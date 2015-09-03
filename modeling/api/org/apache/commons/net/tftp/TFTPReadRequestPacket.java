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
 * A class derived from TFTPRequestPacket definiing a TFTP read request
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
 * @see TFTPRequestPacket
 * @see TFTPPacketException
 * @see TFTP
 ***/

public final class TFTPReadRequestPacket extends TFTPRequestPacket
{

    /***
     * Creates a read request packet to be sent to a host at a
     * given port with a filename and transfer mode request.
     * <p>
     * @param destination  The host to which the packet is going to be sent.
     * @param port  The port to which the packet is going to be sent.
     * @param filename The requested filename.
     * @param mode The requested transfer mode.  This should be on of the TFTP
     *        class MODE constants (e.g., TFTP.NETASCII_MODE).
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.280 -0500", hash_original_method = "3A7ABC5A0EE22699D7304C1DD4A909AC", hash_generated_method = "7AA02F529B8D0D48406AF0657661D582")
    
public TFTPReadRequestPacket(InetAddress destination, int port,
                                 String filename, int mode)
    {
        super(destination, port, TFTPPacket.READ_REQUEST, filename, mode);
    }

    /***
     * Creates a read request packet of based on a received
     * datagram and assumes the datagram has already been identified as a
     * read request.  Assumes the datagram is at least length 4, else an
     * ArrayIndexOutOfBoundsException may be thrown.
     * <p>
     * @param datagram  The datagram containing the received request.
     * @throws TFTPPacketException  If the datagram isn't a valid TFTP
     *         request packet.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.284 -0500", hash_original_method = "5AAB9E5D017D2C4FE1A2773C7915D068", hash_generated_method = "5AAB9E5D017D2C4FE1A2773C7915D068")
    
TFTPReadRequestPacket(DatagramPacket datagram) throws TFTPPacketException
    {
        super(TFTPPacket.READ_REQUEST, datagram);
    }

}
