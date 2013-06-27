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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.102 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.111 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "E4E46445668240B9ABAB7418E10486D2")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_904605620 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_904605620 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_904605620.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_904605620;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.115 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "52484D3785B6DCFDA27B7D982337EBBC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.140 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "48A6B6516393E61756434C65FF41063B")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1874695077 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1874695077;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.142 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.142 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.151 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.152 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.152 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.153 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.153 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.153 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.169 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.169 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.170 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.170 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.171 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "C6AED20E83CF866AEB59A5DE1C3D1EA2")

    private Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.171 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.178 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.181 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.182 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.182 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.183 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.183 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.188 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "2F69AB504EDBEC75083AAFA041ED1434")

    ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.200 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
      ContextImpl() {
        mOuterContext = this;
        // ---------- Original Method ----------
        //mOuterContext = this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.202 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.222 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "1E6BF5DD18AEF9B3886979D25095CC7C")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_18214280 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_18214280 = mResources.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_18214280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_18214280;
        // ---------- Original Method ----------
        //return mResources.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.234 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "E733CBB308FB7DA854D6DD595B55F16B")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_156774755 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_156774755 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_156774755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_156774755;
        // ---------- Original Method ----------
        //return mResources;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.237 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "1C904A0D20AB9778FB968C053F197BD3")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_959656701 = null; //Variable for return #1
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1564896812 = null; //Variable for return #2
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1054359910 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_959656701 = mPackageManager;
        } //End block
        IPackageManager pm;
        pm = ActivityThread.getPackageManager();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1564896812 = (mPackageManager = new ApplicationPackageManager(this, pm));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1054359910 = null;
        PackageManager varA7E53CE21691AB073D9660D615818899_312022511; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_312022511 = varB4EAC82CA7396A68D541C85D26508E83_959656701;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_312022511 = varB4EAC82CA7396A68D541C85D26508E83_1564896812;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_312022511 = varB4EAC82CA7396A68D541C85D26508E83_1054359910;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_312022511.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_312022511;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.253 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "BD89C51678123028E9065726F7DDDFE0")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_78601423 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_78601423 = mContentResolver;
        varB4EAC82CA7396A68D541C85D26508E83_78601423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_78601423;
        // ---------- Original Method ----------
        //return mContentResolver;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.261 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "4DFB492DA782B43D2B1227DA95127F36")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_659968863 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_659968863 = mMainThread.getLooper();
        varB4EAC82CA7396A68D541C85D26508E83_659968863.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_659968863;
        // ---------- Original Method ----------
        //return mMainThread.getLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.279 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "D2B1CD0E0A5809945204F1EB13AAAB13")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1220873055 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1220873055 = (mPackageInfo != null) ?
                mPackageInfo.getApplication() : mMainThread.getApplication();
        varB4EAC82CA7396A68D541C85D26508E83_1220873055.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220873055;
        // ---------- Original Method ----------
        //return (mPackageInfo != null) ?
                //mPackageInfo.getApplication() : mMainThread.getApplication();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.281 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "DAC2322817B2898A8DBFE4A50CECD38D")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        // ---------- Original Method ----------
        //mThemeResource = resid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.285 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "F22DEAC3562F139117AA4580081B4A6C")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902747524 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_902747524;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.305 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "538FE8B3F61665DC4913779A59D0FA67")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1534164073 = null; //Variable for return #1
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1534164073 = mTheme;
        varB4EAC82CA7396A68D541C85D26508E83_1534164073.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1534164073;
        // ---------- Original Method ----------
        //if (mTheme == null) {
            //mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    //getOuterContext().getApplicationInfo().targetSdkVersion);
            //mTheme = mResources.newTheme();
            //mTheme.applyStyle(mThemeResource, true);
        //}
        //return mTheme;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.307 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "11FDE698490E21D35022D94612A4296D")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1832869670 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1832869670 = mPackageInfo != null ?
                mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_1832869670.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1832869670;
        // ---------- Original Method ----------
        //return mPackageInfo != null ?
                //mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.320 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "268713ABE32CF20A62BAFA603AA4B5DB")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1933827632 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1933827632 = mPackageInfo.getPackageName();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1933827632.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933827632;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getPackageName();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.337 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "AC279DF98773AB39637879B40191FEE4")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1397223550 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1397223550 = mPackageInfo.getApplicationInfo();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1397223550.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1397223550;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getApplicationInfo();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.424 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "800834ACB46DA4237FFA9DD1F237DA08")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_572860126 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_572860126 = mPackageInfo.getResDir();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_572860126.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_572860126;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getResDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.431 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "A792844EEABE1107AEDE8C927D30D7FD")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1212915982 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1212915982 = mPackageInfo.getAppDir();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1212915982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1212915982;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getAppDir();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.445 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "12A5517C133EE6EE6D33FFB2FE1A7C74")
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1765682943 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1765682943 = makeFilename(getPreferencesDir(), name + ".xml");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1765682943.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1765682943;
        // ---------- Original Method ----------
        //return makeFilename(getPreferencesDir(), name + ".xml");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.478 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "06797F79A242B7415EA31082680B037C")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1868520325 = null; //Variable for return #1
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1107133006 = null; //Variable for return #2
        SharedPreferencesImpl sp;
        {
            sp = sSharedPrefs.get(name);
            {
                File prefsFile;
                prefsFile = getSharedPrefsFile(name);
                sp = new SharedPreferencesImpl(prefsFile, mode);
                sSharedPrefs.put(name, sp);
                varB4EAC82CA7396A68D541C85D26508E83_1868520325 = sp;
            } //End block
        } //End block
        {
            boolean var2E6124E1185D02CDB2C7C679C6727913_932598167 = ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB);
            {
                sp.startReloadIfChangedUnexpectedly();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1107133006 = sp;
        addTaint(name.getTaint());
        addTaint(mode);
        SharedPreferences varA7E53CE21691AB073D9660D615818899_658919878; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_658919878 = varB4EAC82CA7396A68D541C85D26508E83_1868520325;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_658919878 = varB4EAC82CA7396A68D541C85D26508E83_1107133006;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_658919878.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_658919878;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.496 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "4B04C49050F13638B255268E4FD80309")
    private File getPreferencesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_563034522 = null; //Variable for return #1
        {
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_563034522 = mPreferencesDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_563034522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_563034522;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.506 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "159335045E665308C24A2177435EC892")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_1285393131 = null; //Variable for return #1
        File f;
        f = makeFilename(getFilesDir(), name);
        varB4EAC82CA7396A68D541C85D26508E83_1285393131 = new FileInputStream(f);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1285393131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1285393131;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return new FileInputStream(f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.531 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "9E9E094DCC7FEB976889C2FD8FE5DAA6")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_679379365 = null; //Variable for return #1
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_952324220 = null; //Variable for return #2
        boolean append;
        append = (mode&MODE_APPEND) != 0;
        File f;
        f = makeFilename(getFilesDir(), name);
        try 
        {
            FileOutputStream fos;
            fos = new FileOutputStream(f, append);
            setFilePermissionsFromMode(f.getPath(), mode, 0);
            varB4EAC82CA7396A68D541C85D26508E83_679379365 = fos;
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
        varB4EAC82CA7396A68D541C85D26508E83_952324220 = fos;
        addTaint(name.getTaint());
        addTaint(mode);
        FileOutputStream varA7E53CE21691AB073D9660D615818899_496433401; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_496433401 = varB4EAC82CA7396A68D541C85D26508E83_679379365;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_496433401 = varB4EAC82CA7396A68D541C85D26508E83_952324220;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_496433401.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_496433401;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.533 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "74F3E695B2BF5DF62DED0C20AC38A021")
    @Override
    public boolean deleteFile(String name) {
        File f;
        f = makeFilename(getFilesDir(), name);
        boolean varF551010B15D2D277CEBBB446DD2917F7_1637511911 = (f.delete());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_831314988 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_831314988;
        // ---------- Original Method ----------
        //File f = makeFilename(getFilesDir(), name);
        //return f.delete();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.588 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "ECF814DA5BFD8D7C3735A979A728CAE4")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1822614959 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1139925891 = null; //Variable for return #2
        {
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } //End block
            {
                boolean var19E4FA9AD9694173D1E5B3B11060E583_1192591215 = (!mFilesDir.exists());
                {
                    {
                        boolean var20989B86B1B7C5B3A21029C102C7B0F0_1234693047 = (!mFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1822614959 = null;
                        } //End block
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1139925891 = mFilesDir;
        } //End block
        File varA7E53CE21691AB073D9660D615818899_1812083630; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1812083630 = varB4EAC82CA7396A68D541C85D26508E83_1822614959;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1812083630 = varB4EAC82CA7396A68D541C85D26508E83_1139925891;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1812083630.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1812083630;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.597 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "A72EF6D5EEB1516C87E3E2CAE7051B69")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_726046942 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_418521846 = null; //Variable for return #2
        File varB4EAC82CA7396A68D541C85D26508E83_613839668 = null; //Variable for return #3
        File varB4EAC82CA7396A68D541C85D26508E83_609529353 = null; //Variable for return #4
        {
            {
                mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(
                        getPackageName());
            } //End block
            {
                boolean varB276A181C4EB3EF93304E7B1C49EFB6B_1087350347 = (!mExternalFilesDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean var675269D0F3BF0B3D2DEA41EAF426F526_1083419502 = (!mExternalFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_726046942 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                varB4EAC82CA7396A68D541C85D26508E83_418521846 = mExternalFilesDir;
            } //End block
            File dir;
            dir = new File(mExternalFilesDir, type);
            {
                boolean varFE8E78642ABD38646DA929922A7BF3DC_1158440422 = (!dir.exists());
                {
                    {
                        boolean varCC013DA93565AE954394EDAB638D90F5_1624036137 = (!dir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_613839668 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_609529353 = dir;
        } //End block
        addTaint(type.getTaint());
        File varA7E53CE21691AB073D9660D615818899_2082507683; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2082507683 = varB4EAC82CA7396A68D541C85D26508E83_726046942;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2082507683 = varB4EAC82CA7396A68D541C85D26508E83_418521846;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2082507683 = varB4EAC82CA7396A68D541C85D26508E83_613839668;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2082507683 = varB4EAC82CA7396A68D541C85D26508E83_609529353;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2082507683.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2082507683;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.630 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "B54187944B586B123409863852180ED5")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1750666999 = null; //Variable for return #1
        {
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1750666999 = mObbDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1750666999.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1750666999;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mObbDir == null) {
                //mObbDir = Environment.getExternalStorageAppObbDirectory(
                        //getPackageName());
            //}
            //return mObbDir;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.637 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "90F741BC27105D8C17837C923E2CA580")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_540670249 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1180853754 = null; //Variable for return #2
        {
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } //End block
            {
                boolean var2F5430C0F48CD9EE00D803058AB5029F_1875043489 = (!mCacheDir.exists());
                {
                    {
                        boolean var83D0E63134D15DC773688937A5F3BD28_1671673838 = (!mCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_540670249 = null;
                        } //End block
                    } //End collapsed parenthetic
                    FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1180853754 = mCacheDir;
        File varA7E53CE21691AB073D9660D615818899_444821179; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_444821179 = varB4EAC82CA7396A68D541C85D26508E83_540670249;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_444821179 = varB4EAC82CA7396A68D541C85D26508E83_1180853754;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_444821179.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_444821179;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.664 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "CE496D1FF7B17F8404A024990A49B73A")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_326005266 = null; //Variable for return #1
        File varB4EAC82CA7396A68D541C85D26508E83_1095278809 = null; //Variable for return #2
        {
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } //End block
            {
                boolean var00D9D94DA81ED9ECF73133C2FCFD94BC_1441554436 = (!mExternalCacheDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } //End block
                    catch (IOException e)
                    { }
                    {
                        boolean varBF80BF4F4103A772CF6C96028B68472F_92895038 = (!mExternalCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_326005266 = null;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1095278809 = mExternalCacheDir;
        } //End block
        File varA7E53CE21691AB073D9660D615818899_659431254; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_659431254 = varB4EAC82CA7396A68D541C85D26508E83_326005266;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_659431254 = varB4EAC82CA7396A68D541C85D26508E83_1095278809;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_659431254.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_659431254;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.683 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "EC490EB1E40E96D5E818B1BAB7C9AD70")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1005787841 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1005787841 = makeFilename(getFilesDir(), name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1005787841.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1005787841;
        // ---------- Original Method ----------
        //return makeFilename(getFilesDir(), name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.695 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "94326122B283462D248560E81EFE7D6E")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1727314562 = null; //Variable for return #1
        String[] list;
        list = getFilesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_1727314562 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_1727314562.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1727314562;
        // ---------- Original Method ----------
        //final String[] list = getFilesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.698 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "C8C3F81CAA83AE9EF58D92B163BF7635")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1380544526 = null; //Variable for return #1
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1380544526 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1380544526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1380544526;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.718 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "FB20F9B3E89C1EE96336852104C0DD70")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1126824364 = null; //Variable for return #1
        File f;
        f = validateFilePath(name, true);
        SQLiteDatabase db;
        db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1126824364 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1126824364.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1126824364;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.731 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "696E1D3D9635B83738498F1AECC7E164")
    @Override
    public boolean deleteDatabase(String name) {
        try 
        {
            File f;
            f = validateFilePath(name, false);
            boolean varABE1B429208141FF7999C4FBA16347A8_1997977008 = (f.delete());
        } //End block
        catch (Exception e)
        { }
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1282387655 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1282387655;
        // ---------- Original Method ----------
        //try {
            //File f = validateFilePath(name, false);
            //return f.delete();
        //} catch (Exception e) {
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.734 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "9AB274761067A4111CF092381A6C6F7F")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_769923355 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_769923355 = validateFilePath(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_769923355.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_769923355;
        // ---------- Original Method ----------
        //return validateFilePath(name, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.752 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "1166296E621B27CCF0126ADBED70BEE3")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1217820379 = null; //Variable for return #1
        String[] list;
        list = getDatabasesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_1217820379 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_1217820379.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1217820379;
        // ---------- Original Method ----------
        //final String[] list = getDatabasesDir().list();
        //return (list != null) ? list : EMPTY_FILE_LIST;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.772 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "0F1B3E23ABE60E37E46432DF8DB2B108")
    private File getDatabasesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1461888298 = null; //Variable for return #1
        {
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
            {
                boolean var0314E0B292381BE9F1623149CD8F8489_251082460 = (mDatabasesDir.getPath().equals("databases"));
                {
                    mDatabasesDir = new File("/data/system");
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1461888298 = mDatabasesDir;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1461888298.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1461888298;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.790 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "2CB991FB494DF10E4D274144E3D7D32E")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_651177799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_651177799 = getWallpaperManager().getDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_651177799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_651177799;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.802 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "C4145B38D1FF743E7802554BBE15A9B4")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_93751872 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_93751872 = getWallpaperManager().peekDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_93751872.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_93751872;
        // ---------- Original Method ----------
        //return getWallpaperManager().peekDrawable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.808 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "3EFA1E804D7C7453BF7E95875639F91B")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varC254F548CFAB2206D8996DEF871ED770_1784662765 = (getWallpaperManager().getDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582723810 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1582723810;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.824 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "9DEB1E14EB02F207B98E638079A9D989")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var0CAE8BF1444C70E01A3CB5415A62929F_1513791372 = (getWallpaperManager().getDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63848909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_63848909;
        // ---------- Original Method ----------
        //return getWallpaperManager().getDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.833 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "A75BF9B3D3C58601D6E604F0244A040F")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        getWallpaperManager().setBitmap(bitmap);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //getWallpaperManager().setBitmap(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.840 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "2CF6AFCB1D96AF0794551FECD14D6F8B")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        getWallpaperManager().setStream(data);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //getWallpaperManager().setStream(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.849 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        // ---------- Original Method ----------
        //getWallpaperManager().clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.864 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "29EBAC634D80AFE7243E906991CBB839")
    @Override
    public void startActivity(Intent intent) {
        {
            boolean var4E2CEB5436A3062C8E21590CE555C7F9_1052599350 = ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.875 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "666C5BADA09EDB3A5F633B73AE8C08D3")
    @Override
    public void startActivities(Intent[] intents) {
        {
            boolean varB54A748E26DA9CF993CAE37B6D958C5E_1450224417 = ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.895 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "61EFD88F21F2325A224560E9C3E67692")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.910 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "820865761A4B710CDD5A02B3D66BFBCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.913 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "44F959A68D8B215DC3D2D1678CAF74AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.931 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "B504B7B4F82D3A2C3AC88AC5AE480396")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.938 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "DBB911C2E061634C4750943BCB165C69")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.954 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "5779378950B98E7B615C4569DD3466CE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.974 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "8AFFB79076214283AAF3F7CC35B3C263")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.985 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "0A53F24AF5C4FFF591242CE39462FEAE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.992 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "0998500C85BAC4618940E75268042273")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1969246761 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1969246761 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1969246761.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1969246761;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.015 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "0A23FF72C8F0D02B9A7552A07768A417")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_636073435 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_636073435 = registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext());
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_636073435.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_636073435;
        // ---------- Original Method ----------
        //return registerReceiverInternal(receiver, filter, broadcastPermission,
                //scheduler, getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.045 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "C461CB6950C26DFA6D1EF129BCD0B6B0")
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2062637887 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_1460521379 = null; //Variable for return #2
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
            varB4EAC82CA7396A68D541C85D26508E83_2062637887 = ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1460521379 = null;
        } //End block
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(context.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_1732284204; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1732284204 = varB4EAC82CA7396A68D541C85D26508E83_2062637887;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1732284204 = varB4EAC82CA7396A68D541C85D26508E83_1460521379;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1732284204.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1732284204;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.063 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "14B57999A402BDF9151594CCCD8276F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.076 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "9AC690666164C073679922FEED2233BA")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1819213414 = null; //Variable for return #1
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1805669219 = null; //Variable for return #2
        try 
        {
            service.setAllowFds(false);
            ComponentName cn;
            cn = ActivityManagerNative.getDefault().startService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                boolean varD9D164FC49919222E3F05E39BAD0AAA7_1279345177 = (cn != null && cn.getPackageName().equals("!"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                } //End block
            } //End collapsed parenthetic
            varB4EAC82CA7396A68D541C85D26508E83_1819213414 = cn;
        } //End block
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1805669219 = null;
        } //End block
        addTaint(service.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_2038328267; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2038328267 = varB4EAC82CA7396A68D541C85D26508E83_1819213414;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2038328267 = varB4EAC82CA7396A68D541C85D26508E83_1805669219;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2038328267.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2038328267;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.090 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "F6E85226A8F5F361814FE827FBE415FA")
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1283762610 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1283762610;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.110 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "91B3628C4C3910D030F7FC925077330E")
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
                boolean var6493BF3E84461910769ACF3C960C9AA7_928588222 = (token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_739283443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_739283443;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.176 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "568B477F6DACCC70BDDCDFE81FA71E7C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.180 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "A42680A8B2A514A9E9E7FC880E9C949D")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        try 
        {
            {
                arguments.setAllowFds(false);
            } //End block
            boolean varFB737B53559144BA0BD1ED3EEC743D0D_219608647 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_724488583 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_724488583;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.182 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "E26698A7458B2EC13B66E567E7078BB4")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1847713502 = null; //Variable for return #1
        ServiceFetcher fetcher;
        fetcher = SYSTEM_SERVICE_MAP.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_1847713502 = fetcher == null ? null : fetcher.getService(this);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1847713502.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1847713502;
        // ---------- Original Method ----------
        //ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        //return fetcher == null ? null : fetcher.getService(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.194 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "295DF94F6343607F7C3924E9A65AF6ED")
    private WallpaperManager getWallpaperManager() {
        WallpaperManager varB4EAC82CA7396A68D541C85D26508E83_1602972825 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1602972825 = (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        varB4EAC82CA7396A68D541C85D26508E83_1602972825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1602972825;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.213 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "0C9CB63FE810D1469BD3B08E62B707AC")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        try 
        {
            int var5F40A2437A077EA5C807226D389206D0_1521703316 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712964242 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_712964242;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.215 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "05D1AF128600B1E8A17DEABC5546B185")
    @Override
    public int checkCallingPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_1860787275 = (pid != Process.myPid());
            {
                int var78028F3F1C255CC480151714E778C1C5_1630945575 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
            } //End block
        } //End collapsed parenthetic
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756819386 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1756819386;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.216 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "7F80D1198426AFD5E2CBD886FA16BA78")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } //End block
        int var34AB0D6CBBDC631C7FDA58F28B1B657C_1960218845 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171417252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_171417252;
        // ---------- Original Method ----------
        //if (permission == null) {
            //throw new IllegalArgumentException("permission is null");
        //}
        //return checkPermission(permission, Binder.getCallingPid(),
                //Binder.getCallingUid());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.239 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "EDD1D47CFC1E4EB07F617CFE66F36636")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.249 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "FC57B53127A557B3AD504478DDF41F73")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.252 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "229AC75A92A0D4F7AD99D48F78CBDB05")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.257 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "F70A85011FDF2B702518E9F5FBC8913A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.264 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "705590421E266ACE219C9F1FBD249610")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.265 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "23DE65B58A88974A4DC027D2A87330B6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.293 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "E175F36B525A0B0257541BA9A3A45AAD")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        try 
        {
            int var059CF890EB6981028B04E841A7699518_916438045 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
        } //End block
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613990378 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_613990378;
        // ---------- Original Method ----------
        //try {
            //return ActivityManagerNative.getDefault().checkUriPermission(
                    //uri, pid, uid, modeFlags);
        //} catch (RemoteException e) {
            //return PackageManager.PERMISSION_DENIED;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.307 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "D1C721058E651B8D6A38FD98EB8CC842")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int pid;
        pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_722626537 = (pid != Process.myPid());
            {
                int varD7B1B302EF0CA5C388B6F3983890986E_501040179 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
            } //End block
        } //End collapsed parenthetic
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552272853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1552272853;
        // ---------- Original Method ----------
        //int pid = Binder.getCallingPid();
        //if (pid != Process.myPid()) {
            //return checkUriPermission(uri, pid,
                    //Binder.getCallingUid(), modeFlags);
        //}
        //return PackageManager.PERMISSION_DENIED;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.309 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "D46FCC1EEB2E380AAF7EBB06A4EDC246")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int var41FF907064E7DF4DF0C5983F95FA5974_361547096 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27353263 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_27353263;
        // ---------- Original Method ----------
        //return checkUriPermission(uri, Binder.getCallingPid(),
                //Binder.getCallingUid(), modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.347 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "290D9403EEBDF567297B94830AD04B9F")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        {
            {
                boolean var7E999FB94CB59BF987157589269CB69E_1893313242 = (readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            {
                boolean varBDC2A19824C9195EFA4716604E7FC089_1996447869 = (writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } //End collapsed parenthetic
        } //End block
        {
            Object var486C2278A32794206F2AEE849917E1AC_1034241191 = (checkUriPermission(uri, pid, uid, modeFlags));
        } //End flattened ternary
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390279550 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_390279550;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.369 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "CE5D608CB92F241C5F36C249D03E583B")
    private String uriModeFlagToString(int uriModeFlags) {
        String varB4EAC82CA7396A68D541C85D26508E83_412615188 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2082414436 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2077690022 = null; //Variable for return #3
        //Begin case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_412615188 = "read and write";
        //End case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        //Begin case Intent.FLAG_GRANT_READ_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_2082414436 = "read";
        //End case Intent.FLAG_GRANT_READ_URI_PERMISSION 
        //Begin case Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        varB4EAC82CA7396A68D541C85D26508E83_2077690022 = "write";
        //End case Intent.FLAG_GRANT_WRITE_URI_PERMISSION 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        addTaint(uriModeFlags);
        String varA7E53CE21691AB073D9660D615818899_2145301181; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_412615188;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_2082414436;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_2077690022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2145301181.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2145301181;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.372 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "8CFA06DC20027CBEB43917E502B19401")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.385 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "49B991110E26670EAF291BA89E5B0D03")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.396 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "328D75B611B7291D0B4370DD352EA9F2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.398 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "6CD0DED0D5BFE3583BD6DC38552CD2EC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.416 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "7429D411895773CBB69129A3CE8AB0B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.423 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "5CAFD025AD7BA0441B953FE8CBCE938F")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_1758074408 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_1639315161 = null; //Variable for return #2
        {
            boolean varC1F5D449E2D7CC78DA5400BABA02C561_1723013322 = (packageName.equals("system") || packageName.equals("android"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1758074408 = new ContextImpl(mMainThread.getSystemContext());
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
                varB4EAC82CA7396A68D541C85D26508E83_1639315161 = c;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        addTaint(packageName.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_872931408; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_872931408 = varB4EAC82CA7396A68D541C85D26508E83_1758074408;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_872931408 = varB4EAC82CA7396A68D541C85D26508E83_1639315161;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_872931408.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_872931408;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.440 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "9D59547B3D8F48A1241A258E59A59EF0")
    @Override
    public boolean isRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_852868977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_852868977;
        // ---------- Original Method ----------
        //return mRestricted;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.442 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "3B497D1F833C8DAF6623850FAB9A580D")
    private File getDataDirFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_1566571341 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1566571341 = mPackageInfo.getDataDirFile();
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1566571341.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1566571341;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.465 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "4D76E78D2E45E6A588F42A0069EBD2E3")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_1988747556 = null; //Variable for return #1
        name = "app_" + name;
        File file;
        file = makeFilename(getDataDirFile(), name);
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_1613433766 = (!file.exists());
            {
                file.mkdir();
                setFilePermissionsFromMode(file.getPath(), mode,
                    FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1988747556 = file;
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1988747556.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1988747556;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.480 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "B7A5B5A3AAEC7FAC79639DD3C71CDE61")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        init(packageInfo, activityToken, mainThread, null, null);
        addTaint(packageInfo.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(mainThread.getTaint());
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.498 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "E13DD88F1B6279DB009AB386076EDA96")
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        {
            boolean var104A93987C9CA0B1B66503A62E5FEA6A_629424785 = (mResources != null && container != null
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.515 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.517 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "3BFE871F528AC4979D949BF1DA9B45AF")
    final void scheduleFinalCleanup(String who, String what) {
        mMainThread.scheduleContextCleanup(this, who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.533 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "9B77B4D2288878B05ADE58D891D30BC9")
    final void performFinalCleanup(String who, String what) {
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.535 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "1959AD5366C2E8FC4B1A3656BF12FB9F")
    final Context getReceiverRestrictedContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_2102183018 = null; //Variable for return #1
        Context varB4EAC82CA7396A68D541C85D26508E83_1677179884 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2102183018 = mReceiverRestrictedContext;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1677179884 = mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        Context varA7E53CE21691AB073D9660D615818899_2001116824; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2001116824 = varB4EAC82CA7396A68D541C85D26508E83_2102183018;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2001116824 = varB4EAC82CA7396A68D541C85D26508E83_1677179884;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2001116824.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2001116824;
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.536 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.557 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.572 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "B44D764B8F8515BB709E09F675B4AC45")
    final Context getOuterContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_899594089 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_899594089 = mOuterContext;
        varB4EAC82CA7396A68D541C85D26508E83_899594089.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_899594089;
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.585 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "C5A2ACCBE10E45AC89A8F8EE94CEFFA4")
    final IBinder getActivityToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1590946023 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1590946023 = mActivityToken;
        varB4EAC82CA7396A68D541C85D26508E83_1590946023.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1590946023;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.627 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "4A89F23A8A4475A86AE0E686634311C5")
    private File validateFilePath(String name, boolean createDirectory) {
        File varB4EAC82CA7396A68D541C85D26508E83_1698933119 = null; //Variable for return #1
        File dir;
        File f;
        {
            boolean varFD0C1196C407A4234C7FE0E19F1943FE_31915492 = (name.charAt(0) == File.separatorChar);
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
            boolean var3499179EFDC7A0451D45EF9132D21A84_1757238670 = (createDirectory && !dir.isDirectory() && dir.mkdir());
            {
                FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1698933119 = f;
        addTaint(name.getTaint());
        addTaint(createDirectory);
        varB4EAC82CA7396A68D541C85D26508E83_1698933119.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698933119;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.632 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "E3C5211843B4D89EBF2CA2CACADE629E")
    private File makeFilename(File base, String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_975643490 = null; //Variable for return #1
        {
            boolean varE9928D58DBE793633CB7E7D7D5D3D217_944466860 = (name.indexOf(File.separatorChar) < 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_975643490 = new File(base, name);
            } //End block
        } //End collapsed parenthetic
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "File " + name + " contains a path separator");
        addTaint(base.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_975643490.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975643490;
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.633 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.633 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        public ServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.656 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "830723EA92E0E149043B196C3375C7B0")
        public Object getService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1601602868 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_1243299878 = null; //Variable for return #2
            ArrayList<Object> cache;
            cache = ctx.mServiceCache;
            Object service;
            {
                {
                    boolean var64657C48B0EB7731DEDFDF761A102E58_558686127 = (cache.size() == 0);
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
                            varB4EAC82CA7396A68D541C85D26508E83_1601602868 = service;
                        } //End block
                    } //End block
                } //End collapsed parenthetic
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
                varB4EAC82CA7396A68D541C85D26508E83_1243299878 = service;
            } //End block
            addTaint(ctx.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1431606372; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1431606372 = varB4EAC82CA7396A68D541C85D26508E83_1601602868;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1431606372 = varB4EAC82CA7396A68D541C85D26508E83_1243299878;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1431606372.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1431606372;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.666 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "EF860758FB493A7F2A30EEFAEDF636FA")
        public Object createService(ContextImpl ctx) {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not implemented");
            addTaint(ctx.getTaint());
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.679 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.680 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        public StaticServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.702 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "DC34DEA93128F2CE51D4C2D1F8E5961E")
        @Override
        public final Object getService(ContextImpl unused) {
            Object varB4EAC82CA7396A68D541C85D26508E83_498810809 = null; //Variable for return #1
            Object varB4EAC82CA7396A68D541C85D26508E83_424644551 = null; //Variable for return #2
            {
                Object var2F175684CDE577660B1158202078FB8E_269196465 = (StaticServiceFetcher.this);
                {
                    Object service;
                    service = mCachedInstance;
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_498810809 = service;
                    } //End block
                    varB4EAC82CA7396A68D541C85D26508E83_424644551 = mCachedInstance = createStaticService();
                } //End block
            } //End collapsed parenthetic
            addTaint(unused.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1502634733; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_1502634733 = varB4EAC82CA7396A68D541C85D26508E83_498810809;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1502634733 = varB4EAC82CA7396A68D541C85D26508E83_424644551;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1502634733.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_1502634733;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.705 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.714 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "57E8775C65B09F3977F718498E9F7D5B")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            mMainThread = mainThread;
            addTaint(context.getTaint());
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.770 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "678DEC4EC49573FECE039034AE833427")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_573604087 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_573604087 = mMainThread.acquireProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_573604087.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_573604087;
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.778 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "DC7AFCDB5F847D8E586B2E2D4C484F90")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1740314110 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1740314110 = mMainThread.acquireExistingProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1740314110.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1740314110;
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.780 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "E3C8E1F9E0018A6E62BBADE04294E77A")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            boolean var38B4042628FFD57CF97DF331208B6769_1188434638 = (mMainThread.releaseProvider(provider));
            addTaint(provider.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1164821582 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1164821582;
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.781 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "B73067719DFF8972BB75A5B0F03A8BF5")

    private static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.798 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.799 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "AA249A08BCE876256D581BB0F267575F")

    private static HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.799 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "8E8150950F68B6244E305E710D4C9608")

    private static String[] EMPTY_FILE_LIST = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.809 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "C687AB3B2B70A06A6F6E72BC3BE3C62F")

    private static HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.810 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

    private static int sNextPerContextServiceCacheIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.823 -0400", hash_original_field = "7DB09CDC66836808CD50648C6519F6AD", hash_generated_field = "4E94F872BED7D6A923E6DCBA2FF9B513")

    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.822 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "79DCF2A08D6954A4CDC298AFCA43793B")
        public Object createService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_483600003 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_483600003 = new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler());
            addTaint(ctx.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_483600003.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_483600003;
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

