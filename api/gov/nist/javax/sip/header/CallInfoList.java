package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class CallInfoList extends SIPHeaderList<CallInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.144 -0400", hash_original_method = "ED4F99F21CB3236766303F800D1CCEF7", hash_generated_method = "D2020F1988EEA6AAE4D1E2BFFF584D3E")
    public  CallInfoList() {
        super(CallInfo.class, CallInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.144 -0400", hash_original_method = "95B657F1A1F55E6349A24A49AE286459", hash_generated_method = "A515F2BB365CEEA13290B54629653059")
    public Object clone() {
        CallInfoList retval = new CallInfoList ();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1829177824 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1829177824.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1829177824;
        // ---------- Original Method ----------
        //CallInfoList retval = new CallInfoList ();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.144 -0400", hash_original_field = "DE847272D55EC344DA2971AC1B9E57F0", hash_generated_field = "40CDC5D99109F77F75DE1AE9F98BF26C")

    private static final long serialVersionUID = -4949850334388806423L;
}

