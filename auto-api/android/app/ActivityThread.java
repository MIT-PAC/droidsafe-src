package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.backup.BackupAgent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.IIntentReceiver;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.InstrumentationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.content.res.AssetManager;
import android.content.res.CompatibilityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDebug;
import android.database.sqlite.SQLiteDebug.DbStats;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.IConnectivityManager;
import android.net.Proxy;
import android.net.ProxyProperties;
import android.opengl.GLUtils;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.StrictMode;
import android.os.SystemClock;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.util.EventLog;
import android.util.Log;
import android.util.LogPrinter;
import android.util.Slog;
import android.view.Display;
import android.view.HardwareRenderer;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewManager;
import android.view.ViewRootImpl;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManagerImpl;
import com.android.internal.os.BinderInternal;
import com.android.internal.os.RuntimeInit;
import com.android.internal.os.SamplingProfilerIntegration;
import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;
import dalvik.system.CloseGuard;

final class SuperNotCalledException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.209 -0400", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "88F0D63566ADC28923E97955F02E7CED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SuperNotCalledException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

final class RemoteServiceException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.210 -0400", hash_original_method = "34FE87499D0272DFF74E34D7FF4C8A87", hash_generated_method = "7FE8F3D40183A62C3F1EDEE52149D972")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RemoteServiceException(String msg) {
        super(msg);
        dsTaint.addTaint(msg);
        // ---------- Original Method ----------
    }

    
}

public final class ActivityThread {
    ApplicationThread mAppThread = new ApplicationThread();
    Looper mLooper = Looper.myLooper();
    H mH = new H();
    HashMap<IBinder, ActivityClientRecord> mActivities
            = new HashMap<IBinder, ActivityClientRecord>();
    ActivityClientRecord mNewActivities = null;
    int mNumVisibleActivities = 0;
    HashMap<IBinder, Service> mServices
            = new HashMap<IBinder, Service>();
    AppBindData mBoundApplication;
    Profiler mProfiler;
    Configuration mConfiguration;
    Configuration mCompatConfiguration;
    Configuration mResConfiguration;
    CompatibilityInfo mResCompatibilityInfo;
    Application mInitialApplication;
    ArrayList<Application> mAllApplications
            = new ArrayList<Application>();
    HashMap<String, BackupAgent> mBackupAgents = new HashMap<String, BackupAgent>();
    Instrumentation mInstrumentation;
    String mInstrumentationAppDir = null;
    String mInstrumentationAppPackage = null;
    String mInstrumentedAppDir = null;
    boolean mSystemThread = false;
    boolean mJitEnabled = false;
    HashMap<String, WeakReference<LoadedApk>> mPackages
            = new HashMap<String, WeakReference<LoadedApk>>();
    HashMap<String, WeakReference<LoadedApk>> mResourcePackages
            = new HashMap<String, WeakReference<LoadedApk>>();
    HashMap<CompatibilityInfo, DisplayMetrics> mDisplayMetrics
            = new HashMap<CompatibilityInfo, DisplayMetrics>();
    HashMap<ResourcesKey, WeakReference<Resources> > mActiveResources
            = new HashMap<ResourcesKey, WeakReference<Resources> >();
    ArrayList<ActivityClientRecord> mRelaunchingActivities
            = new ArrayList<ActivityClientRecord>();
    Configuration mPendingConfiguration = null;
    HashMap<String, ProviderClientRecord> mProviderMap
        = new HashMap<String, ProviderClientRecord>();
    HashMap<IBinder, ProviderRefCount> mProviderRefCountMap
        = new HashMap<IBinder, ProviderRefCount>();
    HashMap<IBinder, ProviderClientRecord> mLocalProviders
        = new HashMap<IBinder, ProviderClientRecord>();
    HashMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners
        = new HashMap<Activity, ArrayList<OnActivityPausedListener>>();
    GcIdler mGcIdler = new GcIdler();
    boolean mGcIdlerScheduled = false;
    Bundle mCoreSettings = null;
    private Configuration mMainThreadConfig = new Configuration();
    private int mThumbnailWidth = -1;
    private int mThumbnailHeight = -1;
    private Bitmap mAvailThumbnailBitmap = null;
    private Canvas mThumbnailCanvas = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.211 -0400", hash_original_method = "C5DB87E83A0D8D66EF8ECA86A91864C7", hash_generated_method = "DE4A90A4BD0EECDAD4C2F33FDAD8D9FA")
    @DSModeled(DSC.SAFE)
     ActivityThread() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.211 -0400", hash_original_method = "FA5B9DB827774258D426805F82794E0D", hash_generated_method = "5193D4EFACB8D20D39972A5FDD9BA430")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void dumpGraphicsInfo(FileDescriptor fd) {
        dsTaint.addTaint(fd.dsTaint);
    }

    
        public static ActivityThread currentActivityThread() {
        return sThreadLocal.get();
    }

    
        public static String currentPackageName() {
        ActivityThread am = currentActivityThread();
        return (am != null && am.mBoundApplication != null)
            ? am.mBoundApplication.processName : null;
    }

    
        public static Application currentApplication() {
        ActivityThread am = currentActivityThread();
        return am != null ? am.mInitialApplication : null;
    }

    
        public static IPackageManager getPackageManager() {
        if (sPackageManager != null) {
            return sPackageManager;
        }
        IBinder b = ServiceManager.getService("package");
        sPackageManager = IPackageManager.Stub.asInterface(b);
        return sPackageManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.213 -0400", hash_original_method = "E45CB384263D7EF5FBA0A98360B08B32", hash_generated_method = "B0BF175295E6ED9BF5E9CA291C6A4108")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo ci, boolean forceUpdate) {
        dsTaint.addTaint(ci.dsTaint);
        dsTaint.addTaint(forceUpdate);
        DisplayMetrics dm;
        dm = mDisplayMetrics.get(ci);
        {
            dm = new DisplayMetrics();
            mDisplayMetrics.put(ci, dm);
        } //End block
        Display d;
        d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        d.getMetrics(dm);
        return (DisplayMetrics)dsTaint.getTaint();
        // ---------- Original Method ----------
        //DisplayMetrics dm = mDisplayMetrics.get(ci);
        //if (dm != null && !forceUpdate) {
            //return dm;
        //}
        //if (dm == null) {
            //dm = new DisplayMetrics();
            //mDisplayMetrics.put(ci, dm);
        //}
        //Display d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        //d.getMetrics(dm);
        //return dm;
    }

    
        static Configuration applyConfigCompat(Configuration config, CompatibilityInfo compat) {
        if (config == null) {
            return null;
        }
        if (compat != null && !compat.supportsScreen()) {
            config = new Configuration(config);
            compat.applyToConfiguration(config);
        }
        return config;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.214 -0400", hash_original_method = "DD63F0FD46EA5914D44A0437CF6968C9", hash_generated_method = "F2C68B78AE10D3A7506E2117F321ACE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Configuration applyConfigCompatMainThread(Configuration config, CompatibilityInfo compat) {
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(compat.dsTaint);
        {
            boolean varCD86D3736FF36F045F26DFAD036F3B54_1700559137 = (compat != null && !compat.supportsScreen());
            {
                mMainThreadConfig.setTo(config);
                config = mMainThreadConfig;
                compat.applyToConfiguration(config);
            } //End block
        } //End collapsed parenthetic
        return (Configuration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (config == null) {
            //return null;
        //}
        //if (compat != null && !compat.supportsScreen()) {
            //mMainThreadConfig.setTo(config);
            //config = mMainThreadConfig;
            //compat.applyToConfiguration(config);
        //}
        //return config;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.215 -0400", hash_original_method = "371F1E66BBE63CA5CE35B0BEAA492ADA", hash_generated_method = "90673DEC3FED75B4657C814A1F90C9C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Resources getTopLevelResources(String resDir, CompatibilityInfo compInfo) {
        dsTaint.addTaint(compInfo.dsTaint);
        dsTaint.addTaint(resDir);
        ResourcesKey key;
        key = new ResourcesKey(resDir, compInfo.applicationScale);
        Resources r;
        {
            WeakReference<Resources> wr;
            wr = mActiveResources.get(key);
            r = wr != null ? wr.get() : null;
            {
                boolean var48C26B00950FB02DC27CD0CFBAC99128_218649334 = (r != null && r.getAssets().isUpToDate());
            } //End collapsed parenthetic
        } //End block
        AssetManager assets;
        assets = new AssetManager();
        {
            boolean varA8CA5D176688F55202435C4C301C623B_2058694994 = (assets.addAssetPath(resDir) == 0);
        } //End collapsed parenthetic
        DisplayMetrics metrics;
        metrics = getDisplayMetricsLocked(null, false);
        r = new Resources(assets, metrics, getConfiguration(), compInfo);
        {
            WeakReference<Resources> wr;
            wr = mActiveResources.get(key);
            Resources existing;
            existing = wr.get();
            existing = null;
            {
                boolean var272EB1A1727EF2EADA6DAD1E49705320_1628107640 = (existing != null && existing.getAssets().isUpToDate());
                {
                    r.getAssets().close();
                } //End block
            } //End collapsed parenthetic
            mActiveResources.put(key, new WeakReference<Resources>(r));
        } //End block
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.215 -0400", hash_original_method = "9D648CED90369A8409E4C88D7CE96759", hash_generated_method = "D59B4A3B2D8205700EEFF6E8CB624CB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Resources getTopLevelResources(String resDir, LoadedApk pkgInfo) {
        dsTaint.addTaint(pkgInfo.dsTaint);
        dsTaint.addTaint(resDir);
        Resources varD0CC2F4D5EEA49B01F47AA4667C22436_1511311060 = (getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get()));
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.216 -0400", hash_original_method = "F7A72EDCDC7800374FD6BBEAFCDB636B", hash_generated_method = "8617FCBA21D8F6A8042286727DF2A408")
    @DSModeled(DSC.SAFE)
    final Handler getHandler() {
        return (Handler)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.217 -0400", hash_original_method = "FD6B2C09494E94CB4CF03F9000F967F2", hash_generated_method = "34B52FDD2CBAE37B8424F0B7E1DBB499")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final LoadedApk getPackageInfo(String packageName, CompatibilityInfo compatInfo,
            int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(packageName);
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(packageName);
            } //End block
            {
                ref = mResourcePackages.get(packageName);
            } //End block
            LoadedApk packageInfo;
            packageInfo = ref.get();
            packageInfo = null;
            {
                boolean varB533B767BDFF950E5D1E69E8D8289A2E_1176667958 = (packageInfo != null && (packageInfo.mResources == null
                    || packageInfo.mResources.getAssets().isUpToDate()));
                {
                    {
                        boolean var0E943DBF535AA6AD6A4FBE9A1D1356B5_1563685099 = (packageInfo.isSecurityViolation()
                        && (flags&Context.CONTEXT_IGNORE_SECURITY) == 0);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                            "Requesting code from " + packageName
                            + " to be run in process "
                            + mBoundApplication.processName
                            + "/" + mBoundApplication.appInfo.uid);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        ApplicationInfo ai;
        ai = null;
        try 
        {
            ai = getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_SHARED_LIBRARY_FILES);
        } //End block
        catch (RemoteException e)
        { }
        {
            LoadedApk varDF8C1F6926BC9C316256F449C4B668E9_336068663 = (getPackageInfo(ai, compatInfo, flags));
        } //End block
        return (LoadedApk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.218 -0400", hash_original_method = "45FB4CD004B111E95D4C640E8F52184B", hash_generated_method = "F1D58B71717EE8C8FEF15C6EFD4868DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final LoadedApk getPackageInfo(ApplicationInfo ai, CompatibilityInfo compatInfo,
            int flags) {
        dsTaint.addTaint(ai.dsTaint);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(compatInfo.dsTaint);
        boolean includeCode;
        includeCode = (flags&Context.CONTEXT_INCLUDE_CODE) != 0;
        boolean securityViolation;
        securityViolation = includeCode && ai.uid != 0
                && ai.uid != Process.SYSTEM_UID && (mBoundApplication != null
                        ? ai.uid != mBoundApplication.appInfo.uid : true);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            {
                String msg;
                msg = "Requesting code from " + ai.packageName
                        + " (with uid " + ai.uid + ")";
                {
                    msg = msg + " to be run in process "
                        + mBoundApplication.processName + " (with uid "
                        + mBoundApplication.appInfo.uid + ")";
                } //End block
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            } //End block
        } //End block
        LoadedApk var578F54B83987DE85C954C04ABE16BBBF_22976855 = (getPackageInfo(ai, compatInfo, null, securityViolation, includeCode));
        return (LoadedApk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.219 -0400", hash_original_method = "60B71579104EFF006D8A717508119428", hash_generated_method = "5D1F2B73C1AAB58C7549E88181616743")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo ai,
            CompatibilityInfo compatInfo) {
        dsTaint.addTaint(ai.dsTaint);
        dsTaint.addTaint(compatInfo.dsTaint);
        LoadedApk varA52C6EBF17365357ABB0DE393B295D16_293083625 = (getPackageInfo(ai, compatInfo, null, false, true));
        return (LoadedApk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getPackageInfo(ai, compatInfo, null, false, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.220 -0400", hash_original_method = "5838753A6BAADDD41C531129622D5299", hash_generated_method = "59B21401B9E2BC3426F2573BD319ACA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final LoadedApk peekPackageInfo(String packageName, boolean includeCode) {
        dsTaint.addTaint(packageName);
        dsTaint.addTaint(includeCode);
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(packageName);
            } //End block
            {
                ref = mResourcePackages.get(packageName);
            } //End block
            {
                Object varE8B6FE7E6284ED77A6F8AF563B147DB5_315115050 = (ref.get());
            } //End flattened ternary
        } //End block
        return (LoadedApk)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //WeakReference<LoadedApk> ref;
            //if (includeCode) {
                //ref = mPackages.get(packageName);
            //} else {
                //ref = mResourcePackages.get(packageName);
            //}
            //return ref != null ? ref.get() : null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.221 -0400", hash_original_method = "F2A25E301DE436DC300B56B48A365596", hash_generated_method = "9C9CAD0CDCE63AD36D93BA04A87F83CD")
    @DSModeled(DSC.BAN)
    private LoadedApk getPackageInfo(ApplicationInfo aInfo, CompatibilityInfo compatInfo,
            ClassLoader baseLoader, boolean securityViolation, boolean includeCode) {
        dsTaint.addTaint(securityViolation);
        dsTaint.addTaint(compatInfo.dsTaint);
        dsTaint.addTaint(includeCode);
        dsTaint.addTaint(aInfo.dsTaint);
        dsTaint.addTaint(baseLoader.dsTaint);
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(aInfo.packageName);
            } //End block
            {
                ref = mResourcePackages.get(aInfo.packageName);
            } //End block
            LoadedApk packageInfo;
            packageInfo = ref.get();
            packageInfo = null;
            {
                boolean var9EEE2F12DDA56A5DEE7DE7A2224F5C7D_1976742384 = (packageInfo == null || (packageInfo.mResources != null
                    && !packageInfo.mResources.getAssets().isUpToDate()));
                {
                    packageInfo =
                    new LoadedApk(this, aInfo, compatInfo, this, baseLoader,
                            securityViolation, includeCode &&
                            (aInfo.flags&ApplicationInfo.FLAG_HAS_CODE) != 0);
                    {
                        mPackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                    } //End block
                    {
                        mResourcePackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (LoadedApk)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.222 -0400", hash_original_method = "F0BED1934E92681B3C0E496CA2259BFD", hash_generated_method = "F77659B030019B8CD24FF4C0381EE800")
    @DSModeled(DSC.SAFE)
    public ApplicationThread getApplicationThread() {
        return (ApplicationThread)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAppThread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.222 -0400", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "39E1AEEF172767D61E8860F71287453E")
    @DSModeled(DSC.SAFE)
    public Instrumentation getInstrumentation() {
        return (Instrumentation)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInstrumentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.223 -0400", hash_original_method = "9032A5E826B7A6BB9A1848729A4BF06F", hash_generated_method = "29C38F4FF9E653DFFE5971A7FAE1236E")
    @DSModeled(DSC.SAFE)
    public Configuration getConfiguration() {
        return (Configuration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mResConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.223 -0400", hash_original_method = "BB8D8D9198132B7570723812CBBB4B98", hash_generated_method = "05F0805E1F679CDDF2E6E0C37334B145")
    @DSModeled(DSC.SAFE)
    public boolean isProfiling() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mProfiler != null && mProfiler.profileFile != null
                //&& mProfiler.profileFd == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.223 -0400", hash_original_method = "DE9E88BCF6C439479F5E5429ED790EB6", hash_generated_method = "F460C9AE7287E8E626079EBFB2EACA53")
    @DSModeled(DSC.SAFE)
    public String getProfileFilePath() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mProfiler.profileFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.224 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "FBA004FA502D6A889ABB18AE2C22A8F5")
    @DSModeled(DSC.SAFE)
    public Looper getLooper() {
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.224 -0400", hash_original_method = "BED0801CDE1100B1F268B3031343DFA4", hash_generated_method = "953546B5AABAFE26114746E4F0A0ED26")
    @DSModeled(DSC.SAFE)
    public Application getApplication() {
        return (Application)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mInitialApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.225 -0400", hash_original_method = "5878D065A1BC5C9B3897192B88F09BB5", hash_generated_method = "468BB6DF7B64F3C2B8113EEA35CB54A0")
    @DSModeled(DSC.SAFE)
    public String getProcessName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBoundApplication.processName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.225 -0400", hash_original_method = "67B7F6B98B8791421AA33911A41FCF20", hash_generated_method = "5473FD0F1B38188C9BDD1FCD97A32B19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContextImpl getSystemContext() {
        {
            {
                ContextImpl context;
                context = ContextImpl.createSystemContext(this);
                LoadedApk info;
                info = new LoadedApk(this, "android", context, null,
                        CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO);
                context.init(info, null, this);
                context.getResources().updateConfiguration(
                        getConfiguration(), getDisplayMetricsLocked(
                                CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
                mSystemContext = context;
            } //End block
        } //End block
        return (ContextImpl)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mSystemContext == null) {
                //ContextImpl context =
                    //ContextImpl.createSystemContext(this);
                //LoadedApk info = new LoadedApk(this, "android", context, null,
                        //CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO);
                //context.init(info, null, this);
                //context.getResources().updateConfiguration(
                        //getConfiguration(), getDisplayMetricsLocked(
                                //CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
                //mSystemContext = context;
            //}
        //}
        //return mSystemContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.226 -0400", hash_original_method = "AC12C154682E9BD06E6B4A91255348E3", hash_generated_method = "340502C1E627F5DB2341C75BE66E9240")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void installSystemApplicationInfo(ApplicationInfo info) {
        dsTaint.addTaint(info.dsTaint);
        {
            ContextImpl context;
            context = getSystemContext();
            context.init(new LoadedApk(this, "android", context, info,
                    CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            mProfiler = new Profiler();
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //ContextImpl context = getSystemContext();
            //context.init(new LoadedApk(this, "android", context, info,
                    //CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            //mProfiler = new Profiler();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.227 -0400", hash_original_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15", hash_generated_method = "93C8069C63CC057876DD921F32F06D0F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void ensureJitEnabled() {
        {
            mJitEnabled = true;
            dalvik.system.VMRuntime.getRuntime().startJitCompilation();
        } //End block
        // ---------- Original Method ----------
        //if (!mJitEnabled) {
            //mJitEnabled = true;
            //dalvik.system.VMRuntime.getRuntime().startJitCompilation();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.228 -0400", hash_original_method = "9194C167DA959B824F2056B7870F9862", hash_generated_method = "C950B3F99143F6F5E96E0A1201B207BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void scheduleGcIdler() {
        {
            mGcIdlerScheduled = true;
            Looper.myQueue().addIdleHandler(mGcIdler);
        } //End block
        mH.removeMessages(H.GC_WHEN_IDLE);
        // ---------- Original Method ----------
        //if (!mGcIdlerScheduled) {
            //mGcIdlerScheduled = true;
            //Looper.myQueue().addIdleHandler(mGcIdler);
        //}
        //mH.removeMessages(H.GC_WHEN_IDLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.229 -0400", hash_original_method = "418A9C1DFD1D7F21CC468D764B344F26", hash_generated_method = "DAEBA60FFC284CD27BC815F3423B1DBA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void unscheduleGcIdler() {
        {
            mGcIdlerScheduled = false;
            Looper.myQueue().removeIdleHandler(mGcIdler);
        } //End block
        mH.removeMessages(H.GC_WHEN_IDLE);
        // ---------- Original Method ----------
        //if (mGcIdlerScheduled) {
            //mGcIdlerScheduled = false;
            //Looper.myQueue().removeIdleHandler(mGcIdler);
        //}
        //mH.removeMessages(H.GC_WHEN_IDLE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.229 -0400", hash_original_method = "7E176906E0A5888F6535695D6EB5B115", hash_generated_method = "B735526FD9B1DFDA49A544488BF3CD94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        long now;
        now = SystemClock.uptimeMillis();
        {
            boolean varE184117867CF0C26F2EFEE16CB7C3505_351376168 = ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now);
            {
                BinderInternal.forceGc("bg");
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //mGcIdlerScheduled = false;
        //final long now = SystemClock.uptimeMillis();
        //if ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now) {
            //BinderInternal.forceGc("bg");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.230 -0400", hash_original_method = "BC7C90866968540D7B885FF1F76E8E09", hash_generated_method = "91BF191C944FFF432380003CA0BA3488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            ArrayList<OnActivityPausedListener> list;
            list = mOnPauseListeners.get(activity);
            {
                list = new ArrayList<OnActivityPausedListener>();
                mOnPauseListeners.put(activity, list);
            } //End block
            list.add(listener);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mOnPauseListeners) {
            //ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            //if (list == null) {
                //list = new ArrayList<OnActivityPausedListener>();
                //mOnPauseListeners.put(activity, list);
            //}
            //list.add(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.231 -0400", hash_original_method = "A666FB211AE0A9537AAE3A42A197A4A4", hash_generated_method = "87DA365434AD3B686136CE99713DDC68")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        {
            ArrayList<OnActivityPausedListener> list;
            list = mOnPauseListeners.get(activity);
            {
                list.remove(listener);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mOnPauseListeners) {
            //ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            //if (list != null) {
                //list.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.232 -0400", hash_original_method = "FA6ACBD6D6B2F04759E1E44999782C17", hash_generated_method = "E88B5DF1157CDBAEA45D209249AF0BC1")
    @DSModeled(DSC.SPEC)
    public final ActivityInfo resolveActivityInfo(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        ActivityInfo aInfo;
        aInfo = intent.resolveActivityInfo(
                mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        {
            Instrumentation.checkStartActivityResult(
                    IActivityManager.START_CLASS_NOT_FOUND, intent);
        } //End block
        return (ActivityInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityInfo aInfo = intent.resolveActivityInfo(
                //mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        //if (aInfo == null) {
            //Instrumentation.checkStartActivityResult(
                    //IActivityManager.START_CLASS_NOT_FOUND, intent);
        //}
        //return aInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.233 -0400", hash_original_method = "52193E396925A8581791167FBC0A1FC9", hash_generated_method = "9D4AEB787B84E3DD0C55A5D59B9AAFF8")
    @DSModeled(DSC.SPEC)
    public final Activity startActivityNow(Activity parent, String id,
        Intent intent, ActivityInfo activityInfo, IBinder token, Bundle state,
        Activity.NonConfigurationInstances lastNonConfigurationInstances) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(activityInfo.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(lastNonConfigurationInstances.dsTaint);
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        ActivityClientRecord r;
        r = new ActivityClientRecord();
        r.token = token;
        r.ident = 0;
        r.intent = intent;
        r.state = state;
        r.parent = parent;
        r.embeddedID = id;
        r.activityInfo = activityInfo;
        r.lastNonConfigurationInstances = lastNonConfigurationInstances;
        {
            ComponentName compname;
            compname = intent.getComponent();
            String name;
            {
                name = compname.toShortString();
            } //End block
            {
                name = "(Intent " + intent + ").getComponent() returned null";
            } //End block
        } //End block
        Activity var468D3504EAE564C903E86C4C5C1E26B0_369969037 = (performLaunchActivity(r, null));
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.233 -0400", hash_original_method = "E4DB0C38EE0152F49C4586AFA6AD83D1", hash_generated_method = "3872B14512A9D40117F93288FBC66E62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final Activity getActivity(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        Activity varF3FB84BF94497417DE57C8B684C59F62_281075504 = (mActivities.get(token).activity);
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivities.get(token).activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.234 -0400", hash_original_method = "46F0209236B49884D3899FCB9A0A8CD2", hash_generated_method = "D89CF8DDB3C56374D04C13AAEA16C05F")
    @DSModeled(DSC.SPEC)
    public final void sendActivityResult(
            IBinder token, String id, int requestCode,
            int resultCode, Intent data) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(resultCode);
        ArrayList<ResultInfo> list;
        list = new ArrayList<ResultInfo>();
        list.add(new ResultInfo(id, requestCode, resultCode, data));
        mAppThread.scheduleSendResult(token, list);
        // ---------- Original Method ----------
        //if (DEBUG_RESULTS) Slog.v(TAG, "sendActivityResult: id=" + id
                //+ " req=" + requestCode + " res=" + resultCode + " data=" + data);
        //ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        //list.add(new ResultInfo(id, requestCode, resultCode, data));
        //mAppThread.scheduleSendResult(token, list);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.235 -0400", hash_original_method = "04C4A68B1E80544C50165B2C1F09966C", hash_generated_method = "64725729140E213FC827FDEE907CD36A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void queueOrSendMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        queueOrSendMessage(what, obj, 0, 0);
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.235 -0400", hash_original_method = "3163B4D830BC02309EB9FA4093F38166", hash_generated_method = "AB7019DB1AA7F215AB8D85BE877AFD50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void queueOrSendMessage(int what, Object obj, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        queueOrSendMessage(what, obj, arg1, 0);
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.242 -0400", hash_original_method = "BA532BAA145C03E1DD34B30EBC725387", hash_generated_method = "B3BAC7B4307A840C091208D514C81FCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void queueOrSendMessage(int what, Object obj, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        {
            Message msg;
            msg = Message.obtain();
            msg.what = what;
            msg.obj = obj;
            msg.arg1 = arg1;
            msg.arg2 = arg2;
            mH.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (DEBUG_MESSAGES) Slog.v(
                //TAG, "SCHEDULE " + what + " " + mH.codeToString(what)
                //+ ": " + arg1 + " / " + obj);
            //Message msg = Message.obtain();
            //msg.what = what;
            //msg.obj = obj;
            //msg.arg1 = arg1;
            //msg.arg2 = arg2;
            //mH.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.245 -0400", hash_original_method = "15BD644AA17343360FD7D474ECDA0BC6", hash_generated_method = "942DE2F0B3DAAE12311B789404641C6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void scheduleContextCleanup(ContextImpl context, String who,
            String what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(who);
        ContextCleanupInfo cci;
        cci = new ContextCleanupInfo();
        cci.context = context;
        cci.who = who;
        cci.what = what;
        queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
        // ---------- Original Method ----------
        //ContextCleanupInfo cci = new ContextCleanupInfo();
        //cci.context = context;
        //cci.who = who;
        //cci.what = what;
        //queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.248 -0400", hash_original_method = "C9C4D84CF5E4E5BEF4E002420AA42B4A", hash_generated_method = "753CD6723AB3FB6B22F324E994B4DE21")
    @DSModeled(DSC.SPEC)
    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(customIntent.dsTaint);
        ActivityInfo aInfo;
        aInfo = r.activityInfo;
        {
            r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
                    Context.CONTEXT_INCLUDE_CODE);
        } //End block
        ComponentName component;
        component = r.intent.getComponent();
        {
            component = r.intent.resolveActivity(
                mInitialApplication.getPackageManager());
            r.intent.setComponent(component);
        } //End block
        {
            component = new ComponentName(r.activityInfo.packageName,
                    r.activityInfo.targetActivity);
        } //End block
        Activity activity;
        activity = null;
        try 
        {
            java.lang.ClassLoader cl;
            cl = r.packageInfo.getClassLoader();
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);
            StrictMode.incrementExpectedActivityCount(activity.getClass());
            r.intent.setExtrasClassLoader(cl);
            {
                r.state.setClassLoader(cl);
            } //End block
        } //End block
        catch (Exception e)
        {
            {
                boolean var8E41159D9268684301886771AE50E678_618184417 = (!mInstrumentation.onException(activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate activity " + component
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            Application app;
            app = r.packageInfo.makeApplication(false, mInstrumentation);
            {
                ContextImpl appContext;
                appContext = new ContextImpl();
                appContext.init(r.packageInfo, r.token, this);
                appContext.setOuterContext(activity);
                CharSequence title;
                title = r.activityInfo.loadLabel(appContext.getPackageManager());
                Configuration config;
                config = new Configuration(mCompatConfiguration);
                activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config);
                {
                    activity.mIntent = customIntent;
                } //End block
                r.lastNonConfigurationInstances = null;
                activity.mStartedActivity = false;
                int theme;
                theme = r.activityInfo.getThemeResource();
                {
                    activity.setTheme(theme);
                } //End block
                activity.mCalled = false;
                mInstrumentation.callActivityOnCreate(activity, r.state);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                        "Activity " + r.intent.getComponent().toShortString() +
                        " did not call through to super.onCreate()");
                } //End block
                r.activity = activity;
                r.stopped = true;
                {
                    activity.performStart();
                    r.stopped = false;
                } //End block
                {
                    {
                        mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state);
                    } //End block
                } //End block
                {
                    activity.mCalled = false;
                    mInstrumentation.callActivityOnPostCreate(activity, r.state);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPostCreate()");
                    } //End block
                } //End block
            } //End block
            r.paused = true;
            mActivities.put(r.token, r);
        } //End block
        catch (SuperNotCalledException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (Exception e)
        {
            {
                boolean var8E41159D9268684301886771AE50E678_1176871730 = (!mInstrumentation.onException(activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to start activity " + component
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.249 -0400", hash_original_method = "483F7FDC9359FE0D21A4FBFB307EF0CA", hash_generated_method = "7E8BA5D1040B28ED76AB745DBBE3975E")
    @DSModeled(DSC.SPEC)
    private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(customIntent.dsTaint);
        unscheduleGcIdler();
        {
            mProfiler.setProfiler(r.profileFile, r.profileFd);
            mProfiler.startProfiling();
            mProfiler.autoStopProfiler = r.autoStopProfiler;
        } //End block
        handleConfigurationChanged(null, null);
        Activity a;
        a = performLaunchActivity(r, customIntent);
        {
            r.createdConfig = new Configuration(mConfiguration);
            Bundle oldState;
            oldState = r.state;
            handleResumeActivity(r.token, false, r.isForward);
            {
                try 
                {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    r.state = oldState;
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPause()");
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1254619590 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                r.paused = true;
            } //End block
        } //End block
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(r.token, Activity.RESULT_CANCELED, null);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.251 -0400", hash_original_method = "089DA2DACAED1790C29E22F2D6A7A046", hash_generated_method = "E891D8A44772216B98966198891EB39C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverNewIntents(ActivityClientRecord r,
            List<Intent> intents) {
        dsTaint.addTaint(intents.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        int N;
        N = intents.size();
        {
            int i;
            i = 0;
            {
                Intent intent;
                intent = intents.get(i);
                intent.setExtrasClassLoader(r.activity.getClassLoader());
                r.activity.mFragments.noteStateNotSaved();
                mInstrumentation.callActivityOnNewIntent(r.activity, intent);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int N = intents.size();
        //for (int i=0; i<N; i++) {
            //Intent intent = intents.get(i);
            //intent.setExtrasClassLoader(r.activity.getClassLoader());
            //r.activity.mFragments.noteStateNotSaved();
            //mInstrumentation.callActivityOnNewIntent(r.activity, intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.253 -0400", hash_original_method = "62C39F1A7060D00626ABC1EA40393902", hash_generated_method = "48498FEC3520443D4DE96BC74E9095BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void performNewIntents(IBinder token,
            List<Intent> intents) {
        dsTaint.addTaint(intents.dsTaint);
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            boolean resumed;
            resumed = !r.paused;
            {
                r.activity.mTemporaryPause = true;
                mInstrumentation.callActivityOnPause(r.activity);
            } //End block
            deliverNewIntents(r, intents);
            {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r != null) {
            //final boolean resumed = !r.paused;
            //if (resumed) {
                //r.activity.mTemporaryPause = true;
                //mInstrumentation.callActivityOnPause(r.activity);
            //}
            //deliverNewIntents(r, intents);
            //if (resumed) {
                //r.activity.performResume();
                //r.activity.mTemporaryPause = false;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.256 -0400", hash_original_method = "3340D70EC7FD056C28E3BD0AF1C7CC94", hash_generated_method = "7A2AB4C82C1C3822EC5B000259A502DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleNewIntent(NewIntentData data) {
        dsTaint.addTaint(data.dsTaint);
        performNewIntents(data.token, data.intents);
        // ---------- Original Method ----------
        //performNewIntents(data.token, data.intents);
    }

    
        public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.260 -0400", hash_original_method = "3D8204A3B4D4C5B7C8FEA568D86F5418", hash_generated_method = "C192B84AD9F324DDAA215EDBB94FCC46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleReceiver(ReceiverData data) {
        dsTaint.addTaint(data.dsTaint);
        unscheduleGcIdler();
        String component;
        component = data.intent.getComponent().getClassName();
        LoadedApk packageInfo;
        packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        IActivityManager mgr;
        mgr = ActivityManagerNative.getDefault();
        BroadcastReceiver receiver;
        try 
        {
            java.lang.ClassLoader cl;
            cl = packageInfo.getClassLoader();
            data.intent.setExtrasClassLoader(cl);
            data.setExtrasClassLoader(cl);
            receiver = (BroadcastReceiver)cl.loadClass(component).newInstance();
        } //End block
        catch (Exception e)
        {
            data.sendFinished(mgr);
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                "Unable to instantiate receiver " + component
                + ": " + e.toString(), e);
        } //End block
        try 
        {
            Application app;
            app = packageInfo.makeApplication(false, mInstrumentation);
            ContextImpl context;
            context = (ContextImpl)app.getBaseContext();
            sCurrentBroadcastIntent.set(data.intent);
            receiver.setPendingResult(data);
            receiver.onReceive(context.getReceiverRestrictedContext(),
                    data.intent);
        } //End block
        catch (Exception e)
        {
            data.sendFinished(mgr);
            {
                boolean varE107D295AE6781FEBA130F0CDDDA8A51_269052111 = (!mInstrumentation.onException(receiver, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to start receiver " + component
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            sCurrentBroadcastIntent.set(null);
        } //End block
        {
            boolean var198BEFC4677783C257791C95882C8BD8_148250640 = (receiver.getPendingResult() != null);
            {
                data.finish();
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.261 -0400", hash_original_method = "F9FD1947DE4D383F90C08BC5B81CEB33", hash_generated_method = "933E1BE093F9C694B73FC78615A4CBBC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCreateBackupAgent(CreateBackupAgentData data) {
        dsTaint.addTaint(data.dsTaint);
        unscheduleGcIdler();
        LoadedApk packageInfo;
        packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName;
        packageName = packageInfo.mPackageName;
        {
            boolean var2036584F8EC354D6E6901E916B116B68_415533272 = (mBackupAgents.get(packageName) != null);
            {
                Slog.d(TAG, "BackupAgent " + "  for " + packageName
                    + " already exists");
            } //End block
        } //End collapsed parenthetic
        BackupAgent agent;
        agent = null;
        String classname;
        classname = data.appInfo.backupAgentName;
        {
            classname = "android.app.backup.FullBackupAgent";
        } //End block
        try 
        {
            IBinder binder;
            binder = null;
            try 
            {
                java.lang.ClassLoader cl;
                cl = packageInfo.getClassLoader();
                agent = (BackupAgent) cl.loadClass(classname).newInstance();
                ContextImpl context;
                context = new ContextImpl();
                context.init(packageInfo, null, this);
                context.setOuterContext(agent);
                agent.attach(context);
                agent.onCreate();
                binder = agent.onBind();
                mBackupAgents.put(packageName, agent);
            } //End block
            catch (Exception e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
            } //End block
            try 
            {
                ActivityManagerNative.getDefault().backupAgentCreated(packageName, binder);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unable to create BackupAgent "
                    + classname + ": " + e.toString(), e);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.262 -0400", hash_original_method = "F45834CE0FCB2021DEF63803688239C3", hash_generated_method = "D9C05465C7CC9D3C708C4F2C8319EBA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDestroyBackupAgent(CreateBackupAgentData data) {
        dsTaint.addTaint(data.dsTaint);
        LoadedApk packageInfo;
        packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName;
        packageName = packageInfo.mPackageName;
        BackupAgent agent;
        agent = mBackupAgents.get(packageName);
        {
            try 
            {
                agent.onDestroy();
            } //End block
            catch (Exception e)
            {
                e.printStackTrace();
            } //End block
            mBackupAgents.remove(packageName);
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG_BACKUP) Slog.v(TAG, "handleDestroyBackupAgent: " + data);
        //LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        //String packageName = packageInfo.mPackageName;
        //BackupAgent agent = mBackupAgents.get(packageName);
        //if (agent != null) {
            //try {
                //agent.onDestroy();
            //} catch (Exception e) {
                //Slog.w(TAG, "Exception thrown in onDestroy by backup agent of " + data.appInfo);
                //e.printStackTrace();
            //}
            //mBackupAgents.remove(packageName);
        //} else {
            //Slog.w(TAG, "Attempt to destroy unknown backup agent " + data);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.263 -0400", hash_original_method = "77CEB6B4E506F7F39264B1FEFD4EC387", hash_generated_method = "5CF4BB90B8BE308C01F161AD826A91C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleCreateService(CreateServiceData data) {
        dsTaint.addTaint(data.dsTaint);
        unscheduleGcIdler();
        LoadedApk packageInfo;
        packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        Service service;
        service = null;
        try 
        {
            java.lang.ClassLoader cl;
            cl = packageInfo.getClassLoader();
            service = (Service) cl.loadClass(data.info.name).newInstance();
        } //End block
        catch (Exception e)
        {
            {
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_2001433855 = (!mInstrumentation.onException(service, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate service " + data.info.name
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            ContextImpl context;
            context = new ContextImpl();
            context.init(packageInfo, null, this);
            Application app;
            app = packageInfo.makeApplication(false, mInstrumentation);
            context.setOuterContext(service);
            service.attach(context, this, data.info.name, data.token, app,
                    ActivityManagerNative.getDefault());
            service.onCreate();
            mServices.put(data.token, service);
            try 
            {
                ActivityManagerNative.getDefault().serviceDoneExecuting(
                        data.token, 0, 0, 0);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        catch (Exception e)
        {
            {
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_1179186366 = (!mInstrumentation.onException(service, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to create service " + data.info.name
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.264 -0400", hash_original_method = "881D5FBA45CBA067F129D10745838607", hash_generated_method = "2C542269A06E278AC1C3EC502D9EA190")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleBindService(BindServiceData data) {
        dsTaint.addTaint(data.dsTaint);
        Service s;
        s = mServices.get(data.token);
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                try 
                {
                    {
                        IBinder binder;
                        binder = s.onBind(data.intent);
                        ActivityManagerNative.getDefault().publishService(
                                data.token, data.intent, binder);
                    } //End block
                    {
                        s.onRebind(data.intent);
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } //End block
                    ensureJitEnabled();
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_424923596 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to bind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.265 -0400", hash_original_method = "2796BE6EE721B85B28BB6DBD3B4C5C51", hash_generated_method = "E3DB17CB2B41327E7FCF9B6797969178")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleUnbindService(BindServiceData data) {
        dsTaint.addTaint(data.dsTaint);
        Service s;
        s = mServices.get(data.token);
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                boolean doRebind;
                doRebind = s.onUnbind(data.intent);
                try 
                {
                    {
                        ActivityManagerNative.getDefault().unbindFinished(
                                data.token, data.intent, doRebind);
                    } //End block
                    {
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } //End block
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_27268468 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to unbind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.265 -0400", hash_original_method = "1C18D37F75673CCCBD9C372D3BFFD82C", hash_generated_method = "DD9A46CD3FE5F6EB27775B17D4AE2A7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDumpService(DumpComponentInfo info) {
        dsTaint.addTaint(info.dsTaint);
        Service s;
        s = mServices.get(info.token);
        {
            PrintWriter pw;
            pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            s.dump(info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } //End block
            catch (IOException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //Service s = mServices.get(info.token);
        //if (s != null) {
            //PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            //s.dump(info.fd.getFileDescriptor(), pw, info.args);
            //pw.flush();
            //try {
                //info.fd.close();
            //} catch (IOException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.266 -0400", hash_original_method = "126292FF06E700D8C53E21C56EE062B7", hash_generated_method = "F40072236F20C8AA3BC0F0D7E24068BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDumpActivity(DumpComponentInfo info) {
        dsTaint.addTaint(info.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(info.token);
        {
            PrintWriter pw;
            pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            r.activity.dump(info.prefix, info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } //End block
            catch (IOException e)
            { }
        } //End block
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(info.token);
        //if (r != null && r.activity != null) {
            //PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            //r.activity.dump(info.prefix, info.fd.getFileDescriptor(), pw, info.args);
            //pw.flush();
            //try {
                //info.fd.close();
            //} catch (IOException e) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.267 -0400", hash_original_method = "7729FDAE3B00ADA3C236E33577FF6666", hash_generated_method = "C14FD6E9CE4910DB42FBAA6EE062EE37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleServiceArgs(ServiceArgsData data) {
        dsTaint.addTaint(data.dsTaint);
        Service s;
        s = mServices.get(data.token);
        {
            try 
            {
                {
                    data.args.setExtrasClassLoader(s.getClassLoader());
                } //End block
                int res;
                {
                    res = s.onStartCommand(data.args, data.flags, data.startId);
                } //End block
                {
                    s.onTaskRemoved(data.args);
                    res = Service.START_TASK_REMOVED_COMPLETE;
                } //End block
                QueuedWork.waitToFinish();
                try 
                {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            data.token, 1, data.startId, res);
                } //End block
                catch (RemoteException e)
                { }
                ensureJitEnabled();
            } //End block
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_624925142 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to start service " + s
                            + " with " + data.args + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.268 -0400", hash_original_method = "E9A561F96B3BEE10BDD2A8F223813D32", hash_generated_method = "FBC8AE3395F80B843C1847C6E0D97E36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleStopService(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        Service s;
        s = mServices.remove(token);
        {
            try 
            {
                s.onDestroy();
                Context context;
                context = s.getBaseContext();
                {
                    String who;
                    who = s.getClassName();
                    ((ContextImpl) context).scheduleFinalCleanup(who, "Service");
                } //End block
                QueuedWork.waitToFinish();
                try 
                {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            token, 0, 0, 0);
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_411247499 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to stop service " + s
                            + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.269 -0400", hash_original_method = "821CC6EDFD77BBF57472742A46BD9804", hash_generated_method = "DAFC1FD92DFE954630AEE86963316327")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ActivityClientRecord performResumeActivity(IBinder token,
            boolean clearHide) {
        dsTaint.addTaint(clearHide);
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            {
                r.hideForNow = false;
                r.activity.mStartedActivity = false;
            } //End block
            try 
            {
                {
                    deliverNewIntents(r, r.pendingIntents);
                    r.pendingIntents = null;
                } //End block
                {
                    deliverResults(r, r.pendingResults);
                    r.pendingResults = null;
                } //End block
                r.activity.performResume();
                EventLog.writeEvent(LOG_ON_RESUME_CALLED,
                        r.activity.getComponentName().getClassName());
                r.paused = false;
                r.stopped = false;
                r.state = null;
            } //End block
            catch (Exception e)
            {
                {
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_632255942 = (!mInstrumentation.onException(r.activity, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to resume activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        return (ActivityClientRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.269 -0400", hash_original_method = "3389EE310594E6487CC378BBAF5D49AF", hash_generated_method = "577DEE0368552E8DD299B24B6099F3B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void cleanUpPendingRemoveWindows(ActivityClientRecord r) {
        dsTaint.addTaint(r.dsTaint);
        {
            r.mPendingRemoveWindowManager.removeViewImmediate(r.mPendingRemoveWindow);
            IBinder wtoken;
            wtoken = r.mPendingRemoveWindow.getWindowToken();
            {
                WindowManagerImpl.getDefault().closeAll(wtoken,
                        r.activity.getClass().getName(), "Activity");
            } //End block
        } //End block
        r.mPendingRemoveWindow = null;
        r.mPendingRemoveWindowManager = null;
        // ---------- Original Method ----------
        //if (r.mPendingRemoveWindow != null) {
            //r.mPendingRemoveWindowManager.removeViewImmediate(r.mPendingRemoveWindow);
            //IBinder wtoken = r.mPendingRemoveWindow.getWindowToken();
            //if (wtoken != null) {
                //WindowManagerImpl.getDefault().closeAll(wtoken,
                        //r.activity.getClass().getName(), "Activity");
            //}
        //}
        //r.mPendingRemoveWindow = null;
        //r.mPendingRemoveWindowManager = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.271 -0400", hash_original_method = "E7E626438598608F65C9E3AAFD52E1D3", hash_generated_method = "3E257951927F917883CB109A4CD28382")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
        dsTaint.addTaint(clearHide);
        dsTaint.addTaint(isForward);
        dsTaint.addTaint(token.dsTaint);
        unscheduleGcIdler();
        ActivityClientRecord r;
        r = performResumeActivity(token, clearHide);
        {
            Activity a;
            a = r.activity;
            int forwardBit;
            forwardBit = WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
            forwardBit = 0;
            boolean willBeVisible;
            willBeVisible = !a.mStartedActivity;
            {
                try 
                {
                    willBeVisible = ActivityManagerNative.getDefault().willActivityBeVisible(
                            a.getActivityToken());
                } //End block
                catch (RemoteException e)
                { }
            } //End block
            {
                r.window = r.activity.getWindow();
                View decor;
                decor = r.window.getDecorView();
                decor.setVisibility(View.INVISIBLE);
                ViewManager wm;
                wm = a.getWindowManager();
                WindowManager.LayoutParams l;
                l = r.window.getAttributes();
                a.mDecor = decor;
                l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
                l.softInputMode |= forwardBit;
                {
                    a.mWindowAdded = true;
                    wm.addView(decor, l);
                } //End block
            } //End block
            {
                r.hideForNow = true;
            } //End block
            cleanUpPendingRemoveWindows(r);
            {
                {
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } //End block
                WindowManager.LayoutParams l;
                l = r.window.getAttributes();
                {
                    l.softInputMode = (l.softInputMode
                            & (~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION))
                            | forwardBit;
                    {
                        ViewManager wm;
                        wm = a.getWindowManager();
                        View decor;
                        decor = r.window.getDecorView();
                        wm.updateViewLayout(decor, l);
                    } //End block
                } //End block
                r.activity.mVisibleFromServer = true;
                {
                    r.activity.makeVisible();
                } //End block
            } //End block
            {
                r.nextIdle = mNewActivities;
                mNewActivities = r;
                Looper.myQueue().addIdleHandler(new Idler());
            } //End block
            r.onlyLocalRequest = false;
        } //End block
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(token, Activity.RESULT_CANCELED, null);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.272 -0400", hash_original_method = "DA54714D7ABECA1149DF2EBB4CB12B75", hash_generated_method = "1342CAB481F5396E2A1D966E65C457F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Bitmap createThumbnailBitmap(ActivityClientRecord r) {
        dsTaint.addTaint(r.dsTaint);
        Bitmap thumbnail;
        thumbnail = mAvailThumbnailBitmap;
        try 
        {
            {
                int w;
                w = mThumbnailWidth;
                int h;
                {
                    Resources res;
                    res = r.activity.getResources();
                    mThumbnailHeight = h =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_height);
                    mThumbnailWidth = w =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_width);
                } //End block
                {
                    h = mThumbnailHeight;
                } //End block
                {
                    thumbnail = Bitmap.createBitmap(w, h, THUMBNAIL_FORMAT);
                    thumbnail.eraseColor(0);
                } //End block
            } //End block
            {
                Canvas cv;
                cv = mThumbnailCanvas;
                {
                    mThumbnailCanvas = cv = new Canvas();
                } //End block
                cv.setBitmap(thumbnail);
                {
                    boolean varCCF6BFA25B9B33C500993008D9DBEDE9_1699529753 = (!r.activity.onCreateThumbnail(thumbnail, cv));
                    {
                        mAvailThumbnailBitmap = thumbnail;
                        thumbnail = null;
                    } //End block
                } //End collapsed parenthetic
                cv.setBitmap(null);
            } //End block
        } //End block
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_135773730 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create thumbnail of "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
            thumbnail = null;
        } //End block
        return (Bitmap)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.273 -0400", hash_original_method = "E5BE16D2C462200A7B0F213AB5290C46", hash_generated_method = "36C014592EBA1367CB61700654840FAD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handlePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(userLeaving);
        dsTaint.addTaint(finished);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            {
                performUserLeavingActivity(r);
            } //End block
            r.activity.mConfigChangeFlags |= configChanges;
            performPauseActivity(token, finished, r.isPreHoneycomb());
            {
                boolean varC0947985E80A11FEDC8508BAA28B8037_2112015713 = (r.isPreHoneycomb());
                {
                    QueuedWork.waitToFinish();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                ActivityManagerNative.getDefault().activityPaused(token);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r != null) {
            //if (userLeaving) {
                //performUserLeavingActivity(r);
            //}
            //r.activity.mConfigChangeFlags |= configChanges;
            //performPauseActivity(token, finished, r.isPreHoneycomb());
            //if (r.isPreHoneycomb()) {
                //QueuedWork.waitToFinish();
            //}
            //try {
                //ActivityManagerNative.getDefault().activityPaused(token);
            //} catch (RemoteException ex) {
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.274 -0400", hash_original_method = "E51B505D442E84A2F592A34137ABD72B", hash_generated_method = "E405FEFC9B6938DE72404119FE223B91")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performUserLeavingActivity(ActivityClientRecord r) {
        dsTaint.addTaint(r.dsTaint);
        mInstrumentation.callActivityOnUserLeaving(r.activity);
        // ---------- Original Method ----------
        //mInstrumentation.callActivityOnUserLeaving(r.activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.278 -0400", hash_original_method = "2E97B5DEF88E402FCA1661B4F9DB23CB", hash_generated_method = "0A76F5799AED2A01840DCDB889F57069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Bundle performPauseActivity(IBinder token, boolean finished,
            boolean saveState) {
        dsTaint.addTaint(saveState);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(finished);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            Object var9DCB9D92CE7FFCE5C4C75923E1D0464E_656220540 = (performPauseActivity(r, finished, saveState));
        } //End flattened ternary
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //return r != null ? performPauseActivity(r, finished, saveState) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.279 -0400", hash_original_method = "48F314FABF09550D34AFCF3A61EA40AB", hash_generated_method = "334B6C1021006032A044DBB0E8652A19")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Bundle performPauseActivity(ActivityClientRecord r, boolean finished,
            boolean saveState) {
        dsTaint.addTaint(saveState);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(finished);
        {
            RuntimeException e;
            e = new RuntimeException(
                    "Performing pause of activity that is not resumed: "
                    + r.intent.getComponent().toShortString());
        } //End block
        Bundle state;
        state = null;
        {
            r.activity.mFinished = true;
        } //End block
        try 
        {
            {
                state = new Bundle();
                state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                r.state = state;
            } //End block
            r.activity.mCalled = false;
            mInstrumentation.callActivityOnPause(r.activity);
            EventLog.writeEvent(LOG_ON_PAUSE_CALLED, r.activity.getComponentName().getClassName());
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                    "Activity " + r.intent.getComponent().toShortString() +
                    " did not call through to super.onPause()");
            } //End block
        } //End block
        catch (SuperNotCalledException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } //End block
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_1645317868 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to pause activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        r.paused = true;
        ArrayList<OnActivityPausedListener> listeners;
        {
            listeners = mOnPauseListeners.remove(r.activity);
        } //End block
        int size;
        size = (listeners != null ? listeners.size() : 0);//DSFIXME:  CODE0008: Nested ternary operator in expression
        {
            int i;
            i = 0;
            {
                listeners.get(i).onPaused(r.activity);
            } //End block
        } //End collapsed parenthetic
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.280 -0400", hash_original_method = "16A67002319514C641569BB2AD572A0E", hash_generated_method = "4C2DD8143A07E7B84561B58CC4346789")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performStopActivity(IBinder token, boolean saveState) {
        dsTaint.addTaint(saveState);
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        performStopActivityInner(r, null, false, saveState);
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //performStopActivityInner(r, null, false, saveState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.281 -0400", hash_original_method = "9D7845EB7E019C62C91AEEFF3F12D0E4", hash_generated_method = "6896C2B92C10136F116793FCA0DF09A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void performStopActivityInner(ActivityClientRecord r,
            StopInfo info, boolean keepShown, boolean saveState) {
        dsTaint.addTaint(saveState);
        dsTaint.addTaint(keepShown);
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(info.dsTaint);
        Bundle state;
        state = null;
        {
            {
                RuntimeException e;
                e = new RuntimeException(
                        "Performing stop of activity that is not resumed: "
                        + r.intent.getComponent().toShortString());
            } //End block
            {
                try 
                {
                    info.thumbnail = null;
                    info.description = r.activity.onCreateDescription();
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1282458295 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to save state of activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                {
                    state = new Bundle();
                    state.setAllowFds(false);
                    mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                    r.state = state;
                } //End block
                {
                    state = r.state;
                } //End block
            } //End block
            {
                try 
                {
                    r.activity.performStop();
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_2102924441 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                r.stopped = true;
            } //End block
            r.paused = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.282 -0400", hash_original_method = "A6B6099E264273A69E686CA5F8880A0F", hash_generated_method = "006C425F41F89F57330DF64A1147E61A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void updateVisibility(ActivityClientRecord r, boolean show) {
        dsTaint.addTaint(r.dsTaint);
        dsTaint.addTaint(show);
        View v;
        v = r.activity.mDecor;
        {
            {
                {
                    r.activity.mVisibleFromServer = true;
                    {
                        r.activity.makeVisible();
                    } //End block
                } //End block
                {
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } //End block
            } //End block
            {
                {
                    r.activity.mVisibleFromServer = false;
                    v.setVisibility(View.INVISIBLE);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.283 -0400", hash_original_method = "5B5FF681D8D2131B5D84BD48CB5679C6", hash_generated_method = "6177A72EDAB6ADF4FE49AD4C84F0CF47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleStopActivity(IBinder token, boolean show, int configChanges) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(show);
        ActivityClientRecord r;
        r = mActivities.get(token);
        r.activity.mConfigChangeFlags |= configChanges;
        StopInfo info;
        info = new StopInfo();
        performStopActivityInner(r, info, show, true);
        updateVisibility(r, show);
        {
            boolean varF98050B23FC967ED8AC6A2F93F8DF261_1549811406 = (!r.isPreHoneycomb());
            {
                QueuedWork.waitToFinish();
            } //End block
        } //End collapsed parenthetic
        try 
        {
            ActivityManagerNative.getDefault().activityStopped(
                r.token, r.state, info.thumbnail, info.description);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //r.activity.mConfigChangeFlags |= configChanges;
        //StopInfo info = new StopInfo();
        //performStopActivityInner(r, info, show, true);
        //if (localLOGV) Slog.v(
            //TAG, "Finishing stop of " + r + ": show=" + show
            //+ " win=" + r.window);
        //updateVisibility(r, show);
        //if (!r.isPreHoneycomb()) {
            //QueuedWork.waitToFinish();
        //}
        //try {
            //ActivityManagerNative.getDefault().activityStopped(
                //r.token, r.state, info.thumbnail, info.description);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.284 -0400", hash_original_method = "F0D1B8DFE218B8E130C145F907A20AA2", hash_generated_method = "0A48E883C892310519F9031B501EF7AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void performRestartActivity(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            r.activity.performRestart();
            r.stopped = false;
        } //End block
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r.stopped) {
            //r.activity.performRestart();
            //r.stopped = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.285 -0400", hash_original_method = "6AC1F9C414377243EFD072AEBA5D0138", hash_generated_method = "E7B97312F8AE05BDA6AEEA500B1F3748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleWindowVisibility(IBinder token, boolean show) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(show);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            performStopActivityInner(r, null, show, false);
        } //End block
        {
            unscheduleGcIdler();
            r.activity.performRestart();
            r.stopped = false;
        } //End block
        {
            updateVisibility(r, show);
        } //End block
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r == null) {
            //Log.w(TAG, "handleWindowVisibility: no activity for token " + token);
            //return;
        //}
        //if (!show && !r.stopped) {
            //performStopActivityInner(r, null, show, false);
        //} else if (show && r.stopped) {
            //unscheduleGcIdler();
            //r.activity.performRestart();
            //r.stopped = false;
        //}
        //if (r.activity.mDecor != null) {
            //if (false) Slog.v(
                //TAG, "Handle window " + r + " visibility: " + show);
            //updateVisibility(r, show);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.288 -0400", hash_original_method = "EAD4881422CEC6751FCD8576FDC7454E", hash_generated_method = "98612ABEE03A9467CC57F38C1855CDAF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSleeping(IBinder token, boolean sleeping) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(sleeping);
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            {
                boolean var90CCE8F8E1AD80CE3C0937C3672DBEB8_2111761629 = (!r.stopped && !r.isPreHoneycomb());
                {
                    try 
                    {
                        r.activity.performStop();
                    } //End block
                    catch (Exception e)
                    {
                        {
                            boolean varACA7CC68DADC2688CDBF4B35E8827724_742261489 = (!mInstrumentation.onException(r.activity, e));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    r.stopped = true;
                } //End block
            } //End collapsed parenthetic
            {
                boolean varC7408144C59FFB3C551D3072EB04F87F_888795074 = (!r.isPreHoneycomb());
                {
                    QueuedWork.waitToFinish();
                } //End block
            } //End collapsed parenthetic
            try 
            {
                ActivityManagerNative.getDefault().activitySlept(r.token);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        {
            {
                r.activity.performRestart();
                r.stopped = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.289 -0400", hash_original_method = "E4614A97277DCEBAE71CAB13BCF3AEA6", hash_generated_method = "5828A2403698D23DA3C8C61172B8014E")
    @DSModeled(DSC.SAFE)
    private void handleSetCoreSettings(Bundle coreSettings) {
        dsTaint.addTaint(coreSettings.dsTaint);
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //mCoreSettings = coreSettings;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.290 -0400", hash_original_method = "CFE517344EE2BFA081F85835A58153DF", hash_generated_method = "216B88F869260C36C41EB927CF010D07")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData data) {
        dsTaint.addTaint(data.dsTaint);
        LoadedApk apk;
        apk = peekPackageInfo(data.pkg, false);
        {
            apk.mCompatibilityInfo.set(data.info);
        } //End block
        apk = peekPackageInfo(data.pkg, true);
        {
            apk.mCompatibilityInfo.set(data.info);
        } //End block
        handleConfigurationChanged(mConfiguration, data.info);
        WindowManagerImpl.getDefault().reportNewConfiguration(mConfiguration);
        // ---------- Original Method ----------
        //LoadedApk apk = peekPackageInfo(data.pkg, false);
        //if (apk != null) {
            //apk.mCompatibilityInfo.set(data.info);
        //}
        //apk = peekPackageInfo(data.pkg, true);
        //if (apk != null) {
            //apk.mCompatibilityInfo.set(data.info);
        //}
        //handleConfigurationChanged(mConfiguration, data.info);
        //WindowManagerImpl.getDefault().reportNewConfiguration(mConfiguration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.291 -0400", hash_original_method = "02C0B6EC41B1BF345DD1D4B6B6C7E1EA", hash_generated_method = "DFC2CD16A8697A8BF1A44BD8E3123577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(r.dsTaint);
        int N;
        N = results.size();
        {
            int i;
            i = 0;
            {
                ResultInfo ri;
                ri = results.get(i);
                try 
                {
                    {
                        ri.mData.setExtrasClassLoader(r.activity.getClassLoader());
                    } //End block
                    r.activity.dispatchActivityResult(ri.mResultWho,
                        ri.mRequestCode, ri.mResultCode, ri.mData);
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_772468008 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Failure delivering result " + ri + " to activity "
                            + r.intent.getComponent().toShortString()
                            + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.293 -0400", hash_original_method = "132B22472693443B534F2F702D692F04", hash_generated_method = "AD5590C6110A28FEB129C254C8FBC98C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleSendResult(ResultData res) {
        dsTaint.addTaint(res.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(res.token);
        {
            boolean resumed;
            resumed = !r.paused;
            {
                updateVisibility(r, true);
            } //End block
            {
                try 
                {
                    r.activity.mCalled = false;
                    r.activity.mTemporaryPause = true;
                    mInstrumentation.callActivityOnPause(r.activity);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString()
                            + " did not call through to super.onPause()");
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1779931347 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            deliverResults(r, res.results);
            {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.295 -0400", hash_original_method = "44788E1192B2AF3D6F2EAE0CA2032491", hash_generated_method = "CD1B03AFAAC799572582F0B4921836E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(finishing);
        ActivityClientRecord var524AD4280B7BAAD851CED1EEA2751CF1_793938819 = (performDestroyActivity(token, finishing, 0, false));
        return (ActivityClientRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return performDestroyActivity(token, finishing, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.296 -0400", hash_original_method = "C0523473C414844F9752EDA7A2CAF03B", hash_generated_method = "B00B4ADF66A38AAED5D18BA80B708CCF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(getNonConfigInstance);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(finishing);
        ActivityClientRecord r;
        r = mActivities.get(token);
        Class activityClass;
        activityClass = null;
        {
            activityClass = r.activity.getClass();
            r.activity.mConfigChangeFlags |= configChanges;
            {
                r.activity.mFinished = true;
            } //End block
            {
                try 
                {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    EventLog.writeEvent(LOG_ON_PAUSE_CALLED,
                            r.activity.getComponentName().getClassName());
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + safeToComponentShortString(r.intent)
                            + " did not call through to super.onPause()");
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_2022348609 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                r.paused = true;
            } //End block
            {
                try 
                {
                    r.activity.performStop();
                } //End block
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_632230479 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                r.stopped = true;
            } //End block
            {
                try 
                {
                    r.lastNonConfigurationInstances
                            = r.activity.retainNonConfigurationInstances();
                } //End block
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_895631462 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to retain activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            try 
            {
                r.activity.mCalled = false;
                mInstrumentation.callActivityOnDestroy(r.activity);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                        "Activity " + safeToComponentShortString(r.intent) +
                        " did not call through to super.onDestroy()");
                } //End block
                {
                    r.window.closeAllPanels();
                } //End block
            } //End block
            catch (SuperNotCalledException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } //End block
            catch (Exception e)
            {
                {
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_619605875 = (!mInstrumentation.onException(r.activity, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to destroy activity " + safeToComponentShortString(r.intent)
                            + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        mActivities.remove(token);
        StrictMode.decrementExpectedActivityCount(activityClass);
        return (ActivityClientRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.300 -0400", hash_original_method = "FF5883360F029BC934513AEE9A22C396", hash_generated_method = "E8545E1233C1490FD2225A3D97AAB77C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(getNonConfigInstance);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(finishing);
        ActivityClientRecord r;
        r = performDestroyActivity(token, finishing,
                configChanges, getNonConfigInstance);
        {
            cleanUpPendingRemoveWindows(r);
            WindowManager wm;
            wm = r.activity.getWindowManager();
            View v;
            v = r.activity.mDecor;
            {
                IBinder wtoken;
                wtoken = v.getWindowToken();
                {
                    {
                        r.mPendingRemoveWindow = v;
                        r.mPendingRemoveWindowManager = wm;
                    } //End block
                    {
                        wm.removeViewImmediate(v);
                    } //End block
                } //End block
                {
                    WindowManagerImpl.getDefault().closeAll(wtoken,
                            r.activity.getClass().getName(), "Activity");
                } //End block
                r.activity.mDecor = null;
            } //End block
            {
                WindowManagerImpl.getDefault().closeAll(token,
                        r.activity.getClass().getName(), "Activity");
            } //End block
            Context c;
            c = r.activity.getBaseContext();
            {
                ((ContextImpl) c).scheduleFinalCleanup(
                        r.activity.getClass().getName(), "Activity");
            } //End block
        } //End block
        {
            try 
            {
                ActivityManagerNative.getDefault().activityDestroyed(token);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.302 -0400", hash_original_method = "A011A63AC4A3DA99018317E87A8885A6", hash_generated_method = "17C967057BE605B391C6A9013A801D03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void requestRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config,
            boolean fromServer) {
        dsTaint.addTaint(notResumed);
        dsTaint.addTaint(token.dsTaint);
        dsTaint.addTaint(pendingResults.dsTaint);
        dsTaint.addTaint(configChanges);
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(fromServer);
        dsTaint.addTaint(pendingNewIntents.dsTaint);
        ActivityClientRecord target;
        target = null;
        {
            {
                int i;
                i = 0;
                boolean varA731E4137509ACE9A9EB058DA6597B93_1124344414 = (i<mRelaunchingActivities.size());
                {
                    ActivityClientRecord r;
                    r = mRelaunchingActivities.get(i);
                    {
                        target = r;
                        {
                            {
                                r.pendingResults.addAll(pendingResults);
                            } //End block
                            {
                                r.pendingResults = pendingResults;
                            } //End block
                        } //End block
                        {
                            {
                                r.pendingIntents.addAll(pendingNewIntents);
                            } //End block
                            {
                                r.pendingIntents = pendingNewIntents;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                target = new ActivityClientRecord();
                target.token = token;
                target.pendingResults = pendingResults;
                target.pendingIntents = pendingNewIntents;
                {
                    ActivityClientRecord existing;
                    existing = mActivities.get(token);
                    {
                        target.startsNotResumed = existing.paused;
                    } //End block
                    target.onlyLocalRequest = true;
                } //End block
                mRelaunchingActivities.add(target);
                queueOrSendMessage(H.RELAUNCH_ACTIVITY, target);
            } //End block
            {
                target.startsNotResumed = notResumed;
                target.onlyLocalRequest = false;
            } //End block
            {
                target.createdConfig = config;
            } //End block
            target.pendingConfigChanges |= configChanges;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.303 -0400", hash_original_method = "BE5C8E93A13CCFB0B92460FEFD999D51", hash_generated_method = "6691AC29B4FAD8D5292E10492DCB0196")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRelaunchActivity(ActivityClientRecord tmp) {
        dsTaint.addTaint(tmp.dsTaint);
        unscheduleGcIdler();
        Configuration changedConfig;
        changedConfig = null;
        int configChanges;
        configChanges = 0;
        {
            int N;
            N = mRelaunchingActivities.size();
            IBinder token;
            token = tmp.token;
            tmp = null;
            {
                int i;
                i = 0;
                {
                    ActivityClientRecord r;
                    r = mRelaunchingActivities.get(i);
                    {
                        tmp = r;
                        configChanges |= tmp.pendingConfigChanges;
                        mRelaunchingActivities.remove(i);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                changedConfig = mPendingConfiguration;
                mPendingConfiguration = null;
            } //End block
        } //End block
        {
            {
                boolean var0FC6F86F9662A446DFA38F41BE5B339F_569554725 = (mConfiguration == null
                    || (tmp.createdConfig.isOtherSeqNewer(mConfiguration)
                            && mConfiguration.diff(tmp.createdConfig) != 0));
                {
                    {
                        boolean var1F3B64B07ED4C1BD68FE8B6CE0CE3159_735756468 = (changedConfig == null
                        || tmp.createdConfig.isOtherSeqNewer(changedConfig));
                        {
                            changedConfig = tmp.createdConfig;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            handleConfigurationChanged(changedConfig, null);
        } //End block
        ActivityClientRecord r;
        r = mActivities.get(tmp.token);
        r.activity.mConfigChangeFlags |= configChanges;
        r.onlyLocalRequest = tmp.onlyLocalRequest;
        Intent currentIntent;
        currentIntent = r.activity.mIntent;
        r.activity.mChangingConfigurations = true;
        {
            performPauseActivity(r.token, false, r.isPreHoneycomb());
        } //End block
        {
            boolean var180BDEFD354F97351DFD30CDB936034A_992453861 = (r.state == null && !r.stopped && !r.isPreHoneycomb());
            {
                r.state = new Bundle();
                r.state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, r.state);
            } //End block
        } //End collapsed parenthetic
        handleDestroyActivity(r.token, false, configChanges, true);
        r.activity = null;
        r.window = null;
        r.hideForNow = false;
        r.nextIdle = null;
        {
            {
                r.pendingResults = tmp.pendingResults;
            } //End block
            {
                r.pendingResults.addAll(tmp.pendingResults);
            } //End block
        } //End block
        {
            {
                r.pendingIntents = tmp.pendingIntents;
            } //End block
            {
                r.pendingIntents.addAll(tmp.pendingIntents);
            } //End block
        } //End block
        r.startsNotResumed = tmp.startsNotResumed;
        handleLaunchActivity(r, currentIntent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.304 -0400", hash_original_method = "D80F947211B8AA9FA3600ABD6DD9A5E5", hash_generated_method = "28B0CE284CE3CF890A8D5D7B71852229")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleRequestThumbnail(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        Bitmap thumbnail;
        thumbnail = createThumbnailBitmap(r);
        CharSequence description;
        description = null;
        try 
        {
            description = r.activity.onCreateDescription();
        } //End block
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_1875055368 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create description of activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        try 
        {
            ActivityManagerNative.getDefault().reportThumbnail(
                token, thumbnail, description);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //Bitmap thumbnail = createThumbnailBitmap(r);
        //CharSequence description = null;
        //try {
            //description = r.activity.onCreateDescription();
        //} catch (Exception e) {
            //if (!mInstrumentation.onException(r.activity, e)) {
                //throw new RuntimeException(
                        //"Unable to create description of activity "
                        //+ r.intent.getComponent().toShortString()
                        //+ ": " + e.toString(), e);
            //}
        //}
        //try {
            //ActivityManagerNative.getDefault().reportThumbnail(
                //token, thumbnail, description);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.306 -0400", hash_original_method = "FB356249739137DBEEC4A6A95AF7FF01", hash_generated_method = "3DB2C24B1B9EE881617E7BB78873B611")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<ComponentCallbacks2> collectComponentCallbacksLocked(
            boolean allActivities, Configuration newConfig) {
        dsTaint.addTaint(allActivities);
        dsTaint.addTaint(newConfig.dsTaint);
        ArrayList<ComponentCallbacks2> callbacks;
        callbacks = new ArrayList<ComponentCallbacks2>();
        {
            boolean var861DB40CD6AE57E4F0E83CF55916E1AF_537912605 = (mActivities.size() > 0);
            {
                Iterator<ActivityClientRecord> it;
                it = mActivities.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1003196482 = (it.hasNext());
                    {
                        ActivityClientRecord ar;
                        ar = it.next();
                        Activity a;
                        a = ar.activity;
                        {
                            Configuration thisConfig;
                            thisConfig = applyConfigCompatMainThread(newConfig,
                            ar.packageInfo.mCompatibilityInfo.getIfNeeded());
                            {
                                callbacks.add(a);
                            } //End block
                            {
                                ar.newConfig = thisConfig;
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            boolean var5A1C82E33C6D4B3400958A37BAFF4F9C_435376100 = (mServices.size() > 0);
            {
                Iterator<Service> it;
                it = mServices.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_2018333902 = (it.hasNext());
                    {
                        callbacks.add(it.next());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var164809B4E437753E4C2094F777B6EF33_866255339 = (mLocalProviders.size() > 0);
                {
                    Iterator<ProviderClientRecord> it;
                    it = mLocalProviders.values().iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_795859181 = (it.hasNext());
                        {
                            callbacks.add(it.next().mLocalProvider);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        int N;
        N = mAllApplications.size();
        {
            int i;
            i = 0;
            {
                callbacks.add(mAllApplications.get(i));
            } //End block
        } //End collapsed parenthetic
        return (ArrayList<ComponentCallbacks2>)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.306 -0400", hash_original_method = "EE8F576B02EBE8F159FE2A319294FB0B", hash_generated_method = "214C57B576C1F6F34263474A11ECD1DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private final void performConfigurationChanged(
            ComponentCallbacks2 cb, Configuration config) {
        dsTaint.addTaint(cb.dsTaint);
        dsTaint.addTaint(config.dsTaint);
        Activity activity;
        activity = (Activity) cb;
        activity = null;
        {
            activity.mCalled = false;
        } //End block
        boolean shouldChangeConfig;
        shouldChangeConfig = false;
        {
            shouldChangeConfig = true;
        } //End block
        {
            int diff;
            diff = activity.mCurrentConfig.diff(config);
            {
                {
                    boolean varF0E6ABDF26E6C0B0FD2D021EE0A6E062_1953754791 = ((~activity.mActivityInfo.getRealConfigChanged() & diff) == 0);
                    {
                        shouldChangeConfig = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            cb.onConfigurationChanged(config);
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + activity.getLocalClassName() +
                        " did not call through to super.onConfigurationChanged()");
                } //End block
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(config);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.307 -0400", hash_original_method = "7998F4E95C6128D4C656838AA6A46FDD", hash_generated_method = "441028BFFC17E8F7637476838F3E17A6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void applyConfigurationToResources(Configuration config) {
        dsTaint.addTaint(config.dsTaint);
        {
            applyConfigurationToResourcesLocked(config, null);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //applyConfigurationToResourcesLocked(config, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.308 -0400", hash_original_method = "EEF98A9F112FD55BEEF8F44AEC4B59F9", hash_generated_method = "120A18BFA200A14EFB93984A93FDDEE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final boolean applyConfigurationToResourcesLocked(Configuration config,
            CompatibilityInfo compat) {
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(compat.dsTaint);
        {
            mResConfiguration = new Configuration();
        } //End block
        {
            boolean varDD88D6DA3508C081DB3FE4EFF9E62042_1823029457 = (!mResConfiguration.isOtherSeqNewer(config) && compat == null);
        } //End collapsed parenthetic
        int changes;
        changes = mResConfiguration.updateFrom(config);
        DisplayMetrics dm;
        dm = getDisplayMetricsLocked(null, true);
        {
            boolean var389DB0238F3963595A3670D175566873_1756458775 = (compat != null && (mResCompatibilityInfo == null ||
                !mResCompatibilityInfo.equals(compat)));
            {
                changes |= ActivityInfo.CONFIG_SCREEN_LAYOUT
                    | ActivityInfo.CONFIG_SCREEN_SIZE
                    | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
            } //End block
        } //End collapsed parenthetic
        {
            Locale.setDefault(config.locale);
        } //End block
        Resources.updateSystemConfiguration(config, dm, compat);
        ApplicationPackageManager.configurationChanged();
        Iterator<WeakReference<Resources>> it;
        it = mActiveResources.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_332882455 = (it.hasNext());
            {
                WeakReference<Resources> v;
                v = it.next();
                Resources r;
                r = v.get();
                {
                    r.updateConfiguration(config, dm, compat);
                } //End block
                {
                    it.remove();
                } //End block
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.309 -0400", hash_original_method = "725924C293B055D0DF33B7EFFEB77D1D", hash_generated_method = "941F5960FA89FA0C52534A17E3E7E0F8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final Configuration applyCompatConfiguration() {
        Configuration config;
        config = mConfiguration;
        {
            mCompatConfiguration = new Configuration();
        } //End block
        mCompatConfiguration.setTo(mConfiguration);
        {
            boolean varC23E243EBF9A9F6453914CEF4EFB48AF_1043654986 = (mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen());
            {
                mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
                config = mCompatConfiguration;
            } //End block
        } //End collapsed parenthetic
        return (Configuration)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Configuration config = mConfiguration;
        //if (mCompatConfiguration == null) {
            //mCompatConfiguration = new Configuration();
        //}
        //mCompatConfiguration.setTo(mConfiguration);
        //if (mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen()) {
            //mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
            //config = mCompatConfiguration;
        //}
        //return config;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.310 -0400", hash_original_method = "113EE31E90E397ADB444BCE89226F34D", hash_generated_method = "9488D980E785E5CE828784D763F1EBAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleConfigurationChanged(Configuration config, CompatibilityInfo compat) {
        dsTaint.addTaint(config.dsTaint);
        dsTaint.addTaint(compat.dsTaint);
        ArrayList<ComponentCallbacks2> callbacks;
        callbacks = null;
        {
            {
                {
                    boolean var7FB57B73DAED6E7419FC890952146106_344399585 = (!mPendingConfiguration.isOtherSeqNewer(config));
                    {
                        config = mPendingConfiguration;
                    } //End block
                } //End collapsed parenthetic
                mPendingConfiguration = null;
            } //End block
            applyConfigurationToResourcesLocked(config, compat);
            {
                mConfiguration = new Configuration();
            } //End block
            {
                boolean var76764A772B13C26291B0BB9B4382DB3B_1483636194 = (!mConfiguration.isOtherSeqNewer(config) && compat == null);
            } //End collapsed parenthetic
            mConfiguration.updateFrom(config);
            config = applyCompatConfiguration();
            callbacks = collectComponentCallbacksLocked(false, config);
        } //End block
        WindowManagerImpl.getDefault().trimLocalMemory();
        {
            int N;
            N = callbacks.size();
            {
                int i;
                i = 0;
                {
                    performConfigurationChanged(callbacks.get(i), config);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.311 -0400", hash_original_method = "BCC706E36DA945D7B18FA237C2CE8FDE", hash_generated_method = "66A75FB8F3AAA2EA0271F6867F201D77")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleActivityConfigurationChanged(IBinder token) {
        dsTaint.addTaint(token.dsTaint);
        ActivityClientRecord r;
        r = mActivities.get(token);
        performConfigurationChanged(r.activity, mCompatConfiguration);
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r == null || r.activity == null) {
            //return;
        //}
        //if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handle activity config changed: "
                //+ r.activityInfo.name);
        //performConfigurationChanged(r.activity, mCompatConfiguration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.312 -0400", hash_original_method = "381D38D2D5D4A7D408E3117408C36DEC", hash_generated_method = "14945D35E0E47ABBB2EC78D1F7E18FD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleProfilerControl(boolean start, ProfilerControlData pcd, int profileType) {
        dsTaint.addTaint(profileType);
        dsTaint.addTaint(start);
        dsTaint.addTaint(pcd.dsTaint);
        {
            try 
            {
                //Begin case 1 
                ViewDebug.startLooperProfiling(pcd.path, pcd.fd.getFileDescriptor());
                //End case 1 
                //Begin case default 
                mProfiler.setProfiler(pcd.path, pcd.fd);
                //End case default 
                //Begin case default 
                mProfiler.autoStopProfiler = false;
                //End case default 
                //Begin case default 
                mProfiler.startProfiling();
                //End case default 
            } //End block
            catch (RuntimeException e)
            { }
            finally 
            {
                try 
                {
                    pcd.fd.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
        } //End block
        {
            //Begin case 1 
            ViewDebug.stopLooperProfiling();
            //End case 1 
            //Begin case default 
            mProfiler.stopProfiling();
            //End case default 
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.312 -0400", hash_original_method = "34F4499A4B96EEF8A91ACC379A0CD361", hash_generated_method = "C131B4378428D740CCE6E40E5C25C488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleDumpHeap(boolean managed, DumpHeapData dhd) {
        dsTaint.addTaint(managed);
        dsTaint.addTaint(dhd.dsTaint);
        {
            try 
            {
                Debug.dumpHprofData(dhd.path, dhd.fd.getFileDescriptor());
            } //End block
            catch (IOException e)
            { }
            finally 
            {
                try 
                {
                    dhd.fd.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
        } //End block
        {
            Debug.dumpNativeHeap(dhd.fd.getFileDescriptor());
        } //End block
        // ---------- Original Method ----------
        //if (managed) {
            //try {
                //Debug.dumpHprofData(dhd.path, dhd.fd.getFileDescriptor());
            //} catch (IOException e) {
                //Slog.w(TAG, "Managed heap dump failed on path " + dhd.path
                        //+ " -- can the process access this path?");
            //} finally {
                //try {
                    //dhd.fd.close();
                //} catch (IOException e) {
                    //Slog.w(TAG, "Failure closing profile fd", e);
                //}
            //}
        //} else {
            //Debug.dumpNativeHeap(dhd.fd.getFileDescriptor());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.318 -0400", hash_original_method = "44425A5A4DA98E1612A84EA820E43FA0", hash_generated_method = "C60BC86E3006C7D9D25B74CCF43DE820")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleDispatchPackageBroadcast(int cmd, String[] packages) {
        dsTaint.addTaint(cmd);
        dsTaint.addTaint(packages[0]);
        boolean hasPkgInfo;
        hasPkgInfo = false;
        {
            {
                int i;
                i = packages.length-1;
                {
                    {
                        WeakReference<LoadedApk> ref;
                        ref = mPackages.get(packages[i]);
                        {
                            boolean var452303427881308C0907EF2BFCBFBC97_285574187 = (ref != null && ref.get() != null);
                            {
                                hasPkgInfo = true;
                            } //End block
                            {
                                ref = mResourcePackages.get(packages[i]);
                                {
                                    boolean var35FA527C419A116D546FBD420F0F02FA_1007855443 = (ref != null && ref.get() != null);
                                    {
                                        hasPkgInfo = true;
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    mPackages.remove(packages[i]);
                    mResourcePackages.remove(packages[i]);
                } //End block
            } //End collapsed parenthetic
        } //End block
        ApplicationPackageManager.handlePackageBroadcast(cmd, packages,
                hasPkgInfo);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.320 -0400", hash_original_method = "A02231B2047F154A7A69F70A3ED846FE", hash_generated_method = "F3BFC6BC4E16DD092F17DC163FB07167")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleLowMemory() {
        ArrayList<ComponentCallbacks2> callbacks;
        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } //End block
        int N;
        N = callbacks.size();
        {
            int i;
            i = 0;
            {
                callbacks.get(i).onLowMemory();
            } //End block
        } //End collapsed parenthetic
        {
            boolean var83DFAB275ACAE9E6E683928CEC618B77_2146662861 = (Process.myUid() != Process.SYSTEM_UID);
            {
                int sqliteReleased;
                sqliteReleased = SQLiteDatabase.releaseMemory();
                EventLog.writeEvent(SQLITE_MEM_RELEASED_EVENT_LOG_TAG, sqliteReleased);
            } //End block
        } //End collapsed parenthetic
        Canvas.freeCaches();
        BinderInternal.forceGc("mem");
        // ---------- Original Method ----------
        //ArrayList<ComponentCallbacks2> callbacks;
        //synchronized (mPackages) {
            //callbacks = collectComponentCallbacksLocked(true, null);
        //}
        //final int N = callbacks.size();
        //for (int i=0; i<N; i++) {
            //callbacks.get(i).onLowMemory();
        //}
        //if (Process.myUid() != Process.SYSTEM_UID) {
            //int sqliteReleased = SQLiteDatabase.releaseMemory();
            //EventLog.writeEvent(SQLITE_MEM_RELEASED_EVENT_LOG_TAG, sqliteReleased);
        //}
        //Canvas.freeCaches();
        //BinderInternal.forceGc("mem");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.322 -0400", hash_original_method = "23BC0760ADA981D880A84DB7A1CF33BD", hash_generated_method = "DEAEFFE7764DD9ADF86A25C5DEBC3098")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void handleTrimMemory(int level) {
        dsTaint.addTaint(level);
        WindowManagerImpl.getDefault().trimMemory(level);
        ArrayList<ComponentCallbacks2> callbacks;
        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } //End block
        int N;
        N = callbacks.size();
        {
            int i;
            i = 0;
            {
                callbacks.get(i).onTrimMemory(level);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //WindowManagerImpl.getDefault().trimMemory(level);
        //ArrayList<ComponentCallbacks2> callbacks;
        //synchronized (mPackages) {
            //callbacks = collectComponentCallbacksLocked(true, null);
        //}
        //final int N = callbacks.size();
        //for (int i=0; i<N; i++) {
            //callbacks.get(i).onTrimMemory(level);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.325 -0400", hash_original_method = "E6BF73423380262DF6FF59682ACDE1E2", hash_generated_method = "5350D073ADFAEDFE6D88186B5ECCF6C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setupGraphicsSupport(LoadedApk info) {
        dsTaint.addTaint(info.dsTaint);
        try 
        {
            int uid;
            uid = Process.myUid();
            String[] packages;
            packages = getPackageManager().getPackagesForUid(uid);
            {
                ContextImpl appContext;
                appContext = new ContextImpl();
                appContext.init(info, null, this);
                HardwareRenderer.setupDiskCache(appContext.getCacheDir());
            } //End block
        } //End block
        catch (RemoteException e)
        { }
        // ---------- Original Method ----------
        //try {
            //int uid = Process.myUid();
            //String[] packages = getPackageManager().getPackagesForUid(uid);
            //if (packages.length == 1) {
                //ContextImpl appContext = new ContextImpl();
                //appContext.init(info, null, this);
                //HardwareRenderer.setupDiskCache(appContext.getCacheDir());
            //}
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.328 -0400", hash_original_method = "7EBE3C125D399FC9ADE021947462EA9C", hash_generated_method = "0E8A8632BC05A464B6E00E68AD2A45AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void handleBindApplication(AppBindData data) {
        dsTaint.addTaint(data.dsTaint);
        mConfiguration = new Configuration(data.config);
        mCompatConfiguration = new Configuration(data.config);
        mProfiler = new Profiler();
        mProfiler.profileFile = data.initProfileFile;
        mProfiler.profileFd = data.initProfileFd;
        mProfiler.autoStopProfiler = data.initAutoStopProfiler;
        Process.setArgV0(data.processName);
        android.ddm.DdmHandleAppName.setAppName(data.processName);
        {
            Display display;
            display = WindowManagerImpl.getDefault().getDefaultDisplay();
            {
                boolean varF43CCBE6F4C0623498FA3D729EBA95BA_381026472 = (!ActivityManager.isHighEndGfx(display));
                {
                    HardwareRenderer.disable(false);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mProfiler.startProfiling();
        } //End block
        {
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } //End block
        TimeZone.setDefault(null);
        Locale.setDefault(data.config.locale);
        applyConfigurationToResourcesLocked(data.config, data.compatInfo);
        applyCompatConfiguration();
        data.info = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        setupGraphicsSupport(data.info);
        {
            StrictMode.conditionallyEnableDebugLogging();
        } //End block
        {
            StrictMode.enableDeathOnNetwork();
        } //End block
        {
            Bitmap.setDefaultDensity(DisplayMetrics.DENSITY_DEFAULT);
        } //End block
        {
            Debug.changeDebugPort(8100);
            {
                IActivityManager mgr;
                mgr = ActivityManagerNative.getDefault();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, true);
                } //End block
                catch (RemoteException ex)
                { }
                Debug.waitForDebugger();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, false);
                } //End block
                catch (RemoteException ex)
                { }
            } //End block
        } //End block
        IBinder b;
        b = ServiceManager.getService(Context.CONNECTIVITY_SERVICE);
        {
            IConnectivityManager service;
            service = IConnectivityManager.Stub.asInterface(b);
            try 
            {
                ProxyProperties proxyProperties;
                proxyProperties = service.getProxy();
                Proxy.setHttpProxySystemProperty(proxyProperties);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        {
            ContextImpl appContext;
            appContext = new ContextImpl();
            appContext.init(data.info, null, this);
            InstrumentationInfo ii;
            ii = null;
            try 
            {
                ii = appContext.getPackageManager().
                    getInstrumentationInfo(data.instrumentationName, 0);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            { }
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to find instrumentation info for: "
                    + data.instrumentationName);
            } //End block
            mInstrumentationAppDir = ii.sourceDir;
            mInstrumentationAppPackage = ii.packageName;
            mInstrumentedAppDir = data.info.getAppDir();
            ApplicationInfo instrApp;
            instrApp = new ApplicationInfo();
            instrApp.packageName = ii.packageName;
            instrApp.sourceDir = ii.sourceDir;
            instrApp.publicSourceDir = ii.publicSourceDir;
            instrApp.dataDir = ii.dataDir;
            instrApp.nativeLibraryDir = ii.nativeLibraryDir;
            LoadedApk pi;
            pi = getPackageInfo(instrApp, data.compatInfo,
                    appContext.getClassLoader(), false, true);
            ContextImpl instrContext;
            instrContext = new ContextImpl();
            instrContext.init(pi, null, this);
            try 
            {
                java.lang.ClassLoader cl;
                cl = instrContext.getClassLoader();
                mInstrumentation = (Instrumentation)
                    cl.loadClass(data.instrumentationName.getClassName()).newInstance();
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate instrumentation "
                    + data.instrumentationName + ": " + e.toString(), e);
            } //End block
            mInstrumentation.init(this, instrContext, appContext,
                    new ComponentName(ii.packageName, ii.name), data.instrumentationWatcher);
            {
                mProfiler.handlingProfiling = true;
                File file;
                file = new File(mProfiler.profileFile);
                file.getParentFile().mkdirs();
                Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
            } //End block
            try 
            {
                mInstrumentation.onCreate(data.instrumentationArgs);
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Exception thrown in onCreate() of "
                    + data.instrumentationName + ": " + e.toString(), e);
            } //End block
        } //End block
        {
            mInstrumentation = new Instrumentation();
        } //End block
        {
            dalvik.system.VMRuntime.getRuntime().clearGrowthLimit();
        } //End block
        Application app;
        app = data.info.makeApplication(data.restrictedBackupMode, null);
        mInitialApplication = app;
        {
            List<ProviderInfo> providers;
            providers = data.providers;
            {
                installContentProviders(app, providers);
                mH.sendEmptyMessageDelayed(H.ENABLE_JIT, 10*1000);
            } //End block
        } //End block
        try 
        {
            mInstrumentation.callApplicationOnCreate(app);
        } //End block
        catch (Exception e)
        {
            {
                boolean var99DF702C0466DA8314007B6FFD566CCC_278102038 = (!mInstrumentation.onException(app, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to create application " + app.getClass().getName()
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.329 -0400", hash_original_method = "87522E170C98EEC17A950D0CB0F18A7D", hash_generated_method = "A15568406C98DE5E1BA2C53F78A59D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void finishInstrumentation(int resultCode, Bundle results) {
        dsTaint.addTaint(results.dsTaint);
        dsTaint.addTaint(resultCode);
        IActivityManager am;
        am = ActivityManagerNative.getDefault();
        {
            Debug.stopMethodTracing();
        } //End block
        try 
        {
            am.finishInstrumentation(mAppThread, resultCode, results);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        //IActivityManager am = ActivityManagerNative.getDefault();
        //if (mProfiler.profileFile != null && mProfiler.handlingProfiling
                //&& mProfiler.profileFd == null) {
            //Debug.stopMethodTracing();
        //}
        //try {
            //am.finishInstrumentation(mAppThread, resultCode, results);
        //} catch (RemoteException ex) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.330 -0400", hash_original_method = "E6307225A7BED03273D5285E74D77996", hash_generated_method = "A183A4E3352041AFE28BD4D9FEF5220C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void installContentProviders(
            Context context, List<ProviderInfo> providers) {
        dsTaint.addTaint(providers.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        ArrayList<IActivityManager.ContentProviderHolder> results;
        results = new ArrayList<IActivityManager.ContentProviderHolder>();
        Iterator<ProviderInfo> i;
        i = providers.iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1453176634 = (i.hasNext());
            {
                ProviderInfo cpi;
                cpi = i.next();
                StringBuilder buf;
                buf = new StringBuilder(128);
                buf.append("Pub ");
                buf.append(cpi.authority);
                buf.append(": ");
                buf.append(cpi.name);
                IContentProvider cp;
                cp = installProvider(context, null, cpi,
                    false , true );
                {
                    IActivityManager.ContentProviderHolder cph;
                    cph = new IActivityManager.ContentProviderHolder(cpi);
                    cph.provider = cp;
                    cph.noReleaseNeeded = true;
                    results.add(cph);
                } //End block
            } //End block
        } //End collapsed parenthetic
        try 
        {
            ActivityManagerNative.getDefault().publishContentProviders(
                getApplicationThread(), results);
        } //End block
        catch (RemoteException ex)
        { }
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.331 -0400", hash_original_method = "F88C15CE4CC55ECD0AF9CC176F41EB20", hash_generated_method = "B883963297FA8A7CD3771A0D1B5B03A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IContentProvider acquireProvider(Context c, String name) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(name);
        IContentProvider provider;
        provider = acquireExistingProvider(c, name);
        IActivityManager.ContentProviderHolder holder;
        holder = null;
        try 
        {
            holder = ActivityManagerNative.getDefault().getContentProvider(
                    getApplicationThread(), name);
        } //End block
        catch (RemoteException ex)
        { }
        provider = installProvider(c, holder.provider, holder.info,
                true , holder.noReleaseNeeded);
        {
            try 
            {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), name);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.332 -0400", hash_original_method = "D0EC607B4605DB37ABCB0EC4802499DE", hash_generated_method = "F163DE577E0883C81975681FDAC91322")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final IContentProvider acquireExistingProvider(Context c, String name) {
        dsTaint.addTaint(c.dsTaint);
        dsTaint.addTaint(name);
        {
            ProviderClientRecord pr;
            pr = mProviderMap.get(name);
            IContentProvider provider;
            provider = pr.mProvider;
            IBinder jBinder;
            jBinder = provider.asBinder();
            ProviderRefCount prc;
            prc = mProviderRefCountMap.get(jBinder);
            {
                prc.count += 1;
                {
                    mH.removeMessages(H.REMOVE_PROVIDER, provider);
                } //End block
            } //End block
        } //End block
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.333 -0400", hash_original_method = "570D24C9467F1DF00A050F1BB22169F2", hash_generated_method = "DAEE6746CBFC38D747EBADE144FC39DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final boolean releaseProvider(IContentProvider provider) {
        dsTaint.addTaint(provider.dsTaint);
        IBinder jBinder;
        jBinder = provider.asBinder();
        {
            ProviderRefCount prc;
            prc = mProviderRefCountMap.get(jBinder);
            prc.count -= 1;
            {
                Message msg;
                msg = mH.obtainMessage(H.REMOVE_PROVIDER, provider);
                mH.sendMessage(msg);
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if(provider == null) {
            //return false;
        //}
        //IBinder jBinder = provider.asBinder();
        //synchronized (mProviderMap) {
            //ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            //if (prc == null) {
                //return false;
            //}
            //if (prc.count == 0) {
                //if (localLOGV) Slog.v(TAG, "releaseProvider: ref count already 0, how?");
                //return false;
            //}
            //prc.count -= 1;
            //if (prc.count == 0) {
                //Message msg = mH.obtainMessage(H.REMOVE_PROVIDER, provider);
                //mH.sendMessage(msg);
            //}
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.334 -0400", hash_original_method = "26DD2496F7761FB77064EC4900EC6CC4", hash_generated_method = "8D890D454980DFF0DEA551FB1E4253AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void completeRemoveProvider(IContentProvider provider) {
        dsTaint.addTaint(provider.dsTaint);
        IBinder jBinder;
        jBinder = provider.asBinder();
        String remoteProviderName;
        remoteProviderName = null;
        {
            ProviderRefCount prc;
            prc = mProviderRefCountMap.get(jBinder);
            mProviderRefCountMap.remove(jBinder);
            Iterator<ProviderClientRecord> iter;
            iter = mProviderMap.values().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_1851787802 = (iter.hasNext());
                {
                    ProviderClientRecord pr;
                    pr = iter.next();
                    IBinder myBinder;
                    myBinder = pr.mProvider.asBinder();
                    {
                        iter.remove();
                        {
                            myBinder.unlinkToDeath(pr, 0);
                            {
                                remoteProviderName = pr.mName;
                            } //End block
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            try 
            {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), remoteProviderName);
            } //End block
            catch (RemoteException e)
            { }
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.334 -0400", hash_original_method = "89FC0B7C2EBDC1E0BBDB9AF687772CD2", hash_generated_method = "DD18BDE5C287DFC5696FF639F58B7EB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void removeDeadProvider(String name, IContentProvider provider) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(provider.dsTaint);
        {
            ProviderClientRecord pr;
            pr = mProviderMap.get(name);
            {
                boolean var966307558E067A018FA6F5C432EE1917_725552385 = (pr != null && pr.mProvider.asBinder() == provider.asBinder());
                {
                    ProviderClientRecord removed;
                    removed = mProviderMap.remove(name);
                    {
                        removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized(mProviderMap) {
            //ProviderClientRecord pr = mProviderMap.get(name);
            //if (pr != null && pr.mProvider.asBinder() == provider.asBinder()) {
                //Slog.i(TAG, "Removing dead content provider: " + name);
                //ProviderClientRecord removed = mProviderMap.remove(name);
                //if (removed != null) {
                    //removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.339 -0400", hash_original_method = "54C9C23E13579DED3FD2406679DE4E02", hash_generated_method = "ACC76F82C1166F6EB686FFB71CD71779")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private IContentProvider installProvider(Context context,
            IContentProvider provider, ProviderInfo info,
            boolean noisy, boolean noReleaseNeeded) {
        dsTaint.addTaint(noisy);
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(provider.dsTaint);
        dsTaint.addTaint(noReleaseNeeded);
        dsTaint.addTaint(info.dsTaint);
        ContentProvider localProvider;
        localProvider = null;
        {
            {
                Slog.d(TAG, "Loading provider " + info.authority + ": "
                        + info.name);
            } //End block
            Context c;
            c = null;
            ApplicationInfo ai;
            ai = info.applicationInfo;
            {
                boolean var91DE5B59D8254FD2545D30D7F711FB97_396945810 = (context.getPackageName().equals(ai.packageName));
                {
                    c = context;
                } //End block
                {
                    boolean varBB822C07A468461CB214A3B461BD724D_1398241529 = (mInitialApplication != null &&
                    mInitialApplication.getPackageName().equals(ai.packageName));
                    {
                        c = mInitialApplication;
                    } //End block
                    {
                        try 
                        {
                            c = context.createPackageContext(ai.packageName,
                            Context.CONTEXT_INCLUDE_CODE);
                        } //End block
                        catch (PackageManager.NameNotFoundException e)
                        { }
                    } //End block
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            try 
            {
                java.lang.ClassLoader cl;
                cl = c.getClassLoader();
                localProvider = (ContentProvider)cl.
                    loadClass(info.name).newInstance();
                provider = localProvider.getIContentProvider();
                localProvider.attachInfo(c, info);
            } //End block
            catch (java.lang.Exception e)
            {
                {
                    boolean varFB4F174495DD0F0FC2F116EBF5523752_479370932 = (!mInstrumentation.onException(null, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to get provider " + info.name
                            + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            IBinder jBinder;
            jBinder = provider.asBinder();
            String names[];
            names = PATTERN_SEMICOLON.split(info.authority);
            {
                int i;
                i = 0;
                {
                    ProviderClientRecord pr;
                    pr = mProviderMap.get(names[i]);
                    {
                        provider = pr.mProvider;
                    } //End block
                    {
                        pr = new ProviderClientRecord(names[i], provider, localProvider);
                        {
                            try 
                            {
                                jBinder.linkToDeath(pr, 0);
                            } //End block
                            catch (RemoteException e)
                            { }
                        } //End block
                        mProviderMap.put(names[i], pr);
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                ProviderClientRecord pr;
                pr = mLocalProviders.get(jBinder);
                {
                    provider = pr.mProvider;
                } //End block
                {
                    pr = new ProviderClientRecord(null, provider, localProvider);
                    mLocalProviders.put(jBinder, pr);
                } //End block
            } //End block
            {
                ProviderRefCount prc;
                prc = mProviderRefCountMap.get(jBinder);
                {
                    prc.count += 1;
                    {
                        mH.removeMessages(H.REMOVE_PROVIDER, provider);
                    } //End block
                } //End block
                {
                    mProviderRefCountMap.put(jBinder, new ProviderRefCount(1));
                } //End block
            } //End block
        } //End block
        return (IContentProvider)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.343 -0400", hash_original_method = "C124A05EAD0D975305C2EDD26DCF96DC", hash_generated_method = "EB47E9BBE56CA85139E5BBEDCB99431A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void attach(boolean system) {
        dsTaint.addTaint(system);
        sThreadLocal.set(this);
        {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.341 -0400", hash_original_method = "47807A5814B5D681B360E1F6CDD604E7", hash_generated_method = "CE4C0CC733C0731411E130B03C44D6CB")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    ensureJitEnabled();
                    // ---------- Original Method ----------
                    //ensureJitEnabled();
                }
});
            android.ddm.DdmHandleAppName.setAppName("<pre-initialized>");
            RuntimeInit.setApplicationObject(mAppThread.asBinder());
            IActivityManager mgr;
            mgr = ActivityManagerNative.getDefault();
            try 
            {
                mgr.attachApplication(mAppThread);
            } //End block
            catch (RemoteException ex)
            { }
        } //End block
        {
            android.ddm.DdmHandleAppName.setAppName("system_process");
            try 
            {
                mInstrumentation = new Instrumentation();
                ContextImpl context;
                context = new ContextImpl();
                context.init(getSystemContext().mPackageInfo, null, this);
                Application app;
                app = Instrumentation.newApplication(Application.class, context);
                mAllApplications.add(app);
                mInitialApplication = app;
                app.onCreate();
            } //End block
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to instantiate Application():" + e.toString(), e);
            } //End block
        } //End block
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.342 -0400", hash_original_method = "26C6C7423624E1B7694397A08E8C6CD1", hash_generated_method = "0CDEC6AC7C1AE3F1F564B5C0290C690E")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void onConfigurationChanged(Configuration newConfig) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(newConfig.dsTaint);
                {
                    {
                        boolean var7902634F304B837BD47B2192DBEFCA89_979269561 = (applyConfigurationToResourcesLocked(newConfig, null));
                        {
                            {
                                boolean var4EBF8D921B272E9ECD6097B4EB42049C_741171030 = (mPendingConfiguration == null ||
                                mPendingConfiguration.isOtherSeqNewer(newConfig));
                                {
                                    mPendingConfiguration = newConfig;
                                    queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                // ---------- Original Method ----------
                //synchronized (mPackages) {
                    //if (applyConfigurationToResourcesLocked(newConfig, null)) {
                        //if (mPendingConfiguration == null ||
                                //mPendingConfiguration.isOtherSeqNewer(newConfig)) {
                            //mPendingConfiguration = newConfig;
                            //queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                        //}
                    //}
                //}
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.342 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
            @DSModeled(DSC.SAFE)
            public void onLowMemory() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.342 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C9C9C0A5CE6C55C02F314458C48A02DB")
            @DSModeled(DSC.SAFE)
            public void onTrimMemory(int level) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                dsTaint.addTaint(level);
                // ---------- Original Method ----------
            }
});
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static final ActivityThread systemMain() {
        HardwareRenderer.disable(true);
        ActivityThread thread = new ActivityThread();
        thread.attach(true);
        return thread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.344 -0400", hash_original_method = "2E14593B1AB1D9A91353E1BD8215A316", hash_generated_method = "8602A607B594857B01F505289D70FEC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final void installSystemProviders(List<ProviderInfo> providers) {
        dsTaint.addTaint(providers.dsTaint);
        {
            installContentProviders(mInitialApplication, providers);
        } //End block
        // ---------- Original Method ----------
        //if (providers != null) {
            //installContentProviders(mInitialApplication, providers);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.346 -0400", hash_original_method = "A46DE63D351DE0CEA05BC700781E1C79", hash_generated_method = "D7A6CCD2CC06574E24FB0F037A4B6F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getIntCoreSetting(String key, int defaultValue) {
        dsTaint.addTaint(defaultValue);
        dsTaint.addTaint(key);
        {
            {
                int varFDEB65FAB02737F165A27EF58C1FFD56_1950762824 = (mCoreSettings.getInt(key, defaultValue));
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //if (mCoreSettings != null) {
                //return mCoreSettings.getInt(key, defaultValue);
            //} else {
                //return defaultValue;
            //}
        //}
    }

    
        public static void main(String[] args) {
        SamplingProfilerIntegration.start();
        CloseGuard.setEnabled(false);
        Process.setArgV0("<pre-initialized>");
        Looper.prepareMainLooper();
        if (sMainThreadHandler == null) {
            sMainThreadHandler = new Handler();
        }
        ActivityThread thread = new ActivityThread();
        thread.attach(false);
        if (false) {
            Looper.myLooper().setMessageLogging(new
                    LogPrinter(Log.DEBUG, "ActivityThread"));
        }
        Looper.loop();
        throw new RuntimeException("Main thread loop unexpectedly exited");
    }

    
    static final class ActivityClientRecord {
        IBinder token;
        int ident;
        Intent intent;
        Bundle state;
        Activity activity;
        Window window;
        Activity parent;
        String embeddedID;
        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        boolean paused;
        boolean stopped;
        boolean hideForNow;
        Configuration newConfig;
        Configuration createdConfig;
        ActivityClientRecord nextIdle;
        String profileFile;
        ParcelFileDescriptor profileFd;
        boolean autoStopProfiler;
        ActivityInfo activityInfo;
        CompatibilityInfo compatInfo;
        LoadedApk packageInfo;
        List<ResultInfo> pendingResults;
        List<Intent> pendingIntents;
        boolean startsNotResumed;
        boolean isForward;
        int pendingConfigChanges;
        boolean onlyLocalRequest;
        View mPendingRemoveWindow;
        WindowManager mPendingRemoveWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.348 -0400", hash_original_method = "B5F524E6EAF79ED64F291F38DBCEDD1B", hash_generated_method = "1B05C37D3F960D6790EA6795720DC542")
        @DSModeled(DSC.SAFE)
         ActivityClientRecord() {
            parent = null;
            embeddedID = null;
            paused = false;
            stopped = false;
            hideForNow = false;
            nextIdle = null;
            // ---------- Original Method ----------
            //parent = null;
            //embeddedID = null;
            //paused = false;
            //stopped = false;
            //hideForNow = false;
            //nextIdle = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.348 -0400", hash_original_method = "2761403398E750945AAB952EA69C6C0F", hash_generated_method = "23F500D1B82C218C66D86DC0C0113A26")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean isPreHoneycomb() {
            {
                boolean var708B39EC3F85FBC7A5D34973A60AE645_22926141 = (activity.getApplicationInfo().targetSdkVersion
                        < android.os.Build.VERSION_CODES.HONEYCOMB);
            } //End block
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (activity != null) {
                //return activity.getApplicationInfo().targetSdkVersion
                        //< android.os.Build.VERSION_CODES.HONEYCOMB;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.349 -0400", hash_original_method = "C4594DCD1E896B9BDB54D56E10F2B8EE", hash_generated_method = "CCADBAB2B6ABA3EAF14A75BB8733B040")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            ComponentName componentName;
            componentName = intent.getComponent();
            String varCEEB2FD0AD46E8259A3983208777B779_928117576 = ("ActivityRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " token=" + token + " " + (componentName == null
                        ? "no component name" : componentName.toShortString())
                + "}"); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //ComponentName componentName = intent.getComponent();
            //return "ActivityRecord{"
                //+ Integer.toHexString(System.identityHashCode(this))
                //+ " token=" + token + " " + (componentName == null
                        //? "no component name" : componentName.toShortString())
                //+ "}";
        }

        
    }


    
    final class ProviderClientRecord implements IBinder.DeathRecipient {
        String mName;
        IContentProvider mProvider;
        ContentProvider mLocalProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.350 -0400", hash_original_method = "C7097CC666CFF4D083C9B2045DB42E29", hash_generated_method = "6858C7760142AFB5452CC0CF9EABF9F5")
        @DSModeled(DSC.SAFE)
         ProviderClientRecord(String name, IContentProvider provider,
                ContentProvider localProvider) {
            dsTaint.addTaint(name);
            dsTaint.addTaint(provider.dsTaint);
            dsTaint.addTaint(localProvider.dsTaint);
            // ---------- Original Method ----------
            //mName = name;
            //mProvider = provider;
            //mLocalProvider = localProvider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.350 -0400", hash_original_method = "3801456C44CFB93A5BA86A8AB8C43B3F", hash_generated_method = "B050BAB508FED40C5C7DDCB23C41347E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void binderDied() {
            removeDeadProvider(mName, mProvider);
            // ---------- Original Method ----------
            //removeDeadProvider(mName, mProvider);
        }

        
    }


    
    static final class NewIntentData {
        List<Intent> intents;
        IBinder token;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.351 -0400", hash_original_method = "2992F20177EFD1B39F71DFF0CB3F9357", hash_generated_method = "2992F20177EFD1B39F71DFF0CB3F9357")
                public NewIntentData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.351 -0400", hash_original_method = "E9F4DBEB4C72AFF7F672A47023D2DCCE", hash_generated_method = "2DC3942EE2228F02F002E6465A7706C1")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "NewIntentData{intents=" + intents + " token=" + token + "}";
        }

        
    }


    
    static final class ReceiverData extends BroadcastReceiver.PendingResult {
        Intent intent;
        ActivityInfo info;
        CompatibilityInfo compatInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.352 -0400", hash_original_method = "95DC539EA4572F0714768317249686D3", hash_generated_method = "9A27A3182920B7412599BF9EC5802746")
        @DSModeled(DSC.SPEC)
        public ReceiverData(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                boolean ordered, boolean sticky, IBinder token) {
            super(resultCode, resultData, resultExtras, TYPE_COMPONENT, ordered, sticky, token);
            dsTaint.addTaint(resultData);
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(resultExtras.dsTaint);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(ordered);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(intent.dsTaint);
            // ---------- Original Method ----------
            //this.intent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.355 -0400", hash_original_method = "062A80C4BE8CE608AA3884983AB20A02", hash_generated_method = "2F408D79DF1581CC5D1E64D471371FDA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public String toString() {
            String var4F6C3A052079DB6884F562EC0FB81CFE_1516245434 = ("ReceiverData{intent=" + intent + " packageName=" +
                    info.packageName + " resultCode=" + getResultCode()
                    + " resultData=" + getResultData() + " resultExtras="
                    + getResultExtras(false) + "}");
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ReceiverData{intent=" + intent + " packageName=" +
                    //info.packageName + " resultCode=" + getResultCode()
                    //+ " resultData=" + getResultData() + " resultExtras="
                    //+ getResultExtras(false) + "}";
        }

        
    }


    
    static final class CreateBackupAgentData {
        ApplicationInfo appInfo;
        CompatibilityInfo compatInfo;
        int backupMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.356 -0400", hash_original_method = "3F8BF4DE205DAA8CFEC9F259512C1D68", hash_generated_method = "3F8BF4DE205DAA8CFEC9F259512C1D68")
                public CreateBackupAgentData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.358 -0400", hash_original_method = "87705B4B5A78FEE0786C01D6E7384189", hash_generated_method = "31DE7BD9D213FA955C8A4E71E3AA6C04")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CreateBackupAgentData{appInfo=" + appInfo
                    //+ " backupAgent=" + appInfo.backupAgentName
                    //+ " mode=" + backupMode + "}";
        }

        
    }


    
    static final class CreateServiceData {
        IBinder token;
        ServiceInfo info;
        CompatibilityInfo compatInfo;
        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.359 -0400", hash_original_method = "6469F11103D697C98ADEE25C3443A0E8", hash_generated_method = "6469F11103D697C98ADEE25C3443A0E8")
                public CreateServiceData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.359 -0400", hash_original_method = "DE656B2587EA58A3FB80D8944832AD3A", hash_generated_method = "925C8D53114C92583B6C8E311663298E")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "CreateServiceData{token=" + token + " className="
            //+ info.name + " packageName=" + info.packageName
            //+ " intent=" + intent + "}";
        }

        
    }


    
    static final class BindServiceData {
        IBinder token;
        Intent intent;
        boolean rebind;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.359 -0400", hash_original_method = "CB649677159813918F661324D9CE0C7C", hash_generated_method = "CB649677159813918F661324D9CE0C7C")
                public BindServiceData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.363 -0400", hash_original_method = "788B7BFDCE261467774852FF99962FB6", hash_generated_method = "51D077123D1E6B26381BBCEBEA622E66")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "BindServiceData{token=" + token + " intent=" + intent + "}";
        }

        
    }


    
    static final class ServiceArgsData {
        IBinder token;
        boolean taskRemoved;
        int startId;
        int flags;
        Intent args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.363 -0400", hash_original_method = "DC4DF3C035C9EE1F1E2D0073BBE6FA84", hash_generated_method = "DC4DF3C035C9EE1F1E2D0073BBE6FA84")
                public ServiceArgsData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.363 -0400", hash_original_method = "9123370A477925A90205ABBEEFE44004", hash_generated_method = "4B23AAE3FFD957133C7657A3F7A87701")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ServiceArgsData{token=" + token + " startId=" + startId
            //+ " args=" + args + "}";
        }

        
    }


    
    static final class AppBindData {
        LoadedApk info;
        String processName;
        ApplicationInfo appInfo;
        List<ProviderInfo> providers;
        ComponentName instrumentationName;
        Bundle instrumentationArgs;
        IInstrumentationWatcher instrumentationWatcher;
        int debugMode;
        boolean restrictedBackupMode;
        boolean persistent;
        Configuration config;
        CompatibilityInfo compatInfo;
        String initProfileFile;
        ParcelFileDescriptor initProfileFd;
        boolean initAutoStopProfiler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.364 -0400", hash_original_method = "5B9A918E42B47FBBF6E3918017585E98", hash_generated_method = "5B9A918E42B47FBBF6E3918017585E98")
                public AppBindData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.364 -0400", hash_original_method = "2BA8F6DB78683607CF1A79B96A9E1945", hash_generated_method = "2FF0F8A3A5087EFC05F91620ECA7D695")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "AppBindData{appInfo=" + appInfo + "}";
        }

        
    }


    
    static final class Profiler {
        String profileFile;
        ParcelFileDescriptor profileFd;
        boolean autoStopProfiler;
        boolean profiling;
        boolean handlingProfiling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.365 -0400", hash_original_method = "E4C29EE599E893CED5B012BCDA087639", hash_generated_method = "E4C29EE599E893CED5B012BCDA087639")
                public Profiler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.365 -0400", hash_original_method = "A8A96BF1FCBE3854C04202513222077A", hash_generated_method = "D4598FAA7492357D7EBEA65AEE8DD81C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setProfiler(String file, ParcelFileDescriptor fd) {
            dsTaint.addTaint(file);
            dsTaint.addTaint(fd.dsTaint);
            {
                {
                    try 
                    {
                        fd.close();
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
            } //End block
            {
                try 
                {
                    profileFd.close();
                } //End block
                catch (IOException e)
                { }
            } //End block
            // ---------- Original Method ----------
            //if (profiling) {
                //if (fd != null) {
                    //try {
                        //fd.close();
                    //} catch (IOException e) {
                    //}
                //}
                //return;
            //}
            //if (profileFd != null) {
                //try {
                    //profileFd.close();
                //} catch (IOException e) {
                //}
            //}
            //profileFile = file;
            //profileFd = fd;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.366 -0400", hash_original_method = "4BADC9424DA1A3AC7F9D5563006BCE42", hash_generated_method = "717956F1062DD3A5AEC90B37F1ED3668")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void startProfiling() {
            try 
            {
                Debug.startMethodTracing(profileFile, profileFd.getFileDescriptor(),
                        8 * 1024 * 1024, 0);
                profiling = true;
            } //End block
            catch (RuntimeException e)
            {
                try 
                {
                    profileFd.close();
                    profileFd = null;
                } //End block
                catch (IOException e2)
                { }
            } //End block
            // ---------- Original Method ----------
            //if (profileFd == null || profiling) {
                //return;
            //}
            //try {
                //Debug.startMethodTracing(profileFile, profileFd.getFileDescriptor(),
                        //8 * 1024 * 1024, 0);
                //profiling = true;
            //} catch (RuntimeException e) {
                //Slog.w(TAG, "Profiling failed on path " + profileFile);
                //try {
                    //profileFd.close();
                    //profileFd = null;
                //} catch (IOException e2) {
                    //Slog.w(TAG, "Failure closing profile fd", e2);
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.366 -0400", hash_original_method = "F0726A3E7708B3CB256CEACF5FA42FD5", hash_generated_method = "53B2FD47BCAC0373E4CFDB09F8C1864E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void stopProfiling() {
            {
                profiling = false;
                Debug.stopMethodTracing();
                {
                    try 
                    {
                        profileFd.close();
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
                profileFd = null;
                profileFile = null;
            } //End block
            // ---------- Original Method ----------
            //if (profiling) {
                //profiling = false;
                //Debug.stopMethodTracing();
                //if (profileFd != null) {
                    //try {
                        //profileFd.close();
                    //} catch (IOException e) {
                    //}
                //}
                //profileFd = null;
                //profileFile = null;
            //}
        }

        
    }


    
    static final class DumpComponentInfo {
        ParcelFileDescriptor fd;
        IBinder token;
        String prefix;
        String[] args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.367 -0400", hash_original_method = "317C43A507151CFAB651B4DFED1482CE", hash_generated_method = "317C43A507151CFAB651B4DFED1482CE")
                public DumpComponentInfo ()
        {
        }


    }


    
    static final class ResultData {
        IBinder token;
        List<ResultInfo> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.367 -0400", hash_original_method = "AF84BC74387A36B1335FD190332E733A", hash_generated_method = "AF84BC74387A36B1335FD190332E733A")
                public ResultData ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.367 -0400", hash_original_method = "BA3AA15664E126972C9E79255FFB7B3E", hash_generated_method = "65ABCFA81187DB2604FF1BB0CAF77D3A")
        @DSModeled(DSC.SAFE)
        public String toString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return "ResultData{token=" + token + " results" + results + "}";
        }

        
    }


    
    static final class ContextCleanupInfo {
        ContextImpl context;
        String what;
        String who;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.368 -0400", hash_original_method = "B503E1B321EE777AE8364980E99887BC", hash_generated_method = "B503E1B321EE777AE8364980E99887BC")
                public ContextCleanupInfo ()
        {
        }


    }


    
    static final class ProfilerControlData {
        String path;
        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.368 -0400", hash_original_method = "EA21C5C2D051DDE7F7ACE20501A2D4C8", hash_generated_method = "EA21C5C2D051DDE7F7ACE20501A2D4C8")
                public ProfilerControlData ()
        {
        }


    }


    
    static final class DumpHeapData {
        String path;
        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.368 -0400", hash_original_method = "229CD50B896C614CA216C1589A0775F1", hash_generated_method = "229CD50B896C614CA216C1589A0775F1")
                public DumpHeapData ()
        {
        }


    }


    
    static final class UpdateCompatibilityData {
        String pkg;
        CompatibilityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.368 -0400", hash_original_method = "8A34BBC4D2DD8908C3CC582ECA24788E", hash_generated_method = "8A34BBC4D2DD8908C3CC582ECA24788E")
                public UpdateCompatibilityData ()
        {
        }


    }


    
    private class ApplicationThread extends ApplicationThreadNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.369 -0400", hash_original_method = "B55DFEC4F9D3750718BE581866485DA1", hash_generated_method = "B55DFEC4F9D3750718BE581866485DA1")
                public ApplicationThread ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.369 -0400", hash_original_method = "FEE93A296AD85C197E1C80A7E47B6BFE", hash_generated_method = "8E24E8C3144F8C780120048C0CAF2041")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void updatePendingConfiguration(Configuration config) {
            dsTaint.addTaint(config.dsTaint);
            {
                {
                    boolean var2CFDCC84A5236B199D2609CB25C5A865_936203405 = (mPendingConfiguration == null ||
                        mPendingConfiguration.isOtherSeqNewer(config));
                    {
                        mPendingConfiguration = config;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            // ---------- Original Method ----------
            //synchronized (mPackages) {
                //if (mPendingConfiguration == null ||
                        //mPendingConfiguration.isOtherSeqNewer(config)) {
                    //mPendingConfiguration = config;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.370 -0400", hash_original_method = "BA274F1A18F5196BF92F19261941182B", hash_generated_method = "470F7CBDE6EAC1EAECD9970B4E44F3B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void schedulePauseActivity(IBinder token, boolean finished,
                boolean userLeaving, int configChanges) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(configChanges);
            dsTaint.addTaint(userLeaving);
            dsTaint.addTaint(finished);
            queueOrSendMessage(
                    finished ? H.PAUSE_ACTIVITY_FINISHING : H.PAUSE_ACTIVITY,
                    token,
                    (userLeaving ? 1 : 0),
                    configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                    //finished ? H.PAUSE_ACTIVITY_FINISHING : H.PAUSE_ACTIVITY,
                    //token,
                    //(userLeaving ? 1 : 0),
                    //configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.370 -0400", hash_original_method = "6237E07FCE9BDD69A8A6118FB4C5EAB5", hash_generated_method = "9019D394274DFBAF1D2B80EBEFED96C6")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleStopActivity(IBinder token, boolean showWindow,
                int configChanges) {
            dsTaint.addTaint(showWindow);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(configChanges);
            queueOrSendMessage(
                showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                token, 0, configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                //token, 0, configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.371 -0400", hash_original_method = "07304A552CCDBF618EE7F08FE12E8569", hash_generated_method = "DD6D0B9EEDCEDB72285B89A2C7334ED7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleWindowVisibility(IBinder token, boolean showWindow) {
            dsTaint.addTaint(showWindow);
            dsTaint.addTaint(token.dsTaint);
            queueOrSendMessage(
                showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                token);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                //token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.372 -0400", hash_original_method = "28F90EA3762C8F9BC8352F7DED192FAC", hash_generated_method = "F466ECAE46F7826552A335D993AA17B1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleSleeping(IBinder token, boolean sleeping) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(sleeping);
            queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.376 -0400", hash_original_method = "8E946102D354A83096F7BBE33573DD97", hash_generated_method = "50E134181B212E6BB1F9011C5066CE17")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleResumeActivity(IBinder token, boolean isForward) {
            dsTaint.addTaint(isForward);
            dsTaint.addTaint(token.dsTaint);
            queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.378 -0400", hash_original_method = "C9516E754F864B61E9DED08AC69D1433", hash_generated_method = "75EE3BEA69F6C88BA92175853145F1AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleSendResult(IBinder token, List<ResultInfo> results) {
            dsTaint.addTaint(results.dsTaint);
            dsTaint.addTaint(token.dsTaint);
            ResultData res;
            res = new ResultData();
            res.token = token;
            res.results = results;
            queueOrSendMessage(H.SEND_RESULT, res);
            // ---------- Original Method ----------
            //ResultData res = new ResultData();
            //res.token = token;
            //res.results = results;
            //queueOrSendMessage(H.SEND_RESULT, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.379 -0400", hash_original_method = "A45BCC7C8AC3E4C6E98525A537822FA1", hash_generated_method = "06816EC3513E50CCF814B9794E333094")
        @DSModeled(DSC.SPEC)
        public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
                ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
                Bundle state, List<ResultInfo> pendingResults,
                List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
                String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) {
            dsTaint.addTaint(notResumed);
            dsTaint.addTaint(curConfig.dsTaint);
            dsTaint.addTaint(compatInfo.dsTaint);
            dsTaint.addTaint(ident);
            dsTaint.addTaint(isForward);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(pendingResults.dsTaint);
            dsTaint.addTaint(state.dsTaint);
            dsTaint.addTaint(autoStopProfiler);
            dsTaint.addTaint(profileFd.dsTaint);
            dsTaint.addTaint(profileName);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(pendingNewIntents.dsTaint);
            dsTaint.addTaint(info.dsTaint);
            ActivityClientRecord r;
            r = new ActivityClientRecord();
            r.token = token;
            r.ident = ident;
            r.intent = intent;
            r.activityInfo = info;
            r.compatInfo = compatInfo;
            r.state = state;
            r.pendingResults = pendingResults;
            r.pendingIntents = pendingNewIntents;
            r.startsNotResumed = notResumed;
            r.isForward = isForward;
            r.profileFile = profileName;
            r.profileFd = profileFd;
            r.autoStopProfiler = autoStopProfiler;
            updatePendingConfiguration(curConfig);
            queueOrSendMessage(H.LAUNCH_ACTIVITY, r);
            // ---------- Original Method ----------
            //ActivityClientRecord r = new ActivityClientRecord();
            //r.token = token;
            //r.ident = ident;
            //r.intent = intent;
            //r.activityInfo = info;
            //r.compatInfo = compatInfo;
            //r.state = state;
            //r.pendingResults = pendingResults;
            //r.pendingIntents = pendingNewIntents;
            //r.startsNotResumed = notResumed;
            //r.isForward = isForward;
            //r.profileFile = profileName;
            //r.profileFd = profileFd;
            //r.autoStopProfiler = autoStopProfiler;
            //updatePendingConfiguration(curConfig);
            //queueOrSendMessage(H.LAUNCH_ACTIVITY, r);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.381 -0400", hash_original_method = "7F2AB124E5633740D7D94B2A109EF885", hash_generated_method = "6B8AD297E8122130557F6AE1525B5A19")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleRelaunchActivity(IBinder token,
                List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
                int configChanges, boolean notResumed, Configuration config) {
            dsTaint.addTaint(notResumed);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(pendingResults.dsTaint);
            dsTaint.addTaint(configChanges);
            dsTaint.addTaint(config.dsTaint);
            dsTaint.addTaint(pendingNewIntents.dsTaint);
            requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    configChanges, notResumed, config, true);
            // ---------- Original Method ----------
            //requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    //configChanges, notResumed, config, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.382 -0400", hash_original_method = "821027AAA00C536539A4B7071BFFE4C0", hash_generated_method = "67747269818903947E7481728F35035E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleNewIntent(List<Intent> intents, IBinder token) {
            dsTaint.addTaint(intents.dsTaint);
            dsTaint.addTaint(token.dsTaint);
            NewIntentData data;
            data = new NewIntentData();
            data.intents = intents;
            data.token = token;
            queueOrSendMessage(H.NEW_INTENT, data);
            // ---------- Original Method ----------
            //NewIntentData data = new NewIntentData();
            //data.intents = intents;
            //data.token = token;
            //queueOrSendMessage(H.NEW_INTENT, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.383 -0400", hash_original_method = "09A2B20C75657E983740D1D57867F853", hash_generated_method = "85AE9EA0EBDA5A3FE7C129C0498D53BC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleDestroyActivity(IBinder token, boolean finishing,
                int configChanges) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(configChanges);
            dsTaint.addTaint(finishing);
            queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    //configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.384 -0400", hash_original_method = "F17AEB980BE0F6A4E87F430078BD0B58", hash_generated_method = "8BDA241B09A457E18577F97E568E3B02")
        @DSModeled(DSC.SPEC)
        public final void scheduleReceiver(Intent intent, ActivityInfo info,
                CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras,
                boolean sync) {
            dsTaint.addTaint(compatInfo.dsTaint);
            dsTaint.addTaint(sync);
            dsTaint.addTaint(data);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            dsTaint.addTaint(info.dsTaint);
            ReceiverData r;
            r = new ReceiverData(intent, resultCode, data, extras,
                    sync, false, mAppThread.asBinder());
            r.info = info;
            r.compatInfo = compatInfo;
            queueOrSendMessage(H.RECEIVER, r);
            // ---------- Original Method ----------
            //ReceiverData r = new ReceiverData(intent, resultCode, data, extras,
                    //sync, false, mAppThread.asBinder());
            //r.info = info;
            //r.compatInfo = compatInfo;
            //queueOrSendMessage(H.RECEIVER, r);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.384 -0400", hash_original_method = "5FA1669C7C775884F96F1A035B24EE01", hash_generated_method = "6D4FD17D9EED51929E310E0B897D7177")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleCreateBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo, int backupMode) {
            dsTaint.addTaint(backupMode);
            dsTaint.addTaint(app.dsTaint);
            dsTaint.addTaint(compatInfo.dsTaint);
            CreateBackupAgentData d;
            d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            d.backupMode = backupMode;
            queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
            // ---------- Original Method ----------
            //CreateBackupAgentData d = new CreateBackupAgentData();
            //d.appInfo = app;
            //d.compatInfo = compatInfo;
            //d.backupMode = backupMode;
            //queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.385 -0400", hash_original_method = "313CE24EB5C5C4A7E872620C7BAF7637", hash_generated_method = "1021DCB319AD254ED89649AB7AF6EE6E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleDestroyBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo) {
            dsTaint.addTaint(app.dsTaint);
            dsTaint.addTaint(compatInfo.dsTaint);
            CreateBackupAgentData d;
            d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
            // ---------- Original Method ----------
            //CreateBackupAgentData d = new CreateBackupAgentData();
            //d.appInfo = app;
            //d.compatInfo = compatInfo;
            //queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.386 -0400", hash_original_method = "304266FFC85B0A8F15B84D2439555071", hash_generated_method = "A1EBB1F57F5318F234981B7D7163E076")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleCreateService(IBinder token,
                ServiceInfo info, CompatibilityInfo compatInfo) {
            dsTaint.addTaint(compatInfo.dsTaint);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(info.dsTaint);
            CreateServiceData s;
            s = new CreateServiceData();
            s.token = token;
            s.info = info;
            s.compatInfo = compatInfo;
            queueOrSendMessage(H.CREATE_SERVICE, s);
            // ---------- Original Method ----------
            //CreateServiceData s = new CreateServiceData();
            //s.token = token;
            //s.info = info;
            //s.compatInfo = compatInfo;
            //queueOrSendMessage(H.CREATE_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.386 -0400", hash_original_method = "EC87D949C3428DDE1DD75260E89A91E6", hash_generated_method = "78F6E9FEE4FC27441553F0D5E9FD1B9C")
        @DSModeled(DSC.SPEC)
        public final void scheduleBindService(IBinder token, Intent intent,
                boolean rebind) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(rebind);
            dsTaint.addTaint(intent.dsTaint);
            BindServiceData s;
            s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            s.rebind = rebind;
            queueOrSendMessage(H.BIND_SERVICE, s);
            // ---------- Original Method ----------
            //BindServiceData s = new BindServiceData();
            //s.token = token;
            //s.intent = intent;
            //s.rebind = rebind;
            //queueOrSendMessage(H.BIND_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.388 -0400", hash_original_method = "267A066D9D2EC1A97646FF118EBD56F3", hash_generated_method = "6546A28D37A67264909112F98A512614")
        @DSModeled(DSC.SPEC)
        public final void scheduleUnbindService(IBinder token, Intent intent) {
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(intent.dsTaint);
            BindServiceData s;
            s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            queueOrSendMessage(H.UNBIND_SERVICE, s);
            // ---------- Original Method ----------
            //BindServiceData s = new BindServiceData();
            //s.token = token;
            //s.intent = intent;
            //queueOrSendMessage(H.UNBIND_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.389 -0400", hash_original_method = "4862A31D82FA9B63D38F69A2AB095DD2", hash_generated_method = "97834B9F8578CA77F5E60ACDE1B8F563")
        @DSModeled(DSC.SPEC)
        public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
            int flags ,Intent args) {
            dsTaint.addTaint(startId);
            dsTaint.addTaint(flags);
            dsTaint.addTaint(token.dsTaint);
            dsTaint.addTaint(args.dsTaint);
            dsTaint.addTaint(taskRemoved);
            ServiceArgsData s;
            s = new ServiceArgsData();
            s.token = token;
            s.taskRemoved = taskRemoved;
            s.startId = startId;
            s.flags = flags;
            s.args = args;
            queueOrSendMessage(H.SERVICE_ARGS, s);
            // ---------- Original Method ----------
            //ServiceArgsData s = new ServiceArgsData();
            //s.token = token;
            //s.taskRemoved = taskRemoved;
            //s.startId = startId;
            //s.flags = flags;
            //s.args = args;
            //queueOrSendMessage(H.SERVICE_ARGS, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.390 -0400", hash_original_method = "1A677B6A32C3D13D1D29F012CCC3FAD3", hash_generated_method = "288ACE3B8BF3214E67EE0806033C6639")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleStopService(IBinder token) {
            dsTaint.addTaint(token.dsTaint);
            queueOrSendMessage(H.STOP_SERVICE, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.STOP_SERVICE, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.391 -0400", hash_original_method = "7F787E48DA5312BFEADE988209BA97C7", hash_generated_method = "DDB8F1FBF1918E6F36F4A4751C9FA6B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void bindApplication(String processName,
                ApplicationInfo appInfo, List<ProviderInfo> providers,
                ComponentName instrumentationName, String profileFile,
                ParcelFileDescriptor profileFd, boolean autoStopProfiler,
                Bundle instrumentationArgs, IInstrumentationWatcher instrumentationWatcher,
                int debugMode, boolean isRestrictedBackupMode, boolean persistent,
                Configuration config, CompatibilityInfo compatInfo,
                Map<String, IBinder> services, Bundle coreSettings) {
            dsTaint.addTaint(services.dsTaint);
            dsTaint.addTaint(debugMode);
            dsTaint.addTaint(appInfo.dsTaint);
            dsTaint.addTaint(processName);
            dsTaint.addTaint(instrumentationName.dsTaint);
            dsTaint.addTaint(autoStopProfiler);
            dsTaint.addTaint(isRestrictedBackupMode);
            dsTaint.addTaint(profileFile);
            dsTaint.addTaint(instrumentationWatcher.dsTaint);
            dsTaint.addTaint(coreSettings.dsTaint);
            dsTaint.addTaint(compatInfo.dsTaint);
            dsTaint.addTaint(providers.dsTaint);
            dsTaint.addTaint(persistent);
            dsTaint.addTaint(instrumentationArgs.dsTaint);
            dsTaint.addTaint(config.dsTaint);
            dsTaint.addTaint(profileFd.dsTaint);
            {
                ServiceManager.initServiceCache(services);
            } //End block
            setCoreSettings(coreSettings);
            AppBindData data;
            data = new AppBindData();
            data.processName = processName;
            data.appInfo = appInfo;
            data.providers = providers;
            data.instrumentationName = instrumentationName;
            data.instrumentationArgs = instrumentationArgs;
            data.instrumentationWatcher = instrumentationWatcher;
            data.debugMode = debugMode;
            data.restrictedBackupMode = isRestrictedBackupMode;
            data.persistent = persistent;
            data.config = config;
            data.compatInfo = compatInfo;
            data.initProfileFile = profileFile;
            data.initProfileFd = profileFd;
            data.initAutoStopProfiler = false;
            queueOrSendMessage(H.BIND_APPLICATION, data);
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.391 -0400", hash_original_method = "8F2CF4412C4F9594CB0F284CDA41289F", hash_generated_method = "FD95F1744B2DADE0E6256342E369D342")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleExit() {
            queueOrSendMessage(H.EXIT_APPLICATION, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.EXIT_APPLICATION, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.392 -0400", hash_original_method = "B20E9F159FCFB18DA16F9E3A94AEF27F", hash_generated_method = "FCFDDF7AD8124B805F52430959A87E50")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final void scheduleSuicide() {
            queueOrSendMessage(H.SUICIDE, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SUICIDE, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.392 -0400", hash_original_method = "6202A73E0682C5A75E75C022AC3B402A", hash_generated_method = "0F74DA4BEEE9CC41EE6F877ACDA66052")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void requestThumbnail(IBinder token) {
            dsTaint.addTaint(token.dsTaint);
            queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.393 -0400", hash_original_method = "06772B0545F1E3E199A400C07A7C465B", hash_generated_method = "FFF4C086E01BE2BE28139D67D20584F7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void scheduleConfigurationChanged(Configuration config) {
            dsTaint.addTaint(config.dsTaint);
            updatePendingConfiguration(config);
            queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
            // ---------- Original Method ----------
            //updatePendingConfiguration(config);
            //queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.393 -0400", hash_original_method = "691E3B4CEF6237A9A1AE3434E3DEDEFF", hash_generated_method = "B8C95D80E84F89DC0BEDC85471A2F2D3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updateTimeZone() {
            TimeZone.setDefault(null);
            // ---------- Original Method ----------
            //TimeZone.setDefault(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.394 -0400", hash_original_method = "38B626EB423003E8CAF0F1407CD9E9A9", hash_generated_method = "4A28A43D9782A661EAF6F85250AF0D6F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void clearDnsCache() {
            InetAddress.clearDnsCache();
            // ---------- Original Method ----------
            //InetAddress.clearDnsCache();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.394 -0400", hash_original_method = "B8887413EF343DBD56A367F4C57F614A", hash_generated_method = "DC56C430D14287E8CC301CDCB52B6D8D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setHttpProxy(String host, String port, String exclList) {
            dsTaint.addTaint(port);
            dsTaint.addTaint(host);
            dsTaint.addTaint(exclList);
            Proxy.setHttpProxySystemProperty(host, port, exclList);
            // ---------- Original Method ----------
            //Proxy.setHttpProxySystemProperty(host, port, exclList);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.395 -0400", hash_original_method = "66F6EAD39814B9A04B7952BBDB099BC9", hash_generated_method = "572139B122FBBA71F49FE015C971C791")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void processInBackground() {
            mH.removeMessages(H.GC_WHEN_IDLE);
            mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
            // ---------- Original Method ----------
            //mH.removeMessages(H.GC_WHEN_IDLE);
            //mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.395 -0400", hash_original_method = "876C8E0D071CEA83F82D96AA48344FA4", hash_generated_method = "E5571894BAB7E78E8DA89C8B5B6A8837")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dumpService(FileDescriptor fd, IBinder servicetoken, String[] args) {
            dsTaint.addTaint(servicetoken.dsTaint);
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(fd.dsTaint);
            DumpComponentInfo data;
            data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = servicetoken;
                data.args = args;
                queueOrSendMessage(H.DUMP_SERVICE, data);
            } //End block
            catch (IOException e)
            { }
            // ---------- Original Method ----------
            //DumpComponentInfo data = new DumpComponentInfo();
            //try {
                //data.fd = ParcelFileDescriptor.dup(fd);
                //data.token = servicetoken;
                //data.args = args;
                //queueOrSendMessage(H.DUMP_SERVICE, data);
            //} catch (IOException e) {
                //Slog.w(TAG, "dumpService failed", e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.398 -0400", hash_original_method = "0E238081C4996703A2EA0540C6977CE0", hash_generated_method = "7506BF821C9DF171AAF75C3228303D9E")
        @DSModeled(DSC.SPEC)
        public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
                int resultCode, String dataStr, Bundle extras, boolean ordered,
                boolean sticky) throws RemoteException {
            dsTaint.addTaint(sticky);
            dsTaint.addTaint(dataStr);
            dsTaint.addTaint(receiver.dsTaint);
            dsTaint.addTaint(ordered);
            dsTaint.addTaint(resultCode);
            dsTaint.addTaint(intent.dsTaint);
            dsTaint.addTaint(extras.dsTaint);
            receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
            // ---------- Original Method ----------
            //receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.398 -0400", hash_original_method = "1CA11DE4169634D3536C3A5288820C11", hash_generated_method = "C0AEC8819655C2E24AF50FB99520B4E3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void scheduleLowMemory() {
            queueOrSendMessage(H.LOW_MEMORY, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.LOW_MEMORY, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.399 -0400", hash_original_method = "1503BAA815C894047387C37D52FE75DC", hash_generated_method = "877156C8270B7B68FC1E489DDD93B3E8")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void scheduleActivityConfigurationChanged(IBinder token) {
            dsTaint.addTaint(token.dsTaint);
            queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.399 -0400", hash_original_method = "D92E635329F77F60C61D4CBABCC9E0E5", hash_generated_method = "E8CBF685650386E8115FCF86FE7A8F38")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void profilerControl(boolean start, String path, ParcelFileDescriptor fd,
                int profileType) {
            dsTaint.addTaint(profileType);
            dsTaint.addTaint(start);
            dsTaint.addTaint(path);
            dsTaint.addTaint(fd.dsTaint);
            ProfilerControlData pcd;
            pcd = new ProfilerControlData();
            pcd.path = path;
            pcd.fd = fd;
            queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
            // ---------- Original Method ----------
            //ProfilerControlData pcd = new ProfilerControlData();
            //pcd.path = path;
            //pcd.fd = fd;
            //queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.400 -0400", hash_original_method = "E2AA43C341E3E1223DC4327679137F86", hash_generated_method = "32F9D7865F564775DC2D48938DECA200")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dumpHeap(boolean managed, String path, ParcelFileDescriptor fd) {
            dsTaint.addTaint(managed);
            dsTaint.addTaint(path);
            dsTaint.addTaint(fd.dsTaint);
            DumpHeapData dhd;
            dhd = new DumpHeapData();
            dhd.path = path;
            dhd.fd = fd;
            queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
            // ---------- Original Method ----------
            //DumpHeapData dhd = new DumpHeapData();
            //dhd.path = path;
            //dhd.fd = fd;
            //queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.400 -0400", hash_original_method = "31DFA590CF69650795082863A4038E1E", hash_generated_method = "D7A5F7A29FE4037FEE343D6B088BA97D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setSchedulingGroup(int group) {
            dsTaint.addTaint(group);
            try 
            {
                Process.setProcessGroup(Process.myPid(), group);
            } //End block
            catch (Exception e)
            { }
            // ---------- Original Method ----------
            //try {
                //Process.setProcessGroup(Process.myPid(), group);
            //} catch (Exception e) {
                //Slog.w(TAG, "Failed setting process group to " + group, e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.401 -0400", hash_original_method = "7CB15E6FC063BB1B6B4AEB944EE130EF", hash_generated_method = "065C80FC0EF5457078AE85D7CF37E841")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void getMemoryInfo(Debug.MemoryInfo outInfo) {
            dsTaint.addTaint(outInfo.dsTaint);
            Debug.getMemoryInfo(outInfo);
            // ---------- Original Method ----------
            //Debug.getMemoryInfo(outInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.401 -0400", hash_original_method = "779EC3818AE8FA9E2AC523D128FB5D87", hash_generated_method = "49B3B54CB26F0F0827265CFC77EF41AB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dispatchPackageBroadcast(int cmd, String[] packages) {
            dsTaint.addTaint(cmd);
            dsTaint.addTaint(packages[0]);
            queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.402 -0400", hash_original_method = "E0613CA49761C406F1CB17CB9D000972", hash_generated_method = "96AC4DFAE6EFA50A41C5EB453E59233E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void scheduleCrash(String msg) {
            dsTaint.addTaint(msg);
            queueOrSendMessage(H.SCHEDULE_CRASH, msg);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SCHEDULE_CRASH, msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.402 -0400", hash_original_method = "D7BE3A9B3D448EC9431A34B711555765", hash_generated_method = "9353CF927DEAF5F8C1B6FD479246C39D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dumpActivity(FileDescriptor fd, IBinder activitytoken,
                String prefix, String[] args) {
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(activitytoken.dsTaint);
            dsTaint.addTaint(fd.dsTaint);
            DumpComponentInfo data;
            data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = activitytoken;
                data.prefix = prefix;
                data.args = args;
                queueOrSendMessage(H.DUMP_ACTIVITY, data);
            } //End block
            catch (IOException e)
            { }
            // ---------- Original Method ----------
            //DumpComponentInfo data = new DumpComponentInfo();
            //try {
                //data.fd = ParcelFileDescriptor.dup(fd);
                //data.token = activitytoken;
                //data.prefix = prefix;
                //data.args = args;
                //queueOrSendMessage(H.DUMP_ACTIVITY, data);
            //} catch (IOException e) {
                //Slog.w(TAG, "dumpActivity failed", e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.403 -0400", hash_original_method = "648F3C65CFB469E019D9747F832AE1E8", hash_generated_method = "82A421404DC0943CB882664EAC03E86D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin,
                boolean all, String[] args) {
            dsTaint.addTaint(checkin);
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(fd.dsTaint);
            dsTaint.addTaint(all);
            FileOutputStream fout;
            fout = new FileOutputStream(fd);
            PrintWriter pw;
            pw = new PrintWriter(fout);
            try 
            {
                Debug.MemoryInfo varA29D0152F38C108CE0BC059FE6BAC2E6_237978608 = (dumpMemInfo(pw, checkin, all, args));
            } //End block
            finally 
            {
                pw.flush();
            } //End block
            return (Debug.MemoryInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //FileOutputStream fout = new FileOutputStream(fd);
            //PrintWriter pw = new PrintWriter(fout);
            //try {
                //return dumpMemInfo(pw, checkin, all, args);
            //} finally {
                //pw.flush();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.408 -0400", hash_original_method = "468180529DE63D6D9E6979D7BD66773F", hash_generated_method = "A779FBC02F6518DC79E6CBD351700B7A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private Debug.MemoryInfo dumpMemInfo(PrintWriter pw, boolean checkin, boolean all,
                String[] args) {
            dsTaint.addTaint(checkin);
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(pw.dsTaint);
            dsTaint.addTaint(all);
            long nativeMax;
            nativeMax = Debug.getNativeHeapSize() / 1024;
            long nativeAllocated;
            nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeFree;
            nativeFree = Debug.getNativeHeapFreeSize() / 1024;
            Debug.MemoryInfo memInfo;
            memInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memInfo);
            Runtime runtime;
            runtime = Runtime.getRuntime();
            long dalvikMax;
            dalvikMax = runtime.totalMemory() / 1024;
            long dalvikFree;
            dalvikFree = runtime.freeMemory() / 1024;
            long dalvikAllocated;
            dalvikAllocated = dalvikMax - dalvikFree;
            long viewInstanceCount;
            viewInstanceCount = ViewDebug.getViewInstanceCount();
            long viewRootInstanceCount;
            viewRootInstanceCount = ViewDebug.getViewRootImplCount();
            long appContextInstanceCount;
            appContextInstanceCount = Debug.countInstancesOfClass(ContextImpl.class);
            long activityInstanceCount;
            activityInstanceCount = Debug.countInstancesOfClass(Activity.class);
            int globalAssetCount;
            globalAssetCount = AssetManager.getGlobalAssetCount();
            int globalAssetManagerCount;
            globalAssetManagerCount = AssetManager.getGlobalAssetManagerCount();
            int binderLocalObjectCount;
            binderLocalObjectCount = Debug.getBinderLocalObjectCount();
            int binderProxyObjectCount;
            binderProxyObjectCount = Debug.getBinderProxyObjectCount();
            int binderDeathObjectCount;
            binderDeathObjectCount = Debug.getBinderDeathObjectCount();
            long openSslSocketCount;
            openSslSocketCount = Debug.countInstancesOfClass(OpenSSLSocketImpl.class);
            long sqliteAllocated;
            sqliteAllocated = SQLiteDebug.getHeapAllocatedSize() / 1024;
            SQLiteDebug.PagerStats stats;
            stats = SQLiteDebug.getDatabaseInfo();
            {
                String processName;
                processName = mBoundApplication.processName;
                processName = "unknown";
                pw.print(ACTIVITY_THREAD_CHECKIN_VERSION);
                pw.print(',');
                pw.print(Process.myPid());
                pw.print(',');
                pw.print(processName);
                pw.print(',');
                pw.print(nativeMax);
                pw.print(',');
                pw.print(dalvikMax);
                pw.print(',');
                pw.print("N/A,");
                pw.print(nativeMax + dalvikMax);
                pw.print(',');
                pw.print(nativeAllocated);
                pw.print(',');
                pw.print(dalvikAllocated);
                pw.print(',');
                pw.print("N/A,");
                pw.print(nativeAllocated + dalvikAllocated);
                pw.print(',');
                pw.print(nativeFree);
                pw.print(',');
                pw.print(dalvikFree);
                pw.print(',');
                pw.print("N/A,");
                pw.print(nativeFree + dalvikFree);
                pw.print(',');
                pw.print(memInfo.nativePss);
                pw.print(',');
                pw.print(memInfo.dalvikPss);
                pw.print(',');
                pw.print(memInfo.otherPss);
                pw.print(',');
                pw.print(memInfo.nativePss + memInfo.dalvikPss + memInfo.otherPss);
                pw.print(',');
                pw.print(memInfo.nativeSharedDirty);
                pw.print(',');
                pw.print(memInfo.dalvikSharedDirty);
                pw.print(',');
                pw.print(memInfo.otherSharedDirty);
                pw.print(',');
                pw.print(memInfo.nativeSharedDirty + memInfo.dalvikSharedDirty
                        + memInfo.otherSharedDirty);
                pw.print(',');
                pw.print(memInfo.nativePrivateDirty);
                pw.print(',');
                pw.print(memInfo.dalvikPrivateDirty);
                pw.print(',');
                pw.print(memInfo.otherPrivateDirty);
                pw.print(',');
                pw.print(memInfo.nativePrivateDirty + memInfo.dalvikPrivateDirty
                        + memInfo.otherPrivateDirty);
                pw.print(',');
                pw.print(viewInstanceCount);
                pw.print(',');
                pw.print(viewRootInstanceCount);
                pw.print(',');
                pw.print(appContextInstanceCount);
                pw.print(',');
                pw.print(activityInstanceCount);
                pw.print(',');
                pw.print(globalAssetCount);
                pw.print(',');
                pw.print(globalAssetManagerCount);
                pw.print(',');
                pw.print(binderLocalObjectCount);
                pw.print(',');
                pw.print(binderProxyObjectCount);
                pw.print(',');
                pw.print(binderDeathObjectCount);
                pw.print(',');
                pw.print(openSslSocketCount);
                pw.print(',');
                pw.print(sqliteAllocated);
                pw.print(',');
                pw.print(stats.memoryUsed / 1024);
                pw.print(',');
                pw.print(stats.pageCacheOverflo / 1024);
                pw.print(',');
                pw.print(stats.largestMemAlloc / 1024);
                {
                    int i;
                    i = 0;
                    boolean var34DA22B98BE69F3557BBBED2C262409B_242403321 = (i < stats.dbStats.size());
                    {
                        DbStats dbStats;
                        dbStats = stats.dbStats.get(i);
                        pw.print(',');
                        pw.print(dbStats.dbName);
                        pw.print(',');
                        pw.print(dbStats.pageSize);
                        pw.print(',');
                        pw.print(dbStats.dbSize);
                        pw.print(',');
                        pw.print(dbStats.lookaside);
                        pw.print(',');
                        pw.print(dbStats.cache);
                        pw.print(',');
                        pw.print(dbStats.cache);
                    } //End block
                } //End collapsed parenthetic
                pw.println();
            } //End block
            printRow(pw, HEAP_COLUMN, "", "", "Shared", "Private", "Heap", "Heap", "Heap");
            printRow(pw, HEAP_COLUMN, "", "Pss", "Dirty", "Dirty", "Size", "Alloc", "Free");
            printRow(pw, HEAP_COLUMN, "", "------", "------", "------", "------", "------",
                    "------");
            printRow(pw, HEAP_COLUMN, "Native", memInfo.nativePss, memInfo.nativeSharedDirty,
                    memInfo.nativePrivateDirty, nativeMax, nativeAllocated, nativeFree);
            printRow(pw, HEAP_COLUMN, "Dalvik", memInfo.dalvikPss, memInfo.dalvikSharedDirty,
                    memInfo.dalvikPrivateDirty, dalvikMax, dalvikAllocated, dalvikFree);
            int otherPss;
            otherPss = memInfo.otherPss;
            int otherSharedDirty;
            otherSharedDirty = memInfo.otherSharedDirty;
            int otherPrivateDirty;
            otherPrivateDirty = memInfo.otherPrivateDirty;
            {
                int i;
                i = 0;
                {
                    printRow(pw, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i),
                        memInfo.getOtherPss(i), memInfo.getOtherSharedDirty(i),
                        memInfo.getOtherPrivateDirty(i), "", "", "");
                    otherPss -= memInfo.getOtherPss(i);
                    otherSharedDirty -= memInfo.getOtherSharedDirty(i);
                    otherPrivateDirty -= memInfo.getOtherPrivateDirty(i);
                } //End block
            } //End collapsed parenthetic
            printRow(pw, HEAP_COLUMN, "Unknown", otherPss, otherSharedDirty,
                    otherPrivateDirty, "", "", "");
            printRow(pw, HEAP_COLUMN, "TOTAL", memInfo.getTotalPss(),
                    memInfo.getTotalSharedDirty(), memInfo.getTotalPrivateDirty(),
                    nativeMax+dalvikMax, nativeAllocated+dalvikAllocated,
                    nativeFree+dalvikFree);
            pw.println(" ");
            pw.println(" Objects");
            printRow(pw, TWO_COUNT_COLUMNS, "Views:", viewInstanceCount, "ViewRootImpl:",
                    viewRootInstanceCount);
            printRow(pw, TWO_COUNT_COLUMNS, "AppContexts:", appContextInstanceCount,
                    "Activities:", activityInstanceCount);
            printRow(pw, TWO_COUNT_COLUMNS, "Assets:", globalAssetCount,
                    "AssetManagers:", globalAssetManagerCount);
            printRow(pw, TWO_COUNT_COLUMNS, "Local Binders:", binderLocalObjectCount,
                    "Proxy Binders:", binderProxyObjectCount);
            printRow(pw, ONE_COUNT_COLUMN, "Death Recipients:", binderDeathObjectCount);
            printRow(pw, ONE_COUNT_COLUMN, "OpenSSL Sockets:", openSslSocketCount);
            pw.println(" ");
            pw.println(" SQL");
            printRow(pw, TWO_COUNT_COLUMNS_DB, "heap:", sqliteAllocated, "MEMORY_USED:",
                    stats.memoryUsed / 1024);
            printRow(pw, TWO_COUNT_COLUMNS_DB, "PAGECACHE_OVERFLOW:",
                    stats.pageCacheOverflo / 1024, "MALLOC_SIZE:", stats.largestMemAlloc / 1024);
            pw.println(" ");
            int N;
            N = stats.dbStats.size();
            {
                pw.println(" DATABASES");
                printRow(pw, "  %8s %8s %14s %14s  %s", "pgsz", "dbsz", "Lookaside(b)", "cache",
                        "Dbname");
                {
                    int i;
                    i = 0;
                    {
                        DbStats dbStats;
                        dbStats = stats.dbStats.get(i);
                        printRow(pw, DB_INFO_FORMAT,
                            (dbStats.pageSize > 0) ? String.valueOf(dbStats.pageSize) : " ",
                            (dbStats.dbSize > 0) ? String.valueOf(dbStats.dbSize) : " ",
                            (dbStats.lookaside > 0) ? String.valueOf(dbStats.lookaside) : " ",
                            dbStats.cache, dbStats.dbName);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            String assetAlloc;
            assetAlloc = AssetManager.getAssetAllocations();
            {
                pw.println(" ");
                pw.println(" Asset Allocations");
                pw.print(assetAlloc);
            } //End block
            return (Debug.MemoryInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.409 -0400", hash_original_method = "DBE19F37C980DCB637B8E3CCE0C6D7AE", hash_generated_method = "75ED91A352D46AA462E6833F050F0AFB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void dumpGfxInfo(FileDescriptor fd, String[] args) {
            dsTaint.addTaint(args[0]);
            dsTaint.addTaint(fd.dsTaint);
            dumpGraphicsInfo(fd);
            WindowManagerImpl.getDefault().dumpGfxInfo(fd);
            // ---------- Original Method ----------
            //dumpGraphicsInfo(fd);
            //WindowManagerImpl.getDefault().dumpGfxInfo(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.411 -0400", hash_original_method = "E9FD23CC6BA5457F811332501D367E07", hash_generated_method = "34E3375F347BB6EB56FE189778CEE150")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void printRow(PrintWriter pw, String format, Object...objs) {
            dsTaint.addTaint(objs[0].dsTaint);
            dsTaint.addTaint(format);
            dsTaint.addTaint(pw.dsTaint);
            pw.println(String.format(format, objs));
            // ---------- Original Method ----------
            //pw.println(String.format(format, objs));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.412 -0400", hash_original_method = "5D81A3C132332FC039C36D652A159D52", hash_generated_method = "D2D4999F5E3902C5391552C8C7D13997")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setCoreSettings(Bundle coreSettings) {
            dsTaint.addTaint(coreSettings.dsTaint);
            queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.414 -0400", hash_original_method = "915F19E7DF7511DDBDEE0EA8781AD484", hash_generated_method = "92E3E775B92E182A10397ABD03D97A4B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) {
            dsTaint.addTaint(pkg);
            dsTaint.addTaint(info.dsTaint);
            UpdateCompatibilityData ucd;
            ucd = new UpdateCompatibilityData();
            ucd.pkg = pkg;
            ucd.info = info;
            queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
            // ---------- Original Method ----------
            //UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            //ucd.pkg = pkg;
            //ucd.info = info;
            //queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.414 -0400", hash_original_method = "713723E30DD42F550C53D06876722D4F", hash_generated_method = "C7254EBA48EEE211B893E932A28819CE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void scheduleTrimMemory(int level) {
            dsTaint.addTaint(level);
            queueOrSendMessage(H.TRIM_MEMORY, null, level);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.TRIM_MEMORY, null, level);
        }

        
        private static final String HEAP_COLUMN = "%13s %8s %8s %8s %8s %8s %8s";
        private static final String ONE_COUNT_COLUMN = "%21s %8d";
        private static final String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
        private static final String TWO_COUNT_COLUMNS_DB = "%21s %8d %21s %8d";
        private static final String DB_INFO_FORMAT = "  %8s %8s %14s %14s  %s";
        private static final int ACTIVITY_THREAD_CHECKIN_VERSION = 1;
    }


    
    private class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.415 -0400", hash_original_method = "3D972BE2AB2C2313AC27EF8BE558C9F4", hash_generated_method = "3D972BE2AB2C2313AC27EF8BE558C9F4")
                public H ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.416 -0400", hash_original_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C", hash_generated_method = "7AC84CDD50E51ACF72D368BCB9B5B5C7")
        @DSModeled(DSC.SAFE)
         String codeToString(int code) {
            dsTaint.addTaint(code);
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.418 -0400", hash_original_method = "DC9C3E5B703CFDFA18C27F800AA1CA40", hash_generated_method = "6A8B56CAE694E4F860AE6CFBCEB0C9AD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void handleMessage(Message msg) {
            dsTaint.addTaint(msg.dsTaint);
            //Begin case LAUNCH_ACTIVITY 
            {
                ActivityClientRecord r;
                r = (ActivityClientRecord)msg.obj;
                r.packageInfo = getPackageInfoNoCheck(
                            r.activityInfo.applicationInfo, r.compatInfo);
                handleLaunchActivity(r, null);
            } //End block
            //End case LAUNCH_ACTIVITY 
            //Begin case RELAUNCH_ACTIVITY 
            {
                ActivityClientRecord r;
                r = (ActivityClientRecord)msg.obj;
                handleRelaunchActivity(r);
            } //End block
            //End case RELAUNCH_ACTIVITY 
            //Begin case PAUSE_ACTIVITY 
            handlePauseActivity((IBinder)msg.obj, false, msg.arg1 != 0, msg.arg2);
            //End case PAUSE_ACTIVITY 
            //Begin case PAUSE_ACTIVITY 
            maybeSnapshot();
            //End case PAUSE_ACTIVITY 
            //Begin case PAUSE_ACTIVITY_FINISHING 
            handlePauseActivity((IBinder)msg.obj, true, msg.arg1 != 0, msg.arg2);
            //End case PAUSE_ACTIVITY_FINISHING 
            //Begin case STOP_ACTIVITY_SHOW 
            handleStopActivity((IBinder)msg.obj, true, msg.arg2);
            //End case STOP_ACTIVITY_SHOW 
            //Begin case STOP_ACTIVITY_HIDE 
            handleStopActivity((IBinder)msg.obj, false, msg.arg2);
            //End case STOP_ACTIVITY_HIDE 
            //Begin case SHOW_WINDOW 
            handleWindowVisibility((IBinder)msg.obj, true);
            //End case SHOW_WINDOW 
            //Begin case HIDE_WINDOW 
            handleWindowVisibility((IBinder)msg.obj, false);
            //End case HIDE_WINDOW 
            //Begin case RESUME_ACTIVITY 
            handleResumeActivity((IBinder)msg.obj, true,
                            msg.arg1 != 0);
            //End case RESUME_ACTIVITY 
            //Begin case SEND_RESULT 
            handleSendResult((ResultData)msg.obj);
            //End case SEND_RESULT 
            //Begin case DESTROY_ACTIVITY 
            handleDestroyActivity((IBinder)msg.obj, msg.arg1 != 0,
                            msg.arg2, false);
            //End case DESTROY_ACTIVITY 
            //Begin case BIND_APPLICATION 
            AppBindData data;
            data = (AppBindData)msg.obj;
            //End case BIND_APPLICATION 
            //Begin case BIND_APPLICATION 
            handleBindApplication(data);
            //End case BIND_APPLICATION 
            //Begin case EXIT_APPLICATION 
            {
                mInitialApplication.onTerminate();
            } //End block
            //End case EXIT_APPLICATION 
            //Begin case EXIT_APPLICATION 
            Looper.myLooper().quit();
            //End case EXIT_APPLICATION 
            //Begin case NEW_INTENT 
            handleNewIntent((NewIntentData)msg.obj);
            //End case NEW_INTENT 
            //Begin case RECEIVER 
            handleReceiver((ReceiverData)msg.obj);
            //End case RECEIVER 
            //Begin case RECEIVER 
            maybeSnapshot();
            //End case RECEIVER 
            //Begin case CREATE_SERVICE 
            handleCreateService((CreateServiceData)msg.obj);
            //End case CREATE_SERVICE 
            //Begin case BIND_SERVICE 
            handleBindService((BindServiceData)msg.obj);
            //End case BIND_SERVICE 
            //Begin case UNBIND_SERVICE 
            handleUnbindService((BindServiceData)msg.obj);
            //End case UNBIND_SERVICE 
            //Begin case SERVICE_ARGS 
            handleServiceArgs((ServiceArgsData)msg.obj);
            //End case SERVICE_ARGS 
            //Begin case STOP_SERVICE 
            handleStopService((IBinder)msg.obj);
            //End case STOP_SERVICE 
            //Begin case STOP_SERVICE 
            maybeSnapshot();
            //End case STOP_SERVICE 
            //Begin case REQUEST_THUMBNAIL 
            handleRequestThumbnail((IBinder)msg.obj);
            //End case REQUEST_THUMBNAIL 
            //Begin case CONFIGURATION_CHANGED 
            handleConfigurationChanged((Configuration)msg.obj, null);
            //End case CONFIGURATION_CHANGED 
            //Begin case CLEAN_UP_CONTEXT 
            ContextCleanupInfo cci;
            cci = (ContextCleanupInfo)msg.obj;
            //End case CLEAN_UP_CONTEXT 
            //Begin case CLEAN_UP_CONTEXT 
            cci.context.performFinalCleanup(cci.who, cci.what);
            //End case CLEAN_UP_CONTEXT 
            //Begin case GC_WHEN_IDLE 
            scheduleGcIdler();
            //End case GC_WHEN_IDLE 
            //Begin case DUMP_SERVICE 
            handleDumpService((DumpComponentInfo)msg.obj);
            //End case DUMP_SERVICE 
            //Begin case LOW_MEMORY 
            handleLowMemory();
            //End case LOW_MEMORY 
            //Begin case ACTIVITY_CONFIGURATION_CHANGED 
            handleActivityConfigurationChanged((IBinder)msg.obj);
            //End case ACTIVITY_CONFIGURATION_CHANGED 
            //Begin case PROFILER_CONTROL 
            handleProfilerControl(msg.arg1 != 0, (ProfilerControlData)msg.obj, msg.arg2);
            //End case PROFILER_CONTROL 
            //Begin case CREATE_BACKUP_AGENT 
            handleCreateBackupAgent((CreateBackupAgentData)msg.obj);
            //End case CREATE_BACKUP_AGENT 
            //Begin case DESTROY_BACKUP_AGENT 
            handleDestroyBackupAgent((CreateBackupAgentData)msg.obj);
            //End case DESTROY_BACKUP_AGENT 
            //Begin case SUICIDE 
            Process.killProcess(Process.myPid());
            //End case SUICIDE 
            //Begin case REMOVE_PROVIDER 
            completeRemoveProvider((IContentProvider)msg.obj);
            //End case REMOVE_PROVIDER 
            //Begin case ENABLE_JIT 
            ensureJitEnabled();
            //End case ENABLE_JIT 
            //Begin case DISPATCH_PACKAGE_BROADCAST 
            handleDispatchPackageBroadcast(msg.arg1, (String[])msg.obj);
            //End case DISPATCH_PACKAGE_BROADCAST 
            //Begin case SCHEDULE_CRASH 
            if (DroidSafeAndroidRuntime.control) throw new RemoteServiceException((String)msg.obj);
            //End case SCHEDULE_CRASH 
            //Begin case DUMP_HEAP 
            handleDumpHeap(msg.arg1 != 0, (DumpHeapData)msg.obj);
            //End case DUMP_HEAP 
            //Begin case DUMP_ACTIVITY 
            handleDumpActivity((DumpComponentInfo)msg.obj);
            //End case DUMP_ACTIVITY 
            //Begin case SLEEPING 
            handleSleeping((IBinder)msg.obj, msg.arg1 != 0);
            //End case SLEEPING 
            //Begin case SET_CORE_SETTINGS 
            handleSetCoreSettings((Bundle) msg.obj);
            //End case SET_CORE_SETTINGS 
            //Begin case UPDATE_PACKAGE_COMPATIBILITY_INFO 
            handleUpdatePackageCompatibilityInfo((UpdateCompatibilityData)msg.obj);
            //End case UPDATE_PACKAGE_COMPATIBILITY_INFO 
            //Begin case TRIM_MEMORY 
            handleTrimMemory(msg.arg1);
            //End case TRIM_MEMORY 
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.419 -0400", hash_original_method = "E92E43C77FF76A1843097A49ADA7442E", hash_generated_method = "BC967E089F9043174651088BAAACF125")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void maybeSnapshot() {
            {
                boolean var729A603993F3B35DA9B3209A1DADBC52_300261541 = (mBoundApplication != null && SamplingProfilerIntegration.isEnabled());
                {
                    String packageName;
                    packageName = mBoundApplication.info.mPackageName;
                    android.content.pm.PackageInfo packageInfo;
                    packageInfo = null;
                    try 
                    {
                        Context context;
                        context = getSystemContext();
                        PackageManager pm;
                        pm = context.getPackageManager();
                        packageInfo = pm.getPackageInfo(
                            packageName, PackageManager.GET_ACTIVITIES);
                    } //End block
                    catch (NameNotFoundException e)
                    { }
                    SamplingProfilerIntegration.writeSnapshot(mBoundApplication.processName, packageInfo);
                } //End block
            } //End collapsed parenthetic
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        public static final int LAUNCH_ACTIVITY         = 100;
        public static final int PAUSE_ACTIVITY          = 101;
        public static final int PAUSE_ACTIVITY_FINISHING= 102;
        public static final int STOP_ACTIVITY_SHOW      = 103;
        public static final int STOP_ACTIVITY_HIDE      = 104;
        public static final int SHOW_WINDOW             = 105;
        public static final int HIDE_WINDOW             = 106;
        public static final int RESUME_ACTIVITY         = 107;
        public static final int SEND_RESULT             = 108;
        public static final int DESTROY_ACTIVITY        = 109;
        public static final int BIND_APPLICATION        = 110;
        public static final int EXIT_APPLICATION        = 111;
        public static final int NEW_INTENT              = 112;
        public static final int RECEIVER                = 113;
        public static final int CREATE_SERVICE          = 114;
        public static final int SERVICE_ARGS            = 115;
        public static final int STOP_SERVICE            = 116;
        public static final int REQUEST_THUMBNAIL       = 117;
        public static final int CONFIGURATION_CHANGED   = 118;
        public static final int CLEAN_UP_CONTEXT        = 119;
        public static final int GC_WHEN_IDLE            = 120;
        public static final int BIND_SERVICE            = 121;
        public static final int UNBIND_SERVICE          = 122;
        public static final int DUMP_SERVICE            = 123;
        public static final int LOW_MEMORY              = 124;
        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        public static final int RELAUNCH_ACTIVITY       = 126;
        public static final int PROFILER_CONTROL        = 127;
        public static final int CREATE_BACKUP_AGENT     = 128;
        public static final int DESTROY_BACKUP_AGENT    = 129;
        public static final int SUICIDE                 = 130;
        public static final int REMOVE_PROVIDER         = 131;
        public static final int ENABLE_JIT              = 132;
        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        public static final int SCHEDULE_CRASH          = 134;
        public static final int DUMP_HEAP               = 135;
        public static final int DUMP_ACTIVITY           = 136;
        public static final int SLEEPING                = 137;
        public static final int SET_CORE_SETTINGS       = 138;
        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
        public static final int TRIM_MEMORY             = 140;
    }


    
    private class Idler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.420 -0400", hash_original_method = "0FB458011D54C56E1D7C9716DB0AD58B", hash_generated_method = "0FB458011D54C56E1D7C9716DB0AD58B")
                public Idler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.421 -0400", hash_original_method = "7124AFC3D8D2CB12FD15B850DC795363", hash_generated_method = "43E08B69E9342D9474114A60ED81696E")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean queueIdle() {
            ActivityClientRecord a;
            a = mNewActivities;
            boolean stopProfiling;
            stopProfiling = false;
            {
                stopProfiling = true;
            } //End block
            {
                mNewActivities = null;
                IActivityManager am;
                am = ActivityManagerNative.getDefault();
                ActivityClientRecord prev;
                {
                    {
                        try 
                        {
                            am.activityIdle(a.token, a.createdConfig, stopProfiling);
                            a.createdConfig = null;
                        } //End block
                        catch (RemoteException ex)
                        { }
                    } //End block
                    prev = a;
                    a = a.nextIdle;
                    prev.nextIdle = null;
                } //End block
            } //End block
            {
                mProfiler.stopProfiling();
            } //End block
            ensureJitEnabled();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    final class GcIdler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.422 -0400", hash_original_method = "AC41E9EDD9928466DBAEA6AA4B08835D", hash_generated_method = "AC41E9EDD9928466DBAEA6AA4B08835D")
                public GcIdler ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.422 -0400", hash_original_method = "44179B8732E18ADC2B8565E550483147", hash_generated_method = "22C8F9C720A596198676CEF4D1A9E9B9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final boolean queueIdle() {
            doGcIfNeeded();
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //doGcIfNeeded();
            //return false;
        }

        
    }


    
    private static class ResourcesKey {
        private String mResDir;
        private float mScale;
        private int mHash;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.423 -0400", hash_original_method = "0A249A0E32348D1ED1AC3A6D16406BEA", hash_generated_method = "470A3E62B373B7C6E5B6285970917609")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         ResourcesKey(String resDir, float scale) {
            dsTaint.addTaint(scale);
            dsTaint.addTaint(resDir);
            mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
            // ---------- Original Method ----------
            //mResDir = resDir;
            //mScale = scale;
            //mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.423 -0400", hash_original_method = "FDD99B6C6105A3F31D8E7DC9390101DA", hash_generated_method = "B6FD66B12238AD7826ECB848634185A4")
        @DSModeled(DSC.SAFE)
        @Override
        public int hashCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return mHash;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.424 -0400", hash_original_method = "07DFB89699884113D8C2B96163B07C7F", hash_generated_method = "A6AA0499E884F04E0DD3246B029927C2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public boolean equals(Object obj) {
            dsTaint.addTaint(obj.dsTaint);
            ResourcesKey peer;
            peer = (ResourcesKey) obj;
            boolean var54097B77060828B14B7DD9EC110667F0_1941346802 = (mResDir.equals(peer.mResDir) && mScale == peer.mScale);
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //if (!(obj instanceof ResourcesKey)) {
                //return false;
            //}
            //ResourcesKey peer = (ResourcesKey) obj;
            //return mResDir.equals(peer.mResDir) && mScale == peer.mScale;
        }

        
    }


    
    private static class StopInfo {
        Bitmap thumbnail;
        CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.424 -0400", hash_original_method = "7112A0424A2EA9DA61FB9AD0FA991D79", hash_generated_method = "7112A0424A2EA9DA61FB9AD0FA991D79")
                public StopInfo ()
        {
        }


    }


    
    private static final class ProviderRefCount {
        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.424 -0400", hash_original_method = "92B7A170BA9BC140C9702B48E38F46E8", hash_generated_method = "268D2AB347D2C01026EBD2899A64F053")
        @DSModeled(DSC.SAFE)
         ProviderRefCount(int pCount) {
            dsTaint.addTaint(pCount);
            // ---------- Original Method ----------
            //count = pCount;
        }

        
    }


    
    public static final String TAG = "ActivityThread";
    private static final android.graphics.Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
    static final boolean localLOGV = false;
    static final boolean DEBUG_MESSAGES = false;
    public static final boolean DEBUG_BROADCAST = false;
    private static final boolean DEBUG_RESULTS = false;
    private static final boolean DEBUG_BACKUP = true;
    private static final boolean DEBUG_CONFIGURATION = false;
    private static final long MIN_TIME_BETWEEN_GCS = 5*1000;
    private static final Pattern PATTERN_SEMICOLON = Pattern.compile(";");
    private static final int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
    private static final int LOG_ON_PAUSE_CALLED = 30021;
    private static final int LOG_ON_RESUME_CALLED = 30022;
    static ContextImpl mSystemContext = null;
    static IPackageManager sPackageManager;
    static final ThreadLocal<ActivityThread> sThreadLocal = new ThreadLocal<ActivityThread>();
    static Handler sMainThreadHandler;
    private static final ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<Intent>();
}

