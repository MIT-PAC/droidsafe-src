package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TransactionAlreadyExistsException extends SipException {
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.554 -0500", hash_original_method = "6748172A8FDBE98EBDE794888E886227", hash_generated_method = "0B329D2C1739262736AB4973837E0F3A")
    
public TransactionAlreadyExistsException(){
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.556 -0500", hash_original_method = "230B9A8FB8272D6B6901D384356BD5A2", hash_generated_method = "88C6B386A7B3EBE78385B4BDCA2EEF96")
    
public TransactionAlreadyExistsException(String message) {
        super(message);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:03.559 -0500", hash_original_method = "9199B538C593B6B8FFCCFB817BC4F480", hash_generated_method = "41F6821B2E89A566C87CAD35BC5DC496")
    
public TransactionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}

