package java.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class SecureRandomSpi implements Serializable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.525 -0400", hash_original_method = "00464996810138782590FE80CA45757C", hash_generated_method = "00464996810138782590FE80CA45757C")
        public SecureRandomSpi ()
    {
    }


    protected abstract void engineSetSeed(byte[] seed);

    
    protected abstract void engineNextBytes(byte[] bytes);

    
    protected abstract byte[] engineGenerateSeed(int numBytes);

    
    private static final long serialVersionUID = -2991854161009191830L;
}

