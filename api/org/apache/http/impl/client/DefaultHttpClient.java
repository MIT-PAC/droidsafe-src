package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.apache.http.client.protocol.RequestProxyAuthentication;
import org.apache.http.client.protocol.RequestTargetAuthentication;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionManagerFactory;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.impl.DefaultConnectionReuseStrategy;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.auth.DigestSchemeFactory;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.impl.cookie.NetscapeDraftSpecFactory;
import org.apache.http.impl.cookie.RFC2109SpecFactory;
import org.apache.http.impl.cookie.RFC2965SpecFactory;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestExecutor;
import org.apache.http.protocol.RequestConnControl;
import org.apache.http.protocol.RequestContent;
import org.apache.http.protocol.RequestExpectContinue;
import org.apache.http.protocol.RequestTargetHost;
import org.apache.http.protocol.RequestUserAgent;
import org.apache.http.util.VersionInfo;

public class DefaultHttpClient extends AbstractHttpClient {

    /**
     * Creates a new HTTP client from parameters and a connection manager.
     *
     * @param params    the parameters
     * @param conman    the connection manager
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.247 -0500", hash_original_method = "F1394B84DFE9E4D59F4D1D68B51FC2CF", hash_generated_method = "F906F7D9FEB9182ED6C9030C043C536D")
    
public DefaultHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        super(conman, params);
    }
       
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.249 -0500", hash_original_method = "E0C829A12DCA716ADA587F6BA150989E", hash_generated_method = "A8A0D17BBC5D360DC78B763D6D829C3F")
    
public DefaultHttpClient(final HttpParams params) {
        super(null, params);
    }
    
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.252 -0500", hash_original_method = "750193D90CA0949C0C735B3486D9889C", hash_generated_method = "C2281E91FF5D0B24DBCBA793897CD3E2")
    
public DefaultHttpClient() {
        super(null, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.254 -0500", hash_original_method = "7CB663CBD5778E22C9AD8E80132ECD7C", hash_generated_method = "DE507A8477EB121C42A0C5C9CEDDAA35")
    
@Override
    protected HttpParams createHttpParams() {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, 
                HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, 
                HTTP.DEFAULT_CONTENT_CHARSET);

        /*
         * Android note: Send each request body without first asking the server
         * whether it will be accepted. Asking first slows down the common case
         * and results in "417 expectation failed" errors when a HTTP/1.0 server
         * is behind a proxy. http://b/2471595
         */
        HttpProtocolParams.setUseExpectContinue(params, 
                false); // android-changed

        // determine the release version from packaged version info
        final VersionInfo vi = VersionInfo.loadVersionInfo
            ("org.apache.http.client", getClass().getClassLoader());
        final String release = (vi != null) ?
            vi.getRelease() : VersionInfo.UNAVAILABLE;
        HttpProtocolParams.setUserAgent(params, 
                "Apache-HttpClient/" + release + " (java 1.4)");

        return params;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.257 -0500", hash_original_method = "F3505412AB0839480CB671E1A4D22DAB", hash_generated_method = "E9610A148495136FA39A2DA7FA60A8D2")
    
@Override
    protected HttpRequestExecutor createRequestExecutor() {
        return new HttpRequestExecutor();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.259 -0500", hash_original_method = "C42A8A1E8C3C461006C6920C87D13C0A", hash_generated_method = "3E64F6DEC5D7C9369A75074C865804E3")
    
@Override
    protected ClientConnectionManager createClientConnectionManager() {
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(
                new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(
                new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));

        ClientConnectionManager connManager = null;     
        HttpParams params = getParams();
        
        ClientConnectionManagerFactory factory = null;

        // Try first getting the factory directly as an object.
        factory = (ClientConnectionManagerFactory) params
                .getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY);
        if (factory == null) { // then try getting its class name.
            String className = (String) params.getParameter(
                    ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
            if (className != null) {
                try {
                    Class<?> clazz = Class.forName(className);
                    factory = (ClientConnectionManagerFactory) clazz.newInstance();
                } catch (ClassNotFoundException ex) {
                    throw new IllegalStateException("Invalid class name: " + className);
                } catch (IllegalAccessException ex) {
                    throw new IllegalAccessError(ex.getMessage());
                } catch (InstantiationException ex) {
                    throw new InstantiationError(ex.getMessage());
                }
            }
        }
        
        if(factory != null) {
            connManager = factory.newInstance(params, registry);
        } else {
            connManager = new SingleClientConnManager(getParams(), registry); 
        }
        
        return connManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.262 -0500", hash_original_method = "25CB6129B8FDB94E4986C80A494E2B06", hash_generated_method = "71D3088C96B76CD02A26BBF639087B59")
    
@Override
    protected HttpContext createHttpContext() {
        HttpContext context = new BasicHttpContext();
        context.setAttribute(
                ClientContext.AUTHSCHEME_REGISTRY, 
                getAuthSchemes());
        context.setAttribute(
                ClientContext.COOKIESPEC_REGISTRY, 
                getCookieSpecs());
        context.setAttribute(
                ClientContext.COOKIE_STORE, 
                getCookieStore());
        context.setAttribute(
                ClientContext.CREDS_PROVIDER, 
                getCredentialsProvider());
        return context;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.264 -0500", hash_original_method = "D717E5D917BACE4DBA9E14F0AD65F48C", hash_generated_method = "CA80DE746762F1F3E3B77968ACD0DEF1")
    
@Override
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        return new DefaultConnectionReuseStrategy();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.267 -0500", hash_original_method = "EFD49BF95531A6CFB8AB7833D5492B46", hash_generated_method = "6C16CAE94DC1FF09A2CD37952CA885FF")
    
@Override
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        return new DefaultConnectionKeepAliveStrategy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.270 -0500", hash_original_method = "75C52B493B32BA0931FDF11A10703B36", hash_generated_method = "A08E4CEFEFCDA0F606B484044E5ACF91")
    
@Override
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry registry = new AuthSchemeRegistry(); 
        registry.register(
                AuthPolicy.BASIC, 
                new BasicSchemeFactory());
        registry.register(
                AuthPolicy.DIGEST, 
                new DigestSchemeFactory());
        return registry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.273 -0500", hash_original_method = "2986BF87A2DD05E6E31FCC1654EB03B5", hash_generated_method = "D63B13F5E8799427A74AE56B7D1986FF")
    
@Override
    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry registry = new CookieSpecRegistry();
        registry.register(
                CookiePolicy.BEST_MATCH, 
                new BestMatchSpecFactory());
        registry.register(
                CookiePolicy.BROWSER_COMPATIBILITY, 
                new BrowserCompatSpecFactory());
        registry.register(
                CookiePolicy.NETSCAPE, 
                new NetscapeDraftSpecFactory());
        registry.register(
                CookiePolicy.RFC_2109, 
                new RFC2109SpecFactory());
        registry.register(
                CookiePolicy.RFC_2965, 
                new RFC2965SpecFactory());
        return registry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.276 -0500", hash_original_method = "2E7E8D0B83423FC6C240BF5D6DCBDE4D", hash_generated_method = "53E5A9C9A3A4D1547625AA77B59D3219")
    
@Override
    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor httpproc = new BasicHttpProcessor();
        httpproc.addInterceptor(new RequestDefaultHeaders());
        // Required protocol interceptors
        httpproc.addInterceptor(new RequestContent());
        httpproc.addInterceptor(new RequestTargetHost());
        // Recommended protocol interceptors
        httpproc.addInterceptor(new RequestConnControl());
        httpproc.addInterceptor(new RequestUserAgent());
        httpproc.addInterceptor(new RequestExpectContinue());
        // HTTP state management interceptors
        httpproc.addInterceptor(new RequestAddCookies());
        httpproc.addInterceptor(new ResponseProcessCookies());
        // HTTP authentication interceptors
        httpproc.addInterceptor(new RequestTargetAuthentication());
        httpproc.addInterceptor(new RequestProxyAuthentication());
        return httpproc;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.278 -0500", hash_original_method = "060CC3B74841E3F6FC79CC89E59C47D3", hash_generated_method = "8D23531C58A175032AAA9585BA2458A8")
    
@Override
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        return new DefaultHttpRequestRetryHandler();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.280 -0500", hash_original_method = "4B5E8754A7C96AB1D27440EE21EB62A0", hash_generated_method = "3936A0EFE17DEFBE6BE049B78DE41FED")
    
@Override
    protected RedirectHandler createRedirectHandler() {
        return new DefaultRedirectHandler();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.282 -0500", hash_original_method = "CE20EA4DC0B433CD2AE1F8D13D6593E2", hash_generated_method = "0D1DB14A76C5E9993A866BCE7B5F13EE")
    
@Override
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        return new DefaultTargetAuthenticationHandler();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.285 -0500", hash_original_method = "B6E682DFDA0487EF6FFF82AF7B123D48", hash_generated_method = "2000DF83F4553BBEBFA78113D7C26D09")
    
@Override
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        return new DefaultProxyAuthenticationHandler();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.287 -0500", hash_original_method = "EF2D14C866EAD04A4C29973169C02328", hash_generated_method = "759B155884309A8EE0C3C657632F751E")
    
@Override
    protected CookieStore createCookieStore() {
        return new BasicCookieStore();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.289 -0500", hash_original_method = "7086A691E773C3CE0961AEAF5E488C24", hash_generated_method = "D07D683464361168E4F95A15CCA51123")
    
@Override
    protected CredentialsProvider createCredentialsProvider() {
        return new BasicCredentialsProvider();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.291 -0500", hash_original_method = "0D3A0E833E374EE9EB01454019D72BDB", hash_generated_method = "D8922D903E864F05F9C7126ABAAFE25B")
    
@Override
    protected HttpRoutePlanner createHttpRoutePlanner() {
        // BEGIN android-changed
        //     Use the proxy specified by system properties
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
        // END android-changed
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.293 -0500", hash_original_method = "B64DD33A238620F5CE58C192C71660B3", hash_generated_method = "0C859D64B57A153ED8D6BE57ED159972")
    
@Override
    protected UserTokenHandler createUserTokenHandler() {
        return new DefaultUserTokenHandler();
    }
    
}

