package javax.xml.validation;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;


public abstract class Schema {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:15.596 -0400", hash_original_method = "62D96326348B566190A7BDAA8CEB8272", hash_generated_method = "D8A5B8DCA6B75E0C97C65F08DCB1759B")
    @DSModeled(DSC.SAFE)
    protected Schema() {
        // ---------- Original Method ----------
    }

    
    public abstract Validator newValidator();

    
    public abstract ValidatorHandler newValidatorHandler();

    
}


