package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ContextWrapper;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.RemoteException;
import android.os.IBinder;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class Service extends ContextWrapper implements ComponentCallbacks2 {
    private ActivityThread mThread = null;
    private String mClassName = null;
    private IBinder mToken = null;
    private Application mApplication = null;
    private IActivityManager mActivityManager = null;
    private boolean mStartCompatibility = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.843 -0400", hash_original_method = "D0179C650F036CDA92B50348E0090B82", hash_generated_method = "F9D63210E10597231C4F4BD03B0C29AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Service() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.843 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "8CE7C8F4B14D9FB3ED66AED3A5AE2EA8")
    @DSModeled(DSC.SAFE)
    public final Application getApplication() {
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.844 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    @DSModeled(DSC.SAFE)
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.844 -0400", hash_original_method = "8DB0845BC67A569482FD95D924F2B38E", hash_generated_method = "2D8037B326492CA5323C8086BF88B483")
    @DSModeled(DSC.SPEC)
    @Deprecated
    public void onStart(Intent intent, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(startId);
        dsTaint.addTaint(intent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.845 -0400", hash_original_method = "C7065D6B9C7065CE68918429E4AC852C", hash_generated_method = "56B0F0723534132C7A78C57EA169C696")
    @DSModeled(DSC.SPEC)
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(startId);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(intent.dsTaint);
        onStart(intent, startId);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //onStart(intent, startId);
        //return mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.846 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    @DSModeled(DSC.SAFE)
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.848 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "62ADC209A3CA21C2E5A975A58EB63DBA")
    @DSModeled(DSC.SAFE)
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.849 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    @DSModeled(DSC.SAFE)
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.849 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C9C9C0A5CE6C55C02F314458C48A02DB")
    @DSModeled(DSC.SAFE)
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        // ---------- Original Method ----------
    }

    
    public abstract IBinder onBind(Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.850 -0400", hash_original_method = "5942B5AC8056FD2F0F888A571E85A724", hash_generated_method = "70627336DAA6556133D7ECF409E58DE9")
    @DSModeled(DSC.SPEC)
    public boolean onUnbind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.850 -0400", hash_original_method = "96E602EF97C136D1349E20B0217FC297", hash_generated_method = "08E519AFC7DF9D3738AC79DFB80958BB")
    @DSModeled(DSC.SPEC)
    public void onRebind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(intent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.850 -0400", hash_original_method = "8FB0E93CA9596F065DFD6DBA45B93821", hash_generated_method = "C1F551EA14BAD230334A2EF296257CD9")
    @DSModeled(DSC.SPEC)
    public void onTaskRemoved(Intent rootIntent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(rootIntent.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.851 -0400", hash_original_method = "63DABFC9549E2FB476F01FDE2AC0A25B", hash_generated_method = "9C957CF5C3759100051FFDCA4A386C02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void stopSelf() {
        stopSelf(-1);
        // ---------- Original Method ----------
        //stopSelf(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.851 -0400", hash_original_method = "945F4D421616C07D2272A8F5A6D0EDF6", hash_generated_method = "9CE6A57E716C9BE522AB53136D7D35D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void stopSelf(int startId) {
        dsTaint.addTaint(startId);
        try 
        {
            mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //if (mActivityManager == null) {
            //return;
        //}
        //try {
            //mActivityManager.stopServiceToken(
                    //new ComponentName(this, mClassName), mToken, startId);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.852 -0400", hash_original_method = "12B5F8394AD7AE16AD90C8F95EA27CB9", hash_generated_method = "F89BBD0877BB5172276831781C08AE24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean stopSelfResult(int startId) {
        dsTaint.addTaint(startId);
        try 
        {
            boolean varCE7B9204F75B305989A80280BC281E88_797305280 = (mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId));
        } //End block
        catch (RemoteException ex)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActivityManager == null) {
            //return false;
        //}
        //try {
            //return mActivityManager.stopServiceToken(
                    //new ComponentName(this, mClassName), mToken, startId);
        //} catch (RemoteException ex) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.852 -0400", hash_original_method = "3B13E95A68EC397B0EFBCB7AA4B170BC", hash_generated_method = "82FDA52486A8D7202C21FA56BED80A86")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public final void setForeground(boolean isForeground) {
        dsTaint.addTaint(isForeground);
        // ---------- Original Method ----------
        //Log.w(TAG, "setForeground: ignoring old API call on " + getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.853 -0400", hash_original_method = "4FFCDBDE627194B5F1589AC610EF3404", hash_generated_method = "ADB80685729264E297F96482D2C0A7A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void startForeground(int id, Notification notification) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(notification.dsTaint);
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, id,
                    notification, true);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, id,
                    //notification, true);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.853 -0400", hash_original_method = "4C19D500B60A0A1E30AA501DC977F119", hash_generated_method = "242CD875282225E88A752A0A138C113C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void stopForeground(boolean removeNotification) {
        dsTaint.addTaint(removeNotification);
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, 0, null,
                    removeNotification);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, 0, null,
                    //removeNotification);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.854 -0400", hash_original_method = "708CD3B4DCC4F45281F620E4C375E85F", hash_generated_method = "7C2170951AD07BC3DF60848762CED294")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        writer.println("nothing to dump");
        // ---------- Original Method ----------
        //writer.println("nothing to dump");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.855 -0400", hash_original_method = "9EEE96C6B536EA578538BBE977205B62", hash_generated_method = "4FA6957C30D2F8722104658F232425A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void attach(
            Context context,
            ActivityThread thread, String className, IBinder token,
            Application application, Object activityManager) {
        dsTaint.addTaint(application.dsTaint);
        dsTaint.addTaint(activityManager.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(thread.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(className);
        attachBaseContext(context);
        mActivityManager = (IActivityManager)activityManager;
        mStartCompatibility = getApplicationInfo().targetSdkVersion
                < Build.VERSION_CODES.ECLAIR;
        // ---------- Original Method ----------
        //attachBaseContext(context);
        //mThread = thread;
        //mClassName = className;
        //mToken = token;
        //mApplication = application;
        //mActivityManager = (IActivityManager)activityManager;
        //mStartCompatibility = getApplicationInfo().targetSdkVersion
                //< Build.VERSION_CODES.ECLAIR;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:38.856 -0400", hash_original_method = "8DA57A133C364DA0C4CA877026045103", hash_generated_method = "9A2CDC7DD806C609997C138BCC25F933")
    @DSModeled(DSC.SAFE)
    final String getClassName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    private static final String TAG = "Service";
    public static final int START_CONTINUATION_MASK = 0xf;
    public static final int START_STICKY_COMPATIBILITY = 0;
    public static final int START_STICKY = 1;
    public static final int START_NOT_STICKY = 2;
    public static final int START_REDELIVER_INTENT = 3;
    public static final int START_TASK_REMOVED_COMPLETE = 1000;
    public static final int START_FLAG_REDELIVERY = 0x0001;
    public static final int START_FLAG_RETRY = 0x0002;
}

