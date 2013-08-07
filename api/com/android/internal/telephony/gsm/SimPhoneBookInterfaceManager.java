package com.android.internal.telephony.gsm;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Message;
import android.util.Log;

import com.android.internal.telephony.IccPhoneBookInterfaceManager;




public class SimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.603 -0400", hash_original_method = "EB9FF0C7D9857B55B5A29EA1164E80F0", hash_generated_method = "6585ACE95180A35F68530DD9DA965B83")
    public  SimPhoneBookInterfaceManager(GSMPhone phone) {
        super(phone);
        addTaint(phone.getTaint());
        adnCache = phone.mIccRecords.getAdnCache();
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.603 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.604 -0400", hash_original_method = "11E9A9A4D579433D0F36A7564F8CD864", hash_generated_method = "AB85FE4F4EC33DBF876C82D38D5CD187")
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        {
        } //End block
        if(DBG)        
        Log.d(LOG_TAG, "SimPhoneBookInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "SimPhoneBookInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.604 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "CD8775984EF3A557C8C68ED50F20AB29")
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
        int[] var5BF8005FBC54CBD8FD3B1DD07A722DAC_1415305211 = (recordSize);
                int[] varB4CCCA26F9DB9189C32F33E82D425CFB_1509354119 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_1509354119;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.604 -0400", hash_original_method = "7E6B689FB87F8B4FC5FFEDD55BD71E24", hash_generated_method = "782D6147A8D9739BD339E04B74B3AA9E")
    protected void logd(String msg) {
        addTaint(msg.getTaint());
        Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.604 -0400", hash_original_method = "3C81ED33713B877CE55C1136EDE4985A", hash_generated_method = "9F7B016C36DFFE84C1135F8325127F9A")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:25.604 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "B8386CD6D900777C9D6A0A5CA1D0B217")

    static final String LOG_TAG = "GSM";
}

