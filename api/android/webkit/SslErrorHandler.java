package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Handler;




public class SslErrorHandler extends Handler {

    /**
     * Package-private constructor needed for API compatibility.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.602 -0500", hash_original_method = "3466DABF5042C2C528E28F73B5209EC0", hash_generated_method = "3466DABF5042C2C528E28F73B5209EC0")
    
SslErrorHandler() {}

    /**
     * Proceed with the SSL certificate.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.604 -0500", hash_original_method = "03979FBB0BB429E6C16375AAFE9C359F", hash_generated_method = "3ABC81C77C859CFD1418771BD04B5D0A")
    
public void proceed() {}

    /**
     * Cancel this request and all pending requests for the WebView that had
     * the error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:10.606 -0500", hash_original_method = "E5C5DBED2FC0D18DB80484DB83D94F8A", hash_generated_method = "03D37BD64D7EA5A498C29F3157B06CA4")
    
public void cancel() {}

    
}

