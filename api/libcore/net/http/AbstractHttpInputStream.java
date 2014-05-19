package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheRequest;

import libcore.io.Streams;

abstract class AbstractHttpInputStream extends InputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.945 -0500", hash_original_field = "0A829BC26C36EAF422E245C1EC11D5B0", hash_generated_field = "1EF0A70CD08BE8D63EB2015C913859E5")

    protected  InputStream in;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.947 -0500", hash_original_field = "04E98FAE9CC901E38788E48C2AC65903", hash_generated_field = "A09A97FB50D803FD23447464F21563B5")

    protected  HttpEngine httpEngine;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.950 -0500", hash_original_field = "97A12F2DE32E30A9797715E5B9BFAAFA", hash_generated_field = "B13716E9F9AD1E06D30597F387AAA548")

    private  CacheRequest cacheRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.952 -0500", hash_original_field = "FE0B384B65370AA3619AB548E52F3127", hash_generated_field = "D0AC45CDB02C56E3854DB3EAB2AF3DBC")

    private  OutputStream cacheBody;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.955 -0500", hash_original_field = "0B6D06FC66AB1A3316E7702989E3F923", hash_generated_field = "BA207E645FA463C53A82992C378F82FC")

    protected boolean closed;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.957 -0500", hash_original_method = "6245049C2A6A145F2B06E5BE82F53149", hash_generated_method = "2F21611D4703D793C4636C78A0474625")
    
AbstractHttpInputStream(InputStream in, HttpEngine httpEngine,
            CacheRequest cacheRequest) throws IOException {
        this.in = in;
        this.httpEngine = httpEngine;

        OutputStream cacheBody = cacheRequest != null ? cacheRequest.getBody() : null;

        // some apps return a null body; for compatibility we treat that like a null cache request
        if (cacheBody == null) {
            cacheRequest = null;
        }

        this.cacheBody = cacheBody;
        this.cacheRequest = cacheRequest;
    }

    /**
     * read() is implemented using read(byte[], int, int) so subclasses only
     * need to override the latter.
     */
    @DSSource({DSSourceKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.959 -0500", hash_original_method = "DEBABCFB0D5C81DCE0E37961227F43C9", hash_generated_method = "00E9997F4FCA840224038EEE0C17C5AD")
    
@Override public final int read() throws IOException {
        return Streams.readSingleByte(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.961 -0500", hash_original_method = "9C8C395306DF0EF2B124A9030249421B", hash_generated_method = "BA3B426D1C469E8B524063D3FE13D093")
    
protected final void checkNotClosed() throws IOException {
        if (closed) {
            throw new IOException("stream closed");
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.963 -0500", hash_original_method = "F99DAA756C38E790D14E093C328A014A", hash_generated_method = "53EA44A32FCE521D72E22E3C804E8F8C")
    
protected final void cacheWrite(byte[] buffer, int offset, int count) throws IOException {
        if (cacheBody != null) {
            cacheBody.write(buffer, offset, count);
        }
    }

    /**
     * Closes the cache entry and makes the socket available for reuse. This
     * should be invoked when the end of the body has been reached.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.966 -0500", hash_original_method = "B3EBF796D65123BF085C9E1DA5AFCD9A", hash_generated_method = "0948CF3D7320BE3292D71597EC8123A6")
    
protected final void endOfInput(boolean reuseSocket) throws IOException {
        if (cacheRequest != null) {
            cacheBody.close();
        }
        httpEngine.release(reuseSocket);
    }

    /**
     * Calls abort on the cache entry and disconnects the socket. This
     * should be invoked when the connection is closed unexpectedly to
     * invalidate the cache entry and to prevent the HTTP connection from
     * being reused. HTTP messages are sent in serial so whenever a message
     * cannot be read to completion, subsequent messages cannot be read
     * either and the connection must be discarded.
     *
     * <p>An earlier implementation skipped the remaining bytes, but this
     * requires that the entire transfer be completed. If the intention was
     * to cancel the transfer, closing the connection is the only solution.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:33.969 -0500", hash_original_method = "2A1CD1BA2665856DC3A1B988519977B9", hash_generated_method = "CE8BA60E1C5692E70D3A2BAB3B7030F7")
    
protected final void unexpectedEndOfInput() {
        if (cacheRequest != null) {
            cacheRequest.abort();
        }
        httpEngine.release(false);
    }
    
}

