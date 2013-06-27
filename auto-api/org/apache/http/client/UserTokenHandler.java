package org.apache.http.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.protocol.HttpContext;

public interface UserTokenHandler {

    
    Object getUserToken(HttpContext context);

}
