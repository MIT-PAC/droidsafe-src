package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.protocol.HttpContext;

public interface HttpResponseFactory {

        
    HttpResponse newHttpResponse(ProtocolVersion ver, int status,
                                 HttpContext context);
    
        
    HttpResponse newHttpResponse(StatusLine statusline,
                                 HttpContext context);
    
}
