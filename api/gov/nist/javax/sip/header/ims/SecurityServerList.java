package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeaderList;



public class SecurityServerList extends SIPHeaderList<SecurityServer> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.479 -0400", hash_original_method = "DDC555D009CE8B153DA6D33D8F867563", hash_generated_method = "744A6F9CF502C67EBD2705F91696A76E")
    public  SecurityServerList() {
        super(SecurityServer.class, SecurityServerHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.479 -0400", hash_original_method = "DB9A46F7231A313671C09010ADA9A7C3", hash_generated_method = "0A271D267BB0A736EA53F2D5614C5C4F")
    public Object clone() {
        SecurityServerList retval = new SecurityServerList();
Object varF627329B9209466293A1BF71D9AF7B2B_1051742832 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1051742832.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1051742832;
        // ---------- Original Method ----------
        //SecurityServerList retval = new SecurityServerList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:35.480 -0400", hash_original_field = "DA5AA60986249AC34031EC85612912C9", hash_generated_field = "FA2EA3141868868D79B17D55AFCB33DF")

    private static final long serialVersionUID = -1392066520803180238L;
}

