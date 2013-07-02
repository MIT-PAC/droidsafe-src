package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "DC681AA2DD2A0BE47CBDD78540D5A8BD", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")

    private SessionInputBuffer inbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "2CF5A5642A030530FB530CE6AD73F644", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "9E79D1C5118BFD93F2EA3354BE3B7BB3", hash_generated_field = "51B3B1D6F029892B5D1B485F1E8449D4")

    private int maxHeaderCount;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "4C632171BE04EE204137B2D22962BCCE", hash_generated_field = "C2CDDB4530FA37C525863212B278B681")

    private int maxLineLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "34C401953BC184959C583775D7C02C06", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")

    private EntitySerializer entityserializer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "715711ECB9730DA286C315F4B203F1D7", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")

    private HttpMessageWriter requestWriter = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "E6899A7B60D3CD0F0F3E11DDE4844FF7", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "7CEF8A734855777C2A9D0CAF42666E69", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.572 -0400", hash_original_field = "E728D69D332AE7988C6FE7869D66573E", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.573 -0400", hash_original_method = "34D8A32964859B1FAAC1AC49D9EAB8C7", hash_generated_method = "5D5370FE957D216B92C117496F770B7E")
    public  AndroidHttpClientConnection() {
        this.entityserializer =  new EntitySerializer(
                new StrictContentLengthStrategy());
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.574 -0400", hash_original_method = "B7940401E9D410C3E0007DD81BDA911F", hash_generated_method = "90267543E0030BFA1E5D535A7015CEDB")
    public void bind(
            final Socket socket,
            final HttpParams params) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } 
        assertNotOpen();
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger = HttpConnectionParams.getLinger(params);
        {
            socket.setSoLinger(linger > 0, linger);
        } 
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
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.575 -0400", hash_original_method = "EF7CB084264EC0FC42FD48CA086E7FEB", hash_generated_method = "43FAFFF84BBFF2E0D7F2030D06AFE938")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1674779772 = null; 
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName()).append("[");
        {
            boolean varF14FAC85BD81325B95F4F52AC5545E52_946003977 = (isOpen());
            {
                buffer.append(getRemotePort());
            } 
            {
                buffer.append("closed");
            } 
        } 
        buffer.append("]");
        varB4EAC82CA7396A68D541C85D26508E83_1674779772 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1674779772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1674779772;
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.575 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "FE158C35B4090D4A7DD5DCF2E51C96D7")
    private void assertNotOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is already open");
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.576 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "6C19649848B3A1DD2E6212993C13534D")
    private void assertOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is not open");
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.577 -0400", hash_original_method = "8E8BDB37899E8F9E80D937FD54AF461B", hash_generated_method = "80087B6FA9DEB7694406F0A39C6B0E7A")
    public boolean isOpen() {
        boolean var0E903911466EEC573F7184688086164A_1831434963 = ((this.open && this.socket != null && this.socket.isConnected()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955347647 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955347647;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.577 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "946B6A0AA85ACF23EA1C529EB1A8BA78")
    public InetAddress getLocalAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1896534948 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_874529271 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1896534948 = this.socket.getLocalAddress();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_874529271 = null;
        } 
        InetAddress varA7E53CE21691AB073D9660D615818899_1437268165; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1437268165 = varB4EAC82CA7396A68D541C85D26508E83_1896534948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1437268165 = varB4EAC82CA7396A68D541C85D26508E83_874529271;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1437268165.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1437268165;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.578 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "952216E7965F80EA42E0BC34FAC2EC08")
    public int getLocalPort() {
        {
            int varCCD0594420CD0D8D452225AADE7A07D2_1217948356 = (this.socket.getLocalPort());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133089492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1133089492;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.578 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "FC1B9F9614803F2B9B8F50B83F7202F7")
    public InetAddress getRemoteAddress() {
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_754363076 = null; 
        InetAddress varB4EAC82CA7396A68D541C85D26508E83_1488721650 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_754363076 = this.socket.getInetAddress();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1488721650 = null;
        } 
        InetAddress varA7E53CE21691AB073D9660D615818899_1418573150; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1418573150 = varB4EAC82CA7396A68D541C85D26508E83_754363076;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1418573150 = varB4EAC82CA7396A68D541C85D26508E83_1488721650;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1418573150.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1418573150;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.579 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "0A6B9F15C204258BFFA6D6E5FEB95891")
    public int getRemotePort() {
        {
            int var3EE29869B1F636B5DAA1F70FA7C6400E_983373835 = (this.socket.getPort());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866789559 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866789559;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.579 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "676D254DEDC8A8C19857A94AF50E3C3B")
    public void setSocketTimeout(int timeout) {
        assertOpen();
        {
            try 
            {
                this.socket.setSoTimeout(timeout);
            } 
            catch (SocketException ignore)
            { }
        } 
        addTaint(timeout);
        
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.580 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "E4A07B942880A3FD3DD45C0EA0814322")
    public int getSocketTimeout() {
        {
            try 
            {
                int var1CFD970C58DCF71C94F6332F13F0CD73_224109216 = (this.socket.getSoTimeout());
            } 
            catch (SocketException ignore)
            { }
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715080581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_715080581;
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.580 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "7E2B6040690192B3CAFE5C000979438D")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
        {
            tmpsocket.close();
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.580 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "C67C9038C6A0874A962E604367169DAC")
    public void close() throws IOException {
        this.open = false;
        doFlush();
        try 
        {
            try 
            {
                this.socket.shutdownOutput();
            } 
            catch (IOException ignore)
            { }
            try 
            {
                this.socket.shutdownInput();
            } 
            catch (IOException ignore)
            { }
        } 
        catch (UnsupportedOperationException ignore)
        { }
        this.socket.close();
        
        
            
        
        
        
        
            
                
            
            
            
                
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.581 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "CC0A22F18D01871DE3703B67106DA60F")
    public void sendRequestHeader(final HttpRequest request) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        assertOpen();
        this.requestWriter.write(request);
        this.metrics.incrementRequestCount();
        addTaint(request.getTaint());
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.581 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "920041BEF2BC4FE4B8B3B92B5223D4CD")
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } 
        assertOpen();
        {
            boolean varD49B899B4DAE647F6EFF10130B7BC7C1_195096174 = (request.getEntity() == null);
        } 
        this.entityserializer.serialize(
                this.outbuffer,
                request,
                request.getEntity());
        addTaint(request.getTaint());
        
        
            
        
        
        
            
        
        
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.581 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.582 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.583 -0400", hash_original_method = "5382496E6517DB13491696C30DF0839D", hash_generated_method = "9ECE40153DEDED11D10BF6D8854A0227")
    public StatusLine parseResponseHeader(Headers headers) throws IOException, ParseException {
        StatusLine varB4EAC82CA7396A68D541C85D26508E83_1232075086 = null; 
        assertOpen();
        CharArrayBuffer current = new CharArrayBuffer(64);
        {
            boolean var21CDE1F401E7BB0361226862DF86163A_657281318 = (inbuffer.readLine(current) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoHttpResponseException("The target server failed to respond");
            } 
        } 
        StatusLine statusline = BasicLineParser.DEFAULT.parseStatusLine(
                current, new ParserCursor(0, current.length()));
        HttpLog.v("read: " + statusline);
        int statusCode = statusline.getStatusCode();
        CharArrayBuffer previous = null;
        int headerNumber = 0;
        {
            {
                current = new CharArrayBuffer(64);
            } 
            {
                current.clear();
            } 
            int l = inbuffer.readLine(current);
            {
                boolean varF37487E45CF922EB7BEA02A88464E0BA_454622148 = (l == -1 || current.length() < 1);
            } 
            char first = current.charAt(0);
            {
                int start = 0;
                int length = current.length();
                {
                    char ch = current.charAt(start);
                } 
                {
                    boolean var3DB5EDFC20803D4A5CABA530FEF460F1_575896847 = (maxLineLength > 0 &&
                        previous.length() + 1 + current.length() - start >
                            maxLineLength);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum line length limit exceeded");
                    } 
                } 
                previous.append(' ');
                previous.append(current, start, current.length() - start);
            } 
            {
                {
                    headers.parseHeader(previous);
                } 
                previous = current;
                current = null;
            } 
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum header count exceeded");
            } 
        } 
        {
            headers.parseHeader(previous);
        } 
        {
            this.metrics.incrementResponseCount();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1232075086 = statusline;
        addTaint(headers.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1232075086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1232075086;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.584 -0400", hash_original_method = "1E84D06F522FAB67F7B7209EA462145E", hash_generated_method = "80309F6154D0EC962DE66DC9912566A1")
    public HttpEntity receiveResponseEntity(final Headers headers) {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1548161040 = null; 
        assertOpen();
        BasicHttpEntity entity = new BasicHttpEntity();
        long len = determineLength(headers);
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } 
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } 
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } 
        String contentTypeHeader = headers.getContentType();
        {
            entity.setContentType(contentTypeHeader);
        } 
        String contentEncodingHeader = headers.getContentEncoding();
        {
            entity.setContentEncoding(contentEncodingHeader);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1548161040 = entity;
        addTaint(headers.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1548161040.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1548161040;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.585 -0400", hash_original_method = "DFC24C3199FB5D6CC47411FD6E7FCAFF", hash_generated_method = "0285A4E1CFC144A1FBB2FFFD2992E434")
    private long determineLength(final Headers headers) {
        long transferEncoding = headers.getTransferEncoding();
        {
            long contentlen = headers.getContentLength();
        } 
        addTaint(headers.getTaint());
        long var0F5264038205EDFB1AC05FBB0E8C5E94_571456289 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_571456289;
        
        
        
            
        
            
            
                
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.585 -0400", hash_original_method = "3BE812D13F4292433A7C6B8D5ADAC2E8", hash_generated_method = "72FB028C6164E1EE4AD55A19234128DF")
    public boolean isStale() {
        assertOpen();
        try 
        {
            this.inbuffer.isDataAvailable(1);
        } 
        catch (IOException ex)
        { }
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1343032563 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1343032563;
        
        
        
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:38.586 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "BD842E13242B861D57F4A619080B7C10")
    public HttpConnectionMetrics getMetrics() {
        HttpConnectionMetrics varB4EAC82CA7396A68D541C85D26508E83_449433136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_449433136 = this.metrics;
        varB4EAC82CA7396A68D541C85D26508E83_449433136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_449433136;
        
        
    }

    
}

