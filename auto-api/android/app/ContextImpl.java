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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.657 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.666 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "392814ABECAC15568862F6BA7DC6F670")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1868880206 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868880206 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1868880206.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868880206;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.684 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "52484D3785B6DCFDA27B7D982337EBBC")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to register to receive intents");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.698 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "6D42F49450783EB97CC914D26D9E59B7")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1243396993 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1243396993;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.709 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.709 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.710 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.711 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.711 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.726 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.726 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.727 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.734 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.735 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.736 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.737 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.752 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "C6AED20E83CF866AEB59A5DE1C3D1EA2")

    private Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.752 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.753 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.753 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.754 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.766 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.766 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.767 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.767 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "2F69AB504EDBEC75083AAFA041ED1434")

    ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.774 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
      ContextImpl() {
        mOuterContext = this;
        // ---------- Original Method ----------
        //mOuterContext = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.778 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
    public  ContextImpl(ContextImpl context) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.816 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "928B4EE036138D6111DCFC4CDA828507")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_1244930909 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1244930909 = mResources.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_1244930909.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1244930909;
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.818 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "46F5FC9B8DDA6F6AB269AD01B8DF4884")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_192132378 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_192132378 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_192132378.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_192132378;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.842 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "0FAEC4A303216D11CE8EDBCA87BA7580")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1053418101 = null; //Variable for return #1
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1557592593 = null; //Variable for return #2
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1719499375 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1053418101 = mPackageManager;
        } //End block
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1557592593 = (mPackageManager = new ApplicationPackageManager(this, pm));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1719499375 = null;
        PackageManager varA7E53CE21691AB073D9660D615818899_266088647; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_266088647 = varB4EAC82CA7396A68D541C85D26508E83_1053418101;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_266088647 = varB4EAC82CA7396A68D541C85D26508E83_1557592593;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_266088647 = varB4EAC82CA7396A68D541C85D26508E83_1719499375;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_266088647.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_266088647;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.864 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "E810A1025A939A51E980E19780AA89AE")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_1510029817 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1510029817 = mContentResolver;
        varB4EAC82CA7396A68D541C85D26508E83_1510029817.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1510029817;
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.878 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "374A4B0776180196E2C5D6A3AD3E50DB")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1081306920 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1081306920 = mMainThread.getLooper();
        varB4EAC82CA7396A68D541C85D26508E83_1081306920.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1081306920;
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.891 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "5E71251D37672631D3DF678FF244ADDA")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_117138574 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_117138574 = (mPackageInfo != null) ?
                mPackageInfo.getApplication() : mMainThread.getApplication();
        varB4EAC82CA7396A68D541C85D26508E83_117138574.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_117138574;
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.893 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "DAC2322817B2898A8DBFE4A50CECD38D")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.910 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "50A61FF5EB9412F0684D322C198B9B03")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102648331 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2102648331;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.925 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "E881CDCDED9D8798821DA20279D294B4")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1960266236 = null; //Variable for return #1
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1960266236 = mTheme;
        varB4EAC82CA7396A68D541C85D26508E83_1960266236.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1960266236;
        // ---------- Original Method ----------
        //if (mTheme == null) {
            //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    //getOuterContext().getApplicationInfo().targetSdkVersion);
            //mTheme = mResources.newTheme();
            //mTheme.applyStyle(mThemeResource, true);
        //}
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:46.946 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "BDEE16797CA1427434BEBF87F2E981E8")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1998124688 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1998124688 = mPackageInfo != null ?
                mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_1998124688.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1998124688;
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.023 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "E1566AB1D26FA6E560F75464C264152D")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_485345668 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_485345668 = mPackageInfo.getPackageName();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_485345668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_485345668;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.055 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "43D5F9D2E89977F9D6F1959C532EDB0F")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_227501153 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_227501153 = mPackageInfo.getApplicationInfo();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_227501153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_227501153;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.071 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "FEAFDE9767FB15E18A04EDA943A182CB")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1985648439 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1985648439 = mPackageInfo.getResDir();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1985648439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1985648439;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.073 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "F2DCEDFBFA015A57B95544223292594C")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_445464672 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_445464672 = mPackageInfo.getAppDir();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_445464672.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_445464672;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.095 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "B7A99DC60AB692C522E655BF57B24C6C")
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1411800895 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1411800895 = makeFilename(getPreferencesDir(), name + ".xml");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1411800895.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1411800895;
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.114 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "42A22161D2530311E43DF096F1F5B24D")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1061546542 = null; //Variable for return #1
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1860786308 = null; //Variable for return #2
        SharedPreferencesImpl sp;
        {
            sp = sSharedPrefs.get(name);
            {
                File prefsFile;
                prefsFile = getSharedPrefsFile(name);
                sp = new SharedPreferencesImpl(prefsFile, mode);
                sSharedPrefs.put(name, sp);
                varB4EAC82CA7396A68D541C85D26508E83_1061546542 = sp;
            } //End block
        } //End block
        {
            boolean var2E6124E1185D02CDB2C7C679C6727913_241903378 = ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB);
            {
                sp.startReloadIfChangedUnexpectedly();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1860786308 = sp;
        addTaint(name.getTaint());
        addTaint(mode);
        SharedPreferences varA7E53CE21691AB073D9660D615818899_1835519439; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1835519439 = varB4EAC82CA7396A68D541C85D26508E83_1061546542;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1835519439 = varB4EAC82CA7396A68D541C85D26508E83_1860786308;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1835519439.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1835519439;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.116 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "22B9F0AEF778BE480BAAB714F28AAA7C")
    private File getPreferencesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_968010711 = null; //Variable for return #1
        {
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_968010711 = mPreferencesDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_968010711.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_968010711;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.128 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "E4970AC4900522F3BDB2D34255452777")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_2010394365 = null; //Variable for return #1
        File f;
        f = makeFilename(getFilesDir(), name);
        varB4EAC82CA7396A68D541C85D26508E83_2010394365 = new FileInputStream(f);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2010394365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2010394365;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.144 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "8C33B17BFF81A08245E68AF65E5B8C12")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_101417065 = null; //Variable for return #1
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_309944398 = null; //Variable for return #2
        boolean append;
        append = (mode&MODE_APPEND) != 0;
        File f;
        f = makeFilename(getFilesDir(), name);
        try 
        {
            FileOutputStream fos;
            fos = new FileOutputStream(f, append);
            setFilePermissionsFromMode(f.getPath(), mode, 0);
            varB4EAC82CA7396A68D541C85D26508E83_101417065 = fos;
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
        varB4EAC82CA7396A68D541C85D26508E83_309944398 = fos;
        addTaint(name.getTaint());
        addTaint(mode);
        FileOutputStream varA7E53CE21691AB073D9660D615818899_1767531314; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1767531314 = varB4EAC82CA7396A68D541C85D26508E83_101417065;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1767531314 = varB4EAC82CA7396A68D541C85D26508E83_309944398;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1767531314.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1767531314;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.160 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "BACAC55E10A9F4BB86193D8783656638")
    @Override
    public boolean deleteFile(String name) {
        File f;
        f = makeFilename(getFilesDir(), name);
        boolean varF551010B15D2D277CEBBB446DD2917F7_762189537 = (f.delete());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_338543756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_338543756;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.171 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "5CE8F21480C05DEBD27463869C0A9212")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1544641963 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1146774806 = null; //Variable for return #2
        {
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } //End block
            {
                boolean var19E4FA9AD9694173D1E5B3B11060E583_598948755 = (!mFilesDir.exists());
                {
                    {
                        boolean var20989B86B1B7C5B3A21029C102C7B0F0_325411161 = (!mFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1544641963 = null;
                        } //End block
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1146774806 = mFilesDir;
        } //End block
        File varA7E53CE21691AB073D9660D615818899_1692934970; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1692934970 = varB4EAC82CA7396A68D541C85D26508E83_1544641963;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1692934970 = varB4EAC82CA7396A68D541C85D26508E83_1146774806;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1692934970.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1692934970;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.202 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "F3E6EC593F7F86AB83163148FEC5872E")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_2040650507 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_631293731 = null; //Variable for return #2
        File varB4EAC82CA7396A68D541C85D26508E83_1524947411 = null; //Variable for return #3
        File varB4EAC82CA7396A68D541C85D26508E83_670893901 = null; //Variable for return #4
        {
            {
                mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(
                        getPackageName());
            } //End block
            {
                boolean varB276A181C4EB3EF93304E7B1C49EFB6B_1424532681 = (!mExternalFilesDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean var675269D0F3BF0B3D2DEA41EAF426F526_608489396 = (!mExternalFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_2040650507 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_631293731 = mExternalFilesDir;
            } //End block
            File dir;
            dir = new File(mExternalFilesDir, type);
            {
                boolean varFE8E78642ABD38646DA929922A7BF3DC_45855680 = (!dir.exists());
                {
                    {
                        boolean varCC013DA93565AE954394EDAB638D90F5_1055425113 = (!dir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1524947411 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_670893901 = dir;
        } //End block
        addTaint(type.getTaint());
        File varA7E53CE21691AB073D9660D615818899_2003727542; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2003727542 = varB4EAC82CA7396A68D541C85D26508E83_2040650507;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2003727542 = varB4EAC82CA7396A68D541C85D26508E83_631293731;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2003727542 = varB4EAC82CA7396A68D541C85D26508E83_1524947411;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2003727542 = varB4EAC82CA7396A68D541C85D26508E83_670893901;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2003727542.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2003727542;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.205 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "D8D98B858209230C60F305203233C1E8")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1394294195 = null; //Variable for return #1
        {
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1394294195 = mObbDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1394294195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1394294195;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mObbDir == null) {
                //mObbDir = Environment.getExternalStorageAppObbDirectory(
                        //getPackageName());
            //}
            //return mObbDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.224 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "6633D8A7B3F65F0747F2DF40BD3244D9")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_641487218 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1672533665 = null; //Variable for return #2
        {
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } //End block
            {
                boolean var2F5430C0F48CD9EE00D803058AB5029F_1739047586 = (!mCacheDir.exists());
                {
                    {
                        boolean var83D0E63134D15DC773688937A5F3BD28_225732529 = (!mCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_641487218 = null;
                        } //End block
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1672533665 = mCacheDir;
        File varA7E53CE21691AB073D9660D615818899_1403718447; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1403718447 = varB4EAC82CA7396A68D541C85D26508E83_641487218;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1403718447 = varB4EAC82CA7396A68D541C85D26508E83_1672533665;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1403718447.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1403718447;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.253 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "92479A951FC23DD610679835DD897119")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1832627676 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_801407665 = null; //Variable for return #2
        {
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } //End block
            {
                boolean var00D9D94DA81ED9ECF73133C2FCFD94BC_152432956 = (!mExternalCacheDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean varBF80BF4F4103A772CF6C96028B68472F_1547164028 = (!mExternalCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1832627676 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_801407665 = mExternalCacheDir;
        } //End block
        File varA7E53CE21691AB073D9660D615818899_1915850141; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1915850141 = varB4EAC82CA7396A68D541C85D26508E83_1832627676;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1915850141 = varB4EAC82CA7396A68D541C85D26508E83_801407665;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1915850141.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1915850141;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.270 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "CD86DBA0B30406B4095D60A5ACCCEE16")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_2146256524 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2146256524 = makeFilename(getFilesDir(), name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2146256524.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2146256524;
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.273 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "6FFF9E56D3A9B063A4B21C6522870439")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_332801257 = null; //Variable for return #1
        String[] list;
        list = getFilesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_332801257 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_332801257.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_332801257;
        // ---------- Original Method ----------
        //final String[] list = getFilesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.302 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "75B941F0C646E854FB145B651AA91567")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_76604338 = null; //Variable for return #1
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_76604338 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_76604338.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_76604338;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.306 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "D72D93FC75F2BAB4FD957CE121D22E69")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_310114575 = null; //Variable for return #1
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_310114575 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_310114575.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_310114575;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.330 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "0DE4B51519E58DBE2A106D6B26ACFAE3")
    @Override
    public boolean deleteDatabase(String name) {
        try 
        {
            File f;
            f = validateFilePath(name, false);
            boolean varABE1B429208141FF7999C4FBA16347A8_2142221656 = (f.delete());
        } //End block
        catch (Exception e)
        { }
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_81674913 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_81674913;
        // ---------- Original Method ----------
        //try {
            //File f = validateFilePath(name, false);
            //return f.delete();
        //} catch (Exception e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.332 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "5F6A7065D9D22CC9F749F79A41BD32B4")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1411112820 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1411112820 = validateFilePath(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1411112820.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1411112820;
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.343 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "FA89D70A31FF8B46A12BCA4993833D97")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1008703026 = null; //Variable for return #1
        String[] list;
        list = getDatabasesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_1008703026 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_1008703026.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1008703026;
        // ---------- Original Method ----------
        //final String[] list = getDatabasesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.350 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "8BEBBD8E6EF3BEF7C3C513872586286A")
    private File getDatabasesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1597551924 = null; //Variable for return #1
        {
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
            {
                boolean var0314E0B292381BE9F1623149CD8F8489_777277385 = (mDatabasesDir.getPath().equals("databases"));
                {
                    mDatabasesDir = new File("/data/system");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1597551924 = mDatabasesDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1597551924.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1597551924;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.369 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "AF6293BF765103CD493614518DFF789B")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1825849337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1825849337 = getWallpaperManager().getDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_1825849337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1825849337;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.384 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "A78FF33E1EE62E3834C97E3BEF804991")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_413705020 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_413705020 = getWallpaperManager().peekDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_413705020.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_413705020;
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.386 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "F6AD0E05F8AD36208290386AAE18A592")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varC254F548CFAB2206D8996DEF871ED770_1715692744 = (getWallpaperManager().getDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705686571 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_705686571;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.387 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "D2DD84D27AD5ABDCB608ED2CBF97B15A")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var0CAE8BF1444C70E01A3CB5415A62929F_1638390835 = (getWallpaperManager().getDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303509657 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_303509657;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.409 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "A75BF9B3D3C58601D6E604F0244A040F")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        getWallpaperManager().setBitmap(bitmap);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.410 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "2CF6AFCB1D96AF0794551FECD14D6F8B")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        getWallpaperManager().setStream(data);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.411 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.433 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "9B65D491DC7A0B6142F2D90D805E1FAE")
    @Override
    public void startActivity(Intent intent) {
        {
            boolean var4E2CEB5436A3062C8E21590CE555C7F9_1659077426 = ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.435 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "6D65553A46DA19342C03164AAB9EBF35")
    @Override
    public void startActivities(Intent[] intents) {
        {
            boolean varB54A748E26DA9CF993CAE37B6D958C5E_894203664 = ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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
        addTaint(intents[0].getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.462 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "61EFD88F21F2325A224560E9C3E67692")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
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
        addTaint(intent.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.473 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "820865761A4B710CDD5A02B3D66BFBCB")
    @Override
    public void sendBroadcast(Intent intent) {
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
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.476 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "44F959A68D8B215DC3D2D1678CAF74AF")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
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
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.506 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "B504B7B4F82D3A2C3AC88AC5AE480396")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
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
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.534 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "DBB911C2E061634C4750943BCB165C69")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
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
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.545 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "5779378950B98E7B615C4569DD3466CE")
    @Override
    public void sendStickyBroadcast(Intent intent) {
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
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.577 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "8AFFB79076214283AAF3F7CC35B3C263")
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
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
        addTaint(intent.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.586 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "0A53F24AF5C4FFF591242CE39462FEAE")
    @Override
    public void removeStickyBroadcast(Intent intent) {
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
        addTaint(intent.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.599 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "74F77CFF69D51A42053965D8A844EA37")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1949316923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1949316923 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1949316923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1949316923;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.616 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "F62272A54FC7BA766BFD2276A1233214")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1610575825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1610575825 = registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext());
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1610575825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1610575825;
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.647 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "A841752AB6610189EA1DD61E45C752D3")
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1735724633 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_1098597409 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_1735724633 = ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1098597409 = null;
        } //End block
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(context.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_217784853; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_217784853 = varB4EAC82CA7396A68D541C85D26508E83_1735724633;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_217784853 = varB4EAC82CA7396A68D541C85D26508E83_1098597409;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_217784853.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_217784853;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.658 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "14B57999A402BDF9151594CCCD8276F6")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
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
        addTaint(receiver.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.675 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "0CFBFCC1984A9104C91CF803BF59393A")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_597376767 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1459053186 = null; //Variable for return #2
        try 
        {
            service.setAllowFds(false);
            ComponentName cn;
            cn = ActivityManagerNative.getDefault().startService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                boolean varD9D164FC49919222E3F05E39BAD0AAA7_1805045061 = (cn != null && cn.getPackageName().equals("!"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_597376767 = cn;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1459053186 = null;
        } //End block
        addTaint(service.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_443854387; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_443854387 = varB4EAC82CA7396A68D541C85D26508E83_597376767;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_443854387 = varB4EAC82CA7396A68D541C85D26508E83_1459053186;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_443854387.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_443854387;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.693 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "8BA13E3DB2D294CA937B482664E8AF5E")
    @Override
    public boolean stopService(Intent service) {
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
        addTaint(service.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957441556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957441556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.712 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "5E827A6F23A691C6133C95231D783FE0")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
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
                boolean var6493BF3E84461910769ACF3C960C9AA7_317618086 = (token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
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
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1197342613 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1197342613;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.714 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "568B477F6DACCC70BDDCDFE81FA71E7C")
    @Override
    public void unbindService(ServiceConnection conn) {
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
        addTaint(conn.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.733 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "811B8CF5CF37B20C72F2E6154FF15033")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        try 
        {
            {
                arguments.setAllowFds(false);
            } //End block
            boolean varFB737B53559144BA0BD1ED3EEC743D0D_1736139316 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743885161 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743885161;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.740 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "2B71473890FD0B809177BF4A83BEE3E3")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1471307109 = null; //Variable for return #1
        ServiceFetcher fetcher;
        fetcher = SYSTEM_SERVICE_MAP.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_1471307109 = fetcher == null ? null : fetcher.getService(this);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1471307109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471307109;
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.763 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "7848877F683F04F2D7B954FD23FF9748")
    private WallpaperManager getWallpaperManager() {
        WallpaperManager varB4EAC82CA7396A68D541C85D26508E83_2100456770 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2100456770 = (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        varB4EAC82CA7396A68D541C85D26508E83_2100456770.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2100456770;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.777 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "D5225428C004F3F28602A9DD4072CFF1")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        try 
        {
            int var5F40A2437A077EA5C807226D389206D0_1268073657 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410668428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1410668428;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.790 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "9CF6F33BB1F036574E73916A3B35BD08")
    @Override
    public int checkCallingPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_607725124 = (pid != Process.myPid());
            {
                int var78028F3F1C255CC480151714E778C1C5_867894703 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
            } //End block
        } //End collapsed parenthetic
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17887189 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_17887189;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.802 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "71B8FBB88450EE1C3FC658622670CE2F")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int var34AB0D6CBBDC631C7FDA58F28B1B657C_1687908185 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951086099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1951086099;
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.804 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "EDD1D47CFC1E4EB07F617CFE66F36636")
    private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        {
            if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
        } //End block
        addTaint(permission.getTaint());
        addTaint(resultOfCheck);
        addTaint(selfToo);
        addTaint(uid);
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.805 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "FC57B53127A557B3AD504478DDF41F73")
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        enforce(permission,
                checkPermission(permission, pid, uid),
                false,
                uid,
                message);
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforce(permission,
                //checkPermission(permission, pid, uid),
                //false,
                //uid,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.824 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "229AC75A92A0D4F7AD99D48F78CBDB05")
    public void enforceCallingPermission(String permission, String message) {
        enforce(permission,
                checkCallingPermission(permission),
                false,
                Binder.getCallingUid(),
                message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingPermission(permission),
                //false,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.834 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "F70A85011FDF2B702518E9F5FBC8913A")
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        enforce(permission,
                checkCallingOrSelfPermission(permission),
                true,
                Binder.getCallingUid(),
                message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforce(permission,
                //checkCallingOrSelfPermission(permission),
                //true,
                //Binder.getCallingUid(),
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.835 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "705590421E266ACE219C9F1FBD249610")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        try 
        {
            ActivityManagerNative.getDefault().grantUriPermission(
                    mMainThread.getApplicationThread(), toPackage, uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(toPackage.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().grantUriPermission(
                    //mMainThread.getApplicationThread(), toPackage, uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.840 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "23DE65B58A88974A4DC027D2A87330B6")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        try 
        {
            ActivityManagerNative.getDefault().revokeUriPermission(
                    mMainThread.getApplicationThread(), uri,
                    modeFlags);
        } //End block
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //try {
            //ActivityManagerNative.getDefault().revokeUriPermission(
                    //mMainThread.getApplicationThread(), uri,
                    //modeFlags);
        //} catch (RemoteException e) {
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.845 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "971F99915EF48EA53BECB0832C4321D9")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        try 
        {
            int var059CF890EB6981028B04E841A7699518_1085265598 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186321442 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1186321442;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().checkUriPermission(
                    //uri, pid, uid, modeFlags);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.877 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "5DF9176F208D70B398A03D0FFDFAF518")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_1133672290 = (pid != Process.myPid());
            {
                int varD7B1B302EF0CA5C388B6F3983890986E_484121662 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620238896 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620238896;
        // ---------- Original Method ----------
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkUriPermission(uri, pid,
                    //Binder.getCallingUid(), modeFlags);
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.880 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "10E1A43B21C8C94C226345CB35C8DC26")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int var41FF907064E7DF4DF0C5983F95FA5974_960955812 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661487220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1661487220;
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.906 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "ABB65DE98814F62C82A1D3D080F62767")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        {
            {
                boolean var7E999FB94CB59BF987157589269CB69E_509022346 = (readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBDC2A19824C9195EFA4716604E7FC089_126827694 = (writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            Object var486C2278A32794206F2AEE849917E1AC_282463344 = (checkUriPermission(uri, pid, uid, modeFlags));
        } //End flattened ternary
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992432360 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_992432360;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.922 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "DF112E326FB3C614994555E269865659")
    private String uriModeFlagToString(int uriModeFlags) {
        String varB4EAC82CA7396A68D541C85D26508E83_1523270297 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2042837747 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1093426690 = null; //Variable for return #3
        //Begin case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_1523270297 = "read and write";
        //End case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        //Begin case Intent.FLAG_GRANT_READ_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_2042837747 = "read";
        //End case Intent.FLAG_GRANT_READ_URI_PERMISSION 
        //Begin case Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_1093426690 = "write";
        //End case Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        addTaint(uriModeFlags);
        String varA7E53CE21691AB073D9660D615818899_208148438; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_208148438 = varB4EAC82CA7396A68D541C85D26508E83_1523270297;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_208148438 = varB4EAC82CA7396A68D541C85D26508E83_2042837747;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_208148438 = varB4EAC82CA7396A68D541C85D26508E83_1093426690;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_208148438.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_208148438;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.934 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "8CFA06DC20027CBEB43917E502B19401")
    private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
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
        addTaint(modeFlags);
        addTaint(resultOfCheck);
        addTaint(selfToo);
        addTaint(uid);
        addTaint(uri.getTaint());
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.942 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "49B991110E26670EAF291BA89E5B0D03")
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        enforceForUri(
                modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                false, uid, uri, message);
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkUriPermission(uri, pid, uid, modeFlags),
                //false, uid, uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.952 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "328D75B611B7291D0B4370DD352EA9F2")
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        enforceForUri(
                modeFlags, checkCallingUriPermission(uri, modeFlags),
                false, Binder.getCallingUid(), uri, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags, checkCallingUriPermission(uri, modeFlags),
                //false, Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.955 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "6CD0DED0D5BFE3583BD6DC38552CD2EC")
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        enforceForUri(
                modeFlags,
                checkCallingOrSelfUriPermission(uri, modeFlags), true,
                Binder.getCallingUid(), uri, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //enforceForUri(
                //modeFlags,
                //checkCallingOrSelfUriPermission(uri, modeFlags), true,
                //Binder.getCallingUid(), uri, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.973 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "7429D411895773CBB69129A3CE8AB0B8")
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        enforceForUri(modeFlags,
                      checkUriPermission(
                              uri, readPermission, writePermission, pid, uid,
                              modeFlags),
                      false,
                      uid,
                      uri,
                      message);
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        addTaint(message.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:47.996 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "DFE892927A6F53EE10FE94CD954760DA")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_689435050 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_1748075753 = null; //Variable for return #2
        {
            boolean varC1F5D449E2D7CC78DA5400BABA02C561_842656341 = (packageName.equals("system") || packageName.equals("android"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_689435050 = new ContextImpl(mMainThread.getSystemContext());
            } //End block
        } //End collapsed parenthetic
        LoadedApk pi;
        pi = mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        {
            ContextImpl c;
            c = new ContextImpl();
            c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            c.init(pi, null, mMainThread, mResources, mBasePackageName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1748075753 = c;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        addTaint(packageName.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_1727637824; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1727637824 = varB4EAC82CA7396A68D541C85D26508E83_689435050;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1727637824 = varB4EAC82CA7396A68D541C85D26508E83_1748075753;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1727637824.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1727637824;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.009 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "118BD92340D1FC99BB4DF928CD82E275")
    @Override
    public boolean isRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1137594825 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1137594825;
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.026 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "5BA5A1CDA54125D373090BE1BE4FD277")
    private File getDataDirFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1533618103 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1533618103 = mPackageInfo.getDataDirFile();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1533618103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1533618103;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.039 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "65753D1E7CA1E4A638731F0BEB8FF17E")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_849534910 = null; //Variable for return #1
        name = "app_" + name;
        File file;
        file = makeFilename(getDataDirFile(), name);
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_1463778055 = (!file.exists());
            {
                file.mkdir();
                setFilePermissionsFromMode(file.getPath(), mode,
                    FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_849534910 = file;
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_849534910.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_849534910;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.065 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "B7A5B5A3AAEC7FAC79639DD3C71CDE61")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        init(packageInfo, activityToken, mainThread, null, null);
        addTaint(packageInfo.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(mainThread.getTaint());
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.092 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "64A66F495EDD9D3A0DA3712A63D1896F")
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        {
            boolean var104A93987C9CA0B1B66503A62E5FEA6A_1129941966 = (mResources != null && container != null
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
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        setActivityToken(activityToken);
        addTaint(activityToken.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.095 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
    final void init(Resources resources, ActivityThread mainThread) {
        mPackageInfo = null;
        mBasePackageName = null;
        mResources = resources;
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        // ---------- Original Method ----------
        //mPackageInfo = null;
        //mBasePackageName = null;
        //mResources = resources;
        //mMainThread = mainThread;
        //mContentResolver = new ApplicationContentResolver(this, mainThread);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.114 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "3BFE871F528AC4979D949BF1DA9B45AF")
    final void scheduleFinalCleanup(String who, String what) {
        mMainThread.scheduleContextCleanup(this, who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.215 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "9B77B4D2288878B05ADE58D891D30BC9")
    final void performFinalCleanup(String who, String what) {
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.225 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "807132D8118DA45FACCCFE64128846FD")
    final Context getReceiverRestrictedContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_912897171 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_270112721 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_912897171 = mReceiverRestrictedContext;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_270112721 = mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        Context varA7E53CE21691AB073D9660D615818899_755248363; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_755248363 = varB4EAC82CA7396A68D541C85D26508E83_912897171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_755248363 = varB4EAC82CA7396A68D541C85D26508E83_270112721;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_755248363.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_755248363;
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.238 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.239 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.259 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "C41192E4D0E4AEDDB6E1154FF0C7E5AE")
    final Context getOuterContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1556165746 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1556165746 = mOuterContext;
        varB4EAC82CA7396A68D541C85D26508E83_1556165746.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1556165746;
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.284 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "4819DFBD277A3F7679AA326780CCE062")
    final IBinder getActivityToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1504251350 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1504251350 = mActivityToken;
        varB4EAC82CA7396A68D541C85D26508E83_1504251350.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1504251350;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.312 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "7B8CE0954B36DF3F20199CBA368E9F2C")
    private File validateFilePath(String name, boolean createDirectory) {
        File varB4EAC82CA7396A68D541C85D26508E83_807131629 = null; //Variable for return #1
        File dir;
        File f;
        {
            boolean varFD0C1196C407A4234C7FE0E19F1943FE_684432834 = (name.charAt(0) == File.separatorChar);
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
            boolean var3499179EFDC7A0451D45EF9132D21A84_1600403181 = (createDirectory && !dir.isDirectory() && dir.mkdir());
            {
                FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_807131629 = f;
        addTaint(name.getTaint());
        addTaint(createDirectory);
        varB4EAC82CA7396A68D541C85D26508E83_807131629.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_807131629;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.330 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "36B7E6C14E10890B43459EA68A866D06")
    private File makeFilename(File base, String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1827981036 = null; //Variable for return #1
        {
            boolean varE9928D58DBE793633CB7E7D7D5D3D217_37269042 = (name.indexOf(File.separatorChar) < 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1827981036 = new File(base, name);
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "File " + name + " contains a path separator");
        addTaint(base.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1827981036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1827981036;
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.331 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.331 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        public ServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.366 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "8554040DC6DE2A847418F4763831B538")
        public Object getService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1049917382 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_627210097 = null; //Variable for return #2
            ArrayList<Object> cache;
            cache = ctx.mServiceCache;
            Object service;
            {
                {
                    boolean var64657C48B0EB7731DEDFDF761A102E58_644022265 = (cache.size() == 0);
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
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1049917382 = service;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
                varB4EAC82CA7396A68D541C85D26508E83_627210097 = service;
            } //End block
            addTaint(ctx.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1879447565; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1879447565 = varB4EAC82CA7396A68D541C85D26508E83_1049917382;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1879447565 = varB4EAC82CA7396A68D541C85D26508E83_627210097;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1879447565.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1879447565;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.379 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "EF860758FB493A7F2A30EEFAEDF636FA")
        public Object createService(ContextImpl ctx) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not implemented");
            addTaint(ctx.getTaint());
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.380 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.380 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        public StaticServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.403 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "FA8FC724288BF13E57AE45917BFBFC51")
        @Override
        public final Object getService(ContextImpl unused) {
            Object varB4EAC82CA7396A68D541C85D26508E83_48041007 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_2095228347 = null; //Variable for return #2
            {
                Object var2F175684CDE577660B1158202078FB8E_1117672516 = (StaticServiceFetcher.this);
                {
                    Object service;
                    service = mCachedInstance;
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_48041007 = service;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_2095228347 = mCachedInstance = createStaticService();
                } //End block
            } //End collapsed parenthetic
            addTaint(unused.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1952935864; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1952935864 = varB4EAC82CA7396A68D541C85D26508E83_48041007;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1952935864 = varB4EAC82CA7396A68D541C85D26508E83_2095228347;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1952935864.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1952935864;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.404 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.433 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "57E8775C65B09F3977F718498E9F7D5B")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            mMainThread = mainThread;
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.444 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "029DD8003A332FC212CBA6EFD5A0907B")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_202789575 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_202789575 = mMainThread.acquireProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_202789575.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_202789575;
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.475 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "8E935AF53D6551AE10B99252E196D3F7")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_578735961 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_578735961 = mMainThread.acquireExistingProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_578735961.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_578735961;
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.477 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "9D73254CFD1228B455F9A4E7EFC8ECD2")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            boolean var38B4042628FFD57CF97DF331208B6769_833762609 = (mMainThread.releaseProvider(provider));
            addTaint(provider.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_321824180 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_321824180;
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.477 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "B73067719DFF8972BB75A5B0F03A8BF5")

    private static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.478 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.479 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "AA249A08BCE876256D581BB0F267575F")

    private static HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.497 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "98EE7CE9F1A882068159AF3587374CA6")

    private static String[] EMPTY_FILE_LIST = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.497 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "C687AB3B2B70A06A6F6E72BC3BE3C62F")

    private static HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.498 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

    private static int sNextPerContextServiceCacheIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.514 -0400", hash_original_field = "7DB09CDC66836808CD50648C6519F6AD", hash_generated_field = "40A5F47B48E0088C6A8317D3AAA48176")

    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:48.513 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "E207E5CC715165F89E99550F1BB53AD6")
        public Object createService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_997860533 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_997860533 = new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler());
            addTaint(ctx.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_997860533.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_997860533;
            // ---------- Original Method ----------
            //return new WallpaperManager(ctx.getOuterContext(),
                        //ctx.mMainThread.getHandler());
        }

        
};
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

