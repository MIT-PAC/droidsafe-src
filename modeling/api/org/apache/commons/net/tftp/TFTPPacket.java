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
 * TFTPPacket is an abstract class encapsulating the functionality common
 * to the 5 types of TFTP packets.  It also provides a static factory
 * method that will create the correct TFTP packet instance from a
 * datagram.  This relieves the programmer from having to figure out what
 * kind of TFTP packet is contained in a datagram and create it himself.
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
 * @see TFTPPacketException
 * @see TFTP
 ***/

public abstract class TFTPPacket
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.099 -0500", hash_original_field = "7C1CD116AC7607E30E483848900DE495", hash_generated_field = "40B54A8BBC3118370D4308C1221BF986")

    static final int MIN_PACKET_SIZE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.103 -0500", hash_original_field = "31EF65ECC420105CF5A4F1F2EAAC5E2A", hash_generated_field = "CF78BAAFB19E3F9FDBE2B5B370FB2E2E")

    public static final int READ_REQUEST = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.106 -0500", hash_original_field = "A9F43843A7FBCC7411B1C954562B9778", hash_generated_field = "ABDBCC16C1C38A31DE4F8EFFD51D6F2F")

    public static final int WRITE_REQUEST = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.110 -0500", hash_original_field = "B293B7F3ECC4FD7DE29A5F241B269A8E", hash_generated_field = "A59742109FBE9A9D8C75AEC256FD6DF9")

    public static final int DATA = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.114 -0500", hash_original_field = "118E5C8D51DA65BB5882C24F8F52B11F", hash_generated_field = "E75383AE920C00EE45B99E660EBE0AA3")

    public static final int ACKNOWLEDGEMENT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.118 -0500", hash_original_field = "D76704BAC0D4436CA09F055A120913C7", hash_generated_field = "3B8BBD0046C8921B34164C05C801B806")

    public static final int ERROR = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.121 -0500", hash_original_field = "2ECE484C2F7C8F9F871E52C476E5E699", hash_generated_field = "D92679A2CAF1B323405FD0D7A2EDE18B")

    public static final int SEGMENT_SIZE = 512;

    /***
     * When you receive a datagram that you expect to be a TFTP packet, you use
     * this factory method to create the proper TFTPPacket object
     * encapsulating the data contained in that datagram.  This method is the
     * only way you can instantiate a TFTPPacket derived class from a
     * datagram.
     * <p>
     * @param datagram  The datagram containing a TFTP packet.
     * @return The TFTPPacket object corresponding to the datagram.
     * @exception TFTPPacketException  If the datagram does not contain a valid
     *             TFTP packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.135 -0500", hash_original_method = "4FCAA225E1DC72DDB63B0EF93A10D371", hash_generated_method = "C848D89FFF3391530E773BA313724FA5")
    
public final static TFTPPacket newTFTPPacket(DatagramPacket datagram)
    throws TFTPPacketException
    {
        byte[] data;
        TFTPPacket packet = null;

        if (datagram.getLength() < MIN_PACKET_SIZE)
            throw new TFTPPacketException(
                "Bad packet. Datagram data length is too short.");

        data = datagram.getData();

        switch (data[1])
        {
        case READ_REQUEST:
            packet = new TFTPReadRequestPacket(datagram);
            break;
        case WRITE_REQUEST:
            packet = new TFTPWriteRequestPacket(datagram);
            break;
        case DATA:
            packet = new TFTPDataPacket(datagram);
            break;
        case ACKNOWLEDGEMENT:
            packet = new TFTPAckPacket(datagram);
            break;
        case ERROR:
            packet = new TFTPErrorPacket(datagram);
            break;
        default:
            throw new TFTPPacketException(
                "Bad packet.  Invalid TFTP operator code.");
        }

        return packet;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.124 -0500", hash_original_field = "317AF1F7DA505E95F07C841CE66EB190", hash_generated_field = "317AF1F7DA505E95F07C841CE66EB190")

    int _type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.127 -0500", hash_original_field = "D7468C7A62D98E37C9C6ED886FC1BCAC", hash_generated_field = "D7468C7A62D98E37C9C6ED886FC1BCAC")

    int _port;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.131 -0500", hash_original_field = "A338B02210D1EB87E25CD54BD3E7C679", hash_generated_field = "A338B02210D1EB87E25CD54BD3E7C679")

    InetAddress _address;

    /***
     * This constructor is not visible outside of the package.  It is used
     * by subclasses within the package to initialize base data.
     * <p>
     * @param type The type of the packet.
     * @param address The host the packet came from or is going to be sent.
     * @param port The port the packet came from or is going to be sent.
     **/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.139 -0500", hash_original_method = "0E1BACFE1A92E6CF0E4ACC6DD06F16A6", hash_generated_method = "0E1BACFE1A92E6CF0E4ACC6DD06F16A6")
    
TFTPPacket(int type, InetAddress address, int port)
    {
        _type = type;
        _address = address;
        _port = port;
    }

    /***
     * This is an abstract method only available within the package for
     * implementing efficient datagram transport by elminating buffering.
     * It takes a datagram as an argument, and a byte buffer in which
     * to store the raw datagram data.  Inside the method, the data
     * should be set as the datagram's data and the datagram returned.
     * <p>
     * @param datagram  The datagram to create.
     * @param data The buffer to store the packet and to use in the datagram.
     * @return The datagram argument.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.142 -0500", hash_original_method = "1A495B80BED5FFABA475CA37E58AAD58", hash_generated_method = "76C09B938F8698C964F2F6B5747F897D")
    
abstract DatagramPacket _newDatagram(DatagramPacket datagram, byte[] data);

    /***
     * Creates a UDP datagram containing all the TFTP packet
     * data in the proper format.
     * This is an abstract method, exposed to the programmer in case he
     * wants to implement his own TFTP client instead of using
     * the {@link org.apache.commons.net.tftp.TFTPClient}
     * class.
     * Under normal circumstances, you should not have a need to call this
     * method.
     * <p>
     * @return A UDP datagram containing the TFTP packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.145 -0500", hash_original_method = "9687FE723AA556E9F304A5651002528F", hash_generated_method = "509F74F41574553C24F6F9501717BAC9")
    
public abstract DatagramPacket newDatagram();

    /***
     * Returns the type of the packet.
     * <p>
     * @return The type of the packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.148 -0500", hash_original_method = "158FF5F8278EB1B485412C365F099019", hash_generated_method = "0EC97582023D7064965B514AF33332A9")
    
public final int getType()
    {
        return _type;
    }

    /***
     * Returns the address of the host where the packet is going to be sent
     * or where it came from.
     * <p>
     * @return The type of the packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.152 -0500", hash_original_method = "5278D804CD4D2C1578646381ABA6E7D2", hash_generated_method = "5483B3F7FCF0587448052C7821C06866")
    
public final InetAddress getAddress()
    {
        return _address;
    }

    /***
     * Returns the port where the packet is going to be sent
     * or where it came from.
     * <p>
     * @return The port where the packet came from or where it is going.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.155 -0500", hash_original_method = "C7D205C79A2AA7EFF4B72D12F471E84F", hash_generated_method = "E19191E285144D1AB334698567CB3FA1")
    
public final int getPort()
    {
        return _port;
    }

    /*** Sets the port where the packet is going to be sent. ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.159 -0500", hash_original_method = "4FA05AF961882F10983F6FAD36D3A3A2", hash_generated_method = "9FECED351E58643DA0E6CA77923F807F")
    
public final void setPort(int port)
    {
        _port = port;
    }

    /*** Sets the host address where the packet is going to be sent. ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.162 -0500", hash_original_method = "3BCF40BBAD2A945EBA2DDF9A077AFD44", hash_generated_method = "A9BA1CFC0741BC6AB672BE071BB74360")
    
public final void setAddress(InetAddress address)
    {
        _address = address;
    }
}
