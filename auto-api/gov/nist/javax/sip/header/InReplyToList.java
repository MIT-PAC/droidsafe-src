package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.761 -0400", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "52313BE3C7A7A4FFFFF799BC507758A6")
    public  InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.762 -0400", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "571A34DB98404071835BBAF49D4E60C6")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_716117861 = null; //Variable for return #1
        InReplyToList retval = new InReplyToList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_716117861 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_716117861.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_716117861;
        // ---------- Original Method ----------
        //InReplyToList retval = new InReplyToList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.762 -0400", hash_original_field = "2A446AA5963733707A1B3F286FE94EB3", hash_generated_field = "A3E5ABCB1257722D07C0C4A7F8ADE615")

    private static final long serialVersionUID = -7993498496830999237L;
}

