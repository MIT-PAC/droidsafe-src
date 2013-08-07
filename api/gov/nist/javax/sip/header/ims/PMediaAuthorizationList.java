package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class PMediaAuthorizationList extends SIPHeaderList<PMediaAuthorization> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.209 -0400", hash_original_method = "656C497A7A9D2E8465BD84DF21BD0C00", hash_generated_method = "9BCAC9929D32D2F555BF0B2B59C10BB5")
    public  PMediaAuthorizationList() {
        super(PMediaAuthorization.class, PMediaAuthorizationHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.210 -0400", hash_original_method = "535B60F78292A563EBB4CD53A0D5E752", hash_generated_method = "D0FBE052A5664005DAE346ABC8AB4110")
    public Object clone() {
        PMediaAuthorizationList retval = new PMediaAuthorizationList();
Object varF627329B9209466293A1BF71D9AF7B2B_1975929538 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1975929538.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1975929538;
        // ---------- Original Method ----------
        //PMediaAuthorizationList retval = new PMediaAuthorizationList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.210 -0400", hash_original_field = "29812CDE5546F301183126FFBF7F26AC", hash_generated_field = "6DAAF304C43D28C53E4D1DB9B0DF566E")

    private static final long serialVersionUID = -8226328073989632317L;
}

