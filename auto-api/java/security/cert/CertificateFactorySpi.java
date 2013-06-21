package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.643 -0400", hash_original_method = "5D6CCD92AEFDD2109C84465ED1C78995", hash_generated_method = "C286B4EE0E22EDBF9018054D79D5D19E")
    @DSModeled(DSC.SAFE)
    public CertificateFactorySpi() {
        // ---------- Original Method ----------
    }

    
    public abstract Certificate engineGenerateCertificate(InputStream inStream)
            throws CertificateException;

    
    public abstract Collection<? extends Certificate>
        engineGenerateCertificates(InputStream inStream) throws CertificateException;

    
    public abstract CRL engineGenerateCRL(InputStream inStream)
            throws CRLException;

    
    public abstract Collection<? extends CRL>
        engineGenerateCRLs(InputStream inStream) throws CRLException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.644 -0400", hash_original_method = "2C4FAAEF9B20A7D507A4295CE3E76AED", hash_generated_method = "6B5F5234AE071F97FBC523EA3274B933")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
        dsTaint.addTaint(inStream.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.644 -0400", hash_original_method = "CCA28EB94758BBDA1626E2C95F3A6CB6", hash_generated_method = "472C7BB6891573B86CFB6F7653F8561B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(inStream.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.644 -0400", hash_original_method = "3277FA5FC53B837612594B707D8CC5BB", hash_generated_method = "50ACA2623C2C991748BFEDE427ED45EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CertPath engineGenerateCertPath(List<? extends Certificate>  certificates) throws CertificateException {
        dsTaint.addTaint(certificates.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (CertPath)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.645 -0400", hash_original_method = "D60EF50967AE5C5FE3CD2559F27951D5", hash_generated_method = "4DCA5275FE4597104C5CB563DC467020")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Iterator<String> engineGetCertPathEncodings() {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        return (Iterator<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

