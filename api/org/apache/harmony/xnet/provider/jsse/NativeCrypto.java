package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.716 -0400", hash_original_method = "DDEFB157515C7447D58E1F6901777126", hash_generated_method = "DDEFB157515C7447D58E1F6901777126")
    public NativeCrypto ()
    {
        //Synthesized constructor
    }


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

    
    @DSModeled(DSC.SAFE)
    public static int X509_NAME_hash(X500Principal principal) {
        return X509_NAME_hash(principal, "SHA1");
    }

    
    @DSModeled(DSC.SPEC)
    public static int X509_NAME_hash_old(X500Principal principal) {
        return X509_NAME_hash(principal, "MD5");
    }

    
    @DSModeled(DSC.BAN)
    private static int X509_NAME_hash(X500Principal principal, String algorithm) {
        try {
            byte[] digest = MessageDigest.getInstance(algorithm).digest(principal.getEncoded());
            return Memory.peekInt(digest, 0, ByteOrder.LITTLE_ENDIAN);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static void add(String standard, String openssl) {
        OPENSSL_TO_STANDARD_CIPHER_SUITES.put(openssl, standard);
        STANDARD_TO_OPENSSL_CIPHER_SUITES.put(standard, openssl);
    }

    
    @DSModeled(DSC.SAFE)
    public static int SSL_CTX_new() {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499904329 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_499904329;
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    public static byte[][] encodeCertificates(Certificate[] certificates) throws CertificateEncodingException {
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

    
    @DSModeled(DSC.SPEC)
    public static byte[][] encodeIssuerX509Principals(X509Certificate[] certificates) throws CertificateEncodingException {
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

    
    @DSModeled(DSC.SAFE)
    public static String[] getSupportedProtocols() {
        return new String[] { SUPPORTED_PROTOCOL_SSLV3, SUPPORTED_PROTOCOL_TLSV1 };
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
    public static String[] getSupportedCompressionMethods() {
        return SUPPORTED_COMPRESSION_METHODS.clone();
    }

    
    @DSModeled(DSC.SAFE)
    public static final String[] getDefaultCompressionMethods() {
        return new String[] { SUPPORTED_COMPRESSION_METHOD_NULL };
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SPEC)
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "0F4CEBB59962BA368C7FD7D079A3D043", hash_generated_field = "96B3D7F063AB86A68380150319726EEF")

    public static final int RAND_SEED_LENGTH_IN_BYTES = 1024;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "B3EF6ECACE1051049771471599EE7E52", hash_generated_field = "9023935C52A658A359F4EC994ADDAD3D")

    private static final String SUPPORTED_PROTOCOL_SSLV3 = "SSLv3";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "624150269722D4BCD0E03A70841F141C", hash_generated_field = "5B202BC2B7655D8857447040CF43C754")

    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "82054084632775C6B5F75BA70FD292AE", hash_generated_field = "97E16C9F2C2CC1721F1B1B68F46A60D5")

    public static final Map<String, String> OPENSSL_TO_STANDARD_CIPHER_SUITES
            = new HashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "7EF47BEB0434D81D805CCB08D1F89C74", hash_generated_field = "E10C27FC0C78FF9558F6C5C640B527B4")

    public static final Map<String, String> STANDARD_TO_OPENSSL_CIPHER_SUITES
            = new LinkedHashMap<String, String>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "F3E5577A73E18E0FA4E7EFA29622EB9B", hash_generated_field = "99061485CAC02933CFB832A8FA01EF67")

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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "24D46A327FE03D7E6A9CE5B8E4DCEF2E", hash_generated_field = "91DE1DEF6C8DAA1D2D57F34F524A0E97")

    private static String[] SUPPORTED_CIPHER_SUITES;
    static {
        int size = STANDARD_TO_OPENSSL_CIPHER_SUITES.size();
        SUPPORTED_CIPHER_SUITES = new String[size + 1];
        STANDARD_TO_OPENSSL_CIPHER_SUITES.keySet().toArray(SUPPORTED_CIPHER_SUITES);
        SUPPORTED_CIPHER_SUITES[size] = TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "B9A825B44482009433F40D261C069096", hash_generated_field = "D12010845BE358860D4C1B9CEDB0A239")

    public static final long SSL_MODE_HANDSHAKE_CUTTHROUGH = 0x00000040L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "6F1A501C5CAFC3F779CB2E5F3669FFF5", hash_generated_field = "F599E1E38DE2FF7C5195192CDE8B77D9")

    public static final long SSL_OP_NO_TICKET      = 0x00004000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.721 -0400", hash_original_field = "C392CA8836302EAD135F372AD4D667B5", hash_generated_field = "DEE386528586EC46246396BFBFF5E31B")

    public static final long SSL_OP_NO_COMPRESSION = 0x00020000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "DF98C840C3BAA7824C9CFEEA4F01865B", hash_generated_field = "4596713C51D4556006279A44FF3DC1E5")

    public static final long SSL_OP_NO_SSLv3       = 0x02000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "3448B29885C7E965BA4BE5DEB4023D85", hash_generated_field = "04D5F157235A64D42E27F0360EC9A8E6")

    public static final long SSL_OP_NO_TLSv1       = 0x04000000L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "7D6DAE6B609B9C785AAB48494D5A94E4", hash_generated_field = "D6A7C7352FC63DCD987CF33EE58428AD")

    private static final String SUPPORTED_COMPRESSION_METHOD_ZLIB = "ZLIB";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "47C5EE9EA5B65FA90CE89165E55D1BBE", hash_generated_field = "A016FFB952E5D4292D0F4F008344F132")

    private static final String SUPPORTED_COMPRESSION_METHOD_NULL = "NULL";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "D5E4AAD482A0BBE2712AFFC08AB22442", hash_generated_field = "666CD3955D49FDE8D33C7478EA6E111C")

    private static final String[] SUPPORTED_COMPRESSION_METHODS = { SUPPORTED_COMPRESSION_METHOD_ZLIB, SUPPORTED_COMPRESSION_METHOD_NULL };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "C4F14EAEBC522E9442D933BD91F0BF9A", hash_generated_field = "1264308E1D0D1CDE461ADE126F53073B")

    public static final int SSL_VERIFY_NONE =                 0x00;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "DBD53610952BF88DA6B8106B323FBDE5", hash_generated_field = "056F9710D986851C1F655920AA971C19")

    public static final int SSL_VERIFY_PEER =                 0x01;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.722 -0400", hash_original_field = "9E72384D5C283A7D3BF0E0A3D49688B4", hash_generated_field = "A39492168197080C3D83D6E8C946708C")

    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 0x02;
}

