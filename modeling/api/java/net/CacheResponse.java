package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public abstract class CacheResponse {
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.296 -0400", hash_original_method = "621EFF4ACAE6839C6F6B759A29E80397", hash_generated_method = "621EFF4ACAE6839C6F6B759A29E80397")
    public CacheResponse ()
    {
        //Synthesized constructor
    }
    /**
     * Returns an {@code InputStream} to access the response body.
     *
     * @return an {@code InputStream} which can be used to fetch the response
     *         body.
     * @throws IOException
     *             if an I/O error is encountered while retrieving the response
     *             body.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.049 -0500", hash_original_method = "4FE527F26D4DC9AF0C47E9AE29A33E83", hash_generated_method = "342BF8230112C2AD119F694144CAB4F2")
    
public abstract InputStream getBody() throws IOException;

    /**
     * Returns an immutable {@code Map} which contains the response headers
     * information. Note that {@code URLConnection} may need the original headers to be
     * able to fully reconstruct the response. In particular, failure to provide
     * a mapping from null to the original HTTP status line will prevent an
     * {@code HttpURLConnection} from returning the correct response code.
     * See {@link URLConnection#getHeaderFields}.
     *
     * @return an immutable {@code Map} which contains the response headers.
     * @throws IOException
     *             if an I/O error is encountered while retrieving the response
     *             headers.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.051 -0500", hash_original_method = "573CBFDFD5653531FB0C0AE5FEE8D961", hash_generated_method = "5A04DA33FF0AE30B4D87CD23D93A6522")
    
public abstract Map<String, List<String>> getHeaders() throws IOException;
    
}

