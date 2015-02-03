package droidsafe.android.app;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.ArrayType;
import soot.Body;
import soot.Local;
import soot.Modifier;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootFieldRef;
import soot.SootMethod;
import soot.Type;
import soot.Unit;
import soot.Value;
import soot.VoidType;
import soot.jimple.AssignStmt;
import soot.jimple.Expr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeExpr;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.NewExpr;
import soot.jimple.NopStmt;
import soot.jimple.Stmt;
import soot.jimple.StmtBody;
import soot.jimple.StringConstant;
import soot.util.Chain;

import com.google.common.collect.ImmutableMap;

import droidsafe.android.system.API;
import droidsafe.android.system.Components;
import droidsafe.transforms.TransformsUtils;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.utils.SootUtils;
import droidsafe.utils.Utils;
import droidsafe.android.app.resources.AndroidManifest;
import droidsafe.android.app.resources.AndroidManifest.ComponentBaseElement;
import droidsafe.android.app.resources.AndroidManifest.IntentFilter;
import droidsafe.android.app.resources.Layout;
import droidsafe.android.app.resources.Resources;
import droidsafe.android.app.resources.AndroidManifest.Activity;
import droidsafe.android.app.resources.AndroidManifest.Provider;
import droidsafe.android.app.resources.AndroidManifest.Receiver;
import droidsafe.android.app.resources.AndroidManifest.Service;

/**
 * Create a harness class that will call the entry points of the android application
 * and create objects of appropriate type for the points-to analysis.
 * 
 * @author mgordon
 *
 */
public class Harness {
    private final static Logger logger = LoggerFactory.getLogger(Harness.class);

    public final static String RUNTIME_MODELING_CLASS = "droidsafe.runtime.DroidSafeAndroidRuntime";

    //map of component class names to the init method that should be called for them...
    private static Map<String, String> componentInitMethod = ImmutableMap.of(
        Components.ACTIVITY_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelActivity(android.app.Activity)>",
        Components.SERVICE_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelService(android.app.Service)>",
        Components.CONTENTPROVIDER_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelContentProvider(android.content.ContentProvider)>",
        Components.BROADCASTRECEIVER_CLASS, "<" + RUNTIME_MODELING_CLASS + ": void modelBroadCastReceiver(android.content.BroadcastReceiver)>"
            );
    private String modelApplicationMethod = "<" + RUNTIME_MODELING_CLASS + ": void modelApplication(android.app.Application)>";
    private SootClass harnessClass;
    private SootMethod harnessMain;
    public static String HARNESS_CLASS_NAME = Project.DS_GENERATED_CLASSES_PREFIX + "DroidSafeMain";
    public static String FIELD_PREFIX = "_ds_field_";

    private Map<SootClass, SootField> globalsMap;
    private int localID = 0;
    private int fieldID = 0;
    /** body for the harness main */
    private Body harnessMainBody;
    /** for injecting code after the create() method has been called, inject before this statment */
    private Stmt inLoopStmt;
    /** static singleton */
    public static Harness v;

    /**
     * Create a harness class with a main method that includes calls into
     * all the entry points of the android application.
     */
    public static void create() {
        v = new Harness();
    }

    public static Harness v() {
        if (v == null) {
            logger.error("Harness not created!");
            droidsafe.main.Main.exit(1);
        }
        return v;
    }

    /**
     * Return the main method for the harness that includes all the calls
     * to the entry points.
     */
    public SootMethod getMain() {
        return harnessMain;
    }

    /**
     * Return the set of classes that were created by the harness.  These are Android components
     * and other classes of the application that are created by the runtime. 
     */
    public Set<SootClass> getCreatedClasses() {
        return globalsMap.keySet();
    }

    /**
     * After the harness has created created code in here, this allows one to add additional statements.
     * 
     * @param stmt
     */
    public void addStmtToEndOfMainLoop(Stmt stmt) {
        harnessMainBody.getUnits().insertBefore(stmt, inLoopStmt);
    }
    
    public void addLocalToMain(Local l) {
        harnessMainBody.getLocals().add(l);
    }
    
    public Map<SootClass,SootField> getCreatedFieldsMap() {
        return globalsMap;
    }
    
    public boolean hasCreatedField(SootClass clz) {
        return globalsMap.containsKey(clz);
    }
    
    /**
     * Return the static field of the harness that stores the object of the created class clz. 
     */
    public SootField getFieldForCreatedClass(SootClass clz) {
        return globalsMap.get(clz);
    }

    public SootClass getHarnessClass() {
        return harnessClass;
    }

    private Harness() {
        globalsMap = new LinkedHashMap<SootClass, SootField>();

        //create the harness class
        harnessClass = new SootClass(HARNESS_CLASS_NAME, Modifier.PUBLIC | Modifier.FINAL);
        harnessClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
        API.v().addSystemClass(harnessClass);

        //create the harness main method
        List<Type> args = new LinkedList<Type>();
        args.add(ArrayType.v(RefType.v("java.lang.String"), 1));
        harnessMain = new SootMethod("main", 
            args, VoidType.v(),
            Modifier.PUBLIC | Modifier.STATIC);

        harnessMain.setDeclaringClass(harnessClass);
        harnessClass.addMethod(harnessMain);

        StmtBody body = Jimple.v().newBody(harnessMain);
        harnessMainBody = body;
        harnessMain.setActiveBody(body);

        API.v().addSafeMethod(harnessMain);

        Stmt beginCalls = mainMethodHeader(body);

        //add call to initialize the dummy class that create unmodeled values
        body.getUnits().add(Jimple.v().newInvokeStmt
            (Jimple.v().newStaticInvokeExpr(UnmodeledGeneratedClasses.v().getInitMethod().makeRef())));
        
        /** inject intentfilter and application  */
        injectApplicationIntentFilters();

        //create the loop back to the beginning of the calls
        inLoopStmt = Jimple.v().newGotoStmt(beginCalls);
        body.getUnits().add(inLoopStmt);

        body.getUnits().add(Jimple.v().newReturnVoidStmt());

        Scene.v().addClass(harnessClass);
        Scene.v().loadClass(harnessClass.getName(), SootClass.BODIES);
        harnessClass.setApplicationClass();		

        SootUtils.writeByteCodeAndJimple(Project.v().getOutputDir(), getHarnessClass());
    }

    /**
     * Method to perform actual intent filtering
     * @param context
     * @param intentFilters
     * @param body
     */
    private int intentFilterCount = 0;
    private void injectIntentFilter(Local compLocal, List<IntentFilter> intentFilters, StmtBody body, Local appLocal) {

        if (intentFilters.size() == 0)
            return;

        RefType intentFilterType = RefType.v("android.content.IntentFilter");

        String methodSig = String.format("<%s: android.content.Intent __ds__registerIntentFilter(android.content.IntentFilter)>", 
                "android.content.Context");

        // if broadcast receiver, we use a different signature
        if (appLocal != null) {
            methodSig = String.format("<%s: android.content.Intent[] __ds__registerIntentFilter(android.content.IntentFilter)>", 
                    "android.content.BroadcastReceiver");
        }

        SootMethod registerIntentFilter = Scene.v().getMethod(methodSig);

        methodSig = String.format("<%s: void <init>()>", "android.content.IntentFilter");
        SootMethod intentFilterInit = Scene.v().getMethod(methodSig);


        methodSig = String.format("<%s: void addCategory(java.lang.String)>", 
                "android.content.IntentFilter");
        SootMethod addCategory = Scene.v().getMethod(methodSig);

        methodSig = String.format("<%s: void addAction(java.lang.String)>", 
                "android.content.IntentFilter");
        SootMethod addAction = Scene.v().getMethod(methodSig);
        
        methodSig = String.format("<%s: void droidsafeSetDataUri(java.lang.String)>", 
                "android.content.IntentFilter");
        SootMethod setDataUri = Scene.v().getMethod(methodSig);
        
        methodSig = String.format("<%s: %s registerReceiver(%s,%s)>", 
            "android.content.Context",
            "android.content.Intent",
            "android.content.BroadcastReceiver",
                "android.content.IntentFilter");

        SootMethod registerReceiver =  Scene.v().getMethod(methodSig);

        for (IntentFilter intentFilter: intentFilters) {
            String intentLocalName = String.format("_$dsIntentFilter%s", intentFilterCount++);

            // add local
            Local intentFilterLocal = Jimple.v().newLocal(intentLocalName, intentFilterType);
            body.getLocals().add(intentFilterLocal);

            // add new
            Expr newAppExpr = Jimple.v().newNewExpr(intentFilterType);
            body.getUnits().add(Jimple.v().newAssignStmt(intentFilterLocal,  newAppExpr));

            // call default constructor
            Stmt initStmt = Jimple.v().newInvokeStmt(
                Jimple.v().newSpecialInvokeExpr(intentFilterLocal, intentFilterInit.makeRef()));

            body.getUnits().add(initStmt);

            for (String action: intentFilter.actions) {
                Local stringLocal = Jimple.v().newLocal(String.format("_$dsActionString%03d", LOCAL_COUNTER++),  
                    RefType.v("java.lang.String"));
                body.getLocals().add(stringLocal);

                //localString = "constant"
                body.getUnits().add(Jimple.v().
                    newAssignStmt(stringLocal, StringConstant.v(action)));

                //call addAction
                body.getUnits().add(
                    Jimple.v().newInvokeStmt(
                        Jimple.v().newVirtualInvokeExpr(intentFilterLocal, 
                            addAction.makeRef(), stringLocal)));
            }

            for (String category: intentFilter.categories) {
                Local stringLocal = Jimple.v().newLocal(String.format("_$dsCategoryString%03d", LOCAL_COUNTER++),  
                    RefType.v("java.lang.String"));
                body.getLocals().add(stringLocal);

                //localString = "constant"
                body.getUnits().add(Jimple.v().
                    newAssignStmt(stringLocal, StringConstant.v(category)));

                //call addAction
                body.getUnits().add(
                    Jimple.v().newInvokeStmt(
                        Jimple.v().newVirtualInvokeExpr(intentFilterLocal, 
                            addCategory.makeRef(), stringLocal)));
            }
            
            for (String dataUri : intentFilter.dataUri) {    
                logger.debug("Found intent filter uri  {} ", dataUri);
                Local stringLocal = Jimple.v().newLocal(String.format("_$dsUriString%03d", LOCAL_COUNTER++),  
                    RefType.v("java.lang.String"));
                body.getLocals().add(stringLocal);

                //localString = "constant"
                body.getUnits().add(Jimple.v().
                    newAssignStmt(stringLocal, StringConstant.v(dataUri)));

                body.getUnits().add(
                    Jimple.v().newInvokeStmt(
                        Jimple.v().newVirtualInvokeExpr(intentFilterLocal, 
                            setDataUri.makeRef(), stringLocal)));
                
            }
            

            // calling __ds__registerIntentFilter
            body.getUnits().add(
                Jimple.v().newInvokeStmt(
                    Jimple.v().newVirtualInvokeExpr(compLocal, 
                        registerIntentFilter.makeRef(), intentFilterLocal)));


            // For receiver, we will need to register broadcast receiver with an app
            if (appLocal == null)
                return;

            // Broadcast receiver, will also do this
            body.getUnits().add(
                Jimple.v().newInvokeStmt(
                    Jimple.v().newVirtualInvokeExpr(appLocal, 
                        registerReceiver.makeRef(), compLocal, intentFilterLocal)));

        }
    }


    int LOCAL_COUNTER = 0;

    /**
     * 
     * @param component: one of the provider, service, application and receiver
     */
    private void injectXMLComponent(ComponentBaseElement xmlComponent, String compType, SootClass compClass, 
                                    List<IntentFilter> intentFilterList, StmtBody body) {
        injectXMLComponent(xmlComponent, compType, compClass, intentFilterList, body, null);
    }

    /**
     * inject intent filter and call the receiver registration 
     * @param compType
     * @param compClass
     * @param intentFilterList
     * @param body
     * @param appLocal - local to hold application
     */
    private void injectXMLComponent(ComponentBaseElement xmlElement, String compType, SootClass compClass, 
                                    List<IntentFilter> intentFilterList, StmtBody body, Local appLocal) {
        
        //don't create non-enabled components
        if (!xmlElement.enabled)
            return;
        
        if (compClass != null) {
            logger.info("Type {} ", compType);

            String initSig = String.format("<%s: void <init>()>", compClass.getName());
        
            SootClass componentParent = Hierarchy.getComponentParent(compClass);
            if (componentParent == null) {
            	logger.warn("Could not locate parent for {}, could be external component", compClass);
            	return;
            }

            if (!compType.equals(Hierarchy.getComponentParent(compClass).getName())) {
                logger.error("Malformed manifest: component {} defined in manifest as {} have defined parent {}", 
                             compClass, compType, Hierarchy.getComponentParent(compClass).getName());
                return;
                //droidsafe.main.Main.exit(1);
            }

            //SootMethod compInit = Scene.v().getMethod(initSig);
            SootMethod compInit = null;
            SootMethod initMethod = null; 

            if (Scene.v().containsMethod(initSig)) {
                compInit = Scene.v().getMethod(initSig);
            }
            else {
                logger.info("Class {} does not have <init> function", compClass);
            }

            if (compInit != null) {
                try {
                    initMethod = Scene.v().getActiveHierarchy().resolveConcreteDispatch(compClass, compInit); 
                } 
                catch (Exception ex) {
                    logger.warn("Cannot resolve constructor {}", compInit);
                }
            }

            String name = String.format("_$ds__%s%03d", 
                                        compType.substring(compType.lastIndexOf(".") + 1), LOCAL_COUNTER++);

            //Local compLocal = Jimple.v().newLocal(name,  RefType.v(compType));
            Local compLocal = Jimple.v().newLocal(name,  compClass.getType());
            body.getLocals().add(compLocal);


            //Local stringLocal = Jimple.v().newLocal(String.format("_$dsString%03d", counter++),  
            //        RefType.v(compType)); 

            Expr newAppExpr = Jimple.v().newNewExpr(compClass.getType());
            body.getUnits().add(Jimple.v().newAssignStmt(compLocal,  newAppExpr));

            if (initMethod != null) {
                Stmt initStmt = Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(compLocal, initMethod.makeRef()));
                body.getUnits().add(initStmt);
            }

            //create field for component
            SootField compField = new SootField(FIELD_PREFIX + localID++ , compClass.getType(), 
                                                Modifier.PUBLIC | Modifier.STATIC);
            harnessClass.addField(compField);

            //set local to field
            body.getUnits().add(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(compField.makeRef()), compLocal));
            //add to globals map for querying
            globalsMap.put(compClass, compField);

            injectIntentFilter(compLocal, intentFilterList, body, appLocal);

            // Call runtime init
            SootMethod droidsafeInit = Scene.v().getMethod(componentInitMethod.get(compType));
            Stmt initStmt = Jimple.v().newInvokeStmt(
                                                     Jimple.v().newStaticInvokeExpr(droidsafeInit.makeRef(), compLocal));

            body.getUnits().add(initStmt);
        }

    }


    /**
     * Inject intent-filter, create application instance 
     */
    private void injectApplicationIntentFilters(){

        logger.info("**injectApplicationIntentFilters .... ");

        AndroidManifest manifest = Resources.v().getManifest();
        logger.info("Application {}, package {} ", manifest.application, Resources.v().package_name);

        if (manifest.application == null) {
            logger.info("{} is NOT an allication project, skip intentFilterInjection", 
                Resources.v().package_name);
            return;
        }

        manifest.application.setSootClass(manifest.application.name);

        SootClass appClass = manifest.application.getSootClass();

        StmtBody body = (StmtBody) harnessMain.getActiveBody();

        // locate app constructor and call them
        String appInitSig = String.format("<%s: void <init>()>", "android.app.Application");
        SootMethod appInit = null;

        try {
            appInit = Scene.v().getMethod(appInitSig);
        }
        catch (Exception ex) {
            logger.warn("Cannot inject intent filter ");
        }

        SootMethod initMethod = null;

        try {
            initMethod = Scene.v().getActiveHierarchy().resolveConcreteDispatch(appClass, appInit); 
        } 
        catch (Exception ex) {
            logger.warn("Cannot resolve App constructor {}", appClass);
            return;
        }

        // inject Application __dsApp__
        RefType appType = appClass.getType();

        Local appLocal = Jimple.v().newLocal("_$dsApp__",  appClass.getType());
        body.getLocals().add(appLocal);

        // __dsApp__ = new Application
        Expr newAppExpr = Jimple.v().newNewExpr(appType);
        body.getUnits().add(Jimple.v().newAssignStmt(appLocal,  newAppExpr));

        // __dsApp__.<init>()
        InvokeStmt initStmt = Jimple.v().newInvokeStmt(
            Jimple.v().newSpecialInvokeExpr(appLocal, initMethod.makeRef()));
        body.getUnits().add(initStmt);

        SootMethod droidsafeInit = Scene.v().getMethod(modelApplicationMethod);

        //create field for application
        SootField appField = new SootField(FIELD_PREFIX + localID++ , appClass.getType(), 
            Modifier.PUBLIC | Modifier.STATIC);
        harnessClass.addField(appField);

        //set local to field
        body.getUnits().add(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(appField.makeRef()), appLocal));
        //add to globals map for querying
        globalsMap.put(appClass, appField);

        //instantiate droidsafe runtime
        List<Value> list = new LinkedList<Value>();
        list.add(appLocal);

        body.getUnits().add(
            Jimple.v().newInvokeStmt(
                TransformsUtils.makeInvokeExpression(droidsafeInit, null, list))); 

        // Deal with activities addressed in XML file
        SootMethod contextInit;
        contextInit = Scene.v().getMethod(componentInitMethod.get(Components.SERVICE_CLASS));

        for (Activity context : manifest.activities) {

            logger.info("Activity {} ", context);			
            injectXMLComponent(context, Components.ACTIVITY_CLASS, context.getSootClass(), context.intent_filters, body); 
        }

        //Services
        for (Service context : manifest.services) {
            logger.info("Service {} ", context);

            injectXMLComponent(context, Components.SERVICE_CLASS, context.getSootClass(), context.intent_filters, body); 
        }

        // content provider should not have any
        for (Provider p : manifest.providers) {
            logger.info("Content provider {} ", p);
            injectXMLComponent(p, Components.CONTENTPROVIDER_CLASS, p.getSootClass(), p.intent_filters, body); 
        }

        for (Receiver r : manifest.receivers) {
            logger.info("Receiver {} ", r);

            injectXMLComponent(r, Components.BROADCASTRECEIVER_CLASS, r.getSootClass(), 
                r.intent_filters, body, appLocal); 
            if (r.intent_filters.size() > 0) {
                logger.warn("has intent filter for {}:{}", r.name, r);
            }
        }
    }

    /**
     * create the header for the main method including the saving of args
     * and the start of the loop for entry points calls, return the label for the loop
     */
    private Stmt mainMethodHeader(StmtBody body) {
        //add access to the arg
        Local arg = Jimple.v().newLocal("_$l" + localID++, ArrayType.v(RefType.v("java.lang.String"), 1));
        body.getLocals().add(arg);

        body.getUnits().add(Jimple.v().newIdentityStmt(arg, 
            Jimple.v().newParameterRef(ArrayType.v
                (RefType.v("java.lang.String"), 1), 0)));

        //create a nop as target of goto below, to create loop over all possible events
        NopStmt beginCalls = Jimple.v().newNopStmt();
        body.getUnits().add(beginCalls);

        return beginCalls;
    }

    /** 
     * After the harness has been initialized with create, use this method to add any component classes
     * to the harness to be created and modeled.  This is used if we find a component class that is defined,
     * but not allocated and reachable, and added as part of callback modeling.
     */
    public void createComponentsNotInManifest(SootClass clazz) {
        //first create the local for the declaring class if we have not created it before
        if (!globalsMap.containsKey(clazz)) {
            Body body = harnessMainBody;
            RefType type = RefType.v(clazz);
            logger.info("Creating component class not in manifest: {}", clazz);

            Local receiver = Jimple.v().newLocal("_$l" + localID++, type);
            body.getLocals().add(receiver);

            //add the call to the new object
            body.getUnits().insertBefore(Jimple.v().newAssignStmt(receiver, Jimple.v().newNewExpr(type)), inLoopStmt);

            //add the field
            SootField newField = new SootField(FIELD_PREFIX + localID++, type, 
                Modifier.PUBLIC  | Modifier.STATIC); 
            harnessClass.addField(newField);

            //create a constructor for this object
            List<Stmt> consCalls = TransformsUtils.getConstructorCall(body, receiver, type);
            for (Stmt consCall : consCalls)
                body.getUnits().insertBefore(consCall, inLoopStmt);

            //assign back to field
            body.getUnits().insertBefore(Jimple.v().newAssignStmt(Jimple.v().newStaticFieldRef(newField.makeRef()), receiver), inLoopStmt);

            logger.info("Adding new receiver object to harness main method: {}", clazz.toString());
            globalsMap.put(clazz, newField);

            //if a component, add a call to the launch (init) method in the runtime modeling
            if (Hierarchy.isAndroidComponentClass(clazz)) {
                SootMethod initMethod = 
                        Scene.v().getMethod(componentInitMethod.get(Hierarchy.getComponentParent(clazz).getName()));
                LinkedList<Value> args = new LinkedList<Value>();
                args.add(receiver);
                logger.info("Adding constructor for component to harness {}, of parent {}", clazz, Hierarchy.getComponentParent(clazz));
                Stmt call = Jimple.v().newInvokeStmt(TransformsUtils.makeInvokeExpression(initMethod, null, args));
                body.getUnits().insertBefore(call, inLoopStmt);
            }

        }
    }

}
