package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class LinkageError extends Error {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.075 -0500", hash_original_field = "9B44CF72CFEE8E2328FF33B1B1DF2555", hash_generated_field = "26764E9962CE8BCD1CC3E5C82CC971B6")


    private static final long serialVersionUID = 3579600108157160122L;

    /**
     * Constructs a new {@code LinkageError} that includes the current stack
     * trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.077 -0500", hash_original_method = "F8257C8B139D012B1AF21CEDF65AEAF0", hash_generated_method = "39CB35F13B33ABCDCDED8019268A5407")
    
public LinkageError() {
    }

    /**
     * Constructs a new {@code LinkageError} with the current stack trace and
     * the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.080 -0500", hash_original_method = "3F282F39CCEC2A75C9FAEF6579E7409E", hash_generated_method = "7DDBA2430E3ED5C581B26CD61B51F33F")
    
public LinkageError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code LinkageError} with the given detail message and cause.
     * @since 1.7
     * @hide 1.7
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.083 -0500", hash_original_method = "EA091AF8CE4C0C3DC980640F02BF597B", hash_generated_method = "F7BDF843E44AC3DDAEC5BE3C74AF0A83")
    
public LinkageError(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

