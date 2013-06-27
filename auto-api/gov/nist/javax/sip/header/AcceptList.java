package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptList extends SIPHeaderList<Accept> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.348 -0400", hash_original_method = "51B5F4325CF7E310BAF41022AF7E4824", hash_generated_method = "70A657851AA3A54A657243AA76937424")
    public  AcceptList() {
        super(Accept.class, AcceptHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.348 -0400", hash_original_method = "3C553A191FB2DA2F431571F69D6628C7", hash_generated_method = "29F22D22B240F1A387078C0C49641A97")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_2088103614 = null; //Variable for return #1
        AcceptList retval;
        retval = new AcceptList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_2088103614 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_2088103614.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2088103614;
        // ---------- Original Method ----------
        //AcceptList retval = new AcceptList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:31.348 -0400", hash_original_field = "8560220F20AFBF56AD0369D138528219", hash_generated_field = "889CBDEAA1869CCD111DA0C5B37377F9")

    private static long serialVersionUID = -1800813338560484831L;
}

