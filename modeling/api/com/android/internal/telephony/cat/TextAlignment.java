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
 * Copyright (C) 2006 The Android Open Source Project
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


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum TextAlignment {
    LEFT(0x0),
    CENTER(0x1),
    RIGHT(0x2),
    DEFAULT(0x3);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.232 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.234 -0500", hash_original_method = "65BEFDD6F9FD01556EC027F435F4D3BB", hash_generated_method = "65BEFDD6F9FD01556EC027F435F4D3BB")
        
TextAlignment(int value) {
        mValue = value;
    }

    /**
     * Create a TextAlignment object.
     * @param value Integer value to be converted to a TextAlignment object.
     * @return TextAlignment object whose value is {@code value}. If no
     *         TextAlignment object has that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:04.237 -0500", hash_original_method = "EE4E674CDA4C57E84BB652D16F8BF8CF", hash_generated_method = "4FE90C874477F41538FA88B9E4CB5C27")
        
public static TextAlignment fromInt(int value) {
        for (TextAlignment e : TextAlignment.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
