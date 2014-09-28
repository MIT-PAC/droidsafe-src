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
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/***
 * This class wraps an input stream, replacing all singly occurring
 * &lt;LF&gt; (linefeed) characters with &lt;CR&gt;&lt;LF&gt; (carriage return
 * followed by linefeed), which is the NETASCII standard for representing
 * a newline.
 * You would use this class to implement ASCII file transfers requiring
 * conversion to NETASCII.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class ToNetASCIIInputStream extends FilterInputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.305 -0500", hash_original_field = "A7552E96F1AE61857C1B6D021326C360", hash_generated_field = "36A774B3843A2B2D20A0A0169011E26D")

    private static final int __NOTHING_SPECIAL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.308 -0500", hash_original_field = "056AC956AFFF52B85A1D21AF4517E683", hash_generated_field = "A2B6258A440B7FB33E2CEDEF49C11749")

    private static final int __LAST_WAS_CR = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.312 -0500", hash_original_field = "8FA00154CC9064E5DB0D2683CF54A016", hash_generated_field = "44EB4627EC74AB60D3956B2E4BB97782")

    private static final int __LAST_WAS_NL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.315 -0500", hash_original_field = "A7CDA51A2086DCA1E49F61E96D24C551", hash_generated_field = "D56CF48759C45BF501C68D96F3A84A41")

    private int __status;

    /***
     * Creates a ToNetASCIIInputStream instance that wraps an existing
     * InputStream.
     * <p>
     * @param input  The InputStream to .
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.319 -0500", hash_original_method = "F3B35E0FD371515D334EC748B5846BB7", hash_generated_method = "D0A1AEE213E7B9EB1FD1C4CEB0FEBDA6")
    @DSComment("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
public ToNetASCIIInputStream(InputStream input)
    {
        super(input);
        __status = __NOTHING_SPECIAL;
    }

    /***
     * Reads and returns the next byte in the stream.  If the end of the
     * message has been reached, returns -1.
     * <p>
     * @return The next character in the stream. Returns -1 if the end of the
     *          stream has been reached.
     * @exception IOException If an error occurs while reading the underlying
     *            stream.
     ***/
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.323 -0500", hash_original_method = "A3DC32615BCC1627FA6F5D9720F7FDA3", hash_generated_method = "364063D4FD99910199DCA9476E1586D9")
    @DSSpec(DSCat.IO)
public int read() throws IOException
    {
        int ch;

        if (__status == __LAST_WAS_NL)
        {
            __status = __NOTHING_SPECIAL;
            return '\n';
        }

        ch = in.read();

        switch (ch)
        {
        case '\r':
            __status = __LAST_WAS_CR;
            return '\r';
        case '\n':
            if (__status != __LAST_WAS_CR)
            {
                __status = __LAST_WAS_NL;
                return '\r';
            }
            // else fall through
        default:
            __status = __NOTHING_SPECIAL;
            return ch;
        }
        // statement not reached
        //return ch;
    }

    /***
     * Reads the next number of bytes from the stream into an array and
     * returns the number of bytes read.  Returns -1 if the end of the
     * stream has been reached.
     * <p>
     * @param buffer  The byte array in which to store the data.
     * @return The number of bytes read. Returns -1 if the
     *          end of the message has been reached.
     * @exception IOException If an error occurs in reading the underlying
     *            stream.
     ***/
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.326 -0500", hash_original_method = "1AF05D3B3AC1A0BE6FEC3ED8E4AD92D7", hash_generated_method = "602CBE64B37DDC68026D3CD1EA56EC7D")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(byte buffer[]) throws IOException
    {
        return read(buffer, 0, buffer.length);
    }

    /***
     * Reads the next number of bytes from the stream into an array and returns
     * the number of bytes read.  Returns -1 if the end of the
     * message has been reached.  The characters are stored in the array
     * starting from the given offset and up to the length specified.
     * <p>
     * @param buffer The byte array in which to store the data.
     * @param offset  The offset into the array at which to start storing data.
     * @param length   The number of bytes to read.
     * @return The number of bytes read. Returns -1 if the
     *          end of the stream has been reached.
     * @exception IOException If an error occurs while reading the underlying
     *            stream.
     ***/
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.329 -0500", hash_original_method = "A62229E028B48C960393B7A95C0B3743", hash_generated_method = "2240EB94EB9D0F7EECFEA2AD7D8B2D5A")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(byte buffer[], int offset, int length) throws IOException
    {
        addTaint(length);
        buffer.addTaint(getTaint());
        return buffer.getTaintInt();
    }

    /*** Returns false.  Mark is not supported. ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.332 -0500", hash_original_method = "12DAC0CE56878A53F37AFF65E12010EB", hash_generated_method = "68CB0655189E46325916378CAE21EACC")
    
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean markSupported()
    {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.335 -0500", hash_original_method = "837ED4D38116082969ED1A2B9853076B", hash_generated_method = "FC06C236E4A5ECFD33984BC0DC36AD0F")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public int available() throws IOException
    {
        int result;

        result = in.available();

        if (__status == __LAST_WAS_NL)
            return (result + 1);

        return result;
    }
}
