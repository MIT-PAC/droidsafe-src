package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.Socket;

import org.apache.http.params.HttpParams;



public class SocketOutputBuffer extends AbstractSessionOutputBuffer {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:22.374 -0500", hash_original_method = "1DA9FA2C2AD0E745701D10A4EA37C418", hash_generated_method = "1D50A2ADD7E5B5808E84882EDC02D876")
    public SocketOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        if (socket == null) {
            throw new IllegalArgumentException("Socket may not be null");
        }
        // BEGIN android-changed
        // Workaround for http://b/1083103 and http://b/3514259. We take
        // 'buffersize' as a hint in the weakest sense, and always use
        // an 8KiB heap buffer and leave the kernel buffer size alone,
        // trusting the system to have set a network-appropriate default.
        init(socket.getOutputStream(), 8192, params);
        // END android-changed
    }

    
}

