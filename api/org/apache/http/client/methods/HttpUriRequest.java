package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.URI;

import org.apache.http.HttpRequest;

public interface HttpUriRequest extends HttpRequest {
    
    
    String getMethod();

    
    URI getURI();
    
    
    void abort() throws UnsupportedOperationException;
    
    
    boolean isAborted();
    
}
