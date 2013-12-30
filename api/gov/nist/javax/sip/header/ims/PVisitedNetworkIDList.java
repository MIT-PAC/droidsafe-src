package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class PVisitedNetworkIDList extends SIPHeaderList<PVisitedNetworkID> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.287 -0500", hash_original_field = "12C4C42FA2DC7C90B3A01C3148EA6D9B", hash_generated_field = "638E8C34E6F0641EC1CF8EF02883E4F4")


    private static final long serialVersionUID = -4346667490341752478L;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.290 -0500", hash_original_method = "755748D1B1A32FE22452F6E783BD15E2", hash_generated_method = "445EC97FA1F69ACAA37029AF081AE20D")
    
public PVisitedNetworkIDList() {
        super(PVisitedNetworkID.class, PVisitedNetworkIDHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.294 -0500", hash_original_method = "7C4CA7398653F51DA5C0E61CD8209B41", hash_generated_method = "5BC4B6E3AC3276B05732BBAEF2D1AA85")
    
public Object clone() {
        PVisitedNetworkIDList retval = new PVisitedNetworkIDList();
        return retval.clonehlist(this.hlist);
    }
}

