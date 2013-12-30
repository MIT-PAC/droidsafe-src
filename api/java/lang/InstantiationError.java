package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class InstantiationError extends IncompatibleClassChangeError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.910 -0500", hash_original_field = "FE1E0D266091647CEB7032D9E6BBCCB3", hash_generated_field = "5293F978E12C264089BA3B2578BB9948")

    private static final long serialVersionUID = -4885810657349421204L;

    /**
     * Constructs a new {@code InstantiationError} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.913 -0500", hash_original_method = "0CADFA7EDCF977E1C3E40BA09A641E39", hash_generated_method = "538956C170632FE0860C43439451E631")
    
public InstantiationError() {
    }

    /**
     * Constructs a new {@code InstantiationError} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.916 -0500", hash_original_method = "023CF4960A8F6AD78560985CF4A496AC", hash_generated_method = "EB0476C17938DCAD95114043BBC05FEE")
    
public InstantiationError(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code InstantiationError} with the current stack trace
     * and the class that caused this error.
     *
     * @param clazz
     *            the class that can not be instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.918 -0500", hash_original_method = "715FEA28AECD396E352AFBA27C6E8A8B", hash_generated_method = "715FEA28AECD396E352AFBA27C6E8A8B")
    
InstantiationError(Class<?> clazz) {
        super(clazz.getName());
    }
}

