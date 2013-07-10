package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.protocol.HttpContext;

public interface HttpRequestRetryHandler {

    
    boolean retryRequest(IOException exception, int executionCount, HttpContext context);

}
