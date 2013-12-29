package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}
