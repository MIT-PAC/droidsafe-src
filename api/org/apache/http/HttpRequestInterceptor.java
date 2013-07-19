package org.apache.http;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.protocol.HttpContext;

public interface HttpRequestInterceptor {

    
    void process(HttpRequest request, HttpContext context) 
        throws HttpException, IOException;
    
}
