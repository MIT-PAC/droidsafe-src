package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;

import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;

public interface AbortableHttpRequest {

    
    void setConnectionRequest(ClientConnectionRequest connRequest) throws IOException;
    
    
    void setReleaseTrigger(ConnectionReleaseTrigger releaseTrigger) throws IOException;

    
    void abort();

}
