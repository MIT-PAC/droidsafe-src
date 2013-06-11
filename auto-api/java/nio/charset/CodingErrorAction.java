package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class CodingErrorAction {
    public static final CodingErrorAction IGNORE = new CodingErrorAction(
            "IGNORE");
    public static final CodingErrorAction REPLACE = new CodingErrorAction(
            "REPLACE");
    public static final CodingErrorAction REPORT = new CodingErrorAction(
            "REPORT");
    private String action;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.560 -0400", hash_original_method = "97CD51F500ABFE41AE4BD609F91C5F74", hash_generated_method = "601683E2F1FD72E7B7D7E5A982505D13")
    @DSModeled(DSC.SAFE)
    private CodingErrorAction(String action) {
        dsTaint.addTaint(action);
        // ---------- Original Method ----------
        //this.action = action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.560 -0400", hash_original_method = "A74604AE646C671FE46897A241086F47", hash_generated_method = "C271F913D066DA2A50C4BE728F82A72B")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Action: " + this.action;
    }

    
}


