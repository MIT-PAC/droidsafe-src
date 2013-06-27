package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.security.Principal;
import java.security.SecureRandom;
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
import libcore.util.EmptyArray;

public final class SSLSessionImpl implements SSLSession, Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.937 -0400", hash_original_field = "8799ECF12F308B9267E84384F8C130BF", hash_generated_field = "8A4271AF76CEF8B5667B49A4D9A7868D")

    private long creationTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.938 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.943 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "34EC4E58A52046C4CA9DDEF945200C60")

    private Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.943 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "90A5D328FD00C6FE5EBB6109B912317E")

    byte[] id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.943 -0400", hash_original_field = "D52BF263BB592DFD5C99BCFC956503E4", hash_generated_field = "C69F06F47E4978627AC3DF239BEBA6F7")

    long lastAccessedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "47A36952B8C6C23935E0D010B5EDBA00")

    ProtocolVersion protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "7A3E5BBFBB21F28A5ECA0047133B26EF")

    CipherSuite cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "7CFAD181A1CAE73DBA9CB5F6589A0B7B")

    SSLSessionContext context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "A6CB07B29967E898A0260B81EE9CED38", hash_generated_field = "02F423993F3653EC8EA2F9443B12F112")

    byte[] master_secret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "0B847DA5EDDF41D2334B42BED52D0465", hash_generated_field = "F56FE881C825B7CD93F8A0F7E04073D2")

    byte[] clientRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "77796CD90E8E2914F8F997D40913AC64", hash_generated_field = "1A7A7530C9D8C2184F28723319A6FF4F")

    byte[] serverRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.944 -0400", hash_original_field = "70AC1F18612535124357D903C382EF65", hash_generated_field = "0B1F63DBE702DEAA610286811BDE9119")

    boolean isServer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.945 -0400", hash_original_method = "8B77818B34D277F665DFA23ABC8DBC5D", hash_generated_method = "4CA3A688A2E56E32975757D625070B98")
    public  SSLSessionImpl(CipherSuite cipher_suite, SecureRandom secureRandom) {
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        {
            this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            id = EmptyArray.BYTE;
            isServer = false;
            isValid = false;
        } //End block
        {
            this.cipherSuite = cipher_suite;
            id = new byte[32];
            secureRandom.nextBytes(id);
            long time;
            time = creationTime / 1000;
            id[28] = (byte) ((time & 0xFF000000) >>> 24);
            id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            id[31] = (byte) ((time & 0x000000FF));
            isServer = true;
        } //End block
        addTaint(secureRandom.getTaint());
        // ---------- Original Method ----------
        //creationTime = System.currentTimeMillis();
        //lastAccessedTime = creationTime;
        //if (cipher_suite == null) {
            //this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            //id = EmptyArray.BYTE;
            //isServer = false;
            //isValid = false;
        //} else {
            //this.cipherSuite = cipher_suite;
            //id = new byte[32];
            //secureRandom.nextBytes(id);
            //long time = creationTime / 1000;
            //id[28] = (byte) ((time & 0xFF000000) >>> 24);
            //id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            //id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            //id[31] = (byte) ((time & 0x000000FF));
            //isServer = true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.951 -0400", hash_original_method = "6D9F19E2EE775580BB96A397C59A5AA5", hash_generated_method = "E2B4E46D3973CE9D04AB20EF1B7B31FA")
    public  SSLSessionImpl(SecureRandom secureRandom) {
        this(null, secureRandom);
        addTaint(secureRandom.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.952 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "3A35274B3AD6B69EC772EE944885257C")
    public int getApplicationBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579260685 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1579260685;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.956 -0400", hash_original_method = "745D2790D3F85591FE85537A877B7167", hash_generated_method = "DE9A3A14F475614FB0815789D774DCC5")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_1687746475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1687746475 = cipherSuite.getName();
        varB4EAC82CA7396A68D541C85D26508E83_1687746475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687746475;
        // ---------- Original Method ----------
        //return cipherSuite.getName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.958 -0400", hash_original_method = "09A0842085DDEEEFFBE4843237FA7655", hash_generated_method = "5FD1E690799BF1B42C78E51E42AF2B92")
    public long getCreationTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1520721241 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1520721241;
        // ---------- Original Method ----------
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.962 -0400", hash_original_method = "6FF1AD4C2D68C6B37F5B643FEDAC8BE4", hash_generated_method = "33B97A0639A3487518C4D9ADD9735271")
    public byte[] getId() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1834898698 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1834898698;
        // ---------- Original Method ----------
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.962 -0400", hash_original_method = "79FEA1654BACC0D1C8F52D94037731AA", hash_generated_method = "0BE08FA53652EBD6629C328F4701EF1B")
    public long getLastAccessedTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1008957363 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1008957363;
        // ---------- Original Method ----------
        //return lastAccessedTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.963 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "CCF9AEE67B12B44F8088CFDE61BD4A20")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_617619181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_617619181 = localCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_617619181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_617619181;
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.963 -0400", hash_original_method = "458F509C66510A71C33EE842436FD9CE", hash_generated_method = "71987DCFD092650E9F0016E0608E8EF4")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_668730947 = null; //Variable for return #1
        Principal varB4EAC82CA7396A68D541C85D26508E83_248391488 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_668730947 = localCertificates[0].getSubjectX500Principal();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_248391488 = null;
        Principal varA7E53CE21691AB073D9660D615818899_702877664; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_702877664 = varB4EAC82CA7396A68D541C85D26508E83_668730947;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_702877664 = varB4EAC82CA7396A68D541C85D26508E83_248391488;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_702877664.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_702877664;
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.966 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "E1256C24B014C6E57A46B22D21467DF0")
    public int getPacketBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665391763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665391763;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.975 -0400", hash_original_method = "671707B73FC0A29660C8CE2F332B40EC", hash_generated_method = "2FF08069E64F48536DE024B908D4691F")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        javax.security.cert.X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1436348770 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        javax.security.cert.X509Certificate[] certs;
        certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        {
            int i;
            i = 0;
            {
                try 
                {
                    certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        .getEncoded());
                } //End block
                catch (javax.security.cert.CertificateException ignored)
                { }
                catch (CertificateEncodingException ignored)
                { }
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1436348770 = certs;
        varB4EAC82CA7396A68D541C85D26508E83_1436348770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1436348770;
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //javax.security.cert.X509Certificate[] certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        //for (int i = 0; i < certs.length; i++) {
            //try {
                //certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        //.getEncoded());
            //} catch (javax.security.cert.CertificateException ignored) {
            //} catch (CertificateEncodingException ignored) {
            //}
        //}
        //return certs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.975 -0400", hash_original_method = "3CCB3131DE484F2F007F820172400088", hash_generated_method = "09D08031FCE97917362B22B0F1059556")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_875708606 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_875708606 = peerCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_875708606.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_875708606;
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.977 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "C01D5C32E0EA89516A8F77CE9AE518FC")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_696552940 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_696552940 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_696552940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_696552940;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.977 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "135825520A9D45FE4AEE9B8FECC37EB3")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450931655 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450931655;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.977 -0400", hash_original_method = "B290FEA54ECCBD8C8D1AB720544591AB", hash_generated_method = "6D3ED08F17181968F80CF2E3312A3C13")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1608358775 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1608358775 = peerCertificates[0].getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_1608358775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1608358775;
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.978 -0400", hash_original_method = "70FFC4864CFD3FC7BC69978E71944D24", hash_generated_method = "5A9991F5E344BAFF38767EBE81891F77")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1117580052 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1117580052 = (protocol == null) ? "NONE" : protocol.name;
        varB4EAC82CA7396A68D541C85D26508E83_1117580052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1117580052;
        // ---------- Original Method ----------
        //return (protocol == null) ? "NONE" : protocol.name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.978 -0400", hash_original_method = "E54F5411F9B3E4DD60F47670618D45C7", hash_generated_method = "3AAD41D5F3EBF463A6FD12CA3F532382")
    public SSLSessionContext getSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_982393875 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_982393875 = context;
        varB4EAC82CA7396A68D541C85D26508E83_982393875.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_982393875;
        // ---------- Original Method ----------
        //return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.992 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "7273B0BF5A3EAFD0F95A1FF44207789B")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1147817561 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1147817561 = values.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1147817561.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1147817561;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.992 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "D71FEECBE2276EE1B6CD16DBF467AE89")
    public String[] getValueNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_961484777 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_961484777 = values.keySet().toArray(new String[values.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_961484777.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_961484777;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.992 -0400", hash_original_method = "81658CAC0BD01D20DC226803375A1EFC", hash_generated_method = "1607D36240D420C7B62C0493DECE3B97")
    public void invalidate() {
        isValid = false;
        context = null;
        // ---------- Original Method ----------
        //isValid = false;
        //context = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.993 -0400", hash_original_method = "901AA8BB3AAD61331954CF916345412F", hash_generated_method = "6E5AAE806A94C6B670A6D05B2980B0F5")
    public boolean isValid() {
        {
            boolean varC83BECAF1EA0D7531D2106FB65F27935_1470051502 = (isValid && context != null && context.getSessionTimeout() != 0
                && lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis());
            {
                isValid = false;
            } //End block
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1674954634 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1674954634;
        // ---------- Original Method ----------
        //if (isValid && context != null && context.getSessionTimeout() != 0
                //&& lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis()) {
            //isValid = false;
        //}
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.994 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "0FEE7A9AA134ACD412F9AA1DFD3BCC4B")
    public void putValue(String name, Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null || value == null");
        } //End block
        Object old;
        old = values.put(name, value);
        {
            ((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
        {
            ((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //if (name == null || value == null) {
            //throw new IllegalArgumentException("name == null || value == null");
        //}
        //Object old = values.put(name, value);
        //if (value instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        //}
        //if (old instanceof SSLSessionBindingListener) {
            //((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.994 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "EB83FDAF739D5AC6924934B283A3EB8C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.995 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "BED30C3E9E7E13341A26198EA2DC53A5")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1743714639 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1743714639 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1743714639.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1743714639;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.995 -0400", hash_original_method = "1B64858E0F9CF91B520A55B4E94E3F8D", hash_generated_method = "0E66339A36DC0FF9D4F6EB65322A02EE")
     void setPeer(String peerHost, int peerPort) {
        this.peerHost = peerHost;
        this.peerPort = peerPort;
        // ---------- Original Method ----------
        //this.peerHost = peerHost;
        //this.peerPort = peerPort;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.995 -0400", hash_original_field = "10B912D63EB3E367F83FB84A7614EDB8", hash_generated_field = "4097B493A1663D0BA471C72A0F0B7465")

    public static final SSLSessionImpl NULL_SESSION = new SSLSessionImpl(null);
}

