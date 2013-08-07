package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

public interface ConnectionReleaseTrigger {

    
    void releaseConnection()
        throws IOException
        ;

    
    void abortConnection()
        throws IOException
        ;


}
