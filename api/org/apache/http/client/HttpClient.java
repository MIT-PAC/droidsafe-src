package org.apache.http.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public interface HttpClient {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    HttpParams getParams()
        ;
    
    ClientConnectionManager getConnectionManager()
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpUriRequest request)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpUriRequest request, HttpContext context)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpHost target, HttpRequest request)
        throws IOException, ClientProtocolException
        ;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    HttpResponse execute(HttpHost target, HttpRequest request,
                         HttpContext context)
        throws IOException, ClientProtocolException
        ;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})   
    <T> T execute(
            HttpUriRequest request, 
            ResponseHandler<? extends T> responseHandler,
            HttpContext context)
        throws IOException, ClientProtocolException
        ;

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler)
        throws IOException, ClientProtocolException
        ;
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSSink({DSSinkKind.NETWORK})   
    <T> T execute(
            HttpHost target, 
            HttpRequest request,
            ResponseHandler<? extends T> responseHandler, 
            HttpContext context)
        throws IOException, ClientProtocolException
        ;
    
}
