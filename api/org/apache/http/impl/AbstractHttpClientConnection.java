package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.impl.entity.EntityDeserializer;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.LaxContentLengthStrategy;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.HttpRequestWriter;
import org.apache.http.impl.io.HttpResponseParser;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

public abstract class AbstractHttpClientConnection implements HttpClientConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.491 -0500", hash_original_field = "FDB5A9B9AD2A7A41FA2463863E97E07B", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private  EntitySerializer entityserializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.494 -0500", hash_original_field = "3DB3DE348EF92E8314529FAB3E53A3B1", hash_generated_field = "18C47D09329E968B5EC7364123601CF5")

    private  EntityDeserializer entitydeserializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.496 -0500", hash_original_field = "51AEA610F55961E2DEAE8E33F14CC584", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")
    
    private SessionInputBuffer inbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.499 -0500", hash_original_field = "D37E01EB8D7F3CC9AD7133D08AB04720", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.501 -0500", hash_original_field = "EC0C96F8B2BEC81B6BA9E2D3AB59820E", hash_generated_field = "0B27CE0B99168065998D8DF5303269B9")

    private HttpMessageParser responseParser = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.503 -0500", hash_original_field = "C92B1D7A604A0991F570C5C22AE92582", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.505 -0500", hash_original_field = "10648022F55E6D4D6A7E5414064AE29D", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.508 -0500", hash_original_method = "69689155BD098727A81CB27002CF309C", hash_generated_method = "E5AF705A59AF0D1E36D9FB31C022A11A")
    
public AbstractHttpClientConnection() {
        super();
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.510 -0500", hash_original_method = "EF4FADE4978E6DA370360ABA2B74DC2C", hash_generated_method = "4E6BDA68E7F48D8A30EC00B433E66123")
    
protected abstract void assertOpen() throws IllegalStateException;

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.513 -0500", hash_original_method = "DBD25E48E38888EDD7F8AA52F5A67EB4", hash_generated_method = "F94AC6A6020A76CE5A0CF441214459CB")
    
protected EntityDeserializer createEntityDeserializer() {
        return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.515 -0500", hash_original_method = "FD78F978388B59B364B21C2EBA485800", hash_generated_method = "C551CB028316DBAB414F232D5A47FCE2")
    
protected EntitySerializer createEntitySerializer() {
        return new EntitySerializer(new StrictContentLengthStrategy());
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.517 -0500", hash_original_method = "104F821730DDF9B7746DC5273A66A390", hash_generated_method = "BD3C38DFD68281D67A8C50CD800A221A")
    
protected HttpResponseFactory createHttpResponseFactory() {
        return new DefaultHttpResponseFactory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.519 -0500", hash_original_method = "590F41C6A05F783E2ACF6324D4108D68", hash_generated_method = "DBDCFB2E7D4ED3DED729AAC5CDA5F9D2")
    
protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        // override in derived class to specify a line parser
        return new HttpResponseParser(buffer, null, responseFactory, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.522 -0500", hash_original_method = "C896FAADCB31646EC56EC7195247A646", hash_generated_method = "888FE466F7E8C16A08702D0C56BE2E88")
    
protected HttpMessageWriter createRequestWriter(
            final SessionOutputBuffer buffer,
            final HttpParams params) {
        // override in derived class to specify a line formatter
        return new HttpRequestWriter(buffer, null, params);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.524 -0500", hash_original_method = "93CFFEDE975E0BAA8FD0589F36E92815", hash_generated_method = "64512B6EB789D57FBE5EC9EA83FBACAB")
    
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
        this.responseParser = createResponseParser(
                inbuffer, 
                createHttpResponseFactory(), 
                params);
        this.requestWriter = createRequestWriter(
                outbuffer, params);
        this.metrics = new HttpConnectionMetricsImpl(
                inbuffer.getMetrics(),
                outbuffer.getMetrics());
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.526 -0500", hash_original_method = "EC2664454103C0151B5CF1E9311C3275", hash_generated_method = "C1DCF2F80EADE6F7C7D86F039D50AEC4")
    
public boolean isResponseAvailable(int timeout) throws IOException {
        assertOpen();
        return this.inbuffer.isDataAvailable(timeout);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.529 -0500", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "81445D5814C6BEA82945B6FFD6FF302A")
    
public void sendRequestHeader(final HttpRequest request) 
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        this.requestWriter.write(request);
        this.metrics.incrementRequestCount();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.531 -0500", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "238D8AF41F3258C0147B298BF895C371")
    
public void sendRequestEntity(final HttpEntityEnclosingRequest request) 
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        if (request.getEntity() == null) {
            return;
        }
        this.entityserializer.serialize(
                this.outbuffer,
                request,
                request.getEntity());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.533 -0500", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "95B55363290D586DFB2DF36999E3EB5A")
    
protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.536 -0500", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "7DC12AEDC1E3BAC50748171377DE0490")
    
public void flush() throws IOException {
        assertOpen();
        doFlush();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.538 -0500", hash_original_method = "D806319F8045D19DF3AF6D1ED4567F14", hash_generated_method = "CB962EA7CC6656E0B5EC6E492D1795B3")
    
public HttpResponse receiveResponseHeader() 
            throws HttpException, IOException {
        assertOpen();
        HttpResponse response = (HttpResponse) this.responseParser.parse();
        if (response.getStatusLine().getStatusCode() >= 200) {
            this.metrics.incrementResponseCount();
        }
        return response;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.540 -0500", hash_original_method = "2E1029469FDE3C3BDBC517B380DCF73B", hash_generated_method = "B6ECA66AD54B706F39CBB15215FF98B8")
    
public void receiveResponseEntity(final HttpResponse response)
            throws HttpException, IOException {
        if (response == null) {
            throw new IllegalArgumentException("HTTP response may not be null");
        }
        assertOpen();
        HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, response);
        response.setEntity(entity);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.543 -0500", hash_original_method = "DD669E10200A1B56B0064A07B14E647E", hash_generated_method = "31439310ED3662DDA0907AAD323462FF")
    
public boolean isStale() {
        if (!isOpen()) {
            return true;
        }
        try {
            // BEGIN android-added
            //     don't reuse connections when the socket input stream is exhausted
            if (inbuffer instanceof SocketInputBuffer) {
                return ((SocketInputBuffer) inbuffer).isStale();
            }
            // END android-added
            this.inbuffer.isDataAvailable(1);
            return false;
        } catch (IOException ex) {
            return true;
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:43.545 -0500", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "7AD9A1BFEB710F66C989015EA8C10499")
    
public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }
    
}

