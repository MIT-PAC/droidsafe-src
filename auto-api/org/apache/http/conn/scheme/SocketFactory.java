package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpParams;

public interface SocketFactory {

    
    Socket createSocket()
        throws IOException
        ;


    
    Socket connectSocket(
        Socket sock,
        String host, 
        int port, 
        InetAddress localAddress, 
        int localPort,
        HttpParams params
    ) throws IOException, UnknownHostException, ConnectTimeoutException;


    
    boolean isSecure(Socket sock)
        throws IllegalArgumentException
        ;

}
