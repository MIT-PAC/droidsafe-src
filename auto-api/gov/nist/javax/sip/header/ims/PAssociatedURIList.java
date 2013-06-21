package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.559 -0400", hash_original_method = "4F3C386FF0DD7CB0697F371A75488EC2", hash_generated_method = "35867964AE38FD2D92EA7E427B86E224")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PAssociatedURIList() {
        super(PAssociatedURI.class, PAssociatedURI.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.560 -0400", hash_original_method = "85D89754B0983A44CEDEEC2CF2B4E2A8", hash_generated_method = "A36352FF315C7D00FF08CFE9EDDBEAA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        PAssociatedURIList retval;
        retval = new PAssociatedURIList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1779813820 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PAssociatedURIList retval = new PAssociatedURIList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = 4454306052557362851L;
}

