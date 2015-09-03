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



public enum TextColor {
    BLACK(0x0),
    DARK_GRAY(0x1),
    DARK_RED(0x2),
    DARK_YELLOW(0x3),
    DARK_GREEN(0x4),
    DARK_CYAN(0x5),
    DARK_BLUE(0x6),
    DARK_MAGENTA(0x7),
    GRAY(0x8),
    WHITE(0x9),
    BRIGHT_RED(0xa),
    BRIGHT_YELLOW(0xb),
    BRIGHT_GREEN(0xc),
    BRIGHT_CYAN(0xd),
    BRIGHT_BLUE(0xe),
    BRIGHT_MAGENTA(0xf);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.049 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.052 -0500", hash_original_method = "3D590D1ADED3F8E9D97FE66804FB8342", hash_generated_method = "3D590D1ADED3F8E9D97FE66804FB8342")
        
TextColor(int value) {
        mValue = value;
    }

    /**
     * Create a TextColor object.
     * @param value Integer value to be converted to a TextColor object.
     * @return TextColor object whose value is {@code value}. If no TextColor
     *         object has that value, null is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.054 -0500", hash_original_method = "C1C64C598309A1C0897A2D46B8920DB6", hash_generated_method = "18FC67C18A5DADD280B9B0E8387DDB73")
        
public static TextColor fromInt(int value) {
        for (TextColor e : TextColor.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
