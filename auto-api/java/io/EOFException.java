package java.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class EOFException extends IOException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.689 -0400", hash_original_method = "1CCCAA76135EE86F6894FC590C0C686A", hash_generated_method = "7B880AD42DEB094CD5B685C1C5FFAC26")
    public  EOFException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.689 -0400", hash_original_method = "1DF3A1A90A52071351DFC31CC87C4540", hash_generated_method = "855014E89A61FE5F00BB1A0F46233C4D")
    public  EOFException(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:38.689 -0400", hash_original_field = "B7325034DCD2CA48559C1DD367EA5CAB", hash_generated_field = "5950DB4CD6E96FB998F42C10ECE722AB")

    private static long serialVersionUID = 6433858223774886977L;
}

