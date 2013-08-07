package org.apache.http.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.apache.http.protocol.HttpContext;

public interface UserTokenHandler {

    
    Object getUserToken(HttpContext context);

}
