package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.protocol.HttpContext;

public interface HttpResponseFactory {

        
    HttpResponse newHttpResponse(ProtocolVersion ver, int status,
                                 HttpContext context);
    
        
    HttpResponse newHttpResponse(StatusLine statusline,
                                 HttpContext context);
    
}
