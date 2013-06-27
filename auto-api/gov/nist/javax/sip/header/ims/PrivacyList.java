package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PrivacyList extends SIPHeaderList<Privacy> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.426 -0400", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "1112F36E1D63D8A6DB0A3433FC13B944")
    public  PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.427 -0400", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "0710966A2DF7BE72083FAB4DAE3B10FC")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1101367776 = null; //Variable for return #1
        PrivacyList retval;
        retval = new PrivacyList();
        varB4EAC82CA7396A68D541C85D26508E83_1101367776 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1101367776.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1101367776;
        // ---------- Original Method ----------
        //PrivacyList retval = new PrivacyList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.427 -0400", hash_original_field = "C0CA76C219951888324430E8E7118357", hash_generated_field = "C55D295070CABE986E91959B76F3BB53")

    private static long serialVersionUID = 1798720509806307461L;
}

