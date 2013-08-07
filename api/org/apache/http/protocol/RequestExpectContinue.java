package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.HttpProtocolParams;





public class RequestExpectContinue implements HttpRequestInterceptor {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.389 -0400", hash_original_method = "6FB86855078200C1DA7E1696137BDEB8", hash_generated_method = "D8D48DC6FB0C5155B811101DF979F44F")
    public  RequestExpectContinue() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.391 -0400", hash_original_method = "B3CB825553A33FEA3F57BDDA16C378C7", hash_generated_method = "B2C7BB67E8B294A0C8E55F673D253214")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_834381733 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_834381733.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_834381733;
        } //End block
        if(request instanceof HttpEntityEnclosingRequest)        
        {
            HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
            if(entity != null && entity.getContentLength() != 0)            
            {
                ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
                if(HttpProtocolParams.useExpectContinue(request.getParams()) 
                        && !ver.lessEquals(HttpVersion.HTTP_1_0))                
                {
                    request.addHeader(HTTP.EXPECT_DIRECTIVE, HTTP.EXPECT_CONTINUE);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (request instanceof HttpEntityEnclosingRequest) {
            //HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
            //if (entity != null && entity.getContentLength() != 0) { 
                //ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
                //if (HttpProtocolParams.useExpectContinue(request.getParams()) 
                        //&& !ver.lessEquals(HttpVersion.HTTP_1_0)) {
                    //request.addHeader(HTTP.EXPECT_DIRECTIVE, HTTP.EXPECT_CONTINUE);
                //}
            //}
        //}
    }

    
}

