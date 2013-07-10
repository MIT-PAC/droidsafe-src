package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

public class SSLSocketImpl extends SSLSocket {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.025 -0400", hash_original_field = "3AE81331685336BDF4905577358403FE", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "B833D39B605EBB2737927AB5B4154643", hash_generated_field = "525094C3FC63278C6116C6DEB230FC51")

    private SSLSocketInputStream appDataIS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "D95015CADC11FD2EE735FEB5B8CFBC64", hash_generated_field = "F04547F05FBC3550B4832B6EFAD5429B")

    private SSLSocketOutputStream appDataOS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "2B2C58BD2F67680893D7D8171D248B07", hash_generated_field = "45E3FC29C212ED74F873A281D50900AB")

    private boolean socket_was_closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "A43C1B0AA53A0C908810C06AB1FF3967", hash_generated_field = "D316EEE6844FE498763EB8295772C4A2")

    protected InputStream input;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "78E6221F6393D1356681DB398F14CE6D", hash_generated_field = "0E6723CD0F1F5210EC010C59DA7A47E7")

    protected OutputStream output;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "9F99697C78E088CB04E67AFD7A9D1068", hash_generated_field = "18AE5B2EA1E4D2608E5F816AEC3235B3")

    private ArrayList<HandshakeCompletedListener> listeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_field = "54B84D2B1AE03DCCAE40C4858357B92A", hash_generated_field = "0327D000C0AB01CB97996B4D95743A26")

    private Logger.Stream logger = Logger.getStream("socket");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_method = "7B6D79A24FC469186EEF1935CCE0FAAE", hash_generated_method = "76D8E06FA8235152D346BA475221EC7E")
    protected  SSLSocketImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.026 -0400", hash_original_method = "B90B14697CA53EAAAF818AFF9DD06A34", hash_generated_method = "832BCF3A4866A59E15292F0E42A13131")
    protected  SSLSocketImpl(String host, int port, SSLParametersImpl sslParameters) throws IOException, UnknownHostException {
        super(host, port);
        this.sslParameters = sslParameters;
        init();
        addTaint(host.getTaint());
        addTaint(port);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.027 -0400", hash_original_method = "A894226ED2FD2304A12A4E08266BE71A", hash_generated_method = "768C1021857E670786D51083C7F88F96")
    protected  SSLSocketImpl(String host, int port,
            InetAddress localHost, int localPort,
            SSLParametersImpl sslParameters) throws IOException,
            UnknownHostException {
        super(host, port, localHost, localPort);
        this.sslParameters = sslParameters;
        init();
        addTaint(host.getTaint());
        addTaint(port);
        addTaint(localHost.getTaint());
        addTaint(localPort);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.027 -0400", hash_original_method = "21D48E905F577E64713F2C7CA9B1B030", hash_generated_method = "EC2A0AEADAC7DA5B2E08566C2C363EDC")
    protected  SSLSocketImpl(InetAddress host, int port,
            SSLParametersImpl sslParameters) throws IOException {
        super(host, port);
        this.sslParameters = sslParameters;
        init();
        addTaint(host.getTaint());
        addTaint(port);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.027 -0400", hash_original_method = "6C5671217798C1BD7239CC8FEB7B883B", hash_generated_method = "CA0FA69F45AC52A0E973D87FB1A3E121")
    protected  SSLSocketImpl(InetAddress address, int port,
            InetAddress localAddress, int localPort,
            SSLParametersImpl sslParameters) throws IOException {
        super(address, port, localAddress, localPort);
        this.sslParameters = sslParameters;
        init();
        addTaint(address.getTaint());
        addTaint(port);
        addTaint(localAddress.getTaint());
        addTaint(localPort);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.028 -0400", hash_original_method = "FD845B5AAD012D6985E0ADCD6A0F1286", hash_generated_method = "C7053FCD0C2CAC7A8ED711746999121C")
    protected void init() throws IOException {
        initTransportLayer();
        appDataIS = new SSLSocketInputStream(this);
        appDataOS = new SSLSocketOutputStream(this);
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.028 -0400", hash_original_method = "F1A82616FFDC8899DB87D416AB14644B", hash_generated_method = "A4E325529E24EA029F3DA105A3FC705E")
    protected void initTransportLayer() throws IOException {
        input = super.getInputStream();
        output = super.getOutputStream();
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.028 -0400", hash_original_method = "651677798FC4CE70FB09611DD37A5D23", hash_generated_method = "DC71033D6F8C0E546CC132184F0576C1")
    protected void closeTransportLayer() throws IOException {
        super.close();
        {
            input.close();
            output.close();
        } 
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.029 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "8562C6209F5F44D12CCCE4A6938CA658")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1010165124 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1010165124 = CipherSuite.getSupportedCipherSuiteNames();
        varB4EAC82CA7396A68D541C85D26508E83_1010165124.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1010165124;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.030 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "C877B80C2EB05BAF36AD2AF489BD6DD5")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_221048206 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_221048206 = sslParameters.getEnabledCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_221048206.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_221048206;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.030 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "7F545A6EF3038CFCC5D5B349DF2D820E")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
        addTaint(suites[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.031 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "9AF4FB66B70062166B6123971C60F354")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1188204641 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1188204641 = ProtocolVersion.supportedProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1188204641.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1188204641;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.031 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "BE07255A1035D0D0557CAE56240BEEB8")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1737025488 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1737025488 = sslParameters.getEnabledProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_1737025488.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1737025488;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.031 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "24B3390D4A5DB4328E68855FDA4E4FA9")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
        addTaint(protocols[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.032 -0400", hash_original_method = "3BB959BD0875F4D150E69C54372A8DCB", hash_generated_method = "56BF5F0CF97BA1C2A298465C12ACB7EC")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.032 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "06177D9087AFDC3DA2122DC60EEED908")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_485640022 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_754934239 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_754934239;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.032 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.032 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "0579DEE14066F0D631D41ED59B6CB7A6")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1855551760 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1280799362 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1280799362;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.033 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.033 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "3FD0A385B8948B58942C1EE7FB96BA4C")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1751754603 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1756260895 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1756260895;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.033 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.033 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "33709A54A96D9490DAF0B6CFA071C86D")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_2066983118 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1968306236 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1968306236;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.034 -0400", hash_original_method = "8713059613609B55626747E74A63D7AE", hash_generated_method = "1DDE4003021DC76AEDE27BD278D24FA6")
    @Override
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_257444082 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_2132294283 = null; 
        {
            try 
            {
                startHandshake();
            } 
            catch (IOException e)
            {
                varB4EAC82CA7396A68D541C85D26508E83_257444082 = SSLSessionImpl.NULL_SESSION;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2132294283 = session;
        SSLSession varA7E53CE21691AB073D9660D615818899_929489850; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_929489850 = varB4EAC82CA7396A68D541C85D26508E83_257444082;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_929489850 = varB4EAC82CA7396A68D541C85D26508E83_2132294283;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_929489850.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_929489850;
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.034 -0400", hash_original_method = "F46B9A73766B8D71CEE8B005CFE82615", hash_generated_method = "7287E9F6B751EA96DE97D34C6E28B2B8")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.034 -0400", hash_original_method = "AD8204C7E0D7DFC602B3A996AAF9AC40", hash_generated_method = "DF74374818626FDD8DF05F290A98CED4")
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
            boolean var170C22586EF26335003A8446D4D19EBD_672194189 = (!listeners.remove(listener));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                    "Provided listener is not registered");
            } 
        } 
        addTaint(listener.getTaint());
        
        
            
        
        
            
                    
        
        
            
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.035 -0400", hash_original_method = "765B8FA015660A1850228BA85BA4D2EA", hash_generated_method = "85FE42113BB976229861AFC1D864EFB0")
    @Override
    public void startHandshake() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket is not connected.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } 
        {
            handshake_started = true;
            {
                boolean varA4B0927CB35036900884EAFB51864759_920317134 = (sslParameters.getUseClientMode());
                {
                    {
                        logger.println("SSLSocketImpl: CLIENT");
                    } 
                    handshakeProtocol = new ClientHandshakeImpl(this);
                } 
                {
                    {
                        logger.println("SSLSocketImpl: SERVER");
                    } 
                    handshakeProtocol = new ServerHandshakeImpl(this);
                } 
            } 
            alertProtocol = new AlertProtocol();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, new SSLStreamedInput(input),
                    appDataIS.dataPoint);
        } 
        {
            logger.println("SSLSocketImpl.startHandshake");
        } 
        handshakeProtocol.start();
        doHandshake();
        {
            logger.println("SSLSocketImpl.startHandshake: END");
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.035 -0400", hash_original_method = "9F4C1AA967218079AF1BF56E431987CC", hash_generated_method = "C024944E30F914EEADC67CBBC44D7EDE")
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream varB4EAC82CA7396A68D541C85D26508E83_959855309 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_959855309 = appDataIS;
        varB4EAC82CA7396A68D541C85D26508E83_959855309.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_959855309;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.036 -0400", hash_original_method = "E9E36047983E43D9B4652427AFC0EE2E", hash_generated_method = "2AFBFB805969D74450F45422A0F985DA")
    @Override
    public OutputStream getOutputStream() throws IOException {
        OutputStream varB4EAC82CA7396A68D541C85D26508E83_2145518422 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Socket has already been closed.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2145518422 = appDataOS;
        varB4EAC82CA7396A68D541C85D26508E83_2145518422.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2145518422;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.036 -0400", hash_original_method = "9C6F28F8DBD161E857A3A3894EC60A85", hash_generated_method = "6EC10A3B130B293E5D349A9B42C68E1C")
    @Override
    public void connect(SocketAddress endpoint) throws IOException {
        super.connect(endpoint);
        init();
        addTaint(endpoint.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.036 -0400", hash_original_method = "E1471735BF64AF2EDFAE20D8138E7876", hash_generated_method = "51825E8569446B1B3A8EC885253169CD")
    @Override
    public void connect(SocketAddress endpoint, int timeout) throws IOException {
        super.connect(endpoint, timeout);
        init();
        addTaint(endpoint.getTaint());
        addTaint(timeout);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.037 -0400", hash_original_method = "1C7BF244CDBA20FEDEE01D71D2117BF2", hash_generated_method = "83948190E2B7DC21DA321310F3C8C5F3")
    @Override
    public void close() throws IOException {
        {
            logger.println("SSLSocket.close "+socket_was_closed);
        } 
        {
            {
                alertProtocol.alert(AlertProtocol.WARNING,
                        AlertProtocol.CLOSE_NOTIFY);
                try 
                {
                    output.write(alertProtocol.wrap());
                } 
                catch (IOException ex)
                { }
                alertProtocol.setProcessed();
            } 
            shutdown();
            closeTransportLayer();
            socket_was_closed = true;
        } 
        
        
            
        
        
            
                
                        
                
                    
                
                
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.037 -0400", hash_original_method = "76A321423E9827230577FC78A6A38E86", hash_generated_method = "0145959A11707D1F1EC56AB488EADBC5")
    @Override
    public void sendUrgentData(int data) throws IOException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(
                "Method sendUrgentData() is not supported.");
        addTaint(data);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.037 -0400", hash_original_method = "274CE2EF30305C6385D88E550D3E79A6", hash_generated_method = "80AC7A3184C574479F25F1CCDE990B4A")
    @Override
    public void setOOBInline(boolean on) throws SocketException {
        if (DroidSafeAndroidRuntime.control) throw new SocketException(
                "Methods sendUrgentData, setOOBInline are not supported.");
        addTaint(on);
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.038 -0400", hash_original_method = "14168DA1E68DB132A0DACBB007EAD125", hash_generated_method = "DB8DA0A7842533BECD37164A9F914EE4")
    private void shutdown() {
        {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        } 
        socket_was_closed = true;
        
        
            
            
            
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.038 -0400", hash_original_method = "9F181DA813C5E35277B72423F9B4689F", hash_generated_method = "F5D2CCD9AF5F0BC7A5AD4545018BCEB8")
    protected void needAppData() throws IOException {
        {
            startHandshake();
        } 
        int type;
        {
            logger.println("SSLSocket.needAppData..");
        } 
        try 
        {
            {
                boolean varBAB188DECDCD630F3A5A2ED7BA622EDE_970701815 = (appDataIS.available() == 0);
                {
                    {
                        Object var4E37FE4E1A81B3E2D3D944D08C05A90F_2099140407 = (type = recordProtocol.unwrap());
                        
                        {
                            boolean var001467BA25544030FCEB8131CBC2B509_576855400 = (!handshakeProtocol.getStatus().equals(
                                SSLEngineResult.HandshakeStatus
                                .NOT_HANDSHAKING));
                            {
                                doHandshake();
                            } 
                        } 
                        
                        
                        processAlert();
                        
                        
                        {
                            logger.println(
                                    "SSLSocket.needAppData: got the data");
                        } 
                        
                        
                        reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                new SSLException("Unexpected message of type "
                                    + type + " has been got"));
                        
                    } 
                    {
                        boolean var2403FF9531EBD6D17D981C2B0AA326B1_1654319029 = (alertProtocol.hasAlert());
                        {
                            output.write(alertProtocol.wrap());
                            alertProtocol.setProcessed();
                        } 
                    } 
                    {
                        appDataIS.setEnd();
                    } 
                } 
            } 
        } 
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } 
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
        } 
        {
            logger.println("SSLSocket.needAppData: app data len: "
                    + appDataIS.available());
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.039 -0400", hash_original_method = "BD84CA3E70E7330B95C89C209BCE2D56", hash_generated_method = "3C8D2FF8649A5327CFD202CA6AE99C7A")
    protected void writeAppData(byte[] data, int offset, int len) throws IOException {
        {
            startHandshake();
        } 
        {
            logger.println("SSLSocket.writeAppData: " +
                    len + " " + SSLRecordProtocol.MAX_DATA_LENGTH);
        } 
        try 
        {
            {
                output.write(recordProtocol.wrap(ContentType.APPLICATION_DATA,
                            data, offset, len));
            } 
            {
                {
                    output.write(recordProtocol.wrap(
                                ContentType.APPLICATION_DATA, data, offset,
                                SSLRecordProtocol.MAX_DATA_LENGTH));
                    offset += SSLRecordProtocol.MAX_DATA_LENGTH;
                    len -= SSLRecordProtocol.MAX_DATA_LENGTH;
                } 
                {
                    output.write(
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                            data, offset, len));
                } 
            } 
        } 
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } 
        addTaint(data[0]);
        addTaint(offset);
        addTaint(len);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.042 -0400", hash_original_method = "B11A6FC07E880C42041746EA2FD3607A", hash_generated_method = "82F2AD0047731C1B7A465267C629EA9A")
    private void doHandshake() throws IOException {
        SSLEngineResult.HandshakeStatus status;
        int type;
        try 
        {
            {
                boolean var9D4BC6F5F4D389C19EE66E8CF9079905_498412913 = (!(status = handshakeProtocol.getStatus()).equals(
                        SSLEngineResult.HandshakeStatus.FINISHED));
                {
                    {
                        String s;
                                                {
                            boolean var1EBF21E1C1E39DB6188A852D126567A9_1412507347 = ((status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_WRAP)));
                            Object var0C0A9498B08BB4C776E5FCE33FD86930_983875294 = ((status.equals(
                                SSLEngineResult.HandshakeStatus.NEED_UNWRAP)));
                        } 
                        s = "NEED_UNWRAP";
                        s = "STATUS: OTHER!";
                        logger.println("SSLSocketImpl: HS status: "+s+" "+status);
                    } 
                    {
                        boolean varA794CBC77B92A94782D7BB220928EB7E_1440946796 = (status.equals(SSLEngineResult.HandshakeStatus.NEED_WRAP));
                        {
                            output.write(handshakeProtocol.wrap());
                        } 
                        {
                            boolean varA4C4CAA5C31A47911ED74B3CF47C970B_96207364 = (status.equals(
                            SSLEngineResult.HandshakeStatus.NEED_UNWRAP));
                            {
                                {
                                    Object varE51AE817664D86FB975B92A5A0C84BF6_1148576507 = (type = recordProtocol.unwrap());
                                    
                                    processAlert();
                                    
                                    
                                    reportFatalAlert(AlertProtocol.UNEXPECTED_MESSAGE,
                                    new SSLException(
                                        "Unexpected message of type "
                                        + type + " has been got"));
                                    
                                } 
                            } 
                            {
                                reportFatalAlert(AlertProtocol.INTERNAL_ERROR,
                        new SSLException(
                            "Handshake passed unexpected status: "+status));
                            } 
                        } 
                    } 
                    {
                        boolean var2403FF9531EBD6D17D981C2B0AA326B1_1710262213 = (alertProtocol.hasAlert());
                        {
                            output.write(alertProtocol.wrap());
                            alertProtocol.setProcessed();
                        } 
                    } 
                } 
            } 
        } 
        catch (EndOfSourceException e)
        {
            appDataIS.setEnd();
            if (DroidSafeAndroidRuntime.control) throw new IOException("Connection was closed");
        } 
        catch (AlertException e)
        {
            reportFatalAlert(e.getDescriptionCode(), e.getReason());
        } 
        session = recordProtocol.getSession();
        {
            HandshakeCompletedEvent event = new HandshakeCompletedEvent(this, session);
            int size = listeners.size();
            {
                int i = 0;
                {
                    listeners.get(i)
                    .handshakeCompleted(event);
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.043 -0400", hash_original_method = "1DCA961CD2F2BCD453967A97232AAFC6", hash_generated_method = "FCBD097D2700BB6B5D50B69E4C8FC310")
    private void processAlert() throws IOException {
        {
            boolean varBA114C5BBB68A4964579B65C6677BE54_1032058597 = (!alertProtocol.hasAlert());
        } 
        {
            boolean var4D069DF686D20BBCD8851C3E216CBC3C_959828464 = (alertProtocol.isFatalAlert());
            {
                alertProtocol.setProcessed();
                String description = "Fatal alert received "
                + alertProtocol.getAlertDescription();
                shutdown();
                if (DroidSafeAndroidRuntime.control) throw new SSLException(description);
            } 
        } 
        {
            logger.println("Warning alert received: "
                + alertProtocol.getAlertDescription());
        } 
        {
            Object var182D8DDEF223C10A221BDC17A7C27715_1715088626 = (alertProtocol.getDescriptionCode());
            
            alertProtocol.setProcessed();
            
            
            appDataIS.setEnd();
            
            
            close();
            
            
            alertProtocol.setProcessed();
            
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:38.044 -0400", hash_original_method = "716B8ABB2A0B730F9297C2C81BE3F29D", hash_generated_method = "E8ACAB617807FCE21DCEF5E1395E6368")
    private void reportFatalAlert(byte description_code,
            SSLException reason) throws IOException {
        alertProtocol.alert(AlertProtocol.FATAL, description_code);
        try 
        {
            output.write(alertProtocol.wrap());
        } 
        catch (IOException ex)
        { }
        alertProtocol.setProcessed();
        shutdown();
        if (DroidSafeAndroidRuntime.control) throw reason;
        addTaint(description_code);
        addTaint(reason.getTaint());
        
        
        
            
        
        
        
        
    }

    
}

