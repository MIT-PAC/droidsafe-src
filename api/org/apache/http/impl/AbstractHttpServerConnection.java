/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpcore/trunk/module-main/src/main/java/org/apache/http/impl/AbstractHttpServerConnection.java $
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

package org.apache.http.impl;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpServerConnection;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.HttpRequestParser;
import org.apache.http.impl.io.HttpResponseWriter;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

/**
 * Abstract server-side HTTP connection capable of transmitting and receiving data
 * using arbitrary {@link SessionInputBuffer} and {@link SessionOutputBuffer}
 *
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 *
 * @version $Revision: 618017 $
 * 
 * @since 4.0
 */
public abstract class AbstractHttpServerConnection implements HttpServerConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.395 -0400", hash_original_field = "FDB5A9B9AD2A7A41FA2463863E97E07B", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")


    private  EntitySerializer entityserializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.395 -0400", hash_original_field = "3DB3DE348EF92E8314529FAB3E53A3B1", hash_generated_field = "18C47D09329E968B5EC7364123601CF5")

    private  EntityDeserializer entitydeserializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.396 -0400", hash_original_field = "51AEA610F55961E2DEAE8E33F14CC584", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    
    private SessionInputBuffer inbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.396 -0400", hash_original_field = "D37E01EB8D7F3CC9AD7133D08AB04720", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.397 -0400", hash_original_field = "D4E03C1285C669902BA02AF458E53E12", hash_generated_field = "FF83958BE8D747977A3EE20CE372DEA8")

    private HttpMessageParser requestParser = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.397 -0400", hash_original_field = "818E4F06C092866B999A03DAEA6CC078", hash_generated_field = "7226D73EB10C827C217B46ADCF3B06A2")

    private HttpMessageWriter responseWriter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.398 -0400", hash_original_field = "10648022F55E6D4D6A7E5414064AE29D", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;



    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.398 -0400", hash_original_method = "5EEF386D2F585EBB7845F38C9EC33A1F", hash_generated_method = "A0CF6AE70DB73F2185101322278466CA")
    
public AbstractHttpServerConnection() {
        super();
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.399 -0400", hash_original_method = "EF4FADE4978E6DA370360ABA2B74DC2C", hash_generated_method = "4E6BDA68E7F48D8A30EC00B433E66123")
    
protected abstract void assertOpen() throws IllegalStateException;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.399 -0400", hash_original_method = "DBD25E48E38888EDD7F8AA52F5A67EB4", hash_generated_method = "F94AC6A6020A76CE5A0CF441214459CB")
    
protected EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.400 -0400", hash_original_method = "FD78F978388B59B364B21C2EBA485800", hash_generated_method = "C551CB028316DBAB414F232D5A47FCE2")
    
protected EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.400 -0400", hash_original_method = "7E59AE287CC6586A6AD59B39B55B2004", hash_generated_method = "A9D9827C17494F49B931789C68464A56")
    
protected HttpRequestFactory createHttpRequestFactory() {
        return new DefaultHttpRequestFactory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.401 -0400", hash_original_method = "4DF9584DCD7D01BCCD1ECC9C66DE45DD", hash_generated_method = "6F4C19FF8583751DC3DE56DFC194D50F")
    
protected HttpMessageParser createRequestParser(
            final SessionInputBuffer buffer,
            final HttpRequestFactory requestFactory,
            final HttpParams params) {
        // override in derived class to specify a line parser
        return new HttpRequestParser(buffer, null, requestFactory, params);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.401 -0400", hash_original_method = "527A9576692C6E719A4A2300B8C062D9", hash_generated_method = "0BF96B2984168E27CFEEA8B5AEEF0097")
    
protected HttpMessageWriter createResponseWriter(
            final SessionOutputBuffer buffer,
            final HttpParams params) {
        // override in derived class to specify a line formatter
        return new HttpResponseWriter(buffer, null, params);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.402 -0400", hash_original_method = "70FA0796F0489E5C9604208D2EE92580", hash_generated_method = "4145AAD0983D8AC5909460BC6AFEF1A6")
    
protected void init(
            final SessionInputBuffer inbuffer,
            final SessionOutputBuffer outbuffer,
            final HttpParams params) {
        if (inbuffer == null) {
            throw new IllegalArgumentException("Input session buffer may not be null");
        }
        if (outbuffer == null) {
            throw new IllegalArgumentException("Output session buffer may not be null");
        }
        this.inbuffer = inbuffer;
        this.outbuffer = outbuffer;
        this.requestParser = createRequestParser(
                inbuffer, 
                createHttpRequestFactory(), 
                params);
        this.responseWriter = createResponseWriter(
                outbuffer, params);
        this.metrics = new HttpConnectionMetricsImpl(
                inbuffer.getMetrics(),
                outbuffer.getMetrics());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.403 -0400", hash_original_method = "4A365D63DFBE5F36579F5530591664E3", hash_generated_method = "739F1A8D470C563DBB04829175902829")
    
public HttpRequest receiveRequestHeader() 
            throws HttpException, IOException {
        assertOpen();
        HttpRequest request = (HttpRequest) this.requestParser.parse();
        this.metrics.incrementRequestCount();
        return request;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.403 -0400", hash_original_method = "DBB703C7DB23DFB15E3594D14FA4F6BB", hash_generated_method = "FCC9F94EABA49151E7D5FBF3CA70F1D5")
    
public void receiveRequestEntity(final HttpEntityEnclosingRequest request) 
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, request);
        request.setEntity(entity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.404 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "95B55363290D586DFB2DF36999E3EB5A")
    
protected void doFlush() throws IOException  {
        this.outbuffer.flush();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.404 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "7DC12AEDC1E3BAC50748171377DE0490")
    
public void flush() throws IOException {
        assertOpen();
        doFlush();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.405 -0400", hash_original_method = "58537AE62B5A52DB91AAB96486234164", hash_generated_method = "DDB109C0AB48E49DC0D8DE724EFEB215")
    
public void sendResponseHeader(final HttpResponse response) 
            throws HttpException, IOException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        assertOpen();
        this.responseWriter.write(response);
        if (response.getStatusLine().getStatusCode() >= 200) {
            this.metrics.incrementResponseCount();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.405 -0400", hash_original_method = "2032EA9B9BAC46CA127C60480B977083", hash_generated_method = "D2B8767AB7AB714F5450790BE55BCAA9")
    
public void sendResponseEntity(final HttpResponse response) 
            throws HttpException, IOException {
        if (response.getEntity() == null) {
            return;
        }
        this.entityserializer.serialize(
                this.outbuffer,
                response,
                response.getEntity());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.406 -0400", hash_original_method = "3BE812D13F4292433A7C6B8D5ADAC2E8", hash_generated_method = "1EAD57D36840D6CAEA4FEE7766AE3376")
    
public boolean isStale() {
        assertOpen();
        try {
            this.inbuffer.isDataAvailable(1);
            return false;
        } catch (IOException ex) {
            return true;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:46.406 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "7AD9A1BFEB710F66C989015EA8C10499")
    
public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }

}
