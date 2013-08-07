package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.RequireHeader;






public final class RequireList extends SIPHeaderList<Require> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.936 -0400", hash_original_method = "7F18EBBB41892DE4ABBAD1AE9000FBF7", hash_generated_method = "36D9A361FAF93C191230D023E2D39CA4")
    public  RequireList() {
        super(Require.class, RequireHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.936 -0400", hash_original_method = "4C9D6FE7DF8BFD06BB544C2582BF8758", hash_generated_method = "5A88934468497BE7B778E426E2C03916")
    public Object clone() {
        RequireList retval = new RequireList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_166795624 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_166795624.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_166795624;
        // ---------- Original Method ----------
        //RequireList retval = new RequireList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.936 -0400", hash_original_field = "8080C96575DEF2E403CA5D4337270376", hash_generated_field = "5974674B2811E6A05BEB42772D3F9734")

    private static final long serialVersionUID = -1760629092046963213L;
}

