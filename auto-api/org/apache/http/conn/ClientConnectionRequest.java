package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public interface ClientConnectionRequest {
    
    
    ManagedClientConnection getConnection(long timeout, TimeUnit tunit) 
        throws InterruptedException, ConnectionPoolTimeoutException;
    
    
    void abortRequest();

}
