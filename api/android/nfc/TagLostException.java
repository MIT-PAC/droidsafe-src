package android.nfc;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGenerator;

public class TagLostException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.388 -0400", hash_original_method = "CBC103EF7AC32AEF91409A49527DDCFB", hash_generated_method = "25C1E25DA00F6A263E31CB53D6E1A15D")
    public  TagLostException() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:23.388 -0400", hash_original_method = "239642EC7BB7F7E7C0FD631CE1F9537C", hash_generated_method = "C2CF0D5741DE84E0868DF5282BEDA9C7")
    public  TagLostException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

