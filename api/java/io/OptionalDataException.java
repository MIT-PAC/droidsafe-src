package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class OptionalDataException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:33.924 -0500", hash_original_field = "FDBC11225C979DE3098287A09D755E2A", hash_generated_field = "DDC830DCF3194537EFCDF0B62E5DB379")


    private static final long serialVersionUID = -8011121865681257820L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:33.925 -0500", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "A5BD226ED75D266A3BA0CDE2B4165A63")

    public boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:33.926 -0500", hash_original_field = "136C4DD872F8065EECD33F6CD4E7556E", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;

    /**
     * Constructs a new {@code OptionalDataException} with its stack trace
     * filled in.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:33.927 -0500", hash_original_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A", hash_generated_method = "C77AFC0EE27E4B45ACE7BE98CCDC7A8A")
    OptionalDataException() {
    }

    /**
     * Constructs a new {@code OptionalDataException} with its stack trace and
     * detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:33.928 -0500", hash_original_method = "EE3BF9736C6F166E6F73C7336660246A", hash_generated_method = "EE3BF9736C6F166E6F73C7336660246A")
    OptionalDataException(String detailMessage) {
        super(detailMessage);
    }
}

