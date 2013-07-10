package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpProtocolParams;

public class RequestUserAgent implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.655 -0400", hash_original_method = "C4ABF37EB88E79840E3C3C778B3D3723", hash_generated_method = "6AC3C7B8C84D6604FDB3259D42FE25C2")
    public  RequestUserAgent() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.656 -0400", hash_original_method = "97A5868326343AB54CF8EB07ADAC3DCF", hash_generated_method = "322F0DB7A7559851B6F59E5DE36C2073")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        {
            boolean var49D75A39221CB5928F53FD09F81E4344_443050808 = (!request.containsHeader(HTTP.USER_AGENT));
            {
                String useragent = HttpProtocolParams.getUserAgent(request.getParams());
                {
                    request.addHeader(HTTP.USER_AGENT, useragent);
                } 
            } 
        } 
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        
        
            
        
        
            
            
                
            
        
    }

    
}

