package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}
