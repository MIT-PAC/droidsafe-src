package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class ServiceRouteList extends SIPHeaderList<ServiceRoute> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.503 -0400", hash_original_method = "C0CA39C0A35C17F8012D1D71020C7494", hash_generated_method = "357269883D61B3888F1D67DD56AA019B")
    public  ServiceRouteList() {
        super(ServiceRoute.class, ServiceRouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.503 -0400", hash_original_method = "1032498AE96A3DBCEFF1D5F4D42985C8", hash_generated_method = "25D63D0F646BC25005D37A24590ECAF5")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1096145645 = null; //Variable for return #1
        ServiceRouteList retval;
        retval = new ServiceRouteList();
        varB4EAC82CA7396A68D541C85D26508E83_1096145645 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1096145645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1096145645;
        // ---------- Original Method ----------
        //ServiceRouteList retval = new ServiceRouteList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.503 -0400", hash_original_field = "204BBA06A885F5F15AC6804DDBBC5155", hash_generated_field = "8E839FC3B6C1933679A0490760438DBE")

    private static long serialVersionUID = -4264811439080938519L;
}

