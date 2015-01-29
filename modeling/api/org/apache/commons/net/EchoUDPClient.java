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
import java.net.DatagramPacket;
import java.net.InetAddress;

/***
 * The EchoUDPClient class is a UDP implementation of a client for the
 * Echo protocol described in RFC 862.  To use the class,
 * just open a local UDP port
 * with {@link org.apache.commons.net.DatagramSocketClient#open  open }
 * and call {@link #send  send } to send datagrams to the server,
 * then call {@link #receive  receive } to receive echoes.
 * After you're done echoing data, call
 * {@link org.apache.commons.net.DatagramSocketClient#close  close() }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see EchoTCPClient
 * @see DiscardUDPClient
 ***/

public final class EchoUDPClient extends DiscardUDPClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.470 -0500", hash_original_field = "6E5A2F2B5AF7AC5D2BA5C7D58DEE5511", hash_generated_field = "C5C92617896F89F207846E39CC98C74E")

    public static final int DEFAULT_PORT = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.473 -0500", hash_original_field = "52EE8FFDA3D4900C8C94E7A1CDDED096", hash_generated_field = "E3FB35FB6C11EC7601DE117739C59710")


    private DatagramPacket __receivePacket = new DatagramPacket(new byte[0], 0);

    /***
     * Sends the specified data to the specified server at the default echo
     * port.
     * <p>
     * @param data  The echo data to send.
     * @param length  The length of the data to send.  Should be less than
     *    or equal to the length of the data byte array.
     * @param host  The address of the server.
     * @exception IOException If an error occurs during the datagram send
     *     operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.477 -0500", hash_original_method = "E49393A26F46BBA9E4FCE8FB3A7A7CEB", hash_generated_method = "04D1A691FF8ACA188D2A7A1E7FF1BAE2")
    
public void send(byte[] data, int length, InetAddress host)
    throws IOException
    {
        send(data, length, host, DEFAULT_PORT);
    }


    /*** Same as <code> send(data, data.length, host) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.480 -0500", hash_original_method = "129F7E351048C86B6490303416B23FF4", hash_generated_method = "8A56BEE8B2FB9CBA199B3D2705E15405")
    
public void send(byte[] data, InetAddress host) throws IOException
    {
        send(data, data.length, host, DEFAULT_PORT);
    }


    /***
     * Receives echoed data and returns its length.  The data may be divided
     * up among multiple datagrams, requiring multiple calls to receive.
     * Also, the UDP packets will not necessarily arrive in the same order
     * they were sent.
     * <p>
     * @return  Length of actual data received.
     * @exception IOException If an error occurs while receiving the data.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.483 -0500", hash_original_method = "CEA0E6C41E8B0166BD3ED01845CB7616", hash_generated_method = "2A0DF62DC3D6BDA6FD332746248CC193")
    
public int receive(byte[] data, int length) throws IOException
    {
        __receivePacket.setData(data);
        __receivePacket.setLength(length);
        _socket_.receive(__receivePacket);
        return __receivePacket.getLength();
    }

    /*** Same as <code> receive(data, data.length)</code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:12.486 -0500", hash_original_method = "E56D032C3762790D2A73EF752F48E81C", hash_generated_method = "863F961C11AA7F55CD2263E257F3008A")
    
public int receive(byte[] data) throws IOException
    {
        return receive(data, data.length);
    }

}

