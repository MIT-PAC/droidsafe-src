package java.security;

// Droidsafe Imports
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.Set;

import org.apache.harmony.security.fortress.Engine;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Signature extends SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.495 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.495 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.495 -0400", hash_original_field = "9C233C6B104734A34A36247701B5D158", hash_generated_field = "CDF6660334629CDE27FDB0FE309B0222")

    protected int state = UNINITIALIZED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.495 -0400", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "64FBEE7041AF14FFB5E58DA4CDF89A1A")
    protected  Signature(String algorithm) {
        this.algorithm = algorithm;
        // ---------- Original Method ----------
        //this.algorithm = algorithm;
    }

    
    public static Signature getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        Object spi = sap.spi;
        Provider provider = sap.provider;
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }

    
    public static Signature getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getSignatureInstance(algorithm, p);
    }

    
    public static Signature getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        return getSignatureInstance(algorithm, provider);
    }

    
    private static Signature getSignatureInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        if (spi instanceof Signature) {
            Signature result = (Signature) spi;
            result.algorithm = algorithm;
            result.provider = provider;
            return result;
        }
        return new SignatureImpl((SignatureSpi) spi, provider, algorithm);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.497 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "CCD2EE2C7649486BF9FE714F63F6CE49")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_921464364 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_921464364.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_921464364;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.498 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "3284202BA13FEB65B57F586A5880B0B5")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_2138983321 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_2138983321.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_2138983321;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.498 -0400", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "DD5A0D573738A0D0584918D82BEC350D")
    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        addTaint(publicKey.getTaint());
        engineInitVerify(publicKey);
        state = VERIFY;
        // ---------- Original Method ----------
        //engineInitVerify(publicKey);
        //state = VERIFY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.500 -0400", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "C2185580E25F6CE572CCD1D613FD6AD9")
    public final void initVerify(Certificate certificate) throws InvalidKeyException {
        addTaint(certificate.getTaint());
        if(certificate instanceof X509Certificate)        
        {
            Set ce = ((X509Certificate) certificate).getCriticalExtensionOIDs();
            boolean critical = false;
            if(ce != null && !ce.isEmpty())            
            {
for(Iterator i = ce.iterator();i.hasNext();)
                {
                    if("2.5.29.15".equals(i.next()))                    
                    {
                        critical = true;
                        break;
                    } //End block
                } //End block
                if(critical)                
                {
                    boolean[] keyUsage = ((X509Certificate) certificate)
                            .getKeyUsage();
                    if((keyUsage != null) && (!keyUsage[0]))                    
                    {
                        InvalidKeyException var3C6FA66A427D89D7B509F5F9D450448C_686300685 = new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
                        var3C6FA66A427D89D7B509F5F9D450448C_686300685.addTaint(taint);
                        throw var3C6FA66A427D89D7B509F5F9D450448C_686300685;
                    } //End block
                } //End block
            } //End block
        } //End block
        engineInitVerify(certificate.getPublicKey());
        state = VERIFY;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.501 -0400", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "9EC332E0A351CFBE5A325E9A51C98470")
    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        addTaint(privateKey.getTaint());
        engineInitSign(privateKey);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.502 -0400", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "0BFEDA386B7448BD514F0BA3D12AC034")
    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(privateKey.getTaint());
        engineInitSign(privateKey, random);
        state = SIGN;
        // ---------- Original Method ----------
        //engineInitSign(privateKey, random);
        //state = SIGN;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.503 -0400", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "533ED43C6EDE9D5BB0B36A386A790744")
    public final byte[] sign() throws SignatureException {
        if(state != SIGN)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1170400123 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1170400123.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1170400123;
        } //End block
        byte[] var2C28DE2A22EF8329373C917F693CF6C7_1366149983 = (engineSign());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1656019977 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1656019977;
        // ---------- Original Method ----------
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.504 -0400", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "CF3AED19BDC8BF1FD855E43D757145A2")
    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        addTaint(len);
        addTaint(offset);
        addTaint(outbuf[0]);
        if(outbuf == null || offset < 0 || len < 0 ||
                offset + len > outbuf.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_2142118935 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_2142118935.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_2142118935;
        } //End block
        if(state != SIGN)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1245949267 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1245949267.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1245949267;
        } //End block
        int var763D82640E86A4C5F7903F8DDFF5815F_1953176834 = (engineSign(outbuf, offset, len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505305478 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505305478;
        // ---------- Original Method ----------
        //if (outbuf == null || offset < 0 || len < 0 ||
                //offset + len > outbuf.length) {
            //throw new IllegalArgumentException();
        //}
        //if (state != SIGN) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineSign(outbuf, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.505 -0400", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "D87C88D33BC96097B1F8E1BB78267FEC")
    public final boolean verify(byte[] signature) throws SignatureException {
        addTaint(signature[0]);
        if(state != VERIFY)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_772236165 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_772236165.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_772236165;
        } //End block
        boolean varB6F9D942D920F26A694FF0FC6AC65A47_361770705 = (engineVerify(signature));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_835253123 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_835253123;
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //return engineVerify(signature);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.506 -0400", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "F39E793EC31FCD04AB8250C0373A10B8")
    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        addTaint(length);
        addTaint(offset);
        addTaint(signature[0]);
        if(state != VERIFY)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1206594013 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1206594013.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1206594013;
        } //End block
        if(signature == null || offset < 0 || length < 0 ||
                offset + length > signature.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1239105845 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1239105845.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1239105845;
        } //End block
        boolean varBAB0C0AC7EE46744B853605AEBD2E2DC_1447033554 = (engineVerify(signature, offset, length));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973904795 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973904795;
        // ---------- Original Method ----------
        //if (state != VERIFY) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //if (signature == null || offset < 0 || length < 0 ||
                //offset + length > signature.length) {
            //throw new IllegalArgumentException();
        //}
        //return engineVerify(signature, offset, length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.507 -0400", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "B3A63D51E8263654EA4A47F0F7F29E86")
    public final void update(byte b) throws SignatureException {
        addTaint(b);
        if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1056959427 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1056959427.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1056959427;
        } //End block
        engineUpdate(b);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(b);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.508 -0400", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "0884B528B2CEBD5AEDB8028EBF0072D1")
    public final void update(byte[] data) throws SignatureException {
        addTaint(data[0]);
        if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1227466799 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1227466799.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1227466799;
        } //End block
        engineUpdate(data, 0, data.length);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data, 0, data.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.508 -0400", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "A4C797A4841B439C1C8FAECF56FE944D")
    public final void update(byte[] data, int off, int len) throws SignatureException {
        addTaint(len);
        addTaint(off);
        addTaint(data[0]);
        if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_2133801238 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_2133801238.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_2133801238;
        } //End block
        if(data == null || off < 0 || len < 0 ||
                off + len > data.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1321583892 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1321583892.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1321583892;
        } //End block
        engineUpdate(data, off, len);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //if (data == null || off < 0 || len < 0 ||
                //off + len > data.length) {
            //throw new IllegalArgumentException();
        //}
        //engineUpdate(data, off, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.508 -0400", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "0A43787CFEF67A94F46275A8CFA1C18A")
    public final void update(ByteBuffer data) throws SignatureException {
        addTaint(data.getTaint());
        if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_2138744214 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_2138744214.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_2138744214;
        } //End block
        engineUpdate(data);
        // ---------- Original Method ----------
        //if (state == UNINITIALIZED) {
            //throw new SignatureException("Signature object is not initialized properly");
        //}
        //engineUpdate(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.509 -0400", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "55880624F4C8733CB6F97A79EF7D7DFC")
    @Override
    public String toString() {
String var77ECA046F6C5DB9243992DFD1F17C516_12711862 =         "SIGNATURE " + algorithm + " state: " + stateToString(state);
        var77ECA046F6C5DB9243992DFD1F17C516_12711862.addTaint(taint);
        return var77ECA046F6C5DB9243992DFD1F17C516_12711862;
        // ---------- Original Method ----------
        //return "SIGNATURE " + algorithm + " state: " + stateToString(state);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.509 -0400", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "92CFCC557D9FFBC58078B35C239F6094")
    private String stateToString(int state) {
        addTaint(state);
switch(state){
        case UNINITIALIZED:
String var0DEA4415B2A1B8E47EFF8497DEECF3D8_1638749269 =         "UNINITIALIZED";
        var0DEA4415B2A1B8E47EFF8497DEECF3D8_1638749269.addTaint(taint);
        return var0DEA4415B2A1B8E47EFF8497DEECF3D8_1638749269;
        case SIGN:
String varEBE7E885F018E5F8485ABEA4ECFE0F97_1506737549 =         "SIGN";
        varEBE7E885F018E5F8485ABEA4ECFE0F97_1506737549.addTaint(taint);
        return varEBE7E885F018E5F8485ABEA4ECFE0F97_1506737549;
        case VERIFY:
String varEBB636C9F64873CED41DB540B2211CD7_338548844 =         "VERIFY";
        varEBB636C9F64873CED41DB540B2211CD7_338548844.addTaint(taint);
        return varEBB636C9F64873CED41DB540B2211CD7_338548844;
        default:
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1454035905 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1454035905.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1454035905;
}
        // ---------- Original Method ----------
        //switch (state) {
        //case UNINITIALIZED:
            //return "UNINITIALIZED";
        //case SIGN:
            //return "SIGN";
        //case VERIFY:
            //return "VERIFY";
        //default:
            //return "";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.509 -0400", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "37D481D51E183D8D9990C88466483BAF")
    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        addTaint(value.getTaint());
        addTaint(param.getTaint());
        engineSetParameter(param, value);
        // ---------- Original Method ----------
        //engineSetParameter(param, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.510 -0400", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "74522E307F3F14D563012F94B2A5F555")
    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        engineSetParameter(params);
        // ---------- Original Method ----------
        //engineSetParameter(params);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.510 -0400", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "0E3F924FD9B3A94A23989C95E44FE74C")
    public final AlgorithmParameters getParameters() {
AlgorithmParameters var143868FBE13878C430B11AC612630761_726180465 =         engineGetParameters();
        var143868FBE13878C430B11AC612630761_726180465.addTaint(taint);
        return var143868FBE13878C430B11AC612630761_726180465;
        // ---------- Original Method ----------
        //return engineGetParameters();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.511 -0400", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "A52F3E68015303744A5417DDEBE7B81A")
    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        addTaint(param.getTaint());
Object var940C682D170C73A367318C1A4CB6F451_1312532968 =         engineGetParameter(param);
        var940C682D170C73A367318C1A4CB6F451_1312532968.addTaint(taint);
        return var940C682D170C73A367318C1A4CB6F451_1312532968;
        // ---------- Original Method ----------
        //return engineGetParameter(param);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.511 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "277347EA4E1913EC2538C26C16C21947")
    @Override
    public Object clone() throws CloneNotSupportedException {
        if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1979423098 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1979423098.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1979423098;
        } //End block
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_1714377729 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_1714377729.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_1714377729;
        // ---------- Original Method ----------
        //if (this instanceof Cloneable) {
            //return super.clone();
        //}
        //throw new CloneNotSupportedException();
    }

    
    private static class SignatureImpl extends Signature {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.512 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B117D5F80D09F234127E3A3393EBC255")

        private SignatureSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.512 -0400", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "8E14C27863E796A688E1E4917E3C061E")
        public  SignatureImpl(SignatureSpi signatureSpi, Provider provider,
                String algorithm) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            addTaint(provider.getTaint());
            super.provider = provider;
            spiImpl = signatureSpi;
            // ---------- Original Method ----------
            //super.provider = provider;
            //spiImpl = signatureSpi;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.513 -0400", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "F11D728DB740A9BA2544100AA3C45389")
        @Override
        protected byte[] engineSign() throws SignatureException {
            byte[] varFDB3A8246D1A33F9AE44AE591143B543_1887180698 = (spiImpl.engineSign());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1196923229 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1196923229;
            // ---------- Original Method ----------
            //return spiImpl.engineSign();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.513 -0400", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "87FDD17A6B5EBAAFB8BBEFB2950D05BF")
        @Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.513 -0400", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "24DBA10696E248972E75102C3FECE445")
        @Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            addTaint(arg0[0]);
            boolean var0B72A81BE2B4644062350C16BC8CB81B_1862978070 = (spiImpl.engineVerify(arg0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1075367596 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1075367596;
            // ---------- Original Method ----------
            //return spiImpl.engineVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.514 -0400", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "C243C3F4805D525D41637A1698367089")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) throws SignatureException {
            addTaint(arg2);
            addTaint(arg1);
            addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            // ---------- Original Method ----------
            //spiImpl.engineUpdate(arg0, arg1, arg2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.514 -0400", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "39A8B6FF5830D73DF44103525DD97607")
        @Override
        protected void engineInitSign(PrivateKey arg0) throws InvalidKeyException {
            addTaint(arg0.getTaint());
            spiImpl.engineInitSign(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitSign(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.514 -0400", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "2FA8EB08FB2AC527A2D109B341094316")
        @Override
        protected void engineInitVerify(PublicKey arg0) throws InvalidKeyException {
            addTaint(arg0.getTaint());
            spiImpl.engineInitVerify(arg0);
            // ---------- Original Method ----------
            //spiImpl.engineInitVerify(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.515 -0400", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "931468FE039AC479BDA8D6445CD9C6AA")
        @Override
        protected Object engineGetParameter(String arg0) throws InvalidParameterException {
            addTaint(arg0.getTaint());
Object varCE32E83F946A002A5075AB939035A337_1274199962 =             spiImpl.engineGetParameter(arg0);
            varCE32E83F946A002A5075AB939035A337_1274199962.addTaint(taint);
            return varCE32E83F946A002A5075AB939035A337_1274199962;
            // ---------- Original Method ----------
            //return spiImpl.engineGetParameter(arg0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.515 -0400", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "A0620734AA6FF876354C66E0F38DFF65")
        @Override
        protected void engineSetParameter(String arg0, Object arg1) throws InvalidParameterException {
            addTaint(arg1.getTaint());
            addTaint(arg0.getTaint());
            spiImpl.engineSetParameter(arg0, arg1);
            // ---------- Original Method ----------
            //spiImpl.engineSetParameter(arg0, arg1);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.515 -0400", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "AB123B0AFF83376682BA420FD0BCB18B")
        @Override
        public Object clone() throws CloneNotSupportedException {
            if(spiImpl instanceof Cloneable)            
            {
                SignatureSpi spi = (SignatureSpi) spiImpl.clone();
Object var6B61508400A6F12DA4F46A73D534C975_703978186 =                 new SignatureImpl(spi, getProvider(), getAlgorithm());
                var6B61508400A6F12DA4F46A73D534C975_703978186.addTaint(taint);
                return var6B61508400A6F12DA4F46A73D534C975_703978186;
            } //End block
            CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_44949674 = new CloneNotSupportedException();
            var1615C718FF05C0D800F9FFF876AD8603_44949674.addTaint(taint);
            throw var1615C718FF05C0D800F9FFF876AD8603_44949674;
            // ---------- Original Method ----------
            //if (spiImpl instanceof Cloneable) {
                //SignatureSpi spi = (SignatureSpi) spiImpl.clone();
                //return new SignatureImpl(spi, getProvider(), getAlgorithm());
            //}
            //throw new CloneNotSupportedException();
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.516 -0400", hash_original_field = "A295D45862B91D430A865A6C93B9F575", hash_generated_field = "F153FC2145A140C7EE9C30DF2197BDF3")

    private static final String SERVICE = "Signature";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.516 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.516 -0400", hash_original_field = "7829D7E12A8615805E93FA4D71B48E33", hash_generated_field = "5981180EC86BD86C5A973C24E0F5F941")

    protected static final int UNINITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.516 -0400", hash_original_field = "AD0C3134958983CF0EFFDE205ED3D704", hash_generated_field = "9C254CF368BDF48B3D83BAA2B82A1195")

    protected static final int SIGN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.516 -0400", hash_original_field = "871D2CAC53DED1F4A79E8557E740F34B", hash_generated_field = "8738159158F0C7B8305EEDB4018256AD")

    protected static final int VERIFY = 3;
}

