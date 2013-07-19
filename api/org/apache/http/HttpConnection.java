package org.apache.http;

// Droidsafe Imports
import java.io.IOException;

public interface HttpConnection {

    
    public void close() throws IOException;
    
    
    public boolean isOpen();
 
    
    public boolean isStale();
    
    
    void setSocketTimeout(int timeout);
    
    
    int getSocketTimeout();

    
    public void shutdown() throws IOException;
    
    
    HttpConnectionMetrics getMetrics();
    
}
