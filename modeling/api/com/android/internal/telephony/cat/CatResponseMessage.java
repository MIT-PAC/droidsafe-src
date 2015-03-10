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
 * Copyright (C) 2007 The Android Open Source Project
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

public class CatResponseMessage {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.378 -0500", hash_original_field = "05112D41676684E3E20082CD80AE4A57", hash_generated_field = "05112D41676684E3E20082CD80AE4A57")

        CommandDetails cmdDet = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.381 -0500", hash_original_field = "D564E7393ADCB4AB0DDEC33D24527999", hash_generated_field = "D564E7393ADCB4AB0DDEC33D24527999")

        ResultCode resCode  = ResultCode.OK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.383 -0500", hash_original_field = "8A4681B05F71EED32A79F8A41E6E9871", hash_generated_field = "8A4681B05F71EED32A79F8A41E6E9871")

        int usersMenuSelection = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.385 -0500", hash_original_field = "EB0287EB6E8491AE9C6B217AC1842094", hash_generated_field = "EB0287EB6E8491AE9C6B217AC1842094")

        String usersInput  = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.387 -0500", hash_original_field = "8436B3F9AA1BBF7470B139D65F31B82A", hash_generated_field = "8436B3F9AA1BBF7470B139D65F31B82A")

        boolean usersYesNoSelection = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.389 -0500", hash_original_field = "1348577A3B7DF35DDA0A6478D3302694", hash_generated_field = "1348577A3B7DF35DDA0A6478D3302694")

        boolean usersConfirm = false;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.392 -0500", hash_original_method = "1B97059190C0D1E7E1481885E1591E21", hash_generated_method = "01269C2E8CBA8FE6DEB4A435810440A4")
    
public CatResponseMessage(CatCmdMessage cmdMsg) {
            this.cmdDet = cmdMsg.mCmdDet;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.396 -0500", hash_original_method = "F48E3F317137773EE74DBBA707FC1847", hash_generated_method = "1489698F6BAD565511B2FD84C6402CC2")
    
public void setResultCode(ResultCode resCode) {
            this.resCode = resCode;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.400 -0500", hash_original_method = "2E34FF1D06310BCA5A707F04A208D5E3", hash_generated_method = "DCFD053EE7ABCB1E6032BDB3A6A4972D")
    
public void setMenuSelection(int selection) {
            this.usersMenuSelection = selection;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.404 -0500", hash_original_method = "D6F0022EFC9B658375DA0AA4AF0678E5", hash_generated_method = "AF2254D52079D5615439D2CEF834D76E")
    
public void setInput(String input) {
            this.usersInput = input;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.408 -0500", hash_original_method = "6FEC3BD938C12B7F4A8404538ED69073", hash_generated_method = "94175914C9C48CDB10AFA5CE5D0A6B87")
    
public void setYesNo(boolean yesNo) {
            usersYesNoSelection = yesNo;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.411 -0500", hash_original_method = "EFA8BA2D7BACB7DB3D12098D0C022296", hash_generated_method = "9C33E6FFEB5933FEDAD8EBD3C2D1CC21")
    
public void setConfirmation(boolean confirm) {
            usersConfirm = confirm;
        }

        @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:05.414 -0500", hash_original_method = "09210AE6CE37D89E5644571273FE7BA3", hash_generated_method = "09210AE6CE37D89E5644571273FE7BA3")
    
CommandDetails getCmdDetails() {
            return cmdDet;
        }
    
}

