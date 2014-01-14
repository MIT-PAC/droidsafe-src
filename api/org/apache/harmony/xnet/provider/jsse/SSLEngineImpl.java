package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.820 -0500", hash_original_field = "8A6DEFF4AA86C1DEEEAEB5CE0D8D1777", hash_generated_field = "E654CE2FA30E1E8D898FBE3969CE5BA6")

    private boolean peer_mode_was_set = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.823 -0500", hash_original_field = "DD39B534563266F04E2B935538054204", hash_generated_field = "43A471CC626A390C3F42C96A293CE4F3")

    private boolean handshake_started = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.825 -0500", hash_original_field = "136C94C95CCF7B55D73A79CF4708267E", hash_generated_field = "537BCD10B20577D816D536B7EDFB0EE3")

    private boolean isInboundDone = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.827 -0500", hash_original_field = "39A32EFA8D6BD446983BE1F854C7A070", hash_generated_field = "21C2B63110EA37B8DBBBCF2E6ABCB0C5")

    private boolean isOutboundDone = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.829 -0500", hash_original_field = "C87F662F04ADF0CC75CBBE88B8E2F2CD", hash_generated_field = "0F2AABB7E4332770B73BAB937514BD0D")

    private boolean close_notify_was_sent = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.832 -0500", hash_original_field = "7013C98374FACDAB5C3BA24641303394", hash_generated_field = "03323CA5EBF65F9CEB9F00CD95FE22FD")

    private boolean close_notify_was_received = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.835 -0500", hash_original_field = "41C553578785EA76B0EE4DA747FF38EA", hash_generated_field = "C50ED89FA5ABB54C45F9FD4E36500280")

    // all the works on it are done, except (probably) some finalizing work)
    private boolean engine_was_closed = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.837 -0500", hash_original_field = "4280FC2472410E517980CE572E52847A", hash_generated_field = "EEC1E0FE058E0AD25416983D3B012244")

    // all cleaning work had been done and the engine is not operable)
    private boolean engine_was_shutteddown = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.840 -0500", hash_original_field = "450F49BACBC7E7E38A182C4284626ACE", hash_generated_field = "EDC147518BA686E3DAEAF859EB64368C")

    protected SSLRecordProtocol recordProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.842 -0500", hash_original_field = "26A3C8A99FB9B2D67678F53514631744", hash_generated_field = "FC3A570B665E22F2CB948EFB2EF1D139")

    private SSLBufferedInput recProtIS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.844 -0500", hash_original_field = "C657785F6A0EDCF13D6ABCC66DA9658A", hash_generated_field = "1032E45BD599BACD8B5F207A3C5A48C0")

    private HandshakeProtocol handshakeProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.846 -0500", hash_original_field = "36D0D0F3C543230F133CC70A25806808", hash_generated_field = "7F98BE8FCC656C783F586E8BC58013DC")

    private AlertProtocol alertProtocol;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.849 -0500", hash_original_field = "27E5F7B6B81D90059FF6BCE292BC91BD", hash_generated_field = "ED6BE62BE19D8AB0377A63F127B6719A")

    private SSLEngineAppData appData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.851 -0500", hash_original_field = "581E5136537748E623D0189573F99534", hash_generated_field = "82EA68D6EF77B38A42F06A687812969F")

    private SSLEngineDataStream dataStream = new SSLEngineDataStream();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.853 -0500", hash_original_field = "2FEA9607120FF1F874D7A8B19B248896", hash_generated_field = "14A9356888CCC2F5828130712AD7BEEF")

    private SSLSessionImpl session;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.855 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.858 -0500", hash_original_field = "BAC5E93378091FA931065F43A840AFD2", hash_generated_field = "0432863EB08DECAB7C24492C4E956630")

    // placed in destination buffers it will be stored in this
    // fields
    private byte[] remaining_wrapped_data = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.860 -0500", hash_original_field = "2FE3B97BD848852CB168FFE17F128FAB", hash_generated_field = "7736556E778E3455D57F720F57447D0D")

    private byte[] remaining_hsh_data = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.863 -0500", hash_original_field = "C2098E37CCA2D49CE82A5825503B22B5", hash_generated_field = "45814449E3DD231F6EDFB081F6B3B7C8")

    private Logger.Stream logger = Logger.getStream("engine");

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.865 -0500", hash_original_method = "1C2B310D768BCE8FE406784210BB6A4F", hash_generated_method = "5B0AC4FA24CC5922FEEED89081C72FDD")
    
protected SSLEngineImpl(SSLParametersImpl sslParameters) {
        this.sslParameters = sslParameters;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.868 -0500", hash_original_method = "399A1B6B7D3996FC39BEE7E87B5F152E", hash_generated_method = "97ACEF881BDB50B13F1B0068D5CCA84C")
    
protected SSLEngineImpl(String host, int port, SSLParametersImpl sslParameters) {
        super(host, port);
        this.sslParameters = sslParameters;
    }

    /**
     * Starts the handshake.
     * @throws  SSLException
     * @see javax.net.ssl.SSLEngine#beginHandshake() method documentation
     * for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.871 -0500", hash_original_method = "C9E26C97B00AD59FF47E5A96B3855814", hash_generated_method = "764D4BBF450BE0F398C719E5BE26714A")
    
@Override
    public void beginHandshake() throws SSLException {
        if (engine_was_closed) {
            throw new SSLException("Engine has already been closed.");
        }
        if (!peer_mode_was_set) {
            throw new IllegalStateException("Client/Server mode was not set");
        }
        if (!handshake_started) {
            handshake_started = true;
            if (getUseClientMode()) {
                handshakeProtocol = new ClientHandshakeImpl(this);
            } else {
                handshakeProtocol = new ServerHandshakeImpl(this);
            }
            appData = new SSLEngineAppData();
            alertProtocol = new AlertProtocol();
            recProtIS = new SSLBufferedInput();
            recordProtocol = new SSLRecordProtocol(handshakeProtocol,
                    alertProtocol, recProtIS, appData);
        }
        handshakeProtocol.start();
    }

    /**
     * Closes inbound operations of this engine
     * @throws  SSLException
     * @see javax.net.ssl.SSLEngine#closeInbound() method documentation
     * for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.873 -0500", hash_original_method = "2833A66A573FEB90891C13E00C93BD47", hash_generated_method = "9523084F6775EEFC527B1FEA867C410E")
    
@Override
    public void closeInbound() throws SSLException {
        if (logger != null) {
            logger.println("closeInbound() "+isInboundDone);
        }
        if (isInboundDone) {
            return;
        }
        isInboundDone = true;
        engine_was_closed = true;
        if (handshake_started) {
            if (!close_notify_was_received) {
                if (session != null) {
                    session.invalidate();
                }
                alertProtocol.alert(AlertProtocol.FATAL,
                        AlertProtocol.INTERNAL_ERROR);
                throw new SSLException("Inbound is closed before close_notify "
                        + "alert has been received.");
            }
        } else {
            // engine is closing before initial handshake has been made
            shutdown();
        }
    }

    /**
     * Closes outbound operations of this engine
     * @see javax.net.ssl.SSLEngine#closeOutbound() method documentation
     * for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.877 -0500", hash_original_method = "194E237603CA4A7D605DF99CBAD71850", hash_generated_method = "7822E0FCF7BC1C60BED7C2F8679B7090")
    
@Override
    public void closeOutbound() {
        if (logger != null) {
            logger.println("closeOutbound() "+isOutboundDone);
        }
        if (isOutboundDone) {
            return;
        }
        isOutboundDone = true;
        if (handshake_started) {
            // initial handshake had been started
            alertProtocol.alert(AlertProtocol.WARNING,
                    AlertProtocol.CLOSE_NOTIFY);
            close_notify_was_sent = true;
        } else {
            // engine is closing before initial handshake has been made
            shutdown();
        }
        engine_was_closed = true;
    }

    /**
     * Returns handshake's delegated tasks to be run
     * @return the delegated task to be executed.
     * @see javax.net.ssl.SSLEngine#getDelegatedTask() method documentation
     * for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.879 -0500", hash_original_method = "C14CDBA62113C37F04E8CCD08C8FFAF5", hash_generated_method = "3CD306066AD191C746DFEA554C2E56E0")
    
@Override
    public Runnable getDelegatedTask() {
        return handshakeProtocol.getTask();
    }

    /**
     * Returns names of supported cipher suites.
     * @return array of strings containing the names of supported cipher suites
     * @see javax.net.ssl.SSLEngine#getSupportedCipherSuites() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.881 -0500", hash_original_method = "12BE90119F3183109C9DE5DBB63B352A", hash_generated_method = "0E9DEB7FA21717EA39000930983C1B84")
    
@Override
    public String[] getSupportedCipherSuites() {
        return CipherSuite.getSupportedCipherSuiteNames();
    }

    // --------------- SSLParameters based methods ---------------------

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getEnabledCipherSuites() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.884 -0500", hash_original_method = "80B545F2398A25060AECB1A23E821DD5", hash_generated_method = "9743EBAEBACB48E752148548CBED207E")
    
@Override
    public String[] getEnabledCipherSuites() {
        return sslParameters.getEnabledCipherSuites();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setEnabledCipherSuites(String[]) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.886 -0500", hash_original_method = "7C4ABDE66C2DD67AB299013913F9BF06", hash_generated_method = "C5557FA44AA989E23B0178177369FD5D")
    
@Override
    public void setEnabledCipherSuites(String[] suites) {
        sslParameters.setEnabledCipherSuites(suites);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getSupportedProtocols() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.888 -0500", hash_original_method = "9A36300B3497119D0180A59D3E72D371", hash_generated_method = "0336F8759C7C42688A7C93D456C43BA3")
    
@Override
    public String[] getSupportedProtocols() {
        return ProtocolVersion.supportedProtocols.clone();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getEnabledProtocols() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.891 -0500", hash_original_method = "9376751549A6436575C0783CA6C3A4A0", hash_generated_method = "33350DCBA69002691B7A369DC97FFA9B")
    
@Override
    public String[] getEnabledProtocols() {
        return sslParameters.getEnabledProtocols();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setEnabledProtocols(String[]) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.893 -0500", hash_original_method = "1CAC4BB68A222585D834DF0E7DBBD0B9", hash_generated_method = "5199FC3D60A4E4583B057C0623C822F9")
    
@Override
    public void setEnabledProtocols(String[] protocols) {
        sslParameters.setEnabledProtocols(protocols);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setUseClientMode(boolean) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.896 -0500", hash_original_method = "8643AE5368ED569DA5125D94D54A9561", hash_generated_method = "E5CA1858D886978CABFE92E9C5C19A2E")
    
@Override
    public void setUseClientMode(boolean mode) {
        if (handshake_started) {
            throw new IllegalArgumentException(
            "Could not change the mode after the initial handshake has begun.");
        }
        sslParameters.setUseClientMode(mode);
        peer_mode_was_set = true;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getUseClientMode() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.898 -0500", hash_original_method = "01F03276D647357C499C358366605A7A", hash_generated_method = "C189C4A91AE7529C93E5FE1A68636F7D")
    
@Override
    public boolean getUseClientMode() {
        return sslParameters.getUseClientMode();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setNeedClientAuth(boolean) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.901 -0500", hash_original_method = "87B99BB5E16802D75B8230FD21E2413F", hash_generated_method = "C446CA4D04BF46EBA63D06A750C2C8C1")
    
@Override
    public void setNeedClientAuth(boolean need) {
        sslParameters.setNeedClientAuth(need);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getNeedClientAuth() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.903 -0500", hash_original_method = "01CDFCACAD6C113BE18D967A4C320F8F", hash_generated_method = "1AC7C5FF07516804848811840A468A8B")
    
@Override
    public boolean getNeedClientAuth() {
        return sslParameters.getNeedClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setWantClientAuth(boolean) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.906 -0500", hash_original_method = "C4BE9213AE4AE3AE8B3FD470CA7DBEA1", hash_generated_method = "21E8FF7B7CE0E4FB146B4F3F0EE91E86")
    
@Override
    public void setWantClientAuth(boolean want) {
        sslParameters.setWantClientAuth(want);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getWantClientAuth() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.908 -0500", hash_original_method = "BFCFACF4683D2DA63944456ACA1AFE4C", hash_generated_method = "C498EFFB7EA33937BE58E3D8E2A82C77")
    
@Override
    public boolean getWantClientAuth() {
        return sslParameters.getWantClientAuth();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#setEnableSessionCreation(boolean) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.910 -0500", hash_original_method = "CCC6382646A49B02E626A26467D69493", hash_generated_method = "3DEA9628617E70F67E1471694350041C")
    
@Override
    public void setEnableSessionCreation(boolean flag) {
        sslParameters.setEnableSessionCreation(flag);
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getEnableSessionCreation() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.912 -0500", hash_original_method = "67C983FA387520F5F3AF315C719B29E4", hash_generated_method = "F0850E2B8F230278D1EE6575AFA464E6")
    
@Override
    public boolean getEnableSessionCreation() {
        return sslParameters.getEnableSessionCreation();
    }

    // -----------------------------------------------------------------

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getHandshakeStatus() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.915 -0500", hash_original_method = "74D7DA825347EF6AE406AA95D0E4A742", hash_generated_method = "BF4E7EBEADA9B24FA382B98587EC8F69")
    
@Override
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!handshake_started || engine_was_shutteddown) {
            // initial handshake has not been started yet
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (alertProtocol.hasAlert()) {
            // need to send an alert
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        if (close_notify_was_sent && !close_notify_was_received) {
            // waiting for "close_notify" response
            return SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        }
        return handshakeProtocol.getStatus();
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#getSession() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.917 -0500", hash_original_method = "FEA3CA8E78DB1766A0752130C49C073D", hash_generated_method = "2ED359C1D3E410660776630F2B943189")
    
@Override
    public SSLSession getSession() {
        if (session != null) {
            return session;
        }
        return SSLSessionImpl.NULL_SESSION;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#isInboundDone() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.920 -0500", hash_original_method = "93B7BEFDB685497BB8E88252AEDDD652", hash_generated_method = "6821110C4A35E997617D7154164D6E94")
    
@Override
    public boolean isInboundDone() {
        return isInboundDone || engine_was_closed;
    }

    /**
     * This method works according to the specification of implemented class.
     * @see javax.net.ssl.SSLEngine#isOutboundDone() method
     * documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.922 -0500", hash_original_method = "120A166126F4C5B7FB727570FC11E1A2", hash_generated_method = "1FCE8CF5074ED18EE92E21216C97AD3C")
    
@Override
    public boolean isOutboundDone() {
        return isOutboundDone;
    }

    /**
     * Decodes one complete SSL/TLS record provided in the source buffer.
     * If decoded record contained application data, this data will
     * be placed in the destination buffers.
     * For more information about TLS record fragmentation see
     * TLS v 1 specification (http://www.ietf.org/rfc/rfc2246.txt) p 6.2.
     * @param src source buffer containing SSL/TLS record.
     * @param dsts destination buffers to place received application data.
     * @see javax.net.ssl.SSLEngine#unwrap(ByteBuffer,ByteBuffer[],int,int)
     * method documentation for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.928 -0500", hash_original_method = "F6CF6D1723C677ECF3CA7B0D6EA7AC86", hash_generated_method = "7F9EB34057262551D1EE998AFAFDF802")
    
@Override
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts,
                                int offset, int length) throws SSLException {
        if (engine_was_shutteddown) {
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        }
        if ((src == null) || (dsts == null)) {
            throw new IllegalStateException(
                    "Some of the input parameters are null");
        }

        if (!handshake_started) {
            beginHandshake();
        }

        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
        // If is is initial handshake or connection closure stage,
        // check if this call was made in spite of handshake status
        if ((session == null || engine_was_closed) && (
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP) ||
                    handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK))) {
            return new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
        }

        if (src.remaining() < recordProtocol.getMinRecordSize()) {
            return new SSLEngineResult(
                    SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
        }

        try {
            src.mark();
            // check the destination buffers and count their capacity
            int capacity = 0;
            for (int i=offset; i<offset+length; i++) {
                if (dsts[i] == null) {
                    throw new IllegalStateException(
                            "Some of the input parameters are null");
                }
                if (dsts[i].isReadOnly()) {
                    throw new ReadOnlyBufferException();
                }
                capacity += dsts[i].remaining();
            }
            if (capacity < recordProtocol.getDataSize(src.remaining())) {
                return new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        getHandshakeStatus(), 0, 0);
            }
            recProtIS.setSourceBuffer(src);
            // unwrap the record contained in source buffer, pass it
            // to appropriate client protocol (alert, handshake, or app)
            // and retrieve the type of unwrapped data
            int type = recordProtocol.unwrap();
            // process the data and return the result
            switch (type) {
                case ContentType.HANDSHAKE:
                case ContentType.CHANGE_CIPHER_SPEC:
                    if (handshakeProtocol.getStatus().equals(
                            SSLEngineResult.HandshakeStatus.FINISHED)) {
                        session = recordProtocol.getSession();
                    }
                    break;
                case ContentType.APPLICATION_DATA:
                    break;
                case ContentType.ALERT:
                    if (alertProtocol.isFatalAlert()) {
                        alertProtocol.setProcessed();
                        if (session != null) {
                            session.invalidate();
                        }
                        String description = "Fatal alert received "
                            + alertProtocol.getAlertDescription();
                        shutdown();
                        throw new SSLException(description);
                    } else {
                        if (logger != null) {
                            logger.println("Warning allert has been received: "
                                + alertProtocol.getAlertDescription());
                        }
                        switch(alertProtocol.getDescriptionCode()) {
                            case AlertProtocol.CLOSE_NOTIFY:
                                alertProtocol.setProcessed();
                                close_notify_was_received = true;
                                if (!close_notify_was_sent) {
                                    closeOutbound();
                                    closeInbound();
                                } else {
                                    closeInbound();
                                    shutdown();
                                }
                                break;
                            case AlertProtocol.NO_RENEGOTIATION:
                                alertProtocol.setProcessed();
                                if (session == null) {
                                    // message received during the initial
                                    // handshake
                                    throw new AlertException(
                                        AlertProtocol.HANDSHAKE_FAILURE,
                                        new SSLHandshakeException(
                                            "Received no_renegotiation "
                                            + "during the initial handshake"));
                                } else {
                                    // just stop the handshake
                                    handshakeProtocol.stop();
                                }
                                break;
                            default:
                                alertProtocol.setProcessed();
                        }
                    }
                    break;
            }
            return new SSLEngineResult(getEngineStatus(), getHandshakeStatus(),
                    recProtIS.consumed(),
                    // place the app. data (if any) into the dest. buffers
                    // and get the number of produced bytes:
                    appData.placeTo(dsts, offset, length));
        } catch (BufferUnderflowException e) {
            // there was not enought data ource buffer to make complete packet
            src.reset();
            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_UNDERFLOW,
                    getHandshakeStatus(), 0, 0);
        } catch (AlertException e) {
            // fatal alert occured
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            src.reset();
            if (session != null) {
                session.invalidate();
            }
            // shutdown work will be made after the alert will be sent
            // to another peer (by wrap method)
            throw e.getReason();
        } catch (SSLException e) {
            throw e;
        } catch (IOException e) {
            alertProtocol.alert(AlertProtocol.FATAL,
                    AlertProtocol.INTERNAL_ERROR);
            engine_was_closed = true;
            // shutdown work will be made after the alert will be sent
            // to another peer (by wrap method)
            throw new SSLException(e.getMessage());
        }
    }

    /**
     * Encodes the application data into SSL/TLS record. If handshake status
     * of the engine differs from NOT_HANDSHAKING the operation can work
     * without consuming of the source data.
     * For more information about TLS record fragmentation see
     * TLS v 1 specification (http://www.ietf.org/rfc/rfc2246.txt) p 6.2.
     * @param srcs the source buffers with application data to be encoded
     * into SSL/TLS record.
     * @param offset the offset in the destination buffers array pointing to
     * the first buffer with the source data.
     * @param len specifies the maximum number of buffers to be procesed.
     * @param dst the destination buffer where encoded data will be placed.
     * @see javax.net.ssl.SSLEngine#wrap(ByteBuffer[],int,int,ByteBuffer) method
     * documentation for more information
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.934 -0500", hash_original_method = "4D503F6FEFF5A6DB6E7618C8A28327D4", hash_generated_method = "8635C59B06DF3DC5F17BCC78285185DA")
    
@Override
    public SSLEngineResult wrap(ByteBuffer[] srcs, int offset,
                            int len, ByteBuffer dst) throws SSLException {
        if (engine_was_shutteddown) {
            return new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                    SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        }
        if ((srcs == null) || (dst == null)) {
            throw new IllegalStateException(
                    "Some of the input parameters are null");
        }
        if (dst.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }

        if (!handshake_started) {
            beginHandshake();
        }

        SSLEngineResult.HandshakeStatus handshakeStatus = getHandshakeStatus();
        // If it is an initial handshake or connection closure stage,
        // check if this call was made in spite of handshake status
        if ((session == null || engine_was_closed) && (
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_UNWRAP) ||
                handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_TASK))) {
            return new SSLEngineResult(
                    getEngineStatus(), handshakeStatus, 0, 0);
        }

        int capacity = dst.remaining();
        int produced = 0;

        if (alertProtocol.hasAlert()) {
            // we have an alert to be sent
            if (capacity < recordProtocol.getRecordSize(2)) {
                return new SSLEngineResult(
                        SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
            }
            byte[] alert_data = alertProtocol.wrap();
            // place the alert record into destination
            dst.put(alert_data);
            if (alertProtocol.isFatalAlert()) {
                alertProtocol.setProcessed();
                if (session != null) {
                    session.invalidate();
                }
                // fatal alert has been sent, so shut down the engine
                shutdown();
                return new SSLEngineResult(
                        SSLEngineResult.Status.CLOSED,
                        SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                        0, alert_data.length);
            } else {
                alertProtocol.setProcessed();
                // check if the works on this engine have been done
                if (close_notify_was_sent && close_notify_was_received) {
                    shutdown();
                    return new SSLEngineResult(SSLEngineResult.Status.CLOSED,
                            SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING,
                            0, alert_data.length);
                }
                return new SSLEngineResult(
                        getEngineStatus(),
                        getHandshakeStatus(),
                        0, alert_data.length);
            }
        }

        if (capacity < recordProtocol.getMinRecordSize()) {
            if (logger != null) {
                logger.println("Capacity of the destination("
                        +capacity+") < MIN_PACKET_SIZE("
                        +recordProtocol.getMinRecordSize()+")");
            }
            return new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW,
                        handshakeStatus, 0, 0);
        }

        try {
            if (!handshakeStatus.equals(
                        SSLEngineResult.HandshakeStatus.NEED_WRAP)) {
                // so we wraps application data
                dataStream.setSourceBuffers(srcs, offset, len);
                if ((capacity < SSLRecordProtocol.MAX_SSL_PACKET_SIZE) &&
                    (capacity < recordProtocol.getRecordSize(
                                                 dataStream.available()))) {
                    if (logger != null) {
                        logger.println("The destination buffer("
                                +capacity+") can not take the resulting packet("
                                + recordProtocol.getRecordSize(
                                    dataStream.available())+")");
                    }
                    return new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                }
                if (remaining_wrapped_data == null) {
                    remaining_wrapped_data =
                        recordProtocol.wrap(ContentType.APPLICATION_DATA,
                                dataStream);
                }
                if (capacity < remaining_wrapped_data.length) {
                    // It should newer happen because we checked the destination
                    // buffer size, but there is a possibility
                    // (if dest buffer was filled outside)
                    // so we just remember the data into remaining_wrapped_data
                    // and will enclose it during the the next call
                    return new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, dataStream.consumed(), 0);
                } else {
                    dst.put(remaining_wrapped_data);
                    produced = remaining_wrapped_data.length;
                    remaining_wrapped_data = null;
                    return new SSLEngineResult(getEngineStatus(),
                            handshakeStatus, dataStream.consumed(), produced);
                }
            } else {
                if (remaining_hsh_data == null) {
                    remaining_hsh_data = handshakeProtocol.wrap();
                }
                if (capacity < remaining_hsh_data.length) {
                    // It should newer happen because we checked the destination
                    // buffer size, but there is a possibility
                    // (if dest buffer was filled outside)
                    // so we just remember the data into remaining_hsh_data
                    // and will enclose it during the the next call
                    return new SSLEngineResult(
                            SSLEngineResult.Status.BUFFER_OVERFLOW,
                            handshakeStatus, 0, 0);
                } else {
                    dst.put(remaining_hsh_data);
                    produced = remaining_hsh_data.length;
                    remaining_hsh_data = null;

                    handshakeStatus = handshakeProtocol.getStatus();
                    if (handshakeStatus.equals(
                            SSLEngineResult.HandshakeStatus.FINISHED)) {
                        session = recordProtocol.getSession();
                    }
                }
                return new SSLEngineResult(
                        getEngineStatus(), getHandshakeStatus(), 0, produced);
            }
        } catch (AlertException e) {
            // fatal alert occured
            alertProtocol.alert(AlertProtocol.FATAL, e.getDescriptionCode());
            engine_was_closed = true;
            if (session != null) {
                session.invalidate();
            }
            // shutdown work will be made after the alert will be sent
            // to another peer (by wrap method)
            throw e.getReason();
        }
    }

    // Shutdownes the engine and makes all cleanup work.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.936 -0500", hash_original_method = "2E4498D8774C920317F596FEB8E0DACF", hash_generated_method = "310B3004AFFE64449AAA6D06F3926534")
    
private void shutdown() {
        engine_was_closed = true;
        engine_was_shutteddown = true;
        isOutboundDone = true;
        isInboundDone = true;
        if (handshake_started) {
            alertProtocol.shutdown();
            alertProtocol = null;
            handshakeProtocol.shutdown();
            handshakeProtocol = null;
            recordProtocol.shutdown();
            recordProtocol = null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:12.938 -0500", hash_original_method = "C6B39897E63E44773E5CEE8467983722", hash_generated_method = "955DDEB712D90E4C507BF5F09B619D3A")
    
private SSLEngineResult.Status getEngineStatus() {
        return (engine_was_closed)
            ? SSLEngineResult.Status.CLOSED
            : SSLEngineResult.Status.OK;
    }
    
}

