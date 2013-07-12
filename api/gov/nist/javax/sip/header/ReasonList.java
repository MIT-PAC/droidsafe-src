package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.List;
import javax.sip.header.*;

public final class ReasonList extends SIPHeaderList<Reason> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.811 -0400", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "60E83E51B1F3EDD817C21DE6C510D11F")
    public  ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.812 -0400", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "01C98DA5061D6CDBCBE8038B138DBAF1")
    public Object clone() {
        ReasonList retval = new ReasonList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1404982162 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1404982162.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1404982162;
        // ---------- Original Method ----------
        //ReasonList retval = new ReasonList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.812 -0400", hash_original_field = "B6A406B5E7178CCF4C59015C0B462D39", hash_generated_field = "FD49800BA978856F432C3A45BC93C56C")

    private static final long serialVersionUID = 7459989997463160670L;
}

