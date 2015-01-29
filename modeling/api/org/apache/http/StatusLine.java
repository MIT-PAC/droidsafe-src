package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public interface StatusLine {

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    ProtocolVersion getProtocolVersion();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    int getStatusCode();

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    String getReasonPhrase();
    
}
