package org.apache.harmony.security.utils;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.Signature;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.376 -0400", hash_original_method = "B6197909D06817D0ED3AF1F2E96CC03C", hash_generated_method = "B6197909D06817D0ED3AF1F2E96CC03C")
        public JarUtils ()
    {
    }


        public static Certificate[] verifySignature(InputStream signature, InputStream
            signatureBlock) throws IOException, GeneralSecurityException {
        BerInputStream bis = new BerInputStream(signatureBlock);
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
        X500Principal issuer = sigInfo.getIssuer();
        BigInteger snum = sigInfo.getSerialNumber();
        int issuerSertIndex = 0;
        for (i = 0; i < certs.length; i++) {
            if (issuer.equals(certs[i].getIssuerDN()) &&
                    snum.equals(certs[i].getSerialNumber())) {
                issuerSertIndex = i;
                break;
            }
        }
        if (i == certs.length) { 
            return null;
        }
        if (certs[issuerSertIndex].hasUnsupportedCriticalExtension()) {
            throw new SecurityException("Can not recognize a critical extension");
        }
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
        List<AttributeTypeAndValue> atr = sigInfo.getAuthenticatedAttributes();
        byte[] sfBytes = new byte[signature.available()];
        signature.read(sfBytes);
        if (atr == null) {
            sig.update(sfBytes);
        } else {
            sig.update(sigInfo.getEncodedAuthenticatedAttributes());
            byte[] existingDigest = null;
            for (AttributeTypeAndValue a : atr) {
                if (Arrays.equals(a.getType().getOid(), MESSAGE_DIGEST_OID)) {
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
        return createChain(certs[issuerSertIndex], certs);
    }

    
        private static X509Certificate[] createChain(X509Certificate  signer, X509Certificate[] candidates) {
        LinkedList chain = new LinkedList();
        chain.add(0, signer);
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

    
        private static X509Certificate findCert(Principal issuer, X509Certificate[] candidates) {
        for (int i = 0; i < candidates.length; i++) {
            if (issuer.equals(candidates[i].getSubjectDN())) {
                return candidates[i];
            }
        }
        return null;
    }

    
    private static final int[] MESSAGE_DIGEST_OID =
        new int[] {1, 2, 840, 113549, 1, 9, 4};
}

