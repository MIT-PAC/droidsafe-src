package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import  javax.sip.header.*;

public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.656 -0400", hash_original_method = "5D0C93082A28C4F76AC90901A48C6BD1", hash_generated_method = "6035EA6C915C1EC737CCB1ED8A829814")
    public  WWWAuthenticateList() {
        super(WWWAuthenticate.class, WWWAuthenticateHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.657 -0400", hash_original_method = "CD4D2DBD74BB3BE1B1C2856EF354DA52", hash_generated_method = "4BF7D571E1AD5C4638A2BD5C9DF5F24E")
    public Object clone() {
        WWWAuthenticateList retval = new WWWAuthenticateList();
Object varF627329B9209466293A1BF71D9AF7B2B_2059170955 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_2059170955.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_2059170955;
        // ---------- Original Method ----------
        //WWWAuthenticateList retval = new WWWAuthenticateList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.657 -0400", hash_original_field = "1E01E6607AEE257B1EA82D4E79E39A88", hash_generated_field = "DAEA8AA6BFFB39A4E5CCB1F3F4CC7E4D")

    private static final long serialVersionUID = -6978902284285501346L;
}

