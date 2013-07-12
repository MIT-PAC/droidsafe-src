package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.304 -0400", hash_original_method = "09005AB24FD7DF4C7BE4D5BB1BAB63A4", hash_generated_method = "27FF8CAC18843404200B5A7748448204")
    public  DefaultSSLContextImpl() throws GeneralSecurityException, IOException {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.305 -0400", hash_original_method = "E512CF487829C633B2731FE964DEE240", hash_generated_method = "7FC650199DD18F9F92FAB70C45FE18AE")
     KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {
    if(KEY_MANAGERS != null)        
        {
KeyManager[] varE51930CD0E72C78868ADFB1CB33F038E_1275002385 =             KEY_MANAGERS;
            varE51930CD0E72C78868ADFB1CB33F038E_1275002385.addTaint(taint);
            return varE51930CD0E72C78868ADFB1CB33F038E_1275002385;
        } //End block
        String keystore = System.getProperty("javax.net.ssl.keyStore");
    if(keystore == null)        
        {
KeyManager[] var540C13E9E156B687226421B24F2DF178_429318030 =             null;
            var540C13E9E156B687226421B24F2DF178_429318030.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_429318030;
        } //End block
        String keystorepwd = System.getProperty("javax.net.ssl.keyStorePassword");
        char[] pwd = (keystorepwd == null) ? null : keystorepwd.toCharArray();
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } //End block
        finally 
        {
    if(is != null)            
            {
                is.close();
            } //End block
        } //End block
        String kmfAlg = Security.getProperty("ssl.KeyManagerFactory.algorithm");
    if(kmfAlg == null)        
        {
            kmfAlg = "SunX509";
        } //End block
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(kmfAlg);
        kmf.init(ks, pwd);
        KEY_MANAGERS = kmf.getKeyManagers();
KeyManager[] varE51930CD0E72C78868ADFB1CB33F038E_135523360 =         KEY_MANAGERS;
        varE51930CD0E72C78868ADFB1CB33F038E_135523360.addTaint(taint);
        return varE51930CD0E72C78868ADFB1CB33F038E_135523360;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.306 -0400", hash_original_method = "06C43D579C0D6CACEEC14574641391C0", hash_generated_method = "CA4C35B13D1CF1F96AFCC31F4616B31B")
     TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
    if(TRUST_MANAGERS != null)        
        {
TrustManager[] var156E2C36687C9A83D6CBE6ED027CD2EC_1617067858 =             TRUST_MANAGERS;
            var156E2C36687C9A83D6CBE6ED027CD2EC_1617067858.addTaint(taint);
            return var156E2C36687C9A83D6CBE6ED027CD2EC_1617067858;
        } //End block
        String keystore = System.getProperty("javax.net.ssl.trustStore");
    if(keystore == null)        
        {
TrustManager[] var540C13E9E156B687226421B24F2DF178_108439513 =             null;
            var540C13E9E156B687226421B24F2DF178_108439513.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_108439513;
        } //End block
        String keystorepwd = System.getProperty("javax.net.ssl.trustStorePassword");
        char[] pwd = (keystorepwd == null) ? null : keystorepwd.toCharArray();
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        InputStream is = null;
        try 
        {
            is = new BufferedInputStream(new FileInputStream(keystore));
            ks.load(is, pwd);
        } //End block
        finally 
        {
    if(is != null)            
            {
                is.close();
            } //End block
        } //End block
        String tmfAlg = Security.getProperty("ssl.TrustManagerFactory.algorithm");
    if(tmfAlg == null)        
        {
            tmfAlg = "PKIX";
        } //End block
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlg);
        tmf.init(ks);
        TRUST_MANAGERS = tmf.getTrustManagers();
TrustManager[] var156E2C36687C9A83D6CBE6ED027CD2EC_2056932074 =         TRUST_MANAGERS;
        var156E2C36687C9A83D6CBE6ED027CD2EC_2056932074.addTaint(taint);
        return var156E2C36687C9A83D6CBE6ED027CD2EC_2056932074;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.307 -0400", hash_original_method = "C6A638FBF6A76AC1A136D02168ED58AC", hash_generated_method = "E2514C0D05FC2FFA5D67AAAD5EE4682A")
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        addTaint(sr.getTaint());
        addTaint(tms[0].getTaint());
        addTaint(kms[0].getTaint());
        KeyManagementException var5786FA98FB702651E7EDC138672FE4BB_1417077344 = new KeyManagementException("Do not init() the default SSLContext ");
        var5786FA98FB702651E7EDC138672FE4BB_1417077344.addTaint(taint);
        throw var5786FA98FB702651E7EDC138672FE4BB_1417077344;
        // ---------- Original Method ----------
        //throw new KeyManagementException("Do not init() the default SSLContext ");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.307 -0400", hash_original_field = "6406B1A35F8CB91653CE99D70BDA8752", hash_generated_field = "566D6B41A10785704C5DA62CA709142C")

    private static KeyManager[] KEY_MANAGERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:32.307 -0400", hash_original_field = "C393FECAAE49BABEA370F02A9C12D866", hash_generated_field = "1EC7739BDEC2CA831D3D4FE81BA648C0")

    private static TrustManager[] TRUST_MANAGERS;
}

