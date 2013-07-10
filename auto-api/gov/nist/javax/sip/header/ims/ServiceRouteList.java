package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class ServiceRouteList extends SIPHeaderList<ServiceRoute> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.583 -0400", hash_original_method = "C0CA39C0A35C17F8012D1D71020C7494", hash_generated_method = "357269883D61B3888F1D67DD56AA019B")
    public  ServiceRouteList() {
        super(ServiceRoute.class, ServiceRouteHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.583 -0400", hash_original_method = "1032498AE96A3DBCEFF1D5F4D42985C8", hash_generated_method = "2EED65CA63A53BF4B8BADA1A2EFD43C8")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_686416459 = null; 
        ServiceRouteList retval = new ServiceRouteList();
        varB4EAC82CA7396A68D541C85D26508E83_686416459 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_686416459.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_686416459;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.583 -0400", hash_original_field = "204BBA06A885F5F15AC6804DDBBC5155", hash_generated_field = "6B0CBD0A78E3E34C35CAC0019012F837")

    private static final long serialVersionUID = -4264811439080938519L;
}

