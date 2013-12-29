package org.apache.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;

public interface HttpClientConnection extends HttpConnection {

    
    boolean isResponseAvailable(int timeout) 
        throws IOException; 
    
    
    void sendRequestHeader(HttpRequest request) 
        throws HttpException, IOException;

    
    void sendRequestEntity(HttpEntityEnclosingRequest request) 
        throws HttpException, IOException;

    
    HttpResponse receiveResponseHeader() 
        throws HttpException, IOException;

    
    void receiveResponseEntity(HttpResponse response) 
        throws HttpException, IOException;
    
    
    void flush() throws IOException;
    
}
