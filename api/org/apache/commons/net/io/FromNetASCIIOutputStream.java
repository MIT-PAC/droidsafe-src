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
 * This class wraps an output stream, replacing all occurrences
 * of &lt;CR&gt;&lt;LF&gt; (carriage return followed by a linefeed),
 * which is the NETASCII standard for representing a newline, with the
 * local line separator representation.  You would use this class to
 * implement ASCII file transfers requiring conversion from NETASCII.
 * <p>
 * Because of the translation process, a call to <code>flush()</code> will
 * not flush the last byte written if that byte was a carriage
 * return.  A call to {@link #close  close() }, however, will
 * flush the carriage return.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class FromNetASCIIOutputStream extends FilterOutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.421 -0500", hash_original_field = "7349F15C2200728ADFC8FFA6C9946EEB", hash_generated_field = "1DB3652B34DA0CE8CAEDBB7F8DC0139F")

    private boolean __lastWasCR;

    /***
     * Creates a FromNetASCIIOutputStream instance that wraps an existing
     * OutputStream.
     * <p>
     * @param output  The OutputStream to wrap.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.424 -0500", hash_original_method = "B3697246130D2B10DFD352DF4E32FBC6", hash_generated_method = "654E7775CBB7CAD048A0C4280FAC85E3")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public FromNetASCIIOutputStream(OutputStream output)
    {
        super(output);
        __lastWasCR = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.427 -0500", hash_original_method = "42D12089AE481A637844D99861D38A63", hash_generated_method = "9D73230208366CCCA423836286EE2152")
    @DSVerified
    @DSBan(DSCat.PRIVATE_METHOD)
private void __write(int ch) throws IOException
    {
        switch (ch)
        {
        case '\r':
            __lastWasCR = true;
            // Don't write anything.  We need to see if next one is linefeed
            break;
        case '\n':
            if (__lastWasCR)
            {
                out.write(FromNetASCIIInputStream._lineSeparatorBytes);
                __lastWasCR = false;
                break;
            }
            __lastWasCR = false;
            out.write('\n');
            break;
        default:
            if (__lastWasCR)
            {
                out.write('\r');
                __lastWasCR = false;
            }
            out.write(ch);
            break;
        }
    }

    /***
     * Writes a byte to the stream.    Note that a call to this method
     * might not actually write a byte to the underlying stream until a
     * subsequent character is written, from which it can be determined if
     * a NETASCII line separator was encountered.
     * This is transparent to the programmer and is only mentioned for
     * completeness.
     * <p>
     * @param ch The byte to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.430 -0500", hash_original_method = "E0D4643D13B7CCDA3167C7EA96CF1000", hash_generated_method = "5CF591D4ECBF29A40680A9E022503132")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink(DSSinkKind.IO)
public synchronized void write(int ch)
    throws IOException
    {
        if (FromNetASCIIInputStream._noConversionRequired)
        {
            out.write(ch);
            return ;
        }

        __write(ch);
    }

    /***
     * Writes a byte array to the stream.
     * <p>
     * @param buffer  The byte array to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.434 -0500", hash_original_method = "11AFF6C7676FEB0968CBC8B8BF9C6A52", hash_generated_method = "506047B26931C7FFF38435DA1DD16290")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.437 -0500", hash_original_method = "4A2C80599CF241166B5A206B5D8B6870", hash_generated_method = "A8A4BD75DF015A1A0C79560CED73EED3")
    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.NETWORK})
public synchronized void write(byte buffer[], int offset, int length)
    throws IOException
    {
        if (FromNetASCIIInputStream._noConversionRequired)
        {
            // FilterOutputStream method is very slow.
            //super.write(buffer, offset, length);
            out.write(buffer, offset, length);
            return ;
        }

        while (length-- > 0)
            __write(buffer[offset++]);
    }

    /***
     * Closes the stream, writing all pending data.
     * <p>
     * @exception IOException  If an error occurs while closing the stream.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.441 -0500", hash_original_method = "0E1BC60F26C591E101972A03334B6F1C", hash_generated_method = "082789CDF70A79F8395EB80149C48B2C")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public synchronized void close()
    throws IOException
    {
        if (FromNetASCIIInputStream._noConversionRequired)
        {
            super.close();
            return ;
        }

        if (__lastWasCR)
            out.write('\r');
        super.close();
    }
}
