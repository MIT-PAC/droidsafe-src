package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.282 -0400", hash_original_field = "16434969A53FBE1B6177CDA9EA0B2CD3", hash_generated_field = "91AB1A516766E39A2EE21B008511F72A")

    private Digest digest = new MD5Digest();
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.282 -0400", hash_original_method = "469CB0205646D06181D1559BA7D61CF9", hash_generated_method = "1CCF825CE7F4725EE21D0B68C89CAE4D")
    public  OpenSSLPBEParametersGenerator() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.282 -0400", hash_original_method = "2CA180C614EC01706903EAD38F06E97B", hash_generated_method = "F7EBA9D758CB6C26713FE78F382C4CD6")
    public void init(
       byte[] password,
       byte[] salt) {
        addTaint(salt[0]);
        addTaint(password[0]);
        super.init(password, salt, 1);
        // ---------- Original Method ----------
        //super.init(password, salt, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.283 -0400", hash_original_method = "4E618B69222EA698951005FED9FF9FA3", hash_generated_method = "42B39B8765319086E17BF056B87A7633")
    private byte[] generateDerivedKey(
        int bytesNeeded) {
        addTaint(bytesNeeded);
        byte[] buf = new byte[digest.getDigestSize()];
        byte[] key = new byte[bytesNeeded];
        int offset = 0;
for(;;)
        {
            digest.update(password, 0, password.length);
            digest.update(salt, 0, salt.length);
            digest.doFinal(buf, 0);
            int len = (bytesNeeded > buf.length) ? buf.length : bytesNeeded;
            System.arraycopy(buf, 0, key, offset, len);
            offset += len;
            bytesNeeded -= len;
    if(bytesNeeded == 0)            
            {
                break;
            } //End block
            digest.reset();
            digest.update(buf, 0, buf.length);
        } //End block
        byte[] var3C6E0B8A9C15224A8228B9A98CA1531D_1136420234 = (key);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_587738623 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_587738623;
        // ---------- Original Method ----------
        //byte[]  buf = new byte[digest.getDigestSize()];
        //byte[]  key = new byte[bytesNeeded];
        //int     offset = 0;
        //for (;;)
        //{
            //digest.update(password, 0, password.length);
            //digest.update(salt, 0, salt.length);
            //digest.doFinal(buf, 0);
            //int len = (bytesNeeded > buf.length) ? buf.length : bytesNeeded;
            //System.arraycopy(buf, 0, key, offset, len);
            //offset += len;
            //bytesNeeded -= len;
            //if (bytesNeeded == 0)
            //{
                //break;
            //}
            //digest.reset();
            //digest.update(buf, 0, buf.length);
        //}
        //return key;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.283 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "B59FE7363A1D715A01FFF922FB445A00")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        addTaint(keySize);
        keySize = keySize / 8;
        byte[] dKey = generateDerivedKey(keySize);
CipherParameters var6D94FE6EDC09D11F0842CB9C3B01FB06_192297652 =         new KeyParameter(dKey, 0, keySize);
        var6D94FE6EDC09D11F0842CB9C3B01FB06_192297652.addTaint(taint);
        return var6D94FE6EDC09D11F0842CB9C3B01FB06_192297652;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //byte[]  dKey = generateDerivedKey(keySize);
        //return new KeyParameter(dKey, 0, keySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.283 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "40CF7ACC76F3A59E54BC537B0E53F6B6")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        addTaint(ivSize);
        addTaint(keySize);
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey = generateDerivedKey(keySize + ivSize);
CipherParameters var03ABCD9D26B2AC8C264C443A6B20AF1A_2100677700 =         new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        var03ABCD9D26B2AC8C264C443A6B20AF1A_2100677700.addTaint(taint);
        return var03ABCD9D26B2AC8C264C443A6B20AF1A_2100677700;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //ivSize = ivSize / 8;
        //byte[]  dKey = generateDerivedKey(keySize + ivSize);
        //return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:41.283 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "AB0679EA83982D2DD2620873005E1BDF")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        addTaint(keySize);
CipherParameters var9505286CD610A91174FF03781FA2DA54_661367193 =         generateDerivedParameters(keySize);
        var9505286CD610A91174FF03781FA2DA54_661367193.addTaint(taint);
        return var9505286CD610A91174FF03781FA2DA54_661367193;
        // ---------- Original Method ----------
        //return generateDerivedParameters(keySize);
    }

    
}

