package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.293 -0400", hash_original_field = "60CC4A7350BD40026A718609258D4E10", hash_generated_field = "46DC2FCCD8C543ECEF82F3A223B0B31A")

    private Mac hMac = new HMac(new SHA1Digest());
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.294 -0400", hash_original_method = "B69BB14B43B673ED175B53A442E5BA52", hash_generated_method = "8185A6FBD8116F10F37B5ADDD415EEE5")
    public  PKCS5S2ParametersGenerator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.296 -0400", hash_original_method = "5838C1952069FB825926D87DA007F2C4", hash_generated_method = "B2DA8DD6B97D55CECD2AA0CFA5CD7EF6")
    private void F(
        byte[]  P,
        byte[]  S,
        int     c,
        byte[]  iBuf,
        byte[]  out,
        int     outOff) {
        addTaint(outOff);
        addTaint(out[0]);
        addTaint(iBuf[0]);
        addTaint(c);
        addTaint(S[0]);
        addTaint(P[0]);
        byte[] state = new byte[hMac.getMacSize()];
        CipherParameters param = new KeyParameter(P);
        hMac.init(param);
    if(S != null)        
        {
            hMac.update(S, 0, S.length);
        } //End block
        hMac.update(iBuf, 0, iBuf.length);
        hMac.doFinal(state, 0);
        System.arraycopy(state, 0, out, outOff, state.length);
    if(c == 0)        
        {
            IllegalArgumentException var1150C80F28A9EBB77BA6F63784E89D3E_983767506 = new IllegalArgumentException("iteration count must be at least 1.");
            var1150C80F28A9EBB77BA6F63784E89D3E_983767506.addTaint(taint);
            throw var1150C80F28A9EBB77BA6F63784E89D3E_983767506;
        } //End block
for(int count = 1;count < c;count++)
        {
            hMac.init(param);
            hMac.update(state, 0, state.length);
            hMac.doFinal(state, 0);
for(int j = 0;j != state.length;j++)
            {
                out[outOff + j] ^= state[j];
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.297 -0400", hash_original_method = "D84C49C513A1760CAD87960E0D89CE0E", hash_generated_method = "E2A65E3E9FB0C770A72FEFD274A338E4")
    private void intToOctet(
        byte[]  buf,
        int     i) {
        addTaint(i);
        addTaint(buf[0]);
        buf[0] = (byte)(i >>> 24);
        buf[1] = (byte)(i >>> 16);
        buf[2] = (byte)(i >>> 8);
        buf[3] = (byte)i;
        // ---------- Original Method ----------
        //buf[0] = (byte)(i >>> 24);
        //buf[1] = (byte)(i >>> 16);
        //buf[2] = (byte)(i >>> 8);
        //buf[3] = (byte)i;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.297 -0400", hash_original_method = "9180E4FA1A99F957676BE4B76909E69A", hash_generated_method = "42460A8F95322A0FCCBF2229DA13B943")
    private byte[] generateDerivedKey(
        int dkLen) {
        addTaint(dkLen);
        int hLen = hMac.getMacSize();
        int l = (dkLen + hLen - 1) / hLen;
        byte[] iBuf = new byte[4];
        byte[] out = new byte[l * hLen];
for(int i = 1;i <= l;i++)
        {
            intToOctet(iBuf, i);
            F(password, salt, iterationCount, iBuf, out, (i - 1) * hLen);
        } //End block
        byte[] varC68271A63DDBC431C307BEB7D2918275_1235286239 = (out);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_195582840 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_195582840;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.298 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "2F17416EB9044AD9EA789B34303B1CDD")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        addTaint(keySize);
        keySize = keySize / 8;
        byte[] dKey = generateDerivedKey(keySize);
CipherParameters var6D94FE6EDC09D11F0842CB9C3B01FB06_1451765987 =         new KeyParameter(dKey, 0, keySize);
        var6D94FE6EDC09D11F0842CB9C3B01FB06_1451765987.addTaint(taint);
        return var6D94FE6EDC09D11F0842CB9C3B01FB06_1451765987;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //byte[]  dKey = generateDerivedKey(keySize);
        //return new KeyParameter(dKey, 0, keySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.299 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "2B4B2EE9317806B4C4E4D5F9BBA1C7EF")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        addTaint(ivSize);
        addTaint(keySize);
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey = generateDerivedKey(keySize + ivSize);
CipherParameters var03ABCD9D26B2AC8C264C443A6B20AF1A_690779047 =         new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        var03ABCD9D26B2AC8C264C443A6B20AF1A_690779047.addTaint(taint);
        return var03ABCD9D26B2AC8C264C443A6B20AF1A_690779047;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //ivSize = ivSize / 8;
        //byte[]  dKey = generateDerivedKey(keySize + ivSize);
        //return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.300 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "FB8E6D53645C128EEC41E88708E4E2A4")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        addTaint(keySize);
CipherParameters var9505286CD610A91174FF03781FA2DA54_1793678384 =         generateDerivedParameters(keySize);
        var9505286CD610A91174FF03781FA2DA54_1793678384.addTaint(taint);
        return var9505286CD610A91174FF03781FA2DA54_1793678384;
        // ---------- Original Method ----------
        //return generateDerivedParameters(keySize);
    }

    
}

