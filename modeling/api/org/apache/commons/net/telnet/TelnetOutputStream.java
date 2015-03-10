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


package org.apache.commons.net.telnet;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;

/***
 *
 * <p>
 *
 * <p>
 * <p>
 * @author Daniel F. Savarese
 ***/

final class TelnetOutputStream extends OutputStream
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.691 -0500", hash_original_field = "C86EE9323E0FFDBCF8BA85F6EF05A76C", hash_generated_field = "3FE186602BDE6904EF3E01EF9B657DE2")

    private TelnetClient __client;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.697 -0500", hash_original_field = "06CA9F9DF3DD7CEBEBA1DC2417665E62", hash_generated_field = "37904A9CFB6537D7F03C6C0DB02A2CF7")

    private boolean __convertCRtoCRLF = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.702 -0500", hash_original_field = "7F88404C93089BE0A5A036CED13C688B", hash_generated_field = "7FD929B8022F592655188BA38748A5AA")

    private boolean __lastWasCR = false;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.709 -0500", hash_original_method = "BC45335022C1F0D0E45CC4F361BA0D9E", hash_generated_method = "BC45335022C1F0D0E45CC4F361BA0D9E")
    
TelnetOutputStream(TelnetClient client)
    {
        __client = client;
    }

    /***
     * Writes a byte to the stream.
     * <p>
     * @param ch The byte to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSSink({DSSinkKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.716 -0500", hash_original_method = "7CB4C89F951B084D5A9568880FECD763", hash_generated_method = "FD10B01E03D296994182FBFE110A5ED1")
    
public void write(int ch) throws IOException
    {

        synchronized (__client)
        {
            ch &= 0xff;

            if (__client._requestedWont(TelnetOption.BINARY))
            {
                if (__lastWasCR)
                {
                    if (__convertCRtoCRLF)
                    {
                        __client._sendByte('\n');
                        if (ch == '\n')
                        {
                            __lastWasCR = false;
                            return ;
                        }
                    }
                    else if (ch != '\n')
                        __client._sendByte('\0');
                }

                __lastWasCR = false;

                switch (ch)
                {
                case '\r':
                    __client._sendByte('\r');
                    __lastWasCR = true;
                    break;
                case TelnetCommand.IAC:
                    __client._sendByte(TelnetCommand.IAC);
                    __client._sendByte(TelnetCommand.IAC);
                    break;
                default:
                    __client._sendByte(ch);
                    break;
                }
            }
            else if (ch == TelnetCommand.IAC)
            {
                __client._sendByte(ch);
                __client._sendByte(TelnetCommand.IAC);
            }
            else
                __client._sendByte(ch);
        }
    }

    /***
     * Writes a byte array to the stream.
     * <p>
     * @param buffer  The byte array to write.
     * @exception IOException If an error occurs while writing to the underlying
     *            stream.
     ***/
    @DSSink({DSSinkKind.IO})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.722 -0500", hash_original_method = "11AFF6C7676FEB0968CBC8B8BF9C6A52", hash_generated_method = "7B429BF57D2613ACA216D7C75DB980D2")
    
public void write(byte buffer[]) throws IOException
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
    @DSSink({DSSinkKind.NETWORK})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.727 -0500", hash_original_method = "4D9812CB7B4C707FB9C13C6326E2C974", hash_generated_method = "A70E7E76449691363F4039939B60F329")
    
public void write(byte buffer[], int offset, int length) throws IOException
    {
        synchronized (__client)
        {
            while (length-- > 0)
                write(buffer[offset++]);
        }
    }

    /*** Flushes the stream. ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.730 -0500", hash_original_method = "FD99F31E2E5FFE52E771381277CA5731", hash_generated_method = "68B07C7A80A5D78448CDD84F069CBA73")
    
public void flush() throws IOException
    {
        __client._flushOutputStream();
    }

    /*** Closes the stream. ***/
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:59.734 -0500", hash_original_method = "03A9192B11B1B736885F96C916CDF0FD", hash_generated_method = "5B1061F01B494E85EEEDD7C8238270A5")
    
public void close() throws IOException
    {
        __client._closeOutputStream();
    }
}
