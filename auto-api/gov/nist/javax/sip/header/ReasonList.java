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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.105 -0400", hash_original_method = "5579E067F388468CFB2A3241EC57C70E", hash_generated_method = "60E83E51B1F3EDD817C21DE6C510D11F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ReasonList() {
        super(Reason.class, ReasonHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.105 -0400", hash_original_method = "10E04C2C3285E2CE8B0D90EBF75B8FBF", hash_generated_method = "0A98E775EDB2FE0DB291A08769C67689")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ReasonList retval;
        retval = new ReasonList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ReasonList retval = new ReasonList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 7459989997463160670L;
}

