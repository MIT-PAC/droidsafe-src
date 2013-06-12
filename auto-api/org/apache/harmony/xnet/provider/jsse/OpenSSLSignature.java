package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
import java.util.Locale;
import java.util.Map;

public class OpenSSLSignature extends Signature {
    private static Map<String,Class<? extends OpenSSLSignature>> jdkToOpenSsl
            = new HashMap<String,Class<? extends OpenSSLSignature>>();
    private int ctx;
    private int dsa;
    private int rsa;
    private final String evpAlgorithm;
    private final byte[] singleByte = new byte[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.953 -0400", hash_original_method = "2A2E0ABF3B3B1A4964ED7A72D14B2724", hash_generated_method = "76433738ACEAF05CA12B1874D93C35F7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private OpenSSLSignature(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);
        dsTaint.addTaint(algorithm);
        {
            boolean var9B035DEB4153ABE2CC245F8952726083_676222468 = ("RSA-MD2".equals(algorithm));
            {
                throw new NoSuchAlgorithmException(algorithm);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ("RSA-MD2".equals(algorithm)) {
            //throw new NoSuchAlgorithmException(algorithm);
        //}
        //this.evpAlgorithm = algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.953 -0400", hash_original_method = "C16AFA2976DA97B4197807736538ECAE", hash_generated_method = "EF282995BCEDD6F26648E919F3EB4EE1")
    private static void register(String algorithm, Class implementation) {
        jdkToOpenSsl.put(algorithm.toUpperCase(Locale.US), implementation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.953 -0400", hash_original_method = "D95617746699D57C099129AB19D1FE15", hash_generated_method = "D1A2616C0B35265ADF64B33D5887E51B")
    private static Class lookup(String algorithm) {
        return jdkToOpenSsl.get(algorithm.toUpperCase(Locale.US));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.953 -0400", hash_original_method = "E9DB8824BEE8534111125B172E9C6871", hash_generated_method = "9A2B15D91912BA9AECB4EE3966575466")
    public static OpenSSLSignature getInstance(String algorithm) throws NoSuchAlgorithmException {
        Class <? extends OpenSSLSignature> clazz = lookup(algorithm);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "346ED399212AE09C0968D8FA1B5865A9", hash_generated_method = "D397409E24E28A6985EBC0FF98827757")
    @DSModeled(DSC.SAFE)
    @Override
    protected void engineUpdate(byte input) {
        dsTaint.addTaint(input);
        singleByte[0] = input;
        engineUpdate(singleByte, 0, 1);
        // ---------- Original Method ----------
        //singleByte[0] = input;
        //engineUpdate(singleByte, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "781B79B8126ED66671017896416B5787", hash_generated_method = "202B00D8ECC82C220CAC34642A5CD197")
    @DSModeled(DSC.SAFE)
    @Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        dsTaint.addTaint(input);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            throw new UnsupportedOperationException();
        } //End block
        {
            NativeCrypto.EVP_VerifyUpdate(ctx, input, offset, len);
        } //End block
        // ---------- Original Method ----------
        //if (state == SIGN) {
            //throw new UnsupportedOperationException();
        //} else {
            //NativeCrypto.EVP_VerifyUpdate(ctx, input, offset, len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "CB8A1B4C2EB685EAF12C2B9210E25AE9", hash_generated_method = "C02D913F4F32F5D90154BC54EBC79E87")
    @DSModeled(DSC.SAFE)
    @Override
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        dsTaint.addTaint(param);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "6488F7E05A5FB9520658BCE2FDFC51FF", hash_generated_method = "0EDF8FA5E971045D084A24A6F53BEE97")
    @DSModeled(DSC.SAFE)
    @Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "B5DEEBDD8940EADE5B18431959F129E2", hash_generated_method = "9CAFC03FE888D42B7AE9AF09EA87FE7C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        dsTaint.addTaint(publicKey.dsTaint);
        {
            try 
            {
                DSAPublicKey dsaPublicKey;
                dsaPublicKey = (DSAPublicKey)publicKey;
                DSAParams dsaParams;
                dsaParams = dsaPublicKey.getParams();
                dsa = NativeCrypto.EVP_PKEY_new_DSA(dsaParams.getP().toByteArray(),
                        dsaParams.getQ().toByteArray(), dsaParams.getG().toByteArray(),
                        dsaPublicKey.getY().toByteArray(), null);
            } //End block
            catch (Exception e)
            {
                throw new InvalidKeyException(e);
            } //End block
        } //End block
        {
            try 
            {
                RSAPublicKey rsaPublicKey;
                rsaPublicKey = (RSAPublicKey)publicKey;
                rsa = NativeCrypto.EVP_PKEY_new_RSA(rsaPublicKey.getModulus().toByteArray(),
                        rsaPublicKey.getPublicExponent().toByteArray(), null, null, null);
            } //End block
            catch (Exception e)
            {
                throw new InvalidKeyException(e);
            } //End block
        } //End block
        {
            throw new InvalidKeyException("Need DSA or RSA public key");
        } //End block
        try 
        {
            ctx = NativeCrypto.EVP_VerifyInit(evpAlgorithm);
        } //End block
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "BB69CFAE2D7DAB40561C965B4584F359", hash_generated_method = "CABC3215AA0D4A2CEEDB7E7875883B1D")
    @DSModeled(DSC.SAFE)
    @Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        dsTaint.addTaint(param);
        dsTaint.addTaint(value.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "1867E471CA5CA87F27F3477ACB97988E", hash_generated_method = "418E52CCC3A0E2FBE496DB94A4AA80F3")
    @DSModeled(DSC.SAFE)
    @Override
    protected byte[] engineSign() throws SignatureException {
        throw new UnsupportedOperationException();
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "5335767B8D128F26CEBBB21EFAF129A4", hash_generated_method = "F0FC514A0851EEBFC4F467DA4F7F7024")
    @DSModeled(DSC.SAFE)
    @Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        dsTaint.addTaint(sigBytes);
        int handle;
        handle = rsa;
        handle = dsa;
        {
            throw new SignatureException("Need DSA or RSA public key");
        } //End block
        try 
        {
            int result;
            result = NativeCrypto.EVP_VerifyFinal(ctx, sigBytes, 0, sigBytes.length, handle);
        } //End block
        catch (Exception ex)
        {
            throw new SignatureException(ex);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int handle = (rsa != 0) ? rsa : dsa;
        //if (handle == 0) {
            //throw new SignatureException("Need DSA or RSA public key");
        //}
        //try {
            //int result = NativeCrypto.EVP_VerifyFinal(ctx, sigBytes, 0, sigBytes.length, handle);
            //return result == 1;
        //} catch (Exception ex) {
            //throw new SignatureException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "ADE539E8C8A774F97769C848519F5DF9", hash_generated_method = "E203803BEF3526C1E062462050642674")
    @DSModeled(DSC.SAFE)
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                NativeCrypto.EVP_PKEY_free(dsa);
            } //End block
            {
                NativeCrypto.EVP_PKEY_free(rsa);
            } //End block
            {
                NativeCrypto.EVP_MD_CTX_destroy(ctx);
            } //End block
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (dsa != 0) {
                //NativeCrypto.EVP_PKEY_free(dsa);
            //}
            //if (rsa != 0) {
                //NativeCrypto.EVP_PKEY_free(rsa);
            //}
            //if (ctx != 0) {
                //NativeCrypto.EVP_MD_CTX_destroy(ctx);
            //}
        //} finally {
            //super.finalize();
        //}
    }

    
    public static final class MD5RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "B1183C6C9886C7590F89656BAE25BECA", hash_generated_method = "312AC081CAD45EE3CDDFA169D6E0F4F1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MD5RSA() throws NoSuchAlgorithmException {
            super("RSA-MD5");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "52FBE190C92F5C8F173769172401F04E", hash_generated_method = "4F82A798E3C7894D899EA8B55D5CABFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA1RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA256RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "E7BAD1A6B461EB173260E3EA071C4D98", hash_generated_method = "B677C3187F1188D910D90CF44CD39F20")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA256RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA256");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA384RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "9FE2D91A88929DCA7C5B738CF76745E4", hash_generated_method = "EE1E6AC73FD1CC81927DDB0E6EBCBDBB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA384RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA384");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA512RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.954 -0400", hash_original_method = "020897BEF8DEDF16062B317376B71FB5", hash_generated_method = "A465490BC803C1A10A3E5E646032161E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA512RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA512");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1DSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.955 -0400", hash_original_method = "E31D98400FA8DA28AFA04F7443B0CC39", hash_generated_method = "F8A1D5B88E2CA7F1427263C2F8D015D4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA1DSA() throws NoSuchAlgorithmException {
            super("DSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    static {
        register("MD5WithRSAEncryption", MD5RSA.class);
        register("MD5WithRSA", MD5RSA.class);
        register("MD5/RSA", MD5RSA.class);
        register("1.2.840.113549.1.1.4", MD5RSA.class);
        register("1.2.840.113549.2.5with1.2.840.113549.1.1.1", MD5RSA.class);
        register("SHA1WithRSAEncryption", SHA1RSA.class);
        register("SHA1WithRSA", SHA1RSA.class);
        register("SHA1/RSA", SHA1RSA.class);
        register("SHA-1/RSA", SHA1RSA.class);
        register("1.2.840.113549.1.1.5", SHA1RSA.class);
        register("1.3.14.3.2.26with1.2.840.113549.1.1.1", SHA1RSA.class);
        register("1.3.14.3.2.26with1.2.840.113549.1.1.5", SHA1RSA.class);
        register("1.3.14.3.2.29", SHA1RSA.class);
        register("SHA256WithRSAEncryption", SHA256RSA.class);
        register("SHA256WithRSA", SHA256RSA.class);
        register("1.2.840.113549.1.1.11", SHA256RSA.class);
        register("SHA384WithRSAEncryption", SHA384RSA.class);
        register("SHA384WithRSA", SHA384RSA.class);
        register("1.2.840.113549.1.1.12", SHA384RSA.class);
        register("SHA512WithRSAEncryption", SHA512RSA.class);
        register("SHA512WithRSA", SHA512RSA.class);
        register("1.2.840.113549.1.1.13", SHA512RSA.class);
        register("SHA1withDSA", SHA1DSA.class);
        register("SHA/DSA", SHA1DSA.class);
        register("DSA", SHA1DSA.class);
        register("1.3.14.3.2.26with1.2.840.10040.4.1", SHA1DSA.class);
        register("1.3.14.3.2.26with1.2.840.10040.4.3", SHA1DSA.class);
        register("DSAWithSHA1", SHA1DSA.class);
        register("1.2.840.10040.4.3", SHA1DSA.class);
    }
    
}


