package org.apache.http.io;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public interface HttpTransportMetrics {
    
    
    long getBytesTransferred(); 
    
    
    void reset();
    
}
