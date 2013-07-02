package org.bouncycastle.crypto.macs;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

public class HMac implements Mac {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.067 -0400", hash_original_field = "C10F77963A2B21079156A0E5C5A4BB3C", hash_generated_field = "F5CA32AF1F0185FA6739BEFB868D9AC1")

    private Digest digest;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.067 -0400", hash_original_field = "9255F8D1984F4EA41BF6AA324C3097B4", hash_generated_field = "F92FB817FD31D1DFBC1B86920B98A48F")

    private int digestSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.067 -0400", hash_original_field = "BD69FB59C68C6BC7846F1ED1E90E6664", hash_generated_field = "626390B5DF0BD15522168222272F5EEF")

    private int blockLength;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.067 -0400", hash_original_field = "246C6BB318FCC65906CD761CAAA44D1E", hash_generated_field = "6D892D969D7D84936665B5BDF4E8E0CF")

    private byte[] inputPad;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.067 -0400", hash_original_field = "477C684E7A079D19275A8F4492779756", hash_generated_field = "7F3F56B21FEDB8B51DB60B7746F1D214")

    private byte[] outputPad;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.068 -0400", hash_original_method = "C60799DEC8C5FCA2E5B3602865045199", hash_generated_method = "9C926F4439ACF642136557790644812D")
    public  HMac(
        Digest digest) {
        this(digest, getByteLength(digest));
        addTaint(digest.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.068 -0400", hash_original_method = "2F24A8925EE1F6A5F74219B54F49BAF8", hash_generated_method = "BE12F9EADFC7A313DFF86BD76AF11427")
    private  HMac(
        Digest digest,
        int    byteLength) {
        this.digest = digest;
        digestSize = digest.getDigestSize();
        this.blockLength = byteLength;
        inputPad = new byte[blockLength];
        outputPad = new byte[blockLength];
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.069 -0400", hash_original_method = "6A332A653F94B07A686BBEFB849C6DAB", hash_generated_method = "D37406097009D196D46517C9077547AE")
    public String getAlgorithmName() {
        String varB4EAC82CA7396A68D541C85D26508E83_479248535 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_479248535 = digest.getAlgorithmName() + "/HMAC";
        varB4EAC82CA7396A68D541C85D26508E83_479248535.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_479248535;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.069 -0400", hash_original_method = "DF57895E7914F211606EA32A352DF2A7", hash_generated_method = "8D5BD6E3141E6FE36B8B03DC6508F387")
    public Digest getUnderlyingDigest() {
        Digest varB4EAC82CA7396A68D541C85D26508E83_787982866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_787982866 = digest;
        varB4EAC82CA7396A68D541C85D26508E83_787982866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_787982866;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.070 -0400", hash_original_method = "3101A36249D850D878FF580C09B22824", hash_generated_method = "ED9AC5A473714F91804729FFB52F6303")
    public void init(
        CipherParameters params) {
        digest.reset();
        byte[] key = ((KeyParameter)params).getKey();
        {
            digest.update(key, 0, key.length);
            digest.doFinal(inputPad, 0);
            {
                int i = digestSize;
                {
                    inputPad[i] = 0;
                } 
            } 
        } 
        {
            System.arraycopy(key, 0, inputPad, 0, key.length);
            {
                int i = key.length;
                {
                    inputPad[i] = 0;
                } 
            } 
        } 
        outputPad = new byte[inputPad.length];
        System.arraycopy(inputPad, 0, outputPad, 0, inputPad.length);
        {
            int i = 0;
            {
                inputPad[i] ^= IPAD;
            } 
        } 
        {
            int i = 0;
            {
                outputPad[i] ^= OPAD;
            } 
        } 
        digest.update(inputPad, 0, inputPad.length);
        addTaint(params.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.071 -0400", hash_original_method = "26B5BCE6AD930971148E6F9157D6A115", hash_generated_method = "613A62265959500E7AC2B255634057C7")
    public int getMacSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801007043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_801007043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.071 -0400", hash_original_method = "C3086ADC6CE1A5F257F3E90CDD54BB5C", hash_generated_method = "0BCD34B96EADD4905C9691CC99546487")
    public void update(
        byte in) {
        digest.update(in);
        addTaint(in);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.072 -0400", hash_original_method = "AD060FC4829937C54A58DD468A8ECBD5", hash_generated_method = "46DE5869A6141EEAED720A9EEF8DD477")
    public void update(
        byte[] in,
        int inOff,
        int len) {
        digest.update(in, inOff, len);
        addTaint(in[0]);
        addTaint(inOff);
        addTaint(len);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.073 -0400", hash_original_method = "E110C7DBF05C7A4DE1DAAF3289785A06", hash_generated_method = "153569908AED954A11179EDC0BB9AA6F")
    public int doFinal(
        byte[] out,
        int outOff) {
        byte[] tmp = new byte[digestSize];
        digest.doFinal(tmp, 0);
        digest.update(outputPad, 0, outputPad.length);
        digest.update(tmp, 0, tmp.length);
        int len = digest.doFinal(out, outOff);
        reset();
        addTaint(out[0]);
        addTaint(outOff);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265852931 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1265852931;
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.076 -0400", hash_original_method = "3989731AACDA6B2FAA3C843D8746ADA9", hash_generated_method = "22472C0C76108A5E431142EFA5C05491")
    public void reset() {
        digest.reset();
        digest.update(inputPad, 0, inputPad.length);
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.076 -0400", hash_original_field = "C96C1EB1408887454699B3F47E13349B", hash_generated_field = "5D6A67406DA3DD8011585BBA549D28E5")

    private final static byte IPAD = (byte)0x36;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.076 -0400", hash_original_field = "ECCE7A0C7F50384E7E73C9807794AA83", hash_generated_field = "A1D9A0FD64E87A713B5C09EE12CF27F2")

    private final static byte OPAD = (byte)0x5C;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.076 -0400", hash_original_field = "AF7C35E64C77C1344CE71E1977CA0011", hash_generated_field = "8154B75C53A1CCD4098DE06BC1B2DEA2")

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

