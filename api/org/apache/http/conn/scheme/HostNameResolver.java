package org.apache.http.conn.scheme;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.net.InetAddress;

public interface HostNameResolver {

    InetAddress resolve (String hostname) throws IOException;

}
