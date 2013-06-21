package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;
import gov.nist.javax.sip.header.ims.PVisitedNetworkIDHeader;

public class PVisitedNetworkIDList extends SIPHeaderList<PVisitedNetworkID> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.630 -0400", hash_original_method = "755748D1B1A32FE22452F6E783BD15E2", hash_generated_method = "0F82AF3A13009C31F1061E0FD71C3D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PVisitedNetworkIDList() {
        super(PVisitedNetworkID.class, PVisitedNetworkIDHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.631 -0400", hash_original_method = "7C4CA7398653F51DA5C0E61CD8209B41", hash_generated_method = "ED042C26716A1C979E87490BDB6F7E03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PVisitedNetworkIDList retval;
        retval = new PVisitedNetworkIDList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_998408366 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PVisitedNetworkIDList retval = new PVisitedNetworkIDList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -4346667490341752478L;
}

