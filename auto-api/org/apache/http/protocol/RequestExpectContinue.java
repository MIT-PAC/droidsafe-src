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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.639 -0400", hash_original_method = "6FB86855078200C1DA7E1696137BDEB8", hash_generated_method = "D8D48DC6FB0C5155B811101DF979F44F")
    public  RequestExpectContinue() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.639 -0400", hash_original_method = "B3CB825553A33FEA3F57BDDA16C378C7", hash_generated_method = "233C3D4AF1D07B226325DE24D012FEAF")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
            {
                boolean var4944D89B0F1A4A638A555D105D049CFA_1805816574 = (entity != null && entity.getContentLength() != 0);
                {
                    ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
                    {
                        boolean varFF142DD59BEC80C55FE67AABEEC74711_1676107507 = (HttpProtocolParams.useExpectContinue(request.getParams()) 
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

