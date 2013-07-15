package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:04.999 -0400", hash_original_field = "4637F257714ED0010AAAD4B2D42CA0B5", hash_generated_field = "4DECD94BE6B0174DE36067CBF50C84C9")

    private ActivityThread mThread = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.000 -0400", hash_original_field = "9C9A43E4F7CE518B16A0CE63968FBD24", hash_generated_field = "BE683FA5966EBD9F84092C95A35E6E34")

    private String mClassName = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.000 -0400", hash_original_field = "ED4E44FF349B21B06FEEAE24746F6E3F", hash_generated_field = "DAC5D9DD61EA17334F7C3255730A488C")

    private IBinder mToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.000 -0400", hash_original_field = "0E83E5B4A6743C9CF722DEE507C614EA", hash_generated_field = "4662AB87CC0467DEECD3520FB534F4C7")

    private Application mApplication = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.000 -0400", hash_original_field = "C2CE3B463721CA6F9C1803334A9E5B3F", hash_generated_field = "EC19CF3CBCE73E0074A7B2A120F55C7D")

    private IActivityManager mActivityManager = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.000 -0400", hash_original_field = "D313BB14685A14C8B35EEB59D7673DD6", hash_generated_field = "056DB6B553A04FAC52364200FA203D0E")

    private boolean mStartCompatibility = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.001 -0400", hash_original_method = "D0179C650F036CDA92B50348E0090B82", hash_generated_method = "F9D63210E10597231C4F4BD03B0C29AC")
    public  Service() {
        super(null);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.002 -0400", hash_original_method = "510D23D8CF054FDAE1D1426C6A1A1500", hash_generated_method = "F02D083E9EC9E3F9F5347AA3E9A37215")
    public final Application getApplication() {
Application varF254F0ADF054F0318B65674CA3670A5E_1757843628 =         mApplication;
        varF254F0ADF054F0318B65674CA3670A5E_1757843628.addTaint(taint);
        return varF254F0ADF054F0318B65674CA3670A5E_1757843628;
        // ---------- Original Method ----------
        //return mApplication;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.003 -0400", hash_original_method = "A550D0299CAB894F5185E5356A7BB697", hash_generated_method = "7564C9BAB223A8E7FAC043FBCC648B76")
    public void onCreate() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.004 -0400", hash_original_method = "8DB0845BC67A569482FD95D924F2B38E", hash_generated_method = "971934BB7442F3327C364E7975D13DB5")
    @Deprecated
    public void onStart(Intent intent, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(startId);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.006 -0400", hash_original_method = "C7065D6B9C7065CE68918429E4AC852C", hash_generated_method = "7FBC39536527FD9AB7A7B12E449DDA0E")
    public int onStartCommand(Intent intent, int flags, int startId) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(startId);
        addTaint(flags);
        addTaint(intent.getTaint());
        onStart(intent, startId);
        int var1DF5CB6D30AD18B675A53B382DD16814_1181002469 = (mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003906881 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1003906881;
        // ---------- Original Method ----------
        //onStart(intent, startId);
        //return mStartCompatibility ? START_STICKY_COMPATIBILITY : START_STICKY;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.006 -0400", hash_original_method = "7E0E89252855B3CDBF126F525B8DFC31", hash_generated_method = "E5C4FFF396F837C85A1D40A9B232BFA0")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.007 -0400", hash_original_method = "8287235C28E9D1E310027A2DDEB95FCD", hash_generated_method = "BA7F1E69C22467D62A959775F321C0BA")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.007 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.008 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        // ---------- Original Method ----------
    }

    
    public abstract IBinder onBind(Intent intent);

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.008 -0400", hash_original_method = "5942B5AC8056FD2F0F888A571E85A724", hash_generated_method = "8B0F8908DE5F6296A2E05C1011AEDFE0")
    public boolean onUnbind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1297269147 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_550908499 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_550908499;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.009 -0400", hash_original_method = "96E602EF97C136D1349E20B0217FC297", hash_generated_method = "8F8E56AABCA0613BF8FBF0BDA2865E2C")
    public void onRebind(Intent intent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.009 -0400", hash_original_method = "8FB0E93CA9596F065DFD6DBA45B93821", hash_generated_method = "B691CB7FFACC5EF486F16983D7110EA8")
    public void onTaskRemoved(Intent rootIntent) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(rootIntent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.010 -0400", hash_original_method = "63DABFC9549E2FB476F01FDE2AC0A25B", hash_generated_method = "9C957CF5C3759100051FFDCA4A386C02")
    public final void stopSelf() {
        stopSelf(-1);
        // ---------- Original Method ----------
        //stopSelf(-1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.010 -0400", hash_original_method = "945F4D421616C07D2272A8F5A6D0EDF6", hash_generated_method = "90A2ACABEF9D358251EFBBA296C3DC37")
    public final void stopSelf(int startId) {
        addTaint(startId);
    if(mActivityManager == null)        
        {
            return;
        } //End block
        try 
        {
            mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.012 -0400", hash_original_method = "12B5F8394AD7AE16AD90C8F95EA27CB9", hash_generated_method = "52A94F027219F3B99A2AEFD22DB0716E")
    public final boolean stopSelfResult(int startId) {
        addTaint(startId);
    if(mActivityManager == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1901199571 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1825599471 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1825599471;
        } //End block
        try 
        {
            boolean var5A15ADBAAF6E0EB999554F48783E42C0_619129561 = (mActivityManager.stopServiceToken(
                    new ComponentName(this, mClassName), mToken, startId));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_694398220 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_694398220;
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1195413662 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_548780759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_548780759;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.013 -0400", hash_original_method = "3B13E95A68EC397B0EFBCB7AA4B170BC", hash_generated_method = "6045C21E4FADE12E063F2EF52169C031")
    @Deprecated
    public final void setForeground(boolean isForeground) {
        addTaint(isForeground);
        // ---------- Original Method ----------
        //Log.w(TAG, "setForeground: ignoring old API call on " + getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.015 -0400", hash_original_method = "4FFCDBDE627194B5F1589AC610EF3404", hash_generated_method = "03A8C5528FD4C006792A40884F200753")
    public final void startForeground(int id, Notification notification) {
        addTaint(notification.getTaint());
        addTaint(id);
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, id,
                    notification, true);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, id,
                    //notification, true);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.017 -0400", hash_original_method = "4C19D500B60A0A1E30AA501DC977F119", hash_generated_method = "B8F202C1205AD755C7BB28E97A159E44")
    public final void stopForeground(boolean removeNotification) {
        addTaint(removeNotification);
        try 
        {
            mActivityManager.setServiceForeground(
                    new ComponentName(this, mClassName), mToken, 0, null,
                    removeNotification);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        //try {
            //mActivityManager.setServiceForeground(
                    //new ComponentName(this, mClassName), mToken, 0, null,
                    //removeNotification);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.018 -0400", hash_original_method = "708CD3B4DCC4F45281F620E4C375E85F", hash_generated_method = "F45260AFB3C47FEFA287CAD4B732C9B6")
    protected void dump(FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        writer.println("nothing to dump");
        // ---------- Original Method ----------
        //writer.println("nothing to dump");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.021 -0400", hash_original_method = "9EEE96C6B536EA578538BBE977205B62", hash_generated_method = "55AE90E37C54EA0349E76D75234CC35B")
    public final void attach(
            Context context,
            ActivityThread thread, String className, IBinder token,
            Application application, Object activityManager) {
        addTaint(context.getTaint());
        attachBaseContext(context);
        mThread = thread;
        mClassName = className;
        mToken = token;
        mApplication = application;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.021 -0400", hash_original_method = "8DA57A133C364DA0C4CA877026045103", hash_generated_method = "81E9DBAA0C4DA193D5D54E3971DD9892")
    final String getClassName() {
String varDD9C2143734A2F5CB66BF5CFBE75CE5F_1161159149 =         mClassName;
        varDD9C2143734A2F5CB66BF5CFBE75CE5F_1161159149.addTaint(taint);
        return varDD9C2143734A2F5CB66BF5CFBE75CE5F_1161159149;
        // ---------- Original Method ----------
        //return mClassName;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "A59B3C2E563000CF632F248E775E1904", hash_generated_field = "BCD56721F1394C062DFD537E559B3715")

    private static final String TAG = "Service";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "A7FFE065CC9A3392353ADEFC234DB80E", hash_generated_field = "86EFEF5908B3F0A48EAB2E5148EFD2CE")

    public static final int START_CONTINUATION_MASK = 0xf;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "B482663B18AF5B7CDFC5F414649216FE", hash_generated_field = "6AB8AE8C585B1915F248A48E422129E7")

    public static final int START_STICKY_COMPATIBILITY = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "739F292F3821E9177EB89CEC18B63BE1", hash_generated_field = "C488F1F47EE1B6BEB81C4B247221B19D")

    public static final int START_STICKY = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "25D170F2C83C83DDA900D53916E5AA17", hash_generated_field = "842E5BD5CBB5E2EFE4C7F51F34DD7682")

    public static final int START_NOT_STICKY = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.022 -0400", hash_original_field = "5C814B9861AF6F7E712527533FBAE499", hash_generated_field = "F19A890EE4A2FB7E7378A4C58AC77ECC")

    public static final int START_REDELIVER_INTENT = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.023 -0400", hash_original_field = "A3FF3F746AA9A5546103848F380F9135", hash_generated_field = "FD5FC98B1B2FB67809451B9816107761")

    public static final int START_TASK_REMOVED_COMPLETE = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.023 -0400", hash_original_field = "A41F525E00C4E5BD4E5DD05D948500A2", hash_generated_field = "BAB9A01E808DDE43FF848B5DFA65963D")

    public static final int START_FLAG_REDELIVERY = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:05.023 -0400", hash_original_field = "4209853D508AB854AF214FB3791A38FB", hash_generated_field = "A3148E49A6C6B3EB316E1423172174D4")

    public static final int START_FLAG_RETRY = 0x0002;
}

