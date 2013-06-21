package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import  javax.sip.header.*;

public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.486 -0400", hash_original_method = "5D0C93082A28C4F76AC90901A48C6BD1", hash_generated_method = "6035EA6C915C1EC737CCB1ED8A829814")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WWWAuthenticateList() {
        super(WWWAuthenticate.class, WWWAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.486 -0400", hash_original_method = "CD4D2DBD74BB3BE1B1C2856EF354DA52", hash_generated_method = "715E626356848B20D4CA9009B30B7D7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        WWWAuthenticateList retval;
        retval = new WWWAuthenticateList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1559354873 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //WWWAuthenticateList retval = new WWWAuthenticateList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = -6978902284285501346L;
}

