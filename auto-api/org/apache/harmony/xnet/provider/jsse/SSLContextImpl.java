package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.331 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.332 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.332 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.332 -0400", hash_original_method = "BB3D0F5B2222977574D305A8CAD6912B", hash_generated_method = "C2EBBF6280DAA1C2D96BF5ECCA7861E1")
    public  SSLContextImpl() {
        clientSessionContext = new ClientSessionContext();
        serverSessionContext = new ServerSessionContext();
        // ---------- Original Method ----------
        //clientSessionContext = new ClientSessionContext();
        //serverSessionContext = new ServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.342 -0400", hash_original_method = "81573CDE574A4A011582FBBAB6C3BF9A", hash_generated_method = "90A96C08D19DE63F7D3534347B37A6D0")
    protected  SSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        {
            {
                clientSessionContext = new ClientSessionContext();
                serverSessionContext = new ServerSessionContext();
                DEFAULT_SSL_CONTEXT_IMPL = (DefaultSSLContextImpl)this;
            } //End block
            {
                clientSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetClientSessionContext();
                serverSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetServerSessionContext();
            } //End block
            sslParameters = new SSLParametersImpl(DEFAULT_SSL_CONTEXT_IMPL.getKeyManagers(),
                                                  DEFAULT_SSL_CONTEXT_IMPL.getTrustManagers(),
                                                  null,
                                                  clientSessionContext,
                                                  serverSessionContext);
        } //End block
        addTaint(dummy.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.343 -0400", hash_original_method = "0824770EA02EDCBB315A7517C68CBF9B", hash_generated_method = "5ED612AF34CD0AC820A10D3E7C4E5A8B")
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              clientSessionContext, serverSessionContext);
        // ---------- Original Method ----------
        //sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              //clientSessionContext, serverSessionContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.346 -0400", hash_original_method = "004191AE8609FCF33514DFCEA01A5714", hash_generated_method = "89028968B07C8516B70F09BA6567CC3B")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        SSLSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1449312973 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1449312973 = new SSLSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_1449312973.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1449312973;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.347 -0400", hash_original_method = "65E8F32416A9204F9A4329BBE6993AED", hash_generated_method = "AF99C226C886CD0A2DFAE7A12F6A2A59")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        SSLServerSocketFactory varB4EAC82CA7396A68D541C85D26508E83_1383511995 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1383511995 = new SSLServerSocketFactoryImpl(sslParameters);
        varB4EAC82CA7396A68D541C85D26508E83_1383511995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1383511995;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLServerSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.348 -0400", hash_original_method = "29CE564F844B35192AD02B59CF29ABFD", hash_generated_method = "85B08C2F1C13D0105F0B6A6847C5783E")
    @Override
    public SSLEngine engineCreateSSLEngine(String host, int port) {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_480101586 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLParametersImpl p;
        p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        varB4EAC82CA7396A68D541C85D26508E83_480101586 = new SSLEngineImpl(host, port, p);
        addTaint(host.getTaint());
        addTaint(port);
        varB4EAC82CA7396A68D541C85D26508E83_480101586.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_480101586;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(host, port, p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.360 -0400", hash_original_method = "1B7221E2350F2BEF0C28DC221F83475D", hash_generated_method = "69A849D5FA6A4DA8A42F40F0A398FC6C")
    @Override
    public SSLEngine engineCreateSSLEngine() {
        SSLEngine varB4EAC82CA7396A68D541C85D26508E83_1099753270 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLParametersImpl p;
        p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        varB4EAC82CA7396A68D541C85D26508E83_1099753270 = new SSLEngineImpl(p);
        varB4EAC82CA7396A68D541C85D26508E83_1099753270.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1099753270;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.360 -0400", hash_original_method = "D250F9B5B60A63355C4DD3366841F3DE", hash_generated_method = "0B876B851397D8C344AFE9E2A801920A")
    @Override
    public ServerSessionContext engineGetServerSessionContext() {
        ServerSessionContext varB4EAC82CA7396A68D541C85D26508E83_1462887333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1462887333 = serverSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_1462887333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1462887333;
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.361 -0400", hash_original_method = "F7A52ACBCF1ABAC2A6697027AD059F72", hash_generated_method = "81AB4A012E74784E54C036598D309D81")
    @Override
    public ClientSessionContext engineGetClientSessionContext() {
        ClientSessionContext varB4EAC82CA7396A68D541C85D26508E83_482208058 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_482208058 = clientSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_482208058.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_482208058;
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.361 -0400", hash_original_field = "FE12143B9433BC939A46323087706E75", hash_generated_field = "705088B5C2C8B220095047F197D99BA7")

    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
}

