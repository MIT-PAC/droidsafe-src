package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CodingErrorAction {
    private String action;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.257 -0400", hash_original_method = "97CD51F500ABFE41AE4BD609F91C5F74", hash_generated_method = "E3747D85BA18DF022E006C472AB8C158")
    @DSModeled(DSC.SAFE)
    private CodingErrorAction(String action) {
        dsTaint.addTaint(action);
        // ---------- Original Method ----------
        //this.action = action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.257 -0400", hash_original_method = "A74604AE646C671FE46897A241086F47", hash_generated_method = "552566AA99471751839D56B48B0E5B8C")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Action: " + this.action;
    }

    
    public static final CodingErrorAction IGNORE = new CodingErrorAction(
            "IGNORE");
    public static final CodingErrorAction REPLACE = new CodingErrorAction(
            "REPLACE");
    public static final CodingErrorAction REPORT = new CodingErrorAction(
            "REPORT");
}

