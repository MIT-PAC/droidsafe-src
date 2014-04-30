package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PAssociatedURIList extends SIPHeaderList<PAssociatedURI> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.334 -0500", hash_original_field = "96A20B89FD20299C3DC727EF19B37D5B", hash_generated_field = "E2DA2BC3F02BE9493383780AA95C2103")

    private static final long serialVersionUID = 4454306052557362851L;

    /**
     * constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.337 -0500", hash_original_method = "4F3C386FF0DD7CB0697F371A75488EC2", hash_generated_method = "438D06F9D4E2831695A5088457D7A07C")
    
public PAssociatedURIList()
    {
        super(PAssociatedURI.class, PAssociatedURI.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.341 -0500", hash_original_method = "85D89754B0983A44CEDEEC2CF2B4E2A8", hash_generated_method = "2DBE13DD982E02D8C325965950E49B11")
    
public Object clone() {
        PAssociatedURIList retval = new PAssociatedURIList();
        return retval.clonehlist(this.hlist);
    }
}

