package org.apache.http.client.methods;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.net.URI;
import org.apache.http.HttpRequest;

public interface HttpUriRequest extends HttpRequest {
    
    
    String getMethod();

    
    URI getURI();
    
    
    void abort() throws UnsupportedOperationException;
    
    
    boolean isAborted();
    
}
