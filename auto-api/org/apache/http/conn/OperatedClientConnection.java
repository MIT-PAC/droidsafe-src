package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
