package droidsafe.analyses.interapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import soot.jimple.Stmt;
import droidsafe.android.system.InfoKind;
import droidsafe.speclang.Method;
import droidsafe.speclang.SecuritySpecification;

public class GenerateInterAppSourceFlows {
    private static GenerateInterAppSourceFlows v;
    private SecuritySpecification spec;
    private Map<String, InterAppApiCall> sigToAPICallType;
    private List<SourceFlow> flows;
    
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
                            
                            SourceFlow interAppFlow = new SourceFlow(type, flow.getKey(), flow.getValue(), null);
                            flows.add(interAppFlow);
                            System.out.printf("Found InterApp: %s\n", interAppFlow);
                        } 
                    }                    
                }
            }
        }
    }
    
    private void produceJSONFile() {
        
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
}
