package org.bouncycastle.crypto.params;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.crypto.CipherParameters;

public class AsymmetricKeyParameter implements CipherParameters {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.547 -0400", hash_original_field = "BD0C8E3BD998A500B0984584A7245CA0", hash_generated_field = "B7CB1A33B0CE83673F166D8478A09AB7")

    boolean privateKey;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.547 -0400", hash_original_method = "DD522CA24B87E383EA27DC7A872D3AC1", hash_generated_method = "93CA0F2AF4E2A5A04CA21A70D521BF2C")
    public  AsymmetricKeyParameter(
        boolean privateKey) {
        this.privateKey = privateKey;
        // ---------- Original Method ----------
        //this.privateKey = privateKey;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.548 -0400", hash_original_method = "47130025E2A64A0FEA07D9052329E298", hash_generated_method = "7FD3293EF92A02327B536857934A93BD")
    public boolean isPrivate() {
        boolean varBD0C8E3BD998A500B0984584A7245CA0_964930082 = (privateKey);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344408496 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344408496;
        // ---------- Original Method ----------
        //return privateKey;
    }

    
}

