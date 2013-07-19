package org.apache.http;

// Droidsafe Imports

public interface HttpEntityEnclosingRequest extends HttpRequest {

    
    boolean expectContinue();
    
    
    void setEntity(HttpEntity entity);
    
    HttpEntity getEntity();
    
}
