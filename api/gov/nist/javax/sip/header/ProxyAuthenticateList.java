package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class ProxyAuthenticateList extends SIPHeaderList<ProxyAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.724 -0400", hash_original_method = "57E0FF9724534118B460C05E52A5FB72", hash_generated_method = "E5AD5AA5CA84C69837EF7825C288CAEA")
    public  ProxyAuthenticateList() {
        super(ProxyAuthenticate.class, ProxyAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.725 -0400", hash_original_method = "ECB851A15E7FFD0CBDE6FF3F7172E98C", hash_generated_method = "2A1898FD97FEAD81C8017A9C31E7EECA")
    public Object clone() {
        ProxyAuthenticateList retval = new ProxyAuthenticateList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_2040405253 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2040405253.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2040405253;
        // ---------- Original Method ----------
        //ProxyAuthenticateList retval = new ProxyAuthenticateList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.725 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

