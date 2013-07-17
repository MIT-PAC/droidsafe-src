package org.apache.harmony.xnet.provider.jsse;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_field = "ECACFFFFC22141F3C1C9CF77DDF0308D", hash_generated_field = "BD1C84B906E542A0B7737CDBC958EBF4")

    private int ctx;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_field = "5F039B4EF0058A1D652F13D612375A5B", hash_generated_field = "C6E827FEAEE2EB61DBE5D9A85D4D8B6B")

    private int dsa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_field = "EF31070D66440687A73BEB6242F298BC", hash_generated_field = "08DC989B3FD973EC4E94901E8395CF84")

    private int rsa;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_field = "2E130D966996D5B7ADC4B805903D7A4A", hash_generated_field = "D1E1187B385C5797B4C8180AB8D613E0")

    private String evpAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_field = "ABCA5D984BD29AABF4010E7D76926040", hash_generated_field = "9BD39ECEAC31FB507C39A41CCA51990D")

    private final byte[] singleByte = new byte[1];
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.844 -0400", hash_original_method = "2A2E0ABF3B3B1A4964ED7A72D14B2724", hash_generated_method = "6039A2B9E426F48BF9069C3ACB148006")
    private  OpenSSLSignature(String algorithm) throws NoSuchAlgorithmException {
        super(algorithm);
        if("RSA-MD2".equals(algorithm))        
        {
            NoSuchAlgorithmException var5405A112E617FE00103022CAE2AB0CA5_1461693895 = new NoSuchAlgorithmException(algorithm);
            var5405A112E617FE00103022CAE2AB0CA5_1461693895.addTaint(taint);
            throw var5405A112E617FE00103022CAE2AB0CA5_1461693895;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.845 -0400", hash_original_method = "346ED399212AE09C0968D8FA1B5865A9", hash_generated_method = "33328BFB371B279A80C61D79F659F0DE")
    @Override
    protected void engineUpdate(byte input) {
        singleByte[0] = input;
        engineUpdate(singleByte, 0, 1);
        // ---------- Original Method ----------
        //singleByte[0] = input;
        //engineUpdate(singleByte, 0, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.846 -0400", hash_original_method = "781B79B8126ED66671017896416B5787", hash_generated_method = "199D18E8368D3530838ADA6E22327C55")
    @Override
    protected void engineUpdate(byte[] input, int offset, int len) {
        addTaint(len);
        addTaint(offset);
        addTaint(input[0]);
        if(state == SIGN)        
        {
            UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_227302546 = new UnsupportedOperationException();
            var81FA7E299EEE7F062EBFBEEF08B0464D_227302546.addTaint(taint);
            throw var81FA7E299EEE7F062EBFBEEF08B0464D_227302546;
        } //End block
        else
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.846 -0400", hash_original_method = "CB8A1B4C2EB685EAF12C2B9210E25AE9", hash_generated_method = "15DE3DBD8C0525FFE36C148F76A4E8F8")
    @Override
    protected Object engineGetParameter(String param) throws InvalidParameterException {
        addTaint(param.getTaint());
Object var540C13E9E156B687226421B24F2DF178_1222767903 =         null;
        var540C13E9E156B687226421B24F2DF178_1222767903.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1222767903;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.846 -0400", hash_original_method = "6488F7E05A5FB9520658BCE2FDFC51FF", hash_generated_method = "3F613A17F1E19DE2ADD9A312FBF6ED08")
    @Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        addTaint(privateKey.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_334209879 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_334209879.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_334209879;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.847 -0400", hash_original_method = "B5DEEBDD8940EADE5B18431959F129E2", hash_generated_method = "951A6907BA848536945C67AE156032F5")
    @Override
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        addTaint(publicKey.getTaint());
        if(publicKey instanceof DSAPublicKey)        
        {
            try 
            {
                DSAPublicKey dsaPublicKey = (DSAPublicKey)publicKey;
                DSAParams dsaParams = dsaPublicKey.getParams();
                dsa = NativeCrypto.EVP_PKEY_new_DSA(dsaParams.getP().toByteArray(),
                        dsaParams.getQ().toByteArray(), dsaParams.getG().toByteArray(),
                        dsaPublicKey.getY().toByteArray(), null);
            } //End block
            catch (Exception e)
            {
                InvalidKeyException varF522521D9392C2AD613C7567C21EFAAE_1720962942 = new InvalidKeyException(e);
                varF522521D9392C2AD613C7567C21EFAAE_1720962942.addTaint(taint);
                throw varF522521D9392C2AD613C7567C21EFAAE_1720962942;
            } //End block
        } //End block
        else
        if(publicKey instanceof RSAPublicKey)        
        {
            try 
            {
                RSAPublicKey rsaPublicKey = (RSAPublicKey)publicKey;
                rsa = NativeCrypto.EVP_PKEY_new_RSA(rsaPublicKey.getModulus().toByteArray(),
                        rsaPublicKey.getPublicExponent().toByteArray(), null, null, null);
            } //End block
            catch (Exception e)
            {
                InvalidKeyException varF522521D9392C2AD613C7567C21EFAAE_970069332 = new InvalidKeyException(e);
                varF522521D9392C2AD613C7567C21EFAAE_970069332.addTaint(taint);
                throw varF522521D9392C2AD613C7567C21EFAAE_970069332;
            } //End block
        } //End block
        else
        {
            InvalidKeyException var5D3448A6F61CCF883A8AC30588C0D279_888650153 = new InvalidKeyException("Need DSA or RSA public key");
            var5D3448A6F61CCF883A8AC30588C0D279_888650153.addTaint(taint);
            throw var5D3448A6F61CCF883A8AC30588C0D279_888650153;
        } //End block
        try 
        {
            ctx = NativeCrypto.EVP_VerifyInit(evpAlgorithm);
        } //End block
        catch (Exception ex)
        {
            RuntimeException varF35D3C95F99DACEE8C542CF38D772C50_1403848661 = new RuntimeException(ex);
            varF35D3C95F99DACEE8C542CF38D772C50_1403848661.addTaint(taint);
            throw varF35D3C95F99DACEE8C542CF38D772C50_1403848661;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.848 -0400", hash_original_method = "BB69CFAE2D7DAB40561C965B4584F359", hash_generated_method = "63674D7E8498AF443B36E38A5838B78A")
    @Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        addTaint(value.getTaint());
        addTaint(param.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.848 -0400", hash_original_method = "1867E471CA5CA87F27F3477ACB97988E", hash_generated_method = "2E68720082C1CD0DDC58FCD1AD7F5DB3")
    @Override
    protected byte[] engineSign() throws SignatureException {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_179524639 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_179524639.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_179524639;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.849 -0400", hash_original_method = "5335767B8D128F26CEBBB21EFAF129A4", hash_generated_method = "CD65A4D764FE9570833C19389FE29D83")
    @Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        addTaint(sigBytes[0]);
        int handle = (rsa != 0) ? rsa : dsa;
        if(handle == 0)        
        {
            SignatureException var4F29716846FADF369DEE71FC326C443A_717573418 = new SignatureException("Need DSA or RSA public key");
            var4F29716846FADF369DEE71FC326C443A_717573418.addTaint(taint);
            throw var4F29716846FADF369DEE71FC326C443A_717573418;
        } //End block
        try 
        {
            int result = NativeCrypto.EVP_VerifyFinal(ctx, sigBytes, 0, sigBytes.length, handle);
            boolean var1296E614A250C5BB8625DCE0F7073032_850417824 = (result == 1);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770531808 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770531808;
        } //End block
        catch (Exception ex)
        {
            SignatureException var09F43B2FC38765F5CCE913464C558758_1748560551 = new SignatureException(ex);
            var09F43B2FC38765F5CCE913464C558758_1748560551.addTaint(taint);
            throw var09F43B2FC38765F5CCE913464C558758_1748560551;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.850 -0400", hash_original_method = "ADE539E8C8A774F97769C848519F5DF9", hash_generated_method = "22FB1F6FCBE065255A928060D599B3F2")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(dsa != 0)            
            {
                NativeCrypto.EVP_PKEY_free(dsa);
            } //End block
            if(rsa != 0)            
            {
                NativeCrypto.EVP_PKEY_free(rsa);
            } //End block
            if(ctx != 0)            
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.850 -0400", hash_original_method = "B1183C6C9886C7590F89656BAE25BECA", hash_generated_method = "DE94EFB383F6D56E1927946DBDFD1608")
        public  MD5RSA() throws NoSuchAlgorithmException {
            super("RSA-MD5");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.851 -0400", hash_original_method = "52FBE190C92F5C8F173769172401F04E", hash_generated_method = "D986FEE06588614C43E9DAF463CBE8A8")
        public  SHA1RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA256RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.851 -0400", hash_original_method = "E7BAD1A6B461EB173260E3EA071C4D98", hash_generated_method = "FACA5E3ED2133628B04490DE37518174")
        public  SHA256RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA256");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA384RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.852 -0400", hash_original_method = "9FE2D91A88929DCA7C5B738CF76745E4", hash_generated_method = "5FFB04A117079BFEC3D624C2ADA45CEF")
        public  SHA384RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA384");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA512RSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.852 -0400", hash_original_method = "020897BEF8DEDF16062B317376B71FB5", hash_generated_method = "C6C7A91E8D9537A306EB69101DDC3A68")
        public  SHA512RSA() throws NoSuchAlgorithmException {
            super("RSA-SHA512");
            // ---------- Original Method ----------
        }

        
    }


    
    public static final class SHA1DSA extends OpenSSLSignature {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.852 -0400", hash_original_method = "E31D98400FA8DA28AFA04F7443B0CC39", hash_generated_method = "DCD379A979FD7A6DF1DFA89846B2D8E1")
        public  SHA1DSA() throws NoSuchAlgorithmException {
            super("DSA-SHA1");
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:31.852 -0400", hash_original_field = "3E5062DD6F68BBC584F08EF6B9E2CC56", hash_generated_field = "30CADFDA226F957BCA4F06420D70879B")

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

