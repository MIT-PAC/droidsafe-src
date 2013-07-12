package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpEntityEnclosingRequest extends HttpRequest {

    
    boolean expectContinue();
    
    
    void setEntity(HttpEntity entity);
    
    HttpEntity getEntity();
    
}
