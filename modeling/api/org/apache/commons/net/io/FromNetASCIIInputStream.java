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
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;

/***
 * This class wraps an input stream, replacing all occurrences
 * of &lt;CR&gt;&lt;LF&gt; (carriage return followed by a linefeed),
 * which is the NETASCII standard for representing a newline, with the
 * local line separator representation.  You would use this class to
 * implement ASCII file transfers requiring conversion from NETASCII.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class FromNetASCIIInputStream extends PushbackInputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.886 -0500", hash_original_field = "C488061C4D78A3B5336AA36497545BB4", hash_generated_field = "39FC3F5449DC0DDA527012F8BF1ECB34")

    static  boolean _noConversionRequired;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.891 -0500", hash_original_field = "6D181E498A9D612B37BD84F97F6468F5", hash_generated_field = "C9A5D95B835478FC75BE15019FB3C5AC")

    static  String _lineSeparator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.895 -0500", hash_original_field = "3B531E5C292AA3CA6D2593346E060190", hash_generated_field = "1C02634C62475BAD7EA74B9A35F3CBF0")

    static  byte[] _lineSeparatorBytes;

    static {
        _lineSeparator = System.getProperty("line.separator");
        _noConversionRequired = _lineSeparator.equals("\r\n");
        _lineSeparatorBytes = _lineSeparator.getBytes();
    }

    /***
     * Returns true if the NetASCII line separator differs from the system
     * line separator, false if they are the same.  This method is useful
     * to determine whether or not you need to instantiate a
     * FromNetASCIIInputStream object.
     * <p>
     * @return True if the NETASCII line separator differs from the local
     *   system line separator, false if they are the same.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.901 -0500", hash_original_method = "8110C8E7476BAC12ED22AD12D0A85400", hash_generated_method = "48AB28D83654864E9BDD43DDAAC51E5F")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public static final boolean isConversionRequired()
    {
        return !_noConversionRequired;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.898 -0500", hash_original_field = "225815D0B568E571D54FF0CD87478B66", hash_generated_field = "C07F77B1E7197C6CE7DE2C4F199BE463")

    private int __length = 0;

    /***
     * Creates a FromNetASCIIInputStream instance that wraps an existing
     * InputStream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.905 -0500", hash_original_method = "235D12E1C0658EE09BEFB9086E97A54C", hash_generated_method = "3E872DC79AAB9673DD68326684BD29B8")
    @DSVerified("Constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
public FromNetASCIIInputStream(InputStream input)
    {
        super(input, _lineSeparatorBytes.length + 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.910 -0500", hash_original_method = "77980A358154D9038CFECBC54542DD49", hash_generated_method = "8E9BB545BA3E9B629B4ECC63266C8715")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private int __read() throws IOException
    {
        int ch;

        ch = super.read();

        if (ch == '\r')
        {
            ch = super.read();
            if (ch == '\n')
            {
                unread(_lineSeparatorBytes);
                ch = super.read();
                // This is a kluge for read(byte[], ...) to read the right amount
                --__length;
            }
            else
            {
                if (ch != -1)
                    unread(ch);
                return '\r';
            }
        }

        return ch;
    }

    /***
     * Reads and returns the next byte in the stream.  If the end of the
     * message has been reached, returns -1.  Note that a call to this method
     * may result in multiple reads from the underlying input stream in order
     * to convert NETASCII line separators to the local line separator format.
     * This is transparent to the programmer and is only mentioned for
     * completeness.
     * <p>
     * @return The next character in the stream. Returns -1 if the end of the
     *          stream has been reached.
     * @exception IOException If an error occurs while reading the underlying
     *            stream.
     ***/
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.913 -0500", hash_original_method = "FDD307626797CF03D3088020E6279DC1", hash_generated_method = "EC28F09966AA2D56B5EA24D3CC58965D")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read() throws IOException
    {
        if (_noConversionRequired)
            return super.read();

        return __read();
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.916 -0500", hash_original_method = "1AF05D3B3AC1A0BE6FEC3ED8E4AD92D7", hash_generated_method = "602CBE64B37DDC68026D3CD1EA56EC7D")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.920 -0500", hash_original_method = "D5CA87DB17742A9AF9BD65F49DD2ECBD", hash_generated_method = "E675C261CE18EE23F3E1B538CF4CA707")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(byte buffer[], int offset, int length) throws IOException
    {
        int ch, off;

        if (length < 1)
            return 0;

        ch = available();

        __length = (length > ch ? ch : length);

        // If nothing is available, block to read only one character
        if (__length < 1)
            __length = 1;

        if (_noConversionRequired)
            return super.read(buffer, offset, __length);

        if ((ch = __read()) == -1)
            return -1;

        off = offset;

        do
        {
            buffer[offset++] = (byte)ch;
        }
        while (--__length > 0 && (ch = __read()) != -1);

        return (offset - off);
    }

    // PushbackInputStream in JDK 1.1.3 returns the wrong thing
    /***
     * Returns the number of bytes that can be read without blocking EXCEPT
     * when newline conversions have to be made somewhere within the
     * available block of bytes.  In other words, you really should not
     * rely on the value returned by this method if you are trying to avoid
     * blocking.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:04.923 -0500", hash_original_method = "C56687AB499DA35AD83666C42808A3B2", hash_generated_method = "7668CEF39E8CDEF265D2D91FCC382449")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public int available() throws IOException
    {
        return (buf.length - pos) + in.available();
    }

}
