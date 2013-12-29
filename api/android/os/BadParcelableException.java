package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.util.AndroidRuntimeException;


public class BadParcelableException extends AndroidRuntimeException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.210 -0500", hash_original_method = "C5F204DF0C7D13038C37380E12FE2000", hash_generated_method = "F0B89839410DF67C034B19672974851F")
    public BadParcelableException(String msg) {
        super(msg);
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:38.210 -0500", hash_original_method = "9DC5C45DC709D8D31247431851AD50BB", hash_generated_method = "FFEBFB15683F2C7FA83087DF3D1825F0")
    public BadParcelableException(Exception cause) {
        super(cause);
    }

    
}

