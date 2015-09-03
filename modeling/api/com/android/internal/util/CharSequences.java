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
 * Copyright (C) 2007 The Android Open Source Project
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


package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class CharSequences {
    
    public static CharSequence forAsciiBytes(final byte[] bytes) {
        return new CharSequence() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.168 -0500", hash_original_method = "7182E2CD4878FCE5F8BD74EF7161C3FC", hash_generated_method = "53F8F55F89153BC1B927409211C341B4")
            
public char charAt(int index) {
                return (char) bytes[index];
            }

            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.171 -0500", hash_original_method = "52567BA40A41F53DE2F6B00E0A08B85C", hash_generated_method = "7B4516413F39E90CDAA552700076F548")
            
public int length() {
                return bytes.length;
            }

            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.173 -0500", hash_original_method = "5254A93D454BF96918F4C2721EC9AA9A", hash_generated_method = "67702ACD6F445D2A54DA6DFEC6E23CD9")
            
public CharSequence subSequence(int start, int end) {
                return forAsciiBytes(bytes, start, end);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.176 -0500", hash_original_method = "7C2C56FB3732C224B091B5BD6DEEAA83", hash_generated_method = "ACF017E3363BD9800A5BCCE862131C11")
            
public String toString() {
                return new String(bytes);
            }
        };
    }
    
    public static CharSequence forAsciiBytes(final byte[] bytes,
            final int start, final int end) {
        validate(start, end, bytes.length);
        return new CharSequence() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.181 -0500", hash_original_method = "F8CE755EEADC1ED238F4B18B313AD192", hash_generated_method = "97132914E991C20CE3CB3DDDB8685D49")
            
public char charAt(int index) {
                return (char) bytes[index + start];
            }

            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.184 -0500", hash_original_method = "64984B1D62BA1BB7B1B01F4291290D97", hash_generated_method = "3801A8CF35468C326C420142A889A245")
            
public int length() {
                return end - start;
            }

            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.186 -0500", hash_original_method = "2B0597C3C53D66FD7E304CE961910884", hash_generated_method = "43F65E7790117A8AAB2EADB45FB6CC89")
            
public CharSequence subSequence(int newStart, int newEnd) {
                newStart -= start;
                newEnd -= start;
                validate(newStart, newEnd, length());
                return forAsciiBytes(bytes, newStart, newEnd);
            }

            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.189 -0500", hash_original_method = "975DC91CAFA5FB6A1461F2497562D7C6", hash_generated_method = "BEF38995409F0E04B2C12111AA6A7EE6")
            
public String toString() {
                return new String(bytes, start, length());
            }
        };
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.193 -0500", hash_original_method = "DDE0D9367C1202DE20513CB9F79F1693", hash_generated_method = "1F58DD856E6A80B19F38E2A41E5D4F16")
    
static void validate(int start, int end, int length) {
        if (start < 0) throw new IndexOutOfBoundsException();
        if (end < 0) throw new IndexOutOfBoundsException();
        if (end > length) throw new IndexOutOfBoundsException();
        if (start > end) throw new IndexOutOfBoundsException();
    }

    /**
     * Compares two character sequences for equality.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.196 -0500", hash_original_method = "F74760D693CA529902BCB312B806950B", hash_generated_method = "ACE28FFFFD1910883FF056D2EADE1DDB")
    
public static boolean equals(CharSequence a, CharSequence b) {
        if (a.length() != b.length()) {
            return false;
        }

        int length = a.length();
        for (int i = 0; i < length; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Compares two character sequences with API like {@link Comparable#compareTo}.
     * 
     * @param me The CharSequence that receives the compareTo call.
     * @param another The other CharSequence.
     * @return See {@link Comparable#compareTo}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:46.198 -0500", hash_original_method = "30B0576607E957E5493C9E24E0793D3E", hash_generated_method = "2CAECD8D3E6103CF89B8E41387BFE928")
    
public static int compareToIgnoreCase(CharSequence me, CharSequence another) {
        // Code adapted from String#compareTo
        int myLen = me.length(), anotherLen = another.length();
        int myPos = 0, anotherPos = 0, result;
        int end = (myLen < anotherLen) ? myLen : anotherLen;

        while (myPos < end) {
            if ((result = Character.toLowerCase(me.charAt(myPos++))
                    - Character.toLowerCase(another.charAt(anotherPos++))) != 0) {
                return result;
            }
        }
        return myLen - anotherLen;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.659 -0400", hash_original_method = "1F7BA79C239DAD6228A2DB1150F5EF80", hash_generated_method = "1F7BA79C239DAD6228A2DB1150F5EF80")
    public CharSequences ()
    {
        //Synthesized constructor
    }
    
}

