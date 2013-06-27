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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.929 -0400", hash_original_method = "09005AB24FD7DF4C7BE4D5BB1BAB63A4", hash_generated_method = "27FF8CAC18843404200B5A7748448204")
    public  DefaultSSLContextImpl() throws GeneralSecurityException, IOException {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.938 -0400", hash_original_method = "E512CF487829C633B2731FE964DEE240", hash_generated_method = "472465C2C2D2B0E955537B686F9397E1")
     KeyManager[] getKeyManagers() throws GeneralSecurityException, IOException {
        KeyManager[] varB4EAC82CA7396A68D541C85D26508E83_1345753917 = null; //Variable for return #1
        KeyManager[] varB4EAC82CA7396A68D541C85D26508E83_2030868462 = null; //Variable for return #2
        KeyManager[] varB4EAC82CA7396A68D541C85D26508E83_567616071 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1345753917 = KEY_MANAGERS;
        } //End block
        String keystore;
        keystore = System.getProperty("javax.net.ssl.keyStore");
        {
            varB4EAC82CA7396A68D541C85D26508E83_2030868462 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_567616071 = KEY_MANAGERS;
        KeyManager[] varA7E53CE21691AB073D9660D615818899_1956961922; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1956961922 = varB4EAC82CA7396A68D541C85D26508E83_1345753917;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1956961922 = varB4EAC82CA7396A68D541C85D26508E83_2030868462;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1956961922 = varB4EAC82CA7396A68D541C85D26508E83_567616071;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1956961922.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1956961922;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.939 -0400", hash_original_method = "06C43D579C0D6CACEEC14574641391C0", hash_generated_method = "A41D9BA7CE06A14EC269EC90D2EFFB85")
     TrustManager[] getTrustManagers() throws GeneralSecurityException, IOException {
        TrustManager[] varB4EAC82CA7396A68D541C85D26508E83_2030253883 = null; //Variable for return #1
        TrustManager[] varB4EAC82CA7396A68D541C85D26508E83_1247309958 = null; //Variable for return #2
        TrustManager[] varB4EAC82CA7396A68D541C85D26508E83_744267324 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2030253883 = TRUST_MANAGERS;
        } //End block
        String keystore;
        keystore = System.getProperty("javax.net.ssl.trustStore");
        {
            varB4EAC82CA7396A68D541C85D26508E83_1247309958 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_744267324 = TRUST_MANAGERS;
        TrustManager[] varA7E53CE21691AB073D9660D615818899_692785044; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_692785044 = varB4EAC82CA7396A68D541C85D26508E83_2030253883;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_692785044 = varB4EAC82CA7396A68D541C85D26508E83_1247309958;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_692785044 = varB4EAC82CA7396A68D541C85D26508E83_744267324;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_692785044.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_692785044;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.944 -0400", hash_original_method = "C6A638FBF6A76AC1A136D02168ED58AC", hash_generated_method = "6216B43478FB7C8C14B606D25980A7A2")
    @Override
    public void engineInit(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr) throws KeyManagementException {
        if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("Do not init() the default SSLContext ");
        addTaint(kms[0].getTaint());
        addTaint(tms[0].getTaint());
        addTaint(sr.getTaint());
        // ---------- Original Method ----------
        //throw new KeyManagementException("Do not init() the default SSLContext ");
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.944 -0400", hash_original_field = "6406B1A35F8CB91653CE99D70BDA8752", hash_generated_field = "566D6B41A10785704C5DA62CA709142C")

    private static KeyManager[] KEY_MANAGERS;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.944 -0400", hash_original_field = "C393FECAAE49BABEA370F02A9C12D866", hash_generated_field = "1EC7739BDEC2CA831D3D4FE81BA648C0")

    private static TrustManager[] TRUST_MANAGERS;
}

