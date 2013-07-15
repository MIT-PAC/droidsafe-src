package java.security.cert;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.640 -0400", hash_original_method = "5D6CCD92AEFDD2109C84465ED1C78995", hash_generated_method = "C286B4EE0E22EDBF9018054D79D5D19E")
    public  CertificateFactorySpi() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.641 -0400", hash_original_method = "2C4FAAEF9B20A7D507A4295CE3E76AED", hash_generated_method = "052E05945B923CC96D855E4CC31F3383")
    public CertPath engineGenerateCertPath(InputStream inStream) throws CertificateException {
        addTaint(inStream.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1417462253 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1417462253.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1417462253;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.641 -0400", hash_original_method = "CCA28EB94758BBDA1626E2C95F3A6CB6", hash_generated_method = "6FC42BF461E5EB34CE369DF5F43DBAAD")
    public CertPath engineGenerateCertPath(InputStream inStream, String encoding) throws CertificateException {
        addTaint(encoding.getTaint());
        addTaint(inStream.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1023970147 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1023970147.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1023970147;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.641 -0400", hash_original_method = "3277FA5FC53B837612594B707D8CC5BB", hash_generated_method = "97312ACB42EDA97E7E7CCD1CED14DC2D")
    public CertPath engineGenerateCertPath(List<? extends Certificate>  certificates) throws CertificateException {
        addTaint(certificates.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_914371496 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_914371496.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_914371496;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.642 -0400", hash_original_method = "D60EF50967AE5C5FE3CD2559F27951D5", hash_generated_method = "F5B20E1A071F75A4F63968DD55C73F99")
    public Iterator<String> engineGetCertPathEncodings() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1254601344 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1254601344.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1254601344;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

