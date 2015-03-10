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


package org.apache.commons.net.tftp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import org.apache.commons.net.DatagramSocketClient;

/***
 * The TFTP class exposes a set of methods to allow you to deal with the TFTP
 * protocol directly, in case you want to write your own TFTP client or
 * server.  However, almost every user should only be concerend with
 * the {@link org.apache.commons.net.DatagramSocketClient#open  open() },
 * and {@link org.apache.commons.net.DatagramSocketClient#close  close() },
 * methods. Additionally,the a
 * {@link org.apache.commons.net.DatagramSocketClient#setDefaultTimeout setDefaultTimeout() }
 *  method may be of importance for performance tuning.
 * <p>
 * Details regarding the TFTP protocol and the format of TFTP packets can
 * be found in RFC 783.  But the point of these classes is to keep you
 * from having to worry about the internals.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see org.apache.commons.net.DatagramSocketClient
 * @see TFTPPacket
 * @see TFTPPacketException
 * @see TFTPClient
 ***/

public class TFTP extends DatagramSocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.627 -0500", hash_original_field = "4CBB18CE8786320EBA320EAF49EE46C4", hash_generated_field = "177854B2E1F9E5A71372C69F29C9D1D5")

    public static final int ASCII_MODE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.630 -0500", hash_original_field = "6AF990EDC45E14BB2385F0FB79FA3E92", hash_generated_field = "B1A7B2AF254F88F744D200FEFB8C5F22")

    public static final int NETASCII_MODE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.634 -0500", hash_original_field = "7C668D8C7EDAA897C4E6BE989A421AA7", hash_generated_field = "F80B3F9E824A9F2169D5B2380A915559")

    public static final int BINARY_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.638 -0500", hash_original_field = "90FF0B1B96D5449F8A516960C26B186E", hash_generated_field = "6A496C6C919F4A5AAAE93E1E99546CC1")

    public static final int IMAGE_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.641 -0500", hash_original_field = "7B17870534A354777E0288CFF06A4F5D", hash_generated_field = "C9E360F0491FC6B2F3057AF6D02F874A")

    public static final int OCTET_MODE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.644 -0500", hash_original_field = "52B8C98A2DF9A1701FC502550823685A", hash_generated_field = "AEDBC21EF49D26D43C38A82CB8432256")

    public static final int DEFAULT_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.648 -0500", hash_original_field = "2AC680D35414E8CEFBD3CA5A645CB30B", hash_generated_field = "C30FCFD609F4446E424C8E8D25D16189")

    public static final int DEFAULT_PORT = 69;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.652 -0500", hash_original_field = "A63FDE0E482FAF9EB8DC1665A115AE49", hash_generated_field = "5836C0F64AA6548D4F0463288F879007")

    static final int PACKET_SIZE = TFTPPacket.SEGMENT_SIZE + 4;

    /***
     * Returns the TFTP string representation of a TFTP transfer mode.
     * Will throw an ArrayIndexOutOfBoundsException if an invalid transfer
     * mode is specified.
     * <p>
     * @param mode  The TFTP transfer mode.  One of the MODE constants.
     * @return  The TFTP string representation of the TFTP transfer mode.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.668 -0500", hash_original_method = "99461B1B493289BA7B4E4E4C44DD51FE", hash_generated_method = "90758DF12E1297BDC937643A0BEEE44A")
    
public static final String getModeName(int mode)
    {
        return TFTPRequestPacket._modeStrings[mode];
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.655 -0500", hash_original_field = "064CB7461A2F57FC081FF7CC6FF6B0A5", hash_generated_field = "76EF1E02E9AE150F0762F3831CC69788")

    private byte[] __receiveBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.658 -0500", hash_original_field = "3A895F825C055F73E89EDE32924D3305", hash_generated_field = "1285E4FEF92C15331EA706DD39B948A8")

    private DatagramPacket __receiveDatagram;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.661 -0500", hash_original_field = "78452E8FE4353B2926C1861A10EB57DC", hash_generated_field = "259E40E5563330307C0E0B97BEADA882")

    private DatagramPacket __sendDatagram;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.664 -0500", hash_original_field = "9BD01EF7D3F501C1F28D21F3CBEE6EDA", hash_generated_field = "9BD01EF7D3F501C1F28D21F3CBEE6EDA")

    byte[] _sendBuffer;

    /***
     * Creates a TFTP instance with a default timeout of DEFAULT_TIMEOUT,
     * a null socket, and buffered operations disabled.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.671 -0500", hash_original_method = "247BE4E7D133B432CB20B5679BCB76D6", hash_generated_method = "CE13AD9BB58BCCE8B1D2A97E213F8E5F")
    
public TFTP()
    {
        setDefaultTimeout(DEFAULT_TIMEOUT);
        __receiveBuffer = null;
        __receiveDatagram = null;
    }

    /***
     * This method synchronizes a connection by discarding all packets that
     * may be in the local socket buffer.  This method need only be called
     * when you implement your own TFTP client or server.
     * <p>
     * @exception IOException if an I/O error occurs.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.676 -0500", hash_original_method = "CBC1C8E9D5EE174118E047C6EC7B9670", hash_generated_method = "2719D807D80AA6AF2DEB0C2EC2DD8C43")
    
public final void discardPackets() throws IOException
    {
        int to;
        DatagramPacket datagram;

        datagram = new DatagramPacket(new byte[PACKET_SIZE], PACKET_SIZE);

        to = getSoTimeout();
        setSoTimeout(1);

        try
        {
            while (true)
                _socket_.receive(datagram);
        }
        catch (SocketException e)
        {
            // Do nothing.  We timed out so we hope we're caught up.
        }
        catch (InterruptedIOException e)
        {
            // Do nothing.  We timed out so we hope we're caught up.
        }

        setSoTimeout(to);
    }

    /***
     * This is a special method to perform a more efficient packet receive.
     * It should only be used after calling
     * {@link #beginBufferedOps  beginBufferedOps() }.  beginBufferedOps()
     * initializes a set of buffers used internally that prevent the new
     * allocation of a DatagramPacket and byte array for each send and receive.
     * To use these buffers you must call the bufferedReceive() and
     * bufferedSend() methods instead of send() and receive().  You must
     * also be certain that you don't manipulate the resulting packet in
     * such a way that it interferes with future buffered operations.
     * For example, a TFTPDataPacket received with bufferedReceive() will
     * have a reference to the internal byte buffer.  You must finish using
     * this data before calling bufferedReceive() again, or else the data
     * will be overwritten by the the call.
     * <p>
     * @return The TFTPPacket received.
     * @exception InterruptedIOException  If a socket timeout occurs.  The
     *       Java documentation claims an InterruptedIOException is thrown
     *       on a DatagramSocket timeout, but in practice we find a
     *       SocketException is thrown.  You should catch both to be safe.
     * @exception SocketException  If a socket timeout occurs.  The
     *       Java documentation claims an InterruptedIOException is thrown
     *       on a DatagramSocket timeout, but in practice we find a
     *       SocketException is thrown.  You should catch both to be safe.
     * @exception IOException  If some other I/O error occurs.
     * @exception TFTPPacketException If an invalid TFTP packet is received.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.680 -0500", hash_original_method = "040E4A9D73F097FCD418BC9A2FC85250", hash_generated_method = "F825C75B32447169047041C99FBEA3EE")
    
public final TFTPPacket bufferedReceive() throws IOException,
                InterruptedIOException, SocketException, TFTPPacketException
    {
        __receiveDatagram.setData(__receiveBuffer);
        __receiveDatagram.setLength(__receiveBuffer.length);
        _socket_.receive(__receiveDatagram);

        return TFTPPacket.newTFTPPacket(__receiveDatagram);
    }

    /***
     * This is a special method to perform a more efficient packet send.
     * It should only be used after calling
     * {@link #beginBufferedOps  beginBufferedOps() }.  beginBufferedOps()
     * initializes a set of buffers used internally that prevent the new
     * allocation of a DatagramPacket and byte array for each send and receive.
     * To use these buffers you must call the bufferedReceive() and
     * bufferedSend() methods instead of send() and receive().  You must
     * also be certain that you don't manipulate the resulting packet in
     * such a way that it interferes with future buffered operations.
     * For example, a TFTPDataPacket received with bufferedReceive() will
     * have a reference to the internal byte buffer.  You must finish using
     * this data before calling bufferedReceive() again, or else the data
     * will be overwritten by the the call.
     * <p>
     * @param packet  The TFTP packet to send.
     * @exception IOException  If some  I/O error occurs.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.683 -0500", hash_original_method = "524352509DE9C546A495C59156EC17D8", hash_generated_method = "5AE0766DD21FF00C354577174F8299A3")
    
public final void bufferedSend(TFTPPacket packet) throws IOException
    {
        _socket_.send(packet._newDatagram(__sendDatagram, _sendBuffer));
    }

    /***
     * Initializes the internal buffers. Buffers are used by
     * {@link #bufferedSend  bufferedSend() } and
     * {@link #bufferedReceive  bufferedReceive() }.  This
     * method must be called before calling either one of those two
     * methods.  When you finish using buffered operations, you must
     * call {@link #endBufferedOps  endBufferedOps() }.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.686 -0500", hash_original_method = "A3A09471DA92989A207F70C771740F44", hash_generated_method = "5389838397AAE77A04C8D6FC50613551")
    
public final void beginBufferedOps()
    {
        __receiveBuffer = new byte[PACKET_SIZE];
        __receiveDatagram =
            new DatagramPacket(__receiveBuffer, __receiveBuffer.length);
        _sendBuffer = new byte[PACKET_SIZE];
        __sendDatagram =
            new DatagramPacket(_sendBuffer, _sendBuffer.length);
    }

    /***
     * Releases the resources used to perform buffered sends and receives.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.690 -0500", hash_original_method = "FECE7B1FE9D2EDFD266D412A8771534E", hash_generated_method = "89EF250677DABA772E2AC6EFFDEC1C97")
    
public final void endBufferedOps()
    {
        __receiveBuffer = null;
        __receiveDatagram = null;
        _sendBuffer = null;
        __sendDatagram = null;
    }

    /***
     * Sends a TFTP packet to its destination.
     * <p>
     * @param packet  The TFTP packet to send.
     * @exception IOException  If some  I/O error occurs.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.694 -0500", hash_original_method = "F20A814E25CC4DCEEFFCCD4E0DFF5916", hash_generated_method = "4071720A7A7F32E488953DEEA8D01995")
    
public final void send(TFTPPacket packet) throws IOException
    {
        _socket_.send(packet.newDatagram());
    }

    /***
     * Receives a TFTPPacket.
     * <p>
     * @return The TFTPPacket received.
     * @exception InterruptedIOException  If a socket timeout occurs.  The
     *       Java documentation claims an InterruptedIOException is thrown
     *       on a DatagramSocket timeout, but in practice we find a
     *       SocketException is thrown.  You should catch both to be safe.
     * @exception SocketException  If a socket timeout occurs.  The
     *       Java documentation claims an InterruptedIOException is thrown
     *       on a DatagramSocket timeout, but in practice we find a
     *       SocketException is thrown.  You should catch both to be safe.
     * @exception IOException  If some other I/O error occurs.
     * @exception TFTPPacketException If an invalid TFTP packet is received.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.720 -0500", hash_original_method = "174C12670562B046AE6DB5A50E90BB9F", hash_generated_method = "DF6DB718DAEDFBD90D4BB232ED19A1E2")
    
public final TFTPPacket receive() throws IOException, InterruptedIOException,
                SocketException, TFTPPacketException
    {
        DatagramPacket packet;

        packet = new DatagramPacket(new byte[PACKET_SIZE], PACKET_SIZE);

        _socket_.receive(packet);

        return TFTPPacket.newTFTPPacket(packet);
    }

}
