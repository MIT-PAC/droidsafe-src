package org.bouncycastle.util.io.pem;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public class PemGenerationException extends IOException {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.276 -0500", hash_original_field = "E65D4B046C7E75D4305AF1275FC1F72B", hash_generated_field = "8A44E2478DCB737F0795473263737867")

    private Throwable cause;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.279 -0500", hash_original_method = "33CBECFB76FE1092AA2D14F5073D46BE", hash_generated_method = "C8F1B845D8EEB276BFB6994079CC4AD0")
    
public PemGenerationException(String message, Throwable cause)
    {
        super(message);
        this.cause = cause;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.281 -0500", hash_original_method = "80C2BF6F9B17521430AAD5FD6B82B847", hash_generated_method = "B03B1AC19BEAF7D727DB4D1BDC4B0FF6")
    
public PemGenerationException(String message)
    {
        super(message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:42.283 -0500", hash_original_method = "CDBDBC1C44563A9D34649A0018341F0E", hash_generated_method = "7216169927F14A6BA3457BBD72FD53B3")
    
public Throwable getCause()
    {
        return cause;
    }
    
}

