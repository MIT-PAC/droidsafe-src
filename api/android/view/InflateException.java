package android.view;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class InflateException extends RuntimeException {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.718 -0500", hash_original_method = "0CE2909AE04CF0521618BA35C7B8DC0B", hash_generated_method = "D4CAA5B21518BB66978DE02952E46A95")
    
public InflateException() {
        super();
    }

    @DSComment("this exception is data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.720 -0500", hash_original_method = "AB0AD772D96202B15FD464EB44BD1183", hash_generated_method = "21401FBBCF148045878FA9216F48AB7B")
    
public InflateException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    @DSComment("this exception is data structure only")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.722 -0500", hash_original_method = "D7F4245311806265B6BE5F25BA86EF2F", hash_generated_method = "6A7C44402340409706626CC758FACD5A")
    
public InflateException(String detailMessage) {
        super(detailMessage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:09.726 -0500", hash_original_method = "D6B4BD85C2EC6AC3FF7C8DC3F1D9D2C5", hash_generated_method = "37D65122EF1CAD69D887066C5329339B")
    
public InflateException(Throwable throwable) {
        super(throwable);
    }
    
}

