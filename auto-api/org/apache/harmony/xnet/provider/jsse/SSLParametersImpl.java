package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.xnet.provider.jsse.TrustManagerImpl;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

public class SSLParametersImpl implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.481 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.481 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.481 -0400", hash_original_field = "FEEE4479298DE16A0EB1A633D957D109", hash_generated_field = "2E4F2E1D2FA6BF13888F77364F60E097")

    private X509KeyManager keyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.481 -0400", hash_original_field = "1FB3B48DC5704D7EC12F3F1A1D0B81BF", hash_generated_field = "E649160E3435877F729D449D50C5DE3D")

    private X509TrustManager trustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.481 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "C638DD7688AC4130134CFC7C318E4412")

    private SecureRandom secureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "B2BC3BDD2580C2157EC8D2FC1FA485E7")

    private CipherSuite[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "4A8CBEF3414DD8C3B53B3E3B266D848D", hash_generated_field = "11B1E6E8AC3FE562986A7A98A8FD87BA")

    private String[] enabledCipherSuiteNames = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "4F9BA8ECD9F1AEA9766E9176AF5EC4E2", hash_generated_field = "C765220B91F8DE65CC416D29CE9EDA38")

    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "D944610A48E928E3C58952AC7D9B5574", hash_generated_field = "70621FE8C45C8B2EFCD3777571ACB2D2")

    private boolean client_mode = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "1C6B39EBC78C0DFBA4B33AF393E1EDC9", hash_generated_field = "64B13B8CA853720DE9965C8FA56B90B2")

    private boolean need_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "CFDE7026DAC64F33A41642BF69543E29", hash_generated_field = "C39494A6736ADE40C8F76790B0C56C0E")

    private boolean want_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.482 -0400", hash_original_field = "D93C2AC5DC8ED50B941C3E646827F942", hash_generated_field = "785E0391576E98C2512A899B702A5327")

    private boolean enable_session_creation = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.496 -0400", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "13F37D89ADCDAE7F23C05AAA16823EE5")
    protected  SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        {
            keyManager = getDefaultKeyManager();
        } //End block
        {
            keyManager = findX509KeyManager(kms);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("No X509KeyManager found");
        } //End block
        {
            trustManager = getDefaultTrustManager();
        } //End block
        {
            trustManager = findX509TrustManager(tms);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("No X509TrustManager found");
        } //End block
        secureRandom = sr;
        // ---------- Original Method ----------
        //this.serverSessionContext = serverSessionContext;
        //this.clientSessionContext = clientSessionContext;
        //if ((kms == null) || (kms.length == 0)) {
            //keyManager = getDefaultKeyManager();
        //} else {
            //keyManager = findX509KeyManager(kms);
        //}
        //if (keyManager == null) {
            //throw new KeyManagementException("No X509KeyManager found");
        //}
        //if ((tms == null) || (tms.length == 0)) {
            //trustManager = getDefaultTrustManager();
        //} else {
            //trustManager = findX509TrustManager(tms);
        //}
        //if (trustManager == null) {
            //throw new KeyManagementException("No X509TrustManager found");
        //}
        //secureRandom = sr;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.498 -0400", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "804D12D0F1A39ECE963E846402AD872C")
    protected CipherSuite[] getEnabledCipherSuitesMember() {
        CipherSuite[] varB4EAC82CA7396A68D541C85D26508E83_1755395011 = null; //Variable for return #1
        {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1755395011 = enabledCipherSuites;
        varB4EAC82CA7396A68D541C85D26508E83_1755395011.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1755395011;
        // ---------- Original Method ----------
        //if (enabledCipherSuites == null) {
            //this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        //}
        //return enabledCipherSuites;
    }

    
        protected static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl result = defaultParameters;
        if (result == null) {
            defaultParameters = result = new SSLParametersImpl(null,
                                                               null,
                                                               null,
                                                               new ClientSessionContext(),
                                                               new ServerSessionContext());
        }
        return (SSLParametersImpl) result.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.504 -0400", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "939DB1E6398B83E2FFAD24E5A4780A48")
    protected ServerSessionContext getServerSessionContext() {
        ServerSessionContext varB4EAC82CA7396A68D541C85D26508E83_991267151 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_991267151 = serverSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_991267151.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_991267151;
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.508 -0400", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "B77A3D9D4D70120748146EA94F370E63")
    protected ClientSessionContext getClientSessionContext() {
        ClientSessionContext varB4EAC82CA7396A68D541C85D26508E83_567587831 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_567587831 = clientSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_567587831.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_567587831;
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.508 -0400", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "24FA161FC2FAE3FF65E1E0A99E868029")
    protected X509KeyManager getKeyManager() {
        X509KeyManager varB4EAC82CA7396A68D541C85D26508E83_51940851 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_51940851 = keyManager;
        varB4EAC82CA7396A68D541C85D26508E83_51940851.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_51940851;
        // ---------- Original Method ----------
        //return keyManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.509 -0400", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "314F81A77E6144F6BFF621BB39C2CFF1")
    protected X509TrustManager getTrustManager() {
        X509TrustManager varB4EAC82CA7396A68D541C85D26508E83_1232627208 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1232627208 = trustManager;
        varB4EAC82CA7396A68D541C85D26508E83_1232627208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1232627208;
        // ---------- Original Method ----------
        //return trustManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.509 -0400", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "AC138D588FC68B15CEF09353C138DDA1")
    protected SecureRandom getSecureRandom() {
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_365526954 = null; //Variable for return #1
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_702266571 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_365526954 = secureRandom;
        } //End block
        SecureRandom result;
        result = defaultSecureRandom;
        {
            defaultSecureRandom = result = new SecureRandom();
        } //End block
        secureRandom = result;
        varB4EAC82CA7396A68D541C85D26508E83_702266571 = secureRandom;
        SecureRandom varA7E53CE21691AB073D9660D615818899_1624411601; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1624411601 = varB4EAC82CA7396A68D541C85D26508E83_365526954;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1624411601 = varB4EAC82CA7396A68D541C85D26508E83_702266571;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1624411601.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1624411601;
        // ---------- Original Method ----------
        //if (secureRandom != null) {
            //return secureRandom;
        //}
        //SecureRandom result = defaultSecureRandom;
        //if (result == null) {
            //defaultSecureRandom = result = new SecureRandom();
        //}
        //secureRandom = result;
        //return secureRandom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.510 -0400", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "FCA2824B84471F57E0FE0766FA9F990F")
    protected SecureRandom getSecureRandomMember() {
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_2145458703 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2145458703 = secureRandom;
        varB4EAC82CA7396A68D541C85D26508E83_2145458703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2145458703;
        // ---------- Original Method ----------
        //return secureRandom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.518 -0400", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "42BECB65FF5F5C05E946540FB5021358")
    protected String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_585053266 = null; //Variable for return #1
        {
            CipherSuite[] enabledCipherSuites;
            enabledCipherSuites = getEnabledCipherSuitesMember();
            enabledCipherSuiteNames = new String[enabledCipherSuites.length];
            {
                int i;
                i = 0;
                {
                    enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_585053266 = enabledCipherSuiteNames.clone();
        varB4EAC82CA7396A68D541C85D26508E83_585053266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585053266;
        // ---------- Original Method ----------
        //if (enabledCipherSuiteNames == null) {
            //CipherSuite[] enabledCipherSuites = getEnabledCipherSuitesMember();
            //enabledCipherSuiteNames = new String[enabledCipherSuites.length];
            //for (int i = 0; i< enabledCipherSuites.length; i++) {
                //enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
            //}
        //}
        //return enabledCipherSuiteNames.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.518 -0400", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "78139F15E915DCFE6543CE37A26E95FB")
    protected void setEnabledCipherSuites(String[] suites) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("suites == null");
        } //End block
        CipherSuite[] cipherSuites;
        cipherSuites = new CipherSuite[suites.length];
        {
            int i;
            i = 0;
            {
                String suite;
                suite = suites[i];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("suites[" + i + "] == null");
                } //End block
                cipherSuites[i] = CipherSuite.getByName(suite);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(suite + " is not supported.");
                } //End block
            } //End block
        } //End collapsed parenthetic
        enabledCipherSuites = cipherSuites;
        enabledCipherSuiteNames = suites;
        // ---------- Original Method ----------
        //if (suites == null) {
            //throw new IllegalArgumentException("suites == null");
        //}
        //CipherSuite[] cipherSuites = new CipherSuite[suites.length];
        //for (int i=0; i<suites.length; i++) {
            //String suite = suites[i];
            //if (suite == null) {
                //throw new IllegalArgumentException("suites[" + i + "] == null");
            //}
            //cipherSuites[i] = CipherSuite.getByName(suite);
            //if (cipherSuites[i] == null || !cipherSuites[i].supported) {
                //throw new IllegalArgumentException(suite + " is not supported.");
            //}
        //}
        //enabledCipherSuites = cipherSuites;
        //enabledCipherSuiteNames = suites;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.519 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "18C2A7272CF134E78A976A1592AD1BB5")
    protected String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1377114923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1377114923 = enabledProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1377114923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1377114923;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.519 -0400", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "7E33EB63DE5B30229C4C2BAEB1D008DF")
    protected void setEnabledProtocols(String[] protocols) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("protocols == null");
        } //End block
        {
            int i;
            i = 0;
            {
                String protocol;
                protocol = protocols[i];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("protocols[" + i + "] == null");
                } //End block
                {
                    boolean var62D8EE37F0681C110B52FBB58EB4EBEE_359493281 = (!ProtocolVersion.isSupported(protocol));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Protocol " + protocol + " is not supported.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        enabledProtocols = protocols;
        // ---------- Original Method ----------
        //if (protocols == null) {
            //throw new IllegalArgumentException("protocols == null");
        //}
        //for (int i=0; i<protocols.length; i++) {
            //String protocol = protocols[i];
            //if (protocol == null) {
                //throw new IllegalArgumentException("protocols[" + i + "] == null");
            //}
            //if (!ProtocolVersion.isSupported(protocol)) {
                //throw new IllegalArgumentException("Protocol " + protocol + " is not supported.");
            //}
        //}
        //enabledProtocols = protocols;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.521 -0400", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "887DE4735EDEE4C8E4C83849AF3EB99A")
    protected void setUseClientMode(boolean mode) {
        client_mode = mode;
        // ---------- Original Method ----------
        //client_mode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.521 -0400", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "C93A10A4AF8168727F0ED8C0CDE1619F")
    protected boolean getUseClientMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1336929006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1336929006;
        // ---------- Original Method ----------
        //return client_mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.521 -0400", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "52A5FCBC97E504C4D517CB08073F3187")
    protected void setNeedClientAuth(boolean need) {
        need_client_auth = need;
        want_client_auth = false;
        // ---------- Original Method ----------
        //need_client_auth = need;
        //want_client_auth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.521 -0400", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "564FB3328AF21FF80A9D89BDBD508596")
    protected boolean getNeedClientAuth() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1938295766 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1938295766;
        // ---------- Original Method ----------
        //return need_client_auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.523 -0400", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "720F660EEC765CE9DA60BECAD1888659")
    protected void setWantClientAuth(boolean want) {
        want_client_auth = want;
        need_client_auth = false;
        // ---------- Original Method ----------
        //want_client_auth = want;
        //need_client_auth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.523 -0400", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "F96782BEC2DC5A2325CA2E6D646AEDC0")
    protected boolean getWantClientAuth() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_979569626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_979569626;
        // ---------- Original Method ----------
        //return want_client_auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.523 -0400", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "28552D8F807A40A67118E4FFED07DB76")
    protected void setEnableSessionCreation(boolean flag) {
        enable_session_creation = flag;
        // ---------- Original Method ----------
        //enable_session_creation = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.523 -0400", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "3D63911AB10A2C04534A9CAB235084FC")
    protected boolean getEnableSessionCreation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1052362251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1052362251;
        // ---------- Original Method ----------
        //return enable_session_creation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.526 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "ACE8D5C226FD0323AAEE21669E44B13B")
    @Override
    protected Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1260690819 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1260690819 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1260690819.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1260690819;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        private static X509KeyManager getDefaultKeyManager() {
        X509KeyManager result = defaultKeyManager;
        if (result == null) {
            defaultKeyManager = result = createDefaultKeyManager();
        }
        return result;
    }

    
        private static X509KeyManager createDefaultKeyManager() {
        try {
            String algorithm = KeyManagerFactory.getDefaultAlgorithm();
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
            kmf.init(null, null);
            KeyManager[] kms = kmf.getKeyManagers();
            return findX509KeyManager(kms);
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (KeyStoreException e) {
            return null;
        } catch (UnrecoverableKeyException e) {
            return null;
        }
    }

    
        private static X509KeyManager findX509KeyManager(KeyManager[] kms) {
        for (KeyManager km : kms) {
            if (km instanceof X509KeyManager) {
                return (X509KeyManager)km;
            }
        }
        return null;
    }

    
        public static X509TrustManager getDefaultTrustManager() {
        X509TrustManager result = defaultTrustManager;
        if (result == null) {
            defaultTrustManager = result = createDefaultTrustManager();
        }
        return result;
    }

    
        private static X509TrustManager createDefaultTrustManager() {
        try {
            String algorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(algorithm);
            tmf.init((KeyStore) null);
            TrustManager[] tms = tmf.getTrustManagers();
            X509TrustManager trustManager = findX509TrustManager(tms);
            return trustManager;
        } catch (NoSuchAlgorithmException e) {
            return null;
        } catch (KeyStoreException e) {
            return null;
        }
    }

    
        private static X509TrustManager findX509TrustManager(TrustManager[] tms) {
        for (TrustManager tm : tms) {
            if (tm instanceof X509TrustManager) {
                return (X509TrustManager)tm;
            }
        }
        return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.531 -0400", hash_original_field = "263BBC6767A6C30BC5791BB210D09DF6", hash_generated_field = "2247CCCD3A9C64F5AC74EB2D7BBE823D")

    private static volatile X509KeyManager defaultKeyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.531 -0400", hash_original_field = "AFB552263B64C1DDF9B755A487D86AA1", hash_generated_field = "D8E61E16921257FD780C18C1DD48E30F")

    private static volatile X509TrustManager defaultTrustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.531 -0400", hash_original_field = "A6B2A5244F9D096900425922319189A3", hash_generated_field = "EE9A8654B1BF8C4636FFC69BB2ED4F02")

    private static volatile SecureRandom defaultSecureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.531 -0400", hash_original_field = "13C31DFDDE13D82609E8368C21A7AE91", hash_generated_field = "4E48D99E9C1BEE305569803DC06C2E6D")

    private static volatile SSLParametersImpl defaultParameters;
}

