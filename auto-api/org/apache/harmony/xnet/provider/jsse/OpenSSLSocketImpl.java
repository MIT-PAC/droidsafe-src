package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import dalvik.system.BlockGuard;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import libcore.io.Streams;
import org.apache.harmony.security.provider.cert.X509CertImpl;

public class OpenSSLSocketImpl extends javax.net.ssl.SSLSocket implements NativeCrypto.SSLHandshakeCallbacks {
    private int sslNativePointer;
    private InputStream is;
    private OutputStream os;
    private Object handshakeLock = new Object();
    private Object readLock = new Object();
    private Object writeLock = new Object();
    private SSLParametersImpl sslParameters;
    private String[] enabledProtocols;
    private String[] enabledCipherSuites;
    private String[] enabledCompressionMethods;
    private boolean useSessionTickets;
    private String hostname;
    private OpenSSLSessionImpl sslSession;
    private Socket socket;
    private boolean autoClose;
    private boolean handshakeStarted = false;
    private CloseGuard guard = CloseGuard.get();
    private boolean handshakeCompleted = false;
    private ArrayList<HandshakeCompletedListener> listeners;
    private int timeoutMilliseconds = 0;
    private int handshakeTimeoutMilliseconds = -1;
    private String wrappedHost;
    private int wrappedPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.938 -0400", hash_original_method = "1E0B4679EC7761107339F1A8D3A55F9F", hash_generated_method = "38CAAC5CEDF4F0953967006B3B76D714")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.938 -0400", hash_original_method = "7190C9F3617EA957D6C6C5547D61E7DA", hash_generated_method = "75D53D4C5DF6E0359B70A54F5CB2FE5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(SSLParametersImpl sslParameters,
                                String[] enabledProtocols,
                                String[] enabledCipherSuites,
                                String[] enabledCompressionMethods) throws IOException {
        dsTaint.addTaint(enabledProtocols[0]);
        dsTaint.addTaint(enabledCompressionMethods[0]);
        dsTaint.addTaint(enabledCipherSuites[0]);
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.938 -0400", hash_original_method = "8EFC55677F513E24A665A5B10C8DD781", hash_generated_method = "9CD3634E65D676AAC9AC55198D9051C2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.938 -0400", hash_original_method = "3B4C2FC0F73F444026E804CAAB2D3AA5", hash_generated_method = "E47BEE7ED2C68D6B39D64FE4954B252C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(InetAddress address, int port, SSLParametersImpl sslParameters) throws IOException {
        super(address, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.938 -0400", hash_original_method = "3EB3C6E00E78F272783CA82B1518096D", hash_generated_method = "12213BF3F2E21152A9122D34513C115A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(String host, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(host, port, clientAddress, clientPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(clientPort);
        dsTaint.addTaint(clientAddress.dsTaint);
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.939 -0400", hash_original_method = "BF524C761FC1FBF2285E42FB758995EF", hash_generated_method = "ACD6082D8DCCAB0F494BA061FBD2F22B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(InetAddress address, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(address, port, clientAddress, clientPort);
        dsTaint.addTaint(port);
        dsTaint.addTaint(clientPort);
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(clientAddress.dsTaint);
        dsTaint.addTaint(sslParameters.dsTaint);
        this.socket = this;
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.939 -0400", hash_original_method = "E8402FE2BCEFBC2883099C44FF33F005", hash_generated_method = "D6400668FF554349D0198CC4358214B0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OpenSSLSocketImpl(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(socket.dsTaint);
        dsTaint.addTaint(autoClose);
        dsTaint.addTaint(sslParameters.dsTaint);
        init(sslParameters);
        // ---------- Original Method ----------
        //this.socket = socket;
        //this.wrappedHost = host;
        //this.wrappedPort = port;
        //this.autoClose = autoClose;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.939 -0400", hash_original_method = "33D1B746D20986D17267826F3151AB68", hash_generated_method = "7FD6F83F9F1F25EC817CF9732B2AAB03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void init(SSLParametersImpl sslParameters) throws IOException {
        dsTaint.addTaint(sslParameters.dsTaint);
        init(sslParameters,
             NativeCrypto.getSupportedProtocols(),
             NativeCrypto.getDefaultCipherSuites(),
             NativeCrypto.getDefaultCompressionMethods());
        // ---------- Original Method ----------
        //init(sslParameters,
             //NativeCrypto.getSupportedProtocols(),
             //NativeCrypto.getDefaultCipherSuites(),
             //NativeCrypto.getDefaultCompressionMethods());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.939 -0400", hash_original_method = "28ECC4752D5D2759E8F75423B7F304E1", hash_generated_method = "0EFE9F6A36CAEF65806F5FA75AC81FA4")
    @DSModeled(DSC.SAFE)
    private void init(SSLParametersImpl sslParameters,
                      String[] enabledProtocols,
                      String[] enabledCipherSuites,
                      String[] enabledCompressionMethods) throws IOException {
        dsTaint.addTaint(enabledProtocols[0]);
        dsTaint.addTaint(enabledCompressionMethods[0]);
        dsTaint.addTaint(enabledCipherSuites[0]);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.enabledProtocols = enabledProtocols;
        //this.enabledCipherSuites = enabledCipherSuites;
        //this.enabledCompressionMethods = enabledCompressionMethods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.946 -0400", hash_original_method = "DB9C757E33C47645F1FC9AEA51E10B24", hash_generated_method = "94986D63C4B27B66F9A6B24F9BE9C121")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private OpenSSLSessionImpl getCachedClientSession(ClientSessionContext sessionContext) {
        dsTaint.addTaint(sessionContext.dsTaint);
        {
            boolean varDE450B6D8CDA8C5A5EBF790451254751_2056010097 = (super.getInetAddress() == null ||
                super.getInetAddress().getHostAddress() == null ||
                super.getInetAddress().getHostName() == null);
        } //End collapsed parenthetic
        OpenSSLSessionImpl session;
        session = (OpenSSLSessionImpl) sessionContext.getSession(
                super.getInetAddress().getHostName(),
                super.getPort());
        String protocol;
        protocol = session.getProtocol();
        boolean protocolFound;
        protocolFound = false;
        {
            String enabledProtocol = enabledProtocols[0];
            {
                {
                    boolean varB7CDD2851C57BCE06B93A6CED39A5E38_1070228851 = (protocol.equals(enabledProtocol));
                    {
                        protocolFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String cipherSuite;
        cipherSuite = session.getCipherSuite();
        boolean cipherSuiteFound;
        cipherSuiteFound = false;
        {
            String enabledCipherSuite = enabledCipherSuites[0];
            {
                {
                    boolean var0A90D4178EA81E08B8356065F33DB016_1363713164 = (cipherSuite.equals(enabledCipherSuite));
                    {
                        cipherSuiteFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String compressionMethod;
        compressionMethod = session.getCompressionMethod();
        boolean compressionMethodFound;
        compressionMethodFound = false;
        {
            String enabledCompressionMethod = enabledCompressionMethods[0];
            {
                {
                    boolean varDF0B1461F4631C44245857F1697AFCF1_1116950545 = (compressionMethod.equals(enabledCompressionMethod));
                    {
                        compressionMethodFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        return (OpenSSLSessionImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.947 -0400", hash_original_method = "6F34DF1209370488AD4C31DC9A9003CA", hash_generated_method = "875A1614B9E32119678388031424EBE3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startHandshake() throws IOException {
        startHandshake(true);
        // ---------- Original Method ----------
        //startHandshake(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.947 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "5C9C2C7437ACC8BD38A065EC5AD0ECDF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_1115437113 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.036 -0400", hash_original_method = "7D68DA7254C24BFF3C6F787A75CF4E46", hash_generated_method = "AE0EE548133323B779601D9532ADFA75")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void startHandshake(boolean full) throws IOException {
        dsTaint.addTaint(full);
        {
            checkOpen();
            {
                handshakeStarted = true;
            } //End block
        } //End block
        int seedLengthInBytes;
        seedLengthInBytes = NativeCrypto.RAND_SEED_LENGTH_IN_BYTES;
        SecureRandom secureRandom;
        secureRandom = sslParameters.getSecureRandomMember();
        {
            NativeCrypto.RAND_load_file("/dev/urandom", seedLengthInBytes);
        } //End block
        {
            NativeCrypto.RAND_seed(secureRandom.generateSeed(seedLengthInBytes));
        } //End block
        boolean client;
        client = sslParameters.getUseClientMode();
        int sslCtxNativePointer;
        sslCtxNativePointer = sslParameters.getClientSessionContext().sslCtxNativePointer;
        sslCtxNativePointer = sslParameters.getServerSessionContext().sslCtxNativePointer;
        this.sslNativePointer = 0;
        boolean exception;
        exception = true;
        try 
        {
            sslNativePointer = NativeCrypto.SSL_new(sslCtxNativePointer);
            guard.open("close");
            {
                Set<String> keyTypes;
                keyTypes = new HashSet<String>();
                {
                    String enabledCipherSuite = enabledCipherSuites[0];
                    {
                        {
                            boolean varB970A4D1689EFCBF0C591729604E2F5C_1070641046 = (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV));
                        } //End collapsed parenthetic
                        String keyType;
                        keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                        {
                            keyTypes.add(keyType);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<String> var594EC992A710F64B1906006B59DD5293_1545839033 = (keyTypes).iterator();
                    var594EC992A710F64B1906006B59DD5293_1545839033.hasNext();
                    String keyType = var594EC992A710F64B1906006B59DD5293_1545839033.next();
                    {
                        try 
                        {
                            setCertificate(sslParameters.getKeyManager().chooseServerAlias(keyType,
                                                                                       null,
                                                                                       this));
                        } //End block
                        catch (CertificateEncodingException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException(e);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
            NativeCrypto.setEnabledProtocols(sslNativePointer, enabledProtocols);
            NativeCrypto.setEnabledCipherSuites(sslNativePointer, enabledCipherSuites);
            {
                NativeCrypto.setEnabledCompressionMethods(sslNativePointer,
                                                          enabledCompressionMethods);
            } //End block
            {
                NativeCrypto.SSL_clear_options(sslNativePointer, NativeCrypto.SSL_OP_NO_TICKET);
            } //End block
            {
                NativeCrypto.SSL_set_tlsext_host_name(sslNativePointer, hostname);
            } //End block
            boolean enableSessionCreation;
            enableSessionCreation = sslParameters.getEnableSessionCreation();
            {
                NativeCrypto.SSL_set_session_creation_enabled(sslNativePointer,
                                                              enableSessionCreation);
            } //End block
            AbstractSessionContext sessionContext;
            {
                ClientSessionContext clientSessionContext;
                clientSessionContext = sslParameters.getClientSessionContext();
                sessionContext = clientSessionContext;
                OpenSSLSessionImpl session;
                session = getCachedClientSession(clientSessionContext);
                {
                    NativeCrypto.SSL_set_session(sslNativePointer,
                                                 session.sslSessionNativePointer);
                } //End block
            } //End block
            {
                sessionContext = sslParameters.getServerSessionContext();
            } //End block
            {
                boolean certRequested;
                {
                    boolean varDC6B96A2EBF53EC5C7FA36AF2244C1B9_1608985040 = (sslParameters.getNeedClientAuth());
                    {
                        NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER
                                                | NativeCrypto.SSL_VERIFY_FAIL_IF_NO_PEER_CERT);
                        certRequested = true;
                    } //End block
                    {
                        boolean varBA129A971A32EF54D8E824D21B4687C7_1218229650 = (sslParameters.getWantClientAuth());
                        {
                            NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER);
                            certRequested = true;
                        } //End block
                        {
                            certRequested = false;
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                {
                    X509TrustManager trustManager;
                    trustManager = sslParameters.getTrustManager();
                    X509Certificate[] issuers;
                    issuers = trustManager.getAcceptedIssuers();
                    {
                        byte[][] issuersBytes;
                        try 
                        {
                            issuersBytes = NativeCrypto.encodeIssuerX509Principals(issuers);
                        } //End block
                        catch (CertificateEncodingException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException("Problem encoding principals", e);
                        } //End block
                        NativeCrypto.SSL_set_client_CA_list(sslNativePointer, issuersBytes);
                    } //End block
                } //End block
            } //End block
            {
                NativeCrypto.SSL_clear_mode(sslNativePointer,
                                            NativeCrypto.SSL_MODE_HANDSHAKE_CUTTHROUGH);
            } //End block
            int savedTimeoutMilliseconds;
            savedTimeoutMilliseconds = getSoTimeout();
            {
                setSoTimeout(handshakeTimeoutMilliseconds);
            } //End block
            int sslSessionNativePointer;
            try 
            {
                sslSessionNativePointer = NativeCrypto.SSL_do_handshake(sslNativePointer,
                        socket.getFileDescriptor$(), this, getSoTimeout(), client);
            } //End block
            catch (CertificateException e)
            {
                SSLHandshakeException wrapper;
                wrapper = new SSLHandshakeException(e.getMessage());
                wrapper.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw wrapper;
            } //End block
            byte[] sessionId;
            sessionId = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
            sslSession = (OpenSSLSessionImpl) sessionContext.getSession(sessionId);
            {
                sslSession.lastAccessedTime = System.currentTimeMillis();
                NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSL Session may not be created");
                } //End block
                X509Certificate[] localCertificates;
                localCertificates = createCertChain(NativeCrypto.SSL_get_certificate(sslNativePointer));
                X509Certificate[] peerCertificates;
                peerCertificates = createCertChain(NativeCrypto.SSL_get_peer_cert_chain(sslNativePointer));
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        super.getInetAddress().getHostName(),
                                                        super.getPort(), sessionContext);
                } //End block
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        wrappedHost, wrappedPort,
                                                        sessionContext);
                } //End block
                {
                    sessionContext.putSession(sslSession);
                } //End block
            } //End block
            {
                setSoTimeout(savedTimeoutMilliseconds);
            } //End block
            {
                notifyHandshakeCompletedListeners();
            } //End block
            exception = false;
        } //End block
        catch (SSLProtocolException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLHandshakeException(e);
        } //End block
        finally 
        {
            {
                close();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static X509Certificate[] createCertChain(byte[][] certificatesBytes) {
        if (certificatesBytes == null) {
            return null;
        }
        X509Certificate[] certificates = new X509Certificate[certificatesBytes.length];
        for (int i = 0; i < certificatesBytes.length; i++) {
            try {
                certificates[i] = new X509CertImpl(certificatesBytes[i]);
            } catch (IOException e) {
                return null;
            }
        }
        return certificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.037 -0400", hash_original_method = "447042B984B2D213A231B86095B05FCC", hash_generated_method = "9F1D3AD8BF39AB19FC11EFA4AEC6B203")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setCertificate(String alias) throws CertificateEncodingException, SSLException {
        dsTaint.addTaint(alias);
        PrivateKey privateKey;
        privateKey = sslParameters.getKeyManager().getPrivateKey(alias);
        X509Certificate[] certificates;
        certificates = sslParameters.getKeyManager().getCertificateChain(alias);
        byte[] privateKeyBytes;
        privateKeyBytes = privateKey.getEncoded();
        byte[][] certificateBytes;
        certificateBytes = NativeCrypto.encodeCertificates(certificates);
        NativeCrypto.SSL_use_PrivateKey(sslNativePointer, privateKeyBytes);
        NativeCrypto.SSL_use_certificate(sslNativePointer, certificateBytes);
        NativeCrypto.SSL_check_private_key(sslNativePointer);
        // ---------- Original Method ----------
        //if (alias == null) {
            //return;
        //}
        //PrivateKey privateKey = sslParameters.getKeyManager().getPrivateKey(alias);
        //if (privateKey == null) {
            //return;
        //}
        //X509Certificate[] certificates = sslParameters.getKeyManager().getCertificateChain(alias);
        //if (certificates == null) {
            //return;
        //}
        //byte[] privateKeyBytes = privateKey.getEncoded();
        //byte[][] certificateBytes = NativeCrypto.encodeCertificates(certificates);
        //NativeCrypto.SSL_use_PrivateKey(sslNativePointer, privateKeyBytes);
        //NativeCrypto.SSL_use_certificate(sslNativePointer, certificateBytes);
        //NativeCrypto.SSL_check_private_key(sslNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.037 -0400", hash_original_method = "4494930597AF8911ABFC977B28D550D9", hash_generated_method = "D01041A70D2887ACB549644F7058FB52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    public void clientCertificateRequested(byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws CertificateEncodingException, SSLException {
        dsTaint.addTaint(keyTypeBytes[0]);
        dsTaint.addTaint(asn1DerEncodedPrincipals[0][0]);
        String[] keyTypes;
        keyTypes = new String[keyTypeBytes.length];
        {
            int i;
            i = 0;
            {
                keyTypes[i] = CipherSuite.getClientKeyType(keyTypeBytes[i]);
            } //End block
        } //End collapsed parenthetic
        X500Principal[] issuers;
        {
            issuers = null;
        } //End block
        {
            issuers = new X500Principal[asn1DerEncodedPrincipals.length];
            {
                int i;
                i = 0;
                {
                    issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        setCertificate(sslParameters.getKeyManager().chooseClientAlias(keyTypes, issuers, this));
        // ---------- Original Method ----------
        //String[] keyTypes = new String[keyTypeBytes.length];
        //for (int i = 0; i < keyTypeBytes.length; i++) {
            //keyTypes[i] = CipherSuite.getClientKeyType(keyTypeBytes[i]);
        //}
        //X500Principal[] issuers;
        //if (asn1DerEncodedPrincipals == null) {
            //issuers = null;
        //} else {
            //issuers = new X500Principal[asn1DerEncodedPrincipals.length];
            //for (int i = 0; i < asn1DerEncodedPrincipals.length; i++) {
                //issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
            //}
        //}
        //setCertificate(sslParameters.getKeyManager().chooseClientAlias(keyTypes, issuers, this));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.037 -0400", hash_original_method = "4135185E706706A43228536D20F5AD94", hash_generated_method = "90005C9868199D71B4FC0243D3AC646B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    public void handshakeCompleted() {
        handshakeCompleted = true;
        sslSession.resetId();
        AbstractSessionContext sessionContext;
        boolean var90A449D6F1E51FE89C1444A2ABB20FCB_314881532 = ((sslParameters.getUseClientMode()));
        sessionContext = sslParameters.getClientSessionContext();
        sessionContext = sslParameters.getServerSessionContext();
        sessionContext.putSession(sslSession);
        notifyHandshakeCompletedListeners();
        // ---------- Original Method ----------
        //handshakeCompleted = true;
        //if (sslSession == null) {
            //return;
        //}
        //sslSession.resetId();
        //AbstractSessionContext sessionContext =
            //(sslParameters.getUseClientMode())
            //? sslParameters.getClientSessionContext()
                //: sslParameters.getServerSessionContext();
        //sessionContext.putSession(sslSession);
        //notifyHandshakeCompletedListeners();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.041 -0400", hash_original_method = "7C2534895E7335878B6E22FB6F2D87D0", hash_generated_method = "6E25D77DEA5F2A313E5D621E292D8A77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyHandshakeCompletedListeners() {
        {
            boolean varEA141DED028EB95B14754CBD79C46500_618799591 = (listeners != null && !listeners.isEmpty());
            {
                HandshakeCompletedEvent event;
                event = new HandshakeCompletedEvent(this, sslSession);
                {
                    Iterator<HandshakeCompletedListener> varFA1A76B379D1DD4A9E969658BDCFB86E_1030646372 = (listeners).iterator();
                    varFA1A76B379D1DD4A9E969658BDCFB86E_1030646372.hasNext();
                    HandshakeCompletedListener listener = varFA1A76B379D1DD4A9E969658BDCFB86E_1030646372.next();
                    {
                        try 
                        {
                            listener.handshakeCompleted(event);
                        } //End block
                        catch (RuntimeException e)
                        {
                            Thread thread;
                            thread = Thread.currentThread();
                            thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (listeners != null && !listeners.isEmpty()) {
            //HandshakeCompletedEvent event =
                //new HandshakeCompletedEvent(this, sslSession);
            //for (HandshakeCompletedListener listener : listeners) {
                //try {
                    //listener.handshakeCompleted(event);
                //} catch (RuntimeException e) {
                    //Thread thread = Thread.currentThread();
                    //thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.041 -0400", hash_original_method = "ED84B1AF9EB80DCCE7D2C3DBC193F549", hash_generated_method = "B112A0616820F03CF427173772C7561B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @SuppressWarnings("unused")
    @Override
    public void verifyCertificateChain(byte[][] bytes, String authMethod) throws CertificateException {
        dsTaint.addTaint(bytes[0][0]);
        dsTaint.addTaint(authMethod);
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SSLException("Peer sent no certificate");
            } //End block
            X509Certificate[] peerCertificateChain;
            peerCertificateChain = new X509Certificate[bytes.length];
            {
                int i;
                i = 0;
                {
                    peerCertificateChain[i] = new X509CertImpl(bytes[i]);
                } //End block
            } //End collapsed parenthetic
            boolean client;
            client = sslParameters.getUseClientMode();
            {
                sslParameters.getTrustManager().checkServerTrusted(peerCertificateChain,
                                                                   authMethod);
            } //End block
            {
                String authType;
                authType = peerCertificateChain[0].getPublicKey().getAlgorithm();
                sslParameters.getTrustManager().checkClientTrusted(peerCertificateChain,
                                                                   authType);
            } //End block
        } //End block
        catch (CertificateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (RuntimeException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.042 -0400", hash_original_method = "E61C85BF5C63F4E04D0D50BF3BBE2593", hash_generated_method = "DDE700300B98D1966497CCB24082E39A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public InputStream getInputStream() throws IOException {
        checkOpen();
        {
            {
                is = new SSLInputStream();
            } //End block
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpen();
        //synchronized (this) {
            //if (is == null) {
                //is = new SSLInputStream();
            //}
            //return is;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.042 -0400", hash_original_method = "5EE71E3DCC35A33F08AD90BC3313950F", hash_generated_method = "CFA4696B80C68993F1DEBB78B068A23C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public OutputStream getOutputStream() throws IOException {
        checkOpen();
        {
            {
                os = new SSLOutputStream();
            } //End block
        } //End block
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //checkOpen();
        //synchronized (this) {
            //if (os == null) {
                //os = new SSLOutputStream();
            //}
            //return os;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.042 -0400", hash_original_method = "E137442CFB021C112EB3F3EAC9C4FE47", hash_generated_method = "7883AD08C2E9CEC528CDB765552DE7C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLSession getSession() {
        {
            try 
            {
                startHandshake(true);
            } //End block
            catch (IOException e)
            { }
        } //End block
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslSession == null) {
            //try {
                //startHandshake(true);
            //} catch (IOException e) {
                //return SSLSessionImpl.NULL_SESSION;
            //}
        //}
        //return sslSession;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.042 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "88BFBA2E5BC98914C897F62C1854DD1A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } //End block
        listeners.add(listener);
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //listeners = new ArrayList<HandshakeCompletedListener>();
        //}
        //listeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.043 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "E09A1D905DCA6641CA3D0F4F29E28FA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
        } //End block
        {
            boolean var170C22586EF26335003A8446D4D19EBD_944543381 = (!listeners.remove(listener));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
        //if (!listeners.remove(listener)) {
            //throw new IllegalArgumentException(
                    //"Provided listener is not registered");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.043 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "8CB0257B2AB97F95603C4A543708BEA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_1836684584 = (sslParameters.getEnableSessionCreation());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.043 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "1CEC5C88A393CCF6951D2A9AC29A0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.043 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "104C7E3B2EC152BB9701F21E531383A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var4A8488CAA4D902DCFD3A82F559450276_383949200 = (NativeCrypto.getSupportedCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.043 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "6AA82C1E7BD0DEFADDBC6E3958830A70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledCipherSuites() {
        String[] var6F42AFA5FD643B83B573586346D8E86A_417050112 = (enabledCipherSuites.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledCipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.044 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "6EFA05368FEC584295C1E317F7C71F07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.044 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "50F8E78F1A8C3A9B7B6F60735790048A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedProtocols() {
        String[] var644D168EA6200BD046A33E3868ED2683_643757935 = (NativeCrypto.getSupportedProtocols());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.044 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "66F2D5FB653C6D011ABB63BF015FF9A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledProtocols() {
        String[] varAD12450170E712D0CFE20B0157A51EDE_285938534 = (enabledProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.044 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "D74BFC69D669C73A46232CE079340F09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.044 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "BDEDE3A067EE57D2B2547548DDAD5101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getSupportedCompressionMethods() {
        String[] varDD380EB21716E47043AAADCB4639E6B1_44250303 = (NativeCrypto.getSupportedCompressionMethods());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCompressionMethods();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.045 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "100AAD35A56F77593016925E8EAD1946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String[] getEnabledCompressionMethods() {
        String[] varA2C89B41543A38571294C4D8AC488193_270414571 = (enabledCompressionMethods.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledCompressionMethods.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.045 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "895803C555AC7D50E6CE49E3EE4B26F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setEnabledCompressionMethods(String[] methods) {
        dsTaint.addTaint(methods[0]);
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        // ---------- Original Method ----------
        //enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.045 -0400", hash_original_method = "1BC96C488FBD7622E9D1B33430C794F4", hash_generated_method = "01D6923E15D9B786DCF4CDA41B9FB8A4")
    @DSModeled(DSC.SAFE)
    public void setUseSessionTickets(boolean useSessionTickets) {
        dsTaint.addTaint(useSessionTickets);
        // ---------- Original Method ----------
        //this.useSessionTickets = useSessionTickets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.045 -0400", hash_original_method = "A3C6DFBE0DD33FFBDB883F2D56D0E9E8", hash_generated_method = "9CD206327B7001A617F9FDD655D0C834")
    @DSModeled(DSC.SAFE)
    public void setHostname(String hostname) {
        dsTaint.addTaint(hostname);
        // ---------- Original Method ----------
        //this.hostname = hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.045 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "627A9488859E8832DE4266E5B7554829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_2105615246 = (sslParameters.getUseClientMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.046 -0400", hash_original_method = "796A366B3F70011E31FF500388066E2F", hash_generated_method = "1E0FD5786B9E802FD7FC90162D6DFEF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Could not change the mode after the initial handshake has begun.");
        } //End block
        sslParameters.setUseClientMode(mode);
        // ---------- Original Method ----------
        //if (handshakeStarted) {
            //throw new IllegalArgumentException(
                    //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.046 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "1F92CC89FA68D7868BCEF57683D51211")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1106344148 = (sslParameters.getWantClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.046 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "F063E5C5DDA3B56FDF2CCD3CF7730F2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_355196529 = (sslParameters.getNeedClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.046 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "6CC5B77D04C22EF0B7C8D76FE3C5FE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.048 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "3CF93375E2EDE097483BB86B9A2A6364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.048 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "6C565BF3E8A87F1507E86CD48A19F445")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void sendUrgentData(int data) throws IOException {
        dsTaint.addTaint(data);
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Method sendUrgentData() is not supported.");
        // ---------- Original Method ----------
        //throw new SocketException("Method sendUrgentData() is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.048 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "B752CD8EA611E22B96DA98AAC29F6F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        dsTaint.addTaint(on);
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
        // ---------- Original Method ----------
        //throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.049 -0400", hash_original_method = "E02183BB387F9960402CB70797EE289E", hash_generated_method = "254C7FAE073113DA89A09D6FBDBB1470")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setSoTimeout(int timeoutMilliseconds) throws SocketException {
        dsTaint.addTaint(timeoutMilliseconds);
        super.setSoTimeout(timeoutMilliseconds);
        // ---------- Original Method ----------
        //super.setSoTimeout(timeoutMilliseconds);
        //this.timeoutMilliseconds = timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.049 -0400", hash_original_method = "5DC72E2D363A272A051BD7C43DA762A2", hash_generated_method = "A2BD9A5BBFC7C76A3F05DB266B410B7F")
    @DSModeled(DSC.SAFE)
    @Override
    public int getSoTimeout() throws SocketException {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.049 -0400", hash_original_method = "CE465C7A533FEAB3164F103F1DBDF364", hash_generated_method = "CC0753E61EE331D1C5338F515C46A893")
    @DSModeled(DSC.SAFE)
    public void setHandshakeTimeout(int timeoutMilliseconds) throws SocketException {
        dsTaint.addTaint(timeoutMilliseconds);
        // ---------- Original Method ----------
        //this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.051 -0400", hash_original_method = "B24ED3F34169856B1F2602ADA3894B40", hash_generated_method = "500701C4C4E0745ADD9378638A1E9FE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void close() throws IOException {
        {
            {
                handshakeStarted = true;
                {
                    free();
                    {
                        boolean varD005D44E966655D4EF5111258788BDE6_1391659087 = (socket != this);
                        {
                            {
                                boolean var4DF33A3328473828362786F341A256EE_441768388 = (autoClose && !socket.isClosed());
                                socket.close();
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean varFFACBC82D9AF35C8BB47D8A0637A6062_982877512 = (!super.isClosed());
                                super.close();
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End block
        NativeCrypto.SSL_interrupt(sslNativePointer);
        {
            {
                {
                    try 
                    {
                        {
                            BlockGuard.getThreadPolicy().onNetwork();
                            NativeCrypto.SSL_shutdown(sslNativePointer, socket.getFileDescriptor$(),
                                    this);
                        } //End block
                    } //End block
                    catch (IOException ignored)
                    { }
                    finally 
                    {
                        free();
                        {
                            boolean var9B1ACD52F4FCB38CE1E60CBDC1AAE3BC_202477850 = (socket != this);
                            {
                                {
                                    boolean var3517699F99256E8181CD89A82659CE69_1693320595 = (autoClose && !socket.isClosed());
                                    {
                                        socket.close();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean varE75AF6E6ED9346F3AD29B561C824DE81_1960697780 = (!super.isClosed());
                                    {
                                        super.close();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.051 -0400", hash_original_method = "0B5EFC2C593350712C0760AFE47F069D", hash_generated_method = "ECFAC03105594EE600B9228F2432EC31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void free() {
        NativeCrypto.SSL_free(sslNativePointer);
        sslNativePointer = 0;
        guard.close();
        // ---------- Original Method ----------
        //if (sslNativePointer == 0) {
            //return;
        //}
        //NativeCrypto.SSL_free(sslNativePointer);
        //sslNativePointer = 0;
        //guard.close();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.052 -0400", hash_original_method = "48478F0D5C609BA19837DA284D888FF0", hash_generated_method = "882FADDE20E830A83BAA462AE46622BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
            free();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //free();
        //} finally {
            //super.finalize();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.053 -0400", hash_original_method = "E6BCE3543B6D551909C5B870C6A9DC54", hash_generated_method = "0AAEBA66463BFC7C95E5D831D8FC0908")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileDescriptor getFileDescriptor$() {
        {
            boolean varC17DE78B0F5B654D1C3BAA61447DB932_1519753925 = (socket == this);
            {
                FileDescriptor var3110F769A6A6D8E15A3F1FF062FBF5E6_334716433 = (super.getFileDescriptor$());
            } //End block
            {
                FileDescriptor var9F3883CCBD9D3D8B4F6D875DAC303807_599634973 = (socket.getFileDescriptor$());
            } //End block
        } //End collapsed parenthetic
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (socket == this) {
            //return super.getFileDescriptor$();
        //} else {
            //return socket.getFileDescriptor$();
        //}
    }

    
    private class SSLInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.053 -0400", hash_original_method = "B153503C58DDB9DC7588696F0617BD77", hash_generated_method = "542D2766BEEB467DA4F5A36EE222A67B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SSLInputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            // ---------- Original Method ----------
            //OpenSSLSocketImpl.this.startHandshake(false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.054 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "BBC215F1F411C520D303CCF01C8B25A5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_1209234994 = (Streams.readSingleByte(this));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.054 -0400", hash_original_method = "DB2A9854396CBE443BE0852C07C28BD2", hash_generated_method = "CE9BCC668EE560CD71CB7AA7190E4F71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] buf, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            dsTaint.addTaint(buf[0]);
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                int var42EB93D3EE42AF5A70572DC5EFC4EDBC_1674450410 = (NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout()));
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //BlockGuard.getThreadPolicy().onNetwork();
            //synchronized (readLock) {
                //checkOpen();
                //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                //if (byteCount == 0) {
                    //return 0;
                //}
                //return NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        //OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout());
            //}
        }

        
    }


    
    private class SSLOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.054 -0400", hash_original_method = "1E1541DFFE880DA1B7719D7E370B4D89", hash_generated_method = "2CF7E8309B0292C00087EB8F19D9BB26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         SSLOutputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            // ---------- Original Method ----------
            //OpenSSLSocketImpl.this.startHandshake(false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.054 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "57B6B388F457DD9D18B1F4CD1B038C42")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int oneByte) throws IOException {
            dsTaint.addTaint(oneByte);
            Streams.writeSingleByte(this, oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.055 -0400", hash_original_method = "D98A6CBE7C5513FE6A9CDBBB263207DD", hash_generated_method = "8FF694B76DBF6777F4403DA060E9D122")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] buf, int offset, int byteCount) throws IOException {
            dsTaint.addTaint(byteCount);
            dsTaint.addTaint(offset);
            dsTaint.addTaint(buf[0]);
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount);
            } //End block
            // ---------- Original Method ----------
            //BlockGuard.getThreadPolicy().onNetwork();
            //synchronized (writeLock) {
                //checkOpen();
                //Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                //if (byteCount == 0) {
                    //return;
                //}
                //NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        //OpenSSLSocketImpl.this, buf, offset, byteCount);
            //}
        }

        
    }


    
}

