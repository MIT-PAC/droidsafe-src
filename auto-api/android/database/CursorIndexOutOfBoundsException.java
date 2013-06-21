package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.998 -0400", hash_original_method = "7D18BDB25CF5B28922C44487D666A0F3", hash_generated_method = "3A53DB4748584F7C7E3307911ECBC871")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorIndexOutOfBoundsException(int index, int size) {
        super("Index " + index + " requested, with a size of " + size);
        dsTaint.addTaint(index);
        dsTaint.addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:45.998 -0400", hash_original_method = "7E52A2C3F9CDD649181FC5C4A8E3976F", hash_generated_method = "CD1E2DD55550C2673EFE7F0800441D4E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CursorIndexOutOfBoundsException(String message) {
        super(message);
        dsTaint.addTaint(message);
        // ---------- Original Method ----------
    }

    
}

