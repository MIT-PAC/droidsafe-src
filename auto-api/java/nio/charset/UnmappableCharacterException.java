package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public class UnmappableCharacterException extends CharacterCodingException {
    private static final long serialVersionUID = -7026962371537706123L;
    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.567 -0400", hash_original_method = "A3967154D82E53B3FB96C6C01ABA540C", hash_generated_method = "7AEE7A8FF5AB54E437766D403B0A09DF")
    @DSModeled(DSC.SAFE)
    public UnmappableCharacterException(int length) {
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.567 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "EFC5B3F001E7567529B83049A5E6C919")
    @DSModeled(DSC.SAFE)
    public int getInputLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.567 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "28E14EB10804D5D7CFFBDC30A7FCA4EE")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
}


