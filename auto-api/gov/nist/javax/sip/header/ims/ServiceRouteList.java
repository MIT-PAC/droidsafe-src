package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class ServiceRouteList extends SIPHeaderList<ServiceRoute> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.669 -0400", hash_original_method = "C0CA39C0A35C17F8012D1D71020C7494", hash_generated_method = "357269883D61B3888F1D67DD56AA019B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ServiceRouteList() {
        super(ServiceRoute.class, ServiceRouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.669 -0400", hash_original_method = "1032498AE96A3DBCEFF1D5F4D42985C8", hash_generated_method = "2C9D2ECEF3E85A349238A870E6D0A638")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ServiceRouteList retval;
        retval = new ServiceRouteList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_100689156 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ServiceRouteList retval = new ServiceRouteList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -4264811439080938519L;
}

