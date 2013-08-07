package com.android.internal.telephony;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.372 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.372 -0400", hash_original_field = "69E45E7E240C011D8CB3CFDE90D76B33", hash_generated_field = "C0FF63B0998195CF037A71BFC5C5B113")

    private PowerManager.WakeLock mWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.372 -0400", hash_original_field = "899670309FB45581BDB82613A5C571AB", hash_generated_field = "9F8B4768FAA4CFE15EF5A879C2BD432B")

    private boolean mReportMemoryStatusPending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.372 -0400", hash_original_field = "25D05DACB60858FF7568DE121D7FA36E", hash_generated_field = "6FA166605BB28AA15FBFAB6049BF15B1")

    CommandsInterface mCm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.372 -0400", hash_original_field = "749FC46D0369D805594414596D6562C8", hash_generated_field = "7DBC7A1AE70A2B85F1947F038E6E88AD")

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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.373 -0400", hash_original_method = "F493AFE631289C3191DD16CD5D858B75", hash_generated_method = "7744B9CA6A8361C2FC4D2DA65E5A2489")
    public  SmsStorageMonitor(PhoneBase phone) {
        mContext = phone.getContext();
        mCm = phone.mCM;
        createWakelock();
        mCm.setOnIccSmsFull(this, EVENT_ICC_FULL, null);
        mCm.registerForOn(this, EVENT_RADIO_ON, null);
        IntentFilter filter = new IntentFilter();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.374 -0400", hash_original_method = "811671DD7468C3C7A858127154F03F58", hash_generated_method = "693978ED23A36C55265B819E3BC96139")
    public void dispose() {
        mCm.unSetOnIccSmsFull(this);
        mCm.unregisterForOn(this);
        mContext.unregisterReceiver(mResultReceiver);
        // ---------- Original Method ----------
        //mCm.unSetOnIccSmsFull(this);
        //mCm.unregisterForOn(this);
        //mContext.unregisterReceiver(mResultReceiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.376 -0400", hash_original_method = "4ADFD820FBAEE3B9207F7288ABB2B3FA", hash_generated_method = "A5187DB7C279FFCA7DC88F2AEE9C18E6")
    @Override
    public void handleMessage(Message msg) {
        addTaint(msg.getTaint());
        AsyncResult ar;
switch(msg.what){
        case EVENT_ICC_FULL:
        handleIccFull();
        break;
        case EVENT_REPORT_MEMORY_STATUS_DONE:
        ar = (AsyncResult) msg.obj;
        if(ar.exception != null)        
        {
            mReportMemoryStatusPending = true;
        } //End block
        else
        {
            mReportMemoryStatusPending = false;
        } //End block
        break;
        case EVENT_RADIO_ON:
        if(mReportMemoryStatusPending)        
        {
            mCm.reportSmsMemoryStatus(mStorageAvailable,
                            obtainMessage(EVENT_REPORT_MEMORY_STATUS_DONE));
        } //End block
        break;
}
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.377 -0400", hash_original_method = "CBDD17965584D059356B67C204E0599E", hash_generated_method = "0DE4019B27CA1A73339D9921CA34394B")
    private void createWakelock() {
        PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SmsStorageMonitor");
        mWakeLock.setReferenceCounted(true);
        // ---------- Original Method ----------
        //PowerManager pm = (PowerManager)mContext.getSystemService(Context.POWER_SERVICE);
        //mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "SmsStorageMonitor");
        //mWakeLock.setReferenceCounted(true);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.377 -0400", hash_original_method = "A1AEC8C81078600BF66207F442C7D632", hash_generated_method = "4D96370800094366C09A5CD9CAFF2CDF")
    private void handleIccFull() {
        Intent intent = new Intent(Intents.SIM_FULL_ACTION);
        mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        mContext.sendBroadcast(intent, SMSDispatcher.RECEIVE_SMS_PERMISSION);
        // ---------- Original Method ----------
        //Intent intent = new Intent(Intents.SIM_FULL_ACTION);
        //mWakeLock.acquire(WAKE_LOCK_TIMEOUT);
        //mContext.sendBroadcast(intent, SMSDispatcher.RECEIVE_SMS_PERMISSION);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_method = "8AEABE91EB74288702D500EE9C97116A", hash_generated_method = "CD6D663E14557491D863544893E28E33")
    public boolean isStorageAvailable() {
        boolean var3CACC54997DC9ED5FC3D015BD6B4854B_386815609 = (mStorageAvailable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239308804 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239308804;
        // ---------- Original Method ----------
        //return mStorageAvailable;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_field = "35B10AB3CDA09F3B2F3131AD6DBAA325", hash_generated_field = "ADC819F4640257478A9F0F8C0177ED0F")

    private static final String TAG = "SmsStorageMonitor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_field = "905A760A3D1CE7FF20992BD2C6DF8BC1", hash_generated_field = "60DF9010B6324A6F570C8CA89266E9C0")

    private static final int EVENT_ICC_FULL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_field = "BE2064D81C56BB6CA87D2518D890D18E", hash_generated_field = "24A2262AA5E718C67EA641C704E03708")

    private static final int EVENT_REPORT_MEMORY_STATUS_DONE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_field = "59E79FAD2BB4329D584665182C5B822D", hash_generated_field = "4B8EAC96D11F2A46A4813E325B51B2AF")

    private static final int EVENT_RADIO_ON = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:19.378 -0400", hash_original_field = "B59EE70074140F54FE9A40B8C9352A9F", hash_generated_field = "B4C7CBA06229E71F94E76C8B33DB30C3")

    private static final int WAKE_LOCK_TIMEOUT = 5000;
}

