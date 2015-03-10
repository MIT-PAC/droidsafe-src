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


package org.apache.commons.net.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/***
 * This class wraps an input stream, storing a reference to its originating
 * socket.  When the stream is closed, it will also close the socket
 * immediately afterward.  This class is useful for situations where you
 * are dealing with a stream originating from a socket, but do not have
 * a reference to the socket, and want to make sure it closes when the
 * stream closes.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SocketOutputStream
 ***/

public class SocketInputStream extends FilterInputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.126 -0500", hash_original_field = "5525FC1255660212463E92A527284FEF", hash_generated_field = "B83793D9034606613513ED256B4B8687")

    private Socket __socket;

    /***
     * Creates a SocketInputStream instance wrapping an input stream and
     * storing a reference to a socket that should be closed on closing
     * the stream.
     * <p>
     * @param socket  The socket to close on closing the stream.
     * @param stream  The input stream to wrap.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.129 -0500", hash_original_method = "4A4FFE02A853DD2A3546008C7FB43A41", hash_generated_method = "D2EF5E3F94CC76C228A9615A051CDD44")
    
public SocketInputStream(Socket socket, InputStream stream)
    {
        super(stream);
        __socket = socket;
    }

    /***
     * Closes the stream and immediately afterward closes the referenced
     * socket.
     * <p>
     * @exception IOException  If there is an error in closing the stream
     *                         or socket.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.132 -0500", hash_original_method = "E93BEE50684598E86CF4860142BFC855", hash_generated_method = "5E58DC0AD70210253ADAC11CE7F86386")
    
public void close() throws IOException
    {
        super.close();
        __socket.close();
    }
}
