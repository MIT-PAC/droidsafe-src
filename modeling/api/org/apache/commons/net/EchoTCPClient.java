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
import java.io.InputStream;

/***
 * The EchoTCPClient class is a TCP implementation of a client for the
 * Echo protocol described in RFC 862.  To use the class, merely
 * establish a connection with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * and call {@link DiscardTCPClient#getOutputStream  getOutputStream() } to
 * retrieve the echo output stream and
 * {@link #getInputStream getInputStream() }
 *  to get the echo input stream.
 * Don't close either stream when you're done using them.  Rather, call
 * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
 * to clean up properly.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see EchoUDPClient
 * @see DiscardTCPClient
 ***/

public final class EchoTCPClient extends DiscardTCPClient
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.876 -0500", hash_original_field = "6E5A2F2B5AF7AC5D2BA5C7D58DEE5511", hash_generated_field = "C5C92617896F89F207846E39CC98C74E")

    public static final int DEFAULT_PORT = 7;

    /***
     * The default EchoTCPClient constructor.  It merely sets the default
     * port to <code> DEFAULT_PORT </code>.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.880 -0500", hash_original_method = "C8722E45395B8D0E325E78C6DAD1FA33", hash_generated_method = "7BD2897E12594136CD8B608E7D50E285")
    
public EchoTCPClient ()
    {
        setDefaultPort(DEFAULT_PORT);
    }

    /***
     * Returns an InputStream from which you may read echoed data from
     * the server.  You should NOT close the InputStream when you're finished
     * reading from it.  Rather, you should call
     * {@link org.apache.commons.net.SocketClient#disconnect  disconnect }
     * to clean up properly.
     * <p>
     * @return An InputStream from which you can read echoed data from the
     *         server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:02.884 -0500", hash_original_method = "5B35E9AA913BF4A15ABCD13F74CD4461", hash_generated_method = "A4E9FEBE11F0614695860FA53CA50740")
    
public InputStream getInputStream()
    {
        return _input_;
    }

}
