package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Telephony.Sms.Intents;
import android.util.Log;

public final class SmsStorageMonitor extends Handler {
    private Context mContext;
    private PowerManager.WakeLock mWakeLock;
    private boolean mReportMemoryStatusPending;
    CommandsInterface mCm;
    boolean mStorageAvailable = true;
    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.511 -0400", hash_original_method = "5F38BA022ACD3718858B6FAF49C82F2C", hash_generated_method = "18F4C45C784D8A109211F07DA137FDBB")
        @DSModeled(DSC.SPEC)
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            {
                boolean varFEE2B96B675C3083926B6753B5B2523D_319640562 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_FULL));
                {
                    mStorageAvailable = false;
                    mCm.reportSmsMemoryStatus(false, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                } //End block
                {
                    boolean var77E80C3E4ECA6359DEEA0E8583A1E670_1729770038 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_NOT_FULL));
                    {
                        mStorageAvailable = true;
                        mCm.reportSmsMemoryStatus(true, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_FULL)) {
                //mStorageAvailable = false;
                //mCm.reportSmsMemoryStatus(false, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
            //} else if (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_NOT_FULL)) {
                //mStorageAvailable = true;
                //mCm.reportSmsMemoryStatus(true, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
            //}
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.512 -0400", hash_original_method = "F493AFE631289C3191DD16CD5D858B75", hash_generated_method = "1A39A918E500606AC3F46D7E84996053")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SmsStorageMonitor(PhoneBase phone) {
        dsTaint.addTaint(phone.dsTaint);
        mContext = phone.getContext();
        mCm = phone.mCM;
        createWakelock();
        mCm.setOnIccSmsFull(this, EVENT_ICC_FULL, null);
        mCm.registerForOn(this, EVENT_RADIO_ON, null);
        IntentFilter filter;
        filter = new IntentFilter();
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_FULL);
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_NOT_FULL);
        mContext.registerReceiver(mResultReceiver, filter);
        // ---------- Original Method ----------
        //mContext = phone.getContext();
        //mCm = phone.mCM;
        //createWakelock();
        //mCm.setOnIccSmsFull(this, EVENT_ICC_FULL, null);
        //mCm.registerForOn(this, EVENT_RADIO_ON, null);
        //IntentFilter filter = new IntentFilter();
        //filter.addAction(Intent.ACTION_DEVICE_STORAGE_FULL);
        //filter.addAction(Intent.ACTION_DEVICE_STORAGE_NOT_FULL);
        //mContext.registerReceiver(mResultReceiver, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.512 -0400", hash_original_method = "811671DD7468C3C7A858127154F03F58", hash_generated_method = "693978ED23A36C55265B819E3BC96139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispose() {
        mCm.unSetOnIccSmsFull(this);
        mCm.unregisterForOn(this);
        mContext.unregisterReceiver(mResultReceiver);
        // ---------- Original Method ----------
        //mCm.unSetOnIccSmsFull(this);
        //mCm.unregisterForOn(this);
        //mContext.unregisterReceiver(mResultReceiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.513 -0400", hash_original_method = "4ADFD820FBAEE3B9207F7288ABB2B3FA", hash_generated_method = "803636A13458EE538007EE194BEE64AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        AsyncResult ar;
        //Begin case EVENT_ICC_FULL 
        handleIccFull();
        //End case EVENT_ICC_FULL 
        //Begin case EVENT_REPORT_MEMORY_STATUS_DONE 
        ar = (AsyncResult) msg.obj;
        //End case EVENT_REPORT_MEMORY_STATUS_DONE 
        //Begin case EVENT_REPORT_MEMORY_STATUS_DONE 
        {
            mReportMemoryStatusPending = true;
        } //End block
        {
            mReportMemoryStatusPending = false;
        } //End block
        //End case EVENT_REPORT_MEMORY_STATUS_DONE 
        //Begin case EVENT_RADIO_ON 
        {
            mCm.reportSmsMemoryStatus(mStorageAvailable,
                            obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
        } //End block
        //End case EVENT_RADIO_ON 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.513 -0400", hash_original_method = "CBDD17965584D059356B67C204E0599E", hash_generated_method = "BA916EB318DE607B4A69076AD4F9EE79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void createWakelock() {
        PowerManager pm;
        pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SmsStorageMonitor");
        mWakeLock.setReferenceCounted(true);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        //mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SmsStorageMonitor");
        //mWakeLock.setReferenceCounted(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.513 -0400", hash_original_method = "A1AEC8C81078600BF66207F442C7D632", hash_generated_method = "639CB459C287B160183E346F8A80A77B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleIccFull() {
        Intent intent;
        intent = new Intent(Intents.SIM_FULL_ACTION);
        mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        mContext.sendBroadcast(intent, SMSDispatcher.RECEIVE_SMS_PERMISSION);
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intents.SIM_FULL_ACTION);
        //mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        //mContext.sendBroadcast(intent, SMSDispatcher.RECEIVE_SMS_PERMISSION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.513 -0400", hash_original_method = "8AEABE91EB74288702D500EE9C97116A", hash_generated_method = "5A4F0EC70A9D7D7CCF8B828A7141D783")
    @DSModeled(DSC.SAFE)
    public boolean isStorageAvailable() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mStorageAvailable;
    }

    
    private static final String TAG = "SmsStorageMonitor";
    private static final int EVENT_ICC_FULL = 1;
    private static final int EVENT_REPORT_MEMORY_STATUS_DONE = 2;
    private static final int EVENT_RADIO_ON = 3;
    private static final int WAKE_LOCK_TIMEOUT = 5000;
}

