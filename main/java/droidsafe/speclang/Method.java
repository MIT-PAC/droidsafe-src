
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

import droidsafe.utils.SourceLocationTag;
import droidsafe.utils.Utils;
import droidsafe.android.system.API;

public class Method implements Comparable<Method> {
	private static final Logger logger = LoggerFactory.getLogger(Method.class);
	
	/** Concrete Soot Method */
	private SootMethod sootMethod;
	/** argument full qualified types */
	private ArgumentValue[] args;
	/** receiver (could be a type or an object reference) */
	private String receiver;
	/** locations where this method, either a call or a handler appear in source */
	private List<SourceLocationTag> lines;

	public Method(SootMethod method, ArgumentValue[] args, String receiver) {
		this.sootMethod = method;
		this.args = args;
		this.receiver = receiver;
		lines = new ArrayList<SourceLocationTag>();
	}
	
	public Method(SootMethod method) {
		this.sootMethod = method;
		
		//create argument list from types of method
		ArgumentValue[] argTypes = new ArgumentValue[sootMethod.getParameterCount()];
		for (int i = 0; i < argTypes.length; i++) {
			argTypes[i] = new TypeValue(sootMethod.getParameterType(i));
		}
		
		this.args = argTypes;
		setTypes();
		this.receiver = null;
		
		lines = new ArrayList<SourceLocationTag>();
	}
	
	public SootMethod getSootMethod() {
		return sootMethod;
	}
	
	/**
	 * check to see if these two method objects refer to the same method
	 * even though they have different concrete param values.
	 * 
	 * @param meth2 the method to check against
	 * @return true if same underlying method that is called.
	 */
	public boolean isSameMethod(Method meth2) {
		return meth2.getSootMethod().equals(sootMethod);
	}
	
	/**
 	 * Change the types of the arguments to agree with the underlying soot method
	 */
	public void setTypes() {
		if (!(sootMethod.getSubSignature().equals(this.getSubSignature()))) {
			for (int i = 0; i < this.args.length; i++) {
				this.args[i].setType(sootMethod.getParameterType(i));
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
		
		logger.info("Calling incorporate method on: {}", meth2);
		
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
	 * Create a new method from a soot method signature.
	 * 
	 * @param sootSig The soot method signature string
	 */
	public Method(String sootSig) {
		//<android.media.MediaRecorder: void setOutputFile(java.lang.String)>
		Pattern sigRE = Pattern.compile("<(\\S+): (\\S+) (\\S+)\\((.*)\\)>");
		Matcher matcher = sigRE.matcher(sootSig);
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
		
		/*
		this.cname = cname;
		this.upperMostCName = cname;
		this.args = argsArr;
		this.methName = name;
		this.rtype = rtype;
		this.lines = new ArrayList<SourceLocationTag>();
		this.receiver = "";
		*/
	}
	
	public boolean hasReceiver() {
		return receiver != null && !receiver.equals("");			
	}
	
	/**
	 * Return the method in Soot's Subsignature format.
	 */
	public String getSubSignature() {
		return sootMethod.getSubSignature();
	}
	
	/**
	 * Return the signature for the method in Soot format. 
	 */
	public String getSignature() {
		return  sootMethod.getSignature();
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
		
		if (flagUnsupported && !API.v().isSupportedMethod(sootMethod))
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
		
		ret += getCname() + ": " + getRtype() + " " + this.getName() + "(";
		
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
		String ret = "<method name=\"" + getName() + "\" class=\"" + 
				getCname() + "\" rtype=\"" + getRtype() +  "\" receiver=\"" + receiver + "\">\n"; 
		
		for (ArgumentValue arg : args)
			ret += "<arg type = \"" + arg + "\"/>";
		
		ret += "</method>";
		
		return ret;
	}
	
	/**
	 * Try to find the line number of the declaration of this method.
	 * Must be using byte code and not dex file conversion.
	 */
	public SourceLocationTag getDeclSourceLocation() {
		
		//check to see if this method is defined, if not, return null
		if (!Scene.v().containsMethod(getSignature()))
			return null;
		
		SootMethod method = Scene.v().getMethod(getSignature());
		
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
		return API.v().isSupportedMethod(sootMethod);
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(args);
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
		result = prime * result
				+ ((receiver == null) ? 0 : receiver.hashCode());
		result = prime * result
				+ ((sootMethod == null) ? 0 : sootMethod.hashCode());
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
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		if (receiver == null) {
			if (other.receiver != null)
				return false;
		} else if (!receiver.equals(other.receiver))
			return false;
		if (sootMethod == null) {
			if (other.sootMethod != null)
				return false;
		} else if (!sootMethod.equals(other.sootMethod))
			return false;
		return true;
	}

	public void setReceiver(String rec) {
		this.receiver = rec;
	}
	
	public String getCname() {
		return sootMethod.getDeclaringClass().getName();
	}

	public String getName() {
		return sootMethod.getName();
	}

	public ArgumentValue[] getArgs() {
		return args;
	}

	public String getReceiver() {
		return receiver;
	}

	public String getRtype() {
		return sootMethod.getReturnType().toString();
	}
	
	public void setArg(int i, ArgumentValue v) {
		args[i] = v;
	}
	

	/** Sort by class and method name **/
	public int compareTo (Method m) {
		//if both method have lines, then compare them on lines
		if (!this.lines.isEmpty() && !m.lines.isEmpty()) {
			return this.lines.get(0).compareTo(m.lines.get(0));
		}

		//otherwise, compare them on class name then arg
		String str1 = getCname() + " " + getName();
		for (ArgumentValue arg : args)
			str1 += " " + args.toString();
		
		String str2 = m.getCname() + " " + m.getName();
		for (ArgumentValue arg : m.args)
			str2 += " " + args.toString();
		return str1.compareTo(str2);
	}
}
