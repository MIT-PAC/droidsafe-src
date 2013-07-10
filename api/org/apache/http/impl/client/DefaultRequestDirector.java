package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.conn.BasicManagedEntity;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.routing.BasicRouteDirector;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRouteDirector;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public class DefaultRequestDirector implements RequestDirector {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "02A8F7D7605C029767E3572CFEE2F34C")

    protected ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "16B9BCB9C810B5FB9F1218ABF5433F0A", hash_generated_field = "C85BE630FF179384873F74B45C3D1A5E")

    protected HttpRoutePlanner routePlanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "6841B3DB425CF924E2406CCC3EC7D0C4", hash_generated_field = "D092FC62D0768D92CCEB66662883652A")

    protected ConnectionReuseStrategy reuseStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "06037BBEEBDAD4B9CCEA6123FF7CEF48", hash_generated_field = "CC83794776099E15447E3B95C8DA1298")

    protected ConnectionKeepAliveStrategy keepAliveStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "EBFB9A3D3F58438E791B5FA697F0E019", hash_generated_field = "AE8B5D85021B1C853E8228EC07BB45BD")

    protected HttpRequestExecutor requestExec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "752D4EFA0487789E224C2A1BB7CC684E", hash_generated_field = "BE58AA1EBB61C1DA0052321621920348")

    protected HttpProcessor httpProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "9276D9188CF6BA2DC6A4953C0672BC3D", hash_generated_field = "98BC4E4D2CA69028F19F530E761B7A50")

    protected HttpRequestRetryHandler retryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "F350623671C50CD5233E0DC58B4BC69F", hash_generated_field = "1D6916AFC0FC11340932EC2AB84E4EEA")

    protected RedirectHandler redirectHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "6FA7D1184BC1FAC634576AE3416BC1FC", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "0F58376CC8049DF18F70792E6CDE0CBB", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "7CA4C2AD16B3CB439480B96FCAB580BC", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "EC981A5CB5248DB431EB0C0A85CB6583", hash_generated_field = "D59A8F322AA61B2EDF1BDFFFEB284AB6")

    private int redirectCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "192E8F7D1AC88DB04E4D404EEFE3BA12", hash_generated_field = "C858360B99BF75CE96620A237ADD6C16")

    private int maxRedirects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "42FB65007B91DD7B4C2B4593948697DD", hash_generated_field = "09D81EEE3AA06EF4775316736BFDA2B2")

    private AuthState targetAuthState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.227 -0400", hash_original_field = "BB590229B7E3F737CC2E4575475A1353", hash_generated_field = "04947E0C0D6A7F5789678D91EF5BFD42")

    private AuthState proxyAuthState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.228 -0400", hash_original_method = "0B21A162BE3540982FD94EA0624DFDC2", hash_generated_method = "3B5AB4D8C35110684028394926D618E0")
    public  DefaultRequestDirector(
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
            final UserTokenHandler userTokenHandler,
            final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Request executor may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Client connection manager may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection reuse strategy may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Connection keep alive strategy may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Route planner may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP protocol processor may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP request retry handler may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Redirect handler may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Target authentication handler may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Proxy authentication handler may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("User token handler may not be null.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("HTTP parameters may not be null");
        } 
        this.requestExec       = requestExec;
        this.connManager       = conman;
        this.reuseStrategy     = reustrat;
        this.keepAliveStrategy = kastrat;
        this.routePlanner      = rouplan;
        this.httpProcessor     = httpProcessor;
        this.retryHandler      = retryHandler;
        this.redirectHandler   = redirectHandler;
        this.targetAuthHandler = targetAuthHandler;
        this.proxyAuthHandler  = proxyAuthHandler;
        this.userTokenHandler  = userTokenHandler;
        this.params            = params;
        this.managedConn       = null;
        this.redirectCount = 0;
        this.maxRedirects = this.params.getIntParameter(ClientPNames.MAX_REDIRECTS, 100);
        this.targetAuthState = new AuthState();
        this.proxyAuthState = new AuthState();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.229 -0400", hash_original_method = "61E87BBE33E8E65E80E9F3F1C82F2660", hash_generated_method = "205F08F6535E9FFB28888D704705F021")
    private RequestWrapper wrapRequest(
            final HttpRequest request) throws ProtocolException {
        RequestWrapper varB4EAC82CA7396A68D541C85D26508E83_1323424882 = null; 
        RequestWrapper varB4EAC82CA7396A68D541C85D26508E83_2137951602 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1323424882 = new EntityEnclosingRequestWrapper(
                    (HttpEntityEnclosingRequest) request);
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2137951602 = new RequestWrapper(
                    request);
        } 
        addTaint(request.getTaint());
        RequestWrapper varA7E53CE21691AB073D9660D615818899_519809428; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_519809428 = varB4EAC82CA7396A68D541C85D26508E83_1323424882;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_519809428 = varB4EAC82CA7396A68D541C85D26508E83_2137951602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_519809428.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_519809428;
        
        
            
                    
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.230 -0400", hash_original_method = "6DDB48FED3712857B06BA2C85DA91575", hash_generated_method = "D802E659BDC483781FE83661C785B2E1")
    protected void rewriteRequestURI(
            final RequestWrapper request,
            final HttpRoute route) throws ProtocolException {
        try 
        {
            URI uri = request.getURI();
            {
                boolean var3AA4FF3B949161D68AAF7A4351A382C7_1637398894 = (route.getProxyHost() != null && !route.isTunnelled());
                {
                    {
                        boolean varD11459F3855AF1765B44BF6086B2A245_1908388317 = (!uri.isAbsolute());
                        {
                            HttpHost target = route.getTargetHost();
                            uri = URIUtils.rewriteURI(uri, target);
                            request.setURI(uri);
                        } 
                    } 
                } 
                {
                    {
                        boolean var1CCFF1BB4998DF61105F8536006544AB_853421237 = (uri.isAbsolute());
                        {
                            uri = URIUtils.rewriteURI(uri, null);
                            request.setURI(uri);
                        } 
                    } 
                } 
            } 
        } 
        catch (URISyntaxException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ProtocolException("Invalid URI: " + 
                    request.getRequestLine().getUri(), ex);
        } 
        addTaint(request.getTaint());
        addTaint(route.getTaint());
        
        
            
            
                
                    
                    
                    
                
            
                
                    
                    
                
            
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.234 -0400", hash_original_method = "FF11182248C158BE9943CC5E99D59AB1", hash_generated_method = "966728E61CF3E8A50F0334F6DA974B86")
    public HttpResponse execute(HttpHost target, HttpRequest request,
                                HttpContext context) throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1314383345 = null; 
        HttpRequest orig = request;
        RequestWrapper origWrapper = wrapRequest(orig);
        origWrapper.setParams(params);
        HttpRoute origRoute = determineRoute(target, origWrapper, context);
        RoutedRequest roureq = new RoutedRequest(origWrapper, origRoute);
        long timeout = ConnManagerParams.getTimeout(params);
        int execCount = 0;
        boolean reuse = false;
        HttpResponse response = null;
        boolean done = false;
        try 
        {
            {
                RequestWrapper wrapper = roureq.getRequest();
                HttpRoute route = roureq.getRoute();
                Object userToken = context.getAttribute(ClientContext.USER_TOKEN);
                {
                    ClientConnectionRequest connRequest = connManager.requestConnection(
                            route, userToken);
                    {
                        ((AbortableHttpRequest) orig).setConnectionRequest(connRequest);
                    } 
                    try 
                    {
                        managedConn = connRequest.getConnection(timeout, TimeUnit.MILLISECONDS);
                    } 
                    catch (InterruptedException interrupted)
                    {
                        InterruptedIOException iox = new InterruptedIOException();
                        iox.initCause(interrupted);
                        if (DroidSafeAndroidRuntime.control) throw iox;
                    } 
                    {
                        boolean var5923320BEBC54ED630F34B0E65757066_2007979011 = (HttpConnectionParams.isStaleCheckingEnabled(params));
                        {
                            this.log.debug("Stale connection check");
                            {
                                boolean var2DD7793B43B667C3943BC5E0D5615B97_660554319 = (managedConn.isStale());
                                {
                                    this.log.debug("Stale connection detected");
                                    try 
                                    {
                                        managedConn.close();
                                    } 
                                    catch (IOException ignored)
                                    { }
                                } 
                            } 
                        } 
                    } 
                } 
                {
                    ((AbortableHttpRequest) orig).setReleaseTrigger(managedConn);
                } 
                {
                    boolean var57A1BB929F724922F42032281AF99B55_396664830 = (!managedConn.isOpen());
                    {
                        managedConn.open(route, context, params);
                    } 
                    {
                        managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
                    } 
                } 
                try 
                {
                    establishRoute(route, context);
                } 
                catch (TunnelRefusedException ex)
                {
                    {
                        boolean var1F07AE7CFC0030A6905273861F288C94_327008315 = (this.log.isDebugEnabled());
                        {
                            this.log.debug(ex.getMessage());
                        } 
                    } 
                    response = ex.getResponse();
                } 
                wrapper.resetHeaders();
                rewriteRequestURI(wrapper, route);
                target = (HttpHost) wrapper.getParams().getParameter(
                        ClientPNames.VIRTUAL_HOST);
                {
                    target = route.getTargetHost();
                } 
                HttpHost proxy = route.getProxyHost();
                context.setAttribute(ExecutionContext.HTTP_TARGET_HOST,
                        target);
                context.setAttribute(ExecutionContext.HTTP_PROXY_HOST,
                        proxy);
                context.setAttribute(ExecutionContext.HTTP_CONNECTION,
                        managedConn);
                context.setAttribute(ClientContext.TARGET_AUTH_STATE,
                        targetAuthState);
                context.setAttribute(ClientContext.PROXY_AUTH_STATE,
                        proxyAuthState);
                requestExec.preProcess(wrapper, httpProcessor, context);
                context.setAttribute(ExecutionContext.HTTP_REQUEST,
                        wrapper);
                boolean retrying = true;
                {
                    wrapper.incrementExecCount();
                    {
                        boolean varE2EB083771426CBE4A1AFC7B69AD71ED_2042289384 = (wrapper.getExecCount() > 1 && !wrapper.isRepeatable());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new NonRepeatableRequestException("Cannot retry request " +
                                "with a non-repeatable request entity");
                        } 
                    } 
                    try 
                    {
                        {
                            boolean var77FE74E3FD18153DC8BA47A287E94E9C_1289851959 = (this.log.isDebugEnabled());
                            {
                                this.log.debug("Attempt " + execCount + " to execute request");
                            } 
                        } 
                        response = requestExec.execute(wrapper, managedConn, context);
                        retrying = false;
                    } 
                    catch (IOException ex)
                    {
                        this.log.debug("Closing the connection.");
                        managedConn.close();
                        {
                            boolean var64C3BCAC692FC83F7D401E770FBC72AE_73152641 = (retryHandler.retryRequest(ex, execCount, context));
                            {
                                {
                                    boolean var6C6142ED59A5F61883DA4639369F3712_1451399935 = (this.log.isInfoEnabled());
                                    {
                                        this.log.info("I/O exception ("+ ex.getClass().getName() + 
                                        ") caught when processing request: "
                                        + ex.getMessage());
                                    } 
                                } 
                                {
                                    boolean var3DF9FAF67937974C7A395023CF7157D0_2005150917 = (this.log.isDebugEnabled());
                                    {
                                        this.log.debug(ex.getMessage(), ex);
                                    } 
                                } 
                                this.log.info("Retrying request");
                            } 
                            {
                                if (DroidSafeAndroidRuntime.control) throw ex;
                            } 
                        } 
                        {
                            boolean varB974659626623043E5194C43AFB0E343_276875624 = (route.getHopCount() == 1);
                            {
                                this.log.debug("Reopening the direct connection.");
                                managedConn.open(route, context, params);
                            } 
                            {
                                if (DroidSafeAndroidRuntime.control) throw ex;
                            } 
                        } 
                    } 
                } 
                response.setParams(params);
                requestExec.postProcess(response, httpProcessor, context);
                reuse = reuseStrategy.keepAlive(response, context);
                {
                    long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
                    managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
                } 
                RoutedRequest followup = handleResponse(roureq, response, context);
                {
                    done = true;
                } 
                {
                    {
                        this.log.debug("Connection kept alive");
                        HttpEntity entity = response.getEntity();
                        {
                            entity.consumeContent();
                        } 
                        managedConn.markReusable();
                    } 
                    {
                        managedConn.close();
                    } 
                    {
                        boolean varACB18F1E94F33836161DA99EE30F4796_1614894474 = (!followup.getRoute().equals(roureq.getRoute()));
                        {
                            releaseConnection();
                        } 
                    } 
                    roureq = followup;
                } 
                userToken = this.userTokenHandler.getUserToken(context);
                context.setAttribute(ClientContext.USER_TOKEN, userToken);
                {
                    managedConn.setState(userToken);
                } 
            } 
            {
                boolean var4E1C49B8CE08FFA416DD620F8EF57B0D_1858719000 = ((response == null) || (response.getEntity() == null) ||
                !response.getEntity().isStreaming());
                {
                    managedConn.markReusable();
                    releaseConnection();
                } 
                {
                    HttpEntity entity = response.getEntity();
                    entity = new BasicManagedEntity(entity, managedConn, reuse);
                    response.setEntity(entity);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1314383345 = response;
        } 
        catch (HttpException ex)
        {
            abortConnection();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (IOException ex)
        {
            abortConnection();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        catch (RuntimeException ex)
        {
            abortConnection();
            if (DroidSafeAndroidRuntime.control) throw ex;
        } 
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1314383345.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1314383345;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.234 -0400", hash_original_method = "72FBB2C6656BE4AE3AB40DA6CB70F970", hash_generated_method = "715CF4FA77516E276A6E0260E216C641")
    protected void releaseConnection() {
        try 
        {
            managedConn.releaseConnection();
        } 
        catch (IOException ignored)
        {
            this.log.debug("IOException releasing connection", ignored);
        } 
        managedConn = null;
        
        
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.235 -0400", hash_original_method = "855E342C251EB2356D381DD4230A53C3", hash_generated_method = "C305A885C8E3A3D8CA852D7C7A0D0F24")
    protected HttpRoute determineRoute(HttpHost    target,
                                           HttpRequest request,
                                           HttpContext context) throws HttpException {
        HttpRoute varB4EAC82CA7396A68D541C85D26508E83_2133957786 = null; 
        {
            target = (HttpHost) request.getParams().getParameter(
                ClientPNames.DEFAULT_HOST);
        } 
        {
            String scheme = null;
            String host = null;
            String path = null;
            URI uri = null;
            {
                if(request instanceof HttpUriRequest
                    && (uri = ((HttpUriRequest) request).getURI()) != null)
                {
                    scheme = uri.getScheme();
                    host = uri.getHost();
                    path = uri.getPath();
                } 
            } 
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException( "Target host must not be null, or set in parameters."
                    + " scheme=" + scheme + ", host=" + host + ", path=" + path);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2133957786 = this.routePlanner.determineRoute(target, request, context);
        addTaint(target.getTaint());
        addTaint(request.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2133957786.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2133957786;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.236 -0400", hash_original_method = "7601A49E11EC8C911923D57ABD663D23", hash_generated_method = "42A200EB0B5E9867F4DEC7BEB9C6E6C2")
    protected void establishRoute(HttpRoute route, HttpContext context) throws HttpException, IOException {
        HttpRouteDirector rowdy = new BasicRouteDirector();
        int step;
        {
            HttpRoute fact = managedConn.getRoute();
            step = rowdy.nextStep(route, fact);
            
            managedConn.open(route, context, this.params);
            
            
            {
                boolean secure = createTunnelToTarget(route, context);
                this.log.debug("Tunnel to target created.");
                managedConn.tunnelTarget(secure, this.params);
            } 
            
            
            {
                final int hop = fact.getHopCount()-1;
                boolean secure = createTunnelToProxy(route, hop, context);
                this.log.debug("Tunnel to proxy created.");
                managedConn.tunnelProxy(route.getHopTarget(hop),
                                        secure, this.params);
            } 
            
            
            managedConn.layerProtocol(context, this.params);
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                    ("Unable to establish route." +
                     "\nplanned = " + route +
                     "\ncurrent = " + fact);
            
            
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException
                    ("Unknown step indicator "+step+" from RouteDirector.");
            
        } 
        addTaint(route.getTaint());
        addTaint(context.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.237 -0400", hash_original_method = "135ABB51CD042C7BF2D35A5F6450399E", hash_generated_method = "0B68B0EDFD34142AAB5DFA471FAB41CC")
    protected boolean createTunnelToTarget(HttpRoute route,
                                           HttpContext context) throws HttpException, IOException {
        HttpHost proxy = route.getProxyHost();
        HttpHost target = route.getTargetHost();
        HttpResponse response = null;
        boolean done = false;
        {
            done = true;
            {
                boolean varE24C8D9987FCAD565418104E3ED22290_1161557525 = (!this.managedConn.isOpen());
                {
                    this.managedConn.open(route, context, this.params);
                } 
            } 
            HttpRequest connect = createConnectRequest(route, context);
            String agent = HttpProtocolParams.getUserAgent(params);
            {
                connect.addHeader(HTTP.USER_AGENT, agent);
            } 
            connect.addHeader(HTTP.TARGET_HOST, target.toHostString());
            AuthScheme authScheme = this.proxyAuthState.getAuthScheme();
            AuthScope authScope = this.proxyAuthState.getAuthScope();
            Credentials creds = this.proxyAuthState.getCredentials();
            {
                {
                    boolean var7162080E958C7F1D1FB98D3206150695_1596750433 = (authScope != null || !authScheme.isConnectionBased());
                    {
                        try 
                        {
                            connect.addHeader(authScheme.authenticate(creds, connect));
                        } 
                        catch (AuthenticationException ex)
                        {
                            {
                                boolean var223C02AC5155576C5BF33EBDE2BF71D4_1303459177 = (this.log.isErrorEnabled());
                                {
                                    this.log.error("Proxy authentication error: " + ex.getMessage());
                                } 
                            } 
                        } 
                    } 
                } 
            } 
            response = requestExec.execute(connect, this.managedConn, context);
            int status = response.getStatusLine().getStatusCode();
            {
                if (DroidSafeAndroidRuntime.control) throw new HttpException("Unexpected response to CONNECT request: " +
                        response.getStatusLine());
            } 
            CredentialsProvider credsProvider = (CredentialsProvider)
                context.getAttribute(ClientContext.CREDS_PROVIDER);
            {
                boolean var066E5A2944C8DE608E62F2952F125987_2007062208 = (credsProvider != null && HttpClientParams.isAuthenticating(params));
                {
                    {
                        boolean var820133A86C823DE0CF990CB769500CA4_1623465411 = (this.proxyAuthHandler.isAuthenticationRequested(response, context));
                        {
                            this.log.debug("Proxy requested authentication");
                            Map<String, Header> challenges = this.proxyAuthHandler.getChallenges(
                            response, context);
                            try 
                            {
                                processChallenges(
                                challenges, this.proxyAuthState, this.proxyAuthHandler, 
                                response, context);
                            } 
                            catch (AuthenticationException ex)
                            {
                                {
                                    boolean var98AE6279036784B25F38A97DC5F00031_1290335362 = (this.log.isWarnEnabled());
                                    {
                                        this.log.warn("Authentication error: " +  ex.getMessage());
                                    } 
                                } 
                            } 
                            updateAuthState(this.proxyAuthState, proxy, credsProvider);
                            {
                                boolean varD9595AFA908A709C14DF611A51BAB79F_785177286 = (this.proxyAuthState.getCredentials() != null);
                                {
                                    done = false;
                                    {
                                        boolean varC5EBB71CB69B2B65AACDD488C9350D38_334031577 = (this.reuseStrategy.keepAlive(response, context));
                                        {
                                            this.log.debug("Connection kept alive");
                                            HttpEntity entity = response.getEntity();
                                            {
                                                entity.consumeContent();
                                            } 
                                        } 
                                        {
                                            this.managedConn.close();
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        {
                            this.proxyAuthState.setAuthScope(null);
                        } 
                    } 
                } 
            } 
        } 
        int status = response.getStatusLine().getStatusCode();
        {
            HttpEntity entity = response.getEntity();
            {
                response.setEntity(new BufferedHttpEntity(entity));
            } 
            this.managedConn.close();
            if (DroidSafeAndroidRuntime.control) throw new TunnelRefusedException("CONNECT refused by proxy: " +
                    response.getStatusLine(), response);
        } 
        this.managedConn.markReusable();
        addTaint(route.getTaint());
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_901742936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_901742936;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.238 -0400", hash_original_method = "F6C0B77A6F010BA1F972A9366C7E6CE6", hash_generated_method = "93705B5ABA12007D4DDCB0DB8FE6BE06")
    protected boolean createTunnelToProxy(HttpRoute route, int hop,
                                          HttpContext context) throws HttpException, IOException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException
            ("Proxy chains are not supported.");
        addTaint(route.getTaint());
        addTaint(hop);
        addTaint(context.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_573133852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_573133852;
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.238 -0400", hash_original_method = "7799E26CF8933DA985404F8B4CB5983A", hash_generated_method = "009B6F083714C35D30671F2ED223594A")
    protected HttpRequest createConnectRequest(HttpRoute route,
                                               HttpContext context) {
        HttpRequest varB4EAC82CA7396A68D541C85D26508E83_1512773839 = null; 
        HttpHost target = route.getTargetHost();
        String host = target.getHostName();
        int port = target.getPort();
        {
            Scheme scheme = connManager.getSchemeRegistry().
                getScheme(target.getSchemeName());
            port = scheme.getDefaultPort();
        } 
        StringBuilder buffer = new StringBuilder(host.length() + 6);
        buffer.append(host);
        buffer.append(':');
        buffer.append(Integer.toString(port));
        String authority = buffer.toString();
        ProtocolVersion ver = HttpProtocolParams.getVersion(params);
        HttpRequest req = new BasicHttpRequest
            ("CONNECT", authority, ver);
        varB4EAC82CA7396A68D541C85D26508E83_1512773839 = req;
        addTaint(route.getTaint());
        addTaint(context.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1512773839.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1512773839;
        
        
        
        
        
            
                
            
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.241 -0400", hash_original_method = "E253F133593C4FA5CC62D333761B1C94", hash_generated_method = "D0CAAB061D55044B8DCD332D25DA07B4")
    protected RoutedRequest handleResponse(RoutedRequest roureq,
                                           HttpResponse response,
                                           HttpContext context) throws HttpException, IOException {
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_1913365870 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_1241533478 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_1683021894 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_127553016 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_658981719 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_124839749 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_12412634 = null; 
        RoutedRequest varB4EAC82CA7396A68D541C85D26508E83_369761948 = null; 
        HttpRoute route = roureq.getRoute();
        HttpHost proxy = route.getProxyHost();
        RequestWrapper request = roureq.getRequest();
        HttpParams params = request.getParams();
        {
            boolean var334174C1DFA3E9A13837B792C9A30C33_1514308648 = (HttpClientParams.isRedirecting(params) && 
                this.redirectHandler.isRedirectRequested(response, context));
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new RedirectException("Maximum redirects ("
                        + maxRedirects + ") exceeded");
                } 
                URI uri = this.redirectHandler.getLocationURI(response, context);
                HttpHost newTarget = new HttpHost(
                    uri.getHost(), 
                    uri.getPort(),
                    uri.getScheme());
                HttpGet redirect = new HttpGet(uri);
                HttpRequest orig = request.getOriginal();
                redirect.setHeaders(orig.getAllHeaders());
                RequestWrapper wrapper = new RequestWrapper(redirect);
                wrapper.setParams(params);
                HttpRoute newRoute = determineRoute(newTarget, wrapper, context);
                RoutedRequest newRequest = new RoutedRequest(wrapper, newRoute);
                {
                    boolean varF9D042902FC0F3D680F077033613BA0E_1316243717 = (this.log.isDebugEnabled());
                    {
                        this.log.debug("Redirecting to '" + uri + "' via " + newRoute);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1913365870 = newRequest;
            } 
        } 
        CredentialsProvider credsProvider = (CredentialsProvider)
            context.getAttribute(ClientContext.CREDS_PROVIDER);
        {
            boolean var207C422FFCD9EECE1E08C64BE84723D4_1479902101 = (credsProvider != null && HttpClientParams.isAuthenticating(params));
            {
                {
                    boolean varE240CE312997E004AB6FC1B1453EC91C_1113477029 = (this.targetAuthHandler.isAuthenticationRequested(response, context));
                    {
                        HttpHost target = (HttpHost)
                    context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                        {
                            target = route.getTargetHost();
                        } 
                        this.log.debug("Target requested authentication");
                        Map<String, Header> challenges = this.targetAuthHandler.getChallenges(
                        response, context);
                        try 
                        {
                            processChallenges(challenges, 
                            this.targetAuthState, this.targetAuthHandler,
                            response, context);
                        } 
                        catch (AuthenticationException ex)
                        {
                            {
                                boolean varBCC5345480BEBFF1302623213026F8F0_332149628 = (this.log.isWarnEnabled());
                                {
                                    this.log.warn("Authentication error: " +  ex.getMessage());
                                    varB4EAC82CA7396A68D541C85D26508E83_1241533478 = null;
                                } 
                            } 
                        } 
                        updateAuthState(this.targetAuthState, target, credsProvider);
                        {
                            boolean varCEE5FFFE2D53D6DFBF73746E861AD022_1944906342 = (this.targetAuthState.getCredentials() != null);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1683021894 = roureq;
                            } 
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_127553016 = null;
                            } 
                        } 
                    } 
                    {
                        this.targetAuthState.setAuthScope(null);
                    } 
                } 
                {
                    boolean varC782DE64FF63336D4149D154B1120F13_1609101207 = (this.proxyAuthHandler.isAuthenticationRequested(response, context));
                    {
                        this.log.debug("Proxy requested authentication");
                        Map<String, Header> challenges = this.proxyAuthHandler.getChallenges(
                        response, context);
                        try 
                        {
                            processChallenges(challenges, 
                            this.proxyAuthState, this.proxyAuthHandler, 
                            response, context);
                        } 
                        catch (AuthenticationException ex)
                        {
                            {
                                boolean varBCC5345480BEBFF1302623213026F8F0_1128891006 = (this.log.isWarnEnabled());
                                {
                                    this.log.warn("Authentication error: " +  ex.getMessage());
                                    varB4EAC82CA7396A68D541C85D26508E83_658981719 = null;
                                } 
                            } 
                        } 
                        updateAuthState(this.proxyAuthState, proxy, credsProvider);
                        {
                            boolean var6529B8BD0070542F140B39A735A7433F_327300038 = (this.proxyAuthState.getCredentials() != null);
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_124839749 = roureq;
                            } 
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_12412634 = null;
                            } 
                        } 
                    } 
                    {
                        this.proxyAuthState.setAuthScope(null);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_369761948 = null;
        addTaint(roureq.getTaint());
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        RoutedRequest varA7E53CE21691AB073D9660D615818899_148535817; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_1913365870;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_1241533478;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_1683021894;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_127553016;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_658981719;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_124839749;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_12412634;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_148535817 = varB4EAC82CA7396A68D541C85D26508E83_369761948;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_148535817.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_148535817;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.242 -0400", hash_original_method = "1B42C243E9B570B37B5AA18DF368B31A", hash_generated_method = "0D9336F8D211B5A3FE8873C16343C5D6")
    private void abortConnection() {
        ManagedClientConnection mcc = managedConn;
        {
            managedConn = null;
            try 
            {
                mcc.abortConnection();
            } 
            catch (IOException ex)
            {
                {
                    boolean varF9D042902FC0F3D680F077033613BA0E_88795009 = (this.log.isDebugEnabled());
                    {
                        this.log.debug(ex.getMessage(), ex);
                    } 
                } 
            } 
            try 
            {
                mcc.releaseConnection();
            } 
            catch (IOException ignored)
            {
                this.log.debug("Error releasing connection", ignored);
            } 
        } 
        
        
        
            
            
                
            
                
                    
                
            
            
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.243 -0400", hash_original_method = "582621DB4D93E0412F3CDB3DDE871FB7", hash_generated_method = "20E93DB6EB0CBE10DAE8187CB8DE7161")
    private void processChallenges(
            final Map<String, Header> challenges, 
            final AuthState authState,
            final AuthenticationHandler authHandler,
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException, AuthenticationException {
        AuthScheme authScheme = authState.getAuthScheme();
        {
            authScheme = authHandler.selectScheme(challenges, response, context);
            authState.setAuthScheme(authScheme);
        } 
        String id = authScheme.getSchemeName();
        Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
        {
            if (DroidSafeAndroidRuntime.control) throw new AuthenticationException(id + 
                " authorization challenge expected, but not found");
        } 
        authScheme.processChallenge(challenge);
        this.log.debug("Authorization challenge processed");
        addTaint(challenges.getTaint());
        addTaint(authState.getTaint());
        addTaint(authHandler.getTaint());
        addTaint(response.getTaint());
        addTaint(context.getTaint());
        
        
        
            
            
        
        
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.246 -0400", hash_original_method = "48429FCD8E54925B92F9CF361D5F9B0A", hash_generated_method = "38333ABA5F120848ADADB01C8FF514C0")
    private void updateAuthState(
            final AuthState authState, 
            final HttpHost host,
            final CredentialsProvider credsProvider) {
        {
            boolean varE294CD19057AAD4F26C11D0C7F9699FD_1749758544 = (!authState.isValid());
        } 
        String hostname = host.getHostName();
        int port = host.getPort();
        {
            Scheme scheme = connManager.getSchemeRegistry().getScheme(host);
            port = scheme.getDefaultPort();
        } 
        AuthScheme authScheme = authState.getAuthScheme();
        AuthScope authScope = new AuthScope(
                hostname,
                port,
                authScheme.getRealm(), 
                authScheme.getSchemeName());
        {
            boolean var2083B5DFA3893791124BEF94A917A00D_1866681854 = (this.log.isDebugEnabled());
            {
                this.log.debug("Authentication scope: " + authScope);
            } 
        } 
        Credentials creds = authState.getCredentials();
        {
            creds = credsProvider.getCredentials(authScope);
            {
                boolean var08CB4FDA680E50E69D97D6749FE568F5_1267736865 = (this.log.isDebugEnabled());
                {
                    {
                        this.log.debug("Found credentials");
                    } 
                    {
                        this.log.debug("Credentials not found");
                    } 
                } 
            } 
        } 
        {
            {
                boolean varE472D8780DAACC1D5EBE21FE38AF2EDA_1407316420 = (authScheme.isComplete());
                {
                    this.log.debug("Authentication failed");
                    creds = null;
                } 
            } 
        } 
        authState.setAuthScope(authScope);
        authState.setCredentials(creds);
        addTaint(authState.getTaint());
        addTaint(host.getTaint());
        addTaint(credsProvider.getTaint());
        
        
    }

    
}

