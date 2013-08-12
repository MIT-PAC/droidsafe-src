package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class PAssertedIdentityList extends SIPHeaderList<PAssertedIdentity> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.051 -0400", hash_original_method = "7B547E5D989DEE32A91F605E4D8F2A3B", hash_generated_method = "73CBFC9BA880055E577FD55BB3BE4139")
    public  PAssertedIdentityList() {
        super(PAssertedIdentity.class, PAssertedIdentityHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.057 -0400", hash_original_method = "5563A5DB4245DEBD4AD09019D9E2D95D", hash_generated_method = "FEDC02B5C4874F717829704DAFDDAF05")
    public Object clone() {
        PAssertedIdentityList retval = new PAssertedIdentityList();
Object varF627329B9209466293A1BF71D9AF7B2B_749698646 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_749698646.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_749698646;
        // ---------- Original Method ----------
        //PAssertedIdentityList retval = new PAssertedIdentityList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.059 -0400", hash_original_field = "52A118C1067FA0A9582F70AC166701CF", hash_generated_field = "327B462110ED9334DAFBBBFBC39902B6")

    private static final long serialVersionUID = -6465152445570308974L;
}

