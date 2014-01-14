package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
//import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseFactory;
import org.apache.http.conn.OperatedClientConnection;
import org.apache.http.impl.SocketHttpClientConnection;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.HttpParams;

public class DefaultClientConnection extends SocketHttpClientConnection implements OperatedClientConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.947 -0500", hash_original_field = "0DA7E40E862C937570CA6B0D96D2555A", hash_generated_field = "3FCE5BFF671FE7B3BB3E2D744C5E5D2C")

    private final Log log = LogFactory.getLog(getClass());
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.949 -0500", hash_original_field = "829678FA634ACEE921693B24B6E2260B", hash_generated_field = "4E5EA705088864E33B87793C6FE07C16")

    private final Log headerLog = LogFactory.getLog("org.apache.http.headers");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.952 -0500", hash_original_field = "5B2BD4940BE9077FABC0BF99C3975303", hash_generated_field = "A13F3EDC8B3D2050126D58CBAE58152B")

    private final Log wireLog = LogFactory.getLog("org.apache.http.wire");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.954 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "50659BF88C73A03DFC94D9CBD95233DD")

    private volatile Socket socket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.956 -0500", hash_original_field = "905C01B4FE2157113AE81815E13AB5AC", hash_generated_field = "7B58806231BEF3BA039CB1C0F515C7D6")

    private HttpHost targetHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.959 -0500", hash_original_field = "4CBBE339597DE9B394DE2052B5856BB5", hash_generated_field = "5985EB8DABB6B518B89C4CD8CA0ADA5A")

    private boolean connSecure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.961 -0500", hash_original_field = "329557AAEAF0ABDABA883FE6E2403C7B", hash_generated_field = "9C150001B868C03DDA27B7582F7794C7")

    private volatile boolean shutdown;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.963 -0500", hash_original_method = "90469C020BD0C2691C8C778F609E10DE", hash_generated_method = "71B2B2ABCF6DAD2E7D91FE82AA783C86")
    
public DefaultClientConnection() {
        super();
    }

    // non-javadoc, see interface OperatedClientConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.965 -0500", hash_original_method = "00F8E4422BF57DE6758D681F4A99BDB6", hash_generated_method = "3CF09B50D9FFB38E80EC0DF2754F3C7C")
    
public final HttpHost getTargetHost() {
        return this.targetHost;
    }

    // non-javadoc, see interface OperatedClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.967 -0500", hash_original_method = "4971CDDD7E23679E1EB91619B0566CC2", hash_generated_method = "F0F41AD121783742A0435B44AE89C557")
    
public final boolean isSecure() {
        return this.connSecure;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.970 -0500", hash_original_method = "B12AAA9EA995C0C9BE2466476E8BAC96", hash_generated_method = "3D8353C63A7C48193173CB46F79167E0")
    
@Override
    public final Socket getSocket() {
        return this.socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.972 -0500", hash_original_method = "DA5079B0FADB5957D7F2D5BE061C8D7D", hash_generated_method = "BB4F63F64DCF4298277358E8BB49A459")
    
public void opening(Socket sock, HttpHost target) throws IOException {
        assertNotOpen();        
        this.socket = sock;
        this.targetHost = target;
        
        // Check for shutdown after assigning socket, so that 
        if (this.shutdown) {
            sock.close(); // allow this to throw...
            // ...but if it doesn't, explicitly throw one ourselves.
            throw new IOException("Connection already shutdown");
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.976 -0500", hash_original_method = "238B4BA0F77ED507B3FA0211642C8510", hash_generated_method = "D49258516D8D5A023BDA1019F05A3A0B")
    
public void openCompleted(boolean secure, HttpParams params) throws IOException {
        assertNotOpen();
        if (params == null) {
            throw new IllegalArgumentException
                ("Parameters must not be null.");
        }
        this.connSecure = secure;
        bind(this.socket, params);
    }

    /**
     * Force-closes this connection.
     * If the connection is still in the process of being open (the method 
     * {@link #opening opening} was already called but 
     * {@link #openCompleted openCompleted} was not), the associated 
     * socket that is being connected to a remote address will be closed. 
     * That will interrupt a thread that is blocked on connecting 
     * the socket.
     * If the connection is not yet open, this will prevent the connection
     * from being opened.
     *
     * @throws IOException      in case of a problem
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.978 -0500", hash_original_method = "2C3D09F7EAB3530485FB76A4EFF6AEB8", hash_generated_method = "7E9B1E9561D6F56E2D9967294C1D3F51")
    
@Override
    public void shutdown() throws IOException {
        log.debug("Connection shut down");
        shutdown = true;
        
        super.shutdown();        
        Socket sock = this.socket; // copy volatile attribute
        if (sock != null)
            sock.close();

    } // shutdown
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.980 -0500", hash_original_method = "4ADF205732DDD49A8E02AC6258F60F5A", hash_generated_method = "3E57170AE597C32891CBD42CB0BCB8EE")
    
@Override
    public void close() throws IOException {
        log.debug("Connection closed");
        super.close();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.983 -0500", hash_original_method = "8F7D1845D5CBAF2D176D233AC7877F21", hash_generated_method = "BDC1BA0C1EDA0F9139D2824012EE206A")
    
@Override
    protected SessionInputBuffer createSessionInputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionInputBuffer inbuffer = super.createSessionInputBuffer(
                socket, 
                buffersize,
                params);
        if (wireLog.isDebugEnabled()) {
            inbuffer = new LoggingSessionInputBuffer(inbuffer, new Wire(wireLog));
        }
        return inbuffer;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.985 -0500", hash_original_method = "17D3D45553913AFCC8694294B924BCA4", hash_generated_method = "B58E1E68FC97D65E887D3E0DA016633D")
    
@Override
    protected SessionOutputBuffer createSessionOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        SessionOutputBuffer outbuffer = super.createSessionOutputBuffer(
                socket,
                buffersize,
                params);
        if (wireLog.isDebugEnabled()) {
            outbuffer = new LoggingSessionOutputBuffer(outbuffer, new Wire(wireLog));
        }
        return outbuffer;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.988 -0500", hash_original_method = "8A983123757D80237B42B0E1C96CF087", hash_generated_method = "29927BB685F786B1B3851BA4DDB492DE")
    
@Override
    protected HttpMessageParser createResponseParser(
            final SessionInputBuffer buffer,
            final HttpResponseFactory responseFactory, 
            final HttpParams params) {
        // override in derived class to specify a line parser
        return new DefaultResponseParser
            (buffer, null, responseFactory, params);
    }

    // non-javadoc, see interface OperatedClientConnection
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.990 -0500", hash_original_method = "9118767905DEE596C55572AB6CA12E81", hash_generated_method = "48D943099F3E8633756AD572356F9710")
    
public void update(Socket sock, HttpHost target,
                       boolean secure, HttpParams params)
        throws IOException {

        assertOpen();
        if (target == null) {
            throw new IllegalArgumentException
                ("Target host must not be null.");
        }
        if (params == null) {
            throw new IllegalArgumentException
                ("Parameters must not be null.");
        }

        if (sock != null) {
            this.socket = sock;
            bind(sock, params);
        }
        targetHost = target;
        connSecure = secure;

    } // update

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.993 -0500", hash_original_method = "74E39E85D143527EEDE4A43C784BFAA2", hash_generated_method = "E1C1F7E16FBB1101038B21AACFB34ED3")
    
@Override
    public HttpResponse receiveResponseHeader() throws HttpException, IOException {
        HttpResponse response = super.receiveResponseHeader();
        if (headerLog.isDebugEnabled()) {
            headerLog.debug("<< " + response.getStatusLine().toString());
            Header[] headers = response.getAllHeaders();
            for (Header header : headers) {
                headerLog.debug("<< " + header.toString());
            }
        }
        return response;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.995 -0500", hash_original_method = "8184260E56E5B05281BA00158DD30362", hash_generated_method = "145295A688F01148C93EE8D6A8077DD9")
    
@Override
    public void sendRequestHeader(HttpRequest request) throws HttpException, IOException {
        super.sendRequestHeader(request);
        if (headerLog.isDebugEnabled()) {
            headerLog.debug(">> " + request.getRequestLine().toString());
            Header[] headers = request.getAllHeaders();
            for (Header header : headers) {
                headerLog.debug(">> " + header.toString());
            }
        }
    }
    
}

