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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.io.input;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.DataInput;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.EndianUtils;

/**
 * DataInput for systems relying on little endian data formats.
 * When read, values will be changed from little endian to big 
 * endian formats for internal usage. 
 * <p>
 * <b>Origin of code: </b>Avalon Excalibur (IO)
 *
 * @version CVS $Revision: 1302050 $
 */
public class SwappedDataInputStream extends ProxyInputStream
    implements DataInput
{

    /**
     * Constructs a SwappedDataInputStream.
     *
     * @param input InputStream to read from
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.762 -0400", hash_original_method = "C54F0CC2DA015E75B52724488AA233EF", hash_generated_method = "A59A83563FF6FF0A8C9F9DDE17ECD4F9")
    
public SwappedDataInputStream( InputStream input )
    {
        super( input );
    }

    /**
     * Return <code>{@link #readByte()} != 0</code>
     * @return false if the byte read is zero, otherwise true
     * @throws IOException if an I/O error occurs
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.762 -0400", hash_original_method = "C6E52C66D7D123E3533290F6D5AFC7C2", hash_generated_method = "D26AD4B4F430F5DC30B30408E607E55C")
    
public boolean readBoolean()
        throws IOException, EOFException
    {
        return 0 != readByte();
    }

    /**
     * Invokes the delegate's <code>read()</code> method.
     * @return the byte read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.763 -0400", hash_original_method = "29D7601B80549C4B9C567F426A16BACB", hash_generated_method = "419F4D0159CC5D65D0B2C8B1333318F8")
    
public byte readByte()
        throws IOException, EOFException
    {
        return (byte)in.read();
    }

    /**
     * Reads a character delegating to {@link #readShort()}.
     * @return the byte read or -1 if the end of stream
     * @throws IOException if an I/O error occurs
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.763 -0400", hash_original_method = "8E7A427A98E0CBF45D66268DB7B1B5CD", hash_generated_method = "FAB186C986DFF960961A3A57D92BBE52")
    
public char readChar()
        throws IOException, EOFException
    {
        return (char)readShort();
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedDouble(InputStream)}. 
     * @return the read long
     * @throws IOException if an I/O error occurs
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.764 -0400", hash_original_method = "E0B187CE0A555FF37672F5C84109272C", hash_generated_method = "D648F86C5E26362A2EE167A799F9D4C8")
    
public double readDouble()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedDouble( in );
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedFloat(InputStream)}. 
     * @return the read long
     * @throws IOException if an I/O error occurs
     * @throws EOFException if an end of file is reached unexpectedly
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.764 -0400", hash_original_method = "2E4D15B0B4A0FBF0E7EA1877C828CDC6", hash_generated_method = "D4F4ECFE901EA7F02BE51F8343502990")
    
public float readFloat()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedFloat( in );
    }

    /**
     * Invokes the delegate's <code>read(byte[] data, int, int)</code> method.
     * 
     * @param data the buffer to read the bytes into
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.765 -0400", hash_original_method = "BDF1FFA031B8E898D91BB8F353BF6070", hash_generated_method = "128B50D0F631BE8F91C72911C314314F")
    
public void readFully( byte[] data )
        throws IOException, EOFException
    {
        readFully( data, 0, data.length );
    }

    /**
     * Invokes the delegate's <code>read(byte[] data, int, int)</code> method.
     * 
     * @param data the buffer to read the bytes into
     * @param offset The start offset
     * @param length The number of bytes to read
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.765 -0400", hash_original_method = "C68A979C97C9773BF4E1D97780D466BC", hash_generated_method = "ABED2FB5692629886742AFEF5BC17E85")
    
public void readFully( byte[] data, int offset, int length )
        throws IOException, EOFException
    {
        int remaining = length;

        while( remaining > 0 )
        {
            int location = offset + length - remaining;
            int count = read( data, location, remaining );

            if( -1 == count )
            {
                throw new EOFException();
            }

            remaining -= count;
        }
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedInteger(InputStream)}. 
     * @return the read long
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.766 -0400", hash_original_method = "924D53EB92B2DC5D270610CAC14BB6FD", hash_generated_method = "4277ED708E86189BF2FEB5268789BDAF")
    
public int readInt()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedInteger( in );
    }

    /**
     * Not currently supported - throws {@link UnsupportedOperationException}.
     * @return the line read
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.766 -0400", hash_original_method = "6DEA886173F95E4A3BBF989737ED1DB7", hash_generated_method = "A7E838FF9731D224516E86B79C09E7FA")
    
public String readLine()
        throws IOException, EOFException
    {
        throw new UnsupportedOperationException( 
                "Operation not supported: readLine()" );
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedLong(InputStream)}. 
     * @return the read long
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.767 -0400", hash_original_method = "CC507B2A57FF0027D07E24F5AD4CD5D0", hash_generated_method = "8D17396B790650D5CEF04C6769626224")
    
public long readLong()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedLong( in );
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedShort(InputStream)}. 
     * @return the read long
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.767 -0400", hash_original_method = "147194CFB85434C80763957452B45FC6", hash_generated_method = "0EDAC77C37F768262C2CA4024B50C9E2")
    
public short readShort()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedShort( in );
    }

    /**
     * Invokes the delegate's <code>read()</code> method.
     * @return the byte read or -1 if the end of stream
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.768 -0400", hash_original_method = "712AFF9E606E487D08D6F6FFCD673798", hash_generated_method = "DBA31CEC7B2083D3AF3DB5830C33BE25")
    
public int readUnsignedByte()
        throws IOException, EOFException
    {
        return in.read();
    }

    /**
     * Delegates to {@link EndianUtils#readSwappedUnsignedShort(InputStream)}. 
     * @return the read long
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.768 -0400", hash_original_method = "447E5EB8854335FBF10C9BDB3B1A51D4", hash_generated_method = "FDFEB6C3E21CB15D05AB843366CC911E")
    
public int readUnsignedShort()
        throws IOException, EOFException
    {
        return EndianUtils.readSwappedUnsignedShort( in );
    }

    /**
     * Not currently supported - throws {@link UnsupportedOperationException}.
     * @return UTF String read
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.769 -0400", hash_original_method = "DF617DE965D7ED4B9960FC14A4BE0BB9", hash_generated_method = "61396E41E6BCB81B41A8595CA0CAA00D")
    
public String readUTF()
        throws IOException, EOFException
    {
        throw new UnsupportedOperationException( 
                "Operation not supported: readUTF()" );
    }

    /**
     * Invokes the delegate's <code>skip(int)</code> method.
     * @param count the number of bytes to skip
     * @return the number of bytes to skipped or -1 if the end of stream
     * @throws EOFException if an end of file is reached unexpectedly
     * @throws IOException if an I/O error occurs
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:52.770 -0400", hash_original_method = "F2ACC4611C0738057C364BC3F2D0ADCF", hash_generated_method = "AA4E251D5D22BF2E993C6021EB795949")
    
public int skipBytes( int count )
        throws IOException, EOFException
    {
        return (int)in.skip( count );
    }

}
