package android.database;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CursorIndexOutOfBoundsException extends IndexOutOfBoundsException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.078 -0400", hash_original_method = "7D18BDB25CF5B28922C44487D666A0F3", hash_generated_method = "999C209F83B543A14097323077429FF5")
    public  CursorIndexOutOfBoundsException(int index, int size) {
        super("Index " + index + " requested, with a size of " + size);
        addTaint(index);
        addTaint(size);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:09.078 -0400", hash_original_method = "7E52A2C3F9CDD649181FC5C4A8E3976F", hash_generated_method = "42AC2ADC42E8EC7640C60F95D25F4414")
    public  CursorIndexOutOfBoundsException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
}

