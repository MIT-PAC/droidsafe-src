package org.apache.http.conn.scheme;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public interface LayeredSocketFactory extends SocketFactory {

    
    Socket createSocket(
        Socket socket, 
        String host, 
        int port, 
        boolean autoClose
    ) throws IOException, UnknownHostException;              

}
