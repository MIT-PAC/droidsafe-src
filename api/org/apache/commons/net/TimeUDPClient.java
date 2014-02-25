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
import java.util.Date;

/***
 * The TimeUDPClient class is a UDP implementation of a client for the
 * Time protocol described in RFC 868.  To use the class, merely
 * open a local datagram socket with
 * {@link org.apache.commons.net.DatagramSocketClient#open  open }
 * and call {@link #getTime  getTime } or
 * {@link #getTime  getDate } to retrieve the time. Then call
 * {@link org.apache.commons.net.DatagramSocketClient#close  close }
 * to close the connection properly.  Unlike
 * {@link org.apache.commons.net.TimeTCPClient},
 * successive calls to {@link #getTime  getTime } or
 * {@link #getDate  getDate } are permitted
 * without re-establishing a connection.  That is because UDP is a
 * connectionless protocol and the Time protocol is stateless.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see TimeTCPClient
 ***/

public final class TimeUDPClient extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.435 -0500", hash_original_field = "8101C2679DB4F0F0175135696DB7EC25", hash_generated_field = "4EFF224B7A20681D9094BA4684DD0199")

    public static final int DEFAULT_PORT = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.438 -0500", hash_original_field = "2A90E847EED105F91D1800A1E5C82063", hash_generated_field = "D5EAE304595D14C2A32BE27B0C7A7FC4")

    public static final long SECONDS_1900_TO_1970 = 2208988800L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.440 -0500", hash_original_field = "29F34D6BE5B29D0CB468424E007E2F54", hash_generated_field = "AC10216B203C9587F86A5B36EA79D84B")


    private byte[] __dummyData = new byte[1];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.443 -0500", hash_original_field = "85FBC36084A078169B70995718BAD28C", hash_generated_field = "073B452C054E2D56A1EE8137C6AF2A26")

    private byte[] __timeData = new byte[4];

    /***
     * Retrieves the time from the specified server and port and
     * returns it. The time is the number of seconds since
     * 00:00 (midnight) 1 January 1900 GMT, as specified by RFC 868.
     * This method reads the raw 32-bit big-endian
     * unsigned integer from the server, converts it to a Java long, and
     * returns the value.
     * <p>
     * @param host The address of the server.
     * @param port The port of the service.
     * @return The time value retrieved from the server.
     * @exception IOException If an error occurs while retrieving the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.447 -0500", hash_original_method = "82583DDF28473484866591EFD94D68EC", hash_generated_method = "477FA196970833A3FA569A8FD0E075DB")
    
public long getTime(InetAddress host, int port) throws IOException
    {
        long time;
        DatagramPacket sendPacket, receivePacket;

        sendPacket =
            new DatagramPacket(__dummyData, __dummyData.length, host, port);
        receivePacket = new DatagramPacket(__timeData, __timeData.length);

        _socket_.send(sendPacket);
        _socket_.receive(receivePacket);

        time = 0L;
        time |= (((__timeData[0] & 0xff) << 24) & 0xffffffffL);
        time |= (((__timeData[1] & 0xff) << 16) & 0xffffffffL);
        time |= (((__timeData[2] & 0xff) << 8) & 0xffffffffL);
        time |= ((__timeData[3] & 0xff) & 0xffffffffL);

        return time;
    }

    /*** Same as <code> getTime(host, DEFAULT_PORT); </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.451 -0500", hash_original_method = "FB6313A5702A982DC3F475403CFAB8B0", hash_generated_method = "BD431848EFDB4BCBAA1DB7E99B0E1C85")
    
public long getTime(InetAddress host) throws IOException
    {
        return getTime(host, DEFAULT_PORT);
    }


    /***
     * Retrieves the time from the server and returns a Java Date
     * containing the time converted to the local timezone.
     * <p>
     * @param host The address of the server.
     * @param port The port of the service.
     * @return A Date value containing the time retrieved from the server
     *     converted to the local timezone.
     * @exception IOException  If an error occurs while fetching the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.454 -0500", hash_original_method = "669EC5C59EF76538C73334BA45930CA8", hash_generated_method = "2A6A5C08BE9DAAF765421453E1E80948")
    
public Date getDate(InetAddress host, int port) throws IOException
    {
        return new Date((getTime(host, port) - SECONDS_1900_TO_1970)*1000L);
    }


    /*** Same as <code> getTime(host, DEFAULT_PORT); </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.459 -0500", hash_original_method = "816C6C112E18063428130AC63C0C383D", hash_generated_method = "51EB94D2825C3A0ED0B13D17C2498180")
    
public Date getDate(InetAddress host) throws IOException
    {
        return new Date((getTime(host, DEFAULT_PORT) -
                         SECONDS_1900_TO_1970)*1000L);
    }

}

