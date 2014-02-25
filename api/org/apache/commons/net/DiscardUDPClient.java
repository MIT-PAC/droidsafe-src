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
 * The DiscardUDPClient class is a UDP implementation of a client for the
 * Discard protocol described in RFC 863.  To use the class,
 * just open a local UDP port
 * with {@link org.apache.commons.net.DatagramSocketClient#open  open }
 * and call {@link #send  send } to send datagrams to the server
 * After you're done sending discard data, call
 * {@link org.apache.commons.net.DatagramSocketClient#close  close() }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DiscardTCPClient
 ***/

public class DiscardUDPClient extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.933 -0500", hash_original_field = "9B15D2E0E3A22E5E4DD19692F4A5CB31", hash_generated_field = "2B56E2BB223515B060A405DDC0272D31")

    public static final int DEFAULT_PORT = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.937 -0500", hash_original_field = "91F1DB583CB61BDB6C036D49D41E43F2", hash_generated_field = "91F1DB583CB61BDB6C036D49D41E43F2")


    DatagramPacket _sendPacket;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.942 -0500", hash_original_method = "FF4EC507253E9DA2552C15FE5ECB96ED", hash_generated_method = "9B0D9952F4605AA62C83951E9C71DF87")
    
public DiscardUDPClient()
    {
        _sendPacket = new DatagramPacket(new byte[0], 0);
    }


    /***
     * Sends the specified data to the specified server at the specified port.
     * <p>
     * @param data  The discard data to send.
     * @param length  The length of the data to send.  Should be less than
     *    or equal to the length of the data byte array.
     * @param host  The address of the server.
     * @param port  The service port.
     * @exception IOException If an error occurs during the datagram send
     *            operation.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.947 -0500", hash_original_method = "468639083877010DF76F28D2CCF3941F", hash_generated_method = "0C793579C53BAAFB5D1C7FE4CB20EEA9")
    
public void send(byte[] data, int length, InetAddress host, int port)
    throws IOException
    {
        _sendPacket.setData(data);
        _sendPacket.setLength(length);
        _sendPacket.setAddress(host);
        _sendPacket.setPort(port);
        _socket_.send(_sendPacket);
    }


    /***
     * Same as
     * <code>send(data, length, host. DiscardUDPClient.DEFAULT_PORT)</code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.952 -0500", hash_original_method = "E49393A26F46BBA9E4FCE8FB3A7A7CEB", hash_generated_method = "04D1A691FF8ACA188D2A7A1E7FF1BAE2")
    
public void send(byte[] data, int length, InetAddress host)
    throws IOException
    {
        send(data, length, host, DEFAULT_PORT);
    }


    /***
     * Same as
     * <code>send(data, data.length, host. DiscardUDPClient.DEFAULT_PORT)</code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.957 -0500", hash_original_method = "129F7E351048C86B6490303416B23FF4", hash_generated_method = "8A56BEE8B2FB9CBA199B3D2705E15405")
    
public void send(byte[] data, InetAddress host) throws IOException
    {
        send(data, data.length, host, DEFAULT_PORT);
    }

}

