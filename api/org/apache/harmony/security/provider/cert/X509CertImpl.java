package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "E0D30CEF5C6139275B58B525001B413C", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private Certificate certificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "6930D78A65216DD055F374AA1923CC3C", hash_generated_field = "B02A8B116523E250A29D85912134C3A9")

    private TBSCertificate tbsCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "8A21BBEE57F4A294A7BA2E3B20E0FC50", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "3274719A36AAD81AD8DC03022627EE07", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.208 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "2505866C25309FA6ED2804C37A0EC71E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "77101947D669E45335E7A70CC1FB70A0", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "DFEF16E083EF4F296C0D1C3A16C62167", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "763E5502BE5086F7E15C332CFA5025BC", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.209 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.210 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "E81DCBE6F3B61B93115D4CC5C01B6A71")
    public  X509CertImpl(InputStream in) throws CertificateException {
        try 
        {
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } //End block
        catch (IOException e)
        {
            CertificateException varF4200C6E6F659EC6203F49D9D49E75C2_1984942509 = new CertificateException(e);
            varF4200C6E6F659EC6203F49D9D49E75C2_1984942509.addTaint(taint);
            throw varF4200C6E6F659EC6203F49D9D49E75C2_1984942509;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.210 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "9814F0F29843AE228E9CEBF205CBB9E3")
    public  X509CertImpl(Certificate certificate) {
        this.certificate = certificate;
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
        // ---------- Original Method ----------
        //this.certificate = certificate;
        //this.tbsCert = certificate.getTbsCertificate();
        //this.extensions = tbsCert.getExtensions();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.211 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "2BACBF722EBA4E0F7AD1F70B03BC8985")
    public  X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.211 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.211 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "2FFF3BB4F0AB44597FC8E6106AA77162")
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        addTaint(date.getTaint());
        checkValidity(date.getTime());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.212 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "C19E75CDB5C0DC7981E929B495F06237")
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        addTaint(time);
    if(time < getNotBeforeInternal())        
        {
            CertificateNotYetValidException varF263732D8327E6CAAFD1949906C4732F_80498364 = new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            varF263732D8327E6CAAFD1949906C4732F_80498364.addTaint(taint);
            throw varF263732D8327E6CAAFD1949906C4732F_80498364;
        } //End block
    if(time > getNotAfterInternal())        
        {
            CertificateExpiredException var20E232D428D047D9D73921D881A4016F_1612495562 = new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
            var20E232D428D047D9D73921D881A4016F_1612495562.addTaint(taint);
            throw var20E232D428D047D9D73921D881A4016F_1612495562;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.212 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "83D62E56336693B0BA05F33371501A04")
    public int getVersion() {
        int var82D9B87543E818257630C637DD23BADE_1005079119 = (tbsCert.getVersion() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392682154 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1392682154;
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.212 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "672E6F490E599B21388D2E8736CCAAF9")
    public BigInteger getSerialNumber() {
        BigInteger result = serialNumber;
    if(result == null)        
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } //End block
BigInteger varDC838461EE2FA0CA4C9BBB70A15456B0_1690371677 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1690371677.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1690371677;
        // ---------- Original Method ----------
        //BigInteger result = serialNumber;
        //if (result == null) {
            //serialNumber = result = tbsCert.getSerialNumber();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.213 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "CF44F0A9542EA29313A57CBBF197E387")
    public Principal getIssuerDN() {
Principal var8B119D623D7E352AE065FF4D099457A1_2050847007 =         getIssuerX500Principal();
        var8B119D623D7E352AE065FF4D099457A1_2050847007.addTaint(taint);
        return var8B119D623D7E352AE065FF4D099457A1_2050847007;
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.213 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "1FDA9706D1326848B364365A301426E2")
    public X500Principal getIssuerX500Principal() {
        X500Principal result = issuer;
    if(result == null)        
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } //End block
X500Principal varDC838461EE2FA0CA4C9BBB70A15456B0_266453847 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_266453847.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_266453847;
        // ---------- Original Method ----------
        //X500Principal result = issuer;
        //if (result == null) {
            //issuer = result = tbsCert.getIssuer().getX500Principal();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.213 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "8CBF3BCC27DA5EA38BEA7907D3FFF0F6")
    public Principal getSubjectDN() {
Principal varD321BCC5B5C85FF5FF4DF05A7C18FCC4_1623141317 =         getSubjectX500Principal();
        varD321BCC5B5C85FF5FF4DF05A7C18FCC4_1623141317.addTaint(taint);
        return varD321BCC5B5C85FF5FF4DF05A7C18FCC4_1623141317;
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.214 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "CA2536C8DA2B2FE200885994FD2D5591")
    public X500Principal getSubjectX500Principal() {
        X500Principal result = subject;
    if(result == null)        
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } //End block
X500Principal varDC838461EE2FA0CA4C9BBB70A15456B0_763678144 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_763678144.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_763678144;
        // ---------- Original Method ----------
        //X500Principal result = subject;
        //if (result == null) {
            //subject = result = tbsCert.getSubject().getX500Principal();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.214 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "492592737CA86D6688A57643B7B2B871")
    public Date getNotBefore() {
Date varFEDE4E5DB357A7A9C6F6942870B50E47_2006755232 =         new Date(getNotBeforeInternal());
        varFEDE4E5DB357A7A9C6F6942870B50E47_2006755232.addTaint(taint);
        return varFEDE4E5DB357A7A9C6F6942870B50E47_2006755232;
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.215 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "25E6F649CC7458F781C85845A207A47B")
    private long getNotBeforeInternal() {
        long result = notBefore;
    if(result == -1)        
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_445210581 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1910519221 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1910519221;
        // ---------- Original Method ----------
        //long result = notBefore;
        //if (result == -1) {
            //notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.215 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "C48650C7A16B09D408B4E27445572797")
    public Date getNotAfter() {
Date varF07AE8371BA4C7483475EB71A659D6AA_116482751 =         new Date(getNotAfterInternal());
        varF07AE8371BA4C7483475EB71A659D6AA_116482751.addTaint(taint);
        return varF07AE8371BA4C7483475EB71A659D6AA_116482751;
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.215 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "55A0D8FE046C3872CA6E64F1F93176D9")
    private long getNotAfterInternal() {
        long result = notAfter;
    if(result == -1)        
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_1178409456 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1705782582 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1705782582;
        // ---------- Original Method ----------
        //long result = notAfter;
        //if (result == -1) {
            //notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.216 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "DC97822B6B6DB44F988DE31E92022CBB")
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] var999C0F0C19DBB2AA13CF470395B1301B_2018308977 = (getTbsCertificateInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2079007954 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2079007954;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.216 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "99A4D8495FF467483C10FAC890211AC0")
    private byte[] getTbsCertificateInternal() {
        byte[] result = tbsCertificate;
    if(result == null)        
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_896424761 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1242724435 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1242724435;
        // ---------- Original Method ----------
        //byte[] result = tbsCertificate;
        //if (result == null) {
            //tbsCertificate = result = tbsCert.getEncoded();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.217 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "9453EDE0356BB79710147249A2C805A7")
    public byte[] getSignature() {
        byte[] var877124AB260DABB4E0930C59695E3A36_444887544 = (getSignatureInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_481556706 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_481556706;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.217 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "A88174D6AABD29EB8B97534288FDE88C")
    private byte[] getSignatureInternal() {
        byte[] result = signature;
    if(result == null)        
        {
            signature = result = certificate.getSignatureValue();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_2097041367 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_129596727 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_129596727;
        // ---------- Original Method ----------
        //byte[] result = signature;
        //if (result == null) {
            //signature = result = certificate.getSignatureValue();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.218 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "3E90955FA8862A7A36DE6347F62661E4")
    public String getSigAlgName() {
        String result = sigAlgName;
    if(result == null)        
        {
            String sigAlgOIDLocal = getSigAlgOID();
            result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
    if(result == null)            
            {
                result = sigAlgOIDLocal;
            } //End block
            sigAlgName = result;
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_2136816829 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2136816829.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2136816829;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.218 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "6092A982F01F7CACD26B6CEC1265F367")
    public String getSigAlgOID() {
        String result = sigAlgOID;
    if(result == null)        
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1590877455 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1590877455.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1590877455;
        // ---------- Original Method ----------
        //String result = sigAlgOID;
        //if (result == null) {
            //sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.219 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "4081014707EF45ABFE443D1093D1496C")
    public byte[] getSigAlgParams() {
    if(nullSigAlgParams)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1899566534 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1775781098 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1775781098;
        } //End block
        byte[] result = sigAlgParams;
    if(result == null)        
        {
            result = tbsCert.getSignature().getParameters();
    if(result == null)            
            {
                nullSigAlgParams = true;
                byte[] var37A6259CC0C1DAE299A7866489DFF0BD_861233466 = (null);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_365261098 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_365261098;
            } //End block
            sigAlgParams = result;
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_347572171 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1329225554 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1329225554;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.220 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "698A1F1D17A67E8ED5A4C8FEC8261653")
    public boolean[] getIssuerUniqueID() {
        boolean[] var490EB4602856F1ADB23E8FB86CA2759C_384172671 = (tbsCert.getIssuerUniqueID());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_425186559 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_425186559;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.220 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "F12F5D3AB02837DEA84B3324A57F9D2D")
    public boolean[] getSubjectUniqueID() {
        boolean[] var5A8D1516130F1918A25071AAD0A1C43E_1767065445 = (tbsCert.getSubjectUniqueID());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_49078596 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_49078596;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.220 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "B1503829E4A3AB62BB817FF53CEB9D82")
    public boolean[] getKeyUsage() {
    if(extensions == null)        
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_45384471 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_19534481 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_19534481;
        } //End block
        boolean[] varCCD33CA120B908F5DBDEF96CBBD90320_929433230 = (extensions.valueOfKeyUsage());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_59471576 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_59471576;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.221 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "C4372333FD24554820339F7618F3B5BF")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
    if(extensions == null)        
        {
List<String> var540C13E9E156B687226421B24F2DF178_442959500 =             null;
            var540C13E9E156B687226421B24F2DF178_442959500.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_442959500;
        } //End block
        try 
        {
List<String> varFA88FF5E99F6DBF23FD7A34F12A065CB_1129690037 =             extensions.valueOfExtendedKeyUsage();
            varFA88FF5E99F6DBF23FD7A34F12A065CB_1129690037.addTaint(taint);
            return varFA88FF5E99F6DBF23FD7A34F12A065CB_1129690037;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_393731679 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_393731679.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_393731679;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.221 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "9DA825145B75AADCE039A9D76A3D8B60")
    public int getBasicConstraints() {
    if(extensions == null)        
        {
            int varE7A95D949116A2DA0F0FA83DC6E76C00_512426162 = (Integer.MAX_VALUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458453020 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1458453020;
        } //End block
        int var70F3ED8E09420F45BD7EF789728BECBD_356412051 = (extensions.valueOfBasicConstrains());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844365468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1844365468;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.222 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "B428CCBBD59BC1F4432C60AE8809C827")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
    if(extensions == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_498398637 =             null;
            var540C13E9E156B687226421B24F2DF178_498398637.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_498398637;
        } //End block
        try 
        {
Collection<List<?>> var8C1FA57374866A5B3FA43B13055167B5_1104573612 =             extensions.valueOfSubjectAlternativeName();
            var8C1FA57374866A5B3FA43B13055167B5_1104573612.addTaint(taint);
            return var8C1FA57374866A5B3FA43B13055167B5_1104573612;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_437119739 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_437119739.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_437119739;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.222 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "51C4172DB07F7EA7DAA93558245D3F0D")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
    if(extensions == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_1634588913 =             null;
            var540C13E9E156B687226421B24F2DF178_1634588913.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1634588913;
        } //End block
        try 
        {
Collection<List<?>> varFDB4369B42BB66019B0D43D7D2AC0A9E_1200285882 =             extensions.valueOfIssuerAlternativeName();
            varFDB4369B42BB66019B0D43D7D2AC0A9E_1200285882.addTaint(taint);
            return varFDB4369B42BB66019B0D43D7D2AC0A9E_1200285882;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_1786143228 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_1786143228.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_1786143228;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.223 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "5F7F12A6CD153CFA6D5EF954F0E74171")
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varC6572253373696AD3CCC03FD35D18BD7_1214870255 = (getEncodedInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1994400059 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1994400059;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.224 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "3531D70B5D7E6AF87617AFF529D0A1CC")
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result = encoding;
    if(encoding == null)        
        {
            encoding = result = certificate.getEncoded();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_2113354397 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_411086107 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_411086107;
        // ---------- Original Method ----------
        //byte[] result = encoding;
        //if (encoding == null) {
            //encoding = result = certificate.getEncoded();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.224 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "7A8CB1A8ACB26FD5DB064DC7DC029B81")
    @Override
    public PublicKey getPublicKey() {
        PublicKey result = publicKey;
    if(result == null)        
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } //End block
PublicKey varDC838461EE2FA0CA4C9BBB70A15456B0_1467087009 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1467087009.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1467087009;
        // ---------- Original Method ----------
        //PublicKey result = publicKey;
        //if (result == null) {
            //publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.225 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "C42CB444705C8C3397D1D27EEDB119CA")
    @Override
    public String toString() {
String var4DAAEB14EC5D64F86AE3E76141F1DCFF_21850569 =         certificate.toString();
        var4DAAEB14EC5D64F86AE3E76141F1DCFF_21850569.addTaint(taint);
        return var4DAAEB14EC5D64F86AE3E76141F1DCFF_21850569;
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.225 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "B1C2CEE367F251B8351D3CFEDFA00A77")
    @Override
    public void verify(PublicKey key) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        addTaint(key.getTaint());
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
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
    if(!signature.verify(certificate.getSignatureValue()))        
        {
            SignatureException var9B02340D961020151ABEAC18F884DE24_115781960 = new SignatureException("Signature was not verified");
            var9B02340D961020151ABEAC18F884DE24_115781960.addTaint(taint);
            throw var9B02340D961020151ABEAC18F884DE24_115781960;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.226 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "19A8A639B7F6FF8CA738E6AC0C2BDDA5")
    @Override
    public void verify(PublicKey key, String sigProvider) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {
        addTaint(key.getTaint());
        Signature signature;
        try 
        {
    if(sigProvider == null)            
            {
                signature = OpenSSLSignature.getInstance(getSigAlgName());
            } //End block
            else
            {
                signature = Signature.getInstance(getSigAlgName(), sigProvider);
            } //End block
        } //End block
        catch (NoSuchAlgorithmException ignored)
        {
            signature = Signature.getInstance(getSigAlgName(), sigProvider);
        } //End block
        signature.initVerify(key);
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
    if(!signature.verify(certificate.getSignatureValue()))        
        {
            SignatureException var9B02340D961020151ABEAC18F884DE24_1843486237 = new SignatureException("Signature was not verified");
            var9B02340D961020151ABEAC18F884DE24_1843486237.addTaint(taint);
            throw var9B02340D961020151ABEAC18F884DE24_1843486237;
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.226 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "C4783E1A184D31EAAFA29F50770BCF32")
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
    if(extensions == null)        
        {
Set<String> var540C13E9E156B687226421B24F2DF178_1481221286 =             null;
            var540C13E9E156B687226421B24F2DF178_1481221286.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1481221286;
        } //End block
Set<String> var527809B743FC0C579F26D2991C397701_227380075 =         extensions.getNonCriticalExtensions();
        var527809B743FC0C579F26D2991C397701_227380075.addTaint(taint);
        return var527809B743FC0C579F26D2991C397701_227380075;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.227 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "B485D011EA852374384415E4561733F3")
    @Override
    public Set<String> getCriticalExtensionOIDs() {
    if(extensions == null)        
        {
Set<String> var540C13E9E156B687226421B24F2DF178_1788883989 =             null;
            var540C13E9E156B687226421B24F2DF178_1788883989.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1788883989;
        } //End block
Set<String> var532EB99679368325F37510E1C45E8683_1826169076 =         extensions.getCriticalExtensions();
        var532EB99679368325F37510E1C45E8683_1826169076.addTaint(taint);
        return var532EB99679368325F37510E1C45E8683_1826169076;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.227 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "B1547ADC0752F0097E50BFD23B999EFC")
    @Override
    public byte[] getExtensionValue(String oid) {
        addTaint(oid.getTaint());
    if(extensions == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_118537393 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_293201855 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_293201855;
        } //End block
        Extension ext = extensions.getExtensionByOID(oid);
        byte[] var11C3B9F43B1E3C971181A535BF942F7B_436991346 = ((ext == null) ? null : ext.getRawExtnValue());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_381559780 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_381559780;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //Extension ext = extensions.getExtensionByOID(oid);
        //return (ext == null) ? null : ext.getRawExtnValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.228 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "7B8F1E77B199B257D4FB88FBFEB0EFFD")
    @Override
    public boolean hasUnsupportedCriticalExtension() {
    if(extensions == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_556389372 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1291406177 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1291406177;
        } //End block
        boolean varB78848EBEF95AE2C31DA441F4E096231_445601680 = (extensions.hasUnsupportedCritical());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080455969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080455969;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:18.228 -0400", hash_original_field = "602DDB6C69ED63A58D6995673928AE6B", hash_generated_field = "AE4BC6F1CB9BA34159A076A49F034253")

    private static final long serialVersionUID = 2972248729446736154L;
}

