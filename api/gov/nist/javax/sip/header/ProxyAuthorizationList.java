package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class ProxyAuthorizationList extends SIPHeaderList<ProxyAuthorization> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.739 -0400", hash_original_method = "7E2339716E9E591A456966370DA5C67A", hash_generated_method = "13BE6CAE5E4586734CD6519D7633A9B2")
    public  ProxyAuthorizationList() {
        super(ProxyAuthorization.class, ProxyAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.740 -0400", hash_original_method = "99D8471E873632F99CA4FA915EADF5BB", hash_generated_method = "533BC27A5D12B05D8F656EFAA4A10D06")
    public Object clone() {
        ProxyAuthorizationList retval = new ProxyAuthorizationList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1384925962 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1384925962.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1384925962;
        // ---------- Original Method ----------
        //ProxyAuthorizationList retval = new ProxyAuthorizationList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.740 -0400", hash_original_field = "E460F7E4ADA0B134B90E3C7ACE044BAF", hash_generated_field = "EC74D7B41C3C9002F8FE992882CA7626")

    private static final long serialVersionUID = -1L;
}

