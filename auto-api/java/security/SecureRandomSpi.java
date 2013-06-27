package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class SecureRandomSpi implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.155 -0400", hash_original_method = "80C7AF93ECB1E3D5135CFB765D8A9626", hash_generated_method = "80C7AF93ECB1E3D5135CFB765D8A9626")
    public SecureRandomSpi ()
    {
        //Synthesized constructor
    }


    protected abstract void engineSetSeed(byte[] seed);

    
    protected abstract void engineNextBytes(byte[] bytes);

    
    protected abstract byte[] engineGenerateSeed(int numBytes);

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.155 -0400", hash_original_field = "264DBA7E929051B2931581083A1B45BD", hash_generated_field = "D8EAC7C63EA0EAC0061C7B715AFBFA0C")

    private static long serialVersionUID = -2991854161009191830L;
}

