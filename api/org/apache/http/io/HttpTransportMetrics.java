package org.apache.http.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpTransportMetrics {
    
    
    long getBytesTransferred(); 
    
    
    void reset();
    
}
