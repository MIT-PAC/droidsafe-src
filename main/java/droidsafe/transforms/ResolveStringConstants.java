package droidsafe.transforms;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import droidsafe.android.app.Project;
import droidsafe.transforms.AddAllocsForAPICalls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import soot.ArrayType;
import soot.Body;
import soot.BodyTransformer;
import soot.Hierarchy;
import soot.Local;
import soot.Modifier;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.SootField;
import soot.Value;
import soot.Type;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.NewExpr;
import soot.jimple.StaticInvokeExpr;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.jimple.internal.JAssignStmt;
import soot.util.Chain;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import droidsafe.android.app.resources.Layout;
import droidsafe.android.app.resources.BaseElement;
import soot.tagkit.Tag;
import soot.tagkit.IntegerConstantValueTag;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;



import soot.Body;
import soot.BodyTransformer;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.InvokeExpr;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.IntConstant;
import soot.jimple.StringConstant;
import soot.toolkits.graph.PseudoTopologicalOrderer;
import soot.util.Chain;


/**
 * Transformation called on all application classes that finds all invocations of "getString(int resId)"
 * and "getText(int resId)" from android.content.Context and replaces them with the string values that they would have
 * returned.
 */
public class ResolveStringConstants extends BodyTransformer {

  private static final boolean DEBUG = true;
  private static final Logger logger = LoggerFactory.getLogger(ResolveStringConstants.class);	

  private static HashMap<Integer, String> resourceIdToResourceName;
  private static HashMap<String, String> resourceNameToResourceValue;
	

  public static void run(String application_base_path) {
    
    // create a mapping from string names ot string values
    resourceNameToResourceValue = new HashMap<String, String>();
    File stringXmlFile = new File("res/values/strings.xml");
    Layout layout = null;
    try {
        layout = new Layout(stringXmlFile);
    } catch (Exception e) {
        logger.error("Could not parse string.xml: " + e.getMessage());
        return;
    }
    List<Node> children = layout.view.gather_children();
    for(int i = 0; i < children.size(); ++i){
      Node child = children.get(i);
      String resourceName = ((Element)child).getAttribute("name");
      String resourceValue = child.getFirstChild().getNodeValue();
      if(DEBUG){
        System.out.println("\nAdding a resource name to resource value mapping:");
        System.out.println("Key: " + resourceName);
        System.out.println("Value: " + resourceValue);
      }
      resourceNameToResourceValue.put(resourceName, resourceValue);
    }
  
		// create a mapping from string ids to string names
    resourceIdToResourceName = new HashMap<Integer, String>();
		for (SootClass clz : Scene.v().getClasses()) {
      if (clz.isApplicationClass() & clz.getShortName().startsWith("R$string")) {
				for (SootField field : clz.getFields()) {
          Tag tag = field.getTag("IntegerConstantValueTag");
          Integer resourceId = ((IntegerConstantValueTag)tag).getIntValue();
          String resourceName = field.getName();
          if(DEBUG){
            System.out.println("\nAdding a resource id to resource name mapping:");
            System.out.println("Key: " + resourceId);
            System.out.println("Value: " + resourceName);
          }
          resourceIdToResourceName.put(resourceId, resourceName);
				}
			}
		}
      
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

		while (stmtIt.hasNext()) {
			Stmt stmt = (Stmt)stmtIt.next();
			// we only care about invoke expressions
      if (!stmt.containsInvokeExpr()) {
				continue;
			}
			InvokeExpr expr = (InvokeExpr)stmt.getInvokeExpr();
      SootMethod target = getTarget(expr);
      
      AssignStmt assignStmt = null;
      if(stmt instanceof AssignStmt) {
        assignStmt = (AssignStmt)stmt;
      }else{
        continue;
      }
      
      // there should always be a target
      if(target == null) {
        continue; 
      }
      
      // For now we only target "getString" and "getText" in "android.contet.Context"
      if(target.getDeclaringClass().toString().equals("android.content.Context") &&
        (target.getName().equals("getString") || target.getName().equals("getText"))) {
          if(expr.getArgCount() == 1) {
            Value arg = expr.getArg(0);
            if (arg instanceof IntConstant){
              Integer stringId = new Integer(((IntConstant)arg).value);
              String strVal = resourceNameToResourceValue.get((resourceIdToResourceName.get(stringId)));
              if(DEBUG){
                System.out.println("\nReplacing " + stringId + " with " + strVal);
                System.out.println("Right Op: " + assignStmt.getRightOp());
                System.out.println("Left Op: " + assignStmt.getLeftOp());
              }
              assignStmt.setRightOp(StringConstant.v(strVal));
            }
          }
      }
		}
	}
 

  /**
   * getTarget is a private method copied from AddAllocsForAPICalls.java
   * TODO: Perhaps we should move it out SootUtils or something similar
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
