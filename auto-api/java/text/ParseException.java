package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ParseException extends Exception {
    private int errorOffset;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.480 -0400", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "84E5E010722CF366820A9EF3CA121D98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        dsTaint.addTaint(location);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
        //errorOffset = location;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.481 -0400", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "22E5223090D8200F88F3EBCE9001DA5A")
    @DSModeled(DSC.SAFE)
    public int getErrorOffset() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return errorOffset;
    }

    
    private static final long serialVersionUID = 2703218443322787634L;
}

