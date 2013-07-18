package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.header.ProxyAuthorizationHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.751 -0400", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "13BE6CAE5E4586734CD6519D7633A9B2")
    public  ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.752 -0400", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "CE4CB0E8A4EC5E2C2764769FCDAE83A4")
    public Object clone() {
        ProxyAuthorizationList retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_920140332 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_920140332.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_920140332;
        // ---------- Original Method ----------
        //ProxyAuthorizationList retval = new ProxyAuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.752 -0400", hash_original_field = "E460F7E4ADA0B134B90E3C7ACE044BAF", hash_generated_field = "EC74D7B41C3C9002F8FE992882CA7626")

    private static final long serialVersionUID = -1L;
}

