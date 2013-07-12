package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.362 -0400", hash_original_field = "7A26561346F073823CD60CDE206B36E2", hash_generated_field = "748A6049ACB01D98F85E21799F2EB11A")

    private int sslNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "BFEC39E15FADDFA148ED8D3CE22EABA4")

    private OutputStream os;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "85E5D87B8B4A646833A43466B8645F5F", hash_generated_field = "BBF990300E3830CE6A958CDB35B29B27")

    private final Object handshakeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "BFF5830B7B00AB1C369E1E6FB3114CB0", hash_generated_field = "85F0E10109EFE4B8F58BC1776613705B")

    private String[] enabledProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.363 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "7AD17E190B7E5C8B7D224A9E272C550F")

    private String[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "0D8BDE82F30FA6C13A6F9BC50134508D", hash_generated_field = "3ED2FE1E30316545E9184B9907A7D6E3")

    private String[] enabledCompressionMethods;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "8F6035B29AA347B1267CEF3F327C2192", hash_generated_field = "A2F538231066932F5915EF28021541F1")

    private boolean useSessionTickets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "3893D7DE6BC507FB95AA82B03DBC44D7", hash_generated_field = "368A75AAABC6FBEB91272F5EA8465622")

    private OpenSSLSessionImpl sslSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "676DF800F5B7B514B01D50F354ACAFF6", hash_generated_field = "5B583CD79FBEC6280A38CE8E3A8DAA8A")

    private boolean handshakeStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.364 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "595005CA65C71040ACDA0D73FCAD2D32", hash_generated_field = "2D23168D66D17A93982E63C6133878AC")

    private boolean handshakeCompleted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "8D4C6D611B20EB0D2D4A15AE21386B82", hash_generated_field = "D9040C82E2DDED5191E6D7AE598F1DB8")

    private int timeoutMilliseconds = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "AE8D1946443647A8D684B091A86F1F48", hash_generated_field = "924BC0B5E41E0BD4B8C4C178AB494DA8")

    private int handshakeTimeoutMilliseconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "ADCF75E4E8815498EC1B7BB88537B5B6", hash_generated_field = "6FB2C77C604FE1268BFA3B979F3F3054")

    private String wrappedHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.365 -0400", hash_original_field = "F29AFDAD6C88B29B62279111343E9F96", hash_generated_field = "B7D8F64F41E806C80BDECFDD8FA68EFA")

    private int wrappedPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.366 -0400", hash_original_method = "1E0B4679EC7761107339F1A8D3A55F9F", hash_generated_method = "6C86D9D0F73E6B8A451CA1D62102D8A0")
    protected  OpenSSLSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        addTaint(sslParameters.getTaint());
        this.socket = this;
        init(sslParameters);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.366 -0400", hash_original_method = "7190C9F3617EA957D6C6C5547D61E7DA", hash_generated_method = "D288A7697247F8A58074FC54A2477627")
    protected  OpenSSLSocketImpl(SSLParametersImpl sslParameters,
                                String[] enabledProtocols,
                                String[] enabledCipherSuites,
                                String[] enabledCompressionMethods) throws IOException {
        addTaint(enabledCompressionMethods[0].getTaint());
        addTaint(enabledCipherSuites[0].getTaint());
        addTaint(enabledProtocols[0].getTaint());
        addTaint(sslParameters.getTaint());
        this.socket = this;
        init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.367 -0400", hash_original_method = "8EFC55677F513E24A665A5B10C8DD781", hash_generated_method = "201D20AB06DE5B62666F074625BB5C73")
    protected  OpenSSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        addTaint(sslParameters.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        this.socket = this;
        init(sslParameters);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.367 -0400", hash_original_method = "3B4C2FC0F73F444026E804CAAB2D3AA5", hash_generated_method = "59F7C04F78192609146327889A9846D5")
    protected  OpenSSLSocketImpl(InetAddress address, int port, SSLParametersImpl sslParameters) throws IOException {
        super(address, port);
        addTaint(sslParameters.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        this.socket = this;
        init(sslParameters);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.367 -0400", hash_original_method = "3EB3C6E00E78F272783CA82B1518096D", hash_generated_method = "2661F5D81869006BB4F03C8D6A99A664")
    protected  OpenSSLSocketImpl(String host, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(host, port, clientAddress, clientPort);
        addTaint(sslParameters.getTaint());
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(host.getTaint());
        this.socket = this;
        init(sslParameters);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.368 -0400", hash_original_method = "BF524C761FC1FBF2285E42FB758995EF", hash_generated_method = "8FEB62A8480C4CBEAA0F1D39E54A4444")
    protected  OpenSSLSocketImpl(InetAddress address, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(address, port, clientAddress, clientPort);
        addTaint(sslParameters.getTaint());
        addTaint(clientPort);
        addTaint(clientAddress.getTaint());
        addTaint(port);
        addTaint(address.getTaint());
        this.socket = this;
        init(sslParameters);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.369 -0400", hash_original_method = "E8402FE2BCEFBC2883099C44FF33F005", hash_generated_method = "27CD6DD943584E4FE9704337D522BA65")
    protected  OpenSSLSocketImpl(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        addTaint(sslParameters.getTaint());
        this.socket = socket;
        this.wrappedHost = host;
        this.wrappedPort = port;
        this.autoClose = autoClose;
        init(sslParameters);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.369 -0400", hash_original_method = "33D1B746D20986D17267826F3151AB68", hash_generated_method = "1522001EEC8F25FDDDBF64710A57BDF4")
    private void init(SSLParametersImpl sslParameters) throws IOException {
        addTaint(sslParameters.getTaint());
        init(sslParameters,
             NativeCrypto.getSupportedProtocols(),
             NativeCrypto.getDefaultCipherSuites(),
             NativeCrypto.getDefaultCompressionMethods());
        
        
             
             
             
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.371 -0400", hash_original_method = "28ECC4752D5D2759E8F75423B7F304E1", hash_generated_method = "85DC27B70EC2B768C744122A7207BA7A")
    private void init(SSLParametersImpl sslParameters,
                      String[] enabledProtocols,
                      String[] enabledCipherSuites,
                      String[] enabledCompressionMethods) throws IOException {
        this.sslParameters = sslParameters;
        this.enabledProtocols = enabledProtocols;
        this.enabledCipherSuites = enabledCipherSuites;
        this.enabledCompressionMethods = enabledCompressionMethods;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.371 -0400", hash_original_method = "DB9C757E33C47645F1FC9AEA51E10B24", hash_generated_method = "6196005081765882BA53AFCBE2D97F9A")
    private OpenSSLSessionImpl getCachedClientSession(ClientSessionContext sessionContext) {
        addTaint(sessionContext.getTaint());
    if(super.getInetAddress() == null ||
                super.getInetAddress().getHostAddress() == null ||
                super.getInetAddress().getHostName() == null)        
        {
OpenSSLSessionImpl var540C13E9E156B687226421B24F2DF178_2084215193 =             null;
            var540C13E9E156B687226421B24F2DF178_2084215193.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2084215193;
        } 
        OpenSSLSessionImpl session = (OpenSSLSessionImpl) sessionContext.getSession(
                super.getInetAddress().getHostName(),
                super.getPort());
    if(session == null)        
        {
OpenSSLSessionImpl var540C13E9E156B687226421B24F2DF178_1023026967 =             null;
            var540C13E9E156B687226421B24F2DF178_1023026967.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1023026967;
        } 
        String protocol = session.getProtocol();
        boolean protocolFound = false;
for(String enabledProtocol : enabledProtocols)
        {
    if(protocol.equals(enabledProtocol))            
            {
                protocolFound = true;
                break;
            } 
        } 
    if(!protocolFound)        
        {
OpenSSLSessionImpl var540C13E9E156B687226421B24F2DF178_1654683660 =             null;
            var540C13E9E156B687226421B24F2DF178_1654683660.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1654683660;
        } 
        String cipherSuite = session.getCipherSuite();
        boolean cipherSuiteFound = false;
for(String enabledCipherSuite : enabledCipherSuites)
        {
    if(cipherSuite.equals(enabledCipherSuite))            
            {
                cipherSuiteFound = true;
                break;
            } 
        } 
    if(!cipherSuiteFound)        
        {
OpenSSLSessionImpl var540C13E9E156B687226421B24F2DF178_973673803 =             null;
            var540C13E9E156B687226421B24F2DF178_973673803.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_973673803;
        } 
        String compressionMethod = session.getCompressionMethod();
        boolean compressionMethodFound = false;
for(String enabledCompressionMethod : enabledCompressionMethods)
        {
    if(compressionMethod.equals(enabledCompressionMethod))            
            {
                compressionMethodFound = true;
                break;
            } 
        } 
    if(!compressionMethodFound)        
        {
OpenSSLSessionImpl var540C13E9E156B687226421B24F2DF178_1774774914 =             null;
            var540C13E9E156B687226421B24F2DF178_1774774914.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1774774914;
        } 
OpenSSLSessionImpl varD555E544A66E0F97DA6BCDE940E3E79C_2085801793 =         session;
        varD555E544A66E0F97DA6BCDE940E3E79C_2085801793.addTaint(taint);
        return varD555E544A66E0F97DA6BCDE940E3E79C_2085801793;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.372 -0400", hash_original_method = "6F34DF1209370488AD4C31DC9A9003CA", hash_generated_method = "875A1614B9E32119678388031424EBE3")
    @Override
    public void startHandshake() throws IOException {
        startHandshake(true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.373 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "75D1F0FD9822452C44AD37B83ACAB5A8")
    private void checkOpen() throws SocketException {
    if(isClosed())        
        {
            SocketException var5AD72407DD9337ABED4666C49A30EC41_2130500753 = new SocketException("Socket is closed");
            var5AD72407DD9337ABED4666C49A30EC41_2130500753.addTaint(taint);
            throw var5AD72407DD9337ABED4666C49A30EC41_2130500753;
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.376 -0400", hash_original_method = "7D68DA7254C24BFF3C6F787A75CF4E46", hash_generated_method = "739EAAA192A2F743C1D5EC946D79C891")
    public synchronized void startHandshake(boolean full) throws IOException {
        addTaint(full);
        synchronized
(handshakeLock)        {
            checkOpen();
    if(!handshakeStarted)            
            {
                handshakeStarted = true;
            } 
            else
            {
                return;
            } 
        } 
        final int seedLengthInBytes = NativeCrypto.RAND_SEED_LENGTH_IN_BYTES;
        final SecureRandom secureRandom = sslParameters.getSecureRandomMember();
    if(secureRandom == null)        
        {
            NativeCrypto.RAND_load_file("/dev/urandom", seedLengthInBytes);
        } 
        else
        {
            NativeCrypto.RAND_seed(secureRandom.generateSeed(seedLengthInBytes));
        } 
        final boolean client = sslParameters.getUseClientMode();
        final int sslCtxNativePointer = (client) ?
            sslParameters.getClientSessionContext().sslCtxNativePointer :
            sslParameters.getServerSessionContext().sslCtxNativePointer;
        this.sslNativePointer = 0;
        boolean exception = true;
        try 
        {
            sslNativePointer = NativeCrypto.SSL_new(sslCtxNativePointer);
            guard.open("close");
    if(!client)            
            {
                Set<String> keyTypes = new HashSet<String>();
for(String enabledCipherSuite : enabledCipherSuites)
                {
    if(enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV))                    
                    {
                        continue;
                    } 
                    String keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
    if(keyType != null)                    
                    {
                        keyTypes.add(keyType);
                    } 
                } 
for(String keyType : keyTypes)
                {
                    try 
                    {
                        setCertificate(sslParameters.getKeyManager().chooseServerAlias(keyType,
                                                                                       null,
                                                                                       this));
                    } 
                    catch (CertificateEncodingException e)
                    {
                        IOException var0AFB0468CE17165C7EF7344B3E18B39B_40822396 = new IOException(e);
                        var0AFB0468CE17165C7EF7344B3E18B39B_40822396.addTaint(taint);
                        throw var0AFB0468CE17165C7EF7344B3E18B39B_40822396;
                    } 
                } 
            } 
            NativeCrypto.setEnabledProtocols(sslNativePointer, enabledProtocols);
            NativeCrypto.setEnabledCipherSuites(sslNativePointer, enabledCipherSuites);
    if(enabledCompressionMethods.length != 0)            
            {
                NativeCrypto.setEnabledCompressionMethods(sslNativePointer,
                                                          enabledCompressionMethods);
            } 
    if(useSessionTickets)            
            {
                NativeCrypto.SSL_clear_options(sslNativePointer, NativeCrypto.SSL_OP_NO_TICKET);
            } 
    if(hostname != null)            
            {
                NativeCrypto.SSL_set_tlsext_host_name(sslNativePointer, hostname);
            } 
            boolean enableSessionCreation = sslParameters.getEnableSessionCreation();
    if(!enableSessionCreation)            
            {
                NativeCrypto.SSL_set_session_creation_enabled(sslNativePointer,
                                                              enableSessionCreation);
            } 
            AbstractSessionContext sessionContext;
    if(client)            
            {
                ClientSessionContext clientSessionContext = sslParameters.getClientSessionContext();
                sessionContext = clientSessionContext;
                OpenSSLSessionImpl session = getCachedClientSession(clientSessionContext);
    if(session != null)                
                {
                    NativeCrypto.SSL_set_session(sslNativePointer,
                                                 session.sslSessionNativePointer);
                } 
            } 
            else
            {
                sessionContext = sslParameters.getServerSessionContext();
            } 
    if(client)            
            {
            } 
            else
            {
                boolean certRequested;
    if(sslParameters.getNeedClientAuth())                
                {
                    NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER
                                                | NativeCrypto.SSL_VERIFY_FAIL_IF_NO_PEER_CERT);
                    certRequested = true;
                } 
                else
    if(sslParameters.getWantClientAuth())                
                {
                    NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER);
                    certRequested = true;
                } 
                else
                {
                    certRequested = false;
                } 
    if(certRequested)                
                {
                    X509TrustManager trustManager = sslParameters.getTrustManager();
                    X509Certificate[] issuers = trustManager.getAcceptedIssuers();
    if(issuers != null && issuers.length != 0)                    
                    {
                        byte[][] issuersBytes;
                        try 
                        {
                            issuersBytes = NativeCrypto.encodeIssuerX509Principals(issuers);
                        } 
                        catch (CertificateEncodingException e)
                        {
                            IOException var354A43C4D20FB507E327425C10C9EF12_1478962404 = new IOException("Problem encoding principals", e);
                            var354A43C4D20FB507E327425C10C9EF12_1478962404.addTaint(taint);
                            throw var354A43C4D20FB507E327425C10C9EF12_1478962404;
                        } 
                        NativeCrypto.SSL_set_client_CA_list(sslNativePointer, issuersBytes);
                    } 
                } 
            } 
    if(client && full)            
            {
                NativeCrypto.SSL_clear_mode(sslNativePointer,
                                            NativeCrypto.SSL_MODE_HANDSHAKE_CUTTHROUGH);
            } 
            int savedTimeoutMilliseconds = getSoTimeout();
    if(handshakeTimeoutMilliseconds >= 0)            
            {
                setSoTimeout(handshakeTimeoutMilliseconds);
            } 
            int sslSessionNativePointer;
            try 
            {
                sslSessionNativePointer = NativeCrypto.SSL_do_handshake(sslNativePointer,
                        socket.getFileDescriptor$(), this, getSoTimeout(), client);
            } 
            catch (CertificateException e)
            {
                SSLHandshakeException wrapper = new SSLHandshakeException(e.getMessage());
                wrapper.initCause(e);
                wrapper.addTaint(taint);
                throw wrapper;
            } 
            byte[] sessionId = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
            sslSession = (OpenSSLSessionImpl) sessionContext.getSession(sessionId);
    if(sslSession != null)            
            {
                sslSession.lastAccessedTime = System.currentTimeMillis();
                NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
            } 
            else
            {
    if(!enableSessionCreation)                
                {
                    IllegalStateException varC7FE0B7D7A222425A2B8EE908B63D0E0_1172661032 = new IllegalStateException("SSL Session may not be created");
                    varC7FE0B7D7A222425A2B8EE908B63D0E0_1172661032.addTaint(taint);
                    throw varC7FE0B7D7A222425A2B8EE908B63D0E0_1172661032;
                } 
                X509Certificate[] localCertificates = createCertChain(NativeCrypto.SSL_get_certificate(sslNativePointer));
                X509Certificate[] peerCertificates = createCertChain(NativeCrypto.SSL_get_peer_cert_chain(sslNativePointer));
    if(wrappedHost == null)                
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        super.getInetAddress().getHostName(),
                                                        super.getPort(), sessionContext);
                } 
                else
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        wrappedHost, wrappedPort,
                                                        sessionContext);
                } 
    if(handshakeCompleted)                
                {
                    sessionContext.putSession(sslSession);
                } 
            } 
    if(handshakeTimeoutMilliseconds >= 0)            
            {
                setSoTimeout(savedTimeoutMilliseconds);
            } 
    if(handshakeCompleted)            
            {
                notifyHandshakeCompletedListeners();
            } 
            exception = false;
        } 
        catch (SSLProtocolException e)
        {
            SSLHandshakeException var84DD9C4934A0F2D1CF5FD3E0D7496B10_809861333 = new SSLHandshakeException(e);
            var84DD9C4934A0F2D1CF5FD3E0D7496B10_809861333.addTaint(taint);
            throw var84DD9C4934A0F2D1CF5FD3E0D7496B10_809861333;
        } 
        finally 
        {
    if(exception)            
            {
                close();
            } 
        } 
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.378 -0400", hash_original_method = "447042B984B2D213A231B86095B05FCC", hash_generated_method = "B044C5B5B79AB370CE5F6B68105524FA")
    private void setCertificate(String alias) throws CertificateEncodingException, SSLException {
        addTaint(alias.getTaint());
    if(alias == null)        
        {
            return;
        } 
        PrivateKey privateKey = sslParameters.getKeyManager().getPrivateKey(alias);
    if(privateKey == null)        
        {
            return;
        } 
        X509Certificate[] certificates = sslParameters.getKeyManager().getCertificateChain(alias);
    if(certificates == null)        
        {
            return;
        } 
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[][] certificateBytes = NativeCrypto.encodeCertificates(certificates);
        NativeCrypto.SSL_use_PrivateKey(sslNativePointer, privateKeyBytes);
        NativeCrypto.SSL_use_certificate(sslNativePointer, certificateBytes);
        NativeCrypto.SSL_check_private_key(sslNativePointer);
        
        
            
        
        
        
            
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.378 -0400", hash_original_method = "4494930597AF8911ABFC977B28D550D9", hash_generated_method = "116D4022A7621650CDAB3D7A0DE65DAC")
    @SuppressWarnings("unused")
    public void clientCertificateRequested(byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws CertificateEncodingException, SSLException {
        addTaint(asn1DerEncodedPrincipals[0][0]);
        addTaint(keyTypeBytes[0]);
        String[] keyTypes = new String[keyTypeBytes.length];
for(int i = 0;i < keyTypeBytes.length;i++)
        {
            keyTypes[i] = CipherSuite.getClientKeyType(keyTypeBytes[i]);
        } 
        X500Principal[] issuers;
    if(asn1DerEncodedPrincipals == null)        
        {
            issuers = null;
        } 
        else
        {
            issuers = new X500Principal[asn1DerEncodedPrincipals.length];
for(int i = 0;i < asn1DerEncodedPrincipals.length;i++)
            {
                issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
            } 
        } 
        setCertificate(sslParameters.getKeyManager().chooseClientAlias(keyTypes, issuers, this));
        
        
        
            
        
        
        
            
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.378 -0400", hash_original_method = "4135185E706706A43228536D20F5AD94", hash_generated_method = "3CE08292F9A5DB78D1C6CC44939EE1D3")
    @SuppressWarnings("unused")
    public void handshakeCompleted() {
        handshakeCompleted = true;
    if(sslSession == null)        
        {
            return;
        } 
        sslSession.resetId();
        AbstractSessionContext sessionContext = (sslParameters.getUseClientMode())
            ? sslParameters.getClientSessionContext()
                : sslParameters.getServerSessionContext();
        sessionContext.putSession(sslSession);
        notifyHandshakeCompletedListeners();
        
        
        
            
        
        
        
            
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.379 -0400", hash_original_method = "7C2534895E7335878B6E22FB6F2D87D0", hash_generated_method = "4E547F7B5CEB63DA48BFCC2769E0B044")
    private void notifyHandshakeCompletedListeners() {
    if(listeners != null && !listeners.isEmpty())        
        {
            HandshakeCompletedEvent event = new HandshakeCompletedEvent(this, sslSession);
for(HandshakeCompletedListener listener : listeners)
            {
                try 
                {
                    listener.handshakeCompleted(event);
                } 
                catch (RuntimeException e)
                {
                    Thread thread = Thread.currentThread();
                    thread.getUncaughtExceptionHandler().uncaughtException(thread, e);
                } 
            } 
        } 
        
        
            
                
            
                
                    
                
                    
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.380 -0400", hash_original_method = "ED84B1AF9EB80DCCE7D2C3DBC193F549", hash_generated_method = "554FCBC1CC400E74CFA89FB42DF353EE")
    @SuppressWarnings("unused")
    @Override
    public void verifyCertificateChain(byte[][] bytes, String authMethod) throws CertificateException {
        addTaint(authMethod.getTaint());
        addTaint(bytes[0][0]);
        try 
        {
    if(bytes == null || bytes.length == 0)            
            {
                SSLException varB41F39907A3BD30A90BEC1B82117E984_100154507 = new SSLException("Peer sent no certificate");
                varB41F39907A3BD30A90BEC1B82117E984_100154507.addTaint(taint);
                throw varB41F39907A3BD30A90BEC1B82117E984_100154507;
            } 
            X509Certificate[] peerCertificateChain = new X509Certificate[bytes.length];
for(int i = 0;i < bytes.length;i++)
            {
                peerCertificateChain[i] = new X509CertImpl(bytes[i]);
            } 
            boolean client = sslParameters.getUseClientMode();
    if(client)            
            {
                sslParameters.getTrustManager().checkServerTrusted(peerCertificateChain,
                                                                   authMethod);
            } 
            else
            {
                String authType = peerCertificateChain[0].getPublicKey().getAlgorithm();
                sslParameters.getTrustManager().checkClientTrusted(peerCertificateChain,
                                                                   authType);
            } 
        } 
        catch (CertificateException e)
        {
            e.addTaint(taint);
            throw e;
        } 
        catch (RuntimeException e)
        {
            e.addTaint(taint);
            throw e;
        } 
        catch (Exception e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_713904770 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_713904770.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_713904770;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.380 -0400", hash_original_method = "E61C85BF5C63F4E04D0D50BF3BBE2593", hash_generated_method = "9820EB1E494699C9E39FAED126CBF30E")
    @Override
    public InputStream getInputStream() throws IOException {
        checkOpen();
        synchronized
(this)        {
    if(is == null)            
            {
                is = new SSLInputStream();
            } 
InputStream varFEDEDC0F36E8CADECC99C26A1426338D_561718743 =             is;
            varFEDEDC0F36E8CADECC99C26A1426338D_561718743.addTaint(taint);
            return varFEDEDC0F36E8CADECC99C26A1426338D_561718743;
        } 
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.380 -0400", hash_original_method = "5EE71E3DCC35A33F08AD90BC3313950F", hash_generated_method = "DD313481D2E838DA5989AF76DC0D6B58")
    @Override
    public OutputStream getOutputStream() throws IOException {
        checkOpen();
        synchronized
(this)        {
    if(os == null)            
            {
                os = new SSLOutputStream();
            } 
OutputStream varB2E53C59873A0B658EA84CCA157ED224_1836053319 =             os;
            varB2E53C59873A0B658EA84CCA157ED224_1836053319.addTaint(taint);
            return varB2E53C59873A0B658EA84CCA157ED224_1836053319;
        } 
        
        
        
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.381 -0400", hash_original_method = "E137442CFB021C112EB3F3EAC9C4FE47", hash_generated_method = "F634191126B0420F6F952F64D20D1AB2")
    @Override
    public SSLSession getSession() {
    if(sslSession == null)        
        {
            try 
            {
                startHandshake(true);
            } 
            catch (IOException e)
            {
SSLSession var33266EACB2455415ED08B160E2815F03_1079518556 =                 SSLSessionImpl.NULL_SESSION;
                var33266EACB2455415ED08B160E2815F03_1079518556.addTaint(taint);
                return var33266EACB2455415ED08B160E2815F03_1079518556;
            } 
        } 
SSLSession varAC68A29D0E39337DAC16C06FFEB1623B_178560906 =         sslSession;
        varAC68A29D0E39337DAC16C06FFEB1623B_178560906.addTaint(taint);
        return varAC68A29D0E39337DAC16C06FFEB1623B_178560906;
        
        
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.381 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "4FD70577C7E2261F3E4FD67FE88225E0")
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        addTaint(listener.getTaint());
    if(listener == null)        
        {
            IllegalArgumentException varB02095FE0265340AABD25383D7376280_1570991039 = new IllegalArgumentException("Provided listener is null");
            varB02095FE0265340AABD25383D7376280_1570991039.addTaint(taint);
            throw varB02095FE0265340AABD25383D7376280_1570991039;
        } 
    if(listeners == null)        
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } 
        listeners.add(listener);
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.381 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "1328502CB9914C926E1C259162ED7D1D")
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        addTaint(listener.getTaint());
    if(listener == null)        
        {
            IllegalArgumentException varB02095FE0265340AABD25383D7376280_1662346182 = new IllegalArgumentException("Provided listener is null");
            varB02095FE0265340AABD25383D7376280_1662346182.addTaint(taint);
            throw varB02095FE0265340AABD25383D7376280_1662346182;
        } 
    if(listeners == null)        
        {
            IllegalArgumentException var10FDB35631F14D25CC68C0C86726BCA4_578031899 = new IllegalArgumentException(
                    "Provided listener is not registered");
            var10FDB35631F14D25CC68C0C86726BCA4_578031899.addTaint(taint);
            throw var10FDB35631F14D25CC68C0C86726BCA4_578031899;
        } 
    if(!listeners.remove(listener))        
        {
            IllegalArgumentException var10FDB35631F14D25CC68C0C86726BCA4_1571920053 = new IllegalArgumentException(
                    "Provided listener is not registered");
            var10FDB35631F14D25CC68C0C86726BCA4_1571920053.addTaint(taint);
            throw var10FDB35631F14D25CC68C0C86726BCA4_1571920053;
        } 
        
        
            
        
        
            
                    
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.382 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "3C9A2F0E5ACAD1DF052CF25D55BBF550")
    @Override
    public boolean getEnableSessionCreation() {
        boolean var6A496EF2CB1B11366741370C45064742_1503042992 = (sslParameters.getEnableSessionCreation());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1529113996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1529113996;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.382 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "85CCF52EB3F74FECC3630ABAAC720430")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.382 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "BBB47D0E958F3BFB4E6F2BFB80CA1E03")
    @Override
    public String[] getSupportedCipherSuites() {
String[] var0633111015CD199BA68A1C170162F6EA_1932258921 =         NativeCrypto.getSupportedCipherSuites();
        var0633111015CD199BA68A1C170162F6EA_1932258921.addTaint(taint);
        return var0633111015CD199BA68A1C170162F6EA_1932258921;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.383 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "2A05590ECFC9688D8E752DD25A62197E")
    @Override
    public String[] getEnabledCipherSuites() {
String[] var45BDDDD9D941A372292490884D2E3BF9_1796546764 =         enabledCipherSuites.clone();
        var45BDDDD9D941A372292490884D2E3BF9_1796546764.addTaint(taint);
        return var45BDDDD9D941A372292490884D2E3BF9_1796546764;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.383 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "3FB2F096A8758F371B7BAF38AC6E6A62")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.383 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "EA3DFA445D0EADBB2006290551E8E820")
    @Override
    public String[] getSupportedProtocols() {
String[] varA2CB83838D3C3E6CB428AFD2FA549124_381403163 =         NativeCrypto.getSupportedProtocols();
        varA2CB83838D3C3E6CB428AFD2FA549124_381403163.addTaint(taint);
        return varA2CB83838D3C3E6CB428AFD2FA549124_381403163;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.384 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "BF9369BA4AD21E818455A49D3778D50A")
    @Override
    public String[] getEnabledProtocols() {
String[] var7F784EE3631AE57BC482259F3F556633_674283857 =         enabledProtocols.clone();
        var7F784EE3631AE57BC482259F3F556633_674283857.addTaint(taint);
        return var7F784EE3631AE57BC482259F3F556633_674283857;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.384 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "3A7DB44E7B143D29605895C639B518A6")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.384 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "6965BE1F5993085874F1D9F23F861FF9")
    public String[] getSupportedCompressionMethods() {
String[] varBE8CCF8BFA8321AAC102544B2EEE72A0_1640335461 =         NativeCrypto.getSupportedCompressionMethods();
        varBE8CCF8BFA8321AAC102544B2EEE72A0_1640335461.addTaint(taint);
        return varBE8CCF8BFA8321AAC102544B2EEE72A0_1640335461;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.385 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "9F0A635666510A04E0B292FAED9F7507")
    public String[] getEnabledCompressionMethods() {
String[] varB18894ACCABD95AE01B6F73BD5F6D994_1222215908 =         enabledCompressionMethods.clone();
        varB18894ACCABD95AE01B6F73BD5F6D994_1222215908.addTaint(taint);
        return varB18894ACCABD95AE01B6F73BD5F6D994_1222215908;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.385 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "F6E8AD11719A044F802E33A113589650")
    public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.386 -0400", hash_original_method = "1BC96C488FBD7622E9D1B33430C794F4", hash_generated_method = "9069498A56026D20FD8A09727B7034AD")
    public void setUseSessionTickets(boolean useSessionTickets) {
        this.useSessionTickets = useSessionTickets;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.386 -0400", hash_original_method = "A3C6DFBE0DD33FFBDB883F2D56D0E9E8", hash_generated_method = "7F6DB2623DC2C5039EF0AE7949EDDAF7")
    public void setHostname(String hostname) {
        this.hostname = hostname;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.386 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "5CE3B8B4F1C68E29D2E26EEEF0F7FCBE")
    @Override
    public boolean getUseClientMode() {
        boolean var264C485BBAEC609C8CEC6E380F554AB0_151027844 = (sslParameters.getUseClientMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1402478405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1402478405;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.387 -0400", hash_original_method = "796A366B3F70011E31FF500388066E2F", hash_generated_method = "6748F6709CBF0871C0A991F76ADF35FF")
    @Override
    public void setUseClientMode(boolean mode) {
        addTaint(mode);
    if(handshakeStarted)        
        {
            IllegalArgumentException var090A9C2074D1C9D942FE5C4CFD7155B6_22036589 = new IllegalArgumentException(
                    "Could not change the mode after the initial handshake has begun.");
            var090A9C2074D1C9D942FE5C4CFD7155B6_22036589.addTaint(taint);
            throw var090A9C2074D1C9D942FE5C4CFD7155B6_22036589;
        } 
        sslParameters.setUseClientMode(mode);
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.387 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "F64C07C661369FDA5A9ACC140290C1C9")
    @Override
    public boolean getWantClientAuth() {
        boolean var49776A2797A76D9AE0E32B9F61634A24_1618108913 = (sslParameters.getWantClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_387084497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_387084497;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.387 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "2E2620E72E9353E6AB09D9D7FB77C1E3")
    @Override
    public boolean getNeedClientAuth() {
        boolean var8775D3F02F22101BF43E8B27516BBE95_792007742 = (sslParameters.getNeedClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1569393954 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1569393954;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.388 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "BA7C72106D7ACD8A3990718038741929")
    @Override
    public void setNeedClientAuth(boolean need) {
        addTaint(need);
        sslParameters.setNeedClientAuth(need);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.388 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "09030FB81E24A5D701A15381DB305A48")
    @Override
    public void setWantClientAuth(boolean want) {
        addTaint(want);
        sslParameters.setWantClientAuth(want);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.388 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "8E61FFC696AE6CC55A1092A038D14339")
    @Override
    public void sendUrgentData(int data) throws IOException {
        addTaint(data);
        SocketException var50B8BFCDC6E8315B913207C5748AC53B_552451801 = new SocketException("Method sendUrgentData() is not supported.");
        var50B8BFCDC6E8315B913207C5748AC53B_552451801.addTaint(taint);
        throw var50B8BFCDC6E8315B913207C5748AC53B_552451801;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.389 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "9DB65F1A6C8C574D3FF95F42411D3409")
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        addTaint(on);
        SocketException var88B0E59078F2F2FADE721829F824BF94_1355082374 = new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
        var88B0E59078F2F2FADE721829F824BF94_1355082374.addTaint(taint);
        throw var88B0E59078F2F2FADE721829F824BF94_1355082374;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.389 -0400", hash_original_method = "E02183BB387F9960402CB70797EE289E", hash_generated_method = "B02004F7A366D969474A8D629373A474")
    @Override
    public void setSoTimeout(int timeoutMilliseconds) throws SocketException {
        super.setSoTimeout(timeoutMilliseconds);
        this.timeoutMilliseconds = timeoutMilliseconds;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.390 -0400", hash_original_method = "5DC72E2D363A272A051BD7C43DA762A2", hash_generated_method = "D381FD6003E0C3099D24CE3EF233DBF2")
    @Override
    public int getSoTimeout() throws SocketException {
        int var5FB15470AC503271BD2B094F75548AD8_829598748 = (timeoutMilliseconds);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059633796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1059633796;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.390 -0400", hash_original_method = "CE465C7A533FEAB3164F103F1DBDF364", hash_generated_method = "6671F89B44C6C2B43F432B4E79ACC3F2")
    public void setHandshakeTimeout(int timeoutMilliseconds) throws SocketException {
        this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.391 -0400", hash_original_method = "B24ED3F34169856B1F2602ADA3894B40", hash_generated_method = "62BAAE86488E43F79C284413A241F3EE")
    @Override
    public void close() throws IOException {
        synchronized
(handshakeLock)        {
    if(!handshakeStarted)            
            {
                handshakeStarted = true;
                synchronized
(this)                {
                    free();
    if(socket != this)                    
                    {
    if(autoClose && !socket.isClosed())                        
                        socket.close();
                    } 
                    else
                    {
    if(!super.isClosed())                        
                        super.close();
                    } 
                } 
                return;
            } 
        } 
        NativeCrypto.SSL_interrupt(sslNativePointer);
        synchronized
(this)        {
            synchronized
(writeLock)            {
                synchronized
(readLock)                {
                    try 
                    {
    if(handshakeStarted)                        
                        {
                            BlockGuard.getThreadPolicy().onNetwork();
                            NativeCrypto.SSL_shutdown(sslNativePointer, socket.getFileDescriptor$(),
                                    this);
                        } 
                    } 
                    catch (IOException ignored)
                    {
                    } 
                    finally 
                    {
                        free();
    if(socket != this)                        
                        {
    if(autoClose && !socket.isClosed())                            
                            {
                                socket.close();
                            } 
                        } 
                        else
                        {
    if(!super.isClosed())                            
                            {
                                super.close();
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.392 -0400", hash_original_method = "0B5EFC2C593350712C0760AFE47F069D", hash_generated_method = "9E089A296342E7DA8FE064679399176B")
    private void free() {
    if(sslNativePointer == 0)        
        {
            return;
        } 
        NativeCrypto.SSL_free(sslNativePointer);
        sslNativePointer = 0;
        guard.close();
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.392 -0400", hash_original_method = "48478F0D5C609BA19837DA284D888FF0", hash_generated_method = "BF8C5AB2E5F2BC68AEE0A2853FF7968C")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
    if(guard != null)            
            {
                guard.warnIfOpen();
            } 
            free();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.393 -0400", hash_original_method = "E6BCE3543B6D551909C5B870C6A9DC54", hash_generated_method = "B019BC846FC0F310CF52713EDC2A4D7B")
    @Override
    public FileDescriptor getFileDescriptor$() {
    if(socket == this)        
        {
FileDescriptor varE6D22E20A7AB84D88845D106C3CA0801_2096435692 =             super.getFileDescriptor$();
            varE6D22E20A7AB84D88845D106C3CA0801_2096435692.addTaint(taint);
            return varE6D22E20A7AB84D88845D106C3CA0801_2096435692;
        } 
        else
        {
FileDescriptor varECF71702861DD6150A427D89C35684D2_1862393924 =             socket.getFileDescriptor$();
            varECF71702861DD6150A427D89C35684D2_1862393924.addTaint(taint);
            return varECF71702861DD6150A427D89C35684D2_1862393924;
        } 
        
        
            
        
            
        
    }

    
    private class SSLInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.393 -0400", hash_original_method = "B153503C58DDB9DC7588696F0617BD77", hash_generated_method = "542D2766BEEB467DA4F5A36EE222A67B")
          SSLInputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.394 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "2862B1E7584CEB42510D58C23D41E4E8")
        @Override
        public int read() throws IOException {
            int varC29A5AE95A30EE64395CAB97F32FA4B0_7226833 = (Streams.readSingleByte(this));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251780689 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_251780689;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.394 -0400", hash_original_method = "DB2A9854396CBE443BE0852C07C28BD2", hash_generated_method = "7B667B5B3D3E82A89A8E768AB3BDC3CD")
        @Override
        public int read(byte[] buf, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buf[0]);
            BlockGuard.getThreadPolicy().onNetwork();
            synchronized
(readLock)            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
    if(byteCount == 0)                
                {
                    int varCFCD208495D565EF66E7DFF9F98764DA_518203782 = (0);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485818994 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1485818994;
                } 
                int var3099A4954B670DF30303EB7C0E705A35_180655963 = (NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout()));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874448113 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_874448113;
            } 
            
            
            
                
                
                
                    
                
                
                        
            
        }

        
    }


    
    private class SSLOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.395 -0400", hash_original_method = "1E1541DFFE880DA1B7719D7E370B4D89", hash_generated_method = "2CF7E8309B0292C00087EB8F19D9BB26")
          SSLOutputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.395 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "64E00942800EFBB3ACEFB66C4126D5C6")
        @Override
        public void write(int oneByte) throws IOException {
            addTaint(oneByte);
            Streams.writeSingleByte(this, oneByte);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.395 -0400", hash_original_method = "D98A6CBE7C5513FE6A9CDBBB263207DD", hash_generated_method = "90A357D8A2A56B0200D0B620C08F7CD5")
        @Override
        public void write(byte[] buf, int offset, int byteCount) throws IOException {
            addTaint(byteCount);
            addTaint(offset);
            addTaint(buf[0]);
            BlockGuard.getThreadPolicy().onNetwork();
            synchronized
(writeLock)            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
    if(byteCount == 0)                
                {
                    return;
                } 
                NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount);
            } 
            
            
            
                
                
                
                    
                
                
                        
            
        }

        
    }


    
}

