package org.bouncycastle.openssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class PasswordException extends IOException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:34.118 -0500", hash_original_method = "C6899838B1393DC816DA483F96511D69", hash_generated_method = "F8A973D8A49293EEEDF624237EDFE041")
    
public PasswordException(String msg)
    {
        super(msg);
    }
    
}

