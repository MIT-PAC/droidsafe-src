package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccFileHandler;




public final class CdmaLteUiccFileHandler extends IccFileHandler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.948 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.949 -0500", hash_original_method = "F91AC2EC8400C94DFA50E0DE5830B6E7", hash_generated_method = "F91AC2EC8400C94DFA50E0DE5830B6E7")
    CdmaLteUiccFileHandler(CDMALTEPhone phone) {
        super(phone);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.950 -0500", hash_original_method = "B50B51C72253EA7CE2666FA23DED632D", hash_generated_method = "1FC4F47CE01E976C373B2B882AA74F6E")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.951 -0500", hash_original_method = "6E38A6F3073A316D7DC84B086C57AB0E", hash_generated_method = "C43CF29767D2DB12E17161C68BFFFD1E")
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


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.952 -0500", hash_original_method = "9E18A7664E95C7EB6352A9A22332F4AA", hash_generated_method = "542C4AB9C524A140007220A2BC3B4FDF")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.953 -0500", hash_original_method = "420CE2D43D58036FFB967B46A860B403", hash_generated_method = "FA66BA5CC73A1957E3585E474A43DCEA")
    protected void loge(String msg) {
        Log.e(LOG_TAG, "[CdmaLteUiccFileHandler] " + msg);
    }
}

