package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public interface ConnectionReleaseTrigger {

    
    void releaseConnection()
        throws IOException
        ;

    
    void abortConnection()
        throws IOException
        ;


}
