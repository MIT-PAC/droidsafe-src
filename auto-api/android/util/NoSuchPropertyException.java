package android.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchPropertyException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:52.466 -0400", hash_original_method = "9FBF5439C2FECDDB526E862ED7B30ADC", hash_generated_method = "643DDAD1E106B7CDBBC128A1AFE2753C")
    public  NoSuchPropertyException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

