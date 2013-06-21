package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class RecordRouteList extends SIPHeaderList<RecordRoute> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.109 -0400", hash_original_method = "7184B4196316005943D81815B77BA6D1", hash_generated_method = "A09A2763146C97B1F662605DF0ED92C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RecordRouteList() {
        super(RecordRoute.class, RecordRouteHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.109 -0400", hash_original_method = "7817AF16B5252B16AA7B12BAE88CFC40", hash_generated_method = "E0DF4843B8E3E23776DA64A8AD43B178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        RecordRouteList retval;
        retval = new RecordRouteList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //RecordRouteList retval = new RecordRouteList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = 1724940469426766691L;
}

