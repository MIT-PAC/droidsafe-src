package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.804 -0500", hash_original_field = "4EBEB241E2C5CFE70E86D8F5229E7F98", hash_generated_field = "705088B5C2C8B220095047F197D99BA7")

    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.806 -0500", hash_original_field = "8E8521E081F3C427EBF3E28A6604360E", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private  ClientSessionContext clientSessionContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.808 -0500", hash_original_field = "0A4FD2C76E9BCAC96781A2CAB12D37FF", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private  ServerSessionContext serverSessionContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.811 -0500", hash_original_field = "8EC89ADA2574F1DBC3DD4508F1BBC0BF", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.813 -0500", hash_original_method = "BB3D0F5B2222977574D305A8CAD6912B", hash_generated_method = "A37171A2B26C512FA6F9A10F6396EDDE")
    
public SSLContextImpl() {
        clientSessionContext = new ClientSessionContext();
        serverSessionContext = new ServerSessionContext();
    }

    /**
     * Constuctor for the DefaultSSLContextImpl.
     * @param dummy is null, used to distinguish this case from the
     * public SSLContextImpl() constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.816 -0500", hash_original_method = "81573CDE574A4A011582FBBAB6C3BF9A", hash_generated_method = "DDC5F638976233F286292B031A334A35")
    
protected SSLContextImpl(DefaultSSLContextImpl dummy)
            throws GeneralSecurityException, IOException {
        synchronized (DefaultSSLContextImpl.class) {
            if (DEFAULT_SSL_CONTEXT_IMPL == null) {
                clientSessionContext = new ClientSessionContext();
                serverSessionContext = new ServerSessionContext();
                DEFAULT_SSL_CONTEXT_IMPL = (DefaultSSLContextImpl)this;
            } else {
                clientSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetClientSessionContext();
                serverSessionContext = DEFAULT_SSL_CONTEXT_IMPL.engineGetServerSessionContext();
            }
            sslParameters = new SSLParametersImpl(DEFAULT_SSL_CONTEXT_IMPL.getKeyManagers(),
                                                  DEFAULT_SSL_CONTEXT_IMPL.getTrustManagers(),
                                                  null,
                                                  clientSessionContext,
                                                  serverSessionContext);
        }
    }

    /**
     * Initializes this {@code SSLContext} instance. All of the arguments are
     * optional, and the security providers will be searched for the required
     * implementations of the needed algorithms.
     *
     * @param kms the key sources or {@code null}
     * @param tms the trust decision sources or {@code null}
     * @param sr the randomness source or {@code null}
     * @throws KeyManagementException if initializing this instance fails
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.818 -0500", hash_original_method = "0824770EA02EDCBB315A7517C68CBF9B", hash_generated_method = "8A6A79DD13B7E2A9B79DA93F7EBA3242")
    
@Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              clientSessionContext, serverSessionContext);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.821 -0500", hash_original_method = "004191AE8609FCF33514DFCEA01A5714", hash_generated_method = "FEAC40969EF226E8C9338293FFEF9AD5")
    
@Override
    public SSLSocketFactory engineGetSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new SSLSocketFactoryImpl(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.823 -0500", hash_original_method = "65E8F32416A9204F9A4329BBE6993AED", hash_generated_method = "C8260B35FC007519CDBB4097A4224827")
    
@Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        return new SSLServerSocketFactoryImpl(sslParameters);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.826 -0500", hash_original_method = "29CE564F844B35192AD02B59CF29ABFD", hash_generated_method = "D57CD206451365A44649914A2C3B2F44")
    
@Override
    public SSLEngine engineCreateSSLEngine(String host, int port) {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        return new SSLEngineImpl(host, port, p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.828 -0500", hash_original_method = "1B7221E2350F2BEF0C28DC221F83475D", hash_generated_method = "CE8ECCBD5D2D2B2E80B200EE9FA3A014")
    
@Override
    public SSLEngine engineCreateSSLEngine() {
        if (sslParameters == null) {
            throw new IllegalStateException("SSLContext is not initialized.");
        }
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        return new SSLEngineImpl(p);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.831 -0500", hash_original_method = "D250F9B5B60A63355C4DD3366841F3DE", hash_generated_method = "D0DD72853B05C7E5C456A722E0C3F6A0")
    
@Override
    public ServerSessionContext engineGetServerSessionContext() {
        return serverSessionContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.833 -0500", hash_original_method = "F7A52ACBCF1ABAC2A6697027AD059F72", hash_generated_method = "D20472D200553EF55F94943E57396D56")
    
@Override
    public ClientSessionContext engineGetClientSessionContext() {
        return clientSessionContext;
    }
}

