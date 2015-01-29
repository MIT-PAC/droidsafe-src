package gov.nist.core.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public interface NetworkLayer {
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public ServerSocket createServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SSLServerSocket createSSLServerSocket(int port, int backlog,
            InetAddress bindAddress) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Socket createSocket(InetAddress address, int port) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public Socket createSocket(InetAddress address, int port,
                    InetAddress myAddress, int myPort)
        throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SSLSocket createSSLSocket(InetAddress address, int port) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public SSLSocket createSSLSocket(InetAddress address, int port, InetAddress localAddress) throws IOException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public DatagramSocket createDatagramSocket() throws SocketException;
    
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public DatagramSocket createDatagramSocket(int port, InetAddress laddr)
            throws SocketException;

}
