package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}
