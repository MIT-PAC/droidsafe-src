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
import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;

import soot.Scene;


public class SecuritySpecification  {
	private static final Logger logger = LoggerFactory.getLogger(SecuritySpecification.class);
	
	private Set<Method> whitelist;
	private Map<Method, List<Method>> eventBlocks;
    private static int popup_id = 0;
    private boolean jquery = true;
    private boolean jquery_mobile = false;
    String ANDROID_API_BASE = "http://developer.android.com/reference";
    String JAVA_API_BASE = "http://docs.oracle.com/javase/6/docs/api";
    String TARGET = "iframe_content";
	
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
	 * Add the outputevent's conformance information to the input event, but if one of the 
	 * output event already exists in the spec, then combine the current output event 
	 * with the stored output event by widening. 
	 */
	public void addToInputEventCombine(Method inputEvent, List<Method> oes) {
		for (Method oe : oes) {
			addToInputEventCombine(inputEvent, oe);
		}
	}
	
	/**
	 * Add the outputevent's conformance information to the input event, but if the 
	 * output event already exists in the spec, then combine the current output event 
	 * with the stored output event by widening. 
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
	public String orig_toHtmlString() {
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
        		String dbSig = oe.getSignature();
        		boolean unsup = !API.v().isSupportedMethod(oe.getSootMethod());
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
  
    /** Returns a commented out initial whitelist containing all calls **/
    // public String toWhitelistString() {}

    /** Returns an HTML spec with extra information **/
	public String toHtmlString() {
		StringBuffer buf = new StringBuffer();
        buf.append (jquery_header());

        // initialize the columns 
        buf.append ("<div class=grid>");
        buf.append ("<div class=col1>");
        buf.append ("<h1> SpecDump </h1>");
        buf.append ("<div style='padding-left:0px'>");
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
            buf.append (html_entry_point (ie));

            buf.append ("<div style='padding-left:15px'>\n");

            // Sort the api calls from this method
            List<Method> outm = new ArrayList<Method>(eventBlocks.get(ie));
            Collections.sort (outm);

            List<String> methods = new ArrayList<String>();
            List<String> banned_methods = new ArrayList<String>();

            // Determine the set of descriptors for all of the methods
            Set<String> all_descrs = new LinkedHashSet<String>();
        	for (Method oe : outm) { 
              all_descrs.addAll (api_descriptors (oe));
        	} 
            List<String> all_descrs_sorted = new ArrayList<String>();
            all_descrs_sorted.addAll (all_descrs);
            Collections.sort (all_descrs_sorted);

            // Loop through each descriptor and print the methods for each
            for (String descr : all_descrs_sorted) {
              String mstr = "";
              int danger = -100;
              int dcnt = 0;
              for (Method oe : outm) { 
                if (api_descriptors (oe).contains (descr)) {
                  dcnt++;
                  mstr +=  html_api_call (oe, ie);
                  int d = api_danger(oe);
                  if (d > danger)
                    danger = d;
                }
              } 
              String style = "";
              if (danger > 0)
                style = "color:red";
              else if (danger < 0)
                style = "color:green";
              descr = String.format ("<span style='%s'>%s</span>", style, 
                                     descr);
              String cnt = String.format (" (<span class=count>%d</span>)", 
                                          dcnt);
              buf.append ("<h4> Descriptor " + descr + cnt + "</h4>\n");
              buf.append ("<div style='padding-left:15px'>\n");
              buf.append (mstr);
              buf.append ("</div>\n");
            }
            Collections.sort (banned_methods);
            if (false) {
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
            buf.append ("\n</div>\n");
        } 
        buf.append ("\n<p>"+ all_banned_methods.size() +" banned methods<p>\n");
        for (String m : all_banned_methods)
          buf.append (m + "<br>\n");

        // Terminate the overall div and the columns
        buf.append ("</div>"  // specdump div
                    + "</div>\n"  // column 1 div
                    + "<div class=col2 id=content>\n"
                    + "<iframe name=iframe_content height=195px width=100%>\n"
                    + "</iframe>\n"
                    + "</div>\n" // column2 div
                    + "</div>\n" // overall div
                    );

        return buf.toString();
    }

  /** Header for JQuery **/
  public String jquery_header () {
    return "<!DOCTYPE html>\n"
      + "<html>\n"
      + "<head>\n"
      + "<title>Spec</title>\n"
      + "<script src='http://people.csail.mit.edu/jhp/jquery.js'></script>\n"
      + "<script src='http://people.csail.mit.edu/jhp/utils.js'></script>\n"
      + "<script src='http://code.jquery.com/ui/1.10.0/jquery-ui.js'></script>\n"
      + "<script src='../spec.js'></script>"
      + "<link rel='stylesheet' href='http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css' />\n"
      + "<link rel='stylesheet' href='http://people.csail.mit.edu/jhp/specdump.css' />\n"
      + "<style> a {text-decoration:none} h4 {margin-top:0px;margin-bottom:0px;} </style>\n"
      + "</head>\n"
      + "<body>\n"
      ;
  }

  /** Header for JQueryMobile **/
  public String jquerymobile_header(String title) {

    return "<!DOCTYPE html>\n"
      + "<html>\n"
      + "<head>\n"
      + "<title>Spec</title>\n"
      + "<meta name''viewport' content='width=device-width, initial-scale=1'>\n"
      + "<link rel='stylesheet' href='http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.css' />\n"
      + "<script src='http://code.jquery.com/jquery-1.8.2.min.js'></script>\n"
      + "<script src='http://code.jquery.com/mobile/1.2.0/jquery.mobile-1.2.0.min.js'></script>\n"
      + "</head>\n"
      + "<body>\n"
      + "<div data-role='page'>\n"
      + "<div data-role='header'>\n"
	  + "<h1>" + title + "</h1>\n"
      + "</div><!-- /header -->\n";

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

  /** 
   * Returns the relative path from the android diretory to the source html
   * created by java2html
   */
  public String app_source_path (String app_class) {

    // change package separator (.) into path separator (/)
    String filename = app_class.replace (".", "/");

    // Remove any internal classes from the name
    filename = filename.replaceFirst ("[$][0-9]+", "");
    if (filename.indexOf("$") > 0) { 
    	filename = filename.substring(0, filename.indexOf("$"));
    }
    
    return "../jsrc/" +  filename + ".java.html";
  }
      
  /**
   * Returns cross references for each line where m is called in the 
   * application.  Each cross reference is on a separate line
   */
  public String source_locations_xref (Method m) {

    String out = "";

    List<SourceLocationTag> locs = m.get_lines();
    for (SourceLocationTag loc : locs) {
      String cname = loc.getClz();
      int line = loc.getLine();
      out += String.format ("<a href=%s#%d class=code target=%s> %s:%d</a><br>",
                            app_source_path (cname), line, TARGET, cname, line);
    }
    return out;
  }
      
  public String get_entry_location (Method m) {
    SourceLocationTag tag = m.getDeclSourceLocation();    
    return tag.toString();
  }
    
  /** Return the terminal classname from a fully specified classname **/
  public String extract_classname (String fullname) {
    return fullname.replaceFirst ("^.*[.]", "");
  }

  /** Return the package name from a fully specified classname **/
  public String extract_package (String fullname) {
    return fullname.replaceFirst ("[.][^.]*$", "");
  }

  /** Create HTML for some text that has both a popup and a cross ref **/
  public String html_tooltip_xref (String txt, String popup_txt, String attrs,
                                   String xref) {

      String out = String.format 
        ("<a title='%s' target='%s' %s href=%s>%s</a>", 
         popup_txt, TARGET, attrs, xref, txt);
      return out;
  }

  /** Create a popup for short_txt that will display poup_txt **/
  public String html_popup (String short_txt, String popup_txt, 
                            String popup_title) {

    String popup = String.format 
      ("<div class='hide' id=popup%d title='%s'>%s</div>\n",
       popup_id, popup_title, popup_txt);

    String txt = String.format ("<a class=popup href=popup id=uppop%d>%s</a>",
                                popup_id++, short_txt);

    return txt + "\n" + popup;
  }

  /** Create HTMl for some text and a popup **/
  public String html_tooltip (String short_txt, String popup_txt) {

    String out = "";
    if (jquery) {
      out = String.format ("<div title='%s'>%s</div>", popup_txt, short_txt);
    } else if (jquery_mobile) {
      String popup = String.format ("<div data-role=popup id=popup%d>\n"
                                    + "  <p>%s</p>\n"
                                    + "</div>\n",
                                    popup_id, popup_txt);

      String txt = String.format ("<a href=#popup%d data-rel=popup>%s</a>",
                                  popup_id++, short_txt);
      out = popup + txt;
    }

    return out;
  }
  
  /** 
   * Returns a simple text version of the short signature (one with
   * unqualified classnames and constant values
   */
  public String short_sig (Method m) {

    String out = extract_classname (m.getCname()) + " " 
      + m.getName().replace ("<init>", "_init_") + " (";

    String delim = "";
    for (ArgumentValue arg : m.getArgs()) {
      out += delim;
      if (arg.isType()) {
        out += extract_classname (arg.toString());
      } else { // constant of some sort
        out += arg.toString();
      }
      delim = ", ";
    }

    return out + ")";
  }

  /**
   * Returns the HTML for an API call.  The source line numbers for each
   * call are included as an expandable box
   */
  public String html_api_call (Method m, Method event) {

    String out = String.format ("<h5 api='%s|%s'>", short_sig (m), 
                                short_sig(event));
    String full_cname = m.getCname();
    String method_name = m.getName().replaceAll("<", "&lt;") + " ";
    String txt = String.format ("<span style='%s' title='%s'>%s</span>", 
                                "color:green", full_cname,
                                extract_classname (full_cname));
    txt += " " + method_name;
    String dbSig = m.getSignature();
    out += api_xref (dbSig, txt);
    txt = "(";
    String delim = "";
    for (ArgumentValue arg : m.getArgs()) {
      txt += delim;
      if (arg.isType()) {
        String full_arg_cname = arg.toString();
        txt += String.format 
          ("<a href='%s/%s.html' target=%s title='%s'><span style='%s'>%s</span></a>",
           ANDROID_API_BASE, 
           full_arg_cname.replace (".", "/").replace("$", "."), TARGET,
           full_arg_cname, "color:green", extract_classname (full_arg_cname));
      } else {
        txt += arg.toString();
      }
      delim = ", ";
    }
    txt += ")";
    out += txt + "</h5>";
    out += "<div style='padding-left:15px' class=calls>";
    out += source_locations_xref(m);
    out += "</div>";
    if (false) {
      String call_txt = String.format ("[%d call%s]", m.get_lines().size(),
                                       (m.get_lines().size() == 1) ? "" : "s");
      String calls = html_popup (call_txt, source_locations_xref(m), "calls");
    }
    return (out + "\n");
  }

  public String api_xref (String method_sig, String txt) {
    String sig = method_sig.replace ("<", "");
    sig = sig.replace (">", "");
    String[] sa = sig.split (":* ");
    String class_name = sa[0].replace (".", "/");
    String ret_type = sa[1];
    String method = sa[2].replaceAll (", *", ", ");
    String base = ANDROID_API_BASE;
    if (class_name.startsWith ("java"))
      base = JAVA_API_BASE;
    return String.format 
      ("<a href='%s/%s.html#%s' target=%s>%s</a>", 
       base, class_name, method, TARGET, txt);
  }


  /** Returns the HTML for an entry point **/
  public String html_entry_point (Method m) {

    // + "(" + get_entry_location(ie) + ")</h4>\n");

    String out = "";

    // Jquery version
    if (jquery) {
      out = "<h3>";
      String full_cname = m.getCname();

      String src_path = full_cname.replace(".", "/");                        
      src_path = src_path.replaceFirst ("[$][0-9]+", "");
      if (src_path.indexOf("$") > 0) { 
      	src_path = src_path.substring(0, src_path.indexOf("$"));
      }
      src_path = "jsrc/" +  src_path + ".java.html";
      if (m.getDeclSourceLocation() != null)
    	  src_path += "#" + m.getDeclSourceLocation().getLine();
      out += html_tooltip_xref (extract_classname (full_cname), 
                           full_cname, "class=code", "../" + src_path) + ": ";
    
      out += m.getName().replaceAll("<", "&lt;") + " ";

      out += "()";
      ArgumentValue[] args = m.getArgs();
      out += "</h3>\n";

    // jquerymobile version
    } else if (jquery_mobile) {
      out = "<div data-role=collapsible data-collapsed=false><h3>";
      String full_cname = m.getCname();
      out += html_tooltip (extract_classname (full_cname), full_cname) + ": ";

      out += m.getName().replaceAll("<", "&lt;") + " ";

      out += "()";
      ArgumentValue[] args = m.getArgs();
      out += "</h3>\n</div>\n";
    }

    return out;

  }

  public String collapsible_header (String header, String text) {

    return String.format ("<div data-role=collapsible data-collapsed=false>"
                          + "<%s>%s</%s>\n", header, text);
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

  /** 
   * Returns the relative dangerousness of the API.  0 is average,
   * Negative numbers are safer, positive numbers are more dangerous.
   */
  public int api_danger (Method m) {
    
    int danger = 0;
    String cname = m.getCname();
    String sig = m.getSignature();
    String perms = api_descriptors(m).toString();

    if (perms.contains ("intent"))
      danger++;
    if (perms.contains ("permission"))
      danger++;
    if (perms.contains ("reflect") || perms.contains("thread") 
        || perms.contains ("loader"))
      danger++;

    if ((danger == 0) && (perms.contains("gui")))
      danger--;

    return danger;
  }

  /** Returns a set of descriptors for each method **/
  public Set<String> api_descriptors (Method m) {

    Set<String> apid = new LinkedHashSet<String>();
    apid.addAll (m.getPermissions());
    String cname = m.getCname();
    String sig = m.getSignature();

    if (cname.startsWith ("java")) {
      if (cname.contains ("reflect"))
        apid.add ("java.reflection");
      else if (cname.contains(".io") || cname.contains (".nio"))
        apid.add ("java.io");
      else if (cname.contains (".net"))
        apid.add ("java.net");
      else if (cname.contains (".rmi"))
        apid.add ("java.rmi");
      else if (cname.contains ("Thread") || cname.contains ("Runnable") 
               || (cname.contains ("Process")))
        apid.add ("java.thread");
      else if (cname.contains ("Loader"))
        apid.add ("java.classloader");
    } else if (cname.startsWith ("android")) {
      // Anything that is in the Intent class or passed an intent
      if (sig.contains ("Intent"))
        apid.add ("android.intent");
      if (cname.contains ("opengl"))
        apid.add ("android.gui");
    }

    if (apid.size() == 0)
      apid.add ("misc");

    return apid;
  }
         
      
}
