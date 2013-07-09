package org.bouncycastle.crypto.params;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithIV implements CipherParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.120 -0400", hash_original_field = "F0B53B2DA041FCA49EF0B9839060B345", hash_generated_field = "EF60E6736481A45AB4AEED35775132C4")

    private byte[] iv;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.120 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "37E4A1EB8E400F5F526111B05CB36773")

    private CipherParameters parameters;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.120 -0400", hash_original_method = "02220345FBEC664F191759358E3133FB", hash_generated_method = "C254BC5CA6C0992186E49A3FE9834DD9")
    public  ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv) {
        this(parameters, iv, 0, iv.length);
        addTaint(parameters.getTaint());
        addTaint(iv[0]);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.121 -0400", hash_original_method = "828E5FEC62EC7B691A55A07AD37E3F65", hash_generated_method = "43C420BD1E052276C1CB11DB2E1F5A6B")
    public  ParametersWithIV(
        CipherParameters    parameters,
        byte[]              iv,
        int                 ivOff,
        int                 ivLen) {
        this.iv = new byte[ivLen];
        this.parameters = parameters;
        System.arraycopy(iv, ivOff, this.iv, 0, ivLen);
        addTaint(ivOff);
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.121 -0400", hash_original_method = "D19EA42446BC5DC2CC45B356827C0DC7", hash_generated_method = "C5B657E9160F0121FA7D5A36E4C4A9EA")
    public byte[] getIV() {
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_502560606 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_502560606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:46.121 -0400", hash_original_method = "4D76F2EFD1EF9C1CA864824F06254E67", hash_generated_method = "BCB80A170F07E107F09CD76E075B4246")
    public CipherParameters getParameters() {
        CipherParameters varB4EAC82CA7396A68D541C85D26508E83_31278944 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_31278944 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_31278944.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_31278944;
        
        
    }

    
}

