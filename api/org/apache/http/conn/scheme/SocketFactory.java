package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;

public interface SocketFactory {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Socket createSocket()
        throws IOException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Socket connectSocket(
        Socket sock,
        String host, 
        int port, 
        InetAddress localAddress, 
        int localPort,
        HttpParams params
    ) throws IOException, UnknownHostException, ConnectTimeoutException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    boolean isSecure(Socket sock)
        throws IllegalArgumentException
        ;

}
