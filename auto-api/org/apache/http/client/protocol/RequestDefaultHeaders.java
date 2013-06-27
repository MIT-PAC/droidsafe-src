package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Collection;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.protocol.HttpContext;

public class RequestDefaultHeaders implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.029 -0400", hash_original_method = "A692411AA68D5698704806EAFB0D6447", hash_generated_method = "BC9A54616EA56C3FB9CBB65BD3CE817E")
    public  RequestDefaultHeaders() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.053 -0400", hash_original_method = "BC6D4315FE478105CC299FA29DDE20AF", hash_generated_method = "808CE443E131857C78C128EF5D8481C0")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        Collection<?> defHeaders;
        defHeaders = (Collection<?>) request.getParams().getParameter(
                ClientPNames.DEFAULT_HEADERS);
        {
            {
                Iterator<Object> var6DB89BCBACB10D0D7F512BB6B9D9D2DC_164992794 = (defHeaders).iterator();
                var6DB89BCBACB10D0D7F512BB6B9D9D2DC_164992794.hasNext();
                Object defHeader = var6DB89BCBACB10D0D7F512BB6B9D9D2DC_164992794.next();
                {
                    request.addHeader((Header) defHeader);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //Collection<?> defHeaders = (Collection<?>) request.getParams().getParameter(
                //ClientPNames.DEFAULT_HEADERS);
        //if (defHeaders != null) {
            //for (Object defHeader : defHeaders) {
                //request.addHeader((Header) defHeader);
            //}
        //}
    }

    
}

