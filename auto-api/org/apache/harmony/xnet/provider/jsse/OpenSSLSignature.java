package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int ctx;
    private int dsa;
    private int rsa;
    private String evpAlgorithm;
    private byte[] singleByte = new byte[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.896 -0400", hash_original_method = "2A2E0ABF3B3B1A4964ED7A72D14B2724", hash_generated_method = "4C562A6CBDD0E28D216B1E6FC9BC3169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private OpenSSLSignature(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);
        dsTaint.addTaint(algorithm);
        {
            boolean var9B035DEB4153ABE2CC245F8952726083_2071140427 = ("RSA-MD2".equals(algorithm));
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(algorithm);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if ("RSA-MD2".equals(algorithm)) {
            //throw new NoSuchAlgorithmException(algorithm);
        //}
        //this.evpAlgorithm = algorithm;
    }

    
        private static void register(String algorithm, Class implementation) {
        jdkToOpenSsl.put(algorithm.toUpperCase(Locale.US), implementation);
    }

    
        private static Class lookup(String algorithm) {
        return jdkToOpenSsl.get(algorithm.toUpperCase(Locale.US));
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.897 -0400", hash_original_method = "346ED399212AE09C0968D8FA1B5865A9", hash_generated_method = "04628FE5627BA02FCA306070AB3F8D99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void engineUpdate(byte input) {
        dsTaint.addTaint(input);
        singleByte[0] = input;
        engineUpdate(singleByte, 0, 1);
        // ---------- Original Method ----------
        //singleByte[0] = input;
        //engineUpdate(singleByte, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.897 -0400", hash_original_method = "781B79B8126ED66671017896416B5787", hash_generated_method = "40A46D95C1D8DBFE3106114407F48B1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.897 -0400", hash_original_method = "CB8A1B4C2EB685EAF12C2B9210E25AE9", hash_generated_method = "7D73C241CBCF6708DFD6F3E0C0D5F84A")
    @DSModeled(DSC.SAFE)
    @Override
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        dsTaint.addTaint(param);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.897 -0400", hash_original_method = "6488F7E05A5FB9520658BCE2FDFC51FF", hash_generated_method = "C55DBE3287B4115DF222428B942C58FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        dsTaint.addTaint(privateKey.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.898 -0400", hash_original_method = "B5DEEBDD8940EADE5B18431959F129E2", hash_generated_method = "25B03F1464CF76D692D029920D6D4623")
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
                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException(e);
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
                if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException(e);
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("Need DSA or RSA public key");
        } //End block
        try 
        {
            ctx = NativeCrypto.EVP_VerifyInit(evpAlgorithm);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(ex);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.898 -0400", hash_original_method = "BB69CFAE2D7DAB40561C965B4584F359", hash_generated_method = "3F9BDAFDBA709B899719D5694FF13398")
    @DSModeled(DSC.SAFE)
    @Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        dsTaint.addTaint(param);
        dsTaint.addTaint(value.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.898 -0400", hash_original_method = "1867E471CA5CA87F27F3477ACB97988E", hash_generated_method = "306DBBCF352B1610E019146D3F1D46C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected byte[] engineSign() throws SignatureException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.898 -0400", hash_original_method = "5335767B8D128F26CEBBB21EFAF129A4", hash_generated_method = "D0ACE4C3E94DB091025131F96CFA6F14")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        dsTaint.addTaint(sigBytes[0]);
        int handle;
        handle = rsa;
        handle = dsa;
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException("Need DSA or RSA public key");
        } //End block
        try 
        {
            int result;
            result = NativeCrypto.EVP_VerifyFinal(ctx, sigBytes, 0, sigBytes.length, handle);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new SignatureException(ex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.899 -0400", hash_original_method = "ADE539E8C8A774F97769C848519F5DF9", hash_generated_method = "A9824AD18E8003042D533A5D5F02F132")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.899 -0400", hash_original_method = "B1183C6C9886C7590F89656BAE25BECA", hash_generated_method = "DE94EFB383F6D56E1927946DBDFD1608")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public MD5RSA() throws NoSuchAlgorithmException {
            super("RSA-MD5");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.899 -0400", hash_original_method = "52FBE190C92F5C8F173769172401F04E", hash_generated_method = "D986FEE06588614C43E9DAF463CBE8A8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA1RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA256RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.899 -0400", hash_original_method = "E7BAD1A6B461EB173260E3EA071C4D98", hash_generated_method = "FACA5E3ED2133628B04490DE37518174")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA256RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA256");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA384RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.899 -0400", hash_original_method = "9FE2D91A88929DCA7C5B738CF76745E4", hash_generated_method = "5FFB04A117079BFEC3D624C2ADA45CEF")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA384RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA384");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA512RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.900 -0400", hash_original_method = "020897BEF8DEDF16062B317376B71FB5", hash_generated_method = "C6C7A91E8D9537A306EB69101DDC3A68")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA512RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA512");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1DSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.900 -0400", hash_original_method = "E31D98400FA8DA28AFA04F7443B0CC39", hash_generated_method = "DCD379A979FD7A6DF1DFA89846B2D8E1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SHA1DSA() throws NoSuchAlgorithmException {
            super("DSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    private static Map<String,Class<? extends OpenSSLSignature>> jdkToOpenSsl
            = new HashMap<String,Class<? extends OpenSSLSignature>>();
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

