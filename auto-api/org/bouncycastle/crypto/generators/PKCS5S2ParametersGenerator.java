package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.576 -0400", hash_original_field = "60CC4A7350BD40026A718609258D4E10", hash_generated_field = "46DC2FCCD8C543ECEF82F3A223B0B31A")

    private Mac hMac = new HMac(new SHA1Digest());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.576 -0400", hash_original_method = "B69BB14B43B673ED175B53A442E5BA52", hash_generated_method = "8185A6FBD8116F10F37B5ADDD415EEE5")
    public  PKCS5S2ParametersGenerator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.578 -0400", hash_original_method = "5838C1952069FB825926D87DA007F2C4", hash_generated_method = "489B277666244238C3EBBA992284D5E2")
    private void F(
        byte[]  P,
        byte[]  S,
        int     c,
        byte[]  iBuf,
        byte[]  out,
        int     outOff) {
        byte[] state;
        state = new byte[hMac.getMacSize()];
        CipherParameters param;
        param = new KeyParameter(P);
        hMac.init(param);
        {
            hMac.update(S, 0, S.length);
        } //End block
        hMac.update(iBuf, 0, iBuf.length);
        hMac.doFinal(state, 0);
        System.arraycopy(state, 0, out, outOff, state.length);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("iteration count must be at least 1.");
        } //End block
        {
            int count;
            count = 1;
            {
                hMac.init(param);
                hMac.update(state, 0, state.length);
                hMac.doFinal(state, 0);
                {
                    int j;
                    j = 0;
                    {
                        out[outOff + j] ^= state[j];
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(P[0]);
        addTaint(S[0]);
        addTaint(c);
        addTaint(iBuf[0]);
        addTaint(out[0]);
        addTaint(outOff);
        // ---------- Original Method ----------
        //byte[]              state = new byte[hMac.getMacSize()];
        //CipherParameters    param = new KeyParameter(P);
        //hMac.init(param);
        //if (S != null)
        //{
            //hMac.update(S, 0, S.length);
        //}
        //hMac.update(iBuf, 0, iBuf.length);
        //hMac.doFinal(state, 0);
        //System.arraycopy(state, 0, out, outOff, state.length);
        //if (c == 0)
        //{
            //throw new IllegalArgumentException("iteration count must be at least 1.");
        //}
        //for (int count = 1; count < c; count++)
        //{
            //hMac.init(param);
            //hMac.update(state, 0, state.length);
            //hMac.doFinal(state, 0);
            //for (int j = 0; j != state.length; j++)
            //{
                //out[outOff + j] ^= state[j];
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.579 -0400", hash_original_method = "D84C49C513A1760CAD87960E0D89CE0E", hash_generated_method = "4F67EBA3834A87687C5D876D9EF848D7")
    private void intToOctet(
        byte[]  buf,
        int     i) {
        buf[0] = (byte)(i >>> 24);
        buf[1] = (byte)(i >>> 16);
        buf[2] = (byte)(i >>> 8);
        buf[3] = (byte)i;
        addTaint(buf[0]);
        addTaint(i);
        // ---------- Original Method ----------
        //buf[0] = (byte)(i >>> 24);
        //buf[1] = (byte)(i >>> 16);
        //buf[2] = (byte)(i >>> 8);
        //buf[3] = (byte)i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.587 -0400", hash_original_method = "9180E4FA1A99F957676BE4B76909E69A", hash_generated_method = "E84E81D3FBAD49FD82EA49A7F0B73B98")
    private byte[] generateDerivedKey(
        int dkLen) {
        int hLen;
        hLen = hMac.getMacSize();
        int l;
        l = (dkLen + hLen - 1) / hLen;
        byte[] iBuf;
        iBuf = new byte[4];
        byte[] out;
        out = new byte[l * hLen];
        {
            int i;
            i = 1;
            {
                intToOctet(iBuf, i);
                F(password, salt, iterationCount, iBuf, out, (i - 1) * hLen);
            } //End block
        } //End collapsed parenthetic
        addTaint(dkLen);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1037608850 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1037608850;
        // ---------- Original Method ----------
        //int     hLen = hMac.getMacSize();
        //int     l = (dkLen + hLen - 1) / hLen;
        //byte[]  iBuf = new byte[4];
        //byte[]  out = new byte[l * hLen];
        //for (int i = 1; i <= l; i++)
        //{
            //intToOctet(iBuf, i);
            //F(password, salt, iterationCount, iBuf, out, (i - 1) * hLen);
        //}
        //return out;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.595 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "E3A881B6D86506880C6B96BCE4E2E4AE")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_1288151974 = null; //Variable for return #1
        keySize = keySize / 8;
        byte[] dKey;
        dKey = generateDerivedKey(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_1288151974 = new KeyParameter(dKey, 0, keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_1288151974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1288151974;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //byte[]  dKey = generateDerivedKey(keySize);
        //return new KeyParameter(dKey, 0, keySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.596 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "19D04E4A1D894F7639749FE47A971A3F")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_29429527 = null; //Variable for return #1
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey;
        dKey = generateDerivedKey(keySize + ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_29429527 = new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        addTaint(keySize);
        addTaint(ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_29429527.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_29429527;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //ivSize = ivSize / 8;
        //byte[]  dKey = generateDerivedKey(keySize + ivSize);
        //return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.597 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "1155B841DE218E20AF1FAE983D28287C")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_1979983096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1979983096 = generateDerivedParameters(keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_1979983096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1979983096;
        // ---------- Original Method ----------
        //return generateDerivedParameters(keySize);
    }

    
}

