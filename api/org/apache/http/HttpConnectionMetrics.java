package org.apache.http;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public interface HttpConnectionMetrics {

     
    long getRequestCount();
    
     
    long getResponseCount();
    
     
    long getSentBytesCount();
    
     
    long getReceivedBytesCount(); 
    
    
    Object getMetric(String metricName);
    
    
    void reset();
    
}
