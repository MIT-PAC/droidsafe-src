package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.139 -0500", hash_original_method = "004CFD6937DD69D079A03D412E117735", hash_generated_method = "0CFEAC380A184FD68AEDCE8F560ADD02")
    
protected static SSLParametersImpl getDefault() throws KeyManagementException {
        SSLParametersImpl result = defaultParameters;
        if (result == null) {
            // single-check idiom
            defaultParameters = result = new SSLParametersImpl(null,
                                                               null,
                                                               null,
                                                               new ClientSessionContext(),
                                                               new ServerSessionContext());
        }
        return (SSLParametersImpl) result.clone();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.186 -0500", hash_original_method = "574233A58C89B66EABCD6146F3414560", hash_generated_method = "B3D2C268A30ECAABD5BE40F3FDCDA66A")
    
private static X509KeyManager getDefaultKeyManager() {
        X509KeyManager result = defaultKeyManager;
        if (result == null) {
            // single-check idiom
            defaultKeyManager = result = createDefaultKeyManager();
        }
        return result;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.189 -0500", hash_original_method = "13213BA8EE4DE50C7C892474BADB9D4F", hash_generated_method = "B9B90604A9D81E165AF797EA4AD512AD")
    
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
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.191 -0500", hash_original_method = "9ED10DF52B252A199408CA1F6F270418", hash_generated_method = "1D1362D88C00C884786EA558735B16AD")
    
private static X509KeyManager findX509KeyManager(KeyManager[] kms) {
        for (KeyManager km : kms) {
            if (km instanceof X509KeyManager) {
                return (X509KeyManager)km;
            }
        }
        return null;
    }

    /**
     * Gets the default trust manager.
     *
     * TODO: Move this to a published API under dalvik.system.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.194 -0500", hash_original_method = "A83D18BF15DA4AB9B98DC7D822883D44", hash_generated_method = "D78C35A2A0644AD108F95F54A59E8836")
    
public static X509TrustManager getDefaultTrustManager() {
        X509TrustManager result = defaultTrustManager;
        if (result == null) {
            // single-check idiom
            defaultTrustManager = result = createDefaultTrustManager();
        }
        return result;
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.196 -0500", hash_original_method = "5432827BFD9253E13EAA8058A8BA3DE5", hash_generated_method = "EDB0DAE01EA27A68BB1732B91AB2FCBB")
    
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
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.199 -0500", hash_original_method = "8DFF763FD3F8BB26A048698E510F2183", hash_generated_method = "2EA4E31C91A2B2C25C26E52769B9772C")
    
private static X509TrustManager findX509TrustManager(TrustManager[] tms) {
        for (TrustManager tm : tms) {
            if (tm instanceof X509TrustManager) {
                return (X509TrustManager)tm;
            }
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.094 -0500", hash_original_field = "DB6E5ECB044D7DB343F840F983D30E3A", hash_generated_field = "2247CCCD3A9C64F5AC74EB2D7BBE823D")

    private static volatile X509KeyManager defaultKeyManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.097 -0500", hash_original_field = "49FB4A9B221CA15AF90477AD3EAC9018", hash_generated_field = "D8E61E16921257FD780C18C1DD48E30F")

    private static volatile X509TrustManager defaultTrustManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.099 -0500", hash_original_field = "ABC026EDBC879C8325F2755183B95FEE", hash_generated_field = "EE9A8654B1BF8C4636FFC69BB2ED4F02")

    private static volatile SecureRandom defaultSecureRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.102 -0500", hash_original_field = "8AB0071823AA2F830DEE1B435BD9DB09", hash_generated_field = "4E48D99E9C1BEE305569803DC06C2E6D")

    private static volatile SSLParametersImpl defaultParameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.105 -0500", hash_original_field = "8E8521E081F3C427EBF3E28A6604360E", hash_generated_field = "47ED5A692E30079D73F323303E26DB41")

    // client-side SSL sessions
    private  ClientSessionContext clientSessionContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.108 -0500", hash_original_field = "0A4FD2C76E9BCAC96781A2CAB12D37FF", hash_generated_field = "CAB4FD3EC031EDB594014E985A4BEF4D")

    // server-side SSL sessions
    private  ServerSessionContext serverSessionContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.110 -0500", hash_original_field = "5AD2725EB617D74F0228FE188B7C7311", hash_generated_field = "2E4F2E1D2FA6BF13888F77364F60E097")

    private X509KeyManager keyManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.112 -0500", hash_original_field = "E99735A216970A2EA144F04BB2D7A35B", hash_generated_field = "E649160E3435877F729D449D50C5DE3D")

    private X509TrustManager trustManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.114 -0500", hash_original_field = "34751ECE59C87D5C11B7F66A26E0E74E", hash_generated_field = "C638DD7688AC4130134CFC7C318E4412")

    private SecureRandom secureRandom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.116 -0500", hash_original_field = "BAF13951CB5BD6C0A08C07805280203C", hash_generated_field = "B2BC3BDD2580C2157EC8D2FC1FA485E7")

    private CipherSuite[] enabledCipherSuites;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.119 -0500", hash_original_field = "24B34ECFFEBCE113A4004F8A726ECC02", hash_generated_field = "11B1E6E8AC3FE562986A7A98A8FD87BA")

    private String[] enabledCipherSuiteNames = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.121 -0500", hash_original_field = "666762AB68DDD073C80A35914E7854E9", hash_generated_field = "C765220B91F8DE65CC416D29CE9EDA38")

    private String[] enabledProtocols = ProtocolVersion.supportedProtocols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.123 -0500", hash_original_field = "45B93F4223A1C45D0140F6D4A1B115F3", hash_generated_field = "70621FE8C45C8B2EFCD3777571ACB2D2")

    private boolean client_mode = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.125 -0500", hash_original_field = "ADFD7033A4199AF803BFEB37D3600176", hash_generated_field = "64B13B8CA853720DE9965C8FA56B90B2")

    private boolean need_client_auth = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.128 -0500", hash_original_field = "C9F5074D01D8DF38CC6FDF164DB51EBA", hash_generated_field = "C39494A6736ADE40C8F76790B0C56C0E")

    private boolean want_client_auth = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.130 -0500", hash_original_field = "64898074A8A10F148FBB52AD89ACCB42", hash_generated_field = "785E0391576E98C2512A899B702A5327")

    private boolean enable_session_creation = true;

    /**
     * Initializes the parameters. Naturally this constructor is used
     * in SSLContextImpl.engineInit method which directly passes its
     * parameters. In other words this constructor holds all
     * the functionality provided by SSLContext.init method.
     * See {@link javax.net.ssl.SSLContext#init(KeyManager[],TrustManager[],
     * SecureRandom)} for more information
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.136 -0500", hash_original_method = "434B8A48338D9D15BE95F1FE66033FC3", hash_generated_method = "669251056F3FDC01CF86689A8D3CAEAF")
    
protected SSLParametersImpl(KeyManager[] kms, TrustManager[] tms,
            SecureRandom sr, ClientSessionContext clientSessionContext,
            ServerSessionContext serverSessionContext)
            throws KeyManagementException {
        this.serverSessionContext = serverSessionContext;
        this.clientSessionContext = clientSessionContext;

        // It's not described by the spec of SSLContext what should happen
        // if the arrays of length 0 are specified. This implementation
        // behave as for null arrays (i.e. use installed security providers)

        // initialize keyManager
        if ((kms == null) || (kms.length == 0)) {
            keyManager = getDefaultKeyManager();
        } else {
            keyManager = findX509KeyManager(kms);
        }
        if (keyManager == null) {
            throw new KeyManagementException("No X509KeyManager found");
        }

        // initialize trustManager
        if ((tms == null) || (tms.length == 0)) {
            trustManager = getDefaultTrustManager();
        } else {
            trustManager = findX509TrustManager(tms);
        }
        if (trustManager == null) {
            throw new KeyManagementException("No X509TrustManager found");
        }
        // initialize secure random
        // BEGIN android-removed
        // if (sr == null) {
        //     if (defaultSecureRandom == null) {
        //         defaultSecureRandom = new SecureRandom();
        //     }
        //     secureRandom = defaultSecureRandom;
        // } else {
        //     secureRandom = sr;
        // }
        // END android-removed
        // BEGIN android-added
        // We simply use the SecureRandom passed in by the caller. If it's
        // null, we don't replace it by a new instance. The native code below
        // then directly accesses /dev/urandom. Not the most elegant solution,
        // but faster than going through the SecureRandom object.
        secureRandom = sr;
        // END android-added
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.133 -0500", hash_original_method = "F41241796D4BD57A765BA19A5F557DE2", hash_generated_method = "557C62DBF5377A4EFD9CD6E90358F193")
    
protected CipherSuite[] getEnabledCipherSuitesMember() {
        if (enabledCipherSuites == null) {
            this.enabledCipherSuites = CipherSuite.DEFAULT_CIPHER_SUITES;
        }
        return enabledCipherSuites;
    }

    /**
     * @return server session context
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.141 -0500", hash_original_method = "658F9BFC8B9B3779298360EB3ED283E0", hash_generated_method = "D8D83B69782AACFB427F0100E273F491")
    
protected ServerSessionContext getServerSessionContext() {
        return serverSessionContext;
    }

    /**
     * @return client session context
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.144 -0500", hash_original_method = "F2ACF841A45F78E0C0C46B366B8BBEF0", hash_generated_method = "87D038D420D89D8B04423A4E4D1B2062")
    
protected ClientSessionContext getClientSessionContext() {
        return clientSessionContext;
    }

    /**
     * @return key manager
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.146 -0500", hash_original_method = "55EECB48B318CBDDE6A76E7D2964C45E", hash_generated_method = "A7A484D22ACFDE787395902510E0CD80")
    
protected X509KeyManager getKeyManager() {
        return keyManager;
    }

    /**
     * @return trust manager
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.148 -0500", hash_original_method = "6C6A481BDDE46D9B11307A3C2E7627FB", hash_generated_method = "F8C13A194F51E541C6BCDEEF75D511EB")
    
protected X509TrustManager getTrustManager() {
        return trustManager;
    }

    /**
     * @return secure random
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.150 -0500", hash_original_method = "067B45F1A56F6A0D2A18E621BA5CC8CE", hash_generated_method = "6EC567827A79B62A5BD135BCC4893E2C")
    
protected SecureRandom getSecureRandom() {
        if (secureRandom != null) {
            return secureRandom;
        }
        SecureRandom result = defaultSecureRandom;
        if (result == null) {
            // single-check idiom
            defaultSecureRandom = result = new SecureRandom();
        }
        secureRandom = result;
        return secureRandom;
    }

    /**
     * @return the secure random member reference, even it is null
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.153 -0500", hash_original_method = "3F930A54995EF963563BF853943EBA6D", hash_generated_method = "A0E0AC72733B99663BE1814F4C3E8A50")
    
protected SecureRandom getSecureRandomMember() {
        return secureRandom;
    }

    /**
     * @return the names of enabled cipher suites
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.155 -0500", hash_original_method = "9646311778F84C20B1374BE7EFA44ADB", hash_generated_method = "8F2623AD47F1F52B1248959CED4C17A1")
    
protected String[] getEnabledCipherSuites() {
        if (enabledCipherSuiteNames == null) {
            CipherSuite[] enabledCipherSuites = getEnabledCipherSuitesMember();
            enabledCipherSuiteNames = new String[enabledCipherSuites.length];
            for (int i = 0; i< enabledCipherSuites.length; i++) {
                enabledCipherSuiteNames[i] = enabledCipherSuites[i].getName();
            }
        }
        return enabledCipherSuiteNames.clone();
    }

    /**
     * Sets the set of available cipher suites for use in SSL connection.
     * @param   suites: String[]
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.158 -0500", hash_original_method = "C91A557B3D523F3F985021D6CA71D94C", hash_generated_method = "8954BCAFFC3C2E29B5A52A52BF89BE1F")
    
protected void setEnabledCipherSuites(String[] suites) {
        if (suites == null) {
            throw new IllegalArgumentException("suites == null");
        }
        CipherSuite[] cipherSuites = new CipherSuite[suites.length];
        for (int i=0; i<suites.length; i++) {
            String suite = suites[i];
            if (suite == null) {
                throw new IllegalArgumentException("suites[" + i + "] == null");
            }
            cipherSuites[i] = CipherSuite.getByName(suite);
            if (cipherSuites[i] == null || !cipherSuites[i].supported) {
                throw new IllegalArgumentException(suite + " is not supported.");
            }
        }
        enabledCipherSuites = cipherSuites;
        enabledCipherSuiteNames = suites;
    }

    /**
     * @return the set of enabled protocols
     */
    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.160 -0500", hash_original_method = "26510D7872AB5791B4C2075CD3368FCD", hash_generated_method = "28C53F80C7DE79981766D9A8412DBB5F")
    
protected String[] getEnabledProtocols() {
        return enabledProtocols.clone();
    }

    /**
     * Sets the set of available protocols for use in SSL connection.
     * @param protocols String[]
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.163 -0500", hash_original_method = "2B0D33614474781D29E26E9E317355EA", hash_generated_method = "25D3E1C0CB86924B3E58057C887C7A3B")
    
protected void setEnabledProtocols(String[] protocols) {
        if (protocols == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        for (int i=0; i<protocols.length; i++) {
            String protocol = protocols[i];
            if (protocol == null) {
                throw new IllegalArgumentException("protocols[" + i + "] == null");
            }
            if (!ProtocolVersion.isSupported(protocol)) {
                throw new IllegalArgumentException("Protocol " + protocol + " is not supported.");
            }
        }
        enabledProtocols = protocols;
    }

    /**
     * Tunes the peer holding this parameters to work in client mode.
     * @param   mode if the peer is configured to work in client mode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.165 -0500", hash_original_method = "D4C2A3C88DBFC7AAADB7163E376EACA1", hash_generated_method = "9C479141A097FC2B1BBF57597AD312CF")
    
protected void setUseClientMode(boolean mode) {
        client_mode = mode;
    }

    /**
     * Returns the value indicating if the parameters configured to work
     * in client mode.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.168 -0500", hash_original_method = "90A3F3D7EBB1ED0C929CAB981D05518C", hash_generated_method = "F92BCE1154BA7C0517D67C5A6199989F")
    
protected boolean getUseClientMode() {
        return client_mode;
    }

    /**
     * Tunes the peer holding this parameters to require client authentication
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.170 -0500", hash_original_method = "2F62AC894AF3F12D83050C91D4850055", hash_generated_method = "09DCC7E1C6B64BB2582BC17F14242D87")
    
protected void setNeedClientAuth(boolean need) {
        need_client_auth = need;
        // reset the want_client_auth setting
        want_client_auth = false;
    }

    /**
     * Returns the value indicating if the peer with this parameters tuned
     * to require client authentication
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.172 -0500", hash_original_method = "2471CA6C7557FB2D62663705E2DBC565", hash_generated_method = "F8BCB80ACEB307CDA2CA691533D4DC86")
    
protected boolean getNeedClientAuth() {
        return need_client_auth;
    }

    /**
     * Tunes the peer holding this parameters to request client authentication
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.174 -0500", hash_original_method = "AF76AB0175AB43F1BF7C9A05C2972923", hash_generated_method = "A346DA7638C342212B0DFF83C22778CB")
    
protected void setWantClientAuth(boolean want) {
        want_client_auth = want;
        // reset the need_client_auth setting
        need_client_auth = false;
    }

    /**
     * Returns the value indicating if the peer with this parameters
     * tuned to request client authentication
     * @return
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.176 -0500", hash_original_method = "180B768884625BF4E09AC4E909474C3B", hash_generated_method = "2CB78DCE22E22F454F1BA7582F4C6FE1")
    
protected boolean getWantClientAuth() {
        return want_client_auth;
    }

    /**
     * Allows/disallows the peer holding this parameters to
     * create new SSL session
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.179 -0500", hash_original_method = "982E0D6CA0433DE88B1B4310D3610067", hash_generated_method = "F25FB886641EE2F5D6895BA792E1D8E1")
    
protected void setEnableSessionCreation(boolean flag) {
        enable_session_creation = flag;
    }

    /**
     * Returns the value indicating if the peer with this parameters
     * allowed to cteate new SSL session
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.181 -0500", hash_original_method = "73058AE9A102A5DCB03ABA90C3F4D3DE", hash_generated_method = "61E79086593D4F6A3CB1A4061344C97C")
    
protected boolean getEnableSessionCreation() {
        return enable_session_creation;
    }

    /**
     * Returns the clone of this object.
     * @return the clone.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:14.184 -0500", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "EBBEEB29C41D0AA39444F5EA24292722")
    
@Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

