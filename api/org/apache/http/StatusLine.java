package org.apache.http;

// Droidsafe Imports

public interface StatusLine {

    ProtocolVersion getProtocolVersion();

    int getStatusCode();

    String getReasonPhrase();
    
}
