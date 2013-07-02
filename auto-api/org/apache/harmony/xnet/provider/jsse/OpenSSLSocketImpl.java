package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "7A26561346F073823CD60CDE206B36E2", hash_generated_field = "748A6049ACB01D98F85E21799F2EB11A")

    private int sslNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "BFEC39E15FADDFA148ED8D3CE22EABA4")

    private OutputStream os;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "85E5D87B8B4A646833A43466B8645F5F", hash_generated_field = "BBF990300E3830CE6A958CDB35B29B27")

    private final Object handshakeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "E06B9588EA49DFE66B571508521E184B")

    private final Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "4EB051AF8374C9B2C038ADD375A89D80")

    private final Object writeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "BFF5830B7B00AB1C369E1E6FB3114CB0", hash_generated_field = "85F0E10109EFE4B8F58BC1776613705B")

    private String[] enabledProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "7AD17E190B7E5C8B7D224A9E272C550F")

    private String[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "0D8BDE82F30FA6C13A6F9BC50134508D", hash_generated_field = "3ED2FE1E30316545E9184B9907A7D6E3")

    private String[] enabledCompressionMethods;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "8F6035B29AA347B1267CEF3F327C2192", hash_generated_field = "A2F538231066932F5915EF28021541F1")

    private boolean useSessionTickets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "3893D7DE6BC507FB95AA82B03DBC44D7", hash_generated_field = "368A75AAABC6FBEB91272F5EA8465622")

    private OpenSSLSessionImpl sslSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.491 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "676DF800F5B7B514B01D50F354ACAFF6", hash_generated_field = "5B583CD79FBEC6280A38CE8E3A8DAA8A")

    private boolean handshakeStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "595005CA65C71040ACDA0D73FCAD2D32", hash_generated_field = "2D23168D66D17A93982E63C6133878AC")

    private boolean handshakeCompleted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "8D4C6D611B20EB0D2D4A15AE21386B82", hash_generated_field = "D9040C82E2DDED5191E6D7AE598F1DB8")

    private int timeoutMilliseconds = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "AE8D1946443647A8D684B091A86F1F48", hash_generated_field = "924BC0B5E41E0BD4B8C4C178AB494DA8")

    private int handshakeTimeoutMilliseconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "ADCF75E4E8815498EC1B7BB88537B5B6", hash_generated_field = "6FB2C77C604FE1268BFA3B979F3F3054")

    private String wrappedHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_field = "F29AFDAD6C88B29B62279111343E9F96", hash_generated_field = "B7D8F64F41E806C80BDECFDD8FA68EFA")

    private int wrappedPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_method = "1E0B4679EC7761107339F1A8D3A55F9F", hash_generated_method = "DF6A02121AD8816ADB3A8B8F5A8058AF")
    protected  OpenSSLSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.socket = this;
        init(sslParameters);
        addTaint(sslParameters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.492 -0400", hash_original_method = "7190C9F3617EA957D6C6C5547D61E7DA", hash_generated_method = "971D7397124651619FCECFF99B5BE04A")
    protected  OpenSSLSocketImpl(SSLParametersImpl sslParameters,
                                String[] enabledProtocols,
                                String[] enabledCipherSuites,
                                String[] enabledCompressionMethods) throws IOException {
        this.socket = this;
        init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
        addTaint(sslParameters.getTaint());
        addTaint(enabledProtocols[0].getTaint());
        addTaint(enabledCipherSuites[0].getTaint());
        addTaint(enabledCompressionMethods[0].getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.493 -0400", hash_original_method = "8EFC55677F513E24A665A5B10C8DD781", hash_generated_method = "7D8F823CA102F891371A534B41192A46")
    protected  OpenSSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        this.socket = this;
        init(sslParameters);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(sslParameters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.493 -0400", hash_original_method = "3B4C2FC0F73F444026E804CAAB2D3AA5", hash_generated_method = "DAD6E8973B6E1A3A40FC55411B4A8839")
    protected  OpenSSLSocketImpl(InetAddress address, int port, SSLParametersImpl sslParameters) throws IOException {
        super(address, port);
        this.socket = this;
        init(sslParameters);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(sslParameters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.493 -0400", hash_original_method = "3EB3C6E00E78F272783CA82B1518096D", hash_generated_method = "727E6606B6D469FB3B96532202D84FBA")
    protected  OpenSSLSocketImpl(String host, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(host, port, clientAddress, clientPort);
        this.socket = this;
        init(sslParameters);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(clientAddress.getTaint());
        addTaint(clientPort);
        addTaint(sslParameters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.493 -0400", hash_original_method = "BF524C761FC1FBF2285E42FB758995EF", hash_generated_method = "0AE5725DA8DDFE4BA51FAF6016D5D844")
    protected  OpenSSLSocketImpl(InetAddress address, int port,
                                InetAddress clientAddress, int clientPort,
                                SSLParametersImpl sslParameters) throws IOException {
        super(address, port, clientAddress, clientPort);
        this.socket = this;
        init(sslParameters);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(clientAddress.getTaint());
        addTaint(clientPort);
        addTaint(sslParameters.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.493 -0400", hash_original_method = "E8402FE2BCEFBC2883099C44FF33F005", hash_generated_method = "3FEC15D875FCBF1D6FD52A4DE58DA996")
    protected  OpenSSLSocketImpl(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        this.socket = socket;
        this.wrappedHost = host;
        this.wrappedPort = port;
        this.autoClose = autoClose;
        init(sslParameters);
        addTaint(sslParameters.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.494 -0400", hash_original_method = "33D1B746D20986D17267826F3151AB68", hash_generated_method = "A1286579E3F565D5CA6F2D976D38078D")
    private void init(SSLParametersImpl sslParameters) throws IOException {
        init(sslParameters,
             NativeCrypto.getSupportedProtocols(),
             NativeCrypto.getDefaultCipherSuites(),
             NativeCrypto.getDefaultCompressionMethods());
        addTaint(sslParameters.getTaint());
        
        
             
             
             
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.494 -0400", hash_original_method = "28ECC4752D5D2759E8F75423B7F304E1", hash_generated_method = "85DC27B70EC2B768C744122A7207BA7A")
    private void init(SSLParametersImpl sslParameters,
                      String[] enabledProtocols,
                      String[] enabledCipherSuites,
                      String[] enabledCompressionMethods) throws IOException {
        this.sslParameters = sslParameters;
        this.enabledProtocols = enabledProtocols;
        this.enabledCipherSuites = enabledCipherSuites;
        this.enabledCompressionMethods = enabledCompressionMethods;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.503 -0400", hash_original_method = "DB9C757E33C47645F1FC9AEA51E10B24", hash_generated_method = "9D12CCAFD54C0EDCFE8DD0DCADF38960")
    private OpenSSLSessionImpl getCachedClientSession(ClientSessionContext sessionContext) {
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_507712614 = null; 
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_452167819 = null; 
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_275920249 = null; 
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1025284466 = null; 
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_675771299 = null; 
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1437301402 = null; 
        {
            boolean varDE450B6D8CDA8C5A5EBF790451254751_2071182767 = (super.getInetAddress() == null ||
                super.getInetAddress().getHostAddress() == null ||
                super.getInetAddress().getHostName() == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_507712614 = null;
            } 
        } 
        OpenSSLSessionImpl session = (OpenSSLSessionImpl) sessionContext.getSession(
                super.getInetAddress().getHostName(),
                super.getPort());
        {
            varB4EAC82CA7396A68D541C85D26508E83_452167819 = null;
        } 
        String protocol = session.getProtocol();
        boolean protocolFound = false;
        {
            String enabledProtocol = enabledProtocols[0];
            {
                {
                    boolean varB7CDD2851C57BCE06B93A6CED39A5E38_65100158 = (protocol.equals(enabledProtocol));
                    {
                        protocolFound = true;
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_275920249 = null;
        } 
        String cipherSuite = session.getCipherSuite();
        boolean cipherSuiteFound = false;
        {
            String enabledCipherSuite = enabledCipherSuites[0];
            {
                {
                    boolean var0A90D4178EA81E08B8356065F33DB016_586918693 = (cipherSuite.equals(enabledCipherSuite));
                    {
                        cipherSuiteFound = true;
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1025284466 = null;
        } 
        String compressionMethod = session.getCompressionMethod();
        boolean compressionMethodFound = false;
        {
            String enabledCompressionMethod = enabledCompressionMethods[0];
            {
                {
                    boolean varDF0B1461F4631C44245857F1697AFCF1_443159737 = (compressionMethod.equals(enabledCompressionMethod));
                    {
                        compressionMethodFound = true;
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_675771299 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1437301402 = session;
        addTaint(sessionContext.getTaint());
        OpenSSLSessionImpl varA7E53CE21691AB073D9660D615818899_612769829; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_507712614;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_452167819;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_275920249;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_1025284466;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_675771299;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_612769829 = varB4EAC82CA7396A68D541C85D26508E83_1437301402;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_612769829.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_612769829;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.504 -0400", hash_original_method = "6F34DF1209370488AD4C31DC9A9003CA", hash_generated_method = "875A1614B9E32119678388031424EBE3")
    @Override
    public void startHandshake() throws IOException {
        startHandshake(true);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.504 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "4CA29DAFFF261E862A7A1CA1552F23D3")
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_2020331999 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } 
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.579 -0400", hash_original_method = "7D68DA7254C24BFF3C6F787A75CF4E46", hash_generated_method = "1665D04618E5F491F69FC8974188D140")
    public synchronized void startHandshake(boolean full) throws IOException {
        {
            checkOpen();
            {
                handshakeStarted = true;
            } 
        } 
        final int seedLengthInBytes = NativeCrypto.RAND_SEED_LENGTH_IN_BYTES;
        final SecureRandom secureRandom = sslParameters.getSecureRandomMember();
        {
            NativeCrypto.RAND_load_file("/dev/urandom", seedLengthInBytes);
        } 
        {
            NativeCrypto.RAND_seed(secureRandom.generateSeed(seedLengthInBytes));
        } 
        final boolean client = sslParameters.getUseClientMode();
        int sslCtxNativePointer;
        sslCtxNativePointer = sslParameters.getClientSessionContext().sslCtxNativePointer;
        sslCtxNativePointer = sslParameters.getServerSessionContext().sslCtxNativePointer;
        this.sslNativePointer = 0;
        boolean exception = true;
        try 
        {
            sslNativePointer = NativeCrypto.SSL_new(sslCtxNativePointer);
            guard.open("close");
            {
                Set<String> keyTypes = new HashSet<String>();
                {
                    String enabledCipherSuite = enabledCipherSuites[0];
                    {
                        {
                            boolean varB970A4D1689EFCBF0C591729604E2F5C_503395742 = (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV));
                        } 
                        String keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                        {
                            keyTypes.add(keyType);
                        } 
                    } 
                } 
                {
                    Iterator<String> var594EC992A710F64B1906006B59DD5293_2140138835 = (keyTypes).iterator();
                    var594EC992A710F64B1906006B59DD5293_2140138835.hasNext();
                    String keyType = var594EC992A710F64B1906006B59DD5293_2140138835.next();
                    {
                        try 
                        {
                            setCertificate(sslParameters.getKeyManager().chooseServerAlias(keyType,
                                                                                       null,
                                                                                       this));
                        } 
                        catch (CertificateEncodingException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException(e);
                        } 
                    } 
                } 
            } 
            NativeCrypto.setEnabledProtocols(sslNativePointer, enabledProtocols);
            NativeCrypto.setEnabledCipherSuites(sslNativePointer, enabledCipherSuites);
            {
                NativeCrypto.setEnabledCompressionMethods(sslNativePointer,
                                                          enabledCompressionMethods);
            } 
            {
                NativeCrypto.SSL_clear_options(sslNativePointer, NativeCrypto.SSL_OP_NO_TICKET);
            } 
            {
                NativeCrypto.SSL_set_tlsext_host_name(sslNativePointer, hostname);
            } 
            boolean enableSessionCreation = sslParameters.getEnableSessionCreation();
            {
                NativeCrypto.SSL_set_session_creation_enabled(sslNativePointer,
                                                              enableSessionCreation);
            } 
            AbstractSessionContext sessionContext;
            {
                ClientSessionContext clientSessionContext = sslParameters.getClientSessionContext();
                sessionContext = clientSessionContext;
                OpenSSLSessionImpl session = getCachedClientSession(clientSessionContext);
                {
                    NativeCrypto.SSL_set_session(sslNativePointer,
                                                 session.sslSessionNativePointer);
                } 
            } 
            {
                sessionContext = sslParameters.getServerSessionContext();
            } 
            {
                boolean certRequested;
                {
                    boolean varDC6B96A2EBF53EC5C7FA36AF2244C1B9_1931907924 = (sslParameters.getNeedClientAuth());
                    {
                        NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER
                                                | NativeCrypto.SSL_VERIFY_FAIL_IF_NO_PEER_CERT);
                        certRequested = true;
                    } 
                    {
                        boolean varBA129A971A32EF54D8E824D21B4687C7_1100438192 = (sslParameters.getWantClientAuth());
                        {
                            NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER);
                            certRequested = true;
                        } 
                        {
                            certRequested = false;
                        } 
                    } 
                } 
                {
                    X509TrustManager trustManager = sslParameters.getTrustManager();
                    X509Certificate[] issuers = trustManager.getAcceptedIssuers();
                    {
                        byte[][] issuersBytes = null;
                        try 
                        {
                            issuersBytes = NativeCrypto.encodeIssuerX509Principals(issuers);
                        } 
                        catch (CertificateEncodingException e)
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IOException("Problem encoding principals", e);
                        } 
                        NativeCrypto.SSL_set_client_CA_list(sslNativePointer, issuersBytes);
                    } 
                } 
            } 
            {
                NativeCrypto.SSL_clear_mode(sslNativePointer,
                                            NativeCrypto.SSL_MODE_HANDSHAKE_CUTTHROUGH);
            } 
            int savedTimeoutMilliseconds = getSoTimeout();
            {
                setSoTimeout(handshakeTimeoutMilliseconds);
            } 
            int sslSessionNativePointer = 0;
            try 
            {
                sslSessionNativePointer = NativeCrypto.SSL_do_handshake(sslNativePointer,
                        socket.getFileDescriptor$(), this, getSoTimeout(), client);
            } 
            catch (CertificateException e)
            {
                SSLHandshakeException wrapper = new SSLHandshakeException(e.getMessage());
                wrapper.initCause(e);
                if (DroidSafeAndroidRuntime.control) throw wrapper;
            } 
            byte[] sessionId = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
            sslSession = (OpenSSLSessionImpl) sessionContext.getSession(sessionId);
            {
                sslSession.lastAccessedTime = System.currentTimeMillis();
                NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSL Session may not be created");
                } 
                X509Certificate[] localCertificates = createCertChain(NativeCrypto.SSL_get_certificate(sslNativePointer));
                X509Certificate[] peerCertificates = createCertChain(NativeCrypto.SSL_get_peer_cert_chain(sslNativePointer));
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        super.getInetAddress().getHostName(),
                                                        super.getPort(), sessionContext);
                } 
                {
                    sslSession = new OpenSSLSessionImpl(sslSessionNativePointer,
                                                        localCertificates, peerCertificates,
                                                        wrappedHost, wrappedPort,
                                                        sessionContext);
                } 
                {
                    sessionContext.putSession(sslSession);
                } 
            } 
            {
                setSoTimeout(savedTimeoutMilliseconds);
            } 
            {
                notifyHandshakeCompletedListeners();
            } 
            exception = false;
        } 
        catch (SSLProtocolException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLHandshakeException(e);
        } 
        finally 
        {
            {
                close();
            } 
        } 
        addTaint(full);
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.579 -0400", hash_original_method = "447042B984B2D213A231B86095B05FCC", hash_generated_method = "C6BF9F6970C52A93B793B09290134AA2")
    private void setCertificate(String alias) throws CertificateEncodingException, SSLException {
        PrivateKey privateKey = sslParameters.getKeyManager().getPrivateKey(alias);
        X509Certificate[] certificates = sslParameters.getKeyManager().getCertificateChain(alias);
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[][] certificateBytes = NativeCrypto.encodeCertificates(certificates);
        NativeCrypto.SSL_use_PrivateKey(sslNativePointer, privateKeyBytes);
        NativeCrypto.SSL_use_certificate(sslNativePointer, certificateBytes);
        NativeCrypto.SSL_check_private_key(sslNativePointer);
        addTaint(alias.getTaint());
        
        
            
        
        
        
            
        
        
        
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.580 -0400", hash_original_method = "4494930597AF8911ABFC977B28D550D9", hash_generated_method = "1FCD95BAEBD92A73FFC8CA807C45B4CA")
    @SuppressWarnings("unused")
    public void clientCertificateRequested(byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws CertificateEncodingException, SSLException {
        String[] keyTypes = new String[keyTypeBytes.length];
        {
            int i = 0;
            {
                keyTypes[i] = CipherSuite.getClientKeyType(keyTypeBytes[i]);
            } 
        } 
        X500Principal[] issuers;
        {
            issuers = null;
        } 
        {
            issuers = new X500Principal[asn1DerEncodedPrincipals.length];
            {
                int i = 0;
                {
                    issuers[i] = new X500Principal(asn1DerEncodedPrincipals[i]);
                } 
            } 
        } 
        setCertificate(sslParameters.getKeyManager().chooseClientAlias(keyTypes, issuers, this));
        addTaint(keyTypeBytes[0]);
        addTaint(asn1DerEncodedPrincipals[0][0]);
        
        
        
            
        
        
        
            
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.580 -0400", hash_original_method = "4135185E706706A43228536D20F5AD94", hash_generated_method = "DC5B0A3B26A732BB76C81AA84C76519A")
    @SuppressWarnings("unused")
    public void handshakeCompleted() {
        handshakeCompleted = true;
        sslSession.resetId();
        AbstractSessionContext sessionContext;
        boolean var90A449D6F1E51FE89C1444A2ABB20FCB_2101680302 = ((sslParameters.getUseClientMode()));
        sessionContext = sslParameters.getClientSessionContext();
        sessionContext = sslParameters.getServerSessionContext();
        sessionContext.putSession(sslSession);
        notifyHandshakeCompletedListeners();
        
        
        
            
        
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.585 -0400", hash_original_method = "7C2534895E7335878B6E22FB6F2D87D0", hash_generated_method = "D5A75D7A41241AD1DBBD508FF0FBCAC7")
    private void notifyHandshakeCompletedListeners() {
        {
            boolean varEA141DED028EB95B14754CBD79C46500_443178355 = (listeners != null && !listeners.isEmpty());
            {
                HandshakeCompletedEvent event = new HandshakeCompletedEvent(this, sslSession);
                {
                    Iterator<HandshakeCompletedListener> varFA1A76B379D1DD4A9E969658BDCFB86E_161338917 = (listeners).iterator();
                    varFA1A76B379D1DD4A9E969658BDCFB86E_161338917.hasNext();
                    HandshakeCompletedListener listener = varFA1A76B379D1DD4A9E969658BDCFB86E_161338917.next();
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
        } 
        
        
            
                
            
                
                    
                
                    
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.586 -0400", hash_original_method = "ED84B1AF9EB80DCCE7D2C3DBC193F549", hash_generated_method = "31D980B77D2D1E1FE877B48BE2DC01A0")
    @SuppressWarnings("unused")
    @Override
    public void verifyCertificateChain(byte[][] bytes, String authMethod) throws CertificateException {
        try 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new SSLException("Peer sent no certificate");
            } 
            X509Certificate[] peerCertificateChain = new X509Certificate[bytes.length];
            {
                int i = 0;
                {
                    peerCertificateChain[i] = new X509CertImpl(bytes[i]);
                } 
            } 
            boolean client = sslParameters.getUseClientMode();
            {
                sslParameters.getTrustManager().checkServerTrusted(peerCertificateChain,
                                                                   authMethod);
            } 
            {
                String authType = peerCertificateChain[0].getPublicKey().getAlgorithm();
                sslParameters.getTrustManager().checkClientTrusted(peerCertificateChain,
                                                                   authType);
            } 
        } 
        catch (CertificateException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (RuntimeException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } 
        addTaint(bytes[0][0]);
        addTaint(authMethod.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.586 -0400", hash_original_method = "E61C85BF5C63F4E04D0D50BF3BBE2593", hash_generated_method = "47D6A03923CA3CCE55ABB6C5E66DD5AD")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_1290218401 = null; 
        checkOpen();
        {
            {
                is = new SSLInputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1290218401 = is;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1290218401.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1290218401;
        
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.587 -0400", hash_original_method = "5EE71E3DCC35A33F08AD90BC3313950F", hash_generated_method = "B34D987656E3D32D036FF8F691357430")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_333394152 = null; 
        checkOpen();
        {
            {
                os = new SSLOutputStream();
            } 
            varB4EAC82CA7396A68D541C85D26508E83_333394152 = os;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_333394152.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_333394152;
        
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.588 -0400", hash_original_method = "E137442CFB021C112EB3F3EAC9C4FE47", hash_generated_method = "91902E3CFB36F8F8D9272F8034D4A64D")
    @Override
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_45737948 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1408018792 = null; 
        {
            try 
            {
                startHandshake(true);
            } 
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_45737948 = SSLSessionImpl.NULL_SESSION;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1408018792 = sslSession;
        SSLSession varA7E53CE21691AB073D9660D615818899_629269073; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_629269073 = varB4EAC82CA7396A68D541C85D26508E83_45737948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_629269073 = varB4EAC82CA7396A68D541C85D26508E83_1408018792;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_629269073.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_629269073;
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.588 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "7287E9F6B751EA96DE97D34C6E28B2B8")
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } 
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } 
        listeners.add(listener);
        addTaint(listener.getTaint());
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.588 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "7CCCCA5B0601D4CB4F487E45AFFBB305")
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
        } 
        {
            boolean var170C22586EF26335003A8446D4D19EBD_1693312359 = (!listeners.remove(listener));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
            } 
        } 
        addTaint(listener.getTaint());
        
        
            
        
        
            
                    
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.589 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "C1C2686685FE7B4715FD4DFF1BF9E241")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_712952308 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_166769049 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_166769049;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.589 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.589 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "4723394D7745DAE3D11F0BC10D624B43")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_249378068 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_249378068 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_249378068.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_249378068;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.590 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "C959849F69CBA5E33337459DC54C12AB")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1788623902 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1788623902 = enabledCipherSuites.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1788623902.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1788623902;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.590 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "3FB2F096A8758F371B7BAF38AC6E6A62")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.590 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "B81FFD929FC03D913C7A1A72C38D3A17")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_812008280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_812008280 = NativeCrypto.getSupportedProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_812008280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_812008280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.591 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "F832DC3A2501C47FA7D856253A862874")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_724387949 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_724387949 = enabledProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_724387949.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_724387949;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.591 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "3A7DB44E7B143D29605895C639B518A6")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.591 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "26885AC8EECDBA0A2E6F57E0472FBAF2")
    public String[] getSupportedCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_945914306 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_945914306 = NativeCrypto.getSupportedCompressionMethods();
        varB4EAC82CA7396A68D541C85D26508E83_945914306.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_945914306;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.592 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "4EDB5543F32706C953A1BBFCF6BEEDA0")
    public String[] getEnabledCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_864360073 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_864360073 = enabledCompressionMethods.clone();
        varB4EAC82CA7396A68D541C85D26508E83_864360073.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_864360073;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.592 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "F6E8AD11719A044F802E33A113589650")
    public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.592 -0400", hash_original_method = "1BC96C488FBD7622E9D1B33430C794F4", hash_generated_method = "9069498A56026D20FD8A09727B7034AD")
    public void setUseSessionTickets(boolean useSessionTickets) {
        this.useSessionTickets = useSessionTickets;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.593 -0400", hash_original_method = "A3C6DFBE0DD33FFBDB883F2D56D0E9E8", hash_generated_method = "7F6DB2623DC2C5039EF0AE7949EDDAF7")
    public void setHostname(String hostname) {
        this.hostname = hostname;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.593 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "AB874C2855E5FAC6189389890EB944A4")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1834241605 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_443030659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_443030659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.593 -0400", hash_original_method = "796A366B3F70011E31FF500388066E2F", hash_generated_method = "7E7008FF9D8848F21E35A0053ED6BD48")
    @Override
    public void setUseClientMode(boolean mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Could not change the mode after the initial handshake has begun.");
        } 
        sslParameters.setUseClientMode(mode);
        addTaint(mode);
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.594 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C45EC5DFCBCEDA01C2D7CF592FB95B76")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1322431242 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102432051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102432051;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.594 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "8B70FED4D29ABBB4D7BB5411771E2EB7")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1492724233 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373795648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373795648;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.594 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.595 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.595 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "352C1C0A002DF95EBF288C4FF5A377A5")
    @Override
    public void sendUrgentData(int data) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Method sendUrgentData() is not supported.");
        addTaint(data);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.595 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "03B4E46C1F8C665C265246E76BB39911")
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
        addTaint(on);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.596 -0400", hash_original_method = "E02183BB387F9960402CB70797EE289E", hash_generated_method = "B02004F7A366D969474A8D629373A474")
    @Override
    public void setSoTimeout(int timeoutMilliseconds) throws SocketException {
        super.setSoTimeout(timeoutMilliseconds);
        this.timeoutMilliseconds = timeoutMilliseconds;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.596 -0400", hash_original_method = "5DC72E2D363A272A051BD7C43DA762A2", hash_generated_method = "94143637A2C9649BE750DFDB48AE5696")
    @Override
    public int getSoTimeout() throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123352786 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123352786;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.596 -0400", hash_original_method = "CE465C7A533FEAB3164F103F1DBDF364", hash_generated_method = "6671F89B44C6C2B43F432B4E79ACC3F2")
    public void setHandshakeTimeout(int timeoutMilliseconds) throws SocketException {
        this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.597 -0400", hash_original_method = "B24ED3F34169856B1F2602ADA3894B40", hash_generated_method = "FDA62998B6BD8424C3E5296D33D8142E")
    @Override
    public void close() throws IOException {
        {
            {
                handshakeStarted = true;
                {
                    free();
                    {
                        boolean varD005D44E966655D4EF5111258788BDE6_1866277138 = (socket != this);
                        {
                            {
                                boolean var4DF33A3328473828362786F341A256EE_689675423 = (autoClose && !socket.isClosed());
                                socket.close();
                            } 
                        } 
                        {
                            {
                                boolean varFFACBC82D9AF35C8BB47D8A0637A6062_1075862497 = (!super.isClosed());
                                super.close();
                            } 
                        } 
                    } 
                } 
            } 
        } 
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
                        } 
                    } 
                    catch (IOException ignored)
                    { }
                    finally 
                    {
                        free();
                        {
                            boolean var9B1ACD52F4FCB38CE1E60CBDC1AAE3BC_1500807250 = (socket != this);
                            {
                                {
                                    boolean var3517699F99256E8181CD89A82659CE69_1065813989 = (autoClose && !socket.isClosed());
                                    {
                                        socket.close();
                                    } 
                                } 
                            } 
                            {
                                {
                                    boolean varE75AF6E6ED9346F3AD29B561C824DE81_389511053 = (!super.isClosed());
                                    {
                                        super.close();
                                    } 
                                } 
                            } 
                        } 
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.597 -0400", hash_original_method = "0B5EFC2C593350712C0760AFE47F069D", hash_generated_method = "ECFAC03105594EE600B9228F2432EC31")
    private void free() {
        NativeCrypto.SSL_free(sslNativePointer);
        sslNativePointer = 0;
        guard.close();
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.598 -0400", hash_original_method = "48478F0D5C609BA19837DA284D888FF0", hash_generated_method = "882FADDE20E830A83BAA462AE46622BF")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.598 -0400", hash_original_method = "E6BCE3543B6D551909C5B870C6A9DC54", hash_generated_method = "C606EA2E0A5DF7A748868768A354487D")
    @Override
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_496398103 = null; 
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_1112356836 = null; 
        {
            boolean varC17DE78B0F5B654D1C3BAA61447DB932_248002819 = (socket == this);
            {
                varB4EAC82CA7396A68D541C85D26508E83_496398103 = super.getFileDescriptor$();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1112356836 = socket.getFileDescriptor$();
            } 
        } 
        FileDescriptor varA7E53CE21691AB073D9660D615818899_727238672; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_727238672 = varB4EAC82CA7396A68D541C85D26508E83_496398103;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_727238672 = varB4EAC82CA7396A68D541C85D26508E83_1112356836;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_727238672.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_727238672;
        
        
            
        
            
        
    }

    
    private class SSLInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.599 -0400", hash_original_method = "B153503C58DDB9DC7588696F0617BD77", hash_generated_method = "542D2766BEEB467DA4F5A36EE222A67B")
          SSLInputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.599 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "3D6B249A8B3579A7B55DB6D76A11D9FE")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_15086500 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551299769 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_551299769;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.599 -0400", hash_original_method = "DB2A9854396CBE443BE0852C07C28BD2", hash_generated_method = "7DDBAB713C7252A0211E81437D9965B2")
        @Override
        public int read(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                int var42EB93D3EE42AF5A70572DC5EFC4EDBC_1601000461 = (NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout()));
            } 
            addTaint(buf[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514759275 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1514759275;
            
            
            
                
                
                
                    
                
                
                        
            
        }

        
    }


    
    private class SSLOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.600 -0400", hash_original_method = "1E1541DFFE880DA1B7719D7E370B4D89", hash_generated_method = "2CF7E8309B0292C00087EB8F19D9BB26")
          SSLOutputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.601 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "7C9196718755845369790934EC3B8FE0")
        @Override
        public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
            addTaint(oneByte);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.603 -0400", hash_original_method = "D98A6CBE7C5513FE6A9CDBBB263207DD", hash_generated_method = "D43E07DD85D61F7BF31E3253688840A3")
        @Override
        public void write(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount);
            } 
            addTaint(buf[0]);
            addTaint(offset);
            addTaint(byteCount);
            
            
            
                
                
                
                    
                
                
                        
            
        }

        
    }


    
}

