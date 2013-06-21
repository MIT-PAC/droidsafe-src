package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TooManyListenersException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.859 -0400", hash_original_method = "394F16F71C461EE8325C7C30649B2ED3", hash_generated_method = "55BADF54015CFE6EC75248941CAF5B26")
    @DSModeled(DSC.SAFE)
    public TooManyListenersException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:33.859 -0400", hash_original_method = "9AD8C053A7A66FB4440B6219D5D227F2", hash_generated_method = "001025A0848F40193BACD3CAC1E96C83")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TooManyListenersException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 5074640544770687831L;
}

