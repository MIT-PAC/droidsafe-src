package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;






public class OpenSSLSignature extends Signature {

    /**
     * Creates a new OpenSSLSignature instance for the given algorithm name.
     *
     * @param algorithm The name of the algorithm, e.g. "SHA1WithRSA".
     *
     * @return The new OpenSSLSignature instance.
     *
     * @throws RuntimeException In case of problems.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.722 -0500", hash_original_method = "DDA7EDEE93457C94E7DD861968C9B300", hash_generated_method = "2507FDE2B79C162E4758BCD5DB9E7B7E")
    
public static OpenSSLSignature getInstance(String algorithm) throws NoSuchAlgorithmException {
        // System.out.println("getInstance() invoked with " + algorithm);

        Class <? extends OpenSSLSignature> clazz = jdkToOpenSsl.get(algorithm);
        if (clazz == null) {
            throw new NoSuchAlgorithmException(algorithm);
        }
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new NoSuchAlgorithmException(algorithm, e);
        } catch (IllegalAccessException e) {
            throw new NoSuchAlgorithmException(algorithm, e);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.707 -0500", hash_original_field = "4B33D26517CDA1D6382EB60B2B3E772A", hash_generated_field = "30CADFDA226F957BCA4F06420D70879B")


    private static Map<String,Class<? extends OpenSSLSignature>> jdkToOpenSsl
            = new HashMap<String,Class<? extends OpenSSLSignature>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.710 -0500", hash_original_field = "8215E0C121D6ABB0163C7AD91F0DBCC0", hash_generated_field = "BD1C84B906E542A0B7737CDBC958EBF4")

    private int ctx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.713 -0500", hash_original_field = "E6427C667E82363F1819F937B3BD28EC", hash_generated_field = "C6E827FEAEE2EB61DBE5D9A85D4D8B6B")

    private int dsa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.715 -0500", hash_original_field = "F6BB94CF022AE54B1E5EEEBD31A81159", hash_generated_field = "08DC989B3FD973EC4E94901E8395CF84")

    private int rsa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.717 -0500", hash_original_field = "40251453E5B5D4E153B9BFAC72E244E7", hash_generated_field = "D1E1187B385C5797B4C8180AB8D613E0")

    private  String evpAlgorithm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.719 -0500", hash_original_field = "C563C497DF1B0B36C3B298AC6308EB3F", hash_generated_field = "9BD39ECEAC31FB507C39A41CCA51990D")

    private final byte[] singleByte = new byte[1];

    /**
     * Creates a new OpenSSLSignature instance for the given algorithm name.
     *
     * @param algorithm OpenSSL name of the algorithm, e.g. "RSA-SHA1".
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.725 -0500", hash_original_method = "2A2E0ABF3B3B1A4964ED7A72D14B2724", hash_generated_method = "FA677E6C1FA5D2A4A5104A5809BB044A")
    
private OpenSSLSignature(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);

        // We don't support MD2
        if ("RSA-MD2".equals(algorithm)) {
            throw new NoSuchAlgorithmException(algorithm);
        }

        this.evpAlgorithm = algorithm;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.728 -0500", hash_original_method = "346ED399212AE09C0968D8FA1B5865A9", hash_generated_method = "5D332C421E104A58799A7702ECB73647")
    
@Override
    protected void engineUpdate(byte input) {
        singleByte[0] = input;
        engineUpdate(singleByte, 0, 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.731 -0500", hash_original_method = "781B79B8126ED66671017896416B5787", hash_generated_method = "965E1A7ACBEE83C7189948929CEFAB1A")
    
@Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        if (state == SIGN) {
            throw new UnsupportedOperationException();
        } else {
            NativeCrypto.EVP_VerifyUpdate(ctx, input, offset, len);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.733 -0500", hash_original_method = "CB8A1B4C2EB685EAF12C2B9210E25AE9", hash_generated_method = "2645681A65B65C16E824CFEDB218AB5F")
    
@Override
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.736 -0500", hash_original_method = "6488F7E05A5FB9520658BCE2FDFC51FF", hash_generated_method = "799441CD8F655224031E9815ACABF9D7")
    
@Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.738 -0500", hash_original_method = "B5DEEBDD8940EADE5B18431959F129E2", hash_generated_method = "79584A71BFF5B8DDB0BBDE3D2D3ABF42")
    
@Override
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        // System.out.println("engineInitVerify() invoked with "
        //                    + publicKey.getClass().getCanonicalName());

        if (publicKey instanceof DSAPublicKey) {
            try {
                DSAPublicKey dsaPublicKey = (DSAPublicKey)publicKey;
                DSAParams dsaParams = dsaPublicKey.getParams();
                dsa = NativeCrypto.EVP_PKEY_new_DSA(dsaParams.getP().toByteArray(),
                        dsaParams.getQ().toByteArray(), dsaParams.getG().toByteArray(),
                        dsaPublicKey.getY().toByteArray(), null);

            } catch (Exception e) {
                throw new InvalidKeyException(e);
            }
        } else if (publicKey instanceof RSAPublicKey) {
            try {
                RSAPublicKey rsaPublicKey = (RSAPublicKey)publicKey;
                rsa = NativeCrypto.EVP_PKEY_new_RSA(rsaPublicKey.getModulus().toByteArray(),
                        rsaPublicKey.getPublicExponent().toByteArray(), null, null, null);

            } catch (Exception e) {
                throw new InvalidKeyException(e);
            }
        } else {
            throw new InvalidKeyException("Need DSA or RSA public key");
        }

        try {
            ctx = NativeCrypto.EVP_VerifyInit(evpAlgorithm);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.741 -0500", hash_original_method = "BB69CFAE2D7DAB40561C965B4584F359", hash_generated_method = "345D8E7D2C6498BFEC059D973ABCD475")
    
@Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.743 -0500", hash_original_method = "1867E471CA5CA87F27F3477ACB97988E", hash_generated_method = "17C17D1376C963CE8488269EE67418F5")
    
@Override
    protected byte[] engineSign() throws SignatureException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.746 -0500", hash_original_method = "5335767B8D128F26CEBBB21EFAF129A4", hash_generated_method = "D59A16789A4CFF1100C4AF6F10592168")
    
@Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        int handle = (rsa != 0) ? rsa : dsa;

        if (handle == 0) {
            // This can't actually happen, but you never know...
            throw new SignatureException("Need DSA or RSA public key");
        }

        try {
            int result = NativeCrypto.EVP_VerifyFinal(ctx, sigBytes, 0, sigBytes.length, handle);
            return result == 1;
        } catch (Exception ex) {
            throw new SignatureException(ex);
        }

    }

    
    public static final class MD5RSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.752 -0500", hash_original_method = "B1183C6C9886C7590F89656BAE25BECA", hash_generated_method = "9DCFE763703F44FCA817CF40AB4C25D7")
        
public MD5RSA() throws NoSuchAlgorithmException {
            super("RSA-MD5");
        }

        
    }


    
    public static final class SHA1RSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.757 -0500", hash_original_method = "52FBE190C92F5C8F173769172401F04E", hash_generated_method = "B7D92F1E22696560B0B8FA4887FC4562")
        
public SHA1RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA1");
        }

        
    }


    
    public static final class SHA256RSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.762 -0500", hash_original_method = "E7BAD1A6B461EB173260E3EA071C4D98", hash_generated_method = "06E76CAE8E2E60CB138F17FA07C3029E")
        
public SHA256RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA256");
        }

        
    }


    
    public static final class SHA384RSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.767 -0500", hash_original_method = "9FE2D91A88929DCA7C5B738CF76745E4", hash_generated_method = "486E5EF4A5ADBF83144B3B1B5ED8F667")
        
public SHA384RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA384");
        }

        
    }


    
    public static final class SHA512RSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.772 -0500", hash_original_method = "020897BEF8DEDF16062B317376B71FB5", hash_generated_method = "7E689BC749849AB00AFDEF4CBF3A4801")
        
public SHA512RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA512");
        }

        
    }


    
    public static final class SHA1DSA extends OpenSSLSignature {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.778 -0500", hash_original_method = "E31D98400FA8DA28AFA04F7443B0CC39", hash_generated_method = "E9AE3004958A0A72FF78A4F2FCAB1311")
        
public SHA1DSA() throws NoSuchAlgorithmException {
            super("DSA-SHA1");
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:13.749 -0500", hash_original_method = "ADE539E8C8A774F97769C848519F5DF9", hash_generated_method = "4187FDAF6933EA0058CCED9CBB93E57B")
    
@Override protected void finalize() throws Throwable {
        try {
            if (dsa != 0) {
                NativeCrypto.EVP_PKEY_free(dsa);
            }

            if (rsa != 0) {
                NativeCrypto.EVP_PKEY_free(rsa);
            }

            if (ctx != 0) {
                NativeCrypto.EVP_MD_CTX_destroy(ctx);
            }
        } finally {
            super.finalize();
        }
    }
    static {
        jdkToOpenSsl.put("MD5WithRSAEncryption", MD5RSA.class);
        jdkToOpenSsl.put("MD5WithRSA", MD5RSA.class);
        jdkToOpenSsl.put("MD5/RSA", MD5RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.1.1.4", MD5RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.2.5with1.2.840.113549.1.1.1", MD5RSA.class);
        jdkToOpenSsl.put("SHA1WithRSAEncryption", SHA1RSA.class);
        jdkToOpenSsl.put("SHA1WithRSA", SHA1RSA.class);
        jdkToOpenSsl.put("SHA1/RSA", SHA1RSA.class);
        jdkToOpenSsl.put("SHA-1/RSA", SHA1RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.1.1.5", SHA1RSA.class);
        jdkToOpenSsl.put("1.3.14.3.2.26with1.2.840.113549.1.1.1", SHA1RSA.class);
        jdkToOpenSsl.put("1.3.14.3.2.26with1.2.840.113549.1.1.5", SHA1RSA.class);
        jdkToOpenSsl.put("1.3.14.3.2.29", SHA1RSA.class);
        jdkToOpenSsl.put("SHA256WithRSAEncryption", SHA256RSA.class);
        jdkToOpenSsl.put("SHA256WithRSA", SHA256RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.1.1.11", SHA256RSA.class);
        jdkToOpenSsl.put("SHA384WithRSAEncryption", SHA384RSA.class);
        jdkToOpenSsl.put("SHA384WithRSA", SHA384RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.1.1.12", SHA384RSA.class);
        jdkToOpenSsl.put("SHA512WithRSAEncryption", SHA512RSA.class);
        jdkToOpenSsl.put("SHA512WithRSA", SHA512RSA.class);
        jdkToOpenSsl.put("1.2.840.113549.1.1.13", SHA512RSA.class);
        jdkToOpenSsl.put("SHA1withDSA", SHA1DSA.class);
        jdkToOpenSsl.put("SHA/DSA", SHA1DSA.class);
        jdkToOpenSsl.put("DSA", SHA1DSA.class);
        jdkToOpenSsl.put("1.3.14.3.2.26with1.2.840.10040.4.1", SHA1DSA.class);
        jdkToOpenSsl.put("1.3.14.3.2.26with1.2.840.10040.4.3", SHA1DSA.class);
        jdkToOpenSsl.put("DSAWithSHA1", SHA1DSA.class);
        jdkToOpenSsl.put("1.2.840.10040.4.3", SHA1DSA.class);
    }
    
}

