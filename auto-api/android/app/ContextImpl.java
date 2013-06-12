package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.concrete.DroidSafeContentResolver;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:52.858 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "1D4C9AEA440E61663A2912AA2C97A5FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ReceiverRestrictedContext(Context base) {
        super(base);
        dsTaint.addTaint(base.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:52.872 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "E3DE8FF69A9A52E1039CF81720F99072")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varD2EEEF37B89DF699D70D46FB84E6D0B0_972554544 = (registerReceiver(receiver, filter, null, null));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:52.881 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "215D1EC72B2721FCD1D6D59047B08B6B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:52.910 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "254E3CCD30027F2441B869F20B8BC9AB")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(service.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

public class ContextImpl extends Context {
    private static String TAG = "ApplicationContext";
    private static boolean DEBUG = false;
    private static HashMap<String, SharedPreferencesImpl> sSharedPrefs =
            new HashMap<String, SharedPreferencesImpl>();
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
    private static String[] EMPTY_FILE_LIST = {};
    private static HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP =
            new HashMap<String, ServiceFetcher>();
    private static int sNextPerContextServiceCacheIndex = 0;
    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:52.968 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "213540BB7EAC828692C9A8EA85099AF0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object createService(ContextImpl ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            Object varCF6F7E63ED3DC13E313599E9A85ACDED_1071024039 = (new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler()));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WallpaperManager(ctx.getOuterContext(),
                        //ctx.mMainThread.getHandler());
        }

        
}; //Transformed anonymous class
    ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    private DroidSafeContentResolver contentResolver;
	private SensorManager sensorManager;
	
    @DSModeled
	public ContextImpl() {
		contentResolver = new DroidSafeContentResolver(this);
		sensorManager = new SensorManager();
	}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.028 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "14A32BC4C3D6CA279C3AF3FE766DAAE8")
    @DSModeled(DSC.SPEC)
    public ContextImpl(ContextImpl context) {
    	contentResolver = new DroidSafeContentResolver(this);
		sensorManager = new SensorManager();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.050 -0400", hash_original_method = "2DEA2071DD8F2C13363DA069B1820F58", hash_generated_method = "48DC6DF4787C6418877137AB2B791B18")
    private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.063 -0400", hash_original_method = "374239E6E9AC9E3552D4A077D8744FFB", hash_generated_method = "B8FDDC39B13812FD0E23045E8DFF123F")
    static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.089 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "C12E895D6CB867ADFF9C94DAD53691BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AssetManager getAssets() {
        AssetManager varB6DFBCD77C2C4F7B0CFCD6528F08C57D_1813663247 = (mResources.getAssets());
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.102 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "37B074B654EF2DCC7E713A1DC86D06DC")
    @DSModeled(DSC.SAFE)
    @Override
    public Resources getResources() {
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.132 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "816C41C197F60FAE85EA037530EEC32D")
    @DSModeled(DSC.SAFE)
    @Override
    public PackageManager getPackageManager() {
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        {
            PackageManager var2E36C3212C56B4F941E42ECF1CA2BB21_911162836 = ((mPackageManager = new ApplicationPackageManager(this, pm)));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.148 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "363C4C10C923F6AA52CAB9361E7CA55E")
    @DSModeled(DSC.SAFE)
    @Override
    public ContentResolver getContentResolver() {
        return (ContentResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.162 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "C166852B0292F6E3E035C684B8CFAA95")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Looper getMainLooper() {
        Looper var186120EED072CC94A8348DC54F8714EA_1578929627 = (mMainThread.getLooper());
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.184 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "077F347956A47C49CC1F523D69AC74BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context getApplicationContext() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            Object varAC988EF4A3C085BDA5C83C60073FC1BD_431607476 = (mPackageInfo.getApplication());
            Object var060DE32267C16708F07B2689CF684FA3_398130750 = (mMainThread.getApplication());
        } //End flattened ternary
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.195 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "7CC127534CE2EE5447AB6B66E8C0A442")
    @DSModeled(DSC.SAFE)
    @Override
    public void setTheme(int resid) {
        dsTaint.addTaint(resid);
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.206 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "F0B043051679BE8D95920D442C212F43")
    @DSModeled(DSC.SAFE)
    @Override
    public int getThemeResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.224 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "A436BD1EBA1063829F46190E371C7CE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.245 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "74E3794CBE7D878BF7AB8E9841EE0B83")
    @DSModeled(DSC.BAN)
    @Override
    public ClassLoader getClassLoader() {
        {
            Object var45D32093CB8C655B0A96BB1300392B3A_759967236 = (mPackageInfo.getClassLoader());
            Object var1E575F165FAF267D77C5B9C7A4F8B3AA_1928727136 = (ClassLoader.getSystemClassLoader());
        } //End flattened ternary
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.263 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "1D449DFC2BB733A40CA2D31D218A4159")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageName() {
        {
            String varFEB626561E325D76A4BB63D0A0BDBF6D_980658166 = (mPackageInfo.getPackageName());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.279 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "2EEEA99AD24AA94586AEA41D9D7534E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ApplicationInfo getApplicationInfo() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        {
            ApplicationInfo var6B645DAA9FF4793BD319AC90E86AC344_626154726 = (mPackageInfo.getApplicationInfo());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.300 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "D952780397CF19E198B5DE204D7762F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageResourcePath() {
        {
            String var041E560FDBA108CA79ACB0E1CCD9D504_1204453905 = (mPackageInfo.getResDir());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.313 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "CCF189DFF75A81D56172227A7AE9D3FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageCodePath() {
        {
            String varEAF932C4D46101804124EBA08898B22F_1666641551 = (mPackageInfo.getAppDir());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.325 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "C4EA402223C639D3F1B58E397CA302A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public File getSharedPrefsFile(String name) {
        dsTaint.addTaint(name);
        File var9C75A65C77C38E74778A5AD5E7B63EA4_1150159027 = (makeFilename(getPreferencesDir(), name + ".xml"));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.355 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "5E83A35198D9CD7A5F2AD2557609B346")
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
            boolean var2E6124E1185D02CDB2C7C679C6727913_1532561150 = ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.376 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "4572632C95FD5D4B82C94C96BE8AC7AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.399 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "10A7445EF0566BD51ACA98510FFC75FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        dsTaint.addTaint(name);
        File f;
        f = makeFilename(getFilesDir(), name);
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.420 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "7E06E117BA6B01CF30D547BCE77E9F38")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.443 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "21539D375E6A5635459527583D6CDF18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteFile(String name) {
        dsTaint.addTaint(name);
        File f;
        f = makeFilename(getFilesDir(), name);
        boolean varF551010B15D2D277CEBBB446DD2917F7_448459048 = (f.delete());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.460 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "331AE17E90487A066EA331A660D636A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFilesDir() {
        {
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } //End block
            {
                boolean var19E4FA9AD9694173D1E5B3B11060E583_1287098446 = (!mFilesDir.exists());
                {
                    {
                        boolean var20989B86B1B7C5B3A21029C102C7B0F0_1379823354 = (!mFilesDir.mkdirs());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.492 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "B9233769A75B0C8C88D08263A2916E2D")
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
                boolean varB276A181C4EB3EF93304E7B1C49EFB6B_873516480 = (!mExternalFilesDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean var675269D0F3BF0B3D2DEA41EAF426F526_1326616838 = (!mExternalFilesDir.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            File dir;
            dir = new File(mExternalFilesDir, type);
            {
                boolean varFE8E78642ABD38646DA929922A7BF3DC_1658785344 = (!dir.exists());
                {
                    {
                        boolean varCC013DA93565AE954394EDAB638D90F5_1515285167 = (!dir.mkdirs());
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.513 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "711428CDFBD95A6D609CBE667B4E5B15")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.526 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "D70CDEFCC8BE9DE8F5A2B5EA30893DA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getCacheDir() {
        {
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } //End block
            {
                boolean var2F5430C0F48CD9EE00D803058AB5029F_825243402 = (!mCacheDir.exists());
                {
                    {
                        boolean var83D0E63134D15DC773688937A5F3BD28_1158557694 = (!mCacheDir.mkdirs());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.536 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "7D0C24236F37D37F00BAD7F5C4C98BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getExternalCacheDir() {
        {
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } //End block
            {
                boolean var00D9D94DA81ED9ECF73133C2FCFD94BC_660521051 = (!mExternalCacheDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean varBF80BF4F4103A772CF6C96028B68472F_1780647601 = (!mExternalCacheDir.mkdirs());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.544 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "7510E089E3C58E1B81E7C49FB0891E43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFileStreamPath(String name) {
        dsTaint.addTaint(name);
        File varE53A93B551D5EFAC689F0E45EC61E69F_962660014 = (makeFilename(getFilesDir(), name));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.548 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "3110606B42E713EB3FECAA9B7271638E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.553 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "AF1FE8E170626A26989E33557F35CD61")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.561 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "89F333C0EB21B1D62FAFD798929CCCCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.568 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "DAF6B8916B47E04EF08F2BBA79A54DD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteDatabase(String name) {
        dsTaint.addTaint(name);
        try 
        {
            File f;
            f = validateFilePath(name, false);
            boolean varABE1B429208141FF7999C4FBA16347A8_1485490944 = (f.delete());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.572 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "BFBC5EC94FBE6412A9AFBB4997AB6B2C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDatabasePath(String name) {
        dsTaint.addTaint(name);
        File var73F8DB05AAAE71F509023FB2822C8B0C_1733965388 = (validateFilePath(name, false));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.577 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "84E355D8C7BDCB79C4C44EA744B4960C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.588 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "8B71F66CE526C725CE2379A66B73B58B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getDatabasesDir() {
        {
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
            {
                boolean var0314E0B292381BE9F1623149CD8F8489_986310467 = (mDatabasesDir.getPath().equals("databases"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.594 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "93BDE7B11C585BC128873F4E30C8C970")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getWallpaper() {
        Drawable varED23506173B42870BCEF9B102F0A2E7A_555641387 = (getWallpaperManager().getDrawable());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.601 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "25CE28953C9DBC370E7EDDABACF65ED8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable peekWallpaper() {
        Drawable var0794F6EA267AE86382B38F9AE0A69F72_1045132423 = (getWallpaperManager().peekDrawable());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.605 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "B6119AE8BF59013BF788B71623330196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varC254F548CFAB2206D8996DEF871ED770_639156994 = (getWallpaperManager().getDesiredMinimumWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.609 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "CD5900FD619C8C09D6F75C16313F0DF4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var0CAE8BF1444C70E01A3CB5415A62929F_1878246938 = (getWallpaperManager().getDesiredMinimumHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.613 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "3DF73E89BF591003822E21CEDAAFB65D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        dsTaint.addTaint(bitmap.dsTaint);
        getWallpaperManager().setBitmap(bitmap);
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.616 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "513486C94B0A4DAAD039126975127B7B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        dsTaint.addTaint(data.dsTaint);
        getWallpaperManager().setStream(data);
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.621 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "89B1139E69DC4E18196A32A5AF674F09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.627 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "70BBCBDF3BA7D1AF67A063E6E834E59C")
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            boolean var4E2CEB5436A3062C8E21590CE555C7F9_777704706 = ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.634 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "2F1AF77E1F21F0D98D2AF3C34C53EFC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startActivities(Intent[] intents) {
        dsTaint.addTaint(intents[0].dsTaint);
        {
            boolean varB54A748E26DA9CF993CAE37B6D958C5E_654163953 = ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.643 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "C92289E6AF0618011243638720D96008")
    @DSModeled(DSC.SPEC)
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(fillInIntent.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.649 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "B777B538D745B1B1FB7CCFFB17D3D288")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.657 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "51CF07EC81D89033610C0E097EBE2C8B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.662 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "63E44FB619401DEEC7CF5F72720C9C93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.676 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "54478BB338AA191DEDF618ED3066751F")
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
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.683 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "95AF34E7BFA557439C5C06242501EBF2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.704 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "590029A71FF50FA1CCA428839CF150E6")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(initialExtras.dsTaint);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialCode);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.724 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "3AED443F5D09A08AE8B8298A9F1C7B8D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.732 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "5E02D35A345EBF9CE920E7E3244ABB5D")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varD2EEEF37B89DF699D70D46FB84E6D0B0_492643220 = (registerReceiver(receiver, filter, null, null));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.745 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "434E995807B4E522580CDBBC4EE4E53C")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(broadcastPermission);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent varB46B2452541EDAE8CFF73321541FA200_69239045 = (registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext()));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.753 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "9198E1D6682FE81F1AF947BEF0E1FBD4")
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
            Intent var23EE3E70126311750C0EF52FA1B4011A_90097234 = (ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission));
        } //End block
        catch (RemoteException e)
        { }
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.760 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "6D1F2941F9CE7ECFDCAB4358F9B85A6A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        //DSFIXME: CODE0010: Possible callback registration function detected
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.791 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "6465D953A8830B517E884DA565C99218")
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
                boolean varD9D164FC49919222E3F05E39BAD0AAA7_1772567195 = (cn != null && cn.getPackageName().equals("!"));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.801 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "074A9C5B1CB31F2297697BBDE45D06D2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.810 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "2DFD532698C84276EF32A675908A59A5")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(flags);
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
                boolean var6493BF3E84461910769ACF3C960C9AA7_447144169 = (token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.815 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "A54A3211886820131E2C4262CFC11795")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.826 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "1227F8E570CD33AAB9A3DCE0DCA1C7F0")
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
            boolean varFB737B53559144BA0BD1ED3EEC743D0D_861747678 = (ActivityManagerNative.getDefault().startInstrumentation(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.838 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "23059336CCF730CA1CCA4A2E533CFE03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getSystemService(String name) {
        dsTaint.addTaint(name);
        ServiceFetcher fetcher;
        fetcher = SYSTEM_SERVICE_MAP.get(name);
        {
            Object var995AD4350C7C2586B3B7EFD724D8959C_1084400234 = (fetcher.getService(this));
        } //End flattened ternary
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.843 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "59A8EE6513F1EF2A213F50DB67C85BA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WallpaperManager getWallpaperManager() {
        WallpaperManager var890880107DD63A7285681E1C2F1F1039_707919888 = ((WallpaperManager) WALLPAPER_FETCHER.getService(this));
        return (WallpaperManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.860 -0400", hash_original_method = "4295EC81B8CE00729AA9F7C2FA9F917B", hash_generated_method = "C4724F1BD8C38FB198005E017E70243E")
    static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            return null;
        }
        return new DropBoxManager(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.865 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "9378B8FDB5F3CFD5C551A0ED7F9832E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(permission);
        dsTaint.addTaint(pid);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        try 
        {
            int var5F40A2437A077EA5C807226D389206D0_1354122547 = (ActivityManagerNative.getDefault().checkPermission(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.871 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "2E8FC81681D6F43B3FD2989809750933")
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
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_1024812581 = (pid != Process.myPid());
            {
                int var78028F3F1C255CC480151714E778C1C5_197487247 = (checkPermission(permission, pid,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.875 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "CBC8BBE74867ED1C3EB007B05718082B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        dsTaint.addTaint(permission);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int var34AB0D6CBBDC631C7FDA58F28B1B657C_518482417 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.878 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "9D6FAEDF4210F4303BE0194BE438E10D")
    @DSModeled(DSC.SAFE)
    private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.885 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "2713EF7A7FE61EEAB52E45528C9BED26")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
        dsTaint.addTaint(permission);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.888 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "46F0B9D95EA19B669031491F97006E93")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.891 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "9FF49EB2D1776C02E9C8CE99F92D33FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.895 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "A257514C72005CE51856571130A4096A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.898 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "C917F72E15ED8FF23A52C20A5917A929")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.902 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "AA42CF34CBEB10560D4DBA0510B98320")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        try 
        {
            int var059CF890EB6981028B04E841A7699518_1978949930 = (ActivityManagerNative.getDefault().checkUriPermission(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.909 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "B72BB02AC7E79A6FC6AE6C1C038B4068")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_240332186 = (pid != Process.myPid());
            {
                int varD7B1B302EF0CA5C388B6F3983890986E_746681511 = (checkUriPermission(uri, pid,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.915 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "53CD706ED46DD627CC41FE414F811364")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int var41FF907064E7DF4DF0C5983F95FA5974_1254065225 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.926 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "A48EBE631641391C0896128FA99DBE75")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        {
            {
                boolean var7E999FB94CB59BF987157589269CB69E_565835410 = (readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBDC2A19824C9195EFA4716604E7FC089_1014078251 = (writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            Object var486C2278A32794206F2AEE849917E1AC_1275557542 = (checkUriPermission(uri, pid, uid, modeFlags));
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.930 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "59F58B509163D1BF797E58960162367A")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.933 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "D0B8F4307D1415B5881CFC9BEBB075B9")
    @DSModeled(DSC.SPEC)
    private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.936 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "B75D1727BA68625EFFAACB8ECF787E68")
    @DSModeled(DSC.SPEC)
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.948 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "DB3415007961A48D14B7586D6A223D77")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.953 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "D09C12FA313E440599603FEC1B4E8ACC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.963 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "3752B148441A8B028ED3DE477F0FEE8C")
    @DSModeled(DSC.SPEC)
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(message);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(pid);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.972 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "6A24C36C74790151F06F1B696F9E864A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        {
            boolean varC1F5D449E2D7CC78DA5400BABA02C561_113111144 = (packageName.equals("system") || packageName.equals("android"));
            {
                Context var9AE43F778E42390ABA3A5C32567757B7_158113171 = (new ContextImpl(mMainThread.getSystemContext()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.976 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "6EBC6045D658D1A3B5163643993E5BC2")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.979 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "9201D9077C94A0757B5F064D1262B084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File getDataDirFile() {
        {
            File varEA43519865B1954F413512FF7802FE76_1925902692 = (mPackageInfo.getDataDirFile());
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.983 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "7116FA988084AB48B9BEA9EB3DC27458")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDir(String name, int mode) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        name = "app_" + name;
        File file;
        file = makeFilename(getDataDirFile(), name);
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_265262895 = (!file.exists());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.987 -0400", hash_original_method = "6D48BCF78A0D8F638E4F8DF3493EA1A0", hash_generated_method = "337E35882617EEC65CAF3EEB0E687E78")
    static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.990 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "9C1DB4808549A680555B25D2957A711B")
    @DSModeled(DSC.SAFE)
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        dsTaint.addTaint(packageInfo.dsTaint);
        dsTaint.addTaint(activityToken.dsTaint);
        dsTaint.addTaint(mainThread.dsTaint);
        init(packageInfo, activityToken, mainThread, null, null);
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:53.997 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "343FF2E4941EF0E4405A7EC33F4E0F23")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        dsTaint.addTaint(basePackageName);
        dsTaint.addTaint(container.dsTaint);
        dsTaint.addTaint(packageInfo.dsTaint);
        dsTaint.addTaint(activityToken.dsTaint);
        dsTaint.addTaint(mainThread.dsTaint);
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        {
            boolean var104A93987C9CA0B1B66503A62E5FEA6A_1417835812 = (mResources != null && container != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.001 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "6FC3A0509FCF0111ADC91373DA8C20DA")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.004 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "B215336BA2894B8EB41FF83FD9CECF3D")
    @DSModeled(DSC.SAFE)
    final void scheduleFinalCleanup(String who, String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(who);
        mMainThread.scheduleContextCleanup(this, who, what);
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.008 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "1F31AFB2E6479537BBE289E127C817CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performFinalCleanup(String who, String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(who);
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.011 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "037F62B0BE8050856753BE66A195AC39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Context getReceiverRestrictedContext() {
        Context varBE6B7DA71053E98F6FBFC9411DC0F487_126870690 = (mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext()));
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.014 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "25DEF2DCFD5271E0D2E183545F4FE821")
    @DSModeled(DSC.SAFE)
    final void setActivityToken(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.017 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "99008770619D56488076848348521692")
    @DSModeled(DSC.SAFE)
    final void setOuterContext(Context context) {
        dsTaint.addTaint(context.dsTaint);
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.019 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "4154C4D4EFAFB524A2588A6700474656")
    @DSModeled(DSC.SAFE)
    final Context getOuterContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.022 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "D1495F3D34BE1CC6D960EFCD573A1780")
    @DSModeled(DSC.SAFE)
    final IBinder getActivityToken() {
        return (IBinder)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivityToken;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.025 -0400", hash_original_method = "C8AF3048756974EA22546B41BE2F7C6F", hash_generated_method = "1DC327CB6766B683BFBFB743C0F8C248")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.032 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "60793ACDB51426C1115252433D6F285F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File validateFilePath(String name, boolean createDirectory) {
        dsTaint.addTaint(createDirectory);
        dsTaint.addTaint(name);
        File dir;
        File f;
        {
            boolean varFD0C1196C407A4234C7FE0E19F1943FE_1710920528 = (name.charAt(0) == File.separatorChar);
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
            boolean var3499179EFDC7A0451D45EF9132D21A84_937413924 = (createDirectory && !dir.isDirectory() && dir.mkdir());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.038 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "0786B56BC8D287765182A0716A7C9AA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private File makeFilename(File base, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(base.dsTaint);
        {
            boolean varE9928D58DBE793633CB7E7D7D5D3D217_1906530711 = (name.indexOf(File.separatorChar) < 0);
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.046 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "7B6B15E91E36C3E589F4555BBDE9DBE4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public Object getService(ContextImpl ctx) {
            dsTaint.addTaint(ctx.dsTaint);
            ArrayList<Object> cache;
            cache = ctx.mServiceCache;
            Object service;
            {
                {
                    boolean var64657C48B0EB7731DEDFDF761A102E58_1736326721 = (cache.size() == 0);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.052 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "9EE1D12C575C2C38C57527DEA36CDB9B")
        @DSModeled(DSC.SAFE)
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.057 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "C3E900729633029110E3A87888BC7438")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public final Object getService(ContextImpl unused) {
            dsTaint.addTaint(unused.dsTaint);
            {
                Object service;
                service = mCachedInstance;
                Object varEBE25ABDAE50582B2924CECC4F91A105_915434831 = (mCachedInstance = createStaticService());
            } //End block
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.060 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "957AC838AD0A6BA03EEEF4F03B43B048")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            dsTaint.addTaint(context.dsTaint);
            dsTaint.addTaint(mainThread.dsTaint);
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.065 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "9A66B8A40321573E26A512C53D4224D6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            IContentProvider var6E14F0B8C03ACF51979B6097CA57898D_1396771446 = (mMainThread.acquireProvider(context, name));
            return (IContentProvider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.069 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "EC49FA80C2973A11E7533245FC45566C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(context.dsTaint);
            IContentProvider var03A605DA0D1D5DF30FE0C22F77097ABF_1085472840 = (mMainThread.acquireExistingProvider(context, name));
            return (IContentProvider)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:30:54.073 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "98C8E864DCCE1EA870669DEE505B74FD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            dsTaint.addTaint(provider.dsTaint);
            boolean var38B4042628FFD57CF97DF331208B6769_466549871 = (mMainThread.releaseProvider(provider));
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
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


//DSFIXME:  CODE0011:  Unresolved legacy methods exist in original model
/*

*/
