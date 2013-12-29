package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

import org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl;

import android.app.backup.BackupAgent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks2;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.IContentProvider;
import android.content.IIntentReceiver;
import android.content.Intent;
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

import dalvik.system.CloseGuard;





final class SuperNotCalledException extends AndroidRuntimeException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.895 -0500", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "1F29AF520F96DCB843FE454A7E9FE89B")
    public SuperNotCalledException(String msg) {
        super(msg);
    }

    
}

final class RemoteServiceException extends AndroidRuntimeException {
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.896 -0500", hash_original_method = "34FE87499D0272DFF74E34D7FF4C8A87", hash_generated_method = "1DEEB7C2C8BCD141939C3A8EBF7F139B")
    public RemoteServiceException(String msg) {
        super(msg);
    }

    
}

public final class ActivityThread {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.144 -0500", hash_original_method = "B43C4B997DC053246807238458D91719", hash_generated_method = "135A581E9B81E728594BD7DE7A17114E")
    public static ActivityThread currentActivityThread() {
        return sThreadLocal.get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.145 -0500", hash_original_method = "640ED9247EF2ADAB1EA1DDD62E15A222", hash_generated_method = "537D5F980E72380AE35412B34ED09AFA")
    public static String currentPackageName() {
        ActivityThread am = currentActivityThread();
        return (am != null && am.mBoundApplication != null)
            ? am.mBoundApplication.processName : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.146 -0500", hash_original_method = "F6FC3F72525CD988EE04D3FABD038B41", hash_generated_method = "88F02418DA4B139D2F80F444B2991324")
    public static Application currentApplication() {
        ActivityThread am = currentActivityThread();
        return am != null ? am.mInitialApplication : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.147 -0500", hash_original_method = "7E3EB5C870116C74F7B4935A8BC43ADB", hash_generated_method = "27B1DCDC7C3AFDB4ACA86D0A0E179967")
    public static IPackageManager getPackageManager() {
        if (sPackageManager != null) {
            //Slog.v("PackageManager", "returning cur default = " + sPackageManager);
            return sPackageManager;
        }
        IBinder b = ServiceManager.getService("package");
        //Slog.v("PackageManager", "default service binder = " + b);
        sPackageManager = IPackageManager.Stub.asInterface(b);
        //Slog.v("PackageManager", "default service = " + sPackageManager);
        return sPackageManager;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.148 -0500", hash_original_method = "A1CC0994011C4FE3A611CF29B99A9A46", hash_generated_method = "67A8AB666BB3F082510149DEA07C6205")
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

    /**
     * Return the Intent that's currently being handled by a
     * BroadcastReceiver on this thread, or null if none.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.187 -0500", hash_original_method = "C612CA2769E27EDD7F2EF90666FE3AAF", hash_generated_method = "A4ECD6049017AA9A0EC6CBDFBC54F48B")
    public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.227 -0500", hash_original_method = "F5ECC439B2FFCFACFF5AE332BA877BBF", hash_generated_method = "CE8ECF64254AE6EE59209D5607D18870")
    private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.264 -0500", hash_original_method = "3031C3AD0580201714017D8D3B26A21F", hash_generated_method = "72A6B0535639DEB40CC7410282DE08EB")
    public static final ActivityThread systemMain() {
        HardwareRenderer.disable(true);
        ActivityThread thread = new ActivityThread();
        thread.attach(true);
        return thread;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.266 -0500", hash_original_method = "72236BB11347CD1C488A8F097A7D962C", hash_generated_method = "DF5D248390DF4B437544B42B73BF8848")
    public static void main(String[] args) {
        SamplingProfilerIntegration.start();

        // CloseGuard defaults to true and can be quite spammy.  We
        // disable it here, but selectively enable it later (via
        // StrictMode) on debug builds, but using DropBox, not logs.
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.900 -0500", hash_original_field = "BD17C01956B3F943F6EFE0B2AFFE4CEC", hash_generated_field = "425ACCA9C7A1870DD248AAA65FD54971")

    public static final String TAG = "ActivityThread";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.901 -0500", hash_original_field = "9830E7C5E9FC278EEF7117A0BC2AD165", hash_generated_field = "4FF79E3794E106C584E301B2B6BC3768")

    private static final android.graphics.Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.902 -0500", hash_original_field = "7A06C0A50B73200DDC70097F2AFFF800", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.902 -0500", hash_original_field = "0447C0A0DB0F042DA1CFC51C3A9A5BAA", hash_generated_field = "3E8F6F612D86B529FF072C0082938083")

    static final boolean DEBUG_MESSAGES = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.903 -0500", hash_original_field = "8175643F6E45D5F83B913794FF32FD0B", hash_generated_field = "6C9EE624F63E1C2CAB461CACB0D16387")

    public static final boolean DEBUG_BROADCAST = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.904 -0500", hash_original_field = "2B7FD3372FCA88D8372FD5EFD6C55ED7", hash_generated_field = "91674D83CE8A87566FA90CCE79A6CC85")

    private static final boolean DEBUG_RESULTS = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.905 -0500", hash_original_field = "5A64E91E40B151CDCE12966F4DD2F2A9", hash_generated_field = "1C5ED879567745A3D8BB78B4EBE8FFE6")

    private static final boolean DEBUG_BACKUP = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.906 -0500", hash_original_field = "D809AAB573654CE02E5B3C492F6A9870", hash_generated_field = "56656CF0D95F01C6330394450066014A")

    private static final boolean DEBUG_CONFIGURATION = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.907 -0500", hash_original_field = "C723B47ACBFB53B699227B20CE790E9A", hash_generated_field = "F1C876B177B2AB25A282C24BF376C834")

    private static final long MIN_TIME_BETWEEN_GCS = 5*1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.908 -0500", hash_original_field = "F02291C03B8300C2CA6695C4315B3D78", hash_generated_field = "281968F0BF027264BDDA5DC375DC6283")

    private static final Pattern PATTERN_SEMICOLON = Pattern.compile(";");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.909 -0500", hash_original_field = "3EE8A922C8504C4FBDD5C4D5C0158A3F", hash_generated_field = "6F19A1C876184A0ADFFBF4577E6D8405")

    private static final int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.909 -0500", hash_original_field = "D17A8068CF232371FA0B095A22655C4D", hash_generated_field = "E28C89FE2A6C28B4023589A16739DF35")

    private static final int LOG_ON_PAUSE_CALLED = 30021;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.910 -0500", hash_original_field = "3B584F8DD81D9F302FEE6D4B005E7E04", hash_generated_field = "527D0F0BC32722D4952F258103167308")

    private static final int LOG_ON_RESUME_CALLED = 30022;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.911 -0500", hash_original_field = "7799910C62F22F96C1AC44438B0BF40B", hash_generated_field = "C6FF716724281192967733BEA8F63EE5")


    static ContextImpl mSystemContext = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.912 -0500", hash_original_field = "39F897E7C0D722D99D5FAAEEC367DC33", hash_generated_field = "89DED1E64F20B301AC92B7782A3B4974")


    static IPackageManager sPackageManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.924 -0500", hash_original_field = "7909FF35FAEDBD41BAEFDEEACDA24D35", hash_generated_field = "5C8AC51EFF922C63EFC9F15B72A07218")

    static final ThreadLocal<ActivityThread> sThreadLocal = new ThreadLocal<ActivityThread>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.939 -0500", hash_original_field = "B5F712DF6A1DB744AC0CA5AF128CC6B7", hash_generated_field = "FBC75DA053AA4DB0E9FC91A30C88AF67")


    static Handler sMainThreadHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.186 -0500", hash_original_field = "4757F4742004C0AAB0DCF841A0441800", hash_generated_field = "2F4C1A0F908C99E4E3AF95D1DBBBE434")


    private static final ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<Intent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.913 -0500", hash_original_field = "4BE2592600E22B88F19E5AEDA9C6D0D0", hash_generated_field = "2C05F6440224B9B7B649AAB8E25E7F6C")


    final ApplicationThread mAppThread = new ApplicationThread();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.913 -0500", hash_original_field = "AF37A7D9D38B32899A98EE8F575828DF", hash_generated_field = "9DB6C1654FE8632B559AD8938C2BB6D6")

    final Looper mLooper = Looper.myLooper();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.914 -0500", hash_original_field = "387995F77ECCE28306AB6C09BAF19C94", hash_generated_field = "C347DA9A9231B315F279E735B8928A09")

    final H mH = new H();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.915 -0500", hash_original_field = "615CD00F7E8F11F57B5DF4C0815D5B17", hash_generated_field = "22A9122B8D2BCD21314C7F1C05E1CE1E")

    final HashMap<IBinder, ActivityClientRecord> mActivities
            = new HashMap<IBinder, ActivityClientRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:10.156 -0500", hash_original_field = "B71C13DCB6A9130D877B8D4E74CC61E9", hash_generated_field = "F2029066AE49FF02D92255E8D73B7AF8")

    // be reported when next we idle.
    ActivityClientRecord mNewActivities = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.916 -0500", hash_original_field = "C9408B24459238C3188BD4D966397F6A", hash_generated_field = "C9408B24459238C3188BD4D966397F6A")

    int mNumVisibleActivities = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.917 -0500", hash_original_field = "CD62060FA8FAA93F07C42F15DA265597", hash_generated_field = "273635D78F4F1853FCFEAE6F3977F1CA")

    final HashMap<IBinder, Service> mServices
            = new HashMap<IBinder, Service>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.918 -0500", hash_original_field = "61B01177607D3FEF9030C1D9609A65D2", hash_generated_field = "61B01177607D3FEF9030C1D9609A65D2")

    AppBindData mBoundApplication;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.918 -0500", hash_original_field = "137FC81C700701DC4596025475ABF5FB", hash_generated_field = "137FC81C700701DC4596025475ABF5FB")

    Profiler mProfiler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.919 -0500", hash_original_field = "17926FA2B84283931976E0CD16AD732E", hash_generated_field = "17926FA2B84283931976E0CD16AD732E")

    Configuration mConfiguration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.920 -0500", hash_original_field = "22A6186D8E2A9BFF1CD600DA1D66E51D", hash_generated_field = "22A6186D8E2A9BFF1CD600DA1D66E51D")

    Configuration mCompatConfiguration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.920 -0500", hash_original_field = "EAF24A11BB6A5B40B8CD0A9DD97E14E0", hash_generated_field = "EAF24A11BB6A5B40B8CD0A9DD97E14E0")

    Configuration mResConfiguration;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.921 -0500", hash_original_field = "EA04CA285EC541B77CDD4831DDC16DBF", hash_generated_field = "EA04CA285EC541B77CDD4831DDC16DBF")

    CompatibilityInfo mResCompatibilityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.922 -0500", hash_original_field = "9E9AEECCAC03AFADA449BC8121CFBA7B", hash_generated_field = "9E9AEECCAC03AFADA449BC8121CFBA7B")

    Application mInitialApplication;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.923 -0500", hash_original_field = "04472E000F282817521CDA08EBAABE2D", hash_generated_field = "4467AD43E1EF6F9556A530390DF013D4")

    final ArrayList<Application> mAllApplications
            = new ArrayList<Application>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.923 -0500", hash_original_field = "22A081A93589AAECA93930928B5ABCF5", hash_generated_field = "3547FC58C151AD461F39E0C090811C7E")

    final HashMap<String, BackupAgent> mBackupAgents = new HashMap<String, BackupAgent>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.925 -0500", hash_original_field = "5CBE0F2EE224A7AD181F35AE16EC5D56", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

    Instrumentation mInstrumentation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.926 -0500", hash_original_field = "BC772FC243D47A489F2D7EFDAE87E511", hash_generated_field = "BC772FC243D47A489F2D7EFDAE87E511")

    String mInstrumentationAppDir = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.926 -0500", hash_original_field = "FECBD9A8D7E48015CA8B1CB4E8417096", hash_generated_field = "FECBD9A8D7E48015CA8B1CB4E8417096")

    String mInstrumentationAppPackage = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.927 -0500", hash_original_field = "8A05224BF80336D163F84B1774E94778", hash_generated_field = "8A05224BF80336D163F84B1774E94778")

    String mInstrumentedAppDir = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.928 -0500", hash_original_field = "A1282214A6522F9FAF740141A5995478", hash_generated_field = "A1282214A6522F9FAF740141A5995478")

    boolean mSystemThread = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.929 -0500", hash_original_field = "CA9794682AE3611FC2EF8314769D534A", hash_generated_field = "CA9794682AE3611FC2EF8314769D534A")

    boolean mJitEnabled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:10.170 -0500", hash_original_field = "FEA27B20D4A63203859011A457861469", hash_generated_field = "B90DC9E5AB19FCA9DF53EB39A292FE26")

    // XXX For now we keep around information about all packages we have
    // seen, not removing entries from this map.
    // NOTE: The activity and window managers need to call in to
    // ActivityThread to do things like update resource configurations,
    // which means this lock gets held while the activity and window managers
    // holds their own lock.  Thus you MUST NEVER call back into the activity manager
    // or window manager or anything that depends on them while holding this lock.
    final HashMap<String, WeakReference<LoadedApk>> mPackages
            = new HashMap<String, WeakReference<LoadedApk>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.931 -0500", hash_original_field = "EC7A0BFBB55936D0B61B3B563F70B364", hash_generated_field = "D05B59FB5762244EFE6413375736785F")

    final HashMap<String, WeakReference<LoadedApk>> mResourcePackages
            = new HashMap<String, WeakReference<LoadedApk>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.931 -0500", hash_original_field = "00C29CB9D971953C68B055F0717AB51D", hash_generated_field = "E6A3BBCB9BEFEBC10A10A94F36F55D2A")

    final HashMap<CompatibilityInfo, DisplayMetrics> mDisplayMetrics
            = new HashMap<CompatibilityInfo, DisplayMetrics>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.932 -0500", hash_original_field = "A643317325A53EF83EA8267E12E4A2B1", hash_generated_field = "54C77904755445223E6762582AF7167C")

    final HashMap<ResourcesKey, WeakReference<Resources> > mActiveResources
            = new HashMap<ResourcesKey, WeakReference<Resources> >();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.933 -0500", hash_original_field = "BBDA8BFABB6CB4331606809C8A32FCD7", hash_generated_field = "FDE1BC39BB1A6D9E731AFE2002BB269D")

    final ArrayList<ActivityClientRecord> mRelaunchingActivities
            = new ArrayList<ActivityClientRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.933 -0500", hash_original_field = "52608F8A47308D1928152A18CB1F8EE5", hash_generated_field = "52608F8A47308D1928152A18CB1F8EE5")

    Configuration mPendingConfiguration = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.934 -0500", hash_original_field = "F0523ED3D6D76B895086A38833AF30AD", hash_generated_field = "1CEA5FD2A88003C9D7DAC40EC96872BE")

    final HashMap<String, ProviderClientRecord> mProviderMap
        = new HashMap<String, ProviderClientRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.935 -0500", hash_original_field = "CAD5A9D5BD21F26ABF851CA219AABC58", hash_generated_field = "1C776D7BB444F45BF4ABA07E0A6EA27B")

    final HashMap<IBinder, ProviderRefCount> mProviderRefCountMap
        = new HashMap<IBinder, ProviderRefCount>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.936 -0500", hash_original_field = "0DD2F59DEA9CF73864C3201947856DF3", hash_generated_field = "77FD57C0A1A6E5A9B2317F5C55C5410F")

    final HashMap<IBinder, ProviderClientRecord> mLocalProviders
        = new HashMap<IBinder, ProviderClientRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.936 -0500", hash_original_field = "21DB313BBB4D9FE4E9279F224291BC66", hash_generated_field = "7290AC21C9E09A440EA99C73747C36E5")


    final HashMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners
        = new HashMap<Activity, ArrayList<OnActivityPausedListener>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.937 -0500", hash_original_field = "9A2BB5A7170EE3CC26087AD938361046", hash_generated_field = "0DC5B4AA3D0A311BCB82DC76A964596E")


    final GcIdler mGcIdler = new GcIdler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.938 -0500", hash_original_field = "42912703516C643929BE4407C1512E06", hash_generated_field = "42912703516C643929BE4407C1512E06")

    boolean mGcIdlerScheduled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.939 -0500", hash_original_field = "5193B2043B5018140A114729BFBC1AB5", hash_generated_field = "5193B2043B5018140A114729BFBC1AB5")


    Bundle mCoreSettings = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.149 -0500", hash_original_field = "C0B026A64FCB5CE4BBEAECE65EDAB00E", hash_generated_field = "218DF766A932DC18C65DC16EEE9A759F")


    private Configuration mMainThreadConfig = new Configuration();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.201 -0500", hash_original_field = "89D545404DE284326B58312949C90BC9", hash_generated_field = "4A61C1EAE378A13AF88688B33DC5A9C1")


    private int mThumbnailWidth = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.202 -0500", hash_original_field = "B5422D7CF870E707C3ADDC5B87F8536A", hash_generated_field = "B5D585F47D7019D989CAAE6F1896D3A6")

    private int mThumbnailHeight = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.203 -0500", hash_original_field = "0BF06AEAF129C9F8287729AC8389AAAF", hash_generated_field = "86CFFC9A0E84C08A1C5D2192C683E8D7")

    private Bitmap mAvailThumbnailBitmap = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.204 -0500", hash_original_field = "30D47B44CFF77068A7375251BAEDED8F", hash_generated_field = "1246BE5370B0FC65915F756626A5C46E")

    private Canvas mThumbnailCanvas = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.159 -0500", hash_original_method = "C5DB87E83A0D8D66EF8ECA86A91864C7", hash_generated_method = "C5DB87E83A0D8D66EF8ECA86A91864C7")
    ActivityThread() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:36:10.275 -0500", hash_original_method = "FA5B9DB827774258D426805F82794E0D", hash_generated_method = "094F99CB9F5AEDB4189B4D4CEF3C26FF")
    private native void dumpGraphicsInfo(FileDescriptor fd);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.147 -0500", hash_original_method = "E45CB384263D7EF5FBA0A98360B08B32", hash_generated_method = "3F774A9FE0F0903602F168B8AD61E6E1")
    DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo ci, boolean forceUpdate) {
        DisplayMetrics dm = mDisplayMetrics.get(ci);
        if (dm != null && !forceUpdate) {
            return dm;
        }
        if (dm == null) {
            dm = new DisplayMetrics();
            mDisplayMetrics.put(ci, dm);
        }
        Display d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        d.getMetrics(dm);
        //Slog.i("foo", "New metrics: w=" + metrics.widthPixels + " h="
        //        + metrics.heightPixels + " den=" + metrics.density
        //        + " xdpi=" + metrics.xdpi + " ydpi=" + metrics.ydpi);
        return dm;
    }
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.150 -0500", hash_original_method = "DD63F0FD46EA5914D44A0437CF6968C9", hash_generated_method = "DD63F0FD46EA5914D44A0437CF6968C9")
    Configuration applyConfigCompatMainThread(Configuration config, CompatibilityInfo compat) {
        if (config == null) {
            return null;
        }
        if (compat != null && !compat.supportsScreen()) {
            mMainThreadConfig.setTo(config);
            config = mMainThreadConfig;
            compat.applyToConfiguration(config);
        }
        return config;
    }

    /**
     * Creates the top level Resources for applications with the given compatibility info.
     *
     * @param resDir the resource directory.
     * @param compInfo the compability info. It will use the default compatibility info when it's
     * null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.151 -0500", hash_original_method = "371F1E66BBE63CA5CE35B0BEAA492ADA", hash_generated_method = "D0EFA0416DCD1F6829E1A445070B2B89")
    Resources getTopLevelResources(String resDir, CompatibilityInfo compInfo) {
        ResourcesKey key = new ResourcesKey(resDir, compInfo.applicationScale);
        Resources r;
        synchronized (mPackages) {
            // Resources is app scale dependent.
            if (false) {
                Slog.w(TAG, "getTopLevelResources: " + resDir + " / "
                        + compInfo.applicationScale);
            }
            WeakReference<Resources> wr = mActiveResources.get(key);
            r = wr != null ? wr.get() : null;
            //if (r != null) Slog.i(TAG, "isUpToDate " + resDir + ": " + r.getAssets().isUpToDate());
            if (r != null && r.getAssets().isUpToDate()) {
                if (false) {
                    Slog.w(TAG, "Returning cached resources " + r + " " + resDir
                            + ": appScale=" + r.getCompatibilityInfo().applicationScale);
                }
                return r;
            }
        }

        //if (r != null) {
        //    Slog.w(TAG, "Throwing away out-of-date resources!!!! "
        //            + r + " " + resDir);
        //}

        AssetManager assets = new AssetManager();
        if (assets.addAssetPath(resDir) == 0) {
            return null;
        }

        //Slog.i(TAG, "Resource: key=" + key + ", display metrics=" + metrics);
        DisplayMetrics metrics = getDisplayMetricsLocked(null, false);
        r = new Resources(assets, metrics, getConfiguration(), compInfo);
        if (false) {
            Slog.i(TAG, "Created app resources " + resDir + " " + r + ": "
                    + r.getConfiguration() + " appScale="
                    + r.getCompatibilityInfo().applicationScale);
        }
        
        synchronized (mPackages) {
            WeakReference<Resources> wr = mActiveResources.get(key);
            Resources existing = wr != null ? wr.get() : null;
            if (existing != null && existing.getAssets().isUpToDate()) {
                // Someone else already created the resources while we were
                // unlocked; go ahead and use theirs.
                r.getAssets().close();
                return existing;
            }
            
            // XXX need to remove entries when weak references go away
            mActiveResources.put(key, new WeakReference<Resources>(r));
            return r;
        }
    }

    /**
     * Creates the top level resources for the given package.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.151 -0500", hash_original_method = "9D648CED90369A8409E4C88D7CE96759", hash_generated_method = "9D648CED90369A8409E4C88D7CE96759")
    Resources getTopLevelResources(String resDir, LoadedApk pkgInfo) {
        return getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.152 -0500", hash_original_method = "F7A72EDCDC7800374FD6BBEAFCDB636B", hash_generated_method = "C44BA17ADD31F51332C6E8D0AD6960C9")
    final Handler getHandler() {
        return mH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.153 -0500", hash_original_method = "FD6B2C09494E94CB4CF03F9000F967F2", hash_generated_method = "4081A83E22325FA3E792686D86F401C7")
    public final LoadedApk getPackageInfo(String packageName, CompatibilityInfo compatInfo,
            int flags) {
        synchronized (mPackages) {
            WeakReference<LoadedApk> ref;
            if ((flags&Context.CONTEXT_INCLUDE_CODE) != 0) {
                ref = mPackages.get(packageName);
            } else {
                ref = mResourcePackages.get(packageName);
            }
            LoadedApk packageInfo = ref != null ? ref.get() : null;
            //Slog.i(TAG, "getPackageInfo " + packageName + ": " + packageInfo);
            //if (packageInfo != null) Slog.i(TAG, "isUptoDate " + packageInfo.mResDir
            //        + ": " + packageInfo.mResources.getAssets().isUpToDate());
            if (packageInfo != null && (packageInfo.mResources == null
                    || packageInfo.mResources.getAssets().isUpToDate())) {
                if (packageInfo.isSecurityViolation()
                        && (flags&Context.CONTEXT_IGNORE_SECURITY) == 0) {
                    throw new SecurityException(
                            "Requesting code from " + packageName
                            + " to be run in process "
                            + mBoundApplication.processName
                            + "/" + mBoundApplication.appInfo.uid);
                }
                return packageInfo;
            }
        }

        ApplicationInfo ai = null;
        try {
            ai = getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_SHARED_LIBRARY_FILES);
        } catch (RemoteException e) {
            // Ignore
        }

        if (ai != null) {
            return getPackageInfo(ai, compatInfo, flags);
        }

        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.155 -0500", hash_original_method = "45FB4CD004B111E95D4C640E8F52184B", hash_generated_method = "ECA76357F40087124334EA76821AB59E")
    public final LoadedApk getPackageInfo(ApplicationInfo ai, CompatibilityInfo compatInfo,
            int flags) {
        boolean includeCode = (flags&Context.CONTEXT_INCLUDE_CODE) != 0;
        boolean securityViolation = includeCode && ai.uid != 0
                && ai.uid != Process.SYSTEM_UID && (mBoundApplication != null
                        ? ai.uid != mBoundApplication.appInfo.uid : true);
        if ((flags&(Context.CONTEXT_INCLUDE_CODE
                |Context.CONTEXT_IGNORE_SECURITY))
                == Context.CONTEXT_INCLUDE_CODE) {
            if (securityViolation) {
                String msg = "Requesting code from " + ai.packageName
                        + " (with uid " + ai.uid + ")";
                if (mBoundApplication != null) {
                    msg = msg + " to be run in process "
                        + mBoundApplication.processName + " (with uid "
                        + mBoundApplication.appInfo.uid + ")";
                }
                throw new SecurityException(msg);
            }
        }
        return getPackageInfo(ai, compatInfo, null, securityViolation, includeCode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.156 -0500", hash_original_method = "60B71579104EFF006D8A717508119428", hash_generated_method = "30D7A1DF7C4B62367B7FF8460196F60E")
    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo ai,
            CompatibilityInfo compatInfo) {
        return getPackageInfo(ai, compatInfo, null, false, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.157 -0500", hash_original_method = "5838753A6BAADDD41C531129622D5299", hash_generated_method = "6D44973F0B13D2DDE3A655AA0A08AD53")
    public final LoadedApk peekPackageInfo(String packageName, boolean includeCode) {
        synchronized (mPackages) {
            WeakReference<LoadedApk> ref;
            if (includeCode) {
                ref = mPackages.get(packageName);
            } else {
                ref = mResourcePackages.get(packageName);
            }
            return ref != null ? ref.get() : null;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.158 -0500", hash_original_method = "F2A25E301DE436DC300B56B48A365596", hash_generated_method = "0CA3A1A9325EF2FF2CA78987D528E725")
    private LoadedApk getPackageInfo(ApplicationInfo aInfo, CompatibilityInfo compatInfo,
            ClassLoader baseLoader, boolean securityViolation, boolean includeCode) {
        synchronized (mPackages) {
            WeakReference<LoadedApk> ref;
            if (includeCode) {
                ref = mPackages.get(aInfo.packageName);
            } else {
                ref = mResourcePackages.get(aInfo.packageName);
            }
            LoadedApk packageInfo = ref != null ? ref.get() : null;
            if (packageInfo == null || (packageInfo.mResources != null
                    && !packageInfo.mResources.getAssets().isUpToDate())) {
                if (localLOGV) Slog.v(TAG, (includeCode ? "Loading code package "
                        : "Loading resource-only package ") + aInfo.packageName
                        + " (in " + (mBoundApplication != null
                                ? mBoundApplication.processName : null)
                        + ")");
                packageInfo =
                    new LoadedApk(this, aInfo, compatInfo, this, baseLoader,
                            securityViolation, includeCode &&
                            (aInfo.flags&ApplicationInfo.FLAG_HAS_CODE) != 0);
                if (includeCode) {
                    mPackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                } else {
                    mResourcePackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                }
            }
            return packageInfo;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.160 -0500", hash_original_method = "F0BED1934E92681B3C0E496CA2259BFD", hash_generated_method = "7E448B8B0F4C763F0F9B021D81A2B130")
    public ApplicationThread getApplicationThread()
    {
        return mAppThread;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.161 -0500", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "952CE09D28EE4A9669353A5E94B20293")
    public Instrumentation getInstrumentation()
    {
        return mInstrumentation;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.161 -0500", hash_original_method = "9032A5E826B7A6BB9A1848729A4BF06F", hash_generated_method = "F140C49CFA0AF22F2A2A6EE06C5B72E6")
    public Configuration getConfiguration() {
        return mResConfiguration;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.162 -0500", hash_original_method = "BB8D8D9198132B7570723812CBBB4B98", hash_generated_method = "9F84848E50566940ABA86601B9B7DC16")
    public boolean isProfiling() {
        return mProfiler != null && mProfiler.profileFile != null
                && mProfiler.profileFd == null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.163 -0500", hash_original_method = "DE9E88BCF6C439479F5E5429ED790EB6", hash_generated_method = "91FB917F8BA3E683666A4D6986120126")
    public String getProfileFilePath() {
        return mProfiler.profileFile;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.164 -0500", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "605540C7F38AD7A382EEE637D044DB4C")
    public Looper getLooper() {
        return mLooper;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.164 -0500", hash_original_method = "BED0801CDE1100B1F268B3031343DFA4", hash_generated_method = "5F3DC62E06F33D30E859631477CCF329")
    public Application getApplication() {
        return mInitialApplication;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.165 -0500", hash_original_method = "5878D065A1BC5C9B3897192B88F09BB5", hash_generated_method = "7E14195C0CDC5DF88FFB8B9574E90301")
    public String getProcessName() {
        return mBoundApplication.processName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.166 -0500", hash_original_method = "67B7F6B98B8791421AA33911A41FCF20", hash_generated_method = "C264991D975B33EB14409F26AF27D130")
    public ContextImpl getSystemContext() {
        synchronized (this) {
            if (mSystemContext == null) {
                ContextImpl context =
                    ContextImpl.createSystemContext(this);
                LoadedApk info = new LoadedApk(this, "android", context, null,
                        CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO);
                context.init(info, null, this);
                context.getResources().updateConfiguration(
                        getConfiguration(), getDisplayMetricsLocked(
                                CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
                mSystemContext = context;
                //Slog.i(TAG, "Created system resources " + context.getResources()
                //        + ": " + context.getResources().getConfiguration());
            }
        }
        return mSystemContext;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.167 -0500", hash_original_method = "AC12C154682E9BD06E6B4A91255348E3", hash_generated_method = "4BB3910E0B4DF8764F319B6112D71C37")
    public void installSystemApplicationInfo(ApplicationInfo info) {
        synchronized (this) {
            ContextImpl context = getSystemContext();
            context.init(new LoadedApk(this, "android", context, info,
                    CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);

            // give ourselves a default profiler
            mProfiler = new Profiler();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.168 -0500", hash_original_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15", hash_generated_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15")
    void ensureJitEnabled() {
        if (!mJitEnabled) {
            mJitEnabled = true;
            dalvik.system.VMRuntime.getRuntime().startJitCompilation();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.169 -0500", hash_original_method = "9194C167DA959B824F2056B7870F9862", hash_generated_method = "9194C167DA959B824F2056B7870F9862")
    void scheduleGcIdler() {
        if (!mGcIdlerScheduled) {
            mGcIdlerScheduled = true;
            Looper.myQueue().addIdleHandler(mGcIdler);
        }
        mH.removeMessages(H.GC_WHEN_IDLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.169 -0500", hash_original_method = "418A9C1DFD1D7F21CC468D764B344F26", hash_generated_method = "418A9C1DFD1D7F21CC468D764B344F26")
    void unscheduleGcIdler() {
        if (mGcIdlerScheduled) {
            mGcIdlerScheduled = false;
            Looper.myQueue().removeIdleHandler(mGcIdler);
        }
        mH.removeMessages(H.GC_WHEN_IDLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.170 -0500", hash_original_method = "7E176906E0A5888F6535695D6EB5B115", hash_generated_method = "F41BDFF639E51828B746870F304950E9")
    void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        final long now = SystemClock.uptimeMillis();
        //Slog.i(TAG, "**** WE MIGHT WANT TO GC: then=" + Binder.getLastGcTime()
        //        + "m now=" + now);
        if ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now) {
            //Slog.i(TAG, "**** WE DO, WE DO WANT TO GC!");
            BinderInternal.forceGc("bg");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.171 -0500", hash_original_method = "BC7C90866968540D7B885FF1F76E8E09", hash_generated_method = "A8C66234CFA566C6051E4B27E80A2CFA")
    public void registerOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        synchronized (mOnPauseListeners) {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            if (list == null) {
                list = new ArrayList<OnActivityPausedListener>();
                mOnPauseListeners.put(activity, list);
            }
            list.add(listener);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.172 -0500", hash_original_method = "A666FB211AE0A9537AAE3A42A197A4A4", hash_generated_method = "636CDADC9F5A497EB376DDC5C9025030")
    public void unregisterOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        synchronized (mOnPauseListeners) {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            if (list != null) {
                list.remove(listener);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.173 -0500", hash_original_method = "FA6ACBD6D6B2F04759E1E44999782C17", hash_generated_method = "D5ADFCFE4A9F59D0BB5ACCE7E60E7ACF")
    public final ActivityInfo resolveActivityInfo(Intent intent) {
        ActivityInfo aInfo = intent.resolveActivityInfo(
                mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        if (aInfo == null) {
            // Throw an exception.
            Instrumentation.checkStartActivityResult(
                    IActivityManager.START_CLASS_NOT_FOUND, intent);
        }
        return aInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.174 -0500", hash_original_method = "52193E396925A8581791167FBC0A1FC9", hash_generated_method = "149CAF524945EBECEBB2024E7E9C0660")
    public final Activity startActivityNow(Activity parent, String id,
        Intent intent, ActivityInfo activityInfo, IBinder token, Bundle state,
        Activity.NonConfigurationInstances lastNonConfigurationInstances) {
        ActivityClientRecord r = new ActivityClientRecord();
            r.token = token;
            r.ident = 0;
            r.intent = intent;
            r.state = state;
            r.parent = parent;
            r.embeddedID = id;
            r.activityInfo = activityInfo;
            r.lastNonConfigurationInstances = lastNonConfigurationInstances;
        if (localLOGV) {
            ComponentName compname = intent.getComponent();
            String name;
            if (compname != null) {
                name = compname.toShortString();
            } else {
                name = "(Intent " + intent + ").getComponent() returned null";
            }
            Slog.v(TAG, "Performing launch: action=" + intent.getAction()
                    + ", comp=" + name
                    + ", token=" + token);
        }
        return performLaunchActivity(r, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.175 -0500", hash_original_method = "E4DB0C38EE0152F49C4586AFA6AD83D1", hash_generated_method = "0C96B85C3E3E03C5743EA5E30F7BC63C")
    public final Activity getActivity(IBinder token) {
        return mActivities.get(token).activity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.176 -0500", hash_original_method = "46F0209236B49884D3899FCB9A0A8CD2", hash_generated_method = "F5C5B97C950C42D4B69E721FC751A8BA")
    public final void sendActivityResult(
            IBinder token, String id, int requestCode,
            int resultCode, Intent data) {
        if (DEBUG_RESULTS) Slog.v(TAG, "sendActivityResult: id=" + id
                + " req=" + requestCode + " res=" + resultCode + " data=" + data);
        ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        list.add(new ResultInfo(id, requestCode, resultCode, data));
        mAppThread.scheduleSendResult(token, list);
    }

    // if the thread hasn't started yet, we don't have the handler, so just
    // save the messages until we're ready.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.177 -0500", hash_original_method = "04C4A68B1E80544C50165B2C1F09966C", hash_generated_method = "EB5F52D9E87531565EE15B5ECA9EF039")
    private void queueOrSendMessage(int what, Object obj) {
        queueOrSendMessage(what, obj, 0, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.177 -0500", hash_original_method = "3163B4D830BC02309EB9FA4093F38166", hash_generated_method = "81E3B88D2709FED1D02A23341D65D54A")
    private void queueOrSendMessage(int what, Object obj, int arg1) {
        queueOrSendMessage(what, obj, arg1, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.178 -0500", hash_original_method = "BA532BAA145C03E1DD34B30EBC725387", hash_generated_method = "931177D7F69748233AA749FF9DE3717C")
    private void queueOrSendMessage(int what, Object obj, int arg1, int arg2) {
        synchronized (this) {
            if (DEBUG_MESSAGES) Slog.v(
                TAG, "SCHEDULE " + what + " " + mH.codeToString(what)
                + ": " + arg1 + " / " + obj);
            Message msg = Message.obtain();
            msg.what = what;
            msg.obj = obj;
            msg.arg1 = arg1;
            msg.arg2 = arg2;
            mH.sendMessage(msg);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.179 -0500", hash_original_method = "15BD644AA17343360FD7D474ECDA0BC6", hash_generated_method = "189AA863AF7D2328D457219A7FCED4B5")
    final void scheduleContextCleanup(ContextImpl context, String who,
            String what) {
        ContextCleanupInfo cci = new ContextCleanupInfo();
        cci.context = context;
        cci.who = who;
        cci.what = what;
        queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.181 -0500", hash_original_method = "C9C4D84CF5E4E5BEF4E002420AA42B4A", hash_generated_method = "57F6E7A381EE8A143950CA0CADF39261")
    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        // System.out.println("##### [" + System.currentTimeMillis() + "] ActivityThread.performLaunchActivity(" + r + ")");

        ActivityInfo aInfo = r.activityInfo;
        if (r.packageInfo == null) {
            r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
                    Context.CONTEXT_INCLUDE_CODE);
        }

        ComponentName component = r.intent.getComponent();
        if (component == null) {
            component = r.intent.resolveActivity(
                mInitialApplication.getPackageManager());
            r.intent.setComponent(component);
        }

        if (r.activityInfo.targetActivity != null) {
            component = new ComponentName(r.activityInfo.packageName,
                    r.activityInfo.targetActivity);
        }

        Activity activity = null;
        try {
            java.lang.ClassLoader cl = r.packageInfo.getClassLoader();
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);
            StrictMode.incrementExpectedActivityCount(activity.getClass());
            r.intent.setExtrasClassLoader(cl);
            if (r.state != null) {
                r.state.setClassLoader(cl);
            }
        } catch (Exception e) {
            if (!mInstrumentation.onException(activity, e)) {
                throw new RuntimeException(
                    "Unable to instantiate activity " + component
                    + ": " + e.toString(), e);
            }
        }

        try {
            Application app = r.packageInfo.makeApplication(false, mInstrumentation);

            if (localLOGV) Slog.v(TAG, "Performing launch of " + r);
            if (localLOGV) Slog.v(
                    TAG, r + ": app=" + app
                    + ", appName=" + app.getPackageName()
                    + ", pkg=" + r.packageInfo.getPackageName()
                    + ", comp=" + r.intent.getComponent().toShortString()
                    + ", dir=" + r.packageInfo.getAppDir());

            if (activity != null) {
                ContextImpl appContext = new ContextImpl();
                appContext.init(r.packageInfo, r.token, this);
                appContext.setOuterContext(activity);
                CharSequence title = r.activityInfo.loadLabel(appContext.getPackageManager());
                Configuration config = new Configuration(mCompatConfiguration);
                if (DEBUG_CONFIGURATION) Slog.v(TAG, "Launching activity "
                        + r.activityInfo.name + " with config " + config);
                activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config);

                if (customIntent != null) {
                    activity.mIntent = customIntent;
                }
                r.lastNonConfigurationInstances = null;
                activity.mStartedActivity = false;
                int theme = r.activityInfo.getThemeResource();
                if (theme != 0) {
                    activity.setTheme(theme);
                }

                activity.mCalled = false;
                mInstrumentation.callActivityOnCreate(activity, r.state);
                if (!activity.mCalled) {
                    throw new SuperNotCalledException(
                        "Activity " + r.intent.getComponent().toShortString() +
                        " did not call through to super.onCreate()");
                }
                r.activity = activity;
                r.stopped = true;
                if (!r.activity.mFinished) {
                    activity.performStart();
                    r.stopped = false;
                }
                if (!r.activity.mFinished) {
                    if (r.state != null) {
                        mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state);
                    }
                }
                if (!r.activity.mFinished) {
                    activity.mCalled = false;
                    mInstrumentation.callActivityOnPostCreate(activity, r.state);
                    if (!activity.mCalled) {
                        throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPostCreate()");
                    }
                }
            }
            r.paused = true;

            mActivities.put(r.token, r);

        } catch (SuperNotCalledException e) {
            throw e;

        } catch (Exception e) {
            if (!mInstrumentation.onException(activity, e)) {
                throw new RuntimeException(
                    "Unable to start activity " + component
                    + ": " + e.toString(), e);
            }
        }

        return activity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.182 -0500", hash_original_method = "483F7FDC9359FE0D21A4FBFB307EF0CA", hash_generated_method = "ED192C30B47E68A4694361C7A8CA37B8")
    private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        // If we are getting ready to gc after going to the background, well
        // we are back active so skip it.
        unscheduleGcIdler();

        if (r.profileFd != null) {
            mProfiler.setProfiler(r.profileFile, r.profileFd);
            mProfiler.startProfiling();
            mProfiler.autoStopProfiler = r.autoStopProfiler;
        }

        // Make sure we are running with the most recent config.
        handleConfigurationChanged(null, null);

        if (localLOGV) Slog.v(
            TAG, "Handling launch of " + r);
        Activity a = performLaunchActivity(r, customIntent);

        if (a != null) {
            r.createdConfig = new Configuration(mConfiguration);
            Bundle oldState = r.state;
            handleResumeActivity(r.token, false, r.isForward);

            if (!r.activity.mFinished && r.startsNotResumed) {
                // The activity manager actually wants this one to start out
                // paused, because it needs to be visible but isn't in the
                // foreground.  We accomplish this by going through the
                // normal startup (because activities expect to go through
                // onResume() the first time they run, before their window
                // is displayed), and then pausing it.  However, in this case
                // we do -not- need to do the full pause cycle (of freezing
                // and such) because the activity manager assumes it can just
                // retain the current state it has.
                try {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    // We need to keep around the original state, in case
                    // we need to be created again.
                    r.state = oldState;
                    if (!r.activity.mCalled) {
                        throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPause()");
                    }

                } catch (SuperNotCalledException e) {
                    throw e;

                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
                r.paused = true;
            }
        } else {
            // If there was an error, for any reason, tell the activity
            // manager to stop us.
            try {
                ActivityManagerNative.getDefault()
                    .finishActivity(r.token, Activity.RESULT_CANCELED, null);
            } catch (RemoteException ex) {
                // Ignore
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.183 -0500", hash_original_method = "089DA2DACAED1790C29E22F2D6A7A046", hash_generated_method = "95E7D27425DA3767E341C73BD6E5DEC6")
    private void deliverNewIntents(ActivityClientRecord r,
            List<Intent> intents) {
        final int N = intents.size();
        for (int i=0; i<N; i++) {
            Intent intent = intents.get(i);
            intent.setExtrasClassLoader(r.activity.getClassLoader());
            r.activity.mFragments.noteStateNotSaved();
            mInstrumentation.callActivityOnNewIntent(r.activity, intent);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.184 -0500", hash_original_method = "62C39F1A7060D00626ABC1EA40393902", hash_generated_method = "D8EC5DBEC12EFEBE641A1CC843AC6E3B")
    public final void performNewIntents(IBinder token,
            List<Intent> intents) {
        ActivityClientRecord r = mActivities.get(token);
        if (r != null) {
            final boolean resumed = !r.paused;
            if (resumed) {
                r.activity.mTemporaryPause = true;
                mInstrumentation.callActivityOnPause(r.activity);
            }
            deliverNewIntents(r, intents);
            if (resumed) {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.184 -0500", hash_original_method = "3340D70EC7FD056C28E3BD0AF1C7CC94", hash_generated_method = "1F59E75CAB867B58FCF357CC8C5BBD31")
    private void handleNewIntent(NewIntentData data) {
        performNewIntents(data.token, data.intents);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.188 -0500", hash_original_method = "3D8204A3B4D4C5B7C8FEA568D86F5418", hash_generated_method = "B5D5C287ADB3A0F3F751737E0F217DD9")
    private void handleReceiver(ReceiverData data) {
        // If we are getting ready to gc after going to the background, well
        // we are back active so skip it.
        unscheduleGcIdler();

        String component = data.intent.getComponent().getClassName();

        LoadedApk packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);

        IActivityManager mgr = ActivityManagerNative.getDefault();

        BroadcastReceiver receiver;
        try {
            java.lang.ClassLoader cl = packageInfo.getClassLoader();
            data.intent.setExtrasClassLoader(cl);
            data.setExtrasClassLoader(cl);
            receiver = (BroadcastReceiver)cl.loadClass(component).newInstance();
        } catch (Exception e) {
            if (DEBUG_BROADCAST) Slog.i(TAG,
                    "Finishing failed broadcast to " + data.intent.getComponent());
            data.sendFinished(mgr);
            throw new RuntimeException(
                "Unable to instantiate receiver " + component
                + ": " + e.toString(), e);
        }

        try {
            Application app = packageInfo.makeApplication(false, mInstrumentation);

            if (localLOGV) Slog.v(
                TAG, "Performing receive of " + data.intent
                + ": app=" + app
                + ", appName=" + app.getPackageName()
                + ", pkg=" + packageInfo.getPackageName()
                + ", comp=" + data.intent.getComponent().toShortString()
                + ", dir=" + packageInfo.getAppDir());

            ContextImpl context = (ContextImpl)app.getBaseContext();
            sCurrentBroadcastIntent.set(data.intent);
            receiver.setPendingResult(data);
            receiver.onReceive(context.getReceiverRestrictedContext(),
                    data.intent);
        } catch (Exception e) {
            if (DEBUG_BROADCAST) Slog.i(TAG,
                    "Finishing failed broadcast to " + data.intent.getComponent());
            data.sendFinished(mgr);
            if (!mInstrumentation.onException(receiver, e)) {
                throw new RuntimeException(
                    "Unable to start receiver " + component
                    + ": " + e.toString(), e);
            }
        } finally {
            sCurrentBroadcastIntent.set(null);
        }

        if (receiver.getPendingResult() != null) {
            data.finish();
        }
    }

    // Instantiate a BackupAgent and tell it that it's alive
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.189 -0500", hash_original_method = "F9FD1947DE4D383F90C08BC5B81CEB33", hash_generated_method = "0EF6CDA647E9FC7B904398BCE28A9469")
    private void handleCreateBackupAgent(CreateBackupAgentData data) {
        if (DEBUG_BACKUP) Slog.v(TAG, "handleCreateBackupAgent: " + data);

        // no longer idle; we have backup work to do
        unscheduleGcIdler();

        // instantiate the BackupAgent class named in the manifest
        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
        if (mBackupAgents.get(packageName) != null) {
            Slog.d(TAG, "BackupAgent " + "  for " + packageName
                    + " already exists");
            return;
        }

        BackupAgent agent = null;
        String classname = data.appInfo.backupAgentName;

        // full backup operation but no app-supplied agent?  use the default implementation
        if (classname == null && (data.backupMode == IApplicationThread.BACKUP_MODE_FULL
                || data.backupMode == IApplicationThread.BACKUP_MODE_RESTORE_FULL)) {
            classname = "android.app.backup.FullBackupAgent";
        }

        try {
            IBinder binder = null;
            try {
                if (DEBUG_BACKUP) Slog.v(TAG, "Initializing agent class " + classname);

                java.lang.ClassLoader cl = packageInfo.getClassLoader();
                agent = (BackupAgent) cl.loadClass(classname).newInstance();

                // set up the agent's context
                ContextImpl context = new ContextImpl();
                context.init(packageInfo, null, this);
                context.setOuterContext(agent);
                agent.attach(context);

                agent.onCreate();
                binder = agent.onBind();
                mBackupAgents.put(packageName, agent);
            } catch (Exception e) {
                // If this is during restore, fail silently; otherwise go
                // ahead and let the user see the crash.
                Slog.e(TAG, "Agent threw during creation: " + e);
                if (data.backupMode != IApplicationThread.BACKUP_MODE_RESTORE
                        && data.backupMode != IApplicationThread.BACKUP_MODE_RESTORE_FULL) {
                    throw e;
                }
                // falling through with 'binder' still null
            }

            // tell the OS that we're live now
            try {
                ActivityManagerNative.getDefault().backupAgentCreated(packageName, binder);
            } catch (RemoteException e) {
                // nothing to do.
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to create BackupAgent "
                    + classname + ": " + e.toString(), e);
        }
    }

    // Tear down a BackupAgent
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.190 -0500", hash_original_method = "F45834CE0FCB2021DEF63803688239C3", hash_generated_method = "6DB8126EB5FDFDC5E8E859E32F27B16D")
    private void handleDestroyBackupAgent(CreateBackupAgentData data) {
        if (DEBUG_BACKUP) Slog.v(TAG, "handleDestroyBackupAgent: " + data);

        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
        BackupAgent agent = mBackupAgents.get(packageName);
        if (agent != null) {
            try {
                agent.onDestroy();
            } catch (Exception e) {
                Slog.w(TAG, "Exception thrown in onDestroy by backup agent of " + data.appInfo);
                e.printStackTrace();
            }
            mBackupAgents.remove(packageName);
        } else {
            Slog.w(TAG, "Attempt to destroy unknown backup agent " + data);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.191 -0500", hash_original_method = "77CEB6B4E506F7F39264B1FEFD4EC387", hash_generated_method = "2A47316BF005A7E945646FF33E60CD4C")
    private void handleCreateService(CreateServiceData data) {
        // If we are getting ready to gc after going to the background, well
        // we are back active so skip it.
        unscheduleGcIdler();

        LoadedApk packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        Service service = null;
        try {
            java.lang.ClassLoader cl = packageInfo.getClassLoader();
            service = (Service) cl.loadClass(data.info.name).newInstance();
        } catch (Exception e) {
            if (!mInstrumentation.onException(service, e)) {
                throw new RuntimeException(
                    "Unable to instantiate service " + data.info.name
                    + ": " + e.toString(), e);
            }
        }

        try {
            if (localLOGV) Slog.v(TAG, "Creating service " + data.info.name);

            ContextImpl context = new ContextImpl();
            context.init(packageInfo, null, this);

            Application app = packageInfo.makeApplication(false, mInstrumentation);
            context.setOuterContext(service);
            service.attach(context, this, data.info.name, data.token, app,
                    ActivityManagerNative.getDefault());
            service.onCreate();
            mServices.put(data.token, service);
            try {
                ActivityManagerNative.getDefault().serviceDoneExecuting(
                        data.token, 0, 0, 0);
            } catch (RemoteException e) {
                // nothing to do.
            }
        } catch (Exception e) {
            if (!mInstrumentation.onException(service, e)) {
                throw new RuntimeException(
                    "Unable to create service " + data.info.name
                    + ": " + e.toString(), e);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.192 -0500", hash_original_method = "881D5FBA45CBA067F129D10745838607", hash_generated_method = "C9AF19A7DFB10F992E4B1A6E0209C670")
    private void handleBindService(BindServiceData data) {
        Service s = mServices.get(data.token);
        if (s != null) {
            try {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                try {
                    if (!data.rebind) {
                        IBinder binder = s.onBind(data.intent);
                        ActivityManagerNative.getDefault().publishService(
                                data.token, data.intent, binder);
                    } else {
                        s.onRebind(data.intent);
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    }
                    ensureJitEnabled();
                } catch (RemoteException ex) {
                }
            } catch (Exception e) {
                if (!mInstrumentation.onException(s, e)) {
                    throw new RuntimeException(
                            "Unable to bind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.193 -0500", hash_original_method = "2796BE6EE721B85B28BB6DBD3B4C5C51", hash_generated_method = "196AC88BDA2161CAC4782A46B7681239")
    private void handleUnbindService(BindServiceData data) {
        Service s = mServices.get(data.token);
        if (s != null) {
            try {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                boolean doRebind = s.onUnbind(data.intent);
                try {
                    if (doRebind) {
                        ActivityManagerNative.getDefault().unbindFinished(
                                data.token, data.intent, doRebind);
                    } else {
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    }
                } catch (RemoteException ex) {
                }
            } catch (Exception e) {
                if (!mInstrumentation.onException(s, e)) {
                    throw new RuntimeException(
                            "Unable to unbind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.194 -0500", hash_original_method = "1C18D37F75673CCCBD9C372D3BFFD82C", hash_generated_method = "46913061E1CBC4661E7638D894535FD3")
    private void handleDumpService(DumpComponentInfo info) {
        Service s = mServices.get(info.token);
        if (s != null) {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            s.dump(info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try {
                info.fd.close();
            } catch (IOException e) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.195 -0500", hash_original_method = "126292FF06E700D8C53E21C56EE062B7", hash_generated_method = "E1D2BD0BF51B9A82C3D44BED111F3AF1")
    private void handleDumpActivity(DumpComponentInfo info) {
        ActivityClientRecord r = mActivities.get(info.token);
        if (r != null && r.activity != null) {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            r.activity.dump(info.prefix, info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try {
                info.fd.close();
            } catch (IOException e) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.195 -0500", hash_original_method = "7729FDAE3B00ADA3C236E33577FF6666", hash_generated_method = "85D3E3DE1388346AE2E4115482BDAC73")
    private void handleServiceArgs(ServiceArgsData data) {
        Service s = mServices.get(data.token);
        if (s != null) {
            try {
                if (data.args != null) {
                    data.args.setExtrasClassLoader(s.getClassLoader());
                }
                int res;
                if (!data.taskRemoved) {
                    res = s.onStartCommand(data.args, data.flags, data.startId);
                } else {
                    s.onTaskRemoved(data.args);
                    res = Service.START_TASK_REMOVED_COMPLETE;
                }

                QueuedWork.waitToFinish();

                try {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            data.token, 1, data.startId, res);
                } catch (RemoteException e) {
                    // nothing to do.
                }
                ensureJitEnabled();
            } catch (Exception e) {
                if (!mInstrumentation.onException(s, e)) {
                    throw new RuntimeException(
                            "Unable to start service " + s
                            + " with " + data.args + ": " + e.toString(), e);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.196 -0500", hash_original_method = "E9A561F96B3BEE10BDD2A8F223813D32", hash_generated_method = "6EEBB62D845575B75713DDFECB97D220")
    private void handleStopService(IBinder token) {
        Service s = mServices.remove(token);
        if (s != null) {
            try {
                if (localLOGV) Slog.v(TAG, "Destroying service " + s);
                s.onDestroy();
                Context context = s.getBaseContext();
                if (context instanceof ContextImpl) {
                    final String who = s.getClassName();
                    ((ContextImpl) context).scheduleFinalCleanup(who, "Service");
                }

                QueuedWork.waitToFinish();

                try {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            token, 0, 0, 0);
                } catch (RemoteException e) {
                    // nothing to do.
                }
            } catch (Exception e) {
                if (!mInstrumentation.onException(s, e)) {
                    throw new RuntimeException(
                            "Unable to stop service " + s
                            + ": " + e.toString(), e);
                }
            }
        }
        //Slog.i(TAG, "Running services: " + mServices);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.198 -0500", hash_original_method = "821CC6EDFD77BBF57472742A46BD9804", hash_generated_method = "EC533F01BF939A25A2CD1B215958475F")
    public final ActivityClientRecord performResumeActivity(IBinder token,
            boolean clearHide) {
        ActivityClientRecord r = mActivities.get(token);
        if (localLOGV) Slog.v(TAG, "Performing resume of " + r
                + " finished=" + r.activity.mFinished);
        if (r != null && !r.activity.mFinished) {
            if (clearHide) {
                r.hideForNow = false;
                r.activity.mStartedActivity = false;
            }
            try {
                if (r.pendingIntents != null) {
                    deliverNewIntents(r, r.pendingIntents);
                    r.pendingIntents = null;
                }
                if (r.pendingResults != null) {
                    deliverResults(r, r.pendingResults);
                    r.pendingResults = null;
                }
                r.activity.performResume();

                EventLog.writeEvent(LOG_ON_RESUME_CALLED,
                        r.activity.getComponentName().getClassName());

                r.paused = false;
                r.stopped = false;
                r.state = null;
            } catch (Exception e) {
                if (!mInstrumentation.onException(r.activity, e)) {
                    throw new RuntimeException(
                        "Unable to resume activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                }
            }
        }
        return r;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.198 -0500", hash_original_method = "3389EE310594E6487CC378BBAF5D49AF", hash_generated_method = "6CEC74FC19562A6A6BCB4D3C9B4AFD61")
    final void cleanUpPendingRemoveWindows(ActivityClientRecord r) {
        if (r.mPendingRemoveWindow != null) {
            r.mPendingRemoveWindowManager.removeViewImmediate(r.mPendingRemoveWindow);
            IBinder wtoken = r.mPendingRemoveWindow.getWindowToken();
            if (wtoken != null) {
                WindowManagerImpl.getDefault().closeAll(wtoken,
                        r.activity.getClass().getName(), "Activity");
            }
        }
        r.mPendingRemoveWindow = null;
        r.mPendingRemoveWindowManager = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.201 -0500", hash_original_method = "E7E626438598608F65C9E3AAFD52E1D3", hash_generated_method = "9E76CA0018A6DEA6510CCDFA45962ABF")
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
        // If we are getting ready to gc after going to the background, well
        // we are back active so skip it.
        unscheduleGcIdler();

        ActivityClientRecord r = performResumeActivity(token, clearHide);

        if (r != null) {
            final Activity a = r.activity;

            if (localLOGV) Slog.v(
                TAG, "Resume " + r + " started activity: " +
                a.mStartedActivity + ", hideForNow: " + r.hideForNow
                + ", finished: " + a.mFinished);

            final int forwardBit = isForward ?
                    WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION : 0;

            // If the window hasn't yet been added to the window manager,
            // and this guy didn't finish itself or start another activity,
            // then go ahead and add the window.
            boolean willBeVisible = !a.mStartedActivity;
            if (!willBeVisible) {
                try {
                    willBeVisible = ActivityManagerNative.getDefault().willActivityBeVisible(
                            a.getActivityToken());
                } catch (RemoteException e) {
                }
            }
            if (r.window == null && !a.mFinished && willBeVisible) {
                r.window = r.activity.getWindow();
                View decor = r.window.getDecorView();
                decor.setVisibility(View.INVISIBLE);
                ViewManager wm = a.getWindowManager();
                WindowManager.LayoutParams l = r.window.getAttributes();
                a.mDecor = decor;
                l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
                l.softInputMode |= forwardBit;
                if (a.mVisibleFromClient) {
                    a.mWindowAdded = true;
                    wm.addView(decor, l);
                }

            // If the window has already been added, but during resume
            // we started another activity, then don't yet make the
            // window visible.
            } else if (!willBeVisible) {
                if (localLOGV) Slog.v(
                    TAG, "Launch " + r + " mStartedActivity set");
                r.hideForNow = true;
            }

            // Get rid of anything left hanging around.
            cleanUpPendingRemoveWindows(r);

            // The window is now visible if it has been added, we are not
            // simply finishing, and we are not starting another activity.
            if (!r.activity.mFinished && willBeVisible
                    && r.activity.mDecor != null && !r.hideForNow) {
                if (r.newConfig != null) {
                    if (DEBUG_CONFIGURATION) Slog.v(TAG, "Resuming activity "
                            + r.activityInfo.name + " with newConfig " + r.newConfig);
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                }
                if (localLOGV) Slog.v(TAG, "Resuming " + r + " with isForward="
                        + isForward);
                WindowManager.LayoutParams l = r.window.getAttributes();
                if ((l.softInputMode
                        & WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION)
                        != forwardBit) {
                    l.softInputMode = (l.softInputMode
                            & (~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION))
                            | forwardBit;
                    if (r.activity.mVisibleFromClient) {
                        ViewManager wm = a.getWindowManager();
                        View decor = r.window.getDecorView();
                        wm.updateViewLayout(decor, l);
                    }
                }
                r.activity.mVisibleFromServer = true;
                mNumVisibleActivities++;
                if (r.activity.mVisibleFromClient) {
                    r.activity.makeVisible();
                }
            }

            if (!r.onlyLocalRequest) {
                r.nextIdle = mNewActivities;
                mNewActivities = r;
                if (localLOGV) Slog.v(
                    TAG, "Scheduling idle handler for " + r);
                Looper.myQueue().addIdleHandler(new Idler());
            }
            r.onlyLocalRequest = false;

        } else {
            // If an exception was thrown when trying to resume, then
            // just end this activity.
            try {
                ActivityManagerNative.getDefault()
                    .finishActivity(token, Activity.RESULT_CANCELED, null);
            } catch (RemoteException ex) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.205 -0500", hash_original_method = "DA54714D7ABECA1149DF2EBB4CB12B75", hash_generated_method = "F02EC5EFFD23A63C03103C7CE3F4ADC3")
    private Bitmap createThumbnailBitmap(ActivityClientRecord r) {
        Bitmap thumbnail = mAvailThumbnailBitmap;
        try {
            if (thumbnail == null) {
                int w = mThumbnailWidth;
                int h;
                if (w < 0) {
                    Resources res = r.activity.getResources();
                    mThumbnailHeight = h =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_height);

                    mThumbnailWidth = w =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_width);
                } else {
                    h = mThumbnailHeight;
                }

                // On platforms where we don't want thumbnails, set dims to (0,0)
                if ((w > 0) && (h > 0)) {
                    thumbnail = Bitmap.createBitmap(w, h, THUMBNAIL_FORMAT);
                    thumbnail.eraseColor(0);
                }
            }

            if (thumbnail != null) {
                Canvas cv = mThumbnailCanvas;
                if (cv == null) {
                    mThumbnailCanvas = cv = new Canvas();
                }
    
                cv.setBitmap(thumbnail);
                if (!r.activity.onCreateThumbnail(thumbnail, cv)) {
                    mAvailThumbnailBitmap = thumbnail;
                    thumbnail = null;
                }
                cv.setBitmap(null);
            }

        } catch (Exception e) {
            if (!mInstrumentation.onException(r.activity, e)) {
                throw new RuntimeException(
                        "Unable to create thumbnail of "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
            }
            thumbnail = null;
        }

        return thumbnail;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.206 -0500", hash_original_method = "E5BE16D2C462200A7B0F213AB5290C46", hash_generated_method = "26C3FCE20AA32242693E9EA8591A2968")
    private void handlePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) {
        ActivityClientRecord r = mActivities.get(token);
        if (r != null) {
            //Slog.v(TAG, "userLeaving=" + userLeaving + " handling pause of " + r);
            if (userLeaving) {
                performUserLeavingActivity(r);
            }

            r.activity.mConfigChangeFlags |= configChanges;
            performPauseActivity(token, finished, r.isPreHoneycomb());

            // Make sure any pending writes are now committed.
            if (r.isPreHoneycomb()) {
                QueuedWork.waitToFinish();
            }
            
            // Tell the activity manager we have paused.
            try {
                ActivityManagerNative.getDefault().activityPaused(token);
            } catch (RemoteException ex) {
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.206 -0500", hash_original_method = "E51B505D442E84A2F592A34137ABD72B", hash_generated_method = "ADB261E9552C70636B23A86BC5B5A315")
    final void performUserLeavingActivity(ActivityClientRecord r) {
        mInstrumentation.callActivityOnUserLeaving(r.activity);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.207 -0500", hash_original_method = "2E97B5DEF88E402FCA1661B4F9DB23CB", hash_generated_method = "43BCE858F06F0590F802266ABE3E5A34")
    final Bundle performPauseActivity(IBinder token, boolean finished,
            boolean saveState) {
        ActivityClientRecord r = mActivities.get(token);
        return r != null ? performPauseActivity(r, finished, saveState) : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.208 -0500", hash_original_method = "48F314FABF09550D34AFCF3A61EA40AB", hash_generated_method = "11C4814AE88E028BAF8F9FAA5EA31753")
    final Bundle performPauseActivity(ActivityClientRecord r, boolean finished,
            boolean saveState) {
        if (r.paused) {
            if (r.activity.mFinished) {
                // If we are finishing, we won't call onResume() in certain cases.
                // So here we likewise don't want to call onPause() if the activity
                // isn't resumed.
                return null;
            }
            RuntimeException e = new RuntimeException(
                    "Performing pause of activity that is not resumed: "
                    + r.intent.getComponent().toShortString());
            Slog.e(TAG, e.getMessage(), e);
        }
        Bundle state = null;
        if (finished) {
            r.activity.mFinished = true;
        }
        try {
            // Next have the activity save its current state and managed dialogs...
            if (!r.activity.mFinished && saveState) {
                state = new Bundle();
                state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                r.state = state;
            }
            // Now we are idle.
            r.activity.mCalled = false;
            mInstrumentation.callActivityOnPause(r.activity);
            EventLog.writeEvent(LOG_ON_PAUSE_CALLED, r.activity.getComponentName().getClassName());
            if (!r.activity.mCalled) {
                throw new SuperNotCalledException(
                    "Activity " + r.intent.getComponent().toShortString() +
                    " did not call through to super.onPause()");
            }

        } catch (SuperNotCalledException e) {
            throw e;

        } catch (Exception e) {
            if (!mInstrumentation.onException(r.activity, e)) {
                throw new RuntimeException(
                        "Unable to pause activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
            }
        }
        r.paused = true;

        // Notify any outstanding on paused listeners
        ArrayList<OnActivityPausedListener> listeners;
        synchronized (mOnPauseListeners) {
            listeners = mOnPauseListeners.remove(r.activity);
        }
        int size = (listeners != null ? listeners.size() : 0);
        for (int i = 0; i < size; i++) {
            listeners.get(i).onPaused(r.activity);
        }

        return state;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.209 -0500", hash_original_method = "16A67002319514C641569BB2AD572A0E", hash_generated_method = "6AA3A907EF4985B98B3C23BDE7D415F3")
    final void performStopActivity(IBinder token, boolean saveState) {
        ActivityClientRecord r = mActivities.get(token);
        performStopActivityInner(r, null, false, saveState);
    }

    /**
     * Core implementation of stopping an activity.  Note this is a little
     * tricky because the server's meaning of stop is slightly different
     * than our client -- for the server, stop means to save state and give
     * it the result when it is done, but the window may still be visible.
     * For the client, we want to call onStop()/onStart() to indicate when
     * the activity's UI visibillity changes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.215 -0500", hash_original_method = "9D7845EB7E019C62C91AEEFF3F12D0E4", hash_generated_method = "5663A74D6E68D3AC6BD5BC999142DCB8")
    private void performStopActivityInner(ActivityClientRecord r,
            StopInfo info, boolean keepShown, boolean saveState) {
        if (localLOGV) Slog.v(TAG, "Performing stop of " + r);
        Bundle state = null;
        if (r != null) {
            if (!keepShown && r.stopped) {
                if (r.activity.mFinished) {
                    // If we are finishing, we won't call onResume() in certain
                    // cases.  So here we likewise don't want to call onStop()
                    // if the activity isn't resumed.
                    return;
                }
                RuntimeException e = new RuntimeException(
                        "Performing stop of activity that is not resumed: "
                        + r.intent.getComponent().toShortString());
                Slog.e(TAG, e.getMessage(), e);
            }

            if (info != null) {
                try {
                    // First create a thumbnail for the activity...
                    // For now, don't create the thumbnail here; we are
                    // doing that by doing a screen snapshot.
                    info.thumbnail = null; //createThumbnailBitmap(r);
                    info.description = r.activity.onCreateDescription();
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to save state of activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
            }

            // Next have the activity save its current state and managed dialogs...
            if (!r.activity.mFinished && saveState) {
                if (r.state == null) {
                    state = new Bundle();
                    state.setAllowFds(false);
                    mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                    r.state = state;
                } else {
                    state = r.state;
                }
            }

            if (!keepShown) {
                try {
                    // Now we are idle.
                    r.activity.performStop();
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
                r.stopped = true;
            }

            r.paused = true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.216 -0500", hash_original_method = "A6B6099E264273A69E686CA5F8880A0F", hash_generated_method = "97CC6B25C41B678C18B3A323EDEAE0AC")
    private void updateVisibility(ActivityClientRecord r, boolean show) {
        View v = r.activity.mDecor;
        if (v != null) {
            if (show) {
                if (!r.activity.mVisibleFromServer) {
                    r.activity.mVisibleFromServer = true;
                    mNumVisibleActivities++;
                    if (r.activity.mVisibleFromClient) {
                        r.activity.makeVisible();
                    }
                }
                if (r.newConfig != null) {
                    if (DEBUG_CONFIGURATION) Slog.v(TAG, "Updating activity vis "
                            + r.activityInfo.name + " with new config " + r.newConfig);
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                }
            } else {
                if (r.activity.mVisibleFromServer) {
                    r.activity.mVisibleFromServer = false;
                    mNumVisibleActivities--;
                    v.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.217 -0500", hash_original_method = "5B5FF681D8D2131B5D84BD48CB5679C6", hash_generated_method = "D7DA916FCC60CF3C8ABBE3C588E1114C")
    private void handleStopActivity(IBinder token, boolean show, int configChanges) {
        ActivityClientRecord r = mActivities.get(token);
        r.activity.mConfigChangeFlags |= configChanges;

        StopInfo info = new StopInfo();
        performStopActivityInner(r, info, show, true);

        if (localLOGV) Slog.v(
            TAG, "Finishing stop of " + r + ": show=" + show
            + " win=" + r.window);

        updateVisibility(r, show);

        // Make sure any pending writes are now committed.
        if (!r.isPreHoneycomb()) {
            QueuedWork.waitToFinish();
        }

        // Tell activity manager we have been stopped.
        try {
            ActivityManagerNative.getDefault().activityStopped(
                r.token, r.state, info.thumbnail, info.description);
        } catch (RemoteException ex) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.218 -0500", hash_original_method = "F0D1B8DFE218B8E130C145F907A20AA2", hash_generated_method = "171B67353DC5124F06C72B3465E1DFD0")
    final void performRestartActivity(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        if (r.stopped) {
            r.activity.performRestart();
            r.stopped = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.219 -0500", hash_original_method = "6AC1F9C414377243EFD072AEBA5D0138", hash_generated_method = "A51FFF6C8DA13E319A9C2E458D3734DB")
    private void handleWindowVisibility(IBinder token, boolean show) {
        ActivityClientRecord r = mActivities.get(token);
        
        if (r == null) {
            Log.w(TAG, "handleWindowVisibility: no activity for token " + token);
            return;
        }
        
        if (!show && !r.stopped) {
            performStopActivityInner(r, null, show, false);
        } else if (show && r.stopped) {
            // If we are getting ready to gc after going to the background, well
            // we are back active so skip it.
            unscheduleGcIdler();

            r.activity.performRestart();
            r.stopped = false;
        }
        if (r.activity.mDecor != null) {
            if (false) Slog.v(
                TAG, "Handle window " + r + " visibility: " + show);
            updateVisibility(r, show);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.220 -0500", hash_original_method = "EAD4881422CEC6751FCD8576FDC7454E", hash_generated_method = "26229B7C7776E6B4FD2E565492016C9C")
    private void handleSleeping(IBinder token, boolean sleeping) {
        ActivityClientRecord r = mActivities.get(token);

        if (r == null) {
            Log.w(TAG, "handleSleeping: no activity for token " + token);
            return;
        }

        if (sleeping) {
            if (!r.stopped && !r.isPreHoneycomb()) {
                try {
                    // Now we are idle.
                    r.activity.performStop();
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
                r.stopped = true;
            }

            // Make sure any pending writes are now committed.
            if (!r.isPreHoneycomb()) {
                QueuedWork.waitToFinish();
            }

            // Tell activity manager we slept.
            try {
                ActivityManagerNative.getDefault().activitySlept(r.token);
            } catch (RemoteException ex) {
            }
        } else {
            if (r.stopped && r.activity.mVisibleFromServer) {
                r.activity.performRestart();
                r.stopped = false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.221 -0500", hash_original_method = "E4614A97277DCEBAE71CAB13BCF3AEA6", hash_generated_method = "88166DB0CC7E843BDDC51A66250296E8")
    private void handleSetCoreSettings(Bundle coreSettings) {
        synchronized (mPackages) {
            mCoreSettings = coreSettings;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.222 -0500", hash_original_method = "CFE517344EE2BFA081F85835A58153DF", hash_generated_method = "65CA28489AEE218ADE117EA73C562A1B")
    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData data) {
        LoadedApk apk = peekPackageInfo(data.pkg, false);
        if (apk != null) {
            apk.mCompatibilityInfo.set(data.info);
        }
        apk = peekPackageInfo(data.pkg, true);
        if (apk != null) {
            apk.mCompatibilityInfo.set(data.info);
        }
        handleConfigurationChanged(mConfiguration, data.info);
        WindowManagerImpl.getDefault().reportNewConfiguration(mConfiguration);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.223 -0500", hash_original_method = "02C0B6EC41B1BF345DD1D4B6B6C7E1EA", hash_generated_method = "1781CAA91D655E6AD2F8D4FB656CE09E")
    private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
        final int N = results.size();
        for (int i=0; i<N; i++) {
            ResultInfo ri = results.get(i);
            try {
                if (ri.mData != null) {
                    ri.mData.setExtrasClassLoader(r.activity.getClassLoader());
                }
                if (DEBUG_RESULTS) Slog.v(TAG,
                        "Delivering result to activity " + r + " : " + ri);
                r.activity.dispatchActivityResult(ri.mResultWho,
                        ri.mRequestCode, ri.mResultCode, ri.mData);
            } catch (Exception e) {
                if (!mInstrumentation.onException(r.activity, e)) {
                    throw new RuntimeException(
                            "Failure delivering result " + ri + " to activity "
                            + r.intent.getComponent().toShortString()
                            + ": " + e.toString(), e);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.224 -0500", hash_original_method = "132B22472693443B534F2F702D692F04", hash_generated_method = "09E7EE31347A47CD4055D7F94DA3A0FB")
    private void handleSendResult(ResultData res) {
        ActivityClientRecord r = mActivities.get(res.token);
        if (DEBUG_RESULTS) Slog.v(TAG, "Handling send result to " + r);
        if (r != null) {
            final boolean resumed = !r.paused;
            if (!r.activity.mFinished && r.activity.mDecor != null
                    && r.hideForNow && resumed) {
                // We had hidden the activity because it started another
                // one...  we have gotten a result back and we are not
                // paused, so make sure our window is visible.
                updateVisibility(r, true);
            }
            if (resumed) {
                try {
                    // Now we are idle.
                    r.activity.mCalled = false;
                    r.activity.mTemporaryPause = true;
                    mInstrumentation.callActivityOnPause(r.activity);
                    if (!r.activity.mCalled) {
                        throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString()
                            + " did not call through to super.onPause()");
                    }
                } catch (SuperNotCalledException e) {
                    throw e;
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
            }
            deliverResults(r, res.results);
            if (resumed) {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.225 -0500", hash_original_method = "44788E1192B2AF3D6F2EAE0CA2032491", hash_generated_method = "7418A6D8AF3576D340A3ABF3FCB705A7")
    public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        return performDestroyActivity(token, finishing, 0, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.227 -0500", hash_original_method = "C0523473C414844F9752EDA7A2CAF03B", hash_generated_method = "83AB5956B287F0E4BB076AD7146EFB9E")
    private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        ActivityClientRecord r = mActivities.get(token);
        Class activityClass = null;
        if (localLOGV) Slog.v(TAG, "Performing finish of " + r);
        if (r != null) {
            activityClass = r.activity.getClass();
            r.activity.mConfigChangeFlags |= configChanges;
            if (finishing) {
                r.activity.mFinished = true;
            }
            if (!r.paused) {
                try {
                    r.activity.mCalled = false;
                    mInstrumentation.callActivityOnPause(r.activity);
                    EventLog.writeEvent(LOG_ON_PAUSE_CALLED,
                            r.activity.getComponentName().getClassName());
                    if (!r.activity.mCalled) {
                        throw new SuperNotCalledException(
                            "Activity " + safeToComponentShortString(r.intent)
                            + " did not call through to super.onPause()");
                    }
                } catch (SuperNotCalledException e) {
                    throw e;
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to pause activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                    }
                }
                r.paused = true;
            }
            if (!r.stopped) {
                try {
                    r.activity.performStop();
                } catch (SuperNotCalledException e) {
                    throw e;
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to stop activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                    }
                }
                r.stopped = true;
            }
            if (getNonConfigInstance) {
                try {
                    r.lastNonConfigurationInstances
                            = r.activity.retainNonConfigurationInstances();
                } catch (Exception e) {
                    if (!mInstrumentation.onException(r.activity, e)) {
                        throw new RuntimeException(
                                "Unable to retain activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                    }
                }
            }
            try {
                r.activity.mCalled = false;
                mInstrumentation.callActivityOnDestroy(r.activity);
                if (!r.activity.mCalled) {
                    throw new SuperNotCalledException(
                        "Activity " + safeToComponentShortString(r.intent) +
                        " did not call through to super.onDestroy()");
                }
                if (r.window != null) {
                    r.window.closeAllPanels();
                }
            } catch (SuperNotCalledException e) {
                throw e;
            } catch (Exception e) {
                if (!mInstrumentation.onException(r.activity, e)) {
                    throw new RuntimeException(
                            "Unable to destroy activity " + safeToComponentShortString(r.intent)
                            + ": " + e.toString(), e);
                }
            }
        }
        mActivities.remove(token);
        StrictMode.decrementExpectedActivityCount(activityClass);
        return r;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.229 -0500", hash_original_method = "FF5883360F029BC934513AEE9A22C396", hash_generated_method = "5D64069D1E0E53F6BC05F80990C42C46")
    private void handleDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        ActivityClientRecord r = performDestroyActivity(token, finishing,
                configChanges, getNonConfigInstance);
        if (r != null) {
            cleanUpPendingRemoveWindows(r);
            WindowManager wm = r.activity.getWindowManager();
            View v = r.activity.mDecor;
            if (v != null) {
                if (r.activity.mVisibleFromServer) {
                    mNumVisibleActivities--;
                }
                IBinder wtoken = v.getWindowToken();
                if (r.activity.mWindowAdded) {
                    if (r.onlyLocalRequest) {
                        // Hold off on removing this until the new activity's
                        // window is being added.
                        r.mPendingRemoveWindow = v;
                        r.mPendingRemoveWindowManager = wm;
                    } else {
                        wm.removeViewImmediate(v);
                    }
                }
                if (wtoken != null && r.mPendingRemoveWindow == null) {
                    WindowManagerImpl.getDefault().closeAll(wtoken,
                            r.activity.getClass().getName(), "Activity");
                }
                r.activity.mDecor = null;
            }
            if (r.mPendingRemoveWindow == null) {
                // If we are delaying the removal of the activity window, then
                // we can't clean up all windows here.  Note that we can't do
                // so later either, which means any windows that aren't closed
                // by the app will leak.  Well we try to warning them a lot
                // about leaking windows, because that is a bug, so if they are
                // using this recreate facility then they get to live with leaks.
                WindowManagerImpl.getDefault().closeAll(token,
                        r.activity.getClass().getName(), "Activity");
            }

            // Mocked out contexts won't be participating in the normal
            // process lifecycle, but if we're running with a proper
            // ApplicationContext we need to have it tear down things
            // cleanly.
            Context c = r.activity.getBaseContext();
            if (c instanceof ContextImpl) {
                ((ContextImpl) c).scheduleFinalCleanup(
                        r.activity.getClass().getName(), "Activity");
            }
        }
        if (finishing) {
            try {
                ActivityManagerNative.getDefault().activityDestroyed(token);
            } catch (RemoteException ex) {
                // If the system process has died, it's game over for everyone.
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.230 -0500", hash_original_method = "A011A63AC4A3DA99018317E87A8885A6", hash_generated_method = "D030D33D0AFDC9BD4ECD32E42A3A7066")
    public final void requestRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config,
            boolean fromServer) {
        ActivityClientRecord target = null;

        synchronized (mPackages) {
            for (int i=0; i<mRelaunchingActivities.size(); i++) {
                ActivityClientRecord r = mRelaunchingActivities.get(i);
                if (r.token == token) {
                    target = r;
                    if (pendingResults != null) {
                        if (r.pendingResults != null) {
                            r.pendingResults.addAll(pendingResults);
                        } else {
                            r.pendingResults = pendingResults;
                        }
                    }
                    if (pendingNewIntents != null) {
                        if (r.pendingIntents != null) {
                            r.pendingIntents.addAll(pendingNewIntents);
                        } else {
                            r.pendingIntents = pendingNewIntents;
                        }
                    }
                    break;
                }
            }

            if (target == null) {
                target = new ActivityClientRecord();
                target.token = token;
                target.pendingResults = pendingResults;
                target.pendingIntents = pendingNewIntents;
                if (!fromServer) {
                    ActivityClientRecord existing = mActivities.get(token);
                    if (existing != null) {
                        target.startsNotResumed = existing.paused;
                    }
                    target.onlyLocalRequest = true;
                }
                mRelaunchingActivities.add(target);
                queueOrSendMessage(H.RELAUNCH_ACTIVITY, target);
            }

            if (fromServer) {
                target.startsNotResumed = notResumed;
                target.onlyLocalRequest = false;
            }
            if (config != null) {
                target.createdConfig = config;
            }
            target.pendingConfigChanges |= configChanges;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.232 -0500", hash_original_method = "BE5C8E93A13CCFB0B92460FEFD999D51", hash_generated_method = "EF3DE607F45460877BAD410EA9FC6566")
    private void handleRelaunchActivity(ActivityClientRecord tmp) {
        // If we are getting ready to gc after going to the background, well
        // we are back active so skip it.
        unscheduleGcIdler();

        Configuration changedConfig = null;
        int configChanges = 0;

        // First: make sure we have the most recent configuration and most
        // recent version of the activity, or skip it if some previous call
        // had taken a more recent version.
        synchronized (mPackages) {
            int N = mRelaunchingActivities.size();
            IBinder token = tmp.token;
            tmp = null;
            for (int i=0; i<N; i++) {
                ActivityClientRecord r = mRelaunchingActivities.get(i);
                if (r.token == token) {
                    tmp = r;
                    configChanges |= tmp.pendingConfigChanges;
                    mRelaunchingActivities.remove(i);
                    i--;
                    N--;
                }
            }

            if (tmp == null) {
                if (DEBUG_CONFIGURATION) Slog.v(TAG, "Abort, activity not relaunching!");
                return;
            }

            if (DEBUG_CONFIGURATION) Slog.v(TAG, "Relaunching activity "
                    + tmp.token + " with configChanges=0x"
                    + Integer.toHexString(configChanges));

            if (mPendingConfiguration != null) {
                changedConfig = mPendingConfiguration;
                mPendingConfiguration = null;
            }
        }

        if (tmp.createdConfig != null) {
            // If the activity manager is passing us its current config,
            // assume that is really what we want regardless of what we
            // may have pending.
            if (mConfiguration == null
                    || (tmp.createdConfig.isOtherSeqNewer(mConfiguration)
                            && mConfiguration.diff(tmp.createdConfig) != 0)) {
                if (changedConfig == null
                        || tmp.createdConfig.isOtherSeqNewer(changedConfig)) {
                    changedConfig = tmp.createdConfig;
                }
            }
        }
        
        if (DEBUG_CONFIGURATION) Slog.v(TAG, "Relaunching activity "
                + tmp.token + ": changedConfig=" + changedConfig);
        
        // If there was a pending configuration change, execute it first.
        if (changedConfig != null) {
            handleConfigurationChanged(changedConfig, null);
        }

        ActivityClientRecord r = mActivities.get(tmp.token);
        if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handling relaunch of " + r);
        if (r == null) {
            return;
        }

        r.activity.mConfigChangeFlags |= configChanges;
        r.onlyLocalRequest = tmp.onlyLocalRequest;
        Intent currentIntent = r.activity.mIntent;

        r.activity.mChangingConfigurations = true;

        // Need to ensure state is saved.
        if (!r.paused) {
            performPauseActivity(r.token, false, r.isPreHoneycomb());
        }
        if (r.state == null && !r.stopped && !r.isPreHoneycomb()) {
            r.state = new Bundle();
            r.state.setAllowFds(false);
            mInstrumentation.callActivityOnSaveInstanceState(r.activity, r.state);
        }

        handleDestroyActivity(r.token, false, configChanges, true);

        r.activity = null;
        r.window = null;
        r.hideForNow = false;
        r.nextIdle = null;
        // Merge any pending results and pending intents; don't just replace them
        if (tmp.pendingResults != null) {
            if (r.pendingResults == null) {
                r.pendingResults = tmp.pendingResults;
            } else {
                r.pendingResults.addAll(tmp.pendingResults);
            }
        }
        if (tmp.pendingIntents != null) {
            if (r.pendingIntents == null) {
                r.pendingIntents = tmp.pendingIntents;
            } else {
                r.pendingIntents.addAll(tmp.pendingIntents);
            }
        }
        r.startsNotResumed = tmp.startsNotResumed;

        handleLaunchActivity(r, currentIntent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.233 -0500", hash_original_method = "D80F947211B8AA9FA3600ABD6DD9A5E5", hash_generated_method = "B3A1804409B43E781B5910E718654567")
    private void handleRequestThumbnail(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        Bitmap thumbnail = createThumbnailBitmap(r);
        CharSequence description = null;
        try {
            description = r.activity.onCreateDescription();
        } catch (Exception e) {
            if (!mInstrumentation.onException(r.activity, e)) {
                throw new RuntimeException(
                        "Unable to create description of activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
            }
        }
        //System.out.println("Reporting top thumbnail " + thumbnail);
        try {
            ActivityManagerNative.getDefault().reportThumbnail(
                token, thumbnail, description);
        } catch (RemoteException ex) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.235 -0500", hash_original_method = "FB356249739137DBEEC4A6A95AF7FF01", hash_generated_method = "DDB925BE1735FA9EF6F32EB60AB98E90")
    ArrayList<ComponentCallbacks2> collectComponentCallbacksLocked(
            boolean allActivities, Configuration newConfig) {
        ArrayList<ComponentCallbacks2> callbacks
                = new ArrayList<ComponentCallbacks2>();

        if (mActivities.size() > 0) {
            Iterator<ActivityClientRecord> it = mActivities.values().iterator();
            while (it.hasNext()) {
                ActivityClientRecord ar = it.next();
                Activity a = ar.activity;
                if (a != null) {
                    Configuration thisConfig = applyConfigCompatMainThread(newConfig,
                            ar.packageInfo.mCompatibilityInfo.getIfNeeded());
                    if (!ar.activity.mFinished && (allActivities ||
                            (a != null && !ar.paused))) {
                        // If the activity is currently resumed, its configuration
                        // needs to change right now.
                        callbacks.add(a);
                    } else if (thisConfig != null) {
                        // Otherwise, we will tell it about the change
                        // the next time it is resumed or shown.  Note that
                        // the activity manager may, before then, decide the
                        // activity needs to be destroyed to handle its new
                        // configuration.
                        if (DEBUG_CONFIGURATION) Slog.v(TAG, "Setting activity "
                                + ar.activityInfo.name + " newConfig=" + thisConfig);
                        ar.newConfig = thisConfig;
                    }
                }
            }
        }
        if (mServices.size() > 0) {
            Iterator<Service> it = mServices.values().iterator();
            while (it.hasNext()) {
                callbacks.add(it.next());
            }
        }
        synchronized (mProviderMap) {
            if (mLocalProviders.size() > 0) {
                Iterator<ProviderClientRecord> it = mLocalProviders.values().iterator();
                while (it.hasNext()) {
                    callbacks.add(it.next().mLocalProvider);
                }
            }
        }
        final int N = mAllApplications.size();
        for (int i=0; i<N; i++) {
            callbacks.add(mAllApplications.get(i));
        }

        return callbacks;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.236 -0500", hash_original_method = "EE8F576B02EBE8F159FE2A319294FB0B", hash_generated_method = "E70C352A863400E7BAEBFD4D70A576D0")
    private final void performConfigurationChanged(
            ComponentCallbacks2 cb, Configuration config) {
        // Only for Activity objects, check that they actually call up to their
        // superclass implementation.  ComponentCallbacks2 is an interface, so
        // we check the runtime type and act accordingly.
        Activity activity = (cb instanceof Activity) ? (Activity) cb : null;
        if (activity != null) {
            activity.mCalled = false;
        }

        boolean shouldChangeConfig = false;
        if ((activity == null) || (activity.mCurrentConfig == null)) {
            shouldChangeConfig = true;
        } else {

            // If the new config is the same as the config this Activity
            // is already running with then don't bother calling
            // onConfigurationChanged
            int diff = activity.mCurrentConfig.diff(config);
            if (diff != 0) {
                // If this activity doesn't handle any of the config changes
                // then don't bother calling onConfigurationChanged as we're
                // going to destroy it.
                if ((~activity.mActivityInfo.getRealConfigChanged() & diff) == 0) {
                    shouldChangeConfig = true;
                }
            }
        }

        if (DEBUG_CONFIGURATION) Slog.v(TAG, "Config callback " + cb
                + ": shouldChangeConfig=" + shouldChangeConfig);
        if (shouldChangeConfig) {
            cb.onConfigurationChanged(config);

            if (activity != null) {
                if (!activity.mCalled) {
                    throw new SuperNotCalledException(
                            "Activity " + activity.getLocalClassName() +
                        " did not call through to super.onConfigurationChanged()");
                }
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(config);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.236 -0500", hash_original_method = "7998F4E95C6128D4C656838AA6A46FDD", hash_generated_method = "8608686ADD801E855F0F001C7F6FA9C8")
    public final void applyConfigurationToResources(Configuration config) {
        synchronized (mPackages) {
            applyConfigurationToResourcesLocked(config, null);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.237 -0500", hash_original_method = "EEF98A9F112FD55BEEF8F44AEC4B59F9", hash_generated_method = "8D5B99A8ADD99D9B7206F8A72C9E627F")
    final boolean applyConfigurationToResourcesLocked(Configuration config,
            CompatibilityInfo compat) {
        if (mResConfiguration == null) {
            mResConfiguration = new Configuration();
        }
        if (!mResConfiguration.isOtherSeqNewer(config) && compat == null) {
            if (DEBUG_CONFIGURATION) Slog.v(TAG, "Skipping new config: curSeq="
                    + mResConfiguration.seq + ", newSeq=" + config.seq);
            return false;
        }
        int changes = mResConfiguration.updateFrom(config);
        DisplayMetrics dm = getDisplayMetricsLocked(null, true);

        if (compat != null && (mResCompatibilityInfo == null ||
                !mResCompatibilityInfo.equals(compat))) {
            mResCompatibilityInfo = compat;
            changes |= ActivityInfo.CONFIG_SCREEN_LAYOUT
                    | ActivityInfo.CONFIG_SCREEN_SIZE
                    | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
        }

        // set it for java, this also affects newly created Resources
        if (config.locale != null) {
            Locale.setDefault(config.locale);
        }

        Resources.updateSystemConfiguration(config, dm, compat);

        ApplicationPackageManager.configurationChanged();
        //Slog.i(TAG, "Configuration changed in " + currentPackageName());
        
        Iterator<WeakReference<Resources>> it =
            mActiveResources.values().iterator();
        //Iterator<Map.Entry<String, WeakReference<Resources>>> it =
        //    mActiveResources.entrySet().iterator();
        while (it.hasNext()) {
            WeakReference<Resources> v = it.next();
            Resources r = v.get();
            if (r != null) {
                if (DEBUG_CONFIGURATION) Slog.v(TAG, "Changing resources "
                        + r + " config to: " + config);
                r.updateConfiguration(config, dm, compat);
                //Slog.i(TAG, "Updated app resources " + v.getKey()
                //        + " " + r + ": " + r.getConfiguration());
            } else {
                //Slog.i(TAG, "Removing old resources " + v.getKey());
                it.remove();
            }
        }
        
        return changes != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.238 -0500", hash_original_method = "725924C293B055D0DF33B7EFFEB77D1D", hash_generated_method = "CEAB217195228ED6000534C89B423C86")
    final Configuration applyCompatConfiguration() {
        Configuration config = mConfiguration;
        if (mCompatConfiguration == null) {
            mCompatConfiguration = new Configuration();
        }
        mCompatConfiguration.setTo(mConfiguration);
        if (mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen()) {
            mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
            config = mCompatConfiguration;
        }
        return config;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.239 -0500", hash_original_method = "113EE31E90E397ADB444BCE89226F34D", hash_generated_method = "0BD8C8EA64E25D7107D28B5BD697B961")
    final void handleConfigurationChanged(Configuration config, CompatibilityInfo compat) {

        ArrayList<ComponentCallbacks2> callbacks = null;

        synchronized (mPackages) {
            if (mPendingConfiguration != null) {
                if (!mPendingConfiguration.isOtherSeqNewer(config)) {
                    config = mPendingConfiguration;
                }
                mPendingConfiguration = null;
            }

            if (config == null) {
                return;
            }
            
            if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handle configuration changed: "
                    + config);
        
            applyConfigurationToResourcesLocked(config, compat);
            
            if (mConfiguration == null) {
                mConfiguration = new Configuration();
            }
            if (!mConfiguration.isOtherSeqNewer(config) && compat == null) {
                return;
            }
            mConfiguration.updateFrom(config);
            config = applyCompatConfiguration();
            callbacks = collectComponentCallbacksLocked(false, config);
        }
        
        // Cleanup hardware accelerated stuff
        WindowManagerImpl.getDefault().trimLocalMemory();

        if (callbacks != null) {
            final int N = callbacks.size();
            for (int i=0; i<N; i++) {
                performConfigurationChanged(callbacks.get(i), config);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.240 -0500", hash_original_method = "BCC706E36DA945D7B18FA237C2CE8FDE", hash_generated_method = "EF204A14FFD5E69946F56E15F33B8A79")
    final void handleActivityConfigurationChanged(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        if (r == null || r.activity == null) {
            return;
        }

        if (DEBUG_CONFIGURATION) Slog.v(TAG, "Handle activity config changed: "
                + r.activityInfo.name);
        
        performConfigurationChanged(r.activity, mCompatConfiguration);
    }

    
    static final class ActivityClientRecord {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.940 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.941 -0500", hash_original_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.942 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.942 -0500", hash_original_field = "C00C2C61984260DF3B4937ADC46E8A7C", hash_generated_field = "C00C2C61984260DF3B4937ADC46E8A7C")

        Bundle state;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.943 -0500", hash_original_field = "A63B0916BD4AC2611D1AF746A2DF045C", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.944 -0500", hash_original_field = "C8345ED8E0FB49346B128B9846AFDDB2", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.945 -0500", hash_original_field = "8772E5B00EE7781FE599C41013926102", hash_generated_field = "8772E5B00EE7781FE599C41013926102")

        Activity parent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.946 -0500", hash_original_field = "99A507AF2C301E2FF9994737D79275BB", hash_generated_field = "99A507AF2C301E2FF9994737D79275BB")

        String embeddedID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.947 -0500", hash_original_field = "2EF688309E753499C339EBE96926B7C3", hash_generated_field = "2EF688309E753499C339EBE96926B7C3")

        Activity.NonConfigurationInstances lastNonConfigurationInstances;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.947 -0500", hash_original_field = "5637B5D432947459416E03554347708E", hash_generated_field = "5637B5D432947459416E03554347708E")

        boolean paused;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.948 -0500", hash_original_field = "B0899FB375A0A57065DA66B38777B6C0", hash_generated_field = "B0899FB375A0A57065DA66B38777B6C0")

        boolean stopped;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.949 -0500", hash_original_field = "5DCC7672BCF10641A46EAA548A687CD5", hash_generated_field = "5DCC7672BCF10641A46EAA548A687CD5")

        boolean hideForNow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.950 -0500", hash_original_field = "DD2677A28540A2EE77D6F7429A2F8892", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.951 -0500", hash_original_field = "44F8DA58F1EEFDF22FCF6A1FED0376C3", hash_generated_field = "44F8DA58F1EEFDF22FCF6A1FED0376C3")

        Configuration createdConfig;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.951 -0500", hash_original_field = "583CE8A57524BB39C7618CF1F2B65C96", hash_generated_field = "583CE8A57524BB39C7618CF1F2B65C96")

        ActivityClientRecord nextIdle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.952 -0500", hash_original_field = "0AEB1625B8037FA1222953DB04FF40F7", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")


        String profileFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.953 -0500", hash_original_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.953 -0500", hash_original_field = "7730B1164360352D89737A9ABB4F979F", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.954 -0500", hash_original_field = "9CFCA1B7F8752ABB79A9EED9367C413A", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")


        ActivityInfo activityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.955 -0500", hash_original_field = "2B67D7EEC5FDB496E2BE58A0747899F8", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.956 -0500", hash_original_field = "6FE708D4D9958EC105E3B69C43275F19", hash_generated_field = "6FE708D4D9958EC105E3B69C43275F19")

        LoadedApk packageInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.956 -0500", hash_original_field = "A77E9DD92A64C5F780B6000CA80182A2", hash_generated_field = "A77E9DD92A64C5F780B6000CA80182A2")


        List<ResultInfo> pendingResults;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.957 -0500", hash_original_field = "4BC30CA1B8786644C876DAF48F78533F", hash_generated_field = "4BC30CA1B8786644C876DAF48F78533F")

        List<Intent> pendingIntents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.958 -0500", hash_original_field = "5CE883BF4DAD47FBDAF4D2C3F7074402", hash_generated_field = "5CE883BF4DAD47FBDAF4D2C3F7074402")


        boolean startsNotResumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.959 -0500", hash_original_field = "8A03F39D432E8E43D36A30D2C65BF04B", hash_generated_field = "8A03F39D432E8E43D36A30D2C65BF04B")

        boolean isForward;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.959 -0500", hash_original_field = "2BC5D372006E004497C167DEE6104107", hash_generated_field = "2BC5D372006E004497C167DEE6104107")

        int pendingConfigChanges;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.960 -0500", hash_original_field = "970B3D7A6F8A2CE63E822A10DBAD0F49", hash_generated_field = "970B3D7A6F8A2CE63E822A10DBAD0F49")

        boolean onlyLocalRequest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.961 -0500", hash_original_field = "C7546AC98481F963F1798A1F44EE5004", hash_generated_field = "C7546AC98481F963F1798A1F44EE5004")


        View mPendingRemoveWindow;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.962 -0500", hash_original_field = "651EDB05D2F89D6E111AFDE79ADF6A66", hash_generated_field = "651EDB05D2F89D6E111AFDE79ADF6A66")

        WindowManager mPendingRemoveWindowManager;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.963 -0500", hash_original_method = "B5F524E6EAF79ED64F291F38DBCEDD1B", hash_generated_method = "B5F524E6EAF79ED64F291F38DBCEDD1B")
        ActivityClientRecord() {
            parent = null;
            embeddedID = null;
            paused = false;
            stopped = false;
            hideForNow = false;
            nextIdle = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.963 -0500", hash_original_method = "2761403398E750945AAB952EA69C6C0F", hash_generated_method = "DDC144B5D91753BE4C121A963ABDC53D")
        public boolean isPreHoneycomb() {
            if (activity != null) {
                return activity.getApplicationInfo().targetSdkVersion
                        < android.os.Build.VERSION_CODES.HONEYCOMB;
            }
            return false;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.964 -0500", hash_original_method = "C4594DCD1E896B9BDB54D56E10F2B8EE", hash_generated_method = "C063BDA3A9088C060F96C5DED682B528")
        public String toString() {
            ComponentName componentName = intent.getComponent();
            return "ActivityRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " token=" + token + " " + (componentName == null
                        ? "no component name" : componentName.toShortString())
                + "}";
        }

        
    }


    
    final class ProviderClientRecord implements IBinder.DeathRecipient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.966 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

         String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.967 -0500", hash_original_field = "4165A1FBAFFD21863CC0EAC1937582F7", hash_generated_field = "4165A1FBAFFD21863CC0EAC1937582F7")

         IContentProvider mProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.968 -0500", hash_original_field = "7AAFFB6DED098E36BD02CC080B04AF7E", hash_generated_field = "7AAFFB6DED098E36BD02CC080B04AF7E")

         ContentProvider mLocalProvider;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.969 -0500", hash_original_method = "C7097CC666CFF4D083C9B2045DB42E29", hash_generated_method = "C7097CC666CFF4D083C9B2045DB42E29")
        ProviderClientRecord(String name, IContentProvider provider,
                ContentProvider localProvider) {
            mName = name;
            mProvider = provider;
            mLocalProvider = localProvider;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.970 -0500", hash_original_method = "3801456C44CFB93A5BA86A8AB8C43B3F", hash_generated_method = "EEF7D51E8D94DB9CDE6E4D1BD4AE969F")
        public void binderDied() {
            removeDeadProvider(mName, mProvider);
        }

        
    }


    
    static final class NewIntentData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.972 -0500", hash_original_field = "DCC84A2BE9F90A98827B285408558812", hash_generated_field = "DCC84A2BE9F90A98827B285408558812")

        List<Intent> intents;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.972 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.616 -0400", hash_original_method = "9A9162E54721E56B9804FAED427417E2", hash_generated_method = "9A9162E54721E56B9804FAED427417E2")
        public NewIntentData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.973 -0500", hash_original_method = "E9F4DBEB4C72AFF7F672A47023D2DCCE", hash_generated_method = "90EA49ED8754F00F3EE4D534933D780B")
        public String toString() {
            return "NewIntentData{intents=" + intents + " token=" + token + "}";
        }

        
    }


    
    static final class ReceiverData extends BroadcastReceiver.PendingResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.976 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")


        Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.977 -0500", hash_original_field = "D6562EB0A3FC9B94476A16D5F303F058", hash_generated_field = "D6562EB0A3FC9B94476A16D5F303F058")

        ActivityInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.978 -0500", hash_original_field = "2B67D7EEC5FDB496E2BE58A0747899F8", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.976 -0500", hash_original_method = "95DC539EA4572F0714768317249686D3", hash_generated_method = "F3E77934428C19496ADEDD6B2C484C01")
        public ReceiverData(Intent intent, int resultCode, String resultData, Bundle resultExtras,
                boolean ordered, boolean sticky, IBinder token) {
            super(resultCode, resultData, resultExtras, TYPE_COMPONENT, ordered, sticky, token);
            this.intent = intent;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.979 -0500", hash_original_method = "062A80C4BE8CE608AA3884983AB20A02", hash_generated_method = "60230EECBB6D3DF91BAB63F5C9990602")
        public String toString() {
            return "ReceiverData{intent=" + intent + " packageName=" +
                    info.packageName + " resultCode=" + getResultCode()
                    + " resultData=" + getResultData() + " resultExtras="
                    + getResultExtras(false) + "}";
        }

        
    }


    
    static final class CreateBackupAgentData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.980 -0500", hash_original_field = "BB93ED015037E8AFDF3FDE7CABC1B568", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.981 -0500", hash_original_field = "2B67D7EEC5FDB496E2BE58A0747899F8", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.982 -0500", hash_original_field = "F90DF71BF48FAFE07F43CB879F966CE3", hash_generated_field = "F90DF71BF48FAFE07F43CB879F966CE3")

        int backupMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.624 -0400", hash_original_method = "7F9A4ECF6FE623DBC230D640707CDFD0", hash_generated_method = "7F9A4ECF6FE623DBC230D640707CDFD0")
        public CreateBackupAgentData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.982 -0500", hash_original_method = "87705B4B5A78FEE0786C01D6E7384189", hash_generated_method = "C0FB4C977C99228990BFFFB27F15FCE8")
        public String toString() {
            return "CreateBackupAgentData{appInfo=" + appInfo
                    + " backupAgent=" + appInfo.backupAgentName
                    + " mode=" + backupMode + "}";
        }

        
    }


    
    static final class CreateServiceData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.984 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.985 -0500", hash_original_field = "4AEE41877C99C71A9296A5C433E71F7C", hash_generated_field = "4AEE41877C99C71A9296A5C433E71F7C")

        ServiceInfo info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.985 -0500", hash_original_field = "2B67D7EEC5FDB496E2BE58A0747899F8", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.986 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.628 -0400", hash_original_method = "881257217964B643C1B29F21F8324D73", hash_generated_method = "881257217964B643C1B29F21F8324D73")
        public CreateServiceData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.987 -0500", hash_original_method = "DE656B2587EA58A3FB80D8944832AD3A", hash_generated_method = "E832DED7CB7DECD3B5F9301E94409B3C")
        public String toString() {
            return "CreateServiceData{token=" + token + " className="
            + info.name + " packageName=" + info.packageName
            + " intent=" + intent + "}";
        }

        
    }


    
    static final class BindServiceData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.988 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.989 -0500", hash_original_field = "170FCA7A98A65D8003A3D20D5B3C245D", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.990 -0500", hash_original_field = "35FF113739960C8FEB167B42458B2109", hash_generated_field = "35FF113739960C8FEB167B42458B2109")

        boolean rebind;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.635 -0400", hash_original_method = "2B59A1695FBC674B2F74F0571D5E38A2", hash_generated_method = "2B59A1695FBC674B2F74F0571D5E38A2")
        public BindServiceData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.991 -0500", hash_original_method = "788B7BFDCE261467774852FF99962FB6", hash_generated_method = "8AD8F6164F5D0DC4E3EBB12DC32A96D9")
        public String toString() {
            return "BindServiceData{token=" + token + " intent=" + intent + "}";
        }

        
    }


    
    static final class ServiceArgsData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.993 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.994 -0500", hash_original_field = "CB66DDA6D80EB80E88BF8636FFAE2527", hash_generated_field = "CB66DDA6D80EB80E88BF8636FFAE2527")

        boolean taskRemoved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.994 -0500", hash_original_field = "B575BF041CFA248D715BE93778A966DC", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.995 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.996 -0500", hash_original_field = "77AB5E543174DF1F66D162C0382A930F", hash_generated_field = "77AB5E543174DF1F66D162C0382A930F")

        Intent args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.640 -0400", hash_original_method = "103D015CCE841E84C3050E807488FBE9", hash_generated_method = "103D015CCE841E84C3050E807488FBE9")
        public ServiceArgsData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.997 -0500", hash_original_method = "9123370A477925A90205ABBEEFE44004", hash_generated_method = "49329602825DCD914B70550BC75EE127")
        public String toString() {
            return "ServiceArgsData{token=" + token + " startId=" + startId
            + " args=" + args + "}";
        }

        
    }


    
    static final class AppBindData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.998 -0500", hash_original_field = "CFE674900E356A9F4BF51234744250B8", hash_generated_field = "CFE674900E356A9F4BF51234744250B8")

        LoadedApk info;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:19.999 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "182AC29DC74CEB0C6C89C5576E47A4DD")

        String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.000 -0500", hash_original_field = "BB93ED015037E8AFDF3FDE7CABC1B568", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.001 -0500", hash_original_field = "7A9F4634EB01C0456156CF1B784BCEC9", hash_generated_field = "7A9F4634EB01C0456156CF1B784BCEC9")

        List<ProviderInfo> providers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.001 -0500", hash_original_field = "3F5DA88F1FEC15C88CB883D59573E813", hash_generated_field = "3F5DA88F1FEC15C88CB883D59573E813")

        ComponentName instrumentationName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.002 -0500", hash_original_field = "73077E024184109776339B9D1BEE35EB", hash_generated_field = "73077E024184109776339B9D1BEE35EB")

        Bundle instrumentationArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.003 -0500", hash_original_field = "B075C237152068CFAEC1BD98818F5007", hash_generated_field = "B075C237152068CFAEC1BD98818F5007")

        IInstrumentationWatcher instrumentationWatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.004 -0500", hash_original_field = "5FC68647D6D0CF439E6B829CC880890C", hash_generated_field = "5FC68647D6D0CF439E6B829CC880890C")

        int debugMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.004 -0500", hash_original_field = "4EAC7CFAA88429E81A3DA1B88F7F0814", hash_generated_field = "4EAC7CFAA88429E81A3DA1B88F7F0814")

        boolean restrictedBackupMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.005 -0500", hash_original_field = "B853B56DA62629292AFB975D2A443261", hash_generated_field = "B853B56DA62629292AFB975D2A443261")

        boolean persistent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.006 -0500", hash_original_field = "A3F5781DE6AF7A59A7DBAA1BECE272A9", hash_generated_field = "A3F5781DE6AF7A59A7DBAA1BECE272A9")

        Configuration config;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.007 -0500", hash_original_field = "2B67D7EEC5FDB496E2BE58A0747899F8", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.007 -0500", hash_original_field = "DB4FDD2502B5FFC034FB83C77C56111F", hash_generated_field = "DB4FDD2502B5FFC034FB83C77C56111F")

        String initProfileFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.008 -0500", hash_original_field = "D60C582964877A307BEAF4053762EF15", hash_generated_field = "D60C582964877A307BEAF4053762EF15")

        ParcelFileDescriptor initProfileFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.009 -0500", hash_original_field = "2D2D69EB52002C7C4F13F0178D625E55", hash_generated_field = "2D2D69EB52002C7C4F13F0178D625E55")

        boolean initAutoStopProfiler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.646 -0400", hash_original_method = "EDE65A505FE77989B4B34B8F22E2D58F", hash_generated_method = "EDE65A505FE77989B4B34B8F22E2D58F")
        public AppBindData ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.010 -0500", hash_original_method = "2BA8F6DB78683607CF1A79B96A9E1945", hash_generated_method = "013D1B36A42F26935F9FC793D3DD8D63")
        public String toString() {
            return "AppBindData{appInfo=" + appInfo + "}";
        }

        
    }


    
    static final class Profiler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.011 -0500", hash_original_field = "0AEB1625B8037FA1222953DB04FF40F7", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.012 -0500", hash_original_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.013 -0500", hash_original_field = "7730B1164360352D89737A9ABB4F979F", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.014 -0500", hash_original_field = "5AEBAB31656E136FF8335BF7952CBD3D", hash_generated_field = "5AEBAB31656E136FF8335BF7952CBD3D")

        boolean profiling;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.014 -0500", hash_original_field = "CFD51622CC9205EA276B9A72B7AC1389", hash_generated_field = "CFD51622CC9205EA276B9A72B7AC1389")

        boolean handlingProfiling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.654 -0400", hash_original_method = "7B9BEA1F6EC95E751CD548D4F51680C9", hash_generated_method = "7B9BEA1F6EC95E751CD548D4F51680C9")
        public Profiler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.015 -0500", hash_original_method = "A8A96BF1FCBE3854C04202513222077A", hash_generated_method = "E344F221045350BAE90D62B5B89017E1")
        public void setProfiler(String file, ParcelFileDescriptor fd) {
            if (profiling) {
                if (fd != null) {
                    try {
                        fd.close();
                    } catch (IOException e) {
                    }
                }
                return;
            }
            if (profileFd != null) {
                try {
                    profileFd.close();
                } catch (IOException e) {
                }
            }
            profileFile = file;
            profileFd = fd;
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.016 -0500", hash_original_method = "4BADC9424DA1A3AC7F9D5563006BCE42", hash_generated_method = "034A8D9A6D326230D66CAFDAE10018A1")
        public void startProfiling() {
            if (profileFd == null || profiling) {
                return;
            }
            try {
                Debug.startMethodTracing(profileFile, profileFd.getFileDescriptor(),
                        8 * 1024 * 1024, 0);
                profiling = true;
            } catch (RuntimeException e) {
                Slog.w(TAG, "Profiling failed on path " + profileFile);
                try {
                    profileFd.close();
                    profileFd = null;
                } catch (IOException e2) {
                    Slog.w(TAG, "Failure closing profile fd", e2);
                }
            }
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.017 -0500", hash_original_method = "F0726A3E7708B3CB256CEACF5FA42FD5", hash_generated_method = "9DB88A9583ECEE6B0741A86BDA72D8BF")
        public void stopProfiling() {
            if (profiling) {
                profiling = false;
                Debug.stopMethodTracing();
                if (profileFd != null) {
                    try {
                        profileFd.close();
                    } catch (IOException e) {
                    }
                }
                profileFd = null;
                profileFile = null;
            }
        }

        
    }


    
    static final class DumpComponentInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.019 -0500", hash_original_field = "ED4BCC0409574E6EB5292B0FF005E3EB", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.020 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.021 -0500", hash_original_field = "D07D332701F9B92847141D46D8B2C7CF", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

        String prefix;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.021 -0500", hash_original_field = "7F2C1FD08D9A857D4D2EDF6F9394FC1F", hash_generated_field = "7F2C1FD08D9A857D4D2EDF6F9394FC1F")

        String[] args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.664 -0400", hash_original_method = "705FE87B3B944DB1E7088D167B1442FA", hash_generated_method = "705FE87B3B944DB1E7088D167B1442FA")
        public DumpComponentInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ResultData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.023 -0500", hash_original_field = "AEFA330A775EF7A6CCCEA63565B352D0", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.023 -0500", hash_original_field = "C3849EE0113C1C1730E99FB7C260DA4E", hash_generated_field = "C3849EE0113C1C1730E99FB7C260DA4E")

        List<ResultInfo> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.665 -0400", hash_original_method = "3466C6D5CF0FEDF7456B3B9BA6367B40", hash_generated_method = "3466C6D5CF0FEDF7456B3B9BA6367B40")
        public ResultData ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.024 -0500", hash_original_method = "BA3AA15664E126972C9E79255FFB7B3E", hash_generated_method = "D0EEBA59622A8A916E6C93CE8C9C7D49")
        public String toString() {
            return "ResultData{token=" + token + " results" + results + "}";
        }

        
    }


    
    static final class ContextCleanupInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.026 -0500", hash_original_field = "C9CD4205E05705EAD2345480C07726F5", hash_generated_field = "C9CD4205E05705EAD2345480C07726F5")

        ContextImpl context;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.026 -0500", hash_original_field = "EA705FF509AF2D1BE17CB07841038A94", hash_generated_field = "EA705FF509AF2D1BE17CB07841038A94")

        String what;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.027 -0500", hash_original_field = "C4E3E8F459E3F192A7BA9767B8092770", hash_generated_field = "C4E3E8F459E3F192A7BA9767B8092770")

        String who;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.667 -0400", hash_original_method = "1364E4E916202312196441F2CD1A38A7", hash_generated_method = "1364E4E916202312196441F2CD1A38A7")
        public ContextCleanupInfo ()
        {
            //Synthesized constructor
        }


    }


    
    static final class ProfilerControlData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.029 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.029 -0500", hash_original_field = "ED4BCC0409574E6EB5292B0FF005E3EB", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.667 -0400", hash_original_method = "D11C2D1935BF651482EE891D2A926235", hash_generated_method = "D11C2D1935BF651482EE891D2A926235")
        public ProfilerControlData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class DumpHeapData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.031 -0500", hash_original_field = "4936DBCD90EF1129A7D9F03C4DB55EE0", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.031 -0500", hash_original_field = "ED4BCC0409574E6EB5292B0FF005E3EB", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.669 -0400", hash_original_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F", hash_generated_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F")
        public DumpHeapData ()
        {
            //Synthesized constructor
        }


    }


    
    static final class UpdateCompatibilityData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.033 -0500", hash_original_field = "742D0CCB1EAA4E727F9FCD5430AF1837", hash_generated_field = "742D0CCB1EAA4E727F9FCD5430AF1837")

        String pkg;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.034 -0500", hash_original_field = "F50EE04D1F33A8C52E6957011343491C", hash_generated_field = "F50EE04D1F33A8C52E6957011343491C")

        CompatibilityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.671 -0400", hash_original_method = "20ABF4B3D5332D1381C869593F335293", hash_generated_method = "20ABF4B3D5332D1381C869593F335293")
        public UpdateCompatibilityData ()
        {
            //Synthesized constructor
        }


    }


    
    private class ApplicationThread extends ApplicationThreadNative {

        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.672 -0400", hash_original_method = "1FF8F0D2A8FB58C213C16741C12E71C3", hash_generated_method = "1FF8F0D2A8FB58C213C16741C12E71C3")
        public ApplicationThread ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.043 -0500", hash_original_method = "FEE93A296AD85C197E1C80A7E47B6BFE", hash_generated_method = "764F2267BB0C92BE00075D572A63D28F")
        private void updatePendingConfiguration(Configuration config) {
            synchronized (mPackages) {
                if (mPendingConfiguration == null ||
                        mPendingConfiguration.isOtherSeqNewer(config)) {
                    mPendingConfiguration = config;
                }
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.044 -0500", hash_original_method = "BA274F1A18F5196BF92F19261941182B", hash_generated_method = "CECDBEAABA1ACF4C6FC3438A0D60410D")
        public final void schedulePauseActivity(IBinder token, boolean finished,
                boolean userLeaving, int configChanges) {
            queueOrSendMessage(
                    finished ? H.PAUSE_ACTIVITY_FINISHING : H.PAUSE_ACTIVITY,
                    token,
                    (userLeaving ? 1 : 0),
                    configChanges);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.045 -0500", hash_original_method = "6237E07FCE9BDD69A8A6118FB4C5EAB5", hash_generated_method = "136739FB330841C7035BDC0882AC76BA")
        public final void scheduleStopActivity(IBinder token, boolean showWindow,
                int configChanges) {
           queueOrSendMessage(
                showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                token, 0, configChanges);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.046 -0500", hash_original_method = "07304A552CCDBF618EE7F08FE12E8569", hash_generated_method = "CEB7DBAEC6DBD38EB544BBC91DB7B700")
        public final void scheduleWindowVisibility(IBinder token, boolean showWindow) {
            queueOrSendMessage(
                showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                token);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.047 -0500", hash_original_method = "28F90EA3762C8F9BC8352F7DED192FAC", hash_generated_method = "13A5B3D47A70937CFB0C4E534187FC44")
        public final void scheduleSleeping(IBinder token, boolean sleeping) {
            queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.048 -0500", hash_original_method = "8E946102D354A83096F7BBE33573DD97", hash_generated_method = "A9FB9DF31E065E3A13157593C2A64AB3")
        public final void scheduleResumeActivity(IBinder token, boolean isForward) {
            queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.049 -0500", hash_original_method = "C9516E754F864B61E9DED08AC69D1433", hash_generated_method = "860F32D9A45A6A0A926FC4425748DDAF")
        public final void scheduleSendResult(IBinder token, List<ResultInfo> results) {
            ResultData res = new ResultData();
            res.token = token;
            res.results = results;
            queueOrSendMessage(H.SEND_RESULT, res);
        }

        // we use token to identify this activity without having to send the
        // activity itself back to the activity manager. (matters more with ipc)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.050 -0500", hash_original_method = "A45BCC7C8AC3E4C6E98525A537822FA1", hash_generated_method = "8F581B8DF08879AD596324CA53F7CF3F")
        public final void scheduleLaunchActivity(Intent intent, IBinder token, int ident,
                ActivityInfo info, Configuration curConfig, CompatibilityInfo compatInfo,
                Bundle state, List<ResultInfo> pendingResults,
                List<Intent> pendingNewIntents, boolean notResumed, boolean isForward,
                String profileName, ParcelFileDescriptor profileFd, boolean autoStopProfiler) {
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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.051 -0500", hash_original_method = "7F2AB124E5633740D7D94B2A109EF885", hash_generated_method = "DC0C658EC8291CE9013EE37CEEAE50A5")
        public final void scheduleRelaunchActivity(IBinder token,
                List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
                int configChanges, boolean notResumed, Configuration config) {
            requestRelaunchActivity(token, pendingResults, pendingNewIntents,
                    configChanges, notResumed, config, true);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.051 -0500", hash_original_method = "821027AAA00C536539A4B7071BFFE4C0", hash_generated_method = "DCFEB6B99B7E7AD2043962FDB58A588E")
        public final void scheduleNewIntent(List<Intent> intents, IBinder token) {
            NewIntentData data = new NewIntentData();
            data.intents = intents;
            data.token = token;

            queueOrSendMessage(H.NEW_INTENT, data);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.052 -0500", hash_original_method = "09A2B20C75657E983740D1D57867F853", hash_generated_method = "6AD34B1CAE1F3CFF1569FECE93DD1213")
        public final void scheduleDestroyActivity(IBinder token, boolean finishing,
                int configChanges) {
            queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    configChanges);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.053 -0500", hash_original_method = "F17AEB980BE0F6A4E87F430078BD0B58", hash_generated_method = "63C62A797E31724E389838A68BA08050")
        public final void scheduleReceiver(Intent intent, ActivityInfo info,
                CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras,
                boolean sync) {
            ReceiverData r = new ReceiverData(intent, resultCode, data, extras,
                    sync, false, mAppThread.asBinder());
            r.info = info;
            r.compatInfo = compatInfo;
            queueOrSendMessage(H.RECEIVER, r);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.054 -0500", hash_original_method = "5FA1669C7C775884F96F1A035B24EE01", hash_generated_method = "E6F916131C6F95DEE788A2C3FE607A19")
        public final void scheduleCreateBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo, int backupMode) {
            CreateBackupAgentData d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            d.backupMode = backupMode;

            queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.055 -0500", hash_original_method = "313CE24EB5C5C4A7E872620C7BAF7637", hash_generated_method = "D0CA50FF4E267271EA7357A458FE08A2")
        public final void scheduleDestroyBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo) {
            CreateBackupAgentData d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;

            queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.056 -0500", hash_original_method = "304266FFC85B0A8F15B84D2439555071", hash_generated_method = "3CAF30D9DF1539C89FEC1DA158AD6892")
        public final void scheduleCreateService(IBinder token,
                ServiceInfo info, CompatibilityInfo compatInfo) {
            CreateServiceData s = new CreateServiceData();
            s.token = token;
            s.info = info;
            s.compatInfo = compatInfo;

            queueOrSendMessage(H.CREATE_SERVICE, s);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.057 -0500", hash_original_method = "EC87D949C3428DDE1DD75260E89A91E6", hash_generated_method = "0540C194FF06CE7EE490DEC0D12FDB93")
        public final void scheduleBindService(IBinder token, Intent intent,
                boolean rebind) {
            BindServiceData s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            s.rebind = rebind;

            queueOrSendMessage(H.BIND_SERVICE, s);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.058 -0500", hash_original_method = "267A066D9D2EC1A97646FF118EBD56F3", hash_generated_method = "32490DB5DFC89E0221C206E7C0D592A7")
        public final void scheduleUnbindService(IBinder token, Intent intent) {
            BindServiceData s = new BindServiceData();
            s.token = token;
            s.intent = intent;

            queueOrSendMessage(H.UNBIND_SERVICE, s);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.059 -0500", hash_original_method = "4862A31D82FA9B63D38F69A2AB095DD2", hash_generated_method = "3D3C660CAFBCBD966A3B0F771CE1F668")
        public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
            int flags ,Intent args) {
            ServiceArgsData s = new ServiceArgsData();
            s.token = token;
            s.taskRemoved = taskRemoved;
            s.startId = startId;
            s.flags = flags;
            s.args = args;

            queueOrSendMessage(H.SERVICE_ARGS, s);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.060 -0500", hash_original_method = "1A677B6A32C3D13D1D29F012CCC3FAD3", hash_generated_method = "401E7000D5962EC22B0B838EBA222720")
        public final void scheduleStopService(IBinder token) {
            queueOrSendMessage(H.STOP_SERVICE, token);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.061 -0500", hash_original_method = "7F787E48DA5312BFEADE988209BA97C7", hash_generated_method = "970D0C013FBF9F50370899E080BDF9A9")
        public final void bindApplication(String processName,
                ApplicationInfo appInfo, List<ProviderInfo> providers,
                ComponentName instrumentationName, String profileFile,
                ParcelFileDescriptor profileFd, boolean autoStopProfiler,
                Bundle instrumentationArgs, IInstrumentationWatcher instrumentationWatcher,
                int debugMode, boolean isRestrictedBackupMode, boolean persistent,
                Configuration config, CompatibilityInfo compatInfo,
                Map<String, IBinder> services, Bundle coreSettings) {

            if (services != null) {
                // Setup the service cache in the ServiceManager
                ServiceManager.initServiceCache(services);
            }

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
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.062 -0500", hash_original_method = "8F2CF4412C4F9594CB0F284CDA41289F", hash_generated_method = "EBFF7387630570FAB4A114B8C49A7A49")
        public final void scheduleExit() {
            queueOrSendMessage(H.EXIT_APPLICATION, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.063 -0500", hash_original_method = "B20E9F159FCFB18DA16F9E3A94AEF27F", hash_generated_method = "A48A0AA759B23308C5CBB46731637E6E")
        public final void scheduleSuicide() {
            queueOrSendMessage(H.SUICIDE, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.064 -0500", hash_original_method = "6202A73E0682C5A75E75C022AC3B402A", hash_generated_method = "E5F7203BDC16287B45193DC9E5AB3EAF")
        public void requestThumbnail(IBinder token) {
            queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.064 -0500", hash_original_method = "06772B0545F1E3E199A400C07A7C465B", hash_generated_method = "1C428B7FF53CB77563B0266DC5CD5373")
        public void scheduleConfigurationChanged(Configuration config) {
            updatePendingConfiguration(config);
            queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.066 -0500", hash_original_method = "691E3B4CEF6237A9A1AE3434E3DEDEFF", hash_generated_method = "270B2590F9F4AAF2118B21A599FDE1B0")
        public void updateTimeZone() {
            TimeZone.setDefault(null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.066 -0500", hash_original_method = "38B626EB423003E8CAF0F1407CD9E9A9", hash_generated_method = "2A26B9B44646AB57EC9B9604BE2EC2E5")
        public void clearDnsCache() {
            // a non-standard API to get this to libcore
            InetAddress.clearDnsCache();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.067 -0500", hash_original_method = "B8887413EF343DBD56A367F4C57F614A", hash_generated_method = "F43C73B1104CF338406949FC30940236")
        public void setHttpProxy(String host, String port, String exclList) {
            Proxy.setHttpProxySystemProperty(host, port, exclList);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.068 -0500", hash_original_method = "66F6EAD39814B9A04B7952BBDB099BC9", hash_generated_method = "703A7E8A6D7FA12C2482822965C11FFD")
        public void processInBackground() {
            mH.removeMessages(H.GC_WHEN_IDLE);
            mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.069 -0500", hash_original_method = "876C8E0D071CEA83F82D96AA48344FA4", hash_generated_method = "A733EE0B105326C900C147E87A118702")
        public void dumpService(FileDescriptor fd, IBinder servicetoken, String[] args) {
            DumpComponentInfo data = new DumpComponentInfo();
            try {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = servicetoken;
                data.args = args;
                queueOrSendMessage(H.DUMP_SERVICE, data);
            } catch (IOException e) {
                Slog.w(TAG, "dumpService failed", e);
            }
        }

        // This function exists to make sure all receiver dispatching is
        // correctly ordered, since these are one-way calls and the binder driver
        // applies transaction ordering per object for such calls.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.070 -0500", hash_original_method = "0E238081C4996703A2EA0540C6977CE0", hash_generated_method = "0A830E09EB8505E45EE6B4C525CB4C98")
        public void scheduleRegisteredReceiver(IIntentReceiver receiver, Intent intent,
                int resultCode, String dataStr, Bundle extras, boolean ordered,
                boolean sticky) throws RemoteException {
            receiver.performReceive(intent, resultCode, dataStr, extras, ordered, sticky);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.070 -0500", hash_original_method = "1CA11DE4169634D3536C3A5288820C11", hash_generated_method = "AD1EF6E5062C80B75328B56ACB631FC6")
        public void scheduleLowMemory() {
            queueOrSendMessage(H.LOW_MEMORY, null);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.071 -0500", hash_original_method = "1503BAA815C894047387C37D52FE75DC", hash_generated_method = "0266DE738FFB5BBB4428735BD133AC57")
        public void scheduleActivityConfigurationChanged(IBinder token) {
            queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.072 -0500", hash_original_method = "D92E635329F77F60C61D4CBABCC9E0E5", hash_generated_method = "C21FE0B4A6795DED438B1D1CD56FE20C")
        public void profilerControl(boolean start, String path, ParcelFileDescriptor fd,
                int profileType) {
            ProfilerControlData pcd = new ProfilerControlData();
            pcd.path = path;
            pcd.fd = fd;
            queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.073 -0500", hash_original_method = "E2AA43C341E3E1223DC4327679137F86", hash_generated_method = "0394EC6246BC276A25A96A15378FC014")
        public void dumpHeap(boolean managed, String path, ParcelFileDescriptor fd) {
            DumpHeapData dhd = new DumpHeapData();
            dhd.path = path;
            dhd.fd = fd;
            queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.074 -0500", hash_original_method = "31DFA590CF69650795082863A4038E1E", hash_generated_method = "0797AD09879C786C4C419F6D4346890F")
        public void setSchedulingGroup(int group) {
            // Note: do this immediately, since going into the foreground
            // should happen regardless of what pending work we have to do
            // and the activity manager will wait for us to report back that
            // we are done before sending us to the background.
            try {
                Process.setProcessGroup(Process.myPid(), group);
            } catch (Exception e) {
                Slog.w(TAG, "Failed setting process group to " + group, e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.075 -0500", hash_original_method = "7CB15E6FC063BB1B6B4AEB944EE130EF", hash_generated_method = "B0F10B712EDD59BD97D0FD1F94167165")
        public void getMemoryInfo(Debug.MemoryInfo outInfo) {
            Debug.getMemoryInfo(outInfo);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.075 -0500", hash_original_method = "779EC3818AE8FA9E2AC523D128FB5D87", hash_generated_method = "A39FC27AF6201D9BD9865D8F817CC172")
        public void dispatchPackageBroadcast(int cmd, String[] packages) {
            queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.076 -0500", hash_original_method = "E0613CA49761C406F1CB17CB9D000972", hash_generated_method = "986C4F7EFF4CBB7B83F39A28F7E868DB")
        public void scheduleCrash(String msg) {
            queueOrSendMessage(H.SCHEDULE_CRASH, msg);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.077 -0500", hash_original_method = "D7BE3A9B3D448EC9431A34B711555765", hash_generated_method = "C1F371A36CBFBCD64F60167EA049C32D")
        public void dumpActivity(FileDescriptor fd, IBinder activitytoken,
                String prefix, String[] args) {
            DumpComponentInfo data = new DumpComponentInfo();
            try {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = activitytoken;
                data.prefix = prefix;
                data.args = args;
                queueOrSendMessage(H.DUMP_ACTIVITY, data);
            } catch (IOException e) {
                Slog.w(TAG, "dumpActivity failed", e);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.078 -0500", hash_original_method = "648F3C65CFB469E019D9747F832AE1E8", hash_generated_method = "097B6FD5126F6FF4FEBD96F108EB401A")
        @Override
public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin,
                boolean all, String[] args) {
            FileOutputStream fout = new FileOutputStream(fd);
            PrintWriter pw = new PrintWriter(fout);
            try {
                return dumpMemInfo(pw, checkin, all, args);
            } finally {
                pw.flush();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.082 -0500", hash_original_method = "468180529DE63D6D9E6979D7BD66773F", hash_generated_method = "5C3D8CEE7AC0867B6413FC01125A978C")
        private Debug.MemoryInfo dumpMemInfo(PrintWriter pw, boolean checkin, boolean all,
                String[] args) {
            long nativeMax = Debug.getNativeHeapSize() / 1024;
            long nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeFree = Debug.getNativeHeapFreeSize() / 1024;

            Debug.MemoryInfo memInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memInfo);

            if (!all) {
                return memInfo;
            }

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

            // For checkin, we print one long comma-separated list of values
            if (checkin) {
                // NOTE: if you change anything significant below, also consider changing
                // ACTIVITY_THREAD_CHECKIN_VERSION.
                String processName = (mBoundApplication != null)
                        ? mBoundApplication.processName : "unknown";

                // Header
                pw.print(ACTIVITY_THREAD_CHECKIN_VERSION); pw.print(',');
                pw.print(Process.myPid()); pw.print(',');
                pw.print(processName); pw.print(',');

                // Heap info - max
                pw.print(nativeMax); pw.print(',');
                pw.print(dalvikMax); pw.print(',');
                pw.print("N/A,");
                pw.print(nativeMax + dalvikMax); pw.print(',');

                // Heap info - allocated
                pw.print(nativeAllocated); pw.print(',');
                pw.print(dalvikAllocated); pw.print(',');
                pw.print("N/A,");
                pw.print(nativeAllocated + dalvikAllocated); pw.print(',');

                // Heap info - free
                pw.print(nativeFree); pw.print(',');
                pw.print(dalvikFree); pw.print(',');
                pw.print("N/A,");
                pw.print(nativeFree + dalvikFree); pw.print(',');

                // Heap info - proportional set size
                pw.print(memInfo.nativePss); pw.print(',');
                pw.print(memInfo.dalvikPss); pw.print(',');
                pw.print(memInfo.otherPss); pw.print(',');
                pw.print(memInfo.nativePss + memInfo.dalvikPss + memInfo.otherPss); pw.print(',');

                // Heap info - shared
                pw.print(memInfo.nativeSharedDirty); pw.print(',');
                pw.print(memInfo.dalvikSharedDirty); pw.print(',');
                pw.print(memInfo.otherSharedDirty); pw.print(',');
                pw.print(memInfo.nativeSharedDirty + memInfo.dalvikSharedDirty
                        + memInfo.otherSharedDirty); pw.print(',');

                // Heap info - private
                pw.print(memInfo.nativePrivateDirty); pw.print(',');
                pw.print(memInfo.dalvikPrivateDirty); pw.print(',');
                pw.print(memInfo.otherPrivateDirty); pw.print(',');
                pw.print(memInfo.nativePrivateDirty + memInfo.dalvikPrivateDirty
                        + memInfo.otherPrivateDirty); pw.print(',');

                // Object counts
                pw.print(viewInstanceCount); pw.print(',');
                pw.print(viewRootInstanceCount); pw.print(',');
                pw.print(appContextInstanceCount); pw.print(',');
                pw.print(activityInstanceCount); pw.print(',');

                pw.print(globalAssetCount); pw.print(',');
                pw.print(globalAssetManagerCount); pw.print(',');
                pw.print(binderLocalObjectCount); pw.print(',');
                pw.print(binderProxyObjectCount); pw.print(',');

                pw.print(binderDeathObjectCount); pw.print(',');
                pw.print(openSslSocketCount); pw.print(',');

                // SQL
                pw.print(sqliteAllocated); pw.print(',');
                pw.print(stats.memoryUsed / 1024); pw.print(',');
                pw.print(stats.pageCacheOverflo / 1024); pw.print(',');
                pw.print(stats.largestMemAlloc / 1024);
                for (int i = 0; i < stats.dbStats.size(); i++) {
                    DbStats dbStats = stats.dbStats.get(i);
                    pw.print(','); pw.print(dbStats.dbName);
                    pw.print(','); pw.print(dbStats.pageSize);
                    pw.print(','); pw.print(dbStats.dbSize);
                    pw.print(','); pw.print(dbStats.lookaside);
                    pw.print(','); pw.print(dbStats.cache);
                    pw.print(','); pw.print(dbStats.cache);
                }
                pw.println();

                return memInfo;
            }

            // otherwise, show human-readable format
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

            for (int i=0; i<Debug.MemoryInfo.NUM_OTHER_STATS; i++) {
                printRow(pw, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i),
                        memInfo.getOtherPss(i), memInfo.getOtherSharedDirty(i),
                        memInfo.getOtherPrivateDirty(i), "", "", "");
                otherPss -= memInfo.getOtherPss(i);
                otherSharedDirty -= memInfo.getOtherSharedDirty(i);
                otherPrivateDirty -= memInfo.getOtherPrivateDirty(i);
            }

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

            // SQLite mem info
            pw.println(" ");
            pw.println(" SQL");
            printRow(pw, TWO_COUNT_COLUMNS_DB, "heap:", sqliteAllocated, "MEMORY_USED:",
                    stats.memoryUsed / 1024);
            printRow(pw, TWO_COUNT_COLUMNS_DB, "PAGECACHE_OVERFLOW:",
                    stats.pageCacheOverflo / 1024, "MALLOC_SIZE:", stats.largestMemAlloc / 1024);
            pw.println(" ");
            int N = stats.dbStats.size();
            if (N > 0) {
                pw.println(" DATABASES");
                printRow(pw, "  %8s %8s %14s %14s  %s", "pgsz", "dbsz", "Lookaside(b)", "cache",
                        "Dbname");
                for (int i = 0; i < N; i++) {
                    DbStats dbStats = stats.dbStats.get(i);
                    printRow(pw, DB_INFO_FORMAT,
                            (dbStats.pageSize > 0) ? String.valueOf(dbStats.pageSize) : " ",
                            (dbStats.dbSize > 0) ? String.valueOf(dbStats.dbSize) : " ",
                            (dbStats.lookaside > 0) ? String.valueOf(dbStats.lookaside) : " ",
                            dbStats.cache, dbStats.dbName);
                }
            }

            // Asset details.
            String assetAlloc = AssetManager.getAssetAllocations();
            if (assetAlloc != null) {
                pw.println(" ");
                pw.println(" Asset Allocations");
                pw.print(assetAlloc);
            }

            return memInfo;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.083 -0500", hash_original_method = "DBE19F37C980DCB637B8E3CCE0C6D7AE", hash_generated_method = "2C1C331A8A8049F89316ACCD2681AC35")
        @Override
public void dumpGfxInfo(FileDescriptor fd, String[] args) {
            dumpGraphicsInfo(fd);
            WindowManagerImpl.getDefault().dumpGfxInfo(fd);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.084 -0500", hash_original_method = "E9FD23CC6BA5457F811332501D367E07", hash_generated_method = "D02D5534BE5FBEA084135F978C132B9D")
        private void printRow(PrintWriter pw, String format, Object...objs) {
            pw.println(String.format(format, objs));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.084 -0500", hash_original_method = "5D81A3C132332FC039C36D652A159D52", hash_generated_method = "6493D12C56A79B55F65A864AF7FA3F0F")
        public void setCoreSettings(Bundle coreSettings) {
            queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.085 -0500", hash_original_method = "915F19E7DF7511DDBDEE0EA8781AD484", hash_generated_method = "5927164F8C1EFAE44EA171BAA2DA63E2")
        public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) {
            UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            ucd.pkg = pkg;
            ucd.info = info;
            queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.086 -0500", hash_original_method = "713723E30DD42F550C53D06876722D4F", hash_generated_method = "C7B59837B13DF5130E3F47E17276BDE4")
        public void scheduleTrimMemory(int level) {
            queueOrSendMessage(H.TRIM_MEMORY, null, level);
        }
    }


    
    private class H extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.091 -0500", hash_original_field = "AF264778B48C978F11E0767D955E26A0", hash_generated_field = "79EE3E0E74CCDF8DA485137663462447")

        public static final int LAUNCH_ACTIVITY         = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.092 -0500", hash_original_field = "D6B41CFBEAF30E7CA72AC93792E25A7E", hash_generated_field = "F6E6C101887932ADB1F39FD5B86A118E")

        public static final int PAUSE_ACTIVITY          = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.093 -0500", hash_original_field = "72237C7ED7D295FE134EC1D64B483598", hash_generated_field = "09D07137EA5653F1E891575A10F54C95")

        public static final int PAUSE_ACTIVITY_FINISHING= 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.093 -0500", hash_original_field = "5A8B4F5419D56F71FF53490C36861E2F", hash_generated_field = "EC045D213E7DCC46FAC0B6AAED7E85D6")

        public static final int STOP_ACTIVITY_SHOW      = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.094 -0500", hash_original_field = "B6032C37519E217DD5EB964CBF4BF004", hash_generated_field = "25971E3B508C10EDB2E29C96206F822B")

        public static final int STOP_ACTIVITY_HIDE      = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.095 -0500", hash_original_field = "3751A5BB4ECD92E7F09F174D9D309541", hash_generated_field = "0FBE2B02A08E08DD92AF03DD97DDA5AE")

        public static final int SHOW_WINDOW             = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.096 -0500", hash_original_field = "4DE84EB4313270B146703294F378B803", hash_generated_field = "B048EDF2C316D4329B5527B43CEDFE50")

        public static final int HIDE_WINDOW             = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.097 -0500", hash_original_field = "D5FA8BA9E8BB5DEC62230359DE860928", hash_generated_field = "D40012091267201A48CEA7D4C55C1620")

        public static final int RESUME_ACTIVITY         = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.098 -0500", hash_original_field = "76B614BD280EDEADDFC8444AEE321E0B", hash_generated_field = "A40A106C973F0FB170D2DAC3448C5A13")

        public static final int SEND_RESULT             = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.099 -0500", hash_original_field = "03C4509F60C52A55C3F3C70C37F62FCD", hash_generated_field = "F3C8D3955BE8F2810694F3E7013C556E")

        public static final int DESTROY_ACTIVITY        = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.100 -0500", hash_original_field = "A16D39DDE7DA20CCEF92F5DE1B115BD9", hash_generated_field = "9E021100AE53B786AFAD15A16329BAB4")

        public static final int BIND_APPLICATION        = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.101 -0500", hash_original_field = "52497C25FE1D4A76416C1BF6AACC04E7", hash_generated_field = "D9A851E248DD3DA74E867B25E117FD22")

        public static final int EXIT_APPLICATION        = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.102 -0500", hash_original_field = "07F5C9F06D42948D68986F09155B36C9", hash_generated_field = "E81354CA5082AEBC39D8C31B119790DD")

        public static final int NEW_INTENT              = 112;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.103 -0500", hash_original_field = "1884D065E2FA56A2CB93A391253D7346", hash_generated_field = "BC2E16123EEC2C2FE2146178A6F6EBE7")

        public static final int RECEIVER                = 113;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.103 -0500", hash_original_field = "03FB4974373248F5B289712CB629C56B", hash_generated_field = "46F82A63643EBF3740DA044A97C411BD")

        public static final int CREATE_SERVICE          = 114;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.104 -0500", hash_original_field = "0575B516D0145A6C2699ED083CEC76B2", hash_generated_field = "A20CACB6EB007BA6D6D1EAE18B100F96")

        public static final int SERVICE_ARGS            = 115;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.105 -0500", hash_original_field = "DE186A58998D71DE527ECBAC422B1E78", hash_generated_field = "AB975960BB4220B2FCB171489C6584C5")

        public static final int STOP_SERVICE            = 116;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.106 -0500", hash_original_field = "6345FF9B1DD0AC325C4C97F240BC5665", hash_generated_field = "DA58382979407C0DCE4E024C9F856907")

        public static final int REQUEST_THUMBNAIL       = 117;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.107 -0500", hash_original_field = "DFB288C285DBF02F20C7274EE33E921F", hash_generated_field = "F8782D86E0C72BFCA118C31A420D9DB2")

        public static final int CONFIGURATION_CHANGED   = 118;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.108 -0500", hash_original_field = "92EDC511C757661CF34D4F8A7B5FA892", hash_generated_field = "203638C0D401316316F231069A439983")

        public static final int CLEAN_UP_CONTEXT        = 119;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.109 -0500", hash_original_field = "0D9D4A67EB0BABDD1FAC9A7B79D69390", hash_generated_field = "7FDF10F5D0B32576CCE522E8063EE1AB")

        public static final int GC_WHEN_IDLE            = 120;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.110 -0500", hash_original_field = "99E9AEF8B044B254A7A482E10C6ACCE5", hash_generated_field = "FA82AB4CAC5570F743636186326BBBCB")

        public static final int BIND_SERVICE            = 121;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.111 -0500", hash_original_field = "A1444432BFAEE0E74F4C18B0918A81EF", hash_generated_field = "3AA49274B99CB4754DE7AAC22A64097B")

        public static final int UNBIND_SERVICE          = 122;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.112 -0500", hash_original_field = "6629059B6F0229EEA91DC681A406714A", hash_generated_field = "BE57D55C848AF78B6D13D08C75CD3890")

        public static final int DUMP_SERVICE            = 123;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.113 -0500", hash_original_field = "F11E8E4CC44D50AB9F1E1BE8974F5CCA", hash_generated_field = "016852C1459DE34F8D1BECDF172A7A3B")

        public static final int LOW_MEMORY              = 124;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.113 -0500", hash_original_field = "291CFB1E684C5354376EB1ADC56D20D3", hash_generated_field = "C1874358A5069FBBE942CA7B4FEB06AC")

        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.114 -0500", hash_original_field = "6EF0673B8AF75C7B8B2C3E4BB0FA82D2", hash_generated_field = "F66CB5E4AB6DEA952AC6C4AC4FD8129C")

        public static final int RELAUNCH_ACTIVITY       = 126;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.115 -0500", hash_original_field = "F8EFA5AD9206E2638A3F257E60A0EFA3", hash_generated_field = "B3A767EE70C05E487D7B390CB511DE9C")

        public static final int PROFILER_CONTROL        = 127;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.116 -0500", hash_original_field = "3F42C19E2A808A8FAC27D682CED248AD", hash_generated_field = "385AB826C3B946556BB8D2BA1F6167CB")

        public static final int CREATE_BACKUP_AGENT     = 128;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.117 -0500", hash_original_field = "F65FDD9BE64B560D7A129A2D9919EB61", hash_generated_field = "72995E16D3DBD2A4679635D4E61FC49D")

        public static final int DESTROY_BACKUP_AGENT    = 129;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.117 -0500", hash_original_field = "122142D6DA80A44AEB8AD354CFF8C8AF", hash_generated_field = "2E6A83D9FB3FCAFBC6EA64132F417F75")

        public static final int SUICIDE                 = 130;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.118 -0500", hash_original_field = "80939164681722D20D82CCE34115482E", hash_generated_field = "7DBF1A92BA0E6AA87182CD56B3D107E3")

        public static final int REMOVE_PROVIDER         = 131;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.119 -0500", hash_original_field = "903CB45D27A5E5085A803D1214AF4024", hash_generated_field = "AA41E7437D6E941DE853C39868725DE4")

        public static final int ENABLE_JIT              = 132;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.120 -0500", hash_original_field = "1C354A5A5416F34CA69C2A7627A3A3EE", hash_generated_field = "77AEBFDF31780CFDC843B8D9EAB26B65")

        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.121 -0500", hash_original_field = "757C1A0630E829D748DF5B9949D70E12", hash_generated_field = "2F79168F541635B32A56D3A800568EB5")

        public static final int SCHEDULE_CRASH          = 134;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.122 -0500", hash_original_field = "60835E24E3A75F57FFC35C080E998898", hash_generated_field = "AE9A74DBF18BA76BECBDADA426FDD8D1")

        public static final int DUMP_HEAP               = 135;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.122 -0500", hash_original_field = "D096636DD6FE93B960F662C833298782", hash_generated_field = "2312CB238555E0BCB137FC118844BDC3")

        public static final int DUMP_ACTIVITY           = 136;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.123 -0500", hash_original_field = "E495D8C65BECA460C958B1AFD5388498", hash_generated_field = "4EAC68079DDB116BDF58C13AC47AF396")

        public static final int SLEEPING                = 137;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.125 -0500", hash_original_field = "AF898272425A5BEDF33D6BA98FF3C4C4", hash_generated_field = "7CA400DE0EBC79FF2A4805A342BE87B5")

        public static final int SET_CORE_SETTINGS       = 138;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.126 -0500", hash_original_field = "A465BE762105E744FFC0B8CDF8CC0533", hash_generated_field = "CFEBE5355040D28519CBFFA29E96E50F")

        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.127 -0500", hash_original_field = "9780845177943FAF63493E2EDE358282", hash_generated_field = "CF745352D226FFB32A7FEB6BFD662619")

        public static final int TRIM_MEMORY             = 140;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.783 -0400", hash_original_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5", hash_generated_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5")
        public H ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.128 -0500", hash_original_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C", hash_generated_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C")
        String codeToString(int code) {
            if (DEBUG_MESSAGES) {
                switch (code) {
                    case LAUNCH_ACTIVITY: return "LAUNCH_ACTIVITY";
                    case PAUSE_ACTIVITY: return "PAUSE_ACTIVITY";
                    case PAUSE_ACTIVITY_FINISHING: return "PAUSE_ACTIVITY_FINISHING";
                    case STOP_ACTIVITY_SHOW: return "STOP_ACTIVITY_SHOW";
                    case STOP_ACTIVITY_HIDE: return "STOP_ACTIVITY_HIDE";
                    case SHOW_WINDOW: return "SHOW_WINDOW";
                    case HIDE_WINDOW: return "HIDE_WINDOW";
                    case RESUME_ACTIVITY: return "RESUME_ACTIVITY";
                    case SEND_RESULT: return "SEND_RESULT";
                    case DESTROY_ACTIVITY: return "DESTROY_ACTIVITY";
                    case BIND_APPLICATION: return "BIND_APPLICATION";
                    case EXIT_APPLICATION: return "EXIT_APPLICATION";
                    case NEW_INTENT: return "NEW_INTENT";
                    case RECEIVER: return "RECEIVER";
                    case CREATE_SERVICE: return "CREATE_SERVICE";
                    case SERVICE_ARGS: return "SERVICE_ARGS";
                    case STOP_SERVICE: return "STOP_SERVICE";
                    case REQUEST_THUMBNAIL: return "REQUEST_THUMBNAIL";
                    case CONFIGURATION_CHANGED: return "CONFIGURATION_CHANGED";
                    case CLEAN_UP_CONTEXT: return "CLEAN_UP_CONTEXT";
                    case GC_WHEN_IDLE: return "GC_WHEN_IDLE";
                    case BIND_SERVICE: return "BIND_SERVICE";
                    case UNBIND_SERVICE: return "UNBIND_SERVICE";
                    case DUMP_SERVICE: return "DUMP_SERVICE";
                    case LOW_MEMORY: return "LOW_MEMORY";
                    case ACTIVITY_CONFIGURATION_CHANGED: return "ACTIVITY_CONFIGURATION_CHANGED";
                    case RELAUNCH_ACTIVITY: return "RELAUNCH_ACTIVITY";
                    case PROFILER_CONTROL: return "PROFILER_CONTROL";
                    case CREATE_BACKUP_AGENT: return "CREATE_BACKUP_AGENT";
                    case DESTROY_BACKUP_AGENT: return "DESTROY_BACKUP_AGENT";
                    case SUICIDE: return "SUICIDE";
                    case REMOVE_PROVIDER: return "REMOVE_PROVIDER";
                    case ENABLE_JIT: return "ENABLE_JIT";
                    case DISPATCH_PACKAGE_BROADCAST: return "DISPATCH_PACKAGE_BROADCAST";
                    case SCHEDULE_CRASH: return "SCHEDULE_CRASH";
                    case DUMP_HEAP: return "DUMP_HEAP";
                    case DUMP_ACTIVITY: return "DUMP_ACTIVITY";
                    case SLEEPING: return "SLEEPING";
                    case SET_CORE_SETTINGS: return "SET_CORE_SETTINGS";
                    case UPDATE_PACKAGE_COMPATIBILITY_INFO: return "UPDATE_PACKAGE_COMPATIBILITY_INFO";
                    case TRIM_MEMORY: return "TRIM_MEMORY";
                }
            }
            return "(unknown)";
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.130 -0500", hash_original_method = "DC9C3E5B703CFDFA18C27F800AA1CA40", hash_generated_method = "9160A9FD77CE7966181670D62A44FC6B")
        public void handleMessage(Message msg) {
            if (DEBUG_MESSAGES) Slog.v(TAG, ">>> handling: " + msg.what);
            switch (msg.what) {
                case LAUNCH_ACTIVITY: {
                    ActivityClientRecord r = (ActivityClientRecord)msg.obj;

                    r.packageInfo = getPackageInfoNoCheck(
                            r.activityInfo.applicationInfo, r.compatInfo);
                    handleLaunchActivity(r, null);
                } break;
                case RELAUNCH_ACTIVITY: {
                    ActivityClientRecord r = (ActivityClientRecord)msg.obj;
                    handleRelaunchActivity(r);
                } break;
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
                    if (mInitialApplication != null) {
                        mInitialApplication.onTerminate();
                    }
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
                    throw new RemoteServiceException((String)msg.obj);
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
            }
            if (DEBUG_MESSAGES) Slog.v(TAG, "<<< done: " + msg.what);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.131 -0500", hash_original_method = "E92E43C77FF76A1843097A49ADA7442E", hash_generated_method = "AE508D3B29F23CB661DCFD7316261178")
        private void maybeSnapshot() {
            if (mBoundApplication != null && SamplingProfilerIntegration.isEnabled()) {
                // convert the *private* ActivityThread.PackageInfo to *public* known
                // android.content.pm.PackageInfo
                String packageName = mBoundApplication.info.mPackageName;
                android.content.pm.PackageInfo packageInfo = null;
                try {
                    Context context = getSystemContext();
                    if(context == null) {
                        Log.e(TAG, "cannot get a valid context");
                        return;
                    }
                    PackageManager pm = context.getPackageManager();
                    if(pm == null) {
                        Log.e(TAG, "cannot get a valid PackageManager");
                        return;
                    }
                    packageInfo = pm.getPackageInfo(
                            packageName, PackageManager.GET_ACTIVITIES);
                } catch (NameNotFoundException e) {
                    Log.e(TAG, "cannot get package info for " + packageName, e);
                }
                SamplingProfilerIntegration.writeSnapshot(mBoundApplication.processName, packageInfo);
            }
        }
    }


    
    private class Idler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.822 -0400", hash_original_method = "33AE74878CEBE3B527FC27BCFED9133E", hash_generated_method = "33AE74878CEBE3B527FC27BCFED9133E")
        public Idler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.134 -0500", hash_original_method = "7124AFC3D8D2CB12FD15B850DC795363", hash_generated_method = "A2FC0AB699BC787AB46809FA3C6A2EA4")
        public final boolean queueIdle() {
            ActivityClientRecord a = mNewActivities;
            boolean stopProfiling = false;
            if (mBoundApplication != null && mProfiler.profileFd != null
                    && mProfiler.autoStopProfiler) {
                stopProfiling = true;
            }
            if (a != null) {
                mNewActivities = null;
                IActivityManager am = ActivityManagerNative.getDefault();
                ActivityClientRecord prev;
                do {
                    if (localLOGV) Slog.v(
                        TAG, "Reporting idle of " + a +
                        " finished=" +
                        (a.activity != null && a.activity.mFinished));
                    if (a.activity != null && !a.activity.mFinished) {
                        try {
                            am.activityIdle(a.token, a.createdConfig, stopProfiling);
                            a.createdConfig = null;
                        } catch (RemoteException ex) {
                            // Ignore
                        }
                    }
                    prev = a;
                    a = a.nextIdle;
                    prev.nextIdle = null;
                } while (a != null);
            }
            if (stopProfiling) {
                mProfiler.stopProfiling();
            }
            ensureJitEnabled();
            return false;
        }

        
    }


    
    final class GcIdler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.828 -0400", hash_original_method = "ABBE7DCE196E12604C1E7133F511F6FC", hash_generated_method = "ABBE7DCE196E12604C1E7133F511F6FC")
        public GcIdler ()
        {
            //Synthesized constructor
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.136 -0500", hash_original_method = "44179B8732E18ADC2B8565E550483147", hash_generated_method = "231B9270AD2D5B1CE3116A37BB521F9D")
        public final boolean queueIdle() {
            doGcIfNeeded();
            return false;
        }

        
    }


    
    private static class ResourcesKey {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.138 -0500", hash_original_field = "9CBFFC74B2E8DB2A6DFAD2C0D7303627", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

         private String mResDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.139 -0500", hash_original_field = "ABDB0A4470BBD1454ED388F3CD972EEE", hash_generated_field = "8561DC852E8BD04B40EFBC1F32D92895")

         private float mScale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.140 -0500", hash_original_field = "75C696D792F4D964D02FC041ACD59004", hash_generated_field = "A7D12DAC99918DD08DC20BE8E0E23E1B")

         private int mHash;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.141 -0500", hash_original_method = "0A249A0E32348D1ED1AC3A6D16406BEA", hash_generated_method = "0A249A0E32348D1ED1AC3A6D16406BEA")
        ResourcesKey(String resDir, float scale) {
            mResDir = resDir;
            mScale = scale;
            mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.142 -0500", hash_original_method = "FDD99B6C6105A3F31D8E7DC9390101DA", hash_generated_method = "52ADCB97A75DD9EE7D1911F0EC324C95")
        @Override
public int hashCode() {
            return mHash;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.143 -0500", hash_original_method = "07DFB89699884113D8C2B96163B07C7F", hash_generated_method = "2B2A2B58F0DC0C8CAF315EBCE035393F")
        @Override
public boolean equals(Object obj) {
            if (!(obj instanceof ResourcesKey)) {
                return false;
            }
            ResourcesKey peer = (ResourcesKey) obj;
            return mResDir.equals(peer.mResDir) && mScale == peer.mScale;
        }

        
    }


    
    private static class StopInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.210 -0500", hash_original_field = "671EE8F19CE89CCA3E5285825682D0E2", hash_generated_field = "671EE8F19CE89CCA3E5285825682D0E2")

        Bitmap thumbnail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.211 -0500", hash_original_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB", hash_generated_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB")

        CharSequence description;
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.837 -0400", hash_original_method = "59EF1C21B91F2644F32BF61E1E80BB9E", hash_generated_method = "59EF1C21B91F2644F32BF61E1E80BB9E")
        public StopInfo ()
        {
            //Synthesized constructor
        }


    }


    
    private static final class ProviderRefCount {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.213 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.214 -0500", hash_original_method = "92B7A170BA9BC140C9702B48E38F46E8", hash_generated_method = "92B7A170BA9BC140C9702B48E38F46E8")
        ProviderRefCount(int pCount) {
            count = pCount;
        }

        
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.241 -0500", hash_original_method = "381D38D2D5D4A7D408E3117408C36DEC", hash_generated_method = "C2012EB66E65E1A81BF92569D1A38680")
    final void handleProfilerControl(boolean start, ProfilerControlData pcd, int profileType) {
        if (start) {
            try {
                switch (profileType) {
                    case 1:
                        ViewDebug.startLooperProfiling(pcd.path, pcd.fd.getFileDescriptor());
                        break;
                    default:                        
                        mProfiler.setProfiler(pcd.path, pcd.fd);
                        mProfiler.autoStopProfiler = false;
                        mProfiler.startProfiling();
                        break;
                }
            } catch (RuntimeException e) {
                Slog.w(TAG, "Profiling failed on path " + pcd.path
                        + " -- can the process access this path?");
            } finally {
                try {
                    pcd.fd.close();
                } catch (IOException e) {
                    Slog.w(TAG, "Failure closing profile fd", e);
                }
            }
        } else {
            switch (profileType) {
                case 1:
                    ViewDebug.stopLooperProfiling();
                    break;
                default:
                    mProfiler.stopProfiling();
                    break;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.242 -0500", hash_original_method = "34F4499A4B96EEF8A91ACC379A0CD361", hash_generated_method = "DD5256DB5973BAB7D0FE901BD8B95312")
    final void handleDumpHeap(boolean managed, DumpHeapData dhd) {
        if (managed) {
            try {
                Debug.dumpHprofData(dhd.path, dhd.fd.getFileDescriptor());
            } catch (IOException e) {
                Slog.w(TAG, "Managed heap dump failed on path " + dhd.path
                        + " -- can the process access this path?");
            } finally {
                try {
                    dhd.fd.close();
                } catch (IOException e) {
                    Slog.w(TAG, "Failure closing profile fd", e);
                }
            }
        } else {
            Debug.dumpNativeHeap(dhd.fd.getFileDescriptor());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.243 -0500", hash_original_method = "44425A5A4DA98E1612A84EA820E43FA0", hash_generated_method = "C69BD05F303EB4D52915E0F3884668C8")
    final void handleDispatchPackageBroadcast(int cmd, String[] packages) {
        boolean hasPkgInfo = false;
        if (packages != null) {
            for (int i=packages.length-1; i>=0; i--) {
                //Slog.i(TAG, "Cleaning old package: " + packages[i]);
                if (!hasPkgInfo) {
                    WeakReference<LoadedApk> ref;
                    ref = mPackages.get(packages[i]);
                    if (ref != null && ref.get() != null) {
                        hasPkgInfo = true;
                    } else {
                        ref = mResourcePackages.get(packages[i]);
                        if (ref != null && ref.get() != null) {
                            hasPkgInfo = true;
                        }
                    }
                }
                mPackages.remove(packages[i]);
                mResourcePackages.remove(packages[i]);
            }
        }
        ApplicationPackageManager.handlePackageBroadcast(cmd, packages,
                hasPkgInfo);
    }
        
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.244 -0500", hash_original_method = "A02231B2047F154A7A69F70A3ED846FE", hash_generated_method = "687602486DDFE010AC52163539B4AE50")
    final void handleLowMemory() {
        ArrayList<ComponentCallbacks2> callbacks;

        synchronized (mPackages) {
            callbacks = collectComponentCallbacksLocked(true, null);
        }

        final int N = callbacks.size();
        for (int i=0; i<N; i++) {
            callbacks.get(i).onLowMemory();
        }

        // Ask SQLite to free up as much memory as it can, mostly from its page caches.
        if (Process.myUid() != Process.SYSTEM_UID) {
            int sqliteReleased = SQLiteDatabase.releaseMemory();
            EventLog.writeEvent(SQLITE_MEM_RELEASED_EVENT_LOG_TAG, sqliteReleased);
        }

        // Ask graphics to free up as much as possible (font/image caches)
        Canvas.freeCaches();

        BinderInternal.forceGc("mem");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.245 -0500", hash_original_method = "23BC0760ADA981D880A84DB7A1CF33BD", hash_generated_method = "2A8E30353D19E32782BEC4C9D3EE0044")
    final void handleTrimMemory(int level) {
        WindowManagerImpl.getDefault().trimMemory(level);
        ArrayList<ComponentCallbacks2> callbacks;

        synchronized (mPackages) {
            callbacks = collectComponentCallbacksLocked(true, null);
        }

        final int N = callbacks.size();
        for (int i=0; i<N; i++) {
            callbacks.get(i).onTrimMemory(level);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.245 -0500", hash_original_method = "E6BF73423380262DF6FF59682ACDE1E2", hash_generated_method = "0A6C19CF1DC3D311110210CC9B9422DF")
    private void setupGraphicsSupport(LoadedApk info) {
        try {
            int uid = Process.myUid();
            String[] packages = getPackageManager().getPackagesForUid(uid);

            // If there are several packages in this application we won't
            // initialize the graphics disk caches 
            if (packages.length == 1) {
                ContextImpl appContext = new ContextImpl();
                appContext.init(info, null, this);

                HardwareRenderer.setupDiskCache(appContext.getCacheDir());
            }
        } catch (RemoteException e) {
            // Ignore
        }
    }    
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.248 -0500", hash_original_method = "7EBE3C125D399FC9ADE021947462EA9C", hash_generated_method = "E5818DE033E74CF986E0DC590833683F")
    private void handleBindApplication(AppBindData data) {
        mBoundApplication = data;
        mConfiguration = new Configuration(data.config);
        mCompatConfiguration = new Configuration(data.config);

        mProfiler = new Profiler();
        mProfiler.profileFile = data.initProfileFile;
        mProfiler.profileFd = data.initProfileFd;
        mProfiler.autoStopProfiler = data.initAutoStopProfiler;

        // send up app name; do this *before* waiting for debugger
        Process.setArgV0(data.processName);
        android.ddm.DdmHandleAppName.setAppName(data.processName);

        if (data.persistent) {
            // Persistent processes on low-memory devices do not get to
            // use hardware accelerated drawing, since this can add too much
            // overhead to the process.
            Display display = WindowManagerImpl.getDefault().getDefaultDisplay();
            if (!ActivityManager.isHighEndGfx(display)) {
                HardwareRenderer.disable(false);
            }
        }
        
        if (mProfiler.profileFd != null) {
            mProfiler.startProfiling();
        }

        // If the app is Honeycomb MR1 or earlier, switch its AsyncTask
        // implementation to use the pool executor.  Normally, we use the
        // serialized executor as the default. This has to happen in the
        // main thread so the main looper is set right.
        if (data.appInfo.targetSdkVersion <= 12) {
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        }

        /*
         * Before spawning a new process, reset the time zone to be the system time zone.
         * This needs to be done because the system time zone could have changed after the
         * the spawning of this process. Without doing this this process would have the incorrect
         * system time zone.
         */
        TimeZone.setDefault(null);

        /*
         * Initialize the default locale in this process for the reasons we set the time zone.
         */
        Locale.setDefault(data.config.locale);

        /*
         * Update the system configuration since its preloaded and might not
         * reflect configuration changes. The configuration object passed
         * in AppBindData can be safely assumed to be up to date
         */
        applyConfigurationToResourcesLocked(data.config, data.compatInfo);
        applyCompatConfiguration();

        data.info = getPackageInfoNoCheck(data.appInfo, data.compatInfo);

        setupGraphicsSupport(data.info);        
        
        /**
         * For system applications on userdebug/eng builds, log stack
         * traces of disk and network access to dropbox for analysis.
         */
        if ((data.appInfo.flags &
             (ApplicationInfo.FLAG_SYSTEM |
              ApplicationInfo.FLAG_UPDATED_SYSTEM_APP)) != 0) {
            StrictMode.conditionallyEnableDebugLogging();
        }

        /**
         * For apps targetting SDK Honeycomb or later, we don't allow
         * network usage on the main event loop / UI thread.
         *
         * Note to those grepping:  this is what ultimately throws
         * NetworkOnMainThreadException ...
         */
        if (data.appInfo.targetSdkVersion > 9) {
            StrictMode.enableDeathOnNetwork();
        }

        /**
         * Switch this process to density compatibility mode if needed.
         */
        if ((data.appInfo.flags&ApplicationInfo.FLAG_SUPPORTS_SCREEN_DENSITIES)
                == 0) {
            Bitmap.setDefaultDensity(DisplayMetrics.DENSITY_DEFAULT);
        }

        if (data.debugMode != IApplicationThread.DEBUG_OFF) {
            // XXX should have option to change the port.
            Debug.changeDebugPort(8100);
            if (data.debugMode == IApplicationThread.DEBUG_WAIT) {
                Slog.w(TAG, "Application " + data.info.getPackageName()
                      + " is waiting for the debugger on port 8100...");

                IActivityManager mgr = ActivityManagerNative.getDefault();
                try {
                    mgr.showWaitingForDebugger(mAppThread, true);
                } catch (RemoteException ex) {
                }

                Debug.waitForDebugger();

                try {
                    mgr.showWaitingForDebugger(mAppThread, false);
                } catch (RemoteException ex) {
                }

            } else {
                Slog.w(TAG, "Application " + data.info.getPackageName()
                      + " can be debugged on port 8100...");
            }
        }

        /**
         * Initialize the default http proxy in this process for the reasons we set the time zone.
         */
        IBinder b = ServiceManager.getService(Context.CONNECTIVITY_SERVICE);
        if (b != null) {
            // In pre-boot mode (doing initial launch to collect password), not
            // all system is up.  This includes the connectivity service, so don't
            // crash if we can't get it.
            IConnectivityManager service = IConnectivityManager.Stub.asInterface(b);
            try {
                ProxyProperties proxyProperties = service.getProxy();
                Proxy.setHttpProxySystemProperty(proxyProperties);
            } catch (RemoteException e) {}
        }

        if (data.instrumentationName != null) {
            ContextImpl appContext = new ContextImpl();
            appContext.init(data.info, null, this);
            InstrumentationInfo ii = null;
            try {
                ii = appContext.getPackageManager().
                    getInstrumentationInfo(data.instrumentationName, 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
            if (ii == null) {
                throw new RuntimeException(
                    "Unable to find instrumentation info for: "
                    + data.instrumentationName);
            }

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

            try {
                java.lang.ClassLoader cl = instrContext.getClassLoader();
                mInstrumentation = (Instrumentation)
                    cl.loadClass(data.instrumentationName.getClassName()).newInstance();
            } catch (Exception e) {
                throw new RuntimeException(
                    "Unable to instantiate instrumentation "
                    + data.instrumentationName + ": " + e.toString(), e);
            }

            mInstrumentation.init(this, instrContext, appContext,
                    new ComponentName(ii.packageName, ii.name), data.instrumentationWatcher);

            if (mProfiler.profileFile != null && !ii.handleProfiling
                    && mProfiler.profileFd == null) {
                mProfiler.handlingProfiling = true;
                File file = new File(mProfiler.profileFile);
                file.getParentFile().mkdirs();
                Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
            }

            try {
                mInstrumentation.onCreate(data.instrumentationArgs);
            }
            catch (Exception e) {
                throw new RuntimeException(
                    "Exception thrown in onCreate() of "
                    + data.instrumentationName + ": " + e.toString(), e);
            }

        } else {
            mInstrumentation = new Instrumentation();
        }

        if ((data.appInfo.flags&ApplicationInfo.FLAG_LARGE_HEAP) != 0) {
            dalvik.system.VMRuntime.getRuntime().clearGrowthLimit();
        }

        // If the app is being launched for full backup or restore, bring it up in
        // a restricted environment with the base application class.
        Application app = data.info.makeApplication(data.restrictedBackupMode, null);
        mInitialApplication = app;

        // don't bring up providers in restricted mode; they may depend on the
        // app's custom Application class
        if (!data.restrictedBackupMode){ 
            List<ProviderInfo> providers = data.providers;
            if (providers != null) {
                installContentProviders(app, providers);
                // For process that contains content providers, we want to
                // ensure that the JIT is enabled "at some point".
                mH.sendEmptyMessageDelayed(H.ENABLE_JIT, 10*1000);
            }
        }

        try {
            mInstrumentation.callApplicationOnCreate(app);
        } catch (Exception e) {
            if (!mInstrumentation.onException(app, e)) {
                throw new RuntimeException(
                    "Unable to create application " + app.getClass().getName()
                    + ": " + e.toString(), e);
            }
        }
    }

    /*package*/ @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.249 -0500", hash_original_method = "87522E170C98EEC17A950D0CB0F18A7D", hash_generated_method = "5C4EE7DACB325B565457E9D35D3160DD")
    final void finishInstrumentation(int resultCode, Bundle results) {
        IActivityManager am = ActivityManagerNative.getDefault();
        if (mProfiler.profileFile != null && mProfiler.handlingProfiling
                && mProfiler.profileFd == null) {
            Debug.stopMethodTracing();
        }
        //Slog.i(TAG, "am: " + ActivityManagerNative.getDefault()
        //      + ", app thr: " + mAppThread);
        try {
            am.finishInstrumentation(mAppThread, resultCode, results);
        } catch (RemoteException ex) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.250 -0500", hash_original_method = "E6307225A7BED03273D5285E74D77996", hash_generated_method = "FE351320B3E1EAD14CE4B7BBC415235C")
    private void installContentProviders(
            Context context, List<ProviderInfo> providers) {
        final ArrayList<IActivityManager.ContentProviderHolder> results =
            new ArrayList<IActivityManager.ContentProviderHolder>();

        Iterator<ProviderInfo> i = providers.iterator();
        while (i.hasNext()) {
            ProviderInfo cpi = i.next();
            StringBuilder buf = new StringBuilder(128);
            buf.append("Pub ");
            buf.append(cpi.authority);
            buf.append(": ");
            buf.append(cpi.name);
            Log.i(TAG, buf.toString());
            IContentProvider cp = installProvider(context, null, cpi,
                    false /*noisy*/, true /*noReleaseNeeded*/);
            if (cp != null) {
                IActivityManager.ContentProviderHolder cph =
                        new IActivityManager.ContentProviderHolder(cpi);
                cph.provider = cp;
                cph.noReleaseNeeded = true;
                results.add(cph);
            }
        }

        try {
            ActivityManagerNative.getDefault().publishContentProviders(
                getApplicationThread(), results);
        } catch (RemoteException ex) {
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.251 -0500", hash_original_method = "F88C15CE4CC55ECD0AF9CC176F41EB20", hash_generated_method = "AF02D3B889383F9FD248DF59EA76A40B")
    public final IContentProvider acquireProvider(Context c, String name) {
        IContentProvider provider = acquireExistingProvider(c, name);
        if (provider != null) {
            return provider;
        }

        // There is a possible race here.  Another thread may try to acquire
        // the same provider at the same time.  When this happens, we want to ensure
        // that the first one wins.
        // Note that we cannot hold the lock while acquiring and installing the
        // provider since it might take a long time to run and it could also potentially
        // be re-entrant in the case where the provider is in the same process.
        IActivityManager.ContentProviderHolder holder = null;
        try {
            holder = ActivityManagerNative.getDefault().getContentProvider(
                    getApplicationThread(), name);
        } catch (RemoteException ex) {
        }
        if (holder == null) {
            Slog.e(TAG, "Failed to find provider info for " + name);
            return null;
        }

        // Install provider will increment the reference count for us, and break
        // any ties in the race.
        provider = installProvider(c, holder.provider, holder.info,
                true /*noisy*/, holder.noReleaseNeeded);
        if (holder.provider != null && provider != holder.provider) {
            if (localLOGV) {
                Slog.v(TAG, "acquireProvider: lost the race, releasing extraneous "
                        + "reference to the content provider");
            }
            try {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), name);
            } catch (RemoteException ex) {
            }
        }
        return provider;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.252 -0500", hash_original_method = "D0EC607B4605DB37ABCB0EC4802499DE", hash_generated_method = "63956C50F094BC4A4502157F02F43050")
    public final IContentProvider acquireExistingProvider(Context c, String name) {
        synchronized (mProviderMap) {
            ProviderClientRecord pr = mProviderMap.get(name);
            if (pr == null) {
                return null;
            }

            IContentProvider provider = pr.mProvider;
            IBinder jBinder = provider.asBinder();

            // Only increment the ref count if we have one.  If we don't then the
            // provider is not reference counted and never needs to be released.
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            if (prc != null) {
                prc.count += 1;
                if (prc.count == 1) {
                    if (localLOGV) {
                        Slog.v(TAG, "acquireExistingProvider: "
                                + "snatched provider from the jaws of death");
                    }
                    // Because the provider previously had a reference count of zero,
                    // it was scheduled to be removed.  Cancel that.
                    mH.removeMessages(H.REMOVE_PROVIDER, provider);
                }
            }
            return provider;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.253 -0500", hash_original_method = "570D24C9467F1DF00A050F1BB22169F2", hash_generated_method = "D63371BBD3EBBC83B4EB3979F9D089D5")
    public final boolean releaseProvider(IContentProvider provider) {
        if(provider == null) {
            return false;
        }

        IBinder jBinder = provider.asBinder();
        synchronized (mProviderMap) {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            if (prc == null) {
                // The provider has no ref count, no release is needed.
                return false;
            }

            if (prc.count == 0) {
                if (localLOGV) Slog.v(TAG, "releaseProvider: ref count already 0, how?");
                return false;
            }

            prc.count -= 1;
            if (prc.count == 0) {
                // Schedule the actual remove asynchronously, since we don't know the context
                // this will be called in.
                // TODO: it would be nice to post a delayed message, so
                // if we come back and need the same provider quickly
                // we will still have it available.
                Message msg = mH.obtainMessage(H.REMOVE_PROVIDER, provider);
                mH.sendMessage(msg);
            }
            return true;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.254 -0500", hash_original_method = "26DD2496F7761FB77064EC4900EC6CC4", hash_generated_method = "7AA16C3781F0B9EB4457E003D2D71B09")
    final void completeRemoveProvider(IContentProvider provider) {
        IBinder jBinder = provider.asBinder();
        String remoteProviderName = null;
        synchronized(mProviderMap) {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            if (prc == null) {
                // Either no release is needed (so we shouldn't be here) or the
                // provider was already released.
                if (localLOGV) Slog.v(TAG, "completeRemoveProvider: release not needed");
                return;
            }

            if (prc.count != 0) {
                // There was a race!  Some other client managed to acquire
                // the provider before the removal was completed.
                // Abort the removal.  We will do it later.
                if (localLOGV) Slog.v(TAG, "completeRemoveProvider: lost the race, "
                        + "provider still in use");
                return;
            }

            mProviderRefCountMap.remove(jBinder);

            Iterator<ProviderClientRecord> iter = mProviderMap.values().iterator();
            while (iter.hasNext()) {
                ProviderClientRecord pr = iter.next();
                IBinder myBinder = pr.mProvider.asBinder();
                if (myBinder == jBinder) {
                    iter.remove();
                    if (pr.mLocalProvider == null) {
                        myBinder.unlinkToDeath(pr, 0);
                        if (remoteProviderName == null) {
                            remoteProviderName = pr.mName;
                        }
                    }
                }
            }
        }

        if (remoteProviderName != null) {
            try {
                if (localLOGV) {
                    Slog.v(TAG, "removeProvider: Invoking ActivityManagerNative."
                            + "removeContentProvider(" + remoteProviderName + ")");
                }
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), remoteProviderName);
            } catch (RemoteException e) {
                //do nothing content provider object is dead any way
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.255 -0500", hash_original_method = "89FC0B7C2EBDC1E0BBDB9AF687772CD2", hash_generated_method = "D052E0470FF68B25861E7794328DFB2F")
    final void removeDeadProvider(String name, IContentProvider provider) {
        synchronized(mProviderMap) {
            ProviderClientRecord pr = mProviderMap.get(name);
            if (pr != null && pr.mProvider.asBinder() == provider.asBinder()) {
                Slog.i(TAG, "Removing dead content provider: " + name);
                ProviderClientRecord removed = mProviderMap.remove(name);
                if (removed != null) {
                    removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                }
            }
        }
    }

    /**
     * Installs the provider.
     *
     * Providers that are local to the process or that come from the system server
     * may be installed permanently which is indicated by setting noReleaseNeeded to true.
     * Other remote providers are reference counted.  The initial reference count
     * for all reference counted providers is one.  Providers that are not reference
     * counted do not have a reference count (at all).
     *
     * This method detects when a provider has already been installed.  When this happens,
     * it increments the reference count of the existing provider (if appropriate)
     * and returns the existing provider.  This can happen due to concurrent
     * attempts to acquire the same provider.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.256 -0500", hash_original_method = "54C9C23E13579DED3FD2406679DE4E02", hash_generated_method = "B1E29AB04D31D94EAFCEB50AEA23032C")
    private IContentProvider installProvider(Context context,
            IContentProvider provider, ProviderInfo info,
            boolean noisy, boolean noReleaseNeeded) {
        ContentProvider localProvider = null;
        if (provider == null) {
            if (noisy) {
                Slog.d(TAG, "Loading provider " + info.authority + ": "
                        + info.name);
            }
            Context c = null;
            ApplicationInfo ai = info.applicationInfo;
            if (context.getPackageName().equals(ai.packageName)) {
                c = context;
            } else if (mInitialApplication != null &&
                    mInitialApplication.getPackageName().equals(ai.packageName)) {
                c = mInitialApplication;
            } else {
                try {
                    c = context.createPackageContext(ai.packageName,
                            Context.CONTEXT_INCLUDE_CODE);
                } catch (PackageManager.NameNotFoundException e) {
                    // Ignore
                }
            }
            if (c == null) {
                Slog.w(TAG, "Unable to get context for package " +
                      ai.packageName +
                      " while loading content provider " +
                      info.name);
                return null;
            }
            try {
                final java.lang.ClassLoader cl = c.getClassLoader();
                localProvider = (ContentProvider)cl.
                    loadClass(info.name).newInstance();
                provider = localProvider.getIContentProvider();
                if (provider == null) {
                    Slog.e(TAG, "Failed to instantiate class " +
                          info.name + " from sourceDir " +
                          info.applicationInfo.sourceDir);
                    return null;
                }
                if (false) Slog.v(
                    TAG, "Instantiating local provider " + info.name);
                // XXX Need to create the correct context for this provider.
                localProvider.attachInfo(c, info);
            } catch (java.lang.Exception e) {
                if (!mInstrumentation.onException(null, e)) {
                    throw new RuntimeException(
                            "Unable to get provider " + info.name
                            + ": " + e.toString(), e);
                }
                return null;
            }
        } else if (localLOGV) {
            Slog.v(TAG, "Installing external provider " + info.authority + ": "
                    + info.name);
        }

        synchronized (mProviderMap) {
            // There is a possibility that this thread raced with another thread to
            // add the provider.  If we find another thread got there first then we
            // just get out of the way and return the original provider.
            IBinder jBinder = provider.asBinder();
            String names[] = PATTERN_SEMICOLON.split(info.authority);
            for (int i = 0; i < names.length; i++) {
                ProviderClientRecord pr = mProviderMap.get(names[i]);
                if (pr != null) {
                    if (localLOGV) {
                        Slog.v(TAG, "installProvider: lost the race, "
                                + "using existing named provider");
                    }
                    provider = pr.mProvider;
                } else {
                    pr = new ProviderClientRecord(names[i], provider, localProvider);
                    if (localProvider == null) {
                        try {
                            jBinder.linkToDeath(pr, 0);
                        } catch (RemoteException e) {
                            // Provider already dead.  Bail out of here without making
                            // any changes to the provider map or other data structures.
                            return null;
                        }
                    }
                    mProviderMap.put(names[i], pr);
                }
            }

            if (localProvider != null) {
                ProviderClientRecord pr = mLocalProviders.get(jBinder);
                if (pr != null) {
                    if (localLOGV) {
                        Slog.v(TAG, "installProvider: lost the race, "
                                + "using existing local provider");
                    }
                    provider = pr.mProvider;
                } else {
                    pr = new ProviderClientRecord(null, provider, localProvider);
                    mLocalProviders.put(jBinder, pr);
                }
            }

            if (!noReleaseNeeded) {
                ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
                if (prc != null) {
                    if (localLOGV) {
                        Slog.v(TAG, "installProvider: lost the race, incrementing ref count");
                    }
                    prc.count += 1;
                    if (prc.count == 1) {
                        if (localLOGV) {
                            Slog.v(TAG, "installProvider: "
                                    + "snatched provider from the jaws of death");
                        }
                        // Because the provider previously had a reference count of zero,
                        // it was scheduled to be removed.  Cancel that.
                        mH.removeMessages(H.REMOVE_PROVIDER, provider);
                    }
                } else {
                    mProviderRefCountMap.put(jBinder, new ProviderRefCount(1));
                }
            }
        }
        return provider;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:50.588 -0400", hash_original_method = "C124A05EAD0D975305C2EDD26DCF96DC", hash_generated_method = "52F86B6401BDB1F676A0BBBE819353B6")
    private void attach(boolean system) {
        sThreadLocal.set(this);
        mSystemThread = system;
        if(!system)        
        {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {
                @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.258 -0500", hash_original_method = "47807A5814B5D681B360E1F6CDD604E7", hash_generated_method = "B77EB048BA043BB00322E0199679CB06")
                public void run() {
                    ensureJitEnabled();
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
                RuntimeException varEEE3265923145F3B5B035C3648D6659E_609348860 = new RuntimeException(
                        "Unable to instantiate Application():" + e.toString(), e);
                varEEE3265923145F3B5B035C3648D6659E_609348860.addTaint(taint);
                throw varEEE3265923145F3B5B035C3648D6659E_609348860;
            } //End block
        } //End block
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() {
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.260 -0500", hash_original_method = "26C6C7423624E1B7694397A08E8C6CD1", hash_generated_method = "D03BF1B6524A18DFDB59A09B23FC018D")
            public void onConfigurationChanged(Configuration newConfig) {
                synchronized (mPackages) {
                    // We need to apply this change to the resources
                    // immediately, because upon returning the view
                    // hierarchy will be informed about it.
                    if (applyConfigurationToResourcesLocked(newConfig, null)) {
                        // This actually changed the resources!  Tell
                        // everyone about it.
                        if (mPendingConfiguration == null ||
                                mPendingConfiguration.isOtherSeqNewer(newConfig)) {
                            mPendingConfiguration = newConfig;
                            
                            queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                        }
                    }
                }
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.261 -0500", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "79F592DC22C7A97AE301DB7CC367A921")
            public void onLowMemory() {
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.262 -0500", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "447804E40C3F002F4A06D23D7AFAFD46")
            public void onTrimMemory(int level) {
            }
});
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.264 -0500", hash_original_method = "2E14593B1AB1D9A91353E1BD8215A316", hash_generated_method = "5123E00A13A678D3AA50A21573757DEA")
    public final void installSystemProviders(List<ProviderInfo> providers) {
        if (providers != null) {
            installContentProviders(mInitialApplication, providers);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:20.265 -0500", hash_original_method = "A46DE63D351DE0CEA05BC700781E1C79", hash_generated_method = "5ADAD17E5B9A1E7BD4EA0E7A1320CA0F")
    public int getIntCoreSetting(String key, int defaultValue) {
        synchronized (mPackages) {
            if (mCoreSettings != null) {
                return mCoreSettings.getInt(key, defaultValue);
            } else {
                return defaultValue;
            }
        }
    }
}

