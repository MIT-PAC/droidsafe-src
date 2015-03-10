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
import java.net.DatagramPacket;
import java.net.InetAddress;

/***
 * A final class derived from TFTPPacket definiing the TFTP Data
 * packet type.
 * <p>
 * Details regarding the TFTP protocol and the format of TFTP packets can
 * be found in RFC 783.  But the point of these classes is to keep you
 * from having to worry about the internals.  Additionally, only very
 * few people should have to care about any of the TFTPPacket classes
 * or derived classes.  Almost all users should only be concerned with the
 * {@link org.apache.commons.net.tftp.TFTPClient} class
 * {@link org.apache.commons.net.tftp.TFTPClient#receiveFile receiveFile()}
 * and
 * {@link org.apache.commons.net.tftp.TFTPClient#sendFile sendFile()}
 * methods.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see TFTPPacket
 * @see TFTPPacketException
 * @see TFTP
 ***/

public final class TFTPDataPacket extends TFTPPacket
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.459 -0500", hash_original_field = "298FE8C8C89CC9F6C64B42A0C05FFC2F", hash_generated_field = "246492B05A76ACFF98D283F86D7A9932")

    public static final int MAX_DATA_LENGTH = 512;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.463 -0500", hash_original_field = "59C94B25425DEF55B3EEC24982B08F6B", hash_generated_field = "0F6869A44AF608C7FADDB8B7025A5569")

    public static final int MIN_DATA_LENGTH = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.465 -0500", hash_original_field = "FCB19431A2802836A184148A8BA9C08F", hash_generated_field = "FCB19431A2802836A184148A8BA9C08F")

    int _blockNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.469 -0500", hash_original_field = "F33C4881E9CB6F9B423D80C890DB7046", hash_generated_field = "F33C4881E9CB6F9B423D80C890DB7046")

    int _length;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.472 -0500", hash_original_field = "E2DE971149D320743FE0C74384122E94", hash_generated_field = "E2DE971149D320743FE0C74384122E94")

    int _offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.475 -0500", hash_original_field = "891384352DCA0E4179223BBBFFF1E534", hash_generated_field = "891384352DCA0E4179223BBBFFF1E534")

    byte[] _data;

    /***
     * Creates a data packet to be sent to a host at a given port
     * with a given block number.  The actual data to be sent is passed as
     * an array, an offset, and a length.  The offset is the offset into
     * the byte array where the data starts.  The length is the length of
     * the data.  If the length is greater than MAX_DATA_LENGTH, it is
     * truncated.
     * <p>
     * @param destination  The host to which the packet is going to be sent.
     * @param port  The port to which the packet is going to be sent.
     * @param blockNumber The block number of the data.
     * @param data The byte array containing the data.
     * @param offset The offset into the array where the data starts.
     * @param length The length of the data.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.479 -0500", hash_original_method = "951E23950C742ACC01168638ADC04F9A", hash_generated_method = "C825A4374DC5FB4D17405C9307C62AEE")
    
public TFTPDataPacket(InetAddress destination, int port, int blockNumber,
                          byte[] data, int offset, int length)
    {
        super(TFTPPacket.DATA, destination, port);

        _blockNumber = blockNumber;
        _data = data;
        _offset = offset;

        if (length > MAX_DATA_LENGTH)
            _length = MAX_DATA_LENGTH;
        else
            _length = length;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.483 -0500", hash_original_method = "A7506A8FC86765B1DCCFA735230FDB18", hash_generated_method = "D82A8210AB9EF4FCBC9F5D9ABEF1AF28")
    
public TFTPDataPacket(InetAddress destination, int port, int blockNumber,
                          byte[] data)
    {
        this(destination, port, blockNumber, data, 0, data.length);
    }


    /***
     * Creates a data packet based from a received
     * datagram.  Assumes the datagram is at least length 4, else an
     * ArrayIndexOutOfBoundsException may be thrown.
     * <p>
     * @param datagram  The datagram containing the received data.
     * @throws TFTPPacketException  If the datagram isn't a valid TFTP
     *         data packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.487 -0500", hash_original_method = "0850F4D1450AC54F93659F0BF07621C5", hash_generated_method = "0850F4D1450AC54F93659F0BF07621C5")
    
TFTPDataPacket(DatagramPacket datagram) throws TFTPPacketException
    {
        super(TFTPPacket.DATA, datagram.getAddress(), datagram.getPort());

        _data = datagram.getData();
        _offset = 4;

        if (getType() != _data[1])
            throw new TFTPPacketException("TFTP operator code does not match type.");

        _blockNumber = (((_data[2] & 0xff) << 8) | (_data[3] & 0xff));

        _length = datagram.getLength() - 4;

        if (_length > MAX_DATA_LENGTH)
            _length = MAX_DATA_LENGTH;
    }

    /***
     * This is a method only available within the package for
     * implementing efficient datagram transport by elminating buffering.
     * It takes a datagram as an argument, and a byte buffer in which
     * to store the raw datagram data.  Inside the method, the data
     * is set as the datagram's data and the datagram returned.
     * <p>
     * @param datagram  The datagram to create.
     * @param data The buffer to store the packet and to use in the datagram.
     * @return The datagram argument.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.490 -0500", hash_original_method = "052F52042D38B800260CF7B2BCDFC3AB", hash_generated_method = "4368B68CA0A9A282C2EFDB17A3E71D9C")
    
DatagramPacket _newDatagram(DatagramPacket datagram, byte[] data)
    {
        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_blockNumber & 0xffff) >> 8);
        data[3] = (byte)(_blockNumber & 0xff);

        // Doublecheck we're not the same
        if (data != _data)
            System.arraycopy(_data, _offset, data, 4, _length);

        datagram.setAddress(_address);
        datagram.setPort(_port);
        datagram.setData(data);
        datagram.setLength(_length + 4);

        return datagram;
    }

    /***
     * Creates a UDP datagram containing all the TFTP
     * data packet data in the proper format.
     * This is a method exposed to the programmer in case he
     * wants to implement his own TFTP client instead of using
     * the {@link org.apache.commons.net.tftp.TFTPClient}
     * class.
     * Under normal circumstances, you should not have a need to call this
     * method.
     * <p>
     * @return A UDP datagram containing the TFTP data packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.494 -0500", hash_original_method = "691A4D47FFD9C1A434CE25D45A26D669", hash_generated_method = "ABEB3297F52BAF4778DB23ED16502B9F")
    
public DatagramPacket newDatagram()
    {
        byte[] data;

        data = new byte[_length + 4];
        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_blockNumber & 0xffff) >> 8);
        data[3] = (byte)(_blockNumber & 0xff);

        System.arraycopy(_data, _offset, data, 4, _length);

        return new DatagramPacket(data, _length + 4, _address, _port);
    }

    /***
     * Returns the block number of the data packet.
     * <p>
     * @return The block number of the data packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.496 -0500", hash_original_method = "3EF50D4F2DE79C4491DEE88365CDDB1C", hash_generated_method = "1FA63400B08B8DBCCAB7D934EFEBABF8")
    
public int getBlockNumber()
    {
        return _blockNumber;
    }

    /*** Sets the block number of the data packet.  ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.500 -0500", hash_original_method = "DA3506E086AC5FEE6F71F22DE4F42D13", hash_generated_method = "C7D5ADCABE5EB5BE129F1EAB2D4A8F18")
    
public void setBlockNumber(int blockNumber)
    {
        _blockNumber = blockNumber;
    }

    /***
     * Sets the data for the data packet.
     * <p>
     * @param data The byte array containing the data.
     * @param offset The offset into the array where the data starts.
     * @param length The length of the data.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.503 -0500", hash_original_method = "88F08EDAA2775FCBF6936BD7B169B93D", hash_generated_method = "001C72E2DD13A6BF05DB4F5E1F4F0426")
    
public void setData(byte[] data, int offset, int length)
    {
        _data = data;
        _offset = offset;
        _length = length;

        if (length > MAX_DATA_LENGTH)
            _length = MAX_DATA_LENGTH;
        else
            _length = length;
    }

    /***
     * Returns the length of the data part of the data packet.
     * <p>
     * @return The length of the data part of the data packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.506 -0500", hash_original_method = "C10F84C8D8C2AFCBED0577A977B46E3A", hash_generated_method = "158209E6CA2240284D6BEEF3286C8DC4")
    
public int getDataLength()
    {
        return _length;
    }

    /***
     * Returns the offset into the byte array where the packet data actually
     * starts.
     * <p>
     * @return The offset into the byte array where the packet data actually
     *         starts.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.509 -0500", hash_original_method = "63E3CF4EC6760D1F32CC88A7AF3EA61D", hash_generated_method = "3300180A7F94D8B0F09B9D2739E22375")
    
public int getDataOffset()
    {
        return _offset;
    }

    /***
     * Returns the byte array containing the packet data.
     * <p>
     * @return The byte array containing the packet data.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.512 -0500", hash_original_method = "24A969BA5FB9E4E46832A070EFAA7A2B", hash_generated_method = "10F9F904F8BB589B6C2139C1E1950F4D")
    
public byte[] getData()
    {
        return _data;
    }
}
