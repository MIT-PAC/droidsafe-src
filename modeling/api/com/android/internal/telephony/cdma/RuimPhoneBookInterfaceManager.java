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
** Copyright 2007, The Android Open Source Project
**
** Licensed under the Apache License, Version 2.0 (the "License");
** you may not use this file except in compliance with the License.
** You may obtain a copy of the License at
**
**     http://www.apache.org/licenses/LICENSE-2.0
**
** Unless required by applicable law or agreed to in writing, software
** distributed under the License is distributed on an "AS IS" BASIS,
** WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
** See the License for the specific language governing permissions and
** limitations under the License.
*/


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccPhoneBookInterfaceManager;

public class RuimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.608 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.612 -0500", hash_original_method = "DEF9FAED33693F054DDAD69DBF684358", hash_generated_method = "AA8B9E750D8B078797466A40A6581106")
    
public RuimPhoneBookInterfaceManager(CDMAPhone phone) {
        super(phone);
        adnCache = phone.mIccRecords.getAdnCache();
        //NOTE service "simphonebook" added by IccSmsInterfaceManagerProxy
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.614 -0500", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "CEA4BD04B364A2D6A5DC0E0491C26D12")
    
public void dispose() {
        super.dispose();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.617 -0500", hash_original_method = "DBC78DBC20746AFDB653AFC4701001A9", hash_generated_method = "CEF47042C405985A04F1B2BF385F1D5A")
    
protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Log.e(LOG_TAG, "Error while finalizing:", throwable);
        }
        if(DBG) Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
    }

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.620 -0500", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "728E874A7499D07407E9660978E51BD0")
    
public int[] getAdnRecordsSize(int efid) {
        if (DBG) logd("getAdnRecordsSize: efid=" + efid);
        synchronized(mLock) {
            checkThread();
            recordSize = new int[3];

            //Using mBaseHandler, no difference in EVENT_GET_SIZE_DONE handling
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_GET_SIZE_DONE, status);

            phone.getIccFileHandler().getEFLinearRecordSize(efid, response);
            waitForResult(status);
        }

        return recordSize;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.622 -0500", hash_original_method = "3F9A676B96CAA569C8E5C7846B910ECF", hash_generated_method = "6A14C31B9A324EEE1BA935A9F52B6DE5")
    
protected void logd(String msg) {
        Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.625 -0500", hash_original_method = "87C4CA182A2FF633172C99DE636527CD", hash_generated_method = "16C13E9262C18AD4EFA68662B70AB2F8")
    
protected void loge(String msg) {
        Log.e(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }
}

