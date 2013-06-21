package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchElementException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.930 -0400", hash_original_method = "7511719788F886A7A8274E764953E7B7", hash_generated_method = "DB2EC439058F2459B76E1B52F342488A")
    @DSModeled(DSC.SAFE)
    public NoSuchElementException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:32.931 -0400", hash_original_method = "7D966D3BE675039003302E31B0D249C5", hash_generated_method = "D50F6D638EAC533692027052F0EEFD5E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchElementException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
    private static final long serialVersionUID = 6769829250639411880L;
}

