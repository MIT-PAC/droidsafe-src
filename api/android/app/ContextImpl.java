package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

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

import droidsafe.concrete.DroidSafeContentResolver;
import droidsafe.helpers.DSUtils;

import java.util.Collections;

class ReceiverRestrictedContext extends ContextWrapper {
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.000 -0500", hash_original_method = "7FD4094CD16832D548D3CEFA622075F6", hash_generated_method = "7FD4094CD16832D548D3CEFA622075F6")
    
ReceiverRestrictedContext(Context base) {
        super(base);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.003 -0500", hash_original_method = "E79FC2581462A23AEE3B4180EBBDA608", hash_generated_method = "90430B4E7D776228913823B75B9973EF")
    
@Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return registerReceiver(receiver, filter, null, null);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.005 -0500", hash_original_method = "7DBE869AA37665F34E0D6939DBC75DAB", hash_generated_method = "BE9909161683E82474FD582E36B38112")
    
@Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        return receiver.__ds__registerIntentFilter(filter)[0];
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.008 -0500", hash_original_method = "E81E60407BE1AC3446285185653F6DEC", hash_generated_method = "70CCA2B262847282DDB92A6E7AC7ABF3")
    
@Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        throw new ReceiverCallNotAllowedException(
                "IntentReceiver components are not allowed to bind to services");
        //ex.fillInStackTrace();
        //Log.e("IntentReceiver", ex.getMessage(), ex);
        //return mContext.bindService(service, interfaceName, conn, flags);
    }
    
}

public class ContextImpl extends Context {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.187 -0500", hash_original_method = "374239E6E9AC9E3552D4A077D8744FFB", hash_generated_method = "B8FDDC39B13812FD0E23045E8DFF123F")
    
static ContextImpl getImpl(Context context) {
        Context nextContext;
        while ((context instanceof ContextWrapper) &&
                (nextContext=((ContextWrapper)context).getBaseContext()) != null) {
            context = nextContext;
        }
        return (ContextImpl)context;
    }

    /* package */ @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.344 -0500", hash_original_method = "4295EC81B8CE00729AA9F7C2FA9F917B", hash_generated_method = "01D6B75E63DA8C5A3D28233BF030539F")
    
static DropBoxManager createDropBoxManager() {
        IBinder b = ServiceManager.getService(DROPBOX_SERVICE);
        IDropBoxManagerService service = IDropBoxManagerService.Stub.asInterface(b);
        if (service == null) {
            // Don't return a DropBoxManager that will NPE upon use.
            // This also avoids caching a broken DropBoxManager in
            // getDropBoxManager during early boot, before the
            // DROPBOX_SERVICE is registered.
            return null;
        }
        return new DropBoxManager(service);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.402 -0500", hash_original_method = "6D48BCF78A0D8F638E4F8DF3493EA1A0", hash_generated_method = "337E35882617EEC65CAF3EEB0E687E78")
    
static ContextImpl createSystemContext(ActivityThread mainThread) {
        ContextImpl context = new ContextImpl();
        context.init(Resources.getSystem(), mainThread);
        return context;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.432 -0500", hash_original_method = "C8AF3048756974EA22546B41BE2F7C6F", hash_generated_method = "1DC327CB6766B683BFBFB743C0F8C248")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.012 -0500", hash_original_field = "48D68BC7A16DEEA11F7C490C1B3C5CED", hash_generated_field = "1DD3236631063C4A39FED7CD2DD748A1")

    private final static String TAG = "ApplicationContext";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.014 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "7841AA055B417A7E8C3D727A4ADDD91D")

    private final static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.017 -0500", hash_original_field = "CE42D0F9354A6290AB7AAA746491BCDC", hash_generated_field = "C28D37FE74542C16238F74BB2031E102")

private static final SharedPreferences sSharedPrefs = new SharedPreferencesImpl(null, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.061 -0500", hash_original_field = "4E4A3933C0CBDF5ABDBF6C047A99416B", hash_generated_field = "24FE645B537D86D59BF761DAE24AA3EA")

    private static final String[] EMPTY_FILE_LIST = {};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.018 -0500", hash_original_field = "EDE05288DA1A1347727FFDBB84784438", hash_generated_field = "EDE05288DA1A1347727FFDBB84784438")
 LoadedApk mPackageInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.021 -0500", hash_original_field = "80FF47EE74AECB051D8F50807A4E718C", hash_generated_field = "A7EF77D1F0E656D4474B6E8D2DBB3B3B")

    private String mBasePackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.023 -0500", hash_original_field = "8C221FB485568FEFC5ABDDF092AD743A", hash_generated_field = "8872E9F5EB468B447DB47434F2C2FEC9")

    private Resources mResources;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.025 -0500", hash_original_field = "DAA5CF027F30E341CB6E5B438E9919B8", hash_generated_field = "DAA5CF027F30E341CB6E5B438E9919B8")
 ActivityThread mMainThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.027 -0500", hash_original_field = "A42B354F9CDA77F8F2CF6E54E4A27CDB", hash_generated_field = "34FBCC1608A4936A90F9DF98F1E48881")

    private Context mOuterContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.029 -0500", hash_original_field = "FD0B1279293B26FD10DF67ECBC4986DF", hash_generated_field = "14A36E3A1E55C5D74F222A902E5EE0F2")

    private IBinder mActivityToken = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.031 -0500", hash_original_field = "67ED713B0800CADABE90004D4A5E6745", hash_generated_field = "AF9BE5AAF7F29484886F2FDF1856DC2E")

    private ApplicationContentResolver mContentResolver;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.033 -0500", hash_original_field = "A49FA12EA965E79B33F0B3229F0491B0", hash_generated_field = "299CB1540B8056273D436B48FEF6A0EE")

    private int mThemeResource = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.036 -0500", hash_original_field = "C0FB90804AB4428CA9E817247993AC1C", hash_generated_field = "ECFB75E383EB1877735FF15B18C148C8")

    private Resources.Theme mTheme = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.038 -0500", hash_original_field = "15162FAA915DF49C5A036BA7257F7284", hash_generated_field = "7DEF40BE9F330F69BEFB5B68E8125FE9")

    private PackageManager mPackageManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.040 -0500", hash_original_field = "4ED3BB16F5EA4EAC926B2C1E9F9A9B3A", hash_generated_field = "822E0B86F97CBCA30BEAC92D7074EF2C")

    private Context mReceiverRestrictedContext = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.043 -0500", hash_original_field = "447F659CEA821C391DD99DA152C356C4", hash_generated_field = "02C747C3724FCFC2B7C6A9A22D88CF16")

    private boolean mRestricted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.045 -0500", hash_original_field = "349D1EAD6A3DD6EDFBBB76E7AC55FC2F", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.047 -0500", hash_original_field = "4B4F5453FAAD1AF3E5BEECD0B2F3E6A8", hash_generated_field = "BD1C0920C019BE593BE14FA4F0428E82")

    private File mDatabasesDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.049 -0500", hash_original_field = "B80688CDDD1C13CD0F220F3A32A77FE5", hash_generated_field = "BEE1171B4DEF7C018E6FF18B5E39497F")

    private File mPreferencesDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.051 -0500", hash_original_field = "7B5121095E7B8659514EB86A9685C1BA", hash_generated_field = "836A24647D35486771B3D976EA5B50CE")

    private File mFilesDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.053 -0500", hash_original_field = "A968B97901F84DB3DB0A9D87FA171669", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.055 -0500", hash_original_field = "76B6B0D05DF66A8B4DEC0078131AAA73", hash_generated_field = "BC229612E30213AE76D95F88EDC2856F")

    private File mObbDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.057 -0500", hash_original_field = "2233E80F70C1FD2D4406B368656735A4", hash_generated_field = "7FECE535D8094A9FC9D153E6776699B3")

    private File mExternalFilesDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.059 -0500", hash_original_field = "9E234510D231B622550EC2BDD8537555", hash_generated_field = "507D0ED70658593E79745C0F5D91041A")

    private File mExternalCacheDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.189 -0500", hash_original_field = "2F69AB504EDBEC75083AAFA041ED1434", hash_generated_field = "3570C11DC541CECD116D769F16D06D48")

    // cached per-ContextImpl.  Package-scoped to avoid accessor
    // methods.
    final ArrayList<Object> mServiceCache = new ArrayList<Object>();

    WallpaperManager wallPaperManager = new WallpaperManager(this, mMainThread.getHandler());
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.131 -0400", hash_original_field = "13BBA1D4EB247DCAB6C28F8022170B75", hash_generated_field = "4284E1216B34B381ED919CF71692E867")

    // orphaned legacy field
    private DroidSafeContentResolver contentResolver;
    
    // orphaned legacy field
    private SensorManager sensorManager;
    
	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    public ContextImpl() {
		contentResolver = new DroidSafeContentResolver(this);
		sensorManager = new SensorManager();
	}

    /**
     * Create a new ApplicationContext from an existing one.  The new one
     * works and operates the same as the one it is copying.
     *
     * @param context Existing application context.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.406 -0500", hash_original_method = "9A0B254F42B92476EDBA974C3F238399", hash_generated_method = "EAA69C86A4E9505E19D8891B84BFB3BB")
    
public ContextImpl(ContextImpl context) {
        mPackageInfo = context.mPackageInfo;
        mBasePackageName = context.mBasePackageName;
        mResources = context.mResources;
        mMainThread = context.mMainThread;
        mContentResolver = context.mContentResolver;
        mOuterContext = this;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public AssetManager getAssets() {
        return AssetManager.getSystem();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.SOURCE)
    public Resources getResources() {
        return Resources.getSystem();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    
    public ContentResolver getContentResolver() {
        return contentResolver;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public Looper getMainLooper() {
    	return Looper.getMainLooper();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public Context getApplicationContext() {
        return DroidSafeAndroidRuntime.mApplication;
    }
    
    @Override
    public void setTheme(int resid) {
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.208 -0500", hash_original_method = "AE4733E1C9FA88CFC00EFC04FF1EA93F", hash_generated_method = "CE5A2BC266716375B637FA5870314F3E")
    
@Override
    public int getThemeResId() {
        return mThemeResource;
    }
    
    @Override
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public String getPackageName() {
        return new String("DSUnknown (Package Name)");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public String getPackageResourcePath() {
        return "DSUnknown (Package Resource Path)";
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public String getPackageCodePath() {
        return "DSUnknown (Package Code Path)";
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public File getSharedPrefsFile(String name) {
        return new File("DSUnknown");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {        
        return sSharedPrefs;
    }

    //added by droidsafe to share static preferences around.
    public static SharedPreferences getSharedPreferencesDS() {
        return sSharedPrefs;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.229 -0500", hash_original_method = "0A29125F4E4AA8A93CA3D1CE13216DA3", hash_generated_method = "3F44C0278EEBAE876BE1E4B6C59E4EDC")
    
private File getPreferencesDir() {
        synchronized (mSync) {
            if (mPreferencesDir == null) {
                mPreferencesDir = new File(getDataDirFile(), "shared_prefs");
            }
            return mPreferencesDir;
        }
    }
    

    @Override
    @DSSafe(DSCat.FS_INFO)
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    @DSSafe(DSCat.FS_INFO)
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }
    
    @DSVerified
    @DSSpec(DSCat.FILE_SYSTEM)
    @Override
    public boolean deleteFile(String name) {
        return false;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getFilesDir() {
        return new File("<files-dir>");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getExternalFilesDir(String type) {
        return new File("<external-files-dir>");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getObbDir() {
        return new File("<obb-dir>");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getCacheDir() {
        return new File("<cache-dir>");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getExternalCacheDir() {
        return new File("<external-cache-dir>");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.FS_INFO)
    public File[] getExternalCacheDirs(String type) {
        File file = new File("<external-cache-dirs>/{type=" + type + "}");
        return new File[] {file};
    }
    
    @DSSafe(DSCat.FS_INFO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public File[] getExternalFileDirs(String type) {
        File file = new File("<external-file-dirs>/{type=" + type + "}");
        return new File[] {file};
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.FS_INFO)
    public File[] getObbDirs(String type) {
        File file = new File("<obb-dir>");
        return new File[] {file};
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    @DSSafe(DSCat.FS_INFO)
    public File getFileStreamPath(String name) {
        return new File("<app-dir>/" + name);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.FS_INFO)
    @Override
    public String[] fileList() {
        String file = new String("<app-dir>/<private-files>");
        String[] files = new String[1];
        files[0] = file;
        return files;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.261 -0500", hash_original_method = "65FB5D1503ECB4784897EFA233F40D4E", hash_generated_method = "84BE5A8970A0E0573304AB63A724FE37")
   @DSSpec(DSCat.DATABASE) 
@Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f, factory);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        return db;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.263 -0500", hash_original_method = "E2C57028FEE97C40627D175379C5C276", hash_generated_method = "F757051A6F1AA50C45F64144CC800557")
    
   @DSSpec(DSCat.DATABASE) 
@Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        File f = validateFilePath(name, true);
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(f.getPath(), factory, errorHandler);
        setFilePermissionsFromMode(f.getPath(), mode, 0);
        return db;
    }
    
   @DSSpec(DSCat.DATABASE) 
    @Override
    public boolean deleteDatabase(String name) {
       return getTaintBoolean();
        //throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.FS_INFO)
    @Override
    public File getDatabasePath(String name) {
        //throw new UnsupportedOperationException();
        return new File("<database-path>/" + name);
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSSafe(DSCat.FS_INFO)
    @Override
    public String[] databaseList() {
        //throw new UnsupportedOperationException();
        String file = new String("<database-dir>/<private-db>");
        String[] files = new String[1];
        files[0] = file;
        return files;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.272 -0500", hash_original_method = "5E7F893311C7FFBA04D943EFEC31C4D2", hash_generated_method = "CECB6C2171E104773B017888B934F3B5")
    
    private File getDatabasesDir() {
        synchronized (mSync) {
            if (mDatabasesDir == null) {
                mDatabasesDir = new File(getDataDirFile(), "databases");
            }
            if (mDatabasesDir.getPath().equals("databases")) {
                mDatabasesDir = new File("/data/system");
            }
            return mDatabasesDir;
        }
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void clearWallpaper() {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void startActivity(Intent intent) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void startActivities(Intent[] intents) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void removeStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
    	// Generate Intents based on filter
        return receiver.__ds__registerIntentFilter(filter)[0];
    }
    
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
    	// Generate Intents based on filter
        return receiver.__ds__registerIntentFilter(filter)[0];
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.322 -0500", hash_original_method = "22E75A5CFB9DB3D3B6EDA1829895EA59", hash_generated_method = "85AC04DA82678F15AAEBF3306262841C")
    
private Intent registerReceiverInternal(BroadcastReceiver receiver,
            IntentFilter filter, String broadcastPermission,
            Handler scheduler, Context context) {
        IIntentReceiver rd = null;
        if (receiver != null) {
            if (mPackageInfo != null && context != null) {
                if (scheduler == null) {
                    scheduler = mMainThread.getHandler();
                }
                rd = mPackageInfo.getReceiverDispatcher(
                    receiver, context, scheduler,
                    mMainThread.getInstrumentation(), true);
            } else {
                if (scheduler == null) {
                    scheduler = mMainThread.getHandler();
                }
                rd = new LoadedApk.ReceiverDispatcher(
                        receiver, context, scheduler, null, true).getIIntentReceiver();
            }
        }
        try {
            return ActivityManagerNative.getDefault().registerReceiver(
                    mMainThread.getApplicationThread(), mBasePackageName,
                    rd, filter, broadcastPermission);
        } catch (RemoteException e) {
            return null;
        }
    }
    
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        throw new UnsupportedOperationException();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public ComponentName startService(Intent service) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean stopService(Intent service) {
        throw new UnsupportedOperationException();
    }
    
    ComponentName serviceCompName = null; 

    @DSVerified("Calling connection callback")
    @DSSpec(DSCat.SERVICE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        //throw new UnsupportedOperationException();
        if (serviceCompName == null) {
            serviceCompName = new ComponentName(new String(), new String());
        }
        
        if (conn != null) {
            conn.onServiceConnected(serviceCompName, mActivityToken);
            conn.onServiceDisconnected(serviceCompName);
        }
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        return getTaintBoolean();
    }

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK) 
    @Override
    public void unbindService(ServiceConnection conn) {
        if (conn != null) {
            conn.onServiceDisconnected(serviceCompName);
        }
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        throw new UnsupportedOperationException();
  }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:33.108 -0400", hash_original_method = "0B425FF354429B91E3FB5E5F0CCF5247", hash_generated_method = "9DC6D6BDC8B919CA9F34CC2423316AAF")
    private WallpaperManager getWallpaperManager() {
		return wallPaperManager;

        // ---------- Original Method ----------
        //return (WallpaperManager) WALLPAPER_FETCHER.getService(this);
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

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.355 -0500", hash_original_method = "6A8DDEA43434D3CB20BB0A5477A87FA9", hash_generated_method = "232F074112C61C087B9C620E93374F5E")
    
private void enforce(
            String permission, int resultOfCheck,
            boolean selfToo, int uid, String message) {
        if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    permission +
                    ".");
        }
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
    
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.378 -0500", hash_original_method = "4ABE3E1ABE03D924F88AC8D7A295DCAE", hash_generated_method = "9AD5945F2AFB3A1EB579635C3FB1068B")
    
private String uriModeFlagToString(int uriModeFlags) {
        switch (uriModeFlags) {
            case Intent.FLAG_GRANT_READ_URI_PERMISSION |
                    Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                return "read and write";
            case Intent.FLAG_GRANT_READ_URI_PERMISSION:
                return "read";
            case Intent.FLAG_GRANT_WRITE_URI_PERMISSION:
                return "write";
        }
        throw new IllegalArgumentException(
                "Unknown permission mode flags: " + uriModeFlags);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.380 -0500", hash_original_method = "6A9FD3C401F0CEC7314A7CD25AD534A9", hash_generated_method = "9E69D25BC0E2F5A67B5636B63ACB6648")
    
private void enforceForUri(
            int modeFlags, int resultOfCheck, boolean selfToo,
            int uid, Uri uri, String message) {
        if (resultOfCheck != PackageManager.PERMISSION_GRANTED) {
            throw new SecurityException(
                    (message != null ? (message + ": ") : "") +
                    (selfToo
                     ? "Neither user " + uid + " nor current process has "
                     : "User " + uid + " does not have ") +
                    uriModeFlagToString(modeFlags) +
                    " permission on " +
                    uri +
                    ".");
        }
    }
    
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }
    
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public Context createPackageContext(String packageName, int flags)
            throws PackageManager.NameNotFoundException {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public boolean isRestricted() {
        throw new UnsupportedOperationException();        
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.398 -0500", hash_original_method = "E67FD2E3CB9CBDDDA85EF29E76BC4DD2", hash_generated_method = "16A3CADF8A8FD33F9B29B8BC2A22D525")
    
private File getDataDirFile() {
        if (mPackageInfo != null) {
            return mPackageInfo.getDataDirFile();
        }
        throw new RuntimeException("Not supported in system context");
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public File getDir(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.408 -0500", hash_original_method = "32CF6005086B5520DA4AE96ECAD890BA", hash_generated_method = "BFEB5056C60F11BF4EC12AB46B425601")
    
final void init(LoadedApk packageInfo,
            IBinder activityToken, ActivityThread mainThread) {
        init(packageInfo, activityToken, mainThread, null, null);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.412 -0500", hash_original_method = "617B56367877BE6D5351978E32679FCB", hash_generated_method = "E1643BC9B55B363AC0F781D5F3DCDECD")
    
final void init(LoadedApk packageInfo,
                IBinder activityToken, ActivityThread mainThread,
                Resources container, String basePackageName) {
        mPackageInfo = packageInfo;
        mBasePackageName = basePackageName != null ? basePackageName : packageInfo.mPackageName;
        mResources = mPackageInfo.getResources(mainThread);

        if (mResources != null && container != null
                && container.getCompatibilityInfo().applicationScale !=
                        mResources.getCompatibilityInfo().applicationScale) {
            if (DEBUG) {
                Log.d(TAG, "loaded context has different scaling. Using container's" +
                        " compatiblity info:" + container.getDisplayMetrics());
            }
            mResources = mainThread.getTopLevelResources(
                    mPackageInfo.getResDir(), container.getCompatibilityInfo());
        }
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);

        setActivityToken(activityToken);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.414 -0500", hash_original_method = "A01AC1DE8A0942D58F790AE1580128F4", hash_generated_method = "0E222A7658B0C236572FED39EC0F0A40")
    
final void init(Resources resources, ActivityThread mainThread) {
        mPackageInfo = null;
        mBasePackageName = null;
        mResources = resources;
        mMainThread = mainThread;
        mContentResolver = new ApplicationContentResolver(this, mainThread);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.416 -0500", hash_original_method = "3668A95D26BB557CD7264A8982F20E37", hash_generated_method = "557563E6590F34D000FF7D119C19BA5A")
    
final void scheduleFinalCleanup(String who, String what) {
        mMainThread.scheduleContextCleanup(this, who, what);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.418 -0500", hash_original_method = "0501008D8AD4AD5FA54A7545814DC0B6", hash_generated_method = "0932B236CD2E7CD152D62004CFBBD224")
    
final void performFinalCleanup(String who, String what) {
        //Log.i(TAG, "Cleanup up context: " + this);
        mPackageInfo.removeContextRegistrations(getOuterContext(), who, what);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.420 -0500", hash_original_method = "00E338AD03CD22E7A509C63ABE7257F4", hash_generated_method = "E1719FC9EAE97D56287081945234BDDE")
    
final Context getReceiverRestrictedContext() {
        if (mReceiverRestrictedContext != null) {
            return mReceiverRestrictedContext;
        }
        return mReceiverRestrictedContext = new ReceiverRestrictedContext(getOuterContext());
    }
    
    private static final class ApplicationContentResolver extends ContentResolver {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.449 -0500", hash_original_field = "DAA5CF027F30E341CB6E5B438E9919B8", hash_generated_field = "3BD1B37D989628ECBEBF06B5281DCE58")

        private  ActivityThread mMainThread;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.440 -0500", hash_original_method = "FC2218F5409D3B615253B9FADC78F4F0", hash_generated_method = "C2EBBD2140065E086EED206CC0344224")
        
public ApplicationContentResolver(Context context, ActivityThread mainThread) {
            super(context);
            mMainThread = mainThread;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.443 -0500", hash_original_method = "1D54690CD1C75C22354AFE636FCBB54C", hash_generated_method = "6063FDEE8174953C12FD264964B27DEF")
        
@Override
        protected IContentProvider acquireProvider(Context context, String name) {
            return mMainThread.acquireProvider(context, name);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.445 -0500", hash_original_method = "88B28437EF544809DF8D55FC39CCF726", hash_generated_method = "B4BC64D206110C52B89606435D2DF13F")
        
@Override
        protected IContentProvider acquireExistingProvider(Context context, String name) {
            return mMainThread.acquireExistingProvider(context, name);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.447 -0500", hash_original_method = "2FE34FA97A494E67E9164BEE654A40D1", hash_generated_method = "AA138E241B11F3617397F6F75314F90A")
        
@Override
        public boolean releaseProvider(IContentProvider provider) {
            return mMainThread.releaseProvider(provider);
        }
        
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.422 -0500", hash_original_method = "909971A42CA4D34B6A2AABA7AFFB96CE", hash_generated_method = "104771F57298BD479FD780160FB97942")
    
final void setActivityToken(IBinder token) {
        mActivityToken = token;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.424 -0500", hash_original_method = "A74250CBDFD89C9F601A5AA3ED01CDC8", hash_generated_method = "35BB7ACF4CB3C4C9F87F055BBEC0D230")
    
final void setOuterContext(Context context) {
        mOuterContext = context;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.427 -0500", hash_original_method = "03C284D73757410812309249CAB76117", hash_generated_method = "4E683FF5A8BC97CB945DA2DFC7A929BE")
    
final Context getOuterContext() {
        return mOuterContext;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.429 -0500", hash_original_method = "D32D1A589CFC02641AF8A3133A37BC7F", hash_generated_method = "D2B98033670730E13D8A5E06B011771E")
    
final IBinder getActivityToken() {
        return mActivityToken;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.434 -0500", hash_original_method = "B435A8710874F18AA5DE97F01977E23C", hash_generated_method = "3C5A65C32C57D3A4778CD3ED95B90BBB")
    
private File validateFilePath(String name, boolean createDirectory) {
        File dir;
        File f;

        if (name.charAt(0) == File.separatorChar) {
            String dirPath = name.substring(0, name.lastIndexOf(File.separatorChar));
            dir = new File(dirPath);
            name = name.substring(name.lastIndexOf(File.separatorChar));
            f = new File(dir, name);
        } else {
            dir = getDatabasesDir();
            f = makeFilename(dir, name);
        }

        if (createDirectory && !dir.isDirectory() && dir.mkdir()) {
            FileUtils.setPermissions(dir.getPath(),
                FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                -1, -1);
        }

        return f;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:57.437 -0500", hash_original_method = "E9A305FD20BBA1C0FB0979159F7000FC", hash_generated_method = "1CCB9A221099E3C08074D57F5429D26F")
    
private File makeFilename(File base, String name) {
        if (name.indexOf(File.separatorChar) < 0) {
            return new File(base, name);
        }
        throw new IllegalArgumentException(
                "File " + name + " contains a path separator");
    }

    @Override
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public File[] getExternalCacheDirs() {
        // TODO Auto-generated method stub
        File[] files = new File[1];
        
        files[0] = new File("<external-cache-dirs>");
        
        return files;
        
    }

    @Override
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public File[] getExternalFileDirs() {
        File[] files = new File[1];
        
        files[0] = new File("<external-file-dirs>");
        
        return files;
    }

    @Override
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public File[] getObbDirs() {
        File[] files = new File[1];
        
        files[0] = new File("<obb-dirs>");
        
        return files;
    }
    
}

