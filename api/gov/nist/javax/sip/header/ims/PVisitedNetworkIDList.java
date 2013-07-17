package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;

public class PVisitedNetworkIDList extends SIPHeaderList<PVisitedNetworkID> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.346 -0400", hash_original_method = "755748D1B1A32FE22452F6E783BD15E2", hash_generated_method = "0F82AF3A13009C31F1061E0FD71C3D3E")
    public  PVisitedNetworkIDList() {
        super(PVisitedNetworkID.class, PVisitedNetworkIDHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.347 -0400", hash_original_method = "7C4CA7398653F51DA5C0E61CD8209B41", hash_generated_method = "1865E0676909CF60B22F9A2445A7CCD7")
    public Object clone() {
        PVisitedNetworkIDList retval = new PVisitedNetworkIDList();
Object varF627329B9209466293A1BF71D9AF7B2B_358613401 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_358613401.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_358613401;
        // ---------- Original Method ----------
        //PVisitedNetworkIDList retval = new PVisitedNetworkIDList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.347 -0400", hash_original_field = "32DCF15511677F4191CD259156DD8BE2", hash_generated_field = "638E8C34E6F0641EC1CF8EF02883E4F4")

    private static final long serialVersionUID = -4346667490341752478L;
}

