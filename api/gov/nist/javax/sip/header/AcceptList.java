package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.AcceptHeader;






public class AcceptList extends SIPHeaderList<Accept> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.687 -0400", hash_original_method = "51B5F4325CF7E310BAF41022AF7E4824", hash_generated_method = "70A657851AA3A54A657243AA76937424")
    public  AcceptList() {
        super(Accept.class, AcceptHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.687 -0400", hash_original_method = "3C553A191FB2DA2F431571F69D6628C7", hash_generated_method = "502A10A59F1C757B73E063D6B74F22FA")
    @Override
    public Object clone() {
        AcceptList retval = new AcceptList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1666499799 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1666499799.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1666499799;
        // ---------- Original Method ----------
        //AcceptList retval = new AcceptList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.687 -0400", hash_original_field = "8560220F20AFBF56AD0369D138528219", hash_generated_field = "B64F155B1415D0AC54A9E69071A95C83")

    private static final long serialVersionUID = -1800813338560484831L;
}

