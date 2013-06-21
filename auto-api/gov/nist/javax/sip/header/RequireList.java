package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class RequireList extends SIPHeaderList<Require> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.153 -0400", hash_original_method = "7F18EBBB41892DE4ABBAD1AE9000FBF7", hash_generated_method = "36D9A361FAF93C191230D023E2D39CA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RequireList() {
        super(Require.class, RequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.154 -0400", hash_original_method = "4C9D6FE7DF8BFD06BB544C2582BF8758", hash_generated_method = "CFC3B4CD186E5EBF93F3355F6FFDB9EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        RequireList retval;
        retval = new RequireList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RequireList retval = new RequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -1760629092046963213L;
}

