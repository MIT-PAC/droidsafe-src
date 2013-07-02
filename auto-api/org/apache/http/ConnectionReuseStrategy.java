package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.protocol.HttpContext;

public interface ConnectionReuseStrategy {

    
    boolean keepAlive(HttpResponse response, HttpContext context);
            
}
