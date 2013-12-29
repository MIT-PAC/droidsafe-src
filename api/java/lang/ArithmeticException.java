package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ArithmeticException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:24.924 -0500", hash_original_field = "7D9F8015B61E0B4BE134907A2CB9487A", hash_generated_field = "C9BDC9ED215269D9310238C3CF45CF59")


    private static final long serialVersionUID = 2256477558314496007L;

    /**
     * Constructs a new {@code ArithmeticException} that includes the current
     * stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:24.926 -0500", hash_original_method = "24115F2AC5B4BFA51305F479377E801A", hash_generated_method = "6CA9F084E57C93D38306509B1DC42B7B")
    public ArithmeticException() {
    }

    /**
     * Constructs a new {@code ArithmeticException} with the current stack trace
     * and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:24.927 -0500", hash_original_method = "FAC340A34D2F62BBB9E823C2AE5CBB24", hash_generated_method = "3BFB26C55AB7859304FE7FF29DA7ADA6")
    public ArithmeticException(String detailMessage) {
        super(detailMessage);
    }
}

