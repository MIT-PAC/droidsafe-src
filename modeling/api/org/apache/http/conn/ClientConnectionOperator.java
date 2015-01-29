package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public interface ClientConnectionOperator {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    OperatedClientConnection createConnection()
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void openConnection(OperatedClientConnection conn,
                        HttpHost target,
                        InetAddress local,
                        HttpContext context,
                        HttpParams params)
        throws IOException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    void updateSecureConnection(OperatedClientConnection conn,
                                HttpHost target,
                                HttpContext context,
                                HttpParams params)
        throws IOException
        ;

}
