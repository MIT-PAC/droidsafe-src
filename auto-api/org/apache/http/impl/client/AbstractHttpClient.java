package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.URI;
import java.lang.reflect.UndeclaredThrowableException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.cookie.CookieSpecRegistry;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.DefaultedHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public abstract class AbstractHttpClient implements HttpClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.181 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "4E4E630304492253CB8147CAE1C7D2A5")

    private Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.181 -0400", hash_original_field = "50E5261D8BCA7AE22F750DB5A5E38482", hash_generated_field = "2B47D5796605ED0337DCB8253B1896C5")

    private HttpParams defaultParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.181 -0400", hash_original_field = "EBFB9A3D3F58438E791B5FA697F0E019", hash_generated_field = "4A99276FC1CAC2C29AE58A664804FA18")

    private HttpRequestExecutor requestExec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.181 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "B110094B2D9FE8F9DF9475794843EE87")

    private ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.181 -0400", hash_original_field = "6841B3DB425CF924E2406CCC3EC7D0C4", hash_generated_field = "53F301D72A057E2DF8B8C939D3D9CD90")

    private ConnectionReuseStrategy reuseStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "06037BBEEBDAD4B9CCEA6123FF7CEF48", hash_generated_field = "6B7DB7136FD3BAE521073378AFDD44BF")

    private ConnectionKeepAliveStrategy keepAliveStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "707C5B77EDEF1C2CC7B74E62BACCEA74", hash_generated_field = "3451161F1CFA2C123C0FE67101143B08")

    private CookieSpecRegistry supportedCookieSpecs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "AC7D9D61F24C0E6B0C04963EA0140E4F", hash_generated_field = "0CFF0C92AFAE4510CB7819EC35269016")

    private AuthSchemeRegistry supportedAuthSchemes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "752D4EFA0487789E224C2A1BB7CC684E", hash_generated_field = "9AB2A5083E09B99512C85C1D40618272")

    private BasicHttpProcessor httpProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "9276D9188CF6BA2DC6A4953C0672BC3D", hash_generated_field = "30F0E3855973CBC5841163CE464CF151")

    private HttpRequestRetryHandler retryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "F350623671C50CD5233E0DC58B4BC69F", hash_generated_field = "E830C98496C1F40082C35296635B7B2E")

    private RedirectHandler redirectHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "6FA7D1184BC1FAC634576AE3416BC1FC", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "0F58376CC8049DF18F70792E6CDE0CBB", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "1DFFC198ED2418E9EE70ADA53C5F647E", hash_generated_field = "48EBEC1FDB75AF182113D4070DF327E8")

    private CookieStore cookieStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "EFA53F3DE5392737486FC7E889846147", hash_generated_field = "74F60E181398330BC8F9F57CE3109107")

    private CredentialsProvider credsProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "16B9BCB9C810B5FB9F1218ABF5433F0A", hash_generated_field = "993C3C48EF45D276D4920986CC1A695F")

    private HttpRoutePlanner routePlanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_field = "7CA4C2AD16B3CB439480B96FCAB580BC", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.182 -0400", hash_original_method = "649332244E1BD2DC633E57F283CE534F", hash_generated_method = "7B5BB166B285F69B9BDACA31B48312B6")
    protected  AbstractHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        defaultParams        = params;
        connManager          = conman;
        // ---------- Original Method ----------
        //defaultParams        = params;
        //connManager          = conman;
    }

    
    protected abstract HttpParams createHttpParams();

    
    protected abstract HttpContext createHttpContext();

    
    protected abstract HttpRequestExecutor createRequestExecutor();

    
    protected abstract ClientConnectionManager createClientConnectionManager();

    
    protected abstract AuthSchemeRegistry createAuthSchemeRegistry();

    
    protected abstract CookieSpecRegistry createCookieSpecRegistry();

    
    protected abstract ConnectionReuseStrategy createConnectionReuseStrategy();

    
    protected abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();

    
    protected abstract BasicHttpProcessor createHttpProcessor();

    
    protected abstract HttpRequestRetryHandler createHttpRequestRetryHandler();

    
    protected abstract RedirectHandler createRedirectHandler();

    
    protected abstract AuthenticationHandler createTargetAuthenticationHandler();

    
    protected abstract AuthenticationHandler createProxyAuthenticationHandler();

    
    protected abstract CookieStore createCookieStore();

    
    protected abstract CredentialsProvider createCredentialsProvider();

    
    protected abstract HttpRoutePlanner createHttpRoutePlanner();

    
    protected abstract UserTokenHandler createUserTokenHandler();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.194 -0400", hash_original_method = "0E1E8210CC0DE78C7527875CB41BF658", hash_generated_method = "3FCF9C7ED80EB7B22EC7D1237CEA7363")
    public synchronized final HttpParams getParams() {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_813143976 = null; //Variable for return #1
        {
            defaultParams = createHttpParams();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_813143976 = defaultParams;
        varB4EAC82CA7396A68D541C85D26508E83_813143976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_813143976;
        // ---------- Original Method ----------
        //if (defaultParams == null) {
            //defaultParams = createHttpParams();
        //}
        //return defaultParams;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.195 -0400", hash_original_method = "E8FEA16F6836AB209AB35B29A74CFADA", hash_generated_method = "BC5D0F150AB716DC339EA236FCA8A24D")
    public synchronized void setParams(HttpParams params) {
        defaultParams = params;
        // ---------- Original Method ----------
        //defaultParams = params;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.195 -0400", hash_original_method = "E70C09A1B7F6B835A029131A4BD8CF65", hash_generated_method = "E4D4E6E5A3D656D994CD633C45A35BF5")
    public synchronized final ClientConnectionManager getConnectionManager() {
        ClientConnectionManager varB4EAC82CA7396A68D541C85D26508E83_405708369 = null; //Variable for return #1
        {
            connManager = createClientConnectionManager();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_405708369 = connManager;
        varB4EAC82CA7396A68D541C85D26508E83_405708369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_405708369;
        // ---------- Original Method ----------
        //if (connManager == null) {
            //connManager = createClientConnectionManager();
        //}
        //return connManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.196 -0400", hash_original_method = "E135DC176345D99818B1545EC3559BB7", hash_generated_method = "97C08C736BBDCB01900592C3660711A9")
    public synchronized final HttpRequestExecutor getRequestExecutor() {
        HttpRequestExecutor varB4EAC82CA7396A68D541C85D26508E83_1117327864 = null; //Variable for return #1
        {
            requestExec = createRequestExecutor();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1117327864 = requestExec;
        varB4EAC82CA7396A68D541C85D26508E83_1117327864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117327864;
        // ---------- Original Method ----------
        //if (requestExec == null) {
            //requestExec = createRequestExecutor();
        //}
        //return requestExec;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.196 -0400", hash_original_method = "B64B8CBD2A41A037238B1FA9106B9C55", hash_generated_method = "4996B899D7996C6CBD21358A44225121")
    public synchronized final AuthSchemeRegistry getAuthSchemes() {
        AuthSchemeRegistry varB4EAC82CA7396A68D541C85D26508E83_1552748428 = null; //Variable for return #1
        {
            supportedAuthSchemes = createAuthSchemeRegistry();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1552748428 = supportedAuthSchemes;
        varB4EAC82CA7396A68D541C85D26508E83_1552748428.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552748428;
        // ---------- Original Method ----------
        //if (supportedAuthSchemes == null) {
            //supportedAuthSchemes = createAuthSchemeRegistry();
        //}
        //return supportedAuthSchemes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.196 -0400", hash_original_method = "B5A5E2A2EE7D2FD2092F96692A5CDFDD", hash_generated_method = "3C42503E29092F80429E0AF91C8774F9")
    public synchronized void setAuthSchemes(final AuthSchemeRegistry authSchemeRegistry) {
        supportedAuthSchemes = authSchemeRegistry;
        // ---------- Original Method ----------
        //supportedAuthSchemes = authSchemeRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.203 -0400", hash_original_method = "13CF1774C0163AC97C4FE09A957F51BE", hash_generated_method = "6B02CFD42B378EE388EC8CF9D2310745")
    public synchronized final CookieSpecRegistry getCookieSpecs() {
        CookieSpecRegistry varB4EAC82CA7396A68D541C85D26508E83_1899525440 = null; //Variable for return #1
        {
            supportedCookieSpecs = createCookieSpecRegistry();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1899525440 = supportedCookieSpecs;
        varB4EAC82CA7396A68D541C85D26508E83_1899525440.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1899525440;
        // ---------- Original Method ----------
        //if (supportedCookieSpecs == null) {
            //supportedCookieSpecs = createCookieSpecRegistry();
        //}
        //return supportedCookieSpecs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.203 -0400", hash_original_method = "ECFE272682DD75F5943282F00E9E7207", hash_generated_method = "02A7C140907F5B8EE3A8A142294A0EC2")
    public synchronized void setCookieSpecs(final CookieSpecRegistry cookieSpecRegistry) {
        supportedCookieSpecs = cookieSpecRegistry;
        // ---------- Original Method ----------
        //supportedCookieSpecs = cookieSpecRegistry;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.205 -0400", hash_original_method = "280140DA9BF4BB510F1D77AFF1FE6E38", hash_generated_method = "63C74A13C3A49A8FD87787E1AE2E58E4")
    public synchronized final ConnectionReuseStrategy getConnectionReuseStrategy() {
        ConnectionReuseStrategy varB4EAC82CA7396A68D541C85D26508E83_1552528871 = null; //Variable for return #1
        {
            reuseStrategy = createConnectionReuseStrategy();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1552528871 = reuseStrategy;
        varB4EAC82CA7396A68D541C85D26508E83_1552528871.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1552528871;
        // ---------- Original Method ----------
        //if (reuseStrategy == null) {
            //reuseStrategy = createConnectionReuseStrategy();
        //}
        //return reuseStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.205 -0400", hash_original_method = "0133833828FCF3626C93AA839CEB0491", hash_generated_method = "AF5320EFD9E99DC33F92EA7E0CED5A8B")
    public synchronized void setReuseStrategy(final ConnectionReuseStrategy reuseStrategy) {
        this.reuseStrategy = reuseStrategy;
        // ---------- Original Method ----------
        //this.reuseStrategy = reuseStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.216 -0400", hash_original_method = "0109C95DAAF90D45512D49D44811C1BC", hash_generated_method = "C97BE104F1B77A2EB99FEC9EA396329B")
    public synchronized final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        ConnectionKeepAliveStrategy varB4EAC82CA7396A68D541C85D26508E83_278834112 = null; //Variable for return #1
        {
            keepAliveStrategy = createConnectionKeepAliveStrategy();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_278834112 = keepAliveStrategy;
        varB4EAC82CA7396A68D541C85D26508E83_278834112.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_278834112;
        // ---------- Original Method ----------
        //if (keepAliveStrategy == null) {
            //keepAliveStrategy = createConnectionKeepAliveStrategy();
        //}
        //return keepAliveStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.221 -0400", hash_original_method = "D20C58629EEB51CAE85A715149CC7D7C", hash_generated_method = "B3F9B24A37A8DE5E73DDF55AD916F9EB")
    public synchronized void setKeepAliveStrategy(final ConnectionKeepAliveStrategy keepAliveStrategy) {
        this.keepAliveStrategy = keepAliveStrategy;
        // ---------- Original Method ----------
        //this.keepAliveStrategy = keepAliveStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.222 -0400", hash_original_method = "EDC64C630F8C9BB9424AE860B2C098D2", hash_generated_method = "FEEDCDB87B034472A8C988B9774CF954")
    public synchronized final HttpRequestRetryHandler getHttpRequestRetryHandler() {
        HttpRequestRetryHandler varB4EAC82CA7396A68D541C85D26508E83_2110439786 = null; //Variable for return #1
        {
            retryHandler = createHttpRequestRetryHandler();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2110439786 = retryHandler;
        varB4EAC82CA7396A68D541C85D26508E83_2110439786.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2110439786;
        // ---------- Original Method ----------
        //if (retryHandler == null) {
            //retryHandler = createHttpRequestRetryHandler();
        //}
        //return retryHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.223 -0400", hash_original_method = "19552606DD1E479BE8417A8173CF9EA3", hash_generated_method = "985889BC4F1D66823E0485810DB22646")
    public synchronized void setHttpRequestRetryHandler(final HttpRequestRetryHandler retryHandler) {
        this.retryHandler = retryHandler;
        // ---------- Original Method ----------
        //this.retryHandler = retryHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.225 -0400", hash_original_method = "33F9D2B028213B54FFCD534F34C4B977", hash_generated_method = "6ADE00302734DD4747BC467BF9AD60A1")
    public synchronized final RedirectHandler getRedirectHandler() {
        RedirectHandler varB4EAC82CA7396A68D541C85D26508E83_1259136801 = null; //Variable for return #1
        {
            redirectHandler = createRedirectHandler();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1259136801 = redirectHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1259136801.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1259136801;
        // ---------- Original Method ----------
        //if (redirectHandler == null) {
            //redirectHandler = createRedirectHandler();
        //}
        //return redirectHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.228 -0400", hash_original_method = "07A813B5AFD38C75974602ADA745C22B", hash_generated_method = "73ABE2415F8D9F22FC4D05EC42A96B5F")
    public synchronized void setRedirectHandler(final RedirectHandler redirectHandler) {
        this.redirectHandler = redirectHandler;
        // ---------- Original Method ----------
        //this.redirectHandler = redirectHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.228 -0400", hash_original_method = "DCBE39367A729541D3366A866F88A6B5", hash_generated_method = "B12A406CAF61085E7992D069DE69D599")
    public synchronized final AuthenticationHandler getTargetAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_1076136071 = null; //Variable for return #1
        {
            targetAuthHandler = createTargetAuthenticationHandler();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1076136071 = targetAuthHandler;
        varB4EAC82CA7396A68D541C85D26508E83_1076136071.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1076136071;
        // ---------- Original Method ----------
        //if (targetAuthHandler == null) {
            //targetAuthHandler = createTargetAuthenticationHandler();
        //}
        //return targetAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.231 -0400", hash_original_method = "3685124053FD269048709264319B81C4", hash_generated_method = "7F19CABE1B8FBFBC290DE1DCC8C0E27B")
    public synchronized void setTargetAuthenticationHandler(
            final AuthenticationHandler targetAuthHandler) {
        this.targetAuthHandler = targetAuthHandler;
        // ---------- Original Method ----------
        //this.targetAuthHandler = targetAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.239 -0400", hash_original_method = "FE6A31C4BC47B922AE7100411D6D3962", hash_generated_method = "9DB66CA54DC9B4C916AAEEE59F71E226")
    public synchronized final AuthenticationHandler getProxyAuthenticationHandler() {
        AuthenticationHandler varB4EAC82CA7396A68D541C85D26508E83_549048855 = null; //Variable for return #1
        {
            proxyAuthHandler = createProxyAuthenticationHandler();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_549048855 = proxyAuthHandler;
        varB4EAC82CA7396A68D541C85D26508E83_549048855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_549048855;
        // ---------- Original Method ----------
        //if (proxyAuthHandler == null) {
            //proxyAuthHandler = createProxyAuthenticationHandler();
        //}
        //return proxyAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.239 -0400", hash_original_method = "4AA8E7473E47BB58C8F6156C1A703EBB", hash_generated_method = "356451F6A605451A11F8421138DE04CD")
    public synchronized void setProxyAuthenticationHandler(
            final AuthenticationHandler proxyAuthHandler) {
        this.proxyAuthHandler = proxyAuthHandler;
        // ---------- Original Method ----------
        //this.proxyAuthHandler = proxyAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.240 -0400", hash_original_method = "CED19DC63F5DFF3B80D2B1F10482E892", hash_generated_method = "147AEB8BF3ADDFDF193D2BEC5ADDB834")
    public synchronized final CookieStore getCookieStore() {
        CookieStore varB4EAC82CA7396A68D541C85D26508E83_1018146482 = null; //Variable for return #1
        {
            cookieStore = createCookieStore();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1018146482 = cookieStore;
        varB4EAC82CA7396A68D541C85D26508E83_1018146482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1018146482;
        // ---------- Original Method ----------
        //if (cookieStore == null) {
            //cookieStore = createCookieStore();
        //}
        //return cookieStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.241 -0400", hash_original_method = "6E3B852BBCF6A420BC19B0060772D5B7", hash_generated_method = "901644A30539362C37C64ED0E9AD33C4")
    public synchronized void setCookieStore(final CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        // ---------- Original Method ----------
        //this.cookieStore = cookieStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.252 -0400", hash_original_method = "98E8D6F59FD454CB3C7069127AA5844B", hash_generated_method = "047DBC0D75F080D542F915ADBC25945C")
    public synchronized final CredentialsProvider getCredentialsProvider() {
        CredentialsProvider varB4EAC82CA7396A68D541C85D26508E83_1481718992 = null; //Variable for return #1
        {
            credsProvider = createCredentialsProvider();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1481718992 = credsProvider;
        varB4EAC82CA7396A68D541C85D26508E83_1481718992.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1481718992;
        // ---------- Original Method ----------
        //if (credsProvider == null) {
            //credsProvider = createCredentialsProvider();
        //}
        //return credsProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.253 -0400", hash_original_method = "84417141BEDCB871793C7CE856775B85", hash_generated_method = "BA9188757149893D624B8659AF5EAA2C")
    public synchronized void setCredentialsProvider(final CredentialsProvider credsProvider) {
        this.credsProvider = credsProvider;
        // ---------- Original Method ----------
        //this.credsProvider = credsProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.253 -0400", hash_original_method = "70B10D4ECA33F90F2399EBBBDBCB28FD", hash_generated_method = "8E34AFE2EE55F6F2D9BF74186EABD4B7")
    public synchronized final HttpRoutePlanner getRoutePlanner() {
        HttpRoutePlanner varB4EAC82CA7396A68D541C85D26508E83_858275780 = null; //Variable for return #1
        {
            this.routePlanner = createHttpRoutePlanner();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_858275780 = this.routePlanner;
        varB4EAC82CA7396A68D541C85D26508E83_858275780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_858275780;
        // ---------- Original Method ----------
        //if (this.routePlanner == null) {
            //this.routePlanner = createHttpRoutePlanner();
        //}
        //return this.routePlanner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.254 -0400", hash_original_method = "3BD66AC4C2DF9FC67B263F6DFA8FD061", hash_generated_method = "FDD7402A6E317D6AFBAF72C7F3C5329F")
    public synchronized void setRoutePlanner(final HttpRoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
        // ---------- Original Method ----------
        //this.routePlanner = routePlanner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.254 -0400", hash_original_method = "7975319476225B5506DDD068000CD697", hash_generated_method = "7601E93E308A6C7EC66CC119274317D6")
    public synchronized final UserTokenHandler getUserTokenHandler() {
        UserTokenHandler varB4EAC82CA7396A68D541C85D26508E83_967498459 = null; //Variable for return #1
        {
            this.userTokenHandler = createUserTokenHandler();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_967498459 = this.userTokenHandler;
        varB4EAC82CA7396A68D541C85D26508E83_967498459.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_967498459;
        // ---------- Original Method ----------
        //if (this.userTokenHandler == null) {
            //this.userTokenHandler = createUserTokenHandler();
        //}
        //return this.userTokenHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.255 -0400", hash_original_method = "FFF313FCFA52F9BED7C1E5BB0A288A32", hash_generated_method = "2F9250109242DF93749FD0275E8C2401")
    public synchronized void setUserTokenHandler(final UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
        // ---------- Original Method ----------
        //this.userTokenHandler = userTokenHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.255 -0400", hash_original_method = "A054071B5C703A0BBBB93F177E316F94", hash_generated_method = "E11695337A27EC753D4D702F763CA9B0")
    protected synchronized final BasicHttpProcessor getHttpProcessor() {
        BasicHttpProcessor varB4EAC82CA7396A68D541C85D26508E83_1764835540 = null; //Variable for return #1
        {
            httpProcessor = createHttpProcessor();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1764835540 = httpProcessor;
        varB4EAC82CA7396A68D541C85D26508E83_1764835540.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1764835540;
        // ---------- Original Method ----------
        //if (httpProcessor == null) {
            //httpProcessor = createHttpProcessor();
        //}
        //return httpProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.266 -0400", hash_original_method = "C43412A77AD4A73A401FFD4D6C19DEC0", hash_generated_method = "4EC901583640C5BEB1A34B3DD9794B8F")
    public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
        addTaint(itcp.getTaint());
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.266 -0400", hash_original_method = "F05A17FD0AC8D9037BF5BD8F186688B0", hash_generated_method = "8D11BC809D0A75B679791C53D012B330")
    public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
        addTaint(itcp.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.267 -0400", hash_original_method = "42A1BB66B3595540F9652B515180E4CB", hash_generated_method = "0FA756953B3A0134BC2DB7DAF0CDF36B")
    public synchronized HttpResponseInterceptor getResponseInterceptor(int index) {
        HttpResponseInterceptor varB4EAC82CA7396A68D541C85D26508E83_738081588 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_738081588 = getHttpProcessor().getResponseInterceptor(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_738081588.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_738081588;
        // ---------- Original Method ----------
        //return getHttpProcessor().getResponseInterceptor(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.267 -0400", hash_original_method = "5AA44E0EBC7669E8C12BB7D18976B6A3", hash_generated_method = "15405E10AE4C8C13B1D1077402D44140")
    public synchronized int getResponseInterceptorCount() {
        int var5AF261A6094359C721D955B714E19B36_1943793872 = (getHttpProcessor().getResponseInterceptorCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75806053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_75806053;
        // ---------- Original Method ----------
        //return getHttpProcessor().getResponseInterceptorCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.268 -0400", hash_original_method = "37835CD99974C274F51BA3B209149DC5", hash_generated_method = "5C0A7ECAE42D29CBA9A2D07A634B67C4")
    public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
        // ---------- Original Method ----------
        //getHttpProcessor().clearResponseInterceptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.268 -0400", hash_original_method = "6A5F71CEA46F78E6D39221F9549EADAD", hash_generated_method = "EA3555E689C01C3F997ED90CB8FA8BF3")
    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> clazz) {
        getHttpProcessor().removeResponseInterceptorByClass(clazz);
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
        //getHttpProcessor().removeResponseInterceptorByClass(clazz);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.269 -0400", hash_original_method = "EB011C9A439616D653F69491914F8398", hash_generated_method = "F71CFEC891BBA27D8F127D613E13C196")
    public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
        addTaint(itcp.getTaint());
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.269 -0400", hash_original_method = "B3E4640F3C062B15218CD2B2F2632BF2", hash_generated_method = "19F02DA9D7B812F47C455337D0BDCC19")
    public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
        addTaint(itcp.getTaint());
        addTaint(index);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.270 -0400", hash_original_method = "3B8965152373170CD1AE42DF74FC23C9", hash_generated_method = "E23D6F48C1B251305E8C077814D83067")
    public synchronized HttpRequestInterceptor getRequestInterceptor(int index) {
        HttpRequestInterceptor varB4EAC82CA7396A68D541C85D26508E83_1360622384 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1360622384 = getHttpProcessor().getRequestInterceptor(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1360622384.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1360622384;
        // ---------- Original Method ----------
        //return getHttpProcessor().getRequestInterceptor(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.270 -0400", hash_original_method = "F968E9F4352A234FB330890874D0E8D3", hash_generated_method = "89FB0DC9C2A1A7AF11EB3BD88FA5C8D1")
    public synchronized int getRequestInterceptorCount() {
        int var0D280219756D7A40CB3AA5C38137ACA2_1333973041 = (getHttpProcessor().getRequestInterceptorCount());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194922223 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1194922223;
        // ---------- Original Method ----------
        //return getHttpProcessor().getRequestInterceptorCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.270 -0400", hash_original_method = "71ED0A9BF43B0DB4DD62422FA6127326", hash_generated_method = "284478C231A7ED3EAB636F66A5467B37")
    public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
        // ---------- Original Method ----------
        //getHttpProcessor().clearRequestInterceptors();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.271 -0400", hash_original_method = "388288F90509812A8D957678B2075EF7", hash_generated_method = "362ABDDFEADBACB10E226BFBBAF5A5EB")
    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> clazz) {
        getHttpProcessor().removeRequestInterceptorByClass(clazz);
        addTaint(clazz.getTaint());
        // ---------- Original Method ----------
        //getHttpProcessor().removeRequestInterceptorByClass(clazz);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.291 -0400", hash_original_method = "8C5414A352E96D69F8672C617A799B3F", hash_generated_method = "C7DF6C2D2D8D120966E96A6CD315F794")
    public final HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1972073000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1972073000 = execute(request, (HttpContext) null);
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1972073000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1972073000;
        // ---------- Original Method ----------
        //return execute(request, (HttpContext) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.292 -0400", hash_original_method = "DFABA59EDA546A2813170916E96DC886", hash_generated_method = "387FF2A714021C1BCA4AAB39C094DE4B")
    public final HttpResponse execute(HttpUriRequest request,
                                      HttpContext context) throws IOException, ClientProtocolException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_328866875 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Request must not be null.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_328866875 = execute(determineTarget(request), request, context);
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_328866875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328866875;
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException
                //("Request must not be null.");
        //}
        //return execute(determineTarget(request), request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.293 -0400", hash_original_method = "D4908515F9C0F07C0BDB783E33343E25", hash_generated_method = "260044EE3114153566A75E5F4A5FFC01")
    private HttpHost determineTarget(HttpUriRequest request) {
        HttpHost varB4EAC82CA7396A68D541C85D26508E83_438192541 = null; //Variable for return #1
        HttpHost target;
        target = null;
        URI requestURI;
        requestURI = request.getURI();
        {
            boolean var3EB53D7721E59547DEF4ACCC41D3DE9A_326288808 = (requestURI.isAbsolute());
            {
                target = new HttpHost(
                    requestURI.getHost(),
                    requestURI.getPort(),
                    requestURI.getScheme());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_438192541 = target;
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_438192541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_438192541;
        // ---------- Original Method ----------
        //HttpHost target = null;
        //URI requestURI = request.getURI();
        //if (requestURI.isAbsolute()) {
            //target = new HttpHost(
                    //requestURI.getHost(),
                    //requestURI.getPort(),
                    //requestURI.getScheme());
        //}
        //return target;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.293 -0400", hash_original_method = "7C51BA6300B6898AA66ADB20A5FEE58B", hash_generated_method = "440B080CA5C815F7844293BEE28BDC33")
    public final HttpResponse execute(HttpHost target, HttpRequest request) throws IOException, ClientProtocolException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1783781070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1783781070 = execute(target, request, (HttpContext) null);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1783781070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1783781070;
        // ---------- Original Method ----------
        //return execute(target, request, (HttpContext) null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.294 -0400", hash_original_method = "831E31825E37427A81D59F1020149460", hash_generated_method = "A5519CFAC3D553F4A01D8EC61B0C54F0")
    public final HttpResponse execute(HttpHost target, HttpRequest request,
                                      HttpContext context) throws IOException, ClientProtocolException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_76238986 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Request must not be null.");
        } //End block
        HttpContext execContext;
        execContext = null;
        RequestDirector director;
        director = null;
        {
            HttpContext defaultContext;
            defaultContext = createHttpContext();
            {
                execContext = defaultContext;
            } //End block
            {
                execContext = new DefaultedHttpContext(context, defaultContext);
            } //End block
            director = createClientRequestDirector(
                    getRequestExecutor(),
                    getConnectionManager(),
                    getConnectionReuseStrategy(),
                    getConnectionKeepAliveStrategy(),
                    getRoutePlanner(),
                    getHttpProcessor().copy(),
                    getHttpRequestRetryHandler(),
                    getRedirectHandler(),
                    getTargetAuthenticationHandler(),
                    getProxyAuthenticationHandler(),
                    getUserTokenHandler(),
                    determineParams(request));
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_76238986 = director.execute(target, request, execContext);
        } //End block
        catch (HttpException httpException)
        {
            if (DroidSafeAndroidRuntime.control) throw new ClientProtocolException(httpException);
        } //End block
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_76238986.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76238986;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.314 -0400", hash_original_method = "005994C3A0F7DC1EFC9539C703B59C31", hash_generated_method = "7EC9D153CCB621EECD962D4E1C4F10E3")
    protected RequestDirector createClientRequestDirector(
            final HttpRequestExecutor requestExec,
            final ClientConnectionManager conman,
            final ConnectionReuseStrategy reustrat,
            final ConnectionKeepAliveStrategy kastrat,
            final HttpRoutePlanner rouplan,
            final HttpProcessor httpProcessor,
            final HttpRequestRetryHandler retryHandler,
            final RedirectHandler redirectHandler,
            final AuthenticationHandler targetAuthHandler,
            final AuthenticationHandler proxyAuthHandler,
            final UserTokenHandler stateHandler,
            final HttpParams params) {
        RequestDirector varB4EAC82CA7396A68D541C85D26508E83_831302128 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_831302128 = new DefaultRequestDirector(
                requestExec,
                conman,
                reustrat,
                kastrat,
                rouplan,
                httpProcessor,
                retryHandler,
                redirectHandler,
                targetAuthHandler,
                proxyAuthHandler,
                stateHandler,
                params);
        addTaint(requestExec.getTaint());
        addTaint(conman.getTaint());
        addTaint(reustrat.getTaint());
        addTaint(kastrat.getTaint());
        addTaint(rouplan.getTaint());
        addTaint(httpProcessor.getTaint());
        addTaint(retryHandler.getTaint());
        addTaint(redirectHandler.getTaint());
        addTaint(targetAuthHandler.getTaint());
        addTaint(proxyAuthHandler.getTaint());
        addTaint(stateHandler.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_831302128.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_831302128;
        // ---------- Original Method ----------
        //return new DefaultRequestDirector(
                //requestExec,
                //conman,
                //reustrat,
                //kastrat,
                //rouplan,
                //httpProcessor,
                //retryHandler,
                //redirectHandler,
                //targetAuthHandler,
                //proxyAuthHandler,
                //stateHandler,
                //params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.316 -0400", hash_original_method = "E499E0F2B2039488538F6EF393E5A555", hash_generated_method = "AB73711218858D33599C533DD5B3F0B3")
    protected HttpParams determineParams(HttpRequest req) {
        HttpParams varB4EAC82CA7396A68D541C85D26508E83_1081476293 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1081476293 = new ClientParamsStack
            (null, getParams(), req.getParams(), null);
        addTaint(req.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1081476293.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1081476293;
        // ---------- Original Method ----------
        //return new ClientParamsStack
            //(null, getParams(), req.getParams(), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.316 -0400", hash_original_method = "599A71AED7A734F2BBB0329C86D40EA5", hash_generated_method = "694C3C7B7D68C281FEAD3AD6BDF4FB98")
    public <T> T execute(
            final HttpUriRequest request, 
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_1555804985 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1555804985 = execute(request, responseHandler, null);
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1555804985.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1555804985;
        // ---------- Original Method ----------
        //return execute(request, responseHandler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.318 -0400", hash_original_method = "6E13CCC1CB10D4179E4E7AE1A7FF6054", hash_generated_method = "D4C6574E7BDE98C67033B0F2B6D0D59E")
    public <T> T execute(
            final HttpUriRequest request,
            final ResponseHandler<? extends T> responseHandler, 
            final HttpContext context) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_582385737 = null; //Variable for return #1
        HttpHost target;
        target = determineTarget(request);
        varB4EAC82CA7396A68D541C85D26508E83_582385737 = execute(target, request, responseHandler, context);
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_582385737.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_582385737;
        // ---------- Original Method ----------
        //HttpHost target = determineTarget(request);
        //return execute(target, request, responseHandler, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.318 -0400", hash_original_method = "19C63352B91033068C787AD06D23F86A", hash_generated_method = "BB6DC713CA2A6FEBF84C24CE998E6CB5")
    public <T> T execute(
            final HttpHost target, 
            final HttpRequest request,
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_300784059 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_300784059 = execute(target, request, responseHandler, null);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_300784059.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_300784059;
        // ---------- Original Method ----------
        //return execute(target, request, responseHandler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.336 -0400", hash_original_method = "99C065FAB199CDE7300B84D2FBAE687C", hash_generated_method = "8B2578B4B9ED246442243C11B1BD5F7C")
    public <T> T execute(
            final HttpHost target, 
            final HttpRequest request,
            final ResponseHandler<? extends T> responseHandler, 
            final HttpContext context) throws IOException, ClientProtocolException {
        T varB4EAC82CA7396A68D541C85D26508E83_1017673775 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Response handler must not be null.");
        } //End block
        HttpResponse response;
        response = execute(target, request, context);
        T result;
        try 
        {
            result = responseHandler.handleResponse(response);
        } //End block
        catch (Throwable t)
        {
            HttpEntity entity;
            entity = response.getEntity();
            {
                try 
                {
                    entity.consumeContent();
                } //End block
                catch (Throwable t2)
                {
                    this.log.warn("Error consuming content after an exception.", t2);
                } //End block
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw (Error) t;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw (RuntimeException) t;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw (IOException) t;
            } //End block
            if (DroidSafeAndroidRuntime.control) throw new UndeclaredThrowableException(t);
        } //End block
        HttpEntity entity;
        entity = response.getEntity();
        {
            entity.consumeContent();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1017673775 = result;
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1017673775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1017673775;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

