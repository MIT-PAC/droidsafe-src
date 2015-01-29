package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CloneNotSupportedException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.342 -0500", hash_original_field = "BF6D1A23162E4506BA6D1B0336D39652", hash_generated_field = "02486491CED3B07CB6E05085AC582AA7")

    private static final long serialVersionUID = 5195511250079656443L;

    /**
     * Constructs a new {@code CloneNotSupportedException} that includes the
     * current stack trace.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.345 -0500", hash_original_method = "3D71496D40C645B60B1C6E10AB3776C0", hash_generated_method = "E94AE4323CD1F3459C1761112BD7011C")
    
public CloneNotSupportedException() {
    }

    /**
     * Constructs a new {@code CloneNotSupportedException} with the current
     * stack trace and the specified detail message.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:15.348 -0500", hash_original_method = "19F2DAFDEBBAFFF27428A0FB57B58023", hash_generated_method = "1B39E2CCF9D2613B0210C355E3023149")
    
public CloneNotSupportedException(String detailMessage) {
        super(detailMessage);
    }
}

