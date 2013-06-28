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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "34C401953BC184959C583775D7C02C06", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private EntitySerializer entityserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "77792E7E7655F0E861F5CAD282D40817", hash_generated_field = "18C47D09329E968B5EC7364123601CF5")

    private EntityDeserializer entitydeserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "DC681AA2DD2A0BE47CBDD78540D5A8BD", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    private SessionInputBuffer inbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "2CF5A5642A030530FB530CE6AD73F644", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "DB8812B4E966D02D51AD945C2DE68D19", hash_generated_field = "0B27CE0B99168065998D8DF5303269B9")

    private HttpMessageParser responseParser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "715711ECB9730DA286C315F4B203F1D7", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.665 -0400", hash_original_field = "E6899A7B60D3CD0F0F3E11DDE4844FF7", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.666 -0400", hash_original_method = "69689155BD098727A81CB27002CF309C", hash_generated_method = "41F36C3FEDE28B35D52F3A06E3DE2D75")
    public  AbstractHttpClientConnection() {
        super();
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
        // ---------- Original Method ----------
        //this.entityserializer = createEntitySerializer();
        //this.entitydeserializer = createEntityDeserializer();
    }

    
    protected abstract void assertOpen() throws IllegalStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.666 -0400", hash_original_method = "DBD25E48E38888EDD7F8AA52F5A67EB4", hash_generated_method = "9E3EB8ECDEBE65F536B17CEABF36C9FF")
    protected EntityDeserializer createEntityDeserializer() {
        EntityDeserializer varB4EAC82CA7396A68D541C85D26508E83_77563949 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_77563949 = new EntityDeserializer(new LaxContentLengthStrategy());
        varB4EAC82CA7396A68D541C85D26508E83_77563949.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_77563949;
        // ---------- Original Method ----------
        //return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.667 -0400", hash_original_method = "FD78F978388B59B364B21C2EBA485800", hash_generated_method = "4FF55403A4FCCD801E6D5E575DA11C2F")
    protected EntitySerializer createEntitySerializer() {
        EntitySerializer varB4EAC82CA7396A68D541C85D26508E83_299541032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_299541032 = new EntitySerializer(new StrictContentLengthStrategy());
        varB4EAC82CA7396A68D541C85D26508E83_299541032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_299541032;
        // ---------- Original Method ----------
        //return new EntitySerializer(new StrictContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.667 -0400", hash_original_method = "104F821730DDF9B7746DC5273A66A390", hash_generated_method = "3D3E5A1F03FCE058A4FE382DDB5DBB5D")
    protected HttpResponseFactory createHttpResponseFactory() {
        HttpResponseFactory varB4EAC82CA7396A68D541C85D26508E83_809456034 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_809456034 = new DefaultHttpResponseFactory();
        varB4EAC82CA7396A68D541C85D26508E83_809456034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_809456034;
        // ---------- Original Method ----------
        //return new DefaultHttpResponseFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.667 -0400", hash_original_method = "590F41C6A05F783E2ACF6324D4108D68", hash_generated_method = "6D7FCD7F4526F18AE9688E6C22541C0B")
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        HttpMessageParser varB4EAC82CA7396A68D541C85D26508E83_166596185 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_166596185 = new HttpResponseParser(buffer, null, responseFactory, params);
        addTaint(buffer.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_166596185.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_166596185;
        // ---------- Original Method ----------
        //return new HttpResponseParser(buffer, null, responseFactory, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.668 -0400", hash_original_method = "C896FAADCB31646EC56EC7195247A646", hash_generated_method = "043AE55F80D6A84420C2C88628A30D63")
    protected HttpMessageWriter createRequestWriter(
            final SessionOutputBuffer buffer,
            final HttpParams params) {
        HttpMessageWriter varB4EAC82CA7396A68D541C85D26508E83_970742689 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_970742689 = new HttpRequestWriter(buffer, null, params);
        addTaint(buffer.getTaint());
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_970742689.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_970742689;
        // ---------- Original Method ----------
        //return new HttpRequestWriter(buffer, null, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.669 -0400", hash_original_method = "93CFFEDE975E0BAA8FD0589F36E92815", hash_generated_method = "92D0B69B523E9169335449A258A6C701")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.669 -0400", hash_original_method = "EC2664454103C0151B5CF1E9311C3275", hash_generated_method = "54BD827256A0918520DA91674306C3E6")
    public boolean isResponseAvailable(int timeout) throws IOException {
        assertOpen();
        boolean var7BB3BD63323C3D4DAD760BA0936CF448_2007243056 = (this.inbuffer.isDataAvailable(timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1167738905 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1167738905;
        // ---------- Original Method ----------
        //assertOpen();
        //return this.inbuffer.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.670 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "CC0A22F18D01871DE3703B67106DA60F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.670 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "2A74400B028DDB0686082F96C664BC63")
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        assertOpen();
        {
            boolean varD49B899B4DAE647F6EFF10130B7BC7C1_1744796849 = (request.getEntity() == null);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.671 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        // ---------- Original Method ----------
        //this.outbuffer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.671 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        // ---------- Original Method ----------
        //assertOpen();
        //doFlush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.671 -0400", hash_original_method = "D806319F8045D19DF3AF6D1ED4567F14", hash_generated_method = "37D0178F9DF70EA4A29194FC81F7B923")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse varB4EAC82CA7396A68D541C85D26508E83_1936570091 = null; //Variable for return #1
        assertOpen();
        HttpResponse response = (HttpResponse) this.responseParser.parse();
        {
            boolean varB5B2EC3425FB899C45C158916CB752AD_1364722319 = (response.getStatusLine().getStatusCode() >= 200);
            {
                this.metrics.incrementResponseCount();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1936570091 = response;
        varB4EAC82CA7396A68D541C85D26508E83_1936570091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1936570091;
        // ---------- Original Method ----------
        //assertOpen();
        //HttpResponse response = (HttpResponse) this.responseParser.parse();
        //if (response.getStatusLine().getStatusCode() >= 200) {
            //this.metrics.incrementResponseCount();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.672 -0400", hash_original_method = "2E1029469FDE3C3BDBC517B380DCF73B", hash_generated_method = "EA8D0AF71CE0433260E894AC22EDF819")
    public void receiveResponseEntity(final HttpResponse response) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP response may not be null");
        } //End block
        assertOpen();
        HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, response);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.672 -0400", hash_original_method = "DD669E10200A1B56B0064A07B14E647E", hash_generated_method = "4C2A46B0C0940B33344A71D8BDDDF6E8")
    public boolean isStale() {
        {
            boolean var3A7D61B68AE823F6A30349D498C59A5C_142733822 = (!isOpen());
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var2FEEA41B390182DA2C49083FDE33E2E5_1158668686 = (((SocketInputBuffer) inbuffer).isStale());
            } //End block
            this.inbuffer.isDataAvailable(1);
        } //End block
        catch (IOException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161530362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161530362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:39.673 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "19F9C933C6A3539EEDA47E07773C88EC")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_1695421355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1695421355 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_1695421355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695421355;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

