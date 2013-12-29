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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.971 -0500", hash_original_field = "DB10E3AE28CC9996A816C3CCD7216A83", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.972 -0500", hash_original_method = "DEF9FAED33693F054DDAD69DBF684358", hash_generated_method = "AA8B9E750D8B078797466A40A6581106")
    public RuimPhoneBookInterfaceManager(CDMAPhone phone) {
        super(phone);
        adnCache = phone.mIccRecords.getAdnCache();
        //NOTE service "simphonebook" added by IccSmsInterfaceManagerProxy
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.973 -0500", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "CEA4BD04B364A2D6A5DC0E0491C26D12")
    public void dispose() {
        super.dispose();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.974 -0500", hash_original_method = "DBC78DBC20746AFDB653AFC4701001A9", hash_generated_method = "CEF47042C405985A04F1B2BF385F1D5A")
    protected void finalize() {
        try {
            super.finalize();
        } catch (Throwable throwable) {
            Log.e(LOG_TAG, "Error while finalizing:", throwable);
        }
        if(DBG) Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.975 -0500", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "728E874A7499D07407E9660978E51BD0")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.976 -0500", hash_original_method = "3F9A676B96CAA569C8E5C7846B910ECF", hash_generated_method = "6A14C31B9A324EEE1BA935A9F52B6DE5")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:20.977 -0500", hash_original_method = "87C4CA182A2FF633172C99DE636527CD", hash_generated_method = "16C13E9262C18AD4EFA68662B70AB2F8")
    protected void loge(String msg) {
        Log.e(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }
}

