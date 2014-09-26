/*
 * $HeadURL: http://svn.apache.org/repos/asf/httpcomponents/httpclient/trunk/module-client/src/main/java/org/apache/http/conn/MultihomePlainSocketFactory.java $
 * $Revision: 653041 $
 * $Date: 2008-05-03 03:39:28 -0700 (Sat, 03 May 2008) $
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.conn;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/**
 * Socket factory that implements a simple multi-home fail-over on connect failure, 
 * provided the same hostname resolves to multiple {@link InetAddress}es. Please note
 * the {@link #connectSocket(Socket, String, int, InetAddress, int, HttpParams)}
 * method cannot be reliably interrupted by closing the socket returned by the
 * {@link #createSocket()} method.
 */
public final class MultihomePlainSocketFactory implements SocketFactory {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.042 -0400", hash_original_field = "9972C1EC45A48E4A4388EF7D166E5B0C", hash_generated_field = "DF72F6F87D8FFA4F28F6E1ABF7B7D852")

    private static final
    MultihomePlainSocketFactory DEFAULT_FACTORY = new MultihomePlainSocketFactory();

    /**
     * Gets the singleton instance of this class.
     * @return the one and only plain socket factory
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.044 -0400", hash_original_method = "DA583B328CDFA53628FC982F32BF620E", hash_generated_method = "74BAF1CD9B5CEFB8BE1783EB24E780E5")
    
public static MultihomePlainSocketFactory getSocketFactory() {
        return DEFAULT_FACTORY;
    }

    /**
     * Restricted default constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.045 -0400", hash_original_method = "E9CEA782F8A9793A206A12509AAAC740", hash_generated_method = "C25F725A4C65DDD6F0E32D2A4837EF15")
    
private MultihomePlainSocketFactory() {
        super();
    }

    // non-javadoc, see interface org.apache.http.conn.SocketFactory
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.047 -0400", hash_original_method = "A3A12F6A184479CE87309C0199F9FB19", hash_generated_method = "8E688C07A4933D6FE3996C076C14AB17")
    
public Socket createSocket() {
        return new Socket();
    }

    /**
     * Attempts to connects the socket to any of the {@link InetAddress}es the 
     * given host name resolves to. If connection to all addresses fail, the  
     * last I/O exception is propagated to the caller.
     * 
     * @param sock socket to connect to any of the given addresses
     * @param host Host name to connect to
     * @param port the port to connect to
     * @param localAddress local address
     * @param localPort local port
     * @param params HTTP parameters 
     * 
     * @throws  IOException if an error occurs during the connection
     * @throws  SocketTimeoutException if timeout expires before connecting
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.049 -0400", hash_original_method = "6D46446EF6BD66B63A697ECD5DD37A53", hash_generated_method = "D7B400F5C6E84E3B3E2EB2238C7614BA")
    
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

        InetAddress[] inetadrs = InetAddress.getAllByName(host);
        List<InetAddress> addresses = new ArrayList<InetAddress>(inetadrs.length);
        addresses.addAll(Arrays.asList(inetadrs));
        Collections.shuffle(addresses);

        IOException lastEx = null;
        for (InetAddress address: addresses) {
            try {
                sock.connect(new InetSocketAddress(address, port), timeout);
                break;
            } catch (SocketTimeoutException ex) {
                throw ex;
            } catch (IOException ex) {
                // create new socket
                sock = new Socket();
                // keep the last exception and retry
                lastEx = ex;
            }
        }
        if (lastEx != null) {
            throw lastEx;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.050 -0400", hash_original_method = "7A2A4752679C8696C148A96F8F50755B", hash_generated_method = "DEF466035A4516BA3399AD6AB5C54816")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.051 -0400", hash_original_method = "F7B998F5AE180E31090E44B8A03A92F7", hash_generated_method = "08FF0ED30143F58CAB4DEB62E6201927")
    
@Override
    public boolean equals(Object obj) {
        return (obj == this);
    }

    /**
     * Obtains a hash code for this object.
     * All instances of this class have the same hash code.
     * There is only one instance of this class.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-08-13 13:14:22.052 -0400", hash_original_method = "EE56C51BBF77F8839109E7F97EF2C650", hash_generated_method = "984A51642E868B1A8453A2229F0FFDDA")
    
@Override
    public int hashCode() {
        return PlainSocketFactory.class.hashCode();
    }

}
