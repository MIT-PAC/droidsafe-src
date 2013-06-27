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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "E0D30CEF5C6139275B58B525001B413C", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private Certificate certificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "6930D78A65216DD055F374AA1923CC3C", hash_generated_field = "B02A8B116523E250A29D85912134C3A9")

    private TBSCertificate tbsCert;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "8A21BBEE57F4A294A7BA2E3B20E0FC50", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "3274719A36AAD81AD8DC03022627EE07", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "0929762640B3E7DC003753385C7CF5FB", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "2505866C25309FA6ED2804C37A0EC71E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "77101947D669E45335E7A70CC1FB70A0", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "DFEF16E083EF4F296C0D1C3A16C62167", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "763E5502BE5086F7E15C332CFA5025BC", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "C36853EA059E0D71A67557E5EE54B835", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.096 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.097 -0400", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "D4AF792DA11D9B72DE62F4915E92129E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.110 -0400", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "9814F0F29843AE228E9CEBF205CBB9E3")
    public  X509CertImpl(Certificate certificate) {
        this.certificate = certificate;
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
        // ---------- Original Method ----------
        //this.certificate = certificate;
        //this.tbsCert = certificate.getTbsCertificate();
        //this.extensions = tbsCert.getExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.110 -0400", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "2BACBF722EBA4E0F7AD1F70B03BC8985")
    public  X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
        addTaint(encoding[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.110 -0400", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "2E8592797B80F07DB9D925974C99BF53")
    public void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
        // ---------- Original Method ----------
        //checkValidity(System.currentTimeMillis());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.111 -0400", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "03D9C5BB9AA1AA961221C2C7DCD177AB")
    public void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(date.getTime());
        addTaint(date.getTaint());
        // ---------- Original Method ----------
        //checkValidity(date.getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.111 -0400", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "E472CAC624007646733169521E2E5A95")
    private void checkValidity(long time) throws CertificateExpiredException, CertificateNotYetValidException {
        {
            boolean var264F16FDDA2F76F2C6FA01CF75941728_1187606264 = (time < getNotBeforeInternal());
            {
                if (DroidSafeAndroidRuntime.control) throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
            } //End block
        } //End collapsed parenthetic
        {
            boolean var2AB2BCD0EA9D992C8DA2E852EA2D3B2C_404207676 = (time > getNotAfterInternal());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.115 -0400", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "5DB4F4A29BBEA5BE68408CDB644C8B97")
    public int getVersion() {
        int var14209A0688FE80EBFD09C9716EC0F554_971644987 = (tbsCert.getVersion() + 1);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974592582 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974592582;
        // ---------- Original Method ----------
        //return tbsCert.getVersion() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.119 -0400", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "7C8524C8284431EBDD72A8BD1EBE3BEE")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1487426974 = null; //Variable for return #1
        BigInteger result;
        result = serialNumber;
        {
            serialNumber = result = tbsCert.getSerialNumber();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1487426974 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1487426974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1487426974;
        // ---------- Original Method ----------
        //BigInteger result = serialNumber;
        //if (result == null) {
            //serialNumber = result = tbsCert.getSerialNumber();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.121 -0400", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "1DD6F14A2AF9E8A604B082173F3F4C32")
    public Principal getIssuerDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_573295075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_573295075 = getIssuerX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_573295075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_573295075;
        // ---------- Original Method ----------
        //return getIssuerX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.136 -0400", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "EFDC2349692A0EC9DA8FE19EF84760AD")
    public X500Principal getIssuerX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_632776976 = null; //Variable for return #1
        X500Principal result;
        result = issuer;
        {
            issuer = result = tbsCert.getIssuer().getX500Principal();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_632776976 = result;
        varB4EAC82CA7396A68D541C85D26508E83_632776976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_632776976;
        // ---------- Original Method ----------
        //X500Principal result = issuer;
        //if (result == null) {
            //issuer = result = tbsCert.getIssuer().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.137 -0400", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "B5B20D3C3B17B37E764FB3E0A1A54AE4")
    public Principal getSubjectDN() {
        Principal varB4EAC82CA7396A68D541C85D26508E83_518449300 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_518449300 = getSubjectX500Principal();
        varB4EAC82CA7396A68D541C85D26508E83_518449300.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_518449300;
        // ---------- Original Method ----------
        //return getSubjectX500Principal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.142 -0400", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "A4B6666504B655F4D042328A8594124B")
    public X500Principal getSubjectX500Principal() {
        X500Principal varB4EAC82CA7396A68D541C85D26508E83_1803765929 = null; //Variable for return #1
        X500Principal result;
        result = subject;
        {
            subject = result = tbsCert.getSubject().getX500Principal();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1803765929 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1803765929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803765929;
        // ---------- Original Method ----------
        //X500Principal result = subject;
        //if (result == null) {
            //subject = result = tbsCert.getSubject().getX500Principal();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.143 -0400", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "FF274F202AD14C96DBE153055BA71C89")
    public Date getNotBefore() {
        Date varB4EAC82CA7396A68D541C85D26508E83_819546706 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_819546706 = new Date(getNotBeforeInternal());
        varB4EAC82CA7396A68D541C85D26508E83_819546706.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_819546706;
        // ---------- Original Method ----------
        //return new Date(getNotBeforeInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.146 -0400", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "A26EF454B05C6D9246362AA43DD70779")
    private long getNotBeforeInternal() {
        long result;
        result = notBefore;
        {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_195461306 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_195461306;
        // ---------- Original Method ----------
        //long result = notBefore;
        //if (result == -1) {
            //notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.146 -0400", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "9790E4FFB0D404B786C488E013071C5E")
    public Date getNotAfter() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1821484219 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1821484219 = new Date(getNotAfterInternal());
        varB4EAC82CA7396A68D541C85D26508E83_1821484219.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1821484219;
        // ---------- Original Method ----------
        //return new Date(getNotAfterInternal());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.147 -0400", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "F806CDC8E84E1069EB548125040817C1")
    private long getNotAfterInternal() {
        long result;
        result = notAfter;
        {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        } //End block
        long var0F5264038205EDFB1AC05FBB0E8C5E94_530736177 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_530736177;
        // ---------- Original Method ----------
        //long result = notAfter;
        //if (result == -1) {
            //notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.148 -0400", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "9FC62FFD44E70CEF4377E8322AE45DC7")
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        byte[] varD121FFCD90E6ADE6A3D68F986168F753_1042290595 = (getTbsCertificateInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_267067438 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_267067438;
        // ---------- Original Method ----------
        //return getTbsCertificateInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.148 -0400", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "A71C918412EAE8A711AF8FA8D7B96A8F")
    private byte[] getTbsCertificateInternal() {
        byte[] result;
        result = tbsCertificate;
        {
            tbsCertificate = result = tbsCert.getEncoded();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2035404373 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2035404373;
        // ---------- Original Method ----------
        //byte[] result = tbsCertificate;
        //if (result == null) {
            //tbsCertificate = result = tbsCert.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.148 -0400", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "425C5C36189D6193A63866815758568F")
    public byte[] getSignature() {
        byte[] var8660F4CDC20C0DBFB019B538EFEA4A71_1268195123 = (getSignatureInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1879672666 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1879672666;
        // ---------- Original Method ----------
        //return getSignatureInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.155 -0400", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "E49831DA2BD9AC1AE5E50F6EA395869C")
    private byte[] getSignatureInternal() {
        byte[] result;
        result = signature;
        {
            signature = result = certificate.getSignatureValue();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_774579895 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_774579895;
        // ---------- Original Method ----------
        //byte[] result = signature;
        //if (result == null) {
            //signature = result = certificate.getSignatureValue();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.156 -0400", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "71B16684EC1A452D298F52D455B6A929")
    public String getSigAlgName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1091186307 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1091186307 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1091186307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1091186307;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.157 -0400", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "2BDB425184597CF595C9AC0F726D2B91")
    public String getSigAlgOID() {
        String varB4EAC82CA7396A68D541C85D26508E83_1256054094 = null; //Variable for return #1
        String result;
        result = sigAlgOID;
        {
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1256054094 = result;
        varB4EAC82CA7396A68D541C85D26508E83_1256054094.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1256054094;
        // ---------- Original Method ----------
        //String result = sigAlgOID;
        //if (result == null) {
            //sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.169 -0400", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "6414C9423CE8B49DA947B8983034F68C")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1726286982 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1726286982;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.179 -0400", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "D61767704281BDF74C73454DF75EA4E5")
    public boolean[] getIssuerUniqueID() {
        boolean[] var6AE913DACA7724A438FA1168F4195172_2137024540 = (tbsCert.getIssuerUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_461807275 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_461807275;
        // ---------- Original Method ----------
        //return tbsCert.getIssuerUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.179 -0400", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "F142BD4383262BCACBB7D32F2844BBC4")
    public boolean[] getSubjectUniqueID() {
        boolean[] var10A92D91FC90601725707F1A69995DFF_2075199745 = (tbsCert.getSubjectUniqueID());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_538469727 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_538469727;
        // ---------- Original Method ----------
        //return tbsCert.getSubjectUniqueID();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.179 -0400", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "EBAAE863625888842E0CC1CE0D7B83D7")
    public boolean[] getKeyUsage() {
        boolean[] varAAEE1DF4A5AC8C062F13E76F8BCBB670_745425329 = (extensions.valueOfKeyUsage());
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1887849075 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1887849075;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.valueOfKeyUsage();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.180 -0400", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "57DE5817D7A1CDA013315A8F1A6C150D")
    public List<String> getExtendedKeyUsage() throws CertificateParsingException {
        List<String> varB4EAC82CA7396A68D541C85D26508E83_564667935 = null; //Variable for return #1
        List<String> varB4EAC82CA7396A68D541C85D26508E83_1964703803 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_564667935 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1964703803 = extensions.valueOfExtendedKeyUsage();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        List<String> varA7E53CE21691AB073D9660D615818899_1785181434; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1785181434 = varB4EAC82CA7396A68D541C85D26508E83_564667935;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1785181434 = varB4EAC82CA7396A68D541C85D26508E83_1964703803;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1785181434.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1785181434;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.180 -0400", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "F51776A660A5A9F9FC66FD084652B894")
    public int getBasicConstraints() {
        int var2A969C3C9701091D2359FBAB1716E253_2141179795 = (extensions.valueOfBasicConstrains());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097305518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097305518;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return Integer.MAX_VALUE;
        //}
        //return extensions.valueOfBasicConstrains();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.181 -0400", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "5F905276710A8F052FFBC2BB6DB788DF")
    public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1930566226 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1328939719 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1930566226 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1328939719 = extensions.valueOfSubjectAlternativeName();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_61914499; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_61914499 = varB4EAC82CA7396A68D541C85D26508E83_1930566226;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_61914499 = varB4EAC82CA7396A68D541C85D26508E83_1328939719;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_61914499.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_61914499;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.182 -0400", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "148705B13F41BC85DD1A92F450E680E9")
    public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_338491339 = null; //Variable for return #1
        Collection<List<?>> varB4EAC82CA7396A68D541C85D26508E83_1597052754 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_338491339 = null;
        } //End block
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1597052754 = extensions.valueOfIssuerAlternativeName();
        } //End block
        catch (IOException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new CertificateParsingException(e);
        } //End block
        Collection<List<?>> varA7E53CE21691AB073D9660D615818899_1464651122; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1464651122 = varB4EAC82CA7396A68D541C85D26508E83_338491339;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1464651122 = varB4EAC82CA7396A68D541C85D26508E83_1597052754;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1464651122.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1464651122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.182 -0400", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "98483B9F1E203EBD4BF838835310330A")
    @Override
    public byte[] getEncoded() throws CertificateEncodingException {
        byte[] varA1F6A04F214F5803CFE149F45ABBF243_135473389 = (getEncodedInternal().clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_349646399 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_349646399;
        // ---------- Original Method ----------
        //return getEncodedInternal().clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.182 -0400", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "1278C36C846A849121A449CDBA9BCD19")
    private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result;
        result = encoding;
        {
            encoding = result = certificate.getEncoded();
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_473775495 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_473775495;
        // ---------- Original Method ----------
        //byte[] result = encoding;
        //if (encoding == null) {
            //encoding = result = certificate.getEncoded();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.199 -0400", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "01A3830484B7236284B1BAE30487EEF7")
    @Override
    public PublicKey getPublicKey() {
        PublicKey varB4EAC82CA7396A68D541C85D26508E83_2146818243 = null; //Variable for return #1
        PublicKey result;
        result = publicKey;
        {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2146818243 = result;
        varB4EAC82CA7396A68D541C85D26508E83_2146818243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2146818243;
        // ---------- Original Method ----------
        //PublicKey result = publicKey;
        //if (result == null) {
            //publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.200 -0400", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "8A143214C2A3A597372BC3911EA8AC2E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1729579207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1729579207 = certificate.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1729579207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729579207;
        // ---------- Original Method ----------
        //return certificate.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.202 -0400", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "F7591F67E2CA658FE0695A1EC4A57BDA")
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
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_1401549258 = (!signature.verify(certificate.getSignatureValue()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.203 -0400", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "C289636FC50B52DF60E547A9A7791EB2")
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
            boolean var8A77F4902EA675748C9379BC6E1FD5F4_1725203796 = (!signature.verify(certificate.getSignatureValue()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.213 -0400", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "3966C28C4F2D1395139367DC6FB57FA9")
    @Override
    public Set<String> getNonCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_294133288 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1814491306 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_294133288 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1814491306 = extensions.getNonCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_1434872767; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1434872767 = varB4EAC82CA7396A68D541C85D26508E83_294133288;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1434872767 = varB4EAC82CA7396A68D541C85D26508E83_1814491306;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1434872767.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1434872767;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getNonCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.214 -0400", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "DBDC50B903EF97717E153E30E75BBFBC")
    @Override
    public Set<String> getCriticalExtensionOIDs() {
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1407207183 = null; //Variable for return #1
        Set<String> varB4EAC82CA7396A68D541C85D26508E83_1374002121 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1407207183 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1374002121 = extensions.getCriticalExtensions();
        Set<String> varA7E53CE21691AB073D9660D615818899_2091155954; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2091155954 = varB4EAC82CA7396A68D541C85D26508E83_1407207183;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2091155954 = varB4EAC82CA7396A68D541C85D26508E83_1374002121;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2091155954.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2091155954;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //return extensions.getCriticalExtensions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.214 -0400", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "0D5C9091BAA3950645C08E75150887B2")
    @Override
    public byte[] getExtensionValue(String oid) {
        Extension ext;
        ext = extensions.getExtensionByOID(oid);
        {
            Object var9B2014C61FD04B9534F5C111F996892E_530502786 = (ext.getRawExtnValue());
        } //End flattened ternary
        addTaint(oid.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_168764559 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_168764559;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return null;
        //}
        //Extension ext = extensions.getExtensionByOID(oid);
        //return (ext == null) ? null : ext.getRawExtnValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.215 -0400", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "A0AD664286E3DEAD67DC3C98F096F06D")
    @Override
    public boolean hasUnsupportedCriticalExtension() {
        boolean varCD0035D29141121A191F8784F441BF54_1622112057 = (extensions.hasUnsupportedCritical());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037010794 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037010794;
        // ---------- Original Method ----------
        //if (extensions == null) {
            //return false;
        //}
        //return extensions.hasUnsupportedCritical();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:09.216 -0400", hash_original_field = "602DDB6C69ED63A58D6995673928AE6B", hash_generated_field = "950D3EE66DB7FA79771C824D20467B42")

    private static long serialVersionUID = 2972248729446736154L;
}

