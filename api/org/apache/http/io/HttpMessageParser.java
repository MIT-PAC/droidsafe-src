package org.apache.http.io;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpMessage;

public interface HttpMessageParser {
    
    HttpMessage parse()
        throws IOException, HttpException;

}
