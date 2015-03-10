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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/HttpRequestExecutor.java $
 * $Revision: 576073 $
 * $Date: 2007-09-16 03:53:13 -0700 (Sun, 16 Sep 2007) $
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


package org.apache.http.protocol;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.ProtocolException;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.params.CoreProtocolPNames;

public class HttpRequestExecutor {

    /**
     * Create a new request executor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.065 -0500", hash_original_method = "1B3D6EB0D2C9672C0490DD487A44B10E", hash_generated_method = "FCD633531AD55B8EC2ADF8EE06DBC285")
    
public HttpRequestExecutor() {
        super();
    }

    /**
     * Decide whether a response comes with an entity.
     * The implementation in this class is based on RFC 2616.
     * Unknown methods and response codes are supposed to
     * indicate responses with an entity.
     * <br/>
     * Derived executors can override this method to handle
     * methods and response codes not specified in RFC 2616.
     *
     * @param request   the request, to obtain the executed method
     * @param response  the response, to obtain the status code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.068 -0500", hash_original_method = "0630A8D079D2F2EA09859A2EAC923D24", hash_generated_method = "207D2E135165673D977230B8DEEA32C8")
    
protected boolean canResponseHaveBody(final HttpRequest request,
                                          final HttpResponse response) {

        if ("HEAD".equalsIgnoreCase(request.getRequestLine().getMethod())) {
            return false;
        }
        int status = response.getStatusLine().getStatusCode(); 
        return status >= HttpStatus.SC_OK 
            && status != HttpStatus.SC_NO_CONTENT 
            && status != HttpStatus.SC_NOT_MODIFIED
            && status != HttpStatus.SC_RESET_CONTENT; 
    }

    /**
     * Synchronously send a request and obtain the response.
     *
     * @param request   the request to send. It will be preprocessed.
     * @param conn      the open connection over which to send
     *
     * @return  the response to the request, postprocessed
     *
     * @throws HttpException      in case of a protocol or processing problem
     * @throws IOException        in case of an I/O problem
     */    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.071 -0500", hash_original_method = "119B944BAA4C5EE6E8AB8C1C74A61B19", hash_generated_method = "A8E9502B09A98175D880412D3ACED0A2")
    
public HttpResponse execute(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context) 
                throws IOException, HttpException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (conn == null) {
            throw new IllegalArgumentException("Client connection may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }

        try {
            HttpResponse response = doSendRequest(request, conn, context);
            if (response == null) {
                response = doReceiveResponse(request, conn, context);
            }
            return response;
        } catch (IOException ex) {
            conn.close();
            throw ex;
        } catch (HttpException ex) {
            conn.close();
            throw ex;
        } catch (RuntimeException ex) {
            conn.close();
            throw ex;
        }
    }

    /**
     * Prepare a request for sending.
     *
     * @param request   the request to prepare
     * @param processor the processor to use
     * @param context   the context for sending the request
     *
     * @throws HttpException      in case of a protocol or processing problem
     * @throws IOException        in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.073 -0500", hash_original_method = "83559981E73A0A11E2E39D8FF1D4E53C", hash_generated_method = "351C03041EC146E740980031705F280D")
    
public void preProcess(
            final HttpRequest request,
            final HttpProcessor processor,
            final HttpContext context)
                throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (processor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        processor.process(request, context);
    }

    /**
     * Send a request over a connection.
     * This method also handles the expect-continue handshake if necessary.
     * If it does not have to handle an expect-continue handshake, it will
     * not use the connection for reading or anything else that depends on
     * data coming in over the connection.
     *
     * @param request   the request to send, already
     *                  {@link #preProcess preprocessed}
     * @param conn      the connection over which to send the request,
     *                  already established
     * @param context   the context for sending the request
     *
     * @return  a terminal response received as part of an expect-continue
     *          handshake, or
     *          <code>null</code> if the expect-continue handshake is not used
     *
     * @throws HttpException      in case of a protocol or processing problem
     * @throws IOException        in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.077 -0500", hash_original_method = "3A0BDE86F44AAAE489AB1403F9B488D7", hash_generated_method = "A33312CA1EC96ADA3F27F09206D257AA")
    
protected HttpResponse doSendRequest(
            final HttpRequest request,
            final HttpClientConnection conn,
            final HttpContext context)
                throws IOException, HttpException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (conn == null) {
            throw new IllegalArgumentException("HTTP connection may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }

        HttpResponse response = null;
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.FALSE);

        conn.sendRequestHeader(request);
        if (request instanceof HttpEntityEnclosingRequest) {
            // Check for expect-continue handshake. We have to flush the
            // headers and wait for an 100-continue response to handle it.
            // If we get a different response, we must not send the entity.
            boolean sendentity = true;
            final ProtocolVersion ver =
                request.getRequestLine().getProtocolVersion();
            if (((HttpEntityEnclosingRequest) request).expectContinue() &&
                !ver.lessEquals(HttpVersion.HTTP_1_0)) {

                conn.flush();
                // As suggested by RFC 2616 section 8.2.3, we don't wait for a
                // 100-continue response forever. On timeout, send the entity.
                int tms = request.getParams().getIntParameter(
                        CoreProtocolPNames.WAIT_FOR_CONTINUE, 2000);
                
                if (conn.isResponseAvailable(tms)) {
                    response = conn.receiveResponseHeader();
                    if (canResponseHaveBody(request, response)) {
                        conn.receiveResponseEntity(response);
                    }
                    int status = response.getStatusLine().getStatusCode();
                    if (status < 200) {
                        if (status != HttpStatus.SC_CONTINUE) {
                            throw new ProtocolException(
                                    "Unexpected response: " + response.getStatusLine());
                        }
                        // discard 100-continue
                        response = null;
                    } else {
                        sendentity = false;
                    }
                }
            }
            if (sendentity) {
                conn.sendRequestEntity((HttpEntityEnclosingRequest) request);
            }
        }
        conn.flush();
        context.setAttribute(ExecutionContext.HTTP_REQ_SENT, Boolean.TRUE);
        return response;
    }

    /**
     * Wait for and receive a response.
     * This method will automatically ignore intermediate responses
     * with status code 1xx.
     *
     * @param request   the request for which to obtain the response
     * @param conn      the connection over which the request was sent
     * @param context   the context for receiving the response
     *
     * @return  the final response, not yet post-processed
     *
     * @throws HttpException      in case of a protocol or processing problem
     * @throws IOException        in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.080 -0500", hash_original_method = "ACD44B1A55AB2BB7AB7058E66F36FB4A", hash_generated_method = "6B7A5B5AAB4EAC371C836C89930F94EF")
    
protected HttpResponse doReceiveResponse(
            final HttpRequest          request,
            final HttpClientConnection conn,
            final HttpContext          context)
                throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        if (conn == null) {
            throw new IllegalArgumentException("HTTP connection may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }

        HttpResponse response = null;
        int statuscode = 0;

        while (response == null || statuscode < HttpStatus.SC_OK) {

            response = conn.receiveResponseHeader();
            if (canResponseHaveBody(request, response)) {
                conn.receiveResponseEntity(response);
            }
            statuscode = response.getStatusLine().getStatusCode();

        } // while intermediate response

        return response;

    }

    /**
     * Finish a response.
     * This includes post-processing of the response object.
     * It does <i>not</i> read the response entity, if any.
     * It does <i>not</i> allow for immediate re-use of the
     * connection over which the response is coming in.
     *
     * @param response  the response object to finish
     * @param processor the processor to use
     * @param context   the context for post-processing the response
     *
     * @throws HttpException      in case of a protocol or processing problem
     * @throws IOException        in case of an I/O problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:47.083 -0500", hash_original_method = "64184DC5B382438058CC5473730574C6", hash_generated_method = "5A6E1628CDDCFD728C0DA065C4D778FE")
    
public void postProcess(
            final HttpResponse response,
            final HttpProcessor processor,
            final HttpContext context)
                throws HttpException, IOException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        if (processor == null) {
            throw new IllegalArgumentException("HTTP processor may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        processor.process(response, context);
    }
    
}

