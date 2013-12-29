package javax.net.ssl;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;





public abstract class SSLSocket extends Socket {

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP socket.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.172 -0500", hash_original_method = "65A9306BD8ABF19429A09B81D2DB8751", hash_generated_method = "79C24DC7FBEDF6FC9189D433464AE63B")
    protected SSLSocket() {
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP socket connection to the specified host at the specified
     * port.
     *
     * @param host
     *            the host name to connect to.
     * @param port
     *            the port number to connect to.
     * @throws IOException
     *             if creating the socket fails.
     * @throws UnknownHostException
     *             if the specified host is not known.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.173 -0500", hash_original_method = "7A9B2251249D4A1F85A734BE270C0240", hash_generated_method = "56827ADB3FC9F1133B4C327EC8FD8250")
    protected SSLSocket(String host, int port) throws IOException, UnknownHostException {
        super(host, port);
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP socket connection to the specified address at the specified
     * port.
     *
     * @param address
     *            the address to connect to.
     * @param port
     *            the port number to connect to.
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.174 -0500", hash_original_method = "E1BBFC80ACA37B77A62FE55F8E5644EC", hash_generated_method = "02F6A23E4908270BBEE10ABB5513A8F3")
    protected SSLSocket(InetAddress address, int port) throws IOException {
        super(address, port);
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP socket connection to the specified host at the specified
     * port with the client side bound to the specified address and port.
     *
     * @param host
     *            the host name to connect to.
     * @param port
     *            the port number to connect to.
     * @param clientAddress
     *            the client address to bind to
     * @param clientPort
     *            the client port number to bind to.
     * @throws IOException
     *             if creating the socket fails.
     * @throws UnknownHostException
     *             if the specified host is not known.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.175 -0500", hash_original_method = "A98E3D3F4703F52B86E74E8B006B047C", hash_generated_method = "F94C2ABC483A9F1A0B00B8F9F0839B05")
    protected SSLSocket(String host, int port, InetAddress clientAddress, int clientPort)
            throws IOException, UnknownHostException {
        super(host, port, clientAddress, clientPort);
    }

    /**
     * Only to be used by subclasses.
     * <p>
     * Creates a TCP socket connection to the specified address at the specified
     * port with the client side bound to the specified address and port.
     *
     * @param address
     *            the address to connect to.
     * @param port
     *            the port number to connect to.
     * @param clientAddress
     *            the client address to bind to.
     * @param clientPort
     *            the client port number to bind to.
     * @throws IOException
     *             if creating the socket fails.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.176 -0500", hash_original_method = "0B70D3C7F543DCBA51EA559CD021E805", hash_generated_method = "A94FA805013A9A40525A32FAE3664F98")
    protected SSLSocket(InetAddress address, int port, InetAddress clientAddress, int clientPort)
            throws IOException {
        super(address, port, clientAddress, clientPort);
    }

    /**
     * Unsupported for SSL because reading from an SSL socket may require
     * writing to the network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.177 -0500", hash_original_method = "E0A9F4BE9C470EB91D47ECD4E4371B30", hash_generated_method = "B08BF9FD6A8594D256B74001AAB3CC0C")
    @Override
public void shutdownInput() throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported for SSL because writing to an SSL socket may require reading
     * from the network.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.178 -0500", hash_original_method = "70C01DEF86829F68F838E9F8223EE1C9", hash_generated_method = "C660A4FDE54A073E97068B4FD92F16CB")
    @Override
public void shutdownOutput() throws IOException {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns the names of the supported cipher suites.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.179 -0500", hash_original_method = "972B577B4B04B597248145E0CF6E63D2", hash_generated_method = "09D1FF6565C262832AA989BA28390929")
    public abstract String[] getSupportedCipherSuites();

    /**
     * Returns the names of the enabled cipher suites.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.180 -0500", hash_original_method = "BB75297504ED13529514C3177F090190", hash_generated_method = "061445B26CADFE8B5CD047D7521151EC")
    public abstract String[] getEnabledCipherSuites();

    /**
     * Sets the names of the cipher suites to be enabled.
     * Only cipher suites returned by {@link #getSupportedCipherSuites()} are
     * allowed.
     *
     * @param suites
     *            the names of the to be enabled cipher suites.
     * @throws IllegalArgumentException
     *             if one of the cipher suite names is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.180 -0500", hash_original_method = "84F6E139E9DDF1E455EB26E1B318EBF4", hash_generated_method = "F9805BBF1FBBA5E941AC2541C0C38322")
    public abstract void setEnabledCipherSuites(String[] suites);

    /**
     * Returns the names of the supported protocols.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.181 -0500", hash_original_method = "3FD91F76BC51E9E2EDFCF4A896BF5E5E", hash_generated_method = "A3356A4404800F82B6EC4AE3BBD1CECE")
    public abstract String[] getSupportedProtocols();

    /**
     * Returns the names of the enabled protocols.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.182 -0500", hash_original_method = "32F4E828AC8F445B64955C86B1AFEAEB", hash_generated_method = "5E4CEFAED414B7670ED014CA834938CE")
    public abstract String[] getEnabledProtocols();

    /**
     * Sets the names of the protocols to be enabled. Only
     * protocols returned by {@link #getSupportedProtocols()} are allowed.
     *
     * @param protocols
     *            the names of the to be enabled protocols.
     * @throws IllegalArgumentException
     *             if one of the protocols is not supported.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.183 -0500", hash_original_method = "190265461F98EDDDF9AC6C5332C503B2", hash_generated_method = "30F0BE37EC8F79FDE8B6CE44A0863F4E")
    public abstract void setEnabledProtocols(String[] protocols);

    /**
     * Returns the {@code SSLSession} for this connection. If necessary, a
     * handshake will be initiated, in which case this method will block until the handshake
     * has been established. If the handshake fails, an invalid session object
     * will be returned.
     *
     * @return the session object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.184 -0500", hash_original_method = "532A0CA5E04090EDD94B248F925615EE", hash_generated_method = "83FB733144EA2670CC9BAF632B24E628")
    public abstract SSLSession getSession();

    /**
     * Registers the specified listener to receive notification on completion of a
     * handshake on this connection.
     *
     * @param listener
     *            the listener to register.
     * @throws IllegalArgumentException
     *             if {@code listener} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.184 -0500", hash_original_method = "7F527421AD79EE7BA716B1118B2C4D19", hash_generated_method = "FDF00289C8E2F7B88508208BAA55B783")
    public abstract void addHandshakeCompletedListener(HandshakeCompletedListener listener);

    /**
     * Removes the specified handshake completion listener.
     *
     * @param listener
     *            the listener to remove.
     * @throws IllegalArgumentException
     *             if the specified listener is not registered or {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.185 -0500", hash_original_method = "49070ABB4D1EE67E37F12EA39A05F12D", hash_generated_method = "9F23BC28440600C245FC79F216E7AB56")
    public abstract void removeHandshakeCompletedListener(HandshakeCompletedListener listener);

    /**
     * Starts a new SSL handshake on this connection.
     *
     * @throws IOException
     *             if an error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.186 -0500", hash_original_method = "58FD0B1F324B16B56A92D9386BBD40E4", hash_generated_method = "955A866F6C77828E7E4BE899587FE91A")
    public abstract void startHandshake() throws IOException;

    /**
     * Sets whether this connection should act in client mode when handshaking.
     *
     * @param mode
     *            {@code true} if this connection should act in client mode,
     *            {@code false} if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.187 -0500", hash_original_method = "19AAB4420CED9244333FFE885F8E0B37", hash_generated_method = "AFBE53D3CEDD2FF26833A764AB296F02")
    public abstract void setUseClientMode(boolean mode);

    /**
     * Returns true if this connection will act in client mode when handshaking.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.188 -0500", hash_original_method = "B2F0A693CA367F13693D6A3367E86206", hash_generated_method = "D17191517DC8ACFD56AD0AE6AA8D5B97")
    public abstract boolean getUseClientMode();

    /**
     * Sets whether the server should require client authentication. This
     * does not apply to sockets in {@link #getUseClientMode() client mode}.
     * Client authentication is one of the following:
     * <ul>
     * <li>authentication required</li>
     * <li>authentication requested</li>
     * <li>no authentication needed</li>
     * </ul>
     * This method overrides the setting of {@link #setWantClientAuth(boolean)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.188 -0500", hash_original_method = "12E2718447E521BB2126CF41CA343554", hash_generated_method = "BFF0A42DB80B794FF8EACD8B0D363AFE")
    public abstract void setNeedClientAuth(boolean need);

    /**
     * Sets whether the server should request client authentication. Unlike
     * {@link #setNeedClientAuth} this won't stop the negotiation if the client
     * doesn't authenticate. This does not apply to sockets in {@link
     * #getUseClientMode() client mode}.The client authentication is one of:
     * <ul>
     * <li>authentication required</li>
     * <li>authentication requested</li>
     * <li>no authentication needed</li>
     * </ul>
     * This method overrides the setting of {@link #setNeedClientAuth(boolean)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.189 -0500", hash_original_method = "356948DA3BA53E1DF3CFAAEFCCB304EC", hash_generated_method = "F842593770E8FDE5B25EAE8AEA1A73A2")
    public abstract void setWantClientAuth(boolean want);

    /**
     * Returns true if the server socket should require client authentication.
     * This does not apply to sockets in {@link #getUseClientMode() client
     * mode}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.190 -0500", hash_original_method = "18D8E87E8269449773EEAF111DE0F33F", hash_generated_method = "84AFAA836C2B9FD9D30E6C8E29EDA240")
    public abstract boolean getNeedClientAuth();

    /**
     * Returns true if the server should request client authentication. This
     * does not apply to sockets in {@link #getUseClientMode() client mode}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.191 -0500", hash_original_method = "6ABFE23F3A3B3813808D701D9CDD5E9C", hash_generated_method = "1E5ADAC3870F0177C238FC2ED806960E")
    public abstract boolean getWantClientAuth();

    /**
     * Sets whether new SSL sessions may be created by this socket or if
     * existing sessions must be reused. If {@code flag} is false and there are
     * no sessions to resume, handshaking will fail.
     *
     * @param flag {@code true} if new sessions may be created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.192 -0500", hash_original_method = "C22D69DDD073F51A676C7AA37CECE077", hash_generated_method = "6A8A708293722AAF79D6E19A89EDCF3F")
    public abstract void setEnableSessionCreation(boolean flag);

    /**
     * Returns whether new SSL sessions may be created by this socket or if
     * existing sessions must be reused.
     *
     * @return {@code true} if new sessions may be created, otherwise
     *         {@code false}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.192 -0500", hash_original_method = "A0E2936040B850370E4431895BC97980", hash_generated_method = "367C53128C1B81ADB8CCA01DBCE35F10")
    public abstract boolean getEnableSessionCreation();

    /**
     * Returns a new SSLParameters based on this SSLSocket's current
     * cipher suites, protocols, and client authentication settings.
     *
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.193 -0500", hash_original_method = "B1069FA99460064F4DAFA14459B677AD", hash_generated_method = "E49272E6A5C5F4C5B789C28E3A1AD325")
    public SSLParameters getSSLParameters() {
        SSLParameters p = new SSLParameters();
        p.setCipherSuites(getEnabledCipherSuites());
        p.setProtocols(getEnabledProtocols());
        p.setNeedClientAuth(getNeedClientAuth());
        p.setWantClientAuth(getWantClientAuth());
        return p;
    }

    /**
     * Sets various SSL handshake parameters based on the SSLParameter
     * argument. Specifically, sets the SSLSocket's enabled cipher
     * suites if the parameter's cipher suites are non-null. Similarly
     * sets the enabled protocols. If the parameters specify the want
     * or need for client authentication, those requirements are set
     * on the SSLSocket, otherwise both are set to false.
     * @since 1.6
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:29.194 -0500", hash_original_method = "886AE080148D5E5D7C66238C628CC678", hash_generated_method = "B59D430B54A9E84755CD1B8DE11AFB42")
    public void setSSLParameters(SSLParameters p) {
        String[] cipherSuites = p.getCipherSuites();
        if (cipherSuites != null) {
            setEnabledCipherSuites(cipherSuites);
        }
        String[] protocols = p.getProtocols();
        if (protocols != null) {
            setEnabledProtocols(protocols);
        }
        if (p.getNeedClientAuth()) {
            setNeedClientAuth(true);
        } else if (p.getWantClientAuth()) {
            setWantClientAuth(true);
        } else {
            setWantClientAuth(false);
        }
    }

    
}

