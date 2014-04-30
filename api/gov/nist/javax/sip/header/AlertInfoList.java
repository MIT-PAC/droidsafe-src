package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.AlertInfoHeader;

public class AlertInfoList extends SIPHeaderList<AlertInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.291 -0500", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;

        /** default constructor
         */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.297 -0500", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "F7D1194D3067B7CCAD9F937A41092CB8")
    
public AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.294 -0500", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "9A98783C85E70A790A214AC2CA269F21")
    
public Object clone() {
        AlertInfoList retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

