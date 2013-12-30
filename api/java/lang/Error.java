package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Error extends Throwable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.157 -0500", hash_original_field = "386A00E1E27E51DFD74AF81FF1E097A4", hash_generated_field = "0C6BB99ACF2AC755166A071BFA44B261")


    private static final long serialVersionUID = 4980196508277280342L;

    /**
     * Constructs a new {@code Error} that includes the current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.159 -0500", hash_original_method = "7D5BF5C7538ED3BFC2F69913B33169E2", hash_generated_method = "6D0C6454BB9469EF1C0429926C620B4F")
    
public Error() {
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.163 -0500", hash_original_method = "C6CAA4A4AF257044103CFF33D3E9FE9A", hash_generated_method = "E3D8165277FA6D50061AAC001F58C19C")
    
public Error(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this error.
     * @param throwable
     *            the cause of this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.165 -0500", hash_original_method = "66AA244741442CFF9E9D4A286C858491", hash_generated_method = "86EF41D4B1FADF17B10BB3876C7BF584")
    
public Error(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code Error} with the current stack trace and the
     * specified cause.
     *
     * @param throwable
     *            the cause of this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:16.168 -0500", hash_original_method = "4F891171DD00932FF603BE77BF813093", hash_generated_method = "A653D91049E5B51F33565FEFBC98BB1E")
    
public Error(Throwable throwable) {
        super(throwable);
    }
}

