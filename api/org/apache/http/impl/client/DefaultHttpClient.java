package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.420 -0400", hash_original_method = "F1394B84DFE9E4D59F4D1D68B51FC2CF", hash_generated_method = "A4CBBAA31BD188F6BB342C8440B14836")
    public  DefaultHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        super(conman, params);
        addTaint(params.getTaint());
        addTaint(conman.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.421 -0400", hash_original_method = "E0C829A12DCA716ADA587F6BA150989E", hash_generated_method = "A34F47520AB5BD0BD2EF5BC301D9E340")
    public  DefaultHttpClient(final HttpParams params) {
        super(null, params);
        addTaint(params.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.421 -0400", hash_original_method = "750193D90CA0949C0C735B3486D9889C", hash_generated_method = "85C57FF144AEFA1152101B8C3A7B1643")
    public  DefaultHttpClient() {
        super(null, null);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.421 -0400", hash_original_method = "7CB663CBD5778E22C9AD8E80132ECD7C", hash_generated_method = "1BA43CAFCE8C1D55F5D800E475DF5567")
    @Override
    protected HttpParams createHttpParams() {
        HttpParams params = new BasicHttpParams();
        HttpProtocolParams.setVersion(params, 
                HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(params, 
                HTTP.DEFAULT_CONTENT_CHARSET);
        HttpProtocolParams.setUseExpectContinue(params, 
                false);
        final VersionInfo vi = VersionInfo.loadVersionInfo
            ("org.apache.http.client", getClass().getClassLoader());
        final String release = (vi != null) ?
            vi.getRelease() : VersionInfo.UNAVAILABLE;
        HttpProtocolParams.setUserAgent(params, 
                "Apache-HttpClient/" + release + " (java 1.4)");
HttpParams varD15CEB6F45B18F7EB233792D020C6115_847388363 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_847388363.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_847388363;
        
        
        
                
        
                
        
                
        
            
        
            
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.422 -0400", hash_original_method = "F3505412AB0839480CB671E1A4D22DAB", hash_generated_method = "511AC9430D330C39D6EB1B108DBC1010")
    @Override
    protected HttpRequestExecutor createRequestExecutor() {
HttpRequestExecutor var77057CFCC113A990DCE28ADA4BDF2E52_1934734216 =         new HttpRequestExecutor();
        var77057CFCC113A990DCE28ADA4BDF2E52_1934734216.addTaint(taint);
        return var77057CFCC113A990DCE28ADA4BDF2E52_1934734216;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.423 -0400", hash_original_method = "C42A8A1E8C3C461006C6920C87D13C0A", hash_generated_method = "8F05B935A04AB21814BF6695E6C1BF9D")
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
        factory = (ClientConnectionManagerFactory) params
                .getParameter(ClientPNames.CONNECTION_MANAGER_FACTORY);
    if(factory == null)        
        {
            String className = (String) params.getParameter(
                    ClientPNames.CONNECTION_MANAGER_FACTORY_CLASS_NAME);
    if(className != null)            
            {
                try 
                {
                    Class<?> clazz = Class.forName(className);
                    factory = (ClientConnectionManagerFactory) clazz.newInstance();
                } 
                catch (ClassNotFoundException ex)
                {
                    IllegalStateException var73F8483FF0FE551371BF0CE6A67E0CCB_1542998034 = new IllegalStateException("Invalid class name: " + className);
                    var73F8483FF0FE551371BF0CE6A67E0CCB_1542998034.addTaint(taint);
                    throw var73F8483FF0FE551371BF0CE6A67E0CCB_1542998034;
                } 
                catch (IllegalAccessException ex)
                {
                    IllegalAccessError var25D752797FF6CA15F46C06779D404CBB_1136503894 = new IllegalAccessError(ex.getMessage());
                    var25D752797FF6CA15F46C06779D404CBB_1136503894.addTaint(taint);
                    throw var25D752797FF6CA15F46C06779D404CBB_1136503894;
                } 
                catch (InstantiationException ex)
                {
                    InstantiationError varFE3241543B0575DE3CA4A692D24A1BE2_299435409 = new InstantiationError(ex.getMessage());
                    varFE3241543B0575DE3CA4A692D24A1BE2_299435409.addTaint(taint);
                    throw varFE3241543B0575DE3CA4A692D24A1BE2_299435409;
                } 
            } 
        } 
    if(factory != null)        
        {
            connManager = factory.newInstance(params, registry);
        } 
        else
        {
            connManager = new SingleClientConnManager(getParams(), registry);
        } 
ClientConnectionManager varA3F19198A23DEA30D08223E00C8A3A82_1022508968 =         connManager;
        varA3F19198A23DEA30D08223E00C8A3A82_1022508968.addTaint(taint);
        return varA3F19198A23DEA30D08223E00C8A3A82_1022508968;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.424 -0400", hash_original_method = "25CB6129B8FDB94E4986C80A494E2B06", hash_generated_method = "0C7163396FD34E75A816AC5DEAA72E09")
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
HttpContext var4C2DD4015CB4BB3F876A587F79816595_2000388682 =         context;
        var4C2DD4015CB4BB3F876A587F79816595_2000388682.addTaint(taint);
        return var4C2DD4015CB4BB3F876A587F79816595_2000388682;
        
        
        
                
                
        
                
                
        
                
                
        
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.424 -0400", hash_original_method = "D717E5D917BACE4DBA9E14F0AD65F48C", hash_generated_method = "AF278E19047C4391E1F5D5B7856EA9BB")
    @Override
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
ConnectionReuseStrategy varE9614091F2187FE4D3A838719839C82D_1379758353 =         new DefaultConnectionReuseStrategy();
        varE9614091F2187FE4D3A838719839C82D_1379758353.addTaint(taint);
        return varE9614091F2187FE4D3A838719839C82D_1379758353;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.425 -0400", hash_original_method = "EFD49BF95531A6CFB8AB7833D5492B46", hash_generated_method = "2BB07F10DB3D82AE52EAD68A6013D7B0")
    @Override
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
ConnectionKeepAliveStrategy varB1B09AA60E36505913439B04233EB63B_810266198 =         new DefaultConnectionKeepAliveStrategy();
        varB1B09AA60E36505913439B04233EB63B_810266198.addTaint(taint);
        return varB1B09AA60E36505913439B04233EB63B_810266198;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.425 -0400", hash_original_method = "75C52B493B32BA0931FDF11A10703B36", hash_generated_method = "72AC120A5B1347C36DEA3F7027FDC280")
    @Override
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry registry = new AuthSchemeRegistry();
        registry.register(
                AuthPolicy.BASIC, 
                new BasicSchemeFactory());
        registry.register(
                AuthPolicy.DIGEST, 
                new DigestSchemeFactory());
AuthSchemeRegistry var80BE65E57DEC31A391449487F60A8EC2_2115342290 =         registry;
        var80BE65E57DEC31A391449487F60A8EC2_2115342290.addTaint(taint);
        return var80BE65E57DEC31A391449487F60A8EC2_2115342290;
        
        
        
                
                
        
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.425 -0400", hash_original_method = "2986BF87A2DD05E6E31FCC1654EB03B5", hash_generated_method = "B8D9664114EAE699079905E44AB09BD4")
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
CookieSpecRegistry var80BE65E57DEC31A391449487F60A8EC2_354787479 =         registry;
        var80BE65E57DEC31A391449487F60A8EC2_354787479.addTaint(taint);
        return var80BE65E57DEC31A391449487F60A8EC2_354787479;
        
        
        
                
                
        
                
                
        
                
                
        
                
                
        
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.426 -0400", hash_original_method = "2E7E8D0B83423FC6C240BF5D6DCBDE4D", hash_generated_method = "251FD144C4B252BFD7B2F40B85BDCAFD")
    @Override
    protected BasicHttpProcessor createHttpProcessor() {
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
BasicHttpProcessor var469B662EBDAC4AFE0D9BAB3D14417878_643112585 =         httpproc;
        var469B662EBDAC4AFE0D9BAB3D14417878_643112585.addTaint(taint);
        return var469B662EBDAC4AFE0D9BAB3D14417878_643112585;
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.426 -0400", hash_original_method = "060CC3B74841E3F6FC79CC89E59C47D3", hash_generated_method = "8865E4263F29A9034DCD5EA590A92FCC")
    @Override
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
HttpRequestRetryHandler varF009522154DB5FDBD3705EA6977C3184_485082996 =         new DefaultHttpRequestRetryHandler();
        varF009522154DB5FDBD3705EA6977C3184_485082996.addTaint(taint);
        return varF009522154DB5FDBD3705EA6977C3184_485082996;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.427 -0400", hash_original_method = "4B5E8754A7C96AB1D27440EE21EB62A0", hash_generated_method = "09065C497C183873B4D15455FDCDC7DA")
    @Override
    protected RedirectHandler createRedirectHandler() {
RedirectHandler var47CC789AA5B62D2A2EBD610A236C23FF_1016355126 =         new DefaultRedirectHandler();
        var47CC789AA5B62D2A2EBD610A236C23FF_1016355126.addTaint(taint);
        return var47CC789AA5B62D2A2EBD610A236C23FF_1016355126;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.427 -0400", hash_original_method = "CE20EA4DC0B433CD2AE1F8D13D6593E2", hash_generated_method = "24FC206BC12B8005B8196830FC4AD0A7")
    @Override
    protected AuthenticationHandler createTargetAuthenticationHandler() {
AuthenticationHandler var2194A4635854AFE57F91D31B277D1AAB_2110170040 =         new DefaultTargetAuthenticationHandler();
        var2194A4635854AFE57F91D31B277D1AAB_2110170040.addTaint(taint);
        return var2194A4635854AFE57F91D31B277D1AAB_2110170040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.427 -0400", hash_original_method = "B6E682DFDA0487EF6FFF82AF7B123D48", hash_generated_method = "3807143C0CD4EE226C9FFBE04516A722")
    @Override
    protected AuthenticationHandler createProxyAuthenticationHandler() {
AuthenticationHandler varAFB13A519EB778DEB4F297B86FCEA1A7_483741348 =         new DefaultProxyAuthenticationHandler();
        varAFB13A519EB778DEB4F297B86FCEA1A7_483741348.addTaint(taint);
        return varAFB13A519EB778DEB4F297B86FCEA1A7_483741348;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.427 -0400", hash_original_method = "EF2D14C866EAD04A4C29973169C02328", hash_generated_method = "05CA1FECD39A803BC61E45AFB65ED968")
    @Override
    protected CookieStore createCookieStore() {
CookieStore varBD17152B433B2B4B8E0F5024503423FA_156900461 =         new BasicCookieStore();
        varBD17152B433B2B4B8E0F5024503423FA_156900461.addTaint(taint);
        return varBD17152B433B2B4B8E0F5024503423FA_156900461;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.428 -0400", hash_original_method = "7086A691E773C3CE0961AEAF5E488C24", hash_generated_method = "BC9FD880DA58ADA60007F542887DE684")
    @Override
    protected CredentialsProvider createCredentialsProvider() {
CredentialsProvider varE9F1E29528E36748834AE02D7FF6FC73_870456549 =         new BasicCredentialsProvider();
        varE9F1E29528E36748834AE02D7FF6FC73_870456549.addTaint(taint);
        return varE9F1E29528E36748834AE02D7FF6FC73_870456549;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.428 -0400", hash_original_method = "0D3A0E833E374EE9EB01454019D72BDB", hash_generated_method = "5B660AEE7E532BB988CFAB7C50C0AF18")
    @Override
    protected HttpRoutePlanner createHttpRoutePlanner() {
HttpRoutePlanner varEB83F82775DEAF4B7F183B848435FE34_1929799828 =         new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
        varEB83F82775DEAF4B7F183B848435FE34_1929799828.addTaint(taint);
        return varEB83F82775DEAF4B7F183B848435FE34_1929799828;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.428 -0400", hash_original_method = "B64DD33A238620F5CE58C192C71660B3", hash_generated_method = "BC1CEC48EE6228B93E8C9B12D87F37CE")
    @Override
    protected UserTokenHandler createUserTokenHandler() {
UserTokenHandler var68797C7622985AE4F640C2C2E6C38197_1703137798 =         new DefaultUserTokenHandler();
        var68797C7622985AE4F640C2C2E6C38197_1703137798.addTaint(taint);
        return var68797C7622985AE4F640C2C2E6C38197_1703137798;
        
        
    }

    
}

