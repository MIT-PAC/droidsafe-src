package javax.crypto;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Mac implements Cloneable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.259 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.259 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "0128BA68CF49937E6689B3B2ABC40132")

    private MacSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.259 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.259 -0400", hash_original_field = "71273B8DA3C3CDBA76CC033ECFD09BB7", hash_generated_field = "3ABD1385745F27F79CF607C339AD7462")

    private boolean isInitMac;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.261 -0400", hash_original_method = "41257A854336509F555FDEC12089036E", hash_generated_method = "7032B200155C3BF44BC344231E63CB65")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.262 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "BA87FF6DF730C188D932B0D6E6470CDE")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_476494383 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_476494383.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_476494383;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.262 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "7DA71835032FD3D29D50F9F118E1577A")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_806376510 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_806376510.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_806376510;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.265 -0400", hash_original_method = "02AEE303A4D099BA107FB2CB7C60A1E3", hash_generated_method = "88195A32B310944125B60164B95C8D40")
    public final int getMacLength() {
        int var682E664C96A9B662D36EC2F18A07EE33_1303082927 = (spiImpl.engineGetMacLength());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166372763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_166372763;
        // ---------- Original Method ----------
        //return spiImpl.engineGetMacLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.266 -0400", hash_original_method = "9228EAA32885A066BE953E8B5AE4C236", hash_generated_method = "2F2CA41C23E979A4890DC7AD6275794D")
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        addTaint(params.getTaint());
        addTaint(key.getTaint());
        if(key == null)        
        {
            InvalidKeyException var561EB6DA7D886C25C659084459A45580_35520156 = new InvalidKeyException("key == null");
            var561EB6DA7D886C25C659084459A45580_35520156.addTaint(taint);
            throw var561EB6DA7D886C25C659084459A45580_35520156;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.266 -0400", hash_original_method = "874C36BA9BA67506DF1E27339862DC05", hash_generated_method = "9DAC96B8FD5FEEEA4023BD5478A8E51C")
    public final void init(Key key) throws InvalidKeyException {
        addTaint(key.getTaint());
        if(key == null)        
        {
            InvalidKeyException var561EB6DA7D886C25C659084459A45580_177690772 = new InvalidKeyException("key == null");
            var561EB6DA7D886C25C659084459A45580_177690772.addTaint(taint);
            throw var561EB6DA7D886C25C659084459A45580_177690772;
        } //End block
        try 
        {
            spiImpl.engineInit(key, null);
            isInitMac = true;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            RuntimeException varC76ADF009CE2FEDD948F7A54F409BA37_1263167565 = new RuntimeException(e);
            varC76ADF009CE2FEDD948F7A54F409BA37_1263167565.addTaint(taint);
            throw varC76ADF009CE2FEDD948F7A54F409BA37_1263167565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.267 -0400", hash_original_method = "CE2C32417AC34B9F04F350B6B83BA3FB", hash_generated_method = "45B3867C830924E5F2A2B91D523FA7F2")
    public final void update(byte input) throws IllegalStateException {
        addTaint(input);
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1859599197 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1859599197.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1859599197;
        } //End block
        spiImpl.engineUpdate(input);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //spiImpl.engineUpdate(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.268 -0400", hash_original_method = "715302E1C20F57A2A8D63A54A99663FC", hash_generated_method = "408BCF3038CE299B2834380BDDA9ABFA")
    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        addTaint(len);
        addTaint(offset);
        addTaint(input[0]);
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_502727662 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_502727662.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_502727662;
        } //End block
        if(input == null)        
        {
            return;
        } //End block
        if((offset < 0) || (len < 0) || ((offset + len) > input.length))        
        {
            IllegalArgumentException varD90B7656D507A0AA47CF759577F77B0C_490915602 = new IllegalArgumentException("Incorrect arguments");
            varD90B7656D507A0AA47CF759577F77B0C_490915602.addTaint(taint);
            throw varD90B7656D507A0AA47CF759577F77B0C_490915602;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.269 -0400", hash_original_method = "3D6841DD3321DF543EE186C2C08CA7E2", hash_generated_method = "522060CC728BE4F2ECCD9994A7486629")
    public final void update(byte[] input) throws IllegalStateException {
        addTaint(input[0]);
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_649415576 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_649415576.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_649415576;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.271 -0400", hash_original_method = "A1BB43A6E7623A403344D1C2F2A132EB", hash_generated_method = "2E8F1217E5590EB75E9485587AEE3041")
    public final void update(ByteBuffer input) {
        addTaint(input.getTaint());
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1832966608 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1832966608.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1832966608;
        } //End block
        if(input != null)        
        {
            spiImpl.engineUpdate(input);
        } //End block
        else
        {
            IllegalArgumentException var6A6A965F33A186280ACCE222064E6554_893822233 = new IllegalArgumentException("input == null");
            var6A6A965F33A186280ACCE222064E6554_893822233.addTaint(taint);
            throw var6A6A965F33A186280ACCE222064E6554_893822233;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.272 -0400", hash_original_method = "09A7E9E8BA2AA06F6A3808F7BB018D3B", hash_generated_method = "19613AF18752916B0124B905484401E1")
    public final byte[] doFinal() throws IllegalStateException {
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1896084150 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1896084150.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1896084150;
        } //End block
        byte[] var3F88785EF2C499F8A050A47ED1CB1FEC_42826172 = (spiImpl.engineDoFinal());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_828304465 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_828304465;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.272 -0400", hash_original_method = "3A73D46F22DAF7149F49DD945D0B4F9C", hash_generated_method = "BDBD850E87273281A847C93ED1FB761B")
    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        addTaint(outOffset);
        addTaint(output[0]);
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1922399604 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_1922399604.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_1922399604;
        } //End block
        if(output == null)        
        {
            ShortBufferException var446DDB2F8E22809C1F40C876189351CE_1255382671 = new ShortBufferException("output == null");
            var446DDB2F8E22809C1F40C876189351CE_1255382671.addTaint(taint);
            throw var446DDB2F8E22809C1F40C876189351CE_1255382671;
        } //End block
        if((outOffset < 0) || (outOffset >= output.length))        
        {
            ShortBufferException var7124C6EE3399F2D7037D3A40381E1031_1789596831 = new ShortBufferException("Incorrect outOffset: " + outOffset);
            var7124C6EE3399F2D7037D3A40381E1031_1789596831.addTaint(taint);
            throw var7124C6EE3399F2D7037D3A40381E1031_1789596831;
        } //End block
        int t = spiImpl.engineGetMacLength();
        if(t > (output.length - outOffset))        
        {
            ShortBufferException varF7322BC0E6DACB842D8025AEE0CA403D_307931686 = new ShortBufferException("Output buffer is short. Needed " + t + " bytes.");
            varF7322BC0E6DACB842D8025AEE0CA403D_307931686.addTaint(taint);
            throw varF7322BC0E6DACB842D8025AEE0CA403D_307931686;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.273 -0400", hash_original_method = "D317760A96395810E5039143278FB4E4", hash_generated_method = "6EB6B7DFA3D625232FE79C9A1DB36499")
    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        addTaint(input[0]);
        if(!isInitMac)        
        {
            IllegalStateException varC311A989A119B96A6232C22ABFE87C25_185916197 = new IllegalStateException();
            varC311A989A119B96A6232C22ABFE87C25_185916197.addTaint(taint);
            throw varC311A989A119B96A6232C22ABFE87C25_185916197;
        } //End block
        if(input != null)        
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        byte[] var3F88785EF2C499F8A050A47ED1CB1FEC_852779962 = (spiImpl.engineDoFinal());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_623691399 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_623691399;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.274 -0400", hash_original_method = "81378E48B4C25C37826FA808778D1291", hash_generated_method = "77C57E72DC7D91B702D238A17B41BD51")
    public final void reset() {
        spiImpl.engineReset();
        // ---------- Original Method ----------
        //spiImpl.engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.274 -0400", hash_original_method = "D491B3C29A973D07513DEBD79BD84B18", hash_generated_method = "E28370C74BCEA8B2019782EB63F971DB")
    @Override
    public final Object clone() throws CloneNotSupportedException {
        MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
Object var36DD9F01D73A338B6C55C831B6AFFC27_259746982 =         mac;
        var36DD9F01D73A338B6C55C831B6AFFC27_259746982.addTaint(taint);
        return var36DD9F01D73A338B6C55C831B6AFFC27_259746982;
        // ---------- Original Method ----------
        //MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        //Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        //mac.isInitMac = this.isInitMac;
        //return mac;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:17.274 -0400", hash_original_field = "85CE784A77CAA5294BF3FA70EE513A6D", hash_generated_field = "806BD6BDD2ABE5FBF629090CA696D2F6")

    private static final Engine ENGINE = new Engine("Mac");
}

