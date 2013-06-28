package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class UnknownError extends VirtualMachineError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.448 -0400", hash_original_method = "DEBB86C8E485BA79C07551D87066B1FF", hash_generated_method = "8B2FBCDE5A416A32BD94734123C8D214")
    public  UnknownError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.449 -0400", hash_original_method = "9EE2469E06677E3029FF643B11D994DB", hash_generated_method = "7D5350E4022121FF812DF6D1B2B31AC0")
    public  UnknownError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:51.449 -0400", hash_original_field = "5A150D1A2AD6013CCB992555A7148C3F", hash_generated_field = "3A804F8B2369E6030B7BA56EE93212B0")

    private static final long serialVersionUID = 2524784860676771849L;
}

