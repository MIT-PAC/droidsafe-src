package org.apache.http.client.protocol;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.825 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.825 -0400", hash_original_method = "33F7F2F89F06A1D5C3C4E627DB5C44E6", hash_generated_method = "FD33866982A2765D2C23205A551EF459")
    public  RequestAddCookies() {
        super();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.840 -0400", hash_original_method = "6C6FAAF5CABF854B7199A55A540BF3C8", hash_generated_method = "2281AE098F5248A24BF64E8C6CE9A30B")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } 
        CookieStore cookieStore = (CookieStore) context.getAttribute(
                ClientContext.COOKIE_STORE);
        {
            this.log.info("Cookie store not available in HTTP context");
        } 
        CookieSpecRegistry registry = (CookieSpecRegistry) context.getAttribute(
                ClientContext.COOKIESPEC_REGISTRY);
        {
            this.log.info("CookieSpec registry not available in HTTP context");
        } 
        HttpHost targetHost = (HttpHost) context.getAttribute(
                ExecutionContext.HTTP_TARGET_HOST);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Target host not specified in HTTP context");
        } 
        ManagedClientConnection conn = (ManagedClientConnection) context.getAttribute(
                ExecutionContext.HTTP_CONNECTION);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Client connection not specified in HTTP context");
        } 
        String policy = HttpClientParams.getCookiePolicy(request.getParams());
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_1866643485 = (this.log.isDebugEnabled());
            {
                this.log.debug("CookieSpec selected: " + policy);
            } 
        } 
        URI requestURI;
        {
            requestURI = ((HttpUriRequest) request).getURI();
        } 
        {
            try 
            {
                requestURI = new URI(request.getRequestLine().getUri());
            } 
            catch (URISyntaxException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid request URI: " + 
                        request.getRequestLine().getUri(), ex);
            } 
        } 
        String hostName = targetHost.getHostName();
        int port = targetHost.getPort();
        {
            port = conn.getRemotePort();
        } 
        CookieOrigin cookieOrigin = new CookieOrigin(
                hostName, 
                port, 
                requestURI.getPath(),
                conn.isSecure());
        CookieSpec cookieSpec = registry.getCookieSpec(policy, request.getParams());
        List<Cookie> cookies = new ArrayList<Cookie>(cookieStore.getCookies());
        List<Cookie> matchedCookies = new ArrayList<Cookie>();
        {
            Iterator<Cookie> var122FD713E52C825D20E0B3FA83D127D8_169943664 = (cookies).iterator();
            var122FD713E52C825D20E0B3FA83D127D8_169943664.hasNext();
            Cookie cookie = var122FD713E52C825D20E0B3FA83D127D8_169943664.next();
            {
                {
                    boolean var0FF047161CF32E1929613C05DB808628_424929136 = (cookieSpec.match(cookie, cookieOrigin));
                    {
                        {
                            boolean var77FE74E3FD18153DC8BA47A287E94E9C_397602013 = (this.log.isDebugEnabled());
                            {
                                this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                            } 
                        } 
                        matchedCookies.add(cookie);
                    } 
                } 
            } 
        } 
        {
            boolean var39BCE6116D6320BA679FCA2D20CAA501_782639937 = (!matchedCookies.isEmpty());
            {
                List<Header> headers = cookieSpec.formatCookies(matchedCookies);
                {
                    Iterator<Header> varEB4B2371BC0CCACE92E0AF8B1282EFFC_2140194923 = (headers).iterator();
                    varEB4B2371BC0CCACE92E0AF8B1282EFFC_2140194923.hasNext();
                    Header header = varEB4B2371BC0CCACE92E0AF8B1282EFFC_2140194923.next();
                    {
                        request.addHeader(header);
                    } 
                } 
            } 
        } 
        int ver = cookieSpec.getVersion();
        {
            boolean needVersionHeader = false;
            {
                Iterator<Cookie> var48A26F2CE0607EBC42B8BB68A715D819_907101667 = (matchedCookies).iterator();
                var48A26F2CE0607EBC42B8BB68A715D819_907101667.hasNext();
                Cookie cookie = var48A26F2CE0607EBC42B8BB68A715D819_907101667.next();
                {
                    {
                        boolean var58174ECE9271A4B92BFA8ED180513081_570694318 = (ver != cookie.getVersion());
                        {
                            needVersionHeader = true;
                        } 
                    } 
                } 
            } 
            {
                Header header = cookieSpec.getVersionHeader();
                {
                    request.addHeader(header);
                } 
            } 
        } 
        context.setAttribute(ClientContext.COOKIE_SPEC, cookieSpec);
        context.setAttribute(ClientContext.COOKIE_ORIGIN, cookieOrigin);
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        
        
    }

    
}

