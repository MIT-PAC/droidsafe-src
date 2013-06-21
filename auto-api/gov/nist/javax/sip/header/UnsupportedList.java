package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.Iterator;
import javax.sip.header.*;

public class UnsupportedList extends SIPHeaderList<Unsupported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.447 -0400", hash_original_method = "CBBAF1558631750DDBDF9DAEDB7A572C", hash_generated_method = "8F7A7A782386B52882B87C6BD42B708B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UnsupportedList() {
        super(Unsupported.class, UnsupportedHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.447 -0400", hash_original_method = "586FD49C37A8AA9D6CC092649E8819BF", hash_generated_method = "3781B9483B78F3D9613A02A0C5339C10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        UnsupportedList retval;
        retval = new UnsupportedList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_342384130 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UnsupportedList retval = new UnsupportedList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -4052610269407058661L;
}

