package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HttpEntityEnclosingRequest extends HttpRequest {

    
    boolean expectContinue();
    
    
    void setEntity(HttpEntity entity);
    
    HttpEntity getEntity();
    
}
