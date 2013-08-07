package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "E0D30CEF5C6139275B58B525001B413C", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private Certificate certificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "6930D78A65216DD055F374AA1923CC3C", hash_generated_field = "B02A8B116523E250A29D85912134C3A9")

    private TBSCertificate tbsCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "8A21BBEE57F4A294A7BA2E3B20E0FC50", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "3274719A36AAD81AD8DC03022627EE07", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "2505866C25309FA6ED2804C37A0EC71E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "77101947D669E45335E7A70CC1FB70A0", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "DFEF16E083EF4F296C0D1C3A16C62167", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "763E5502BE5086F7E15C332CFA5025BC", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.193 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.194 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.194 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "AB53D732FA67C9DBC943E72771D06D50")
    public  X509CertImpl(InputStream in) throws CertificateException {
        try 
        {
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } //End block
        catch (IOException e)
        {
            CertificateException varF4200C6E6F659EC6203F49D9D49E75C2_408625614 = new CertificateException(e);
            varF4200C6E6F659EC6203F49D9D49E75C2_408625614.addTaint(taint);
            throw varF4200C6E6F659EC6203F49D9D49E75C2_408625614;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.195 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "9814F0F29843AE228E9CEBF205CBB9E3")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.196 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "2BACBF722EBA4E0F7AD1F70B03BC8985")
    public  X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.196 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.196 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "2FFF3BB4F0AB44597FC8E6106AA77162")
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        addTaint(date.getTaint());
        checkValidity(date.getTime());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.197 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "A3C99B8F445CBDB15716DEBC1A28E669")
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        addTaint(time);
        if(time < getNotBeforeInternal())        
        {
            CertificateNotYetValidException varF263732D8327E6CAAFD1949906C4732F_578200337 = new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            varF263732D8327E6CAAFD1949906C4732F_578200337.addTaint(taint);
            throw varF263732D8327E6CAAFD1949906C4732F_578200337;
        } //End block
        if(time > getNotAfterInternal())        
        {
            CertificateExpiredException var20E232D428D047D9D73921D881A4016F_222019697 = new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
            var20E232D428D047D9D73921D881A4016F_222019697.addTaint(taint);
            throw var20E232D428D047D9D73921D881A4016F_222019697;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.197 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "37B0DE60C4AF8F20AFACBBD15C5CCAC4")
    public int getVersion() {
        int var82D9B87543E818257630C637DD23BADE_1763653887 = (tbsCert.getVersion() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607961978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1607961978;
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.198 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "C42C22B69EF652261B88A58D810482DB")
    public BigInteger getSerialNumber() {
        BigInteger result = serialNumber;
        if(result == null)        
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } //End block
BigInteger varDC838461EE2FA0CA4C9BBB70A15456B0_2082609251 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2082609251.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2082609251;
        // ---------- Original Method ----------
        //BigInteger result = serialNumber;
        //if (result == null) {
            //serialNumber = result = tbsCert.getSerialNumber();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.198 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "874F526D13137511CA22054A05BC11BE")
    public Principal getIssuerDN() {
Principal var8B119D623D7E352AE065FF4D099457A1_1399940243 =         getIssuerX500Principal();
        var8B119D623D7E352AE065FF4D099457A1_1399940243.addTaint(taint);
        return var8B119D623D7E352AE065FF4D099457A1_1399940243;
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.199 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "77B0D069BB0B1A09B338D1E3E7F14ED7")
    public X500Principal getIssuerX500Principal() {
        X500Principal result = issuer;
        if(result == null)        
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } //End block
X500Principal varDC838461EE2FA0CA4C9BBB70A15456B0_41392890 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_41392890.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_41392890;
        // ---------- Original Method ----------
        //X500Principal result = issuer;
        //if (result == null) {
            //issuer = result = tbsCert.getIssuer().getX500Principal();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.199 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "6407FEAABA01BC853692B64E65845BB9")
    public Principal getSubjectDN() {
Principal varD321BCC5B5C85FF5FF4DF05A7C18FCC4_754749578 =         getSubjectX500Principal();
        varD321BCC5B5C85FF5FF4DF05A7C18FCC4_754749578.addTaint(taint);
        return varD321BCC5B5C85FF5FF4DF05A7C18FCC4_754749578;
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.199 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "338DD8241D312A72823980BD9B9838A6")
    public X500Principal getSubjectX500Principal() {
        X500Principal result = subject;
        if(result == null)        
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } //End block
X500Principal varDC838461EE2FA0CA4C9BBB70A15456B0_923478362 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_923478362.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_923478362;
        // ---------- Original Method ----------
        //X500Principal result = subject;
        //if (result == null) {
            //subject = result = tbsCert.getSubject().getX500Principal();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.200 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "02621285F41CAD28FBA92C93DEE890A8")
    public Date getNotBefore() {
Date varFEDE4E5DB357A7A9C6F6942870B50E47_104809517 =         new Date(getNotBeforeInternal());
        varFEDE4E5DB357A7A9C6F6942870B50E47_104809517.addTaint(taint);
        return varFEDE4E5DB357A7A9C6F6942870B50E47_104809517;
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.200 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "64C8E38933FB2400AF9A72F624977EB7")
    private long getNotBeforeInternal() {
        long result = notBefore;
        if(result == -1)        
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_1599466533 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1729924164 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1729924164;
        // ---------- Original Method ----------
        //long result = notBefore;
        //if (result == -1) {
            //notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.200 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "9E2F6891E3E27CD96833187C8B8C04B6")
    public Date getNotAfter() {
Date varF07AE8371BA4C7483475EB71A659D6AA_1418722844 =         new Date(getNotAfterInternal());
        varF07AE8371BA4C7483475EB71A659D6AA_1418722844.addTaint(taint);
        return varF07AE8371BA4C7483475EB71A659D6AA_1418722844;
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.201 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "4AD89B41AD5FACAC95DC88CA6E982F79")
    private long getNotAfterInternal() {
        long result = notAfter;
        if(result == -1)        
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } //End block
        long varB4A88417B3D0170D754C647C30B7216A_927493429 = (result);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1968714937 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1968714937;
        // ---------- Original Method ----------
        //long result = notAfter;
        //if (result == -1) {
            //notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.201 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "A2390783B3CBBBEFF5AF2D5A619F5506")
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] var999C0F0C19DBB2AA13CF470395B1301B_609419874 = (getTbsCertificateInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1268748792 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1268748792;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.201 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "14110BF06D4C93EEFD7BADFDC69FC13C")
    private byte[] getTbsCertificateInternal() {
        byte[] result = tbsCertificate;
        if(result == null)        
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_144671387 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2009573172 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2009573172;
        // ---------- Original Method ----------
        //byte[] result = tbsCertificate;
        //if (result == null) {
            //tbsCertificate = result = tbsCert.getEncoded();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.202 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "4C06AC4FB177A357E84C1A443D5AF880")
    public byte[] getSignature() {
        byte[] var877124AB260DABB4E0930C59695E3A36_382522524 = (getSignatureInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1213175703 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1213175703;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.202 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "16C1AF63AD5996AA94A659CD7AB75DFC")
    private byte[] getSignatureInternal() {
        byte[] result = signature;
        if(result == null)        
        {
            signature = result = certificate.getSignatureValue();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_1922441422 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2063530482 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2063530482;
        // ---------- Original Method ----------
        //byte[] result = signature;
        //if (result == null) {
            //signature = result = certificate.getSignatureValue();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.203 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "D9F24149A5A3536181DE4D968CD1A782")
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
String varDC838461EE2FA0CA4C9BBB70A15456B0_1444378423 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1444378423.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1444378423;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.203 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "BF3C30CB501421D8E1901A88DC358490")
    public String getSigAlgOID() {
        String result = sigAlgOID;
        if(result == null)        
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } //End block
String varDC838461EE2FA0CA4C9BBB70A15456B0_1962783440 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_1962783440.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_1962783440;
        // ---------- Original Method ----------
        //String result = sigAlgOID;
        //if (result == null) {
            //sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.204 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "8D31606CF26504BA4EDA579928CFEF08")
    public byte[] getSigAlgParams() {
        if(nullSigAlgParams)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_313762381 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_428611131 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_428611131;
        } //End block
        byte[] result = sigAlgParams;
        if(result == null)        
        {
            result = tbsCert.getSignature().getParameters();
            if(result == null)            
            {
                nullSigAlgParams = true;
                byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1868259270 = (null);
                                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2018633146 = {getTaintByte()};
                return var2F9C81BC6E497382285CD6B7A7E33DE1_2018633146;
            } //End block
            sigAlgParams = result;
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_1537426068 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1923099865 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1923099865;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.204 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "7887132B654E13DA4DF0F3EB86A64B76")
    public boolean[] getIssuerUniqueID() {
        boolean[] var490EB4602856F1ADB23E8FB86CA2759C_1868827864 = (tbsCert.getIssuerUniqueID());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_73586097 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_73586097;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.204 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "7CADA77DC3FC1A3EB48C91184D6F76B8")
    public boolean[] getSubjectUniqueID() {
        boolean[] var5A8D1516130F1918A25071AAD0A1C43E_512632049 = (tbsCert.getSubjectUniqueID());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_1041775038 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1041775038;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.205 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "225666D1611B531128683903666048D6")
    public boolean[] getKeyUsage() {
        if(extensions == null)        
        {
            boolean[] var37A6259CC0C1DAE299A7866489DFF0BD_561385496 = (null);
                        boolean[] var503EB2F420079C4024483971CE5EDEA8_2121600479 = {getTaintBoolean()};
            return var503EB2F420079C4024483971CE5EDEA8_2121600479;
        } //End block
        boolean[] varCCD33CA120B908F5DBDEF96CBBD90320_783940153 = (extensions.valueOfKeyUsage());
                boolean[] var503EB2F420079C4024483971CE5EDEA8_151636136 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_151636136;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.205 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "12B4ABC18B77679A704ABE4C7A8C2DA7")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        if(extensions == null)        
        {
List<String> var540C13E9E156B687226421B24F2DF178_1601640796 =             null;
            var540C13E9E156B687226421B24F2DF178_1601640796.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1601640796;
        } //End block
        try 
        {
List<String> varFA88FF5E99F6DBF23FD7A34F12A065CB_1723124229 =             extensions.valueOfExtendedKeyUsage();
            varFA88FF5E99F6DBF23FD7A34F12A065CB_1723124229.addTaint(taint);
            return varFA88FF5E99F6DBF23FD7A34F12A065CB_1723124229;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_1011830632 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_1011830632.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_1011830632;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.205 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "49C99D742A70E60C52B1FA5D16BDADE2")
    public int getBasicConstraints() {
        if(extensions == null)        
        {
            int varE7A95D949116A2DA0F0FA83DC6E76C00_1854715837 = (Integer.MAX_VALUE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663386284 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_663386284;
        } //End block
        int var70F3ED8E09420F45BD7EF789728BECBD_554042891 = (extensions.valueOfBasicConstrains());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301956056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_301956056;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.206 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "12B0A43844B9D1C56090BCD2DDA0BDE5")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        if(extensions == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_430795167 =             null;
            var540C13E9E156B687226421B24F2DF178_430795167.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_430795167;
        } //End block
        try 
        {
Collection<List<?>> var8C1FA57374866A5B3FA43B13055167B5_703334858 =             extensions.valueOfSubjectAlternativeName();
            var8C1FA57374866A5B3FA43B13055167B5_703334858.addTaint(taint);
            return var8C1FA57374866A5B3FA43B13055167B5_703334858;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_79436057 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_79436057.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_79436057;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.206 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "217F1EB7B727C5FB28208C8C9C42A262")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        if(extensions == null)        
        {
Collection<List<?>> var540C13E9E156B687226421B24F2DF178_2080113961 =             null;
            var540C13E9E156B687226421B24F2DF178_2080113961.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2080113961;
        } //End block
        try 
        {
Collection<List<?>> varFDB4369B42BB66019B0D43D7D2AC0A9E_445582906 =             extensions.valueOfIssuerAlternativeName();
            varFDB4369B42BB66019B0D43D7D2AC0A9E_445582906.addTaint(taint);
            return varFDB4369B42BB66019B0D43D7D2AC0A9E_445582906;
        } //End block
        catch (IOException e)
        {
            CertificateParsingException var5C936E301C70562A208B4C24D7CAFEB7_1060031938 = new CertificateParsingException(e);
            var5C936E301C70562A208B4C24D7CAFEB7_1060031938.addTaint(taint);
            throw var5C936E301C70562A208B4C24D7CAFEB7_1060031938;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.207 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "0A97EE5B625DF00653A285B504CE3DA8")
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varC6572253373696AD3CCC03FD35D18BD7_527809085 = (getEncodedInternal().clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_305541910 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_305541910;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.208 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "A3777E780A85DA0939016F75B88FB872")
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result = encoding;
        if(encoding == null)        
        {
            encoding = result = certificate.getEncoded();
        } //End block
        byte[] varB4A88417B3D0170D754C647C30B7216A_58261152 = (result);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_496669178 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_496669178;
        // ---------- Original Method ----------
        //byte[] result = encoding;
        //if (encoding == null) {
            //encoding = result = certificate.getEncoded();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.208 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "71F344DF1BAA218555042376FD129374")
    @Override
    public PublicKey getPublicKey() {
        PublicKey result = publicKey;
        if(result == null)        
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } //End block
PublicKey varDC838461EE2FA0CA4C9BBB70A15456B0_2026319339 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2026319339.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2026319339;
        // ---------- Original Method ----------
        //PublicKey result = publicKey;
        //if (result == null) {
            //publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        //}
        //return result;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.208 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "AE98A7D41D8525340A21908B247FFC8E")
    @Override
    public String toString() {
String var4DAAEB14EC5D64F86AE3E76141F1DCFF_1819414202 =         certificate.toString();
        var4DAAEB14EC5D64F86AE3E76141F1DCFF_1819414202.addTaint(taint);
        return var4DAAEB14EC5D64F86AE3E76141F1DCFF_1819414202;
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.209 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "2834B9266D3B64819BFD567621EE5922")
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
            SignatureException var9B02340D961020151ABEAC18F884DE24_2107675460 = new SignatureException("Signature was not verified");
            var9B02340D961020151ABEAC18F884DE24_2107675460.addTaint(taint);
            throw var9B02340D961020151ABEAC18F884DE24_2107675460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.210 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "EDEB7B819009E99E91251F72154B96DB")
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
            SignatureException var9B02340D961020151ABEAC18F884DE24_295931112 = new SignatureException("Signature was not verified");
            var9B02340D961020151ABEAC18F884DE24_295931112.addTaint(taint);
            throw var9B02340D961020151ABEAC18F884DE24_295931112;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.210 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "C14524C30B52C0C2EC8793F6405FD440")
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        if(extensions == null)        
        {
Set<String> var540C13E9E156B687226421B24F2DF178_1394254061 =             null;
            var540C13E9E156B687226421B24F2DF178_1394254061.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1394254061;
        } //End block
Set<String> var527809B743FC0C579F26D2991C397701_65759261 =         extensions.getNonCriticalExtensions();
        var527809B743FC0C579F26D2991C397701_65759261.addTaint(taint);
        return var527809B743FC0C579F26D2991C397701_65759261;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.211 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "D7E8DC2A2F094DEA68D9CD0596FA6FF3")
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        if(extensions == null)        
        {
Set<String> var540C13E9E156B687226421B24F2DF178_887869293 =             null;
            var540C13E9E156B687226421B24F2DF178_887869293.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_887869293;
        } //End block
Set<String> var532EB99679368325F37510E1C45E8683_849460448 =         extensions.getCriticalExtensions();
        var532EB99679368325F37510E1C45E8683_849460448.addTaint(taint);
        return var532EB99679368325F37510E1C45E8683_849460448;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.211 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "75596BAC663344588BB4BBE6B471FAE4")
    @Override
    public byte[] getExtensionValue(String oid) {
        addTaint(oid.getTaint());
        if(extensions == null)        
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_427534062 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1902840210 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1902840210;
        } //End block
        Extension ext = extensions.getExtensionByOID(oid);
        byte[] var11C3B9F43B1E3C971181A535BF942F7B_1537169971 = ((ext == null) ? null : ext.getRawExtnValue());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_294141999 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_294141999;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //Extension ext = extensions.getExtensionByOID(oid);
        //return (ext == null) ? null : ext.getRawExtnValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.212 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "888071467FD83A269932876407F28353")
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        if(extensions == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_402038259 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1332700388 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1332700388;
        } //End block
        boolean varB78848EBEF95AE2C31DA441F4E096231_1319198068 = (extensions.hasUnsupportedCritical());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1820550761 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1820550761;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.212 -0400", hash_original_field = "602DDB6C69ED63A58D6995673928AE6B", hash_generated_field = "AE4BC6F1CB9BA34159A076A49F034253")

    private static final long serialVersionUID = 2972248729446736154L;
}

