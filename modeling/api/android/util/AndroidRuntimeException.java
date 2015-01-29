package android.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class AndroidRuntimeException extends RuntimeException {
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.088 -0500", hash_original_method = "8C5786A2A5252DB156BAEEC9B2143392", hash_generated_method = "02DA522DD080CDAE1E9ADBFF5C94CF58")
    
public AndroidRuntimeException() {
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.090 -0500", hash_original_method = "8B3545FC9B2683E7AFCB1B7C9932589B", hash_generated_method = "67B445ECFCC17D0A755847CA92266B90")
    
public AndroidRuntimeException(String name) {
        super(name);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.093 -0500", hash_original_method = "396EB52B778995BFC6A3E50EA6AAC7F8", hash_generated_method = "5C585823752F147C8502A1D03B84B243")
    
public AndroidRuntimeException(String name, Throwable cause) {
        super(name, cause);
    }

    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:25.095 -0500", hash_original_method = "ED4D86824E00309868D3D3E5627C1A8D", hash_generated_method = "1D5FDD8734CCF05D7269AECF4A852360")
    
public AndroidRuntimeException(Exception cause) {
        super(cause);
    }
    
}

