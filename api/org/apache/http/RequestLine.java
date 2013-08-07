package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface RequestLine {

    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
    
}
