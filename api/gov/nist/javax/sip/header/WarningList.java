package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class WarningList extends SIPHeaderList<Warning> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.531 -0500", hash_original_field = "9E25FFFCE541C6A5AF3A6BB5686A4CB8", hash_generated_field = "546B02DCE7471BB4B665A16CFACDC783")

    private static final long serialVersionUID = -1423278728898430175L;
    /**
     * Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.537 -0500", hash_original_method = "8098AC8A06CDB819C465A9D30CC2E5BB", hash_generated_method = "9A9C483885958DD0B2EF686698AB11CB")
    
public WarningList() {
        super(Warning.class, Warning.NAME);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.533 -0500", hash_original_method = "266F52C906228C3D1DC5D5C7E03D3C84", hash_generated_method = "779799A7CDBBD321B260B7EACF0181CB")
    
public Object clone() {
        WarningList retval = new WarningList();
        return retval.clonehlist(this.hlist);
    }
}

