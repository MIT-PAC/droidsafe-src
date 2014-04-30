package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class Base64DataException extends IOException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.962 -0500", hash_original_method = "4EC3E97359DA3A3F3DC9A065DD926D19", hash_generated_method = "443E18CCF5CCDAA0E95F891143C64D33")
    
public Base64DataException(String detailMessage) {
        super(detailMessage);
    }
    
}

