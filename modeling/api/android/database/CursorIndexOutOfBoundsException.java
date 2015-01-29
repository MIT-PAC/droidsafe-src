package android.database;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.152 -0500", hash_original_method = "7D18BDB25CF5B28922C44487D666A0F3", hash_generated_method = "B589712C12C92D0CD29305D6013BFF07")
    
public CursorIndexOutOfBoundsException(int index, int size) {
        super("Index " + index + " requested, with a size of " + size);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:45.155 -0500", hash_original_method = "7E52A2C3F9CDD649181FC5C4A8E3976F", hash_generated_method = "30B027354F09A7E754A232542AFBBF16")
    
public CursorIndexOutOfBoundsException(String message) {
        super(message);
    }
    
}

