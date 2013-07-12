package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpProtocolParams;

public class RequestUserAgent implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.015 -0400", hash_original_method = "C4ABF37EB88E79840E3C3C778B3D3723", hash_generated_method = "6AC3C7B8C84D6604FDB3259D42FE25C2")
    public  RequestUserAgent() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.015 -0400", hash_original_method = "97A5868326343AB54CF8EB07ADAC3DCF", hash_generated_method = "2469588C8DB90DCAF93550A67BB0CECD")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1370898135 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1370898135.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1370898135;
        } //End block
    if(!request.containsHeader(HTTP.USER_AGENT))        
        {
            String useragent = HttpProtocolParams.getUserAgent(request.getParams());
    if(useragent != null)            
            {
                request.addHeader(HTTP.USER_AGENT, useragent);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (!request.containsHeader(HTTP.USER_AGENT)) {
            //String useragent = HttpProtocolParams.getUserAgent(request.getParams());
            //if (useragent != null) {
                //request.addHeader(HTTP.USER_AGENT, useragent);
            //}
        //}
    }

    
}

