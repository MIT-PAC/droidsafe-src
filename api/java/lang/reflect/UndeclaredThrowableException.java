package java.lang.reflect;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class UndeclaredThrowableException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.142 -0500", hash_original_field = "E7E12866610474314368CE3B05D11CFF", hash_generated_field = "D26E659D3C6F2BAC21FB5EA803CB906E")

    private static final long serialVersionUID = 330127114055056639L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.144 -0500", hash_original_field = "78087893AB98A2D25C5062009414C591", hash_generated_field = "BF3D8746B5EF92EBFB7AAFB8779CD82F")

    private Throwable undeclaredThrowable;

    /**
     * Constructs a new {@code UndeclaredThrowableException} instance with the
     * undeclared, checked exception that occurred.
     *
     * @param exception
     *            the undeclared, checked exception that occurred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.147 -0500", hash_original_method = "2E4465C869474A92C89F11543A5003FF", hash_generated_method = "640184A84C05B7F149271CD80E9EDBB6")
    
public UndeclaredThrowableException(Throwable exception) {
        this.undeclaredThrowable = exception;
        initCause(exception);
    }

    /**
     * Constructs a new {@code UndeclaredThrowableException} instance with the
     * undeclared, checked exception that occurred and a message.
     *
     * @param detailMessage
     *            the detail message for the exception
     * @param exception
     *            the undeclared, checked exception that occurred
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.149 -0500", hash_original_method = "6F99F5FACA33DF39A2D7F5348E0FE855", hash_generated_method = "39A772A0C44B961DAB684482F8D664E5")
    
public UndeclaredThrowableException(Throwable exception,
            String detailMessage) {
        super(detailMessage);
        this.undeclaredThrowable = exception;
        initCause(exception);
    }

    /**
     * Returns the undeclared, checked exception that occurred, which may be
     * {@code null}.
     *
     * @return the undeclared, checked exception that occurred
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.151 -0500", hash_original_method = "01FF2A365C1FC09F8BDCAF7FAA2D9177", hash_generated_method = "AAE8EA3B94CC171AA0A6A12A9BF21D1D")
    
public Throwable getUndeclaredThrowable() {
        return undeclaredThrowable;
    }

    /**
     * Returns the undeclared, checked exception that occurred, which may be
     * {@code null}.
     *
     * @return the undeclared, checked exception that occurred
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:12.154 -0500", hash_original_method = "1E11CE865934C875382AA6A691DB2EF1", hash_generated_method = "493C3D310278EA30F486DA9AAD65DAC5")
    
@Override
    public Throwable getCause() {
        return undeclaredThrowable;
    }
}

