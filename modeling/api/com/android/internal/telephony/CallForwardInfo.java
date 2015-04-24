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


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.telephony.PhoneNumberUtils;

public class CallForwardInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.989 -0500", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "E9243AA6ACDC688110619DDCF59ACF0B")

    public int             status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.992 -0500", hash_original_field = "FC9D5868840FFB9B2A75AB6FD79D21E6", hash_generated_field = "4CD87EFFD76230E744684521DDB4CA27")

    public int             reason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.995 -0500", hash_original_field = "4C722E26C15C5D3C38B4E4AD663FB2EB", hash_generated_field = "E084E4CD80C0302BF3BC150DFB947842")

    public int             serviceClass;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.997 -0500", hash_original_field = "D91CDD7EA396C29897A3485734F2FFD1", hash_generated_field = "BA17426A58710B9C5E5B752C001049B9")

    public int             toa;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:41.999 -0500", hash_original_field = "F0C1D0D479817313A0A5D4AB9BD9FA68", hash_generated_field = "35C5A82434F6EB5F96609BC97C13822F")

    public String          number;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.002 -0500", hash_original_field = "60867F4CC9C6D473FDAF112305BC0B98", hash_generated_field = "5D1F33269E9E5D70AC3DCFCD9620B054")

    public int             timeSeconds;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.485 -0400", hash_original_method = "1AD2DD7ADA01B6155671A6205A67842C", hash_generated_method = "1AD2DD7ADA01B6155671A6205A67842C")
    public CallForwardInfo ()
    {
        //Synthesized constructor
    } /* for CF no reply only */

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:42.005 -0500", hash_original_method = "EA7E7BF9BED1BC105930545F926483CA", hash_generated_method = "8A06A73622A06D35BA171B322B1FA264")
    
public String toString() {
        return super.toString() + (status == 0 ? " not active " : " active ")
            + " reason: " + reason
            + " serviceClass: " + serviceClass
            + " \"" + PhoneNumberUtils.stringFromStringAndTOA(number, toa) + "\" "
            + timeSeconds + " seconds";

    }
    
}

