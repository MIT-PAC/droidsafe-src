package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.503 -0400", hash_original_field = "57D19B3FC2AF605BB9ADD6379EF4F14F", hash_generated_field = "258A596A4575EE51D9F18F048FF1B7C5")

    private int errorOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.503 -0400", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "C2E0C0635105B16B32714A0C0130B05A")
    public  ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        errorOffset = location;
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
        //errorOffset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.503 -0400", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "8F78825CE8582B8006ECFAAE3894A4FD")
    public int getErrorOffset() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037879353 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1037879353;
        // ---------- Original Method ----------
        //return errorOffset;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.503 -0400", hash_original_field = "138CDDD5C93305BF7D6B5E9D27100630", hash_generated_field = "8BA67A70347C4A9B54ECC8C4AECA282F")

    private static long serialVersionUID = 2703218443322787634L;
}

