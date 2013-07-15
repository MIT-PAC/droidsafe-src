package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class ErrorInfoList extends SIPHeaderList<ErrorInfo> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.342 -0400", hash_original_method = "BE8380000E3CB2DA0A370B790F9454ED", hash_generated_method = "314469C48167DD93726734246BAB2F4B")
    public  ErrorInfoList() {
        super(ErrorInfo.class, ErrorInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.342 -0400", hash_original_method = "DEBEF33CFB4944E55BD5A9FB315B228C", hash_generated_method = "CB4DCFF8642710107ADC69494DD55AD9")
    public Object clone() {
        ErrorInfoList retval = new ErrorInfoList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1165404506 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1165404506.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1165404506;
        // ---------- Original Method ----------
        //ErrorInfoList retval = new ErrorInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.343 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

