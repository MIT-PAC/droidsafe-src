package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ReasonHeader;






public final class ReasonList extends SIPHeaderList<Reason> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.727 -0500", hash_original_field = "8918B1E3D10B5236FBAB9B43C5674881", hash_generated_field = "FD49800BA978856F432C3A45BC93C56C")


    private static final long serialVersionUID = 7459989997463160670L;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.734 -0500", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "082DDDE38FA0993132CBFB628B6168CA")
    
public ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:05.731 -0500", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "0440A327426C593E3C3523D102C09D64")
    
public Object clone() {
        ReasonList retval = new ReasonList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

