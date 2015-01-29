package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class Exception extends Throwable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.542 -0500", hash_original_field = "EECB0D30D5F470342FA90BDEB3A56936", hash_generated_field = "F7EDE40BB9DA19762EC547780842C1FC")

    private static final long serialVersionUID = -3387516993124229948L;

    /**
     * Constructs a new {@code Exception} that includes the current stack trace.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.545 -0500", hash_original_method = "D33746B9B653741A49B1BE35D2346C75", hash_generated_method = "2DC5F4F46B1C4964DC33696D0E242A70")
    
public Exception() {
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace and the
     * specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.547 -0500", hash_original_method = "830A2EF4A7E30C0BE0D23F3C6E3EB88B", hash_generated_method = "0DA14231CA28FFA84AC2446DD1D89346")
    
public Exception(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace, the
     * specified detail message and the specified cause.
     *
     * @param detailMessage
     *            the detail message for this exception.
     * @param throwable
     *            the cause of this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.550 -0500", hash_original_method = "1CCC5FB7B2239F395100A328B05F71D2", hash_generated_method = "244E8810C7BC5B26AD1A1844DD052A3D")
    
public Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new {@code Exception} with the current stack trace and the
     * specified cause.
     *
     * @param throwable
     *            the cause of this exception.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:32.553 -0500", hash_original_method = "521C63C689E06CBA8E8D56AF626D043A", hash_generated_method = "368FEBC585DA2449C41F94036C536236")
    
public Exception(Throwable throwable) {
        super(throwable);
    }
}

