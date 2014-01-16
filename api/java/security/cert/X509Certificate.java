package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.Principal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.security.auth.x500.X500Principal;

public abstract class X509Certificate extends Certificate implements X509Extension {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.753 -0500", hash_original_field = "45A94DD103E7CC2C6930B99BDD4E44E3", hash_generated_field = "295358E84336F84BE14E3E6F43F3885D")

    private static final long serialVersionUID = -2491127588187038216L;

    /**
     * Creates a new {@code X509Certificate}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.755 -0500", hash_original_method = "91BE0E39C67CC71AFC40C5A05860BC17", hash_generated_method = "19C930C3AE8A07BCD0404159D78050F4")
    
protected X509Certificate() {
        super("X.509");
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.758 -0500", hash_original_method = "F5F347E34DA2ECA632629BEE6BFD25DB", hash_generated_method = "365EAF961D9881EC936517E72D7D2CE1")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.760 -0500", hash_original_method = "2BDF346C2D19CD8B70118069444E98B2", hash_generated_method = "42703E5E13EF137B54DDF0AB4D8D14E0")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.764 -0500", hash_original_method = "C9D69CCD70755B0B4C79B91112E497F0", hash_generated_method = "9A237F250BD641E6638839B83E2CCDA2")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.766 -0500", hash_original_method = "2D5882042D282C86B57A0B6CD5FE19CE", hash_generated_method = "D29148C5FFC0F0105CF1B0377A4956B6")
    
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
     * <b>replaced by:</b> {@link #getIssuerX500Principal()}.
     *
     * @return the {@code issuer} as an implementation specific {@code
     *         Principal}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.769 -0500", hash_original_method = "CFD4B1AB5457E8D83BA71C1E3C629BC8", hash_generated_method = "9C5A2933970D035DEBB544066AFA6660")
    
public abstract Principal getIssuerDN() ;

    /**
     * Returns the {@code issuer} (issuer distinguished name) as an {@code
     * X500Principal}.
     *
     * @return the {@code issuer} (issuer distinguished name).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.771 -0500", hash_original_method = "622364792700CAE6EDC2CD40345CDB0C", hash_generated_method = "478760CCC26CE25D1BFDCC9A710FDFC9")
    
public X500Principal getIssuerX500Principal() {

        try {
            // TODO if there is no X.509 certificate provider installed
            // should we try to access Harmony X509CertImpl via classForName?
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");

            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));

            return cert.getIssuerX500Principal();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get X500Principal issuer", e);
        }
    }

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
     * <p>
     * <b>replaced by:</b> {@link #getSubjectX500Principal()}.
     *
     * @return the {@code subject} (subject distinguished name).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.773 -0500", hash_original_method = "E0F77CE07B227D3603ED3A0271F92454", hash_generated_method = "E482C8FB11763C0AFFC0735209BBBE58")
    
public abstract Principal getSubjectDN();

    /**
     * Returns the {@code subject} (subject distinguished name) as an {@code
     * X500Principal}.
     *
     * @return the {@code subject} (subject distinguished name)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.776 -0500", hash_original_method = "4B536E889AC2F831879320061DB28B36", hash_generated_method = "CDA1CB61CC02EE95C2EA7871BDAE4CDE")
    
public X500Principal getSubjectX500Principal() {

        try {
            // TODO if there is no X.509 certificate provider installed
            // should we try to access Harmony X509CertImpl via classForName?
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");

            X509Certificate cert = (X509Certificate) factory
                    .generateCertificate(new ByteArrayInputStream(getEncoded()));

            return cert.getSubjectX500Principal();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get X500Principal subject", e);
        }
    }

    /**
     * Returns the {@code notBefore} date from the validity period of the
     * certificate.
     *
     * @return the start of the validity period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.778 -0500", hash_original_method = "4973D771E66D1A4657A0C1247BDB1C7F", hash_generated_method = "4D5B6DD9ED79E382CCCE201BD20FBF19")
    
public abstract Date getNotBefore();

    /**
     * Returns the {@code notAfter} date of the validity period of the
     * certificate.
     *
     * @return the end of the validity period.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.781 -0500", hash_original_method = "60CD39BB89D5B2F3FE02567DED33AE6A", hash_generated_method = "A46977176465432B398D77EAC1C4B7AC")
    
public abstract Date getNotAfter();

    /**
     * Returns the {@code tbsCertificate} information from this certificate in
     * DER-encoded format.
     *
     * @return the DER-encoded certificate information.
     * @throws CertificateEncodingException
     *             if an error occurs in encoding
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.783 -0500", hash_original_method = "F3D489432C6DB907E03A8B787DF8236C", hash_generated_method = "DCE8C2BFA5E76E6745D7713807996CE9")
    
public abstract byte[] getTBSCertificate()
                                    throws CertificateEncodingException;

    /**
     * Returns the raw signature bits from the certificate.
     *
     * @return the raw signature bits from the certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.786 -0500", hash_original_method = "2A6A081097CE32B58420C722B3CF0653", hash_generated_method = "EE84B78CECA9DEC244E6765A7A5D9557")
    
public abstract byte[] getSignature();

    /**
     * Returns the name of the algorithm for the certificate signature.
     *
     * @return the signature algorithm name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.788 -0500", hash_original_method = "216D3E1A498593B7D7EABB101D467822", hash_generated_method = "CB43224098008E13522F8ACD3701FF8F")
    
public abstract String getSigAlgName();

    /**
     * Returns the OID of the signature algorithm from the certificate.
     *
     * @return the OID of the signature algorithm.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.790 -0500", hash_original_method = "9620CC2E45D9ACF043D9721699346668", hash_generated_method = "0BDD2E502B8E1AFA50ACBBDB644FEF8E")
    
public abstract String getSigAlgOID();

    /**
     * Returns the parameters of the signature algorithm in DER-encoded format.
     *
     * @return the parameters of the signature algorithm, or {@code null} if
     *         none are used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.793 -0500", hash_original_method = "894442A9DD60EB8EA7F18DCBD364CD81", hash_generated_method = "0ED228DA803094562287FBBA6821152B")
    
public abstract byte[] getSigAlgParams();

    /**
     * Returns the {@code issuerUniqueID} from the certificate.
     *
     * @return the {@code issuerUniqueID} or {@code null} if there's none in the
     *         certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.795 -0500", hash_original_method = "42468BEFDB67B8375D02DCA54DB436D8", hash_generated_method = "6EC7E0A1A432C2D66F970EF61D61EC0D")
    
public abstract boolean[] getIssuerUniqueID();

    /**
     * Returns the {@code subjectUniqueID} from the certificate.
     *
     * @return the {@code subjectUniqueID} or null if there's none in the
     *         certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.798 -0500", hash_original_method = "DF7F9EAF530A427E347F11A22A131303", hash_generated_method = "E42D1FFB5105CA6EE85B948133A1D903")
    
public abstract boolean[] getSubjectUniqueID();

    /**
     * Returns the {@code KeyUsage} extension as a {@code boolean} array.
     * <p>
     * The ASN.1 definition of {@code KeyUsage}:
     *
     * <pre>
     * KeyUsage ::= BIT STRING {
     *      digitalSignature        (0),
     *      nonRepudiation          (1),
     *      keyEncipherment         (2),
     *      dataEncipherment        (3),
     *      keyAgreement            (4),
     *      keyCertSign             (5),
     *      cRLSign                 (6),
     *      encipherOnly            (7),
     *      decipherOnly            (8) }
     *
     * </pre>
     *
     * @return the {@code KeyUsage} extension or {@code null} if there's none in
     *         the certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.800 -0500", hash_original_method = "9C5524B8EB344BA29043716526C919DA", hash_generated_method = "844F6E17D103FDBB3AC2E71D6932375B")
    
public abstract boolean[] getKeyUsage();

    /**
     * Returns a read-only list of OID strings representing the {@code
     * ExtKeyUsageSyntax} field of the extended key usage extension.
     *
     * @return the extended key usage extension, or {@code null} if there's none
     *         in the certificate.
     * @throws CertificateParsingException
     *             if the extension decoding fails.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.802 -0500", hash_original_method = "418B9B73EF0BB9A94B6F38EF0D0811CB", hash_generated_method = "9D60A831FC7F629FFDF2244F7B5F2183")
    
public List<String> getExtendedKeyUsage()
                        throws CertificateParsingException {
        return null;
    }

    /**
     * Returns the path length of the certificate constraints from the {@code
     * BasicContraints} extension.
     *
     * @return the path length of the certificate constraints if the extension
     *         is present or {@code -1} if the extension is not present. {@code
     *         Integer.MAX_VALUE} if there's not limit.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.805 -0500", hash_original_method = "C846106608A983A029DC331AAE301468", hash_generated_method = "CFAF0A64AE2F7C09E8CCC6847669F060")
    
public abstract int getBasicConstraints();

    /**
     * Returns a read-only list of the subject alternative names from the
     * {@code SubjectAltName} extension.
     * <p>
     * The ASN.1 definition of {@code SubjectAltName}:
     *
     * <pre>
     * SubjectAltName ::= GeneralNames
     *
     * GeneralNames ::= SEQUENCE SIZE (1..MAX) OF GeneralName
     *
     * GeneralName ::= CHOICE {
     *      otherName                       [0]     AnotherName,
     *      rfc822Name                      [1]     IA5String,
     *      dNSName                         [2]     IA5String,
     *      x400Address                     [3]     ORAddress,
     *      directoryName                   [4]     Name,
     *      ediPartyName                    [5]     EDIPartyName,
     *      uniformResourceIdentifier       [6]     IA5String,
     *      iPAddress                       [7]     OCTET STRING,
     *      registeredID                    [8]     OBJECT IDENTIFIER }
     *
     * </pre>
     *
     * @return the subject alternative names or {@code null} if there are none
     *         in the certificate.
     * @throws CertificateParsingException
     *             if decoding of the extension fails.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.808 -0500", hash_original_method = "2F7FC96FA38F720B2ACF5452CA7F8BC4", hash_generated_method = "3B38E600F6745A563AE2BD9CBD9C3451")
    
public Collection<List<?>> getSubjectAlternativeNames()
                                    throws CertificateParsingException {
        return null;
    }

    /**
     * Returns a read-only list of the issuer alternative names from the {@code
     * IssuerAltName} extension.
     * <p>
     * The ASN.1 definition of {@code IssuerAltName}:
     *
     * <pre>
     * IssuerAltName ::= GeneralNames
     *
     * GeneralNames ::= SEQUENCE SIZE (1..MAX) OF GeneralName
     *
     * GeneralName ::= CHOICE {
     *      otherName                       [0]     AnotherName,
     *      rfc822Name                      [1]     IA5String,
     *      dNSName                         [2]     IA5String,
     *      x400Address                     [3]     ORAddress,
     *      directoryName                   [4]     Name,
     *      ediPartyName                    [5]     EDIPartyName,
     *      uniformResourceIdentifier       [6]     IA5String,
     *      iPAddress                       [7]     OCTET STRING,
     *      registeredID                    [8]     OBJECT IDENTIFIER }
     *
     * </pre>
     *
     * @return the issuer alternative names of {@code null} if there are none in
     *         the certificate.
     * @throws CertificateParsingException
     *             if decoding of the extension fails.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.810 -0500", hash_original_method = "274C80A4A7372477807793557A7E6C15", hash_generated_method = "41EA8909B54C30DB2B9ECAE055E46505")
    
public Collection<List<?>> getIssuerAlternativeNames()
                                    throws CertificateParsingException {
        return null;
    }
}

