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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/protocol/ResponseConnControl.java $
 * $Revision: 618017 $
 * $Date: 2008-02-03 08:42:22 -0800 (Sun, 03 Feb 2008) $
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;

/**
 * A response interceptor that suggests connection keep-alive to the client.
 * For use on the server side.
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 618017 $
 * 
 * @since 4.0
 */
public class ResponseConnControl implements HttpResponseInterceptor {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.231 -0400", hash_original_method = "35742010D58AA41C5E78EA9BB2862199", hash_generated_method = "5575BDDD4F7BA1E96427FE6CC6108A50")
    
public ResponseConnControl() {
        super();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:34.232 -0400", hash_original_method = "F66F62FCF51768C7CF3609573511E171", hash_generated_method = "2D6CE2ACF985F8489866485F0E6231AC")
    
public void process(final HttpResponse response, final HttpContext context) 
            throws HttpException, IOException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        if (context == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        }
        // Always drop connection after certain type of responses
        int status = response.getStatusLine().getStatusCode();
        if (status == HttpStatus.SC_BAD_REQUEST ||
                status == HttpStatus.SC_REQUEST_TIMEOUT ||
                status == HttpStatus.SC_LENGTH_REQUIRED ||
                status == HttpStatus.SC_REQUEST_TOO_LONG ||
                status == HttpStatus.SC_REQUEST_URI_TOO_LONG ||
                status == HttpStatus.SC_SERVICE_UNAVAILABLE ||
                status == HttpStatus.SC_NOT_IMPLEMENTED) {
            response.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
            return;
        }
        // Always drop connection for HTTP/1.0 responses and below
        // if the content body cannot be correctly delimited
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
            if (entity.getContentLength() < 0 && 
                    (!entity.isChunked() || ver.lessEquals(HttpVersion.HTTP_1_0))) {
                response.setHeader(HTTP.CONN_DIRECTIVE, HTTP.CONN_CLOSE);
                return;
            }
        }
        // Drop connection if requested by the client
        HttpRequest request = (HttpRequest)
            context.getAttribute(ExecutionContext.HTTP_REQUEST);
        if (request != null) {
            Header header = request.getFirstHeader(HTTP.CONN_DIRECTIVE);
            if (header != null) {
                response.setHeader(HTTP.CONN_DIRECTIVE, header.getValue());
            }
        }
    }
    
}
