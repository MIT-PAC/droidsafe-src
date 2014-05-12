package org.apache.harmony.security.provider.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.329 -0500", hash_original_field = "D07E4E14804DB7179916D91414448DCB", hash_generated_field = "AE4BC6F1CB9BA34159A076A49F034253")

    private static final long serialVersionUID = 2972248729446736154L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.332 -0500", hash_original_field = "606F6D0798228B84DAABB5165ABB953A", hash_generated_field = "A35DA85BFB78148ECCCCEB5F8393F6B0")

    private  Certificate certificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.334 -0500", hash_original_field = "25819148CF1894444A83EA1D53C5368C", hash_generated_field = "E9E16C20F8109D30A58A2009C3D92E1C")

    // cache values retrieved from the certificate object,
    // initialized using the "single-check idiom".
    private  TBSCertificate tbsCert;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.336 -0500", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.338 -0500", hash_original_field = "4947207FD34032EC0E9887166E067AE9", hash_generated_field = "2EC765BED2BDF716AF9EC97A75A23436")

    private volatile long notBefore = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.341 -0500", hash_original_field = "60B013C243B90585D6DBD6D88B906DAA", hash_generated_field = "39CE9AE64002FC7D7824A24107B28BE1")

    private volatile long notAfter = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.343 -0500", hash_original_field = "357D34BE4D3F218CD8ADF717DBF7DD40", hash_generated_field = "6E5F6035204D1622737CA2ACC061DCF3")

    private volatile BigInteger serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.346 -0500", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "9EE5AF17618FD2BB7F463AA6D8952935")

    private volatile X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.348 -0500", hash_original_field = "26CC832F307ECF2BD351D71B87043988", hash_generated_field = "20CE70858EB070AC19DF0C0FA3C8801D")

    private volatile X500Principal subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.350 -0500", hash_original_field = "BEC8F47C3CF2E85A5F37672FC9740D93", hash_generated_field = "FBFFF3FD4D9E6CA34F106C52F8881399")

    private volatile byte[] tbsCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.353 -0500", hash_original_field = "89CE5EB976882E5EBBD495E98D430D47", hash_generated_field = "B37059E96BFF94C4A8C826F2D458A74F")

    private volatile byte[] signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.355 -0500", hash_original_field = "26DABF5BD766951ADC08DC97E66ADD9E", hash_generated_field = "3D60F38E5AA9D7EF79A1B8F4EBF24343")

    private volatile String sigAlgName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.357 -0500", hash_original_field = "8E10B0B5A62ABD64FA9CA5CFA3002BB8", hash_generated_field = "D6704B6C7A301C1DCB611073FEDDE231")

    private volatile String sigAlgOID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.360 -0500", hash_original_field = "7D8C90E870C41938AFC08C3BE4E5FAFE", hash_generated_field = "A269D1A3BD65F686C483ED5C003170D3")

    private volatile byte[] sigAlgParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.362 -0500", hash_original_field = "647BF73090D203056F6FE9A73A500D11", hash_generated_field = "DB9191EE373830AE3B545E4BDE2CE4EC")

    private volatile boolean nullSigAlgParams;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.364 -0500", hash_original_field = "B73719A7AAE8E737607C294F86B7D620", hash_generated_field = "87651767986B8672256166483FB97DC1")

    private volatile PublicKey publicKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.367 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "D34977BDD79D6A10947AFF688E9F659B")

    private volatile byte[] encoding;

    /**
     * Constructs the instance on the base of ASN.1 encoded
     * form of X.509 certificate provided via stream parameter.
     * @param in input stream containing ASN.1 encoded form of certificate.
     * @throws CertificateException if some decoding problems occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.369 -0500", hash_original_method = "8B0F316F14E4B2EBE1AD9D0407358FB5", hash_generated_method = "78FFD442CB305199059CB561CEF465DD")
    
public X509CertImpl(InputStream in) throws CertificateException {
        try {
            // decode the Certificate object
            this.certificate = (Certificate) Certificate.ASN1.decode(in);
            // cache the values of TBSCertificate and Extensions
            this.tbsCert = certificate.getTbsCertificate();
            this.extensions = tbsCert.getExtensions();
        } catch (IOException e) {
            throw new CertificateException(e);
        }
    }

    /**
     * Constructs the instance on the base of existing Certificate object to
     * be wrapped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.373 -0500", hash_original_method = "8876B8D60330C38B32B3F1E3F7F33D8F", hash_generated_method = "D68C6F9FA647A83C6A4D81A513346973")
    
public X509CertImpl(Certificate certificate) {
        this.certificate = certificate;
        // cache the values of TBSCertificate and Extensions
        this.tbsCert = certificate.getTbsCertificate();
        this.extensions = tbsCert.getExtensions();
    }

    /**
     * Constructs the instance on the base of ASN.1 encoded
     * form of X.509 certificate provided via array of bytes.
     * @param encoding byte array containing ASN.1 encoded form of certificate.
     * @throws IOException if some decoding problems occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.375 -0500", hash_original_method = "9C90F0AD6131A4566D6AF431EC38BE50", hash_generated_method = "E01374FD1E1E369CB4B351319DA3A487")
    
public X509CertImpl(byte[] encoding) throws IOException {
        this((Certificate) Certificate.ASN1.decode(encoding));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.378 -0500", hash_original_method = "92CEFDF21FC191A18696C43CA9E48D20", hash_generated_method = "F5D828DECEF90BB55E6333E45DBA90FB")
    
public void checkValidity()
            throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(System.currentTimeMillis());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.380 -0500", hash_original_method = "59C6435E22C5BAEC0B6376C8B7A5112D", hash_generated_method = "91935A18F6CF288062F5ED6508F38A42")
    
public void checkValidity(Date date)
            throws CertificateExpiredException, CertificateNotYetValidException {
        checkValidity(date.getTime());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.382 -0500", hash_original_method = "5C762410FB306F1308EE7204752B0EB0", hash_generated_method = "311D76C9863D34CF179390B67991A922")
    
private void checkValidity(long time)
            throws CertificateExpiredException, CertificateNotYetValidException {
        if (time < getNotBeforeInternal()) {
            throw new CertificateNotYetValidException("current time: " + new Date(time)
                + ", validation time: " + new Date(getNotBeforeInternal()));
        }
        if (time > getNotAfterInternal()) {
            throw new CertificateExpiredException("current time: " + new Date(time)
                + ", expiration time: " + new Date(getNotAfterInternal()));
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.384 -0500", hash_original_method = "89D7F1BE0C395C13D4A43DDDB6D84533", hash_generated_method = "1B6A9D404A9BA8CA67C38D4F8D91C208")
    
public int getVersion() {
        return tbsCert.getVersion() + 1;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.386 -0500", hash_original_method = "CC90380181A21ABFD0C1237D9F2C9838", hash_generated_method = "1199A7B57F4E4267AC58B13BDEBD0678")
    
public BigInteger getSerialNumber() {
        BigInteger result = serialNumber;
        if (result == null) {
            serialNumber = result = tbsCert.getSerialNumber();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.389 -0500", hash_original_method = "2552251E229FA5F4C4BC8254C0633556", hash_generated_method = "EBA8C8B9CAB304F95B6A01ACB111427C")
    
public Principal getIssuerDN() {
        return getIssuerX500Principal();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.391 -0500", hash_original_method = "B82B3361EE6501B1AD6CD55F9554225E", hash_generated_method = "71F1BFFB4A7102D8CAA0E079228915EF")
    
public X500Principal getIssuerX500Principal() {
        X500Principal result = issuer;
        if (result == null) {
            // retrieve the issuer's principal
            issuer = result = tbsCert.getIssuer().getX500Principal();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.393 -0500", hash_original_method = "57EE376613339C3801C08A778AAA92CE", hash_generated_method = "C62826B4FD94AC083D14C15A363E5647")
    
public Principal getSubjectDN() {
        return getSubjectX500Principal();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.395 -0500", hash_original_method = "50D7E6DD1BE4A80FFE9B722B1EC59064", hash_generated_method = "FDD8230D45C6725C89C1F220D6884FC5")
    
public X500Principal getSubjectX500Principal() {
        X500Principal result = subject;
        if (result == null) {
            // retrieve the subject's principal
            subject = result = tbsCert.getSubject().getX500Principal();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.397 -0500", hash_original_method = "42D01D75FA3640E76A288F4F69BBD1FB", hash_generated_method = "72127F0B9743A5DA27E49109497022A4")
    
public Date getNotBefore() {
        return new Date(getNotBeforeInternal());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.400 -0500", hash_original_method = "4558EB8E531DC796F00773B26346E007", hash_generated_method = "044D2B87E64C7236EF8B83EBD8379DA0")
    
private long getNotBeforeInternal() {
        long result = notBefore;
        if (result == -1) {
            notBefore = result = tbsCert.getValidity().getNotBefore().getTime();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.402 -0500", hash_original_method = "247B9C82A59BA08F12FC34A8D1043A8F", hash_generated_method = "B45871D78FD8C6F3A097DF6173F6DAA9")
    
public Date getNotAfter() {
        return new Date(getNotAfterInternal());
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.404 -0500", hash_original_method = "DD249744796DD4B2B8069CA6B07316ED", hash_generated_method = "33B834046F08057C0FFF6F5A4EEEC77A")
    
private long getNotAfterInternal() {
        long result = notAfter;
        if (result == -1) {
            notAfter = result = tbsCert.getValidity().getNotAfter().getTime();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.406 -0500", hash_original_method = "713937699882346A31B465214B9B4401", hash_generated_method = "2A84FE76145DAA052F3C634C578E920D")
    
public byte[] getTBSCertificate() throws CertificateEncodingException {
        return getTbsCertificateInternal().clone();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.408 -0500", hash_original_method = "3E85018628BFB50292B491E8B8B8C0CD", hash_generated_method = "E0D2EC5640A10FD9E303C656EA287E7E")
    
private byte[] getTbsCertificateInternal() {
        byte[] result = tbsCertificate;
        if (result == null) {
            tbsCertificate = result = tbsCert.getEncoded();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.411 -0500", hash_original_method = "EB14E7CDB05E64025ABBA11FDD999629", hash_generated_method = "B81DBD388F1D0E887C7D7D7B161BFD24")
    
public byte[] getSignature() {
        return getSignatureInternal().clone();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.413 -0500", hash_original_method = "1D526D791318CE6ACD668C92F6511A39", hash_generated_method = "2F8D8C885CA92928A4332801289EB1F4")
    
private byte[] getSignatureInternal() {
        byte[] result = signature;
        if (result == null) {
            signature = result = certificate.getSignatureValue();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.416 -0500", hash_original_method = "36C3BDBBAA85C39CA2DA1792DFF67222", hash_generated_method = "DB5C391257E1BBC05C90A6A205BA1331")
    
public String getSigAlgName() {
        String result = sigAlgName;
        if (result == null) {
            String sigAlgOIDLocal = getSigAlgOID();
            // retrieve the name of the signing algorithm
            result = AlgNameMapper.map2AlgName(sigAlgOIDLocal);
            if (result == null) {
                // if could not be found, use OID as a name
                result = sigAlgOIDLocal;
            }
            sigAlgName = result;
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.419 -0500", hash_original_method = "C10B97AA2F949E0770EFB417749475D0", hash_generated_method = "778D62D59B6D2A3AD5EE4B55CC71DC2D")
    
public String getSigAlgOID() {
        String result = sigAlgOID;
        if (result == null) {
            // if info was not retrieved (and cached), do it:
            sigAlgOID = result = tbsCert.getSignature().getAlgorithm();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.421 -0500", hash_original_method = "A4F68E4A7ABF2F614B271E042CE68DFD", hash_generated_method = "93845529E0B90C234574746244E60D04")
    
public byte[] getSigAlgParams() {
        if (nullSigAlgParams) {
            return null;
        }
        byte[] result = sigAlgParams;
        if (result == null) {
            result = tbsCert.getSignature().getParameters();
            if (result == null) {
                nullSigAlgParams = true;
                return null;
            }
            sigAlgParams = result;
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.423 -0500", hash_original_method = "5910DFD7FE416853E5E8B3596C036798", hash_generated_method = "EAAF83AFD4A8D6BFF2CC8D0061803038")
    
public boolean[] getIssuerUniqueID() {
        return tbsCert.getIssuerUniqueID();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.425 -0500", hash_original_method = "97AECD47F957244BC2EDB08A3DFA1485", hash_generated_method = "4B5FBE50259FE9C84FCA6635A1784E7E")
    
public boolean[] getSubjectUniqueID() {
        return tbsCert.getSubjectUniqueID();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.428 -0500", hash_original_method = "7963F25A7C6EC878E5FE59792F4927CF", hash_generated_method = "F36E1E92435A3EBFF21A5C1D34F79BC0")
    
public boolean[] getKeyUsage() {
        if (extensions == null) {
            return null;
        }
        return extensions.valueOfKeyUsage();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.430 -0500", hash_original_method = "879E6EC12A8ACAB06B48BD9054F744F5", hash_generated_method = "33DB801A575FB28AE8500B7C6BC069D7")
    
public List<String> getExtendedKeyUsage()
                                throws CertificateParsingException {
        if (extensions == null) {
            return null;
        }
        try {
            return extensions.valueOfExtendedKeyUsage();
        } catch (IOException e) {
            throw new CertificateParsingException(e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.432 -0500", hash_original_method = "338E6CEAECFAB8CF1E7BE34A5E6721D3", hash_generated_method = "E9408E6086C76A4EB83790A2DA4BF4DF")
    
public int getBasicConstraints() {
        if (extensions == null) {
            return Integer.MAX_VALUE;
        }
        return extensions.valueOfBasicConstrains();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.434 -0500", hash_original_method = "73F2B21E8EC8FD1E84C605144B87E477", hash_generated_method = "3D7D7D4650E1696332AF8E9E95CF2D86")
    
public Collection<List<?>> getSubjectAlternativeNames() throws CertificateParsingException {
        if (extensions == null) {
            return null;
        }
        try {
            // Retrieve the extension value from the cached extensions object
            // This extension is not checked for correctness during
            // certificate generation, so now it can throw exception
            return extensions.valueOfSubjectAlternativeName();
        } catch (IOException e) {
            throw new CertificateParsingException(e);
        }
    }

    /**
     * @see java.security.cert.X509Certificate#getIssuerAlternativeNames()
     * method documentation for more information.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.437 -0500", hash_original_method = "40F7C32C55156DBF6396CA2C21DA2FF4", hash_generated_method = "B5BE233C797BC4CF987EE5F91E908549")
    
public Collection<List<?>> getIssuerAlternativeNames() throws CertificateParsingException {
        if (extensions == null) {
            return null;
        }
        try {
            // Retrieve the extension value from the cached extensions object
            // This extension is not checked for correctness during
            // certificate generation, so now it can throw exception
            return extensions.valueOfIssuerAlternativeName();
        } catch (IOException e) {
            throw new CertificateParsingException(e);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.439 -0500", hash_original_method = "4063CD679B717558744A87C021CCD284", hash_generated_method = "E51385EDB6480527A04F58C974576564")
    
@Override public byte[] getEncoded() throws CertificateEncodingException {
        return getEncodedInternal().clone();
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.441 -0500", hash_original_method = "89DAFF52A0746AEA205DFD1B0F750CF1", hash_generated_method = "D23A0C5E912E559E9C9382142EDDFC0F")
    
private byte[] getEncodedInternal() throws CertificateEncodingException {
        byte[] result = encoding;
        if (encoding == null) {
            encoding = result = certificate.getEncoded();
        }
        return result;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.444 -0500", hash_original_method = "C29BF4798FFF05217C70FFE55AFF7469", hash_generated_method = "043BA1F61BA7CFB09029937732338040")
    
@Override public PublicKey getPublicKey() {
        PublicKey result = publicKey;
        if (result == null) {
            publicKey = result = tbsCert.getSubjectPublicKeyInfo().getPublicKey();
        }
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.447 -0500", hash_original_method = "3446887E135847ED5405A847AD59261D", hash_generated_method = "512F65A6CFB71990BA9F151259699921")
    
@Override public String toString() {
        return certificate.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.449 -0500", hash_original_method = "900A10423E0048AD626C0269D411A2B0", hash_generated_method = "93A048DD63D1FB15884F72F9E5B817D4")
    
@Override public void verify(PublicKey key)
            throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {

        Signature signature;
        try {
            signature = OpenSSLSignature.getInstance(getSigAlgName());
        } catch (NoSuchAlgorithmException ignored) {
            signature = Signature.getInstance(getSigAlgName());
        }
        signature.initVerify(key);
        // retrieve the encoding of the TBSCertificate structure
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        // compute and verify the signature
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        if (!signature.verify(certificate.getSignatureValue())) {
            throw new SignatureException("Signature was not verified");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.452 -0500", hash_original_method = "F86E33551F4B4C0CF1612498F092A43C", hash_generated_method = "798BB055D6E9C0CEC6724B364AAB560D")
    
@Override public void verify(PublicKey key, String sigProvider)
            throws CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            NoSuchProviderException, SignatureException {

        Signature signature;
        try {
            if (sigProvider == null) {
                signature = OpenSSLSignature.getInstance(getSigAlgName());
            } else {
                signature = Signature.getInstance(getSigAlgName(), sigProvider);
            }
        } catch (NoSuchAlgorithmException ignored) {
            signature = Signature.getInstance(getSigAlgName(), sigProvider);
        }
        signature.initVerify(key);
        // retrieve the encoding of the TBSCertificate structure
        byte[] tbsCertificateLocal = getTbsCertificateInternal();
        // compute and verify the signature
        signature.update(tbsCertificateLocal, 0, tbsCertificateLocal.length);
        if (!signature.verify(certificate.getSignatureValue())) {
            throw new SignatureException("Signature was not verified");
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.454 -0500", hash_original_method = "D555F516A4047F5D7C4D53CF443DF432", hash_generated_method = "20D9EB8A8B0FAC7E79DEC4100F37A033")
    
@Override public Set<String> getNonCriticalExtensionOIDs() {
        if (extensions == null) {
            return null;
        }
        // retrieve the info from the cached extensions object
        return extensions.getNonCriticalExtensions();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.457 -0500", hash_original_method = "B95147569C30A037580BE18E2484572D", hash_generated_method = "B4F87595567AF751F1BF120C5728B730")
    
@Override public Set<String> getCriticalExtensionOIDs() {
        if (extensions == null) {
            return null;
        }
        // retrieve the info from the cached extensions object
        return extensions.getCriticalExtensions();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.459 -0500", hash_original_method = "46B3B0A81D238D78F58FF04050F493C3", hash_generated_method = "947E8F1D0576A94E3DCB126528913FFF")
    
@Override public byte[] getExtensionValue(String oid) {
        if (extensions == null) {
            return null;
        }
        // retrieve the info from the cached extensions object
        Extension ext = extensions.getExtensionByOID(oid);
        return (ext == null) ? null : ext.getRawExtnValue();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:04.462 -0500", hash_original_method = "CB7B238BECDE285B4B368E69C74FBD34", hash_generated_method = "4ACED1938F5AC420EAFD5EA2C46DF029")
    
@Override public boolean hasUnsupportedCriticalExtension() {
        if (extensions == null) {
            return false;
        }
        // retrieve the info from the cached extensions object
        return extensions.hasUnsupportedCritical();
    }
}

