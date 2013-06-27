package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "34C401953BC184959C583775D7C02C06", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private EntitySerializer entityserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "77792E7E7655F0E861F5CAD282D40817", hash_generated_field = "18C47D09329E968B5EC7364123601CF5")

    private EntityDeserializer entitydeserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "DC681AA2DD2A0BE47CBDD78540D5A8BD", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    private SessionInputBuffer inbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "2CF5A5642A030530FB530CE6AD73F644", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "DB8812B4E966D02D51AD945C2DE68D19", hash_generated_field = "0B27CE0B99168065998D8DF5303269B9")

    private HttpMessageParser responseParser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "715711ECB9730DA286C315F4B203F1D7", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.936 -0400", hash_original_field = "E6899A7B60D3CD0F0F3E11DDE4844FF7", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.937 -0400", hash_original_method = "69689155BD098727A81CB27002CF309C", hash_generated_method = "41F36C3FEDE28B35D52F3A06E3DE2D75")
    public  AbstractHttpClientConnection() {
        super();
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
        // ---------- Original Method ----------
        //this.entityserializer = createEntitySerializer();
        //this.entitydeserializer = createEntityDeserializer();
    }

    
    protected abstract void assertOpen() throws IllegalStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.950 -0400", hash_original_method = "DBD25E48E38888EDD7F8AA52F5A67EB4", hash_generated_method = "1CF89586E7E8F882838F10ACCEACD568")
    protected EntityDeserializer createEntityDeserializer() {
        EntityDeserializer varB4EAC82CA7396A68D541C85D26508E83_207549545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_207549545 = new EntityDeserializer(new LaxContentLengthStrategy());
        varB4EAC82CA7396A68D541C85D26508E83_207549545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_207549545;
        // ---------- Original Method ----------
        //return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.951 -0400", hash_original_method = "FD78F978388B59B364B21C2EBA485800", hash_generated_method = "DCCDFA6A374A48C04F917AD871825023")
    protected EntitySerializer createEntitySerializer() {
        EntitySerializer varB4EAC82CA7396A68D541C85D26508E83_931128476 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_931128476 = new EntitySerializer(new StrictContentLengthStrategy());
        varB4EAC82CA7396A68D541C85D26508E83_931128476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_931128476;
        // ---------- Original Method ----------
        //return new EntitySerializer(new StrictContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.951 -0400", hash_original_method = "104F821730DDF9B7746DC5273A66A390", hash_generated_method = "D04A756F6CF40A037EEE77E71CED9EF0")
    protected HttpResponseFactory createHttpResponseFactory() {
        HttpResponseFactory varB4EAC82CA7396A68D541C85D26508E83_433931565 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_433931565 = new DefaultHttpResponseFactory();
        varB4EAC82CA7396A68D541C85D26508E83_433931565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_433931565;
        // ---------- Original Method ----------
        //return new DefaultHttpResponseFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.952 -0400", hash_original_method = "590F41C6A05F783E2ACF6324D4108D68", hash_generated_method = "E8605A699872EBDF8FDADE97194C552A")
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        HttpMessageParser varB4EAC82CA7396A68D541C85D26508E83_1502894243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1502894243 = new HttpResponseParser(buffer, null, responseFactory, params);
        addTaint(buffer.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1502894243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1502894243;
        // ---------- Original Method ----------
        //return new HttpResponseParser(buffer, null, responseFactory, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.953 -0400", hash_original_method = "C896FAADCB31646EC56EC7195247A646", hash_generated_method = "E739CFB10C38701534536E4CE5B8A284")
    protected HttpMessageWriter createRequestWriter(
            final SessionOutputBuffer buffer,
            final HttpParams params) {
        HttpMessageWriter varB4EAC82CA7396A68D541C85D26508E83_1259981269 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1259981269 = new HttpRequestWriter(buffer, null, params);
        addTaint(buffer.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1259981269.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1259981269;
        // ---------- Original Method ----------
        //return new HttpRequestWriter(buffer, null, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.970 -0400", hash_original_method = "93CFFEDE975E0BAA8FD0589F36E92815", hash_generated_method = "92D0B69B523E9169335449A258A6C701")
    protected void init(
            final SessionInputBuffer inbuffer,
            final SessionOutputBuffer outbuffer,
            final HttpParams params) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Input session buffer may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Output session buffer may not be null");
        } //End block
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
        // ---------- Original Method ----------
        //if (inbuffer == null) {
            //throw new IllegalArgumentException("Input session buffer may not be null");
        //}
        //if (outbuffer == null) {
            //throw new IllegalArgumentException("Output session buffer may not be null");
        //}
        //this.inbuffer = inbuffer;
        //this.outbuffer = outbuffer;
        //this.responseParser = createResponseParser(
                //inbuffer, 
                //createHttpResponseFactory(), 
                //params);
        //this.requestWriter = createRequestWriter(
                //outbuffer, params);
        //this.metrics = new HttpConnectionMetricsImpl(
                //inbuffer.getMetrics(),
                //outbuffer.getMetrics());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.971 -0400", hash_original_method = "EC2664454103C0151B5CF1E9311C3275", hash_generated_method = "598CF6ED2A7D9572394E482818238DED")
    public boolean isResponseAvailable(int timeout) throws IOException {
        assertOpen();
        boolean var7BB3BD63323C3D4DAD760BA0936CF448_1878501384 = (this.inbuffer.isDataAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472939342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_472939342;
        // ---------- Original Method ----------
        //assertOpen();
        //return this.inbuffer.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.972 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "CC0A22F18D01871DE3703B67106DA60F")
    public void sendRequestHeader(final HttpRequest request) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        assertOpen();
        this.requestWriter.write(request);
        this.metrics.incrementRequestCount();
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //assertOpen();
        //this.requestWriter.write(request);
        //this.metrics.incrementRequestCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.980 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "9DDDB4FB6EB939A90A982FC2C0C3EFF4")
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        assertOpen();
        {
            boolean varD49B899B4DAE647F6EFF10130B7BC7C1_1961718870 = (request.getEntity() == null);
        } //End collapsed parenthetic
        this.entityserializer.serialize(
                this.outbuffer,
                request,
                request.getEntity());
        addTaint(request.getTaint());
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //assertOpen();
        //if (request.getEntity() == null) {
            //return;
        //}
        //this.entityserializer.serialize(
                //this.outbuffer,
                //request,
                //request.getEntity());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.983 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        // ---------- Original Method ----------
        //this.outbuffer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.984 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        // ---------- Original Method ----------
        //assertOpen();
        //doFlush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.984 -0400", hash_original_method = "D806319F8045D19DF3AF6D1ED4567F14", hash_generated_method = "D5AF8BB9F234C8DC4173CBBBD36BD45F")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1300388189 = null; //Variable for return #1
        assertOpen();
        HttpResponse response;
        response = (HttpResponse) this.responseParser.parse();
        {
            boolean varB5B2EC3425FB899C45C158916CB752AD_575738449 = (response.getStatusLine().getStatusCode() >= 200);
            {
                this.metrics.incrementResponseCount();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1300388189 = response;
        varB4EAC82CA7396A68D541C85D26508E83_1300388189.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1300388189;
        // ---------- Original Method ----------
        //assertOpen();
        //HttpResponse response = (HttpResponse) this.responseParser.parse();
        //if (response.getStatusLine().getStatusCode() >= 200) {
            //this.metrics.incrementResponseCount();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:15.991 -0400", hash_original_method = "2E1029469FDE3C3BDBC517B380DCF73B", hash_generated_method = "72D7F40C2F83278E587D05C7A0D1A56C")
    public void receiveResponseEntity(final HttpResponse response) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        assertOpen();
        HttpEntity entity;
        entity = this.entitydeserializer.deserialize(this.inbuffer, response);
        response.setEntity(entity);
        addTaint(response.getTaint());
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //assertOpen();
        //HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, response);
        //response.setEntity(entity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.005 -0400", hash_original_method = "DD669E10200A1B56B0064A07B14E647E", hash_generated_method = "E508F3F8F65585E7C31B933C00876313")
    public boolean isStale() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_1836784317 = (!isOpen());
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var2FEEA41B390182DA2C49083FDE33E2E5_1223711581 = (((SocketInputBuffer) inbuffer).isStale());
            } //End block
            this.inbuffer.isDataAvailable(1);
        } //End block
        catch (IOException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_471975372 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_471975372;
        // ---------- Original Method ----------
        //if (!isOpen()) {
            //return true;
        //}
        //try {
            //if (inbuffer instanceof SocketInputBuffer) {
                //return ((SocketInputBuffer) inbuffer).isStale();
            //}
            //this.inbuffer.isDataAvailable(1);
            //return false;
        //} catch (IOException ex) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:16.013 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "20099D793F83D594E9A00C2B472EFCD0")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_2019184772 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2019184772 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_2019184772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2019184772;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

