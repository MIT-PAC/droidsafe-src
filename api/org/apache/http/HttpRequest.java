package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}
