package java.text;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ParseException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.525 -0500", hash_original_field = "8981FBE471D806A7618236C22EA1A6C5", hash_generated_field = "5A7101C6E28567B3F3B659C16DEAC630")


    private static final long serialVersionUID = 2703218443322787634L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.526 -0500", hash_original_field = "B788853ABE9B2871E364B41F20C8C424", hash_generated_field = "258A596A4575EE51D9F18F048FF1B7C5")


    private int errorOffset;

    /**
     * Constructs a new instance of this class with its stack trace, detail
     * message and the location of the error filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param location
     *            the index at which the parse exception occurred.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.527 -0500", hash_original_method = "23D3B11AE402493DA8F476B948072A30", hash_generated_method = "8CD4FC8E1AC9ABF55C88FFAC857144E0")
    public ParseException(String detailMessage, int location) {
        super(detailMessage + (" (at offset " + location + ")"));
        errorOffset = location;
    }

    /**
     * Returns the index at which this parse exception occurred.
     *
     * @return the location of this exception in the parsed string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:16.528 -0500", hash_original_method = "738B6139CDE89AFA00D1C6F31524980A", hash_generated_method = "5D59C3F156DEF1986BBF400D3ABFD44F")
    public int getErrorOffset() {
        return errorOffset;
    }
}

