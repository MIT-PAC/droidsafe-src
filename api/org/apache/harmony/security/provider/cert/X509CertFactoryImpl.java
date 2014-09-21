/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Alexander Y. Kleymenov
* @version $Revision$
*/

package org.apache.harmony.security.provider.cert;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import libcore.io.Base64;
import libcore.io.Streams;
import org.apache.harmony.security.asn1.ASN1Constants;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.pkcs7.ContentInfo;
import org.apache.harmony.security.pkcs7.SignedData;
import org.apache.harmony.security.x509.CertificateList;

/**
 * X509 Certificate Factory Service Provider Interface Implementation.
 * It supports CRLs and Certificates in (PEM) ASN.1 DER encoded form,
 * and Certification Paths in PkiPath and PKCS7 formats.
 * For Certificates and CRLs factory maintains the caching
 * mechanisms allowing to speed up repeated Certificate/CRL
 * generation.
 * @see Cache
 */
public class X509CertFactoryImpl extends CertificateFactorySpi {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.703 -0400", hash_original_field = "A8177664CAC2D9C1D288FAECA9855E52", hash_generated_field = "45C71272E46845913989D77079F05ABA")

    private static final int CERT_CACHE_SEED_LENGTH = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.703 -0400", hash_original_field = "74F4D45AF478CB434B553A61ED05C980", hash_generated_field = "8B28D24CCEA5042B3303F74087838BB1")

    private static final Cache CERT_CACHE = new Cache(CERT_CACHE_SEED_LENGTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.704 -0400", hash_original_field = "B2A217420C2FDF08FCC4A8D7CDC50B1E", hash_generated_field = "005B0F67AEAAEA36120018F4DB298CE6")

    private static final int CRL_CACHE_SEED_LENGTH = 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.705 -0400", hash_original_field = "F152D36213425B27FFA6766AD0921D0F", hash_generated_field = "DA9E1DD4838C47828C6525F51F626E65")

    private static final Cache CRL_CACHE = new Cache(CRL_CACHE_SEED_LENGTH);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.714 -0400", hash_original_field = "45BE8E7C09EA77FDFA458F4D2D543456", hash_generated_field = "C2258F953A9A283DBADE7DC630A56F2C")

    // ------------------------ Staff methods ------------------------------
    // ---------------------------------------------------------------------

    private static final byte[] PEM_BEGIN = "-----BEGIN".getBytes(StandardCharsets.UTF_8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.714 -0400", hash_original_field = "EAACBD8E0EC7A6BF52387E134655166C", hash_generated_field = "4765242E5DA320A4F1D4227518D5CB64")

    private static final byte[] PEM_END = "-----END".getBytes(StandardCharsets.UTF_8);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.715 -0400", hash_original_field = "D760826D1222A12066C1061E41464160", hash_generated_field = "72AAD06215FB7D610E44ADA3E2F98E83")

    private static final byte[] FREE_BOUND_SUFFIX = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.715 -0400", hash_original_field = "856D3332DA3E236E9BC31910073B8325", hash_generated_field = "04AB53F59B31ADC2438E36867DDC0425")

    private static final byte[] CERT_BOUND_SUFFIX = " CERTIFICATE-----".getBytes(StandardCharsets.UTF_8);

    /**
     * Reads the data of specified length from source
     * and returns it as an array.
     * @return the byte array contained read data or
     * null if the stream contains not enough data
     * @throws IOException if some I/O error has been occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.719 -0400", hash_original_method = "2502C66FB29FAFF0F2F046B5ECEC3668", hash_generated_method = "EE721D72F775EB5292443307E088537E")
    
private static byte[] readBytes(InputStream source, int length)
                                                            throws IOException {
        byte[] result = new byte[length];
        for (int i=0; i<length; i++) {
            int bytik = source.read();
            if (bytik == -1) {
                return null;
            }
            result[i] = (byte) bytik;
        }
        return result;
    }

    /**
     * Returns the Certificate object corresponding to the provided encoding.
     * Resulting object is retrieved from the cache
     * if it contains such correspondence
     * and is constructed on the base of encoding
     * and stored in the cache otherwise.
     * @throws IOException if some decoding errors occur
     * (in the case of cache miss).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.720 -0400", hash_original_method = "4331863C21ED162CEC7CA80DF47BAAE2", hash_generated_method = "36D0D1D4E2292302A90CC119791627ED")
    
private static Certificate getCertificate(byte[] encoding)
                                    throws CertificateException, IOException {
        if (encoding.length < CERT_CACHE_SEED_LENGTH) {
            throw new CertificateException("encoding.length < CERT_CACHE_SEED_LENGTH");
        }
        synchronized (CERT_CACHE) {
            long hash = CERT_CACHE.getHash(encoding);
            if (CERT_CACHE.contains(hash)) {
                Certificate res =
                    (Certificate) CERT_CACHE.get(hash, encoding);
                if (res != null) {
                    return res;
                }
            }
            Certificate res = new X509CertImpl(encoding);
            CERT_CACHE.put(hash, encoding, res);
            return res;
        }
    }

    /**
     * Returns the Certificate object corresponding to the encoding provided
     * by the stream.
     * Resulting object is retrieved from the cache
     * if it contains such correspondence
     * and is constructed on the base of encoding
     * and stored in the cache otherwise.
     * @throws IOException if some decoding errors occur
     * (in the case of cache miss).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.721 -0400", hash_original_method = "F2F19E8AFEF53D4BDC13886B6A196F3D", hash_generated_method = "D8930102D725CA5946D4FCFE155AB149")
    
private static Certificate getCertificate(InputStream inStream)
                                    throws CertificateException, IOException {
        synchronized (CERT_CACHE) {
            inStream.mark(CERT_CACHE_SEED_LENGTH);
            // read the prefix of the encoding
            byte[] buff = readBytes(inStream, CERT_CACHE_SEED_LENGTH);
            inStream.reset();
            if (buff == null) {
                throw new CertificateException("InputStream doesn't contain enough data");
            }
            long hash = CERT_CACHE.getHash(buff);
            if (CERT_CACHE.contains(hash)) {
                byte[] encoding = new byte[BerInputStream.getLength(buff)];
                if (encoding.length < CERT_CACHE_SEED_LENGTH) {
                    throw new CertificateException("Bad Certificate encoding");
                }
                Streams.readFully(inStream, encoding);
                Certificate res = (Certificate) CERT_CACHE.get(hash, encoding);
                if (res != null) {
                    return res;
                }
                res = new X509CertImpl(encoding);
                CERT_CACHE.put(hash, encoding, res);
                return res;
            } else {
                inStream.reset();
                Certificate res = new X509CertImpl(inStream);
                CERT_CACHE.put(hash, res.getEncoded(), res);
                return res;
            }
        }
    }

    /**
     * Returns the CRL object corresponding to the provided encoding.
     * Resulting object is retrieved from the cache
     * if it contains such correspondence
     * and is constructed on the base of encoding
     * and stored in the cache otherwise.
     * @throws IOException if some decoding errors occur
     * (in the case of cache miss).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.722 -0400", hash_original_method = "364F7EBDF245D7E3F2B5A5B4C81B7CA6", hash_generated_method = "08A4D9AC734A7E50AE269C036B257ED1")
    
private static CRL getCRL(byte[] encoding)
                                            throws CRLException, IOException {
        if (encoding.length < CRL_CACHE_SEED_LENGTH) {
            throw new CRLException("encoding.length < CRL_CACHE_SEED_LENGTH");
        }
        synchronized (CRL_CACHE) {
            long hash = CRL_CACHE.getHash(encoding);
            if (CRL_CACHE.contains(hash)) {
                X509CRL res = (X509CRL) CRL_CACHE.get(hash, encoding);
                if (res != null) {
                    return res;
                }
            }
            X509CRL res = new X509CRLImpl(encoding);
            CRL_CACHE.put(hash, encoding, res);
            return res;
        }
    }

    /**
     * Returns the CRL object corresponding to the encoding provided
     * by the stream.
     * Resulting object is retrieved from the cache
     * if it contains such correspondence
     * and is constructed on the base of encoding
     * and stored in the cache otherwise.
     * @throws IOException if some decoding errors occur
     * (in the case of cache miss).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.723 -0400", hash_original_method = "6FB536A9BEB7077B9C33083705D8E3E5", hash_generated_method = "42E9DEBFF2DD8F99B1EC23AB2239C6C7")
    
private static CRL getCRL(InputStream inStream)
                                            throws CRLException, IOException {
        synchronized (CRL_CACHE) {
            inStream.mark(CRL_CACHE_SEED_LENGTH);
            byte[] buff = readBytes(inStream, CRL_CACHE_SEED_LENGTH);
            // read the prefix of the encoding
            inStream.reset();
            if (buff == null) {
                throw new CRLException("InputStream doesn't contain enough data");
            }
            long hash = CRL_CACHE.getHash(buff);
            if (CRL_CACHE.contains(hash)) {
                byte[] encoding = new byte[BerInputStream.getLength(buff)];
                if (encoding.length < CRL_CACHE_SEED_LENGTH) {
                    throw new CRLException("Bad CRL encoding");
                }
                Streams.readFully(inStream, encoding);
                CRL res = (CRL) CRL_CACHE.get(hash, encoding);
                if (res != null) {
                    return res;
                }
                res = new X509CRLImpl(encoding);
                CRL_CACHE.put(hash, encoding, res);
                return res;
            } else {
                X509CRL res = new X509CRLImpl(inStream);
                CRL_CACHE.put(hash, res.getEncoded(), res);
                return res;
            }
        }
    }

    /**
     * Default constructor.
     * Creates the instance of Certificate Factory SPI ready for use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.706 -0400", hash_original_method = "9F3FD440525E78908D8AD7BD9995E533", hash_generated_method = "914A6D6A89189E7D58FFE9B559C9E790")
    
public X509CertFactoryImpl() { }

    /**
     * Generates the X.509 certificate from the data in the stream.
     * The data in the stream can be either in ASN.1 DER encoded X.509
     * certificate, or PEM (Base64 encoding bounded by
     * <code>"-----BEGIN CERTIFICATE-----"</code> at the beginning and
     * <code>"-----END CERTIFICATE-----"</code> at the end) representation
     * of the former encoded form.
     *
     * Before the generation the encoded form is looked up in
     * the cache. If the cache contains the certificate with requested encoded
     * form it is returned from it, otherwise it is generated by ASN.1
     * decoder.
     *
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCertificate(InputStream)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.706 -0400", hash_original_method = "9729F67B9F2FEFC1FCC46BDEC3EBFAEA", hash_generated_method = "F14BF4961BC4377A26B87D76A08387A5")
    
public Certificate engineGenerateCertificate(InputStream inStream)
            throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        try {
            if (!inStream.markSupported()) {
                // create the mark supporting wrapper
                inStream = new RestoringInputStream(inStream);
            }
            // mark is needed to recognize the format of the provided encoding
            // (ASN.1 or PEM)
            inStream.mark(1);
            // check whether the provided certificate is in PEM encoded form
            if (inStream.read() == '-') {
                // decode PEM, retrieve CRL
                return getCertificate(decodePEM(inStream, CERT_BOUND_SUFFIX));
            } else {
                inStream.reset();
                // retrieve CRL
                return getCertificate(inStream);
            }
        } catch (IOException e) {
            throw new CertificateException(e);
        }
    }

    /**
     * Generates the collection of the certificates on the base of provided
     * via input stream encodings.
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCertificates(InputStream)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.708 -0400", hash_original_method = "AD50C4AE43C84CAFDA529E78BF7FE7D8", hash_generated_method = "C8CCC8804046A2687F8D3D90AEE56A06")
    
public Collection<? extends Certificate>
            engineGenerateCertificates(InputStream inStream)
                throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        ArrayList<Certificate> result = new ArrayList<Certificate>();
        try {
            if (!inStream.markSupported()) {
                // create the mark supporting wrapper
                inStream = new RestoringInputStream(inStream);
            }
            // if it is PEM encoded form this array will contain the encoding
            // so ((it is PEM) <-> (encoding != null))
            byte[] encoding = null;
            // The following by SEQUENCE ASN.1 tag, used for
            // recognizing the data format
            // (is it PKCS7 ContentInfo structure, X.509 Certificate, or
            // unsupported encoding)
            int second_asn1_tag = -1;
            inStream.mark(1);
            int ch;
            while ((ch = inStream.read()) != -1) {
                // check if it is PEM encoded form
                if (ch == '-') { // beginning of PEM encoding ('-' char)
                    // decode PEM chunk and store its content (ASN.1 encoding)
                    encoding = decodePEM(inStream, FREE_BOUND_SUFFIX);
                } else if (ch == 0x30) { // beginning of ASN.1 sequence (0x30)
                    encoding = null;
                    inStream.reset();
                    // prepare for data format determination
                    inStream.mark(CERT_CACHE_SEED_LENGTH);
                } else { // unsupported data
                    if (result.size() == 0) {
                        throw new CertificateException("Unsupported encoding");
                    } else {
                        // it can be trailing user data,
                        // so keep it in the stream
                        inStream.reset();
                        return result;
                    }
                }
                // Check the data format
                BerInputStream in = (encoding == null)
                                        ? new BerInputStream(inStream)
                                        : new BerInputStream(encoding);
                // read the next ASN.1 tag
                second_asn1_tag = in.next(); // inStream position changed
                if (encoding == null) {
                    // keep whole structure in the stream
                    inStream.reset();
                }
                // check if it is a TBSCertificate structure
                if (second_asn1_tag != ASN1Constants.TAG_C_SEQUENCE) {
                    if (result.size() == 0) {
                        // there were not read X.509 Certificates, so
                        // break the cycle and check
                        // whether it is PKCS7 structure
                        break;
                    } else {
                        // it can be trailing user data,
                        // so return what we already read
                        return result;
                    }
                } else {
                    if (encoding == null) {
                        result.add(getCertificate(inStream));
                    } else {
                        result.add(getCertificate(encoding));
                    }
                }
                // mark for the next iteration
                inStream.mark(1);
            }
            if (result.size() != 0) {
                // some Certificates have been read
                return result;
            } else if (ch == -1) {
                /* No data in the stream, so return the empty collection. */
                return result;
            }
            // else: check if it is PKCS7
            if (second_asn1_tag == ASN1Constants.TAG_OID) {
                // it is PKCS7 ContentInfo structure, so decode it
                ContentInfo info = (ContentInfo)
                    ((encoding != null)
                        ? ContentInfo.ASN1.decode(encoding)
                        : ContentInfo.ASN1.decode(inStream));
                // retrieve SignedData
                SignedData data = info.getSignedData();
                if (data == null) {
                    throw new CertificateException("Invalid PKCS7 data provided");
                }
                List<org.apache.harmony.security.x509.Certificate> certs = data.getCertificates();
                if (certs != null) {
                    for (org.apache.harmony.security.x509.Certificate cert : certs) {
                        result.add(new X509CertImpl(cert));
                    }
                }
                return result;
            }
            // else: Unknown data format
            throw new CertificateException("Unsupported encoding");
        } catch (IOException e) {
            throw new CertificateException(e);
        }
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCRL(InputStream)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.709 -0400", hash_original_method = "831436CC5D0E9675C977595539D23A10", hash_generated_method = "7D61988CBEFC056C6590F5CCC770BD89")
    
public CRL engineGenerateCRL(InputStream inStream)
            throws CRLException {
        if (inStream == null) {
            throw new CRLException("inStream == null");
        }
        try {
            if (!inStream.markSupported()) {
                // Create the mark supporting wrapper
                // Mark is needed to recognize the format
                // of provided encoding form (ASN.1 or PEM)
                inStream = new RestoringInputStream(inStream);
            }
            inStream.mark(1);
            // check whether the provided crl is in PEM encoded form
            if (inStream.read() == '-') {
                // decode PEM, retrieve CRL
                return getCRL(decodePEM(inStream, FREE_BOUND_SUFFIX));
            } else {
                inStream.reset();
                // retrieve CRL
                return getCRL(inStream);
            }
        } catch (IOException e) {
            throw new CRLException(e);
        }
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCRLs(InputStream)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.711 -0400", hash_original_method = "CCE0B5A1A2F33D093089985C27F4EFA1", hash_generated_method = "0AF3410D4282E054D66D45C0737BF508")
    
public Collection<? extends CRL> engineGenerateCRLs(InputStream inStream)
            throws CRLException {
        if (inStream == null) {
            throw new CRLException("inStream == null");
        }
        ArrayList<CRL> result = new ArrayList<CRL>();
        try {
            if (!inStream.markSupported()) {
                inStream = new RestoringInputStream(inStream);
            }
            // if it is PEM encoded form this array will contain the encoding
            // so ((it is PEM) <-> (encoding != null))
            byte[] encoding = null;
            // The following by SEQUENCE ASN.1 tag, used for
            // recognizing the data format
            // (is it PKCS7 ContentInfo structure, X.509 CRL, or
            // unsupported encoding)
            int second_asn1_tag = -1;
            inStream.mark(1);
            int ch;
            while ((ch = inStream.read()) != -1) {
                // check if it is PEM encoded form
                if (ch == '-') { // beginning of PEM encoding ('-' char)
                    // decode PEM chunk and store its content (ASN.1 encoding)
                    encoding = decodePEM(inStream, FREE_BOUND_SUFFIX);
                } else if (ch == 0x30) { // beginning of ASN.1 sequence (0x30)
                    encoding = null;
                    inStream.reset();
                    // prepare for data format determination
                    inStream.mark(CRL_CACHE_SEED_LENGTH);
                } else { // unsupported data
                    if (result.size() == 0) {
                        throw new CRLException("Unsupported encoding");
                    } else {
                        // it can be trailing user data,
                        // so keep it in the stream
                        inStream.reset();
                        return result;
                    }
                }
                // Check the data format
                BerInputStream in = (encoding == null)
                                        ? new BerInputStream(inStream)
                                        : new BerInputStream(encoding);
                // read the next ASN.1 tag
                second_asn1_tag = in.next();
                if (encoding == null) {
                    // keep whole structure in the stream
                    inStream.reset();
                }
                // check if it is a TBSCertList structure
                if (second_asn1_tag != ASN1Constants.TAG_C_SEQUENCE) {
                    if (result.size() == 0) {
                        // there were not read X.509 CRLs, so
                        // break the cycle and check
                        // whether it is PKCS7 structure
                        break;
                    } else {
                        // it can be trailing user data,
                        // so return what we already read
                        return result;
                    }
                } else {
                    if (encoding == null) {
                        result.add(getCRL(inStream));
                    } else {
                        result.add(getCRL(encoding));
                    }
                }
                inStream.mark(1);
            }
            if (result.size() != 0) {
                // the stream was read out
                return result;
            } else if (ch == -1) {
                throw new CRLException("There is no data in the stream");
            }
            // else: check if it is PKCS7
            if (second_asn1_tag == ASN1Constants.TAG_OID) {
                // it is PKCS7 ContentInfo structure, so decode it
                ContentInfo info = (ContentInfo)
                    ((encoding != null)
                        ? ContentInfo.ASN1.decode(encoding)
                        : ContentInfo.ASN1.decode(inStream));
                // retrieve SignedData
                SignedData data = info.getSignedData();
                if (data == null) {
                    throw new CRLException("Invalid PKCS7 data provided");
                }
                List<CertificateList> crls = data.getCRLs();
                if (crls != null) {
                    for (CertificateList crl : crls) {
                        result.add(new X509CRLImpl(crl));
                    }
                }
                return result;
            }
            // else: Unknown data format
            throw new CRLException("Unsupported encoding");
        } catch (IOException e) {
            throw new CRLException(e);
        }
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCertPath(InputStream)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.711 -0400", hash_original_method = "2D3F19323210F336B68C1F52270F7A67", hash_generated_method = "F682D7577EA0B985E2538EBF202BDECB")
    
public CertPath engineGenerateCertPath(InputStream inStream)
            throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        return engineGenerateCertPath(inStream, "PkiPath");
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCertPath(InputStream,String)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.712 -0400", hash_original_method = "E01EABA4D54035A3D9EC3E842D9ABA2F", hash_generated_method = "82F0D5A1A7181E9FBDB045815F53BB0E")
    
public CertPath engineGenerateCertPath(
            InputStream inStream, String encoding) throws CertificateException {
        if (inStream == null) {
            throw new CertificateException("inStream == null");
        }
        if (!inStream.markSupported()) {
            inStream = new RestoringInputStream(inStream);
        }
        try {
            inStream.mark(1);
            int ch;

            // check if it is PEM encoded form
            if ((ch = inStream.read()) == '-') {
                // decode PEM chunk into ASN.1 form and decode CertPath object
                return X509CertPathImpl.getInstance(
                        decodePEM(inStream, FREE_BOUND_SUFFIX), encoding);
            } else if (ch == 0x30) { // ASN.1 Sequence
                inStream.reset();
                // decode ASN.1 form
                return X509CertPathImpl.getInstance(inStream, encoding);
            } else {
                throw new CertificateException("Unsupported encoding");
            }
        } catch (IOException e) {
            throw new CertificateException(e);
        }
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGenerateCertPath(List)
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.713 -0400", hash_original_method = "9585E9B4714CDFA4F6F8514FE3CDC5BA", hash_generated_method = "A99DBC4C7D4B97585AFCF25305D7283A")
    
public CertPath engineGenerateCertPath(List<? extends Certificate> certificates)
            throws CertificateException {
        return new X509CertPathImpl(certificates);
    }

    /**
     * @see java.security.cert.CertificateFactorySpi#engineGetCertPathEncodings()
     * method documentation for more info
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.713 -0400", hash_original_method = "BC7D889385757B7F0FD17716261CCFC9", hash_generated_method = "13FDAA2648AFD928DA0D1E44B9F503D4")
    
public Iterator<String> engineGetCertPathEncodings() {
        return X509CertPathImpl.encodings.iterator();
    }

    /**
     * Method retrieves the PEM encoded data from the stream
     * and returns its decoded representation.
     * Method checks correctness of PEM boundaries. It supposes that
     * the first '-' of the opening boundary has already been read from
     * the stream. So first of all it checks that the leading bytes
     * are equal to "-----BEGIN" boundary prefix. Than if boundary_suffix
     * is not null, it checks that next bytes equal to boundary_suffix
     * + new line char[s] ([CR]LF).
     * If boundary_suffix parameter is null, method supposes free suffix
     * format and skips any bytes until the new line.<br>
     * After the opening boundary has been read and checked, the method
     * read Base64 encoded data until closing PEM boundary is not reached.<br>
     * Than it checks closing boundary - it should start with new line +
     * "-----END" + boundary_suffix. If boundary_suffix is null,
     * any characters are skipped until the new line.<br>
     * After this any trailing new line characters are skipped from the stream,
     * Base64 encoding is decoded and returned.
     * @param inStream the stream containing the PEM encoding.
     * @param boundary_suffix the suffix of expected PEM multipart
     * boundary delimiter.<br>
     * If it is null, that any character sequences are accepted.
     * @throws IOException If PEM boundary delimiter does not comply
     * with expected or some I/O or decoding problems occur.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.717 -0400", hash_original_method = "8F4229A52B3304209FE322C58E01ADF5", hash_generated_method = "C41F82F19584AAF5372B760FE21B1169")
    
private byte[] decodePEM(InputStream inStream, byte[] boundary_suffix)
                                                        throws IOException {
        int ch; // the char to be read
        // check and skip opening boundary delimiter
        // (first '-' is supposed as already read)
        for (int i = 1; i < PEM_BEGIN.length; ++i) {
            if (PEM_BEGIN[i] != (ch = inStream.read())) {
                throw new IOException(
                    "Incorrect PEM encoding: '-----BEGIN"
                    + ((boundary_suffix == null)
                        ? "" : new String(boundary_suffix))
                    + "' is expected as opening delimiter boundary.");
            }
        }
        if (boundary_suffix == null) {
            // read (skip) the trailing characters of
            // the beginning PEM boundary delimiter
            while ((ch = inStream.read()) != '\n') {
                if (ch == -1) {
                    throw new IOException("Incorrect PEM encoding: EOF before content");
                }
            }
        } else {
            for (int i=0; i<boundary_suffix.length; i++) {
                if (boundary_suffix[i] != inStream.read()) {
                    throw new IOException("Incorrect PEM encoding: '-----BEGIN" +
                            new String(boundary_suffix) + "' is expected as opening delimiter boundary.");
                }
            }
            // read new line characters
            if ((ch = inStream.read()) == '\r') {
                // CR has been read, now read LF character
                ch = inStream.read();
            }
            if (ch != '\n') {
                throw new IOException("Incorrect PEM encoding: newline expected after " +
                        "opening delimiter boundary");
            }
        }
        int size = 1024; // the size of the buffer containing Base64 data
        byte[] buff = new byte[size];
        int index = 0;
        // read bytes while ending boundary delimiter is not reached
        while ((ch = inStream.read()) != '-') {
            if (ch == -1) {
                throw new IOException("Incorrect Base64 encoding: EOF without closing delimiter");
            }
            buff[index++] = (byte) ch;
            if (index == size) {
                // enlarge the buffer
                byte[] newbuff = new byte[size+1024];
                System.arraycopy(buff, 0, newbuff, 0, size);
                buff = newbuff;
                size += 1024;
            }
        }
        if (buff[index-1] != '\n') {
            throw new IOException("Incorrect Base64 encoding: newline expected before " +
                    "closing boundary delimiter");
        }
        // check and skip closing boundary delimiter prefix
        // (first '-' was read)
        for (int i = 1; i < PEM_END.length; ++i) {
            if (PEM_END[i] != inStream.read()) {
                throw badEnd(boundary_suffix);
            }
        }
        if (boundary_suffix == null) {
            // read (skip) the trailing characters of
            // the closing PEM boundary delimiter
            while (((ch = inStream.read()) != -1) && (ch != '\n') && (ch != '\r')) {
            }
        } else {
            for (int i=0; i<boundary_suffix.length; i++) {
                if (boundary_suffix[i] != inStream.read()) {
                    throw badEnd(boundary_suffix);
                }
            }
        }
        // skip trailing line breaks
        inStream.mark(1);
        while (((ch = inStream.read()) != -1) && (ch == '\n' || ch == '\r')) {
            inStream.mark(1);
        }
        inStream.reset();
        buff = Base64.decode(buff, index);
        if (buff == null) {
            throw new IOException("Incorrect Base64 encoding");
        }
        return buff;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.718 -0400", hash_original_method = "C54A9AFC82EAFBE0E1F3D93E138D8123", hash_generated_method = "7BAA8AF02AE7EE35C94A7270A1C449BC")
    
private IOException badEnd(byte[] boundary_suffix) throws IOException {
        String s = (boundary_suffix == null) ? "" : new String(boundary_suffix);
        throw new IOException("Incorrect PEM encoding: '-----END" + s + "' is expected as closing delimiter boundary.");
    }

    /*
     * This class extends any existing input stream with
     * mark functionality. It acts as a wrapper over the
     * stream and supports reset to the
     * marked state with readlimit no more than BUFF_SIZE.
     */
    private static class RestoringInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.724 -0400", hash_original_field = "C102B8C229512E5EE3F188B68F0D8085", hash_generated_field = "16599C7186FD0CC4C4FCFE56D26FAD9F")

        // after the mark has been set up
        private static final int BUFF_SIZE = 32;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.724 -0400", hash_original_field = "CE67F8E6759E7AA9F0B2D1B1C622FA48", hash_generated_field = "848E95AB29D035B62B017F39E2191D18")

        private  InputStream inStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.724 -0400", hash_original_field = "F22FBB1DBF00020DE59BEACDDE6965E0", hash_generated_field = "E2C20D272981764D235F318747968801")

        private final int[] buff = new int[BUFF_SIZE*2];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.725 -0400", hash_original_field = "9DBA99389B1E561A787ED19695A15CE3", hash_generated_field = "E71810444DCD5E7FEAECA44F6B9B8233")

        // the value of -1 indicates that the buffer is not used
        // (mark was not set up or was invalidated, or reset to the marked
        // position has been done and all the buffered data was read out)
        private int pos = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.726 -0400", hash_original_field = "F879FB20BF5F01C3E86E273C0D85D0E2", hash_generated_field = "B60EC752663307F0EEA46A4E09871D39")

        private int bar = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.726 -0400", hash_original_field = "9AEC138AA242ABDD95898CF0FF5A924E", hash_generated_field = "CC9A8AAFEBE399C694DFF87772F4911A")

        private int end = 0;

        /**
         * Creates the mark supporting wrapper over the stream.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.727 -0400", hash_original_method = "60DEF30A1190938008A7A3D1CF53CB89", hash_generated_method = "4F1F393B0267F1A2ED77CFC3C824AC0F")
        
public RestoringInputStream(InputStream inStream) {
            this.inStream = inStream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.727 -0400", hash_original_method = "B71DEEEAD399BB0DCF13B0C2AE5A2B98", hash_generated_method = "1F5BB34F0557B17CFCF88CD1C1A2DC1D")
        
@Override
        public int available() throws IOException {
            return (bar - pos) + inStream.available();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.728 -0400", hash_original_method = "85817177915E65173443212CF18FCB04", hash_generated_method = "6A2CEBC2FD0C7B8D31BF0A64C59FC177")
        
@Override
        public void close() throws IOException {
            inStream.close();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.728 -0400", hash_original_method = "1C96C4B088FAA99912B4F35EEBC601A1", hash_generated_method = "0786F2EF1FC644652B8803329FE64409")
        
@Override
        public void mark(int readlimit) {
            if (pos < 0) {
                pos = 0;
                bar = 0;
                end = BUFF_SIZE - 1;
            } else {
                end = (pos + BUFF_SIZE - 1) % BUFF_SIZE;
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.729 -0400", hash_original_method = "3448BF342B33B519FE64A3FA0274077D", hash_generated_method = "8651EC098CD56FF2A595F29537142CD3")
        
@Override
        public boolean markSupported() {
            return true;
        }

        /**
         * Reads the byte from the stream. If mark has been set up
         * and was not invalidated byte is read from the underlying
         * stream and saved into the buffer. If the current read position
         * has been reset to the marked position and there are remaining
         * bytes in the buffer, the byte is taken from it. In the other cases
         * (if mark has been invalidated, or there are no buffered bytes)
         * the byte is taken directly from the underlying stream and it is
         * returned without saving to the buffer.
         *
         * @see java.io.InputStream#read()
         * method documentation for more info
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.729 -0400", hash_original_method = "317FFD5E22779163B9A9FF8F68A90F78", hash_generated_method = "2A98E4C470D4F7C5996C6947A05619B6")
        
public int read() throws IOException {
            // if buffer is currently used
            if (pos >= 0) {
                // current position in the buffer
                int cur = pos % BUFF_SIZE;
                // check whether the buffer contains the data to be read
                if (cur < bar) {
                    // return the data from the buffer
                    pos++;
                    return buff[cur];
                }
                // check whether buffer has free space
                if (cur != end) {
                    // it has, so read the data from the wrapped stream
                    // and place it in the buffer
                    buff[cur] = inStream.read();
                    bar = cur+1;
                    pos++;
                    return buff[cur];
                } else {
                    // buffer if full and can not operate
                    // any more, so invalidate the mark position
                    // and turn off the using of buffer
                    pos = -1;
                }
            }
            // buffer is not used, so return the data from the wrapped stream
            return inStream.read();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.730 -0400", hash_original_method = "2602231C2859D265322E57134E41FCCE", hash_generated_method = "A764B2C20607AC8E0152613D5CA02F67")
        
@Override
        public int read(byte[] b, int off, int len) throws IOException {
            int read_b;
            int i;
            for (i=0; i<len; i++) {
                if ((read_b = read()) == -1) {
                    return (i == 0) ? -1 : i;
                }
                b[off+i] = (byte) read_b;
            }
            return i;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:03.731 -0400", hash_original_method = "786D58C28A20490DD577C7A5F50D32DC", hash_generated_method = "A298AC900E9A0ED809932B5CD8BC1440")
        
@Override
        public void reset() throws IOException {
            if (pos >= 0) {
                pos = (end + 1) % BUFF_SIZE;
            } else {
                throw new IOException("Could not reset the stream: " +
                        "position became invalid or stream has not been marked");
            }
        }
    }
}
