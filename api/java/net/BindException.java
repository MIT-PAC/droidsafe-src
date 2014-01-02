package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public class BindException extends SocketException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.012 -0500", hash_original_field = "59B89B96D77D39960A9CC4B33424C199", hash_generated_field = "EA3137D160EDA862C3C64F1345348850")


    private static final long serialVersionUID = -5945005768251722951L;

    /**
     * Constructs a new instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.015 -0500", hash_original_method = "D66D1C4C5928E000A465F2B26896B637", hash_generated_method = "67462F58C9225E1872E2A6EC78A7CCD4")
    
public BindException() {
    }

    /**
     * Constructs a new instance with the given detail message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.018 -0500", hash_original_method = "6FF32DF773E2792C41FA7AD13FDCFDDC", hash_generated_method = "FA7A2FC4F704693B139DE1009428863C")
    
public BindException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance with the given detail message and cause.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.021 -0500", hash_original_method = "C8F93BE3A806C12732DAADB48D8791E4", hash_generated_method = "C5B311C94510CAEE036013661C9C799B")
    
public BindException(String detailMessage, Throwable cause) {
        super(detailMessage, cause);
    }
}

