package android.net.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.228 -0400", hash_original_field = "9EB1CE36ECBD5AF4267329395E50E86C", hash_generated_field = "0A84F656FB5724862D6D0C3942C87FC1")

    private Object mSuspendLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.228 -0400", hash_original_field = "5D27C8AB954990D67BA475D813D946C2", hash_generated_field = "BA9E563F9C3D28A8140DFC39976CEE8E")

    private boolean mSuspended = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.228 -0400", hash_original_field = "70D135DAAA1408F28858623C23C5ABD0", hash_generated_field = "97FC50A1353400AFE74E8B9443FE780C")

    private boolean mAborted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.228 -0400", hash_original_field = "1E907E04A2E7F2CE11304EA1E7E477A6", hash_generated_field = "C97CBEA2D1E657445C817C4D993F97BF")

    private HttpHost mProxyHost;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.228 -0400", hash_original_method = "09C25F5735AB0754281F1FBF0B28F30D", hash_generated_method = "4937DF2BB7F4620AC3775E5E26F09720")
      HttpsConnection(Context context, HttpHost host, HttpHost proxy,
                    RequestFeeder requestFeeder) {
        super(context, host, requestFeeder);
        addTaint(requestFeeder.getTaint());
        addTaint(host.getTaint());
        addTaint(context.getTaint());
        mProxyHost = proxy;
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

    
    @DSModeled(DSC.SAFE)
    private synchronized static SSLSocketFactory getSocketFactory() {
        return mSslSocketFactory;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.229 -0400", hash_original_method = "CE5F1A45B1025117B442485B7D853DDB", hash_generated_method = "4B8075248C213E7C49A5EEBA2B95A200")
     void setCertificate(SslCertificate certificate) {
        addTaint(certificate.getTaint());
        mCertificate = certificate;
        // ---------- Original Method ----------
        //mCertificate = certificate;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.234 -0400", hash_original_method = "F14CEFDDF6A25D53C3E36A1E481088F2", hash_generated_method = "AD3B2B7020EEA8B4D642AC47C6DD5A9D")
    @Override
     AndroidHttpClientConnection openConnection(Request req) throws IOException {
        addTaint(req.getTaint());
        SSLSocket sslSock = null;
        if(mProxyHost != null)        
        {
            AndroidHttpClientConnection proxyConnection = null;
            Socket proxySock = null;
            try 
            {
                proxySock = new Socket
                    (mProxyHost.getHostName(), mProxyHost.getPort());
                proxySock.setSoTimeout(60 * 1000);
                proxyConnection = new AndroidHttpClientConnection();
                HttpParams params = new BasicHttpParams();
                HttpConnectionParams.setSocketBufferSize(params, 8192);
                proxyConnection.bind(proxySock, params);
            } //End block
            catch (IOException e)
            {
                if(proxyConnection != null)                
                {
                    proxyConnection.close();
                } //End block
                String errorMessage = e.getMessage();
                if(errorMessage == null)                
                {
                    errorMessage =
                        "failed to establish a connection to the proxy";
                } //End block
                IOException var342594BFE7B1414446AFBD7940E755CF_1072999394 = new IOException(errorMessage);
                var342594BFE7B1414446AFBD7940E755CF_1072999394.addTaint(taint);
                throw var342594BFE7B1414446AFBD7940E755CF_1072999394;
            } //End block
            StatusLine statusLine = null;
            int statusCode = 0;
            Headers headers = new Headers();
            try 
            {
                BasicHttpRequest proxyReq = new BasicHttpRequest
                    ("CONNECT", mHost.toHostString());
for(Header h : req.mHttpRequest.getAllHeaders())
                {
                    String headerName = h.getName().toLowerCase();
                    if(headerName.startsWith("proxy") || headerName.equals("keep-alive")
                            || headerName.equals("host"))                    
                    {
                        proxyReq.addHeader(h);
                    } //End block
                } //End block
                proxyConnection.sendRequestHeader(proxyReq);
                proxyConnection.flush();
                do {
                    {
                        statusLine = proxyConnection.parseResponseHeader(headers);
                        statusCode = statusLine.getStatusCode();
                    } //End block
} while (statusCode < HttpStatus.SC_OK);
            } //End block
            catch (ParseException e)
            {
                String errorMessage = e.getMessage();
                if(errorMessage == null)                
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                IOException var342594BFE7B1414446AFBD7940E755CF_1115372977 = new IOException(errorMessage);
                var342594BFE7B1414446AFBD7940E755CF_1115372977.addTaint(taint);
                throw var342594BFE7B1414446AFBD7940E755CF_1115372977;
            } //End block
            catch (HttpException e)
            {
                String errorMessage = e.getMessage();
                if(errorMessage == null)                
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                IOException var342594BFE7B1414446AFBD7940E755CF_1068646725 = new IOException(errorMessage);
                var342594BFE7B1414446AFBD7940E755CF_1068646725.addTaint(taint);
                throw var342594BFE7B1414446AFBD7940E755CF_1068646725;
            } //End block
            catch (IOException e)
            {
                String errorMessage = e.getMessage();
                if(errorMessage == null)                
                {
                    errorMessage =
                        "failed to send a CONNECT request";
                } //End block
                IOException var342594BFE7B1414446AFBD7940E755CF_1297125270 = new IOException(errorMessage);
                var342594BFE7B1414446AFBD7940E755CF_1297125270.addTaint(taint);
                throw var342594BFE7B1414446AFBD7940E755CF_1297125270;
            } //End block
            if(statusCode == HttpStatus.SC_OK)            
            {
                try 
                {
                    sslSock = (SSLSocket) getSocketFactory().createSocket(
                            proxySock, mHost.getHostName(), mHost.getPort(), true);
                } //End block
                catch (IOException e)
                {
                    if(sslSock != null)                    
                    {
                        sslSock.close();
                    } //End block
                    String errorMessage = e.getMessage();
                    if(errorMessage == null)                    
                    {
                        errorMessage =
                            "failed to create an SSL socket";
                    } //End block
                    IOException var342594BFE7B1414446AFBD7940E755CF_1280984113 = new IOException(errorMessage);
                    var342594BFE7B1414446AFBD7940E755CF_1280984113.addTaint(taint);
                    throw var342594BFE7B1414446AFBD7940E755CF_1280984113;
                } //End block
            } //End block
            else
            {
                ProtocolVersion version = statusLine.getProtocolVersion();
                req.mEventHandler.status(version.getMajor(),
                                         version.getMinor(),
                                         statusCode,
                                         statusLine.getReasonPhrase());
                req.mEventHandler.headers(headers);
                req.mEventHandler.endData();
                proxyConnection.close();
AndroidHttpClientConnection var540C13E9E156B687226421B24F2DF178_810580871 =                 null;
                var540C13E9E156B687226421B24F2DF178_810580871.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_810580871;
            } //End block
        } //End block
        else
        {
            try 
            {
                sslSock = (SSLSocket) getSocketFactory().createSocket(
                        mHost.getHostName(), mHost.getPort());
                sslSock.setSoTimeout(SOCKET_TIMEOUT);
            } //End block
            catch (IOException e)
            {
                if(sslSock != null)                
                {
                    sslSock.close();
                } //End block
                String errorMessage = e.getMessage();
                if(errorMessage == null)                
                {
                    errorMessage = "failed to create an SSL socket";
                } //End block
                IOException var342594BFE7B1414446AFBD7940E755CF_498783652 = new IOException(errorMessage);
                var342594BFE7B1414446AFBD7940E755CF_498783652.addTaint(taint);
                throw var342594BFE7B1414446AFBD7940E755CF_498783652;
            } //End block
        } //End block
        SslError error = CertificateChainValidator.getInstance().
            doHandshakeAndValidateServerCertificates(this, sslSock, mHost.getHostName());
        if(error != null)        
        {
            synchronized
(mSuspendLock)            {
                mSuspended = true;
            } //End block
            boolean canHandle = req.getEventHandler().handleSslErrorRequest(error);
            if(!canHandle)            
            {
                IOException varD2B3D5F35813EE7438CB3CC60DCF7D28_988221552 = new IOException("failed to handle "+ error);
                varD2B3D5F35813EE7438CB3CC60DCF7D28_988221552.addTaint(taint);
                throw varD2B3D5F35813EE7438CB3CC60DCF7D28_988221552;
            } //End block
            synchronized
(mSuspendLock)            {
                if(mSuspended)                
                {
                    try 
                    {
                        mSuspendLock.wait(10 * 60 * 1000);
                        if(mSuspended)                        
                        {
                            mSuspended = false;
                            mAborted = true;
                            if(HttpLog.LOGV)                            
                            {
                                HttpLog.v("HttpsConnection.openConnection():" +
                                          " SSL timeout expired and request was cancelled!!!");
                            } //End block
                        } //End block
                    } //End block
                    catch (InterruptedException e)
                    {
                    } //End block
                } //End block
                if(mAborted)                
                {
                    sslSock.close();
                    SSLConnectionClosedByUserException var31C0B60A93882ED6BE945B6E20382201_106478217 = new SSLConnectionClosedByUserException("connection closed by the user");
                    var31C0B60A93882ED6BE945B6E20382201_106478217.addTaint(taint);
                    throw var31C0B60A93882ED6BE945B6E20382201_106478217;
                } //End block
            } //End block
        } //End block
        AndroidHttpClientConnection conn = new AndroidHttpClientConnection();
        BasicHttpParams params = new BasicHttpParams();
        params.setIntParameter(HttpConnectionParams.SOCKET_BUFFER_SIZE, 8192);
        conn.bind(sslSock, params);
AndroidHttpClientConnection varE92EA799FE726EFFA481FDDF43ADE4CF_1303278650 =         conn;
        varE92EA799FE726EFFA481FDDF43ADE4CF_1303278650.addTaint(taint);
        return varE92EA799FE726EFFA481FDDF43ADE4CF_1303278650;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.237 -0400", hash_original_method = "94AF48C1BBE0D9628C41EDAE43AD4A70", hash_generated_method = "F7616D8C46554D4B0A63C13BBA13BA46")
    @Override
     void closeConnection() {
        if(mSuspended)        
        {
            restartConnection(false);
        } //End block
        try 
        {
            if(mHttpClientConnection != null && mHttpClientConnection.isOpen())            
            {
                mHttpClientConnection.close();
            } //End block
        } //End block
        catch (IOException e)
        {
            if(HttpLog.LOGV)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.239 -0400", hash_original_method = "AF3B09D914ADDB679280100B7539789D", hash_generated_method = "3932166F3621C00D850E1CE41617491A")
     void restartConnection(boolean proceed) {
        if(HttpLog.LOGV)        
        {
            HttpLog.v("HttpsConnection.restartConnection():" +
                      " proceed: " + proceed);
        } //End block
        synchronized
(mSuspendLock)        {
            if(mSuspended)            
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.239 -0400", hash_original_method = "369703D22EBB0B4280A990A7CBC1073E", hash_generated_method = "EACC9FF0295C7AC0EE3AC47861DDD4A6")
    @Override
     String getScheme() {
String varD77F5CF20131CC5BD2D3B9090001888B_1542332171 =         "https";
        varD77F5CF20131CC5BD2D3B9090001888B_1542332171.addTaint(taint);
        return varD77F5CF20131CC5BD2D3B9090001888B_1542332171;
        // ---------- Original Method ----------
        //return "https";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.239 -0400", hash_original_field = "EB937D10491011CD8AC6FF9535AE63C5", hash_generated_field = "8E3EE282922FDB169CB5B6E3288B84EE")

    private static SSLSocketFactory mSslSocketFactory = null;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:20.240 -0400", hash_original_method = "1C338196B36BFFFB864A09C466046734", hash_generated_method = "12E090A5BFD5466C086FEE77A2D7DCF2")
    public  SSLConnectionClosedByUserException(String reason) {
        super(reason);
        addTaint(reason.getTaint());
        // ---------- Original Method ----------
    }

    
}

