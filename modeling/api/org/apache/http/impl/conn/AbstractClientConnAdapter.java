package org.apache.http.impl.conn;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.http.HttpConnectionMetrics;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.conn.OperatedClientConnection;

public abstract class AbstractClientConnAdapter implements ManagedClientConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.424 -0500", hash_original_field = "95CB9ABFDCC232EF4D3860F7B9A99D20", hash_generated_field = "93A1502471BEBD8A1D320A124A64C925")

    private  Thread executionThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.427 -0500", hash_original_field = "79C539F0631DE1ED22CABB863DF47A25", hash_generated_field = "5B1DB60EB737FCE9D8CE8B7EB0423FFA")

    private volatile ClientConnectionManager connManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.429 -0500", hash_original_field = "ECE57901F15468069ECFE1A96D6FBDF1", hash_generated_field = "917911B52507F6EAD6ABB3C534C08061")

    private volatile OperatedClientConnection wrappedConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.432 -0500", hash_original_field = "9564E52321F66E210C3F67A1DD8EAD85", hash_generated_field = "536CD81D74826635B01647B1F98CB897")

    private volatile boolean markedReusable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.434 -0500", hash_original_field = "D257EA6B1465C401242DE11DC61376AA", hash_generated_field = "E6C2D59700A91862A935CE6ECAB4AE34")

    private volatile boolean aborted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.436 -0500", hash_original_field = "55107CF285B030B92DD9E509D85ADD9E", hash_generated_field = "E04672A216F0A14E9EF0EC0ECFC2A7EA")

    private volatile long duration;

    /**
     * Creates a new connection adapter.
     * The adapter is initially <i>not</i>
     * {@link #isMarkedReusable marked} as reusable.
     *
     * @param mgr       the connection manager, or <code>null</code>
     * @param conn      the connection to wrap, or <code>null</code>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.439 -0500", hash_original_method = "F19F8D1447EDBBE8B1DB0973B5A52449", hash_generated_method = "C2F4934E25D1B0B6718C554FEAF40FD6")
    
protected AbstractClientConnAdapter(ClientConnectionManager mgr,
                                        OperatedClientConnection conn) {
        super();
        executionThread = Thread.currentThread();
        connManager = mgr;
        wrappedConnection = conn;
        markedReusable = false;
        aborted = false;
        duration = Long.MAX_VALUE;
    } // <constructor>

    /**
     * Detaches this adapter from the wrapped connection.
     * This adapter becomes useless.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.441 -0500", hash_original_method = "5CCC2D76AB339C78C9BD8A2A561C74E1", hash_generated_method = "EB65942C4CBA85DA81B2535FD453180B")
    
protected void detach() {
        wrappedConnection = null;
        connManager = null; // base class attribute
        duration = Long.MAX_VALUE;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.443 -0500", hash_original_method = "6A8409740777F9B554371FD5CA23B84B", hash_generated_method = "6C654E86E20140E0ABF98E328BA36F13")
    
protected OperatedClientConnection getWrappedConnection() {
        return wrappedConnection;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.445 -0500", hash_original_method = "D124AA8CBEEBBCAB0459F467E40DD04B", hash_generated_method = "133BA87A5E90C8491B5153DEC7BEC184")
    
protected ClientConnectionManager getManager() {
        return connManager;
    }
    
    /**
     * Asserts that the connection has not been aborted.
     *
     * @throws InterruptedIOException   if the connection has been aborted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.448 -0500", hash_original_method = "9979A78C8840F79217BFF27E2D058EEC", hash_generated_method = "2A6FD794BA745C39D70D661668FDD982")
    
protected final void assertNotAborted() throws InterruptedIOException {
        if (aborted) {
            throw new InterruptedIOException("Connection has been shut down.");
        }
    }

    /**
     * Asserts that there is a wrapped connection to delegate to.
     *
     * @throws IllegalStateException    if there is no wrapped connection
     *                                  or connection has been aborted
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.451 -0500", hash_original_method = "948816836115B6F212C1F0250C125169", hash_generated_method = "56CB4EE59BE5F1D850A81405D23C80A8")
    
protected final void assertValid(
            final OperatedClientConnection wrappedConn) {
        if (wrappedConn == null) {
            throw new IllegalStateException("No wrapped connection.");
        }
    }

    // non-javadoc, see interface HttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.453 -0500", hash_original_method = "2FF9625B0864983A43D78C23BFFFC0A5", hash_generated_method = "9CE47EA8CEBF9A737CF8F7CAD754A702")
    
public boolean isOpen() {
        OperatedClientConnection conn = getWrappedConnection();
        if (conn == null)
            return false;

        return conn.isOpen();
    }

    // non-javadoc, see interface HttpConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.455 -0500", hash_original_method = "90FAABB6F73024DC33344558EFAA1B46", hash_generated_method = "5396D4D44845553C0C6BF9F9A9A677C4")
    
public boolean isStale() {
        if (aborted)
            return true;
        OperatedClientConnection conn = getWrappedConnection();
        if (conn == null)
            return true;

        return conn.isStale();
    }

    // non-javadoc, see interface HttpConnection
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.457 -0500", hash_original_method = "B78291A4996D117FD5B4CC742670B408", hash_generated_method = "45949ADBB44FC26CB3ABD3CE14C37C14")
    
public void setSocketTimeout(int timeout) {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        conn.setSocketTimeout(timeout);
    }

    // non-javadoc, see interface HttpConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.459 -0500", hash_original_method = "BE23B10B196A5676F79C60CBBEA5CE71", hash_generated_method = "A7C1AB0296F79AAC48830049CF6E19F8")
    
public int getSocketTimeout() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getSocketTimeout();
    }

    // non-javadoc, see interface HttpConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.462 -0500", hash_original_method = "E00A8936DFAA9158B267C15F614D75D2", hash_generated_method = "8314BE72AA1ADEC5A22ABB176CE76672")
    
public HttpConnectionMetrics getMetrics() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getMetrics();
    }

    // non-javadoc, see interface HttpClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.464 -0500", hash_original_method = "4AF00870D9F2520B9D9724B955A54108", hash_generated_method = "9A5A634B8DBB1DB8F8D5CB6BACB22E4E")
    
public void flush()
        throws IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);

        conn.flush();
    }

    // non-javadoc, see interface HttpClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.466 -0500", hash_original_method = "25E2D0AFEEAE4A9FF0C3D2AE265B1F31", hash_generated_method = "300050088BB4AC5B54B72E6BEC39D420")
    
public boolean isResponseAvailable(int timeout)
        throws IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);

        return conn.isResponseAvailable(timeout);
    }

    // non-javadoc, see interface HttpClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.468 -0500", hash_original_method = "329A88989F2294EA414AFD573C61A83C", hash_generated_method = "64E15EC72FEB52320D290C92A55E76A9")
    
public void receiveResponseEntity(HttpResponse response)
        throws HttpException, IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);

        unmarkReusable();
        conn.receiveResponseEntity(response);
    }

    // non-javadoc, see interface HttpClientConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.471 -0500", hash_original_method = "DE944D48C7CF4AE77CB8336F5E9ECC2B", hash_generated_method = "BF986F6456DE99062AC4DD51D794143A")
    
public HttpResponse receiveResponseHeader()
        throws HttpException, IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);

        unmarkReusable();
        return conn.receiveResponseHeader();
    }

    // non-javadoc, see interface HttpClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.473 -0500", hash_original_method = "BB213D1ED83C696B5F4C4C57285E4F37", hash_generated_method = "EC16C7083A0B3AA0467277FF489F59B8")
    
public void sendRequestEntity(HttpEntityEnclosingRequest request)
        throws HttpException, IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);

        unmarkReusable();
        conn.sendRequestEntity(request);
    }

    // non-javadoc, see interface HttpClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.476 -0500", hash_original_method = "54941B5E0F36540E3C9EF8677D0A50F2", hash_generated_method = "42B3D9752BDC155239DE0850D079D54C")
    
public void sendRequestHeader(HttpRequest request)
        throws HttpException, IOException {

        assertNotAborted();
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        
        unmarkReusable();
        conn.sendRequestHeader(request);
    }

    // non-javadoc, see interface HttpInetConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.478 -0500", hash_original_method = "24C66DF3AC644AC2F2EBA8DCA3FC4629", hash_generated_method = "CB15477C669233D9C5E8AD9E9A542EB7")
    
public InetAddress getLocalAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getLocalAddress();
    }

    // non-javadoc, see interface HttpInetConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.481 -0500", hash_original_method = "CFFC28C49AC23EFEB6812E81E4BB886D", hash_generated_method = "EF27723DF665D396C1A7AC25EE90DBA0")
    
public int getLocalPort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getLocalPort();
    }

    // non-javadoc, see interface HttpInetConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.483 -0500", hash_original_method = "600F3FFEA838B52DB2FC8A00D0FD1454", hash_generated_method = "6F67633A1CE13E3F434C06255A40D727")
    
public InetAddress getRemoteAddress() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getRemoteAddress();
    }

    // non-javadoc, see interface HttpInetConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.485 -0500", hash_original_method = "8BDC367E1BB67504AED838B12612BDA6", hash_generated_method = "A700C69947294E647BAFB16D435A6E0A")
    
public int getRemotePort() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.getRemotePort();
    }

    // non-javadoc, see interface ManagedClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.487 -0500", hash_original_method = "4D12F5B41CA786A718C0CE38C40DC2DA", hash_generated_method = "CFB9C5A002D19B2C2CC755CCD770F581")
    
public boolean isSecure() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        return conn.isSecure();
    }

    // non-javadoc, see interface ManagedClientConnection
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.489 -0500", hash_original_method = "08E9B3DBCD970FB9C319F7E659C9D167", hash_generated_method = "68CE9245CAAE3EAD9D28CA0EFCB9F937")
    
public SSLSession getSSLSession() {
        OperatedClientConnection conn = getWrappedConnection();
        assertValid(conn);
        if (!isOpen())
            return null;

        SSLSession result = null;
        Socket    sock    = conn.getSocket();
        if (sock instanceof SSLSocket) {
            result = ((SSLSocket)sock).getSession();
        }
        return result;
    }

    // non-javadoc, see interface ManagedClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.491 -0500", hash_original_method = "839709285FE118C452FA26DE879FFB1D", hash_generated_method = "B5F7A7FB90A3EAE19D18EC0795313EFA")
    
public void markReusable() {
        markedReusable = true;
    }

    // non-javadoc, see interface ManagedClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.494 -0500", hash_original_method = "7923E01503297FB76AA22E34EEF6FDF5", hash_generated_method = "A2B9C68EB7ABEDF1B41C2F39418CAB5F")
    
public void unmarkReusable() {
        markedReusable = false;
    }

    // non-javadoc, see interface ManagedClientConnection
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.496 -0500", hash_original_method = "2387742F6BF9638BB6ECF14FF1FDB0EE", hash_generated_method = "A512F91C42F3F1A271B8CAB0560BBF74")
    
public boolean isMarkedReusable() {
        return markedReusable;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.498 -0500", hash_original_method = "37F53EE2ADE585D06847009D28379E6D", hash_generated_method = "7850A588B2820F40ED6E1734A7F434E7")
    
public void setIdleDuration(long duration, TimeUnit unit) {
        if(duration > 0) {
            this.duration = unit.toMillis(duration);
        } else {
            this.duration = -1;
        }
    }

    // non-javadoc, see interface ConnectionReleaseTrigger
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.500 -0500", hash_original_method = "6E364751B79392C296E473C8CD17B57B", hash_generated_method = "16999BA65EDCE6FD3FB3B14BB939A9FD")
    
public void releaseConnection() {
        if (connManager != null) {
            connManager.releaseConnection(this, duration, TimeUnit.MILLISECONDS);
        }
    }

    // non-javadoc, see interface ConnectionReleaseTrigger
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:33.503 -0500", hash_original_method = "8C46EA9A337087A0A63A85A9D3E05177", hash_generated_method = "90F2B3A17D1BD88B6424C285D0B86C53")
    
public void abortConnection() {
        if (aborted) {
            return;
        }
        aborted = true;
        unmarkReusable();
        try {
            shutdown();
        } catch (IOException ignore) {
        }
        // Usually #abortConnection() is expected to be called from 
        // a helper thread in order to unblock the main execution thread 
        // blocked in an I/O operation. It may be unsafe to call 
        // #releaseConnection() from the helper thread, so we have to rely
        // on an IOException thrown by the closed socket on the main thread 
        // to trigger the release of the connection back to the 
        // connection manager.
        // 
        // However, if this method is called from the main execution thread 
        // it should be safe to release the connection immediately. Besides, 
        // this also helps ensure the connection gets released back to the 
        // manager if #abortConnection() is called from the main execution 
        // thread while there is no blocking I/O operation.
        if (executionThread.equals(Thread.currentThread())) {
            releaseConnection();
        }
    }
    
}

