package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.conn.scheme.HostNameResolver;
import org.apache.http.conn.scheme.LayeredSocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;

public class SSLSocketFactory implements LayeredSocketFactory {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.747 -0400", hash_original_field = "BC9F9BFF8F0C1C44BE0441660A338FEA", hash_generated_field = "99E7FAE9E3E14DF80520CEFA14EB241F")

    private SSLContext sslcontext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.747 -0400", hash_original_field = "627E46BFF62038116B5653AA7BBEDD42", hash_generated_field = "E52538B4D22258905E6F27080C928A86")

    private javax.net.ssl.SSLSocketFactory socketfactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.747 -0400", hash_original_field = "FAF84B85401CDF826F3FA5277B6286C9", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")

    private HostNameResolver nameResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.747 -0400", hash_original_field = "2E7616EC74E5928B45A89742D9811A6C", hash_generated_field = "90112E8EDB7E7A821B80118DB10FBEFF")

    private X509HostnameVerifier hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.748 -0400", hash_original_method = "F80FA0F4889B4450DC2D852F3A3A58DF", hash_generated_method = "9A8489E9BB58E1A1BCBF96E8B52ED97E")
    public  SSLSocketFactory(
        String algorithm, 
        final KeyStore keystore, 
        final String keystorePassword, 
        final KeyStore truststore,
        final SecureRandom random,
        final HostNameResolver nameResolver) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super();
        addTaint(random.getTaint());
        addTaint(truststore.getTaint());
        addTaint(keystorePassword.getTaint());
        addTaint(keystore.getTaint());
    if(algorithm == null)        
        {
            algorithm = TLS;
        } //End block
        KeyManager[] keymanagers = null;
    if(keystore != null)        
        {
            keymanagers = createKeyManagers(keystore, keystorePassword);
        } //End block
        TrustManager[] trustmanagers = null;
    if(truststore != null)        
        {
            trustmanagers = createTrustManagers(truststore);
        } //End block
        this.sslcontext = SSLContext.getInstance(algorithm);
        this.sslcontext.init(keymanagers, trustmanagers, random);
        this.socketfactory = this.sslcontext.getSocketFactory();
        this.nameResolver = nameResolver;
        // ---------- Original Method ----------
        //if (algorithm == null) {
            //algorithm = TLS;
        //}
        //KeyManager[] keymanagers = null;
        //if (keystore != null) {
            //keymanagers = createKeyManagers(keystore, keystorePassword);
        //}
        //TrustManager[] trustmanagers = null;
        //if (truststore != null) {
            //trustmanagers = createTrustManagers(truststore);
        //}
        //this.sslcontext = SSLContext.getInstance(algorithm);
        //this.sslcontext.init(keymanagers, trustmanagers, random);
        //this.socketfactory = this.sslcontext.getSocketFactory();
        //this.nameResolver = nameResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.749 -0400", hash_original_method = "56E365183E16E975E9BA33998913B83F", hash_generated_method = "385C9AE23CAD7FA1E0F6F9D0E8938E40")
    public  SSLSocketFactory(
            final KeyStore keystore, 
            final String keystorePassword, 
            final KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, keystore, keystorePassword, truststore, null, null);
        addTaint(truststore.getTaint());
        addTaint(keystorePassword.getTaint());
        addTaint(keystore.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.749 -0400", hash_original_method = "A67823A5DC6C5FF7C43D604E05CE11CB", hash_generated_method = "84573373818D5725E24D1267F81CD065")
    public  SSLSocketFactory(final KeyStore keystore, final String keystorePassword) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, keystore, keystorePassword, null, null, null);
        addTaint(keystorePassword.getTaint());
        addTaint(keystore.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.749 -0400", hash_original_method = "28D877B99CD24F9AB6618A77DF1E85C8", hash_generated_method = "14D04C1C6B1AD68EA417EEFF4713352E")
    public  SSLSocketFactory(final KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, null, null, truststore, null, null);
        addTaint(truststore.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.750 -0400", hash_original_method = "607044CE64B6D03D5A8C48CB0A47A2B4", hash_generated_method = "7E576B5E7A19F0C89D90887890438A63")
    public  SSLSocketFactory(javax.net.ssl.SSLSocketFactory socketfactory) {
        super();
        this.sslcontext = null;
        this.socketfactory = socketfactory;
        this.nameResolver = null;
        // ---------- Original Method ----------
        //this.sslcontext = null;
        //this.socketfactory = socketfactory;
        //this.nameResolver = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.751 -0400", hash_original_method = "B5B8605C888DE528BB32DDEA2B05EF81", hash_generated_method = "ECDC694BC4F29B8EB127473FB8B8106E")
    private  SSLSocketFactory() {
        super();
        this.sslcontext = null;
        this.socketfactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        this.nameResolver = null;
        // ---------- Original Method ----------
        //this.sslcontext = null;
        //this.socketfactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        //this.nameResolver = null;
    }

    
        @DSModeled(DSC.SAFE)
    public static SSLSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    
        private static KeyManager[] createKeyManagers(final KeyStore keystore, final String password) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        if (keystore == null) {
            throw new IllegalArgumentException("Keystore may not be null");
        }
        KeyManagerFactory kmfactory = KeyManagerFactory.getInstance(
            KeyManagerFactory.getDefaultAlgorithm());
        kmfactory.init(keystore, password != null ? password.toCharArray(): null);
        return kmfactory.getKeyManagers();
    }

    
        private static TrustManager[] createTrustManagers(final KeyStore keystore) throws KeyStoreException, NoSuchAlgorithmException {
        if (keystore == null) {
            throw new IllegalArgumentException("Keystore may not be null");
        }
        TrustManagerFactory tmfactory = TrustManagerFactory.getInstance(
            TrustManagerFactory.getDefaultAlgorithm());
        tmfactory.init(keystore);
        return tmfactory.getTrustManagers();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.752 -0400", hash_original_method = "63050927494CC5AD1D14809EA278FFBF", hash_generated_method = "A603A5EC334D166E6073A3711444FF58")
    public Socket createSocket() throws IOException {
Socket var0E0BC511BA4EC00F28BB00B8267F4271_1678987305 =         (SSLSocket) this.socketfactory.createSocket();
        var0E0BC511BA4EC00F28BB00B8267F4271_1678987305.addTaint(taint);
        return var0E0BC511BA4EC00F28BB00B8267F4271_1678987305;
        // ---------- Original Method ----------
        //return (SSLSocket) this.socketfactory.createSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.753 -0400", hash_original_method = "1B91A377551E45AA28D03654EA268EA3", hash_generated_method = "9845D6F414374A3373D685BEF61429E5")
    public Socket connectSocket(
        final Socket sock,
        final String host,
        final int port,
        final InetAddress localAddress,
        int localPort,
        final HttpParams params
    ) throws IOException {
        addTaint(params.getTaint());
        addTaint(localPort);
        addTaint(localAddress.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(sock.getTaint());
    if(host == null)        
        {
            IllegalArgumentException var0834355F17AB1D6D8F9C33D9EE9B8ED6_1227631598 = new IllegalArgumentException("Target host may not be null.");
            var0834355F17AB1D6D8F9C33D9EE9B8ED6_1227631598.addTaint(taint);
            throw var0834355F17AB1D6D8F9C33D9EE9B8ED6_1227631598;
        } //End block
    if(params == null)        
        {
            IllegalArgumentException varB946B6A484C42AA7AF308B91324BA829_1661059324 = new IllegalArgumentException("Parameters may not be null.");
            varB946B6A484C42AA7AF308B91324BA829_1661059324.addTaint(taint);
            throw varB946B6A484C42AA7AF308B91324BA829_1661059324;
        } //End block
        SSLSocket sslsock = (SSLSocket)
            ((sock != null) ? sock : createSocket());
    if((localAddress != null) || (localPort > 0))        
        {
    if(localPort < 0)            
            localPort = 0;
            InetSocketAddress isa = new InetSocketAddress(localAddress, localPort);
            sslsock.bind(isa);
        } //End block
        int connTimeout = HttpConnectionParams.getConnectionTimeout(params);
        int soTimeout = HttpConnectionParams.getSoTimeout(params);
        InetSocketAddress remoteAddress;
    if(this.nameResolver != null)        
        {
            remoteAddress = new InetSocketAddress(this.nameResolver.resolve(host), port);
        } //End block
        else
        {
            remoteAddress = new InetSocketAddress(host, port);
        } //End block
        sslsock.connect(remoteAddress, connTimeout);
        sslsock.setSoTimeout(soTimeout);
        try 
        {
            hostnameVerifier.verify(host, sslsock);
        } //End block
        catch (IOException iox)
        {
            try 
            {
                sslsock.close();
            } //End block
            catch (Exception x)
            {
            } //End block
            iox.addTaint(taint);
            throw iox;
        } //End block
Socket var60CA3250EDBBF5555FAF69541F78D26E_1368675699 =         sslsock;
        var60CA3250EDBBF5555FAF69541F78D26E_1368675699.addTaint(taint);
        return var60CA3250EDBBF5555FAF69541F78D26E_1368675699;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.753 -0400", hash_original_method = "66B541002324CA4265A637C3F35D74A1", hash_generated_method = "7CBEAEAB2ABDA7CDFCD7405D89B16AD0")
    public boolean isSecure(Socket sock) throws IllegalArgumentException {
        addTaint(sock.getTaint());
    if(sock == null)        
        {
            IllegalArgumentException var908C00FEC12FB3D0085E3AFEF63E364D_1455740019 = new IllegalArgumentException("Socket may not be null.");
            var908C00FEC12FB3D0085E3AFEF63E364D_1455740019.addTaint(taint);
            throw var908C00FEC12FB3D0085E3AFEF63E364D_1455740019;
        } //End block
    if(!(sock instanceof SSLSocket))        
        {
            IllegalArgumentException var745F34B2140DE0EF716D2801F4BA086F_2127630393 = new IllegalArgumentException
                ("Socket not created by this factory.");
            var745F34B2140DE0EF716D2801F4BA086F_2127630393.addTaint(taint);
            throw var745F34B2140DE0EF716D2801F4BA086F_2127630393;
        } //End block
    if(sock.isClosed())        
        {
            IllegalArgumentException varE6A53A17C2E2D099F5EDA38E621B0B3B_313742177 = new IllegalArgumentException("Socket is closed.");
            varE6A53A17C2E2D099F5EDA38E621B0B3B_313742177.addTaint(taint);
            throw varE6A53A17C2E2D099F5EDA38E621B0B3B_313742177;
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1036391085 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1347082757 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1347082757;
        // ---------- Original Method ----------
        //if (sock == null) {
            //throw new IllegalArgumentException("Socket may not be null.");
        //}
        //if (!(sock instanceof SSLSocket)) {
            //throw new IllegalArgumentException
                //("Socket not created by this factory.");
        //}
        //if (sock.isClosed()) {
            //throw new IllegalArgumentException("Socket is closed.");
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.754 -0400", hash_original_method = "76BFB202D82A5741071D030FB94DC57A", hash_generated_method = "864D23CFBE2CD935B8069F28F0F96F75")
    public Socket createSocket(
        final Socket socket,
        final String host,
        final int port,
        final boolean autoClose
    ) throws IOException, UnknownHostException {
        addTaint(autoClose);
        addTaint(port);
        addTaint(host.getTaint());
        addTaint(socket.getTaint());
        SSLSocket sslSocket = (SSLSocket) this.socketfactory.createSocket(
              socket,
              host,
              port,
              autoClose
        );
        hostnameVerifier.verify(host, sslSocket);
Socket var483A6DFBDF2AF13A3CF8A0177BC684A5_1901796036 =         sslSocket;
        var483A6DFBDF2AF13A3CF8A0177BC684A5_1901796036.addTaint(taint);
        return var483A6DFBDF2AF13A3CF8A0177BC684A5_1901796036;
        // ---------- Original Method ----------
        //SSLSocket sslSocket = (SSLSocket) this.socketfactory.createSocket(
              //socket,
              //host,
              //port,
              //autoClose
        //);
        //hostnameVerifier.verify(host, sslSocket);
        //return sslSocket;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.754 -0400", hash_original_method = "CE9A92F10A15AE99F29896C9A2E4D993", hash_generated_method = "43BB1EB99DFEA6AE6D803624410C8A44")
    public void setHostnameVerifier(X509HostnameVerifier hostnameVerifier) {
    if(hostnameVerifier == null)        
        {
            IllegalArgumentException var605CFA973554766214393739080ACD94_11065342 = new IllegalArgumentException("Hostname verifier may not be null");
            var605CFA973554766214393739080ACD94_11065342.addTaint(taint);
            throw var605CFA973554766214393739080ACD94_11065342;
        } //End block
        this.hostnameVerifier = hostnameVerifier;
        // ---------- Original Method ----------
        //if ( hostnameVerifier == null ) {
            //throw new IllegalArgumentException("Hostname verifier may not be null");
        //}
        //this.hostnameVerifier = hostnameVerifier;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_method = "E4B056341E706F6A6ED43C64885CAEDA", hash_generated_method = "1FCCB8A5DC4EF0D08A99AE45D20CABD7")
    public X509HostnameVerifier getHostnameVerifier() {
X509HostnameVerifier var9306CAE4DB3D2F94D65947C804026160_817704657 =         hostnameVerifier;
        var9306CAE4DB3D2F94D65947C804026160_817704657.addTaint(taint);
        return var9306CAE4DB3D2F94D65947C804026160_817704657;
        // ---------- Original Method ----------
        //return hostnameVerifier;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "D455F7DD8C31BC30A448532551F08694", hash_generated_field = "CA5E4F0BFCB251BDC73BBB5281DA6EC7")

    public static final String TLS   = "TLS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "FBC8FA9DD0CC2B894909A6C11C9863C6", hash_generated_field = "86941BAF175786CD2D0CA4E940EC1D46")

    public static final String SSL   = "SSL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "FDABF3E98F2B6D6617841A99D7F146FC", hash_generated_field = "1EF78CC576401D233FE0AF77A8567CD4")

    public static final String SSLV2 = "SSLv2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "3D49AE0F6F7A80B2D96CB5488BF1AD5C", hash_generated_field = "D5F90D56F3DB6E488CA3C5CC0704B598")

    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER 
        = new AllowAllHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "B1E04F5BB6CCDD51A26880255E383C5B", hash_generated_field = "5F3BDD7FFC06D2A92E3E1417CC23EFC0")

    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER 
        = new BrowserCompatHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "ED961636C162BB2A1D53FA17FFC18030", hash_generated_field = "11D7C2BC55F08EBD00B773626A86597A")

    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER 
        = new StrictHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.755 -0400", hash_original_field = "DC1431E2F5884544956BAA27766439A5", hash_generated_field = "A610358EC0501A0752622D234730777E")

    private static final SSLSocketFactory DEFAULT_FACTORY = new SSLSocketFactory();
}

