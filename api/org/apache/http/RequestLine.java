package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface RequestLine {

    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
    
}
