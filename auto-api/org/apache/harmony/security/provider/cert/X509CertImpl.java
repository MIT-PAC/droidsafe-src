package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "E0D30CEF5C6139275B58B525001B413C", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private Certificate certificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "6930D78A65216DD055F374AA1923CC3C", hash_generated_field = "B02A8B116523E250A29D85912134C3A9")

    private TBSCertificate tbsCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "8A21BBEE57F4A294A7BA2E3B20E0FC50", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "3274719A36AAD81AD8DC03022627EE07", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "2505866C25309FA6ED2804C37A0EC71E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "77101947D669E45335E7A70CC1FB70A0", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "DFEF16E083EF4F296C0D1C3A16C62167", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "763E5502BE5086F7E15C332CFA5025BC", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.077 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.078 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "D4AF792DA11D9B72DE62F4915E92129E")
    public  X509CertImpl(InputStream in) throws CertificateException {
        try 
        {
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateException(e);
        } //End block
        // ---------- Original Method ----------
        //try {
            //this.certificate = (Certificate) Certificate.ASN1.decode(in);
            //this.tbsCert = certificate.getTbsCertificate();
            //this.extensions = tbsCert.getExtensions();
        //} catch (IOException e) {
            //throw new CertificateException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.079 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "9814F0F29843AE228E9CEBF205CBB9E3")
    public  X509CertImpl(Certificate certificate) {
        this.certificate = certificate;
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
        // ---------- Original Method ----------
        //this.certificate = certificate;
        //this.tbsCert = certificate.getTbsCertificate();
        //this.extensions = tbsCert.getExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.084 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "2BACBF722EBA4E0F7AD1F70B03BC8985")
    public  X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.084 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.084 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "03D9C5BB9AA1AA961221C2C7DCD177AB")
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(date.getTime());
        addTaint(date.getTaint());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.084 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "B42524F1B09252121BF9109952D3B330")
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var264F16FDDA2F76F2C6FA01CF75941728_1323109852 = (time < getNotBeforeInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AB2BCD0EA9D992C8DA2E852EA2D3B2C_365531293 = (time > getNotAfterInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
            } //End block
        } //End collapsed parenthetic
        addTaint(time);
        // ---------- Original Method ----------
        //if (time < getNotBeforeInternal()) {
            //throw new CertificateNotYetValidException("current time: " + new Date(time)
                //+ ", validation time: " + new Date(getNotBeforeInternal()));
        //}
        //if (time > getNotAfterInternal()) {
            //throw new CertificateExpiredException("current time: " + new Date(time)
                //+ ", expiration time: " + new Date(getNotAfterInternal()));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.085 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "5BF61F06054A0761C2DC8BC8FE75B400")
    public int getVersion() {
        int var14209A0688FE80EBFD09C9716EC0F554_338203330 = (tbsCert.getVersion() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350529472 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350529472;
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.085 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "76B4AEC054A8E0E1F600B92009BEACE2")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1710819298 = null; //Variable for return #1
        BigInteger result;
        result = serialNumber;
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1710819298 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1710819298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1710819298;
        // ---------- Original Method ----------
        //BigInteger result = serialNumber;
        //if (result == null) {
            //serialNumber = result = tbsCert.getSerialNumber();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.091 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "DE0489C0CBB2D7621539BAC7BBCF7888")
    public Principal getIssuerDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_1834889467 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1834889467 = getIssuerX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_1834889467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1834889467;
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.103 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "E4DC14A8BA0AD1312021B1A9E855A8AA")
    public X500Principal getIssuerX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1436327478 = null; //Variable for return #1
        X500Principal result;
        result = issuer;
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1436327478 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1436327478.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1436327478;
        // ---------- Original Method ----------
        //X500Principal result = issuer;
        //if (result == null) {
            //issuer = result = tbsCert.getIssuer().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.104 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "DFB8069617A3476BB36044E5D5416A5F")
    public Principal getSubjectDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_734916467 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_734916467 = getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_734916467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_734916467;
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.107 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "546F3EB3F3490DDFDA62CDB697E9E7AA")
    public X500Principal getSubjectX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1895567483 = null; //Variable for return #1
        X500Principal result;
        result = subject;
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1895567483 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1895567483.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1895567483;
        // ---------- Original Method ----------
        //X500Principal result = subject;
        //if (result == null) {
            //subject = result = tbsCert.getSubject().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.108 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "C3BDEA7A50A8E1C71F72661AA3E92E27")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_880658014 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_880658014 = new Date(getNotBeforeInternal());
        varB4EAC82CA7396A68D541C85D26508E83_880658014.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_880658014;
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.108 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "B89828F1644AA8F36EB32D5740615DF2")
    private long getNotBeforeInternal() {
        long result;
        result = notBefore;
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1026995287 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1026995287;
        // ---------- Original Method ----------
        //long result = notBefore;
        //if (result == -1) {
            //notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.154 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "2AEBBAB602A096E0EB1608AB7676DAA2")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1866066126 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1866066126 = new Date(getNotAfterInternal());
        varB4EAC82CA7396A68D541C85D26508E83_1866066126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1866066126;
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.155 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "6D632A4AEA2F40683FD66F7E46347B55")
    private long getNotAfterInternal() {
        long result;
        result = notAfter;
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1410524671 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1410524671;
        // ---------- Original Method ----------
        //long result = notAfter;
        //if (result == -1) {
            //notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.156 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "46BA5CABACE02CCAE3AEF665EB43FF79")
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] varD121FFCD90E6ADE6A3D68F986168F753_155024815 = (getTbsCertificateInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_544494446 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_544494446;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.157 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "85BBD495B18B42CDD4EB45E22275B1AC")
    private byte[] getTbsCertificateInternal() {
        byte[] result;
        result = tbsCertificate;
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_705783979 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_705783979;
        // ---------- Original Method ----------
        //byte[] result = tbsCertificate;
        //if (result == null) {
            //tbsCertificate = result = tbsCert.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.157 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "3621D994D7B5ECCF4255E23B66DD7FD7")
    public byte[] getSignature() {
        byte[] var8660F4CDC20C0DBFB019B538EFEA4A71_762737596 = (getSignatureInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1314422703 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1314422703;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.157 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "74F8D0F6753835F34245EE64EAA33A31")
    private byte[] getSignatureInternal() {
        byte[] result;
        result = signature;
        {
            signature = result = certificate.getSignatureValue();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1450938345 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1450938345;
        // ---------- Original Method ----------
        //byte[] result = signature;
        //if (result == null) {
            //signature = result = certificate.getSignatureValue();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.168 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "07C9492026A76F2E64B856D27A591E25")
    public String getSigAlgName() {
        String varB4EAC82CA7396A68D541C85D26508E83_658077419 = null; //Variable for return #1
        String result;
        result = sigAlgName;
        {
            String sigAlgOIDLocal;
            sigAlgOIDLocal = getSigAlgOID();
            result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            {
                result = sigAlgOIDLocal;
            } //End block
            sigAlgName = result;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_658077419 = result;
        varB4EAC82CA7396A68D541C85D26508E83_658077419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_658077419;
        // ---------- Original Method ----------
        //String result = sigAlgName;
        //if (result == null) {
            //String sigAlgOIDLocal = getSigAlgOID();
            //result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            //if (result == null) {
                //result = sigAlgOIDLocal;
            //}
            //sigAlgName = result;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.169 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "CABE3470AC43C26C4F89734DB5951C7D")
    public String getSigAlgOID() {
        String varB4EAC82CA7396A68D541C85D26508E83_1391921217 = null; //Variable for return #1
        String result;
        result = sigAlgOID;
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1391921217 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1391921217.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391921217;
        // ---------- Original Method ----------
        //String result = sigAlgOID;
        //if (result == null) {
            //sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.170 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "1661109A353238BE04B911A93155A320")
    public byte[] getSigAlgParams() {
        byte[] result;
        result = sigAlgParams;
        {
            result = tbsCert.getSignature().getParameters();
            {
                nullSigAlgParams = true;
            } //End block
            sigAlgParams = result;
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1474476222 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1474476222;
        // ---------- Original Method ----------
        //if (nullSigAlgParams) {
            //return null;
        //}
        //byte[] result = sigAlgParams;
        //if (result == null) {
            //result = tbsCert.getSignature().getParameters();
            //if (result == null) {
                //nullSigAlgParams = true;
                //return null;
            //}
            //sigAlgParams = result;
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.176 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "B8EAC844B4C3C72D75EC3D683B2BAA56")
    public boolean[] getIssuerUniqueID() {
        boolean[] var6AE913DACA7724A438FA1168F4195172_1950115913 = (tbsCert.getIssuerUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1795895422 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1795895422;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.177 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "5CC00ED8B87C5C54DEB907861BC011B6")
    public boolean[] getSubjectUniqueID() {
        boolean[] var10A92D91FC90601725707F1A69995DFF_2079539647 = (tbsCert.getSubjectUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1578125236 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1578125236;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.177 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "217211B6C94BA3D3E3895303F5C8912B")
    public boolean[] getKeyUsage() {
        boolean[] varAAEE1DF4A5AC8C062F13E76F8BCBB670_2144751258 = (extensions.valueOfKeyUsage());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_864227493 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_864227493;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.177 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "00B0E52775F4EA1641C682C7B51AFD32")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1179103946 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_700268399 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1179103946 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_700268399 = extensions.valueOfExtendedKeyUsage();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        List<String> varA7E53CE21691AB073D9660D615818899_222160597; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_222160597 = varB4EAC82CA7396A68D541C85D26508E83_1179103946;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_222160597 = varB4EAC82CA7396A68D541C85D26508E83_700268399;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_222160597.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_222160597;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfExtendedKeyUsage();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.178 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "760D464F47B3DA0046FD60E52DF4B0DB")
    public int getBasicConstraints() {
        int var2A969C3C9701091D2359FBAB1716E253_1907001435 = (extensions.valueOfBasicConstrains());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825884647 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_825884647;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.178 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "33366CC25FE3B6C40A3AFBABB0F9AFB3")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_250282948 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_883498814 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_250282948 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_883498814 = extensions.valueOfSubjectAlternativeName();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_290472036; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_290472036 = varB4EAC82CA7396A68D541C85D26508E83_250282948;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_290472036 = varB4EAC82CA7396A68D541C85D26508E83_883498814;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_290472036.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_290472036;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfSubjectAlternativeName();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.187 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "95FF9BCBC37B29615BD58AF092433E2E")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_911716946 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1495762780 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_911716946 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1495762780 = extensions.valueOfIssuerAlternativeName();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_779494339; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_779494339 = varB4EAC82CA7396A68D541C85D26508E83_911716946;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_779494339 = varB4EAC82CA7396A68D541C85D26508E83_1495762780;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_779494339.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_779494339;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //try {
            //return extensions.valueOfIssuerAlternativeName();
        //} catch (IOException e) {
            //throw new CertificateParsingException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.192 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "B0384A46E62FCA4094E1AA8A78FC220B")
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varA1F6A04F214F5803CFE149F45ABBF243_213359805 = (getEncodedInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1447583122 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1447583122;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.193 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "87D584FB9990C86733E4DC51EC91DB65")
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result;
        result = encoding;
        {
            encoding = result = certificate.getEncoded();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1838663828 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1838663828;
        // ---------- Original Method ----------
        //byte[] result = encoding;
        //if (encoding == null) {
            //encoding = result = certificate.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.194 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "6C10C5CE7163B0EC228D49C88DE53E2F")
    @Override
    public PublicKey getPublicKey() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_426539779 = null; //Variable for return #1
        PublicKey result;
        result = publicKey;
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_426539779 = result;
        varB4EAC82CA7396A68D541C85D26508E83_426539779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_426539779;
        // ---------- Original Method ----------
        //PublicKey result = publicKey;
        //if (result == null) {
            //publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.196 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "54C5568F9E8EABA1BDE8620A6BEB9281")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_129460890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_129460890 = certificate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_129460890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_129460890;
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.197 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "2096264E83A8AE7A44BB859410ABBE15")
    @Override
    public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        Signature signature;
        try 
        {
            signature = OpenSSLSignature.getInstance(getSigAlgName());
        } //End block
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName());
        } //End block
        signature.initVerify(key);
        byte[] tbsCertificateLocal;
        tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_2028204624 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //Signature signature;
        //try {
            //signature = OpenSSLSignature.getInstance(getSigAlgName());
        //} catch (NoSuchAlgorithmException ignored) {
            //signature = Signature.getInstance(getSigAlgName());
        //}
        //signature.initVerify(key);
        //byte[] tbsCertificateLocal = getTbsCertificateInternal();
        //signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        //if (!signature.verify(certificate.getSignatureValue())) {
            //throw new SignatureException("Signature was not verified");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.206 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "C86C07A001B467CFC2328064B048B559")
    @Override
    public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        Signature signature;
        try 
        {
            {
                signature = OpenSSLSignature.getInstance(getSigAlgName());
            } //End block
            {
                signature = Signature.getInstance(getSigAlgName(), sigProvider);
            } //End block
        } //End block
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName(), sigProvider);
        } //End block
        signature.initVerify(key);
        byte[] tbsCertificateLocal;
        tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        {
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_410398480 = (!signature.verify(certificate.getSignatureValue()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SignatureException("Signature was not verified");
            } //End block
        } //End collapsed parenthetic
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //Signature signature;
        //try {
            //if (sigProvider == null) {
                //signature = OpenSSLSignature.getInstance(getSigAlgName());
            //} else {
                //signature = Signature.getInstance(getSigAlgName(), sigProvider);
            //}
        //} catch (NoSuchAlgorithmException ignored) {
            //signature = Signature.getInstance(getSigAlgName(), sigProvider);
        //}
        //signature.initVerify(key);
        //byte[] tbsCertificateLocal = getTbsCertificateInternal();
        //signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        //if (!signature.verify(certificate.getSignatureValue())) {
            //throw new SignatureException("Signature was not verified");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.208 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "4EF3CE5B31E760B35B2A12D0D7BD12CD")
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1435095151 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_262936452 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1435095151 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_262936452 = extensions.getNonCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_1794902545; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1794902545 = varB4EAC82CA7396A68D541C85D26508E83_1435095151;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1794902545 = varB4EAC82CA7396A68D541C85D26508E83_262936452;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1794902545.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1794902545;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.209 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "89DC68DFF19BC88B5E8992A7F87DA6E4")
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_715182657 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1251607166 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_715182657 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1251607166 = extensions.getCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_173723092; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_173723092 = varB4EAC82CA7396A68D541C85D26508E83_715182657;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_173723092 = varB4EAC82CA7396A68D541C85D26508E83_1251607166;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_173723092.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_173723092;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.210 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "B57D54FB3E8A055B4C08F45BBD1AB52D")
    @Override
    public byte[] getExtensionValue(String oid) {
        Extension ext;
        ext = extensions.getExtensionByOID(oid);
        {
            Object var9B2014C61FD04B9534F5C111F996892E_1267979375 = (ext.getRawExtnValue());
        } //End flattened ternary
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1878567481 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1878567481;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //Extension ext = extensions.getExtensionByOID(oid);
        //return (ext == null) ? null : ext.getRawExtnValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.210 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "EF58BB17407382FE7C85FEF4EED1A024")
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        boolean varCD0035D29141121A191F8784F441BF54_1085841682 = (extensions.hasUnsupportedCritical());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_394608574 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_394608574;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:10.214 -0400", hash_original_field = "602DDB6C69ED63A58D6995673928AE6B", hash_generated_field = "950D3EE66DB7FA79771C824D20467B42")

    private static long serialVersionUID = 2972248729446736154L;
}

