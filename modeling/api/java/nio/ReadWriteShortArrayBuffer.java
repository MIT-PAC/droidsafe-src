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


package java.nio;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class ReadWriteShortArrayBuffer extends ShortArrayBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.670 -0500", hash_original_method = "E5828D785D2B7BE994EAC0A3E289DECD", hash_generated_method = "8717F6CBC1D05F222C10BD6B2E557139")
    
static ReadWriteShortArrayBuffer copy(ShortArrayBuffer other, int markOfOther) {
        ReadWriteShortArrayBuffer buf =
                new ReadWriteShortArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.672 -0500", hash_original_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41", hash_generated_method = "8E9D34BCCAE8E429C96FDCF9DF5CAB41")
    
ReadWriteShortArrayBuffer(short[] array) {
        super(array);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.675 -0500", hash_original_method = "D514769C5D5F8B6E9B68E0333601C0ED", hash_generated_method = "D514769C5D5F8B6E9B68E0333601C0ED")
    
ReadWriteShortArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.678 -0500", hash_original_method = "9C56AF79FD26FC5F344A35E3553FC338", hash_generated_method = "9C56AF79FD26FC5F344A35E3553FC338")
    
ReadWriteShortArrayBuffer(int capacity, short[] backingArray,
            int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.680 -0500", hash_original_method = "462C3B568A7739CEDBF963B6B469485C", hash_generated_method = "E63E7998EC43C337004D865B743FC012")
    
@Override
    public ShortBuffer asReadOnlyBuffer() {
        return ReadOnlyShortArrayBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.683 -0500", hash_original_method = "36F9748654A1F1F28EBEE4901281019B", hash_generated_method = "983BF1E49A8B6FD1AF97B08012DBB7F0")
    
@Override
    public ShortBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.685 -0500", hash_original_method = "F49238B32F318D341B9FD2839B701A87", hash_generated_method = "DA11699F4331CF771EFF0F49C605960A")
    
@Override
    public ShortBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.688 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.690 -0500", hash_original_method = "085A06B6EDE16089D63E0B4E0858AD77", hash_generated_method = "D94A3804CEB67BBBDCF04C061E2DE31B")
    
@Override
    protected short[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.693 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.695 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.698 -0500", hash_original_method = "54E323A30539354E0A95916606A58A4C", hash_generated_method = "BB299C983758A01108D1A25A21A93F2C")
    
@Override
    public ShortBuffer put(short c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.700 -0500", hash_original_method = "40ADB3B61FB69E1E8C75AAC651E43068", hash_generated_method = "9029E3D330A9CA69E44BFD32145F2C24")
    
@Override
    public ShortBuffer put(int index, short c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.703 -0500", hash_original_method = "2F2CA14AF95FC5682B6555E8CB32AB80", hash_generated_method = "7C4DB71BD07DC142F0EF8AD353FF8F6E")
    
@Override
    public ShortBuffer put(short[] src, int srcOffset, int shortCount) {
        if (shortCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, shortCount);
        position += shortCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.706 -0500", hash_original_method = "295BE67A092E5DAA08585681B1E9120C", hash_generated_method = "D877C45A0D0BC142C1EC350D8612AD3D")
    
@Override
    public ShortBuffer slice() {
        return new ReadWriteShortArrayBuffer(remaining(), backingArray, offset + position);
    }
    
}

