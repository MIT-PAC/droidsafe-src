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


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class SmsResponse {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.288 -0500", hash_original_field = "E6F7BFC22487D00A28F9E36C2AA573F1", hash_generated_field = "E6F7BFC22487D00A28F9E36C2AA573F1")

    int messageRef;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.290 -0500", hash_original_field = "447B56C16ADE1A3EBD20B53504F3A1D8", hash_generated_field = "447B56C16ADE1A3EBD20B53504F3A1D8")

    String ackPdu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.293 -0500", hash_original_field = "882AAD94CF961762112192DCF3E37119", hash_generated_field = "882AAD94CF961762112192DCF3E37119")

    int errorCode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.296 -0500", hash_original_method = "3700DD8B61A34F0B0DF8E5BCBD18E935", hash_generated_method = "862F856DD52DE47D969EA6BC32E4AF97")
    
public SmsResponse(int messageRef, String ackPdu, int errorCode) {
        this.messageRef = messageRef;
        this.ackPdu = ackPdu;
        this.errorCode = errorCode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.298 -0500", hash_original_method = "713734C16C162CC185BDF9249475CA58", hash_generated_method = "B5147131D2C4BB90C91C47A69831E916")
    
public String toString() {
        String ret = "{ messageRef = " + messageRef
                        + ", errorCode = " + errorCode
                        + ", ackPdu = " + ackPdu
                        + "}";
        return ret;
    }
    
}

