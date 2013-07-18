package org.apache.http.client;

// Droidsafe Imports
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HttpContext;

public interface RedirectHandler {

    
    boolean isRedirectRequested(HttpResponse response, HttpContext context);
    
    
    URI getLocationURI(HttpResponse response, HttpContext context)
            throws ProtocolException;

}
