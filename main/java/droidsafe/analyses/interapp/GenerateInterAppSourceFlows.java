package droidsafe.analyses.interapp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import soot.jimple.Stmt;
import soot.jimple.toolkits.pta.IAllocNode;
import droidsafe.analyses.value.IntentModel;
import droidsafe.analyses.value.IntentUtils;
import droidsafe.android.app.Project;
import droidsafe.android.system.InfoKind;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;
import droidsafe.utils.GsonExclude;

public class GenerateInterAppSourceFlows {
    private final static Logger logger = LoggerFactory.getLogger(GenerateInterAppSourceFlows.class);
    
    private static GenerateInterAppSourceFlows v;
    private SecuritySpecification spec;
    private Map<String, InterAppApiCall> sigToAPICallType;
    private List<SourceFlow> flows;
    private static final String FILE_NAME = "InterAppSourceFlows.gson";
    
    private GenerateInterAppSourceFlows() {
        createAPIMap();
        flows = new ArrayList<SourceFlow>();
    }

    public static GenerateInterAppSourceFlows v() {
        if (v == null) 
            v = new GenerateInterAppSourceFlows();

        return v;
    }

    public static void reset() {
        v = null;
    }

    public void run(SecuritySpecification spec) {
        this.spec = spec;
        createSourceFlows();
        produceJSONFile();
    }

    private void createSourceFlows() {
        for (Map.Entry<Method, List<Method>> entry: spec.getEventBlocks().entrySet()) {
            for (Method oe : entry.getValue()) {
                System.out.println(oe.getSignature());
                if (sigToAPICallType.containsKey(oe.getSignature())) {
                    InterAppApiCall type = sigToAPICallType.get(oe.getSignature());

                    for (int i = 0; i < oe.getNumArgs(); i++) {
                        for (Entry<InfoKind, Set<Stmt>> flow : oe.getArgSourceInfoUnitsConservative(i).entrySet()) {
                            for (IAllocNode node : oe.getArgAllocNodes(i)) {
                                IntentModel im = IntentUtils.v().getIntentModel(node);
                                SourceFlow interAppFlow = new SourceFlow(type, flow.getKey(), flow.getValue(), im);
                                flows.add(interAppFlow);
                                System.out.printf("Found InterApp: %s\n", interAppFlow);
                            }
                        } 
                    }                    
                }
            }
        }
    }

    private void produceJSONFile() {
        Gson gson = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .setExclusionStrategies(new IntentModelExclusionStrategy())
            .create();
       
        String output = gson.toJson(flows);
        FileWriter fw;
        try {
            fw = new FileWriter(Project.v().getOutputDir() + File.separator + FILE_NAME);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            logger.warn("Error writing json file.", e);
        }

    }

    private void createAPIMap() {
        sigToAPICallType = new HashMap<String, InterAppApiCall>();
        sigToAPICallType.put("<android.app.Activity: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Activity: void startActivity(android.content.Intent,android.os.Bundle)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Activity: void startActivityForResult(android.content.Intent,int)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Activity: void startActivityForResult(android.content.Intent,int,android.os.Bundle)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Activity: void startActivityIfNeeded(android.content.Intent,int,android.os.Bundle)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.content.Context: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.ContexImpl: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Service: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Application: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put( "<android.app.Fragment: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.app.Fragment: void startActivityForResult(android.content.Intent,int)>", InterAppApiCall.START_ACTIVITY);
        sigToAPICallType.put("<android.content.ContextWrapper: void startActivity(android.content.Intent)>", InterAppApiCall.START_ACTIVITY);

        sigToAPICallType.put("<android.content.Context: android.content.ComponentName startService(android.content.Intent)>", InterAppApiCall.START_SERVICE);
        sigToAPICallType.put("<android.app.ContextImpl: android.content.ComponentName startService(android.content.Intent)>", InterAppApiCall.START_SERVICE);
        sigToAPICallType.put("<android.content.ContextWrapper: android.content.ComponentName startService(android.content.Intent)>", InterAppApiCall.START_SERVICE);

        sigToAPICallType.put("<android.content.Context: void sendBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.Context: void sendBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.Context: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.Context: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.Context: void sendStickyBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.Context: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendStickyBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.content.ContextWrapper: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendOrderedBroadcast(android.content.Intent,java.lang.String)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendOrderedBroadcast(android.content.Intent,java.lang.String,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendStickyBroadcast(android.content.Intent)>", InterAppApiCall.SEND_BROADCAST);
        sigToAPICallType.put("<android.app.ContextImpl: void sendStickyOrderedBroadcast(android.content.Intent,android.content.BroadcastReceiver,android.os.Handler,int,java.lang.String,android.os.Bundle)>", InterAppApiCall.SEND_BROADCAST);
    }
    
    public class IntentModelExclusionStrategy implements ExclusionStrategy {

        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(GsonExclude.class) != null;
        }

        @Override
        public boolean shouldSkipClass(Class<?> arg0) {            
            return false;
        }
      }
}
