package javax.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;


public class InvalidArgumentException extends SipException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.934 -0500", hash_original_method = "058727A85A3561BD87B89BB684E2068E", hash_generated_method = "AF12D8E2090729205342B367A499ADBB")
    public InvalidArgumentException() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.935 -0500", hash_original_method = "6CFB0BD92581CA0A67925F5045802025", hash_generated_method = "BD8586C7E6A7B533D39F4096F0DE5F3F")
    public InvalidArgumentException(String message) {
        super(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.936 -0500", hash_original_method = "36D7705F557972E94094B17807C973B6", hash_generated_method = "A703C68E76D6F76749A31F494141C720")
    public InvalidArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    
}

