package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSession;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public interface ManagedClientConnection extends
    HttpClientConnection, HttpInetConnection, ConnectionReleaseTrigger {


    
    boolean isSecure()
        ;


    
    HttpRoute getRoute()
        ;


    
    SSLSession getSSLSession()
        ;


    
    void open(HttpRoute route, HttpContext context, HttpParams params)
        throws IOException
        ;


    
    void tunnelTarget(boolean secure, HttpParams params)
        throws IOException
        ;


    
    void tunnelProxy(HttpHost next, boolean secure, HttpParams params)
        throws IOException
        ;


    
    void layerProtocol(HttpContext context, HttpParams params)
        throws IOException
        ;


    
    void markReusable()
        ;


    
    void unmarkReusable()
        ;


    
    boolean isMarkedReusable()
        ;

    
    void setState(Object state)
        ;
    
    
    Object getState()
        ;
    
    
    void setIdleDuration(long duration, TimeUnit unit);

}
