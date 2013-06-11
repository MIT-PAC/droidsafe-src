package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public interface HttpRequest extends HttpMessage {

    
    RequestLine getRequestLine();
    
}

