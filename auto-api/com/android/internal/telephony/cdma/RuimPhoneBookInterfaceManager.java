package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import android.os.Message;
import android.util.Log;
import com.android.internal.telephony.IccPhoneBookInterfaceManager;

public class RuimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.809 -0400", hash_original_method = "DEF9FAED33693F054DDAD69DBF684358", hash_generated_method = "4975C3169B954C6F973CA2773CC3701F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RuimPhoneBookInterfaceManager(CDMAPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        adnCache = phone.mIccRecords.getAdnCache();
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.809 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.809 -0400", hash_original_method = "DBC78DBC20746AFDB653AFC4701001A9", hash_generated_method = "5C9621C5FED2DAE78D5F6048454FBEAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.810 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "578C0C76F5BDF0799D86E551B1C3D0B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int[] getAdnRecordsSize(int efid) {
        dsTaint.addTaint(efid);
        logd("getAdnRecordsSize: efid=" + efid);
        {
            checkThread();
            recordSize = new int[3];
            AtomicBoolean status;
            status = new AtomicBoolean(false);
            Message response;
            response = mBaseHandler.obtainMessage(EVENT_GET_SIZE_DONE, status);
            phone.getIccFileHandler().getEFLinearRecordSize(efid, response);
            waitForResult(status);
        } //End block
        int[] retVal = new int[1];
        retVal[0] = dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (DBG) logd("getAdnRecordsSize: efid=" + efid);
        //synchronized(mLock) {
            //checkThread();
            //recordSize = new int[3];
            //AtomicBoolean status = new AtomicBoolean(false);
            //Message response = mBaseHandler.obtainMessage(EVENT_GET_SIZE_DONE, status);
            //phone.getIccFileHandler().getEFLinearRecordSize(efid, response);
            //waitForResult(status);
        //}
        //return recordSize;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.810 -0400", hash_original_method = "3F9A676B96CAA569C8E5C7846B910ECF", hash_generated_method = "BEF1EEA97271BB076B2AB9C1F90BA622")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logd(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:13.810 -0400", hash_original_method = "87C4CA182A2FF633172C99DE636527CD", hash_generated_method = "6623E034A54BF6BA1824682437DD6B31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String msg) {
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    static final String LOG_TAG = "CDMA";
}

