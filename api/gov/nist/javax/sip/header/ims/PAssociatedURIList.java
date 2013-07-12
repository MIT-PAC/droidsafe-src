package gov.nist.javax.sip.header.ims;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.919 -0400", hash_original_method = "4F3C386FF0DD7CB0697F371A75488EC2", hash_generated_method = "35867964AE38FD2D92EA7E427B86E224")
    public  PAssociatedURIList() {
        super(PAssociatedURI.class, PAssociatedURI.NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.920 -0400", hash_original_method = "85D89754B0983A44CEDEEC2CF2B4E2A8", hash_generated_method = "C73465826B349730C517E1974E973F03")
    public Object clone() {
        PAssociatedURIList retval = new PAssociatedURIList();
Object varF627329B9209466293A1BF71D9AF7B2B_673372361 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_673372361.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_673372361;
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.936 -0400", hash_original_field = "F2A09E90533068AD94F7E1B321852ACA", hash_generated_field = "E2DA2BC3F02BE9493383780AA95C2103")

    private static final long serialVersionUID = 4454306052557362851L;
}

