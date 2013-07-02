package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HttpContext;

public interface RedirectHandler {

    
    boolean isRedirectRequested(HttpResponse response, HttpContext context);
    
    
    URI getLocationURI(HttpResponse response, HttpContext context)
            throws ProtocolException;

}
