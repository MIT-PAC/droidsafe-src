package org.apache.http.io;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HttpTransportMetrics {
    
    
    long getBytesTransferred(); 
    
    
    void reset();
    
}
