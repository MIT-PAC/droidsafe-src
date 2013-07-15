package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.protocol.HttpContext;

public interface HttpResponseInterceptor {

    
    void process(HttpResponse response, HttpContext context) 
        throws HttpException, IOException;

}
