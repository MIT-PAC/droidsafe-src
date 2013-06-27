package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.072 -0400", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "52313BE3C7A7A4FFFFF799BC507758A6")
    public  InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.072 -0400", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "E3DD3E4D88AB430FC3AFEF5235160213")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1993119107 = null; //Variable for return #1
        InReplyToList retval;
        retval = new InReplyToList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1993119107 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1993119107.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1993119107;
        // ---------- Original Method ----------
        //InReplyToList retval = new InReplyToList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.072 -0400", hash_original_field = "2A446AA5963733707A1B3F286FE94EB3", hash_generated_field = "5A36048EDF4314F04A8E3BAD09701B48")

    private static long serialVersionUID = -7993498496830999237L;
}

