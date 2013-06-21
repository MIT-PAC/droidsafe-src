package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.006 -0400", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "52313BE3C7A7A4FFFFF799BC507758A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.006 -0400", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "84C39E4993A5E714D4259847DCCBDB6C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        InReplyToList retval;
        retval = new InReplyToList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //InReplyToList retval = new InReplyToList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -7993498496830999237L;
}

