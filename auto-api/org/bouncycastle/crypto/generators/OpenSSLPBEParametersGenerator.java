package org.bouncycastle.crypto.generators;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.031 -0400", hash_original_field = "16434969A53FBE1B6177CDA9EA0B2CD3", hash_generated_field = "91AB1A516766E39A2EE21B008511F72A")

    private Digest digest = new MD5Digest();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.031 -0400", hash_original_method = "469CB0205646D06181D1559BA7D61CF9", hash_generated_method = "1CCF825CE7F4725EE21D0B68C89CAE4D")
    public  OpenSSLPBEParametersGenerator() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.032 -0400", hash_original_method = "2CA180C614EC01706903EAD38F06E97B", hash_generated_method = "EE902D6EAA15E3CD0D8EFC5A1A3AECA9")
    public void init(
       byte[] password,
       byte[] salt) {
        super.init(password, salt, 1);
        addTaint(password[0]);
        addTaint(salt[0]);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.033 -0400", hash_original_method = "4E618B69222EA698951005FED9FF9FA3", hash_generated_method = "B785E294494CD20C44E4B70AB36A449F")
    private byte[] generateDerivedKey(
        int bytesNeeded) {
        byte[] buf = new byte[digest.getDigestSize()];
        byte[] key = new byte[bytesNeeded];
        int offset = 0;
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
        } 
        addTaint(bytesNeeded);
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_695102355 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_695102355;
        
        
        
        
        
        
            
            
            
            
            
            
            
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.033 -0400", hash_original_method = "47F03A4B7607EC42FAB580BDD530C12C", hash_generated_method = "5D1536746EE607475272BC65868ECA43")
    public CipherParameters generateDerivedParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_1412845088 = null; 
        keySize = keySize / 8;
        byte[] dKey = generateDerivedKey(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_1412845088 = new KeyParameter(dKey, 0, keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_1412845088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1412845088;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.034 -0400", hash_original_method = "51142E64B42932805E0B604E9F91CFAD", hash_generated_method = "382FEC7722A08B453F333A2127E03F88")
    public CipherParameters generateDerivedParameters(
        int     keySize,
        int     ivSize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_1435755155 = null; 
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey = generateDerivedKey(keySize + ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_1435755155 = new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
        addTaint(keySize);
        addTaint(ivSize);
        varB4EAC82CA7396A68D541C85D26508E83_1435755155.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1435755155;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.034 -0400", hash_original_method = "9CBF59A81FEE9822185147DE8DCD075A", hash_generated_method = "05A6F090260132E32F7DA0874BD35073")
    public CipherParameters generateDerivedMacParameters(
        int keySize) {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_911414361 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_911414361 = generateDerivedParameters(keySize);
        addTaint(keySize);
        varB4EAC82CA7396A68D541C85D26508E83_911414361.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_911414361;
        
        
    }

    
}

