package java.util.concurrent;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class TimeoutException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.188 -0500", hash_original_field = "68575169DC0173071B6C7AFCA1837323", hash_generated_field = "27D2403B305D4570D5BAB39A961BDA5B")

    private static final long serialVersionUID = 1900926677490660714L;

    /**
     * Constructs a <tt>TimeoutException</tt> with no specified detail
     * message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.188 -0500", hash_original_method = "043D89A921444ACFFC25D3711EECF0CA", hash_generated_method = "1EC3AF62B1106EC64D8195D6B4E8C3D2")
    public TimeoutException() {}

    /**
     * Constructs a <tt>TimeoutException</tt> with the specified detail
     * message.
     *
     * @param message the detail message
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:41.189 -0500", hash_original_method = "D54DDC72729A014BD7698825D7BF2D5A", hash_generated_method = "787A427C3C50877320E1D51565E40BED")
    public TimeoutException(String message) {
        super(message);
    }
}

