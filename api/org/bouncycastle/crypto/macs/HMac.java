package org.bouncycastle.crypto.macs;

// Droidsafe Imports
import java.util.Hashtable;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class HMac implements Mac {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.036 -0400", hash_original_field = "C10F77963A2B21079156A0E5C5A4BB3C", hash_generated_field = "F5CA32AF1F0185FA6739BEFB868D9AC1")

    private Digest digest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.037 -0400", hash_original_field = "9255F8D1984F4EA41BF6AA324C3097B4", hash_generated_field = "F92FB817FD31D1DFBC1B86920B98A48F")

    private int digestSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.037 -0400", hash_original_field = "BD69FB59C68C6BC7846F1ED1E90E6664", hash_generated_field = "626390B5DF0BD15522168222272F5EEF")

    private int blockLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.037 -0400", hash_original_field = "246C6BB318FCC65906CD761CAAA44D1E", hash_generated_field = "6D892D969D7D84936665B5BDF4E8E0CF")

    private byte[] inputPad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.037 -0400", hash_original_field = "477C684E7A079D19275A8F4492779756", hash_generated_field = "7F3F56B21FEDB8B51DB60B7746F1D214")

    private byte[] outputPad;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.037 -0400", hash_original_method = "C60799DEC8C5FCA2E5B3602865045199", hash_generated_method = "9C926F4439ACF642136557790644812D")
    public  HMac(
        Digest digest) {
        this(digest, getByteLength(digest));
        addTaint(digest.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.038 -0400", hash_original_method = "2F24A8925EE1F6A5F74219B54F49BAF8", hash_generated_method = "BE12F9EADFC7A313DFF86BD76AF11427")
    private  HMac(
        Digest digest,
        int    byteLength) {
        this.digest = digest;
        digestSize = digest.getDigestSize();
        this.blockLength = byteLength;
        inputPad = new byte[blockLength];
        outputPad = new byte[blockLength];
        // ---------- Original Method ----------
        //this.digest = digest;
        //digestSize = digest.getDigestSize();
        //this.blockLength = byteLength;
        //inputPad = new byte[blockLength];
        //outputPad = new byte[blockLength];
    }

    
    private static int getByteLength(
        Digest digest) {
        if (digest instanceof ExtendedDigest)
        {
            return ((ExtendedDigest)digest).getByteLength();
        }
        Integer  b = (Integer)blockLengths.get(digest.getAlgorithmName());
        if (b == null)
        {       
            throw new IllegalArgumentException("unknown digest passed: " + digest.getAlgorithmName());
        }
        return b.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.039 -0400", hash_original_method = "6A332A653F94B07A686BBEFB849C6DAB", hash_generated_method = "003481C2AD5AB25D28E7877E8BD5AE08")
    public String getAlgorithmName() {
String var3B1F39D8F465DFD1B0D3818B237F2D32_1150631987 =         digest.getAlgorithmName() + "/HMAC";
        var3B1F39D8F465DFD1B0D3818B237F2D32_1150631987.addTaint(taint);
        return var3B1F39D8F465DFD1B0D3818B237F2D32_1150631987;
        // ---------- Original Method ----------
        //return digest.getAlgorithmName() + "/HMAC";
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.039 -0400", hash_original_method = "DF57895E7914F211606EA32A352DF2A7", hash_generated_method = "C0A688C11876A1B0AA136EE14633486D")
    public Digest getUnderlyingDigest() {
Digest var3198260B9187CD88530E727D50A62D10_2103145591 =         digest;
        var3198260B9187CD88530E727D50A62D10_2103145591.addTaint(taint);
        return var3198260B9187CD88530E727D50A62D10_2103145591;
        // ---------- Original Method ----------
        //return digest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.041 -0400", hash_original_method = "3101A36249D850D878FF580C09B22824", hash_generated_method = "7A810CABEBB66607937D0A3EA166CACA")
    public void init(
        CipherParameters params) {
        addTaint(params.getTaint());
        digest.reset();
        byte[] key = ((KeyParameter)params).getKey();
        if(key.length > blockLength)        
        {
            digest.update(key, 0, key.length);
            digest.doFinal(inputPad, 0);
for(int i = digestSize;i < inputPad.length;i++)
            {
                inputPad[i] = 0;
            } //End block
        } //End block
        else
        {
            System.arraycopy(key, 0, inputPad, 0, key.length);
for(int i = key.length;i < inputPad.length;i++)
            {
                inputPad[i] = 0;
            } //End block
        } //End block
        outputPad = new byte[inputPad.length];
        System.arraycopy(inputPad, 0, outputPad, 0, inputPad.length);
for(int i = 0;i < inputPad.length;i++)
        {
            inputPad[i] ^= IPAD;
        } //End block
for(int i = 0;i < outputPad.length;i++)
        {
            outputPad[i] ^= OPAD;
        } //End block
        digest.update(inputPad, 0, inputPad.length);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.042 -0400", hash_original_method = "26B5BCE6AD930971148E6F9157D6A115", hash_generated_method = "0975E5C3910D6803E35D5C1A3C03D500")
    public int getMacSize() {
        int var9255F8D1984F4EA41BF6AA324C3097B4_1562421330 = (digestSize);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428918663 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_428918663;
        // ---------- Original Method ----------
        //return digestSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.042 -0400", hash_original_method = "C3086ADC6CE1A5F257F3E90CDD54BB5C", hash_generated_method = "42F617E365C3BBEAE8510D15E653E8C6")
    public void update(
        byte in) {
        addTaint(in);
        digest.update(in);
        // ---------- Original Method ----------
        //digest.update(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.042 -0400", hash_original_method = "AD060FC4829937C54A58DD468A8ECBD5", hash_generated_method = "FD2081F8A76FC8FF3ADF1E12E0CD877B")
    public void update(
        byte[] in,
        int inOff,
        int len) {
        addTaint(len);
        addTaint(inOff);
        addTaint(in[0]);
        digest.update(in, inOff, len);
        // ---------- Original Method ----------
        //digest.update(in, inOff, len);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.043 -0400", hash_original_method = "E110C7DBF05C7A4DE1DAAF3289785A06", hash_generated_method = "C06F2F05E967CB9E2F81BA807A623987")
    public int doFinal(
        byte[] out,
        int outOff) {
        addTaint(outOff);
        addTaint(out[0]);
        byte[] tmp = new byte[digestSize];
        digest.doFinal(tmp, 0);
        digest.update(outputPad, 0, outputPad.length);
        digest.update(tmp, 0, tmp.length);
        int len = digest.doFinal(out, outOff);
        reset();
        int varF5A8E923F8CD24B56B3BAB32358CC58A_1083088542 = (len);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155520321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_155520321;
        // ---------- Original Method ----------
        //byte[] tmp = new byte[digestSize];
        //digest.doFinal(tmp, 0);
        //digest.update(outputPad, 0, outputPad.length);
        //digest.update(tmp, 0, tmp.length);
        //int     len = digest.doFinal(out, outOff);
        //reset();
        //return len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.043 -0400", hash_original_method = "3989731AACDA6B2FAA3C843D8746ADA9", hash_generated_method = "22472C0C76108A5E431142EFA5C05491")
    public void reset() {
        digest.reset();
        digest.update(inputPad, 0, inputPad.length);
        // ---------- Original Method ----------
        //digest.reset();
        //digest.update(inputPad, 0, inputPad.length);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.043 -0400", hash_original_field = "C96C1EB1408887454699B3F47E13349B", hash_generated_field = "5D6A67406DA3DD8011585BBA549D28E5")

    private final static byte IPAD = (byte)0x36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.044 -0400", hash_original_field = "ECCE7A0C7F50384E7E73C9807794AA83", hash_generated_field = "A1D9A0FD64E87A713B5C09EE12CF27F2")

    private final static byte OPAD = (byte)0x5C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.044 -0400", hash_original_field = "AF7C35E64C77C1344CE71E1977CA0011", hash_generated_field = "8154B75C53A1CCD4098DE06BC1B2DEA2")

    private static Hashtable blockLengths;
    static {
        blockLengths = new Hashtable();
        blockLengths.put("GOST3411", Integer.valueOf(32));
        blockLengths.put("MD2", Integer.valueOf(16));
        blockLengths.put("MD4", Integer.valueOf(64));
        blockLengths.put("MD5", Integer.valueOf(64));
        blockLengths.put("RIPEMD128", Integer.valueOf(64));
        blockLengths.put("RIPEMD160", Integer.valueOf(64));
        blockLengths.put("SHA-1", Integer.valueOf(64));
        blockLengths.put("SHA-224", Integer.valueOf(64));
        blockLengths.put("SHA-256", Integer.valueOf(64));
        blockLengths.put("SHA-384", Integer.valueOf(128));
        blockLengths.put("SHA-512", Integer.valueOf(128));
        blockLengths.put("Tiger", Integer.valueOf(64));
        blockLengths.put("Whirlpool", Integer.valueOf(64));
    }
    
}

