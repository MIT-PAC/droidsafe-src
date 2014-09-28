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
import java.io.PushbackReader;
import java.io.Reader;

/**
 * DotTerminatedMessageReader is a class used to read messages from a
 * server that are terminated by a single dot followed by a
 * &lt;CR&gt;&lt;LF&gt;
 * sequence and with double dots appearing at the begining of lines which
 * do not signal end of message yet start with a dot.  Various Internet
 * protocols such as NNTP and POP3 produce messages of this type.
 * <p>
 * This class handles stripping of the duplicate period at the beginning
 * of lines starting with a period, converts NETASCII newlines to the
 * local line separator format, truncates the end of message indicator,
 * and ensures you cannot read past the end of the message.
 * @author <a href="mailto:savarese@apache.org">Daniel F. Savarese</a>
 * @version $Id: DotTerminatedMessageReader.java 165675 2005-05-02 20:09:55Z rwinston $
 */
public final class DotTerminatedMessageReader extends Reader
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.624 -0500", hash_original_field = "603B63878F33FA04A2C6D49584A486C3", hash_generated_field = "EB012EEE79305A63403A677F21F99C22")

    private static  String LS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.627 -0500", hash_original_field = "1A4E2B188ECC7382F638BE603CFAF76D", hash_generated_field = "971FDBC5CFFF0164F097106F61E1ACD5")

    private static  char[] LS_CHARS;

    static
    {
        LS = System.getProperty("line.separator");
        LS_CHARS = LS.toCharArray();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.631 -0500", hash_original_field = "DE99D136869D4043B79E4FA0D6E7FB41", hash_generated_field = "F1CDF3C91EA45CBB5C4D2E1AB6ED5722")

    private boolean atBeginning;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.634 -0500", hash_original_field = "F63D5C2A3218247517725999753A7A52", hash_generated_field = "5CB70878869318B356B4B3C25335C11E")

    private boolean eof;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.638 -0500", hash_original_field = "5780BC7BCF265A6425A5A90F1AD9B24E", hash_generated_field = "74B29150B9CA7F1725D53FF286BFBC4B")

    private int pos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.641 -0500", hash_original_field = "DF148F444A49761E734388D9E8CC370E", hash_generated_field = "9F56A8DFB1E1C26223363D287CEDB01C")

    private char[] internalBuffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.645 -0500", hash_original_field = "079FFA0A62CC23BA07389D727B8B1FE8", hash_generated_field = "2B28E164E9AD3B2735003661E995D0D0")

    private PushbackReader internalReader;

    /**
     * Creates a DotTerminatedMessageReader that wraps an existing Reader
     * input source.
     * @param reader  The Reader input source containing the message.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.649 -0500", hash_original_method = "5F0168F87C9D2A44BA2B8F8ED212E0A4", hash_generated_method = "93F0EF4DDF0AF87DDB7A69D318F3F3AC")
    
    @DSSafe(DSCat.SAFE_OTHERS)
public DotTerminatedMessageReader(Reader reader)
    {
        super(reader);
        internalBuffer = new char[LS_CHARS.length + 3];
        pos = internalBuffer.length;
        // Assumes input is at start of message
        atBeginning = true;
        eof = false;
        internalReader = new PushbackReader(reader);
    }

    /**
     * Reads and returns the next character in the message.  If the end of the
     * message has been reached, returns -1.  Note that a call to this method
     * may result in multiple reads from the underlying input stream to decode
     * the message properly (removing doubled dots and so on).  All of
     * this is transparent to the programmer and is only mentioned for
     * completeness.
     * @return The next character in the message. Returns -1 if the end of the
     *          message has been reached.
     * @exception IOException If an error occurs while reading the underlying
     *            stream.
     */
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.655 -0500", hash_original_method = "31E0BE08E1B2B985E35B0612944B01C1", hash_generated_method = "638C5AFEA3994937953C50E97D9FE696")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read() throws IOException
    {
        int ch;

        synchronized (lock)
        {
            if (pos < internalBuffer.length)
            {
                return internalBuffer[pos++];
            }

            if (eof)
            {
                return -1;
            }

            if ((ch = internalReader.read()) == -1)
            {
                eof = true;
                return -1;
            }

            if (atBeginning)
            {
                atBeginning = false;
                if (ch == '.')
                {
                    ch = internalReader.read();

                    if (ch != '.')
                    {
                        // read newline
                        eof = true;
                        internalReader.read();
                        return -1;
                    }
                    else
                    {
                        return '.';
                    }
                }
            }

            if (ch == '\r')
            {
                ch = internalReader.read();

                if (ch == '\n')
                {
                    ch = internalReader.read();

                    if (ch == '.')
                    {
                        ch = internalReader.read();

                        if (ch != '.')
                        {
                            // read newline and indicate end of file
                            internalReader.read();
                            eof = true;
                        }
                        else
                        {
                            internalBuffer[--pos] = (char) ch;
                        }
                    }
                    else
                    {
                        internalReader.unread(ch);
                    }

                    pos -= LS_CHARS.length;
                    System.arraycopy(LS_CHARS, 0, internalBuffer, pos,
                                     LS_CHARS.length);
                    ch = internalBuffer[pos++];
                }
                else
                {
                    internalBuffer[--pos] = (char) ch;
                    return '\r';
                }
            }

            return ch;
        }
    }

    /**
     * Reads the next characters from the message into an array and
     * returns the number of characters read.  Returns -1 if the end of the
     * message has been reached.
     * @param buffer  The character array in which to store the characters.
     * @return The number of characters read. Returns -1 if the
     *          end of the message has been reached.
     * @exception IOException If an error occurs in reading the underlying
     *            stream.
     */
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.660 -0500", hash_original_method = "65554F0C302DA5F8C76906F90F535223", hash_generated_method = "684EA5F33B6E7AA3FC0B779B5BE44EC3")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(char[] buffer) throws IOException
    {
        return read(buffer, 0, buffer.length);
    }

    /**
     * Reads the next characters from the message into an array and
     * returns the number of characters read.  Returns -1 if the end of the
     * message has been reached.  The characters are stored in the array
     * starting from the given offset and up to the length specified.
     * @param buffer  The character array in which to store the characters.
     * @param offset   The offset into the array at which to start storing
     *              characters.
     * @param length   The number of characters to read.
     * @return The number of characters read. Returns -1 if the
     *          end of the message has been reached.
     * @exception IOException If an error occurs in reading the underlying
     *            stream.
     */
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.663 -0500", hash_original_method = "297F7CC520BE2F901AA36D11D965CF70", hash_generated_method = "F2D860805EDA4A832B634194E89F311B")
    @DSVerified
    @DSSpec(DSCat.IO)
public int read(char[] buffer, int offset, int length) throws IOException
    {
        addTaint(offset);
        addTaint(length);
        buffer.addTaint(getTaint());
        
        return buffer.getTaintInt();
    }

    /**
     * Determines if the message is ready to be read.
     * @return True if the message is ready to be read, false if not.
     * @exception IOException If an error occurs while checking the underlying
     *            stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.666 -0500", hash_original_method = "312B0BBDB8B9F957CA62333F3425B34A", hash_generated_method = "146CA1B4249C7657C86A7CD7358090AF")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public boolean ready() throws IOException
    {
        return getTaintBoolean();
    }

    /**
     * Closes the message for reading.  This doesn't actually close the
     * underlying stream.  The underlying stream may still be used for
     * communicating with the server and therefore is not closed.
     * <p>
     * If the end of the message has not yet been reached, this method
     * will read the remainder of the message until it reaches the end,
     * so that the underlying stream may continue to be used properly
     * for communicating with the server.  If you do not fully read
     * a message, you MUST close it, otherwise your program will likely
     * hang or behave improperly.
     * @exception IOException  If an error occurs while reading the
     *            underlying stream.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:05.670 -0500", hash_original_method = "9C47CBAA33D56EB05E095A69AEB3F55A", hash_generated_method = "3F2D341E8B187C6DA677EC304D5C7996")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public void close() throws IOException
    {
        synchronized (lock)
        {
            if (internalReader == null)
            {
                return;
            }

            if (!eof)
            {
                while (read() != -1)
                {
                    ;
                }
            }
            eof = true;
            atBeginning = false;
            pos = internalBuffer.length;
            internalReader = null;
        }
    }
}
