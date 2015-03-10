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

public interface AppInterface {

    
    public static final String CAT_CMD_ACTION =
                                    "android.intent.action.stk.command";
    public static final String CAT_SESSION_END_ACTION =
                                    "android.intent.action.stk.session_end";

    
    void onCmdResponse(CatResponseMessage resMsg);

    
    public static enum CommandType {
        DISPLAY_TEXT(0x21),
        GET_INKEY(0x22),
        GET_INPUT(0x23),
        LAUNCH_BROWSER(0x15),
        PLAY_TONE(0x20),
        REFRESH(0x01),
        SELECT_ITEM(0x24),
        SEND_SS(0x11),
        SEND_USSD(0x12),
        SEND_SMS(0x13),
        SEND_DTMF(0x14),
        SET_UP_EVENT_LIST(0x05),
        SET_UP_IDLE_MODE_TEXT(0x28),
        SET_UP_MENU(0x25),
        SET_UP_CALL(0x10),
        PROVIDE_LOCAL_INFORMATION(0x26);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.657 -0500", hash_original_field = "177FAFFA7A38FCF6D55DEE4AFF0E6CEC", hash_generated_field = "1FE26AAF0F7068BF50C3FDD7D6BD850D")


        private int mValue;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.659 -0500", hash_original_method = "6F7266DBE7D20F5D2808BEB812EAA6BB", hash_generated_method = "6F7266DBE7D20F5D2808BEB812EAA6BB")
            
CommandType(int value) {
            mValue = value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.661 -0500", hash_original_method = "27017A4BB2548485661BB15426A7D88C", hash_generated_method = "830F464825E9198C7936F8382B630542")
            
public int value() {
            return mValue;
        }

        /**
         * Create a CommandType object.
         *
         * @param value Integer value to be converted to a CommandType object.
         * @return CommandType object whose "Type of Command" value is {@code
         *         value}. If no CommandType object has that value, null is
         *         returned.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:06.664 -0500", hash_original_method = "1F19DA1C6CBA846FE2FCDE89F2B2BD0C", hash_generated_method = "C65E8D2A280FF7728EC3A8053627318B")
            
public static CommandType fromInt(int value) {
            for (CommandType e : CommandType.values()) {
                if (e.mValue == value) {
                    return e;
                }
            }
            return null;
        }
    }
}
