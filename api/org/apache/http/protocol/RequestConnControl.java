package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

public class RequestConnControl implements HttpRequestInterceptor {

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.197 -0500", hash_original_method = "76ED84E03F54549E28D46816E0160A3A", hash_generated_method = "CFC97CD76E7073402B6FC020BFA49F5B")
    
public RequestConnControl() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.201 -0500", hash_original_method = "9C577C8F5A150200E96070754F4C1849", hash_generated_method = "5018AB48B2F72F193FFB64EAE3773C27")
    
public void process(final HttpRequest request, final HttpContext context) 
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (!request.containsHeader(HTTP.CONN_DIRECTIVE)) {
            // Default policy is to keep connection alive
            // whenever possible
            request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
    }
    
}

