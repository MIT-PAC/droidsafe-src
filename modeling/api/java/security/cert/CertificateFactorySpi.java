package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CertificateFactorySpi {

    /**
     * Constructs a new instance of this class.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.657 -0500", hash_original_method = "5D6CCD92AEFDD2109C84465ED1C78995", hash_generated_method = "CB7D73E8C74A00833A1DB1F47F6A7107")
    
public CertificateFactorySpi() {
    }

    /**
     * Generates and initializes a {@code Certificate} from the provided input
     * stream.
     *
     * @param inStream
     *            the stream from which the data is read to create the
     *            certificate.
     * @return an initialized certificate.
     * @exception CertificateException
     *                if parsing problems are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.660 -0500", hash_original_method = "6250586A2416CA0D958CE1FED5D56F11", hash_generated_method = "2006AF8689DE20455B64C85A61ED065E")
    
public abstract Certificate engineGenerateCertificate(InputStream inStream)
            throws CertificateException;

    /**
     * Generates and initializes a collection of certificates from the provided
     * input stream.
     *
     * @param inStream
     *            the stream from where data is read to create the certificates.
     * @return a collection of certificates.
     * @exception CertificateException
     *                if parsing problems are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.662 -0500", hash_original_method = "C98A5E0C086FF0EA46A70DE403C9B7B6", hash_generated_method = "2152B5EB07E3DE291702833E914FD335")
    
public abstract Collection<? extends Certificate>
        engineGenerateCertificates(InputStream inStream) throws CertificateException;

    /**
     * Generates and initializes a <i>Certificate Revocation List</i> (CRL) from
     * the provided input stream.
     *
     * @param inStream
     *            the stream from where data is read to create the CRL.
     * @return an CRL instance.
     * @exception CRLException
     *                if parsing problems are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.664 -0500", hash_original_method = "D86BB6441FBCD789BFDFD55777C4D377", hash_generated_method = "40B61B56537588F737066AA3DA0C2A92")
    
public abstract CRL engineGenerateCRL(InputStream inStream)
            throws CRLException;

    /**
     * Generates and initializes a collection of <i>Certificate Revocation
     * List</i> (CRL) from the provided input stream.
     *
     * @param inStream
     *            the stream from which the data is read to create the CRLs.
     * @return a collection of CRLs.
     * @exception CRLException
     *                if parsing problems are detected.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.667 -0500", hash_original_method = "EC440E2CD456EA99D8FFD29CCF8B2AEB", hash_generated_method = "AABE80498BFFAC969ECACCFC0F92CC1D")
    
public abstract Collection<? extends CRL>
        engineGenerateCRLs(InputStream inStream) throws CRLException;

    /**
     * Generates a {@code CertPath} from the provided {@code InputStream}. The
     * default encoding scheme is applied.
     *
     * @param inStream
     *            an input stream with encoded data.
     * @return a {@code CertPath} initialized from the provided data.
     * @throws CertificateException
     *             if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.669 -0500", hash_original_method = "2C4FAAEF9B20A7D507A4295CE3E76AED", hash_generated_method = "AC6C59E0BE871ABE24456BCEDBF8DB77")
    
public CertPath engineGenerateCertPath(InputStream inStream)
            throws CertificateException {
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a {@code CertPath} from the provided {@code
     * InputStream} in the specified encoding.
     *
     * @param inStream
     *            an input stream containing certificate path data in specified
     *            encoding.
     * @param encoding
     *            the encoding of the data in the input stream.
     * @return a {@code CertPath} initialized from the provided data
     * @throws CertificateException
     *             if parsing problems are detected.
     * @throws UnsupportedOperationException
     *             if the provider does not implement this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.673 -0500", hash_original_method = "CCA28EB94758BBDA1626E2C95F3A6CB6", hash_generated_method = "71A5BBC1F39E1C1E77BCA3A99CC03ED0")
    
public CertPath engineGenerateCertPath(InputStream inStream, String encoding)
            throws CertificateException {
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a {@code CertPath} from the provided list of certificates. The
     * encoding is the default encoding.
     *
     * @param certificates
     *            the list containing certificates in a format supported by the
     *            {@code CertificateFactory}.
     * @return a {@code CertPath} initialized from the provided data.
     * @throws CertificateException
     *             if parsing problems are detected.
     * @throws UnsupportedOperationException
     *             if the provider does not implement this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.675 -0500", hash_original_method = "3277FA5FC53B837612594B707D8CC5BB", hash_generated_method = "DA33604706A418F7B22986D03A3DD406")
    
public CertPath engineGenerateCertPath(List<? extends Certificate>  certificates)
            throws CertificateException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns an {@code Iterator} over the supported {@code CertPath} encodings
     * (as Strings). The first element is the default encoding.
     *
     * @return an iterator over supported {@code CertPath} encodings (as
     *         Strings).
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:59.677 -0500", hash_original_method = "D60EF50967AE5C5FE3CD2559F27951D5", hash_generated_method = "1CA69DF50450DA8AB9EA04C7BC236B79")
    
public Iterator<String> engineGetCertPathEncodings() {
        throw new UnsupportedOperationException();
    }
    
}

