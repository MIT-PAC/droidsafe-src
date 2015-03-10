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
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/AbstractMessageParser.java $
 * $Revision: 576077 $
 * $Date: 2007-09-16 04:50:22 -0700 (Sun, 16 Sep 2007) $
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


package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageParser implements HttpMessageParser {

    /**
     * Parses HTTP headers from the data receiver stream according to the generic 
     * format as given in Section 3.1 of RFC 822, RFC-2616 Section 4 and 19.3.
     *  
     * @param inbuffer Session input buffer
     * @param maxHeaderCount maximum number of headers allowed. If the number
     *  of headers received from the data stream exceeds maxCount value, an
     *  IOException will be thrown. Setting this parameter to a negative value
     *  or zero  will disable the check.
     * @param maxLineLen maximum number of characters for a header line,
     *                   including the continuation lines
     * @return array of HTTP headers
     * 
     * @throws HttpException
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.694 -0500", hash_original_method = "2B984335CEDFCBC69AB5F6A3D7DB39C1", hash_generated_method = "0BA1FC05FC31962F32B373ABA2C04A84")
    
public static Header[] parseHeaders(
            final SessionInputBuffer inbuffer,
            int maxHeaderCount,
            int maxLineLen,
            LineParser parser)
        throws HttpException, IOException {

        if (inbuffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        if (parser == null)
            parser = BasicLineParser.DEFAULT;

        ArrayList headerLines = new ArrayList();

        CharArrayBuffer current = null;
        CharArrayBuffer previous = null;
        for (;;) {
            if (current == null) {
                current = new CharArrayBuffer(64);
            } else {
                current.clear();
            }
            int l = inbuffer.readLine(current);
            if (l == -1 || current.length() < 1) {
                break;
            }
            // Parse the header name and value
            // Check for folded headers first
            // Detect LWS-char see HTTP/1.0 or HTTP/1.1 Section 2.2
            // discussion on folded headers
            if ((current.charAt(0) == ' ' || current.charAt(0) == '\t') && previous != null) {
                // we have continuation folded header
                // so append value
                int i = 0;
                while (i < current.length()) {
                    char ch = current.charAt(i);
                    if (ch != ' ' && ch != '\t') {
                        break;
                    }
                    i++;
                }
                if (maxLineLen > 0 
                        && previous.length() + 1 + current.length() - i > maxLineLen) {
                    throw new IOException("Maximum line length limit exceeded");
                }
                previous.append(' ');
                previous.append(current, i, current.length() - i);
            } else {
                headerLines.add(current);
                previous = current;
                current = null;
            }
            if (maxHeaderCount > 0 && headerLines.size() >= maxHeaderCount) {
                throw new IOException("Maximum header count exceeded");
            }
        }
        Header[] headers = new Header[headerLines.size()];
        for (int i = 0; i < headerLines.size(); i++) {
            CharArrayBuffer buffer = (CharArrayBuffer) headerLines.get(i);
            try {
                headers[i] = parser.parseHeader(buffer);
            } catch (ParseException ex) {
                throw new ProtocolException(ex.getMessage());
            }
        }
        return headers;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.681 -0500", hash_original_field = "13B47FDB2E79FE6CD90882D9DA95C973", hash_generated_field = "A33B1C99D4B1A85FF593937CE103B3DB")

    private  SessionInputBuffer sessionBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.683 -0500", hash_original_field = "F0C13102950DF6DEECC29E1050A6EEE7", hash_generated_field = "51B3B1D6F029892B5D1B485F1E8449D4")

    private  int maxHeaderCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.686 -0500", hash_original_field = "392877A4EDCAD2EFA855A1EA0D8967B1", hash_generated_field = "8BE013DE7B241F7CDF197195794AF2BA")

    private  int maxLineLen;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.688 -0500", hash_original_field = "723ECC87F42B3213E8B9AE9AA3CD7937", hash_generated_field = "FA36EAE3CC325D535A91E6794A3FA61E")

    protected  LineParser lineParser;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.691 -0500", hash_original_method = "CD9F7BFE0207530C59E31A12BA61FD32", hash_generated_method = "C56EDB0284C9BDBC66929A015DE95D08")
    
public AbstractMessageParser(
            final SessionInputBuffer buffer,
            final LineParser parser,
            final HttpParams params) {
        super();
        if (buffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        }
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        this.sessionBuffer = buffer;
        this.maxHeaderCount = params.getIntParameter(
                CoreConnectionPNames.MAX_HEADER_COUNT, -1);
        this.maxLineLen = params.getIntParameter(
                CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.lineParser = (parser != null) ? parser : BasicLineParser.DEFAULT;
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.697 -0500", hash_original_method = "6A5FF6AE0D3937AC48619DDFC949CE62", hash_generated_method = "D56D0B4E2D705C17713E8B3E7801723D")
    
protected abstract HttpMessage parseHead(SessionInputBuffer sessionBuffer) 
        throws IOException, HttpException, ParseException;

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:42.699 -0500", hash_original_method = "56FD9FE99CC7B8784E50CC19E304C067", hash_generated_method = "41264974E91E9340349EE60460B9AC40")
    
public HttpMessage parse() throws IOException, HttpException {
        HttpMessage message = null;
        try {
            message = parseHead(this.sessionBuffer);
        } catch (ParseException px) {
            throw new ProtocolException(px.getMessage(), px);
        }
        Header[] headers = AbstractMessageParser.parseHeaders(
                this.sessionBuffer, 
                this.maxHeaderCount,
                this.maxLineLen,
                this.lineParser);
        message.setHeaders(headers);
        return message;
    }
    
}

