package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.InetAddress;
import org.apache.http.HttpConnection;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.ProtocolException;

public class RequestTargetHost implements HttpRequestInterceptor {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.326 -0400", hash_original_method = "8E392018972A7DBBBF7C8FCDEC2420D5", hash_generated_method = "6517A03037392B0D34A56F3318F3EB95")
    public  RequestTargetHost() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.327 -0400", hash_original_method = "EFFA06EA6DD5102576B15EFE0500FD3E", hash_generated_method = "00DAF200C9E5C2F49D5F97016A882FEB")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        {
            boolean var42F48AC317DCD4FCC14CFA497F63A10F_2066854353 = (!request.containsHeader(HTTP.TARGET_HOST));
            {
                HttpHost targethost;
                targethost = (HttpHost) context
                .getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                {
                    HttpConnection conn;
                    conn = (HttpConnection) context
                    .getAttribute(ExecutionContext.HTTP_CONNECTION);
                    {
                        InetAddress address;
                        address = ((HttpInetConnection) conn).getRemoteAddress();
                        int port;
                        port = ((HttpInetConnection) conn).getRemotePort();
                        {
                            targethost = new HttpHost(address.getHostName(), port);
                        } //End block
                    } //End block
                    {
                        ProtocolVersion ver;
                        ver = request.getRequestLine().getProtocolVersion();
                        {
                            boolean var6975353BB6195CBDBBE6503768DE7665_1638762670 = (ver.lessEquals(HttpVersion.HTTP_1_0));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Target host missing");
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
                request.addHeader(HTTP.TARGET_HOST, targethost.toHostString());
            } //End block
        } //End collapsed parenthetic
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

