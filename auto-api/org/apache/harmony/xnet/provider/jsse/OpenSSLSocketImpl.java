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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "7A26561346F073823CD60CDE206B36E2", hash_generated_field = "748A6049ACB01D98F85E21799F2EB11A")

    private int sslNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "A2A551A6458A8DE22446CC76D639A9E9", hash_generated_field = "2E5ED6972CC94407ADA802F01B2A91D3")

    private InputStream is;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "DD302F94682DBD2A114D63B0433602E0", hash_generated_field = "BFEC39E15FADDFA148ED8D3CE22EABA4")

    private OutputStream os;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "85E5D87B8B4A646833A43466B8645F5F", hash_generated_field = "189B6C7082FD299E46A28A59CD6C8F15")

    private Object handshakeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "0EBBDB2C6AB02F595FD6B8EE0165CE90", hash_generated_field = "0BDEB8ABE1932E75D75EE50EF5D56058")

    private Object readLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "5A9206244ED4B85CC1847D97E427123C", hash_generated_field = "04E97E6709F6F21DAA184AB6BB309FED")

    private Object writeLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "D3BEC3280BC0116C55BDEA33933A255E")

    private SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "BFF5830B7B00AB1C369E1E6FB3114CB0", hash_generated_field = "85F0E10109EFE4B8F58BC1776613705B")

    private String[] enabledProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "7AD17E190B7E5C8B7D224A9E272C550F")

    private String[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "0D8BDE82F30FA6C13A6F9BC50134508D", hash_generated_field = "3ED2FE1E30316545E9184B9907A7D6E3")

    private String[] enabledCompressionMethods;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "8F6035B29AA347B1267CEF3F327C2192", hash_generated_field = "A2F538231066932F5915EF28021541F1")

    private boolean useSessionTickets;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "0897ACF49C7C1EA9F76EFE59187AA046", hash_generated_field = "A7530665071F24FF1A9052578197759B")

    private String hostname;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "3893D7DE6BC507FB95AA82B03DBC44D7", hash_generated_field = "368A75AAABC6FBEB91272F5EA8465622")

    private OpenSSLSessionImpl sslSession;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "61F2529360AEC54F5DC9804B842CF3FA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private Socket socket;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "C95C0A64A513F1206A9EEEDFADED27FF", hash_generated_field = "AEB05A26C586581FD503591C56751340")

    private boolean autoClose;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "676DF800F5B7B514B01D50F354ACAFF6", hash_generated_field = "5B583CD79FBEC6280A38CE8E3A8DAA8A")

    private boolean handshakeStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "595005CA65C71040ACDA0D73FCAD2D32", hash_generated_field = "2D23168D66D17A93982E63C6133878AC")

    private boolean handshakeCompleted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "8D4C6D611B20EB0D2D4A15AE21386B82", hash_generated_field = "D9040C82E2DDED5191E6D7AE598F1DB8")

    private int timeoutMilliseconds = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "AE8D1946443647A8D684B091A86F1F48", hash_generated_field = "924BC0B5E41E0BD4B8C4C178AB494DA8")

    private int handshakeTimeoutMilliseconds = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "ADCF75E4E8815498EC1B7BB88537B5B6", hash_generated_field = "6FB2C77C604FE1268BFA3B979F3F3054")

    private String wrappedHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.496 -0400", hash_original_field = "F29AFDAD6C88B29B62279111343E9F96", hash_generated_field = "B7D8F64F41E806C80BDECFDD8FA68EFA")

    private int wrappedPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.497 -0400", hash_original_method = "1E0B4679EC7761107339F1A8D3A55F9F", hash_generated_method = "DF6A02121AD8816ADB3A8B8F5A8058AF")
    protected  OpenSSLSocketImpl(SSLParametersImpl sslParameters) throws IOException {
        this.socket = this;
        init(sslParameters);
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.497 -0400", hash_original_method = "7190C9F3617EA957D6C6C5547D61E7DA", hash_generated_method = "971D7397124651619FCECFF99B5BE04A")
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
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters, enabledProtocols, enabledCipherSuites, enabledCompressionMethods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.497 -0400", hash_original_method = "8EFC55677F513E24A665A5B10C8DD781", hash_generated_method = "7D8F823CA102F891371A534B41192A46")
    protected  OpenSSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        this.socket = this;
        init(sslParameters);
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.507 -0400", hash_original_method = "3B4C2FC0F73F444026E804CAAB2D3AA5", hash_generated_method = "DAD6E8973B6E1A3A40FC55411B4A8839")
    protected  OpenSSLSocketImpl(InetAddress address, int port, SSLParametersImpl sslParameters) throws IOException {
        super(address, port);
        this.socket = this;
        init(sslParameters);
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.507 -0400", hash_original_method = "3EB3C6E00E78F272783CA82B1518096D", hash_generated_method = "727E6606B6D469FB3B96532202D84FBA")
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
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.508 -0400", hash_original_method = "BF524C761FC1FBF2285E42FB758995EF", hash_generated_method = "0AE5725DA8DDFE4BA51FAF6016D5D844")
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
        // ---------- Original Method ----------
        //this.socket = this;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.509 -0400", hash_original_method = "E8402FE2BCEFBC2883099C44FF33F005", hash_generated_method = "3FEC15D875FCBF1D6FD52A4DE58DA996")
    protected  OpenSSLSocketImpl(Socket socket, String host, int port,
            boolean autoClose, SSLParametersImpl sslParameters) throws IOException {
        this.socket = socket;
        this.wrappedHost = host;
        this.wrappedPort = port;
        this.autoClose = autoClose;
        init(sslParameters);
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //this.socket = socket;
        //this.wrappedHost = host;
        //this.wrappedPort = port;
        //this.autoClose = autoClose;
        //init(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.509 -0400", hash_original_method = "33D1B746D20986D17267826F3151AB68", hash_generated_method = "A1286579E3F565D5CA6F2D976D38078D")
    private void init(SSLParametersImpl sslParameters) throws IOException {
        init(sslParameters,
             NativeCrypto.getSupportedProtocols(),
             NativeCrypto.getDefaultCipherSuites(),
             NativeCrypto.getDefaultCompressionMethods());
        addTaint(sslParameters.getTaint());
        // ---------- Original Method ----------
        //init(sslParameters,
             //NativeCrypto.getSupportedProtocols(),
             //NativeCrypto.getDefaultCipherSuites(),
             //NativeCrypto.getDefaultCompressionMethods());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.519 -0400", hash_original_method = "28ECC4752D5D2759E8F75423B7F304E1", hash_generated_method = "85DC27B70EC2B768C744122A7207BA7A")
    private void init(SSLParametersImpl sslParameters,
                      String[] enabledProtocols,
                      String[] enabledCipherSuites,
                      String[] enabledCompressionMethods) throws IOException {
        this.sslParameters = sslParameters;
        this.enabledProtocols = enabledProtocols;
        this.enabledCipherSuites = enabledCipherSuites;
        this.enabledCompressionMethods = enabledCompressionMethods;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
        //this.enabledProtocols = enabledProtocols;
        //this.enabledCipherSuites = enabledCipherSuites;
        //this.enabledCompressionMethods = enabledCompressionMethods;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.561 -0400", hash_original_method = "DB9C757E33C47645F1FC9AEA51E10B24", hash_generated_method = "424D61F65E706C6FF340AE5F16EE5129")
    private OpenSSLSessionImpl getCachedClientSession(ClientSessionContext sessionContext) {
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_1106468854 = null; //Variable for return #1
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_247370647 = null; //Variable for return #2
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_853767824 = null; //Variable for return #3
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_739199431 = null; //Variable for return #4
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_907960456 = null; //Variable for return #5
        OpenSSLSessionImpl varB4EAC82CA7396A68D541C85D26508E83_440907032 = null; //Variable for return #6
        {
            boolean varDE450B6D8CDA8C5A5EBF790451254751_1207208226 = (super.getInetAddress() == null ||
                super.getInetAddress().getHostAddress() == null ||
                super.getInetAddress().getHostName() == null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1106468854 = null;
            } //End block
        } //End collapsed parenthetic
        OpenSSLSessionImpl session;
        session = (OpenSSLSessionImpl) sessionContext.getSession(
                super.getInetAddress().getHostName(),
                super.getPort());
        {
            varB4EAC82CA7396A68D541C85D26508E83_247370647 = null;
        } //End block
        String protocol;
        protocol = session.getProtocol();
        boolean protocolFound;
        protocolFound = false;
        {
            String enabledProtocol = enabledProtocols[0];
            {
                {
                    boolean varB7CDD2851C57BCE06B93A6CED39A5E38_880458754 = (protocol.equals(enabledProtocol));
                    {
                        protocolFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_853767824 = null;
        } //End block
        String cipherSuite;
        cipherSuite = session.getCipherSuite();
        boolean cipherSuiteFound;
        cipherSuiteFound = false;
        {
            String enabledCipherSuite = enabledCipherSuites[0];
            {
                {
                    boolean var0A90D4178EA81E08B8356065F33DB016_1407510311 = (cipherSuite.equals(enabledCipherSuite));
                    {
                        cipherSuiteFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_739199431 = null;
        } //End block
        String compressionMethod;
        compressionMethod = session.getCompressionMethod();
        boolean compressionMethodFound;
        compressionMethodFound = false;
        {
            String enabledCompressionMethod = enabledCompressionMethods[0];
            {
                {
                    boolean varDF0B1461F4631C44245857F1697AFCF1_2092992388 = (compressionMethod.equals(enabledCompressionMethod));
                    {
                        compressionMethodFound = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_907960456 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_440907032 = session;
        addTaint(sessionContext.getTaint());
        OpenSSLSessionImpl varA7E53CE21691AB073D9660D615818899_1823768128; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_1106468854;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_247370647;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_853767824;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_739199431;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_907960456;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1823768128 = varB4EAC82CA7396A68D541C85D26508E83_440907032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1823768128.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1823768128;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.564 -0400", hash_original_method = "6F34DF1209370488AD4C31DC9A9003CA", hash_generated_method = "875A1614B9E32119678388031424EBE3")
    @Override
    public void startHandshake() throws IOException {
        startHandshake(true);
        // ---------- Original Method ----------
        //startHandshake(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.564 -0400", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "5908A262EEAA392BE8B6D04E58E27949")
    private void checkOpen() throws SocketException {
        {
            boolean varF463C9E3EC09CF3DDC0E11AE27E5A7FD_321890066 = (isClosed());
            {
                if (DroidSafeAndroidRuntime.control) throw new SocketException("Socket is closed");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (isClosed()) {
            //throw new SocketException("Socket is closed");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.455 -0400", hash_original_method = "7D68DA7254C24BFF3C6F787A75CF4E46", hash_generated_method = "B5917E883CA69D410F749AEB89C0941A")
    public synchronized void startHandshake(boolean full) throws IOException {
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
                    Iterator<String> var632AFCA10F9C76A9615C3FAFC76C51B2_942093446 = (enabledCipherSuites).iterator();
                    var632AFCA10F9C76A9615C3FAFC76C51B2_942093446.hasNext();
                    String enabledCipherSuite = var632AFCA10F9C76A9615C3FAFC76C51B2_942093446.next();
                    {
                        {
                            boolean varB970A4D1689EFCBF0C591729604E2F5C_1003833389 = (enabledCipherSuite.equals(NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV));
                        } //End collapsed parenthetic
                        String keyType;
                        keyType = CipherSuite.getByName(enabledCipherSuite).getServerKeyType();
                        {
                            keyTypes.add(keyType);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                {
                    Iterator<String> var594EC992A710F64B1906006B59DD5293_1690103806 = (keyTypes).iterator();
                    var594EC992A710F64B1906006B59DD5293_1690103806.hasNext();
                    String keyType = var594EC992A710F64B1906006B59DD5293_1690103806.next();
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
                    boolean varDC6B96A2EBF53EC5C7FA36AF2244C1B9_366580649 = (sslParameters.getNeedClientAuth());
                    {
                        NativeCrypto.SSL_set_verify(sslNativePointer,
                                                NativeCrypto.SSL_VERIFY_PEER
                                                | NativeCrypto.SSL_VERIFY_FAIL_IF_NO_PEER_CERT);
                        certRequested = true;
                    } //End block
                    {
                        boolean varBA129A971A32EF54D8E824D21B4687C7_751029178 = (sslParameters.getWantClientAuth());
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
        addTaint(full);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.463 -0400", hash_original_method = "447042B984B2D213A231B86095B05FCC", hash_generated_method = "FBC34C32DDC45330CFD94E38C56DBE7E")
    private void setCertificate(String alias) throws CertificateEncodingException, SSLException {
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
        addTaint(alias.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.464 -0400", hash_original_method = "4494930597AF8911ABFC977B28D550D9", hash_generated_method = "DEA6B848DA0AAB7988F3CFD81A76222B")
    @SuppressWarnings("unused")
    public void clientCertificateRequested(byte[] keyTypeBytes, byte[][] asn1DerEncodedPrincipals) throws CertificateEncodingException, SSLException {
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
        addTaint(keyTypeBytes[0]);
        addTaint(asn1DerEncodedPrincipals[0][0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.477 -0400", hash_original_method = "4135185E706706A43228536D20F5AD94", hash_generated_method = "57A4B116248545511413C4575F5BA8A5")
    @SuppressWarnings("unused")
    public void handshakeCompleted() {
        handshakeCompleted = true;
        sslSession.resetId();
        AbstractSessionContext sessionContext;
        boolean var90A449D6F1E51FE89C1444A2ABB20FCB_1500215135 = ((sslParameters.getUseClientMode()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.512 -0400", hash_original_method = "7C2534895E7335878B6E22FB6F2D87D0", hash_generated_method = "A75F5CFC9ABC21B2127441CE5148FAE2")
    private void notifyHandshakeCompletedListeners() {
        {
            boolean varEA141DED028EB95B14754CBD79C46500_1429571982 = (listeners != null && !listeners.isEmpty());
            {
                HandshakeCompletedEvent event;
                event = new HandshakeCompletedEvent(this, sslSession);
                {
                    Iterator<HandshakeCompletedListener> varFA1A76B379D1DD4A9E969658BDCFB86E_905642420 = (listeners).iterator();
                    varFA1A76B379D1DD4A9E969658BDCFB86E_905642420.hasNext();
                    HandshakeCompletedListener listener = varFA1A76B379D1DD4A9E969658BDCFB86E_905642420.next();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.513 -0400", hash_original_method = "ED84B1AF9EB80DCCE7D2C3DBC193F549", hash_generated_method = "3CFCBA35986B12C89469B6DC71298860")
    @SuppressWarnings("unused")
    @Override
    public void verifyCertificateChain(byte[][] bytes, String authMethod) throws CertificateException {
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
        addTaint(bytes[0][0]);
        addTaint(authMethod.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.514 -0400", hash_original_method = "E61C85BF5C63F4E04D0D50BF3BBE2593", hash_generated_method = "FB5476E2EC6B57A6FB47BAB46BECB671")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_108681498 = null; //Variable for return #1
        checkOpen();
        {
            {
                is = new SSLInputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_108681498 = is;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_108681498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108681498;
        // ---------- Original Method ----------
        //checkOpen();
        //synchronized (this) {
            //if (is == null) {
                //is = new SSLInputStream();
            //}
            //return is;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.515 -0400", hash_original_method = "5EE71E3DCC35A33F08AD90BC3313950F", hash_generated_method = "3B1EE43A33AE7FEE8A0F6067164E28B9")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_199685194 = null; //Variable for return #1
        checkOpen();
        {
            {
                os = new SSLOutputStream();
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_199685194 = os;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_199685194.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_199685194;
        // ---------- Original Method ----------
        //checkOpen();
        //synchronized (this) {
            //if (os == null) {
                //os = new SSLOutputStream();
            //}
            //return os;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.533 -0400", hash_original_method = "E137442CFB021C112EB3F3EAC9C4FE47", hash_generated_method = "28E732E535C25C6D16764C9638AAE613")
    @Override
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1197275477 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_262130561 = null; //Variable for return #2
        {
            try 
            {
                startHandshake(true);
            } //End block
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1197275477 = SSLSessionImpl.NULL_SESSION;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_262130561 = sslSession;
        SSLSession varA7E53CE21691AB073D9660D615818899_1055405310; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1055405310 = varB4EAC82CA7396A68D541C85D26508E83_1197275477;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1055405310 = varB4EAC82CA7396A68D541C85D26508E83_262130561;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1055405310.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1055405310;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.534 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "7287E9F6B751EA96DE97D34C6E28B2B8")
    @Override
    public void addHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            listeners = new ArrayList<HandshakeCompletedListener>();
        } //End block
        listeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (listener == null) {
            //throw new IllegalArgumentException("Provided listener is null");
        //}
        //if (listeners == null) {
            //listeners = new ArrayList<HandshakeCompletedListener>();
        //}
        //listeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.538 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "89993E44B2D41CB568C06F3CC3EB81D5")
    @Override
    public void removeHandshakeCompletedListener(
            HandshakeCompletedListener listener) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Provided listener is null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
        } //End block
        {
            boolean var170C22586EF26335003A8446D4D19EBD_619153756 = (!listeners.remove(listener));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
            } //End block
        } //End collapsed parenthetic
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.546 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "BDEE5199EBB4C5EBE2D1C57FED74F504")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_344321501 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_926056175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_926056175;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.547 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.547 -0400", hash_original_method = "1B8AAFC0DA0BD632205C9BB94F36BE40", hash_generated_method = "AC64B2AC57B3158ABD38A494F0BFC0BB")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_146077097 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_146077097 = NativeCrypto.getSupportedCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_146077097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_146077097;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.551 -0400", hash_original_method = "5CCACD4A046B80B9464615B5EFBE522F", hash_generated_method = "B4D34518344EB34FD41FAAAA3A18E3FA")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_937258318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_937258318 = enabledCipherSuites.clone();
        varB4EAC82CA7396A68D541C85D26508E83_937258318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_937258318;
        // ---------- Original Method ----------
        //return enabledCipherSuites.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.553 -0400", hash_original_method = "A8F29A0117C2056BB4F12EE1D48F5595", hash_generated_method = "3FB2F096A8758F371B7BAF38AC6E6A62")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //enabledCipherSuites = NativeCrypto.checkEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.557 -0400", hash_original_method = "B10F1AAC80A139AD997D0D8B0338DD89", hash_generated_method = "21EFB61CCB52334614385141F235D8B0")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_380422336 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_380422336 = NativeCrypto.getSupportedProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_380422336.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380422336;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.561 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "F727F320875111F19B91D47C7B1DD245")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_7151990 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_7151990 = enabledProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_7151990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_7151990;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.571 -0400", hash_original_method = "4F25266A0ABB18E1CEC5E2893BCF6C12", hash_generated_method = "3A7DB44E7B143D29605895C639B518A6")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //enabledProtocols = NativeCrypto.checkEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.572 -0400", hash_original_method = "375DD2648264EE3CAE4788D31A756EC5", hash_generated_method = "FCAE942F533CC1FC81E54B4FB104F9E4")
    public String[] getSupportedCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_75902819 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_75902819 = NativeCrypto.getSupportedCompressionMethods();
        varB4EAC82CA7396A68D541C85D26508E83_75902819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_75902819;
        // ---------- Original Method ----------
        //return NativeCrypto.getSupportedCompressionMethods();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.583 -0400", hash_original_method = "1BCE54E87A889265E8FA0E0B8689F62E", hash_generated_method = "0AB1431E1DF4966CC18D68947E3446C0")
    public String[] getEnabledCompressionMethods() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_496336855 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_496336855 = enabledCompressionMethods.clone();
        varB4EAC82CA7396A68D541C85D26508E83_496336855.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_496336855;
        // ---------- Original Method ----------
        //return enabledCompressionMethods.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.584 -0400", hash_original_method = "8EA4CA69B5E5586515E70C8BB15F1DC8", hash_generated_method = "F6E8AD11719A044F802E33A113589650")
    public void setEnabledCompressionMethods(String[] methods) {
        enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
        // ---------- Original Method ----------
        //enabledCompressionMethods = NativeCrypto.checkEnabledCompressionMethods(methods);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.584 -0400", hash_original_method = "1BC96C488FBD7622E9D1B33430C794F4", hash_generated_method = "9069498A56026D20FD8A09727B7034AD")
    public void setUseSessionTickets(boolean useSessionTickets) {
        this.useSessionTickets = useSessionTickets;
        // ---------- Original Method ----------
        //this.useSessionTickets = useSessionTickets;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.584 -0400", hash_original_method = "A3C6DFBE0DD33FFBDB883F2D56D0E9E8", hash_generated_method = "7F6DB2623DC2C5039EF0AE7949EDDAF7")
    public void setHostname(String hostname) {
        this.hostname = hostname;
        // ---------- Original Method ----------
        //this.hostname = hostname;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.585 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "604DDEC82F92EC4B6A9FFDACDDBD30DB")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1655975096 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1799106820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1799106820;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.585 -0400", hash_original_method = "796A366B3F70011E31FF500388066E2F", hash_generated_method = "7E7008FF9D8848F21E35A0053ED6BD48")
    @Override
    public void setUseClientMode(boolean mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Could not change the mode after the initial handshake has begun.");
        } //End block
        sslParameters.setUseClientMode(mode);
        addTaint(mode);
        // ---------- Original Method ----------
        //if (handshakeStarted) {
            //throw new IllegalArgumentException(
                    //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.611 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "E05AF7BD499F3B66030E7721FEF5F955")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_2636310 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1333822322 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1333822322;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.619 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "226C6FAE9F1938E46E4527CAC804E34D")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1665320501 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_539249489 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_539249489;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.619 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.620 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.620 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "352C1C0A002DF95EBF288C4FF5A377A5")
    @Override
    public void sendUrgentData(int data) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Method sendUrgentData() is not supported.");
        addTaint(data);
        // ---------- Original Method ----------
        //throw new SocketException("Method sendUrgentData() is not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.620 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "03B4E46C1F8C665C265246E76BB39911")
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
        addTaint(on);
        // ---------- Original Method ----------
        //throw new SocketException("Methods sendUrgentData, setOOBInline are not supported.");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.625 -0400", hash_original_method = "E02183BB387F9960402CB70797EE289E", hash_generated_method = "B02004F7A366D969474A8D629373A474")
    @Override
    public void setSoTimeout(int timeoutMilliseconds) throws SocketException {
        super.setSoTimeout(timeoutMilliseconds);
        this.timeoutMilliseconds = timeoutMilliseconds;
        // ---------- Original Method ----------
        //super.setSoTimeout(timeoutMilliseconds);
        //this.timeoutMilliseconds = timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.625 -0400", hash_original_method = "5DC72E2D363A272A051BD7C43DA762A2", hash_generated_method = "5D3FAEDB2D4DF39C6485A60572D09111")
    @Override
    public int getSoTimeout() throws SocketException {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408209110 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_408209110;
        // ---------- Original Method ----------
        //return timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.625 -0400", hash_original_method = "CE465C7A533FEAB3164F103F1DBDF364", hash_generated_method = "6671F89B44C6C2B43F432B4E79ACC3F2")
    public void setHandshakeTimeout(int timeoutMilliseconds) throws SocketException {
        this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
        // ---------- Original Method ----------
        //this.handshakeTimeoutMilliseconds = timeoutMilliseconds;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.631 -0400", hash_original_method = "B24ED3F34169856B1F2602ADA3894B40", hash_generated_method = "F5EFD7EE10F636F7FE7FFE6C40CE297B")
    @Override
    public void close() throws IOException {
        {
            {
                handshakeStarted = true;
                {
                    free();
                    {
                        boolean varD005D44E966655D4EF5111258788BDE6_1082677001 = (socket != this);
                        {
                            {
                                boolean var4DF33A3328473828362786F341A256EE_1814472699 = (autoClose && !socket.isClosed());
                                socket.close();
                            } //End collapsed parenthetic
                        } //End block
                        {
                            {
                                boolean varFFACBC82D9AF35C8BB47D8A0637A6062_1200319571 = (!super.isClosed());
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
                            boolean var9B1ACD52F4FCB38CE1E60CBDC1AAE3BC_2101077339 = (socket != this);
                            {
                                {
                                    boolean var3517699F99256E8181CD89A82659CE69_186723412 = (autoClose && !socket.isClosed());
                                    {
                                        socket.close();
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                            {
                                {
                                    boolean varE75AF6E6ED9346F3AD29B561C824DE81_96880140 = (!super.isClosed());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.642 -0400", hash_original_method = "0B5EFC2C593350712C0760AFE47F069D", hash_generated_method = "ECFAC03105594EE600B9228F2432EC31")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.643 -0400", hash_original_method = "48478F0D5C609BA19837DA284D888FF0", hash_generated_method = "882FADDE20E830A83BAA462AE46622BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.644 -0400", hash_original_method = "E6BCE3543B6D551909C5B870C6A9DC54", hash_generated_method = "9E4A19679FF499B95301191DF5069B38")
    @Override
    public FileDescriptor getFileDescriptor$() {
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_809440339 = null; //Variable for return #1
        FileDescriptor varB4EAC82CA7396A68D541C85D26508E83_861081060 = null; //Variable for return #2
        {
            boolean varC17DE78B0F5B654D1C3BAA61447DB932_31197366 = (socket == this);
            {
                varB4EAC82CA7396A68D541C85D26508E83_809440339 = super.getFileDescriptor$();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_861081060 = socket.getFileDescriptor$();
            } //End block
        } //End collapsed parenthetic
        FileDescriptor varA7E53CE21691AB073D9660D615818899_1465963575; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1465963575 = varB4EAC82CA7396A68D541C85D26508E83_809440339;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1465963575 = varB4EAC82CA7396A68D541C85D26508E83_861081060;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1465963575.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1465963575;
        // ---------- Original Method ----------
        //if (socket == this) {
            //return super.getFileDescriptor$();
        //} else {
            //return socket.getFileDescriptor$();
        //}
    }

    
    private class SSLInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.644 -0400", hash_original_method = "B153503C58DDB9DC7588696F0617BD77", hash_generated_method = "542D2766BEEB467DA4F5A36EE222A67B")
          SSLInputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            // ---------- Original Method ----------
            //OpenSSLSocketImpl.this.startHandshake(false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.645 -0400", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "96DE17DA2F15896349A0409DDB8EC1B9")
        @Override
        public int read() throws IOException {
            int var27157AD7296922C5499EDCD13E8A2ED8_1882057333 = (Streams.readSingleByte(this));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026039438 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1026039438;
            // ---------- Original Method ----------
            //return Streams.readSingleByte(this);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.653 -0400", hash_original_method = "DB2A9854396CBE443BE0852C07C28BD2", hash_generated_method = "41A73BEA70D16FAB177B21C3DE4A18C5")
        @Override
        public int read(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                int var42EB93D3EE42AF5A70572DC5EFC4EDBC_1778155397 = (NativeCrypto.SSL_read(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount, getSoTimeout()));
            } //End block
            addTaint(buf[0]);
            addTaint(offset);
            addTaint(byteCount);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645615832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1645615832;
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.653 -0400", hash_original_method = "1E1541DFFE880DA1B7719D7E370B4D89", hash_generated_method = "2CF7E8309B0292C00087EB8F19D9BB26")
          SSLOutputStream() throws IOException {
            OpenSSLSocketImpl.this.startHandshake(false);
            // ---------- Original Method ----------
            //OpenSSLSocketImpl.this.startHandshake(false);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.657 -0400", hash_original_method = "C7F824EB5C9CE82C3E815BE1E94821BC", hash_generated_method = "7C9196718755845369790934EC3B8FE0")
        @Override
        public void write(int oneByte) throws IOException {
            Streams.writeSingleByte(this, oneByte);
            addTaint(oneByte);
            // ---------- Original Method ----------
            //Streams.writeSingleByte(this, oneByte);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.659 -0400", hash_original_method = "D98A6CBE7C5513FE6A9CDBBB263207DD", hash_generated_method = "D43E07DD85D61F7BF31E3253688840A3")
        @Override
        public void write(byte[] buf, int offset, int byteCount) throws IOException {
            BlockGuard.getThreadPolicy().onNetwork();
            {
                checkOpen();
                Arrays.checkOffsetAndCount(buf.length, offset, byteCount);
                NativeCrypto.SSL_write(sslNativePointer, socket.getFileDescriptor$(),
                        OpenSSLSocketImpl.this, buf, offset, byteCount);
            } //End block
            addTaint(buf[0]);
            addTaint(offset);
            addTaint(byteCount);
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

