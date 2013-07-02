package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;

public class SSLEngineImpl extends SSLEngine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "7FBF54CF570CEAF60078F31954B8B4A0", hash_generated_field = "E654CE2FA30E1E8D898FBE3969CE5BA6")

    private boolean peer_mode_was_set = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "3AE81331685336BDF4905577358403FE", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "7DA2C545C56E344DA4BE6047ABB8C218", hash_generated_field = "537BCD10B20577D816D536B7EDFB0EE3")

    private boolean isInboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "264D68367E3ADE189F1F2A061B01173C", hash_generated_field = "21C2B63110EA37B8DBBBCF2E6ABCB0C5")

    private boolean isOutboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "AD2CAB884FC34185AFBAC0C583801A9B", hash_generated_field = "0F2AABB7E4332770B73BAB937514BD0D")

    private boolean close_notify_was_sent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "12846A5171C74544269F1A0D9D8DDDB1", hash_generated_field = "03323CA5EBF65F9CEB9F00CD95FE22FD")

    private boolean close_notify_was_received = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "A0EE8E97814BBF3228F9D01743B7562A", hash_generated_field = "B6CCCFBA31363DCB6CB3A490B6425D37")

    private boolean engine_was_closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "87C012AF7A1326EDFFF2C077A68FABDC", hash_generated_field = "DCE9A139F26465C1B64DE6866C9BACD4")

    private boolean engine_was_shutteddown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "A37720500B9EFE8F88BA25252953D413", hash_generated_field = "FC3A570B665E22F2CB948EFB2EF1D139")

    private SSLBufferedInput recProtIS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "78DC08180DEB6EFF54F49C04C6F3038B", hash_generated_field = "ED6BE62BE19D8AB0377A63F127B6719A")

    private SSLEngineAppData appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "3481789BD3617E3A5C841738CE452D88", hash_generated_field = "82EA68D6EF77B38A42F06A687812969F")

    private SSLEngineDataStream dataStream = new SSLEngineDataStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "FC88AA253F00F788C3DE05E8DA029A4E", hash_generated_field = "EE60D1DC1F6328AC4E5F20E6A2F3A8B3")

    private byte[] remaining_wrapped_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "204FA029E945DECB729F2176146804E2", hash_generated_field = "7736556E778E3455D57F720F57447D0D")

    private byte[] remaining_hsh_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_field = "220E7B611C947D4301416AD762474BA7", hash_generated_field = "45814449E3DD231F6EDFB081F6B3B7C8")

    private Logger.Stream logger = Logger.getStream("engine");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.776 -0400", hash_original_method = "1C2B310D768BCE8FE406784210BB6A4F", hash_generated_method = "449421F84A60DA11810D2E6AE603064A")
    protected  SSLEngineImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.777 -0400", hash_original_method = "399A1B6B7D3996FC39BEE7E87B5F152E", hash_generated_method = "32262A311B212709BEDE958FE392FCDC")
    protected  SSLEngineImpl(String host, int port, SSLParametersImpl sslParameters) {
        super(host, port);
        this.sslParameters = sslParameters;
        addTaint(host.getTaint());
        addTaint(port);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.777 -0400", hash_original_method = "C9E26C97B00AD59FF47E5A96B3855814", hash_generated_method = "860D0616887C0F657492F558DDA3FC81")
    @Override
    public void beginHandshake() throws SSLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLException("Engine has already been closed.");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Client/Server mode was not set");
        } 
        {
            handshake_started = true;
            {
                boolean varD3A3B98B1AB89C5D601DFF15338516F8_1834801249 = (getUseClientMode());
                {
                    handshakeProtocol = new ClientHandshakeImpl(this);
                } 
                {
                    handshakeProtocol = new ServerHandshakeImpl(this);
                } 
            } 
            appData = new SSLEngineAppData();
            alertProtocol = new AlertProtocol();
            recProtIS = new SSLBufferedInput();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, recProtIS, appData);
        } 
        handshakeProtocol.start();
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.777 -0400", hash_original_method = "2833A66A573FEB90891C13E00C93BD47", hash_generated_method = "3189E9D7150A6A0E1DE2A7DE74C5BCB2")
    @Override
    public void closeInbound() throws SSLException {
        {
            logger.println("closeInbound() "+isInboundDone);
        } 
        isInboundDone = true;
        engine_was_closed = true;
        {
            {
                {
                    session.invalidate();
                } 
                alertProtocol.alert(AlertProtocol.FATAL,
                        AlertProtocol.INTERNAL_ERROR);
                if (DroidSafeAndroidRuntime.control) throw new SSLException("Inbound is closed before close_notify "
                        + "alert has been received.");
            } 
        } 
        {
            shutdown();
        } 
        
        
            
        
        
            
        
        
        
        
            
                
                    
                
                
                        
                
                        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.778 -0400", hash_original_method = "194E237603CA4A7D605DF99CBAD71850", hash_generated_method = "F269323587B99EEB025EB87312B376EA")
    @Override
    public void closeOutbound() {
        {
            logger.println("closeOutbound() "+isOutboundDone);
        } 
        isOutboundDone = true;
        {
            alertProtocol.alert(AlertProtocol.WARNING,
                    AlertProtocol.CLOSE_NOTIFY);
            close_notify_was_sent = true;
        } 
        {
            shutdown();
        } 
        engine_was_closed = true;
        
        
            
        
        
            
        
        
        
            
                    
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.778 -0400", hash_original_method = "C14CDBA62113C37F04E8CCD08C8FFAF5", hash_generated_method = "FE19CFF0F8115DFA8D83D21E5A2CCDAA")
    @Override
    public Runnable getDelegatedTask() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_543284180 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_543284180 = handshakeProtocol.getTask();
        varB4EAC82CA7396A68D541C85D26508E83_543284180.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_543284180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.779 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "34BAE16C13187C72EF5EEA5040AAB111")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1418163526 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1418163526 = CipherSuite.getSupportedCipherSuiteNames();
        varB4EAC82CA7396A68D541C85D26508E83_1418163526.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1418163526;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.780 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "6A11A9B9B2632ABD296346878C9EB1DE")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1353994265 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1353994265 = sslParameters.getEnabledCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1353994265.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1353994265;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.780 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "7F545A6EF3038CFCC5D5B349DF2D820E")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
        addTaint(suites[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.781 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "20D35227A50A23377AE928683D7311AD")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2137460372 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2137460372 = ProtocolVersion.supportedProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2137460372.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2137460372;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.782 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "FCCD607D1364BF190B187FED5D2B95C8")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_487405247 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_487405247 = sslParameters.getEnabledProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_487405247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_487405247;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.782 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "24B3390D4A5DB4328E68855FDA4E4FA9")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
        addTaint(protocols[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.782 -0400", hash_original_method = "8643AE5368ED569DA5125D94D54A9561", hash_generated_method = "10EA4ABFA66EF30039C31C15156C8D1B")
    @Override
    public void setUseClientMode(boolean mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
        } 
        sslParameters.setUseClientMode(mode);
        peer_mode_was_set = true;
        addTaint(mode);
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.782 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "EC4833A19476D7D0A4E74E1584C853FA")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1604960677 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_867339394 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_867339394;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.783 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.783 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "8E7635F846B58A493B0B7CD12877E18A")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1818088319 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849519305 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849519305;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.783 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.783 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "2844E58FFB0389BBFC53127FD74AA556")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1616303689 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1647440808 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1647440808;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.783 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.784 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "ACCBA6646134F5301F4B7CD80DD48D13")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_1712457464 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_648943297 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_648943297;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.784 -0400", hash_original_method = "74D7DA825347EF6AE406AA95D0E4A742", hash_generated_method = "1CB94E87EB8CF4E851AE948DFB9B2436")
    @Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1965612223 = null; 
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_827481464 = null; 
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_943190224 = null; 
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1046103295 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1965612223 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        } 
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_1400394241 = (alertProtocol.hasAlert());
            {
                varB4EAC82CA7396A68D541C85D26508E83_827481464 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_943190224 = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1046103295 = handshakeProtocol.getStatus();
        SSLEngineResult.HandshakeStatus varA7E53CE21691AB073D9660D615818899_377551788; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_377551788 = varB4EAC82CA7396A68D541C85D26508E83_1965612223;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_377551788 = varB4EAC82CA7396A68D541C85D26508E83_827481464;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_377551788 = varB4EAC82CA7396A68D541C85D26508E83_943190224;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_377551788 = varB4EAC82CA7396A68D541C85D26508E83_1046103295;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_377551788.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_377551788;
        
        
            
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.785 -0400", hash_original_method = "FEA3CA8E78DB1766A0752130C49C073D", hash_generated_method = "508D18C8B676B118FE04D4DF1D1C9B3E")
    @Override
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1974383953 = null; 
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_270369993 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1974383953 = session;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_270369993 = SSLSessionImpl.NULL_SESSION;
        SSLSession varA7E53CE21691AB073D9660D615818899_974832259; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_974832259 = varB4EAC82CA7396A68D541C85D26508E83_1974383953;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_974832259 = varB4EAC82CA7396A68D541C85D26508E83_270369993;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_974832259.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_974832259;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.785 -0400", hash_original_method = "93B7BEFDB685497BB8E88252AEDDD652", hash_generated_method = "1200B74E783AD56A7E15788655FB96CC")
    @Override
    public boolean isInboundDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1114874352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1114874352;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.785 -0400", hash_original_method = "120A166126F4C5B7FB727570FC11E1A2", hash_generated_method = "33D451E759F5E88C6E43A746F0A1BFC4")
    @Override
    public boolean isOutboundDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_643376659 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_643376659;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.787 -0400", hash_original_method = "F6CF6D1723C677ECF3CA7B0D6EA7AC86", hash_generated_method = "3E11EF696C656319EA9BDF51E1C39BE8")
    @Override
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts,
                                int offset, int length) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_523196868 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1623570139 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1270589284 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1457803656 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1938844083 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_953522479 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_523196868 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Some of the input parameters are null");
        } 
        {
            beginHandshake();
        } 
        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
        {
            boolean varBAECE7682DA8E288BBC6FAB3928B20A7_343257588 = ((session == null || engine_was_closed) && (
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP) ||
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1623570139 = new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            } 
        } 
        {
            boolean var7CB7F8820E6FE7BA16FA809B4AF09898_233591302 = (src.remaining() < recordProtocol.getMinRecordSize());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1270589284 = new SSLEngineResult(
                    SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
            } 
        } 
        try 
        {
            src.mark();
            int capacity = 0;
            {
                int i = offset;
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Some of the input parameters are null");
                    } 
                    {
                        boolean varABE2E5A62BD09C290D04797BA3FDE495_32555718 = (dsts[i].isReadOnly());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
                        } 
                    } 
                    capacity += dsts[i].remaining();
                } 
            } 
            {
                boolean var42B9869E086C4444677BC2C6EB9C6DC5_870621346 = (capacity < recordProtocol.getDataSize(src.remaining()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1457803656 = new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        getHandshakeStatus(), 0, 0);
                } 
            } 
            recProtIS.setSourceBuffer(src);
            int type = recordProtocol.unwrap();
            
            {
                boolean var9D33EDAC6D221E1C1A7877165F01AA35_768623750 = (handshakeProtocol.getStatus().equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                {
                    session = recordProtocol.getSession();
                } 
            } 
            
            
            {
                boolean var421E7BAA85D40FC415472A07983EC7FA_1206479437 = (alertProtocol.isFatalAlert());
                {
                    alertProtocol.setProcessed();
                    {
                        session.invalidate();
                    } 
                    String description = "Fatal alert received "
                            + alertProtocol.getAlertDescription();
                    shutdown();
                    if (DroidSafeAndroidRuntime.control) throw new SSLException(description);
                } 
                {
                    {
                        logger.println("Warning allert has been received: "
                                + alertProtocol.getAlertDescription());
                    } 
                    {
                        Object varF26DEB029A4082B6DE95442C45AA531E_144894364 = (alertProtocol.getDescriptionCode());
                        
                        alertProtocol.setProcessed();
                        
                        
                        close_notify_was_received = true;
                        
                        
                        {
                            closeOutbound();
                            closeInbound();
                        } 
                        {
                            closeInbound();
                            shutdown();
                        } 
                        
                        
                        alertProtocol.setProcessed();
                        
                        
                        {
                            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                                        AlertProtocol.HANDSHAKE_FAILURE,
                                        new SSLHandshakeException(
                                            "Received no_renegotiation "
                                            + "during the initial handshake"));
                        } 
                        {
                            handshakeProtocol.stop();
                        } 
                        
                        
                        alertProtocol.setProcessed();
                        
                    } 
                } 
            } 
            
            varB4EAC82CA7396A68D541C85D26508E83_1938844083 = new SSLEngineResult(getEngineStatus(), getHandshakeStatus(),
                    recProtIS.consumed(),
                    appData.placeTo(dsts, offset, length));
        } 
        catch (BufferUnderflowException e)
        {
            src.reset();
            varB4EAC82CA7396A68D541C85D26508E83_953522479 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
        } 
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            src.reset();
            {
                session.invalidate();
            } 
            if (DroidSafeAndroidRuntime.control) throw e.getReason();
        } 
        catch (SSLException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (IOException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL,
                    AlertProtocol.INTERNAL_ERROR);
            engine_was_closed = true;
            if (DroidSafeAndroidRuntime.control) throw new SSLException(e.getMessage());
        } 
        addTaint(src.getTaint());
        addTaint(dsts[0].getTaint());
        addTaint(offset);
        addTaint(length);
        SSLEngineResult varA7E53CE21691AB073D9660D615818899_386936267; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_523196868;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_1623570139;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_1270589284;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_1457803656;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_1938844083;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_386936267 = varB4EAC82CA7396A68D541C85D26508E83_953522479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_386936267.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_386936267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.791 -0400", hash_original_method = "4D503F6FEFF5A6DB6E7618C8A28327D4", hash_generated_method = "9A2BA65B9D339D2C7B8EBF000CDC7808")
    @Override
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset,
                            int len, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1940261285 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1958778786 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_886382859 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_759216439 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_256459652 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1800724921 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1258445580 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1201147426 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_2028824987 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_636952133 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1700349779 = null; 
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_599280478 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1940261285 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Some of the input parameters are null");
        } 
        {
            boolean var45C27560C2BDC5437CAF1B5DEC7559EF_1132725125 = (dst.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } 
        } 
        {
            beginHandshake();
        } 
        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
        {
            boolean varCA637BAACDB0BB5B3DC8E7EA5C3B4866_2056878922 = ((session == null || engine_was_closed) && (
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_UNWRAP) ||
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1958778786 = new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            } 
        } 
        int capacity = dst.remaining();
        int produced = 0;
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_311420813 = (alertProtocol.hasAlert());
            {
                {
                    boolean var2E387AFA09379ED6A8A77D9181EA9203_1929879197 = (capacity < recordProtocol.getRecordSize(2));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_886382859 = new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
                    } 
                } 
                byte[] alert_data = alertProtocol.wrap();
                dst.put(alert_data);
                {
                    boolean varE8538EAB39A9EEDECFE745A4C142519C_767423085 = (alertProtocol.isFatalAlert());
                    {
                        alertProtocol.setProcessed();
                        {
                            session.invalidate();
                        } 
                        shutdown();
                        varB4EAC82CA7396A68D541C85D26508E83_759216439 = new SSLEngineResult(
                        SSLEngineResult.Status.CLOSED,
                        SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                        0, alert_data.length);
                    } 
                    {
                        alertProtocol.setProcessed();
                        {
                            shutdown();
                            varB4EAC82CA7396A68D541C85D26508E83_256459652 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                            SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                            0, alert_data.length);
                        } 
                        varB4EAC82CA7396A68D541C85D26508E83_1800724921 = new SSLEngineResult(
                        getEngineStatus(),
                        getHandshakeStatus(),
                        0, alert_data.length);
                    } 
                } 
            } 
        } 
        {
            boolean var0EB0B6901228962450A57485F383904A_1796476130 = (capacity < recordProtocol.getMinRecordSize());
            {
                {
                    logger.println("Capacity of the destination("
                        +capacity+") < MIN_PACKET_SIZE("
                        +recordProtocol.getMinRecordSize()+")");
                } 
                varB4EAC82CA7396A68D541C85D26508E83_1258445580 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
            } 
        } 
        try 
        {
            {
                boolean var26A202D1540C87FD4D5B941AC813E7AA_319757602 = (!handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP));
                {
                    dataStream.setSourceBuffers(srcs, offset, len);
                    {
                        boolean varACD5D72B7ADB189B1CB41D8641229159_1687801487 = ((capacity < SSLRecordProtocol.MAX_SSL_PACKET_SIZE) &&
                    (capacity < recordProtocol.getRecordSize(
                                                 dataStream.available())));
                        {
                            {
                                logger.println("The destination buffer("
                                +capacity+") can not take the resulting packet("
                                + recordProtocol.getRecordSize(
                                    dataStream.available())+")");
                            } 
                            varB4EAC82CA7396A68D541C85D26508E83_1201147426 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                        } 
                    } 
                    {
                        remaining_wrapped_data =
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                dataStream);
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_2028824987 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, dataStream.consumed(), 0);
                    } 
                    {
                        dst.put(remaining_wrapped_data);
                        produced = remaining_wrapped_data.length;
                        remaining_wrapped_data = null;
                        varB4EAC82CA7396A68D541C85D26508E83_636952133 = new SSLEngineResult(getEngineStatus(),
                            handshakeStatus, dataStream.consumed(), produced);
                    } 
                } 
                {
                    {
                        remaining_hsh_data = handshakeProtocol.wrap();
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1700349779 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                    } 
                    {
                        dst.put(remaining_hsh_data);
                        produced = remaining_hsh_data.length;
                        remaining_hsh_data = null;
                        handshakeStatus = handshakeProtocol.getStatus();
                        {
                            boolean var4CD13050AAC00AFD2C83ECB27D501211_1804179819 = (handshakeStatus.equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                            {
                                session = recordProtocol.getSession();
                            } 
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_599280478 = new SSLEngineResult(
                        getEngineStatus(), getHandshakeStatus(), 0, produced);
                } 
            } 
        } 
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            {
                session.invalidate();
            } 
            if (DroidSafeAndroidRuntime.control) throw e.getReason();
        } 
        addTaint(srcs[0].getTaint());
        addTaint(offset);
        addTaint(len);
        addTaint(dst.getTaint());
        SSLEngineResult varA7E53CE21691AB073D9660D615818899_1094223451; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1940261285;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1958778786;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_886382859;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_759216439;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_256459652;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1800724921;
                break;
            case 7: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1258445580;
                break;
            case 8: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1201147426;
                break;
            case 9: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_2028824987;
                break;
            case 10: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_636952133;
                break;
            case 11: 
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_1700349779;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1094223451 = varB4EAC82CA7396A68D541C85D26508E83_599280478;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1094223451.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1094223451;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.792 -0400", hash_original_method = "2E4498D8774C920317F596FEB8E0DACF", hash_generated_method = "8C621A488925C104801D7B92F36FF261")
    private void shutdown() {
        engine_was_closed = true;
        engine_was_shutteddown = true;
        isOutboundDone = true;
        isInboundDone = true;
        {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        } 
        
        
        
        
        
        
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.794 -0400", hash_original_method = "C6B39897E63E44773E5CEE8467983722", hash_generated_method = "A93A457CD03CACD2BAD5B332ECB6E386")
    private SSLEngineResult.Status getEngineStatus() {
        SSLEngineResult.Status varB4EAC82CA7396A68D541C85D26508E83_929342818 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_929342818 = (engine_was_closed)
            ? SSLEngineResult.Status.CLOSED
            : SSLEngineResult.Status.OK;
        varB4EAC82CA7396A68D541C85D26508E83_929342818.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_929342818;
        
        
            
            
    }

    
}

