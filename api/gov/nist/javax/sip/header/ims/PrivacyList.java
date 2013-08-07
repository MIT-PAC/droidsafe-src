package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class PrivacyList extends SIPHeaderList<Privacy> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.392 -0400", hash_original_method = "45F84AF986B8E1D18781B003920274BC", hash_generated_method = "1112F36E1D63D8A6DB0A3433FC13B944")
    public  PrivacyList() {
        super(Privacy.class, PrivacyHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.392 -0400", hash_original_method = "09C54AFDDBF31F8225613CB28A3AFCA3", hash_generated_method = "567CB183A20847E31C5C72DC3280CD3B")
    public Object clone() {
        PrivacyList retval = new PrivacyList();
Object varF627329B9209466293A1BF71D9AF7B2B_507830504 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_507830504.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_507830504;
        // ---------- Original Method ----------
        //PrivacyList retval = new PrivacyList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.393 -0400", hash_original_field = "C0CA76C219951888324430E8E7118357", hash_generated_field = "2DADF4F7F0061239917C97DB089D6111")

    private static final long serialVersionUID = 1798720509806307461L;
}

