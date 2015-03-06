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
import java.io.InputStream;

/***
 * The CharGenTCPClient class is a TCP implementation of a client for the
 * character generator protocol described in RFC 864.  It can also be
 * used for Systat (RFC 866), Quote of the Day (RFC 865), and netstat
 * (port 15).  All of these protocols involve connecting to the appropriate
 * port, and reading data from an input stream.  The chargen protocol
 * actually sends data until the receiving end closes the connection.  All
 * of the others send only a fixed amount of data and then close the
 * connection.
 * <p>
 * To use the CharGenTCPClient class, just establish a
 * connection with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * and call {@link #getInputStream  getInputStream() } to access
 * the data.  Don't close the input stream when you're done with it.  Rather,
 * call {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see CharGenUDPClient
 ***/

public final class CharGenTCPClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.586 -0500", hash_original_field = "A3B8BE413FDA372C23A944AE11365486", hash_generated_field = "954938980BA4AB4C625DE283DDF00F79")

    public static final int SYSTAT_PORT = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.591 -0500", hash_original_field = "3F4F334D1B29133FA00F300847CFBDC5", hash_generated_field = "C5BA04F208572CAE023EB53BCD0CC4AE")

    public static final int NETSTAT_PORT = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.596 -0500", hash_original_field = "EE291AD2E9AB1EF343F4926EE2954827", hash_generated_field = "6A4013FBAB6D430863A41E5371ABBF8A")

    public static final int QUOTE_OF_DAY_PORT = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.599 -0500", hash_original_field = "ED27A8DAD675241CE62D0C15E822262A", hash_generated_field = "D80559FB5D8667C300457C9CF0A7ACC9")

    public static final int CHARGEN_PORT = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.602 -0500", hash_original_field = "EE74BAEE584614418BAB3CF1393C909B", hash_generated_field = "DAA90A78B9BDAA68EBF3DB8D0DC6BCBA")

    public static final int DEFAULT_PORT = 19;

    /***
     * The default constructor for CharGenTCPClient.  It merely sets the
     * default port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.606 -0500", hash_original_method = "74919E562F51AE29699191F0B83C4E29", hash_generated_method = "8B3823FD97ADA1658D8DD25FD3FD2630")
    
public CharGenTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Returns an InputStream from which the server generated data can be
     * read.  You should NOT close the InputStream when you're finished
     * reading from it.  Rather, you should call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * to clean up properly.
     * <p>
     * @return An InputStream from which the server generated data can be read.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:11.608 -0500", hash_original_method = "5B35E9AA913BF4A15ABCD13F74CD4461", hash_generated_method = "A4E9FEBE11F0614695860FA53CA50740")
    
public InputStream getInputStream()
    {
        return _input_;
    }
}




