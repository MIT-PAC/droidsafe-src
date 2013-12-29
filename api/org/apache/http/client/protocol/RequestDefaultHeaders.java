package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Collection;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.protocol.HttpContext;



public class RequestDefaultHeaders implements HttpRequestInterceptor {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.363 -0500", hash_original_method = "A692411AA68D5698704806EAFB0D6447", hash_generated_method = "BD7FFDE8DB7E8AE23358B8D03BBB8E00")
    public RequestDefaultHeaders() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:23.364 -0500", hash_original_method = "BC6D4315FE478105CC299FA29DDE20AF", hash_generated_method = "10E5C0C258D6760FF3D6408A8AF1DCEE")
    public void process(final HttpRequest request, final HttpContext context) 
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        // Add default headers
        Collection<?> defHeaders = (Collection<?>) request.getParams().getParameter(
                ClientPNames.DEFAULT_HEADERS);
        if (defHeaders != null) {
            for (Object defHeader : defHeaders) {
                request.addHeader((Header) defHeader);
            }
        }
    }

    
}

