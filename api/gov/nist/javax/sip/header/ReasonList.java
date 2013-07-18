package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.header.ReasonHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class ReasonList extends SIPHeaderList<Reason> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.829 -0400", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "60E83E51B1F3EDD817C21DE6C510D11F")
    public  ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.830 -0400", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "E4DCF8334B52726011724FB67C34303D")
    public Object clone() {
        ReasonList retval = new ReasonList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1124599117 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1124599117.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1124599117;
        // ---------- Original Method ----------
        //ReasonList retval = new ReasonList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.830 -0400", hash_original_field = "B6A406B5E7178CCF4C59015C0B462D39", hash_generated_field = "FD49800BA978856F432C3A45BC93C56C")

    private static final long serialVersionUID = 7459989997463160670L;
}

