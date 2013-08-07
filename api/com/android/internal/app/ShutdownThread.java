package com.android.internal.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.ProgressDialog;
import android.os.Power;
import android.os.SystemClock;
import android.os.Vibrator;
import android.content.DialogInterface;
import android.util.Log;
import android.view.WindowManager;
import android.os.storage.IMountShutdownObserver;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.content.BroadcastReceiver;
import android.bluetooth.IBluetooth;
import android.content.Intent;
import android.os.Handler;
import android.app.ActivityManagerNative;
import android.os.storage.IMountService;
import android.app.Dialog;
import android.os.SystemProperties;
import com.android.internal.telephony.ITelephony;
import android.content.IntentFilter;
import android.app.AlertDialog;
import android.app.IActivityManager;
import android.content.Context;
import android.bluetooth.BluetoothAdapter;
import android.os.PowerManager;
public final class ShutdownThread extends Thread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.524 -0400", hash_original_field = "7CE38FCFDF2D05E9E271DED683B697C3", hash_generated_field = "15B53E8BCEED5432F4D71F5A0879B5DA")

    private final Object mActionDoneSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.525 -0400", hash_original_field = "116C8677C258022DCBDD4D0EAD21F504", hash_generated_field = "509F4163626FE95E2EDB5B55878971E7")

    private boolean mActionDone;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.525 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.526 -0400", hash_original_field = "914EF4BB3FD2989BEA197B83DB980E43", hash_generated_field = "C0ABFDE975E218E90A8E9AECD9B1F45A")

    private PowerManager mPowerManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.526 -0400", hash_original_field = "DB96C9E53A20BE35D877086567454266", hash_generated_field = "1D128A4802842834CA85C9C5E61B81CC")

    private PowerManager.WakeLock mCpuWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.526 -0400", hash_original_field = "B856EB226C5EDCBCF395F07B3B295B3D", hash_generated_field = "4F1766A522E6DB82FCD95AE274742460")

    private PowerManager.WakeLock mScreenWakeLock;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.527 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.527 -0400", hash_original_method = "115D0338FD20B2B4AC94BDB3BF74A3E3", hash_generated_method = "21DF4EC75BD90EA07501EDB79AC5760C")
    private  ShutdownThread() {
        // ---------- Original Method ----------
    }

    
    public static void shutdown(final Context context, boolean confirm) {
        synchronized (sIsStartedGuard) {
            if (sIsStarted) {
                Log.d(TAG, "Request to shutdown already running, returning.");
                return;
            }
        }
        final int longPressBehavior = context.getResources().getInteger(
                        com.android.internal.R.integer.config_longPressOnPowerBehavior);
        final int resourceId = longPressBehavior == 2
                ? com.android.internal.R.string.shutdown_confirm_question
                : com.android.internal.R.string.shutdown_confirm;
        Log.d(TAG, "Notifying thread to start shutdown longPressBehavior=" + longPressBehavior);
        if (confirm) {
            final CloseDialogReceiver closer = new CloseDialogReceiver(context);
            final AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle(com.android.internal.R.string.power_off)
                    .setMessage(resourceId)
                    .setPositiveButton(com.android.internal.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            beginShutdownSequence(context);
                        }
                    })
                    .setNegativeButton(com.android.internal.R.string.no, null)
                    .create();
            closer.dialog = dialog;
            dialog.setOnDismissListener(closer);
            dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
            dialog.show();
        } else {
            beginShutdownSequence(context);
        }
    }

    
    public static void reboot(final Context context, String reason, boolean confirm) {
        mReboot = true;
        mRebootReason = reason;
        shutdown(context, confirm);
    }

    
    private static void beginShutdownSequence(Context context) {
        synchronized (sIsStartedGuard) {
            if (sIsStarted) {
                Log.d(TAG, "Shutdown sequence already running, returning.");
                return;
            }
            sIsStarted = true;
        }
        ProgressDialog pd = new ProgressDialog(context);
        pd.setTitle(context.getText(com.android.internal.R.string.power_off));
        pd.setMessage(context.getText(com.android.internal.R.string.shutdown_progress));
        pd.setIndeterminate(true);
        pd.setCancelable(false);
        pd.getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        pd.show();
        sInstance.mContext = context;
        sInstance.mPowerManager = (PowerManager)context.getSystemService(Context.POWER_SERVICE);
        sInstance.mCpuWakeLock = null;
        try {
            sInstance.mCpuWakeLock = sInstance.mPowerManager.newWakeLock(
                    PowerManager.PARTIAL_WAKE_LOCK, TAG + "-cpu");
            sInstance.mCpuWakeLock.setReferenceCounted(false);
            sInstance.mCpuWakeLock.acquire();
        } catch (SecurityException e) {
            Log.w(TAG, "No permission to acquire wake lock", e);
            sInstance.mCpuWakeLock = null;
        }
        sInstance.mScreenWakeLock = null;
        if (sInstance.mPowerManager.isScreenOn()) {
            try {
                sInstance.mScreenWakeLock = sInstance.mPowerManager.newWakeLock(
                        PowerManager.FULL_WAKE_LOCK, TAG + "-screen");
                sInstance.mScreenWakeLock.setReferenceCounted(false);
                sInstance.mScreenWakeLock.acquire();
            } catch (SecurityException e) {
                Log.w(TAG, "No permission to acquire wake lock", e);
                sInstance.mScreenWakeLock = null;
            }
        }
        sInstance.mHandler = new Handler() {
        };
        sInstance.start();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.530 -0400", hash_original_method = "A9725DDED11455278AE77F5C62728DC8", hash_generated_method = "9FF44A8213BE39943A83E76668440A55")
     void actionDone() {
        synchronized
(mActionDoneSync)        {
mActionDone=truemActionDoneSync.notifyAll()
        } //End block
        // ---------- Original Method ----------
        //synchronized (mActionDoneSync) {
            //mActionDone = true;
            //mActionDoneSync.notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.533 -0400", hash_original_method = "E89C36018E17ACFB09B8CFEB0502172C", hash_generated_method = "FA53C6B9AC8B461191BBB7D7DFABCDE1")
    public void run() {
        boolean bluetoothOff;
        boolean radioOff;
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override public void onReceive(Context context, Intent intent) {
                actionDone();
            }
        };
        {
            String reason = (mReboot ? "1" : "0") + (mRebootReason != null ? mRebootReason : "");
SystemProperties.set(SHUTDOWN_ACTION_PROPERTY, reason)
        } //End block
mActionDone=falsemContext.sendOrderedBroadcast(new Intent(Intent.ACTION_SHUTDOWN), null, br, mHandler, 0, null, null)        final long endTime = SystemClock.elapsedRealtime() + MAX_BROADCAST_TIME;
        synchronized
(mActionDoneSync)        {
            while
(!mActionDone)            
            {
                long delay = endTime - SystemClock.elapsedRealtime();
                if(delay<=0)                
                {
                    break;
                } //End block
                try 
                {
mActionDoneSync.wait(delay)
                } //End block
                catch (InterruptedException e)
                {
                } //End block
            } //End block
        } //End block
        final IActivityManager am = ActivityManagerNative.asInterface(ServiceManager.checkService("activity"));
        if(am!=null)        
        {
            try 
            {
am.shutdown(MAX_BROADCAST_TIME)
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        final ITelephony phone = ITelephony.Stub.asInterface(ServiceManager.checkService("phone"));
        final IBluetooth bluetooth = IBluetooth.Stub.asInterface(ServiceManager.checkService(
                        BluetoothAdapter.BLUETOOTH_SERVICE));
        final IMountService mount = IMountService.Stub.asInterface(
                        ServiceManager.checkService("mount"));
        try 
        {
bluetoothOff=bluetooth==null||bluetooth.getBluetoothState()==BluetoothAdapter.STATE_OFF            if(!bluetoothOff)            
            {
bluetooth.disable(false)
            } //End block
        } //End block
        catch (RemoteException ex)
        {
bluetoothOff=true
        } //End block
        try 
        {
radioOff=phone==null||!phone.isRadioOn()            if(!radioOff)            
            {
phone.setRadio(false)
            } //End block
        } //End block
        catch (RemoteException ex)
        {
radioOff=true
        } //End block
for(int i = 0;i<MAX_NUM_PHONE_STATE_READS;i)
        {
            if(!bluetoothOff)            
            {
                try 
                {
bluetoothOff=bluetooth.getBluetoothState()==BluetoothAdapter.STATE_OFF
                } //End block
                catch (RemoteException ex)
                {
bluetoothOff=true
                } //End block
            } //End block
            if(!radioOff)            
            {
                try 
                {
radioOff=!phone.isRadioOn()
                } //End block
                catch (RemoteException ex)
                {
radioOff=true
                } //End block
            } //End block
            if(radioOff&&bluetoothOff)            
            {
                break;
            } //End block
SystemClock.sleep(PHONE_STATE_POLL_SLEEP_MSEC)
        } //End block
        IMountShutdownObserver observer = new IMountShutdownObserver.Stub() {
            public void onShutDownComplete(int statusCode) throws RemoteException {
                Log.w(TAG, "Result code " + statusCode + " from MountService.shutdown");
                actionDone();
            }
        };
mActionDone=false        final long endShutTime = SystemClock.elapsedRealtime() + MAX_SHUTDOWN_WAIT_TIME;
        synchronized
(mActionDoneSync)        {
            try 
            {
                if(mount!=null)                
                {
mount.shutdown(observer)
                } //End block
                else
                {
                } //End block
            } //End block
            catch (Exception e)
            {
            } //End block
            while
(!mActionDone)            
            {
                long delay = endShutTime - SystemClock.elapsedRealtime();
                if(delay<=0)                
                {
                    break;
                } //End block
                try 
                {
mActionDoneSync.wait(delay)
                } //End block
                catch (InterruptedException e)
                {
                } //End block
            } //End block
        } //End block
rebootOrShutdown(mReboot, mRebootReason)
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static void rebootOrShutdown(boolean reboot, String reason) {
        if (reboot) {
            Log.i(TAG, "Rebooting, reason: " + reason);
            try {
                Power.reboot(reason);
            } catch (Exception e) {
                Log.e(TAG, "Reboot failed, will attempt shutdown instead", e);
            }
        } else if (SHUTDOWN_VIBRATE_MS > 0) {
            Vibrator vibrator = new Vibrator();
            try {
                vibrator.vibrate(SHUTDOWN_VIBRATE_MS);
            } catch (Exception e) {
                Log.w(TAG, "Failed to vibrate during shutdown.", e);
            }
            try {
                Thread.sleep(SHUTDOWN_VIBRATE_MS);
            } catch (InterruptedException unused) {
            }
        }
        Log.i(TAG, "Performing low-level shutdown...");
        Power.shutdown();
    }

    
    private static class CloseDialogReceiver extends BroadcastReceiver implements DialogInterface.OnDismissListener {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.536 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

        private Context mContext;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.537 -0400", hash_original_field = "91C7EC8D1C8BB75E853F70FEE324A43B", hash_generated_field = "125893687654D9A3439C7E3A2A4B7C16")

        public Dialog dialog;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.538 -0400", hash_original_method = "92F27FA11D4344F53674FD98FDA3735F", hash_generated_method = "3559FF1C881B028FE1D26EA696898112")
          CloseDialogReceiver(Context context) {
            addTaint(context.getTaint());
mContext=context            IntentFilter filter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
context.registerReceiver(this, filter)
            // ---------- Original Method ----------
            //mContext = context;
            //IntentFilter filter = new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS);
            //context.registerReceiver(this, filter);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.539 -0400", hash_original_method = "E91648B96E88DD48551F07961966C327", hash_generated_method = "6F07BF41C8517711EA80BDD4DAE65B1C")
        @Override
        public void onReceive(Context context, Intent intent) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(intent.getTaint());
            addTaint(context.getTaint());
dialog.cancel()
            // ---------- Original Method ----------
            //dialog.cancel();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.540 -0400", hash_original_method = "49E40C349EB7466A5818F808A326B10D", hash_generated_method = "C32D8A2D1A74328F4B842EB83CE1879A")
        public void onDismiss(DialogInterface unused) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(unused.getTaint());
mContext.unregisterReceiver(this)
            // ---------- Original Method ----------
            //mContext.unregisterReceiver(this);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.541 -0400", hash_original_field = "5820534196B8DC81A2D61C4B9361B6E0", hash_generated_field = "9E12CAF7EB633B728865937A87C9CA34")

    private static final String TAG = "ShutdownThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.541 -0400", hash_original_field = "92B9863CD0FA26C9C80BE80C1CA38522", hash_generated_field = "70575DB617E9BF82E7A5D2BCA0B7D5A7")

    private static final int MAX_NUM_PHONE_STATE_READS = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.542 -0400", hash_original_field = "F83066B1A754A3E546BA360748FC21CA", hash_generated_field = "E40390E25F97A429DC2483CF0F9DDB6C")

    private static final int PHONE_STATE_POLL_SLEEP_MSEC = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.543 -0400", hash_original_field = "0B3B596D51EEC5B7BA3A9989B67146DB", hash_generated_field = "6BB33E3F0187D33566F321E8FBDF6C0A")

    private static final int MAX_BROADCAST_TIME = 10*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.543 -0400", hash_original_field = "9650C62474BCEB10798D369F20292037", hash_generated_field = "2128A6DB35FDB33C9AC6129302D0690C")

    private static final int MAX_SHUTDOWN_WAIT_TIME = 20*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.544 -0400", hash_original_field = "68758FC8507E619113DB92920AB41012", hash_generated_field = "B7DDA32347B97E005BEF3C61A69E49A7")

    private static final int SHUTDOWN_VIBRATE_MS = 500;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.544 -0400", hash_original_field = "0DF4FE6EC25265A1853F0BD75FECD34A", hash_generated_field = "0E4452AD1733F112A3FFC3DCA1F26317")

    private static Object sIsStartedGuard = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.544 -0400", hash_original_field = "87EA77AC3351B8417196292DB8350CFE", hash_generated_field = "96DA4EB6DC30545D70A0F731C81E710F")

    private static boolean sIsStarted = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.545 -0400", hash_original_field = "CDF69FF65FB96B388B1F74BFD546D502", hash_generated_field = "0FE021681B70AF3E8C142391EA64A8ED")

    private static boolean mReboot;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-08-07 13:35:40.545 -0400", hash_original_field = "F86683160F70396C25C705E99015BA2F", hash_generated_field = "18C9235636D60E01A8D5AFC8D1A0B0F4")

    private static String mRebootReason;

