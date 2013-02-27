package droidsafe.transforms;

import java.io.File;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import droidsafe.android.app.Project;
import droidsafe.transforms.AddAllocsForAPICalls;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
import soot.jimple.ArrayRef;
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
import soot.jimple.NewArrayExpr;
import soot.util.Chain;
import droidsafe.android.app.Project;
import droidsafe.android.system.API;
import droidsafe.utils.SootUtils;
import droidsafe.android.app.Harness;
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

  public static final boolean DEBUG = true;
  public static final boolean STRING_ARRAYS = true;

  private static final Logger logger = LoggerFactory.getLogger(ResolveStringConstants.class);	

  private static HashMap<Integer, String> stringIdToStringName;
  private static HashMap<String, String> stringNameToStringValue;
  private static HashMap<String, List<String>> stringArrayNameToStringArrayValues;	

  public static void run(String application_base_path) {
    
    for (SootClass clazz : Scene.v().getApplicationClasses()) {
    	if (clazz.isInterface() || clazz.getName().equals(Harness.HARNESS_CLASS_NAME))
    	  continue;
    	
      //don't add entry points into the system classes...
      if (API.v().isSystemClass(clazz))
    	  continue;

      // does the class subclass res
      Set<SootClass> parents = SootUtils.getParents(clazz);
      for (SootClass parent : parents) {
        if(parent.getName().equals("android.content.res.Resources")) {
          logger.error("Found class that inherits from android.content.res.Resources: {}", clazz);
          System.exit(1);
        }
      }
		}

    // create a mapping from string names to string values
    stringNameToStringValue = new HashMap<String, String>();
    stringArrayNameToStringArrayValues = new HashMap<String, List<String>>();
    String[] filesToProcess = {"res/values/strings.xml", "res/values/arrays.xml"};
    for (String fileToProcess : filesToProcess) {
      File stringXmlFile = new File(fileToProcess);
    
      Layout layout = null;
      try {
        layout = new Layout(stringXmlFile);
      } catch (Exception e) {
        logger.error("Could not parse " + stringXmlFile + ":" + e.getMessage());
        continue;
      }
      List<Node> children = layout.view.gather_children();
      for(int i = 0; i < children.size(); ++i){
        Element element = (Element)children.get(i);
        String tagName = element.getTagName();
        if (tagName.equals("string")){
          String stringName = element.getAttribute("name");
          String stringValue = element.getFirstChild().getNodeValue();
          if(DEBUG){
            System.out.println("\nAdding a string name to string value mapping:");
            System.out.println("String Name: " + stringName);
            System.out.println("String Value: " + stringValue);
          }
          stringNameToStringValue.put(stringName, stringValue);
        } else if(tagName.equals("string-array") && STRING_ARRAYS){
          String stringArrayName = element.getAttribute("name");
          NodeList stringArrayNodes = element.getChildNodes();
          List<String> stringArrayValues = new ArrayList<String>();
          for (int j = 0; j < stringArrayNodes.getLength(); ++j) {
            Node child = stringArrayNodes.item(j);
            if(child instanceof Element){
              Element elementChild = (Element)child;
              String stringArrayValue = ((Element)child).getFirstChild().getNodeValue();
              int index = stringArrayValue.indexOf("@string");
              if(index != -1){
                String stringName = stringArrayValue.substring("@string".length()+1, stringArrayValue.length());
                if(stringNameToStringValue.containsKey(stringName)){
                  stringArrayValue = stringNameToStringValue.get(stringName);
                }
              }
              stringArrayValues.add(stringArrayValue);
            }
          }
          if(DEBUG){
            System.out.println("\nAdding a string array name to string array value mapping:");
            System.out.println("String Array Name: " + stringArrayName);
            System.out.println("String Array Values: ");
            for(String stringArrayValue : stringArrayValues){
              System.out.println(stringArrayValue);   
            }
          }
          stringArrayNameToStringArrayValues.put(stringArrayName, stringArrayValues);
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
          if(DEBUG){
            System.out.println("\nAdding a string id to string name mapping:");
            System.out.println("String Id: " + stringId);
            System.out.println("String Name: " + stringName);
          }
          stringIdToStringName.put(stringId, stringName);
				}
			} else {
        if(clz.getShortName().startsWith("R$array")) {
          for (SootField field : clz.getFields()) {
            Tag tag = field.getTag("IntegerConstantValueTag");
            Integer stringId = ((IntegerConstantValueTag)tag).getIntValue();
            String stringArrayName = field.getName();
            if(DEBUG){
              System.out.println("\nAdding a string id to string array name mapping:");
              System.out.println("String Id: " + stringId);
              System.out.println("String Array Name: " + stringArrayName);
            }
            stringIdToStringName.put(stringId, stringArrayName);
				  }
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
      if(((target.getDeclaringClass().toString().equals("android.content.Context")) ||
         (target.getDeclaringClass().toString().equals("android.content.res.Resources"))) &&
         (target.getName().equals("getString") || target.getName().equals("getText"))) {
          if(expr.getArgCount() == 1) {
            Value arg = expr.getArg(0);
            if (arg instanceof IntConstant){
              Integer stringId = new Integer(((IntConstant)arg).value);
              String strVal = stringNameToStringValue.get((stringIdToStringName.get(stringId)));
              if (strVal != null) {
                if(DEBUG){
                  System.out.println("\nReplacing " + stringId + " with " + strVal);
                  System.out.println("Right Op: " + assignStmt.getRightOp());
                  System.out.println("Left Op: " + assignStmt.getLeftOp());
                }
                assignStmt.setRightOp(StringConstant.v(strVal));
              }
            }
          }
      } else if(target.getDeclaringClass().toString().equals("android.content.res.Resources") &&
                target.getName().equals("getStringArray")) {
        if(expr.getArgCount() == 1) {
          Value arg = expr.getArg(0);
          if (arg instanceof IntConstant){
            Integer stringId = new Integer(((IntConstant)arg).value);
            String stringArrayName = stringIdToStringName.get(stringId);
            if (stringArrayName != null) {
              List<String> stringArrayValues = stringArrayNameToStringArrayValues.get(stringArrayName);
              if (stringArrayValues != null) {
                if(DEBUG){
                  System.out.println("\nReplacing " + stringId + " with: ");
                  for(String stringArrayValue : stringArrayValues){
                    System.out.println(stringArrayValue);
                  }
                  System.out.println("Right Op: " + assignStmt.getRightOp());
                  System.out.println("Left Op: " + assignStmt.getLeftOp());
                }
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
