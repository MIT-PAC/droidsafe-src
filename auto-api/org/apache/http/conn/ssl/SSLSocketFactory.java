package org.apache.http.conn.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.661 -0400", hash_original_field = "BC9F9BFF8F0C1C44BE0441660A338FEA", hash_generated_field = "99E7FAE9E3E14DF80520CEFA14EB241F")

    private SSLContext sslcontext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.661 -0400", hash_original_field = "627E46BFF62038116B5653AA7BBEDD42", hash_generated_field = "E52538B4D22258905E6F27080C928A86")

    private javax.net.ssl.SSLSocketFactory socketfactory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.661 -0400", hash_original_field = "FAF84B85401CDF826F3FA5277B6286C9", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")

    private HostNameResolver nameResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.661 -0400", hash_original_field = "2E7616EC74E5928B45A89742D9811A6C", hash_generated_field = "90112E8EDB7E7A821B80118DB10FBEFF")

    private X509HostnameVerifier hostnameVerifier = BROWSER_COMPATIBLE_HOSTNAME_VERIFIER;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.662 -0400", hash_original_method = "F80FA0F4889B4450DC2D852F3A3A58DF", hash_generated_method = "4180280A7D207F01E32B28446A76E193")
    public  SSLSocketFactory(
        String algorithm, 
        final KeyStore keystore, 
        final String keystorePassword, 
        final KeyStore truststore,
        final SecureRandom random,
        final HostNameResolver nameResolver) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super();
        {
            algorithm = TLS;
        } //End block
        KeyManager[] keymanagers;
        keymanagers = null;
        {
            keymanagers = createKeyManagers(keystore, keystorePassword);
        } //End block
        TrustManager[] trustmanagers;
        trustmanagers = null;
        {
            trustmanagers = createTrustManagers(truststore);
        } //End block
        this.sslcontext = SSLContext.getInstance(algorithm);
        this.sslcontext.init(keymanagers, trustmanagers, random);
        this.socketfactory = this.sslcontext.getSocketFactory();
        this.nameResolver = nameResolver;
        addTaint(keystore.getTaint());
        addTaint(keystorePassword.getTaint());
        addTaint(truststore.getTaint());
        addTaint(random.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.667 -0400", hash_original_method = "56E365183E16E975E9BA33998913B83F", hash_generated_method = "232F2167973EFC457320A5EF71F7564C")
    public  SSLSocketFactory(
            final KeyStore keystore, 
            final String keystorePassword, 
            final KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, keystore, keystorePassword, truststore, null, null);
        addTaint(keystore.getTaint());
        addTaint(keystorePassword.getTaint());
        addTaint(truststore.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.670 -0400", hash_original_method = "A67823A5DC6C5FF7C43D604E05CE11CB", hash_generated_method = "3FEE79F3510304CB880EDD8457171FE6")
    public  SSLSocketFactory(final KeyStore keystore, final String keystorePassword) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, keystore, keystorePassword, null, null, null);
        addTaint(keystore.getTaint());
        addTaint(keystorePassword.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.678 -0400", hash_original_method = "28D877B99CD24F9AB6618A77DF1E85C8", hash_generated_method = "14D04C1C6B1AD68EA417EEFF4713352E")
    public  SSLSocketFactory(final KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        this(TLS, null, null, truststore, null, null);
        addTaint(truststore.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.679 -0400", hash_original_method = "607044CE64B6D03D5A8C48CB0A47A2B4", hash_generated_method = "7E576B5E7A19F0C89D90887890438A63")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.679 -0400", hash_original_method = "B5B8605C888DE528BB32DDEA2B05EF81", hash_generated_method = "ECDC694BC4F29B8EB127473FB8B8106E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.691 -0400", hash_original_method = "63050927494CC5AD1D14809EA278FFBF", hash_generated_method = "7F4886C0FEC607D344B6E8BA5C80A4F0")
    public Socket createSocket() throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_852592233 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_852592233 = (SSLSocket) this.socketfactory.createSocket();
        varB4EAC82CA7396A68D541C85D26508E83_852592233.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_852592233;
        // ---------- Original Method ----------
        //return (SSLSocket) this.socketfactory.createSocket();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.693 -0400", hash_original_method = "1B91A377551E45AA28D03654EA268EA3", hash_generated_method = "C8C16FD23510668D96B31E674C48906C")
    public Socket connectSocket(
        final Socket sock,
        final String host,
        final int port,
        final InetAddress localAddress,
        int localPort,
        final HttpParams params
    ) throws IOException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1563010158 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Target host may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Parameters may not be null.");
        } //End block
        SSLSocket sslsock;
        sslsock = (SSLSocket)
            ((sock != null) ? sock : createSocket());//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            localPort = 0;
            InetSocketAddress isa;
            isa = new InetSocketAddress(localAddress, localPort);
            sslsock.bind(isa);
        } //End block
        int connTimeout;
        connTimeout = HttpConnectionParams.getConnectionTimeout(params);
        int soTimeout;
        soTimeout = HttpConnectionParams.getSoTimeout(params);
        InetSocketAddress remoteAddress;
        {
            remoteAddress = new InetSocketAddress(this.nameResolver.resolve(host), port);
        } //End block
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
            { }
            if (DroidSafeAndroidRuntime.control) throw iox;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1563010158 = sslsock;
        addTaint(sock.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        addTaint(params.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1563010158.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1563010158;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.699 -0400", hash_original_method = "66B541002324CA4265A637C3F35D74A1", hash_generated_method = "4801409479561CDB4E716781D26565BA")
    public boolean isSecure(Socket sock) throws IllegalArgumentException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException
                ("Socket not created by this factory.");
        } //End block
        {
            boolean varEFCDCF8D21AE7A43F6220E08DD901C1F_160571113 = (sock.isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket is closed.");
            } //End block
        } //End collapsed parenthetic
        addTaint(sock.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_890236537 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_890236537;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.709 -0400", hash_original_method = "76BFB202D82A5741071D030FB94DC57A", hash_generated_method = "F7F7FF85260A887CB4E00F7FB923E9E9")
    public Socket createSocket(
        final Socket socket,
        final String host,
        final int port,
        final boolean autoClose
    ) throws IOException, UnknownHostException {
        Socket varB4EAC82CA7396A68D541C85D26508E83_1640598405 = null; //Variable for return #1
        SSLSocket sslSocket;
        sslSocket = (SSLSocket) this.socketfactory.createSocket(
              socket,
              host,
              port,
              autoClose
        );
        hostnameVerifier.verify(host, sslSocket);
        varB4EAC82CA7396A68D541C85D26508E83_1640598405 = sslSocket;
        addTaint(socket.getTaint());
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(autoClose);
        varB4EAC82CA7396A68D541C85D26508E83_1640598405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1640598405;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.709 -0400", hash_original_method = "CE9A92F10A15AE99F29896C9A2E4D993", hash_generated_method = "F7A04765D809E3C1C76E14DCD7B9E80C")
    public void setHostnameVerifier(X509HostnameVerifier hostnameVerifier) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Hostname verifier may not be null");
        } //End block
        this.hostnameVerifier = hostnameVerifier;
        // ---------- Original Method ----------
        //if ( hostnameVerifier == null ) {
            //throw new IllegalArgumentException("Hostname verifier may not be null");
        //}
        //this.hostnameVerifier = hostnameVerifier;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.710 -0400", hash_original_method = "E4B056341E706F6A6ED43C64885CAEDA", hash_generated_method = "E0A3F08601C783363CA3DBCC633D0F6A")
    public X509HostnameVerifier getHostnameVerifier() {
        X509HostnameVerifier varB4EAC82CA7396A68D541C85D26508E83_1821211034 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1821211034 = hostnameVerifier;
        varB4EAC82CA7396A68D541C85D26508E83_1821211034.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821211034;
        // ---------- Original Method ----------
        //return hostnameVerifier;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.711 -0400", hash_original_field = "D455F7DD8C31BC30A448532551F08694", hash_generated_field = "CA5E4F0BFCB251BDC73BBB5281DA6EC7")

    public static final String TLS   = "TLS";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.711 -0400", hash_original_field = "FBC8FA9DD0CC2B894909A6C11C9863C6", hash_generated_field = "86941BAF175786CD2D0CA4E940EC1D46")

    public static final String SSL   = "SSL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.712 -0400", hash_original_field = "FDABF3E98F2B6D6617841A99D7F146FC", hash_generated_field = "1EF78CC576401D233FE0AF77A8567CD4")

    public static final String SSLV2 = "SSLv2";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.712 -0400", hash_original_field = "3D49AE0F6F7A80B2D96CB5488BF1AD5C", hash_generated_field = "D5F90D56F3DB6E488CA3C5CC0704B598")

    public static final X509HostnameVerifier ALLOW_ALL_HOSTNAME_VERIFIER 
        = new AllowAllHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.712 -0400", hash_original_field = "B1E04F5BB6CCDD51A26880255E383C5B", hash_generated_field = "5F3BDD7FFC06D2A92E3E1417CC23EFC0")

    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER 
        = new BrowserCompatHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.712 -0400", hash_original_field = "ED961636C162BB2A1D53FA17FFC18030", hash_generated_field = "11D7C2BC55F08EBD00B773626A86597A")

    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER 
        = new StrictHostnameVerifier();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:14.713 -0400", hash_original_field = "DC1431E2F5884544956BAA27766439A5", hash_generated_field = "E68BFBA0C4750E0369E7DFB37B1D4EE7")

    private static SSLSocketFactory DEFAULT_FACTORY = new SSLSocketFactory();
}

