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


package android.graphics;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.util.ArrayUtils;

public class TemporaryBuffer {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.263 -0500", hash_original_method = "479CBA9FC8EA655BBDC28F01631A11FA", hash_generated_method = "66B1007AD9440A141FCEE73F59A60847")
    
public static char[] obtain(int len) {
        char[] buf;

        synchronized (TemporaryBuffer.class) {
            buf = sTemp;
            sTemp = null;
        }

        if (buf == null || buf.length < len) {
            buf = new char[ArrayUtils.idealCharArraySize(len)];
        }

        return buf;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.265 -0500", hash_original_method = "071C606A3BD9E15E8A4F59CA77E0213C", hash_generated_method = "D7A996FB61E18FC691D8793A217A5412")
    
public static void recycle(char[] temp) {
        if (temp.length > 1000) return;

        synchronized (TemporaryBuffer.class) {
            sTemp = temp;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:05.267 -0500", hash_original_field = "55DA4B3993779389A3DF2C10AD0407DA", hash_generated_field = "D5B55575C53803B48B8DF0B1F8C65A25")

    private static char[] sTemp = null;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:11.182 -0400", hash_original_method = "4FF062759AAFC6722B3224BBA791BE93", hash_generated_method = "4FF062759AAFC6722B3224BBA791BE93")
    public TemporaryBuffer ()
    {
        //Synthesized constructor
    }
}

