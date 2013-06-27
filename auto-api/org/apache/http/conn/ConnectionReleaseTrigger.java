package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;

public interface ConnectionReleaseTrigger {

    
    void releaseConnection()
        throws IOException
        ;

    
    void abortConnection()
        throws IOException
        ;


}
