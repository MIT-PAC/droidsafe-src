package java.nio.charset;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class MalformedInputException extends CharacterCodingException {
    private int inputLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.260 -0400", hash_original_method = "18BAC8E5082B44B03924789E1D8CD6BE", hash_generated_method = "1E940EBE4EF7EBD1E0792CFE85DF6A3A")
    @DSModeled(DSC.SAFE)
    public MalformedInputException(int length) {
        dsTaint.addTaint(length);
        // ---------- Original Method ----------
        //this.inputLength = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.260 -0400", hash_original_method = "99174ED6911F5F8CBB68A90343CD57CF", hash_generated_method = "C22C3903B408976A897A8BC896A23157")
    @DSModeled(DSC.SAFE)
    public int getInputLength() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.inputLength;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.260 -0400", hash_original_method = "7D10807CFABB560A12F38675F46A3FF5", hash_generated_method = "02B4FEA78B64EA9671FFD858ABC07DB1")
    @DSModeled(DSC.SAFE)
    @Override
    public String getMessage() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "Length: " + inputLength;
    }

    
    private static final long serialVersionUID = -3438823399834806194L;
}

