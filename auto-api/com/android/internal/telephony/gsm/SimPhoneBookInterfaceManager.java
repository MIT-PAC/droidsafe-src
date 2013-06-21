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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.814 -0400", hash_original_method = "EB9FF0C7D9857B55B5A29EA1164E80F0", hash_generated_method = "A4E29422201B6F2956C36BD77D98C90A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SimPhoneBookInterfaceManager(GSMPhone phone) {
        super(phone);
        dsTaint.addTaint(phone.dsTaint);
        adnCache = phone.mIccRecords.getAdnCache();
        // ---------- Original Method ----------
        //adnCache = phone.mIccRecords.getAdnCache();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.815 -0400", hash_original_method = "9B378D368B78D2E2F938DA57C729E6B5", hash_generated_method = "9A4F77B4E25F9CFE2D71D8AC605A621B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        super.dispose();
        // ---------- Original Method ----------
        //super.dispose();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.815 -0400", hash_original_method = "11E9A9A4D579433D0F36A7564F8CD864", hash_generated_method = "4C6721F5A9C5E61BF8F6FC55DBAC4727")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.815 -0400", hash_original_method = "F8C8B1EC8901BE31BE40309AF8515A8A", hash_generated_method = "578C0C76F5BDF0799D86E551B1C3D0B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.815 -0400", hash_original_method = "7E6B689FB87F8B4FC5FFEDD55BD71E24", hash_generated_method = "E96A3AB0BBE1327395E9931DF61A493E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void logd(String msg) {
        dsTaint.addTaint(msg);
        Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
        // ---------- Original Method ----------
        //Log.d(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:16.816 -0400", hash_original_method = "3C81ED33713B877CE55C1136EDE4985A", hash_generated_method = "D95819DEDF635558AFAEAE4B54A40004")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void loge(String msg) {
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
        //Log.e(LOG_TAG, "[SimPbInterfaceManager] " + msg);
    }

    
    static final String LOG_TAG = "GSM";
}

