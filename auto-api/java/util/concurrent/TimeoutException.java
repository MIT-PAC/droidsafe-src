package java.util.concurrent;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class TimeoutException extends Exception {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.771 -0400", hash_original_method = "043D89A921444ACFFC25D3711EECF0CA", hash_generated_method = "2EED959198322EAFC7EA8AB16C41E080")
    public  TimeoutException() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.771 -0400", hash_original_method = "D54DDC72729A014BD7698825D7BF2D5A", hash_generated_method = "312397A5A5410DF83FD53C034CCAFBAD")
    public  TimeoutException(String message) {
        super(message);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:57.771 -0400", hash_original_field = "E7D250620E65CEAFADCA7500EC5003F7", hash_generated_field = "D3D7B630E430BF7E2267E7CC9646414F")

    private static long serialVersionUID = 1900926677490660714L;
}

