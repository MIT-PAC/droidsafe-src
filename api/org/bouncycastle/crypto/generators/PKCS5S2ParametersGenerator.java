package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.838 -0500", hash_original_field = "321616263CBCD002E2637343ACC6E0EB", hash_generated_field = "46DC2FCCD8C543ECEF82F3A223B0B31A")

    private Mac    hMac = new HMac(new SHA1Digest());

    /**
     * construct a PKCS5 Scheme 2 Parameters generator.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.841 -0500", hash_original_method = "B69BB14B43B673ED175B53A442E5BA52", hash_generated_method = "593916AB818176A1FF3DCE8385A308C4")
    
public PKCS5S2ParametersGenerator()
    {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.844 -0500", hash_original_method = "5838C1952069FB825926D87DA007F2C4", hash_generated_method = "CDC3842003E6730159838578BB5FF055")
    
private void F(
        byte[]  P,
        byte[]  S,
        int     c,
        byte[]  iBuf,
        byte[]  out,
        int     outOff)
    {
        byte[]              state = new byte[hMac.getMacSize()];
        CipherParameters    param = new KeyParameter(P);

        hMac.init(param);

        if (S != null)
        {
            hMac.update(S, 0, S.length);
        }

        hMac.update(iBuf, 0, iBuf.length);

        hMac.doFinal(state, 0);

        System.arraycopy(state, 0, out, outOff, state.length);

        if (c == 0)
        {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        
        for (int count = 1; count < c; count++)
        {
            hMac.init(param);
            hMac.update(state, 0, state.length);
            hMac.doFinal(state, 0);

            for (int j = 0; j != state.length; j++)
            {
                out[outOff + j] ^= state[j];
            }
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.847 -0500", hash_original_method = "D84C49C513A1760CAD87960E0D89CE0E", hash_generated_method = "7E5D24344EA07CFF7648793E6BD280A6")
    
private void intToOctet(
        byte[]  buf,
        int     i)
    {
        buf[0] = (byte)(i >>> 24);
        buf[1] = (byte)(i >>> 16);
        buf[2] = (byte)(i >>> 8);
        buf[3] = (byte)i;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.849 -0500", hash_original_method = "9180E4FA1A99F957676BE4B76909E69A", hash_generated_method = "761DF403D56191BEC207394E69089CF5")
    
private byte[] generateDerivedKey(
        int dkLen)
    {
        int     hLen = hMac.getMacSize();
        int     l = (dkLen + hLen - 1) / hLen;
        byte[]  iBuf = new byte[4];
        byte[]  out = new byte[l * hLen];

        for (int i = 1; i <= l; i++)
        {
            intToOctet(iBuf, i);

            F(password, salt, iterationCount, iBuf, out, (i - 1) * hLen);
        }

        return out;
    }

    /**
     * Generate a key parameter derived from the password, salt, and iteration
     * count we are currently initialised with.
     *
     * @param keySize the size of the key we want (in bits)
     * @return a KeyParameter object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.851 -0500", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "FE92A991493A370A91578410E0107D1F")
    
public CipherParameters generateDerivedParameters(
        int keySize)
    {
        keySize = keySize / 8;

        byte[]  dKey = generateDerivedKey(keySize);

        return new KeyParameter(dKey, 0, keySize);
    }

    /**
     * Generate a key with initialisation vector parameter derived from
     * the password, salt, and iteration count we are currently initialised
     * with.
     *
     * @param keySize the size of the key we want (in bits)
     * @param ivSize the size of the iv we want (in bits)
     * @return a ParametersWithIV object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.854 -0500", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "C303AAB7EA511965A225079A754DF7E1")
    
public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize)
    {
        keySize = keySize / 8;
        ivSize = ivSize / 8;

        byte[]  dKey = generateDerivedKey(keySize + ivSize);

        return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    /**
     * Generate a key parameter for use with a MAC derived from the password,
     * salt, and iteration count we are currently initialised with.
     *
     * @param keySize the size of the key we want (in bits)
     * @return a KeyParameter object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:29.856 -0500", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "394172050377204AF59B47DCF537242A")
    
public CipherParameters generateDerivedMacParameters(
        int keySize)
    {
        return generateDerivedParameters(keySize);
    }
    
}

