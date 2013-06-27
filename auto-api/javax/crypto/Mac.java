package javax.crypto;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.878 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "2D84320E029EBF537A8555BC820086EF")

    private Provider provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.878 -0400", hash_original_field = "96FF779E0BE718F2D29D8C56320393D2", hash_generated_field = "0128BA68CF49937E6689B3B2ABC40132")

    private MacSpi spiImpl;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.878 -0400", hash_original_field = "ED469618898D75B149E5C7C4B6A1C415", hash_generated_field = "40E4722A302366B2A43F1CD6C99E2454")

    private String algorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.879 -0400", hash_original_field = "71273B8DA3C3CDBA76CC033ECFD09BB7", hash_generated_field = "3ABD1385745F27F79CF607C339AD7462")

    private boolean isInitMac;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.879 -0400", hash_original_method = "41257A854336509F555FDEC12089036E", hash_generated_method = "7032B200155C3BF44BC344231E63CB65")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.884 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "61352503F5A8EB20085556B85632C3B4")
    public final String getAlgorithm() {
        String varB4EAC82CA7396A68D541C85D26508E83_124926668 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_124926668 = algorithm;
        varB4EAC82CA7396A68D541C85D26508E83_124926668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_124926668;
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.886 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "7EA7F1F5A0C37A808F00E284DF7B5775")
    public final Provider getProvider() {
        Provider varB4EAC82CA7396A68D541C85D26508E83_1592312835 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1592312835 = provider;
        varB4EAC82CA7396A68D541C85D26508E83_1592312835.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592312835;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.887 -0400", hash_original_method = "02AEE303A4D099BA107FB2CB7C60A1E3", hash_generated_method = "20BDC629281826F9EA53F81184C14EF2")
    public final int getMacLength() {
        int varDE0776842F57D1FBC8679CFC79D95000_1933575444 = (spiImpl.engineGetMacLength());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149118264 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_149118264;
        // ---------- Original Method ----------
        //return spiImpl.engineGetMacLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.887 -0400", hash_original_method = "9228EAA32885A066BE953E8B5AE4C236", hash_generated_method = "D57C846C5F27C4AD47BA12CEAEB1A7CD")
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("key == null");
        } //End block
        spiImpl.engineInit(key, params);
        isInitMac = true;
        addTaint(key.getTaint());
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (key == null) {
            //throw new InvalidKeyException("key == null");
        //}
        //spiImpl.engineInit(key, params);
        //isInitMac = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.901 -0400", hash_original_method = "874C36BA9BA67506DF1E27339862DC05", hash_generated_method = "264D35287C0369B9D2FEF7BB8A9A9D25")
    public final void init(Key key) throws InvalidKeyException {
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("key == null");
        } //End block
        try 
        {
            spiImpl.engineInit(key, null);
            isInitMac = true;
        } //End block
        catch (InvalidAlgorithmParameterException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(e);
        } //End block
        addTaint(key.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.902 -0400", hash_original_method = "CE2C32417AC34B9F04F350B6B83BA3FB", hash_generated_method = "5DFCB6FDC782C8DFB117648F60C9333A")
    public final void update(byte input) throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        spiImpl.engineUpdate(input);
        addTaint(input);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //spiImpl.engineUpdate(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.907 -0400", hash_original_method = "715302E1C20F57A2A8D63A54A99663FC", hash_generated_method = "A4C8E8BBD89A2A76DB130F6757740817")
    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect arguments");
        } //End block
        spiImpl.engineUpdate(input, offset, len);
        addTaint(input[0]);
        addTaint(offset);
        addTaint(len);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.908 -0400", hash_original_method = "3D6841DD3321DF543EE186C2C08CA7E2", hash_generated_method = "2743217E627C9A00E31C36A82979E7C0")
    public final void update(byte[] input) throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        addTaint(input[0]);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.908 -0400", hash_original_method = "A1BB43A6E7623A403344D1C2F2A132EB", hash_generated_method = "F640ABBD91F9D516665F2CBC1D504360")
    public final void update(ByteBuffer input) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            spiImpl.engineUpdate(input);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
        } //End block
        addTaint(input.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.909 -0400", hash_original_method = "09A7E9E8BA2AA06F6A3808F7BB018D3B", hash_generated_method = "AC89E3C00488E4EA758D9FDF1E589A23")
    public final byte[] doFinal() throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] varF2FE2E7531EFB386D123AA3F78BCA993_1840028634 = (spiImpl.engineDoFinal());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_17300975 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_17300975;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.913 -0400", hash_original_method = "3A73D46F22DAF7149F49DD945D0B4F9C", hash_generated_method = "FB536952A34D45716AEDA33EF46912CE")
    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("output == null");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("Incorrect outOffset: " + outOffset);
        } //End block
        int t;
        t = spiImpl.engineGetMacLength();
        {
            if (DroidSafeAndroidRuntime.control) throw new ShortBufferException("Output buffer is short. Needed " + t + " bytes.");
        } //End block
        byte[] result;
        result = spiImpl.engineDoFinal();
        System.arraycopy(result, 0, output, outOffset, result.length);
        addTaint(output[0]);
        addTaint(outOffset);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.913 -0400", hash_original_method = "D317760A96395810E5039143278FB4E4", hash_generated_method = "D2A9128D95B51A4EAAD8D60FD488B7C6")
    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        byte[] varF2FE2E7531EFB386D123AA3F78BCA993_418392551 = (spiImpl.engineDoFinal());
        addTaint(input[0]);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1178235461 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1178235461;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.920 -0400", hash_original_method = "81378E48B4C25C37826FA808778D1291", hash_generated_method = "77C57E72DC7D91B702D238A17B41BD51")
    public final void reset() {
        spiImpl.engineReset();
        // ---------- Original Method ----------
        //spiImpl.engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.935 -0400", hash_original_method = "D491B3C29A973D07513DEBD79BD84B18", hash_generated_method = "F7B45DEDC9E04207178862DE4910AD9D")
    @Override
    public final Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1511360451 = null; //Variable for return #1
        MacSpi newSpiImpl;
        newSpiImpl = (MacSpi)spiImpl.clone();
        Mac mac;
        mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
        varB4EAC82CA7396A68D541C85D26508E83_1511360451 = mac;
        varB4EAC82CA7396A68D541C85D26508E83_1511360451.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1511360451;
        // ---------- Original Method ----------
        //MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        //Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        //mac.isInitMac = this.isInitMac;
        //return mac;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:59.935 -0400", hash_original_field = "85CE784A77CAA5294BF3FA70EE513A6D", hash_generated_field = "B22704FF4F749E9A78C208C223431525")

    private static Engine ENGINE = new Engine("Mac");
}

