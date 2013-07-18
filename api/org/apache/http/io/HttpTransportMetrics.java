package org.apache.http.io;

// Droidsafe Imports

public interface HttpTransportMetrics {
    
    
    long getBytesTransferred(); 
    
    
    void reset();
    
}
