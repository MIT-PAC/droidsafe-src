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
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;

import soot.jimple.Constant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.NullConstant;
import soot.jimple.StringConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.spark.pag.AllocNode;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;

import soot.Type;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootMethod;

import soot.util.Chain;

import soot.Value;

/**
 * Models certain Android objects such as Intents, Strings, and Uris so that we better understand the way 
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
    /*
    if (RCFG.v() == null) {
      logger.error("The RCFG pass has not been run. Attribute modeling requires it.");
      System.exit(1);
    }
    */
    if (am == null)
      am = new AttributeModeling();

    Set<SootMethod> reachableMethods = GeoPTA.v().getAllReachableMethods();

    // loop over all code, creating models and simulating whichever invokeExprs we can as we go
    for (SootClass clazz : Scene.v().getApplicationClasses()) {
      String className = clazz.getName();

      // We don't care about the harness or interfaces
      if (clazz.isInterface() || className.equals(Harness.HARNESS_CLASS_NAME))
        continue;
     
      // DroidSafeCalls will go away eventually and we don't want to look at it for now 
      if(className.equals("edu.mit.csail.droidsafe.DroidSafeCalls")){
        continue;
      }

      for (SootMethod meth : clazz.getMethods()) {
        if (meth.isConcrete() && reachableMethods.contains(meth)) {
          StmtBody stmtBody = (StmtBody)meth.retrieveActiveBody();

          // get body's unit as a chain
          Chain units = stmtBody.getUnits();

          Iterator stmtIt = units.snapshotIterator();

          ParamAnalyzer paramAnalyzer;

          while (stmtIt.hasNext()) {
            Stmt stmt = (Stmt)stmtIt.next();
            if (!stmt.containsInvokeExpr()) {
              continue;
            }
            InvokeExpr invokeExpr = (InvokeExpr)stmt.getInvokeExpr();
            
            paramAnalyzer = am.new ParamAnalyzer(invokeExpr);

            // Compute cartesian product of params, creating models as we do so. If we can't model something, we
            // invalidate any param models that we created for this method already and return null
            Set<ArrayList<Object>> paramObjectCartesianProduct = paramAnalyzer.getParamCartesianProduct();
            
            // Store the class of each param for later invoke simulation
            ArrayList<Class> paramClasses = paramAnalyzer.getParamClasses();

            if (invokeExpr instanceof InstanceInvokeExpr){
              InstanceInvokeExpr iie = (InstanceInvokeExpr)invokeExpr;
              // get all the receivers and the models for them
              // if we can model a receiver and have the cartesian product of params, simulate the call
              // if we can model a receiver but don't have the cartesian product, then invalidate the receiver
              for (AllocNode node : GeoPTA.v().getPTSetContextIns(iie.getBase())) {
                ModeledClass modeledReceiverObject = am.createAndGetModel(node);
                if(modeledReceiverObject != null) {
                  if(paramObjectCartesianProduct != null){
                    // simulateInvokeExprEffects will simulate the call for each param permutation in paramObjectCartesianProduct
                    am.simulateInvokeExprEffects(modeledReceiverObject, modeledReceiverObject.getClass(), invokeExpr, 
                                                 paramObjectCartesianProduct, paramClasses);
                  } else {
                    // We couldn't model one of the arguments so we can't simulate the call and have to invalidate the receiver
                    modeledReceiverObject.invalidate();
                    // log the invalidation
                    try {
                      String logEntry = "Couldn't model every parameter for " + iie;
                      logEntry += "\n" + "> invalidating " + modeledReceiverObject + " as a result";
                      am.attrModelingTodoLog.write(logEntry + "\n");
                    } catch (IOException ioe) {}
                  }
                }
              }
            }
            else if (invokeExpr instanceof StaticInvokeExpr){
              try{
                // simulate the static call
                am.simulateInvokeExprEffects(null, Class.forName("droidsafe.model." + invokeExpr.getMethod().getDeclaringClass().getName()), invokeExpr, paramObjectCartesianProduct, paramClasses);
              } catch(Exception e) {
                try {
                  String logEntry = "Unable to simulate the static call " + invokeExpr;
                  am.attrModelingTodoLog.write(logEntry + "\n");
                } catch( IOException ioe) {}
                // if we are unable to simulate the static call, then invalidate all params
                am.invalidateParamObjects(paramObjectCartesianProduct);
              }
            } else {
              // we don't know what to do with methods that aren't static or instance invokes
              // log the lack of simulation
              try {
                am.invalidateParamObjects(paramObjectCartesianProduct);
                String logEntry = "Not simulating expression (isn't an instance invoke or static)" + invokeExpr;
                am.attrModelingTodoLog.write(logEntry + "\n");
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

  /**
   *  Invalidate any param that we modeled and log each invalidation.
   */
  public void invalidateParamObjects(Set<ArrayList<Object>> paramObjectCartesianProduct){  
    if(paramObjectCartesianProduct != null) {
      for (ArrayList paramObjectPermutation : paramObjectCartesianProduct){
        for (Object object : paramObjectPermutation){
          if(object instanceof ModeledClass){
            ModeledClass modeledObject = (ModeledClass)object;
            modeledObject.invalidate();
            try {
              String logEntry = "\n" + "> invalidating argument " + modeledObject + " as a result";
              this.attrModelingTodoLog.write(logEntry + "\n");
            } catch( IOException ioe) {}
          }
        }
      }
    }
  }

  /**
   * Calls the invokeExpr for every possible permutation of params.
   */
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
        String logEntry = "The method " + methodName + " in " + invokeExprClass + " hasn't been modeled: " + e.toString();

        // The method isn't modeled, so we must invalidate every argument that we modeled
        this.invalidateParamObjects(paramObjectCartesianProduct);

        // If this is an InstanceInvoke, also invalidate the receiver object
        if (modeledReceiverObject != null){
          modeledReceiverObject.invalidate();
          logEntry += "\n" + "> invalidating receiver" + modeledReceiverObject + " as a result";
        }
        this.attrModelingTodoLog.write(logEntry + "\n");
      } catch (IOException ioe) {}
    }
  }

  /**
   * Creates (if it does not yet exist) and returns our model
   * of the dynamic type of the AllocNode if it is modeled
   */
  private ModeledClass createAndGetModel(AllocNode allocNode) {

    //don't track values for alloc nodes we create
    if (AddAllocsForAPICalls.v().isGeneratedExpr(allocNode.getNewExpr())){
      try {
        String logEntry = "We created the allocNode and thus don't want to model " + allocNode;
        this.attrModelingTodoLog.write(logEntry + "\n");
      } catch (IOException ioe) {}
      return null;
    }
    
    if (!(allocNode.getType() instanceof RefType)){
      try {
        String logEntry = "Can't give model for allocNode (not a RefType) " + allocNode;
        this.attrModelingTodoLog.write(logEntry + "\n");
      } catch (IOException ioe) {}
     return null;
    }
    
    // We don't want to model things created in the harness 
    boolean exception = false;
    SootClass sootClass = ((RefType)allocNode.getType()).getSootClass();
    if (sootClass.hasSuperclass()){
      if(sootClass.getSuperclass().getName().equals("android.app.Activity")){
        exception = true;
      }
    } 
    if (!exception && allocNode.getMethod() != null && allocNode.getMethod().equals(Harness.v().getMain())) {
      try {
        String logEntry = "AllocNode is not an activity but came from the harness. Not modeling: " + allocNode;
        this.attrModelingTodoLog.write(logEntry + "\n");
      } catch (IOException ioe) {}
      return null;
    }
    
    ModeledClass model;
    if (!objectToModelMap.containsKey(allocNode)) {
      RefType refType = (RefType)allocNode.getType();
      Constructor<?> ctor;
      try {
        ctor = getDroidsafeClass(refType).getConstructor(AllocNode.class);
        model = (ModeledClass)ctor.newInstance(allocNode);
      } catch(Exception e) {
        try {
          String logEntry = "Couldn't model an instance of the " + refType.getSootClass().getName() + " class: " + e.toString();
          this.attrModelingTodoLog.write(logEntry + "\n");
        } catch (IOException ioe) {}
        return null;
      }
      objectToModelMap.put(allocNode, model);
    } else {

      model = objectToModelMap.get(allocNode);
    }
    return model;
  }

  private Class<?> getDroidsafeClass(RefType refType) throws ClassNotFoundException {
    
    SootClass sootClass = refType.getSootClass();
    String className = sootClass.getName();

    if(className.indexOf("Activity") != -1){
      className = "android.app.Activity";
    }
    
    return Class.forName("droidsafe.model." + className);
  }
  private void writeToToDoLog(String logEntry) {
    try {
      this.attrModelingTodoLog.write(logEntry);
    } catch (IOException ioe) {}
  }

  /*
   * Log the results of the modeling
   */
  private void log() {
    for (Map.Entry<AllocNode, ModeledClass> entry : objectToModelMap.entrySet()) {
      ModeledClass modeledObject = entry.getValue();
      logger.info("Finished Model: {}", modeledObject);
      logger.info("Corresponding AllocNode: {}", entry.getKey());
    }
  }

  //===================================================================================================================
  // Nested Classes
  //===================================================================================================================

  public class ParamAnalyzer { 
    //===================================================================================================================
    // Private Attributes
    //===================================================================================================================

    // All the possible permutations of params that the method can be called with. This analysis is flow
    // insensitive and thus we have to consider every permutation
    private Set<ArrayList<Object>> paramCartesianProduct;

    // The class of each param
    private ArrayList<Class> paramClasses;
    
    //===================================================================================================================
    // Constructors
    //===================================================================================================================

    private ParamAnalyzer(InvokeExpr invokeExpr) {
      int paramCount = invokeExpr.getArgCount(); 
      
      // Each index is the class of the param at that index
      this.paramClasses = new ArrayList<Class>(paramCount);

      List<Type> paramTypes = invokeExpr.getMethod().getParameterTypes();
      
      // Each index is a set of objects that the param at that index can possibly be 
      ArrayList<HashSet<Object>> paramObjectSets = new ArrayList<HashSet<Object>>();

      // Store the param object models so that we can later invalidate them if we haven't modeled the method
      ArrayList<ModeledClass> paramObjectModels = new ArrayList<ModeledClass>();
      
      // All this entire for loop does is fill in paramClasses and paramObjectSets. We may quit early if we are unable to
      // model any of the params. 
      for (int i = 0; i < paramCount; i++) {
        // Create a new set in which we'll put all possible objects that could be this param 
        paramObjectSets.add(i, new HashSet<Object>());

        Value arg = invokeExpr.getArg(i);
        // If the argument is a constant, we box it up. We don't model primitives.
        // If the argument is a RefType, then we use PTA to find all possible AllocNodes and their corresponding models
        // We can't simulate this invokeExpr if the argument doesn't fall in those two cases (yet)
        if(arg instanceof Constant) {
          if(arg instanceof NullConstant){
            try {
              try {
                paramClasses.get(i);
              } catch (IndexOutOfBoundsException e) {
                paramClasses.add(i, AttributeModeling.this.getDroidsafeClass((RefType)paramTypes.get(i)));
              }
            } catch(Exception e) {
              try {
                String logEntry = "Type of parameter #" + i + " of method " + invokeExpr + "isn't modeled yet: " + e.toString();
                AttributeModeling.this.attrModelingTodoLog.write(logEntry + "\n");
              } catch (IOException ioe) {}
              return;
            }
            paramObjectSets.get(i).add(null);
          } else {
            Object object;
            try {
              object = SootUtils.constantValueToObject(arg);
            } catch (ClassNotFoundException cnfe){
              AttributeModeling.this.writeToToDoLog("Couldn't convert constant value " + arg + " to object: " + cnfe + "\n");
              for(ModeledClass modeledObject : paramObjectModels){
                modeledObject.invalidate();
              }   
              return;
            }
            try {
              paramClasses.get(i);
            } catch(IndexOutOfBoundsException e) {
              paramClasses.add(i, object.getClass());
            }
            paramObjectSets.get(i).add(object);
          }
        } else if(arg.getType() instanceof RefType) {  
          // use PTA to find all possible AllocNodes and their corresponding models
          Set<AllocNode> allocNodeSet = GeoPTA.v().getPTSetContextIns(arg);
          if (allocNodeSet.size() != 0){
            for (AllocNode node : allocNodeSet) {
              ModeledClass modeledParamObject = createAndGetModel(node);
              if(modeledParamObject != null){
                paramObjectSets.get(i).add(modeledParamObject);
                try {
                  try {
                    paramClasses.get(i);
                  } catch (IndexOutOfBoundsException e) {
                    paramClasses.add(i, AttributeModeling.this.getDroidsafeClass((RefType)paramTypes.get(i)));
                  }
                } catch(ClassNotFoundException cnfe) {
                   AttributeModeling.this.writeToToDoLog("Couldn't getDroidsafeClass for arg " + arg); 
                  return;
                }
                // Store the param object model so that we can later invalidate it if we haven't modeled the method
                paramObjectModels.add(modeledParamObject);
              } else {
                // We couldn't model the argument node, so invalidate any param models we've already created
                for(ModeledClass modeledObject : paramObjectModels){
                  modeledObject.invalidate();
                }
                try {
                  String logEntry = "Couldn't model argument AllocNode " + node + " for method" + invokeExpr;
                  AttributeModeling.this.attrModelingTodoLog.write(logEntry + "\n");
                } catch (IOException ioe) {}
                return;
              }
            }
          } else {
            // log the problem
            try {
              String logEntry = "No AllocNodes were found by PTA for arg #" + i + " of instanceInvokeExpr " + invokeExpr;
              AttributeModeling.this.attrModelingTodoLog.write(logEntry + "\n");
            } catch(IOException ioe){}
            // invalidate any param models we've already created
            for(ModeledClass modeledObject : paramObjectModels){
              modeledObject.invalidate();
            }
            return;
          }
        } else {
          // log the problem
          try {
            String logEntry = "Arg #" + i + " of method " + invokeExpr + " isn't a constant or a RefType. Not sure what to do - invalidating other params and not simulating the call.";
            AttributeModeling.this.attrModelingTodoLog.write(logEntry + "\n");
          } catch (IOException ioe) {}
          // invalidate any param models we've already created
          for(ModeledClass modeledObject : paramObjectModels){
            modeledObject.invalidate();
          }
          return;
        }
      }
      
      // What are all the possible ways in which the method can be called now that we know all possible params
      this.paramCartesianProduct = cartesianProduct(0, paramObjectSets);
    }

    //===================================================================================================================
    // Getters & Setters
    //===================================================================================================================
    
    public Set<ArrayList<Object>> getParamCartesianProduct(){
      return this.paramCartesianProduct;
    }

    public ArrayList<Class> getParamClasses(){
      return this.paramClasses;
    }
  }  
}
