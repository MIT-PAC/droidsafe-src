package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.apache.harmony.security.fortress.Engine;

public class AlgorithmParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.926 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.926 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "9D41D4F6030CE195996EC7214F8C92A4")

    private AlgorithmParametersSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.926 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.926 -0400", hash_original_field = "84D10A1ED612E61DBF6880F6E3EE533A", hash_generated_field = "D96AC35F2092AB08D47BC799DE8F3A01")

    private boolean initialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.927 -0400", hash_original_method = "8DBC0799ED7E4900EBC29238B9DE7938", hash_generated_method = "FC9EF5F3B00E0445DB638E5CE884E307")
    protected  AlgorithmParameters(AlgorithmParametersSpi algPramSpi,
            Provider provider, String algorithm) {
        this.provider = provider;
        this.algorithm = algorithm;
        this.spiImpl = algPramSpi;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = algPramSpi;
    }

    
        public static AlgorithmParameters getInstance(String algorithm) throws NoSuchAlgorithmException {
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Engine.SpiAndProvider sap = ENGINE.getInstance(algorithm, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) sap.spi, sap.provider, algorithm);
    }

    
        public static AlgorithmParameters getInstance(String algorithm,
            String provider) throws NoSuchAlgorithmException,
            NoSuchProviderException {
        if (provider == null || provider.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Provider p = Security.getProvider(provider);
        if (p == null) {
            throw new NoSuchProviderException(provider);
        }
        return getInstance(algorithm, p);
    }

    
        public static AlgorithmParameters getInstance(String algorithm,
            Provider provider) throws NoSuchAlgorithmException {
        if (provider == null) {
            throw new IllegalArgumentException();
        }
        if (algorithm == null) {
            throw new NullPointerException();
        }
        Object spi = ENGINE.getInstance(algorithm, provider, null);
        return new AlgorithmParameters((AlgorithmParametersSpi) spi, provider, algorithm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.928 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "3A3A255930DD2AB9225F281F862DB337")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_491395408 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_491395408.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_491395408;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.928 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "04B5EB2F008A96C721EE74C4F9D9C60C")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_184502094 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_184502094.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_184502094;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.929 -0400", hash_original_method = "7E6C59119732596BEFEB2E6E8A90EC10", hash_generated_method = "ABE00705779A04EE896556D41E416704")
    public final void init(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
        addTaint(paramSpec.getTaint());
    if(initialized)        
        {
            InvalidParameterSpecException var5DB2ADB5E96DF64DAD68995CB4827B7B_40015977 = new InvalidParameterSpecException("Parameter has already been initialized");
            var5DB2ADB5E96DF64DAD68995CB4827B7B_40015977.addTaint(taint);
            throw var5DB2ADB5E96DF64DAD68995CB4827B7B_40015977;
        } //End block
        spiImpl.engineInit(paramSpec);
        initialized = true;
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new InvalidParameterSpecException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(paramSpec);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.929 -0400", hash_original_method = "617D5B707C3D1A91A18634DFC0D9F364", hash_generated_method = "C12A91345B08632B4345CC9A53BBBF0F")
    public final void init(byte[] params) throws IOException {
        addTaint(params[0]);
    if(initialized)        
        {
            IOException var26602866FB927D6A5CB453D4A246F2C3_967778813 = new IOException("Parameter has already been initialized");
            var26602866FB927D6A5CB453D4A246F2C3_967778813.addTaint(taint);
            throw var26602866FB927D6A5CB453D4A246F2C3_967778813;
        } //End block
        spiImpl.engineInit(params);
        initialized = true;
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new IOException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(params);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.930 -0400", hash_original_method = "7B3B0E8CD7575D668CB68D6510D827CC", hash_generated_method = "BDA26DA8112164C211122F65B0F1D3B8")
    public final void init(byte[] params, String format) throws IOException {
        addTaint(format.getTaint());
        addTaint(params[0]);
    if(initialized)        
        {
            IOException var26602866FB927D6A5CB453D4A246F2C3_932070399 = new IOException("Parameter has already been initialized");
            var26602866FB927D6A5CB453D4A246F2C3_932070399.addTaint(taint);
            throw var26602866FB927D6A5CB453D4A246F2C3_932070399;
        } //End block
        spiImpl.engineInit(params, format);
        initialized = true;
        // ---------- Original Method ----------
        //if (initialized) {
            //throw new IOException("Parameter has already been initialized");
        //}
        //spiImpl.engineInit(params, format);
        //initialized = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.930 -0400", hash_original_method = "9BE0AC13DE94D992E08BA6CD89DD9D38", hash_generated_method = "2DD3C1E0D8841C7CC2BD3D73FE942149")
    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> paramSpec) throws InvalidParameterSpecException {
        addTaint(paramSpec.getTaint());
    if(!initialized)        
        {
            InvalidParameterSpecException var54E4AE85F53D5769EC35860EC68CC518_671257100 = new InvalidParameterSpecException("Parameter has not been initialized");
            var54E4AE85F53D5769EC35860EC68CC518_671257100.addTaint(taint);
            throw var54E4AE85F53D5769EC35860EC68CC518_671257100;
        } //End block
T var85314A191FE096CEB6FC1BB15A481DB0_1279402434 =         spiImpl.engineGetParameterSpec(paramSpec);
        var85314A191FE096CEB6FC1BB15A481DB0_1279402434.addTaint(taint);
        return var85314A191FE096CEB6FC1BB15A481DB0_1279402434;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new InvalidParameterSpecException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetParameterSpec(paramSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.931 -0400", hash_original_method = "2345D83B19F14D228FA4A748BB5C0696", hash_generated_method = "A64F34632E5022A92E18F94865CECEB2")
    public final byte[] getEncoded() throws IOException {
    if(!initialized)        
        {
            IOException varFF5A49CE886DAE4E8184341E6FCF0FCB_1177145090 = new IOException("Parameter has not been initialized");
            varFF5A49CE886DAE4E8184341E6FCF0FCB_1177145090.addTaint(taint);
            throw varFF5A49CE886DAE4E8184341E6FCF0FCB_1177145090;
        } //End block
        byte[] var74DF2EDCBF8D5B4561F96A3F84E23BB1_756855178 = (spiImpl.engineGetEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_398066940 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_398066940;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.931 -0400", hash_original_method = "5F0B9F7B1E2AFA510F6DA0646E7306FA", hash_generated_method = "8F6B979913776AC80C7F9FAA36AF0EC2")
    public final byte[] getEncoded(String format) throws IOException {
        addTaint(format.getTaint());
    if(!initialized)        
        {
            IOException varFF5A49CE886DAE4E8184341E6FCF0FCB_1103451964 = new IOException("Parameter has not been initialized");
            varFF5A49CE886DAE4E8184341E6FCF0FCB_1103451964.addTaint(taint);
            throw varFF5A49CE886DAE4E8184341E6FCF0FCB_1103451964;
        } //End block
        byte[] varF1DD7B79C07D160117794D1825EAE692_66626815 = (spiImpl.engineGetEncoded(format));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_436138989 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_436138989;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.931 -0400", hash_original_method = "3487587F52CF5404E8DAC6B47C5FD08C", hash_generated_method = "0A004DD3C5F43BD9CE767256BC769505")
    @Override
    public final String toString() {
    if(!initialized)        
        {
String var540C13E9E156B687226421B24F2DF178_793422023 =             null;
            var540C13E9E156B687226421B24F2DF178_793422023.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_793422023;
        } //End block
String varCE1E0EFB1D2A110810605AD0151D4ECA_806741560 =         spiImpl.engineToString();
        varCE1E0EFB1D2A110810605AD0151D4ECA_806741560.addTaint(taint);
        return varCE1E0EFB1D2A110810605AD0151D4ECA_806741560;
        // ---------- Original Method ----------
        //if (!initialized) {
            //return null;
        //}
        //return spiImpl.engineToString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.932 -0400", hash_original_field = "BD287EEC5C314A263C8A703B0C369591", hash_generated_field = "2A5FC69C67235739D89B6E72871223E3")

    private static final String SEVICE = "AlgorithmParameters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:57.932 -0400", hash_original_field = "F520423B8D44D86CE24ED3349D3881B9", hash_generated_field = "00A78935B1DF849DB7CCEEA674A30AFE")

    private static final Engine ENGINE = new Engine(SEVICE);
}

