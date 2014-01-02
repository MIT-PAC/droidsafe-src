package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;





public abstract class CacheRequest {

    /**
     * This implementation does nothing.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.208 -0500", hash_original_method = "EF935F4A27F0AD3C6EAFD085021C924B", hash_generated_method = "85DB54FA4E841108F707942963E84F89")
    
public CacheRequest() {
    }

    /**
     * Aborts the current cache operation. If an {@code IOException} occurs
     * while reading the response or writing resource data to the cache, the
     * current cache store operation is aborted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.211 -0500", hash_original_method = "1FFF85D2B99366704DF7B68C63810E9A", hash_generated_method = "497794C45780098437438798A00821F0")
    
public abstract void abort();

    /**
     * Returns an {@code OutputStream} which is used to write the response body.
     *
     * @return an {@code OutputStream} which is used to write the response body.
     * @throws IOException
     *             if an I/O error is encountered during writing response body
     *             operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:11.213 -0500", hash_original_method = "B81ACDAD971E33A4DC945821187CD1BF", hash_generated_method = "8FC46DDF1D15241976B7C944E220004D")
    
public abstract OutputStream getBody() throws IOException;

    
}

