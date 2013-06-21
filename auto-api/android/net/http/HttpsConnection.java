package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.util.Log;
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
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;

public class HttpsConnection extends Connection {
    private Object mSuspendLock = new Object();
    private boolean mSuspended = false;
    private boolean mAborted = false;
    private HttpHost mProxyHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.837 -0400", hash_original_method = "09C25F5735AB0754281F1FBF0B28F30D", hash_generated_method = "4B0BC7F23B8F20E7318578CCFBD24F31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     HttpsConnection(Context context, HttpHost host, HttpHost proxy,
                    RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        dsTaint.addTaint(host.dsTaint);
        dsTaint.addTaint(requestFeeder.dsTaint);
        dsTaint.addTaint(proxy.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mProxyHost = proxy;
    }

    
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
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                    public void checkClientTrusted(
                        X509Certificate[] certs, String authType) {
                    }
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

    
        private synchronized static SSLSocketFactory getSocketFactory() {
        return mSslSocketFactory;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.838 -0400", hash_original_method = "CE5F1A45B1025117B442485B7D853DDB", hash_generated_method = "246078D096C8432C5B585B726A9E247B")
    @DSModeled(DSC.SAFE)
     void setCertificate(SslCertificate certificate) {
        dsTaint.addTaint(certificate.dsTaint);
        mCertificate = certificate;
        // ---------- Original Method ----------
        //mCertificate = certificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.883 -0400", hash_original_method = "F14CEFDDF6A25D53C3E36A1E481088F2", hash_generated_method = "BDC7CD0E2B26FA5CB64AD90CC680B264")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        dsTaint.addTaint(req.dsTaint);
        SSLSocket sslSock;
        sslSock = null;
        {
            AndroidHttpClientConnection proxyConnection;
            proxyConnection = null;
            Socket proxySock;
            proxySock = null;
            try 
            {
                proxySock = new Socket
                    (mProxyHost.getHostName(), mProxyHost.getPort());
                proxySock.setSoTimeout(60 * 1000);
                proxyConnection = new AndroidHttpClientConnection();
                HttpParams params;
                params = new BasicHttpParams();
                HttpConnectionParams.setSocketBufferSize(params, 8192);
                proxyConnection.bind(proxySock, params);
            } //End block
            catch (IOException e)
            {
                {
                    proxyConnection.close();
                } //End block
                String errorMessage;
                errorMessage = e.getMessage();
                {
                    errorMessage =
                        "failed to establish a connection to the proxy";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
            } //End block
            StatusLine statusLine;
            statusLine = null;
            int statusCode;
            statusCode = 0;
            Headers headers;
            headers = new Headers();
            try 
            {
                BasicHttpRequest proxyReq;
                proxyReq = new BasicHttpRequest
                    ("CONNECT", mHost.toHostString());
                {
                    Header h = req.mHttpRequest.getAllHeaders()[0];
                    {
                        String headerName;
                        headerName = h.getName().toLowerCase();
                        {
                            boolean var45D2A1AD823D35D308E7D208797200BE_2111214787 = (headerName.startsWith("proxy") || headerName.equals("keep-alive")
                            || headerName.equals("host"));
                            {
                                proxyReq.addHeader(h);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                proxyConnection.sendRequestHeader(proxyReq);
                proxyConnection.flush();
                {
                    statusLine = proxyConnection.parseResponseHeader(headers);
                    statusCode = statusLine.getStatusCode();
                } //End block
            } //End block
            catch (ParseException e)
            {
                String errorMessage;
                errorMessage = e.getMessage();
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
            } //End block
            catch (HttpException e)
            {
                String errorMessage;
                errorMessage = e.getMessage();
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
            } //End block
            catch (IOException e)
            {
                String errorMessage;
                errorMessage = e.getMessage();
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
            } //End block
            {
                try 
                {
                    sslSock = (SSLSocket) getSocketFactory().createSocket(
                            proxySock, mHost.getHostName(), mHost.getPort(), true);
                } //End block
                catch (IOException e)
                {
                    {
                        sslSock.close();
                    } //End block
                    String errorMessage;
                    errorMessage = e.getMessage();
                    {
                        errorMessage =
                            "failed to create an SSL socket";
                    } //End block
                    if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
                } //End block
            } //End block
            {
                ProtocolVersion version;
                version = statusLine.getProtocolVersion();
                req.mEventHandler.status(version.getMajor(),
                                         version.getMinor(),
                                         statusCode,
                                         statusLine.getReasonPhrase());
                req.mEventHandler.headers(headers);
                req.mEventHandler.endData();
                proxyConnection.close();
            } //End block
        } //End block
        {
            try 
            {
                sslSock = (SSLSocket) getSocketFactory().createSocket(
                        mHost.getHostName(), mHost.getPort());
                sslSock.setSoTimeout(SOCKET_TIMEOUT);
            } //End block
            catch (IOException e)
            {
                {
                    sslSock.close();
                } //End block
                String errorMessage;
                errorMessage = e.getMessage();
                {
                    errorMessage = "failed to create an SSL socket";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new IOException(errorMessage);
            } //End block
        } //End block
        SslError error;
        error = CertificateChainValidator.getInstance().
            doHandshakeAndValidateServerCertificates(this, sslSock, mHost.getHostName());
        {
            {
                mSuspended = true;
            } //End block
            boolean canHandle;
            canHandle = req.getEventHandler().handleSslErrorRequest(error);
            {
                if (DroidSafeAndroidRuntime.control) throw new IOException("failed to handle "+ error);
            } //End block
            {
                {
                    try 
                    {
                        mSuspendLock.wait(10 * 60 * 1000);
                        {
                            mSuspended = false;
                            mAborted = true;
                            {
                                HttpLog.v("HttpsConnection.openConnection():" +
                                          " SSL timeout expired and request was cancelled!!!");
                            } //End block
                        } //End block
                    } //End block
                    catch (InterruptedException e)
                    { }
                } //End block
                {
                    sslSock.close();
                    if (DroidSafeAndroidRuntime.control) throw new SSLConnectionClosedByUserException("connection closed by the user");
                } //End block
            } //End block
        } //End block
        AndroidHttpClientConnection conn;
        conn = new AndroidHttpClientConnection();
        BasicHttpParams params;
        params = new BasicHttpParams();
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sslSock, params);
        return (AndroidHttpClientConnection)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.884 -0400", hash_original_method = "94AF48C1BBE0D9628C41EDAE43AD4A70", hash_generated_method = "6EDE6C791EEFE0779F858865EEE39874")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
     void closeConnection() {
        {
            restartConnection(false);
        } //End block
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_1748603286 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
                {
                    mHttpClientConnection.close();
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (IOException e)
        {
            HttpLog.v("HttpsConnection.closeConnection():" +
                          " failed closing connection " + mHost);
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //if (mSuspended) {
            //restartConnection(false);
        //}
        //try {
            //if (mHttpClientConnection != null && mHttpClientConnection.isOpen()) {
                //mHttpClientConnection.close();
            //}
        //} catch (IOException e) {
            //if (HttpLog.LOGV)
                //HttpLog.v("HttpsConnection.closeConnection():" +
                          //" failed closing connection " + mHost);
            //e.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.885 -0400", hash_original_method = "AF3B09D914ADDB679280100B7539789D", hash_generated_method = "98FA51F39622EF8D27E2D1FC57038395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void restartConnection(boolean proceed) {
        dsTaint.addTaint(proceed);
        {
            HttpLog.v("HttpsConnection.restartConnection():" +
                      " proceed: " + proceed);
        } //End block
        {
            {
                mSuspended = false;
                mAborted = !proceed;
                mSuspendLock.notify();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (HttpLog.LOGV) {
            //HttpLog.v("HttpsConnection.restartConnection():" +
                      //" proceed: " + proceed);
        //}
        //synchronized (mSuspendLock) {
            //if (mSuspended) {
                //mSuspended = false;
                //mAborted = !proceed;
                //mSuspendLock.notify();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.886 -0400", hash_original_method = "369703D22EBB0B4280A990A7CBC1073E", hash_generated_method = "CC3C25C90382589B28CB8083888103E3")
    @DSModeled(DSC.SAFE)
    @Override
     String getScheme() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "https";
    }

    
    private static SSLSocketFactory mSslSocketFactory = null;
    static {
        initializeEngine(null);
    }
    
}

class SSLConnectionClosedByUserException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.886 -0400", hash_original_method = "1C338196B36BFFFB864A09C466046734", hash_generated_method = "25E35DB1B7E4E4BDB0EA5CF78C587A96")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLConnectionClosedByUserException(String reason) {
        super(reason);
        dsTaint.addTaint(reason);
        // ---------- Original Method ----------
    }

    
}

