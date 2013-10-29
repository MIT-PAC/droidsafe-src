
package droidsafe.speclang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Local;
import soot.Scene;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.jimple.Expr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.spark.pag.AllocNode;
import soot.tagkit.LineNumberTag;
import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.PTAMethodInformation;
import droidsafe.analyses.infoflow.APIInfoKindMapping;
import droidsafe.analyses.infoflow.InfoKind;
import droidsafe.analyses.infoflow.InfoUnit;
import droidsafe.analyses.infoflow.InfoValue;
import droidsafe.analyses.infoflow.InformationFlowAnalysis;
import droidsafe.android.system.API;
import droidsafe.android.system.Permissions;
import droidsafe.main.Config;
import droidsafe.utils.CannotFindMethodException;
import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public class Method implements Comparable<Method> {
	private static final Logger logger = LoggerFactory.getLogger(Method.class);
	
	/** Concrete Soot Method */
	private SootMethod sootMethod;
	/** argument full qualified types */
	private ArgumentValue[] args;
	/** receiver (could be a type or an object reference) */
	private Object receiver;
	/** locations where this method, either a call or a handler appear in source */
	private List<SourceLocationTag> lines;
	/** Points to information for this method call */
	private PTAMethodInformation ptaInfo;

	public Method(SootMethod method, PTAMethodInformation ptaInfo, ArgumentValue[] args, Object receiver) {
		this.sootMethod = method;
		this.args = args;
		this.receiver = receiver;
		lines = new ArrayList<SourceLocationTag>();
		logger.info("Creating method: {} with receiever {}", method, receiver);
		this.ptaInfo = ptaInfo;
	}
	
	
	public SootMethod getSootMethod() {
		return sootMethod;
	}
	
	/**
	 * check to see if these two method objects refer to the same method
	 * even though they have different concrete param values, but only if they
	 * have the same receiver (type or allocnode).
	 * 
	 * @param meth2 the method to check against
	 * @return true if same underlying method that is called.
	 */
	public boolean isSameMethod(Method meth2) {
		if (!meth2.getSootMethod().equals(sootMethod))
			return false;
		if (this.hasReceiver() && meth2.hasReceiver() && !meth2.receiver.equals(this.receiver)) 
			return false;
		if (!this.hasReceiver() && meth2.hasReceiver())
			return false;
		return true;
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
	    logger.info("Calling incorporate method on: {}", meth2);
	    
	    if (!isSameMethod(meth2)) {
		    logger.error("Error: Trying to combine concrete value restrictions on different methods!");
			droidsafe.main.Main.exit(1);
		}
	
		
		for (int i = 0; i < args.length; i++) {
			args[i] = ArgumentValue.combine(args[i], meth2.args[i], getActualArgType(i)); 
		}
		
		//combine the line numbers the method to incorporate and resort them
		for (SourceLocationTag tag: meth2.lines){
			if (!this.lines.contains(tag))
				this.lines.add(tag);
		}
		
		Collections.sort(lines);
	}
	
	/**
	 * Return a set of allocation nodes for possible new expression that can reach receiver of this method.
	 */
	public Set<AllocNode> getReceiverAllocNodes() {
	    if (ptaInfo == null || !ptaInfo.hasReceiver() || !GeoPTA.v().isPointer(ptaInfo.getReceiver()))
	        return new HashSet<AllocNode>();
	    
	    return ptaInfo.getReceiverPTSet();
	}
	
	/**
	 * Return the set of allocation nodes for new expression that could reach the argument i,  
	 * assuming it is a pointer value.  Return empty set of any problems.
	 */
	public Set<AllocNode> getArgAllocNodes(int i) {
	    if (ptaInfo == null || !GeoPTA.v().isPointer(ptaInfo.getArgValue(i)))
	        return new HashSet<AllocNode>();

	    return ptaInfo.getArgPTSet(i);
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
	StringBuilder ret = new StringBuilder();
		
		if (!lines.isEmpty() && !Config.v().noSourceInfo) {
			for (SourceLocationTag line : lines) {
				ret.append("// " + line + "\n");
			}
		}
		
		for (String str : Permissions.v().getPermissions(sootMethod)) 
			ret.append("// Requires permission: " + str + "\n");
		
		//print resolved high-level information flows
		Set<InfoKind> recSourceKinds = getRecInfoKinds();
		Set<InfoKind> sinkKinds = getSinkInfoKinds();
		
		Set<InfoKind> argsSourceKinds = new HashSet<InfoKind>();
		
		for (int i = 0; i < ptaInfo.getNumArgs(); i++)
		    argsSourceKinds.addAll(getArgInfoKinds(i));
		
		if (!recSourceKinds.isEmpty() || !argsSourceKinds.isEmpty() || !sinkKinds.isEmpty()) {
		    ret.append("// InfoFlows: \n");

		    if (hasReceiver()) {
		        ret.append("//    (receiver:");
		        for (InfoKind src : recSourceKinds) 
		            ret.append(" " + src);

		        ret.append(")\n");
		    }
		    
		    ret.append("//    (args:");
		    for (InfoKind src : argsSourceKinds) { 
                ret.append(" " + src);
		    }
		    ret.append(")\n//    (sinks:");
            
		    for (InfoKind sink : sinkKinds)
		        ret.append(" " + sink);
		  
		    ret.append(")\n");
		}
		
		if (flagUnsupported && !API.v().isSupportedMethod(sootMethod))
			ret.append("**");
		
        return ret + toSignatureString();
	}

    /** Return the permissions this method requires **/
    public Set<String> getPermissions() {
      return Permissions.v().getPermissions(sootMethod);
    }
	
    /**
     * Returns the signature portion of the string in security spec format
     * with arg values and not arg types from the soot method
     */
    public String toSignatureString() {
	
        String ret = "";

        if (hasReceiver()) 
			ret += receiver;
        else 
        	ret += getCname();
		
		ret += ": " + getRtype() + " " + this.getName() + "(";
		
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
    public List<SourceLocationTag> getLines() {
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
	
	/**
	 * If this method is defined as a sink method with a high level sink type, 
	 * return the InfoKinds of this method.  Otherwise, return an empty list. 
	 */
	public Set<InfoKind> getSinkInfoKinds() {
	    if (APIInfoKindMapping.v().hasSinkInfoKind(sootMethod)) {
	        return APIInfoKindMapping.v().getSinkInfoKinds(sootMethod);
	    }
	    return new HashSet<InfoKind>();
	}

	/**
	 * Query the information flow analysis for the given value, either the receiver or an argument
	 * of this method call.
	 */
	private Set<InfoValue> queryInfoFlow(Value val) {
	    if (!Config.v().infoFlow || !(val instanceof Local))
            return new HashSet<InfoValue>();
        
        Unit unit = JimpleRelationships.v().getEnclosingStmt(ptaInfo.getInvokeExpr());
        //call the information flow results
        return InformationFlowAnalysis.v().getTaintsBeforeRecursively(ptaInfo.getContextEdge(), unit, (Local)val);
	}
		
	/**
	 * For the receiver of this method, return the set of all api calls in user code that 
	 * could reach the receiver (or one of its fields).
	 */
	public Set<Stmt> getReceiverSourceInfoUnits() {
	    //call the information flow results
	    if (!hasReceiver())
	        return new HashSet<Stmt>();
	                
	    Set<InfoValue> srcs = queryInfoFlow(ptaInfo.getReceiver());
	    	    
	    Set<Stmt> srcSrcs = new HashSet<Stmt>();
	    for (InfoValue iv : srcs) {
	        if (iv instanceof InfoUnit) {
	            InfoUnit srcUnit = (InfoUnit)iv;
	            if (!(srcUnit.getUnit() instanceof Stmt))
	                continue;
	            srcSrcs.add((Stmt)srcUnit.getUnit());
	        }
	    }
	    
	    return srcSrcs;
	}
	
	/**
	 * For argument at i return the set of all api calls in user code that could reach the 
	 * argument (or one of its fields).
	 */
	public Set<Stmt> getArgSourceInfoUnits(int i) {
	    Set<InfoValue> srcs = queryInfoFlow(ptaInfo.getArgValue(i));	    
	    
        Set<Stmt> srcSrcs = new HashSet<Stmt>();
        for (InfoValue iv : srcs) {
            if (iv instanceof InfoUnit) {
                InfoUnit srcUnit = (InfoUnit)iv;
                if (!(srcUnit.getUnit() instanceof Stmt))
                    continue;
                  srcSrcs.add((Stmt)srcUnit.getUnit());
            }
        }
        
        return srcSrcs;
	}
	
	/**
	 * Given a value from the invoke statement (either receiver or an argument), query the 
	 * information flow for the units the flow to it, and then use the PTA to find all the targets
	 * of the source statements to see if any of them have higher level InfoKind associated with them.
	 * Return the set of all InfoKinds for the targets of all sources.
	 */
	private Set<InfoKind> getInfoKinds(Value v) {
	    Set<InfoValue> srcs = queryInfoFlow(v);
        
        Set<InfoKind> srcKinds = new HashSet<InfoKind>();
        for (InfoValue iv : srcs) {
            if (iv instanceof InfoUnit && ((InfoUnit)iv).getUnit() instanceof Stmt) {
                
                Stmt stmt = (Stmt)((InfoUnit)iv).getUnit();
                
                if (!stmt.containsInvokeExpr())
                    continue;
                
                InvokeExpr invoke = stmt.getInvokeExpr();
                //for each of the targets see if they have an Info Kind
                
                try {
                    Collection<SootMethod> targets = 
                            GeoPTA.v().resolveInvokeEventContext(invoke, ptaInfo.getContextEdge());
                    
                    for (SootMethod target : targets) {
                        if (APIInfoKindMapping.v().hasSourceInfoKind(target))
                            srcKinds.addAll(APIInfoKindMapping.v().getSourceInfoKinds(target));
                        else {
                            //unknown info kind, check if a spec or ban method and if so, denote with UNKNOWN kind
                            if (API.v().isInterestingMethod(target)) {
                                srcKinds.add(APIInfoKindMapping.v().SENSITIVE_NOCATEGORY);
                            }
                            
                        }
                    }
                } catch (CannotFindMethodException e) {
                    continue;
                }
            } else if (iv instanceof InfoKind) {
                srcKinds.add((InfoKind)iv);
            }
        }
        
        return srcKinds;
	}

	/**
	 * For argument at i, return the set of high level information kinds that the argument could possibly 
	 * be tainted with.
	 */
	public Set<InfoKind> getArgInfoKinds(int i) {
	    return getInfoKinds(ptaInfo.getArgValue(i));
	}

	/**
	 * For receiver, return the set of high-level information kinds that the receiver could possibly be 
	 * tainted with.	 
	 */
	public Set<InfoKind> getRecInfoKinds() {
	    if (hasReceiver())
	        return getInfoKinds(ptaInfo.getReceiver());
	    else 
	        return new HashSet<InfoKind>();
	}

	/**
	 *  Return the high level InfoKinds for all possible sources (receiver and all args).
	 */
	public Set<InfoKind> getSourcesInfoKinds() {
	    Set<InfoKind> srcKinds = getRecInfoKinds();
	    for (int i = 0; i < ptaInfo.getNumArgs(); i++)
	        srcKinds.addAll(getArgInfoKinds(i));
	    return srcKinds;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(args);
        result = prime * result + ((lines == null) ? 0 : lines.hashCode());
        result = prime * result + ((ptaInfo == null) ? 0 : ptaInfo.hashCode());
        result = prime * result + ((receiver == null) ? 0 : receiver.hashCode());
        result = prime * result + ((sootMethod == null) ? 0 : sootMethod.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Method other = (Method) obj;
        if (!Arrays.equals(args, other.args)) return false;
        if (lines == null) {
            if (other.lines != null) return false;
        } else if (!lines.equals(other.lines)) return false;
        if (ptaInfo == null) {
            if (other.ptaInfo != null) return false;
        } else if (!ptaInfo.equals(other.ptaInfo)) return false;
        if (receiver == null) {
            if (other.receiver != null) return false;
        } else if (!receiver.equals(other.receiver)) return false;
        if (sootMethod == null) {
            if (other.sootMethod != null) return false;
        } else if (!sootMethod.equals(other.sootMethod)) return false;
        return true;
    }


    public void setReceiver(Object rec) {
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

	public Object getReceiver() {
		return receiver;
	}

	public String getRtype() {
		return sootMethod.getReturnType().toString();
	}
	
	public void setArg(int i, ArgumentValue v) {
		args[i] = v;
	}

	public Type getActualArgType(int i) {
		return sootMethod.getParameterType(i);
	}

	/**
	 * Return a string of all the information of this method object: line numbers, receiver and signature.
	 */
	public String toCompleteString() {
	    String ret = "";
        
        if (!lines.isEmpty() && !Config.v().noSourceInfo) {
            for (SourceLocationTag line : lines) {
                ret += "// " + line + "\n";
            }
        }
        
        ret += toSignatureString();
        
        return ret;
	}
	
	/** 
	 * Compare method m to this method.  Right now it puts them in order based on line
	 * number annotation, but if that is not present, it does a lexigraphical order of 
	 * the receiver and method name.
	 */
	public int compareTo (Method m) {
		return this.toCompleteString().compareTo(m.toCompleteString());
	}
}
