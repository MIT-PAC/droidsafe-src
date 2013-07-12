package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface RequestLine {

    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
    
}
