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


package com.android.internal.telephony.cat;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public enum ComprehensionTlvTag {
    COMMAND_DETAILS(0x01),
    DEVICE_IDENTITIES(0x02),
    RESULT(0x03),
    DURATION(0x04),
    ALPHA_ID(0x05),
    ADDRESS(0x06),
    USSD_STRING(0x0a),
    SMS_TPDU(0x0b),
    TEXT_STRING(0x0d),
    TONE(0x0e),
    ITEM(0x0f),
    ITEM_ID(0x10),
    RESPONSE_LENGTH(0x11),
    FILE_LIST(0x12),
    HELP_REQUEST(0x15),
    DEFAULT_TEXT(0x17),
    EVENT_LIST(0x19),
    ICON_ID(0x1e),
    ITEM_ICON_ID_LIST(0x1f),
    IMMEDIATE_RESPONSE(0x2b),
    LANGUAGE(0x2d),
    URL(0x31),
    BROWSER_TERMINATION_CAUSE(0x34),
    TEXT_ATTRIBUTE(0x50);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.074 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


    private int mValue;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.076 -0500", hash_original_method = "7F4CD850361B10325932E6280EE6B17E", hash_generated_method = "7F4CD850361B10325932E6280EE6B17E")
        
ComprehensionTlvTag(int value) {
        mValue = value;
    }

    /**
     * Returns the actual value of this COMPREHENSION-TLV object.
     *
     * @return Actual tag value of this object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.079 -0500", hash_original_method = "27017A4BB2548485661BB15426A7D88C", hash_generated_method = "830F464825E9198C7936F8382B630542")
        
public int value() {
        return mValue;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:07.081 -0500", hash_original_method = "33F65876064DF227E7D95E254A137FBB", hash_generated_method = "E83211FFEF3EACA388D0315B46E32149")
        
public static ComprehensionTlvTag fromInt(int value) {
        for (ComprehensionTlvTag e : ComprehensionTlvTag.values()) {
            if (e.mValue == value) {
                return e;
            }
        }
        return null;
    }
}
