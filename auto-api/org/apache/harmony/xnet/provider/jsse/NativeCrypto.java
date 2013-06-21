package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLException;
import javax.security.auth.x500.X500Principal;
import libcore.io.Memory;

public final class NativeCrypto {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.824 -0400", hash_original_method = "4B88CEC60993780848A8B7E0B3D139E6", hash_generated_method = "4B88CEC60993780848A8B7E0B3D139E6")
        public NativeCrypto ()
    {
    }


        private static void clinit() {
    }

    
        public static int EVP_PKEY_new_DSA(byte[] p, byte[] q, byte[] g,
                                              byte[] priv_key, byte[] pub_key) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int EVP_PKEY_new_RSA(byte[] n, byte[] e, byte[] d, byte[] p, byte[] q) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void EVP_PKEY_free(int pkey) {
    }

    
        public static int EVP_get_digestbyname(String name) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int EVP_MD_size(int evp_md) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int EVP_MD_block_size(int evp_md) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void EVP_MD_CTX_destroy(int ctx) {
    }

    
        public static int EVP_MD_CTX_copy(int ctx) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int EVP_DigestInit(int evp_md) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void EVP_DigestUpdate(int ctx, byte[] buffer, int offset, int length) {
    }

    
        public static int EVP_DigestFinal(int ctx, byte[] hash, int offset) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int EVP_VerifyInit(String algorithm) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void EVP_VerifyUpdate(int ctx, byte[] buffer,
                                               int offset, int length) {
    }

    
        public static int EVP_VerifyFinal(int ctx, byte[] signature,
                                             int offset, int length, int key) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void RAND_seed(byte[] seed) {
    }

    
        public static int RAND_load_file(String filename, long max_bytes) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int X509_NAME_hash(X500Principal principal) {
        return X509_NAME_hash(principal, "SHA1");
    }

    
        public static int X509_NAME_hash_old(X500Principal principal) {
        return X509_NAME_hash(principal, "MD5");
    }

    
        private static int X509_NAME_hash(X500Principal principal, String algorithm) {
        try {
            byte[] digest = MessageDigest.getInstance(algorithm).digest(principal.getEncoded());
            return Memory.peekInt(digest, 0, ByteOrder.LITTLE_ENDIAN);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    
        private static void add(String standard, String openssl) {
        OPENSSL_TO_STANDARD_CIPHER_SUITES.put(openssl, standard);
        STANDARD_TO_OPENSSL_CIPHER_SUITES.put(standard, openssl);
    }

    
        public static int SSL_CTX_new() {
        return DSUtils.UNKNOWN_INT;
    }

    
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

    
        public static String[] getSupportedCipherSuites() {
        return SUPPORTED_CIPHER_SUITES.clone();
    }

    
        public static void SSL_CTX_free(int ssl_ctx) {
    }

    
        public static int SSL_new(int ssl_ctx) throws SSLException {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static byte[][] encodeCertificates(Certificate[] certificates) throws CertificateEncodingException {
        byte[][] certificateBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            certificateBytes[i] = certificates[i].getEncoded();
        }
        return certificateBytes;
    }

    
        public static void SSL_use_certificate(int ssl, byte[][] asn1DerEncodedCertificateChain) {
    }

    
        public static void SSL_use_PrivateKey(int ssl, byte[] pkcs8EncodedPrivateKey) {
    }

    
        public static void SSL_check_private_key(int ssl) throws SSLException {
    }

    
        public static byte[][] encodeIssuerX509Principals(X509Certificate[] certificates) throws CertificateEncodingException {
        byte[][] principalBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            principalBytes[i] = certificates[i].getIssuerX500Principal().getEncoded();
        }
        return principalBytes;
    }

    
        public static void SSL_set_client_CA_list(int ssl, byte[][] asn1DerEncodedX500Principals) {
    }

    
        public static long SSL_get_mode(int ssl) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long SSL_set_mode(int ssl, long mode) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long SSL_clear_mode(int ssl, long mode) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long SSL_get_options(int ssl) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long SSL_set_options(int ssl, long options) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static long SSL_clear_options(int ssl, long options) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static String[] getSupportedProtocols() {
        return new String[] { SUPPORTED_PROTOCOL_SSLV3, SUPPORTED_PROTOCOL_TLSV1 };
    }

    
        public static void setEnabledProtocols(int ssl, String[] protocols) {
        checkEnabledProtocols(protocols);
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
                throw new IllegalStateException();
            }
        }
        SSL_set_options(ssl, optionsToSet);
        SSL_clear_options(ssl, optionsToClear);
    }

    
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

    
        public static void SSL_set_cipher_lists(int ssl, String[] ciphers) {
    }

    
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

    
        public static String[] checkEnabledCipherSuites(String[] cipherSuites) {
        if (cipherSuites == null) {
            throw new IllegalArgumentException("cipherSuites == null");
        }
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
                continue;
            }
            throw new IllegalArgumentException("cipherSuite " + cipherSuite + " is not supported.");
        }
        return cipherSuites;
    }

    
        public static String[] getSupportedCompressionMethods() {
        return SUPPORTED_COMPRESSION_METHODS.clone();
    }

    
        public static final String[] getDefaultCompressionMethods() {
        return new String[] { SUPPORTED_COMPRESSION_METHOD_NULL };
    }

    
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

    
        public static void setEnabledCompressionMethods(int ssl, String[] methods) {
        checkEnabledCompressionMethods(methods);
        long optionsToSet = (SSL_OP_NO_COMPRESSION);
        long optionsToClear = 0;
        for (int i = 0; i < methods.length; i++) {
            String method = methods[i];
            if (method.equals(SUPPORTED_COMPRESSION_METHOD_NULL)) {
            } else if (method.equals(SUPPORTED_COMPRESSION_METHOD_ZLIB)) {
                optionsToSet &= ~SSL_OP_NO_COMPRESSION;
                optionsToClear |= SSL_OP_NO_COMPRESSION;
            } else {
                throw new IllegalStateException();
            }
        }
        SSL_set_options(ssl, optionsToSet);
        SSL_clear_options(ssl, optionsToClear);
    }

    
        public static void SSL_set_verify(int sslNativePointer, int mode) {
    }

    
        public static void SSL_set_session(int sslNativePointer, int sslSessionNativePointer) throws SSLException {
    }

    
        public static void SSL_set_session_creation_enabled(
            int sslNativePointer, boolean creationEnabled) throws SSLException {
    }

    
        public static void SSL_set_tlsext_host_name(int sslNativePointer, String hostname) throws SSLException {
    }

    
        public static String SSL_get_servername(int sslNativePointer) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static int SSL_do_handshake(int sslNativePointer,
                                              FileDescriptor fd,
                                              SSLHandshakeCallbacks shc,
                                              int timeout,
                                              boolean client_mode) throws SSLException, SocketTimeoutException, CertificateException {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void SSL_renegotiate(int sslNativePointer) throws SSLException {
    }

    
        public static byte[][] SSL_get_certificate(int sslNativePointer) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static byte[][] SSL_get_peer_cert_chain(int sslNativePointer) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static int SSL_read(int sslNativePointer,
                                      FileDescriptor fd,
                                      SSLHandshakeCallbacks shc,
                                      byte[] b, int off, int len, int timeout) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void SSL_write(int sslNativePointer,
                                        FileDescriptor fd,
                                        SSLHandshakeCallbacks shc,
                                        byte[] b, int off, int len) throws IOException {
    }

    
        public static void SSL_interrupt(int sslNativePointer) {
    }

    
        public static void SSL_shutdown(int sslNativePointer,
                                           FileDescriptor fd,
                                           SSLHandshakeCallbacks shc) throws IOException {
    }

    
        public static void SSL_free(int sslNativePointer) {
    }

    
        public static byte[] SSL_SESSION_session_id(int sslSessionNativePointer) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        public static long SSL_SESSION_get_time(int sslSessionNativePointer) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static String SSL_SESSION_get_version(int sslSessionNativePointer) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String SSL_SESSION_cipher(int sslSessionNativePointer) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static String SSL_SESSION_compress_meth(int sslCtxNativePointer,
                                                          int sslSessionNativePointer) {
        return DSUtils.UNKNOWN_STRING;
    }

    
        public static void SSL_SESSION_free(int sslSessionNativePointer) {
    }

    
        public static byte[] i2d_SSL_SESSION(int sslSessionNativePointer) {
        byte[] retVal = {DSUtils.UNKNOWN_BYTE};
        return retVal;
    }

    
        public static int d2i_SSL_SESSION(byte[] data) {
        return DSUtils.UNKNOWN_INT;
    }

    
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
    
    public static final int RAND_SEED_LENGTH_IN_BYTES = 1024;
    private static final String SUPPORTED_PROTOCOL_SSLV3 = "SSLv3";
    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
    public static final Map<String, String> OPENSSL_TO_STANDARD_CIPHER_SUITES
            = new HashMap<String, String>();
    public static final Map<String, String> STANDARD_TO_OPENSSL_CIPHER_SUITES
            = new LinkedHashMap<String, String>();
    public static final String TLS_EMPTY_RENEGOTIATION_INFO_SCSV
            = "TLS_EMPTY_RENEGOTIATION_INFO_SCSV";
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
    
    private static final String[] SUPPORTED_CIPHER_SUITES;
    static {
        int size = STANDARD_TO_OPENSSL_CIPHER_SUITES.size();
        SUPPORTED_CIPHER_SUITES = new String[size + 1];
        STANDARD_TO_OPENSSL_CIPHER_SUITES.keySet().toArray(SUPPORTED_CIPHER_SUITES);
        SUPPORTED_CIPHER_SUITES[size] = TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    }
    
    public static final long SSL_MODE_HANDSHAKE_CUTTHROUGH = 0x00000040L;
    public static final long SSL_OP_NO_TICKET      = 0x00004000L;
    public static final long SSL_OP_NO_COMPRESSION = 0x00020000L;
    public static final long SSL_OP_NO_SSLv3       = 0x02000000L;
    public static final long SSL_OP_NO_TLSv1       = 0x04000000L;
    private static final String SUPPORTED_COMPRESSION_METHOD_ZLIB = "ZLIB";
    private static final String SUPPORTED_COMPRESSION_METHOD_NULL = "NULL";
    private static final String[] SUPPORTED_COMPRESSION_METHODS
            = { SUPPORTED_COMPRESSION_METHOD_ZLIB, SUPPORTED_COMPRESSION_METHOD_NULL };
    public static final int SSL_VERIFY_NONE =                 0x00;
    public static final int SSL_VERIFY_PEER =                 0x01;
    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 0x02;
}

