package org.apache.http.client.methods;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.conn.ManagedClientConnection;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;

public interface AbortableHttpRequest {

    
    void setConnectionRequest(ClientConnectionRequest connRequest) throws IOException;
    
    
    void setReleaseTrigger(ConnectionReleaseTrigger releaseTrigger) throws IOException;

    
    void abort();

}
