package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class RuntimeException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.449 -0500", hash_original_field = "E65ACED5A2DE509E1CDD843DE04EAFE7", hash_generated_field = "3820080247BEE5769E364CDD33D922EF")


    private static final long serialVersionUID = -7034897190745766939L;

    /**
     * Constructs a new {@code RuntimeException} that includes the current stack
     * trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.451 -0500", hash_original_method = "C630CF95A30AC67866F4ABFDC2AE9E1F", hash_generated_method = "8AB2C2966B4371731D39E4E95567B0FE")
    
public RuntimeException() {
    }

    /**
     * Constructs a new {@code RuntimeException} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.454 -0500", hash_original_method = "80B9FEB41572B74366DE05587056CF70", hash_generated_method = "4DD04B2C35838618AF6F996FA7A705B9")
    
public RuntimeException(String detailMessage) {
        super(detailMessage);
    }

   /**
     * Constructs a new {@code RuntimeException} with the current stack trace,
     * the specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param throwable
     *            the cause of this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.457 -0500", hash_original_method = "6494A6C5ABD2EBB06754B14C1D93C94D", hash_generated_method = "5A62B4EA73570EEB9EAE7AFF938ADEB8")
    
public RuntimeException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code RuntimeException} with the current stack trace
     * and the specified cause.
     *
     * @param throwable
     *            the cause of this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:28.459 -0500", hash_original_method = "2585C76CA369FC60FE687924F5D5A532", hash_generated_method = "CB55487DE634289096B1F047CCFE33AA")
    
public RuntimeException(Throwable throwable) {
        super(throwable);
    }
}

