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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.295 -0400", hash_original_field = "9EB1CE36ECBD5AF4267329395E50E86C", hash_generated_field = "0A84F656FB5724862D6D0C3942C87FC1")

    private Object mSuspendLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.295 -0400", hash_original_field = "5D27C8AB954990D67BA475D813D946C2", hash_generated_field = "BA9E563F9C3D28A8140DFC39976CEE8E")

    private boolean mSuspended = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.296 -0400", hash_original_field = "70D135DAAA1408F28858623C23C5ABD0", hash_generated_field = "97FC50A1353400AFE74E8B9443FE780C")

    private boolean mAborted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.296 -0400", hash_original_field = "1E907E04A2E7F2CE11304EA1E7E477A6", hash_generated_field = "C97CBEA2D1E657445C817C4D993F97BF")

    private HttpHost mProxyHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.296 -0400", hash_original_method = "09C25F5735AB0754281F1FBF0B28F30D", hash_generated_method = "4FFD14A4EEB91132D44FCF3DDFDDC296")
      HttpsConnection(Context context, HttpHost host, HttpHost proxy,
                    RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        mProxyHost = proxy;
        addTaint(context.getTaint());
        addTaint(host.getTaint());
        addTaint(requestFeeder.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:21.309 -0400", hash_original_method = "CE5F1A45B1025117B442485B7D853DDB", hash_generated_method = "AC0DECA411F29D56F22FA411B0F399E9")
     void setCertificate(SslCertificate certificate) {
        mCertificate = certificate;
        addTaint(certificate.getTaint());
        // ---------- Original Method ----------
        //mCertificate = certificate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.136 -0400", hash_original_method = "F14CEFDDF6A25D53C3E36A1E481088F2", hash_generated_method = "789E07614831023C96DD782CB3FC7970")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        AndroidHttpClientConnection varB4EAC82CA7396A68D541C85D26508E83_1952803033 = null; //Variable for return #1
        AndroidHttpClientConnection varB4EAC82CA7396A68D541C85D26508E83_1059099856 = null; //Variable for return #2
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
                            boolean var45D2A1AD823D35D308E7D208797200BE_1737626317 = (headerName.startsWith("proxy") || headerName.equals("keep-alive")
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
                varB4EAC82CA7396A68D541C85D26508E83_1952803033 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1059099856 = conn;
        addTaint(req.getTaint());
        AndroidHttpClientConnection varA7E53CE21691AB073D9660D615818899_771760141; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_771760141 = varB4EAC82CA7396A68D541C85D26508E83_1952803033;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_771760141 = varB4EAC82CA7396A68D541C85D26508E83_1059099856;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_771760141.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_771760141;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.156 -0400", hash_original_method = "94AF48C1BBE0D9628C41EDAE43AD4A70", hash_generated_method = "FF0103EC6473CCB6F6EDA594A28BD9D5")
    @Override
     void closeConnection() {
        {
            restartConnection(false);
        } //End block
        try 
        {
            {
                boolean var554318C54B5107CFCDE3465BA6E4A2D0_1197256165 = (mHttpClientConnection != null && mHttpClientConnection.isOpen());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.158 -0400", hash_original_method = "AF3B09D914ADDB679280100B7539789D", hash_generated_method = "CA9CEA39CE466AA305FE1A4FFB2390F9")
     void restartConnection(boolean proceed) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.161 -0400", hash_original_method = "369703D22EBB0B4280A990A7CBC1073E", hash_generated_method = "040C1F4CE103B6BFF235454E78D8F5B7")
    @Override
     String getScheme() {
        String varB4EAC82CA7396A68D541C85D26508E83_400803091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_400803091 = "https";
        varB4EAC82CA7396A68D541C85D26508E83_400803091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_400803091;
        // ---------- Original Method ----------
        //return "https";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.161 -0400", hash_original_field = "EB937D10491011CD8AC6FF9535AE63C5", hash_generated_field = "8E3EE282922FDB169CB5B6E3288B84EE")

    private static SSLSocketFactory mSslSocketFactory = null;
    static {
        initializeEngine(null);
    }
    
}

class SSLConnectionClosedByUserException extends SSLException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:22.162 -0400", hash_original_method = "1C338196B36BFFFB864A09C466046734", hash_generated_method = "12E090A5BFD5466C086FEE77A2D7DCF2")
    public  SSLConnectionClosedByUserException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
}

