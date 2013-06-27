package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Iterator;
import javax.sip.header.*;

public class UnsupportedList extends SIPHeaderList<Unsupported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.724 -0400", hash_original_method = "CBBAF1558631750DDBDF9DAEDB7A572C", hash_generated_method = "8F7A7A782386B52882B87C6BD42B708B")
    public  UnsupportedList() {
        super(Unsupported.class, UnsupportedHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.725 -0400", hash_original_method = "586FD49C37A8AA9D6CC092649E8819BF", hash_generated_method = "66D3921A952D4BCC7CDBE4411A7B8BAB")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1357053102 = null; //Variable for return #1
        UnsupportedList retval;
        retval = new UnsupportedList();
        varB4EAC82CA7396A68D541C85D26508E83_1357053102 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1357053102.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1357053102;
        // ---------- Original Method ----------
        //UnsupportedList retval = new UnsupportedList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.725 -0400", hash_original_field = "043C2460CDAFC725D54C2CA7401A9DF9", hash_generated_field = "DD132B81B7A986F003683C3540A14E03")

    private static long serialVersionUID = -4052610269407058661L;
}

