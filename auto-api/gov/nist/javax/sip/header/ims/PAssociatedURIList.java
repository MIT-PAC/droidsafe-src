package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.227 -0400", hash_original_method = "4F3C386FF0DD7CB0697F371A75488EC2", hash_generated_method = "35867964AE38FD2D92EA7E427B86E224")
    public  PAssociatedURIList() {
        super(PAssociatedURI.class, PAssociatedURI.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.228 -0400", hash_original_method = "85D89754B0983A44CEDEEC2CF2B4E2A8", hash_generated_method = "2CE6B3FDE4F0D1CE5F00D21487965CE2")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_770828435 = null; //Variable for return #1
        PAssociatedURIList retval = new PAssociatedURIList();
        varB4EAC82CA7396A68D541C85D26508E83_770828435 = retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_770828435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_770828435;
        // ---------- Original Method ----------
        //PAssociatedURIList retval = new PAssociatedURIList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.228 -0400", hash_original_field = "F2A09E90533068AD94F7E1B321852ACA", hash_generated_field = "E2DA2BC3F02BE9493383780AA95C2103")

    private static final long serialVersionUID = 4454306052557362851L;
}

