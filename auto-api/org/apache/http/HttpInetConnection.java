package org.apache.http;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.net.InetAddress;

public interface HttpInetConnection extends HttpConnection {

    InetAddress getLocalAddress();

    int getLocalPort();
    
    InetAddress getRemoteAddress();

    int getRemotePort();
    
}
