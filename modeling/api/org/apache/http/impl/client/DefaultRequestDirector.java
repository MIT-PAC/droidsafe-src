/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/client/DefaultRequestDirector.java $
 * $Revision: 676023 $
 * $Date: 2008-07-11 09:40:56 -0700 (Fri, 11 Jul 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.864 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.867 -0500", hash_original_field = "79C539F0631DE1ED22CABB863DF47A25", hash_generated_field = "02A8F7D7605C029767E3572CFEE2F34C")

    protected  ClientConnectionManager connManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.869 -0500", hash_original_field = "8823E067EE1A73A5A4F8381AD9DE926C", hash_generated_field = "C85BE630FF179384873F74B45C3D1A5E")

    protected  HttpRoutePlanner routePlanner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.871 -0500", hash_original_field = "28E659C3D090811B03AB9280351D82C6", hash_generated_field = "D092FC62D0768D92CCEB66662883652A")

    protected  ConnectionReuseStrategy reuseStrategy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.873 -0500", hash_original_field = "DC7075B9CA312E5C377DD150B9B7DC40", hash_generated_field = "CC83794776099E15447E3B95C8DA1298")

    protected  ConnectionKeepAliveStrategy keepAliveStrategy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.876 -0500", hash_original_field = "8F281D2DD0CAF0CB49AD825611A30021", hash_generated_field = "AE8B5D85021B1C853E8228EC07BB45BD")

    protected  HttpRequestExecutor requestExec;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.879 -0500", hash_original_field = "0B667B56B623A6709D8228F6864C17B9", hash_generated_field = "BE58AA1EBB61C1DA0052321621920348")

    protected  HttpProcessor httpProcessor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.881 -0500", hash_original_field = "BE7CB17045E13BE02A346FA0C3A4D12A", hash_generated_field = "98BC4E4D2CA69028F19F530E761B7A50")

    protected  HttpRequestRetryHandler retryHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.883 -0500", hash_original_field = "C389F7622E181983E4C8376E70EDBD71", hash_generated_field = "1D6916AFC0FC11340932EC2AB84E4EEA")

    protected  RedirectHandler redirectHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.886 -0500", hash_original_field = "DBA4951E5E541F8099D40BF93DF5F36F", hash_generated_field = "6C80A901FF52F10B6A44B9702DD7CAAC")

    private  AuthenticationHandler targetAuthHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.888 -0500", hash_original_field = "5E81B4DA49E5D7964FC77151D6BD375D", hash_generated_field = "BEE8D0545E89B6E0C8B7E30053A9F7B8")

    private  AuthenticationHandler proxyAuthHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.890 -0500", hash_original_field = "CAE4A7A320983E8C1CCB152CF3DFF728", hash_generated_field = "EB0695AD7F13D362DB9842F689B4BC95")

    private  UserTokenHandler userTokenHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.893 -0500", hash_original_field = "E1952F00A693661EA0D1C7B3D836F77E", hash_generated_field = "3B20DD38103AF5BA4B3F3187700011E0")

    protected  HttpParams params;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.896 -0500", hash_original_field = "ECC1A1A1F3BB31DE20717F98D44EFC60", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.898 -0500", hash_original_field = "0AE41E5E8D5B3D970EA29093BE41B738", hash_generated_field = "D59A8F322AA61B2EDF1BDFFFEB284AB6")

    private int redirectCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.900 -0500", hash_original_field = "74902B111622E9E3A744EFC5D329328E", hash_generated_field = "C858360B99BF75CE96620A237ADD6C16")

    private int maxRedirects;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.903 -0500", hash_original_field = "5A35C8104FC2D865E8F8A0879C0F7F9A", hash_generated_field = "09D81EEE3AA06EF4775316736BFDA2B2")
    
    private  AuthState targetAuthState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.905 -0500", hash_original_field = "A6CA6072C1BFCC3C72577263E286D091", hash_generated_field = "04947E0C0D6A7F5789678D91EF5BFD42")
    
    private  AuthState proxyAuthState;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.909 -0500", hash_original_method = "0B21A162BE3540982FD94EA0624DFDC2", hash_generated_method = "F6CEE975853313FCFBBAA42B262AAD1E")
    
public DefaultRequestDirector(
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

        if (requestExec == null) {
            throw new IllegalArgumentException
                ("Request executor may not be null.");
        }
        if (conman == null) {
            throw new IllegalArgumentException
                ("Client connection manager may not be null.");
        }
        if (reustrat == null) {
            throw new IllegalArgumentException
                ("Connection reuse strategy may not be null.");
        }
        if (kastrat == null) {
            throw new IllegalArgumentException
                ("Connection keep alive strategy may not be null.");
        }
        if (rouplan == null) {
            throw new IllegalArgumentException
                ("Route planner may not be null.");
        }
        if (httpProcessor == null) {
            throw new IllegalArgumentException
                ("HTTP protocol processor may not be null.");
        }
        if (retryHandler == null) {
            throw new IllegalArgumentException
                ("HTTP request retry handler may not be null.");
        }
        if (redirectHandler == null) {
            throw new IllegalArgumentException
                ("Redirect handler may not be null.");
        }
        if (targetAuthHandler == null) {
            throw new IllegalArgumentException
                ("Target authentication handler may not be null.");
        }
        if (proxyAuthHandler == null) {
            throw new IllegalArgumentException
                ("Proxy authentication handler may not be null.");
        }
        if (userTokenHandler == null) {
            throw new IllegalArgumentException
                ("User token handler may not be null.");
        }
        if (params == null) {
            throw new IllegalArgumentException
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
    } // constructor

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.911 -0500", hash_original_method = "61E87BBE33E8E65E80E9F3F1C82F2660", hash_generated_method = "6FBF59CD03CC8B4D52C23997423EADC5")
    
private RequestWrapper wrapRequest(
            final HttpRequest request) throws ProtocolException {
        if (request instanceof HttpEntityEnclosingRequest) {
            return new EntityEnclosingRequestWrapper(
                    (HttpEntityEnclosingRequest) request);
        } else {
            return new RequestWrapper(
                    request);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.914 -0500", hash_original_method = "6DDB48FED3712857B06BA2C85DA91575", hash_generated_method = "127EB3421BD46398C7ABCCC86B5FF295")
    
protected void rewriteRequestURI(
            final RequestWrapper request,
            final HttpRoute route) throws ProtocolException {
        try {
            
            URI uri = request.getURI();
            if (route.getProxyHost() != null && !route.isTunnelled()) {
                // Make sure the request URI is absolute
                if (!uri.isAbsolute()) {
                    HttpHost target = route.getTargetHost();
                    uri = URIUtils.rewriteURI(uri, target);
                    request.setURI(uri);
                }
            } else {
                // Make sure the request URI is relative
                if (uri.isAbsolute()) {
                    uri = URIUtils.rewriteURI(uri, null);
                    request.setURI(uri);
                }
            }
            
        } catch (URISyntaxException ex) {
            throw new ProtocolException("Invalid URI: " + 
                    request.getRequestLine().getUri(), ex);
        }
    }
    
    // non-javadoc, see interface ClientRequestDirector
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.921 -0500", hash_original_method = "FF11182248C158BE9943CC5E99D59AB1", hash_generated_method = "FADA447509B07675118E8E4872FBFA31")
    
public HttpResponse execute(HttpHost target, HttpRequest request,
                                HttpContext context)
        throws HttpException, IOException {

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
        try {
            while (!done) {
                // In this loop, the RoutedRequest may be replaced by a
                // followup request and route. The request and route passed
                // in the method arguments will be replaced. The original
                // request is still available in 'orig'.

                RequestWrapper wrapper = roureq.getRequest();
                HttpRoute route = roureq.getRoute();
                
                // See if we have a user token bound to the execution context
                Object userToken = context.getAttribute(ClientContext.USER_TOKEN);
                
                // Allocate connection if needed
                if (managedConn == null) {
                    ClientConnectionRequest connRequest = connManager.requestConnection(
                            route, userToken);
                    if (orig instanceof AbortableHttpRequest) {
                        ((AbortableHttpRequest) orig).setConnectionRequest(connRequest);
                    }
                    
                    try {
                        managedConn = connRequest.getConnection(timeout, TimeUnit.MILLISECONDS);
                    } catch(InterruptedException interrupted) {
                        InterruptedIOException iox = new InterruptedIOException();
                        iox.initCause(interrupted);
                        throw iox;
                    }

                    if (HttpConnectionParams.isStaleCheckingEnabled(params)) {
                        // validate connection
                        this.log.debug("Stale connection check");
                        if (managedConn.isStale()) {
                            this.log.debug("Stale connection detected");
                            // BEGIN android-changed
                            try {
                                managedConn.close();
                            } catch (IOException ignored) {
                                // SSLSocket's will throw IOException
                                // because they can't send a "close
                                // notify" protocol message to the
                                // server. Just supresss any
                                // exceptions related to closing the
                                // stale connection.
                            }
                            // END android-changed
                        }
                    }
                }

                if (orig instanceof AbortableHttpRequest) {
                    ((AbortableHttpRequest) orig).setReleaseTrigger(managedConn);
                }

                // Reopen connection if needed
                if (!managedConn.isOpen()) {
                    managedConn.open(route, context, params);
                }
                // BEGIN android-added
                else {
                    // b/3241899 set the per request timeout parameter on reused connections
                    managedConn.setSocketTimeout(HttpConnectionParams.getSoTimeout(params));
                }
                // END android-added
                
                try {
                    establishRoute(route, context);
                } catch (TunnelRefusedException ex) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug(ex.getMessage());
                    }
                    response = ex.getResponse();
                    break;
                }

                // Reset headers on the request wrapper
                wrapper.resetHeaders();
                
                // Re-write request URI if needed
                rewriteRequestURI(wrapper, route);

                // Use virtual host if set
                target = (HttpHost) wrapper.getParams().getParameter(
                        ClientPNames.VIRTUAL_HOST);

                if (target == null) {
                    target = route.getTargetHost();
                }

                HttpHost proxy = route.getProxyHost();

                // Populate the execution context
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
                
                // Run request protocol interceptors
                requestExec.preProcess(wrapper, httpProcessor, context);
                
                context.setAttribute(ExecutionContext.HTTP_REQUEST,
                        wrapper);

                boolean retrying = true;
                while (retrying) {
                    // Increment total exec count (with redirects)
                    execCount++;
                    // Increment exec count for this particular request
                    wrapper.incrementExecCount();
                    if (wrapper.getExecCount() > 1 && !wrapper.isRepeatable()) {
                        throw new NonRepeatableRequestException("Cannot retry request " +
                                "with a non-repeatable request entity");
                    }
                    
                    try {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Attempt " + execCount + " to execute request");
                        }
                        response = requestExec.execute(wrapper, managedConn, context);
                        retrying = false;
                        
                    } catch (IOException ex) {
                        this.log.debug("Closing the connection.");
                        managedConn.close();
                        if (retryHandler.retryRequest(ex, execCount, context)) {
                            if (this.log.isInfoEnabled()) {
                                this.log.info("I/O exception ("+ ex.getClass().getName() + 
                                        ") caught when processing request: "
                                        + ex.getMessage());
                            }
                            if (this.log.isDebugEnabled()) {
                                this.log.debug(ex.getMessage(), ex);
                            }
                            this.log.info("Retrying request");
                        } else {
                            throw ex;
                        }

                        // If we have a direct route to the target host
                        // just re-open connection and re-try the request
                        if (route.getHopCount() == 1) {
                            this.log.debug("Reopening the direct connection.");
                            managedConn.open(route, context, params);
                        } else {
                            // otherwise give up
                            throw ex;
                        }
                        
                    }

                }

                // Run response protocol interceptors
                response.setParams(params);
                requestExec.postProcess(response, httpProcessor, context);

                // The connection is in or can be brought to a re-usable state.
                reuse = reuseStrategy.keepAlive(response, context);
                if(reuse) {
                    // Set the idle duration of this connection
                    long duration = keepAliveStrategy.getKeepAliveDuration(response, context);
                    managedConn.setIdleDuration(duration, TimeUnit.MILLISECONDS);
                }
                
                RoutedRequest followup = handleResponse(roureq, response, context);
                if (followup == null) {
                    done = true;
                } else {
                    if (reuse) {
                        this.log.debug("Connection kept alive");
                        // Make sure the response body is fully consumed, if present
                        HttpEntity entity = response.getEntity();
                        if (entity != null) {
                            entity.consumeContent();
                        }
                        // entity consumed above is not an auto-release entity,
                        // need to mark the connection re-usable explicitly
                        managedConn.markReusable();
                    } else {
                        managedConn.close();
                    }
                    // check if we can use the same connection for the followup
                    if (!followup.getRoute().equals(roureq.getRoute())) {
                        releaseConnection();
                    }
                    roureq = followup;
                }
                
                userToken = this.userTokenHandler.getUserToken(context);
                context.setAttribute(ClientContext.USER_TOKEN, userToken);
                if (managedConn != null) {
                    managedConn.setState(userToken);
                }
            } // while not done

            // check for entity, release connection if possible
            if ((response == null) || (response.getEntity() == null) ||
                !response.getEntity().isStreaming()) {
                // connection not needed and (assumed to be) in re-usable state
                if (reuse)
                    managedConn.markReusable();
                releaseConnection();
            } else {
                // install an auto-release entity
                HttpEntity entity = response.getEntity();
                entity = new BasicManagedEntity(entity, managedConn, reuse);
                response.setEntity(entity);
            }

            return response;
            
        } catch (HttpException ex) {
            abortConnection();
            throw ex;
        } catch (IOException ex) {
            abortConnection();
            throw ex;
        } catch (RuntimeException ex) {
            abortConnection();
            throw ex;
        }
    } // execute

    /**
     * Returns the connection back to the connection manager
     * and prepares for retrieving a new connection during
     * the next request.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.923 -0500", hash_original_method = "72FBB2C6656BE4AE3AB40DA6CB70F970", hash_generated_method = "8BE1B8153A027B32D41BF07FD000777A")
    
protected void releaseConnection() {
        // Release the connection through the ManagedConnection instead of the
        // ConnectionManager directly.  This lets the connection control how
        // it is released.
        try {
            managedConn.releaseConnection();
        } catch(IOException ignored) {
            this.log.debug("IOException releasing connection", ignored);
        }
        managedConn = null;
    }

    /**
     * Determines the route for a request.
     * Called by {@link #execute}
     * to determine the route for either the original or a followup request.
     *
     * @param target    the target host for the request.
     *                  Implementations may accept <code>null</code>
     *                  if they can still determine a route, for example
     *                  to a default target or by inspecting the request.
     * @param request   the request to execute
     * @param context   the context to use for the execution,
     *                  never <code>null</code>
     *
     * @return  the route the request should take
     *
     * @throws HttpException    in case of a problem
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.926 -0500", hash_original_method = "855E342C251EB2356D381DD4230A53C3", hash_generated_method = "A332452DAA3A752D6FC6722C5C72039F")
    
protected HttpRoute determineRoute(HttpHost    target,
                                           HttpRequest request,
                                           HttpContext context)
        throws HttpException {

        if (target == null) {
            target = (HttpHost) request.getParams().getParameter(
                ClientPNames.DEFAULT_HOST);
        }
        if (target == null) {
            // BEGIN android-changed
            //     If the URI was malformed, make it obvious where there's no host component
            String scheme = null;
            String host = null;
            String path = null;
            URI uri;
            if (request instanceof HttpUriRequest
                    && (uri = ((HttpUriRequest) request).getURI()) != null) {
                scheme = uri.getScheme();
                host = uri.getHost();
                path = uri.getPath();
            }
            throw new IllegalStateException( "Target host must not be null, or set in parameters."
                    + " scheme=" + scheme + ", host=" + host + ", path=" + path);
            // END android-changed
        }

        return this.routePlanner.determineRoute(target, request, context);
    }

    /**
     * Establishes the target route.
     *
     * @param route     the route to establish
     * @param context   the context for the request execution
     *
     * @throws HttpException    in case of a problem
     * @throws IOException      in case of an IO problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.929 -0500", hash_original_method = "7601A49E11EC8C911923D57ABD663D23", hash_generated_method = "93361CD9C318CE622A8DACDDD93D80AA")
    
protected void establishRoute(HttpRoute route, HttpContext context)
        throws HttpException, IOException {

        //@@@ how to handle CONNECT requests for tunnelling?
        //@@@ refuse to send external CONNECT via director? special handling?

        //@@@ should the request parameters already be used below?
        //@@@ probably yes, but they're not linked yet
        //@@@ will linking above cause problems with linking in reqExec?
        //@@@ probably not, because the parent is replaced
        //@@@ just make sure we don't link parameters to themselves

        HttpRouteDirector rowdy = new BasicRouteDirector();
        int step;
        do {
            HttpRoute fact = managedConn.getRoute();
            step = rowdy.nextStep(route, fact);

            switch (step) {

            case HttpRouteDirector.CONNECT_TARGET:
            case HttpRouteDirector.CONNECT_PROXY:
                managedConn.open(route, context, this.params);
                break;

            case HttpRouteDirector.TUNNEL_TARGET: {
                boolean secure = createTunnelToTarget(route, context);
                this.log.debug("Tunnel to target created.");
                managedConn.tunnelTarget(secure, this.params);
            }   break;

            case HttpRouteDirector.TUNNEL_PROXY: {
                // The most simple example for this case is a proxy chain
                // of two proxies, where P1 must be tunnelled to P2.
                // route: Source -> P1 -> P2 -> Target (3 hops)
                // fact:  Source -> P1 -> Target       (2 hops)
                final int hop = fact.getHopCount()-1; // the hop to establish
                boolean secure = createTunnelToProxy(route, hop, context);
                this.log.debug("Tunnel to proxy created.");
                managedConn.tunnelProxy(route.getHopTarget(hop),
                                        secure, this.params);
            }   break;

            case HttpRouteDirector.LAYER_PROTOCOL:
                managedConn.layerProtocol(context, this.params);
                break;

            case HttpRouteDirector.UNREACHABLE:
                throw new IllegalStateException
                    ("Unable to establish route." +
                     "\nplanned = " + route +
                     "\ncurrent = " + fact);

            case HttpRouteDirector.COMPLETE:
                // do nothing
                break;

            default:
                throw new IllegalStateException
                    ("Unknown step indicator "+step+" from RouteDirector.");
            } // switch

        } while (step > HttpRouteDirector.COMPLETE);

    } // establishConnection

    /**
     * Creates a tunnel to the target server.
     * The connection must be established to the (last) proxy.
     * A CONNECT request for tunnelling through the proxy will
     * be created and sent, the response received and checked.
     * This method does <i>not</i> update the connection with
     * information about the tunnel, that is left to the caller.
     *
     * @param route     the route to establish
     * @param context   the context for request execution
     *
     * @return  <code>true</code> if the tunnelled route is secure,
     *          <code>false</code> otherwise.
     *          The implementation here always returns <code>false</code>,
     *          but derived classes may override.
     *
     * @throws HttpException    in case of a problem
     * @throws IOException      in case of an IO problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.934 -0500", hash_original_method = "135ABB51CD042C7BF2D35A5F6450399E", hash_generated_method = "863385F4DDF4E2867E79479775F0563A")
    
protected boolean createTunnelToTarget(HttpRoute route,
                                           HttpContext context)
        throws HttpException, IOException {

        HttpHost proxy = route.getProxyHost();
        HttpHost target = route.getTargetHost();
        HttpResponse response = null;
        
        boolean done = false;
        while (!done) {

            done = true;
            
            if (!this.managedConn.isOpen()) {
                this.managedConn.open(route, context, this.params);
            }
            
            HttpRequest connect = createConnectRequest(route, context);
            
            String agent = HttpProtocolParams.getUserAgent(params);
            if (agent != null) {
                connect.addHeader(HTTP.USER_AGENT, agent);
            }
            connect.addHeader(HTTP.TARGET_HOST, target.toHostString());
            
            AuthScheme authScheme = this.proxyAuthState.getAuthScheme();
            AuthScope authScope = this.proxyAuthState.getAuthScope();
            Credentials creds = this.proxyAuthState.getCredentials();
            if (creds != null) {
                if (authScope != null || !authScheme.isConnectionBased()) {
                    try {
                        connect.addHeader(authScheme.authenticate(creds, connect));
                    } catch (AuthenticationException ex) {
                        if (this.log.isErrorEnabled()) {
                            this.log.error("Proxy authentication error: " + ex.getMessage());
                        }
                    }
                }
            }
            
            response = requestExec.execute(connect, this.managedConn, context);
            
            int status = response.getStatusLine().getStatusCode();
            if (status < 200) {
                throw new HttpException("Unexpected response to CONNECT request: " +
                        response.getStatusLine());
            }
            
            CredentialsProvider credsProvider = (CredentialsProvider)
                context.getAttribute(ClientContext.CREDS_PROVIDER);
            
            if (credsProvider != null && HttpClientParams.isAuthenticating(params)) {
                if (this.proxyAuthHandler.isAuthenticationRequested(response, context)) {

                    this.log.debug("Proxy requested authentication");
                    Map<String, Header> challenges = this.proxyAuthHandler.getChallenges(
                            response, context);
                    try {
                        processChallenges(
                                challenges, this.proxyAuthState, this.proxyAuthHandler, 
                                response, context);
                    } catch (AuthenticationException ex) {
                        if (this.log.isWarnEnabled()) {
                            this.log.warn("Authentication error: " +  ex.getMessage());
                            break;
                        }
                    }
                    updateAuthState(this.proxyAuthState, proxy, credsProvider);
                    
                    if (this.proxyAuthState.getCredentials() != null) {
                        done = false;

                        // Retry request
                        if (this.reuseStrategy.keepAlive(response, context)) {
                            this.log.debug("Connection kept alive");
                            // Consume response content
                            HttpEntity entity = response.getEntity();
                            if (entity != null) {
                                entity.consumeContent();
                            }                
                        } else {
                            this.managedConn.close();
                        }
                        
                    }
                    
                } else {
                    // Reset proxy auth scope
                    this.proxyAuthState.setAuthScope(null);
                }
            }
        }
        
        int status = response.getStatusLine().getStatusCode();

        if (status > 299) {

            // Buffer response content
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                response.setEntity(new BufferedHttpEntity(entity));
            }
            
            this.managedConn.close();
            throw new TunnelRefusedException("CONNECT refused by proxy: " +
                    response.getStatusLine(), response);
        }

        this.managedConn.markReusable();
        
        // How to decide on security of the tunnelled connection?
        // The socket factory knows only about the segment to the proxy.
        // Even if that is secure, the hop to the target may be insecure.
        // Leave it to derived classes, consider insecure by default here.
        return false;

    } // createTunnelToTarget

    /**
     * Creates a tunnel to an intermediate proxy.
     * This method is <i>not</i> implemented in this class.
     * It just throws an exception here.
     *
     * @param route     the route to establish
     * @param hop       the hop in the route to establish now.
     *                  <code>route.getHopTarget(hop)</code>
     *                  will return the proxy to tunnel to.
     * @param context   the context for request execution
     *
     * @return  <code>true</code> if the partially tunnelled connection
     *          is secure, <code>false</code> otherwise.
     *
     * @throws HttpException    in case of a problem
     * @throws IOException      in case of an IO problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.936 -0500", hash_original_method = "F6C0B77A6F010BA1F972A9366C7E6CE6", hash_generated_method = "7E55AD8D0773EBBDA8B51AD34E5BAF6B")
    
protected boolean createTunnelToProxy(HttpRoute route, int hop,
                                          HttpContext context)
        throws HttpException, IOException {

        // Have a look at createTunnelToTarget and replicate the parts
        // you need in a custom derived class. If your proxies don't require
        // authentication, it is not too hard. But for the stock version of
        // HttpClient, we cannot make such simplifying assumptions and would
        // have to include proxy authentication code. The HttpComponents team
        // is currently not in a position to support rarely used code of this
        // complexity. Feel free to submit patches that refactor the code in
        // createTunnelToTarget to facilitate re-use for proxy tunnelling.

        throw new UnsupportedOperationException
            ("Proxy chains are not supported.");
    }

    /**
     * Creates the CONNECT request for tunnelling.
     * Called by {@link #createTunnelToTarget createTunnelToTarget}.
     *
     * @param route     the route to establish
     * @param context   the context for request execution
     *
     * @return  the CONNECT request for tunnelling
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.939 -0500", hash_original_method = "7799E26CF8933DA985404F8B4CB5983A", hash_generated_method = "DCF19388C8A870851BDAE2D1C0669598")
    
protected HttpRequest createConnectRequest(HttpRoute route,
                                               HttpContext context) {
        // see RFC 2817, section 5.2 and 
        // INTERNET-DRAFT: Tunneling TCP based protocols through 
        // Web proxy servers
            
        HttpHost target = route.getTargetHost();
        
        String host = target.getHostName();
        int port = target.getPort();
        if (port < 0) {
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

        return req;
    }

    /**
     * Analyzes a response to check need for a followup.
     *
     * @param roureq    the request and route. 
     * @param response  the response to analayze
     * @param context   the context used for the current request execution
     *
     * @return  the followup request and route if there is a followup, or
     *          <code>null</code> if the response should be returned as is
     *
     * @throws HttpException    in case of a problem
     * @throws IOException      in case of an IO problem
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.943 -0500", hash_original_method = "E253F133593C4FA5CC62D333761B1C94", hash_generated_method = "24E27C826C46B023BB99412DF746179B")
    
protected RoutedRequest handleResponse(RoutedRequest roureq,
                                           HttpResponse response,
                                           HttpContext context)
        throws HttpException, IOException {

        HttpRoute route = roureq.getRoute();
        HttpHost proxy = route.getProxyHost();
        RequestWrapper request = roureq.getRequest();
        
        HttpParams params = request.getParams();
        if (HttpClientParams.isRedirecting(params) && 
                this.redirectHandler.isRedirectRequested(response, context)) {

            if (redirectCount >= maxRedirects) {
                throw new RedirectException("Maximum redirects ("
                        + maxRedirects + ") exceeded");
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
            
            if (this.log.isDebugEnabled()) {
                this.log.debug("Redirecting to '" + uri + "' via " + newRoute);
            }
            
            return newRequest;
        }

        CredentialsProvider credsProvider = (CredentialsProvider)
            context.getAttribute(ClientContext.CREDS_PROVIDER);
    
        if (credsProvider != null && HttpClientParams.isAuthenticating(params)) {

            if (this.targetAuthHandler.isAuthenticationRequested(response, context)) {

                HttpHost target = (HttpHost)
                    context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
                if (target == null) {
                    target = route.getTargetHost();
                }
                
                this.log.debug("Target requested authentication");
                Map<String, Header> challenges = this.targetAuthHandler.getChallenges(
                        response, context); 
                try {
                    processChallenges(challenges, 
                            this.targetAuthState, this.targetAuthHandler,
                            response, context);
                } catch (AuthenticationException ex) {
                    if (this.log.isWarnEnabled()) {
                        this.log.warn("Authentication error: " +  ex.getMessage());
                        return null;
                    }
                }
                updateAuthState(this.targetAuthState, target, credsProvider);
                
                if (this.targetAuthState.getCredentials() != null) {
                    // Re-try the same request via the same route
                    return roureq;
                } else {
                    return null;
                }
            } else {
                // Reset target auth scope
                this.targetAuthState.setAuthScope(null);
            }
            
            if (this.proxyAuthHandler.isAuthenticationRequested(response, context)) {

                this.log.debug("Proxy requested authentication");
                Map<String, Header> challenges = this.proxyAuthHandler.getChallenges(
                        response, context);
                try {
                    processChallenges(challenges, 
                            this.proxyAuthState, this.proxyAuthHandler, 
                            response, context);
                } catch (AuthenticationException ex) {
                    if (this.log.isWarnEnabled()) {
                        this.log.warn("Authentication error: " +  ex.getMessage());
                        return null;
                    }
                }
                updateAuthState(this.proxyAuthState, proxy, credsProvider);
                
                if (this.proxyAuthState.getCredentials() != null) {
                    // Re-try the same request via the same route
                    return roureq;
                } else {
                    return null;
                }
            } else {
                // Reset proxy auth scope
                this.proxyAuthState.setAuthScope(null);
            }
        }
        return null;
    } // handleResponse

    /**
     * Shuts down the connection.
     * This method is called from a <code>catch</code> block in
     * {@link #execute execute} during exception handling.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.946 -0500", hash_original_method = "1B42C243E9B570B37B5AA18DF368B31A", hash_generated_method = "6068E21F3A76D203B26A018E1BECEB31")
    
private void abortConnection() {
        ManagedClientConnection mcc = managedConn;
        if (mcc != null) {
            // we got here as the result of an exception
            // no response will be returned, release the connection
            managedConn = null;
            try {
                mcc.abortConnection();
            } catch (IOException ex) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug(ex.getMessage(), ex);
                }
            }
            // ensure the connection manager properly releases this connection
            try {
                mcc.releaseConnection();
            } catch(IOException ignored) {
                this.log.debug("Error releasing connection", ignored);
            }
        }
    } // abortConnection

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.949 -0500", hash_original_method = "582621DB4D93E0412F3CDB3DDE871FB7", hash_generated_method = "83C7CA03A31FEC6F6006FB8DE25DCE8F")
    
private void processChallenges(
            final Map<String, Header> challenges, 
            final AuthState authState,
            final AuthenticationHandler authHandler,
            final HttpResponse response, 
            final HttpContext context) 
                throws MalformedChallengeException, AuthenticationException {
        
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null) {
            // Authentication not attempted before
            authScheme = authHandler.selectScheme(challenges, response, context);
            authState.setAuthScheme(authScheme);
        }
        String id = authScheme.getSchemeName();

        Header challenge = challenges.get(id.toLowerCase(Locale.ENGLISH));
        if (challenge == null) {
            throw new AuthenticationException(id + 
                " authorization challenge expected, but not found");
        }
        authScheme.processChallenge(challenge);
        this.log.debug("Authorization challenge processed");
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.952 -0500", hash_original_method = "48429FCD8E54925B92F9CF361D5F9B0A", hash_generated_method = "ADD32D1227248CB9BD42747DB98E512A")
    
private void updateAuthState(
            final AuthState authState, 
            final HttpHost host,
            final CredentialsProvider credsProvider) {
        
        if (!authState.isValid()) {
            return;
        }
        
        String hostname = host.getHostName();
        int port = host.getPort();
        if (port < 0) {
            Scheme scheme = connManager.getSchemeRegistry().getScheme(host);
            port = scheme.getDefaultPort();
        }
        
        AuthScheme authScheme = authState.getAuthScheme();
        AuthScope authScope = new AuthScope(
                hostname,
                port,
                authScheme.getRealm(), 
                authScheme.getSchemeName());
        
        if (this.log.isDebugEnabled()) {
            this.log.debug("Authentication scope: " + authScope);
        }
        Credentials creds = authState.getCredentials();
        if (creds == null) {
            creds = credsProvider.getCredentials(authScope);
            if (this.log.isDebugEnabled()) {
                if (creds != null) {
                    this.log.debug("Found credentials");
                } else {
                    this.log.debug("Credentials not found");
                }
            }
        } else {
            if (authScheme.isComplete()) {
                this.log.debug("Authentication failed");
                creds = null;
            }
        }
        authState.setAuthScope(authScope);
        authState.setCredentials(creds);
    }
    
}

