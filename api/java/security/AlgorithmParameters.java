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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.759 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.759 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "9D41D4F6030CE195996EC7214F8C92A4")

    private AlgorithmParametersSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.760 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.760 -0400", hash_original_field = "84D10A1ED612E61DBF6880F6E3EE533A", hash_generated_field = "D96AC35F2092AB08D47BC799DE8F3A01")

    private boolean initialized;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.761 -0400", hash_original_method = "8DBC0799ED7E4900EBC29238B9DE7938", hash_generated_method = "FC9EF5F3B00E0445DB638E5CE884E307")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.762 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "712E2C3D99359BC895B2DB34838937E1")
    public final Provider getProvider() {
Provider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1971789133 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1971789133.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1971789133;
        // ---------- Original Method ----------
        //return provider;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.762 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "94BF1DA20E39B1FB373A6E74410665CE")
    public final String getAlgorithm() {
String var44A46B4003FC81ACB0223385BA1FA818_567538338 =         algorithm;
        var44A46B4003FC81ACB0223385BA1FA818_567538338.addTaint(taint);
        return var44A46B4003FC81ACB0223385BA1FA818_567538338;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.763 -0400", hash_original_method = "7E6C59119732596BEFEB2E6E8A90EC10", hash_generated_method = "8AC8EF5D25C8AA68F6F3B6B9716076F7")
    public final void init(AlgorithmParameterSpec paramSpec) throws InvalidParameterSpecException {
        addTaint(paramSpec.getTaint());
        if(initialized)        
        {
            InvalidParameterSpecException var5DB2ADB5E96DF64DAD68995CB4827B7B_1147983965 = new InvalidParameterSpecException("Parameter has already been initialized");
            var5DB2ADB5E96DF64DAD68995CB4827B7B_1147983965.addTaint(taint);
            throw var5DB2ADB5E96DF64DAD68995CB4827B7B_1147983965;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.763 -0400", hash_original_method = "617D5B707C3D1A91A18634DFC0D9F364", hash_generated_method = "4CB3CF2A238FD214AD15F19EFC3E8D81")
    public final void init(byte[] params) throws IOException {
        addTaint(params[0]);
        if(initialized)        
        {
            IOException var26602866FB927D6A5CB453D4A246F2C3_155041819 = new IOException("Parameter has already been initialized");
            var26602866FB927D6A5CB453D4A246F2C3_155041819.addTaint(taint);
            throw var26602866FB927D6A5CB453D4A246F2C3_155041819;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.764 -0400", hash_original_method = "7B3B0E8CD7575D668CB68D6510D827CC", hash_generated_method = "172F4F88C26D1B37D09196A64D906A8F")
    public final void init(byte[] params, String format) throws IOException {
        addTaint(format.getTaint());
        addTaint(params[0]);
        if(initialized)        
        {
            IOException var26602866FB927D6A5CB453D4A246F2C3_2129151439 = new IOException("Parameter has already been initialized");
            var26602866FB927D6A5CB453D4A246F2C3_2129151439.addTaint(taint);
            throw var26602866FB927D6A5CB453D4A246F2C3_2129151439;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.765 -0400", hash_original_method = "9BE0AC13DE94D992E08BA6CD89DD9D38", hash_generated_method = "DAA561BDD29669502F20C03B7972ADA6")
    public final <T extends AlgorithmParameterSpec> T getParameterSpec(Class<T> paramSpec) throws InvalidParameterSpecException {
        addTaint(paramSpec.getTaint());
        if(!initialized)        
        {
            InvalidParameterSpecException var54E4AE85F53D5769EC35860EC68CC518_1569405853 = new InvalidParameterSpecException("Parameter has not been initialized");
            var54E4AE85F53D5769EC35860EC68CC518_1569405853.addTaint(taint);
            throw var54E4AE85F53D5769EC35860EC68CC518_1569405853;
        } //End block
T var85314A191FE096CEB6FC1BB15A481DB0_510525874 =         spiImpl.engineGetParameterSpec(paramSpec);
        var85314A191FE096CEB6FC1BB15A481DB0_510525874.addTaint(taint);
        return var85314A191FE096CEB6FC1BB15A481DB0_510525874;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new InvalidParameterSpecException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetParameterSpec(paramSpec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.765 -0400", hash_original_method = "2345D83B19F14D228FA4A748BB5C0696", hash_generated_method = "6C0398B86C726A6FF0D279495CC43B78")
    public final byte[] getEncoded() throws IOException {
        if(!initialized)        
        {
            IOException varFF5A49CE886DAE4E8184341E6FCF0FCB_1786353718 = new IOException("Parameter has not been initialized");
            varFF5A49CE886DAE4E8184341E6FCF0FCB_1786353718.addTaint(taint);
            throw varFF5A49CE886DAE4E8184341E6FCF0FCB_1786353718;
        } //End block
        byte[] var74DF2EDCBF8D5B4561F96A3F84E23BB1_455208756 = (spiImpl.engineGetEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1147107733 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1147107733;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.766 -0400", hash_original_method = "5F0B9F7B1E2AFA510F6DA0646E7306FA", hash_generated_method = "E3B5CBA7E622F37265106A27206C7260")
    public final byte[] getEncoded(String format) throws IOException {
        addTaint(format.getTaint());
        if(!initialized)        
        {
            IOException varFF5A49CE886DAE4E8184341E6FCF0FCB_1326932397 = new IOException("Parameter has not been initialized");
            varFF5A49CE886DAE4E8184341E6FCF0FCB_1326932397.addTaint(taint);
            throw varFF5A49CE886DAE4E8184341E6FCF0FCB_1326932397;
        } //End block
        byte[] varF1DD7B79C07D160117794D1825EAE692_1873096010 = (spiImpl.engineGetEncoded(format));
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_878094143 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_878094143;
        // ---------- Original Method ----------
        //if (!initialized) {
            //throw new IOException("Parameter has not been initialized");
        //}
        //return spiImpl.engineGetEncoded(format);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.767 -0400", hash_original_method = "3487587F52CF5404E8DAC6B47C5FD08C", hash_generated_method = "6FABEB4C58A2537CBF82CA060A2F9A50")
    @Override
    public final String toString() {
        if(!initialized)        
        {
String var540C13E9E156B687226421B24F2DF178_853032847 =             null;
            var540C13E9E156B687226421B24F2DF178_853032847.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_853032847;
        } //End block
String varCE1E0EFB1D2A110810605AD0151D4ECA_1982536909 =         spiImpl.engineToString();
        varCE1E0EFB1D2A110810605AD0151D4ECA_1982536909.addTaint(taint);
        return varCE1E0EFB1D2A110810605AD0151D4ECA_1982536909;
        // ---------- Original Method ----------
        //if (!initialized) {
            //return null;
        //}
        //return spiImpl.engineToString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.767 -0400", hash_original_field = "BD287EEC5C314A263C8A703B0C369591", hash_generated_field = "2A5FC69C67235739D89B6E72871223E3")

    private static final String SEVICE = "AlgorithmParameters";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:54.767 -0400", hash_original_field = "F520423B8D44D86CE24ED3349D3881B9", hash_generated_field = "00A78935B1DF849DB7CCEEA674A30AFE")

    private static final Engine ENGINE = new Engine(SEVICE);
}

