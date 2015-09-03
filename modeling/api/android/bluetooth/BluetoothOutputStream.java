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
 * Copyright (C) 2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
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


package android.bluetooth;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.OutputStream;

final class BluetoothOutputStream extends OutputStream {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.494 -0500", hash_original_field = "F88CEEEA2A0982472DB6E6356FAA58B9", hash_generated_field = "F41529E7146F039F8982FD61509E896F")

    private BluetoothSocket mSocket;

    /*package*/ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.496 -0500", hash_original_method = "6B802CCB266833E5725B115B8F18B649", hash_generated_method = "6B802CCB266833E5725B115B8F18B649")
    
BluetoothOutputStream(BluetoothSocket s) {
        mSocket = s;
    }

    /**
     * Close this output stream and the socket associated with it.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.498 -0500", hash_original_method = "1323B57D07CB6385C2F8CE9373488A22", hash_generated_method = "C95071B8627034E7D9B94D5D2A0541A3")
    
public void close() throws IOException {
        mSocket.close();
    }

    /**
     * Writes a single byte to this stream. Only the least significant byte of
     * the integer {@code oneByte} is written to the stream.
     *
     * @param oneByte
     *            the byte to be written.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     * @since Android 1.0
     */
    @DSSink({DSSinkKind.BLUETOOTH})
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.500 -0500", hash_original_method = "B2E185518772C6191E25665E6AAA6FD5", hash_generated_method = "2D5A46C23DD97DDE153E0C9506B1B72B")
    
public void write(int oneByte) throws IOException {
        byte b[] = new byte[1];
        b[0] = (byte)oneByte;
        mSocket.write(b, 0, 1);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting
     * at position {@code offset} to this stream.
     *
     * @param b
     *            the buffer to be written.
     * @param offset
     *            the start position in {@code buffer} from where to get bytes.
     * @param count
     *            the number of bytes from {@code buffer} to write to this
     *            stream.
     * @throws IOException
     *             if an error occurs while writing to this stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code count < 0}, or if
     *             {@code offset + count} is bigger than the length of
     *             {@code buffer}.
     * @since Android 1.0
     */
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.IO})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:34.503 -0500", hash_original_method = "DFA6C29609C7324702E3356FC466F21E", hash_generated_method = "7AAC56040D447F28CDAF031F1B6BE1B8")
    
public void write(byte[] b, int offset, int count) throws IOException {
        if (b == null) {
            throw new NullPointerException("buffer is null");
        }
        if ((offset | count) < 0 || count > b.length - offset) {
            throw new IndexOutOfBoundsException("invalid offset or length");
        }
        mSocket.write(b, offset, count);
    }
    
}

