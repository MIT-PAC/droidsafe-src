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
 * A final class derived from TFTPPacket definiing the TFTP Error
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

public final class TFTPErrorPacket extends TFTPPacket
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.933 -0500", hash_original_field = "76543FBD60BDE03E72033EDE3CFE4116", hash_generated_field = "D84F6B2C3E0993D460A02581D01E100C")

    public static final int UNDEFINED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.936 -0500", hash_original_field = "E652057CA90B913AF72DCF24B0B63183", hash_generated_field = "1014F8C00D6E62FC394BF97777936243")

    public static final int FILE_NOT_FOUND = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.939 -0500", hash_original_field = "09C1FA3ED42FFBE7688766B18E11F63C", hash_generated_field = "6C2EB6A756BD8D987259CB238190F400")

    public static final int ACCESS_VIOLATION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.942 -0500", hash_original_field = "25F9B2798AF2C052B927FEC3CA47A64C", hash_generated_field = "14BB53FD4FEA1FC5DE1C5DBFE929D465")

    public static final int OUT_OF_SPACE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.946 -0500", hash_original_field = "1780174FF071709BDEF0B03A46C8EE13", hash_generated_field = "7780F2B5260F3F47D77DC741186F51EB")

    public static final int ILLEGAL_OPERATION = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.950 -0500", hash_original_field = "76BCE7F9F708C6DD4595D2B3FDCAA301", hash_generated_field = "FA362095C87916A635425063850F6990")

    public static final int UNKNOWN_TID = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.954 -0500", hash_original_field = "C83586E0F113AE030DD31636E2E10C20", hash_generated_field = "5C9BE9A053B174B14721F053A3A598D8")

    public static final int FILE_EXISTS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.957 -0500", hash_original_field = "C0A20C3654DD1CEA47DE8A973E3C8959", hash_generated_field = "126B584F941DAF1D97266222E0B1C6E5")

    public static final int NO_SUCH_USER = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.960 -0500", hash_original_field = "E9BC52FED7257173FC0C6CAE87DB1982", hash_generated_field = "E9BC52FED7257173FC0C6CAE87DB1982")

    int _error;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.963 -0500", hash_original_field = "87D1AC571EBAFC8C3C43AC71B5E60416", hash_generated_field = "87D1AC571EBAFC8C3C43AC71B5E60416")

    String _message;

    /***
     * Creates an error packet to be sent to a host at a given port
     * with an error code and error message.
     * <p>
     * @param destination  The host to which the packet is going to be sent.
     * @param port  The port to which the packet is going to be sent.
     * @param error The error code of the packet.
     * @param message The error message of the packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.967 -0500", hash_original_method = "79A0D897F753E955B6701F092D250BC1", hash_generated_method = "FDF76E43A7A96F317B3248A9FD9041E9")
    
public TFTPErrorPacket(InetAddress destination, int port,
                           int error, String message)
    {
        super(TFTPPacket.ERROR, destination, port);

        _error = error;
        _message = message;
    }

    /***
     * Creates an error packet based from a received
     * datagram.  Assumes the datagram is at least length 4, else an
     * ArrayIndexOutOfBoundsException may be thrown.
     * <p>
     * @param datagram  The datagram containing the received error.
     * @throws TFTPPacketException  If the datagram isn't a valid TFTP
     *         error packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.971 -0500", hash_original_method = "5AE788D699768B81A9959AB7BD861BB0", hash_generated_method = "5AE788D699768B81A9959AB7BD861BB0")
    
TFTPErrorPacket(DatagramPacket datagram) throws TFTPPacketException
    {
        super(TFTPPacket.ERROR, datagram.getAddress(), datagram.getPort());
        int index, length;
        byte[] data;
        StringBuffer buffer;

        data = datagram.getData();
        length = datagram.getLength();

        if (getType() != data[1])
            throw new TFTPPacketException("TFTP operator code does not match type.");

        _error = (((data[2] & 0xff) << 8) | (data[3] & 0xff));

        if (length < 5)
            throw new TFTPPacketException("Bad error packet. No message.");

        index = 4;
        buffer = new StringBuffer();

        while (index < length && data[index] != 0)
        {
            buffer.append((char)data[index]);
            ++index;
        }

        _message = buffer.toString();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.975 -0500", hash_original_method = "9A7B50231514472DCC7663FFF9D885AE", hash_generated_method = "9A7B50231514472DCC7663FFF9D885AE")
    
DatagramPacket _newDatagram(DatagramPacket datagram, byte[] data)
    {
        int length;

        length = _message.length();

        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_error & 0xffff) >> 8);
        data[3] = (byte)(_error & 0xff);

        System.arraycopy(_message.getBytes(), 0, data, 4, length);

        data[length + 4] = 0;

        datagram.setAddress(_address);
        datagram.setPort(_port);
        datagram.setData(data);
        datagram.setLength(length + 4);

        return datagram;
    }


    /***
     * Creates a UDP datagram containing all the TFTP
     * error packet data in the proper format.
     * This is a method exposed to the programmer in case he
     * wants to implement his own TFTP client instead of using
     * the {@link org.apache.commons.net.tftp.TFTPClient}
     * class.
     * Under normal circumstances, you should not have a need to call this
     * method.
     * <p>
     * @return A UDP datagram containing the TFTP error packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.978 -0500", hash_original_method = "0991B56B86DFEFB9882491DD69117C3B", hash_generated_method = "9C17C29F9924B174CA28F87900A08F4D")
    
public DatagramPacket newDatagram()
    {
        byte[] data;
        int length;

        length = _message.length();

        data = new byte[length + 5];
        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_error & 0xffff) >> 8);
        data[3] = (byte)(_error & 0xff);

        System.arraycopy(_message.getBytes(), 0, data, 4, length);

        data[length + 4] = 0;

        return new DatagramPacket(data, data.length, _address, _port);
    }


    /***
     * Returns the error code of the packet.
     * <p>
     * @return The error code of the packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.981 -0500", hash_original_method = "D892F1F4F34E2F9104AF41DE6917984E", hash_generated_method = "581C9FD03B391A161A3C96AC6BDDA5EB")
    
public int getError()
    {
        return _error;
    }


    /***
     * Returns the error message of the packet.
     * <p>
     * @return The error message of the packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.984 -0500", hash_original_method = "537E50B4C61FE2B7079FE202B4146B0C", hash_generated_method = "932DB3CD934B0618EB9A17E491DE5106")
    
public String getMessage()
    {
        return _message;
    }
}
