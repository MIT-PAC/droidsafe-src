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


package libcore.net.http;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import libcore.io.IoUtils;
import libcore.util.Objects;

import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;

final class HttpConnection {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.691 -0500", hash_original_method = "22C5C5E8E87C7BC2DD06DFD6C9827DA4", hash_generated_method = "6F648DB371387AEA053D3E0EDC51F470")
    
public static HttpConnection connect(URI uri, Proxy proxy, boolean requiresTunnel,
            int connectTimeout) throws IOException {
        /*
         * Try an explicitly-specified proxy.
         */
        if (proxy != null) {
            Address address = (proxy.type() == Proxy.Type.DIRECT)
                    ? new Address(uri)
                    : new Address(uri, proxy, requiresTunnel);
            return HttpConnectionPool.INSTANCE.get(address, connectTimeout);
        }

        /*
         * Try connecting to each of the proxies provided by the ProxySelector
         * until a connection succeeds.
         */
        ProxySelector selector = ProxySelector.getDefault();
        List<Proxy> proxyList = selector.select(uri);
        if (proxyList != null) {
            for (Proxy selectedProxy : proxyList) {
                if (selectedProxy.type() == Proxy.Type.DIRECT) {
                    // the same as NO_PROXY
                    // TODO: if the selector recommends a direct connection, attempt that?
                    continue;
                }
                try {
                    Address address = new Address(uri, selectedProxy, requiresTunnel);
                    return HttpConnectionPool.INSTANCE.get(address, connectTimeout);
                } catch (IOException e) {
                    // failed to connect, tell it to the selector
                    selector.connectFailed(uri, selectedProxy.address(), e);
                }
            }
        }

        /*
         * Try a direct connection. If this fails, this method will throw.
         */
        return HttpConnectionPool.INSTANCE.get(new Address(uri), connectTimeout);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.670 -0500", hash_original_field = "871601D13CF5231EC822D4BA36DD02D2", hash_generated_field = "8E0ACE0F30850C9F1F71EFC5F985F46E")

    private  Address address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.672 -0500", hash_original_field = "5019B3EE05D6098E4ECE32F00F7F88CA", hash_generated_field = "8626E3C3C4BFCB66E8863775B28E01CC")

    private  Socket socket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.675 -0500", hash_original_field = "219F81106B069BE15533E4B7BAC5527C", hash_generated_field = "92444C781A1F5D159CDAA9528EFB69D8")

    private InputStream inputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.677 -0500", hash_original_field = "661AC26F0CF33AB40D90D727DEB87E17", hash_generated_field = "765C7DA707EC84D85188E77508C6D245")

    private OutputStream outputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.679 -0500", hash_original_field = "46B4D17F12A36C17C104C796AAB1EC5A", hash_generated_field = "649CC3E68690FE0D5C49F1CB1C97C793")

    private SSLSocket unverifiedSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.681 -0500", hash_original_field = "AEF574D1FDB94AB7E47AFE01544C161B", hash_generated_field = "CE8322B162FF12735FB871E7AA8B8BA9")

    private SSLSocket sslSocket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.683 -0500", hash_original_field = "B1F147A304419D9F6405EDDB82AC2A06", hash_generated_field = "1135E3111E26F3F567DE353BD59C3E31")

    private InputStream sslInputStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.686 -0500", hash_original_field = "8DF5FD2210D61AF1FEAE9DD88B1AA6A6", hash_generated_field = "A6FD5A356329B1E885E1D97B809AB43D")

    private OutputStream sslOutputStream;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.689 -0500", hash_original_method = "02721492ABE8A93C98AFD47B69F8145D", hash_generated_method = "25A4542E72E5E792F521C3D0E1CD5652")
    
private HttpConnection(Address config, int connectTimeout) throws IOException {
        this.address = config;

        /*
         * Try each of the host's addresses for best behavior in mixed IPv4/IPv6
         * environments. See http://b/2876927
         * TODO: add a hidden method so that Socket.tryAllAddresses can does this for us
         */
        Socket socketCandidate = null;
        InetAddress[] addresses = InetAddress.getAllByName(config.socketHost);
        for (int i = 0; i < addresses.length; i++) {
            socketCandidate = (config.proxy != null && config.proxy.type() != Proxy.Type.HTTP)
                    ? new Socket(config.proxy)
                    : new Socket();
            try {
                socketCandidate.connect(
                        new InetSocketAddress(addresses[i], config.socketPort), connectTimeout);
                break;
            } catch (IOException e) {
                if (i == addresses.length - 1) {
                    throw e;
                }
            }
        }

        this.socket = socketCandidate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.694 -0500", hash_original_method = "50D4F2062BD74B4850A586FC88599309", hash_generated_method = "BCC26FAAEF6069B9C52FBDED3C25C5B6")
    
public void closeSocketAndStreams() {
        IoUtils.closeQuietly(sslOutputStream);
        IoUtils.closeQuietly(sslInputStream);
        IoUtils.closeQuietly(sslSocket);
        IoUtils.closeQuietly(outputStream);
        IoUtils.closeQuietly(inputStream);
        IoUtils.closeQuietly(socket);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.697 -0500", hash_original_method = "8353DEF033DB8B4F652D08F1BE7D5FB2", hash_generated_method = "C85CBCDA24EC8CD174E9D4A52F197AF0")
    
public void setSoTimeout(int readTimeout) throws SocketException {
        socket.setSoTimeout(readTimeout);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.699 -0500", hash_original_method = "97D9B93978E46D1095C2BFB6FD92F6AE", hash_generated_method = "43F3FA3241C577367335938E6D9AF5C7")
    
public OutputStream getOutputStream() throws IOException {
        if (sslSocket != null) {
            if (sslOutputStream == null) {
                sslOutputStream = sslSocket.getOutputStream();
            }
            return sslOutputStream;
        } else if(outputStream == null) {
            outputStream = socket.getOutputStream();
        }
        return outputStream;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.702 -0500", hash_original_method = "1360CB9715FEE0D075363C3EF21DD92C", hash_generated_method = "6F7E230249AD89C9E65BB768166689ED")
    
public InputStream getInputStream() throws IOException {
        if (sslSocket != null) {
            if (sslInputStream == null) {
                sslInputStream = sslSocket.getInputStream();
            }
            return sslInputStream;
        } else if (inputStream == null) {
            /*
             * Buffer the socket stream to permit efficient parsing of HTTP
             * headers and chunk sizes. Benchmarks suggest 128 is sufficient.
             * We cannot buffer when setting up a tunnel because we may consume
             * bytes intended for the SSL socket.
             */
            int bufferSize = 128;
            inputStream = address.requiresTunnel
                    ? socket.getInputStream()
                    : new BufferedInputStream(socket.getInputStream(), bufferSize);
        }
        return inputStream;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.704 -0500", hash_original_method = "EA9CBC15CAAA468AF10BBF1CD02918CF", hash_generated_method = "25CEAAC7C1D353A197B84844D34FA4E6")
    
protected Socket getSocket() {
        return sslSocket != null ? sslSocket : socket;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.706 -0500", hash_original_method = "9472CD13980FF331A1EC2B82F4638C6F", hash_generated_method = "C447D8F3D28FA4B357817DCC39DEFF36")
    
public Address getAddress() {
        return address;
    }

    /**
     * Create an {@code SSLSocket} and perform the SSL handshake
     * (performing certificate validation.
     *
     * @param sslSocketFactory Source of new {@code SSLSocket} instances.
     * @param tlsTolerant If true, assume server can handle common
     * TLS extensions and SSL deflate compression. If false, use
     * an SSL3 only fallback mode without compression.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.709 -0500", hash_original_method = "15C1B21595200C1DF5857AC28380107D", hash_generated_method = "AA9A7875A7CD9C0FE0107FD3F0D2029B")
    
public void setupSecureSocket(SSLSocketFactory sslSocketFactory, boolean tlsTolerant)
            throws IOException {
        // create the wrapper over connected socket
        unverifiedSocket = (SSLSocket) sslSocketFactory.createSocket(socket,
                address.uriHost, address.uriPort, true /* autoClose */);
        // tlsTolerant mimics Chrome's behavior
        if (tlsTolerant && unverifiedSocket instanceof OpenSSLSocketImpl) {
            OpenSSLSocketImpl openSslSocket = (OpenSSLSocketImpl) unverifiedSocket;
            openSslSocket.setEnabledCompressionMethods(new String[] { "ZLIB"});
            openSslSocket.setUseSessionTickets(true);
            openSslSocket.setHostname(address.socketHost);
            // use SSLSocketFactory default enabled protocols
        } else {
            unverifiedSocket.setEnabledProtocols(new String [] { "SSLv3" });
        }
        // force handshake, which can throw
        unverifiedSocket.startHandshake();
    }

    /**
     * Return an {@code SSLSocket} that is not only connected but has
     * also passed hostname verification.
     *
     * @param hostnameVerifier Used to verify the hostname we
     * connected to is an acceptable match for the peer certificate
     * chain of the SSLSession.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.711 -0500", hash_original_method = "E313A7AB78F75EDB07568DFA09A3BF60", hash_generated_method = "4A0C2B76C9FF308E6203F674AF1D00B0")
    
public SSLSocket verifySecureSocketHostname(HostnameVerifier hostnameVerifier)
            throws IOException {
        if (!hostnameVerifier.verify(address.uriHost, unverifiedSocket.getSession())) {
            throw new IOException("Hostname '" + address.uriHost + "' was not verified");
        }
        sslSocket = unverifiedSocket;
        return sslSocket;
    }

    /**
     * Return an {@code SSLSocket} if already connected, otherwise null.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.713 -0500", hash_original_method = "0390CC00C23D2289E08AFB9047DDDB88", hash_generated_method = "84DEC4F76B1FE416005685F168F0560A")
    
public SSLSocket getSecureSocketIfConnected() {
        return sslSocket;
    }

    /**
     * Returns true if the connection is functional. This uses a shameful hack
     * to peek a byte from the socket.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.717 -0500", hash_original_method = "197418179C71EABCF647B3FA4C9F9D3C", hash_generated_method = "5C11BDA1B3A23466E1E33DCD2701C4C8")
    
boolean isStale() throws IOException {
        if (!isEligibleForRecycling()) {
            return true;
        }

        InputStream in = getInputStream();
        if (in.available() > 0) {
            return false;
        }

        Socket socket = getSocket();
        int soTimeout = socket.getSoTimeout();
        try {
            socket.setSoTimeout(1);
            in.mark(1);
            int byteRead = in.read();
            if (byteRead != -1) {
                in.reset();
                return false;
            }
            return true; // the socket is reporting all data read; it's stale
        } catch (SocketTimeoutException e) {
            return false; // the connection is not stale; hooray
        } catch (IOException e) {
            return true; // the connection is stale, the read or soTimeout failed.
        } finally {
            socket.setSoTimeout(soTimeout);
        }
    }

    /**
     * Returns true if this connection is eligible to be recycled. This
     * is like {@link #isStale} except that it doesn't try to actually
     * perform any I/O.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.719 -0500", hash_original_method = "10486D7D4909022462833E73661236C1", hash_generated_method = "5AEDC5A59103A441F8132C3CDEDD2FB9")
    
protected boolean isEligibleForRecycling() {
        return !socket.isClosed()
                && !socket.isInputShutdown()
                && !socket.isOutputShutdown();
    }
    
    public static final class Address {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.722 -0500", hash_original_field = "CA775536D3A7F4013C2E9C464BE24463", hash_generated_field = "EE0BB8F1739D62A5A5C8EDF7D478A66B")

        private  Proxy proxy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.725 -0500", hash_original_field = "4C2C50AE95A53DAB0E5E2FEEFD58397B", hash_generated_field = "07AEE931A3DB127ADD85468783C7312B")

        private  boolean requiresTunnel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.728 -0500", hash_original_field = "046D2A3EC0C079B4C49E3D516E7B84F4", hash_generated_field = "2E25E6A02EC1EA9F050C57679AE98E79")

        private  String uriHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.730 -0500", hash_original_field = "B2B903DA8544D10936DFC02ACC840BB3", hash_generated_field = "E82B694E22483837DC8A7FA45AAFFD3E")

        private  int uriPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.732 -0500", hash_original_field = "8912EDD94314D41C2C58A23D140F9C32", hash_generated_field = "B2FB257AF7E44452ADEDE39DC00B96E5")

        private  String socketHost;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.735 -0500", hash_original_field = "56A8F821D10B01C1EC9E48DE6EC27FB8", hash_generated_field = "B6CE69B75628186CDBBBC00DA03652CE")

        private  int socketPort;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.737 -0500", hash_original_method = "56C3F1DA7938694CED60FE34095C0213", hash_generated_method = "C304839C60144B5791858A366B03A084")
        
public Address(URI uri) {
            this.proxy = null;
            this.requiresTunnel = false;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();
            this.socketHost = uriHost;
            this.socketPort = uriPort;
        }

        /**
         * @param requiresTunnel true if the HTTP connection needs to tunnel one
         *     protocol over another, such as when using HTTPS through an HTTP
         *     proxy. When doing so, we must avoid buffering bytes intended for
         *     the higher-level protocol.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.741 -0500", hash_original_method = "A6C9CB15451FF69F0D42BB48C7372F2F", hash_generated_method = "16352D83DB9DDA1D4992993602850AC6")
        
public Address(URI uri, Proxy proxy, boolean requiresTunnel) {
            this.proxy = proxy;
            this.requiresTunnel = requiresTunnel;
            this.uriHost = uri.getHost();
            this.uriPort = uri.getEffectivePort();

            SocketAddress proxyAddress = proxy.address();
            if (!(proxyAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: "
                        + proxyAddress.getClass());
            }
            InetSocketAddress proxySocketAddress = (InetSocketAddress) proxyAddress;
            this.socketHost = proxySocketAddress.getHostName();
            this.socketPort = proxySocketAddress.getPort();
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.744 -0500", hash_original_method = "19AE87D83FEEE8E799F844F8A7A84495", hash_generated_method = "1834A10F1CD4537F2A71DE81C5EBDAE9")
        
public Proxy getProxy() {
            return proxy;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.746 -0500", hash_original_method = "104FF09B2C80755ABB27A6E9EA994C0B", hash_generated_method = "81E6E1D6639F9FB92DB8CE0541AE64F3")
        
@Override public boolean equals(Object other) {
            if (other instanceof Address) {
                Address that = (Address) other;
                return Objects.equal(this.proxy, that.proxy)
                        && this.uriHost.equals(that.uriHost)
                        && this.uriPort == that.uriPort
                        && this.requiresTunnel == that.requiresTunnel;
            }
            return false;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.749 -0500", hash_original_method = "03AAE27C923B9ECFDFA09DAEE6900F4B", hash_generated_method = "A5810BB01DEE26B460FB545102FD1166")
        
@Override public int hashCode() {
            int result = 17;
            result = 31 * result + uriHost.hashCode();
            result = 31 * result + uriPort;
            result = 31 * result + (proxy != null ? proxy.hashCode() : 0);
            result = 31 * result + (requiresTunnel ? 1 : 0);
            return result;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:30.752 -0500", hash_original_method = "D7960E9C2008885C55D097BA1D2C0C2A", hash_generated_method = "858E0ECAD8EB4C1EA30182550D0944B1")
        
public HttpConnection connect(int connectTimeout) throws IOException {
            return new HttpConnection(this, connectTimeout);
        }
        
    }
    
}

