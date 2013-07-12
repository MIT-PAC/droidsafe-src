package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class AcceptList extends SIPHeaderList<Accept> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.697 -0400", hash_original_method = "51B5F4325CF7E310BAF41022AF7E4824", hash_generated_method = "70A657851AA3A54A657243AA76937424")
    public  AcceptList() {
        super(Accept.class, AcceptHeader.NAME);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.698 -0400", hash_original_method = "3C553A191FB2DA2F431571F69D6628C7", hash_generated_method = "FD52063B1A4A3B6BFC800B388AA92022")
    @Override
    public Object clone() {
        AcceptList retval = new AcceptList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1431534681 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1431534681.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1431534681;
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.698 -0400", hash_original_field = "8560220F20AFBF56AD0369D138528219", hash_generated_field = "B64F155B1415D0AC54A9E69071A95C83")

    private static final long serialVersionUID = -1800813338560484831L;
}

