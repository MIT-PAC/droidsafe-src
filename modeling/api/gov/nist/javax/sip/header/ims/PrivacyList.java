package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PrivacyList extends SIPHeaderList<Privacy> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.774 -0500", hash_original_field = "D16CF8567B5F4707FC1292B366988C3D", hash_generated_field = "2DADF4F7F0061239917C97DB089D6111")

    private static final long serialVersionUID = 1798720509806307461L;

    /**
     * Default constructor
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.777 -0500", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "DC64B9842C90DC26CE7FE452F14FE478")
    
public PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:58.780 -0500", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "2CB46F21CA1EC882462A859CCDB14DC5")
    
public Object clone() {
        PrivacyList retval = new PrivacyList();
        return retval.clonehlist(this.hlist);
    }
}

