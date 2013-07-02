package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.075 -0400", hash_original_method = "F1394B84DFE9E4D59F4D1D68B51FC2CF", hash_generated_method = "3BBF6A5C0750648D1DEC5ECAA9B7485F")
    public  DefaultHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        super(conman, params);
        addTaint(conman.getTaint());
        addTaint(params.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.076 -0400", hash_original_method = "E0C829A12DCA716ADA587F6BA150989E", hash_generated_method = "A34F47520AB5BD0BD2EF5BC301D9E340")
    public  DefaultHttpClient(final HttpParams params) {
        super(null, params);
        addTaint(params.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.078 -0400", hash_original_method = "750193D90CA0949C0C735B3486D9889C", hash_generated_method = "85C57FF144AEFA1152101B8C3A7B1643")
    public  DefaultHttpClient() {
        super(null, null);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.081 -0400", hash_original_method = "7CB663CBD5778E22C9AD8E80132ECD7C", hash_generated_method = "10D51E27A20402CB9FFAF0D9294D7452")
    @Override
    protected HttpParams createHttpParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_809088774 = null; 
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, 
                HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, 
                HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, 
                false);
        final VersionInfo vi = VersionInfo.loadVersionInfo
            ("org.apache.http.client", getClass().getClassLoader());
        String release;
        release = vi.getRelease();
        release = VersionInfo.UNAVAILABLE;
        HttpProtocolParams.setUserAgent(params, 
                "Apache-HttpClient/" + release + " (java 1.4)");
        varB4EAC82CA7396A68D541C85D26508E83_809088774 = params;
        varB4EAC82CA7396A68D541C85D26508E83_809088774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_809088774;
        
        
        
                
        
                
        
                
        
            
        
            
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.083 -0400", hash_original_method = "F3505412AB0839480CB671E1A4D22DAB", hash_generated_method = "0D36C90870AD71AEC6524DE920799310")
    @Override
    protected HttpRequestExecutor createRequestExecutor() {
        HttpRequestExecutor varB4EAC82CA7396A68D541C85D26508E83_1296915910 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1296915910 = new HttpRequestExecutor();
        varB4EAC82CA7396A68D541C85D26508E83_1296915910.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1296915910;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.085 -0400", hash_original_method = "C42A8A1E8C3C461006C6920C87D13C0A", hash_generated_method = "A86F6CB3D5E1906C9C1595D112BB7592")
    @Override
    protected ClientConnectionManager createClientConnectionManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_909230021 = null; 
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(
                new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(
                new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        ClientConnectionManager connManager = null;
        HttpParams params = getParams();
        ClientConnectionManagerFactory factory = null;
        factory = (ClientConnectionManagerFactory) params
                .getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY);
        {
            String className = (String) params.getParameter(
                    ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
            {
                try 
                {
                    Class<?> clazz = Class.forName(className);
                    factory = (ClientConnectionManagerFactory) clazz.newInstance();
                } 
                catch (ClassNotFoundException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Invalid class name: " + className);
                } 
                catch (IllegalAccessException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalAccessError(ex.getMessage());
                } 
                catch (InstantiationException ex)
                {
                    if (DroidSafeAndroidRuntime.control) throw new InstantiationError(ex.getMessage());
                } 
            } 
        } 
        {
            connManager = factory.newInstance(params, registry);
        } 
        {
            connManager = new SingleClientConnManager(getParams(), registry);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_909230021 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_909230021.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_909230021;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.086 -0400", hash_original_method = "25CB6129B8FDB94E4986C80A494E2B06", hash_generated_method = "180E029899E0CB05A8CA242F45AA025F")
    @Override
    protected HttpContext createHttpContext() {
        HttpContext varB4EAC82CA7396A68D541C85D26508E83_1327789205 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1327789205 = context;
        varB4EAC82CA7396A68D541C85D26508E83_1327789205.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1327789205;
        
        
        
                
                
        
                
                
        
                
                
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.088 -0400", hash_original_method = "D717E5D917BACE4DBA9E14F0AD65F48C", hash_generated_method = "53AB2CEF945849538A2CD1C99FAA435A")
    @Override
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
        ConnectionReuseStrategy varB4EAC82CA7396A68D541C85D26508E83_415482651 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_415482651 = new DefaultConnectionReuseStrategy();
        varB4EAC82CA7396A68D541C85D26508E83_415482651.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_415482651;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.089 -0400", hash_original_method = "EFD49BF95531A6CFB8AB7833D5492B46", hash_generated_method = "4B27B2034B482B0DCF2F710D56CC011E")
    @Override
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
        ConnectionKeepAliveStrategy varB4EAC82CA7396A68D541C85D26508E83_1410986516 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1410986516 = new DefaultConnectionKeepAliveStrategy();
        varB4EAC82CA7396A68D541C85D26508E83_1410986516.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1410986516;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.089 -0400", hash_original_method = "75C52B493B32BA0931FDF11A10703B36", hash_generated_method = "9DFF70408DBA9455BA2394BFEBA088E1")
    @Override
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_687003462 = null; 
        AuthSchemeRegistry registry = new AuthSchemeRegistry();
        registry.register(
                AuthPolicy.BASIC, 
                new BasicSchemeFactory());
        registry.register(
                AuthPolicy.DIGEST, 
                new DigestSchemeFactory());
        varB4EAC82CA7396A68D541C85D26508E83_687003462 = registry;
        varB4EAC82CA7396A68D541C85D26508E83_687003462.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_687003462;
        
        
        
                
                
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.090 -0400", hash_original_method = "2986BF87A2DD05E6E31FCC1654EB03B5", hash_generated_method = "15E6CF595125E2F1E31EDAECFAC68989")
    @Override
    protected CookieSpecRegistry createCookieSpecRegistry() {
        CookieSpecRegistry varB4EAC82CA7396A68D541C85D26508E83_1003459865 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1003459865 = registry;
        varB4EAC82CA7396A68D541C85D26508E83_1003459865.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1003459865;
        
        
        
                
                
        
                
                
        
                
                
        
                
                
        
                
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.091 -0400", hash_original_method = "2E7E8D0B83423FC6C240BF5D6DCBDE4D", hash_generated_method = "91693999B00D6655E99F7C5F06E85779")
    @Override
    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor varB4EAC82CA7396A68D541C85D26508E83_775442993 = null; 
        BasicHttpProcessor httpproc = new BasicHttpProcessor();
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
        varB4EAC82CA7396A68D541C85D26508E83_775442993 = httpproc;
        varB4EAC82CA7396A68D541C85D26508E83_775442993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_775442993;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.092 -0400", hash_original_method = "060CC3B74841E3F6FC79CC89E59C47D3", hash_generated_method = "E7D460C108154C22C3389D2A6BBBEEB3")
    @Override
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
        HttpRequestRetryHandler varB4EAC82CA7396A68D541C85D26508E83_1314373215 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1314373215 = new DefaultHttpRequestRetryHandler();
        varB4EAC82CA7396A68D541C85D26508E83_1314373215.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1314373215;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.093 -0400", hash_original_method = "4B5E8754A7C96AB1D27440EE21EB62A0", hash_generated_method = "C54C59B7D6C0C67E0690C3D60D02931E")
    @Override
    protected RedirectHandler createRedirectHandler() {
        RedirectHandler varB4EAC82CA7396A68D541C85D26508E83_79266915 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_79266915 = new DefaultRedirectHandler();
        varB4EAC82CA7396A68D541C85D26508E83_79266915.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_79266915;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.096 -0400", hash_original_method = "CE20EA4DC0B433CD2AE1F8D13D6593E2", hash_generated_method = "C5F7AF582EF6FA59E206A1698421D70D")
    @Override
    protected AuthenticationHandler createTargetAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_517207012 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_517207012 = new DefaultTargetAuthenticationHandler();
        varB4EAC82CA7396A68D541C85D26508E83_517207012.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_517207012;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.097 -0400", hash_original_method = "B6E682DFDA0487EF6FFF82AF7B123D48", hash_generated_method = "BA720A5BA3F5989C8B57D24972E8D2B4")
    @Override
    protected AuthenticationHandler createProxyAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_302291563 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_302291563 = new DefaultProxyAuthenticationHandler();
        varB4EAC82CA7396A68D541C85D26508E83_302291563.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_302291563;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.099 -0400", hash_original_method = "EF2D14C866EAD04A4C29973169C02328", hash_generated_method = "EA9D12B7F3652C96FA1BB153AB0AE18D")
    @Override
    protected CookieStore createCookieStore() {
        CookieStore varB4EAC82CA7396A68D541C85D26508E83_1525577528 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1525577528 = new BasicCookieStore();
        varB4EAC82CA7396A68D541C85D26508E83_1525577528.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1525577528;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.100 -0400", hash_original_method = "7086A691E773C3CE0961AEAF5E488C24", hash_generated_method = "03C69C0715DEFDB00C05EA3CB631564B")
    @Override
    protected CredentialsProvider createCredentialsProvider() {
        CredentialsProvider varB4EAC82CA7396A68D541C85D26508E83_1988484199 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1988484199 = new BasicCredentialsProvider();
        varB4EAC82CA7396A68D541C85D26508E83_1988484199.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1988484199;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.101 -0400", hash_original_method = "0D3A0E833E374EE9EB01454019D72BDB", hash_generated_method = "2F060EAFBFA4A184BEFA6DACCB66C2B4")
    @Override
    protected HttpRoutePlanner createHttpRoutePlanner() {
        HttpRoutePlanner varB4EAC82CA7396A68D541C85D26508E83_956389606 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_956389606 = new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
        varB4EAC82CA7396A68D541C85D26508E83_956389606.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_956389606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.101 -0400", hash_original_method = "B64DD33A238620F5CE58C192C71660B3", hash_generated_method = "B957050FE5FBA873166BFA774281CD9F")
    @Override
    protected UserTokenHandler createUserTokenHandler() {
        UserTokenHandler varB4EAC82CA7396A68D541C85D26508E83_3482553 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_3482553 = new DefaultUserTokenHandler();
        varB4EAC82CA7396A68D541C85D26508E83_3482553.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_3482553;
        
        
    }

    
}

