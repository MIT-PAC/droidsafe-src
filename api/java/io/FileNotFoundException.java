package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class FileNotFoundException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.366 -0500", hash_original_field = "0468040FB64F4508B5C2080B079F9059", hash_generated_field = "30AE48B68F3E5FDD84FAAA1767F19D64")


    private static final long serialVersionUID = -897856973823710492L;

    /**
     * Constructs a new {@code FileNotFoundException} with its stack trace
     * filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.369 -0500", hash_original_method = "5655520ED34EDABAA2AA5E324B421F90", hash_generated_method = "FB15F551739706DA8BDBB2F11ED4BCDA")
    
public FileNotFoundException() {
    }

    /**
     * Constructs a new {@code FileNotFoundException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:42.372 -0500", hash_original_method = "84F2811DBCCBCE4B9E51EB4FDB1C21D5", hash_generated_method = "00AC5B40B9F0182CECE471D5813160F8")
    
public FileNotFoundException(String detailMessage) {
        super(detailMessage);
    }
}

