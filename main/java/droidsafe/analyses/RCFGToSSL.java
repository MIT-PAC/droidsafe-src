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
import soot.CharType;
import soot.IntType;
import soot.Type;
import soot.Value;
import soot.jimple.ClassConstant;
import soot.jimple.IntConstant;
import soot.jimple.LongConstant;
import soot.jimple.StringConstant;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.spark.pag.ClassConstantNode;
import soot.jimple.spark.pag.StringConstantNode;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Project;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.BooleanValue;
import droidsafe.speclang.CharValue;
import droidsafe.speclang.ClassValue;
import droidsafe.speclang.ConcreteArgumentValue;
import droidsafe.speclang.ConcreteListArgumentValue;
import droidsafe.speclang.IntValue;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.speclang.StringValue;
import droidsafe.speclang.TypeValue;


public class RCFGToSSL {
	private final static Logger logger = LoggerFactory.getLogger(RCFGToSSL.class);
	
	private static RCFGToSSL v;
	
	private SecuritySpecification spec;
	
	public static final String SSL_FILE_NAME = "template-spec.ssl";
	
	/**
	 * if true, ignore creating output events for the packages defined in IGNORE_OE_FROM_PACKAGES 
	 */
	public static final boolean IGNORE_OE_FROM_DEFINED_PACKAGES = false;
	
	/** List of packages to ignore from the android API, use only second level package name: 
	 * android.something.
	 */
	public static final Set<String> IGNORE_OE_FROM_PACKAGES = new HashSet<String>(Arrays.asList(""
			/*"android.graphics", "android.view","android.widget"*/
			));
	
	
	private static final Set<String> IGNORE_SYS_METHODS_WITH_SUBSIG = 
			new HashSet<String>(Arrays.asList(
					"boolean equals(java.lang.Object)",
					"int hashCode()",
					"java.lang.String toString()"
					));
	
	public static RCFGToSSL v() { 
		return v;
	}
	
	public static void run() {
		v = new RCFGToSSL();
		
		v.createSSL(RCFG.v());
		
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
	
	protected RCFGToSSL() {
		spec = new SecuritySpecification();	
	}
	
	public SecuritySpecification getSpec() {
		return spec;
	}
	
	private void createSSL(RCFG rcfg) {
		for (RCFGNode node : rcfg.getNodes()) {
			Method ie = new Method(node.getEntryPoint());
			for (OutputEvent oe : node.getOutputEvents())
				spec.addToInputEventCombine(ie, methodsFromOutputEvent(oe));
		}
	}
	
	private boolean shouldIgnore(OutputEvent oe) {	
		String[] className = oe.getTarget().getDeclaringClass().getName().split("\\.");				
		if (className.length < 2)
			return false;
		
		String packageStart = className[0] + "." + className[1];
		
		return (IGNORE_OE_FROM_PACKAGES.contains(packageStart) ||
				IGNORE_SYS_METHODS_WITH_SUBSIG.contains(oe.getTarget().getSubSignature())); 
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
				args[i] = getArgumentValueForPointer(oe.getArgPTSet(i), oe.getArgumentType(i));
			} else {
				args[i] = getArgumentValueForPrimitive(oe.getArgValue(i), oe.getTarget().getParameterType(i));
			}
		}

		Method method = null;
		if (oe.hasReceiver()) {
			method = new Method(oe.getTarget(), args, oe.getReceiverType());	
		} else {
			method = new Method(oe.getTarget(), args, null);
		}
		
		//logger.info("Created method with target: {}", method.getSootMethod());
		//transfer over the source location information of the call
		if (oe.getSourceLocationTag() != null)
			method.addLineTag(oe.getSourceLocationTag());

		methods.add(method);

		return methods;
	}
	
	private static void writeSpecToFile(String secspec, String fname) {
		try{
			FileWriter fstream = new FileWriter(fname);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(secspec);
			out.close();
		}catch (Exception e){//Catch exception if any
          logger.error("Writing specification file.", e.getMessage());
		}
	}
	
	//given a pta set for an arg and type for the arg, create the appropriate value
	//for the Method object of the specification language.
	private ArgumentValue getArgumentValueForPointer(Set<AllocNode> ptsToSet, Type t) {
		boolean allConstants = true;
		List<ConcreteArgumentValue> constants = new LinkedList<ConcreteArgumentValue>();
		
		//iterate over all the nodes pointed to and see if they are all constants
		//if not, break and remember
		for (AllocNode node : ptsToSet) {
			if (node instanceof StringConstantNode) {
				//create new string values just in case this is all constants
				String value = ((StringConstantNode)node).getString();
				constants.add(new StringValue(value));
			} else if (node instanceof ClassConstantNode) {
				//create a new concrete arg value just in case this is all constants
				constants.add(new ClassValue(((ClassConstantNode)node).getClassConstant().getValue()));
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
			} else {
				logger.error("Unknown type for int constant when converting to method: {}", type);
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
		} else 
			return new TypeValue(type);
	}
}
