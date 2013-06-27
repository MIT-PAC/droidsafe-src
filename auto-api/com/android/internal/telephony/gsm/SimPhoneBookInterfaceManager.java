package com.android.internal.telephony.gsm;

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

public class SimPhoneBookInterfaceManager extends IccPhoneBookInterfaceManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.699 -0400", hash_original_method = "EB9FF0C7D9857B55B5A29EA1164E80F0", hash_generated_method = "67A0ACE92A93706063A7631C22735047")
    public  SimPhoneBookInterfaceManager(GSMPhone phone) {
        super(phone);
        adnCache = phone.mIccRecords.getAdnCache();
        addTaint(phone.getTaint());
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.700 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.700 -0400", hash_original_method = "11E9A9A4D579433D0F36A7564F8CD864", hash_generated_method = "4C6721F5A9C5E61BF8F6FC55DBAC4727")
    protected void finalize() {
        try 
        {
            super.finalize();
        } //End block
        catch (Throwable throwable)
        { }
        Log.d(LOG_TAG, "SimPhoneBookInterfaceManager finalized");
        // ---------- Original Method ----------
        //try {
            //super.finalize();
        //} catch (Throwable throwable) {
            //Log.e(LOG_TAG, "Error while finalizing:", throwable);
        //}
        //if(DBG) Log.d(LOG_TAG, "SimPhoneBookInterfaceManager finalized");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.701 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "4342E2FA5869B800FFE07098CD08C1ED")
    public int[] getAdnRecordsSize(int efid) {
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
        addTaint(efid);
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_146637516 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_146637516;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.701 -0400", hash_original_method = "7E6B689FB87F8B4FC5FFEDD55BD71E24", hash_generated_method = "05B82BB398702D4F65967737AA29DAF3")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.701 -0400", hash_original_method = "3C81ED33713B877CE55C1136EDE4985A", hash_generated_method = "9F7B016C36DFFE84C1135F8325127F9A")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:22.701 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "D3C0B237A982707BF0906F1B27E7321D")

    static String LOG_TAG = "GSM";
}

