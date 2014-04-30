package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.CallInfoHeader;

public class CallInfoList extends SIPHeaderList<CallInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.732 -0500", hash_original_field = "696068A02A7EBA6238E6DD6749A028D3", hash_generated_field = "40CDC5D99109F77F75DE1AE9F98BF26C")

    private static final long serialVersionUID = -4949850334388806423L;
    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.741 -0500", hash_original_method = "ED4F99F21CB3236766303F800D1CCEF7", hash_generated_method = "D70492DBDBF8B958E95F3818F2E06C24")
    
public CallInfoList() {
        super(CallInfo.class, CallInfoHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:52.736 -0500", hash_original_method = "95B657F1A1F55E6349A24A49AE286459", hash_generated_method = "E53DACF95B1EB9EC1A29480796C01A37")
    
public Object clone() {
        CallInfoList retval = new CallInfoList ();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

