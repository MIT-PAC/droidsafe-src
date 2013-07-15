package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HttpConnection;
import org.apache.http.HttpClientConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.impl.DefaultHttpResponseFactory;
import org.apache.http.impl.HttpConnectionMetricsImpl;
import org.apache.http.impl.entity.EntitySerializer;
import org.apache.http.impl.entity.StrictContentLengthStrategy;
import org.apache.http.impl.io.ChunkedInputStream;
import org.apache.http.impl.io.ContentLengthInputStream;
import org.apache.http.impl.io.HttpRequestWriter;
import org.apache.http.impl.io.IdentityInputStream;
import org.apache.http.impl.io.SocketInputBuffer;
import org.apache.http.impl.io.SocketOutputBuffer;
import org.apache.http.io.HttpMessageWriter;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class AndroidHttpClientConnection implements HttpInetConnection, HttpConnection {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.898 -0400", hash_original_field = "DC681AA2DD2A0BE47CBDD78540D5A8BD", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    private SessionInputBuffer inbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.898 -0400", hash_original_field = "2CF5A5642A030530FB530CE6AD73F644", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.898 -0400", hash_original_field = "9E79D1C5118BFD93F2EA3354BE3B7BB3", hash_generated_field = "51B3B1D6F029892B5D1B485F1E8449D4")

    private int maxHeaderCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.898 -0400", hash_original_field = "4C632171BE04EE204137B2D22962BCCE", hash_generated_field = "C2CDDB4530FA37C525863212B278B681")

    private int maxLineLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.899 -0400", hash_original_field = "34C401953BC184959C583775D7C02C06", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private EntitySerializer entityserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.899 -0400", hash_original_field = "715711ECB9730DA286C315F4B203F1D7", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.899 -0400", hash_original_field = "E6899A7B60D3CD0F0F3E11DDE4844FF7", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.899 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.899 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.900 -0400", hash_original_method = "34D8A32964859B1FAAC1AC49D9EAB8C7", hash_generated_method = "5D5370FE957D216B92C117496F770B7E")
    public  AndroidHttpClientConnection() {
        this.entityserializer =  new EntitySerializer(
                new StrictContentLengthStrategy());
        // ---------- Original Method ----------
        //this.entityserializer =  new EntitySerializer(
                //new StrictContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.902 -0400", hash_original_method = "B7940401E9D410C3E0007DD81BDA911F", hash_generated_method = "E62D1C1E5BF576BE04521B9DBDE8C1AC")
    public void bind(
            final Socket socket,
            final HttpParams params) throws IOException {
    if(socket == null)        
        {
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_1453709143 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_1453709143.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_1453709143;
        } //End block
    if(params == null)        
        {
            IllegalArgumentException var497CCC27A43EDD6EE25BEEC5507E2BE2_1311410884 = new IllegalArgumentException("HTTP parameters may not be null");
            var497CCC27A43EDD6EE25BEEC5507E2BE2_1311410884.addTaint(taint);
            throw var497CCC27A43EDD6EE25BEEC5507E2BE2_1311410884;
        } //End block
        assertNotOpen();
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger = HttpConnectionParams.getLinger(params);
    if(linger >= 0)        
        {
            socket.setSoLinger(linger > 0, linger);
        } //End block
        this.socket = socket;
        int buffersize = HttpConnectionParams.getSocketBufferSize(params);
        this.inbuffer = new SocketInputBuffer(socket, buffersize, params);
        this.outbuffer = new SocketOutputBuffer(socket, buffersize, params);
        maxHeaderCount = params.getIntParameter(
                CoreConnectionPNames.MAX_HEADER_COUNT, -1);
        maxLineLength = params.getIntParameter(
                CoreConnectionPNames.MAX_LINE_LENGTH, -1);
        this.requestWriter = new HttpRequestWriter(outbuffer, null, params);
        this.metrics = new HttpConnectionMetricsImpl(
                inbuffer.getMetrics(),
                outbuffer.getMetrics());
        this.open = true;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.902 -0400", hash_original_method = "EF7CB084264EC0FC42FD48CA086E7FEB", hash_generated_method = "E084A2C585CA504BFAA7037D4898D907")
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName()).append("[");
    if(isOpen())        
        {
            buffer.append(getRemotePort());
        } //End block
        else
        {
            buffer.append("closed");
        } //End block
        buffer.append("]");
String varD03843288D33B9E1D3062E25339ECF6D_572995336 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_572995336.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_572995336;
        // ---------- Original Method ----------
        //StringBuilder buffer = new StringBuilder();
        //buffer.append(getClass().getSimpleName()).append("[");
        //if (isOpen()) {
            //buffer.append(getRemotePort());
        //} else {
            //buffer.append("closed");
        //}
        //buffer.append("]");
        //return buffer.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.902 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "ACDB8F35904C95FB6B969853A8388DEF")
    private void assertNotOpen() {
    if(this.open)        
        {
            IllegalStateException var84A3AD519B18408EB344ACE934F6C410_927654829 = new IllegalStateException("Connection is already open");
            var84A3AD519B18408EB344ACE934F6C410_927654829.addTaint(taint);
            throw var84A3AD519B18408EB344ACE934F6C410_927654829;
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.903 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "025C23A5DBEF55A250B8E4970D68EBDD")
    private void assertOpen() {
    if(!this.open)        
        {
            IllegalStateException var9ADD238E8FA39BC97A70F042343A30CA_1889132349 = new IllegalStateException("Connection is not open");
            var9ADD238E8FA39BC97A70F042343A30CA_1889132349.addTaint(taint);
            throw var9ADD238E8FA39BC97A70F042343A30CA_1889132349;
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.903 -0400", hash_original_method = "8E8BDB37899E8F9E80D937FD54AF461B", hash_generated_method = "585E4A68FA460A03B24ECAB33859E42F")
    public boolean isOpen() {
        boolean varE850F00B58D108E3C63F93C8F17C0010_1933146265 = ((this.open && this.socket != null && this.socket.isConnected()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_361414337 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_361414337;
        // ---------- Original Method ----------
        //return (this.open && this.socket != null && this.socket.isConnected());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.903 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "31F93DEEDC57ECB8094D9C5598FF842B")
    public InetAddress getLocalAddress() {
    if(this.socket != null)        
        {
InetAddress var55250CAC8E472010A9C3BCFFCA885EF9_24593384 =             this.socket.getLocalAddress();
            var55250CAC8E472010A9C3BCFFCA885EF9_24593384.addTaint(taint);
            return var55250CAC8E472010A9C3BCFFCA885EF9_24593384;
        } //End block
        else
        {
InetAddress var540C13E9E156B687226421B24F2DF178_242540250 =             null;
            var540C13E9E156B687226421B24F2DF178_242540250.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_242540250;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.904 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "46CB082D6274F9B3D3C5B98B7C10341F")
    public int getLocalPort() {
    if(this.socket != null)        
        {
            int varA1A37855EF64705F2D43A30D558084D5_1032539196 = (this.socket.getLocalPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763334053 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1763334053;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_924680919 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312265169 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312265169;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.904 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "66C263A1125F5FBE154EE79871E1758C")
    public InetAddress getRemoteAddress() {
    if(this.socket != null)        
        {
InetAddress var601DF1EB7A81FFA1EAA0DD611F88A9A1_1907864489 =             this.socket.getInetAddress();
            var601DF1EB7A81FFA1EAA0DD611F88A9A1_1907864489.addTaint(taint);
            return var601DF1EB7A81FFA1EAA0DD611F88A9A1_1907864489;
        } //End block
        else
        {
InetAddress var540C13E9E156B687226421B24F2DF178_2016197199 =             null;
            var540C13E9E156B687226421B24F2DF178_2016197199.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2016197199;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.905 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "69E8ECE133BDB4E4A9E62BE924AD5866")
    public int getRemotePort() {
    if(this.socket != null)        
        {
            int var502403C994AC2D85DCA0890A45B626BE_2016278057 = (this.socket.getPort());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769211940 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_769211940;
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_890610437 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524594154 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1524594154;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.905 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "BE67356934499B3F4828E090EF89D577")
    public void setSocketTimeout(int timeout) {
        addTaint(timeout);
        assertOpen();
    if(this.socket != null)        
        {
            try 
            {
                this.socket.setSoTimeout(timeout);
            } //End block
            catch (SocketException ignore)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        //assertOpen();
        //if (this.socket != null) {
            //try {
                //this.socket.setSoTimeout(timeout);
            //} catch (SocketException ignore) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.906 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "9A29A6AE1AB8A0A1D35BF079CD24CF24")
    public int getSocketTimeout() {
    if(this.socket != null)        
        {
            try 
            {
                int var1F56CB3CA7DD779FD088C15B14EF2D6D_236215309 = (this.socket.getSoTimeout());
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069940013 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1069940013;
            } //End block
            catch (SocketException ignore)
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_332492885 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809852379 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1809852379;
            } //End block
        } //End block
        else
        {
            int var6BB61E3B7BCE0931DA574D19D1D82C88_757458020 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_177347597 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_177347597;
        } //End block
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //try {
                //return this.socket.getSoTimeout();
            //} catch (SocketException ignore) {
                //return -1;
            //}
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.906 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "A28E06A0CA260323C8F4F1C99DF0CED4")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
    if(tmpsocket != null)        
        {
            tmpsocket.close();
        } //End block
        // ---------- Original Method ----------
        //this.open = false;
        //Socket tmpsocket = this.socket;
        //if (tmpsocket != null) {
            //tmpsocket.close();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.907 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "F1846722FD7DAA0EB6FBC61594D64B90")
    public void close() throws IOException {
    if(!this.open)        
        {
            return;
        } //End block
        this.open = false;
        doFlush();
        try 
        {
            try 
            {
                this.socket.shutdownOutput();
            } //End block
            catch (IOException ignore)
            {
            } //End block
            try 
            {
                this.socket.shutdownInput();
            } //End block
            catch (IOException ignore)
            {
            } //End block
        } //End block
        catch (UnsupportedOperationException ignore)
        {
        } //End block
        this.socket.close();
        // ---------- Original Method ----------
        //if (!this.open) {
            //return;
        //}
        //this.open = false;
        //doFlush();
        //try {
            //try {
                //this.socket.shutdownOutput();
            //} catch (IOException ignore) {
            //}
            //try {
                //this.socket.shutdownInput();
            //} catch (IOException ignore) {
            //}
        //} catch (UnsupportedOperationException ignore) {
        //}
        //this.socket.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.907 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "721CA2FB5A1F12E00BBC7D071E9B6515")
    public void sendRequestHeader(final HttpRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_454708053 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_454708053.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_454708053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.908 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "AF7D262F02AC6C4165860653383554D1")
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        addTaint(request.getTaint());
    if(request == null)        
        {
            IllegalArgumentException varF07DEF4BA25028D1DB51C0BA629AF0B4_112763459 = new IllegalArgumentException("HTTP request may not be null");
            varF07DEF4BA25028D1DB51C0BA629AF0B4_112763459.addTaint(taint);
            throw varF07DEF4BA25028D1DB51C0BA629AF0B4_112763459;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.908 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        // ---------- Original Method ----------
        //this.outbuffer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.909 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        // ---------- Original Method ----------
        //assertOpen();
        //doFlush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.910 -0400", hash_original_method = "5382496E6517DB13491696C30DF0839D", hash_generated_method = "C9E5A91783091D375A8A4B5674695802")
    public StatusLine parseResponseHeader(Headers headers) throws IOException, ParseException {
        addTaint(headers.getTaint());
        assertOpen();
        CharArrayBuffer current = new CharArrayBuffer(64);
    if(inbuffer.readLine(current) == -1)        
        {
            NoHttpResponseException var8E6E6A11E770AF132B510E2C0E1EA88C_2023290701 = new NoHttpResponseException("The target server failed to respond");
            var8E6E6A11E770AF132B510E2C0E1EA88C_2023290701.addTaint(taint);
            throw var8E6E6A11E770AF132B510E2C0E1EA88C_2023290701;
        } //End block
        StatusLine statusline = BasicLineParser.DEFAULT.parseStatusLine(
                current, new ParserCursor(0, current.length()));
    if(HttpLog.LOGV)        
        HttpLog.v("read: " + statusline);
        int statusCode = statusline.getStatusCode();
        CharArrayBuffer previous = null;
        int headerNumber = 0;
        while
(true)        
        {
    if(current == null)            
            {
                current = new CharArrayBuffer(64);
            } //End block
            else
            {
                current.clear();
            } //End block
            int l = inbuffer.readLine(current);
    if(l == -1 || current.length() < 1)            
            {
                break;
            } //End block
            char first = current.charAt(0);
    if((first == ' ' || first == '\t') && previous != null)            
            {
                int start = 0;
                int length = current.length();
                while
(start < length)                
                {
                    char ch = current.charAt(start);
    if(ch != ' ' && ch != '\t')                    
                    {
                        break;
                    } //End block
                    start++;
                } //End block
    if(maxLineLength > 0 &&
                        previous.length() + 1 + current.length() - start >
                            maxLineLength)                
                {
                    IOException var12ACD845FE59D4DF91577F545067D44A_304185804 = new IOException("Maximum line length limit exceeded");
                    var12ACD845FE59D4DF91577F545067D44A_304185804.addTaint(taint);
                    throw var12ACD845FE59D4DF91577F545067D44A_304185804;
                } //End block
                previous.append(' ');
                previous.append(current, start, current.length() - start);
            } //End block
            else
            {
    if(previous != null)                
                {
                    headers.parseHeader(previous);
                } //End block
                headerNumber++;
                previous = current;
                current = null;
            } //End block
    if(maxHeaderCount > 0 && headerNumber >= maxHeaderCount)            
            {
                IOException var715D62412F40E87C48B3054F65A13D4F_88267242 = new IOException("Maximum header count exceeded");
                var715D62412F40E87C48B3054F65A13D4F_88267242.addTaint(taint);
                throw var715D62412F40E87C48B3054F65A13D4F_88267242;
            } //End block
        } //End block
    if(previous != null)        
        {
            headers.parseHeader(previous);
        } //End block
    if(statusCode >= 200)        
        {
            this.metrics.incrementResponseCount();
        } //End block
StatusLine varECE1183D548EEF2334B847FDE0390490_1894070303 =         statusline;
        varECE1183D548EEF2334B847FDE0390490_1894070303.addTaint(taint);
        return varECE1183D548EEF2334B847FDE0390490_1894070303;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.911 -0400", hash_original_method = "1E84D06F522FAB67F7B7209EA462145E", hash_generated_method = "A8FC654F72D959652840757200C8D173")
    public HttpEntity receiveResponseEntity(final Headers headers) {
        addTaint(headers.getTaint());
        assertOpen();
        BasicHttpEntity entity = new BasicHttpEntity();
        long len = determineLength(headers);
    if(len == ContentLengthStrategy.CHUNKED)        
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } //End block
        else
    if(len == ContentLengthStrategy.IDENTITY)        
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } //End block
        else
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } //End block
        String contentTypeHeader = headers.getContentType();
    if(contentTypeHeader != null)        
        {
            entity.setContentType(contentTypeHeader);
        } //End block
        String contentEncodingHeader = headers.getContentEncoding();
    if(contentEncodingHeader != null)        
        {
            entity.setContentEncoding(contentEncodingHeader);
        } //End block
HttpEntity var5E2D610DE63DCFFE14343DA0A43AB041_1998109228 =         entity;
        var5E2D610DE63DCFFE14343DA0A43AB041_1998109228.addTaint(taint);
        return var5E2D610DE63DCFFE14343DA0A43AB041_1998109228;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.911 -0400", hash_original_method = "DFC24C3199FB5D6CC47411FD6E7FCAFF", hash_generated_method = "F5B776F577CE612B4341EF36830F638B")
    private long determineLength(final Headers headers) {
        addTaint(headers.getTaint());
        long transferEncoding = headers.getTransferEncoding();
    if(transferEncoding < Headers.NO_TRANSFER_ENCODING)        
        {
            long varBF0487A5497D96D26C24936A4DAD1B2F_797136626 = (transferEncoding);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_343998467 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_343998467;
        } //End block
        else
        {
            long contentlen = headers.getContentLength();
    if(contentlen > Headers.NO_CONTENT_LENGTH)            
            {
                long varCB93A9937843A987DEAF858742557F95_657769443 = (contentlen);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_2056446029 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_2056446029;
            } //End block
            else
            {
                long var85A74CC368A28A3EE8374941BD402BFD_79268758 = (ContentLengthStrategy.IDENTITY);
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_630502827 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_630502827;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //long transferEncoding = headers.getTransferEncoding();
        //if (transferEncoding < Headers.NO_TRANSFER_ENCODING) {
            //return transferEncoding;
        //} else {
            //long contentlen = headers.getContentLength();
            //if (contentlen > Headers.NO_CONTENT_LENGTH) {
                //return contentlen;
            //} else {
                //return ContentLengthStrategy.IDENTITY;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.912 -0400", hash_original_method = "3BE812D13F4292433A7C6B8D5ADAC2E8", hash_generated_method = "125C76F3D15B51A62A0F7910FD36C0ED")
    public boolean isStale() {
        assertOpen();
        try 
        {
            this.inbuffer.isDataAvailable(1);
            boolean var68934A3E9455FA72420237EB05902327_1516325074 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_823167642 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_823167642;
        } //End block
        catch (IOException ex)
        {
            boolean varB326B5062B2F0E69046810717534CB09_1603349017 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611025254 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_611025254;
        } //End block
        // ---------- Original Method ----------
        //assertOpen();
        //try {
            //this.inbuffer.isDataAvailable(1);
            //return false;
        //} catch (IOException ex) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:26.912 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "D0087111A16A2BBB53ED3D5FB7D0338E")
    public HttpConnectionMetrics getMetrics() {
HttpConnectionMetrics varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1641017354 =         this.metrics;
        varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1641017354.addTaint(taint);
        return varFC1AE2E8C2526EA66FBB8E6B024A2CB6_1641017354;
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

