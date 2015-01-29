/*
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
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Dumps data in hexadecimal format.
 * <p>
 * Provides a single function to take an array of bytes and display it
 * in hexadecimal form.
 * <p>
 * Origin of code: POI.
 *
 * @version $Id: HexDump.java 1302748 2012-03-20 01:35:32Z ggregory $
 */
public class HexDump {

    /**
     * Dump an array of bytes to an OutputStream. The output is formatted
     * for human inspection, with a hexadecimal offset followed by the
     * hexadecimal values of the next 16 bytes of data and the printable ASCII
     * characters (if any) that those bytes represent printed per each line
     * of output.
     * <p>
     * The offset argument specifies the start offset of the data array
     * within a larger entity like a file or an incoming stream. For example,
     * if the data array contains the third kibibyte of a file, then the
     * offset argument should be set to 2048. The offset value printed
     * at the beginning of each line indicates where in that larger entity
     * the first byte on that line is located.
     * <p>
     * All bytes between the given index (inclusive) and the end of the
     * data array are dumped. 
     *
     * @param data  the byte array to be dumped
     * @param offset  offset of the byte array within a larger entity
     * @param stream  the OutputStream to which the data is to be
     *               written
     * @param index initial index into the byte array
     *
     * @throws IOException is thrown if anything goes wrong writing
     *         the data to stream
     * @throws ArrayIndexOutOfBoundsException if the index is
     *         outside the data array's bounds
     * @throws IllegalArgumentException if the output stream is null
     */

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.620 -0400", hash_original_method = "472FEF71223996485998F30A706D4370", hash_generated_method = "328A6FCBACECA0A5D6BCAB9052A23BAE")
    
public static void dump(byte[] data, long offset,
                            OutputStream stream, int index)
            throws IOException, ArrayIndexOutOfBoundsException,
            IllegalArgumentException {
        
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException(
                    "illegal index: " + index + " into array of length "
                    + data.length);
        }
        if (stream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long display_offset = offset + index;
        StringBuilder buffer = new StringBuilder(74);

        for (int j = index; j < data.length; j += 16) {
            int chars_read = data.length - j;

            if (chars_read > 16) {
                chars_read = 16;
            }
            dump(buffer, display_offset).append(' ');
            for (int k = 0; k < 16; k++) {
                if (k < chars_read) {
                    dump(buffer, data[k + j]);
                } else {
                    buffer.append("  ");
                }
                buffer.append(' ');
            }
            for (int k = 0; k < chars_read; k++) {
                if (data[k + j] >= ' ' && data[k + j] < 127) {
                    buffer.append((char) data[k + j]);
                } else {
                    buffer.append('.');
                }
            }
            buffer.append(EOL);
            stream.write(buffer.toString().getBytes());
            stream.flush();
            buffer.setLength(0);
            display_offset += chars_read;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.620 -0400", hash_original_field = "7B56CABCDBC11F20C5534E47289C2309", hash_generated_field = "A7F0DD505858F5926B10790A390B4BA5")

    public static final String EOL =
            System.getProperty("line.separator");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.621 -0400", hash_original_field = "DFF59EB29C72C2007BEEFE541D2D567E", hash_generated_field = "B8FA09A9F521E192770D2BBBC2317DC7")

    private static final char[] _hexcodes =
            {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'
            };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.622 -0400", hash_original_field = "8547ECF03DFD06AE7020F614CDBCE107", hash_generated_field = "B4BAE99288E9B5FBB7D8F781B2DFB5E4")

    private static final int[] _shifts =
            {
                28, 24, 20, 16, 12, 8, 4, 0
            };

    /**
     * Dump a long value into a StringBuilder.
     *
     * @param _lbuffer the StringBuilder to dump the value in
     * @param value  the long value to be dumped
     * @return StringBuilder containing the dumped value.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.622 -0400", hash_original_method = "0A174ACDCB49B94165896CFEF9819231", hash_generated_method = "F5811F017433BFD7E87EDF7D2C287CBC")
    
private static StringBuilder dump(StringBuilder _lbuffer, long value) {
        for (int j = 0; j < 8; j++) {
            _lbuffer
                    .append(_hexcodes[(int) (value >> _shifts[j]) & 15]);
        }
        return _lbuffer;
    }

    /**
     * Dump a byte value into a StringBuilder.
     *
     * @param _cbuffer the StringBuilder to dump the value in
     * @param value  the byte value to be dumped
     * @return StringBuilder containing the dumped value.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.623 -0400", hash_original_method = "61EC9166C8D178CBF739391CDD148490", hash_generated_method = "C098EAE839A3218982538AE4F7B2246C")
    
private static StringBuilder dump(StringBuilder _cbuffer, byte value) {
        for (int j = 0; j < 2; j++) {
            _cbuffer.append(_hexcodes[value >> _shifts[j + 6] & 15]);
        }
        return _cbuffer;
    }

    /**
     * Instances should NOT be constructed in standard programming.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:51.618 -0400", hash_original_method = "DD2FEACFBC451CD61B40E6EB3CDE5668", hash_generated_method = "94A9868306918A882FF5FEC269365CA6")
    
public HexDump() {
        super();
    }

}
