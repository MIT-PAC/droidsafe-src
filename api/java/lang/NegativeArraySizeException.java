package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class NegativeArraySizeException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.584 -0500", hash_original_field = "59244586A788BEC4E32F89D8E6447446", hash_generated_field = "E540D2C0CDF6C49ADF14B99D1098B08E")


    private static final long serialVersionUID = -8960118058596991861L;

    /**
     * Constructs a new {@code NegativeArraySizeException} that includes the
     * current stack trace.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.587 -0500", hash_original_method = "D33CED1C2CC51E1A27A91F713183A870", hash_generated_method = "E2EA9079FDC4AA48610E64DC9E6A46EF")
    
public NegativeArraySizeException() {
    }

    /**
     * Constructs a new {@code NegativeArraySizeException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.590 -0500", hash_original_method = "8AAF2E9F34B5796377EDFC62134DFEB6", hash_generated_method = "9DA35405D4782D82BC899C34E2B6EFA8")
    
public NegativeArraySizeException(String detailMessage) {
        super(detailMessage);
    }
}

