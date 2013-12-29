package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.Serializable;






public class InputMismatchException extends NoSuchElementException implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:46.231 -0500", hash_original_field = "8B1A3CDDAD7CF5D497BCD7A938C0E58B", hash_generated_field = "7554F709646625C457AB1EB5A5B9A0B3")


    private static final long serialVersionUID = 8811230760997066428L;

    /**
     * Constructs a new {@code InputMismatchException} with the current stack
     * trace filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:46.232 -0500", hash_original_method = "E660D99FFDDF21F21077CDA3D732980B", hash_generated_method = "ADF824D47240C59880853F763199DB09")
    public InputMismatchException() {
    }

    /**
     * Constructs a new {@code InputMismatchException} with the stack trace
     * filled in and {@code msg} as its error message.
     *
     * @param msg
     *           the specified error message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:46.233 -0500", hash_original_method = "47047CB10E710A9BD2F04A12F2CE94CF", hash_generated_method = "22971C4DFB78EBE0B889539658BC1F21")
    public InputMismatchException(String msg) {
        super(msg);
    }
}

