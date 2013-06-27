package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class RequireList extends SIPHeaderList<Require> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.347 -0400", hash_original_method = "7F18EBBB41892DE4ABBAD1AE9000FBF7", hash_generated_method = "36D9A361FAF93C191230D023E2D39CA4")
    public  RequireList() {
        super(Require.class, RequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.347 -0400", hash_original_method = "4C9D6FE7DF8BFD06BB544C2582BF8758", hash_generated_method = "06A1743C873C7BECF5D038E9A045D656")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1434050542 = null; //Variable for return #1
        RequireList retval;
        retval = new RequireList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1434050542 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1434050542.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1434050542;
        // ---------- Original Method ----------
        //RequireList retval = new RequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.352 -0400", hash_original_field = "8080C96575DEF2E403CA5D4337270376", hash_generated_field = "568650C4B9541BFC2BCF2EC9E7813B15")

    private static long serialVersionUID = -1760629092046963213L;
}

