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
 * Copyright (C) 2011 The Android Open Source Project
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


package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.IOException;

import libcore.io.ErrnoException;
import libcore.io.Libcore;

final class IoVec {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.807 -0500", hash_original_field = "EAA57126CB83C6F63722C70ACD182EC3", hash_generated_field = "8F7E59474A3A47E6FACE7437BBBF16C4")

    private  ByteBuffer[] byteBuffers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.809 -0500", hash_original_field = "B7E810BF01B52122CB927525A0CA4721", hash_generated_field = "EA4C80BAC452228E60AC0DA2D3E0C953")

    private  int offset;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.812 -0500", hash_original_field = "B9FB324AE4D12762A507A37B39A3AE19", hash_generated_field = "D602CF0E0740AAEDFC4DEF8987780EF2")

    private  int bufferCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.815 -0500", hash_original_field = "5ADD99E37B3A3DA9A715D46B0498EC13", hash_generated_field = "27EC5D44122911539EEF00080CA2291C")

    private  Object[] ioBuffers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.817 -0500", hash_original_field = "558F8D9D196E335F46E7F2341F45A030", hash_generated_field = "E194B71DC943C13E8607B77E79D5CB4E")

    private  int[] offsets;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.820 -0500", hash_original_field = "E4CDDCCB36846CD357BB1CAC9C653AA2", hash_generated_field = "8F6C8CDE5390F607AD0E24ACD9D6AB82")

    private  int[] byteCounts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.823 -0500", hash_original_field = "846FC68BE992F4639E3CFA86583CA8F9", hash_generated_field = "AD22A97F29292C6D1CAA320C6112ECB5")

    private  Direction direction;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.825 -0500", hash_original_method = "79FA89440D1C6736393E7E6CE16B2553", hash_generated_method = "79FA89440D1C6736393E7E6CE16B2553")
    
IoVec(ByteBuffer[] byteBuffers, int offset, int bufferCount, Direction direction) {
        this.byteBuffers = byteBuffers;
        this.offset = offset;
        this.bufferCount = bufferCount;
        this.direction = direction;
        this.ioBuffers = new Object[bufferCount];
        this.offsets = new int[bufferCount];
        this.byteCounts = new int[bufferCount];
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.828 -0500", hash_original_method = "0C69B202E78D62C368E6E03D03D6C92B", hash_generated_method = "0C69B202E78D62C368E6E03D03D6C92B")
    
int init() {
        int totalRemaining = 0;
        for (int i = 0; i < bufferCount; ++i) {
            ByteBuffer b = byteBuffers[i + offset];
            if (direction == Direction.READV) {
                b.checkWritable();
            }
            int remaining = b.remaining();
            if (b.isDirect()) {
                ioBuffers[i] = b;
                offsets[i] = b.position();
            } else {
                ioBuffers[i] = NioUtils.unsafeArray(b);
                offsets[i] = NioUtils.unsafeArrayOffset(b) + b.position();
            }
            byteCounts[i] = remaining;
            totalRemaining += remaining;
        }
        return totalRemaining;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.830 -0500", hash_original_method = "A7EE0836183CE06C4386DE620F235FAB", hash_generated_method = "A7EE0836183CE06C4386DE620F235FAB")
    
int doTransfer(FileDescriptor fd) throws IOException {
        try {
            if (direction == Direction.READV) {
                int result = Libcore.os.readv(fd, ioBuffers, offsets, byteCounts);
                if (result == 0) {
                    result = -1;
                }
                return result;
            } else {
                return Libcore.os.writev(fd, ioBuffers, offsets, byteCounts);
            }
        } catch (ErrnoException errnoException) {
            throw errnoException.rethrowAsIOException();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.833 -0500", hash_original_method = "EBAF870E907233DA47B6BC3AD10EE875", hash_generated_method = "EBAF870E907233DA47B6BC3AD10EE875")
    
void didTransfer(int byteCount) {
        for (int i = 0; byteCount > 0 && i < bufferCount; ++i) {
            ByteBuffer b = byteBuffers[i + offset];
            if (byteCounts[i] < byteCount) {
                b.position(b.limit());
                byteCount -= byteCounts[i];
            } else {
                b.position((direction == Direction.WRITEV ? b.position() : 0) + byteCount);
                byteCount = 0;
            }
        }
    }
    
    enum Direction { READV, WRITEV }
    
}

