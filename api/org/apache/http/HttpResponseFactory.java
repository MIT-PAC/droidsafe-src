package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.protocol.HttpContext;

public interface HttpResponseFactory {
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    HttpResponse newHttpResponse(ProtocolVersion ver, int status,
                                 HttpContext context);
        
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    HttpResponse newHttpResponse(StatusLine statusline,
                                 HttpContext context);
    
}
