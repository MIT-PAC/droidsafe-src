package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;

public class RequestConnControl implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.470 -0400", hash_original_method = "76ED84E03F54549E28D46816E0160A3A", hash_generated_method = "72AD438ABB5E9882C9BDC97BAC97B081")
    public  RequestConnControl() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.485 -0400", hash_original_method = "9C577C8F5A150200E96070754F4C1849", hash_generated_method = "D9B5BD7BD12A020140E5FC09EF2C8F6C")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            boolean var0A9B5FA9EDF930E2CAFE1EEAD6AAFE3E_1784787661 = (!request.containsHeader(HTTP.CONN_DIRECTIVE));
            {
                request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //if (!request.containsHeader(HTTP.CONN_DIRECTIVE)) {
            //request.addHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        //}
    }

    
}

