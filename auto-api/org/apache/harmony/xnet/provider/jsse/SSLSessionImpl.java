package org.apache.harmony.xnet.provider.jsse;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "8799ECF12F308B9267E84384F8C130BF", hash_generated_field = "8A4271AF76CEF8B5667B49A4D9A7868D")

    private long creationTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "90A5D328FD00C6FE5EBB6109B912317E")

    byte[] id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "D52BF263BB592DFD5C99BCFC956503E4", hash_generated_field = "C69F06F47E4978627AC3DF239BEBA6F7")

    long lastAccessedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "47A36952B8C6C23935E0D010B5EDBA00")

    ProtocolVersion protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "7A3E5BBFBB21F28A5ECA0047133B26EF")

    CipherSuite cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.959 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "7CFAD181A1CAE73DBA9CB5F6589A0B7B")

    SSLSessionContext context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "A6CB07B29967E898A0260B81EE9CED38", hash_generated_field = "02F423993F3653EC8EA2F9443B12F112")

    byte[] master_secret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "0B847DA5EDDF41D2334B42BED52D0465", hash_generated_field = "F56FE881C825B7CD93F8A0F7E04073D2")

    byte[] clientRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "77796CD90E8E2914F8F997D40913AC64", hash_generated_field = "1A7A7530C9D8C2184F28723319A6FF4F")

    byte[] serverRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_field = "70AC1F18612535124357D903C382EF65", hash_generated_field = "0B1F63DBE702DEAA610286811BDE9119")

    boolean isServer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.960 -0400", hash_original_method = "8B77818B34D277F665DFA23ABC8DBC5D", hash_generated_method = "45FE93336A4FDB3A127EA67AD4CF0249")
    public  SSLSessionImpl(CipherSuite cipher_suite, SecureRandom secureRandom) {
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        {
            this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            id = EmptyArray.BYTE;
            isServer = false;
            isValid = false;
        } 
        {
            this.cipherSuite = cipher_suite;
            id = new byte[32];
            secureRandom.nextBytes(id);
            long time = creationTime / 1000;
            id[28] = (byte) ((time & 0xFF000000) >>> 24);
            id[29] = (byte) ((time & 0x00FF0000) >>> 16);
            id[30] = (byte) ((time & 0x0000FF00) >>> 8);
            id[31] = (byte) ((time & 0x000000FF));
            isServer = true;
        } 
        addTaint(secureRandom.getTaint());
        
        
        
        
            
            
            
            
        
            
            
            
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.961 -0400", hash_original_method = "6D9F19E2EE775580BB96A397C59A5AA5", hash_generated_method = "E2B4E46D3973CE9D04AB20EF1B7B31FA")
    public  SSLSessionImpl(SecureRandom secureRandom) {
        this(null, secureRandom);
        addTaint(secureRandom.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.961 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "820C78AC42B4C32E3667D008D422B1F4")
    public int getApplicationBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337876333 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_337876333;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.962 -0400", hash_original_method = "745D2790D3F85591FE85537A877B7167", hash_generated_method = "120E796E4819AA9BB16A11635B852507")
    public String getCipherSuite() {
        String varB4EAC82CA7396A68D541C85D26508E83_1941937219 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1941937219 = cipherSuite.getName();
        varB4EAC82CA7396A68D541C85D26508E83_1941937219.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1941937219;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.962 -0400", hash_original_method = "09A0842085DDEEEFFBE4843237FA7655", hash_generated_method = "197852CC1BD7FEF43BE9B255A00D0F89")
    public long getCreationTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1381341135 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1381341135;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.963 -0400", hash_original_method = "6FF1AD4C2D68C6B37F5B643FEDAC8BE4", hash_generated_method = "6A88275EB786E25B6D286293D37CA757")
    public byte[] getId() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1706514840 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1706514840;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.963 -0400", hash_original_method = "79FEA1654BACC0D1C8F52D94037731AA", hash_generated_method = "A379EA917B5EEFDCD356A202FDED83B7")
    public long getLastAccessedTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_282665336 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_282665336;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.964 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "AF97B7777EA94E43B7FE09CE70C91AF0")
    public Certificate[] getLocalCertificates() {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_2061702148 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2061702148 = localCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_2061702148.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2061702148;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.965 -0400", hash_original_method = "458F509C66510A71C33EE842436FD9CE", hash_generated_method = "8A96D772B23F353679BB7AE22E8181F0")
    public Principal getLocalPrincipal() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_2047022568 = null; 
        Principal varB4EAC82CA7396A68D541C85D26508E83_1022143520 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2047022568 = localCertificates[0].getSubjectX500Principal();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1022143520 = null;
        Principal varA7E53CE21691AB073D9660D615818899_919647912; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_919647912 = varB4EAC82CA7396A68D541C85D26508E83_2047022568;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_919647912 = varB4EAC82CA7396A68D541C85D26508E83_1022143520;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_919647912.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_919647912;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.965 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "6AE182729DC0F56AD6ECCA8D576DDE09")
    public int getPacketBufferSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760054620 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1760054620;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.966 -0400", hash_original_method = "671707B73FC0A29660C8CE2F332B40EC", hash_generated_method = "E2C6FCD19603C02F60459B5DF0EB414C")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        javax.security.cert.X509Certificate[] varB4EAC82CA7396A68D541C85D26508E83_907679643 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } 
        javax.security.cert.X509Certificate[] certs = new javax.security.cert.X509Certificate[peerCertificates.length];
        {
            int i = 0;
            {
                try 
                {
                    certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        .getEncoded());
                } 
                catch (javax.security.cert.CertificateException ignored)
                { }
                catch (CertificateEncodingException ignored)
                { }
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_907679643 = certs;
        varB4EAC82CA7396A68D541C85D26508E83_907679643.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_907679643;
        
        
            
        
        
        
            
                
                        
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.966 -0400", hash_original_method = "3CCB3131DE484F2F007F820172400088", hash_generated_method = "3DC10F5C3C1EDE96CDC6D5953EE6B593")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        Certificate[] varB4EAC82CA7396A68D541C85D26508E83_1341873718 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1341873718 = peerCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_1341873718.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1341873718;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.967 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "4A1B641C06CB998AF21FD3F467DEC229")
    public String getPeerHost() {
        String varB4EAC82CA7396A68D541C85D26508E83_1876404003 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1876404003 = peerHost;
        varB4EAC82CA7396A68D541C85D26508E83_1876404003.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876404003;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.967 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "1E631F7B4F6486AB3DFCCAE70CE19042")
    public int getPeerPort() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283539918 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_283539918;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.967 -0400", hash_original_method = "B290FEA54ECCBD8C8D1AB720544591AB", hash_generated_method = "57DE1FC2F79BDD7A313A1D41B0DDED29")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        Principal varB4EAC82CA7396A68D541C85D26508E83_264631744 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new SSLPeerUnverifiedException("No peer certificate");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_264631744 = peerCertificates[0].getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_264631744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_264631744;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.968 -0400", hash_original_method = "70FFC4864CFD3FC7BC69978E71944D24", hash_generated_method = "0C38BF7014BB58ACE4DDA6A79EA7DEF1")
    public String getProtocol() {
        String varB4EAC82CA7396A68D541C85D26508E83_1888007716 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1888007716 = (protocol == null) ? "NONE" : protocol.name;
        varB4EAC82CA7396A68D541C85D26508E83_1888007716.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1888007716;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.968 -0400", hash_original_method = "E54F5411F9B3E4DD60F47670618D45C7", hash_generated_method = "896F3D95B046B6F4B25149EFB0FE6BE0")
    public SSLSessionContext getSessionContext() {
        SSLSessionContext varB4EAC82CA7396A68D541C85D26508E83_1710478183 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1710478183 = context;
        varB4EAC82CA7396A68D541C85D26508E83_1710478183.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1710478183;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.969 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "F33744E9FD201F81B9431CDB3E29309B")
    public Object getValue(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1703005185 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1703005185 = values.get(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1703005185.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1703005185;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.969 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "72D67FF5EED8E8878E4816DBC4944686")
    public String[] getValueNames() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1976765896 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1976765896 = values.keySet().toArray(new String[values.size()]);
        varB4EAC82CA7396A68D541C85D26508E83_1976765896.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1976765896;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.969 -0400", hash_original_method = "81658CAC0BD01D20DC226803375A1EFC", hash_generated_method = "1607D36240D420C7B62C0493DECE3B97")
    public void invalidate() {
        isValid = false;
        context = null;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.970 -0400", hash_original_method = "901AA8BB3AAD61331954CF916345412F", hash_generated_method = "7822E923B895E57A6411841C66546015")
    public boolean isValid() {
        {
            boolean varC83BECAF1EA0D7531D2106FB65F27935_1792044843 = (isValid && context != null && context.getSessionTimeout() != 0
                && lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis());
            {
                isValid = false;
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1077835941 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1077835941;
        
        
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.970 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "AA9B7695D7EC4CF839CABD5001D316BE")
    public void putValue(String name, Object value) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null || value == null");
        } 
        Object old = values.put(name, value);
        {
            ((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        } 
        {
            ((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        } 
        addTaint(name.getTaint());
        addTaint(value.getTaint());
        
        
            
        
        
        
            
        
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.970 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "926F903F1982985CD9E76CF49D0A2DD8")
    public void removeValue(String name) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("name == null");
        } 
        Object old = values.remove(name);
        {
            SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        } 
        addTaint(name.getTaint());
        
        
            
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.971 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "4B54C5F9719E670661D96C19C7114339")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1613996051 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1613996051 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1613996051.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1613996051;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.971 -0400", hash_original_method = "1B64858E0F9CF91B520A55B4E94E3F8D", hash_generated_method = "0E66339A36DC0FF9D4F6EB65322A02EE")
     void setPeer(String peerHost, int peerPort) {
        this.peerHost = peerHost;
        this.peerPort = peerPort;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:37.971 -0400", hash_original_field = "10B912D63EB3E367F83FB84A7614EDB8", hash_generated_field = "4097B493A1663D0BA471C72A0F0B7465")

    public static final SSLSessionImpl NULL_SESSION = new SSLSessionImpl(null);
}

