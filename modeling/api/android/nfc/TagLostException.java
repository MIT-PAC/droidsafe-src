package android.nfc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class TagLostException extends IOException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.475 -0500", hash_original_method = "CBC103EF7AC32AEF91409A49527DDCFB", hash_generated_method = "C68855AE03A93B4B35492ECEDDB91651")
    
public TagLostException() {
        super();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:47.478 -0500", hash_original_method = "239642EC7BB7F7E7C0FD631CE1F9537C", hash_generated_method = "1689781C79202287B703764D87B8DBA0")
    
public TagLostException(String message) {
        super(message);
    }
    
}

