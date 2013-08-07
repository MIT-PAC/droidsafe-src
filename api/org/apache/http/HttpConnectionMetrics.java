package org.apache.http;

// Droidsafe Imports
import droidsafe.annotations.*;

public interface HttpConnectionMetrics {

     
    long getRequestCount();
    
     
    long getResponseCount();
    
     
    long getSentBytesCount();
    
     
    long getReceivedBytesCount(); 
    
    
    Object getMetric(String metricName);
    
    
    void reset();
    
}
