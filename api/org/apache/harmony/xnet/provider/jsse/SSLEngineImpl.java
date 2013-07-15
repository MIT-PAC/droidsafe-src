package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.980 -0400", hash_original_field = "7FBF54CF570CEAF60078F31954B8B4A0", hash_generated_field = "E654CE2FA30E1E8D898FBE3969CE5BA6")

    private boolean peer_mode_was_set = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.980 -0400", hash_original_field = "3AE81331685336BDF4905577358403FE", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.980 -0400", hash_original_field = "7DA2C545C56E344DA4BE6047ABB8C218", hash_generated_field = "537BCD10B20577D816D536B7EDFB0EE3")

    private boolean isInboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.980 -0400", hash_original_field = "264D68367E3ADE189F1F2A061B01173C", hash_generated_field = "21C2B63110EA37B8DBBBCF2E6ABCB0C5")

    private boolean isOutboundDone = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "AD2CAB884FC34185AFBAC0C583801A9B", hash_generated_field = "0F2AABB7E4332770B73BAB937514BD0D")

    private boolean close_notify_was_sent = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "12846A5171C74544269F1A0D9D8DDDB1", hash_generated_field = "03323CA5EBF65F9CEB9F00CD95FE22FD")

    private boolean close_notify_was_received = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "A0EE8E97814BBF3228F9D01743B7562A", hash_generated_field = "B6CCCFBA31363DCB6CB3A490B6425D37")

    private boolean engine_was_closed = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "87C012AF7A1326EDFFF2C077A68FABDC", hash_generated_field = "DCE9A139F26465C1B64DE6866C9BACD4")

    private boolean engine_was_shutteddown = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "398E3ACF063793A09BD262C5C522B1DE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "A37720500B9EFE8F88BA25252953D413", hash_generated_field = "FC3A570B665E22F2CB948EFB2EF1D139")

    private SSLBufferedInput recProtIS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "C8D4E1C676644CE99FCC63554749D588", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "81D2B0D9B2A75D6611E459D125528CA5", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "78DC08180DEB6EFF54F49C04C6F3038B", hash_generated_field = "ED6BE62BE19D8AB0377A63F127B6719A")

    private SSLEngineAppData appData;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "3481789BD3617E3A5C841738CE452D88", hash_generated_field = "82EA68D6EF77B38A42F06A687812969F")

    private SSLEngineDataStream dataStream = new SSLEngineDataStream();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.981 -0400", hash_original_field = "FC88AA253F00F788C3DE05E8DA029A4E", hash_generated_field = "EE60D1DC1F6328AC4E5F20E6A2F3A8B3")

    private byte[] remaining_wrapped_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.982 -0400", hash_original_field = "204FA029E945DECB729F2176146804E2", hash_generated_field = "7736556E778E3455D57F720F57447D0D")

    private byte[] remaining_hsh_data = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.982 -0400", hash_original_field = "220E7B611C947D4301416AD762474BA7", hash_generated_field = "45814449E3DD231F6EDFB081F6B3B7C8")

    private Logger.Stream logger = Logger.getStream("engine");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.982 -0400", hash_original_method = "1C2B310D768BCE8FE406784210BB6A4F", hash_generated_method = "449421F84A60DA11810D2E6AE603064A")
    protected  SSLEngineImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.983 -0400", hash_original_method = "399A1B6B7D3996FC39BEE7E87B5F152E", hash_generated_method = "EA46FA16EFB453446B7498074189D5CA")
    protected  SSLEngineImpl(String host, int port, SSLParametersImpl sslParameters) {
        super(host, port);
        addTaint(port);
        addTaint(host.getTaint());
        this.sslParameters = sslParameters;
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.984 -0400", hash_original_method = "C9E26C97B00AD59FF47E5A96B3855814", hash_generated_method = "64E493696AFFFE805CC43E8583DD7E66")
    @Override
    public void beginHandshake() throws SSLException {
    if(engine_was_closed)        
        {
            SSLException varC9291568544388BA373BDE3ED2B766B0_2078669288 = new SSLException("Engine has already been closed.");
            varC9291568544388BA373BDE3ED2B766B0_2078669288.addTaint(taint);
            throw varC9291568544388BA373BDE3ED2B766B0_2078669288;
        } //End block
    if(!peer_mode_was_set)        
        {
            IllegalStateException varC1B3F221097BAD7684C98F247BB7C183_1118489692 = new IllegalStateException("Client/Server mode was not set");
            varC1B3F221097BAD7684C98F247BB7C183_1118489692.addTaint(taint);
            throw varC1B3F221097BAD7684C98F247BB7C183_1118489692;
        } //End block
    if(!handshake_started)        
        {
            handshake_started = true;
    if(getUseClientMode())            
            {
                handshakeProtocol = new ClientHandshakeImpl(this);
            } //End block
            else
            {
                handshakeProtocol = new ServerHandshakeImpl(this);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.985 -0400", hash_original_method = "2833A66A573FEB90891C13E00C93BD47", hash_generated_method = "493890EEECD9F63D08B496F4573F0F3A")
    @Override
    public void closeInbound() throws SSLException {
    if(logger != null)        
        {
            logger.println("closeInbound() "+isInboundDone);
        } //End block
    if(isInboundDone)        
        {
            return;
        } //End block
        isInboundDone = true;
        engine_was_closed = true;
    if(handshake_started)        
        {
    if(!close_notify_was_received)            
            {
    if(session != null)                
                {
                    session.invalidate();
                } //End block
                alertProtocol.alert(AlertProtocol.FATAL,
                        AlertProtocol.INTERNAL_ERROR);
                SSLException var5F21B431B8BB4187FA00A1C78D0CD95F_217711181 = new SSLException("Inbound is closed before close_notify "
                        + "alert has been received.");
                var5F21B431B8BB4187FA00A1C78D0CD95F_217711181.addTaint(taint);
                throw var5F21B431B8BB4187FA00A1C78D0CD95F_217711181;
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.986 -0400", hash_original_method = "194E237603CA4A7D605DF99CBAD71850", hash_generated_method = "4BEBC003D7829E63BF49158B4FA0DE02")
    @Override
    public void closeOutbound() {
    if(logger != null)        
        {
            logger.println("closeOutbound() "+isOutboundDone);
        } //End block
    if(isOutboundDone)        
        {
            return;
        } //End block
        isOutboundDone = true;
    if(handshake_started)        
        {
            alertProtocol.alert(AlertProtocol.WARNING,
                    AlertProtocol.CLOSE_NOTIFY);
            close_notify_was_sent = true;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.986 -0400", hash_original_method = "C14CDBA62113C37F04E8CCD08C8FFAF5", hash_generated_method = "6D62B19273DA54B85C63C0E29D21A0E3")
    @Override
    public Runnable getDelegatedTask() {
Runnable varB6B057671593B61EA10FF2253040D421_1213097279 =         handshakeProtocol.getTask();
        varB6B057671593B61EA10FF2253040D421_1213097279.addTaint(taint);
        return varB6B057671593B61EA10FF2253040D421_1213097279;
        // ---------- Original Method ----------
        //return handshakeProtocol.getTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.986 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "8B0DC50F91FE302BD01B975B741D1A31")
    @Override
    public String[] getSupportedCipherSuites() {
String[] varF6F3ABBB205DDE294417F777EFDFB1AB_2108248309 =         CipherSuite.getSupportedCipherSuiteNames();
        varF6F3ABBB205DDE294417F777EFDFB1AB_2108248309.addTaint(taint);
        return varF6F3ABBB205DDE294417F777EFDFB1AB_2108248309;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.987 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "C5561DDB89C032BEF4D7B8CEEAD457EB")
    @Override
    public String[] getEnabledCipherSuites() {
String[] varE73CF5FBDF510EEFDF00C7E4AF85C310_1771930863 =         sslParameters.getEnabledCipherSuites();
        varE73CF5FBDF510EEFDF00C7E4AF85C310_1771930863.addTaint(taint);
        return varE73CF5FBDF510EEFDF00C7E4AF85C310_1771930863;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.987 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "A502E0EAAECE8396CE85A55C0A04C6E0")
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        addTaint(suites[0].getTaint());
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.987 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "605676A0B7BD69E2E9B37510F839D50B")
    @Override
    public String[] getSupportedProtocols() {
String[] varCE68CF4030A908DFE590B8EDFA039BDD_880193119 =         ProtocolVersion.supportedProtocols.clone();
        varCE68CF4030A908DFE590B8EDFA039BDD_880193119.addTaint(taint);
        return varCE68CF4030A908DFE590B8EDFA039BDD_880193119;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.987 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "6220C7C7A1B7F2A0CFDA311F5A9520C5")
    @Override
    public String[] getEnabledProtocols() {
String[] var845A46B817F78B5E0728F82AD0FF52E6_565331422 =         sslParameters.getEnabledProtocols();
        var845A46B817F78B5E0728F82AD0FF52E6_565331422.addTaint(taint);
        return var845A46B817F78B5E0728F82AD0FF52E6_565331422;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.988 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "CCBC6F8DD000D5739B00A3E9F868DB1C")
    @Override
    public void setEnabledProtocols(String[] protocols) {
        addTaint(protocols[0].getTaint());
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.988 -0400", hash_original_method = "8643AE5368ED569DA5125D94D54A9561", hash_generated_method = "9CEFA181994B0608B86FA013B8205C38")
    @Override
    public void setUseClientMode(boolean mode) {
        addTaint(mode);
    if(handshake_started)        
        {
            IllegalArgumentException var090A9C2074D1C9D942FE5C4CFD7155B6_2094441182 = new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
            var090A9C2074D1C9D942FE5C4CFD7155B6_2094441182.addTaint(taint);
            throw var090A9C2074D1C9D942FE5C4CFD7155B6_2094441182;
        } //End block
        sslParameters.setUseClientMode(mode);
        peer_mode_was_set = true;
        // ---------- Original Method ----------
        //if (handshake_started) {
            //throw new IllegalArgumentException(
            //"Could not change the mode after the initial handshake has begun.");
        //}
        //sslParameters.setUseClientMode(mode);
        //peer_mode_was_set = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.988 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "EFA4A0AF531F645E0D1A14F143397A19")
    @Override
    public boolean getUseClientMode() {
        boolean var264C485BBAEC609C8CEC6E380F554AB0_1755439100 = (sslParameters.getUseClientMode());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1411909793 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1411909793;
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.988 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "BA7C72106D7ACD8A3990718038741929")
    @Override
    public void setNeedClientAuth(boolean need) {
        addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.989 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "720621A792312ABC16A55B0FE1CA4145")
    @Override
    public boolean getNeedClientAuth() {
        boolean var8775D3F02F22101BF43E8B27516BBE95_1464018801 = (sslParameters.getNeedClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544423507 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544423507;
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.989 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "09030FB81E24A5D701A15381DB305A48")
    @Override
    public void setWantClientAuth(boolean want) {
        addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.989 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "1482DCA141727BF04E717C8151DD93E1")
    @Override
    public boolean getWantClientAuth() {
        boolean var49776A2797A76D9AE0E32B9F61634A24_612551663 = (sslParameters.getWantClientAuth());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1843047224 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1843047224;
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.989 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "85CCF52EB3F74FECC3630ABAAC720430")
    @Override
    public void setEnableSessionCreation(boolean flag) {
        addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.989 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "0502D03BA6DC85BB187CB0E04D818FEE")
    @Override
    public boolean getEnableSessionCreation() {
        boolean var6A496EF2CB1B11366741370C45064742_2079216937 = (sslParameters.getEnableSessionCreation());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1130432859 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1130432859;
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.990 -0400", hash_original_method = "74D7DA825347EF6AE406AA95D0E4A742", hash_generated_method = "1E7DE8E09B9C3615BC8F4A20F9A5FA4A")
    @Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
    if(!handshake_started || engine_was_shutteddown)        
        {
SSLEngineResult.HandshakeStatus var68E71D62754FEACD6A50A6182D14BA78_1934193251 =             SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            var68E71D62754FEACD6A50A6182D14BA78_1934193251.addTaint(taint);
            return var68E71D62754FEACD6A50A6182D14BA78_1934193251;
        } //End block
    if(alertProtocol.hasAlert())        
        {
SSLEngineResult.HandshakeStatus varD93BC47E4428FB80139BCF884A7D0255_2124422952 =             SSLEngineResult.HandshakeStatus.NEED_WRAP;
            varD93BC47E4428FB80139BCF884A7D0255_2124422952.addTaint(taint);
            return varD93BC47E4428FB80139BCF884A7D0255_2124422952;
        } //End block
    if(close_notify_was_sent && !close_notify_was_received)        
        {
SSLEngineResult.HandshakeStatus var410FAE431F4BF2BADF6C4EA25EB0AEE4_1298338191 =             SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
            var410FAE431F4BF2BADF6C4EA25EB0AEE4_1298338191.addTaint(taint);
            return var410FAE431F4BF2BADF6C4EA25EB0AEE4_1298338191;
        } //End block
SSLEngineResult.HandshakeStatus varF38C42C93424F1FD62AE648E094A376F_1663606764 =         handshakeProtocol.getStatus();
        varF38C42C93424F1FD62AE648E094A376F_1663606764.addTaint(taint);
        return varF38C42C93424F1FD62AE648E094A376F_1663606764;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.990 -0400", hash_original_method = "FEA3CA8E78DB1766A0752130C49C073D", hash_generated_method = "072951ECC69CE4EA60932EE5DC66E4A4")
    @Override
    public SSLSession getSession() {
    if(session != null)        
        {
SSLSession varD555E544A66E0F97DA6BCDE940E3E79C_1511016690 =             session;
            varD555E544A66E0F97DA6BCDE940E3E79C_1511016690.addTaint(taint);
            return varD555E544A66E0F97DA6BCDE940E3E79C_1511016690;
        } //End block
SSLSession var33266EACB2455415ED08B160E2815F03_844412908 =         SSLSessionImpl.NULL_SESSION;
        var33266EACB2455415ED08B160E2815F03_844412908.addTaint(taint);
        return var33266EACB2455415ED08B160E2815F03_844412908;
        // ---------- Original Method ----------
        //if (session != null) {
            //return session;
        //}
        //return SSLSessionImpl.NULL_SESSION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.991 -0400", hash_original_method = "93B7BEFDB685497BB8E88252AEDDD652", hash_generated_method = "0C0D8734043B3C34686D9A4AD1D205A1")
    @Override
    public boolean isInboundDone() {
        boolean var6D68D16BCF179B07C3299B10E6B5F71F_1277191990 = (isInboundDone || engine_was_closed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723765480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723765480;
        // ---------- Original Method ----------
        //return isInboundDone || engine_was_closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.991 -0400", hash_original_method = "120A166126F4C5B7FB727570FC11E1A2", hash_generated_method = "81FCD03A51DF41D06EECBB48441D5B3E")
    @Override
    public boolean isOutboundDone() {
        boolean var59E72EB7F048BC58F04803B57A425B19_184831308 = (isOutboundDone);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_598959009 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_598959009;
        // ---------- Original Method ----------
        //return isOutboundDone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.044 -0400", hash_original_method = "F6CF6D1723C677ECF3CA7B0D6EA7AC86", hash_generated_method = "4C1D006164330D9FE33DD70D6DD142DF")
    @Override
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts,
                                int offset, int length) throws SSLException {
        addTaint(length);
        addTaint(offset);
        addTaint(dsts[0].getTaint());
        addTaint(src.getTaint());
    if(engine_was_shutteddown)        
        {
SSLEngineResult var155DFB8E78EC17A1A9AE2D5AAAEE9884_1155140761 =             new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
            var155DFB8E78EC17A1A9AE2D5AAAEE9884_1155140761.addTaint(taint);
            return var155DFB8E78EC17A1A9AE2D5AAAEE9884_1155140761;
        } //End block
    if((src == null) || (dsts == null))        
        {
            IllegalStateException var205149AF7ED940A9AB9D4D1787309CCB_1751059711 = new IllegalStateException(
                    "Some of the input parameters are null");
            var205149AF7ED940A9AB9D4D1787309CCB_1751059711.addTaint(taint);
            throw var205149AF7ED940A9AB9D4D1787309CCB_1751059711;
        } //End block
    if(!handshake_started)        
        {
            beginHandshake();
        } //End block
        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
    if((session == null || engine_was_closed) && (
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP) ||
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)))        
        {
SSLEngineResult varD0FB369D5F22F48EBC24E2509C60D37F_8042903 =             new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            varD0FB369D5F22F48EBC24E2509C60D37F_8042903.addTaint(taint);
            return varD0FB369D5F22F48EBC24E2509C60D37F_8042903;
        } //End block
    if(src.remaining() < recordProtocol.getMinRecordSize())        
        {
SSLEngineResult var3ABD5BF379F67729A0D0FC3A24A9D2C8_61900926 =             new SSLEngineResult(
                    SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
            var3ABD5BF379F67729A0D0FC3A24A9D2C8_61900926.addTaint(taint);
            return var3ABD5BF379F67729A0D0FC3A24A9D2C8_61900926;
        } //End block
        try 
        {
            src.mark();
            int capacity = 0;
for(int i=offset;i<offset+length;i++)
            {
    if(dsts[i] == null)                
                {
                    IllegalStateException var205149AF7ED940A9AB9D4D1787309CCB_1042557064 = new IllegalStateException(
                            "Some of the input parameters are null");
                    var205149AF7ED940A9AB9D4D1787309CCB_1042557064.addTaint(taint);
                    throw var205149AF7ED940A9AB9D4D1787309CCB_1042557064;
                } //End block
    if(dsts[i].isReadOnly())                
                {
                    ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_2137497527 = new ReadOnlyBufferException();
                    varA14F16C43B102D90B34008C8FF8087F8_2137497527.addTaint(taint);
                    throw varA14F16C43B102D90B34008C8FF8087F8_2137497527;
                } //End block
                capacity += dsts[i].remaining();
            } //End block
    if(capacity < recordProtocol.getDataSize(src.remaining()))            
            {
SSLEngineResult varFE220BCF95A2154805491D9C5E83BD35_1360344533 =                 new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        getHandshakeStatus(), 0, 0);
                varFE220BCF95A2154805491D9C5E83BD35_1360344533.addTaint(taint);
                return varFE220BCF95A2154805491D9C5E83BD35_1360344533;
            } //End block
            recProtIS.setSourceBuffer(src);
            int type = recordProtocol.unwrap();
switch(type){
            case ContentType.HANDSHAKE:
            case ContentType.CHANGE_CIPHER_SPEC:
    if(handshakeProtocol.getStatus().equals(
                            SSLEngineResult.HandshakeStatus.FINISHED))            
            {
                session = recordProtocol.getSession();
            } //End block
            break;
            case ContentType.APPLICATION_DATA:
            break;
            case ContentType.ALERT:
    if(alertProtocol.isFatalAlert())            
            {
                alertProtocol.setProcessed();
    if(session != null)                
                {
                    session.invalidate();
                } //End block
                String description = "Fatal alert received "
                            + alertProtocol.getAlertDescription();
                shutdown();
                SSLException var30A4E97391385D7A4E772B8C367E9DCB_982064011 = new SSLException(description);
                var30A4E97391385D7A4E772B8C367E9DCB_982064011.addTaint(taint);
                throw var30A4E97391385D7A4E772B8C367E9DCB_982064011;
            } //End block
            else
            {
    if(logger != null)                
                {
                    logger.println("Warning allert has been received: "
                                + alertProtocol.getAlertDescription());
                } //End block
switch(alertProtocol.getDescriptionCode()){
                case AlertProtocol.CLOSE_NOTIFY:
                alertProtocol.setProcessed();
                close_notify_was_received = true;
    if(!close_notify_was_sent)                
                {
                    closeOutbound();
                    closeInbound();
                } //End block
                else
                {
                    closeInbound();
                    shutdown();
                } //End block
                break;
                case AlertProtocol.NO_RENEGOTIATION:
                alertProtocol.setProcessed();
    if(session == null)                
                {
                    AlertException var84A264ED7FCD9F31B3114CFB53292D37_1957513066 = new AlertException(
                                        AlertProtocol.HANDSHAKE_FAILURE,
                                        new SSLHandshakeException(
                                            "Received no_renegotiation "
                                            + "during the initial handshake"));
                    var84A264ED7FCD9F31B3114CFB53292D37_1957513066.addTaint(taint);
                    throw var84A264ED7FCD9F31B3114CFB53292D37_1957513066;
                } //End block
                else
                {
                    handshakeProtocol.stop();
                } //End block
                break;
                default:
                alertProtocol.setProcessed();
}
            } //End block
            break;
}SSLEngineResult var2C5CB397E79B7C0C2BCAA114FDEFB14C_1066619629 =             new SSLEngineResult(getEngineStatus(), getHandshakeStatus(),
                    recProtIS.consumed(),
                    appData.placeTo(dsts, offset, length));
            var2C5CB397E79B7C0C2BCAA114FDEFB14C_1066619629.addTaint(taint);
            return var2C5CB397E79B7C0C2BCAA114FDEFB14C_1066619629;
        } //End block
        catch (BufferUnderflowException e)
        {
            src.reset();
SSLEngineResult var3ABD5BF379F67729A0D0FC3A24A9D2C8_722964119 =             new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
            var3ABD5BF379F67729A0D0FC3A24A9D2C8_722964119.addTaint(taint);
            return var3ABD5BF379F67729A0D0FC3A24A9D2C8_722964119;
        } //End block
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            src.reset();
    if(session != null)            
            {
                session.invalidate();
            } //End block
            javax.net.ssl.SSLException var6595BE9A223029F6497D8D8537E199F6_559650810 = e.getReason();
            var6595BE9A223029F6497D8D8537E199F6_559650810.addTaint(taint);
            throw var6595BE9A223029F6497D8D8537E199F6_559650810;
        } //End block
        catch (SSLException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (IOException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL,
                    AlertProtocol.INTERNAL_ERROR);
            engine_was_closed = true;
            SSLException var3E723685209F41E8F42A97C21BFF864F_991345750 = new SSLException(e.getMessage());
            var3E723685209F41E8F42A97C21BFF864F_991345750.addTaint(taint);
            throw var3E723685209F41E8F42A97C21BFF864F_991345750;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.075 -0400", hash_original_method = "4D503F6FEFF5A6DB6E7618C8A28327D4", hash_generated_method = "03507FF074A5EBBD2122035271182DC8")
    @Override
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset,
                            int len, ByteBuffer dst) throws SSLException {
        addTaint(dst.getTaint());
        addTaint(len);
        addTaint(offset);
        addTaint(srcs[0].getTaint());
    if(engine_was_shutteddown)        
        {
SSLEngineResult var155DFB8E78EC17A1A9AE2D5AAAEE9884_1363914533 =             new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
            var155DFB8E78EC17A1A9AE2D5AAAEE9884_1363914533.addTaint(taint);
            return var155DFB8E78EC17A1A9AE2D5AAAEE9884_1363914533;
        } //End block
    if((srcs == null) || (dst == null))        
        {
            IllegalStateException var205149AF7ED940A9AB9D4D1787309CCB_2044423786 = new IllegalStateException(
                    "Some of the input parameters are null");
            var205149AF7ED940A9AB9D4D1787309CCB_2044423786.addTaint(taint);
            throw var205149AF7ED940A9AB9D4D1787309CCB_2044423786;
        } //End block
    if(dst.isReadOnly())        
        {
            ReadOnlyBufferException varA14F16C43B102D90B34008C8FF8087F8_453013281 = new ReadOnlyBufferException();
            varA14F16C43B102D90B34008C8FF8087F8_453013281.addTaint(taint);
            throw varA14F16C43B102D90B34008C8FF8087F8_453013281;
        } //End block
    if(!handshake_started)        
        {
            beginHandshake();
        } //End block
        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
    if((session == null || engine_was_closed) && (
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_UNWRAP) ||
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)))        
        {
SSLEngineResult varD0FB369D5F22F48EBC24E2509C60D37F_1165146805 =             new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
            varD0FB369D5F22F48EBC24E2509C60D37F_1165146805.addTaint(taint);
            return varD0FB369D5F22F48EBC24E2509C60D37F_1165146805;
        } //End block
        int capacity = dst.remaining();
        int produced = 0;
    if(alertProtocol.hasAlert())        
        {
    if(capacity < recordProtocol.getRecordSize(2))            
            {
SSLEngineResult varC99A53ED80EC3AF6115535C0533EB387_994751447 =                 new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
                varC99A53ED80EC3AF6115535C0533EB387_994751447.addTaint(taint);
                return varC99A53ED80EC3AF6115535C0533EB387_994751447;
            } //End block
            byte[] alert_data = alertProtocol.wrap();
            dst.put(alert_data);
    if(alertProtocol.isFatalAlert())            
            {
                alertProtocol.setProcessed();
    if(session != null)                
                {
                    session.invalidate();
                } //End block
                shutdown();
SSLEngineResult var38CDF9E371E69CC58975ADB5ADF17A73_793860566 =                 new SSLEngineResult(
                        SSLEngineResult.Status.CLOSED,
                        SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                        0, alert_data.length);
                var38CDF9E371E69CC58975ADB5ADF17A73_793860566.addTaint(taint);
                return var38CDF9E371E69CC58975ADB5ADF17A73_793860566;
            } //End block
            else
            {
                alertProtocol.setProcessed();
    if(close_notify_was_sent && close_notify_was_received)                
                {
                    shutdown();
SSLEngineResult var38CDF9E371E69CC58975ADB5ADF17A73_2009119429 =                     new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                            SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                            0, alert_data.length);
                    var38CDF9E371E69CC58975ADB5ADF17A73_2009119429.addTaint(taint);
                    return var38CDF9E371E69CC58975ADB5ADF17A73_2009119429;
                } //End block
SSLEngineResult var1C6903D47C06D12F818E8BE274D7425E_1617312667 =                 new SSLEngineResult(
                        getEngineStatus(),
                        getHandshakeStatus(),
                        0, alert_data.length);
                var1C6903D47C06D12F818E8BE274D7425E_1617312667.addTaint(taint);
                return var1C6903D47C06D12F818E8BE274D7425E_1617312667;
            } //End block
        } //End block
    if(capacity < recordProtocol.getMinRecordSize())        
        {
    if(logger != null)            
            {
                logger.println("Capacity of the destination("
                        +capacity+") < MIN_PACKET_SIZE("
                        +recordProtocol.getMinRecordSize()+")");
            } //End block
SSLEngineResult varC99A53ED80EC3AF6115535C0533EB387_7465093 =             new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
            varC99A53ED80EC3AF6115535C0533EB387_7465093.addTaint(taint);
            return varC99A53ED80EC3AF6115535C0533EB387_7465093;
        } //End block
        try 
        {
    if(!handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP))            
            {
                dataStream.setSourceBuffers(srcs, offset, len);
    if((capacity < SSLRecordProtocol.MAX_SSL_PACKET_SIZE) &&
                    (capacity < recordProtocol.getRecordSize(
                                                 dataStream.available())))                
                {
    if(logger != null)                    
                    {
                        logger.println("The destination buffer("
                                +capacity+") can not take the resulting packet("
                                + recordProtocol.getRecordSize(
                                    dataStream.available())+")");
                    } //End block
SSLEngineResult varC99A53ED80EC3AF6115535C0533EB387_1576443388 =                     new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                    varC99A53ED80EC3AF6115535C0533EB387_1576443388.addTaint(taint);
                    return varC99A53ED80EC3AF6115535C0533EB387_1576443388;
                } //End block
    if(remaining_wrapped_data == null)                
                {
                    remaining_wrapped_data =
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                dataStream);
                } //End block
    if(capacity < remaining_wrapped_data.length)                
                {
SSLEngineResult varE59D8F9B21A30D6A85DDF53467EDC310_1551395010 =                     new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, dataStream.consumed(), 0);
                    varE59D8F9B21A30D6A85DDF53467EDC310_1551395010.addTaint(taint);
                    return varE59D8F9B21A30D6A85DDF53467EDC310_1551395010;
                } //End block
                else
                {
                    dst.put(remaining_wrapped_data);
                    produced = remaining_wrapped_data.length;
                    remaining_wrapped_data = null;
SSLEngineResult var94C8E30648DF5E315A644E7D34BB8872_321807460 =                     new SSLEngineResult(getEngineStatus(),
                            handshakeStatus, dataStream.consumed(), produced);
                    var94C8E30648DF5E315A644E7D34BB8872_321807460.addTaint(taint);
                    return var94C8E30648DF5E315A644E7D34BB8872_321807460;
                } //End block
            } //End block
            else
            {
    if(remaining_hsh_data == null)                
                {
                    remaining_hsh_data = handshakeProtocol.wrap();
                } //End block
    if(capacity < remaining_hsh_data.length)                
                {
SSLEngineResult varC99A53ED80EC3AF6115535C0533EB387_1950456018 =                     new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                    varC99A53ED80EC3AF6115535C0533EB387_1950456018.addTaint(taint);
                    return varC99A53ED80EC3AF6115535C0533EB387_1950456018;
                } //End block
                else
                {
                    dst.put(remaining_hsh_data);
                    produced = remaining_hsh_data.length;
                    remaining_hsh_data = null;
                    handshakeStatus = handshakeProtocol.getStatus();
    if(handshakeStatus.equals(
                            SSLEngineResult.HandshakeStatus.FINISHED))                    
                    {
                        session = recordProtocol.getSession();
                    } //End block
                } //End block
SSLEngineResult varBEA709060994944EF40F7489BDF50675_336372061 =                 new SSLEngineResult(
                        getEngineStatus(), getHandshakeStatus(), 0, produced);
                varBEA709060994944EF40F7489BDF50675_336372061.addTaint(taint);
                return varBEA709060994944EF40F7489BDF50675_336372061;
            } //End block
        } //End block
        catch (AlertException e)
        {
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
    if(session != null)            
            {
                session.invalidate();
            } //End block
            javax.net.ssl.SSLException var6595BE9A223029F6497D8D8537E199F6_1836209656 = e.getReason();
            var6595BE9A223029F6497D8D8537E199F6_1836209656.addTaint(taint);
            throw var6595BE9A223029F6497D8D8537E199F6_1836209656;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.081 -0400", hash_original_method = "2E4498D8774C920317F596FEB8E0DACF", hash_generated_method = "6154C95F34A00564A3C2B515E4F5A9F3")
    private void shutdown() {
        engine_was_closed = true;
        engine_was_shutteddown = true;
        isOutboundDone = true;
        isInboundDone = true;
    if(handshake_started)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:33.081 -0400", hash_original_method = "C6B39897E63E44773E5CEE8467983722", hash_generated_method = "07C3BB5DF95A246569D3BF9F98FD5154")
    private SSLEngineResult.Status getEngineStatus() {
SSLEngineResult.Status var925E923E0431B37FC45FA5E1D17248C1_652666755 =         (engine_was_closed)
            ? SSLEngineResult.Status.CLOSED
            : SSLEngineResult.Status.OK;
        var925E923E0431B37FC45FA5E1D17248C1_652666755.addTaint(taint);
        return var925E923E0431B37FC45FA5E1D17248C1_652666755;
        // ---------- Original Method ----------
        //return (engine_was_closed)
            //? SSLEngineResult.Status.CLOSED
            //: SSLEngineResult.Status.OK;
    }

    
}

