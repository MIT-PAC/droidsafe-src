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
import soot.jimple.InvokeStmt;
import soot.jimple.Jimple;
import soot.jimple.Stmt;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import droidsafe.analyses.rcfg.RCFG;
import droidsafe.analyses.value.ImplicitIntentModel;
import droidsafe.analyses.value.IntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.analyses.value.ResolvedExplicitIntent;
import droidsafe.analyses.value.UnresolvedIntent;
import droidsafe.android.app.Harness;
import droidsafe.android.system.AndroidComponents;
import droidsafe.android.system.InfoKind;
import droidsafe.main.Config;
import droidsafe.reports.ICCMap;
import droidsafe.transforms.UnmodeledGeneratedClasses;
import droidsafe.utils.JimpleRelationships;

/**
 * 
 * 
 * Currently will work taint return values for injected intent methods that return string or primitive.
 * This is because fall back modeling will inject objects that are not tainted.
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
                generatedIntentField = UnmodeledGeneratedClasses.v().addRefType(RefType.v("android.content.Intent"), 
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
        
    private void injectForService(SootField serviceField, SootField intentField) {
        //TODO
    }
    
    private void injectForBroadcastReceiver(SootField receiverField,SootField intentField) {
        //TODO
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
