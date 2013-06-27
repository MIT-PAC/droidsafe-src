package org.apache.http.client.protocol;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.056 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.059 -0400", hash_original_method = "33F7F2F89F06A1D5C3C4E627DB5C44E6", hash_generated_method = "FD33866982A2765D2C23205A551EF459")
    public  RequestAddCookies() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.209 -0400", hash_original_method = "6C6FAAF5CABF854B7199A55A540BF3C8", hash_generated_method = "86DB7AF5A6727A388FDDAC78F60A0DB4")
    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP context may not be null");
        } //End block
        CookieStore cookieStore;
        cookieStore = (CookieStore) context.getAttribute(
                ClientContext.COOKIE_STORE);
        {
            this.log.info("Cookie store not available in HTTP context");
        } //End block
        CookieSpecRegistry registry;
        registry = (CookieSpecRegistry) context.getAttribute(
                ClientContext.COOKIESPEC_REGISTRY);
        {
            this.log.info("CookieSpec registry not available in HTTP context");
        } //End block
        HttpHost targetHost;
        targetHost = (HttpHost) context.getAttribute(
                ExecutionContext.HTTP_TARGET_HOST);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Target host not specified in HTTP context");
        } //End block
        ManagedClientConnection conn;
        conn = (ManagedClientConnection) context.getAttribute(
                ExecutionContext.HTTP_CONNECTION);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Client connection not specified in HTTP context");
        } //End block
        String policy;
        policy = HttpClientParams.getCookiePolicy(request.getParams());
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_848506703 = (this.log.isDebugEnabled());
            {
                this.log.debug("CookieSpec selected: " + policy);
            } //End block
        } //End collapsed parenthetic
        URI requestURI;
        {
            requestURI = ((HttpUriRequest) request).getURI();
        } //End block
        {
            try 
            {
                requestURI = new URI(request.getRequestLine().getUri());
            } //End block
            catch (URISyntaxException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid request URI: " + 
                        request.getRequestLine().getUri(), ex);
            } //End block
        } //End block
        String hostName;
        hostName = targetHost.getHostName();
        int port;
        port = targetHost.getPort();
        {
            port = conn.getRemotePort();
        } //End block
        CookieOrigin cookieOrigin;
        cookieOrigin = new CookieOrigin(
                hostName, 
                port, 
                requestURI.getPath(),
                conn.isSecure());
        CookieSpec cookieSpec;
        cookieSpec = registry.getCookieSpec(policy, request.getParams());
        List<Cookie> cookies;
        cookies = new ArrayList<Cookie>(cookieStore.getCookies());
        List<Cookie> matchedCookies;
        matchedCookies = new ArrayList<Cookie>();
        {
            Iterator<Cookie> var122FD713E52C825D20E0B3FA83D127D8_2018615938 = (cookies).iterator();
            var122FD713E52C825D20E0B3FA83D127D8_2018615938.hasNext();
            Cookie cookie = var122FD713E52C825D20E0B3FA83D127D8_2018615938.next();
            {
                {
                    boolean var0FF047161CF32E1929613C05DB808628_796626772 = (cookieSpec.match(cookie, cookieOrigin));
                    {
                        {
                            boolean var77FE74E3FD18153DC8BA47A287E94E9C_2029462047 = (this.log.isDebugEnabled());
                            {
                                this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                            } //End block
                        } //End collapsed parenthetic
                        matchedCookies.add(cookie);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var39BCE6116D6320BA679FCA2D20CAA501_53746916 = (!matchedCookies.isEmpty());
            {
                List<Header> headers;
                headers = cookieSpec.formatCookies(matchedCookies);
                {
                    Iterator<Header> varEB4B2371BC0CCACE92E0AF8B1282EFFC_1335204581 = (headers).iterator();
                    varEB4B2371BC0CCACE92E0AF8B1282EFFC_1335204581.hasNext();
                    Header header = varEB4B2371BC0CCACE92E0AF8B1282EFFC_1335204581.next();
                    {
                        request.addHeader(header);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        int ver;
        ver = cookieSpec.getVersion();
        {
            boolean needVersionHeader;
            needVersionHeader = false;
            {
                Iterator<Cookie> var48A26F2CE0607EBC42B8BB68A715D819_1803377974 = (matchedCookies).iterator();
                var48A26F2CE0607EBC42B8BB68A715D819_1803377974.hasNext();
                Cookie cookie = var48A26F2CE0607EBC42B8BB68A715D819_1803377974.next();
                {
                    {
                        boolean var58174ECE9271A4B92BFA8ED180513081_118117448 = (ver != cookie.getVersion());
                        {
                            needVersionHeader = true;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                Header header;
                header = cookieSpec.getVersionHeader();
                {
                    request.addHeader(header);
                } //End block
            } //End block
        } //End block
        context.setAttribute(ClientContext.COOKIE_SPEC, cookieSpec);
        context.setAttribute(ClientContext.COOKIE_ORIGIN, cookieOrigin);
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

