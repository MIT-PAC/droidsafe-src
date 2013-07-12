package org.apache.http.impl.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.Socket;
import org.apache.http.params.HttpParams;

public class SocketOutputBuffer extends AbstractSessionOutputBuffer {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.253 -0400", hash_original_method = "1DA9FA2C2AD0E745701D10A4EA37C418", hash_generated_method = "7F42AE9CE0407D39B269B63E52E66E05")
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
            IllegalArgumentException varCBABC6A96FAFFF53CCBEEA230A20A836_1737955247 = new IllegalArgumentException("Socket may not be null");
            varCBABC6A96FAFFF53CCBEEA230A20A836_1737955247.addTaint(taint);
            throw varCBABC6A96FAFFF53CCBEEA230A20A836_1737955247;
        } 
        init(socket.getOutputStream(), 8192, params);
        
        
            
        
        
    }

    
}

