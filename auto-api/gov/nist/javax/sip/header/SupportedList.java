package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class SupportedList extends SIPHeaderList<Supported> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.429 -0400", hash_original_method = "C97E7EF6FC87A3A068AC23349CE0B329", hash_generated_method = "9D8330A8D22F00AA1938D1F30E872420")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SupportedList() {
        super(Supported.class, SupportedHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.429 -0400", hash_original_method = "45CDCD8BD327539AF66457D00250AD24", hash_generated_method = "3F27EC8673E1A68469F066ADF53576A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        SupportedList retval;
        retval = new SupportedList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SupportedList retval = new SupportedList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -4539299544895602367L;
}

