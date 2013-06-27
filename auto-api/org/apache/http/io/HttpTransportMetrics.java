package org.apache.http.io;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public interface HttpTransportMetrics {
    
    
    long getBytesTransferred(); 
    
    
    void reset();
    
}
