package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.350 -0400", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "15811A6DE9C2E964B99F6377F947BD45")
    public  SuperNotCalledException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

final class RemoteServiceException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.350 -0400", hash_original_method = "34FE87499D0272DFF74E34D7FF4C8A87", hash_generated_method = "9A8916256CBCF45D2502CDF5D2E2014D")
    public  RemoteServiceException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

public final class ActivityThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "B53D6F39CF0756976F39C3EF8C9347C8", hash_generated_field = "2C05F6440224B9B7B649AAB8E25E7F6C")

    final ApplicationThread mAppThread = new ApplicationThread();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "22026F7CA49D7800DC9226FB14F18D4E", hash_generated_field = "9DB6C1654FE8632B559AD8938C2BB6D6")

    final Looper mLooper = Looper.myLooper();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "0E2EFBC2E5CA04A190F128248BAC384F", hash_generated_field = "C347DA9A9231B315F279E735B8928A09")

    final H mH = new H();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "5140A1A9D96802BCD33EE8109598D4E9", hash_generated_field = "22A9122B8D2BCD21314C7F1C05E1CE1E")

    final HashMap<IBinder, ActivityClientRecord> mActivities = new HashMap<IBinder, ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "2596BE0728EC6D0B3DD8489111BCE626", hash_generated_field = "B71C13DCB6A9130D877B8D4E74CC61E9")

    ActivityClientRecord mNewActivities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.353 -0400", hash_original_field = "73A5CC022DE998406F6B6FE5D86E0FC9", hash_generated_field = "C9408B24459238C3188BD4D966397F6A")

    int mNumVisibleActivities = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.354 -0400", hash_original_field = "61AC602172BC64F1EFD6C846BCAC6EA5", hash_generated_field = "273635D78F4F1853FCFEAE6F3977F1CA")

    final HashMap<IBinder, Service> mServices = new HashMap<IBinder, Service>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.354 -0400", hash_original_field = "E1323E77467AAA94220311B9002D86DC", hash_generated_field = "61B01177607D3FEF9030C1D9609A65D2")

    AppBindData mBoundApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.354 -0400", hash_original_field = "3813FD00D078EDC298A6165A01B23375", hash_generated_field = "137FC81C700701DC4596025475ABF5FB")

    Profiler mProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.354 -0400", hash_original_field = "2A37B83F421C69FA65AB0336DCD40F61", hash_generated_field = "17926FA2B84283931976E0CD16AD732E")

    Configuration mConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.354 -0400", hash_original_field = "9BD99EFAE86DB5408E1E53D94FB68EF1", hash_generated_field = "22A6186D8E2A9BFF1CD600DA1D66E51D")

    Configuration mCompatConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "07E1B5B9B806672E596B36E6C58FDD44", hash_generated_field = "EAF24A11BB6A5B40B8CD0A9DD97E14E0")

    Configuration mResConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "FFC49FFC4C1ADAB5104047620A7D56C4", hash_generated_field = "EA04CA285EC541B77CDD4831DDC16DBF")

    CompatibilityInfo mResCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "BE63E38FE23E99043AF34F6BEC9CDB32", hash_generated_field = "9E9AEECCAC03AFADA449BC8121CFBA7B")

    Application mInitialApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "9754DC7CB34C86576E6459500AEBA7A8", hash_generated_field = "4467AD43E1EF6F9556A530390DF013D4")

    final ArrayList<Application> mAllApplications = new ArrayList<Application>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "DDC10AFA30585BFE20C9F9446377894E", hash_generated_field = "3547FC58C151AD461F39E0C090811C7E")

    final HashMap<String, BackupAgent> mBackupAgents = new HashMap<String, BackupAgent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.355 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

    Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.356 -0400", hash_original_field = "3F33A383895BCD9FFD4FF85E994A91B3", hash_generated_field = "BC772FC243D47A489F2D7EFDAE87E511")

    String mInstrumentationAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.356 -0400", hash_original_field = "E384AAD9DCDFF1E8D0CD8D0A19256B7C", hash_generated_field = "FECBD9A8D7E48015CA8B1CB4E8417096")

    String mInstrumentationAppPackage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.356 -0400", hash_original_field = "9BFC607661C16E486035F6C16F2728BF", hash_generated_field = "8A05224BF80336D163F84B1774E94778")

    String mInstrumentedAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.356 -0400", hash_original_field = "4E393FC3E9967B2FBCC5BD30CD6D6121", hash_generated_field = "A1282214A6522F9FAF740141A5995478")

    boolean mSystemThread = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.356 -0400", hash_original_field = "2ADB2DE2F0908AF94082A4D9E402F85C", hash_generated_field = "CA9794682AE3611FC2EF8314769D534A")

    boolean mJitEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.357 -0400", hash_original_field = "2F3B136DE313E1E070DB549F1244D943", hash_generated_field = "1EDAA3CA75AF739BF8D18A37DF3C0780")

    final HashMap<String, WeakReference<LoadedApk>> mPackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.357 -0400", hash_original_field = "E54DD7B740A85C91DABABE72B3B095EB", hash_generated_field = "D05B59FB5762244EFE6413375736785F")

    final HashMap<String, WeakReference<LoadedApk>> mResourcePackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.357 -0400", hash_original_field = "8F7DF79A1A56B58604502A94A5CC013A", hash_generated_field = "E6A3BBCB9BEFEBC10A10A94F36F55D2A")

    final HashMap<CompatibilityInfo, DisplayMetrics> mDisplayMetrics = new HashMap<CompatibilityInfo, DisplayMetrics>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.357 -0400", hash_original_field = "2FFFBD4436769ADEF3F6BE93035E29EA", hash_generated_field = "54C77904755445223E6762582AF7167C")

    final HashMap<ResourcesKey, WeakReference<Resources> > mActiveResources = new HashMap<ResourcesKey, WeakReference<Resources> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.357 -0400", hash_original_field = "E0C0F3A1D8876C73109C81652022AE20", hash_generated_field = "FDE1BC39BB1A6D9E731AFE2002BB269D")

    final ArrayList<ActivityClientRecord> mRelaunchingActivities = new ArrayList<ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.358 -0400", hash_original_field = "F5DB0E5D46891F17B40D6AE0558F2A3E", hash_generated_field = "52608F8A47308D1928152A18CB1F8EE5")

    Configuration mPendingConfiguration = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.358 -0400", hash_original_field = "DAFE2855A8819A2CAFDA3A7DC574897D", hash_generated_field = "1CEA5FD2A88003C9D7DAC40EC96872BE")

    final HashMap<String, ProviderClientRecord> mProviderMap = new HashMap<String, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.358 -0400", hash_original_field = "FAD775743D6E65E861C71DE7D10EDCC7", hash_generated_field = "1C776D7BB444F45BF4ABA07E0A6EA27B")

    final HashMap<IBinder, ProviderRefCount> mProviderRefCountMap = new HashMap<IBinder, ProviderRefCount>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.358 -0400", hash_original_field = "67EF4D3C5C70C137D7F9C1C0643D46E2", hash_generated_field = "77FD57C0A1A6E5A9B2317F5C55C5410F")

    final HashMap<IBinder, ProviderClientRecord> mLocalProviders = new HashMap<IBinder, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.358 -0400", hash_original_field = "219DD26B03E1DDCCF0E4339F403F8A1B", hash_generated_field = "7290AC21C9E09A440EA99C73747C36E5")

    final HashMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners = new HashMap<Activity, ArrayList<OnActivityPausedListener>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.359 -0400", hash_original_field = "95C2F14E893DEE4E51A4A3450B6F5DDE", hash_generated_field = "0DC5B4AA3D0A311BCB82DC76A964596E")

    final GcIdler mGcIdler = new GcIdler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.359 -0400", hash_original_field = "DE4BFAC052533664C59E9AD019F17B6A", hash_generated_field = "42912703516C643929BE4407C1512E06")

    boolean mGcIdlerScheduled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.359 -0400", hash_original_field = "3FAF8118696AC73FC8F1B67D3D02AF4A", hash_generated_field = "5193B2043B5018140A114729BFBC1AB5")

    Bundle mCoreSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.359 -0400", hash_original_field = "993B4BC77167CA135C4203377145C3CD", hash_generated_field = "218DF766A932DC18C65DC16EEE9A759F")

    private Configuration mMainThreadConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.359 -0400", hash_original_field = "C0A0D42CB8ABD8C7501B75A124D2EBED", hash_generated_field = "4A61C1EAE378A13AF88688B33DC5A9C1")

    private int mThumbnailWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.360 -0400", hash_original_field = "911A70F142E0968B61A5EFA355B11DDC", hash_generated_field = "B5D585F47D7019D989CAAE6F1896D3A6")

    private int mThumbnailHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.360 -0400", hash_original_field = "141C098303475F179108F5D3107FEAD3", hash_generated_field = "86CFFC9A0E84C08A1C5D2192C683E8D7")

    private Bitmap mAvailThumbnailBitmap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.360 -0400", hash_original_field = "9896186CB5EE9EEFA16B028C2F3D5A9A", hash_generated_field = "1246BE5370B0FC65915F756626A5C46E")

    private Canvas mThumbnailCanvas = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.360 -0400", hash_original_method = "C5DB87E83A0D8D66EF8ECA86A91864C7", hash_generated_method = "DE4A90A4BD0EECDAD4C2F33FDAD8D9FA")
      ActivityThread() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.361 -0400", hash_original_method = "FA5B9DB827774258D426805F82794E0D", hash_generated_method = "EBE4AC8FA18D0885A3E86BAFC9F27611")
    private void dumpGraphicsInfo(FileDescriptor fd) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.364 -0400", hash_original_method = "E45CB384263D7EF5FBA0A98360B08B32", hash_generated_method = "C666B4EC102414F3CF67025943D9D2DE")
     DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo ci, boolean forceUpdate) {
        addTaint(forceUpdate);
        addTaint(ci.getTaint());
        DisplayMetrics dm = mDisplayMetrics.get(ci);
    if(dm != null && !forceUpdate)        
        {
DisplayMetrics var9B1FDF2E4EE0CDF920164A162BBFC859_417481953 =             dm;
            var9B1FDF2E4EE0CDF920164A162BBFC859_417481953.addTaint(taint);
            return var9B1FDF2E4EE0CDF920164A162BBFC859_417481953;
        } //End block
    if(dm == null)        
        {
            dm = new DisplayMetrics();
            mDisplayMetrics.put(ci, dm);
        } //End block
        Display d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        d.getMetrics(dm);
DisplayMetrics var9B1FDF2E4EE0CDF920164A162BBFC859_390496783 =         dm;
        var9B1FDF2E4EE0CDF920164A162BBFC859_390496783.addTaint(taint);
        return var9B1FDF2E4EE0CDF920164A162BBFC859_390496783;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.366 -0400", hash_original_method = "DD63F0FD46EA5914D44A0437CF6968C9", hash_generated_method = "EFB3F553C5D9E9E9CD26417362EA0013")
     Configuration applyConfigCompatMainThread(Configuration config, CompatibilityInfo compat) {
        addTaint(compat.getTaint());
        addTaint(config.getTaint());
    if(config == null)        
        {
Configuration var540C13E9E156B687226421B24F2DF178_1601965425 =             null;
            var540C13E9E156B687226421B24F2DF178_1601965425.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1601965425;
        } //End block
    if(compat != null && !compat.supportsScreen())        
        {
            mMainThreadConfig.setTo(config);
            config = mMainThreadConfig;
            compat.applyToConfiguration(config);
        } //End block
Configuration var81567CF7749AF2EA37063F56A4D104CE_755967456 =         config;
        var81567CF7749AF2EA37063F56A4D104CE_755967456.addTaint(taint);
        return var81567CF7749AF2EA37063F56A4D104CE_755967456;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.367 -0400", hash_original_method = "371F1E66BBE63CA5CE35B0BEAA492ADA", hash_generated_method = "DB755B7DC9D762D8654C3DF989C5648A")
     Resources getTopLevelResources(String resDir, CompatibilityInfo compInfo) {
        addTaint(compInfo.getTaint());
        addTaint(resDir.getTaint());
        ResourcesKey key = new ResourcesKey(resDir, compInfo.applicationScale);
        Resources r;
        synchronized
(mPackages)        {
    if(false)            
            {
            } //End block
            WeakReference<Resources> wr = mActiveResources.get(key);
            r = wr != null ? wr.get() : null;
    if(r != null && r.getAssets().isUpToDate())            
            {
    if(false)                
                {
                } //End block
Resources var4C1F3C86A0E56B6E375080F5F710547E_1678669341 =                 r;
                var4C1F3C86A0E56B6E375080F5F710547E_1678669341.addTaint(taint);
                return var4C1F3C86A0E56B6E375080F5F710547E_1678669341;
            } //End block
        } //End block
        AssetManager assets = new AssetManager();
    if(assets.addAssetPath(resDir) == 0)        
        {
Resources var540C13E9E156B687226421B24F2DF178_1601346160 =             null;
            var540C13E9E156B687226421B24F2DF178_1601346160.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1601346160;
        } //End block
        DisplayMetrics metrics = getDisplayMetricsLocked(null, false);
        r = new Resources(assets, metrics, getConfiguration(), compInfo);
    if(false)        
        {
        } //End block
        synchronized
(mPackages)        {
            WeakReference<Resources> wr = mActiveResources.get(key);
            Resources existing = wr != null ? wr.get() : null;
    if(existing != null && existing.getAssets().isUpToDate())            
            {
                r.getAssets().close();
Resources varA595529F9548FF5AC46AEEA816BCBC88_342505579 =                 existing;
                varA595529F9548FF5AC46AEEA816BCBC88_342505579.addTaint(taint);
                return varA595529F9548FF5AC46AEEA816BCBC88_342505579;
            } //End block
            mActiveResources.put(key, new WeakReference<Resources>(r));
Resources var4C1F3C86A0E56B6E375080F5F710547E_1874596925 =             r;
            var4C1F3C86A0E56B6E375080F5F710547E_1874596925.addTaint(taint);
            return var4C1F3C86A0E56B6E375080F5F710547E_1874596925;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.368 -0400", hash_original_method = "9D648CED90369A8409E4C88D7CE96759", hash_generated_method = "F571D01869B66EF8716A9B9FC6D23284")
     Resources getTopLevelResources(String resDir, LoadedApk pkgInfo) {
        addTaint(pkgInfo.getTaint());
        addTaint(resDir.getTaint());
Resources varDBD804D6BEF51876FC7FE3C1437E5875_537026554 =         getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
        varDBD804D6BEF51876FC7FE3C1437E5875_537026554.addTaint(taint);
        return varDBD804D6BEF51876FC7FE3C1437E5875_537026554;
        // ---------- Original Method ----------
        //return getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.369 -0400", hash_original_method = "F7A72EDCDC7800374FD6BBEAFCDB636B", hash_generated_method = "780247253F7915725C1E34B9E02A87B6")
    final Handler getHandler() {
Handler var42FA84C88A5BC46E84179AB18958974D_1633398346 =         mH;
        var42FA84C88A5BC46E84179AB18958974D_1633398346.addTaint(taint);
        return var42FA84C88A5BC46E84179AB18958974D_1633398346;
        // ---------- Original Method ----------
        //return mH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.371 -0400", hash_original_method = "FD6B2C09494E94CB4CF03F9000F967F2", hash_generated_method = "3B5DB42FF9C1E2F0B79CADF8B877A761")
    public final LoadedApk getPackageInfo(String packageName, CompatibilityInfo compatInfo,
            int flags) {
        addTaint(flags);
        addTaint(compatInfo.getTaint());
        addTaint(packageName.getTaint());
        synchronized
(mPackages)        {
            WeakReference<LoadedApk> ref;
    if((flags&Context.CONTEXT_INCLUDE_CODE) != 0)            
            {
                ref = mPackages.get(packageName);
            } //End block
            else
            {
                ref = mResourcePackages.get(packageName);
            } //End block
            LoadedApk packageInfo = ref != null ? ref.get() : null;
    if(packageInfo != null && (packageInfo.mResources == null
                    || packageInfo.mResources.getAssets().isUpToDate()))            
            {
    if(packageInfo.isSecurityViolation()
                        && (flags&Context.CONTEXT_IGNORE_SECURITY) == 0)                
                {
                    SecurityException varDDA3BDE7DBA5D1BE9E4F3307D8B8B668_1057052781 = new SecurityException(
                            "Requesting code from " + packageName
                            + " to be run in process "
                            + mBoundApplication.processName
                            + "/" + mBoundApplication.appInfo.uid);
                    varDDA3BDE7DBA5D1BE9E4F3307D8B8B668_1057052781.addTaint(taint);
                    throw varDDA3BDE7DBA5D1BE9E4F3307D8B8B668_1057052781;
                } //End block
LoadedApk var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_806621483 =                 packageInfo;
                var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_806621483.addTaint(taint);
                return var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_806621483;
            } //End block
        } //End block
        ApplicationInfo ai = null;
        try 
        {
            ai = getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_SHARED_LIBRARY_FILES);
        } //End block
        catch (RemoteException e)
        {
        } //End block
    if(ai != null)        
        {
LoadedApk var64805F1660EAECB12F5405EB9CB9DD68_459526610 =             getPackageInfo(ai, compatInfo, flags);
            var64805F1660EAECB12F5405EB9CB9DD68_459526610.addTaint(taint);
            return var64805F1660EAECB12F5405EB9CB9DD68_459526610;
        } //End block
LoadedApk var540C13E9E156B687226421B24F2DF178_1966224910 =         null;
        var540C13E9E156B687226421B24F2DF178_1966224910.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1966224910;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.373 -0400", hash_original_method = "45FB4CD004B111E95D4C640E8F52184B", hash_generated_method = "824845FAD7ABB53F0BDBF62253A698C0")
    public final LoadedApk getPackageInfo(ApplicationInfo ai, CompatibilityInfo compatInfo,
            int flags) {
        addTaint(flags);
        addTaint(compatInfo.getTaint());
        addTaint(ai.getTaint());
        boolean includeCode = (flags&Context.CONTEXT_INCLUDE_CODE) != 0;
        boolean securityViolation = includeCode && ai.uid != 0
                && ai.uid != Process.SYSTEM_UID && (mBoundApplication != null
                        ? ai.uid != mBoundApplication.appInfo.uid : true);
    if((flags&(Context.CONTEXT_INCLUDE_CODE
                |Context.CONTEXT_IGNORE_SECURITY))
                == Context.CONTEXT_INCLUDE_CODE)        
        {
    if(securityViolation)            
            {
                String msg = "Requesting code from " + ai.packageName
                        + " (with uid " + ai.uid + ")";
    if(mBoundApplication != null)                
                {
                    msg = msg + " to be run in process "
                        + mBoundApplication.processName + " (with uid "
                        + mBoundApplication.appInfo.uid + ")";
                } //End block
                SecurityException varC5EE93F1F5A2A36B7796B378C69384FB_1917694149 = new SecurityException(msg);
                varC5EE93F1F5A2A36B7796B378C69384FB_1917694149.addTaint(taint);
                throw varC5EE93F1F5A2A36B7796B378C69384FB_1917694149;
            } //End block
        } //End block
LoadedApk varE83CD1A449A2728799815F538CFCEC53_722253345 =         getPackageInfo(ai, compatInfo, null, securityViolation, includeCode);
        varE83CD1A449A2728799815F538CFCEC53_722253345.addTaint(taint);
        return varE83CD1A449A2728799815F538CFCEC53_722253345;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.375 -0400", hash_original_method = "60B71579104EFF006D8A717508119428", hash_generated_method = "66C37B9CC8B16B00A7B004320B28899B")
    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo ai,
            CompatibilityInfo compatInfo) {
        addTaint(compatInfo.getTaint());
        addTaint(ai.getTaint());
LoadedApk var5BD2B346034679A520A729C91937F0E4_1040117122 =         getPackageInfo(ai, compatInfo, null, false, true);
        var5BD2B346034679A520A729C91937F0E4_1040117122.addTaint(taint);
        return var5BD2B346034679A520A729C91937F0E4_1040117122;
        // ---------- Original Method ----------
        //return getPackageInfo(ai, compatInfo, null, false, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.376 -0400", hash_original_method = "5838753A6BAADDD41C531129622D5299", hash_generated_method = "780ED461B74E5D57B74CC60D56B468C8")
    public final LoadedApk peekPackageInfo(String packageName, boolean includeCode) {
        addTaint(includeCode);
        addTaint(packageName.getTaint());
        synchronized
(mPackages)        {
            WeakReference<LoadedApk> ref;
    if(includeCode)            
            {
                ref = mPackages.get(packageName);
            } //End block
            else
            {
                ref = mResourcePackages.get(packageName);
            } //End block
LoadedApk var1D70A0B4812190D10459BDBA540121C1_415635555 =             ref != null ? ref.get() : null;
            var1D70A0B4812190D10459BDBA540121C1_415635555.addTaint(taint);
            return var1D70A0B4812190D10459BDBA540121C1_415635555;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.388 -0400", hash_original_method = "F2A25E301DE436DC300B56B48A365596", hash_generated_method = "D8DB258E17FE1F8087AB8E5809CAEB60")
    private LoadedApk getPackageInfo(ApplicationInfo aInfo, CompatibilityInfo compatInfo,
            ClassLoader baseLoader, boolean securityViolation, boolean includeCode) {
        addTaint(includeCode);
        addTaint(securityViolation);
        addTaint(baseLoader.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(aInfo.getTaint());
        synchronized
(mPackages)        {
            WeakReference<LoadedApk> ref;
    if(includeCode)            
            {
                ref = mPackages.get(aInfo.packageName);
            } //End block
            else
            {
                ref = mResourcePackages.get(aInfo.packageName);
            } //End block
            LoadedApk packageInfo = ref != null ? ref.get() : null;
    if(packageInfo == null || (packageInfo.mResources != null
                    && !packageInfo.mResources.getAssets().isUpToDate()))            
            {
    if(localLOGV){ }                packageInfo =
                    new LoadedApk(this, aInfo, compatInfo, this, baseLoader,
                            securityViolation, includeCode &&
                            (aInfo.flags&ApplicationInfo.FLAG_HAS_CODE) != 0);
    if(includeCode)                
                {
                    mPackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                } //End block
                else
                {
                    mResourcePackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                } //End block
            } //End block
LoadedApk var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_1596854923 =             packageInfo;
            var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_1596854923.addTaint(taint);
            return var09E9A17EAAF0BD6075FEFBEEEE6DAEFD_1596854923;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.389 -0400", hash_original_method = "F0BED1934E92681B3C0E496CA2259BFD", hash_generated_method = "484E1F1ACFDBEC8E1B03756B62419C53")
    public ApplicationThread getApplicationThread() {
ApplicationThread var05FB2E1B0D97BA0C25A0DFA7E1564820_1924290453 =         mAppThread;
        var05FB2E1B0D97BA0C25A0DFA7E1564820_1924290453.addTaint(taint);
        return var05FB2E1B0D97BA0C25A0DFA7E1564820_1924290453;
        // ---------- Original Method ----------
        //return mAppThread;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.390 -0400", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "7E9C2B6803FCA7CE1431DB38465E8B81")
    public Instrumentation getInstrumentation() {
Instrumentation var0FB7EFFFC0B8CD54E817BBC71710DE88_331454223 =         mInstrumentation;
        var0FB7EFFFC0B8CD54E817BBC71710DE88_331454223.addTaint(taint);
        return var0FB7EFFFC0B8CD54E817BBC71710DE88_331454223;
        // ---------- Original Method ----------
        //return mInstrumentation;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.391 -0400", hash_original_method = "9032A5E826B7A6BB9A1848729A4BF06F", hash_generated_method = "04B2A98CB12C83B5679BE763DCC77FB6")
    public Configuration getConfiguration() {
Configuration var25C788DF28CF295164A33A25CD6E466B_1481915956 =         mResConfiguration;
        var25C788DF28CF295164A33A25CD6E466B_1481915956.addTaint(taint);
        return var25C788DF28CF295164A33A25CD6E466B_1481915956;
        // ---------- Original Method ----------
        //return mResConfiguration;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.391 -0400", hash_original_method = "BB8D8D9198132B7570723812CBBB4B98", hash_generated_method = "EF7C2AFA1119034E3D7B202AF94CD963")
    public boolean isProfiling() {
        boolean var66C5AECD240B7D31E9E5A4916FB77E5C_1435669309 = (mProfiler != null && mProfiler.profileFile != null
                && mProfiler.profileFd == null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_794621680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_794621680;
        // ---------- Original Method ----------
        //return mProfiler != null && mProfiler.profileFile != null
                //&& mProfiler.profileFd == null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.392 -0400", hash_original_method = "DE9E88BCF6C439479F5E5429ED790EB6", hash_generated_method = "10CBD4F5669541C69A2A4E41B2931B44")
    public String getProfileFilePath() {
String var6F57B88EC75C2F0A7C0F4AAE1EC76DA3_463579252 =         mProfiler.profileFile;
        var6F57B88EC75C2F0A7C0F4AAE1EC76DA3_463579252.addTaint(taint);
        return var6F57B88EC75C2F0A7C0F4AAE1EC76DA3_463579252;
        // ---------- Original Method ----------
        //return mProfiler.profileFile;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.393 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "25B52A65BC774FD2B67A31BDAF8C5E75")
    public Looper getLooper() {
Looper var0D78717954912E9F181D5C0583378DCC_2089484074 =         mLooper;
        var0D78717954912E9F181D5C0583378DCC_2089484074.addTaint(taint);
        return var0D78717954912E9F181D5C0583378DCC_2089484074;
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.393 -0400", hash_original_method = "BED0801CDE1100B1F268B3031343DFA4", hash_generated_method = "7BAD9240969A11CA3BE3E449642C515A")
    public Application getApplication() {
Application var3B7981332C2D9E00AFA9BC4902A48C86_390943981 =         mInitialApplication;
        var3B7981332C2D9E00AFA9BC4902A48C86_390943981.addTaint(taint);
        return var3B7981332C2D9E00AFA9BC4902A48C86_390943981;
        // ---------- Original Method ----------
        //return mInitialApplication;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.394 -0400", hash_original_method = "5878D065A1BC5C9B3897192B88F09BB5", hash_generated_method = "D042C4654E972E74B275CE8000A89DE1")
    public String getProcessName() {
String var35FFE105AEC7D49B01357465EE337563_2087847865 =         mBoundApplication.processName;
        var35FFE105AEC7D49B01357465EE337563_2087847865.addTaint(taint);
        return var35FFE105AEC7D49B01357465EE337563_2087847865;
        // ---------- Original Method ----------
        //return mBoundApplication.processName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.397 -0400", hash_original_method = "67B7F6B98B8791421AA33911A41FCF20", hash_generated_method = "CDFFBD90E4CB2E61F136689A4036EA2D")
    public ContextImpl getSystemContext() {
        synchronized
(this)        {
    if(mSystemContext == null)            
            {
                ContextImpl context = ContextImpl.createSystemContext(this);
                LoadedApk info = new LoadedApk(this, "android", context, null,
                        CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO);
                context.init(info, null, this);
                context.getResources().updateConfiguration(
                        getConfiguration(), getDisplayMetricsLocked(
                                CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
                mSystemContext = context;
            } //End block
        } //End block
ContextImpl var8C7F00BBFA5D714A8F742FB231BABCE9_400094276 =         mSystemContext;
        var8C7F00BBFA5D714A8F742FB231BABCE9_400094276.addTaint(taint);
        return var8C7F00BBFA5D714A8F742FB231BABCE9_400094276;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.399 -0400", hash_original_method = "AC12C154682E9BD06E6B4A91255348E3", hash_generated_method = "261D1582AFB3931524755E9B42B9AFF2")
    public void installSystemApplicationInfo(ApplicationInfo info) {
        addTaint(info.getTaint());
        synchronized
(this)        {
            ContextImpl context = getSystemContext();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.400 -0400", hash_original_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15", hash_generated_method = "43FCCD1C79278E93E08DC79B42917B11")
     void ensureJitEnabled() {
    if(!mJitEnabled)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.401 -0400", hash_original_method = "9194C167DA959B824F2056B7870F9862", hash_generated_method = "AA964439A5C7497A72651BA236CC2168")
     void scheduleGcIdler() {
    if(!mGcIdlerScheduled)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.403 -0400", hash_original_method = "418A9C1DFD1D7F21CC468D764B344F26", hash_generated_method = "BA3652EF164DC887AC81A79D338852CE")
     void unscheduleGcIdler() {
    if(mGcIdlerScheduled)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.405 -0400", hash_original_method = "7E176906E0A5888F6535695D6EB5B115", hash_generated_method = "5222592CBBECADD26297565A22B4F3AF")
     void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        final long now = SystemClock.uptimeMillis();
    if((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now)        
        {
            BinderInternal.forceGc("bg");
        } //End block
        // ---------- Original Method ----------
        //mGcIdlerScheduled = false;
        //final long now = SystemClock.uptimeMillis();
        //if ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now) {
            //BinderInternal.forceGc("bg");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.406 -0400", hash_original_method = "BC7C90866968540D7B885FF1F76E8E09", hash_generated_method = "A8092423CCE6E503DCA567707DD4691F")
    public void registerOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(listener.getTaint());
        addTaint(activity.getTaint());
        synchronized
(mOnPauseListeners)        {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
    if(list == null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.406 -0400", hash_original_method = "A666FB211AE0A9537AAE3A42A197A4A4", hash_generated_method = "AF5EB19ABF9AC64C25E1300C16FBA6AA")
    public void unregisterOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        addTaint(listener.getTaint());
        addTaint(activity.getTaint());
        synchronized
(mOnPauseListeners)        {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
    if(list != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.407 -0400", hash_original_method = "FA6ACBD6D6B2F04759E1E44999782C17", hash_generated_method = "01484492CE509E0882B0E86EC4AFD2F7")
    public final ActivityInfo resolveActivityInfo(Intent intent) {
        addTaint(intent.getTaint());
        ActivityInfo aInfo = intent.resolveActivityInfo(
                mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
    if(aInfo == null)        
        {
            Instrumentation.checkStartActivityResult(
                    IActivityManager.START_CLASS_NOT_FOUND, intent);
        } //End block
ActivityInfo var25154327F32EA688CDFCE3B1E63BC564_1327679383 =         aInfo;
        var25154327F32EA688CDFCE3B1E63BC564_1327679383.addTaint(taint);
        return var25154327F32EA688CDFCE3B1E63BC564_1327679383;
        // ---------- Original Method ----------
        //ActivityInfo aInfo = intent.resolveActivityInfo(
                //mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        //if (aInfo == null) {
            //Instrumentation.checkStartActivityResult(
                    //IActivityManager.START_CLASS_NOT_FOUND, intent);
        //}
        //return aInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.411 -0400", hash_original_method = "52193E396925A8581791167FBC0A1FC9", hash_generated_method = "C9C016A1BE4D8A770798773CF8CB3A77")
    public final Activity startActivityNow(Activity parent, String id,
        Intent intent, ActivityInfo activityInfo, IBinder token, Bundle state,
        Activity.NonConfigurationInstances lastNonConfigurationInstances) {
        addTaint(lastNonConfigurationInstances.getTaint());
        addTaint(state.getTaint());
        addTaint(token.getTaint());
        addTaint(activityInfo.getTaint());
        addTaint(intent.getTaint());
        addTaint(id.getTaint());
        addTaint(parent.getTaint());
        ActivityClientRecord r = new ActivityClientRecord();
        r.token = token;
        r.ident = 0;
        r.intent = intent;
        r.state = state;
        r.parent = parent;
        r.embeddedID = id;
        r.activityInfo = activityInfo;
        r.lastNonConfigurationInstances = lastNonConfigurationInstances;
    if(localLOGV)        
        {
            ComponentName compname = intent.getComponent();
            String name;
    if(compname != null)            
            {
                name = compname.toShortString();
            } //End block
            else
            {
                name = "(Intent " + intent + ").getComponent() returned null";
            } //End block
        } //End block
Activity var21BE0162D2552721B0E714C1F8CBE8EA_157697086 =         performLaunchActivity(r, null);
        var21BE0162D2552721B0E714C1F8CBE8EA_157697086.addTaint(taint);
        return var21BE0162D2552721B0E714C1F8CBE8EA_157697086;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.412 -0400", hash_original_method = "E4DB0C38EE0152F49C4586AFA6AD83D1", hash_generated_method = "0C8376909D7F86F865F5B54A51A2B409")
    public final Activity getActivity(IBinder token) {
        addTaint(token.getTaint());
Activity var2C38D07B6015CB84F54BA801C96989DD_1680554610 =         mActivities.get(token).activity;
        var2C38D07B6015CB84F54BA801C96989DD_1680554610.addTaint(taint);
        return var2C38D07B6015CB84F54BA801C96989DD_1680554610;
        // ---------- Original Method ----------
        //return mActivities.get(token).activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.413 -0400", hash_original_method = "46F0209236B49884D3899FCB9A0A8CD2", hash_generated_method = "A0A9898BEF94F721CA4A6499A59F5BBE")
    public final void sendActivityResult(
            IBinder token, String id, int requestCode,
            int resultCode, Intent data) {
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        addTaint(id.getTaint());
        addTaint(token.getTaint());
    if(DEBUG_RESULTS){ }        ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        list.add(new ResultInfo(id, requestCode, resultCode, data));
        mAppThread.scheduleSendResult(token, list);
        // ---------- Original Method ----------
        //if (DEBUG_RESULTS) Slog.v(TAG, "sendActivityResult: id=" + id
                //+ " req=" + requestCode + " res=" + resultCode + " data=" + data);
        //ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        //list.add(new ResultInfo(id, requestCode, resultCode, data));
        //mAppThread.scheduleSendResult(token, list);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.413 -0400", hash_original_method = "04C4A68B1E80544C50165B2C1F09966C", hash_generated_method = "4517D57266CA0DC462A091B4C822D4E5")
    private void queueOrSendMessage(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        queueOrSendMessage(what, obj, 0, 0);
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.414 -0400", hash_original_method = "3163B4D830BC02309EB9FA4093F38166", hash_generated_method = "CEDA3CE8FBC5F3DC108D1A191F6F1A61")
    private void queueOrSendMessage(int what, Object obj, int arg1) {
        addTaint(arg1);
        addTaint(obj.getTaint());
        addTaint(what);
        queueOrSendMessage(what, obj, arg1, 0);
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.415 -0400", hash_original_method = "BA532BAA145C03E1DD34B30EBC725387", hash_generated_method = "98D0FCDA96A422BCFEBBCED6F532823D")
    private void queueOrSendMessage(int what, Object obj, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(obj.getTaint());
        addTaint(what);
        synchronized
(this)        {
    if(DEBUG_MESSAGES){ }            Message msg = Message.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.417 -0400", hash_original_method = "15BD644AA17343360FD7D474ECDA0BC6", hash_generated_method = "DE78094F51D9125A05099FE9EC14C883")
    final void scheduleContextCleanup(ContextImpl context, String who,
            String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        addTaint(context.getTaint());
        ContextCleanupInfo cci = new ContextCleanupInfo();
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.425 -0400", hash_original_method = "C9C4D84CF5E4E5BEF4E002420AA42B4A", hash_generated_method = "0813D4BD6ADE3506DE352CCB7F2CAE02")
    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        addTaint(customIntent.getTaint());
        addTaint(r.getTaint());
        ActivityInfo aInfo = r.activityInfo;
    if(r.packageInfo == null)        
        {
            r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
                    Context.CONTEXT_INCLUDE_CODE);
        } //End block
        ComponentName component = r.intent.getComponent();
    if(component == null)        
        {
            component = r.intent.resolveActivity(
                mInitialApplication.getPackageManager());
            r.intent.setComponent(component);
        } //End block
    if(r.activityInfo.targetActivity != null)        
        {
            component = new ComponentName(r.activityInfo.packageName,
                    r.activityInfo.targetActivity);
        } //End block
        Activity activity = null;
        try 
        {
            java.lang.ClassLoader cl = r.packageInfo.getClassLoader();
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);
            StrictMode.incrementExpectedActivityCount(activity.getClass());
            r.intent.setExtrasClassLoader(cl);
    if(r.state != null)            
            {
                r.state.setClassLoader(cl);
            } //End block
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(activity, e))            
            {
                RuntimeException var7191F90A11B87251ABDE43BFABA52EEF_638821615 = new RuntimeException(
                    "Unable to instantiate activity " + component
                    + ": " + e.toString(), e);
                var7191F90A11B87251ABDE43BFABA52EEF_638821615.addTaint(taint);
                throw var7191F90A11B87251ABDE43BFABA52EEF_638821615;
            } //End block
        } //End block
        try 
        {
            Application app = r.packageInfo.makeApplication(false, mInstrumentation);
    if(localLOGV){ }    if(localLOGV){ }    if(activity != null)            
            {
                ContextImpl appContext = new ContextImpl();
                appContext.init(r.packageInfo, r.token, this);
                appContext.setOuterContext(activity);
                CharSequence title = r.activityInfo.loadLabel(appContext.getPackageManager());
                Configuration config = new Configuration(mCompatConfiguration);
    if(DEBUG_CONFIGURATION){ }                activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config);
    if(customIntent != null)                
                {
                    activity.mIntent = customIntent;
                } //End block
                r.lastNonConfigurationInstances = null;
                activity.mStartedActivity = false;
                int theme = r.activityInfo.getThemeResource();
    if(theme != 0)                
                {
                    activity.setTheme(theme);
                } //End block
                activity.mCalled = false;
                mInstrumentation.callActivityOnCreate(activity, r.state);
    if(!activity.mCalled)                
                {
                    SuperNotCalledException varB1538AA6F71115070CF1848CC5B5388C_815458684 = new SuperNotCalledException(
                        "Activity " + r.intent.getComponent().toShortString() +
                        " did not call through to super.onCreate()");
                    varB1538AA6F71115070CF1848CC5B5388C_815458684.addTaint(taint);
                    throw varB1538AA6F71115070CF1848CC5B5388C_815458684;
                } //End block
                r.activity = activity;
                r.stopped = true;
    if(!r.activity.mFinished)                
                {
                    activity.performStart();
                    r.stopped = false;
                } //End block
    if(!r.activity.mFinished)                
                {
    if(r.state != null)                    
                    {
                        mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state);
                    } //End block
                } //End block
    if(!r.activity.mFinished)                
                {
                    activity.mCalled = false;
                    mInstrumentation.callActivityOnPostCreate(activity, r.state);
    if(!activity.mCalled)                    
                    {
                        SuperNotCalledException var8652BC87B0FDCFACADB441E48C8357E2_1054821272 = new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPostCreate()");
                        var8652BC87B0FDCFACADB441E48C8357E2_1054821272.addTaint(taint);
                        throw var8652BC87B0FDCFACADB441E48C8357E2_1054821272;
                    } //End block
                } //End block
            } //End block
            r.paused = true;
            mActivities.put(r.token, r);
        } //End block
        catch (SuperNotCalledException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(activity, e))            
            {
                RuntimeException var51E2730B66E8680677386C38F48E197A_1667022355 = new RuntimeException(
                    "Unable to start activity " + component
                    + ": " + e.toString(), e);
                var51E2730B66E8680677386C38F48E197A_1667022355.addTaint(taint);
                throw var51E2730B66E8680677386C38F48E197A_1667022355;
            } //End block
        } //End block
Activity var8CEBAC25E19008E785695F06EF11C2CD_1948230015 =         activity;
        var8CEBAC25E19008E785695F06EF11C2CD_1948230015.addTaint(taint);
        return var8CEBAC25E19008E785695F06EF11C2CD_1948230015;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.428 -0400", hash_original_method = "483F7FDC9359FE0D21A4FBFB307EF0CA", hash_generated_method = "92B834EB8F52DEAE66341B86D40BEFD2")
    private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        addTaint(customIntent.getTaint());
        unscheduleGcIdler();
    if(r.profileFd != null)        
        {
            mProfiler.setProfiler(r.profileFile, r.profileFd);
            mProfiler.startProfiling();
            mProfiler.autoStopProfiler = r.autoStopProfiler;
        } //End block
        handleConfigurationChanged(null, null);
    if(localLOGV){ }        Activity a = performLaunchActivity(r, customIntent);
    if(a != null)        
        {
            r.createdConfig = new Configuration(mConfiguration);
            Bundle oldState = r.state;
            handleResumeActivity(r.token, false, r.isForward);
    if(!r.activity.mFinished && r.startsNotResumed)            
            {
                try 
                {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    r.state = oldState;
    if(!r.activity.mCalled)                    
                    {
                        SuperNotCalledException var47B6BE7C11FC09EAC2B61A203C9ED5C3_2136154360 = new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPause()");
                        var47B6BE7C11FC09EAC2B61A203C9ED5C3_2136154360.addTaint(taint);
                        throw var47B6BE7C11FC09EAC2B61A203C9ED5C3_2136154360;
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var01C0879CF941A9B86515CD1539C2F3E4_1856384845 = new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        var01C0879CF941A9B86515CD1539C2F3E4_1856384845.addTaint(taint);
                        throw var01C0879CF941A9B86515CD1539C2F3E4_1856384845;
                    } //End block
                } //End block
                r.paused = true;
            } //End block
        } //End block
        else
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(r.token, Activity.RESULT_CANCELED, null);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.431 -0400", hash_original_method = "089DA2DACAED1790C29E22F2D6A7A046", hash_generated_method = "D1C8AE40663647080E67BF4C00EA7EAA")
    private void deliverNewIntents(ActivityClientRecord r,
            List<Intent> intents) {
        addTaint(intents.getTaint());
        addTaint(r.getTaint());
        final int N = intents.size();
for(int i=0;i<N;i++)
        {
            Intent intent = intents.get(i);
            intent.setExtrasClassLoader(r.activity.getClassLoader());
            r.activity.mFragments.noteStateNotSaved();
            mInstrumentation.callActivityOnNewIntent(r.activity, intent);
        } //End block
        // ---------- Original Method ----------
        //final int N = intents.size();
        //for (int i=0; i<N; i++) {
            //Intent intent = intents.get(i);
            //intent.setExtrasClassLoader(r.activity.getClassLoader());
            //r.activity.mFragments.noteStateNotSaved();
            //mInstrumentation.callActivityOnNewIntent(r.activity, intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.432 -0400", hash_original_method = "62C39F1A7060D00626ABC1EA40393902", hash_generated_method = "DE99AF817412DA7FC3AC7894E409045D")
    public final void performNewIntents(IBinder token,
            List<Intent> intents) {
        addTaint(intents.getTaint());
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r != null)        
        {
            final boolean resumed = !r.paused;
    if(resumed)            
            {
                r.activity.mTemporaryPause = true;
                mInstrumentation.callActivityOnPause(r.activity);
            } //End block
            deliverNewIntents(r, intents);
    if(resumed)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.433 -0400", hash_original_method = "3340D70EC7FD056C28E3BD0AF1C7CC94", hash_generated_method = "22E9E00A21957DC530FF180BBFF790DD")
    private void handleNewIntent(NewIntentData data) {
        addTaint(data.getTaint());
        performNewIntents(data.token, data.intents);
        // ---------- Original Method ----------
        //performNewIntents(data.token, data.intents);
    }

    
        @DSModeled(DSC.SPEC)
    public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.435 -0400", hash_original_method = "3D8204A3B4D4C5B7C8FEA568D86F5418", hash_generated_method = "0DA3421E4C73EDD602E954E133CBD221")
    private void handleReceiver(ReceiverData data) {
        addTaint(data.getTaint());
        unscheduleGcIdler();
        String component = data.intent.getComponent().getClassName();
        LoadedApk packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        IActivityManager mgr = ActivityManagerNative.getDefault();
        BroadcastReceiver receiver;
        try 
        {
            java.lang.ClassLoader cl = packageInfo.getClassLoader();
            data.intent.setExtrasClassLoader(cl);
            data.setExtrasClassLoader(cl);
            receiver = (BroadcastReceiver)cl.loadClass(component).newInstance();
        } //End block
        catch (Exception e)
        {
    if(DEBUG_BROADCAST){ }            data.sendFinished(mgr);
            RuntimeException varE8453109F201046231A7F4C49EEBC06C_1707912685 = new RuntimeException(
                "Unable to instantiate receiver " + component
                + ": " + e.toString(), e);
            varE8453109F201046231A7F4C49EEBC06C_1707912685.addTaint(taint);
            throw varE8453109F201046231A7F4C49EEBC06C_1707912685;
        } //End block
        try 
        {
            Application app = packageInfo.makeApplication(false, mInstrumentation);
    if(localLOGV){ }            ContextImpl context = (ContextImpl)app.getBaseContext();
            sCurrentBroadcastIntent.set(data.intent);
            receiver.setPendingResult(data);
            receiver.onReceive(context.getReceiverRestrictedContext(),
                    data.intent);
        } //End block
        catch (Exception e)
        {
    if(DEBUG_BROADCAST){ }            data.sendFinished(mgr);
    if(!mInstrumentation.onException(receiver, e))            
            {
                RuntimeException var998AEF3D47E42383571E918699EAE31A_1176693588 = new RuntimeException(
                    "Unable to start receiver " + component
                    + ": " + e.toString(), e);
                var998AEF3D47E42383571E918699EAE31A_1176693588.addTaint(taint);
                throw var998AEF3D47E42383571E918699EAE31A_1176693588;
            } //End block
        } //End block
        finally 
        {
            sCurrentBroadcastIntent.set(null);
        } //End block
    if(receiver.getPendingResult() != null)        
        {
            data.finish();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.441 -0400", hash_original_method = "F9FD1947DE4D383F90C08BC5B81CEB33", hash_generated_method = "8FD2445F1E2F32B4D3E98FE38376E1F3")
    private void handleCreateBackupAgent(CreateBackupAgentData data) {
        addTaint(data.getTaint());
    if(DEBUG_BACKUP){ }        unscheduleGcIdler();
        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
    if(mBackupAgents.get(packageName) != null)        
        {
            Slog.d(TAG, "BackupAgent " + "  for " + packageName
                    + " already exists");
            return;
        } //End block
        BackupAgent agent = null;
        String classname = data.appInfo.backupAgentName;
    if(classname == null && (data.backupMode == IApplicationThread.BACKUP_MODE_FULL
                || data.backupMode == IApplicationThread.BACKUP_MODE_RESTORE_FULL))        
        {
            classname = "android.app.backup.FullBackupAgent";
        } //End block
        try 
        {
            IBinder binder = null;
            try 
            {
    if(DEBUG_BACKUP){ }                java.lang.ClassLoader cl = packageInfo.getClassLoader();
                agent = (BackupAgent) cl.loadClass(classname).newInstance();
                ContextImpl context = new ContextImpl();
                context.init(packageInfo, null, this);
                context.setOuterContext(agent);
                agent.attach(context);
                agent.onCreate();
                binder = agent.onBind();
                mBackupAgents.put(packageName, agent);
            } //End block
            catch (Exception e)
            {
    if(data.backupMode != IApplicationThread.BACKUP_MODE_RESTORE
                        && data.backupMode != IApplicationThread.BACKUP_MODE_RESTORE_FULL)                
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
            } //End block
            try 
            {
                ActivityManagerNative.getDefault().backupAgentCreated(packageName, binder);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        catch (Exception e)
        {
            RuntimeException var82F3A4CC16F8A30090CB4953DDF05BAB_548131772 = new RuntimeException("Unable to create BackupAgent "
                    + classname + ": " + e.toString(), e);
            var82F3A4CC16F8A30090CB4953DDF05BAB_548131772.addTaint(taint);
            throw var82F3A4CC16F8A30090CB4953DDF05BAB_548131772;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.445 -0400", hash_original_method = "F45834CE0FCB2021DEF63803688239C3", hash_generated_method = "4F1F8719A6C009425F7BDBFFF753460C")
    private void handleDestroyBackupAgent(CreateBackupAgentData data) {
        addTaint(data.getTaint());
    if(DEBUG_BACKUP){ }        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
        BackupAgent agent = mBackupAgents.get(packageName);
    if(agent != null)        
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
        else
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.448 -0400", hash_original_method = "77CEB6B4E506F7F39264B1FEFD4EC387", hash_generated_method = "1019DD8658AC116CE4D78ADB788A18AD")
    private void handleCreateService(CreateServiceData data) {
        addTaint(data.getTaint());
        unscheduleGcIdler();
        LoadedApk packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        Service service = null;
        try 
        {
            java.lang.ClassLoader cl = packageInfo.getClassLoader();
            service = (Service) cl.loadClass(data.info.name).newInstance();
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(service, e))            
            {
                RuntimeException varBFBC4F25E526D4E1EEFF080CD72D95F4_827071030 = new RuntimeException(
                    "Unable to instantiate service " + data.info.name
                    + ": " + e.toString(), e);
                varBFBC4F25E526D4E1EEFF080CD72D95F4_827071030.addTaint(taint);
                throw varBFBC4F25E526D4E1EEFF080CD72D95F4_827071030;
            } //End block
        } //End block
        try 
        {
    if(localLOGV){ }            ContextImpl context = new ContextImpl();
            context.init(packageInfo, null, this);
            Application app = packageInfo.makeApplication(false, mInstrumentation);
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
            {
            } //End block
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(service, e))            
            {
                RuntimeException var704B6B14CA6C74B5680EFEEA29944BAB_551470992 = new RuntimeException(
                    "Unable to create service " + data.info.name
                    + ": " + e.toString(), e);
                var704B6B14CA6C74B5680EFEEA29944BAB_551470992.addTaint(taint);
                throw var704B6B14CA6C74B5680EFEEA29944BAB_551470992;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.451 -0400", hash_original_method = "881D5FBA45CBA067F129D10745838607", hash_generated_method = "D580C6EAC6A42D206F6BE1A665D37751")
    private void handleBindService(BindServiceData data) {
        addTaint(data.getTaint());
        Service s = mServices.get(data.token);
    if(s != null)        
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                try 
                {
    if(!data.rebind)                    
                    {
                        IBinder binder = s.onBind(data.intent);
                        ActivityManagerNative.getDefault().publishService(
                                data.token, data.intent, binder);
                    } //End block
                    else
                    {
                        s.onRebind(data.intent);
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } //End block
                    ensureJitEnabled();
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(s, e))                
                {
                    RuntimeException varB6B61C64CD605F1EE7D04B14BBB74B89_455594592 = new RuntimeException(
                            "Unable to bind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    varB6B61C64CD605F1EE7D04B14BBB74B89_455594592.addTaint(taint);
                    throw varB6B61C64CD605F1EE7D04B14BBB74B89_455594592;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.453 -0400", hash_original_method = "2796BE6EE721B85B28BB6DBD3B4C5C51", hash_generated_method = "1E14FD19CC2A2E36AA01BECEEE7053BC")
    private void handleUnbindService(BindServiceData data) {
        addTaint(data.getTaint());
        Service s = mServices.get(data.token);
    if(s != null)        
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                boolean doRebind = s.onUnbind(data.intent);
                try 
                {
    if(doRebind)                    
                    {
                        ActivityManagerNative.getDefault().unbindFinished(
                                data.token, data.intent, doRebind);
                    } //End block
                    else
                    {
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } //End block
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(s, e))                
                {
                    RuntimeException var2AD3E72750A672B208C0C378175BE868_280036263 = new RuntimeException(
                            "Unable to unbind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    var2AD3E72750A672B208C0C378175BE868_280036263.addTaint(taint);
                    throw var2AD3E72750A672B208C0C378175BE868_280036263;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.454 -0400", hash_original_method = "1C18D37F75673CCCBD9C372D3BFFD82C", hash_generated_method = "5E4CD6925F44A7E8E5B8EB793F9C8638")
    private void handleDumpService(DumpComponentInfo info) {
        addTaint(info.getTaint());
        Service s = mServices.get(info.token);
    if(s != null)        
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            s.dump(info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } //End block
            catch (IOException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.455 -0400", hash_original_method = "126292FF06E700D8C53E21C56EE062B7", hash_generated_method = "00BCD33583782EDECF0A67A2C6E3CC70")
    private void handleDumpActivity(DumpComponentInfo info) {
        addTaint(info.getTaint());
        ActivityClientRecord r = mActivities.get(info.token);
    if(r != null && r.activity != null)        
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            r.activity.dump(info.prefix, info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } //End block
            catch (IOException e)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.456 -0400", hash_original_method = "7729FDAE3B00ADA3C236E33577FF6666", hash_generated_method = "01983A2BC9C3A5323FD125EB7E009C77")
    private void handleServiceArgs(ServiceArgsData data) {
        addTaint(data.getTaint());
        Service s = mServices.get(data.token);
    if(s != null)        
        {
            try 
            {
    if(data.args != null)                
                {
                    data.args.setExtrasClassLoader(s.getClassLoader());
                } //End block
                int res;
    if(!data.taskRemoved)                
                {
                    res = s.onStartCommand(data.args, data.flags, data.startId);
                } //End block
                else
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
                {
                } //End block
                ensureJitEnabled();
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(s, e))                
                {
                    RuntimeException varBA55997109B086ECA1D0055762FBFE1C_263970707 = new RuntimeException(
                            "Unable to start service " + s
                            + " with " + data.args + ": " + e.toString(), e);
                    varBA55997109B086ECA1D0055762FBFE1C_263970707.addTaint(taint);
                    throw varBA55997109B086ECA1D0055762FBFE1C_263970707;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.458 -0400", hash_original_method = "E9A561F96B3BEE10BDD2A8F223813D32", hash_generated_method = "266B703F2225487BFEB11B8E255C220A")
    private void handleStopService(IBinder token) {
        addTaint(token.getTaint());
        Service s = mServices.remove(token);
    if(s != null)        
        {
            try 
            {
    if(localLOGV){ }                s.onDestroy();
                Context context = s.getBaseContext();
    if(context instanceof ContextImpl)                
                {
                    final String who = s.getClassName();
                    ((ContextImpl) context).scheduleFinalCleanup(who, "Service");
                } //End block
                QueuedWork.waitToFinish();
                try 
                {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            token, 0, 0, 0);
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(s, e))                
                {
                    RuntimeException var40C2F6368EDA67F8678A95092E27D406_699941180 = new RuntimeException(
                            "Unable to stop service " + s
                            + ": " + e.toString(), e);
                    var40C2F6368EDA67F8678A95092E27D406_699941180.addTaint(taint);
                    throw var40C2F6368EDA67F8678A95092E27D406_699941180;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.462 -0400", hash_original_method = "821CC6EDFD77BBF57472742A46BD9804", hash_generated_method = "F484EDCC6A1B987C9DB794EB2468D2A5")
    public final ActivityClientRecord performResumeActivity(IBinder token,
            boolean clearHide) {
        addTaint(clearHide);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(localLOGV){ }    if(r != null && !r.activity.mFinished)        
        {
    if(clearHide)            
            {
                r.hideForNow = false;
                r.activity.mStartedActivity = false;
            } //End block
            try 
            {
    if(r.pendingIntents != null)                
                {
                    deliverNewIntents(r, r.pendingIntents);
                    r.pendingIntents = null;
                } //End block
    if(r.pendingResults != null)                
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
    if(!mInstrumentation.onException(r.activity, e))                
                {
                    RuntimeException varBC2D846D9F3D14F6565578D06078C575_320996798 = new RuntimeException(
                        "Unable to resume activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                    varBC2D846D9F3D14F6565578D06078C575_320996798.addTaint(taint);
                    throw varBC2D846D9F3D14F6565578D06078C575_320996798;
                } //End block
            } //End block
        } //End block
ActivityClientRecord var4C1F3C86A0E56B6E375080F5F710547E_262834396 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_262834396.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_262834396;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.463 -0400", hash_original_method = "3389EE310594E6487CC378BBAF5D49AF", hash_generated_method = "6D47760C249411009F7928D23D4BCF39")
    final void cleanUpPendingRemoveWindows(ActivityClientRecord r) {
        addTaint(r.getTaint());
    if(r.mPendingRemoveWindow != null)        
        {
            r.mPendingRemoveWindowManager.removeViewImmediate(r.mPendingRemoveWindow);
            IBinder wtoken = r.mPendingRemoveWindow.getWindowToken();
    if(wtoken != null)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.467 -0400", hash_original_method = "E7E626438598608F65C9E3AAFD52E1D3", hash_generated_method = "E20D870B46647CF5BD291703E070355B")
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
        addTaint(isForward);
        addTaint(clearHide);
        addTaint(token.getTaint());
        unscheduleGcIdler();
        ActivityClientRecord r = performResumeActivity(token, clearHide);
    if(r != null)        
        {
            final Activity a = r.activity;
    if(localLOGV){ }            final int forwardBit = isForward ?
                    WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION : 0;
            boolean willBeVisible = !a.mStartedActivity;
    if(!willBeVisible)            
            {
                try 
                {
                    willBeVisible = ActivityManagerNative.getDefault().willActivityBeVisible(
                            a.getActivityToken());
                } //End block
                catch (RemoteException e)
                {
                } //End block
            } //End block
    if(r.window == null && !a.mFinished && willBeVisible)            
            {
                r.window = r.activity.getWindow();
                View decor = r.window.getDecorView();
                decor.setVisibility(View.INVISIBLE);
                ViewManager wm = a.getWindowManager();
                WindowManager.LayoutParams l = r.window.getAttributes();
                a.mDecor = decor;
                l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
                l.softInputMode |= forwardBit;
    if(a.mVisibleFromClient)                
                {
                    a.mWindowAdded = true;
                    wm.addView(decor, l);
                } //End block
            } //End block
            else
    if(!willBeVisible)            
            {
    if(localLOGV){ }                r.hideForNow = true;
            } //End block
            cleanUpPendingRemoveWindows(r);
    if(!r.activity.mFinished && willBeVisible
                    && r.activity.mDecor != null && !r.hideForNow)            
            {
    if(r.newConfig != null)                
                {
    if(DEBUG_CONFIGURATION){ }                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } //End block
    if(localLOGV){ }                WindowManager.LayoutParams l = r.window.getAttributes();
    if((l.softInputMode
                        & WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION)
                        != forwardBit)                
                {
                    l.softInputMode = (l.softInputMode
                            & (~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION))
                            | forwardBit;
    if(r.activity.mVisibleFromClient)                    
                    {
                        ViewManager wm = a.getWindowManager();
                        View decor = r.window.getDecorView();
                        wm.updateViewLayout(decor, l);
                    } //End block
                } //End block
                r.activity.mVisibleFromServer = true;
                mNumVisibleActivities++;
    if(r.activity.mVisibleFromClient)                
                {
                    r.activity.makeVisible();
                } //End block
            } //End block
    if(!r.onlyLocalRequest)            
            {
                r.nextIdle = mNewActivities;
                mNewActivities = r;
    if(localLOGV){ }                Looper.myQueue().addIdleHandler(new Idler());
            } //End block
            r.onlyLocalRequest = false;
        } //End block
        else
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(token, Activity.RESULT_CANCELED, null);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.472 -0400", hash_original_method = "DA54714D7ABECA1149DF2EBB4CB12B75", hash_generated_method = "A09B7E7F3C235038EFC5546B3B72F533")
    private Bitmap createThumbnailBitmap(ActivityClientRecord r) {
        addTaint(r.getTaint());
        Bitmap thumbnail = mAvailThumbnailBitmap;
        try 
        {
    if(thumbnail == null)            
            {
                int w = mThumbnailWidth;
                int h;
    if(w < 0)                
                {
                    Resources res = r.activity.getResources();
                    mThumbnailHeight = h =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_height);
                    mThumbnailWidth = w =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_width);
                } //End block
                else
                {
                    h = mThumbnailHeight;
                } //End block
    if((w > 0) && (h > 0))                
                {
                    thumbnail = Bitmap.createBitmap(w, h, THUMBNAIL_FORMAT);
                    thumbnail.eraseColor(0);
                } //End block
            } //End block
    if(thumbnail != null)            
            {
                Canvas cv = mThumbnailCanvas;
    if(cv == null)                
                {
                    mThumbnailCanvas = cv = new Canvas();
                } //End block
                cv.setBitmap(thumbnail);
    if(!r.activity.onCreateThumbnail(thumbnail, cv))                
                {
                    mAvailThumbnailBitmap = thumbnail;
                    thumbnail = null;
                } //End block
                cv.setBitmap(null);
            } //End block
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(r.activity, e))            
            {
                RuntimeException varBBBA085A04F1A3A995C06F3AD340A690_178354358 = new RuntimeException(
                        "Unable to create thumbnail of "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                varBBBA085A04F1A3A995C06F3AD340A690_178354358.addTaint(taint);
                throw varBBBA085A04F1A3A995C06F3AD340A690_178354358;
            } //End block
            thumbnail = null;
        } //End block
Bitmap var13D9DF3E943C4D22E7A507556F896F5F_1010766528 =         thumbnail;
        var13D9DF3E943C4D22E7A507556F896F5F_1010766528.addTaint(taint);
        return var13D9DF3E943C4D22E7A507556F896F5F_1010766528;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.474 -0400", hash_original_method = "E5BE16D2C462200A7B0F213AB5290C46", hash_generated_method = "9B5A59B2FE731E7D81BAEC065633D507")
    private void handlePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) {
        addTaint(configChanges);
        addTaint(userLeaving);
        addTaint(finished);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r != null)        
        {
    if(userLeaving)            
            {
                performUserLeavingActivity(r);
            } //End block
            r.activity.mConfigChangeFlags |= configChanges;
            performPauseActivity(token, finished, r.isPreHoneycomb());
    if(r.isPreHoneycomb())            
            {
                QueuedWork.waitToFinish();
            } //End block
            try 
            {
                ActivityManagerNative.getDefault().activityPaused(token);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.475 -0400", hash_original_method = "E51B505D442E84A2F592A34137ABD72B", hash_generated_method = "7DCF1E757EC2D22ECB8D9A33ADAAB179")
    final void performUserLeavingActivity(ActivityClientRecord r) {
        addTaint(r.getTaint());
        mInstrumentation.callActivityOnUserLeaving(r.activity);
        // ---------- Original Method ----------
        //mInstrumentation.callActivityOnUserLeaving(r.activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.475 -0400", hash_original_method = "2E97B5DEF88E402FCA1661B4F9DB23CB", hash_generated_method = "4053CC7704A36F6E5E2703FF97017ECA")
    final Bundle performPauseActivity(IBinder token, boolean finished,
            boolean saveState) {
        addTaint(saveState);
        addTaint(finished);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
Bundle varEB3914CF2475570750D9070243EB3992_787349419 =         r != null ? performPauseActivity(r, finished, saveState) : null;
        varEB3914CF2475570750D9070243EB3992_787349419.addTaint(taint);
        return varEB3914CF2475570750D9070243EB3992_787349419;
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //return r != null ? performPauseActivity(r, finished, saveState) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.478 -0400", hash_original_method = "48F314FABF09550D34AFCF3A61EA40AB", hash_generated_method = "479836114C6DA39EB7A116D66E067A0B")
    final Bundle performPauseActivity(ActivityClientRecord r, boolean finished,
            boolean saveState) {
        addTaint(saveState);
        addTaint(finished);
        addTaint(r.getTaint());
    if(r.paused)        
        {
    if(r.activity.mFinished)            
            {
Bundle var540C13E9E156B687226421B24F2DF178_1423204267 =                 null;
                var540C13E9E156B687226421B24F2DF178_1423204267.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1423204267;
            } //End block
            RuntimeException e = new RuntimeException(
                    "Performing pause of activity that is not resumed: "
                    + r.intent.getComponent().toShortString());
        } //End block
        Bundle state = null;
    if(finished)        
        {
            r.activity.mFinished = true;
        } //End block
        try 
        {
    if(!r.activity.mFinished && saveState)            
            {
                state = new Bundle();
                state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                r.state = state;
            } //End block
            r.activity.mCalled = false;
            mInstrumentation.callActivityOnPause(r.activity);
            EventLog.writeEvent(LOG_ON_PAUSE_CALLED, r.activity.getComponentName().getClassName());
    if(!r.activity.mCalled)            
            {
                SuperNotCalledException var47B6BE7C11FC09EAC2B61A203C9ED5C3_160412525 = new SuperNotCalledException(
                    "Activity " + r.intent.getComponent().toShortString() +
                    " did not call through to super.onPause()");
                var47B6BE7C11FC09EAC2B61A203C9ED5C3_160412525.addTaint(taint);
                throw var47B6BE7C11FC09EAC2B61A203C9ED5C3_160412525;
            } //End block
        } //End block
        catch (SuperNotCalledException e)
        {
            e.addTaint(taint);
            throw e;
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(r.activity, e))            
            {
                RuntimeException var01C0879CF941A9B86515CD1539C2F3E4_38126455 = new RuntimeException(
                        "Unable to pause activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                var01C0879CF941A9B86515CD1539C2F3E4_38126455.addTaint(taint);
                throw var01C0879CF941A9B86515CD1539C2F3E4_38126455;
            } //End block
        } //End block
        r.paused = true;
        ArrayList<OnActivityPausedListener> listeners;
        synchronized
(mOnPauseListeners)        {
            listeners = mOnPauseListeners.remove(r.activity);
        } //End block
        int size = (listeners != null ? listeners.size() : 0);
for(int i = 0;i < size;i++)
        {
            listeners.get(i).onPaused(r.activity);
        } //End block
Bundle var37C56C9D63C623261861C16DCFB73F6D_4183422 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_4183422.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_4183422;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.479 -0400", hash_original_method = "16A67002319514C641569BB2AD572A0E", hash_generated_method = "575FF35538DAF45BCBF3B426F7C472B6")
    final void performStopActivity(IBinder token, boolean saveState) {
        addTaint(saveState);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
        performStopActivityInner(r, null, false, saveState);
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //performStopActivityInner(r, null, false, saveState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.482 -0400", hash_original_method = "9D7845EB7E019C62C91AEEFF3F12D0E4", hash_generated_method = "EB9A66CE9F5998934B9BF11F648045DE")
    private void performStopActivityInner(ActivityClientRecord r,
            StopInfo info, boolean keepShown, boolean saveState) {
        addTaint(saveState);
        addTaint(keepShown);
        addTaint(info.getTaint());
        addTaint(r.getTaint());
    if(localLOGV){ }        Bundle state = null;
    if(r != null)        
        {
    if(!keepShown && r.stopped)            
            {
    if(r.activity.mFinished)                
                {
                    return;
                } //End block
                RuntimeException e = new RuntimeException(
                        "Performing stop of activity that is not resumed: "
                        + r.intent.getComponent().toShortString());
            } //End block
    if(info != null)            
            {
                try 
                {
                    info.thumbnail = null;
                    info.description = r.activity.onCreateDescription();
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var17361BC15C322F9B95BCF07F0102C3ED_1224898026 = new RuntimeException(
                                "Unable to save state of activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        var17361BC15C322F9B95BCF07F0102C3ED_1224898026.addTaint(taint);
                        throw var17361BC15C322F9B95BCF07F0102C3ED_1224898026;
                    } //End block
                } //End block
            } //End block
    if(!r.activity.mFinished && saveState)            
            {
    if(r.state == null)                
                {
                    state = new Bundle();
                    state.setAllowFds(false);
                    mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                    r.state = state;
                } //End block
                else
                {
                    state = r.state;
                } //End block
            } //End block
    if(!keepShown)            
            {
                try 
                {
                    r.activity.performStop();
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException varB40B9960AFA41B7CBB246D406397E100_312040128 = new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        varB40B9960AFA41B7CBB246D406397E100_312040128.addTaint(taint);
                        throw varB40B9960AFA41B7CBB246D406397E100_312040128;
                    } //End block
                } //End block
                r.stopped = true;
            } //End block
            r.paused = true;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.484 -0400", hash_original_method = "A6B6099E264273A69E686CA5F8880A0F", hash_generated_method = "EC4DEBD5FDA3750A2CE2E43D689EF8C6")
    private void updateVisibility(ActivityClientRecord r, boolean show) {
        addTaint(show);
        addTaint(r.getTaint());
        View v = r.activity.mDecor;
    if(v != null)        
        {
    if(show)            
            {
    if(!r.activity.mVisibleFromServer)                
                {
                    r.activity.mVisibleFromServer = true;
                    mNumVisibleActivities++;
    if(r.activity.mVisibleFromClient)                    
                    {
                        r.activity.makeVisible();
                    } //End block
                } //End block
    if(r.newConfig != null)                
                {
    if(DEBUG_CONFIGURATION){ }                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } //End block
            } //End block
            else
            {
    if(r.activity.mVisibleFromServer)                
                {
                    r.activity.mVisibleFromServer = false;
                    mNumVisibleActivities--;
                    v.setVisibility(View.INVISIBLE);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.488 -0400", hash_original_method = "5B5FF681D8D2131B5D84BD48CB5679C6", hash_generated_method = "94FA2B12DDC4598CC1B54C36103813A2")
    private void handleStopActivity(IBinder token, boolean show, int configChanges) {
        addTaint(configChanges);
        addTaint(show);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
        r.activity.mConfigChangeFlags |= configChanges;
        StopInfo info = new StopInfo();
        performStopActivityInner(r, info, show, true);
    if(localLOGV){ }        updateVisibility(r, show);
    if(!r.isPreHoneycomb())        
        {
            QueuedWork.waitToFinish();
        } //End block
        try 
        {
            ActivityManagerNative.getDefault().activityStopped(
                r.token, r.state, info.thumbnail, info.description);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.490 -0400", hash_original_method = "F0D1B8DFE218B8E130C145F907A20AA2", hash_generated_method = "52454BCB1F791B77D7A53E62C2E2FC85")
    final void performRestartActivity(IBinder token) {
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r.stopped)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.492 -0400", hash_original_method = "6AC1F9C414377243EFD072AEBA5D0138", hash_generated_method = "C054BBA8957DCD7190ABFAC59040BE63")
    private void handleWindowVisibility(IBinder token, boolean show) {
        addTaint(show);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r == null)        
        {
            return;
        } //End block
    if(!show && !r.stopped)        
        {
            performStopActivityInner(r, null, show, false);
        } //End block
        else
    if(show && r.stopped)        
        {
            unscheduleGcIdler();
            r.activity.performRestart();
            r.stopped = false;
        } //End block
    if(r.activity.mDecor != null)        
        {
    if(false){ }            updateVisibility(r, show);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.496 -0400", hash_original_method = "EAD4881422CEC6751FCD8576FDC7454E", hash_generated_method = "434436CE2CF268F54D96EECEC5FEDAF9")
    private void handleSleeping(IBinder token, boolean sleeping) {
        addTaint(sleeping);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r == null)        
        {
            return;
        } //End block
    if(sleeping)        
        {
    if(!r.stopped && !r.isPreHoneycomb())            
            {
                try 
                {
                    r.activity.performStop();
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException varB40B9960AFA41B7CBB246D406397E100_1389653808 = new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        varB40B9960AFA41B7CBB246D406397E100_1389653808.addTaint(taint);
                        throw varB40B9960AFA41B7CBB246D406397E100_1389653808;
                    } //End block
                } //End block
                r.stopped = true;
            } //End block
    if(!r.isPreHoneycomb())            
            {
                QueuedWork.waitToFinish();
            } //End block
            try 
            {
                ActivityManagerNative.getDefault().activitySlept(r.token);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        else
        {
    if(r.stopped && r.activity.mVisibleFromServer)            
            {
                r.activity.performRestart();
                r.stopped = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.497 -0400", hash_original_method = "E4614A97277DCEBAE71CAB13BCF3AEA6", hash_generated_method = "D1BB498CD4A9BC2067F5BDB99E6BFE83")
    private void handleSetCoreSettings(Bundle coreSettings) {
        synchronized
(mPackages)        {
            mCoreSettings = coreSettings;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //mCoreSettings = coreSettings;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.498 -0400", hash_original_method = "CFE517344EE2BFA081F85835A58153DF", hash_generated_method = "41E965052DA99849AEB1F5B55DEAF99D")
    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData data) {
        addTaint(data.getTaint());
        LoadedApk apk = peekPackageInfo(data.pkg, false);
    if(apk != null)        
        {
            apk.mCompatibilityInfo.set(data.info);
        } //End block
        apk = peekPackageInfo(data.pkg, true);
    if(apk != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.500 -0400", hash_original_method = "02C0B6EC41B1BF345DD1D4B6B6C7E1EA", hash_generated_method = "490C0DD5D0E4FDE81AA3A34C1C6ECF26")
    private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
        addTaint(results.getTaint());
        addTaint(r.getTaint());
        final int N = results.size();
for(int i=0;i<N;i++)
        {
            ResultInfo ri = results.get(i);
            try 
            {
    if(ri.mData != null)                
                {
                    ri.mData.setExtrasClassLoader(r.activity.getClassLoader());
                } //End block
    if(DEBUG_RESULTS){ }                r.activity.dispatchActivityResult(ri.mResultWho,
                        ri.mRequestCode, ri.mResultCode, ri.mData);
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(r.activity, e))                
                {
                    RuntimeException var77A3ADB9AFE2948EBE2C208B84D83006_1120746388 = new RuntimeException(
                            "Failure delivering result " + ri + " to activity "
                            + r.intent.getComponent().toShortString()
                            + ": " + e.toString(), e);
                    var77A3ADB9AFE2948EBE2C208B84D83006_1120746388.addTaint(taint);
                    throw var77A3ADB9AFE2948EBE2C208B84D83006_1120746388;
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.505 -0400", hash_original_method = "132B22472693443B534F2F702D692F04", hash_generated_method = "8EE063E951F5DFB6153E48E6ED2FB336")
    private void handleSendResult(ResultData res) {
        addTaint(res.getTaint());
        ActivityClientRecord r = mActivities.get(res.token);
    if(DEBUG_RESULTS){ }    if(r != null)        
        {
            final boolean resumed = !r.paused;
    if(!r.activity.mFinished && r.activity.mDecor != null
                    && r.hideForNow && resumed)            
            {
                updateVisibility(r, true);
            } //End block
    if(resumed)            
            {
                try 
                {
                    r.activity.mCalled = false;
                    r.activity.mTemporaryPause = true;
                    mInstrumentation.callActivityOnPause(r.activity);
    if(!r.activity.mCalled)                    
                    {
                        SuperNotCalledException var47B6BE7C11FC09EAC2B61A203C9ED5C3_335686903 = new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString()
                            + " did not call through to super.onPause()");
                        var47B6BE7C11FC09EAC2B61A203C9ED5C3_335686903.addTaint(taint);
                        throw var47B6BE7C11FC09EAC2B61A203C9ED5C3_335686903;
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var01C0879CF941A9B86515CD1539C2F3E4_993631260 = new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        var01C0879CF941A9B86515CD1539C2F3E4_993631260.addTaint(taint);
                        throw var01C0879CF941A9B86515CD1539C2F3E4_993631260;
                    } //End block
                } //End block
            } //End block
            deliverResults(r, res.results);
    if(resumed)            
            {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.506 -0400", hash_original_method = "44788E1192B2AF3D6F2EAE0CA2032491", hash_generated_method = "1D813003CEDD905E56E726350768AE03")
    public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        addTaint(finishing);
        addTaint(token.getTaint());
ActivityClientRecord var941FFFA17B6E7D8B596843B4A085C112_2135372004 =         performDestroyActivity(token, finishing, 0, false);
        var941FFFA17B6E7D8B596843B4A085C112_2135372004.addTaint(taint);
        return var941FFFA17B6E7D8B596843B4A085C112_2135372004;
        // ---------- Original Method ----------
        //return performDestroyActivity(token, finishing, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.509 -0400", hash_original_method = "C0523473C414844F9752EDA7A2CAF03B", hash_generated_method = "EE3FFF8BE7A8860963D617487EF5CFBA")
    private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        addTaint(getNonConfigInstance);
        addTaint(configChanges);
        addTaint(finishing);
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
        Class activityClass = null;
    if(localLOGV){ }    if(r != null)        
        {
            activityClass = r.activity.getClass();
            r.activity.mConfigChangeFlags |= configChanges;
    if(finishing)            
            {
                r.activity.mFinished = true;
            } //End block
    if(!r.paused)            
            {
                try 
                {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    EventLog.writeEvent(LOG_ON_PAUSE_CALLED,
                            r.activity.getComponentName().getClassName());
    if(!r.activity.mCalled)                    
                    {
                        SuperNotCalledException var9BC1655424AD831BAB330609232345A1_355763162 = new SuperNotCalledException(
                            "Activity " + safeToComponentShortString(r.intent)
                            + " did not call through to super.onPause()");
                        var9BC1655424AD831BAB330609232345A1_355763162.addTaint(taint);
                        throw var9BC1655424AD831BAB330609232345A1_355763162;
                    } //End block
                } //End block
                catch (SuperNotCalledException e)
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var79F563D718B7DCD93447BEA1C0E96614_228578520 = new RuntimeException(
                                "Unable to pause activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        var79F563D718B7DCD93447BEA1C0E96614_228578520.addTaint(taint);
                        throw var79F563D718B7DCD93447BEA1C0E96614_228578520;
                    } //End block
                } //End block
                r.paused = true;
            } //End block
    if(!r.stopped)            
            {
                try 
                {
                    r.activity.performStop();
                } //End block
                catch (SuperNotCalledException e)
                {
                    e.addTaint(taint);
                    throw e;
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var8851F4E7119CEEFFA0E6034FC285E356_277474953 = new RuntimeException(
                                "Unable to stop activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        var8851F4E7119CEEFFA0E6034FC285E356_277474953.addTaint(taint);
                        throw var8851F4E7119CEEFFA0E6034FC285E356_277474953;
                    } //End block
                } //End block
                r.stopped = true;
            } //End block
    if(getNonConfigInstance)            
            {
                try 
                {
                    r.lastNonConfigurationInstances
                            = r.activity.retainNonConfigurationInstances();
                } //End block
                catch (Exception e)
                {
    if(!mInstrumentation.onException(r.activity, e))                    
                    {
                        RuntimeException var71FD34231FD8104002DAA72967759D80_212839511 = new RuntimeException(
                                "Unable to retain activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        var71FD34231FD8104002DAA72967759D80_212839511.addTaint(taint);
                        throw var71FD34231FD8104002DAA72967759D80_212839511;
                    } //End block
                } //End block
            } //End block
            try 
            {
                r.activity.mCalled = false;
                mInstrumentation.callActivityOnDestroy(r.activity);
    if(!r.activity.mCalled)                
                {
                    SuperNotCalledException varB1515CE23B2640F750F14CD83291FEF5_1377822916 = new SuperNotCalledException(
                        "Activity " + safeToComponentShortString(r.intent) +
                        " did not call through to super.onDestroy()");
                    varB1515CE23B2640F750F14CD83291FEF5_1377822916.addTaint(taint);
                    throw varB1515CE23B2640F750F14CD83291FEF5_1377822916;
                } //End block
    if(r.window != null)                
                {
                    r.window.closeAllPanels();
                } //End block
            } //End block
            catch (SuperNotCalledException e)
            {
                e.addTaint(taint);
                throw e;
            } //End block
            catch (Exception e)
            {
    if(!mInstrumentation.onException(r.activity, e))                
                {
                    RuntimeException var33EF9B28F8CA84D339B47EA8F13AD7A0_1632970094 = new RuntimeException(
                            "Unable to destroy activity " + safeToComponentShortString(r.intent)
                            + ": " + e.toString(), e);
                    var33EF9B28F8CA84D339B47EA8F13AD7A0_1632970094.addTaint(taint);
                    throw var33EF9B28F8CA84D339B47EA8F13AD7A0_1632970094;
                } //End block
            } //End block
        } //End block
        mActivities.remove(token);
        StrictMode.decrementExpectedActivityCount(activityClass);
ActivityClientRecord var4C1F3C86A0E56B6E375080F5F710547E_1910743126 =         r;
        var4C1F3C86A0E56B6E375080F5F710547E_1910743126.addTaint(taint);
        return var4C1F3C86A0E56B6E375080F5F710547E_1910743126;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SPEC)
    private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.514 -0400", hash_original_method = "FF5883360F029BC934513AEE9A22C396", hash_generated_method = "55190C346AD76E59E14C88E784A8B5A8")
    private void handleDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        addTaint(getNonConfigInstance);
        addTaint(configChanges);
        addTaint(finishing);
        addTaint(token.getTaint());
        ActivityClientRecord r = performDestroyActivity(token, finishing,
                configChanges, getNonConfigInstance);
    if(r != null)        
        {
            cleanUpPendingRemoveWindows(r);
            WindowManager wm = r.activity.getWindowManager();
            View v = r.activity.mDecor;
    if(v != null)            
            {
    if(r.activity.mVisibleFromServer)                
                {
                    mNumVisibleActivities--;
                } //End block
                IBinder wtoken = v.getWindowToken();
    if(r.activity.mWindowAdded)                
                {
    if(r.onlyLocalRequest)                    
                    {
                        r.mPendingRemoveWindow = v;
                        r.mPendingRemoveWindowManager = wm;
                    } //End block
                    else
                    {
                        wm.removeViewImmediate(v);
                    } //End block
                } //End block
    if(wtoken != null && r.mPendingRemoveWindow == null)                
                {
                    WindowManagerImpl.getDefault().closeAll(wtoken,
                            r.activity.getClass().getName(), "Activity");
                } //End block
                r.activity.mDecor = null;
            } //End block
    if(r.mPendingRemoveWindow == null)            
            {
                WindowManagerImpl.getDefault().closeAll(token,
                        r.activity.getClass().getName(), "Activity");
            } //End block
            Context c = r.activity.getBaseContext();
    if(c instanceof ContextImpl)            
            {
                ((ContextImpl) c).scheduleFinalCleanup(
                        r.activity.getClass().getName(), "Activity");
            } //End block
        } //End block
    if(finishing)        
        {
            try 
            {
                ActivityManagerNative.getDefault().activityDestroyed(token);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.517 -0400", hash_original_method = "A011A63AC4A3DA99018317E87A8885A6", hash_generated_method = "B90C29A886C6C99C7923E5689CCB1737")
    public final void requestRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config,
            boolean fromServer) {
        addTaint(fromServer);
        addTaint(config.getTaint());
        addTaint(notResumed);
        addTaint(configChanges);
        addTaint(pendingNewIntents.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(token.getTaint());
        ActivityClientRecord target = null;
        synchronized
(mPackages)        {
for(int i=0;i<mRelaunchingActivities.size();i++)
            {
                ActivityClientRecord r = mRelaunchingActivities.get(i);
    if(r.token == token)                
                {
                    target = r;
    if(pendingResults != null)                    
                    {
    if(r.pendingResults != null)                        
                        {
                            r.pendingResults.addAll(pendingResults);
                        } //End block
                        else
                        {
                            r.pendingResults = pendingResults;
                        } //End block
                    } //End block
    if(pendingNewIntents != null)                    
                    {
    if(r.pendingIntents != null)                        
                        {
                            r.pendingIntents.addAll(pendingNewIntents);
                        } //End block
                        else
                        {
                            r.pendingIntents = pendingNewIntents;
                        } //End block
                    } //End block
                    break;
                } //End block
            } //End block
    if(target == null)            
            {
                target = new ActivityClientRecord();
                target.token = token;
                target.pendingResults = pendingResults;
                target.pendingIntents = pendingNewIntents;
    if(!fromServer)                
                {
                    ActivityClientRecord existing = mActivities.get(token);
    if(existing != null)                    
                    {
                        target.startsNotResumed = existing.paused;
                    } //End block
                    target.onlyLocalRequest = true;
                } //End block
                mRelaunchingActivities.add(target);
                queueOrSendMessage(H.RELAUNCH_ACTIVITY, target);
            } //End block
    if(fromServer)            
            {
                target.startsNotResumed = notResumed;
                target.onlyLocalRequest = false;
            } //End block
    if(config != null)            
            {
                target.createdConfig = config;
            } //End block
            target.pendingConfigChanges |= configChanges;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.522 -0400", hash_original_method = "BE5C8E93A13CCFB0B92460FEFD999D51", hash_generated_method = "D1F93BC1618A33A6FBFA9374BD10EA00")
    private void handleRelaunchActivity(ActivityClientRecord tmp) {
        addTaint(tmp.getTaint());
        unscheduleGcIdler();
        Configuration changedConfig = null;
        int configChanges = 0;
        synchronized
(mPackages)        {
            int N = mRelaunchingActivities.size();
            IBinder token = tmp.token;
            tmp = null;
for(int i=0;i<N;i++)
            {
                ActivityClientRecord r = mRelaunchingActivities.get(i);
    if(r.token == token)                
                {
                    tmp = r;
                    configChanges |= tmp.pendingConfigChanges;
                    mRelaunchingActivities.remove(i);
                    i--;
                    N--;
                } //End block
            } //End block
    if(tmp == null)            
            {
    if(DEBUG_CONFIGURATION){ }                return;
            } //End block
    if(DEBUG_CONFIGURATION){ }    if(mPendingConfiguration != null)            
            {
                changedConfig = mPendingConfiguration;
                mPendingConfiguration = null;
            } //End block
        } //End block
    if(tmp.createdConfig != null)        
        {
    if(mConfiguration == null
                    || (tmp.createdConfig.isOtherSeqNewer(mConfiguration)
                            && mConfiguration.diff(tmp.createdConfig) != 0))            
            {
    if(changedConfig == null
                        || tmp.createdConfig.isOtherSeqNewer(changedConfig))                
                {
                    changedConfig = tmp.createdConfig;
                } //End block
            } //End block
        } //End block
    if(DEBUG_CONFIGURATION){ }    if(changedConfig != null)        
        {
            handleConfigurationChanged(changedConfig, null);
        } //End block
        ActivityClientRecord r = mActivities.get(tmp.token);
    if(DEBUG_CONFIGURATION){ }    if(r == null)        
        {
            return;
        } //End block
        r.activity.mConfigChangeFlags |= configChanges;
        r.onlyLocalRequest = tmp.onlyLocalRequest;
        Intent currentIntent = r.activity.mIntent;
        r.activity.mChangingConfigurations = true;
    if(!r.paused)        
        {
            performPauseActivity(r.token, false, r.isPreHoneycomb());
        } //End block
    if(r.state == null && !r.stopped && !r.isPreHoneycomb())        
        {
            r.state = new Bundle();
            r.state.setAllowFds(false);
            mInstrumentation.callActivityOnSaveInstanceState(r.activity, r.state);
        } //End block
        handleDestroyActivity(r.token, false, configChanges, true);
        r.activity = null;
        r.window = null;
        r.hideForNow = false;
        r.nextIdle = null;
    if(tmp.pendingResults != null)        
        {
    if(r.pendingResults == null)            
            {
                r.pendingResults = tmp.pendingResults;
            } //End block
            else
            {
                r.pendingResults.addAll(tmp.pendingResults);
            } //End block
        } //End block
    if(tmp.pendingIntents != null)        
        {
    if(r.pendingIntents == null)            
            {
                r.pendingIntents = tmp.pendingIntents;
            } //End block
            else
            {
                r.pendingIntents.addAll(tmp.pendingIntents);
            } //End block
        } //End block
        r.startsNotResumed = tmp.startsNotResumed;
        handleLaunchActivity(r, currentIntent);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.524 -0400", hash_original_method = "D80F947211B8AA9FA3600ABD6DD9A5E5", hash_generated_method = "6AE6FAFCDC534F7180D15AC90382D13D")
    private void handleRequestThumbnail(IBinder token) {
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
        Bitmap thumbnail = createThumbnailBitmap(r);
        CharSequence description = null;
        try 
        {
            description = r.activity.onCreateDescription();
        } //End block
        catch (Exception e)
        {
    if(!mInstrumentation.onException(r.activity, e))            
            {
                RuntimeException var113C6266B9EAC79CFBF74B0A3E0E5AE9_1476655207 = new RuntimeException(
                        "Unable to create description of activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                var113C6266B9EAC79CFBF74B0A3E0E5AE9_1476655207.addTaint(taint);
                throw var113C6266B9EAC79CFBF74B0A3E0E5AE9_1476655207;
            } //End block
        } //End block
        try 
        {
            ActivityManagerNative.getDefault().reportThumbnail(
                token, thumbnail, description);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.525 -0400", hash_original_method = "FB356249739137DBEEC4A6A95AF7FF01", hash_generated_method = "F3608DA081323808C4F10A2C4CC05777")
     ArrayList<ComponentCallbacks2> collectComponentCallbacksLocked(
            boolean allActivities, Configuration newConfig) {
        addTaint(newConfig.getTaint());
        addTaint(allActivities);
        ArrayList<ComponentCallbacks2> callbacks = new ArrayList<ComponentCallbacks2>();
    if(mActivities.size() > 0)        
        {
            Iterator<ActivityClientRecord> it = mActivities.values().iterator();
            while
(it.hasNext())            
            {
                ActivityClientRecord ar = it.next();
                Activity a = ar.activity;
    if(a != null)                
                {
                    Configuration thisConfig = applyConfigCompatMainThread(newConfig,
                            ar.packageInfo.mCompatibilityInfo.getIfNeeded());
    if(!ar.activity.mFinished && (allActivities ||
                            (a != null && !ar.paused)))                    
                    {
                        callbacks.add(a);
                    } //End block
                    else
    if(thisConfig != null)                    
                    {
    if(DEBUG_CONFIGURATION){ }                        ar.newConfig = thisConfig;
                    } //End block
                } //End block
            } //End block
        } //End block
    if(mServices.size() > 0)        
        {
            Iterator<Service> it = mServices.values().iterator();
            while
(it.hasNext())            
            {
                callbacks.add(it.next());
            } //End block
        } //End block
        synchronized
(mProviderMap)        {
    if(mLocalProviders.size() > 0)            
            {
                Iterator<ProviderClientRecord> it = mLocalProviders.values().iterator();
                while
(it.hasNext())                
                {
                    callbacks.add(it.next().mLocalProvider);
                } //End block
            } //End block
        } //End block
        final int N = mAllApplications.size();
for(int i=0;i<N;i++)
        {
            callbacks.add(mAllApplications.get(i));
        } //End block
ArrayList<ComponentCallbacks2> var7E06ACD9C2C819F377F4C0B98904AB11_2026689599 =         callbacks;
        var7E06ACD9C2C819F377F4C0B98904AB11_2026689599.addTaint(taint);
        return var7E06ACD9C2C819F377F4C0B98904AB11_2026689599;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.527 -0400", hash_original_method = "EE8F576B02EBE8F159FE2A319294FB0B", hash_generated_method = "235239EA7A54F9000628EB8C6B1EDBA2")
    private final void performConfigurationChanged(
            ComponentCallbacks2 cb, Configuration config) {
        addTaint(config.getTaint());
        addTaint(cb.getTaint());
        Activity activity = (cb instanceof Activity) ? (Activity) cb : null;
    if(activity != null)        
        {
            activity.mCalled = false;
        } //End block
        boolean shouldChangeConfig = false;
    if((activity == null) || (activity.mCurrentConfig == null))        
        {
            shouldChangeConfig = true;
        } //End block
        else
        {
            int diff = activity.mCurrentConfig.diff(config);
    if(diff != 0)            
            {
    if((~activity.mActivityInfo.getRealConfigChanged() & diff) == 0)                
                {
                    shouldChangeConfig = true;
                } //End block
            } //End block
        } //End block
    if(DEBUG_CONFIGURATION){ }    if(shouldChangeConfig)        
        {
            cb.onConfigurationChanged(config);
    if(activity != null)            
            {
    if(!activity.mCalled)                
                {
                    SuperNotCalledException var646049B44AD5A13FBB73C558388E49FB_1121006050 = new SuperNotCalledException(
                            "Activity " + activity.getLocalClassName() +
                        " did not call through to super.onConfigurationChanged()");
                    var646049B44AD5A13FBB73C558388E49FB_1121006050.addTaint(taint);
                    throw var646049B44AD5A13FBB73C558388E49FB_1121006050;
                } //End block
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(config);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.529 -0400", hash_original_method = "7998F4E95C6128D4C656838AA6A46FDD", hash_generated_method = "9E9B2B1D25F84E2C71E51E0FFCC6B1B4")
    public final void applyConfigurationToResources(Configuration config) {
        addTaint(config.getTaint());
        synchronized
(mPackages)        {
            applyConfigurationToResourcesLocked(config, null);
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //applyConfigurationToResourcesLocked(config, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.530 -0400", hash_original_method = "EEF98A9F112FD55BEEF8F44AEC4B59F9", hash_generated_method = "ACA0DE8052799EDFF68A7260A18C303E")
    final boolean applyConfigurationToResourcesLocked(Configuration config,
            CompatibilityInfo compat) {
        addTaint(config.getTaint());
    if(mResConfiguration == null)        
        {
            mResConfiguration = new Configuration();
        } //End block
    if(!mResConfiguration.isOtherSeqNewer(config) && compat == null)        
        {
    if(DEBUG_CONFIGURATION){ }            boolean var68934A3E9455FA72420237EB05902327_1577480934 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676059100 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676059100;
        } //End block
        int changes = mResConfiguration.updateFrom(config);
        DisplayMetrics dm = getDisplayMetricsLocked(null, true);
    if(compat != null && (mResCompatibilityInfo == null ||
                !mResCompatibilityInfo.equals(compat)))        
        {
            mResCompatibilityInfo = compat;
            changes |= ActivityInfo.CONFIG_SCREEN_LAYOUT
                    | ActivityInfo.CONFIG_SCREEN_SIZE
                    | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
        } //End block
    if(config.locale != null)        
        {
            Locale.setDefault(config.locale);
        } //End block
        Resources.updateSystemConfiguration(config, dm, compat);
        ApplicationPackageManager.configurationChanged();
        Iterator<WeakReference<Resources>> it = mActiveResources.values().iterator();
        while
(it.hasNext())        
        {
            WeakReference<Resources> v = it.next();
            Resources r = v.get();
    if(r != null)            
            {
    if(DEBUG_CONFIGURATION){ }                r.updateConfiguration(config, dm, compat);
            } //End block
            else
            {
                it.remove();
            } //End block
        } //End block
        boolean var71E9EDADFCE078A37143FE55C5529B5E_1327082725 = (changes != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1161852498 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1161852498;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.532 -0400", hash_original_method = "725924C293B055D0DF33B7EFFEB77D1D", hash_generated_method = "01EF26AFC5486EF67284FC6549D15FC2")
    final Configuration applyCompatConfiguration() {
        Configuration config = mConfiguration;
    if(mCompatConfiguration == null)        
        {
            mCompatConfiguration = new Configuration();
        } //End block
        mCompatConfiguration.setTo(mConfiguration);
    if(mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen())        
        {
            mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
            config = mCompatConfiguration;
        } //End block
Configuration var81567CF7749AF2EA37063F56A4D104CE_1833637018 =         config;
        var81567CF7749AF2EA37063F56A4D104CE_1833637018.addTaint(taint);
        return var81567CF7749AF2EA37063F56A4D104CE_1833637018;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.534 -0400", hash_original_method = "113EE31E90E397ADB444BCE89226F34D", hash_generated_method = "AF01860612A1593FCDD1AC94C58D5D65")
    final void handleConfigurationChanged(Configuration config, CompatibilityInfo compat) {
        addTaint(compat.getTaint());
        addTaint(config.getTaint());
        ArrayList<ComponentCallbacks2> callbacks = null;
        synchronized
(mPackages)        {
    if(mPendingConfiguration != null)            
            {
    if(!mPendingConfiguration.isOtherSeqNewer(config))                
                {
                    config = mPendingConfiguration;
                } //End block
                mPendingConfiguration = null;
            } //End block
    if(config == null)            
            {
                return;
            } //End block
    if(DEBUG_CONFIGURATION){ }            applyConfigurationToResourcesLocked(config, compat);
    if(mConfiguration == null)            
            {
                mConfiguration = new Configuration();
            } //End block
    if(!mConfiguration.isOtherSeqNewer(config) && compat == null)            
            {
                return;
            } //End block
            mConfiguration.updateFrom(config);
            config = applyCompatConfiguration();
            callbacks = collectComponentCallbacksLocked(false, config);
        } //End block
        WindowManagerImpl.getDefault().trimLocalMemory();
    if(callbacks != null)        
        {
            final int N = callbacks.size();
for(int i=0;i<N;i++)
            {
                performConfigurationChanged(callbacks.get(i), config);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.537 -0400", hash_original_method = "BCC706E36DA945D7B18FA237C2CE8FDE", hash_generated_method = "EEFC805617F969C83EE5284B01B955A5")
    final void handleActivityConfigurationChanged(IBinder token) {
        addTaint(token.getTaint());
        ActivityClientRecord r = mActivities.get(token);
    if(r == null || r.activity == null)        
        {
            return;
        } //End block
    if(DEBUG_CONFIGURATION){ }        performConfigurationChanged(r.activity, mCompatConfiguration);
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r == null || r.activity == null) {
            //return;
        //}
        //if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handle activity config changed: "
                //+ r.activityInfo.name);
        //performConfigurationChanged(r.activity, mCompatConfiguration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.540 -0400", hash_original_method = "381D38D2D5D4A7D408E3117408C36DEC", hash_generated_method = "8C419DE4504573E94E2BE50F5F015BC1")
    final void handleProfilerControl(boolean start, ProfilerControlData pcd, int profileType) {
        addTaint(profileType);
        addTaint(pcd.getTaint());
        addTaint(start);
    if(start)        
        {
            try 
            {
switch(profileType){
                case 1:
                ViewDebug.startLooperProfiling(pcd.path, pcd.fd.getFileDescriptor());
                break;
                default:
                mProfiler.setProfiler(pcd.path, pcd.fd);
                mProfiler.autoStopProfiler = false;
                mProfiler.startProfiling();
                break;
}
            } //End block
            catch (RuntimeException e)
            {
            } //End block
            finally 
            {
                try 
                {
                    pcd.fd.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
        } //End block
        else
        {
switch(profileType){
            case 1:
            ViewDebug.stopLooperProfiling();
            break;
            default:
            mProfiler.stopProfiling();
            break;
}
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.542 -0400", hash_original_method = "34F4499A4B96EEF8A91ACC379A0CD361", hash_generated_method = "B7772BF8C97D127E37A43608C02E8EB5")
    final void handleDumpHeap(boolean managed, DumpHeapData dhd) {
        addTaint(dhd.getTaint());
        addTaint(managed);
    if(managed)        
        {
            try 
            {
                Debug.dumpHprofData(dhd.path, dhd.fd.getFileDescriptor());
            } //End block
            catch (IOException e)
            {
            } //End block
            finally 
            {
                try 
                {
                    dhd.fd.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.547 -0400", hash_original_method = "44425A5A4DA98E1612A84EA820E43FA0", hash_generated_method = "6B819890CDE7C85EA7E817010EA265F7")
    final void handleDispatchPackageBroadcast(int cmd, String[] packages) {
        addTaint(packages[0].getTaint());
        addTaint(cmd);
        boolean hasPkgInfo = false;
    if(packages != null)        
        {
for(int i=packages.length-1;i>=0;i--)
            {
    if(!hasPkgInfo)                
                {
                    WeakReference<LoadedApk> ref;
                    ref = mPackages.get(packages[i]);
    if(ref != null && ref.get() != null)                    
                    {
                        hasPkgInfo = true;
                    } //End block
                    else
                    {
                        ref = mResourcePackages.get(packages[i]);
    if(ref != null && ref.get() != null)                        
                        {
                            hasPkgInfo = true;
                        } //End block
                    } //End block
                } //End block
                mPackages.remove(packages[i]);
                mResourcePackages.remove(packages[i]);
            } //End block
        } //End block
        ApplicationPackageManager.handlePackageBroadcast(cmd, packages,
                hasPkgInfo);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.548 -0400", hash_original_method = "A02231B2047F154A7A69F70A3ED846FE", hash_generated_method = "A03E08D1DC0ADF9308EE5206A187B8F3")
    final void handleLowMemory() {
        ArrayList<ComponentCallbacks2> callbacks;
        synchronized
(mPackages)        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } //End block
        final int N = callbacks.size();
for(int i=0;i<N;i++)
        {
            callbacks.get(i).onLowMemory();
        } //End block
    if(Process.myUid() != Process.SYSTEM_UID)        
        {
            int sqliteReleased = SQLiteDatabase.releaseMemory();
            EventLog.writeEvent(SQLITE_MEM_RELEASED_EVENT_LOG_TAG, sqliteReleased);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.549 -0400", hash_original_method = "23BC0760ADA981D880A84DB7A1CF33BD", hash_generated_method = "A93037F70ED42CCB0A3B8907296CF5DF")
    final void handleTrimMemory(int level) {
        addTaint(level);
        WindowManagerImpl.getDefault().trimMemory(level);
        ArrayList<ComponentCallbacks2> callbacks;
        synchronized
(mPackages)        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } //End block
        final int N = callbacks.size();
for(int i=0;i<N;i++)
        {
            callbacks.get(i).onTrimMemory(level);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.550 -0400", hash_original_method = "E6BF73423380262DF6FF59682ACDE1E2", hash_generated_method = "EFABE06F17FF2EE3F41D177359AB176A")
    private void setupGraphicsSupport(LoadedApk info) {
        addTaint(info.getTaint());
        try 
        {
            int uid = Process.myUid();
            String[] packages = getPackageManager().getPackagesForUid(uid);
    if(packages.length == 1)            
            {
                ContextImpl appContext = new ContextImpl();
                appContext.init(info, null, this);
                HardwareRenderer.setupDiskCache(appContext.getCacheDir());
            } //End block
        } //End block
        catch (RemoteException e)
        {
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.558 -0400", hash_original_method = "7EBE3C125D399FC9ADE021947462EA9C", hash_generated_method = "77EA83EA7286BCA5D33D766D3C6D4E05")
    private void handleBindApplication(AppBindData data) {
        mBoundApplication = data;
        mConfiguration = new Configuration(data.config);
        mCompatConfiguration = new Configuration(data.config);
        mProfiler = new Profiler();
        mProfiler.profileFile = data.initProfileFile;
        mProfiler.profileFd = data.initProfileFd;
        mProfiler.autoStopProfiler = data.initAutoStopProfiler;
        Process.setArgV0(data.processName);
        android.ddm.DdmHandleAppName.setAppName(data.processName);
    if(data.persistent)        
        {
            Display display = WindowManagerImpl.getDefault().getDefaultDisplay();
    if(!ActivityManager.isHighEndGfx(display))            
            {
                HardwareRenderer.disable(false);
            } //End block
        } //End block
    if(mProfiler.profileFd != null)        
        {
            mProfiler.startProfiling();
        } //End block
    if(data.appInfo.targetSdkVersion <= 12)        
        {
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } //End block
        TimeZone.setDefault(null);
        Locale.setDefault(data.config.locale);
        applyConfigurationToResourcesLocked(data.config, data.compatInfo);
        applyCompatConfiguration();
        data.info = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        setupGraphicsSupport(data.info);
    if((data.appInfo.flags &
             (ApplicationInfo.FLAG_SYSTEM |
              ApplicationInfo.FLAG_UPDATED_SYSTEM_APP)) != 0)        
        {
            StrictMode.conditionallyEnableDebugLogging();
        } //End block
    if(data.appInfo.targetSdkVersion > 9)        
        {
            StrictMode.enableDeathOnNetwork();
        } //End block
    if((data.appInfo.flags&ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES)
                == 0)        
        {
            Bitmap.setDefaultDensity(DisplayMetrics.DENSITY_DEFAULT);
        } //End block
    if(data.debugMode != IApplicationThread.DEBUG_OFF)        
        {
            Debug.changeDebugPort(8100);
    if(data.debugMode == IApplicationThread.DEBUG_WAIT)            
            {
                IActivityManager mgr = ActivityManagerNative.getDefault();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, true);
                } //End block
                catch (RemoteException ex)
                {
                } //End block
                Debug.waitForDebugger();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, false);
                } //End block
                catch (RemoteException ex)
                {
                } //End block
            } //End block
            else
            {
            } //End block
        } //End block
        IBinder b = ServiceManager.getService(Context.CONNECTIVITY_SERVICE);
    if(b != null)        
        {
            IConnectivityManager service = IConnectivityManager.Stub.asInterface(b);
            try 
            {
                ProxyProperties proxyProperties = service.getProxy();
                Proxy.setHttpProxySystemProperty(proxyProperties);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
    if(data.instrumentationName != null)        
        {
            ContextImpl appContext = new ContextImpl();
            appContext.init(data.info, null, this);
            InstrumentationInfo ii = null;
            try 
            {
                ii = appContext.getPackageManager().
                    getInstrumentationInfo(data.instrumentationName, 0);
            } //End block
            catch (PackageManager.NameNotFoundException e)
            {
            } //End block
    if(ii == null)            
            {
                RuntimeException var46FDF3B0EEFD838E27B7818CD1709303_1333555245 = new RuntimeException(
                    "Unable to find instrumentation info for: "
                    + data.instrumentationName);
                var46FDF3B0EEFD838E27B7818CD1709303_1333555245.addTaint(taint);
                throw var46FDF3B0EEFD838E27B7818CD1709303_1333555245;
            } //End block
            mInstrumentationAppDir = ii.sourceDir;
            mInstrumentationAppPackage = ii.packageName;
            mInstrumentedAppDir = data.info.getAppDir();
            ApplicationInfo instrApp = new ApplicationInfo();
            instrApp.packageName = ii.packageName;
            instrApp.sourceDir = ii.sourceDir;
            instrApp.publicSourceDir = ii.publicSourceDir;
            instrApp.dataDir = ii.dataDir;
            instrApp.nativeLibraryDir = ii.nativeLibraryDir;
            LoadedApk pi = getPackageInfo(instrApp, data.compatInfo,
                    appContext.getClassLoader(), false, true);
            ContextImpl instrContext = new ContextImpl();
            instrContext.init(pi, null, this);
            try 
            {
                java.lang.ClassLoader cl = instrContext.getClassLoader();
                mInstrumentation = (Instrumentation)
                    cl.loadClass(data.instrumentationName.getClassName()).newInstance();
            } //End block
            catch (Exception e)
            {
                RuntimeException varF35138FDAEF31E83E493BC8AECF73533_1632122764 = new RuntimeException(
                    "Unable to instantiate instrumentation "
                    + data.instrumentationName + ": " + e.toString(), e);
                varF35138FDAEF31E83E493BC8AECF73533_1632122764.addTaint(taint);
                throw varF35138FDAEF31E83E493BC8AECF73533_1632122764;
            } //End block
            mInstrumentation.init(this, instrContext, appContext,
                    new ComponentName(ii.packageName, ii.name), data.instrumentationWatcher);
    if(mProfiler.profileFile != null && !ii.handleProfiling
                    && mProfiler.profileFd == null)            
            {
                mProfiler.handlingProfiling = true;
                File file = new File(mProfiler.profileFile);
                file.getParentFile().mkdirs();
                Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
            } //End block
            try 
            {
                mInstrumentation.onCreate(data.instrumentationArgs);
            } //End block
            catch (Exception e)
            {
                RuntimeException varB329F149F9058AEF601C3455C8934210_2108362955 = new RuntimeException(
                    "Exception thrown in onCreate() of "
                    + data.instrumentationName + ": " + e.toString(), e);
                varB329F149F9058AEF601C3455C8934210_2108362955.addTaint(taint);
                throw varB329F149F9058AEF601C3455C8934210_2108362955;
            } //End block
        } //End block
        else
        {
            mInstrumentation = new Instrumentation();
        } //End block
    if((data.appInfo.flags&ApplicationInfo.FLAG_LARGE_HEAP) != 0)        
        {
            dalvik.system.VMRuntime.getRuntime().clearGrowthLimit();
        } //End block
        Application app = data.info.makeApplication(data.restrictedBackupMode, null);
        mInitialApplication = app;
    if(!data.restrictedBackupMode)        
        {
            List<ProviderInfo> providers = data.providers;
    if(providers != null)            
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
    if(!mInstrumentation.onException(app, e))            
            {
                RuntimeException varADC9641D2DD7F467934A79889D69CEE2_1637840790 = new RuntimeException(
                    "Unable to create application " + app.getClass().getName()
                    + ": " + e.toString(), e);
                varADC9641D2DD7F467934A79889D69CEE2_1637840790.addTaint(taint);
                throw varADC9641D2DD7F467934A79889D69CEE2_1637840790;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.561 -0400", hash_original_method = "87522E170C98EEC17A950D0CB0F18A7D", hash_generated_method = "34B6A1A2D0884BBCE6144B49C2C39C14")
    final void finishInstrumentation(int resultCode, Bundle results) {
        addTaint(results.getTaint());
        addTaint(resultCode);
        IActivityManager am = ActivityManagerNative.getDefault();
    if(mProfiler.profileFile != null && mProfiler.handlingProfiling
                && mProfiler.profileFd == null)        
        {
            Debug.stopMethodTracing();
        } //End block
        try 
        {
            am.finishInstrumentation(mAppThread, resultCode, results);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.563 -0400", hash_original_method = "E6307225A7BED03273D5285E74D77996", hash_generated_method = "1AE124E399F19951F3B953C95D9EADD4")
    private void installContentProviders(
            Context context, List<ProviderInfo> providers) {
        addTaint(providers.getTaint());
        addTaint(context.getTaint());
        final ArrayList<IActivityManager.ContentProviderHolder> results = new ArrayList<IActivityManager.ContentProviderHolder>();
        Iterator<ProviderInfo> i = providers.iterator();
        while
(i.hasNext())        
        {
            ProviderInfo cpi = i.next();
            StringBuilder buf = new StringBuilder(128);
            buf.append("Pub ");
            buf.append(cpi.authority);
            buf.append(": ");
            buf.append(cpi.name);
            IContentProvider cp = installProvider(context, null, cpi,
                    false , true );
    if(cp != null)            
            {
                IActivityManager.ContentProviderHolder cph = new IActivityManager.ContentProviderHolder(cpi);
                cph.provider = cp;
                cph.noReleaseNeeded = true;
                results.add(cph);
            } //End block
        } //End block
        try 
        {
            ActivityManagerNative.getDefault().publishContentProviders(
                getApplicationThread(), results);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.566 -0400", hash_original_method = "F88C15CE4CC55ECD0AF9CC176F41EB20", hash_generated_method = "F79AC13632097C6C6811F0BD3E138BDA")
    public final IContentProvider acquireProvider(Context c, String name) {
        addTaint(name.getTaint());
        addTaint(c.getTaint());
        IContentProvider provider = acquireExistingProvider(c, name);
    if(provider != null)        
        {
IContentProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_194426635 =             provider;
            varC1EB7B12CCABB27D431E5B91E5FF9ECB_194426635.addTaint(taint);
            return varC1EB7B12CCABB27D431E5B91E5FF9ECB_194426635;
        } //End block
        IActivityManager.ContentProviderHolder holder = null;
        try 
        {
            holder = ActivityManagerNative.getDefault().getContentProvider(
                    getApplicationThread(), name);
        } //End block
        catch (RemoteException ex)
        {
        } //End block
    if(holder == null)        
        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1759207015 =             null;
            var540C13E9E156B687226421B24F2DF178_1759207015.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1759207015;
        } //End block
        provider = installProvider(c, holder.provider, holder.info,
                true , holder.noReleaseNeeded);
    if(holder.provider != null && provider != holder.provider)        
        {
    if(localLOGV)            
            {
            } //End block
            try 
            {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), name);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
IContentProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_1622452320 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_1622452320.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_1622452320;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.568 -0400", hash_original_method = "D0EC607B4605DB37ABCB0EC4802499DE", hash_generated_method = "740361874AD479E1E7557B8262F8B9D3")
    public final IContentProvider acquireExistingProvider(Context c, String name) {
        addTaint(name.getTaint());
        addTaint(c.getTaint());
        synchronized
(mProviderMap)        {
            ProviderClientRecord pr = mProviderMap.get(name);
    if(pr == null)            
            {
IContentProvider var540C13E9E156B687226421B24F2DF178_803771929 =                 null;
                var540C13E9E156B687226421B24F2DF178_803771929.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_803771929;
            } //End block
            IContentProvider provider = pr.mProvider;
            IBinder jBinder = provider.asBinder();
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
    if(prc != null)            
            {
                prc.count += 1;
    if(prc.count == 1)                
                {
    if(localLOGV)                    
                    {
                    } //End block
                    mH.removeMessages(H.REMOVE_PROVIDER, provider);
                } //End block
            } //End block
IContentProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_315743242 =             provider;
            varC1EB7B12CCABB27D431E5B91E5FF9ECB_315743242.addTaint(taint);
            return varC1EB7B12CCABB27D431E5B91E5FF9ECB_315743242;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.570 -0400", hash_original_method = "570D24C9467F1DF00A050F1BB22169F2", hash_generated_method = "A28C8A66EECED801FA74B5FA37D99CCA")
    public final boolean releaseProvider(IContentProvider provider) {
        addTaint(provider.getTaint());
    if(provider == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_167535201 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185645133 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_185645133;
        } //End block
        IBinder jBinder = provider.asBinder();
        synchronized
(mProviderMap)        {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
    if(prc == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_708701355 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1855765517 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1855765517;
            } //End block
    if(prc.count == 0)            
            {
    if(localLOGV){ }                boolean var68934A3E9455FA72420237EB05902327_1943168134 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641431625 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_641431625;
            } //End block
            prc.count -= 1;
    if(prc.count == 0)            
            {
                Message msg = mH.obtainMessage(H.REMOVE_PROVIDER, provider);
                mH.sendMessage(msg);
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_1074988578 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_307214743 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_307214743;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.574 -0400", hash_original_method = "26DD2496F7761FB77064EC4900EC6CC4", hash_generated_method = "58B3CD0046131D1E4CA9A39404860046")
    final void completeRemoveProvider(IContentProvider provider) {
        addTaint(provider.getTaint());
        IBinder jBinder = provider.asBinder();
        String remoteProviderName = null;
        synchronized
(mProviderMap)        {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
    if(prc == null)            
            {
    if(localLOGV){ }                return;
            } //End block
    if(prc.count != 0)            
            {
    if(localLOGV){ }                return;
            } //End block
            mProviderRefCountMap.remove(jBinder);
            Iterator<ProviderClientRecord> iter = mProviderMap.values().iterator();
            while
(iter.hasNext())            
            {
                ProviderClientRecord pr = iter.next();
                IBinder myBinder = pr.mProvider.asBinder();
    if(myBinder == jBinder)                
                {
                    iter.remove();
    if(pr.mLocalProvider == null)                    
                    {
                        myBinder.unlinkToDeath(pr, 0);
    if(remoteProviderName == null)                        
                        {
                            remoteProviderName = pr.mName;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End block
    if(remoteProviderName != null)        
        {
            try 
            {
    if(localLOGV)                
                {
                } //End block
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), remoteProviderName);
            } //End block
            catch (RemoteException e)
            {
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.575 -0400", hash_original_method = "89FC0B7C2EBDC1E0BBDB9AF687772CD2", hash_generated_method = "952760C5D02BD45775F242841018D3A3")
    final void removeDeadProvider(String name, IContentProvider provider) {
        addTaint(provider.getTaint());
        addTaint(name.getTaint());
        synchronized
(mProviderMap)        {
            ProviderClientRecord pr = mProviderMap.get(name);
    if(pr != null && pr.mProvider.asBinder() == provider.asBinder())            
            {
                ProviderClientRecord removed = mProviderMap.remove(name);
    if(removed != null)                
                {
                    removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.579 -0400", hash_original_method = "54C9C23E13579DED3FD2406679DE4E02", hash_generated_method = "3BBEEB186344E58B776A179D23C8D070")
    private IContentProvider installProvider(Context context,
            IContentProvider provider, ProviderInfo info,
            boolean noisy, boolean noReleaseNeeded) {
        addTaint(noReleaseNeeded);
        addTaint(noisy);
        addTaint(info.getTaint());
        addTaint(provider.getTaint());
        addTaint(context.getTaint());
        ContentProvider localProvider = null;
    if(provider == null)        
        {
    if(noisy)            
            {
                Slog.d(TAG, "Loading provider " + info.authority + ": "
                        + info.name);
            } //End block
            Context c = null;
            ApplicationInfo ai = info.applicationInfo;
    if(context.getPackageName().equals(ai.packageName))            
            {
                c = context;
            } //End block
            else
    if(mInitialApplication != null &&
                    mInitialApplication.getPackageName().equals(ai.packageName))            
            {
                c = mInitialApplication;
            } //End block
            else
            {
                try 
                {
                    c = context.createPackageContext(ai.packageName,
                            Context.CONTEXT_INCLUDE_CODE);
                } //End block
                catch (PackageManager.NameNotFoundException e)
                {
                } //End block
            } //End block
    if(c == null)            
            {
IContentProvider var540C13E9E156B687226421B24F2DF178_1686199902 =                 null;
                var540C13E9E156B687226421B24F2DF178_1686199902.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1686199902;
            } //End block
            try 
            {
                final java.lang.ClassLoader cl = c.getClassLoader();
                localProvider = (ContentProvider)cl.
                    loadClass(info.name).newInstance();
                provider = localProvider.getIContentProvider();
    if(provider == null)                
                {
IContentProvider var540C13E9E156B687226421B24F2DF178_634771421 =                     null;
                    var540C13E9E156B687226421B24F2DF178_634771421.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_634771421;
                } //End block
    if(false){ }                localProvider.attachInfo(c, info);
            } //End block
            catch (java.lang.Exception e)
            {
    if(!mInstrumentation.onException(null, e))                
                {
                    RuntimeException var943EDBB9C18392D7E00F06DBDBF55363_1784181797 = new RuntimeException(
                            "Unable to get provider " + info.name
                            + ": " + e.toString(), e);
                    var943EDBB9C18392D7E00F06DBDBF55363_1784181797.addTaint(taint);
                    throw var943EDBB9C18392D7E00F06DBDBF55363_1784181797;
                } //End block
IContentProvider var540C13E9E156B687226421B24F2DF178_766922551 =                 null;
                var540C13E9E156B687226421B24F2DF178_766922551.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_766922551;
            } //End block
        } //End block
        else
    if(localLOGV)        
        {
        } //End block
        synchronized
(mProviderMap)        {
            IBinder jBinder = provider.asBinder();
            String names[] = PATTERN_SEMICOLON.split(info.authority);
for(int i = 0;i < names.length;i++)
            {
                ProviderClientRecord pr = mProviderMap.get(names[i]);
    if(pr != null)                
                {
    if(localLOGV)                    
                    {
                    } //End block
                    provider = pr.mProvider;
                } //End block
                else
                {
                    pr = new ProviderClientRecord(names[i], provider, localProvider);
    if(localProvider == null)                    
                    {
                        try 
                        {
                            jBinder.linkToDeath(pr, 0);
                        } //End block
                        catch (RemoteException e)
                        {
IContentProvider var540C13E9E156B687226421B24F2DF178_1026442279 =                             null;
                            var540C13E9E156B687226421B24F2DF178_1026442279.addTaint(taint);
                            return var540C13E9E156B687226421B24F2DF178_1026442279;
                        } //End block
                    } //End block
                    mProviderMap.put(names[i], pr);
                } //End block
            } //End block
    if(localProvider != null)            
            {
                ProviderClientRecord pr = mLocalProviders.get(jBinder);
    if(pr != null)                
                {
    if(localLOGV)                    
                    {
                    } //End block
                    provider = pr.mProvider;
                } //End block
                else
                {
                    pr = new ProviderClientRecord(null, provider, localProvider);
                    mLocalProviders.put(jBinder, pr);
                } //End block
            } //End block
    if(!noReleaseNeeded)            
            {
                ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
    if(prc != null)                
                {
    if(localLOGV)                    
                    {
                    } //End block
                    prc.count += 1;
    if(prc.count == 1)                    
                    {
    if(localLOGV)                        
                        {
                        } //End block
                        mH.removeMessages(H.REMOVE_PROVIDER, provider);
                    } //End block
                } //End block
                else
                {
                    mProviderRefCountMap.put(jBinder, new ProviderRefCount(1));
                } //End block
            } //End block
        } //End block
IContentProvider varC1EB7B12CCABB27D431E5B91E5FF9ECB_557915600 =         provider;
        varC1EB7B12CCABB27D431E5B91E5FF9ECB_557915600.addTaint(taint);
        return varC1EB7B12CCABB27D431E5B91E5FF9ECB_557915600;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.591 -0400", hash_original_method = "C124A05EAD0D975305C2EDD26DCF96DC", hash_generated_method = "7756EFE88333C8AA234E8BB101F204E4")
    private void attach(boolean system) {
        sThreadLocal.set(this);
        mSystemThread = system;
    if(!system)        
        {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.584 -0400", hash_original_method = "47807A5814B5D681B360E1F6CDD604E7", hash_generated_method = "CE4C0CC733C0731411E130B03C44D6CB")
        public void run() {
            ensureJitEnabled();
            // ---------- Original Method ----------
            //ensureJitEnabled();
        }
});
            android.ddm.DdmHandleAppName.setAppName("<pre-initialized>");
            RuntimeInit.setApplicationObject(mAppThread.asBinder());
            IActivityManager mgr = ActivityManagerNative.getDefault();
            try 
            {
                mgr.attachApplication(mAppThread);
            } //End block
            catch (RemoteException ex)
            {
            } //End block
        } //End block
        else
        {
            android.ddm.DdmHandleAppName.setAppName("system_process");
            try 
            {
                mInstrumentation = new Instrumentation();
                ContextImpl context = new ContextImpl();
                context.init(getSystemContext().mPackageInfo, null, this);
                Application app = Instrumentation.newApplication(Application.class, context);
                mAllApplications.add(app);
                mInitialApplication = app;
                app.onCreate();
            } //End block
            catch (Exception e)
            {
                RuntimeException varEEE3265923145F3B5B035C3648D6659E_2089168721 = new RuntimeException(
                        "Unable to instantiate Application():" + e.toString(), e);
                varEEE3265923145F3B5B035C3648D6659E_2089168721.addTaint(taint);
                throw varEEE3265923145F3B5B035C3648D6659E_2089168721;
            } //End block
        } //End block
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.587 -0400", hash_original_method = "26C6C7423624E1B7694397A08E8C6CD1", hash_generated_method = "98247B6283C866B4D7906172D78415B0")
        public void onConfigurationChanged(Configuration newConfig) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(newConfig.getTaint());
            synchronized
(mPackages)            {
    if(applyConfigurationToResourcesLocked(newConfig, null))                
                {
    if(mPendingConfiguration == null ||
                                mPendingConfiguration.isOtherSeqNewer(newConfig))                    
                    {
                        mPendingConfiguration = newConfig;
                        queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                    } //End block
                } //End block
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
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.589 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
        public void onLowMemory() {
            //DSFIXME:  CODE0009: Possible callback target function detected
            // ---------- Original Method ----------
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.590 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
        public void onTrimMemory(int level) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(level);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.593 -0400", hash_original_method = "2E14593B1AB1D9A91353E1BD8215A316", hash_generated_method = "AB5B7839BAFE74DD08F9B7A253C5F1FA")
    public final void installSystemProviders(List<ProviderInfo> providers) {
        addTaint(providers.getTaint());
    if(providers != null)        
        {
            installContentProviders(mInitialApplication, providers);
        } //End block
        // ---------- Original Method ----------
        //if (providers != null) {
            //installContentProviders(mInitialApplication, providers);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.596 -0400", hash_original_method = "A46DE63D351DE0CEA05BC700781E1C79", hash_generated_method = "084627C8B5C0C9EC525BF9A17C96F86A")
    public int getIntCoreSetting(String key, int defaultValue) {
        addTaint(defaultValue);
        addTaint(key.getTaint());
        synchronized
(mPackages)        {
    if(mCoreSettings != null)            
            {
                int varABAAC1E651B058D486233DFF92988220_1591142046 = (mCoreSettings.getInt(key, defaultValue));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705185197 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1705185197;
            } //End block
            else
            {
                int var16830A58E1E33A4163524366BA7B701B_1774166948 = (defaultValue);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954672317 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_954672317;
            } //End block
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.600 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.600 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.600 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.600 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "C00C2C61984260DF3B4937ADC46E8A7C")

        Bundle state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.601 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.601 -0400", hash_original_field = "05B8C74CBD96FBF2DE4C1A352702FBF4", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.601 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8772E5B00EE7781FE599C41013926102")

        Activity parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.601 -0400", hash_original_field = "6F8E7109EE5ADBADB311A9D0FBBBBC2D", hash_generated_field = "99A507AF2C301E2FF9994737D79275BB")

        String embeddedID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.601 -0400", hash_original_field = "C9A812088441D29B618CAF19775FDAA2", hash_generated_field = "2EF688309E753499C339EBE96926B7C3")

        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.602 -0400", hash_original_field = "D13C3F7BAED576768B11A714EF4D90E2", hash_generated_field = "5637B5D432947459416E03554347708E")

        boolean paused;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.602 -0400", hash_original_field = "F0A0BFE6BC7D2C58D2989034F83183E0", hash_generated_field = "B0899FB375A0A57065DA66B38777B6C0")

        boolean stopped;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.602 -0400", hash_original_field = "614AB218DE1950441B1407D6BB38AFE3", hash_generated_field = "5DCC7672BCF10641A46EAA548A687CD5")

        boolean hideForNow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.602 -0400", hash_original_field = "6D069C9B9BA8B31B534F29F6B998EB02", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.603 -0400", hash_original_field = "70155DDAAD08A53C67D84B831081C73C", hash_generated_field = "44F8DA58F1EEFDF22FCF6A1FED0376C3")

        Configuration createdConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.603 -0400", hash_original_field = "8585C121190575E017AD93490EC11357", hash_generated_field = "583CE8A57524BB39C7618CF1F2B65C96")

        ActivityClientRecord nextIdle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.603 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.604 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.604 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.604 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.604 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.605 -0400", hash_original_field = "FD5373273702F9470D1C201B33B812A0", hash_generated_field = "6FE708D4D9958EC105E3B69C43275F19")

        LoadedApk packageInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.605 -0400", hash_original_field = "3B0B9C6FBD20486E139A43FC64A202D9", hash_generated_field = "A77E9DD92A64C5F780B6000CA80182A2")

        List<ResultInfo> pendingResults;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.605 -0400", hash_original_field = "433CEFD43BB3E36958F4429303CFBDF2", hash_generated_field = "4BC30CA1B8786644C876DAF48F78533F")

        List<Intent> pendingIntents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.605 -0400", hash_original_field = "8C75492FB96D35639922DFCB4D489088", hash_generated_field = "5CE883BF4DAD47FBDAF4D2C3F7074402")

        boolean startsNotResumed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.606 -0400", hash_original_field = "4DFD186ABB3EB706F59F85400A376CE9", hash_generated_field = "8A03F39D432E8E43D36A30D2C65BF04B")

        boolean isForward;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.606 -0400", hash_original_field = "7771A08DD693060EE393D87DF30CF928", hash_generated_field = "2BC5D372006E004497C167DEE6104107")

        int pendingConfigChanges;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.606 -0400", hash_original_field = "97D2042DAB1F67D641A4735F0A59DDA4", hash_generated_field = "970B3D7A6F8A2CE63E822A10DBAD0F49")

        boolean onlyLocalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.607 -0400", hash_original_field = "FA6E167268326F793F40624DB64B3B41", hash_generated_field = "C7546AC98481F963F1798A1F44EE5004")

        View mPendingRemoveWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.607 -0400", hash_original_field = "A1EB5D2CF63EABFE576274089B0DEA1C", hash_generated_field = "651EDB05D2F89D6E111AFDE79ADF6A66")

        WindowManager mPendingRemoveWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.608 -0400", hash_original_method = "B5F524E6EAF79ED64F291F38DBCEDD1B", hash_generated_method = "1B05C37D3F960D6790EA6795720DC542")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.609 -0400", hash_original_method = "2761403398E750945AAB952EA69C6C0F", hash_generated_method = "16DDD3A1D8DD874D77F7FD232A313110")
        public boolean isPreHoneycomb() {
    if(activity != null)            
            {
                boolean varB9F78216D199BC802ED56B7ACEB5291B_1982671210 = (activity.getApplicationInfo().targetSdkVersion
                        < android.os.Build.VERSION_CODES.HONEYCOMB);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1603178862 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1603178862;
            } //End block
            boolean var68934A3E9455FA72420237EB05902327_191110602 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482445332 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482445332;
            // ---------- Original Method ----------
            //if (activity != null) {
                //return activity.getApplicationInfo().targetSdkVersion
                        //< android.os.Build.VERSION_CODES.HONEYCOMB;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.610 -0400", hash_original_method = "C4594DCD1E896B9BDB54D56E10F2B8EE", hash_generated_method = "98C02746171D522BCDAE2B4A5BB0966E")
        public String toString() {
            ComponentName componentName = intent.getComponent();
String var353164426B60C449C9FB36F3184CB614_1228016738 =             "ActivityRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " token=" + token + " " + (componentName == null
                        ? "no component name" : componentName.toShortString())
                + "}";
            var353164426B60C449C9FB36F3184CB614_1228016738.addTaint(taint);
            return var353164426B60C449C9FB36F3184CB614_1228016738;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.610 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

        String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.611 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "4165A1FBAFFD21863CC0EAC1937582F7")

        IContentProvider mProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.611 -0400", hash_original_field = "10F83DD9C72C654C184D34757393AB14", hash_generated_field = "7AAFFB6DED098E36BD02CC080B04AF7E")

        ContentProvider mLocalProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.613 -0400", hash_original_method = "C7097CC666CFF4D083C9B2045DB42E29", hash_generated_method = "DF4756A2C65B372E178D3BE3C4A53DC6")
          ProviderClientRecord(String name, IContentProvider provider,
                ContentProvider localProvider) {
            mName = name;
            mProvider = provider;
            mLocalProvider = localProvider;
            // ---------- Original Method ----------
            //mName = name;
            //mProvider = provider;
            //mLocalProvider = localProvider;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.614 -0400", hash_original_method = "3801456C44CFB93A5BA86A8AB8C43B3F", hash_generated_method = "B050BAB508FED40C5C7DDCB23C41347E")
        public void binderDied() {
            removeDeadProvider(mName, mProvider);
            // ---------- Original Method ----------
            //removeDeadProvider(mName, mProvider);
        }

        
    }


    
    static final class NewIntentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.617 -0400", hash_original_field = "99F399B171645B449364ED937DFD6F10", hash_generated_field = "DCC84A2BE9F90A98827B285408558812")

        List<Intent> intents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.618 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.618 -0400", hash_original_method = "9A9162E54721E56B9804FAED427417E2", hash_generated_method = "9A9162E54721E56B9804FAED427417E2")
        public NewIntentData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.619 -0400", hash_original_method = "E9F4DBEB4C72AFF7F672A47023D2DCCE", hash_generated_method = "9EC0EAD36F76A4B19CB161794B84EDA9")
        public String toString() {
String var029687FA3448A44CDE2ADF906A695CC0_1636833312 =             "NewIntentData{intents=" + intents + " token=" + token + "}";
            var029687FA3448A44CDE2ADF906A695CC0_1636833312.addTaint(taint);
            return var029687FA3448A44CDE2ADF906A695CC0_1636833312;
            // ---------- Original Method ----------
            //return "NewIntentData{intents=" + intents + " token=" + token + "}";
        }

        
    }


    
    static final class ReceiverData extends BroadcastReceiver.PendingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.620 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.620 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "D6562EB0A3FC9B94476A16D5F303F058")

        ActivityInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.621 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.623 -0400", hash_original_method = "95DC539EA4572F0714768317249686D3", hash_generated_method = "5F5EA5B5DB9BAC270C564AE64F897F98")
        public  ReceiverData(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                boolean ordered, boolean sticky, IBinder token) {
            super(resultCode, resultData, resultExtras, TYPE_COMPONENT, ordered, sticky, token);
            addTaint(token.getTaint());
            addTaint(sticky);
            addTaint(ordered);
            addTaint(resultExtras.getTaint());
            addTaint(resultData.getTaint());
            addTaint(resultCode);
            this.intent = intent;
            // ---------- Original Method ----------
            //this.intent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.624 -0400", hash_original_method = "062A80C4BE8CE608AA3884983AB20A02", hash_generated_method = "020BD17F67A19B659764FB4F86984070")
        public String toString() {
String var9047DF43E424C50B37419516DB534403_308207929 =             "ReceiverData{intent=" + intent + " packageName=" +
                    info.packageName + " resultCode=" + getResultCode()
                    + " resultData=" + getResultData() + " resultExtras="
                    + getResultExtras(false) + "}";
            var9047DF43E424C50B37419516DB534403_308207929.addTaint(taint);
            return var9047DF43E424C50B37419516DB534403_308207929;
            // ---------- Original Method ----------
            //return "ReceiverData{intent=" + intent + " packageName=" +
                    //info.packageName + " resultCode=" + getResultCode()
                    //+ " resultData=" + getResultData() + " resultExtras="
                    //+ getResultExtras(false) + "}";
        }

        
    }


    
    static final class CreateBackupAgentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.625 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.625 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.626 -0400", hash_original_field = "804191EFAC8137D8B58292EF386D75FA", hash_generated_field = "F90DF71BF48FAFE07F43CB879F966CE3")

        int backupMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.626 -0400", hash_original_method = "7F9A4ECF6FE623DBC230D640707CDFD0", hash_generated_method = "7F9A4ECF6FE623DBC230D640707CDFD0")
        public CreateBackupAgentData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.627 -0400", hash_original_method = "87705B4B5A78FEE0786C01D6E7384189", hash_generated_method = "0B1E9D946B87EE0D4B57BF6DC7A58DF3")
        public String toString() {
String var3809FCF9C80F8B464B87519839CF69D5_95959556 =             "CreateBackupAgentData{appInfo=" + appInfo
                    + " backupAgent=" + appInfo.backupAgentName
                    + " mode=" + backupMode + "}";
            var3809FCF9C80F8B464B87519839CF69D5_95959556.addTaint(taint);
            return var3809FCF9C80F8B464B87519839CF69D5_95959556;
            // ---------- Original Method ----------
            //return "CreateBackupAgentData{appInfo=" + appInfo
                    //+ " backupAgent=" + appInfo.backupAgentName
                    //+ " mode=" + backupMode + "}";
        }

        
    }


    
    static final class CreateServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.628 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.628 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "4AEE41877C99C71A9296A5C433E71F7C")

        ServiceInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.628 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.629 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.629 -0400", hash_original_method = "881257217964B643C1B29F21F8324D73", hash_generated_method = "881257217964B643C1B29F21F8324D73")
        public CreateServiceData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.630 -0400", hash_original_method = "DE656B2587EA58A3FB80D8944832AD3A", hash_generated_method = "0819B7B3074583A8D6E60ED7EDF32DA1")
        public String toString() {
String varE9AF178A10B71E9D8D557410DB685B76_330633255 =             "CreateServiceData{token=" + token + " className="
            + info.name + " packageName=" + info.packageName
            + " intent=" + intent + "}";
            varE9AF178A10B71E9D8D557410DB685B76_330633255.addTaint(taint);
            return varE9AF178A10B71E9D8D557410DB685B76_330633255;
            // ---------- Original Method ----------
            //return "CreateServiceData{token=" + token + " className="
            //+ info.name + " packageName=" + info.packageName
            //+ " intent=" + intent + "}";
        }

        
    }


    
    static final class BindServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.630 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.630 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.631 -0400", hash_original_field = "35DA50F034DA1C4AB0308E9228963716", hash_generated_field = "35FF113739960C8FEB167B42458B2109")

        boolean rebind;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.631 -0400", hash_original_method = "2B59A1695FBC674B2F74F0571D5E38A2", hash_generated_method = "2B59A1695FBC674B2F74F0571D5E38A2")
        public BindServiceData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.632 -0400", hash_original_method = "788B7BFDCE261467774852FF99962FB6", hash_generated_method = "0DAD5FF28DE2826EFDA90ADD8C6073B8")
        public String toString() {
String var9758559D535620B86E73D6C78BB1AC5E_420801010 =             "BindServiceData{token=" + token + " intent=" + intent + "}";
            var9758559D535620B86E73D6C78BB1AC5E_420801010.addTaint(taint);
            return var9758559D535620B86E73D6C78BB1AC5E_420801010;
            // ---------- Original Method ----------
            //return "BindServiceData{token=" + token + " intent=" + intent + "}";
        }

        
    }


    
    static final class ServiceArgsData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.633 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.634 -0400", hash_original_field = "18114AC9833DE9BE54FC2510379F9C46", hash_generated_field = "CB66DDA6D80EB80E88BF8636FFAE2527")

        boolean taskRemoved;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.634 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.634 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.635 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "77AB5E543174DF1F66D162C0382A930F")

        Intent args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.635 -0400", hash_original_method = "103D015CCE841E84C3050E807488FBE9", hash_generated_method = "103D015CCE841E84C3050E807488FBE9")
        public ServiceArgsData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.636 -0400", hash_original_method = "9123370A477925A90205ABBEEFE44004", hash_generated_method = "5217BCE848C3A13CBD6F6B3ACC6FD529")
        public String toString() {
String var19F02F31E296FD3DCC366394AD0A1D00_1901334367 =             "ServiceArgsData{token=" + token + " startId=" + startId
            + " args=" + args + "}";
            var19F02F31E296FD3DCC366394AD0A1D00_1901334367.addTaint(taint);
            return var19F02F31E296FD3DCC366394AD0A1D00_1901334367;
            // ---------- Original Method ----------
            //return "ServiceArgsData{token=" + token + " startId=" + startId
            //+ " args=" + args + "}";
        }

        
    }


    
    static final class AppBindData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.640 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFE674900E356A9F4BF51234744250B8")

        LoadedApk info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.641 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "182AC29DC74CEB0C6C89C5576E47A4DD")

        String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.641 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.642 -0400", hash_original_field = "29D247EE74C64366386D8D549C17162D", hash_generated_field = "7A9F4634EB01C0456156CF1B784BCEC9")

        List<ProviderInfo> providers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.642 -0400", hash_original_field = "B80C791FAFFB60831D70548CB5215902", hash_generated_field = "3F5DA88F1FEC15C88CB883D59573E813")

        ComponentName instrumentationName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.643 -0400", hash_original_field = "A787EF10308AF70C6A64332DCA7C8E51", hash_generated_field = "73077E024184109776339B9D1BEE35EB")

        Bundle instrumentationArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.643 -0400", hash_original_field = "4165C674FEE7A7791DA12B1AFD3117CF", hash_generated_field = "B075C237152068CFAEC1BD98818F5007")

        IInstrumentationWatcher instrumentationWatcher;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.643 -0400", hash_original_field = "48E635F7A84F2E705C3CC133792C2E42", hash_generated_field = "5FC68647D6D0CF439E6B829CC880890C")

        int debugMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.644 -0400", hash_original_field = "BA6ED9886C7F4DC26B56F7D1AD9427A4", hash_generated_field = "4EAC7CFAA88429E81A3DA1B88F7F0814")

        boolean restrictedBackupMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.644 -0400", hash_original_field = "23C6323BFB57BB630B8A2ECF703D6BB0", hash_generated_field = "B853B56DA62629292AFB975D2A443261")

        boolean persistent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.645 -0400", hash_original_field = "2245023265AE4CF87D02C8B6BA991139", hash_generated_field = "A3F5781DE6AF7A59A7DBAA1BECE272A9")

        Configuration config;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.645 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.646 -0400", hash_original_field = "03E5F42EE7352D707D8219D0B5A3A3D3", hash_generated_field = "DB4FDD2502B5FFC034FB83C77C56111F")

        String initProfileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.646 -0400", hash_original_field = "1A8CF268D8A31BBDEFA6FA16D91B0CEE", hash_generated_field = "D60C582964877A307BEAF4053762EF15")

        ParcelFileDescriptor initProfileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.647 -0400", hash_original_field = "56F3F00A970BDF076342D5A0780440E9", hash_generated_field = "2D2D69EB52002C7C4F13F0178D625E55")

        boolean initAutoStopProfiler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.647 -0400", hash_original_method = "EDE65A505FE77989B4B34B8F22E2D58F", hash_generated_method = "EDE65A505FE77989B4B34B8F22E2D58F")
        public AppBindData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.648 -0400", hash_original_method = "2BA8F6DB78683607CF1A79B96A9E1945", hash_generated_method = "858D939D091269EDE4C2FF4F31A6D669")
        public String toString() {
String var04B95099EE76729E362E7C6BCFADF6ED_157066112 =             "AppBindData{appInfo=" + appInfo + "}";
            var04B95099EE76729E362E7C6BCFADF6ED_157066112.addTaint(taint);
            return var04B95099EE76729E362E7C6BCFADF6ED_157066112;
            // ---------- Original Method ----------
            //return "AppBindData{appInfo=" + appInfo + "}";
        }

        
    }


    
    static final class Profiler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.649 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.649 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.649 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.649 -0400", hash_original_field = "3CDDA3E94E1B3DFD218A9D60B8139968", hash_generated_field = "5AEBAB31656E136FF8335BF7952CBD3D")

        boolean profiling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.650 -0400", hash_original_field = "F172439EC8EE2FA7210D2763CB835A33", hash_generated_field = "CFD51622CC9205EA276B9A72B7AC1389")

        boolean handlingProfiling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.650 -0400", hash_original_method = "7B9BEA1F6EC95E751CD548D4F51680C9", hash_generated_method = "7B9BEA1F6EC95E751CD548D4F51680C9")
        public Profiler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.651 -0400", hash_original_method = "A8A96BF1FCBE3854C04202513222077A", hash_generated_method = "51AF4EFD259434AF27D9AFA4B3C88A38")
        public void setProfiler(String file, ParcelFileDescriptor fd) {
    if(profiling)            
            {
    if(fd != null)                
                {
                    try 
                    {
                        fd.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                } //End block
                return;
            } //End block
    if(profileFd != null)            
            {
                try 
                {
                    profileFd.close();
                } //End block
                catch (IOException e)
                {
                } //End block
            } //End block
            profileFile = file;
            profileFd = fd;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.653 -0400", hash_original_method = "4BADC9424DA1A3AC7F9D5563006BCE42", hash_generated_method = "37EC444C5D4789F0D0FE66DAFF35C9DE")
        public void startProfiling() {
    if(profileFd == null || profiling)            
            {
                return;
            } //End block
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
                {
                } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.655 -0400", hash_original_method = "F0726A3E7708B3CB256CEACF5FA42FD5", hash_generated_method = "3EF4B8F58444E5F75F38E7B37AC022D0")
        public void stopProfiling() {
    if(profiling)            
            {
                profiling = false;
                Debug.stopMethodTracing();
    if(profileFd != null)                
                {
                    try 
                    {
                        profileFd.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.657 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.657 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.657 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

        String prefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.658 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "7F2C1FD08D9A857D4D2EDF6F9394FC1F")

        String[] args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.658 -0400", hash_original_method = "705FE87B3B944DB1E7088D167B1442FA", hash_generated_method = "705FE87B3B944DB1E7088D167B1442FA")
        public DumpComponentInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ResultData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.658 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.658 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "C3849EE0113C1C1730E99FB7C260DA4E")

        List<ResultInfo> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.659 -0400", hash_original_method = "3466C6D5CF0FEDF7456B3B9BA6367B40", hash_generated_method = "3466C6D5CF0FEDF7456B3B9BA6367B40")
        public ResultData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.659 -0400", hash_original_method = "BA3AA15664E126972C9E79255FFB7B3E", hash_generated_method = "B469E18E5D28D4A59EBAC1C782A22CD0")
        public String toString() {
String var0E2638BBD63C3DF853211506C164BD6C_522631608 =             "ResultData{token=" + token + " results" + results + "}";
            var0E2638BBD63C3DF853211506C164BD6C_522631608.addTaint(taint);
            return var0E2638BBD63C3DF853211506C164BD6C_522631608;
            // ---------- Original Method ----------
            //return "ResultData{token=" + token + " results" + results + "}";
        }

        
    }


    
    static final class ContextCleanupInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.660 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "C9CD4205E05705EAD2345480C07726F5")

        ContextImpl context;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.660 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "EA705FF509AF2D1BE17CB07841038A94")

        String what;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.660 -0400", hash_original_field = "53D670AF9BB16EA82E7EF41EE23EC6DF", hash_generated_field = "C4E3E8F459E3F192A7BA9767B8092770")

        String who;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.661 -0400", hash_original_method = "1364E4E916202312196441F2CD1A38A7", hash_generated_method = "1364E4E916202312196441F2CD1A38A7")
        public ContextCleanupInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ProfilerControlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.661 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.661 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.662 -0400", hash_original_method = "D11C2D1935BF651482EE891D2A926235", hash_generated_method = "D11C2D1935BF651482EE891D2A926235")
        public ProfilerControlData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class DumpHeapData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.663 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.663 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.664 -0400", hash_original_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F", hash_generated_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F")
        public DumpHeapData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class UpdateCompatibilityData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.664 -0400", hash_original_field = "A46A1BCE0B67C45BEC8F435BD5390A54", hash_generated_field = "742D0CCB1EAA4E727F9FCD5430AF1837")

        String pkg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.665 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "F50EE04D1F33A8C52E6957011343491C")

        CompatibilityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.665 -0400", hash_original_method = "20ABF4B3D5332D1381C869593F335293", hash_generated_method = "20ABF4B3D5332D1381C869593F335293")
        public UpdateCompatibilityData ()
        {
            //Synthesized constructor
        }


    }


    
    private class ApplicationThread extends ApplicationThreadNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.666 -0400", hash_original_method = "1FF8F0D2A8FB58C213C16741C12E71C3", hash_generated_method = "1FF8F0D2A8FB58C213C16741C12E71C3")
        public ApplicationThread ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.668 -0400", hash_original_method = "FEE93A296AD85C197E1C80A7E47B6BFE", hash_generated_method = "76ACC06F0B36C43F45E75CF0BFD12BC0")
        private void updatePendingConfiguration(Configuration config) {
            addTaint(config.getTaint());
            synchronized
(mPackages)            {
    if(mPendingConfiguration == null ||
                        mPendingConfiguration.isOtherSeqNewer(config))                
                {
                    mPendingConfiguration = config;
                } //End block
            } //End block
            // ---------- Original Method ----------
            //synchronized (mPackages) {
                //if (mPendingConfiguration == null ||
                        //mPendingConfiguration.isOtherSeqNewer(config)) {
                    //mPendingConfiguration = config;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.670 -0400", hash_original_method = "BA274F1A18F5196BF92F19261941182B", hash_generated_method = "FF7390FD4ECDB2685A9E4418F7F7E679")
        public final void schedulePauseActivity(IBinder token, boolean finished,
                boolean userLeaving, int configChanges) {
            addTaint(configChanges);
            addTaint(userLeaving);
            addTaint(finished);
            addTaint(token.getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.671 -0400", hash_original_method = "6237E07FCE9BDD69A8A6118FB4C5EAB5", hash_generated_method = "66AA1DD1C9EE2C22C5A79AD7DDC767B6")
        public final void scheduleStopActivity(IBinder token, boolean showWindow,
                int configChanges) {
            addTaint(configChanges);
            addTaint(showWindow);
            addTaint(token.getTaint());
            queueOrSendMessage(
                showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                token, 0, configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                //token, 0, configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.672 -0400", hash_original_method = "07304A552CCDBF618EE7F08FE12E8569", hash_generated_method = "CFA65A6060676EDB430F00C3232709E1")
        public final void scheduleWindowVisibility(IBinder token, boolean showWindow) {
            addTaint(showWindow);
            addTaint(token.getTaint());
            queueOrSendMessage(
                showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                token);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                //token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.674 -0400", hash_original_method = "28F90EA3762C8F9BC8352F7DED192FAC", hash_generated_method = "9FE61D77A92E98458D09ABF3E8283B76")
        public final void scheduleSleeping(IBinder token, boolean sleeping) {
            addTaint(sleeping);
            addTaint(token.getTaint());
            queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.675 -0400", hash_original_method = "8E946102D354A83096F7BBE33573DD97", hash_generated_method = "BEFE10D18D21D45B461BACE736C27A53")
        public final void scheduleResumeActivity(IBinder token, boolean isForward) {
            addTaint(isForward);
            addTaint(token.getTaint());
            queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.676 -0400", hash_original_method = "C9516E754F864B61E9DED08AC69D1433", hash_generated_method = "F59F6938F2D70F53AEBB4F0E122F1B88")
        public final void scheduleSendResult(IBinder token, List<ResultInfo> results) {
            addTaint(results.getTaint());
            addTaint(token.getTaint());
            ResultData res = new ResultData();
            res.token = token;
            res.results = results;
            queueOrSendMessage(H.SEND_RESULT, res);
            // ---------- Original Method ----------
            //ResultData res = new ResultData();
            //res.token = token;
            //res.results = results;
            //queueOrSendMessage(H.SEND_RESULT, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.684 -0400", hash_original_method = "A45BCC7C8AC3E4C6E98525A537822FA1", hash_generated_method = "8C96694155D44352BCF603BFCD88BB87")
        public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
                ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
                Bundle state, List<ResultInfo> pendingResults,
                List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
                String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) {
            addTaint(autoStopProfiler);
            addTaint(profileFd.getTaint());
            addTaint(profileName.getTaint());
            addTaint(isForward);
            addTaint(notResumed);
            addTaint(pendingNewIntents.getTaint());
            addTaint(pendingResults.getTaint());
            addTaint(state.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(curConfig.getTaint());
            addTaint(info.getTaint());
            addTaint(ident);
            addTaint(token.getTaint());
            addTaint(intent.getTaint());
            ActivityClientRecord r = new ActivityClientRecord();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.685 -0400", hash_original_method = "7F2AB124E5633740D7D94B2A109EF885", hash_generated_method = "D5DB3C2871309C30E0E8C517A325CD7A")
        public final void scheduleRelaunchActivity(IBinder token,
                List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
                int configChanges, boolean notResumed, Configuration config) {
            addTaint(config.getTaint());
            addTaint(notResumed);
            addTaint(configChanges);
            addTaint(pendingNewIntents.getTaint());
            addTaint(pendingResults.getTaint());
            addTaint(token.getTaint());
            requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    configChanges, notResumed, config, true);
            // ---------- Original Method ----------
            //requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    //configChanges, notResumed, config, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.687 -0400", hash_original_method = "821027AAA00C536539A4B7071BFFE4C0", hash_generated_method = "85C8FA5ADD025EE10BC1513EE4E0B271")
        public final void scheduleNewIntent(List<Intent> intents, IBinder token) {
            addTaint(token.getTaint());
            addTaint(intents.getTaint());
            NewIntentData data = new NewIntentData();
            data.intents = intents;
            data.token = token;
            queueOrSendMessage(H.NEW_INTENT, data);
            // ---------- Original Method ----------
            //NewIntentData data = new NewIntentData();
            //data.intents = intents;
            //data.token = token;
            //queueOrSendMessage(H.NEW_INTENT, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.691 -0400", hash_original_method = "09A2B20C75657E983740D1D57867F853", hash_generated_method = "D04B501AE442636EA5CF01D29DAE177D")
        public final void scheduleDestroyActivity(IBinder token, boolean finishing,
                int configChanges) {
            addTaint(configChanges);
            addTaint(finishing);
            addTaint(token.getTaint());
            queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    //configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.695 -0400", hash_original_method = "F17AEB980BE0F6A4E87F430078BD0B58", hash_generated_method = "4529350361FE68C754C014BF5B42FACA")
        public final void scheduleReceiver(Intent intent, ActivityInfo info,
                CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras,
                boolean sync) {
            addTaint(sync);
            addTaint(extras.getTaint());
            addTaint(data.getTaint());
            addTaint(resultCode);
            addTaint(compatInfo.getTaint());
            addTaint(info.getTaint());
            addTaint(intent.getTaint());
            ReceiverData r = new ReceiverData(intent, resultCode, data, extras,
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.697 -0400", hash_original_method = "5FA1669C7C775884F96F1A035B24EE01", hash_generated_method = "105DA8574C9A47815140FD35B367FC95")
        public final void scheduleCreateBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo, int backupMode) {
            addTaint(backupMode);
            addTaint(compatInfo.getTaint());
            addTaint(app.getTaint());
            CreateBackupAgentData d = new CreateBackupAgentData();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.698 -0400", hash_original_method = "313CE24EB5C5C4A7E872620C7BAF7637", hash_generated_method = "16AEF2352918D09B743D57BEE7C75ECB")
        public final void scheduleDestroyBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo) {
            addTaint(compatInfo.getTaint());
            addTaint(app.getTaint());
            CreateBackupAgentData d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
            // ---------- Original Method ----------
            //CreateBackupAgentData d = new CreateBackupAgentData();
            //d.appInfo = app;
            //d.compatInfo = compatInfo;
            //queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.700 -0400", hash_original_method = "304266FFC85B0A8F15B84D2439555071", hash_generated_method = "8974A6B1095E2265569C6EDD58E05BC9")
        public final void scheduleCreateService(IBinder token,
                ServiceInfo info, CompatibilityInfo compatInfo) {
            addTaint(compatInfo.getTaint());
            addTaint(info.getTaint());
            addTaint(token.getTaint());
            CreateServiceData s = new CreateServiceData();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.702 -0400", hash_original_method = "EC87D949C3428DDE1DD75260E89A91E6", hash_generated_method = "0F46448146084DF0A48253BB6B15EAD3")
        public final void scheduleBindService(IBinder token, Intent intent,
                boolean rebind) {
            addTaint(rebind);
            addTaint(intent.getTaint());
            addTaint(token.getTaint());
            BindServiceData s = new BindServiceData();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.704 -0400", hash_original_method = "267A066D9D2EC1A97646FF118EBD56F3", hash_generated_method = "9843EAA00159F5B9025BCC662D5F34AD")
        public final void scheduleUnbindService(IBinder token, Intent intent) {
            addTaint(intent.getTaint());
            addTaint(token.getTaint());
            BindServiceData s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            queueOrSendMessage(H.UNBIND_SERVICE, s);
            // ---------- Original Method ----------
            //BindServiceData s = new BindServiceData();
            //s.token = token;
            //s.intent = intent;
            //queueOrSendMessage(H.UNBIND_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.711 -0400", hash_original_method = "4862A31D82FA9B63D38F69A2AB095DD2", hash_generated_method = "6BA1A2E44412FD9EEFA33C46C75E2693")
        public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
            int flags ,Intent args) {
            addTaint(args.getTaint());
            addTaint(flags);
            addTaint(startId);
            addTaint(taskRemoved);
            addTaint(token.getTaint());
            ServiceArgsData s = new ServiceArgsData();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.712 -0400", hash_original_method = "1A677B6A32C3D13D1D29F012CCC3FAD3", hash_generated_method = "5F061C96303B8FAA402E9CA3B678A983")
        public final void scheduleStopService(IBinder token) {
            addTaint(token.getTaint());
            queueOrSendMessage(H.STOP_SERVICE, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.STOP_SERVICE, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.719 -0400", hash_original_method = "7F787E48DA5312BFEADE988209BA97C7", hash_generated_method = "19BC713C15A2EFF45AAD13E9CCEC2A66")
        public final void bindApplication(String processName,
                ApplicationInfo appInfo, List<ProviderInfo> providers,
                ComponentName instrumentationName, String profileFile,
                ParcelFileDescriptor profileFd, boolean autoStopProfiler,
                Bundle instrumentationArgs, IInstrumentationWatcher instrumentationWatcher,
                int debugMode, boolean isRestrictedBackupMode, boolean persistent,
                Configuration config, CompatibilityInfo compatInfo,
                Map<String, IBinder> services, Bundle coreSettings) {
            addTaint(coreSettings.getTaint());
            addTaint(services.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(config.getTaint());
            addTaint(persistent);
            addTaint(isRestrictedBackupMode);
            addTaint(debugMode);
            addTaint(instrumentationWatcher.getTaint());
            addTaint(instrumentationArgs.getTaint());
            addTaint(autoStopProfiler);
            addTaint(profileFd.getTaint());
            addTaint(profileFile.getTaint());
            addTaint(instrumentationName.getTaint());
            addTaint(providers.getTaint());
            addTaint(appInfo.getTaint());
            addTaint(processName.getTaint());
    if(services != null)            
            {
                ServiceManager.initServiceCache(services);
            } //End block
            setCoreSettings(coreSettings);
            AppBindData data = new AppBindData();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.721 -0400", hash_original_method = "8F2CF4412C4F9594CB0F284CDA41289F", hash_generated_method = "FD95F1744B2DADE0E6256342E369D342")
        public final void scheduleExit() {
            queueOrSendMessage(H.EXIT_APPLICATION, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.EXIT_APPLICATION, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.722 -0400", hash_original_method = "B20E9F159FCFB18DA16F9E3A94AEF27F", hash_generated_method = "FCFDDF7AD8124B805F52430959A87E50")
        public final void scheduleSuicide() {
            queueOrSendMessage(H.SUICIDE, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SUICIDE, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.725 -0400", hash_original_method = "6202A73E0682C5A75E75C022AC3B402A", hash_generated_method = "0E871D198BD360CD542A8D2D1BF6DEA9")
        public void requestThumbnail(IBinder token) {
            addTaint(token.getTaint());
            queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.726 -0400", hash_original_method = "06772B0545F1E3E199A400C07A7C465B", hash_generated_method = "9BCE070C07BDE164F84C1F968B035BB0")
        public void scheduleConfigurationChanged(Configuration config) {
            addTaint(config.getTaint());
            updatePendingConfiguration(config);
            queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
            // ---------- Original Method ----------
            //updatePendingConfiguration(config);
            //queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.727 -0400", hash_original_method = "691E3B4CEF6237A9A1AE3434E3DEDEFF", hash_generated_method = "B8C95D80E84F89DC0BEDC85471A2F2D3")
        public void updateTimeZone() {
            TimeZone.setDefault(null);
            // ---------- Original Method ----------
            //TimeZone.setDefault(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.728 -0400", hash_original_method = "38B626EB423003E8CAF0F1407CD9E9A9", hash_generated_method = "4A28A43D9782A661EAF6F85250AF0D6F")
        public void clearDnsCache() {
            InetAddress.clearDnsCache();
            // ---------- Original Method ----------
            //InetAddress.clearDnsCache();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.729 -0400", hash_original_method = "B8887413EF343DBD56A367F4C57F614A", hash_generated_method = "1FFEDF48E01C28AED910CF2C3072781E")
        public void setHttpProxy(String host, String port, String exclList) {
            addTaint(exclList.getTaint());
            addTaint(port.getTaint());
            addTaint(host.getTaint());
            Proxy.setHttpProxySystemProperty(host, port, exclList);
            // ---------- Original Method ----------
            //Proxy.setHttpProxySystemProperty(host, port, exclList);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.732 -0400", hash_original_method = "66F6EAD39814B9A04B7952BBDB099BC9", hash_generated_method = "572139B122FBBA71F49FE015C971C791")
        public void processInBackground() {
            mH.removeMessages(H.GC_WHEN_IDLE);
            mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
            // ---------- Original Method ----------
            //mH.removeMessages(H.GC_WHEN_IDLE);
            //mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.734 -0400", hash_original_method = "876C8E0D071CEA83F82D96AA48344FA4", hash_generated_method = "5B3FFC679D888CC80E158FC9F6EB1880")
        public void dumpService(FileDescriptor fd, IBinder servicetoken, String[] args) {
            addTaint(args[0].getTaint());
            addTaint(servicetoken.getTaint());
            addTaint(fd.getTaint());
            DumpComponentInfo data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = servicetoken;
                data.args = args;
                queueOrSendMessage(H.DUMP_SERVICE, data);
            } //End block
            catch (IOException e)
            {
            } //End block
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

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.735 -0400", hash_original_method = "0E238081C4996703A2EA0540C6977CE0", hash_generated_method = "04C1ACD7C21C57F18695ED537721D2B7")
        public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
                int resultCode, String dataStr, Bundle extras, boolean ordered,
                boolean sticky) throws RemoteException {
            addTaint(sticky);
            addTaint(ordered);
            addTaint(extras.getTaint());
            addTaint(dataStr.getTaint());
            addTaint(resultCode);
            addTaint(intent.getTaint());
            addTaint(receiver.getTaint());
            receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
            // ---------- Original Method ----------
            //receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.736 -0400", hash_original_method = "1CA11DE4169634D3536C3A5288820C11", hash_generated_method = "C0AEC8819655C2E24AF50FB99520B4E3")
        public void scheduleLowMemory() {
            queueOrSendMessage(H.LOW_MEMORY, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.LOW_MEMORY, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.736 -0400", hash_original_method = "1503BAA815C894047387C37D52FE75DC", hash_generated_method = "C9F1D830309E43E012418369F84F0A7F")
        public void scheduleActivityConfigurationChanged(IBinder token) {
            addTaint(token.getTaint());
            queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.737 -0400", hash_original_method = "D92E635329F77F60C61D4CBABCC9E0E5", hash_generated_method = "2EE80ACF76983FE4A3479B022F4581B9")
        public void profilerControl(boolean start, String path, ParcelFileDescriptor fd,
                int profileType) {
            addTaint(profileType);
            addTaint(fd.getTaint());
            addTaint(path.getTaint());
            addTaint(start);
            ProfilerControlData pcd = new ProfilerControlData();
            pcd.path = path;
            pcd.fd = fd;
            queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
            // ---------- Original Method ----------
            //ProfilerControlData pcd = new ProfilerControlData();
            //pcd.path = path;
            //pcd.fd = fd;
            //queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.739 -0400", hash_original_method = "E2AA43C341E3E1223DC4327679137F86", hash_generated_method = "048784B587B600571D8E5D2F7F720258")
        public void dumpHeap(boolean managed, String path, ParcelFileDescriptor fd) {
            addTaint(fd.getTaint());
            addTaint(path.getTaint());
            addTaint(managed);
            DumpHeapData dhd = new DumpHeapData();
            dhd.path = path;
            dhd.fd = fd;
            queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
            // ---------- Original Method ----------
            //DumpHeapData dhd = new DumpHeapData();
            //dhd.path = path;
            //dhd.fd = fd;
            //queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.743 -0400", hash_original_method = "31DFA590CF69650795082863A4038E1E", hash_generated_method = "738B573B4053C25E676231126780C34C")
        public void setSchedulingGroup(int group) {
            addTaint(group);
            try 
            {
                Process.setProcessGroup(Process.myPid(), group);
            } //End block
            catch (Exception e)
            {
            } //End block
            // ---------- Original Method ----------
            //try {
                //Process.setProcessGroup(Process.myPid(), group);
            //} catch (Exception e) {
                //Slog.w(TAG, "Failed setting process group to " + group, e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.744 -0400", hash_original_method = "7CB15E6FC063BB1B6B4AEB944EE130EF", hash_generated_method = "1A9052625396703ADBDD03342F970566")
        public void getMemoryInfo(Debug.MemoryInfo outInfo) {
            addTaint(outInfo.getTaint());
            Debug.getMemoryInfo(outInfo);
            // ---------- Original Method ----------
            //Debug.getMemoryInfo(outInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.745 -0400", hash_original_method = "779EC3818AE8FA9E2AC523D128FB5D87", hash_generated_method = "72C126391FB8A836D855FBE2B2DBC3E3")
        public void dispatchPackageBroadcast(int cmd, String[] packages) {
            addTaint(packages[0].getTaint());
            addTaint(cmd);
            queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.747 -0400", hash_original_method = "E0613CA49761C406F1CB17CB9D000972", hash_generated_method = "0A121DE00DA5D31CCF41B98E4CBDB8E5")
        public void scheduleCrash(String msg) {
            addTaint(msg.getTaint());
            queueOrSendMessage(H.SCHEDULE_CRASH, msg);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SCHEDULE_CRASH, msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.750 -0400", hash_original_method = "D7BE3A9B3D448EC9431A34B711555765", hash_generated_method = "E9B9B46C875734C500C8099354060A1A")
        public void dumpActivity(FileDescriptor fd, IBinder activitytoken,
                String prefix, String[] args) {
            addTaint(args[0].getTaint());
            addTaint(prefix.getTaint());
            addTaint(activitytoken.getTaint());
            addTaint(fd.getTaint());
            DumpComponentInfo data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = activitytoken;
                data.prefix = prefix;
                data.args = args;
                queueOrSendMessage(H.DUMP_ACTIVITY, data);
            } //End block
            catch (IOException e)
            {
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.751 -0400", hash_original_method = "648F3C65CFB469E019D9747F832AE1E8", hash_generated_method = "E34FEF4EF630093DC121733200DF9902")
        @Override
        public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin,
                boolean all, String[] args) {
            addTaint(args[0].getTaint());
            addTaint(all);
            addTaint(checkin);
            addTaint(fd.getTaint());
            FileOutputStream fout = new FileOutputStream(fd);
            PrintWriter pw = new PrintWriter(fout);
            try 
            {
Debug.MemoryInfo var7DAD20EFC9BAD77DE8595EF4274FBC5D_2006570 =                 dumpMemInfo(pw, checkin, all, args);
                var7DAD20EFC9BAD77DE8595EF4274FBC5D_2006570.addTaint(taint);
                return var7DAD20EFC9BAD77DE8595EF4274FBC5D_2006570;
            } //End block
            finally 
            {
                pw.flush();
            } //End block
            // ---------- Original Method ----------
            //FileOutputStream fout = new FileOutputStream(fd);
            //PrintWriter pw = new PrintWriter(fout);
            //try {
                //return dumpMemInfo(pw, checkin, all, args);
            //} finally {
                //pw.flush();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.756 -0400", hash_original_method = "468180529DE63D6D9E6979D7BD66773F", hash_generated_method = "D6A3202F5781CA3A66C7D66927DE4A8C")
        private Debug.MemoryInfo dumpMemInfo(PrintWriter pw, boolean checkin, boolean all,
                String[] args) {
            addTaint(args[0].getTaint());
            addTaint(all);
            addTaint(checkin);
            addTaint(pw.getTaint());
            long nativeMax = Debug.getNativeHeapSize() / 1024;
            long nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeFree = Debug.getNativeHeapFreeSize() / 1024;
            Debug.MemoryInfo memInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memInfo);
    if(!all)            
            {
Debug.MemoryInfo varCA75B7F9315593DF42E4A3048479A54C_1063894753 =                 memInfo;
                varCA75B7F9315593DF42E4A3048479A54C_1063894753.addTaint(taint);
                return varCA75B7F9315593DF42E4A3048479A54C_1063894753;
            } //End block
            Runtime runtime = Runtime.getRuntime();
            long dalvikMax = runtime.totalMemory() / 1024;
            long dalvikFree = runtime.freeMemory() / 1024;
            long dalvikAllocated = dalvikMax - dalvikFree;
            long viewInstanceCount = ViewDebug.getViewInstanceCount();
            long viewRootInstanceCount = ViewDebug.getViewRootImplCount();
            long appContextInstanceCount = Debug.countInstancesOfClass(ContextImpl.class);
            long activityInstanceCount = Debug.countInstancesOfClass(Activity.class);
            int globalAssetCount = AssetManager.getGlobalAssetCount();
            int globalAssetManagerCount = AssetManager.getGlobalAssetManagerCount();
            int binderLocalObjectCount = Debug.getBinderLocalObjectCount();
            int binderProxyObjectCount = Debug.getBinderProxyObjectCount();
            int binderDeathObjectCount = Debug.getBinderDeathObjectCount();
            long openSslSocketCount = Debug.countInstancesOfClass(OpenSSLSocketImpl.class);
            long sqliteAllocated = SQLiteDebug.getHeapAllocatedSize() / 1024;
            SQLiteDebug.PagerStats stats = SQLiteDebug.getDatabaseInfo();
    if(checkin)            
            {
                String processName = (mBoundApplication != null)
                        ? mBoundApplication.processName : "unknown";
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
for(int i = 0;i < stats.dbStats.size();i++)
                {
                    DbStats dbStats = stats.dbStats.get(i);
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
                pw.println();
Debug.MemoryInfo varCA75B7F9315593DF42E4A3048479A54C_625849723 =                 memInfo;
                varCA75B7F9315593DF42E4A3048479A54C_625849723.addTaint(taint);
                return varCA75B7F9315593DF42E4A3048479A54C_625849723;
            } //End block
            printRow(pw, HEAP_COLUMN, "", "", "Shared", "Private", "Heap", "Heap", "Heap");
            printRow(pw, HEAP_COLUMN, "", "Pss", "Dirty", "Dirty", "Size", "Alloc", "Free");
            printRow(pw, HEAP_COLUMN, "", "------", "------", "------", "------", "------",
                    "------");
            printRow(pw, HEAP_COLUMN, "Native", memInfo.nativePss, memInfo.nativeSharedDirty,
                    memInfo.nativePrivateDirty, nativeMax, nativeAllocated, nativeFree);
            printRow(pw, HEAP_COLUMN, "Dalvik", memInfo.dalvikPss, memInfo.dalvikSharedDirty,
                    memInfo.dalvikPrivateDirty, dalvikMax, dalvikAllocated, dalvikFree);
            int otherPss = memInfo.otherPss;
            int otherSharedDirty = memInfo.otherSharedDirty;
            int otherPrivateDirty = memInfo.otherPrivateDirty;
for(int i=0;i<Debug.MemoryInfo.NUM_OTHER_STATS;i++)
            {
                printRow(pw, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i),
                        memInfo.getOtherPss(i), memInfo.getOtherSharedDirty(i),
                        memInfo.getOtherPrivateDirty(i), "", "", "");
                otherPss -= memInfo.getOtherPss(i);
                otherSharedDirty -= memInfo.getOtherSharedDirty(i);
                otherPrivateDirty -= memInfo.getOtherPrivateDirty(i);
            } //End block
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
            int N = stats.dbStats.size();
    if(N > 0)            
            {
                pw.println(" DATABASES");
                printRow(pw, "  %8s %8s %14s %14s  %s", "pgsz", "dbsz", "Lookaside(b)", "cache",
                        "Dbname");
for(int i = 0;i < N;i++)
                {
                    DbStats dbStats = stats.dbStats.get(i);
                    printRow(pw, DB_INFO_FORMAT,
                            (dbStats.pageSize > 0) ? String.valueOf(dbStats.pageSize) : " ",
                            (dbStats.dbSize > 0) ? String.valueOf(dbStats.dbSize) : " ",
                            (dbStats.lookaside > 0) ? String.valueOf(dbStats.lookaside) : " ",
                            dbStats.cache, dbStats.dbName);
                } //End block
            } //End block
            String assetAlloc = AssetManager.getAssetAllocations();
    if(assetAlloc != null)            
            {
                pw.println(" ");
                pw.println(" Asset Allocations");
                pw.print(assetAlloc);
            } //End block
Debug.MemoryInfo varCA75B7F9315593DF42E4A3048479A54C_354802373 =             memInfo;
            varCA75B7F9315593DF42E4A3048479A54C_354802373.addTaint(taint);
            return varCA75B7F9315593DF42E4A3048479A54C_354802373;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.759 -0400", hash_original_method = "DBE19F37C980DCB637B8E3CCE0C6D7AE", hash_generated_method = "8741EF0148ED5E9B5AFA482A7C4B833D")
        @Override
        public void dumpGfxInfo(FileDescriptor fd, String[] args) {
            addTaint(args[0].getTaint());
            addTaint(fd.getTaint());
            dumpGraphicsInfo(fd);
            WindowManagerImpl.getDefault().dumpGfxInfo(fd);
            // ---------- Original Method ----------
            //dumpGraphicsInfo(fd);
            //WindowManagerImpl.getDefault().dumpGfxInfo(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.760 -0400", hash_original_method = "E9FD23CC6BA5457F811332501D367E07", hash_generated_method = "D520CB903A65AA7B98B60573F3289943")
        private void printRow(PrintWriter pw, String format, Object...objs) {
            addTaint(objs[0].getTaint());
            addTaint(format.getTaint());
            addTaint(pw.getTaint());
            pw.println(String.format(format, objs));
            // ---------- Original Method ----------
            //pw.println(String.format(format, objs));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.760 -0400", hash_original_method = "5D81A3C132332FC039C36D652A159D52", hash_generated_method = "20D3A50F0E9D661A9EA5F53B06B6558B")
        public void setCoreSettings(Bundle coreSettings) {
            addTaint(coreSettings.getTaint());
            queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.761 -0400", hash_original_method = "915F19E7DF7511DDBDEE0EA8781AD484", hash_generated_method = "5BB8A968A701734A66E87201C6477144")
        public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) {
            addTaint(info.getTaint());
            addTaint(pkg.getTaint());
            UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            ucd.pkg = pkg;
            ucd.info = info;
            queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
            // ---------- Original Method ----------
            //UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            //ucd.pkg = pkg;
            //ucd.info = info;
            //queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.762 -0400", hash_original_method = "713723E30DD42F550C53D06876722D4F", hash_generated_method = "6C6AE1EC1D1EFB86095B77C0510FAF8D")
        public void scheduleTrimMemory(int level) {
            addTaint(level);
            queueOrSendMessage(H.TRIM_MEMORY, null, level);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.TRIM_MEMORY, null, level);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.870 -0400", hash_original_field = "DB018D420C41A3AA31DB7A5C0D61BF49", hash_generated_field = "96FE4DE896DA8140237FE2F2A32AB60D")

        private static final String HEAP_COLUMN = "%13s %8s %8s %8s %8s %8s %8s";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.888 -0400", hash_original_field = "8C67A7F03B15ABF12A0BF8AF99E82E57", hash_generated_field = "8E20BB4B613E1B8E1B2DA12DB50E69D3")

        private static final String ONE_COUNT_COLUMN = "%21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.889 -0400", hash_original_field = "22778F00F1A90EFFD754BBAB24439FEA", hash_generated_field = "6CEAA9CA3D9ACF8FFD77880F59229D13")

        private static final String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.889 -0400", hash_original_field = "21567A713D1BAFE64C7E61BD2868538A", hash_generated_field = "E1986AF9DD2AA88B111C4B08C267AB55")

        private static final String TWO_COUNT_COLUMNS_DB = "%21s %8d %21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.910 -0400", hash_original_field = "EFC99A6ACAB1774B303D5BBEBCE82329", hash_generated_field = "F260B277CED6BCEF639DFFBC60FBBB27")

        private static final String DB_INFO_FORMAT = "  %8s %8s %14s %14s  %s";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.912 -0400", hash_original_field = "FFC3E978BB0A535AB4D65ADF77410A56", hash_generated_field = "A616DB8304B25BAEBD73BFE313E4CC76")

        private static final int ACTIVITY_THREAD_CHECKIN_VERSION = 1;
    }


    
    private class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.767 -0400", hash_original_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5", hash_generated_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5")
        public H ()
        {
            //Synthesized constructor
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.773 -0400", hash_original_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C", hash_generated_method = "5291B9ACFCFA90845F6D2A8F69F0FF1A")
         String codeToString(int code) {
            addTaint(code);
    if(DEBUG_MESSAGES)            
            {
switch(code){
                case LAUNCH_ACTIVITY:
String varC3A9631E305EF7F704A0535ADE9AB209_147360216 =                 "LAUNCH_ACTIVITY";
                varC3A9631E305EF7F704A0535ADE9AB209_147360216.addTaint(taint);
                return varC3A9631E305EF7F704A0535ADE9AB209_147360216;
                case PAUSE_ACTIVITY:
String var13FE960985BEA357B874C8BA8147F59B_1658557486 =                 "PAUSE_ACTIVITY";
                var13FE960985BEA357B874C8BA8147F59B_1658557486.addTaint(taint);
                return var13FE960985BEA357B874C8BA8147F59B_1658557486;
                case PAUSE_ACTIVITY_FINISHING:
String var35DAD969B21ECACCD5954778B1FCE2CA_729058034 =                 "PAUSE_ACTIVITY_FINISHING";
                var35DAD969B21ECACCD5954778B1FCE2CA_729058034.addTaint(taint);
                return var35DAD969B21ECACCD5954778B1FCE2CA_729058034;
                case STOP_ACTIVITY_SHOW:
String var17AACA1A811371E9D06F27381C281C09_931466244 =                 "STOP_ACTIVITY_SHOW";
                var17AACA1A811371E9D06F27381C281C09_931466244.addTaint(taint);
                return var17AACA1A811371E9D06F27381C281C09_931466244;
                case STOP_ACTIVITY_HIDE:
String var40AF0B6C8414E8C671AD0061B7C3F3CA_316287512 =                 "STOP_ACTIVITY_HIDE";
                var40AF0B6C8414E8C671AD0061B7C3F3CA_316287512.addTaint(taint);
                return var40AF0B6C8414E8C671AD0061B7C3F3CA_316287512;
                case SHOW_WINDOW:
String var72774A012C6A7F71377924BD46223730_1084646573 =                 "SHOW_WINDOW";
                var72774A012C6A7F71377924BD46223730_1084646573.addTaint(taint);
                return var72774A012C6A7F71377924BD46223730_1084646573;
                case HIDE_WINDOW:
String var7C8A3FA01DF4EAB22109A3AE1145669C_2041086768 =                 "HIDE_WINDOW";
                var7C8A3FA01DF4EAB22109A3AE1145669C_2041086768.addTaint(taint);
                return var7C8A3FA01DF4EAB22109A3AE1145669C_2041086768;
                case RESUME_ACTIVITY:
String var3F0D0E55D7160207B6C4FA6E46E6AFA7_273936402 =                 "RESUME_ACTIVITY";
                var3F0D0E55D7160207B6C4FA6E46E6AFA7_273936402.addTaint(taint);
                return var3F0D0E55D7160207B6C4FA6E46E6AFA7_273936402;
                case SEND_RESULT:
String varD34D7E1F17B91F5721A9267943F4D915_1397864377 =                 "SEND_RESULT";
                varD34D7E1F17B91F5721A9267943F4D915_1397864377.addTaint(taint);
                return varD34D7E1F17B91F5721A9267943F4D915_1397864377;
                case DESTROY_ACTIVITY:
String varBC98996B94902DAEC75417707B5BE285_426199694 =                 "DESTROY_ACTIVITY";
                varBC98996B94902DAEC75417707B5BE285_426199694.addTaint(taint);
                return varBC98996B94902DAEC75417707B5BE285_426199694;
                case BIND_APPLICATION:
String var53439F912A8CF81809B3422CA9594934_315019853 =                 "BIND_APPLICATION";
                var53439F912A8CF81809B3422CA9594934_315019853.addTaint(taint);
                return var53439F912A8CF81809B3422CA9594934_315019853;
                case EXIT_APPLICATION:
String var2619FF8712644C4BEAF8864243B4ECD2_1001718675 =                 "EXIT_APPLICATION";
                var2619FF8712644C4BEAF8864243B4ECD2_1001718675.addTaint(taint);
                return var2619FF8712644C4BEAF8864243B4ECD2_1001718675;
                case NEW_INTENT:
String varBB09EE63CD1CFFE7E0B0F4288976674C_108072171 =                 "NEW_INTENT";
                varBB09EE63CD1CFFE7E0B0F4288976674C_108072171.addTaint(taint);
                return varBB09EE63CD1CFFE7E0B0F4288976674C_108072171;
                case RECEIVER:
String varC3FF2482DFDCEBBAFB98469915C69616_920410993 =                 "RECEIVER";
                varC3FF2482DFDCEBBAFB98469915C69616_920410993.addTaint(taint);
                return varC3FF2482DFDCEBBAFB98469915C69616_920410993;
                case CREATE_SERVICE:
String var9B67C83E895914C80EDE20DA565C4B3B_982783479 =                 "CREATE_SERVICE";
                var9B67C83E895914C80EDE20DA565C4B3B_982783479.addTaint(taint);
                return var9B67C83E895914C80EDE20DA565C4B3B_982783479;
                case SERVICE_ARGS:
String var29FC9AF2A391BDAA746E7ED331E08D4D_367772310 =                 "SERVICE_ARGS";
                var29FC9AF2A391BDAA746E7ED331E08D4D_367772310.addTaint(taint);
                return var29FC9AF2A391BDAA746E7ED331E08D4D_367772310;
                case STOP_SERVICE:
String var2B7713B3BE09D0FB0378DC2E34BC9DDF_1330301803 =                 "STOP_SERVICE";
                var2B7713B3BE09D0FB0378DC2E34BC9DDF_1330301803.addTaint(taint);
                return var2B7713B3BE09D0FB0378DC2E34BC9DDF_1330301803;
                case REQUEST_THUMBNAIL:
String varC35456E12C5B446909C4D429FD2846DD_1793744740 =                 "REQUEST_THUMBNAIL";
                varC35456E12C5B446909C4D429FD2846DD_1793744740.addTaint(taint);
                return varC35456E12C5B446909C4D429FD2846DD_1793744740;
                case CONFIGURATION_CHANGED:
String var5B00CEEFF850285C392AFE5702149CA7_865858164 =                 "CONFIGURATION_CHANGED";
                var5B00CEEFF850285C392AFE5702149CA7_865858164.addTaint(taint);
                return var5B00CEEFF850285C392AFE5702149CA7_865858164;
                case CLEAN_UP_CONTEXT:
String var2A0045C72F755900263ADD8ED92DD90D_341972015 =                 "CLEAN_UP_CONTEXT";
                var2A0045C72F755900263ADD8ED92DD90D_341972015.addTaint(taint);
                return var2A0045C72F755900263ADD8ED92DD90D_341972015;
                case GC_WHEN_IDLE:
String var46C47BAAC1D03D7CF96E66451F36986A_1117884442 =                 "GC_WHEN_IDLE";
                var46C47BAAC1D03D7CF96E66451F36986A_1117884442.addTaint(taint);
                return var46C47BAAC1D03D7CF96E66451F36986A_1117884442;
                case BIND_SERVICE:
String varA4F4CEDA863E91F73D036B2C4B3671B8_277993658 =                 "BIND_SERVICE";
                varA4F4CEDA863E91F73D036B2C4B3671B8_277993658.addTaint(taint);
                return varA4F4CEDA863E91F73D036B2C4B3671B8_277993658;
                case UNBIND_SERVICE:
String var8452CE93AED0C4F5624724389ACFDA6F_1359021081 =                 "UNBIND_SERVICE";
                var8452CE93AED0C4F5624724389ACFDA6F_1359021081.addTaint(taint);
                return var8452CE93AED0C4F5624724389ACFDA6F_1359021081;
                case DUMP_SERVICE:
String var170A5EA9E5F78763F105A102FA691C15_1880751156 =                 "DUMP_SERVICE";
                var170A5EA9E5F78763F105A102FA691C15_1880751156.addTaint(taint);
                return var170A5EA9E5F78763F105A102FA691C15_1880751156;
                case LOW_MEMORY:
String var658F956721C9F511EDDE863C9AF51D80_247139412 =                 "LOW_MEMORY";
                var658F956721C9F511EDDE863C9AF51D80_247139412.addTaint(taint);
                return var658F956721C9F511EDDE863C9AF51D80_247139412;
                case ACTIVITY_CONFIGURATION_CHANGED:
String var2A0E7D74F79504051AE86143C884DE0B_2066405589 =                 "ACTIVITY_CONFIGURATION_CHANGED";
                var2A0E7D74F79504051AE86143C884DE0B_2066405589.addTaint(taint);
                return var2A0E7D74F79504051AE86143C884DE0B_2066405589;
                case RELAUNCH_ACTIVITY:
String varA1B86FCE3964C0B223F6ED13819C087D_1449095121 =                 "RELAUNCH_ACTIVITY";
                varA1B86FCE3964C0B223F6ED13819C087D_1449095121.addTaint(taint);
                return varA1B86FCE3964C0B223F6ED13819C087D_1449095121;
                case PROFILER_CONTROL:
String var8C6EC399D436B566659D72F5B8411B4B_1994730930 =                 "PROFILER_CONTROL";
                var8C6EC399D436B566659D72F5B8411B4B_1994730930.addTaint(taint);
                return var8C6EC399D436B566659D72F5B8411B4B_1994730930;
                case CREATE_BACKUP_AGENT:
String var6A6C7C6E4F5E53DE6AFA763D98902DD9_1696020014 =                 "CREATE_BACKUP_AGENT";
                var6A6C7C6E4F5E53DE6AFA763D98902DD9_1696020014.addTaint(taint);
                return var6A6C7C6E4F5E53DE6AFA763D98902DD9_1696020014;
                case DESTROY_BACKUP_AGENT:
String var3408CB01F5A3E7740333D577D70598D5_2119809117 =                 "DESTROY_BACKUP_AGENT";
                var3408CB01F5A3E7740333D577D70598D5_2119809117.addTaint(taint);
                return var3408CB01F5A3E7740333D577D70598D5_2119809117;
                case SUICIDE:
String var9D51CB7174F2E38567C3DE11AA723D1E_203522778 =                 "SUICIDE";
                var9D51CB7174F2E38567C3DE11AA723D1E_203522778.addTaint(taint);
                return var9D51CB7174F2E38567C3DE11AA723D1E_203522778;
                case REMOVE_PROVIDER:
String varFD5BFFCA0298E2267DA4CA7ED6B1A232_138959004 =                 "REMOVE_PROVIDER";
                varFD5BFFCA0298E2267DA4CA7ED6B1A232_138959004.addTaint(taint);
                return varFD5BFFCA0298E2267DA4CA7ED6B1A232_138959004;
                case ENABLE_JIT:
String varED777055495A0F5CE410E9225F64E79B_2062635365 =                 "ENABLE_JIT";
                varED777055495A0F5CE410E9225F64E79B_2062635365.addTaint(taint);
                return varED777055495A0F5CE410E9225F64E79B_2062635365;
                case DISPATCH_PACKAGE_BROADCAST:
String varEE2CE5466165243022BDA6BB7EB797B9_1497432999 =                 "DISPATCH_PACKAGE_BROADCAST";
                varEE2CE5466165243022BDA6BB7EB797B9_1497432999.addTaint(taint);
                return varEE2CE5466165243022BDA6BB7EB797B9_1497432999;
                case SCHEDULE_CRASH:
String var1F028B2DD4A4B7BA2ECFBFCE1C635DD8_2042870063 =                 "SCHEDULE_CRASH";
                var1F028B2DD4A4B7BA2ECFBFCE1C635DD8_2042870063.addTaint(taint);
                return var1F028B2DD4A4B7BA2ECFBFCE1C635DD8_2042870063;
                case DUMP_HEAP:
String var6F7C7D888E641FDBAF2CAA7DBE154945_1131296953 =                 "DUMP_HEAP";
                var6F7C7D888E641FDBAF2CAA7DBE154945_1131296953.addTaint(taint);
                return var6F7C7D888E641FDBAF2CAA7DBE154945_1131296953;
                case DUMP_ACTIVITY:
String varA56B9B6D8EFE176384B287F5BD5FFE70_1255111145 =                 "DUMP_ACTIVITY";
                varA56B9B6D8EFE176384B287F5BD5FFE70_1255111145.addTaint(taint);
                return varA56B9B6D8EFE176384B287F5BD5FFE70_1255111145;
                case SLEEPING:
String var475D91C539CB92039EC0C31B1CF1A268_1151906992 =                 "SLEEPING";
                var475D91C539CB92039EC0C31B1CF1A268_1151906992.addTaint(taint);
                return var475D91C539CB92039EC0C31B1CF1A268_1151906992;
                case SET_CORE_SETTINGS:
String varB399D3C7B0769FF29D654C8C38C08C72_2145096463 =                 "SET_CORE_SETTINGS";
                varB399D3C7B0769FF29D654C8C38C08C72_2145096463.addTaint(taint);
                return varB399D3C7B0769FF29D654C8C38C08C72_2145096463;
                case UPDATE_PACKAGE_COMPATIBILITY_INFO:
String var35E615B626EDB23B8E83E1690E72713C_1464262407 =                 "UPDATE_PACKAGE_COMPATIBILITY_INFO";
                var35E615B626EDB23B8E83E1690E72713C_1464262407.addTaint(taint);
                return var35E615B626EDB23B8E83E1690E72713C_1464262407;
                case TRIM_MEMORY:
String var1CCE4D8D0DE9B4337504D4C24699B399_1059115581 =                 "TRIM_MEMORY";
                var1CCE4D8D0DE9B4337504D4C24699B399_1059115581.addTaint(taint);
                return var1CCE4D8D0DE9B4337504D4C24699B399_1059115581;
}
            } //End block
String var8E88FB026CD047690CF189FD43C5BC04_1767869036 =             "(unknown)";
            var8E88FB026CD047690CF189FD43C5BC04_1767869036.addTaint(taint);
            return var8E88FB026CD047690CF189FD43C5BC04_1767869036;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.775 -0400", hash_original_method = "DC9C3E5B703CFDFA18C27F800AA1CA40", hash_generated_method = "B6CD749816E28DD94323952E8E68425C")
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
    if(DEBUG_MESSAGES){ }switch(msg.what){
            case LAUNCH_ACTIVITY:
            {
                ActivityClientRecord r = (ActivityClientRecord)msg.obj;
                r.packageInfo = getPackageInfoNoCheck(
                            r.activityInfo.applicationInfo, r.compatInfo);
                handleLaunchActivity(r, null);
            } //End block
            break;
            case RELAUNCH_ACTIVITY:
            {
                ActivityClientRecord r = (ActivityClientRecord)msg.obj;
                handleRelaunchActivity(r);
            } //End block
            break;
            case PAUSE_ACTIVITY:
            handlePauseActivity((IBinder)msg.obj, false, msg.arg1 != 0, msg.arg2);
            maybeSnapshot();
            break;
            case PAUSE_ACTIVITY_FINISHING:
            handlePauseActivity((IBinder)msg.obj, true, msg.arg1 != 0, msg.arg2);
            break;
            case STOP_ACTIVITY_SHOW:
            handleStopActivity((IBinder)msg.obj, true, msg.arg2);
            break;
            case STOP_ACTIVITY_HIDE:
            handleStopActivity((IBinder)msg.obj, false, msg.arg2);
            break;
            case SHOW_WINDOW:
            handleWindowVisibility((IBinder)msg.obj, true);
            break;
            case HIDE_WINDOW:
            handleWindowVisibility((IBinder)msg.obj, false);
            break;
            case RESUME_ACTIVITY:
            handleResumeActivity((IBinder)msg.obj, true,
                            msg.arg1 != 0);
            break;
            case SEND_RESULT:
            handleSendResult((ResultData)msg.obj);
            break;
            case DESTROY_ACTIVITY:
            handleDestroyActivity((IBinder)msg.obj, msg.arg1 != 0,
                            msg.arg2, false);
            break;
            case BIND_APPLICATION:
            AppBindData data = (AppBindData)msg.obj;
            handleBindApplication(data);
            break;
            case EXIT_APPLICATION:
    if(mInitialApplication != null)            
            {
                mInitialApplication.onTerminate();
            } //End block
            Looper.myLooper().quit();
            break;
            case NEW_INTENT:
            handleNewIntent((NewIntentData)msg.obj);
            break;
            case RECEIVER:
            handleReceiver((ReceiverData)msg.obj);
            maybeSnapshot();
            break;
            case CREATE_SERVICE:
            handleCreateService((CreateServiceData)msg.obj);
            break;
            case BIND_SERVICE:
            handleBindService((BindServiceData)msg.obj);
            break;
            case UNBIND_SERVICE:
            handleUnbindService((BindServiceData)msg.obj);
            break;
            case SERVICE_ARGS:
            handleServiceArgs((ServiceArgsData)msg.obj);
            break;
            case STOP_SERVICE:
            handleStopService((IBinder)msg.obj);
            maybeSnapshot();
            break;
            case REQUEST_THUMBNAIL:
            handleRequestThumbnail((IBinder)msg.obj);
            break;
            case CONFIGURATION_CHANGED:
            handleConfigurationChanged((Configuration)msg.obj, null);
            break;
            case CLEAN_UP_CONTEXT:
            ContextCleanupInfo cci = (ContextCleanupInfo)msg.obj;
            cci.context.performFinalCleanup(cci.who, cci.what);
            break;
            case GC_WHEN_IDLE:
            scheduleGcIdler();
            break;
            case DUMP_SERVICE:
            handleDumpService((DumpComponentInfo)msg.obj);
            break;
            case LOW_MEMORY:
            handleLowMemory();
            break;
            case ACTIVITY_CONFIGURATION_CHANGED:
            handleActivityConfigurationChanged((IBinder)msg.obj);
            break;
            case PROFILER_CONTROL:
            handleProfilerControl(msg.arg1 != 0, (ProfilerControlData)msg.obj, msg.arg2);
            break;
            case CREATE_BACKUP_AGENT:
            handleCreateBackupAgent((CreateBackupAgentData)msg.obj);
            break;
            case DESTROY_BACKUP_AGENT:
            handleDestroyBackupAgent((CreateBackupAgentData)msg.obj);
            break;
            case SUICIDE:
            Process.killProcess(Process.myPid());
            break;
            case REMOVE_PROVIDER:
            completeRemoveProvider((IContentProvider)msg.obj);
            break;
            case ENABLE_JIT:
            ensureJitEnabled();
            break;
            case DISPATCH_PACKAGE_BROADCAST:
            handleDispatchPackageBroadcast(msg.arg1, (String[])msg.obj);
            break;
            case SCHEDULE_CRASH:
            RemoteServiceException varFE803001684F54152007360F76234B4D_690645094 = new RemoteServiceException((String)msg.obj);
            varFE803001684F54152007360F76234B4D_690645094.addTaint(taint);
            throw varFE803001684F54152007360F76234B4D_690645094;
            case DUMP_HEAP:
            handleDumpHeap(msg.arg1 != 0, (DumpHeapData)msg.obj);
            break;
            case DUMP_ACTIVITY:
            handleDumpActivity((DumpComponentInfo)msg.obj);
            break;
            case SLEEPING:
            handleSleeping((IBinder)msg.obj, msg.arg1 != 0);
            break;
            case SET_CORE_SETTINGS:
            handleSetCoreSettings((Bundle) msg.obj);
            break;
            case UPDATE_PACKAGE_COMPATIBILITY_INFO:
            handleUpdatePackageCompatibilityInfo((UpdateCompatibilityData)msg.obj);
            break;
            case TRIM_MEMORY:
            handleTrimMemory(msg.arg1);
            break;
}    if(DEBUG_MESSAGES){ }
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.776 -0400", hash_original_method = "E92E43C77FF76A1843097A49ADA7442E", hash_generated_method = "3C7808751CD913987AB8C64CEB507DC1")
        private void maybeSnapshot() {
    if(mBoundApplication != null && SamplingProfilerIntegration.isEnabled())            
            {
                String packageName = mBoundApplication.info.mPackageName;
                android.content.pm.PackageInfo packageInfo = null;
                try 
                {
                    Context context = getSystemContext();
    if(context == null)                    
                    {
                        return;
                    } //End block
                    PackageManager pm = context.getPackageManager();
    if(pm == null)                    
                    {
                        return;
                    } //End block
                    packageInfo = pm.getPackageInfo(
                            packageName, PackageManager.GET_ACTIVITIES);
                } //End block
                catch (NameNotFoundException e)
                {
                } //End block
                SamplingProfilerIntegration.writeSnapshot(mBoundApplication.processName, packageInfo);
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.777 -0400", hash_original_field = "722CEDE668F96C619AD9AE4EE59CCD7B", hash_generated_field = "79EE3E0E74CCDF8DA485137663462447")

        public static final int LAUNCH_ACTIVITY         = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.778 -0400", hash_original_field = "7C6BEE59AC8DEB3272ACA35B77D0ECB8", hash_generated_field = "F6E6C101887932ADB1F39FD5B86A118E")

        public static final int PAUSE_ACTIVITY          = 101;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.779 -0400", hash_original_field = "27E7CCADA8E378177A09B210CB7998B9", hash_generated_field = "09D07137EA5653F1E891575A10F54C95")

        public static final int PAUSE_ACTIVITY_FINISHING= 102;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.780 -0400", hash_original_field = "DC0C14DC0B1F89A47A5B1280137AB9E3", hash_generated_field = "EC045D213E7DCC46FAC0B6AAED7E85D6")

        public static final int STOP_ACTIVITY_SHOW      = 103;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.780 -0400", hash_original_field = "E188806E5AACE94BD962909A9F9D11B7", hash_generated_field = "25971E3B508C10EDB2E29C96206F822B")

        public static final int STOP_ACTIVITY_HIDE      = 104;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.781 -0400", hash_original_field = "D3BBE314F0306D0843A920C0579FAD38", hash_generated_field = "0FBE2B02A08E08DD92AF03DD97DDA5AE")

        public static final int SHOW_WINDOW             = 105;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.781 -0400", hash_original_field = "AEEF026EB5CD7DCEC2DB87D54CB22A26", hash_generated_field = "B048EDF2C316D4329B5527B43CEDFE50")

        public static final int HIDE_WINDOW             = 106;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.781 -0400", hash_original_field = "518DFFD71C73003A033FA6BC1B294FC6", hash_generated_field = "D40012091267201A48CEA7D4C55C1620")

        public static final int RESUME_ACTIVITY         = 107;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.782 -0400", hash_original_field = "40995C694C9D49F47FA7514A7F959820", hash_generated_field = "A40A106C973F0FB170D2DAC3448C5A13")

        public static final int SEND_RESULT             = 108;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.782 -0400", hash_original_field = "2BCF8356B8869C9E49E05C226AB9C831", hash_generated_field = "F3C8D3955BE8F2810694F3E7013C556E")

        public static final int DESTROY_ACTIVITY        = 109;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.782 -0400", hash_original_field = "72110ACC314A9846CE925BF8B24FB2C4", hash_generated_field = "9E021100AE53B786AFAD15A16329BAB4")

        public static final int BIND_APPLICATION        = 110;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.783 -0400", hash_original_field = "C8EB10E0EF2483EDA8A276929FEC0A42", hash_generated_field = "D9A851E248DD3DA74E867B25E117FD22")

        public static final int EXIT_APPLICATION        = 111;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.783 -0400", hash_original_field = "C51444BA300FE3DFDBF5E4BACC59B339", hash_generated_field = "E81354CA5082AEBC39D8C31B119790DD")

        public static final int NEW_INTENT              = 112;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.783 -0400", hash_original_field = "5F934832E9EA645D6B42B183077116BE", hash_generated_field = "BC2E16123EEC2C2FE2146178A6F6EBE7")

        public static final int RECEIVER                = 113;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.783 -0400", hash_original_field = "DF58095DA1EF21EA8AFE7DC349A8C5EE", hash_generated_field = "46F82A63643EBF3740DA044A97C411BD")

        public static final int CREATE_SERVICE          = 114;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.784 -0400", hash_original_field = "ADC07D5CB42F74F249ED9FA053F1F453", hash_generated_field = "A20CACB6EB007BA6D6D1EAE18B100F96")

        public static final int SERVICE_ARGS            = 115;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.784 -0400", hash_original_field = "DA80AE7CA253D962B8BA0A9C2B53B49E", hash_generated_field = "AB975960BB4220B2FCB171489C6584C5")

        public static final int STOP_SERVICE            = 116;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.784 -0400", hash_original_field = "8FDB2CCAA7CDF8F31A6175479EDFB50A", hash_generated_field = "DA58382979407C0DCE4E024C9F856907")

        public static final int REQUEST_THUMBNAIL       = 117;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.785 -0400", hash_original_field = "1832887E832CF03CCE11F98660915BA9", hash_generated_field = "F8782D86E0C72BFCA118C31A420D9DB2")

        public static final int CONFIGURATION_CHANGED   = 118;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.785 -0400", hash_original_field = "B69BEAC73959E05CD1A9C07F9E505BF9", hash_generated_field = "203638C0D401316316F231069A439983")

        public static final int CLEAN_UP_CONTEXT        = 119;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.785 -0400", hash_original_field = "524F3CBD925BC2700E2FE96AFB6C6814", hash_generated_field = "7FDF10F5D0B32576CCE522E8063EE1AB")

        public static final int GC_WHEN_IDLE            = 120;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.786 -0400", hash_original_field = "3742E17E26429D8B18102CF3986F6EC2", hash_generated_field = "FA82AB4CAC5570F743636186326BBBCB")

        public static final int BIND_SERVICE            = 121;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.786 -0400", hash_original_field = "15BD5376B9A6F8BB72279CD48F03813F", hash_generated_field = "3AA49274B99CB4754DE7AAC22A64097B")

        public static final int UNBIND_SERVICE          = 122;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.786 -0400", hash_original_field = "4CE5A2061279EE1D7222C2D95BD68317", hash_generated_field = "BE57D55C848AF78B6D13D08C75CD3890")

        public static final int DUMP_SERVICE            = 123;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.787 -0400", hash_original_field = "CE13FEC4244FD5042DEA52894A5793E4", hash_generated_field = "016852C1459DE34F8D1BECDF172A7A3B")

        public static final int LOW_MEMORY              = 124;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.787 -0400", hash_original_field = "C7101CE79C508314D48E359FD888E39C", hash_generated_field = "C1874358A5069FBBE942CA7B4FEB06AC")

        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.788 -0400", hash_original_field = "FA7FD8D6AC5C010F87FE5A85800EF7ED", hash_generated_field = "F66CB5E4AB6DEA952AC6C4AC4FD8129C")

        public static final int RELAUNCH_ACTIVITY       = 126;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.788 -0400", hash_original_field = "0ECDAAA38F1875EBF22B06CF4D97840D", hash_generated_field = "B3A767EE70C05E487D7B390CB511DE9C")

        public static final int PROFILER_CONTROL        = 127;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.789 -0400", hash_original_field = "3BC29C9DB33C1749A39F6BAE42EB6789", hash_generated_field = "385AB826C3B946556BB8D2BA1F6167CB")

        public static final int CREATE_BACKUP_AGENT     = 128;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.789 -0400", hash_original_field = "C783232AA4EE8DD32768F1B54E157355", hash_generated_field = "72995E16D3DBD2A4679635D4E61FC49D")

        public static final int DESTROY_BACKUP_AGENT    = 129;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.790 -0400", hash_original_field = "A0AB320ED67492363EAFB1A4223F0B32", hash_generated_field = "2E6A83D9FB3FCAFBC6EA64132F417F75")

        public static final int SUICIDE                 = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.791 -0400", hash_original_field = "9A5FCDBB5243520A850EF658F203D220", hash_generated_field = "7DBF1A92BA0E6AA87182CD56B3D107E3")

        public static final int REMOVE_PROVIDER         = 131;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.791 -0400", hash_original_field = "66EC3392B95DE4AF1DB032BB1B33C503", hash_generated_field = "AA41E7437D6E941DE853C39868725DE4")

        public static final int ENABLE_JIT              = 132;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.792 -0400", hash_original_field = "97FF97449C421C91A81CB7768A612B09", hash_generated_field = "77AEBFDF31780CFDC843B8D9EAB26B65")

        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.792 -0400", hash_original_field = "750A8194549152ABCA207A461974A0F2", hash_generated_field = "2F79168F541635B32A56D3A800568EB5")

        public static final int SCHEDULE_CRASH          = 134;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.792 -0400", hash_original_field = "CE74C94F7495E6DA3E31F74989140E11", hash_generated_field = "AE9A74DBF18BA76BECBDADA426FDD8D1")

        public static final int DUMP_HEAP               = 135;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.793 -0400", hash_original_field = "B1D84959B056AFDF77A071642B0B4DDE", hash_generated_field = "2312CB238555E0BCB137FC118844BDC3")

        public static final int DUMP_ACTIVITY           = 136;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.793 -0400", hash_original_field = "EC1261A9F39672203AD216DA43C7C314", hash_generated_field = "4EAC68079DDB116BDF58C13AC47AF396")

        public static final int SLEEPING                = 137;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.793 -0400", hash_original_field = "33DB7ACE50C2A3180517FF1D30A7D18B", hash_generated_field = "7CA400DE0EBC79FF2A4805A342BE87B5")

        public static final int SET_CORE_SETTINGS       = 138;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.794 -0400", hash_original_field = "930E95663EFFE03E81FB9BE166DBCB37", hash_generated_field = "CFEBE5355040D28519CBFFA29E96E50F")

        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.794 -0400", hash_original_field = "C8ED1A4929B7571B8B7A3A096311133B", hash_generated_field = "CF745352D226FFB32A7FEB6BFD662619")

        public static final int TRIM_MEMORY             = 140;
    }


    
    private class Idler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.794 -0400", hash_original_method = "33AE74878CEBE3B527FC27BCFED9133E", hash_generated_method = "33AE74878CEBE3B527FC27BCFED9133E")
        public Idler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.798 -0400", hash_original_method = "7124AFC3D8D2CB12FD15B850DC795363", hash_generated_method = "ED4EA76A2E6C61E91CEA04FE22A14A39")
        public final boolean queueIdle() {
            ActivityClientRecord a = mNewActivities;
            boolean stopProfiling = false;
    if(mBoundApplication != null && mProfiler.profileFd != null
                    && mProfiler.autoStopProfiler)            
            {
                stopProfiling = true;
            } //End block
    if(a != null)            
            {
                mNewActivities = null;
                IActivityManager am = ActivityManagerNative.getDefault();
                ActivityClientRecord prev;
                do {
                    {
    if(localLOGV){ }    if(a.activity != null && !a.activity.mFinished)                        
                        {
                            try 
                            {
                                am.activityIdle(a.token, a.createdConfig, stopProfiling);
                                a.createdConfig = null;
                            } //End block
                            catch (RemoteException ex)
                            {
                            } //End block
                        } //End block
                        prev = a;
                        a = a.nextIdle;
                        prev.nextIdle = null;
                    } //End block
} while (a != null);
            } //End block
    if(stopProfiling)            
            {
                mProfiler.stopProfiling();
            } //End block
            ensureJitEnabled();
            boolean var68934A3E9455FA72420237EB05902327_1044942340 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125828338 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_125828338;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    final class GcIdler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.800 -0400", hash_original_method = "ABBE7DCE196E12604C1E7133F511F6FC", hash_generated_method = "ABBE7DCE196E12604C1E7133F511F6FC")
        public GcIdler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.801 -0400", hash_original_method = "44179B8732E18ADC2B8565E550483147", hash_generated_method = "685BF5B391B37BDB332FDE686BDE0787")
        public final boolean queueIdle() {
            doGcIfNeeded();
            boolean var68934A3E9455FA72420237EB05902327_145594041 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1304840946 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1304840946;
            // ---------- Original Method ----------
            //doGcIfNeeded();
            //return false;
        }

        
    }


    
    private static class ResourcesKey {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.801 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

        private String mResDir;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.801 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "8561DC852E8BD04B40EFBC1F32D92895")

        private float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.802 -0400", hash_original_field = "EDC211DB900F40F9CAE89C00A3C90AD9", hash_generated_field = "A7D12DAC99918DD08DC20BE8E0E23E1B")

        private int mHash;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.803 -0400", hash_original_method = "0A249A0E32348D1ED1AC3A6D16406BEA", hash_generated_method = "60A5475EFF1937E45B7BF5B2F50F200B")
          ResourcesKey(String resDir, float scale) {
            mResDir = resDir;
            mScale = scale;
            mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
            // ---------- Original Method ----------
            //mResDir = resDir;
            //mScale = scale;
            //mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.803 -0400", hash_original_method = "FDD99B6C6105A3F31D8E7DC9390101DA", hash_generated_method = "BED9D99326D9A178C1FD1745DEE754C6")
        @Override
        public int hashCode() {
            int varEDC211DB900F40F9CAE89C00A3C90AD9_1941108866 = (mHash);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853105401 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1853105401;
            // ---------- Original Method ----------
            //return mHash;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.804 -0400", hash_original_method = "07DFB89699884113D8C2B96163B07C7F", hash_generated_method = "52437907D6FC7EF7A93B106856EAA142")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
    if(!(obj instanceof ResourcesKey))            
            {
                boolean var68934A3E9455FA72420237EB05902327_691320240 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_125876605 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_125876605;
            } //End block
            ResourcesKey peer = (ResourcesKey) obj;
            boolean var2440C46A902240C4C9588E73632DD290_1943236077 = (mResDir.equals(peer.mResDir) && mScale == peer.mScale);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_708669055 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_708669055;
            // ---------- Original Method ----------
            //if (!(obj instanceof ResourcesKey)) {
                //return false;
            //}
            //ResourcesKey peer = (ResourcesKey) obj;
            //return mResDir.equals(peer.mResDir) && mScale == peer.mScale;
        }

        
    }


    
    private static class StopInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.804 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "671EE8F19CE89CCA3E5285825682D0E2")

        Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.805 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB")

        CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.805 -0400", hash_original_method = "59EF1C21B91F2644F32BF61E1E80BB9E", hash_generated_method = "59EF1C21B91F2644F32BF61E1E80BB9E")
        public StopInfo ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ProviderRefCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.805 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.806 -0400", hash_original_method = "92B7A170BA9BC140C9702B48E38F46E8", hash_generated_method = "4A93BF52DF489431CBF421164E067011")
          ProviderRefCount(int pCount) {
            count = pCount;
            // ---------- Original Method ----------
            //count = pCount;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.806 -0400", hash_original_field = "34FDD53B5E6A10E8767A5E0043343C94", hash_generated_field = "425ACCA9C7A1870DD248AAA65FD54971")

    public static final String TAG = "ActivityThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.806 -0400", hash_original_field = "83F8875443EA39A07A5B37A3724C8054", hash_generated_field = "4FF79E3794E106C584E301B2B6BC3768")

    private static final android.graphics.Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.807 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.807 -0400", hash_original_field = "B3FD9C27E71EC619E39A58558EDF3036", hash_generated_field = "3E8F6F612D86B529FF072C0082938083")

    static final boolean DEBUG_MESSAGES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.807 -0400", hash_original_field = "07B77DD4826C3BEC455D95A864B72887", hash_generated_field = "6C9EE624F63E1C2CAB461CACB0D16387")

    public static final boolean DEBUG_BROADCAST = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.807 -0400", hash_original_field = "C1F0DE5C32CA1844900CC6BE3D463A43", hash_generated_field = "91674D83CE8A87566FA90CCE79A6CC85")

    private static final boolean DEBUG_RESULTS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.807 -0400", hash_original_field = "02D938CC958225A67031500CA26D971D", hash_generated_field = "1C5ED879567745A3D8BB78B4EBE8FFE6")

    private static final boolean DEBUG_BACKUP = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.808 -0400", hash_original_field = "D146DDB94A0D3A63C400058639AEBC96", hash_generated_field = "56656CF0D95F01C6330394450066014A")

    private static final boolean DEBUG_CONFIGURATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.808 -0400", hash_original_field = "95E53F781A83DB02B99AB3900C2C7910", hash_generated_field = "F1C876B177B2AB25A282C24BF376C834")

    private static final long MIN_TIME_BETWEEN_GCS = 5*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.808 -0400", hash_original_field = "CA66A5F91375944277EA9D4BD909BB19", hash_generated_field = "281968F0BF027264BDDA5DC375DC6283")

    private static final Pattern PATTERN_SEMICOLON = Pattern.compile(";");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.808 -0400", hash_original_field = "9286A6A3B31A2E01F0E11BFB8849AA7C", hash_generated_field = "6F19A1C876184A0ADFFBF4577E6D8405")

    private static final int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.808 -0400", hash_original_field = "BB5DE43B41F17D8A8E055223ED42E745", hash_generated_field = "E28C89FE2A6C28B4023589A16739DF35")

    private static final int LOG_ON_PAUSE_CALLED = 30021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.809 -0400", hash_original_field = "80F691776CC864CF51EEA7DD7E478D83", hash_generated_field = "527D0F0BC32722D4952F258103167308")

    private static final int LOG_ON_RESUME_CALLED = 30022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.809 -0400", hash_original_field = "E95028B5077B5EE8819464B14D52B9CA", hash_generated_field = "C6FF716724281192967733BEA8F63EE5")

    static ContextImpl mSystemContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.809 -0400", hash_original_field = "758BE64E47881C41CB626D9F77009B70", hash_generated_field = "89DED1E64F20B301AC92B7782A3B4974")

    static IPackageManager sPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.809 -0400", hash_original_field = "5C9F282BC1F2B74095E784FCC3BEC9F9", hash_generated_field = "5C8AC51EFF922C63EFC9F15B72A07218")

    static final ThreadLocal<ActivityThread> sThreadLocal = new ThreadLocal<ActivityThread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.809 -0400", hash_original_field = "03FC11B1885ADD83E904E0299842923E", hash_generated_field = "FBC75DA053AA4DB0E9FC91A30C88AF67")

    static Handler sMainThreadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:46:59.810 -0400", hash_original_field = "3BEAF3224097BD2645583753F770DF18", hash_generated_field = "2F4C1A0F908C99E4E3AF95D1DBBBE434")

    private static final ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<Intent>();
}

