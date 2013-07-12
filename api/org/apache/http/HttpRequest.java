package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}
