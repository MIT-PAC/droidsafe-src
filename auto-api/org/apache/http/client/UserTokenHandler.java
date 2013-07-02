package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.apache.http.protocol.HttpContext;

public interface UserTokenHandler {

    
    Object getUserToken(HttpContext context);

}
