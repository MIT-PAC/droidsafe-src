package org.apache.http.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import org.apache.http.util.CharArrayBuffer;

public interface SessionInputBuffer {
    
    int read(byte[] b, int off, int len) throws IOException; 
    
    int read(byte[] b) throws IOException; 
    
    int read() throws IOException; 
    
    int readLine(CharArrayBuffer buffer) throws IOException;
    
    String readLine() throws IOException;
    
    boolean isDataAvailable(int timeout) throws IOException; 

    HttpTransportMetrics getMetrics();
    
}
