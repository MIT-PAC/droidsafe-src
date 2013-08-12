package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.security.cert.CRLException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.x509.TBSCertList;
import org.bouncycastle.asn1.x509.TBSCertificateStructure;



public class PrincipalUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.268 -0400", hash_original_method = "86E544B1F15763FE29D0BFED0D83B178", hash_generated_method = "86E544B1F15763FE29D0BFED0D83B178")
    public PrincipalUtil ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static X509Principal getIssuerX509Principal(
        X509Certificate cert) throws CertificateEncodingException {
        try
        {
            TBSCertificateStructure tbsCert = TBSCertificateStructure.getInstance(
                    ASN1Object.fromByteArray(cert.getTBSCertificate()));
            return new X509Principal(tbsCert.getIssuer());
        }
        catch (IOException e)
        {
            throw new CertificateEncodingException(e.toString());
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static X509Principal getSubjectX509Principal(
        X509Certificate cert) throws CertificateEncodingException {
        try
        {
            TBSCertificateStructure tbsCert = TBSCertificateStructure.getInstance(
                    ASN1Object.fromByteArray(cert.getTBSCertificate()));
            return new X509Principal(tbsCert.getSubject());
        }
        catch (IOException e)
        {
            throw new CertificateEncodingException(e.toString());
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static X509Principal getIssuerX509Principal(
        X509CRL crl) throws CRLException {
        try
        {
            TBSCertList tbsCertList = TBSCertList.getInstance(
                ASN1Object.fromByteArray(crl.getTBSCertList()));
            return new X509Principal(tbsCertList.getIssuer());
        }
        catch (IOException e)
        {
            throw new CRLException(e.toString());
        }
    }

    
}

