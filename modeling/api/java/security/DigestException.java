package java.security;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class DigestException extends GeneralSecurityException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.003 -0500", hash_original_field = "E452B9EC58667CE2A5F7CBB9D62299F3", hash_generated_field = "853F3DF1FAC804A2D310C3B47CFD7996")

    private static final long serialVersionUID = 5821450303093652515L;

    /**
     * Constructs a new instance of {@code DigestException} with the
     * given message.
     *
     * @param msg
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.006 -0500", hash_original_method = "5DAAB61061CBFECD5A1E1A61BC7BAA88", hash_generated_method = "0DBA4FCDF31281A92C6AF2C31935DF04")
    
public DigestException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of {@code DigestException}.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.009 -0500", hash_original_method = "4BFD0A9812571E805B2B692917954A18", hash_generated_method = "37A829DB0B3E723B4558F5F7D4508D49")
    
public DigestException() {
    }

    /**
     * Constructs a new instance of {@code DigestException} with the
     * given message and the cause.
     *
     * @param message
     *            the detail message for this exception.
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.012 -0500", hash_original_method = "BCC7846DF9BFB7C5F5EA1087695CCF8F", hash_generated_method = "EE670F61890C190CF353A5C9C0CA66C7")
    
public DigestException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of {@code DigestException} with the
     * cause.
     *
     * @param cause
     *            the exception which is the cause for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:55.015 -0500", hash_original_method = "57079B2A067E95F6018E75F3448CD9E3", hash_generated_method = "6F48F0842ACE830A7DA85EC097885ACA")
    
public DigestException(Throwable cause) {
        super(cause);
    }
}

