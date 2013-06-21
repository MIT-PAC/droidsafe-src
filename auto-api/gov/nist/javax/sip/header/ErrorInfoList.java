package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.924 -0400", hash_original_method = "BE8380000E3CB2DA0A370B790F9454ED", hash_generated_method = "314469C48167DD93726734246BAB2F4B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ErrorInfoList() {
        super(ErrorInfo.class, ErrorInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.924 -0400", hash_original_method = "DEBEF33CFB4944E55BD5A9FB315B228C", hash_generated_method = "5111F12F7859E7982B0515DE916A118F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ErrorInfoList retval;
        retval = new ErrorInfoList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ErrorInfoList retval = new ErrorInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1L;
}

