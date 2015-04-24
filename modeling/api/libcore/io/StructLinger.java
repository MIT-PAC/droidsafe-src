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


package libcore.io;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class StructLinger {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.868 -0500", hash_original_field = "A78CA655CA35C68307B38A883F062E58", hash_generated_field = "313A34DC743869D82F472BEDE730F98E")

    public  int l_onoff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.870 -0500", hash_original_field = "32E13CC419A45BB78FB27A6ABA473BC5", hash_generated_field = "D8BC60732FDD96B0D1DB46A72316816A")

    public  int l_linger;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.873 -0500", hash_original_method = "B2DBC5125F252FD79E2837DA3A5E5C7A", hash_generated_method = "04B36ACA1EA2B9A5BBE6449E5E6068E4")
    
public StructLinger(int l_onoff, int l_linger) {
        this.l_onoff = l_onoff;
        this.l_linger = l_linger;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.875 -0500", hash_original_method = "9E5D902293FF11591147857F4F3E0D72", hash_generated_method = "9AE321B3914056648980F923BF953A6E")
    
public boolean isOn() {
        return l_onoff != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:21.877 -0500", hash_original_method = "F93BE5BFF4FFDE74302B318FFC6DC0AC", hash_generated_method = "CED7527B424594A81A8918DC71B96A89")
    
@Override public String toString() {
        return "StructLinger[l_onoff=" + l_onoff + ",l_linger=" + l_linger + "]";
    }
    
}

