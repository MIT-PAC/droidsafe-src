package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpContext {

    
    public static final String RESERVED_PREFIX  = "http.";
    
    Object getAttribute(String id);

    void setAttribute(String id, Object obj);

    Object removeAttribute(String id);
    
}
