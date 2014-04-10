package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;
import org.apache.harmony.security.pkcs7.SignedData;
import org.apache.harmony.security.pkcs7.SignerInfo;
import org.apache.harmony.security.provider.cert.X509CertImpl;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSignature;

public class JarUtils {

    /**
     * This method handle all the work with  PKCS7, ASN1 encoding, signature verifying,
     * and certification path building.
     * See also PKCS #7: Cryptographic Message Syntax Standard:
     * http://www.ietf.org/rfc/rfc2315.txt
     * @param signature - the input stream of signature file to be verified
     * @param signatureBlock - the input stream of corresponding signature block file
     * @return array of certificates used to verify the signature file
     * @throws IOException - if some errors occurs during reading from the stream
     * @throws GeneralSecurityException - if signature verification process fails
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.564 -0500", hash_original_method = "BD120DD25E8222693A9ADBDDB2DA9384", hash_generated_method = "65442D82859A19E4CC821E815E314D2D")
    
public static Certificate[] verifySignature(InputStream signature, InputStream
            signatureBlock) throws IOException, GeneralSecurityException {

        Certificate[] certs = new Certificate[1];
        
        certs[0] = new org.apache.harmony.security.provider.cert.X509CertImpl(signature);
        certs[0].addTaint(signatureBlock.getTaint());
        
        return certs;
        
      /*  BerInputStream bis = new BerInputStream(signatureBlock);
        ContentInfo info = (ContentInfo)ContentInfo.ASN1.decode(bis);
        SignedData signedData = info.getSignedData();
        if (signedData == null) {
            throw new IOException("No SignedData found");
        }
        Collection<org.apache.harmony.security.x509.Certificate> encCerts
                = signedData.getCertificates();
        if (encCerts.isEmpty()) {
            return null;
        }
        X509Certificate[] certs = new X509Certificate[encCerts.size()];
        int i = 0;
        for (org.apache.harmony.security.x509.Certificate encCert : encCerts) {
            certs[i++] = new X509CertImpl(encCert);
        }

        List<SignerInfo> sigInfos = signedData.getSignerInfos();
        SignerInfo sigInfo;
        if (!sigInfos.isEmpty()) {
            sigInfo = sigInfos.get(0);
        } else {
            return null;
        }

        // Issuer
        X500Principal issuer = sigInfo.getIssuer();

        // Certificate serial number
        BigInteger snum = sigInfo.getSerialNumber();

        // Locate the certificate
        int issuerSertIndex = 0;
        for (i = 0; i < certs.length; i++) {
            if (issuer.equals(certs[i].getIssuerDN()) &&
                    snum.equals(certs[i].getSerialNumber())) {
                issuerSertIndex = i;
                break;
            }
        }
        if (i == certs.length) { // No issuer certificate found
            return null;
        }

        if (certs[issuerSertIndex].hasUnsupportedCriticalExtension()) {
            throw new SecurityException("Can not recognize a critical extension");
        }

        // Get Signature instance
        Signature sig = null;
        String da = sigInfo.getDigestAlgorithm();
        String dea = sigInfo.getDigestEncryptionAlgorithm();
        String alg = null;
        if (da != null && dea != null) {
            alg = da + "with" +  dea;
            try {
                sig = OpenSSLSignature.getInstance(alg);
            } catch (NoSuchAlgorithmException e) {}
        }
        if (sig == null) {
            alg = da;
            if (alg == null) {
                return null;
            }
            try {
                sig = OpenSSLSignature.getInstance(alg);
            } catch (NoSuchAlgorithmException e) {
                return null;
            }
        }
        sig.initVerify(certs[issuerSertIndex]);

        // If the authenticatedAttributes field of SignerInfo contains more than zero attributes,
        // compute the message digest on the ASN.1 DER encoding of the Attributes value.
        // Otherwise, compute the message digest on the data.
        List<AttributeTypeAndValue> atr = sigInfo.getAuthenticatedAttributes();

        byte[] sfBytes = new byte[signature.available()];
        signature.read(sfBytes);

        if (atr == null) {
            sig.update(sfBytes);
        } else {
            sig.update(sigInfo.getEncodedAuthenticatedAttributes());

            // If the authenticatedAttributes field contains the message-digest attribute,
            // verify that it equals the computed digest of the signature file
            byte[] existingDigest = null;
            for (AttributeTypeAndValue a : atr) {
                if (Arrays.equals(a.getType().getOid(), MESSAGE_DIGEST_OID)) {
//TODO value                    existingDigest = a.AttributeValue;
                }
            }
            if (existingDigest != null) {
                MessageDigest md = MessageDigest.getInstance(sigInfo.getDigestAlgorithm());
                byte[] computedDigest = md.digest(sfBytes);
                if (!Arrays.equals(existingDigest, computedDigest)) {
                    throw new SecurityException("Incorrect MD");
                }
            }
        }

        if (!sig.verify(sigInfo.getEncryptedDigest())) {
            throw new SecurityException("Incorrect signature");
        }

        return createChain(certs[issuerSertIndex], certs);*/
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.568 -0500", hash_original_method = "00820D9D1C06D03E9E9086299A341619", hash_generated_method = "66AC70C53AC724CC98DD695C82DCBF2F")
    
private static X509Certificate[] createChain(X509Certificate  signer, X509Certificate[] candidates) {
        LinkedList chain = new LinkedList();
        chain.add(0, signer);

        // Signer is self-signed
        if (signer.getSubjectDN().equals(signer.getIssuerDN())){
            return (X509Certificate[])chain.toArray(new X509Certificate[1]);
        }

        Principal issuer = signer.getIssuerDN();
        X509Certificate issuerCert;
        int count = 1;
        while (true) {
            issuerCert = findCert(issuer, candidates);
            if( issuerCert == null) {
                break;
            }
            chain.add(issuerCert);
            count++;
            if (issuerCert.getSubjectDN().equals(issuerCert.getIssuerDN())) {
                break;
            }
            issuer = issuerCert.getIssuerDN();
        }
        return (X509Certificate[])chain.toArray(new X509Certificate[count]);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.570 -0500", hash_original_method = "34EEBCFB9983630620133DA22BDE2B4B", hash_generated_method = "6F2C72488FF3B4FA0C845C18D07D3371")
    
private static X509Certificate findCert(Principal issuer, X509Certificate[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (issuer.equals(candidates[i].getSubjectDN())) {
                return candidates[i];
            }
        }
        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:55.560 -0500", hash_original_field = "66B21D9EF5D555CE9FAF254DD5F9C14A", hash_generated_field = "7B3EEB03E75670F328FA64ED3D57A29C")

    // http://www.ietf.org/rfc/rfc2985.txt
    private static final int[] MESSAGE_DIGEST_OID =
        new int[] {1, 2, 840, 113549, 1, 9, 4};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:28.425 -0400", hash_original_method = "C4E6A9DD3A1CC4544C825D59A384053A", hash_generated_method = "C4E6A9DD3A1CC4544C825D59A384053A")
    public JarUtils ()
    {
        //Synthesized constructor
    }
    
    private static class DummyCertificate extends Certificate {

        protected DummyCertificate(String type) {
            super(type);
            // TODO Auto-generated constructor stub
        }

        @Override
        @DSSafe(DSCat.SAFE_OTHERS)
        public byte[] getEncoded() throws CertificateEncodingException {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        @DSComment("Abstract Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        public void verify(PublicKey key) throws CertificateException,
                NoSuchAlgorithmException, InvalidKeyException,
                NoSuchProviderException, SignatureException {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.490 -0500", hash_original_method = "206D0A21D5BAE0F83A1719C1D14A7E35", hash_generated_method = "D17B985B54E602C77696D4D138B8890E")
        public void verify(PublicKey key, String sigProvider)
                throws CertificateException, NoSuchAlgorithmException,
                InvalidKeyException, NoSuchProviderException,
                SignatureException {
            // TODO Auto-generated method stub
            
        }

        @Override
        @DSSafe(DSCat.SAFE_OTHERS)
        public String toString() {
            // TODO Auto-generated method stub
            return new String(taint);
        }

        @Override
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.495 -0500", hash_original_method = "F2C717FDFBF8A1EA046A033A3AA9C5CC", hash_generated_method = "D544FA3197F301F074C9140DD12C3EA0")
        public PublicKey getPublicKey() {
            // TODO Auto-generated method stub
            return null;
        }
        
    }
}

