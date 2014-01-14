package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.harmony.xnet.provider.jsse.FileClientSessionCache;
import org.apache.harmony.xnet.provider.jsse.OpenSSLContextImpl;
import org.apache.harmony.xnet.provider.jsse.SSLClientSessionCache;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.BasicHttpRequest;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.util.Log;

public class HttpsConnection extends Connection {
    
    public static void initializeEngine(File sessionDir) {
        try {
            SSLClientSessionCache cache = null;
            if (sessionDir != null) {
                Log.d("HttpsConnection", "Caching SSL sessions in "
                        + sessionDir + ".");
                cache = FileClientSessionCache.usingDirectory(sessionDir);
            }
            OpenSSLContextImpl sslContext = new OpenSSLContextImpl();
            TrustManager[] trustManagers = new TrustManager[] {
                new X509TrustManager() {
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.698 -0500", hash_original_method = "26F2D3EE02564BFED1F63E8224D261E2", hash_generated_method = "4B421804C4196085705F57A169F61AAF")
                
public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.701 -0500", hash_original_method = "8BEE625C472E5C247B0F67569E87EB34", hash_generated_method = "F756548F393463E0C8D93B459A266B14")
                
public void checkClientTrusted(
                        X509Certificate[] certs, String authType) {
                    }

                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.704 -0500", hash_original_method = "B887E524006B0C946A6E6D3AF1B3859E", hash_generated_method = "9A95F409B60F21956FB15D9D594D5808")
                
public void checkServerTrusted(
                        X509Certificate[] certs, String authType) {
                    }
                }
            };
            sslContext.engineInit(null, trustManagers, null);
            sslContext.engineGetClientSessionContext().setPersistentCache(cache);
            synchronized (HttpsConnection.class) {
                mSslSocketFactory = sslContext.engineGetSocketFactory();
            }
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.709 -0500", hash_original_method = "85F174ABC4055BEA52A3B6ED8F0BA48D", hash_generated_method = "C029373C9E1D524F94FA7302D85722C8")
    
private synchronized static SSLSocketFactory getSocketFactory() {
        return mSslSocketFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.694 -0500", hash_original_field = "C0E8772F63B6CB66BA5EF399681285B7", hash_generated_field = "8E3EE282922FDB169CB5B6E3288B84EE")

    private static SSLSocketFactory mSslSocketFactory = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.711 -0500", hash_original_field = "A78075C6B404E1A3729B2564AA0E1FCC", hash_generated_field = "0A84F656FB5724862D6D0C3942C87FC1")

    private Object mSuspendLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.713 -0500", hash_original_field = "99486750A96AC48100839A0EF6F5FA03", hash_generated_field = "BA9E563F9C3D28A8140DFC39976CEE8E")

    private boolean mSuspended = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.716 -0500", hash_original_field = "A3D94C28DC24D0838F1204401C40E70B", hash_generated_field = "97FC50A1353400AFE74E8B9443FE780C")

    private boolean mAborted = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.718 -0500", hash_original_field = "8D07AC44AA4C74B2AC6E6F002329824C", hash_generated_field = "C97CBEA2D1E657445C817C4D993F97BF")

    private HttpHost mProxyHost;

    /**
     * Contructor for a https connection.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.720 -0500", hash_original_method = "09C25F5735AB0754281F1FBF0B28F30D", hash_generated_method = "09C25F5735AB0754281F1FBF0B28F30D")
    
HttpsConnection(Context context, HttpHost host, HttpHost proxy,
                    RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        mProxyHost = proxy;
    }

    /**
     * Sets the server SSL certificate associated with this
     * connection.
     * @param certificate The SSL certificate
     */
    /* package */ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.722 -0500", hash_original_method = "CE5F1A45B1025117B442485B7D853DDB", hash_generated_method = "CE5F1A45B1025117B442485B7D853DDB")
    
void setCertificate(SslCertificate certificate) {
        mCertificate = certificate;
    }

    /**
     * Opens the connection to a http server or proxy.
     *
     * @return the opened low level connection
     * @throws IOException if the connection fails for any reason.
     */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.727 -0500", hash_original_method = "F14CEFDDF6A25D53C3E36A1E481088F2", hash_generated_method = "622D4DB076F02438468DE4A4417A69A2")
    
@Override
    AndroidHttpClientConnection openConnection(Request req) throws IOException {
        SSLSocket sslSock = null;

        if (mProxyHost != null) {
            // If we have a proxy set, we first send a CONNECT request
            // to the proxy; if the proxy returns 200 OK, we negotiate
            // a secure connection to the target server via the proxy.
            // If the request fails, we drop it, but provide the event
            // handler with the response status and headers. The event
            // handler is then responsible for cancelling the load or
            // issueing a new request.
            AndroidHttpClientConnection proxyConnection = null;
            Socket proxySock = null;
            try {
                proxySock = new Socket
                    (mProxyHost.getHostName(), mProxyHost.getPort());

                proxySock.setSoTimeout(60 * 1000);

                proxyConnection = new AndroidHttpClientConnection();
                HttpParams params = new BasicHttpParams();
                HttpConnectionParams.setSocketBufferSize(params, 8192);

                proxyConnection.bind(proxySock, params);
            } catch(IOException e) {
                if (proxyConnection != null) {
                    proxyConnection.close();
                }

                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage =
                        "failed to establish a connection to the proxy";
                }

                throw new IOException(errorMessage);
            }

            StatusLine statusLine = null;
            int statusCode = 0;
            Headers headers = new Headers();
            try {
                BasicHttpRequest proxyReq = new BasicHttpRequest
                    ("CONNECT", mHost.toHostString());

                // add all 'proxy' headers from the original request, we also need
                // to add 'host' header unless we want proxy to answer us with a
                // 400 Bad Request
                for (Header h : req.mHttpRequest.getAllHeaders()) {
                    String headerName = h.getName().toLowerCase();
                    if (headerName.startsWith("proxy") || headerName.equals("keep-alive")
                            || headerName.equals("host")) {
                        proxyReq.addHeader(h);
                    }
                }

                proxyConnection.sendRequestHeader(proxyReq);
                proxyConnection.flush();

                // it is possible to receive informational status
                // codes prior to receiving actual headers;
                // all those status codes are smaller than OK 200
                // a loop is a standard way of dealing with them
                do {
                    statusLine = proxyConnection.parseResponseHeader(headers);
                    statusCode = statusLine.getStatusCode();
                } while (statusCode < HttpStatus.SC_OK);
            } catch (ParseException e) {
                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage =
                        "failed to send a CONNECT request";
                }

                throw new IOException(errorMessage);
            } catch (HttpException e) {
                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage =
                        "failed to send a CONNECT request";
                }

                throw new IOException(errorMessage);
            } catch (IOException e) {
                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage =
                        "failed to send a CONNECT request";
                }

                throw new IOException(errorMessage);
            }

            if (statusCode == HttpStatus.SC_OK) {
                try {
                    sslSock = (SSLSocket) getSocketFactory().createSocket(
                            proxySock, mHost.getHostName(), mHost.getPort(), true);
                } catch(IOException e) {
                    if (sslSock != null) {
                        sslSock.close();
                    }

                    String errorMessage = e.getMessage();
                    if (errorMessage == null) {
                        errorMessage =
                            "failed to create an SSL socket";
                    }
                    throw new IOException(errorMessage);
                }
            } else {
                // if the code is not OK, inform the event handler
                ProtocolVersion version = statusLine.getProtocolVersion();

                req.mEventHandler.status(version.getMajor(),
                                         version.getMinor(),
                                         statusCode,
                                         statusLine.getReasonPhrase());
                req.mEventHandler.headers(headers);
                req.mEventHandler.endData();

                proxyConnection.close();

                // here, we return null to indicate that the original
                // request needs to be dropped
                return null;
            }
        } else {
            // if we do not have a proxy, we simply connect to the host
            try {
                sslSock = (SSLSocket) getSocketFactory().createSocket(
                        mHost.getHostName(), mHost.getPort());
                sslSock.setSoTimeout(SOCKET_TIMEOUT);
            } catch(IOException e) {
                if (sslSock != null) {
                    sslSock.close();
                }

                String errorMessage = e.getMessage();
                if (errorMessage == null) {
                    errorMessage = "failed to create an SSL socket";
                }

                throw new IOException(errorMessage);
            }
        }

        // do handshake and validate server certificates
        SslError error = CertificateChainValidator.getInstance().
            doHandshakeAndValidateServerCertificates(this, sslSock, mHost.getHostName());

        // Inform the user if there is a problem
        if (error != null) {
            // handleSslErrorRequest may immediately unsuspend if it wants to
            // allow the certificate anyway.
            // So we mark the connection as suspended, call handleSslErrorRequest
            // then check if we're still suspended and only wait if we actually
            // need to.
            synchronized (mSuspendLock) {
                mSuspended = true;
            }
            // don't hold the lock while calling out to the event handler
            boolean canHandle = req.getEventHandler().handleSslErrorRequest(error);
            if(!canHandle) {
                throw new IOException("failed to handle "+ error);
            }
            synchronized (mSuspendLock) {
                if (mSuspended) {
                    try {
                        // Put a limit on how long we are waiting; if the timeout
                        // expires (which should never happen unless you choose
                        // to ignore the SSL error dialog for a very long time),
                        // we wake up the thread and abort the request. This is
                        // to prevent us from stalling the network if things go
                        // very bad.
                        mSuspendLock.wait(10 * 60 * 1000);
                        if (mSuspended) {
                            // mSuspended is true if we have not had a chance to
                            // restart the connection yet (ie, the wait timeout
                            // has expired)
                            mSuspended = false;
                            mAborted = true;
                            if (HttpLog.LOGV) {
                                HttpLog.v("HttpsConnection.openConnection():" +
                                          " SSL timeout expired and request was cancelled!!!");
                            }
                        }
                    } catch (InterruptedException e) {
                        // ignore
                    }
                }
                if (mAborted) {
                    // The user decided not to use this unverified connection
                    // so close it immediately.
                    sslSock.close();
                    throw new SSLConnectionClosedByUserException("connection closed by the user");
                }
            }
        }

        // All went well, we have an open, verified connection.
        AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        BasicHttpParams params = new BasicHttpParams();
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sslSock, params);

        return conn;
    }

    /**
     * Closes the low level connection.
     *
     * If an exception is thrown then it is assumed that the connection will
     * have been closed (to the extent possible) anyway and the caller does not
     * need to take any further action.
     *
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.730 -0500", hash_original_method = "94AF48C1BBE0D9628C41EDAE43AD4A70", hash_generated_method = "6F750470763A09962F7C3949B80129FE")
    
@Override
    void closeConnection() {
        // if the connection has been suspended due to an SSL error
        if (mSuspended) {
            // wake up the network thread
            restartConnection(false);
        }

        try {
            if (mHttpClientConnection != null && mHttpClientConnection.isOpen()) {
                mHttpClientConnection.close();
            }
        } catch (IOException e) {
            if (HttpLog.LOGV)
                HttpLog.v("HttpsConnection.closeConnection():" +
                          " failed closing connection " + mHost);
            e.printStackTrace();
        }
    }

    /**
     * Restart a secure connection suspended waiting for user interaction.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.733 -0500", hash_original_method = "AF3B09D914ADDB679280100B7539789D", hash_generated_method = "AF3B09D914ADDB679280100B7539789D")
    
void restartConnection(boolean proceed) {
        if (HttpLog.LOGV) {
            HttpLog.v("HttpsConnection.restartConnection():" +
                      " proceed: " + proceed);
        }

        synchronized (mSuspendLock) {
            if (mSuspended) {
                mSuspended = false;
                mAborted = !proceed;
                mSuspendLock.notify();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.735 -0500", hash_original_method = "369703D22EBB0B4280A990A7CBC1073E", hash_generated_method = "C7BD68F4A3F52626B3EE16BC0A450363")
    
@Override
    String getScheme() {
        return "https";
    }
    static {
        initializeEngine(null);
    }
    
    // orphaned legacy method
    public void checkServerTrusted(
                        X509Certificate[] certs, String authType) {
                    }
    
    // orphaned legacy method
    public void checkClientTrusted(
                        X509Certificate[] certs, String authType) {
                    }
    
    // orphaned legacy method
    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
    
}

class SSLConnectionClosedByUserException extends SSLException {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:13.737 -0500", hash_original_method = "1C338196B36BFFFB864A09C466046734", hash_generated_method = "FA4B5BC32C579A431C293C3392E7A18A")
    
public SSLConnectionClosedByUserException(String reason) {
        super(reason);
    }
    
}

