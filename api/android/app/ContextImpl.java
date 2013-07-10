package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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

import droidsafe.concrete.DroidSafeContentResolver;
import android.telephony.TelephonyManager;

class ReceiverRestrictedContext extends ContextWrapper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.184 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.185 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "FBFA414C98D405147A0179DC0A8F74B7")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_1359915866 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1359915866 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1359915866.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1359915866;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:49.115 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "52484D3785B6DCFDA27B7D982337EBBC")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
    	throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.186 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "5CE268051E73CF7050E246EB70F1A251")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        if (DroidSafeAndroidRuntime.control) throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1631237281 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1631237281;
        
        
                
    }

    
}

public class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.187 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.187 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.187 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.188 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.189 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "D63EC7F2931BD6BAD4B3EF85C123726C")

    final ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    private DroidSafeContentResolver contentResolver;
    private SensorManager sensorManager;
    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.190 -0400", hash_original_method = "D626E4F654DE4449ACE9581A8359F0B3", hash_generated_method = "EE67F93CB8AD578637611B4EAAB10CB4")
    public ContextImpl() {
        mOuterContext = this;
        contentResolver = new DroidSafeContentResolver(this);
        sensorManager = new SensorManager();
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.190 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
    public  ContextImpl(ContextImpl context) {
        mPackageInfo = context.mPackageInfo;
        mBasePackageName = context.mBasePackageName;
        mResources = context.mResources;
        mMainThread = context.mMainThread;
        mContentResolver = context.mContentResolver;
        mOuterContext = this;
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static void registerService(String serviceName, ServiceFetcher fetcher) {
        if (!(fetcher instanceof StaticServiceFetcher)) {
            fetcher.mContextCacheIndex = sNextPerContextServiceCacheIndex++;
        }
        SYSTEM_SERVICE_MAP.put(serviceName, fetcher);
    }

    
    @DSModeled(DSC.SAFE)
    static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.192 -0400", hash_original_method = "E29B1E8B8DA0771E0791531B452826D2", hash_generated_method = "CB13BCC0897BD0D110DD639E10733CA2")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_815691295 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_815691295 = mResources.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_815691295.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_815691295;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.193 -0400", hash_original_method = "9FEC9CB1792EB215E49CBF732B0DBF5B", hash_generated_method = "BEB56DE7B7F7D926437BD7E4BF1C8EA8")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1372958679 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1372958679 = mResources;
        varB4EAC82CA7396A68D541C85D26508E83_1372958679.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1372958679;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.194 -0400", hash_original_method = "BD4B6640BF321317C66EC62ED1810EDC", hash_generated_method = "405F20DFD3A049B06D86E32252C1DB36")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_716206294 = null; 
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_943672709 = null; 
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1016663155 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_716206294 = mPackageManager;
        } 
        IPackageManager pm = ActivityThread.getPackageManager();
        {
            varB4EAC82CA7396A68D541C85D26508E83_943672709 = (mPackageManager = new ApplicationPackageManager(this, pm));
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1016663155 = null;
        PackageManager varA7E53CE21691AB073D9660D615818899_146297807; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_146297807 = varB4EAC82CA7396A68D541C85D26508E83_716206294;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_146297807 = varB4EAC82CA7396A68D541C85D26508E83_943672709;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_146297807 = varB4EAC82CA7396A68D541C85D26508E83_1016663155;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_146297807.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_146297807;
        
        
            
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.195 -0400", hash_original_method = "E4195DED98361134A039FE4C88A6F4B6", hash_generated_method = "AC856441B3773DA0EBF20989860B3450")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_1948122587 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1948122587 = mContentResolver;
        varB4EAC82CA7396A68D541C85D26508E83_1948122587.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1948122587;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.197 -0400", hash_original_method = "83F01A831E976E654749A9BEC1E37CC3", hash_generated_method = "5AAFA073D3FF6E73632DD622374EB9FF")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_410628156 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_410628156 = mMainThread.getLooper();
        varB4EAC82CA7396A68D541C85D26508E83_410628156.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_410628156;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.198 -0400", hash_original_method = "EEBDE58C6E671C89B231CC2A7DC13506", hash_generated_method = "BCC0C2F724A078E89AF8C1EFC539ADED")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_497447676 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_497447676 = (mPackageInfo != null) ?
                mPackageInfo.getApplication() : mMainThread.getApplication();
        varB4EAC82CA7396A68D541C85D26508E83_497447676.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_497447676;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.200 -0400", hash_original_method = "B9D345E863E2753C5A0BB0CFD009BEA6", hash_generated_method = "DAC2322817B2898A8DBFE4A50CECD38D")
    @Override
    public void setTheme(int resid) {
        mThemeResource = resid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.201 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "D5516450D56C47D15D8B0BA5845E0FDD")
    @Override
    public int getThemeResId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092633796 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2092633796;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.202 -0400", hash_original_method = "D6BB36732A764F444B4412949FAD7357", hash_generated_method = "3C61673936C9D5F15E97E2DA016155F0")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1936795088 = null; 
        {
            mThemeResource = Resources.selectDefaultTheme(mThemeResource,
                    getOuterContext().getApplicationInfo().targetSdkVersion);
            mTheme = mResources.newTheme();
            mTheme.applyStyle(mThemeResource, true);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1936795088 = mTheme;
        varB4EAC82CA7396A68D541C85D26508E83_1936795088.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1936795088;
        
        
            
                    
            
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.203 -0400", hash_original_method = "E4AD06E2DE5640E33DD0DE83076841CC", hash_generated_method = "482C30E6D69A65C418BEC1DD36D84A73")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_470013794 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_470013794 = mPackageInfo != null ?
                mPackageInfo.getClassLoader() : ClassLoader.getSystemClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_470013794.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_470013794;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.204 -0400", hash_original_method = "C2ABF52241A6291268B401FAB7288697", hash_generated_method = "80347B588B365C83CE021F9ADE6EFCF4")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1838088730 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1838088730 = mPackageInfo.getPackageName();
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1838088730.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1838088730;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.205 -0400", hash_original_method = "B6824C91AB2BEA3E97D1CD03B60D140A", hash_generated_method = "8451CF3EACA177D3CD901314BADA9FA0")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1979740450 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1979740450 = mPackageInfo.getApplicationInfo();
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1979740450.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1979740450;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.206 -0400", hash_original_method = "B40C4604E79523ED9CA9BD2DB89D9D21", hash_generated_method = "423A01044806B2D27DD437AD3AF146B7")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1730424172 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1730424172 = mPackageInfo.getResDir();
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1730424172.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1730424172;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.207 -0400", hash_original_method = "6299B0E465B0087370ABC2DD5D8DF3A0", hash_generated_method = "15D84190315EF22917A07B5545ADF849")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1063387722 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1063387722 = mPackageInfo.getAppDir();
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_1063387722.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1063387722;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.209 -0400", hash_original_method = "AB577AC8DAB754DCD42D8B905735EB0E", hash_generated_method = "7EE4F56A605FC1A770254D99CC4134A8")
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1012784280 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1012784280 = makeFilename(getPreferencesDir(), name + ".xml");
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1012784280.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1012784280;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.211 -0400", hash_original_method = "B5A20353911F33A4DD3A6110C0300877", hash_generated_method = "37EC86C8A77AD92C4B325AB2F42AD707")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_2018588905 = null; 
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_87170250 = null; 
        SharedPreferencesImpl sp;
        {
            sp = sSharedPrefs.get(name);
            {
                File prefsFile = getSharedPrefsFile(name);
                sp = new SharedPreferencesImpl(prefsFile, mode);
                sSharedPrefs.put(name, sp);
                varB4EAC82CA7396A68D541C85D26508E83_2018588905 = sp;
            } 
        } 
        {
            boolean var2E6124E1185D02CDB2C7C679C6727913_486689326 = ((mode & Context.MODE_MULTI_PROCESS) != 0 ||
            getApplicationInfo().targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB);
            {
                sp.startReloadIfChangedUnexpectedly();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_87170250 = sp;
        addTaint(name.getTaint());
        addTaint(mode);
        SharedPreferences varA7E53CE21691AB073D9660D615818899_1137255540; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1137255540 = varB4EAC82CA7396A68D541C85D26508E83_2018588905;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1137255540 = varB4EAC82CA7396A68D541C85D26508E83_87170250;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1137255540.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1137255540;
        
        
        
            
            
                
                
                
                
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.212 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "C5111B97FE5BBD2BF7421A5814B6AC39")
    private File getPreferencesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1456377726 = null; 
        {
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1456377726 = mPreferencesDir;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1456377726.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1456377726;
        
        
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.214 -0400", hash_original_method = "99E1A62B7C8E5CCF8F9E6256C436E103", hash_generated_method = "8D36A2C9144EFC220EE51CC07D9EF950")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_929213656 = null; 
        File f = makeFilename(getFilesDir(), name);
        varB4EAC82CA7396A68D541C85D26508E83_929213656 = new FileInputStream(f);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_929213656.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_929213656;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.215 -0400", hash_original_method = "8D0BF4576C7B4CFD18075B0F373C4195", hash_generated_method = "CAB5E161B4DB4EE44ADE10096E3A6C7A")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_1196909538 = null; 
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_28750015 = null; 
        final boolean append = (mode&MODE_APPEND) != 0;
        File f = makeFilename(getFilesDir(), name);
        try 
        {
            FileOutputStream fos = new FileOutputStream(f, append);
            setFilePermissionsFromMode(f.getPath(), mode, 0);
            varB4EAC82CA7396A68D541C85D26508E83_1196909538 = fos;
        } 
        catch (FileNotFoundException e)
        { }
        File parent = f.getParentFile();
        parent.mkdir();
        FileUtils.setPermissions(
            parent.getPath(),
            FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
            -1, -1);
        FileOutputStream fos = new FileOutputStream(f, append);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_28750015 = fos;
        addTaint(name.getTaint());
        addTaint(mode);
        FileOutputStream varA7E53CE21691AB073D9660D615818899_371723511; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_371723511 = varB4EAC82CA7396A68D541C85D26508E83_1196909538;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_371723511 = varB4EAC82CA7396A68D541C85D26508E83_28750015;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_371723511.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_371723511;
        
        
        
        
            
            
            
        
        
        
        
        
            
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.216 -0400", hash_original_method = "F16B6B6A1EABD28DB33653BAF5021B3A", hash_generated_method = "625C1A30D1BCCA84B217ABBA93C20A2B")
    @Override
    public boolean deleteFile(String name) {
        File f = makeFilename(getFilesDir(), name);
        boolean varF551010B15D2D277CEBBB446DD2917F7_1177680979 = (f.delete());
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_800302418 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_800302418;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.218 -0400", hash_original_method = "F3D2FFAF4E630F0552CFADCBAF494A59", hash_generated_method = "DE4D98D1A140A3C234E77173237F2D1B")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_185584920 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_937792234 = null; 
        {
            {
                mFilesDir = new File(getDataDirFile(), "files");
            } 
            {
                boolean var19E4FA9AD9694173D1E5B3B11060E583_1518288343 = (!mFilesDir.exists());
                {
                    {
                        boolean var20989B86B1B7C5B3A21029C102C7B0F0_1513047255 = (!mFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_185584920 = null;
                        } 
                    } 
                    FileUtils.setPermissions(
                        mFilesDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_937792234 = mFilesDir;
        } 
        File varA7E53CE21691AB073D9660D615818899_1798508648; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1798508648 = varB4EAC82CA7396A68D541C85D26508E83_185584920;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1798508648 = varB4EAC82CA7396A68D541C85D26508E83_937792234;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1798508648.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1798508648;
        
        
            
                
            
            
                
                    
                    
                
                
                        
                        
                        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.221 -0400", hash_original_method = "E1CC83B0B5F678A7C2185F1397CC9FDE", hash_generated_method = "D399A0B918297971BE0FC026C8B44808")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_1848853079 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_1840084369 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_1632591456 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_273679611 = null; 
        {
            {
                mExternalFilesDir = Environment.getExternalStorageAppFilesDirectory(
                        getPackageName());
            } 
            {
                boolean varB276A181C4EB3EF93304E7B1C49EFB6B_1733965696 = (!mExternalFilesDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } 
                    catch (IOException e)
                    { }
                    {
                        boolean var675269D0F3BF0B3D2DEA41EAF426F526_2100532147 = (!mExternalFilesDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1848853079 = null;
                        } 
                    } 
                } 
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1840084369 = mExternalFilesDir;
            } 
            File dir = new File(mExternalFilesDir, type);
            {
                boolean varFE8E78642ABD38646DA929922A7BF3DC_905921136 = (!dir.exists());
                {
                    {
                        boolean varCC013DA93565AE954394EDAB638D90F5_1270810281 = (!dir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1632591456 = null;
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_273679611 = dir;
        } 
        addTaint(type.getTaint());
        File varA7E53CE21691AB073D9660D615818899_1067784435; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1067784435 = varB4EAC82CA7396A68D541C85D26508E83_1848853079;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1067784435 = varB4EAC82CA7396A68D541C85D26508E83_1840084369;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1067784435 = varB4EAC82CA7396A68D541C85D26508E83_1632591456;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1067784435 = varB4EAC82CA7396A68D541C85D26508E83_273679611;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1067784435.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1067784435;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.223 -0400", hash_original_method = "36DEC4EC6E4DB2E91443B0A9125E0342", hash_generated_method = "CB0202EFF486149D1BA86C88A8DABC85")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1129704426 = null; 
        {
            {
                mObbDir = Environment.getExternalStorageAppObbDirectory(
                        getPackageName());
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1129704426 = mObbDir;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1129704426.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1129704426;
        
        
            
                
                        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.224 -0400", hash_original_method = "F6DBEEC95A0D73AEBD7CDC4BC14EA6E3", hash_generated_method = "419429CB646023C265A79D587B100D96")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1897156949 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_1892328417 = null; 
        {
            {
                mCacheDir = new File(getDataDirFile(), "cache");
            } 
            {
                boolean var2F5430C0F48CD9EE00D803058AB5029F_684522817 = (!mCacheDir.exists());
                {
                    {
                        boolean var83D0E63134D15DC773688937A5F3BD28_1181562829 = (!mCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1897156949 = null;
                        } 
                    } 
                    FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1892328417 = mCacheDir;
        File varA7E53CE21691AB073D9660D615818899_1541927628; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1541927628 = varB4EAC82CA7396A68D541C85D26508E83_1897156949;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1541927628 = varB4EAC82CA7396A68D541C85D26508E83_1892328417;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1541927628.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1541927628;
        
        
            
                
            
            
                
                    
                    
                
                
                        
                        
                        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.226 -0400", hash_original_method = "A3CE8D82B860400333D94B94289B1B1E", hash_generated_method = "2E42F08DC53F34934FCD2E54593CA7A7")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1733359222 = null; 
        File varB4EAC82CA7396A68D541C85D26508E83_929808158 = null; 
        {
            {
                mExternalCacheDir = Environment.getExternalStorageAppCacheDirectory(
                        getPackageName());
            } 
            {
                boolean var00D9D94DA81ED9ECF73133C2FCFD94BC_475438945 = (!mExternalCacheDir.exists());
                {
                    try 
                    {
                        (new File(Environment.getExternalStorageAndroidDataDir(),
                            ".nomedia")).createNewFile();
                    } 
                    catch (IOException e)
                    { }
                    {
                        boolean varBF80BF4F4103A772CF6C96028B68472F_1337211007 = (!mExternalCacheDir.mkdirs());
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1733359222 = null;
                        } 
                    } 
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_929808158 = mExternalCacheDir;
        } 
        File varA7E53CE21691AB073D9660D615818899_209629946; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_209629946 = varB4EAC82CA7396A68D541C85D26508E83_1733359222;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_209629946 = varB4EAC82CA7396A68D541C85D26508E83_929808158;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_209629946.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_209629946;
        
        
            
                
                        
            
            
                
                    
                            
                
                
                
                    
                    
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.227 -0400", hash_original_method = "32A40B7EA525B83ED21D63D0A896CF7D", hash_generated_method = "440CDB398CA7ABB676405B1FD90ADCB8")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1247914411 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1247914411 = makeFilename(getFilesDir(), name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1247914411.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1247914411;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.229 -0400", hash_original_method = "568E82D783647A73A7CA56CF0FA39878", hash_generated_method = "8797A91BF583C406D5600140AD8F3439")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_27874173 = null; 
        final String[] list = getFilesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_27874173 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_27874173.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_27874173;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.231 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "E5840C7135ED1DD223EFE6BE8C8AEBED")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1246124850 = null; 
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_1246124850 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1246124850.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1246124850;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.232 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "DAC2823031AB0F66DE2E0AB75DA1E027")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_348789646 = null; 
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        varB4EAC82CA7396A68D541C85D26508E83_348789646 = db;
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_348789646.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_348789646;
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.233 -0400", hash_original_method = "0A030BBB6F700BE85FBACF41F39CE120", hash_generated_method = "1E20BA80DBC3AEDC7253A4DCE85E255F")
    @Override
    public boolean deleteDatabase(String name) {
        try 
        {
            File f = validateFilePath(name, false);
            boolean varABE1B429208141FF7999C4FBA16347A8_1513223307 = (f.delete());
        } 
        catch (Exception e)
        { }
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58315684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58315684;
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.234 -0400", hash_original_method = "D766C2B887EEA2E44EE642CC66A97FF8", hash_generated_method = "1A49C5D4AD454C0601CE233D290281D8")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1412700625 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1412700625 = validateFilePath(name, false);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1412700625.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1412700625;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.235 -0400", hash_original_method = "68895933E30EC3F2C5788FC13140D12F", hash_generated_method = "D19D05E122DE52BF3F82112546210003")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_659864439 = null; 
        final String[] list = getDatabasesDir().list();
        varB4EAC82CA7396A68D541C85D26508E83_659864439 = (list != null) ? list : EMPTY_FILE_LIST;
        varB4EAC82CA7396A68D541C85D26508E83_659864439.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_659864439;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.236 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "BE9DF77E0EE0636BD83F0BCE0FDB8033")
    private File getDatabasesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_2021308539 = null; 
        {
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } 
            {
                boolean var0314E0B292381BE9F1623149CD8F8489_462930931 = (mDatabasesDir.getPath().equals("databases"));
                {
                    mDatabasesDir = new File("/data/system");
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_2021308539 = mDatabasesDir;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2021308539.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2021308539;
        
        
            
                
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.237 -0400", hash_original_method = "FF2FCBF8AB66D55188EF68C63BF4015D", hash_generated_method = "2E8FA94948F88E2D9879A9BF321D9C2A")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1073820829 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1073820829 = getWallpaperManager().getDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_1073820829.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1073820829;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.239 -0400", hash_original_method = "65D83D9F23D018D77206F0312145003F", hash_generated_method = "6C7F2E97FA30035ADED09BC1E2EFF84A")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1862546438 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1862546438 = getWallpaperManager().peekDrawable();
        varB4EAC82CA7396A68D541C85D26508E83_1862546438.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1862546438;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.241 -0400", hash_original_method = "4D3A48BB3B555646A3FEA2026A3AE79A", hash_generated_method = "A9BD391A7688526CC36A9288B2698709")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varC254F548CFAB2206D8996DEF871ED770_470419259 = (getWallpaperManager().getDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028723933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2028723933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.241 -0400", hash_original_method = "5FD558BDEB2B471F8EE36257DB8EACE1", hash_generated_method = "6A2555FC817EF3F51D9F9E20F7B62B84")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int var0CAE8BF1444C70E01A3CB5415A62929F_264595257 = (getWallpaperManager().getDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736149060 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1736149060;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.242 -0400", hash_original_method = "0825D5DEC636130484CFA4FBC7BA319E", hash_generated_method = "A75BF9B3D3C58601D6E604F0244A040F")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        getWallpaperManager().setBitmap(bitmap);
        addTaint(bitmap.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.242 -0400", hash_original_method = "DCC00C29B93F57D37E7F7F1EC0E5F4AD", hash_generated_method = "2CF6AFCB1D96AF0794551FECD14D6F8B")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        getWallpaperManager().setStream(data);
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.243 -0400", hash_original_method = "4ED3BD15D71B912DA43CDB584176350F", hash_generated_method = "1643E4DA39B9CD39D6B65552B739B7A0")
    @Override
    public void clearWallpaper() throws IOException {
        getWallpaperManager().clear();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.244 -0400", hash_original_method = "C279CF6F1AD260899DD449A44D934DDE", hash_generated_method = "CB62F330ABB7AA88641D95F82681909B")
    @Override
    public void startActivity(Intent intent) {
        {
            boolean var4E2CEB5436A3062C8E21590CE555C7F9_908695743 = ((intent.getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException(
                    "Calling startActivity() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag."
                    + " Is this really what you want?");
            } 
        } 
        mMainThread.getInstrumentation().execStartActivity(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intent, -1);
        addTaint(intent.getTaint());
        
        
            
                    
                    
                    
        
        
            
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.244 -0400", hash_original_method = "769E1A7E8134E0631F8E7ACB4BECF53B", hash_generated_method = "403D9E40A34F6C126B10B658087F99E8")
    @Override
    public void startActivities(Intent[] intents) {
        {
            boolean varB54A748E26DA9CF993CAE37B6D958C5E_723322870 = ((intents[0].getFlags()&Intent.FLAG_ACTIVITY_NEW_TASK) == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new AndroidRuntimeException(
                    "Calling startActivities() from outside of an Activity "
                    + " context requires the FLAG_ACTIVITY_NEW_TASK flag on first Intent."
                    + " Is this really what you want?");
            } 
        } 
        mMainThread.getInstrumentation().execStartActivities(
            getOuterContext(), mMainThread.getApplicationThread(), null,
            (Activity)null, intents);
        addTaint(intents[0].getTaint());
        
        
            
                    
                    
                    
        
        
            
            
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.245 -0400", hash_original_method = "C8E02424AE63F5F49E1852E1F77F5819", hash_generated_method = "4F0C823802F5D6CCDE15AD336928E8CF")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        try 
        {
            String resolvedType = null;
            {
                fillInIntent.setAllowFds(false);
                resolvedType = fillInIntent.resolveTypeIfNeeded(getContentResolver());
            } 
            int result = ActivityManagerNative.getDefault()
                .startActivityIntentSender(mMainThread.getApplicationThread(), intent,
                        fillInIntent, resolvedType, null, null,
                        0, flagsMask, flagsValues);
            {
                if (DroidSafeAndroidRuntime.control) throw new IntentSender.SendIntentException();
            } 
            Instrumentation.checkStartActivityResult(result, null);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
        
        
            
            
                
                
            
            
                
                        
                        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.246 -0400", hash_original_method = "A60EBABFFFCFDD737FB1FDCFE05C44F2", hash_generated_method = "139225D4047699D4B430D8DCE500AA1E")
    @Override
    public void sendBroadcast(Intent intent) {
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, false);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        
        
        
            
            
                
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.246 -0400", hash_original_method = "D592FFEA5E7229A3F68F56DC823D9A2C", hash_generated_method = "E035DAD44BBB6CBB437D0C7C80636D74")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, false, false);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        
        
        
            
            
                
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.247 -0400", hash_original_method = "1B45A83FF6806414FEA9DF50022B81FD", hash_generated_method = "A1491939235E670CEDD54A4297AB7FD5")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, receiverPermission, true, false);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        
        
        
            
            
                
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.248 -0400", hash_original_method = "75D722FF40A3D746C01E744F45F69CB7", hash_generated_method = "2C878867E0D7E8D7CE514FA7581E0186")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        IIntentReceiver rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } 
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } 
        } 
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, receiverPermission,
                true, false);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.250 -0400", hash_original_method = "A9DD8A9FF695328B63C944596A4EDBF3", hash_generated_method = "44D82FE6E69256F506073E39DD610BFB")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, null,
                Activity.RESULT_OK, null, null, null, false, true);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        
        
        
            
            
                
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.251 -0400", hash_original_method = "5A5C4F9500968E8C5F0A5BF45BC32927", hash_generated_method = "29752737B2249089365D5B73B008E1B6")
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras) {
        IIntentReceiver rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = mPackageInfo.getReceiverDispatcher(
                    resultReceiver, getOuterContext(), scheduler,
                    mMainThread.getInstrumentation(), false);
            } 
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = new LoadedApk.ReceiverDispatcher(
                        resultReceiver, getOuterContext(), scheduler, null, false).getIIntentReceiver();
            } 
        } 
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().broadcastIntent(
                mMainThread.getApplicationThread(), intent, resolvedType, rd,
                initialCode, initialData, initialExtras, null,
                true, true);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.252 -0400", hash_original_method = "F1371F3418D2B98EF62AEAB9A1FB12D9", hash_generated_method = "A04BC1DAFE9A8CFD1B863CDFC8FAB153")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        String resolvedType = intent.resolveTypeIfNeeded(getContentResolver());
        {
            intent = new Intent(intent);
            intent.setDataAndType(intent.getData(), resolvedType);
        } 
        try 
        {
            intent.setAllowFds(false);
            ActivityManagerNative.getDefault().unbroadcastIntent(
                mMainThread.getApplicationThread(), intent);
        } 
        catch (RemoteException e)
        { }
        addTaint(intent.getTaint());
        
        
        
            
            
        
        
            
            
                
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.253 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "9F83FA7ADCD62B5C86A6702E4092E9EC")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_606793765 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_606793765 = registerReceiver(receiver, filter, null, null);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_606793765.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_606793765;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.254 -0400", hash_original_method = "185009C7B52864D361FCA1A63F57A4A0", hash_generated_method = "CEE014D7BAD6EA774D7A3ADFFE10759C")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_1046204687 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1046204687 = registerReceiverInternal(receiver, filter, broadcastPermission,
                scheduler, getOuterContext());
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1046204687.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1046204687;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.255 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "09F9B76BA352273CE5E92C2C7AE73447")
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_784360030 = null; 
        Intent varB4EAC82CA7396A68D541C85D26508E83_1166189785 = null; 
        IIntentReceiver rd = null;
        {
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = mPackageInfo.getReceiverDispatcher(
                    receiver, context, scheduler,
                    mMainThread.getInstrumentation(), true);
            } 
            {
                {
                    scheduler = mMainThread.getHandler();
                } 
                rd = new LoadedApk.ReceiverDispatcher(
                        receiver, context, scheduler, null, true).getIIntentReceiver();
            } 
        } 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_784360030 = ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1166189785 = null;
        } 
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(context.getTaint());
        Intent varA7E53CE21691AB073D9660D615818899_623682267; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_623682267 = varB4EAC82CA7396A68D541C85D26508E83_784360030;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_623682267 = varB4EAC82CA7396A68D541C85D26508E83_1166189785;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_623682267.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_623682267;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.256 -0400", hash_original_method = "21E1A5F4D046FA1A605B9CB2F1A5C01A", hash_generated_method = "3D901144803AB7A3430EF5C61CBA33D9")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        {
            IIntentReceiver rd = mPackageInfo.forgetReceiverDispatcher(
                    getOuterContext(), receiver);
            try 
            {
                ActivityManagerNative.getDefault().unregisterReceiver(rd);
            } 
            catch (RemoteException e)
            { }
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } 
        addTaint(receiver.getTaint());
        
        
            
                    
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.257 -0400", hash_original_method = "9B31F5C57DE16C0FCBD62EA4E59CD86B", hash_generated_method = "AEDE146786DE35134C7BAF149E9C9021")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1988235354 = null; 
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_1319343510 = null; 
        try 
        {
            service.setAllowFds(false);
            ComponentName cn = ActivityManagerNative.getDefault().startService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                boolean varD9D164FC49919222E3F05E39BAD0AAA7_1138227660 = (cn != null && cn.getPackageName().equals("!"));
                {
                    if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to start service " + service
                        + " without permission " + cn.getClassName());
                } 
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1988235354 = cn;
        } 
        catch (RemoteException e)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1319343510 = null;
        } 
        addTaint(service.getTaint());
        ComponentName varA7E53CE21691AB073D9660D615818899_1231915925; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1231915925 = varB4EAC82CA7396A68D541C85D26508E83_1988235354;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1231915925 = varB4EAC82CA7396A68D541C85D26508E83_1319343510;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1231915925.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1231915925;
        
        
            
            
                
                
            
                
                        
                        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.258 -0400", hash_original_method = "3FB64CBED2328D4F85F81CBC4C681900", hash_generated_method = "779CE997A2EBD581C3646A824E4DC1E8")
    @Override
    public boolean stopService(Intent service) {
        try 
        {
            service.setAllowFds(false);
            int res = ActivityManagerNative.getDefault().stopService(
                mMainThread.getApplicationThread(), service,
                service.resolveTypeIfNeeded(getContentResolver()));
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to stop service " + service);
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(service.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1969534370 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1969534370;
        
        
            
            
                
                
            
                
                        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.260 -0400", hash_original_method = "96A08A27D9E82A40B6EBDC8137646365", hash_generated_method = "2FCDC158FDB8162F691521D72F01D606")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        IServiceConnection sd;
        {
            sd = mPackageInfo.getServiceDispatcher(conn, getOuterContext(),
                    mMainThread.getHandler(), flags);
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } 
        try 
        {
            IBinder token = getActivityToken();
            {
                boolean var6493BF3E84461910769ACF3C960C9AA7_645428820 = (token == null && (flags&BIND_AUTO_CREATE) == 0 && mPackageInfo != null
                    && mPackageInfo.getApplicationInfo().targetSdkVersion
                    < android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH);
                {
                    flags |= BIND_WAIVE_PRIORITY;
                } 
            } 
            service.setAllowFds(false);
            int res = ActivityManagerNative.getDefault().bindService(
                mMainThread.getApplicationThread(), getActivityToken(),
                service, service.resolveTypeIfNeeded(getContentResolver()),
                sd, flags);
            {
                if (DroidSafeAndroidRuntime.control) throw new SecurityException(
                        "Not allowed to bind to service " + service);
            } 
        } 
        catch (RemoteException e)
        { }
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860049048 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860049048;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.261 -0400", hash_original_method = "9DD3486AE81B06ADE2CF5A15294BDDD9", hash_generated_method = "206EF13B4D5702AE0F9947D59F6B0DEC")
    @Override
    public void unbindService(ServiceConnection conn) {
        {
            IServiceConnection sd = mPackageInfo.forgetServiceDispatcher(
                    getOuterContext(), conn);
            try 
            {
                ActivityManagerNative.getDefault().unbindService(sd);
            } 
            catch (RemoteException e)
            { }
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        } 
        addTaint(conn.getTaint());
        
        
            
                    
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.262 -0400", hash_original_method = "CC12C19EE7A70096368CCF1888E2A848", hash_generated_method = "3EE06C3524C0ECBF90B984591923346E")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        try 
        {
            {
                arguments.setAllowFds(false);
            } 
            boolean varFB737B53559144BA0BD1ED3EEC743D0D_628937711 = (ActivityManagerNative.getDefault().startInstrumentation(
                    className, profileFile, 0, arguments, null));
        } 
        catch (RemoteException e)
        { }
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1880757121 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1880757121;
        
        
            
                
            
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.263 -0400", hash_original_method = "321D04A4EEFC063A6FECB18E3640022A", hash_generated_method = "2D1739FB44EDDDE6D9462F37E7C27F9E")
    @Override
    public Object getSystemService(String name) {
    	if (Context.SENSOR_SERVICE.equals(name)) {
    		return sensorManager;
    	} else if ("Service".equals(name)) {
    		return new LocationManager(null);
    	} else if (Context.TELEPHONY_SERVICE.equals(name)) {
            return new TelephonyManager(this);
        }
        else 
    		return new Object();
    	/*
        Object varB4EAC82CA7396A68D541C85D26508E83_972857920 = null; 
        ServiceFetcher fetcher = SYSTEM_SERVICE_MAP.get(name);
        varB4EAC82CA7396A68D541C85D26508E83_972857920 = fetcher == null ? null : fetcher.getService(this);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_972857920.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_972857920;
        */
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.264 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "B126B6607D8C8E57AB6D748F18249945")
    private WallpaperManager getWallpaperManager() {
        WallpaperManager varB4EAC82CA7396A68D541C85D26508E83_931780627 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_931780627 = (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        varB4EAC82CA7396A68D541C85D26508E83_931780627.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_931780627;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            return null;
        }
        return new DropBoxManager(service);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.266 -0400", hash_original_method = "E655FD683190F9408899A9F63A4817BD", hash_generated_method = "754CB3E7D6732C95A8B03187EF55E384")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } 
        try 
        {
            int var5F40A2437A077EA5C807226D389206D0_949017120 = (ActivityManagerNative.getDefault().checkPermission(
                    permission, pid, uid));
        } 
        catch (RemoteException e)
        { }
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557283785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557283785;
        
        
            
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.266 -0400", hash_original_method = "53BB4562C186F88686E791E4D4D7B971", hash_generated_method = "3D3DE23B5533003E28DA49657B0AB8A7")
    @Override
    public int checkCallingPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } 
        int pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_642203062 = (pid != Process.myPid());
            {
                int var78028F3F1C255CC480151714E778C1C5_1620327739 = (checkPermission(permission, pid,
                    Binder.getCallingUid()));
            } 
        } 
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43254932 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43254932;
        
        
            
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.267 -0400", hash_original_method = "5A754757CCEBCBF70FA4909241A44647", hash_generated_method = "1B785AD3C9D40A1C6A39C06BAC7A43D2")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("permission is null");
        } 
        int var34AB0D6CBBDC631C7FDA58F28B1B657C_199312580 = (checkPermission(permission, Binder.getCallingPid(),
                Binder.getCallingUid()));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364788330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_364788330;
        
        
            
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.268 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "EDD1D47CFC1E4EB07F617CFE66F36636")
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
        } 
        addTaint(permission.getTaint());
        addTaint(resultOfCheck);
        addTaint(selfToo);
        addTaint(uid);
        addTaint(message.getTaint());
        
        
            
                    
                    
                     
                     
                    
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.269 -0400", hash_original_method = "F2B22F288DBABA7E0BD88EB0745E09E9", hash_generated_method = "FC57B53127A557B3AD504478DDF41F73")
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
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.269 -0400", hash_original_method = "CA80E1A1204586397A57A1A5E2A7C208", hash_generated_method = "229AC75A92A0D4F7AD99D48F78CBDB05")
    public void enforceCallingPermission(String permission, String message) {
        enforce(permission,
                checkCallingPermission(permission),
                false,
                Binder.getCallingUid(),
                message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.271 -0400", hash_original_method = "29F4EE380B9693113A658836F1C9D9AE", hash_generated_method = "F70A85011FDF2B702518E9F5FBC8913A")
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        enforce(permission,
                checkCallingOrSelfPermission(permission),
                true,
                Binder.getCallingUid(),
                message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        
        
                
                
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.272 -0400", hash_original_method = "482617D8CF55E6FF0FA0E9B04256EFBF", hash_generated_method = "705590421E266ACE219C9F1FBD249610")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        try 
        {
            ActivityManagerNative.getDefault().grantUriPermission(
                    mMainThread.getApplicationThread(), toPackage, uri,
                    modeFlags);
        } 
        catch (RemoteException e)
        { }
        addTaint(toPackage.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.272 -0400", hash_original_method = "F750735697FFE8FE8985E9218A8D8CF6", hash_generated_method = "23DE65B58A88974A4DC027D2A87330B6")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        try 
        {
            ActivityManagerNative.getDefault().revokeUriPermission(
                    mMainThread.getApplicationThread(), uri,
                    modeFlags);
        } 
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        
        
            
                    
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.273 -0400", hash_original_method = "A8F29D130C6713A956C80075096D4067", hash_generated_method = "544AD34B4AD1ED286F5D326CFC9C18A0")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        try 
        {
            int var059CF890EB6981028B04E841A7699518_372023117 = (ActivityManagerNative.getDefault().checkUriPermission(
                    uri, pid, uid, modeFlags));
        } 
        catch (RemoteException e)
        { }
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373003068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1373003068;
        
        
            
                    
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.274 -0400", hash_original_method = "F1471C24A57D163C01E766B9D19A4C37", hash_generated_method = "69B840C8786A0FC58E40166EDEDFE080")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int pid = Binder.getCallingPid();
        {
            boolean varE3ED4E3F3F9E0B85790B6C3494D9E65F_12290770 = (pid != Process.myPid());
            {
                int varD7B1B302EF0CA5C388B6F3983890986E_867274078 = (checkUriPermission(uri, pid,
                    Binder.getCallingUid(), modeFlags));
            } 
        } 
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306719450 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1306719450;
        
        
        
            
                    
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.274 -0400", hash_original_method = "92EE95457F7ED1F3B819760C77B2C515", hash_generated_method = "21F5411E87919E56244A7364E5F03785")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int var41FF907064E7DF4DF0C5983F95FA5974_2113435786 = (checkUriPermission(uri, Binder.getCallingPid(),
                Binder.getCallingUid(), modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34017785 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_34017785;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.276 -0400", hash_original_method = "A80C4E19DF7618048E1ED051566AC69E", hash_generated_method = "D86B811A1595117E1F6FA3B93B4B5E06")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        {
            {
                boolean var7E999FB94CB59BF987157589269CB69E_12794217 = (readPermission == null
                    || checkPermission(readPermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } 
        } 
        {
            {
                boolean varBDC2A19824C9195EFA4716604E7FC089_649374599 = (writePermission == null
                    || checkPermission(writePermission, pid, uid)
                    == PackageManager.PERMISSION_GRANTED);
            } 
        } 
        {
            Object var486C2278A32794206F2AEE849917E1AC_1472629851 = (checkUriPermission(uri, pid, uid, modeFlags));
        } 
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858596062 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1858596062;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.369 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "CE5D608CB92F241C5F36C249D03E583B")
    private String uriModeFlagToString(int uriModeFlags) {
        String varB4EAC82CA7396A68D541C85D26508E83_412615188 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2082414436 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_2077690022 = null; 
        
        varB4EAC82CA7396A68D541C85D26508E83_412615188 = "read and write";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2082414436 = "read";
        
        
        varB4EAC82CA7396A68D541C85D26508E83_2077690022 = "write";
        
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        addTaint(uriModeFlags);
        String varA7E53CE21691AB073D9660D615818899_2145301181; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_412615188;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_2082414436;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2145301181 = varB4EAC82CA7396A68D541C85D26508E83_2077690022;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2145301181.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2145301181;
        
        
            
                    
                
            
                
            
                
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.277 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "8CFA06DC20027CBEB43917E502B19401")
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
        } 
        addTaint(modeFlags);
        addTaint(resultOfCheck);
        addTaint(selfToo);
        addTaint(uid);
        addTaint(uri.getTaint());
        addTaint(message.getTaint());
        
        
            
                    
                    
                     
                     
                    
                    
                    
                    
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.278 -0400", hash_original_method = "E9EAEBDE16DA8C22A5B7F64130CC6C00", hash_generated_method = "49B991110E26670EAF291BA89E5B0D03")
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
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.279 -0400", hash_original_method = "6F0B74751E74AFB2005E6D12F19CB27E", hash_generated_method = "328D75B611B7291D0B4370DD352EA9F2")
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        enforceForUri(
                modeFlags, checkCallingUriPermission(uri, modeFlags),
                false, Binder.getCallingUid(), uri, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.280 -0400", hash_original_method = "886A3C8614D2CB5B8B7CB50793F1366D", hash_generated_method = "6CD0DED0D5BFE3583BD6DC38552CD2EC")
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        enforceForUri(
                modeFlags,
                checkCallingOrSelfUriPermission(uri, modeFlags), true,
                Binder.getCallingUid(), uri, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
                
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.282 -0400", hash_original_method = "68131D896D42419119F62C3A9452D081", hash_generated_method = "7429D411895773CBB69129A3CE8AB0B8")
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
        
        
                      
                              
                              
                      
                      
                      
                      
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.284 -0400", hash_original_method = "3BCB60F29BD51DD324BEDBA4985B960D", hash_generated_method = "89A9B40F7D204D1E20B2F65281ACF28D")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_129780014 = null; 
        Context varB4EAC82CA7396A68D541C85D26508E83_193734171 = null; 
        {
            boolean varC1F5D449E2D7CC78DA5400BABA02C561_1456857788 = (packageName.equals("system") || packageName.equals("android"));
            {
                varB4EAC82CA7396A68D541C85D26508E83_129780014 = new ContextImpl(mMainThread.getSystemContext());
            } 
        } 
        LoadedApk pi = mMainThread.getPackageInfo(packageName, mResources.getCompatibilityInfo(), flags);
        {
            ContextImpl c = new ContextImpl();
            c.mRestricted = (flags & CONTEXT_RESTRICTED) == CONTEXT_RESTRICTED;
            c.init(pi, null, mMainThread, mResources, mBasePackageName);
            {
                varB4EAC82CA7396A68D541C85D26508E83_193734171 = c;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new PackageManager.NameNotFoundException(
            "Application package " + packageName + " not found");
        addTaint(packageName.getTaint());
        Context varA7E53CE21691AB073D9660D615818899_1390364816; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1390364816 = varB4EAC82CA7396A68D541C85D26508E83_129780014;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1390364816 = varB4EAC82CA7396A68D541C85D26508E83_193734171;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1390364816.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1390364816;
        
        
            
        
        
            
        
            
            
            
            
                
            
        
        
            
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.285 -0400", hash_original_method = "190E6158FD0788E25F3E34C2C0D2C33E", hash_generated_method = "4E0B0A785C831A28157C39EA9DB90462")
    @Override
    public boolean isRestricted() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128024549 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_128024549;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.286 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "379A687A564A09AD4A81C9BCAAA95AA8")
    private File getDataDirFile() {
        File varB4EAC82CA7396A68D541C85D26508E83_2028854569 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2028854569 = mPackageInfo.getDataDirFile();
        } 
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Not supported in system context");
        varB4EAC82CA7396A68D541C85D26508E83_2028854569.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2028854569;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.287 -0400", hash_original_method = "217ABBE8E0BC68B3B120E02EA884E102", hash_generated_method = "B455E6B10DF248D6CFFD66D000A040F0")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_1377665883 = null; 
        name = "app_" + name;
        File file = makeFilename(getDataDirFile(), name);
        {
            boolean varE02387E0421DAF07E6582975BDA6A5F5_964344327 = (!file.exists());
            {
                file.mkdir();
                setFilePermissionsFromMode(file.getPath(), mode,
                    FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1377665883 = file;
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1377665883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1377665883;
        
        
        
        
            
            
                    
        
        
    }

    
    @DSModeled(DSC.SAFE)
    static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.288 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "B7A5B5A3AAEC7FAC79639DD3C71CDE61")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        init(packageInfo, activityToken, mainThread, null, null);
        addTaint(packageInfo.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(mainThread.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.290 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "6C3A21EAD6054B0C270A03127A846419")
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        {
            boolean var104A93987C9CA0B1B66503A62E5FEA6A_708409802 = (mResources != null && container != null
                && container.getCompatibilityInfo().applicationScale !=
                        mResources.getCompatibilityInfo().applicationScale);
            {
                {
                    Log.d(TAG, "loaded context has different scaling. Using container's" +
                        " compatiblity info:" + container.getDisplayMetrics());
                } 
                mResources = mainThread.getTopLevelResources(
                    mPackageInfo.getResDir(), container.getCompatibilityInfo());
            } 
        } 
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        setActivityToken(activityToken);
        addTaint(activityToken.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.291 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
    final void init(Resources resources, ActivityThread mainThread) {
        mPackageInfo = null;
        mBasePackageName = null;
        mResources = resources;
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.292 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "3BFE871F528AC4979D949BF1DA9B45AF")
    final void scheduleFinalCleanup(String who, String what) {
        mMainThread.scheduleContextCleanup(this, who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.293 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "9B77B4D2288878B05ADE58D891D30BC9")
    final void performFinalCleanup(String who, String what) {
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        addTaint(who.getTaint());
        addTaint(what.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.294 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "35E77A9E500B32BE194D0230AD28BE08")
    final Context getReceiverRestrictedContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_311847673 = null; 
        Context varB4EAC82CA7396A68D541C85D26508E83_455391312 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_311847673 = mReceiverRestrictedContext;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_455391312 = mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        Context varA7E53CE21691AB073D9660D615818899_1342957557; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1342957557 = varB4EAC82CA7396A68D541C85D26508E83_311847673;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1342957557 = varB4EAC82CA7396A68D541C85D26508E83_455391312;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1342957557.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1342957557;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.294 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.295 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.296 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "F9AD74D13D8EC988A2E3A4DD407CAD1A")
    final Context getOuterContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1813657914 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1813657914 = mOuterContext;
        varB4EAC82CA7396A68D541C85D26508E83_1813657914.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1813657914;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.297 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "474C0B4DB45DEE0F94719520B1E9E41C")
    final IBinder getActivityToken() {
        IBinder varB4EAC82CA7396A68D541C85D26508E83_1998198335 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1998198335 = mActivityToken;
        varB4EAC82CA7396A68D541C85D26508E83_1998198335.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1998198335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.299 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "62831EFDFB90118942CFDCF27E4AE053")
    private File validateFilePath(String name, boolean createDirectory) {
        File varB4EAC82CA7396A68D541C85D26508E83_1928840031 = null; 
        File dir;
        File f;
        {
            boolean varFD0C1196C407A4234C7FE0E19F1943FE_2095731001 = (name.charAt(0) == File.separatorChar);
            {
                String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
                dir = new File(dirPath);
                name = name.substring(name.lastIndexOf(File.separatorChar));
                f = new File(dir, name);
            } 
            {
                dir = getDatabasesDir();
                f = makeFilename(dir, name);
            } 
        } 
        {
            boolean var3499179EFDC7A0451D45EF9132D21A84_1132952115 = (createDirectory && !dir.isDirectory() && dir.mkdir());
            {
                FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1928840031 = f;
        addTaint(name.getTaint());
        addTaint(createDirectory);
        varB4EAC82CA7396A68D541C85D26508E83_1928840031.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1928840031;
        
        
        
        
            
            
            
            
        
            
            
        
        
            
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.301 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "F508689B73F3D5AC13DA5A5C56300CCE")
    private File makeFilename(File base, String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_2105651191 = null; 
        {
            boolean varE9928D58DBE793633CB7E7D7D5D3D217_242198458 = (name.indexOf(File.separatorChar) < 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2105651191 = new File(base, name);
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                "File " + name + " contains a path separator");
        addTaint(base.getTaint());
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2105651191.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2105651191;
        
        
            
        
        
                
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.302 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.302 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        public ServiceFetcher ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.304 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "7DDF804D5F56FA9913B7AA44F4E8891C")
        public Object getService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_184554536 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_743225564 = null; 
            ArrayList<Object> cache = ctx.mServiceCache;
            Object service;
            {
                {
                    boolean var64657C48B0EB7731DEDFDF761A102E58_703295186 = (cache.size() == 0);
                    {
                        {
                            int i = 0;
                            {
                                cache.add(null);
                            } 
                        } 
                    } 
                    {
                        service = cache.get(mContextCacheIndex);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_184554536 = service;
                        } 
                    } 
                } 
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
                varB4EAC82CA7396A68D541C85D26508E83_743225564 = service;
            } 
            addTaint(ctx.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_1315101691; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_1315101691 = varB4EAC82CA7396A68D541C85D26508E83_184554536;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_1315101691 = varB4EAC82CA7396A68D541C85D26508E83_743225564;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_1315101691.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_1315101691;
            
            
            
            
                
                    
                        
                    
                
                    
                    
                        
                    
                
                
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:50.666 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "EF860758FB493A7F2A30EEFAEDF636FA")
        public Object createService(ContextImpl ctx) {
        	throw new RuntimeException("Not implemented");
            
            
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.305 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.305 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        public StaticServiceFetcher ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.306 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "54C289C8E2C272B3F3F79219C787884C")
        @Override
        public final Object getService(ContextImpl unused) {
            Object varB4EAC82CA7396A68D541C85D26508E83_1118692442 = null; 
            Object varB4EAC82CA7396A68D541C85D26508E83_1859213496 = null; 
            {
                Object var2F175684CDE577660B1158202078FB8E_279783043 = (StaticServiceFetcher.this);
                {
                    Object service = mCachedInstance;
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1118692442 = service;
                    } 
                    varB4EAC82CA7396A68D541C85D26508E83_1859213496 = mCachedInstance = createStaticService();
                } 
            } 
            addTaint(unused.getTaint());
            Object varA7E53CE21691AB073D9660D615818899_401200183; 
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: 
                    varA7E53CE21691AB073D9660D615818899_401200183 = varB4EAC82CA7396A68D541C85D26508E83_1118692442;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_401200183 = varB4EAC82CA7396A68D541C85D26508E83_1859213496;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_401200183.addTaint(getTaint()); 
            return varA7E53CE21691AB073D9660D615818899_401200183;
            
            
                
                
                    
                
                
            
        }

        
        public abstract Object createStaticService();

        
    }


    
    private static final class ApplicationContentResolver extends ContentResolver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.307 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.308 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "57E8775C65B09F3977F718498E9F7D5B")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            mMainThread = mainThread;
            addTaint(context.getTaint());
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.309 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "1E9266EF6A857E3DC75B2A57A6507287")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_784387546 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_784387546 = mMainThread.acquireProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_784387546.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_784387546;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.311 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "EDCC80F862D2A22FD7FC57A4FBE236B5")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            IContentProvider varB4EAC82CA7396A68D541C85D26508E83_1872350194 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1872350194 = mMainThread.acquireExistingProvider(context, name);
            addTaint(context.getTaint());
            addTaint(name.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_1872350194.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1872350194;
            
            
        }

        
        @DSModeled(DSC.SPEC)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.312 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "54CA51AB151EB10443CCCE885F97E482")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            boolean var38B4042628FFD57CF97DF331208B6769_652706152 = (mMainThread.releaseProvider(provider));
            addTaint(provider.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_687491895 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_687491895;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.312 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "1DD3236631063C4A39FED7CD2DD748A1")

    private final static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.313 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.313 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "C28D37FE74542C16238F74BB2031E102")

    private static final HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.313 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "24FE645B537D86D59BF761DAE24AA3EA")

    private static final String[] EMPTY_FILE_LIST = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.313 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "4284E1216B34B381ED919CF71692E867")

    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.314 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

    private static int sNextPerContextServiceCacheIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.315 -0400", hash_original_field = "7DB09CDC66836808CD50648C6519F6AD", hash_generated_field = "CD2A659A34AB859F9017A1B2CEB8A4E2")

    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.315 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "666779A41202E9B3348BBA99A71CBFCC")
        public Object createService(ContextImpl ctx) {
            Object varB4EAC82CA7396A68D541C85D26508E83_382677315 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_382677315 = new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler());
            addTaint(ctx.getTaint());
            varB4EAC82CA7396A68D541C85D26508E83_382677315.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_382677315;
            
            
                        
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

