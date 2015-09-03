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


package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import com.android.internal.telephony.IccCard;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneBase;

public final class SimCard extends IccCard {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.902 -0500", hash_original_method = "9F0A913CCE42D6EF6B4C91409D578CD8", hash_generated_method = "9F0A913CCE42D6EF6B4C91409D578CD8")
    
SimCard(GSMPhone phone) {
        super(phone, "GSM", true);

        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();
    }

    /**
    * We have the Sim card for LTE on CDMA phone
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.905 -0500", hash_original_method = "7954DCD4B4ED180767A5CCD973B61DEE", hash_generated_method = "647189C2CD6450042C1E09FC5061E0A6")
    
public SimCard(PhoneBase phone, String logTag, Boolean dbg) {
        super(phone, logTag, dbg);
        mPhone.mCM.registerForSIMLockedOrAbsent(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        mPhone.mCM.registerForOffOrNotAvailable(mHandler, EVENT_RADIO_OFF_OR_NOT_AVAILABLE, null);
        mPhone.mCM.registerForSIMReady(mHandler, EVENT_ICC_READY, null);
        updateStateProperty();

        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            mPhone.mCM.registerForIccStatusChanged(mHandler, EVENT_ICC_LOCKED_OR_ABSENT, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.909 -0500", hash_original_method = "C4D53CA88AF6F553E502BD318EED734B", hash_generated_method = "33F8948DD521027B438452D2D16395AF")
    
@Override
    public void dispose() {
        super.dispose();
        //Unregister for all events
        mPhone.mCM.unregisterForSIMLockedOrAbsent(mHandler);
        mPhone.mCM.unregisterForOffOrNotAvailable(mHandler);
        mPhone.mCM.unregisterForSIMReady(mHandler);

        if(mPhone.getLteOnCdmaMode() == Phone.LTE_ON_CDMA_TRUE) {
            mPhone.mCM.unregisterForIccStatusChanged(mHandler);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.912 -0500", hash_original_method = "9DB5C3DD2D46DFBEACD42980054AFF5F", hash_generated_method = "0EDAD9D4EAB75FE9706C00B6C5AE3662")
    
@Override
    public String getServiceProviderName () {
        return mPhone.mIccRecords.getServiceProviderName();
    }
    
}

