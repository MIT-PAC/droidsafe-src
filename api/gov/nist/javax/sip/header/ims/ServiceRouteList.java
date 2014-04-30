package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class ServiceRouteList extends SIPHeaderList<ServiceRoute> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.586 -0500", hash_original_field = "42A2D6950650105ED6F19C5327C09D8A", hash_generated_field = "6B0CBD0A78E3E34C35CAC0019012F837")

    private static final long serialVersionUID = -4264811439080938519L;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.590 -0500", hash_original_method = "C0CA39C0A35C17F8012D1D71020C7494", hash_generated_method = "F817F67D70DE3897FF24BE183ED21BC3")
    
public ServiceRouteList() {
        super(ServiceRoute.class, ServiceRouteHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:56.593 -0500", hash_original_method = "1032498AE96A3DBCEFF1D5F4D42985C8", hash_generated_method = "BC44DEF6E9B0776E11FFC921235E5B34")
    
public Object clone() {
        ServiceRouteList retval = new ServiceRouteList();
        return retval.clonehlist(this.hlist);
    }
}

