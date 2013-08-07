package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface StatusLine {

    ProtocolVersion getProtocolVersion();

    int getStatusCode();

    String getReasonPhrase();
    
}
