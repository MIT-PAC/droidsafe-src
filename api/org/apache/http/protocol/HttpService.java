/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/HttpService.java $
 * $Revision: 610763 $
 * $Date: 2008-01-10 04:01:13 -0800 (Thu, 10 Jan 2008) $
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

package org.apache.http.protocol;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.HttpServerConnection;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.MethodNotSupportedException;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.UnsupportedHttpVersionException;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpParams;
import org.apache.http.params.DefaultedHttpParams;
import org.apache.http.util.EncodingUtils;

/**
 * Minimalistic server-side implementation of an HTTP processor.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 610763 $
 */
public class HttpService {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.835 -0400", hash_original_field = "F6D59FA244250A5706D18F5DF4148123", hash_generated_field = "6E53DC81F0880FD043DC91867FCCD969")


    private HttpParams params = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.835 -0400", hash_original_field = "12D7A426F7256B2F83E1138218C261F0", hash_generated_field = "DFEF273C3F53417F62DDC18A17C32857")

    private HttpProcessor processor = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.836 -0400", hash_original_field = "1E869ADA1414883AA2913F8F4C04BB12", hash_generated_field = "571813F0DC7CB80E80F76B6EF8C5E680")

    private HttpRequestHandlerResolver handlerResolver = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.836 -0400", hash_original_field = "1ACDC03A7FC33D24DC65399D210748F9", hash_generated_field = "C18A58553A5B24B5C5F108FB2ED6447B")

    private ConnectionReuseStrategy connStrategy = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.837 -0400", hash_original_field = "A8B42C5F8E6B804B2D28ED6CF27E7A95", hash_generated_field = "3638ACD8034D569D1CC55EC480441E0B")

    private HttpResponseFactory responseFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.837 -0400", hash_original_field = "EE63AE92566EA8E589A2C61F3579AC79", hash_generated_field = "604965E521FCFD263A309573D7A5F922")

    private HttpExpectationVerifier expectationVerifier = null;
    
    /**
     * Create a new HTTP service.
     *
     * @param proc             the processor to use on requests and responses
     * @param connStrategy     the connection reuse strategy
     * @param responseFactory  the response factory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.838 -0400", hash_original_method = "B344CD189BA7D1BDB7605103D52B5490", hash_generated_method = "A21034D3BD494D96EA24AA81098D5498")
    
public HttpService(
            final HttpProcessor proc,
            final ConnectionReuseStrategy connStrategy,
            final HttpResponseFactory responseFactory) {
        super();
        setHttpProcessor(proc);
        setConnReuseStrategy(connStrategy);
        setResponseFactory(responseFactory);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.839 -0400", hash_original_method = "604E4A0AE66A89E3F190356B22533C68", hash_generated_method = "E9C19AE1AFBBF139EE6E49EF6F92E7C3")
    
public void setHttpProcessor(final HttpProcessor processor) {
        if (processor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null.");
        }
        this.processor = processor;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.840 -0400", hash_original_method = "7DE2377FEBBE6B38E6B8658602E01168", hash_generated_method = "D1DB89FC4D4A1064040FB906E2E2F36D")
    
public void setConnReuseStrategy(final ConnectionReuseStrategy connStrategy) {
        if (connStrategy == null) {
            throw new IllegalArgumentException("Connection reuse strategy may not be null");
        }
        this.connStrategy = connStrategy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.840 -0400", hash_original_method = "2239A030A8C23CE22C1E02EE859E51BF", hash_generated_method = "59DA4146F51D13D75E7A7E6A4FEB615F")
    
public void setResponseFactory(final HttpResponseFactory responseFactory) {
        if (responseFactory == null) {
            throw new IllegalArgumentException("Response factory may not be null");
        }
        this.responseFactory = responseFactory;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.841 -0400", hash_original_method = "368976D2D2568FCE07E581535F100976", hash_generated_method = "5C40C6747A4FC4DDCACF9BF399183A38")
    
public void setHandlerResolver(final HttpRequestHandlerResolver handlerResolver) {
        this.handlerResolver = handlerResolver;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.842 -0400", hash_original_method = "9862968A26EBAA2912AA02E0B55591BB", hash_generated_method = "D7D5D68F482A5A46B37EB85C739F837A")
    
public void setExpectationVerifier(final HttpExpectationVerifier expectationVerifier) {
        this.expectationVerifier = expectationVerifier;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.842 -0400", hash_original_method = "F091AAF8F24EFA19FFAA73C7CC3FCCD0", hash_generated_method = "126EC88B1D6F3807CDDE7509650606D1")
    
public HttpParams getParams() {
        return this.params;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.843 -0400", hash_original_method = "FC82965372EA5BD6142AF119D44F2F42", hash_generated_method = "24511E79B367B4A5B0FAF739171B9E2D")
    
public void setParams(final HttpParams params) {
        this.params = params;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.845 -0400", hash_original_method = "A1638B93DB0C8868BC0C9607BE6791FA", hash_generated_method = "5058E1119728A6B6FF8C343CD471DBE7")
    
public void handleRequest(
            final HttpServerConnection conn, 
            final HttpContext context) throws IOException, HttpException { 
        
        context.setAttribute(ExecutionContext.HTTP_CONNECTION, conn);

        HttpResponse response = null;
        
        try {

            HttpRequest request = conn.receiveRequestHeader();
            request.setParams(
                    new DefaultedHttpParams(request.getParams(), this.params));
            
            ProtocolVersion ver =
                request.getRequestLine().getProtocolVersion();
            if (!ver.lessEquals(HttpVersion.HTTP_1_1)) {
                // Downgrade protocol version if greater than HTTP/1.1 
                ver = HttpVersion.HTTP_1_1;
            }

            if (request instanceof HttpEntityEnclosingRequest) {

                if (((HttpEntityEnclosingRequest) request).expectContinue()) {
                    response = this.responseFactory.newHttpResponse(ver, 
                            HttpStatus.SC_CONTINUE, context);
                    response.setParams(
                            new DefaultedHttpParams(response.getParams(), this.params));
                    
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(request, response, context);
                        } catch (HttpException ex) {
                            response = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, 
                                    HttpStatus.SC_INTERNAL_SERVER_ERROR, context);
                            response.setParams(
                                    new DefaultedHttpParams(response.getParams(), this.params));
                            handleException(ex, response);
                        }
                    }
                    if (response.getStatusLine().getStatusCode() < 200) {
                        // Send 1xx response indicating the server expections
                        // have been met
                        conn.sendResponseHeader(response);
                        conn.flush();
                        response = null;
                        conn.receiveRequestEntity((HttpEntityEnclosingRequest) request);
                    }
                } else {
                    conn.receiveRequestEntity((HttpEntityEnclosingRequest) request);
                }
            }

            if (response == null) {
                response = this.responseFactory.newHttpResponse(ver, HttpStatus.SC_OK, context);
                response.setParams(
                        new DefaultedHttpParams(response.getParams(), this.params));

                context.setAttribute(ExecutionContext.HTTP_REQUEST, request);
                context.setAttribute(ExecutionContext.HTTP_RESPONSE, response);

                this.processor.process(request, context);
                doService(request, response, context);
            }
            
            // Make sure the request content is fully consumed
            if (request instanceof HttpEntityEnclosingRequest) {
                HttpEntity entity = ((HttpEntityEnclosingRequest)request).getEntity();
                if (entity != null) {
                    entity.consumeContent();
                }
            }
            
        } catch (HttpException ex) {
            response = this.responseFactory.newHttpResponse
                (HttpVersion.HTTP_1_0, HttpStatus.SC_INTERNAL_SERVER_ERROR,
                 context);
            response.setParams(
                    new DefaultedHttpParams(response.getParams(), this.params));
            handleException(ex, response);
        }
        
        this.processor.process(response, context);
        conn.sendResponseHeader(response);
        conn.sendResponseEntity(response);
        conn.flush();
        
        if (!this.connStrategy.keepAlive(response, context)) {
            conn.close();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.846 -0400", hash_original_method = "B072FA7F18EBA093428866F9D5422514", hash_generated_method = "D6470D679F79D5FA1580E45E91B91B0E")
    
protected void handleException(final HttpException ex, final HttpResponse response) {
        if (ex instanceof MethodNotSupportedException) {
            response.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        } else if (ex instanceof UnsupportedHttpVersionException) {
            response.setStatusCode(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
        } else if (ex instanceof ProtocolException) {
            response.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        } else {
            response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
        }
        byte[] msg = EncodingUtils.getAsciiBytes(ex.getMessage());
        ByteArrayEntity entity = new ByteArrayEntity(msg);
        entity.setContentType("text/plain; charset=US-ASCII");
        response.setEntity(entity);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:33.846 -0400", hash_original_method = "11C823280D0704542F29323D209E313C", hash_generated_method = "D715099EF82284176CFD3A08B0E95B25")
    
protected void doService(
            final HttpRequest request, 
            final HttpResponse response,
            final HttpContext context) throws HttpException, IOException {
        HttpRequestHandler handler = null;
        if (this.handlerResolver != null) {
            String requestURI = request.getRequestLine().getUri();
            handler = this.handlerResolver.lookup(requestURI);
        }
        if (handler != null) {
            handler.handle(request, response, context);
        } else {
            response.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        }
    }
    
}
