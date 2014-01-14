package javax.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Security;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.util.Date;

public abstract class X509Certificate extends Certificate {
    
    public static final X509Certificate getInstance(InputStream inStream) throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        if (constructor != null) {
            try {
                return (X509Certificate)
                    constructor.newInstance(new Object[] {inStream});
            } catch (Throwable e) {
                throw new CertificateException(e.getMessage());
            }
        }
        final java.security.cert.X509Certificate cert;
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            cert = (java.security.cert.X509Certificate)
                                            cf.generateCertificate(inStream);
        } catch (java.security.cert.CertificateException e) {
            throw new CertificateException(e.getMessage());
        }
        return new X509Certificate() {

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.832 -0500", hash_original_method = "8AD2DCC1EEFB93B0D6F07C4FB7BF70E9", hash_generated_method = "A2D6588FF8363A2C82CB5FD54437BADC")
            
public byte[] getEncoded() throws CertificateEncodingException {
                try {
                    return cert.getEncoded();
                } catch (java.security.cert.CertificateEncodingException e) {
                    throw new CertificateEncodingException(e.getMessage());
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.834 -0500", hash_original_method = "A8AA9B7C471C7CDB9EDB6C435620D0D8", hash_generated_method = "B1A84FBFE74089F0FB816007036A068C")
            
public void verify(PublicKey key) throws CertificateException,
                                NoSuchAlgorithmException, InvalidKeyException,
                                NoSuchProviderException, SignatureException {
                try {
                    cert.verify(key);
                } catch (java.security.cert.CertificateException e) {
                    throw new CertificateException(e.getMessage());
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.837 -0500", hash_original_method = "C805370AE6F335B3B43A93AD3C44270E", hash_generated_method = "582853CA1F0DB57E7A255A2EAEE1F92D")
            
public void verify(PublicKey key, String sigProvider)
                            throws CertificateException,
                                NoSuchAlgorithmException, InvalidKeyException,
                                NoSuchProviderException, SignatureException {
                try {
                    cert.verify(key, sigProvider);
                } catch (java.security.cert.CertificateException e) {
                    throw new CertificateException(e.getMessage());
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.839 -0500", hash_original_method = "41549717A9C4B1F409796BF6EB2A013F", hash_generated_method = "0FA0AFDFCE11223840EA50B776D9C9B9")
            
public String toString() {
                return cert.toString();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.843 -0500", hash_original_method = "DFA7B9612F04FA27415D790DCAB9B56B", hash_generated_method = "724BC0FBAC2A949AC783C9B17AF6FC00")
            
public PublicKey getPublicKey() {
                return cert.getPublicKey();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.846 -0500", hash_original_method = "303726EA6E007F82DECAF2DAE4B7B752", hash_generated_method = "E91AF14F97D19BCEAD5B6AD81273FCAA")
            
public void checkValidity() throws CertificateExpiredException,
                                   CertificateNotYetValidException {
                try {
                    cert.checkValidity();
                } catch (java.security.cert.CertificateNotYetValidException e) {
                    throw new CertificateNotYetValidException(e.getMessage());
                } catch (java.security.cert.CertificateExpiredException e) {
                    throw new CertificateExpiredException(e.getMessage());
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.848 -0500", hash_original_method = "49DF2ADC8AB42600043D5163F65B49F1", hash_generated_method = "6803D5535F4EC491C64DF36B1024B2E9")
            
public void checkValidity(Date date)
                            throws CertificateExpiredException,
                                   CertificateNotYetValidException {
                try {
                    cert.checkValidity(date);
                } catch (java.security.cert.CertificateNotYetValidException e) {
                    throw new CertificateNotYetValidException(e.getMessage());
                } catch (java.security.cert.CertificateExpiredException e) {
                    throw new CertificateExpiredException(e.getMessage());
                }
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.851 -0500", hash_original_method = "68448D1F5E3522A266812F443BFC209F", hash_generated_method = "968B861E5676D9F282754FD08C6CB3FE")
            
public int getVersion() {
                return 2;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.853 -0500", hash_original_method = "6031DB0A3BAFAE8082EB4CC865EC32C8", hash_generated_method = "15FDDAA066DD35F23710861058343AFB")
            
public BigInteger getSerialNumber() {
                return cert.getSerialNumber();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.856 -0500", hash_original_method = "0DE779F5218051DFDA8D6AED41DCBBEC", hash_generated_method = "15888F28CE370639815C6DADAA052D77")
            
public Principal getIssuerDN() {
                return cert.getIssuerDN();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.858 -0500", hash_original_method = "842EDDA5C55BBF3F51FA272A067D70E7", hash_generated_method = "CC90AB19C85742E39B55596E29CE344C")
            
public Principal getSubjectDN() {
                return cert.getSubjectDN();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.861 -0500", hash_original_method = "16FAF9BCD2CAC885C11ED38D4B8D72D3", hash_generated_method = "043F7575B666B697826D2D502196FF32")
            
public Date getNotBefore() {
                return cert.getNotBefore();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.864 -0500", hash_original_method = "F3AC697C0D919966395CCA080B040BC7", hash_generated_method = "774B7D4FC63E4F3D1F63CC375937D0AF")
            
public Date getNotAfter() {
                return cert.getNotAfter();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.866 -0500", hash_original_method = "47C7F0D07F343BF2D250C19C8F227AFD", hash_generated_method = "116E7BD7753F268569DABFE67574D0B0")
            
public String getSigAlgName() {
                return cert.getSigAlgName();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.868 -0500", hash_original_method = "6EF21831D3E0F4F0EA739B4D72DF06B9", hash_generated_method = "673776EE55BF6858DA051445A0213866")
            
public String getSigAlgOID() {
                return cert.getSigAlgOID();
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.871 -0500", hash_original_method = "B14BB26E0DE1B1F3E36D1E9FA1E63109", hash_generated_method = "E04BC5D53DA35DA362C0E783F93820E6")
            
public byte[] getSigAlgParams() {
                return cert.getSigAlgParams();
            }
        };
    }

    /**
     * Creates a new {@code X509Certificate} and initializes it from the
     * specified byte array.
     *
     * @param certData
     *            byte array containing data to initialize the certificate.
     * @return the certificate initialized from the specified byte array
     * @throws CertificateException
     *             if the certificate cannot be created or initialized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.877 -0500", hash_original_method = "4740B2B56500AAF60D83C231AF13C259", hash_generated_method = "0C866782C071AAF4B318273EC6BE3C9F")
    
public static final X509Certificate getInstance(byte[] certData)
                                             throws CertificateException {
        if (certData == null) {
            throw new CertificateException("certData == null");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(certData);
        return getInstance(bais);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.825 -0500", hash_original_field = "C7A44D4A43B1906F79B31BCC6A88354D", hash_generated_field = "2112A4F4A023E8F770192D2021400B78")

    private static Constructor constructor;

    /**
     * Creates a new {@code X509Certificate}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.828 -0500", hash_original_method = "0337B060243DB2E8E059CE304C023100", hash_generated_method = "947DC153C927E5F73C306FE5828C199C")
    
public X509Certificate() {
    }

    /**
     * Checks whether the certificate is currently valid.
     * <p>
     * The validity defined in ASN.1:
     *
     * <pre>
     * validity             Validity
     *
     * Validity ::= SEQUENCE {
     *      notBefore       CertificateValidityDate,
     *      notAfter        CertificateValidityDate }
     *
     * CertificateValidityDate ::= CHOICE {
     *      utcTime         UTCTime,
     *      generalTime     GeneralizedTime }
     * </pre>
     *
     * @throws CertificateExpiredException
     *             if the certificate has expired.
     * @throws CertificateNotYetValidException
     *             if the certificate is not yet valid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.879 -0500", hash_original_method = "F5F347E34DA2ECA632629BEE6BFD25DB", hash_generated_method = "365EAF961D9881EC936517E72D7D2CE1")
    
public abstract void checkValidity()
            throws CertificateExpiredException, CertificateNotYetValidException;

    /**
     * Checks whether the certificate is valid at the specified date.
     *
     * @param date
     *            the date to check the validity against.
     * @throws CertificateExpiredException
     *             if the certificate has expired.
     * @throws CertificateNotYetValidException
     *             if the certificate is not yet valid.
     * @see #checkValidity()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.881 -0500", hash_original_method = "2BDF346C2D19CD8B70118069444E98B2", hash_generated_method = "42703E5E13EF137B54DDF0AB4D8D14E0")
    
public abstract void checkValidity(Date date)
            throws CertificateExpiredException, CertificateNotYetValidException;

    /**
     * Returns the certificates {@code version} (version number).
     * <p>
     * The version defined is ASN.1:
     *
     * <pre>
     * Version ::=  INTEGER  {  v1(0), v2(1), v3(2)  }
     * </pre>
     *
     * @return the version number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.884 -0500", hash_original_method = "C9D69CCD70755B0B4C79B91112E497F0", hash_generated_method = "9A237F250BD641E6638839B83E2CCDA2")
    
public abstract int getVersion();

    /**
     * Returns the {@code serialNumber} of the certificate.
     * <p>
     * The ASN.1 definition of {@code serialNumber}:
     *
     * <pre>
     * CertificateSerialNumber  ::=  INTEGER
     * </pre>
     *
     * @return the serial number.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.887 -0500", hash_original_method = "2D5882042D282C86B57A0B6CD5FE19CE", hash_generated_method = "D29148C5FFC0F0105CF1B0377A4956B6")
    
public abstract BigInteger getSerialNumber();

    /**
     * Returns the {@code issuer} (issuer distinguished name) as an
     * implementation specific {@code Principal} object.
     * <p>
     * The ASN.1 definition of {@code issuer}:
     *
     * <pre>
     *  issuer      Name
     *
     *  Name ::= CHOICE {
     *      RDNSequence }
     *
     *    RDNSequence ::= SEQUENCE OF RelativeDistinguishedName
     *
     *    RelativeDistinguishedName ::= SET OF AttributeTypeAndValue
     *
     *    AttributeTypeAndValue ::= SEQUENCE {
     *      type     AttributeType,
     *      value    AttributeValue }
     *
     *    AttributeType ::= OBJECT IDENTIFIER
     *
     *    AttributeValue ::= ANY DEFINED BY AttributeType
     * </pre>
     *
     * @return the {@code issuer} as an implementation specific {@code
     *         Principal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.889 -0500", hash_original_method = "CFD4B1AB5457E8D83BA71C1E3C629BC8", hash_generated_method = "9C5A2933970D035DEBB544066AFA6660")
    
public abstract Principal getIssuerDN();

    /**
     * Returns the {@code subject} (subject distinguished name) as an
     * implementation specific {@code Principal} object.
     * <p>
     * The ASN.1 definition of {@code subject}:
     *
     * <pre>
     * subject      Name
     *
     *  Name ::= CHOICE {
     *      RDNSequence }
     *
     *    RDNSequence ::= SEQUENCE OF RelativeDistinguishedName
     *
     *    RelativeDistinguishedName ::= SET OF AttributeTypeAndValue
     *
     *    AttributeTypeAndValue ::= SEQUENCE {
     *      type     AttributeType,
     *      value    AttributeValue }
     *
     *    AttributeType ::= OBJECT IDENTIFIER
     *
     *    AttributeValue ::= ANY DEFINED BY AttributeType
     * </pre>
     *
     * @return the {@code subject} (subject distinguished name).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.891 -0500", hash_original_method = "E0F77CE07B227D3603ED3A0271F92454", hash_generated_method = "E482C8FB11763C0AFFC0735209BBBE58")
    
public abstract Principal getSubjectDN();

    /**
     * Returns the {@code notBefore} date from the validity period of the
     * certificate.
     *
     * @return the start of the validity period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.893 -0500", hash_original_method = "4973D771E66D1A4657A0C1247BDB1C7F", hash_generated_method = "4D5B6DD9ED79E382CCCE201BD20FBF19")
    
public abstract Date getNotBefore();

    /**
     * Returns the {@code notAfter} date of the validity period of the
     * certificate.
     *
     * @return the end of the validity period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.896 -0500", hash_original_method = "60CD39BB89D5B2F3FE02567DED33AE6A", hash_generated_method = "A46977176465432B398D77EAC1C4B7AC")
    
public abstract Date getNotAfter();

    /**
     * Returns the name of the algorithm for the certificate signature.
     *
     * @return the signature algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.898 -0500", hash_original_method = "216D3E1A498593B7D7EABB101D467822", hash_generated_method = "CB43224098008E13522F8ACD3701FF8F")
    
public abstract String getSigAlgName();

    /**
     * Returns the OID of the signature algorithm from the certificate.
     *
     * @return the OID of the signature algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.900 -0500", hash_original_method = "9620CC2E45D9ACF043D9721699346668", hash_generated_method = "0BDD2E502B8E1AFA50ACBBDB644FEF8E")
    
public abstract String getSigAlgOID();

    /**
     * Returns the parameters of the signature algorithm in DER-encoded format.
     *
     * @return the parameters of the signature algorithm, or null if none are
     *         used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:53.902 -0500", hash_original_method = "894442A9DD60EB8EA7F18DCBD364CD81", hash_generated_method = "0ED228DA803094562287FBBA6821152B")
    
public abstract byte[] getSigAlgParams();
    static {
        try {
            String classname = Security.getProperty("cert.provider.x509v1");
            Class cl = Class.forName(classname);
            constructor = cl.getConstructor(new Class[] {InputStream.class});
        } catch (Throwable e) {
        }
    }
    
}

