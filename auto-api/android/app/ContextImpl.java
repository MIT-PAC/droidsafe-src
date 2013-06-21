package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.policy.PolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IIntentReceiver;
import android.content.IntentSender;
import android.content.ReceiverCallNotAllowedException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.SensorManager;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.ICountryDetector;
import android.location.ILocationManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.IConnectivityManager;
import android.net.INetworkPolicyManager;
import android.net.NetworkPolicyManager;
import android.net.ThrottleManager;
import android.net.IThrottleManager;
import android.net.Uri;
import android.net.wifi.IWifiManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.IWifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.content.ClipboardManager;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.admin.DevicePolicyManager;
import com.android.internal.os.IDropBoxManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

class ReceiverRestrictedContext extends ContextWrapper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.062 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "6D84807CA2A983251270C1CF3BAE889A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReceiverRestrictedContext(Context base) {
        super(base);
        dsTaint.addTaint(base.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.063 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "3134AF761DB01E1CFDABD971DC43EF88")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varD2EEEF37B89DF699D70D46FB84E6D0B0_287060782 = (registerReceiver(receiver, filter, null, null));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.064 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "5872709979E49C16A06E318FBD458DC3")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(broadcastPermission);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to register to receive intents");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.064 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "242D4713C75D6DF228A332359E0CEF8F")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

class ContextImpl extends Context {
    LoadedApk mPackageInfo;
    private String mBasePackageName;
    private Resources mResources;
    ActivityThread mMainThread;
    private Context mOuterContext;
    private IBinder mActivityToken = null;
    private ApplicationContentResolver mContentResolver;
    private int mThemeResource = 0;
    private Resources.Theme mTheme = null;
    private PackageManager mPackageManager;
    private Context mReceiverRestrictedContext = null;
    private boolean mRestricted;
    private Object mSync = new Object();
    private File mDatabasesDir;
    private File mPreferencesDir;
    private File mFilesDir;
    private File mCacheDir;
    private File mObbDir;
    private File mExternalFilesDir;
    private File mExternalCacheDir;
    ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.065 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ContextImpl() {
        mOuterContext = this;
        // ---------- Original Method ----------
        //mOuterContext = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.065 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "B8876EFB74882543D0D6A16C0C7F1868")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContextImpl(ContextImpl context) {
        dsTaint.addTaint(context.dsTaint);
        mPackageInfo = context.mPackageInfo;
        mBasePackageName = context.mBasePackageName;
        mResources = context.mResources;
        mMainThread = context.mMainThread;
        mContentResolver = context.mContentResolver;
        mOuterContext = this;
        // ---------- Original Method ----------
        //mPackageInfo = context.mPackageInfo;
        //mBasePackageName = context.mBasePackageName;
        //mResources = context.mResources;
        //mMainThread = context.mMainThread;
        //mContentResolver = context.mContentResolver;
        //mOuterContext = this;
    }

    
        private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }

    
        static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.066 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "37FC8C702CDC07882CE50D13FB27CAF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AssetManager getAssets() {
        AssetManager varB6DFBCD77C2C4F7B0CFCD6528F08C57D_803532484 = (mResources.getAssets());
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.067 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "6E782E4D717B081FEBED195ECA1E7075")
    @DSModeled(DSC.SAFE)
    @Override
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.068 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "4C54BEA7092ED06CC54DAC4E7F1FC83F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PackageManager getPackageManager() {
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        {
            PackageManager var2E36C3212C56B4F941E42ECF1CA2BB21_369888069 = ((mPackageManager = new ApplicationPackageManager(this, pm)));
        } //End block
        return (PackageManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPackageManager != null) {
            //return mPackageManager;
        //}
        //IPackageManager pm = ActivityThread.getPackageManager();
        //if (pm != null) {
            //return (mPackageManager = new ApplicationPackageManager(this, pm));
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.068 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "9C0ABED848D1B9B8FD20E4A79DE405D6")
    @DSModeled(DSC.SAFE)
    @Override
    public ContentResolver getContentResolver() {
        return (ContentResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.068 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "C3292FC4BF1D602ED95FAF09E20E35B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Looper getMainLooper() {
        Looper var186120EED072CC94A8348DC54F8714EA_1512714720 = (mMainThread.getLooper());
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.069 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "CB96934C0D6FCE7670C3C75853355EDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context getApplicationContext() {
        {
            Object varAC988EF4A3C085BDA5C83C60073FC1BD_15572143 = (mPackageInfo.getApplication());
            Object var060DE32267C16708F07B2689CF684FA3_1616988256 = (mMainThread.getApplication());
        } //End flattened ternary
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.070 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "B02BE616CE899A6C4211C5FDF612E8FF")
    @DSModeled(DSC.SAFE)
    @Override
    public void setTheme(int resid) {
        dsTaint.addTaint(resid);
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.070 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "0C4E45037542F2097B57CEE6AC24E39E")
    @DSModeled(DSC.SAFE)
    @Override
    public int getThemeResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.071 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "EB6F0AB084522C3701C3DA4F58035E02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources.Theme getTheme() {
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } //End block
        return (Resources.Theme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mTheme == null) {
            //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    //getOuterContext().getApplicationInfo().targetSdkVersion);
            //mTheme = mResources.newTheme();
            //mTheme.applyStyle(mThemeResource, true);
        //}
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.071 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "B0E43855C6D70594A82052ED17849C22")
    @DSModeled(DSC.BAN)
    @Override
    public ClassLoader getClassLoader() {
        {
            Object var45D32093CB8C655B0A96BB1300392B3A_1721298375 = (mPackageInfo.getClassLoader());
            Object var1E575F165FAF267D77C5B9C7A4F8B3AA_2115252157 = (ClassLoader.getSystemClassLoader());
        } //End flattened ternary
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.072 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "A917E4FB82E7646322F260B1E65F66C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageName() {
        {
            String varFEB626561E325D76A4BB63D0A0BDBF6D_524965391 = (mPackageInfo.getPackageName());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.074 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "D3B54DECE00D5C612AB98B2F594B2061")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ApplicationInfo getApplicationInfo() {
        {
            ApplicationInfo var6B645DAA9FF4793BD319AC90E86AC344_126650209 = (mPackageInfo.getApplicationInfo());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.075 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "E1EC686FB953E575189F51174212D8D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageResourcePath() {
        {
            String var041E560FDBA108CA79ACB0E1CCD9D504_643095288 = (mPackageInfo.getResDir());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.075 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "112C15B1240312FEB8281DD23B31245F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageCodePath() {
        {
            String varEAF932C4D46101804124EBA08898B22F_83283387 = (mPackageInfo.getAppDir());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.077 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "06EE364501551B01125DF39DDB6596D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getSharedPrefsFile(String name) {
        dsTaint.addTaint(name);
        File var9C75A65C77C38E74778A5AD5E7B63EA4_247996587 = (makeFilename(getPreferencesDir(), name + ".xml"));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.079 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "0F7676CA94A64C984D581D7955CF5B5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        SharedPreferencesImpl sp;
        {
            sp = sSharedPrefs.get(name);
            {
                File prefsFile;
                prefsFile = getSharedPrefsFile(name);
                sp = new SharedPreferencesImpl(prefsFile, mode);
                sSharedPrefs.put(name, sp);
            } //End block
        } //End block
        {
            boolean var2E6124E1185D02CDB2C7C679C6727913_2004995713 = ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB);
            {
                sp.startReloadIfChangedUnexpectedly();
            } //End block
        } //End collapsed parenthetic
        return (SharedPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //SharedPreferencesImpl sp;
        //synchronized (sSharedPrefs) {
            //sp = sSharedPrefs.get(name);
            //if (sp == null) {
                //File prefsFile = getSharedPrefsFile(name);
                //sp = new SharedPreferencesImpl(prefsFile, mode);
                //sSharedPrefs.put(name, sp);
                //return sp;
            //}
        //}
        //if ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            //getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
            //sp.startReloadIfChangedUnexpectedly();
        //}
        //return sp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.080 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "4A22DE8AB0184C993550AA228C9AD3E7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getPreferencesDir() {
        {
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.080 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "D9855309215EF57293E3EDC2F9E95079")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        dsTaint.addTaint(name);
        File f;
        f = makeFilename(getFilesDir(), name);
        FileInputStream var9B8ABC11EA7492469E53849ED556C850_1247959597 = (new FileInputStream(f));
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.081 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "EDEEB47B154CACD1D20EE407FA519B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        boolean append;
        append = (mode&MODE_APPEND) != 0;
        File f;
        f = makeFilename(getFilesDir(), name);
        try 
        {
            FileOutputStream fos;
            fos = new FileOutputStream(f, append);
            setFilePermissionsFromMode(f.getPath(), mode, 0);
        } //End block
        catch (FileNotFoundException e)
        { }
        File parent;
        parent = f.getParentFile();
        parent.mkdir();
        FileUtils.setPermissions(
            parent.getPath(),
            FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
            -1, -1);
        FileOutputStream fos;
        fos = new FileOutputStream(f, append);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final boolean append = (mode&MODE_APPEND) != 0;
        //File f = makeFilename(getFilesDir(), name);
        //try {
            //FileOutputStream fos = new FileOutputStream(f, append);
            //setFilePermissionsFromMode(f.getPath(), mode, 0);
            //return fos;
        //} catch (FileNotFoundException e) {
        //}
        //File parent = f.getParentFile();
        //parent.mkdir();
        //FileUtils.setPermissions(
            //parent.getPath(),
            //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
            //-1, -1);
        //FileOutputStream fos = new FileOutputStream(f, append);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return fos;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.082 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "912D239A24E75B8EB6040A7BBB36D9A2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteFile(String name) {
        dsTaint.addTaint(name);
        File f;
        f = makeFilename(getFilesDir(), name);
        boolean varF551010B15D2D277CEBBB446DD2917F7_1620424718 = (f.delete());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.083 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "D71759D0C711F91B16B804C6A96454EF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFilesDir() {
        {
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } //End block
            {
                boolean var19E4FA9AD9694173D1E5B3B11060E583_1227716847 = (!mFilesDir.exists());
                {
                    {
                        boolean var20989B86B1B7C5B3A21029C102C7B0F0_1985449679 = (!mFilesDir.mkdirs());
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mFilesDir == null) {
                //mFilesDir = new File(getDataDirFile(), "files");
            //}
            //if (!mFilesDir.exists()) {
                //if(!mFilesDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create files directory " + mFilesDir.getPath());
                    //return null;
                //}
                //FileUtils.setPermissions(
                        //mFilesDir.getPath(),
                        //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        //-1, -1);
            //}
            //return mFilesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.083 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "BDC6BB387B1ABE82B11B460E8E23BB21")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getExternalFilesDir(String type) {
        dsTaint.addTaint(type);
        {
            {
                mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(
                        getPackageName());
            } //End block
            {
                boolean varB276A181C4EB3EF93304E7B1C49EFB6B_62622434 = (!mExternalFilesDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean var675269D0F3BF0B3D2DEA41EAF426F526_747726918 = (!mExternalFilesDir.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            File dir;
            dir = new File(mExternalFilesDir, type);
            {
                boolean varFE8E78642ABD38646DA929922A7BF3DC_1658905736 = (!dir.exists());
                {
                    {
                        boolean varCC013DA93565AE954394EDAB638D90F5_86347751 = (!dir.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.084 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "61294C35FFFE2D5031A2F48D843321DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getObbDir() {
        {
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } //End block
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mObbDir == null) {
                //mObbDir = Environment.getExternalStorageAppObbDirectory(
                        //getPackageName());
            //}
            //return mObbDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.085 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "84BF57659F1C61C0C22A19E1F4D58F05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getCacheDir() {
        {
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } //End block
            {
                boolean var2F5430C0F48CD9EE00D803058AB5029F_1034309097 = (!mCacheDir.exists());
                {
                    {
                        boolean var83D0E63134D15DC773688937A5F3BD28_126526396 = (!mCacheDir.mkdirs());
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mCacheDir == null) {
                //mCacheDir = new File(getDataDirFile(), "cache");
            //}
            //if (!mCacheDir.exists()) {
                //if(!mCacheDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create cache directory");
                    //return null;
                //}
                //FileUtils.setPermissions(
                        //mCacheDir.getPath(),
                        //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        //-1, -1);
            //}
        //}
        //return mCacheDir;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.086 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "929FB09BC0CF46CC99950422E0E77AF7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getExternalCacheDir() {
        {
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } //End block
            {
                boolean var00D9D94DA81ED9ECF73133C2FCFD94BC_601898652 = (!mExternalCacheDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean varBF80BF4F4103A772CF6C96028B68472F_1467276085 = (!mExternalCacheDir.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mExternalCacheDir == null) {
                //mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        //getPackageName());
            //}
            //if (!mExternalCacheDir.exists()) {
                //try {
                    //(new File(Environment.getExternalStorageAndroidDataDir(),
                            //".nomedia")).createNewFile();
                //} catch (IOException e) {
                //}
                //if (!mExternalCacheDir.mkdirs()) {
                    //Log.w(TAG, "Unable to create external cache directory");
                    //return null;
                //}
            //}
            //return mExternalCacheDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.086 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "1E6EBD9B0CA18510367E342EF0A4874F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFileStreamPath(String name) {
        dsTaint.addTaint(name);
        File varE53A93B551D5EFAC689F0E45EC61E69F_1379483524 = (makeFilename(getFilesDir(), name));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.087 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "30D1097A36D2208B3945D56E21C0E8DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] fileList() {
        String[] list;
        list = getFilesDir().list();
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //final String[] list = getFilesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.087 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "933DD39D46969ABFE4364D342372BA95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(factory.dsTaint);
        dsTaint.addTaint(mode);
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.089 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "D226EEC40709295CDE94F099E915CCCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(errorHandler.dsTaint);
        dsTaint.addTaint(factory.dsTaint);
        dsTaint.addTaint(mode);
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.090 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "0F9B2D10F552D13B83AC98C52307E941")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteDatabase(String name) {
        dsTaint.addTaint(name);
        try 
        {
            File f;
            f = validateFilePath(name, false);
            boolean varABE1B429208141FF7999C4FBA16347A8_250706380 = (f.delete());
        } //End block
        catch (Exception e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //File f = validateFilePath(name, false);
            //return f.delete();
        //} catch (Exception e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.090 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "565B27C4822AFA493E5DDCB67F351BCA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDatabasePath(String name) {
        dsTaint.addTaint(name);
        File var73F8DB05AAAE71F509023FB2822C8B0C_494391175 = (validateFilePath(name, false));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.091 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "9D8ED20EAAFA9DAFFA5D55F883FA6EA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] databaseList() {
        String[] list;
        list = getDatabasesDir().list();
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //final String[] list = getDatabasesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.091 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "D85CA48CA6C83674596DFF9314D7AE25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getDatabasesDir() {
        {
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
            {
                boolean var0314E0B292381BE9F1623149CD8F8489_1516368919 = (mDatabasesDir.getPath().equals("databases"));
                {
                    mDatabasesDir = new File("/data/system");
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mDatabasesDir == null) {
                //mDatabasesDir = new File(getDataDirFile(), "databases");
            //}
            //if (mDatabasesDir.getPath().equals("databases")) {
                //mDatabasesDir = new File("/data/system");
            //}
            //return mDatabasesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.092 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "17C8D534CA454656D33D406BBEE6315A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getWallpaper() {
        Drawable varED23506173B42870BCEF9B102F0A2E7A_1531584698 = (getWallpaperManager().getDrawable());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.092 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "B15ECB601B9509A9E3A2B324E59342DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable peekWallpaper() {
        Drawable var0794F6EA267AE86382B38F9AE0A69F72_805010654 = (getWallpaperManager().peekDrawable());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.093 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "4D8B3BDF1D1800CF410D80068D162739")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varC254F548CFAB2206D8996DEF871ED770_1626743385 = (getWallpaperManager().getDesiredMinimumWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.093 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "8A3D23EB52B3A6A42A3817AB97CB4E3F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var0CAE8BF1444C70E01A3CB5415A62929F_1631126132 = (getWallpaperManager().getDesiredMinimumHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.094 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "4EBB5E9911C53D9F0DD14019F4CAB3F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        dsTaint.addTaint(bitmap.dsTaint);
        getWallpaperManager().setBitmap(bitmap);
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.094 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "4B83C10DBA4AFC0D2E28D2BB885C0546")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        dsTaint.addTaint(data.dsTaint);
        getWallpaperManager().setStream(data);
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.095 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.097 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "7EAC563596EEA5F2FF40579537E15CD1")
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            boolean var4E2CEB5436A3062C8E21590CE555C7F9_931775350 = ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException(
                    "Calling startActivity() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    + " Is this really what you want?");
            } //End block
        } //End collapsed parenthetic
        mMainThread.getInstrumentation().execStartActivity(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intent, -1);
        // ---------- Original Method ----------
        //if ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0) {
            //throw new AndroidRuntimeException(
                    //"Calling startActivity() from outside of an Activity "
                    //+ " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    //+ " Is this really what you want?");
        //}
        //mMainThread.getInstrumentation().execStartActivity(
            //getOuterContext(), mMainThread.getApplicationThread(), null,
            //(Activity)null, intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.098 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "A1BB8E1B434820F00A99197D2688B466")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startActivities(Intent[] intents) {
        dsTaint.addTaint(intents[0].dsTaint);
        {
            boolean varB54A748E26DA9CF993CAE37B6D958C5E_1387221996 = ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException(
                    "Calling startActivities() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    + " Is this really what you want?");
            } //End block
        } //End collapsed parenthetic
        mMainThread.getInstrumentation().execStartActivities(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intents);
        // ---------- Original Method ----------
        //if ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0) {
            //throw new AndroidRuntimeException(
                    //"Calling startActivities() from outside of an Activity "
                    //+ " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    //+ " Is this really what you want?");
        //}
        //mMainThread.getInstrumentation().execStartActivities(
            //getOuterContext(), mMainThread.getApplicationThread(), null,
            //(Activity)null, intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.098 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "BAB8BBE7C83A537755037F298F9E6C43")
    @DSModeled(DSC.SPEC)
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(fillInIntent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        try 
        {
            String resolvedType;
            resolvedType = null;
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } //End block
            int result;
            result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, null, null,
                        0, flagsMask, flagsValues);
            {
                if (DroidSafeAndroidRuntime.control) throw new IntentSender.SendIntentException();
            } //End block
            Instrumentation.checkStartActivityResult(result, null);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //String resolvedType = null;
            //if (fillInIntent != null) {
                //fillInIntent.setAllowFds(false);
                //resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            //}
            //int result = ActivityManagerNative.getDefault()
                //.startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        //fillInIntent, resolvedType, null, null,
                        //0, flagsMask, flagsValues);
            //if (result == IActivityManager.START_CANCELED) {
                //throw new IntentSender.SendIntentException();
            //}
            //Instrumentation.checkStartActivityResult(result, null);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.099 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "A3C9D7D9DFEBEA432E4469FA8D5E495C")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, false);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, null, false, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.099 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "4A311230230DAAC26388526FEFC97F0A")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(intent.dsTaint);
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, false, false);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, receiverPermission, false, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.100 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "E454608CA85A2E91C460BB2969303790")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(intent.dsTaint);
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, true, false);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, receiverPermission, true, false);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.101 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "17D64AC8148E5BFF57368DD336B56C28")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(initialExtras.dsTaint);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(initialCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialData);
        IIntentReceiver rd;
        rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } //End block
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } //End block
        } //End block
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, receiverPermission,
                true, false);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.103 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "67D2D8370CB12234D9E5288249EF271B")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, true);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().broadcastIntent(
                //mMainThread.getApplicationThread(), intent, resolvedType, null,
                //Activity.RESULT_OK, null, null, null, false, true);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.105 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "9A77FBE7B5FC66D653E4D4679F1965E9")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(initialExtras.dsTaint);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(initialCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialData);
        IIntentReceiver rd;
        rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } //End block
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } //End block
        } //End block
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, null,
                true, true);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.106 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "B6D06653583FE0CE5CF78C22847C5F8F")
    @DSModeled(DSC.SPEC)
    @Override
    public void removeStickyBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        String resolvedType;
        resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        {
            intent = new Intent(intent);
            intent.setDataAndType(intent.getData(), resolvedType);
        } //End block
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().unbroadcastIntent(
                mMainThread.getApplicationThread(), intent);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        //if (resolvedType != null) {
            //intent = new Intent(intent);
            //intent.setDataAndType(intent.getData(), resolvedType);
        //}
        //try {
            //intent.setAllowFds(false);
            //ActivityManagerNative.getDefault().unbroadcastIntent(
                //mMainThread.getApplicationThread(), intent);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.106 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "B0D66A1F8D6C5ACA87FB93D4D09B3AC1")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varD2EEEF37B89DF699D70D46FB84E6D0B0_1188157514 = (registerReceiver(receiver, filter, null, null));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.107 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "3A911E7EB582E8937C2CD96339D52FA8")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(broadcastPermission);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varB46B2452541EDAE8CFF73321541FA200_324390041 = (registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext()));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.108 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "B351E4396B1B8DCF450855C4C46C78EF")
    @DSModeled(DSC.SPEC)
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        dsTaint.addTaint(broadcastPermission);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        IIntentReceiver rd;
        rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    receiver, context, scheduler,
                    mMainThread.getInstrumentation(), true);
            } //End block
            {
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        receiver, context, scheduler, null, true).getIIntentReceiver();
            } //End block
        } //End block
        try 
        {
            Intent var23EE3E70126311750C0EF52FA1B4011A_2130809082 = (ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission));
        } //End block
        catch (RemoteException e)
        { }
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.108 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "A71D2DE2A44314FAEECC44B1B0D63A5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        dsTaint.addTaint(receiver.dsTaint);
        {
            IIntentReceiver rd;
            rd = mPackageInfo.forgetReceiverDispatcher(
                    getOuterContext(), receiver);
            try 
            {
                ActivityManagerNative.getDefault().unregisterReceiver(rd);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } //End block
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //IIntentReceiver rd = mPackageInfo.forgetReceiverDispatcher(
                    //getOuterContext(), receiver);
            //try {
                //ActivityManagerNative.getDefault().unregisterReceiver(rd);
            //} catch (RemoteException e) {
            //}
        //} else {
            //throw new RuntimeException("Not supported in system context");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.109 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "A5A5F7613E4885C1154C16E15DE6AB04")
    @DSModeled(DSC.SPEC)
    @Override
    public ComponentName startService(Intent service) {
        dsTaint.addTaint(service.dsTaint);
        try 
        {
            service.setAllowFds(false);
            ComponentName cn;
            cn = ActivityManagerNative.getDefault().startService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                boolean varD9D164FC49919222E3F05E39BAD0AAA7_2104599671 = (cn != null && cn.getPackageName().equals("!"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (RemoteException e)
        { }
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //service.setAllowFds(false);
            //ComponentName cn = ActivityManagerNative.getDefault().startService(
                //mMainThread.getApplicationThread(), service,
                //service.resolveTypeIfNeeded(getContentResolver()));
            //if (cn != null && cn.getPackageName().equals("!")) {
                //throw new SecurityException(
                        //"Not allowed to start service " + service
                        //+ " without permission " + cn.getClassName());
            //}
            //return cn;
        //} catch (RemoteException e) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.110 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "7B063869827FB13E7496367C370313E9")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean stopService(Intent service) {
        dsTaint.addTaint(service.dsTaint);
        try 
        {
            service.setAllowFds(false);
            int res;
            res = ActivityManagerNative.getDefault().stopService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to stop service " + service);
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //service.setAllowFds(false);
            //int res = ActivityManagerNative.getDefault().stopService(
                //mMainThread.getApplicationThread(), service,
                //service.resolveTypeIfNeeded(getContentResolver()));
            //if (res < 0) {
                //throw new SecurityException(
                        //"Not allowed to stop service " + service);
            //}
            //return res != 0;
        //} catch (RemoteException e) {
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.110 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "70FBBD974A7B835A57FF31DB01A4C41B")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        IServiceConnection sd;
        {
            sd = mPackageInfo.getServiceDispatcher(conn, getOuterContext(),
                    mMainThread.getHandler(), flags);
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } //End block
        try 
        {
            IBinder token;
            token = getActivityToken();
            {
                boolean var6493BF3E84461910769ACF3C960C9AA7_523206012 = (token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
                    && mPackageInfo.getApplicationInfo().targetSdkVersion
                    < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH);
                {
                    flags |= BIND_WAIVE_PRIORITY;
                } //End block
            } //End collapsed parenthetic
            service.setAllowFds(false);
            int res;
            res = ActivityManagerNative.getDefault().bindService(
                mMainThread.getApplicationThread(), getActivityToken(),
                service, service.resolveTypeIfNeeded(getContentResolver()),
                sd, flags);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to bind to service " + service);
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.111 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "DA5FD6B35FD30D105736A2A7E2E41724")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unbindService(ServiceConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        {
            IServiceConnection sd;
            sd = mPackageInfo.forgetServiceDispatcher(
                    getOuterContext(), conn);
            try 
            {
                ActivityManagerNative.getDefault().unbindService(sd);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } //End block
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //IServiceConnection sd = mPackageInfo.forgetServiceDispatcher(
                    //getOuterContext(), conn);
            //try {
                //ActivityManagerNative.getDefault().unbindService(sd);
            //} catch (RemoteException e) {
            //}
        //} else {
            //throw new RuntimeException("Not supported in system context");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.112 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "561E8BA007FA88DEC07DB1DB1AB75A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        dsTaint.addTaint(arguments.dsTaint);
        dsTaint.addTaint(className.dsTaint);
        dsTaint.addTaint(profileFile);
        try 
        {
            {
                arguments.setAllowFds(false);
            } //End block
            boolean varFB737B53559144BA0BD1ED3EEC743D0D_949852774 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //try {
            //if (arguments != null) {
                //arguments.setAllowFds(false);
            //}
            //return ActivityManagerNative.getDefault().startInstrumentation(
                    //className, profileFile, 0, arguments, null);
        //} catch (RemoteException e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.112 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "43C4AFC2CCFE0E4C4D32AD75C08561A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getSystemService(String name) {
        dsTaint.addTaint(name);
        ServiceFetcher fetcher;
        fetcher = SYSTEM_SERVICE_MAP.get(name);
        {
            Object var995AD4350C7C2586B3B7EFD724D8959C_731107057 = (fetcher.getService(this));
        } //End flattened ternary
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.113 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "0F306113F9ACC29572731CDA22538909")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WallpaperManager getWallpaperManager() {
        WallpaperManager var890880107DD63A7285681E1C2F1F1039_56399863 = ((WallpaperManager) WALLPAPER_FETCHER.getService(this));
        return (WallpaperManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
    }

    
        static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            return null;
        }
        return new DropBoxManager(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.114 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "C79C8E89CD13A77043711279FF15870B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(permission);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        try 
        {
            int var5F40A2437A077EA5C807226D389206D0_888487594 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //try {
            //return ActivityManagerNative.getDefault().checkPermission(
                    //permission, pid, uid);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.114 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "38E91899A01141FFBFD46DC31120B78A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkCallingPermission(String permission) {
        dsTaint.addTaint(permission);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_14753155 = (pid != Process.myPid());
            {
                int var78028F3F1C255CC480151714E778C1C5_1319600343 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkPermission(permission, pid,
                    //Binder.getCallingUid());
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.115 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "0C234BF9258B34531A990DF5FE70DE46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        dsTaint.addTaint(permission);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int var34AB0D6CBBDC631C7FDA58F28B1B657C_1455218335 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.115 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "61E3C3A3E05453E82090FD13CD58C013")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(selfToo);
        dsTaint.addTaint(resultOfCheck);
        dsTaint.addTaint(permission);
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
        } //End block
        // ---------- Original Method ----------
        //if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //(message != null ? (message + ": ") : "") +
                    //(selfToo
                     //? "Neither user " + uid + " nor current process has "
                     //: "User " + uid + " does not have ") +
                    //permission +
                    //".");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.116 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "84FA86E83BB3D78B01C8F64755185C37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(permission);
        enforce(permission,
                checkPermission(permission, pid, uid),
                false,
                uid,
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkPermission(permission, pid, uid),
                //false,
                //uid,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.117 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "6047657BF90E9A1CA29F178422214903")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enforceCallingPermission(String permission, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(permission);
        enforce(permission,
                checkCallingPermission(permission),
                false,
                Binder.getCallingUid(),
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingPermission(permission),
                //false,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.117 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "E2665065E0811A0E573045E9994EA65E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(permission);
        enforce(permission,
                checkCallingOrSelfPermission(permission),
                true,
                Binder.getCallingUid(),
                message);
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingOrSelfPermission(permission),
                //true,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.118 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "47CA3303141E592A89218B3E5377A136")
    @DSModeled(DSC.SPEC)
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(toPackage);
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            ActivityManagerNative.getDefault().grantUriPermission(
                    mMainThread.getApplicationThread(), toPackage, uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().grantUriPermission(
                    //mMainThread.getApplicationThread(), toPackage, uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.118 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "2766CE8A52874B52E3E0FC94A5B2CB09")
    @DSModeled(DSC.SPEC)
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            ActivityManagerNative.getDefault().revokeUriPermission(
                    mMainThread.getApplicationThread(), uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().revokeUriPermission(
                    //mMainThread.getApplicationThread(), uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.119 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "3CEAB7BEF275332D6D6987211C0E7E26")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            int var059CF890EB6981028B04E841A7699518_375695371 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
        } //End block
        catch (RemoteException e)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().checkUriPermission(
                    //uri, pid, uid, modeFlags);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.122 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "6A316498BBA9E56F1B4D7420626B6FBF")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_1006152842 = (pid != Process.myPid());
            {
                int varD7B1B302EF0CA5C388B6F3983890986E_346689287 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkUriPermission(uri, pid,
                    //Binder.getCallingUid(), modeFlags);
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.123 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "879EFBEC77B2D74A55A53B23D47A78D4")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int var41FF907064E7DF4DF0C5983F95FA5974_1548768728 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.124 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "DBD48CC16E2197775A17780008ABEA9F")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(uri.dsTaint);
        {
            {
                boolean var7E999FB94CB59BF987157589269CB69E_1678350619 = (readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBDC2A19824C9195EFA4716604E7FC089_210948117 = (writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            Object var486C2278A32794206F2AEE849917E1AC_25999370 = (checkUriPermission(uri, pid, uid, modeFlags));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.124 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "C816BAE4525C80721436F723B0CE2297")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String uriModeFlagToString(int uriModeFlags) {
        dsTaint.addTaint(uriModeFlags);
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //switch (uriModeFlags) {
            //case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    //Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                //return "read and write";
            //case Intent.FLAG_GRANT_READ_URI_PERMISSION:
                //return "read";
            //case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                //return "write";
        //}
        //throw new IllegalArgumentException(
                //"Unknown permission mode flags: " + uriModeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.125 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "7817DB05229C3AAE94821C65EE5C5C25")
    @DSModeled(DSC.SPEC)
    private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(selfToo);
        dsTaint.addTaint(resultOfCheck);
        dsTaint.addTaint(uri.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    uriModeFlagToString(modeFlags) +
                    " permission on " +
                    uri +
                    ".");
        } //End block
        // ---------- Original Method ----------
        //if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            //throw new SecurityException(
                    //(message != null ? (message + ": ") : "") +
                    //(selfToo
                     //? "Neither user " + uid + " nor current process has "
                     //: "User " + uid + " does not have ") +
                    //uriModeFlagToString(modeFlags) +
                    //" permission on " +
                    //uri +
                    //".");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.125 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "00897D61874341F78C82BE088DDECE4E")
    @DSModeled(DSC.SPEC)
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        enforceForUri(
                modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                false, uid, uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                //false, uid, uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.126 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "EC63D41C2F430C7905B9957A62604F8C")
    @DSModeled(DSC.SPEC)
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        enforceForUri(
                modeFlags, checkCallingUriPermission(uri, modeFlags),
                false, Binder.getCallingUid(), uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkCallingUriPermission(uri, modeFlags),
                //false, Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.126 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "6172A19CE334DEABD9EEE2E224881DB4")
    @DSModeled(DSC.SPEC)
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        enforceForUri(
                modeFlags,
                checkCallingOrSelfUriPermission(uri, modeFlags), true,
                Binder.getCallingUid(), uri, message);
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags,
                //checkCallingOrSelfUriPermission(uri, modeFlags), true,
                //Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.127 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "2A2063256D52F0367B72427A70FAA963")
    @DSModeled(DSC.SPEC)
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(uri.dsTaint);
        enforceForUri(modeFlags,
                      checkUriPermission(
                              uri, readPermission, writePermission, pid, uid,
                              modeFlags),
                      false,
                      uid,
                      uri,
                      message);
        // ---------- Original Method ----------
        //enforceForUri(modeFlags,
                      //checkUriPermission(
                              //uri, readPermission, writePermission, pid, uid,
                              //modeFlags),
                      //false,
                      //uid,
                      //uri,
                      //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.128 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "66027673B1BE574671C17389015D4CDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        {
            boolean varC1F5D449E2D7CC78DA5400BABA02C561_1466319870 = (packageName.equals("system") || packageName.equals("android"));
            {
                Context var9AE43F778E42390ABA3A5C32567757B7_745471993 = (new ContextImpl(mMainThread.getSystemContext()));
            } //End block
        } //End collapsed parenthetic
        LoadedApk pi;
        pi = mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        {
            ContextImpl c;
            c = new ContextImpl();
            c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            c.init(pi, null, mMainThread, mResources, mBasePackageName);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (packageName.equals("system") || packageName.equals("android")) {
            //return new ContextImpl(mMainThread.getSystemContext());
        //}
        //LoadedApk pi =
            //mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        //if (pi != null) {
            //ContextImpl c = new ContextImpl();
            //c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            //c.init(pi, null, mMainThread, mResources, mBasePackageName);
            //if (c.mResources != null) {
                //return c;
            //}
        //}
        //throw new PackageManager.NameNotFoundException(
            //"Application package " + packageName + " not found");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.128 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "FD4333A7AF5AE10A2E798D26424D323D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.129 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "CB25EDE90CDFC0167E9A72AD85ED37F9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getDataDirFile() {
        {
            File varEA43519865B1954F413512FF7802FE76_1719114287 = (mPackageInfo.getDataDirFile());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.130 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "D7C84F6E615918CB6CF9B2FA40EEA176")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDir(String name, int mode) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        name = "app_" + name;
        File file;
        file = makeFilename(getDataDirFile(), name);
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_1570653263 = (!file.exists());
            {
                file.mkdir();
                setFilePermissionsFromMode(file.getPath(), mode,
                    FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
            } //End block
        } //End collapsed parenthetic
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //name = "app_" + name;
        //File file = makeFilename(getDataDirFile(), name);
        //if (!file.exists()) {
            //file.mkdir();
            //setFilePermissionsFromMode(file.getPath(), mode,
                    //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
        //}
        //return file;
    }

    
        static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.131 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "D2BE4CA03DEF9336A4C54FA7B9E17A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        dsTaint.addTaint(activityToken.dsTaint);
        dsTaint.addTaint(packageInfo.dsTaint);
        dsTaint.addTaint(mainThread.dsTaint);
        init(packageInfo, activityToken, mainThread, null, null);
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.132 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "12C5286E4773DBEF992EE0536BECD0F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        dsTaint.addTaint(basePackageName);
        dsTaint.addTaint(container.dsTaint);
        dsTaint.addTaint(activityToken.dsTaint);
        dsTaint.addTaint(packageInfo.dsTaint);
        dsTaint.addTaint(mainThread.dsTaint);
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        {
            boolean var104A93987C9CA0B1B66503A62E5FEA6A_1039593507 = (mResources != null && container != null
                && container.getCompatibilityInfo().applicationScale !=
                        mResources.getCompatibilityInfo().applicationScale);
            {
                {
                    Log.d(TAG, "loaded context has different scaling. Using container's" +
                        " compatiblity info:" + container.getDisplayMetrics());
                } //End block
                mResources = mainThread.getTopLevelResources(
                    mPackageInfo.getResDir(), container.getCompatibilityInfo());
            } //End block
        } //End collapsed parenthetic
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        setActivityToken(activityToken);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.132 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "C34C70B0A78EAC086CB3D15FDE6436F5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void init(Resources resources, ActivityThread mainThread) {
        dsTaint.addTaint(resources.dsTaint);
        dsTaint.addTaint(mainThread.dsTaint);
        mPackageInfo = null;
        mBasePackageName = null;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        // ---------- Original Method ----------
        //mPackageInfo = null;
        //mBasePackageName = null;
        //mResources = resources;
        //mMainThread = mainThread;
        //mContentResolver = new ApplicationContentResolver(this, mainThread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.133 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "2ED558B21D22BA4EA14F0B61A7E409AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void scheduleFinalCleanup(String who, String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(who);
        mMainThread.scheduleContextCleanup(this, who, what);
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.133 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "CE618D18E5339FD5FE15427262203C4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performFinalCleanup(String who, String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(who);
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.134 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "81A71B2DCAA1F16E9EFBDA7085E36CD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Context getReceiverRestrictedContext() {
        Context varBE6B7DA71053E98F6FBFC9411DC0F487_1777526359 = (mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext()));
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.135 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "5377F06078580E5872CE63BD1BE4F1C9")
    @DSModeled(DSC.SAFE)
    final void setActivityToken(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.136 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "3DB06044A8D31A04E5C3046F1C12B67C")
    @DSModeled(DSC.SAFE)
    final void setOuterContext(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.137 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "B7F295163B50FE986ADEBCAF516DCDA4")
    @DSModeled(DSC.SAFE)
    final Context getOuterContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.139 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "610B1E8B888F86937EB1EF7004FAC65E")
    @DSModeled(DSC.SAFE)
    final IBinder getActivityToken() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivityToken;
    }

    
        static void setFilePermissionsFromMode(String name, int mode,
            int extraPermissions) {
        int perms = FileUtils.S_IRUSR|FileUtils.S_IWUSR
            |FileUtils.S_IRGRP|FileUtils.S_IWGRP
            |extraPermissions;
        if ((mode&MODE_WORLD_READABLE) != 0) {
            perms |= FileUtils.S_IROTH;
        }
        if ((mode&MODE_WORLD_WRITEABLE) != 0) {
            perms |= FileUtils.S_IWOTH;
        }
        if (DEBUG) {
            Log.i(TAG, "File " + name + ": mode=0x" + Integer.toHexString(mode)
                  + ", perms=0x" + Integer.toHexString(perms));
        }
        FileUtils.setPermissions(name, perms, -1, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.140 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "E9D58910ADC190AD25EFB660B09DF0FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File validateFilePath(String name, boolean createDirectory) {
        dsTaint.addTaint(createDirectory);
        dsTaint.addTaint(name);
        File dir;
        File f;
        {
            boolean varFD0C1196C407A4234C7FE0E19F1943FE_1119290254 = (name.charAt(0) == File.separatorChar);
            {
                String dirPath;
                dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
                dir = new File(dirPath);
                name = name.substring(name.lastIndexOf(File.separatorChar));
                f = new File(dir, name);
            } //End block
            {
                dir = getDatabasesDir();
                f = makeFilename(dir, name);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var3499179EFDC7A0451D45EF9132D21A84_1007640783 = (createDirectory && !dir.isDirectory() && dir.mkdir());
            {
                FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            } //End block
        } //End collapsed parenthetic
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File dir;
        //File f;
        //if (name.charAt(0) == File.separatorChar) {
            //String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
            //dir = new File(dirPath);
            //name = name.substring(name.lastIndexOf(File.separatorChar));
            //f = new File(dir, name);
        //} else {
            //dir = getDatabasesDir();
            //f = makeFilename(dir, name);
        //}
        //if (createDirectory && !dir.isDirectory() && dir.mkdir()) {
            //FileUtils.setPermissions(dir.getPath(),
                //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                //-1, -1);
        //}
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.141 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "E02DF0B78B00079C4128CE720A349E3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File makeFilename(File base, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(base.dsTaint);
        {
            boolean varE9928D58DBE793633CB7E7D7D5D3D217_246687890 = (name.indexOf(File.separatorChar) < 0);
            {
                File var1141959ED30920B0C5CD3C04AC4AF093_215815315 = (new File(base, name));
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "File " + name + " contains a path separator");
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.141 -0400", hash_original_method = "F671C93322E8A7C7EF41B34D85A97E4B", hash_generated_method = "F671C93322E8A7C7EF41B34D85A97E4B")
                public ServiceFetcher ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.142 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "0A95F35762D82E94A91FF36B235F393E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getService(ContextImpl ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            ArrayList<Object> cache;
            cache = ctx.mServiceCache;
            Object service;
            {
                {
                    boolean var64657C48B0EB7731DEDFDF761A102E58_634224040 = (cache.size() == 0);
                    {
                        {
                            int i;
                            i = 0;
                            {
                                cache.add(null);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        service = cache.get(mContextCacheIndex);
                    } //End block
                } //End collapsed parenthetic
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
            } //End block
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //ArrayList<Object> cache = ctx.mServiceCache;
            //Object service;
            //synchronized (cache) {
                //if (cache.size() == 0) {
                    //for (int i = 0; i < sNextPerContextServiceCacheIndex; i++) {
                        //cache.add(null);
                    //}
                //} else {
                    //service = cache.get(mContextCacheIndex);
                    //if (service != null) {
                        //return service;
                    //}
                //}
                //service = createService(ctx);
                //cache.set(mContextCacheIndex, service);
                //return service;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.142 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "7ADAEC94760D98075148B842E2D872E6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object createService(ContextImpl ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not implemented");
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.142 -0400", hash_original_method = "BCF107FC6A9A40800F7729B4F834D620", hash_generated_method = "BCF107FC6A9A40800F7729B4F834D620")
                public StaticServiceFetcher ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.143 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "8322DBE5835E1130967CD33E761594FC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final Object getService(ContextImpl unused) {
            dsTaint.addTaint(unused.dsTaint);
            {
                Object var2F175684CDE577660B1158202078FB8E_1660528804 = (StaticServiceFetcher.this);
                {
                    Object service;
                    service = mCachedInstance;
                    Object var8559050D8448FFE866E0540EBADC4392_996088398 = (mCachedInstance = createStaticService());
                } //End block
            } //End collapsed parenthetic
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //synchronized (StaticServiceFetcher.this) {
                //Object service = mCachedInstance;
                //if (service != null) {
                    //return service;
                //}
                //return mCachedInstance = createStaticService();
            //}
        }

        
        public abstract Object createStaticService();

        
    }


    
    private static final class ApplicationContentResolver extends ContentResolver {
        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.144 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "AF3EBD5593271CFCD59E9AD158DF76FA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(mainThread.dsTaint);
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.144 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "66FEF1E44A2768E411D602613348151E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            IContentProvider var6E14F0B8C03ACF51979B6097CA57898D_433725100 = (mMainThread.acquireProvider(context, name));
            return (IContentProvider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.145 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "588F86CACBB8A93F26177550DD50C1D2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            IContentProvider var03A605DA0D1D5DF30FE0C22F77097ABF_1689657408 = (mMainThread.acquireExistingProvider(context, name));
            return (IContentProvider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.145 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "EBF9E554E284FB229F7E4A604C01A928")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            dsTaint.addTaint(provider.dsTaint);
            boolean var38B4042628FFD57CF97DF331208B6769_511579046 = (mMainThread.releaseProvider(provider));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    private final static String TAG = "ApplicationContext";
    private final static boolean DEBUG = false;
    private static final HashMap<String, SharedPreferencesImpl> sSharedPrefs =
            new HashMap<String, SharedPreferencesImpl>();
    private static final String[] EMPTY_FILE_LIST = {};
    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP =
            new HashMap<String, ServiceFetcher>();
    private static int sNextPerContextServiceCacheIndex = 0;
    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.146 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "69C9B7A6C78EF4D3CB02312965E0552B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object createService(ContextImpl ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            Object varCF6F7E63ED3DC13E313599E9A85ACDED_1534159025 = (new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WallpaperManager(ctx.getOuterContext(),
                        //ctx.mMainThread.getHandler());
        }

        
}; //Transformed anonymous class
    static {
        registerService(ACCESSIBILITY_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return AccessibilityManager.getInstance(ctx);
                }});
        registerService(ACCOUNT_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(ACCOUNT_SERVICE);
                    IAccountManager service = IAccountManager.Stub.asInterface(b);
                    return new AccountManager(ctx, service);
                }});
        registerService(ACTIVITY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new ActivityManager(ctx.getOuterContext(), ctx.mMainThread.getHandler());
                }});
        registerService(ALARM_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(ALARM_SERVICE);
                    IAlarmManager service = IAlarmManager.Stub.asInterface(b);
                    return new AlarmManager(service);
                }});
        registerService(AUDIO_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new AudioManager(ctx);
                }});
        registerService(CLIPBOARD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new ClipboardManager(ctx.getOuterContext(),
                            ctx.mMainThread.getHandler());
                }});
        registerService(CONNECTIVITY_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(CONNECTIVITY_SERVICE);
                    return new ConnectivityManager(IConnectivityManager.Stub.asInterface(b));
                }});
        registerService(COUNTRY_DETECTOR, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(COUNTRY_DETECTOR);
                    return new CountryDetector(ICountryDetector.Stub.asInterface(b));
                }});
        registerService(DEVICE_POLICY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return DevicePolicyManager.create(ctx, ctx.mMainThread.getHandler());
                }});
        registerService(DOWNLOAD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new DownloadManager(ctx.getContentResolver(), ctx.getPackageName());
                }});
        registerService(NFC_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new NfcManager(ctx);
                }});
        registerService(DROPBOX_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    return createDropBoxManager();
                }});
        registerService(INPUT_METHOD_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return InputMethodManager.getInstance(ctx);
                }});
        registerService(TEXT_SERVICES_MANAGER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return TextServicesManager.getInstance();
                }});
        registerService(KEYGUARD_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return new KeyguardManager();
                }});
        registerService(LAYOUT_INFLATER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return PolicyManager.makeNewLayoutInflater(ctx.getOuterContext());
                }});
        registerService(LOCATION_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(LOCATION_SERVICE);
                    return new LocationManager(ILocationManager.Stub.asInterface(b));
                }});
        registerService(NETWORK_POLICY_SERVICE, new ServiceFetcher() {
            @Override
            public Object createService(ContextImpl ctx) {
                return new NetworkPolicyManager(INetworkPolicyManager.Stub.asInterface(
                        ServiceManager.getService(NETWORK_POLICY_SERVICE)));
            }
        });
        registerService(NOTIFICATION_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    final Context outerContext = ctx.getOuterContext();
                    return new NotificationManager(
                        new ContextThemeWrapper(outerContext,
                                Resources.selectSystemTheme(0,
                                        outerContext.getApplicationInfo().targetSdkVersion,
                                        com.android.internal.R.style.Theme_Dialog,
                                        com.android.internal.R.style.Theme_Holo_Dialog,
                                        com.android.internal.R.style.Theme_DeviceDefault_Dialog)),
                        ctx.mMainThread.getHandler());
                }});
        registerService(POWER_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(POWER_SERVICE);
                    IPowerManager service = IPowerManager.Stub.asInterface(b);
                    return new PowerManager(service, ctx.mMainThread.getHandler());
                }});
        registerService(SEARCH_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new SearchManager(ctx.getOuterContext(),
                            ctx.mMainThread.getHandler());
                }});
        registerService(SENSOR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new SensorManager(ctx.mMainThread.getHandler().getLooper());
                }});
        registerService(STATUS_BAR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new StatusBarManager(ctx.getOuterContext());
                }});
        registerService(STORAGE_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    try {
                        return new StorageManager(ctx.mMainThread.getHandler().getLooper());
                    } catch (RemoteException rex) {
                        Log.e(TAG, "Failed to create StorageManager", rex);
                        return null;
                    }
                }});
        registerService(TELEPHONY_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new TelephonyManager(ctx.getOuterContext());
                }});
        registerService(THROTTLE_SERVICE, new StaticServiceFetcher() {
                public Object createStaticService() {
                    IBinder b = ServiceManager.getService(THROTTLE_SERVICE);
                    return new ThrottleManager(IThrottleManager.Stub.asInterface(b));
                }});
        registerService(UI_MODE_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new UiModeManager();
                }});
        registerService(USB_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(USB_SERVICE);
                    return new UsbManager(ctx, IUsbManager.Stub.asInterface(b));
                }});
        registerService(VIBRATOR_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    return new Vibrator();
                }});
        registerService(WALLPAPER_SERVICE, WALLPAPER_FETCHER);
        registerService(WIFI_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(WIFI_SERVICE);
                    IWifiManager service = IWifiManager.Stub.asInterface(b);
                    return new WifiManager(service, ctx.mMainThread.getHandler());
                }});
        registerService(WIFI_P2P_SERVICE, new ServiceFetcher() {
                public Object createService(ContextImpl ctx) {
                    IBinder b = ServiceManager.getService(WIFI_P2P_SERVICE);
                    IWifiP2pManager service = IWifiP2pManager.Stub.asInterface(b);
                    return new WifiP2pManager(service);
                }});
        registerService(WINDOW_SERVICE, new ServiceFetcher() {
                public Object getService(ContextImpl ctx) {
                    return WindowManagerImpl.getDefault(ctx.mPackageInfo.mCompatibilityInfo);
                }});
    }
    
}

