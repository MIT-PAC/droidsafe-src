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
    private ClientSessionContext clientSessionContext;
    private ServerSessionContext serverSessionContext;
    protected SSLParametersImpl sslParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.094 -0400", hash_original_method = "BB3D0F5B2222977574D305A8CAD6912B", hash_generated_method = "C2EBBF6280DAA1C2D96BF5ECCA7861E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SSLContextImpl() {
        clientSessionContext = new ClientSessionContext();
        serverSessionContext = new ServerSessionContext();
        // ---------- Original Method ----------
        //clientSessionContext = new ClientSessionContext();
        //serverSessionContext = new ServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.094 -0400", hash_original_method = "81573CDE574A4A011582FBBAB6C3BF9A", hash_generated_method = "0446A20D1147425D0B2FE2265AAE7795")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        dsTaint.addTaint(dummy.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.094 -0400", hash_original_method = "0824770EA02EDCBB315A7517C68CBF9B", hash_generated_method = "C8D4A2FBD1F2958F90A56B3A09EF7646")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        dsTaint.addTaint(kms[0].dsTaint);
        dsTaint.addTaint(tms[0].dsTaint);
        dsTaint.addTaint(sr.dsTaint);
        sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              clientSessionContext, serverSessionContext);
        // ---------- Original Method ----------
        //sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              //clientSessionContext, serverSessionContext);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.095 -0400", hash_original_method = "004191AE8609FCF33514DFCEA01A5714", hash_generated_method = "37274F3FEC8415FE3696FF737F2D960A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLSocketFactory varA94E961FDF8645C67D1D8264B005FB05_1141368258 = (new SSLSocketFactoryImpl(sslParameters));
        return (SSLSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.095 -0400", hash_original_method = "65E8F32416A9204F9A4329BBE6993AED", hash_generated_method = "A9306D02FEB9CF3D4E3BEFCBD1BA1066")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLServerSocketFactory varBD871B6656F712EBE9D0834311DBD534_1254561985 = (new SSLServerSocketFactoryImpl(sslParameters));
        return (SSLServerSocketFactory)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLServerSocketFactoryImpl(sslParameters);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.095 -0400", hash_original_method = "29CE564F844B35192AD02B59CF29ABFD", hash_generated_method = "6CB17C0E5E7424A46390B3F3963B5DDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLEngine engineCreateSSLEngine(String host, int port) {
        dsTaint.addTaint(port);
        dsTaint.addTaint(host);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLParametersImpl p;
        p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        SSLEngine var82E903F477FA428EF04E9F4237E0B394_644359771 = (new SSLEngineImpl(host, port, p));
        return (SSLEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(host, port, p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.095 -0400", hash_original_method = "1B7221E2350F2BEF0C28DC221F83475D", hash_generated_method = "E8BC148B014112F5DE11F1BA3A6F68AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SSLEngine engineCreateSSLEngine() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("SSLContext is not initialized.");
        } //End block
        SSLParametersImpl p;
        p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
        SSLEngine var785504DDDC4F5BEFB0D108607C822AE9_1201779899 = (new SSLEngineImpl(p));
        return (SSLEngine)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(p);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.095 -0400", hash_original_method = "D250F9B5B60A63355C4DD3366841F3DE", hash_generated_method = "7743C3DE032AE84E561FD1F5C9F6973E")
    @DSModeled(DSC.SAFE)
    @Override
    public ServerSessionContext engineGetServerSessionContext() {
        return (ServerSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.096 -0400", hash_original_method = "F7A52ACBCF1ABAC2A6697027AD059F72", hash_generated_method = "A4D573996DA7B201B8DAF2DAAEE41BEE")
    @DSModeled(DSC.SAFE)
    @Override
    public ClientSessionContext engineGetClientSessionContext() {
        return (ClientSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
}

