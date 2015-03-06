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


package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;

public final class CdmaLteUiccFileHandler extends IccFileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.531 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.535 -0500", hash_original_method = "F91AC2EC8400C94DFA50E0DE5830B6E7", hash_generated_method = "F91AC2EC8400C94DFA50E0DE5830B6E7")
    
CdmaLteUiccFileHandler(CDMALTEPhone phone) {
        super(phone);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.539 -0500", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "1FC4F47CE01E976C373B2B882AA74F6E")
    
protected String getEFPath(int efid) {
        switch(efid) {
        case EF_CSIM_SPN:
        case EF_CSIM_LI:
        case EF_CSIM_MDN:
        case EF_CSIM_IMSIM:
        case EF_CSIM_CDMAHOME:
        case EF_CSIM_EPRL:
            return MF_SIM + DF_CDMA;
        case EF_AD:
            return MF_SIM + DF_GSM;
        case EF_IMPI:
        case EF_DOMAIN:
        case EF_IMPU:
            return MF_SIM + DF_ADFISIM;
        }
        return getCommonIccEFPath(efid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.543 -0500", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "C43CF29767D2DB12E17161C68BFFFD1E")
    
@Override
    public void loadEFTransparent(int fileid, Message onLoaded) {
        if (fileid == EF_CSIM_EPRL) {
            // Entire PRL could be huge. We are only interested in
            // the first 4 bytes of the record.
            phone.mCM.iccIO(COMMAND_READ_BINARY, fileid, getEFPath(fileid),
                            0, 0, 4, null, null,
                            obtainMessage(EVENT_READ_BINARY_DONE,
                                          fileid, 0, onLoaded));
        } else {
            super.loadEFTransparent(fileid, onLoaded);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.547 -0500", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "542C4AB9C524A140007220A2BC3B4FDF")
    
protected void logd(String msg) {
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:54.551 -0500", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "FA66BA5CC73A1957E3585E474A43DCEA")
    
protected void loge(String msg) {
        Log.e(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }
}

