package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.TimeUnit;

import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.scheme.SchemeRegistry;

public interface ClientConnectionManager {

    
    SchemeRegistry getSchemeRegistry()
        ;

    
    
    ClientConnectionRequest requestConnection(HttpRoute route, Object state)
        ;


    
    void releaseConnection(ManagedClientConnection conn, long validDuration, TimeUnit timeUnit)
        ;


    
    void closeIdleConnections(long idletime, TimeUnit tunit)
        ;

    
    void closeExpiredConnections();

    
    void shutdown()
        ;


}
