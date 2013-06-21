package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class WarningList extends SIPHeaderList<Warning> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.493 -0400", hash_original_method = "8098AC8A06CDB819C465A9D30CC2E5BB", hash_generated_method = "62F1F7BE0861080B87B988F0A42FF4AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WarningList() {
        super(Warning.class, Warning.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.493 -0400", hash_original_method = "266F52C906228C3D1DC5D5C7E03D3C84", hash_generated_method = "2FD5603ED1153D88E4F1B736FD9912B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        WarningList retval;
        retval = new WarningList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1106362083 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WarningList retval = new WarningList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -1423278728898430175L;
}

