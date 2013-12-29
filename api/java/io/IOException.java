package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class IOException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.630 -0500", hash_original_field = "B1489E9C2F91511CC7ABA4754C388294", hash_generated_field = "E1BB06D1BDEDB21E301ADD66B95C6A57")


    private static final long serialVersionUID = 7818375828146090155L;

    /**
     * Constructs a new {@code IOException} with its stack trace filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.631 -0500", hash_original_method = "4DDFF90B7CF8CD74272BB60235E66E65", hash_generated_method = "2B20F6BC5311851A287D855E8383F8C8")
    public IOException() {
    }

    /**
     * Constructs a new {@code IOException} with its stack trace and detail
     * message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.632 -0500", hash_original_method = "240D0BB3974E5D097E21F85B24F6FB44", hash_generated_method = "6B62B2903FC8CDC509B50797A6D8D38A")
    public IOException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance of this class with detail message and cause
     * filled in.
     *
     * @param message
     *            The detail message for the exception.
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.633 -0500", hash_original_method = "D16D4F9A4DF133858001870C6413D65C", hash_generated_method = "9EE73FDB0C546D60128128DD662DBF63")
    public IOException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of this class with its detail cause filled in.
     *
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:32.634 -0500", hash_original_method = "653E955146B329965A610B3602D07E3E", hash_generated_method = "5FC282426A31CD7F17EA87DB0C0514BE")
    public IOException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}

