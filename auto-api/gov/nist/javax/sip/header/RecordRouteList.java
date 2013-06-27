package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class RecordRouteList extends SIPHeaderList<RecordRoute> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.288 -0400", hash_original_method = "7184B4196316005943D81815B77BA6D1", hash_generated_method = "A09A2763146C97B1F662605DF0ED92C3")
    public  RecordRouteList() {
        super(RecordRoute.class, RecordRouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.293 -0400", hash_original_method = "7817AF16B5252B16AA7B12BAE88CFC40", hash_generated_method = "48794876F4A412D8A009879E0C1A9CF3")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_206103925 = null; //Variable for return #1
        RecordRouteList retval;
        retval = new RecordRouteList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_206103925 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_206103925.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_206103925;
        // ---------- Original Method ----------
        //RecordRouteList retval = new RecordRouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.293 -0400", hash_original_field = "3F3F267B538FC1595859DA217FDED7CD", hash_generated_field = "B78E1464FADFCAE2A562E7BA0A22C013")

    private static long serialVersionUID = 1724940469426766691L;
}

