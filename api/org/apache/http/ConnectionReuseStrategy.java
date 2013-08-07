package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.protocol.HttpContext;

public interface ConnectionReuseStrategy {

    
    boolean keepAlive(HttpResponse response, HttpContext context);
            
}
