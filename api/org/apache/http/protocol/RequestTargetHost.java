package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.007 -0400", hash_original_method = "8E392018972A7DBBBF7C8FCDEC2420D5", hash_generated_method = "6517A03037392B0D34A56F3318F3EB95")
    public  RequestTargetHost() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:38.009 -0400", hash_original_method = "EFFA06EA6DD5102576B15EFE0500FD3E", hash_generated_method = "25FF8F4C715769B8F60A8C971F1FD5F2")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_2067715678 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_2067715678.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_2067715678;
        } //End block
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_1123239893 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_1123239893.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_1123239893;
        } //End block
    if(!request.containsHeader(HTTP.TARGET_HOST))        
        {
            HttpHost targethost = (HttpHost) context
                .getAttribute(ExecutionContext.HTTP_TARGET_HOST);
    if(targethost == null)            
            {
                HttpConnection conn = (HttpConnection) context
                    .getAttribute(ExecutionContext.HTTP_CONNECTION);
    if(conn instanceof HttpInetConnection)                
                {
                    InetAddress address = ((HttpInetConnection) conn).getRemoteAddress();
                    int port = ((HttpInetConnection) conn).getRemotePort();
    if(address != null)                    
                    {
                        targethost = new HttpHost(address.getHostName(), port);
                    } //End block
                } //End block
    if(targethost == null)                
                {
                    ProtocolVersion ver = request.getRequestLine().getProtocolVersion();
    if(ver.lessEquals(HttpVersion.HTTP_1_0))                    
                    {
                        return;
                    } //End block
                    else
                    {
                        ProtocolException varA557E6481C232D003289F510B5D5329E_1769046764 = new ProtocolException("Target host missing");
                        varA557E6481C232D003289F510B5D5329E_1769046764.addTaint(taint);
                        throw varA557E6481C232D003289F510B5D5329E_1769046764;
                    } //End block
                } //End block
            } //End block
            request.addHeader(HTTP.TARGET_HOST, targethost.toHostString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

