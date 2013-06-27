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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.527 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.527 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.527 -0400", hash_original_field = "899670309FB45581BDB82613A5C571AB", hash_generated_field = "9F8B4768FAA4CFE15EF5A879C2BD432B")

    private boolean mReportMemoryStatusPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.527 -0400", hash_original_field = "25D05DACB60858FF7568DE121D7FA36E", hash_generated_field = "6FA166605BB28AA15FBFAB6049BF15B1")

    CommandsInterface mCm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.527 -0400", hash_original_field = "749FC46D0369D805594414596D6562C8", hash_generated_field = "7DBC7A1AE70A2B85F1947F038E6E88AD")

    boolean mStorageAvailable = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.535 -0400", hash_original_field = "BC56B8F1C1A0861751BBE78333C8BDF8", hash_generated_field = "29B46927D356DE7F7AFD514F97A9A27E")

    private BroadcastReceiver mResultReceiver = new BroadcastReceiver() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.535 -0400", hash_original_method = "5F38BA022ACD3718858B6FAF49C82F2C", hash_generated_method = "10F6A09FE2879F416CC213D2651736BF")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                boolean varFEE2B96B675C3083926B6753B5B2523D_1925676110 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_FULL));
                {
                    mStorageAvailable = false;
                    mCm.reportSmsMemoryStatus(false, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                } //End block
                {
                    boolean var77E80C3E4ECA6359DEEA0E8583A1E670_709177742 = (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_NOT_FULL));
                    {
                        mStorageAvailable = true;
                        mCm.reportSmsMemoryStatus(true, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            addTaint(context.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //if (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_FULL)) {
                //mStorageAvailable = false;
                //mCm.reportSmsMemoryStatus(false, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
            //} else if (intent.getAction().equals(Intent.ACTION_DEVICE_STORAGE_NOT_FULL)) {
                //mStorageAvailable = true;
                //mCm.reportSmsMemoryStatus(true, obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
            //}
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.538 -0400", hash_original_method = "F493AFE631289C3191DD16CD5D858B75", hash_generated_method = "97CAC49A1E4C3AE0BAEBA5651E4FEEEA")
    public  SmsStorageMonitor(PhoneBase phone) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.539 -0400", hash_original_method = "811671DD7468C3C7A858127154F03F58", hash_generated_method = "693978ED23A36C55265B819E3BC96139")
    public void dispose() {
        mCm.unSetOnIccSmsFull(this);
        mCm.unregisterForOn(this);
        mContext.unregisterReceiver(mResultReceiver);
        // ---------- Original Method ----------
        //mCm.unSetOnIccSmsFull(this);
        //mCm.unregisterForOn(this);
        //mContext.unregisterReceiver(mResultReceiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.539 -0400", hash_original_method = "4ADFD820FBAEE3B9207F7288ABB2B3FA", hash_generated_method = "6372985DC446AE67695604B2303F7009")
    @Override
    public void handleMessage(Message msg) {
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
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.547 -0400", hash_original_method = "CBDD17965584D059356B67C204E0599E", hash_generated_method = "BA916EB318DE607B4A69076AD4F9EE79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_method = "A1AEC8C81078600BF66207F442C7D632", hash_generated_method = "639CB459C287B160183E346F8A80A77B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_method = "8AEABE91EB74288702D500EE9C97116A", hash_generated_method = "4F7E4416B076DF656E0983F7B9A166A1")
    public boolean isStorageAvailable() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1780241810 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1780241810;
        // ---------- Original Method ----------
        //return mStorageAvailable;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_field = "35B10AB3CDA09F3B2F3131AD6DBAA325", hash_generated_field = "3D20442FA204AFA6A0E06C1C02874F18")

    private static String TAG = "SmsStorageMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_field = "905A760A3D1CE7FF20992BD2C6DF8BC1", hash_generated_field = "F6FEA627F343BC4345441F71F8085C75")

    private static int EVENT_ICC_FULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_field = "BE2064D81C56BB6CA87D2518D890D18E", hash_generated_field = "3C3FF6B8DE12B0C8914C2F92992A5377")

    private static int EVENT_REPORT_MEMORY_STATUS_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_field = "59E79FAD2BB4329D584665182C5B822D", hash_generated_field = "0545BB9FF83D2B6BAA25BB2288802AFC")

    private static int EVENT_RADIO_ON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:16.555 -0400", hash_original_field = "B59EE70074140F54FE9A40B8C9352A9F", hash_generated_field = "9AB78C2F6B3D53B12C8ABAD036DB6520")

    private static int WAKE_LOCK_TIMEOUT = 5000;
}

