package org.apache.http.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.ProtocolException;

public class RequestContent implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.627 -0400", hash_original_method = "9AE5E648CA522092E457677BB79033D0", hash_generated_method = "E4F12D313596D681A69A32225957CE9E")
    public  RequestContent() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.628 -0400", hash_original_method = "2DAF25F14B8FE3908731654E049F044C", hash_generated_method = "9EF9B4C6B9BC9619BFD0DEDDEF40C543")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        {
            {
                boolean var646AE38863D06907811EC513F33403FC_749937982 = (request.containsHeader(HTTP.TRANSFER_ENCODING));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Transfer-encoding header already present");
                } 
            } 
            {
                boolean var92EF040A65FE7CFBF5D3BDFC8C44DBA4_1276149139 = (request.containsHeader(HTTP.CONTENT_LEN));
                {
                    if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Content-Length header already present");
                } 
            } 
            ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
            {
                request.addHeader(HTTP.CONTENT_LEN, "0");
            } 
            {
                boolean varB4775B085A848E4B33B43479AFA8CE42_92335005 = (entity.isChunked() || entity.getContentLength() < 0);
                {
                    {
                        boolean var8F261FF015E669BB856EC76EE9676F9A_1481865983 = (ver.lessEquals(HttpVersion.HTTP_1_0));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ProtocolException(
                            "Chunked transfer encoding not allowed for " + ver);
                        } 
                    } 
                    request.addHeader(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
                } 
                {
                    request.addHeader(HTTP.CONTENT_LEN, Long.toString(entity.getContentLength()));
                } 
            } 
            {
                boolean varB374F770732423B0FC66B80B4928A659_1619655431 = (entity.getContentType() != null && !request.containsHeader(
                    HTTP.CONTENT_TYPE ));
                {
                    request.addHeader(entity.getContentType());
                } 
            } 
            {
                boolean varB2AD78A384A88F31BC74FC6EB2E63AE6_822188854 = (entity.getContentEncoding() != null && !request.containsHeader(
                    HTTP.CONTENT_ENCODING));
                {
                    request.addHeader(entity.getContentEncoding());
                } 
            } 
        } 
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        
        
    }

    
}

