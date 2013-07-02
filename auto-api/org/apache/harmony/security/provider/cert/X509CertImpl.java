package org.apache.harmony.security.provider.cert;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.utils.AlgNameMapper;
import org.apache.harmony.security.x509.Certificate;
import org.apache.harmony.security.x509.Extension;
import org.apache.harmony.security.x509.Extensions;
import org.apache.harmony.security.x509.TBSCertificate;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSignature;

public final class X509CertImpl extends X509Certificate {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "E0D30CEF5C6139275B58B525001B413C", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private Certificate certificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "6930D78A65216DD055F374AA1923CC3C", hash_generated_field = "B02A8B116523E250A29D85912134C3A9")

    private TBSCertificate tbsCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "8A21BBEE57F4A294A7BA2E3B20E0FC50", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "3274719A36AAD81AD8DC03022627EE07", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "2505866C25309FA6ED2804C37A0EC71E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "77101947D669E45335E7A70CC1FB70A0", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "DFEF16E083EF4F296C0D1C3A16C62167", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "763E5502BE5086F7E15C332CFA5025BC", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.132 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.133 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "D4AF792DA11D9B72DE62F4915E92129E")
    public  X509CertImpl(InputStream in) throws CertificateException {
        try 
        {
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateException(e);
        } 
        
        
            
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.133 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "9814F0F29843AE228E9CEBF205CBB9E3")
    public  X509CertImpl(Certificate certificate) {
        this.certificate = certificate;
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.133 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "2BACBF722EBA4E0F7AD1F70B03BC8985")
    public  X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        addTaint(encoding[0]);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.134 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.134 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "03D9C5BB9AA1AA961221C2C7DCD177AB")
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(date.getTime());
        addTaint(date.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.134 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "E59A2558C9CF0504C7F994BA17C8B4D7")
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var264F16FDDA2F76F2C6FA01CF75941728_667417570 = (time < getNotBeforeInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            } 
        } 
        {
            boolean var2AB2BCD0EA9D992C8DA2E852EA2D3B2C_632505713 = (time > getNotAfterInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
            } 
        } 
        addTaint(time);
        
        
            
                
        
        
            
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.134 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "73DB5C66A36631556AAE964D04112F5B")
    public int getVersion() {
        int var14209A0688FE80EBFD09C9716EC0F554_1638963037 = (tbsCert.getVersion() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593760771 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_593760771;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.135 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "67A2B112AFB503AF1E0978EF99E2FF3C")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1270707336 = null; 
        BigInteger result = serialNumber;
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1270707336 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1270707336.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1270707336;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.136 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "256481AA0B9EECEA5436035489672CB2")
    public Principal getIssuerDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_299016407 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_299016407 = getIssuerX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_299016407.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_299016407;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.137 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "5937C10A694EC23207151CCFE0FBBAAB")
    public X500Principal getIssuerX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_788644944 = null; 
        X500Principal result = issuer;
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_788644944 = result;
        varB4EAC82CA7396A68D541C85D26508E83_788644944.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_788644944;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.138 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "516FCF36633DAD7FB4357C0FCEBDAF93")
    public Principal getSubjectDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_561656043 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_561656043 = getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_561656043.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_561656043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.138 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "247BD4316CD83A475FF3B5EC70C3660A")
    public X500Principal getSubjectX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_602235057 = null; 
        X500Principal result = subject;
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_602235057 = result;
        varB4EAC82CA7396A68D541C85D26508E83_602235057.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_602235057;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.139 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "CA431A8A84718FDD47DA1A79AB755F28")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1244990222 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1244990222 = new Date(getNotBeforeInternal());
        varB4EAC82CA7396A68D541C85D26508E83_1244990222.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1244990222;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.139 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "32D36CB932540BDFACC4F30BCAD1A4F5")
    private long getNotBeforeInternal() {
        long result = notBefore;
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_972305932 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_972305932;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.139 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "60A1281BA4D497055F4F146640F41377")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1668099203 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1668099203 = new Date(getNotAfterInternal());
        varB4EAC82CA7396A68D541C85D26508E83_1668099203.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1668099203;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.140 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "DAFC34E0C4894E9C6613BFDD03CA22D0")
    private long getNotAfterInternal() {
        long result = notAfter;
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } 
        long var0F5264038205EDFB1AC05FBB0E8C5E94_492116584 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_492116584;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.140 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "B0A64B52C9B02C70D45D750F3F338C04")
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] varD121FFCD90E6ADE6A3D68F986168F753_1010875036 = (getTbsCertificateInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_69612320 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_69612320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.140 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "A5A43A284129ABC3048F53C3DC10705D")
    private byte[] getTbsCertificateInternal() {
        byte[] result = tbsCertificate;
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1709361584 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1709361584;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.140 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "E085DA36163987FA4CC6AB48649A0A8C")
    public byte[] getSignature() {
        byte[] var8660F4CDC20C0DBFB019B538EFEA4A71_1462352521 = (getSignatureInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1345304758 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1345304758;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.141 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "2B1A0F656B436CD989E05606F7CB0351")
    private byte[] getSignatureInternal() {
        byte[] result = signature;
        {
            signature = result = certificate.getSignatureValue();
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1910178802 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1910178802;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.141 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "F631F3E18500B30583C38D3C30DC9BFA")
    public String getSigAlgName() {
        String varB4EAC82CA7396A68D541C85D26508E83_131168008 = null; 
        String result = sigAlgName;
        {
            String sigAlgOIDLocal = getSigAlgOID();
            result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            {
                result = sigAlgOIDLocal;
            } 
            sigAlgName = result;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_131168008 = result;
        varB4EAC82CA7396A68D541C85D26508E83_131168008.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_131168008;
        
        
        
            
            
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.142 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "99B2F04E907C9EDB8EDFFEA44993E1C3")
    public String getSigAlgOID() {
        String varB4EAC82CA7396A68D541C85D26508E83_518203460 = null; 
        String result = sigAlgOID;
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_518203460 = result;
        varB4EAC82CA7396A68D541C85D26508E83_518203460.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_518203460;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.142 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "1DE83A8B6207306606731F9FEDF51413")
    public byte[] getSigAlgParams() {
        byte[] result = sigAlgParams;
        {
            result = tbsCert.getSignature().getParameters();
            {
                nullSigAlgParams = true;
            } 
            sigAlgParams = result;
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1897461230 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1897461230;
        
        
            
        
        
        
            
            
                
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.143 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "C62C2200DF3CDC5579C306AE28B714F8")
    public boolean[] getIssuerUniqueID() {
        boolean[] var6AE913DACA7724A438FA1168F4195172_904498918 = (tbsCert.getIssuerUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1587428741 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1587428741;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.143 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "C868A5FF522BCB1FC30595D3A9B9A9B7")
    public boolean[] getSubjectUniqueID() {
        boolean[] var10A92D91FC90601725707F1A69995DFF_196312154 = (tbsCert.getSubjectUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_952497782 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_952497782;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.143 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "E774C05A7AD3CF0286AC42F941FD3D77")
    public boolean[] getKeyUsage() {
        boolean[] varAAEE1DF4A5AC8C062F13E76F8BCBB670_2047677737 = (extensions.valueOfKeyUsage());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1061037619 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1061037619;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.144 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "7170D251BAC6722DD22F60133ECE8D5D")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1005635457 = null; 
        List<String> varB4EAC82CA7396A68D541C85D26508E83_483610742 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1005635457 = null;
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_483610742 = extensions.valueOfExtendedKeyUsage();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } 
        List<String> varA7E53CE21691AB073D9660D615818899_512260360; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_512260360 = varB4EAC82CA7396A68D541C85D26508E83_1005635457;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_512260360 = varB4EAC82CA7396A68D541C85D26508E83_483610742;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_512260360.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_512260360;
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.144 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "50E79B13241D38187C636EC302B5D476")
    public int getBasicConstraints() {
        int var2A969C3C9701091D2359FBAB1716E253_1976794483 = (extensions.valueOfBasicConstrains());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103092603 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1103092603;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.145 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "B8CB037516A03B5FA9295C8E3C7648D5")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1481226042 = null; 
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1752805032 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1481226042 = null;
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1752805032 = extensions.valueOfSubjectAlternativeName();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } 
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_1070675589; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1070675589 = varB4EAC82CA7396A68D541C85D26508E83_1481226042;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1070675589 = varB4EAC82CA7396A68D541C85D26508E83_1752805032;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1070675589.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1070675589;
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.146 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "8B68B89E6D73A5492DF944B8DDE9124D")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_906230396 = null; 
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1105347809 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_906230396 = null;
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1105347809 = extensions.valueOfIssuerAlternativeName();
        } 
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } 
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_1200800701; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1200800701 = varB4EAC82CA7396A68D541C85D26508E83_906230396;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1200800701 = varB4EAC82CA7396A68D541C85D26508E83_1105347809;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1200800701.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1200800701;
        
        
            
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.147 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "7B77DB043266671D1B4B2C379FFFE6CA")
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varA1F6A04F214F5803CFE149F45ABBF243_2086638307 = (getEncodedInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1043312189 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1043312189;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.148 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "DEE9D041F85C86C641E431B799B6999A")
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result = encoding;
        {
            encoding = result = certificate.getEncoded();
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_315734337 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_315734337;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.149 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "5E4402C95BCEEFF1D9F0EBB265B01C81")
    @Override
    public PublicKey getPublicKey() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_941842007 = null; 
        PublicKey result = publicKey;
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_941842007 = result;
        varB4EAC82CA7396A68D541C85D26508E83_941842007.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_941842007;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.150 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "D4FE9F48A1693C12EE5ED40575D38667")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_881365815 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_881365815 = certificate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_881365815.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_881365815;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.150 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "7C12A085F8EE0F1E7E31C934D3A9BD07")
    @Override
    public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        Signature signature;
        try 
        {
            signature = OpenSSLSignature.getInstance(getSigAlgName());
        } 
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName());
        } 
        signature.initVerify(key);
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_199198958 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
            } 
        } 
        addTaint(key.getTaint());
        
        
        
            
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.151 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "4E31B29DD6A0227F19ACB459C647D141")
    @Override
    public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        Signature signature;
        try 
        {
            {
                signature = OpenSSLSignature.getInstance(getSigAlgName());
            } 
            {
                signature = Signature.getInstance(getSigAlgName(), sigProvider);
            } 
        } 
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName(), sigProvider);
        } 
        signature.initVerify(key);
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_1948120011 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
            } 
        } 
        addTaint(key.getTaint());
        
        
        
            
                
            
                
            
        
            
        
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.152 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "D23543C1B02702FD4B18D9F1E1AC7885")
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1523309785 = null; 
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_733304171 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1523309785 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_733304171 = extensions.getNonCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_505263444; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_505263444 = varB4EAC82CA7396A68D541C85D26508E83_1523309785;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_505263444 = varB4EAC82CA7396A68D541C85D26508E83_733304171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_505263444.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_505263444;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.152 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "59B98F89950E56E3A6841E8F2DD07A88")
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_691629295 = null; 
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_604748238 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_691629295 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_604748238 = extensions.getCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_2080907281; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2080907281 = varB4EAC82CA7396A68D541C85D26508E83_691629295;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2080907281 = varB4EAC82CA7396A68D541C85D26508E83_604748238;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2080907281.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2080907281;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.153 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "C5C5C8F102EDA72DC555294B038E1595")
    @Override
    public byte[] getExtensionValue(String oid) {
        Extension ext = extensions.getExtensionByOID(oid);
        {
            Object var9B2014C61FD04B9534F5C111F996892E_440603735 = (ext.getRawExtnValue());
        } 
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_733515395 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_733515395;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.153 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "DC1DBCAB05C3321CFD6F15AE9723261E")
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        boolean varCD0035D29141121A191F8784F441BF54_948691306 = (extensions.hasUnsupportedCritical());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_458934535 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_458934535;
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:34.153 -0400", hash_original_field = "602DDB6C69ED63A58D6995673928AE6B", hash_generated_field = "AE4BC6F1CB9BA34159A076A49F034253")

    private static final long serialVersionUID = 2972248729446736154L;
}

