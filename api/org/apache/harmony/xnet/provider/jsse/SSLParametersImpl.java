package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "FEEE4479298DE16A0EB1A633D957D109", hash_generated_field = "2E4F2E1D2FA6BF13888F77364F60E097")

    private X509KeyManager keyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "1FB3B48DC5704D7EC12F3F1A1D0B81BF", hash_generated_field = "E649160E3435877F729D449D50C5DE3D")

    private X509TrustManager trustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "C638DD7688AC4130134CFC7C318E4412")

    private SecureRandom secureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.445 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "B2BC3BDD2580C2157EC8D2FC1FA485E7")

    private CipherSuite[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "4A8CBEF3414DD8C3B53B3E3B266D848D", hash_generated_field = "11B1E6E8AC3FE562986A7A98A8FD87BA")

    private String[] enabledCipherSuiteNames = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "4F9BA8ECD9F1AEA9766E9176AF5EC4E2", hash_generated_field = "C765220B91F8DE65CC416D29CE9EDA38")

    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "D944610A48E928E3C58952AC7D9B5574", hash_generated_field = "70621FE8C45C8B2EFCD3777571ACB2D2")

    private boolean client_mode = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "1C6B39EBC78C0DFBA4B33AF393E1EDC9", hash_generated_field = "64B13B8CA853720DE9965C8FA56B90B2")

    private boolean need_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "CFDE7026DAC64F33A41642BF69543E29", hash_generated_field = "C39494A6736ADE40C8F76790B0C56C0E")

    private boolean want_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.446 -0400", hash_original_field = "D93C2AC5DC8ED50B941C3E646827F942", hash_generated_field = "785E0391576E98C2512A899B702A5327")

    private boolean enable_session_creation = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.447 -0400", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "0439CD7F25069500F63DC97414FA2238")
    protected  SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
    if((kms == null) || (kms.length == 0))        
        {
            keyManager = getDefaultKeyManager();
        } 
        else
        {
            keyManager = findX509KeyManager(kms);
        } 
    if(keyManager == null)        
        {
            KeyManagementException varB4B4897F7D1096437D542031D15D197C_1467194387 = new KeyManagementException("No X509KeyManager found");
            varB4B4897F7D1096437D542031D15D197C_1467194387.addTaint(taint);
            throw varB4B4897F7D1096437D542031D15D197C_1467194387;
        } 
    if((tms == null) || (tms.length == 0))        
        {
            trustManager = getDefaultTrustManager();
        } 
        else
        {
            trustManager = findX509TrustManager(tms);
        } 
    if(trustManager == null)        
        {
            KeyManagementException varA449CBA60048DE5D62BF8B7E29C90C7A_21087978 = new KeyManagementException("No X509TrustManager found");
            varA449CBA60048DE5D62BF8B7E29C90C7A_21087978.addTaint(taint);
            throw varA449CBA60048DE5D62BF8B7E29C90C7A_21087978;
        } 
        secureRandom = sr;
        
        
        
        
            
        
            
        
        
            
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.448 -0400", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "9C1850C76ABA5B9108E7EEE63E045CEE")
    protected CipherSuite[] getEnabledCipherSuitesMember() {
    if(enabledCipherSuites == null)        
        {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        } 
CipherSuite[] var4FE9A25924581DEE872791EA4874412D_735839407 =         enabledCipherSuites;
        var4FE9A25924581DEE872791EA4874412D_735839407.addTaint(taint);
        return var4FE9A25924581DEE872791EA4874412D_735839407;
        
        
            
        
        
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.448 -0400", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "8BB6337DE4072076CF7A5E8A61234307")
    protected ServerSessionContext getServerSessionContext() {
ServerSessionContext var100440D65E59DFFC2F85188BB92C5DF8_1298691268 =         serverSessionContext;
        var100440D65E59DFFC2F85188BB92C5DF8_1298691268.addTaint(taint);
        return var100440D65E59DFFC2F85188BB92C5DF8_1298691268;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.449 -0400", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "CC45356794EF01747168AA88063AE63D")
    protected ClientSessionContext getClientSessionContext() {
ClientSessionContext varF881C293692092C9564353C09AD998B5_1310822193 =         clientSessionContext;
        varF881C293692092C9564353C09AD998B5_1310822193.addTaint(taint);
        return varF881C293692092C9564353C09AD998B5_1310822193;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.449 -0400", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "76E978F4AAEFA968BB1F850B93C75A21")
    protected X509KeyManager getKeyManager() {
X509KeyManager varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1860059375 =         keyManager;
        varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1860059375.addTaint(taint);
        return varB2F1F4ADA8F75A61CE21B0CA3AA12DC4_1860059375;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.449 -0400", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "F9CDED4DDE051F2BDCAF4A19F3619780")
    protected X509TrustManager getTrustManager() {
X509TrustManager var56C611970C82E9A90BA55937E8F17214_1013280382 =         trustManager;
        var56C611970C82E9A90BA55937E8F17214_1013280382.addTaint(taint);
        return var56C611970C82E9A90BA55937E8F17214_1013280382;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.450 -0400", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "240A48FE2BAAB5FD6130C38B38F576AF")
    protected SecureRandom getSecureRandom() {
    if(secureRandom != null)        
        {
SecureRandom var61F46EA9C65D699D838C78C67875DF31_1103775485 =             secureRandom;
            var61F46EA9C65D699D838C78C67875DF31_1103775485.addTaint(taint);
            return var61F46EA9C65D699D838C78C67875DF31_1103775485;
        } 
        SecureRandom result = defaultSecureRandom;
    if(result == null)        
        {
            defaultSecureRandom = result = new SecureRandom();
        } 
        secureRandom = result;
SecureRandom var61F46EA9C65D699D838C78C67875DF31_1453313361 =         secureRandom;
        var61F46EA9C65D699D838C78C67875DF31_1453313361.addTaint(taint);
        return var61F46EA9C65D699D838C78C67875DF31_1453313361;
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.450 -0400", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "DA50588A3021FBA80EDDE15AE9B87B6B")
    protected SecureRandom getSecureRandomMember() {
SecureRandom var61F46EA9C65D699D838C78C67875DF31_630056372 =         secureRandom;
        var61F46EA9C65D699D838C78C67875DF31_630056372.addTaint(taint);
        return var61F46EA9C65D699D838C78C67875DF31_630056372;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.451 -0400", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "41F2AA6E5CA248F2C872AADBE3FF0F54")
    protected String[] getEnabledCipherSuites() {
    if(enabledCipherSuiteNames == null)        
        {
            CipherSuite[] enabledCipherSuites = getEnabledCipherSuitesMember();
            enabledCipherSuiteNames = new String[enabledCipherSuites.length];
for(int i = 0;i< enabledCipherSuites.length;i++)
            {
                enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
            } 
        } 
String[] varF3F84C88F370917D7BACDC6E9882C7DE_1030281656 =         enabledCipherSuiteNames.clone();
        varF3F84C88F370917D7BACDC6E9882C7DE_1030281656.addTaint(taint);
        return varF3F84C88F370917D7BACDC6E9882C7DE_1030281656;
        
        
            
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.452 -0400", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "37058FBB0EFEC6A3B3A671F722F50E22")
    protected void setEnabledCipherSuites(String[] suites) {
    if(suites == null)        
        {
            IllegalArgumentException var807CC84CDC4277C5BED4C8C99CADE6D9_763031725 = new IllegalArgumentException("suites == null");
            var807CC84CDC4277C5BED4C8C99CADE6D9_763031725.addTaint(taint);
            throw var807CC84CDC4277C5BED4C8C99CADE6D9_763031725;
        } 
        CipherSuite[] cipherSuites = new CipherSuite[suites.length];
for(int i=0;i<suites.length;i++)
        {
            String suite = suites[i];
    if(suite == null)            
            {
                IllegalArgumentException var858B7BFBFA45D338547759A820F9FB09_1903545729 = new IllegalArgumentException("suites[" + i + "] == null");
                var858B7BFBFA45D338547759A820F9FB09_1903545729.addTaint(taint);
                throw var858B7BFBFA45D338547759A820F9FB09_1903545729;
            } 
            cipherSuites[i] = CipherSuite.getByName(suite);
    if(cipherSuites[i] == null || !cipherSuites[i].supported)            
            {
                IllegalArgumentException varA6DDD6B50C3C1A02D7FC8AF815250187_1162485280 = new IllegalArgumentException(suite + " is not supported.");
                varA6DDD6B50C3C1A02D7FC8AF815250187_1162485280.addTaint(taint);
                throw varA6DDD6B50C3C1A02D7FC8AF815250187_1162485280;
            } 
        } 
        enabledCipherSuites = cipherSuites;
        enabledCipherSuiteNames = suites;
        
        
            
        
        
        
            
            
                
            
            
            
                
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.452 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "F1C518D37F63CE1BA12F6CC84840C4B2")
    protected String[] getEnabledProtocols() {
String[] var7F784EE3631AE57BC482259F3F556633_217484113 =         enabledProtocols.clone();
        var7F784EE3631AE57BC482259F3F556633_217484113.addTaint(taint);
        return var7F784EE3631AE57BC482259F3F556633_217484113;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.453 -0400", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "58949772B053540993AE12EFD4FB9279")
    protected void setEnabledProtocols(String[] protocols) {
    if(protocols == null)        
        {
            IllegalArgumentException var2822E6C7CFBEAB80136C7D0521361E0E_927324299 = new IllegalArgumentException("protocols == null");
            var2822E6C7CFBEAB80136C7D0521361E0E_927324299.addTaint(taint);
            throw var2822E6C7CFBEAB80136C7D0521361E0E_927324299;
        } 
for(int i=0;i<protocols.length;i++)
        {
            String protocol = protocols[i];
    if(protocol == null)            
            {
                IllegalArgumentException varF04D0F97B47B7F5B7599232D02F2FC50_924227921 = new IllegalArgumentException("protocols[" + i + "] == null");
                varF04D0F97B47B7F5B7599232D02F2FC50_924227921.addTaint(taint);
                throw varF04D0F97B47B7F5B7599232D02F2FC50_924227921;
            } 
    if(!ProtocolVersion.isSupported(protocol))            
            {
                IllegalArgumentException var197A1530EEB0493EE1C3EF8D1914D69C_336192631 = new IllegalArgumentException("Protocol " + protocol + " is not supported.");
                var197A1530EEB0493EE1C3EF8D1914D69C_336192631.addTaint(taint);
                throw var197A1530EEB0493EE1C3EF8D1914D69C_336192631;
            } 
        } 
        enabledProtocols = protocols;
        
        
            
        
        
            
            
                
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.453 -0400", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "887DE4735EDEE4C8E4C83849AF3EB99A")
    protected void setUseClientMode(boolean mode) {
        client_mode = mode;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.454 -0400", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "A9AF8E43DA0FF0DB02C8744B47A89F68")
    protected boolean getUseClientMode() {
        boolean var81E447258804BADEDC394F9945D6641A_15178822 = (client_mode);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1868085253 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1868085253;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.454 -0400", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "52A5FCBC97E504C4D517CB08073F3187")
    protected void setNeedClientAuth(boolean need) {
        need_client_auth = need;
        want_client_auth = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.455 -0400", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "D6393CFFA7195B5571C5A74977E16C91")
    protected boolean getNeedClientAuth() {
        boolean var5F0E053B848765DC1E643EA106B30957_1895381007 = (need_client_auth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571696006 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571696006;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.455 -0400", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "720F660EEC765CE9DA60BECAD1888659")
    protected void setWantClientAuth(boolean want) {
        want_client_auth = want;
        need_client_auth = false;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.455 -0400", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "C4EF4F937BC12B95AF7321EBA329A5EB")
    protected boolean getWantClientAuth() {
        boolean var50809B1BF60864131797768ED7DF2BCB_247117342 = (want_client_auth);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2077558550 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2077558550;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.456 -0400", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "28552D8F807A40A67118E4FFED07DB76")
    protected void setEnableSessionCreation(boolean flag) {
        enable_session_creation = flag;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.456 -0400", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "AB69E64167858BAC3F9847E256D841A5")
    protected boolean getEnableSessionCreation() {
        boolean varDA1F4A09E5BAA4AF184991F774AB6DE4_378939758 = (enable_session_creation);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_927812142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_927812142;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.457 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "98998EFA521EB73D4B8ABC9985DFB5F4")
    @Override
    protected Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1482783171 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1482783171.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1482783171;
        } 
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_892247247 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_892247247.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_892247247;
        } 
        
        
            
        
            
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.459 -0400", hash_original_field = "263BBC6767A6C30BC5791BB210D09DF6", hash_generated_field = "2247CCCD3A9C64F5AC74EB2D7BBE823D")

    private static volatile X509KeyManager defaultKeyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.459 -0400", hash_original_field = "AFB552263B64C1DDF9B755A487D86AA1", hash_generated_field = "D8E61E16921257FD780C18C1DD48E30F")

    private static volatile X509TrustManager defaultTrustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.459 -0400", hash_original_field = "A6B2A5244F9D096900425922319189A3", hash_generated_field = "EE9A8654B1BF8C4636FFC69BB2ED4F02")

    private static volatile SecureRandom defaultSecureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.459 -0400", hash_original_field = "13C31DFDDE13D82609E8368C21A7AE91", hash_generated_field = "4E48D99E9C1BEE305569803DC06C2E6D")

    private static volatile SSLParametersImpl defaultParameters;
}

