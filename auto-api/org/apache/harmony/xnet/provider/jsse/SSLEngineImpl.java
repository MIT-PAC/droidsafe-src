package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.497 -0400", hash_original_field = "7FBF54CF570CEAF60078F31954B8B4A0", hash_generated_field = "E654CE2FA30E1E8D898FBE3969CE5BA6")

    private boolean peer_mode_was_set = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.497 -0400", hash_original_field = "3AE81331685336BDF4905577358403FE", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.497 -0400", hash_original_field = "7DA2C545C56E344DA4BE6047ABB8C218", hash_generated_field = "537BCD10B20577D816D536B7EDFB0EE3")

    private boolean isInboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "264D68367E3ADE189F1F2A061B01173C", hash_generated_field = "21C2B63110EA37B8DBBBCF2E6ABCB0C5")

    private boolean isOutboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "AD2CAB884FC34185AFBAC0C583801A9B", hash_generated_field = "0F2AABB7E4332770B73BAB937514BD0D")

    private boolean close_notify_was_sent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "12846A5171C74544269F1A0D9D8DDDB1", hash_generated_field = "03323CA5EBF65F9CEB9F00CD95FE22FD")

    private boolean close_notify_was_received = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "A0EE8E97814BBF3228F9D01743B7562A", hash_generated_field = "B6CCCFBA31363DCB6CB3A490B6425D37")

    private boolean engine_was_closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "87C012AF7A1326EDFFF2C077A68FABDC", hash_generated_field = "DCE9A139F26465C1B64DE6866C9BACD4")

    private boolean engine_was_shutteddown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "A37720500B9EFE8F88BA25252953D413", hash_generated_field = "FC3A570B665E22F2CB948EFB2EF1D139")

    private SSLBufferedInput recProtIS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "78DC08180DEB6EFF54F49C04C6F3038B", hash_generated_field = "ED6BE62BE19D8AB0377A63F127B6719A")

    private SSLEngineAppData appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "3481789BD3617E3A5C841738CE452D88", hash_generated_field = "82EA68D6EF77B38A42F06A687812969F")

    private SSLEngineDataStream dataStream = new SSLEngineDataStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "FC88AA253F00F788C3DE05E8DA029A4E", hash_generated_field = "EE60D1DC1F6328AC4E5F20E6A2F3A8B3")

    private byte[] remaining_wrapped_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "204FA029E945DECB729F2176146804E2", hash_generated_field = "7736556E778E3455D57F720F57447D0D")

    private byte[] remaining_hsh_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_field = "220E7B611C947D4301416AD762474BA7", hash_generated_field = "45814449E3DD231F6EDFB081F6B3B7C8")

    private Logger.Stream logger = Logger.getStream("engine");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.499 -0400", hash_original_method = "1C2B310D768BCE8FE406784210BB6A4F", hash_generated_method = "449421F84A60DA11810D2E6AE603064A")
    protected  SSLEngineImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.500 -0400", hash_original_method = "399A1B6B7D3996FC39BEE7E87B5F152E", hash_generated_method = "32262A311B212709BEDE958FE392FCDC")
    protected  SSLEngineImpl(String host, int port, SSLParametersImpl sslParameters) {
        super(host, port);
        this.sslParameters = sslParameters;
        addTaint(host.getTaint());
        addTaint(port);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.500 -0400", hash_original_method = "C9E26C97B00AD59FF47E5A96B3855814", hash_generated_method = "D4DB80AF3819FA9DA7C2B370C4F2CB12")
    @Override
    public void beginHandshake() throws SSLException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLException("Engine has already been closed.");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Client/Server mode was not set");
        } //End block
        {
            handshake_started = true;
            {
                boolean varD3A3B98B1AB89C5D601DFF15338516F8_982956727 = (getUseClientMode());
                {
                    handshakeProtocol = new ClientHandshakeImpl(this);
                } //End block
                {
                    handshakeProtocol = new ServerHandshakeImpl(this);
                } //End block
            } //End collapsed parenthetic
            appData = new SSLEngineAppData();
            alertProtocol = new AlertProtocol();
            recProtIS = new SSLBufferedInput();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, recProtIS, appData);
        } //End block
        handshakeProtocol.start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.501 -0400", hash_original_method = "2833A66A573FEB90891C13E00C93BD47", hash_generated_method = "3189E9D7150A6A0E1DE2A7DE74C5BCB2")
    @Override
    public void closeInbound() throws SSLException {
        {
            logger.println("closeInbound() "+isInboundDone);
        } //End block
        isInboundDone = true;
        engine_was_closed = true;
        {
            {
                {
                    session.invalidate();
                } //End block
                alertProtocol.alert(AlertProtocol.FATAL,
                        AlertProtocol.INTERNAL_ERROR);
                if (DroidSafeAndroidRuntime.control) throw new SSLException("Inbound is closed before close_notify "
                        + "alert has been received.");
            } //End block
        } //End block
        {
            shutdown();
        } //End block
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("closeInbound() "+isInboundDone);
        //}
        //if (isInboundDone) {
            //return;
        //}
        //isInboundDone = true;
        //engine_was_closed = true;
        //if (handshake_started) {
            //if (!close_notify_was_received) {
                //if (session != null) {
                    //session.invalidate();
                //}
                //alertProtocol.alert(AlertProtocol.FATAL,
                        //AlertProtocol.INTERNAL_ERROR);
                //throw new SSLException("Inbound is closed before close_notify "
                        //+ "alert has been received.");
            //}
        //} else {
            //shutdown();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.506 -0400", hash_original_method = "194E237603CA4A7D605DF99CBAD71850", hash_generated_method = "F269323587B99EEB025EB87312B376EA")
    @Override
    public void closeOutbound() {
        {
            logger.println("closeOutbound() "+isOutboundDone);
        } //End block
        isOutboundDone = true;
        {
            alertProtocol.alert(AlertProtocol.WARNING,
                    AlertProtocol.CLOSE_NOTIFY);
            close_notify_was_sent = true;
        } //End block
        {
            shutdown();
        } //End block
        engine_was_closed = true;
        // ---------- Original Method ----------
        //if (logger != null) {
            //logger.println("closeOutbound() "+isOutboundDone);
        //}
        //if (isOutboundDone) {
            //return;
        //}
        //isOutboundDone = true;
        //if (handshake_started) {
            //alertProtocol.alert(AlertProtocol.WARNING,
                    //AlertProtocol.CLOSE_NOTIFY);
            //close_notify_was_sent = true;
        //} else {
            //shutdown();
        //}
        //engine_was_closed = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.506 -0400", hash_original_method = "C14CDBA62113C37F04E8CCD08C8FFAF5", hash_generated_method = "5EE92577EF23E8B56657E4BF7A5DDBAC")
    @Override
    public Runnable getDelegatedTask() {
        Runnable varB4EAC82CA7396A68D541C85D26508E83_791724339 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_791724339 = handshakeProtocol.getTask();
        varB4EAC82CA7396A68D541C85D26508E83_791724339.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_791724339;
        // ---------- Original Method ----------
        //return handshakeProtocol.getTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.507 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "91EDE1E574F80CA7DB12B8E040B500E3")
    @Override
    public String[] getSupportedCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_757382029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_757382029 = CipherSuite.getSupportedCipherSuiteNames();
        varB4EAC82CA7396A68D541C85D26508E83_757382029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_757382029;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.507 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "6D0D3A5B6C4ECD729EEA6E0B3D67285A")
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1128564800 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1128564800 = sslParameters.getEnabledCipherSuites();
        varB4EAC82CA7396A68D541C85D26508E83_1128564800.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1128564800;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.507 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "7F545A6EF3038CFCC5D5B349DF2D820E")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
        addTaint(suites[0].getTaint());
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.511 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "C8364329ACF265E905D0B0AE5BE0FC55")
    @Override
    public String[] getSupportedProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_988408519 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_988408519 = ProtocolVersion.supportedProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_988408519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_988408519;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.511 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "128EAD5B57FD0DCD0E705B367EF3A14D")
    @Override
    public String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_792612111 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_792612111 = sslParameters.getEnabledProtocols();
        varB4EAC82CA7396A68D541C85D26508E83_792612111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_792612111;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.511 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "24B3390D4A5DB4328E68855FDA4E4FA9")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
        addTaint(protocols[0].getTaint());
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.517 -0400", hash_original_method = "8643AE5368ED569DA5125D94D54A9561", hash_generated_method = "10EA4ABFA66EF30039C31C15156C8D1B")
    @Override
    public void setUseClientMode(boolean mode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
        } //End block
        sslParameters.setUseClientMode(mode);
        peer_mode_was_set = true;
        addTaint(mode);
        // ---------- Original Method ----------
        //if (handshake_started) {
            //throw new IllegalArgumentException(
            //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
        //peer_mode_was_set = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.517 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "B83B4FECD06B5E21BC585A6028CF0DEE")
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_183474596 = (sslParameters.getUseClientMode());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1486761483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1486761483;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.517 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "0546B005C61E39ED72A709422B43B69F")
    @Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
        addTaint(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.518 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "155B21E1F51160C7967E9E58B73672C7")
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1648349483 = (sslParameters.getNeedClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_930497262 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_930497262;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.520 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "36D0D50995337D2D75DCB0482721034F")
    @Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
        addTaint(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.520 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "E5E244948CE5FE5C84E29A1D1ED5465A")
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_1489507559 = (sslParameters.getWantClientAuth());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975064296 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975064296;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.520 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "781712039B284C5CB7B48D72B261E886")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
        addTaint(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.522 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "113CB1B4EC247DDB6B29FE046AB1960E")
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_959171538 = (sslParameters.getEnableSessionCreation());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_157619639 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_157619639;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.522 -0400", hash_original_method = "74D7DA825347EF6AE406AA95D0E4A742", hash_generated_method = "E4D66CD608BDF733FBF8C9B8C7910C0B")
    @Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_416859415 = null; //Variable for return #1
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_52632688 = null; //Variable for return #2
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_676578659 = null; //Variable for return #3
        SSLEngineResult.HandshakeStatus varB4EAC82CA7396A68D541C85D26508E83_1232982348 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_416859415 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        } //End block
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_367459967 = (alertProtocol.hasAlert());
            {
                varB4EAC82CA7396A68D541C85D26508E83_52632688 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_676578659 = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1232982348 = handshakeProtocol.getStatus();
        SSLEngineResult.HandshakeStatus varA7E53CE21691AB073D9660D615818899_1242247483; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1242247483 = varB4EAC82CA7396A68D541C85D26508E83_416859415;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1242247483 = varB4EAC82CA7396A68D541C85D26508E83_52632688;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1242247483 = varB4EAC82CA7396A68D541C85D26508E83_676578659;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1242247483 = varB4EAC82CA7396A68D541C85D26508E83_1232982348;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1242247483.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1242247483;
        // ---------- Original Method ----------
        //if (!handshake_started || engine_was_shutteddown) {
            //return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        //}
        //if (alertProtocol.hasAlert()) {
            //return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        //}
        //if (close_notify_was_sent && !close_notify_was_received) {
            //return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        //}
        //return handshakeProtocol.getStatus();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.524 -0400", hash_original_method = "FEA3CA8E78DB1766A0752130C49C073D", hash_generated_method = "7C9BB7729693F3359B205A6CCD2BACA5")
    @Override
    public SSLSession getSession() {
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1603817940 = null; //Variable for return #1
        SSLSession varB4EAC82CA7396A68D541C85D26508E83_1016808235 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1603817940 = session;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1016808235 = SSLSessionImpl.NULL_SESSION;
        SSLSession varA7E53CE21691AB073D9660D615818899_489409011; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_489409011 = varB4EAC82CA7396A68D541C85D26508E83_1603817940;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_489409011 = varB4EAC82CA7396A68D541C85D26508E83_1016808235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_489409011.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_489409011;
        // ---------- Original Method ----------
        //if (session != null) {
            //return session;
        //}
        //return SSLSessionImpl.NULL_SESSION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.524 -0400", hash_original_method = "93B7BEFDB685497BB8E88252AEDDD652", hash_generated_method = "4EDCD067B43D6E75A5D0322405D92B18")
    @Override
    public boolean isInboundDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1688485193 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1688485193;
        // ---------- Original Method ----------
        //return isInboundDone || engine_was_closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.524 -0400", hash_original_method = "120A166126F4C5B7FB727570FC11E1A2", hash_generated_method = "C93DC7BBFDCF7C729295D32CCF89D166")
    @Override
    public boolean isOutboundDone() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1759954504 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1759954504;
        // ---------- Original Method ----------
        //return isOutboundDone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.535 -0400", hash_original_method = "F6CF6D1723C677ECF3CA7B0D6EA7AC86", hash_generated_method = "EACF326320F636D9C4C2AC77781F613E")
    @Override
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts,
                                int offset, int length) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1958418647 = null; //Variable for return #1
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1765318763 = null; //Variable for return #2
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_2040758073 = null; //Variable for return #3
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_651061673 = null; //Variable for return #4
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1007184695 = null; //Variable for return #5
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_120680722 = null; //Variable for return #6
        {
            varB4EAC82CA7396A68D541C85D26508E83_1958418647 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Some of the input parameters are null");
        } //End block
        {
            beginHandshake();
        } //End block
        SSLEngineResult.HandshakeStatus handshakeStatus;
        handshakeStatus = getHandshakeStatus();
        {
            boolean varBAECE7682DA8E288BBC6FAB3928B20A7_1737535324 = ((session == null || engine_was_closed) && (
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP) ||
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1765318763 = new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7CB7F8820E6FE7BA16FA809B4AF09898_185048072 = (src.remaining() < recordProtocol.getMinRecordSize());
            {
                varB4EAC82CA7396A68D541C85D26508E83_2040758073 = new SSLEngineResult(
                    SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            src.mark();
            int capacity;
            capacity = 0;
            {
                int i;
                i = offset;
                {
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "Some of the input parameters are null");
                    } //End block
                    {
                        boolean varABE2E5A62BD09C290D04797BA3FDE495_12272630 = (dsts[i].isReadOnly());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
                        } //End block
                    } //End collapsed parenthetic
                    capacity += dsts[i].remaining();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var42B9869E086C4444677BC2C6EB9C6DC5_1661299183 = (capacity < recordProtocol.getDataSize(src.remaining()));
                {
                    varB4EAC82CA7396A68D541C85D26508E83_651061673 = new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        getHandshakeStatus(), 0, 0);
                } //End block
            } //End collapsed parenthetic
            recProtIS.setSourceBuffer(src);
            int type;
            type = recordProtocol.unwrap();
            //Begin case ContentType.HANDSHAKE ContentType.CHANGE_CIPHER_SPEC 
            {
                boolean var9D33EDAC6D221E1C1A7877165F01AA35_792115192 = (handshakeProtocol.getStatus().equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                {
                    session = recordProtocol.getSession();
                } //End block
            } //End collapsed parenthetic
            //End case ContentType.HANDSHAKE ContentType.CHANGE_CIPHER_SPEC 
            //Begin case ContentType.ALERT 
            {
                boolean var421E7BAA85D40FC415472A07983EC7FA_629456606 = (alertProtocol.isFatalAlert());
                {
                    alertProtocol.setProcessed();
                    {
                        session.invalidate();
                    } //End block
                    String description;
                    description = "Fatal alert received "
                            + alertProtocol.getAlertDescription();
                    shutdown();
                    if (DroidSafeAndroidRuntime.control) throw new SSLException(description);
                } //End block
                {
                    {
                        logger.println("Warning allert has been received: "
                                + alertProtocol.getAlertDescription());
                    } //End block
                    {
                        Object varF26DEB029A4082B6DE95442C45AA531E_143743420 = (alertProtocol.getDescriptionCode());
                        //Begin case AlertProtocol.CLOSE_NOTIFY 
                        alertProtocol.setProcessed();
                        //End case AlertProtocol.CLOSE_NOTIFY 
                        //Begin case AlertProtocol.CLOSE_NOTIFY 
                        close_notify_was_received = true;
                        //End case AlertProtocol.CLOSE_NOTIFY 
                        //Begin case AlertProtocol.CLOSE_NOTIFY 
                        {
                            closeOutbound();
                            closeInbound();
                        } //End block
                        {
                            closeInbound();
                            shutdown();
                        } //End block
                        //End case AlertProtocol.CLOSE_NOTIFY 
                        //Begin case AlertProtocol.NO_RENEGOTIATION 
                        alertProtocol.setProcessed();
                        //End case AlertProtocol.NO_RENEGOTIATION 
                        //Begin case AlertProtocol.NO_RENEGOTIATION 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new AlertException(
                                        AlertProtocol.HANDSHAKE_FAILURE,
                                        new SSLHandshakeException(
                                            "Received no_renegotiation "
                                            + "during the initial handshake"));
                        } //End block
                        {
                            handshakeProtocol.stop();
                        } //End block
                        //End case AlertProtocol.NO_RENEGOTIATION 
                        //Begin case default 
                        alertProtocol.setProcessed();
                        //End case default 
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            //End case ContentType.ALERT 
            varB4EAC82CA7396A68D541C85D26508E83_1007184695 = new SSLEngineResult(getEngineStatus(), getHandshakeStatus(),
                    recProtIS.consumed(),
                    appData.placeTo(dsts, offset, length));
        } //End block
        catch (BufferUnderflowException e)
        {
            src.reset();
            varB4EAC82CA7396A68D541C85D26508E83_120680722 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
        } //End block
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            src.reset();
            {
                session.invalidate();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw e.getReason();
        } //End block
        catch (SSLException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (IOException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL,
                    AlertProtocol.INTERNAL_ERROR);
            engine_was_closed = true;
            if (DroidSafeAndroidRuntime.control) throw new SSLException(e.getMessage());
        } //End block
        addTaint(src.getTaint());
        addTaint(dsts[0].getTaint());
        addTaint(offset);
        addTaint(length);
        SSLEngineResult varA7E53CE21691AB073D9660D615818899_692275508; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_1958418647;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_1765318763;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_2040758073;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_651061673;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_1007184695;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_692275508 = varB4EAC82CA7396A68D541C85D26508E83_120680722;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_692275508.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_692275508;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.546 -0400", hash_original_method = "4D503F6FEFF5A6DB6E7618C8A28327D4", hash_generated_method = "69281450D394DF35AC555F6F453FBB06")
    @Override
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset,
                            int len, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1368081899 = null; //Variable for return #1
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1393513574 = null; //Variable for return #2
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_902574469 = null; //Variable for return #3
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_583870629 = null; //Variable for return #4
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1450484926 = null; //Variable for return #5
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1437805455 = null; //Variable for return #6
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_246149028 = null; //Variable for return #7
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1540251080 = null; //Variable for return #8
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1156498957 = null; //Variable for return #9
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_195224787 = null; //Variable for return #10
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1348489526 = null; //Variable for return #11
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_331414237 = null; //Variable for return #12
        {
            varB4EAC82CA7396A68D541C85D26508E83_1368081899 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Some of the input parameters are null");
        } //End block
        {
            boolean var45C27560C2BDC5437CAF1B5DEC7559EF_2127426689 = (dst.isReadOnly());
            {
                if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
            } //End block
        } //End collapsed parenthetic
        {
            beginHandshake();
        } //End block
        SSLEngineResult.HandshakeStatus handshakeStatus;
        handshakeStatus = getHandshakeStatus();
        {
            boolean varCA637BAACDB0BB5B3DC8E7EA5C3B4866_562755675 = ((session == null || engine_was_closed) && (
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_UNWRAP) ||
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1393513574 = new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            } //End block
        } //End collapsed parenthetic
        int capacity;
        capacity = dst.remaining();
        int produced;
        produced = 0;
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_958703141 = (alertProtocol.hasAlert());
            {
                {
                    boolean var2E387AFA09379ED6A8A77D9181EA9203_1055677120 = (capacity < recordProtocol.getRecordSize(2));
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_902574469 = new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
                    } //End block
                } //End collapsed parenthetic
                byte[] alert_data;
                alert_data = alertProtocol.wrap();
                dst.put(alert_data);
                {
                    boolean varE8538EAB39A9EEDECFE745A4C142519C_1716387385 = (alertProtocol.isFatalAlert());
                    {
                        alertProtocol.setProcessed();
                        {
                            session.invalidate();
                        } //End block
                        shutdown();
                        varB4EAC82CA7396A68D541C85D26508E83_583870629 = new SSLEngineResult(
                        SSLEngineResult.Status.CLOSED,
                        SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                        0, alert_data.length);
                    } //End block
                    {
                        alertProtocol.setProcessed();
                        {
                            shutdown();
                            varB4EAC82CA7396A68D541C85D26508E83_1450484926 = new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                            SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                            0, alert_data.length);
                        } //End block
                        varB4EAC82CA7396A68D541C85D26508E83_1437805455 = new SSLEngineResult(
                        getEngineStatus(),
                        getHandshakeStatus(),
                        0, alert_data.length);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0EB0B6901228962450A57485F383904A_1342997717 = (capacity < recordProtocol.getMinRecordSize());
            {
                {
                    logger.println("Capacity of the destination("
                        +capacity+") < MIN_PACKET_SIZE("
                        +recordProtocol.getMinRecordSize()+")");
                } //End block
                varB4EAC82CA7396A68D541C85D26508E83_246149028 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var26A202D1540C87FD4D5B941AC813E7AA_62369644 = (!handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP));
                {
                    dataStream.setSourceBuffers(srcs, offset, len);
                    {
                        boolean varACD5D72B7ADB189B1CB41D8641229159_1460917272 = ((capacity < SSLRecordProtocol.MAX_SSL_PACKET_SIZE) &&
                    (capacity < recordProtocol.getRecordSize(
                                                 dataStream.available())));
                        {
                            {
                                logger.println("The destination buffer("
                                +capacity+") can not take the resulting packet("
                                + recordProtocol.getRecordSize(
                                    dataStream.available())+")");
                            } //End block
                            varB4EAC82CA7396A68D541C85D26508E83_1540251080 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        remaining_wrapped_data =
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                dataStream);
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1156498957 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, dataStream.consumed(), 0);
                    } //End block
                    {
                        dst.put(remaining_wrapped_data);
                        produced = remaining_wrapped_data.length;
                        remaining_wrapped_data = null;
                        varB4EAC82CA7396A68D541C85D26508E83_195224787 = new SSLEngineResult(getEngineStatus(),
                            handshakeStatus, dataStream.consumed(), produced);
                    } //End block
                } //End block
                {
                    {
                        remaining_hsh_data = handshakeProtocol.wrap();
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1348489526 = new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                    } //End block
                    {
                        dst.put(remaining_hsh_data);
                        produced = remaining_hsh_data.length;
                        remaining_hsh_data = null;
                        handshakeStatus = handshakeProtocol.getStatus();
                        {
                            boolean var4CD13050AAC00AFD2C83ECB27D501211_1725840076 = (handshakeStatus.equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                            {
                                session = recordProtocol.getSession();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_331414237 = new SSLEngineResult(
                        getEngineStatus(), getHandshakeStatus(), 0, produced);
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            {
                session.invalidate();
            } //End block
            if (DroidSafeAndroidRuntime.control) throw e.getReason();
        } //End block
        addTaint(srcs[0].getTaint());
        addTaint(offset);
        addTaint(len);
        addTaint(dst.getTaint());
        SSLEngineResult varA7E53CE21691AB073D9660D615818899_287356526; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1368081899;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1393513574;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_902574469;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_583870629;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1450484926;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1437805455;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_246149028;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1540251080;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1156498957;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_195224787;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_1348489526;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_287356526 = varB4EAC82CA7396A68D541C85D26508E83_331414237;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_287356526.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_287356526;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.547 -0400", hash_original_method = "2E4498D8774C920317F596FEB8E0DACF", hash_generated_method = "8C621A488925C104801D7B92F36FF261")
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
        } //End block
        // ---------- Original Method ----------
        //engine_was_closed = true;
        //engine_was_shutteddown = true;
        //isOutboundDone = true;
        //isInboundDone = true;
        //if (handshake_started) {
            //alertProtocol.shutdown();
            //alertProtocol = null;
            //handshakeProtocol.shutdown();
            //handshakeProtocol = null;
            //recordProtocol.shutdown();
            //recordProtocol = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.547 -0400", hash_original_method = "C6B39897E63E44773E5CEE8467983722", hash_generated_method = "4FE1E71433763CA8CE9BF3B48FCA0578")
    private SSLEngineResult.Status getEngineStatus() {
        SSLEngineResult.Status varB4EAC82CA7396A68D541C85D26508E83_195001044 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_195001044 = (engine_was_closed)
            ? SSLEngineResult.Status.CLOSED
            : SSLEngineResult.Status.OK;
        varB4EAC82CA7396A68D541C85D26508E83_195001044.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_195001044;
        // ---------- Original Method ----------
        //return (engine_was_closed)
            //? SSLEngineResult.Status.CLOSED
            //: SSLEngineResult.Status.OK;
    }

    
}

