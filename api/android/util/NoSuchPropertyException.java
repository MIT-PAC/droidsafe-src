package android.util;

// Droidsafe Imports
import droidsafe.annotations.*;


public class NoSuchPropertyException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:40.938 -0400", hash_original_method = "9FBF5439C2FECDDB526E862ED7B30ADC", hash_generated_method = "643DDAD1E106B7CDBBC128A1AFE2753C")
    public  NoSuchPropertyException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

