package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.NonRepeatableRequestException;
import org.apache.http.client.RedirectException;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.813 -0400", hash_original_field = "0B7469F2850D918A96D1C36E99B23F5C", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "7094FDC3C48BF4047F1C3E46D7A0B7D4", hash_generated_field = "02A8F7D7605C029767E3572CFEE2F34C")

    protected ClientConnectionManager connManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "16B9BCB9C810B5FB9F1218ABF5433F0A", hash_generated_field = "C85BE630FF179384873F74B45C3D1A5E")

    protected HttpRoutePlanner routePlanner;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "6841B3DB425CF924E2406CCC3EC7D0C4", hash_generated_field = "D092FC62D0768D92CCEB66662883652A")

    protected ConnectionReuseStrategy reuseStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "06037BBEEBDAD4B9CCEA6123FF7CEF48", hash_generated_field = "CC83794776099E15447E3B95C8DA1298")

    protected ConnectionKeepAliveStrategy keepAliveStrategy;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "EBFB9A3D3F58438E791B5FA697F0E019", hash_generated_field = "AE8B5D85021B1C853E8228EC07BB45BD")

    protected HttpRequestExecutor requestExec;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "752D4EFA0487789E224C2A1BB7CC684E", hash_generated_field = "BE58AA1EBB61C1DA0052321621920348")

    protected HttpProcessor httpProcessor;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "9276D9188CF6BA2DC6A4953C0672BC3D", hash_generated_field = "98BC4E4D2CA69028F19F530E761B7A50")

    protected HttpRequestRetryHandler retryHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "F350623671C50CD5233E0DC58B4BC69F", hash_generated_field = "1D6916AFC0FC11340932EC2AB84E4EEA")

    protected RedirectHandler redirectHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "6FA7D1184BC1FAC634576AE3416BC1FC", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private AuthenticationHandler targetAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "0F58376CC8049DF18F70792E6CDE0CBB", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private AuthenticationHandler proxyAuthHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "7CA4C2AD16B3CB439480B96FCAB580BC", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private UserTokenHandler userTokenHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "21FFCE5B8A6CC8CC6A41448DD69623C9", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected HttpParams params;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "EC981A5CB5248DB431EB0C0A85CB6583", hash_generated_field = "D59A8F322AA61B2EDF1BDFFFEB284AB6")

    private int redirectCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.814 -0400", hash_original_field = "192E8F7D1AC88DB04E4D404EEFE3BA12", hash_generated_field = "C858360B99BF75CE96620A237ADD6C16")

    private int maxRedirects;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.815 -0400", hash_original_field = "42FB65007B91DD7B4C2B4593948697DD", hash_generated_field = "09D81EEE3AA06EF4775316736BFDA2B2")

    private AuthState targetAuthState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.815 -0400", hash_original_field = "BB590229B7E3F737CC2E4575475A1353", hash_generated_field = "04947E0C0D6A7F5789678D91EF5BFD42")

    private AuthState proxyAuthState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.822 -0400", hash_original_method = "0B21A162BE3540982FD94EA0624DFDC2", hash_generated_method = "1C89CC839DACE6F62DB386775FD06301")
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
            IllegalArgumentException varBD20B6DE94BA160E38D6A19FE620972B_1085161961 = new IllegalArgumentException
                ("Request executor may not be null.");
            varBD20B6DE94BA160E38D6A19FE620972B_1085161961.addTaint(taint);
            throw varBD20B6DE94BA160E38D6A19FE620972B_1085161961;
        } //End block
        if(conman == null)        
        {
            IllegalArgumentException var2CAE72D222E2018F21A500BBB781366A_1066882273 = new IllegalArgumentException
                ("Client connection manager may not be null.");
            var2CAE72D222E2018F21A500BBB781366A_1066882273.addTaint(taint);
            throw var2CAE72D222E2018F21A500BBB781366A_1066882273;
        } //End block
        if(reustrat == null)        
        {
            IllegalArgumentException varAC1BE54E06BD0BF73EC95A07797E6CC6_426073987 = new IllegalArgumentException
                ("Connection reuse strategy may not be null.");
            varAC1BE54E06BD0BF73EC95A07797E6CC6_426073987.addTaint(taint);
            throw varAC1BE54E06BD0BF73EC95A07797E6CC6_426073987;
        } //End block
        if(kastrat == null)        
        {
            IllegalArgumentException var5D18D55E95DEDD7525CEB1D5D4EDA5AE_76229940 = new IllegalArgumentException
                ("Connection keep alive strategy may not be null.");
            var5D18D55E95DEDD7525CEB1D5D4EDA5AE_76229940.addTaint(taint);
            throw var5D18D55E95DEDD7525CEB1D5D4EDA5AE_76229940;
        } //End block
        if(rouplan == null)        
        {
            IllegalArgumentException var61450AC721478F07064D5CA3DC87688F_1810044586 = new IllegalArgumentException
                ("Route planner may not be null.");
            var61450AC721478F07064D5CA3DC87688F_1810044586.addTaint(taint);
            throw var61450AC721478F07064D5CA3DC87688F_1810044586;
        } //End block
        if(httpProcessor == null)        
        {
            IllegalArgumentException var483355B68B755FD92D77FBBC0550B939_381588495 = new IllegalArgumentException
                ("HTTP protocol processor may not be null.");
            var483355B68B755FD92D77FBBC0550B939_381588495.addTaint(taint);
            throw var483355B68B755FD92D77FBBC0550B939_381588495;
        } //End block
        if(retryHandler == null)        
        {
            IllegalArgumentException varC2CE5DC5C328BB16435F5ED993581E10_1276006953 = new IllegalArgumentException
                ("HTTP request retry handler may not be null.");
            varC2CE5DC5C328BB16435F5ED993581E10_1276006953.addTaint(taint);
            throw varC2CE5DC5C328BB16435F5ED993581E10_1276006953;
        } //End block
        if(redirectHandler == null)        
        {
            IllegalArgumentException varBF23C9695C0C4964C86566E857075907_78193037 = new IllegalArgumentException
                ("Redirect handler may not be null.");
            varBF23C9695C0C4964C86566E857075907_78193037.addTaint(taint);
            throw varBF23C9695C0C4964C86566E857075907_78193037;
        } //End block
        if(targetAuthHandler == null)        
        {
            IllegalArgumentException varC21C33DC73C90A72F11A21040411F90C_581743496 = new IllegalArgumentException
                ("Target authentication handler may not be null.");
            varC21C33DC73C90A72F11A21040411F90C_581743496.addTaint(taint);
            throw varC21C33DC73C90A72F11A21040411F90C_581743496;
        } //End block
        if(proxyAuthHandler == null)        
        {
            IllegalArgumentException var891BA88640E4B3379FCF2CCC866D25AF_554833703 = new IllegalArgumentException
                ("Proxy authentication handler may not be null.");
            var891BA88640E4B3379FCF2CCC866D25AF_554833703.addTaint(taint);
            throw var891BA88640E4B3379FCF2CCC866D25AF_554833703;
        } //End block
        if(userTokenHandler == null)        
        {
            IllegalArgumentException var9380208749C6633F93F784E902C07784_1081642131 = new IllegalArgumentException
                ("User token handler may not be null.");
            var9380208749C6633F93F784E902C07784_1081642131.addTaint(taint);
            throw var9380208749C6633F93F784E902C07784_1081642131;
        } //End block
        if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1230432554 = new IllegalArgumentException
                ("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1230432554.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1230432554;
        } //End block
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.823 -0400", hash_original_method = "61E87BBE33E8E65E80E9F3F1C82F2660", hash_generated_method = "7F670B2EBE1422E8A44AF135D1C69B91")
    private RequestWrapper wrapRequest(
            final HttpRequest request) throws ProtocolException {
        addTaint(request.getTaint());
        if(request instanceof HttpEntityEnclosingRequest)        
        {
RequestWrapper var0C4280835D14C11473AAA56C205C196E_69750663 =             new EntityEnclosingRequestWrapper(
                    (HttpEntityEnclosingRequest) request);
            var0C4280835D14C11473AAA56C205C196E_69750663.addTaint(taint);
            return var0C4280835D14C11473AAA56C205C196E_69750663;
        } //End block
        else
        {
RequestWrapper varECE469D25B56B0BCEBCCBF137D95445B_1295689652 =             new RequestWrapper(
                    request);
            varECE469D25B56B0BCEBCCBF137D95445B_1295689652.addTaint(taint);
            return varECE469D25B56B0BCEBCCBF137D95445B_1295689652;
        } //End block
        // ---------- Original Method ----------
        //if (request instanceof HttpEntityEnclosingRequest) {
            //return new EntityEnclosingRequestWrapper(
                    //(HttpEntityEnclosingRequest) request);
        //} else {
            //return new RequestWrapper(
                    //request);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.823 -0400", hash_original_method = "6DDB48FED3712857B06BA2C85DA91575", hash_generated_method = "56FC19C47F200C9C51682659348EFFFD")
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
                } //End block
            } //End block
            else
            {
                if(uri.isAbsolute())                
                {
                    uri = URIUtils.rewriteURI(uri, null);
                    request.setURI(uri);
                } //End block
            } //End block
        } //End block
        catch (URISyntaxException ex)
        {
            ProtocolException var7A0C22AEC7611C0CB0FD9196AE88644C_639004217 = new ProtocolException("Invalid URI: " + 
                    request.getRequestLine().getUri(), ex);
            var7A0C22AEC7611C0CB0FD9196AE88644C_639004217.addTaint(taint);
            throw var7A0C22AEC7611C0CB0FD9196AE88644C_639004217;
        } //End block
        // ---------- Original Method ----------
        //try {
            //URI uri = request.getURI();
            //if (route.getProxyHost() != null && !route.isTunnelled()) {
                //if (!uri.isAbsolute()) {
                    //HttpHost target = route.getTargetHost();
                    //uri = URIUtils.rewriteURI(uri, target);
                    //request.setURI(uri);
                //}
            //} else {
                //if (uri.isAbsolute()) {
                    //uri = URIUtils.rewriteURI(uri, null);
                    //request.setURI(uri);
                //}
            //}
        //} catch (URISyntaxException ex) {
            //throw new ProtocolException("Invalid URI: " + 
                    //request.getRequestLine().getUri(), ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.826 -0400", hash_original_method = "FF11182248C158BE9943CC5E99D59AB1", hash_generated_method = "48A3F0096BB1067B9B77E58BA009FB46")
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
                    } //End block
                    try 
                    {
                        managedConn = connRequest.getConnection(timeout, TimeUnit.MILLISECONDS);
                    } //End block
                    catch (InterruptedException interrupted)
                    {
                        InterruptedIOException iox = new InterruptedIOException();
                        iox.initCause(interrupted);
                        iox.addTaint(taint);
                        throw iox;
                    } //End block
                    if(HttpConnectionParams.isStaleCheckingEnabled(params))                    
                    {
                        this.log.debug("Stale connection check");
                        if(managedConn.isStale())                        
                        {
                            this.log.debug("Stale connection detected");
                            try 
                            {
                                managedConn.close();
                            } //End block
                            catch (IOException ignored)
                            {
                            } //End block
                        } //End block
                    } //End block
                } //End block
                if(orig instanceof AbortableHttpRequest)                
                {
                    ((AbortableHttpRequest) orig).setReleaseTrigger(managedConn);
                } //End block
                if(!managedConn.isOpen())                
                {
                    managedConn.open(route, context, params);
                } //End block
                else
                {
                    managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
                } //End block
                try 
                {
                    establishRoute(route, context);
                } //End block
                catch (TunnelRefusedException ex)
                {
                    if(this.log.isDebugEnabled())                    
                    {
                        this.log.debug(ex.getMessage());
                    } //End block
                    response = ex.getResponse();
                    break;
                } //End block
                wrapper.resetHeaders();
                rewriteRequestURI(wrapper, route);
                target = (HttpHost) wrapper.getParams().getParameter(
                        ClientPNames.VIRTUAL_HOST);
                if(target == null)                
                {
                    target = route.getTargetHost();
                } //End block
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
                        NonRepeatableRequestException varBE8956FD29594D8614365E775C241D18_946575156 = new NonRepeatableRequestException("Cannot retry request " +
                                "with a non-repeatable request entity");
                        varBE8956FD29594D8614365E775C241D18_946575156.addTaint(taint);
                        throw varBE8956FD29594D8614365E775C241D18_946575156;
                    } //End block
                    try 
                    {
                        if(this.log.isDebugEnabled())                        
                        {
                            this.log.debug("Attempt " + execCount + " to execute request");
                        } //End block
                        response = requestExec.execute(wrapper, managedConn, context);
                        retrying = false;
                    } //End block
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
                            } //End block
                            if(this.log.isDebugEnabled())                            
                            {
                                this.log.debug(ex.getMessage(), ex);
                            } //End block
                            this.log.info("Retrying request");
                        } //End block
                        else
                        {
                            ex.addTaint(taint);
                            throw ex;
                        } //End block
                        if(route.getHopCount() == 1)                        
                        {
                            this.log.debug("Reopening the direct connection.");
                            managedConn.open(route, context, params);
                        } //End block
                        else
                        {
                            ex.addTaint(taint);
                            throw ex;
                        } //End block
                    } //End block
                } //End block
                response.setParams(params);
                requestExec.postProcess(response, httpProcessor, context);
                reuse = reuseStrategy.keepAlive(response, context);
                if(reuse)                
                {
                    long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
                    managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
                } //End block
                RoutedRequest followup = handleResponse(roureq, response, context);
                if(followup == null)                
                {
                    done = true;
                } //End block
                else
                {
                    if(reuse)                    
                    {
                        this.log.debug("Connection kept alive");
                        HttpEntity entity = response.getEntity();
                        if(entity != null)                        
                        {
                            entity.consumeContent();
                        } //End block
                        managedConn.markReusable();
                    } //End block
                    else
                    {
                        managedConn.close();
                    } //End block
                    if(!followup.getRoute().equals(roureq.getRoute()))                    
                    {
                        releaseConnection();
                    } //End block
                    roureq = followup;
                } //End block
                userToken = this.userTokenHandler.getUserToken(context);
                context.setAttribute(ClientContext.USER_TOKEN, userToken);
                if(managedConn != null)                
                {
                    managedConn.setState(userToken);
                } //End block
            } //End block
            if((response == null) || (response.getEntity() == null) ||
                !response.getEntity().isStreaming())            
            {
                if(reuse)                
                managedConn.markReusable();
                releaseConnection();
            } //End block
            else
            {
                HttpEntity entity = response.getEntity();
                entity = new BasicManagedEntity(entity, managedConn, reuse);
                response.setEntity(entity);
            } //End block
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_997377750 =             response;
            var2A1114F4272D753FE23A36E3D68CD293_997377750.addTaint(taint);
            return var2A1114F4272D753FE23A36E3D68CD293_997377750;
        } //End block
        catch (HttpException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (IOException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } //End block
        catch (RuntimeException ex)
        {
            abortConnection();
            ex.addTaint(taint);
            throw ex;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.829 -0400", hash_original_method = "72FBB2C6656BE4AE3AB40DA6CB70F970", hash_generated_method = "715CF4FA77516E276A6E0260E216C641")
    protected void releaseConnection() {
        try 
        {
            managedConn.releaseConnection();
        } //End block
        catch (IOException ignored)
        {
            this.log.debug("IOException releasing connection", ignored);
        } //End block
        managedConn = null;
        // ---------- Original Method ----------
        //try {
            //managedConn.releaseConnection();
        //} catch(IOException ignored) {
            //this.log.debug("IOException releasing connection", ignored);
        //}
        //managedConn = null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.830 -0400", hash_original_method = "855E342C251EB2356D381DD4230A53C3", hash_generated_method = "415DA8F0AF4612F76124E7EB7439B06D")
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
        } //End block
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
            } //End block
            IllegalStateException var7A13D68460776BAB9F175883D2724744_508204401 = new IllegalStateException( "Target host must not be null, or set in parameters."
                    + " scheme=" + scheme + ", host=" + host + ", path=" + path);
            var7A13D68460776BAB9F175883D2724744_508204401.addTaint(taint);
            throw var7A13D68460776BAB9F175883D2724744_508204401;
        } //End block
HttpRoute var18D2C66D78254B27FEC5244CEBAE6575_856531488 =         this.routePlanner.determineRoute(target, request, context);
        var18D2C66D78254B27FEC5244CEBAE6575_856531488.addTaint(taint);
        return var18D2C66D78254B27FEC5244CEBAE6575_856531488;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.831 -0400", hash_original_method = "7601A49E11EC8C911923D57ABD663D23", hash_generated_method = "3CB1D84AD04CC0161F8BF41B665AEE4F")
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
                } //End block
                break;
                case HttpRouteDirector.TUNNEL_PROXY:
                {
                    final int hop = fact.getHopCount()-1;
                    boolean secure = createTunnelToProxy(route, hop, context);
                    this.log.debug("Tunnel to proxy created.");
                    managedConn.tunnelProxy(route.getHopTarget(hop),
                                        secure, this.params);
                } //End block
                break;
                case HttpRouteDirector.LAYER_PROTOCOL:
                managedConn.layerProtocol(context, this.params);
                break;
                case HttpRouteDirector.UNREACHABLE:
                IllegalStateException var41E4D464A14C97E1EC762FC59C493EE0_710019003 = new IllegalStateException
                    ("Unable to establish route." +
                     "\nplanned = " + route +
                     "\ncurrent = " + fact);
                var41E4D464A14C97E1EC762FC59C493EE0_710019003.addTaint(taint);
                throw var41E4D464A14C97E1EC762FC59C493EE0_710019003;
                case HttpRouteDirector.COMPLETE:
                break;
                default:
                IllegalStateException var8F4BA28D8DE40A5BAB04A0DC81D7EB48_1134160548 = new IllegalStateException
                    ("Unknown step indicator "+step+" from RouteDirector.");
                var8F4BA28D8DE40A5BAB04A0DC81D7EB48_1134160548.addTaint(taint);
                throw var8F4BA28D8DE40A5BAB04A0DC81D7EB48_1134160548;
}
            } //End block
} while (step > HttpRouteDirector.COMPLETE);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.833 -0400", hash_original_method = "135ABB51CD042C7BF2D35A5F6450399E", hash_generated_method = "1627B99E1102F756DE8EE65E33B3ABA8")
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
            } //End block
            HttpRequest connect = createConnectRequest(route, context);
            String agent = HttpProtocolParams.getUserAgent(params);
            if(agent != null)            
            {
                connect.addHeader(HTTP.USER_AGENT, agent);
            } //End block
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
                    } //End block
                    catch (AuthenticationException ex)
                    {
                        if(this.log.isErrorEnabled())                        
                        {
                            this.log.error("Proxy authentication error: " + ex.getMessage());
                        } //End block
                    } //End block
                } //End block
            } //End block
            response = requestExec.execute(connect, this.managedConn, context);
            int status = response.getStatusLine().getStatusCode();
            if(status < 200)            
            {
                HttpException varD3EF24224D53CFEC9101DECAEC6951EE_394084008 = new HttpException("Unexpected response to CONNECT request: " +
                        response.getStatusLine());
                varD3EF24224D53CFEC9101DECAEC6951EE_394084008.addTaint(taint);
                throw varD3EF24224D53CFEC9101DECAEC6951EE_394084008;
            } //End block
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
                    } //End block
                    catch (AuthenticationException ex)
                    {
                        if(this.log.isWarnEnabled())                        
                        {
                            this.log.warn("Authentication error: " +  ex.getMessage());
                            break;
                        } //End block
                    } //End block
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
                            } //End block
                        } //End block
                        else
                        {
                            this.managedConn.close();
                        } //End block
                    } //End block
                } //End block
                else
                {
                    this.proxyAuthState.setAuthScope(null);
                } //End block
            } //End block
        } //End block
        int status = response.getStatusLine().getStatusCode();
        if(status > 299)        
        {
            HttpEntity entity = response.getEntity();
            if(entity != null)            
            {
                response.setEntity(new BufferedHttpEntity(entity));
            } //End block
            this.managedConn.close();
            TunnelRefusedException varB63C984E4D7FCF92F245BAD42F4DFE6F_491891182 = new TunnelRefusedException("CONNECT refused by proxy: " +
                    response.getStatusLine(), response);
            varB63C984E4D7FCF92F245BAD42F4DFE6F_491891182.addTaint(taint);
            throw varB63C984E4D7FCF92F245BAD42F4DFE6F_491891182;
        } //End block
        this.managedConn.markReusable();
        boolean var68934A3E9455FA72420237EB05902327_571152908 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063354158 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063354158;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.835 -0400", hash_original_method = "F6C0B77A6F010BA1F972A9366C7E6CE6", hash_generated_method = "36AE56BB7A4F30C0EFF30FDDAC17A718")
    protected boolean createTunnelToProxy(HttpRoute route, int hop,
                                          HttpContext context) throws HttpException, IOException {
        addTaint(context.getTaint());
        addTaint(hop);
        addTaint(route.getTaint());
        UnsupportedOperationException varFE02595BC82A88C5229C259936D54501_400764733 = new UnsupportedOperationException
            ("Proxy chains are not supported.");
        varFE02595BC82A88C5229C259936D54501_400764733.addTaint(taint);
        throw varFE02595BC82A88C5229C259936D54501_400764733;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException
            //("Proxy chains are not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.835 -0400", hash_original_method = "7799E26CF8933DA985404F8B4CB5983A", hash_generated_method = "E41E4B451B398CFE3FA43E437007FBA6")
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
        } //End block
        StringBuilder buffer = new StringBuilder(host.length() + 6);
        buffer.append(host);
        buffer.append(':');
        buffer.append(Integer.toString(port));
        String authority = buffer.toString();
        ProtocolVersion ver = HttpProtocolParams.getVersion(params);
        HttpRequest req = new BasicHttpRequest
            ("CONNECT", authority, ver);
HttpRequest var71AC1B13807E2EDC246A42B3DB2D8EEA_345801757 =         req;
        var71AC1B13807E2EDC246A42B3DB2D8EEA_345801757.addTaint(taint);
        return var71AC1B13807E2EDC246A42B3DB2D8EEA_345801757;
        // ---------- Original Method ----------
        //HttpHost target = route.getTargetHost();
        //String host = target.getHostName();
        //int port = target.getPort();
        //if (port < 0) {
            //Scheme scheme = connManager.getSchemeRegistry().
                //getScheme(target.getSchemeName());
            //port = scheme.getDefaultPort();
        //}
        //StringBuilder buffer = new StringBuilder(host.length() + 6);
        //buffer.append(host);
        //buffer.append(':');
        //buffer.append(Integer.toString(port));
        //String authority = buffer.toString();
        //ProtocolVersion ver = HttpProtocolParams.getVersion(params);
        //HttpRequest req = new BasicHttpRequest
            //("CONNECT", authority, ver);
        //return req;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.836 -0400", hash_original_method = "E253F133593C4FA5CC62D333761B1C94", hash_generated_method = "39992CA38935D35DCEB87C51D89A9486")
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
                RedirectException var29BC0BAED8BB7987E47C0BA80AF93FBD_909838165 = new RedirectException("Maximum redirects ("
                        + maxRedirects + ") exceeded");
                var29BC0BAED8BB7987E47C0BA80AF93FBD_909838165.addTaint(taint);
                throw var29BC0BAED8BB7987E47C0BA80AF93FBD_909838165;
            } //End block
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
            } //End block
RoutedRequest var843B90BB67BB5454D25E3643EF8010AB_1521830247 =             newRequest;
            var843B90BB67BB5454D25E3643EF8010AB_1521830247.addTaint(taint);
            return var843B90BB67BB5454D25E3643EF8010AB_1521830247;
        } //End block
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
                } //End block
                this.log.debug("Target requested authentication");
                Map<String, Header> challenges = this.targetAuthHandler.getChallenges(
                        response, context);
                try 
                {
                    processChallenges(challenges, 
                            this.targetAuthState, this.targetAuthHandler,
                            response, context);
                } //End block
                catch (AuthenticationException ex)
                {
                    if(this.log.isWarnEnabled())                    
                    {
                        this.log.warn("Authentication error: " +  ex.getMessage());
RoutedRequest var540C13E9E156B687226421B24F2DF178_724028341 =                         null;
                        var540C13E9E156B687226421B24F2DF178_724028341.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_724028341;
                    } //End block
                } //End block
                updateAuthState(this.targetAuthState, target, credsProvider);
                if(this.targetAuthState.getCredentials() != null)                
                {
RoutedRequest var6648910846287553B78C1318790BB204_760703723 =                     roureq;
                    var6648910846287553B78C1318790BB204_760703723.addTaint(taint);
                    return var6648910846287553B78C1318790BB204_760703723;
                } //End block
                else
                {
RoutedRequest var540C13E9E156B687226421B24F2DF178_1250611475 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1250611475.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1250611475;
                } //End block
            } //End block
            else
            {
                this.targetAuthState.setAuthScope(null);
            } //End block
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
                } //End block
                catch (AuthenticationException ex)
                {
                    if(this.log.isWarnEnabled())                    
                    {
                        this.log.warn("Authentication error: " +  ex.getMessage());
RoutedRequest var540C13E9E156B687226421B24F2DF178_1902368442 =                         null;
                        var540C13E9E156B687226421B24F2DF178_1902368442.addTaint(taint);
                        return var540C13E9E156B687226421B24F2DF178_1902368442;
                    } //End block
                } //End block
                updateAuthState(this.proxyAuthState, proxy, credsProvider);
                if(this.proxyAuthState.getCredentials() != null)                
                {
RoutedRequest var6648910846287553B78C1318790BB204_1669495651 =                     roureq;
                    var6648910846287553B78C1318790BB204_1669495651.addTaint(taint);
                    return var6648910846287553B78C1318790BB204_1669495651;
                } //End block
                else
                {
RoutedRequest var540C13E9E156B687226421B24F2DF178_1634909064 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1634909064.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1634909064;
                } //End block
            } //End block
            else
            {
                this.proxyAuthState.setAuthScope(null);
            } //End block
        } //End block
RoutedRequest var540C13E9E156B687226421B24F2DF178_639884716 =         null;
        var540C13E9E156B687226421B24F2DF178_639884716.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_639884716;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.838 -0400", hash_original_method = "1B42C243E9B570B37B5AA18DF368B31A", hash_generated_method = "17198A02B2E5C37081B5A7BE5C174595")
    private void abortConnection() {
        ManagedClientConnection mcc = managedConn;
        if(mcc != null)        
        {
            managedConn = null;
            try 
            {
                mcc.abortConnection();
            } //End block
            catch (IOException ex)
            {
                if(this.log.isDebugEnabled())                
                {
                    this.log.debug(ex.getMessage(), ex);
                } //End block
            } //End block
            try 
            {
                mcc.releaseConnection();
            } //End block
            catch (IOException ignored)
            {
                this.log.debug("Error releasing connection", ignored);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //ManagedClientConnection mcc = managedConn;
        //if (mcc != null) {
            //managedConn = null;
            //try {
                //mcc.abortConnection();
            //} catch (IOException ex) {
                //if (this.log.isDebugEnabled()) {
                    //this.log.debug(ex.getMessage(), ex);
                //}
            //}
            //try {
                //mcc.releaseConnection();
            //} catch(IOException ignored) {
                //this.log.debug("Error releasing connection", ignored);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.839 -0400", hash_original_method = "582621DB4D93E0412F3CDB3DDE871FB7", hash_generated_method = "EA679C6F1AA8CE77E96E16ABF551363F")
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
        } //End block
        String id = authScheme.getSchemeName();
        Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
        if(challenge == null)        
        {
            AuthenticationException varADD197DE4731E0165FACB33B3B3666F1_1816628298 = new AuthenticationException(id + 
                " authorization challenge expected, but not found");
            varADD197DE4731E0165FACB33B3B3666F1_1816628298.addTaint(taint);
            throw varADD197DE4731E0165FACB33B3B3666F1_1816628298;
        } //End block
        authScheme.processChallenge(challenge);
        this.log.debug("Authorization challenge processed");
        // ---------- Original Method ----------
        //AuthScheme authScheme = authState.getAuthScheme();
        //if (authScheme == null) {
            //authScheme = authHandler.selectScheme(challenges, response, context);
            //authState.setAuthScheme(authScheme);
        //}
        //String id = authScheme.getSchemeName();
        //Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
        //if (challenge == null) {
            //throw new AuthenticationException(id + 
                //" authorization challenge expected, but not found");
        //}
        //authScheme.processChallenge(challenge);
        //this.log.debug("Authorization challenge processed");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:34.839 -0400", hash_original_method = "48429FCD8E54925B92F9CF361D5F9B0A", hash_generated_method = "9F4D9E0699D7444EDF75B415F2AA6026")
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
        } //End block
        String hostname = host.getHostName();
        int port = host.getPort();
        if(port < 0)        
        {
            Scheme scheme = connManager.getSchemeRegistry().getScheme(host);
            port = scheme.getDefaultPort();
        } //End block
        AuthScheme authScheme = authState.getAuthScheme();
        AuthScope authScope = new AuthScope(
                hostname,
                port,
                authScheme.getRealm(), 
                authScheme.getSchemeName());
        if(this.log.isDebugEnabled())        
        {
            this.log.debug("Authentication scope: " + authScope);
        } //End block
        Credentials creds = authState.getCredentials();
        if(creds == null)        
        {
            creds = credsProvider.getCredentials(authScope);
            if(this.log.isDebugEnabled())            
            {
                if(creds != null)                
                {
                    this.log.debug("Found credentials");
                } //End block
                else
                {
                    this.log.debug("Credentials not found");
                } //End block
            } //End block
        } //End block
        else
        {
            if(authScheme.isComplete())            
            {
                this.log.debug("Authentication failed");
                creds = null;
            } //End block
        } //End block
        authState.setAuthScope(authScope);
        authState.setCredentials(creds);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

