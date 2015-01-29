package javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TooManyHopsException extends Exception {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.096 -0500", hash_original_method = "7059525C7D643548AACC26A1B7FECDC6", hash_generated_method = "91253CE2ABA231246A1DFCB563806840")
    
public TooManyHopsException(){
        super();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.099 -0500", hash_original_method = "10941AD8E9E3A8951C3E1FF56EF96A49", hash_generated_method = "F3E86D0176FF040A066BC0A3E085792D")
    
public TooManyHopsException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.102 -0500", hash_original_method = "3567ED48A659002D0FAAA891FC5B218E", hash_generated_method = "28BDFEFFBE5C9F189879C7D742F539C7")
    
public TooManyHopsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

