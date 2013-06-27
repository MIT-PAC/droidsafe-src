package org.apache.http.impl.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:16.832 -0400", hash_original_method = "1DA9FA2C2AD0E745701D10A4EA37C418", hash_generated_method = "E092FBE55E76DDEDFBA5487FA81CE750")
    public  SocketOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Socket may not be null");
        } //End block
        init(socket.getOutputStream(), 8192, params);
        addTaint(socket.getTaint());
        addTaint(buffersize);
        addTaint(params.getTaint());
        // ---------- Original Method ----------
        //if (socket == null) {
            //throw new IllegalArgumentException("Socket may not be null");
        //}
        //init(socket.getOutputStream(), 8192, params);
    }

    
}

