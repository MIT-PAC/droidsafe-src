package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IllegalThreadStateException extends IllegalArgumentException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.728 -0500", hash_original_field = "A734A18CC347C4763740C4AD178DB0BC", hash_generated_field = "816FD291B6FE29E09EF042CECC4919EF")


    private static final long serialVersionUID = -7626246362397460174L;

    /**
     * Constructs a new {@code IllegalThreadStateException} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.729 -0500", hash_original_method = "5791A934E1D6D40F1C86D615B455C03B", hash_generated_method = "F32D651F547E5DD4CF6FA1E8A60AD6EC")
    public IllegalThreadStateException() {
    }

    /**
     * Constructs a new {@code IllegalThreadStateException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:21.730 -0500", hash_original_method = "3CBEBFECA4223415F4314CC0B87A4ECE", hash_generated_method = "7C3B2BF90CFFAA6D1B372154DE540591")
    public IllegalThreadStateException(String detailMessage) {
        super(detailMessage);
    }
}

