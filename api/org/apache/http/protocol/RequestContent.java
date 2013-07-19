package org.apache.http.protocol;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RequestContent implements HttpRequestInterceptor {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.375 -0400", hash_original_method = "9AE5E648CA522092E457677BB79033D0", hash_generated_method = "E4F12D313596D681A69A32225957CE9E")
    public  RequestContent() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.376 -0400", hash_original_method = "2DAF25F14B8FE3908731654E049F044C", hash_generated_method = "5ABA73DA7EB3FF36409C4E7056820C4B")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1544260802 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1544260802.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1544260802;
        } //End block
        if(request instanceof HttpEntityEnclosingRequest)        
        {
            if(request.containsHeader(HTTP.TRANSFER_ENCODING))            
            {
                ProtocolException var9C708B232522398C4B32520B6B430D0F_1451302649 = new ProtocolException("Transfer-encoding header already present");
                var9C708B232522398C4B32520B6B430D0F_1451302649.addTaint(taint);
                throw var9C708B232522398C4B32520B6B430D0F_1451302649;
            } //End block
            if(request.containsHeader(HTTP.CONTENT_LEN))            
            {
                ProtocolException var5295187289166468AF16153C3268B3C3_719470444 = new ProtocolException("Content-Length header already present");
                var5295187289166468AF16153C3268B3C3_719470444.addTaint(taint);
                throw var5295187289166468AF16153C3268B3C3_719470444;
            } //End block
            ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
            if(entity == null)            
            {
                request.addHeader(HTTP.CONTENT_LEN, "0");
                return;
            } //End block
            if(entity.isChunked() || entity.getContentLength() < 0)            
            {
                if(ver.lessEquals(HttpVersion.HTTP_1_0))                
                {
                    ProtocolException var8A605811C51273610E12A5A14D77E726_946749518 = new ProtocolException(
                            "Chunked transfer encoding not allowed for " + ver);
                    var8A605811C51273610E12A5A14D77E726_946749518.addTaint(taint);
                    throw var8A605811C51273610E12A5A14D77E726_946749518;
                } //End block
                request.addHeader(HTTP.TRANSFER_ENCODING, HTTP.CHUNK_CODING);
            } //End block
            else
            {
                request.addHeader(HTTP.CONTENT_LEN, Long.toString(entity.getContentLength()));
            } //End block
            if(entity.getContentType() != null && !request.containsHeader(
                    HTTP.CONTENT_TYPE ))            
            {
                request.addHeader(entity.getContentType());
            } //End block
            if(entity.getContentEncoding() != null && !request.containsHeader(
                    HTTP.CONTENT_ENCODING))            
            {
                request.addHeader(entity.getContentEncoding());
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

