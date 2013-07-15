package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.ProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.ExecutionContext;

public class RequestAddCookies implements HttpRequestInterceptor {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.237 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.237 -0400", hash_original_method = "33F7F2F89F06A1D5C3C4E627DB5C44E6", hash_generated_method = "FD33866982A2765D2C23205A551EF459")
    public  RequestAddCookies() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.239 -0400", hash_original_method = "6C6FAAF5CABF854B7199A55A540BF3C8", hash_generated_method = "7BD4AEA5ABEE11CCE753EF78203FCD0B")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_447729559 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_447729559.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_447729559;
        } //End block
    if(context == null)        
        {
            IllegalArgumentException var313A469DAA78732DF88285478241413C_951322247 = new IllegalArgumentException("HTTP context may not be null");
            var313A469DAA78732DF88285478241413C_951322247.addTaint(taint);
            throw var313A469DAA78732DF88285478241413C_951322247;
        } //End block
        CookieStore cookieStore = (CookieStore) context.getAttribute(
                ClientContext.COOKIE_STORE);
    if(cookieStore == null)        
        {
            this.log.info("Cookie store not available in HTTP context");
            return;
        } //End block
        CookieSpecRegistry registry = (CookieSpecRegistry) context.getAttribute(
                ClientContext.COOKIESPEC_REGISTRY);
    if(registry == null)        
        {
            this.log.info("CookieSpec registry not available in HTTP context");
            return;
        } //End block
        HttpHost targetHost = (HttpHost) context.getAttribute(
                ExecutionContext.HTTP_TARGET_HOST);
    if(targetHost == null)        
        {
            IllegalStateException var760295C0041D27B820596D897E314707_1912359620 = new IllegalStateException("Target host not specified in HTTP context");
            var760295C0041D27B820596D897E314707_1912359620.addTaint(taint);
            throw var760295C0041D27B820596D897E314707_1912359620;
        } //End block
        ManagedClientConnection conn = (ManagedClientConnection) context.getAttribute(
                ExecutionContext.HTTP_CONNECTION);
    if(conn == null)        
        {
            IllegalStateException var07DF5B38AAE2601AC052DE1F8DCAC126_98654397 = new IllegalStateException("Client connection not specified in HTTP context");
            var07DF5B38AAE2601AC052DE1F8DCAC126_98654397.addTaint(taint);
            throw var07DF5B38AAE2601AC052DE1F8DCAC126_98654397;
        } //End block
        String policy = HttpClientParams.getCookiePolicy(request.getParams());
    if(this.log.isDebugEnabled())        
        {
            this.log.debug("CookieSpec selected: " + policy);
        } //End block
        URI requestURI;
    if(request instanceof HttpUriRequest)        
        {
            requestURI = ((HttpUriRequest) request).getURI();
        } //End block
        else
        {
            try 
            {
                requestURI = new URI(request.getRequestLine().getUri());
            } //End block
            catch (URISyntaxException ex)
            {
                ProtocolException varF248FA419F42B78570E40734E6F28F4D_866587834 = new ProtocolException("Invalid request URI: " + 
                        request.getRequestLine().getUri(), ex);
                varF248FA419F42B78570E40734E6F28F4D_866587834.addTaint(taint);
                throw varF248FA419F42B78570E40734E6F28F4D_866587834;
            } //End block
        } //End block
        String hostName = targetHost.getHostName();
        int port = targetHost.getPort();
    if(port < 0)        
        {
            port = conn.getRemotePort();
        } //End block
        CookieOrigin cookieOrigin = new CookieOrigin(
                hostName, 
                port, 
                requestURI.getPath(),
                conn.isSecure());
        CookieSpec cookieSpec = registry.getCookieSpec(policy, request.getParams());
        List<Cookie> cookies = new ArrayList<Cookie>(cookieStore.getCookies());
        List<Cookie> matchedCookies = new ArrayList<Cookie>();
for(Cookie cookie : cookies)
        {
    if(cookieSpec.match(cookie, cookieOrigin))            
            {
    if(this.log.isDebugEnabled())                
                {
                    this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                } //End block
                matchedCookies.add(cookie);
            } //End block
        } //End block
    if(!matchedCookies.isEmpty())        
        {
            List<Header> headers = cookieSpec.formatCookies(matchedCookies);
for(Header header : headers)
            {
                request.addHeader(header);
            } //End block
        } //End block
        int ver = cookieSpec.getVersion();
    if(ver > 0)        
        {
            boolean needVersionHeader = false;
for(Cookie cookie : matchedCookies)
            {
    if(ver != cookie.getVersion())                
                {
                    needVersionHeader = true;
                } //End block
            } //End block
    if(needVersionHeader)            
            {
                Header header = cookieSpec.getVersionHeader();
    if(header != null)                
                {
                    request.addHeader(header);
                } //End block
            } //End block
        } //End block
        context.setAttribute(ClientContext.COOKIE_SPEC, cookieSpec);
        context.setAttribute(ClientContext.COOKIE_ORIGIN, cookieOrigin);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

