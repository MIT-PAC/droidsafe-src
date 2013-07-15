package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;

public class AcceptEncodingList extends SIPHeaderList<AcceptEncoding> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.660 -0400", hash_original_method = "6872E94CB9CC14DAB89517B2FDF048F7", hash_generated_method = "8D77967938F665982D2EA5AC5A044ED3")
    public  AcceptEncodingList() {
        super(AcceptEncoding.class, AcceptEncodingHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:35.660 -0400", hash_original_method = "39DF8810A78ACD57DE26FFD5511EC56E", hash_generated_method = "C5A28913E82BBC9EEB48F93768962F87")
    @Override
    public Object clone() {
        AcceptEncodingList retval = new AcceptEncodingList();
        retval.clonehlist(this.hlist);
Object varF9E19AD6135C970F387F77C6F3DE4477_1251017051 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1251017051.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1251017051;
        // ---------- Original Method ----------
        //AcceptEncodingList retval = new AcceptEncodingList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
}

