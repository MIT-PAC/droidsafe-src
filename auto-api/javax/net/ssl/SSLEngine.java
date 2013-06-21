package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class SSLEngine {
    private String peerHost;
    private int peerPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.075 -0400", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "6C354AD4901187F011888EBB5BDEB711")
    @DSModeled(DSC.SAFE)
    protected SSLEngine() {
        peerHost = null;
        peerPort = -1;
        // ---------- Original Method ----------
        //peerHost = null;
        //peerPort = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.075 -0400", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "8D43686843AC68145B5A14E2BC8DA993")
    @DSModeled(DSC.SAFE)
    protected SSLEngine(String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        // ---------- Original Method ----------
        //this.peerHost = host;
        //this.peerPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.075 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "3BF3C4086F7B3CF4925E10D1813275BA")
    @DSModeled(DSC.SAFE)
    public String getPeerHost() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.075 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "AEBA702D6111FFED2D7D8A1EFD0D8FC1")
    @DSModeled(DSC.SAFE)
    public int getPeerPort() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    public abstract void beginHandshake() throws SSLException;

    
    public abstract void closeInbound() throws SSLException;

    
    public abstract void closeOutbound();

    
    public abstract Runnable getDelegatedTask();

    
    public abstract String[] getEnabledCipherSuites();

    
    public abstract String[] getEnabledProtocols();

    
    public abstract boolean getEnableSessionCreation();

    
    public abstract SSLEngineResult.HandshakeStatus getHandshakeStatus();

    
    public abstract boolean getNeedClientAuth();

    
    public abstract SSLSession getSession();

    
    public abstract String[] getSupportedCipherSuites();

    
    public abstract String[] getSupportedProtocols();

    
    public abstract boolean getUseClientMode();

    
    public abstract boolean getWantClientAuth();

    
    public abstract boolean isInboundDone();

    
    public abstract boolean isOutboundDone();

    
    public abstract void setEnabledCipherSuites(String[] suites);

    
    public abstract void setEnabledProtocols(String[] protocols);

    
    public abstract void setEnableSessionCreation(boolean flag);

    
    public abstract void setNeedClientAuth(boolean need);

    
    public abstract void setUseClientMode(boolean mode);

    
    public abstract void setWantClientAuth(boolean want);

    
    public abstract SSLEngineResult unwrap(ByteBuffer src,
                                           ByteBuffer[] dsts,
                                           int offset,
                                           int length) throws SSLException;

    
    public abstract SSLEngineResult wrap(ByteBuffer[] srcs, int offset, int length, ByteBuffer dst)
            throws SSLException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.078 -0400", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "9CDB252D69810BF92F993905AF93EFBF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        SSLEngineResult var5A1B67D9769054129E981FCDB43F6409_517978491 = (unwrap(src, new ByteBuffer[] { dst }, 0, 1));
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return unwrap(src, new ByteBuffer[] { dst }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.078 -0400", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "6E1CC6DDF6CCA852899B19C902D49C88")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        dsTaint.addTaint(dsts[0].dsTaint);
        dsTaint.addTaint(src.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array dsts is null");
        } //End block
        SSLEngineResult varB6ADCBC6937B1E6F868EB4320C216978_1438975881 = (unwrap(src, dsts, 0, dsts.length));
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (dsts == null) {
            //throw new IllegalArgumentException("Byte buffer array dsts is null");
        //}
        //return unwrap(src, dsts, 0, dsts.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.078 -0400", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "0937C7660254ABD9977AA122A97B238C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(srcs[0].dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array srcs is null");
        } //End block
        SSLEngineResult var3E281CF05ECBC49B607E50735D572FCF_1417002380 = (wrap(srcs, 0, srcs.length, dst));
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (srcs == null) {
            //throw new IllegalArgumentException("Byte buffer array srcs is null");
        //}
        //return wrap(srcs, 0, srcs.length, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.078 -0400", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "D7949D7C7F7805CB3A64379D59FF0D21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        dsTaint.addTaint(dst.dsTaint);
        dsTaint.addTaint(src.dsTaint);
        SSLEngineResult var7F5A33A3DC424E7722230CCD36A9AAC6_360391265 = (wrap(new ByteBuffer[] { src }, 0, 1, dst));
        return (SSLEngineResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return wrap(new ByteBuffer[] { src }, 0, 1, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.078 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "090A23B6E68C3753C70D33B64F3C5183")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLParameters getSSLParameters() {
        SSLParameters p;
        p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        return (SSLParameters)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:36.079 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "A6457A942A54E5FDF3AFC90A9FCB5B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setSSLParameters(SSLParameters p) {
        dsTaint.addTaint(p.dsTaint);
        String[] cipherSuites;
        cipherSuites = p.getCipherSuites();
        {
            setEnabledCipherSuites(cipherSuites);
        } //End block
        String[] protocols;
        protocols = p.getProtocols();
        {
            setEnabledProtocols(protocols);
        } //End block
        {
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_1505831900 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } //End block
            {
                boolean var2FBA481A340F527F533722A37691A0E1_802825643 = (p.getWantClientAuth());
                {
                    setWantClientAuth(true);
                } //End block
                {
                    setWantClientAuth(false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //String[] cipherSuites = p.getCipherSuites();
        //if (cipherSuites != null) {
            //setEnabledCipherSuites(cipherSuites);
        //}
        //String[] protocols = p.getProtocols();
        //if (protocols != null) {
            //setEnabledProtocols(protocols);
        //}
        //if (p.getNeedClientAuth()) {
            //setNeedClientAuth(true);
        //} else if (p.getWantClientAuth()) {
            //setWantClientAuth(true);
        //} else {
            //setWantClientAuth(false);
        //}
    }

    
}

