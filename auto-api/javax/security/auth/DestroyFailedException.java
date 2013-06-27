package javax.security.auth;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class DestroyFailedException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.793 -0400", hash_original_method = "22F1E573FCB9B888944769B0D578ECFF", hash_generated_method = "625155947AD09CAB3856E8CDF9BE43F0")
    public  DestroyFailedException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.793 -0400", hash_original_method = "49DB9D74B82421E273A368ED4AD8049A", hash_generated_method = "1C116CEBFB0E50E54BBB1395893F9B9C")
    public  DestroyFailedException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:00.793 -0400", hash_original_field = "BDD9F7635817EE9CFFDB503F651F0550", hash_generated_field = "EA468BF27ADD4371F4C08CAB77B1B7F6")

    private static long serialVersionUID = -7790152857282749162L;
}

