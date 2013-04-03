package droidsafe.analyses;

import droidsafe.analyses.GeoPTA;
import droidsafe.analyses.rcfg.OutputEvent;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.rcfg.RCFGNode;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;

import droidsafe.model.ModeledClass;

import droidsafe.speclang.Method;

import droidsafe.transforms.AddAllocsForAPICalls;

import droidsafe.utils.SootUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.lang.reflect.Constructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;

import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.StaticInvokeExpr;
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
  
  //===================================================================================================================
  // Private Attributes
  //===================================================================================================================
  
  // Singleton for analysis
	private static AttributeModeling am;

  // AllocNode keys are the objects that we can and want to model.
  // The value is the Model object which simulates that object.
	private Map<AllocNode, ModeledClass> objectToModelMap; 
  
  // We care about the AllocNodes which are the keys and hence want to simulate the effects of the instanceInvokeExprs 
  // of which they are the receivers
	private Map<AllocNode, Set<InstanceInvokeExpr>> objectToInstanceInvokeExprMap;

  // We care about one or more of the arguments to these static methods and hence want to simulate their effects
	private Set<StaticInvokeExpr> staticInvokeExprs;

  // FileWriter used to log what we still don't model but perhaps should
  private FileWriter attrModelingTodoLog;

  // Generic logger
  private final static Logger logger  = LoggerFactory.getLogger(AttributeModeling.class);

  //===================================================================================================================
  // Constructors
  //===================================================================================================================

  private AttributeModeling() {
		this.objectToModelMap = new LinkedHashMap<AllocNode, ModeledClass>();
		this.objectToInstanceInvokeExprMap = new LinkedHashMap<AllocNode, Set<InstanceInvokeExpr>>();
		this.staticInvokeExprs = new HashSet<StaticInvokeExpr>();
    
    try {
	    this.attrModelingTodoLog = new FileWriter(Project.v().getOutputDir() + File.separator + "attribute-modeling-todos.log");
    } catch (Exception e) {
      logger.warn("Unable to record attribute modeling errors.", e);
    }
  }

  //===================================================================================================================
  // Static Methods
  //===================================================================================================================

	public static AttributeModeling v() {
		return am;
	}
	
  private static Set<ArrayList<Object>> cartesianProduct(int index, ArrayList<HashSet<Object>> sets) {
    HashSet<ArrayList<Object>> ret = new HashSet<ArrayList<Object>>();
    if (index == sets.size()) {
      ret.add(new ArrayList<Object>());
    } else {
      for (Object obj : sets.get(index)) {
        for (ArrayList<Object> set : cartesianProduct(index+1, sets)) {
           set.add(0, obj);
           ret.add(set);
        }
      }  
    } 
    return ret;
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
    am.simulateInstanceInvokeExprEffects();

    am.simulateStaticInvokeExprEffects();

    try {
      am.attrModelingTodoLog.close();
    } catch (IOException ioe){
      logger.warn("Unable to close the attribute modeling error log file.", ioe);
    }

		am.log();
	}

  //===================================================================================================================
  // Private Methods
  //===================================================================================================================

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
					analyzeBody(meth.retrieveActiveBody());
				}
    		}
		}
	}
	
  private void simulateStaticInvokeExprEffects() {
    for (StaticInvokeExpr staticInvokeExpr : this.staticInvokeExprs){
      // Simulate the effects of each StaticInvokeExpr. We pass in null for modeledObject because there is no receiver
      simulateInvokeExprEffects(staticInvokeExpr, null);
	  }
  }

  private void simulateInstanceInvokeExprEffects() {
    for (Map.Entry<AllocNode, ModeledClass> entry : this.objectToModelMap.entrySet()){
      AllocNode allocNode = entry.getKey();
      ModeledClass modeledClass = entry.getValue();
      if (this.objectToInstanceInvokeExprMap.containsKey(allocNode)){
        for(InstanceInvokeExpr instanceInvokeExpr : this.objectToInstanceInvokeExprMap.get(allocNode)){
          // Simulate the effects of each InstanceInvokeExpr. As soon as we can't simulate one, we invalidate the model
          // and move on to the next AllocNode
          if(!simulateInvokeExprEffects(instanceInvokeExpr, modeledClass)){
            modeledClass.invalidate(); 
            break;
          }
        }
      }
	  }
  }

  private boolean simulateInvokeExprEffects(InvokeExpr invokeExpr, ModeledClass modeledClass) {

    // First, we gather info about the parameters of the invokeExpr

    int paramCount = invokeExpr.getArgCount(); 
    // Each index is the class that the parameter at that index is an instance of
    Class[] paramClasses = new Class[paramCount];
    // Each index is a set of objects that the parameter at that index can possibly be 
    ArrayList<HashSet<Object>> paramObjectSets = new ArrayList<HashSet<Object>>();
    
    // Store the parameter object models so that we can later invalidate them if we haven't modeled the method
    ArrayList<ModeledClass> paramObjectModels = new ArrayList<ModeledClass>();
    // All this entire for loop does is fill in paramClasses and paramObjectSets. We may quit early if we are unable to
    // model any of the parameters. 
    for (int i = 0; i < paramCount; i++) {
      // Create a new set in which we'll put all possible objects that could be this parameter 
      paramObjectSets.add(i, new HashSet<Object>());

      Value arg = invokeExpr.getArg(i);
      // If the argument is a constant, we box it up. We don't model primitives.
      // If the argument is a RefType, then we use PTA to find all possible AllocNodes and their corresponding models
      // We can't simulate this invokeExpr if the argument doesn't fall in those two cases (yet)
      if(arg instanceof Constant) {
        
        Object object = SootUtils.constantValueToObject(arg);
        paramObjectSets.get(i).add(SootUtils.constantValueToObject(arg));
        paramClasses[i] = object.getClass();

      } else if(arg.getType() instanceof RefType) {
        Set<AllocNode> allocNodeSet = GeoPTA.v().getPTSetContextIns(arg);
        if (allocNodeSet.size() != 0){
          for (AllocNode node : allocNodeSet) {
            if(this.objectToModelMap.containsKey(node)){
              ModeledClass paramObjectModel = this.objectToModelMap.get(node);
              paramObjectSets.get(i).add(paramObjectModel);
              paramClasses[i] = paramObjectModel.getClass();
              
              // Store the parameter object model so that we can later invalidate it if we haven't modeled the method
              paramObjectModels.add(paramObjectModel);
            } else {
              try {
                String logEntry = "Couldn't model argument '" + node + "' of method '" + invokeExpr + "'\n";
                if (invokeExpr instanceof InstanceInvokeExpr) {
                  logEntry += "> invalidating " + modeledClass + " as a result.";
                }
                this.attrModelingTodoLog.write(logEntry + "\n\n");
              } catch (IOException ioe) {}
              // Only invalidate the receiver if there is one
              if (invokeExpr instanceof InstanceInvokeExpr) {
                modeledClass.invalidate();
              }
            return false;
            }
          }
        } else {
          logger.warn("No AllocNodes were found by PTA for arg #{} in instanceInvokeExpr {}", i, invokeExpr);
        }
      } else {
        try {
          String logEntry = "Don't know enough about argument #" + i + " of method " + invokeExpr + "\n";
          logEntry += "> invalidating " + modeledClass + " as a result.";
          this.attrModelingTodoLog.write(logEntry + "\n\n");
        } catch (IOException ioe) {}
        // Only invalidate the receiver if there is one
        if (invokeExpr instanceof InstanceInvokeExpr) {
          modeledClass.invalidate();
        }
        return false;
      }
    }
    
    // What are all the possible ways in which the method can be called now that we know all possible parameters
    Set<ArrayList<Object>> paramObjectCartesianProduct = cartesianProduct(0, paramObjectSets);
    
    try {
      String methodName = invokeExpr.getMethod().getName();
      if(methodName.equals("<init>")){
        methodName = "_init_";
      }
      Class methodClass;
      if (modeledClass != null) {
        methodClass = modeledClass.getClass();
      } else {
        methodClass = Class.forName("droidsafe.model." + invokeExpr.getMethod().getDeclaringClass().getName());
      }
      java.lang.reflect.Method method = methodClass.getDeclaredMethod(methodName, paramClasses);
      for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
        method.invoke(modeledClass, paramObjectPermutation.toArray());
      }
    } catch (Exception e) {
      try {
        for (ModeledClass modeledObject : paramObjectModels){
          modeledObject.invalidate();
        }
        String logEntry = "Couldn't model instance of " + modeledClass + " class: \n" + e.toString();
        for (ModeledClass modeledObject : paramObjectModels){
          logEntry += "\n" + "> invalidating " + modeledObject + " as a result.";
          modeledObject.invalidate();
        }
        this.attrModelingTodoLog.write(logEntry + "\n\n");
      } catch (IOException ioe) {}
      return false;
    }
    return true;
  }

  
  /*
   * Find all objects that we currently model and create the underlying models for them.
   * These are either receivers or args in output events in rCFG.
   */
	private void createModels() {
		for (RCFGNode node : RCFG.v().getNodes()) {
			for (OutputEvent oe : node.getOutputEvents()) {
				if (oe.hasReceiver()) {
          createModel(oe.getReceiverAlloc());
        }
				// create the model for the arguments if it hasn't been created yet and we can model the class
				for (int i = 0; i < oe.getNumArgs(); i++) {
					if (oe.isArgPointer(i)) { 
						for (AllocNode argAllocNode : oe.getArgPTSet(i)) {
              createModel(argAllocNode);
						}
          }
				}
			}
		}
	}

	/*
	 * Creates (if it does not yet exist) and returns our model
   * of the dynamic type of the AllocNode if it is modeled
	 */
	private void createModel(AllocNode allocNode) {
    
    //don't track values for alloc nodes we create
		if (AddAllocsForAPICalls.v().isGeneratedExpr(allocNode.getNewExpr()))
			return;

		if (!(allocNode.getType() instanceof RefType))
			return;
    
		SootClass clazz = ((RefType)allocNode.getType()).getSootClass();
  
    if (allocNode.getMethod() != null && allocNode.getMethod().equals(Harness.v().getMain())) {
      clazz = clazz.getSuperclass();
    }
    String className = clazz.getName();
    try {
      Class<?> modelClazz = Class.forName("droidsafe.model." + className);
      if (!objectToModelMap.containsKey(allocNode)) {
        Constructor<?> ctor = modelClazz.getConstructor(AllocNode.class);
        ModeledClass model = (ModeledClass)ctor.newInstance(allocNode);
        objectToModelMap.put(allocNode, model);
      }
    } catch(Exception e) {
      try {
        String logEntry = "Couldn't model an instance of the " + className + " class: \n" + e.toString();
        this.attrModelingTodoLog.write(logEntry + "\n\n");
      } catch (IOException ioe) {}
    }
    return;
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
      else if (expr instanceof StaticInvokeExpr){
        boolean added = false;
        for (int i = 0; i < expr.getArgCount() && !added; i++) {
				  Value arg = expr.getArg(i);
				  if (!GeoPTA.v().isPointer(arg)){
					  continue;
          }
				  for (AllocNode node : GeoPTA.v().getPTSetContextIns(arg)) {
					  if (objectToModelMap.containsKey(node)) {
						  staticInvokeExprs.add((StaticInvokeExpr)expr); 
              added = true;
              break;
					  }
          }
				}
			} else {
        try {
          String logEntry = "Not simulating expression (isn't an instance invoke or static)" + expr;
          this.attrModelingTodoLog.write(logEntry + "\n\n");
        } catch (IOException ioe) {}
      }
		}
  }

  /*
   * Log the results of the modeling
   */
  private void log() {
		for (ModeledClass modeledObject : objectToModelMap.values()) {
      logger.info("Finished Model: {}", modeledObject);
    }
  }
}
