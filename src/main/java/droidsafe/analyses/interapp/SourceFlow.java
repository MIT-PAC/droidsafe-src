/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

package droidsafe.analyses.interapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import soot.jimple.Stmt;
import droidsafe.analyses.value.IntentModel;
import droidsafe.android.system.InfoKind;

public class SourceFlow {
    /** source information kind */
    private InfoKind srcKind;
    /** Strings representing the generating source statements */
    private Collection<String> srcStmts;
    /** The reolved intent for the source flow */
    private IntentModel intent;
    /** The generating api call type */
    private InterAppApiCall apiCall;
    
    private static Map<String, InterAppApiCall> sigToAPICallType;      
    
    public SourceFlow(InterAppApiCall apiCall, InfoKind srcKind, Collection<String> srcSootStmts, IntentModel intent) {
        super();
        this.apiCall = apiCall;
        this.srcKind = srcKind;
        
        this.intent = intent;
        this.srcStmts = srcSootStmts;
    }     
    
    public InterAppApiCall getApiCall() {
        return apiCall;
    }

    public void setApiCall(InterAppApiCall apiCall) {
        this.apiCall = apiCall;
    }

    public InfoKind getSrcKind() {
        return srcKind;
    }

    public void setSrcKind(InfoKind srcKind) {
        this.srcKind = srcKind;
    }

    public Collection<String> getSrcStmts() {
        return srcStmts;
    }

    public void setSrcStmt(Collection<String> srcStmts) {
        this.srcStmts = srcStmts;
    }

    public IntentModel getIntent() {
        return intent;
    }

    public void setIntent(IntentModel intent) {
        this.intent = intent;
    }

    @Override
    public String toString() {
        return "SourceFlow [srcKind=" + srcKind + ", srcStmts=" + srcStmts + ", intent=" + intent
                + ", apiCall=" + apiCall + "]";
    }
    
    public static boolean isSourceFlowMethodSig(String sig) {
        return sigToAPICallType.containsKey(sig);
    }
    
    public static InterAppApiCall getInterAppApiCallForSig(String sig) {
        return sigToAPICallType.get(sig);
    }
    
    static {
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
