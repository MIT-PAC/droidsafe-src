package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;

public class AcceptList extends SIPHeaderList<Accept> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.649 -0400", hash_original_method = "51B5F4325CF7E310BAF41022AF7E4824", hash_generated_method = "70A657851AA3A54A657243AA76937424")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AcceptList() {
        super(Accept.class, AcceptHeader.NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.650 -0400", hash_original_method = "3C553A191FB2DA2F431571F69D6628C7", hash_generated_method = "EA5F64F21DDAC82FD9FB4953F2F7DEAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        AcceptList retval;
        retval = new AcceptList();
        retval.clonehlist(this.hlist);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //AcceptList retval = new AcceptList();
        //retval.clonehlist(this.hlist);
        //return retval;
    }

    
    private static final long serialVersionUID = -1800813338560484831L;
}

