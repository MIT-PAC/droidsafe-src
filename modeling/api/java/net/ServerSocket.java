/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.nio.channels.ServerSocketChannel;

public class ServerSocket {

    /**
     * Sets the server socket implementation factory of this instance. This
     * method may only be invoked with sufficient security privilege and only
     * once during the application lifetime.
     *
     * @param aFactory
     *            the streaming socket factory to be used for further socket
     *            instantiations.
     * @throws IOException
     *             if the factory could not be set or is already set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.860 -0500", hash_original_method = "AD596D4AF4B8C0F4CC7CCD1314618053", hash_generated_method = "A0F82496A72050EBD804B93C615C7799")
    
public static synchronized void setSocketFactory(SocketImplFactory aFactory) throws IOException {
        if (factory != null) {
            throw new SocketException("Factory already set");
        }
        factory = aFactory;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.816 -0500", hash_original_field = "AB6C9C045A1DF9A56309FC181CC7A873", hash_generated_field = "0D50DA6800F2DE564A61761F3E32E3F7")

    private static final int DEFAULT_BACKLOG = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.823 -0500", hash_original_field = "D13BB32EBB2361D82290016DAD496DC0", hash_generated_field = "10D4EEC45D11B59A6B6543CD9427385B")

    static SocketImplFactory factory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.818 -0500", hash_original_field = "76382137C184A183F2BF2D8583A90AEC", hash_generated_field = "E5435F593B4B4C544AAC5D578CFF6639")

    private  SocketImpl impl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.825 -0500", hash_original_field = "B2E2EDC9404AD10BB9AF0AC0088343DD", hash_generated_field = "C0B93BC213B673FF2E47783C561E2823")

    private boolean isBound;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.828 -0500", hash_original_field = "FF1318BD7B381B7887A6EEC627EFEF6C", hash_generated_field = "61C76B683BBEFCB5006250611D355A94")

    private boolean isClosed;

    /**
     * Constructs a new unbound {@code ServerSocket}.
     *
     * @throws IOException if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.831 -0500", hash_original_method = "31BB74D5896D397B1327C5B34E5CB836", hash_generated_method = "F6958EEE717C65B2382EA357C50183A7")
    
public ServerSocket() throws IOException {
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        impl.create(true);
    }

    /**
     * Constructs a new {@code ServerSocket} instance bound to the given {@code port}.
     * The backlog is set to 50. If {@code port == 0}, a port will be assigned by the OS.
     *
     * @throws IOException if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.833 -0500", hash_original_method = "17E5A7EAB5FF74551872A5C22051BFB5", hash_generated_method = "B9F823FA7D895103EEFDAF26A9FC01D0")
    
public ServerSocket(int port) throws IOException {
        this(port, DEFAULT_BACKLOG, Inet4Address.ANY);
    }

    /**
     * Constructs a new {@code ServerSocket} instance bound to the given {@code port}.
     * The backlog is set to {@code backlog}.
     * If {@code port == 0}, a port will be assigned by the OS.
     *
     * @throws IOException if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.836 -0500", hash_original_method = "B81C30D251B31CAFF71CF07C7882EF32", hash_generated_method = "FCF551FDBEDBC3159E80F30C445BF534")
    
public ServerSocket(int port, int backlog) throws IOException {
        this(port, backlog, Inet4Address.ANY);
    }

    /**
     * Constructs a new {@code ServerSocket} instance bound to the given {@code localAddress}
     * and {@code port}. The backlog is set to {@code backlog}.
     * If {@code localAddress == null}, the ANY address is used.
     * If {@code port == 0}, a port will be assigned by the OS.
     *
     * @throws IOException if an error occurs while creating the socket.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.839 -0500", hash_original_method = "6BB36DC8E15E305D7407A47C7739996C", hash_generated_method = "F776CE6D05038553C1A88DD290C54077")
    
public ServerSocket(int port, int backlog, InetAddress localAddress) throws IOException {
        checkListen(port);
        this.impl = factory != null ? factory.createSocketImpl()
                : new PlainServerSocketImpl();
        InetAddress addr = (localAddress == null) ? Inet4Address.ANY : localAddress;

        synchronized (this) {
            impl.create(true);
            try {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } catch (IOException e) {
                close();
                throw e;
            }
        }
    }

    /**
     * @hide internal use only
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.820 -0500", hash_original_method = "847F07D140851DC7DF04F3DA230B7EED", hash_generated_method = "FAB0479ECF5F05048C7FE7B9B50808FC")
    
public SocketImpl getImpl$() {
        return impl;
    }

    /**
     * Waits for an incoming request and blocks until the connection is opened.
     * This method returns a socket object representing the just opened
     * connection.
     *
     * @return the connection representing socket.
     * @throws IOException
     *             if an error occurs while accepting a new connection.
     */
    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.INTERNET)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.842 -0500", hash_original_method = "DE0153D2AABFEE83527E2EAC5D1F68DF", hash_generated_method = "29F537F9AC7BE50FF7DBE4DBA5831698")
    
public Socket accept() throws IOException {
        checkOpen();
        if (!isBound()) {
            throw new SocketException("Socket is not bound");
        }

        Socket aSocket = new Socket();
        try {
            implAccept(aSocket);
        } catch (IOException e) {
            aSocket.close();
            throw e;
        }
        return aSocket;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.844 -0500", hash_original_method = "C273B8F533783A3DE90657F5715801E0", hash_generated_method = "7E2B6688A6C527ADA19B28987E08F61A")
    
private void checkListen(int aPort) {
        if (aPort < 0 || aPort > 65535) {
            throw new IllegalArgumentException("Port out of range: " + aPort);
        }
    }

    /**
     * Closes this server socket and its implementation. Any attempt to connect
     * to this socket thereafter will fail.
     *
     * @throws IOException
     *             if an error occurs while closing this socket.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.847 -0500", hash_original_method = "8636C7CEC5FFD33F6CBF2C75F9E6A135", hash_generated_method = "49D139305406AB770BC7CB5D3895D434")
    
public void close() throws IOException {
        isClosed = true;
        impl.close();
    }

    /**
     * Gets the local IP address of this server socket or {@code null} if the
     * socket is unbound. This is useful for multihomed hosts.
     *
     * @return the local address of this server socket.
     */
    @DSComment("can learn network device info")
    @DSSpec(DSCat.NETWORK)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.850 -0500", hash_original_method = "0AAA019638F2B2CC41FFEEEB4E260F6C", hash_generated_method = "AD67A3BCA0927F812C6A2C52711C2948")
    
public InetAddress getInetAddress() {
        if (!isBound()) {
            return null;
        }
        return impl.getInetAddress();
    }

    /**
     * Gets the local port of this server socket or {@code -1} if the socket is
     * unbound.
     *
     * @return the local port this server is listening on.
     */
    @DSComment("local port has to be provided, no new info leaking")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.852 -0500", hash_original_method = "F5BB694DF3469EBFBD82064FFB1FEAE0", hash_generated_method = "7757875108A58B1E253356DE798623DA")
    
public int getLocalPort() {
        if (!isBound()) {
            return -1;
        }
        return impl.getLocalPort();
    }

    /**
     * Gets the socket {@link SocketOptions#SO_TIMEOUT accept timeout}.
     *
     * @throws IOException
     *             if the option cannot be retrieved.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.855 -0500", hash_original_method = "37BE74568AC5DDD629C634B42E81BFFA", hash_generated_method = "405F927B58C98C88965016EB5176B58B")
    
public synchronized int getSoTimeout() throws IOException {
        checkOpen();
        return ((Integer) impl.getOption(SocketOptions.SO_TIMEOUT)).intValue();
    }

    /**
     * Invokes the server socket implementation to accept a connection on the
     * given socket {@code aSocket}.
     *
     * @param aSocket
     *            the concrete {@code SocketImpl} to accept the connection
     *            request on.
     * @throws IOException
     *             if the connection cannot be accepted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.858 -0500", hash_original_method = "BFFC5C44CB4D0AB53035D05D9EAC93F6", hash_generated_method = "A8AB60001DACDDF256482E83B1AA528F")
    
protected final void implAccept(Socket aSocket) throws IOException {
        synchronized (this) {
            impl.accept(aSocket.impl);
            aSocket.accepted();
        }
    }

    /**
     * Sets the {@link SocketOptions#SO_TIMEOUT accept timeout} in milliseconds for this socket.
     * This accept timeout defines the period the socket will block waiting to
     * accept a connection before throwing an {@code InterruptedIOException}. The value
     * {@code 0} (default) is used to set an infinite timeout. To have effect
     * this option must be set before the blocking method was called.
     *
     * @param timeout the timeout in milliseconds or 0 for no timeout.
     * @throws SocketException
     *             if an error occurs while setting the option.
     */
    @DSComment("no info leakage")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.863 -0500", hash_original_method = "E2A5F03981AB4BF932E59A553E83FA6F", hash_generated_method = "D11FFBB6E24AFF767E7A4AB1B4A07FDB")
    
public synchronized void setSoTimeout(int timeout) throws SocketException {
        checkOpen();
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout < 0");
        }
        impl.setOption(SocketOptions.SO_TIMEOUT, Integer.valueOf(timeout));
    }

    /**
     * Returns a textual representation of this server socket including the
     * address, port and the state. The port field is set to {@code 0} if there
     * is no connection to the server socket.
     *
     * @return the textual socket representation.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.866 -0500", hash_original_method = "577ACC2D572353EA5861EB3648159EF5", hash_generated_method = "6449E1D40009C093BF2C3A48885041E6")
    
@Override
    public String toString() {
        StringBuilder result = new StringBuilder(64);
        result.append("ServerSocket[");
        if (!isBound()) {
            return result.append("unbound]").toString();
        }
        return result.append("addr=")
                .append(getInetAddress().getHostName()).append("/")
                .append(getInetAddress().getHostAddress()).append(
                        ",port=0,localport=")
                .append(getLocalPort()).append("]")
                .toString();
    }

    /**
     * Binds this server socket to the given local socket address with a maximum
     * backlog of 50 unaccepted connections. If the {@code localAddr} is set to
     * {@code null} the socket will be bound to an available local address on
     * any free port of the system.
     *
     * @param localAddr
     *            the local address and port to bind on.
     * @throws IllegalArgumentException
     *             if the {@code SocketAddress} is not supported.
     * @throws IOException
     *             if the socket is already bound or a problem occurs during
     *             binding.
     */
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO_ACTION_METHOD)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.868 -0500", hash_original_method = "AB1F91AE5F8F2B3C00C4EDCF73D5B4D1", hash_generated_method = "6D8A600A2BA5C00245EE3BF986AC0850")
    
public void bind(SocketAddress localAddr) throws IOException {
        bind(localAddr, DEFAULT_BACKLOG);
    }

    /**
     * Binds this server socket to the given local socket address. If the
     * {@code localAddr} is set to {@code null} the socket will be bound to an
     * available local address on any free port of the system.
     *
     * @param localAddr the local machine address and port to bind on.
     * @param backlog the maximum number of unaccepted connections. Passing 0 or
     *     a negative value yields the default backlog of 50.
     * @throws IllegalArgumentException if the {@code SocketAddress} is not
     *     supported.
     * @throws IOException if the socket is already bound or a problem occurs
     *     during binding.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.871 -0500", hash_original_method = "684D242B2EA0BE4D55F437B908E9CC5D", hash_generated_method = "EAC39C6E1A8A8AE1A6C52CDDCAC68D6A")
    
public void bind(SocketAddress localAddr, int backlog) throws IOException {
        checkOpen();
        if (isBound()) {
            throw new BindException("Socket is already bound");
        }
        int port = 0;
        InetAddress addr = Inet4Address.ANY;
        if (localAddr != null) {
            if (!(localAddr instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Local address not an InetSocketAddress: " +
                        localAddr.getClass());
            }
            InetSocketAddress inetAddr = (InetSocketAddress) localAddr;
            if ((addr = inetAddr.getAddress()) == null) {
                throw new SocketException("Host is unresolved: " + inetAddr.getHostName());
            }
            port = inetAddr.getPort();
        }

        synchronized (this) {
            try {
                impl.bind(addr, port);
                isBound = true;
                impl.listen(backlog > 0 ? backlog : DEFAULT_BACKLOG);
            } catch (IOException e) {
                close();
                throw e;
            }
        }
    }

    /**
     * Gets the local socket address of this server socket or {@code null} if
     * the socket is unbound. This is useful on multihomed hosts.
     *
     * @return the local socket address and port this socket is bound to.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.874 -0500", hash_original_method = "7AD76537AA5A3220834213189640F2E9", hash_generated_method = "B6F6BE40480DB6FDE227D19A9E29325B")
    
public SocketAddress getLocalSocketAddress() {
        if (!isBound()) {
            return null;
        }
        return new InetSocketAddress(getInetAddress(), getLocalPort());
    }

    /**
     * Returns whether this server socket is bound to a local address and port
     * or not.
     *
     * @return {@code true} if this socket is bound, {@code false} otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.876 -0500", hash_original_method = "589AFDD4CA6BF38ABB5F59E26BB3DC6D", hash_generated_method = "A878CB652BF3277F9F7822AB8074E046")
    
public boolean isBound() {
        return isBound;
    }

    /**
     * Returns whether this server socket is closed or not.
     *
     * @return {@code true} if this socket is closed, {@code false} otherwise.
     */
    @DSComment("no action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.878 -0500", hash_original_method = "2EEDDDEB8BA1CD500E3647BC397BF54F", hash_generated_method = "10C0B8E2B9DF49DDBC078E9919A022F7")
    
public boolean isClosed() {
        return isClosed;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.881 -0500", hash_original_method = "8DC54C39C6445BAF3181407C830C5887", hash_generated_method = "7588EA0B4439101A03904302427A4E46")
    
private void checkOpen() throws SocketException {
        if (isClosed()) {
            throw new SocketException("Socket is closed");
        }
    }

    /**
     * Sets the value for the socket option {@code SocketOptions.SO_REUSEADDR}.
     *
     * @param reuse
     *            the socket option setting.
     * @throws SocketException
     *             if an error occurs while setting the option value.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.883 -0500", hash_original_method = "D6CD69E67882E49578E557811A0FC457", hash_generated_method = "F94F3DC09B3E131C2F7D5BA39FFC9336")
    
public void setReuseAddress(boolean reuse) throws SocketException {
        checkOpen();
        impl.setOption(SocketOptions.SO_REUSEADDR, Boolean.valueOf(reuse));
    }

    /**
     * Gets the value of the socket option {@code SocketOptions.SO_REUSEADDR}.
     *
     * @return {@code true} if the option is enabled, {@code false} otherwise.
     * @throws SocketException
     *             if an error occurs while reading the option value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.886 -0500", hash_original_method = "8920D58954E3583481E89192EF874E86", hash_generated_method = "4750294BF903E7A0F86FCB8F7F2519DE")
    
public boolean getReuseAddress() throws SocketException {
        checkOpen();
        return ((Boolean) impl.getOption(SocketOptions.SO_REUSEADDR)).booleanValue();
    }

    /**
     * Sets this socket's {@link SocketOptions#SO_SNDBUF receive buffer size}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.888 -0500", hash_original_method = "4A5F0E88940F2B7162C81724AB1FDFE4", hash_generated_method = "C87F3412CD4ADAA1F2B4D2E022D7A397")
    
public void setReceiveBufferSize(int size) throws SocketException {
        checkOpen();
        if (size < 1) {
            throw new IllegalArgumentException("size < 1");
        }
        impl.setOption(SocketOptions.SO_RCVBUF, Integer.valueOf(size));
    }

    /**
     * Returns this socket's {@link SocketOptions#SO_RCVBUF receive buffer size}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.890 -0500", hash_original_method = "1025A74ACDCA065D38BE1D18813D43DB", hash_generated_method = "E0D1E6777755F89A592BB6B477403B32")
    
public int getReceiveBufferSize() throws SocketException {
        checkOpen();
        return ((Integer) impl.getOption(SocketOptions.SO_RCVBUF)).intValue();
    }

    /**
     * Returns this socket's {@code ServerSocketChannel}, if one exists. A channel is
     * available only if this socket wraps a channel. (That is, you can go from a
     * channel to a socket and back again, but you can't go from an arbitrary socket to a channel.)
     * In practice, this means that the socket must have been created by
     * {@link java.nio.channels.ServerSocketChannel#open}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.893 -0500", hash_original_method = "3D28E6253835634FC7711C1CE3F0C48B", hash_generated_method = "C5E30506A370D3B8F16D8419FD259FD0")
    
public ServerSocketChannel getChannel() {
        return null;
    }

    /**
     * Sets performance preferences for connection time, latency and bandwidth.
     * <p>
     * This method does currently nothing.
     *
     * @param connectionTime
     *            the value representing the importance of a short connecting
     *            time.
     * @param latency
     *            the value representing the importance of low latency.
     * @param bandwidth
     *            the value representing the importance of high bandwidth.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.896 -0500", hash_original_method = "EE4DCDA11944F25F3B6AAA6A92D8AD2F", hash_generated_method = "F246F8DA4A0CBB54D188217F5E7B1DB3")
    
public void setPerformancePreferences(int connectionTime, int latency, int bandwidth) {
        // Our socket implementation only provide one protocol: TCP/IP, so
        // we do nothing for this method
    }
}

