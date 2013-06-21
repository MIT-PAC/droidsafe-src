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
    private Provider provider;
    private MacSpi spiImpl;
    private String algorithm;
    private boolean isInitMac;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.981 -0400", hash_original_method = "41257A854336509F555FDEC12089036E", hash_generated_method = "9E9D881EC364CEE20E27A7640FD4FEBF")
    @DSModeled(DSC.SAFE)
    protected Mac(MacSpi macSpi, Provider provider, String algorithm) {
        dsTaint.addTaint(macSpi.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(algorithm);
        this.isInitMac = false;
        // ---------- Original Method ----------
        //this.provider = provider;
        //this.algorithm = algorithm;
        //this.spiImpl = macSpi;
        //this.isInitMac = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.981 -0400", hash_original_method = "545C988DDCCD8AD6AA15877CD458F7D6", hash_generated_method = "D8B68EE02F71705BA62E93B42B805D25")
    @DSModeled(DSC.SAFE)
    public final String getAlgorithm() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return algorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.981 -0400", hash_original_method = "4D6A4C5C7B57C5543A93E2FA43879F89", hash_generated_method = "828895F1878B3605546159F61AC099C2")
    @DSModeled(DSC.SAFE)
    public final Provider getProvider() {
        return (Provider)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.982 -0400", hash_original_method = "02AEE303A4D099BA107FB2CB7C60A1E3", hash_generated_method = "CCB66B9967872E718731603B5AE433FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getMacLength() {
        int varDE0776842F57D1FBC8679CFC79D95000_1877918395 = (spiImpl.engineGetMacLength());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return spiImpl.engineGetMacLength();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.982 -0400", hash_original_method = "9228EAA32885A066BE953E8B5AE4C236", hash_generated_method = "E730449A59D5244EFEA0E968D96BD383")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key, AlgorithmParameterSpec params) throws InvalidKeyException, InvalidAlgorithmParameterException {
        dsTaint.addTaint(params.dsTaint);
        dsTaint.addTaint(key.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidKeyException("key == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.982 -0400", hash_original_method = "874C36BA9BA67506DF1E27339862DC05", hash_generated_method = "844739E3E2BA9950CF5B452B285DB05A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void init(Key key) throws InvalidKeyException {
        dsTaint.addTaint(key.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.982 -0400", hash_original_method = "CE2C32417AC34B9F04F350B6B83BA3FB", hash_generated_method = "E395FD6DF241E0C6C4583C84EF4F5D8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte input) throws IllegalStateException {
        dsTaint.addTaint(input);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        spiImpl.engineUpdate(input);
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //spiImpl.engineUpdate(input);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.982 -0400", hash_original_method = "715302E1C20F57A2A8D63A54A99663FC", hash_generated_method = "AD50C71EAB57A55DA972DFCA0D28691F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte[] input, int offset, int len) throws IllegalStateException {
        dsTaint.addTaint(input[0]);
        dsTaint.addTaint(len);
        dsTaint.addTaint(offset);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Incorrect arguments");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.983 -0400", hash_original_method = "3D6841DD3321DF543EE186C2C08CA7E2", hash_generated_method = "F40C93CEA06F2915B3FAB1F60E3B8196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(byte[] input) throws IllegalStateException {
        dsTaint.addTaint(input[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.983 -0400", hash_original_method = "A1BB43A6E7623A403344D1C2F2A132EB", hash_generated_method = "086272EAA2B9B797799C8335F37B941F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void update(ByteBuffer input) {
        dsTaint.addTaint(input.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            spiImpl.engineUpdate(input);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("input == null");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.983 -0400", hash_original_method = "09A7E9E8BA2AA06F6A3808F7BB018D3B", hash_generated_method = "9A3FF090731FD8290D74CF429A67452B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] doFinal() throws IllegalStateException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        byte[] varF2FE2E7531EFB386D123AA3F78BCA993_2086453571 = (spiImpl.engineDoFinal());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.983 -0400", hash_original_method = "3A73D46F22DAF7149F49DD945D0B4F9C", hash_generated_method = "49D3618E5FB97364BF0F16B91B796BFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void doFinal(byte[] output, int outOffset) throws ShortBufferException, IllegalStateException {
        dsTaint.addTaint(outOffset);
        dsTaint.addTaint(output[0]);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.984 -0400", hash_original_method = "D317760A96395810E5039143278FB4E4", hash_generated_method = "8401DEB68C07A9135180A31E0445E946")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final byte[] doFinal(byte[] input) throws IllegalStateException {
        dsTaint.addTaint(input[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        } //End block
        {
            spiImpl.engineUpdate(input, 0, input.length);
        } //End block
        byte[] varF2FE2E7531EFB386D123AA3F78BCA993_1226466323 = (spiImpl.engineDoFinal());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (!isInitMac) {
            //throw new IllegalStateException();
        //}
        //if (input != null) {
            //spiImpl.engineUpdate(input, 0, input.length);
        //}
        //return spiImpl.engineDoFinal();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.984 -0400", hash_original_method = "81378E48B4C25C37826FA808778D1291", hash_generated_method = "77C57E72DC7D91B702D238A17B41BD51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void reset() {
        spiImpl.engineReset();
        // ---------- Original Method ----------
        //spiImpl.engineReset();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:35.984 -0400", hash_original_method = "D491B3C29A973D07513DEBD79BD84B18", hash_generated_method = "BFA3E4C6F5517FCE31AFA213B7828BEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public final Object clone() throws CloneNotSupportedException {
        MacSpi newSpiImpl;
        newSpiImpl = (MacSpi)spiImpl.clone();
        Mac mac;
        mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        mac.isInitMac = this.isInitMac;
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MacSpi newSpiImpl = (MacSpi)spiImpl.clone();
        //Mac mac = new Mac(newSpiImpl, this.provider, this.algorithm);
        //mac.isInitMac = this.isInitMac;
        //return mac;
    }

    
    private static final Engine ENGINE = new Engine("Mac");
}

