package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class NoSuchFieldError extends IncompatibleClassChangeError {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.870 -0400", hash_original_method = "F8D799539E9A974C8BB35DC17F7C342D", hash_generated_method = "F310D0DF0C26994229A44A3EEEF18445")
    public  NoSuchFieldError() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.870 -0400", hash_original_method = "18AA8F00FBF3130F84A1236717EEB4A7", hash_generated_method = "0EFA84EA99FF806B4CF8E9A39B8D5343")
    public  NoSuchFieldError(String detailMessage) {
        super(detailMessage);
        addTaint(detailMessage.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.870 -0400", hash_original_field = "7619DA8FAE56FFEB65AC088E02923838", hash_generated_field = "BCF6CC0FF0E425951A0A962EA7AC61D1")

    private static long serialVersionUID = -3456430195886129035L;
}

