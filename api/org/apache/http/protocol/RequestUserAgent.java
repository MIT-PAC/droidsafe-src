package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.params.HttpProtocolParams;





public class RequestUserAgent implements HttpRequestInterceptor {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.941 -0500", hash_original_method = "C4ABF37EB88E79840E3C3C778B3D3723", hash_generated_method = "3B89854E56F53FC6151AA5D1DD5BED4D")
    public RequestUserAgent() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.942 -0500", hash_original_method = "97A5868326343AB54CF8EB07ADAC3DCF", hash_generated_method = "5DA34AA39E9A51FFCCABD26BB3BFBF4F")
    public void process(final HttpRequest request, final HttpContext context) 
        throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (!request.containsHeader(HTTP.USER_AGENT)) {
            String useragent = HttpProtocolParams.getUserAgent(request.getParams());
            if (useragent != null) {
                request.addHeader(HTTP.USER_AGENT, useragent);
            }
        }
    }

    
}

