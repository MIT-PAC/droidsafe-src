package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class ProxyRequireList extends SIPHeaderList<ProxyRequire> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.086 -0400", hash_original_method = "029C98C6EA119F5ED189F5C1632A9558", hash_generated_method = "2056F217F92BE2216FB0A4CD03CA3055")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ProxyRequireList() {
        super(ProxyRequire.class, ProxyRequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.087 -0400", hash_original_method = "013E28988AF93ED240675D60306569D5", hash_generated_method = "C64A5C71C894FA00C6F4170B8D568D61")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ProxyRequireList retval;
        retval = new ProxyRequireList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ProxyRequireList retval = new ProxyRequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 5648630649476486042L;
}

