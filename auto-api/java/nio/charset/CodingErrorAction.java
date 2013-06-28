package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class CodingErrorAction {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.004 -0400", hash_original_field = "418C5509E2171D55B0AEE5C2EA4442B5", hash_generated_field = "B1982569D823DF720405855D93182845")

    private String action;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.005 -0400", hash_original_method = "97CD51F500ABFE41AE4BD609F91C5F74", hash_generated_method = "7A8E959B2CD8A428B2EF81F66E186CC8")
    private  CodingErrorAction(String action) {
        this.action = action;
        // ---------- Original Method ----------
        //this.action = action;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.005 -0400", hash_original_method = "A74604AE646C671FE46897A241086F47", hash_generated_method = "337A605A0DA6D1BC1343DC37A8059819")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1016714718 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1016714718 = "Action: " + this.action;
        varB4EAC82CA7396A68D541C85D26508E83_1016714718.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1016714718;
        // ---------- Original Method ----------
        //return "Action: " + this.action;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.005 -0400", hash_original_field = "0F5B8118B30070942489AD77C0474094", hash_generated_field = "180E61F2E81DA6FA0483F69131029064")

    public static final CodingErrorAction IGNORE = new CodingErrorAction(
            "IGNORE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.005 -0400", hash_original_field = "09AFE2E9F798DE3373809AE3664DDC29", hash_generated_field = "71B23436B9F036A6D96826127DFB318D")

    public static final CodingErrorAction REPLACE = new CodingErrorAction(
            "REPLACE");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:57.005 -0400", hash_original_field = "48B81E9D42599CE475EF19EF6CF26E3F", hash_generated_field = "D805EA59DDF422B4EBEECDD03C0F17B7")

    public static final CodingErrorAction REPORT = new CodingErrorAction(
            "REPORT");
}

