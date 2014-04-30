package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.InReplyToHeader;

public final class InReplyToList extends SIPHeaderList<InReplyTo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.845 -0500", hash_original_field = "41DD4C19AF483E8B689925740477D1F5", hash_generated_field = "A3E5ABCB1257722D07C0C4A7F8ADE615")

    private static final long serialVersionUID = -7993498496830999237L;

    /** Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.851 -0500", hash_original_method = "352B2862B115206F092911A984BAE33E", hash_generated_method = "0A598722299A5B709794ED0B11F085BA")
    
public InReplyToList() {
        super(InReplyTo.class, InReplyToHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:01.848 -0500", hash_original_method = "DCD4BD1433043890DC84CD67AE62360B", hash_generated_method = "2BAB5C8EDECEE9EE44AAE05EBACC5F58")
    
public Object clone() {
        InReplyToList retval = new InReplyToList();
        retval.clonehlist(this.hlist);
        return retval;
    }
}

