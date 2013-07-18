package android.util;

// Droidsafe Imports
import droidsafe.annotations.DSGenerator;

public class TimeFormatException extends RuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:41.238 -0400", hash_original_method = "1F441C8C9E2A795A7065E4180639EC98", hash_generated_method = "CDF48688F37ADCAF94FCBCF139181A93")
      TimeFormatException(String s) {
        super(s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
    }

    
}

