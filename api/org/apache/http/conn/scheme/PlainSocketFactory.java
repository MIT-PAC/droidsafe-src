package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;






public final class PlainSocketFactory implements SocketFactory {
    
    /**
     * Gets the singleton instance of this class.
     * @return the one and only plain socket factory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.255 -0500", hash_original_method = "6DB12A6CB7CE4518D36C52EAD158CA98", hash_generated_method = "A70FFEFA7A5819874C872C5173FBAA64")
    public static PlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.253 -0500", hash_original_field = "785670155C313BBC06D61BCC3C9E481C", hash_generated_field = "65C81C687C7F55312B3A7CFD6F6762B7")

    private static final
        PlainSocketFactory DEFAULT_FACTORY = new PlainSocketFactory();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.254 -0500", hash_original_field = "98B8869502CC5FF944B6B408CA137F17", hash_generated_field = "81E302E459F079F5FBE4C1ED4F82BD8C")


    private  HostNameResolver nameResolver;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.256 -0500", hash_original_method = "0E5BF5873ABF9DF43E8A566F0715555C", hash_generated_method = "221ABB32C60F37DF9135EB5A170910A5")
    public PlainSocketFactory(final HostNameResolver nameResolver) {
        super();
        this.nameResolver = nameResolver;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.257 -0500", hash_original_method = "CB0B0698D5F49CD73D676E27B7E3296D", hash_generated_method = "FCDA984BC8BEAD58F07418DB0D7C98DD")
    public PlainSocketFactory() {
        this(null);
    }

    // non-javadoc, see interface org.apache.http.conn.SocketFactory
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.257 -0500", hash_original_method = "A3A12F6A184479CE87309C0199F9FB19", hash_generated_method = "8E688C07A4933D6FE3996C076C14AB17")
    public Socket createSocket() {
        return new Socket();
    }

    // non-javadoc, see interface org.apache.http.conn.SocketFactory
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.258 -0500", hash_original_method = "3F8F2095BF15D67174F7BEAF65F7911A", hash_generated_method = "3F546C76425FC49B179A7D932399EDBC")
    public Socket connectSocket(Socket sock, String host, int port, 
                                InetAddress localAddress, int localPort,
                                HttpParams params)
        throws IOException {

        if (host == null) {
            throw new IllegalArgumentException("Target host may not be null.");
        }
        if (params == null) {
            throw new IllegalArgumentException("Parameters may not be null.");
        }

        if (sock == null)
            sock = createSocket();

        if ((localAddress != null) || (localPort > 0)) {

            // we need to bind explicitly
            if (localPort < 0)
                localPort = 0; // indicates "any"

            InetSocketAddress isa =
                new InetSocketAddress(localAddress, localPort);
            sock.bind(isa);
        }

        int timeout = HttpConnectionParams.getConnectionTimeout(params);

        InetSocketAddress remoteAddress;
        if (this.nameResolver != null) {
            remoteAddress = new InetSocketAddress(this.nameResolver.resolve(host), port); 
        } else {
            remoteAddress = new InetSocketAddress(host, port);            
        }
        try {
            sock.connect(remoteAddress, timeout);
        } catch (SocketTimeoutException ex) {
            throw new ConnectTimeoutException("Connect to " + remoteAddress + " timed out");
        }
        return sock;

    } // connectSocket


    /**
     * Checks whether a socket connection is secure.
     * This factory creates plain socket connections
     * which are not considered secure.
     *
     * @param sock      the connected socket
     *
     * @return  <code>false</code>
     *
     * @throws IllegalArgumentException if the argument is invalid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.259 -0500", hash_original_method = "7A2A4752679C8696C148A96F8F50755B", hash_generated_method = "DEF466035A4516BA3399AD6AB5C54816")
    public final boolean isSecure(Socket sock)
        throws IllegalArgumentException {

        if (sock == null) {
            throw new IllegalArgumentException("Socket may not be null.");
        }
        // This class check assumes that createSocket() calls the constructor
        // directly. If it was using javax.net.SocketFactory, we couldn't make
        // an assumption about the socket class here.
        if (sock.getClass() != Socket.class) {
            throw new IllegalArgumentException
                ("Socket not created by this factory.");
        }
        // This check is performed last since it calls a method implemented
        // by the argument object. getClass() is final in java.lang.Object.
        if (sock.isClosed()) {
            throw new IllegalArgumentException("Socket is closed.");
        }

        return false;

    } // isSecure


    /**
     * Compares this factory with an object.
     * There is only one instance of this class.
     *
     * @param obj       the object to compare with
     *
     * @return  iff the argument is this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.260 -0500", hash_original_method = "F7B998F5AE180E31090E44B8A03A92F7", hash_generated_method = "08FF0ED30143F58CAB4DEB62E6201927")
    @Override
public boolean equals(Object obj) {
        return (obj == this);
    }

    /**
     * Obtains a hash code for this object.
     * All instances of this class have the same hash code.
     * There is only one instance of this class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.261 -0500", hash_original_method = "EE56C51BBF77F8839109E7F97EF2C650", hash_generated_method = "984A51642E868B1A8453A2229F0FFDDA")
    @Override
public int hashCode() {
        return PlainSocketFactory.class.hashCode();
    }
}

