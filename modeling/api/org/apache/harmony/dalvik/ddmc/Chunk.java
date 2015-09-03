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


package org.apache.harmony.dalvik.ddmc;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.ByteBuffer;

public class Chunk {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.181 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.183 -0500", hash_original_field = "B330DF564CD90A5498A9E4F0AB344BB9", hash_generated_field = "F02DD38BDDF66ED8369494A65A3A6765")

    public byte[] data;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "29401E0923088C769B2CF76AB91921CE")

    public int offset;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:26.849 -0400", hash_original_field = "2FA47F7C65FEC19CC163B195725E3844", hash_generated_field = "1125768121756783FBBAD7831AFCFE31")

    public int length;      // position within "data"

    /**
     * Blank constructor.  Fill in your own fields.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.188 -0500", hash_original_method = "6A535F879971D0788BB13E4964856994", hash_generated_method = "C7E2E20F4D9C5CE6F4D248CA29ADE431")
    
public Chunk() {}

    /**
     * Constructor with all fields.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.192 -0500", hash_original_method = "C04A7188909E46725BABBA45D3411BA7", hash_generated_method = "10A66FA8B7385AE3D2B9AB29CACBDE31")
    
public Chunk(int type, byte[] data, int offset, int length) {
        this.type = type;
        this.data = data;
        this.offset = offset;
        this.length = length;
    }

    /**
     * Construct from a ByteBuffer.  The chunk is assumed to start at
     * offset 0 and continue to the current position.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:25.194 -0500", hash_original_method = "E3AC8BD9C0992AF624180216E36F1FC7", hash_generated_method = "DDD1B73EF63996EC35AEB8E335F6DB91")
    
public Chunk(int type, ByteBuffer buf) {
        this.type = type;

        this.data = buf.array();
        this.offset = buf.arrayOffset();
        this.length = buf.position();
    }
    
}

