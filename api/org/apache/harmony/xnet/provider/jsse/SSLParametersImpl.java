package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class SSLParametersImpl implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.308 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.308 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "FEEE4479298DE16A0EB1A633D957D109", hash_generated_field = "2E4F2E1D2FA6BF13888F77364F60E097")

    private X509KeyManager keyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "1FB3B48DC5704D7EC12F3F1A1D0B81BF", hash_generated_field = "E649160E3435877F729D449D50C5DE3D")

    private X509TrustManager trustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "C638DD7688AC4130134CFC7C318E4412")

    private SecureRandom secureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "B2BC3BDD2580C2157EC8D2FC1FA485E7")

    private CipherSuite[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "4A8CBEF3414DD8C3B53B3E3B266D848D", hash_generated_field = "11B1E6E8AC3FE562986A7A98A8FD87BA")

    private String[] enabledCipherSuiteNames = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "4F9BA8ECD9F1AEA9766E9176AF5EC4E2", hash_generated_field = "C765220B91F8DE65CC416D29CE9EDA38")

    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "D944610A48E928E3C58952AC7D9B5574", hash_generated_field = "70621FE8C45C8B2EFCD3777571ACB2D2")

    private boolean client_mode = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "1C6B39EBC78C0DFBA4B33AF393E1EDC9", hash_generated_field = "64B13B8CA853720DE9965C8FA56B90B2")

    private boolean need_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "CFDE7026DAC64F33A41642BF69543E29", hash_generated_field = "C39494A6736ADE40C8F76790B0C56C0E")

    private boolean want_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.309 -0400", hash_original_field = "D93C2AC5DC8ED50B941C3E646827F942", hash_generated_field = "785E0391576E98C2512A899B702A5327")

    private boolean enable_session_creation = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.311 -0400", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "1EF7F418E5CC28F5758ACB990BB8EDF5")
    protected  SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        if((kms == null) || (kms.length == 0))        
        {
            keyManager = getDefaultKeyManager();
        } //End block
        else
        {
            keyManager = findX509KeyManager(kms);
        } //End block
        if(keyManager == null)        
        {
            KeyManagementException varB4B4897F7D1096437D542031D15D197C_622357668 = new KeyManagementException("No X509KeyManager found");
            varB4B4897F7D1096437D542031D15D197C_622357668.addTaint(taint);
            throw varB4B4897F7D1096437D542031D15D197C_622357668;
        } //End block
        if((tms == null) || (tms.length == 0))        
        {
            trustManager = getDefaultTrustManager();
        } //End block
        else
        {
            trustManager = findX509TrustManager(tms);
        } //End block
        if(trustManager == null)        
        {
            KeyManagementException varA449CBA60048DE5D62BF8B7E29C90C7A_748210966 = new KeyManagementException("No X509TrustManager found");
            varA449CBA60048DE5D62BF8B7E29C90C7A_748210966.addTaint(taint);
            throw varA449CBA60048DE5D62BF8B7E29C90C7A_748210966;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.311 -0400", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "015C3D10154D93536568DAE31976F2EA")
    protected CipherSuite[] getEnabledCipherSuitesMember() {
        if(enabledCipherSuites == null)        
        {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        } //End block
CipherSuite[] var4FE9A25924581DEE872791EA4874412D_1212556164 =         enabledCipherSuites;
        var4FE9A25924581DEE872791EA4874412D_1212556164.addTaint(taint);
        return var4FE9A25924581DEE872791EA4874412D_1212556164;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.312 -0400", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "E88C44E6C43733DD5BAC38F5D0466A83")
    protected ServerSessionContext getServerSessionContext() {
ServerSessionContext var100440D65E59DFFC2F85188BB92C5DF8_759261662 =         serverSessionContext;
        var100440D65E59DFFC2F85188BB92C5DF8_759261662.addTaint(taint);
        return var100440D65E59DFFC2F85188BB92C5DF8_759261662;
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.312 -0400", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "EF0A8BD9C8BF4603F51CA4D5502894DF")
    protected ClientSessionContext getClientSessionContext() {
ClientSessionContext varF881C293692092C9564353C09AD998B5_203173424 =         clientSessionContext;
        varF881C293692092C9564353C09AD998B5_203173424.addTaint(taint);
        return varF881C293692092C9564353C09AD998B5_203173424;
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.313 -0400", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "E53DC79DDF4A887F8BFE591E9C39168A")
    protected X509KeyManager getKeyManager() {
X509KeyManager varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1259680318 =         keyManager;
        varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1259680318.addTaint(taint);
        return varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1259680318;
        // ---------- Original Method ----------
        //return keyManager;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.313 -0400", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "6BE023BFFBD40952082FF21DBC02687B")
    protected X509TrustManager getTrustManager() {
X509TrustManager var56C611970C82E9A90BA55937E8F17214_1184780114 =         trustManager;
        var56C611970C82E9A90BA55937E8F17214_1184780114.addTaint(taint);
        return var56C611970C82E9A90BA55937E8F17214_1184780114;
        // ---------- Original Method ----------
        //return trustManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.314 -0400", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "55F9A43B238D2DFD2C7A3111E1D48F0C")
    protected SecureRandom getSecureRandom() {
        if(secureRandom != null)        
        {
SecureRandom var61F46EA9C65D699D838C78C67875DF31_243043493 =             secureRandom;
            var61F46EA9C65D699D838C78C67875DF31_243043493.addTaint(taint);
            return var61F46EA9C65D699D838C78C67875DF31_243043493;
        } //End block
        SecureRandom result = defaultSecureRandom;
        if(result == null)        
        {
            defaultSecureRandom = result = new SecureRandom();
        } //End block
        secureRandom = result;
SecureRandom var61F46EA9C65D699D838C78C67875DF31_1225805903 =         secureRandom;
        var61F46EA9C65D699D838C78C67875DF31_1225805903.addTaint(taint);
        return var61F46EA9C65D699D838C78C67875DF31_1225805903;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.314 -0400", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "2995C341B4CB382F9F6A4BF03E02D104")
    protected SecureRandom getSecureRandomMember() {
SecureRandom var61F46EA9C65D699D838C78C67875DF31_1722737110 =         secureRandom;
        var61F46EA9C65D699D838C78C67875DF31_1722737110.addTaint(taint);
        return var61F46EA9C65D699D838C78C67875DF31_1722737110;
        // ---------- Original Method ----------
        //return secureRandom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.315 -0400", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "9D156815EAA41B7F506DCC6DC98B292B")
    protected String[] getEnabledCipherSuites() {
        if(enabledCipherSuiteNames == null)        
        {
            CipherSuite[] enabledCipherSuites = getEnabledCipherSuitesMember();
            enabledCipherSuiteNames = new String[enabledCipherSuites.length];
for(int i = 0;i< enabledCipherSuites.length;i++)
            {
                enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
            } //End block
        } //End block
String[] varF3F84C88F370917D7BACDC6E9882C7DE_1282954448 =         enabledCipherSuiteNames.clone();
        varF3F84C88F370917D7BACDC6E9882C7DE_1282954448.addTaint(taint);
        return varF3F84C88F370917D7BACDC6E9882C7DE_1282954448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.316 -0400", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "57D77AF8F771A20B63363AD1186483E6")
    protected void setEnabledCipherSuites(String[] suites) {
        if(suites == null)        
        {
            IllegalArgumentException var807CC84CDC4277C5BED4C8C99CADE6D9_657207004 = new IllegalArgumentException("suites == null");
            var807CC84CDC4277C5BED4C8C99CADE6D9_657207004.addTaint(taint);
            throw var807CC84CDC4277C5BED4C8C99CADE6D9_657207004;
        } //End block
        CipherSuite[] cipherSuites = new CipherSuite[suites.length];
for(int i=0;i<suites.length;i++)
        {
            String suite = suites[i];
            if(suite == null)            
            {
                IllegalArgumentException var858B7BFBFA45D338547759A820F9FB09_1641000862 = new IllegalArgumentException("suites[" + i + "] == null");
                var858B7BFBFA45D338547759A820F9FB09_1641000862.addTaint(taint);
                throw var858B7BFBFA45D338547759A820F9FB09_1641000862;
            } //End block
            cipherSuites[i] = CipherSuite.getByName(suite);
            if(cipherSuites[i] == null || !cipherSuites[i].supported)            
            {
                IllegalArgumentException varA6DDD6B50C3C1A02D7FC8AF815250187_332522410 = new IllegalArgumentException(suite + " is not supported.");
                varA6DDD6B50C3C1A02D7FC8AF815250187_332522410.addTaint(taint);
                throw varA6DDD6B50C3C1A02D7FC8AF815250187_332522410;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.317 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "BFB70864F35E5354D4543C17625FA1B8")
    protected String[] getEnabledProtocols() {
String[] var7F784EE3631AE57BC482259F3F556633_1840911321 =         enabledProtocols.clone();
        var7F784EE3631AE57BC482259F3F556633_1840911321.addTaint(taint);
        return var7F784EE3631AE57BC482259F3F556633_1840911321;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.317 -0400", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "6D433B3A91ED3443A38865B3E2D926EE")
    protected void setEnabledProtocols(String[] protocols) {
        if(protocols == null)        
        {
            IllegalArgumentException var2822E6C7CFBEAB80136C7D0521361E0E_191755025 = new IllegalArgumentException("protocols == null");
            var2822E6C7CFBEAB80136C7D0521361E0E_191755025.addTaint(taint);
            throw var2822E6C7CFBEAB80136C7D0521361E0E_191755025;
        } //End block
for(int i=0;i<protocols.length;i++)
        {
            String protocol = protocols[i];
            if(protocol == null)            
            {
                IllegalArgumentException varF04D0F97B47B7F5B7599232D02F2FC50_1053813107 = new IllegalArgumentException("protocols[" + i + "] == null");
                varF04D0F97B47B7F5B7599232D02F2FC50_1053813107.addTaint(taint);
                throw varF04D0F97B47B7F5B7599232D02F2FC50_1053813107;
            } //End block
            if(!ProtocolVersion.isSupported(protocol))            
            {
                IllegalArgumentException var197A1530EEB0493EE1C3EF8D1914D69C_244431541 = new IllegalArgumentException("Protocol " + protocol + " is not supported.");
                var197A1530EEB0493EE1C3EF8D1914D69C_244431541.addTaint(taint);
                throw var197A1530EEB0493EE1C3EF8D1914D69C_244431541;
            } //End block
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.318 -0400", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "887DE4735EDEE4C8E4C83849AF3EB99A")
    protected void setUseClientMode(boolean mode) {
        client_mode = mode;
        // ---------- Original Method ----------
        //client_mode = mode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.318 -0400", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "C95DC409D5B3DFF6A50B111EC38BA876")
    protected boolean getUseClientMode() {
        boolean var81E447258804BADEDC394F9945D6641A_155681695 = (client_mode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_184874145 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_184874145;
        // ---------- Original Method ----------
        //return client_mode;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.318 -0400", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "52A5FCBC97E504C4D517CB08073F3187")
    protected void setNeedClientAuth(boolean need) {
        need_client_auth = need;
        want_client_auth = false;
        // ---------- Original Method ----------
        //need_client_auth = need;
        //want_client_auth = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.319 -0400", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "513EA84A173449DF4E3A03986CF92A0F")
    protected boolean getNeedClientAuth() {
        boolean var5F0E053B848765DC1E643EA106B30957_1865277033 = (need_client_auth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1534053670 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1534053670;
        // ---------- Original Method ----------
        //return need_client_auth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.319 -0400", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "720F660EEC765CE9DA60BECAD1888659")
    protected void setWantClientAuth(boolean want) {
        want_client_auth = want;
        need_client_auth = false;
        // ---------- Original Method ----------
        //want_client_auth = want;
        //need_client_auth = false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.319 -0400", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "EBDE7E940B4A3765D6B224B71D168C53")
    protected boolean getWantClientAuth() {
        boolean var50809B1BF60864131797768ED7DF2BCB_1363214843 = (want_client_auth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2079908206 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2079908206;
        // ---------- Original Method ----------
        //return want_client_auth;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.320 -0400", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "28552D8F807A40A67118E4FFED07DB76")
    protected void setEnableSessionCreation(boolean flag) {
        enable_session_creation = flag;
        // ---------- Original Method ----------
        //enable_session_creation = flag;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.320 -0400", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "9AF201EF102868E226A6EA6875926BAB")
    protected boolean getEnableSessionCreation() {
        boolean varDA1F4A09E5BAA4AF184991F774AB6DE4_88218773 = (enable_session_creation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_154755464 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_154755464;
        // ---------- Original Method ----------
        //return enable_session_creation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.320 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "824184689828B4A591C02DE0DD5B1A12")
    @Override
    protected Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_2043267237 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_2043267237.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_2043267237;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1897440284 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1897440284.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1897440284;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    private static X509TrustManager findX509TrustManager(TrustManager[] tms) {
        for (TrustManager tm : tms) {
            if (tm instanceof X509TrustManager) {
                return (X509TrustManager)tm;
            }
        }
        return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.322 -0400", hash_original_field = "263BBC6767A6C30BC5791BB210D09DF6", hash_generated_field = "2247CCCD3A9C64F5AC74EB2D7BBE823D")

    private static volatile X509KeyManager defaultKeyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.322 -0400", hash_original_field = "AFB552263B64C1DDF9B755A487D86AA1", hash_generated_field = "D8E61E16921257FD780C18C1DD48E30F")

    private static volatile X509TrustManager defaultTrustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.322 -0400", hash_original_field = "A6B2A5244F9D096900425922319189A3", hash_generated_field = "EE9A8654B1BF8C4636FFC69BB2ED4F02")

    private static volatile SecureRandom defaultSecureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.322 -0400", hash_original_field = "13C31DFDDE13D82609E8368C21A7AE91", hash_generated_field = "4E48D99E9C1BEE305569803DC06C2E6D")

    private static volatile SSLParametersImpl defaultParameters;
}

