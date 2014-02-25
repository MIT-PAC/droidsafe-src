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
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/***
 * DefaultDatagramSocketFactory implements the DatagramSocketFactory
 * interface by simply wrapping the java.net.DatagramSocket
 * constructors.  It is the default DatagramSocketFactory used by
 * {@link org.apache.commons.net.DatagramSocketClient}
 *  implementations.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DatagramSocketFactory
 * @see DatagramSocketClient
 * @see DatagramSocketClient#setDatagramSocketFactory
 ***/

public class DefaultDatagramSocketFactory implements DatagramSocketFactory
{

    /***
     * Creates a DatagramSocket on the local host at the first available port.
     * <p>
     * @exception SocketException If the socket could not be created.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.539 -0500", hash_original_method = "58256EB8A7EF88EDEB5E4AD1ABF0E125", hash_generated_method = "23A41768FB0B8E7E2E1730BDCDF4AD35")
    
public DatagramSocket createDatagramSocket() throws SocketException
    {
        return new DatagramSocket();
    }

    /***
     * Creates a DatagramSocket on the local host at a specified port.
     * <p>
     * @param port The port to use for the socket.
     * @exception SocketException If the socket could not be created.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.542 -0500", hash_original_method = "F6DD6C3EA4EC095AD6C456C3C2A4311E", hash_generated_method = "D0173F6A98A344AF92F85E29FE893017")
    
public DatagramSocket createDatagramSocket(int port) throws SocketException
    {
        return new DatagramSocket(port);
    }

    /***
     * Creates a DatagramSocket at the specified address on the local host
     * at a specified port.
     * <p>
     * @param port The port to use for the socket.
     * @param laddr  The local address to use.
     * @exception SocketException If the socket could not be created.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.546 -0500", hash_original_method = "E7765B1F5071215565A877BF624E5F15", hash_generated_method = "48AAD943FA72B2B79BA264EF711FFE29")
    
public DatagramSocket createDatagramSocket(int port, InetAddress laddr)
    throws SocketException
    {
        return new DatagramSocket(port, laddr);
    }
}
