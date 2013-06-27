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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.263 -0400", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "60E83E51B1F3EDD817C21DE6C510D11F")
    public  ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.264 -0400", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "10223D95BE9098C2F1F5A0B94C250817")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_243223465 = null; //Variable for return #1
        ReasonList retval;
        retval = new ReasonList();
        retval.clonehlist(this.hlist);
        varB4EAC82CA7396A68D541C85D26508E83_243223465 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_243223465.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_243223465;
        // ---------- Original Method ----------
        //ReasonList retval = new ReasonList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.264 -0400", hash_original_field = "B6A406B5E7178CCF4C59015C0B462D39", hash_generated_field = "FF34BD236E246432FA1F85F0CBC62BBF")

    private static long serialVersionUID = 7459989997463160670L;
}

