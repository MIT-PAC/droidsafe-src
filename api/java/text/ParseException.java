package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ParseException extends Exception {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.801 -0400", hash_original_field = "57D19B3FC2AF605BB9ADD6379EF4F14F", hash_generated_field = "258A596A4575EE51D9F18F048FF1B7C5")

    private int errorOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.802 -0400", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "D1555EF0FFA9A6471C758462A176BF9F")
    public  ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        addTaint(detailMessage.getTaint());
        errorOffset = location;
        // ---------- Original Method ----------
        //errorOffset = location;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.802 -0400", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "2F620C0A75F3211D64C6E5F78D7228D0")
    public int getErrorOffset() {
        int var57D19B3FC2AF605BB9ADD6379EF4F14F_763548116 = (errorOffset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090504649 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2090504649;
        // ---------- Original Method ----------
        //return errorOffset;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.802 -0400", hash_original_field = "138CDDD5C93305BF7D6B5E9D27100630", hash_generated_field = "5A7101C6E28567B3F3B659C16DEAC630")

    private static final long serialVersionUID = 2703218443322787634L;
}

