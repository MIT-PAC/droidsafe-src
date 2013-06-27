package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.CertificateException;

public class OpenSSLSessionImpl implements SSLSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.140 -0400", hash_original_field = "5DED728EB700D850EA04B789FE21E2A0", hash_generated_field = "269D1908AAA6996EA79A385B96B8D46B")

    private long creationTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.140 -0400", hash_original_field = "388448CF3FDDB350B7A22E8DFF6A7BC6", hash_generated_field = "CA76B0FD881476C838923B95EAFEFA21")

    long lastAccessedTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.140 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "34EC4E58A52046C4CA9DDEF945200C60")

    private Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "E9BEAE9732AC2010347B9CC56A4B1F6D", hash_generated_field = "CA10727E3B6C4E28BA2DC6C0BB046AB5")

    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "D5A225287EFD2557AC2E83AC46A37BB4", hash_generated_field = "B359FFDC454F9BD60DB6759BAEDB0FBE")

    protected int sslSessionNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

    private String cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "2BB54D2AE49B8469137AD2B40B9E2AD5", hash_generated_field = "60FA26833155E846A9CFC6F83676739D")

    private String compressionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "5B59BBDE6FE889598DF661BDB872EDC1", hash_generated_field = "4CFE5CBF57F2F36BBD15DF349B9E7672")

    private AbstractSessionContext sessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.141 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "8E7258E790097F4AD5ED2D02B17E7B9A")

    private byte[] id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.142 -0400", hash_original_method = "1D97F06EBCB0CC7BB7E5B60E8D275DC2", hash_generated_method = "FE5C2A8EDF8FF5637936D2332932071B")
    protected  OpenSSLSessionImpl(int sslSessionNativePointer, X509Certificate[] localCertificates,
            X509Certificate[] peerCertificates, String peerHost, int peerPort,
            AbstractSessionContext sessionContext) {
        this.sslSessionNativePointer = sslSessionNativePointer;
        this.localCertificates = localCertificates;
        this.peerCertificates = peerCertificates;
        this.peerHost = peerHost;
        this.peerPort = peerPort;
        this.sessionContext = sessionContext;
        // ---------- Original Method ----------
        //this.sslSessionNativePointer = sslSessionNativePointer;
        //this.localCertificates = localCertificates;
        //this.peerCertificates = peerCertificates;
        //this.peerHost = peerHost;
        //this.peerPort = peerPort;
        //this.sessionContext = sessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.150 -0400", hash_original_method = "ECC374A16FFF293E37020E85B391DB03", hash_generated_method = "934AACC5A1C2AF0502440F42869F8D14")
      OpenSSLSessionImpl(byte[] derData,
            String peerHost, int peerPort,
            X509Certificate[] peerCertificates,
            AbstractSessionContext sessionContext) throws IOException {
        this(NativeCrypto.d2i_SSL_SESSION(derData),
             null,
             peerCertificates,
             peerHost,
             peerPort,
             sessionContext);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("Invalid session data");
        } //End block
        addTaint(derData[0]);
        addTaint(peerHost.getTaint());
        addTaint(peerPort);
        addTaint(peerCertificates[0].getTaint());
        addTaint(sessionContext.getTaint());
        // ---------- Original Method ----------
        //if (this.sslSessionNativePointer == 0) {
            //throw new IOException("Invalid session data");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.151 -0400", hash_original_method = "566A3E7ED91C5CA2BC21AC127756388D", hash_generated_method = "39020A3425D6087F0EC1B489B1EE016E")
    public byte[] getId() {
        {
            resetId();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_557337833 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_557337833;
        // ---------- Original Method ----------
        //if (id == null) {
            //resetId();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.151 -0400", hash_original_method = "57B02BE93AE841112E3F3B64D0EF8580", hash_generated_method = "3A40234A24A17A498837F8630547C44C")
     void resetId() {
        id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
        // ---------- Original Method ----------
        //id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.152 -0400", hash_original_method = "6E61934F3054764656AF5E19BA5296B9", hash_generated_method = "CE9CE18191E5C43A8E923189851023E6")
     byte[] getEncoded() {
        byte[] var1B32E27C6AA38E481DE7B683DE0C78A0_435517410 = (NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer));
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1788575726 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1788575726;
        // ---------- Original Method ----------
        //return NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.152 -0400", hash_original_method = "A19FB54083053630467ACC70727A9F00", hash_generated_method = "6F648D6E8551A5F279A3E41054EEF401")
    public long getCreationTime() {
        {
            creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_593126930 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_593126930;
        // ---------- Original Method ----------
        //if (creationTime == 0) {
            //creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        //}
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.152 -0400", hash_original_method = "D25DBFE273F16B7B3F4524AEB4575158", hash_generated_method = "FE0C7CE50ED4CD1D9AEDB62334E65CC9")
    public long getLastAccessedTime() {
        {
            Object var1E00950F601E34E55AF1F5E53EA61CA5_2091981629 = (getCreationTime());
        } //End flattened ternary
        long var0F5264038205EDFB1AC05FBB0E8C5E94_660630277 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_660630277;
        // ---------- Original Method ----------
        //return (lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.153 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "FF133ACF4AEC4B3EBE030AFB091B87FC")
    public int getApplicationBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767924296 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_767924296;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.153 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "ADF81D1B26FEFEAC812A7E051CFA805B")
    public int getPacketBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955578736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1955578736;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.155 -0400", hash_original_method = "FC218F5482EE1068025787BA631F1A11", hash_generated_method = "F69D72D2402ADFD606D746A6FF414585")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_2064689599 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_1182208214 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2064689599 = localCertificates[0].getSubjectX500Principal();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1182208214 = null;
        } //End block
        Principal varA7E53CE21691AB073D9660D615818899_1582945928; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1582945928 = varB4EAC82CA7396A68D541C85D26508E83_2064689599;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1582945928 = varB4EAC82CA7396A68D541C85D26508E83_1182208214;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1582945928.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1582945928;
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //} else {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.166 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "6CF5FE5BA341A334A1D14394F8CB8F5B")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1453672309 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1453672309 = localCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_1453672309.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1453672309;
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.167 -0400", hash_original_method = "74B59F5E567633033E420B2FD20F7EA9", hash_generated_method = "D30F7FDAA40168DF96DD39D48E157D6E")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        javax.security.cert.X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1113346406 = null; //Variable for return #1
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] result;
        result = peerCertificateChain;
        {
            peerCertificateChain = result = createPeerCertificateChain();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1113346406 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1113346406.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1113346406;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //javax.security.cert.X509Certificate[] result = peerCertificateChain;
        //if (result == null) {
            //peerCertificateChain = result = createPeerCertificateChain();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.176 -0400", hash_original_method = "95455CDE829A27B48DAF238C4403FA5A", hash_generated_method = "AF61E7738D96DC0E49EA4266FA7BB974")
    private javax.security.cert.X509Certificate[] createPeerCertificateChain() throws SSLPeerUnverifiedException {
        javax.security.cert.X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1711377965 = null; //Variable for return #1
        try 
        {
            javax.security.cert.X509Certificate[] chain;
            chain = new javax.security.cert.X509Certificate[peerCertificates.length];
            {
                int i;
                i = 0;
                {
                    byte[] encoded;
                    encoded = peerCertificates[i].getEncoded();
                    chain[i] = javax.security.cert.X509Certificate.getInstance(encoded);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1711377965 = chain;
        } //End block
        catch (CertificateEncodingException e)
        {
            SSLPeerUnverifiedException exception;
            exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            if (DroidSafeAndroidRuntime.control) throw exception;
        } //End block
        catch (CertificateException e)
        {
            SSLPeerUnverifiedException exception;
            exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            if (DroidSafeAndroidRuntime.control) throw exception;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1711377965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1711377965;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.178 -0400", hash_original_method = "6F2F2196C2B5F66BDE334D0180ADBF68", hash_generated_method = "27689884E73E5AC880D2D851CCDFE4AE")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_350074713 = null; //Variable for return #1
        checkPeerCertificatesPresent();
        varB4EAC82CA7396A68D541C85D26508E83_350074713 = peerCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_350074713.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_350074713;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.187 -0400", hash_original_method = "4A7519F376EC7B19E89A23705C5BAAD6", hash_generated_method = "0ECA2302D909DF168B9F353DDB7E1C7C")
    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificates");
        } //End block
        // ---------- Original Method ----------
        //if (peerCertificates == null || peerCertificates.length == 0) {
            //throw new SSLPeerUnverifiedException("No peer certificates");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.188 -0400", hash_original_method = "14CCB3DBB8312C280BE97228D3117477", hash_generated_method = "D33EBF7D023EC0F327B93296F8933C44")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_2079384359 = null; //Variable for return #1
        checkPeerCertificatesPresent();
        varB4EAC82CA7396A68D541C85D26508E83_2079384359 = peerCertificates[0].getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_2079384359.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2079384359;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.188 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "BB9FCD12A1BFBE91F6DA36818E445870")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_485879720 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_485879720 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_485879720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_485879720;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.188 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "163BD300F5BC0C41FBCDA05912D6B4EE")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025317080 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1025317080;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.189 -0400", hash_original_method = "232543257EF0615A8C98189B2944DDF8", hash_generated_method = "AB106DC4D99C20F147E8DC93AE4408C9")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_785015159 = null; //Variable for return #1
        {
            String name;
            name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
            {
                cipherSuite = name;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_785015159 = cipherSuite;
        varB4EAC82CA7396A68D541C85D26508E83_785015159.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_785015159;
        // ---------- Original Method ----------
        //if (cipherSuite == null) {
            //String name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            //cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
            //if (cipherSuite == null) {
                //cipherSuite = name;
            //}
        //}
        //return cipherSuite;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.189 -0400", hash_original_method = "DC690D466354C337179157E9ED46DB27", hash_generated_method = "87FCFEB3FFA4B6D1F6718324F5B69BA4")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1675985322 = null; //Variable for return #1
        {
            protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1675985322 = protocol;
        varB4EAC82CA7396A68D541C85D26508E83_1675985322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1675985322;
        // ---------- Original Method ----------
        //if (protocol == null) {
            //protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        //}
        //return protocol;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.198 -0400", hash_original_method = "968671DF82E2AA12BC31F552097867FE", hash_generated_method = "042C02303C50FFA0EB83999B0A1032C7")
    public String getCompressionMethod() {
        String varB4EAC82CA7396A68D541C85D26508E83_889368053 = null; //Variable for return #1
        {
            compressionMethod
                    = NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             sslSessionNativePointer);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_889368053 = compressionMethod;
        varB4EAC82CA7396A68D541C85D26508E83_889368053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_889368053;
        // ---------- Original Method ----------
        //if (compressionMethod == null) {
            //compressionMethod
                    //= NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             //sslSessionNativePointer);
        //}
        //return compressionMethod;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.199 -0400", hash_original_method = "6C1FB28F6F59303D04A80E546963567A", hash_generated_method = "C8FEB020F8B80021C4C3C578413E7920")
    public SSLSessionContext getSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_1703835371 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1703835371 = sessionContext;
        varB4EAC82CA7396A68D541C85D26508E83_1703835371.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1703835371;
        // ---------- Original Method ----------
        //return sessionContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.200 -0400", hash_original_method = "8D23F85B43098BFBC0CC2E7E59C1A10A", hash_generated_method = "CE23E991BEF0C455F2DD726F18AE69A9")
    public boolean isValid() {
        SSLSessionContext context;
        context = sessionContext;
        {
            boolean var014183AFC31920D3752F2F3A5699E2A8_955851280 = (isValid
                && context != null
                && context.getSessionTimeout() != 0
                && getCreationTime() + (context.getSessionTimeout() * 1000)
                    < System.currentTimeMillis());
            {
                isValid = false;
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_418283072 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_418283072;
        // ---------- Original Method ----------
        //SSLSessionContext context = sessionContext;
        //if (isValid
                //&& context != null
                //&& context.getSessionTimeout() != 0
                //&& getCreationTime() + (context.getSessionTimeout() * 1000)
                    //< System.currentTimeMillis()) {
            //isValid = false;
        //}
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.200 -0400", hash_original_method = "9CCB74C876B98AB8C259B415A5496084", hash_generated_method = "D973F2208FD25A513B4A2BF5A3AECE34")
    public void invalidate() {
        isValid = false;
        sessionContext = null;
        // ---------- Original Method ----------
        //isValid = false;
        //sessionContext = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.200 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "A1300BB4C93986EDA97CC3BDF2A22CB3")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1465802775 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1465802775 = values.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1465802775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1465802775;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.201 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "F04DA91D482716537AAA6E21EEACBCBC")
    public String[] getValueNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1834579630 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1834579630 = values.keySet().toArray(new String[values.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1834579630.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834579630;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.201 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "7419CDD6B31998D2938D48F979DAB833")
    public void putValue(String name, Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null || value == null");
        } //End block
        Object old;
        old = values.put(name, value);
        {
            ((SSLSessionBindingListener) value)
                    .valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
        {
            ((SSLSessionBindingListener) old)
                    .valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //throw new IllegalArgumentException("name == null || value == null");
        //}
        //Object old = values.put(name, value);
        //if (value instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) value)
                    //.valueBound(new SSLSessionBindingEvent(this, name));
        //}
        //if (old instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) old)
                    //.valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.202 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "EB83FDAF739D5AC6924934B283A3EB8C")
    public void removeValue(String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        Object old;
        old = values.remove(name);
        {
            SSLSessionBindingListener listener;
            listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        addTaint(name.getTaint());
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //Object old = values.remove(name);
        //if (old instanceof SSLSessionBindingListener) {
            //SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            //listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:13.202 -0400", hash_original_method = "1A939A31B27FEC68DC8C26996575F0FB", hash_generated_method = "A8CE8D6C0FF6144187B973F048710022")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //NativeCrypto.SSL_SESSION_free(sslSessionNativePointer);
        //} finally {
            //super.finalize();
        //}
    }

    
}

