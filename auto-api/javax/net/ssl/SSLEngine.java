package javax.net.ssl;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class SSLEngine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.260 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.260 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.266 -0400", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "6C354AD4901187F011888EBB5BDEB711")
    protected  SSLEngine() {
        peerHost = null;
        peerPort = -1;
        // ---------- Original Method ----------
        //peerHost = null;
        //peerPort = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.266 -0400", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "A5F53C24279159BD08B9BD851D5512FB")
    protected  SSLEngine(String host, int port) {
        this.peerHost = host;
        this.peerPort = port;
        // ---------- Original Method ----------
        //this.peerHost = host;
        //this.peerPort = port;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.267 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "7850663A5C00EA7C29BCF252BE784160")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1102496370 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1102496370 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_1102496370.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102496370;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.268 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "ECF58F32C5E8C8B3FE657F6622EADD89")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956907071 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956907071;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.282 -0400", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "6BCA407825AADF900A2FC6A3DE9A2854")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1577184912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1577184912 = unwrap(src, new ByteBuffer[] { dst }, 0, 1);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1577184912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1577184912;
        // ---------- Original Method ----------
        //return unwrap(src, new ByteBuffer[] { dst }, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.283 -0400", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "6FF33E0B66E3FC743C6DE63441D1BAB2")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_270080733 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array dsts is null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_270080733 = unwrap(src, dsts, 0, dsts.length);
        addTaint(src.getTaint());
        addTaint(dsts[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_270080733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_270080733;
        // ---------- Original Method ----------
        //if (dsts == null) {
            //throw new IllegalArgumentException("Byte buffer array dsts is null");
        //}
        //return unwrap(src, dsts, 0, dsts.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.283 -0400", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "A7E62EE3FD46677B24CBB62C49F9F2A9")
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_130297970 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array srcs is null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_130297970 = wrap(srcs, 0, srcs.length, dst);
        addTaint(srcs[0].getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_130297970.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_130297970;
        // ---------- Original Method ----------
        //if (srcs == null) {
            //throw new IllegalArgumentException("Byte buffer array srcs is null");
        //}
        //return wrap(srcs, 0, srcs.length, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.292 -0400", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "1ED659F95C62121DA5539E4D7E826C43")
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_104245296 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_104245296 = wrap(new ByteBuffer[] { src }, 0, 1, dst);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_104245296.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104245296;
        // ---------- Original Method ----------
        //return wrap(new ByteBuffer[] { src }, 0, 1, dst);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.292 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "374739B1F6BEE1973D595D4242A2CBDF")
    public SSLParameters getSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1408678584 = null; //Variable for return #1
        SSLParameters p;
        p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        varB4EAC82CA7396A68D541C85D26508E83_1408678584 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1408678584.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1408678584;
        // ---------- Original Method ----------
        //SSLParameters p = new SSLParameters();
        //p.setCipherSuites(getEnabledCipherSuites());
        //p.setProtocols(getEnabledProtocols());
        //p.setNeedClientAuth(getNeedClientAuth());
        //p.setWantClientAuth(getWantClientAuth());
        //return p;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.293 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "683A4684FB34F013334ED837A4B30E8C")
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
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_1821571348 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } //End block
            {
                boolean var2FBA481A340F527F533722A37691A0E1_539029476 = (p.getWantClientAuth());
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

