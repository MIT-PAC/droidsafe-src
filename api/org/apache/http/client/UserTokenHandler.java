package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.protocol.HttpContext;

public interface UserTokenHandler {

    
    Object getUserToken(HttpContext context);

}
