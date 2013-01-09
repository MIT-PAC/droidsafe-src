
package droidsafe.speclang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.tagkit.LineNumberTag;

import droidsafe.speclang.SourceLocationTag;
import droidsafe.utils.Utils;
import droidsafe.android.system.API;

public class Method implements Comparable<Method> {
	private static final Logger logger = LoggerFactory.getLogger(Method.class);
	
	
	/** full qualified class name */
	private String cname;
	/** fully qualified class name of the uppermost superclass that defines this method */
	private String upperMostCName;
	/** name of method */
	private String methName;
	/** argument full qualified types */
	private ArgumentValue[] args;
	/** receiver (could be a type or an object reference) */
	private String receiver;
	/** return type */
	private String rtype;
	/** locations where this method, either a call or a handler appear in source */
	private List<SourceLocationTag> lines;

	
	/**
	 * check to see if these two method objects refer to the same method
	 * even though they have different concrete param values.
	 * 
	 * @param meth2 the method to check against
	 * @return true if same underlying method that is called.
	 */
	public boolean isSameMethod(Method meth2) {
		if (!cname.equals(meth2.cname) || !methName.equals(meth2.methName) ||
				!receiver.equals(meth2.receiver)) {	
			return false;
		}
		
		//check all the args for the same underlying type
		if (args.length != meth2.args.length)
			return false;
		for (int i = 0; i < args.length; i++) {
			if (!args[i].getType().equals(meth2.args[i].getType())) {
				return false;
			}
		}
				
		return true;
	}
	
	/**
 	 * Change the types of the arguments to argee with the parameter method
	 */
	public void setTypes(SootMethod method) {
		if (!(method.getSubSignature().equals(this.getSubSignature()))) {
			for (int i = 0; i < this.args.length; i++) {
				this.args[i].setType(method.getParameterType(i));
			}
		}
	}
	
	/**
	 * Add a line number tag to this method remembering where it was called 
	 * or defined. 
	 */
	public void addLineTag(SourceLocationTag tag) {
		if (!lines.contains(tag))
			lines.add(tag);
	}
	
	/**
	 * Return true if this method call enables the given method.  Meanings its restrictions
	 * are a superset of the given method.  Right now this means that we check all the concrete 
	 * values of the given method to see if they are enabled by this method.
	 */
	public boolean isMethodCallEnabled(Method testMe) {
		if (!isSameMethod(testMe)) {
			//Messages.log(String.format("%s != %s\n", toSignatureString(), testMe.toSignatureString()));
			return false;
		}
		//loop through all the args of testme to see if they are enabled by this method
		for (int i = 0; i < testMe.args.length; i++) {
			//only check if the spec method (this) defined concrete values
			if (this.args[i].isConcreteList()) {
				if (!testMe.args[i].isConcreteList())
					return false;
				
				if (!((ConcreteListArgumentValue)args[i]).doesEnable((ConcreteListArgumentValue)testMe.args[i]))
					return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * For all arguments of the method, add the method argument restrictions from meth2
	 * into the method argument values of this method. 
	 * 
	 * @param meth2
	 */
	public void incorporateMethod(Method meth2) {
		if (!isSameMethod(meth2))
			Utils.ERROR_AND_EXIT(logger,"Error: Trying to combine concrete value restrictions on different methods!");
		
		for (int i = 0; i < args.length; i++) {
			args[i] = ArgumentValue.combine(args[i], meth2.args[i]); 
		}
		
		//combine the line numbers the method to incorporate and resort them
		for (SourceLocationTag tag: meth2.lines){
			if (!this.lines.contains(tag))
				this.lines.add(tag);
		}
		
		Collections.sort(lines);
	}
	
	/**
	 * Create a method without a receiver
	 * 
	 * @param cname the fully qualified class name
	 * @param name the name of the method
	 * @param args the arguments of the method
	 * @param receiver the string of the receiver (either a class or object id)
	 */
	public Method(String cname, String rtype, String name, ArgumentValue[] args, String receiver) {
		this.cname = cname;
		this.upperMostCName = cname;
		this.methName = name;
		this.args = args;
		this.receiver = receiver;
		this.rtype = rtype;
		this.lines = new ArrayList<SourceLocationTag>();
		setUpperMostMethod();
	}

	/**
	 * Create a method without a receiver
	 * 
	 * @param cname the fully qualified class name
	 * @param name the name of the method
	 * @param args the arguments of the method
	 */
	public Method(String cname, String rtype, String name, ArgumentValue[] args) {
		this(cname, rtype, name, args, "");
	}
	
	/**
	 * Create a new method from a droidblaze method signature.
	 * 
	 * @param dbSig The droidblaze method signature string
	 */
	public Method(String dbSig) {
		//<android.media.MediaRecorder: void setOutputFile(java.lang.String)>
		Pattern sigRE = Pattern.compile("<(\\S+): (\\S+) (\\S+)\\((.*)\\)>");
		Matcher matcher = sigRE.matcher(dbSig);
		boolean b = matcher.matches();
		
		if (!b && matcher.groupCount() != 4)
			Utils.ERROR_AND_EXIT(logger,"Cannot create Method from DroidBlaze Signature");
		
		//class
		String cname = matcher.group(1);
		//return-type
		String rtype = matcher.group(2);
		//name
		String name = matcher.group(3);
		//args, create the args string array
		String args = matcher.group(4);
		StringTokenizer st = new StringTokenizer(args, ",");
		
		ArgumentValue[] argsArr = new ArgumentValue[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			argsArr[i++] = new TypeValue(st.nextToken());
		}
		
		this.cname = cname;
		this.upperMostCName = cname;
		this.args = argsArr;
		this.methName = name;
		this.rtype = rtype;
		this.lines = new ArrayList<SourceLocationTag>();
		this.receiver = "";
		
		setUpperMostMethod();
	}
	
	public boolean hasReceiver() {
		return !receiver.equals("");			
	}

	/**
	 * Return a string representation of the method that matches the format used 
	 * for methods in DroidBlaze.  Used for conformance checking.
	 * 
	 * @param useUpperMost if true, return the signature for the uppermost super definition
	 * this method.
	 * 
	 * @return DroidBlaze String representation of method
	 */
	public String toDroidBlazeString(boolean useUpperMost) {
		String ret = "<";
		
		if (hasReceiver()) 
			ret += "#" + receiver + "#";
		
		ret += useUpperMost ? upperMostCName : cname; 
		ret += ": " + rtype + " " + methName + "(";
		
		for (int i = 0; i < args.length; i++) {
          if (i > 0)
            ret += ",";
          ret += args[i].getType();
		}
		
		return ret + ")>";
	}
	
	/**
	 * Return the method in Soot's Subsignature format.
	 */
	public String getSubSignature() {
		String ret = rtype + " " + methName + "(";
		
		for (int i = 0; i < args.length; i++) {
          if (i > 0)
            ret += ",";
          ret += args[i].getType();
		}
		
		return ret + ")";
	}
	
	/**
	 * Return the signature for the method in Soot format. 
	 */
	public String getSignature(boolean useUpperMost) {
		return  "<" + (useUpperMost ? upperMostCName : cname) + ": " + getSubSignature() + ">";
	}
	
	/**
	 * Return a string that conforms to the security specification language.
	 */
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean flagUnsupported) {
	String ret = "";
		
		if (!lines.isEmpty()) {
			for (SourceLocationTag line : lines) {
				ret += "// " + line + "\n";
			}
		}
		
		if (flagUnsupported && !API.v().isSupportedMethod(this.getSignature(true)))
			ret += "**";
		
        return ret + toSignatureString();
	}
	
    /**
     * Returns the signature portion of the string in security spec format
     */
    public String toSignatureString() {
	
        String ret = "";

        if (hasReceiver()) 
			ret += receiver + " ";
		
		ret += cname + ": " + rtype + " " + methName + "(";
		
		for (int i = 0; i < args.length; i++) {
          if (i > 0)
            ret += ", ";
          ret += args[i].toString();
		}
		
		return ret + ")";
    }

    /**
     * Returns the lines that contain calls to this method
     */
    public List<SourceLocationTag> get_lines() {
      return lines;
    }

	public String toXML() {
		String ret = "<method name=\"" + methName + "\" class=\"" + 
				cname + "\" rtype=\"" + rtype +  "\" receiver=\"" + receiver + "\">\n"; 
		
		for (ArgumentValue arg : args)
			ret += "<arg type = \"" + arg + "\"/>";
		
		ret += "</method>";
		
		return ret;
	}
	
	/**
	 * Given the string representation for the this object from PTA, 
	 * be more specific with the class of the method if possible.
	 * 
	 * @param alloc 
	 */
	public void processPTAInfo(String alloc) {
		Pattern re = Pattern.compile("AllocNode (\\d+) new (\\S+) (.*)");
		Matcher matcher = re.matcher(alloc);
		
		//if a match, set the class name to the class of the allocation
		if (matcher.matches()) {
			//System.out.println("Could not match: " + thisArg);
			upperMostCName = cname;
			cname = matcher.group(2);	
			return;
		}
		
		re = Pattern.compile("Fail Safe Node of (\\S+)");
		matcher = re.matcher(alloc);
		
		//if a match, set the class name to the class of the allocation
		if (matcher.matches()) {
			//System.out.println("Could not match: " + thisArg);
			upperMostCName = cname;
			cname = matcher.group(1);
			return;
		}
	}
	
	/**
	 * Try to find the line number of the declaration of this method.
	 * Must be using byte code and not dex file conversion.
	 */
	public SourceLocationTag getDeclSourceLocation() {
		
		//check to see if this method is defined, if not, return null
		if (!Scene.v().containsMethod(getSignature(false)))
			return null;
		
		SootMethod method = Scene.v().getMethod(getSignature(false));
		
		if (!method.hasActiveBody())
			return null;
		
		LineNumberTag line = (LineNumberTag)method.getActiveBody().getUnits().getFirst().getTag("LineNumberTag");
		if (line == null) {
			return null;
		}
		return new SourceLocationTag(method.getDeclaringClass().getName(), line.getLineNumber());
	}
	
	/**
	 * Check if the method is valid to appear in the body (block) of an event block.
	 * Since an API callback can be overriden, we have to check the superclasses.
	 * 
	 * @return
	 */
	public boolean checkValidSpecMethod() {
		return API.v().isSupportedMethod(this.getSignature(false));
	}
	
	private void setUpperMostMethod() {
		SootClass clazz = Scene.v().getSootClass(cname);
		
    	while (clazz != null) {
    		if (clazz.declaresMethod(this.getSubSignature())) {
    			this.setUpperMostCName(clazz.getName());
    		}
    		
    		if (clazz.hasSuperclass())
    			clazz = clazz.getSuperclass();
    		else
    			clazz = null;
    	}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(args);
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((methName == null) ? 0 : methName.hashCode());
		result = prime * result
				+ ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result + ((rtype == null) ? 0 : rtype.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Method other = (Method) obj;
		if (!Arrays.equals(args, other.args))
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (methName == null) {
			if (other.methName != null)
				return false;
		} else if (!methName.equals(other.methName))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (rtype == null) {
			if (other.rtype != null)
				return false;
		} else if (!rtype.equals(other.rtype))
			return false;
		return true;
	}

	public void setReceiver(String rec) {
		this.receiver = rec;
	}
	
	public String getCname() {
		return cname;
	}

	public String getName() {
		return methName;
	}

	public ArgumentValue[] getArgs() {
		return args;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getRtype() {
		return rtype;
	}
	
	public void setArg(int i, ArgumentValue v) {
		args[i] = v;
	}
	
	public void setCName(String cname) {
		this.cname = cname;
	}
	
	public void setUpperMostCName(String str) {
		this.upperMostCName = str;
	}
	
	public String getUpperMostCName() {
		return upperMostCName;
	}

	/** Sort by class and method name **/
	public int compareTo (Method m) {
		//if both method have lines, then compare them on lines
		if (!this.lines.isEmpty() && !m.lines.isEmpty()) {
			return this.lines.get(0).compareTo(m.lines.get(0));
		}

		//otherwise, compare them on class name then arg
		String str1 = cname + " " + methName;
		for (ArgumentValue arg : args)
			str1 += " " + args.toString();
		
		String str2 = m.cname + " " + m.methName;
		for (ArgumentValue arg : m.args)
			str2 += " " + args.toString();
		return str1.compareTo(str2);
	}
}
