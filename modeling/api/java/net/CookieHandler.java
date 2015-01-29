package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public abstract class CookieHandler {

    /**
     * Returns the system-wide cookie handler or {@code null} if not set.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.128 -0500", hash_original_method = "65064E42240CB41EFD8C79933CC6C8FC", hash_generated_method = "55FAD7BF0BEF4B8C6325DB42E40DDC15")
    
public static CookieHandler getDefault() {
        return systemWideCookieHandler;
    }

    /**
     * Sets the system-wide cookie handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.130 -0500", hash_original_method = "AB3F232505BCF1617B98122211B7FA81", hash_generated_method = "734A52BCED4FD1C1F2414241135412A8")
    
public static void setDefault(CookieHandler cHandler) {
        systemWideCookieHandler = cHandler;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.125 -0500", hash_original_field = "960FE1D0599F5BBCD5F5E9E0F7FBB7E7", hash_generated_field = "8C9BF4ECEE0FD776A81C187004A66852")

    private static CookieHandler systemWideCookieHandler;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.319 -0400", hash_original_method = "88D15E3335299CEFE37CA24D0A89E063", hash_generated_method = "88D15E3335299CEFE37CA24D0A89E063")
    public CookieHandler ()
    {
        //Synthesized constructor
    }

    /**
     * Gets all cookies for a specific URI from the cookie cache.
     *
     * @param uri
     *            a URI to search for applicable cookies.
     * @param requestHeaders
     *            a list of request headers.
     * @return an unchangeable map of all appropriate cookies.
     * @throws IOException
     *             if an error occurs during the I/O operation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.132 -0500", hash_original_method = "D068D18B3D9B47F0EAD824B58CADE291", hash_generated_method = "D2294388951A4DED6ABEA745A3199C15")
    
public abstract Map<String, List<String>> get(URI uri,
            Map<String, List<String>> requestHeaders) throws IOException;

    /**
     * Sets all cookies of a specific URI in the {@code responseHeaders} into
     * the cookie cache.
     *
     * @param uri
     *            the origin URI of the cookies.
     * @param responseHeaders
     *            a list of request headers.
     * @throws IOException
     *             if an error occurs during the I/O operation.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.135 -0500", hash_original_method = "9C8A274D718511DE42A2D4C3B7D23DEA", hash_generated_method = "86CB2FC2AB52984EA96576101B656CCF")
    
public abstract void put(URI uri, Map<String, List<String>> responseHeaders)
            throws IOException;
}

