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
package org.apache.commons.net.tftp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.net.DatagramPacket;
import java.net.InetAddress;

/***
 * An abstract class derived from TFTPPacket definiing a TFTP Request
 * packet type.  It is subclassed by the
 * {@link org.apache.commons.net.tftp.TFTPReadRequestPacket}
 *   and
 * {@link org.apache.commons.net.tftp.TFTPWriteRequestPacket}
 *  classes.
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
 * @see TFTPReadRequestPacket
 * @see TFTPWriteRequestPacket
 * @see TFTPPacketException
 * @see TFTP
 ***/

public abstract class TFTPRequestPacket extends TFTPPacket
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.417 -0500", hash_original_field = "9E65BD3DF9033001BEED01E0B023DCD4", hash_generated_field = "F640CAB98E6890EDCCF0D8EE779664E4")

    static final String[] _modeStrings = { "netascii", "octet" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.421 -0500", hash_original_field = "83B8E331D05AA9264853F677D7EBFF27", hash_generated_field = "6C8DC4A36E099305001CD79D7E742DD9")

    static final byte[] _modeBytes[] = {
                                           { (byte)'n', (byte)'e', (byte)'t', (byte)'a', (byte)'s', (byte)'c',
                                             (byte)'i', (byte)'i', 0 },
                                           { (byte)'o', (byte)'c', (byte)'t', (byte)'e', (byte)'t', 0 }
                                       };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.423 -0500", hash_original_field = "807C044FB5EFBCFA43485ABAA0864556", hash_generated_field = "807C044FB5EFBCFA43485ABAA0864556")

    int _mode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.427 -0500", hash_original_field = "85ECE841CC4F85EB420A572C9F1E4F26", hash_generated_field = "85ECE841CC4F85EB420A572C9F1E4F26")

    String _filename;

    /***
     * Creates a request packet of a given type to be sent to a host at a
     * given port with a filename and transfer mode request.
     * <p>
     * @param destination  The host to which the packet is going to be sent.
     * @param port  The port to which the packet is going to be sent.
     * @param type The type of the request (either TFTPPacket.READ_REQUEST or
     *             TFTPPacket.WRITE_REQUEST).
     * @param filename The requested filename.
     * @param mode The requested transfer mode.  This should be on of the TFTP
     *        class MODE constants (e.g., TFTP.NETASCII_MODE).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.430 -0500", hash_original_method = "895DA247F3EA500D4E298433EB0DC81A", hash_generated_method = "895DA247F3EA500D4E298433EB0DC81A")
    
TFTPRequestPacket(InetAddress destination, int port,
                      int type, String filename, int mode)
    {
        super(type, destination, port);

        _filename = filename;
        _mode = mode;
    }

    /***
     * Creates a request packet of a given type based on a received
     * datagram.  Assumes the datagram is at least length 4, else an
     * ArrayIndexOutOfBoundsException may be thrown.
     * <p>
     * @param type The type of the request (either TFTPPacket.READ_REQUEST or
     *             TFTPPacket.WRITE_REQUEST).
     * @param datagram  The datagram containing the received request.
     * @throws TFTPPacketException  If the datagram isn't a valid TFTP
     *         request packet of the appropriate type.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.436 -0500", hash_original_method = "158F810291D2A91A31DC503BED9BBD2A", hash_generated_method = "42CC10676CEAC90699D7C56616C8A5AB")
    
TFTPRequestPacket(int type, DatagramPacket datagram)
    throws TFTPPacketException
    {
        super(type, datagram.getAddress(), datagram.getPort());

        byte[] data;
        int index, length;
        String mode;
        StringBuffer buffer;

        data = datagram.getData();

        if (getType() != data[1])
            throw new TFTPPacketException("TFTP operator code does not match type.");

        buffer = new StringBuffer();

        index = 2;
        length = datagram.getLength();

        while (index < length && data[index] != 0)
        {
            buffer.append((char)data[index]);
            ++index;
        }

        _filename = buffer.toString();

        if (index >= length)
            throw new TFTPPacketException("Bad filename and mode format.");

        buffer.setLength(0);
        ++index; // need to advance beyond the end of string marker
        while (index < length && data[index] != 0)
        {
            buffer.append((char)data[index]);
            ++index;
        }

        mode = buffer.toString().toLowerCase();
        length = _modeStrings.length;

        for (index = 0; index < length; index++)
        {
            if (mode.equals(_modeStrings[index]))
            {
                _mode = index;
                break;
            }
        }

        if (index >= length)
        {
            throw new TFTPPacketException("Unrecognized TFTP transfer mode: " + mode);
            // May just want to default to binary mode instead of throwing
            // exception.
            //_mode = TFTP.OCTET_MODE;
        }
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.440 -0500", hash_original_method = "86E255CE072D46AD6A16D6F678838D23", hash_generated_method = "F8C1A4DF4F6558D3827A2824F0C4D016")
    
final DatagramPacket _newDatagram(DatagramPacket datagram, byte[] data)
    {
        int fileLength, modeLength;

        fileLength = _filename.length();
        modeLength = _modeBytes[_mode].length;

        data[0] = 0;
        data[1] = (byte)_type;
        System.arraycopy(_filename.getBytes(), 0, data, 2, fileLength);
        data[fileLength + 2] = 0;
        System.arraycopy(_modeBytes[_mode], 0, data, fileLength + 3,
                         modeLength);

        datagram.setAddress(_address);
        datagram.setPort(_port);
        datagram.setData(data);
        datagram.setLength(fileLength + modeLength + 3);
        
        return datagram;
    }

    /***
     * Creates a UDP datagram containing all the TFTP
     * request packet data in the proper format.
     * This is a method exposed to the programmer in case he
     * wants to implement his own TFTP client instead of using
     * the {@link org.apache.commons.net.tftp.TFTPClient}
     * class.  Under normal circumstances, you should not have a need to call
     * this method.
     * <p>
     * @return A UDP datagram containing the TFTP request packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.443 -0500", hash_original_method = "0B03D85CEDB8AEF3CEE8D4DDE8943453", hash_generated_method = "E0DEAAF8F165430FA47959D7C3D83183")
    
public final DatagramPacket newDatagram()
    {
        int fileLength, modeLength;
        byte[] data;

        fileLength = _filename.length();
        modeLength = _modeBytes[_mode].length;

        data = new byte[fileLength + modeLength + 4];
        data[0] = 0;
        data[1] = (byte)_type;
        System.arraycopy(_filename.getBytes(), 0, data, 2, fileLength);
        data[fileLength + 2] = 0;
        System.arraycopy(_modeBytes[_mode], 0, data, fileLength + 3,
                         modeLength);

        return new DatagramPacket(data, data.length, _address, _port);
    }

    /***
     * Returns the transfer mode of the request.
     * <p>
     * @return The transfer mode of the request.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.447 -0500", hash_original_method = "FED27C734C74CB68D0D25B5CDAD6F0D6", hash_generated_method = "24253F2519C8DA3DD8D9A8A4C37881E7")
    
public final int getMode()
    {
        return _mode;
    }

    /***
     * Returns the requested filename.
     * <p>
     * @return The requested filename.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.450 -0500", hash_original_method = "8DBA3E7CFE0239BF00815BF3FFB8F81A", hash_generated_method = "8A8F6826199EE99DBF8D79FAE0C79D92")
    
public final String getFilename()
    {
        return _filename;
    }
}
