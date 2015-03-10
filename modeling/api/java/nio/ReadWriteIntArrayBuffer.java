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

final class ReadWriteIntArrayBuffer extends IntArrayBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.600 -0500", hash_original_method = "A302ED31CDA696A45FD17F44C5B68C8C", hash_generated_method = "028ACFE128CC44F788CF7793A84C85F3")
    
static ReadWriteIntArrayBuffer copy(IntArrayBuffer other, int markOfOther) {
        ReadWriteIntArrayBuffer buf =
                new ReadWriteIntArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.603 -0500", hash_original_method = "8D9DDDEFB3AB21DD4A0254B750731D70", hash_generated_method = "8D9DDDEFB3AB21DD4A0254B750731D70")
    
ReadWriteIntArrayBuffer(int[] array) {
        super(array);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.605 -0500", hash_original_method = "43CEDB64CCBA692E544DE7CD0AC198FC", hash_generated_method = "43CEDB64CCBA692E544DE7CD0AC198FC")
    
ReadWriteIntArrayBuffer(int capacity) {
        super(capacity);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.608 -0500", hash_original_method = "A26E8A674EF0ED3D9F3331CA6DE93799", hash_generated_method = "A26E8A674EF0ED3D9F3331CA6DE93799")
    
ReadWriteIntArrayBuffer(int capacity, int[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.610 -0500", hash_original_method = "4B95192F4339BC062AF51933230B3F0C", hash_generated_method = "A54379D3D322FA5A2D3124C9C26283D8")
    
@Override
    public IntBuffer asReadOnlyBuffer() {
        return ReadOnlyIntArrayBuffer.copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.613 -0500", hash_original_method = "62E2BDB6C89716847449D50CC36598CA", hash_generated_method = "3CC8CB845AA2CA580117627C9E824578")
    
@Override
    public IntBuffer compact() {
        System.arraycopy(backingArray, position + offset, backingArray, offset, remaining());
        position = limit - position;
        limit = capacity;
        mark = UNSET_MARK;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.615 -0500", hash_original_method = "E687D66866CD72B4F21034D8F21E9369", hash_generated_method = "1E7DC474F320749966A19EE776FB4E91")
    
@Override
    public IntBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.618 -0500", hash_original_method = "19E9B6B291778F8D7BAF6F9BA6FE7EDF", hash_generated_method = "71081A201DF7B08144D6AE781E679981")
    
@Override
    public boolean isReadOnly() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.620 -0500", hash_original_method = "A905887CE8C7700C79178CD7C8EB8B1A", hash_generated_method = "156233B7D6AB7E9FAB024F69A9854D73")
    
@Override
    protected int[] protectedArray() {
        return backingArray;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.623 -0500", hash_original_method = "F848F07A68FC53238B1B56C46C388C04", hash_generated_method = "F5674176D88BEBAEFE4F538492719546")
    
@Override
    protected int protectedArrayOffset() {
        return offset;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.626 -0500", hash_original_method = "504D4244F3E9BA0CFC7CEE21DED3336C", hash_generated_method = "314D008C862B56E51390FC603128783F")
    
@Override
    protected boolean protectedHasArray() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.628 -0500", hash_original_method = "24A625E8D082FBF527A2D93F3C5BC8E0", hash_generated_method = "500026303EE94C1F7975AEC2DD8C5D9D")
    
@Override
    public IntBuffer put(int c) {
        if (position == limit) {
            throw new BufferOverflowException();
        }
        backingArray[offset + position++] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.630 -0500", hash_original_method = "2E47BE1B8B3BBE9EFD962F4A517C459A", hash_generated_method = "FC611EA8FAB58201EF4EDFFC0C84DDF4")
    
@Override
    public IntBuffer put(int index, int c) {
        checkIndex(index);
        backingArray[offset + index] = c;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.633 -0500", hash_original_method = "F72176B11CC709D09C4C37209C319F78", hash_generated_method = "5B72B45C03FEEB50D94824B37928224C")
    
@Override
    public IntBuffer put(int[] src, int srcOffset, int intCount) {
        if (intCount > remaining()) {
            throw new BufferOverflowException();
        }
        System.arraycopy(src, srcOffset, backingArray, offset + position, intCount);
        position += intCount;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:55.635 -0500", hash_original_method = "E64EEB28D2F233E17F9AAF235F4E0576", hash_generated_method = "D8270D490E02D9DEB1CA51D726EA5A9A")
    
@Override
    public IntBuffer slice() {
        return new ReadWriteIntArrayBuffer(remaining(), backingArray, offset + position);
    }
    
}

