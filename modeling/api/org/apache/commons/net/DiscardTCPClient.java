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
import java.io.OutputStream;

/***
 * The DiscardTCPClient class is a TCP implementation of a client for the
 * Discard protocol described in RFC 863.  To use the class, merely
 * establish a connection with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * and call {@link #getOutputStream  getOutputStream() } to
 * retrieve the discard output stream.  Don't close the output stream
 * when you're done writing to it.  Rather, call
 * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DiscardUDPClient
 ***/

public class DiscardTCPClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:51.238 -0500", hash_original_field = "9B15D2E0E3A22E5E4DD19692F4A5CB31", hash_generated_field = "2B56E2BB223515B060A405DDC0272D31")

    public static final int DEFAULT_PORT = 9;

    /***
     * The default DiscardTCPClient constructor.  It merely sets the default
     * port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:51.247 -0500", hash_original_method = "DE198E34D03C0E3D0A6C2DCF24EBCF72", hash_generated_method = "E1398558A0DEB7C5FA6FAB05913757CB")
    
public DiscardTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Returns an OutputStream through which you may write data to the server.
     * You should NOT close the OutputStream when you're finished
     * reading from it.  Rather, you should call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * to clean up properly.
     * <p>
     * @return An OutputStream through which you can write data to the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:51.256 -0500", hash_original_method = "9D2BB106ED3726830193706965BB93BE", hash_generated_method = "D94AD9215C67C9EFF14689561FD9C004")
    
public OutputStream getOutputStream()
    {
        return _output_;
    }
}
