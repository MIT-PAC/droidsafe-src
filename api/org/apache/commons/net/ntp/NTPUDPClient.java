package org.apache.commons.net.ntp;
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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import org.apache.commons.net.DatagramSocketClient;

/***
 * The NTPUDPClient class is a UDP implementation of a client for the
 * Network Time Protocol (NTP) described in RFC 1305 as well as the
 * Simple Network Time Protocol (SNTP) in RFC-2030. To use the class,
 * merely open a local datagram socket with <a href="#open"> open </a>
 * and call <a href="#getTime"> getTime </a> to retrieve the time. Then call
 * <a href="org.apache.commons.net.DatagramSocketClient.html#close"> close </a>
 * to close the connection properly.
 * Successive calls to <a href="#getTime"> getTime </a> are permitted
 * without re-establishing a connection.  That is because UDP is a
 * connectionless protocol and the Network Time Protocol is stateless.
 *
 * @author Jason Mathews, MITRE Corp
 * @version $Revision: 165675 $ $Date: 2005-05-02 15:09:55 -0500 (Mon, 02 May 2005) $
 ***/

public final class NTPUDPClient extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.605 -0500", hash_original_field = "4248829B91463DDAA82C4098B079ED31", hash_generated_field = "20A981706BB42C0B8C97AB560020ACB7")

    public static final int DEFAULT_PORT = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.611 -0500", hash_original_field = "EB80E317573C03D6E92CC3CE25D20F90", hash_generated_field = "AE17FE994689E8189A3C264ADF119D38")


    private int _version = NtpV3Packet.VERSION_3;

    /***
     * Retrieves the time information from the specified server and port and
     * returns it. The time is the number of miliiseconds since
     * 00:00 (midnight) 1 January 1900 UTC, as specified by RFC 1305.
     * This method reads the raw NTP packet and constructs a <i>TimeInfo</i>
     * object that allows access to all the fields of the NTP message header.
     * <p>
     * @param host The address of the server.
     * @param port The port of the service.
     * @return The time value retrieved from the server.
     * @exception IOException If an error occurs while retrieving the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.618 -0500", hash_original_method = "7FE1D7106B81441300AD21D6A9055E62", hash_generated_method = "A133F7FC6119F0FCB46BF1957D0AC27C")
    
public TimeInfo getTime(InetAddress host, int port) throws IOException
    {
        // if not connected then open to next available UDP port
        if (!isOpen())
        {
            open();
        }

        NtpV3Packet message = new NtpV3Impl();
        message.setMode(NtpV3Packet.MODE_CLIENT);
        message.setVersion(_version);
        DatagramPacket sendPacket = message.getDatagramPacket();
        sendPacket.setAddress(host);
        sendPacket.setPort(port);

        NtpV3Packet recMessage = new NtpV3Impl();
        DatagramPacket receivePacket = recMessage.getDatagramPacket();

        /*
         * Must minimize the time between getting the current time,
         * timestamping the packet, and sending it out which
         * introduces an error in the delay time.
         * No extraneous logging and initializations here !!!
         */
        TimeStamp now = TimeStamp.getCurrentTime();

        // Note that if you do not set the transmit time field then originating time
        // in server response is all 0's which is "Thu Feb 07 01:28:16 EST 2036".
        message.setTransmitTime(now);

        _socket_.send(sendPacket);
        _socket_.receive(receivePacket);

        long returnTime = System.currentTimeMillis();
        // create TimeInfo message container but don't pre-compute the details yet
        TimeInfo info = new TimeInfo(recMessage, returnTime, false);

        return info;
    }

    /***
     * Retrieves the time information from the specified server on the
     * default NTP port and returns it. The time is the number of miliiseconds
     * since 00:00 (midnight) 1 January 1900 UTC, as specified by RFC 1305.
     * This method reads the raw NTP packet and constructs a <i>TimeInfo</i>
     * object that allows access to all the fields of the NTP message header.
     * <p>
     * @param host The address of the server.
     * @return The time value retrieved from the server.
     * @exception IOException If an error occurs while retrieving the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.623 -0500", hash_original_method = "3D445D5063ADF8F68DFD7874E69289E4", hash_generated_method = "022A4929BD0EF062EBCECFA7D5524B13")
    
public TimeInfo getTime(InetAddress host) throws IOException
    {
        return getTime(host, NtpV3Packet.NTP_PORT);
    }

    /***
     * Returns the NTP protocol version number that client sets on request packet
     * that is sent to remote host (e.g. 3=NTP v3, 4=NTP v4, etc.)
     *
     * @return  the NTP protocol version number that client sets on request packet.
     * @see #setVersion(int)
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.628 -0500", hash_original_method = "2BF852CF57A468E27D4BD4E0571C1C8D", hash_generated_method = "C5B20433B9819630EFA6B7138828F615")
    
public int getVersion()
    {
        return _version;
    }

    /***
     * Sets the NTP protocol version number that client sets on request packet
     * communicate with remote host.
     *
     * @param version the NTP protocol version number
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:55.632 -0500", hash_original_method = "86BC9ACCC6893638688708217A8C2019", hash_generated_method = "FB9F10F6DA494DC1519FA4ED0771CC0F")
    
public void setVersion(int version)
    {
        _version = version;
    }

}
