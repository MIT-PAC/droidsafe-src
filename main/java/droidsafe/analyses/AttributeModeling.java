package droidsafe.analyses;

import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;
import droidsafe.analyses.GeoPTA;

import droidsafe.android.app.Harness;
import droidsafe.android.system.API;

import droidsafe.model.ModeledClass;

import droidsafe.speclang.Method;

import droidsafe.transforms.AddAllocsForAPICalls;

import droidsafe.utils.SootUtils;

import java.lang.reflect.Constructor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;

import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootMethod;

import soot.util.Chain;

import soot.Value;

/**
 * We want to model certain Android objects such as Intents, Strings, and Uris so that we better understand the way 
 * they are built up and used.
 *
 * We don't want to present the analyst with the built up of each like we do now, but instead each at the time of its
 * use with as much Context as possible (this might help shorten the spec a little bit). For example, for an Intent i, 
 * we should tell the analyst which View or Uri will be started when StartActivity(i) is called and let them decide 
 * whether its malware or not.
 *
 * We are assuming that in general, each is used simply and once.
 * 
 * @author mgordon, dpetters
 *
 */
public class AttributeModeling {

  private final static Logger logger = LoggerFactory.getLogger(AttributeModeling.class);
	
  
  // AllocNode keys are the objects that we can and want to model. The value is the Model object which simulates that
  // object.
	private Map<AllocNode, ModeledClass> objectToModelMap; 
  
  // InstanceInvokeExpr for which the object we can about is a receiver 
	private Map<AllocNode, Set<InstanceInvokeExpr>> objectToInstanceInvokeExprMap;

  // InvokeExpr for which the object we care about is an argument
	private Map<AllocNode, Set<InvokeExpr>> objectToInvokeExprMap;


	/** Singleton for analysis */
	private static AttributeModeling am;
	
	public static AttributeModeling v() {
		return am;
	}
	
	
  public static void run() {
		if (GeoPTA.v() == null) {
      logger.error("The GeoPTA pass has not been run. Attribute modeling requires it.");
      System.exit(1);
    }      
    if (RCFG.v() == null) {
			logger.error("The RCFG pass has not been run. Attribute modeling requires it.");
			System.exit(1);
		}
		
		am = new AttributeModeling();
		
    // build up the objectToModelMap
		am.createModels();
		
		// Find all calls on the objects that we just modeled.
		am.findInvokeExprs();

    // TODO: Add a pass that kills deadcode
    
    // Simulate the effects of all the calls we found on the appropirate objects' models' attributes.
    am.simulateInvokeExprEffects();

		am.log();
	}
	
	private AttributeModeling() {
		this.objectToModelMap = new LinkedHashMap<AllocNode, ModeledClass>();
		this.objectToInstanceInvokeExprMap = new LinkedHashMap<AllocNode, Set<InstanceInvokeExpr>>();
		this.objectToInvokeExprMap = new LinkedHashMap<AllocNode, Set<InvokeExpr>>();
	}

  // Find all calls on the objects that we just modeled.
	private void findInvokeExprs() {
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
			
			
			// get the receiver - receivers are only present for instance invokes 
			InstanceInvokeExpr iie = SootUtils.getInstanceInvokeExpr(stmt);
			if (iie != null) {
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
					if (this.objectToModelMap.containsKey(node)) {
						if (!objectToInstanceInvokeExprMap.containsKey(node)){
							this.objectToInstanceInvokeExprMap.put(node, new LinkedHashSet<InstanceInvokeExpr>());
            }
						this.objectToInstanceInvokeExprMap.get(node).add(iie);
					}
				}
			}
			
			//get the args
			for (int i = 0; i < expr.getArgCount(); i++) {
				Value arg = expr.getArg(i);
				if (!GeoPTA.v().isPointer(arg))
					continue;
				
				for (AllocNode node : GeoPTA.v().getPTSetContextIns(arg)) {
					if (objectToModelMap.containsKey(node)) {
						if (!objectToInvokeExprMap.containsKey(node)) {
							objectToInvokeExprMap.put(node, new LinkedHashSet<InvokeExpr>());
            }
						objectToInvokeExprMap.get(node).add(expr);
					}
				}
			}
		}
	}
	
  private void simulateInvokeExprEffects() {
    for (Map.Entry<AllocNode, ModeledClass> entry : this.objectToModelMap.entrySet()){
      AllocNode allocNode = entry.getKey();
      ModeledClass modeledClass = entry.getValue();
      if (this.objectToInstanceInvokeExprMap.containsKey(allocNode)){
        for(InstanceInvokeExpr instanceInvokeExpr : this.objectToInstanceInvokeExprMap.get(allocNode)){
          // Simulate the effects of each InstanceInvokeExpr. As soon as we can't simulate one, we invalidate the model
          // and move on to the next AllocNode
          if(!simulateInstanceInvokeExprEffects(instanceInvokeExpr, modeledClass)){
            modeledClass.invalidate(); 
            break;
          }
        }
      }
      
      /*
       * Don't simulate invokeExpressions for now
      if (!modeledClass.isInvalid() && this.objectToInvokeExprMap.containsKey(allocNode)) { 
        for(InvokeExpr invokeExpr : this.objectToInvokeExprMap.get(allocNode)){
          // Simulate the effects of each InstanceInvokeExpr. As soon as we can't simulate one, we invalidate the model
          // and move on to the next AllocNode
          if(!simulateInvokeExprEffects(invokeExpr, modeledClass)){
            modeledClass.invalidate(); 
            break;
          }
        }
      }
      */
	  }
  }

  private boolean simulateInstanceInvokeExprEffects(InstanceInvokeExpr instanceInvokeExpr, ModeledClass modeledClass) {
    int paramCount = instanceInvokeExpr.getArgCount();
    Class[] params = new Class[paramCount];
    ArrayList<HashSet<Object>> paramObjectSets = new ArrayList<HashSet<Object>>(); 
    for (int i = 0; i < paramCount; i++) {
      paramObjectSets.add(i, new HashSet<Object>());
      Value arg = instanceInvokeExpr.getArg(i);
      for (AllocNode node : GeoPTA.v().getPTSetContextIns(arg)) {
        if(this.objectToModelMap.containsKey(node)){
          ModeledClass paramObject = this.objectToModelMap.get(node);
          paramObjectSets.get(i).add(paramObject);
          params[i] = paramObject.getClass();
        } else {
          logger.warn("Had to invalidate modeling of {}: do not know how to model the argument {} of method {}", modeledClass, node, instanceInvokeExpr);
          return false;
        }
      }
    }
    ArrayList<ArrayList<Object>> paramObjectPermutations = new ArrayList<ArrayList<Object>>();
    if(paramObjectSets.size() == 1){ 
      for (int i = 0; i < paramObjectSets.size(); ++i) {
        for(Object paramObject : paramObjectSets.get(i)){
          ArrayList<Object> paramObjectPermutation = new ArrayList<Object>();
          paramObjectPermutation.add(0, paramObject);
          paramObjectPermutations.add(i, paramObjectPermutation);
        }
      }
    }
    try {
      String methodName = instanceInvokeExpr.getMethod().getName();
      if(methodName.equals("<init>")){
        methodName = "_init_";
      }
      java.lang.reflect.Method method = modeledClass.getClass().getDeclaredMethod(methodName, params);
      for (ArrayList paramObjectCombo : paramObjectPermutations){
        method.invoke(modeledClass, paramObjectCombo.toArray());
      }
    } catch(Exception e) {
      logger.warn("Had to invalidate modeling of {}: {}", modeledClass, e);
      return false;
    }
    return true;
  }

  /**
   * Find all objects that we currently model and create the underlying models for them.
   * These are either receivers or args in output events in rCFG.
   */
	private void createModels() {
		for (RCFGNode node : RCFG.v().getNodes()) {
			Method ie = new Method(node.getEntryPoint());
			for (OutputEvent oe : node.getOutputEvents()) {
				// create the model for the receiver if it hasn't been created yet and we can model the class
				if (oe.hasReceiver()) {
          
          AllocNode receiverAllocNode = oe.getReceiverAlloc();
          ModeledClass model = this.getOrCreateModel(receiverAllocNode);
					if (model != null && !this.objectToModelMap.containsKey(receiverAllocNode)) {
             this.objectToModelMap.put(receiverAllocNode, model);    
          }
        }
				// create the model for the arguments if it hasn't been created yet and we can model the class
				for (int i = 0; i < oe.getNumArgs(); i++) {
					if (oe.isArgPointer(i)) { 
						for (AllocNode argAllocNode : oe.getArgPTSet(i)) {
						  ModeledClass model = getOrCreateModel(argAllocNode);
					    if (model != null && !this.objectToModelMap.containsKey(argAllocNode)) {
                this.objectToModelMap.put(argAllocNode, model);    
              }	
						}
          }
				}
			}
		}
	}

	/**
	 * Creates (if it does not yet exist) and returns our model of the dynamic type of the AllocNode if it is modeled
	 */
	public ModeledClass getOrCreateModel(AllocNode allocNode) {
    //don't track values for alloc nodes we create
		if (AddAllocsForAPICalls.v().isGeneratedExpr(allocNode.getNewExpr()))
			return null;

		if (!(allocNode.getType() instanceof RefType))
			return null;
    
		SootClass clazz = ((RefType)allocNode.getType()).getSootClass();
  
    if (allocNode.getMethod() != null && allocNode.getMethod().equals(Harness.v().getMain())) {
      clazz = clazz.getSuperclass();
    }
    
    String className = clazz.getName();
    try {
      Class<?> modelClazz = Class.forName("droidsafe.model." + className);
      if (objectToModelMap.containsKey(allocNode)) {
        return objectToModelMap.get(allocNode);
      } else {
        Constructor<?> ctor = modelClazz.getConstructor(AllocNode.class);
        ModeledClass model = (ModeledClass)ctor.newInstance(allocNode);
        logger.info("Created Model: {}, {}", allocNode, model);
        objectToModelMap.put(allocNode, model);
        return model;
      }
    } catch(Exception e) {
      logger.warn("Couldn't model an AllocNode of the {} class: {}, {}", className, allocNode, e);
      return null;
    }
	}
 
  /**
   * Log the results of the modeling
   */
  private void log() {
		for (ModeledClass modeledClass : objectToModelMap.values()) {
      logger.info("Finished Model: {}, {}", modeledClass.getAllocNode(), modeledClass);
    }
  }
}
