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
package org.apache.commons.net;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * The DaytimeTCPClient class is a TCP implementation of a client for the
 * Daytime protocol described in RFC 867.  To use the class, merely
 * establish a connection with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * and call {@link #getTime  getTime() } to retrieve the daytime
 * string, then
 * call {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * to close the connection properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see DaytimeUDPClient
 ***/

public final class DaytimeTCPClient extends SocketClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.320 -0500", hash_original_field = "31EEA5CACB483220DD88DFF45D265DD5", hash_generated_field = "630E125A56F4BF12B075A0A50A0AC8A5")

    public static final int DEFAULT_PORT = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.325 -0500", hash_original_field = "28478BFC101CB0EBB8B1935E2818094F", hash_generated_field = "C5428FE11F1A45B833D5C82A18C62703")

    // This is a temporary buffer used while receiving data.
    private char[] __buffer = new char[64];

    /***
     * The default DaytimeTCPClient constructor.  It merely sets the default
     * port to <code> DEFAULT_PORT </code>.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.331 -0500", hash_original_method = "65C3F07BD3FAC7A17371D28051A56D90", hash_generated_method = "263BD4846436A305C070872FAABE7F68")
    
public DaytimeTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Retrieves the time string from the server and returns it.  The
     * server will have closed the connection at this point, so you should
     * call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * after calling this method.  To retrieve another time, you must
     * initiate another connection with
     * {@link org.apache.commons.net.SocketClient#connect  connect }
     * before calling <code> getTime() </code> again.
     * <p>
     * @return The time string retrieved from the server.
     * @exception IOException  If an error occurs while fetching the time string.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.337 -0500", hash_original_method = "FFBADE00D2298922CE2B51DDF52E94D8", hash_generated_method = "46022369361AFC187A5EE69286B565FC")
    
public String getTime() throws IOException
    {
        int read;
        StringBuffer result = new StringBuffer(__buffer.length);
        BufferedReader reader;

        reader = new BufferedReader(new InputStreamReader(_input_));

        while (true)
        {
            read = reader.read(__buffer, 0, __buffer.length);
            if (read <= 0)
                break;
            result.append(__buffer, 0, read);
        }

        return result.toString();
    }

}

