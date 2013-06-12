package java.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class NoSuchElementException extends RuntimeException {
    private static final long serialVersionUID = 6769829250639411880L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.783 -0400", hash_original_method = "7511719788F886A7A8274E764953E7B7", hash_generated_method = "F2CF74DB427683F75979290275961449")
    @DSModeled(DSC.SAFE)
    public NoSuchElementException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:14.783 -0400", hash_original_method = "7D966D3BE675039003302E31B0D249C5", hash_generated_method = "0353D5DB7403334EE3162CCA2B9396E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NoSuchElementException(String detailMessage) {
        super(detailMessage);
        dsTaint.addTaint(detailMessage);
        // ---------- Original Method ----------
    }

    
}


