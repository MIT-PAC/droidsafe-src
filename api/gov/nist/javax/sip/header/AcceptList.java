package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.AcceptHeader;






public class AcceptList extends SIPHeaderList<Accept> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.157 -0500", hash_original_field = "C61EC703D8A7A3917185EDDEEA8CEF11", hash_generated_field = "B64F155B1415D0AC54A9E69071A95C83")

    private static final long serialVersionUID = -1800813338560484831L;
    /**
     * Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.159 -0500", hash_original_method = "51B5F4325CF7E310BAF41022AF7E4824", hash_generated_method = "96BD397756DDEB5AA68DD348EB765748")
    public AcceptList() {
        super(Accept.class, AcceptHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:44:51.158 -0500", hash_original_method = "3C553A191FB2DA2F431571F69D6628C7", hash_generated_method = "565CDA55B83947CB87D8FF4CAE06E754")
    @Override
public Object clone() {
        AcceptList retval = new AcceptList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

