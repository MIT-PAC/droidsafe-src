package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class SSLEngine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.560 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.561 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.562 -0400", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "6C354AD4901187F011888EBB5BDEB711")
    protected  SSLEngine() {
        peerHost = null;
        peerPort = -1;
        // ---------- Original Method ----------
        //peerHost = null;
        //peerPort = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.575 -0400", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "A5F53C24279159BD08B9BD851D5512FB")
    protected  SSLEngine(String host, int port) {
        this.peerHost = host;
        this.peerPort = port;
        // ---------- Original Method ----------
        //this.peerHost = host;
        //this.peerPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.605 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "CF844EA25AC575E281E8E802F88DD3AD")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1250507409 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1250507409 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_1250507409.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1250507409;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.605 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "5426FFBA1812DB9EE93732586DA9EDD7")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962560473 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_962560473;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.616 -0400", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "61DB5AAFF0BDA7AFDEE577B83F0FDA7D")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_160259332 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_160259332 = unwrap(src, new ByteBuffer[] { dst }, 0, 1);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_160259332.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_160259332;
        // ---------- Original Method ----------
        //return unwrap(src, new ByteBuffer[] { dst }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.636 -0400", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "138B3E401D048ACF79E1F71F06C14F04")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1174637906 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array dsts is null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1174637906 = unwrap(src, dsts, 0, dsts.length);
        addTaint(src.getTaint());
        addTaint(dsts[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1174637906.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1174637906;
        // ---------- Original Method ----------
        //if (dsts == null) {
            //throw new IllegalArgumentException("Byte buffer array dsts is null");
        //}
        //return unwrap(src, dsts, 0, dsts.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.636 -0400", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "33112B13632A248BB72320D0EB23B36E")
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1178428438 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array srcs is null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1178428438 = wrap(srcs, 0, srcs.length, dst);
        addTaint(srcs[0].getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1178428438.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1178428438;
        // ---------- Original Method ----------
        //if (srcs == null) {
            //throw new IllegalArgumentException("Byte buffer array srcs is null");
        //}
        //return wrap(srcs, 0, srcs.length, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.637 -0400", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "DDA4D19CD0B1B5ACB606F841893B69A0")
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1323455094 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1323455094 = wrap(new ByteBuffer[] { src }, 0, 1, dst);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1323455094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1323455094;
        // ---------- Original Method ----------
        //return wrap(new ByteBuffer[] { src }, 0, 1, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.637 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "19D0C93C0FDF346484DA316DEF38FA9C")
    public SSLParameters getSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1811682450 = null; //Variable for return #1
        SSLParameters p;
        p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        varB4EAC82CA7396A68D541C85D26508E83_1811682450 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1811682450.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1811682450;
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.638 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "0BDFCE137EDF2AC1BC509F57515AC54D")
    public void setSSLParameters(SSLParameters p) {
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
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_843068342 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } //End block
            {
                boolean var2FBA481A340F527F533722A37691A0E1_124567681 = (p.getWantClientAuth());
                {
                    setWantClientAuth(true);
                } //End block
                {
                    setWantClientAuth(false);
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        addTaint(p.getTaint());
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

