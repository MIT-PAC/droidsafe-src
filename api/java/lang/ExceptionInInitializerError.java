package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ExceptionInInitializerError extends LinkageError {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.952 -0500", hash_original_field = "9AA47CA1643168E0CC856212190B376C", hash_generated_field = "7192C69596784210497884AC1F9F31E5")

    private static final long serialVersionUID = 1521711792217232256L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.954 -0500", hash_original_field = "ED6B643F1012B300A602DEA8C7E5C621", hash_generated_field = "3848780C3E4557B7B025FBB998A1DBF6")

    private Throwable exception;

    /**
     * Constructs a new {@code ExceptionInInitializerError} that includes the
     * current stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.957 -0500", hash_original_method = "6D1A3A1944D703E56CAA922913525A43", hash_generated_method = "95B2FEB99475E14A7A7596C2882BF493")
    
public ExceptionInInitializerError() {
        initCause(null);
    }

    /**
     * Constructs a new {@code ExceptionInInitializerError} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.959 -0500", hash_original_method = "CDE8F850C70A27B83A36A148C961A5A1", hash_generated_method = "81DC4DA563C4D3955A10AEF79ED15705")
    
public ExceptionInInitializerError(String detailMessage) {
        super(detailMessage);
        initCause(null);
    }

    /**
     * Constructs a new {@code ExceptionInInitializerError} with the current
     * stack trace and the specified cause. The exception should be the one
     * which originally occurred in the class initialization code.
     *
     * @param exception
     *            the exception that caused this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.962 -0500", hash_original_method = "C6EE88DB95324F4EE61EE6CA197E1367", hash_generated_method = "9CB445F43A2D1A1B659EA9D2FEC77AEC")
    
public ExceptionInInitializerError(Throwable exception) {
        this.exception = exception;
        initCause(exception);
    }

    /**
     * Returns the exception that is the cause of this error.
     *
     * @return the exception that caused this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.965 -0500", hash_original_method = "7090E247F85246652792FDABBC14B51F", hash_generated_method = "DD2C1A468BBA098F8DCF17D1795200AE")
    
public Throwable getException() {
        return exception;
    }

    /**
     * Returns the cause of this error, or {@code null} if there is no cause.
     *
     * @return the exception that caused this error.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.968 -0500", hash_original_method = "28A8EFFB85C5CFA84BB4445EFA004CE6", hash_generated_method = "2841951C2FDE7E37DE442D29F3E6D125")
    
@Override
    public Throwable getCause() {
        return exception;
    }
}

