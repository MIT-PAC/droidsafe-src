/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/io/HttpRequestParser.java $
 * $Revision: 589374 $
 * $Date: 2007-10-28 09:25:07 -0700 (Sun, 28 Oct 2007) $
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

package org.apache.http.impl.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequestFactory;
import org.apache.http.RequestLine;
import org.apache.http.ParseException;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.LineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public class HttpRequestParser extends AbstractMessageParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.089 -0400", hash_original_field = "262527A2B1C73FAE121A8DA8A40DC5C4", hash_generated_field = "C8A78F08C68285A01F01B036EB1BF179")

    
    private  HttpRequestFactory requestFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.090 -0400", hash_original_field = "FC03653F373BA80D3DD2EC29A605B1FD", hash_generated_field = "138A98BD7AF16A46911F2E280FBA40A5")

    private  CharArrayBuffer lineBuf;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.091 -0400", hash_original_method = "70769E86B899A170E784F9B2BC548ECA", hash_generated_method = "6E09CF2318F8D6DF0F6462D864316134")
    
public HttpRequestParser(
            final SessionInputBuffer buffer, 
            final LineParser parser,
            final HttpRequestFactory requestFactory,
            final HttpParams params) {
        super(buffer, parser, params);
        if (requestFactory == null) {
            throw new IllegalArgumentException("Request factory may not be null");
        }
        this.requestFactory = requestFactory;
        this.lineBuf = new CharArrayBuffer(128);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.091 -0400", hash_original_method = "1553418440CA46B2F1E39722DC0196B7", hash_generated_method = "977503CF6588B8C3B665484ED7227AA0")
    
protected HttpMessage parseHead(
            final SessionInputBuffer sessionBuffer)
        throws IOException, HttpException, ParseException {

        this.lineBuf.clear();
        int i = sessionBuffer.readLine(this.lineBuf);
        if (i == -1) {
            throw new ConnectionClosedException("Client closed connection"); 
        }
        ParserCursor cursor = new ParserCursor(0, this.lineBuf.length());
        RequestLine requestline = this.lineParser.parseRequestLine(this.lineBuf, cursor);
        return this.requestFactory.newHttpRequest(requestline);
    }
    
}
