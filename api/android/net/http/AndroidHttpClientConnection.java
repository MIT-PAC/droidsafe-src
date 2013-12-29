package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

import org.apache.http.HttpConnection;
import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpInetConnection;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentLengthStrategy;
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
import org.apache.http.util.CharArrayBuffer;






public class AndroidHttpClientConnection implements HttpInetConnection, HttpConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.426 -0500", hash_original_field = "51AEA610F55961E2DEAE8E33F14CC584", hash_generated_field = "B0D6D00F71FC030A17C26A2601F3BE87")


    private SessionInputBuffer inbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.427 -0500", hash_original_field = "D37E01EB8D7F3CC9AD7133D08AB04720", hash_generated_field = "10B58CBE3BBA8B7201F396357A83D45E")

    private SessionOutputBuffer outbuffer = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.428 -0500", hash_original_field = "F0C13102950DF6DEECC29E1050A6EEE7", hash_generated_field = "51B3B1D6F029892B5D1B485F1E8449D4")

    private int maxHeaderCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.428 -0500", hash_original_field = "86307AB9869BB09B7197621A6EABCFF7", hash_generated_field = "C2CDDB4530FA37C525863212B278B681")

    private int maxLineLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.429 -0500", hash_original_field = "FDB5A9B9AD2A7A41FA2463863E97E07B", hash_generated_field = "AB3FDC91331A5753EE17C338AC9D0381")


    private  EntitySerializer entityserializer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.430 -0500", hash_original_field = "C92B1D7A604A0991F570C5C22AE92582", hash_generated_field = "F323E9D16DC81146FC2969062D7F8C7E")


    private HttpMessageWriter requestWriter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.431 -0500", hash_original_field = "10648022F55E6D4D6A7E5414064AE29D", hash_generated_field = "EE4B08A08CEE9A462065794CA86E6F61")

    private HttpConnectionMetricsImpl metrics = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.431 -0500", hash_original_field = "B4185B849AB8251A0F1052DF377DB9A2", hash_generated_field = "F8642D5396CC441E503E603D20259781")

    private volatile boolean open;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.432 -0500", hash_original_field = "E7F90F41B90C8A055F53F64B106EF2DC", hash_generated_field = "9FD10C539AD3B0FAAA147E92379F8AC8")

    private Socket socket = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.433 -0500", hash_original_method = "34D8A32964859B1FAAC1AC49D9EAB8C7", hash_generated_method = "724B23751891E64CC0AE8C46D487447E")
    public AndroidHttpClientConnection() {
        this.entityserializer =  new EntitySerializer(
                new StrictContentLengthStrategy());
    }

    /**
     * Bind socket and set HttpParams to AndroidHttpClientConnection
     * @param socket outgoing socket
     * @param params HttpParams
     * @throws IOException
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.434 -0500", hash_original_method = "B7940401E9D410C3E0007DD81BDA911F", hash_generated_method = "A02E352C63788D84A841872A26CC26AC")
    public void bind(
            final Socket socket,
            final HttpParams params) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        assertNotOpen();
        socket.setTcpNoDelay(HttpConnectionParams.getTcpNoDelay(params));
        socket.setSoTimeout(HttpConnectionParams.getSoTimeout(params));

        int linger = HttpConnectionParams.getLinger(params);
        if (linger >= 0) {
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.435 -0500", hash_original_method = "EF7CB084264EC0FC42FD48CA086E7FEB", hash_generated_method = "9782A619B445536B5BB9B37FDDA0CAA0")
    @Override
public String toString() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(getClass().getSimpleName()).append("[");
        if (isOpen()) {
            buffer.append(getRemotePort());
        } else {
            buffer.append("closed");
        }
        buffer.append("]");
        return buffer.toString();
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.436 -0500", hash_original_method = "BD86A908767A86776B5DCBFC714C696F", hash_generated_method = "FA059EA16C6BD439D56873736FDE28AE")
    private void assertNotOpen() {
        if (this.open) {
            throw new IllegalStateException("Connection is already open");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.436 -0500", hash_original_method = "ACED44A56037ABE0B09ED18FFAC2A6E6", hash_generated_method = "800BA487D09C6D9F62760FED6B11DCF8")
    private void assertOpen() {
        if (!this.open) {
            throw new IllegalStateException("Connection is not open");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.437 -0500", hash_original_method = "8E8BDB37899E8F9E80D937FD54AF461B", hash_generated_method = "DAB4782EDDCF0CCF46E3A0208F9AC369")
    public boolean isOpen() {
        // to make this method useful, we want to check if the socket is connected
        return (this.open && this.socket != null && this.socket.isConnected());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.438 -0500", hash_original_method = "37A4CCD5FC4FE8478033812CF6081247", hash_generated_method = "EA530790EC409832EC35D8CAE50145BF")
    public InetAddress getLocalAddress() {
        if (this.socket != null) {
            return this.socket.getLocalAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.439 -0500", hash_original_method = "CB3D09E80AD036DA49A9727AFFCF9E16", hash_generated_method = "3A0C54C4A483F7C7ABC3323E7544AA7B")
    public int getLocalPort() {
        if (this.socket != null) {
            return this.socket.getLocalPort();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.439 -0500", hash_original_method = "738E936ADE4702B2396BC3DC05386FBD", hash_generated_method = "A53D10A004E6582D7D26BD15F7A46312")
    public InetAddress getRemoteAddress() {
        if (this.socket != null) {
            return this.socket.getInetAddress();
        } else {
            return null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.440 -0500", hash_original_method = "D939EFD523917F0149002711980337D5", hash_generated_method = "E09502CC817CBCDCE2D379B1FD8CEA55")
    public int getRemotePort() {
        if (this.socket != null) {
            return this.socket.getPort();
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.442 -0500", hash_original_method = "1060FB10CE7965802AECEE442A1DB6DF", hash_generated_method = "A990F9F152705D0F8E5F26717A2CA640")
    public void setSocketTimeout(int timeout) {
        assertOpen();
        if (this.socket != null) {
            try {
                this.socket.setSoTimeout(timeout);
            } catch (SocketException ignore) {
                // It is not quite clear from the original documentation if there are any
                // other legitimate cases for a socket exception to be thrown when setting
                // SO_TIMEOUT besides the socket being already closed
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.442 -0500", hash_original_method = "65027FF3AE16248E56640778A6A4578D", hash_generated_method = "655443F0128AABC6EA28FA9B52CC5D57")
    public int getSocketTimeout() {
        if (this.socket != null) {
            try {
                return this.socket.getSoTimeout();
            } catch (SocketException ignore) {
                return -1;
            }
        } else {
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.443 -0500", hash_original_method = "CEF80ABEDD17E9F414E04B4979CC6A82", hash_generated_method = "C3605AB6514A2B9C5B898F69DC37D353")
    public void shutdown() throws IOException {
        this.open = false;
        Socket tmpsocket = this.socket;
        if (tmpsocket != null) {
            tmpsocket.close();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.444 -0500", hash_original_method = "E2A0230BE95C4B74092464470E281A24", hash_generated_method = "0212C870A827603A75CFFEDCEE597CF0")
    public void close() throws IOException {
        if (!this.open) {
            return;
        }
        this.open = false;
        doFlush();
        try {
            try {
                this.socket.shutdownOutput();
            } catch (IOException ignore) {
            }
            try {
                this.socket.shutdownInput();
            } catch (IOException ignore) {
            }
        } catch (UnsupportedOperationException ignore) {
            // if one isn't supported, the other one isn't either
        }
        this.socket.close();
    }

    /**
     * Sends the request line and all headers over the connection.
     * @param request the request whose headers to send.
     * @throws HttpException
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.445 -0500", hash_original_method = "9CF9D3D7B73D0AA22EE5EB3E861EF60E", hash_generated_method = "81445D5814C6BEA82945B6FFD6FF302A")
    public void sendRequestHeader(final HttpRequest request)
            throws HttpException, IOException {
        if (request == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
        assertOpen();
        this.requestWriter.write(request);
        this.metrics.incrementRequestCount();
    }

    /**
     * Sends the request entity over the connection.
     * @param request the request whose entity to send.
     * @throws HttpException
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.445 -0500", hash_original_method = "73C1557906EF5C67B1A62D382FCB88AB", hash_generated_method = "238D8AF41F3258C0147B298BF895C371")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.446 -0500", hash_original_method = "DE0B8B580EE6D4219521C9A2503EB8AB", hash_generated_method = "95B55363290D586DFB2DF36999E3EB5A")
    protected void doFlush() throws IOException {
        this.outbuffer.flush();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.447 -0500", hash_original_method = "166CB1CAE087E4752127F8680D07EE90", hash_generated_method = "7DC12AEDC1E3BAC50748171377DE0490")
    public void flush() throws IOException {
        assertOpen();
        doFlush();
    }

    /**
     * Parses the response headers and adds them to the
     * given {@code headers} object, and returns the response StatusLine
     * @param headers store parsed header to headers.
     * @throws IOException
     * @return StatusLine
     * @see HttpClientConnection#receiveResponseHeader()
      */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.448 -0500", hash_original_method = "5382496E6517DB13491696C30DF0839D", hash_generated_method = "0FB17C3737EC5FCAD6265FF322D190DC")
    public StatusLine parseResponseHeader(Headers headers)
            throws IOException, ParseException {
        assertOpen();

        CharArrayBuffer current = new CharArrayBuffer(64);

        if (inbuffer.readLine(current) == -1) {
            throw new NoHttpResponseException("The target server failed to respond");
        }

        // Create the status line from the status string
        StatusLine statusline = BasicLineParser.DEFAULT.parseStatusLine(
                current, new ParserCursor(0, current.length()));
        
        if (HttpLog.LOGV) HttpLog.v("read: " + statusline);
        int statusCode = statusline.getStatusCode();

        // Parse header body
        CharArrayBuffer previous = null;
        int headerNumber = 0;
        while(true) {
            if (current == null) {
                current = new CharArrayBuffer(64);
            } else {
                // This must be he buffer used to parse the status
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
            char first = current.charAt(0);
            if ((first == ' ' || first == '\t') && previous != null) {
                // we have continuation folded header
                // so append value
                int start = 0;
                int length = current.length();
                while (start < length) {
                    char ch = current.charAt(start);
                    if (ch != ' ' && ch != '\t') {
                        break;
                    }
                    start++;
                }
                if (maxLineLength > 0 &&
                        previous.length() + 1 + current.length() - start >
                            maxLineLength) {
                    throw new IOException("Maximum line length limit exceeded");
                }
                previous.append(' ');
                previous.append(current, start, current.length() - start);
            } else {
                if (previous != null) {
                    headers.parseHeader(previous);
                }
                headerNumber++;
                previous = current;
                current = null;
            }
            if (maxHeaderCount > 0 && headerNumber >= maxHeaderCount) {
                throw new IOException("Maximum header count exceeded");
            }
        }

        if (previous != null) {
            headers.parseHeader(previous);
        }

        if (statusCode >= 200) {
            this.metrics.incrementResponseCount();
        }
        return statusline;
    }

    /**
     * Return the next response entity.
     * @param headers contains values for parsing entity
     * @see HttpClientConnection#receiveResponseEntity(HttpResponse response)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.449 -0500", hash_original_method = "1E84D06F522FAB67F7B7209EA462145E", hash_generated_method = "2132BBACB0AA83CF35658A046EFF1076")
    public HttpEntity receiveResponseEntity(final Headers headers) {
        assertOpen();
        BasicHttpEntity entity = new BasicHttpEntity();

        long len = determineLength(headers);
        if (len == ContentLengthStrategy.CHUNKED) {
            entity.setChunked(true);
            entity.setContentLength(-1);
            entity.setContent(new ChunkedInputStream(inbuffer));
        } else if (len == ContentLengthStrategy.IDENTITY) {
            entity.setChunked(false);
            entity.setContentLength(-1);
            entity.setContent(new IdentityInputStream(inbuffer));
        } else {
            entity.setChunked(false);
            entity.setContentLength(len);
            entity.setContent(new ContentLengthInputStream(inbuffer, len));
        }

        String contentTypeHeader = headers.getContentType();
        if (contentTypeHeader != null) {
            entity.setContentType(contentTypeHeader);
        }
        String contentEncodingHeader = headers.getContentEncoding();
        if (contentEncodingHeader != null) {
            entity.setContentEncoding(contentEncodingHeader);
        }

       return entity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.450 -0500", hash_original_method = "DFC24C3199FB5D6CC47411FD6E7FCAFF", hash_generated_method = "36989700B1229E52071669676C89DAE6")
    private long determineLength(final Headers headers) {
        long transferEncoding = headers.getTransferEncoding();
        // We use Transfer-Encoding if present and ignore Content-Length.
        // RFC2616, 4.4 item number 3
        if (transferEncoding < Headers.NO_TRANSFER_ENCODING) {
            return transferEncoding;
        } else {
            long contentlen = headers.getContentLength();
            if (contentlen > Headers.NO_CONTENT_LENGTH) {
                return contentlen;
            } else {
                return ContentLengthStrategy.IDENTITY;
            }
        }
    }

    /**
     * Checks whether this connection has gone down.
     * Network connections may get closed during some time of inactivity
     * for several reasons. The next time a read is attempted on such a
     * connection it will throw an IOException.
     * This method tries to alleviate this inconvenience by trying to
     * find out if a connection is still usable. Implementations may do
     * that by attempting a read with a very small timeout. Thus this
     * method may block for a small amount of time before returning a result.
     * It is therefore an <i>expensive</i> operation.
     *
     * @return  <code>true</code> if attempts to use this connection are
     *          likely to succeed, or <code>false</code> if they are likely
     *          to fail and this connection should be closed
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.451 -0500", hash_original_method = "3BE812D13F4292433A7C6B8D5ADAC2E8", hash_generated_method = "1EAD57D36840D6CAEA4FEE7766AE3376")
    public boolean isStale() {
        assertOpen();
        try {
            this.inbuffer.isDataAvailable(1);
            return false;
        } catch (IOException ex) {
            return true;
        }
    }

    /**
     * Returns a collection of connection metrcis
     * @return HttpConnectionMetrics
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:32.452 -0500", hash_original_method = "B4ACF96912B4372C3DFCBFF37024F952", hash_generated_method = "7AD9A1BFEB710F66C989015EA8C10499")
    public HttpConnectionMetrics getMetrics() {
        return this.metrics;
    }

    
}

