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

final class ReadOnlyFloatArrayBuffer extends FloatArrayBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.467 -0500", hash_original_method = "0003FBB86F60A89AB3C5D98E0358B9E6", hash_generated_method = "01F22EC904D1E78F8F883B74D517D5C4")
    
static ReadOnlyFloatArrayBuffer copy(FloatArrayBuffer other, int markOfOther) {
        ReadOnlyFloatArrayBuffer buf =
                new ReadOnlyFloatArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.469 -0500", hash_original_method = "E7687DEEE2349AEC9B3D116E5F0447AE", hash_generated_method = "E7687DEEE2349AEC9B3D116E5F0447AE")
    
ReadOnlyFloatArrayBuffer(int capacity, float[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.472 -0500", hash_original_method = "950AD5330FDA6C397B84663FB836B7AC", hash_generated_method = "CCA7D19D710AA79B66143C5F1EFAAEC3")
    
@Override
    public FloatBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.474 -0500", hash_original_method = "3651F4075426ACE9E47115ABCBF7340C", hash_generated_method = "6B2D3E92AEEDD2A2610F36BEB3FE5367")
    
@Override
    public FloatBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.477 -0500", hash_original_method = "3E38DEB88805A3AD5A9BAFA46381EB46", hash_generated_method = "0110369AFCDD0624F359E2091231917C")
    
@Override
    public FloatBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.479 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.482 -0500", hash_original_method = "C411BFEF69C342422C56A1A8A49A766C", hash_generated_method = "E64AA614318CCDF0C2F5A2578AB226BF")
    
@Override
    protected float[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.484 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    
@Override
    protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.487 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.489 -0500", hash_original_method = "4648A9FB9F6674DFF187FD22874B4264", hash_generated_method = "9A80C6F6D64CFC8B44E020AC06A37DF6")
    
@Override
    public FloatBuffer put(float c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.492 -0500", hash_original_method = "2F3AA3FAE455D6D3597D42F3669BC144", hash_generated_method = "BCB0EA00F19B0D4F8DD3777D1A0B3D7A")
    
@Override
    public FloatBuffer put(int index, float c) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.494 -0500", hash_original_method = "4593D163A029E48A7BF09387C27B8D4B", hash_generated_method = "A46913F47CF58B761C2037E2811054F9")
    
@Override
    public FloatBuffer put(FloatBuffer buf) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.497 -0500", hash_original_method = "B855D58A55D1A37F7BFB3C60ACA0157A", hash_generated_method = "6057C5FAD7BBB263D543E27273D8FBD0")
    
@Override
    public final FloatBuffer put(float[] src, int srcOffset, int byteCount) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:56.500 -0500", hash_original_method = "CBF8325EDBAF150278EE67A0E06067DF", hash_generated_method = "8E955DEC3AF6BF910AB2DC88B6F33B22")
    
@Override
    public FloatBuffer slice() {
        return new ReadOnlyFloatArrayBuffer(remaining(), backingArray, offset + position);
    }
    
}

