package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.protocol.HttpContext;

public interface HttpRequestInterceptor {

    
    void process(HttpRequest request, HttpContext context) 
        throws HttpException, IOException;
    
}
