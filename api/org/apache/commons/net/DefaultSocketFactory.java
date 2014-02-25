/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/***
 * DefaultSocketFactory implements the SocketFactory interface by
 * simply wrapping the java.net.Socket and java.net.ServerSocket
 * constructors.  It is the default SocketFactory used by
 * {@link org.apache.commons.net.SocketClient}
 * implementations.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SocketFactory
 * @see SocketClient
 * @see SocketClient#setSocketFactory
 ***/

public class DefaultSocketFactory implements SocketFactory
{

    /***
     * Creates a Socket connected to the given host and port.
     * <p>
     * @param host The hostname to connect to.
     * @param port The port to connect to.
     * @return A Socket connected to the given host and port.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     * @exception IOException If an I/O error occurs while creating the Socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.921 -0500", hash_original_method = "E3C08730060A1DB913261948D34028DD", hash_generated_method = "68F04B570EA7F496BBE3356F541FB81C")
    
public Socket createSocket(String host, int port)
    throws UnknownHostException, IOException
    {
        return new Socket(host, port);
    }

    /***
     * Creates a Socket connected to the given host and port.
     * <p>
     * @param address The address of the host to connect to.
     * @param port The port to connect to.
     * @return A Socket connected to the given host and port.
     * @exception IOException If an I/O error occurs while creating the Socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.924 -0500", hash_original_method = "06342840B51BA72C757680F9FE102AFC", hash_generated_method = "D6FFC4235218375704698D3AC22AB6DF")
    
public Socket createSocket(InetAddress address, int port)
    throws IOException
    {
        return new Socket(address, port);
    }

    /***
     * Creates a Socket connected to the given host and port and
     * originating from the specified local address and port.
     * <p>
     * @param host The hostname to connect to.
     * @param port The port to connect to.
     * @param localAddr  The local address to use.
     * @param localPort  The local port to use.
     * @return A Socket connected to the given host and port.
     * @exception UnknownHostException  If the hostname cannot be resolved.
     * @exception IOException If an I/O error occurs while creating the Socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.927 -0500", hash_original_method = "1ED0E7CC3A3DEA87A3E7770AD1F18412", hash_generated_method = "8C2CA31FBA0C0203186E50F29FFA6A8F")
    
public Socket createSocket(String host, int port,
                               InetAddress localAddr, int localPort)
    throws UnknownHostException, IOException
    {
        return new Socket(host, port, localAddr, localPort);
    }

    /***
     * Creates a Socket connected to the given host and port and
     * originating from the specified local address and port.
     * <p>
     * @param address The address of the host to connect to.
     * @param port The port to connect to.
     * @param localAddr  The local address to use.
     * @param localPort  The local port to use.
     * @return A Socket connected to the given host and port.
     * @exception IOException If an I/O error occurs while creating the Socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.930 -0500", hash_original_method = "C6B41426A404CA21E11CAC8C87CD14A9", hash_generated_method = "D555261B8552AD64E58ADC3D88FA70D5")
    
public Socket createSocket(InetAddress address, int port,
                               InetAddress localAddr, int localPort)
    throws IOException
    {
        return new Socket(address, port, localAddr, localPort);
    }

    /***
     * Creates a ServerSocket bound to a specified port.  A port
     * of 0 will create the ServerSocket on a system-determined free port.
     * <p>
     * @param port  The port on which to listen, or 0 to use any free port.
     * @return A ServerSocket that will listen on a specified port.
     * @exception IOException If an I/O error occurs while creating
     *                        the ServerSocket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.933 -0500", hash_original_method = "097C287FD25A56D7F8F92140BF3438EE", hash_generated_method = "0295F9A01FC85527786027CA6436B158")
    
public ServerSocket createServerSocket(int port) throws IOException
    {
        return new ServerSocket(port);
    }

    /***
     * Creates a ServerSocket bound to a specified port with a given
     * maximum queue length for incoming connections.  A port of 0 will
     * create the ServerSocket on a system-determined free port.
     * <p>
     * @param port  The port on which to listen, or 0 to use any free port.
     * @param backlog  The maximum length of the queue for incoming connections.
     * @return A ServerSocket that will listen on a specified port.
     * @exception IOException If an I/O error occurs while creating
     *                        the ServerSocket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.937 -0500", hash_original_method = "3D1593377407708784326DC2078D0103", hash_generated_method = "10FCFFA6DE7275B391E4D816E1D0E21F")
    
public ServerSocket createServerSocket(int port, int backlog)
    throws IOException
    {
        return new ServerSocket(port, backlog);
    }

    /***
     * Creates a ServerSocket bound to a specified port on a given local
     * address with a given maximum queue length for incoming connections.
     * A port of 0 will
     * create the ServerSocket on a system-determined free port.
     * <p>
     * @param port  The port on which to listen, or 0 to use any free port.
     * @param backlog  The maximum length of the queue for incoming connections.
     * @param bindAddr  The local address to which the ServerSocket should bind.
     * @return A ServerSocket that will listen on a specified port.
     * @exception IOException If an I/O error occurs while creating
     *                        the ServerSocket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.940 -0500", hash_original_method = "CE809ED990CA285407261837C22B5422", hash_generated_method = "1AADAE22D2753B0B40FBB90B996F33ED")
    
public ServerSocket createServerSocket(int port, int backlog,
                                           InetAddress bindAddr)
    throws IOException
    {
        return new ServerSocket(port, backlog, bindAddr);
    }
}
