package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class TooManyListenersException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.723 -0500", hash_original_field = "9E71A724A2133D49821DCFC9931C3B14", hash_generated_field = "A9BE0D402B2678382730EEC5FD3D31D7")

    private static final long serialVersionUID = 5074640544770687831L;

    /**
     * Constructs a new {@code TooManyListenersException} with the current stack
     * trace filled in.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.726 -0500", hash_original_method = "394F16F71C461EE8325C7C30649B2ED3", hash_generated_method = "A00C68B13F21EB3E80F6F1BA41949E52")
    
public TooManyListenersException() {
    }

    /**
     * Constructs a new {@code TooManyListenersException} with the stack trace
     * and message filled in.
     *
     * @param detailMessage
     *            the detail message for the exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:02.728 -0500", hash_original_method = "9AD8C053A7A66FB4440B6219D5D227F2", hash_generated_method = "F18B30553EC0F81B26F20E636FA35055")
    
public TooManyListenersException(String detailMessage) {
        super(detailMessage);
    }
}

