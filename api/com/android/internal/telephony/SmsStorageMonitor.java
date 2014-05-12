package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Telephony.Sms.Intents;

public final class SmsStorageMonitor extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.467 -0500", hash_original_field = "FB7DBAB3BD99ADAD6D2F0065DB8C554C", hash_generated_field = "ADC819F4640257478A9F0F8C0177ED0F")

    private static final String TAG = "SmsStorageMonitor";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.469 -0500", hash_original_field = "D2791D3D7379190624E6E50644DF66C3", hash_generated_field = "60DF9010B6324A6F570C8CA89266E9C0")

    private static final int EVENT_ICC_FULL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.472 -0500", hash_original_field = "28B7664B27E1A5889FEAC8F76A68B1AE", hash_generated_field = "24A2262AA5E718C67EA641C704E03708")

    private static final int EVENT_REPORT_MEMORY_STATUS_DONE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.474 -0500", hash_original_field = "81478AEE511E4A529FB23C1C0421719A", hash_generated_field = "4B8EAC96D11F2A46A4813E325B51B2AF")

    private static final int EVENT_RADIO_ON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.488 -0500", hash_original_field = "65EAEBF48EC2BD9FC227F227DB04505F", hash_generated_field = "01706AE98C00842290153C530661773F")

    /**
     * Hold the wake lock for 5 seconds, which should be enough time for
     * any receiver(s) to grab its own wake lock.
     */
    private static final int WAKE_LOCK_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.477 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.479 -0500", hash_original_field = "87068C2348540A5517D7F6F40E0F6E43", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.481 -0500", hash_original_field = "C9768C965FD48249C77E944269AE4C3E", hash_generated_field = "9F8B4768FAA4CFE15EF5A879C2BD432B")

    private boolean mReportMemoryStatusPending;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.483 -0500", hash_original_field = "6FA166605BB28AA15FBFAB6049BF15B1", hash_generated_field = "6FA166605BB28AA15FBFAB6049BF15B1")

     CommandsInterface mCm;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.485 -0500", hash_original_field = "7DBC7A1AE70A2B85F1947F038E6E88AD", hash_generated_field = "7DBC7A1AE70A2B85F1947F038E6E88AD")

    boolean mStorageAvailable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.003 -0400", hash_original_field = "BC56B8F1C1A0861751BBE78333C8BDF8", hash_generated_field = "7712C2BDAAF354E20E58C1731007D923")

    private final BroadcastReceiver mResultReceiver = new BroadcastReceiver() {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.003 -0400", hash_original_method = "5F38BA022ACD3718858B6FAF49C82F2C", hash_generated_method = "433F6D8B0AF631BD6BC6DCF023E72652")
        @Override
        public void onReceive(Context context, Intent intent) {
            
            {
                boolean varFEE2B96B675C3083926B6753B5B2523D_1169935938 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_FULL));
                {
                    mStorageAvailable = false;
                    mCm.reportSmsMemoryStatus(false, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                } 
                {
                    boolean var77E80C3E4ECA6359DEEA0E8583A1E670_776775747 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_NOT_FULL));
                    {
                        mStorageAvailable = true;
                        mCm.reportSmsMemoryStatus(true, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                    } 
                } 
            } 
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            
        }
        
};

    /**
     * Creates an SmsStorageMonitor and registers for events.
     * @param phone the Phone to use
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.491 -0500", hash_original_method = "F493AFE631289C3191DD16CD5D858B75", hash_generated_method = "85207D23893660A0A15E61C0EBB0DD64")
    
public SmsStorageMonitor(PhoneBase phone) {
        mContext = phone.getContext();
        mCm = phone.mCM;

        createWakelock();

        mCm.setOnIccSmsFull(this, EVENT_ICC_FULL, null);
        mCm.registerForOn(this, EVENT_RADIO_ON, null);

        // Register for device storage intents.  Use these to notify the RIL
        // that storage for SMS is or is not available.
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_FULL);
        filter.addAction(Intent.ACTION_DEVICE_STORAGE_NOT_FULL);
        mContext.registerReceiver(mResultReceiver, filter);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.493 -0500", hash_original_method = "811671DD7468C3C7A858127154F03F58", hash_generated_method = "C142736D15AF0AF0EDB92606DC73220D")
    
public void dispose() {
        mCm.unSetOnIccSmsFull(this);
        mCm.unregisterForOn(this);
        mContext.unregisterReceiver(mResultReceiver);
    }

    /**
     * Handles events coming from the phone stack. Overridden from handler.
     * @param msg the message to handle
     */
    @DSSafe(DSCat.IPC_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.497 -0500", hash_original_method = "4ADFD820FBAEE3B9207F7288ABB2B3FA", hash_generated_method = "DBD9934380248D13C69A49A59A76507F")
    
@Override
    public void handleMessage(Message msg) {
        AsyncResult ar;

        switch (msg.what) {
            case EVENT_ICC_FULL:
                handleIccFull();
                break;

            case EVENT_REPORT_MEMORY_STATUS_DONE:
                ar = (AsyncResult) msg.obj;
                if (ar.exception != null) {
                    mReportMemoryStatusPending = true;
                    Log.v(TAG, "Memory status report to modem pending : mStorageAvailable = "
                            + mStorageAvailable);
                } else {
                    mReportMemoryStatusPending = false;
                }
                break;

            case EVENT_RADIO_ON:
                if (mReportMemoryStatusPending) {
                    Log.v(TAG, "Sending pending memory status report : mStorageAvailable = "
                            + mStorageAvailable);
                    mCm.reportSmsMemoryStatus(mStorageAvailable,
                            obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                }
                break;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.499 -0500", hash_original_method = "CBDD17965584D059356B67C204E0599E", hash_generated_method = "59DB1211363D99AB5450D719CF1C9B6E")
    
private void createWakelock() {
        PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SmsStorageMonitor");
        mWakeLock.setReferenceCounted(true);
    }

    /**
     * Called when SIM_FULL message is received from the RIL.  Notifies interested
     * parties that SIM storage for SMS messages is full.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.501 -0500", hash_original_method = "A1AEC8C81078600BF66207F442C7D632", hash_generated_method = "7E0FF3D59263946E3DA08FAE6D77851D")
    
private void handleIccFull() {
        // broadcast SIM_FULL intent
        Intent intent = new Intent(Intents.SIM_FULL_ACTION);
        mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        mContext.sendBroadcast(intent, SMSDispatcher.RECEIVE_SMS_PERMISSION);
    }

    /** Returns whether or not there is storage available for an incoming SMS. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:17.503 -0500", hash_original_method = "8AEABE91EB74288702D500EE9C97116A", hash_generated_method = "5FE078E65308257A905D025017A215A6")
    
public boolean isStorageAvailable() {
        return mStorageAvailable;
    }
}

