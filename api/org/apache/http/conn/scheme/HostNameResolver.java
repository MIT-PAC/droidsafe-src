package org.apache.http.conn.scheme;

// Droidsafe Imports
import java.io.IOException;
import java.net.InetAddress;

public interface HostNameResolver {

    InetAddress resolve (String hostname) throws IOException;

}
