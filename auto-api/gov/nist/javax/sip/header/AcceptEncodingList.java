package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.064 -0400", hash_original_method = "6872E94CB9CC14DAB89517B2FDF048F7", hash_generated_method = "8D77967938F665982D2EA5AC5A044ED3")
    public  AcceptEncodingList() {
        super(AcceptEncoding.class, AcceptEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.065 -0400", hash_original_method = "39DF8810A78ACD57DE26FFD5511EC56E", hash_generated_method = "417510E9908FEEA56604754225C7D803")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1207176519 = null; //Variable for return #1
        AcceptEncodingList retval;
        retval = new AcceptEncodingList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1207176519 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1207176519.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1207176519;
        // ---------- Original Method ----------
        //AcceptEncodingList retval = new AcceptEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
}

