package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class ResponseCache {

    /**
     * Returns the system's default response cache, or null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.194 -0500", hash_original_method = "5D4B10CEEF902A15EE482FB7322F92B2", hash_generated_method = "05EA587265C5DA8650C5DD9F2E66D93D")
    
public static ResponseCache getDefault() {
        return defaultResponseCache;
    }

    /**
     * Sets the system's default response cache. Use null to remove the response cache.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.196 -0500", hash_original_method = "A6312AA15E9F855E4D8376956298FCD0", hash_generated_method = "CEC571B0C62F629A8E3121E8BCD5722A")
    
public static void setDefault(ResponseCache responseCache) {
        defaultResponseCache = responseCache;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.191 -0500", hash_original_field = "9B2F073A0D6F42DE90512B4B2699D03D", hash_generated_field = "977723D7A34AC2663C01851D0C5635D6")

    private static ResponseCache defaultResponseCache = null;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:51.356 -0400", hash_original_method = "D16C43EEDC21B64FF5979CBD3059BA6B", hash_generated_method = "D16C43EEDC21B64FF5979CBD3059BA6B")
    public ResponseCache ()
    {
        //Synthesized constructor
    }

    /**
     * Returns the cached response corresponding to the given request.
     *
     * @param uri
     *            the request URI.
     * @param requestMethod
     *            the request method.
     * @param requestHeaders
     *            a map of request headers.
     * @return the {@code CacheResponse} object if the request is available in the cache
     *         or {@code null} otherwise.
     * @throws IOException
     *             if an I/O error occurs while getting the cached data.
     * @throws IllegalArgumentException
     *             if any one of the parameters is set to {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.200 -0500", hash_original_method = "1EDD2E6CBFE8528F203F73FF29C1DE1D", hash_generated_method = "CA4D91334F9FE7CDA25A7203F5064D8C")
    
public abstract CacheResponse get(URI uri, String requestMethod,
            Map<String, List<String>> requestHeaders) throws IOException;

    /**
     * Allows the protocol handler to cache data after retrieving resources. The
     * {@code ResponseCache} decides whether the resource data should be cached
     * or not. If so, this method returns a {@code CacheRequest} to write the
     * resource data to. Otherwise, this method returns {@code null}.
     *
     * @param uri
     *            the reference to the requested resource.
     * @param connection
     *            the connection to fetch the response.
     * @return a CacheRequest object with a WriteableByteChannel if the resource
     *         has to be cached, {@code null} otherwise.
     * @throws IOException
     *             if an I/O error occurs while adding the resource.
     * @throws IllegalArgumentException
     *             if any one of the parameters is set to {@code null}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:16.202 -0500", hash_original_method = "7E0EF9B048C955B193FDF9F90BC94741", hash_generated_method = "DC40A35C7A23A4FEF98B3168BB2F5EE1")
    
public abstract CacheRequest put(URI uri, URLConnection connection) throws IOException;
}

