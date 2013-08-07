package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HttpContext {

    
    public static final String RESERVED_PREFIX  = "http.";
    
    Object getAttribute(String id);

    void setAttribute(String id, Object obj);

    Object removeAttribute(String id);
    
}
