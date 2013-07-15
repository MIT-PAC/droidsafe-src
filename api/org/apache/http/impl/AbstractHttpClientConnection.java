package org.apache.http.impl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "34C401953BC184959C583775D7C02C06", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private EntitySerializer entityserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "77792E7E7655F0E861F5CAD282D40817", hash_generated_field = "18C47D09329E968B5EC7364123601CF5")

    private EntityDeserializer entitydeserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "DC681AA2DD2A0BE47CBDD78540D5A8BD", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    private SessionInputBuffer inbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "2CF5A5642A030530FB530CE6AD73F644", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "DB8812B4E966D02D51AD945C2DE68D19", hash_generated_field = "0B27CE0B99168065998D8DF5303269B9")

    private HttpMessageParser responseParser = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "715711ECB9730DA286C315F4B203F1D7", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_field = "E6899A7B60D3CD0F0F3E11DDE4844FF7", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_method = "69689155BD098727A81CB27002CF309C", hash_generated_method = "41F36C3FEDE28B35D52F3A06E3DE2D75")
    public  AbstractHttpClientConnection() {
        super();
        this.entityserializer = createEntitySerializer();
        this.entitydeserializer = createEntityDeserializer();
        // ---------- Original Method ----------
        //this.entityserializer = createEntitySerializer();
        //this.entitydeserializer = createEntityDeserializer();
    }

    
    protected abstract void assertOpen() throws IllegalStateException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.994 -0400", hash_original_method = "DBD25E48E38888EDD7F8AA52F5A67EB4", hash_generated_method = "0823A32C5DDF39DC2B41FB058578D467")
    protected EntityDeserializer createEntityDeserializer() {
EntityDeserializer varD8277C9FB64D708D6AAEC33B5D57A8C1_266519651 =         new EntityDeserializer(new LaxContentLengthStrategy());
        varD8277C9FB64D708D6AAEC33B5D57A8C1_266519651.addTaint(taint);
        return varD8277C9FB64D708D6AAEC33B5D57A8C1_266519651;
        // ---------- Original Method ----------
        //return new EntityDeserializer(new LaxContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "FD78F978388B59B364B21C2EBA485800", hash_generated_method = "2CA0089775789D269CEB5AEF94469D3B")
    protected EntitySerializer createEntitySerializer() {
EntitySerializer var73E805B24B914F947FB8A61049CA1B74_876298595 =         new EntitySerializer(new StrictContentLengthStrategy());
        var73E805B24B914F947FB8A61049CA1B74_876298595.addTaint(taint);
        return var73E805B24B914F947FB8A61049CA1B74_876298595;
        // ---------- Original Method ----------
        //return new EntitySerializer(new StrictContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "104F821730DDF9B7746DC5273A66A390", hash_generated_method = "0B716DF8E66A8A10EF43CAAF3AF2D94B")
    protected HttpResponseFactory createHttpResponseFactory() {
HttpResponseFactory varBC11667D6421859A3157C95B024F6BD9_993574027 =         new DefaultHttpResponseFactory();
        varBC11667D6421859A3157C95B024F6BD9_993574027.addTaint(taint);
        return varBC11667D6421859A3157C95B024F6BD9_993574027;
        // ---------- Original Method ----------
        //return new DefaultHttpResponseFactory();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "590F41C6A05F783E2ACF6324D4108D68", hash_generated_method = "738F49587A9A0AD1F4454ECDF52401AF")
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory,
            final HttpParams params) {
        addTaint(params.getTaint());
        addTaint(responseFactory.getTaint());
        addTaint(buffer.getTaint());
HttpMessageParser varB490B2FFBF849B1B42A29CDAF85ABF94_1305803939 =         new HttpResponseParser(buffer, null, responseFactory, params);
        varB490B2FFBF849B1B42A29CDAF85ABF94_1305803939.addTaint(taint);
        return varB490B2FFBF849B1B42A29CDAF85ABF94_1305803939;
        // ---------- Original Method ----------
        //return new HttpResponseParser(buffer, null, responseFactory, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "C896FAADCB31646EC56EC7195247A646", hash_generated_method = "E959E42A3D3FD65E0ADD0F3A43A921E9")
    protected HttpMessageWriter createRequestWriter(
            final SessionOutputBuffer buffer,
            final HttpParams params) {
        addTaint(params.getTaint());
        addTaint(buffer.getTaint());
HttpMessageWriter var04F23D93A84A9612B54CC0F1D40D1AB2_938552430 =         new HttpRequestWriter(buffer, null, params);
        var04F23D93A84A9612B54CC0F1D40D1AB2_938552430.addTaint(taint);
        return var04F23D93A84A9612B54CC0F1D40D1AB2_938552430;
        // ---------- Original Method ----------
        //return new HttpRequestWriter(buffer, null, params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "93CFFEDE975E0BAA8FD0589F36E92815", hash_generated_method = "FEE8F91D3672665AA0937315B61334FF")
    protected void init(
            final SessionInputBuffer inbuffer,
            final SessionOutputBuffer outbuffer,
            final HttpParams params) {
    if(inbuffer == null)        
        {
            IllegalArgumentException var09E8CD37474729E64903391667436F8D_1193771496 = new IllegalArgumentException("Input session buffer may not be null");
            var09E8CD37474729E64903391667436F8D_1193771496.addTaint(taint);
            throw var09E8CD37474729E64903391667436F8D_1193771496;
        } //End block
    if(outbuffer == null)        
        {
            IllegalArgumentException varB4FD2758188C99A80EE7A5FBD554B10A_1760803103 = new IllegalArgumentException("Output session buffer may not be null");
            varB4FD2758188C99A80EE7A5FBD554B10A_1760803103.addTaint(taint);
            throw varB4FD2758188C99A80EE7A5FBD554B10A_1760803103;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.995 -0400", hash_original_method = "EC2664454103C0151B5CF1E9311C3275", hash_generated_method = "B7006AA679278B8D20190229156E8E26")
    public boolean isResponseAvailable(int timeout) throws IOException {
        addTaint(timeout);
        assertOpen();
        boolean varE7A1AA20D93B96AA0ABFF4C7890ED8BA_19823413 = (this.inbuffer.isDataAvailable(timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1524698610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1524698610;
        // ---------- Original Method ----------
        //assertOpen();
        //return this.inbuffer.isDataAvailable(timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "0BB9C3DF4E44E13CEF2E43B1A4CCCB2E")
    public void sendRequestHeader(final HttpRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_1039025705 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_1039025705.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_1039025705;
        } //End block
        assertOpen();
        this.requestWriter.write(request);
        this.metrics.incrementRequestCount();
        // ---------- Original Method ----------
        //if (request == null) {
            //throw new IllegalArgumentException("HTTP request may not be null");
        //}
        //assertOpen();
        //this.requestWriter.write(request);
        //this.metrics.incrementRequestCount();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "D19CF93E4E74E3A79850E4AF8723E76B")
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_974569537 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_974569537.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_974569537;
        } //End block
        assertOpen();
    if(request.getEntity() == null)        
        {
            return;
        } //End block
        this.entityserializer.serialize(
                this.outbuffer,
                request,
                request.getEntity());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        // ---------- Original Method ----------
        //this.outbuffer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        // ---------- Original Method ----------
        //assertOpen();
        //doFlush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "D806319F8045D19DF3AF6D1ED4567F14", hash_generated_method = "DC7E1105652A2BF83B44024D9CF6D3B7")
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        assertOpen();
        HttpResponse response = (HttpResponse) this.responseParser.parse();
    if(response.getStatusLine().getStatusCode() >= 200)        
        {
            this.metrics.incrementResponseCount();
        } //End block
HttpResponse var2A1114F4272D753FE23A36E3D68CD293_1234810780 =         response;
        var2A1114F4272D753FE23A36E3D68CD293_1234810780.addTaint(taint);
        return var2A1114F4272D753FE23A36E3D68CD293_1234810780;
        // ---------- Original Method ----------
        //assertOpen();
        //HttpResponse response = (HttpResponse) this.responseParser.parse();
        //if (response.getStatusLine().getStatusCode() >= 200) {
            //this.metrics.incrementResponseCount();
        //}
        //return response;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "2E1029469FDE3C3BDBC517B380DCF73B", hash_generated_method = "8B6AB16012681ACB97F89A5693AFE1E8")
    public void receiveResponseEntity(final HttpResponse response) throws HttpException, IOException {
        addTaint(response.getTaint());
    if(response == null)        
        {
            IllegalArgumentException var81F7C558D1B895656E1A076743F59C7C_1307326503 = new IllegalArgumentException("HTTP response may not be null");
            var81F7C558D1B895656E1A076743F59C7C_1307326503.addTaint(taint);
            throw var81F7C558D1B895656E1A076743F59C7C_1307326503;
        } //End block
        assertOpen();
        HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, response);
        response.setEntity(entity);
        // ---------- Original Method ----------
        //if (response == null) {
            //throw new IllegalArgumentException("HTTP response may not be null");
        //}
        //assertOpen();
        //HttpEntity entity = this.entitydeserializer.deserialize(this.inbuffer, response);
        //response.setEntity(entity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.996 -0400", hash_original_method = "DD669E10200A1B56B0064A07B14E647E", hash_generated_method = "262DFA76302D523BD6B7647FB5D17287")
    public boolean isStale() {
    if(!isOpen())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1732567260 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1023915455 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1023915455;
        } //End block
        try 
        {
    if(inbuffer instanceof SocketInputBuffer)            
            {
                boolean var70981A13FF8F12123AAC043584711ABC_465114182 = (((SocketInputBuffer) inbuffer).isStale());
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19660021 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_19660021;
            } //End block
            this.inbuffer.isDataAvailable(1);
            boolean var68934A3E9455FA72420237EB05902327_1128760513 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1406786014 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1406786014;
        } //End block
        catch (IOException ex)
        {
            boolean varB326B5062B2F0E69046810717534CB09_2093733089 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_468958800 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_468958800;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.997 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "1ABEBB2A7F6D24E4E333693B5E878426")
    public HttpConnectionMetrics getMetrics() {
HttpConnectionMetrics varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1205790256 =         this.metrics;
        varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1205790256.addTaint(taint);
        return varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1205790256;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

