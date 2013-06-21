package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.Security;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public final class DefaultSSLContextImpl extends OpenSSLContextImpl {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.732 -0400", hash_original_method = "09005AB24FD7DF4C7BE4D5BB1BAB63A4", hash_generated_method = "27FF8CAC18843404200B5A7748448204")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DefaultSSLContextImpl() throws GeneralSecurityException, IOException {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.733 -0400", hash_original_method = "E512CF487829C633B2731FE964DEE240", hash_generated_method = "17F3D56AC4B54C1E2054CABD04EDAF52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {
        String keystore;
        keystore = System.getProperty("javax.net.ssl.keyStore");
        String keystorepwd;
        keystorepwd = System.getProperty("javax.net.ssl.keyStorePassword");
        char[] pwd;
        pwd = null;
        pwd = keystorepwd.toCharArray();
        KeyStore ks;
        ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is;
        is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } //End block
        finally 
        {
            {
                is.close();
            } //End block
        } //End block
        String kmfAlg;
        kmfAlg = Security.getProperty("ssl.KeyManagerFactory.algorithm");
        {
            kmfAlg = "SunX509";
        } //End block
        KeyManagerFactory kmf;
        kmf = KeyManagerFactory.getInstance(kmfAlg);
        kmf.init(ks, pwd);
        KEY_MANAGERS = kmf.getKeyManagers();
        return (KeyManager[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.734 -0400", hash_original_method = "06C43D579C0D6CACEEC14574641391C0", hash_generated_method = "3502CB366BA207D0D3E666DBB09CE713")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
        String keystore;
        keystore = System.getProperty("javax.net.ssl.trustStore");
        String keystorepwd;
        keystorepwd = System.getProperty("javax.net.ssl.trustStorePassword");
        char[] pwd;
        pwd = null;
        pwd = keystorepwd.toCharArray();
        KeyStore ks;
        ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is;
        is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } //End block
        finally 
        {
            {
                is.close();
            } //End block
        } //End block
        String tmfAlg;
        tmfAlg = Security.getProperty("ssl.TrustManagerFactory.algorithm");
        {
            tmfAlg = "PKIX";
        } //End block
        TrustManagerFactory tmf;
        tmf = TrustManagerFactory.getInstance(tmfAlg);
        tmf.init(ks);
        TRUST_MANAGERS = tmf.getTrustManagers();
        return (TrustManager[])dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.734 -0400", hash_original_method = "C6A638FBF6A76AC1A136D02168ED58AC", hash_generated_method = "DA70F2F2552D1C15C11A07952116DB17")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        dsTaint.addTaint(kms[0].dsTaint);
        dsTaint.addTaint(tms[0].dsTaint);
        dsTaint.addTaint(sr.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("Do not init() the default SSLContext ");
        // ---------- Original Method ----------
        //throw new KeyManagementException("Do not init() the default SSLContext ");
    }

    
    private static KeyManager[] KEY_MANAGERS;
    private static TrustManager[] TRUST_MANAGERS;
}

