package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLException;
import javax.security.auth.x500.X500Principal;

import libcore.io.Memory;




import droidsafe.helpers.DSUtils;

public final class NativeCrypto {


    @DSModeled(DSC.SAFE)
    private static void clinit() {
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_PKEY_new_DSA(byte[] p, byte[] q, byte[] g,
                                              byte[] priv_key, byte[] pub_key) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865609011 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_865609011;
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_PKEY_new_RSA(byte[] n, byte[] e, byte[] d, byte[] p, byte[] q) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232903658 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_232903658;
    }

    
    @DSModeled(DSC.SAFE)
    public static void EVP_PKEY_free(int pkey) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_get_digestbyname(String name) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067004612 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1067004612;
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_MD_size(int evp_md) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371314546 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_371314546;
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_MD_block_size(int evp_md) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519226683 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1519226683;
    }

    
    @DSModeled(DSC.SAFE)
    public static void EVP_MD_CTX_destroy(int ctx) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_MD_CTX_copy(int ctx) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963314458 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1963314458;
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_DigestInit(int evp_md) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024163460 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024163460;
    }

    
    @DSModeled(DSC.SAFE)
    public static void EVP_DigestUpdate(int ctx, byte[] buffer, int offset, int length) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_DigestFinal(int ctx, byte[] hash, int offset) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668405372 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1668405372;
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_VerifyInit(String algorithm) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134582078 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1134582078;
    }

    
    @DSModeled(DSC.SAFE)
    public static void EVP_VerifyUpdate(int ctx, byte[] buffer,
                                               int offset, int length) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int EVP_VerifyFinal(int ctx, byte[] signature,
                                             int offset, int length, int key) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181030487 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_181030487;
    }

    
    @DSModeled(DSC.SAFE)
    public static void RAND_seed(byte[] seed) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int RAND_load_file(String filename, long max_bytes) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562927099 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_562927099;
    }

    // --- X509_NAME -----------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.679 -0500", hash_original_method = "8B2F1CEC41FBF819685923522CA17444", hash_generated_method = "6B28337E34E82B1D54345B6B5D37280B")
    public static int X509_NAME_hash(X500Principal principal) {
        return X509_NAME_hash(principal, "SHA1");
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.679 -0500", hash_original_method = "C17C757DF3C671578E2AD64FCF45039D", hash_generated_method = "5EBBFB09138D07E3FB0957A866CE746D")
    public static int X509_NAME_hash_old(X500Principal principal) {
        return X509_NAME_hash(principal, "MD5");
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.680 -0500", hash_original_method = "B344D9153FDACF8192135D5EDBC47AE4", hash_generated_method = "96D65C307A3DA21E0664FB2E60F0D2FD")
    private static int X509_NAME_hash(X500Principal principal, String algorithm) {
        try {
            byte[] digest = MessageDigest.getInstance(algorithm).digest(principal.getEncoded());
            return Memory.peekInt(digest, 0, ByteOrder.LITTLE_ENDIAN);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.685 -0500", hash_original_method = "2E5190E56F7FF68ACB3015B0CB8E2A04", hash_generated_method = "4E228C0756CB9FA5C05937BA2FE8210D")
    private static void add(String standard, String openssl) {
        OPENSSL_TO_STANDARD_CIPHER_SUITES.put(openssl, standard);
        STANDARD_TO_OPENSSL_CIPHER_SUITES.put(standard, openssl);
    }

    
    @DSModeled(DSC.SAFE)
    public static int SSL_CTX_new() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499904329 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499904329;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.693 -0500", hash_original_method = "E992C3F3F90B62E0551244900B94B100", hash_generated_method = "3D7DFB78F17D70B3C235908641BBF2B4")
    public static String[] getDefaultCipherSuites() {
        return new String[] {
            "SSL_RSA_WITH_RC4_128_MD5",
            "SSL_RSA_WITH_RC4_128_SHA",
            "TLS_RSA_WITH_AES_128_CBC_SHA",
            "TLS_RSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDH_ECDSA_WITH_RC4_128_SHA",
            "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDH_RSA_WITH_RC4_128_SHA",
            "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",
            "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_RC4_128_SHA",
            "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",
            "TLS_DHE_RSA_WITH_AES_128_CBC_SHA",
            "TLS_DHE_RSA_WITH_AES_256_CBC_SHA",
            "TLS_DHE_DSS_WITH_AES_128_CBC_SHA",
            "TLS_DHE_DSS_WITH_AES_256_CBC_SHA",
            "SSL_RSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA",
            "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",
            "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA",
            "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA",
            "SSL_RSA_WITH_DES_CBC_SHA",
            "SSL_DHE_RSA_WITH_DES_CBC_SHA",
            "SSL_DHE_DSS_WITH_DES_CBC_SHA",
            "SSL_RSA_EXPORT_WITH_RC4_40_MD5",
            "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA",
            "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA",
            TLS_EMPTY_RENEGOTIATION_INFO_SCSV
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.694 -0500", hash_original_method = "441F524A9CDEE2C4724FDD0DDA52219B", hash_generated_method = "E692D155C970F0CFDF25498C8BBE6DF9")
    public static String[] getSupportedCipherSuites() {
        return SUPPORTED_CIPHER_SUITES.clone();
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_CTX_free(int ssl_ctx) {
    }

    
    @DSModeled(DSC.SAFE)
    public static int SSL_new(int ssl_ctx) throws SSLException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431793162 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431793162;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.698 -0500", hash_original_method = "72E122187013708BACCA6AD76CAE16AD", hash_generated_method = "4A31EBD0504003546DBA1D0217827A21")
    public static byte[][] encodeCertificates(Certificate[] certificates)
            throws CertificateEncodingException {
        byte[][] certificateBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            certificateBytes[i] = certificates[i].getEncoded();
        }
        return certificateBytes;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_use_certificate(int ssl, byte[][] asn1DerEncodedCertificateChain) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_use_PrivateKey(int ssl, byte[] pkcs8EncodedPrivateKey) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_check_private_key(int ssl) throws SSLException {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.703 -0500", hash_original_method = "2D6986FABFE74112B0A6ED2D5EFD8130", hash_generated_method = "8766A83D65D1ACCCF510091C76CEC869")
    public static byte[][] encodeIssuerX509Principals(X509Certificate[] certificates)
            throws CertificateEncodingException {
        byte[][] principalBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            principalBytes[i] = certificates[i].getIssuerX500Principal().getEncoded();
        }
        return principalBytes;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_client_CA_list(int ssl, byte[][] asn1DerEncodedX500Principals) {
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_get_mode(int ssl) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_935462345 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_935462345;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_set_mode(int ssl, long mode) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1592410460 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1592410460;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_clear_mode(int ssl, long mode) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1994213698 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1994213698;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_get_options(int ssl) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1351792898 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1351792898;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_set_options(int ssl, long options) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1606611539 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1606611539;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_clear_options(int ssl, long options) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1442836426 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1442836426;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.714 -0500", hash_original_method = "D5492E8CBB49F42F0984D673FB7ACE24", hash_generated_method = "D8B73AE8848BD17996252ED9294BA7A1")
    public static String[] getSupportedProtocols() {
        return new String[] { SUPPORTED_PROTOCOL_SSLV3, SUPPORTED_PROTOCOL_TLSV1 };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.715 -0500", hash_original_method = "88EB0A02E9253501CDB639C0011C0E5E", hash_generated_method = "FE667197C3A8E42ADF2EB3B663665CBD")
    public static void setEnabledProtocols(int ssl, String[] protocols) {
        checkEnabledProtocols(protocols);
        // openssl uses negative logic letting you disable protocols.
        // so first, assume we need to set all (disable all) and clear none (enable none).
        // in the loop, selectively move bits from set to clear (from disable to enable)
        long optionsToSet = (SSL_OP_NO_SSLv3 | SSL_OP_NO_TLSv1);
        long optionsToClear = 0;
        for (int i = 0; i < protocols.length; i++) {
            String protocol = protocols[i];
            if (protocol.equals(SUPPORTED_PROTOCOL_SSLV3)) {
                optionsToSet &= ~SSL_OP_NO_SSLv3;
                optionsToClear |= SSL_OP_NO_SSLv3;
            } else if (protocol.equals(SUPPORTED_PROTOCOL_TLSV1)) {
                optionsToSet &= ~SSL_OP_NO_TLSv1;
                optionsToClear |= SSL_OP_NO_TLSv1;
            } else {
                // error checked by checkEnabledProtocols
                throw new IllegalStateException();
            }
        }

        SSL_set_options(ssl, optionsToSet);
        SSL_clear_options(ssl, optionsToClear);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.716 -0500", hash_original_method = "D751F06ACF4928AF4666FFE186DCE64E", hash_generated_method = "4CB927A9C676B135F760D3349CAA6149")
    public static String[] checkEnabledProtocols(String[] protocols) {
        if (protocols == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        for (int i = 0; i < protocols.length; i++) {
            String protocol = protocols[i];
            if (protocol == null) {
                throw new IllegalArgumentException("protocols[" + i + "] == null");
            }
            if ((!protocol.equals(SUPPORTED_PROTOCOL_SSLV3))
                    && (!protocol.equals(SUPPORTED_PROTOCOL_TLSV1))) {
                throw new IllegalArgumentException("protocol " + protocol
                                                   + " is not supported");
            }
        }
        return protocols;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_cipher_lists(int ssl, String[] ciphers) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.719 -0500", hash_original_method = "590A1411A3915B3F10784B0A83240A94", hash_generated_method = "CA52C070E1F786A7670C7D42B30B4F53")
    public static void setEnabledCipherSuites(int ssl, String[] cipherSuites) {
        checkEnabledCipherSuites(cipherSuites);
        List<String> opensslSuites = new ArrayList<String>();
        for (int i = 0; i < cipherSuites.length; i++) {
            String cipherSuite = cipherSuites[i];
            if (cipherSuite.equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                continue;
            }
            String openssl = STANDARD_TO_OPENSSL_CIPHER_SUITES.get(cipherSuite);
            String cs = (openssl == null) ? cipherSuite : openssl;
            opensslSuites.add(cs);
        }
        SSL_set_cipher_lists(ssl, opensslSuites.toArray(new String[opensslSuites.size()]));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.720 -0500", hash_original_method = "2FECB01C291C5D2D3716483AA9BE1895", hash_generated_method = "1EA25300C2DE328E9440239AA10C4201")
    public static String[] checkEnabledCipherSuites(String[] cipherSuites) {
        if (cipherSuites == null) {
            throw new IllegalArgumentException("cipherSuites == null");
        }
        // makes sure all suites are valid, throwing on error
        for (int i = 0; i < cipherSuites.length; i++) {
            String cipherSuite = cipherSuites[i];
            if (cipherSuite == null) {
                throw new IllegalArgumentException("cipherSuites[" + i + "] == null");
            }
            if (cipherSuite.equals(TLS_EMPTY_RENEGOTIATION_INFO_SCSV)) {
                continue;
            }
            if (STANDARD_TO_OPENSSL_CIPHER_SUITES.containsKey(cipherSuite)) {
                continue;
            }
            if (OPENSSL_TO_STANDARD_CIPHER_SUITES.containsKey(cipherSuite)) {
                // TODO log warning about using backward compatability
                continue;
            }
            throw new IllegalArgumentException("cipherSuite " + cipherSuite + " is not supported.");
        }
        return cipherSuites;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.723 -0500", hash_original_method = "F3CB11551C79744236E757C86A89C757", hash_generated_method = "638413FBBE5E4D98EDF593B77FC983C2")
    public static String[] getSupportedCompressionMethods() {
        return SUPPORTED_COMPRESSION_METHODS.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.724 -0500", hash_original_method = "A901AF6EA414203A59788DDBAFC645BA", hash_generated_method = "D7C4C9E4F03582A737AED2F222D7568D")
    public static final String[] getDefaultCompressionMethods() {
        return new String[] { SUPPORTED_COMPRESSION_METHOD_NULL };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.725 -0500", hash_original_method = "414D814ABD06A91544C6447388000DA1", hash_generated_method = "0609CE05A6E7ECC1A1262011FD7B3E79")
    public static String[] checkEnabledCompressionMethods(String[] methods) {
        if (methods == null) {
            throw new IllegalArgumentException("methods == null");
        }
        if (methods.length < 1
                && !methods[methods.length-1].equals(SUPPORTED_COMPRESSION_METHOD_NULL)) {
            throw new IllegalArgumentException("last method must be NULL");
        }
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            if (method == null) {
                throw new IllegalArgumentException("methods[" + i + "] == null");
            }
            if (!method.equals(SUPPORTED_COMPRESSION_METHOD_ZLIB)
                    && !method.equals(SUPPORTED_COMPRESSION_METHOD_NULL)) {
                throw new IllegalArgumentException("method " + method
                                                   + " is not supported");
            }
        }
        return methods;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.726 -0500", hash_original_method = "305A7CF92E5DCD206A7820A87A30261A", hash_generated_method = "9D6FED887F6B31BB3ADA93A6A00B4B45")
    public static void setEnabledCompressionMethods(int ssl, String[] methods) {
        checkEnabledCompressionMethods(methods);
        // openssl uses negative logic letting you disable compression.
        // so first, assume we need to set all (disable all) and clear none (enable none).
        // in the loop, selectively move bits from set to clear (from disable to enable)
        long optionsToSet = (SSL_OP_NO_COMPRESSION);
        long optionsToClear = 0;
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            if (method.equals(SUPPORTED_COMPRESSION_METHOD_NULL)) {
                // nothing to do to support NULL
            } else if (method.equals(SUPPORTED_COMPRESSION_METHOD_ZLIB)) {
                optionsToSet &= ~SSL_OP_NO_COMPRESSION;
                optionsToClear |= SSL_OP_NO_COMPRESSION;
            } else {
                // error checked by checkEnabledCompressionMethods
                throw new IllegalStateException();
            }
        }

        SSL_set_options(ssl, optionsToSet);
        SSL_clear_options(ssl, optionsToClear);
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_verify(int sslNativePointer, int mode) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_session(int sslNativePointer, int sslSessionNativePointer) throws SSLException {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_session_creation_enabled(
            int sslNativePointer, boolean creationEnabled) throws SSLException {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_set_tlsext_host_name(int sslNativePointer, String hostname) throws SSLException {
    }

    
    @DSModeled(DSC.SAFE)
    public static String SSL_get_servername(int sslNativePointer) {
    	String ret = new String();
    	ret.taint.addTaint(sslNativePointer);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static int SSL_do_handshake(int sslNativePointer,
                                              FileDescriptor fd,
                                              SSLHandshakeCallbacks shc,
                                              int timeout,
                                              boolean client_mode) throws SSLException, SocketTimeoutException, CertificateException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052926841 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052926841;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_renegotiate(int sslNativePointer) throws SSLException {
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[][] SSL_get_certificate(int sslNativePointer) {
                byte[][] var09EEFE93BC05FD972F5A60957AA3195B_275851818 = {{DSUtils.UNKNOWN_BYTE}};
        return var09EEFE93BC05FD972F5A60957AA3195B_275851818;
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[][] SSL_get_peer_cert_chain(int sslNativePointer) {
                byte[][] var09EEFE93BC05FD972F5A60957AA3195B_144247038 = {{DSUtils.UNKNOWN_BYTE}};
        return var09EEFE93BC05FD972F5A60957AA3195B_144247038;
    }

    
    @DSModeled(DSC.SAFE)
    public static int SSL_read(int sslNativePointer,
                                      FileDescriptor fd,
                                      SSLHandshakeCallbacks shc,
                                      byte[] b, int off, int len, int timeout) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161276270 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_161276270;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_write(int sslNativePointer,
                                        FileDescriptor fd,
                                        SSLHandshakeCallbacks shc,
                                        byte[] b, int off, int len) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_interrupt(int sslNativePointer) {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_shutdown(int sslNativePointer,
                                           FileDescriptor fd,
                                           SSLHandshakeCallbacks shc) throws IOException {
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_free(int sslNativePointer) {
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] SSL_SESSION_session_id(int sslSessionNativePointer) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1024556878 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1024556878;
    }

    
    @DSModeled(DSC.SAFE)
    public static long SSL_SESSION_get_time(int sslSessionNativePointer) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_922418158 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_922418158;
    }

    
    @DSModeled(DSC.SAFE)
    public static String SSL_SESSION_get_version(int sslSessionNativePointer) {
    	String ret = new String();
    	ret.taint.addTaint(sslSessionNativePointer);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String SSL_SESSION_cipher(int sslSessionNativePointer) {
    	String ret = new String();
    	ret.taint.addTaint(sslSessionNativePointer);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static String SSL_SESSION_compress_meth(int sslCtxNativePointer,
                                                          int sslSessionNativePointer) {
    	String ret = new String();
    	ret.taint.addTaint(sslCtxNativePointer);
    	ret.taint.addTaint(sslSessionNativePointer);
    	return ret;
    }

    
    @DSModeled(DSC.SAFE)
    public static void SSL_SESSION_free(int sslSessionNativePointer) {
    }

    
    @DSModeled(DSC.SAFE)
    public static byte[] i2d_SSL_SESSION(int sslSessionNativePointer) {
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_503780473 = {DSUtils.UNKNOWN_BYTE};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_503780473;
    }

    
    @DSModeled(DSC.SAFE)
    public static int d2i_SSL_SESSION(byte[] data) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053194282 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1053194282;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.675 -0500", hash_original_field = "C3CFB2FCD1E5EF44AE7C46878C170911", hash_generated_field = "96B3D7F063AB86A68380150319726EEF")


    public static final int RAND_SEED_LENGTH_IN_BYTES = 1024;

    
    public interface SSLHandshakeCallbacks {
        
        public void verifyCertificateChain(byte[][] asn1DerEncodedCertificateChain, String authMethod)
            throws CertificateException;

        
        public void clientCertificateRequested(byte[] keyTypes,
                                               byte[][] asn1DerEncodedX500Principals)
            throws CertificateEncodingException, SSLException;

        
        public void handshakeCompleted();
    }
    
    static {
        clinit();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.681 -0500", hash_original_field = "9E559542127D639B38EF0AC72F395217", hash_generated_field = "9023935C52A658A359F4EC994ADDAD3D")


    private static final String SUPPORTED_PROTOCOL_SSLV3 = "SSLv3";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.682 -0500", hash_original_field = "48998320448FD3BBFABE1E7E97EA1EB4", hash_generated_field = "5B202BC2B7655D8857447040CF43C754")

    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.683 -0500", hash_original_field = "11F142202670ED688C9E69FC8685331C", hash_generated_field = "97E16C9F2C2CC1721F1B1B68F46A60D5")


    public static final Map<String, String> OPENSSL_TO_STANDARD_CIPHER_SUITES
            = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.684 -0500", hash_original_field = "902BD1235411D6DBB47E9EA30D1D5A37", hash_generated_field = "E10C27FC0C78FF9558F6C5C640B527B4")

    public static final Map<String, String> STANDARD_TO_OPENSSL_CIPHER_SUITES
            = new LinkedHashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.686 -0500", hash_original_field = "251C1E391299B2594F2D46BC7EFBD252", hash_generated_field = "99061485CAC02933CFB832A8FA01EF67")

    public static final String TLS_EMPTY_RENEGOTIATION_INFO_SCSV
            = "TLS_EMPTY_RENEGOTIATION_INFO_SCSV";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.687 -0500", hash_original_field = "AFA0037EECC832F9C7A79527C5852474", hash_generated_field = "91DE1DEF6C8DAA1D2D57F34F524A0E97")


    private static  String[] SUPPORTED_CIPHER_SUITES;
    static {
        add("SSL_RSA_WITH_RC4_128_MD5",              "RC4-MD5");
        add("SSL_RSA_WITH_RC4_128_SHA",              "RC4-SHA");
        add("TLS_RSA_WITH_AES_128_CBC_SHA",          "AES128-SHA");
        add("TLS_RSA_WITH_AES_256_CBC_SHA",          "AES256-SHA");
        add("TLS_ECDH_ECDSA_WITH_RC4_128_SHA",       "ECDH-ECDSA-RC4-SHA");
        add("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA",   "ECDH-ECDSA-AES128-SHA");
        add("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA",   "ECDH-ECDSA-AES256-SHA");
        add("TLS_ECDH_RSA_WITH_RC4_128_SHA",         "ECDH-RSA-RC4-SHA");
        add("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA",     "ECDH-RSA-AES128-SHA");
        add("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA",     "ECDH-RSA-AES256-SHA");
        add("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA",      "ECDHE-ECDSA-RC4-SHA");
        add("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA",  "ECDHE-ECDSA-AES128-SHA");
        add("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA",  "ECDHE-ECDSA-AES256-SHA");
        add("TLS_ECDHE_RSA_WITH_RC4_128_SHA",        "ECDHE-RSA-RC4-SHA");
        add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA",    "ECDHE-RSA-AES128-SHA");
        add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA",    "ECDHE-RSA-AES256-SHA");
        add("TLS_DHE_RSA_WITH_AES_128_CBC_SHA",      "DHE-RSA-AES128-SHA");
        add("TLS_DHE_RSA_WITH_AES_256_CBC_SHA",      "DHE-RSA-AES256-SHA");
        add("TLS_DHE_DSS_WITH_AES_128_CBC_SHA",      "DHE-DSS-AES128-SHA");
        add("TLS_DHE_DSS_WITH_AES_256_CBC_SHA",      "DHE-DSS-AES256-SHA");
        add("SSL_RSA_WITH_3DES_EDE_CBC_SHA",         "DES-CBC3-SHA");
        add("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA",  "ECDH-ECDSA-DES-CBC3-SHA");
        add("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA",    "ECDH-RSA-DES-CBC3-SHA");
        add("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "ECDHE-ECDSA-DES-CBC3-SHA");
        add("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA",   "ECDHE-RSA-DES-CBC3-SHA");
        add("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA",     "EDH-RSA-DES-CBC3-SHA");
        add("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA",     "EDH-DSS-DES-CBC3-SHA");
        add("SSL_RSA_WITH_DES_CBC_SHA",              "DES-CBC-SHA");
        add("SSL_DHE_RSA_WITH_DES_CBC_SHA",          "EDH-RSA-DES-CBC-SHA");
        add("SSL_DHE_DSS_WITH_DES_CBC_SHA",          "EDH-DSS-DES-CBC-SHA");
        add("SSL_RSA_EXPORT_WITH_RC4_40_MD5",        "EXP-RC4-MD5");
        add("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA",     "EXP-DES-CBC-SHA");
        add("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "EXP-EDH-RSA-DES-CBC-SHA");
        add("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "EXP-EDH-DSS-DES-CBC-SHA");
        add("SSL_RSA_WITH_NULL_MD5",                 "NULL-MD5");
        add("SSL_RSA_WITH_NULL_SHA",                 "NULL-SHA");
        add("TLS_ECDH_ECDSA_WITH_NULL_SHA",          "ECDH-ECDSA-NULL-SHA");
        add("TLS_ECDH_RSA_WITH_NULL_SHA",            "ECDH-RSA-NULL-SHA");
        add("TLS_ECDHE_ECDSA_WITH_NULL_SHA",         "ECDHE-ECDSA-NULL-SHA");
        add("TLS_ECDHE_RSA_WITH_NULL_SHA",           "ECDHE-RSA-NULL-SHA");
        add("SSL_DH_anon_WITH_RC4_128_MD5",          "ADH-RC4-MD5");
        add("TLS_DH_anon_WITH_AES_128_CBC_SHA",      "ADH-AES128-SHA");
        add("TLS_DH_anon_WITH_AES_256_CBC_SHA",      "ADH-AES256-SHA");
        add("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA",     "ADH-DES-CBC3-SHA");
        add("SSL_DH_anon_WITH_DES_CBC_SHA",          "ADH-DES-CBC-SHA");
        add("TLS_ECDH_anon_WITH_RC4_128_SHA",        "AECDH-RC4-SHA");
        add("TLS_ECDH_anon_WITH_AES_128_CBC_SHA",    "AECDH-AES128-SHA");
        add("TLS_ECDH_anon_WITH_AES_256_CBC_SHA",    "AECDH-AES256-SHA");
        add("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA",   "AECDH-DES-CBC3-SHA");
        add("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5",    "EXP-ADH-RC4-MD5");
        add("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "EXP-ADH-DES-CBC-SHA");
        add("TLS_ECDH_anon_WITH_NULL_SHA",           "AECDH-NULL-SHA");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.688 -0500", hash_original_field = "2CA15A751A7770AA3B85C160A5E41CA4", hash_generated_field = "D12010845BE358860D4C1B9CEDB0A239")

    public static final long SSL_MODE_HANDSHAKE_CUTTHROUGH = 0x00000040L;
    static {
        int size = STANDARD_TO_OPENSSL_CIPHER_SUITES.size();
        SUPPORTED_CIPHER_SUITES = new String[size + 1];
        STANDARD_TO_OPENSSL_CIPHER_SUITES.keySet().toArray(SUPPORTED_CIPHER_SUITES);
        SUPPORTED_CIPHER_SUITES[size] = TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.689 -0500", hash_original_field = "DF4535FC2BE1313E2C5F82CA4BEAB175", hash_generated_field = "F599E1E38DE2FF7C5195192CDE8B77D9")

    public static final long SSL_OP_NO_TICKET      = 0x00004000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.690 -0500", hash_original_field = "D2C0147ED3FA8EC0C8E1745AA05BBE7A", hash_generated_field = "DEE386528586EC46246396BFBFF5E31B")

    public static final long SSL_OP_NO_COMPRESSION = 0x00020000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.690 -0500", hash_original_field = "077DD13DDD20426B86466628C7314FF3", hash_generated_field = "4596713C51D4556006279A44FF3DC1E5")

    public static final long SSL_OP_NO_SSLv3       = 0x02000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.691 -0500", hash_original_field = "F39E37361FFAE8717459417359498674", hash_generated_field = "04D5F157235A64D42E27F0360EC9A8E6")

    public static final long SSL_OP_NO_TLSv1       = 0x04000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.720 -0500", hash_original_field = "242A5D38B2FB7CAA9F8FD11439F35313", hash_generated_field = "D6A7C7352FC63DCD987CF33EE58428AD")


    private static final String SUPPORTED_COMPRESSION_METHOD_ZLIB = "ZLIB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.721 -0500", hash_original_field = "3F10C372087A167A730E250D9E42935C", hash_generated_field = "A016FFB952E5D4292D0F4F008344F132")

    private static final String SUPPORTED_COMPRESSION_METHOD_NULL = "NULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.722 -0500", hash_original_field = "C03CC1F5985255536672FA63A8B08EB3", hash_generated_field = "666CD3955D49FDE8D33C7478EA6E111C")


    private static final String[] SUPPORTED_COMPRESSION_METHODS
            = { SUPPORTED_COMPRESSION_METHOD_ZLIB, SUPPORTED_COMPRESSION_METHOD_NULL };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.726 -0500", hash_original_field = "C4DD847E91C1EFA9222F33CDA1EBAC2C", hash_generated_field = "1264308E1D0D1CDE461ADE126F53073B")

    public static final int SSL_VERIFY_NONE =                 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.727 -0500", hash_original_field = "C27A0FCCB40B3F92E8BBE4BB230929D5", hash_generated_field = "056F9710D986851C1F655920AA971C19")

    public static final int SSL_VERIFY_PEER =                 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:09.728 -0500", hash_original_field = "6988C47D07F3E2ECC0B12CAE4216A4A1", hash_generated_field = "A39492168197080C3D83D6E8C946708C")

    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 0x02;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.716 -0400", hash_original_method = "DDEFB157515C7447D58E1F6901777126", hash_generated_method = "DDEFB157515C7447D58E1F6901777126")
    public NativeCrypto ()
    {
        //Synthesized constructor
    }
}

