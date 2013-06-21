package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.util.Iterator;

public final class ViaList extends SIPHeaderList<Via> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.482 -0400", hash_original_method = "810E0ED8E1E79C548735B6B2AD5FE1B8", hash_generated_method = "075F5CC46E50FEE2ED5E752A18746683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ViaList() {
        super(Via.class, ViaHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.482 -0400", hash_original_method = "4D93C8A8DA65DDEDB364A162E5648CA9", hash_generated_method = "D671EEF8B796646AEC876506F268A56F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        ViaList retval;
        retval = new ViaList();
        Object varF7AD6DD8E2D0A0D86D7DC6EABC62B125_1847470427 = (retval.clonehlist(this.hlist));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ViaList retval = new ViaList();
        //return retval.clonehlist(this.hlist);
    }

    
    private static final long serialVersionUID = 3899679374556152313L;
}

