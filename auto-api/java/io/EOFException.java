package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class EOFException extends IOException {
    private static final long serialVersionUID = 6433858223774886977L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.417 -0400", hash_original_method = "1CCCAA76135EE86F6894FC590C0C686A", hash_generated_method = "9D00C6551A031EE177C1D2D43EDA8B28")
    @DSModeled(DSC.SAFE)
    public EOFException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.417 -0400", hash_original_method = "1DF3A1A90A52071351DFC31CC87C4540", hash_generated_method = "E4B1F98C3E57EB65352953FA3E709B41")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public EOFException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


