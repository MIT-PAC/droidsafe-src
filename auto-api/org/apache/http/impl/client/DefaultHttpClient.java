package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.322 -0400", hash_original_method = "F1394B84DFE9E4D59F4D1D68B51FC2CF", hash_generated_method = "3BBF6A5C0750648D1DEC5ECAA9B7485F")
    public  DefaultHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        super(conman, params);
        addTaint(conman.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.332 -0400", hash_original_method = "E0C829A12DCA716ADA587F6BA150989E", hash_generated_method = "A34F47520AB5BD0BD2EF5BC301D9E340")
    public  DefaultHttpClient(final HttpParams params) {
        super(null, params);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.333 -0400", hash_original_method = "750193D90CA0949C0C735B3486D9889C", hash_generated_method = "85C57FF144AEFA1152101B8C3A7B1643")
    public  DefaultHttpClient() {
        super(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.333 -0400", hash_original_method = "7CB663CBD5778E22C9AD8E80132ECD7C", hash_generated_method = "A3BA29678A2E4EFD51EB124E7144C81F")
    @Override
    protected HttpParams createHttpParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_730053850 = null; //Variable for return #1
        HttpParams params;
        params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, 
                HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, 
                HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, 
                false);
        VersionInfo vi;
        vi = VersionInfo.loadVersionInfo
            ("org.apache.http.client", getClass().getClassLoader());
        String release;
        release = vi.getRelease();
        release = VersionInfo.UNAVAILABLE;
        HttpProtocolParams.setUserAgent(params, 
                "Apache-HttpClient/" + release + " (java 1.4)");
        varB4EAC82CA7396A68D541C85D26508E83_730053850 = params;
        varB4EAC82CA7396A68D541C85D26508E83_730053850.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_730053850;
        // ---------- Original Method ----------
        //HttpParams params = new BasicHttpParams();
        //HttpProtocolParams.setVersion(params, 
                //HttpVersion.HTTP_1_1);
        //HttpProtocolParams.setContentCharset(params, 
                //HTTP.DEFAULT_CONTENT_CHARSET);
        //HttpProtocolParams.setUseExpectContinue(params, 
                //false);
        //final VersionInfo vi = VersionInfo.loadVersionInfo
            //("org.apache.http.client", getClass().getClassLoader());
        //final String release = (vi != null) ?
            //vi.getRelease() : VersionInfo.UNAVAILABLE;
        //HttpProtocolParams.setUserAgent(params, 
                //"Apache-HttpClient/" + release + " (java 1.4)");
        //return params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.334 -0400", hash_original_method = "F3505412AB0839480CB671E1A4D22DAB", hash_generated_method = "507A1F8F8AEFFC5E8B19BDAEED0C5B76")
    @Override
    protected HttpRequestExecutor createRequestExecutor() {
        HttpRequestExecutor varB4EAC82CA7396A68D541C85D26508E83_1211581296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1211581296 = new HttpRequestExecutor();
        varB4EAC82CA7396A68D541C85D26508E83_1211581296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1211581296;
        // ---------- Original Method ----------
        //return new HttpRequestExecutor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.358 -0400", hash_original_method = "C42A8A1E8C3C461006C6920C87D13C0A", hash_generated_method = "5E997FDA1B9F5D0ACA25D80FC4F4FA13")
    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_185408452 = null; //Variable for return #1
        SchemeRegistry registry;
        registry = new SchemeRegistry();
        registry.register(
                new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(
                new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager connManager;
        connManager = null;
        HttpParams params;
        params = getParams();
        ClientConnectionManagerFactory factory;
        factory = null;
        factory = (ClientConnectionManagerFactory) params
                .getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY);
        {
            String className;
            className = (String) params.getParameter(
                    ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
            {
                try 
                {
                    Class<?> clazz;
                    clazz = Class.forName(className);
                    factory = (ClientConnectionManagerFactory) clazz.newInstance();
                } //End block
                catch (ClassNotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Invalid class name: " + className);
                } //End block
                catch (IllegalAccessException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError(ex.getMessage());
                } //End block
                catch (InstantiationException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new InstantiationError(ex.getMessage());
                } //End block
            } //End block
        } //End block
        {
            connManager = factory.newInstance(params, registry);
        } //End block
        {
            connManager = new SingleClientConnManager(getParams(), registry);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_185408452 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_185408452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_185408452;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.359 -0400", hash_original_method = "25CB6129B8FDB94E4986C80A494E2B06", hash_generated_method = "E6561AEF9EB64276BF53441E06E3241C")
    @Override
    protected HttpContext createHttpContext() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_1938306431 = null; //Variable for return #1
        HttpContext context;
        context = new BasicHttpContext();
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
        varB4EAC82CA7396A68D541C85D26508E83_1938306431 = context;
        varB4EAC82CA7396A68D541C85D26508E83_1938306431.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1938306431;
        // ---------- Original Method ----------
        //HttpContext context = new BasicHttpContext();
        //context.setAttribute(
                //ClientContext.AUTHSCHEME_REGISTRY, 
                //getAuthSchemes());
        //context.setAttribute(
                //ClientContext.COOKIESPEC_REGISTRY, 
                //getCookieSpecs());
        //context.setAttribute(
                //ClientContext.COOKIE_STORE, 
                //getCookieStore());
        //context.setAttribute(
                //ClientContext.CREDS_PROVIDER, 
                //getCredentialsProvider());
        //return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.360 -0400", hash_original_method = "D717E5D917BACE4DBA9E14F0AD65F48C", hash_generated_method = "99B0EE13EA145FFFF032325D525ADCEE")
    @Override
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        ConnectionReuseStrategy varB4EAC82CA7396A68D541C85D26508E83_2119487759 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2119487759 = new DefaultConnectionReuseStrategy();
        varB4EAC82CA7396A68D541C85D26508E83_2119487759.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2119487759;
        // ---------- Original Method ----------
        //return new DefaultConnectionReuseStrategy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.360 -0400", hash_original_method = "EFD49BF95531A6CFB8AB7833D5492B46", hash_generated_method = "9CE8AFF7A5D6C4D7275180F646F2F047")
    @Override
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        ConnectionKeepAliveStrategy varB4EAC82CA7396A68D541C85D26508E83_128378705 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_128378705 = new DefaultConnectionKeepAliveStrategy();
        varB4EAC82CA7396A68D541C85D26508E83_128378705.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_128378705;
        // ---------- Original Method ----------
        //return new DefaultConnectionKeepAliveStrategy();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.361 -0400", hash_original_method = "75C52B493B32BA0931FDF11A10703B36", hash_generated_method = "CF951BB9C964FC9CE737CC63C91E1F76")
    @Override
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_2024657798 = null; //Variable for return #1
        AuthSchemeRegistry registry;
        registry = new AuthSchemeRegistry();
        registry.register(
                AuthPolicy.BASIC, 
                new BasicSchemeFactory());
        registry.register(
                AuthPolicy.DIGEST, 
                new DigestSchemeFactory());
        varB4EAC82CA7396A68D541C85D26508E83_2024657798 = registry;
        varB4EAC82CA7396A68D541C85D26508E83_2024657798.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2024657798;
        // ---------- Original Method ----------
        //AuthSchemeRegistry registry = new AuthSchemeRegistry();
        //registry.register(
                //AuthPolicy.BASIC, 
                //new BasicSchemeFactory());
        //registry.register(
                //AuthPolicy.DIGEST, 
                //new DigestSchemeFactory());
        //return registry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.368 -0400", hash_original_method = "2986BF87A2DD05E6E31FCC1654EB03B5", hash_generated_method = "4EC8E75AEFFDC53BE336857767A0ABE6")
    @Override
    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry varB4EAC82CA7396A68D541C85D26508E83_839359655 = null; //Variable for return #1
        CookieSpecRegistry registry;
        registry = new CookieSpecRegistry();
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
        varB4EAC82CA7396A68D541C85D26508E83_839359655 = registry;
        varB4EAC82CA7396A68D541C85D26508E83_839359655.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_839359655;
        // ---------- Original Method ----------
        //CookieSpecRegistry registry = new CookieSpecRegistry();
        //registry.register(
                //CookiePolicy.BEST_MATCH, 
                //new BestMatchSpecFactory());
        //registry.register(
                //CookiePolicy.BROWSER_COMPATIBILITY, 
                //new BrowserCompatSpecFactory());
        //registry.register(
                //CookiePolicy.NETSCAPE, 
                //new NetscapeDraftSpecFactory());
        //registry.register(
                //CookiePolicy.RFC_2109, 
                //new RFC2109SpecFactory());
        //registry.register(
                //CookiePolicy.RFC_2965, 
                //new RFC2965SpecFactory());
        //return registry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.369 -0400", hash_original_method = "2E7E8D0B83423FC6C240BF5D6DCBDE4D", hash_generated_method = "0BAB0017AD8BFD2036147D00DA65273F")
    @Override
    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor varB4EAC82CA7396A68D541C85D26508E83_1736383358 = null; //Variable for return #1
        BasicHttpProcessor httpproc;
        httpproc = new BasicHttpProcessor();
        httpproc.addInterceptor(new RequestDefaultHeaders());
        httpproc.addInterceptor(new RequestContent());
        httpproc.addInterceptor(new RequestTargetHost());
        httpproc.addInterceptor(new RequestConnControl());
        httpproc.addInterceptor(new RequestUserAgent());
        httpproc.addInterceptor(new RequestExpectContinue());
        httpproc.addInterceptor(new RequestAddCookies());
        httpproc.addInterceptor(new ResponseProcessCookies());
        httpproc.addInterceptor(new RequestTargetAuthentication());
        httpproc.addInterceptor(new RequestProxyAuthentication());
        varB4EAC82CA7396A68D541C85D26508E83_1736383358 = httpproc;
        varB4EAC82CA7396A68D541C85D26508E83_1736383358.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1736383358;
        // ---------- Original Method ----------
        //BasicHttpProcessor httpproc = new BasicHttpProcessor();
        //httpproc.addInterceptor(new RequestDefaultHeaders());
        //httpproc.addInterceptor(new RequestContent());
        //httpproc.addInterceptor(new RequestTargetHost());
        //httpproc.addInterceptor(new RequestConnControl());
        //httpproc.addInterceptor(new RequestUserAgent());
        //httpproc.addInterceptor(new RequestExpectContinue());
        //httpproc.addInterceptor(new RequestAddCookies());
        //httpproc.addInterceptor(new ResponseProcessCookies());
        //httpproc.addInterceptor(new RequestTargetAuthentication());
        //httpproc.addInterceptor(new RequestProxyAuthentication());
        //return httpproc;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.370 -0400", hash_original_method = "060CC3B74841E3F6FC79CC89E59C47D3", hash_generated_method = "88E52A8B60D09C27A56FCAE427AF2D56")
    @Override
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        HttpRequestRetryHandler varB4EAC82CA7396A68D541C85D26508E83_899305666 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_899305666 = new DefaultHttpRequestRetryHandler();
        varB4EAC82CA7396A68D541C85D26508E83_899305666.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_899305666;
        // ---------- Original Method ----------
        //return new DefaultHttpRequestRetryHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.374 -0400", hash_original_method = "4B5E8754A7C96AB1D27440EE21EB62A0", hash_generated_method = "64A54300CB84E8C6706192E489A11FA1")
    @Override
    protected RedirectHandler createRedirectHandler() {
        RedirectHandler varB4EAC82CA7396A68D541C85D26508E83_1204064463 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1204064463 = new DefaultRedirectHandler();
        varB4EAC82CA7396A68D541C85D26508E83_1204064463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1204064463;
        // ---------- Original Method ----------
        //return new DefaultRedirectHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.375 -0400", hash_original_method = "CE20EA4DC0B433CD2AE1F8D13D6593E2", hash_generated_method = "966423B7F3ADD9E2DB52CBC229A50780")
    @Override
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_1853681219 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1853681219 = new DefaultTargetAuthenticationHandler();
        varB4EAC82CA7396A68D541C85D26508E83_1853681219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853681219;
        // ---------- Original Method ----------
        //return new DefaultTargetAuthenticationHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.382 -0400", hash_original_method = "B6E682DFDA0487EF6FFF82AF7B123D48", hash_generated_method = "8B95F94E7EA76F8AAFB09B0C53017DEA")
    @Override
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_1962412379 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1962412379 = new DefaultProxyAuthenticationHandler();
        varB4EAC82CA7396A68D541C85D26508E83_1962412379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1962412379;
        // ---------- Original Method ----------
        //return new DefaultProxyAuthenticationHandler();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.393 -0400", hash_original_method = "EF2D14C866EAD04A4C29973169C02328", hash_generated_method = "F83F3CD30D4B301C216C20FDC4659B37")
    @Override
    protected CookieStore createCookieStore() {
        CookieStore varB4EAC82CA7396A68D541C85D26508E83_78204557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_78204557 = new BasicCookieStore();
        varB4EAC82CA7396A68D541C85D26508E83_78204557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_78204557;
        // ---------- Original Method ----------
        //return new BasicCookieStore();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.393 -0400", hash_original_method = "7086A691E773C3CE0961AEAF5E488C24", hash_generated_method = "DE122FA3A98606270A04F27E9BAA4E1D")
    @Override
    protected CredentialsProvider createCredentialsProvider() {
        CredentialsProvider varB4EAC82CA7396A68D541C85D26508E83_376260138 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_376260138 = new BasicCredentialsProvider();
        varB4EAC82CA7396A68D541C85D26508E83_376260138.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_376260138;
        // ---------- Original Method ----------
        //return new BasicCredentialsProvider();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.393 -0400", hash_original_method = "0D3A0E833E374EE9EB01454019D72BDB", hash_generated_method = "891DBC324A0F9A486E86D54524592AB4")
    @Override
    protected HttpRoutePlanner createHttpRoutePlanner() {
        HttpRoutePlanner varB4EAC82CA7396A68D541C85D26508E83_976477052 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_976477052 = new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
        varB4EAC82CA7396A68D541C85D26508E83_976477052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_976477052;
        // ---------- Original Method ----------
        //return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.394 -0400", hash_original_method = "B64DD33A238620F5CE58C192C71660B3", hash_generated_method = "D2EAF08FF63BAE8A70C5FE2823CF87C6")
    @Override
    protected UserTokenHandler createUserTokenHandler() {
        UserTokenHandler varB4EAC82CA7396A68D541C85D26508E83_130942242 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_130942242 = new DefaultUserTokenHandler();
        varB4EAC82CA7396A68D541C85D26508E83_130942242.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130942242;
        // ---------- Original Method ----------
        //return new DefaultUserTokenHandler();
    }

    
}

