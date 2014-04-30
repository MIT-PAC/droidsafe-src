package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.WWWAuthenticateHeader;

public class WWWAuthenticateList extends SIPHeaderList<WWWAuthenticate> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.601 -0500", hash_original_field = "EFDF7C1043E85214A01AD205D7485752", hash_generated_field = "DAEA8AA6BFFB39A4E5CCB1F3F4CC7E4D")

    private static final long serialVersionUID = -6978902284285501346L;
    /**
     * constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.608 -0500", hash_original_method = "5D0C93082A28C4F76AC90901A48C6BD1", hash_generated_method = "3F5AE67C3B0BEB7E37D821503D8BCC9E")
    
public WWWAuthenticateList() {
        super(WWWAuthenticate.class, WWWAuthenticateHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:00.604 -0500", hash_original_method = "CD4D2DBD74BB3BE1B1C2856EF354DA52", hash_generated_method = "40ECC57638E12ABD9C42A703737D2FBF")
    
public Object clone() {
        WWWAuthenticateList retval = new WWWAuthenticateList();
        return retval.clonehlist(this.hlist);
    }
}

