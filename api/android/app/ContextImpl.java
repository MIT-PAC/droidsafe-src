package android.app;

// Droidsafe Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.IContentProvider;
import android.content.IIntentReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ReceiverCallNotAllowedException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
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
import android.net.IThrottleManager;
import android.net.NetworkPolicyManager;
import android.net.ThrottleManager;
import android.net.Uri;
import android.net.wifi.IWifiManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.IWifiP2pManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.FileUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

import com.android.internal.os.IDropBoxManagerService;
import com.android.internal.policy.PolicyManager;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.concrete.DroidSafeContentResolver;

class ReceiverRestrictedContext extends ContextWrapper {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.059 -0400", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "26ACA97A400E372B38EB9A675A8132FB")
      ReceiverRestrictedContext(Context base) {
        super(base);
        addTaint(base.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.059 -0400", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "D608908D746D10916B4095E402568990")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varD535A24B470170C9E7EA08ED846B5DCB_39836133 =         registerReceiver(receiver, filter, null, null);
        varD535A24B470170C9E7EA08ED846B5DCB_39836133.addTaint(taint);
        return varD535A24B470170C9E7EA08ED846B5DCB_39836133;
        // ---------- Original Method ----------
        //return registerReceiver(receiver, filter, null, null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.060 -0400", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "1F3A8BDB68C4E15A753ABE5D240E603B")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        ReceiverCallNotAllowedException var407F1997E2CF2D1DCB2F742C7E6ABC2A_688725319 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to register to receive intents");
        var407F1997E2CF2D1DCB2F742C7E6ABC2A_688725319.addTaint(taint);
        throw var407F1997E2CF2D1DCB2F742C7E6ABC2A_688725319;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to register to receive intents");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.060 -0400", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "855E1EBB0D5B5D11B7F33F73441536E2")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        ReceiverCallNotAllowedException var729F58CF16FF58058AE63A05FEB9E78F_202471322 = new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        var729F58CF16FF58058AE63A05FEB9E78F_202471322.addTaint(taint);
        throw var729F58CF16FF58058AE63A05FEB9E78F_202471322;
        // ---------- Original Method ----------
        //throw new ReceiverCallNotAllowedException(
                //"IntentReceiver components are not allowed to bind to services");
    }

    
}

public class ContextImpl extends Context {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "F26EF77FADF5A57881907E560F2D0D42", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")

    LoadedApk mPackageInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "150BB4175FE9139A54D3AF314D73B91A", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "0D8AC9B29D5FDF7FAC18EB1269D7F6D0", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")

    ActivityThread mMainThread;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "D10CC1136F43CB8D3AAE1B13B8FBB4DD", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "2BE449269B1F4C70928A0DCFE94621E0", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "AA30776C328196000CD028A324C818FD", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "CE5AF0AE42F0D6CB1908A11BF7CF16FA", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "78906EEF842F20C56E3EE018C7F5BDA7", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "7D66DD2494F037ED6AC341A00B2AD467", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "B21243549DB3C4FC35772D5A6CD22B8A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.061 -0400", hash_original_field = "ADD7E2B2442A13369398593FA842CF51", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "31F3077B8747A5A9D3290AEC5630F5D0", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "8672D560D8B148EC9C43183252399EC3", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "73A71AF7C46968236F3164132333F1FD", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "52A2417455D76879BFA170FFF26775B5", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "E65B49FD891CDDD102DA56E94053DEBA", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "C9602422414763F3A8137ECD73997A49", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.062 -0400", hash_original_field = "9CDF81E446283F70EAFFA44FDC69EEA5", hash_generated_field = "D63EC7F2931BD6BAD4B3EF85C123726C")

    final ArrayList<Object> mServiceCache = new ArrayList<Object>();
    
    @DSModeled(DSC.SPEC)
	public ContextImpl() {
		contentResolver = new DroidSafeContentResolver(this);
		sensorManager = new SensorManager();
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.063 -0400", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "953194B41378DE16C60A8443D4FF5403")
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

    
    @DSModeled(DSC.SAFE)
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

    
    @Override
    public AssetManager getAssets() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    @DSModeled(DSC.SPEC)
    public Resources getResources() {
        return Resources.getSystem();
    }

    
    @Override
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    @DSModeled(DSC.SPEC)
    public ContentResolver getContentResolver() {
        return contentResolver;
    }

    
    @Override
    public Looper getMainLooper() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public Context getApplicationContext() {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public void setTheme(int resid) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.066 -0400", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "469249C54C189C42FBC62825A9683033")
    @Override
    public int getThemeResId() {
        int var1A7BE5C50406CFB30A072C422592257E_250445033 = (mThemeResource);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625183285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1625183285;
        // ---------- Original Method ----------
        //return mThemeResource;
    }

    
    @Override
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @Override
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public String getPackageName() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public String getPackageResourcePath() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public String getPackageCodePath() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getSharedPrefsFile(String name) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.071 -0400", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "3E4E7766B0DED496458EDE1A39939CF9")
    private File getPreferencesDir() {
        synchronized
(mSync)        {
            if(mPreferencesDir == null)            
            {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            } //End block
File varB5580270F36BE30B06AE9DEFC8DEE79A_507544949 =             mPreferencesDir;
            varB5580270F36BE30B06AE9DEFC8DEE79A_507544949.addTaint(taint);
            return varB5580270F36BE30B06AE9DEFC8DEE79A_507544949;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mPreferencesDir == null) {
                //mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            //}
            //return mPreferencesDir;
        //}
    }

    
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public boolean deleteFile(String name) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getFilesDir() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getExternalFilesDir(String type) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getObbDir() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getCacheDir() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getExternalCacheDir() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getFileStreamPath(String name) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public String[] fileList() {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.078 -0400", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "AE13D2DD8E914E679C8603936D3464CA")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_474569250 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_474569250.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_474569250;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.078 -0400", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "DF6B3A5E12A24D787DE4ABF76B70323A")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
SQLiteDatabase var2F732BA7E0C8A6B94C1D7B25B6A078BE_237158048 =         db;
        var2F732BA7E0C8A6B94C1D7B25B6A078BE_237158048.addTaint(taint);
        return var2F732BA7E0C8A6B94C1D7B25B6A078BE_237158048;
        // ---------- Original Method ----------
        //File f = validateFilePath(name, true);
        //SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        //setFilePermissionsFromMode(f.getPath(), mode, 0);
        //return db;
    }

    
    @Override
    public boolean deleteDatabase(String name) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public File getDatabasePath(String name) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public String[] databaseList() {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.080 -0400", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "0BCF517720F4FD6FA1F80926818391CD")
    private File getDatabasesDir() {
        synchronized
(mSync)        {
            if(mDatabasesDir == null)            
            {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            } //End block
            if(mDatabasesDir.getPath().equals("databases"))            
            {
                mDatabasesDir = new File("/data/system");
            } //End block
File var03F2278E22352E1F6C912BE2E985552F_206274327 =             mDatabasesDir;
            var03F2278E22352E1F6C912BE2E985552F_206274327.addTaint(taint);
            return var03F2278E22352E1F6C912BE2E985552F_206274327;
        } //End block
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

    
    @Override
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void clearWallpaper() {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void startActivities(Intent[] intents) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void removeStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
    	receiver.onReceive(this, new Intent());
    	return null; // no 'sticky' intents need to be modeled for coverage
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.104 -0400", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "43B2BF89975362326EFDEF5C29629973")
    private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        addTaint(context.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        IIntentReceiver rd = null;
        if(receiver != null)        
        {
            if(mPackageInfo != null && context != null)            
            {
                if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = mPackageInfo.getReceiverDispatcher(
                    receiver, context, scheduler,
                    mMainThread.getInstrumentation(), true);
            } //End block
            else
            {
                if(scheduler == null)                
                {
                    scheduler = mMainThread.getHandler();
                } //End block
                rd = new LoadedApk.ReceiverDispatcher(
                        receiver, context, scheduler, null, true).getIIntentReceiver();
            } //End block
        } //End block
        try 
        {
Intent var2F4548E10CBDEA14DF6B0F5748692FEB_1171730969 =             ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
            var2F4548E10CBDEA14DF6B0F5748692FEB_1171730969.addTaint(taint);
            return var2F4548E10CBDEA14DF6B0F5748692FEB_1171730969;
        } //End block
        catch (RemoteException e)
        {
Intent var540C13E9E156B687226421B24F2DF178_1029140709 =             null;
            var540C13E9E156B687226421B24F2DF178_1029140709.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1029140709;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public ComponentName startService(Intent service) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public boolean stopService(Intent service) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void unbindService(ServiceConnection conn) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        throw new UnsupportedOperationException();
  }

    
    @Override
	@DSModeled(value = DSC.SAFE)
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
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.108 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "9DC6D6BDC8B919CA9F34CC2423316AAF")
    private WallpaperManager getWallpaperManager() {
WallpaperManager var7DCBA8725EE8E928D8710BDCD76F68F8_1962399602 =         (WallpaperManager) WALLPAPER_FETCHER.getService(this);
        var7DCBA8725EE8E928D8710BDCD76F68F8_1962399602.addTaint(taint);
        return var7DCBA8725EE8E928D8710BDCD76F68F8_1962399602;
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

    
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public int checkCallingPermission(String permission) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.110 -0400", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "5BB4D99C6796D51F5C5DB798AB5D5B3C")
    private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(selfToo);
        addTaint(resultOfCheck);
        addTaint(permission.getTaint());
        if(resultOfCheck != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException varE050E0B9F98E39D331C5436BC1F85F8F_522468923 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
            varE050E0B9F98E39D331C5436BC1F85F8F_522468923.addTaint(taint);
            throw varE050E0B9F98E39D331C5436BC1F85F8F_522468923;
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

    
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void enforceCallingPermission(String permission, String message) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.114 -0400", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "D5A164F066DC40893BBC893CC934B4B8")
    private String uriModeFlagToString(int uriModeFlags) {
        addTaint(uriModeFlags);
switch(uriModeFlags){
        case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String varB66BDCE2B275B77D4B33D75B25097E16_277676137 =         "read and write";
        varB66BDCE2B275B77D4B33D75B25097E16_277676137.addTaint(taint);
        return varB66BDCE2B275B77D4B33D75B25097E16_277676137;
        case Intent.FLAG_GRANT_READ_URI_PERMISSION:
String var8406D42862B2F33E68A58F11E3652EA9_558903356 =         "read";
        var8406D42862B2F33E68A58F11E3652EA9_558903356.addTaint(taint);
        return var8406D42862B2F33E68A58F11E3652EA9_558903356;
        case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
String var1D88E2A6AC371783E3524ED205D20662_132970480 =         "write";
        var1D88E2A6AC371783E3524ED205D20662_132970480.addTaint(taint);
        return var1D88E2A6AC371783E3524ED205D20662_132970480;
}        IllegalArgumentException var3D3A9E5462A7D4A56D1C234DC46E3B04_419040999 = new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
        var3D3A9E5462A7D4A56D1C234DC46E3B04_419040999.addTaint(taint);
        throw var3D3A9E5462A7D4A56D1C234DC46E3B04_419040999;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.115 -0400", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "31449087A3AA8A60A1B9198669E5798A")
    private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
        addTaint(message.getTaint());
        addTaint(uri.getTaint());
        addTaint(uid);
        addTaint(selfToo);
        addTaint(resultOfCheck);
        addTaint(modeFlags);
        if(resultOfCheck != PackageManager.PERMISSION_GRANTED)        
        {
            SecurityException var47D452409C040F6BBFD52844F43F3DAE_1381616320 = new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    uriModeFlagToString(modeFlags) +
                    " permission on " +
                    uri +
                    ".");
            var47D452409C040F6BBFD52844F43F3DAE_1381616320.addTaint(taint);
            throw var47D452409C040F6BBFD52844F43F3DAE_1381616320;
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

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SPEC)
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    
    @Override
    public Context createPackageContext(String packageName, int flags)
            throws PackageManager.NameNotFoundException {
        throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRestricted() {
        throw new UnsupportedOperationException();        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.118 -0400", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "4CAE89A8970C39DFE71503D53F5E095B")
    private File getDataDirFile() {
        if(mPackageInfo != null)        
        {
File varFC9C2C7F2B1B79BD901FB4B96215DB24_856543158 =             mPackageInfo.getDataDirFile();
            varFC9C2C7F2B1B79BD901FB4B96215DB24_856543158.addTaint(taint);
            return varFC9C2C7F2B1B79BD901FB4B96215DB24_856543158;
        } //End block
        RuntimeException varEE904A2D709F2CDD39CAD0AF95215C1A_1740967280 = new RuntimeException("Not supported in system context");
        varEE904A2D709F2CDD39CAD0AF95215C1A_1740967280.addTaint(taint);
        throw varEE904A2D709F2CDD39CAD0AF95215C1A_1740967280;
        // ---------- Original Method ----------
        //if (mPackageInfo != null) {
            //return mPackageInfo.getDataDirFile();
        //}
        //throw new RuntimeException("Not supported in system context");
    }

    
    @Override
    public File getDir(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    
    static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.119 -0400", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "AE2CC5C57D9D5C26CA316310EFA3A3B8")
    final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        addTaint(mainThread.getTaint());
        addTaint(activityToken.getTaint());
        addTaint(packageInfo.getTaint());
        init(packageInfo, activityToken, mainThread, null, null);
        // ---------- Original Method ----------
        //init(packageInfo, activityToken, mainThread, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.119 -0400", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "3BC163CC2102C44B3CFCAD183744CCC5")
    final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        addTaint(activityToken.getTaint());
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);
        if(mResources != null && container != null
                && container.getCompatibilityInfo().applicationScale !=
                        mResources.getCompatibilityInfo().applicationScale)        
        {
            if(DEBUG)            
            {
                Log.d(TAG, "loaded context has different scaling. Using container's" +
                        " compatiblity info:" + container.getDisplayMetrics());
            } //End block
            mResources = mainThread.getTopLevelResources(
                    mPackageInfo.getResDir(), container.getCompatibilityInfo());
        } //End block
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
        setActivityToken(activityToken);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.120 -0400", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "B64720F78160A873470409736052901F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.120 -0400", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "AEFCCA08892C84D675AD5641AAB08075")
    final void scheduleFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mMainThread.scheduleContextCleanup(this, who, what);
        // ---------- Original Method ----------
        //mMainThread.scheduleContextCleanup(this, who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.121 -0400", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "54C566E7BE538AE9A5BF1A18440BA5CE")
    final void performFinalCleanup(String who, String what) {
        addTaint(what.getTaint());
        addTaint(who.getTaint());
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
        // ---------- Original Method ----------
        //mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.121 -0400", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "D633E95438E4D4495D54D17BB8A58C95")
    final Context getReceiverRestrictedContext() {
        if(mReceiverRestrictedContext != null)        
        {
Context varA84ADA944216C52FAC66287846BC900D_120328806 =             mReceiverRestrictedContext;
            varA84ADA944216C52FAC66287846BC900D_120328806.addTaint(taint);
            return varA84ADA944216C52FAC66287846BC900D_120328806;
        } //End block
Context var7BF64381736836E6D5B8EFBEBA0DD76E_2085466171 =         mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
        var7BF64381736836E6D5B8EFBEBA0DD76E_2085466171.addTaint(taint);
        return var7BF64381736836E6D5B8EFBEBA0DD76E_2085466171;
        // ---------- Original Method ----------
        //if (mReceiverRestrictedContext != null) {
            //return mReceiverRestrictedContext;
        //}
        //return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.122 -0400", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "C4C31AC20FA544B3334C8E032915E0EF")
    final void setActivityToken(IBinder token) {
        mActivityToken = token;
        // ---------- Original Method ----------
        //mActivityToken = token;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.122 -0400", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "F5D9056DA7F9C25752FDC44D6CB7B93B")
    final void setOuterContext(Context context) {
        mOuterContext = context;
        // ---------- Original Method ----------
        //mOuterContext = context;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.122 -0400", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "8F84B6703026E9C3A2692830399A3448")
    final Context getOuterContext() {
Context var05221853CA1248996DC6A0DB070356A2_1081893138 =         mOuterContext;
        var05221853CA1248996DC6A0DB070356A2_1081893138.addTaint(taint);
        return var05221853CA1248996DC6A0DB070356A2_1081893138;
        // ---------- Original Method ----------
        //return mOuterContext;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.123 -0400", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "FBBF27435E3B24A82D25219873351FA6")
    final IBinder getActivityToken() {
IBinder var776483BEB0D8BCC1373C51E8861CFB6F_944315431 =         mActivityToken;
        var776483BEB0D8BCC1373C51E8861CFB6F_944315431.addTaint(taint);
        return var776483BEB0D8BCC1373C51E8861CFB6F_944315431;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.126 -0400", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "95DA246C45244B00BF0BD94F34CA4C0E")
    private File validateFilePath(String name, boolean createDirectory) {
        addTaint(createDirectory);
        addTaint(name.getTaint());
        File dir;
        File f;
        if(name.charAt(0) == File.separatorChar)        
        {
            String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
            dir = new File(dirPath);
            name = name.substring(name.lastIndexOf(File.separatorChar));
            f = new File(dir, name);
        } //End block
        else
        {
            dir = getDatabasesDir();
            f = makeFilename(dir, name);
        } //End block
        if(createDirectory && !dir.isDirectory() && dir.mkdir())        
        {
            FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
        } //End block
File varABE3CFB53FE4A79F34CB25BC80BFD6E2_786471606 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_786471606.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_786471606;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.127 -0400", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "D89D4DCF1C5E12272E3957FCCD0A252D")
    private File makeFilename(File base, String name) {
        addTaint(name.getTaint());
        addTaint(base.getTaint());
        if(name.indexOf(File.separatorChar) < 0)        
        {
File var1737453552AEDF3042D01F5D328877B0_481861044 =             new File(base, name);
            var1737453552AEDF3042D01F5D328877B0_481861044.addTaint(taint);
            return var1737453552AEDF3042D01F5D328877B0_481861044;
        } //End block
        IllegalArgumentException var43A7391A8C864B703618A9E060576B77_1328765649 = new IllegalArgumentException(
                "File " + name + " contains a path separator");
        var43A7391A8C864B703618A9E060576B77_1328765649.addTaint(taint);
        throw var43A7391A8C864B703618A9E060576B77_1328765649;
        // ---------- Original Method ----------
        //if (name.indexOf(File.separatorChar) < 0) {
            //return new File(base, name);
        //}
        //throw new IllegalArgumentException(
                //"File " + name + " contains a path separator");
    }

    
    static class ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.127 -0400", hash_original_field = "11138EF8AAFCAE7E2D7F37AF352B0770", hash_generated_field = "20F7EDA162164996331945812DFD02D4")

        int mContextCacheIndex = -1;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.127 -0400", hash_original_method = "89135ACC7FF80D7CE959D5207760FBC6", hash_generated_method = "89135ACC7FF80D7CE959D5207760FBC6")
        @DSModeled(DSC.SAFE)
        public ServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.127 -0400", hash_original_method = "B6729E9AD3191DC45FFEF069242EB9AE", hash_generated_method = "D7DF58C7A6E4B38FCADC71D28CBC9C8F")
        public Object getService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
            ArrayList<Object> cache = ctx.mServiceCache;
            Object service;
            synchronized
(cache)            {
                if(cache.size() == 0)                
                {
for(int i = 0;i < sNextPerContextServiceCacheIndex;i++)
                    {
                        cache.add(null);
                    } //End block
                } //End block
                else
                {
                    service = cache.get(mContextCacheIndex);
                    if(service != null)                    
                    {
Object var18881A382C668272945CA08D6E19E173_317555480 =                         service;
                        var18881A382C668272945CA08D6E19E173_317555480.addTaint(taint);
                        return var18881A382C668272945CA08D6E19E173_317555480;
                    } //End block
                } //End block
                service = createService(ctx);
                cache.set(mContextCacheIndex, service);
Object var18881A382C668272945CA08D6E19E173_1102709340 =                 service;
                var18881A382C668272945CA08D6E19E173_1102709340.addTaint(taint);
                return var18881A382C668272945CA08D6E19E173_1102709340;
            } //End block
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.128 -0400", hash_original_method = "46ECB6FD3C57198589BC43EC5E83533F", hash_generated_method = "D627C76D53CA767EEE80C9722217E388")
        public Object createService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
            RuntimeException varECF25F51942B946710F937BB139F9A1F_2096872765 = new RuntimeException("Not implemented");
            varECF25F51942B946710F937BB139F9A1F_2096872765.addTaint(taint);
            throw varECF25F51942B946710F937BB139F9A1F_2096872765;
            // ---------- Original Method ----------
            //throw new RuntimeException("Not implemented");
        }

        
    }


    
    abstract static class StaticServiceFetcher extends ServiceFetcher {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.128 -0400", hash_original_field = "ADDD4BB358F7AD43A1A174EC547D00F5", hash_generated_field = "5F0E5A47E62743034DEA32CA1075BE94")

        private Object mCachedInstance;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.128 -0400", hash_original_method = "8F4B3E9510C7190A989D0DB2833CAA4A", hash_generated_method = "8F4B3E9510C7190A989D0DB2833CAA4A")
        @DSModeled(DSC.SAFE)
        public StaticServiceFetcher ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.129 -0400", hash_original_method = "1B75D0F6FCB51C941C36BEE235F0DE1C", hash_generated_method = "4915950F92325BA6CC1BBDCD86649F07")
        @Override
        public final Object getService(ContextImpl unused) {
            addTaint(unused.getTaint());
            synchronized
(StaticServiceFetcher.this)            {
                Object service = mCachedInstance;
                if(service != null)                
                {
Object var18881A382C668272945CA08D6E19E173_181692166 =                     service;
                    var18881A382C668272945CA08D6E19E173_181692166.addTaint(taint);
                    return var18881A382C668272945CA08D6E19E173_181692166;
                } //End block
Object var43F21808E64BDDCA0A2A490DACFF475F_1010162685 =                 mCachedInstance = createStaticService();
                var43F21808E64BDDCA0A2A490DACFF475F_1010162685.addTaint(taint);
                return var43F21808E64BDDCA0A2A490DACFF475F_1010162685;
            } //End block
            // ---------- Original Method ----------
            //synchronized (StaticServiceFetcher.this) {
                //Object service = mCachedInstance;
                //if (service != null) {
                    //return service;
                //}
                //return mCachedInstance = createStaticService();
            //}
        }

        
        @DSModeled(DSC.SAFE)
        public abstract Object createStaticService();

        
    }


    
    private static final class ApplicationContentResolver extends ContentResolver {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.129 -0400", hash_original_field = "46FDB2388003D2F8D58B7436C6E7B099", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private ActivityThread mMainThread;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.130 -0400", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "359DBF2FD41658189FAAF78BDED31F8F")
        public  ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            addTaint(context.getTaint());
            mMainThread = mainThread;
            // ---------- Original Method ----------
            //mMainThread = mainThread;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.130 -0400", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "D03BEC942A7B17286E612DA1A57E4E17")
        @Override
        protected IContentProvider acquireProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var504CEE3172AE9DFD9087963E4D1C26EC_1639759555 =             mMainThread.acquireProvider(context, name);
            var504CEE3172AE9DFD9087963E4D1C26EC_1639759555.addTaint(taint);
            return var504CEE3172AE9DFD9087963E4D1C26EC_1639759555;
            // ---------- Original Method ----------
            //return mMainThread.acquireProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.130 -0400", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "6E55B03B2DFEE6C220F59016108EF931")
        @Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            addTaint(name.getTaint());
            addTaint(context.getTaint());
IContentProvider var1E904BFF275D0D05BE64E7DBFB56C1C8_614601652 =             mMainThread.acquireExistingProvider(context, name);
            var1E904BFF275D0D05BE64E7DBFB56C1C8_614601652.addTaint(taint);
            return var1E904BFF275D0D05BE64E7DBFB56C1C8_614601652;
            // ---------- Original Method ----------
            //return mMainThread.acquireExistingProvider(context, name);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "5C187116518D672C6D1050201B520FCC")
        @Override
        public boolean releaseProvider(IContentProvider provider) {
            addTaint(provider.getTaint());
            boolean var8D325C1832521ECE73A55AE353080AA9_1462372605 = (mMainThread.releaseProvider(provider));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2043086072 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2043086072;
            // ---------- Original Method ----------
            //return mMainThread.releaseProvider(provider);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "DBC1AC9CDA1CA721403986EF486E93FD", hash_generated_field = "1DD3236631063C4A39FED7CD2DD748A1")

    private final static String TAG = "ApplicationContext";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "6207FCFCFA690538862FA691A68C4AB1", hash_generated_field = "C28D37FE74542C16238F74BB2031E102")

    private static final HashMap<String, SharedPreferencesImpl> sSharedPrefs = new HashMap<String, SharedPreferencesImpl>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "8606DB58F4504BB95F437927A1118D9A", hash_generated_field = "24FE645B537D86D59BF761DAE24AA3EA")

    private static final String[] EMPTY_FILE_LIST = {};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "4284E1216B34B381ED919CF71692E867")

    private static final HashMap<String, ServiceFetcher> SYSTEM_SERVICE_MAP = new HashMap<String, ServiceFetcher>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "27718F14D4140FEAE2ACB2C6900056C4", hash_generated_field = "BD87370C7C88691CA93E0A9F7822E99D")

    private static int sNextPerContextServiceCacheIndex = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.132 -0400", hash_original_field = "7DB09CDC66836808CD50648C6519F6AD", hash_generated_field = "1EBC9263F872A8A59E25D724C87886B5")

    private static ServiceFetcher WALLPAPER_FETCHER = new ServiceFetcher() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.132 -0400", hash_original_method = "08C2B02667D273FDC254F58A2074D83A", hash_generated_method = "0959D483423C5C87B4EAECF826217CE3")
        public Object createService(ContextImpl ctx) {
            addTaint(ctx.getTaint());
Object varDBBAAAC9107CE4BCE906761B33CD6DC6_1526316759 =             new WallpaperManager(ctx.getOuterContext(),
                        ctx.mMainThread.getHandler());
            varDBBAAAC9107CE4BCE906761B33CD6DC6_1526316759.addTaint(taint);
            return varDBBAAAC9107CE4BCE906761B33CD6DC6_1526316759;
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
    
    // orphaned legacy field
    private DroidSafeContentResolver contentResolver;
    
    // orphaned legacy field
    private SensorManager sensorManager;
    
}

