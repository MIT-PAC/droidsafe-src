package org.apache.http.impl.client;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.557 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.557 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "02A8F7D7605C029767E3572CFEE2F34C")

    protected ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.557 -0400", hash_original_field = "16B9BCB9C810B5FB9F1218ABF5433F0A", hash_generated_field = "C85BE630FF179384873F74B45C3D1A5E")

    protected HttpRoutePlanner routePlanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "6841B3DB425CF924E2406CCC3EC7D0C4", hash_generated_field = "D092FC62D0768D92CCEB66662883652A")

    protected ConnectionReuseStrategy reuseStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "06037BBEEBDAD4B9CCEA6123FF7CEF48", hash_generated_field = "CC83794776099E15447E3B95C8DA1298")

    protected ConnectionKeepAliveStrategy keepAliveStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "EBFB9A3D3F58438E791B5FA697F0E019", hash_generated_field = "AE8B5D85021B1C853E8228EC07BB45BD")

    protected HttpRequestExecutor requestExec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "752D4EFA0487789E224C2A1BB7CC684E", hash_generated_field = "BE58AA1EBB61C1DA0052321621920348")

    protected HttpProcessor httpProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "9276D9188CF6BA2DC6A4953C0672BC3D", hash_generated_field = "98BC4E4D2CA69028F19F530E761B7A50")

    protected HttpRequestRetryHandler retryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "F350623671C50CD5233E0DC58B4BC69F", hash_generated_field = "1D6916AFC0FC11340932EC2AB84E4EEA")

    protected RedirectHandler redirectHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "6FA7D1184BC1FAC634576AE3416BC1FC", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "0F58376CC8049DF18F70792E6CDE0CBB", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.558 -0400", hash_original_field = "7CA4C2AD16B3CB439480B96FCAB580BC", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "EC981A5CB5248DB431EB0C0A85CB6583", hash_generated_field = "D59A8F322AA61B2EDF1BDFFFEB284AB6")

    private int redirectCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "192E8F7D1AC88DB04E4D404EEFE3BA12", hash_generated_field = "C858360B99BF75CE96620A237ADD6C16")

    private int maxRedirects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "42FB65007B91DD7B4C2B4593948697DD", hash_generated_field = "09D81EEE3AA06EF4775316736BFDA2B2")

    private AuthState targetAuthState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.559 -0400", hash_original_field = "BB590229B7E3F737CC2E4575475A1353", hash_generated_field = "04947E0C0D6A7F5789678D91EF5BFD42")

    private AuthState proxyAuthState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.563 -0400", hash_original_method = "0B21A162BE3540982FD94EA0624DFDC2", hash_generated_method = "096943810769ACB26542F920071C518F")
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
    if(requestExec == null)        
        {
            IllegalArgumentException varBD20B6DE94BA160E38D6A19FE620972B_1029766485 = new IllegalArgumentException
                ("Request executor may not be null.");
            varBD20B6DE94BA160E38D6A19FE620972B_1029766485.addTaint(taint);
            throw varBD20B6DE94BA160E38D6A19FE620972B_1029766485;
        } 
    if(conman == null)        
        {
            IllegalArgumentException var2CAE72D222E2018F21A500BBB781366A_742317391 = new IllegalArgumentException
                ("Client connection manager may not be null.");
            var2CAE72D222E2018F21A500BBB781366A_742317391.addTaint(taint);
            throw var2CAE72D222E2018F21A500BBB781366A_742317391;
        } 
    if(reustrat == null)        
        {
            IllegalArgumentException varAC1BE54E06BD0BF73EC95A07797E6CC6_1150482775 = new IllegalArgumentException
                ("Connection reuse strategy may not be null.");
            varAC1BE54E06BD0BF73EC95A07797E6CC6_1150482775.addTaint(taint);
            throw varAC1BE54E06BD0BF73EC95A07797E6CC6_1150482775;
        } 
    if(kastrat == null)        
        {
            IllegalArgumentException var5D18D55E95DEDD7525CEB1D5D4EDA5AE_1892767636 = new IllegalArgumentException
                ("Connection keep alive strategy may not be null.");
            var5D18D55E95DEDD7525CEB1D5D4EDA5AE_1892767636.addTaint(taint);
            throw var5D18D55E95DEDD7525CEB1D5D4EDA5AE_1892767636;
        } 
    if(rouplan == null)        
        {
            IllegalArgumentException var61450AC721478F07064D5CA3DC87688F_1531502023 = new IllegalArgumentException
                ("Route planner may not be null.");
            var61450AC721478F07064D5CA3DC87688F_1531502023.addTaint(taint);
            throw var61450AC721478F07064D5CA3DC87688F_1531502023;
        } 
    if(httpProcessor == null)        
        {
            IllegalArgumentException var483355B68B755FD92D77FBBC0550B939_1004057664 = new IllegalArgumentException
                ("HTTP protocol processor may not be null.");
            var483355B68B755FD92D77FBBC0550B939_1004057664.addTaint(taint);
            throw var483355B68B755FD92D77FBBC0550B939_1004057664;
        } 
    if(retryHandler == null)        
        {
            IllegalArgumentException varC2CE5DC5C328BB16435F5ED993581E10_1565240985 = new IllegalArgumentException
                ("HTTP request retry handler may not be null.");
            varC2CE5DC5C328BB16435F5ED993581E10_1565240985.addTaint(taint);
            throw varC2CE5DC5C328BB16435F5ED993581E10_1565240985;
        } 
    if(redirectHandler == null)        
        {
            IllegalArgumentException varBF23C9695C0C4964C86566E857075907_1904598945 = new IllegalArgumentException
                ("Redirect handler may not be null.");
            varBF23C9695C0C4964C86566E857075907_1904598945.addTaint(taint);
            throw varBF23C9695C0C4964C86566E857075907_1904598945;
        } 
    if(targetAuthHandler == null)        
        {
            IllegalArgumentException varC21C33DC73C90A72F11A21040411F90C_1154680514 = new IllegalArgumentException
                ("Target authentication handler may not be null.");
            varC21C33DC73C90A72F11A21040411F90C_1154680514.addTaint(taint);
            throw varC21C33DC73C90A72F11A21040411F90C_1154680514;
        } 
    if(proxyAuthHandler == null)        
        {
            IllegalArgumentException var891BA88640E4B3379FCF2CCC866D25AF_1235854368 = new IllegalArgumentException
                ("Proxy authentication handler may not be null.");
            var891BA88640E4B3379FCF2CCC866D25AF_1235854368.addTaint(taint);
            throw var891BA88640E4B3379FCF2CCC866D25AF_1235854368;
        } 
    if(userTokenHandler == null)        
        {
            IllegalArgumentException var9380208749C6633F93F784E902C07784_1974417764 = new IllegalArgumentException
                ("User token handler may not be null.");
            var9380208749C6633F93F784E902C07784_1974417764.addTaint(taint);
            throw var9380208749C6633F93F784E902C07784_1974417764;
        } 
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1715034259 = new IllegalArgumentException
                ("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1715034259.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1715034259;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.564 -0400", hash_original_method = "61E87BBE33E8E65E80E9F3F1C82F2660", hash_generated_method = "28F5B910DBB19B6CFBACC86A149EF196")
    private RequestWrapper wrapRequest(
            final HttpRequest request) throws ProtocolException {
        addTaint(request.getTaint());
    if(request instanceof HttpEntityEnclosingRequest)        
        {
RequestWrapper var0C4280835D14C11473AAA56C205C196E_984761044 =             new EntityEnclosingRequestWrapper(
                    (HttpEntityEnclosingRequest) request);
            var0C4280835D14C11473AAA56C205C196E_984761044.addTaint(taint);
            return var0C4280835D14C11473AAA56C205C196E_984761044;
        } 
        else
        {
RequestWrapper varECE469D25B56B0BCEBCCBF137D95445B_672521706 =             new RequestWrapper(
                    request);
            varECE469D25B56B0BCEBCCBF137D95445B_672521706.addTaint(taint);
            return varECE469D25B56B0BCEBCCBF137D95445B_672521706;
        } 
        
        
            
                    
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.565 -0400", hash_original_method = "6DDB48FED3712857B06BA2C85DA91575", hash_generated_method = "C97BAA4DC04433FCF71759B9B9DE90A9")
    protected void rewriteRequestURI(
            final RequestWrapper request,
            final HttpRoute route) throws ProtocolException {
        addTaint(route.getTaint());
        addTaint(request.getTaint());
        try 
        {
            URI uri = request.getURI();
    if(route.getProxyHost() != null && !route.isTunnelled())            
            {
    if(!uri.isAbsolute())                
                {
                    HttpHost target = route.getTargetHost();
                    uri = URIUtils.rewriteURI(uri, target);
                    request.setURI(uri);
                } 
            } 
            else
            {
    if(uri.isAbsolute())                
                {
                    uri = URIUtils.rewriteURI(uri, null);
                    request.setURI(uri);
                } 
            } 
        } 
        catch (URISyntaxException ex)
        {
            ProtocolException var7A0C22AEC7611C0CB0FD9196AE88644C_420372476 = new ProtocolException("Invalid URI: " + 
                    request.getRequestLine().getUri(), ex);
            var7A0C22AEC7611C0CB0FD9196AE88644C_420372476.addTaint(taint);
            throw var7A0C22AEC7611C0CB0FD9196AE88644C_420372476;
        } 
        
        
            
            
                
                    
                    
                    
                
            
                
                    
                    
                
            
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.571 -0400", hash_original_method = "FF11182248C158BE9943CC5E99D59AB1", hash_generated_method = "FE1BEF88AED28345536E7781E9E3BE0B")
    public HttpResponse execute(HttpHost target, HttpRequest request,
                                HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
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
            while
(!done)            
            {
                RequestWrapper wrapper = roureq.getRequest();
                HttpRoute route = roureq.getRoute();
                Object userToken = context.getAttribute(ClientContext.USER_TOKEN);
    if(managedConn == null)                
                {
                    ClientConnectionRequest connRequest = connManager.requestConnection(
                            route, userToken);
    if(orig instanceof AbortableHttpRequest)                    
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
                        iox.addTaint(taint);
                        throw iox;
                    } 
    if(HttpConnectionParams.isStaleCheckingEnabled(params))                    
                    {
                        this.log.debug("Stale connection check");
    if(managedConn.isStale())                        
                        {
                            this.log.debug("Stale connection detected");
                            try 
                            {
                                managedConn.close();
                            } 
                            catch (IOException ignored)
                            {
                            } 
                        } 
                    } 
                } 
    if(orig instanceof AbortableHttpRequest)                
                {
                    ((AbortableHttpRequest) orig).setReleaseTrigger(managedConn);
                } 
    if(!managedConn.isOpen())                
                {
                    managedConn.open(route, context, params);
                } 
                else
                {
                    managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
                } 
                try 
                {
                    establishRoute(route, context);
                } 
                catch (TunnelRefusedException ex)
                {
    if(this.log.isDebugEnabled())                    
                    {
                        this.log.debug(ex.getMessage());
                    } 
                    response = ex.getResponse();
                    break;
                } 
                wrapper.resetHeaders();
                rewriteRequestURI(wrapper, route);
                target = (HttpHost) wrapper.getParams().getParameter(
                        ClientPNames.VIRTUAL_HOST);
    if(target == null)                
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
                while
(retrying)                
                {
                    execCount++;
                    wrapper.incrementExecCount();
    if(wrapper.getExecCount() > 1 && !wrapper.isRepeatable())                    
                    {
                        NonRepeatableRequestException varBE8956FD29594D8614365E775C241D18_1874411820 = new NonRepeatableRequestException("Cannot retry request " +
                                "with a non-repeatable request entity");
                        varBE8956FD29594D8614365E775C241D18_1874411820.addTaint(taint);
                        throw varBE8956FD29594D8614365E775C241D18_1874411820;
                    } 
                    try 
                    {
    if(this.log.isDebugEnabled())                        
                        {
                            this.log.debug("Attempt " + execCount + " to execute request");
                        } 
                        response = requestExec.execute(wrapper, managedConn, context);
                        retrying = false;
                    } 
                    catch (IOException ex)
                    {
                        this.log.debug("Closing the connection.");
                        managedConn.close();
    if(retryHandler.retryRequest(ex, execCount, context))                        
                        {
    if(this.log.isInfoEnabled())                            
                            {
                                this.log.info("I/O exception ("+ ex.getClass().getName() + 
                                        ") caught when processing request: "
                                        + ex.getMessage());
                            } 
    if(this.log.isDebugEnabled())                            
                            {
                                this.log.debug(ex.getMessage(), ex);
                            } 
                            this.log.info("Retrying request");
                        } 
                        else
                        {
                            ex.addTaint(taint);
                            throw ex;
                        } 
    if(route.getHopCount() == 1)                        
                        {
                            this.log.debug("Reopening the direct connection.");
                            managedConn.open(route, context, params);
                        } 
                        else
                        {
                            ex.addTaint(taint);
                            throw ex;
                        } 
                    } 
                } 
                response.setParams(params);
                requestExec.postProcess(response, httpProcessor, context);
                reuse = reuseStrategy.keepAlive(response, context);
    if(reuse)                
                {
                    long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
                    managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
                } 
                RoutedRequest followup = handleResponse(roureq, response, context);
    if(followup == null)                
                {
                    done = true;
                } 
                else
                {
    if(reuse)                    
                    {
                        this.log.debug("Connection kept alive");
                        HttpEntity entity = response.getEntity();
    if(entity != null)                        
                        {
                            entity.consumeContent();
                        } 
                        managedConn.markReusable();
                    } 
                    else
                    {
                        managedConn.close();
                    } 
    if(!followup.getRoute().equals(roureq.getRoute()))                    
                    {
                        releaseConnection();
                    } 
                    roureq = followup;
                } 
                userToken = this.userTokenHandler.getUserToken(context);
                context.setAttribute(ClientContext.USER_TOKEN, userToken);
    if(managedConn != null)                
                {
                    managedConn.setState(userToken);
                } 
            } 
    if((response == null) || (response.getEntity() == null) ||
                !response.getEntity().isStreaming())            
            {
    if(reuse)                
                managedConn.markReusable();
                releaseConnection();
            } 
            else
            {
                HttpEntity entity = response.getEntity();
                entity = new BasicManagedEntity(entity, managedConn, reuse);
                response.setEntity(entity);
            } 
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_103948176 =             response;
            var2A1114F4272D753FE23A36E3D68CD293_103948176.addTaint(taint);
            return var2A1114F4272D753FE23A36E3D68CD293_103948176;
        } 
        catch (HttpException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } 
        catch (IOException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } 
        catch (RuntimeException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.574 -0400", hash_original_method = "72FBB2C6656BE4AE3AB40DA6CB70F970", hash_generated_method = "715CF4FA77516E276A6E0260E216C641")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.575 -0400", hash_original_method = "855E342C251EB2356D381DD4230A53C3", hash_generated_method = "883B187E66FD896B25D0281114CC5944")
    protected HttpRoute determineRoute(HttpHost    target,
                                           HttpRequest request,
                                           HttpContext context) throws HttpException {
        addTaint(context.getTaint());
        addTaint(request.getTaint());
        addTaint(target.getTaint());
    if(target == null)        
        {
            target = (HttpHost) request.getParams().getParameter(
                ClientPNames.DEFAULT_HOST);
        } 
    if(target == null)        
        {
            String scheme = null;
            String host = null;
            String path = null;
            URI uri;
    if(request instanceof HttpUriRequest
                    && (uri = ((HttpUriRequest) request).getURI()) != null)            
            {
                scheme = uri.getScheme();
                host = uri.getHost();
                path = uri.getPath();
            } 
            IllegalStateException var7A13D68460776BAB9F175883D2724744_892155137 = new IllegalStateException( "Target host must not be null, or set in parameters."
                    + " scheme=" + scheme + ", host=" + host + ", path=" + path);
            var7A13D68460776BAB9F175883D2724744_892155137.addTaint(taint);
            throw var7A13D68460776BAB9F175883D2724744_892155137;
        } 
HttpRoute var18D2C66D78254B27FEC5244CEBAE6575_851747941 =         this.routePlanner.determineRoute(target, request, context);
        var18D2C66D78254B27FEC5244CEBAE6575_851747941.addTaint(taint);
        return var18D2C66D78254B27FEC5244CEBAE6575_851747941;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.576 -0400", hash_original_method = "7601A49E11EC8C911923D57ABD663D23", hash_generated_method = "7778BC571DE93B6055796428AF0F67A7")
    protected void establishRoute(HttpRoute route, HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(route.getTaint());
        HttpRouteDirector rowdy = new BasicRouteDirector();
        int step;
        do {
            {
                HttpRoute fact = managedConn.getRoute();
                step = rowdy.nextStep(route, fact);
switch(step){
                case HttpRouteDirector.CONNECT_TARGET:
                case HttpRouteDirector.CONNECT_PROXY:
                managedConn.open(route, context, this.params);
                break;
                case HttpRouteDirector.TUNNEL_TARGET:
                {
                    boolean secure = createTunnelToTarget(route, context);
                    this.log.debug("Tunnel to target created.");
                    managedConn.tunnelTarget(secure, this.params);
                } 
                break;
                case HttpRouteDirector.TUNNEL_PROXY:
                {
                    final int hop = fact.getHopCount()-1;
                    boolean secure = createTunnelToProxy(route, hop, context);
                    this.log.debug("Tunnel to proxy created.");
                    managedConn.tunnelProxy(route.getHopTarget(hop),
                                        secure, this.params);
                } 
                break;
                case HttpRouteDirector.LAYER_PROTOCOL:
                managedConn.layerProtocol(context, this.params);
                break;
                case HttpRouteDirector.UNREACHABLE:
                IllegalStateException var41E4D464A14C97E1EC762FC59C493EE0_194936432 = new IllegalStateException
                    ("Unable to establish route." +
                     "\nplanned = " + route +
                     "\ncurrent = " + fact);
                var41E4D464A14C97E1EC762FC59C493EE0_194936432.addTaint(taint);
                throw var41E4D464A14C97E1EC762FC59C493EE0_194936432;
                case HttpRouteDirector.COMPLETE:
                break;
                default:
                IllegalStateException var8F4BA28D8DE40A5BAB04A0DC81D7EB48_462704108 = new IllegalStateException
                    ("Unknown step indicator "+step+" from RouteDirector.");
                var8F4BA28D8DE40A5BAB04A0DC81D7EB48_462704108.addTaint(taint);
                throw var8F4BA28D8DE40A5BAB04A0DC81D7EB48_462704108;
}
            } 
} while (step > HttpRouteDirector.COMPLETE);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.577 -0400", hash_original_method = "135ABB51CD042C7BF2D35A5F6450399E", hash_generated_method = "7040B1D126FDBA464A78346367383CE5")
    protected boolean createTunnelToTarget(HttpRoute route,
                                           HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(route.getTaint());
        HttpHost proxy = route.getProxyHost();
        HttpHost target = route.getTargetHost();
        HttpResponse response = null;
        boolean done = false;
        while
(!done)        
        {
            done = true;
    if(!this.managedConn.isOpen())            
            {
                this.managedConn.open(route, context, this.params);
            } 
            HttpRequest connect = createConnectRequest(route, context);
            String agent = HttpProtocolParams.getUserAgent(params);
    if(agent != null)            
            {
                connect.addHeader(HTTP.USER_AGENT, agent);
            } 
            connect.addHeader(HTTP.TARGET_HOST, target.toHostString());
            AuthScheme authScheme = this.proxyAuthState.getAuthScheme();
            AuthScope authScope = this.proxyAuthState.getAuthScope();
            Credentials creds = this.proxyAuthState.getCredentials();
    if(creds != null)            
            {
    if(authScope != null || !authScheme.isConnectionBased())                
                {
                    try 
                    {
                        connect.addHeader(authScheme.authenticate(creds, connect));
                    } 
                    catch (AuthenticationException ex)
                    {
    if(this.log.isErrorEnabled())                        
                        {
                            this.log.error("Proxy authentication error: " + ex.getMessage());
                        } 
                    } 
                } 
            } 
            response = requestExec.execute(connect, this.managedConn, context);
            int status = response.getStatusLine().getStatusCode();
    if(status < 200)            
            {
                HttpException varD3EF24224D53CFEC9101DECAEC6951EE_1499102339 = new HttpException("Unexpected response to CONNECT request: " +
                        response.getStatusLine());
                varD3EF24224D53CFEC9101DECAEC6951EE_1499102339.addTaint(taint);
                throw varD3EF24224D53CFEC9101DECAEC6951EE_1499102339;
            } 
            CredentialsProvider credsProvider = (CredentialsProvider)
                context.getAttribute(ClientContext.CREDS_PROVIDER);
    if(credsProvider != null && HttpClientParams.isAuthenticating(params))            
            {
    if(this.proxyAuthHandler.isAuthenticationRequested(response, context))                
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
    if(this.log.isWarnEnabled())                        
                        {
                            this.log.warn("Authentication error: " +  ex.getMessage());
                            break;
                        } 
                    } 
                    updateAuthState(this.proxyAuthState, proxy, credsProvider);
    if(this.proxyAuthState.getCredentials() != null)                    
                    {
                        done = false;
    if(this.reuseStrategy.keepAlive(response, context))                        
                        {
                            this.log.debug("Connection kept alive");
                            HttpEntity entity = response.getEntity();
    if(entity != null)                            
                            {
                                entity.consumeContent();
                            } 
                        } 
                        else
                        {
                            this.managedConn.close();
                        } 
                    } 
                } 
                else
                {
                    this.proxyAuthState.setAuthScope(null);
                } 
            } 
        } 
        int status = response.getStatusLine().getStatusCode();
    if(status > 299)        
        {
            HttpEntity entity = response.getEntity();
    if(entity != null)            
            {
                response.setEntity(new BufferedHttpEntity(entity));
            } 
            this.managedConn.close();
            TunnelRefusedException varB63C984E4D7FCF92F245BAD42F4DFE6F_2009781547 = new TunnelRefusedException("CONNECT refused by proxy: " +
                    response.getStatusLine(), response);
            varB63C984E4D7FCF92F245BAD42F4DFE6F_2009781547.addTaint(taint);
            throw varB63C984E4D7FCF92F245BAD42F4DFE6F_2009781547;
        } 
        this.managedConn.markReusable();
        boolean var68934A3E9455FA72420237EB05902327_478251624 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_662084211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_662084211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.578 -0400", hash_original_method = "F6C0B77A6F010BA1F972A9366C7E6CE6", hash_generated_method = "AD66814FEBD5B0AEC5FA89E4EF7C870D")
    protected boolean createTunnelToProxy(HttpRoute route, int hop,
                                          HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(hop);
        addTaint(route.getTaint());
        UnsupportedOperationException varFE02595BC82A88C5229C259936D54501_1258151244 = new UnsupportedOperationException
            ("Proxy chains are not supported.");
        varFE02595BC82A88C5229C259936D54501_1258151244.addTaint(taint);
        throw varFE02595BC82A88C5229C259936D54501_1258151244;
        
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.579 -0400", hash_original_method = "7799E26CF8933DA985404F8B4CB5983A", hash_generated_method = "360C1AE122936D8DB12DA5A278295387")
    protected HttpRequest createConnectRequest(HttpRoute route,
                                               HttpContext context) {
        addTaint(context.getTaint());
        addTaint(route.getTaint());
        HttpHost target = route.getTargetHost();
        String host = target.getHostName();
        int port = target.getPort();
    if(port < 0)        
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
HttpRequest var71AC1B13807E2EDC246A42B3DB2D8EEA_995642604 =         req;
        var71AC1B13807E2EDC246A42B3DB2D8EEA_995642604.addTaint(taint);
        return var71AC1B13807E2EDC246A42B3DB2D8EEA_995642604;
        
        
        
        
        
            
                
            
        
        
        
        
        
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.580 -0400", hash_original_method = "E253F133593C4FA5CC62D333761B1C94", hash_generated_method = "7FA0FCFC26E5C629064BE710D1C2E071")
    protected RoutedRequest handleResponse(RoutedRequest roureq,
                                           HttpResponse response,
                                           HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        addTaint(roureq.getTaint());
        HttpRoute route = roureq.getRoute();
        HttpHost proxy = route.getProxyHost();
        RequestWrapper request = roureq.getRequest();
        HttpParams params = request.getParams();
    if(HttpClientParams.isRedirecting(params) && 
                this.redirectHandler.isRedirectRequested(response, context))        
        {
    if(redirectCount >= maxRedirects)            
            {
                RedirectException var29BC0BAED8BB7987E47C0BA80AF93FBD_995361898 = new RedirectException("Maximum redirects ("
                        + maxRedirects + ") exceeded");
                var29BC0BAED8BB7987E47C0BA80AF93FBD_995361898.addTaint(taint);
                throw var29BC0BAED8BB7987E47C0BA80AF93FBD_995361898;
            } 
            redirectCount++;
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
    if(this.log.isDebugEnabled())            
            {
                this.log.debug("Redirecting to '" + uri + "' via " + newRoute);
            } 
RoutedRequest var843B90BB67BB5454D25E3643EF8010AB_1097409195 =             newRequest;
            var843B90BB67BB5454D25E3643EF8010AB_1097409195.addTaint(taint);
            return var843B90BB67BB5454D25E3643EF8010AB_1097409195;
        } 
        CredentialsProvider credsProvider = (CredentialsProvider)
            context.getAttribute(ClientContext.CREDS_PROVIDER);
    if(credsProvider != null && HttpClientParams.isAuthenticating(params))        
        {
    if(this.targetAuthHandler.isAuthenticationRequested(response, context))            
            {
                HttpHost target = (HttpHost)
                    context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
    if(target == null)                
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
    if(this.log.isWarnEnabled())                    
                    {
                        this.log.warn("Authentication error: " +  ex.getMessage());
RoutedRequest var540C13E9E156B687226421B24F2DF178_1818401167 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1818401167.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1818401167;
                    } 
                } 
                updateAuthState(this.targetAuthState, target, credsProvider);
    if(this.targetAuthState.getCredentials() != null)                
                {
RoutedRequest var6648910846287553B78C1318790BB204_1514966201 =                     roureq;
                    var6648910846287553B78C1318790BB204_1514966201.addTaint(taint);
                    return var6648910846287553B78C1318790BB204_1514966201;
                } 
                else
                {
RoutedRequest var540C13E9E156B687226421B24F2DF178_885521346 =                     null;
                    var540C13E9E156B687226421B24F2DF178_885521346.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_885521346;
                } 
            } 
            else
            {
                this.targetAuthState.setAuthScope(null);
            } 
    if(this.proxyAuthHandler.isAuthenticationRequested(response, context))            
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
    if(this.log.isWarnEnabled())                    
                    {
                        this.log.warn("Authentication error: " +  ex.getMessage());
RoutedRequest var540C13E9E156B687226421B24F2DF178_499636949 =                         null;
                        var540C13E9E156B687226421B24F2DF178_499636949.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_499636949;
                    } 
                } 
                updateAuthState(this.proxyAuthState, proxy, credsProvider);
    if(this.proxyAuthState.getCredentials() != null)                
                {
RoutedRequest var6648910846287553B78C1318790BB204_1912328467 =                     roureq;
                    var6648910846287553B78C1318790BB204_1912328467.addTaint(taint);
                    return var6648910846287553B78C1318790BB204_1912328467;
                } 
                else
                {
RoutedRequest var540C13E9E156B687226421B24F2DF178_270893367 =                     null;
                    var540C13E9E156B687226421B24F2DF178_270893367.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_270893367;
                } 
            } 
            else
            {
                this.proxyAuthState.setAuthScope(null);
            } 
        } 
RoutedRequest var540C13E9E156B687226421B24F2DF178_1682691471 =         null;
        var540C13E9E156B687226421B24F2DF178_1682691471.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1682691471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.582 -0400", hash_original_method = "1B42C243E9B570B37B5AA18DF368B31A", hash_generated_method = "17198A02B2E5C37081B5A7BE5C174595")
    private void abortConnection() {
        ManagedClientConnection mcc = managedConn;
    if(mcc != null)        
        {
            managedConn = null;
            try 
            {
                mcc.abortConnection();
            } 
            catch (IOException ex)
            {
    if(this.log.isDebugEnabled())                
                {
                    this.log.debug(ex.getMessage(), ex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.584 -0400", hash_original_method = "582621DB4D93E0412F3CDB3DDE871FB7", hash_generated_method = "7C7F2B7A08DCFF45A8FAD15FB47EAE09")
    private void processChallenges(
            final Map<String, Header> challenges, 
            final AuthState authState,
            final AuthenticationHandler authHandler,
            final HttpResponse response, 
            final HttpContext context) throws MalformedChallengeException, AuthenticationException {
        addTaint(context.getTaint());
        addTaint(response.getTaint());
        addTaint(authHandler.getTaint());
        addTaint(authState.getTaint());
        addTaint(challenges.getTaint());
        AuthScheme authScheme = authState.getAuthScheme();
    if(authScheme == null)        
        {
            authScheme = authHandler.selectScheme(challenges, response, context);
            authState.setAuthScheme(authScheme);
        } 
        String id = authScheme.getSchemeName();
        Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
    if(challenge == null)        
        {
            AuthenticationException varADD197DE4731E0165FACB33B3B3666F1_877205235 = new AuthenticationException(id + 
                " authorization challenge expected, but not found");
            varADD197DE4731E0165FACB33B3B3666F1_877205235.addTaint(taint);
            throw varADD197DE4731E0165FACB33B3B3666F1_877205235;
        } 
        authScheme.processChallenge(challenge);
        this.log.debug("Authorization challenge processed");
        
        
        
            
            
        
        
        
        
            
                
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:35.586 -0400", hash_original_method = "48429FCD8E54925B92F9CF361D5F9B0A", hash_generated_method = "9F4D9E0699D7444EDF75B415F2AA6026")
    private void updateAuthState(
            final AuthState authState, 
            final HttpHost host,
            final CredentialsProvider credsProvider) {
        addTaint(credsProvider.getTaint());
        addTaint(host.getTaint());
        addTaint(authState.getTaint());
    if(!authState.isValid())        
        {
            return;
        } 
        String hostname = host.getHostName();
        int port = host.getPort();
    if(port < 0)        
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
    if(this.log.isDebugEnabled())        
        {
            this.log.debug("Authentication scope: " + authScope);
        } 
        Credentials creds = authState.getCredentials();
    if(creds == null)        
        {
            creds = credsProvider.getCredentials(authScope);
    if(this.log.isDebugEnabled())            
            {
    if(creds != null)                
                {
                    this.log.debug("Found credentials");
                } 
                else
                {
                    this.log.debug("Credentials not found");
                } 
            } 
        } 
        else
        {
    if(authScheme.isComplete())            
            {
                this.log.debug("Authentication failed");
                creds = null;
            } 
        } 
        authState.setAuthScope(authScope);
        authState.setCredentials(creds);
        
        
    }

    
}

