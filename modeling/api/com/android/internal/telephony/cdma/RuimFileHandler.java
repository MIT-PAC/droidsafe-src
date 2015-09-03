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
 * Copyright (C) 2008 The Android Open Source Project
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


package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;

public final class RuimFileHandler extends IccFileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.370 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";

    //***** Instance Variables

    //***** Constructor
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.372 -0500", hash_original_method = "CF453B27C96776BB45DA5C39513E79B9", hash_generated_method = "CF453B27C96776BB45DA5C39513E79B9")
    
RuimFileHandler(CDMAPhone phone) {
        super(phone);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.374 -0500", hash_original_method = "090E1F04EFD80CF69ADD306ED1D79AE5", hash_generated_method = "5EA87569AF1433DF9A5120E4976B79C1")
    
public void dispose() {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.376 -0500", hash_original_method = "CF724477DA2C2A9786B4BE9A808F0A43", hash_generated_method = "C2A559F48B57DAFE35BF0FE1D49C9585")
    
protected void finalize() {
        Log.d(LOG_TAG, "RuimFileHandler finalized");
    }

    //***** Overridden from IccFileHandler

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.378 -0500", hash_original_method = "7CD46C2339603E91E870121ED1EC8F59", hash_generated_method = "471C018DEA8587F0FEE1710727BA1BB8")
    
@Override
    public void loadEFImgTransparent(int fileid, int highOffset, int lowOffset,
            int length, Message onLoaded) {
        Message response = obtainMessage(EVENT_READ_ICON_DONE, fileid, 0,
                onLoaded);

        phone.mCM.iccIO(COMMAND_GET_RESPONSE, fileid, "img", 0, 0,
                GET_RESPONSE_EF_IMG_SIZE_BYTES, null, null, response);
    }

    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.381 -0500", hash_original_method = "D06C959A971F705A496791A8170E55B9", hash_generated_method = "DCAA486667275FD4C905CA1844E72CB8")
    
@Override
    public void handleMessage(Message msg) {

        super.handleMessage(msg);
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.384 -0500", hash_original_method = "607B460DC742A6DBDB6C6AB4B03B96A2", hash_generated_method = "32779E0C05F7B98AC48AD904F7F2057A")
    
protected String getEFPath(int efid) {
        switch(efid) {
        case EF_SMS:
        case EF_CST:
        case EF_RUIM_SPN:
            return MF_SIM + DF_CDMA;
        }
        return getCommonIccEFPath(efid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.386 -0500", hash_original_method = "14F2EAD0BAAC0C4A3E4A3932F0B0B9F3", hash_generated_method = "FE66D7D950502CE29EC603099314CF0C")
    
protected void logd(String msg) {
        Log.d(LOG_TAG, "[RuimFileHandler] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.388 -0500", hash_original_method = "6458B63A49DDA09CACB99172BE6F4B0B", hash_generated_method = "70813DCEAD5A591EAE4F4E039ED365B3")
    
protected void loge(String msg) {
        Log.e(LOG_TAG, "[RuimFileHandler] " + msg);
    }
}

