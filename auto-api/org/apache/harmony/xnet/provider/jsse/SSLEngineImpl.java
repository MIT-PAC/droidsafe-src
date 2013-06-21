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
    private boolean peer_mode_was_set = false;
    private boolean handshake_started = false;
    private boolean isInboundDone = false;
    private boolean isOutboundDone = false;
    private boolean close_notify_was_sent = false;
    private boolean close_notify_was_received = false;
    private boolean engine_was_closed = false;
    private boolean engine_was_shutteddown = false;
    protected SSLRecordProtocol recordProtocol;
    private SSLBufferedInput recProtIS;
    private HandshakeProtocol handshakeProtocol;
    private AlertProtocol alertProtocol;
    private SSLEngineAppData appData;
    private SSLEngineDataStream dataStream = new SSLEngineDataStream();
    private SSLSessionImpl session;
    protected SSLParametersImpl sslParameters;
    private byte[] remaining_wrapped_data = null;
    private byte[] remaining_hsh_data = null;
    private Logger.Stream logger = Logger.getStream("engine");
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.123 -0400", hash_original_method = "1C2B310D768BCE8FE406784210BB6A4F", hash_generated_method = "2DA08159376CD24F87AB20D49103BD41")
    @DSModeled(DSC.SAFE)
    protected SSLEngineImpl(SSLParametersImpl sslParameters) {
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.123 -0400", hash_original_method = "399A1B6B7D3996FC39BEE7E87B5F152E", hash_generated_method = "805E0DA542423D1AAE7278B36ACEC07E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLEngineImpl(String host, int port, SSLParametersImpl sslParameters) {
        super(host, port);
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        dsTaint.addTaint(sslParameters.dsTaint);
        // ---------- Original Method ----------
        //this.sslParameters = sslParameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.124 -0400", hash_original_method = "C9E26C97B00AD59FF47E5A96B3855814", hash_generated_method = "7CF13AA30C7311A17A079A032D10E019")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                boolean varD3A3B98B1AB89C5D601DFF15338516F8_2024886916 = (getUseClientMode());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.124 -0400", hash_original_method = "2833A66A573FEB90891C13E00C93BD47", hash_generated_method = "3189E9D7150A6A0E1DE2A7DE74C5BCB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.124 -0400", hash_original_method = "194E237603CA4A7D605DF99CBAD71850", hash_generated_method = "F269323587B99EEB025EB87312B376EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "C14CDBA62113C37F04E8CCD08C8FFAF5", hash_generated_method = "CC39B693E3E2C0730A7EE2F127847A22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Runnable getDelegatedTask() {
        Runnable var08AAEED6641DC97C2BB8CC8F03D86571_718004832 = (handshakeProtocol.getTask());
        return (Runnable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return handshakeProtocol.getTask();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "535D1B89B5463B55994AB438C5310A0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedCipherSuites() {
        String[] var7538431C68A39BDF527B3279B9F226C5_1892387690 = (CipherSuite.getSupportedCipherSuiteNames());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return CipherSuite.getSupportedCipherSuiteNames();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "203838DAC6B2AB279CE23F4595E00D82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledCipherSuites() {
        String[] varC3ED4EB907904E69984EFC846C8D14D7_1825343351 = (sslParameters.getEnabledCipherSuites());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledCipherSuites();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "9E1BD0F36B086A8B521F2689941AD1AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
        sslParameters.setEnabledCipherSuites(suites);
        // ---------- Original Method ----------
        //sslParameters.setEnabledCipherSuites(suites);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "8DCC77A9E7EE005B2A7B6594977D0987")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getSupportedProtocols() {
        String[] var783FADE499BFC8C3457949EAB555903E_1768193741 = (ProtocolVersion.supportedProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return ProtocolVersion.supportedProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "24D39535E4CF3180481C3D9816962EF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] getEnabledProtocols() {
        String[] varA33B229DEE35C74B9811610CA888B1B5_1338734459 = (sslParameters.getEnabledProtocols());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return sslParameters.getEnabledProtocols();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.125 -0400", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "98EB9B5352B74ED52E4191B5D05D71C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
        sslParameters.setEnabledProtocols(protocols);
        // ---------- Original Method ----------
        //sslParameters.setEnabledProtocols(protocols);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.126 -0400", hash_original_method = "8643AE5368ED569DA5125D94D54A9561", hash_generated_method = "6EFE9E963D806006F4362BC1F3678990")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.126 -0400", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "9379F05C2E0ECB21D4BBC0CDDFA227DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getUseClientMode() {
        boolean var5D6C317C7C34AA34FED4DDA3BFA46DAC_1517187686 = (sslParameters.getUseClientMode());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getUseClientMode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.126 -0400", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "6CC5B77D04C22EF0B7C8D76FE3C5FE68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        sslParameters.setNeedClientAuth(need);
        // ---------- Original Method ----------
        //sslParameters.setNeedClientAuth(need);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.126 -0400", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "7840FAB8CC9845AE0808257421FDECFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getNeedClientAuth() {
        boolean var666666A183221FEF9E4AC429A4F2FC13_1867431975 = (sslParameters.getNeedClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getNeedClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.126 -0400", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "3CF93375E2EDE097483BB86B9A2A6364")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        sslParameters.setWantClientAuth(want);
        // ---------- Original Method ----------
        //sslParameters.setWantClientAuth(want);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "4B47F57F209A98C3F5537C46D615955F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getWantClientAuth() {
        boolean var1F88322EA2F28C29D3EC82222D21AA46_797304822 = (sslParameters.getWantClientAuth());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getWantClientAuth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "1CEC5C88A393CCF6951D2A9AC29A0DA8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        sslParameters.setEnableSessionCreation(flag);
        // ---------- Original Method ----------
        //sslParameters.setEnableSessionCreation(flag);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "599D320404C83EBE08D33FE455FF955A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean getEnableSessionCreation() {
        boolean varAFF7A8ADF82548D8DE353C67D9576F3E_2029238021 = (sslParameters.getEnableSessionCreation());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return sslParameters.getEnableSessionCreation();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "74D7DA825347EF6AE406AA95D0E4A742", hash_generated_method = "44FE682BE8D89214415960043A1EB6DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_51646036 = (alertProtocol.hasAlert());
        } //End collapsed parenthetic
        SSLEngineResult.HandshakeStatus var7141B2489D13757E0C411C780F445F15_56340262 = (handshakeProtocol.getStatus());
        return (SSLEngineResult.HandshakeStatus)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "FEA3CA8E78DB1766A0752130C49C073D", hash_generated_method = "C5BB084375143B5C4F369C30B6BEDA02")
    @DSModeled(DSC.SAFE)
    @Override
    public SSLSession getSession() {
        return (SSLSession)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (session != null) {
            //return session;
        //}
        //return SSLSessionImpl.NULL_SESSION;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.127 -0400", hash_original_method = "93B7BEFDB685497BB8E88252AEDDD652", hash_generated_method = "72BD9DBAD68D530B562EC7306847990D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isInboundDone() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isInboundDone || engine_was_closed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.128 -0400", hash_original_method = "120A166126F4C5B7FB727570FC11E1A2", hash_generated_method = "C2588FF24D8E9691AC86D95065B61B42")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isOutboundDone() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isOutboundDone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.129 -0400", hash_original_method = "F6CF6D1723C677ECF3CA7B0D6EA7AC86", hash_generated_method = "A007547287AD78B052F86DD2ADC310F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts,
                                int offset, int length) throws SSLException {
        dsTaint.addTaint(dsts[0].dsTaint);
        dsTaint.addTaint(length);
        dsTaint.addTaint(src.dsTaint);
        dsTaint.addTaint(offset);
        {
            SSLEngineResult var7E5E4DC34C0FF9BDF2C3472F0757D323_2069655666 = (new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0));
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
            boolean varBAECE7682DA8E288BBC6FAB3928B20A7_1702388114 = ((session == null || engine_was_closed) && (
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP) ||
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                SSLEngineResult varEAE0B204AA60139D245D3279697DEB27_641015178 = (new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var7CB7F8820E6FE7BA16FA809B4AF09898_454219379 = (src.remaining() < recordProtocol.getMinRecordSize());
            {
                SSLEngineResult var50181822528B5955E10C32C8C17A7C98_70569660 = (new SSLEngineResult(
                    SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0));
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
                        boolean varABE2E5A62BD09C290D04797BA3FDE495_2055676312 = (dsts[i].isReadOnly());
                        {
                            if (DroidSafeAndroidRuntime.control) throw new ReadOnlyBufferException();
                        } //End block
                    } //End collapsed parenthetic
                    capacity += dsts[i].remaining();
                } //End block
            } //End collapsed parenthetic
            {
                boolean var42B9869E086C4444677BC2C6EB9C6DC5_313585394 = (capacity < recordProtocol.getDataSize(src.remaining()));
                {
                    SSLEngineResult varA689D5E72F2AF4AC0433575B4C0B1378_663048987 = (new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        getHandshakeStatus(), 0, 0));
                } //End block
            } //End collapsed parenthetic
            recProtIS.setSourceBuffer(src);
            int type;
            type = recordProtocol.unwrap();
            //Begin case ContentType.HANDSHAKE ContentType.CHANGE_CIPHER_SPEC 
            {
                boolean var9D33EDAC6D221E1C1A7877165F01AA35_139261004 = (handshakeProtocol.getStatus().equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                {
                    session = recordProtocol.getSession();
                } //End block
            } //End collapsed parenthetic
            //End case ContentType.HANDSHAKE ContentType.CHANGE_CIPHER_SPEC 
            //Begin case ContentType.ALERT 
            {
                boolean var421E7BAA85D40FC415472A07983EC7FA_214771771 = (alertProtocol.isFatalAlert());
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
                        Object varF26DEB029A4082B6DE95442C45AA531E_971168975 = (alertProtocol.getDescriptionCode());
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
            SSLEngineResult var385039537BDAE7EFEB1494A26F2CEDDE_1576813821 = (new SSLEngineResult(getEngineStatus(), getHandshakeStatus(),
                    recProtIS.consumed(),
                    appData.placeTo(dsts, offset, length)));
        } //End block
        catch (BufferUnderflowException e)
        {
            src.reset();
            SSLEngineResult varF37CF24E7B2C14C52851FA5E48C229FF_1768890944 = (new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0));
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
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.130 -0400", hash_original_method = "4D503F6FEFF5A6DB6E7618C8A28327D4", hash_generated_method = "511391CE2833B5BF0983186686830C1C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset,
                            int len, ByteBuffer dst) throws SSLException {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        dsTaint.addTaint(srcs[0].dsTaint);
        {
            SSLEngineResult var7E5E4DC34C0FF9BDF2C3472F0757D323_657806174 = (new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0));
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Some of the input parameters are null");
        } //End block
        {
            boolean var45C27560C2BDC5437CAF1B5DEC7559EF_1931068096 = (dst.isReadOnly());
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
            boolean varCA637BAACDB0BB5B3DC8E7EA5C3B4866_1434519399 = ((session == null || engine_was_closed) && (
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_UNWRAP) ||
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK)));
            {
                SSLEngineResult varEAE0B204AA60139D245D3279697DEB27_954952913 = (new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0));
            } //End block
        } //End collapsed parenthetic
        int capacity;
        capacity = dst.remaining();
        int produced;
        produced = 0;
        {
            boolean varA52FAF2DC39046381FEF43FA0104C75B_1412934601 = (alertProtocol.hasAlert());
            {
                {
                    boolean var2E387AFA09379ED6A8A77D9181EA9203_751412495 = (capacity < recordProtocol.getRecordSize(2));
                    {
                        SSLEngineResult var1FD141249B907DFE0FD0F92F51767785_472359786 = (new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0));
                    } //End block
                } //End collapsed parenthetic
                byte[] alert_data;
                alert_data = alertProtocol.wrap();
                dst.put(alert_data);
                {
                    boolean varE8538EAB39A9EEDECFE745A4C142519C_487840814 = (alertProtocol.isFatalAlert());
                    {
                        alertProtocol.setProcessed();
                        {
                            session.invalidate();
                        } //End block
                        shutdown();
                        SSLEngineResult varF76688E2DCAE893FE7239D2A43C1C686_1863870432 = (new SSLEngineResult(
                        SSLEngineResult.Status.CLOSED,
                        SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                        0, alert_data.length));
                    } //End block
                    {
                        alertProtocol.setProcessed();
                        {
                            shutdown();
                            SSLEngineResult varBA3F554289E33A7155C0B06D98FDEB37_129780900 = (new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                            SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                            0, alert_data.length));
                        } //End block
                        SSLEngineResult varC34AE7E92E982EECE1405F11421F8FB2_241597446 = (new SSLEngineResult(
                        getEngineStatus(),
                        getHandshakeStatus(),
                        0, alert_data.length));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var0EB0B6901228962450A57485F383904A_699547467 = (capacity < recordProtocol.getMinRecordSize());
            {
                {
                    logger.println("Capacity of the destination("
                        +capacity+") < MIN_PACKET_SIZE("
                        +recordProtocol.getMinRecordSize()+")");
                } //End block
                SSLEngineResult var86C4CA0BB40EBA5A90F36E3DA43BB912_2128799459 = (new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0));
            } //End block
        } //End collapsed parenthetic
        try 
        {
            {
                boolean var26A202D1540C87FD4D5B941AC813E7AA_639442172 = (!handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP));
                {
                    dataStream.setSourceBuffers(srcs, offset, len);
                    {
                        boolean varACD5D72B7ADB189B1CB41D8641229159_2071308529 = ((capacity < SSLRecordProtocol.MAX_SSL_PACKET_SIZE) &&
                    (capacity < recordProtocol.getRecordSize(
                                                 dataStream.available())));
                        {
                            {
                                logger.println("The destination buffer("
                                +capacity+") can not take the resulting packet("
                                + recordProtocol.getRecordSize(
                                    dataStream.available())+")");
                            } //End block
                            SSLEngineResult var31450E1251452FF25CA153F91076ABE2_1888774215 = (new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0));
                        } //End block
                    } //End collapsed parenthetic
                    {
                        remaining_wrapped_data =
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                dataStream);
                    } //End block
                    {
                        SSLEngineResult var752A8408FD3D3C8E14311F0E4DF473F2_614557897 = (new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, dataStream.consumed(), 0));
                    } //End block
                    {
                        dst.put(remaining_wrapped_data);
                        produced = remaining_wrapped_data.length;
                        remaining_wrapped_data = null;
                        SSLEngineResult var3E648D0196A237CC6084064AA7D5D001_841096089 = (new SSLEngineResult(getEngineStatus(),
                            handshakeStatus, dataStream.consumed(), produced));
                    } //End block
                } //End block
                {
                    {
                        remaining_hsh_data = handshakeProtocol.wrap();
                    } //End block
                    {
                        SSLEngineResult varD2258D6A73563DED5C335FCDFA0E069A_319647379 = (new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0));
                    } //End block
                    {
                        dst.put(remaining_hsh_data);
                        produced = remaining_hsh_data.length;
                        remaining_hsh_data = null;
                        handshakeStatus = handshakeProtocol.getStatus();
                        {
                            boolean var4CD13050AAC00AFD2C83ECB27D501211_672323708 = (handshakeStatus.equals(
                            SSLEngineResult.HandshakeStatus.FINISHED));
                            {
                                session = recordProtocol.getSession();
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    SSLEngineResult var3CC46747543738731B736912179DA047_656379658 = (new SSLEngineResult(
                        getEngineStatus(), getHandshakeStatus(), 0, produced));
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
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.131 -0400", hash_original_method = "2E4498D8774C920317F596FEB8E0DACF", hash_generated_method = "8C621A488925C104801D7B92F36FF261")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.131 -0400", hash_original_method = "C6B39897E63E44773E5CEE8467983722", hash_generated_method = "0BFAA69484D1555D5CC3A8C5D671F531")
    @DSModeled(DSC.SAFE)
    private SSLEngineResult.Status getEngineStatus() {
        return (SSLEngineResult.Status)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (engine_was_closed)
            //? SSLEngineResult.Status.CLOSED
            //: SSLEngineResult.Status.OK;
    }

    
}

