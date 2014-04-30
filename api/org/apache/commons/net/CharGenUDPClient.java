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
 * The CharGenUDPClient class is a UDP implementation of a client for the
 * character generator protocol described in RFC 864.  It can also be
 * used for Systat (RFC 866), Quote of the Day (RFC 865), and netstat
 * (port 15).  All of these protocols involve sending a datagram to the
 * appropriate port, and reading data contained in one or more reply
 * datagrams.  The chargen and quote of the day protocols only send
 * one reply datagram containing 512 bytes or less of data.  The other
 * protocols may reply with more than one datagram, in which case you
 * must wait for a timeout to determine that all reply datagrams have
 * been sent.
 * <p>
 * To use the CharGenUDPClient class, just open a local UDP port
 * with {@link org.apache.commons.net.DatagramSocketClient#open  open }
 * and call {@link #send  send } to send the datagram that will
 * initiate the data reply.  For chargen or quote of the day, just
 * call {@link #receive  receive }, and you're done.  For netstat and
 * systat, call receive in a while loop, and catch a SocketException and
 * InterruptedIOException to detect a timeout (don't forget to set the
 * timeout duration beforehand).  Don't forget to call
 * {@link org.apache.commons.net.DatagramSocketClient#close  close() }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see CharGenTCPClient
 ***/

public final class CharGenUDPClient extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.949 -0500", hash_original_field = "A3B8BE413FDA372C23A944AE11365486", hash_generated_field = "954938980BA4AB4C625DE283DDF00F79")

    public static final int SYSTAT_PORT = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.952 -0500", hash_original_field = "3F4F334D1B29133FA00F300847CFBDC5", hash_generated_field = "C5BA04F208572CAE023EB53BCD0CC4AE")

    public static final int NETSTAT_PORT = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.955 -0500", hash_original_field = "EE291AD2E9AB1EF343F4926EE2954827", hash_generated_field = "6A4013FBAB6D430863A41E5371ABBF8A")

    public static final int QUOTE_OF_DAY_PORT = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.958 -0500", hash_original_field = "ED27A8DAD675241CE62D0C15E822262A", hash_generated_field = "D80559FB5D8667C300457C9CF0A7ACC9")

    public static final int CHARGEN_PORT = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.961 -0500", hash_original_field = "EE74BAEE584614418BAB3CF1393C909B", hash_generated_field = "DAA90A78B9BDAA68EBF3DB8D0DC6BCBA")

    public static final int DEFAULT_PORT = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.964 -0500", hash_original_field = "140AB95FF05F6D5B0CA471B45F025B51", hash_generated_field = "2BE99DB36337645D32A62863921CB3D2")

    private byte[] __receiveData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.966 -0500", hash_original_field = "45F1278E374F48AF0B2EC2000DE0B25D", hash_generated_field = "98287AAF88C9703D4ED1044852AFFF98")

    private DatagramPacket __receivePacket;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.970 -0500", hash_original_field = "E723241218570CD7AEC713FBDFFF5E11", hash_generated_field = "3AF4DEE3C48C0E73F429FD1284137302")

    private DatagramPacket __sendPacket;

    /***
     * The default CharGenUDPClient constructor.  It initializes some internal
     * data structures for sending and receiving the necessary datagrams for
     * the chargen and related protocols.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.973 -0500", hash_original_method = "1269355D60D7190EAE617D5C71982259", hash_generated_method = "5E1FC5222F1D24E03DD02D8882E1411F")
    
public CharGenUDPClient()
    {
        // CharGen return packets have a maximum length of 512
        __receiveData = new byte[512];
        __receivePacket = new DatagramPacket(__receiveData, 512);
        __sendPacket = new DatagramPacket(new byte[0], 0);
    }

    /***
     * Sends the data initiation datagram.  This data in the packet is ignored
     * by the server, and merely serves to signal that the server should send
     * its reply.
     * <p>
     * @param host The address of the server.
     * @param port The port of the service.
     * @exception IOException If an error occurs while sending the datagram.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.976 -0500", hash_original_method = "24A3E423DE78176900F1058E127BC8B2", hash_generated_method = "5B5F51BF25DAE30DEF4DFB5C781A6B4A")
    
public void send(InetAddress host, int port) throws IOException
    {
        __sendPacket.setAddress(host);
        __sendPacket.setPort(port);
        _socket_.send(__sendPacket);
    }

    /*** Same as <code>send(host, CharGenUDPClient.DEFAULT_PORT);</code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.979 -0500", hash_original_method = "C03B7BA0DE1B470242B235172550195E", hash_generated_method = "7D506C9D568D8CEEB8F867DEA192AADC")
    
public void send(InetAddress host) throws IOException
    {
        send(host, DEFAULT_PORT);
    }

    /***
     * Receive the reply data from the server.  This will always be 512 bytes
     * or less.  Chargen and quote of the day only return one packet.  Netstat
     * and systat require multiple calls to receive() with timeout detection.
     * <p>
     * @return The reply data from the server.
     * @exception IOException If an error occurs while receiving the datagram.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.982 -0500", hash_original_method = "4C2C559A1F5EA512B39B33D53CB17E9D", hash_generated_method = "172F68C5AE823BE13435DB055190A3AF")
    
public byte[] receive() throws IOException
    {
        int length;
        byte[] result;

        _socket_.receive(__receivePacket);

        result = new byte[length = __receivePacket.getLength()];
        System.arraycopy(__receiveData, 0, result, 0, length);

        return result;
    }

}

