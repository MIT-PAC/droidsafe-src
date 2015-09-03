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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteOrder;

import droidsafe.helpers.DSUtils;

public final class Memory {
    
    public static void unsafeBulkGet(Object dst, int dstOffset, int byteCount,
            byte[] src, int srcOffset, int sizeofElements, boolean swap) {
    }
    
    public static void unsafeBulkPut(byte[] dst, int dstOffset, int byteCount,
            Object src, int srcOffset, int sizeofElements, boolean swap) {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.971 -0500", hash_original_method = "8D305254CD39829F31410B39DF7BBEBE", hash_generated_method = "C0A96DEE00CA2BE8EF1300EFA2162F67")
    
public static int peekInt(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset  ] & 0xff) <<  0));
        } else {
            return (((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset  ] & 0xff) << 24));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.974 -0500", hash_original_method = "B98F7C4B79C3BE5084DDBB18889854BB", hash_generated_method = "24280502FAE5E6F244E66533738743BD")
    
public static long peekLong(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            int h = ((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) <<  0);
            int l = ((src[offset++] & 0xff) << 24) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset  ] & 0xff) <<  0);
            return (((long) h) << 32L) | ((long) l) & 0xffffffffL;
        } else {
            int l = ((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset++] & 0xff) << 24);
            int h = ((src[offset++] & 0xff) <<  0) |
                    ((src[offset++] & 0xff) <<  8) |
                    ((src[offset++] & 0xff) << 16) |
                    ((src[offset  ] & 0xff) << 24);
            return (((long) h) << 32L) | ((long) l) & 0xffffffffL;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.976 -0500", hash_original_method = "AA975D78647A63D19011E50852F27F77", hash_generated_method = "A2FE1438CB8FEBAE16E8C1B640DD0C94")
    
public static short peekShort(byte[] src, int offset, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            return (short) ((src[offset] << 8) | (src[offset + 1] & 0xff));
        } else {
            return (short) ((src[offset + 1] << 8) | (src[offset] & 0xff));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.979 -0500", hash_original_method = "44BE7D40F5A344CCFA84ECB14F292BE4", hash_generated_method = "A8DDB705EB46AF8364B74A8E9874F939")
    
public static void pokeInt(byte[] dst, int offset, int value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 24) & 0xff);
            dst[offset++] = (byte) ((value >> 16) & 0xff);
            dst[offset++] = (byte) ((value >>  8) & 0xff);
            dst[offset  ] = (byte) ((value >>  0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >>  0) & 0xff);
            dst[offset++] = (byte) ((value >>  8) & 0xff);
            dst[offset++] = (byte) ((value >> 16) & 0xff);
            dst[offset  ] = (byte) ((value >> 24) & 0xff);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.983 -0500", hash_original_method = "D98917DE7F47EEA6D6D33C72096FA56C", hash_generated_method = "CAE5456AB250883137844560F51B60A7")
    
public static void pokeLong(byte[] dst, int offset, long value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            int i = (int) (value >> 32);
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            i = (int) value;
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset  ] = (byte) ((i >>  0) & 0xff);
        } else {
            int i = (int) value;
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset++] = (byte) ((i >> 24) & 0xff);
            i = (int) (value >> 32);
            dst[offset++] = (byte) ((i >>  0) & 0xff);
            dst[offset++] = (byte) ((i >>  8) & 0xff);
            dst[offset++] = (byte) ((i >> 16) & 0xff);
            dst[offset  ] = (byte) ((i >> 24) & 0xff);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.986 -0500", hash_original_method = "126E144BF1B52FAB4A446BDFDDF25035", hash_generated_method = "ECB2141A3DBF6EE4061FC9D3169A2629")
    
public static void pokeShort(byte[] dst, int offset, short value, ByteOrder order) {
        if (order == ByteOrder.BIG_ENDIAN) {
            dst[offset++] = (byte) ((value >> 8) & 0xff);
            dst[offset  ] = (byte) ((value >> 0) & 0xff);
        } else {
            dst[offset++] = (byte) ((value >> 0) & 0xff);
            dst[offset  ] = (byte) ((value >> 8) & 0xff);
        }
    }
    
    public static void memmove(Object dstObject, int dstOffset, Object srcObject, int srcOffset, long byteCount) {
    }
    
    public static byte peekByte(int address) {
        return (byte)address;
    }
    
    public static int peekInt(int address, boolean swap) {
        int temp = 0;
        if (swap)
            temp = 1;
        return address + temp;
    }
    
    public static long peekLong(int address, boolean swap) {
        int temp = 0;
        if (swap)
            temp = 1;
        return address + temp;
    }
    
    public static short peekShort(int address, boolean swap) {
        int temp = 0;
        if (swap)
            temp = 1;
        return (short) (address + temp);
    }
    
    public static void peekByteArray(int address, byte[] dst, int dstOffset, int byteCount) {
    }
    
    public static void peekCharArray(int address, char[] dst, int dstOffset, int charCount, boolean swap) {
    }
    
    public static void peekDoubleArray(int address, double[] dst, int dstOffset, int doubleCount, boolean swap) {
    }
    
    public static void peekFloatArray(int address, float[] dst, int dstOffset, int floatCount, boolean swap) {
    }
    
    public static void peekIntArray(int address, int[] dst, int dstOffset, int intCount, boolean swap) {
    }
    
    public static void peekLongArray(int address, long[] dst, int dstOffset, int longCount, boolean swap) {
    }
    
    public static void peekShortArray(int address, short[] dst, int dstOffset, int shortCount, boolean swap) {
    }
    
    public static void pokeByte(int address, byte value) {
    }
    
    public static void pokeInt(int address, int value, boolean swap) {
    }
    
    public static void pokeLong(int address, long value, boolean swap) {
    }
    
    public static void pokeShort(int address, short value, boolean swap) {
    }
    
    public static void pokeByteArray(int address, byte[] src, int offset, int count) {
    }
    
    public static void pokeCharArray(int address, char[] src, int offset, int count, boolean swap) {
    }
    
    public static void pokeDoubleArray(int address, double[] src, int offset, int count, boolean swap) {
    }
    
    public static void pokeFloatArray(int address, float[] src, int offset, int count, boolean swap) {
    }
    
    public static void pokeIntArray(int address, int[] src, int offset, int count, boolean swap) {
    }
    
    public static void pokeLongArray(int address, long[] src, int offset, int count, boolean swap) {
    }
    
    public static void pokeShortArray(int address, short[] src, int offset, int count, boolean swap) {
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.960 -0500", hash_original_method = "8E748606B262B165332F0089DEAB291F", hash_generated_method = "B7B6F537B3C912F02D456567DA9C0DA2")
    
private Memory() { }
    
}

