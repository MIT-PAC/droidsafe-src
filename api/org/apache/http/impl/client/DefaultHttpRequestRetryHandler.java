package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;






public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.688 -0400", hash_original_field = "B4DF5887CB02A4F326343B4E2FC8DC1E", hash_generated_field = "1D6143EFD067DE65E0F1632FD027ED68")

    private int retryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.688 -0400", hash_original_field = "FE8B8D4C96FA75ADA834853E0A88A2B1", hash_generated_field = "5229ECE23C7E3ED8EB78411CF48864E4")

    private boolean requestSentRetryEnabled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.689 -0400", hash_original_method = "6D9057C3F9363D21510D9933DD6755F5", hash_generated_method = "4582FB4D07EF2C7BD4CEC0E86D9868D6")
    public  DefaultHttpRequestRetryHandler(int retryCount, boolean requestSentRetryEnabled) {
        super();
        this.retryCount = retryCount;
        this.requestSentRetryEnabled = requestSentRetryEnabled;
        // ---------- Original Method ----------
        //this.retryCount = retryCount;
        //this.requestSentRetryEnabled = requestSentRetryEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.689 -0400", hash_original_method = "5F4132CBD367F2EB70F7284BB1D2E959", hash_generated_method = "2BF645713EE7B0044C6A526FDD62C704")
    public  DefaultHttpRequestRetryHandler() {
        this(3, false);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.689 -0400", hash_original_method = "CD15A57681F805F21E0C1F750415FEC8", hash_generated_method = "A166DAF2CB1B0E817C4227701DBD7C29")
    public boolean retryRequest(
            final IOException exception, 
            int executionCount,
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(executionCount);
        addTaint(exception.getTaint());
        if(exception == null)        
        {
            IllegalArgumentException varFCDED35F2A1413CC3D2EB14D2CD71CD7_502676886 = new IllegalArgumentException("Exception parameter may not be null");
            varFCDED35F2A1413CC3D2EB14D2CD71CD7_502676886.addTaint(taint);
            throw varFCDED35F2A1413CC3D2EB14D2CD71CD7_502676886;
        } //End block
        if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_682181585 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_682181585.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_682181585;
        } //End block
        if(executionCount > this.retryCount)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1621098743 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340864546 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_340864546;
        } //End block
        if(exception instanceof NoHttpResponseException)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1883096753 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_383518844 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_383518844;
        } //End block
        if(exception instanceof InterruptedIOException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_558745838 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_560063134 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_560063134;
        } //End block
        if(exception instanceof UnknownHostException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_711237676 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_799341963 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_799341963;
        } //End block
        if(exception instanceof SSLHandshakeException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1769060390 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232550209 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_232550209;
        } //End block
        Boolean b = (Boolean)
            context.getAttribute(ExecutionContext.HTTP_REQ_SENT);
        boolean sent = (b != null && b.booleanValue());
        if(!sent || this.requestSentRetryEnabled)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_391613746 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1685530969 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1685530969;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_333661582 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_811716412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_811716412;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.689 -0400", hash_original_method = "D094CEC45107E8B04F6D27DB66E61646", hash_generated_method = "628D1040732DFCAC858A0835F2F14EBB")
    public boolean isRequestSentRetryEnabled() {
        boolean varFE8B8D4C96FA75ADA834853E0A88A2B1_159393880 = (requestSentRetryEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_700363005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_700363005;
        // ---------- Original Method ----------
        //return requestSentRetryEnabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.689 -0400", hash_original_method = "C82A3B7CA490A8560B081A320AF1EB0A", hash_generated_method = "271D0781797F7783B9DC69598ACC1514")
    public int getRetryCount() {
        int varB4DF5887CB02A4F326343B4E2FC8DC1E_775309261 = (retryCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996708772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_996708772;
        // ---------- Original Method ----------
        //return retryCount;
    }

    
}

