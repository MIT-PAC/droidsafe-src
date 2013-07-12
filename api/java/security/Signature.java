package java.security;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Iterator;
import java.util.Set;
import org.apache.harmony.security.fortress.Engine;

public abstract class Signature extends SignatureSpi {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.524 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.524 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.524 -0400", hash_original_field = "9C233C6B104734A34A36247701B5D158", hash_generated_field = "CDF6660334629CDE27FDB0FE309B0222")

    protected int state = UNINITIALIZED;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.524 -0400", hash_original_method = "007DE01FB6A8AC35B06025EDE803711E", hash_generated_method = "64FBEE7041AF14FFB5E58DA4CDF89A1A")
    protected  Signature(String algorithm) {
        this.algorithm = algorithm;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.526 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "578BBC4728EF48653C92D72292AC6298")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_2076467430 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_2076467430.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_2076467430;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.526 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "B90BAC67056ABD8081B97D05A2D7D571")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_736534951 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_736534951.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_736534951;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.527 -0400", hash_original_method = "6F44917D7B2EA34B37DC316438211882", hash_generated_method = "DD5A0D573738A0D0584918D82BEC350D")
    public final void initVerify(PublicKey publicKey) throws InvalidKeyException {
        addTaint(publicKey.getTaint());
        engineInitVerify(publicKey);
        state = VERIFY;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.528 -0400", hash_original_method = "D5B41FE621F8332C2172FC7A18EF69C6", hash_generated_method = "AB625FDCAD9AC833D1972DAECBA94E63")
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
                    } 
                } 
    if(critical)                
                {
                    boolean[] keyUsage = ((X509Certificate) certificate)
                            .getKeyUsage();
    if((keyUsage != null) && (!keyUsage[0]))                    
                    {
                        InvalidKeyException var3C6FA66A427D89D7B509F5F9D450448C_1231622909 = new InvalidKeyException("The public key in the certificate cannot be used for digital signature purposes");
                        var3C6FA66A427D89D7B509F5F9D450448C_1231622909.addTaint(taint);
                        throw var3C6FA66A427D89D7B509F5F9D450448C_1231622909;
                    } 
                } 
            } 
        } 
        engineInitVerify(certificate.getPublicKey());
        state = VERIFY;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.528 -0400", hash_original_method = "B6C8D7AE33737E5AFF4E8BA0A220ACB3", hash_generated_method = "9EC332E0A351CFBE5A325E9A51C98470")
    public final void initSign(PrivateKey privateKey) throws InvalidKeyException {
        addTaint(privateKey.getTaint());
        engineInitSign(privateKey);
        state = SIGN;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.529 -0400", hash_original_method = "94B0D7FD7FB8599FDCD6F4025918B2A9", hash_generated_method = "0BFEDA386B7448BD514F0BA3D12AC034")
    public final void initSign(PrivateKey privateKey, SecureRandom random) throws InvalidKeyException {
        addTaint(random.getTaint());
        addTaint(privateKey.getTaint());
        engineInitSign(privateKey, random);
        state = SIGN;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.529 -0400", hash_original_method = "1CBD4CB00E49A2B9C590273D2FD8D112", hash_generated_method = "AC82380C56BA1A60191A4FC64DB55DAF")
    public final byte[] sign() throws SignatureException {
    if(state != SIGN)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1813998116 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1813998116.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1813998116;
        } 
        byte[] var2C28DE2A22EF8329373C917F693CF6C7_639282278 = (engineSign());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_923244293 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_923244293;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.530 -0400", hash_original_method = "82A870C6C8965CC8E79085F7D8A960EB", hash_generated_method = "F211FDA96B3DDABC2F46CF8E0CBD2B02")
    public final int sign(byte[] outbuf, int offset, int len) throws SignatureException {
        addTaint(len);
        addTaint(offset);
        addTaint(outbuf[0]);
    if(outbuf == null || offset < 0 || len < 0 ||
                offset + len > outbuf.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_299508453 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_299508453.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_299508453;
        } 
    if(state != SIGN)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_968153170 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_968153170.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_968153170;
        } 
        int var763D82640E86A4C5F7903F8DDFF5815F_386814637 = (engineSign(outbuf, offset, len));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080163519 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2080163519;
        
        
                
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.531 -0400", hash_original_method = "C9B26283C94B06BB8BE60C57C40A18DF", hash_generated_method = "5C4F845FCDE8953D37AFA7DCF7B13FE4")
    public final boolean verify(byte[] signature) throws SignatureException {
        addTaint(signature[0]);
    if(state != VERIFY)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_181715034 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_181715034.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_181715034;
        } 
        boolean varB6F9D942D920F26A694FF0FC6AC65A47_1286123114 = (engineVerify(signature));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_413248057 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_413248057;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.531 -0400", hash_original_method = "59329C8B89ACE0AC6C4DAAF18DA3F3C5", hash_generated_method = "BA61929BFA3064E41A446AB9868D5FAB")
    public final boolean verify(byte[] signature, int offset, int length) throws SignatureException {
        addTaint(length);
        addTaint(offset);
        addTaint(signature[0]);
    if(state != VERIFY)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_784144335 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_784144335.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_784144335;
        } 
    if(signature == null || offset < 0 || length < 0 ||
                offset + length > signature.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_811334886 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_811334886.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_811334886;
        } 
        boolean varBAB0C0AC7EE46744B853605AEBD2E2DC_1710081127 = (engineVerify(signature, offset, length));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1686024229 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1686024229;
        
        
            
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.532 -0400", hash_original_method = "79EA6E53B3D29CDFCD3B6E1380EAFC50", hash_generated_method = "D5B4A2579BC15BDFB2050FCD536399A7")
    public final void update(byte b) throws SignatureException {
        addTaint(b);
    if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_887861950 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_887861950.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_887861950;
        } 
        engineUpdate(b);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.532 -0400", hash_original_method = "7FDD4CB7D645E432F89E836C71DCF871", hash_generated_method = "730B726BEABFEE07DBA84F5AFA434789")
    public final void update(byte[] data) throws SignatureException {
        addTaint(data[0]);
    if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_666815676 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_666815676.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_666815676;
        } 
        engineUpdate(data, 0, data.length);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.533 -0400", hash_original_method = "935040FEA1E890342F7B1ED90DB7090F", hash_generated_method = "9556FBBD9544CD801AEEB58E1AD56DCE")
    public final void update(byte[] data, int off, int len) throws SignatureException {
        addTaint(len);
        addTaint(off);
        addTaint(data[0]);
    if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1693573190 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1693573190.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1693573190;
        } 
    if(data == null || off < 0 || len < 0 ||
                off + len > data.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_22695818 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_22695818.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_22695818;
        } 
        engineUpdate(data, off, len);
        
        
            
        
        
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.533 -0400", hash_original_method = "4D212376BB0D0E0EE1EF0BE20DC8A649", hash_generated_method = "EEBDE50773B2411D1B52BDFAEE2406CC")
    public final void update(ByteBuffer data) throws SignatureException {
        addTaint(data.getTaint());
    if(state == UNINITIALIZED)        
        {
            SignatureException var125661CE8E1441B5F396C624407C3274_1820704398 = new SignatureException("Signature object is not initialized properly");
            var125661CE8E1441B5F396C624407C3274_1820704398.addTaint(taint);
            throw var125661CE8E1441B5F396C624407C3274_1820704398;
        } 
        engineUpdate(data);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.534 -0400", hash_original_method = "300ADD63628A84B0D8F725B1BA1E9A8E", hash_generated_method = "AE6013590D67ED52F3D587663CB9A40B")
    @Override
    public String toString() {
String var77ECA046F6C5DB9243992DFD1F17C516_1861157972 =         "SIGNATURE " + algorithm + " state: " + stateToString(state);
        var77ECA046F6C5DB9243992DFD1F17C516_1861157972.addTaint(taint);
        return var77ECA046F6C5DB9243992DFD1F17C516_1861157972;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.534 -0400", hash_original_method = "C1A460A3B710FBA1ED28C52AC5BBE911", hash_generated_method = "6730DFC0D1EE8F9155FE43A74B806F14")
    private String stateToString(int state) {
        addTaint(state);
switch(state){
        case UNINITIALIZED:
String var0DEA4415B2A1B8E47EFF8497DEECF3D8_1746980976 =         "UNINITIALIZED";
        var0DEA4415B2A1B8E47EFF8497DEECF3D8_1746980976.addTaint(taint);
        return var0DEA4415B2A1B8E47EFF8497DEECF3D8_1746980976;
        case SIGN:
String varEBE7E885F018E5F8485ABEA4ECFE0F97_627921701 =         "SIGN";
        varEBE7E885F018E5F8485ABEA4ECFE0F97_627921701.addTaint(taint);
        return varEBE7E885F018E5F8485ABEA4ECFE0F97_627921701;
        case VERIFY:
String varEBB636C9F64873CED41DB540B2211CD7_1271384823 =         "VERIFY";
        varEBB636C9F64873CED41DB540B2211CD7_1271384823.addTaint(taint);
        return varEBB636C9F64873CED41DB540B2211CD7_1271384823;
        default:
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1927252943 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1927252943.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1927252943;
}
        
        
        
            
        
            
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.534 -0400", hash_original_method = "D52E00AF44B32CEF42E7B7F3CD02413C", hash_generated_method = "37D481D51E183D8D9990C88466483BAF")
    @Deprecated
    public final void setParameter(String param, Object value) throws InvalidParameterException {
        addTaint(value.getTaint());
        addTaint(param.getTaint());
        engineSetParameter(param, value);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.535 -0400", hash_original_method = "723DAA3D9E86E61831D60007CF8F8BBA", hash_generated_method = "74522E307F3F14D563012F94B2A5F555")
    public final void setParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        engineSetParameter(params);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.535 -0400", hash_original_method = "8EDBC3AD900BE7B10A8F191CA049C5A8", hash_generated_method = "D8DFDA5592908D6C755EC78E401FF894")
    public final AlgorithmParameters getParameters() {
AlgorithmParameters var143868FBE13878C430B11AC612630761_17378298 =         engineGetParameters();
        var143868FBE13878C430B11AC612630761_17378298.addTaint(taint);
        return var143868FBE13878C430B11AC612630761_17378298;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.536 -0400", hash_original_method = "3218EA86DC018EF694546DAFA3BC417D", hash_generated_method = "879697C876CAF2B1F26AC63566A2F066")
    @Deprecated
    public final Object getParameter(String param) throws InvalidParameterException {
        addTaint(param.getTaint());
Object var940C682D170C73A367318C1A4CB6F451_1327808745 =         engineGetParameter(param);
        var940C682D170C73A367318C1A4CB6F451_1327808745.addTaint(taint);
        return var940C682D170C73A367318C1A4CB6F451_1327808745;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.536 -0400", hash_original_method = "31D01322C9910F836DA03F7FCF4D6261", hash_generated_method = "084D9C6E3F110C4C950D9407BA77044B")
    @Override
    public Object clone() throws CloneNotSupportedException {
    if(this instanceof Cloneable)        
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1620603630 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1620603630.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1620603630;
        } 
        CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_200848143 = new CloneNotSupportedException();
        var1615C718FF05C0D800F9FFF876AD8603_200848143.addTaint(taint);
        throw var1615C718FF05C0D800F9FFF876AD8603_200848143;
        
        
            
        
        
    }

    
    private static class SignatureImpl extends Signature {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.536 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "B117D5F80D09F234127E3A3393EBC255")

        private SignatureSpi spiImpl;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.537 -0400", hash_original_method = "3E4D7926596EAD873E22E30BA201B1D4", hash_generated_method = "8E14C27863E796A688E1E4917E3C061E")
        public  SignatureImpl(SignatureSpi signatureSpi, Provider provider,
                String algorithm) {
            super(algorithm);
            addTaint(algorithm.getTaint());
            addTaint(provider.getTaint());
            super.provider = provider;
            spiImpl = signatureSpi;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.537 -0400", hash_original_method = "FFC69249636133C4828AD78F0F12AF56", hash_generated_method = "93E43F76513EEC98380B3E5CA749E9DE")
        @Override
        protected byte[] engineSign() throws SignatureException {
            byte[] varFDB3A8246D1A33F9AE44AE591143B543_1680847352 = (spiImpl.engineSign());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2008355762 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_2008355762;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.537 -0400", hash_original_method = "5E472B7CE8DF4677B6CD62A0BE3E6E55", hash_generated_method = "87FDD17A6B5EBAAFB8BBEFB2950D05BF")
        @Override
        protected void engineUpdate(byte arg0) throws SignatureException {
            addTaint(arg0);
            spiImpl.engineUpdate(arg0);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.538 -0400", hash_original_method = "5B50F80B75147450A8AE91D93998317F", hash_generated_method = "3128EDFF257F00B02AA70D87ACA9397F")
        @Override
        protected boolean engineVerify(byte[] arg0) throws SignatureException {
            addTaint(arg0[0]);
            boolean var0B72A81BE2B4644062350C16BC8CB81B_1674596099 = (spiImpl.engineVerify(arg0));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879727342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879727342;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.538 -0400", hash_original_method = "8E9D74168176A196545DE618D70F0045", hash_generated_method = "C243C3F4805D525D41637A1698367089")
        @Override
        protected void engineUpdate(byte[] arg0, int arg1, int arg2) throws SignatureException {
            addTaint(arg2);
            addTaint(arg1);
            addTaint(arg0[0]);
            spiImpl.engineUpdate(arg0, arg1, arg2);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.539 -0400", hash_original_method = "8D0AD1B347F88E648DA57C6C188D8255", hash_generated_method = "39A8B6FF5830D73DF44103525DD97607")
        @Override
        protected void engineInitSign(PrivateKey arg0) throws InvalidKeyException {
            addTaint(arg0.getTaint());
            spiImpl.engineInitSign(arg0);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.539 -0400", hash_original_method = "C51005CD648E9A95CA7D0B48071C4D8E", hash_generated_method = "2FA8EB08FB2AC527A2D109B341094316")
        @Override
        protected void engineInitVerify(PublicKey arg0) throws InvalidKeyException {
            addTaint(arg0.getTaint());
            spiImpl.engineInitVerify(arg0);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.539 -0400", hash_original_method = "BC25730F2F2C84CFB445E50D8EAB3A12", hash_generated_method = "71EABF0F2C24094867DB9B679B295CF2")
        @Override
        protected Object engineGetParameter(String arg0) throws InvalidParameterException {
            addTaint(arg0.getTaint());
Object varCE32E83F946A002A5075AB939035A337_1101216157 =             spiImpl.engineGetParameter(arg0);
            varCE32E83F946A002A5075AB939035A337_1101216157.addTaint(taint);
            return varCE32E83F946A002A5075AB939035A337_1101216157;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.540 -0400", hash_original_method = "2EB6574DEFEEC579E00AC6D7C846FB9A", hash_generated_method = "A0620734AA6FF876354C66E0F38DFF65")
        @Override
        protected void engineSetParameter(String arg0, Object arg1) throws InvalidParameterException {
            addTaint(arg1.getTaint());
            addTaint(arg0.getTaint());
            spiImpl.engineSetParameter(arg0, arg1);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.540 -0400", hash_original_method = "E18D3A064C93BFFE53C93A44BEF059CB", hash_generated_method = "EDAFC9E5FD2F0606E2B21F5F05A07195")
        @Override
        public Object clone() throws CloneNotSupportedException {
    if(spiImpl instanceof Cloneable)            
            {
                SignatureSpi spi = (SignatureSpi) spiImpl.clone();
Object var6B61508400A6F12DA4F46A73D534C975_61794226 =                 new SignatureImpl(spi, getProvider(), getAlgorithm());
                var6B61508400A6F12DA4F46A73D534C975_61794226.addTaint(taint);
                return var6B61508400A6F12DA4F46A73D534C975_61794226;
            } 
            CloneNotSupportedException var1615C718FF05C0D800F9FFF876AD8603_1739023251 = new CloneNotSupportedException();
            var1615C718FF05C0D800F9FFF876AD8603_1739023251.addTaint(taint);
            throw var1615C718FF05C0D800F9FFF876AD8603_1739023251;
            
            
                
                
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.540 -0400", hash_original_field = "A295D45862B91D430A865A6C93B9F575", hash_generated_field = "F153FC2145A140C7EE9C30DF2197BDF3")

    private static final String SERVICE = "Signature";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.541 -0400", hash_original_field = "48254CA5EA2459783D1EB8D6358A6F88", hash_generated_field = "82D6520D3C45D5046B0A4FDCEDAFF880")

    private static Engine ENGINE = new Engine(SERVICE);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.541 -0400", hash_original_field = "7829D7E12A8615805E93FA4D71B48E33", hash_generated_field = "5981180EC86BD86C5A973C24E0F5F941")

    protected static final int UNINITIALIZED = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.541 -0400", hash_original_field = "AD0C3134958983CF0EFFDE205ED3D704", hash_generated_field = "9C254CF368BDF48B3D83BAA2B82A1195")

    protected static final int SIGN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:53.541 -0400", hash_original_field = "871D2CAC53DED1F4A79E8557E740F34B", hash_generated_field = "8738159158F0C7B8305EEDB4018256AD")

    protected static final int VERIFY = 3;
}

