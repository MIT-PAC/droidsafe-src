package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "BBF2E072FADE089E3AAF9C311B04B922", hash_generated_field = "18DF1224C27021F1A3724F6E02033981")

    private ClientSessionContext clientSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "CFD3E7982F5FF61303CFF556E2DA3D97", hash_generated_field = "C5EBE7874A86EC861FFFE1CE7FF9026A")

    private ServerSessionContext serverSessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "FEEE4479298DE16A0EB1A633D957D109", hash_generated_field = "2E4F2E1D2FA6BF13888F77364F60E097")

    private X509KeyManager keyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "1FB3B48DC5704D7EC12F3F1A1D0B81BF", hash_generated_field = "E649160E3435877F729D449D50C5DE3D")

    private X509TrustManager trustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "7A369DC18E63D8C3EA510B9B660A072D", hash_generated_field = "C638DD7688AC4130134CFC7C318E4412")

    private SecureRandom secureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "38383F4C014341443E61625DF4882821", hash_generated_field = "B2BC3BDD2580C2157EC8D2FC1FA485E7")

    private CipherSuite[] enabledCipherSuites;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "4A8CBEF3414DD8C3B53B3E3B266D848D", hash_generated_field = "11B1E6E8AC3FE562986A7A98A8FD87BA")

    private String[] enabledCipherSuiteNames = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "4F9BA8ECD9F1AEA9766E9176AF5EC4E2", hash_generated_field = "C765220B91F8DE65CC416D29CE9EDA38")

    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "D944610A48E928E3C58952AC7D9B5574", hash_generated_field = "70621FE8C45C8B2EFCD3777571ACB2D2")

    private boolean client_mode = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "1C6B39EBC78C0DFBA4B33AF393E1EDC9", hash_generated_field = "64B13B8CA853720DE9965C8FA56B90B2")

    private boolean need_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "CFDE7026DAC64F33A41642BF69543E29", hash_generated_field = "C39494A6736ADE40C8F76790B0C56C0E")

    private boolean want_client_auth = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.829 -0400", hash_original_field = "D93C2AC5DC8ED50B941C3E646827F942", hash_generated_field = "785E0391576E98C2512A899B702A5327")

    private boolean enable_session_creation = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.830 -0400", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "13F37D89ADCDAE7F23C05AAA16823EE5")
    protected  SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext) throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;
        {
            keyManager = getDefaultKeyManager();
        } 
        {
            keyManager = findX509KeyManager(kms);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("No X509KeyManager found");
        } 
        {
            trustManager = getDefaultTrustManager();
        } 
        {
            trustManager = findX509TrustManager(tms);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new KeyManagementException("No X509TrustManager found");
        } 
        secureRandom = sr;
        
        
        
        
            
        
            
        
        
            
        
        
            
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.831 -0400", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "5797C318688557145F978EE2BBFC3B4D")
    protected CipherSuite[] getEnabledCipherSuitesMember() {
        CipherSuite[] varB4EAC82CA7396A68D541C85D26508E83_694065468 = null; 
        {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_694065468 = enabledCipherSuites;
        varB4EAC82CA7396A68D541C85D26508E83_694065468.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_694065468;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.832 -0400", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "1887394B9A0531442539F4C903D085CF")
    protected ServerSessionContext getServerSessionContext() {
        ServerSessionContext varB4EAC82CA7396A68D541C85D26508E83_1664927060 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1664927060 = serverSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_1664927060.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1664927060;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.834 -0400", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "76D80CF3EF07D3FB212B7FEAD6502BE9")
    protected ClientSessionContext getClientSessionContext() {
        ClientSessionContext varB4EAC82CA7396A68D541C85D26508E83_1885968628 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1885968628 = clientSessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_1885968628.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1885968628;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.836 -0400", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "5D910A4EC277C569E89820151547505D")
    protected X509KeyManager getKeyManager() {
        X509KeyManager varB4EAC82CA7396A68D541C85D26508E83_1319975757 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1319975757 = keyManager;
        varB4EAC82CA7396A68D541C85D26508E83_1319975757.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1319975757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.837 -0400", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "1C4B663D599C1A1C974B9BC24026CDBC")
    protected X509TrustManager getTrustManager() {
        X509TrustManager varB4EAC82CA7396A68D541C85D26508E83_1766981302 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1766981302 = trustManager;
        varB4EAC82CA7396A68D541C85D26508E83_1766981302.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1766981302;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.838 -0400", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "325875F6302968D80F44FAB9A5925439")
    protected SecureRandom getSecureRandom() {
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_1511902684 = null; 
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_307007696 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1511902684 = secureRandom;
        } 
        SecureRandom result = defaultSecureRandom;
        {
            defaultSecureRandom = result = new SecureRandom();
        } 
        secureRandom = result;
        varB4EAC82CA7396A68D541C85D26508E83_307007696 = secureRandom;
        SecureRandom varA7E53CE21691AB073D9660D615818899_186563939; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_186563939 = varB4EAC82CA7396A68D541C85D26508E83_1511902684;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_186563939 = varB4EAC82CA7396A68D541C85D26508E83_307007696;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_186563939.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_186563939;
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.839 -0400", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "6A68BAA70AF6396F3C547644254BD9A8")
    protected SecureRandom getSecureRandomMember() {
        SecureRandom varB4EAC82CA7396A68D541C85D26508E83_1390457312 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1390457312 = secureRandom;
        varB4EAC82CA7396A68D541C85D26508E83_1390457312.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1390457312;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.840 -0400", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "F1B00D25CC5B9A2FF1D527F5831FFE93")
    protected String[] getEnabledCipherSuites() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_379234878 = null; 
        {
            CipherSuite[] enabledCipherSuites = getEnabledCipherSuitesMember();
            enabledCipherSuiteNames = new String[enabledCipherSuites.length];
            {
                int i = 0;
                {
                    enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_379234878 = enabledCipherSuiteNames.clone();
        varB4EAC82CA7396A68D541C85D26508E83_379234878.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_379234878;
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.840 -0400", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "67386CB914D6DDCC4523EBBAE93FB7A0")
    protected void setEnabledCipherSuites(String[] suites) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("suites == null");
        } 
        CipherSuite[] cipherSuites = new CipherSuite[suites.length];
        {
            int i = 0;
            {
                String suite = suites[i];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("suites[" + i + "] == null");
                } 
                cipherSuites[i] = CipherSuite.getByName(suite);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(suite + " is not supported.");
                } 
            } 
        } 
        enabledCipherSuites = cipherSuites;
        enabledCipherSuiteNames = suites;
        
        
            
        
        
        
            
            
                
            
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.841 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "01427527FFD6066A2B5126DDC6132DC5")
    protected String[] getEnabledProtocols() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_2070697770 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2070697770 = enabledProtocols.clone();
        varB4EAC82CA7396A68D541C85D26508E83_2070697770.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2070697770;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.841 -0400", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "B87D32AE7DC5B4FB1F9306A986DD5886")
    protected void setEnabledProtocols(String[] protocols) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("protocols == null");
        } 
        {
            int i = 0;
            {
                String protocol = protocols[i];
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("protocols[" + i + "] == null");
                } 
                {
                    boolean var62D8EE37F0681C110B52FBB58EB4EBEE_1772443729 = (!ProtocolVersion.isSupported(protocol));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Protocol " + protocol + " is not supported.");
                    } 
                } 
            } 
        } 
        enabledProtocols = protocols;
        
        
            
        
        
            
            
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.841 -0400", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "887DE4735EDEE4C8E4C83849AF3EB99A")
    protected void setUseClientMode(boolean mode) {
        client_mode = mode;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.842 -0400", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "614A1640268C89549DC36B52792531DB")
    protected boolean getUseClientMode() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_148853933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_148853933;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.842 -0400", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "52A5FCBC97E504C4D517CB08073F3187")
    protected void setNeedClientAuth(boolean need) {
        need_client_auth = need;
        want_client_auth = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.842 -0400", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "C86A047250F39B3A524172B9BE4C01CB")
    protected boolean getNeedClientAuth() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_423227370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_423227370;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.843 -0400", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "720F660EEC765CE9DA60BECAD1888659")
    protected void setWantClientAuth(boolean want) {
        want_client_auth = want;
        need_client_auth = false;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.843 -0400", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "59729AC5D079ED6EBADC87A1D90E0A36")
    protected boolean getWantClientAuth() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_368361555 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_368361555;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.843 -0400", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "28552D8F807A40A67118E4FFED07DB76")
    protected void setEnableSessionCreation(boolean flag) {
        enable_session_creation = flag;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.843 -0400", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "44C1D05529DDC47D5D18D901F43196B9")
    protected boolean getEnableSessionCreation() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061602144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061602144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.844 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "6DC51F7B915D63130ABC00396FA18F9C")
    @Override
    protected Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_35487269 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_35487269 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_35487269.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_35487269;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    private static X509KeyManager getDefaultKeyManager() {
        X509KeyManager result = defaultKeyManager;
        if (result == null) {
            defaultKeyManager = result = createDefaultKeyManager();
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static X509TrustManager getDefaultTrustManager() {
        X509TrustManager result = defaultTrustManager;
        if (result == null) {
            defaultTrustManager = result = createDefaultTrustManager();
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.846 -0400", hash_original_field = "263BBC6767A6C30BC5791BB210D09DF6", hash_generated_field = "2247CCCD3A9C64F5AC74EB2D7BBE823D")

    private static volatile X509KeyManager defaultKeyManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.846 -0400", hash_original_field = "AFB552263B64C1DDF9B755A487D86AA1", hash_generated_field = "D8E61E16921257FD780C18C1DD48E30F")

    private static volatile X509TrustManager defaultTrustManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.846 -0400", hash_original_field = "A6B2A5244F9D096900425922319189A3", hash_generated_field = "EE9A8654B1BF8C4636FFC69BB2ED4F02")

    private static volatile SecureRandom defaultSecureRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.846 -0400", hash_original_field = "13C31DFDDE13D82609E8368C21A7AE91", hash_generated_field = "4E48D99E9C1BEE305569803DC06C2E6D")

    private static volatile SSLParametersImpl defaultParameters;
}

