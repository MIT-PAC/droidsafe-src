package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.UnsupportedHeader;

public class UnsupportedList extends SIPHeaderList<Unsupported> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.915 -0500", hash_original_field = "349125D0D735C0B36640E4A3981AFE9E", hash_generated_field = "127841856DFEDCF98BA424B546FA09BC")

    private static final long serialVersionUID = -4052610269407058661L;

    /** Default Constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.919 -0500", hash_original_method = "CBBAF1558631750DDBDF9DAEDB7A572C", hash_generated_method = "E4BA823E78F552EE56C402AD3022B220")
    
public UnsupportedList() {
        super(Unsupported.class, UnsupportedHeader.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.921 -0500", hash_original_method = "586FD49C37A8AA9D6CC092649E8819BF", hash_generated_method = "F69B5C0382BBC6ED2C3C331501831857")
    
public Object clone() {
        UnsupportedList retval = new UnsupportedList();
        return retval.clonehlist(this.hlist);
    }
}

