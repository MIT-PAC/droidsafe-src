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
import java.io.IOException;
import java.io.Writer;

/***
 * DotTerminatedMessageWriter is a class used to write messages to a
 * server that are terminated by a single dot followed by a
 * &lt;CR&gt;&lt;LF&gt;
 * sequence and with double dots appearing at the begining of lines which
 * do not signal end of message yet start with a dot.  Various Internet
 * protocols such as NNTP and POP3 produce messages of this type.
 * <p>
 * This class handles the doubling of line-starting periods,
 * converts single linefeeds to NETASCII newlines, and on closing
 * will send the final message terminator dot and NETASCII newline
 * sequence.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

public final class DotTerminatedMessageWriter extends Writer
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.930 -0500", hash_original_field = "CF00A5711548ED34455DD6BAB469043C", hash_generated_field = "B7A056A3C1923113176235FFBDACE57A")

    private static final int __NOTHING_SPECIAL_STATE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.936 -0500", hash_original_field = "6B4E34424FA1F7D66E1D3A92B2A4AD99", hash_generated_field = "328304229EAC14A8355810BAD0A0B9D5")

    private static final int __LAST_WAS_CR_STATE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.940 -0500", hash_original_field = "AB04E25FA71DD88D9FEA9B677E920C86", hash_generated_field = "73C0E7DE0B7850786F5C9A18F3604F35")

    private static final int __LAST_WAS_NL_STATE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.943 -0500", hash_original_field = "52F6FF2783D6331A8D30C6852223843F", hash_generated_field = "5AD41186785E88DD1F7FF1EEF877EE9E")

    private int __state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.946 -0500", hash_original_field = "902460CA8958914FD108B5165B21CF5C", hash_generated_field = "E719BB84825F6B08666A694C6A1EF62C")

    private Writer __output;

    /***
     * Creates a DotTerminatedMessageWriter that wraps an existing Writer
     * output destination.
     * <p>
     * @param output  The Writer output destination to write the message.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.949 -0500", hash_original_method = "7F3B7E4878F7B7AD878E6CDC69994E94", hash_generated_method = "D333A4E720FF728B2B39EB9E531568C9")
    
public DotTerminatedMessageWriter(Writer output)
    {
        super(output);
        __output = output;
        __state = __NOTHING_SPECIAL_STATE;
    }

    /***
     * Writes a character to the output.  Note that a call to this method
     * may result in multiple writes to the underling Writer in order to
     * convert naked linefeeds to NETASCII line separators and to double
     * line-leading periods.  This is transparent to the programmer and
     * is only mentioned for completeness.
     * <p>
     * @param ch  The character to write.
     * @exception IOException  If an error occurs while writing to the
     *            underlying output.
     ***/
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.953 -0500", hash_original_method = "4EE95F45C86E4F91258EC37A0D803D0C", hash_generated_method = "6D7E28704DC5D004632F393AF374FD21")
    
public void write(int ch) throws IOException
    {
        synchronized (lock)
        {
            switch (ch)
            {
            case '\r':
                __state = __LAST_WAS_CR_STATE;
                __output.write('\r');
                return ;
            case '\n':
                if (__state != __LAST_WAS_CR_STATE)
                    __output.write('\r');
                __output.write('\n');
                __state = __LAST_WAS_NL_STATE;
                return ;
            case '.':
                // Double the dot at the beginning of a line
                if (__state == __LAST_WAS_NL_STATE)
                    __output.write('.');
                // Fall through
            default:
                __state = __NOTHING_SPECIAL_STATE;
                __output.write(ch);
                return ;
            }
        }
    }

    /***
     * Writes a number of characters from a character array to the output
     * starting from a given offset.
     * <p>
     * @param buffer  The character array to write.
     * @param offset  The offset into the array at which to start copying data.
     * @param length  The number of characters to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            output.
     ***/
    @DSSink({DSSinkKind.IO})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.957 -0500", hash_original_method = "41630DBB62E0DD4474E2353E85A23DEC", hash_generated_method = "51F12645A0F3999256B122AE6A18CCC9")
    
public void write(char[] buffer, int offset, int length) throws IOException
    {
        synchronized (lock)
        {
            while (length-- > 0)
                write(buffer[offset++]);
        }
    }

    /***
     * Writes a character array to the output.
     * <p>
     * @param buffer  The character array to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            output.
     ***/
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.960 -0500", hash_original_method = "FA022850E89BAA01DC8A711414675DE7", hash_generated_method = "D072F1DB76073C5678A4C631350B2B2D")
    
public void write(char[] buffer) throws IOException
    {
        write(buffer, 0, buffer.length);
    }

    /***
     * Writes a String to the output.
     * <p>
     * @param string  The String to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            output.
     ***/
    @DSSink({DSSinkKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.963 -0500", hash_original_method = "222E87E258845BFD571D8B5E946AF980", hash_generated_method = "ECA3BB9D25CCF5656E5278F6B4A24661")
    
public void write(String string) throws IOException
    {
        write(string.toCharArray());
    }

    /***
     * Writes part of a String to the output starting from a given offset.
     * <p>
     * @param string  The String to write.
     * @param offset  The offset into the String at which to start copying data.
     * @param length  The number of characters to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            output.
     ***/
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.966 -0500", hash_original_method = "A3382A53D185805D9FEF81E52E78D014", hash_generated_method = "CE386F23A09968D7056636BB7A12DD1A")
    
public void write(String string, int offset, int length) throws IOException
    {
        write(string.toCharArray(), offset, length);
    }

    /***
     * Flushes the underlying output, writing all buffered output.
     * <p>
     * @exception IOException If an error occurs while writing to the underlying
     *            output.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.969 -0500", hash_original_method = "AF30157C4F5CAE7AE82AAF53354D984E", hash_generated_method = "E7186C784360CA6859C777C951E7586A")
    
public void flush() throws IOException
    {
        synchronized (lock)
        {
            __output.flush();
        }
    }

    /***
     * Flushes the underlying output, writing all buffered output, but doesn't
     * actually close the underlying stream.  The underlying stream may still
     * be used for communicating with the server and therefore is not closed.
     * <p>
     * @exception IOException If an error occurs while writing to the underlying
     *            output or closing the Writer.
     ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.973 -0500", hash_original_method = "7531D5F82588F4D92692F66CB681201F", hash_generated_method = "F542C941445B636958D108896311DE9A")
    
public void close() throws IOException
    {
        synchronized (lock)
        {
            if (__output == null)
                return ;

            if (__state == __LAST_WAS_CR_STATE)
                __output.write('\n');
            else if (__state != __LAST_WAS_NL_STATE)
                __output.write("\r\n");

            __output.write(".\r\n");

            __output.flush();
            __output = null;
        }
    }

}
