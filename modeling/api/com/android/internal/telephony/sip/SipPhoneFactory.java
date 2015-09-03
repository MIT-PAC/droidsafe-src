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
 * Copyright (C) 2010 The Android Open Source Project
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


package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import android.content.Context;
import android.net.sip.SipProfile;
import android.util.Log;

import com.android.internal.telephony.PhoneNotifier;

public class SipPhoneFactory {
    /**
     * Makes a {@link SipPhone} object.
     * @param sipUri the local SIP URI the phone runs on
     * @param context {@code Context} needed to create a Phone object
     * @param phoneNotifier {@code PhoneNotifier} needed to create a Phone
     *      object
     * @return the {@code SipPhone} object or null if the SIP URI is not valid
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.134 -0500", hash_original_method = "58A7161193CB0CF71FFF602E5D298512", hash_generated_method = "BC4BFACAF7BDFD62A8A1527DF38E7421")
    
public static SipPhone makePhone(String sipUri, Context context,
            PhoneNotifier phoneNotifier) {
        try {
            SipProfile profile = new SipProfile.Builder(sipUri).build();
            return new SipPhone(context, phoneNotifier, profile);
        } catch (ParseException e) {
            Log.w("SipPhoneFactory", "makePhone", e);
            return null;
        }
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:26.399 -0400", hash_original_method = "15E2472645F6BD56CA55CE00B2D7EBA0", hash_generated_method = "15E2472645F6BD56CA55CE00B2D7EBA0")
    public SipPhoneFactory ()
    {
        //Synthesized constructor
    }
    
}

