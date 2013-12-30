package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class PMediaAuthorizationList extends SIPHeaderList<PMediaAuthorization> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.110 -0500", hash_original_field = "03273C2C995311E1D0CBF34F16486D3F", hash_generated_field = "6DAAF304C43D28C53E4D1DB9B0DF566E")

    private static final long serialVersionUID = -8226328073989632317L;


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.114 -0500", hash_original_method = "656C497A7A9D2E8465BD84DF21BD0C00", hash_generated_method = "F8DEC75DC17D6818020593F8B4A599D2")
    
public PMediaAuthorizationList()
    {
        super(PMediaAuthorization.class, PMediaAuthorizationHeader.NAME);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:57.117 -0500", hash_original_method = "535B60F78292A563EBB4CD53A0D5E752", hash_generated_method = "25E2FD42224B9CE87E159FD25A84990F")
    
public Object clone() {
        PMediaAuthorizationList retval = new PMediaAuthorizationList();
        return retval.clonehlist(this.hlist);
    }
}

