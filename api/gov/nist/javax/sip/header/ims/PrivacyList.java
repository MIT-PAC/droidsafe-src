package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.SIPHeaderList;

public class PrivacyList extends SIPHeaderList<Privacy> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.150 -0400", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "1112F36E1D63D8A6DB0A3433FC13B944")
    public  PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.150 -0400", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "F79A545396B0AADA6215E5D51EF01707")
    public Object clone() {
        PrivacyList retval = new PrivacyList();
Object varF627329B9209466293A1BF71D9AF7B2B_50042725 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_50042725.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_50042725;
        // ---------- Original Method ----------
        //PrivacyList retval = new PrivacyList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:38.150 -0400", hash_original_field = "C0CA76C219951888324430E8E7118357", hash_generated_field = "2DADF4F7F0061239917C97DB089D6111")

    private static final long serialVersionUID = 1798720509806307461L;
}

