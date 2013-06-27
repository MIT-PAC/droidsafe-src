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
import java.util.Map;

public class OpenSSLSignature extends Signature {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.296 -0400", hash_original_field = "ECACFFFFC22141F3C1C9CF77DDF0308D", hash_generated_field = "BD1C84B906E542A0B7737CDBC958EBF4")

    private int ctx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.296 -0400", hash_original_field = "5F039B4EF0058A1D652F13D612375A5B", hash_generated_field = "C6E827FEAEE2EB61DBE5D9A85D4D8B6B")

    private int dsa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.296 -0400", hash_original_field = "EF31070D66440687A73BEB6242F298BC", hash_generated_field = "08DC989B3FD973EC4E94901E8395CF84")

    private int rsa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.296 -0400", hash_original_field = "2E130D966996D5B7ADC4B805903D7A4A", hash_generated_field = "D1E1187B385C5797B4C8180AB8D613E0")

    private String evpAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.296 -0400", hash_original_field = "ABCA5D984BD29AABF4010E7D76926040", hash_generated_field = "7EDDD4E9C9E4FCF978DC887FC4DF1C80")

    private byte[] singleByte = new byte[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.297 -0400", hash_original_method = "2A2E0ABF3B3B1A4964ED7A72D14B2724", hash_generated_method = "91E1F1F663BB15C2EACFC4268AFBFD93")
    private  OpenSSLSignature(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);
        {
            boolean var9B035DEB4153ABE2CC245F8952726083_1419997696 = ("RSA-MD2".equals(algorithm));
            {
                if (DroidSafeAndroidRuntime.control) throw new NoSuchAlgorithmException(algorithm);
            } //End block
        } //End collapsed parenthetic
        this.evpAlgorithm = algorithm;
        // ---------- Original Method ----------
        //if ("RSA-MD2".equals(algorithm)) {
            //throw new NoSuchAlgorithmException(algorithm);
        //}
        //this.evpAlgorithm = algorithm;
    }

    
        public static OpenSSLSignature getInstance(String algorithm) throws NoSuchAlgorithmException {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.302 -0400", hash_original_method = "346ED399212AE09C0968D8FA1B5865A9", hash_generated_method = "33328BFB371B279A80C61D79F659F0DE")
    @Override
    protected void engineUpdate(byte input) {
        singleByte[0] = input;
        engineUpdate(singleByte, 0, 1);
        // ---------- Original Method ----------
        //singleByte[0] = input;
        //engineUpdate(singleByte, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.303 -0400", hash_original_method = "781B79B8126ED66671017896416B5787", hash_generated_method = "B5745E8112196A9E168E9179DDDE9C35")
    @Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        {
            if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        } //End block
        {
            NativeCrypto.EVP_VerifyUpdate(ctx, input, offset, len);
        } //End block
        addTaint(input[0]);
        addTaint(offset);
        addTaint(len);
        // ---------- Original Method ----------
        //if (state == SIGN) {
            //throw new UnsupportedOperationException();
        //} else {
            //NativeCrypto.EVP_VerifyUpdate(ctx, input, offset, len);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.303 -0400", hash_original_method = "CB8A1B4C2EB685EAF12C2B9210E25AE9", hash_generated_method = "A225CC2E61BF7F4242A59A74E53AB98B")
    @Override
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2120404555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2120404555 = null;
        addTaint(param.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2120404555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2120404555;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.303 -0400", hash_original_method = "6488F7E05A5FB9520658BCE2FDFC51FF", hash_generated_method = "2395ED19D5FA27B310B61C115E310B68")
    @Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        addTaint(privateKey.getTaint());
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.308 -0400", hash_original_method = "B5DEEBDD8940EADE5B18431959F129E2", hash_generated_method = "3DC5C411B702EC500145D44DB67F645E")
    @Override
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
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
        addTaint(publicKey.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.308 -0400", hash_original_method = "BB69CFAE2D7DAB40561C965B4584F359", hash_generated_method = "7BEA947E1474A3CD87BC2204E590B70A")
    @Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        addTaint(param.getTaint());
        addTaint(value.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.313 -0400", hash_original_method = "1867E471CA5CA87F27F3477ACB97988E", hash_generated_method = "FD1B03004965F29D8981D0AF8AD4CAC3")
    @Override
    protected byte[] engineSign() throws SignatureException {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException();
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1217500418 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1217500418;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.314 -0400", hash_original_method = "5335767B8D128F26CEBBB21EFAF129A4", hash_generated_method = "27FF4E0A199014128A4A559D41CA7CF1")
    @Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
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
        addTaint(sigBytes[0]);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2121862540 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2121862540;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.318 -0400", hash_original_method = "ADE539E8C8A774F97769C848519F5DF9", hash_generated_method = "A9824AD18E8003042D533A5D5F02F132")
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.319 -0400", hash_original_method = "B1183C6C9886C7590F89656BAE25BECA", hash_generated_method = "DE94EFB383F6D56E1927946DBDFD1608")
        public  MD5RSA() throws NoSuchAlgorithmException {
            super("RSA-MD5");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.319 -0400", hash_original_method = "52FBE190C92F5C8F173769172401F04E", hash_generated_method = "D986FEE06588614C43E9DAF463CBE8A8")
        public  SHA1RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA256RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.319 -0400", hash_original_method = "E7BAD1A6B461EB173260E3EA071C4D98", hash_generated_method = "FACA5E3ED2133628B04490DE37518174")
        public  SHA256RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA256");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA384RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.319 -0400", hash_original_method = "9FE2D91A88929DCA7C5B738CF76745E4", hash_generated_method = "5FFB04A117079BFEC3D624C2ADA45CEF")
        public  SHA384RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA384");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA512RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.319 -0400", hash_original_method = "020897BEF8DEDF16062B317376B71FB5", hash_generated_method = "C6C7A91E8D9537A306EB69101DDC3A68")
        public  SHA512RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA512");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1DSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.329 -0400", hash_original_method = "E31D98400FA8DA28AFA04F7443B0CC39", hash_generated_method = "DCD379A979FD7A6DF1DFA89846B2D8E1")
        public  SHA1DSA() throws NoSuchAlgorithmException {
            super("DSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:12.329 -0400", hash_original_field = "3E5062DD6F68BBC584F08EF6B9E2CC56", hash_generated_field = "30CADFDA226F957BCA4F06420D70879B")

    private static Map<String,Class<? extends OpenSSLSignature>> jdkToOpenSsl = new HashMap<String,Class<? extends OpenSSLSignature>>();
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

