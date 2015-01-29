package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.protocol.HttpContext;

public interface HttpRequestRetryHandler {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean retryRequest(IOException exception, int executionCount, HttpContext context);

}
