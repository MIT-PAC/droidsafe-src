package java.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class StreamCorruptedException extends ObjectStreamException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.132 -0500", hash_original_field = "130D49E62A08880675568332DC3A7624", hash_generated_field = "C02478F50E87CEA242ED68632349F681")

    private static final long serialVersionUID = 8983558202217591746L;

    /**
     * Constructs a new {@code StreamCorruptedException} with its stack trace
     * filled in.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.135 -0500", hash_original_method = "03146CFF1C14D5173926865A5139AFE4", hash_generated_method = "FF991A549068A8E8DD401C5E50C7D1F2")
    
public StreamCorruptedException() {
    }

    /**
     * Constructs a new {@code StreamCorruptedException} with its stack trace
     * and detail message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:40.137 -0500", hash_original_method = "6AA6DFEF93503E81D7AC2485347FBC08", hash_generated_method = "1EEB5EC4A47D302E742281C2A3E20EF1")
    
public StreamCorruptedException(String detailMessage) {
        super(detailMessage);
    }
}

