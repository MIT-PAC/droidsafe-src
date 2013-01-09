package droidsafe.speclang;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.system.API;
import droidsafe.utils.Utils;

import soot.Scene;


public class SecuritySpecification  {
	private static final Logger logger = LoggerFactory.getLogger(SecuritySpecification.class);
	
	private Set<Method> whitelist;
	private Map<Method, List<Method>> eventBlocks;
	
	public SecuritySpecification() {
		whitelist = new LinkedHashSet<Method>();
		eventBlocks = new LinkedHashMap<Method, List<Method>>();
	}
	
	public void addOutputEventToWhitelist(Method m) {
		whitelist.add(m);
	}
	
	public boolean inWhitelist(Method testMe) {
		for (Method m : whitelist) {
			if (m.isMethodCallEnabled(testMe))
				return true;
		}
		return false;
	}
	
	/**
	 * Add the outputevent's conformance information to the input event, but if the 
	 * output event already exists in the spec, then combine the current output event 
	 * with the stored output event by widening.  Only used for spec dump.
	 */
	public void addToInputEventCombine(Method inputEvent, Method outputEvent) {
		
		if (inputEvent == null || outputEvent == null)
			return;
		
		if (!eventBlocks.containsKey(inputEvent))
			eventBlocks.put(inputEvent, new ArrayList<Method>());
		
		//see if we already have this method (signature) in the input event block
		//it may be the same method but with different concrete allowed args
		Method sameMethod = null;
		for (Method m : eventBlocks.get(inputEvent)) {
			if (m.isSameMethod(outputEvent)) {
				if (sameMethod != null)
					Utils.ERROR_AND_EXIT(logger, "More than one appearance of a method (output event) in event block: {}", inputEvent);
				sameMethod = m;
			}
		}
		
		//if we found the same method, then add any restrictions from the new method to the old
		if (sameMethod != null) 
			sameMethod.incorporateMethod(outputEvent);
		else //otherwise, just add the new method
			eventBlocks.get(inputEvent).add(outputEvent);
	}
	
	/**
	 * Add the outputevent to the input event's api call list.  Error if the outputevent is
	 * already there.
	 */
	public void addToInputEvent(Method inputEvent, Method outputEvent) {
		
		if (inputEvent == null || outputEvent == null)
			return;
		
		if (!eventBlocks.containsKey(inputEvent))
			eventBlocks.put(inputEvent, new ArrayList<Method>());
		
		//should not see multipe output events in same input event in the spec
		for (Method m : eventBlocks.get(inputEvent)) {
			if (m.isSameMethod(outputEvent)) {
				Utils.ERROR_AND_EXIT(logger, "More than one appearance of a method (output event) in event block: {}", inputEvent);
			}
		}

		eventBlocks.get(inputEvent).add(outputEvent);
	}
	
	public void addToInputEvent(Method inputEvent, List<Method> outputEvents) {
		if (inputEvent == null || outputEvents == null)
			return;
		
		if (!eventBlocks.containsKey(inputEvent))
			eventBlocks.put(inputEvent, new ArrayList<Method>());
		
		for (Method m : outputEvents)
			addToInputEvent(inputEvent, m);
	}
	
	/**
	 * Check if the output event is a legal api method call for the input event.
	 * 
	 * @param inputEvent The input event
	 * @param outputEvent The output event
	 * @return true if the input event can trigger the output event given the specification.
	 */
	public boolean isLegalOutputEvent(Method inputEvent, Method outputEvent) {
		if (!eventBlocks.containsKey(inputEvent))
			return false;
		
		for (Method m : eventBlocks.get(inputEvent)) {
			if (m.isMethodCallEnabled(outputEvent)) {
				return true;
			}
		}
		
		return false;
	}
	/*
	private HashSet<Method> allMatchingBlocks(Method inputEvent) {
		HashSet<Method> matching = new HashSet<Method>();
		for (Method m : eventBlocks.keySet()) {
			if (m.isOverridingMethod(inputEvent))
				matching.add(m);
			
		}
		
		return matching;
	
	}
	*/

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("whitelist {\n");
        for (Method m : whitelist) {
        	buf.append("\t" + m.toString() + "\n");
        }
        buf.append("}\n\n");

        List<Method> methods = new ArrayList<Method>(eventBlocks.keySet());
        Collections.sort (methods);
        
        for (Method ie : methods) {
        	SourceLocationTag line = ie.getDeclSourceLocation();
        	if (line != null) {
        		buf.append("// " + line + "\n");
        	}
        	buf.append(ie.toString());
        	buf.append(" {\n");
        	
            List<Method> outm = new ArrayList<Method>(eventBlocks.get(ie));
            Collections.sort (outm);
        	for (Method oe : outm) {
        		buf.append("\t");
        		//print out the method and flag unsupport (true arg to toString())
        		buf.append(oe.toString(true).replaceAll("\n", "\n\t") + ";\n");
        	}
        	
        	buf.append("}\n\n");
        }
        
        return buf.toString();
	}
	
    /** Returns an HTML spec with extra information **/
	public String toHtmlString() {
		StringBuffer buf = new StringBuffer();
		buf.append("<h4>whitelist</h4>\n");
        for (Method m : whitelist) {
        	buf.append(m.toString() + "<br>");
        }
        
        // Sort the methods for consistent output
        List<Method> entry_points = new ArrayList<Method>(eventBlocks.keySet());
        Collections.sort (entry_points);
        
        // Set of all banned methods in the application (sorted, no dups)
        TreeSet<String> all_banned_methods = new TreeSet<String>();

        for (Method ie : entry_points) {
            buf.append("<h4> " + ie.toString().replaceAll("<", "&lt;") 
                       + "</h4>\n");
        	
            // Sort the api calls from this method
            List<Method> outm = new ArrayList<Method>(eventBlocks.get(ie));
            Collections.sort (outm);

            List<String> methods = new ArrayList<String>();
            List<String> banned_methods = new ArrayList<String>();
        	for (Method oe : outm) {
                String msig = "";
        		String dbSig = oe.toDroidBlazeString(true);
        		boolean unsup = !API.v().isSupportedMethod(dbSig);
                if (unsup) {
                  msig += "<b>";
                }
                String txt = oe.toSignatureString().replaceAll ("<", "&lt;");
                msig += API.v().api_xref (dbSig, txt);
                if (unsup) {
                  msig += "</b>";
                  banned_methods.add (dbSig);
                }
                
                String calls 
                  = String.format("<span title='%s'>[%d calls]</span>",
                         source_locations_to_title(oe), oe.get_lines().size());
                methods.add (msig + calls);
        	} 
            for (String m : methods) {
                buf.append (m + "<br>\n");
            }
            Collections.sort (banned_methods);
            if (banned_methods.size() > 0) 
              buf.append ("<br>");
            for (String m : banned_methods) {
                m = m.replaceFirst ("^<", "");
                m = m.replaceFirst (">$", "");
                m = m.replaceAll ("<", "&lt;");
                all_banned_methods.add (m);
                buf.append (m + "<br>\n");
            }
        } 
        buf.append ("\n<p>"+ all_banned_methods.size() +" banned methods<p>\n");
        for (String m : all_banned_methods)
          buf.append (m + "<br>\n");
        return buf.toString();
	}

  public String source_locations_to_title (Method m) {

    Map<String,String> classmap = new LinkedHashMap<String,String>();

    // Create a map from each class to all of the lines in that class
    List<SourceLocationTag> locs = m.get_lines();
    for (SourceLocationTag loc : locs) {
      String l = classmap.get (loc.getClz());
      if (l == null)
        classmap.put (loc.getClz(), "" + loc.getLine());
      else {
        classmap.put (loc.getClz(), l + ", " + loc.getLine());
      }
    }

    String out = "";
    for (String clz : classmap.keySet()) {
      out += clz + ":" + classmap.get(clz) + "&#10;";
    }

    return out;
  }
      
    

	public String toReadableString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Security Specification\n\n");
        buf.append("whitelist:\n");
        for (Method m : whitelist) {
        	buf.append("\t" + m.toString() + "\n");
        }
        buf.append("\n");
        
        
        for (Method ie : eventBlocks.keySet()) {
        	buf.append("Action\n");
        	buf.append("\tInput Event: " + ie.toString() + "\n");
        	
        	buf.append("\tOutput Events:\n");
        	for (Method oe : eventBlocks.get(ie)) {
            	buf.append("\t\t" + oe.toString() + "\n");
        	}
        	
            buf.append("\n");
        }

        buf.append("\n");
        return buf.toString();
	}
	
    public boolean printXML(PrintWriter out) {
		out.println("<secspec>");
        out.println("<whitelist>");
        for (Method m : whitelist) {
        	out.println(m.toXML());
        }
        out.println("</whitelist>");
        
        
        for (Method ie : eventBlocks.keySet()) {
        	out.println("<action>");
        	out.println("<inputevent>");
        	out.println(ie.toXML());
        	out.println("</inputevent>");
        	for (Method oe : eventBlocks.get(ie)) {
        		out.println("<outputevent>");
            	out.println(oe.toXML());
            	out.println("</outputevent>");
        	}
        	
            out.println("</action>");
        }

        
        out.println("</secspec>");
        return true;
    }
    
    /**
	 * Parse a method that are in the format an api from the spec into 
	 * a Method object. 
	 */
	public static Method parseSpecMethod(String meth) {
		try {
			CharStream input = new ANTLRStringStream(meth);
			DroidSafeLexer lexer = new DroidSafeLexer(input);

			CommonTokenStream tokens = new CommonTokenStream(lexer);

			DroidSafeParser parser = new DroidSafeParser(tokens);

			DroidSafeParser.api_call_return method = parser.api_call();

			CommonTree t = (CommonTree)method.getTree();

			//System.out.println(t.toStringTree());

			CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
			SpecCreator specCreator = new SpecCreator(nodes);
			specCreator.setSingleMethodParse();
			
			return specCreator.api_call();
		} catch (Exception e) {
			logger.error("Error while parsing spec method from Action: " + meth);
			System.exit(1);
		}
		return null;
	}
	
	/**
	 * Parse a methods that are in the format an api from the spec into 
	 * a Method object. 
	 */
	public static List<Method> parseSpecMethods(List<String> strs) {
		LinkedList<Method> methods = new LinkedList<Method>();
		
		for (String str : strs) {
			Method m = parseSpecMethod(str);
			methods.add(m);
		}
		
		return methods;
	}
}
