package org.apache.http.impl.client;

// Droidsafe Imports
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.net.URI;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.auth.AuthSchemeRegistry;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.ResponseHandler;
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class AbstractHttpClient implements HttpClient {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.564 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.564 -0400", hash_original_field = "50E5261D8BCA7AE22F750DB5A5E38482", hash_generated_field = "2B47D5796605ED0337DCB8253B1896C5")

    private HttpParams defaultParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.564 -0400", hash_original_field = "EBFB9A3D3F58438E791B5FA697F0E019", hash_generated_field = "4A99276FC1CAC2C29AE58A664804FA18")

    private HttpRequestExecutor requestExec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.564 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "B110094B2D9FE8F9DF9475794843EE87")

    private ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "6841B3DB425CF924E2406CCC3EC7D0C4", hash_generated_field = "53F301D72A057E2DF8B8C939D3D9CD90")

    private ConnectionReuseStrategy reuseStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "06037BBEEBDAD4B9CCEA6123FF7CEF48", hash_generated_field = "6B7DB7136FD3BAE521073378AFDD44BF")

    private ConnectionKeepAliveStrategy keepAliveStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "707C5B77EDEF1C2CC7B74E62BACCEA74", hash_generated_field = "3451161F1CFA2C123C0FE67101143B08")

    private CookieSpecRegistry supportedCookieSpecs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "AC7D9D61F24C0E6B0C04963EA0140E4F", hash_generated_field = "0CFF0C92AFAE4510CB7819EC35269016")

    private AuthSchemeRegistry supportedAuthSchemes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "752D4EFA0487789E224C2A1BB7CC684E", hash_generated_field = "9AB2A5083E09B99512C85C1D40618272")

    private BasicHttpProcessor httpProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "9276D9188CF6BA2DC6A4953C0672BC3D", hash_generated_field = "30F0E3855973CBC5841163CE464CF151")

    private HttpRequestRetryHandler retryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "F350623671C50CD5233E0DC58B4BC69F", hash_generated_field = "E830C98496C1F40082C35296635B7B2E")

    private RedirectHandler redirectHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "6FA7D1184BC1FAC634576AE3416BC1FC", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "0F58376CC8049DF18F70792E6CDE0CBB", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.565 -0400", hash_original_field = "1DFFC198ED2418E9EE70ADA53C5F647E", hash_generated_field = "48EBEC1FDB75AF182113D4070DF327E8")

    private CookieStore cookieStore;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.566 -0400", hash_original_field = "EFA53F3DE5392737486FC7E889846147", hash_generated_field = "74F60E181398330BC8F9F57CE3109107")

    private CredentialsProvider credsProvider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.566 -0400", hash_original_field = "16B9BCB9C810B5FB9F1218ABF5433F0A", hash_generated_field = "993C3C48EF45D276D4920986CC1A695F")

    private HttpRoutePlanner routePlanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.566 -0400", hash_original_field = "7CA4C2AD16B3CB439480B96FCAB580BC", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.567 -0400", hash_original_method = "649332244E1BD2DC633E57F283CE534F", hash_generated_method = "7B5BB166B285F69B9BDACA31B48312B6")
    protected  AbstractHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        defaultParams        = params;
        connManager          = conman;
        // ---------- Original Method ----------
        //defaultParams        = params;
        //connManager          = conman;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract HttpParams createHttpParams();

    
    @DSModeled(DSC.SAFE)
    protected abstract HttpContext createHttpContext();

    
    @DSModeled(DSC.SAFE)
    protected abstract HttpRequestExecutor createRequestExecutor();

    
    @DSModeled(DSC.SAFE)
    protected abstract ClientConnectionManager createClientConnectionManager();

    
    @DSModeled(DSC.SAFE)
    protected abstract AuthSchemeRegistry createAuthSchemeRegistry();

    
    @DSModeled(DSC.SAFE)
    protected abstract CookieSpecRegistry createCookieSpecRegistry();

    
    @DSModeled(DSC.SAFE)
    protected abstract ConnectionReuseStrategy createConnectionReuseStrategy();

    
    @DSModeled(DSC.SAFE)
    protected abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();

    
    @DSModeled(DSC.SAFE)
    protected abstract BasicHttpProcessor createHttpProcessor();

    
    @DSModeled(DSC.SAFE)
    protected abstract HttpRequestRetryHandler createHttpRequestRetryHandler();

    
    @DSModeled(DSC.SAFE)
    protected abstract RedirectHandler createRedirectHandler();

    
    @DSModeled(DSC.SAFE)
    protected abstract AuthenticationHandler createTargetAuthenticationHandler();

    
    @DSModeled(DSC.SAFE)
    protected abstract AuthenticationHandler createProxyAuthenticationHandler();

    
    @DSModeled(DSC.SAFE)
    protected abstract CookieStore createCookieStore();

    
    @DSModeled(DSC.SAFE)
    protected abstract CredentialsProvider createCredentialsProvider();

    
    @DSModeled(DSC.SAFE)
    protected abstract HttpRoutePlanner createHttpRoutePlanner();

    
    @DSModeled(DSC.SAFE)
    protected abstract UserTokenHandler createUserTokenHandler();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.572 -0400", hash_original_method = "0E1E8210CC0DE78C7527875CB41BF658", hash_generated_method = "9F083B80D868282A92BF3C41CD4313A0")
    public synchronized final HttpParams getParams() {
        if(defaultParams == null)        
        {
            defaultParams = createHttpParams();
        } //End block
HttpParams var44B488213C6710CAA88E56A7B52636A1_510823127 =         defaultParams;
        var44B488213C6710CAA88E56A7B52636A1_510823127.addTaint(taint);
        return var44B488213C6710CAA88E56A7B52636A1_510823127;
        // ---------- Original Method ----------
        //if (defaultParams == null) {
            //defaultParams = createHttpParams();
        //}
        //return defaultParams;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.573 -0400", hash_original_method = "E8FEA16F6836AB209AB35B29A74CFADA", hash_generated_method = "BC5D0F150AB716DC339EA236FCA8A24D")
    public synchronized void setParams(HttpParams params) {
        defaultParams = params;
        // ---------- Original Method ----------
        //defaultParams = params;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.574 -0400", hash_original_method = "E70C09A1B7F6B835A029131A4BD8CF65", hash_generated_method = "212FBC1A56123B6B4DAB5AA07FCFA83A")
    public synchronized final ClientConnectionManager getConnectionManager() {
        if(connManager == null)        
        {
            connManager = createClientConnectionManager();
        } //End block
ClientConnectionManager varA3F19198A23DEA30D08223E00C8A3A82_1041187094 =         connManager;
        varA3F19198A23DEA30D08223E00C8A3A82_1041187094.addTaint(taint);
        return varA3F19198A23DEA30D08223E00C8A3A82_1041187094;
        // ---------- Original Method ----------
        //if (connManager == null) {
            //connManager = createClientConnectionManager();
        //}
        //return connManager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.574 -0400", hash_original_method = "E135DC176345D99818B1545EC3559BB7", hash_generated_method = "98AD030F49FAD4B88DD7EEDA264733A8")
    public synchronized final HttpRequestExecutor getRequestExecutor() {
        if(requestExec == null)        
        {
            requestExec = createRequestExecutor();
        } //End block
HttpRequestExecutor var8DBD400D59E485565CB5FE9A1AB57B3B_647855367 =         requestExec;
        var8DBD400D59E485565CB5FE9A1AB57B3B_647855367.addTaint(taint);
        return var8DBD400D59E485565CB5FE9A1AB57B3B_647855367;
        // ---------- Original Method ----------
        //if (requestExec == null) {
            //requestExec = createRequestExecutor();
        //}
        //return requestExec;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.574 -0400", hash_original_method = "B64B8CBD2A41A037238B1FA9106B9C55", hash_generated_method = "747E457BB7148A16B4AF2515C95ADFD1")
    public synchronized final AuthSchemeRegistry getAuthSchemes() {
        if(supportedAuthSchemes == null)        
        {
            supportedAuthSchemes = createAuthSchemeRegistry();
        } //End block
AuthSchemeRegistry var1D6A0ADE255A698E8F43B1E2D290AEE8_349352746 =         supportedAuthSchemes;
        var1D6A0ADE255A698E8F43B1E2D290AEE8_349352746.addTaint(taint);
        return var1D6A0ADE255A698E8F43B1E2D290AEE8_349352746;
        // ---------- Original Method ----------
        //if (supportedAuthSchemes == null) {
            //supportedAuthSchemes = createAuthSchemeRegistry();
        //}
        //return supportedAuthSchemes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.574 -0400", hash_original_method = "B5A5E2A2EE7D2FD2092F96692A5CDFDD", hash_generated_method = "3C42503E29092F80429E0AF91C8774F9")
    public synchronized void setAuthSchemes(final AuthSchemeRegistry authSchemeRegistry) {
        supportedAuthSchemes = authSchemeRegistry;
        // ---------- Original Method ----------
        //supportedAuthSchemes = authSchemeRegistry;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.574 -0400", hash_original_method = "13CF1774C0163AC97C4FE09A957F51BE", hash_generated_method = "31F978FA5C3573413117C2ECAAF3FC00")
    public synchronized final CookieSpecRegistry getCookieSpecs() {
        if(supportedCookieSpecs == null)        
        {
            supportedCookieSpecs = createCookieSpecRegistry();
        } //End block
CookieSpecRegistry var03DD863D201DBFCBCC9315ABE44F665D_1103312737 =         supportedCookieSpecs;
        var03DD863D201DBFCBCC9315ABE44F665D_1103312737.addTaint(taint);
        return var03DD863D201DBFCBCC9315ABE44F665D_1103312737;
        // ---------- Original Method ----------
        //if (supportedCookieSpecs == null) {
            //supportedCookieSpecs = createCookieSpecRegistry();
        //}
        //return supportedCookieSpecs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "ECFE272682DD75F5943282F00E9E7207", hash_generated_method = "02A7C140907F5B8EE3A8A142294A0EC2")
    public synchronized void setCookieSpecs(final CookieSpecRegistry cookieSpecRegistry) {
        supportedCookieSpecs = cookieSpecRegistry;
        // ---------- Original Method ----------
        //supportedCookieSpecs = cookieSpecRegistry;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "280140DA9BF4BB510F1D77AFF1FE6E38", hash_generated_method = "0A4CA6AB7990C55D2D380C17DD14F3FD")
    public synchronized final ConnectionReuseStrategy getConnectionReuseStrategy() {
        if(reuseStrategy == null)        
        {
            reuseStrategy = createConnectionReuseStrategy();
        } //End block
ConnectionReuseStrategy varC37844E15433FF489CCF7DF2085601AF_1893986479 =         reuseStrategy;
        varC37844E15433FF489CCF7DF2085601AF_1893986479.addTaint(taint);
        return varC37844E15433FF489CCF7DF2085601AF_1893986479;
        // ---------- Original Method ----------
        //if (reuseStrategy == null) {
            //reuseStrategy = createConnectionReuseStrategy();
        //}
        //return reuseStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "0133833828FCF3626C93AA839CEB0491", hash_generated_method = "AF5320EFD9E99DC33F92EA7E0CED5A8B")
    public synchronized void setReuseStrategy(final ConnectionReuseStrategy reuseStrategy) {
        this.reuseStrategy = reuseStrategy;
        // ---------- Original Method ----------
        //this.reuseStrategy = reuseStrategy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "0109C95DAAF90D45512D49D44811C1BC", hash_generated_method = "C2CD8CC30681B1973710F1AE5488461F")
    public synchronized final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        if(keepAliveStrategy == null)        
        {
            keepAliveStrategy = createConnectionKeepAliveStrategy();
        } //End block
ConnectionKeepAliveStrategy var350D15DC240AE1CEBE26AA8C1FB91B5D_438466984 =         keepAliveStrategy;
        var350D15DC240AE1CEBE26AA8C1FB91B5D_438466984.addTaint(taint);
        return var350D15DC240AE1CEBE26AA8C1FB91B5D_438466984;
        // ---------- Original Method ----------
        //if (keepAliveStrategy == null) {
            //keepAliveStrategy = createConnectionKeepAliveStrategy();
        //}
        //return keepAliveStrategy;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "D20C58629EEB51CAE85A715149CC7D7C", hash_generated_method = "B3F9B24A37A8DE5E73DDF55AD916F9EB")
    public synchronized void setKeepAliveStrategy(final ConnectionKeepAliveStrategy keepAliveStrategy) {
        this.keepAliveStrategy = keepAliveStrategy;
        // ---------- Original Method ----------
        //this.keepAliveStrategy = keepAliveStrategy;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "EDC64C630F8C9BB9424AE860B2C098D2", hash_generated_method = "93742427C3BB5251353BE15D3A072A07")
    public synchronized final HttpRequestRetryHandler getHttpRequestRetryHandler() {
        if(retryHandler == null)        
        {
            retryHandler = createHttpRequestRetryHandler();
        } //End block
HttpRequestRetryHandler var27CFE2B9CEAB74F4158D32BF7CE29442_1120576827 =         retryHandler;
        var27CFE2B9CEAB74F4158D32BF7CE29442_1120576827.addTaint(taint);
        return var27CFE2B9CEAB74F4158D32BF7CE29442_1120576827;
        // ---------- Original Method ----------
        //if (retryHandler == null) {
            //retryHandler = createHttpRequestRetryHandler();
        //}
        //return retryHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.575 -0400", hash_original_method = "19552606DD1E479BE8417A8173CF9EA3", hash_generated_method = "985889BC4F1D66823E0485810DB22646")
    public synchronized void setHttpRequestRetryHandler(final HttpRequestRetryHandler retryHandler) {
        this.retryHandler = retryHandler;
        // ---------- Original Method ----------
        //this.retryHandler = retryHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.576 -0400", hash_original_method = "33F9D2B028213B54FFCD534F34C4B977", hash_generated_method = "F5523BA74689FA91DDE1B5A035973DA8")
    public synchronized final RedirectHandler getRedirectHandler() {
        if(redirectHandler == null)        
        {
            redirectHandler = createRedirectHandler();
        } //End block
RedirectHandler var969FF4899AC3037F7E626C3A09754AB9_634206803 =         redirectHandler;
        var969FF4899AC3037F7E626C3A09754AB9_634206803.addTaint(taint);
        return var969FF4899AC3037F7E626C3A09754AB9_634206803;
        // ---------- Original Method ----------
        //if (redirectHandler == null) {
            //redirectHandler = createRedirectHandler();
        //}
        //return redirectHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.576 -0400", hash_original_method = "07A813B5AFD38C75974602ADA745C22B", hash_generated_method = "73ABE2415F8D9F22FC4D05EC42A96B5F")
    public synchronized void setRedirectHandler(final RedirectHandler redirectHandler) {
        this.redirectHandler = redirectHandler;
        // ---------- Original Method ----------
        //this.redirectHandler = redirectHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.576 -0400", hash_original_method = "DCBE39367A729541D3366A866F88A6B5", hash_generated_method = "F921AF0A1D39041D467B346C346276B8")
    public synchronized final AuthenticationHandler getTargetAuthenticationHandler() {
        if(targetAuthHandler == null)        
        {
            targetAuthHandler = createTargetAuthenticationHandler();
        } //End block
AuthenticationHandler var14FEB6F269E494F8F61E59AA40ABA915_1426458496 =         targetAuthHandler;
        var14FEB6F269E494F8F61E59AA40ABA915_1426458496.addTaint(taint);
        return var14FEB6F269E494F8F61E59AA40ABA915_1426458496;
        // ---------- Original Method ----------
        //if (targetAuthHandler == null) {
            //targetAuthHandler = createTargetAuthenticationHandler();
        //}
        //return targetAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "3685124053FD269048709264319B81C4", hash_generated_method = "7F19CABE1B8FBFBC290DE1DCC8C0E27B")
    public synchronized void setTargetAuthenticationHandler(
            final AuthenticationHandler targetAuthHandler) {
        this.targetAuthHandler = targetAuthHandler;
        // ---------- Original Method ----------
        //this.targetAuthHandler = targetAuthHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "FE6A31C4BC47B922AE7100411D6D3962", hash_generated_method = "1A482334E2A6D9A7C5AB03CF37E44331")
    public synchronized final AuthenticationHandler getProxyAuthenticationHandler() {
        if(proxyAuthHandler == null)        
        {
            proxyAuthHandler = createProxyAuthenticationHandler();
        } //End block
AuthenticationHandler var9EB5A7EC5E1A637214C662B32FCF2B73_689530338 =         proxyAuthHandler;
        var9EB5A7EC5E1A637214C662B32FCF2B73_689530338.addTaint(taint);
        return var9EB5A7EC5E1A637214C662B32FCF2B73_689530338;
        // ---------- Original Method ----------
        //if (proxyAuthHandler == null) {
            //proxyAuthHandler = createProxyAuthenticationHandler();
        //}
        //return proxyAuthHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "4AA8E7473E47BB58C8F6156C1A703EBB", hash_generated_method = "356451F6A605451A11F8421138DE04CD")
    public synchronized void setProxyAuthenticationHandler(
            final AuthenticationHandler proxyAuthHandler) {
        this.proxyAuthHandler = proxyAuthHandler;
        // ---------- Original Method ----------
        //this.proxyAuthHandler = proxyAuthHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "CED19DC63F5DFF3B80D2B1F10482E892", hash_generated_method = "9780D7EF7A44F24946F073B8E0A641EF")
    public synchronized final CookieStore getCookieStore() {
        if(cookieStore == null)        
        {
            cookieStore = createCookieStore();
        } //End block
CookieStore varEF8955D9725B20580D54DFD94C0772B2_86808192 =         cookieStore;
        varEF8955D9725B20580D54DFD94C0772B2_86808192.addTaint(taint);
        return varEF8955D9725B20580D54DFD94C0772B2_86808192;
        // ---------- Original Method ----------
        //if (cookieStore == null) {
            //cookieStore = createCookieStore();
        //}
        //return cookieStore;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "6E3B852BBCF6A420BC19B0060772D5B7", hash_generated_method = "901644A30539362C37C64ED0E9AD33C4")
    public synchronized void setCookieStore(final CookieStore cookieStore) {
        this.cookieStore = cookieStore;
        // ---------- Original Method ----------
        //this.cookieStore = cookieStore;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "98E8D6F59FD454CB3C7069127AA5844B", hash_generated_method = "BB522908B5549FADE9B71B350A092234")
    public synchronized final CredentialsProvider getCredentialsProvider() {
        if(credsProvider == null)        
        {
            credsProvider = createCredentialsProvider();
        } //End block
CredentialsProvider var8211F985665B1FE67F6F01527CAE769E_1831122548 =         credsProvider;
        var8211F985665B1FE67F6F01527CAE769E_1831122548.addTaint(taint);
        return var8211F985665B1FE67F6F01527CAE769E_1831122548;
        // ---------- Original Method ----------
        //if (credsProvider == null) {
            //credsProvider = createCredentialsProvider();
        //}
        //return credsProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.577 -0400", hash_original_method = "84417141BEDCB871793C7CE856775B85", hash_generated_method = "BA9188757149893D624B8659AF5EAA2C")
    public synchronized void setCredentialsProvider(final CredentialsProvider credsProvider) {
        this.credsProvider = credsProvider;
        // ---------- Original Method ----------
        //this.credsProvider = credsProvider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "70B10D4ECA33F90F2399EBBBDBCB28FD", hash_generated_method = "19D14B712CFEA809BAF73B5E69BDB148")
    public synchronized final HttpRoutePlanner getRoutePlanner() {
        if(this.routePlanner == null)        
        {
            this.routePlanner = createHttpRoutePlanner();
        } //End block
HttpRoutePlanner var2417A831E17E58CB597F83300D761324_1025955725 =         this.routePlanner;
        var2417A831E17E58CB597F83300D761324_1025955725.addTaint(taint);
        return var2417A831E17E58CB597F83300D761324_1025955725;
        // ---------- Original Method ----------
        //if (this.routePlanner == null) {
            //this.routePlanner = createHttpRoutePlanner();
        //}
        //return this.routePlanner;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "3BD66AC4C2DF9FC67B263F6DFA8FD061", hash_generated_method = "FDD7402A6E317D6AFBAF72C7F3C5329F")
    public synchronized void setRoutePlanner(final HttpRoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
        // ---------- Original Method ----------
        //this.routePlanner = routePlanner;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "7975319476225B5506DDD068000CD697", hash_generated_method = "FCF65300360E3CE128EB91192004EC98")
    public synchronized final UserTokenHandler getUserTokenHandler() {
        if(this.userTokenHandler == null)        
        {
            this.userTokenHandler = createUserTokenHandler();
        } //End block
UserTokenHandler varD1124753873EE6AAD5C43849D9B4A3C0_1946165668 =         this.userTokenHandler;
        varD1124753873EE6AAD5C43849D9B4A3C0_1946165668.addTaint(taint);
        return varD1124753873EE6AAD5C43849D9B4A3C0_1946165668;
        // ---------- Original Method ----------
        //if (this.userTokenHandler == null) {
            //this.userTokenHandler = createUserTokenHandler();
        //}
        //return this.userTokenHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "FFF313FCFA52F9BED7C1E5BB0A288A32", hash_generated_method = "2F9250109242DF93749FD0275E8C2401")
    public synchronized void setUserTokenHandler(final UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
        // ---------- Original Method ----------
        //this.userTokenHandler = userTokenHandler;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "A054071B5C703A0BBBB93F177E316F94", hash_generated_method = "6D1E415A2DC2AAD37A7C05849DCFB715")
    protected synchronized final BasicHttpProcessor getHttpProcessor() {
        if(httpProcessor == null)        
        {
            httpProcessor = createHttpProcessor();
        } //End block
BasicHttpProcessor varB9569B978E5F00EB20FE2D57A31757F4_269337330 =         httpProcessor;
        varB9569B978E5F00EB20FE2D57A31757F4_269337330.addTaint(taint);
        return varB9569B978E5F00EB20FE2D57A31757F4_269337330;
        // ---------- Original Method ----------
        //if (httpProcessor == null) {
            //httpProcessor = createHttpProcessor();
        //}
        //return httpProcessor;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "C43412A77AD4A73A401FFD4D6C19DEC0", hash_generated_method = "D8566CB38F44390F2D0885364DABEE2C")
    public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        addTaint(itcp.getTaint());
        getHttpProcessor().addInterceptor(itcp);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "F05A17FD0AC8D9037BF5BD8F186688B0", hash_generated_method = "90698898C4D6899AC9BA6A54B5AC1389")
    public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp, int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
        getHttpProcessor().addInterceptor(itcp, index);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp, index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "42A1BB66B3595540F9652B515180E4CB", hash_generated_method = "049C918FBF80448E59767E9013D34590")
    public synchronized HttpResponseInterceptor getResponseInterceptor(int index) {
        addTaint(index);
HttpResponseInterceptor var14C69ADE76D50A2EFFEE1CF66D37806B_845614648 =         getHttpProcessor().getResponseInterceptor(index);
        var14C69ADE76D50A2EFFEE1CF66D37806B_845614648.addTaint(taint);
        return var14C69ADE76D50A2EFFEE1CF66D37806B_845614648;
        // ---------- Original Method ----------
        //return getHttpProcessor().getResponseInterceptor(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "5AA44E0EBC7669E8C12BB7D18976B6A3", hash_generated_method = "DEEA8CCABCC2E692766B0A4895B82FE0")
    public synchronized int getResponseInterceptorCount() {
        int var8EA0D8340E2D60259BD9861995DDFC00_874691587 = (getHttpProcessor().getResponseInterceptorCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611135161 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_611135161;
        // ---------- Original Method ----------
        //return getHttpProcessor().getResponseInterceptorCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.578 -0400", hash_original_method = "37835CD99974C274F51BA3B209149DC5", hash_generated_method = "5C0A7ECAE42D29CBA9A2D07A634B67C4")
    public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
        // ---------- Original Method ----------
        //getHttpProcessor().clearResponseInterceptors();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "6A5F71CEA46F78E6D39221F9549EADAD", hash_generated_method = "5073B791D706F88105887F05CCA3B9F9")
    public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> clazz) {
        addTaint(clazz.getTaint());
        getHttpProcessor().removeResponseInterceptorByClass(clazz);
        // ---------- Original Method ----------
        //getHttpProcessor().removeResponseInterceptorByClass(clazz);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "EB011C9A439616D653F69491914F8398", hash_generated_method = "DB4E78CE5CA484A1AF5A134C9857F9D1")
    public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp) {
        addTaint(itcp.getTaint());
        getHttpProcessor().addInterceptor(itcp);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "B3E4640F3C062B15218CD2B2F2632BF2", hash_generated_method = "1C3FA71EBEA6C930BC67F5D07C43A0C5")
    public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp, int index) {
        addTaint(index);
        addTaint(itcp.getTaint());
        getHttpProcessor().addInterceptor(itcp, index);
        // ---------- Original Method ----------
        //getHttpProcessor().addInterceptor(itcp, index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "3B8965152373170CD1AE42DF74FC23C9", hash_generated_method = "EA5BF48D8184AD0EADB6B9444D808E8B")
    public synchronized HttpRequestInterceptor getRequestInterceptor(int index) {
        addTaint(index);
HttpRequestInterceptor varBB4763CB0F25016809DFE65E2B809ED2_982709927 =         getHttpProcessor().getRequestInterceptor(index);
        varBB4763CB0F25016809DFE65E2B809ED2_982709927.addTaint(taint);
        return varBB4763CB0F25016809DFE65E2B809ED2_982709927;
        // ---------- Original Method ----------
        //return getHttpProcessor().getRequestInterceptor(index);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "F968E9F4352A234FB330890874D0E8D3", hash_generated_method = "E7F24116416A90D4CF3AA126557B0A1B")
    public synchronized int getRequestInterceptorCount() {
        int var60A5A35335FD81C73D38FB7498882438_1601189923 = (getHttpProcessor().getRequestInterceptorCount());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378444625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378444625;
        // ---------- Original Method ----------
        //return getHttpProcessor().getRequestInterceptorCount();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "71ED0A9BF43B0DB4DD62422FA6127326", hash_generated_method = "284478C231A7ED3EAB636F66A5467B37")
    public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
        // ---------- Original Method ----------
        //getHttpProcessor().clearRequestInterceptors();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "388288F90509812A8D957678B2075EF7", hash_generated_method = "F7FC19E02EA65058F6B3214BA3172E92")
    public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> clazz) {
        addTaint(clazz.getTaint());
        getHttpProcessor().removeRequestInterceptorByClass(clazz);
        // ---------- Original Method ----------
        //getHttpProcessor().removeRequestInterceptorByClass(clazz);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.579 -0400", hash_original_method = "8C5414A352E96D69F8672C617A799B3F", hash_generated_method = "6057D21DFC3306CD36EF15C12DA18855")
    public final HttpResponse execute(HttpUriRequest request) throws IOException, ClientProtocolException {
        addTaint(request.getTaint());
HttpResponse varDD0A9081FBDD6C3CFDDAD9B9C9245845_881557001 =         execute(request, (HttpContext) null);
        varDD0A9081FBDD6C3CFDDAD9B9C9245845_881557001.addTaint(taint);
        return varDD0A9081FBDD6C3CFDDAD9B9C9245845_881557001;
        // ---------- Original Method ----------
        //return execute(request, (HttpContext) null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.580 -0400", hash_original_method = "DFABA59EDA546A2813170916E96DC886", hash_generated_method = "F72773D5557D2D89EE65D1E8D9868DEC")
    public final HttpResponse execute(HttpUriRequest request,
                                      HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varB621FF8F02FC28666D51AFC50ABD65CA_1694127523 = new IllegalArgumentException
                ("Request must not be null.");
            varB621FF8F02FC28666D51AFC50ABD65CA_1694127523.addTaint(taint);
            throw varB621FF8F02FC28666D51AFC50ABD65CA_1694127523;
        } //End block
HttpResponse var25FF3C9AFD9A9A6E6EC782E10702BF8A_452291939 =         execute(determineTarget(request), request, context);
        var25FF3C9AFD9A9A6E6EC782E10702BF8A_452291939.addTaint(taint);
        return var25FF3C9AFD9A9A6E6EC782E10702BF8A_452291939;
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException
                //("Request must not be null.");
        //}
        //return execute(determineTarget(request), request, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.580 -0400", hash_original_method = "D4908515F9C0F07C0BDB783E33343E25", hash_generated_method = "E76B3333FB30D238B00AE4E646428475")
    private HttpHost determineTarget(HttpUriRequest request) {
        addTaint(request.getTaint());
        HttpHost target = null;
        URI requestURI = request.getURI();
        if(requestURI.isAbsolute())        
        {
            target = new HttpHost(
                    requestURI.getHost(),
                    requestURI.getPort(),
                    requestURI.getScheme());
        } //End block
HttpHost varA7DD35DE8EDE4A2FCAF77CE202E687B3_969844382 =         target;
        varA7DD35DE8EDE4A2FCAF77CE202E687B3_969844382.addTaint(taint);
        return varA7DD35DE8EDE4A2FCAF77CE202E687B3_969844382;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.580 -0400", hash_original_method = "7C51BA6300B6898AA66ADB20A5FEE58B", hash_generated_method = "7E20AAB31EE8D225ACAD8AE3F8DB366A")
    public final HttpResponse execute(HttpHost target, HttpRequest request) throws IOException, ClientProtocolException {
        addTaint(request.getTaint());
        addTaint(target.getTaint());
HttpResponse var1E0ADA5609F1551DD904433FC94E0E29_361942657 =         execute(target, request, (HttpContext) null);
        var1E0ADA5609F1551DD904433FC94E0E29_361942657.addTaint(taint);
        return var1E0ADA5609F1551DD904433FC94E0E29_361942657;
        // ---------- Original Method ----------
        //return execute(target, request, (HttpContext) null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.580 -0400", hash_original_method = "831E31825E37427A81D59F1020149460", hash_generated_method = "8A6595D13AB4A18DE477836245493EF5")
    public final HttpResponse execute(HttpHost target, HttpRequest request,
                                      HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
        if(request == null)        
        {
            IllegalArgumentException varB621FF8F02FC28666D51AFC50ABD65CA_542760997 = new IllegalArgumentException
                ("Request must not be null.");
            varB621FF8F02FC28666D51AFC50ABD65CA_542760997.addTaint(taint);
            throw varB621FF8F02FC28666D51AFC50ABD65CA_542760997;
        } //End block
        HttpContext execContext = null;
        RequestDirector director = null;
        synchronized
(this)        {
            HttpContext defaultContext = createHttpContext();
            if(context == null)            
            {
                execContext = defaultContext;
            } //End block
            else
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
HttpResponse var2E70A3D4F5DCEF0F014AD0E6BE779429_1730959618 =             director.execute(target, request, execContext);
            var2E70A3D4F5DCEF0F014AD0E6BE779429_1730959618.addTaint(taint);
            return var2E70A3D4F5DCEF0F014AD0E6BE779429_1730959618;
        } //End block
        catch (HttpException httpException)
        {
            ClientProtocolException varD03F1F94C1B5C290467A22E41113580F_92835100 = new ClientProtocolException(httpException);
            varD03F1F94C1B5C290467A22E41113580F_92835100.addTaint(taint);
            throw varD03F1F94C1B5C290467A22E41113580F_92835100;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.581 -0400", hash_original_method = "005994C3A0F7DC1EFC9539C703B59C31", hash_generated_method = "0E3698A5B8C041EE15402A09E2D7994B")
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
        addTaint(params.getTaint());
        addTaint(stateHandler.getTaint());
        addTaint(proxyAuthHandler.getTaint());
        addTaint(targetAuthHandler.getTaint());
        addTaint(redirectHandler.getTaint());
        addTaint(retryHandler.getTaint());
        addTaint(httpProcessor.getTaint());
        addTaint(rouplan.getTaint());
        addTaint(kastrat.getTaint());
        addTaint(reustrat.getTaint());
        addTaint(conman.getTaint());
        addTaint(requestExec.getTaint());
RequestDirector var43EC8343BC71C69A22184C82FAC1B4D5_1714961297 =         new DefaultRequestDirector(
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
        var43EC8343BC71C69A22184C82FAC1B4D5_1714961297.addTaint(taint);
        return var43EC8343BC71C69A22184C82FAC1B4D5_1714961297;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.581 -0400", hash_original_method = "E499E0F2B2039488538F6EF393E5A555", hash_generated_method = "737430F04D24EC31659A83A140154EE2")
    protected HttpParams determineParams(HttpRequest req) {
        addTaint(req.getTaint());
HttpParams var163DF10A66BA9C232CB9547DD21891E3_1612919744 =         new ClientParamsStack
            (null, getParams(), req.getParams(), null);
        var163DF10A66BA9C232CB9547DD21891E3_1612919744.addTaint(taint);
        return var163DF10A66BA9C232CB9547DD21891E3_1612919744;
        // ---------- Original Method ----------
        //return new ClientParamsStack
            //(null, getParams(), req.getParams(), null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.581 -0400", hash_original_method = "599A71AED7A734F2BBB0329C86D40EA5", hash_generated_method = "18E467C662633262941269A9164038A3")
    public <T> T execute(
            final HttpUriRequest request, 
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T varED3CB22FA083C9F271E3D2665EE7B341_170760856 =         execute(request, responseHandler, null);
        varED3CB22FA083C9F271E3D2665EE7B341_170760856.addTaint(taint);
        return varED3CB22FA083C9F271E3D2665EE7B341_170760856;
        // ---------- Original Method ----------
        //return execute(request, responseHandler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.581 -0400", hash_original_method = "6E13CCC1CB10D4179E4E7AE1A7FF6054", hash_generated_method = "EBE956C32524E75329F55B43D365BFE8")
    public <T> T execute(
            final HttpUriRequest request,
            final ResponseHandler<? extends T> responseHandler, 
            final HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        HttpHost target = determineTarget(request);
T var7F6E56C9A163132ECE3E76F87E689070_1042701820 =         execute(target, request, responseHandler, context);
        var7F6E56C9A163132ECE3E76F87E689070_1042701820.addTaint(taint);
        return var7F6E56C9A163132ECE3E76F87E689070_1042701820;
        // ---------- Original Method ----------
        //HttpHost target = determineTarget(request);
        //return execute(target, request, responseHandler, context);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.601 -0400", hash_original_method = "19C63352B91033068C787AD06D23F86A", hash_generated_method = "905067418FFAED7F323D5BD51C7A857C")
    public <T> T execute(
            final HttpHost target, 
            final HttpRequest request,
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T varA621BC86743DA81920EC9390504093CE_1205114777 =         execute(target, request, responseHandler, null);
        varA621BC86743DA81920EC9390504093CE_1205114777.addTaint(taint);
        return varA621BC86743DA81920EC9390504093CE_1205114777;
        // ---------- Original Method ----------
        //return execute(target, request, responseHandler, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.602 -0400", hash_original_method = "99C065FAB199CDE7300B84D2FBAE687C", hash_generated_method = "60E4C44856B0E550335DA1C5F3B4276E")
    public <T> T execute(
            final HttpHost target, 
            final HttpRequest request,
            final ResponseHandler<? extends T> responseHandler, 
            final HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
        if(responseHandler == null)        
        {
            IllegalArgumentException varC8FA2574296C77CD9B2D78EDCAB5BB02_1093853128 = new IllegalArgumentException
                ("Response handler must not be null.");
            varC8FA2574296C77CD9B2D78EDCAB5BB02_1093853128.addTaint(taint);
            throw varC8FA2574296C77CD9B2D78EDCAB5BB02_1093853128;
        } //End block
        HttpResponse response = execute(target, request, context);
        T result;
        try 
        {
            result = responseHandler.handleResponse(response);
        } //End block
        catch (Throwable t)
        {
            HttpEntity entity = response.getEntity();
            if(entity != null)            
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
            if(t instanceof Error)            
            {
                Error varE4E19808241EF112D2272BA099520A74_703430816 = (Error) t;
                varE4E19808241EF112D2272BA099520A74_703430816.addTaint(taint);
                throw varE4E19808241EF112D2272BA099520A74_703430816;
            } //End block
            if(t instanceof RuntimeException)            
            {
                RuntimeException var240BB82070FA0C18A5C852C3B09D6C1F_711978315 = (RuntimeException) t;
                var240BB82070FA0C18A5C852C3B09D6C1F_711978315.addTaint(taint);
                throw var240BB82070FA0C18A5C852C3B09D6C1F_711978315;
            } //End block
            if(t instanceof IOException)            
            {
                IOException var8E119F6D5DC5E35389CA6F978EE60BCE_1188538174 = (IOException) t;
                var8E119F6D5DC5E35389CA6F978EE60BCE_1188538174.addTaint(taint);
                throw var8E119F6D5DC5E35389CA6F978EE60BCE_1188538174;
            } //End block
            UndeclaredThrowableException varCDADF2F647FF0550CFA2582D55121867_665968188 = new UndeclaredThrowableException(t);
            varCDADF2F647FF0550CFA2582D55121867_665968188.addTaint(taint);
            throw varCDADF2F647FF0550CFA2582D55121867_665968188;
        } //End block
        HttpEntity entity = response.getEntity();
        if(entity != null)        
        {
            entity.consumeContent();
        } //End block
T varDC838461EE2FA0CA4C9BBB70A15456B0_1956414294 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1956414294.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1956414294;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

