package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.492 -0400", hash_original_method = "6FB86855078200C1DA7E1696137BDEB8", hash_generated_method = "D8D48DC6FB0C5155B811101DF979F44F")
    public  RequestExpectContinue() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.494 -0400", hash_original_method = "B3CB825553A33FEA3F57BDDA16C378C7", hash_generated_method = "9CD61B4EC0EFFED55CBA4A9456813079")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            HttpEntity entity;
            entity = ((HttpEntityEnclosingRequest)request).getEntity();
            {
                boolean var4944D89B0F1A4A638A555D105D049CFA_659858089 = (entity != null && entity.getContentLength() != 0);
                {
                    ProtocolVersion ver;
                    ver = request.getRequestLine().getProtocolVersion();
                    {
                        boolean varFF142DD59BEC80C55FE67AABEEC74711_2122784757 = (HttpProtocolParams.useExpectContinue(request.getParams()) 
                        && !ver.lessEquals(HttpVersion.HTTP_1_0));
                        {
                            request.addHeader(HTTP.EXPECT_DIRECTIVE, HTTP.EXPECT_CONTINUE);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(request.getTaint());
        addTaint(context.getTaint());
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

