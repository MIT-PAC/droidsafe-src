package droidsafe.analyses;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.spark.pag.AllocNode;
import soot.util.Chain;

import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.android.app.Harness;
import droidsafe.android.system.API;
import droidsafe.speclang.Method;
import droidsafe.transforms.AddAllocsForAPICalls;
import droidsafe.utils.SootUtils;

/**
 * Find 
 * 
 * @author mgordon
 *
 */
public class AttributeModeling {
	private final static Logger logger = LoggerFactory.getLogger(AttributeModeling.class);
	
	private Set<AllocNode> objectsToTrack;
	
	private Map<AllocNode, Set<InstanceInvokeExpr>> receiverForMethods;
	
	private Map<AllocNode, Set<InvokeExpr>> argumentOfMethods;
	
	/** Singleton for analysis */
	private static AttributeModeling am;
	
	public static AttributeModeling v() {
		return am;
	}
	
	public static void run() {
		if (GeoPTA.v() == null || RCFG.v() == null) {
			logger.error("Attribute Modeling depends on both GeoPTA and RCFG passes.");
			System.exit(1);
		}
		
		am = new AttributeModeling();
		
		//find all values that we want to track, these are either receivers or args in 
		//output events in rCFG
		am.findObjects();
		
		//single pass over code to find all calls on these objects and incorporate their effects
		//TODO: We should have a pass that kills deadcode (methods that cannot be reached from main)
		am.modelObjects();
		
		am.log();
	}
	
	private AttributeModeling() {
		objectsToTrack = new LinkedHashSet<AllocNode>();
		receiverForMethods = new LinkedHashMap<AllocNode, Set<InstanceInvokeExpr>>();
		argumentOfMethods = new LinkedHashMap<AllocNode, Set<InvokeExpr>>();
	}
	
	private void modelObjects() {
		//loop over all code and find calls for with any tracked as received or arg
		for (SootClass clazz : Scene.v().getApplicationClasses()) {
    		if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
    			continue;
    	
    		//don't add entry points into the system classes...
    		if (API.v().isSystemClass(clazz))
    			continue;
    		
    		for (SootMethod meth : clazz.getMethods()) {
				if (meth.isConcrete()) {
					logger.info("Analyzing method: {}", meth);
					analyzeBody(meth.retrieveActiveBody());
				}
    		}
		}
	}
	
	private void analyzeBody(Body b) {
		StmtBody stmtBody = (StmtBody)b;

		// get body's unit as a chain
		Chain units = stmtBody.getUnits();

		Iterator stmtIt = units.snapshotIterator();

		while (stmtIt.hasNext()) {
			Stmt stmt = (Stmt)stmtIt.next();
			
			if (!stmt.containsInvokeExpr()) {
				continue;
			}

			InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
			
			
			//get the receiver, receivers are only present for instance invokes 
			InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
			if (iie != null) {
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
					//if we are tracking this object, then add the call in the receiver for method
					//map
					if (objectsToTrack.contains(node)) {
						if (!receiverForMethods.containsKey(node))
							receiverForMethods.put(node, new LinkedHashSet<InstanceInvokeExpr>());
						
						receiverForMethods.get(node).add(iie);
					}
				}
			}
			
			//get the args
			for (int i = 0; i < expr.getArgCount(); i++) {
				Value arg = expr.getArg(i);
				if (!GeoPTA.v().isPointer(arg))
					continue;
				
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(arg)) {
					//if we are tracking this object, then add the call in the argument map
					if (objectsToTrack.contains(node)) {
						if (!argumentOfMethods.containsKey(node))
							argumentOfMethods.put(node, new LinkedHashSet<InvokeExpr>());
						
						argumentOfMethods.get(node).add(expr);
					}
				}
				
			}
		}
	}
	
	private void log() {
		for (AllocNode node : objectsToTrack) {
			logger.info("Tracking allocNode: {}", node);
			logger.info("Receiver For: ");
			for (InstanceInvokeExpr iie : receiverForMethods.get(node)) {
				logger.info("    {}", iie);
			}
			
			logger.info("Argument for:");
			for (InvokeExpr ie : argumentOfMethods.get(node)) {
				logger.info("    {}", ie);
			}
		}
	}
	
	private void findObjects() {
		for (RCFGNode node : RCFG.v().getNodes()) {
			Method ie = new Method(node.getEntryPoint());
			for (OutputEvent oe : node.getOutputEvents()) {
				
				//check the receiver
				if (oe.hasReceiver() && isSecuritySensitive(oe.getReceiverAlloc()))
					objectsToTrack.add(oe.getReceiverAlloc());
				
				//now check all the arguments
				for (int i = 0; i < oe.getNumArgs(); i++) {
					if (oe.isArgPointer(i)) 
						for (AllocNode argNode : oe.getArgPTSet(i)) {
							if (isSecuritySensitive(argNode))
								objectsToTrack.add(argNode);
						}
				}
			}
		}
	}
	
	/**
	 * Return true if the dynamic type of the allocnode is a security relevant type.
	 */
	public boolean isSecuritySensitive(AllocNode node) {
		//don't track values for alloc nodes we create
		if (AddAllocsForAPICalls.v().isGeneratedExpr(node.getNewExpr()))
			return false;
		
		//don't track values for alloc in harness
		if (node.getMethod() != null &&
				node.getMethod().equals(Harness.v().getMain()))
			return false;
		
		if (!(node.getType() instanceof RefType))
			return false;
		
		SootClass clazz = ((RefType)node.getType()).getSootClass();
		
		if (clazz.getName().equals("android.content.Intent"))
			return true;
		
		return false;
				
	}
}
