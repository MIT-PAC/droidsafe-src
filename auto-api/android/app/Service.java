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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "4637F257714ED0010AAAD4B2D42CA0B5", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "9C9A43E4F7CE518B16A0CE63968FBD24", hash_generated_field = "BE683FA5966EBD9F84092C95A35E6E34")

    private String mClassName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "ED4E44FF349B21B06FEEAE24746F6E3F", hash_generated_field = "DAC5D9DD61EA17334F7C3255730A488C")

    private IBinder mToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "0E83E5B4A6743C9CF722DEE507C614EA", hash_generated_field = "4662AB87CC0467DEECD3520FB534F4C7")

    private Application mApplication = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "C2CE3B463721CA6F9C1803334A9E5B3F", hash_generated_field = "EC19CF3CBCE73E0074A7B2A120F55C7D")

    private IActivityManager mActivityManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.408 -0400", hash_original_field = "D313BB14685A14C8B35EEB59D7673DD6", hash_generated_field = "056DB6B553A04FAC52364200FA203D0E")

    private boolean mStartCompatibility = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.409 -0400", hash_original_method = "D0179C650F036CDA92B50348E0090B82", hash_generated_method = "F9D63210E10597231C4F4BD03B0C29AC")
    public  Service() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.409 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "ABA78E00BDE1A813AFB36FCDDC618343")
    public final Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_151731026 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_151731026 = mApplication;
        varB4EAC82CA7396A68D541C85D26508E83_151731026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_151731026;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.410 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.410 -0400", hash_original_method = "8DB0845BC67A569482FD95D924F2B38E", hash_generated_method = "8219973C28906A5A49CAD34BA7928B86")
    @Deprecated
    public void onStart(Intent intent, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        addTaint(startId);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.411 -0400", hash_original_method = "C7065D6B9C7065CE68918429E4AC852C", hash_generated_method = "F7048F167B9A3691A30213514E25A331")
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        onStart(intent, startId);
        addTaint(intent.getTaint());
        addTaint(flags);
        addTaint(startId);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930359817 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930359817;
        // ---------- Original Method ----------
        //onStart(intent, startId);
        //return mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.411 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.412 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.413 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.413 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    public abstract IBinder onBind(Intent intent);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.414 -0400", hash_original_method = "5942B5AC8056FD2F0F888A571E85A724", hash_generated_method = "7B45D178B7D2B2EB2D46FEDAC3E57C35")
    public boolean onUnbind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1466380638 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1466380638;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.414 -0400", hash_original_method = "96E602EF97C136D1349E20B0217FC297", hash_generated_method = "8F8E56AABCA0613BF8FBF0BDA2865E2C")
    public void onRebind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.415 -0400", hash_original_method = "8FB0E93CA9596F065DFD6DBA45B93821", hash_generated_method = "B691CB7FFACC5EF486F16983D7110EA8")
    public void onTaskRemoved(Intent rootIntent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(rootIntent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.415 -0400", hash_original_method = "63DABFC9549E2FB476F01FDE2AC0A25B", hash_generated_method = "9C957CF5C3759100051FFDCA4A386C02")
    public final void stopSelf() {
        stopSelf(-1);
        // ---------- Original Method ----------
        //stopSelf(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.415 -0400", hash_original_method = "945F4D421616C07D2272A8F5A6D0EDF6", hash_generated_method = "BB688D4B61CB9A4FD52B1F916C693A4F")
    public final void stopSelf(int startId) {
        try 
        {
            mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(startId);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.416 -0400", hash_original_method = "12B5F8394AD7AE16AD90C8F95EA27CB9", hash_generated_method = "93412665711CFD972D994E53BFDF0763")
    public final boolean stopSelfResult(int startId) {
        try 
        {
            boolean varCE7B9204F75B305989A80280BC281E88_227612705 = (mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId));
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(startId);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_846332202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_846332202;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.416 -0400", hash_original_method = "3B13E95A68EC397B0EFBCB7AA4B170BC", hash_generated_method = "6045C21E4FADE12E063F2EF52169C031")
    @Deprecated
    public final void setForeground(boolean isForeground) {
        addTaint(isForeground);
        // ---------- Original Method ----------
        //Log.w(TAG, "setForeground: ignoring old API call on " + getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.417 -0400", hash_original_method = "4FFCDBDE627194B5F1589AC610EF3404", hash_generated_method = "1378635B40CD5AEFB29F9FA198F834BF")
    public final void startForeground(int id, Notification notification) {
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, id,
                    notification, true);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(id);
        addTaint(notification.getTaint());
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, id,
                    //notification, true);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.417 -0400", hash_original_method = "4C19D500B60A0A1E30AA501DC977F119", hash_generated_method = "FE664499487C88B97DE7FF149723A36F")
    public final void stopForeground(boolean removeNotification) {
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, 0, null,
                    removeNotification);
        } //End block
        catch (RemoteException ex)
        { }
        addTaint(removeNotification);
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, 0, null,
                    //removeNotification);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.418 -0400", hash_original_method = "708CD3B4DCC4F45281F620E4C375E85F", hash_generated_method = "EAEE2D67D868F8581157CF1309675359")
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.println("nothing to dump");
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        //writer.println("nothing to dump");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.418 -0400", hash_original_method = "9EEE96C6B536EA578538BBE977205B62", hash_generated_method = "435AE336B063223155D9788AD533C256")
    public final void attach(
            Context context,
            ActivityThread thread, String className, IBinder token,
            Application application, Object activityManager) {
        attachBaseContext(context);
        mThread = thread;
        mClassName = className;
        mToken = token;
        mApplication = application;
        mActivityManager = (IActivityManager)activityManager;
        mStartCompatibility = getApplicationInfo().targetSdkVersion
                < Build.VERSION_CODES.ECLAIR;
        addTaint(context.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_method = "8DA57A133C364DA0C4CA877026045103", hash_generated_method = "7D2BF1D3F312DFA9866A64F49C25013B")
    final String getClassName() {
        String varB4EAC82CA7396A68D541C85D26508E83_877220070 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_877220070 = mClassName;
        varB4EAC82CA7396A68D541C85D26508E83_877220070.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_877220070;
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "A59B3C2E563000CF632F248E775E1904", hash_generated_field = "BCD56721F1394C062DFD537E559B3715")

    private static final String TAG = "Service";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "A7FFE065CC9A3392353ADEFC234DB80E", hash_generated_field = "86EFEF5908B3F0A48EAB2E5148EFD2CE")

    public static final int START_CONTINUATION_MASK = 0xf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "B482663B18AF5B7CDFC5F414649216FE", hash_generated_field = "6AB8AE8C585B1915F248A48E422129E7")

    public static final int START_STICKY_COMPATIBILITY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "739F292F3821E9177EB89CEC18B63BE1", hash_generated_field = "C488F1F47EE1B6BEB81C4B247221B19D")

    public static final int START_STICKY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "25D170F2C83C83DDA900D53916E5AA17", hash_generated_field = "842E5BD5CBB5E2EFE4C7F51F34DD7682")

    public static final int START_NOT_STICKY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "5C814B9861AF6F7E712527533FBAE499", hash_generated_field = "F19A890EE4A2FB7E7378A4C58AC77ECC")

    public static final int START_REDELIVER_INTENT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "A3FF3F746AA9A5546103848F380F9135", hash_generated_field = "FD5FC98B1B2FB67809451B9816107761")

    public static final int START_TASK_REMOVED_COMPLETE = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "A41F525E00C4E5BD4E5DD05D948500A2", hash_generated_field = "BAB9A01E808DDE43FF848B5DFA65963D")

    public static final int START_FLAG_REDELIVERY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:20.419 -0400", hash_original_field = "4209853D508AB854AF214FB3791A38FB", hash_generated_field = "A3148E49A6C6B3EB316E1423172174D4")

    public static final int START_FLAG_RETRY = 0x0002;
}

