package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class NumberFormatException extends IllegalArgumentException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:30.999 -0500", hash_original_field = "8D171DAFB2ADA241D6E6BA5DA0E60B74", hash_generated_field = "4EECED22A3600992D325F6581476D42F")

    private static final long serialVersionUID = -2848938806368998894L;

    /**
     * Constructs a new {@code NumberFormatException} that includes the current
     * stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.001 -0500", hash_original_method = "5EB9584C9C40374DC4817FFEDC3C2AF2", hash_generated_method = "B681D93FA1DAABB1E461B38A96858684")
    
public NumberFormatException() {
    }

    /**
     * Constructs a new {@code NumberFormatException} with the current stack
     * trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:31.004 -0500", hash_original_method = "E8CAE1FBBA27FF2762363375A55E9E2D", hash_generated_method = "ACB19163F0EB7585646C59502A3263AA")
    
public NumberFormatException(String detailMessage) {
        super(detailMessage);
    }
}

