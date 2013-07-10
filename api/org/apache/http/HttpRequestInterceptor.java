package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.protocol.HttpContext;

public interface HttpRequestInterceptor {

    
    void process(HttpRequest request, HttpContext context) 
        throws HttpException, IOException;
    
}
