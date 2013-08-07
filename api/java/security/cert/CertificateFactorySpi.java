package java.security.cert;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;





public abstract class CertificateFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.734 -0400", hash_original_method = "5D6CCD92AEFDD2109C84465ED1C78995", hash_generated_method = "C286B4EE0E22EDBF9018054D79D5D19E")
    public  CertificateFactorySpi() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Certificate engineGenerateCertificate(InputStream inStream)
            throws CertificateException;

    
    @DSModeled(DSC.SAFE)
    public abstract Collection<? extends Certificate>
        engineGenerateCertificates(InputStream inStream) throws CertificateException;

    
    @DSModeled(DSC.SAFE)
    public abstract CRL engineGenerateCRL(InputStream inStream)
            throws CRLException;

    
    @DSModeled(DSC.SAFE)
    public abstract Collection<? extends CRL>
        engineGenerateCRLs(InputStream inStream) throws CRLException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.734 -0400", hash_original_method = "2C4FAAEF9B20A7D507A4295CE3E76AED", hash_generated_method = "53EC1830F6C55DA56D6A5F775B3BC90E")
    public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
        addTaint(inStream.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_936855655 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_936855655.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_936855655;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.735 -0400", hash_original_method = "CCA28EB94758BBDA1626E2C95F3A6CB6", hash_generated_method = "A8DA455EF3F51C83FB09D2D19FEADD12")
    public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
        addTaint(encoding.getTaint());
        addTaint(inStream.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_793001782 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_793001782.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_793001782;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.735 -0400", hash_original_method = "3277FA5FC53B837612594B707D8CC5BB", hash_generated_method = "AAE71896DFEC37B4D70FBCAEDE319B38")
    public CertPath engineGenerateCertPath(List<? extends Certificate>  certificates) throws CertificateException {
        addTaint(certificates.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_109548654 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_109548654.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_109548654;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.735 -0400", hash_original_method = "D60EF50967AE5C5FE3CD2559F27951D5", hash_generated_method = "F3EAE62E30329433531199EAC4C53701")
    public Iterator<String> engineGetCertPathEncodings() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1152733511 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1152733511.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1152733511;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

