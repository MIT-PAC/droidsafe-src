package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ClassNotFoundException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.326 -0500", hash_original_field = "D378D451C6A9AA75042E4C7DA0EA13BC", hash_generated_field = "FA7E6F5FBCB6CD253D61495BAEBC0CED")

    private static final long serialVersionUID = 9176873029745254542L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.328 -0500", hash_original_field = "1681A14450382F5ED1D23C2523918CE1", hash_generated_field = "F73E8300D821D42895FBD4F8215B8AE6")

    private Throwable ex;

    /**
     * Constructs a new {@code ClassNotFoundException} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.331 -0500", hash_original_method = "0639B59AB447390D4DDFBD24616B4C1C", hash_generated_method = "087A5B50FC44FD666E2D3F8D2057B243")
    
public ClassNotFoundException() {
        super((Throwable) null);
    }

    /**
     * Constructs a new {@code ClassNotFoundException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.333 -0500", hash_original_method = "298BE36926392F30C6A667D05BCFC9E5", hash_generated_method = "8B6723A0279947B5AF5A19813C5FAF0F")
    
public ClassNotFoundException(String detailMessage) {
        super(detailMessage, null);
    }

    /**
     * Constructs a new {@code ClassNotFoundException} with the current stack
     * trace, the specified detail message and the exception that occurred when
     * loading the class.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param exception
     *            the exception which occurred while loading the class.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.336 -0500", hash_original_method = "3941F53B9B07ECD0ECA0F56417778218", hash_generated_method = "A5D5B3A0A6DD55A720FC331268C5BBB7")
    
public ClassNotFoundException(String detailMessage, Throwable exception) {
        super(detailMessage);
        ex = exception;
    }

    /**
     * Returns the exception which occurred when loading the class.
     *
     * @return Throwable the exception which occurred while loading the class.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.339 -0500", hash_original_method = "4088520C94C7E98A0F8384BC5CAC9A7D", hash_generated_method = "D473C62C475616E21991B01B54B563B2")
    
public Throwable getException() {
        return ex;
    }

    /**
     * Returns the cause of this Throwable, or {@code null} if there is no
     * cause.
     *
     * @return Throwable the receiver's cause.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:29.341 -0500", hash_original_method = "8471E555B70ADD40A898DC66BF7F4D1C", hash_generated_method = "A69F1A8789DE405322A53C635DA52F50")
    
@Override
    public Throwable getCause() {
        return ex;
    }
}

