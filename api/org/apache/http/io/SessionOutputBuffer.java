package org.apache.http.io;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.util.CharArrayBuffer;

public interface SessionOutputBuffer {

    void write(byte[] b, int off, int len) throws IOException;
    
    void write(byte[] b) throws IOException;
    
    void write(int b) throws IOException;
    
    void writeLine(String s) throws IOException;
    
    void writeLine(CharArrayBuffer buffer) throws IOException;
    
    void flush() throws IOException;
    
    HttpTransportMetrics getMetrics();
    
}
