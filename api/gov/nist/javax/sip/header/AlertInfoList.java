package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.AlertInfoHeader;






public class AlertInfoList extends SIPHeaderList<AlertInfo> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.727 -0400", hash_original_method = "A08E8746373CA778814FF59876F6CC5B", hash_generated_method = "1454CC4C294B31424367C5E69A11C07E")
    public  AlertInfoList() {
        super( AlertInfo.class,AlertInfoHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.728 -0400", hash_original_method = "DA21929F9B4B968B70B27DDE76B9FF23", hash_generated_method = "E959AF3B97699205D15D24154266B00D")
    public Object clone() {
        AlertInfoList retval = new AlertInfoList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1781697784 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1781697784.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1781697784;
        // ---------- Original Method ----------
        //AlertInfoList retval = new AlertInfoList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:32.728 -0400", hash_original_field = "0B32F171B7F0DF451D414BE461B5698C", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
}

