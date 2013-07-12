package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.ExecutionContext;

public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.436 -0400", hash_original_field = "B4DF5887CB02A4F326343B4E2FC8DC1E", hash_generated_field = "1D6143EFD067DE65E0F1632FD027ED68")

    private int retryCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.437 -0400", hash_original_field = "FE8B8D4C96FA75ADA834853E0A88A2B1", hash_generated_field = "5229ECE23C7E3ED8EB78411CF48864E4")

    private boolean requestSentRetryEnabled;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.437 -0400", hash_original_method = "6D9057C3F9363D21510D9933DD6755F5", hash_generated_method = "4582FB4D07EF2C7BD4CEC0E86D9868D6")
    public  DefaultHttpRequestRetryHandler(int retryCount, boolean requestSentRetryEnabled) {
        super();
        this.retryCount = retryCount;
        this.requestSentRetryEnabled = requestSentRetryEnabled;
        // ---------- Original Method ----------
        //this.retryCount = retryCount;
        //this.requestSentRetryEnabled = requestSentRetryEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.438 -0400", hash_original_method = "5F4132CBD367F2EB70F7284BB1D2E959", hash_generated_method = "2BF645713EE7B0044C6A526FDD62C704")
    public  DefaultHttpRequestRetryHandler() {
        this(3, false);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.439 -0400", hash_original_method = "CD15A57681F805F21E0C1F750415FEC8", hash_generated_method = "E2D25DA1321B52EAF4A18D357923D05C")
    public boolean retryRequest(
            final IOException exception, 
            int executionCount,
            final HttpContext context) {
        addTaint(context.getTaint());
        addTaint(executionCount);
        addTaint(exception.getTaint());
    if(exception == null)        
        {
            IllegalArgumentException varFCDED35F2A1413CC3D2EB14D2CD71CD7_862322937 = new IllegalArgumentException("Exception parameter may not be null");
            varFCDED35F2A1413CC3D2EB14D2CD71CD7_862322937.addTaint(taint);
            throw varFCDED35F2A1413CC3D2EB14D2CD71CD7_862322937;
        } //End block
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_897826463 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_897826463.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_897826463;
        } //End block
    if(executionCount > this.retryCount)        
        {
            boolean var68934A3E9455FA72420237EB05902327_147588652 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2104001699 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2104001699;
        } //End block
    if(exception instanceof NoHttpResponseException)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_654541411 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_179799347 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_179799347;
        } //End block
    if(exception instanceof InterruptedIOException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_890407541 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1932407783 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1932407783;
        } //End block
    if(exception instanceof UnknownHostException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1379469601 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1642841541 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1642841541;
        } //End block
    if(exception instanceof SSLHandshakeException)        
        {
            boolean var68934A3E9455FA72420237EB05902327_83089959 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1600115716 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1600115716;
        } //End block
        Boolean b = (Boolean)
            context.getAttribute(ExecutionContext.HTTP_REQ_SENT);
        boolean sent = (b != null && b.booleanValue());
    if(!sent || this.requestSentRetryEnabled)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_894662491 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1922835484 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1922835484;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_314090935 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_7254682 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_7254682;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.440 -0400", hash_original_method = "D094CEC45107E8B04F6D27DB66E61646", hash_generated_method = "B20D4B5EB7AD02F289F2BA2DF42E3103")
    public boolean isRequestSentRetryEnabled() {
        boolean varFE8B8D4C96FA75ADA834853E0A88A2B1_1182870446 = (requestSentRetryEnabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218803049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_218803049;
        // ---------- Original Method ----------
        //return requestSentRetryEnabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.441 -0400", hash_original_method = "C82A3B7CA490A8560B081A320AF1EB0A", hash_generated_method = "C4477CACC2929CC6A68AF4AF1E6699A8")
    public int getRetryCount() {
        int varB4DF5887CB02A4F326343B4E2FC8DC1E_1158180248 = (retryCount);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281649163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281649163;
        // ---------- Original Method ----------
        //return retryCount;
    }

    
}

