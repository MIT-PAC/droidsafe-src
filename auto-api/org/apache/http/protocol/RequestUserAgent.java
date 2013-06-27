package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpProtocolParams;

public class RequestUserAgent implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.318 -0400", hash_original_method = "C4ABF37EB88E79840E3C3C778B3D3723", hash_generated_method = "6AC3C7B8C84D6604FDB3259D42FE25C2")
    public  RequestUserAgent() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.319 -0400", hash_original_method = "97A5868326343AB54CF8EB07ADAC3DCF", hash_generated_method = "2FC16676068876D99C5FEEB007F85FCE")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            boolean var49D75A39221CB5928F53FD09F81E4344_612590757 = (!request.containsHeader(HTTP.USER_AGENT));
            {
                String useragent;
                useragent = HttpProtocolParams.getUserAgent(request.getParams());
                {
                    request.addHeader(HTTP.USER_AGENT, useragent);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        addTaint(context.getTaint());
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

