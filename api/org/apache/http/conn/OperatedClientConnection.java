package org.apache.http.conn;

// Droidsafe Imports
import java.io.IOException;
import java.net.Socket;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.params.HttpParams;

public interface OperatedClientConnection
    extends HttpClientConnection, HttpInetConnection {

    
    HttpHost getTargetHost()
        ;

    
    boolean isSecure()
        ;

    
    Socket getSocket()
        ;


    
    


    
    void opening(Socket sock, HttpHost target)
        throws IOException
        ;


    
    void openCompleted(boolean secure, HttpParams params)
        throws IOException
        ;


    
    void update(Socket sock, HttpHost target,
                boolean secure, HttpParams params)
        throws IOException
        ;


}
