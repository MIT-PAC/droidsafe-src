package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NotActiveException extends ObjectStreamException {
    private static final long serialVersionUID = -3893467273049808895L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "04F1D3389F0C6F41AEA2935866CA7222", hash_generated_method = "58939E0E1C42E2DC3CFC00796F069716")
    @DSModeled(DSC.SAFE)
    public NotActiveException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:11.484 -0400", hash_original_method = "3214341FEC67E095A6821294CDC33C6B", hash_generated_method = "1D2B41C20E40BA1F0418EE5D5CB13166")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NotActiveException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


