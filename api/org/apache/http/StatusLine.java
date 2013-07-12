package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface StatusLine {

    ProtocolVersion getProtocolVersion();

    int getStatusCode();

    String getReasonPhrase();
    
}
