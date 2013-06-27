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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.224 -0400", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "15811A6DE9C2E964B99F6377F947BD45")
    public  SuperNotCalledException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

final class RemoteServiceException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.225 -0400", hash_original_method = "34FE87499D0272DFF74E34D7FF4C8A87", hash_generated_method = "9A8916256CBCF45D2502CDF5D2E2014D")
    public  RemoteServiceException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
    }

    
}

public final class ActivityThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.252 -0400", hash_original_field = "B53D6F39CF0756976F39C3EF8C9347C8", hash_generated_field = "4BE2592600E22B88F19E5AEDA9C6D0D0")

    ApplicationThread mAppThread = new ApplicationThread();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.252 -0400", hash_original_field = "22026F7CA49D7800DC9226FB14F18D4E", hash_generated_field = "AF37A7D9D38B32899A98EE8F575828DF")

    Looper mLooper = Looper.myLooper();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.253 -0400", hash_original_field = "0E2EFBC2E5CA04A190F128248BAC384F", hash_generated_field = "387995F77ECCE28306AB6C09BAF19C94")

    H mH = new H();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.269 -0400", hash_original_field = "5140A1A9D96802BCD33EE8109598D4E9", hash_generated_field = "615CD00F7E8F11F57B5DF4C0815D5B17")

    HashMap<IBinder, ActivityClientRecord> mActivities = new HashMap<IBinder, ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.270 -0400", hash_original_field = "2596BE0728EC6D0B3DD8489111BCE626", hash_generated_field = "B71C13DCB6A9130D877B8D4E74CC61E9")

    ActivityClientRecord mNewActivities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.270 -0400", hash_original_field = "73A5CC022DE998406F6B6FE5D86E0FC9", hash_generated_field = "C9408B24459238C3188BD4D966397F6A")

    int mNumVisibleActivities = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.271 -0400", hash_original_field = "61AC602172BC64F1EFD6C846BCAC6EA5", hash_generated_field = "CD62060FA8FAA93F07C42F15DA265597")

    HashMap<IBinder, Service> mServices = new HashMap<IBinder, Service>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.292 -0400", hash_original_field = "E1323E77467AAA94220311B9002D86DC", hash_generated_field = "61B01177607D3FEF9030C1D9609A65D2")

    AppBindData mBoundApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.293 -0400", hash_original_field = "3813FD00D078EDC298A6165A01B23375", hash_generated_field = "137FC81C700701DC4596025475ABF5FB")

    Profiler mProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.293 -0400", hash_original_field = "2A37B83F421C69FA65AB0336DCD40F61", hash_generated_field = "17926FA2B84283931976E0CD16AD732E")

    Configuration mConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.294 -0400", hash_original_field = "9BD99EFAE86DB5408E1E53D94FB68EF1", hash_generated_field = "22A6186D8E2A9BFF1CD600DA1D66E51D")

    Configuration mCompatConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.389 -0400", hash_original_field = "07E1B5B9B806672E596B36E6C58FDD44", hash_generated_field = "EAF24A11BB6A5B40B8CD0A9DD97E14E0")

    Configuration mResConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.389 -0400", hash_original_field = "FFC49FFC4C1ADAB5104047620A7D56C4", hash_generated_field = "EA04CA285EC541B77CDD4831DDC16DBF")

    CompatibilityInfo mResCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.390 -0400", hash_original_field = "BE63E38FE23E99043AF34F6BEC9CDB32", hash_generated_field = "9E9AEECCAC03AFADA449BC8121CFBA7B")

    Application mInitialApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.391 -0400", hash_original_field = "9754DC7CB34C86576E6459500AEBA7A8", hash_generated_field = "04472E000F282817521CDA08EBAABE2D")

    ArrayList<Application> mAllApplications = new ArrayList<Application>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.391 -0400", hash_original_field = "DDC10AFA30585BFE20C9F9446377894E", hash_generated_field = "22A081A93589AAECA93930928B5ABCF5")

    HashMap<String, BackupAgent> mBackupAgents = new HashMap<String, BackupAgent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.392 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

    Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.393 -0400", hash_original_field = "3F33A383895BCD9FFD4FF85E994A91B3", hash_generated_field = "BC772FC243D47A489F2D7EFDAE87E511")

    String mInstrumentationAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.393 -0400", hash_original_field = "E384AAD9DCDFF1E8D0CD8D0A19256B7C", hash_generated_field = "FECBD9A8D7E48015CA8B1CB4E8417096")

    String mInstrumentationAppPackage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.393 -0400", hash_original_field = "9BFC607661C16E486035F6C16F2728BF", hash_generated_field = "8A05224BF80336D163F84B1774E94778")

    String mInstrumentedAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.418 -0400", hash_original_field = "4E393FC3E9967B2FBCC5BD30CD6D6121", hash_generated_field = "A1282214A6522F9FAF740141A5995478")

    boolean mSystemThread = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.419 -0400", hash_original_field = "2ADB2DE2F0908AF94082A4D9E402F85C", hash_generated_field = "CA9794682AE3611FC2EF8314769D534A")

    boolean mJitEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.419 -0400", hash_original_field = "2F3B136DE313E1E070DB549F1244D943", hash_generated_field = "FEA27B20D4A63203859011A457861469")

    HashMap<String, WeakReference<LoadedApk>> mPackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.420 -0400", hash_original_field = "E54DD7B740A85C91DABABE72B3B095EB", hash_generated_field = "EC7A0BFBB55936D0B61B3B563F70B364")

    HashMap<String, WeakReference<LoadedApk>> mResourcePackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.430 -0400", hash_original_field = "8F7DF79A1A56B58604502A94A5CC013A", hash_generated_field = "00C29CB9D971953C68B055F0717AB51D")

    HashMap<CompatibilityInfo, DisplayMetrics> mDisplayMetrics = new HashMap<CompatibilityInfo, DisplayMetrics>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.430 -0400", hash_original_field = "2FFFBD4436769ADEF3F6BE93035E29EA", hash_generated_field = "A643317325A53EF83EA8267E12E4A2B1")

    HashMap<ResourcesKey, WeakReference<Resources> > mActiveResources = new HashMap<ResourcesKey, WeakReference<Resources> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.431 -0400", hash_original_field = "E0C0F3A1D8876C73109C81652022AE20", hash_generated_field = "BBDA8BFABB6CB4331606809C8A32FCD7")

    ArrayList<ActivityClientRecord> mRelaunchingActivities = new ArrayList<ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.432 -0400", hash_original_field = "F5DB0E5D46891F17B40D6AE0558F2A3E", hash_generated_field = "52608F8A47308D1928152A18CB1F8EE5")

    Configuration mPendingConfiguration = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.432 -0400", hash_original_field = "DAFE2855A8819A2CAFDA3A7DC574897D", hash_generated_field = "F0523ED3D6D76B895086A38833AF30AD")

    HashMap<String, ProviderClientRecord> mProviderMap = new HashMap<String, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.433 -0400", hash_original_field = "FAD775743D6E65E861C71DE7D10EDCC7", hash_generated_field = "CAD5A9D5BD21F26ABF851CA219AABC58")

    HashMap<IBinder, ProviderRefCount> mProviderRefCountMap = new HashMap<IBinder, ProviderRefCount>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.433 -0400", hash_original_field = "67EF4D3C5C70C137D7F9C1C0643D46E2", hash_generated_field = "0DD2F59DEA9CF73864C3201947856DF3")

    HashMap<IBinder, ProviderClientRecord> mLocalProviders = new HashMap<IBinder, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.445 -0400", hash_original_field = "219DD26B03E1DDCCF0E4339F403F8A1B", hash_generated_field = "21DB313BBB4D9FE4E9279F224291BC66")

    HashMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners = new HashMap<Activity, ArrayList<OnActivityPausedListener>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.446 -0400", hash_original_field = "95C2F14E893DEE4E51A4A3450B6F5DDE", hash_generated_field = "9A2BB5A7170EE3CC26087AD938361046")

    GcIdler mGcIdler = new GcIdler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.446 -0400", hash_original_field = "DE4BFAC052533664C59E9AD019F17B6A", hash_generated_field = "42912703516C643929BE4407C1512E06")

    boolean mGcIdlerScheduled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.447 -0400", hash_original_field = "3FAF8118696AC73FC8F1B67D3D02AF4A", hash_generated_field = "5193B2043B5018140A114729BFBC1AB5")

    Bundle mCoreSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.447 -0400", hash_original_field = "993B4BC77167CA135C4203377145C3CD", hash_generated_field = "218DF766A932DC18C65DC16EEE9A759F")

    private Configuration mMainThreadConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.468 -0400", hash_original_field = "C0A0D42CB8ABD8C7501B75A124D2EBED", hash_generated_field = "4A61C1EAE378A13AF88688B33DC5A9C1")

    private int mThumbnailWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.469 -0400", hash_original_field = "911A70F142E0968B61A5EFA355B11DDC", hash_generated_field = "B5D585F47D7019D989CAAE6F1896D3A6")

    private int mThumbnailHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.469 -0400", hash_original_field = "141C098303475F179108F5D3107FEAD3", hash_generated_field = "86CFFC9A0E84C08A1C5D2192C683E8D7")

    private Bitmap mAvailThumbnailBitmap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.470 -0400", hash_original_field = "9896186CB5EE9EEFA16B028C2F3D5A9A", hash_generated_field = "1246BE5370B0FC65915F756626A5C46E")

    private Canvas mThumbnailCanvas = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.485 -0400", hash_original_method = "C5DB87E83A0D8D66EF8ECA86A91864C7", hash_generated_method = "DE4A90A4BD0EECDAD4C2F33FDAD8D9FA")
      ActivityThread() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.485 -0400", hash_original_method = "FA5B9DB827774258D426805F82794E0D", hash_generated_method = "EBE4AC8FA18D0885A3E86BAFC9F27611")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.507 -0400", hash_original_method = "E45CB384263D7EF5FBA0A98360B08B32", hash_generated_method = "EE9732823102855BE6FF5B8D181221E0")
     DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo ci, boolean forceUpdate) {
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_703475627 = null; //Variable for return #1
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_1802069696 = null; //Variable for return #2
        DisplayMetrics dm;
        dm = mDisplayMetrics.get(ci);
        {
            varB4EAC82CA7396A68D541C85D26508E83_703475627 = dm;
        } //End block
        {
            dm = new DisplayMetrics();
            mDisplayMetrics.put(ci, dm);
        } //End block
        Display d;
        d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        d.getMetrics(dm);
        varB4EAC82CA7396A68D541C85D26508E83_1802069696 = dm;
        addTaint(ci.getTaint());
        addTaint(forceUpdate);
        DisplayMetrics varA7E53CE21691AB073D9660D615818899_632421362; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_632421362 = varB4EAC82CA7396A68D541C85D26508E83_703475627;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_632421362 = varB4EAC82CA7396A68D541C85D26508E83_1802069696;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_632421362.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_632421362;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.532 -0400", hash_original_method = "DD63F0FD46EA5914D44A0437CF6968C9", hash_generated_method = "B39AAD3EB0AF152532C5A47704AD04D2")
     Configuration applyConfigCompatMainThread(Configuration config, CompatibilityInfo compat) {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_38736322 = null; //Variable for return #1
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1230421657 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_38736322 = null;
        } //End block
        {
            boolean varCD86D3736FF36F045F26DFAD036F3B54_1412502301 = (compat != null && !compat.supportsScreen());
            {
                mMainThreadConfig.setTo(config);
                config = mMainThreadConfig;
                compat.applyToConfiguration(config);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1230421657 = config;
        addTaint(config.getTaint());
        addTaint(compat.getTaint());
        Configuration varA7E53CE21691AB073D9660D615818899_1140055575; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1140055575 = varB4EAC82CA7396A68D541C85D26508E83_38736322;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1140055575 = varB4EAC82CA7396A68D541C85D26508E83_1230421657;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1140055575.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1140055575;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.553 -0400", hash_original_method = "371F1E66BBE63CA5CE35B0BEAA492ADA", hash_generated_method = "8186E3A7CCDFC897D56E94F2A928BF53")
     Resources getTopLevelResources(String resDir, CompatibilityInfo compInfo) {
        Resources varB4EAC82CA7396A68D541C85D26508E83_914846843 = null; //Variable for return #1
        Resources varB4EAC82CA7396A68D541C85D26508E83_417573289 = null; //Variable for return #2
        Resources varB4EAC82CA7396A68D541C85D26508E83_87346612 = null; //Variable for return #3
        Resources varB4EAC82CA7396A68D541C85D26508E83_320715936 = null; //Variable for return #4
        ResourcesKey key;
        key = new ResourcesKey(resDir, compInfo.applicationScale);
        Resources r;
        {
            WeakReference<Resources> wr;
            wr = mActiveResources.get(key);
            r = wr != null ? wr.get() : null;
            {
                boolean var48C26B00950FB02DC27CD0CFBAC99128_167585814 = (r != null && r.getAssets().isUpToDate());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_914846843 = r;
                } //End block
            } //End collapsed parenthetic
        } //End block
        AssetManager assets;
        assets = new AssetManager();
        {
            boolean varA8CA5D176688F55202435C4C301C623B_978873756 = (assets.addAssetPath(resDir) == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_417573289 = null;
            } //End block
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
                boolean var272EB1A1727EF2EADA6DAD1E49705320_669533736 = (existing != null && existing.getAssets().isUpToDate());
                {
                    r.getAssets().close();
                    varB4EAC82CA7396A68D541C85D26508E83_87346612 = existing;
                } //End block
            } //End collapsed parenthetic
            mActiveResources.put(key, new WeakReference<Resources>(r));
            varB4EAC82CA7396A68D541C85D26508E83_320715936 = r;
        } //End block
        addTaint(resDir.getTaint());
        addTaint(compInfo.getTaint());
        Resources varA7E53CE21691AB073D9660D615818899_1276068369; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1276068369 = varB4EAC82CA7396A68D541C85D26508E83_914846843;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1276068369 = varB4EAC82CA7396A68D541C85D26508E83_417573289;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1276068369 = varB4EAC82CA7396A68D541C85D26508E83_87346612;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1276068369 = varB4EAC82CA7396A68D541C85D26508E83_320715936;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1276068369.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1276068369;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.578 -0400", hash_original_method = "9D648CED90369A8409E4C88D7CE96759", hash_generated_method = "5C54C6D64A1235DD701274D0DEF58C12")
     Resources getTopLevelResources(String resDir, LoadedApk pkgInfo) {
        Resources varB4EAC82CA7396A68D541C85D26508E83_794813152 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_794813152 = getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
        addTaint(resDir.getTaint());
        addTaint(pkgInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_794813152.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_794813152;
        // ---------- Original Method ----------
        //return getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.582 -0400", hash_original_method = "F7A72EDCDC7800374FD6BBEAFCDB636B", hash_generated_method = "C86D5982DDBDEEF992395018D3AF37EC")
    final Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_275359697 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_275359697 = mH;
        varB4EAC82CA7396A68D541C85D26508E83_275359697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_275359697;
        // ---------- Original Method ----------
        //return mH;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.601 -0400", hash_original_method = "FD6B2C09494E94CB4CF03F9000F967F2", hash_generated_method = "DB14FDB543F8A763D369E2A6F2403C5C")
    public final LoadedApk getPackageInfo(String packageName, CompatibilityInfo compatInfo,
            int flags) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1280424118 = null; //Variable for return #1
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_969714711 = null; //Variable for return #2
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_687696487 = null; //Variable for return #3
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
                boolean varB533B767BDFF950E5D1E69E8D8289A2E_430125710 = (packageInfo != null && (packageInfo.mResources == null
                    || packageInfo.mResources.getAssets().isUpToDate()));
                {
                    {
                        boolean var0E943DBF535AA6AD6A4FBE9A1D1356B5_1594758274 = (packageInfo.isSecurityViolation()
                        && (flags&Context.CONTEXT_IGNORE_SECURITY) == 0);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                            "Requesting code from " + packageName
                            + " to be run in process "
                            + mBoundApplication.processName
                            + "/" + mBoundApplication.appInfo.uid);
                        } //End block
                    } //End collapsed parenthetic
                    varB4EAC82CA7396A68D541C85D26508E83_1280424118 = packageInfo;
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
            varB4EAC82CA7396A68D541C85D26508E83_969714711 = getPackageInfo(ai, compatInfo, flags);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_687696487 = null;
        addTaint(packageName.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(flags);
        LoadedApk varA7E53CE21691AB073D9660D615818899_480335877; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_480335877 = varB4EAC82CA7396A68D541C85D26508E83_1280424118;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_480335877 = varB4EAC82CA7396A68D541C85D26508E83_969714711;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_480335877 = varB4EAC82CA7396A68D541C85D26508E83_687696487;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_480335877.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_480335877;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.619 -0400", hash_original_method = "45FB4CD004B111E95D4C640E8F52184B", hash_generated_method = "7BBDCFDEAEBAC9459B4712091FABBACC")
    public final LoadedApk getPackageInfo(ApplicationInfo ai, CompatibilityInfo compatInfo,
            int flags) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1732648144 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1732648144 = getPackageInfo(ai, compatInfo, null, securityViolation, includeCode);
        addTaint(ai.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1732648144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1732648144;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.621 -0400", hash_original_method = "60B71579104EFF006D8A717508119428", hash_generated_method = "73604537568F45183291554B5C519334")
    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo ai,
            CompatibilityInfo compatInfo) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_942400211 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_942400211 = getPackageInfo(ai, compatInfo, null, false, true);
        addTaint(ai.getTaint());
        addTaint(compatInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_942400211.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_942400211;
        // ---------- Original Method ----------
        //return getPackageInfo(ai, compatInfo, null, false, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.631 -0400", hash_original_method = "5838753A6BAADDD41C531129622D5299", hash_generated_method = "C50801062122F79F2469B4AF43C7F3CF")
    public final LoadedApk peekPackageInfo(String packageName, boolean includeCode) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_230292390 = null; //Variable for return #1
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(packageName);
            } //End block
            {
                ref = mResourcePackages.get(packageName);
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_230292390 = ref != null ? ref.get() : null;
        } //End block
        addTaint(packageName.getTaint());
        addTaint(includeCode);
        varB4EAC82CA7396A68D541C85D26508E83_230292390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_230292390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.658 -0400", hash_original_method = "F2A25E301DE436DC300B56B48A365596", hash_generated_method = "D45DBE787D0722AC44E41915ED233A47")
    private LoadedApk getPackageInfo(ApplicationInfo aInfo, CompatibilityInfo compatInfo,
            ClassLoader baseLoader, boolean securityViolation, boolean includeCode) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1507149579 = null; //Variable for return #1
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
                boolean var9EEE2F12DDA56A5DEE7DE7A2224F5C7D_92906362 = (packageInfo == null || (packageInfo.mResources != null
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
            varB4EAC82CA7396A68D541C85D26508E83_1507149579 = packageInfo;
        } //End block
        addTaint(aInfo.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(baseLoader.getTaint());
        addTaint(securityViolation);
        addTaint(includeCode);
        varB4EAC82CA7396A68D541C85D26508E83_1507149579.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1507149579;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.663 -0400", hash_original_method = "F0BED1934E92681B3C0E496CA2259BFD", hash_generated_method = "E2A2E00E5F48A8EC03CADD850CBE0CBF")
    public ApplicationThread getApplicationThread() {
        ApplicationThread varB4EAC82CA7396A68D541C85D26508E83_1376385029 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1376385029 = mAppThread;
        varB4EAC82CA7396A68D541C85D26508E83_1376385029.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1376385029;
        // ---------- Original Method ----------
        //return mAppThread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.677 -0400", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "F5D3E6129A53DEA6A4C607578AD10A73")
    public Instrumentation getInstrumentation() {
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_816534421 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_816534421 = mInstrumentation;
        varB4EAC82CA7396A68D541C85D26508E83_816534421.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_816534421;
        // ---------- Original Method ----------
        //return mInstrumentation;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.688 -0400", hash_original_method = "9032A5E826B7A6BB9A1848729A4BF06F", hash_generated_method = "04A2A70E4C5D0129E4713E4055B1161E")
    public Configuration getConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1742652076 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1742652076 = mResConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_1742652076.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1742652076;
        // ---------- Original Method ----------
        //return mResConfiguration;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.690 -0400", hash_original_method = "BB8D8D9198132B7570723812CBBB4B98", hash_generated_method = "5986904030D25CE3B442D55E33CE040C")
    public boolean isProfiling() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_79050440 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_79050440;
        // ---------- Original Method ----------
        //return mProfiler != null && mProfiler.profileFile != null
                //&& mProfiler.profileFd == null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.697 -0400", hash_original_method = "DE9E88BCF6C439479F5E5429ED790EB6", hash_generated_method = "3C533B0BAC4573FC8F8E83BD54A0F82D")
    public String getProfileFilePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1137484176 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1137484176 = mProfiler.profileFile;
        varB4EAC82CA7396A68D541C85D26508E83_1137484176.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137484176;
        // ---------- Original Method ----------
        //return mProfiler.profileFile;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.717 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "BD88054A5E19B52BBCB2B85FA383329B")
    public Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_2076553144 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2076553144 = mLooper;
        varB4EAC82CA7396A68D541C85D26508E83_2076553144.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2076553144;
        // ---------- Original Method ----------
        //return mLooper;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.720 -0400", hash_original_method = "BED0801CDE1100B1F268B3031343DFA4", hash_generated_method = "7B8E9A09A783102DC8A7DCDFC81C869D")
    public Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_360951318 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_360951318 = mInitialApplication;
        varB4EAC82CA7396A68D541C85D26508E83_360951318.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_360951318;
        // ---------- Original Method ----------
        //return mInitialApplication;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.754 -0400", hash_original_method = "5878D065A1BC5C9B3897192B88F09BB5", hash_generated_method = "286AF46A9594ABF94A0D0CCFA0BD42E5")
    public String getProcessName() {
        String varB4EAC82CA7396A68D541C85D26508E83_828203898 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_828203898 = mBoundApplication.processName;
        varB4EAC82CA7396A68D541C85D26508E83_828203898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_828203898;
        // ---------- Original Method ----------
        //return mBoundApplication.processName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.772 -0400", hash_original_method = "67B7F6B98B8791421AA33911A41FCF20", hash_generated_method = "E4A78917B917CDB5B1605A9CBC644FD8")
    public ContextImpl getSystemContext() {
        ContextImpl varB4EAC82CA7396A68D541C85D26508E83_2067888340 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2067888340 = mSystemContext;
        varB4EAC82CA7396A68D541C85D26508E83_2067888340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2067888340;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.774 -0400", hash_original_method = "AC12C154682E9BD06E6B4A91255348E3", hash_generated_method = "6ACAE2CB48B56E0D7508768B8BB21653")
    public void installSystemApplicationInfo(ApplicationInfo info) {
        {
            ContextImpl context;
            context = getSystemContext();
            context.init(new LoadedApk(this, "android", context, info,
                    CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            mProfiler = new Profiler();
        } //End block
        addTaint(info.getTaint());
        // ---------- Original Method ----------
        //synchronized (this) {
            //ContextImpl context = getSystemContext();
            //context.init(new LoadedApk(this, "android", context, info,
                    //CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            //mProfiler = new Profiler();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.786 -0400", hash_original_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15", hash_generated_method = "93C8069C63CC057876DD921F32F06D0F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.805 -0400", hash_original_method = "9194C167DA959B824F2056B7870F9862", hash_generated_method = "C950B3F99143F6F5E96E0A1201B207BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.811 -0400", hash_original_method = "418A9C1DFD1D7F21CC468D764B344F26", hash_generated_method = "DAEBA60FFC284CD27BC815F3423B1DBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.817 -0400", hash_original_method = "7E176906E0A5888F6535695D6EB5B115", hash_generated_method = "A6215B26D22BD65E2363F54C0967A5A4")
     void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        long now;
        now = SystemClock.uptimeMillis();
        {
            boolean varE184117867CF0C26F2EFEE16CB7C3505_1380928468 = ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.827 -0400", hash_original_method = "BC7C90866968540D7B885FF1F76E8E09", hash_generated_method = "EED42570B03829B8294BF1610344550E")
    public void registerOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            ArrayList<OnActivityPausedListener> list;
            list = mOnPauseListeners.get(activity);
            {
                list = new ArrayList<OnActivityPausedListener>();
                mOnPauseListeners.put(activity, list);
            } //End block
            list.add(listener);
        } //End block
        addTaint(activity.getTaint());
        addTaint(listener.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.829 -0400", hash_original_method = "A666FB211AE0A9537AAE3A42A197A4A4", hash_generated_method = "22D4BEC5FDC7F7BB6D84467F81DE00F0")
    public void unregisterOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        {
            ArrayList<OnActivityPausedListener> list;
            list = mOnPauseListeners.get(activity);
            {
                list.remove(listener);
            } //End block
        } //End block
        addTaint(activity.getTaint());
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //synchronized (mOnPauseListeners) {
            //ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            //if (list != null) {
                //list.remove(listener);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.897 -0400", hash_original_method = "FA6ACBD6D6B2F04759E1E44999782C17", hash_generated_method = "5298222E223A1F05550E2EBA35A6558F")
    public final ActivityInfo resolveActivityInfo(Intent intent) {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1885993702 = null; //Variable for return #1
        ActivityInfo aInfo;
        aInfo = intent.resolveActivityInfo(
                mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        {
            Instrumentation.checkStartActivityResult(
                    IActivityManager.START_CLASS_NOT_FOUND, intent);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1885993702 = aInfo;
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1885993702.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1885993702;
        // ---------- Original Method ----------
        //ActivityInfo aInfo = intent.resolveActivityInfo(
                //mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        //if (aInfo == null) {
            //Instrumentation.checkStartActivityResult(
                    //IActivityManager.START_CLASS_NOT_FOUND, intent);
        //}
        //return aInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.912 -0400", hash_original_method = "52193E396925A8581791167FBC0A1FC9", hash_generated_method = "595F45DD27D408E8417D06A38FACAFD1")
    public final Activity startActivityNow(Activity parent, String id,
        Intent intent, ActivityInfo activityInfo, IBinder token, Bundle state,
        Activity.NonConfigurationInstances lastNonConfigurationInstances) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_772519788 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_772519788 = performLaunchActivity(r, null);
        addTaint(parent.getTaint());
        addTaint(id.getTaint());
        addTaint(intent.getTaint());
        addTaint(activityInfo.getTaint());
        addTaint(token.getTaint());
        addTaint(state.getTaint());
        addTaint(lastNonConfigurationInstances.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_772519788.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_772519788;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.915 -0400", hash_original_method = "E4DB0C38EE0152F49C4586AFA6AD83D1", hash_generated_method = "7228BBBE829C53A286B789B5DCDA4356")
    public final Activity getActivity(IBinder token) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_2076090491 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2076090491 = mActivities.get(token).activity;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2076090491.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2076090491;
        // ---------- Original Method ----------
        //return mActivities.get(token).activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.943 -0400", hash_original_method = "46F0209236B49884D3899FCB9A0A8CD2", hash_generated_method = "AF8A783F55A3190950C6CCE680B5A30C")
    public final void sendActivityResult(
            IBinder token, String id, int requestCode,
            int resultCode, Intent data) {
        ArrayList<ResultInfo> list;
        list = new ArrayList<ResultInfo>();
        list.add(new ResultInfo(id, requestCode, resultCode, data));
        mAppThread.scheduleSendResult(token, list);
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //if (DEBUG_RESULTS) Slog.v(TAG, "sendActivityResult: id=" + id
                //+ " req=" + requestCode + " res=" + resultCode + " data=" + data);
        //ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        //list.add(new ResultInfo(id, requestCode, resultCode, data));
        //mAppThread.scheduleSendResult(token, list);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.945 -0400", hash_original_method = "04C4A68B1E80544C50165B2C1F09966C", hash_generated_method = "321706A67BED54A5A8D03B480A5D0B66")
    private void queueOrSendMessage(int what, Object obj) {
        queueOrSendMessage(what, obj, 0, 0);
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.972 -0400", hash_original_method = "3163B4D830BC02309EB9FA4093F38166", hash_generated_method = "65054CEA9CE759579BC78585AFB485B4")
    private void queueOrSendMessage(int what, Object obj, int arg1) {
        queueOrSendMessage(what, obj, arg1, 0);
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(arg1);
        // ---------- Original Method ----------
        //queueOrSendMessage(what, obj, arg1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.975 -0400", hash_original_method = "BA532BAA145C03E1DD34B30EBC725387", hash_generated_method = "87F8248745A18F376D0771B00E6DD62F")
    private void queueOrSendMessage(int what, Object obj, int arg1, int arg2) {
        {
            Message msg;
            msg = Message.obtain();
            msg.what = what;
            msg.obj = obj;
            msg.arg1 = arg1;
            msg.arg2 = arg2;
            mH.sendMessage(msg);
        } //End block
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(arg1);
        addTaint(arg2);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.997 -0400", hash_original_method = "15BD644AA17343360FD7D474ECDA0BC6", hash_generated_method = "11F16F3EECAF104C0A75ABABE18FA4EC")
    final void scheduleContextCleanup(ContextImpl context, String who,
            String what) {
        ContextCleanupInfo cci;
        cci = new ContextCleanupInfo();
        cci.context = context;
        cci.who = who;
        cci.what = what;
        queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
        addTaint(context.getTaint());
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //ContextCleanupInfo cci = new ContextCleanupInfo();
        //cci.context = context;
        //cci.who = who;
        //cci.what = what;
        //queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.054 -0400", hash_original_method = "C9C4D84CF5E4E5BEF4E002420AA42B4A", hash_generated_method = "E689890E28C41C670277929ECABF154B")
    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1762844768 = null; //Variable for return #1
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
                boolean var8E41159D9268684301886771AE50E678_1429109619 = (!mInstrumentation.onException(activity, e));
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
                boolean var8E41159D9268684301886771AE50E678_689993667 = (!mInstrumentation.onException(activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to start activity " + component
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1762844768 = activity;
        addTaint(r.getTaint());
        addTaint(customIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1762844768.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1762844768;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.086 -0400", hash_original_method = "483F7FDC9359FE0D21A4FBFB307EF0CA", hash_generated_method = "2A38E90E77FDDB6D072450A3344DBD46")
    private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1783061876 = (!mInstrumentation.onException(r.activity, e));
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
        addTaint(customIntent.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.096 -0400", hash_original_method = "089DA2DACAED1790C29E22F2D6A7A046", hash_generated_method = "7A7A78F9621344BD7B410CC56D3D08F0")
    private void deliverNewIntents(ActivityClientRecord r,
            List<Intent> intents) {
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
        addTaint(r.getTaint());
        addTaint(intents.getTaint());
        // ---------- Original Method ----------
        //final int N = intents.size();
        //for (int i=0; i<N; i++) {
            //Intent intent = intents.get(i);
            //intent.setExtrasClassLoader(r.activity.getClassLoader());
            //r.activity.mFragments.noteStateNotSaved();
            //mInstrumentation.callActivityOnNewIntent(r.activity, intent);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.114 -0400", hash_original_method = "62C39F1A7060D00626ABC1EA40393902", hash_generated_method = "C4C0537426BA028B93DDDBFF7CAFDB43")
    public final void performNewIntents(IBinder token,
            List<Intent> intents) {
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
        addTaint(token.getTaint());
        addTaint(intents.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.119 -0400", hash_original_method = "3340D70EC7FD056C28E3BD0AF1C7CC94", hash_generated_method = "F53E80B90447BEAED725633B8B7CEF50")
    private void handleNewIntent(NewIntentData data) {
        performNewIntents(data.token, data.intents);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //performNewIntents(data.token, data.intents);
    }

    
        public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.143 -0400", hash_original_method = "3D8204A3B4D4C5B7C8FEA568D86F5418", hash_generated_method = "0A3AAED73836F4537504B0980124B7A1")
    private void handleReceiver(ReceiverData data) {
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
                boolean varE107D295AE6781FEBA130F0CDDDA8A51_375268246 = (!mInstrumentation.onException(receiver, e));
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
            boolean var198BEFC4677783C257791C95882C8BD8_969809034 = (receiver.getPendingResult() != null);
            {
                data.finish();
            } //End block
        } //End collapsed parenthetic
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.153 -0400", hash_original_method = "F9FD1947DE4D383F90C08BC5B81CEB33", hash_generated_method = "0BF97CC301545E2479A96296A7060751")
    private void handleCreateBackupAgent(CreateBackupAgentData data) {
        unscheduleGcIdler();
        LoadedApk packageInfo;
        packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName;
        packageName = packageInfo.mPackageName;
        {
            boolean var2036584F8EC354D6E6901E916B116B68_993317549 = (mBackupAgents.get(packageName) != null);
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
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.174 -0400", hash_original_method = "F45834CE0FCB2021DEF63803688239C3", hash_generated_method = "0AD7404B1542089D34EDA60050F63971")
    private void handleDestroyBackupAgent(CreateBackupAgentData data) {
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
        addTaint(data.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.205 -0400", hash_original_method = "77CEB6B4E506F7F39264B1FEFD4EC387", hash_generated_method = "E2C3E528ED06D53FDE792D6425BA81A2")
    private void handleCreateService(CreateServiceData data) {
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
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_1319634969 = (!mInstrumentation.onException(service, e));
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
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_327168002 = (!mInstrumentation.onException(service, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to create service " + data.info.name
                    + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.220 -0400", hash_original_method = "881D5FBA45CBA067F129D10745838607", hash_generated_method = "02AEE4200E0122654EDB4A0C30CEA823")
    private void handleBindService(BindServiceData data) {
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
                    boolean var10690A467C953EA99805B9012CAE2444_999256559 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to bind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.235 -0400", hash_original_method = "2796BE6EE721B85B28BB6DBD3B4C5C51", hash_generated_method = "B6969883B4A0AC0197F49BC5A5A403E6")
    private void handleUnbindService(BindServiceData data) {
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
                    boolean var10690A467C953EA99805B9012CAE2444_1706398431 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to unbind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.243 -0400", hash_original_method = "1C18D37F75673CCCBD9C372D3BFFD82C", hash_generated_method = "08C7214290960AD452A639B61FAA9B6F")
    private void handleDumpService(DumpComponentInfo info) {
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
        addTaint(info.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.245 -0400", hash_original_method = "126292FF06E700D8C53E21C56EE062B7", hash_generated_method = "2198A530484F6B6002CA7663430F83AB")
    private void handleDumpActivity(DumpComponentInfo info) {
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
        addTaint(info.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.268 -0400", hash_original_method = "7729FDAE3B00ADA3C236E33577FF6666", hash_generated_method = "3EE366F6C889D8F7D726CBB51F9C9BBB")
    private void handleServiceArgs(ServiceArgsData data) {
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
                    boolean var10690A467C953EA99805B9012CAE2444_272011090 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to start service " + s
                            + " with " + data.args + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.277 -0400", hash_original_method = "E9A561F96B3BEE10BDD2A8F223813D32", hash_generated_method = "3645164D9FEE8DBE020C77B23E036C86")
    private void handleStopService(IBinder token) {
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
                    boolean var10690A467C953EA99805B9012CAE2444_1176642396 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to stop service " + s
                            + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.422 -0400", hash_original_method = "821CC6EDFD77BBF57472742A46BD9804", hash_generated_method = "093235D7825B6E2D79860CF540F94728")
    public final ActivityClientRecord performResumeActivity(IBinder token,
            boolean clearHide) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_1794075882 = null; //Variable for return #1
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
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_8441498 = (!mInstrumentation.onException(r.activity, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to resume activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1794075882 = r;
        addTaint(token.getTaint());
        addTaint(clearHide);
        varB4EAC82CA7396A68D541C85D26508E83_1794075882.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1794075882;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.446 -0400", hash_original_method = "3389EE310594E6487CC378BBAF5D49AF", hash_generated_method = "7D3DE13514B2BF8E83BBD88222566573")
    final void cleanUpPendingRemoveWindows(ActivityClientRecord r) {
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
        addTaint(r.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.487 -0400", hash_original_method = "E7E626438598608F65C9E3AAFD52E1D3", hash_generated_method = "1AEA41B638B696AD66C452D2FA9F2D81")
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
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
        addTaint(token.getTaint());
        addTaint(clearHide);
        addTaint(isForward);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.515 -0400", hash_original_method = "DA54714D7ABECA1149DF2EBB4CB12B75", hash_generated_method = "9F7C26A68001F46D72A0359492A39539")
    private Bitmap createThumbnailBitmap(ActivityClientRecord r) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1883926498 = null; //Variable for return #1
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
                    boolean varCCF6BFA25B9B33C500993008D9DBEDE9_2101362443 = (!r.activity.onCreateThumbnail(thumbnail, cv));
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
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_1168338665 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create thumbnail of "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } //End block
            } //End collapsed parenthetic
            thumbnail = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1883926498 = thumbnail;
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1883926498.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883926498;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.518 -0400", hash_original_method = "E5BE16D2C462200A7B0F213AB5290C46", hash_generated_method = "18785B0F6A2A6C5495BA36E0D89F5EBF")
    private void handlePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            {
                performUserLeavingActivity(r);
            } //End block
            r.activity.mConfigChangeFlags |= configChanges;
            performPauseActivity(token, finished, r.isPreHoneycomb());
            {
                boolean varC0947985E80A11FEDC8508BAA28B8037_1800220076 = (r.isPreHoneycomb());
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
        addTaint(token.getTaint());
        addTaint(finished);
        addTaint(userLeaving);
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.522 -0400", hash_original_method = "E51B505D442E84A2F592A34137ABD72B", hash_generated_method = "69B5AEACF21357C47F1820277D206195")
    final void performUserLeavingActivity(ActivityClientRecord r) {
        mInstrumentation.callActivityOnUserLeaving(r.activity);
        addTaint(r.getTaint());
        // ---------- Original Method ----------
        //mInstrumentation.callActivityOnUserLeaving(r.activity);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.537 -0400", hash_original_method = "2E97B5DEF88E402FCA1661B4F9DB23CB", hash_generated_method = "FDE73FDC9756FB58E0763C8F6B3CB968")
    final Bundle performPauseActivity(IBinder token, boolean finished,
            boolean saveState) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_211600331 = null; //Variable for return #1
        ActivityClientRecord r;
        r = mActivities.get(token);
        varB4EAC82CA7396A68D541C85D26508E83_211600331 = r != null ? performPauseActivity(r, finished, saveState) : null;
        addTaint(token.getTaint());
        addTaint(finished);
        addTaint(saveState);
        varB4EAC82CA7396A68D541C85D26508E83_211600331.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_211600331;
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //return r != null ? performPauseActivity(r, finished, saveState) : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.554 -0400", hash_original_method = "48F314FABF09550D34AFCF3A61EA40AB", hash_generated_method = "CBEDC08982A93777A799CE38273B9C2A")
    final Bundle performPauseActivity(ActivityClientRecord r, boolean finished,
            boolean saveState) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_2058622875 = null; //Variable for return #1
        Bundle varB4EAC82CA7396A68D541C85D26508E83_831940713 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_2058622875 = null;
            } //End block
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
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_621530204 = (!mInstrumentation.onException(r.activity, e));
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
        varB4EAC82CA7396A68D541C85D26508E83_831940713 = state;
        addTaint(r.getTaint());
        addTaint(finished);
        addTaint(saveState);
        Bundle varA7E53CE21691AB073D9660D615818899_489039349; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_489039349 = varB4EAC82CA7396A68D541C85D26508E83_2058622875;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_489039349 = varB4EAC82CA7396A68D541C85D26508E83_831940713;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_489039349.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_489039349;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.562 -0400", hash_original_method = "16A67002319514C641569BB2AD572A0E", hash_generated_method = "D87766B98AF24A6D35540E2DEE61B406")
    final void performStopActivity(IBinder token, boolean saveState) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        performStopActivityInner(r, null, false, saveState);
        addTaint(token.getTaint());
        addTaint(saveState);
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //performStopActivityInner(r, null, false, saveState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.591 -0400", hash_original_method = "9D7845EB7E019C62C91AEEFF3F12D0E4", hash_generated_method = "753B713768D541F73327ECAC0208CD9D")
    private void performStopActivityInner(ActivityClientRecord r,
            StopInfo info, boolean keepShown, boolean saveState) {
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_2121449630 = (!mInstrumentation.onException(r.activity, e));
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_757618253 = (!mInstrumentation.onException(r.activity, e));
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
        addTaint(r.getTaint());
        addTaint(info.getTaint());
        addTaint(keepShown);
        addTaint(saveState);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.601 -0400", hash_original_method = "A6B6099E264273A69E686CA5F8880A0F", hash_generated_method = "FA23F03AEDBB60FC96905062179ED413")
    private void updateVisibility(ActivityClientRecord r, boolean show) {
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
        addTaint(r.getTaint());
        addTaint(show);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.632 -0400", hash_original_method = "5B5FF681D8D2131B5D84BD48CB5679C6", hash_generated_method = "C65EF3E4CCD27D471AD9E52E55C96C8B")
    private void handleStopActivity(IBinder token, boolean show, int configChanges) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        r.activity.mConfigChangeFlags |= configChanges;
        StopInfo info;
        info = new StopInfo();
        performStopActivityInner(r, info, show, true);
        updateVisibility(r, show);
        {
            boolean varF98050B23FC967ED8AC6A2F93F8DF261_550637458 = (!r.isPreHoneycomb());
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
        addTaint(token.getTaint());
        addTaint(show);
        addTaint(configChanges);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.634 -0400", hash_original_method = "F0D1B8DFE218B8E130C145F907A20AA2", hash_generated_method = "80E2731BDD8B10E61C5CF6DCDC277F80")
    final void performRestartActivity(IBinder token) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            r.activity.performRestart();
            r.stopped = false;
        } //End block
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r.stopped) {
            //r.activity.performRestart();
            //r.stopped = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.649 -0400", hash_original_method = "6AC1F9C414377243EFD072AEBA5D0138", hash_generated_method = "0B44D2AABCC78512B21D36C819D9E559")
    private void handleWindowVisibility(IBinder token, boolean show) {
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
        addTaint(token.getTaint());
        addTaint(show);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.658 -0400", hash_original_method = "EAD4881422CEC6751FCD8576FDC7454E", hash_generated_method = "28733AA371D64B4D93F230D225286A49")
    private void handleSleeping(IBinder token, boolean sleeping) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        {
            {
                boolean var90CCE8F8E1AD80CE3C0937C3672DBEB8_715924755 = (!r.stopped && !r.isPreHoneycomb());
                {
                    try 
                    {
                        r.activity.performStop();
                    } //End block
                    catch (Exception e)
                    {
                        {
                            boolean varACA7CC68DADC2688CDBF4B35E8827724_1576534440 = (!mInstrumentation.onException(r.activity, e));
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
                boolean varC7408144C59FFB3C551D3072EB04F87F_1708001039 = (!r.isPreHoneycomb());
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
        addTaint(token.getTaint());
        addTaint(sleeping);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.676 -0400", hash_original_method = "E4614A97277DCEBAE71CAB13BCF3AEA6", hash_generated_method = "4309DE4D4EAD7AE9AC86B020D9DAC4E6")
    private void handleSetCoreSettings(Bundle coreSettings) {
        {
            mCoreSettings = coreSettings;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //mCoreSettings = coreSettings;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.680 -0400", hash_original_method = "CFE517344EE2BFA081F85835A58153DF", hash_generated_method = "D1338943B76F1DF65B7422CB6AF4E2CE")
    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData data) {
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
        addTaint(data.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.701 -0400", hash_original_method = "02C0B6EC41B1BF345DD1D4B6B6C7E1EA", hash_generated_method = "5EF10A48D9053F32194C6436D6F2B599")
    private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1185588709 = (!mInstrumentation.onException(r.activity, e));
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
        addTaint(r.getTaint());
        addTaint(results.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.704 -0400", hash_original_method = "132B22472693443B534F2F702D692F04", hash_generated_method = "CB2075C3BA179DCE30CE1FCC10994763")
    private void handleSendResult(ResultData res) {
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1963287306 = (!mInstrumentation.onException(r.activity, e));
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
        addTaint(res.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.728 -0400", hash_original_method = "44788E1192B2AF3D6F2EAE0CA2032491", hash_generated_method = "E47A9717FA8E07FC576F815BAA11A3BB")
    public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_565705741 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_565705741 = performDestroyActivity(token, finishing, 0, false);
        addTaint(token.getTaint());
        addTaint(finishing);
        varB4EAC82CA7396A68D541C85D26508E83_565705741.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_565705741;
        // ---------- Original Method ----------
        //return performDestroyActivity(token, finishing, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.770 -0400", hash_original_method = "C0523473C414844F9752EDA7A2CAF03B", hash_generated_method = "30C88602EC463151E4937AAAA1674614")
    private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_1853553419 = null; //Variable for return #1
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1648320162 = (!mInstrumentation.onException(r.activity, e));
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1592751187 = (!mInstrumentation.onException(r.activity, e));
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
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1137501375 = (!mInstrumentation.onException(r.activity, e));
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
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_780232242 = (!mInstrumentation.onException(r.activity, e));
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
        varB4EAC82CA7396A68D541C85D26508E83_1853553419 = r;
        addTaint(token.getTaint());
        addTaint(finishing);
        addTaint(configChanges);
        addTaint(getNonConfigInstance);
        varB4EAC82CA7396A68D541C85D26508E83_1853553419.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1853553419;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.788 -0400", hash_original_method = "FF5883360F029BC934513AEE9A22C396", hash_generated_method = "5A2213E881FE692E513ED1B286682B97")
    private void handleDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
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
        addTaint(token.getTaint());
        addTaint(finishing);
        addTaint(configChanges);
        addTaint(getNonConfigInstance);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.836 -0400", hash_original_method = "A011A63AC4A3DA99018317E87A8885A6", hash_generated_method = "89171692E8FD6922C6049F45DF798505")
    public final void requestRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config,
            boolean fromServer) {
        ActivityClientRecord target;
        target = null;
        {
            {
                int i;
                i = 0;
                boolean varA731E4137509ACE9A9EB058DA6597B93_1963262070 = (i<mRelaunchingActivities.size());
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
        addTaint(token.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(pendingNewIntents.getTaint());
        addTaint(configChanges);
        addTaint(notResumed);
        addTaint(config.getTaint());
        addTaint(fromServer);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.880 -0400", hash_original_method = "BE5C8E93A13CCFB0B92460FEFD999D51", hash_generated_method = "A586B4203CDF300A9905CCCEDFC0986B")
    private void handleRelaunchActivity(ActivityClientRecord tmp) {
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
                boolean var0FC6F86F9662A446DFA38F41BE5B339F_1212864580 = (mConfiguration == null
                    || (tmp.createdConfig.isOtherSeqNewer(mConfiguration)
                            && mConfiguration.diff(tmp.createdConfig) != 0));
                {
                    {
                        boolean var1F3B64B07ED4C1BD68FE8B6CE0CE3159_1585176650 = (changedConfig == null
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
            boolean var180BDEFD354F97351DFD30CDB936034A_1871670542 = (r.state == null && !r.stopped && !r.isPreHoneycomb());
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
        addTaint(tmp.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.892 -0400", hash_original_method = "D80F947211B8AA9FA3600ABD6DD9A5E5", hash_generated_method = "01721ADC26F1E9A92D52564B9DED9414")
    private void handleRequestThumbnail(IBinder token) {
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
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_1549417060 = (!mInstrumentation.onException(r.activity, e));
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
        addTaint(token.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.925 -0400", hash_original_method = "FB356249739137DBEEC4A6A95AF7FF01", hash_generated_method = "D9A4C69D470037E3A14B5F753CDAB74C")
     ArrayList<ComponentCallbacks2> collectComponentCallbacksLocked(
            boolean allActivities, Configuration newConfig) {
        ArrayList<ComponentCallbacks2> varB4EAC82CA7396A68D541C85D26508E83_305443657 = null; //Variable for return #1
        ArrayList<ComponentCallbacks2> callbacks;
        callbacks = new ArrayList<ComponentCallbacks2>();
        {
            boolean var861DB40CD6AE57E4F0E83CF55916E1AF_223536840 = (mActivities.size() > 0);
            {
                Iterator<ActivityClientRecord> it;
                it = mActivities.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1533190808 = (it.hasNext());
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
            boolean var5A1C82E33C6D4B3400958A37BAFF4F9C_554686795 = (mServices.size() > 0);
            {
                Iterator<Service> it;
                it = mServices.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_1119138469 = (it.hasNext());
                    {
                        callbacks.add(it.next());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            {
                boolean var164809B4E437753E4C2094F777B6EF33_317882602 = (mLocalProviders.size() > 0);
                {
                    Iterator<ProviderClientRecord> it;
                    it = mLocalProviders.values().iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_1972403053 = (it.hasNext());
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
        varB4EAC82CA7396A68D541C85D26508E83_305443657 = callbacks;
        addTaint(allActivities);
        addTaint(newConfig.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_305443657.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_305443657;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.943 -0400", hash_original_method = "EE8F576B02EBE8F159FE2A319294FB0B", hash_generated_method = "7E35E8A329A1331E4F50F7EB47D811F7")
    private final void performConfigurationChanged(
            ComponentCallbacks2 cb, Configuration config) {
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
                    boolean varF0E6ABDF26E6C0B0FD2D021EE0A6E062_794521822 = ((~activity.mActivityInfo.getRealConfigChanged() & diff) == 0);
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
        addTaint(cb.getTaint());
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.967 -0400", hash_original_method = "7998F4E95C6128D4C656838AA6A46FDD", hash_generated_method = "9E04B811244F781CE0CEB408264E0F79")
    public final void applyConfigurationToResources(Configuration config) {
        {
            applyConfigurationToResourcesLocked(config, null);
        } //End block
        addTaint(config.getTaint());
        // ---------- Original Method ----------
        //synchronized (mPackages) {
            //applyConfigurationToResourcesLocked(config, null);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.971 -0400", hash_original_method = "EEF98A9F112FD55BEEF8F44AEC4B59F9", hash_generated_method = "BCE91FD47DC1864D2E1828D1B166E132")
    final boolean applyConfigurationToResourcesLocked(Configuration config,
            CompatibilityInfo compat) {
        {
            mResConfiguration = new Configuration();
        } //End block
        {
            boolean varDD88D6DA3508C081DB3FE4EFF9E62042_1815346590 = (!mResConfiguration.isOtherSeqNewer(config) && compat == null);
        } //End collapsed parenthetic
        int changes;
        changes = mResConfiguration.updateFrom(config);
        DisplayMetrics dm;
        dm = getDisplayMetricsLocked(null, true);
        {
            boolean var389DB0238F3963595A3670D175566873_1545511938 = (compat != null && (mResCompatibilityInfo == null ||
                !mResCompatibilityInfo.equals(compat)));
            {
                mResCompatibilityInfo = compat;
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
            boolean var03729FD53960D8DCA3A41A13A0229637_1721844986 = (it.hasNext());
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
        addTaint(config.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273720678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273720678;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.994 -0400", hash_original_method = "725924C293B055D0DF33B7EFFEB77D1D", hash_generated_method = "7BED96CFE3FB92B284C223247AFF1BD6")
    final Configuration applyCompatConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1921098096 = null; //Variable for return #1
        Configuration config;
        config = mConfiguration;
        {
            mCompatConfiguration = new Configuration();
        } //End block
        mCompatConfiguration.setTo(mConfiguration);
        {
            boolean varC23E243EBF9A9F6453914CEF4EFB48AF_1279403104 = (mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen());
            {
                mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
                config = mCompatConfiguration;
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1921098096 = config;
        varB4EAC82CA7396A68D541C85D26508E83_1921098096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1921098096;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.010 -0400", hash_original_method = "113EE31E90E397ADB444BCE89226F34D", hash_generated_method = "17FD39B5E67A91136DC83416938778B1")
    final void handleConfigurationChanged(Configuration config, CompatibilityInfo compat) {
        ArrayList<ComponentCallbacks2> callbacks;
        callbacks = null;
        {
            {
                {
                    boolean var7FB57B73DAED6E7419FC890952146106_2095542054 = (!mPendingConfiguration.isOtherSeqNewer(config));
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
                boolean var76764A772B13C26291B0BB9B4382DB3B_712761013 = (!mConfiguration.isOtherSeqNewer(config) && compat == null);
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
        addTaint(config.getTaint());
        addTaint(compat.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.027 -0400", hash_original_method = "BCC706E36DA945D7B18FA237C2CE8FDE", hash_generated_method = "59D795110A8F807A8CAEF105D86B0646")
    final void handleActivityConfigurationChanged(IBinder token) {
        ActivityClientRecord r;
        r = mActivities.get(token);
        performConfigurationChanged(r.activity, mCompatConfiguration);
        addTaint(token.getTaint());
        // ---------- Original Method ----------
        //ActivityClientRecord r = mActivities.get(token);
        //if (r == null || r.activity == null) {
            //return;
        //}
        //if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handle activity config changed: "
                //+ r.activityInfo.name);
        //performConfigurationChanged(r.activity, mCompatConfiguration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.036 -0400", hash_original_method = "381D38D2D5D4A7D408E3117408C36DEC", hash_generated_method = "9E1B895545420413D21683FF197B4A0F")
    final void handleProfilerControl(boolean start, ProfilerControlData pcd, int profileType) {
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
        addTaint(start);
        addTaint(pcd.getTaint());
        addTaint(profileType);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.038 -0400", hash_original_method = "34F4499A4B96EEF8A91ACC379A0CD361", hash_generated_method = "B32EC387A1CA21249D561868D95EED4F")
    final void handleDumpHeap(boolean managed, DumpHeapData dhd) {
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
        addTaint(managed);
        addTaint(dhd.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.061 -0400", hash_original_method = "44425A5A4DA98E1612A84EA820E43FA0", hash_generated_method = "D9FD32851D10D57DBA0B17A8C0C1DED5")
    final void handleDispatchPackageBroadcast(int cmd, String[] packages) {
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
                            boolean var452303427881308C0907EF2BFCBFBC97_1839425948 = (ref != null && ref.get() != null);
                            {
                                hasPkgInfo = true;
                            } //End block
                            {
                                ref = mResourcePackages.get(packages[i]);
                                {
                                    boolean var35FA527C419A116D546FBD420F0F02FA_1334040049 = (ref != null && ref.get() != null);
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
        addTaint(cmd);
        addTaint(packages[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.078 -0400", hash_original_method = "A02231B2047F154A7A69F70A3ED846FE", hash_generated_method = "B06224C1250BF69CA43348F225EA5680")
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
            boolean var83DFAB275ACAE9E6E683928CEC618B77_2123391771 = (Process.myUid() != Process.SYSTEM_UID);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.080 -0400", hash_original_method = "23BC0760ADA981D880A84DB7A1CF33BD", hash_generated_method = "E4CB875C56C47B6A265767D68D076DA5")
    final void handleTrimMemory(int level) {
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
        addTaint(level);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.085 -0400", hash_original_method = "E6BF73423380262DF6FF59682ACDE1E2", hash_generated_method = "8330050FC551CA837CB450E9B226CE1C")
    private void setupGraphicsSupport(LoadedApk info) {
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
        addTaint(info.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.190 -0400", hash_original_method = "7EBE3C125D399FC9ADE021947462EA9C", hash_generated_method = "DB7D0F04C7596E3436EAE1783741B625")
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
        {
            Display display;
            display = WindowManagerImpl.getDefault().getDefaultDisplay();
            {
                boolean varF43CCBE6F4C0623498FA3D729EBA95BA_627817369 = (!ActivityManager.isHighEndGfx(display));
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
                boolean var99DF702C0466DA8314007B6FFD566CCC_577853341 = (!mInstrumentation.onException(app, e));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.208 -0400", hash_original_method = "87522E170C98EEC17A950D0CB0F18A7D", hash_generated_method = "3B148976176BFA4CA57F9ED526D8AC1D")
    final void finishInstrumentation(int resultCode, Bundle results) {
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
        addTaint(resultCode);
        addTaint(results.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.221 -0400", hash_original_method = "E6307225A7BED03273D5285E74D77996", hash_generated_method = "83E9253777A47D9C850A7A00C0B18C1F")
    private void installContentProviders(
            Context context, List<ProviderInfo> providers) {
        ArrayList<IActivityManager.ContentProviderHolder> results;
        results = new ArrayList<IActivityManager.ContentProviderHolder>();
        Iterator<ProviderInfo> i;
        i = providers.iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_2111483770 = (i.hasNext());
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
        addTaint(context.getTaint());
        addTaint(providers.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.270 -0400", hash_original_method = "F88C15CE4CC55ECD0AF9CC176F41EB20", hash_generated_method = "240294DD34C4FCE740EF12ADEC87C569")
    public final IContentProvider acquireProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1748295819 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_659271883 = null; //Variable for return #2
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_150431327 = null; //Variable for return #3
        IContentProvider provider;
        provider = acquireExistingProvider(c, name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1748295819 = provider;
        } //End block
        IActivityManager.ContentProviderHolder holder;
        holder = null;
        try 
        {
            holder = ActivityManagerNative.getDefault().getContentProvider(
                    getApplicationThread(), name);
        } //End block
        catch (RemoteException ex)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_659271883 = null;
        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_150431327 = provider;
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_1422639870; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1422639870 = varB4EAC82CA7396A68D541C85D26508E83_1748295819;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1422639870 = varB4EAC82CA7396A68D541C85D26508E83_659271883;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1422639870 = varB4EAC82CA7396A68D541C85D26508E83_150431327;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1422639870.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1422639870;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.274 -0400", hash_original_method = "D0EC607B4605DB37ABCB0EC4802499DE", hash_generated_method = "B2400B6D61958BE4CD1EA3CC16FC741F")
    public final IContentProvider acquireExistingProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1577416037 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1492587455 = null; //Variable for return #2
        {
            ProviderClientRecord pr;
            pr = mProviderMap.get(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1577416037 = null;
            } //End block
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
            varB4EAC82CA7396A68D541C85D26508E83_1492587455 = provider;
        } //End block
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_2133393923; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2133393923 = varB4EAC82CA7396A68D541C85D26508E83_1577416037;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2133393923 = varB4EAC82CA7396A68D541C85D26508E83_1492587455;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2133393923.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2133393923;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.276 -0400", hash_original_method = "570D24C9467F1DF00A050F1BB22169F2", hash_generated_method = "6EF08E016E1B83F8C43135280DACD1AA")
    public final boolean releaseProvider(IContentProvider provider) {
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
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_574388643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_574388643;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.321 -0400", hash_original_method = "26DD2496F7761FB77064EC4900EC6CC4", hash_generated_method = "97DBDA5D24DBF079B76FBC151C65095A")
    final void completeRemoveProvider(IContentProvider provider) {
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
                boolean var8492AE2C695A56B730381A28B8BA3F6D_265534457 = (iter.hasNext());
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
        addTaint(provider.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.362 -0400", hash_original_method = "89FC0B7C2EBDC1E0BBDB9AF687772CD2", hash_generated_method = "225A6A9E3055B959110C0CB21512987E")
    final void removeDeadProvider(String name, IContentProvider provider) {
        {
            ProviderClientRecord pr;
            pr = mProviderMap.get(name);
            {
                boolean var966307558E067A018FA6F5C432EE1917_567654125 = (pr != null && pr.mProvider.asBinder() == provider.asBinder());
                {
                    ProviderClientRecord removed;
                    removed = mProviderMap.remove(name);
                    {
                        removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(name.getTaint());
        addTaint(provider.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.412 -0400", hash_original_method = "54C9C23E13579DED3FD2406679DE4E02", hash_generated_method = "464A9B88A2C182388DC92671F11773E4")
    private IContentProvider installProvider(Context context,
            IContentProvider provider, ProviderInfo info,
            boolean noisy, boolean noReleaseNeeded) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_390181845 = null; //Variable for return #1
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_534991474 = null; //Variable for return #2
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1469301548 = null; //Variable for return #3
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_667146249 = null; //Variable for return #4
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_987513310 = null; //Variable for return #5
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
                boolean var91DE5B59D8254FD2545D30D7F711FB97_1910729298 = (context.getPackageName().equals(ai.packageName));
                {
                    c = context;
                } //End block
                {
                    boolean varBB822C07A468461CB214A3B461BD724D_1793757219 = (mInitialApplication != null &&
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
            {
                varB4EAC82CA7396A68D541C85D26508E83_390181845 = null;
            } //End block
            try 
            {
                java.lang.ClassLoader cl;
                cl = c.getClassLoader();
                localProvider = (ContentProvider)cl.
                    loadClass(info.name).newInstance();
                provider = localProvider.getIContentProvider();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_534991474 = null;
                } //End block
                localProvider.attachInfo(c, info);
            } //End block
            catch (java.lang.Exception e)
            {
                {
                    boolean varFB4F174495DD0F0FC2F116EBF5523752_394999933 = (!mInstrumentation.onException(null, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to get provider " + info.name
                            + ": " + e.toString(), e);
                    } //End block
                } //End collapsed parenthetic
                varB4EAC82CA7396A68D541C85D26508E83_1469301548 = null;
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
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_667146249 = null;
                            } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_987513310 = provider;
        addTaint(context.getTaint());
        addTaint(provider.getTaint());
        addTaint(info.getTaint());
        addTaint(noisy);
        addTaint(noReleaseNeeded);
        IContentProvider varA7E53CE21691AB073D9660D615818899_1080099287; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1080099287 = varB4EAC82CA7396A68D541C85D26508E83_390181845;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1080099287 = varB4EAC82CA7396A68D541C85D26508E83_534991474;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1080099287 = varB4EAC82CA7396A68D541C85D26508E83_1469301548;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1080099287 = varB4EAC82CA7396A68D541C85D26508E83_667146249;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1080099287 = varB4EAC82CA7396A68D541C85D26508E83_987513310;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1080099287.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1080099287;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.470 -0400", hash_original_method = "C124A05EAD0D975305C2EDD26DCF96DC", hash_generated_method = "88AA9B0F58902FFDDDA3E53EA2D0E901")
    private void attach(boolean system) {
        sThreadLocal.set(this);
        mSystemThread = system;
        {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.414 -0400", hash_original_method = "47807A5814B5D681B360E1F6CDD604E7", hash_generated_method = "CE4C0CC733C0731411E130B03C44D6CB")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.449 -0400", hash_original_method = "26C6C7423624E1B7694397A08E8C6CD1", hash_generated_method = "E868D9127282E2A16306E0E30A47B13B")
            public void onConfigurationChanged(Configuration newConfig) {
                //DSFIXME:  CODE0009: Possible callback target function detected
                {
                    {
                        boolean var7902634F304B837BD47B2192DBEFCA89_1389292973 = (applyConfigurationToResourcesLocked(newConfig, null));
                        {
                            {
                                boolean var4EBF8D921B272E9ECD6097B4EB42049C_1481251088 = (mPendingConfiguration == null ||
                                mPendingConfiguration.isOtherSeqNewer(newConfig));
                                {
                                    mPendingConfiguration = newConfig;
                                    queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                addTaint(newConfig.getTaint());
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.450 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
            public void onLowMemory() {
                //DSFIXME:  CODE0009: Possible callback target function detected
                // ---------- Original Method ----------
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.469 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.478 -0400", hash_original_method = "2E14593B1AB1D9A91353E1BD8215A316", hash_generated_method = "A4CE5608AD7F182D2B581B43594B9F3B")
    public final void installSystemProviders(List<ProviderInfo> providers) {
        {
            installContentProviders(mInitialApplication, providers);
        } //End block
        addTaint(providers.getTaint());
        // ---------- Original Method ----------
        //if (providers != null) {
            //installContentProviders(mInitialApplication, providers);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.495 -0400", hash_original_method = "A46DE63D351DE0CEA05BC700781E1C79", hash_generated_method = "F34022FBA5FFDC5374628B726B75120B")
    public int getIntCoreSetting(String key, int defaultValue) {
        {
            {
                int varFDEB65FAB02737F165A27EF58C1FFD56_674327337 = (mCoreSettings.getInt(key, defaultValue));
            } //End block
        } //End block
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898671099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_898671099;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.507 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.508 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.508 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.508 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "C00C2C61984260DF3B4937ADC46E8A7C")

        Bundle state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.509 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.517 -0400", hash_original_field = "05B8C74CBD96FBF2DE4C1A352702FBF4", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.518 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8772E5B00EE7781FE599C41013926102")

        Activity parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.518 -0400", hash_original_field = "6F8E7109EE5ADBADB311A9D0FBBBBC2D", hash_generated_field = "99A507AF2C301E2FF9994737D79275BB")

        String embeddedID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.519 -0400", hash_original_field = "C9A812088441D29B618CAF19775FDAA2", hash_generated_field = "2EF688309E753499C339EBE96926B7C3")

        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.519 -0400", hash_original_field = "D13C3F7BAED576768B11A714EF4D90E2", hash_generated_field = "5637B5D432947459416E03554347708E")

        boolean paused;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.530 -0400", hash_original_field = "F0A0BFE6BC7D2C58D2989034F83183E0", hash_generated_field = "B0899FB375A0A57065DA66B38777B6C0")

        boolean stopped;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.530 -0400", hash_original_field = "614AB218DE1950441B1407D6BB38AFE3", hash_generated_field = "5DCC7672BCF10641A46EAA548A687CD5")

        boolean hideForNow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.531 -0400", hash_original_field = "6D069C9B9BA8B31B534F29F6B998EB02", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.531 -0400", hash_original_field = "70155DDAAD08A53C67D84B831081C73C", hash_generated_field = "44F8DA58F1EEFDF22FCF6A1FED0376C3")

        Configuration createdConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.550 -0400", hash_original_field = "8585C121190575E017AD93490EC11357", hash_generated_field = "583CE8A57524BB39C7618CF1F2B65C96")

        ActivityClientRecord nextIdle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.551 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.551 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.552 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.568 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.568 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.569 -0400", hash_original_field = "FD5373273702F9470D1C201B33B812A0", hash_generated_field = "6FE708D4D9958EC105E3B69C43275F19")

        LoadedApk packageInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.569 -0400", hash_original_field = "3B0B9C6FBD20486E139A43FC64A202D9", hash_generated_field = "A77E9DD92A64C5F780B6000CA80182A2")

        List<ResultInfo> pendingResults;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.575 -0400", hash_original_field = "433CEFD43BB3E36958F4429303CFBDF2", hash_generated_field = "4BC30CA1B8786644C876DAF48F78533F")

        List<Intent> pendingIntents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.575 -0400", hash_original_field = "8C75492FB96D35639922DFCB4D489088", hash_generated_field = "5CE883BF4DAD47FBDAF4D2C3F7074402")

        boolean startsNotResumed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.576 -0400", hash_original_field = "4DFD186ABB3EB706F59F85400A376CE9", hash_generated_field = "8A03F39D432E8E43D36A30D2C65BF04B")

        boolean isForward;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.576 -0400", hash_original_field = "7771A08DD693060EE393D87DF30CF928", hash_generated_field = "2BC5D372006E004497C167DEE6104107")

        int pendingConfigChanges;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.590 -0400", hash_original_field = "97D2042DAB1F67D641A4735F0A59DDA4", hash_generated_field = "970B3D7A6F8A2CE63E822A10DBAD0F49")

        boolean onlyLocalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.590 -0400", hash_original_field = "FA6E167268326F793F40624DB64B3B41", hash_generated_field = "C7546AC98481F963F1798A1F44EE5004")

        View mPendingRemoveWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.591 -0400", hash_original_field = "A1EB5D2CF63EABFE576274089B0DEA1C", hash_generated_field = "651EDB05D2F89D6E111AFDE79ADF6A66")

        WindowManager mPendingRemoveWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.608 -0400", hash_original_method = "B5F524E6EAF79ED64F291F38DBCEDD1B", hash_generated_method = "1B05C37D3F960D6790EA6795720DC542")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.610 -0400", hash_original_method = "2761403398E750945AAB952EA69C6C0F", hash_generated_method = "159E524FEDF4AB1E205F407A526783B5")
        public boolean isPreHoneycomb() {
            {
                boolean var708B39EC3F85FBC7A5D34973A60AE645_1798200496 = (activity.getApplicationInfo().targetSdkVersion
                        < android.os.Build.VERSION_CODES.HONEYCOMB);
            } //End block
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_289581350 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_289581350;
            // ---------- Original Method ----------
            //if (activity != null) {
                //return activity.getApplicationInfo().targetSdkVersion
                        //< android.os.Build.VERSION_CODES.HONEYCOMB;
            //}
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.625 -0400", hash_original_method = "C4594DCD1E896B9BDB54D56E10F2B8EE", hash_generated_method = "F96A5D9A0EC78B4949B9880E6138A8A9")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_873387889 = null; //Variable for return #1
            ComponentName componentName;
            componentName = intent.getComponent();
            varB4EAC82CA7396A68D541C85D26508E83_873387889 = "ActivityRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " token=" + token + " " + (componentName == null
                        ? "no component name" : componentName.toShortString())
                + "}";
            varB4EAC82CA7396A68D541C85D26508E83_873387889.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_873387889;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.639 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

        String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.640 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "4165A1FBAFFD21863CC0EAC1937582F7")

        IContentProvider mProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.641 -0400", hash_original_field = "10F83DD9C72C654C184D34757393AB14", hash_generated_field = "7AAFFB6DED098E36BD02CC080B04AF7E")

        ContentProvider mLocalProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.661 -0400", hash_original_method = "C7097CC666CFF4D083C9B2045DB42E29", hash_generated_method = "DF4756A2C65B372E178D3BE3C4A53DC6")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.662 -0400", hash_original_method = "3801456C44CFB93A5BA86A8AB8C43B3F", hash_generated_method = "B050BAB508FED40C5C7DDCB23C41347E")
        public void binderDied() {
            removeDeadProvider(mName, mProvider);
            // ---------- Original Method ----------
            //removeDeadProvider(mName, mProvider);
        }

        
    }


    
    static final class NewIntentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.674 -0400", hash_original_field = "99F399B171645B449364ED937DFD6F10", hash_generated_field = "DCC84A2BE9F90A98827B285408558812")

        List<Intent> intents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.674 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.675 -0400", hash_original_method = "9A9162E54721E56B9804FAED427417E2", hash_generated_method = "9A9162E54721E56B9804FAED427417E2")
        public NewIntentData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.693 -0400", hash_original_method = "E9F4DBEB4C72AFF7F672A47023D2DCCE", hash_generated_method = "2500157EE8DEA942D0BFAD11831881D9")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_976022299 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_976022299 = "NewIntentData{intents=" + intents + " token=" + token + "}";
            varB4EAC82CA7396A68D541C85D26508E83_976022299.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_976022299;
            // ---------- Original Method ----------
            //return "NewIntentData{intents=" + intents + " token=" + token + "}";
        }

        
    }


    
    static final class ReceiverData extends BroadcastReceiver.PendingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.698 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.698 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "D6562EB0A3FC9B94476A16D5F303F058")

        ActivityInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.699 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.728 -0400", hash_original_method = "95DC539EA4572F0714768317249686D3", hash_generated_method = "83D54A34A23AC7CAE3151DFA2BD4FA5A")
        public  ReceiverData(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                boolean ordered, boolean sticky, IBinder token) {
            super(resultCode, resultData, resultExtras, TYPE_COMPONENT, ordered, sticky, token);
            this.intent = intent;
            addTaint(resultCode);
            addTaint(resultData.getTaint());
            addTaint(resultExtras.getTaint());
            addTaint(ordered);
            addTaint(sticky);
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //this.intent = intent;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.738 -0400", hash_original_method = "062A80C4BE8CE608AA3884983AB20A02", hash_generated_method = "CBC7CB682F845CC35DD6447F57E01BDB")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1160701543 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1160701543 = "ReceiverData{intent=" + intent + " packageName=" +
                    info.packageName + " resultCode=" + getResultCode()
                    + " resultData=" + getResultData() + " resultExtras="
                    + getResultExtras(false) + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1160701543.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1160701543;
            // ---------- Original Method ----------
            //return "ReceiverData{intent=" + intent + " packageName=" +
                    //info.packageName + " resultCode=" + getResultCode()
                    //+ " resultData=" + getResultData() + " resultExtras="
                    //+ getResultExtras(false) + "}";
        }

        
    }


    
    static final class CreateBackupAgentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.739 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.740 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.741 -0400", hash_original_field = "804191EFAC8137D8B58292EF386D75FA", hash_generated_field = "F90DF71BF48FAFE07F43CB879F966CE3")

        int backupMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.754 -0400", hash_original_method = "7F9A4ECF6FE623DBC230D640707CDFD0", hash_generated_method = "7F9A4ECF6FE623DBC230D640707CDFD0")
        public CreateBackupAgentData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.762 -0400", hash_original_method = "87705B4B5A78FEE0786C01D6E7384189", hash_generated_method = "65036E15A339F09F72C597E1F0610D4B")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_323380557 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_323380557 = "CreateBackupAgentData{appInfo=" + appInfo
                    + " backupAgent=" + appInfo.backupAgentName
                    + " mode=" + backupMode + "}";
            varB4EAC82CA7396A68D541C85D26508E83_323380557.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_323380557;
            // ---------- Original Method ----------
            //return "CreateBackupAgentData{appInfo=" + appInfo
                    //+ " backupAgent=" + appInfo.backupAgentName
                    //+ " mode=" + backupMode + "}";
        }

        
    }


    
    static final class CreateServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.773 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.773 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "4AEE41877C99C71A9296A5C433E71F7C")

        ServiceInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.774 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.783 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.784 -0400", hash_original_method = "881257217964B643C1B29F21F8324D73", hash_generated_method = "881257217964B643C1B29F21F8324D73")
        public CreateServiceData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.799 -0400", hash_original_method = "DE656B2587EA58A3FB80D8944832AD3A", hash_generated_method = "8E550C96CAAF40CBEB70C40BB6239B70")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_796218459 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_796218459 = "CreateServiceData{token=" + token + " className="
            + info.name + " packageName=" + info.packageName
            + " intent=" + intent + "}";
            varB4EAC82CA7396A68D541C85D26508E83_796218459.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_796218459;
            // ---------- Original Method ----------
            //return "CreateServiceData{token=" + token + " className="
            //+ info.name + " packageName=" + info.packageName
            //+ " intent=" + intent + "}";
        }

        
    }


    
    static final class BindServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.800 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.801 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.802 -0400", hash_original_field = "35DA50F034DA1C4AB0308E9228963716", hash_generated_field = "35FF113739960C8FEB167B42458B2109")

        boolean rebind;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.819 -0400", hash_original_method = "2B59A1695FBC674B2F74F0571D5E38A2", hash_generated_method = "2B59A1695FBC674B2F74F0571D5E38A2")
        public BindServiceData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.822 -0400", hash_original_method = "788B7BFDCE261467774852FF99962FB6", hash_generated_method = "FA2E86D0C40CD9C8FB36A7ECD52CAB24")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_70343874 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_70343874 = "BindServiceData{token=" + token + " intent=" + intent + "}";
            varB4EAC82CA7396A68D541C85D26508E83_70343874.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_70343874;
            // ---------- Original Method ----------
            //return "BindServiceData{token=" + token + " intent=" + intent + "}";
        }

        
    }


    
    static final class ServiceArgsData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.832 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.832 -0400", hash_original_field = "18114AC9833DE9BE54FC2510379F9C46", hash_generated_field = "CB66DDA6D80EB80E88BF8636FFAE2527")

        boolean taskRemoved;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.833 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.848 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.849 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "77AB5E543174DF1F66D162C0382A930F")

        Intent args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.849 -0400", hash_original_method = "103D015CCE841E84C3050E807488FBE9", hash_generated_method = "103D015CCE841E84C3050E807488FBE9")
        public ServiceArgsData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.862 -0400", hash_original_method = "9123370A477925A90205ABBEEFE44004", hash_generated_method = "CE69FEA13DFC7F9DEE5E1BB7E974A0E2")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1143215062 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1143215062 = "ServiceArgsData{token=" + token + " startId=" + startId
            + " args=" + args + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1143215062.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1143215062;
            // ---------- Original Method ----------
            //return "ServiceArgsData{token=" + token + " startId=" + startId
            //+ " args=" + args + "}";
        }

        
    }


    
    static final class AppBindData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.863 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFE674900E356A9F4BF51234744250B8")

        LoadedApk info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.863 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "182AC29DC74CEB0C6C89C5576E47A4DD")

        String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.866 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.866 -0400", hash_original_field = "29D247EE74C64366386D8D549C17162D", hash_generated_field = "7A9F4634EB01C0456156CF1B784BCEC9")

        List<ProviderInfo> providers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.867 -0400", hash_original_field = "B80C791FAFFB60831D70548CB5215902", hash_generated_field = "3F5DA88F1FEC15C88CB883D59573E813")

        ComponentName instrumentationName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.867 -0400", hash_original_field = "A787EF10308AF70C6A64332DCA7C8E51", hash_generated_field = "73077E024184109776339B9D1BEE35EB")

        Bundle instrumentationArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.868 -0400", hash_original_field = "4165C674FEE7A7791DA12B1AFD3117CF", hash_generated_field = "B075C237152068CFAEC1BD98818F5007")

        IInstrumentationWatcher instrumentationWatcher;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.868 -0400", hash_original_field = "48E635F7A84F2E705C3CC133792C2E42", hash_generated_field = "5FC68647D6D0CF439E6B829CC880890C")

        int debugMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.887 -0400", hash_original_field = "BA6ED9886C7F4DC26B56F7D1AD9427A4", hash_generated_field = "4EAC7CFAA88429E81A3DA1B88F7F0814")

        boolean restrictedBackupMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.888 -0400", hash_original_field = "23C6323BFB57BB630B8A2ECF703D6BB0", hash_generated_field = "B853B56DA62629292AFB975D2A443261")

        boolean persistent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.888 -0400", hash_original_field = "2245023265AE4CF87D02C8B6BA991139", hash_generated_field = "A3F5781DE6AF7A59A7DBAA1BECE272A9")

        Configuration config;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.889 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.890 -0400", hash_original_field = "03E5F42EE7352D707D8219D0B5A3A3D3", hash_generated_field = "DB4FDD2502B5FFC034FB83C77C56111F")

        String initProfileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.890 -0400", hash_original_field = "1A8CF268D8A31BBDEFA6FA16D91B0CEE", hash_generated_field = "D60C582964877A307BEAF4053762EF15")

        ParcelFileDescriptor initProfileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.891 -0400", hash_original_field = "56F3F00A970BDF076342D5A0780440E9", hash_generated_field = "2D2D69EB52002C7C4F13F0178D625E55")

        boolean initAutoStopProfiler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.891 -0400", hash_original_method = "EDE65A505FE77989B4B34B8F22E2D58F", hash_generated_method = "EDE65A505FE77989B4B34B8F22E2D58F")
        public AppBindData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.910 -0400", hash_original_method = "2BA8F6DB78683607CF1A79B96A9E1945", hash_generated_method = "95615D6A0C089E8A367624D099CEF4C9")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1107250981 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1107250981 = "AppBindData{appInfo=" + appInfo + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1107250981.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1107250981;
            // ---------- Original Method ----------
            //return "AppBindData{appInfo=" + appInfo + "}";
        }

        
    }


    
    static final class Profiler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.911 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.911 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.912 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.913 -0400", hash_original_field = "3CDDA3E94E1B3DFD218A9D60B8139968", hash_generated_field = "5AEBAB31656E136FF8335BF7952CBD3D")

        boolean profiling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.977 -0400", hash_original_field = "F172439EC8EE2FA7210D2763CB835A33", hash_generated_field = "CFD51622CC9205EA276B9A72B7AC1389")

        boolean handlingProfiling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.977 -0400", hash_original_method = "7B9BEA1F6EC95E751CD548D4F51680C9", hash_generated_method = "7B9BEA1F6EC95E751CD548D4F51680C9")
        public Profiler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.986 -0400", hash_original_method = "A8A96BF1FCBE3854C04202513222077A", hash_generated_method = "722B5CB8BBE43F8168FF27701087A5B0")
        public void setProfiler(String file, ParcelFileDescriptor fd) {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.999 -0400", hash_original_method = "4BADC9424DA1A3AC7F9D5563006BCE42", hash_generated_method = "717956F1062DD3A5AEC90B37F1ED3668")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.012 -0400", hash_original_method = "F0726A3E7708B3CB256CEACF5FA42FD5", hash_generated_method = "53B2FD47BCAC0373E4CFDB09F8C1864E")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.019 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.020 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.021 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

        String prefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.021 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "7F2C1FD08D9A857D4D2EDF6F9394FC1F")

        String[] args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.032 -0400", hash_original_method = "705FE87B3B944DB1E7088D167B1442FA", hash_generated_method = "705FE87B3B944DB1E7088D167B1442FA")
        public DumpComponentInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ResultData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.032 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.033 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "C3849EE0113C1C1730E99FB7C260DA4E")

        List<ResultInfo> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.044 -0400", hash_original_method = "3466C6D5CF0FEDF7456B3B9BA6367B40", hash_generated_method = "3466C6D5CF0FEDF7456B3B9BA6367B40")
        public ResultData ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.046 -0400", hash_original_method = "BA3AA15664E126972C9E79255FFB7B3E", hash_generated_method = "98215D1B5780B030656B1F0F8998102B")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_208573716 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_208573716 = "ResultData{token=" + token + " results" + results + "}";
            varB4EAC82CA7396A68D541C85D26508E83_208573716.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_208573716;
            // ---------- Original Method ----------
            //return "ResultData{token=" + token + " results" + results + "}";
        }

        
    }


    
    static final class ContextCleanupInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.047 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "C9CD4205E05705EAD2345480C07726F5")

        ContextImpl context;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.047 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "EA705FF509AF2D1BE17CB07841038A94")

        String what;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.060 -0400", hash_original_field = "53D670AF9BB16EA82E7EF41EE23EC6DF", hash_generated_field = "C4E3E8F459E3F192A7BA9767B8092770")

        String who;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.062 -0400", hash_original_method = "1364E4E916202312196441F2CD1A38A7", hash_generated_method = "1364E4E916202312196441F2CD1A38A7")
        public ContextCleanupInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ProfilerControlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.063 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.063 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.075 -0400", hash_original_method = "D11C2D1935BF651482EE891D2A926235", hash_generated_method = "D11C2D1935BF651482EE891D2A926235")
        public ProfilerControlData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class DumpHeapData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.075 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.076 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.080 -0400", hash_original_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F", hash_generated_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F")
        public DumpHeapData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class UpdateCompatibilityData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.083 -0400", hash_original_field = "A46A1BCE0B67C45BEC8F435BD5390A54", hash_generated_field = "742D0CCB1EAA4E727F9FCD5430AF1837")

        String pkg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.084 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "F50EE04D1F33A8C52E6957011343491C")

        CompatibilityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.084 -0400", hash_original_method = "20ABF4B3D5332D1381C869593F335293", hash_generated_method = "20ABF4B3D5332D1381C869593F335293")
        public UpdateCompatibilityData ()
        {
            //Synthesized constructor
        }


    }


    
    private class ApplicationThread extends ApplicationThreadNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.098 -0400", hash_original_method = "1FF8F0D2A8FB58C213C16741C12E71C3", hash_generated_method = "1FF8F0D2A8FB58C213C16741C12E71C3")
        public ApplicationThread ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.109 -0400", hash_original_method = "FEE93A296AD85C197E1C80A7E47B6BFE", hash_generated_method = "6661BA80D539E47199FAF6BD1E4A7647")
        private void updatePendingConfiguration(Configuration config) {
            {
                {
                    boolean var2CFDCC84A5236B199D2609CB25C5A865_1714705413 = (mPendingConfiguration == null ||
                        mPendingConfiguration.isOtherSeqNewer(config));
                    {
                        mPendingConfiguration = config;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            addTaint(config.getTaint());
            // ---------- Original Method ----------
            //synchronized (mPackages) {
                //if (mPendingConfiguration == null ||
                        //mPendingConfiguration.isOtherSeqNewer(config)) {
                    //mPendingConfiguration = config;
                //}
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.121 -0400", hash_original_method = "BA274F1A18F5196BF92F19261941182B", hash_generated_method = "D917AB3F71BC8A576A91C774953B89AE")
        public final void schedulePauseActivity(IBinder token, boolean finished,
                boolean userLeaving, int configChanges) {
            queueOrSendMessage(
                    finished ? H.PAUSE_ACTIVITY_FINISHING : H.PAUSE_ACTIVITY,
                    token,
                    (userLeaving ? 1 : 0),
                    configChanges);
            addTaint(token.getTaint());
            addTaint(finished);
            addTaint(userLeaving);
            addTaint(configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                    //finished ? H.PAUSE_ACTIVITY_FINISHING : H.PAUSE_ACTIVITY,
                    //token,
                    //(userLeaving ? 1 : 0),
                    //configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.123 -0400", hash_original_method = "6237E07FCE9BDD69A8A6118FB4C5EAB5", hash_generated_method = "4992DA782DB647284F757A3441D4940F")
        public final void scheduleStopActivity(IBinder token, boolean showWindow,
                int configChanges) {
            queueOrSendMessage(
                showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                token, 0, configChanges);
            addTaint(token.getTaint());
            addTaint(showWindow);
            addTaint(configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                //token, 0, configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.127 -0400", hash_original_method = "07304A552CCDBF618EE7F08FE12E8569", hash_generated_method = "359FCA9ACAFBF8DB7F3B260C9C3B669A")
        public final void scheduleWindowVisibility(IBinder token, boolean showWindow) {
            queueOrSendMessage(
                showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                token);
            addTaint(token.getTaint());
            addTaint(showWindow);
            // ---------- Original Method ----------
            //queueOrSendMessage(
                //showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                //token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.138 -0400", hash_original_method = "28F90EA3762C8F9BC8352F7DED192FAC", hash_generated_method = "E86314E031E79DB9BF7AAF2C5814522E")
        public final void scheduleSleeping(IBinder token, boolean sleeping) {
            queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
            addTaint(token.getTaint());
            addTaint(sleeping);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.139 -0400", hash_original_method = "8E946102D354A83096F7BBE33573DD97", hash_generated_method = "FC60EBCDFCD4CF934283C731AD0FCE8C")
        public final void scheduleResumeActivity(IBinder token, boolean isForward) {
            queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
            addTaint(token.getTaint());
            addTaint(isForward);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.160 -0400", hash_original_method = "C9516E754F864B61E9DED08AC69D1433", hash_generated_method = "39E6216214D30CE3A76048024F6ED830")
        public final void scheduleSendResult(IBinder token, List<ResultInfo> results) {
            ResultData res;
            res = new ResultData();
            res.token = token;
            res.results = results;
            queueOrSendMessage(H.SEND_RESULT, res);
            addTaint(token.getTaint());
            addTaint(results.getTaint());
            // ---------- Original Method ----------
            //ResultData res = new ResultData();
            //res.token = token;
            //res.results = results;
            //queueOrSendMessage(H.SEND_RESULT, res);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.170 -0400", hash_original_method = "A45BCC7C8AC3E4C6E98525A537822FA1", hash_generated_method = "A32CEED7144B9A686FD3C5B26CB7D52E")
        public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
                ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
                Bundle state, List<ResultInfo> pendingResults,
                List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
                String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) {
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
            addTaint(intent.getTaint());
            addTaint(token.getTaint());
            addTaint(ident);
            addTaint(info.getTaint());
            addTaint(curConfig.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(state.getTaint());
            addTaint(pendingResults.getTaint());
            addTaint(pendingNewIntents.getTaint());
            addTaint(notResumed);
            addTaint(isForward);
            addTaint(profileName.getTaint());
            addTaint(profileFd.getTaint());
            addTaint(autoStopProfiler);
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.188 -0400", hash_original_method = "7F2AB124E5633740D7D94B2A109EF885", hash_generated_method = "4E9123D26F10AFF75DD1819381499521")
        public final void scheduleRelaunchActivity(IBinder token,
                List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
                int configChanges, boolean notResumed, Configuration config) {
            requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    configChanges, notResumed, config, true);
            addTaint(token.getTaint());
            addTaint(pendingResults.getTaint());
            addTaint(pendingNewIntents.getTaint());
            addTaint(configChanges);
            addTaint(notResumed);
            addTaint(config.getTaint());
            // ---------- Original Method ----------
            //requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    //configChanges, notResumed, config, true);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.191 -0400", hash_original_method = "821027AAA00C536539A4B7071BFFE4C0", hash_generated_method = "1BC2C5C34C4161F3AE3FA141288CEB6B")
        public final void scheduleNewIntent(List<Intent> intents, IBinder token) {
            NewIntentData data;
            data = new NewIntentData();
            data.intents = intents;
            data.token = token;
            queueOrSendMessage(H.NEW_INTENT, data);
            addTaint(intents.getTaint());
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //NewIntentData data = new NewIntentData();
            //data.intents = intents;
            //data.token = token;
            //queueOrSendMessage(H.NEW_INTENT, data);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.192 -0400", hash_original_method = "09A2B20C75657E983740D1D57867F853", hash_generated_method = "F9D5651405F34FC3B8EBE453223B7F40")
        public final void scheduleDestroyActivity(IBinder token, boolean finishing,
                int configChanges) {
            queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    configChanges);
            addTaint(token.getTaint());
            addTaint(finishing);
            addTaint(configChanges);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    //configChanges);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.218 -0400", hash_original_method = "F17AEB980BE0F6A4E87F430078BD0B58", hash_generated_method = "0BE7EC7D96200F5AA9FB5FAC88F0AE38")
        public final void scheduleReceiver(Intent intent, ActivityInfo info,
                CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras,
                boolean sync) {
            ReceiverData r;
            r = new ReceiverData(intent, resultCode, data, extras,
                    sync, false, mAppThread.asBinder());
            r.info = info;
            r.compatInfo = compatInfo;
            queueOrSendMessage(H.RECEIVER, r);
            addTaint(intent.getTaint());
            addTaint(info.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(resultCode);
            addTaint(data.getTaint());
            addTaint(extras.getTaint());
            addTaint(sync);
            // ---------- Original Method ----------
            //ReceiverData r = new ReceiverData(intent, resultCode, data, extras,
                    //sync, false, mAppThread.asBinder());
            //r.info = info;
            //r.compatInfo = compatInfo;
            //queueOrSendMessage(H.RECEIVER, r);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.225 -0400", hash_original_method = "5FA1669C7C775884F96F1A035B24EE01", hash_generated_method = "8595B05982A0D1AE18BF2E7657DF84F4")
        public final void scheduleCreateBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo, int backupMode) {
            CreateBackupAgentData d;
            d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            d.backupMode = backupMode;
            queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
            addTaint(app.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(backupMode);
            // ---------- Original Method ----------
            //CreateBackupAgentData d = new CreateBackupAgentData();
            //d.appInfo = app;
            //d.compatInfo = compatInfo;
            //d.backupMode = backupMode;
            //queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.228 -0400", hash_original_method = "313CE24EB5C5C4A7E872620C7BAF7637", hash_generated_method = "3634F66DB484CE4F7FEABAFE928D2A65")
        public final void scheduleDestroyBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo) {
            CreateBackupAgentData d;
            d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
            addTaint(app.getTaint());
            addTaint(compatInfo.getTaint());
            // ---------- Original Method ----------
            //CreateBackupAgentData d = new CreateBackupAgentData();
            //d.appInfo = app;
            //d.compatInfo = compatInfo;
            //queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.239 -0400", hash_original_method = "304266FFC85B0A8F15B84D2439555071", hash_generated_method = "3231C49DA5DBA01C2070B8FB816763B5")
        public final void scheduleCreateService(IBinder token,
                ServiceInfo info, CompatibilityInfo compatInfo) {
            CreateServiceData s;
            s = new CreateServiceData();
            s.token = token;
            s.info = info;
            s.compatInfo = compatInfo;
            queueOrSendMessage(H.CREATE_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(info.getTaint());
            addTaint(compatInfo.getTaint());
            // ---------- Original Method ----------
            //CreateServiceData s = new CreateServiceData();
            //s.token = token;
            //s.info = info;
            //s.compatInfo = compatInfo;
            //queueOrSendMessage(H.CREATE_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.255 -0400", hash_original_method = "EC87D949C3428DDE1DD75260E89A91E6", hash_generated_method = "427B4F41166FDAF24318394A8E240AEE")
        public final void scheduleBindService(IBinder token, Intent intent,
                boolean rebind) {
            BindServiceData s;
            s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            s.rebind = rebind;
            queueOrSendMessage(H.BIND_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(intent.getTaint());
            addTaint(rebind);
            // ---------- Original Method ----------
            //BindServiceData s = new BindServiceData();
            //s.token = token;
            //s.intent = intent;
            //s.rebind = rebind;
            //queueOrSendMessage(H.BIND_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.270 -0400", hash_original_method = "267A066D9D2EC1A97646FF118EBD56F3", hash_generated_method = "3875AB7DC6A15857E4E1DDB48B62F7DA")
        public final void scheduleUnbindService(IBinder token, Intent intent) {
            BindServiceData s;
            s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            queueOrSendMessage(H.UNBIND_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(intent.getTaint());
            // ---------- Original Method ----------
            //BindServiceData s = new BindServiceData();
            //s.token = token;
            //s.intent = intent;
            //queueOrSendMessage(H.UNBIND_SERVICE, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.281 -0400", hash_original_method = "4862A31D82FA9B63D38F69A2AB095DD2", hash_generated_method = "912AF6C8F7C5931E41355C2F33E40F51")
        public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
            int flags ,Intent args) {
            ServiceArgsData s;
            s = new ServiceArgsData();
            s.token = token;
            s.taskRemoved = taskRemoved;
            s.startId = startId;
            s.flags = flags;
            s.args = args;
            queueOrSendMessage(H.SERVICE_ARGS, s);
            addTaint(token.getTaint());
            addTaint(taskRemoved);
            addTaint(startId);
            addTaint(flags);
            addTaint(args.getTaint());
            // ---------- Original Method ----------
            //ServiceArgsData s = new ServiceArgsData();
            //s.token = token;
            //s.taskRemoved = taskRemoved;
            //s.startId = startId;
            //s.flags = flags;
            //s.args = args;
            //queueOrSendMessage(H.SERVICE_ARGS, s);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.282 -0400", hash_original_method = "1A677B6A32C3D13D1D29F012CCC3FAD3", hash_generated_method = "20CB2D0F2CE7EB21E307347824868418")
        public final void scheduleStopService(IBinder token) {
            queueOrSendMessage(H.STOP_SERVICE, token);
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.STOP_SERVICE, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.314 -0400", hash_original_method = "7F787E48DA5312BFEADE988209BA97C7", hash_generated_method = "779D93EE41B07D6B822968E4AE739700")
        public final void bindApplication(String processName,
                ApplicationInfo appInfo, List<ProviderInfo> providers,
                ComponentName instrumentationName, String profileFile,
                ParcelFileDescriptor profileFd, boolean autoStopProfiler,
                Bundle instrumentationArgs, IInstrumentationWatcher instrumentationWatcher,
                int debugMode, boolean isRestrictedBackupMode, boolean persistent,
                Configuration config, CompatibilityInfo compatInfo,
                Map<String, IBinder> services, Bundle coreSettings) {
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
            addTaint(processName.getTaint());
            addTaint(appInfo.getTaint());
            addTaint(providers.getTaint());
            addTaint(instrumentationName.getTaint());
            addTaint(profileFile.getTaint());
            addTaint(profileFd.getTaint());
            addTaint(autoStopProfiler);
            addTaint(instrumentationArgs.getTaint());
            addTaint(instrumentationWatcher.getTaint());
            addTaint(debugMode);
            addTaint(isRestrictedBackupMode);
            addTaint(persistent);
            addTaint(config.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(services.getTaint());
            addTaint(coreSettings.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.316 -0400", hash_original_method = "8F2CF4412C4F9594CB0F284CDA41289F", hash_generated_method = "FD95F1744B2DADE0E6256342E369D342")
        public final void scheduleExit() {
            queueOrSendMessage(H.EXIT_APPLICATION, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.EXIT_APPLICATION, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.329 -0400", hash_original_method = "B20E9F159FCFB18DA16F9E3A94AEF27F", hash_generated_method = "FCFDDF7AD8124B805F52430959A87E50")
        public final void scheduleSuicide() {
            queueOrSendMessage(H.SUICIDE, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SUICIDE, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.331 -0400", hash_original_method = "6202A73E0682C5A75E75C022AC3B402A", hash_generated_method = "48A1F121DF1D20DE06EFB7AE38C20B3B")
        public void requestThumbnail(IBinder token) {
            queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.426 -0400", hash_original_method = "06772B0545F1E3E199A400C07A7C465B", hash_generated_method = "53FC298F5726D07F58C2FD2F30D198B5")
        public void scheduleConfigurationChanged(Configuration config) {
            updatePendingConfiguration(config);
            queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
            addTaint(config.getTaint());
            // ---------- Original Method ----------
            //updatePendingConfiguration(config);
            //queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.427 -0400", hash_original_method = "691E3B4CEF6237A9A1AE3434E3DEDEFF", hash_generated_method = "B8C95D80E84F89DC0BEDC85471A2F2D3")
        public void updateTimeZone() {
            TimeZone.setDefault(null);
            // ---------- Original Method ----------
            //TimeZone.setDefault(null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.429 -0400", hash_original_method = "38B626EB423003E8CAF0F1407CD9E9A9", hash_generated_method = "4A28A43D9782A661EAF6F85250AF0D6F")
        public void clearDnsCache() {
            InetAddress.clearDnsCache();
            // ---------- Original Method ----------
            //InetAddress.clearDnsCache();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.460 -0400", hash_original_method = "B8887413EF343DBD56A367F4C57F614A", hash_generated_method = "BF7EEB7653EAAE61B498B50053247D7C")
        public void setHttpProxy(String host, String port, String exclList) {
            Proxy.setHttpProxySystemProperty(host, port, exclList);
            addTaint(host.getTaint());
            addTaint(port.getTaint());
            addTaint(exclList.getTaint());
            // ---------- Original Method ----------
            //Proxy.setHttpProxySystemProperty(host, port, exclList);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.464 -0400", hash_original_method = "66F6EAD39814B9A04B7952BBDB099BC9", hash_generated_method = "572139B122FBBA71F49FE015C971C791")
        public void processInBackground() {
            mH.removeMessages(H.GC_WHEN_IDLE);
            mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
            // ---------- Original Method ----------
            //mH.removeMessages(H.GC_WHEN_IDLE);
            //mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.489 -0400", hash_original_method = "876C8E0D071CEA83F82D96AA48344FA4", hash_generated_method = "7C4160574952DAB983259F10CE8EDCE8")
        public void dumpService(FileDescriptor fd, IBinder servicetoken, String[] args) {
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
            addTaint(fd.getTaint());
            addTaint(servicetoken.getTaint());
            addTaint(args[0].getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.502 -0400", hash_original_method = "0E238081C4996703A2EA0540C6977CE0", hash_generated_method = "5D03A8CD7858AA8957D593C5285A33DF")
        public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
                int resultCode, String dataStr, Bundle extras, boolean ordered,
                boolean sticky) throws RemoteException {
            receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
            addTaint(receiver.getTaint());
            addTaint(intent.getTaint());
            addTaint(resultCode);
            addTaint(dataStr.getTaint());
            addTaint(extras.getTaint());
            addTaint(ordered);
            addTaint(sticky);
            // ---------- Original Method ----------
            //receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.503 -0400", hash_original_method = "1CA11DE4169634D3536C3A5288820C11", hash_generated_method = "C0AEC8819655C2E24AF50FB99520B4E3")
        public void scheduleLowMemory() {
            queueOrSendMessage(H.LOW_MEMORY, null);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.LOW_MEMORY, null);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.524 -0400", hash_original_method = "1503BAA815C894047387C37D52FE75DC", hash_generated_method = "59188C16C404FB146F1EDA7F192F2F81")
        public void scheduleActivityConfigurationChanged(IBinder token) {
            queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
            addTaint(token.getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.540 -0400", hash_original_method = "D92E635329F77F60C61D4CBABCC9E0E5", hash_generated_method = "39A1D2DF7858E681B4D15040C6631ADC")
        public void profilerControl(boolean start, String path, ParcelFileDescriptor fd,
                int profileType) {
            ProfilerControlData pcd;
            pcd = new ProfilerControlData();
            pcd.path = path;
            pcd.fd = fd;
            queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
            addTaint(start);
            addTaint(path.getTaint());
            addTaint(fd.getTaint());
            addTaint(profileType);
            // ---------- Original Method ----------
            //ProfilerControlData pcd = new ProfilerControlData();
            //pcd.path = path;
            //pcd.fd = fd;
            //queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.561 -0400", hash_original_method = "E2AA43C341E3E1223DC4327679137F86", hash_generated_method = "B8067A758CE966C361C02B13AC7BFA24")
        public void dumpHeap(boolean managed, String path, ParcelFileDescriptor fd) {
            DumpHeapData dhd;
            dhd = new DumpHeapData();
            dhd.path = path;
            dhd.fd = fd;
            queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
            addTaint(managed);
            addTaint(path.getTaint());
            addTaint(fd.getTaint());
            // ---------- Original Method ----------
            //DumpHeapData dhd = new DumpHeapData();
            //dhd.path = path;
            //dhd.fd = fd;
            //queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.579 -0400", hash_original_method = "31DFA590CF69650795082863A4038E1E", hash_generated_method = "D80D73D17CF81872BBAFCB26CF4AB3CD")
        public void setSchedulingGroup(int group) {
            try 
            {
                Process.setProcessGroup(Process.myPid(), group);
            } //End block
            catch (Exception e)
            { }
            addTaint(group);
            // ---------- Original Method ----------
            //try {
                //Process.setProcessGroup(Process.myPid(), group);
            //} catch (Exception e) {
                //Slog.w(TAG, "Failed setting process group to " + group, e);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.581 -0400", hash_original_method = "7CB15E6FC063BB1B6B4AEB944EE130EF", hash_generated_method = "7F178544F547A85E455180D9AAF83037")
        public void getMemoryInfo(Debug.MemoryInfo outInfo) {
            Debug.getMemoryInfo(outInfo);
            addTaint(outInfo.getTaint());
            // ---------- Original Method ----------
            //Debug.getMemoryInfo(outInfo);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.588 -0400", hash_original_method = "779EC3818AE8FA9E2AC523D128FB5D87", hash_generated_method = "C465F6CE7C51F836B2A046A8FE39D2EA")
        public void dispatchPackageBroadcast(int cmd, String[] packages) {
            queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
            addTaint(cmd);
            addTaint(packages[0].getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.596 -0400", hash_original_method = "E0613CA49761C406F1CB17CB9D000972", hash_generated_method = "42CC174CF32CED87381A83DC00332392")
        public void scheduleCrash(String msg) {
            queueOrSendMessage(H.SCHEDULE_CRASH, msg);
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SCHEDULE_CRASH, msg);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.609 -0400", hash_original_method = "D7BE3A9B3D448EC9431A34B711555765", hash_generated_method = "0E5C2769FDAB8E819DB628D0D724B33A")
        public void dumpActivity(FileDescriptor fd, IBinder activitytoken,
                String prefix, String[] args) {
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
            addTaint(fd.getTaint());
            addTaint(activitytoken.getTaint());
            addTaint(prefix.getTaint());
            addTaint(args[0].getTaint());
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.636 -0400", hash_original_method = "648F3C65CFB469E019D9747F832AE1E8", hash_generated_method = "C2AE26D041674814BF19A9049AD7DF2D")
        @Override
        public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin,
                boolean all, String[] args) {
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1610166058 = null; //Variable for return #1
            FileOutputStream fout;
            fout = new FileOutputStream(fd);
            PrintWriter pw;
            pw = new PrintWriter(fout);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1610166058 = dumpMemInfo(pw, checkin, all, args);
            } //End block
            finally 
            {
                pw.flush();
            } //End block
            addTaint(fd.getTaint());
            addTaint(checkin);
            addTaint(all);
            addTaint(args[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1610166058.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1610166058;
            // ---------- Original Method ----------
            //FileOutputStream fout = new FileOutputStream(fd);
            //PrintWriter pw = new PrintWriter(fout);
            //try {
                //return dumpMemInfo(pw, checkin, all, args);
            //} finally {
                //pw.flush();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.730 -0400", hash_original_method = "468180529DE63D6D9E6979D7BD66773F", hash_generated_method = "18C9C342ECF14B07E4FA9A19DFE7ABC7")
        private Debug.MemoryInfo dumpMemInfo(PrintWriter pw, boolean checkin, boolean all,
                String[] args) {
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_164871806 = null; //Variable for return #1
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1921909016 = null; //Variable for return #2
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_598333300 = null; //Variable for return #3
            long nativeMax;
            nativeMax = Debug.getNativeHeapSize() / 1024;
            long nativeAllocated;
            nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeFree;
            nativeFree = Debug.getNativeHeapFreeSize() / 1024;
            Debug.MemoryInfo memInfo;
            memInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memInfo);
            {
                varB4EAC82CA7396A68D541C85D26508E83_164871806 = memInfo;
            } //End block
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
                    boolean var34DA22B98BE69F3557BBBED2C262409B_165178521 = (i < stats.dbStats.size());
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
                varB4EAC82CA7396A68D541C85D26508E83_1921909016 = memInfo;
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
            varB4EAC82CA7396A68D541C85D26508E83_598333300 = memInfo;
            addTaint(pw.getTaint());
            addTaint(checkin);
            addTaint(all);
            addTaint(args[0].getTaint());
            Debug.MemoryInfo varA7E53CE21691AB073D9660D615818899_1379545218; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1379545218 = varB4EAC82CA7396A68D541C85D26508E83_164871806;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1379545218 = varB4EAC82CA7396A68D541C85D26508E83_1921909016;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1379545218 = varB4EAC82CA7396A68D541C85D26508E83_598333300;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1379545218.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1379545218;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.733 -0400", hash_original_method = "DBE19F37C980DCB637B8E3CCE0C6D7AE", hash_generated_method = "9DFFA905487BE70E4D9DA058B40F3E0E")
        @Override
        public void dumpGfxInfo(FileDescriptor fd, String[] args) {
            dumpGraphicsInfo(fd);
            WindowManagerImpl.getDefault().dumpGfxInfo(fd);
            addTaint(fd.getTaint());
            addTaint(args[0].getTaint());
            // ---------- Original Method ----------
            //dumpGraphicsInfo(fd);
            //WindowManagerImpl.getDefault().dumpGfxInfo(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.853 -0400", hash_original_method = "E9FD23CC6BA5457F811332501D367E07", hash_generated_method = "01B252CEECEC227E9C9B5E48CB8CD1D6")
        private void printRow(PrintWriter pw, String format, Object...objs) {
            pw.println(String.format(format, objs));
            addTaint(pw.getTaint());
            addTaint(format.getTaint());
            addTaint(objs[0].getTaint());
            // ---------- Original Method ----------
            //pw.println(String.format(format, objs));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.856 -0400", hash_original_method = "5D81A3C132332FC039C36D652A159D52", hash_generated_method = "292FEB3CA0CC3BEAF89B4B6F4EDB115F")
        public void setCoreSettings(Bundle coreSettings) {
            queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
            addTaint(coreSettings.getTaint());
            // ---------- Original Method ----------
            //queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.857 -0400", hash_original_method = "915F19E7DF7511DDBDEE0EA8781AD484", hash_generated_method = "1868DF611379F6047B82189038AC751B")
        public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) {
            UpdateCompatibilityData ucd;
            ucd = new UpdateCompatibilityData();
            ucd.pkg = pkg;
            ucd.info = info;
            queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
            addTaint(pkg.getTaint());
            addTaint(info.getTaint());
            // ---------- Original Method ----------
            //UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            //ucd.pkg = pkg;
            //ucd.info = info;
            //queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.858 -0400", hash_original_method = "713723E30DD42F550C53D06876722D4F", hash_generated_method = "3D824C6AACF052B15E39794D74C144BF")
        public void scheduleTrimMemory(int level) {
            queueOrSendMessage(H.TRIM_MEMORY, null, level);
            addTaint(level);
            // ---------- Original Method ----------
            //queueOrSendMessage(H.TRIM_MEMORY, null, level);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.870 -0400", hash_original_field = "DB018D420C41A3AA31DB7A5C0D61BF49", hash_generated_field = "96FE4DE896DA8140237FE2F2A32AB60D")

        private static String HEAP_COLUMN = "%13s %8s %8s %8s %8s %8s %8s";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.888 -0400", hash_original_field = "8C67A7F03B15ABF12A0BF8AF99E82E57", hash_generated_field = "8E20BB4B613E1B8E1B2DA12DB50E69D3")

        private static String ONE_COUNT_COLUMN = "%21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.889 -0400", hash_original_field = "22778F00F1A90EFFD754BBAB24439FEA", hash_generated_field = "6CEAA9CA3D9ACF8FFD77880F59229D13")

        private static String TWO_COUNT_COLUMNS = "%21s %8d %21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.889 -0400", hash_original_field = "21567A713D1BAFE64C7E61BD2868538A", hash_generated_field = "E1986AF9DD2AA88B111C4B08C267AB55")

        private static String TWO_COUNT_COLUMNS_DB = "%21s %8d %21s %8d";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.910 -0400", hash_original_field = "EFC99A6ACAB1774B303D5BBEBCE82329", hash_generated_field = "F260B277CED6BCEF639DFFBC60FBBB27")

        private static String DB_INFO_FORMAT = "  %8s %8s %14s %14s  %s";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.912 -0400", hash_original_field = "FFC3E978BB0A535AB4D65ADF77410A56", hash_generated_field = "A616DB8304B25BAEBD73BFE313E4CC76")

        private static int ACTIVITY_THREAD_CHECKIN_VERSION = 1;
    }


    
    private class H extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:51.915 -0400", hash_original_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5", hash_generated_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5")
        public H ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.015 -0400", hash_original_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C", hash_generated_method = "FF11A0CFDBE85E2A711EDE8059026BE1")
         String codeToString(int code) {
            String varB4EAC82CA7396A68D541C85D26508E83_1956353037 = null; //Variable for return #1
            String varB4EAC82CA7396A68D541C85D26508E83_2113850007 = null; //Variable for return #2
            String varB4EAC82CA7396A68D541C85D26508E83_1809909083 = null; //Variable for return #3
            String varB4EAC82CA7396A68D541C85D26508E83_2030061277 = null; //Variable for return #4
            String varB4EAC82CA7396A68D541C85D26508E83_1607649279 = null; //Variable for return #5
            String varB4EAC82CA7396A68D541C85D26508E83_857543982 = null; //Variable for return #6
            String varB4EAC82CA7396A68D541C85D26508E83_161493821 = null; //Variable for return #7
            String varB4EAC82CA7396A68D541C85D26508E83_993636296 = null; //Variable for return #8
            String varB4EAC82CA7396A68D541C85D26508E83_1092400170 = null; //Variable for return #9
            String varB4EAC82CA7396A68D541C85D26508E83_800988356 = null; //Variable for return #10
            String varB4EAC82CA7396A68D541C85D26508E83_409191090 = null; //Variable for return #11
            String varB4EAC82CA7396A68D541C85D26508E83_1553915223 = null; //Variable for return #12
            String varB4EAC82CA7396A68D541C85D26508E83_1810522451 = null; //Variable for return #13
            String varB4EAC82CA7396A68D541C85D26508E83_1731900720 = null; //Variable for return #14
            String varB4EAC82CA7396A68D541C85D26508E83_177953730 = null; //Variable for return #15
            String varB4EAC82CA7396A68D541C85D26508E83_2035244559 = null; //Variable for return #16
            String varB4EAC82CA7396A68D541C85D26508E83_1236642144 = null; //Variable for return #17
            String varB4EAC82CA7396A68D541C85D26508E83_447854492 = null; //Variable for return #18
            String varB4EAC82CA7396A68D541C85D26508E83_840746546 = null; //Variable for return #19
            String varB4EAC82CA7396A68D541C85D26508E83_403221179 = null; //Variable for return #20
            String varB4EAC82CA7396A68D541C85D26508E83_1577250072 = null; //Variable for return #21
            String varB4EAC82CA7396A68D541C85D26508E83_30088711 = null; //Variable for return #22
            String varB4EAC82CA7396A68D541C85D26508E83_469366710 = null; //Variable for return #23
            String varB4EAC82CA7396A68D541C85D26508E83_580615551 = null; //Variable for return #24
            String varB4EAC82CA7396A68D541C85D26508E83_749962537 = null; //Variable for return #25
            String varB4EAC82CA7396A68D541C85D26508E83_885164580 = null; //Variable for return #26
            String varB4EAC82CA7396A68D541C85D26508E83_957554488 = null; //Variable for return #27
            String varB4EAC82CA7396A68D541C85D26508E83_1267268051 = null; //Variable for return #28
            String varB4EAC82CA7396A68D541C85D26508E83_1998172373 = null; //Variable for return #29
            String varB4EAC82CA7396A68D541C85D26508E83_1210860184 = null; //Variable for return #30
            String varB4EAC82CA7396A68D541C85D26508E83_1641656236 = null; //Variable for return #31
            String varB4EAC82CA7396A68D541C85D26508E83_2067623977 = null; //Variable for return #32
            String varB4EAC82CA7396A68D541C85D26508E83_247373055 = null; //Variable for return #33
            String varB4EAC82CA7396A68D541C85D26508E83_587971843 = null; //Variable for return #34
            String varB4EAC82CA7396A68D541C85D26508E83_1142531122 = null; //Variable for return #35
            String varB4EAC82CA7396A68D541C85D26508E83_1208783964 = null; //Variable for return #36
            String varB4EAC82CA7396A68D541C85D26508E83_785283306 = null; //Variable for return #37
            String varB4EAC82CA7396A68D541C85D26508E83_2043753396 = null; //Variable for return #38
            String varB4EAC82CA7396A68D541C85D26508E83_743713454 = null; //Variable for return #39
            String varB4EAC82CA7396A68D541C85D26508E83_1431712999 = null; //Variable for return #40
            String varB4EAC82CA7396A68D541C85D26508E83_101309206 = null; //Variable for return #41
            String varB4EAC82CA7396A68D541C85D26508E83_1640936884 = null; //Variable for return #42
            {
                //Begin case LAUNCH_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_1956353037 = "LAUNCH_ACTIVITY";
                //End case LAUNCH_ACTIVITY 
                //Begin case PAUSE_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_2113850007 = "PAUSE_ACTIVITY";
                //End case PAUSE_ACTIVITY 
                //Begin case PAUSE_ACTIVITY_FINISHING 
                varB4EAC82CA7396A68D541C85D26508E83_1809909083 = "PAUSE_ACTIVITY_FINISHING";
                //End case PAUSE_ACTIVITY_FINISHING 
                //Begin case STOP_ACTIVITY_SHOW 
                varB4EAC82CA7396A68D541C85D26508E83_2030061277 = "STOP_ACTIVITY_SHOW";
                //End case STOP_ACTIVITY_SHOW 
                //Begin case STOP_ACTIVITY_HIDE 
                varB4EAC82CA7396A68D541C85D26508E83_1607649279 = "STOP_ACTIVITY_HIDE";
                //End case STOP_ACTIVITY_HIDE 
                //Begin case SHOW_WINDOW 
                varB4EAC82CA7396A68D541C85D26508E83_857543982 = "SHOW_WINDOW";
                //End case SHOW_WINDOW 
                //Begin case HIDE_WINDOW 
                varB4EAC82CA7396A68D541C85D26508E83_161493821 = "HIDE_WINDOW";
                //End case HIDE_WINDOW 
                //Begin case RESUME_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_993636296 = "RESUME_ACTIVITY";
                //End case RESUME_ACTIVITY 
                //Begin case SEND_RESULT 
                varB4EAC82CA7396A68D541C85D26508E83_1092400170 = "SEND_RESULT";
                //End case SEND_RESULT 
                //Begin case DESTROY_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_800988356 = "DESTROY_ACTIVITY";
                //End case DESTROY_ACTIVITY 
                //Begin case BIND_APPLICATION 
                varB4EAC82CA7396A68D541C85D26508E83_409191090 = "BIND_APPLICATION";
                //End case BIND_APPLICATION 
                //Begin case EXIT_APPLICATION 
                varB4EAC82CA7396A68D541C85D26508E83_1553915223 = "EXIT_APPLICATION";
                //End case EXIT_APPLICATION 
                //Begin case NEW_INTENT 
                varB4EAC82CA7396A68D541C85D26508E83_1810522451 = "NEW_INTENT";
                //End case NEW_INTENT 
                //Begin case RECEIVER 
                varB4EAC82CA7396A68D541C85D26508E83_1731900720 = "RECEIVER";
                //End case RECEIVER 
                //Begin case CREATE_SERVICE 
                varB4EAC82CA7396A68D541C85D26508E83_177953730 = "CREATE_SERVICE";
                //End case CREATE_SERVICE 
                //Begin case SERVICE_ARGS 
                varB4EAC82CA7396A68D541C85D26508E83_2035244559 = "SERVICE_ARGS";
                //End case SERVICE_ARGS 
                //Begin case STOP_SERVICE 
                varB4EAC82CA7396A68D541C85D26508E83_1236642144 = "STOP_SERVICE";
                //End case STOP_SERVICE 
                //Begin case REQUEST_THUMBNAIL 
                varB4EAC82CA7396A68D541C85D26508E83_447854492 = "REQUEST_THUMBNAIL";
                //End case REQUEST_THUMBNAIL 
                //Begin case CONFIGURATION_CHANGED 
                varB4EAC82CA7396A68D541C85D26508E83_840746546 = "CONFIGURATION_CHANGED";
                //End case CONFIGURATION_CHANGED 
                //Begin case CLEAN_UP_CONTEXT 
                varB4EAC82CA7396A68D541C85D26508E83_403221179 = "CLEAN_UP_CONTEXT";
                //End case CLEAN_UP_CONTEXT 
                //Begin case GC_WHEN_IDLE 
                varB4EAC82CA7396A68D541C85D26508E83_1577250072 = "GC_WHEN_IDLE";
                //End case GC_WHEN_IDLE 
                //Begin case BIND_SERVICE 
                varB4EAC82CA7396A68D541C85D26508E83_30088711 = "BIND_SERVICE";
                //End case BIND_SERVICE 
                //Begin case UNBIND_SERVICE 
                varB4EAC82CA7396A68D541C85D26508E83_469366710 = "UNBIND_SERVICE";
                //End case UNBIND_SERVICE 
                //Begin case DUMP_SERVICE 
                varB4EAC82CA7396A68D541C85D26508E83_580615551 = "DUMP_SERVICE";
                //End case DUMP_SERVICE 
                //Begin case LOW_MEMORY 
                varB4EAC82CA7396A68D541C85D26508E83_749962537 = "LOW_MEMORY";
                //End case LOW_MEMORY 
                //Begin case ACTIVITY_CONFIGURATION_CHANGED 
                varB4EAC82CA7396A68D541C85D26508E83_885164580 = "ACTIVITY_CONFIGURATION_CHANGED";
                //End case ACTIVITY_CONFIGURATION_CHANGED 
                //Begin case RELAUNCH_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_957554488 = "RELAUNCH_ACTIVITY";
                //End case RELAUNCH_ACTIVITY 
                //Begin case PROFILER_CONTROL 
                varB4EAC82CA7396A68D541C85D26508E83_1267268051 = "PROFILER_CONTROL";
                //End case PROFILER_CONTROL 
                //Begin case CREATE_BACKUP_AGENT 
                varB4EAC82CA7396A68D541C85D26508E83_1998172373 = "CREATE_BACKUP_AGENT";
                //End case CREATE_BACKUP_AGENT 
                //Begin case DESTROY_BACKUP_AGENT 
                varB4EAC82CA7396A68D541C85D26508E83_1210860184 = "DESTROY_BACKUP_AGENT";
                //End case DESTROY_BACKUP_AGENT 
                //Begin case SUICIDE 
                varB4EAC82CA7396A68D541C85D26508E83_1641656236 = "SUICIDE";
                //End case SUICIDE 
                //Begin case REMOVE_PROVIDER 
                varB4EAC82CA7396A68D541C85D26508E83_2067623977 = "REMOVE_PROVIDER";
                //End case REMOVE_PROVIDER 
                //Begin case ENABLE_JIT 
                varB4EAC82CA7396A68D541C85D26508E83_247373055 = "ENABLE_JIT";
                //End case ENABLE_JIT 
                //Begin case DISPATCH_PACKAGE_BROADCAST 
                varB4EAC82CA7396A68D541C85D26508E83_587971843 = "DISPATCH_PACKAGE_BROADCAST";
                //End case DISPATCH_PACKAGE_BROADCAST 
                //Begin case SCHEDULE_CRASH 
                varB4EAC82CA7396A68D541C85D26508E83_1142531122 = "SCHEDULE_CRASH";
                //End case SCHEDULE_CRASH 
                //Begin case DUMP_HEAP 
                varB4EAC82CA7396A68D541C85D26508E83_1208783964 = "DUMP_HEAP";
                //End case DUMP_HEAP 
                //Begin case DUMP_ACTIVITY 
                varB4EAC82CA7396A68D541C85D26508E83_785283306 = "DUMP_ACTIVITY";
                //End case DUMP_ACTIVITY 
                //Begin case SLEEPING 
                varB4EAC82CA7396A68D541C85D26508E83_2043753396 = "SLEEPING";
                //End case SLEEPING 
                //Begin case SET_CORE_SETTINGS 
                varB4EAC82CA7396A68D541C85D26508E83_743713454 = "SET_CORE_SETTINGS";
                //End case SET_CORE_SETTINGS 
                //Begin case UPDATE_PACKAGE_COMPATIBILITY_INFO 
                varB4EAC82CA7396A68D541C85D26508E83_1431712999 = "UPDATE_PACKAGE_COMPATIBILITY_INFO";
                //End case UPDATE_PACKAGE_COMPATIBILITY_INFO 
                //Begin case TRIM_MEMORY 
                varB4EAC82CA7396A68D541C85D26508E83_101309206 = "TRIM_MEMORY";
                //End case TRIM_MEMORY 
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1640936884 = "(unknown)";
            addTaint(code);
            String varA7E53CE21691AB073D9660D615818899_1938659177; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1956353037;
                    break;
                case 2: //Assign result for return ordinal #2
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_2113850007;
                    break;
                case 3: //Assign result for return ordinal #3
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1809909083;
                    break;
                case 4: //Assign result for return ordinal #4
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_2030061277;
                    break;
                case 5: //Assign result for return ordinal #5
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1607649279;
                    break;
                case 6: //Assign result for return ordinal #6
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_857543982;
                    break;
                case 7: //Assign result for return ordinal #7
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_161493821;
                    break;
                case 8: //Assign result for return ordinal #8
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_993636296;
                    break;
                case 9: //Assign result for return ordinal #9
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1092400170;
                    break;
                case 10: //Assign result for return ordinal #10
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_800988356;
                    break;
                case 11: //Assign result for return ordinal #11
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_409191090;
                    break;
                case 12: //Assign result for return ordinal #12
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1553915223;
                    break;
                case 13: //Assign result for return ordinal #13
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1810522451;
                    break;
                case 14: //Assign result for return ordinal #14
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1731900720;
                    break;
                case 15: //Assign result for return ordinal #15
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_177953730;
                    break;
                case 16: //Assign result for return ordinal #16
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_2035244559;
                    break;
                case 17: //Assign result for return ordinal #17
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1236642144;
                    break;
                case 18: //Assign result for return ordinal #18
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_447854492;
                    break;
                case 19: //Assign result for return ordinal #19
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_840746546;
                    break;
                case 20: //Assign result for return ordinal #20
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_403221179;
                    break;
                case 21: //Assign result for return ordinal #21
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1577250072;
                    break;
                case 22: //Assign result for return ordinal #22
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_30088711;
                    break;
                case 23: //Assign result for return ordinal #23
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_469366710;
                    break;
                case 24: //Assign result for return ordinal #24
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_580615551;
                    break;
                case 25: //Assign result for return ordinal #25
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_749962537;
                    break;
                case 26: //Assign result for return ordinal #26
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_885164580;
                    break;
                case 27: //Assign result for return ordinal #27
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_957554488;
                    break;
                case 28: //Assign result for return ordinal #28
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1267268051;
                    break;
                case 29: //Assign result for return ordinal #29
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1998172373;
                    break;
                case 30: //Assign result for return ordinal #30
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1210860184;
                    break;
                case 31: //Assign result for return ordinal #31
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1641656236;
                    break;
                case 32: //Assign result for return ordinal #32
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_2067623977;
                    break;
                case 33: //Assign result for return ordinal #33
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_247373055;
                    break;
                case 34: //Assign result for return ordinal #34
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_587971843;
                    break;
                case 35: //Assign result for return ordinal #35
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1142531122;
                    break;
                case 36: //Assign result for return ordinal #36
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1208783964;
                    break;
                case 37: //Assign result for return ordinal #37
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_785283306;
                    break;
                case 38: //Assign result for return ordinal #38
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_2043753396;
                    break;
                case 39: //Assign result for return ordinal #39
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_743713454;
                    break;
                case 40: //Assign result for return ordinal #40
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1431712999;
                    break;
                case 41: //Assign result for return ordinal #41
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_101309206;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1938659177 = varB4EAC82CA7396A68D541C85D26508E83_1640936884;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1938659177.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1938659177;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.043 -0400", hash_original_method = "DC9C3E5B703CFDFA18C27F800AA1CA40", hash_generated_method = "4C46923FE0DEC8659DAE96B149F43FEB")
        public void handleMessage(Message msg) {
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
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.087 -0400", hash_original_method = "E92E43C77FF76A1843097A49ADA7442E", hash_generated_method = "00D7A7899512F772104A3C2C15EC5F4A")
        private void maybeSnapshot() {
            {
                boolean var729A603993F3B35DA9B3209A1DADBC52_81773165 = (mBoundApplication != null && SamplingProfilerIntegration.isEnabled());
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

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.088 -0400", hash_original_field = "722CEDE668F96C619AD9AE4EE59CCD7B", hash_generated_field = "79EE3E0E74CCDF8DA485137663462447")

        public static final int LAUNCH_ACTIVITY         = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.088 -0400", hash_original_field = "7C6BEE59AC8DEB3272ACA35B77D0ECB8", hash_generated_field = "F6E6C101887932ADB1F39FD5B86A118E")

        public static final int PAUSE_ACTIVITY          = 101;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.102 -0400", hash_original_field = "27E7CCADA8E378177A09B210CB7998B9", hash_generated_field = "09D07137EA5653F1E891575A10F54C95")

        public static final int PAUSE_ACTIVITY_FINISHING= 102;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.104 -0400", hash_original_field = "DC0C14DC0B1F89A47A5B1280137AB9E3", hash_generated_field = "EC045D213E7DCC46FAC0B6AAED7E85D6")

        public static final int STOP_ACTIVITY_SHOW      = 103;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.104 -0400", hash_original_field = "E188806E5AACE94BD962909A9F9D11B7", hash_generated_field = "25971E3B508C10EDB2E29C96206F822B")

        public static final int STOP_ACTIVITY_HIDE      = 104;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.104 -0400", hash_original_field = "D3BBE314F0306D0843A920C0579FAD38", hash_generated_field = "0FBE2B02A08E08DD92AF03DD97DDA5AE")

        public static final int SHOW_WINDOW             = 105;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.106 -0400", hash_original_field = "AEEF026EB5CD7DCEC2DB87D54CB22A26", hash_generated_field = "B048EDF2C316D4329B5527B43CEDFE50")

        public static final int HIDE_WINDOW             = 106;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.124 -0400", hash_original_field = "518DFFD71C73003A033FA6BC1B294FC6", hash_generated_field = "D40012091267201A48CEA7D4C55C1620")

        public static final int RESUME_ACTIVITY         = 107;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.125 -0400", hash_original_field = "40995C694C9D49F47FA7514A7F959820", hash_generated_field = "A40A106C973F0FB170D2DAC3448C5A13")

        public static final int SEND_RESULT             = 108;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.125 -0400", hash_original_field = "2BCF8356B8869C9E49E05C226AB9C831", hash_generated_field = "F3C8D3955BE8F2810694F3E7013C556E")

        public static final int DESTROY_ACTIVITY        = 109;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.141 -0400", hash_original_field = "72110ACC314A9846CE925BF8B24FB2C4", hash_generated_field = "9E021100AE53B786AFAD15A16329BAB4")

        public static final int BIND_APPLICATION        = 110;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.142 -0400", hash_original_field = "C8EB10E0EF2483EDA8A276929FEC0A42", hash_generated_field = "D9A851E248DD3DA74E867B25E117FD22")

        public static final int EXIT_APPLICATION        = 111;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.142 -0400", hash_original_field = "C51444BA300FE3DFDBF5E4BACC59B339", hash_generated_field = "E81354CA5082AEBC39D8C31B119790DD")

        public static final int NEW_INTENT              = 112;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.143 -0400", hash_original_field = "5F934832E9EA645D6B42B183077116BE", hash_generated_field = "BC2E16123EEC2C2FE2146178A6F6EBE7")

        public static final int RECEIVER                = 113;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.159 -0400", hash_original_field = "DF58095DA1EF21EA8AFE7DC349A8C5EE", hash_generated_field = "46F82A63643EBF3740DA044A97C411BD")

        public static final int CREATE_SERVICE          = 114;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.159 -0400", hash_original_field = "ADC07D5CB42F74F249ED9FA053F1F453", hash_generated_field = "A20CACB6EB007BA6D6D1EAE18B100F96")

        public static final int SERVICE_ARGS            = 115;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.160 -0400", hash_original_field = "DA80AE7CA253D962B8BA0A9C2B53B49E", hash_generated_field = "AB975960BB4220B2FCB171489C6584C5")

        public static final int STOP_SERVICE            = 116;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.160 -0400", hash_original_field = "8FDB2CCAA7CDF8F31A6175479EDFB50A", hash_generated_field = "DA58382979407C0DCE4E024C9F856907")

        public static final int REQUEST_THUMBNAIL       = 117;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.167 -0400", hash_original_field = "1832887E832CF03CCE11F98660915BA9", hash_generated_field = "F8782D86E0C72BFCA118C31A420D9DB2")

        public static final int CONFIGURATION_CHANGED   = 118;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.168 -0400", hash_original_field = "B69BEAC73959E05CD1A9C07F9E505BF9", hash_generated_field = "203638C0D401316316F231069A439983")

        public static final int CLEAN_UP_CONTEXT        = 119;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.169 -0400", hash_original_field = "524F3CBD925BC2700E2FE96AFB6C6814", hash_generated_field = "7FDF10F5D0B32576CCE522E8063EE1AB")

        public static final int GC_WHEN_IDLE            = 120;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.169 -0400", hash_original_field = "3742E17E26429D8B18102CF3986F6EC2", hash_generated_field = "FA82AB4CAC5570F743636186326BBBCB")

        public static final int BIND_SERVICE            = 121;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.181 -0400", hash_original_field = "15BD5376B9A6F8BB72279CD48F03813F", hash_generated_field = "3AA49274B99CB4754DE7AAC22A64097B")

        public static final int UNBIND_SERVICE          = 122;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.181 -0400", hash_original_field = "4CE5A2061279EE1D7222C2D95BD68317", hash_generated_field = "BE57D55C848AF78B6D13D08C75CD3890")

        public static final int DUMP_SERVICE            = 123;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.182 -0400", hash_original_field = "CE13FEC4244FD5042DEA52894A5793E4", hash_generated_field = "016852C1459DE34F8D1BECDF172A7A3B")

        public static final int LOW_MEMORY              = 124;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.182 -0400", hash_original_field = "C7101CE79C508314D48E359FD888E39C", hash_generated_field = "C1874358A5069FBBE942CA7B4FEB06AC")

        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.193 -0400", hash_original_field = "FA7FD8D6AC5C010F87FE5A85800EF7ED", hash_generated_field = "F66CB5E4AB6DEA952AC6C4AC4FD8129C")

        public static final int RELAUNCH_ACTIVITY       = 126;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.194 -0400", hash_original_field = "0ECDAAA38F1875EBF22B06CF4D97840D", hash_generated_field = "B3A767EE70C05E487D7B390CB511DE9C")

        public static final int PROFILER_CONTROL        = 127;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.195 -0400", hash_original_field = "3BC29C9DB33C1749A39F6BAE42EB6789", hash_generated_field = "385AB826C3B946556BB8D2BA1F6167CB")

        public static final int CREATE_BACKUP_AGENT     = 128;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.196 -0400", hash_original_field = "C783232AA4EE8DD32768F1B54E157355", hash_generated_field = "72995E16D3DBD2A4679635D4E61FC49D")

        public static final int DESTROY_BACKUP_AGENT    = 129;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.196 -0400", hash_original_field = "A0AB320ED67492363EAFB1A4223F0B32", hash_generated_field = "2E6A83D9FB3FCAFBC6EA64132F417F75")

        public static final int SUICIDE                 = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.254 -0400", hash_original_field = "9A5FCDBB5243520A850EF658F203D220", hash_generated_field = "7DBF1A92BA0E6AA87182CD56B3D107E3")

        public static final int REMOVE_PROVIDER         = 131;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.255 -0400", hash_original_field = "66EC3392B95DE4AF1DB032BB1B33C503", hash_generated_field = "AA41E7437D6E941DE853C39868725DE4")

        public static final int ENABLE_JIT              = 132;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.255 -0400", hash_original_field = "97FF97449C421C91A81CB7768A612B09", hash_generated_field = "77AEBFDF31780CFDC843B8D9EAB26B65")

        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.256 -0400", hash_original_field = "750A8194549152ABCA207A461974A0F2", hash_generated_field = "2F79168F541635B32A56D3A800568EB5")

        public static final int SCHEDULE_CRASH          = 134;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.256 -0400", hash_original_field = "CE74C94F7495E6DA3E31F74989140E11", hash_generated_field = "AE9A74DBF18BA76BECBDADA426FDD8D1")

        public static final int DUMP_HEAP               = 135;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.270 -0400", hash_original_field = "B1D84959B056AFDF77A071642B0B4DDE", hash_generated_field = "2312CB238555E0BCB137FC118844BDC3")

        public static final int DUMP_ACTIVITY           = 136;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.270 -0400", hash_original_field = "EC1261A9F39672203AD216DA43C7C314", hash_generated_field = "4EAC68079DDB116BDF58C13AC47AF396")

        public static final int SLEEPING                = 137;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.271 -0400", hash_original_field = "33DB7ACE50C2A3180517FF1D30A7D18B", hash_generated_field = "7CA400DE0EBC79FF2A4805A342BE87B5")

        public static final int SET_CORE_SETTINGS       = 138;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.271 -0400", hash_original_field = "930E95663EFFE03E81FB9BE166DBCB37", hash_generated_field = "CFEBE5355040D28519CBFFA29E96E50F")

        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.282 -0400", hash_original_field = "C8ED1A4929B7571B8B7A3A096311133B", hash_generated_field = "CF745352D226FFB32A7FEB6BFD662619")

        public static final int TRIM_MEMORY             = 140;
    }


    
    private class Idler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.283 -0400", hash_original_method = "33AE74878CEBE3B527FC27BCFED9133E", hash_generated_method = "33AE74878CEBE3B527FC27BCFED9133E")
        public Idler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.299 -0400", hash_original_method = "7124AFC3D8D2CB12FD15B850DC795363", hash_generated_method = "0934EA612C4A9896A4F675CF0A506267")
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
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_933194628 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_933194628;
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    final class GcIdler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.300 -0400", hash_original_method = "ABBE7DCE196E12604C1E7133F511F6FC", hash_generated_method = "ABBE7DCE196E12604C1E7133F511F6FC")
        public GcIdler ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.320 -0400", hash_original_method = "44179B8732E18ADC2B8565E550483147", hash_generated_method = "CEC34B0A8FD98E07AD85B2CA22151F95")
        public final boolean queueIdle() {
            doGcIfNeeded();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_218252457 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_218252457;
            // ---------- Original Method ----------
            //doGcIfNeeded();
            //return false;
        }

        
    }


    
    private static class ResourcesKey {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.321 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

        private String mResDir;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.321 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "8561DC852E8BD04B40EFBC1F32D92895")

        private float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.322 -0400", hash_original_field = "EDC211DB900F40F9CAE89C00A3C90AD9", hash_generated_field = "A7D12DAC99918DD08DC20BE8E0E23E1B")

        private int mHash;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.323 -0400", hash_original_method = "0A249A0E32348D1ED1AC3A6D16406BEA", hash_generated_method = "60A5475EFF1937E45B7BF5B2F50F200B")
          ResourcesKey(String resDir, float scale) {
            mResDir = resDir;
            mScale = scale;
            mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
            // ---------- Original Method ----------
            //mResDir = resDir;
            //mScale = scale;
            //mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.343 -0400", hash_original_method = "FDD99B6C6105A3F31D8E7DC9390101DA", hash_generated_method = "FE90565CFCFF55A6ADA6223744167648")
        @Override
        public int hashCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924300253 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924300253;
            // ---------- Original Method ----------
            //return mHash;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.352 -0400", hash_original_method = "07DFB89699884113D8C2B96163B07C7F", hash_generated_method = "D93461E2EC7FBC324A4A3ABF057A82C6")
        @Override
        public boolean equals(Object obj) {
            ResourcesKey peer;
            peer = (ResourcesKey) obj;
            boolean var54097B77060828B14B7DD9EC110667F0_2096928902 = (mResDir.equals(peer.mResDir) && mScale == peer.mScale);
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1929903568 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1929903568;
            // ---------- Original Method ----------
            //if (!(obj instanceof ResourcesKey)) {
                //return false;
            //}
            //ResourcesKey peer = (ResourcesKey) obj;
            //return mResDir.equals(peer.mResDir) && mScale == peer.mScale;
        }

        
    }


    
    private static class StopInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.353 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "671EE8F19CE89CCA3E5285825682D0E2")

        Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.353 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB")

        CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.372 -0400", hash_original_method = "59EF1C21B91F2644F32BF61E1E80BB9E", hash_generated_method = "59EF1C21B91F2644F32BF61E1E80BB9E")
        public StopInfo ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ProviderRefCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.373 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.375 -0400", hash_original_method = "92B7A170BA9BC140C9702B48E38F46E8", hash_generated_method = "4A93BF52DF489431CBF421164E067011")
          ProviderRefCount(int pCount) {
            count = pCount;
            // ---------- Original Method ----------
            //count = pCount;
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.393 -0400", hash_original_field = "34FDD53B5E6A10E8767A5E0043343C94", hash_generated_field = "425ACCA9C7A1870DD248AAA65FD54971")

    public static final String TAG = "ActivityThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.393 -0400", hash_original_field = "83F8875443EA39A07A5B37A3724C8054", hash_generated_field = "5ADA15DD6F3ED9E9A9023E7BCC7EBFDC")

    private static android.graphics.Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.394 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "28F5FC4643EA692F03C0CC4366480592")

    static boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.406 -0400", hash_original_field = "B3FD9C27E71EC619E39A58558EDF3036", hash_generated_field = "A7753FF800A1A4F708A4ADE0D56E842C")

    static boolean DEBUG_MESSAGES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.411 -0400", hash_original_field = "07B77DD4826C3BEC455D95A864B72887", hash_generated_field = "6C9EE624F63E1C2CAB461CACB0D16387")

    public static final boolean DEBUG_BROADCAST = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.411 -0400", hash_original_field = "C1F0DE5C32CA1844900CC6BE3D463A43", hash_generated_field = "8D10A31B2B31FF1FC47E4525564CB8B5")

    private static boolean DEBUG_RESULTS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.413 -0400", hash_original_field = "02D938CC958225A67031500CA26D971D", hash_generated_field = "339254FF67592E98703CDFEBF99DD13C")

    private static boolean DEBUG_BACKUP = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.413 -0400", hash_original_field = "D146DDB94A0D3A63C400058639AEBC96", hash_generated_field = "6C4DF1581599C9814FBF1C85B8C65CED")

    private static boolean DEBUG_CONFIGURATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.414 -0400", hash_original_field = "95E53F781A83DB02B99AB3900C2C7910", hash_generated_field = "52A281005C5DBFAFA5426EBAACBB12C9")

    private static long MIN_TIME_BETWEEN_GCS = 5*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.414 -0400", hash_original_field = "CA66A5F91375944277EA9D4BD909BB19", hash_generated_field = "7DAFEE4434BBF05141D16A737F37FBB1")

    private static Pattern PATTERN_SEMICOLON = Pattern.compile(";");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.435 -0400", hash_original_field = "9286A6A3B31A2E01F0E11BFB8849AA7C", hash_generated_field = "31505C426AE4CDDC81AA0A96EF0E64EF")

    private static int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.436 -0400", hash_original_field = "BB5DE43B41F17D8A8E055223ED42E745", hash_generated_field = "F61AA9B84217E513EE1EE11A5C6D8431")

    private static int LOG_ON_PAUSE_CALLED = 30021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.437 -0400", hash_original_field = "80F691776CC864CF51EEA7DD7E478D83", hash_generated_field = "A4E8E19C15E3E1C5A33C09AB209343E4")

    private static int LOG_ON_RESUME_CALLED = 30022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.437 -0400", hash_original_field = "E95028B5077B5EE8819464B14D52B9CA", hash_generated_field = "C6FF716724281192967733BEA8F63EE5")

    static ContextImpl mSystemContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.438 -0400", hash_original_field = "758BE64E47881C41CB626D9F77009B70", hash_generated_field = "89DED1E64F20B301AC92B7782A3B4974")

    static IPackageManager sPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.438 -0400", hash_original_field = "5C9F282BC1F2B74095E784FCC3BEC9F9", hash_generated_field = "DBC757AAAD24F8A1EBDA3CE1967506D2")

    static ThreadLocal<ActivityThread> sThreadLocal = new ThreadLocal<ActivityThread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.439 -0400", hash_original_field = "03FC11B1885ADD83E904E0299842923E", hash_generated_field = "FBC75DA053AA4DB0E9FC91A30C88AF67")

    static Handler sMainThreadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.439 -0400", hash_original_field = "3BEAF3224097BD2645583753F770DF18", hash_generated_field = "67B16105E0C69F35F358A0B461F346A9")

    private static ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<Intent>();
}

