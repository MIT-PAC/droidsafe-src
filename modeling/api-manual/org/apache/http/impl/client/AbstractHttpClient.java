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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/impl/client/AbstractHttpClient.java $
 * $Revision: 677250 $
 * $Date: 2008-07-16 04:45:47 -0700 (Wed, 16 Jul 2008) $
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

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class AbstractHttpClient implements HttpClient {
	
    private HttpParams defaultParams;
    private ClientConnectionManager connManager;
    
	// DSModeled - This field is added to help short circuit the static analysis
	//             of the http comms.
	private HttpHost target;
	
	// DSModeled - This field is added to help short circuit the static analysis
	//             of the http comms.
	private HttpRequest request;
	
	// DSModeled - This field is added to help short circuit the static analysis
	//             of the http comms.
	private HttpContext context;
	
	@DSModeled(DSC.SPEC)
	protected AbstractHttpClient(
            final ClientConnectionManager conman,
            final HttpParams params) {
		defaultParams = params;
		connManager = conman;
    }

	@DSModeled(DSC.SPEC)
	@Override
	public HttpResponse execute(HttpUriRequest request) throws IOException,
			ClientProtocolException {
		return execute(request, (HttpContext) null);
	}

	@DSModeled(DSC.SPEC)
	@Override
	public HttpResponse execute(HttpUriRequest request, HttpContext context)
			throws IOException, ClientProtocolException {
		if (request == null) {
            throw new IllegalArgumentException
                ("Request must not be null.");
        }

        return execute(determineTarget(request), request, context);
	}

	@DSModeled(DSC.SPEC)
	@Override
	public HttpResponse execute(HttpHost arg0, HttpRequest arg1)
			throws IOException, ClientProtocolException {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SPEC)
	@Override
	public <T> T execute(HttpUriRequest arg0, ResponseHandler<? extends T> arg1)
			throws IOException, ClientProtocolException {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SPEC)
	@Override
	public final HttpResponse execute(HttpHost target, HttpRequest request,
			HttpContext context) throws IOException, ClientProtocolException {
		//DSFIXME - Need to determine if short circuiting this method here
		//          is acceptable modeling.
		this.target = target;
		this.request = request;
		this.context = context;
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
	}

	@DSModeled(DSC.SPEC)
	@Override
	public <T> T execute(HttpUriRequest arg0,
			ResponseHandler<? extends T> arg1, HttpContext arg2)
			throws IOException, ClientProtocolException {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SPEC)
	@Override
	public <T> T execute(HttpHost arg0, HttpRequest arg1,
			ResponseHandler<? extends T> arg2) throws IOException,
			ClientProtocolException {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SPEC)
	@Override
	public <T> T execute(HttpHost arg0, HttpRequest arg1,
			ResponseHandler<? extends T> arg2, HttpContext arg3)
			throws IOException, ClientProtocolException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientConnectionManager getConnectionManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpParams getParams() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@DSModeled(DSC.SAFE)
	private static HttpHost determineTarget(final HttpUriRequest request) throws ClientProtocolException {

        final URI requestURI = request.getURI();
        HttpHost target = new HttpHost(requestURI.getHost());
        
        return target;
    }

}
