package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;

public abstract class SSLEngine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.675 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.675 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.676 -0400", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "6C354AD4901187F011888EBB5BDEB711")
    protected  SSLEngine() {
        peerHost = null;
        peerPort = -1;
        // ---------- Original Method ----------
        //peerHost = null;
        //peerPort = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.676 -0400", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "A5F53C24279159BD08B9BD851D5512FB")
    protected  SSLEngine(String host, int port) {
        this.peerHost = host;
        this.peerPort = port;
        // ---------- Original Method ----------
        //this.peerHost = host;
        //this.peerPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.676 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "884EE51D0491A08921E7C06365218CB8")
    public String getPeerHost() {
String varFEF815055C97D4B621404BF729E85DA2_1000186825 =         peerHost;
        varFEF815055C97D4B621404BF729E85DA2_1000186825.addTaint(taint);
        return varFEF815055C97D4B621404BF729E85DA2_1000186825;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.677 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "DE0D05E64654CEEC33718C25AC6BE8A1")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_1813309264 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927822323 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_927822323;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.680 -0400", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "E870B4DF4F6AC8699B6E1E5CBE0DA01C")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
SSLEngineResult varDD78561FBD283269B6DD42AF139A709B_600761060 =         unwrap(src, new ByteBuffer[] { dst }, 0, 1);
        varDD78561FBD283269B6DD42AF139A709B_600761060.addTaint(taint);
        return varDD78561FBD283269B6DD42AF139A709B_600761060;
        // ---------- Original Method ----------
        //return unwrap(src, new ByteBuffer[] { dst }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.680 -0400", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "D023B83A75B8209EC572B061C36DAF50")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        addTaint(dsts[0].getTaint());
        addTaint(src.getTaint());
    if(dsts == null)        
        {
            IllegalArgumentException var9A48F68B6ACA4F10390F24793213AE1A_1747482611 = new IllegalArgumentException("Byte buffer array dsts is null");
            var9A48F68B6ACA4F10390F24793213AE1A_1747482611.addTaint(taint);
            throw var9A48F68B6ACA4F10390F24793213AE1A_1747482611;
        } //End block
SSLEngineResult varF59CCEEF71B0ADC2DE10A862EA422DCB_504315236 =         unwrap(src, dsts, 0, dsts.length);
        varF59CCEEF71B0ADC2DE10A862EA422DCB_504315236.addTaint(taint);
        return varF59CCEEF71B0ADC2DE10A862EA422DCB_504315236;
        // ---------- Original Method ----------
        //if (dsts == null) {
            //throw new IllegalArgumentException("Byte buffer array dsts is null");
        //}
        //return unwrap(src, dsts, 0, dsts.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.681 -0400", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "1A5E5D31F222863750B90A5186E5F6A0")
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        addTaint(dst.getTaint());
        addTaint(srcs[0].getTaint());
    if(srcs == null)        
        {
            IllegalArgumentException var433488ACC9F76CFE26370F760861C10E_1121361782 = new IllegalArgumentException("Byte buffer array srcs is null");
            var433488ACC9F76CFE26370F760861C10E_1121361782.addTaint(taint);
            throw var433488ACC9F76CFE26370F760861C10E_1121361782;
        } //End block
SSLEngineResult varF785702831660251D276B1204D3A4B36_1104319821 =         wrap(srcs, 0, srcs.length, dst);
        varF785702831660251D276B1204D3A4B36_1104319821.addTaint(taint);
        return varF785702831660251D276B1204D3A4B36_1104319821;
        // ---------- Original Method ----------
        //if (srcs == null) {
            //throw new IllegalArgumentException("Byte buffer array srcs is null");
        //}
        //return wrap(srcs, 0, srcs.length, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.681 -0400", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "55CA8C4C2A5A476375FCA5D3B74D6A60")
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        addTaint(dst.getTaint());
        addTaint(src.getTaint());
SSLEngineResult var8990D21D724771169EEA983129118039_1664139085 =         wrap(new ByteBuffer[] { src }, 0, 1, dst);
        var8990D21D724771169EEA983129118039_1664139085.addTaint(taint);
        return var8990D21D724771169EEA983129118039_1664139085;
        // ---------- Original Method ----------
        //return wrap(new ByteBuffer[] { src }, 0, 1, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.682 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "E40BD137806BEA38723154F3781AEC0D")
    public SSLParameters getSSLParameters() {
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
SSLParameters var74E4690D9F2A026504928C017944E149_619189555 =         p;
        var74E4690D9F2A026504928C017944E149_619189555.addTaint(taint);
        return var74E4690D9F2A026504928C017944E149_619189555;
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.682 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "27EFFE024357E2EEA5E53D9F242DF898")
    public void setSSLParameters(SSLParameters p) {
        addTaint(p.getTaint());
        String[] cipherSuites = p.getCipherSuites();
    if(cipherSuites != null)        
        {
            setEnabledCipherSuites(cipherSuites);
        } //End block
        String[] protocols = p.getProtocols();
    if(protocols != null)        
        {
            setEnabledProtocols(protocols);
        } //End block
    if(p.getNeedClientAuth())        
        {
            setNeedClientAuth(true);
        } //End block
        else
    if(p.getWantClientAuth())        
        {
            setWantClientAuth(true);
        } //End block
        else
        {
            setWantClientAuth(false);
        } //End block
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

