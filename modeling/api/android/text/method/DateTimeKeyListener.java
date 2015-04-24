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

public class DateTimeKeyListener extends NumberKeyListener {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.954 -0500", hash_original_method = "274B4DE16BC594B6FC9A8F011B07B7B9", hash_generated_method = "EB46540C8FA44FCAF90CACA2D50FEE90")
    
public static DateTimeKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new DateTimeKeyListener();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.957 -0500", hash_original_field = "AEE06D5C4B0CBCE22E86B827DE14AF21", hash_generated_field = "CC28C7351EEFBCCFD2A5481C9E11D592")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'm',
            'p', ':', '/', '-', ' '
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.960 -0500", hash_original_field = "0EDF1E1565F5BEBAA68AD63ED254B7CF", hash_generated_field = "A08939C26C7FAC41D21C88327D28A913")

    private static DateTimeKeyListener sInstance;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.188 -0400", hash_original_method = "A2664B73E6BC35FEDCFE12F8374A7DD3", hash_generated_method = "A2664B73E6BC35FEDCFE12F8374A7DD3")
    public DateTimeKeyListener ()
    {
        //Synthesized constructor
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.948 -0500", hash_original_method = "25727FE9AFE9AFBCFB0652DF45BFCF89", hash_generated_method = "0C9757E64671FB1F5E78A0BC602D4F57")
    
public int getInputType() {
        return InputType.TYPE_CLASS_DATETIME
                | InputType.TYPE_DATETIME_VARIATION_NORMAL;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:02.951 -0500", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "C8829E311180669DC917FA428AC766DB")
    
@Override
    protected char[] getAcceptedChars()
    {
        return CHARACTERS;
    }
}

