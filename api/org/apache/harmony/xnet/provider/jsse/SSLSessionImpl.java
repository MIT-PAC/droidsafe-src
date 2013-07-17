package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "8799ECF12F308B9267E84384F8C130BF", hash_generated_field = "8A4271AF76CEF8B5667B49A4D9A7868D")

    private long creationTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "90A5D328FD00C6FE5EBB6109B912317E")

    byte[] id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "D52BF263BB592DFD5C99BCFC956503E4", hash_generated_field = "C69F06F47E4978627AC3DF239BEBA6F7")

    long lastAccessedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "47A36952B8C6C23935E0D010B5EDBA00")

    ProtocolVersion protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "7A3E5BBFBB21F28A5ECA0047133B26EF")

    CipherSuite cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "7CFAD181A1CAE73DBA9CB5F6589A0B7B")

    SSLSessionContext context;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "A6CB07B29967E898A0260B81EE9CED38", hash_generated_field = "02F423993F3653EC8EA2F9443B12F112")

    byte[] master_secret;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.458 -0400", hash_original_field = "0B847DA5EDDF41D2334B42BED52D0465", hash_generated_field = "F56FE881C825B7CD93F8A0F7E04073D2")

    byte[] clientRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.459 -0400", hash_original_field = "77796CD90E8E2914F8F997D40913AC64", hash_generated_field = "1A7A7530C9D8C2184F28723319A6FF4F")

    byte[] serverRandom;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.459 -0400", hash_original_field = "70AC1F18612535124357D903C382EF65", hash_generated_field = "0B1F63DBE702DEAA610286811BDE9119")

    boolean isServer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.461 -0400", hash_original_method = "8B77818B34D277F665DFA23ABC8DBC5D", hash_generated_method = "84BC4610BEAE54767D950B6F6C4E8CEF")
    public  SSLSessionImpl(CipherSuite cipher_suite, SecureRandom secureRandom) {
        addTaint(secureRandom.getTaint());
        creationTime = System.currentTimeMillis();
        lastAccessedTime = creationTime;
        if(cipher_suite == null)        
        {
            this.cipherSuite = CipherSuite.SSL_NULL_WITH_NULL_NULL;
            id = EmptyArray.BYTE;
            isServer = false;
            isValid = false;
        } //End block
        else
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
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.461 -0400", hash_original_method = "6D9F19E2EE775580BB96A397C59A5AA5", hash_generated_method = "E2B4E46D3973CE9D04AB20EF1B7B31FA")
    public  SSLSessionImpl(SecureRandom secureRandom) {
        this(null, secureRandom);
        addTaint(secureRandom.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.461 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "D7468071E70BDD55609EDE20D6D656B6")
    public int getApplicationBufferSize() {
        int var241C2B32F58EBF2C562C0D8BE125FE0C_1805986763 = (SSLRecordProtocol.MAX_DATA_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077431747 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1077431747;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.462 -0400", hash_original_method = "745D2790D3F85591FE85537A877B7167", hash_generated_method = "1E701AD0B2CD88C7349545C337A99107")
    public String getCipherSuite() {
String var80FBB7E6B734C861203B0EF1B8AB804F_855740231 =         cipherSuite.getName();
        var80FBB7E6B734C861203B0EF1B8AB804F_855740231.addTaint(taint);
        return var80FBB7E6B734C861203B0EF1B8AB804F_855740231;
        // ---------- Original Method ----------
        //return cipherSuite.getName();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.462 -0400", hash_original_method = "09A0842085DDEEEFFBE4843237FA7655", hash_generated_method = "5A779BC3BE6F4BFE2E4F3A2D4BA3E7C7")
    public long getCreationTime() {
        long var8799ECF12F308B9267E84384F8C130BF_1891785283 = (creationTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1733622987 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1733622987;
        // ---------- Original Method ----------
        //return creationTime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.462 -0400", hash_original_method = "6FF1AD4C2D68C6B37F5B643FEDAC8BE4", hash_generated_method = "DBE9B2E94E3EEAA51EC375385B2AE5F3")
    public byte[] getId() {
        byte[] varB80BB7740288FDA1F201890375A60C8F_1978084562 = (id);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1906861421 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1906861421;
        // ---------- Original Method ----------
        //return id;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.462 -0400", hash_original_method = "79FEA1654BACC0D1C8F52D94037731AA", hash_generated_method = "56A70C4274285FBF1FE6FF475F44B4FD")
    public long getLastAccessedTime() {
        long varD52BF263BB592DFD5C99BCFC956503E4_1363465180 = (lastAccessedTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1550570807 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1550570807;
        // ---------- Original Method ----------
        //return lastAccessedTime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.463 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "83B152C93775E3063893E3DE607C17F5")
    public Certificate[] getLocalCertificates() {
Certificate[] var4C5AE20413882C8DD1DF3FE09B18641D_250301105 =         localCertificates;
        var4C5AE20413882C8DD1DF3FE09B18641D_250301105.addTaint(taint);
        return var4C5AE20413882C8DD1DF3FE09B18641D_250301105;
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.463 -0400", hash_original_method = "458F509C66510A71C33EE842436FD9CE", hash_generated_method = "2E6D097290107CB897E3DE08AF1059B3")
    public Principal getLocalPrincipal() {
        if(localCertificates != null && localCertificates.length > 0)        
        {
Principal var8766F23B953392F7F4017C72F2D2F8A5_761958878 =             localCertificates[0].getSubjectX500Principal();
            var8766F23B953392F7F4017C72F2D2F8A5_761958878.addTaint(taint);
            return var8766F23B953392F7F4017C72F2D2F8A5_761958878;
        } //End block
Principal var540C13E9E156B687226421B24F2DF178_665856215 =         null;
        var540C13E9E156B687226421B24F2DF178_665856215.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_665856215;
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.463 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "221DF28A1E3072786D27677E61C65337")
    public int getPacketBufferSize() {
        int varC83B5DF623EDEFDB0686BE40106F81D9_1050209971 = (SSLRecordProtocol.MAX_SSL_PACKET_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301782556 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1301782556;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.464 -0400", hash_original_method = "671707B73FC0A29660C8CE2F332B40EC", hash_generated_method = "5ADD7DF919FA0A78CAE8505E9602CB3F")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        if(peerCertificates == null)        
        {
            SSLPeerUnverifiedException var0FB3652A7C89F3D0BB8816AC8678472B_560993518 = new SSLPeerUnverifiedException("No peer certificate");
            var0FB3652A7C89F3D0BB8816AC8678472B_560993518.addTaint(taint);
            throw var0FB3652A7C89F3D0BB8816AC8678472B_560993518;
        } //End block
        javax.security.cert.X509Certificate[] certs = new javax.security.cert.X509Certificate[peerCertificates.length];
for(int i = 0;i < certs.length;i++)
        {
            try 
            {
                certs[i] = javax.security.cert.X509Certificate.getInstance(peerCertificates[i]
                        .getEncoded());
            } //End block
            catch (javax.security.cert.CertificateException ignored)
            {
            } //End block
            catch (CertificateEncodingException ignored)
            {
            } //End block
        } //End block
javax.security.cert.X509Certificate[] var9BDF30FA618B8006CA81E4F4FD9FBC1B_204853352 =         certs;
        var9BDF30FA618B8006CA81E4F4FD9FBC1B_204853352.addTaint(taint);
        return var9BDF30FA618B8006CA81E4F4FD9FBC1B_204853352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.465 -0400", hash_original_method = "3CCB3131DE484F2F007F820172400088", hash_generated_method = "DD816E3032BA9D44A1CE4854B707CE04")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        if(peerCertificates == null)        
        {
            SSLPeerUnverifiedException var0FB3652A7C89F3D0BB8816AC8678472B_147151519 = new SSLPeerUnverifiedException("No peer certificate");
            var0FB3652A7C89F3D0BB8816AC8678472B_147151519.addTaint(taint);
            throw var0FB3652A7C89F3D0BB8816AC8678472B_147151519;
        } //End block
Certificate[] varF937CE92F117196F80CD35B09BCDC7EA_282225735 =         peerCertificates;
        varF937CE92F117196F80CD35B09BCDC7EA_282225735.addTaint(taint);
        return varF937CE92F117196F80CD35B09BCDC7EA_282225735;
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.465 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "EE6694A521A34D05EC00E62AF6C0370D")
    public String getPeerHost() {
String varFEF815055C97D4B621404BF729E85DA2_2115132561 =         peerHost;
        varFEF815055C97D4B621404BF729E85DA2_2115132561.addTaint(taint);
        return varFEF815055C97D4B621404BF729E85DA2_2115132561;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.465 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "3B83AB9F35172F5F1AB131ED1D18630E")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_2035399884 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312864163 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1312864163;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.466 -0400", hash_original_method = "B290FEA54ECCBD8C8D1AB720544591AB", hash_generated_method = "4297040BF167E9F36417DCB85070D2B2")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        if(peerCertificates == null)        
        {
            SSLPeerUnverifiedException var0FB3652A7C89F3D0BB8816AC8678472B_371673970 = new SSLPeerUnverifiedException("No peer certificate");
            var0FB3652A7C89F3D0BB8816AC8678472B_371673970.addTaint(taint);
            throw var0FB3652A7C89F3D0BB8816AC8678472B_371673970;
        } //End block
Principal var9A28761194D2D1E856FBE408F69063AC_1346537775 =         peerCertificates[0].getSubjectX500Principal();
        var9A28761194D2D1E856FBE408F69063AC_1346537775.addTaint(taint);
        return var9A28761194D2D1E856FBE408F69063AC_1346537775;
        // ---------- Original Method ----------
        //if (peerCertificates == null) {
            //throw new SSLPeerUnverifiedException("No peer certificate");
        //}
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.466 -0400", hash_original_method = "70FFC4864CFD3FC7BC69978E71944D24", hash_generated_method = "EA1A26FD5DC082EBC2D82368D2EE0C69")
    public String getProtocol() {
String varC1869FB983D83359EAFE829125122338_217811821 =         (protocol == null) ? "NONE" : protocol.name;
        varC1869FB983D83359EAFE829125122338_217811821.addTaint(taint);
        return varC1869FB983D83359EAFE829125122338_217811821;
        // ---------- Original Method ----------
        //return (protocol == null) ? "NONE" : protocol.name;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.466 -0400", hash_original_method = "E54F5411F9B3E4DD60F47670618D45C7", hash_generated_method = "6417443FFDE6F9440B624E87C7F848AD")
    public SSLSessionContext getSessionContext() {
SSLSessionContext var4C2DD4015CB4BB3F876A587F79816595_1390984236 =         context;
        var4C2DD4015CB4BB3F876A587F79816595_1390984236.addTaint(taint);
        return var4C2DD4015CB4BB3F876A587F79816595_1390984236;
        // ---------- Original Method ----------
        //return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.466 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "008F7671D9528D155728DD7A182250FC")
    public Object getValue(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_1274705465 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_1274705465.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_1274705465;
        } //End block
Object var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1168010996 =         values.get(name);
        var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1168010996.addTaint(taint);
        return var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1168010996;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.467 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "6EE8E96E4F250A1A4C36541F04B980CF")
    public String[] getValueNames() {
String[] var8EC09F25808BADEED53BE05F8E91790F_97021665 =         values.keySet().toArray(new String[values.size()]);
        var8EC09F25808BADEED53BE05F8E91790F_97021665.addTaint(taint);
        return var8EC09F25808BADEED53BE05F8E91790F_97021665;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.467 -0400", hash_original_method = "81658CAC0BD01D20DC226803375A1EFC", hash_generated_method = "1607D36240D420C7B62C0493DECE3B97")
    public void invalidate() {
        isValid = false;
        context = null;
        // ---------- Original Method ----------
        //isValid = false;
        //context = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.467 -0400", hash_original_method = "901AA8BB3AAD61331954CF916345412F", hash_generated_method = "57F94B39BBE8F37032437E2E554DA92A")
    public boolean isValid() {
        if(isValid && context != null && context.getSessionTimeout() != 0
                && lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis())        
        {
            isValid = false;
        } //End block
        boolean varCE74825B5A01C99B06AF231DE0BD667D_1021293605 = (isValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_970990122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_970990122;
        // ---------- Original Method ----------
        //if (isValid && context != null && context.getSessionTimeout() != 0
                //&& lastAccessedTime + context.getSessionTimeout() > System.currentTimeMillis()) {
            //isValid = false;
        //}
        //return isValid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.468 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "D31FE15FCE0663914F4D8E0D77EACF56")
    public void putValue(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null || value == null)        
        {
            IllegalArgumentException var8B2F8D7AAF6CA4AD931494119DFBFE29_1228570144 = new IllegalArgumentException("name == null || value == null");
            var8B2F8D7AAF6CA4AD931494119DFBFE29_1228570144.addTaint(taint);
            throw var8B2F8D7AAF6CA4AD931494119DFBFE29_1228570144;
        } //End block
        Object old = values.put(name, value);
        if(value instanceof SSLSessionBindingListener)        
        {
            ((SSLSessionBindingListener) value).valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
        if(old instanceof SSLSessionBindingListener)        
        {
            ((SSLSessionBindingListener) old).valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.468 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "F43E7260E36DDA0C51FB6585ABBB1CE5")
    public void removeValue(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_356424191 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_356424191.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_356424191;
        } //End block
        Object old = values.remove(name);
        if(old instanceof SSLSessionBindingListener)        
        {
            SSLSessionBindingListener listener = (SSLSessionBindingListener) old;
            listener.valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.469 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "37CD925D3200AEE725386319AACB084C")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_965711138 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_965711138.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_965711138;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1062152296 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1062152296.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1062152296;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.469 -0400", hash_original_method = "1B64858E0F9CF91B520A55B4E94E3F8D", hash_generated_method = "0E66339A36DC0FF9D4F6EB65322A02EE")
     void setPeer(String peerHost, int peerPort) {
        this.peerHost = peerHost;
        this.peerPort = peerPort;
        // ---------- Original Method ----------
        //this.peerHost = peerHost;
        //this.peerPort = peerPort;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:32.469 -0400", hash_original_field = "10B912D63EB3E367F83FB84A7614EDB8", hash_generated_field = "4097B493A1663D0BA471C72A0F0B7465")

    public static final SSLSessionImpl NULL_SESSION = new SSLSessionImpl(null);
}

