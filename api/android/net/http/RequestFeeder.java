package android.net.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.HttpHost;

interface RequestFeeder {

    Request getRequest();
    Request getRequest(HttpHost host);

    
    boolean haveRequest(HttpHost host);

    
    void requeueRequest(Request request);
}
