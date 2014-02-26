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
 * A final class derived from TFTPPacket definiing the TFTP Acknowledgement
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

public final class TFTPAckPacket extends TFTPPacket
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.019 -0500", hash_original_field = "FCB19431A2802836A184148A8BA9C08F", hash_generated_field = "FCB19431A2802836A184148A8BA9C08F")

    int _blockNumber;

    /***
     * Creates an acknowledgment packet to be sent to a host at a given port
     * acknowledging receipt of a block.
     * <p>
     * @param destination  The host to which the packet is going to be sent.
     * @param port  The port to which the packet is going to be sent.
     * @param blockNumber  The block number being acknowledged.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.024 -0500", hash_original_method = "33174949058EF1059E013904B6AFFD90", hash_generated_method = "DFF08E819BACBBBFC40594983760EDE8")
    
public TFTPAckPacket(InetAddress destination, int port, int blockNumber)
    {
        super(TFTPPacket.ACKNOWLEDGEMENT, destination, port);
        _blockNumber = blockNumber;
    }

    /***
     * Creates an acknowledgement packet based from a received
     * datagram.  Assumes the datagram is at least length 4, else an
     * ArrayIndexOutOfBoundsException may be thrown.
     * <p>
     * @param datagram  The datagram containing the received acknowledgement.
     * @throws TFTPPacketException  If the datagram isn't a valid TFTP
     *         acknowledgement packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.030 -0500", hash_original_method = "5080586E74AB22D43AADEE459D5D8F50", hash_generated_method = "5080586E74AB22D43AADEE459D5D8F50")
    
TFTPAckPacket(DatagramPacket datagram) throws TFTPPacketException
    {
        super(TFTPPacket.ACKNOWLEDGEMENT, datagram.getAddress(),
              datagram.getPort());
        byte[] data;

        data = datagram.getData();

        if (getType() != data[1])
            throw new TFTPPacketException("TFTP operator code does not match type.");

        _blockNumber = (((data[2] & 0xff) << 8) | (data[3] & 0xff));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.036 -0500", hash_original_method = "927B2B273DA104E012B994771AF82E33", hash_generated_method = "927B2B273DA104E012B994771AF82E33")
    
DatagramPacket _newDatagram(DatagramPacket datagram, byte[] data)
    {
        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_blockNumber & 0xffff) >> 8);
        data[3] = (byte)(_blockNumber & 0xff);

        datagram.setAddress(_address);
        datagram.setPort(_port);
        datagram.setData(data);
        datagram.setLength(4);

        return datagram;
    }


    /***
     * Creates a UDP datagram containing all the TFTP
     * acknowledgement packet data in the proper format.
     * This is a method exposed to the programmer in case he
     * wants to implement his own TFTP client instead of using
     * the {@link org.apache.commons.net.tftp.TFTPClient}
     * class.  Under normal circumstances, you should not have a need to call this
     * method.
     * <p>
     * @return A UDP datagram containing the TFTP acknowledgement packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.041 -0500", hash_original_method = "3246DC053A070F72E521C71A5FE0638D", hash_generated_method = "06746F256EC6DA98F74CBAB20A258C77")
    
public DatagramPacket newDatagram()
    {
        byte[] data;

        data = new byte[4];
        data[0] = 0;
        data[1] = (byte)_type;
        data[2] = (byte)((_blockNumber & 0xffff) >> 8);
        data[3] = (byte)(_blockNumber & 0xff);

        return new DatagramPacket(data, data.length, _address, _port);
    }


    /***
     * Returns the block number of the acknowledgement.
     * <p>
     * @return The block number of the acknowledgement.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.045 -0500", hash_original_method = "3EF50D4F2DE79C4491DEE88365CDDB1C", hash_generated_method = "1FA63400B08B8DBCCAB7D934EFEBABF8")
    
public int getBlockNumber()
    {
        return _blockNumber;
    }


    /*** Sets the block number of the acknowledgement.  ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:03.051 -0500", hash_original_method = "DA3506E086AC5FEE6F71F22DE4F42D13", hash_generated_method = "C7D5ADCABE5EB5BE129F1EAB2D4A8F18")
    
public void setBlockNumber(int blockNumber)
    {
        _blockNumber = blockNumber;
    }
}

