package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.header.RecordRouteHeader;






public class RecordRouteList extends SIPHeaderList<RecordRoute> {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.846 -0400", hash_original_method = "7184B4196316005943D81815B77BA6D1", hash_generated_method = "A09A2763146C97B1F662605DF0ED92C3")
    public  RecordRouteList() {
        super(RecordRoute.class, RecordRouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.846 -0400", hash_original_method = "7817AF16B5252B16AA7B12BAE88CFC40", hash_generated_method = "F4E10E2D2581CD493A9C2CF4352F91E8")
    public Object clone() {
        RecordRouteList retval = new RecordRouteList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_127293260 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_127293260.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_127293260;
        // ---------- Original Method ----------
        //RecordRouteList retval = new RecordRouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.846 -0400", hash_original_field = "3F3F267B538FC1595859DA217FDED7CD", hash_generated_field = "44C63522FD239381EAF8817DE94BC086")

    private static final long serialVersionUID = 1724940469426766691L;
}

