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


package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccPhoneBookInterfaceManager;

public class SimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.783 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.786 -0500", hash_original_method = "EB9FF0C7D9857B55B5A29EA1164E80F0", hash_generated_method = "F12D2D528F30F847B45D8155A494E733")
    
public SimPhoneBookInterfaceManager(GSMPhone phone) {
        super(phone);
        adnCache = phone.mIccRecords.getAdnCache();
        //NOTE service "simphonebook" added by IccSmsInterfaceManagerProxy
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.788 -0500", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "CEA4BD04B364A2D6A5DC0E0491C26D12")
    
public void dispose() {
        super.dispose();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.791 -0500", hash_original_method = "11E9A9A4D579433D0F36A7564F8CD864", hash_generated_method = "3372AA2EAB20936657DDEB3BD0B06EED")
    
protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Log.e(LOG_TAG, "Error while finalizing:", throwable);
        }
        if(DBG) Log.d(LOG_TAG, "SimPhoneBookInterfaceManager finalized");
    }

    @DSSource({DSSourceKind.CONTACT_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.794 -0500", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "728E874A7499D07407E9660978E51BD0")
    
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.796 -0500", hash_original_method = "7E6B689FB87F8B4FC5FFEDD55BD71E24", hash_generated_method = "14F4697753BAA77151B42580F672A2D2")
    
protected void logd(String msg) {
        Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:31.798 -0500", hash_original_method = "3C81ED33713B877CE55C1136EDE4985A", hash_generated_method = "DF68973FCB15249DE265DC338D512209")
    
protected void loge(String msg) {
        Log.e(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }
}

