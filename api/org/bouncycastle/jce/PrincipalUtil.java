package org.bouncycastle.jce;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    /**
     * return the issuer of the given cert as an X509PrincipalObject.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.856 -0500", hash_original_method = "166B775807CA9630825F040ACD22C9D9", hash_generated_method = "D39C91FCF949AC8D833106517D990ED0")
    
public static X509Principal getIssuerX509Principal(
        X509Certificate cert)
        throws CertificateEncodingException
    {
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

    /**
     * return the subject of the given cert as an X509PrincipalObject.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.858 -0500", hash_original_method = "17329EDB7F3F6379048AC3576BCE6002", hash_generated_method = "6F8E3AC677B96539AE758CF4537940FF")
    
public static X509Principal getSubjectX509Principal(
        X509Certificate cert)
        throws CertificateEncodingException
    {
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
    
    /**
     * return the issuer of the given CRL as an X509PrincipalObject.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.861 -0500", hash_original_method = "D1923EE98321556672BA5B09F8556462", hash_generated_method = "F97153EC819B44D798CD3EE04AF742A9")
    
public static X509Principal getIssuerX509Principal(
        X509CRL crl)
        throws CRLException
    {
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
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.268 -0400", hash_original_method = "86E544B1F15763FE29D0BFED0D83B178", hash_generated_method = "86E544B1F15763FE29D0BFED0D83B178")
    public PrincipalUtil ()
    {
        //Synthesized constructor
    }
    
}

