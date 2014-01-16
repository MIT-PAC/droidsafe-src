package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class MalformedURLException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.251 -0500", hash_original_field = "E744E5E5145E24C62ED6FDA618DBC852", hash_generated_field = "B44A4BD557582E4A416B968EA462C43E")

    private static final long serialVersionUID = -182787522200415866L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.254 -0500", hash_original_method = "6F3415F478603350217F65D672585814", hash_generated_method = "0E236ABE9114E40AAA3268CD6473B8F7")
    
public MalformedURLException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSComment("exception")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.257 -0500", hash_original_method = "1BAAD892782075B201BE55BD9DAC535A", hash_generated_method = "AA9F9CC55712E63E74CB29634AA09FCD")
    
public MalformedURLException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with given detail message and cause.
     * @hide internal use only
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.260 -0500", hash_original_method = "ACF50FF54717652ACCF5120218FC2A60", hash_generated_method = "9C7671ACA56F81AE7FE116893866060D")
    
public MalformedURLException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

