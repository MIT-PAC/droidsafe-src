package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class ConcurrentModificationException extends RuntimeException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.261 -0500", hash_original_field = "557B581588154B680EBBA0EFE4F73934", hash_generated_field = "BE6788E7D91F00AD085BECEE1E4F5DE1")

    private static final long serialVersionUID = -3666751008965953603L;

    /**
     * Constructs a new {@code ConcurrentModificationException} with the current
     * stack trace filled in.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.264 -0500", hash_original_method = "5F5AEF59023EF0CE03A16FBB12617DB7", hash_generated_method = "36411DD424D866BE99107FE1F2CAFAAC")
    
public ConcurrentModificationException() {
        /*empty*/
    }

    /**
     * Constructs a new {@code ConcurrentModificationException} with the current
     * stack trace and message filled in.
     *
     * @param detailMessage
     *           the detail message for the exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.266 -0500", hash_original_method = "106C24DD3D2A07AA8584E42740C7683A", hash_generated_method = "AF6C9CF7F087DDFFAE2DE0F344896AA8")
    
public ConcurrentModificationException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new {@code ConcurrentModificationException} with the given detail
     * message and cause.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.269 -0500", hash_original_method = "2C18D4011661B4B4C3C2AF76F80D71D0", hash_generated_method = "6C86FBCCFB6A47ADD3BE2BE14A44B5EA")
    
public ConcurrentModificationException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }

    /**
     * Constructs a new {@code ConcurrentModificationException} with the given cause.
     * @since 1.7
     * @hide 1.7
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:38.272 -0500", hash_original_method = "1483D8E8224DDF6AD31766681C65E484", hash_generated_method = "4637238951A922846FDFD9A2504F0E10")
    
public ConcurrentModificationException(Throwable cause) {
        super(cause);
    }
}

