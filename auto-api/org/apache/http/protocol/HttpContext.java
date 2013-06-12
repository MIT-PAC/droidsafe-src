package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface HttpContext {

    
    public static final String RESERVED_PREFIX  = "http.";
    
    Object getAttribute(String id);

    void setAttribute(String id, Object obj);

    Object removeAttribute(String id);
    
}

