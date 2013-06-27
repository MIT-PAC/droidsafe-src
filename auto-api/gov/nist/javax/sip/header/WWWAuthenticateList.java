package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import  javax.sip.header.*;

public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.823 -0400", hash_original_method = "5D0C93082A28C4F76AC90901A48C6BD1", hash_generated_method = "6035EA6C915C1EC737CCB1ED8A829814")
    public  WWWAuthenticateList() {
        super(WWWAuthenticate.class, WWWAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.824 -0400", hash_original_method = "CD4D2DBD74BB3BE1B1C2856EF354DA52", hash_generated_method = "F4AD06E94A50A86D1CF96484EBC7A4D2")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_352077780 = null; //Variable for return #1
        WWWAuthenticateList retval;
        retval = new WWWAuthenticateList();
        varB4EAC82CA7396A68D541C85D26508E83_352077780 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_352077780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_352077780;
        // ---------- Original Method ----------
        //WWWAuthenticateList retval = new WWWAuthenticateList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.824 -0400", hash_original_field = "1E01E6607AEE257B1EA82D4E79E39A88", hash_generated_field = "0AE4192948B0337D0A3780510654E1BF")

    private static long serialVersionUID = -6978902284285501346L;
}

