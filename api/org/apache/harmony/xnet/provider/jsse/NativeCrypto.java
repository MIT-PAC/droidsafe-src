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

    // --- Signature handling functions ----------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.742 -0400", hash_original_method = "8A251B2ADA9B7674BDECA07CD6282E10", hash_generated_method = "7D4D9E3C62A1B664EEF269DF9B192B93")
    
    public static int EVP_SignInit(String algorithm){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += algorithm.getTaintInt();
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.588 -0400", hash_original_method = "EAC451683E9448E7DD93BF7148251114", hash_generated_method = "5957E40D75B0EE834C9BC0D2090F32EC")
    
    public static int ENGINE_by_id(String id){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += id.getTaintInt();
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.015 -0400", hash_original_method = "BA5082EB2A8130661F8BCCC042084F5A", hash_generated_method = "104CE1AD7E02C232EC8E67CCF33EAB72")
    
    public static byte[] SSL_get_npn_negotiated_protocol(int sslNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.752 -0400", hash_original_method = "3E6E40EFB0B8C0961A1F5DFFF4092E2F", hash_generated_method = "F5E5404460E57F2E571CE6CEBA9E817D")
    
    public static int EVP_SignFinal(int ctx, byte[] signature, int offset, int key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    	taintDouble += signature[0];
    	taintDouble += offset;
    	taintDouble += key;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.677 -0400", hash_original_method = "A626D2BEEDBD8540BDF3D27502974C8F", hash_generated_method = "286B79A9799F77FED34CB72649F9064D")
    
    public static int DSA_generate_key(int primeBits, byte[] seed, byte[] g, byte[] p,
                byte[] q){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += primeBits;
    	taintDouble += seed[0];
    	taintDouble += g[0];
    	taintDouble += p[0];
    	taintDouble += q[0];
    
    	return (int)taintDouble;
    }



    // --- Block ciphers -------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.771 -0400", hash_original_method = "CBE7A9D64FEF276BFF672FB9CF19F995", hash_generated_method = "2C5E12E3869ED5C78688F150E022C4B5")
    
    public static int EVP_get_cipherbyname(String string){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += string.getTaintInt();
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.818 -0400", hash_original_field = "85D00D872100EE92CE0EC23DCE4D6859", hash_generated_field = "F0F09E278F3275255656F790468834C1")

    private static final String SUPPORTED_PROTOCOL_TLSV1_2 = "TLSv1.2";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.701 -0400", hash_original_method = "892A85B10D61CAFAAF699E0D5D84F685", hash_generated_method = "6F40F129EAC1589D7F4B11FDD5197786")
    
    public static byte[] i2d_DSAPrivateKey(int dsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dsa;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.784 -0400", hash_original_method = "81302C0D87D8C0198853F45FB5C8C6F9", hash_generated_method = "00D594C972EA05BA1FB524660F31C5C3")
    
    public static int EVP_CipherFinal_ex(int ctx, byte[] out, int outOffset){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    	taintDouble += out[0];
    	taintDouble += outOffset;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.603 -0400", hash_original_method = "6170E9B7A2B57CA55195F40BB7C0B5FA", hash_generated_method = "150BCFFB9B2F05F007D7772922C349B6")
    
    public static int ENGINE_free(int e){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += e;
    
    	return (int)taintDouble;
    }


    /**
     * Enables NPN for all SSL connections in the context.
     *
     * <p>For clients this causes the NPN extension to be included in the
     * ClientHello message.
     *
     * <p>For servers this causes the NPN extension to be included in the
     * ServerHello message. The NPN extension will not be included in the
     * ServerHello response if the client didn't include it in the ClientHello
     * request.
     *
     * <p>In either case the caller should pass a non-null byte array of NPN
     * protocols to {@link #SSL_do_handshake}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.004 -0400", hash_original_method = "4F6B088F963FDA55DCDAA97398EBDE1C", hash_generated_method = "4015D1BCFBF46AE949C3E73B2DB5CD4C")
    
    public static void SSL_CTX_enable_npn(int sslCtxNativePointer){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.885 -0400", hash_original_method = "76E31CA7777F1F7A98351A8596F40F43", hash_generated_method = "2D27E2214F9D2B2FB12577C177CAF802")
    
    public static void SSL_CTX_set_session_id_context(int ssl_ctx, byte[] sid_ctx){
    	//Formerly a native method
    }


    // --- ENGINE functions ----------------------------------------------------
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.582 -0400", hash_original_method = "AB3C133BC2D08F7A24AF8C5728F742AB", hash_generated_method = "BE52A5338869EFEA92894429FE455D71")
    
    public static void ENGINE_load_dynamic(){
    	//Formerly a native method
    }


    /**
     * @return array of {g, p, q, y(pub), x(priv)}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.682 -0400", hash_original_method = "E43574102B5984484310F79EFEDBDC82", hash_generated_method = "84CE9D8930F7B37F3FECC4DA4E1A8602")
    
    public static byte[][] get_DSA_params(int dsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dsa;
    
    	byte[][] retObj = new byte[1][1]; 
    	retObj[0][0] = (byte)taintDouble;
    	return retObj;
    }


    /**
     * @return array of {n, e, d, p, q, dmp1, dmq1, iqmp}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.671 -0400", hash_original_method = "44E9A7D91D880EF20BB90E571E802146", hash_generated_method = "5193CD0138AD238E6525F7FE23414236")
    
    public static byte[][] get_RSA_private_params(int rsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += rsa;
    
        byte[][] retObj = new byte[1][1]; 
        retObj[0][0] = (byte)taintDouble;
        return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.686 -0400", hash_original_method = "B312A370494E1688FA4C40536A114A9E", hash_generated_method = "B080439AB58B93BC58C47D9D2C9D21C7")
    
    public static byte[] i2d_RSAPublicKey(int rsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += rsa;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.837 -0400", hash_original_field = "3B7EC80C18079E184CC7143CBE063857", hash_generated_field = "63932D8C4B3D735EEDEA0F81058B2689")

    public static final int EVP_PKEY_RSA = 6;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.634 -0400", hash_original_method = "E02AB7FEF65DCA09B8EA13D494B11E47", hash_generated_method = "64BC062F6743B5A9B5455F29F2A5F89E")
    
    public static int EVP_PKEY_type(int pkey){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pkey;
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.816 -0400", hash_original_field = "DB92FB499C62FC29E1143C76EFA82B70", hash_generated_field = "882B9FDD31C26F047DB876FDB55CA733")

    private static final String SUPPORTED_PROTOCOL_TLSV1_1 = "TLSv1.1";

    // --- DSA/RSA public/private key handling functions -----------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.618 -0400", hash_original_method = "215191AF994971AA7718D877394FEAD8", hash_generated_method = "E89F02604D371C3255E9915B159AF04A")
    
    public static int EVP_PKEY_new_DSA(byte[] p, byte[] q, byte[] g,
                                                  byte[] pub_key, byte[] priv_key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += p[0];
    	taintDouble += q[0];
    	taintDouble += g[0];
    	taintDouble += pub_key[0];
    	taintDouble += priv_key[0];
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.593 -0400", hash_original_method = "8995B734512A91A9547EFEFF2F3861A1", hash_generated_method = "ED33B7F49D7F44812312C7BC29C76144")
    
    public static int ENGINE_init(int e){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += e;
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.840 -0400", hash_original_field = "822B405EABE5D097B40F6D5D74EE672D", hash_generated_field = "FAFDDCA6A5B2C584730257315A414E64")

    public static final int EVP_PKEY_DSA = 116;

    /**
     * Reads with the native SSL_read function from the encrypted data stream
     * @return -1 if error or the end of the stream is reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.030 -0400", hash_original_method = "4674C23351777809269FA0420D1BE0E1", hash_generated_method = "ED9C9ABB49CF82DCCD1C5C96334F733E")
    
    public static int SSL_read(int sslNativePointer,
                                          FileDescriptor fd,
                                          SSLHandshakeCallbacks shc,
                                          byte[] b, int off, int len, int timeoutMillis)
            throws IOException{
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    	taintDouble += fd.getTaintInt();
    	taintDouble += shc.getTaintInt();
    	taintDouble += b[0];
    	taintDouble += off;
    	taintDouble += len;
    	taintDouble += timeoutMillis;
    
    	return (int)taintDouble;
    }


    /**
     * @return array of {n, e}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.667 -0400", hash_original_method = "798A997E2781E33D316CD4352825B4C8", hash_generated_method = "EE78EBB314AE7E64B17E448E2C2FC06F")
    
    public static byte[][] get_RSA_public_params(int rsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += rsa;
    
        byte[][] retObj = new byte[1][1]; 
        retObj[0][0] = (byte)taintDouble;
        return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.696 -0400", hash_original_method = "63C7BE8F7C77FF2F793561A0291DCA25", hash_generated_method = "F9AA5418F813C17889A4663B6E8E55B9")
    
    public static byte[] i2d_DSAPublicKey(int dsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += dsa;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.853 -0400", hash_original_field = "9B6D2553B6608F6C4B11EE7DC1BF3EE0", hash_generated_field = "930B5144365AAC3831C8FB635F76A468")

    public static final long SSL_OP_NO_SESSION_RESUMPTION_ON_RENEGOTIATION = 0x00010000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.842 -0400", hash_original_field = "9F5C9972F291EEA769AB1C1D3D870B05", hash_generated_field = "1140222890790F5069A7454B70A02E5B")

    public static final int EVP_PKEY_DH  = 28;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.866 -0400", hash_original_field = "3DF60CAF5A0EDA54EDBA98DF60E90822", hash_generated_field = "FBFF686CD718FA15F6D36F6644624A93")

    public static final long SSL_OP_NO_TLSv1_2                             = 0x08000000L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.663 -0400", hash_original_method = "56C6543D4ED5651A5BEDBCDA83D3B669", hash_generated_method = "793AEFA82D4F8B4273FFB7AA4436E540")
    
    public static int RSA_generate_key_ex(int modulusBits, byte[] publicExponent){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += modulusBits;
    	taintDouble += publicExponent[0];
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.788 -0400", hash_original_method = "0FD5E439AE3B326EB42B661E58A26430", hash_generated_method = "DD2F6286D02B8A4C9411C9E757C410D1")
    
    public static void EVP_CIPHER_CTX_cleanup(int ctx){
    	//Formerly a native method
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.864 -0400", hash_original_field = "82C3DAA42CEE37C0669436634F09D2D0", hash_generated_field = "F9DFC5620B40EAB6D85D403FCF089479")

    public static final long SSL_OP_NO_TLSv1_1                             = 0x10000000L;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.643 -0400", hash_original_method = "DD54E738C95F7E004D33CA29AEB91163", hash_generated_method = "108056A884C65A9BDD4DCAE88F450212")
    
    public static byte[] i2d_PKCS8_PRIV_KEY_INFO(int pkey){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pkey;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.780 -0400", hash_original_method = "D68DB4C0B752695AD6D0ABCC4BCC14BB", hash_generated_method = "00162507BB175111DF52C76F3C268125")
    
    public static int EVP_CipherUpdate(int ctx, byte[] out, int outOffset, byte[] in,
                int inOffset){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    	taintDouble += out[0];
    	taintDouble += outOffset;
    	taintDouble += in[0];
    	taintDouble += inOffset;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.628 -0400", hash_original_method = "9F9BE545010BAAFE8F645E44C14C0EDC", hash_generated_method = "CD7C0D5D13C6ACD7BFE8143CB41FB59A")
    
    public static int EVP_PKEY_size(int pkey){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pkey;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.608 -0400", hash_original_method = "9A0A8CE67694E66B0BD4CDCF4A48C2D0", hash_generated_method = "9EF8CAFE28C3330200ACC2E564D9B809")
    
    public static int ENGINE_load_private_key(int e, String key_id){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += e;
    	taintDouble += key_id.getTaintInt();
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.845 -0400", hash_original_field = "805821DB25974EDF1CD81994C87A4073", hash_generated_field = "163A1DBB7AF8209588ACA39E03C93651")

    public static final int EVP_PKEY_EC  = 408;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.658 -0400", hash_original_method = "B6A875880625C4C1389431658FFE5CD0", hash_generated_method = "C6451FD5060795D8B5E6D77904E177F2")
    
    public static int d2i_PUBKEY(byte[] data){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.648 -0400", hash_original_method = "025530B39A399F1BEBD08E98F5BBF2E4", hash_generated_method = "F6C8BCBB45449C414EE0F209BA20CCFF")
    
    public static int d2i_PKCS8_PRIV_KEY_INFO(byte[] data){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    
    	return (int)taintDouble;
    }


    /**
     * Disables NPN for all SSL connections in the context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.007 -0400", hash_original_method = "B11E564B94385BE2D5B6D28B4BC9058F", hash_generated_method = "9CA693E9FCDF4718FF333C3ADC6E2A17")
    
    public static void SSL_CTX_disable_npn(int sslCtxNativePointer){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.775 -0400", hash_original_method = "E1A402359249AC2C29E41F04821C1E25", hash_generated_method = "8B93F03153848CED038951F5725C1DFA")
    
    public static int EVP_CipherInit_ex(int cipherNid, byte[] key, byte[] iv,
                boolean encrypting){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += cipherNid;
    	taintDouble += key[0];
    	taintDouble += iv[0];
    	taintDouble += ((encrypting) ? 1 : 0);
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.623 -0400", hash_original_method = "35D804457F19357889105AE01F624C52", hash_generated_method = "196CD15B17A6BEA17CC8AB9BB91AA037")
    
    public static int EVP_PKEY_new_RSA(byte[] n, byte[] e, byte[] d, byte[] p, byte[] q,
                byte[] dmp1, byte[] dmq1, byte[] iqmp){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += n[0];
    	taintDouble += e[0];
    	taintDouble += d[0];
    	taintDouble += p[0];
    	taintDouble += q[0];
    	taintDouble += dmp1[0];
    	taintDouble += dmq1[0];
    	taintDouble += iqmp[0];
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.691 -0400", hash_original_method = "F59A7953B174B24062E2BF90EF57992D", hash_generated_method = "43B99270053A36047C19E1E353B010A9")
    
    public static byte[] i2d_RSAPrivateKey(int rsa){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += rsa;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.747 -0400", hash_original_method = "5A217F8C120D368DE39BDC8E20A3F0E5", hash_generated_method = "F17E1759AE58CA0B10DF52B736EF8B82")
    
    public static void EVP_SignUpdate(int ctx, byte[] buffer,
                                                   int offset, int length){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.653 -0400", hash_original_method = "A84EBA9C33BA95E256D0CD1CCC90F0E0", hash_generated_method = "F4633E47831514AA81AFBD3CF8F519C5")
    
    public static byte[] i2d_PUBKEY(int pkey){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += pkey;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.899 -0400", hash_original_method = "BF8EF87A8EA40B7A4209BF83A509C4A6", hash_generated_method = "AB771C358CCA832FB02A8E8D049BAA8C")
    
    public static void SSL_use_OpenSSL_PrivateKey(int ssl, int pkey){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.940 -0400", hash_original_method = "E92932E2769F54FDE808BF10DF0BCA69", hash_generated_method = "AA3801BC93A9CEBA6D3B4126907A79E1")
    
public static String[] getDefaultProtocols() {
        return new String[] { SUPPORTED_PROTOCOL_SSLV3,
                              SUPPORTED_PROTOCOL_TLSV1,
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.598 -0400", hash_original_method = "CC2C5077E3C2D93A784BD8A176096176", hash_generated_method = "19EEA8D7BB63908A567F6F5FCC18841E")
    
    public static int ENGINE_finish(int e){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += e;
    
    	return (int)taintDouble;
    }


    /**
     * Returns the sslSessionNativePointer of the negotiated session
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.011 -0400", hash_original_method = "E26D52AFBEEE2A68922D1897BB11C283", hash_generated_method = "B6F63B5D35FB3FBBE3A5F3E253B12ADB")
    
    public static int SSL_do_handshake(int sslNativePointer,
                                                  FileDescriptor fd,
                                                  SSLHandshakeCallbacks shc,
                                                  int timeoutMillis,
                                                  boolean client_mode,
                                                  byte[] npnProtocols)
            throws SSLException, SocketTimeoutException, CertificateException{
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    	taintDouble += fd.getTaintInt();
    	taintDouble += shc.getTaintInt();
    	taintDouble += timeoutMillis;
    	taintDouble += ((client_mode) ? 1 : 0);
    	taintDouble += npnProtocols[0];
    
    	return (int)taintDouble;
    }


    @DSBan(DSCat.PRIVATE_METHOD)


    @DSComment("Private Method")


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.577 -0400", hash_original_method = "59A9A08DBA9982417E5608D955218D51", hash_generated_method = "152D45A4BA4B0F1C312D94AAB908E950")
    
    private static void clinit(){
    	//Formerly a native method
    }

    public static int EVP_PKEY_new_RSA(byte[] n, byte[] e, byte[] d, byte[] p, byte[] q) {
        return (p[0] + q[0] + n[0] + e[0] + d[0] + 
                p.getTaintInt() + q.getTaintInt() + 
                n.getTaintInt() + e.getTaintInt() + d.getTaintInt());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.638 -0400", hash_original_method = "CD8CD747DBC65A2A88D21CCC20893889", hash_generated_method = "886C5F593B64B64B57B94B82ACFAB291")
    
    public static void EVP_PKEY_free(int pkey){
    	//Formerly a native method
    }


    // --- Message digest functions --------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.706 -0400", hash_original_method = "4639605EA4A0E22540B89617B844B366", hash_generated_method = "C142FC9AE901FF7800A58CB66820505F")
    
    public static int EVP_get_digestbyname(String name){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += name.getTaintInt();
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.710 -0400", hash_original_method = "46980BC11013A8C1C58DF44E2DA1EAF1", hash_generated_method = "3FBC0478B1B881866F0195F5F9C8CE8E")
    
    public static int EVP_MD_size(int evp_md){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += evp_md;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.715 -0400", hash_original_method = "035748D20B98FC0740DCE6A90B7FFAE2", hash_generated_method = "A00EA13E0CCB297248F0A81E9912E6C8")
    
    public static int EVP_MD_block_size(int evp_md){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += evp_md;
    
    	return (int)taintDouble;
    }


    // --- Message digest context functions --------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.719 -0400", hash_original_method = "B8843F27ED6DB5A617AF093803FD9D0E", hash_generated_method = "2C58CC22E0E908A28E0D92608419127F")
    
    public static void EVP_MD_CTX_destroy(int ctx){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.724 -0400", hash_original_method = "1ECCDE625542AC3B87D12691722F13C7", hash_generated_method = "FDF89846CEA3ACB3406B9712748C7304")
    
    public static int EVP_MD_CTX_copy(int ctx){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    
    	return (int)taintDouble;
    }


    // --- Digest handling functions -------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.728 -0400", hash_original_method = "016023D57D315ACD39E198A31375D179", hash_generated_method = "265B373C409C4DFBB2AF5EC2B91C9C6A")
    
    public static int EVP_DigestInit(int evp_md){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += evp_md;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.733 -0400", hash_original_method = "17F7840190C80CBDE96F10C268B2419D", hash_generated_method = "31C691F742114785BC83086058C7F28C")
    
    public static void EVP_DigestUpdate(int ctx, byte[] buffer, int offset, int length){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.738 -0400", hash_original_method = "F90CA1F8E285033C93895B1632E2CE5A", hash_generated_method = "4FBD1485ECACE969AB4BFEC0FD4E401E")
    
    public static int EVP_DigestFinal(int ctx, byte[] hash, int offset){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    	taintDouble += hash[0];
    	taintDouble += offset;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.756 -0400", hash_original_method = "9B748947D0AB121594A892A5E29A8446", hash_generated_method = "9E28D17A46927B691B4D8300B4B08F30")
    
    public static int EVP_VerifyInit(String algorithm){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += algorithm.getTaintInt();
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.761 -0400", hash_original_method = "ADF3B06D7728CC208411998D654B9D82", hash_generated_method = "8306871658A05CEF49EA05DF81015D70")
    
    public static void EVP_VerifyUpdate(int ctx, byte[] buffer,
                                                   int offset, int length){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.766 -0400", hash_original_method = "6A779D6FE55952F32C1C9B7B4B8EFAED", hash_generated_method = "4A2EEE07EF0D9CA70A76FE4C3E463592")
    
    public static int EVP_VerifyFinal(int ctx, byte[] signature,
                                                 int offset, int length, int key){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ctx;
    	taintDouble += signature[0];
    	taintDouble += offset;
    	taintDouble += length;
    	taintDouble += key;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.795 -0400", hash_original_method = "038305B765501AD2A470A35D0FCAA80A", hash_generated_method = "6BEA751017C0D1B2726F8BF49CA49956")
    
    public static void RAND_seed(byte[] seed){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.799 -0400", hash_original_method = "03AA9BDD30A7E036A6266646C741D126", hash_generated_method = "5EC1B9DBF754EDDB8BF3CA98AA76E25D")
    
    public static int RAND_load_file(String filename, long max_bytes){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += filename.getTaintInt();
    	taintDouble += max_bytes;
    
    	return (int)taintDouble;
    }


    // --- X509_NAME -----------------------------------------------------------

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.802 -0400", hash_original_method = "8B2F1CEC41FBF819685923522CA17444", hash_generated_method = "6B28337E34E82B1D54345B6B5D37280B")
    
public static int X509_NAME_hash(X500Principal principal) {
        return X509_NAME_hash(principal, "SHA1");
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.805 -0400", hash_original_method = "C17C757DF3C671578E2AD64FCF45039D", hash_generated_method = "5EBBFB09138D07E3FB0957A866CE746D")
    
public static int X509_NAME_hash_old(X500Principal principal) {
        return X509_NAME_hash(principal, "MD5");
    }
    @DSBan(DSCat.PRIVATE_METHOD)

    @DSComment("Private Method")

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.807 -0400", hash_original_method = "B344D9153FDACF8192135D5EDBC47AE4", hash_generated_method = "96D65C307A3DA21E0664FB2E60F0D2FD")
    
private static int X509_NAME_hash(X500Principal principal, String algorithm) {
        try {
            byte[] digest = MessageDigest.getInstance(algorithm).digest(principal.getEncoded());
            return Memory.peekInt(digest, 0, ByteOrder.LITTLE_ENDIAN);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    @DSBan(DSCat.PRIVATE_METHOD)


    @DSComment("Private Method")


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.827 -0400", hash_original_method = "2E5190E56F7FF68ACB3015B0CB8E2A04", hash_generated_method = "4E228C0756CB9FA5C05937BA2FE8210D")
    
private static void add(String standard, String openssl) {
        OPENSSL_TO_STANDARD_CIPHER_SUITES.put(openssl, standard);
        STANDARD_TO_OPENSSL_CIPHER_SUITES.put(standard, openssl);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.870 -0400", hash_original_method = "B41D6C3E83794CA72027FBD8916F2134", hash_generated_method = "A2465B2191A0E8B6ECC28F580545B517")
    
    public static int SSL_CTX_new(){
    	//Formerly a native method
    	double taintDouble = 0;
    
    	return (int)taintDouble;
    }


    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.874 -0400", hash_original_method = "E992C3F3F90B62E0551244900B94B100", hash_generated_method = "3D7DFB78F17D70B3C235908641BBF2B4")
    
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

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.877 -0400", hash_original_method = "441F524A9CDEE2C4724FDD0DDA52219B", hash_generated_method = "E692D155C970F0CFDF25498C8BBE6DF9")
    
public static String[] getSupportedCipherSuites() {
        return SUPPORTED_CIPHER_SUITES.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.881 -0400", hash_original_method = "CFD74B21B9EA5743AF462392B3287CD1", hash_generated_method = "7AE85AFD2B8D00F25ED89138D15C705B")
    
    public static void SSL_CTX_free(int ssl_ctx){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.889 -0400", hash_original_method = "E5B7C0A7D6AE6F85126497913DEF31FA", hash_generated_method = "8479AB9B229EE445E2DAC8436BA98D22")
    
    public static int SSL_new(int ssl_ctx) throws SSLException{
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl_ctx;
    
    	return (int)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.891 -0400", hash_original_method = "72E122187013708BACCA6AD76CAE16AD", hash_generated_method = "4A31EBD0504003546DBA1D0217827A21")
    
public static byte[][] encodeCertificates(Certificate[] certificates)
            throws CertificateEncodingException {
        byte[][] certificateBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            certificateBytes[i] = certificates[i].getEncoded();
        }
        return certificateBytes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.895 -0400", hash_original_method = "506013B0872B8D215268F2FE8AF0A6BB", hash_generated_method = "865FD030E647AC7FC2CB912D217FC7D9")
    
    public static void SSL_use_certificate(int ssl, byte[][] asn1DerEncodedCertificateChain){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.903 -0400", hash_original_method = "25A670B7F092DF53E83308F123DEF05A", hash_generated_method = "17FE9A37B2DABF8DBD9C0275E63942A3")
    
    public static void SSL_use_PrivateKey(int ssl, byte[] pkcs8EncodedPrivateKey){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.907 -0400", hash_original_method = "8E7239868887F223A716095852DAD591", hash_generated_method = "F5E37BD7B58986AD5505D8B915C06528")
    
    public static void SSL_check_private_key(int ssl) throws SSLException{
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.909 -0400", hash_original_method = "2D6986FABFE74112B0A6ED2D5EFD8130", hash_generated_method = "8766A83D65D1ACCCF510091C76CEC869")
    
public static byte[][] encodeIssuerX509Principals(X509Certificate[] certificates)
            throws CertificateEncodingException {
        byte[][] principalBytes = new byte[certificates.length][];
        for (int i = 0; i < certificates.length; i++) {
            principalBytes[i] = certificates[i].getIssuerX500Principal().getEncoded();
        }
        return principalBytes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.913 -0400", hash_original_method = "F44660D0EEABD1F4961BAA4E360DCECB", hash_generated_method = "E9889AF4C3507F9C9967B07D0B230362")
    
    public static void SSL_set_client_CA_list(int ssl, byte[][] asn1DerEncodedX500Principals){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.917 -0400", hash_original_method = "54DEAD4E59A72E885DFA2ED3FD14744D", hash_generated_method = "6A5D679787A530FA01719978C32AC784")
    
    public static long SSL_get_mode(int ssl){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.921 -0400", hash_original_method = "C3999A12FA66649C9CF9738A26F69AF8", hash_generated_method = "826DE517003F6BF775BA86D21C79CCA7")
    
    public static long SSL_set_mode(int ssl, long mode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    	taintDouble += mode;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.926 -0400", hash_original_method = "D9BE0CA4DB9C5FE19EF335E473EC5452", hash_generated_method = "38C614B58B455828AF1A84E1566455B3")
    
    public static long SSL_clear_mode(int ssl, long mode){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    	taintDouble += mode;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.930 -0400", hash_original_method = "43E225F6B38415DADC11EC8353B2375C", hash_generated_method = "251090B55DC715EC23C38040FD82BEBD")
    
    public static long SSL_get_options(int ssl){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.934 -0400", hash_original_method = "4F1575BEA73479FDCE00C88FFCB0C60F", hash_generated_method = "326CCED08572BD303F23E9AE17F9DA83")
    
    public static long SSL_set_options(int ssl, long options){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    	taintDouble += options;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.938 -0400", hash_original_method = "50945CAC029AC7ABB9EC2B1ECC18037A", hash_generated_method = "84AF7CFE4F51C64DD1B4469F0AE68FE6")
    
    public static long SSL_clear_options(int ssl, long options){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += ssl;
    	taintDouble += options;
    
    	return (long)taintDouble;
    }


    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.942 -0400", hash_original_method = "DBA41A8BD983A5BB8F13A2F7F70F9C8E", hash_generated_method = "D1644535DC17ABF8CB1F9D60CE00BD6C")
    
public static String[] getSupportedProtocols() {
        return new String[] { SUPPORTED_PROTOCOL_SSLV3,
                              SUPPORTED_PROTOCOL_TLSV1,
                              SUPPORTED_PROTOCOL_TLSV1_1,
                              SUPPORTED_PROTOCOL_TLSV1_2,
        };
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.946 -0400", hash_original_method = "A3189445BACD657CCE63A598850C94C4", hash_generated_method = "D3B2B55CDE4F8E747FB2E7586D3F9A56")
    
public static void setEnabledProtocols(int ssl, String[] protocols) {
        checkEnabledProtocols(protocols);
        // openssl uses negative logic letting you disable protocols.
        // so first, assume we need to set all (disable all) and clear none (enable none).
        // in the loop, selectively move bits from set to clear (from disable to enable)
        long optionsToSet = (SSL_OP_NO_SSLv3 | SSL_OP_NO_TLSv1 | SSL_OP_NO_TLSv1_1 | SSL_OP_NO_TLSv1_2);
        long optionsToClear = 0;
        for (int i = 0; i < protocols.length; i++) {
            String protocol = protocols[i];
            if (protocol.equals(SUPPORTED_PROTOCOL_SSLV3)) {
                optionsToSet &= ~SSL_OP_NO_SSLv3;
                optionsToClear |= SSL_OP_NO_SSLv3;
            } else if (protocol.equals(SUPPORTED_PROTOCOL_TLSV1)) {
                optionsToSet &= ~SSL_OP_NO_TLSv1;
                optionsToClear |= SSL_OP_NO_TLSv1;
            } else if (protocol.equals(SUPPORTED_PROTOCOL_TLSV1_1)) {
                optionsToSet &= ~SSL_OP_NO_TLSv1_1;
                optionsToClear |= SSL_OP_NO_TLSv1_1;
            } else if (protocol.equals(SUPPORTED_PROTOCOL_TLSV1_2)) {
                optionsToSet &= ~SSL_OP_NO_TLSv1_2;
                optionsToClear |= SSL_OP_NO_TLSv1_2;
            } else {
                // error checked by checkEnabledProtocols
                throw new IllegalStateException();
            }
        }

        SSL_set_options(ssl, optionsToSet);
        SSL_clear_options(ssl, optionsToClear);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.949 -0400", hash_original_method = "0AFE4151F3B25C3D8C182A3C00A452FD", hash_generated_method = "286ABDD81E27D3C695006E2FD3F28F99")
    
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
                    && (!protocol.equals(SUPPORTED_PROTOCOL_TLSV1))
                    && (!protocol.equals(SUPPORTED_PROTOCOL_TLSV1_1))
                    && (!protocol.equals(SUPPORTED_PROTOCOL_TLSV1_2))) {
                throw new IllegalArgumentException("protocol " + protocol
                                                   + " is not supported");
            }
        }
        return protocols;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.952 -0400", hash_original_method = "A2766F77BA7152D09EC4E13142518803", hash_generated_method = "89E9BF91CAEF1DAC9945A0C720354136")
    
    public static void SSL_set_cipher_lists(int ssl, String[] ciphers){
    	//Formerly a native method
    }


    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.955 -0400", hash_original_method = "590A1411A3915B3F10784B0A83240A94", hash_generated_method = "CA52C070E1F786A7670C7D42B30B4F53")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.958 -0400", hash_original_method = "2FECB01C291C5D2D3716483AA9BE1895", hash_generated_method = "1EA25300C2DE328E9440239AA10C4201")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.967 -0400", hash_original_method = "F3CB11551C79744236E757C86A89C757", hash_generated_method = "638413FBBE5E4D98EDF593B77FC983C2")
    
public static String[] getSupportedCompressionMethods() {
        return SUPPORTED_COMPRESSION_METHODS.clone();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.969 -0400", hash_original_method = "A901AF6EA414203A59788DDBAFC645BA", hash_generated_method = "D7C4C9E4F03582A737AED2F222D7568D")
    
public static final String[] getDefaultCompressionMethods() {
        return new String[] { SUPPORTED_COMPRESSION_METHOD_NULL };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.971 -0400", hash_original_method = "414D814ABD06A91544C6447388000DA1", hash_generated_method = "0609CE05A6E7ECC1A1262011FD7B3E79")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.975 -0400", hash_original_method = "305A7CF92E5DCD206A7820A87A30261A", hash_generated_method = "9D6FED887F6B31BB3ADA93A6A00B4B45")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.985 -0400", hash_original_method = "D5991F1593B5DFF42A0BD4944429D200", hash_generated_method = "592DD00F3272CD021865721F3E401FF7")
    
    public static void SSL_set_verify(int sslNativePointer, int mode){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.989 -0400", hash_original_method = "3AA944D4787C57D6833ACE5B6B19BA45", hash_generated_method = "08A8C233C58EFF9CD0A4B10C30AF76D4")
    
    public static void SSL_set_session(int sslNativePointer, int sslSessionNativePointer)
            throws SSLException{
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.992 -0400", hash_original_method = "9AEE0DF1291B45A7C52C50094DF6EB6D", hash_generated_method = "CC68A316158E5ACD25EBD28AB6277A16")
    
    public static void SSL_set_session_creation_enabled(
                int sslNativePointer, boolean creationEnabled) throws SSLException{
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.996 -0400", hash_original_method = "C91F463E44AACF0CCBFED47A5A4DDA70", hash_generated_method = "E14240FABBA46762976C7A0383BD872F")
    
    public static void SSL_set_tlsext_host_name(int sslNativePointer, String hostname)
                throws SSLException{
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.000 -0400", hash_original_method = "252C1C29357AD1A327E098C0E01EBE2C", hash_generated_method = "65C57C5EFA9199D8FB530AE479BF3773")
    
    public static String SSL_get_servername(int sslNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }

    
    public static int SSL_do_handshake(int sslNativePointer,
                                              FileDescriptor fd,
                                              SSLHandshakeCallbacks shc,
                                              int timeout,
                                              boolean client_mode) throws SSLException, SocketTimeoutException, CertificateException {

        int tmp = 0;
        if (client_mode)
            tmp = 1;

        return (sslNativePointer + fd.getTaintInt() +
                shc.getTaintInt() + timeout + tmp); 
    }

    /**
     * Currently only intended for forcing renegotiation for testing.
     * Not used within OpenSSLSocketImpl.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.018 -0400", hash_original_method = "653B6C837FBDC05DA46D59247AB99D55", hash_generated_method = "4CECCADFA12E8D755EE295A913536293")
    
    public static void SSL_renegotiate(int sslNativePointer) throws SSLException{
    	//Formerly a native method
    }


    /**
     * Returns the local ASN.1 DER encoded X509 certificates.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.022 -0400", hash_original_method = "9C9459C209AF6A03933646C306604001", hash_generated_method = "8165FBDB175CB66A773918D6626D5A78")
    
    public static byte[][] SSL_get_certificate(int sslNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    
    	byte[][] retObj = new byte[1][1]; 
    	retObj[0][0] = (byte)taintDouble;
    	return retObj;
    }


    /**
     * Returns the peer ASN.1 DER encoded X509 certificates.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.026 -0400", hash_original_method = "27FB5BDD05771A6867D8B0247E96EA3A", hash_generated_method = "36AA5472C2141277D80D22CE8446F10C")
    
    public static byte[][] SSL_get_peer_cert_chain(int sslNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslNativePointer;
    
        byte[][] retObj = new byte[1][1]; 
        retObj[0][0] = (byte)taintDouble;
        return retObj;
    }

    
    /**
     * Writes with the native SSL_write function to the encrypted data stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.033 -0400", hash_original_method = "F1FC57853E49CD4A809D89DC66CA24B9", hash_generated_method = "EAD5CB345E436EBA4F3222625571CDED")
    
    public static void SSL_write(int sslNativePointer,
                                            FileDescriptor fd,
                                            SSLHandshakeCallbacks shc,
                                            byte[] b, int off, int len)
            throws IOException{
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.037 -0400", hash_original_method = "D6296267E7D1CBFDEB0578E2523C55FF", hash_generated_method = "2E6D8DF5ED5C904F50FC86B2FBFF55B8")
    
    public static void SSL_interrupt(int sslNativePointer){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.040 -0400", hash_original_method = "0625AB3E153AEFC095B15E90FB759B31", hash_generated_method = "7EC7D907BF9119F1EA0D755841100C77")
    
    public static void SSL_shutdown(int sslNativePointer,
                                               FileDescriptor fd,
                                               SSLHandshakeCallbacks shc) throws IOException{
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.045 -0400", hash_original_method = "9F00C935FCEC36B4374289578D36E391", hash_generated_method = "FA7946F87BA15723419F27BE428CF70B")
    
    public static void SSL_free(int sslNativePointer){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.048 -0400", hash_original_method = "CD44E46983D412B5D2EEC17EC18CC606", hash_generated_method = "9AD182DB8404DF20928D24D990249D30")
    
    public static byte[] SSL_SESSION_session_id(int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslSessionNativePointer;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.052 -0400", hash_original_method = "B41C2184D4949F080C13604AEE3564E4", hash_generated_method = "680A6955792D7C09F4A8F9F43FE47493")
    
    public static long SSL_SESSION_get_time(int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslSessionNativePointer;
    
    	return (long)taintDouble;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.056 -0400", hash_original_method = "54C73834C635457F27C018A54D4C1897", hash_generated_method = "82FF995B6B3EF4A5A0479973BE0911EC")
    
    public static String SSL_SESSION_get_version(int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslSessionNativePointer;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.059 -0400", hash_original_method = "5DE7C381C066F8F6DDDDDAA28363179D", hash_generated_method = "64E5AFABB9B251554EF84585917F714C")
    
    public static String SSL_SESSION_cipher(int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslSessionNativePointer;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.063 -0400", hash_original_method = "8D112340AD4755DC5733A1E99B6A0424", hash_generated_method = "AB2362D8D3743C2B784B788BC9E8E7DF")
    
    public static String SSL_SESSION_compress_meth(int sslCtxNativePointer,
                                                              int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslCtxNativePointer;
    	taintDouble += sslSessionNativePointer;
    
    	String retObj = new String(); 
    	retObj.addTaint(taintDouble);
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.067 -0400", hash_original_method = "6A0EF236118FFEE85BA559ADCC961BF6", hash_generated_method = "4A462B279DC33FF76A6C719F3B0758E4")
    
    public static void SSL_SESSION_free(int sslSessionNativePointer){
    	//Formerly a native method
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.070 -0400", hash_original_method = "D7B308E7F52B2BB310370DED796194A2", hash_generated_method = "E73070F9E57CCEC4AAD65631FA3ACDBA")
    
    public static byte[] i2d_SSL_SESSION(int sslSessionNativePointer){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += sslSessionNativePointer;
    
    	byte[] retObj = new byte[1]; 
    	retObj[0] = (byte)taintDouble;
    	return retObj;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:19.074 -0400", hash_original_method = "12E103B5422E80FA5C5B7AEB8B3298F8", hash_generated_method = "0E4A44D3F97C6B6DFE86AB413EA9C8B7")
    
    public static int d2i_SSL_SESSION(byte[] data){
    	//Formerly a native method
    	double taintDouble = 0;
    	taintDouble += data[0];
    
    	return (int)taintDouble;
    }

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.791 -0400", hash_original_field = "C3CFB2FCD1E5EF44AE7C46878C170911", hash_generated_field = "96B3D7F063AB86A68380150319726EEF")


    public static final int RAND_SEED_LENGTH_IN_BYTES = 1024;
    
    public interface SSLHandshakeCallbacks {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void verifyCertificateChain(byte[][] asn1DerEncodedCertificateChain, String authMethod)
            throws CertificateException;
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void clientCertificateRequested(byte[] keyTypes,
                                               byte[][] asn1DerEncodedX500Principals)
            throws CertificateEncodingException, SSLException;
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void handshakeCompleted();
    }
    
    static {
        clinit();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.810 -0400", hash_original_field = "9E559542127D639B38EF0AC72F395217", hash_generated_field = "9023935C52A658A359F4EC994ADDAD3D")


    private static final String SUPPORTED_PROTOCOL_SSLV3 = "SSLv3";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.813 -0400", hash_original_field = "48998320448FD3BBFABE1E7E97EA1EB4", hash_generated_field = "5B202BC2B7655D8857447040CF43C754")

    private static final String SUPPORTED_PROTOCOL_TLSV1 = "TLSv1";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.821 -0400", hash_original_field = "11F142202670ED688C9E69FC8685331C", hash_generated_field = "97E16C9F2C2CC1721F1B1B68F46A60D5")


    public static final Map<String, String> OPENSSL_TO_STANDARD_CIPHER_SUITES
            = new HashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.824 -0400", hash_original_field = "902BD1235411D6DBB47E9EA30D1D5A37", hash_generated_field = "E10C27FC0C78FF9558F6C5C640B527B4")

    public static final Map<String, String> STANDARD_TO_OPENSSL_CIPHER_SUITES
            = new LinkedHashMap<String, String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.830 -0400", hash_original_field = "251C1E391299B2594F2D46BC7EFBD252", hash_generated_field = "99061485CAC02933CFB832A8FA01EF67")

    public static final String TLS_EMPTY_RENEGOTIATION_INFO_SCSV
            = "TLS_EMPTY_RENEGOTIATION_INFO_SCSV";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.834 -0400", hash_original_field = "AFA0037EECC832F9C7A79527C5852474", hash_generated_field = "91DE1DEF6C8DAA1D2D57F34F524A0E97")


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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:13.160 -0400", hash_original_field = "2CA15A751A7770AA3B85C160A5E41CA4", hash_generated_field = "FB7CED1C7FD31B52CA41A1562BE8447E")


    // SSL mode from ssl.h
    public static final long SSL_MODE_HANDSHAKE_CUTTHROUGH = 0x00000040L;
    static {
        int size = STANDARD_TO_OPENSSL_CIPHER_SUITES.size();
        SUPPORTED_CIPHER_SUITES = new String[size + 1];
        STANDARD_TO_OPENSSL_CIPHER_SUITES.keySet().toArray(SUPPORTED_CIPHER_SUITES);
        SUPPORTED_CIPHER_SUITES[size] = TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.850 -0400", hash_original_field = "DF4535FC2BE1313E2C5F82CA4BEAB175", hash_generated_field = "F599E1E38DE2FF7C5195192CDE8B77D9")

    public static final long SSL_OP_NO_TICKET                              = 0x00004000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.856 -0400", hash_original_field = "D2C0147ED3FA8EC0C8E1745AA05BBE7A", hash_generated_field = "DEE386528586EC46246396BFBFF5E31B")

    public static final long SSL_OP_NO_COMPRESSION                         = 0x00020000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.859 -0400", hash_original_field = "077DD13DDD20426B86466628C7314FF3", hash_generated_field = "4596713C51D4556006279A44FF3DC1E5")

    public static final long SSL_OP_NO_SSLv3                               = 0x02000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.861 -0400", hash_original_field = "F39E37361FFAE8717459417359498674", hash_generated_field = "04D5F157235A64D42E27F0360EC9A8E6")

    public static final long SSL_OP_NO_TLSv1                               = 0x04000000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.960 -0400", hash_original_field = "242A5D38B2FB7CAA9F8FD11439F35313", hash_generated_field = "0B35DC456000E4191A6B390D50E98C77")


    public static final String SUPPORTED_COMPRESSION_METHOD_ZLIB = "ZLIB";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.962 -0400", hash_original_field = "3F10C372087A167A730E250D9E42935C", hash_generated_field = "244E11EA71FD82C909AD9962624AEC91")

    public static final String SUPPORTED_COMPRESSION_METHOD_NULL = "NULL";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.965 -0400", hash_original_field = "C03CC1F5985255536672FA63A8B08EB3", hash_generated_field = "666CD3955D49FDE8D33C7478EA6E111C")


    private static final String[] SUPPORTED_COMPRESSION_METHODS
            = { SUPPORTED_COMPRESSION_METHOD_ZLIB, SUPPORTED_COMPRESSION_METHOD_NULL };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.977 -0400", hash_original_field = "C4DD847E91C1EFA9222F33CDA1EBAC2C", hash_generated_field = "1264308E1D0D1CDE461ADE126F53073B")

    public static final int SSL_VERIFY_NONE =                 0x00;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.979 -0400", hash_original_field = "C27A0FCCB40B3F92E8BBE4BB230929D5", hash_generated_field = "056F9710D986851C1F655920AA971C19")

    public static final int SSL_VERIFY_PEER =                 0x01;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-05 09:35:18.982 -0400", hash_original_field = "6988C47D07F3E2ECC0B12CAE4216A4A1", hash_generated_field = "A39492168197080C3D83D6E8C946708C")

    public static final int SSL_VERIFY_FAIL_IF_NO_PEER_CERT = 0x02;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.716 -0400", hash_original_method = "DDEFB157515C7447D58E1F6901777126", hash_generated_method = "DDEFB157515C7447D58E1F6901777126")
    public NativeCrypto ()
    {
        //Synthesized constructor
    }
}

