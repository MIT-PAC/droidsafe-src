package org.apache.http.impl.client;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.679 -0400", hash_original_method = "F1394B84DFE9E4D59F4D1D68B51FC2CF", hash_generated_method = "A4CBBAA31BD188F6BB342C8440B14836")
    public  DefaultHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        super(conman, params);
        addTaint(params.getTaint());
        addTaint(conman.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.679 -0400", hash_original_method = "E0C829A12DCA716ADA587F6BA150989E", hash_generated_method = "A34F47520AB5BD0BD2EF5BC301D9E340")
    public  DefaultHttpClient(final HttpParams params) {
        super(null, params);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.679 -0400", hash_original_method = "750193D90CA0949C0C735B3486D9889C", hash_generated_method = "85C57FF144AEFA1152101B8C3A7B1643")
    public  DefaultHttpClient() {
        super(null, null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.679 -0400", hash_original_method = "7CB663CBD5778E22C9AD8E80132ECD7C", hash_generated_method = "98F30E6F4C38BE668E066642B33C7CC6")
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
HttpParams varD15CEB6F45B18F7EB233792D020C6115_54432926 =         params;
        varD15CEB6F45B18F7EB233792D020C6115_54432926.addTaint(taint);
        return varD15CEB6F45B18F7EB233792D020C6115_54432926;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.680 -0400", hash_original_method = "F3505412AB0839480CB671E1A4D22DAB", hash_generated_method = "C75474E167DCC9719A40C916E2AEF417")
    @Override
    protected HttpRequestExecutor createRequestExecutor() {
HttpRequestExecutor var77057CFCC113A990DCE28ADA4BDF2E52_424793201 =         new HttpRequestExecutor();
        var77057CFCC113A990DCE28ADA4BDF2E52_424793201.addTaint(taint);
        return var77057CFCC113A990DCE28ADA4BDF2E52_424793201;
        // ---------- Original Method ----------
        //return new HttpRequestExecutor();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.680 -0400", hash_original_method = "C42A8A1E8C3C461006C6920C87D13C0A", hash_generated_method = "DC32099440E7E4801E66F1EA925514A2")
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
                } //End block
                catch (ClassNotFoundException ex)
                {
                    IllegalStateException var73F8483FF0FE551371BF0CE6A67E0CCB_1477863507 = new IllegalStateException("Invalid class name: " + className);
                    var73F8483FF0FE551371BF0CE6A67E0CCB_1477863507.addTaint(taint);
                    throw var73F8483FF0FE551371BF0CE6A67E0CCB_1477863507;
                } //End block
                catch (IllegalAccessException ex)
                {
                    IllegalAccessError var25D752797FF6CA15F46C06779D404CBB_1814042868 = new IllegalAccessError(ex.getMessage());
                    var25D752797FF6CA15F46C06779D404CBB_1814042868.addTaint(taint);
                    throw var25D752797FF6CA15F46C06779D404CBB_1814042868;
                } //End block
                catch (InstantiationException ex)
                {
                    InstantiationError varFE3241543B0575DE3CA4A692D24A1BE2_55328352 = new InstantiationError(ex.getMessage());
                    varFE3241543B0575DE3CA4A692D24A1BE2_55328352.addTaint(taint);
                    throw varFE3241543B0575DE3CA4A692D24A1BE2_55328352;
                } //End block
            } //End block
        } //End block
        if(factory != null)        
        {
            connManager = factory.newInstance(params, registry);
        } //End block
        else
        {
            connManager = new SingleClientConnManager(getParams(), registry);
        } //End block
ClientConnectionManager varA3F19198A23DEA30D08223E00C8A3A82_2004127151 =         connManager;
        varA3F19198A23DEA30D08223E00C8A3A82_2004127151.addTaint(taint);
        return varA3F19198A23DEA30D08223E00C8A3A82_2004127151;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.680 -0400", hash_original_method = "25CB6129B8FDB94E4986C80A494E2B06", hash_generated_method = "59AB1A4172F850CD03F68455FF888229")
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
HttpContext var4C2DD4015CB4BB3F876A587F79816595_135804137 =         context;
        var4C2DD4015CB4BB3F876A587F79816595_135804137.addTaint(taint);
        return var4C2DD4015CB4BB3F876A587F79816595_135804137;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.680 -0400", hash_original_method = "D717E5D917BACE4DBA9E14F0AD65F48C", hash_generated_method = "090EDF6D98079B23C91CA9CD428E53CB")
    @Override
    protected ConnectionReuseStrategy createConnectionReuseStrategy() {
ConnectionReuseStrategy varE9614091F2187FE4D3A838719839C82D_2039302410 =         new DefaultConnectionReuseStrategy();
        varE9614091F2187FE4D3A838719839C82D_2039302410.addTaint(taint);
        return varE9614091F2187FE4D3A838719839C82D_2039302410;
        // ---------- Original Method ----------
        //return new DefaultConnectionReuseStrategy();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "EFD49BF95531A6CFB8AB7833D5492B46", hash_generated_method = "D90099C9129EB5D5C2D6429F57DADFF9")
    @Override
    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy() {
ConnectionKeepAliveStrategy varB1B09AA60E36505913439B04233EB63B_934752984 =         new DefaultConnectionKeepAliveStrategy();
        varB1B09AA60E36505913439B04233EB63B_934752984.addTaint(taint);
        return varB1B09AA60E36505913439B04233EB63B_934752984;
        // ---------- Original Method ----------
        //return new DefaultConnectionKeepAliveStrategy();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "75C52B493B32BA0931FDF11A10703B36", hash_generated_method = "3392F1DE48DA87088D349E57B420F3C2")
    @Override
    protected AuthSchemeRegistry createAuthSchemeRegistry() {
        AuthSchemeRegistry registry = new AuthSchemeRegistry();
        registry.register(
                AuthPolicy.BASIC, 
                new BasicSchemeFactory());
        registry.register(
                AuthPolicy.DIGEST, 
                new DigestSchemeFactory());
AuthSchemeRegistry var80BE65E57DEC31A391449487F60A8EC2_1387867743 =         registry;
        var80BE65E57DEC31A391449487F60A8EC2_1387867743.addTaint(taint);
        return var80BE65E57DEC31A391449487F60A8EC2_1387867743;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "2986BF87A2DD05E6E31FCC1654EB03B5", hash_generated_method = "8593DD23ED3AD887A2D500C187AFE08A")
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
CookieSpecRegistry var80BE65E57DEC31A391449487F60A8EC2_1199820047 =         registry;
        var80BE65E57DEC31A391449487F60A8EC2_1199820047.addTaint(taint);
        return var80BE65E57DEC31A391449487F60A8EC2_1199820047;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "2E7E8D0B83423FC6C240BF5D6DCBDE4D", hash_generated_method = "9AC526FC994601B8AD3047EE8FD24F5D")
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
BasicHttpProcessor var469B662EBDAC4AFE0D9BAB3D14417878_1547064168 =         httpproc;
        var469B662EBDAC4AFE0D9BAB3D14417878_1547064168.addTaint(taint);
        return var469B662EBDAC4AFE0D9BAB3D14417878_1547064168;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "060CC3B74841E3F6FC79CC89E59C47D3", hash_generated_method = "C0BBAA363112F0824B5B4EC9C1F30FC8")
    @Override
    protected HttpRequestRetryHandler createHttpRequestRetryHandler() {
HttpRequestRetryHandler varF009522154DB5FDBD3705EA6977C3184_680024537 =         new DefaultHttpRequestRetryHandler();
        varF009522154DB5FDBD3705EA6977C3184_680024537.addTaint(taint);
        return varF009522154DB5FDBD3705EA6977C3184_680024537;
        // ---------- Original Method ----------
        //return new DefaultHttpRequestRetryHandler();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "4B5E8754A7C96AB1D27440EE21EB62A0", hash_generated_method = "47B7F6F4712064198646DBA3B30B6CAE")
    @Override
    protected RedirectHandler createRedirectHandler() {
RedirectHandler var47CC789AA5B62D2A2EBD610A236C23FF_231049158 =         new DefaultRedirectHandler();
        var47CC789AA5B62D2A2EBD610A236C23FF_231049158.addTaint(taint);
        return var47CC789AA5B62D2A2EBD610A236C23FF_231049158;
        // ---------- Original Method ----------
        //return new DefaultRedirectHandler();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "CE20EA4DC0B433CD2AE1F8D13D6593E2", hash_generated_method = "B8A8B3CF69A470CBB832B775876DC0CD")
    @Override
    protected AuthenticationHandler createTargetAuthenticationHandler() {
AuthenticationHandler var2194A4635854AFE57F91D31B277D1AAB_1234674025 =         new DefaultTargetAuthenticationHandler();
        var2194A4635854AFE57F91D31B277D1AAB_1234674025.addTaint(taint);
        return var2194A4635854AFE57F91D31B277D1AAB_1234674025;
        // ---------- Original Method ----------
        //return new DefaultTargetAuthenticationHandler();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.681 -0400", hash_original_method = "B6E682DFDA0487EF6FFF82AF7B123D48", hash_generated_method = "96DA2A3C944CB8F28ACAE94F3870C28A")
    @Override
    protected AuthenticationHandler createProxyAuthenticationHandler() {
AuthenticationHandler varAFB13A519EB778DEB4F297B86FCEA1A7_1651036094 =         new DefaultProxyAuthenticationHandler();
        varAFB13A519EB778DEB4F297B86FCEA1A7_1651036094.addTaint(taint);
        return varAFB13A519EB778DEB4F297B86FCEA1A7_1651036094;
        // ---------- Original Method ----------
        //return new DefaultProxyAuthenticationHandler();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.682 -0400", hash_original_method = "EF2D14C866EAD04A4C29973169C02328", hash_generated_method = "97502AEA24598D9624D3794D08D87AE9")
    @Override
    protected CookieStore createCookieStore() {
CookieStore varBD17152B433B2B4B8E0F5024503423FA_594418866 =         new BasicCookieStore();
        varBD17152B433B2B4B8E0F5024503423FA_594418866.addTaint(taint);
        return varBD17152B433B2B4B8E0F5024503423FA_594418866;
        // ---------- Original Method ----------
        //return new BasicCookieStore();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.682 -0400", hash_original_method = "7086A691E773C3CE0961AEAF5E488C24", hash_generated_method = "6B6F8B97F8AC28CBA8B8A97D8B6461FD")
    @Override
    protected CredentialsProvider createCredentialsProvider() {
CredentialsProvider varE9F1E29528E36748834AE02D7FF6FC73_759746835 =         new BasicCredentialsProvider();
        varE9F1E29528E36748834AE02D7FF6FC73_759746835.addTaint(taint);
        return varE9F1E29528E36748834AE02D7FF6FC73_759746835;
        // ---------- Original Method ----------
        //return new BasicCredentialsProvider();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.682 -0400", hash_original_method = "0D3A0E833E374EE9EB01454019D72BDB", hash_generated_method = "7B9DF6096422A9990431AA29E8AC4624")
    @Override
    protected HttpRoutePlanner createHttpRoutePlanner() {
HttpRoutePlanner varEB83F82775DEAF4B7F183B848435FE34_1620220570 =         new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
        varEB83F82775DEAF4B7F183B848435FE34_1620220570.addTaint(taint);
        return varEB83F82775DEAF4B7F183B848435FE34_1620220570;
        // ---------- Original Method ----------
        //return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.682 -0400", hash_original_method = "B64DD33A238620F5CE58C192C71660B3", hash_generated_method = "1DB18F4EF751BA2C1E795ADF00C2D39F")
    @Override
    protected UserTokenHandler createUserTokenHandler() {
UserTokenHandler var68797C7622985AE4F640C2C2E6C38197_2002854754 =         new DefaultUserTokenHandler();
        var68797C7622985AE4F640C2C2E6C38197_2002854754.addTaint(taint);
        return var68797C7622985AE4F640C2C2E6C38197_2002854754;
        // ---------- Original Method ----------
        //return new DefaultUserTokenHandler();
    }

    
}

