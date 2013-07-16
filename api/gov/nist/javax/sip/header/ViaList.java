package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.header.*;
import java.util.Iterator;

public final class ViaList extends SIPHeaderList<Via> {
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.645 -0400", hash_original_method = "810E0ED8E1E79C548735B6B2AD5FE1B8", hash_generated_method = "075F5CC46E50FEE2ED5E752A18746683")
    public  ViaList() {
        super(Via.class, ViaHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.645 -0400", hash_original_method = "4D93C8A8DA65DDEDB364A162E5648CA9", hash_generated_method = "80C000814768D757581C0169D6DD5DFA")
    public Object clone() {
        ViaList retval = new ViaList();
Object varF627329B9209466293A1BF71D9AF7B2B_1121052476 =         retval.clonehlist(this.hlist);
        varF627329B9209466293A1BF71D9AF7B2B_1121052476.addTaint(taint);
        return varF627329B9209466293A1BF71D9AF7B2B_1121052476;
        // ---------- Original Method ----------
        //ViaList retval = new ViaList();
        //return retval.clonehlist(this.hlist);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.645 -0400", hash_original_field = "3ECBF1E8B8DA1501F382FF3D98D84F4A", hash_generated_field = "062CEB967E0E9232630ABE83F99100E4")

    private static final long serialVersionUID = 3899679374556152313L;
}

