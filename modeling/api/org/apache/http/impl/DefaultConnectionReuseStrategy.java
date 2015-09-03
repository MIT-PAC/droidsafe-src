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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/DefaultConnectionReuseStrategy.java $
 * $Revision: 602537 $
 * $Date: 2007-12-08 11:42:06 -0800 (Sat, 08 Dec 2007) $
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


package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.TokenIterator;
import org.apache.http.message.BasicTokenIterator;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {

    @DSComment("possible networking data collection or keeping secure connection open")
    @DSSpec(DSCat.NETWORKING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.597 -0500", hash_original_method = "34BE1FD46571091C81AAB19A83E6EA86", hash_generated_method = "86528F5F65914F5929E8417F1AFC209E")
    
public DefaultConnectionReuseStrategy() {
        super();
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    // see interface ConnectionReuseStrategy
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.602 -0500", hash_original_method = "99701CE5AD38D49B49A62B2892241655", hash_generated_method = "9C5EAA05C0FE23320E5792BD37C1027B")
    
public boolean keepAlive(final HttpResponse response,
                             final HttpContext context) {
        if (response == null) {
            throw new IllegalArgumentException
                ("HTTP response may not be null.");
        }
        if (context == null) {
            throw new IllegalArgumentException
                ("HTTP context may not be null.");
        }
        
        HttpConnection conn = (HttpConnection)
            context.getAttribute(ExecutionContext.HTTP_CONNECTION);

        if (conn != null && !conn.isOpen())
            return false;
        // do NOT check for stale connection, that is an expensive operation

        // Check for a self-terminating entity. If the end of the entity will
        // be indicated by closing the connection, there is no keep-alive.
        HttpEntity entity = response.getEntity();
        ProtocolVersion ver = response.getStatusLine().getProtocolVersion();
        if (entity != null) {
            if (entity.getContentLength() < 0) {
                if (!entity.isChunked() ||
                    ver.lessEquals(HttpVersion.HTTP_1_0)) {
                    // if the content length is not known and is not chunk
                    // encoded, the connection cannot be reused
                    return false;
                }
            }
        }

        // Check for the "Connection" header. If that is absent, check for
        // the "Proxy-Connection" header. The latter is an unspecified and
        // broken but unfortunately common extension of HTTP.
        HeaderIterator hit = response.headerIterator(HTTP.CONN_DIRECTIVE);
        if (!hit.hasNext())
            hit = response.headerIterator("Proxy-Connection");

        // Experimental usage of the "Connection" header in HTTP/1.0 is
        // documented in RFC 2068, section 19.7.1. A token "keep-alive" is
        // used to indicate that the connection should be persistent.
        // Note that the final specification of HTTP/1.1 in RFC 2616 does not
        // include this information. Neither is the "Connection" header
        // mentioned in RFC 1945, which informally describes HTTP/1.0.
        //
        // RFC 2616 specifies "close" as the only connection token with a
        // specific meaning: it disables persistent connections.
        //
        // The "Proxy-Connection" header is not formally specified anywhere,
        // but is commonly used to carry one token, "close" or "keep-alive".
        // The "Connection" header, on the other hand, is defined as a
        // sequence of tokens, where each token is a header name, and the
        // token "close" has the above-mentioned additional meaning.
        //
        // To get through this mess, we treat the "Proxy-Connection" header
        // in exactly the same way as the "Connection" header, but only if
        // the latter is missing. We scan the sequence of tokens for both
        // "close" and "keep-alive". As "close" is specified by RFC 2068,
        // it takes precedence and indicates a non-persistent connection.
        // If there is no "close" but a "keep-alive", we take the hint.

        if (hit.hasNext()) {
            try {
                TokenIterator ti = createTokenIterator(hit);
                boolean keepalive = false;
                while (ti.hasNext()) {
                    final String token = ti.nextToken();
                    if (HTTP.CONN_CLOSE.equalsIgnoreCase(token)) {
                        return false;
                    } else if (HTTP.CONN_KEEP_ALIVE.equalsIgnoreCase(token)) {
                        // continue the loop, there may be a "close" afterwards
                        keepalive = true;
                    }
                }
                if (keepalive)
                    return true;
                // neither "close" nor "keep-alive", use default policy

            } catch (ParseException px) {
                // invalid connection header means no persistent connection
                // we don't have logging in HttpCore, so the exception is lost
                return false;
            }
        }

        // default since HTTP/1.1 is persistent, before it was non-persistent
        return !ver.lessEquals(HttpVersion.HTTP_1_0);
    }

    /**
     * Creates a token iterator from a header iterator.
     * This method can be overridden to replace the implementation of
     * the token iterator.
     *
     * @param hit       the header iterator
     *
     * @return  the token iterator
     */
    @DSComment("no suspicious activity, only creates object")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:41.604 -0500", hash_original_method = "EFAD97F429DE8DB8F9E4AB7241876CEE", hash_generated_method = "F267F4777920ABE45213A1BBDCEC5A8C")
    
protected TokenIterator createTokenIterator(HeaderIterator hit) {
        return new BasicTokenIterator(hit);
    }
    
}

