package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.List;
import javax.sip.header.*;

public final class ReasonList extends SIPHeaderList<Reason> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.996 -0400", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "60E83E51B1F3EDD817C21DE6C510D11F")
    public  ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.997 -0400", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "8992BC96C09E51E364F36F290D8D0494")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1618307549 = null; //Variable for return #1
        ReasonList retval = new ReasonList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_1618307549 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1618307549.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1618307549;
        // ---------- Original Method ----------
        //ReasonList retval = new ReasonList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:39.997 -0400", hash_original_field = "B6A406B5E7178CCF4C59015C0B462D39", hash_generated_field = "FD49800BA978856F432C3A45BC93C56C")

    private static final long serialVersionUID = 7459989997463160670L;
}

