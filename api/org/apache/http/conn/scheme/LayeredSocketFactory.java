package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public interface LayeredSocketFactory extends SocketFactory {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    Socket createSocket(
        Socket socket, 
        String host, 
        int port, 
        boolean autoClose
    ) throws IOException, UnknownHostException;

}
