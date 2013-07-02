package javax.net.ssl;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.nio.ByteBuffer;

public abstract class SSLEngine {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.607 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.607 -0400", hash_original_field = "BBD5741C4F9994864582D25DD194C4DE", hash_generated_field = "FE74A5BA5CFBB5B6DC2B68FEFA76ECFC")

    private int peerPort;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.607 -0400", hash_original_method = "4DB69FC0D6B2C4EA5754BFEC7A5A4921", hash_generated_method = "6C354AD4901187F011888EBB5BDEB711")
    protected  SSLEngine() {
        peerHost = null;
        peerPort = -1;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.608 -0400", hash_original_method = "EEA000A850DD4012FB53C4A935EA52C0", hash_generated_method = "A5F53C24279159BD08B9BD851D5512FB")
    protected  SSLEngine(String host, int port) {
        this.peerHost = host;
        this.peerPort = port;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.608 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "F567F285401AED842638FC9CF19B8BDD")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_242937134 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_242937134 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_242937134.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_242937134;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.609 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "B3D3495544228AD7D09DB962E7C78DBC")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082663831 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2082663831;
        
        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.616 -0400", hash_original_method = "7AC56F3E97B3BF2A8A3FC335E647B318", hash_generated_method = "AA48EF4AADCE97261630DBCD63183CFB")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1749328395 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1749328395 = unwrap(src, new ByteBuffer[] { dst }, 0, 1);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1749328395.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1749328395;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.616 -0400", hash_original_method = "9736EBF4FA9EEB1C5129AD63480700AA", hash_generated_method = "C95DDDC9CA9C1270AF123B653F460E87")
    public SSLEngineResult unwrap(ByteBuffer src, ByteBuffer[] dsts) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1486771056 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array dsts is null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1486771056 = unwrap(src, dsts, 0, dsts.length);
        addTaint(src.getTaint());
        addTaint(dsts[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1486771056.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1486771056;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.617 -0400", hash_original_method = "2CCA444D00129DF62214EE036E36E4DD", hash_generated_method = "2C0C9130B6330E278F51910B39B921C9")
    public SSLEngineResult wrap(ByteBuffer[] srcs, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_1288882497 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Byte buffer array srcs is null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1288882497 = wrap(srcs, 0, srcs.length, dst);
        addTaint(srcs[0].getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1288882497.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1288882497;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.617 -0400", hash_original_method = "15A7413E97A8CAC06D2DFD60F87EA34E", hash_generated_method = "321DE37AA13E15FB4EDB3A9D15DD3D9A")
    public SSLEngineResult wrap(ByteBuffer src, ByteBuffer dst) throws SSLException {
        SSLEngineResult varB4EAC82CA7396A68D541C85D26508E83_2134492209 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2134492209 = wrap(new ByteBuffer[] { src }, 0, 1, dst);
        addTaint(src.getTaint());
        addTaint(dst.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2134492209.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2134492209;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.618 -0400", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "1AFA32F2EB4619E6A99901383939145C")
    public SSLParameters getSSLParameters() {
        SSLParameters varB4EAC82CA7396A68D541C85D26508E83_1588070493 = null; 
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        varB4EAC82CA7396A68D541C85D26508E83_1588070493 = p;
        varB4EAC82CA7396A68D541C85D26508E83_1588070493.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1588070493;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:17.618 -0400", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "653D61AE3717AD9CADC6625FB3DA20C6")
    public void setSSLParameters(SSLParameters p) {
        String[] cipherSuites = p.getCipherSuites();
        {
            setEnabledCipherSuites(cipherSuites);
        } 
        String[] protocols = p.getProtocols();
        {
            setEnabledProtocols(protocols);
        } 
        {
            boolean var6D45BED7515FD6C0BD1ED2BAAE0F632B_1892788506 = (p.getNeedClientAuth());
            {
                setNeedClientAuth(true);
            } 
            {
                boolean var2FBA481A340F527F533722A37691A0E1_2017371176 = (p.getWantClientAuth());
                {
                    setWantClientAuth(true);
                } 
                {
                    setWantClientAuth(false);
                } 
            } 
        } 
        addTaint(p.getTaint());
        
        
        
            
        
        
        
            
        
        
            
        
            
        
            
        
    }

    
}

