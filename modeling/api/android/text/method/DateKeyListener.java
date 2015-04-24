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

public class DateKeyListener extends NumberKeyListener {

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.103 -0500", hash_original_method = "C1FF2F03ED98B7DB4C979A07E5F21A3F", hash_generated_method = "CDBA412E6107F33E828C513B6AD48AC7")
    
public static DateKeyListener getInstance() {
        if (sInstance != null)
            return sInstance;

        sInstance = new DateKeyListener();
        return sInstance;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.107 -0500", hash_original_field = "31F2EB7945CEC7ADC72CE576E4F4B964", hash_generated_field = "6417CC602ED83242D282A9E4E0224150")

    public static final char[] CHARACTERS = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '/', '-', '.'
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.109 -0500", hash_original_field = "9EE53EFCFCD697FEA63924BB5498F9F8", hash_generated_field = "6773A635B34EF84E192EA12F2E9E0C08")

    private static DateKeyListener sInstance;
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:39.176 -0400", hash_original_method = "09F9B6EA4C38704CC9648D105D359284", hash_generated_method = "09F9B6EA4C38704CC9648D105D359284")
    public DateKeyListener ()
    {
        //Synthesized constructor
    }
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.097 -0500", hash_original_method = "FAAA10DF871CFF7A2AF0FCDCA83E30F3", hash_generated_method = "8CDE16EC483428CF85E0F248BF00BBC7")
    
public int getInputType() {
        return InputType.TYPE_CLASS_DATETIME
                | InputType.TYPE_DATETIME_VARIATION_DATE;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:59.100 -0500", hash_original_method = "EEC77EA89700D9A449D9FC8461D61396", hash_generated_method = "C8829E311180669DC917FA428AC766DB")
    
@Override
    protected char[] getAcceptedChars()
    {
        return CHARACTERS;
    }
}

