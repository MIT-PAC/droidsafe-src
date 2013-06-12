package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class MalformedInputException extends CharacterCodingException {
    private static final long serialVersionUID = -3438823399834806194L;
    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.562 -0400", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "40FEACF7364460289888074248B4D424")
    @DSModeled(DSC.SAFE)
    public MalformedInputException(int length) {
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.562 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "EFC5B3F001E7567529B83049A5E6C919")
    @DSModeled(DSC.SAFE)
    public int getInputLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.562 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "28E14EB10804D5D7CFFBDC30A7FCA4EE")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
}


