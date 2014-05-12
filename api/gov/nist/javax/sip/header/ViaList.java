package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import javax.sip.header.ViaHeader;

public final class ViaList extends SIPHeaderList<Via> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.023 -0500", hash_original_field = "4A03234F17287307C9B5B5561F2B9445", hash_generated_field = "062CEB967E0E9232630ABE83F99100E4")

    private static final long serialVersionUID = 3899679374556152313L;
    /**
     * Default Constructor.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.029 -0500", hash_original_method = "810E0ED8E1E79C548735B6B2AD5FE1B8", hash_generated_method = "E83AD57AD176D7E48D87236C889B7FDF")
    
public ViaList() {
        super(Via.class, ViaHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:03.026 -0500", hash_original_method = "4D93C8A8DA65DDEDB364A162E5648CA9", hash_generated_method = "D13000004744A9F69B1F7560879B664D")
    
public Object clone() {
        ViaList retval = new ViaList();
        return retval.clonehlist(this.hlist);
    }
}

