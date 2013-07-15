package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.246 -0400", hash_original_field = "5DED728EB700D850EA04B789FE21E2A0", hash_generated_field = "269D1908AAA6996EA79A385B96B8D46B")

    private long creationTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.246 -0400", hash_original_field = "388448CF3FDDB350B7A22E8DFF6A7BC6", hash_generated_field = "CA76B0FD881476C838923B95EAFEFA21")

    long lastAccessedTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.246 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.246 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.246 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "E9BEAE9732AC2010347B9CC56A4B1F6D", hash_generated_field = "CA10727E3B6C4E28BA2DC6C0BB046AB5")

    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "D5A225287EFD2557AC2E83AC46A37BB4", hash_generated_field = "B359FFDC454F9BD60DB6759BAEDB0FBE")

    protected int sslSessionNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

    private String cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "2BB54D2AE49B8469137AD2B40B9E2AD5", hash_generated_field = "60FA26833155E846A9CFC6F83676739D")

    private String compressionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "5B59BBDE6FE889598DF661BDB872EDC1", hash_generated_field = "4CFE5CBF57F2F36BBD15DF349B9E7672")

    private AbstractSessionContext sessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.247 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "8E7258E790097F4AD5ED2D02B17E7B9A")

    private byte[] id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.249 -0400", hash_original_method = "1D97F06EBCB0CC7BB7E5B60E8D275DC2", hash_generated_method = "FE5C2A8EDF8FF5637936D2332932071B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.250 -0400", hash_original_method = "ECC374A16FFF293E37020E85B391DB03", hash_generated_method = "E5A0BF7C0BEEC9E0EA0D0FDE10C862CC")
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
        addTaint(sessionContext.getTaint());
        addTaint(peerCertificates[0].getTaint());
        addTaint(peerPort);
        addTaint(peerHost.getTaint());
        addTaint(derData[0]);
    if(this.sslSessionNativePointer == 0)        
        {
            IOException varFA6EBDDF30FE6825E0AD960CD2C6C03C_2138946621 = new IOException("Invalid session data");
            varFA6EBDDF30FE6825E0AD960CD2C6C03C_2138946621.addTaint(taint);
            throw varFA6EBDDF30FE6825E0AD960CD2C6C03C_2138946621;
        } //End block
        // ---------- Original Method ----------
        //if (this.sslSessionNativePointer == 0) {
            //throw new IOException("Invalid session data");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.250 -0400", hash_original_method = "566A3E7ED91C5CA2BC21AC127756388D", hash_generated_method = "44AC6BD8D46DD4C719F61AF4FD3CAE10")
    public byte[] getId() {
    if(id == null)        
        {
            resetId();
        } //End block
        byte[] varB80BB7740288FDA1F201890375A60C8F_2134679013 = (id);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_732080394 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_732080394;
        // ---------- Original Method ----------
        //if (id == null) {
            //resetId();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.251 -0400", hash_original_method = "57B02BE93AE841112E3F3B64D0EF8580", hash_generated_method = "3A40234A24A17A498837F8630547C44C")
     void resetId() {
        id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
        // ---------- Original Method ----------
        //id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.251 -0400", hash_original_method = "6E61934F3054764656AF5E19BA5296B9", hash_generated_method = "9352FDE1260BF9DDC94FF518670F07D1")
     byte[] getEncoded() {
        byte[] var75494793557DCCA3169151D8314E9D4E_1989616323 = (NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1315405571 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1315405571;
        // ---------- Original Method ----------
        //return NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.252 -0400", hash_original_method = "A19FB54083053630467ACC70727A9F00", hash_generated_method = "629B044707CACC6964A5011BD5DD59FA")
    public long getCreationTime() {
    if(creationTime == 0)        
        {
            creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        } //End block
        long var8799ECF12F308B9267E84384F8C130BF_216682657 = (creationTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1549062492 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1549062492;
        // ---------- Original Method ----------
        //if (creationTime == 0) {
            //creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        //}
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.252 -0400", hash_original_method = "D25DBFE273F16B7B3F4524AEB4575158", hash_generated_method = "74CA49725608D3663D7C313D48429379")
    public long getLastAccessedTime() {
        long varFFDF44C8D9CCB39514B4C2A610D3B3B8_1292532856 = ((lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_2003570050 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2003570050;
        // ---------- Original Method ----------
        //return (lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.253 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "0EDEBCF643E8E2AD62BDD81E84E75957")
    public int getApplicationBufferSize() {
        int var241C2B32F58EBF2C562C0D8BE125FE0C_1131598253 = (SSLRecordProtocol.MAX_DATA_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429226417 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1429226417;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.253 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "756B7F7D9E44A6E376DCE312AEF88F34")
    public int getPacketBufferSize() {
        int varC83B5DF623EDEFDB0686BE40106F81D9_875950615 = (SSLRecordProtocol.MAX_SSL_PACKET_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535840717 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1535840717;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.253 -0400", hash_original_method = "FC218F5482EE1068025787BA631F1A11", hash_generated_method = "4EE889A51BB3CC7B907C237B03C67352")
    public Principal getLocalPrincipal() {
    if(localCertificates != null && localCertificates.length > 0)        
        {
Principal var8766F23B953392F7F4017C72F2D2F8A5_988226729 =             localCertificates[0].getSubjectX500Principal();
            var8766F23B953392F7F4017C72F2D2F8A5_988226729.addTaint(taint);
            return var8766F23B953392F7F4017C72F2D2F8A5_988226729;
        } //End block
        else
        {
Principal var540C13E9E156B687226421B24F2DF178_437209678 =             null;
            var540C13E9E156B687226421B24F2DF178_437209678.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_437209678;
        } //End block
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //} else {
            //return null;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.254 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "76329BC2C12B78A354A27235F589CF2F")
    public Certificate[] getLocalCertificates() {
Certificate[] var4C5AE20413882C8DD1DF3FE09B18641D_1320236458 =         localCertificates;
        var4C5AE20413882C8DD1DF3FE09B18641D_1320236458.addTaint(taint);
        return var4C5AE20413882C8DD1DF3FE09B18641D_1320236458;
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.254 -0400", hash_original_method = "74B59F5E567633033E420B2FD20F7EA9", hash_generated_method = "0F3D15A39915C003777E9508CD42DA35")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] result = peerCertificateChain;
    if(result == null)        
        {
            peerCertificateChain = result = createPeerCertificateChain();
        } //End block
javax.security.cert.X509Certificate[] varDC838461EE2FA0CA4C9BBB70A15456B0_743246483 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_743246483.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_743246483;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //javax.security.cert.X509Certificate[] result = peerCertificateChain;
        //if (result == null) {
            //peerCertificateChain = result = createPeerCertificateChain();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.255 -0400", hash_original_method = "95455CDE829A27B48DAF238C4403FA5A", hash_generated_method = "905FE292207A08272353093683E53F03")
    private javax.security.cert.X509Certificate[] createPeerCertificateChain() throws SSLPeerUnverifiedException {
        try 
        {
            javax.security.cert.X509Certificate[] chain = new javax.security.cert.X509Certificate[peerCertificates.length];
for(int i = 0;i < peerCertificates.length;i++)
            {
                byte[] encoded = peerCertificates[i].getEncoded();
                chain[i] = javax.security.cert.X509Certificate.getInstance(encoded);
            } //End block
javax.security.cert.X509Certificate[] var96007A05DC9437D4696083FF3089928F_219434039 =             chain;
            var96007A05DC9437D4696083FF3089928F_219434039.addTaint(taint);
            return var96007A05DC9437D4696083FF3089928F_219434039;
        } //End block
        catch (CertificateEncodingException e)
        {
            SSLPeerUnverifiedException exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            exception.addTaint(taint);
            throw exception;
        } //End block
        catch (CertificateException e)
        {
            SSLPeerUnverifiedException exception = new SSLPeerUnverifiedException(e.getMessage());
            exception.initCause(exception);
            exception.addTaint(taint);
            throw exception;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.255 -0400", hash_original_method = "6F2F2196C2B5F66BDE334D0180ADBF68", hash_generated_method = "02846BAE9C5B9169F9F394144AED9D35")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
Certificate[] varF937CE92F117196F80CD35B09BCDC7EA_24730958 =         peerCertificates;
        varF937CE92F117196F80CD35B09BCDC7EA_24730958.addTaint(taint);
        return varF937CE92F117196F80CD35B09BCDC7EA_24730958;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.255 -0400", hash_original_method = "4A7519F376EC7B19E89A23705C5BAAD6", hash_generated_method = "63523D92FBCBD1FF5C75CFC1FACD79BD")
    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
    if(peerCertificates == null || peerCertificates.length == 0)        
        {
            SSLPeerUnverifiedException var126CC9F057BAE0A6AE94F8070A58C903_385315772 = new SSLPeerUnverifiedException("No peer certificates");
            var126CC9F057BAE0A6AE94F8070A58C903_385315772.addTaint(taint);
            throw var126CC9F057BAE0A6AE94F8070A58C903_385315772;
        } //End block
        // ---------- Original Method ----------
        //if (peerCertificates == null || peerCertificates.length == 0) {
            //throw new SSLPeerUnverifiedException("No peer certificates");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.256 -0400", hash_original_method = "14CCB3DBB8312C280BE97228D3117477", hash_generated_method = "30099D4351EFC56E043A58FF05FD9007")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
Principal var9A28761194D2D1E856FBE408F69063AC_1306783912 =         peerCertificates[0].getSubjectX500Principal();
        var9A28761194D2D1E856FBE408F69063AC_1306783912.addTaint(taint);
        return var9A28761194D2D1E856FBE408F69063AC_1306783912;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.256 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "D1E04AFEFFE111723EF58D5137E205C6")
    public String getPeerHost() {
String varFEF815055C97D4B621404BF729E85DA2_297024508 =         peerHost;
        varFEF815055C97D4B621404BF729E85DA2_297024508.addTaint(taint);
        return varFEF815055C97D4B621404BF729E85DA2_297024508;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.256 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "742F91FDDB907887236DFC693ABDF6C3")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_1825477253 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093667850 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1093667850;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.257 -0400", hash_original_method = "232543257EF0615A8C98189B2944DDF8", hash_generated_method = "BDAD3065A1167DEB8F78C33D9C6C2436")
    public String getCipherSuite() {
    if(cipherSuite == null)        
        {
            String name = NativeCrypto.SSL_SESSION_cipher(sslSessionNativePointer);
            cipherSuite = NativeCrypto.OPENSSL_TO_STANDARD_CIPHER_SUITES.get(name);
    if(cipherSuite == null)            
            {
                cipherSuite = name;
            } //End block
        } //End block
String var40C8215E3932EC890F412FE48280D7DD_1544627024 =         cipherSuite;
        var40C8215E3932EC890F412FE48280D7DD_1544627024.addTaint(taint);
        return var40C8215E3932EC890F412FE48280D7DD_1544627024;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.257 -0400", hash_original_method = "DC690D466354C337179157E9ED46DB27", hash_generated_method = "32D86A67EE1196209621057B2EDBA641")
    public String getProtocol() {
    if(protocol == null)        
        {
            protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        } //End block
String varDD56EE388A0FA5696BF9686AC14D2DB9_426157750 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_426157750.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_426157750;
        // ---------- Original Method ----------
        //if (protocol == null) {
            //protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        //}
        //return protocol;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.258 -0400", hash_original_method = "968671DF82E2AA12BC31F552097867FE", hash_generated_method = "3BE52BFADC0FD287E1BBD467181C45AD")
    public String getCompressionMethod() {
    if(compressionMethod == null)        
        {
            compressionMethod
                    = NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             sslSessionNativePointer);
        } //End block
String varA8A635525C57E9F2D9CABEB3024E7192_1291776449 =         compressionMethod;
        varA8A635525C57E9F2D9CABEB3024E7192_1291776449.addTaint(taint);
        return varA8A635525C57E9F2D9CABEB3024E7192_1291776449;
        // ---------- Original Method ----------
        //if (compressionMethod == null) {
            //compressionMethod
                    //= NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             //sslSessionNativePointer);
        //}
        //return compressionMethod;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.258 -0400", hash_original_method = "6C1FB28F6F59303D04A80E546963567A", hash_generated_method = "ECAF77913DC169DFC2F936E626FF03F3")
    public SSLSessionContext getSessionContext() {
SSLSessionContext var4CDF9BEB60CDBB66FE106B31ECF12ED3_2097577568 =         sessionContext;
        var4CDF9BEB60CDBB66FE106B31ECF12ED3_2097577568.addTaint(taint);
        return var4CDF9BEB60CDBB66FE106B31ECF12ED3_2097577568;
        // ---------- Original Method ----------
        //return sessionContext;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.259 -0400", hash_original_method = "8D23F85B43098BFBC0CC2E7E59C1A10A", hash_generated_method = "D780E72AD5A1B76AE1F75628AD53820A")
    public boolean isValid() {
        SSLSessionContext context = sessionContext;
    if(isValid
                && context != null
                && context.getSessionTimeout() != 0
                && getCreationTime() + (context.getSessionTimeout() * 1000)
                    < System.currentTimeMillis())        
        {
            isValid = false;
        } //End block
        boolean varCE74825B5A01C99B06AF231DE0BD667D_1656680066 = (isValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1629877456 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1629877456;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.259 -0400", hash_original_method = "9CCB74C876B98AB8C259B415A5496084", hash_generated_method = "D973F2208FD25A513B4A2BF5A3AECE34")
    public void invalidate() {
        isValid = false;
        sessionContext = null;
        // ---------- Original Method ----------
        //isValid = false;
        //sessionContext = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.259 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "BBFCBD9CA0AA5612F8812E70EE338ABC")
    public Object getValue(String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_1556603917 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_1556603917.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_1556603917;
        } //End block
Object var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1389887226 =         values.get(name);
        var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1389887226.addTaint(taint);
        return var6DAEDF94ADFD5EF7FEDE28F5B58DA162_1389887226;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.260 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "AF3A0BF4A591ECA659134BB5CB98F832")
    public String[] getValueNames() {
String[] var8EC09F25808BADEED53BE05F8E91790F_784848668 =         values.keySet().toArray(new String[values.size()]);
        var8EC09F25808BADEED53BE05F8E91790F_784848668.addTaint(taint);
        return var8EC09F25808BADEED53BE05F8E91790F_784848668;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.260 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "39EF6248E7D0813ED7340730837AF248")
    public void putValue(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
    if(name == null || value == null)        
        {
            IllegalArgumentException var8B2F8D7AAF6CA4AD931494119DFBFE29_44699778 = new IllegalArgumentException("name == null || value == null");
            var8B2F8D7AAF6CA4AD931494119DFBFE29_44699778.addTaint(taint);
            throw var8B2F8D7AAF6CA4AD931494119DFBFE29_44699778;
        } //End block
        Object old = values.put(name, value);
    if(value instanceof SSLSessionBindingListener)        
        {
            ((SSLSessionBindingListener) value)
                    .valueBound(new SSLSessionBindingEvent(this, name));
        } //End block
    if(old instanceof SSLSessionBindingListener)        
        {
            ((SSLSessionBindingListener) old)
                    .valueUnbound(new SSLSessionBindingEvent(this, name));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.261 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "9A57ECA5D7D5A85A4098ECD02C81AEE7")
    public void removeValue(String name) {
        addTaint(name.getTaint());
    if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_1313215786 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_1313215786.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_1313215786;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.261 -0400", hash_original_method = "1A939A31B27FEC68DC8C26996575F0FB", hash_generated_method = "A8CE8D6C0FF6144187B973F048710022")
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

