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
package org.apache.commons.net.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/***
 * This class wraps an output stream, storing a reference to its originating
 * socket.  When the stream is closed, it will also close the socket
 * immediately afterward.  This class is useful for situations where you
 * are dealing with a stream originating from a socket, but do not have
 * a reference to the socket, and want to make sure it closes when the
 * stream closes.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see SocketInputStream
 ***/

public class SocketOutputStream extends FilterOutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.078 -0500", hash_original_field = "5525FC1255660212463E92A527284FEF", hash_generated_field = "B83793D9034606613513ED256B4B8687")

    private Socket __socket;

    /***
     * Creates a SocketOutputStream instance wrapping an output stream and
     * storing a reference to a socket that should be closed on closing
     * the stream.
     * <p>
     * @param socket  The socket to close on closing the stream.
     * @param stream  The input stream to wrap.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.081 -0500", hash_original_method = "7F812F523D0E5A460F612F9FF5DFBBFE", hash_generated_method = "36F947C0B7CA3FFADBD301E3AB0D2646")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
public SocketOutputStream(Socket socket, OutputStream stream)
    {
        super(stream);
        __socket = socket;
    }

    /***
     * Writes a number of bytes from a byte array to the stream starting from
     * a given offset.  This method bypasses the equivalent method in
     * FilterOutputStream because the FilterOutputStream implementation is
     * very inefficient.
     * <p>
     * @param buffer  The byte array to write.
     * @param offset  The offset into the array at which to start copying data.
     * @param length  The number of bytes to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.084 -0500", hash_original_method = "2025D8159C2E55719645FF1B84712B94", hash_generated_method = "AF8A52B23E466A1E85C0396FA63F30D8")
    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
public void write(byte buffer[], int offset, int length) throws IOException
    {
        out.write(buffer, offset, length);
    }

    /***
     * Closes the stream and immediately afterward closes the referenced
     * socket.
     * <p>
     * @exception IOException  If there is an error in closing the stream
     *                         or socket.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.088 -0500", hash_original_method = "E93BEE50684598E86CF4860142BFC855", hash_generated_method = "5E58DC0AD70210253ADAC11CE7F86386")
    @DSSafe(DSCat.SAFE_OTHERS)
public void close() throws IOException
    {
        super.close();
        __socket.close();
    }
}
