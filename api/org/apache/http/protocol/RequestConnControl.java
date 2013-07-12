package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

public class RequestConnControl implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.974 -0400", hash_original_method = "76ED84E03F54549E28D46816E0160A3A", hash_generated_method = "72AD438ABB5E9882C9BDC97BAC97B081")
    public  RequestConnControl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.974 -0400", hash_original_method = "9C577C8F5A150200E96070754F4C1849", hash_generated_method = "F83EE8BB080AC740720CFE67D9D5C9D4")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_991962028 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_991962028.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_991962028;
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

