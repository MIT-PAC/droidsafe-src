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


package android.text.method;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.text.InputType;

public class TimeKeyListener extends NumberKeyListener {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.708 -0500", hash_original_method = "E3D1D19A4F0AD3BF112656171BB40F7B", hash_generated_method = "775E9E8EEAE8BFB1441E2E40A07E5EA3")
    
public static TimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new TimeKeyListener();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.712 -0500", hash_original_field = "BADCC950784F9D920D0CCAF58EF2DFE9", hash_generated_field = "03D6010F82701EA810C482FC784D2E6D")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':'
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.716 -0500", hash_original_field = "8DF1A60B58A81137500B1CD8DA13D29C", hash_generated_field = "33355AAAF3221ACB9E3222BB6726B57D")

    private static TimeKeyListener sInstance;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.781 -0400", hash_original_method = "B9206F846F22DC573861D1007C9C3102", hash_generated_method = "B9206F846F22DC573861D1007C9C3102")
    public TimeKeyListener ()
    {
        //Synthesized constructor
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.701 -0500", hash_original_method = "F4BD69BECB4A0F93AC68BF98F9909696", hash_generated_method = "A25476C7DC4D7F01A57A4FA58B212E1E")
    
public int getInputType() {
        return InputType.TYPE_CLASS_DATETIME
        | InputType.TYPE_DATETIME_VARIATION_TIME;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.704 -0500", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "C8829E311180669DC917FA428AC766DB")
    
@Override
    protected char[] getAcceptedChars()
    {
        return CHARACTERS;
    }
}

