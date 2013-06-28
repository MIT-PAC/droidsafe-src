package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.973 -0400", hash_original_field = "57D19B3FC2AF605BB9ADD6379EF4F14F", hash_generated_field = "258A596A4575EE51D9F18F048FF1B7C5")

    private int errorOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.973 -0400", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "C2E0C0635105B16B32714A0C0130B05A")
    public  ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        errorOffset = location;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //errorOffset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.974 -0400", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "42788D60D47742DC4E728C2E2FFDDCEA")
    public int getErrorOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988251327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988251327;
        // ---------- Original Method ----------
        //return errorOffset;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.974 -0400", hash_original_field = "138CDDD5C93305BF7D6B5E9D27100630", hash_generated_field = "5A7101C6E28567B3F3B659C16DEAC630")

    private static final long serialVersionUID = 2703218443322787634L;
}

