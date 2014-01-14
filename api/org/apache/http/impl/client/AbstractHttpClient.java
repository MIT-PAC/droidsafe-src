package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
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
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.DefaultedHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public abstract class AbstractHttpClient implements HttpClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.963 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.965 -0500", hash_original_field = "862D6AEBA539D9F5C7CFE7CCC992D01E", hash_generated_field = "2B47D5796605ED0337DCB8253B1896C5")

    private HttpParams defaultParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.967 -0500", hash_original_field = "8F281D2DD0CAF0CB49AD825611A30021", hash_generated_field = "4A99276FC1CAC2C29AE58A664804FA18")

    private HttpRequestExecutor requestExec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.969 -0500", hash_original_field = "79C539F0631DE1ED22CABB863DF47A25", hash_generated_field = "B110094B2D9FE8F9DF9475794843EE87")

    private ClientConnectionManager connManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.972 -0500", hash_original_field = "28E659C3D090811B03AB9280351D82C6", hash_generated_field = "53F301D72A057E2DF8B8C939D3D9CD90")

    private ConnectionReuseStrategy reuseStrategy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.974 -0500", hash_original_field = "DC7075B9CA312E5C377DD150B9B7DC40", hash_generated_field = "6B7DB7136FD3BAE521073378AFDD44BF")

    private ConnectionKeepAliveStrategy keepAliveStrategy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.976 -0500", hash_original_field = "A3E9106F2C2FF765AB92B7B7D3496A91", hash_generated_field = "3451161F1CFA2C123C0FE67101143B08")

    private CookieSpecRegistry supportedCookieSpecs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.978 -0500", hash_original_field = "EAC802A6A807F3502161DA967F0F5D05", hash_generated_field = "0CFF0C92AFAE4510CB7819EC35269016")

    private AuthSchemeRegistry supportedAuthSchemes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.980 -0500", hash_original_field = "B4469066035DB4D3B00FAF852EA4B966", hash_generated_field = "9AB2A5083E09B99512C85C1D40618272")

    private BasicHttpProcessor httpProcessor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.982 -0500", hash_original_field = "BE7CB17045E13BE02A346FA0C3A4D12A", hash_generated_field = "30F0E3855973CBC5841163CE464CF151")

    private HttpRequestRetryHandler retryHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.985 -0500", hash_original_field = "C389F7622E181983E4C8376E70EDBD71", hash_generated_field = "E830C98496C1F40082C35296635B7B2E")

    private RedirectHandler redirectHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.987 -0500", hash_original_field = "DBA4951E5E541F8099D40BF93DF5F36F", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.989 -0500", hash_original_field = "5E81B4DA49E5D7964FC77151D6BD375D", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.992 -0500", hash_original_field = "8D3B0C7A936922BA49D690A96E423C83", hash_generated_field = "48EBEC1FDB75AF182113D4070DF327E8")

    private CookieStore cookieStore;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.994 -0500", hash_original_field = "1AAC9263EBE34D6D767CDD626F08F7A4", hash_generated_field = "74F60E181398330BC8F9F57CE3109107")

    private CredentialsProvider credsProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.996 -0500", hash_original_field = "8823E067EE1A73A5A4F8381AD9DE926C", hash_generated_field = "993C3C48EF45D276D4920986CC1A695F")

    private HttpRoutePlanner routePlanner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:40.998 -0500", hash_original_field = "CAE4A7A320983E8C1CCB152CF3DFF728", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    
    // orphaned legacy field
    private HttpRequest request;
    
    // orphaned legacy field
    private HttpHost target;
    
    // orphaned legacy field
    private HttpContext context;

    /**
     * Creates a new HTTP client.
     *
     * @param conman    the connection manager
     * @param params    the parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.001 -0500", hash_original_method = "649332244E1BD2DC633E57F283CE534F", hash_generated_method = "BD3C9C442BE99C6AEEFF9ABA168AE9A4")
    
protected AbstractHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
        defaultParams        = params;
        connManager          = conman;
    } // constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.003 -0500", hash_original_method = "E760643E0AC1959FE5C530A1F121AD2B", hash_generated_method = "E04FB14D09B2B83C24A5F1215E8BD77C")
    
protected abstract HttpParams createHttpParams();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.005 -0500", hash_original_method = "247C3FFFCAC7023358E59BA10D2BB371", hash_generated_method = "EB3219EC02588493DDD4C2031BA5F40C")
    
protected abstract HttpContext createHttpContext();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.008 -0500", hash_original_method = "26CCEF008C8565E7F0C352E1FB780A7F", hash_generated_method = "BA1425CF0534BE3990D6B8224A55320F")
    
protected abstract HttpRequestExecutor createRequestExecutor();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.010 -0500", hash_original_method = "A7E391CA589A0D00A4292862BDE01F03", hash_generated_method = "A79C9D680D4A694C6B6D88F37C3FEC1F")
    
protected abstract ClientConnectionManager createClientConnectionManager();

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.012 -0500", hash_original_method = "ACB698551ADB996E7366690CCB47C0D7", hash_generated_method = "F05A06FB4B3A1D7C2ECAD4A8BE4FA4CD")
    
protected abstract AuthSchemeRegistry createAuthSchemeRegistry();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.014 -0500", hash_original_method = "5548986326F8FAC785B31AC07D54394B", hash_generated_method = "0507F78A6E09472BD6F76098FB9FCC0B")
    
protected abstract CookieSpecRegistry createCookieSpecRegistry();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.017 -0500", hash_original_method = "90801EA4D3DEC4952C41D56CE8D261EC", hash_generated_method = "DEDF079293F22D331B2B8958BA4B0DB1")
    
protected abstract ConnectionReuseStrategy createConnectionReuseStrategy();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.019 -0500", hash_original_method = "99366874123306FD40F8EA59466E70E8", hash_generated_method = "72CE0563C7B88EE3E16C1C209E98D1B0")
    
protected abstract ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.021 -0500", hash_original_method = "30116B8D6918FFE3FE30E6C197D404C5", hash_generated_method = "8EF78F68EBD940E1A4DEC661C437D21B")
    
protected abstract BasicHttpProcessor createHttpProcessor();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.024 -0500", hash_original_method = "6E6917ACB8353A340C276C398A9AD4A1", hash_generated_method = "A1075C32392D151625B5DD9E7B0EC6C9")
    
protected abstract HttpRequestRetryHandler createHttpRequestRetryHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.027 -0500", hash_original_method = "10B1E54D2564A3F0A072B1EF6BC00D8F", hash_generated_method = "B62E16612E9011613B554C84D31AE124")
    
protected abstract RedirectHandler createRedirectHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.029 -0500", hash_original_method = "1F7A00F85F5BD3044B2003CCCA327A49", hash_generated_method = "425F6FF775542C0FD725DDD64B43EF52")
    
protected abstract AuthenticationHandler createTargetAuthenticationHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.031 -0500", hash_original_method = "F5B1BC8740DB48B36E73188C4160F846", hash_generated_method = "FC23B5CBE2D73C5FE5EBE31F727D4BA1")
    
protected abstract AuthenticationHandler createProxyAuthenticationHandler();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.033 -0500", hash_original_method = "4ED4AF9AEDF1106B3CAD1EFFA7CC2C42", hash_generated_method = "C9B82DF3926E5AAEF31112779BA392F7")
    
protected abstract CookieStore createCookieStore();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.035 -0500", hash_original_method = "B2DEF9323612691BA8F3782129F8E85E", hash_generated_method = "98CC829429F62E564CE56E435E1F5AF1")
    
protected abstract CredentialsProvider createCredentialsProvider();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.038 -0500", hash_original_method = "34AF1AC0639FB3072E7D087CDC2B56E0", hash_generated_method = "BF0C741521AA2345954B1689A75A52C2")
    
protected abstract HttpRoutePlanner createHttpRoutePlanner();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.040 -0500", hash_original_method = "A5FC5D70749E52A363FD037ECA7FDB92", hash_generated_method = "8B0812BB2D9445BF5EF7D2987D5685DA")
    
protected abstract UserTokenHandler createUserTokenHandler();
    
    @Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Replaces the parameters.
     * The implementation here does not update parameters of dependent objects.
     *
     * @param params    the new default parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.045 -0500", hash_original_method = "E8FEA16F6836AB209AB35B29A74CFADA", hash_generated_method = "641B56A51F938F4C248E9BD95238E1EE")
    
public synchronized void setParams(HttpParams params) {
        defaultParams = params;
    }
    
    @Override
	public ClientConnectionManager getConnectionManager() {
		// TODO Auto-generated method stub
		return null;
	}

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.050 -0500", hash_original_method = "E135DC176345D99818B1545EC3559BB7", hash_generated_method = "12FA2C9D13042C54DC7ACEFAB72A6410")
    
public synchronized final HttpRequestExecutor getRequestExecutor() {
        if (requestExec == null) {
            requestExec = createRequestExecutor();
        }
        return requestExec;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.052 -0500", hash_original_method = "B64B8CBD2A41A037238B1FA9106B9C55", hash_generated_method = "DE0C0E52202EBF0A019684533A5AF8D0")
    
public synchronized final AuthSchemeRegistry getAuthSchemes() {
        if (supportedAuthSchemes == null) {
            supportedAuthSchemes = createAuthSchemeRegistry();
        }
        return supportedAuthSchemes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.054 -0500", hash_original_method = "B5A5E2A2EE7D2FD2092F96692A5CDFDD", hash_generated_method = "92E68176454138465BE3C2659046BF66")
    
public synchronized void setAuthSchemes(final AuthSchemeRegistry authSchemeRegistry) {
        supportedAuthSchemes = authSchemeRegistry;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.056 -0500", hash_original_method = "13CF1774C0163AC97C4FE09A957F51BE", hash_generated_method = "1F43A612B0062B4AF6DA658DA49B5648")
    
public synchronized final CookieSpecRegistry getCookieSpecs() {
        if (supportedCookieSpecs == null) {
            supportedCookieSpecs = createCookieSpecRegistry();
        }
        return supportedCookieSpecs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.059 -0500", hash_original_method = "ECFE272682DD75F5943282F00E9E7207", hash_generated_method = "D077F9A75EF40E9E20A3DFC2637EC159")
    
public synchronized void setCookieSpecs(final CookieSpecRegistry cookieSpecRegistry) {
        supportedCookieSpecs = cookieSpecRegistry;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.063 -0500", hash_original_method = "280140DA9BF4BB510F1D77AFF1FE6E38", hash_generated_method = "023482637699E150EE17E22E584E16C7")
    
public synchronized final ConnectionReuseStrategy getConnectionReuseStrategy() {
        if (reuseStrategy == null) {
            reuseStrategy = createConnectionReuseStrategy();
        }
        return reuseStrategy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.065 -0500", hash_original_method = "0133833828FCF3626C93AA839CEB0491", hash_generated_method = "6B4D9A10215BDB9BCF9B678733FAE2E9")
    
public synchronized void setReuseStrategy(final ConnectionReuseStrategy reuseStrategy) {
        this.reuseStrategy = reuseStrategy;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.067 -0500", hash_original_method = "0109C95DAAF90D45512D49D44811C1BC", hash_generated_method = "D27F30C4281AB71C25EAC4B28E5A4B47")
    
public synchronized final ConnectionKeepAliveStrategy getConnectionKeepAliveStrategy() {
        if (keepAliveStrategy == null) {
            keepAliveStrategy = createConnectionKeepAliveStrategy();
        }
        return keepAliveStrategy;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.070 -0500", hash_original_method = "D20C58629EEB51CAE85A715149CC7D7C", hash_generated_method = "44177EBBF11727B8030383B31ADB7CA6")
    
public synchronized void setKeepAliveStrategy(final ConnectionKeepAliveStrategy keepAliveStrategy) {
        this.keepAliveStrategy = keepAliveStrategy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.072 -0500", hash_original_method = "EDC64C630F8C9BB9424AE860B2C098D2", hash_generated_method = "4BD62B1DA5735E60D87E570ADAA2CAD0")
    
public synchronized final HttpRequestRetryHandler getHttpRequestRetryHandler() {
        if (retryHandler == null) {
            retryHandler = createHttpRequestRetryHandler();
        }
        return retryHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.074 -0500", hash_original_method = "19552606DD1E479BE8417A8173CF9EA3", hash_generated_method = "8794F1397654AA278D4A3FBF2008A522")
    
public synchronized void setHttpRequestRetryHandler(final HttpRequestRetryHandler retryHandler) {
        this.retryHandler = retryHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.077 -0500", hash_original_method = "33F9D2B028213B54FFCD534F34C4B977", hash_generated_method = "F966672BFC28ACC01AD6E35AD4530584")
    
public synchronized final RedirectHandler getRedirectHandler() {
        if (redirectHandler == null) {
            redirectHandler = createRedirectHandler();
        }
        return redirectHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.079 -0500", hash_original_method = "07A813B5AFD38C75974602ADA745C22B", hash_generated_method = "B130C29869592800C2D18AD48DD53B72")
    
public synchronized void setRedirectHandler(final RedirectHandler redirectHandler) {
        this.redirectHandler = redirectHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.081 -0500", hash_original_method = "DCBE39367A729541D3366A866F88A6B5", hash_generated_method = "85F532D7BDE9D58E86C8C50E31549B75")
    
public synchronized final AuthenticationHandler getTargetAuthenticationHandler() {
        if (targetAuthHandler == null) {
            targetAuthHandler = createTargetAuthenticationHandler();
        }
        return targetAuthHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.084 -0500", hash_original_method = "3685124053FD269048709264319B81C4", hash_generated_method = "F612B26AC5E9C8449C39892CC80A76E4")
    
public synchronized void setTargetAuthenticationHandler(
            final AuthenticationHandler targetAuthHandler) {
        this.targetAuthHandler = targetAuthHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.086 -0500", hash_original_method = "FE6A31C4BC47B922AE7100411D6D3962", hash_generated_method = "43DD12DADE37C132CD496217AFE74A82")
    
public synchronized final AuthenticationHandler getProxyAuthenticationHandler() {
        if (proxyAuthHandler == null) {
            proxyAuthHandler = createProxyAuthenticationHandler();
        }
        return proxyAuthHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.088 -0500", hash_original_method = "4AA8E7473E47BB58C8F6156C1A703EBB", hash_generated_method = "419077050B6BB703D9FE3E0DBDCED2A0")
    
public synchronized void setProxyAuthenticationHandler(
            final AuthenticationHandler proxyAuthHandler) {
        this.proxyAuthHandler = proxyAuthHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.091 -0500", hash_original_method = "CED19DC63F5DFF3B80D2B1F10482E892", hash_generated_method = "A0C40B75230CB05B51D0EA80B4D8BB46")
    
public synchronized final CookieStore getCookieStore() {
        if (cookieStore == null) {
            cookieStore = createCookieStore();
        }
        return cookieStore;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.093 -0500", hash_original_method = "6E3B852BBCF6A420BC19B0060772D5B7", hash_generated_method = "DAFB1AA6B223CE28B5E49821E62C676E")
    
public synchronized void setCookieStore(final CookieStore cookieStore) {
        this.cookieStore = cookieStore;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.096 -0500", hash_original_method = "98E8D6F59FD454CB3C7069127AA5844B", hash_generated_method = "2F6355DE373428EEE930FF676F6316CB")
    
public synchronized final CredentialsProvider getCredentialsProvider() {
        if (credsProvider == null) {
            credsProvider = createCredentialsProvider();
        }
        return credsProvider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.099 -0500", hash_original_method = "84417141BEDCB871793C7CE856775B85", hash_generated_method = "D79D85E211DFF093B5FABD25DE71D293")
    
public synchronized void setCredentialsProvider(final CredentialsProvider credsProvider) {
        this.credsProvider = credsProvider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.101 -0500", hash_original_method = "70B10D4ECA33F90F2399EBBBDBCB28FD", hash_generated_method = "C88CA5FD05E2451A95E192EDFFF22348")
    
public synchronized final HttpRoutePlanner getRoutePlanner() {
        if (this.routePlanner == null) {
            this.routePlanner = createHttpRoutePlanner();
        }
        return this.routePlanner;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.104 -0500", hash_original_method = "3BD66AC4C2DF9FC67B263F6DFA8FD061", hash_generated_method = "A3AFB83AAA785C81095E29F5521E435E")
    
public synchronized void setRoutePlanner(final HttpRoutePlanner routePlanner) {
        this.routePlanner = routePlanner;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.106 -0500", hash_original_method = "7975319476225B5506DDD068000CD697", hash_generated_method = "AA811A03F7A30B4BAECD127E751D6310")
    
public synchronized final UserTokenHandler getUserTokenHandler() {
        if (this.userTokenHandler == null) {
            this.userTokenHandler = createUserTokenHandler();
        }
        return this.userTokenHandler;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.108 -0500", hash_original_method = "FFF313FCFA52F9BED7C1E5BB0A288A32", hash_generated_method = "BE1076F1C3853A02FB4C751CEBD82097")
    
public synchronized void setUserTokenHandler(final UserTokenHandler userTokenHandler) {
        this.userTokenHandler = userTokenHandler;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.111 -0500", hash_original_method = "A054071B5C703A0BBBB93F177E316F94", hash_generated_method = "45F415AA3B5DB732F68EBD30E5F6BFC5")
    
protected synchronized final BasicHttpProcessor getHttpProcessor() {
        if (httpProcessor == null) {
            httpProcessor = createHttpProcessor();
        }
        return httpProcessor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.113 -0500", hash_original_method = "C43412A77AD4A73A401FFD4D6C19DEC0", hash_generated_method = "F4F1FEDCBA812F5213867B845917CBE3")
    
public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.115 -0500", hash_original_method = "F05A17FD0AC8D9037BF5BD8F186688B0", hash_generated_method = "2E70A529D783EF62F22350BA423D104F")
    
public synchronized void addResponseInterceptor(final HttpResponseInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.117 -0500", hash_original_method = "42A1BB66B3595540F9652B515180E4CB", hash_generated_method = "6D041B3ECC91CE3E5229BB73DE3A5412")
    
public synchronized HttpResponseInterceptor getResponseInterceptor(int index) {
        return getHttpProcessor().getResponseInterceptor(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.120 -0500", hash_original_method = "5AA44E0EBC7669E8C12BB7D18976B6A3", hash_generated_method = "54F2A90D75054E8BCE43B996AE9646F6")
    
public synchronized int getResponseInterceptorCount() {
        return getHttpProcessor().getResponseInterceptorCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.122 -0500", hash_original_method = "37835CD99974C274F51BA3B209149DC5", hash_generated_method = "CDC8E674F58A74EAE7010D54004A0BA1")
    
public synchronized void clearResponseInterceptors() {
        getHttpProcessor().clearResponseInterceptors();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.124 -0500", hash_original_method = "6A5F71CEA46F78E6D39221F9549EADAD", hash_generated_method = "4F46614EAAFEEB444095AE4D128D7886")
    
public void removeResponseInterceptorByClass(Class<? extends HttpResponseInterceptor> clazz) {
        getHttpProcessor().removeResponseInterceptorByClass(clazz);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.126 -0500", hash_original_method = "EB011C9A439616D653F69491914F8398", hash_generated_method = "65139BEAA74288A5B5A9FA08EE4D24B2")
    
public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp) {
        getHttpProcessor().addInterceptor(itcp);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.129 -0500", hash_original_method = "B3E4640F3C062B15218CD2B2F2632BF2", hash_generated_method = "7FFBB6757F719B70040FDA88A2B0E9A1")
    
public synchronized void addRequestInterceptor(final HttpRequestInterceptor itcp, int index) {
        getHttpProcessor().addInterceptor(itcp, index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.131 -0500", hash_original_method = "3B8965152373170CD1AE42DF74FC23C9", hash_generated_method = "9FAAE41482B98D1747C5FCA4A2EFD757")
    
public synchronized HttpRequestInterceptor getRequestInterceptor(int index) {
        return getHttpProcessor().getRequestInterceptor(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.133 -0500", hash_original_method = "F968E9F4352A234FB330890874D0E8D3", hash_generated_method = "15A972BE37569D526CFB0817F611FD12")
    
public synchronized int getRequestInterceptorCount() {
        return getHttpProcessor().getRequestInterceptorCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.136 -0500", hash_original_method = "71ED0A9BF43B0DB4DD62422FA6127326", hash_generated_method = "BDA80338491B9C62E1CDBC28B8C56D68")
    
public synchronized void clearRequestInterceptors() {
        getHttpProcessor().clearRequestInterceptors();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.138 -0500", hash_original_method = "388288F90509812A8D957678B2075EF7", hash_generated_method = "E3FB9376BDFFC176F4708694AB9BB0EB")
    
public void removeRequestInterceptorByClass(Class<? extends HttpRequestInterceptor> clazz) {
        getHttpProcessor().removeRequestInterceptorByClass(clazz);
    }

    // non-javadoc, see interface HttpClient
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.140 -0500", hash_original_method = "8C5414A352E96D69F8672C617A799B3F", hash_generated_method = "8579099BD17E76C7F736CB1EA0112BCF")
    
public final HttpResponse execute(HttpUriRequest request)
        throws IOException, ClientProtocolException {

        return execute(request, (HttpContext) null);
    }

    /**
     * Maps to {@link HttpClient#execute(HttpHost,HttpRequest,HttpContext)
     *                           execute(target, request, context)}.
     * The target is determined from the URI of the request.
     *
     * @param request   the request to execute
     * @param context   the request-specific execution context,
     *                  or <code>null</code> to use a default context
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.143 -0500", hash_original_method = "DFABA59EDA546A2813170916E96DC886", hash_generated_method = "57BC04C174DD1EA3921BF968322BD923")
    
public final HttpResponse execute(HttpUriRequest request,
                                      HttpContext context)
        throws IOException, ClientProtocolException {

        if (request == null) {
            throw new IllegalArgumentException
                ("Request must not be null.");
        }

        return execute(determineTarget(request), request, context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.145 -0500", hash_original_method = "D4908515F9C0F07C0BDB783E33343E25", hash_generated_method = "0A81BB37E1E34BCDCA4D80A38D818BFF")
    
private HttpHost determineTarget(HttpUriRequest request) {
        // A null target may be acceptable if there is a default target.
        // Otherwise, the null target is detected in the director.
        HttpHost target = null;

        URI requestURI = request.getURI();
        if (requestURI.isAbsolute()) {
            target = new HttpHost(
                    requestURI.getHost(),
                    requestURI.getPort(),
                    requestURI.getScheme());
        }
        return target;
    }

    // non-javadoc, see interface HttpClient
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.148 -0500", hash_original_method = "7C51BA6300B6898AA66ADB20A5FEE58B", hash_generated_method = "7FE66F54B6C880ACCAD2A8A6C1C24EB0")
    
public final HttpResponse execute(HttpHost target, HttpRequest request)
        throws IOException, ClientProtocolException {

        return execute(target, request, (HttpContext) null);
    }
    
	@Override
	public final HttpResponse execute(HttpHost target, HttpRequest request,
			HttpContext context) throws IOException, ClientProtocolException {
		//DSFIXME - Need to determine if short circuiting this method here
		//          is acceptable modeling.
		this.target = target;
		this.request = request;
		this.context = context;
		addTaint(target.getTaint());
		addTaint(request.getTaint());
		addTaint(context.getTaint());
		
		if (DroidSafeAndroidRuntime.control) {		    
		    ClientProtocolException clientEx = new ClientProtocolException(new HttpException());    
		    clientEx.addTaint(getTaint());
		    throw clientEx;
		}
		
		if (DroidSafeAndroidRuntime.control) {         
            IOException ioEx = new IOException("");
            ioEx.addTaint(getTaint());
            throw ioEx;
        }
		// DSModel - send back a fake response
		return new BasicHttpResponse(null, null, null);
		/*
		if (request == null) {
            throw new IllegalArgumentException
                ("Request must not be null.");
        }
        // a null target may be acceptable, this depends on the route planner
        // a null context is acceptable, default context created below
        HttpContext execContext = null;
        RequestDirector director = null;
        HttpRoutePlanner routePlanner = null;
        ConnectionBackoffStrategy connectionBackoffStrategy = null;
        BackoffManager backoffManager = null;
        // Initialize the request execution context making copies of
        // all shared objects that are potentially threading unsafe.
        synchronized (this) {
            final HttpContext defaultContext = createHttpContext();
            if (context == null) {
                execContext = defaultContext;
            } else {
                execContext = new DefaultedHttpContext(context, defaultContext);
            }
            // Create a director for this request
            director = createClientRequestDirector(
                    getRequestExecutor(),
                    getConnectionManager(),
                    getConnectionReuseStrategy(),
                    getConnectionKeepAliveStrategy(),
                    getRoutePlanner(),
                    getProtocolProcessor(),
                    getHttpRequestRetryHandler(),
                    getRedirectStrategy(),
                    getTargetAuthenticationStrategy(),
                    getProxyAuthenticationStrategy(),
                    getUserTokenHandler(),
                    determineParams(request));
            routePlanner = getRoutePlanner();
            connectionBackoffStrategy = getConnectionBackoffStrategy();
            backoffManager = getBackoffManager();
        }
        try {
            if (connectionBackoffStrategy != null && backoffManager != null) {
                final HttpHost targetForRoute = (target != null) ? target
                        : (HttpHost) determineParams(request).getParameter(
                                ClientPNames.DEFAULT_HOST);
                final HttpRoute route = routePlanner.determineRoute(targetForRoute, request, execContext);
                HttpResponse out;
                try {
                    out = director.execute(target, request, execContext);
                } catch (final RuntimeException re) {
                    if (connectionBackoffStrategy.shouldBackoff(re)) {
                        backoffManager.backOff(route);
                    }
                    throw re;
                } catch (final Exception e) {
                    if (connectionBackoffStrategy.shouldBackoff(e)) {
                        backoffManager.backOff(route);
                    }
                    if (e instanceof HttpException) throw (HttpException)e;
                    if (e instanceof IOException) throw (IOException)e;
                    throw new UndeclaredThrowableException(e);
                }
                if (connectionBackoffStrategy.shouldBackoff(out)) {
                    backoffManager.backOff(route);
                } else {
                    backoffManager.probe(route);
                }
                return out;
            } else {
                return director.execute(target, request, execContext);
            }
        } catch(final HttpException httpException) {
            throw new ClientProtocolException(httpException);
        }
        */
	} // execute
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.153 -0500", hash_original_method = "005994C3A0F7DC1EFC9539C703B59C31", hash_generated_method = "23018EF84379366C8A08AF7C34535D6B")
    
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
        return new DefaultRequestDirector(
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
    }

    /**
     * Obtains parameters for executing a request.
     * The default implementation in this class creates a new
     * {@link ClientParamsStack} from the request parameters
     * and the client parameters.
     * <br/>
     * This method is called by the default implementation of
     * {@link #execute(HttpHost,HttpRequest,HttpContext)}
     * to obtain the parameters for the
     * {@link DefaultRequestDirector}.
     *
     * @param req    the request that will be executed
     *
     * @return  the parameters to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.156 -0500", hash_original_method = "E499E0F2B2039488538F6EF393E5A555", hash_generated_method = "AEB368E62C20ADA9E182FFE35B0CAB05")
    
protected HttpParams determineParams(HttpRequest req) {
        return new ClientParamsStack
            (null, getParams(), req.getParams(), null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.128 -0400", hash_original_method = "599A71AED7A734F2BBB0329C86D40EA5", hash_generated_method = "BDCAB35088727F7F5E56A15D4B4B2103")
    
    public <T> T execute(
            final HttpUriRequest request, 
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
T varED3CB22FA083C9F271E3D2665EE7B341_1684867738 =         execute(request, responseHandler, null);
        varED3CB22FA083C9F271E3D2665EE7B341_1684867738.addTaint(taint);
        return varED3CB22FA083C9F271E3D2665EE7B341_1684867738;
        // ---------- Original Method ----------
        //return execute(request, responseHandler, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.130 -0400", hash_original_method = "6E13CCC1CB10D4179E4E7AE1A7FF6054", hash_generated_method = "E1CBD85E8B397E21B196B7DF6218DABF")
    
    public <T> T execute(
            final HttpUriRequest request,
            final ResponseHandler<? extends T> responseHandler, 
            final HttpContext context) throws IOException, ClientProtocolException {
        addTaint(context.getTaint());
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        HttpHost target = determineTarget(request);
T var7F6E56C9A163132ECE3E76F87E689070_1492548815 =         execute(target, request, responseHandler, context);
        var7F6E56C9A163132ECE3E76F87E689070_1492548815.addTaint(taint);
        return var7F6E56C9A163132ECE3E76F87E689070_1492548815;
        // ---------- Original Method ----------
        //HttpHost target = determineTarget(request);
        //return execute(target, request, responseHandler, context);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.132 -0400", hash_original_method = "19C63352B91033068C787AD06D23F86A", hash_generated_method = "C14A0A7F521044146CBC7F6666D75E9E")
    
    public <T> T execute(
            final HttpHost target, 
            final HttpRequest request,
            final ResponseHandler<? extends T> responseHandler) throws IOException, ClientProtocolException {
        addTaint(responseHandler.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
T varA621BC86743DA81920EC9390504093CE_1888191818 =         execute(target, request, responseHandler, null);
        varA621BC86743DA81920EC9390504093CE_1888191818.addTaint(taint);
        return varA621BC86743DA81920EC9390504093CE_1888191818;
        // ---------- Original Method ----------
        //return execute(target, request, responseHandler, null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.135 -0400", hash_original_method = "99C065FAB199CDE7300B84D2FBAE687C", hash_generated_method = "0A4C2F3A74DB8937E9E4351C24754138")
    
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
            IllegalArgumentException varC8FA2574296C77CD9B2D78EDCAB5BB02_1745085228 = new IllegalArgumentException
                ("Response handler must not be null.");
            varC8FA2574296C77CD9B2D78EDCAB5BB02_1745085228.addTaint(taint);
            throw varC8FA2574296C77CD9B2D78EDCAB5BB02_1745085228;
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
                Error varE4E19808241EF112D2272BA099520A74_528921079 = (Error) t;
                varE4E19808241EF112D2272BA099520A74_528921079.addTaint(taint);
                throw varE4E19808241EF112D2272BA099520A74_528921079;
            } //End block
            if(t instanceof RuntimeException)            
            {
                RuntimeException var240BB82070FA0C18A5C852C3B09D6C1F_123333957 = (RuntimeException) t;
                var240BB82070FA0C18A5C852C3B09D6C1F_123333957.addTaint(taint);
                throw var240BB82070FA0C18A5C852C3B09D6C1F_123333957;
            } //End block
            if(t instanceof IOException)            
            {
                IOException var8E119F6D5DC5E35389CA6F978EE60BCE_886945523 = (IOException) t;
                var8E119F6D5DC5E35389CA6F978EE60BCE_886945523.addTaint(taint);
                throw var8E119F6D5DC5E35389CA6F978EE60BCE_886945523;
            } //End block
            UndeclaredThrowableException varCDADF2F647FF0550CFA2582D55121867_650809770 = new UndeclaredThrowableException(t);
            varCDADF2F647FF0550CFA2582D55121867_650809770.addTaint(taint);
            throw varCDADF2F647FF0550CFA2582D55121867_650809770;
        } //End block
        HttpEntity entity = response.getEntity();
        if(entity != null)        
        {
            entity.consumeContent();
        } //End block
T varDC838461EE2FA0CA4C9BBB70A15456B0_1663788671 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1663788671.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1663788671;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
}

