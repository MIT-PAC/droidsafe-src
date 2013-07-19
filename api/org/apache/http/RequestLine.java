package org.apache.http;

// Droidsafe Imports

public interface RequestLine {

    String getMethod();

    ProtocolVersion getProtocolVersion();

    String getUri();
    
}
