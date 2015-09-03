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


package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;

/**
 * Byte Order Mark (BOM) representation - see {@link org.apache.commons.io.input.BOMInputStream}.
 * 
 * @see org.apache.commons.io.input.BOMInputStream
 * @see <a href="http://en.wikipedia.org/wiki/Byte_order_mark">Wikipedia: Byte Order Mark</a>
 * @see <a href="http://www.w3.org/TR/2006/REC-xml-20060816/#sec-guessing">W3C: Autodetection of Character Encodings
 *      (Non-Normative)</a>
 * @version $Id: ByteOrderMark.java 1347571 2012-06-07 11:13:53Z sebb $
 * @since 2.0
 */
public class ByteOrderMark implements Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.340 -0400", hash_original_field = "7D07EDF60BE7D52BF87500AC6D8FE154", hash_generated_field = "712212474A80BD328114C4C1DC66CBA3")

    private static final long serialVersionUID = 1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.341 -0400", hash_original_field = "361BD621F8B38984C52DEB702F68B909", hash_generated_field = "0EE4AB34DF3A7FE0C980C2CEA09B7D92")

    public static final ByteOrderMark UTF_8    = new ByteOrderMark("UTF-8",    0xEF, 0xBB, 0xBF);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.341 -0400", hash_original_field = "D7F67E4B0D3B1E068DF63C745CAED00C", hash_generated_field = "3D14B45311CE99ADDEB6EC56F8774A9D")

    public static final ByteOrderMark UTF_16BE = new ByteOrderMark("UTF-16BE", 0xFE, 0xFF);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.342 -0400", hash_original_field = "49C48E2D9083C7946CFEC8F2B02ECE1E", hash_generated_field = "3750D0C2B02CE14E57B1BE9ACECF0D11")

    public static final ByteOrderMark UTF_16LE = new ByteOrderMark("UTF-16LE", 0xFF, 0xFE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.342 -0400", hash_original_field = "D133691FD77613D19A666B2CB17DF58E", hash_generated_field = "1DEE4DE7020627F1CE1135D702465501")

    public static final ByteOrderMark UTF_32BE = new ByteOrderMark("UTF-32BE", 0x00, 0x00, 0xFE, 0xFF);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.343 -0400", hash_original_field = "701B7EA1ECF9477FB24E8F9008EDC581", hash_generated_field = "A3C920E79D82B803677D117982E9CAFA")

    public static final ByteOrderMark UTF_32LE = new ByteOrderMark("UTF-32LE", 0xFF, 0xFE, 0x00, 0x00);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.343 -0400", hash_original_field = "5E24356DE8A42080D6D8EE74FC7DBA00", hash_generated_field = "294F0480F54B014FA8831418027DC6AA")
    
    private  String charsetName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.344 -0400", hash_original_field = "A3AB97F2F3BEC6A125773562CC36361E", hash_generated_field = "0C5E046695D7217A9F5EC920641D817A")

    private  int[] bytes;

    /**
     * Construct a new BOM.
     *
     * @param charsetName The name of the charset the BOM represents
     * @param bytes The BOM's bytes
     * @throws IllegalArgumentException if the charsetName is null or
     * zero length
     * @throws IllegalArgumentException if the bytes are null or zero
     * length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.344 -0400", hash_original_method = "482ECF37ABE57D8C1F1786C0CD279E80", hash_generated_method = "770ACB14E673B71C24836B63811E0BB1")
    
public ByteOrderMark(String charsetName, int... bytes) {
        if (charsetName == null || charsetName.length() == 0) {
            throw new IllegalArgumentException("No charsetName specified");
        }
        if (bytes == null || bytes.length == 0) {
            throw new IllegalArgumentException("No bytes specified");
        }
        this.charsetName = charsetName;
        this.bytes = new int[bytes.length];
        System.arraycopy(bytes, 0, this.bytes, 0, bytes.length);
    }

    /**
     * Return the name of the {@link java.nio.charset.Charset} the BOM represents.
     *
     * @return the character set name
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.345 -0400", hash_original_method = "62D3F36CA78A6EC4185A2D1A05C169E6", hash_generated_method = "C3E3B8FCC038ED1DFB7C6F3AF5424FEA")
    
public String getCharsetName() {
        return charsetName;
    }

    /**
     * Return the length of the BOM's bytes.
     *
     * @return the length of the BOM's bytes
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.345 -0400", hash_original_method = "52567BA40A41F53DE2F6B00E0A08B85C", hash_generated_method = "7B4516413F39E90CDAA552700076F548")
    
public int length() {
        return bytes.length;
    }

    /**
     * The byte at the specified position.
     *
     * @param pos The position
     * @return The specified byte
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.346 -0400", hash_original_method = "97E73E03DAE09D2D62A9AEEE833FF79F", hash_generated_method = "09CF3219318509718A488D49B6696578")
    
public int get(int pos) {
        return bytes[pos];
    }

    /**
     * Return a copy of the BOM's bytes.
     *
     * @return a copy of the BOM's bytes
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.346 -0400", hash_original_method = "78D0BF90C8B8ABA8109AF21E9A6358BA", hash_generated_method = "D4069B6A2C0591A3AB9CA032DD4FF4F9")
    
public byte[] getBytes() {
        byte[] copy = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            copy[i] = (byte)bytes[i];
        }
        return copy;
    }

    /**
     * Indicates if this BOM's bytes equals another.
     *
     * @param obj The object to compare to
     * @return true if the bom's bytes are equal, otherwise
     * false
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.347 -0400", hash_original_method = "17B283E675F13C0A62946A353F07CD53", hash_generated_method = "E45B81EF177F99E3E73457DF095A84DF")
    
@Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ByteOrderMark)) {
            return false;
        }
        ByteOrderMark bom = (ByteOrderMark)obj;
        if (bytes.length != bom.length()) {
            return false;
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != bom.get(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Return the hashcode for this BOM.
     *
     * @return the hashcode for this BOM.
     * @see java.lang.Object#hashCode()
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.348 -0400", hash_original_method = "16009F7E89FC8CC2A15B27C66C701DE5", hash_generated_method = "3DD76A0217B2D72589AB0D1EEAB20583")
    
@Override
    public int hashCode() {
        int hashCode = getClass().hashCode();
        for (int b : bytes) {
            hashCode += b;
        }
        return hashCode;
    }

    /**
     * Provide a String representation of the BOM.
     *
     * @return the length of the BOM's bytes
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:53.349 -0400", hash_original_method = "C1269ADA454FD9CDC780161D09FCDB9A", hash_generated_method = "AC30A26E48F08317DEBC958B804C2453")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append('[');
        builder.append(charsetName);
        builder.append(": ");
        for (int i = 0; i < bytes.length; i++) {
            if (i > 0) {
                builder.append(",");
            }
            builder.append("0x");
            builder.append(Integer.toHexString(0xFF & bytes[i]).toUpperCase());
        }
        builder.append(']');
        return builder.toString();
    }

}
