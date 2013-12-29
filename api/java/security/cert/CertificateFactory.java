package java.security.cert;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.harmony.security.fortress.Engine;






public class CertificateFactory {

    /**
     * Creates a new {@code CertificateFactory} instance that provides the
     * requested certificate type.
     *
     * @param type
     *            the certificate type.
     * @return the new {@code CertificateFactory} instance.
     * @throws CertificateException
     *             if the specified certificate type is not available at any
     *             installed provider.
     * @throws NullPointerException if {@code type == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.487 -0500", hash_original_method = "4AD7FAA844427F176B8B65D577E52F93", hash_generated_method = "87D3B2169C00645004EE6002962939F6")
    public static final CertificateFactory getInstance(String type)
            throws CertificateException {
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Engine.SpiAndProvider sap = ENGINE.getInstance(type, null);
            return new CertificateFactory((CertificateFactorySpi) sap.spi, sap.provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }

    /**
     * Creates a new {@code CertificateFactory} instance from the specified
     * provider that provides the requested certificate type.
     *
     * @param type
     *            the certificate type.
     * @param provider
     *            the name of the provider providing certificates of the
     *            specified type.
     * @return the new {@code CertificateFactory} instance.
     * @throws CertificateException
     *             if the specified certificate type is not available by the
     *             specified provider.
     * @throws NoSuchProviderException
     *             if no provider with the specified name can be found.
     * @throws IllegalArgumentException if {@code provider == null || provider.isEmpty()}
     * @throws NullPointerException
     *             it {@code type} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.488 -0500", hash_original_method = "8516850578A03892E88112705C313FAD", hash_generated_method = "7918DBFDD3E629F72077CF0ECDDBD807")
    public static final CertificateFactory getInstance(String type,
            String provider) throws CertificateException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(type, impProvider);
    }

    /**
     * Creates a new {@code CertificateFactory} instance from the specified
     * provider that provides the requested certificate type.
     *
     * @param type
     *            the certificate type.
     * @param provider
     *            the name of the provider providing certificates of the
     *            specified type.
     * @return the new {@code CertificateFactory} instance.
     * @throws CertificateException
     *             if the specified certificate type is not available at the
     *             specified provider.
     * @throws IllegalArgumentException
     *             if the specified provider is {@code null}.
     * @throws NullPointerException if {@code type == null}
     * @throws IllegalArgumentException if {@code provider == null}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.489 -0500", hash_original_method = "5A73DDBD4164B592F1D7657222558E65", hash_generated_method = "148B2F0E6CCE90FEBAF4EBBBA3C5CA46")
    public static final CertificateFactory getInstance(String type,
            Provider provider) throws CertificateException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (type == null) {
            throw new NullPointerException();
        }
        try {
            Object spi = ENGINE.getInstance(type, provider, null);
            return new CertificateFactory((CertificateFactorySpi) spi, provider, type);
        } catch (NoSuchAlgorithmException e) {
            throw new CertificateException(e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.481 -0500", hash_original_field = "91D59D0E3FA22017ECC2DD4FE8A893A4", hash_generated_field = "A66EAB910E2080B86DC151E0E257CE68")

    private static final String SERVICE = "CertificateFactory";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.482 -0500", hash_original_field = "17F86B5CB94419D7D346BC8D1B101EA5", hash_generated_field = "0CDCB796C7211B2802F60DAA409FC065")

    private static final Engine ENGINE = new Engine(SERVICE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.483 -0500", hash_original_field = "70389BF55D92237F4948951640719A18", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private  Provider provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.484 -0500", hash_original_field = "F816EB69C9D1C2CF02F3A29C789D5552", hash_generated_field = "B931F49514C7C80BDCB99D7936A2923D")

    private  CertificateFactorySpi spiImpl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.485 -0500", hash_original_field = "1B03D0EF3E71EB350936336F82D5E0C5", hash_generated_field = "AB2C9E2EF2C4EBDBF6BF18A679B45B62")

    private  String type;

    /**
     * Creates a new {@code CertificateFactory} instance.
     *
     * @param certFacSpi
     *            the implementation delegate.
     * @param provider
     *            the associated provider.
     * @param type
     *            the certificate type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.486 -0500", hash_original_method = "8F22BB9FD67741B57F6E16F313DC406A", hash_generated_method = "5DD04C865CFD5A8DB8CFCB510BE20266")
    protected CertificateFactory(CertificateFactorySpi certFacSpi,
            Provider provider, String type) {
        this.provider = provider;
        this.type = type;
        this.spiImpl = certFacSpi;
    }

    /**
     * Returns the {@code Provider} of the certificate factory represented by
     * the certificate.
     *
     * @return the provider of this certificate factory.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.490 -0500", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "443000CF13C77ABCABFC8B67E2DE556F")
    public final Provider getProvider() {
        return provider;
    }

    /**
     * Returns the Certificate type.
     *
     * @return type of certificate being used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.491 -0500", hash_original_method = "0E0B07C7C3039087C9D268CAF8DACC19", hash_generated_method = "B5025B3379E65F477B29B0C5C8B783DF")
    public final String getType() {
        return type;
    }

    /**
     * Generates and initializes a {@code Certificate} from the provided input
     * stream.
     *
     * @param inStream
     *            the stream from where data is read to create the {@code
     *            Certificate}.
     * @return an initialized Certificate.
     * @throws CertificateException
     *             if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.492 -0500", hash_original_method = "056686B78E96E8E09F6472D6283D322E", hash_generated_method = "0444684966816F1C38BE82369A0C5646")
    public final Certificate generateCertificate(InputStream inStream)
            throws CertificateException {
        return spiImpl.engineGenerateCertificate(inStream);
    }

    /**
     * Returns an {@code Iterator} over the supported {@code CertPath} encodings
     * (as Strings). The first element is the default encoding scheme to apply.
     *
     * @return an iterator over supported {@link CertPath} encodings (as
     *         Strings).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.493 -0500", hash_original_method = "E0154FCC8B9DF343492D74548A8DABBF", hash_generated_method = "95471670040F9731176EC96070384C81")
    public final Iterator<String> getCertPathEncodings() {
        return spiImpl.engineGetCertPathEncodings();
    }

    /**
     * Generates a {@code CertPath} (a certificate chain) from the provided
     * {@code InputStream}. The default encoding scheme is applied.
     *
     * @param inStream
     *            {@code InputStream} with encoded data.
     * @return a {@code CertPath} initialized from the provided data.
     * @throws CertificateException
     *             if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.494 -0500", hash_original_method = "3A334BAABFC8F8F07B1C887BAAF7ABEE", hash_generated_method = "39FFEE8E6A55FA04CEED8DBE066F23F7")
    public final CertPath generateCertPath(InputStream inStream) throws CertificateException {
        Iterator<String> it = getCertPathEncodings();
        if (!it.hasNext()) {
            throw new CertificateException("There are no CertPath encodings");
        }
        return spiImpl.engineGenerateCertPath(inStream, it.next());
    }

    /**
     * Generates a {@code CertPath} (a certificate chain) from the provided
     * {@code InputStream} and the specified encoding scheme.
     *
     * @param inStream
     *            {@code InputStream} containing certificate path data in
     *            specified encoding.
     * @param encoding
     *            encoding of the data in the input stream.
     * @return a {@code CertPath} initialized from the provided data.
     * @throws CertificateException
     *             if parsing problems are detected.
     * @throws UnsupportedOperationException
     *             if the provider does not implement this method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.495 -0500", hash_original_method = "2B5CC92C0290261B5C7A25A0F691CEF6", hash_generated_method = "BD4C94A0745326B90DC6690BD73E65C4")
    public final CertPath generateCertPath(InputStream inStream, String encoding)
            throws CertificateException {
        return spiImpl.engineGenerateCertPath(inStream, encoding);
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.495 -0500", hash_original_method = "FE6370346FB92E14C140A17484E61066", hash_generated_method = "48452F19DB0CD40F8E00E22CA8F4AF85")
    public final CertPath generateCertPath(List<? extends Certificate> certificates)
            throws CertificateException {
        return spiImpl.engineGenerateCertPath(certificates);
    }

    /**
     * Generates and initializes a collection of (unrelated) certificates from
     * the provided input stream.
     *
     * @param inStream
     *            the stream from which the data is read to create the
     *            collection.
     * @return an initialized collection of certificates.
     * @throws CertificateException
     *             if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.496 -0500", hash_original_method = "2C42C184C3EAF19809C332EBF46CD8DC", hash_generated_method = "3835A6A016D70AAB4CCE556486752FB7")
    public final Collection<? extends Certificate> generateCertificates(InputStream inStream)
            throws CertificateException {
        return spiImpl.engineGenerateCertificates(inStream);
    }

    /**
     * Generates and initializes a <i>Certificate Revocation List</i> (CRL) from
     * the provided input stream.
     *
     * @param inStream
     *            the stream from where data is read to create the CRL.
     * @return an initialized CRL.
     * @exception CRLException
     *                if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.497 -0500", hash_original_method = "61C041CED79E728E684417F700AE9F1B", hash_generated_method = "DE4CAF8E51A5F2419171F98B28019BB8")
    public final CRL generateCRL(InputStream inStream) throws CRLException {
        return spiImpl.engineGenerateCRL(inStream);
    }

    /**
     * Generates and initializes a collection of <i>Certificate Revocation
     * List</i> (CRL) from the provided input stream.
     *
     * @param inStream
     *            the stream from which the data is read to create the CRLs.
     * @return an initialized collection of CRLs.
     * @exception CRLException
     *                if parsing problems are detected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:15.498 -0500", hash_original_method = "82C17943BE49A882CA4049864C9D79C5", hash_generated_method = "1CADE1F32E0D1257A23A04EC925B3F76")
    public final Collection<? extends CRL> generateCRLs(InputStream inStream)
            throws CRLException {
        return spiImpl.engineGenerateCRLs(inStream);
    }
}

