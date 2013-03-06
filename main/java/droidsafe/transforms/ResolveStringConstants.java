package droidsafe.transforms;

import droidsafe.android.app.Harness;
import droidsafe.android.app.Project;
import droidsafe.android.app.Project;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.resources.RString;
import droidsafe.android.app.resources.RStringArray;
import droidsafe.android.system.API;

import droidsafe.transforms.AddAllocsForAPICalls;

import droidsafe.utils.SootUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;

import soot.Body;
import soot.Body;

import soot.BodyTransformer;
import soot.BodyTransformer;

import soot.jimple.ArrayRef;
import soot.jimple.AssignStmt;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Jimple;
import soot.jimple.NewArrayExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.StringConstant;

import soot.RefLikeType;

import soot.RefType;

import soot.Scene;

import soot.SootClass;

import soot.SootField;

import soot.SootMethod;

import soot.tagkit.IntegerConstantValueTag;
import soot.tagkit.Tag;

import soot.Type;

import soot.util.Chain;

import soot.Value;


/**
 * Transformation called on all application classes that finds all invocations of "getString(int resId)"
 * and "getText(int resId)" from android.content.Context and replaces them with the string values that they would have
 * returned.
 * TODO: add support for calls to getString and getText that take in formatArgs
 */
public class ResolveStringConstants extends BodyTransformer {

  private static final Logger logger = LoggerFactory.getLogger(ResolveStringConstants.class);	

  // id to name map used for both strings and string-arrays 
  private static HashMap<Integer, String> stringIdToStringName;

  
  public static void run(String application_base_path) {
    
    // Check to see if the application defines any subclasses of android.content.res.Resources. We consider this
    // malware   
    for (SootClass clazz : Scene.v().getApplicationClasses()) {
    	if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
    	  continue;
    	
      //don't add entry points into the system classes...
      if (API.v().isSystemClass(clazz))
    	  continue;

      // does the class subclass andorid.content.res.Resources? If so, exit.
      Set<SootClass> parents = SootUtils.getParents(clazz);
      for (SootClass parent : parents) {
        if(parent.getName().equals("android.content.res.Resources")) {
          logger.error("Found class that inherits from android.content.res.Resources: {}", clazz);
          System.exit(1);
        }
      }
		}
		
    // create a mapping from string ids to string names
    stringIdToStringName = new HashMap<Integer, String>();
		for (SootClass clz : Scene.v().getClasses()) {
      if (clz.isApplicationClass() & clz.getShortName().startsWith("R$string")) {
				System.out.println(clz.getShortName());
        for (SootField field : clz.getFields()) {
          Tag tag = field.getTag("IntegerConstantValueTag");
          Integer stringId = ((IntegerConstantValueTag)tag).getIntValue();
          String stringName = field.getName();
          stringIdToStringName.put(stringId, stringName);
				}
			} else {
        if(clz.getShortName().startsWith("R$array")) {
          for (SootField field : clz.getFields()) {
            Tag tag = field.getTag("IntegerConstantValueTag");
            Integer stringId = ((IntegerConstantValueTag)tag).getIntValue();
            String stringArrayName = field.getName();
            stringIdToStringName.put(stringId, stringArrayName);
				  }
        }
      }
		}
    
    // call the transformation on each method 
    ResolveStringConstants transformer = new ResolveStringConstants();
		for (SootClass clz : Scene.v().getClasses()) {
			if (Project.v().isAppClass(clz.toString())) {
				for (SootMethod meth : clz.getMethods()) {
					if (meth.isConcrete())
						transformer.transform(meth.retrieveActiveBody());
				}
			}
		}
	}
	

	protected void internalTransform(Body b, String phaseName, Map options)  {
		StmtBody stmtBody = (StmtBody)b;
		Chain units = stmtBody.getUnits();

    // need a snapshot iterator since we want to mutate while iterating
		Iterator stmtIt = units.snapshotIterator();

    // Get the data from parsed resource files
    Resources resources = Resources.v();
    HashMap<String, RString> stringNameToRString = resources.getStringNameToRStringHashMap();
    HashMap<String, RStringArray> stringArrayNameToRStringArray = resources.getStringArrayNameToRStringArrayHashMap();

    while (stmtIt.hasNext()) {
			Stmt stmt = (Stmt)stmtIt.next();

      // we only care about invoke expressions
      if (!stmt.containsInvokeExpr()) {
				continue;
			}

      InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
      SootMethod target = getTarget(expr);

      // we're at jimple's level so everything should be an AssignStmt      
      AssignStmt assignStmt = null;
      if(stmt instanceof AssignStmt) {
        assignStmt = (AssignStmt)stmt;
      }else{
        continue;
      }
      
      // If there is no target, skip the current statement. However, there should always be a target
      if(target == null) {
        continue; 
      }
      
      // Replace calls to getString and getText from android.content.Context and android.content.res.Resources with
      // values. The android.content.Context calls simply call the same methods in android.content.res.Resources but
      // are final
      if(((target.getDeclaringClass().toString().equals("android.content.Context")) ||
         (target.getDeclaringClass().toString().equals("android.content.res.Resources"))) &&
         (target.getName().equals("getString") || target.getName().equals("getText"))) {
        
        // Only handling calls to getString and getText that take in one IntConstant argument
        if(expr.getArgCount() == 1) {
          Value arg = expr.getArg(0);
          if (arg instanceof IntConstant){
            // Get the string id and the string value with which we'll replace it
            Integer stringId = new Integer(((IntConstant)arg).value);
            String stringName = stringIdToStringName.get(stringId);
            // continue only if we have the string name
            if(stringName != null){
              RString rString = stringNameToRString.get(stringName);
              if (rString != null) {
                String stringValue = rString.value;
                // continue only if we have the string value
                if (stringValue != null) {
                  // replace the virtual invoke statement with the string value
                  logger.info("ResolveStringConstants: replacing {} with {}", stringId, stringValue);
                  assignStmt.setRightOp(StringConstant.v(stringValue));
                }
              }
            }
          }
        }
      } else {
        // Replace calls to getStringArray from android.content.res.Resources
        if(target.getDeclaringClass().toString().equals("android.content.res.Resources") &&
           target.getName().equals("getStringArray")) {
          
          // Only handling calls to getStringArray that take in one IntConstant argument  
          if(expr.getArgCount() == 1) {
            Value arg = expr.getArg(0);
            if (arg instanceof IntConstant){
              // get the string array id and the list of string values
              Integer stringId = new Integer(((IntConstant)arg).value);
              String stringArrayName = stringIdToStringName.get(stringId);
              // continue only if we have the string array name 
              if (stringArrayName != null) {
                RStringArray rStringArray = stringArrayNameToRStringArray.get(stringArrayName);
                if (rStringArray != null) {
                  List<String> stringArrayValues = rStringArray.value;
                  // continue only if we have the string array value
                  if (stringArrayValues != null) {
                    // replace the the virtual invoke statement with an array definition and fill in all the string values
                    logger.info("ResolveStringConstants: replacing {} with {}", stringId, Arrays.toString(stringArrayValues.toArray()));
                    ArrayType type = ArrayType.v(RefType.v("java.lang.String"), 1);
                    NewArrayExpr arrayExpr = Jimple.v().newNewArrayExpr(type, IntConstant.v(stringArrayValues.size()));
				            assignStmt.setRightOp(arrayExpr);
				            for(int k = 0; k < stringArrayValues.size(); ++k) {
                      String stringArrayValue = stringArrayValues.get(k);
                      ArrayRef arrayRef = Jimple.v().newArrayRef(assignStmt.getLeftOp(), IntConstant.v(k));
                      AssignStmt arrayAssignStmt = Jimple.v().newAssignStmt(arrayRef, StringConstant.v(stringArrayValue));
                      units.insertAfter(arrayAssignStmt, stmt);
                    }
                  }
                }
              }
            }
          }
        }
      }
		}
	}
 

  /**
   * getTarget is a private method copied from AddAllocsForAPICalls.java
   * TODO: have Michael decide what to do about this method.
   */
  private SootMethod getTarget(InvokeExpr expr) {
		if (expr instanceof InstanceInvokeExpr) {
			InstanceInvokeExpr iie = (InstanceInvokeExpr)expr;
			if (iie.getBase().getType() instanceof RefLikeType)  {
				Type recType = SootUtils.getBaseType((RefLikeType)iie.getBase().getType());
				if (recType instanceof RefType) {
					RefType recRefType = (RefType)recType;
					SootClass recClass = recRefType.getSootClass();
					//we have found a type for the receiver that we can handle
					//if it is an abstract or interface, then just return the abstract method
					//all we care about is the return type
					if (recClass.isInterface() || recClass.isAbstract()) {
						return expr.getMethod();
					} else  {//if concrete, then try to find the exact method, but who really cares, we just need the 
						//return type
						return Scene.v().getActiveHierarchy().resolveConcreteDispatch( recRefType.getSootClass(), expr.getMethod());
					}
				}
			}
		} else if (expr instanceof StaticInvokeExpr) {
			return ((StaticInvokeExpr)expr).getMethod();
		} else {
      logger.error("Unknown invoke expr {}", expr);
			System.exit(1);
		}
		return null;
	}
}
