package android.util;

// Droidsafe Imports
import java.io.IOException;

import droidsafe.annotations.DSGenerator;

public class Base64DataException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.592 -0400", hash_original_method = "4EC3E97359DA3A3F3DC9A065DD926D19", hash_generated_method = "3D13AB6CFA099CC4EA16B5C320123C63")
    public  Base64DataException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
}

