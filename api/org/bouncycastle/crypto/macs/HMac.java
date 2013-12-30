package org.bouncycastle.crypto.macs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Hashtable;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;






public class HMac implements Mac {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.901 -0500", hash_original_method = "22CE895445A67645E1245C9F620EC3AF", hash_generated_method = "7474B90794D20F4D5961FB89B3FD4064")
    
private static int getByteLength(
        Digest digest)
    {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.881 -0500", hash_original_field = "AF2B88B3F884CE389C377EDDF0562888", hash_generated_field = "5D6A67406DA3DD8011585BBA549D28E5")

    private final static byte IPAD = (byte)0x36;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.884 -0500", hash_original_field = "3C02F9C79FABFCEF0D648192EB5E3FFB", hash_generated_field = "A1D9A0FD64E87A713B5C09EE12CF27F2")

    private final static byte OPAD = (byte)0x5C;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.897 -0500", hash_original_field = "AE6DBBD45137DB46363467A77EC3D235", hash_generated_field = "8154B75C53A1CCD4098DE06BC1B2DEA2")


    private static Hashtable blockLengths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.886 -0500", hash_original_field = "A27690AA68DDFB7D002AAB3E5D9E96C9", hash_generated_field = "F5CA32AF1F0185FA6739BEFB868D9AC1")


    private Digest digest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.888 -0500", hash_original_field = "64A3555DDEDEFC54BE3BEBE705E5221D", hash_generated_field = "F92FB817FD31D1DFBC1B86920B98A48F")

    private int digestSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.890 -0500", hash_original_field = "39E2ADD518C5DD382C4C526D92F32F91", hash_generated_field = "626390B5DF0BD15522168222272F5EEF")

    private int blockLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.893 -0500", hash_original_field = "F98A792A11536C9F74F471773342692F", hash_generated_field = "6D892D969D7D84936665B5BDF4E8E0CF")

    
    private byte[] inputPad;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.895 -0500", hash_original_field = "A5AA4968E96F16D80E074A7C9E7C4D5F", hash_generated_field = "7F3F56B21FEDB8B51DB60B7746F1D214")

    private byte[] outputPad;
    
    /**
     * Base constructor for one of the standard digest algorithms that the 
     * byteLength of the algorithm is know for.
     * 
     * @param digest the digest.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.904 -0500", hash_original_method = "C60799DEC8C5FCA2E5B3602865045199", hash_generated_method = "BBB9C0F60A90B41BC1EE3DE4E9722CA4")
    
public HMac(
        Digest digest)
    {
        this(digest, getByteLength(digest));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.906 -0500", hash_original_method = "2F24A8925EE1F6A5F74219B54F49BAF8", hash_generated_method = "38E6E69C320E1806A041CA3E402181DF")
    
private HMac(
        Digest digest,
        int    byteLength)
    {
        this.digest = digest;
        digestSize = digest.getDigestSize();

        this.blockLength = byteLength;

        inputPad = new byte[blockLength];
        outputPad = new byte[blockLength];
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.909 -0500", hash_original_method = "6A332A653F94B07A686BBEFB849C6DAB", hash_generated_method = "6474BCED6E437DC6FAE42D92E9BA6B6C")
    
public String getAlgorithmName()
    {
        return digest.getAlgorithmName() + "/HMAC";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.911 -0500", hash_original_method = "DF57895E7914F211606EA32A352DF2A7", hash_generated_method = "F9F026C46606A2FE15983FEC780AEEE7")
    
public Digest getUnderlyingDigest()
    {
        return digest;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.914 -0500", hash_original_method = "3101A36249D850D878FF580C09B22824", hash_generated_method = "E152A9DEF02A74992F178EE59BF87D00")
    
public void init(
        CipherParameters params)
    {
        digest.reset();

        byte[] key = ((KeyParameter)params).getKey();

        if (key.length > blockLength)
        {
            digest.update(key, 0, key.length);
            digest.doFinal(inputPad, 0);
            for (int i = digestSize; i < inputPad.length; i++)
            {
                inputPad[i] = 0;
            }
        }
        else
        {
            System.arraycopy(key, 0, inputPad, 0, key.length);
            for (int i = key.length; i < inputPad.length; i++)
            {
                inputPad[i] = 0;
            }
        }

        outputPad = new byte[inputPad.length];
        System.arraycopy(inputPad, 0, outputPad, 0, inputPad.length);

        for (int i = 0; i < inputPad.length; i++)
        {
            inputPad[i] ^= IPAD;
        }

        for (int i = 0; i < outputPad.length; i++)
        {
            outputPad[i] ^= OPAD;
        }

        digest.update(inputPad, 0, inputPad.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.916 -0500", hash_original_method = "26B5BCE6AD930971148E6F9157D6A115", hash_generated_method = "050572D72DC4BEEAAA242ED0099B8983")
    
public int getMacSize()
    {
        return digestSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.919 -0500", hash_original_method = "C3086ADC6CE1A5F257F3E90CDD54BB5C", hash_generated_method = "11D909DE3B983B71CB3D2F2348577A64")
    
public void update(
        byte in)
    {
        digest.update(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.921 -0500", hash_original_method = "AD060FC4829937C54A58DD468A8ECBD5", hash_generated_method = "4DA54952752259B66AC231DA6E774D07")
    
public void update(
        byte[] in,
        int inOff,
        int len)
    {
        digest.update(in, inOff, len);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.923 -0500", hash_original_method = "E110C7DBF05C7A4DE1DAAF3289785A06", hash_generated_method = "5B50A7D669A6E75A44A2241F990E6C86")
    
public int doFinal(
        byte[] out,
        int outOff)
    {
        byte[] tmp = new byte[digestSize];
        digest.doFinal(tmp, 0);

        digest.update(outputPad, 0, outputPad.length);
        digest.update(tmp, 0, tmp.length);

        int     len = digest.doFinal(out, outOff);

        reset();

        return len;
    }

    /**
     * Reset the mac generator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:30.926 -0500", hash_original_method = "3989731AACDA6B2FAA3C843D8746ADA9", hash_generated_method = "3B9EE989A8D2280E604B3D6296E45F2E")
    
public void reset()
    {
        /*
         * reset the underlying digest.
         */
        digest.reset();

        /*
         * reinitialize the digest.
         */
        digest.update(inputPad, 0, inputPad.length);
    }
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

