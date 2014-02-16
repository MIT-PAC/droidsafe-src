package droidsafe.analyses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.Context;
import soot.IntType;
import soot.Type;
import soot.Value;
import soot.jimple.ClassConstant;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.StringConstant;
import soot.jimple.toolkits.pta.IAllocNode;
import soot.jimple.toolkits.pta.IStringConstantNode;
import soot.jimple.toolkits.pta.IClassConstantNode;
import droidsafe.analyses.pta.PTAMethodInformation;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.analyses.strings.JSAStrings;
import droidsafe.analyses.value.ValueAnalysis;
import droidsafe.android.app.Project;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.BooleanValue;
import droidsafe.speclang.ByteValue;
import droidsafe.speclang.CharValue;
import droidsafe.speclang.ClassValue;
import droidsafe.speclang.ConcreteArgumentValue;
import droidsafe.speclang.ConcreteListArgumentValue;
import droidsafe.speclang.IntValue;
import droidsafe.speclang.JSAValue;
import droidsafe.speclang.Method;
import droidsafe.speclang.NullValue;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.speclang.StringValue;
import droidsafe.speclang.TypeValue;
import droidsafe.speclang.ValueAnalysisValue;


public class RCFGToSSL {
	private final static Logger logger = LoggerFactory.getLogger(RCFGToSSL.class);
	
	private static RCFGToSSL v;
	
	private SecuritySpecification spec;
	
	public static final String SSL_FILE_NAME = "template-spec.ssl";
	
	/**
	 * if true, ignore creating output events for the packages defined in IGNORE_OE_FROM_PACKAGES 
	 */
	public static final boolean IGNORE_OE_FROM_DEFINED_PACKAGES = false;
	
	private static final Set<String> IGNORE_SYS_METHODS_WITH_SUBSIG = 
			new HashSet<String>(Arrays.asList(
					"boolean equals(java.lang.Object)",
					"int hashCode()",
					"java.lang.String toString()"
					));
	
	public static RCFGToSSL v() { 
		return v;
	}
	
	/**
	 * Convert the rCFT to an SSL.
	 * 
	 * If conformance is true, then we are going to use the SSL for conformance checking, so group the same 
	 * method of a Input event
	 */
	public static void run(boolean conformance) {
		v = new RCFGToSSL(conformance);
		
		v.createSSL(RCFG.v());
		
		logger.info("Writing spec to file");
		String fname = Project.v().getOutputDir() + File.separator + SSL_FILE_NAME;
		writeSpecToFile(v.getSpec().toString(), fname);

        String html_fname = Project.v().getOutputDir() + "/spec.html";
        writeSpecToFile(v.getSpec().toHtmlString(), html_fname);

        /* 
        // GK: Removing json spec generation, until it is needed.
        String json_fname = Project.v().getOutputDir() + "/spec.json";
        writeSpecToFile("var data = " + v.getSpec().toJsonString(), json_fname);
        */
	}
	
	protected RCFGToSSL(boolean conformance) {
		spec = new SecuritySpecification(conformance);	
	}
	
	public SecuritySpecification getSpec() {
		return spec;
	}
	
	private void createSSL(RCFG rcfg) {
		for (RCFGNode node : rcfg.getNodes()) {
		    logger.info("Converting rCFG Node: " + node);
		    Method ie = makeInputEventMethod(node);
			for (OutputEvent oe : node.getOutputEvents())
				spec.addOutputEventToInputEvent(ie, methodsFromOutputEvent(oe));
		}
	}
	
	/**
	 * Create a method from the rCFG node's entry point (input event).
	 */
	private Method makeInputEventMethod(RCFGNode node) {
	    ArgumentValue receiver = makeMethodReceiver(node);

	    ArgumentValue[] args = new ArgumentValue[node.getNumArgs()];

        for (int i = 0; i < node.getNumArgs(); i++) {
            if (node.isArgPointer(i)) {
                args[i] = getArgumentValueForPointer(node, i);
            } else {
                args[i] = getArgumentValueForPrimitive(node.getArgValue(i), node.getArgumentType(i));
            }
        }
	    
	    Method method = new Method(node.getEntryPoint(), node, args, receiver);
	    return method;
	}
	
	private boolean shouldIgnore(OutputEvent oe) {	
		if (SafeAndroidClassesAndMethods.v().isSafeMethod(oe.getTarget()))
		    return true;
		
		return (IGNORE_SYS_METHODS_WITH_SUBSIG.contains(oe.getTarget().getSubSignature())); 
	}
	
	private List<Method> methodsFromOutputEvent(OutputEvent oe) {
		List<Method> methods = new LinkedList<Method>();

		//should we ignore creating a method in the spec from this output event
		if (shouldIgnore(oe)) {
			return methods;
		}

		ArgumentValue[] args = new ArgumentValue[oe.getNumArgs()];

		for (int i = 0; i < oe.getNumArgs(); i++) {
			if (oe.isArgPointer(i)) {
				args[i] = getArgumentValueForPointer(oe, i);
			} else {
				args[i] = getArgumentValueForPrimitive(oe.getArgValue(i), oe.getTarget().getParameterType(i));
			}
		}

		ArgumentValue receiver = makeMethodReceiver(oe);
		Method method = new Method(oe.getTarget(), oe, args, receiver);	
		
		logger.info("Created method with target: {}", method.getSootMethod());
		//transfer over the source location information of the call
		if (oe.getSourceLocationTag() != null)
			method.addLineTag(oe.getSourceLocationTag());

		methods.add(method);

		return methods;
	}
	
	/**
	 * Given the possible presence of a receiver for a method, query the VA for a result
	 * and if no result, just return type.
	 */
	private ArgumentValue makeMethodReceiver(PTAMethodInformation method) {
	    //if no receiver, then return null
	    if (!method.hasReceiver())
	        return null;

	    boolean allVAResults = true;
	    List<ConcreteArgumentValue> vaResults = new LinkedList<ConcreteArgumentValue>();
        Context context = method.getContext();
	    
        //iterate over all the nodes pointed to and see if they are all va results
        //if not, break and remember
        for (IAllocNode node : method.getReceiverPTSet(context)) {
            if (ValueAnalysis.v().hasResult(node)) {
                //check to see if we have a value analysis result for this alloc node
                //and if so, add it to the concrete list of values.
                ValueAnalysisValue vav = new ValueAnalysisValue(ValueAnalysis.v().getResult(node));
                vaResults.add(vav);             
            } else {
                allVAResults = false;
                break;
            }
        }
        
	    if (allVAResults && method.getReceiverPTSet(context).size() > 0) {
            //if we have all va results, create the concrete argument list from the results
            ConcreteListArgumentValue clrv = new ConcreteListArgumentValue(method.getReceiverType());
            for (ConcreteArgumentValue s : vaResults) 
                clrv.add(s);
            return clrv;
	    } else {
	        //cannot conclude va results because not all nodes have them, so just return type
	        return new TypeValue(method.getReceiverType());
	    }
	}
	
	private static void writeSpecToFile(String secspec, String fname) {
		try{
			FileWriter fstream = new FileWriter(fname);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(secspec);
			out.close();
		} catch (Exception e){//Catch exception if any
          logger.error("Writing specification file.", e);
		}
	}
	
	//given a pta set for an arg and type for the arg, create the appropriate value
	//for the Method object of the specification language.
	private ArgumentValue getArgumentValueForPointer(PTAMethodInformation methodInfo, int i) {
	    Type t = methodInfo.getArgumentType(i);
	   
	    //set the argument value if it is a value tracked by JSA
	    if (JSAStrings.v().isHotspotValue(methodInfo.getArgValue(i))) {
	        JSAValue jsav = new JSAValue(JSAStrings.v().getRegex(methodInfo.getArgValue(i)));
	        ConcreteListArgumentValue clrv = new ConcreteListArgumentValue(t);
	        clrv.add(jsav);
	        return clrv;
	    }
	    
	    Set<? extends IAllocNode> ptsToSet = methodInfo.getArgPTSet(methodInfo.getContext(), i); 
		boolean allConstants = true;
		//here we consider Value Analysis results as constants
		List<ConcreteArgumentValue> constants = new LinkedList<ConcreteArgumentValue>();
		
		//iterate over all the nodes pointed to and see if they are all constants
		//if not, break and remember
		for (IAllocNode node : ptsToSet) {
			if (node instanceof IStringConstantNode) {
				//create new string values just in case this is all constants
				String value = ((IStringConstantNode)node).getString();
				constants.add(new StringValue(value));
			} else if (node instanceof IClassConstantNode) {
				//create a new concrete arg value just in case this is all constants
				constants.add(new ClassValue(((IClassConstantNode)node).getClassConstant().getValue()));
			} else if (ValueAnalysis.v().hasResult(node)) {
			    //check to see if we have a value analysis result for this alloc node
			    //and if so, add it to the concrete list of values.
			    ValueAnalysisValue vav = new ValueAnalysisValue(ValueAnalysis.v().getResult(node));
			    constants.add(vav);			    
			} else {
				allConstants = false;
				break;
			}
		}
		
		//a points to set could be empty if the alloc node is in library code
		if (allConstants && ptsToSet.size() > 0) {
			//if we have all constants, create the concrete argument list from the constants
			ConcreteListArgumentValue clrv = new ConcreteListArgumentValue(t);
			for (ConcreteArgumentValue s : constants) 
				clrv.add(s);
			return clrv;
			
		} else if (ptsToSet.isEmpty()) {
		    ConcreteListArgumentValue clrv = new ConcreteListArgumentValue(t);
            clrv.add(NullValue.getNullValue());
            return clrv;
		} else {  //if not all constants, then return type because we don't know what is happening
			return new TypeValue(t);
		}
	}
	
	/**
	 * Create an argument in the SSL IR from the type and the value of the parameter of
	 * a method.
	 */
	private ArgumentValue getArgumentValueForPrimitive(Value value, Type type) {
		ConcreteListArgumentValue listArg = new ConcreteListArgumentValue(type);
		
		if (value instanceof IntConstant) {
			int intValue = ((IntConstant)value).value;

			if (type instanceof BooleanType) {
				listArg.add(BooleanValue.getBooleanValue(intValue));
			} else if (type instanceof CharType) {
				listArg.add(new CharValue((char)intValue));
			} else if (type instanceof IntType) {
				listArg.add(new IntValue(intValue));
			} else if (type instanceof ByteType) {
			    listArg.add(new ByteValue((byte)intValue));
			} else {
				logger.error("Unknown type for int constant when converting to method: {}", type);
				droidsafe.main.Main.exit(1);
			}
			return listArg;
		} else if (value instanceof LongConstant) {
			//TODO: should have a long constant as well
			return new TypeValue(type);
		} else if (value instanceof StringConstant) {
			listArg.add(new StringValue(((StringConstant)value).value));
			return listArg;
		} else if (value instanceof ClassConstant) {
			listArg.add(new ClassValue(((ClassConstant)value).getValue()));
			return listArg;
		} else if (value instanceof NullConstant) {
		    listArg.add(NullValue.getNullValue());
		    return listArg;
		} else 
			return new TypeValue(type);
	}
}
