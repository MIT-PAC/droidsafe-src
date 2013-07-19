package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class AuthorizationList extends SIPHeaderList<Authorization> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.056 -0400", hash_original_method = "84C7F0569F21A5F411F5E14C38C62885", hash_generated_method = "F63A8C57CD2EBABA71B55FD2B076BBC7")
    public  AuthorizationList() {
        super(Authorization.class, Authorization.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.056 -0400", hash_original_method = "81792A8EF4604C1C9CC7309BCA2D7523", hash_generated_method = "CFAD13DBA0136A1E0B49EB887C20AF5F")
    public Object clone() {
        AuthorizationList retval = new AuthorizationList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1193146677 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1193146677.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1193146677;
        // ---------- Original Method ----------
        //AuthorizationList retval = new AuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.056 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

