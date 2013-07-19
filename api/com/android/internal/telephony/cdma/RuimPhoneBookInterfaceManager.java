package com.android.internal.telephony.cdma;

// Droidsafe Imports
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccPhoneBookInterfaceManager;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

public class RuimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.301 -0400", hash_original_method = "DEF9FAED33693F054DDAD69DBF684358", hash_generated_method = "0E4D483D9675402D7D013319E1AB1917")
    public  RuimPhoneBookInterfaceManager(CDMAPhone phone) {
        super(phone);
        addTaint(phone.getTaint());
        adnCache = phone.mIccRecords.getAdnCache();
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.301 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.301 -0400", hash_original_method = "DBC78DBC20746AFDB653AFC4701001A9", hash_generated_method = "7877DE135B03348F88DBEB3AFCBACC90")
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        {
        } //End block
        if(DBG)        
        Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "RuimPhoneBookInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.302 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "C9570B711E5561109FD339A7075B7C80")
    public int[] getAdnRecordsSize(int efid) {
        addTaint(efid);
        if(DBG)        
        logd("getAdnRecordsSize: efid=" + efid);
        synchronized
(mLock)        {
            checkThread();
            recordSize = new int[3];
            AtomicBoolean status = new AtomicBoolean(false);
            Message response = mBaseHandler.obtainMessage(EVENT_GET_SIZE_DONE, status);
            phone.getIccFileHandler().getEFLinearRecordSize(efid, response);
            waitForResult(status);
        } //End block
        int[] var5BF8005FBC54CBD8FD3B1DD07A722DAC_1204471422 = (recordSize);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_324195756 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_324195756;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.303 -0400", hash_original_method = "3F9A676B96CAA569C8E5C7846B910ECF", hash_generated_method = "19533D96E6305AE0B8DE41EBDC71113C")
    protected void logd(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.303 -0400", hash_original_method = "87C4CA182A2FF633172C99DE636527CD", hash_generated_method = "4823C001B774DC70663F87F1BACCD1E4")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:23.303 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "37C2AB96DD7CCDC96FF809DAC1A6D712")

    static final String LOG_TAG = "CDMA";
}

