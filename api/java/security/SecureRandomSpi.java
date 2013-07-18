package java.security;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class SecureRandomSpi implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.358 -0400", hash_original_method = "80C7AF93ECB1E3D5135CFB765D8A9626", hash_generated_method = "80C7AF93ECB1E3D5135CFB765D8A9626")
    public SecureRandomSpi ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    protected abstract void engineSetSeed(byte[] seed);

    
    @DSModeled(DSC.SAFE)
    protected abstract void engineNextBytes(byte[] bytes);

    
    @DSModeled(DSC.SAFE)
    protected abstract byte[] engineGenerateSeed(int numBytes);

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:55.358 -0400", hash_original_field = "264DBA7E929051B2931581083A1B45BD", hash_generated_field = "FD60E79FCEB20AD629BA66BEC1122BB3")

    private static final long serialVersionUID = -2991854161009191830L;
}

