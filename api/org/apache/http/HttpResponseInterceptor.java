package org.apache.http;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.protocol.HttpContext;

public interface HttpResponseInterceptor {

    
    void process(HttpResponse response, HttpContext context) 
        throws HttpException, IOException;

}
