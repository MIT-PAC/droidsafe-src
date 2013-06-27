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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.062 -0400", hash_original_method = "DEF9FAED33693F054DDAD69DBF684358", hash_generated_method = "9DD8A6AF65C9E52EB902A3B2AD3CA789")
    public  RuimPhoneBookInterfaceManager(CDMAPhone phone) {
        super(phone);
        adnCache = phone.mIccRecords.getAdnCache();
        addTaint(phone.getTaint());
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.062 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.063 -0400", hash_original_method = "DBC78DBC20746AFDB653AFC4701001A9", hash_generated_method = "5C9621C5FED2DAE78D5F6048454FBEAA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.063 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "AD6990972EAB89235EB2AE25E4C2698F")
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
        int[] varB4CCCA26F9DB9189C32F33E82D425CFB_2010920440 = {getTaintInt()};
        return varB4CCCA26F9DB9189C32F33E82D425CFB_2010920440;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.071 -0400", hash_original_method = "3F9A676B96CAA569C8E5C7846B910ECF", hash_generated_method = "6A35717B0E022C635895546DB845E28B")
    protected void logd(String msg) {
        Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.072 -0400", hash_original_method = "87C4CA182A2FF633172C99DE636527CD", hash_generated_method = "4823C001B774DC70663F87F1BACCD1E4")
    protected void loge(String msg) {
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[RuimPbInterfaceManager] " + msg);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:21.072 -0400", hash_original_field = "951C150E6D062E6AED2C45BB9B756185", hash_generated_field = "3985FC5365F0E17AC0BA70F3DC93B852")

    static String LOG_TAG = "CDMA";
}

