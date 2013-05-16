/*
 * This class contains soot objects that will be used in XML replacement 
 */
package droidsafe.android.app.resources;

import com.google.common.collect.HashBiMap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import droidsafe.android.app.Project;
import droidsafe.main.Config;
import droidsafe.speclang.ArgumentValue;
import droidsafe.speclang.Method;
import droidsafe.speclang.TypeValue;

import soot.Body;
import soot.AnySubType;
import soot.ArrayType;
import soot.BooleanType;
import soot.ByteType;
import soot.CharType;
import soot.DoubleType;
import soot.FloatType;
import soot.Hierarchy;
import soot.IntType;
import soot.LongType;
import soot.NullType;
import soot.PrimType;
import soot.Printer;
import soot.RefLikeType;
import soot.RefType;
import soot.Scene;
import soot.ShortType;
import soot.SootClass;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.Modifier;
import soot.SootField;
import soot.Scene;
import soot.Local;
import soot.RefType;

import soot.util.HashChain;
import soot.PatchingChain;
import soot.jimple.FieldRef;  
import soot.jimple.Expr;
import soot.jimple.ConditionExpr;
import soot.jimple.Constant;
import soot.jimple.StringConstant;
import soot.jimple.IdentityStmt;
import soot.jimple.DoubleConstant;
import soot.jimple.FloatConstant;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.LongConstant;
import soot.jimple.NullConstant;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.JimpleBody;
import soot.tagkit.LineNumberTag;
import soot.util.Chain;
import soot.util.JasminOutputStream;


import droidsafe.utils.SootUtils;

public class ResourcesSoot {

    /**
    * Inner class holding UISoot object used for lookup.  We will have a table of id->UISootObject
	* mapping that will allow us to do cross reference between ID and (methods, object, text)
    */
    public class UISootObject {
        public int          numericId;
        public String       stringId;
        public String       type;
        public String       text;
		public List<String> textList;
		public Map<String, String> attributes;
        public SootField    sootField;
        public SootMethod   lookupMethod;

        public UISootObject() {
            numericId = 0;
            stringId   = "unknown";
            type = "unkownType";
            text = "";
            sootField    = null;
            lookupMethod = null;
			attributes = null;
        }

        public UISootObject(int numId, String type, String strId, List<String> textValues, SootField sf) {
            numericId = numId;
            stringId  = strId;
            this.textList = textValues;
            this.type = type;
            sootField = sf;
        }

		public UISootObject(int numId, String type, String strId, Map<String, String> attrs) {
            this.numericId = numId;
            this.stringId  = strId;
            this.type = type;
			this.attributes = attrs;
        }

    }

    private final static Logger logger = LoggerFactory.getLogger(ResourcesSoot.class);  

    /* Object factory */
    private static  ResourcesSoot instance = new ResourcesSoot();
    public static ResourcesSoot v() { return instance; }

    private SootClass  mSootClass;	   //class that holds all methods
    private SootMethod mClinitMethod;  //clinit method
    private JimpleBody mClinitBody;
    private SootMethod mSetActivityMethod; 

    private SootField  mActivityField;
	private SootClass  mViewClass;   
	private SootClass  mTextViewClass;  //TextViewClass can call setText
	private SootMethod mSetTextMethod;
	private SootMethod mViewInitMethod;

    private HashMap<Integer, UISootObject> uiObjectTable; 

    private HashBiMap<Integer, String> numericToStringIDMap;
	private Map<String, Set<RString>> stringToValueSet;

    private ResourcesSoot() {

        uiObjectTable = new HashMap<Integer, UISootObject>();

        mSootClass = new SootClass("droidsafe.android.ResourcesSoot", Modifier.PUBLIC);
    //  mSootClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
        Scene.v().addClass(mSootClass);

        mActivityField = new SootField("currentActivity", RefType.v("android.app.Activity"), Modifier.PUBLIC | Modifier.STATIC);
        mSootClass.addField(mActivityField);
        mSootClass.setApplicationClass();

		mViewClass     = Scene.v().getSootClass("android.view.View");
		mTextViewClass = Scene.v().getSootClass("android.widget.TextView");
		mSetTextMethod = Scene.v().getMethod("<android.widget.TextView: void setText(java.lang.CharSequence)>");
		mViewInitMethod = Scene.v().getMethod("<android.view.View: void <init>(android.content.Context)>");
    }

    // get numericID -> string ID mapping
    public void setNumberToStringMap(HashBiMap<Integer, String> map) {
        numericToStringIDMap = map;
    }

	// get stringID => list of possible values
	public void setStringToValueSetMap(Map<String, Set<RString>> map) {
		stringToValueSet = map;	
	}

	/**
    * addView:
    *   function to add a view info into uiObjectTable and create a static for use by the
    *   IntegrateXMLLayout transformation.
    */
    public void addView(String type, String strId, Map<String, String> attrMap) {
        // adding ui object (partial information, no numeric ID, no soot method)  
        // to the list of UI objects 

        // First time initializing, we will add the clinit method.  <clinit> method
        // CANNOT be empty, so we only add it when there is at least a static member
        // if (uiObjectTable.isEmpty()) {
        //  addClinitMethod();
        // }

		if(strId == null || type == null) {
			logger.warn("addView type:{}, id:{}", type, strId);
		} else {
			logger.info("addView type:{}, id:{}", type, strId);
		}

		strId = strId.replace("@android:", "");
        Integer id = numericToStringIDMap.inverse().get(strId);

		if (id == null) {
			logger.warn("lookup id {} => {} ", strId, id);
			return;
		}

        if (uiObjectTable.get(id) == null) {
            UISootObject obj = new UISootObject(id.intValue(), type, strId, attrMap);
            uiObjectTable.put(id, obj);

			//create a static field 
            createViewMember(id);

			// create method getView_XYX()
            addGetView_ID(id);
        }
    }



    /**
    * addView:
    *   function to add a view info into uiObjectTable and create a static for use by the
    *   IntegrateXMLLayout transformation.
    */
	/*
    public void addView(String type, String strId, List<String> textList) {
        // adding ui object (partial information, no numeric ID, no soot method)  
        // to the list of UI objects 

        // First time initializing, we will add the clinit method.  <clinit> method
        // CANNOT be empty, so we only add it when there is at least a static member
        // if (uiObjectTable.isEmpty()) {
        //  addClinitMethod();
        // }

		if(strId == null || type == null) {
			logger.warn("addView type:{}, id:{}", type, strId);
		} else {
			logger.info("addView type:{}, id:{}", type, strId);
		}

		strId = strId.replace("@android:", "");

        Integer id = numericToStringIDMap.inverse().get(strId);

		if (id == null) {
			logger.warn("lookup id {} => {} ", strId, id);
			return;
		}

        if (uiObjectTable.get(id) == null) {
            UISootObject obj = new UISootObject(id.intValue(), type, strId, textList, null);
            uiObjectTable.put(id, obj);

			//create a static field 
            createViewMember(id);

			// create method getView_XYX()
            addGetView_ID(id);
        }
    }
	*/


    /**
    * createViewMember:
    *   method to add static Button button_xxyyyy to the ResourcesSoot class
    */
    private void createViewMember(Integer intId) {
        logger.info("calling createViewMember {}:{}) ", 
					intId.toString(), String.format("%x", intId));

        UISootObject obj = uiObjectTable.get(intId);    
        if (obj == null) {
            logger.warn("Object for id {} info is not available", intId);
            return; 
        }

        String   idName    = makeIdName(obj.type, obj.numericId); 
        String   className = makeClassName(obj.type);

		if (className == null) {
            logger.warn("Cannot resolve class {} ", obj.type);
			return;
		}

        RefType  classType = RefType.v(className); 

        // step 1: create sootfield for member variable
        SootField sf = new SootField(idName, classType, Modifier.PUBLIC | Modifier.STATIC);
        mSootClass.addField(sf);
        obj.sootField = sf;
    }

    /**
    * lookupGetView_ID:
    *   Method to look up the getView_2222()
    */
    public SootMethod lookupGetView_ID(Integer intId) {
        logger.info("calling lookupGetView_ID {}) ", intId.toString());
        UISootObject obj = uiObjectTable.get(intId);    
        if (obj == null) {
            logger.warn("Object for id 0x{} info is not available", 
						String.format("%x", intId));
            return null; 
        }
        return obj.lookupMethod; 
    }

    /**
    * addGetView:
    *       - method to add getView_XYX(content) to the droidsafe.android.ResourcesSoot 
    */
    private void addGetView_ID(Integer intId) {
        // units.add(Jimple.v().newAssignStmt(fieldRef, arg));

        UISootObject obj = uiObjectTable.get(intId);    
        logger.info("calling addGetView_ID({}:{}) ", intId.toString(),	String.format("%x", intId));

        if (obj == null) {
            logger.warn("Object for id {} does not exist ", intId);
            return;
        }
		if (obj.sootField == null)  {
            logger.warn("No sootfield previously created ");;
			return;
		}

        List params = new LinkedList<Type>();
        params.add(RefType.v("android.app.Activity"));

        RefType returnType = (RefType) obj.sootField.getType(); 

		SootMethod viewInitMethod = Scene.v().getActiveHierarchy().resolveConcreteDispatch(returnType.getSootClass(), mViewInitMethod);

		if (viewInitMethod == null) {
			logger.warn("Cannot locate proper constructor for {})", returnType);
			return;
		}

        String funcName = "getView_" + String.format("%x", intId);
        //instantiate a method
        SootMethod method = new SootMethod(funcName, params, returnType, 
                                        Modifier.PUBLIC | Modifier.STATIC);

        obj.lookupMethod = method;

        // add the method to the class
        mSootClass.addMethod(method);

        // create active body, and set the body active
        JimpleBody body = Jimple.v().newBody(method);
        method.setActiveBody(body);

        Chain units = body.getUnits();

        // extract parameter
        Local argActivity = Jimple.v().newLocal("paramActivity",  RefType.v("android.app.Activity"));

        // android.app.Activity paramActivity;
        body.getLocals().add(argActivity);

        // local Argument for view
        Local localView = Jimple.v().newLocal("localView",  returnType);
        body.getLocals().add(localView);

        // paramActivity = @paramter0
        units.add(Jimple.v().newIdentityStmt(argActivity,
                         Jimple.v().newParameterRef(RefType.v("android.app.Activity"), 0)));

        FieldRef  fieldRef = Jimple.v().newStaticFieldRef(obj.sootField.makeRef());

        // localView =  fieldRef
        units.add(Jimple.v().newAssignStmt(localView, fieldRef));

        // beforeIF block
        Stmt beforeIf = (Stmt) units.getLast();

        // IF block: adding more code for if block
        Expr newExpr = Jimple.v().newNewExpr((RefType)returnType);

        units.add(Jimple.v().newAssignStmt(localView, newExpr));

        units.add(Jimple.v().newInvokeStmt(
                    Jimple.v().newVirtualInvokeExpr(localView, viewInitMethod.makeRef(), 
                                argActivity))); 

		for (String attrName: obj.attributes.keySet()) {
			SootMethod setter = AttributeSetterMap.v().resolveSetter(
									attrName, returnType.getSootClass());

			// if there is no setter match, skip the attribute
			if (setter == null) {
				// logger.debug("attr {}, class {} CANNOT resolve ", 
				// 			attrName, returnType.getSootClass());
				continue;
			} 

			// at this point, we have a setter, need to call the setter with values
			logger.debug("attr {} => setter {} ", attrName, setter);

			String attrValue = obj.attributes.get(attrName);

			//TODO: need to normalize the name/params
			if (attrValue.contains("@")) {
				int ind = attrValue.indexOf("@");
				String stringName = attrValue.substring(ind+1);
				stringName = stringName.replace("/", ".");

				logger.debug("Need to expand {} ", stringName);

				if (stringToValueSet.containsKey(stringName)) {
					logger.warn("{} can be expanded ", stringName);	
					Set<RString> rstringList = stringToValueSet.get(stringName);
					Set<String> textSet = new HashSet<String>();

					/* set will keep it unique, remove duplicate entries */
					for (RString rstring: rstringList) {
						if (rstring == null || rstring.value == null)
							continue;
						textSet.add(rstring.value);
					}

					for (String text: textSet) {
						Expr settingExpr = Jimple.v().newVirtualInvokeExpr(localView, setter.makeRef(),
								StringConstant.v(text)); 
						Stmt settingStmt = Jimple.v().newInvokeStmt(settingExpr);
						logger.info("text <{}> ", text);
						logger.info("settingText expr {} ", settingExpr);
						logger.info("settingStmt stmt {} ", settingStmt);
						units.add(settingStmt); 


					}
				}
			}
		}

        units.add(Jimple.v().newAssignStmt(fieldRef, localView));
         
        // afterIF: return localView
        Stmt afterIf = Jimple.v().newReturnStmt(localView);
        units.add(afterIf);

        // condition expression and statement (not equal expr)
        ConditionExpr condExpr = Jimple.v().newNeExpr(localView, NullConstant.v());

        // condition statement
        Stmt condStmt =  Jimple.v().newIfStmt(condExpr, afterIf);

        logger.debug("condStmt {} ", condStmt);
        units.insertAfter(condStmt, beforeIf);
    }
    


    /*****************************************************************************
    *                               Utility/helper Functions 
    ******************************************************************************/
    private String makeIdName(String type, int numId) {
        String[] tokens = type.split("[.]", 8);
        
        String shortType = type;
        if (tokens.length > 1)
            shortType = tokens[tokens.length - 1];

        StringBuilder builder = new StringBuilder(shortType);
        builder.append("_").append(String.format("%x", numId));
        return builder.toString();
    }

    /*
     * 
     */
    private String makeClassName(String className) {
        String[] tokens = className.split("[.]", 8);
        /* if the name already contains full qualified path, keep it */

        if (tokens.length > 1)
            return className;

        String name = className;

		if (name.equals("View")) {
			return "android.view.View";
		}

        StringBuilder builder = new StringBuilder("android.widget.");

		builder.append(name.charAt(0));

		if (name.length() > 1)
			builder.append(name.substring(1));

        String fullName = builder.toString();

		logger.info("Trying to locatate {} class ", fullName);
		if (Scene.v().containsClass(fullName))
		{
			logger.info("Found class {} ", fullName);
			return fullName;
		}

		logger.info("class {} NOT Found ", fullName);
		logger.info("Trying to match class {} NOT Found ", className);

		// Now we are trying to match
		List<SootClass> classes = SootUtils.matchShortName(name);

		for (SootClass sootClass: classes) {
			logger.info("matching {} ", sootClass);
			if (SootUtils.checkAncestor(sootClass, mViewClass)) {
				logger.info("soot class {} is a view ", sootClass);
				return sootClass.toString();
			}
		}
		return null;
    }

    /**
    * Write to the file
    */
    public void writeFile(String dir)  {
    	
        String filePath = dir + File.separator + mSootClass.toString();
		PrintWriter writer;
	
		try {
			writer = new PrintWriter(filePath + "_steps.jimple");
		}
		catch (Exception ex) {
			logger.warn("Cannot open file {} ", filePath);
			return;
		}

		writer.printf("class %s { \n", mSootClass.toString());
		writer.println("");
		 
		logger.info("fields ");
		for (SootField field : mSootClass.getFields()) {
			logger.info("field {} ", field);	
			writer.printf("\t%s %s \n", Modifier.toString(field.getModifiers()), field);
		}

		logger.info("methods ");
		writer.println("");
		for (SootMethod method: mSootClass.getMethods()) {
			Body body = method.getActiveBody();

			logger.info("====== method {} ======== ", method);	
			writer.printf("\t%s %s { \n", 
					Modifier.toString(method.getModifiers()), method);

			for (Local local: body.getLocals()) {
				logger.info("{}", local);
				writer.printf("\t\t%s %s \n", local.getType(), local);
			}

			writer.println("");
			Chain<Unit> units = body.getUnits();
			for (Unit unit: units) {
				String unitString;
				try {
					unitString = unit.toString();
				} catch(Exception ex) {
					unitString = "***Invalid Statement ";
				}
				writer.printf("\t\t%s \n", unitString);
				logger.info("{} ", unitString);
			}

			writer.printf("\t} \n");
			logger.info("");
		}
		writer.printf("} \n");
		writer.flush();
    }

    /****************************************************************************
    *                           To delete
    ****************************************************************************/

	/**
    * addClinitMethod:
    *   add the static constructor (class constructor)
    */
    private void addClinitMethod() {
        mClinitMethod = new SootMethod("<clinit>", new LinkedList(), VoidType.v(), Modifier.STATIC);
        mSootClass.addMethod(mClinitMethod);

        /*
         * adding clinit method for the class
         */
        mClinitBody = Jimple.v().newBody(mClinitMethod);

        /* The active body to work on is mClinitBody */
        mClinitMethod.setActiveBody(mClinitBody);
    }
}
