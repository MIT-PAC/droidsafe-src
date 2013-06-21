package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class CallInfoList extends SIPHeaderList<CallInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.858 -0400", hash_original_method = "ED4F99F21CB3236766303F800D1CCEF7", hash_generated_method = "D2020F1988EEA6AAE4D1E2BFFF584D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CallInfoList() {
        super(CallInfo.class, CallInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.858 -0400", hash_original_method = "95B657F1A1F55E6349A24A49AE286459", hash_generated_method = "01A94020099E1A8D7678893F5BD2FBC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        CallInfoList retval;
        retval = new CallInfoList ();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //CallInfoList retval = new CallInfoList ();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -4949850334388806423L;
}

