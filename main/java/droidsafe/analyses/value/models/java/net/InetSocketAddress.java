package droidsafe.analyses.value.models.java.net;

import droidsafe.analyses.value.ValueAnalysisModelingSet;
import droidsafe.analyses.value.ValueAnalysisModeledObject;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisBoolean;
import droidsafe.analyses.value.models.droidsafe.primitives.ValueAnalysisInt;
import droidsafe.analyses.value.models.java.net.InetSocketAddress;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;
import soot.jimple.spark.pag.AllocNode;

public class InetSocketAddress extends ValueAnalysisModeledObject {

    private final Set<String> hostname = new ValueAnalysisModelingSet<String>();

    private final Set<ValueAnalysisInt> port = new ValueAnalysisModelingSet<ValueAnalysisInt>();

    public InetSocketAddress(AllocNode allocNode) {
        super(allocNode);
    }

    /**
     * @hide internal use only
     */
    
    public void _init_() {
        this.port.add(new ValueAnalysisInt(-1));        
        /*
        this.addr = null;
        this.hostname = null;
        this.port = -1;
        */

    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and
     * no specified address. The range for valid port numbers is between 0 and
     * 65535 inclusive.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     */
    
    public void _init_(Set<ValueAnalysisInt> port) {
        this.port.addAll(port);
    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and
     * {@code address}. The range for valid port numbers is between 0 and 65535
     * inclusive. If {@code address} is {@code null} this socket is bound to the
     * IPv4 wildcard address.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     * @param address
     *            the specified address to which this socket is bound.
     */
    
    public void _init_(InetAddress address, Set<ValueAnalysisInt> port) {
        this.hostname.addAll(address.hostName);
        this.port.addAll(port);
        /*
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port=" + port);
        }
        this.addr = (address == null) ? Inet4Address.ANY : address;
        this.hostname = null;
        this.port = port;
        */
    }

    /**
     * Creates a socket endpoint with the given port number {@code port} and the
     * hostname {@code host}. The hostname is tried to be resolved and cannot be
     * {@code null}. The range for valid port numbers is between 0 and 65535
     * inclusive.
     *
     * @param port
     *            the specified port number to which this socket is bound.
     * @param host
     *            the specified hostname to which this socket is bound.
     */
    
    public void _init_(Set<String> host, Set<ValueAnalysisInt> port) {
        this.hostname.addAll(host);
        this.port.addAll(port);
        /*
        this(host, port, true);
        */
    }

    
    void _init_(Set<String> hostname, Set<ValueAnalysisInt> port, Set<ValueAnalysisBoolean> needResolved) {
        this.hostname.addAll(hostname);
        this.port.addAll(port);
        /*
        if (hostname == null || port < 0 || port > 65535) {
            throw new IllegalArgumentException("host=" + hostname + ", port=" + port);
        }
        InetAddress addr = null;
        if (needResolved) {
            try {
                addr = InetAddress.getByName(hostname);
                hostname = null;
            } catch (UnknownHostException ignored) {
            }
        }
        this.addr = addr;
        this.hostname = hostname;
        this.port = port;
        */
    }

    /**
     * Creates an {@code InetSocketAddress} without trying to resolve the
     * hostname into an {@code InetAddress}. The address field is marked as
     * unresolved.
     *
     * @param host
     *            the specified hostname to which this socket is bound.
     * @param port
     *            the specified port number to which this socket is bound.
     * @return the created InetSocketAddress instance.
     * @throws IllegalArgumentException
     *             if the hostname {@code host} is {@code null} or the port is
     *             not in the range between 0 and 65535.
     */
//    
//            modeled=true)
//    public static InetSocketAddress createUnresolved(Set<String> host, Set<ValueAnalysisInt> port) {
//        Set<ValueAnalysisBoolean> bools = new HashSet<ValueAnalysisBoolean>();
//        bools.add(false);
//        InetSocketAddress rval =  new InetSocketAddress();
//        rval._init_(host, port, bools);
//    }

    /**
     * Gets the port number of this socket.
     *
     * @return the socket endpoint port number.
     */
    
    public final Set<ValueAnalysisInt>getPort() {
        return this.port;
        /*
        return port;
        */
    }

    /**
     * Gets the address of this socket.
     *
     * @return the socket endpoint address.
     */
//    
//    public final InetAddress getAddress() {
//        invalidate();
//        return null;
//        /*
//        return addr;
//        */
//    }

    /**
     * Returns the hostname, doing a reverse lookup on the {@code InetAddress} if no
     * hostname string was provided at construction time.
     */
    
    public final Set<String> getHostName() {
        return this.hostname;
        /*
        return (addr != null) ? addr.getHostName() : hostname;
        */
    }

    /**
     * Returns the hostname if known, or the result of {@code InetAddress.getHostAddress}.
     * Unlike {@link #getHostName}, this method will never cause a DNS lookup.
     * @since 1.7
     * @hide 1.7 - remember to add a link in the getHostName documentation!
     */
    
    public final Set<String> getHostString() {
        return this.getHostName();
        /*
        return (hostname != null) ? hostname : addr.getHostAddress();
        */
    }

    /**
     * Returns whether this socket address is unresolved or not.
     *
     * @return {@code true} if this socket address is unresolved, {@code false}
     *         otherwise.
     */
//    
//    public final boolean isUnresolved() {
//        invalidate();
//        return false;
//        /*
//        return addr == null;
//        */
//    }

    /**
     * Gets a string representation of this socket included the address and the
     * port number.
     *
     * @return the address and port number as a textual representation.
     */
//    @Override
//    
//    public String toString() {
//        invalidate();
//        return null;
//        /*
//        return ((addr != null) ? addr.toString() : hostname) + ":" + port;
//        */
//    }

    /**
     * Compares two socket endpoints and returns true if they are equal. Two
     * socket endpoints are equal if the IP address or the hostname of both are
     * equal and they are bound to the same port.
     *
     * @param socketAddr
     *            the object to be tested for equality.
     * @return {@code true} if this socket and the given socket object {@code
     *         socketAddr} are equal, {@code false} otherwise.
     */
//    @Override
//    
//    public final boolean equals(Object socketAddr) {
//        invalidate();
//        return false;
//        /*
//        if (this == socketAddr) {
//            return true;
//        }
//        if (!(socketAddr instanceof InetSocketAddress)) {
//            return false;
//        }
//        InetSocketAddress iSockAddr = (InetSocketAddress) socketAddr;
//        if (port != iSockAddr.port) {
//            return false;
//        }
//        if ((addr == null) && (iSockAddr.addr == null)) {
//            return hostname.equals(iSockAddr.hostname);
//        }
//        if (addr == null) {
//            return false;
//        }
//        return addr.equals(iSockAddr.addr);
//        */
//    }

//    @Override
//    
//    public final int hashCode() {
//        invalidate();
//        return 0;
//        /*
//        if (addr == null) {
//            return hostname.hashCode() + port;
//        }
//        return addr.hashCode() + port;
//        */
//    }

//    
//    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
//        invalidate();
//        /*
//        stream.defaultReadObject();
//        */
//    }
}
