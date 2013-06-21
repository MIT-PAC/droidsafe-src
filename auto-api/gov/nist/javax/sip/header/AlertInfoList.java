package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.660 -0400", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "1454CC4C294B31424367C5E69A11C07E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.661 -0400", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "78BBAF4CCD56424B99EDD4CEC8B7021F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        AlertInfoList retval;
        retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AlertInfoList retval = new AlertInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1L;
}

