package org.apache.http.protocol;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class RequestConnControl implements HttpRequestInterceptor {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.359 -0400", hash_original_method = "76ED84E03F54549E28D46816E0160A3A", hash_generated_method = "72AD438ABB5E9882C9BDC97BAC97B081")
    public  RequestConnControl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.361 -0400", hash_original_method = "9C577C8F5A150200E96070754F4C1849", hash_generated_method = "8D2CB76920E7DF2A4EF89E973CD54479")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_2134094853 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_2134094853.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_2134094853;
        } //End block
        if(!request.containsHeader(HTTP.CONN_DIRECTIVE))        
        {
            request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        } //End block
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (!request.containsHeader(HTTP.CONN_DIRECTIVE)) {
            //request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        //}
    }

    
}

