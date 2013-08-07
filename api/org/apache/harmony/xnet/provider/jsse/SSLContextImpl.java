package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.075 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.075 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.075 -0400", hash_original_field = "275693D255E1C48D7D5797E25BF7F3FC", hash_generated_field = "193A05E0CE57E1D6165874B1C5DC807D")

    protected SSLParametersImpl sslParameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.076 -0400", hash_original_method = "BB3D0F5B2222977574D305A8CAD6912B", hash_generated_method = "C2EBBF6280DAA1C2D96BF5ECCA7861E1")
    public  SSLContextImpl() {
        clientSessionContext = new ClientSessionContext();
        serverSessionContext = new ServerSessionContext();
        // ---------- Original Method ----------
        //clientSessionContext = new ClientSessionContext();
        //serverSessionContext = new ServerSessionContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.077 -0400", hash_original_method = "81573CDE574A4A011582FBBAB6C3BF9A", hash_generated_method = "D2C05BB72B59952B500C0972419E7AD8")
    protected  SSLContextImpl(DefaultSSLContextImpl dummy) throws GeneralSecurityException, IOException {
        addTaint(dummy.getTaint());
        synchronized
(DefaultSSLContextImpl.class)        {
            if(DEFAULT_SSL_CONTEXT_IMPL == null)            
            {
                clientSessionContext = new ClientSessionContext();
                serverSessionContext = new ServerSessionContext();
                DEFAULT_SSL_CONTEXT_IMPL = (DefaultSSLContextImpl)this;
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.078 -0400", hash_original_method = "0824770EA02EDCBB315A7517C68CBF9B", hash_generated_method = "5ED612AF34CD0AC820A10D3E7C4E5A8B")
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              clientSessionContext, serverSessionContext);
        // ---------- Original Method ----------
        //sslParameters = new SSLParametersImpl(kms, tms, sr,
                                              //clientSessionContext, serverSessionContext);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.078 -0400", hash_original_method = "004191AE8609FCF33514DFCEA01A5714", hash_generated_method = "874E5F58309924AE54ABA09939F73266")
    @Override
    public SSLSocketFactory engineGetSocketFactory() {
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_1765008952 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_1765008952.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_1765008952;
        } //End block
SSLSocketFactory varD866F76D407F66984611D788DE50D243_1457338077 =         new SSLSocketFactoryImpl(sslParameters);
        varD866F76D407F66984611D788DE50D243_1457338077.addTaint(taint);
        return varD866F76D407F66984611D788DE50D243_1457338077;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLSocketFactoryImpl(sslParameters);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.079 -0400", hash_original_method = "65E8F32416A9204F9A4329BBE6993AED", hash_generated_method = "2BC54FBBFBEE5D0CAD23B461EFAFECA3")
    @Override
    public SSLServerSocketFactory engineGetServerSocketFactory() {
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_598772484 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_598772484.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_598772484;
        } //End block
SSLServerSocketFactory varBE5DD6464E3726ADF417C1BBB9EB6CEA_1683421403 =         new SSLServerSocketFactoryImpl(sslParameters);
        varBE5DD6464E3726ADF417C1BBB9EB6CEA_1683421403.addTaint(taint);
        return varBE5DD6464E3726ADF417C1BBB9EB6CEA_1683421403;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //return new SSLServerSocketFactoryImpl(sslParameters);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.080 -0400", hash_original_method = "29CE564F844B35192AD02B59CF29ABFD", hash_generated_method = "D7ACCED43364E3641EBC018E8CFB3A5B")
    @Override
    public SSLEngine engineCreateSSLEngine(String host, int port) {
        addTaint(port);
        addTaint(host.getTaint());
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_885689931 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_885689931.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_885689931;
        } //End block
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
SSLEngine var6DC08F9D892DA3576FB89C5E98C66023_1935083992 =         new SSLEngineImpl(host, port, p);
        var6DC08F9D892DA3576FB89C5E98C66023_1935083992.addTaint(taint);
        return var6DC08F9D892DA3576FB89C5E98C66023_1935083992;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(host, port, p);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.080 -0400", hash_original_method = "1B7221E2350F2BEF0C28DC221F83475D", hash_generated_method = "501A8C0C026EAD14D29BD7297B6A78BE")
    @Override
    public SSLEngine engineCreateSSLEngine() {
        if(sslParameters == null)        
        {
            IllegalStateException varC8351C8104E6525114445B68BAB6733B_1171130883 = new IllegalStateException("SSLContext is not initialized.");
            varC8351C8104E6525114445B68BAB6733B_1171130883.addTaint(taint);
            throw varC8351C8104E6525114445B68BAB6733B_1171130883;
        } //End block
        SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        p.setUseClientMode(false);
SSLEngine var3CF3392FBD56214EF1E101685DBC345A_503558983 =         new SSLEngineImpl(p);
        var3CF3392FBD56214EF1E101685DBC345A_503558983.addTaint(taint);
        return var3CF3392FBD56214EF1E101685DBC345A_503558983;
        // ---------- Original Method ----------
        //if (sslParameters == null) {
            //throw new IllegalStateException("SSLContext is not initialized.");
        //}
        //SSLParametersImpl p = (SSLParametersImpl) sslParameters.clone();
        //p.setUseClientMode(false);
        //return new SSLEngineImpl(p);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.081 -0400", hash_original_method = "D250F9B5B60A63355C4DD3366841F3DE", hash_generated_method = "BD63699E5023546FE7241BA37E311837")
    @Override
    public ServerSessionContext engineGetServerSessionContext() {
ServerSessionContext var100440D65E59DFFC2F85188BB92C5DF8_2087709003 =         serverSessionContext;
        var100440D65E59DFFC2F85188BB92C5DF8_2087709003.addTaint(taint);
        return var100440D65E59DFFC2F85188BB92C5DF8_2087709003;
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.081 -0400", hash_original_method = "F7A52ACBCF1ABAC2A6697027AD059F72", hash_generated_method = "A4840F2DC0048D5795D337DE48524A4C")
    @Override
    public ClientSessionContext engineGetClientSessionContext() {
ClientSessionContext varF881C293692092C9564353C09AD998B5_1945681464 =         clientSessionContext;
        varF881C293692092C9564353C09AD998B5_1945681464.addTaint(taint);
        return varF881C293692092C9564353C09AD998B5_1945681464;
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.081 -0400", hash_original_field = "FE12143B9433BC939A46323087706E75", hash_generated_field = "705088B5C2C8B220095047F197D99BA7")

    private static DefaultSSLContextImpl DEFAULT_SSL_CONTEXT_IMPL;
}

