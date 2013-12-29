package android.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HttpHost;

interface RequestFeeder {

    Request getRequest();
    Request getRequest(HttpHost host);

    
    boolean haveRequest(HttpHost host);

    
    void requeueRequest(Request request);
}
