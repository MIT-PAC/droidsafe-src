package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContextSpi;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class SSLContextImpl extends SSLContextSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.698 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.698 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.698 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.699 -0400", hash_original_method = "BB3D0F5B2222977574D305A8CAD6912B", hash_generated_method = "C2EBBF6280DAA1C2D96BF5ECCA7861E1")
    public  SSLContextImpl() {
        clientSessionContext = new ClientSessionContext();
        serverSessionContext = new ServerSessionContext();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.699 -0400", hash_original_method = "81573CDE574A4A011582FBBAB6C3BF9A", hash_generated_method = "90A96C08D19DE63F7D3534347B37A6D0")
    protected  SSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        {
            {
                clientSessionContext = new ClientSessionContext();
                serverSessionContext = new ServerSessionContext();
                DEFAULT_SSL_CONTEXT_IMPL = (DefaultSSLContextImpl)this;
            } 
            {
                clientSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetClientSessionContext();
                serverSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetServerSessionContext();
            } 
            sslParameters = new SSLParametersImpl(DEFAULT_SSL_CONTEXT_IMPL.getKeyManagers(),
                                                  DEFAULT_SSL_CONTEXT_IMPL.getTrustManagers(),
                                                  null,
                                                  clientSessionContext,
                                                  serverSessionContext);
        } 
        addTaint(dummy.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.700 -0400", hash_original_method = "0824770EA02EDCBB315A7517C68CBF9B", hash_generated_method = "5ED612AF34CD0AC820A10D3E7C4E5A8B")
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              clientSessionContext, serverSessionContext);
        
        
                                              
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.701 -0400", hash_original_method = "004191AE8609FCF33514DFCEA01A5714", hash_generated_method = "D3E78B7BC0BA51CB922FE351330FBEC3")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_335056501 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_335056501 = new SSLSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_335056501.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_335056501;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.701 -0400", hash_original_method = "65E8F32416A9204F9A4329BBE6993AED", hash_generated_method = "1E0E2426849EB8DA4C114053817437FC")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1897914627 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1897914627 = new SSLServerSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_1897914627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1897914627;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.702 -0400", hash_original_method = "29CE564F844B35192AD02B59CF29ABFD", hash_generated_method = "35702A67007F2740D5C30B1D64FCC1A4")
    @Override
    public SSLEngine engineCreateSSLEngine(String host, int port) {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_312849414 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } 
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        varB4EAC82CA7396A68D541C85D26508E83_312849414 = new SSLEngineImpl(host, port, p);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_312849414.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_312849414;
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.703 -0400", hash_original_method = "1B7221E2350F2BEF0C28DC221F83475D", hash_generated_method = "B0F99111CC1398097DEA90DE8CC7241E")
    @Override
    public SSLEngine engineCreateSSLEngine() {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_1986140109 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } 
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        varB4EAC82CA7396A68D541C85D26508E83_1986140109 = new SSLEngineImpl(p);
        varB4EAC82CA7396A68D541C85D26508E83_1986140109.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1986140109;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.704 -0400", hash_original_method = "D250F9B5B60A63355C4DD3366841F3DE", hash_generated_method = "8A610170A85BB5CC2F4D9999AF582097")
    @Override
    public ServerSessionContext engineGetServerSessionContext() {
        ServerSessionContext varB4EAC82CA7396A68D541C85D26508E83_677714192 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_677714192 = serverSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_677714192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_677714192;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.705 -0400", hash_original_method = "F7A52ACBCF1ABAC2A6697027AD059F72", hash_generated_method = "A5A4A63E111BF3C53D720DA16326E992")
    @Override
    public ClientSessionContext engineGetClientSessionContext() {
        ClientSessionContext varB4EAC82CA7396A68D541C85D26508E83_326531216 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_326531216 = clientSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_326531216.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_326531216;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.705 -0400", hash_original_field = "FE12143B9433BC939A46323087706E75", hash_generated_field = "705088B5C2C8B220095047F197D99BA7")

    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
}

