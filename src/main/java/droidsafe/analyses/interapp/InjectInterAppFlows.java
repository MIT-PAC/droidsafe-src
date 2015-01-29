package droidsafe.analyses.interapp;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import soot.Body;
import soot.Local;
import soot.RefType;
import soot.Scene;
import soot.SootClass;
import soot.SootField;
import soot.SootMethod;
import soot.SootMethodRef;
import soot.Value;
import soot.jimple.AssignStmt;
import soot.jimple.InstanceInvokeExpr;
import soot.jimple.IntConstant;
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import droidsafe.analyses.pta.PTABridge;
import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ImplicitIntentModel;
import droidsafe.analyses.value.IntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.ResolvedExplicitIntent;
import droidsafe.analyses.value.UnresolvedIntent;
import droidsafe.analyses.value.VAUtils;
import droidsafe.android.app.Harness;
import droidsafe.android.app.Hierarchy;
import droidsafe.android.system.AndroidComponents;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.reports.ICCMap;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.utils.JimpleRelationships;

/**
 * 
 * 
 * Currently will taint return values for injected intent methods that return string or primitive.
 * This is because fall back modeling injects objects that will not be tainted.
 * 
 * @author mgordon
 *
 */
public class InjectInterAppFlows {
    private final static Logger logger = LoggerFactory.getLogger(InjectInterAppFlows.class);
    
    private static InjectInterAppFlows v;
    private List<SourceFlow> flows;
    public static int localID = 0;
    
    public static InjectInterAppFlows v() {
       if (v == null)
           v = new InjectInterAppFlows();
       
       return v;
    }
    
    private InjectInterAppFlows() {
            
    }
    
    public void run() {
        //read entire file into string
        String fileStr = Config.v().readInterAppFlowsFile;
        String jsonString = "";
        flows = new LinkedList<SourceFlow>();
        
        if (fileStr.isEmpty())
            return;
        
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(fileStr));
            jsonString = new String(encoded, Charset.defaultCharset());
        } catch (Exception e) {
            logger.error("Error opening inter app flows file", e);
        }
        
        if (jsonString.isEmpty())
            return;
        
        deserializeJsonToSourceFlows(jsonString);
        injectFlows();
    }
    
    private void injectFlows() {
        for (SourceFlow flow : flows) {
            AndroidComponents component = flow.getApiCall().getTargetComponent();     
            Set<SootField> targetFields = IntentUtils.v().getIntentTargetHarnessFields(component, flow.getIntent());
            SootField generatedIntentField = null;
            
            //generate a new Intent object and tag all methods of the cloned intent class 
            if (targetFields.size() > 0) {                
                generatedIntentField = UnmodeledGeneratedClasses.v().addRefTypeWithNewField(RefType.v("android.content.Intent"), 
                    flow.getSrcKind(), true);
                SootClass clonedIntentClz = UnmodeledGeneratedClasses.v().getLastCloneCreated();
                methodReturnStringSimplify(clonedIntentClz); 
                logger.info("Creating dummy intent object to inject inter app flow: {}", generatedIntentField);                
            }
            
            for (SootField field : targetFields) {
                logger.info("Found target for {}: {}", flow.getIntent(), field);
                switch (component) {
                    case ACTIVITY: injectForActivity(field, generatedIntentField); break;
                    case SERVICE: injectForService(field, generatedIntentField); break;
                    case BROADCAST_RECEIVER: injectForBroadcastReceiver(field, generatedIntentField); break;
                    default: break;
                }
            }            
        }
    }
    
    private void injectForActivity(SootField activityField, SootField intentField) { 
        SootMethod setIntentMethod = 
                Scene.v().getMethod("<android.app.Activity: void setIntent(android.content.Intent)>");
       
        logger.info("Adding setIntent call in harness for field {}", activityField);
        //call set intent on these activities with local   

        //create local and add to body
        Local compLocal = Jimple.v().newLocal("_$injectinterapp_comp_local_" + localID++, activityField.getType());        
        Harness.v().addLocalToMain(compLocal);
        
        //set field of activity to local [local = harness.activityfield]
        //set local to field
        Stmt activityAss = Jimple.v().newAssignStmt
                (compLocal, Jimple.v().newStaticFieldRef(activityField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(activityAss);
        
        //set local to field for intent from dummies
        Local intentLocal = Jimple.v().newLocal("_$injectinterapp_intent_local_" + localID++, intentField.getType());        
        Harness.v().addLocalToMain(intentLocal);
        Stmt intentAssign = Jimple.v().newAssignStmt
                (intentLocal, Jimple.v().newStaticFieldRef(intentField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(intentAssign);

        //call setActivity on local with local arg from start activity
        List<Value> args = new LinkedList<Value>();
        //this will work for both startActivity and startActivityForResult
        args.add(intentLocal);
        Stmt setIntentCall = 
                Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                    (compLocal, setIntentMethod.makeRef(), args));        
        Harness.v().addStmtToEndOfMainLoop(setIntentCall);
        
        //ignore making output events for this call we add
        RCFG.v().ignoreInvokeForOutputEvents(setIntentCall);             
    }
      
    /**
     * For a service, create calls to onStart and onStartCommand with the created Intent for the 
     * injected flows.
     */
    private void injectForService(SootField serviceField, SootField intentField) {
        
        SootMethod onStartCommand = Scene.v().getMethod("<android.app.Service: int onStartCommand(android.content.Intent,int,int)>");
        SootMethod onStart = Scene.v().getMethod("<android.app.Service: void onStart(android.content.Intent,int)>");

        logger.info("Adding onStartCommand/onStart call in Harness for Field {}", serviceField);
        //call set intent on these activities with local   

        //create local and add to body
        Local compLocal = Jimple.v().newLocal("_$injectinterapp_comp_local_" + localID++, serviceField.getType());
        Harness.v().addLocalToMain(compLocal);
        
        //create local and add to body
        Local intentLocal = Jimple.v().newLocal("_$injectinterapp_intent_local_" + localID++, intentField.getType());
        Harness.v().addLocalToMain(intentLocal);                

        //set field of component to local [local = harness.activityfield]
        //set local to field
        Stmt compLocalAssign = Jimple.v().newAssignStmt
                (compLocal, Jimple.v().newStaticFieldRef(serviceField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(compLocalAssign);
        
        //set local for intent to the field for the created intent
        Stmt intentAssign = Jimple.v().newAssignStmt
                (intentLocal, Jimple.v().newStaticFieldRef(intentField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(intentAssign);

        List<Value> args = new LinkedList<Value>();

        args.add(intentLocal);
        args.add(IntConstant.v(0));
        args.add(IntConstant.v(0));
        Stmt onStartCall = 
                Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                    (compLocal, onStartCommand.makeRef(), args));

        Harness.v().addStmtToEndOfMainLoop(onStartCall);
        //ignore making output events for this call we add
        RCFG.v().ignoreInvokeForOutputEvents(onStartCall);

        //now add the call to onStart()

        args = new LinkedList<Value>();

        args.add(intentLocal);
        args.add(IntConstant.v(0));
        Stmt onStartDepCall = 
                Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                    (compLocal, onStart.makeRef(), args));

        Harness.v().addStmtToEndOfMainLoop(onStartDepCall);
        //ignore making output events for this call we add
        RCFG.v().ignoreInvokeForOutputEvents(onStartDepCall);
    }
    
    /**
     * Inject source flow into broadcast receiver field by injecting a call to onReceiver with the
     * created Intent.
     */
    private void injectForBroadcastReceiver(SootField brField, SootField intentField) {
        SootMethod onReceive = Scene.v().getMethod("<android.content.BroadcastReceiver: void onReceive(android.content.Context,android.content.Intent)>");


        logger.info("Adding onReceive call in Harness for Field {}", brField);
        //call set intent on these activities with local   

        //create local and add to body
        Local compLocal = Jimple.v().newLocal("_$injectinterapp_comp_local_" + localID++, brField.getType());
        Harness.v().addLocalToMain(compLocal);
        
        //create local and add to body
        Local intentLocal = Jimple.v().newLocal("_$injectinterapp_intent_local_" + localID++, intentField.getType());
        Harness.v().addLocalToMain(intentLocal);                


        //set field of component to local [local = harness.activityfield]
        //set local to field
        Stmt compLocalAssign = Jimple.v().newAssignStmt
                (compLocal, Jimple.v().newStaticFieldRef(brField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(compLocalAssign);
        
        //set local for intent to the field for the created intent
        Stmt intentAssign = Jimple.v().newAssignStmt
                (intentLocal, Jimple.v().newStaticFieldRef(intentField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(intentAssign);
        
        //for the context, grab the context from the DroidSafeAndroidRuntime
        
        //create local and add to body
        Local contextLocal = Jimple.v().newLocal("_$injectinterapp_content_local_" + localID++, intentField.getType());
        Harness.v().addLocalToMain(contextLocal);
        SootField contextField = 
                Scene.v().getSootClass("droidsafe.runtime.DroidSafeAndroidRuntime").getFieldByName("context");
        Stmt contextAssign = 
                Jimple.v().newAssignStmt(contextLocal, Jimple.v().newStaticFieldRef(contextField.makeRef()));
        Harness.v().addStmtToEndOfMainLoop(contextAssign);

        List<Value> args = new LinkedList<Value>();
        args.add(contextLocal);
        args.add(intentLocal);
        Stmt onReceiveCall = 
                Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr
                    (compLocal, onReceive.makeRef(), args));

        Harness.v().addStmtToEndOfMainLoop(onReceiveCall);
        
        //ignore making output events for this call we add
        RCFG.v().ignoreInvokeForOutputEvents(onReceiveCall);
    }      

    private void deserializeJsonToSourceFlows(String json) {
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(json).getAsJsonArray();
        
        for (int i = 0; i < array.size(); i++) {
            JsonObject flowJson = array.get(i).getAsJsonObject();
            
            //infokind
            InfoKind temp = gson.fromJson(flowJson.get("srcKind"), InfoKind.class);
            InfoKind infoKind = InfoKind.getInfoKind(temp.getName(), temp.isSensitive());
            
            //stmts
            List<String> stmts = new LinkedList<String>();
            JsonArray stmtsArray = flowJson.get("srcStmts").getAsJsonArray();
            for (int j = 0; j < stmtsArray.size(); j++) {
                stmts.add(stmtsArray.get(j).getAsString());
            }
            /*
            Type collectionType = new TypeToken<Collection<String>>(){}.getType();
            Collection<String> stmts = (Collection<String>) gson.fromJson(flowJson.get("srcStmts").getAsJsonArray(), 
                collectionType.getClass());
            */
            
            //determine what type of intent we have
            JsonElement intentJson = flowJson.get("intent");
            IntentModel intent;
            if (intentJson.getAsJsonObject().has("isInvalidated")) {
                //implicit
                intent = gson.fromJson(intentJson, ImplicitIntentModel.class);
            } else if (intentJson.getAsJsonObject().has("componentNames")) {
                //explicit
                intent = gson.fromJson(intentJson, ResolvedExplicitIntent.class);
            } else {
                //unresolved??
                intent = UnresolvedIntent.v();           
            }
            
            //InterAppApiCall
            InterAppApiCall interAppApiCall = 
                    gson.fromJson(flowJson.get("apiCall"), InterAppApiCall.class);           
            
            SourceFlow flow = new SourceFlow(interAppApiCall, infoKind, null, intent);
            flow.setSrcStmt(stmts);            
            flows.add(flow);
        }
    }
    
    /**
     * For each method that returns a string in clz, replace the body with a body that simply
     * creates a string and returns it.
     */
    private void methodReturnStringSimplify(SootClass clz) {
        RefType stringType = RefType.v("java.lang.String");
        SootMethodRef strCons = Scene.v().getMethod("<java.lang.String: void <init>()>").makeRef();
        for (SootMethod method : clz.getMethods()) {
            if (!stringType.equals(method.getReturnType())) {
                continue;
            }

            //create new body that just returns a new string
            Body newBody = Jimple.v().newBody();
            
            //create param identity statements
            for (int i = 0; i < method.getParameterCount(); i++) {
                Local p = Jimple.v().newLocal("_$str_method_arg_" + localID++, method.getParameterType(i));
                newBody.getLocals().add(p);
                newBody.getUnits().add(Jimple.v().newIdentityStmt(p, Jimple.v().newParameterRef(method.getParameterType(i), i)));
            }
                
            
            //method returns string
            Local l = Jimple.v().newLocal("_$str_method_return_" + localID++, stringType); 
            newBody.getLocals().add(l);
            
            AssignStmt as = Jimple.v().newAssignStmt(l, Jimple.v().newNewExpr(stringType));
            newBody.getUnits().add(as);
            
            
            InvokeStmt cons = Jimple.v().newInvokeStmt(Jimple.v().newSpecialInvokeExpr(l, strCons));
            newBody.getUnits().add(cons);
            
            newBody.getUnits().add(Jimple.v().newReturnStmt(l));
            
            newBody.setMethod(method);
            method.setActiveBody(newBody);
        }
    }

}
