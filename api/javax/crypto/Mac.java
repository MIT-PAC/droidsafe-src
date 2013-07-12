package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.spec.AlgorithmParameterSpec;
import org.apache.harmony.security.fortress.Engine;

public class Mac implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.319 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.319 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "0128BA68CF49937E6689B3B2ABC40132")

    private MacSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.320 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.320 -0400", hash_original_field = "71273B8DA3C3CDBA76CC033ECFD09BB7", hash_generated_field = "3ABD1385745F27F79CF607C339AD7462")

    private boolean isInitMac;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.320 -0400", hash_original_method = "41257A854336509F555FDEC12089036E", hash_generated_method = "7032B200155C3BF44BC344231E63CB65")
    protected  Mac(MacSpi macSpi, Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = macSpi;
        this.isInitMac = false;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = macSpi;
        //this.isInitMac = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.321 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "9087DE4A9330B3BDDB39E54065FE3E43")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_1526371767 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_1526371767.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_1526371767;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.321 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "5A8D349AFCD51CF3C5A81B10FD1B4429")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1985049098 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1985049098.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1985049098;
        // ---------- Original Method ----------
        //return provider;
    }

    
        public static final Mac getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new Mac((MacSpi) sap.spi, sap.provider, algorithm);
    }

    
        public static final Mac getInstance(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException("Provider is null or empty");
        }
        Provider impProvider = Security.getProvider(provider);
        if (impProvider == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, impProvider);
    }

    
        public static final Mac getInstance(String algorithm, Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException("provider == null");
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new Mac((MacSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.322 -0400", hash_original_method = "02AEE303A4D099BA107FB2CB7C60A1E3", hash_generated_method = "0D8E50AAD42EB2629938272A48D74A9C")
    public final int getMacLength() {
        int var682E664C96A9B662D36EC2F18A07EE33_425966061 = (spiImpl.engineGetMacLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259289700 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259289700;
        // ---------- Original Method ----------
        //return spiImpl.engineGetMacLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.322 -0400", hash_original_method = "9228EAA32885A066BE953E8B5AE4C236", hash_generated_method = "D041EEE137593D811DB413D9EEC0BE93")
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
    if(key == null)        
        {
            InvalidKeyException var561EB6DA7D886C25C659084459A45580_1060411852 = new InvalidKeyException("key == null");
            var561EB6DA7D886C25C659084459A45580_1060411852.addTaint(taint);
            throw var561EB6DA7D886C25C659084459A45580_1060411852;
        } //End block
        spiImpl.engineInit(key, params);
        isInitMac = true;
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new InvalidKeyException("key == null");
        //}
        //spiImpl.engineInit(key, params);
        //isInitMac = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.323 -0400", hash_original_method = "874C36BA9BA67506DF1E27339862DC05", hash_generated_method = "8E2F899EFBB360AC6D723A1B530FD5BB")
    public final void init(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
    if(key == null)        
        {
            InvalidKeyException var561EB6DA7D886C25C659084459A45580_1081346125 = new InvalidKeyException("key == null");
            var561EB6DA7D886C25C659084459A45580_1081346125.addTaint(taint);
            throw var561EB6DA7D886C25C659084459A45580_1081346125;
        } //End block
        try 
        {
            spiImpl.engineInit(key, null);
            isInitMac = true;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_2062547285 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_2062547285.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_2062547285;
        } //End block
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new InvalidKeyException("key == null");
        //}
        //try {
            //spiImpl.engineInit(key, null);
            //isInitMac = true;
        //} catch (InvalidAlgorithmParameterException e) {
            //throw new RuntimeException(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.323 -0400", hash_original_method = "CE2C32417AC34B9F04F350B6B83BA3FB", hash_generated_method = "D8BCD4AB677973D76DDE1BCDC26F1C66")
    public final void update(byte input) throws IllegalStateException {
        addTaint(input);
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1183650263 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1183650263.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1183650263;
        } //End block
        spiImpl.engineUpdate(input);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //spiImpl.engineUpdate(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.324 -0400", hash_original_method = "715302E1C20F57A2A8D63A54A99663FC", hash_generated_method = "44FF34F1CC3A359B131A0B4F8B4864D4")
    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        addTaint(len);
        addTaint(offset);
        addTaint(input[0]);
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1638611937 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1638611937.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1638611937;
        } //End block
    if(input == null)        
        {
            return;
        } //End block
    if((offset < 0) || (len < 0) || ((offset + len) > input.length))        
        {
            IllegalArgumentException varD90B7656D507A0AA47CF759577F77B0C_367006160 = new IllegalArgumentException("Incorrect arguments");
            varD90B7656D507A0AA47CF759577F77B0C_367006160.addTaint(taint);
            throw varD90B7656D507A0AA47CF759577F77B0C_367006160;
        } //End block
        spiImpl.engineUpdate(input, offset, len);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input == null) {
            //return;
        //}
        //if ((offset < 0) || (len < 0) || ((offset + len) > input.length)) {
            //throw new IllegalArgumentException("Incorrect arguments");
        //}
        //spiImpl.engineUpdate(input, offset, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.324 -0400", hash_original_method = "3D6841DD3321DF543EE186C2C08CA7E2", hash_generated_method = "1F41DFCE510E0A3F440A6526C571A334")
    public final void update(byte[] input) throws IllegalStateException {
        addTaint(input[0]);
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1896957777 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1896957777.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1896957777;
        } //End block
    if(input != null)        
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.325 -0400", hash_original_method = "A1BB43A6E7623A403344D1C2F2A132EB", hash_generated_method = "6681CF89A2C6643F79E383AEAA270562")
    public final void update(ByteBuffer input) {
        addTaint(input.getTaint());
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_2122117791 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_2122117791.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_2122117791;
        } //End block
    if(input != null)        
        {
            spiImpl.engineUpdate(input);
        } //End block
        else
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_868155812 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_868155812.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_868155812;
        } //End block
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input);
        //} else {
            //throw new IllegalArgumentException("input == null");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.325 -0400", hash_original_method = "09A7E9E8BA2AA06F6A3808F7BB018D3B", hash_generated_method = "4E2F0FD6B1130E1ABFC282A237CAE3D5")
    public final byte[] doFinal() throws IllegalStateException {
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_89173384 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_89173384.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_89173384;
        } //End block
        byte[] var3F88785EF2C499F8A050A47ED1CB1FEC_1683941287 = (spiImpl.engineDoFinal());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1573447716 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1573447716;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.326 -0400", hash_original_method = "3A73D46F22DAF7149F49DD945D0B4F9C", hash_generated_method = "21C2C3E4F67ADA190D5480F54F90A9B6")
    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        addTaint(outOffset);
        addTaint(output[0]);
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1120909100 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1120909100.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1120909100;
        } //End block
    if(output == null)        
        {
            ShortBufferException var446DDB2F8E22809C1F40C876189351CE_493492827 = new ShortBufferException("output == null");
            var446DDB2F8E22809C1F40C876189351CE_493492827.addTaint(taint);
            throw var446DDB2F8E22809C1F40C876189351CE_493492827;
        } //End block
    if((outOffset < 0) || (outOffset >= output.length))        
        {
            ShortBufferException var7124C6EE3399F2D7037D3A40381E1031_303776403 = new ShortBufferException("Incorrect outOffset: " + outOffset);
            var7124C6EE3399F2D7037D3A40381E1031_303776403.addTaint(taint);
            throw var7124C6EE3399F2D7037D3A40381E1031_303776403;
        } //End block
        int t = spiImpl.engineGetMacLength();
    if(t > (output.length - outOffset))        
        {
            ShortBufferException varF7322BC0E6DACB842D8025AEE0CA403D_1472354140 = new ShortBufferException("Output buffer is short. Needed " + t + " bytes.");
            varF7322BC0E6DACB842D8025AEE0CA403D_1472354140.addTaint(taint);
            throw varF7322BC0E6DACB842D8025AEE0CA403D_1472354140;
        } //End block
        byte[] result = spiImpl.engineDoFinal();
        System.arraycopy(result, 0, output, outOffset, result.length);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (output == null) {
            //throw new ShortBufferException("output == null");
        //}
        //if ((outOffset < 0) || (outOffset >= output.length)) {
            //throw new ShortBufferException("Incorrect outOffset: " + outOffset);
        //}
        //int t = spiImpl.engineGetMacLength();
        //if (t > (output.length - outOffset)) {
            //throw new ShortBufferException("Output buffer is short. Needed " + t + " bytes.");
        //}
        //byte[] result = spiImpl.engineDoFinal();
        //System.arraycopy(result, 0, output, outOffset, result.length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.327 -0400", hash_original_method = "D317760A96395810E5039143278FB4E4", hash_generated_method = "DE72BA9878942671DCB3DF3A9747802C")
    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        addTaint(input[0]);
    if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_162775757 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_162775757.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_162775757;
        } //End block
    if(input != null)        
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        byte[] var3F88785EF2C499F8A050A47ED1CB1FEC_1181437009 = (spiImpl.engineDoFinal());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_9438314 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_9438314;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.327 -0400", hash_original_method = "81378E48B4C25C37826FA808778D1291", hash_generated_method = "77C57E72DC7D91B702D238A17B41BD51")
    public final void reset() {
        spiImpl.engineReset();
        // ---------- Original Method ----------
        //spiImpl.engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.328 -0400", hash_original_method = "D491B3C29A973D07513DEBD79BD84B18", hash_generated_method = "ABB1D77CD35FF8530D3B6513F53D4679")
    @Override
    public final Object clone() throws CloneNotSupportedException {
        MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
Object var36DD9F01D73A338B6C55C831B6AFFC27_222171004 =         mac;
        var36DD9F01D73A338B6C55C831B6AFFC27_222171004.addTaint(taint);
        return var36DD9F01D73A338B6C55C831B6AFFC27_222171004;
        // ---------- Original Method ----------
        //MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        //Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        //mac.isInitMac = this.isInitMac;
        //return mac;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:19.328 -0400", hash_original_field = "85CE784A77CAA5294BF3FA70EE513A6D", hash_generated_field = "806BD6BDD2ABE5FBF629090CA696D2F6")

    private static final Engine ENGINE = new Engine("Mac");
}

