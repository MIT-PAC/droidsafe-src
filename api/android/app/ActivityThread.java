package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.768 -0400", hash_original_method = "5E7B9B2805F37099E5240CEF94D75E86", hash_generated_method = "15811A6DE9C2E964B99F6377F947BD45")
    public  SuperNotCalledException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

final class RemoteServiceException extends AndroidRuntimeException {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.768 -0400", hash_original_method = "34FE87499D0272DFF74E34D7FF4C8A87", hash_generated_method = "9A8916256CBCF45D2502CDF5D2E2014D")
    public  RemoteServiceException(String msg) {
        super(msg);
        addTaint(msg.getTaint());
        
    }

    
}

public final class ActivityThread {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.769 -0400", hash_original_field = "B53D6F39CF0756976F39C3EF8C9347C8", hash_generated_field = "2C05F6440224B9B7B649AAB8E25E7F6C")

    final ApplicationThread mAppThread = new ApplicationThread();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.769 -0400", hash_original_field = "22026F7CA49D7800DC9226FB14F18D4E", hash_generated_field = "9DB6C1654FE8632B559AD8938C2BB6D6")

    final Looper mLooper = Looper.myLooper();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.769 -0400", hash_original_field = "0E2EFBC2E5CA04A190F128248BAC384F", hash_generated_field = "C347DA9A9231B315F279E735B8928A09")

    final H mH = new H();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "5140A1A9D96802BCD33EE8109598D4E9", hash_generated_field = "22A9122B8D2BCD21314C7F1C05E1CE1E")

    final HashMap<IBinder, ActivityClientRecord> mActivities = new HashMap<IBinder, ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "2596BE0728EC6D0B3DD8489111BCE626", hash_generated_field = "B71C13DCB6A9130D877B8D4E74CC61E9")

    ActivityClientRecord mNewActivities = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "73A5CC022DE998406F6B6FE5D86E0FC9", hash_generated_field = "C9408B24459238C3188BD4D966397F6A")

    int mNumVisibleActivities = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "61AC602172BC64F1EFD6C846BCAC6EA5", hash_generated_field = "273635D78F4F1853FCFEAE6F3977F1CA")

    final HashMap<IBinder, Service> mServices = new HashMap<IBinder, Service>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "E1323E77467AAA94220311B9002D86DC", hash_generated_field = "61B01177607D3FEF9030C1D9609A65D2")

    AppBindData mBoundApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.770 -0400", hash_original_field = "3813FD00D078EDC298A6165A01B23375", hash_generated_field = "137FC81C700701DC4596025475ABF5FB")

    Profiler mProfiler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "2A37B83F421C69FA65AB0336DCD40F61", hash_generated_field = "17926FA2B84283931976E0CD16AD732E")

    Configuration mConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "9BD99EFAE86DB5408E1E53D94FB68EF1", hash_generated_field = "22A6186D8E2A9BFF1CD600DA1D66E51D")

    Configuration mCompatConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "07E1B5B9B806672E596B36E6C58FDD44", hash_generated_field = "EAF24A11BB6A5B40B8CD0A9DD97E14E0")

    Configuration mResConfiguration;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "FFC49FFC4C1ADAB5104047620A7D56C4", hash_generated_field = "EA04CA285EC541B77CDD4831DDC16DBF")

    CompatibilityInfo mResCompatibilityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "BE63E38FE23E99043AF34F6BEC9CDB32", hash_generated_field = "9E9AEECCAC03AFADA449BC8121CFBA7B")

    Application mInitialApplication;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "9754DC7CB34C86576E6459500AEBA7A8", hash_generated_field = "4467AD43E1EF6F9556A530390DF013D4")

    final ArrayList<Application> mAllApplications = new ArrayList<Application>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.771 -0400", hash_original_field = "DDC10AFA30585BFE20C9F9446377894E", hash_generated_field = "3547FC58C151AD461F39E0C090811C7E")

    final HashMap<String, BackupAgent> mBackupAgents = new HashMap<String, BackupAgent>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "E062CE48CD3AFCDDC19DD9FCF2E119D4", hash_generated_field = "5CBE0F2EE224A7AD181F35AE16EC5D56")

    Instrumentation mInstrumentation;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "3F33A383895BCD9FFD4FF85E994A91B3", hash_generated_field = "BC772FC243D47A489F2D7EFDAE87E511")

    String mInstrumentationAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "E384AAD9DCDFF1E8D0CD8D0A19256B7C", hash_generated_field = "FECBD9A8D7E48015CA8B1CB4E8417096")

    String mInstrumentationAppPackage = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "9BFC607661C16E486035F6C16F2728BF", hash_generated_field = "8A05224BF80336D163F84B1774E94778")

    String mInstrumentedAppDir = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "4E393FC3E9967B2FBCC5BD30CD6D6121", hash_generated_field = "A1282214A6522F9FAF740141A5995478")

    boolean mSystemThread = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "2ADB2DE2F0908AF94082A4D9E402F85C", hash_generated_field = "CA9794682AE3611FC2EF8314769D534A")

    boolean mJitEnabled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.772 -0400", hash_original_field = "2F3B136DE313E1E070DB549F1244D943", hash_generated_field = "1EDAA3CA75AF739BF8D18A37DF3C0780")

    final HashMap<String, WeakReference<LoadedApk>> mPackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "E54DD7B740A85C91DABABE72B3B095EB", hash_generated_field = "D05B59FB5762244EFE6413375736785F")

    final HashMap<String, WeakReference<LoadedApk>> mResourcePackages = new HashMap<String, WeakReference<LoadedApk>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "8F7DF79A1A56B58604502A94A5CC013A", hash_generated_field = "E6A3BBCB9BEFEBC10A10A94F36F55D2A")

    final HashMap<CompatibilityInfo, DisplayMetrics> mDisplayMetrics = new HashMap<CompatibilityInfo, DisplayMetrics>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "2FFFBD4436769ADEF3F6BE93035E29EA", hash_generated_field = "54C77904755445223E6762582AF7167C")

    final HashMap<ResourcesKey, WeakReference<Resources> > mActiveResources = new HashMap<ResourcesKey, WeakReference<Resources> >();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "E0C0F3A1D8876C73109C81652022AE20", hash_generated_field = "FDE1BC39BB1A6D9E731AFE2002BB269D")

    final ArrayList<ActivityClientRecord> mRelaunchingActivities = new ArrayList<ActivityClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "F5DB0E5D46891F17B40D6AE0558F2A3E", hash_generated_field = "52608F8A47308D1928152A18CB1F8EE5")

    Configuration mPendingConfiguration = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.773 -0400", hash_original_field = "DAFE2855A8819A2CAFDA3A7DC574897D", hash_generated_field = "1CEA5FD2A88003C9D7DAC40EC96872BE")

    final HashMap<String, ProviderClientRecord> mProviderMap = new HashMap<String, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "FAD775743D6E65E861C71DE7D10EDCC7", hash_generated_field = "1C776D7BB444F45BF4ABA07E0A6EA27B")

    final HashMap<IBinder, ProviderRefCount> mProviderRefCountMap = new HashMap<IBinder, ProviderRefCount>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "67EF4D3C5C70C137D7F9C1C0643D46E2", hash_generated_field = "77FD57C0A1A6E5A9B2317F5C55C5410F")

    final HashMap<IBinder, ProviderClientRecord> mLocalProviders = new HashMap<IBinder, ProviderClientRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "219DD26B03E1DDCCF0E4339F403F8A1B", hash_generated_field = "7290AC21C9E09A440EA99C73747C36E5")

    final HashMap<Activity, ArrayList<OnActivityPausedListener>> mOnPauseListeners = new HashMap<Activity, ArrayList<OnActivityPausedListener>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "95C2F14E893DEE4E51A4A3450B6F5DDE", hash_generated_field = "0DC5B4AA3D0A311BCB82DC76A964596E")

    final GcIdler mGcIdler = new GcIdler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "DE4BFAC052533664C59E9AD019F17B6A", hash_generated_field = "42912703516C643929BE4407C1512E06")

    boolean mGcIdlerScheduled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "3FAF8118696AC73FC8F1B67D3D02AF4A", hash_generated_field = "5193B2043B5018140A114729BFBC1AB5")

    Bundle mCoreSettings = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.774 -0400", hash_original_field = "993B4BC77167CA135C4203377145C3CD", hash_generated_field = "218DF766A932DC18C65DC16EEE9A759F")

    private Configuration mMainThreadConfig = new Configuration();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.775 -0400", hash_original_field = "C0A0D42CB8ABD8C7501B75A124D2EBED", hash_generated_field = "4A61C1EAE378A13AF88688B33DC5A9C1")

    private int mThumbnailWidth = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.775 -0400", hash_original_field = "911A70F142E0968B61A5EFA355B11DDC", hash_generated_field = "B5D585F47D7019D989CAAE6F1896D3A6")

    private int mThumbnailHeight = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.775 -0400", hash_original_field = "141C098303475F179108F5D3107FEAD3", hash_generated_field = "86CFFC9A0E84C08A1C5D2192C683E8D7")

    private Bitmap mAvailThumbnailBitmap = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.775 -0400", hash_original_field = "9896186CB5EE9EEFA16B028C2F3D5A9A", hash_generated_field = "1246BE5370B0FC65915F756626A5C46E")

    private Canvas mThumbnailCanvas = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.776 -0400", hash_original_method = "C5DB87E83A0D8D66EF8ECA86A91864C7", hash_generated_method = "DE4A90A4BD0EECDAD4C2F33FDAD8D9FA")
      ActivityThread() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.776 -0400", hash_original_method = "FA5B9DB827774258D426805F82794E0D", hash_generated_method = "EBE4AC8FA18D0885A3E86BAFC9F27611")
    private void dumpGraphicsInfo(FileDescriptor fd) {
    }

    
    @DSModeled(DSC.SAFE)
    public static ActivityThread currentActivityThread() {
        return sThreadLocal.get();
    }

    
    @DSModeled(DSC.SAFE)
    public static String currentPackageName() {
        ActivityThread am = currentActivityThread();
        return (am != null && am.mBoundApplication != null)
            ? am.mBoundApplication.processName : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static Application currentApplication() {
        ActivityThread am = currentActivityThread();
        return am != null ? am.mInitialApplication : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static IPackageManager getPackageManager() {
        if (sPackageManager != null) {
            return sPackageManager;
        }
        IBinder b = ServiceManager.getService("package");
        sPackageManager = IPackageManager.Stub.asInterface(b);
        return sPackageManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.779 -0400", hash_original_method = "E45CB384263D7EF5FBA0A98360B08B32", hash_generated_method = "3E10813C3AE5EFDFB07A49198FB06F77")
     DisplayMetrics getDisplayMetricsLocked(CompatibilityInfo ci, boolean forceUpdate) {
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_2029408444 = null; 
        DisplayMetrics varB4EAC82CA7396A68D541C85D26508E83_1325332273 = null; 
        DisplayMetrics dm = mDisplayMetrics.get(ci);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2029408444 = dm;
        } 
        {
            dm = new DisplayMetrics();
            mDisplayMetrics.put(ci, dm);
        } 
        Display d = WindowManagerImpl.getDefault(ci).getDefaultDisplay();
        d.getMetrics(dm);
        varB4EAC82CA7396A68D541C85D26508E83_1325332273 = dm;
        addTaint(ci.getTaint());
        addTaint(forceUpdate);
        DisplayMetrics varA7E53CE21691AB073D9660D615818899_414238981; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_414238981 = varB4EAC82CA7396A68D541C85D26508E83_2029408444;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_414238981 = varB4EAC82CA7396A68D541C85D26508E83_1325332273;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_414238981.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_414238981;
        
        
        
            
        
        
            
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.781 -0400", hash_original_method = "DD63F0FD46EA5914D44A0437CF6968C9", hash_generated_method = "05E3A80500146282F05C3733203BDC64")
     Configuration applyConfigCompatMainThread(Configuration config, CompatibilityInfo compat) {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1142659777 = null; 
        Configuration varB4EAC82CA7396A68D541C85D26508E83_244206564 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1142659777 = null;
        } 
        {
            boolean varCD86D3736FF36F045F26DFAD036F3B54_140343579 = (compat != null && !compat.supportsScreen());
            {
                mMainThreadConfig.setTo(config);
                config = mMainThreadConfig;
                compat.applyToConfiguration(config);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_244206564 = config;
        addTaint(config.getTaint());
        addTaint(compat.getTaint());
        Configuration varA7E53CE21691AB073D9660D615818899_1921411546; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1921411546 = varB4EAC82CA7396A68D541C85D26508E83_1142659777;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1921411546 = varB4EAC82CA7396A68D541C85D26508E83_244206564;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1921411546.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1921411546;
        
        
            
        
        
            
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.786 -0400", hash_original_method = "371F1E66BBE63CA5CE35B0BEAA492ADA", hash_generated_method = "FCD63A1BEEECD2550C078A2ED36D6813")
     Resources getTopLevelResources(String resDir, CompatibilityInfo compInfo) {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1595508413 = null; 
        Resources varB4EAC82CA7396A68D541C85D26508E83_2016427880 = null; 
        Resources varB4EAC82CA7396A68D541C85D26508E83_358679570 = null; 
        Resources varB4EAC82CA7396A68D541C85D26508E83_1073063700 = null; 
        ResourcesKey key = new ResourcesKey(resDir, compInfo.applicationScale);
        Resources r;
        {
            WeakReference<Resources> wr = mActiveResources.get(key);
            r = wr != null ? wr.get() : null;
            {
                boolean var48C26B00950FB02DC27CD0CFBAC99128_1406800421 = (r != null && r.getAssets().isUpToDate());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1595508413 = r;
                } 
            } 
        } 
        AssetManager assets = new AssetManager();
        {
            boolean varA8CA5D176688F55202435C4C301C623B_93833578 = (assets.addAssetPath(resDir) == 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2016427880 = null;
            } 
        } 
        DisplayMetrics metrics = getDisplayMetricsLocked(null, false);
        r = new Resources(assets, metrics, getConfiguration(), compInfo);
        {
            WeakReference<Resources> wr = mActiveResources.get(key);
            Resources existing;
            existing = wr.get();
            existing = null;
            {
                boolean var272EB1A1727EF2EADA6DAD1E49705320_1425106149 = (existing != null && existing.getAssets().isUpToDate());
                {
                    r.getAssets().close();
                    varB4EAC82CA7396A68D541C85D26508E83_358679570 = existing;
                } 
            } 
            mActiveResources.put(key, new WeakReference<Resources>(r));
            varB4EAC82CA7396A68D541C85D26508E83_1073063700 = r;
        } 
        addTaint(resDir.getTaint());
        addTaint(compInfo.getTaint());
        Resources varA7E53CE21691AB073D9660D615818899_1161532677; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1161532677 = varB4EAC82CA7396A68D541C85D26508E83_1595508413;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1161532677 = varB4EAC82CA7396A68D541C85D26508E83_2016427880;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1161532677 = varB4EAC82CA7396A68D541C85D26508E83_358679570;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1161532677 = varB4EAC82CA7396A68D541C85D26508E83_1073063700;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1161532677.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1161532677;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.787 -0400", hash_original_method = "9D648CED90369A8409E4C88D7CE96759", hash_generated_method = "7CCD15DCBA5DD06122A38552A86F3787")
     Resources getTopLevelResources(String resDir, LoadedApk pkgInfo) {
        Resources varB4EAC82CA7396A68D541C85D26508E83_188553471 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_188553471 = getTopLevelResources(resDir, pkgInfo.mCompatibilityInfo.get());
        addTaint(resDir.getTaint());
        addTaint(pkgInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_188553471.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_188553471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.788 -0400", hash_original_method = "F7A72EDCDC7800374FD6BBEAFCDB636B", hash_generated_method = "48E9B9992D36F65A8228695D99882AC9")
    final Handler getHandler() {
        Handler varB4EAC82CA7396A68D541C85D26508E83_156546932 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_156546932 = mH;
        varB4EAC82CA7396A68D541C85D26508E83_156546932.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_156546932;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.790 -0400", hash_original_method = "FD6B2C09494E94CB4CF03F9000F967F2", hash_generated_method = "F08105BED18F74BDE381F044F23F2F92")
    public final LoadedApk getPackageInfo(String packageName, CompatibilityInfo compatInfo,
            int flags) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1465706812 = null; 
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1909467311 = null; 
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1749229908 = null; 
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(packageName);
            } 
            {
                ref = mResourcePackages.get(packageName);
            } 
            LoadedApk packageInfo;
            packageInfo = ref.get();
            packageInfo = null;
            {
                boolean varB533B767BDFF950E5D1E69E8D8289A2E_861776931 = (packageInfo != null && (packageInfo.mResources == null
                    || packageInfo.mResources.getAssets().isUpToDate()));
                {
                    {
                        boolean var0E943DBF535AA6AD6A4FBE9A1D1356B5_1449171744 = (packageInfo.isSecurityViolation()
                        && (flags&Context.CONTEXT_IGNORE_SECURITY) == 0);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                            "Requesting code from " + packageName
                            + " to be run in process "
                            + mBoundApplication.processName
                            + "/" + mBoundApplication.appInfo.uid);
                        } 
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1465706812 = packageInfo;
                } 
            } 
        } 
        ApplicationInfo ai = null;
        try 
        {
            ai = getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_SHARED_LIBRARY_FILES);
        } 
        catch (RemoteException e)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_1909467311 = getPackageInfo(ai, compatInfo, flags);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1749229908 = null;
        addTaint(packageName.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(flags);
        LoadedApk varA7E53CE21691AB073D9660D615818899_2088737175; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2088737175 = varB4EAC82CA7396A68D541C85D26508E83_1465706812;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2088737175 = varB4EAC82CA7396A68D541C85D26508E83_1909467311;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2088737175 = varB4EAC82CA7396A68D541C85D26508E83_1749229908;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2088737175.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2088737175;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.793 -0400", hash_original_method = "45FB4CD004B111E95D4C640E8F52184B", hash_generated_method = "3CBA709CA0335DA622AD5BB4116F2D5B")
    public final LoadedApk getPackageInfo(ApplicationInfo ai, CompatibilityInfo compatInfo,
            int flags) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1115502231 = null; 
        boolean includeCode = (flags&Context.CONTEXT_INCLUDE_CODE) != 0;
        boolean securityViolation = includeCode && ai.uid != 0
                && ai.uid != Process.SYSTEM_UID && (mBoundApplication != null
                        ? ai.uid != mBoundApplication.appInfo.uid : true);
        {
            {
                String msg = "Requesting code from " + ai.packageName
                        + " (with uid " + ai.uid + ")";
                {
                    msg = msg + " to be run in process "
                        + mBoundApplication.processName + " (with uid "
                        + mBoundApplication.appInfo.uid + ")";
                } 
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(msg);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1115502231 = getPackageInfo(ai, compatInfo, null, securityViolation, includeCode);
        addTaint(ai.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1115502231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1115502231;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.795 -0400", hash_original_method = "60B71579104EFF006D8A717508119428", hash_generated_method = "8C34909B1E70A507511EC5B35B91A2B3")
    public final LoadedApk getPackageInfoNoCheck(ApplicationInfo ai,
            CompatibilityInfo compatInfo) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_1407003486 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1407003486 = getPackageInfo(ai, compatInfo, null, false, true);
        addTaint(ai.getTaint());
        addTaint(compatInfo.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1407003486.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1407003486;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.796 -0400", hash_original_method = "5838753A6BAADDD41C531129622D5299", hash_generated_method = "09D842C97BA47A9C34B27FC2E45F63BC")
    public final LoadedApk peekPackageInfo(String packageName, boolean includeCode) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_113785306 = null; 
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(packageName);
            } 
            {
                ref = mResourcePackages.get(packageName);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_113785306 = ref != null ? ref.get() : null;
        } 
        addTaint(packageName.getTaint());
        addTaint(includeCode);
        varB4EAC82CA7396A68D541C85D26508E83_113785306.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_113785306;
        
        
            
            
                
            
                
            
            
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.798 -0400", hash_original_method = "F2A25E301DE436DC300B56B48A365596", hash_generated_method = "F25035221DAB39944B2B666075A80FE5")
    private LoadedApk getPackageInfo(ApplicationInfo aInfo, CompatibilityInfo compatInfo,
            ClassLoader baseLoader, boolean securityViolation, boolean includeCode) {
        LoadedApk varB4EAC82CA7396A68D541C85D26508E83_514937822 = null; 
        {
            WeakReference<LoadedApk> ref;
            {
                ref = mPackages.get(aInfo.packageName);
            } 
            {
                ref = mResourcePackages.get(aInfo.packageName);
            } 
            LoadedApk packageInfo;
            packageInfo = ref.get();
            packageInfo = null;
            {
                boolean var9EEE2F12DDA56A5DEE7DE7A2224F5C7D_536847991 = (packageInfo == null || (packageInfo.mResources != null
                    && !packageInfo.mResources.getAssets().isUpToDate()));
                {
                    packageInfo =
                    new LoadedApk(this, aInfo, compatInfo, this, baseLoader,
                            securityViolation, includeCode &&
                            (aInfo.flags&ApplicationInfo.FLAG_HAS_CODE) != 0);
                    {
                        mPackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                    } 
                    {
                        mResourcePackages.put(aInfo.packageName,
                            new WeakReference<LoadedApk>(packageInfo));
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_514937822 = packageInfo;
        } 
        addTaint(aInfo.getTaint());
        addTaint(compatInfo.getTaint());
        addTaint(baseLoader.getTaint());
        addTaint(securityViolation);
        addTaint(includeCode);
        varB4EAC82CA7396A68D541C85D26508E83_514937822.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_514937822;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.799 -0400", hash_original_method = "F0BED1934E92681B3C0E496CA2259BFD", hash_generated_method = "B00ACA88AB4FE899E6C24B66D2A67128")
    public ApplicationThread getApplicationThread() {
        ApplicationThread varB4EAC82CA7396A68D541C85D26508E83_1207824696 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1207824696 = mAppThread;
        varB4EAC82CA7396A68D541C85D26508E83_1207824696.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1207824696;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.800 -0400", hash_original_method = "84F87CEBEDE5D31C88CD24E066F68A95", hash_generated_method = "582BF1A0E0DCAA201B854F3B0DB112F1")
    public Instrumentation getInstrumentation() {
        Instrumentation varB4EAC82CA7396A68D541C85D26508E83_1280331690 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1280331690 = mInstrumentation;
        varB4EAC82CA7396A68D541C85D26508E83_1280331690.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1280331690;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.802 -0400", hash_original_method = "9032A5E826B7A6BB9A1848729A4BF06F", hash_generated_method = "BB4C654E4D1BD497CB43E8F2B01313EA")
    public Configuration getConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1493239654 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1493239654 = mResConfiguration;
        varB4EAC82CA7396A68D541C85D26508E83_1493239654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1493239654;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.803 -0400", hash_original_method = "BB8D8D9198132B7570723812CBBB4B98", hash_generated_method = "DC7EEAB38085A79D9136B0F242889899")
    public boolean isProfiling() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1955620312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1955620312;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.805 -0400", hash_original_method = "DE9E88BCF6C439479F5E5429ED790EB6", hash_generated_method = "2605915698528AA453E9E0F2BCA5CF3B")
    public String getProfileFilePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_820669047 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_820669047 = mProfiler.profileFile;
        varB4EAC82CA7396A68D541C85D26508E83_820669047.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_820669047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.806 -0400", hash_original_method = "6CA5860A95ACD9BB8C844ECC1E567192", hash_generated_method = "F5FEB144ABC31A4213F476A394C00E05")
    public Looper getLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1805840381 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1805840381 = mLooper;
        varB4EAC82CA7396A68D541C85D26508E83_1805840381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1805840381;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.807 -0400", hash_original_method = "BED0801CDE1100B1F268B3031343DFA4", hash_generated_method = "CC2E687B79D2BD0FC198A3EBA50A4A46")
    public Application getApplication() {
        Application varB4EAC82CA7396A68D541C85D26508E83_1296548014 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1296548014 = mInitialApplication;
        varB4EAC82CA7396A68D541C85D26508E83_1296548014.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1296548014;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.808 -0400", hash_original_method = "5878D065A1BC5C9B3897192B88F09BB5", hash_generated_method = "EC4032152C99C6577518E4148A2A7C59")
    public String getProcessName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1162913230 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1162913230 = mBoundApplication.processName;
        varB4EAC82CA7396A68D541C85D26508E83_1162913230.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1162913230;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.810 -0400", hash_original_method = "67B7F6B98B8791421AA33911A41FCF20", hash_generated_method = "A9DF01C4215293A6909F770416C1D2D8")
    public ContextImpl getSystemContext() {
        ContextImpl varB4EAC82CA7396A68D541C85D26508E83_1187563197 = null; 
        {
            {
                ContextImpl context = ContextImpl.createSystemContext(this);
                LoadedApk info = new LoadedApk(this, "android", context, null,
                        CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO);
                context.init(info, null, this);
                context.getResources().updateConfiguration(
                        getConfiguration(), getDisplayMetricsLocked(
                                CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, false));
                mSystemContext = context;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1187563197 = mSystemContext;
        varB4EAC82CA7396A68D541C85D26508E83_1187563197.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1187563197;
        
        
            
                
                    
                
                        
                
                
                        
                                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.811 -0400", hash_original_method = "AC12C154682E9BD06E6B4A91255348E3", hash_generated_method = "60B6CD2EB599B5ABB18D3BAD3F8328FC")
    public void installSystemApplicationInfo(ApplicationInfo info) {
        {
            ContextImpl context = getSystemContext();
            context.init(new LoadedApk(this, "android", context, info,
                    CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO), null, this);
            mProfiler = new Profiler();
        } 
        addTaint(info.getTaint());
        
        
            
            
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.812 -0400", hash_original_method = "6C1D7D3CADCC8F71CFEF3977DBF36D15", hash_generated_method = "93C8069C63CC057876DD921F32F06D0F")
     void ensureJitEnabled() {
        {
            mJitEnabled = true;
            dalvik.system.VMRuntime.getRuntime().startJitCompilation();
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.813 -0400", hash_original_method = "9194C167DA959B824F2056B7870F9862", hash_generated_method = "C950B3F99143F6F5E96E0A1201B207BF")
     void scheduleGcIdler() {
        {
            mGcIdlerScheduled = true;
            Looper.myQueue().addIdleHandler(mGcIdler);
        } 
        mH.removeMessages(H.GC_WHEN_IDLE);
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.814 -0400", hash_original_method = "418A9C1DFD1D7F21CC468D764B344F26", hash_generated_method = "DAEBA60FFC284CD27BC815F3423B1DBA")
     void unscheduleGcIdler() {
        {
            mGcIdlerScheduled = false;
            Looper.myQueue().removeIdleHandler(mGcIdler);
        } 
        mH.removeMessages(H.GC_WHEN_IDLE);
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.815 -0400", hash_original_method = "7E176906E0A5888F6535695D6EB5B115", hash_generated_method = "4DA5E3EADF5B142BBF9034FE7F67383B")
     void doGcIfNeeded() {
        mGcIdlerScheduled = false;
        final long now = SystemClock.uptimeMillis();
        {
            boolean varE184117867CF0C26F2EFEE16CB7C3505_1447112326 = ((BinderInternal.getLastGcTime()+MIN_TIME_BETWEEN_GCS) < now);
            {
                BinderInternal.forceGc("bg");
            } 
        } 
        
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.816 -0400", hash_original_method = "BC7C90866968540D7B885FF1F76E8E09", hash_generated_method = "27A360AEF250E709B11106BA288E46C1")
    public void registerOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        
        {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            {
                list = new ArrayList<OnActivityPausedListener>();
                mOnPauseListeners.put(activity, list);
            } 
            list.add(listener);
        } 
        addTaint(activity.getTaint());
        addTaint(listener.getTaint());
        
        
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.817 -0400", hash_original_method = "A666FB211AE0A9537AAE3A42A197A4A4", hash_generated_method = "9647425E4A09772DF7738AB94AA15EEE")
    public void unregisterOnActivityPausedListener(Activity activity,
            OnActivityPausedListener listener) {
        {
            ArrayList<OnActivityPausedListener> list = mOnPauseListeners.get(activity);
            {
                list.remove(listener);
            } 
        } 
        addTaint(activity.getTaint());
        addTaint(listener.getTaint());
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.818 -0400", hash_original_method = "FA6ACBD6D6B2F04759E1E44999782C17", hash_generated_method = "17C5456FA2FB5475E502403717B702E3")
    public final ActivityInfo resolveActivityInfo(Intent intent) {
        ActivityInfo varB4EAC82CA7396A68D541C85D26508E83_1945507355 = null; 
        ActivityInfo aInfo = intent.resolveActivityInfo(
                mInitialApplication.getPackageManager(), PackageManager.GET_SHARED_LIBRARY_FILES);
        {
            Instrumentation.checkStartActivityResult(
                    IActivityManager.START_CLASS_NOT_FOUND, intent);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1945507355 = aInfo;
        addTaint(intent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1945507355.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1945507355;
        
        
                
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.819 -0400", hash_original_method = "52193E396925A8581791167FBC0A1FC9", hash_generated_method = "DF73D050F768CBC9FDA7C65A1B003206")
    public final Activity startActivityNow(Activity parent, String id,
        Intent intent, ActivityInfo activityInfo, IBinder token, Bundle state,
        Activity.NonConfigurationInstances lastNonConfigurationInstances) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1334339523 = null; 
        ActivityClientRecord r = new ActivityClientRecord();
        r.token = token;
        r.ident = 0;
        r.intent = intent;
        r.state = state;
        r.parent = parent;
        r.embeddedID = id;
        r.activityInfo = activityInfo;
        r.lastNonConfigurationInstances = lastNonConfigurationInstances;
        {
            ComponentName compname = intent.getComponent();
            String name;
            {
                name = compname.toShortString();
            } 
            {
                name = "(Intent " + intent + ").getComponent() returned null";
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1334339523 = performLaunchActivity(r, null);
        addTaint(parent.getTaint());
        addTaint(id.getTaint());
        addTaint(intent.getTaint());
        addTaint(activityInfo.getTaint());
        addTaint(token.getTaint());
        addTaint(state.getTaint());
        addTaint(lastNonConfigurationInstances.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1334339523.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1334339523;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.821 -0400", hash_original_method = "E4DB0C38EE0152F49C4586AFA6AD83D1", hash_generated_method = "3D3D33F7F5D7FE626346CD0FB14D40A7")
    public final Activity getActivity(IBinder token) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_384469365 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_384469365 = mActivities.get(token).activity;
        addTaint(token.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_384469365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_384469365;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.822 -0400", hash_original_method = "46F0209236B49884D3899FCB9A0A8CD2", hash_generated_method = "CEF6B2496F07B45294A77D6210901690")
    public final void sendActivityResult(
            IBinder token, String id, int requestCode,
            int resultCode, Intent data) {
        ArrayList<ResultInfo> list = new ArrayList<ResultInfo>();
        list.add(new ResultInfo(id, requestCode, resultCode, data));
        mAppThread.scheduleSendResult(token, list);
        addTaint(token.getTaint());
        addTaint(id.getTaint());
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
        
                
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.824 -0400", hash_original_method = "04C4A68B1E80544C50165B2C1F09966C", hash_generated_method = "321706A67BED54A5A8D03B480A5D0B66")
    private void queueOrSendMessage(int what, Object obj) {
        queueOrSendMessage(what, obj, 0, 0);
        addTaint(what);
        addTaint(obj.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.824 -0400", hash_original_method = "3163B4D830BC02309EB9FA4093F38166", hash_generated_method = "65054CEA9CE759579BC78585AFB485B4")
    private void queueOrSendMessage(int what, Object obj, int arg1) {
        queueOrSendMessage(what, obj, arg1, 0);
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(arg1);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.825 -0400", hash_original_method = "BA532BAA145C03E1DD34B30EBC725387", hash_generated_method = "4383914684AEE9250D81A4829B5C4B16")
    private void queueOrSendMessage(int what, Object obj, int arg1, int arg2) {
        {
            Message msg = Message.obtain();
            msg.what = what;
            msg.obj = obj;
            msg.arg1 = arg1;
            msg.arg2 = arg2;
            mH.sendMessage(msg);
        } 
        addTaint(what);
        addTaint(obj.getTaint());
        addTaint(arg1);
        addTaint(arg2);
        
        
            
                
                
            
            
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.826 -0400", hash_original_method = "15BD644AA17343360FD7D474ECDA0BC6", hash_generated_method = "CB66B0150AA355B84BAF7DB7682CCAEC")
    final void scheduleContextCleanup(ContextImpl context, String who,
            String what) {
        ContextCleanupInfo cci = new ContextCleanupInfo();
        cci.context = context;
        cci.who = who;
        cci.what = what;
        queueOrSendMessage(H.CLEAN_UP_CONTEXT, cci);
        addTaint(context.getTaint());
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.829 -0400", hash_original_method = "C9C4D84CF5E4E5BEF4E002420AA42B4A", hash_generated_method = "8EDEE8F6A6EB08C83136727C80F440A5")
    private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1852405061 = null; 
        ActivityInfo aInfo = r.activityInfo;
        {
            r.packageInfo = getPackageInfo(aInfo.applicationInfo, r.compatInfo,
                    Context.CONTEXT_INCLUDE_CODE);
        } 
        ComponentName component = r.intent.getComponent();
        {
            component = r.intent.resolveActivity(
                mInitialApplication.getPackageManager());
            r.intent.setComponent(component);
        } 
        {
            component = new ComponentName(r.activityInfo.packageName,
                    r.activityInfo.targetActivity);
        } 
        Activity activity = null;
        try 
        {
            java.lang.ClassLoader cl = r.packageInfo.getClassLoader();
            activity = mInstrumentation.newActivity(
                    cl, component.getClassName(), r.intent);
            StrictMode.incrementExpectedActivityCount(activity.getClass());
            r.intent.setExtrasClassLoader(cl);
            {
                r.state.setClassLoader(cl);
            } 
        } 
        catch (Exception e)
        {
            {
                boolean var8E41159D9268684301886771AE50E678_1050573052 = (!mInstrumentation.onException(activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate activity " + component
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        try 
        {
            Application app = r.packageInfo.makeApplication(false, mInstrumentation);
            {
                ContextImpl appContext = new ContextImpl();
                appContext.init(r.packageInfo, r.token, this);
                appContext.setOuterContext(activity);
                CharSequence title = r.activityInfo.loadLabel(appContext.getPackageManager());
                Configuration config = new Configuration(mCompatConfiguration);
                activity.attach(appContext, this, getInstrumentation(), r.token,
                        r.ident, app, r.intent, r.activityInfo, title, r.parent,
                        r.embeddedID, r.lastNonConfigurationInstances, config);
                {
                    activity.mIntent = customIntent;
                } 
                r.lastNonConfigurationInstances = null;
                activity.mStartedActivity = false;
                int theme = r.activityInfo.getThemeResource();
                {
                    activity.setTheme(theme);
                } 
                activity.mCalled = false;
                mInstrumentation.callActivityOnCreate(activity, r.state);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                        "Activity " + r.intent.getComponent().toShortString() +
                        " did not call through to super.onCreate()");
                } 
                r.activity = activity;
                r.stopped = true;
                {
                    activity.performStart();
                    r.stopped = false;
                } 
                {
                    {
                        mInstrumentation.callActivityOnRestoreInstanceState(activity, r.state);
                    } 
                } 
                {
                    activity.mCalled = false;
                    mInstrumentation.callActivityOnPostCreate(activity, r.state);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + r.intent.getComponent().toShortString() +
                            " did not call through to super.onPostCreate()");
                    } 
                } 
            } 
            r.paused = true;
            mActivities.put(r.token, r);
        } 
        catch (SuperNotCalledException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (Exception e)
        {
            {
                boolean var8E41159D9268684301886771AE50E678_241709158 = (!mInstrumentation.onException(activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to start activity " + component
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1852405061 = activity;
        addTaint(r.getTaint());
        addTaint(customIntent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1852405061.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1852405061;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.831 -0400", hash_original_method = "483F7FDC9359FE0D21A4FBFB307EF0CA", hash_generated_method = "B51D7E38CFFEDF88D2777AF7682B65F0")
    private void handleLaunchActivity(ActivityClientRecord r, Intent customIntent) {
        unscheduleGcIdler();
        {
            mProfiler.setProfiler(r.profileFile, r.profileFd);
            mProfiler.startProfiling();
            mProfiler.autoStopProfiler = r.autoStopProfiler;
        } 
        handleConfigurationChanged(null, null);
        Activity a = performLaunchActivity(r, customIntent);
        {
            r.createdConfig = new Configuration(mConfiguration);
            Bundle oldState = r.state;
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
                    } 
                } 
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1276874131 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
                r.paused = true;
            } 
        } 
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(r.token, Activity.RESULT_CANCELED, null);
            } 
            catch (RemoteException ex)
            { }
        } 
        addTaint(customIntent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.832 -0400", hash_original_method = "089DA2DACAED1790C29E22F2D6A7A046", hash_generated_method = "FF90597869B972932CA7372F9393FFD3")
    private void deliverNewIntents(ActivityClientRecord r,
            List<Intent> intents) {
        final int N = intents.size();
        {
            int i = 0;
            {
                Intent intent = intents.get(i);
                intent.setExtrasClassLoader(r.activity.getClassLoader());
                r.activity.mFragments.noteStateNotSaved();
                mInstrumentation.callActivityOnNewIntent(r.activity, intent);
            } 
        } 
        addTaint(r.getTaint());
        addTaint(intents.getTaint());
        
        
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.834 -0400", hash_original_method = "62C39F1A7060D00626ABC1EA40393902", hash_generated_method = "3A29DF5A2F2BAFFF7E8F476D5F604493")
    public final void performNewIntents(IBinder token,
            List<Intent> intents) {
        ActivityClientRecord r = mActivities.get(token);
        {
            final boolean resumed = !r.paused;
            {
                r.activity.mTemporaryPause = true;
                mInstrumentation.callActivityOnPause(r.activity);
            } 
            deliverNewIntents(r, intents);
            {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            } 
        } 
        addTaint(token.getTaint());
        addTaint(intents.getTaint());
        
        
        
            
            
                
                
            
            
            
                
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.835 -0400", hash_original_method = "3340D70EC7FD056C28E3BD0AF1C7CC94", hash_generated_method = "F53E80B90447BEAED725633B8B7CEF50")
    private void handleNewIntent(NewIntentData data) {
        performNewIntents(data.token, data.intents);
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    public static Intent getIntentBeingBroadcast() {
        return sCurrentBroadcastIntent.get();
    }

    
    @DSModeled(DSC.SAFE)
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
        } 
        catch (Exception e)
        {
            data.sendFinished(mgr);
            throw new RuntimeException(
                "Unable to instantiate receiver " + component
                + ": " + e.toString(), e);
        } 
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
        } 
        catch (Exception e)
        {
            data.sendFinished(mgr);
            {
                boolean varE107D295AE6781FEBA130F0CDDDA8A51_375268246 = (!mInstrumentation.onException(receiver, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to start receiver " + component
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        finally 
        {
            sCurrentBroadcastIntent.set(null);
        } 
        {
            boolean var198BEFC4677783C257791C95882C8BD8_969809034 = (receiver.getPendingResult() != null);
            {
                data.finish();
            } 
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.837 -0400", hash_original_method = "F9FD1947DE4D383F90C08BC5B81CEB33", hash_generated_method = "6E45882BE2C43FB4FB76066C1D6C1834")
    private void handleCreateBackupAgent(CreateBackupAgentData data) {
        unscheduleGcIdler();
        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
        {
            boolean var2036584F8EC354D6E6901E916B116B68_2010558873 = (mBackupAgents.get(packageName) != null);
            {
                Slog.d(TAG, "BackupAgent " + "  for " + packageName
                    + " already exists");
            } 
        } 
        BackupAgent agent = null;
        String classname = data.appInfo.backupAgentName;
        {
            classname = "android.app.backup.FullBackupAgent";
        } 
        try 
        {
            IBinder binder = null;
            try 
            {
                java.lang.ClassLoader cl = packageInfo.getClassLoader();
                agent = (BackupAgent) cl.loadClass(classname).newInstance();
                ContextImpl context = new ContextImpl();
                context.init(packageInfo, null, this);
                context.setOuterContext(agent);
                agent.attach(context);
                agent.onCreate();
                binder = agent.onBind();
                mBackupAgents.put(packageName, agent);
            } 
            catch (Exception e)
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
            } 
            try 
            {
                ActivityManagerNative.getDefault().backupAgentCreated(packageName, binder);
            } 
            catch (RemoteException e)
            { }
        } 
        catch (Exception e)
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Unable to create BackupAgent "
                    + classname + ": " + e.toString(), e);
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.838 -0400", hash_original_method = "F45834CE0FCB2021DEF63803688239C3", hash_generated_method = "0496618E2143D18C55200C3958C8E1CD")
    private void handleDestroyBackupAgent(CreateBackupAgentData data) {
        LoadedApk packageInfo = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        String packageName = packageInfo.mPackageName;
        BackupAgent agent = mBackupAgents.get(packageName);
        {
            try 
            {
                agent.onDestroy();
            } 
            catch (Exception e)
            {
                e.printStackTrace();
            } 
            mBackupAgents.remove(packageName);
        } 
        addTaint(data.getTaint());
        
        
        
        
        
        
            
                
            
                
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.839 -0400", hash_original_method = "77CEB6B4E506F7F39264B1FEFD4EC387", hash_generated_method = "A1D93E84BEB9A0294B10C191D6DEAB59")
    private void handleCreateService(CreateServiceData data) {
        unscheduleGcIdler();
        LoadedApk packageInfo = getPackageInfoNoCheck(
                data.info.applicationInfo, data.compatInfo);
        Service service = null;
        try 
        {
            java.lang.ClassLoader cl = packageInfo.getClassLoader();
            service = (Service) cl.loadClass(data.info.name).newInstance();
        } 
        catch (Exception e)
        {
            {
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_824455713 = (!mInstrumentation.onException(service, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate service " + data.info.name
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        try 
        {
            ContextImpl context = new ContextImpl();
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
            } 
            catch (RemoteException e)
            { }
        } 
        catch (Exception e)
        {
            {
                boolean var5CCAE16AB901A25C2EF7121B6406B19B_1111405634 = (!mInstrumentation.onException(service, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to create service " + data.info.name
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.840 -0400", hash_original_method = "881D5FBA45CBA067F129D10745838607", hash_generated_method = "0870E9C90FDD050695B603696879AD25")
    private void handleBindService(BindServiceData data) {
        Service s = mServices.get(data.token);
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                try 
                {
                    {
                        IBinder binder = s.onBind(data.intent);
                        ActivityManagerNative.getDefault().publishService(
                                data.token, data.intent, binder);
                    } 
                    {
                        s.onRebind(data.intent);
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } 
                    ensureJitEnabled();
                } 
                catch (RemoteException ex)
                { }
            } 
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_1972052514 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to bind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.841 -0400", hash_original_method = "2796BE6EE721B85B28BB6DBD3B4C5C51", hash_generated_method = "4AD6DFCCE642AC2B562455A1B071D6C8")
    private void handleUnbindService(BindServiceData data) {
        Service s = mServices.get(data.token);
        {
            try 
            {
                data.intent.setExtrasClassLoader(s.getClassLoader());
                boolean doRebind = s.onUnbind(data.intent);
                try 
                {
                    {
                        ActivityManagerNative.getDefault().unbindFinished(
                                data.token, data.intent, doRebind);
                    } 
                    {
                        ActivityManagerNative.getDefault().serviceDoneExecuting(
                                data.token, 0, 0, 0);
                    } 
                } 
                catch (RemoteException ex)
                { }
            } 
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_1135072596 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to unbind to service " + s
                            + " with " + data.intent + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.842 -0400", hash_original_method = "1C18D37F75673CCCBD9C372D3BFFD82C", hash_generated_method = "ACF9C875D783745AADDBA54F43C971DC")
    private void handleDumpService(DumpComponentInfo info) {
        Service s = mServices.get(info.token);
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            s.dump(info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } 
            catch (IOException e)
            { }
        } 
        addTaint(info.getTaint());
        
        
        
            
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.844 -0400", hash_original_method = "126292FF06E700D8C53E21C56EE062B7", hash_generated_method = "0C201D9441E71B450C1422EFD6103EB3")
    private void handleDumpActivity(DumpComponentInfo info) {
        ActivityClientRecord r = mActivities.get(info.token);
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(info.fd.getFileDescriptor()));
            r.activity.dump(info.prefix, info.fd.getFileDescriptor(), pw, info.args);
            pw.flush();
            try 
            {
                info.fd.close();
            } 
            catch (IOException e)
            { }
        } 
        addTaint(info.getTaint());
        
        
        
            
            
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.845 -0400", hash_original_method = "7729FDAE3B00ADA3C236E33577FF6666", hash_generated_method = "ECECF136AA577D13AB4BFF442F446876")
    private void handleServiceArgs(ServiceArgsData data) {
        Service s = mServices.get(data.token);
        {
            try 
            {
                {
                    data.args.setExtrasClassLoader(s.getClassLoader());
                } 
                int res;
                {
                    res = s.onStartCommand(data.args, data.flags, data.startId);
                } 
                {
                    s.onTaskRemoved(data.args);
                    res = Service.START_TASK_REMOVED_COMPLETE;
                } 
                QueuedWork.waitToFinish();
                try 
                {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            data.token, 1, data.startId, res);
                } 
                catch (RemoteException e)
                { }
                ensureJitEnabled();
            } 
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_1957475053 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to start service " + s
                            + " with " + data.args + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.846 -0400", hash_original_method = "E9A561F96B3BEE10BDD2A8F223813D32", hash_generated_method = "118D91B28A4F9A03F020FBAB9519DDCE")
    private void handleStopService(IBinder token) {
        Service s = mServices.remove(token);
        {
            try 
            {
                s.onDestroy();
                Context context = s.getBaseContext();
                {
                    final String who = s.getClassName();
                    ((ContextImpl) context).scheduleFinalCleanup(who, "Service");
                } 
                QueuedWork.waitToFinish();
                try 
                {
                    ActivityManagerNative.getDefault().serviceDoneExecuting(
                            token, 0, 0, 0);
                } 
                catch (RemoteException e)
                { }
            } 
            catch (Exception e)
            {
                {
                    boolean var10690A467C953EA99805B9012CAE2444_514753046 = (!mInstrumentation.onException(s, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to stop service " + s
                            + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        addTaint(token.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.848 -0400", hash_original_method = "821CC6EDFD77BBF57472742A46BD9804", hash_generated_method = "E9782116723BF21C5DFC63E82DE005B4")
    public final ActivityClientRecord performResumeActivity(IBinder token,
            boolean clearHide) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_379987322 = null; 
        ActivityClientRecord r = mActivities.get(token);
        {
            {
                r.hideForNow = false;
                r.activity.mStartedActivity = false;
            } 
            try 
            {
                {
                    deliverNewIntents(r, r.pendingIntents);
                    r.pendingIntents = null;
                } 
                {
                    deliverResults(r, r.pendingResults);
                    r.pendingResults = null;
                } 
                r.activity.performResume();
                EventLog.writeEvent(LOG_ON_RESUME_CALLED,
                        r.activity.getComponentName().getClassName());
                r.paused = false;
                r.stopped = false;
                r.state = null;
            } 
            catch (Exception e)
            {
                {
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_1796641519 = (!mInstrumentation.onException(r.activity, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to resume activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_379987322 = r;
        addTaint(token.getTaint());
        addTaint(clearHide);
        varB4EAC82CA7396A68D541C85D26508E83_379987322.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_379987322;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.849 -0400", hash_original_method = "3389EE310594E6487CC378BBAF5D49AF", hash_generated_method = "EDD4A62328331413BEDBCC03BF62E7CD")
    final void cleanUpPendingRemoveWindows(ActivityClientRecord r) {
        {
            r.mPendingRemoveWindowManager.removeViewImmediate(r.mPendingRemoveWindow);
            IBinder wtoken = r.mPendingRemoveWindow.getWindowToken();
            {
                WindowManagerImpl.getDefault().closeAll(wtoken,
                        r.activity.getClass().getName(), "Activity");
            } 
        } 
        r.mPendingRemoveWindow = null;
        r.mPendingRemoveWindowManager = null;
        addTaint(r.getTaint());
        
        
            
            
            
                
                        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.851 -0400", hash_original_method = "E7E626438598608F65C9E3AAFD52E1D3", hash_generated_method = "D1A83E930996BDA567580C78DF0FD3A6")
    final void handleResumeActivity(IBinder token, boolean clearHide, boolean isForward) {
        unscheduleGcIdler();
        ActivityClientRecord r = performResumeActivity(token, clearHide);
        {
            final Activity a = r.activity;
            int forwardBit;
            forwardBit = WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION;
            forwardBit = 0;
            boolean willBeVisible = !a.mStartedActivity;
            {
                try 
                {
                    willBeVisible = ActivityManagerNative.getDefault().willActivityBeVisible(
                            a.getActivityToken());
                } 
                catch (RemoteException e)
                { }
            } 
            {
                r.window = r.activity.getWindow();
                View decor = r.window.getDecorView();
                decor.setVisibility(View.INVISIBLE);
                ViewManager wm = a.getWindowManager();
                WindowManager.LayoutParams l = r.window.getAttributes();
                a.mDecor = decor;
                l.type = WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
                l.softInputMode |= forwardBit;
                {
                    a.mWindowAdded = true;
                    wm.addView(decor, l);
                } 
            } 
            {
                r.hideForNow = true;
            } 
            cleanUpPendingRemoveWindows(r);
            {
                {
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } 
                WindowManager.LayoutParams l = r.window.getAttributes();
                {
                    l.softInputMode = (l.softInputMode
                            & (~WindowManager.LayoutParams.SOFT_INPUT_IS_FORWARD_NAVIGATION))
                            | forwardBit;
                    {
                        ViewManager wm = a.getWindowManager();
                        View decor = r.window.getDecorView();
                        wm.updateViewLayout(decor, l);
                    } 
                } 
                r.activity.mVisibleFromServer = true;
                {
                    r.activity.makeVisible();
                } 
            } 
            {
                r.nextIdle = mNewActivities;
                mNewActivities = r;
                Looper.myQueue().addIdleHandler(new Idler());
            } 
            r.onlyLocalRequest = false;
        } 
        {
            try 
            {
                ActivityManagerNative.getDefault()
                    .finishActivity(token, Activity.RESULT_CANCELED, null);
            } 
            catch (RemoteException ex)
            { }
        } 
        addTaint(token.getTaint());
        addTaint(clearHide);
        addTaint(isForward);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.855 -0400", hash_original_method = "DA54714D7ABECA1149DF2EBB4CB12B75", hash_generated_method = "A7A6AD746FF4E30FDC086ACEF0C28DD2")
    private Bitmap createThumbnailBitmap(ActivityClientRecord r) {
        Bitmap varB4EAC82CA7396A68D541C85D26508E83_1234503977 = null; 
        Bitmap thumbnail = mAvailThumbnailBitmap;
        try 
        {
            {
                int w = mThumbnailWidth;
                int h;
                {
                    Resources res = r.activity.getResources();
                    mThumbnailHeight = h =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_height);
                    mThumbnailWidth = w =
                        res.getDimensionPixelSize(com.android.internal.R.dimen.thumbnail_width);
                } 
                {
                    h = mThumbnailHeight;
                } 
                {
                    thumbnail = Bitmap.createBitmap(w, h, THUMBNAIL_FORMAT);
                    thumbnail.eraseColor(0);
                } 
            } 
            {
                Canvas cv = mThumbnailCanvas;
                {
                    mThumbnailCanvas = cv = new Canvas();
                } 
                cv.setBitmap(thumbnail);
                {
                    boolean varCCF6BFA25B9B33C500993008D9DBEDE9_1438623494 = (!r.activity.onCreateThumbnail(thumbnail, cv));
                    {
                        mAvailThumbnailBitmap = thumbnail;
                        thumbnail = null;
                    } 
                } 
                cv.setBitmap(null);
            } 
        } 
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_113942053 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create thumbnail of "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } 
            } 
            thumbnail = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1234503977 = thumbnail;
        addTaint(r.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1234503977.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1234503977;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.856 -0400", hash_original_method = "E5BE16D2C462200A7B0F213AB5290C46", hash_generated_method = "91A81802760B58EE5DD9F776FDCBEC52")
    private void handlePauseActivity(IBinder token, boolean finished,
            boolean userLeaving, int configChanges) {
        ActivityClientRecord r = mActivities.get(token);
        {
            {
                performUserLeavingActivity(r);
            } 
            r.activity.mConfigChangeFlags |= configChanges;
            performPauseActivity(token, finished, r.isPreHoneycomb());
            {
                boolean varC0947985E80A11FEDC8508BAA28B8037_159269267 = (r.isPreHoneycomb());
                {
                    QueuedWork.waitToFinish();
                } 
            } 
            try 
            {
                ActivityManagerNative.getDefault().activityPaused(token);
            } 
            catch (RemoteException ex)
            { }
        } 
        addTaint(token.getTaint());
        addTaint(finished);
        addTaint(userLeaving);
        addTaint(configChanges);
        
        
        
            
                
            
            
            
            
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.857 -0400", hash_original_method = "E51B505D442E84A2F592A34137ABD72B", hash_generated_method = "69B5AEACF21357C47F1820277D206195")
    final void performUserLeavingActivity(ActivityClientRecord r) {
        mInstrumentation.callActivityOnUserLeaving(r.activity);
        addTaint(r.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.859 -0400", hash_original_method = "2E97B5DEF88E402FCA1661B4F9DB23CB", hash_generated_method = "81D80E82B5F68D871799306CF3FDAE0C")
    final Bundle performPauseActivity(IBinder token, boolean finished,
            boolean saveState) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1130102590 = null; 
        ActivityClientRecord r = mActivities.get(token);
        varB4EAC82CA7396A68D541C85D26508E83_1130102590 = r != null ? performPauseActivity(r, finished, saveState) : null;
        addTaint(token.getTaint());
        addTaint(finished);
        addTaint(saveState);
        varB4EAC82CA7396A68D541C85D26508E83_1130102590.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1130102590;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.861 -0400", hash_original_method = "48F314FABF09550D34AFCF3A61EA40AB", hash_generated_method = "7E3C90D2F98F81AC1C075AD85C47CBF8")
    final Bundle performPauseActivity(ActivityClientRecord r, boolean finished,
            boolean saveState) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1717482095 = null; 
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1916431359 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1717482095 = null;
            } 
            RuntimeException e = new RuntimeException(
                    "Performing pause of activity that is not resumed: "
                    + r.intent.getComponent().toShortString());
        } 
        Bundle state = null;
        {
            r.activity.mFinished = true;
        } 
        try 
        {
            {
                state = new Bundle();
                state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                r.state = state;
            } 
            r.activity.mCalled = false;
            mInstrumentation.callActivityOnPause(r.activity);
            EventLog.writeEvent(LOG_ON_PAUSE_CALLED, r.activity.getComponentName().getClassName());
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                    "Activity " + r.intent.getComponent().toShortString() +
                    " did not call through to super.onPause()");
            } 
        } 
        catch (SuperNotCalledException e)
        {
            if (DroidSafeAndroidRuntime.control) throw e;
        } 
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_1100852018 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to pause activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } 
            } 
        } 
        r.paused = true;
        ArrayList<OnActivityPausedListener> listeners;
        {
            listeners = mOnPauseListeners.remove(r.activity);
        } 
        int size = (listeners != null ? listeners.size() : 0);
        {
            int i = 0;
            {
                listeners.get(i).onPaused(r.activity);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1916431359 = state;
        addTaint(r.getTaint());
        addTaint(finished);
        addTaint(saveState);
        Bundle varA7E53CE21691AB073D9660D615818899_2034265763; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2034265763 = varB4EAC82CA7396A68D541C85D26508E83_1717482095;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2034265763 = varB4EAC82CA7396A68D541C85D26508E83_1916431359;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2034265763.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2034265763;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.862 -0400", hash_original_method = "16A67002319514C641569BB2AD572A0E", hash_generated_method = "37993B1B4A0BE10C22AD3DAC88F9ED68")
    final void performStopActivity(IBinder token, boolean saveState) {
        ActivityClientRecord r = mActivities.get(token);
        performStopActivityInner(r, null, false, saveState);
        addTaint(token.getTaint());
        addTaint(saveState);
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.865 -0400", hash_original_method = "9D7845EB7E019C62C91AEEFF3F12D0E4", hash_generated_method = "4DE611FB6E0C44B6377EFF198B6476C8")
    private void performStopActivityInner(ActivityClientRecord r,
            StopInfo info, boolean keepShown, boolean saveState) {
        Bundle state = null;
        {
            {
                RuntimeException e = new RuntimeException(
                        "Performing stop of activity that is not resumed: "
                        + r.intent.getComponent().toShortString());
            } 
            {
                try 
                {
                    info.thumbnail = null;
                    info.description = r.activity.onCreateDescription();
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1376397119 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to save state of activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
            } 
            {
                {
                    state = new Bundle();
                    state.setAllowFds(false);
                    mInstrumentation.callActivityOnSaveInstanceState(r.activity, state);
                    r.state = state;
                } 
                {
                    state = r.state;
                } 
            } 
            {
                try 
                {
                    r.activity.performStop();
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_477272047 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
                r.stopped = true;
            } 
            r.paused = true;
        } 
        addTaint(r.getTaint());
        addTaint(info.getTaint());
        addTaint(keepShown);
        addTaint(saveState);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.867 -0400", hash_original_method = "A6B6099E264273A69E686CA5F8880A0F", hash_generated_method = "7E593485314D79481D99D3479C956E63")
    private void updateVisibility(ActivityClientRecord r, boolean show) {
        View v = r.activity.mDecor;
        {
            {
                {
                    r.activity.mVisibleFromServer = true;
                    {
                        r.activity.makeVisible();
                    } 
                } 
                {
                    performConfigurationChanged(r.activity, r.newConfig);
                    r.newConfig = null;
                } 
            } 
            {
                {
                    r.activity.mVisibleFromServer = false;
                    v.setVisibility(View.INVISIBLE);
                } 
            } 
        } 
        addTaint(r.getTaint());
        addTaint(show);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.868 -0400", hash_original_method = "5B5FF681D8D2131B5D84BD48CB5679C6", hash_generated_method = "C97443914D7666DCF3BD452B6893D2DA")
    private void handleStopActivity(IBinder token, boolean show, int configChanges) {
        ActivityClientRecord r = mActivities.get(token);
        r.activity.mConfigChangeFlags |= configChanges;
        StopInfo info = new StopInfo();
        performStopActivityInner(r, info, show, true);
        updateVisibility(r, show);
        {
            boolean varF98050B23FC967ED8AC6A2F93F8DF261_1286881057 = (!r.isPreHoneycomb());
            {
                QueuedWork.waitToFinish();
            } 
        } 
        try 
        {
            ActivityManagerNative.getDefault().activityStopped(
                r.token, r.state, info.thumbnail, info.description);
        } 
        catch (RemoteException ex)
        { }
        addTaint(token.getTaint());
        addTaint(show);
        addTaint(configChanges);
        
        
        
        
        
        
            
            
        
        
            
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.869 -0400", hash_original_method = "F0D1B8DFE218B8E130C145F907A20AA2", hash_generated_method = "69EE498DAD2810B362BE2AF5B9150062")
    final void performRestartActivity(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        {
            r.activity.performRestart();
            r.stopped = false;
        } 
        addTaint(token.getTaint());
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.870 -0400", hash_original_method = "6AC1F9C414377243EFD072AEBA5D0138", hash_generated_method = "954F11ACB6771689F169E8010F96644F")
    private void handleWindowVisibility(IBinder token, boolean show) {
        ActivityClientRecord r = mActivities.get(token);
        {
            performStopActivityInner(r, null, show, false);
        } 
        {
            unscheduleGcIdler();
            r.activity.performRestart();
            r.stopped = false;
        } 
        {
            updateVisibility(r, show);
        } 
        addTaint(token.getTaint());
        addTaint(show);
        
        
        
            
            
        
        
            
        
            
            
            
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.871 -0400", hash_original_method = "EAD4881422CEC6751FCD8576FDC7454E", hash_generated_method = "BB485DDB74EE5C2D587B2941A32635BB")
    private void handleSleeping(IBinder token, boolean sleeping) {
        ActivityClientRecord r = mActivities.get(token);
        {
            {
                boolean var90CCE8F8E1AD80CE3C0937C3672DBEB8_1801446743 = (!r.stopped && !r.isPreHoneycomb());
                {
                    try 
                    {
                        r.activity.performStop();
                    } 
                    catch (Exception e)
                    {
                        {
                            boolean varACA7CC68DADC2688CDBF4B35E8827724_1351817473 = (!mInstrumentation.onException(r.activity, e));
                            {
                                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                            } 
                        } 
                    } 
                    r.stopped = true;
                } 
            } 
            {
                boolean varC7408144C59FFB3C551D3072EB04F87F_1975221998 = (!r.isPreHoneycomb());
                {
                    QueuedWork.waitToFinish();
                } 
            } 
            try 
            {
                ActivityManagerNative.getDefault().activitySlept(r.token);
            } 
            catch (RemoteException ex)
            { }
        } 
        {
            {
                r.activity.performRestart();
                r.stopped = false;
            } 
        } 
        addTaint(token.getTaint());
        addTaint(sleeping);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.872 -0400", hash_original_method = "E4614A97277DCEBAE71CAB13BCF3AEA6", hash_generated_method = "4309DE4D4EAD7AE9AC86B020D9DAC4E6")
    private void handleSetCoreSettings(Bundle coreSettings) {
        {
            mCoreSettings = coreSettings;
        } 
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.873 -0400", hash_original_method = "CFE517344EE2BFA081F85835A58153DF", hash_generated_method = "05A1A4F18F78CEA7E3AB34C2E6E25939")
    private void handleUpdatePackageCompatibilityInfo(UpdateCompatibilityData data) {
        LoadedApk apk = peekPackageInfo(data.pkg, false);
        {
            apk.mCompatibilityInfo.set(data.info);
        } 
        apk = peekPackageInfo(data.pkg, true);
        {
            apk.mCompatibilityInfo.set(data.info);
        } 
        handleConfigurationChanged(mConfiguration, data.info);
        WindowManagerImpl.getDefault().reportNewConfiguration(mConfiguration);
        addTaint(data.getTaint());
        
        
        
            
        
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.874 -0400", hash_original_method = "02C0B6EC41B1BF345DD1D4B6B6C7E1EA", hash_generated_method = "262B536959A65C66F1B22E467C474FEF")
    private void deliverResults(ActivityClientRecord r, List<ResultInfo> results) {
        final int N = results.size();
        {
            int i = 0;
            {
                ResultInfo ri = results.get(i);
                try 
                {
                    {
                        ri.mData.setExtrasClassLoader(r.activity.getClassLoader());
                    } 
                    r.activity.dispatchActivityResult(ri.mResultWho,
                        ri.mRequestCode, ri.mResultCode, ri.mData);
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1465335281 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Failure delivering result " + ri + " to activity "
                            + r.intent.getComponent().toShortString()
                            + ": " + e.toString(), e);
                        } 
                    } 
                } 
            } 
        } 
        addTaint(r.getTaint());
        addTaint(results.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.877 -0400", hash_original_method = "132B22472693443B534F2F702D692F04", hash_generated_method = "0F6CE6D9F2573EE178B6F27F539E88AB")
    private void handleSendResult(ResultData res) {
        ActivityClientRecord r = mActivities.get(res.token);
        {
            final boolean resumed = !r.paused;
            {
                updateVisibility(r, true);
            } 
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
                    } 
                } 
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1779611509 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
            } 
            deliverResults(r, res.results);
            {
                r.activity.performResume();
                r.activity.mTemporaryPause = false;
            } 
        } 
        addTaint(res.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.878 -0400", hash_original_method = "44788E1192B2AF3D6F2EAE0CA2032491", hash_generated_method = "13516436A062DF888A50692A16065C90")
    public final ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_1970847228 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1970847228 = performDestroyActivity(token, finishing, 0, false);
        addTaint(token.getTaint());
        addTaint(finishing);
        varB4EAC82CA7396A68D541C85D26508E83_1970847228.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1970847228;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.881 -0400", hash_original_method = "C0523473C414844F9752EDA7A2CAF03B", hash_generated_method = "0F84D1015CDA959BF966A640EE774E96")
    private ActivityClientRecord performDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        ActivityClientRecord varB4EAC82CA7396A68D541C85D26508E83_1206979381 = null; 
        ActivityClientRecord r = mActivities.get(token);
        Class activityClass = null;
        {
            activityClass = r.activity.getClass();
            r.activity.mConfigChangeFlags |= configChanges;
            {
                r.activity.mFinished = true;
            } 
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
                    } 
                } 
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_283837205 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to pause activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
                r.paused = true;
            } 
            {
                try 
                {
                    r.activity.performStop();
                } 
                catch (SuperNotCalledException e)
                {
                    if (DroidSafeAndroidRuntime.control) throw e;
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_1120077331 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to stop activity "
                                + safeToComponentShortString(r.intent)
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
                r.stopped = true;
            } 
            {
                try 
                {
                    r.lastNonConfigurationInstances
                            = r.activity.retainNonConfigurationInstances();
                } 
                catch (Exception e)
                {
                    {
                        boolean varEA1D939B58A63BB32FD749EB4AA2F837_425160213 = (!mInstrumentation.onException(r.activity, e));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                                "Unable to retain activity "
                                + r.intent.getComponent().toShortString()
                                + ": " + e.toString(), e);
                        } 
                    } 
                } 
            } 
            try 
            {
                r.activity.mCalled = false;
                mInstrumentation.callActivityOnDestroy(r.activity);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                        "Activity " + safeToComponentShortString(r.intent) +
                        " did not call through to super.onDestroy()");
                } 
                {
                    r.window.closeAllPanels();
                } 
            } 
            catch (SuperNotCalledException e)
            {
                if (DroidSafeAndroidRuntime.control) throw e;
            } 
            catch (Exception e)
            {
                {
                    boolean varD013D528769EFE2104C5EEE0E7D0F03F_195478270 = (!mInstrumentation.onException(r.activity, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to destroy activity " + safeToComponentShortString(r.intent)
                            + ": " + e.toString(), e);
                    } 
                } 
            } 
        } 
        mActivities.remove(token);
        StrictMode.decrementExpectedActivityCount(activityClass);
        varB4EAC82CA7396A68D541C85D26508E83_1206979381 = r;
        addTaint(token.getTaint());
        addTaint(finishing);
        addTaint(configChanges);
        addTaint(getNonConfigInstance);
        varB4EAC82CA7396A68D541C85D26508E83_1206979381.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1206979381;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    private static String safeToComponentShortString(Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? "[Unknown]" : component.toShortString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.883 -0400", hash_original_method = "FF5883360F029BC934513AEE9A22C396", hash_generated_method = "F10691A19EBB36061E626623079F2EF3")
    private void handleDestroyActivity(IBinder token, boolean finishing,
            int configChanges, boolean getNonConfigInstance) {
        ActivityClientRecord r = performDestroyActivity(token, finishing,
                configChanges, getNonConfigInstance);
        {
            cleanUpPendingRemoveWindows(r);
            WindowManager wm = r.activity.getWindowManager();
            View v = r.activity.mDecor;
            {
                IBinder wtoken = v.getWindowToken();
                {
                    {
                        r.mPendingRemoveWindow = v;
                        r.mPendingRemoveWindowManager = wm;
                    } 
                    {
                        wm.removeViewImmediate(v);
                    } 
                } 
                {
                    WindowManagerImpl.getDefault().closeAll(wtoken,
                            r.activity.getClass().getName(), "Activity");
                } 
                r.activity.mDecor = null;
            } 
            {
                WindowManagerImpl.getDefault().closeAll(token,
                        r.activity.getClass().getName(), "Activity");
            } 
            Context c = r.activity.getBaseContext();
            {
                ((ContextImpl) c).scheduleFinalCleanup(
                        r.activity.getClass().getName(), "Activity");
            } 
        } 
        {
            try 
            {
                ActivityManagerNative.getDefault().activityDestroyed(token);
            } 
            catch (RemoteException ex)
            { }
        } 
        addTaint(token.getTaint());
        addTaint(finishing);
        addTaint(configChanges);
        addTaint(getNonConfigInstance);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.886 -0400", hash_original_method = "A011A63AC4A3DA99018317E87A8885A6", hash_generated_method = "232D823E49EB662F101C4944685792F3")
    public final void requestRelaunchActivity(IBinder token,
            List<ResultInfo> pendingResults, List<Intent> pendingNewIntents,
            int configChanges, boolean notResumed, Configuration config,
            boolean fromServer) {
        ActivityClientRecord target = null;
        {
            {
                int i = 0;
                boolean varA731E4137509ACE9A9EB058DA6597B93_1032080126 = (i<mRelaunchingActivities.size());
                {
                    ActivityClientRecord r = mRelaunchingActivities.get(i);
                    {
                        target = r;
                        {
                            {
                                r.pendingResults.addAll(pendingResults);
                            } 
                            {
                                r.pendingResults = pendingResults;
                            } 
                        } 
                        {
                            {
                                r.pendingIntents.addAll(pendingNewIntents);
                            } 
                            {
                                r.pendingIntents = pendingNewIntents;
                            } 
                        } 
                    } 
                } 
            } 
            {
                target = new ActivityClientRecord();
                target.token = token;
                target.pendingResults = pendingResults;
                target.pendingIntents = pendingNewIntents;
                {
                    ActivityClientRecord existing = mActivities.get(token);
                    {
                        target.startsNotResumed = existing.paused;
                    } 
                    target.onlyLocalRequest = true;
                } 
                mRelaunchingActivities.add(target);
                queueOrSendMessage(H.RELAUNCH_ACTIVITY, target);
            } 
            {
                target.startsNotResumed = notResumed;
                target.onlyLocalRequest = false;
            } 
            {
                target.createdConfig = config;
            } 
            target.pendingConfigChanges |= configChanges;
        } 
        addTaint(token.getTaint());
        addTaint(pendingResults.getTaint());
        addTaint(pendingNewIntents.getTaint());
        addTaint(configChanges);
        addTaint(notResumed);
        addTaint(config.getTaint());
        addTaint(fromServer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.889 -0400", hash_original_method = "BE5C8E93A13CCFB0B92460FEFD999D51", hash_generated_method = "B4E12C47EC8CAF2F555A4E62C6D496E2")
    private void handleRelaunchActivity(ActivityClientRecord tmp) {
        unscheduleGcIdler();
        Configuration changedConfig = null;
        int configChanges = 0;
        {
            int N = mRelaunchingActivities.size();
            IBinder token = tmp.token;
            tmp = null;
            {
                int i = 0;
                {
                    ActivityClientRecord r = mRelaunchingActivities.get(i);
                    {
                        tmp = r;
                        configChanges |= tmp.pendingConfigChanges;
                        mRelaunchingActivities.remove(i);
                    } 
                } 
            } 
            {
                changedConfig = mPendingConfiguration;
                mPendingConfiguration = null;
            } 
        } 
        {
            {
                boolean var0FC6F86F9662A446DFA38F41BE5B339F_279442550 = (mConfiguration == null
                    || (tmp.createdConfig.isOtherSeqNewer(mConfiguration)
                            && mConfiguration.diff(tmp.createdConfig) != 0));
                {
                    {
                        boolean var1F3B64B07ED4C1BD68FE8B6CE0CE3159_549436591 = (changedConfig == null
                        || tmp.createdConfig.isOtherSeqNewer(changedConfig));
                        {
                            changedConfig = tmp.createdConfig;
                        } 
                    } 
                } 
            } 
        } 
        {
            handleConfigurationChanged(changedConfig, null);
        } 
        ActivityClientRecord r = mActivities.get(tmp.token);
        r.activity.mConfigChangeFlags |= configChanges;
        r.onlyLocalRequest = tmp.onlyLocalRequest;
        Intent currentIntent = r.activity.mIntent;
        r.activity.mChangingConfigurations = true;
        {
            performPauseActivity(r.token, false, r.isPreHoneycomb());
        } 
        {
            boolean var180BDEFD354F97351DFD30CDB936034A_2061408477 = (r.state == null && !r.stopped && !r.isPreHoneycomb());
            {
                r.state = new Bundle();
                r.state.setAllowFds(false);
                mInstrumentation.callActivityOnSaveInstanceState(r.activity, r.state);
            } 
        } 
        handleDestroyActivity(r.token, false, configChanges, true);
        r.activity = null;
        r.window = null;
        r.hideForNow = false;
        r.nextIdle = null;
        {
            {
                r.pendingResults = tmp.pendingResults;
            } 
            {
                r.pendingResults.addAll(tmp.pendingResults);
            } 
        } 
        {
            {
                r.pendingIntents = tmp.pendingIntents;
            } 
            {
                r.pendingIntents.addAll(tmp.pendingIntents);
            } 
        } 
        r.startsNotResumed = tmp.startsNotResumed;
        handleLaunchActivity(r, currentIntent);
        addTaint(tmp.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.890 -0400", hash_original_method = "D80F947211B8AA9FA3600ABD6DD9A5E5", hash_generated_method = "74098E51D5C72526A9F8B80D835A14FA")
    private void handleRequestThumbnail(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        Bitmap thumbnail = createThumbnailBitmap(r);
        CharSequence description = null;
        try 
        {
            description = r.activity.onCreateDescription();
        } 
        catch (Exception e)
        {
            {
                boolean varB0EB73057242B22D5F7630AAE18BE0D8_478676107 = (!mInstrumentation.onException(r.activity, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to create description of activity "
                        + r.intent.getComponent().toShortString()
                        + ": " + e.toString(), e);
                } 
            } 
        } 
        try 
        {
            ActivityManagerNative.getDefault().reportThumbnail(
                token, thumbnail, description);
        } 
        catch (RemoteException ex)
        { }
        addTaint(token.getTaint());
        
        
        
        
        
            
        
            
                
                        
                        
                        
            
        
        
            
                
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.892 -0400", hash_original_method = "FB356249739137DBEEC4A6A95AF7FF01", hash_generated_method = "1CA6C805A63BE5427316825675ED35FD")
     ArrayList<ComponentCallbacks2> collectComponentCallbacksLocked(
            boolean allActivities, Configuration newConfig) {
        ArrayList<ComponentCallbacks2> varB4EAC82CA7396A68D541C85D26508E83_651411773 = null; 
        ArrayList<ComponentCallbacks2> callbacks = new ArrayList<ComponentCallbacks2>();
        {
            boolean var861DB40CD6AE57E4F0E83CF55916E1AF_1708891313 = (mActivities.size() > 0);
            {
                Iterator<ActivityClientRecord> it = mActivities.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_2089689422 = (it.hasNext());
                    {
                        ActivityClientRecord ar = it.next();
                        Activity a = ar.activity;
                        {
                            Configuration thisConfig = applyConfigCompatMainThread(newConfig,
                            ar.packageInfo.mCompatibilityInfo.getIfNeeded());
                            {
                                callbacks.add(a);
                            } 
                            {
                                ar.newConfig = thisConfig;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            boolean var5A1C82E33C6D4B3400958A37BAFF4F9C_1349400804 = (mServices.size() > 0);
            {
                Iterator<Service> it = mServices.values().iterator();
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_565969676 = (it.hasNext());
                    {
                        callbacks.add(it.next());
                    } 
                } 
            } 
        } 
        {
            {
                boolean var164809B4E437753E4C2094F777B6EF33_1964364154 = (mLocalProviders.size() > 0);
                {
                    Iterator<ProviderClientRecord> it = mLocalProviders.values().iterator();
                    {
                        boolean var4CA2EDBF7D27138D75E73CCD01CCB025_54332357 = (it.hasNext());
                        {
                            callbacks.add(it.next().mLocalProvider);
                        } 
                    } 
                } 
            } 
        } 
        final int N = mAllApplications.size();
        {
            int i = 0;
            {
                callbacks.add(mAllApplications.get(i));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_651411773 = callbacks;
        addTaint(allActivities);
        addTaint(newConfig.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_651411773.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_651411773;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.894 -0400", hash_original_method = "EE8F576B02EBE8F159FE2A319294FB0B", hash_generated_method = "E8B258904158418511CDEBDA77ACA250")
    private final void performConfigurationChanged(
            ComponentCallbacks2 cb, Configuration config) {
        Activity activity;
        activity = (Activity) cb;
        activity = null;
        {
            activity.mCalled = false;
        } 
        boolean shouldChangeConfig = false;
        {
            shouldChangeConfig = true;
        } 
        {
            int diff = activity.mCurrentConfig.diff(config);
            {
                {
                    boolean varF0E6ABDF26E6C0B0FD2D021EE0A6E062_717839980 = ((~activity.mActivityInfo.getRealConfigChanged() & diff) == 0);
                    {
                        shouldChangeConfig = true;
                    } 
                } 
            } 
        } 
        {
            cb.onConfigurationChanged(config);
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException(
                            "Activity " + activity.getLocalClassName() +
                        " did not call through to super.onConfigurationChanged()");
                } 
                activity.mConfigChangeFlags = 0;
                activity.mCurrentConfig = new Configuration(config);
            } 
        } 
        addTaint(cb.getTaint());
        addTaint(config.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.896 -0400", hash_original_method = "7998F4E95C6128D4C656838AA6A46FDD", hash_generated_method = "9E04B811244F781CE0CEB408264E0F79")
    public final void applyConfigurationToResources(Configuration config) {
        {
            applyConfigurationToResourcesLocked(config, null);
        } 
        addTaint(config.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.897 -0400", hash_original_method = "EEF98A9F112FD55BEEF8F44AEC4B59F9", hash_generated_method = "B3A4C9D251AC10362C9F7C11FB196AB2")
    final boolean applyConfigurationToResourcesLocked(Configuration config,
            CompatibilityInfo compat) {
        {
            mResConfiguration = new Configuration();
        } 
        {
            boolean varDD88D6DA3508C081DB3FE4EFF9E62042_249565361 = (!mResConfiguration.isOtherSeqNewer(config) && compat == null);
        } 
        int changes = mResConfiguration.updateFrom(config);
        DisplayMetrics dm = getDisplayMetricsLocked(null, true);
        {
            boolean var389DB0238F3963595A3670D175566873_411096081 = (compat != null && (mResCompatibilityInfo == null ||
                !mResCompatibilityInfo.equals(compat)));
            {
                mResCompatibilityInfo = compat;
                changes |= ActivityInfo.CONFIG_SCREEN_LAYOUT
                    | ActivityInfo.CONFIG_SCREEN_SIZE
                    | ActivityInfo.CONFIG_SMALLEST_SCREEN_SIZE;
            } 
        } 
        {
            Locale.setDefault(config.locale);
        } 
        Resources.updateSystemConfiguration(config, dm, compat);
        ApplicationPackageManager.configurationChanged();
        Iterator<WeakReference<Resources>> it = mActiveResources.values().iterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_1241304644 = (it.hasNext());
            {
                WeakReference<Resources> v = it.next();
                Resources r = v.get();
                {
                    r.updateConfiguration(config, dm, compat);
                } 
                {
                    it.remove();
                } 
            } 
        } 
        addTaint(config.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1419881529 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1419881529;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.899 -0400", hash_original_method = "725924C293B055D0DF33B7EFFEB77D1D", hash_generated_method = "4CDAA47547EE1FA3C9C2971D4888F746")
    final Configuration applyCompatConfiguration() {
        Configuration varB4EAC82CA7396A68D541C85D26508E83_1154566447 = null; 
        Configuration config = mConfiguration;
        {
            mCompatConfiguration = new Configuration();
        } 
        mCompatConfiguration.setTo(mConfiguration);
        {
            boolean varC23E243EBF9A9F6453914CEF4EFB48AF_1128806680 = (mResCompatibilityInfo != null && !mResCompatibilityInfo.supportsScreen());
            {
                mResCompatibilityInfo.applyToConfiguration(mCompatConfiguration);
                config = mCompatConfiguration;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1154566447 = config;
        varB4EAC82CA7396A68D541C85D26508E83_1154566447.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1154566447;
        
        
        
            
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.901 -0400", hash_original_method = "113EE31E90E397ADB444BCE89226F34D", hash_generated_method = "344568F486D81A40CDA327B29E846180")
    final void handleConfigurationChanged(Configuration config, CompatibilityInfo compat) {
        ArrayList<ComponentCallbacks2> callbacks = null;
        {
            {
                {
                    boolean var7FB57B73DAED6E7419FC890952146106_1661224077 = (!mPendingConfiguration.isOtherSeqNewer(config));
                    {
                        config = mPendingConfiguration;
                    } 
                } 
                mPendingConfiguration = null;
            } 
            applyConfigurationToResourcesLocked(config, compat);
            {
                mConfiguration = new Configuration();
            } 
            {
                boolean var76764A772B13C26291B0BB9B4382DB3B_1015539201 = (!mConfiguration.isOtherSeqNewer(config) && compat == null);
            } 
            mConfiguration.updateFrom(config);
            config = applyCompatConfiguration();
            callbacks = collectComponentCallbacksLocked(false, config);
        } 
        WindowManagerImpl.getDefault().trimLocalMemory();
        {
            final int N = callbacks.size();
            {
                int i = 0;
                {
                    performConfigurationChanged(callbacks.get(i), config);
                } 
            } 
        } 
        addTaint(config.getTaint());
        addTaint(compat.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.901 -0400", hash_original_method = "BCC706E36DA945D7B18FA237C2CE8FDE", hash_generated_method = "60F2BABE5A8C15F6CCEAF2D6E2AF9944")
    final void handleActivityConfigurationChanged(IBinder token) {
        ActivityClientRecord r = mActivities.get(token);
        performConfigurationChanged(r.activity, mCompatConfiguration);
        addTaint(token.getTaint());
        
        
        
            
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.903 -0400", hash_original_method = "381D38D2D5D4A7D408E3117408C36DEC", hash_generated_method = "9E1B895545420413D21683FF197B4A0F")
    final void handleProfilerControl(boolean start, ProfilerControlData pcd, int profileType) {
        {
            try 
            {
                
                ViewDebug.startLooperProfiling(pcd.path, pcd.fd.getFileDescriptor());
                
                
                mProfiler.setProfiler(pcd.path, pcd.fd);
                
                
                mProfiler.autoStopProfiler = false;
                
                
                mProfiler.startProfiling();
                
            } 
            catch (RuntimeException e)
            { }
            finally 
            {
                try 
                {
                    pcd.fd.close();
                } 
                catch (IOException e)
                { }
            } 
        } 
        {
            
            ViewDebug.stopLooperProfiling();
            
            
            mProfiler.stopProfiling();
            
        } 
        addTaint(start);
        addTaint(pcd.getTaint());
        addTaint(profileType);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.904 -0400", hash_original_method = "34F4499A4B96EEF8A91ACC379A0CD361", hash_generated_method = "B32EC387A1CA21249D561868D95EED4F")
    final void handleDumpHeap(boolean managed, DumpHeapData dhd) {
        {
            try 
            {
                Debug.dumpHprofData(dhd.path, dhd.fd.getFileDescriptor());
            } 
            catch (IOException e)
            { }
            finally 
            {
                try 
                {
                    dhd.fd.close();
                } 
                catch (IOException e)
                { }
            } 
        } 
        {
            Debug.dumpNativeHeap(dhd.fd.getFileDescriptor());
        } 
        addTaint(managed);
        addTaint(dhd.getTaint());
        
        
            
                
            
                
                        
            
                
                    
                
                    
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.906 -0400", hash_original_method = "44425A5A4DA98E1612A84EA820E43FA0", hash_generated_method = "02D75BB0FBDBD5500C97BA03CD0F7B6E")
    final void handleDispatchPackageBroadcast(int cmd, String[] packages) {
        boolean hasPkgInfo = false;
        {
            {
                int i = packages.length-1;
                {
                    {
                        WeakReference<LoadedApk> ref;
                        ref = mPackages.get(packages[i]);
                        {
                            boolean var452303427881308C0907EF2BFCBFBC97_767918908 = (ref != null && ref.get() != null);
                            {
                                hasPkgInfo = true;
                            } 
                            {
                                ref = mResourcePackages.get(packages[i]);
                                {
                                    boolean var35FA527C419A116D546FBD420F0F02FA_1798142117 = (ref != null && ref.get() != null);
                                    {
                                        hasPkgInfo = true;
                                    } 
                                } 
                            } 
                        } 
                    } 
                    mPackages.remove(packages[i]);
                    mResourcePackages.remove(packages[i]);
                } 
            } 
        } 
        ApplicationPackageManager.handlePackageBroadcast(cmd, packages,
                hasPkgInfo);
        addTaint(cmd);
        addTaint(packages[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.907 -0400", hash_original_method = "A02231B2047F154A7A69F70A3ED846FE", hash_generated_method = "04AF746C488C80555A8F5360E26F6172")
    final void handleLowMemory() {
        ArrayList<ComponentCallbacks2> callbacks;
        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } 
        final int N = callbacks.size();
        {
            int i = 0;
            {
                callbacks.get(i).onLowMemory();
            } 
        } 
        {
            boolean var83DFAB275ACAE9E6E683928CEC618B77_284742266 = (Process.myUid() != Process.SYSTEM_UID);
            {
                int sqliteReleased = SQLiteDatabase.releaseMemory();
                EventLog.writeEvent(SQLITE_MEM_RELEASED_EVENT_LOG_TAG, sqliteReleased);
            } 
        } 
        Canvas.freeCaches();
        BinderInternal.forceGc("mem");
        
        
        
            
        
        
        
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.908 -0400", hash_original_method = "23BC0760ADA981D880A84DB7A1CF33BD", hash_generated_method = "E4A92E202A2264D14E92BA85DA868F46")
    final void handleTrimMemory(int level) {
        WindowManagerImpl.getDefault().trimMemory(level);
        ArrayList<ComponentCallbacks2> callbacks;
        {
            callbacks = collectComponentCallbacksLocked(true, null);
        } 
        final int N = callbacks.size();
        {
            int i = 0;
            {
                callbacks.get(i).onTrimMemory(level);
            } 
        } 
        addTaint(level);
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.909 -0400", hash_original_method = "E6BF73423380262DF6FF59682ACDE1E2", hash_generated_method = "958C1AB73A772EC55469611673298A31")
    private void setupGraphicsSupport(LoadedApk info) {
        try 
        {
            int uid = Process.myUid();
            String[] packages = getPackageManager().getPackagesForUid(uid);
            {
                ContextImpl appContext = new ContextImpl();
                appContext.init(info, null, this);
                HardwareRenderer.setupDiskCache(appContext.getCacheDir());
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(info.getTaint());
        
        
            
            
            
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.911 -0400", hash_original_method = "7EBE3C125D399FC9ADE021947462EA9C", hash_generated_method = "4A6D5CCFF6AEEEC38AFC1A9EB35EEEB7")
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
            Display display = WindowManagerImpl.getDefault().getDefaultDisplay();
            {
                boolean varF43CCBE6F4C0623498FA3D729EBA95BA_1744334626 = (!ActivityManager.isHighEndGfx(display));
                {
                    HardwareRenderer.disable(false);
                } 
            } 
        } 
        {
            mProfiler.startProfiling();
        } 
        {
            AsyncTask.setDefaultExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } 
        TimeZone.setDefault(null);
        Locale.setDefault(data.config.locale);
        applyConfigurationToResourcesLocked(data.config, data.compatInfo);
        applyCompatConfiguration();
        data.info = getPackageInfoNoCheck(data.appInfo, data.compatInfo);
        setupGraphicsSupport(data.info);
        {
            StrictMode.conditionallyEnableDebugLogging();
        } 
        {
            StrictMode.enableDeathOnNetwork();
        } 
        {
            Bitmap.setDefaultDensity(DisplayMetrics.DENSITY_DEFAULT);
        } 
        {
            Debug.changeDebugPort(8100);
            {
                IActivityManager mgr = ActivityManagerNative.getDefault();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, true);
                } 
                catch (RemoteException ex)
                { }
                Debug.waitForDebugger();
                try 
                {
                    mgr.showWaitingForDebugger(mAppThread, false);
                } 
                catch (RemoteException ex)
                { }
            } 
        } 
        IBinder b = ServiceManager.getService(Context.CONNECTIVITY_SERVICE);
        {
            IConnectivityManager service = IConnectivityManager.Stub.asInterface(b);
            try 
            {
                ProxyProperties proxyProperties = service.getProxy();
                Proxy.setHttpProxySystemProperty(proxyProperties);
            } 
            catch (RemoteException e)
            { }
        } 
        {
            ContextImpl appContext = new ContextImpl();
            appContext.init(data.info, null, this);
            InstrumentationInfo ii = null;
            try 
            {
                ii = appContext.getPackageManager().
                    getInstrumentationInfo(data.instrumentationName, 0);
            } 
            catch (PackageManager.NameNotFoundException e)
            { }
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
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
            try 
            {
                java.lang.ClassLoader cl = instrContext.getClassLoader();
                mInstrumentation = (Instrumentation)
                    cl.loadClass(data.instrumentationName.getClassName()).newInstance();
            } 
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to instantiate instrumentation "
                    + data.instrumentationName + ": " + e.toString(), e);
            } 
            mInstrumentation.init(this, instrContext, appContext,
                    new ComponentName(ii.packageName, ii.name), data.instrumentationWatcher);
            {
                mProfiler.handlingProfiling = true;
                File file = new File(mProfiler.profileFile);
                file.getParentFile().mkdirs();
                Debug.startMethodTracing(file.toString(), 8 * 1024 * 1024);
            } 
            try 
            {
                mInstrumentation.onCreate(data.instrumentationArgs);
            } 
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Exception thrown in onCreate() of "
                    + data.instrumentationName + ": " + e.toString(), e);
            } 
        } 
        {
            mInstrumentation = new Instrumentation();
        } 
        {
            dalvik.system.VMRuntime.getRuntime().clearGrowthLimit();
        } 
        Application app = data.info.makeApplication(data.restrictedBackupMode, null);
        mInitialApplication = app;
        {
            List<ProviderInfo> providers = data.providers;
            {
                installContentProviders(app, providers);
                mH.sendEmptyMessageDelayed(H.ENABLE_JIT, 10*1000);
            } 
        } 
        try 
        {
            mInstrumentation.callApplicationOnCreate(app);
        } 
        catch (Exception e)
        {
            {
                boolean var99DF702C0466DA8314007B6FFD566CCC_418421979 = (!mInstrumentation.onException(app, e));
                {
                    if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                    "Unable to create application " + app.getClass().getName()
                    + ": " + e.toString(), e);
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.912 -0400", hash_original_method = "87522E170C98EEC17A950D0CB0F18A7D", hash_generated_method = "338A4196918C2A22CF447025D240C23E")
    final void finishInstrumentation(int resultCode, Bundle results) {
        IActivityManager am = ActivityManagerNative.getDefault();
        {
            Debug.stopMethodTracing();
        } 
        try 
        {
            am.finishInstrumentation(mAppThread, resultCode, results);
        } 
        catch (RemoteException ex)
        { }
        addTaint(resultCode);
        addTaint(results.getTaint());
        
        
        
                
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.914 -0400", hash_original_method = "E6307225A7BED03273D5285E74D77996", hash_generated_method = "498B6631EE5C8A2C8390AA54401BA45B")
    private void installContentProviders(
            Context context, List<ProviderInfo> providers) {
        final ArrayList<IActivityManager.ContentProviderHolder> results = new ArrayList<IActivityManager.ContentProviderHolder>();
        Iterator<ProviderInfo> i = providers.iterator();
        {
            boolean var1611849CD1EE22EA22E4E7E3327E2E35_1707857889 = (i.hasNext());
            {
                ProviderInfo cpi = i.next();
                StringBuilder buf = new StringBuilder(128);
                buf.append("Pub ");
                buf.append(cpi.authority);
                buf.append(": ");
                buf.append(cpi.name);
                IContentProvider cp = installProvider(context, null, cpi,
                    false , true );
                {
                    IActivityManager.ContentProviderHolder cph = new IActivityManager.ContentProviderHolder(cpi);
                    cph.provider = cp;
                    cph.noReleaseNeeded = true;
                    results.add(cph);
                } 
            } 
        } 
        try 
        {
            ActivityManagerNative.getDefault().publishContentProviders(
                getApplicationThread(), results);
        } 
        catch (RemoteException ex)
        { }
        addTaint(context.getTaint());
        addTaint(providers.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.917 -0400", hash_original_method = "F88C15CE4CC55ECD0AF9CC176F41EB20", hash_generated_method = "8D54889017F26BCC1DCEE5F095ACD8F8")
    public final IContentProvider acquireProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_875481475 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_2090697879 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_808091416 = null; 
        IContentProvider provider = acquireExistingProvider(c, name);
        {
            varB4EAC82CA7396A68D541C85D26508E83_875481475 = provider;
        } 
        IActivityManager.ContentProviderHolder holder = null;
        try 
        {
            holder = ActivityManagerNative.getDefault().getContentProvider(
                    getApplicationThread(), name);
        } 
        catch (RemoteException ex)
        { }
        {
            varB4EAC82CA7396A68D541C85D26508E83_2090697879 = null;
        } 
        provider = installProvider(c, holder.provider, holder.info,
                true , holder.noReleaseNeeded);
        {
            try 
            {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), name);
            } 
            catch (RemoteException ex)
            { }
        } 
        varB4EAC82CA7396A68D541C85D26508E83_808091416 = provider;
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_124006302; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_124006302 = varB4EAC82CA7396A68D541C85D26508E83_875481475;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_124006302 = varB4EAC82CA7396A68D541C85D26508E83_2090697879;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_124006302 = varB4EAC82CA7396A68D541C85D26508E83_808091416;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_124006302.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_124006302;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.919 -0400", hash_original_method = "D0EC607B4605DB37ABCB0EC4802499DE", hash_generated_method = "5F224528AD54ECC27AA426282C99B066")
    public final IContentProvider acquireExistingProvider(Context c, String name) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_729488451 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_176802964 = null; 
        {
            ProviderClientRecord pr = mProviderMap.get(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_729488451 = null;
            } 
            IContentProvider provider = pr.mProvider;
            IBinder jBinder = provider.asBinder();
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            {
                prc.count += 1;
                {
                    mH.removeMessages(H.REMOVE_PROVIDER, provider);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_176802964 = provider;
        } 
        addTaint(c.getTaint());
        addTaint(name.getTaint());
        IContentProvider varA7E53CE21691AB073D9660D615818899_358842786; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_358842786 = varB4EAC82CA7396A68D541C85D26508E83_729488451;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_358842786 = varB4EAC82CA7396A68D541C85D26508E83_176802964;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_358842786.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_358842786;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.920 -0400", hash_original_method = "570D24C9467F1DF00A050F1BB22169F2", hash_generated_method = "F3A186BCA8B3DC369F8EE013AAFDD77A")
    public final boolean releaseProvider(IContentProvider provider) {
        IBinder jBinder = provider.asBinder();
        {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            prc.count -= 1;
            {
                Message msg = mH.obtainMessage(H.REMOVE_PROVIDER, provider);
                mH.sendMessage(msg);
            } 
        } 
        addTaint(provider.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_878186825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_878186825;
        
        
            
        
        
        
            
            
                
            
            
                
                
            
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.921 -0400", hash_original_method = "26DD2496F7761FB77064EC4900EC6CC4", hash_generated_method = "E41899AC8BDEB3458A8FE375D81C4FD1")
    final void completeRemoveProvider(IContentProvider provider) {
        IBinder jBinder = provider.asBinder();
        String remoteProviderName = null;
        {
            ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
            mProviderRefCountMap.remove(jBinder);
            Iterator<ProviderClientRecord> iter = mProviderMap.values().iterator();
            {
                boolean var8492AE2C695A56B730381A28B8BA3F6D_559170143 = (iter.hasNext());
                {
                    ProviderClientRecord pr = iter.next();
                    IBinder myBinder = pr.mProvider.asBinder();
                    {
                        iter.remove();
                        {
                            myBinder.unlinkToDeath(pr, 0);
                            {
                                remoteProviderName = pr.mName;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            try 
            {
                ActivityManagerNative.getDefault().removeContentProvider(
                        getApplicationThread(), remoteProviderName);
            } 
            catch (RemoteException e)
            { }
        } 
        addTaint(provider.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.922 -0400", hash_original_method = "89FC0B7C2EBDC1E0BBDB9AF687772CD2", hash_generated_method = "176495CB5E255E4CCF0C6209B8F2DEE6")
    final void removeDeadProvider(String name, IContentProvider provider) {
        {
            ProviderClientRecord pr = mProviderMap.get(name);
            {
                boolean var966307558E067A018FA6F5C432EE1917_374000990 = (pr != null && pr.mProvider.asBinder() == provider.asBinder());
                {
                    ProviderClientRecord removed = mProviderMap.remove(name);
                    {
                        removed.mProvider.asBinder().unlinkToDeath(removed, 0);
                    } 
                } 
            } 
        } 
        addTaint(name.getTaint());
        addTaint(provider.getTaint());
        
        
            
            
                
                
                
                    
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.929 -0400", hash_original_method = "54C9C23E13579DED3FD2406679DE4E02", hash_generated_method = "7324C8347CBB36CB570C9AB090C618D3")
    private IContentProvider installProvider(Context context,
            IContentProvider provider, ProviderInfo info,
            boolean noisy, boolean noReleaseNeeded) {
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_73719834 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_921433628 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_687724995 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1051146569 = null; 
        IContentProvider varB4EAC82CA7396A68D541C85D26508E83_576426400 = null; 
        ContentProvider localProvider = null;
        {
            {
                Slog.d(TAG, "Loading provider " + info.authority + ": "
                        + info.name);
            } 
            Context c = null;
            ApplicationInfo ai = info.applicationInfo;
            {
                boolean var91DE5B59D8254FD2545D30D7F711FB97_1010110305 = (context.getPackageName().equals(ai.packageName));
                {
                    c = context;
                } 
                {
                    boolean varBB822C07A468461CB214A3B461BD724D_2080733700 = (mInitialApplication != null &&
                    mInitialApplication.getPackageName().equals(ai.packageName));
                    {
                        c = mInitialApplication;
                    } 
                    {
                        try 
                        {
                            c = context.createPackageContext(ai.packageName,
                            Context.CONTEXT_INCLUDE_CODE);
                        } 
                        catch (PackageManager.NameNotFoundException e)
                        { }
                    } 
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_73719834 = null;
            } 
            try 
            {
                final java.lang.ClassLoader cl = c.getClassLoader();
                localProvider = (ContentProvider)cl.
                    loadClass(info.name).newInstance();
                provider = localProvider.getIContentProvider();
                {
                    varB4EAC82CA7396A68D541C85D26508E83_921433628 = null;
                } 
                localProvider.attachInfo(c, info);
            } 
            catch (java.lang.Exception e)
            {
                {
                    boolean varFB4F174495DD0F0FC2F116EBF5523752_1099889821 = (!mInstrumentation.onException(null, e));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                            "Unable to get provider " + info.name
                            + ": " + e.toString(), e);
                    } 
                } 
                varB4EAC82CA7396A68D541C85D26508E83_687724995 = null;
            } 
        } 
        {
            IBinder jBinder = provider.asBinder();
            String names[] = PATTERN_SEMICOLON.split(info.authority);
            {
                int i = 0;
                {
                    ProviderClientRecord pr = mProviderMap.get(names[i]);
                    {
                        provider = pr.mProvider;
                    } 
                    {
                        pr = new ProviderClientRecord(names[i], provider, localProvider);
                        {
                            try 
                            {
                                jBinder.linkToDeath(pr, 0);
                            } 
                            catch (RemoteException e)
                            {
                                varB4EAC82CA7396A68D541C85D26508E83_1051146569 = null;
                            } 
                        } 
                        mProviderMap.put(names[i], pr);
                    } 
                } 
            } 
            {
                ProviderClientRecord pr = mLocalProviders.get(jBinder);
                {
                    provider = pr.mProvider;
                } 
                {
                    pr = new ProviderClientRecord(null, provider, localProvider);
                    mLocalProviders.put(jBinder, pr);
                } 
            } 
            {
                ProviderRefCount prc = mProviderRefCountMap.get(jBinder);
                {
                    prc.count += 1;
                    {
                        mH.removeMessages(H.REMOVE_PROVIDER, provider);
                    } 
                } 
                {
                    mProviderRefCountMap.put(jBinder, new ProviderRefCount(1));
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_576426400 = provider;
        addTaint(context.getTaint());
        addTaint(provider.getTaint());
        addTaint(info.getTaint());
        addTaint(noisy);
        addTaint(noReleaseNeeded);
        IContentProvider varA7E53CE21691AB073D9660D615818899_803060606; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_803060606 = varB4EAC82CA7396A68D541C85D26508E83_73719834;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_803060606 = varB4EAC82CA7396A68D541C85D26508E83_921433628;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_803060606 = varB4EAC82CA7396A68D541C85D26508E83_687724995;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_803060606 = varB4EAC82CA7396A68D541C85D26508E83_1051146569;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_803060606 = varB4EAC82CA7396A68D541C85D26508E83_576426400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_803060606.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_803060606;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.934 -0400", hash_original_method = "C124A05EAD0D975305C2EDD26DCF96DC", hash_generated_method = "546B7882FBFA3A3F24EAA322BCE7CA34")
    private void attach(boolean system) {
        sThreadLocal.set(this);
        mSystemThread = system;
        {
            ViewRootImpl.addFirstDrawHandler(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.931 -0400", hash_original_method = "47807A5814B5D681B360E1F6CDD604E7", hash_generated_method = "CE4C0CC733C0731411E130B03C44D6CB")
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
            } 
            catch (RemoteException ex)
            { }
        } 
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
            } 
            catch (Exception e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException(
                        "Unable to instantiate Application():" + e.toString(), e);
            } 
        } 
        ViewRootImpl.addConfigCallback(new ComponentCallbacks2() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.932 -0400", hash_original_method = "26C6C7423624E1B7694397A08E8C6CD1", hash_generated_method = "2C70D570B2EEF64D7ECBB4A9F11DCC09")
            public void onConfigurationChanged(Configuration newConfig) {
                
                {
                    {
                        boolean var7902634F304B837BD47B2192DBEFCA89_1956701953 = (applyConfigurationToResourcesLocked(newConfig, null));
                        {
                            {
                                boolean var4EBF8D921B272E9ECD6097B4EB42049C_1732034095 = (mPendingConfiguration == null ||
                                mPendingConfiguration.isOtherSeqNewer(newConfig));
                                {
                                    mPendingConfiguration = newConfig;
                                    queueOrSendMessage(H.CONFIGURATION_CHANGED, newConfig);
                                } 
                            } 
                        } 
                    } 
                } 
                addTaint(newConfig.getTaint());
                
                
                    
                        
                                
                            
                            
                        
                    
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.933 -0400", hash_original_method = "4F0E380BE715BF5B2ECCDB1794C8905E", hash_generated_method = "39AEB8790734ECC8DC70BBAAEE0BAB0B")
            public void onLowMemory() {
                
                
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.933 -0400", hash_original_method = "3AE0D4ACEA3D5F3B779A378D5AB27A6A", hash_generated_method = "C1AFC91F30E138BA03233A690A40C0CC")
            public void onTrimMemory(int level) {
                
                addTaint(level);
                
            }
});
        
        
    }

    
        public static final ActivityThread systemMain() {
        HardwareRenderer.disable(true);
        ActivityThread thread = new ActivityThread();
        thread.attach(true);
        return thread;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.935 -0400", hash_original_method = "2E14593B1AB1D9A91353E1BD8215A316", hash_generated_method = "A4CE5608AD7F182D2B581B43594B9F3B")
    public final void installSystemProviders(List<ProviderInfo> providers) {
        {
            installContentProviders(mInitialApplication, providers);
        } 
        addTaint(providers.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.936 -0400", hash_original_method = "A46DE63D351DE0CEA05BC700781E1C79", hash_generated_method = "97C2752408FC6A2B7FA7D7C28F1091B3")
    public int getIntCoreSetting(String key, int defaultValue) {
        {
            {
                int varFDEB65FAB02737F165A27EF58C1FFD56_32993104 = (mCoreSettings.getInt(key, defaultValue));
            } 
        } 
        addTaint(key.getTaint());
        addTaint(defaultValue);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175673829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_175673829;
        
        
            
                
            
                
            
        
    }

    
        @DSModeled(DSC.SAFE)
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.938 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.938 -0400", hash_original_field = "67217D8B401CF5E72BBF5103D60F3E97", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

        int ident;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.938 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "C00C2C61984260DF3B4937ADC46E8A7C")

        Bundle state;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "A63B0916BD4AC2611D1AF746A2DF045C")

        Activity activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "05B8C74CBD96FBF2DE4C1A352702FBF4", hash_generated_field = "C8345ED8E0FB49346B128B9846AFDDB2")

        Window window;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "D0E45878043844FFC41AAC437E86B602", hash_generated_field = "8772E5B00EE7781FE599C41013926102")

        Activity parent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "6F8E7109EE5ADBADB311A9D0FBBBBC2D", hash_generated_field = "99A507AF2C301E2FF9994737D79275BB")

        String embeddedID;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "C9A812088441D29B618CAF19775FDAA2", hash_generated_field = "2EF688309E753499C339EBE96926B7C3")

        Activity.NonConfigurationInstances lastNonConfigurationInstances;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.939 -0400", hash_original_field = "D13C3F7BAED576768B11A714EF4D90E2", hash_generated_field = "5637B5D432947459416E03554347708E")

        boolean paused;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "F0A0BFE6BC7D2C58D2989034F83183E0", hash_generated_field = "B0899FB375A0A57065DA66B38777B6C0")

        boolean stopped;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "614AB218DE1950441B1407D6BB38AFE3", hash_generated_field = "5DCC7672BCF10641A46EAA548A687CD5")

        boolean hideForNow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "6D069C9B9BA8B31B534F29F6B998EB02", hash_generated_field = "DD2677A28540A2EE77D6F7429A2F8892")

        Configuration newConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "70155DDAAD08A53C67D84B831081C73C", hash_generated_field = "44F8DA58F1EEFDF22FCF6A1FED0376C3")

        Configuration createdConfig;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "8585C121190575E017AD93490EC11357", hash_generated_field = "583CE8A57524BB39C7618CF1F2B65C96")

        ActivityClientRecord nextIdle;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.940 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "9CFCA1B7F8752ABB79A9EED9367C413A")

        ActivityInfo activityInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "FD5373273702F9470D1C201B33B812A0", hash_generated_field = "6FE708D4D9958EC105E3B69C43275F19")

        LoadedApk packageInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "3B0B9C6FBD20486E139A43FC64A202D9", hash_generated_field = "A77E9DD92A64C5F780B6000CA80182A2")

        List<ResultInfo> pendingResults;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "433CEFD43BB3E36958F4429303CFBDF2", hash_generated_field = "4BC30CA1B8786644C876DAF48F78533F")

        List<Intent> pendingIntents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.941 -0400", hash_original_field = "8C75492FB96D35639922DFCB4D489088", hash_generated_field = "5CE883BF4DAD47FBDAF4D2C3F7074402")

        boolean startsNotResumed;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.942 -0400", hash_original_field = "4DFD186ABB3EB706F59F85400A376CE9", hash_generated_field = "8A03F39D432E8E43D36A30D2C65BF04B")

        boolean isForward;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.942 -0400", hash_original_field = "7771A08DD693060EE393D87DF30CF928", hash_generated_field = "2BC5D372006E004497C167DEE6104107")

        int pendingConfigChanges;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.942 -0400", hash_original_field = "97D2042DAB1F67D641A4735F0A59DDA4", hash_generated_field = "970B3D7A6F8A2CE63E822A10DBAD0F49")

        boolean onlyLocalRequest;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.942 -0400", hash_original_field = "FA6E167268326F793F40624DB64B3B41", hash_generated_field = "C7546AC98481F963F1798A1F44EE5004")

        View mPendingRemoveWindow;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.942 -0400", hash_original_field = "A1EB5D2CF63EABFE576274089B0DEA1C", hash_generated_field = "651EDB05D2F89D6E111AFDE79ADF6A66")

        WindowManager mPendingRemoveWindowManager;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.943 -0400", hash_original_method = "B5F524E6EAF79ED64F291F38DBCEDD1B", hash_generated_method = "1B05C37D3F960D6790EA6795720DC542")
          ActivityClientRecord() {
            parent = null;
            embeddedID = null;
            paused = false;
            stopped = false;
            hideForNow = false;
            nextIdle = null;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.943 -0400", hash_original_method = "2761403398E750945AAB952EA69C6C0F", hash_generated_method = "D2CC9C209A4E1BD8A36A47277C62E047")
        public boolean isPreHoneycomb() {
            {
                boolean var708B39EC3F85FBC7A5D34973A60AE645_1983609428 = (activity.getApplicationInfo().targetSdkVersion
                        < android.os.Build.VERSION_CODES.HONEYCOMB);
            } 
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_876145284 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_876145284;
            
            
                
                        
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.945 -0400", hash_original_method = "C4594DCD1E896B9BDB54D56E10F2B8EE", hash_generated_method = "98A47ABC7B423A9783CE43F43E3606C8")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1815324570 = null; 
            ComponentName componentName = intent.getComponent();
            varB4EAC82CA7396A68D541C85D26508E83_1815324570 = "ActivityRecord{"
                + Integer.toHexString(System.identityHashCode(this))
                + " token=" + token + " " + (componentName == null
                        ? "no component name" : componentName.toShortString())
                + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1815324570.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1815324570;
            
            
            
                
                
                        
                
        }

        
    }


    
    final class ProviderClientRecord implements IBinder.DeathRecipient {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.945 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

        String mName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.945 -0400", hash_original_field = "BD1D19BC6BC3803BE152A977D479AC49", hash_generated_field = "4165A1FBAFFD21863CC0EAC1937582F7")

        IContentProvider mProvider;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.945 -0400", hash_original_field = "10F83DD9C72C654C184D34757393AB14", hash_generated_field = "7AAFFB6DED098E36BD02CC080B04AF7E")

        ContentProvider mLocalProvider;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.946 -0400", hash_original_method = "C7097CC666CFF4D083C9B2045DB42E29", hash_generated_method = "DF4756A2C65B372E178D3BE3C4A53DC6")
          ProviderClientRecord(String name, IContentProvider provider,
                ContentProvider localProvider) {
            mName = name;
            mProvider = provider;
            mLocalProvider = localProvider;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.947 -0400", hash_original_method = "3801456C44CFB93A5BA86A8AB8C43B3F", hash_generated_method = "B050BAB508FED40C5C7DDCB23C41347E")
        public void binderDied() {
            removeDeadProvider(mName, mProvider);
            
            
        }

        
    }


    
    static final class NewIntentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.947 -0400", hash_original_field = "99F399B171645B449364ED937DFD6F10", hash_generated_field = "DCC84A2BE9F90A98827B285408558812")

        List<Intent> intents;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.947 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.948 -0400", hash_original_method = "9A9162E54721E56B9804FAED427417E2", hash_generated_method = "9A9162E54721E56B9804FAED427417E2")
        public NewIntentData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.949 -0400", hash_original_method = "E9F4DBEB4C72AFF7F672A47023D2DCCE", hash_generated_method = "B3311B6FC1BBD283E6D119CA70CDA5A2")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1533668056 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1533668056 = "NewIntentData{intents=" + intents + " token=" + token + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1533668056.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1533668056;
            
            
        }

        
    }


    
    static final class ReceiverData extends BroadcastReceiver.PendingResult {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.949 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.949 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "D6562EB0A3FC9B94476A16D5F303F058")

        ActivityInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.949 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.950 -0400", hash_original_method = "95DC539EA4572F0714768317249686D3", hash_generated_method = "83D54A34A23AC7CAE3151DFA2BD4FA5A")
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
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.951 -0400", hash_original_method = "062A80C4BE8CE608AA3884983AB20A02", hash_generated_method = "3CCD38B5B8A4D2A862FF756BA67891BE")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_815059947 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_815059947 = "ReceiverData{intent=" + intent + " packageName=" +
                    info.packageName + " resultCode=" + getResultCode()
                    + " resultData=" + getResultData() + " resultExtras="
                    + getResultExtras(false) + "}";
            varB4EAC82CA7396A68D541C85D26508E83_815059947.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_815059947;
            
            
                    
                    
                    
        }

        
    }


    
    static final class CreateBackupAgentData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.951 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.951 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.951 -0400", hash_original_field = "804191EFAC8137D8B58292EF386D75FA", hash_generated_field = "F90DF71BF48FAFE07F43CB879F966CE3")

        int backupMode;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.952 -0400", hash_original_method = "7F9A4ECF6FE623DBC230D640707CDFD0", hash_generated_method = "7F9A4ECF6FE623DBC230D640707CDFD0")
        public CreateBackupAgentData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.952 -0400", hash_original_method = "87705B4B5A78FEE0786C01D6E7384189", hash_generated_method = "2726AD409B6DB76B58DF1F795377CA39")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1763229326 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1763229326 = "CreateBackupAgentData{appInfo=" + appInfo
                    + " backupAgent=" + appInfo.backupAgentName
                    + " mode=" + backupMode + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1763229326.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1763229326;
            
            
                    
                    
        }

        
    }


    
    static final class CreateServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.953 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.953 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "4AEE41877C99C71A9296A5C433E71F7C")

        ServiceInfo info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.953 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.953 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.953 -0400", hash_original_method = "881257217964B643C1B29F21F8324D73", hash_generated_method = "881257217964B643C1B29F21F8324D73")
        public CreateServiceData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.954 -0400", hash_original_method = "DE656B2587EA58A3FB80D8944832AD3A", hash_generated_method = "0C46945FD576F5D6FE30A934F1921D32")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1721417979 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1721417979 = "CreateServiceData{token=" + token + " className="
            + info.name + " packageName=" + info.packageName
            + " intent=" + intent + "}";
            varB4EAC82CA7396A68D541C85D26508E83_1721417979.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1721417979;
            
            
            
            
        }

        
    }


    
    static final class BindServiceData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.954 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.955 -0400", hash_original_field = "FA48C7D544739BA0E46430E4BA366662", hash_generated_field = "170FCA7A98A65D8003A3D20D5B3C245D")

        Intent intent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.955 -0400", hash_original_field = "35DA50F034DA1C4AB0308E9228963716", hash_generated_field = "35FF113739960C8FEB167B42458B2109")

        boolean rebind;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.955 -0400", hash_original_method = "2B59A1695FBC674B2F74F0571D5E38A2", hash_generated_method = "2B59A1695FBC674B2F74F0571D5E38A2")
        public BindServiceData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.956 -0400", hash_original_method = "788B7BFDCE261467774852FF99962FB6", hash_generated_method = "09E2C2EAD456A0BA878AE513B017DF82")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_159425289 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_159425289 = "BindServiceData{token=" + token + " intent=" + intent + "}";
            varB4EAC82CA7396A68D541C85D26508E83_159425289.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_159425289;
            
            
        }

        
    }


    
    static final class ServiceArgsData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.957 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.957 -0400", hash_original_field = "18114AC9833DE9BE54FC2510379F9C46", hash_generated_field = "CB66DDA6D80EB80E88BF8636FFAE2527")

        boolean taskRemoved;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.957 -0400", hash_original_field = "1479C40F2636F6E3EEED28E17C8A08D9", hash_generated_field = "B575BF041CFA248D715BE93778A966DC")

        int startId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.958 -0400", hash_original_field = "4E5868D676CB634AA75B125A0F741ABF", hash_generated_field = "E0CDE1A38A40425C446F52269E5723DC")

        int flags;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.958 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "77AB5E543174DF1F66D162C0382A930F")

        Intent args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.958 -0400", hash_original_method = "103D015CCE841E84C3050E807488FBE9", hash_generated_method = "103D015CCE841E84C3050E807488FBE9")
        public ServiceArgsData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.959 -0400", hash_original_method = "9123370A477925A90205ABBEEFE44004", hash_generated_method = "5D70F7EA5F05D00A7A267B94CA544FC0")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_356753385 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_356753385 = "ServiceArgsData{token=" + token + " startId=" + startId
            + " args=" + args + "}";
            varB4EAC82CA7396A68D541C85D26508E83_356753385.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_356753385;
            
            
            
        }

        
    }


    
    static final class AppBindData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "CFE674900E356A9F4BF51234744250B8")

        LoadedApk info;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "182AC29DC74CEB0C6C89C5576E47A4DD")

        String processName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "FFA4BF6CCD9374A51A326ED65290538B", hash_generated_field = "BB93ED015037E8AFDF3FDE7CABC1B568")

        ApplicationInfo appInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "29D247EE74C64366386D8D549C17162D", hash_generated_field = "7A9F4634EB01C0456156CF1B784BCEC9")

        List<ProviderInfo> providers;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "B80C791FAFFB60831D70548CB5215902", hash_generated_field = "3F5DA88F1FEC15C88CB883D59573E813")

        ComponentName instrumentationName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "A787EF10308AF70C6A64332DCA7C8E51", hash_generated_field = "73077E024184109776339B9D1BEE35EB")

        Bundle instrumentationArgs;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.960 -0400", hash_original_field = "4165C674FEE7A7791DA12B1AFD3117CF", hash_generated_field = "B075C237152068CFAEC1BD98818F5007")

        IInstrumentationWatcher instrumentationWatcher;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "48E635F7A84F2E705C3CC133792C2E42", hash_generated_field = "5FC68647D6D0CF439E6B829CC880890C")

        int debugMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "BA6ED9886C7F4DC26B56F7D1AD9427A4", hash_generated_field = "4EAC7CFAA88429E81A3DA1B88F7F0814")

        boolean restrictedBackupMode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "23C6323BFB57BB630B8A2ECF703D6BB0", hash_generated_field = "B853B56DA62629292AFB975D2A443261")

        boolean persistent;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "2245023265AE4CF87D02C8B6BA991139", hash_generated_field = "A3F5781DE6AF7A59A7DBAA1BECE272A9")

        Configuration config;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "F6B198972AA8ABD8CD52EAFD4BD54CF7", hash_generated_field = "2B67D7EEC5FDB496E2BE58A0747899F8")

        CompatibilityInfo compatInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "03E5F42EE7352D707D8219D0B5A3A3D3", hash_generated_field = "DB4FDD2502B5FFC034FB83C77C56111F")

        String initProfileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.961 -0400", hash_original_field = "1A8CF268D8A31BBDEFA6FA16D91B0CEE", hash_generated_field = "D60C582964877A307BEAF4053762EF15")

        ParcelFileDescriptor initProfileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.962 -0400", hash_original_field = "56F3F00A970BDF076342D5A0780440E9", hash_generated_field = "2D2D69EB52002C7C4F13F0178D625E55")

        boolean initAutoStopProfiler;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.962 -0400", hash_original_method = "EDE65A505FE77989B4B34B8F22E2D58F", hash_generated_method = "EDE65A505FE77989B4B34B8F22E2D58F")
        public AppBindData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_method = "2BA8F6DB78683607CF1A79B96A9E1945", hash_generated_method = "06DEA590E63D4D4F2C747FF17D84FDC6")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_445554044 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_445554044 = "AppBindData{appInfo=" + appInfo + "}";
            varB4EAC82CA7396A68D541C85D26508E83_445554044.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_445554044;
            
            
        }

        
    }


    
    static final class Profiler {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_field = "4687101F4A9E9CF3F4EC110EF0BD4D86", hash_generated_field = "0AEB1625B8037FA1222953DB04FF40F7")

        String profileFile;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_field = "F9C030A18879AB83AD9F3E19D92655BC", hash_generated_field = "6D0D0FC1FD6F72A79E2D27F4C2A0837E")

        ParcelFileDescriptor profileFd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_field = "5F38B0248D86DE098CB25DD9678C199B", hash_generated_field = "7730B1164360352D89737A9ABB4F979F")

        boolean autoStopProfiler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_field = "3CDDA3E94E1B3DFD218A9D60B8139968", hash_generated_field = "5AEBAB31656E136FF8335BF7952CBD3D")

        boolean profiling;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.963 -0400", hash_original_field = "F172439EC8EE2FA7210D2763CB835A33", hash_generated_field = "CFD51622CC9205EA276B9A72B7AC1389")

        boolean handlingProfiling;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.964 -0400", hash_original_method = "7B9BEA1F6EC95E751CD548D4F51680C9", hash_generated_method = "7B9BEA1F6EC95E751CD548D4F51680C9")
        public Profiler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.964 -0400", hash_original_method = "A8A96BF1FCBE3854C04202513222077A", hash_generated_method = "722B5CB8BBE43F8168FF27701087A5B0")
        public void setProfiler(String file, ParcelFileDescriptor fd) {
            {
                {
                    try 
                    {
                        fd.close();
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            {
                try 
                {
                    profileFd.close();
                } 
                catch (IOException e)
                { }
            } 
            profileFile = file;
            profileFd = fd;
            
            
                
                    
                        
                    
                    
                
                
            
            
                
                    
                
                
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.965 -0400", hash_original_method = "4BADC9424DA1A3AC7F9D5563006BCE42", hash_generated_method = "717956F1062DD3A5AEC90B37F1ED3668")
        public void startProfiling() {
            try 
            {
                Debug.startMethodTracing(profileFile, profileFd.getFileDescriptor(),
                        8 * 1024 * 1024, 0);
                profiling = true;
            } 
            catch (RuntimeException e)
            {
                try 
                {
                    profileFd.close();
                    profileFd = null;
                } 
                catch (IOException e2)
                { }
            } 
            
            
                
            
            
                
                        
                
            
                
                
                    
                    
                
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.966 -0400", hash_original_method = "F0726A3E7708B3CB256CEACF5FA42FD5", hash_generated_method = "53B2FD47BCAC0373E4CFDB09F8C1864E")
        public void stopProfiling() {
            {
                profiling = false;
                Debug.stopMethodTracing();
                {
                    try 
                    {
                        profileFd.close();
                    } 
                    catch (IOException e)
                    { }
                } 
                profileFd = null;
                profileFile = null;
            } 
            
            
                
                
                
                    
                        
                    
                    
                
                
                
            
        }

        
    }


    
    static final class DumpComponentInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.967 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.967 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.967 -0400", hash_original_field = "851F5AC9941D720844D143ED9CFCF60A", hash_generated_field = "D07D332701F9B92847141D46D8B2C7CF")

        String prefix;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.967 -0400", hash_original_field = "A956AF09162870AF6CE4EBE0F12CCAF8", hash_generated_field = "7F2C1FD08D9A857D4D2EDF6F9394FC1F")

        String[] args;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.968 -0400", hash_original_method = "705FE87B3B944DB1E7088D167B1442FA", hash_generated_method = "705FE87B3B944DB1E7088D167B1442FA")
        public DumpComponentInfo ()
        {
            
        }


    }


    
    static final class ResultData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.968 -0400", hash_original_field = "94A08DA1FECBB6E8B46990538C7B50B2", hash_generated_field = "AEFA330A775EF7A6CCCEA63565B352D0")

        IBinder token;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.968 -0400", hash_original_field = "53E61336BB49EC978968786B07DEA50B", hash_generated_field = "C3849EE0113C1C1730E99FB7C260DA4E")

        List<ResultInfo> results;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.968 -0400", hash_original_method = "3466C6D5CF0FEDF7456B3B9BA6367B40", hash_generated_method = "3466C6D5CF0FEDF7456B3B9BA6367B40")
        public ResultData ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.969 -0400", hash_original_method = "BA3AA15664E126972C9E79255FFB7B3E", hash_generated_method = "1B858084F9F5623CE67B8822A734FA8A")
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_181218047 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_181218047 = "ResultData{token=" + token + " results" + results + "}";
            varB4EAC82CA7396A68D541C85D26508E83_181218047.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_181218047;
            
            
        }

        
    }


    
    static final class ContextCleanupInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_field = "5C18EF72771564B7F43C497DC507AEAB", hash_generated_field = "C9CD4205E05705EAD2345480C07726F5")

        ContextImpl context;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_field = "4A2028ECEAC5E1F4D252EA13C71ECEC6", hash_generated_field = "EA705FF509AF2D1BE17CB07841038A94")

        String what;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_field = "53D670AF9BB16EA82E7EF41EE23EC6DF", hash_generated_field = "C4E3E8F459E3F192A7BA9767B8092770")

        String who;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_method = "1364E4E916202312196441F2CD1A38A7", hash_generated_method = "1364E4E916202312196441F2CD1A38A7")
        public ContextCleanupInfo ()
        {
            
        }


    }


    
    static final class ProfilerControlData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.970 -0400", hash_original_method = "D11C2D1935BF651482EE891D2A926235", hash_generated_method = "D11C2D1935BF651482EE891D2A926235")
        public ProfilerControlData ()
        {
            
        }


    }


    
    static final class DumpHeapData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_field = "D6FE1D0BE6347B8EF2427FA629C04485", hash_generated_field = "4936DBCD90EF1129A7D9F03C4DB55EE0")

        String path;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_field = "36EBA1E1E343279857EA7F69A597324E", hash_generated_field = "ED4BCC0409574E6EB5292B0FF005E3EB")

        ParcelFileDescriptor fd;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F", hash_generated_method = "5B27D5ED8CFA7C0680EB0EE8314BCB6F")
        public DumpHeapData ()
        {
            
        }


    }


    
    static final class UpdateCompatibilityData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_field = "A46A1BCE0B67C45BEC8F435BD5390A54", hash_generated_field = "742D0CCB1EAA4E727F9FCD5430AF1837")

        String pkg;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_field = "CAF9B6B99962BF5C2264824231D7A40C", hash_generated_field = "F50EE04D1F33A8C52E6957011343491C")

        CompatibilityInfo info;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.971 -0400", hash_original_method = "20ABF4B3D5332D1381C869593F335293", hash_generated_method = "20ABF4B3D5332D1381C869593F335293")
        public UpdateCompatibilityData ()
        {
            
        }


    }


    
    private class ApplicationThread extends ApplicationThreadNative {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.972 -0400", hash_original_method = "1FF8F0D2A8FB58C213C16741C12E71C3", hash_generated_method = "1FF8F0D2A8FB58C213C16741C12E71C3")
        public ApplicationThread ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.972 -0400", hash_original_method = "FEE93A296AD85C197E1C80A7E47B6BFE", hash_generated_method = "8DD54AAF7009A307512D025FC9DC6A2C")
        private void updatePendingConfiguration(Configuration config) {
            {
                {
                    boolean var2CFDCC84A5236B199D2609CB25C5A865_823748373 = (mPendingConfiguration == null ||
                        mPendingConfiguration.isOtherSeqNewer(config));
                    {
                        mPendingConfiguration = config;
                    } 
                } 
            } 
            addTaint(config.getTaint());
            
            
                
                        
                    
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.973 -0400", hash_original_method = "BA274F1A18F5196BF92F19261941182B", hash_generated_method = "D917AB3F71BC8A576A91C774953B89AE")
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
            
            
                    
                    
                    
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.973 -0400", hash_original_method = "6237E07FCE9BDD69A8A6118FB4C5EAB5", hash_generated_method = "4992DA782DB647284F757A3441D4940F")
        public final void scheduleStopActivity(IBinder token, boolean showWindow,
                int configChanges) {
            queueOrSendMessage(
                showWindow ? H.STOP_ACTIVITY_SHOW : H.STOP_ACTIVITY_HIDE,
                token, 0, configChanges);
            addTaint(token.getTaint());
            addTaint(showWindow);
            addTaint(configChanges);
            
            
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.974 -0400", hash_original_method = "07304A552CCDBF618EE7F08FE12E8569", hash_generated_method = "359FCA9ACAFBF8DB7F3B260C9C3B669A")
        public final void scheduleWindowVisibility(IBinder token, boolean showWindow) {
            queueOrSendMessage(
                showWindow ? H.SHOW_WINDOW : H.HIDE_WINDOW,
                token);
            addTaint(token.getTaint());
            addTaint(showWindow);
            
            
                
                
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.974 -0400", hash_original_method = "28F90EA3762C8F9BC8352F7DED192FAC", hash_generated_method = "E86314E031E79DB9BF7AAF2C5814522E")
        public final void scheduleSleeping(IBinder token, boolean sleeping) {
            queueOrSendMessage(H.SLEEPING, token, sleeping ? 1 : 0);
            addTaint(token.getTaint());
            addTaint(sleeping);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.975 -0400", hash_original_method = "8E946102D354A83096F7BBE33573DD97", hash_generated_method = "FC60EBCDFCD4CF934283C731AD0FCE8C")
        public final void scheduleResumeActivity(IBinder token, boolean isForward) {
            queueOrSendMessage(H.RESUME_ACTIVITY, token, isForward ? 1 : 0);
            addTaint(token.getTaint());
            addTaint(isForward);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.976 -0400", hash_original_method = "C9516E754F864B61E9DED08AC69D1433", hash_generated_method = "FC112796569EF30967739A40510E849B")
        public final void scheduleSendResult(IBinder token, List<ResultInfo> results) {
            ResultData res = new ResultData();
            res.token = token;
            res.results = results;
            queueOrSendMessage(H.SEND_RESULT, res);
            addTaint(token.getTaint());
            addTaint(results.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.977 -0400", hash_original_method = "A45BCC7C8AC3E4C6E98525A537822FA1", hash_generated_method = "16A2D57DBBDD05460CFE0B8F7BB63E33")
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
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.979 -0400", hash_original_method = "7F2AB124E5633740D7D94B2A109EF885", hash_generated_method = "4E9123D26F10AFF75DD1819381499521")
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
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.980 -0400", hash_original_method = "821027AAA00C536539A4B7071BFFE4C0", hash_generated_method = "E2EA02A16BF7BB09E8B2FB07789FC0A7")
        public final void scheduleNewIntent(List<Intent> intents, IBinder token) {
            NewIntentData data = new NewIntentData();
            data.intents = intents;
            data.token = token;
            queueOrSendMessage(H.NEW_INTENT, data);
            addTaint(intents.getTaint());
            addTaint(token.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.980 -0400", hash_original_method = "09A2B20C75657E983740D1D57867F853", hash_generated_method = "F9D5651405F34FC3B8EBE453223B7F40")
        public final void scheduleDestroyActivity(IBinder token, boolean finishing,
                int configChanges) {
            queueOrSendMessage(H.DESTROY_ACTIVITY, token, finishing ? 1 : 0,
                    configChanges);
            addTaint(token.getTaint());
            addTaint(finishing);
            addTaint(configChanges);
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.981 -0400", hash_original_method = "F17AEB980BE0F6A4E87F430078BD0B58", hash_generated_method = "44FC2C23C471130B66AC53C23DE1D780")
        public final void scheduleReceiver(Intent intent, ActivityInfo info,
                CompatibilityInfo compatInfo, int resultCode, String data, Bundle extras,
                boolean sync) {
            ReceiverData r = new ReceiverData(intent, resultCode, data, extras,
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
            
            
                    
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.982 -0400", hash_original_method = "5FA1669C7C775884F96F1A035B24EE01", hash_generated_method = "F493E238AAB9BFF99B4EE34E463DFC5E")
        public final void scheduleCreateBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo, int backupMode) {
            CreateBackupAgentData d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            d.backupMode = backupMode;
            queueOrSendMessage(H.CREATE_BACKUP_AGENT, d);
            addTaint(app.getTaint());
            addTaint(compatInfo.getTaint());
            addTaint(backupMode);
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.982 -0400", hash_original_method = "313CE24EB5C5C4A7E872620C7BAF7637", hash_generated_method = "20E5097E880E3B099CA22A7004E127CD")
        public final void scheduleDestroyBackupAgent(ApplicationInfo app,
                CompatibilityInfo compatInfo) {
            CreateBackupAgentData d = new CreateBackupAgentData();
            d.appInfo = app;
            d.compatInfo = compatInfo;
            queueOrSendMessage(H.DESTROY_BACKUP_AGENT, d);
            addTaint(app.getTaint());
            addTaint(compatInfo.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.983 -0400", hash_original_method = "304266FFC85B0A8F15B84D2439555071", hash_generated_method = "62D1914A4ABF879815354823EBAA13A4")
        public final void scheduleCreateService(IBinder token,
                ServiceInfo info, CompatibilityInfo compatInfo) {
            CreateServiceData s = new CreateServiceData();
            s.token = token;
            s.info = info;
            s.compatInfo = compatInfo;
            queueOrSendMessage(H.CREATE_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(info.getTaint());
            addTaint(compatInfo.getTaint());
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.984 -0400", hash_original_method = "EC87D949C3428DDE1DD75260E89A91E6", hash_generated_method = "9102F37E4DE4DFA99819D2842D64AF3B")
        public final void scheduleBindService(IBinder token, Intent intent,
                boolean rebind) {
            BindServiceData s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            s.rebind = rebind;
            queueOrSendMessage(H.BIND_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(intent.getTaint());
            addTaint(rebind);
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.984 -0400", hash_original_method = "267A066D9D2EC1A97646FF118EBD56F3", hash_generated_method = "8885F6655F8F32529F04653D47BE35E1")
        public final void scheduleUnbindService(IBinder token, Intent intent) {
            BindServiceData s = new BindServiceData();
            s.token = token;
            s.intent = intent;
            queueOrSendMessage(H.UNBIND_SERVICE, s);
            addTaint(token.getTaint());
            addTaint(intent.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.985 -0400", hash_original_method = "4862A31D82FA9B63D38F69A2AB095DD2", hash_generated_method = "278774D8B74AC171AAFFF673755A4AF7")
        public final void scheduleServiceArgs(IBinder token, boolean taskRemoved, int startId,
            int flags ,Intent args) {
            ServiceArgsData s = new ServiceArgsData();
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
            
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.985 -0400", hash_original_method = "1A677B6A32C3D13D1D29F012CCC3FAD3", hash_generated_method = "20CB2D0F2CE7EB21E307347824868418")
        public final void scheduleStopService(IBinder token) {
            queueOrSendMessage(H.STOP_SERVICE, token);
            addTaint(token.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.987 -0400", hash_original_method = "7F787E48DA5312BFEADE988209BA97C7", hash_generated_method = "BC3F290DD972E713F01679D80BD7DED7")
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
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.988 -0400", hash_original_method = "8F2CF4412C4F9594CB0F284CDA41289F", hash_generated_method = "FD95F1744B2DADE0E6256342E369D342")
        public final void scheduleExit() {
            queueOrSendMessage(H.EXIT_APPLICATION, null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.989 -0400", hash_original_method = "B20E9F159FCFB18DA16F9E3A94AEF27F", hash_generated_method = "FCFDDF7AD8124B805F52430959A87E50")
        public final void scheduleSuicide() {
            queueOrSendMessage(H.SUICIDE, null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.990 -0400", hash_original_method = "6202A73E0682C5A75E75C022AC3B402A", hash_generated_method = "48A1F121DF1D20DE06EFB7AE38C20B3B")
        public void requestThumbnail(IBinder token) {
            queueOrSendMessage(H.REQUEST_THUMBNAIL, token);
            addTaint(token.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.991 -0400", hash_original_method = "06772B0545F1E3E199A400C07A7C465B", hash_generated_method = "53FC298F5726D07F58C2FD2F30D198B5")
        public void scheduleConfigurationChanged(Configuration config) {
            updatePendingConfiguration(config);
            queueOrSendMessage(H.CONFIGURATION_CHANGED, config);
            addTaint(config.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.991 -0400", hash_original_method = "691E3B4CEF6237A9A1AE3434E3DEDEFF", hash_generated_method = "B8C95D80E84F89DC0BEDC85471A2F2D3")
        public void updateTimeZone() {
            TimeZone.setDefault(null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.992 -0400", hash_original_method = "38B626EB423003E8CAF0F1407CD9E9A9", hash_generated_method = "4A28A43D9782A661EAF6F85250AF0D6F")
        public void clearDnsCache() {
            InetAddress.clearDnsCache();
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.992 -0400", hash_original_method = "B8887413EF343DBD56A367F4C57F614A", hash_generated_method = "BF7EEB7653EAAE61B498B50053247D7C")
        public void setHttpProxy(String host, String port, String exclList) {
            Proxy.setHttpProxySystemProperty(host, port, exclList);
            addTaint(host.getTaint());
            addTaint(port.getTaint());
            addTaint(exclList.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.993 -0400", hash_original_method = "66F6EAD39814B9A04B7952BBDB099BC9", hash_generated_method = "572139B122FBBA71F49FE015C971C791")
        public void processInBackground() {
            mH.removeMessages(H.GC_WHEN_IDLE);
            mH.sendMessage(mH.obtainMessage(H.GC_WHEN_IDLE));
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.994 -0400", hash_original_method = "876C8E0D071CEA83F82D96AA48344FA4", hash_generated_method = "0A74666E4861FF5F2F140CD28ADD0442")
        public void dumpService(FileDescriptor fd, IBinder servicetoken, String[] args) {
            DumpComponentInfo data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = servicetoken;
                data.args = args;
                queueOrSendMessage(H.DUMP_SERVICE, data);
            } 
            catch (IOException e)
            { }
            addTaint(fd.getTaint());
            addTaint(servicetoken.getTaint());
            addTaint(args[0].getTaint());
            
            
            
                
                
                
                
            
                
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.994 -0400", hash_original_method = "0E238081C4996703A2EA0540C6977CE0", hash_generated_method = "5D03A8CD7858AA8957D593C5285A33DF")
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
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.995 -0400", hash_original_method = "1CA11DE4169634D3536C3A5288820C11", hash_generated_method = "C0AEC8819655C2E24AF50FB99520B4E3")
        public void scheduleLowMemory() {
            queueOrSendMessage(H.LOW_MEMORY, null);
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.995 -0400", hash_original_method = "1503BAA815C894047387C37D52FE75DC", hash_generated_method = "59188C16C404FB146F1EDA7F192F2F81")
        public void scheduleActivityConfigurationChanged(IBinder token) {
            queueOrSendMessage(H.ACTIVITY_CONFIGURATION_CHANGED, token);
            addTaint(token.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.996 -0400", hash_original_method = "D92E635329F77F60C61D4CBABCC9E0E5", hash_generated_method = "4A05C9729C31735E74B84016F387B301")
        public void profilerControl(boolean start, String path, ParcelFileDescriptor fd,
                int profileType) {
            ProfilerControlData pcd = new ProfilerControlData();
            pcd.path = path;
            pcd.fd = fd;
            queueOrSendMessage(H.PROFILER_CONTROL, pcd, start ? 1 : 0, profileType);
            addTaint(start);
            addTaint(path.getTaint());
            addTaint(fd.getTaint());
            addTaint(profileType);
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.997 -0400", hash_original_method = "E2AA43C341E3E1223DC4327679137F86", hash_generated_method = "A7A17ABBD6F4763EF251DAA4B6ABC665")
        public void dumpHeap(boolean managed, String path, ParcelFileDescriptor fd) {
            DumpHeapData dhd = new DumpHeapData();
            dhd.path = path;
            dhd.fd = fd;
            queueOrSendMessage(H.DUMP_HEAP, dhd, managed ? 1 : 0);
            addTaint(managed);
            addTaint(path.getTaint());
            addTaint(fd.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.998 -0400", hash_original_method = "31DFA590CF69650795082863A4038E1E", hash_generated_method = "D80D73D17CF81872BBAFCB26CF4AB3CD")
        public void setSchedulingGroup(int group) {
            try 
            {
                Process.setProcessGroup(Process.myPid(), group);
            } 
            catch (Exception e)
            { }
            addTaint(group);
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:15.999 -0400", hash_original_method = "7CB15E6FC063BB1B6B4AEB944EE130EF", hash_generated_method = "7F178544F547A85E455180D9AAF83037")
        public void getMemoryInfo(Debug.MemoryInfo outInfo) {
            Debug.getMemoryInfo(outInfo);
            addTaint(outInfo.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.000 -0400", hash_original_method = "779EC3818AE8FA9E2AC523D128FB5D87", hash_generated_method = "C465F6CE7C51F836B2A046A8FE39D2EA")
        public void dispatchPackageBroadcast(int cmd, String[] packages) {
            queueOrSendMessage(H.DISPATCH_PACKAGE_BROADCAST, packages, cmd);
            addTaint(cmd);
            addTaint(packages[0].getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.001 -0400", hash_original_method = "E0613CA49761C406F1CB17CB9D000972", hash_generated_method = "42CC174CF32CED87381A83DC00332392")
        public void scheduleCrash(String msg) {
            queueOrSendMessage(H.SCHEDULE_CRASH, msg);
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.001 -0400", hash_original_method = "D7BE3A9B3D448EC9431A34B711555765", hash_generated_method = "9A962686E4636E735DEBB456A19ED829")
        public void dumpActivity(FileDescriptor fd, IBinder activitytoken,
                String prefix, String[] args) {
            DumpComponentInfo data = new DumpComponentInfo();
            try 
            {
                data.fd = ParcelFileDescriptor.dup(fd);
                data.token = activitytoken;
                data.prefix = prefix;
                data.args = args;
                queueOrSendMessage(H.DUMP_ACTIVITY, data);
            } 
            catch (IOException e)
            { }
            addTaint(fd.getTaint());
            addTaint(activitytoken.getTaint());
            addTaint(prefix.getTaint());
            addTaint(args[0].getTaint());
            
            
            
                
                
                
                
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.002 -0400", hash_original_method = "648F3C65CFB469E019D9747F832AE1E8", hash_generated_method = "C00CC23B6D29E8DC73D9FE8983E0A9E9")
        @Override
        public Debug.MemoryInfo dumpMemInfo(FileDescriptor fd, boolean checkin,
                boolean all, String[] args) {
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1882913340 = null; 
            FileOutputStream fout = new FileOutputStream(fd);
            PrintWriter pw = new PrintWriter(fout);
            try 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1882913340 = dumpMemInfo(pw, checkin, all, args);
            } 
            finally 
            {
                pw.flush();
            } 
            addTaint(fd.getTaint());
            addTaint(checkin);
            addTaint(all);
            addTaint(args[0].getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1882913340.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1882913340;
            
            
            
            
                
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.007 -0400", hash_original_method = "468180529DE63D6D9E6979D7BD66773F", hash_generated_method = "3CC9C4761490A62C5CFB3AD6CCA67341")
        private Debug.MemoryInfo dumpMemInfo(PrintWriter pw, boolean checkin, boolean all,
                String[] args) {
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1671464966 = null; 
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1440882782 = null; 
            Debug.MemoryInfo varB4EAC82CA7396A68D541C85D26508E83_1611898189 = null; 
            long nativeMax = Debug.getNativeHeapSize() / 1024;
            long nativeAllocated = Debug.getNativeHeapAllocatedSize() / 1024;
            long nativeFree = Debug.getNativeHeapFreeSize() / 1024;
            Debug.MemoryInfo memInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memInfo);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1671464966 = memInfo;
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
                    int i = 0;
                    boolean var34DA22B98BE69F3557BBBED2C262409B_1635912453 = (i < stats.dbStats.size());
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
                    } 
                } 
                pw.println();
                varB4EAC82CA7396A68D541C85D26508E83_1440882782 = memInfo;
            } 
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
            {
                int i = 0;
                {
                    printRow(pw, HEAP_COLUMN, Debug.MemoryInfo.getOtherLabel(i),
                        memInfo.getOtherPss(i), memInfo.getOtherSharedDirty(i),
                        memInfo.getOtherPrivateDirty(i), "", "", "");
                    otherPss -= memInfo.getOtherPss(i);
                    otherSharedDirty -= memInfo.getOtherSharedDirty(i);
                    otherPrivateDirty -= memInfo.getOtherPrivateDirty(i);
                } 
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
            pw.println(" ");
            pw.println(" SQL");
            printRow(pw, TWO_COUNT_COLUMNS_DB, "heap:", sqliteAllocated, "MEMORY_USED:",
                    stats.memoryUsed / 1024);
            printRow(pw, TWO_COUNT_COLUMNS_DB, "PAGECACHE_OVERFLOW:",
                    stats.pageCacheOverflo / 1024, "MALLOC_SIZE:", stats.largestMemAlloc / 1024);
            pw.println(" ");
            int N = stats.dbStats.size();
            {
                pw.println(" DATABASES");
                printRow(pw, "  %8s %8s %14s %14s  %s", "pgsz", "dbsz", "Lookaside(b)", "cache",
                        "Dbname");
                {
                    int i = 0;
                    {
                        DbStats dbStats = stats.dbStats.get(i);
                        printRow(pw, DB_INFO_FORMAT,
                            (dbStats.pageSize > 0) ? String.valueOf(dbStats.pageSize) : " ",
                            (dbStats.dbSize > 0) ? String.valueOf(dbStats.dbSize) : " ",
                            (dbStats.lookaside > 0) ? String.valueOf(dbStats.lookaside) : " ",
                            dbStats.cache, dbStats.dbName);
                    } 
                } 
            } 
            String assetAlloc = AssetManager.getAssetAllocations();
            {
                pw.println(" ");
                pw.println(" Asset Allocations");
                pw.print(assetAlloc);
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1611898189 = memInfo;
            addTaint(pw.getTaint());
            addTaint(checkin);
            addTaint(all);
            addTaint(args[0].getTaint());
            Debug.MemoryInfo varA7E53CE21691AB073D9660D615818899_1774943298; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1774943298 = varB4EAC82CA7396A68D541C85D26508E83_1671464966;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1774943298 = varB4EAC82CA7396A68D541C85D26508E83_1440882782;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1774943298 = varB4EAC82CA7396A68D541C85D26508E83_1611898189;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1774943298.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1774943298;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.009 -0400", hash_original_method = "DBE19F37C980DCB637B8E3CCE0C6D7AE", hash_generated_method = "9DFFA905487BE70E4D9DA058B40F3E0E")
        @Override
        public void dumpGfxInfo(FileDescriptor fd, String[] args) {
            dumpGraphicsInfo(fd);
            WindowManagerImpl.getDefault().dumpGfxInfo(fd);
            addTaint(fd.getTaint());
            addTaint(args[0].getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.010 -0400", hash_original_method = "E9FD23CC6BA5457F811332501D367E07", hash_generated_method = "01B252CEECEC227E9C9B5E48CB8CD1D6")
        private void printRow(PrintWriter pw, String format, Object...objs) {
            pw.println(String.format(format, objs));
            addTaint(pw.getTaint());
            addTaint(format.getTaint());
            addTaint(objs[0].getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.010 -0400", hash_original_method = "5D81A3C132332FC039C36D652A159D52", hash_generated_method = "292FEB3CA0CC3BEAF89B4B6F4EDB115F")
        public void setCoreSettings(Bundle coreSettings) {
            queueOrSendMessage(H.SET_CORE_SETTINGS, coreSettings);
            addTaint(coreSettings.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.011 -0400", hash_original_method = "915F19E7DF7511DDBDEE0EA8781AD484", hash_generated_method = "D395256DD43028DBD9F203AA95DDC0C6")
        public void updatePackageCompatibilityInfo(String pkg, CompatibilityInfo info) {
            UpdateCompatibilityData ucd = new UpdateCompatibilityData();
            ucd.pkg = pkg;
            ucd.info = info;
            queueOrSendMessage(H.UPDATE_PACKAGE_COMPATIBILITY_INFO, ucd);
            addTaint(pkg.getTaint());
            addTaint(info.getTaint());
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.012 -0400", hash_original_method = "713723E30DD42F550C53D06876722D4F", hash_generated_method = "3D824C6AACF052B15E39794D74C144BF")
        public void scheduleTrimMemory(int level) {
            queueOrSendMessage(H.TRIM_MEMORY, null, level);
            addTaint(level);
            
            
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.013 -0400", hash_original_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5", hash_generated_method = "31EC72C0AC7AFF27B721CAEF4AAA57B5")
        public H ()
        {
            
        }


        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.019 -0400", hash_original_method = "D4EECE8CA6B12CA48ED79AE861C2FF1C", hash_generated_method = "3C8DF3CEE44D92428EC67D447AF44984")
         String codeToString(int code) {
            String varB4EAC82CA7396A68D541C85D26508E83_1398565327 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_458996058 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_2084638897 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_98945728 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1765716512 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_721311701 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_418411736 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_949841536 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1368621001 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_795825906 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_384195501 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1461055576 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_193991372 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1003177583 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_2019906579 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1346998060 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1549955559 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1438108485 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1775910327 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_2052650214 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_155294750 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_835125871 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1056924531 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_2054312266 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1623012468 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_379209317 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1311528951 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1051058362 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1336766832 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_509083873 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1270118566 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_306253609 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1121202251 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_842677545 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_386909507 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_549678638 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_62018345 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_848538566 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_710170950 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1144730846 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1530581689 = null; 
            String varB4EAC82CA7396A68D541C85D26508E83_1079023403 = null; 
            {
                
                varB4EAC82CA7396A68D541C85D26508E83_1398565327 = "LAUNCH_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_458996058 = "PAUSE_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_2084638897 = "PAUSE_ACTIVITY_FINISHING";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_98945728 = "STOP_ACTIVITY_SHOW";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1765716512 = "STOP_ACTIVITY_HIDE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_721311701 = "SHOW_WINDOW";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_418411736 = "HIDE_WINDOW";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_949841536 = "RESUME_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1368621001 = "SEND_RESULT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_795825906 = "DESTROY_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_384195501 = "BIND_APPLICATION";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1461055576 = "EXIT_APPLICATION";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_193991372 = "NEW_INTENT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1003177583 = "RECEIVER";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_2019906579 = "CREATE_SERVICE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1346998060 = "SERVICE_ARGS";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1549955559 = "STOP_SERVICE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1438108485 = "REQUEST_THUMBNAIL";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1775910327 = "CONFIGURATION_CHANGED";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_2052650214 = "CLEAN_UP_CONTEXT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_155294750 = "GC_WHEN_IDLE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_835125871 = "BIND_SERVICE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1056924531 = "UNBIND_SERVICE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_2054312266 = "DUMP_SERVICE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1623012468 = "LOW_MEMORY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_379209317 = "ACTIVITY_CONFIGURATION_CHANGED";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1311528951 = "RELAUNCH_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1051058362 = "PROFILER_CONTROL";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1336766832 = "CREATE_BACKUP_AGENT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_509083873 = "DESTROY_BACKUP_AGENT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1270118566 = "SUICIDE";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_306253609 = "REMOVE_PROVIDER";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1121202251 = "ENABLE_JIT";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_842677545 = "DISPATCH_PACKAGE_BROADCAST";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_386909507 = "SCHEDULE_CRASH";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_549678638 = "DUMP_HEAP";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_62018345 = "DUMP_ACTIVITY";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_848538566 = "SLEEPING";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_710170950 = "SET_CORE_SETTINGS";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1144730846 = "UPDATE_PACKAGE_COMPATIBILITY_INFO";
                
                
                varB4EAC82CA7396A68D541C85D26508E83_1530581689 = "TRIM_MEMORY";
                
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1079023403 = "(unknown)";
            addTaint(code);
            String varA7E53CE21691AB073D9660D615818899_1988712965; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1398565327;
                    break;
                case 2: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_458996058;
                    break;
                case 3: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_2084638897;
                    break;
                case 4: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_98945728;
                    break;
                case 5: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1765716512;
                    break;
                case 6: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_721311701;
                    break;
                case 7: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_418411736;
                    break;
                case 8: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_949841536;
                    break;
                case 9: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1368621001;
                    break;
                case 10: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_795825906;
                    break;
                case 11: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_384195501;
                    break;
                case 12: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1461055576;
                    break;
                case 13: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_193991372;
                    break;
                case 14: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1003177583;
                    break;
                case 15: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_2019906579;
                    break;
                case 16: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1346998060;
                    break;
                case 17: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1549955559;
                    break;
                case 18: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1438108485;
                    break;
                case 19: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1775910327;
                    break;
                case 20: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_2052650214;
                    break;
                case 21: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_155294750;
                    break;
                case 22: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_835125871;
                    break;
                case 23: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1056924531;
                    break;
                case 24: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_2054312266;
                    break;
                case 25: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1623012468;
                    break;
                case 26: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_379209317;
                    break;
                case 27: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1311528951;
                    break;
                case 28: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1051058362;
                    break;
                case 29: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1336766832;
                    break;
                case 30: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_509083873;
                    break;
                case 31: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1270118566;
                    break;
                case 32: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_306253609;
                    break;
                case 33: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1121202251;
                    break;
                case 34: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_842677545;
                    break;
                case 35: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_386909507;
                    break;
                case 36: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_549678638;
                    break;
                case 37: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_62018345;
                    break;
                case 38: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_848538566;
                    break;
                case 39: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_710170950;
                    break;
                case 40: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1144730846;
                    break;
                case 41: 
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1530581689;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1988712965 = varB4EAC82CA7396A68D541C85D26508E83_1079023403;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1988712965.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1988712965;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.021 -0400", hash_original_method = "DC9C3E5B703CFDFA18C27F800AA1CA40", hash_generated_method = "51274CBDB76FBCF6ACFA6154FC583191")
        public void handleMessage(Message msg) {
            
            {
                ActivityClientRecord r = (ActivityClientRecord)msg.obj;
                r.packageInfo = getPackageInfoNoCheck(
                            r.activityInfo.applicationInfo, r.compatInfo);
                handleLaunchActivity(r, null);
            } 
            
            
            {
                ActivityClientRecord r = (ActivityClientRecord)msg.obj;
                handleRelaunchActivity(r);
            } 
            
            
            handlePauseActivity((IBinder)msg.obj, false, msg.arg1 != 0, msg.arg2);
            
            
            maybeSnapshot();
            
            
            handlePauseActivity((IBinder)msg.obj, true, msg.arg1 != 0, msg.arg2);
            
            
            handleStopActivity((IBinder)msg.obj, true, msg.arg2);
            
            
            handleStopActivity((IBinder)msg.obj, false, msg.arg2);
            
            
            handleWindowVisibility((IBinder)msg.obj, true);
            
            
            handleWindowVisibility((IBinder)msg.obj, false);
            
            
            handleResumeActivity((IBinder)msg.obj, true,
                            msg.arg1 != 0);
            
            
            handleSendResult((ResultData)msg.obj);
            
            
            handleDestroyActivity((IBinder)msg.obj, msg.arg1 != 0,
                            msg.arg2, false);
            
            
            AppBindData data = (AppBindData)msg.obj;
            
            
            handleBindApplication(data);
            
            
            {
                mInitialApplication.onTerminate();
            } 
            
            
            Looper.myLooper().quit();
            
            
            handleNewIntent((NewIntentData)msg.obj);
            
            
            handleReceiver((ReceiverData)msg.obj);
            
            
            maybeSnapshot();
            
            
            handleCreateService((CreateServiceData)msg.obj);
            
            
            handleBindService((BindServiceData)msg.obj);
            
            
            handleUnbindService((BindServiceData)msg.obj);
            
            
            handleServiceArgs((ServiceArgsData)msg.obj);
            
            
            handleStopService((IBinder)msg.obj);
            
            
            maybeSnapshot();
            
            
            handleRequestThumbnail((IBinder)msg.obj);
            
            
            handleConfigurationChanged((Configuration)msg.obj, null);
            
            
            ContextCleanupInfo cci = (ContextCleanupInfo)msg.obj;
            
            
            cci.context.performFinalCleanup(cci.who, cci.what);
            
            
            scheduleGcIdler();
            
            
            handleDumpService((DumpComponentInfo)msg.obj);
            
            
            handleLowMemory();
            
            
            handleActivityConfigurationChanged((IBinder)msg.obj);
            
            
            handleProfilerControl(msg.arg1 != 0, (ProfilerControlData)msg.obj, msg.arg2);
            
            
            handleCreateBackupAgent((CreateBackupAgentData)msg.obj);
            
            
            handleDestroyBackupAgent((CreateBackupAgentData)msg.obj);
            
            
            Process.killProcess(Process.myPid());
            
            
            completeRemoveProvider((IContentProvider)msg.obj);
            
            
            ensureJitEnabled();
            
            
            handleDispatchPackageBroadcast(msg.arg1, (String[])msg.obj);
            
            
            if (DroidSafeAndroidRuntime.control) throw new RemoteServiceException((String)msg.obj);
            
            
            handleDumpHeap(msg.arg1 != 0, (DumpHeapData)msg.obj);
            
            
            handleDumpActivity((DumpComponentInfo)msg.obj);
            
            
            handleSleeping((IBinder)msg.obj, msg.arg1 != 0);
            
            
            handleSetCoreSettings((Bundle) msg.obj);
            
            
            handleUpdatePackageCompatibilityInfo((UpdateCompatibilityData)msg.obj);
            
            
            handleTrimMemory(msg.arg1);
            
            addTaint(msg.getTaint());
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.022 -0400", hash_original_method = "E92E43C77FF76A1843097A49ADA7442E", hash_generated_method = "7450CE226DDBE8CC1A49EF98CC071298")
        private void maybeSnapshot() {
            {
                boolean var729A603993F3B35DA9B3209A1DADBC52_2136098134 = (mBoundApplication != null && SamplingProfilerIntegration.isEnabled());
                {
                    String packageName = mBoundApplication.info.mPackageName;
                    android.content.pm.PackageInfo packageInfo = null;
                    try 
                    {
                        Context context = getSystemContext();
                        PackageManager pm = context.getPackageManager();
                        packageInfo = pm.getPackageInfo(
                            packageName, PackageManager.GET_ACTIVITIES);
                    } 
                    catch (NameNotFoundException e)
                    { }
                    SamplingProfilerIntegration.writeSnapshot(mBoundApplication.processName, packageInfo);
                } 
            } 
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "722CEDE668F96C619AD9AE4EE59CCD7B", hash_generated_field = "79EE3E0E74CCDF8DA485137663462447")

        public static final int LAUNCH_ACTIVITY         = 100;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "7C6BEE59AC8DEB3272ACA35B77D0ECB8", hash_generated_field = "F6E6C101887932ADB1F39FD5B86A118E")

        public static final int PAUSE_ACTIVITY          = 101;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "27E7CCADA8E378177A09B210CB7998B9", hash_generated_field = "09D07137EA5653F1E891575A10F54C95")

        public static final int PAUSE_ACTIVITY_FINISHING= 102;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "DC0C14DC0B1F89A47A5B1280137AB9E3", hash_generated_field = "EC045D213E7DCC46FAC0B6AAED7E85D6")

        public static final int STOP_ACTIVITY_SHOW      = 103;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "E188806E5AACE94BD962909A9F9D11B7", hash_generated_field = "25971E3B508C10EDB2E29C96206F822B")

        public static final int STOP_ACTIVITY_HIDE      = 104;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.023 -0400", hash_original_field = "D3BBE314F0306D0843A920C0579FAD38", hash_generated_field = "0FBE2B02A08E08DD92AF03DD97DDA5AE")

        public static final int SHOW_WINDOW             = 105;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "AEEF026EB5CD7DCEC2DB87D54CB22A26", hash_generated_field = "B048EDF2C316D4329B5527B43CEDFE50")

        public static final int HIDE_WINDOW             = 106;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "518DFFD71C73003A033FA6BC1B294FC6", hash_generated_field = "D40012091267201A48CEA7D4C55C1620")

        public static final int RESUME_ACTIVITY         = 107;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "40995C694C9D49F47FA7514A7F959820", hash_generated_field = "A40A106C973F0FB170D2DAC3448C5A13")

        public static final int SEND_RESULT             = 108;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "2BCF8356B8869C9E49E05C226AB9C831", hash_generated_field = "F3C8D3955BE8F2810694F3E7013C556E")

        public static final int DESTROY_ACTIVITY        = 109;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "72110ACC314A9846CE925BF8B24FB2C4", hash_generated_field = "9E021100AE53B786AFAD15A16329BAB4")

        public static final int BIND_APPLICATION        = 110;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "C8EB10E0EF2483EDA8A276929FEC0A42", hash_generated_field = "D9A851E248DD3DA74E867B25E117FD22")

        public static final int EXIT_APPLICATION        = 111;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "C51444BA300FE3DFDBF5E4BACC59B339", hash_generated_field = "E81354CA5082AEBC39D8C31B119790DD")

        public static final int NEW_INTENT              = 112;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.024 -0400", hash_original_field = "5F934832E9EA645D6B42B183077116BE", hash_generated_field = "BC2E16123EEC2C2FE2146178A6F6EBE7")

        public static final int RECEIVER                = 113;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "DF58095DA1EF21EA8AFE7DC349A8C5EE", hash_generated_field = "46F82A63643EBF3740DA044A97C411BD")

        public static final int CREATE_SERVICE          = 114;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "ADC07D5CB42F74F249ED9FA053F1F453", hash_generated_field = "A20CACB6EB007BA6D6D1EAE18B100F96")

        public static final int SERVICE_ARGS            = 115;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "DA80AE7CA253D962B8BA0A9C2B53B49E", hash_generated_field = "AB975960BB4220B2FCB171489C6584C5")

        public static final int STOP_SERVICE            = 116;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "8FDB2CCAA7CDF8F31A6175479EDFB50A", hash_generated_field = "DA58382979407C0DCE4E024C9F856907")

        public static final int REQUEST_THUMBNAIL       = 117;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "1832887E832CF03CCE11F98660915BA9", hash_generated_field = "F8782D86E0C72BFCA118C31A420D9DB2")

        public static final int CONFIGURATION_CHANGED   = 118;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "B69BEAC73959E05CD1A9C07F9E505BF9", hash_generated_field = "203638C0D401316316F231069A439983")

        public static final int CLEAN_UP_CONTEXT        = 119;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.025 -0400", hash_original_field = "524F3CBD925BC2700E2FE96AFB6C6814", hash_generated_field = "7FDF10F5D0B32576CCE522E8063EE1AB")

        public static final int GC_WHEN_IDLE            = 120;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "3742E17E26429D8B18102CF3986F6EC2", hash_generated_field = "FA82AB4CAC5570F743636186326BBBCB")

        public static final int BIND_SERVICE            = 121;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "15BD5376B9A6F8BB72279CD48F03813F", hash_generated_field = "3AA49274B99CB4754DE7AAC22A64097B")

        public static final int UNBIND_SERVICE          = 122;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "4CE5A2061279EE1D7222C2D95BD68317", hash_generated_field = "BE57D55C848AF78B6D13D08C75CD3890")

        public static final int DUMP_SERVICE            = 123;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "CE13FEC4244FD5042DEA52894A5793E4", hash_generated_field = "016852C1459DE34F8D1BECDF172A7A3B")

        public static final int LOW_MEMORY              = 124;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "C7101CE79C508314D48E359FD888E39C", hash_generated_field = "C1874358A5069FBBE942CA7B4FEB06AC")

        public static final int ACTIVITY_CONFIGURATION_CHANGED = 125;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "FA7FD8D6AC5C010F87FE5A85800EF7ED", hash_generated_field = "F66CB5E4AB6DEA952AC6C4AC4FD8129C")

        public static final int RELAUNCH_ACTIVITY       = 126;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "0ECDAAA38F1875EBF22B06CF4D97840D", hash_generated_field = "B3A767EE70C05E487D7B390CB511DE9C")

        public static final int PROFILER_CONTROL        = 127;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.026 -0400", hash_original_field = "3BC29C9DB33C1749A39F6BAE42EB6789", hash_generated_field = "385AB826C3B946556BB8D2BA1F6167CB")

        public static final int CREATE_BACKUP_AGENT     = 128;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "C783232AA4EE8DD32768F1B54E157355", hash_generated_field = "72995E16D3DBD2A4679635D4E61FC49D")

        public static final int DESTROY_BACKUP_AGENT    = 129;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "A0AB320ED67492363EAFB1A4223F0B32", hash_generated_field = "2E6A83D9FB3FCAFBC6EA64132F417F75")

        public static final int SUICIDE                 = 130;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "9A5FCDBB5243520A850EF658F203D220", hash_generated_field = "7DBF1A92BA0E6AA87182CD56B3D107E3")

        public static final int REMOVE_PROVIDER         = 131;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "66EC3392B95DE4AF1DB032BB1B33C503", hash_generated_field = "AA41E7437D6E941DE853C39868725DE4")

        public static final int ENABLE_JIT              = 132;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "97FF97449C421C91A81CB7768A612B09", hash_generated_field = "77AEBFDF31780CFDC843B8D9EAB26B65")

        public static final int DISPATCH_PACKAGE_BROADCAST = 133;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "750A8194549152ABCA207A461974A0F2", hash_generated_field = "2F79168F541635B32A56D3A800568EB5")

        public static final int SCHEDULE_CRASH          = 134;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.027 -0400", hash_original_field = "CE74C94F7495E6DA3E31F74989140E11", hash_generated_field = "AE9A74DBF18BA76BECBDADA426FDD8D1")

        public static final int DUMP_HEAP               = 135;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_field = "B1D84959B056AFDF77A071642B0B4DDE", hash_generated_field = "2312CB238555E0BCB137FC118844BDC3")

        public static final int DUMP_ACTIVITY           = 136;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_field = "EC1261A9F39672203AD216DA43C7C314", hash_generated_field = "4EAC68079DDB116BDF58C13AC47AF396")

        public static final int SLEEPING                = 137;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_field = "33DB7ACE50C2A3180517FF1D30A7D18B", hash_generated_field = "7CA400DE0EBC79FF2A4805A342BE87B5")

        public static final int SET_CORE_SETTINGS       = 138;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_field = "930E95663EFFE03E81FB9BE166DBCB37", hash_generated_field = "CFEBE5355040D28519CBFFA29E96E50F")

        public static final int UPDATE_PACKAGE_COMPATIBILITY_INFO = 139;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_field = "C8ED1A4929B7571B8B7A3A096311133B", hash_generated_field = "CF745352D226FFB32A7FEB6BFD662619")

        public static final int TRIM_MEMORY             = 140;
    }


    
    private class Idler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.028 -0400", hash_original_method = "33AE74878CEBE3B527FC27BCFED9133E", hash_generated_method = "33AE74878CEBE3B527FC27BCFED9133E")
        public Idler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.029 -0400", hash_original_method = "7124AFC3D8D2CB12FD15B850DC795363", hash_generated_method = "0170A6609D7621ACE4ECDDEA0A43DB38")
        public final boolean queueIdle() {
            ActivityClientRecord a = mNewActivities;
            boolean stopProfiling = false;
            {
                stopProfiling = true;
            } 
            {
                mNewActivities = null;
                IActivityManager am = ActivityManagerNative.getDefault();
                ActivityClientRecord prev;
                {
                    {
                        try 
                        {
                            am.activityIdle(a.token, a.createdConfig, stopProfiling);
                            a.createdConfig = null;
                        } 
                        catch (RemoteException ex)
                        { }
                    } 
                    prev = a;
                    a = a.nextIdle;
                    prev.nextIdle = null;
                } 
            } 
            {
                mProfiler.stopProfiling();
            } 
            ensureJitEnabled();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_71878499 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_71878499;
            
            
        }

        
    }


    
    final class GcIdler implements MessageQueue.IdleHandler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.029 -0400", hash_original_method = "ABBE7DCE196E12604C1E7133F511F6FC", hash_generated_method = "ABBE7DCE196E12604C1E7133F511F6FC")
        public GcIdler ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.030 -0400", hash_original_method = "44179B8732E18ADC2B8565E550483147", hash_generated_method = "F76FE76A1C3EE2373411815E6DD9F244")
        public final boolean queueIdle() {
            doGcIfNeeded();
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_490100851 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_490100851;
            
            
            
        }

        
    }


    
    private static class ResourcesKey {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.030 -0400", hash_original_field = "E6DEC81428C06CF3161B8FA0C4811101", hash_generated_field = "16A785049F12D1DFDF4F72387E1D9EFB")

        private String mResDir;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.031 -0400", hash_original_field = "275FA34397492A04DE22E307142BC45D", hash_generated_field = "8561DC852E8BD04B40EFBC1F32D92895")

        private float mScale;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.031 -0400", hash_original_field = "EDC211DB900F40F9CAE89C00A3C90AD9", hash_generated_field = "A7D12DAC99918DD08DC20BE8E0E23E1B")

        private int mHash;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.032 -0400", hash_original_method = "0A249A0E32348D1ED1AC3A6D16406BEA", hash_generated_method = "60A5475EFF1937E45B7BF5B2F50F200B")
          ResourcesKey(String resDir, float scale) {
            mResDir = resDir;
            mScale = scale;
            mHash = mResDir.hashCode() << 2 + (int) (mScale * 2);
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.033 -0400", hash_original_method = "FDD99B6C6105A3F31D8E7DC9390101DA", hash_generated_method = "54813C75854919F82E2304710CCEFE51")
        @Override
        public int hashCode() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49940132 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49940132;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.034 -0400", hash_original_method = "07DFB89699884113D8C2B96163B07C7F", hash_generated_method = "DAD1B03B656C1DC81BC2356C5225A11B")
        @Override
        public boolean equals(Object obj) {
            ResourcesKey peer = (ResourcesKey) obj;
            boolean var54097B77060828B14B7DD9EC110667F0_38623059 = (mResDir.equals(peer.mResDir) && mScale == peer.mScale);
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1365835040 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1365835040;
            
            
                
            
            
            
        }

        
    }


    
    private static class StopInfo {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.034 -0400", hash_original_field = "951D4DFF3C22E9FCC4A2707009F45EA8", hash_generated_field = "671EE8F19CE89CCA3E5285825682D0E2")

        Bitmap thumbnail;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.034 -0400", hash_original_field = "67DAF92C833C41C95DB874E18FCB2786", hash_generated_field = "4C2BAB005F4C5A1BF9E436D5BA36EABB")

        CharSequence description;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.034 -0400", hash_original_method = "59EF1C21B91F2644F32BF61E1E80BB9E", hash_generated_method = "59EF1C21B91F2644F32BF61E1E80BB9E")
        public StopInfo ()
        {
            
        }


    }


    
    private static final class ProviderRefCount {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.035 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "21B1DF5337CCD3E0731435FB1361ED67")

        public int count;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.035 -0400", hash_original_method = "92B7A170BA9BC140C9702B48E38F46E8", hash_generated_method = "4A93BF52DF489431CBF421164E067011")
          ProviderRefCount(int pCount) {
            count = pCount;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.035 -0400", hash_original_field = "34FDD53B5E6A10E8767A5E0043343C94", hash_generated_field = "425ACCA9C7A1870DD248AAA65FD54971")

    public static final String TAG = "ActivityThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.035 -0400", hash_original_field = "83F8875443EA39A07A5B37A3724C8054", hash_generated_field = "4FF79E3794E106C584E301B2B6BC3768")

    private static final android.graphics.Bitmap.Config THUMBNAIL_FORMAT = Bitmap.Config.RGB_565;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "6225589B7095A2A8B4D13D7070C07695", hash_generated_field = "071B7B77A9473B9527F9198838C91D11")

    static final boolean localLOGV = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "B3FD9C27E71EC619E39A58558EDF3036", hash_generated_field = "3E8F6F612D86B529FF072C0082938083")

    static final boolean DEBUG_MESSAGES = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "07B77DD4826C3BEC455D95A864B72887", hash_generated_field = "6C9EE624F63E1C2CAB461CACB0D16387")

    public static final boolean DEBUG_BROADCAST = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "C1F0DE5C32CA1844900CC6BE3D463A43", hash_generated_field = "91674D83CE8A87566FA90CCE79A6CC85")

    private static final boolean DEBUG_RESULTS = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "02D938CC958225A67031500CA26D971D", hash_generated_field = "1C5ED879567745A3D8BB78B4EBE8FFE6")

    private static final boolean DEBUG_BACKUP = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "D146DDB94A0D3A63C400058639AEBC96", hash_generated_field = "56656CF0D95F01C6330394450066014A")

    private static final boolean DEBUG_CONFIGURATION = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "95E53F781A83DB02B99AB3900C2C7910", hash_generated_field = "F1C876B177B2AB25A282C24BF376C834")

    private static final long MIN_TIME_BETWEEN_GCS = 5*1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.036 -0400", hash_original_field = "CA66A5F91375944277EA9D4BD909BB19", hash_generated_field = "281968F0BF027264BDDA5DC375DC6283")

    private static final Pattern PATTERN_SEMICOLON = Pattern.compile(";");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "9286A6A3B31A2E01F0E11BFB8849AA7C", hash_generated_field = "6F19A1C876184A0ADFFBF4577E6D8405")

    private static final int SQLITE_MEM_RELEASED_EVENT_LOG_TAG = 75003;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "BB5DE43B41F17D8A8E055223ED42E745", hash_generated_field = "E28C89FE2A6C28B4023589A16739DF35")

    private static final int LOG_ON_PAUSE_CALLED = 30021;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "80F691776CC864CF51EEA7DD7E478D83", hash_generated_field = "527D0F0BC32722D4952F258103167308")

    private static final int LOG_ON_RESUME_CALLED = 30022;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "E95028B5077B5EE8819464B14D52B9CA", hash_generated_field = "C6FF716724281192967733BEA8F63EE5")

    static ContextImpl mSystemContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "758BE64E47881C41CB626D9F77009B70", hash_generated_field = "89DED1E64F20B301AC92B7782A3B4974")

    static IPackageManager sPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "5C9F282BC1F2B74095E784FCC3BEC9F9", hash_generated_field = "5C8AC51EFF922C63EFC9F15B72A07218")

    static final ThreadLocal<ActivityThread> sThreadLocal = new ThreadLocal<ActivityThread>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.037 -0400", hash_original_field = "03FC11B1885ADD83E904E0299842923E", hash_generated_field = "FBC75DA053AA4DB0E9FC91A30C88AF67")

    static Handler sMainThreadHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.038 -0400", hash_original_field = "3BEAF3224097BD2645583753F770DF18", hash_generated_field = "2F4C1A0F908C99E4E3AF95D1DBBBE434")

    private static final ThreadLocal<Intent> sCurrentBroadcastIntent = new ThreadLocal<Intent>();
}

