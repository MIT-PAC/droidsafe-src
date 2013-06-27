package org.bouncycastle.crypto.generators;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.636 -0400", hash_original_field = "16434969A53FBE1B6177CDA9EA0B2CD3", hash_generated_field = "91AB1A516766E39A2EE21B008511F72A")

    private Digest digest = new MD5Digest();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.637 -0400", hash_original_method = "469CB0205646D06181D1559BA7D61CF9", hash_generated_method = "1CCF825CE7F4725EE21D0B68C89CAE4D")
    public  OpenSSLPBEParametersGenerator() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.637 -0400", hash_original_method = "2CA180C614EC01706903EAD38F06E97B", hash_generated_method = "EE902D6EAA15E3CD0D8EFC5A1A3AECA9")
    public void init(
       byte[] password,
       byte[] salt) {
        super.init(password, salt, 1);
        addTaint(password[0]);
        addTaint(salt[0]);
        // ---------- Original Method ----------
        //super.init(password, salt, 1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.656 -0400", hash_original_method = "4E618B69222EA698951005FED9FF9FA3", hash_generated_method = "A9A15712517FBC511596DA92548AB6D4")
    private byte[] generateDerivedKey(
        int bytesNeeded) {
        byte[] buf;
        buf = new byte[digest.getDigestSize()];
        byte[] key;
        key = new byte[bytesNeeded];
        int offset;
        offset = 0;
        {
            digest.update(password, 0, password.length);
            digest.update(salt, 0, salt.length);
            digest.doFinal(buf, 0);
            int len;
            len = buf.length;
            len = bytesNeeded;
            System.arraycopy(buf, 0, key, offset, len);
            offset += len;
            bytesNeeded -= len;
            digest.reset();
            digest.update(buf, 0, buf.length);
        } //End block
        addTaint(bytesNeeded);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1226828655 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1226828655;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.657 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "B83448F7058DE7177D564635B767B894")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_922628240 = null; //Variable for return #1
        keySize = keySize / 8;
        byte[] dKey;
        dKey = generateDerivedKey(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_922628240 = new KeyParameter(dKey, 0, keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_922628240.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_922628240;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //byte[]  dKey = generateDerivedKey(keySize);
        //return new KeyParameter(dKey, 0, keySize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.658 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "50A98D4F9FE96976EB6E173B08CD2E86")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_10034337 = null; //Variable for return #1
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey;
        dKey = generateDerivedKey(keySize + ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_10034337 = new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        addTaint(keySize);
        addTaint(ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_10034337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_10034337;
        // ---------- Original Method ----------
        //keySize = keySize / 8;
        //ivSize = ivSize / 8;
        //byte[]  dKey = generateDerivedKey(keySize + ivSize);
        //return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.669 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "95BA33F33719EA0DDFFE76FC4E507591")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_538952884 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_538952884 = generateDerivedParameters(keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_538952884.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_538952884;
        // ---------- Original Method ----------
        //return generateDerivedParameters(keySize);
    }

    
}

