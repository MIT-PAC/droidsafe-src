package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class OpenSSLSessionImpl implements SSLSession {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "5DED728EB700D850EA04B789FE21E2A0", hash_generated_field = "269D1908AAA6996EA79A385B96B8D46B")

    private long creationTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "388448CF3FDDB350B7A22E8DFF6A7BC6", hash_generated_field = "CA76B0FD881476C838923B95EAFEFA21")

    long lastAccessedTime = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "6F142D6C5C187A9E1F8D9F1E506C53A1", hash_generated_field = "32A66D390E195F822A847B8B4CE21F22")

    X509Certificate[] localCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "8B0159748D248FD98D3660C86BA7E100", hash_generated_field = "C26B9ED4C7D0355EF58C50C7FCD5DD79")

    X509Certificate[] peerCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "8AEB5FF3DF8A5B1CEA44718D6D637F23", hash_generated_field = "5738630542C71F34716CA340A1982FCB")

    private boolean isValid = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "31E0234F59EDA4B6B45940B0273E8577", hash_generated_field = "9D0FE98D3FB5DD14BD6D5D1B013768C8")

    private final Map<String, Object> values = new HashMap<String, Object>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "E9BEAE9732AC2010347B9CC56A4B1F6D", hash_generated_field = "CA10727E3B6C4E28BA2DC6C0BB046AB5")

    private volatile javax.security.cert.X509Certificate[] peerCertificateChain;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "D5A225287EFD2557AC2E83AC46A37BB4", hash_generated_field = "B359FFDC454F9BD60DB6759BAEDB0FBE")

    protected int sslSessionNativePointer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "4EC98FB9133927791198E49B2FD46358", hash_generated_field = "871B4093DF845204CC93E22B63A3EB07")

    private String peerHost;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.800 -0400", hash_original_field = "8B19A0FF46E0A9E3223D7D9514D0916A", hash_generated_field = "95590212F4127D0DA83F9732C159832A")

    private int peerPort = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.801 -0400", hash_original_field = "3CB6C58EE89931E7823844852162AE8C", hash_generated_field = "2B93F4D04C330EE5C6289BC73BF497CE")

    private String cipherSuite;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.801 -0400", hash_original_field = "81788BA0D7D02D81C063DBCA621BA11B", hash_generated_field = "512C13BA7A4120A610964F395EA31E91")

    private String protocol;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.801 -0400", hash_original_field = "2BB54D2AE49B8469137AD2B40B9E2AD5", hash_generated_field = "60FA26833155E846A9CFC6F83676739D")

    private String compressionMethod;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.801 -0400", hash_original_field = "5B59BBDE6FE889598DF661BDB872EDC1", hash_generated_field = "4CFE5CBF57F2F36BBD15DF349B9E7672")

    private AbstractSessionContext sessionContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.801 -0400", hash_original_field = "B80BB7740288FDA1F201890375A60C8F", hash_generated_field = "8E7258E790097F4AD5ED2D02B17E7B9A")

    private byte[] id;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.803 -0400", hash_original_method = "1D97F06EBCB0CC7BB7E5B60E8D275DC2", hash_generated_method = "FE5C2A8EDF8FF5637936D2332932071B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.803 -0400", hash_original_method = "ECC374A16FFF293E37020E85B391DB03", hash_generated_method = "A90BD01E38CC5719D42FB4108A6041EA")
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
            IOException varFA6EBDDF30FE6825E0AD960CD2C6C03C_1638100613 = new IOException("Invalid session data");
            varFA6EBDDF30FE6825E0AD960CD2C6C03C_1638100613.addTaint(taint);
            throw varFA6EBDDF30FE6825E0AD960CD2C6C03C_1638100613;
        } //End block
        // ---------- Original Method ----------
        //if (this.sslSessionNativePointer == 0) {
            //throw new IOException("Invalid session data");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.804 -0400", hash_original_method = "566A3E7ED91C5CA2BC21AC127756388D", hash_generated_method = "0C61C1DB89E8142128D9DF36886EC2B8")
    public byte[] getId() {
        if(id == null)        
        {
            resetId();
        } //End block
        byte[] varB80BB7740288FDA1F201890375A60C8F_1985090631 = (id);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_140258083 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_140258083;
        // ---------- Original Method ----------
        //if (id == null) {
            //resetId();
        //}
        //return id;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.804 -0400", hash_original_method = "57B02BE93AE841112E3F3B64D0EF8580", hash_generated_method = "3A40234A24A17A498837F8630547C44C")
     void resetId() {
        id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
        // ---------- Original Method ----------
        //id = NativeCrypto.SSL_SESSION_session_id(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.804 -0400", hash_original_method = "6E61934F3054764656AF5E19BA5296B9", hash_generated_method = "2055E20CD97685841DB8B81C4659930A")
     byte[] getEncoded() {
        byte[] var75494793557DCCA3169151D8314E9D4E_359558878 = (NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1991096060 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1991096060;
        // ---------- Original Method ----------
        //return NativeCrypto.i2d_SSL_SESSION(sslSessionNativePointer);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.805 -0400", hash_original_method = "A19FB54083053630467ACC70727A9F00", hash_generated_method = "0E2364F467A024429334A50C22831B62")
    public long getCreationTime() {
        if(creationTime == 0)        
        {
            creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        } //End block
        long var8799ECF12F308B9267E84384F8C130BF_1754938654 = (creationTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_557138842 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_557138842;
        // ---------- Original Method ----------
        //if (creationTime == 0) {
            //creationTime = NativeCrypto.SSL_SESSION_get_time(sslSessionNativePointer);
        //}
        //return creationTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.805 -0400", hash_original_method = "D25DBFE273F16B7B3F4524AEB4575158", hash_generated_method = "1034BFA31966A106235C3312E08FC7C4")
    public long getLastAccessedTime() {
        long varFFDF44C8D9CCB39514B4C2A610D3B3B8_1789423357 = ((lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_743006143 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_743006143;
        // ---------- Original Method ----------
        //return (lastAccessedTime == 0) ? getCreationTime() : lastAccessedTime;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.806 -0400", hash_original_method = "A8B8393BBD8B21276043F8F436BCE41F", hash_generated_method = "1D6EE418B29C116ED3E477304CD1EFC2")
    public int getApplicationBufferSize() {
        int var241C2B32F58EBF2C562C0D8BE125FE0C_331459466 = (SSLRecordProtocol.MAX_DATA_LENGTH);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495782572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495782572;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_DATA_LENGTH;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.806 -0400", hash_original_method = "D48FD6D531D6586277314A5CB11C610B", hash_generated_method = "88331CEBD79273258E9BAA422A23B5B3")
    public int getPacketBufferSize() {
        int varC83B5DF623EDEFDB0686BE40106F81D9_965801443 = (SSLRecordProtocol.MAX_SSL_PACKET_SIZE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184125446 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_184125446;
        // ---------- Original Method ----------
        //return SSLRecordProtocol.MAX_SSL_PACKET_SIZE;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.807 -0400", hash_original_method = "FC218F5482EE1068025787BA631F1A11", hash_generated_method = "F4EEDCB24AFA42C6E670CBC10324368F")
    public Principal getLocalPrincipal() {
        if(localCertificates != null && localCertificates.length > 0)        
        {
Principal var8766F23B953392F7F4017C72F2D2F8A5_1944796080 =             localCertificates[0].getSubjectX500Principal();
            var8766F23B953392F7F4017C72F2D2F8A5_1944796080.addTaint(taint);
            return var8766F23B953392F7F4017C72F2D2F8A5_1944796080;
        } //End block
        else
        {
Principal var540C13E9E156B687226421B24F2DF178_301349010 =             null;
            var540C13E9E156B687226421B24F2DF178_301349010.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_301349010;
        } //End block
        // ---------- Original Method ----------
        //if (localCertificates != null && localCertificates.length > 0) {
            //return localCertificates[0].getSubjectX500Principal();
        //} else {
            //return null;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.807 -0400", hash_original_method = "00176E7E524F828990985588910F48EC", hash_generated_method = "E89B5705103C259F0D7D671DE17500A8")
    public Certificate[] getLocalCertificates() {
Certificate[] var4C5AE20413882C8DD1DF3FE09B18641D_92966799 =         localCertificates;
        var4C5AE20413882C8DD1DF3FE09B18641D_92966799.addTaint(taint);
        return var4C5AE20413882C8DD1DF3FE09B18641D_92966799;
        // ---------- Original Method ----------
        //return localCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.808 -0400", hash_original_method = "74B59F5E567633033E420B2FD20F7EA9", hash_generated_method = "62CC5EB0286BC36E92EE8D15CBC4863F")
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
        javax.security.cert.X509Certificate[] result = peerCertificateChain;
        if(result == null)        
        {
            peerCertificateChain = result = createPeerCertificateChain();
        } //End block
javax.security.cert.X509Certificate[] varDC838461EE2FA0CA4C9BBB70A15456B0_364534767 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_364534767.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_364534767;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //javax.security.cert.X509Certificate[] result = peerCertificateChain;
        //if (result == null) {
            //peerCertificateChain = result = createPeerCertificateChain();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.808 -0400", hash_original_method = "95455CDE829A27B48DAF238C4403FA5A", hash_generated_method = "8FE6235DF5F3F785C5C0F911D2C49F69")
    private javax.security.cert.X509Certificate[] createPeerCertificateChain() throws SSLPeerUnverifiedException {
        try 
        {
            javax.security.cert.X509Certificate[] chain = new javax.security.cert.X509Certificate[peerCertificates.length];
for(int i = 0;i < peerCertificates.length;i++)
            {
                byte[] encoded = peerCertificates[i].getEncoded();
                chain[i] = javax.security.cert.X509Certificate.getInstance(encoded);
            } //End block
javax.security.cert.X509Certificate[] var96007A05DC9437D4696083FF3089928F_107812910 =             chain;
            var96007A05DC9437D4696083FF3089928F_107812910.addTaint(taint);
            return var96007A05DC9437D4696083FF3089928F_107812910;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.808 -0400", hash_original_method = "6F2F2196C2B5F66BDE334D0180ADBF68", hash_generated_method = "FBAF1EDE79C3C0FA5562BBAB2864C1B5")
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
Certificate[] varF937CE92F117196F80CD35B09BCDC7EA_1429103444 =         peerCertificates;
        varF937CE92F117196F80CD35B09BCDC7EA_1429103444.addTaint(taint);
        return varF937CE92F117196F80CD35B09BCDC7EA_1429103444;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.809 -0400", hash_original_method = "4A7519F376EC7B19E89A23705C5BAAD6", hash_generated_method = "6EF810108CC956F014272DF61E60AD4B")
    private void checkPeerCertificatesPresent() throws SSLPeerUnverifiedException {
        if(peerCertificates == null || peerCertificates.length == 0)        
        {
            SSLPeerUnverifiedException var126CC9F057BAE0A6AE94F8070A58C903_1401668195 = new SSLPeerUnverifiedException("No peer certificates");
            var126CC9F057BAE0A6AE94F8070A58C903_1401668195.addTaint(taint);
            throw var126CC9F057BAE0A6AE94F8070A58C903_1401668195;
        } //End block
        // ---------- Original Method ----------
        //if (peerCertificates == null || peerCertificates.length == 0) {
            //throw new SSLPeerUnverifiedException("No peer certificates");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.809 -0400", hash_original_method = "14CCB3DBB8312C280BE97228D3117477", hash_generated_method = "67068CD65775EDA5A2639E2F80BC216F")
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        checkPeerCertificatesPresent();
Principal var9A28761194D2D1E856FBE408F69063AC_1696293663 =         peerCertificates[0].getSubjectX500Principal();
        var9A28761194D2D1E856FBE408F69063AC_1696293663.addTaint(taint);
        return var9A28761194D2D1E856FBE408F69063AC_1696293663;
        // ---------- Original Method ----------
        //checkPeerCertificatesPresent();
        //return peerCertificates[0].getSubjectX500Principal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.809 -0400", hash_original_method = "686621F471AF14AF505B60419214318E", hash_generated_method = "A818B0FE39937617DB13BB408FB595E8")
    public String getPeerHost() {
String varFEF815055C97D4B621404BF729E85DA2_393482613 =         peerHost;
        varFEF815055C97D4B621404BF729E85DA2_393482613.addTaint(taint);
        return varFEF815055C97D4B621404BF729E85DA2_393482613;
        // ---------- Original Method ----------
        //return peerHost;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.809 -0400", hash_original_method = "356711D154A2D021F9E9DF4BCD609AF2", hash_generated_method = "4F22A311666B55926FF7B1A6111B392C")
    public int getPeerPort() {
        int varBBD5741C4F9994864582D25DD194C4DE_91066582 = (peerPort);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355524883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_355524883;
        // ---------- Original Method ----------
        //return peerPort;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.810 -0400", hash_original_method = "232543257EF0615A8C98189B2944DDF8", hash_generated_method = "C179B47B11E6B4F6E455A4F84068AD40")
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
String var40C8215E3932EC890F412FE48280D7DD_2126276719 =         cipherSuite;
        var40C8215E3932EC890F412FE48280D7DD_2126276719.addTaint(taint);
        return var40C8215E3932EC890F412FE48280D7DD_2126276719;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.810 -0400", hash_original_method = "DC690D466354C337179157E9ED46DB27", hash_generated_method = "CB3F4DF6355740C3C28F355883FD1841")
    public String getProtocol() {
        if(protocol == null)        
        {
            protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        } //End block
String varDD56EE388A0FA5696BF9686AC14D2DB9_1463987812 =         protocol;
        varDD56EE388A0FA5696BF9686AC14D2DB9_1463987812.addTaint(taint);
        return varDD56EE388A0FA5696BF9686AC14D2DB9_1463987812;
        // ---------- Original Method ----------
        //if (protocol == null) {
            //protocol = NativeCrypto.SSL_SESSION_get_version(sslSessionNativePointer);
        //}
        //return protocol;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.811 -0400", hash_original_method = "968671DF82E2AA12BC31F552097867FE", hash_generated_method = "3D0C90D1AB6852A221F5FD6618D1BD12")
    public String getCompressionMethod() {
        if(compressionMethod == null)        
        {
            compressionMethod
                    = NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             sslSessionNativePointer);
        } //End block
String varA8A635525C57E9F2D9CABEB3024E7192_1719445145 =         compressionMethod;
        varA8A635525C57E9F2D9CABEB3024E7192_1719445145.addTaint(taint);
        return varA8A635525C57E9F2D9CABEB3024E7192_1719445145;
        // ---------- Original Method ----------
        //if (compressionMethod == null) {
            //compressionMethod
                    //= NativeCrypto.SSL_SESSION_compress_meth(sessionContext.sslCtxNativePointer,
                                                             //sslSessionNativePointer);
        //}
        //return compressionMethod;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.811 -0400", hash_original_method = "6C1FB28F6F59303D04A80E546963567A", hash_generated_method = "73CCFC2EDC73307314962CDD49FC506E")
    public SSLSessionContext getSessionContext() {
SSLSessionContext var4CDF9BEB60CDBB66FE106B31ECF12ED3_23403212 =         sessionContext;
        var4CDF9BEB60CDBB66FE106B31ECF12ED3_23403212.addTaint(taint);
        return var4CDF9BEB60CDBB66FE106B31ECF12ED3_23403212;
        // ---------- Original Method ----------
        //return sessionContext;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.812 -0400", hash_original_method = "8D23F85B43098BFBC0CC2E7E59C1A10A", hash_generated_method = "DF5EBED4F1A9008BC9F912E8FB8CA522")
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
        boolean varCE74825B5A01C99B06AF231DE0BD667D_197999946 = (isValid);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_180418106 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_180418106;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.812 -0400", hash_original_method = "9CCB74C876B98AB8C259B415A5496084", hash_generated_method = "D973F2208FD25A513B4A2BF5A3AECE34")
    public void invalidate() {
        isValid = false;
        sessionContext = null;
        // ---------- Original Method ----------
        //isValid = false;
        //sessionContext = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.813 -0400", hash_original_method = "AC1FF55FABC34CC9974A294171A954DF", hash_generated_method = "6B9982A973F202A290A34EF90764C2ED")
    public Object getValue(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_1191490614 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_1191490614.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_1191490614;
        } //End block
Object var6DAEDF94ADFD5EF7FEDE28F5B58DA162_914394468 =         values.get(name);
        var6DAEDF94ADFD5EF7FEDE28F5B58DA162_914394468.addTaint(taint);
        return var6DAEDF94ADFD5EF7FEDE28F5B58DA162_914394468;
        // ---------- Original Method ----------
        //if (name == null) {
            //throw new IllegalArgumentException("name == null");
        //}
        //return values.get(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.813 -0400", hash_original_method = "94A4765ACA5D7A784EB5749EBA86107C", hash_generated_method = "B34D043EA5BFF5267AB22A11F84B5564")
    public String[] getValueNames() {
String[] var8EC09F25808BADEED53BE05F8E91790F_1122071600 =         values.keySet().toArray(new String[values.size()]);
        var8EC09F25808BADEED53BE05F8E91790F_1122071600.addTaint(taint);
        return var8EC09F25808BADEED53BE05F8E91790F_1122071600;
        // ---------- Original Method ----------
        //return values.keySet().toArray(new String[values.size()]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.813 -0400", hash_original_method = "306FE04DD14403034511108312788846", hash_generated_method = "5B6E285C71B44594FA0E070CC329822A")
    public void putValue(String name, Object value) {
        addTaint(value.getTaint());
        addTaint(name.getTaint());
        if(name == null || value == null)        
        {
            IllegalArgumentException var8B2F8D7AAF6CA4AD931494119DFBFE29_512927222 = new IllegalArgumentException("name == null || value == null");
            var8B2F8D7AAF6CA4AD931494119DFBFE29_512927222.addTaint(taint);
            throw var8B2F8D7AAF6CA4AD931494119DFBFE29_512927222;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.814 -0400", hash_original_method = "EC2DC464BD3BB987F4ACA997202AA983", hash_generated_method = "92D251808FE4A941A80EDF0D446FDED3")
    public void removeValue(String name) {
        addTaint(name.getTaint());
        if(name == null)        
        {
            IllegalArgumentException var6DECD338B4ADF738B2F3D7F9B2BA118C_895998755 = new IllegalArgumentException("name == null");
            var6DECD338B4ADF738B2F3D7F9B2BA118C_895998755.addTaint(taint);
            throw var6DECD338B4ADF738B2F3D7F9B2BA118C_895998755;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.814 -0400", hash_original_method = "1A939A31B27FEC68DC8C26996575F0FB", hash_generated_method = "A8CE8D6C0FF6144187B973F048710022")
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

