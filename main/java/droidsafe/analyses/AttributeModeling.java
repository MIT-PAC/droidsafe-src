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

  // FileWriter used to log what we still don't model but perhaps should
  private FileWriter attrModelingTodoLog;

  // Generic logger
  private final static Logger logger  = LoggerFactory.getLogger(AttributeModeling.class);

  //===================================================================================================================
  // Constructors
  //===================================================================================================================

  private AttributeModeling() {
    this.objectToModelMap = new LinkedHashMap<AllocNode, ModeledClass>();

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
    if (am == null)		
      am = new AttributeModeling();

    // loop over all code, creating models and simulating whichever invokeExprs we can as we go
    for (SootClass clazz : Scene.v().getApplicationClasses()) {

      // We don't care about the harness or interfaces
      if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
        continue;

      // We don't care about entry points into the system classes
      if (API.v().isSystemClass(clazz))
        continue;

      for (SootMethod meth : clazz.getMethods()) {
        if (meth.isConcrete()) {
          StmtBody stmtBody = (StmtBody)meth.retrieveActiveBody();

          // get body's unit as a chain
          Chain units = stmtBody.getUnits();

          Iterator stmtIt = units.snapshotIterator();

          while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr()) {
              continue;
            }
            InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();

            // Compute cartesian product of parameters, creating models as we do so. If we can't model something,
            // null is returned.
            //
            ArrayList<Class> paramClasses = new ArrayList<Class>();
            Set<ArrayList<Object>> paramObjectCartesianProduct = am.computeParameterCartesianProduct(invokeExpr);
            if(paramObjectCartesianProduct != null){
              for(Object object : paramObjectCartesianProduct.iterator().next()){
                paramClasses.add(object.getClass());
              }
            }

            // get all the receivers and the models for them
            // if we can model a receiver and have the cartesian product of parameters, simulate each one
            // if we can model a receiver but don't have the cartesian product, then invalidate each model
            if (invokeExpr instanceof InstanceInvokeExpr){
              InstanceInvokeExpr iie = (InstanceInvokeExpr)invokeExpr;
              for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
                ModeledClass modeledReceiverObject = am.createAndGetModel(node);
                if(modeledReceiverObject != null) {
                  if(paramObjectCartesianProduct != null){
                    am.simulateInvokeExprEffects(modeledReceiverObject, modeledReceiverObject.getClass(), invokeExpr, paramObjectCartesianProduct, paramClasses);
                  } else {
                    modeledReceiverObject.invalidate();
                    try {
                      String logEntry = "\n" + "> invalidating " + modeledReceiverObject + " as a result";
                      am.attrModelingTodoLog.write(logEntry + "\n\n");
                    } catch (IOException ioe) {}
                  }
                }
              }
            }
            else if (invokeExpr instanceof StaticInvokeExpr){
              try{
                am.simulateInvokeExprEffects(null, Class.forName("droidsafe.model." + invokeExpr.getMethod().getDeclaringClass().getName()), invokeExpr, paramObjectCartesianProduct, paramClasses);
              } catch(ClassNotFoundException e) {
                am.invalidateParamObjects(paramObjectCartesianProduct);
              }
            } else {
              try {
                am.invalidateParamObjects(paramObjectCartesianProduct);
                String logEntry = "Not simulating expression (isn't an instance invoke or static)" + invokeExpr;
                am.attrModelingTodoLog.write(logEntry + "\n\n");
              } catch (IOException ioe) {}
            }
          }
        }
      }
    }

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

  private Set<ArrayList<Object>> computeParameterCartesianProduct(InvokeExpr invokeExpr){
    int paramCount = invokeExpr.getArgCount(); 
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
      } else if(arg.getType() instanceof RefType) {
        Set<AllocNode> allocNodeSet = GeoPTA.v().getPTSetContextIns(arg);
        if (allocNodeSet.size() != 0){
          for (AllocNode node : allocNodeSet) {
            ModeledClass modeledParamObject = createAndGetModel(node);

            if(modeledParamObject != null){
              paramObjectSets.get(i).add(modeledParamObject);

              // Store the parameter object model so that we can later invalidate it if we haven't modeled the method
              paramObjectModels.add(modeledParamObject);
            } else {
              for(ModeledClass modeledObject : paramObjectModels){
                modeledObject.invalidate();
              }
              return null;
            }
          }
        } else {
          logger.warn("No AllocNodes were found by PTA for arg #{} in instanceInvokeExpr {}", i, invokeExpr);
          for(ModeledClass modeledObject : paramObjectModels){
            modeledObject.invalidate();
          }
          return null;
        }
      } else {
        try {
          String logEntry = "Don't know enough about argument #" + i + " of method " + invokeExpr + "\n";
          this.attrModelingTodoLog.write(logEntry);
        } catch (IOException ioe) {}
        for(ModeledClass modeledObject : paramObjectModels){
          modeledObject.invalidate();
        }      
        return null;
      }
    }

    // What are all the possible ways in which the method can be called now that we know all possible parameters
    return cartesianProduct(0, paramObjectSets);
  } 

  public void invalidateParamObjects(Set<ArrayList<Object>> paramObjectCartesianProduct){  
    if(paramObjectCartesianProduct != null) {
      for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
        for (Object object : paramObjectPermutation){
          if(object instanceof ModeledClass){
            ModeledClass modeledObject = (ModeledClass)object;
            modeledObject.invalidate();
            try {
              String logEntry = "\n" + "> invalidating argument" + modeledObject + " as a result";
              this.attrModelingTodoLog.write(logEntry + "\n\n");
            } catch( IOException ioe) {}
          }
        }
      }
    }
  }

  public void simulateInvokeExprEffects(ModeledClass modeledReceiverObject, Class invokeExprClass, InvokeExpr invokeExpr, Set<ArrayList<Object>> paramObjectCartesianProduct, ArrayList<Class> paramObjectClasses) { 
    String methodName = invokeExpr.getMethod().getName();
    if(methodName.equals("<init>")){
      methodName = "_init_";
    }
    try {
      java.lang.reflect.Method method = invokeExprClass.getDeclaredMethod(methodName, paramObjectClasses.toArray(new Class[paramObjectClasses.size()]));
      for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
        method.invoke(modeledReceiverObject, paramObjectPermutation.toArray());
      }
    } catch (Exception e) {
      try {
        String logEntry = "The method " + methodName + " in class " + invokeExprClass + "hasn't been modeled: " + e.toString();

        // The method isn't modeled, so we must invalidate every argument that we modeled
        this.invalidateParamObjects(paramObjectCartesianProduct);

        // If this is an InstanceInvoke, also invalidate the receiver object
        if (modeledReceiverObject != null){
          modeledReceiverObject.invalidate();
          logEntry += "\n" + "> invalidating receiver" + modeledReceiverObject + " as a result";
        }
        this.attrModelingTodoLog.write(logEntry + "\n\n");
      } catch (IOException ioe) {}
    }
  }

  /*
   * Creates (if it does not yet exist) and returns our model
   * of the dynamic type of the AllocNode if it is modeled
   */
  private ModeledClass createAndGetModel(AllocNode allocNode) {
    //don't track values for alloc nodes we create
    if (AddAllocsForAPICalls.v().isGeneratedExpr(allocNode.getNewExpr()))
      return null;

    if (!(allocNode.getType() instanceof RefType))
      return null;

    SootClass clazz = ((RefType)allocNode.getType()).getSootClass();

    if (allocNode.getMethod() != null && allocNode.getMethod().equals(Harness.v().getMain())) {
      clazz = clazz.getSuperclass();
    }
    ModeledClass model = null;
    String className = clazz.getName();
    try {
      Class<?> modelClazz = Class.forName("droidsafe.model." + className);
      if (!objectToModelMap.containsKey(allocNode)) {
        Constructor<?> ctor = modelClazz.getConstructor(AllocNode.class);
        model = (ModeledClass)ctor.newInstance(allocNode);
        objectToModelMap.put(allocNode, model);
      } else {
        return objectToModelMap.get(allocNode);
      }
    } catch(Exception e) {
      try {
        String logEntry = "Couldn't model an instance of the " + className + " class: \n" + e.toString();
        this.attrModelingTodoLog.write(logEntry + "\n\n");
      } catch (IOException ioe) {}
    }
    return model;
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
