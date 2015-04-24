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


package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.lang.reflect.Array;

public class UnsafeArrayList<T> extends AbstractList<T> {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.681 -0400", hash_original_method = "D398440EEBE08F157EA10B9D3F4B575B", hash_generated_method = "F07679F0FB5C7D0607D217046F47FB25")
    public  UnsafeArrayList(Class<T> elementType, int initialCapacity) {
        super.requestCapacity(initialCapacity);
        // ---------- Original Method ----------
        //this.array = (T[]) Array.newInstance(elementType, initialCapacity);
        //this.elementType = elementType;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.684 -0400", hash_original_method = "E1B1B3AC94057B841216C896CA029484", hash_generated_method = "40D98EA0615F2F0B20C0561C28BE4E38")
    public T[] array() {
        return (T[])super.toArray();
        // ---------- Original Method ----------
        //return array;
    }
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:12.685 -0400", hash_original_method = "6AAD1AE5FDA036294C1A8E6B43833A30", hash_generated_method = "A9974704F73CEA49F0CF514F31EB009D")
    public T get(int i) {
        addTaint(i);
        return super.getElementAt(i);
        // ---------- Original Method ----------
        //return array[i];
    }
}

