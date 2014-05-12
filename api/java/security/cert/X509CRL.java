package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Date;
import java.util.Set;

import javax.security.auth.x500.X500Principal;

public abstract class X509CRL extends CRL implements X509Extension {

    /**
     * Creates a new {@code X509CRL} instance.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.704 -0500", hash_original_method = "2D9BCEC4939C6B2A16B59D950D508E2F", hash_generated_method = "A0991578263BE5A21B57395E595617A0")
    
protected X509CRL() {
        super("X.509");
    }

    /**
     * Returns whether the specified object equals to this instance.
     *
     * @param other
     *            the object to compare.
     * @return {@code true} if the specified object is equal to this, otherwise
     *         {@code false}.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.707 -0500", hash_original_method = "B46E0DB2406C7673FA6227AB64C6E804", hash_generated_method = "A372A8D26A60B4BE8EC4244338F3FC47")
    
public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof X509CRL)) {
            return false;
        }
        X509CRL obj = (X509CRL) other;
        try {
            return Arrays.equals(getEncoded(), obj.getEncoded());
        } catch (CRLException e) {
            return false;
        }
    }

    /**
     * Returns the hashcode of this CRL instance.
     *
     * @return the hashcode.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.709 -0500", hash_original_method = "A943E96C731BD94967EC1AD73CB7A230", hash_generated_method = "3B302EDEF414A062B9EAB71D370690F3")
    
public int hashCode() {
        try {
            int res = 0;
            byte[] array = getEncoded();
            for (int i=0; i<array.length; i++) {
                res += array[i] & 0xFF;
            }
            return res;
        } catch (CRLException e) {
            return 0;
        }
    }

    /**
     * Returns this CRL in ASN.1 DER encoded form.
     *
     * @return this CRL in ASN.1 DER encoded form.
     * @throws CRLException
     *             if encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.712 -0500", hash_original_method = "FC55581283358EA6D0060240A5ACF549", hash_generated_method = "F231EC0E41468E770571456AAD350EA8")
    
public abstract byte[] getEncoded() throws CRLException;

    /**
     * Verifies this CRL by verifying that this CRL was signed with the
     * corresponding private key to the specified public key.
     *
     * @param key
     *            the public key to verify this CRL with.
     * @throws CRLException
     *             if encoding or decoding fails.
     * @throws NoSuchAlgorithmException
     *             if a needed algorithm is not present.
     * @throws InvalidKeyException
     *             if the specified key is invalid.
     * @throws NoSuchProviderException
     *             if no provider can be found.
     * @throws SignatureException
     *             if errors occur on signatures.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.714 -0500", hash_original_method = "5F4D078983C28BC7E7A3C9E3E7FEBA49", hash_generated_method = "554E05DF4ABD85556E359A5C4A6A1830")
    
public abstract void verify(PublicKey key)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException;

    /**
     * Verifies this CRL by verifying that this CRL was signed with the
     * corresponding private key to the specified public key. The signature
     * verification engine of the specified provider will be used.
     *
     * @param key
     *            the public key to verify this CRL with.
     * @param sigProvider
     *            the name of the provider for the signature algorithm.
     * @throws CRLException
     *             if encoding decoding fails.
     * @throws NoSuchAlgorithmException
     *             if a needed algorithm is not present.
     * @throws InvalidKeyException
     *             if the specified key is invalid.
     * @throws NoSuchProviderException
     *             if the specified provider cannot be found.
     * @throws SignatureException
     *             if errors occur on signatures.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.717 -0500", hash_original_method = "F5C4428A675377EFB261A3C66620C5AB", hash_generated_method = "034BA3499E0EC952183AB0E404914D97")
    
public abstract void verify(PublicKey key, String sigProvider)
                     throws CRLException, NoSuchAlgorithmException,
                            InvalidKeyException, NoSuchProviderException,
                            SignatureException;

    /**
     * Returns the version number of this CRL.
     *
     * @return the version number of this CRL.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.720 -0500", hash_original_method = "C9D69CCD70755B0B4C79B91112E497F0", hash_generated_method = "9A237F250BD641E6638839B83E2CCDA2")
    
public abstract int getVersion();

    /**
     * <b>Do not use</b>, use {@link #getIssuerX500Principal()} instead. Returns
     * the issuer as an implementation specific Principal object.
     *
     * @return the issuer distinguished name.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.722 -0500", hash_original_method = "CFD4B1AB5457E8D83BA71C1E3C629BC8", hash_generated_method = "9C5A2933970D035DEBB544066AFA6660")
    
public abstract Principal getIssuerDN();

    /**
     * Returns the issuer distinguished name of this CRL.
     *
     * @return the issuer distinguished name of this CRL.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.724 -0500", hash_original_method = "7A37B67299F05C8453FDB868F4BBC1A9", hash_generated_method = "0C1DA724CAD73B39289F6DD3E807E893")
    
public X500Principal getIssuerX500Principal() {
        try {
            // TODO if there is no X.509 certificate provider installed
            // should we try to access Harmony X509CRLImpl via classForName?
            CertificateFactory factory = CertificateFactory
                    .getInstance("X.509");

            X509CRL crl = (X509CRL) factory
                    .generateCRL(new ByteArrayInputStream(getEncoded()));

            return crl.getIssuerX500Principal();

        } catch (Exception e) {
            throw new RuntimeException("Failed to get X500Principal issuer", e);
        }
    }

    /**
     * Returns the {@code thisUpdate} value of this CRL.
     *
     * @return the {@code thisUpdate} value of this CRL.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.727 -0500", hash_original_method = "329F7AD22906AF13491758C4D60D1586", hash_generated_method = "BD3C57B4DCACA5E60B09F0348A780A6C")
    
public abstract Date getThisUpdate();

    /**
     * Returns the {@code nextUpdate} value of this CRL.
     *
     * @return the {@code nextUpdate} value of this CRL, or {@code null} if none
     *         is present.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.729 -0500", hash_original_method = "7E39B043FA4E91F04C1A59DEF5EF7ED8", hash_generated_method = "6C528658AFA4AC8C14A8A0B49D7A774D")
    
public abstract Date getNextUpdate();

    /**
     * Returns the CRL entry with the specified certificate serial number.
     *
     * @param serialNumber
     *            the certificate serial number to search for a CRL entry.
     * @return the entry for the specified certificate serial number, or {@code
     *         null} if not found.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.733 -0500", hash_original_method = "D31D5CE2614B8CB03FC1AE0FD73EB17D", hash_generated_method = "1878E3AD6D9845B6C4312DCA212EE452")
    
public abstract X509CRLEntry getRevokedCertificate(BigInteger serialNumber);

    /**
     * Returns the CRL entry for the specified certificate.
     *
     * @param certificate
     *            the certificate to search a CRL entry for.
     * @return the entry for the specified certificate, or {@code null} if not
     *         found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.735 -0500", hash_original_method = "22BEF0D3299982E1A7A804A3A397C4D3", hash_generated_method = "244D5B2EFE48A3E86D985C34D40B6DBE")
    
public X509CRLEntry getRevokedCertificate(X509Certificate certificate) {
        if (certificate == null) {
            throw new NullPointerException();
        }
        return getRevokedCertificate(certificate.getSerialNumber());
    }

    /**
     * Returns the set of revoked certificates.
     *
     * @return the set of revoked certificates, or {@code null} if no revoked
     *         certificates are in this CRL.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.738 -0500", hash_original_method = "65F4C8D14BD7D209CEA2530A7F5087EF", hash_generated_method = "CEF2A9D13024E8592BBB240239E6409F")
    
public abstract Set<? extends X509CRLEntry> getRevokedCertificates();

    /**
     * Returns the {@code tbsCertList} information of this CRL in DER encoded
     * form.
     *
     * @return the CRL information in DER encoded form.
     * @throws CRLException
     *             if encoding fails.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.740 -0500", hash_original_method = "FD0D7957F15CC3ACDF69B469057EFEF5", hash_generated_method = "1BE0EA0F40662486B2B84E45F8E433B2")
    
public abstract byte[] getTBSCertList() throws CRLException;

    /**
     * Returns the signature bytes of this CRL.
     *
     * @return the signature bytes of this CRL.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.743 -0500", hash_original_method = "2A6A081097CE32B58420C722B3CF0653", hash_generated_method = "EE84B78CECA9DEC244E6765A7A5D9557")
    
public abstract byte[] getSignature();

    /**
     * Returns the name of the signature algorithm.
     *
     * @return the name of the signature algorithm.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.745 -0500", hash_original_method = "216D3E1A498593B7D7EABB101D467822", hash_generated_method = "CB43224098008E13522F8ACD3701FF8F")
    
public abstract String getSigAlgName();

    /**
     * Returns the OID of the signature algorithm.
     *
     * @return the OID of the signature algorithm.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.747 -0500", hash_original_method = "9620CC2E45D9ACF043D9721699346668", hash_generated_method = "0BDD2E502B8E1AFA50ACBBDB644FEF8E")
    
public abstract String getSigAlgOID();

    /**
     * Returns the parameters of the signature algorithm in DER encoded form.
     *
     * @return the parameters of the signature algorithm in DER encoded form, or
     *         {@code null} if not present.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:58.750 -0500", hash_original_method = "894442A9DD60EB8EA7F18DCBD364CD81", hash_generated_method = "0ED228DA803094562287FBBA6821152B")
    
public abstract byte[] getSigAlgParams();
    
}

