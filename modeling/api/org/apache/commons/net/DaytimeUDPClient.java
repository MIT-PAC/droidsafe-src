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
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/***
 * The DaytimeUDPClient class is a UDP implementation of a client for the
 * Daytime protocol described in RFC 867.  To use the class, merely
 * open a local datagram socket with
 * {@link org.apache.commons.net.DatagramSocketClient#open  open }
 * and call {@link #getTime  getTime } to retrieve the daytime
 * string, then
 * call {@link org.apache.commons.net.DatagramSocketClient#close  close }
 * to close the connection properly.  Unlike
 * {@link org.apache.commons.net.DaytimeTCPClient},
 * successive calls to {@link #getTime  getTime } are permitted
 * without re-establishing a connection.  That is because UDP is a
 * connectionless protocol and the Daytime protocol is stateless.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DaytimeTCPClient
 ***/

public final class DaytimeUDPClient extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.597 -0500", hash_original_field = "31EEA5CACB483220DD88DFF45D265DD5", hash_generated_field = "630E125A56F4BF12B075A0A50A0AC8A5")

    public static final int DEFAULT_PORT = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.601 -0500", hash_original_field = "29F34D6BE5B29D0CB468424E007E2F54", hash_generated_field = "AC10216B203C9587F86A5B36EA79D84B")


    private byte[] __dummyData = new byte[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.606 -0500", hash_original_field = "A7543B5E7380AAE2B5DAC3CFC6CCA5CC", hash_generated_field = "947D73EBF5E21AB2C49B65F3B5EC4B85")

    private byte[] __timeData = new byte[256];

    /***
     * Retrieves the time string from the specified server and port and
     * returns it.
     * <p>
     * @param host The address of the server.
     * @param port The port of the service.
     * @return The time string.
     * @exception IOException If an error occurs while retrieving the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.609 -0500", hash_original_method = "AE9659E7D211E4445F0DD1A00457BDBB", hash_generated_method = "D32B4075FB0DC163643F89D144434F0E")
    
public String getTime(InetAddress host, int port) throws IOException
    {
        DatagramPacket sendPacket, receivePacket;

        sendPacket =
            new DatagramPacket(__dummyData, __dummyData.length, host, port);
        receivePacket = new DatagramPacket(__timeData, __timeData.length);

        _socket_.send(sendPacket);
        _socket_.receive(receivePacket);

        return new String(receivePacket.getData(), 0, receivePacket.getLength());
    }

    /*** Same as <code>getTime(host, DaytimeUDPClient.DEFAULT_PORT);</code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.613 -0500", hash_original_method = "0EA455D24328679076027346FF2DF644", hash_generated_method = "346081750DBCDF2387CADC0C50A7285E")
    
public String getTime(InetAddress host) throws IOException
    {
        return getTime(host, DEFAULT_PORT);
    }

}

