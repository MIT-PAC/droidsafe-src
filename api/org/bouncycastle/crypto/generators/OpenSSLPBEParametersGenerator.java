package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.annotations.*;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;






public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.982 -0400", hash_original_field = "16434969A53FBE1B6177CDA9EA0B2CD3", hash_generated_field = "91AB1A516766E39A2EE21B008511F72A")

    private Digest digest = new MD5Digest();
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.983 -0400", hash_original_method = "469CB0205646D06181D1559BA7D61CF9", hash_generated_method = "1CCF825CE7F4725EE21D0B68C89CAE4D")
    public  OpenSSLPBEParametersGenerator() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.983 -0400", hash_original_method = "2CA180C614EC01706903EAD38F06E97B", hash_generated_method = "F7EBA9D758CB6C26713FE78F382C4CD6")
    public void init(
       byte[] password,
       byte[] salt) {
        addTaint(salt[0]);
        addTaint(password[0]);
        super.init(password, salt, 1);
        // ---------- Original Method ----------
        //super.init(password, salt, 1);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.984 -0400", hash_original_method = "4E618B69222EA698951005FED9FF9FA3", hash_generated_method = "B2BC24FEDB4EA05F8C9AB68EE9442FB4")
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
        byte[] var3C6E0B8A9C15224A8228B9A98CA1531D_678928574 = (key);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_462440385 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_462440385;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.985 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "D060DDF045331E9429193283257AACDD")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        addTaint(keySize);
        keySize = keySize / 8;
        byte[] dKey = generateDerivedKey(keySize);
CipherParameters var6D94FE6EDC09D11F0842CB9C3B01FB06_833234573 =         new KeyParameter(dKey, 0, keySize);
        var6D94FE6EDC09D11F0842CB9C3B01FB06_833234573.addTaint(taint);
        return var6D94FE6EDC09D11F0842CB9C3B01FB06_833234573;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //byte[]  dKey = generateDerivedKey(keySize);
        //return new KeyParameter(dKey, 0, keySize);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.986 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "A867C8943BD9F78CC6D767E5C3914EB4")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        addTaint(ivSize);
        addTaint(keySize);
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey = generateDerivedKey(keySize + ivSize);
CipherParameters var03ABCD9D26B2AC8C264C443A6B20AF1A_800914908 =         new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        var03ABCD9D26B2AC8C264C443A6B20AF1A_800914908.addTaint(taint);
        return var03ABCD9D26B2AC8C264C443A6B20AF1A_800914908;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //ivSize = ivSize / 8;
        //byte[]  dKey = generateDerivedKey(keySize + ivSize);
        //return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:40.987 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "DADB217550A5DD31BFB423D1FC2369B2")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        addTaint(keySize);
CipherParameters var9505286CD610A91174FF03781FA2DA54_1350363243 =         generateDerivedParameters(keySize);
        var9505286CD610A91174FF03781FA2DA54_1350363243.addTaint(taint);
        return var9505286CD610A91174FF03781FA2DA54_1350363243;
        // ---------- Original Method ----------
        //return generateDerivedParameters(keySize);
    }

    
}

