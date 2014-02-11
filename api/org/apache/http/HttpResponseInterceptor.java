package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.protocol.HttpContext;

public interface HttpResponseInterceptor {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSVerified
    void process(HttpResponse response, HttpContext context) 
        throws HttpException, IOException;

}
