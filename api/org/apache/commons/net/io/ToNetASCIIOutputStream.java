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

/***
 * This class wraps an output stream, replacing all singly occurring
 * &lt;LF&gt; (linefeed) characters with &lt;CR&gt;&lt;LF&gt; (carriage return
 * followed by linefeed), which is the NETASCII standard for representing
 * a newline.
 * You would use this class to implement ASCII file transfers requiring
 * conversion to NETASCII.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class ToNetASCIIOutputStream extends FilterOutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.123 -0500", hash_original_field = "7349F15C2200728ADFC8FFA6C9946EEB", hash_generated_field = "1DB3652B34DA0CE8CAEDBB7F8DC0139F")

    private boolean __lastWasCR;

    /***
     * Creates a ToNetASCIIOutputStream instance that wraps an existing
     * OutputStream.
     * <p>
     * @param output  The OutputStream to wrap.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.128 -0500", hash_original_method = "455EAE3DE648593AC33DA780813354C8", hash_generated_method = "D0A2D391BDF46DDA5D237F5FEF381ACE")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)

public ToNetASCIIOutputStream(OutputStream output)
    {
        super(output);
        __lastWasCR = false;
    }


    /***
     * Writes a byte to the stream.    Note that a call to this method
     * may result in multiple writes to the underlying input stream in order
     * to convert naked newlines to NETASCII line separators.
     * This is transparent to the programmer and is only mentioned for
     * completeness.
     * <p>
     * @param ch The byte to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.134 -0500", hash_original_method = "C10D4A1492D25EED638CC1439313FEB4", hash_generated_method = "1EB1701C520BB6CD6B5B055C3516E7D2")
    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
public synchronized void write(int ch)
    throws IOException
    {
        switch (ch)
        {
        case '\r':
            __lastWasCR = true;
            out.write('\r');
            return ;
        case '\n':
            if (!__lastWasCR)
                out.write('\r');
            // Fall through
        default:
            __lastWasCR = false;
            out.write(ch);
            return ;
        }
    }


    /***
     * Writes a byte array to the stream.
     * <p>
     * @param buffer  The byte array to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.140 -0500", hash_original_method = "11AFF6C7676FEB0968CBC8B8BF9C6A52", hash_generated_method = "506047B26931C7FFF38435DA1DD16290")
    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
public synchronized void write(byte buffer[])
    throws IOException
    {
        write(buffer, 0, buffer.length);
    }


    /***
     * Writes a number of bytes from a byte array to the stream starting from
     * a given offset.
     * <p>
     * @param buffer  The byte array to write.
     * @param offset  The offset into the array at which to start copying data.
     * @param length  The number of bytes to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.146 -0500", hash_original_method = "35710279C92937D6002494F8923AF4C7", hash_generated_method = "6E9348F7EFB5AD81FB65B907A9AA86BD")
    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
public synchronized void write(byte buffer[], int offset, int length)
    throws IOException
    {
        while (length-- > 0)
            write(buffer[offset++]);
    }

}
