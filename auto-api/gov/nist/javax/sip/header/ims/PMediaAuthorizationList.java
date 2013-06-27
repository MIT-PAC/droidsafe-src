package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PMediaAuthorizationList extends SIPHeaderList<PMediaAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.421 -0400", hash_original_method = "656C497A7A9D2E8465BD84DF21BD0C00", hash_generated_method = "9BCAC9929D32D2F555BF0B2B59C10BB5")
    public  PMediaAuthorizationList() {
        super(PMediaAuthorization.class, PMediaAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.422 -0400", hash_original_method = "535B60F78292A563EBB4CD53A0D5E752", hash_generated_method = "A132CED7B0FDE6004C4E3AA7F7569809")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_711301476 = null; //Variable for return #1
        PMediaAuthorizationList retval;
        retval = new PMediaAuthorizationList();
        varB4EAC82CA7396A68D541C85D26508E83_711301476 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_711301476.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_711301476;
        // ---------- Original Method ----------
        //PMediaAuthorizationList retval = new PMediaAuthorizationList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:32.422 -0400", hash_original_field = "29812CDE5546F301183126FFBF7F26AC", hash_generated_field = "3328714C1175ABD43EEC9266CAEFD360")

    private static long serialVersionUID = -8226328073989632317L;
}

