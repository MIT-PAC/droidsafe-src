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
    private ClientSessionContext clientSessionContext;
    private ServerSessionContext serverSessionContext;
    private X509KeyManager keyManager;
    private X509TrustManager trustManager;
    private SecureRandom secureRandom;
    private CipherSuite[] enabledCipherSuites;
    private String[] enabledCipherSuiteNames = null;
    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
    private boolean client_mode = true;
    private boolean need_client_auth = false;
    private boolean want_client_auth = false;
    private boolean enable_session_creation = true;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.146 -0400", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "3A061E743F371CBFC36565099451F8F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext) throws KeyManagementException {
        dsTaint.addTaint(kms[0].dsTaint);
        dsTaint.addTaint(clientSessionContext.dsTaint);
        dsTaint.addTaint(tms[0].dsTaint);
        dsTaint.addTaint(sr.dsTaint);
        dsTaint.addTaint(serverSessionContext.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.147 -0400", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "06B0063A3DBEB7DD69860B0533712691")
    @DSModeled(DSC.SAFE)
    protected CipherSuite[] getEnabledCipherSuitesMember() {
        {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        } //End block
        return (CipherSuite[])dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.147 -0400", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "EF820DFFC22DD7FEC0BF56ED687CACE3")
    @DSModeled(DSC.SAFE)
    protected ServerSessionContext getServerSessionContext() {
        return (ServerSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return serverSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.147 -0400", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "C506BE52A981485C6CE00CDAD01E07D3")
    @DSModeled(DSC.SAFE)
    protected ClientSessionContext getClientSessionContext() {
        return (ClientSessionContext)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return clientSessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.147 -0400", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "4C7D3A02645770AA3AFC616473838263")
    @DSModeled(DSC.SAFE)
    protected X509KeyManager getKeyManager() {
        return (X509KeyManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return keyManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.147 -0400", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "3DD86D46F44728A1B8230C9D7658365F")
    @DSModeled(DSC.SAFE)
    protected X509TrustManager getTrustManager() {
        return (X509TrustManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return trustManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.148 -0400", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "CFF21E511CBF51A76110B151C3156937")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected SecureRandom getSecureRandom() {
        SecureRandom result;
        result = defaultSecureRandom;
        {
            defaultSecureRandom = result = new SecureRandom();
        } //End block
        secureRandom = result;
        return (SecureRandom)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.148 -0400", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "9544D45AC23F24D4883758BB02E0A2C6")
    @DSModeled(DSC.SAFE)
    protected SecureRandom getSecureRandomMember() {
        return (SecureRandom)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return secureRandom;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.148 -0400", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "ECA2D33861AEAC0FC23B14C863A7B03D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String[] getEnabledCipherSuites() {
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
        String[] var2067DDCA624C029421DE6FFE57DFA396_1335322388 = (enabledCipherSuiteNames.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.149 -0400", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "7077E29851E5EDFE819B0A4650C61AE0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setEnabledCipherSuites(String[] suites) {
        dsTaint.addTaint(suites[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.149 -0400", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "3382D7AD6FD5F022D8A1164E85841B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String[] getEnabledProtocols() {
        String[] varAD12450170E712D0CFE20B0157A51EDE_938873883 = (enabledProtocols.clone());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return enabledProtocols.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.149 -0400", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "90100987B5057605B3DB772E1EA38659")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void setEnabledProtocols(String[] protocols) {
        dsTaint.addTaint(protocols[0]);
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
                    boolean var62D8EE37F0681C110B52FBB58EB4EBEE_964588177 = (!ProtocolVersion.isSupported(protocol));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Protocol " + protocol + " is not supported.");
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.149 -0400", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "599A68FB8C4B9768BFFED73EE1177401")
    @DSModeled(DSC.SAFE)
    protected void setUseClientMode(boolean mode) {
        dsTaint.addTaint(mode);
        // ---------- Original Method ----------
        //client_mode = mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.150 -0400", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "818BC440F150B16DA68C571DD05C27D8")
    @DSModeled(DSC.SAFE)
    protected boolean getUseClientMode() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return client_mode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.150 -0400", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "21E7EE07667656926DAE5B47AC46825C")
    @DSModeled(DSC.SAFE)
    protected void setNeedClientAuth(boolean need) {
        dsTaint.addTaint(need);
        want_client_auth = false;
        // ---------- Original Method ----------
        //need_client_auth = need;
        //want_client_auth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.150 -0400", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "1A797897450FAEA12837102A0D9DA4A2")
    @DSModeled(DSC.SAFE)
    protected boolean getNeedClientAuth() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return need_client_auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.150 -0400", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "7FA5A53A47C23C197FDDC6AAE09E1660")
    @DSModeled(DSC.SAFE)
    protected void setWantClientAuth(boolean want) {
        dsTaint.addTaint(want);
        need_client_auth = false;
        // ---------- Original Method ----------
        //want_client_auth = want;
        //need_client_auth = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.150 -0400", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "4D02E6DB20374F7558E316EC3DF1CC24")
    @DSModeled(DSC.SAFE)
    protected boolean getWantClientAuth() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return want_client_auth;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.151 -0400", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "AD34EC5B828140312F1818C647FD86FF")
    @DSModeled(DSC.SAFE)
    protected void setEnableSessionCreation(boolean flag) {
        dsTaint.addTaint(flag);
        // ---------- Original Method ----------
        //enable_session_creation = flag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.151 -0400", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "06DD18D3604EB01581A2CDC823443580")
    @DSModeled(DSC.SAFE)
    protected boolean getEnableSessionCreation() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enable_session_creation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:42.151 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "D0006E4C8CF585E34FA3EB86ED72C15B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_255816324 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
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

    
    private static volatile X509KeyManager defaultKeyManager;
    private static volatile X509TrustManager defaultTrustManager;
    private static volatile SecureRandom defaultSecureRandom;
    private static volatile SSLParametersImpl defaultParameters;
}

