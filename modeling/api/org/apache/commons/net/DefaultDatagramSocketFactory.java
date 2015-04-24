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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


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
    @DSComment("Constructor")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
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
    
    @DSVerified("Potentially listening to other socket")
    @DSSpec(DSCat.INTERNET)
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
    
    @DSVerified
    @DSSpec(DSCat.INTERNET)
public DatagramSocket createDatagramSocket(int port, InetAddress laddr)
    throws SocketException
    {
        return new DatagramSocket(port, laddr);
    }
}
