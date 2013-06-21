package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private SessionInputBuffer inbuffer = null;
    private SessionOutputBuffer outbuffer = null;
    private int maxHeaderCount;
    private int maxLineLength;
    private EntitySerializer entityserializer;
    private HttpMessageWriter requestWriter = null;
    private HttpConnectionMetricsImpl metrics = null;
    private volatile boolean open;
    private Socket socket = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.699 -0400", hash_original_method = "34D8A32964859B1FAAC1AC49D9EAB8C7", hash_generated_method = "5D5370FE957D216B92C117496F770B7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AndroidHttpClientConnection() {
        this.entityserializer =  new EntitySerializer(
                new StrictContentLengthStrategy());
        // ---------- Original Method ----------
        //this.entityserializer =  new EntitySerializer(
                //new StrictContentLengthStrategy());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.699 -0400", hash_original_method = "B7940401E9D410C3E0007DD81BDA911F", hash_generated_method = "EC70DBF9A54B363C0FEEDDC7188ED40B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(
            final Socket socket,
            final HttpParams params) throws IOException {
        dsTaint.addTaint(socket.dsTaint);
        dsTaint.addTaint(params.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP parameters may not be null");
        } //End block
        assertNotOpen();
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(params));
        int linger;
        linger = HttpConnectionParams.getLinger(params);
        {
            socket.setSoLinger(linger > 0, linger);
        } //End block
        int buffersize;
        buffersize = HttpConnectionParams.getSocketBufferSize(params);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.699 -0400", hash_original_method = "EF7CB084264EC0FC42FD48CA086E7FEB", hash_generated_method = "45F35ADF738BDC9CE132E9954D404FD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder buffer;
        buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName()).append("[");
        {
            boolean varF14FAC85BD81325B95F4F52AC5545E52_1918738221 = (isOpen());
            {
                buffer.append(getRemotePort());
            } //End block
            {
                buffer.append("closed");
            } //End block
        } //End collapsed parenthetic
        buffer.append("]");
        String varAD28D02EB1C6982A5710D014292E1955_939616620 = (buffer.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.700 -0400", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "FE158C35B4090D4A7DD5DCF2E51C96D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void assertNotOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is already open");
        } //End block
        // ---------- Original Method ----------
        //if (this.open) {
            //throw new IllegalStateException("Connection is already open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.700 -0400", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "6C19649848B3A1DD2E6212993C13534D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void assertOpen() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Connection is not open");
        } //End block
        // ---------- Original Method ----------
        //if (!this.open) {
            //throw new IllegalStateException("Connection is not open");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.700 -0400", hash_original_method = "8E8BDB37899E8F9E80D937FD54AF461B", hash_generated_method = "612F40FB06758EBC493724D290FE9FBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isOpen() {
        boolean var0E903911466EEC573F7184688086164A_362370646 = ((this.open && this.socket != null && this.socket.isConnected()));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return (this.open && this.socket != null && this.socket.isConnected());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.701 -0400", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "421BBD5FC9F9638E7BD6B0D57AE8959E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getLocalAddress() {
        {
            InetAddress var3864414C1DFDBA5DCF1DF354B4ED7E85_272882170 = (this.socket.getLocalAddress());
        } //End block
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.701 -0400", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "15CB1E93B7766BF1A2A02AA98A4A7077")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getLocalPort() {
        {
            int varCCD0594420CD0D8D452225AADE7A07D2_672489690 = (this.socket.getLocalPort());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getLocalPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.701 -0400", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "C62CAFD99619CE7D21ED41698B4AAA5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InetAddress getRemoteAddress() {
        {
            InetAddress var7A732D8521684F3F1578E7600D1E4C1E_1484132018 = (this.socket.getInetAddress());
        } //End block
        return (InetAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getInetAddress();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.701 -0400", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "03EEF3D1C9244EC92DAE3613683182AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRemotePort() {
        {
            int var3EE29869B1F636B5DAA1F70FA7C6400E_890476211 = (this.socket.getPort());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.socket != null) {
            //return this.socket.getPort();
        //} else {
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.702 -0400", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "BCCCEAAF07F79B62C8192A12C5E950FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSocketTimeout(int timeout) {
        dsTaint.addTaint(timeout);
        assertOpen();
        {
            try 
            {
                this.socket.setSoTimeout(timeout);
            } //End block
            catch (SocketException ignore)
            { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.702 -0400", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "348F7CF3E6CD4A729D722CAB642D9571")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getSocketTimeout() {
        {
            try 
            {
                int var1CFD970C58DCF71C94F6332F13F0CD73_1785311303 = (this.socket.getSoTimeout());
            } //End block
            catch (SocketException ignore)
            { }
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.702 -0400", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "CF620A7315D3C1C1AD4D9BAC734BF982")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket;
        tmpsocket = this.socket;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.703 -0400", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "C67C9038C6A0874A962E604367169DAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        this.open = false;
        doFlush();
        try 
        {
            try 
            {
                this.socket.shutdownOutput();
            } //End block
            catch (IOException ignore)
            { }
            try 
            {
                this.socket.shutdownInput();
            } //End block
            catch (IOException ignore)
            { }
        } //End block
        catch (UnsupportedOperationException ignore)
        { }
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.703 -0400", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "160BFB1EBBD7D39AEA2F3DA40342DEFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequestHeader(final HttpRequest request) throws HttpException, IOException {
        dsTaint.addTaint(request.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.703 -0400", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "0C06CC58EFF732D67A5E0D34070EF1D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendRequestEntity(final HttpEntityEnclosingRequest request) throws HttpException, IOException {
        dsTaint.addTaint(request.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("HTTP request may not be null");
        } //End block
        assertOpen();
        {
            boolean varD49B899B4DAE647F6EFF10130B7BC7C1_1031893156 = (request.getEntity() == null);
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.704 -0400", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "4D1A2508A821B55E0B18D024D4D93DA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
        // ---------- Original Method ----------
        //this.outbuffer.flush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.704 -0400", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "C32057FFD327A27B41D17512113B46BE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void flush() throws IOException {
        assertOpen();
        doFlush();
        // ---------- Original Method ----------
        //assertOpen();
        //doFlush();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.704 -0400", hash_original_method = "5382496E6517DB13491696C30DF0839D", hash_generated_method = "3AEF95F4F1D5938F391C68FC75730BA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public StatusLine parseResponseHeader(Headers headers) throws IOException, ParseException {
        dsTaint.addTaint(headers.dsTaint);
        assertOpen();
        CharArrayBuffer current;
        current = new CharArrayBuffer(64);
        {
            boolean var21CDE1F401E7BB0361226862DF86163A_322223197 = (inbuffer.readLine(current) == -1);
            {
                if (DroidSafeAndroidRuntime.control) throw new NoHttpResponseException("The target server failed to respond");
            } //End block
        } //End collapsed parenthetic
        StatusLine statusline;
        statusline = BasicLineParser.DEFAULT.parseStatusLine(
                current, new ParserCursor(0, current.length()));
        HttpLog.v("read: " + statusline);
        int statusCode;
        statusCode = statusline.getStatusCode();
        CharArrayBuffer previous;
        previous = null;
        int headerNumber;
        headerNumber = 0;
        {
            {
                current = new CharArrayBuffer(64);
            } //End block
            {
                current.clear();
            } //End block
            int l;
            l = inbuffer.readLine(current);
            {
                boolean varF37487E45CF922EB7BEA02A88464E0BA_1643962195 = (l == -1 || current.length() < 1);
            } //End collapsed parenthetic
            char first;
            first = current.charAt(0);
            {
                int start;
                start = 0;
                int length;
                length = current.length();
                {
                    char ch;
                    ch = current.charAt(start);
                } //End block
                {
                    boolean var3DB5EDFC20803D4A5CABA530FEF460F1_989662273 = (maxLineLength > 0 &&
                        previous.length() + 1 + current.length() - start >
                            maxLineLength);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum line length limit exceeded");
                    } //End block
                } //End collapsed parenthetic
                previous.append(' ');
                previous.append(current, start, current.length() - start);
            } //End block
            {
                {
                    headers.parseHeader(previous);
                } //End block
                previous = current;
                current = null;
            } //End block
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("Maximum header count exceeded");
            } //End block
        } //End block
        {
            headers.parseHeader(previous);
        } //End block
        {
            this.metrics.incrementResponseCount();
        } //End block
        return (StatusLine)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.705 -0400", hash_original_method = "1E84D06F522FAB67F7B7209EA462145E", hash_generated_method = "EEA50E743765EF66F339FA97C8B85B52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HttpEntity receiveResponseEntity(final Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        assertOpen();
        BasicHttpEntity entity;
        entity = new BasicHttpEntity();
        long len;
        len = determineLength(headers);
        {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } //End block
        {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } //End block
        {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        } //End block
        String contentTypeHeader;
        contentTypeHeader = headers.getContentType();
        {
            entity.setContentType(contentTypeHeader);
        } //End block
        String contentEncodingHeader;
        contentEncodingHeader = headers.getContentEncoding();
        {
            entity.setContentEncoding(contentEncodingHeader);
        } //End block
        return (HttpEntity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.706 -0400", hash_original_method = "DFC24C3199FB5D6CC47411FD6E7FCAFF", hash_generated_method = "2F3B4338122337BA1DB3FB3975D836B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private long determineLength(final Headers headers) {
        dsTaint.addTaint(headers.dsTaint);
        long transferEncoding;
        transferEncoding = headers.getTransferEncoding();
        {
            long contentlen;
            contentlen = headers.getContentLength();
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.706 -0400", hash_original_method = "3BE812D13F4292433A7C6B8D5ADAC2E8", hash_generated_method = "6BF6E450C71C3A72A98BE2D1CC4B5B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isStale() {
        assertOpen();
        try 
        {
            this.inbuffer.isDataAvailable(1);
        } //End block
        catch (IOException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //assertOpen();
        //try {
            //this.inbuffer.isDataAvailable(1);
            //return false;
        //} catch (IOException ex) {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.707 -0400", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "79FC3CFD38C889943EF337B8AA327096")
    @DSModeled(DSC.SAFE)
    public HttpConnectionMetrics getMetrics() {
        return (HttpConnectionMetrics)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return this.metrics;
    }

    
}

