package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.RequireHeader;






public final class RequireList extends SIPHeaderList<Require> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.006 -0500", hash_original_field = "3DEB8F0B84A8E7B5BEA7A703684C24A2", hash_generated_field = "5974674B2811E6A05BEB42772D3F9734")



    private static final long serialVersionUID = -1760629092046963213L;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.008 -0500", hash_original_method = "7F18EBBB41892DE4ABBAD1AE9000FBF7", hash_generated_method = "64F0CE0BD7D3F7FBB93F2AF2B4B80E46")
    public RequireList() {
        super(Require.class, RequireHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.007 -0500", hash_original_method = "4C9D6FE7DF8BFD06BB544C2582BF8758", hash_generated_method = "86BAA05A4045A31EF70AAA68505D2DBC")
    public Object clone() {
        RequireList retval = new RequireList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

