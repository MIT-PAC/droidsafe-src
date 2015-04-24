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

final class ReadOnlyCharArrayBuffer extends CharArrayBuffer {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.862 -0500", hash_original_method = "D5F09B11FADBD37E61FEF2873B0DCA07", hash_generated_method = "AB6BF9FA1FA7A4A229528C86A8EFF384")
    
static ReadOnlyCharArrayBuffer copy(CharArrayBuffer other, int markOfOther) {
        ReadOnlyCharArrayBuffer buf =
                new ReadOnlyCharArrayBuffer(other.capacity(), other.backingArray, other.offset);
        buf.limit = other.limit;
        buf.position = other.position();
        buf.mark = markOfOther;
        return buf;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.865 -0500", hash_original_method = "45CC985A35F0F1494520573D6ACE292A", hash_generated_method = "45CC985A35F0F1494520573D6ACE292A")
    
ReadOnlyCharArrayBuffer(int capacity, char[] backingArray, int arrayOffset) {
        super(capacity, backingArray, arrayOffset);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.868 -0500", hash_original_method = "6272265C933D4E168CAF2033C47ED968", hash_generated_method = "A9D0BE229F30B3716C8CDFCA80787DB7")
    
@Override
    public CharBuffer asReadOnlyBuffer() {
        return duplicate();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.870 -0500", hash_original_method = "B36182A594E1794791B93E3BECF5B149", hash_generated_method = "2593C5B1B74EAD2E7E6B37DB5FD97A42")
    
@Override
    public CharBuffer compact() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.873 -0500", hash_original_method = "CC31CA0A52E7075216F6C304954E7B50", hash_generated_method = "1D23E659FD61AA77B2D3D7F85F6A84C8")
    
@Override
    public CharBuffer duplicate() {
        return copy(this, mark);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.875 -0500", hash_original_method = "D0F583BEFACE4F70BE4011CED42FF4E6", hash_generated_method = "E930BFBB15BF0F3A3E2A714B41BC0488")
    
@Override
    public boolean isReadOnly() {
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.878 -0500", hash_original_method = "0F9E5668E984B4901FBF78711C9DAE7C", hash_generated_method = "1B195A72923E539DE93EB88ED89545CF")
    
@Override
    protected char[] protectedArray() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.881 -0500", hash_original_method = "0ABFB09F32C9F0D211E0D26315A037E6", hash_generated_method = "74EBBCBD37A62C7AD6A8876E571480EF")
    
@Override
    protected int protectedArrayOffset() {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.883 -0500", hash_original_method = "22273AD75DCD1D369E6F6089E4C15AAA", hash_generated_method = "4DE1ADBFC1C0BCD2FC8429D8307DD9AC")
    
@Override
    protected boolean protectedHasArray() {
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.885 -0500", hash_original_method = "AA890865E828C97A020097D7CDA5EE73", hash_generated_method = "CA0F24469F2A1A92B0C086F3C3BFE249")
    
@Override
    public CharBuffer put(char c) {
        throw new ReadOnlyBufferException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.888 -0500", hash_original_method = "4BB5828CEE96E76B6DAC9C0855ABDDFD", hash_generated_method = "8EF03B178409CB5ACD391B77A43BDF8E")
    
@Override
    public CharBuffer put(int index, char c) {
        throw new ReadOnlyBufferException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.890 -0500", hash_original_method = "456A915B3249AF3B6DBAB08ACEE5755D", hash_generated_method = "923BD9694955DF4557C0EFE16A5FA1CD")
    
@Override
    public final CharBuffer put(char[] src, int srcOffset, int charCount) {
        throw new ReadOnlyBufferException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.893 -0500", hash_original_method = "FB6FEA0A32E7A03D5D90CE6B495DAC9B", hash_generated_method = "8E86F9E86E94497BBE85F731D8200DA6")
    
@Override
    public final CharBuffer put(CharBuffer src) {
        throw new ReadOnlyBufferException();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.896 -0500", hash_original_method = "4A99CE8F005D81D8D8D69EFF935B4E86", hash_generated_method = "8B3A388C3F691526F5A4A008E9F71CD1")
    
@Override
    public CharBuffer put(String src, int start, int end) {
        throw new ReadOnlyBufferException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:52.899 -0500", hash_original_method = "B45CBDD156981DE98E6537855A7A214E", hash_generated_method = "BBBE9CE5388A8DE48AA83FBF50BEFCD0")
    
@Override
    public CharBuffer slice() {
        return new ReadOnlyCharArrayBuffer(remaining(), backingArray, offset + position);
    }
    
}

