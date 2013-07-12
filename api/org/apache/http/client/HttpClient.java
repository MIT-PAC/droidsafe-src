package org.apache.http.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;

public interface HttpClient {


    
    HttpParams getParams()
        ;


    
    ClientConnectionManager getConnectionManager()
        ;

    
    HttpResponse execute(HttpUriRequest request)
        throws IOException, ClientProtocolException
        ;


    
    HttpResponse execute(HttpUriRequest request, HttpContext context)
        throws IOException, ClientProtocolException
        ;


    
    HttpResponse execute(HttpHost target, HttpRequest request)
        throws IOException, ClientProtocolException
        ;

    
    HttpResponse execute(HttpHost target, HttpRequest request,
                         HttpContext context)
        throws IOException, ClientProtocolException
        ;

    
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;

    
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler,
            HttpContext context)
        throws IOException, ClientProtocolException
        ;

    
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;
    
    
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler, 
            HttpContext context)
        throws IOException, ClientProtocolException
        ;
    
}
