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


package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.util.Date;
import java.io.DataInputStream;

/***
 * The TimeTCPClient class is a TCP implementation of a client for the
 * Time protocol described in RFC 868.  To use the class, merely
 * establish a connection with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * and call either {@link #getTime  getTime() } or
 * {@link #getDate  getDate() } to retrieve the time, then
 * call {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * to close the connection properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see TimeUDPClient
 ***/

public final class TimeTCPClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.037 -0500", hash_original_field = "8101C2679DB4F0F0175135696DB7EC25", hash_generated_field = "4EFF224B7A20681D9094BA4684DD0199")

    public static final int DEFAULT_PORT = 37;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.047 -0500", hash_original_field = "2A90E847EED105F91D1800A1E5C82063", hash_generated_field = "D5EAE304595D14C2A32BE27B0C7A7FC4")

    public static final long SECONDS_1900_TO_1970 = 2208988800L;

    /***
     * The default TimeTCPClient constructor.  It merely sets the default
     * port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.052 -0500", hash_original_method = "BF2A50626BBCB9FAA892D314FA8AC4D5", hash_generated_method = "C2B93624CEC746433B4316798D6BBEDE")
    
public TimeTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Retrieves the time from the server and returns it.  The time
     * is the number of seconds since 00:00 (midnight) 1 January 1900 GMT,
     * as specified by RFC 868.  This method reads the raw 32-bit big-endian
     * unsigned integer from the server, converts it to a Java long, and
     * returns the value.
     * <p>
     * The server will have closed the connection at this point, so you should
     * call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * after calling this method.  To retrieve another time, you must
     * initiate another connection with
     * {@link org.apache.commons.net.SocketClient#connect  connect }
     * before calling <code> getTime() </code> again.
     * <p>
     * @return The time value retrieved from the server.
     * @exception IOException  If an error occurs while fetching the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.057 -0500", hash_original_method = "992AFECD48E3994EB43A5693F571E617", hash_generated_method = "3EB3D92FC55B005E61A4F7D29D45CDEA")
    
public long getTime() throws IOException
    {
        DataInputStream input;
        input = new DataInputStream(_input_);
        return (long)(input.readInt() & 0xffffffffL);
    }

    /***
     * Retrieves the time from the server and returns a Java Date
     * containing the time converted to the local timezone.
     * <p>
     * The server will have closed the connection at this point, so you should
     * call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * after calling this method.  To retrieve another time, you must
     * initiate another connection with
     * {@link org.apache.commons.net.SocketClient#connect  connect }
     * before calling <code> getDate() </code> again.
     * <p>
     * @return A Date value containing the time retrieved from the server
     *     converted to the local timezone.
     * @exception IOException  If an error occurs while fetching the time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:56.061 -0500", hash_original_method = "345BE8D9B302C6EC03E7996BD25B3ED9", hash_generated_method = "236AC6BEEAF66F7281710A29DBB6E881")
    
public Date getDate() throws IOException
    {
        return new Date((getTime() - SECONDS_1900_TO_1970)*1000L);
    }

}

