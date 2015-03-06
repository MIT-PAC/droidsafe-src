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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Alexander Y. Kleymenov
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.charset.Charsets;

import libcore.util.EmptyArray;

public final class Base64 {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.154 -0500", hash_original_method = "8535EDDE1B82B493909B7A5D7029E7BE", hash_generated_method = "6A8FCF4552AAB657EB72B7C62E120750")
    
public static byte[] decode(byte[] in) {
        return decode(in, in.length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.157 -0500", hash_original_method = "C6A868DEF1696F686F485C4F95484204", hash_generated_method = "BB0A9EA117B311C37A5055FCC0BB6D2B")
    
public static byte[] decode(byte[] in, int len) {
        // approximate output length
        int length = len / 4 * 3;
        // return an empty array on empty or short input without padding
        if (length == 0) {
            return EmptyArray.BYTE;
        }
        // temporary array
        byte[] out = new byte[length];
        // number of padding characters ('=')
        int pad = 0;
        byte chr;
        // compute the number of the padding characters
        // and adjust the length of the input
        for (;;len--) {
            chr = in[len-1];
            // skip the neutral characters
            if ((chr == '\n') || (chr == '\r') ||
                    (chr == ' ') || (chr == '\t')) {
                continue;
            }
            if (chr == '=') {
                pad++;
            } else {
                break;
            }
        }
        // index in the output array
        int outIndex = 0;
        // index in the input array
        int inIndex = 0;
        // holds the value of the input character
        int bits = 0;
        // holds the value of the input quantum
        int quantum = 0;
        for (int i=0; i<len; i++) {
            chr = in[i];
            // skip the neutral characters
            if ((chr == '\n') || (chr == '\r') ||
                    (chr == ' ') || (chr == '\t')) {
                continue;
            }
            if ((chr >= 'A') && (chr <= 'Z')) {
                // char ASCII value
                //  A    65    0
                //  Z    90    25 (ASCII - 65)
                bits = chr - 65;
            } else if ((chr >= 'a') && (chr <= 'z')) {
                // char ASCII value
                //  a    97    26
                //  z    122   51 (ASCII - 71)
                bits = chr - 71;
            } else if ((chr >= '0') && (chr <= '9')) {
                // char ASCII value
                //  0    48    52
                //  9    57    61 (ASCII + 4)
                bits = chr + 4;
            } else if (chr == '+') {
                bits = 62;
            } else if (chr == '/') {
                bits = 63;
            } else {
                return null;
            }
            // append the value to the quantum
            quantum = (quantum << 6) | (byte) bits;
            if (inIndex%4 == 3) {
                // 4 characters were read, so make the output:
                out[outIndex++] = (byte) (quantum >> 16);
                out[outIndex++] = (byte) (quantum >> 8);
                out[outIndex++] = (byte) quantum;
            }
            inIndex++;
        }
        if (pad > 0) {
            // adjust the quantum value according to the padding
            quantum = quantum << (6*pad);
            // make output
            out[outIndex++] = (byte) (quantum >> 16);
            if (pad == 1) {
                out[outIndex++] = (byte) (quantum >> 8);
            }
        }
        // create the resulting array
        byte[] result = new byte[outIndex];
        System.arraycopy(out, 0, result, 0, outIndex);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.163 -0500", hash_original_method = "3951A54D7E58E025CF9BE59B6C0BF589", hash_generated_method = "FE53652097EBC8DA4AE52F4B93D33BD1")
    
public static String encode(byte[] in) {
        int length = (in.length + 2) * 4 / 3;
        byte[] out = new byte[length];
        int index = 0, end = in.length - in.length % 3;
        for (int i = 0; i < end; i += 3) {
            out[index++] = map[(in[i] & 0xff) >> 2];
            out[index++] = map[((in[i] & 0x03) << 4) | ((in[i+1] & 0xff) >> 4)];
            out[index++] = map[((in[i+1] & 0x0f) << 2) | ((in[i+2] & 0xff) >> 6)];
            out[index++] = map[(in[i+2] & 0x3f)];
        }
        switch (in.length % 3) {
            case 1:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[(in[end] & 0x03) << 4];
                out[index++] = '=';
                out[index++] = '=';
                break;
            case 2:
                out[index++] = map[(in[end] & 0xff) >> 2];
                out[index++] = map[((in[end] & 0x03) << 4) | ((in[end+1] & 0xff) >> 4)];
                out[index++] = map[((in[end+1] & 0x0f) << 2)];
                out[index++] = '=';
                break;
        }
        return new String(out, 0, index, Charsets.US_ASCII);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.160 -0500", hash_original_field = "3063CAA3327D5F99524D47E8A719D4E8", hash_generated_field = "82F1210628F15E92912F89A88C162707")

    private static final byte[] map = new byte[]
        {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
         'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b',
         'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
         'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
         '4', '5', '6', '7', '8', '9', '+', '/'};
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:26.151 -0500", hash_original_method = "B12DC6BE1A1E2EB3A4F484EDEACB8E03", hash_generated_method = "C3084AA7D5019852EF92F271F4A0E81D")
    
private Base64() {
    }
}

