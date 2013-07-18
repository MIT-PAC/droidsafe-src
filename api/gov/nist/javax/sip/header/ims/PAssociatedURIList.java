package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import gov.nist.javax.sip.header.SIPHeaderList;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.114 -0400", hash_original_method = "4F3C386FF0DD7CB0697F371A75488EC2", hash_generated_method = "35867964AE38FD2D92EA7E427B86E224")
    public  PAssociatedURIList() {
        super(PAssociatedURI.class, PAssociatedURI.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.114 -0400", hash_original_method = "85D89754B0983A44CEDEEC2CF2B4E2A8", hash_generated_method = "406DC38289D422A5E18FABECC7FC82A6")
    public Object clone() {
        PAssociatedURIList retval = new PAssociatedURIList();
Object varF627329B9209466293A1BF71D9AF7B2B_365064120 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_365064120.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_365064120;
        // ---------- Original Method ----------
        //PAssociatedURIList retval = new PAssociatedURIList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.115 -0400", hash_original_field = "F2A09E90533068AD94F7E1B321852ACA", hash_generated_field = "E2DA2BC3F02BE9493383780AA95C2103")

    private static final long serialVersionUID = 4454306052557362851L;
}

