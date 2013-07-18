package org.apache.http.impl.io;

// Droidsafe Imports
import java.io.IOException;
import java.net.Socket;

import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSGenerator;

public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.649 -0400", hash_original_method = "1DA9FA2C2AD0E745701D10A4EA37C418", hash_generated_method = "999529FA66E8471E2B9F7371CEF1C574")
    public  SocketOutputBuffer(
            final Socket socket,
            int buffersize,
            final HttpParams params) throws IOException {
        super();
        addTaint(params.getTaint());
        addTaint(buffersize);
        addTaint(socket.getTaint());
        if(socket == null)        
        {
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_801183770 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_801183770.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_801183770;
        } //End block
        init(socket.getOutputStream(), 8192, params);
        // ---------- Original Method ----------
        //if (socket == null) {
            //throw new IllegalArgumentException("Socket may not be null");
        //}
        //init(socket.getOutputStream(), 8192, params);
    }

    
}

