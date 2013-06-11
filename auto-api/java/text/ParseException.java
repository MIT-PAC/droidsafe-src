package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class ParseException extends Exception {
    private static final long serialVersionUID = 2703218443322787634L;
    private int errorOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.140 -0400", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "FAF654827358A3B93D87B0365598F2FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        dsTaint.addTaint(detailMessage);
        dsTaint.addTaint(location);
        // ---------- Original Method ----------
        //errorOffset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.140 -0400", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "E668E9D39114FB9DB24880BBF27495C3")
    @DSModeled(DSC.SAFE)
    public int getErrorOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorOffset;
    }

    
}


