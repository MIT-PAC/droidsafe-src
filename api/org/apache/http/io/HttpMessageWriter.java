package org.apache.http.io;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

public interface HttpMessageWriter {
    
    void write(HttpMessage message)
        throws IOException, HttpException;
    
}
