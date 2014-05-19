package android.content;

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

import com.android.internal.policy.PolicyManager;

import android.accounts.AccountManager;
import android.accounts.IAccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.StatusBarManager;
import android.app.UiModeManager;
import android.app.admin.DevicePolicyManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.usb.IUsbManager;
import android.hardware.usb.UsbManager;
import android.location.CountryDetector;
import android.location.ICountryDetector;
import android.location.LocationManager;
import android.location.ILocationManager;
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
import android.os.Handler;
import android.os.IBinder;
import android.os.IPowerManager;
import android.os.Looper;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.provider.AlarmClock;
import android.telephony.TelephonyManager;
import android.view.CompatibilityInfoHolder;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManagerImpl;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;

public class ContextWrapper extends Context {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.092 -0500", hash_original_field = "45A1FAFEC6ED7EF70B481175C79188A0", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;

    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.OS_GENERAL)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.095 -0500", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "B8ABB131CA8665C04FDC2AFCAE3905CE")
    
public ContextWrapper(Context base) {
        mBase = base;
    }
    
    protected void attachBaseContext(Context base) {
        mBase = base;
    }

    /**
     * @return the base context as set by the constructor or setBaseContext
     */
    @DSComment("delegated to android.content.Context")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.099 -0500", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "DA754C99DA3B20091EE22A3809569BE4")
    
public Context getBaseContext() {
        return mBase;
    }

    @DSComment("Accessing App Resource")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.102 -0500", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "6CB5F06DB234C725609449A49F465CA2")
    
@Override
    public AssetManager getAssets() {
        return mBase.getAssets();
    }

    @DSComment("Accessing App Resource")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.104 -0500", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "B4F0C829CD4F5F2C97CA8904752E4CF8")
    
@Override
    public Resources getResources()
    {
        return mBase.getResources();
    }

    @DSComment("Android Manager retrieved/accessed")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.106 -0500", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "8F16F9223B72E9B17F9B501EDFC09857")
    
@Override
    public PackageManager getPackageManager() {
        return mBase.getPackageManager();
    }

    @DSComment("General android operation, no security concern")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.109 -0500", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "139D612C99B54783A4962502799FFB5A")
    
@Override
    public ContentResolver getContentResolver() {
        return mBase.getContentResolver();
    }

    @DSComment("General android operation, no security concern")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.111 -0500", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "6EEAF27F90D1C6317E7721349FF9813F")
    
@Override
    public Looper getMainLooper() {
        return mBase.getMainLooper();
    }
    
    @DSComment("delegated to android.content.Context")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.113 -0500", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "A6D0C1903DCB48BCDDC31B2E575E3D5A")
    
@Override
    public Context getApplicationContext() {
        return mBase.getApplicationContext();
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.115 -0500", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "0D55832D602F2CF9FB8E76E5D16912B6")
    
@Override
    public void setTheme(int resid) {
        mBase.setTheme(resid);
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.117 -0500", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "AFA0D21A0F3F2A89A23FF54022E56F46")
    
@Override
    public int getThemeResId() {
        return mBase.getThemeResId();
    }

    @DSSource({DSSourceKind.RESOURCES})
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.120 -0500", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "A9363DFE0568A2EA37CF4138C68635A9")
    
@Override
    public Resources.Theme getTheme() {
        return mBase.getTheme();
    }

    @DSComment("Refelction/class loader")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.122 -0500", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "CD16D25F5FDB5376B6D65A38DAD451DB")
    
@Override
    public ClassLoader getClassLoader() {
        return mBase.getClassLoader();
    }

    @DSComment("Is there concern about package info harvesting???")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.124 -0500", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "981E8FCA373F2235FD0793073F84BFB1")
    
@Override
    public String getPackageName() {
        return mBase.getPackageName();
    }

    @DSComment("Harvesting information")
    @DSSpec(DSCat.SECURITY)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.126 -0500", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "FE296D16B1CFFEEEDB18114E3BAD0956")
    
@Override
    public ApplicationInfo getApplicationInfo() {
        return mBase.getApplicationInfo();
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.128 -0500", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "817366513C6780B3AFAB65AEECFDEB91")
    
@Override
    public String getPackageResourcePath() {
        return mBase.getPackageResourcePath();
    }

    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.131 -0500", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "C796F4FD1D22BA33BA9F69A37BB8C39E")
    
@Override
    public String getPackageCodePath() {
        return mBase.getPackageCodePath();
    }

    /** @hide */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.133 -0500", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "2A0C250F3A35574A6093B36A1F4A4320")
    
@Override
    public File getSharedPrefsFile(String name) {
        return mBase.getSharedPrefsFile(name);
    }

    @DSSpec(DSCat.ABSTRACT_METHOD)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.136 -0500", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "BB704DA8F5AC55B97A278F82E1650118")
    @DSVerified
@Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return mBase.getSharedPreferences(name, mode);
    }

    @DSVerified
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.139 -0500", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "4E892866A57704AD43DCD1822DAC1B41")
    
@Override
    public FileInputStream openFileInput(String name)
        throws FileNotFoundException {
        return mBase.openFileInput(name);
    }

    @DSVerified
    @DSComment("IO movement methodName")
    @DSSpec(DSCat.IO)
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.141 -0500", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "01EA4CF88D4454D02E59AE01582F31BB")
    
@Override
    public FileOutputStream openFileOutput(String name, int mode)
        throws FileNotFoundException {
        return mBase.openFileOutput(name, mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.143 -0500", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "088BEFD9F1B8635996E5A51BFD67A075")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSVerified
    
@Override
    public boolean deleteFile(String name) {
        return mBase.deleteFile(name);
    }

    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.145 -0500", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "DD85A67E109B3B87717E895779708082")
    
@Override
    public File getFileStreamPath(String name) {
        return mBase.getFileStreamPath(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.147 -0500", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "9CB350BD6B1DABA2CBCEBA29342AD670")
    
@Override
    public String[] fileList() {
        return mBase.fileList();
    }

    @DSVerified
    @DSComment("Method returns IO Object")
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.150 -0500", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "58D9BF1BB0E543D2ED8CF780E3EDB5A5")
    
@Override
    public File getFilesDir() {
        return mBase.getFilesDir();
    }
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.152 -0500", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "74788A6B35EEC28097DFD9AF92A3AD42")
    
@Override
    public File getExternalFilesDir(String type) {
        return mBase.getExternalFilesDir(type);
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.154 -0500", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "4E58085C8DDCC2BDAF8530221C73DDA2")
    
@Override
    public File getObbDir() {
        return mBase.getObbDir();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.156 -0500", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "0F6E27ED3C39786F554597D2572B5FD9")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public File getCacheDir() {
        return mBase.getCacheDir();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.159 -0500", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "5907DC0B3DDB4625833A1540D8CFA11E")
    
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public File getExternalCacheDir() {
        return mBase.getExternalCacheDir();
    }
    
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @Override
    public File[] getExternalCacheDirs() {
        return mBase.getExternalCacheDirs();
    }

    @DSVerified
    @DSSafe(DSCat.FS_INFO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @Override
    public File[] getExternalFileDirs() {
        return mBase.getExternalFileDirs();
    }

    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @Override
    public File[] getObbDirs() {
        return mBase.getObbDirs();
    }

    @DSComment("Method returns IO Object")
    @DSSpec(DSCat.IO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.161 -0500", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "6C7C58FB9AB46404091EC495CF6EE142")
    @DSVerified
    
@Override
    public File getDir(String name, int mode) {
        return mBase.getDir(name, mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.163 -0500", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "F75FC8CDE79A6B9ED45517DBB10EF4B8")
    @DSVerified
    @DSSpec(DSCat.DATABASE)
@Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        //return mBase.openOrCreateDatabase(name, mode, factory);
        SQLiteDatabase db = SQLiteDatabase.openDatabase(name, factory, mode); 
        return db;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.166 -0500", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "B78B1255E8ACE0078D1779299830C1AB")
    @DSVerified
    @DSSpec(DSCat.DATABASE)
    
@Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(name, factory, mode); 
        errorHandler.onCorruption(db);
        //return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        return db;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.168 -0500", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "5F9D01C1C5301426A2D101BDA344D5A9")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSVerified
@Override
    public boolean deleteDatabase(String name) {
        return mBase.deleteDatabase(name);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.170 -0500", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "C3D6263238BAE1469C805D6EC8E52340")
    @DSSpec(DSCat.FILE_SYSTEM)
    @DSVerified
    
@Override
    public File getDatabasePath(String name) {
        return mBase.getDatabasePath(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.172 -0500", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "22F6340706BFD95A2683CEF2116DA3F9")
    
@Override
    public String[] databaseList() {
        return mBase.databaseList();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.174 -0500", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "BD27CE5E9792B8BF942573B95F3A8F87")
    
@Override
    public Drawable getWallpaper() {
        return mBase.getWallpaper();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.176 -0500", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "96E812F3093FF5E2C406F2CDD5049FA3")
    
@Override
    public Drawable peekWallpaper() {
        return mBase.peekWallpaper();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.179 -0500", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "2DE9382B5DE3CE5219A7232D48C0CB14")
    
@Override
    public int getWallpaperDesiredMinimumWidth() {
        return mBase.getWallpaperDesiredMinimumWidth();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.182 -0500", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "A92765679C906390CE7CA9E4DBD06D06")
    
@Override
    public int getWallpaperDesiredMinimumHeight() {
        return mBase.getWallpaperDesiredMinimumHeight();
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.184 -0500", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "FD1EAF4DA4587A50600F5BB24F751124")
    @DSVerified
    @DSSpec(DSCat.IO)
    
@Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
    }

    @DSSink({DSSinkKind.ACCOUNT_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.186 -0500", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "8AAD2E0863A03186AD47504774357069")
    @DSVerified
    @DSSpec(DSCat.IO)
    
@Override
    public void setWallpaper(InputStream data) throws IOException {
        mBase.setWallpaper(data);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.188 -0500", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "3A8932FE55ADDD5CFD46245D43702F93")
    
@Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
    }

    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
    @DSSink({DSSinkKind.START_ACTIVITY})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.190 -0500", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "992EA6715D65F485692876B471F1C6B9")
    
@Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }

    @DSSink({DSSinkKind.START_ACTIVITY})
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.193 -0500", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "52762932C0CF308D26FC5B36BA40DE9B")
    
@Override
    public void startActivities(Intent[] intents) {
        mBase.startActivities(intents);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.196 -0500", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "A75697A4F883BAA4873AD01D25FE8E42")    
    @Override
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException {
        mBase.startIntentSender(intent, fillInIntent, flagsMask,
                flagsValues, extraFlags);
    }
    
    @DSComment("IO movement methodName")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.198 -0500", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "BE288488A1FBD4AF9F7B86466BB1D059")
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    @Override
    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.200 -0500", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "DA4E611FCD62E3251428C579B62B39B8")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @Override
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mBase.sendBroadcast(intent, receiverPermission);
    }
    @DSVerified
    @DSComment("IO movement methodName")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.202 -0500", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "B9C5A334E7FCF219150501789BEAC80C")
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.205 -0500", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "60EB3C25B9CDBEE2156292B403A5D265")
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    @Override
    public void sendOrderedBroadcast(
        Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendOrderedBroadcast(intent, receiverPermission,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.207 -0500", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "5C8026ECFF9BD6F962718388BB93A0F3")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    @Override
    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.210 -0500", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "BE7EB70AC42FBFF67990C422D3707BA6")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")    
    @DSSink({DSSinkKind.IPC})
    @DSSpec(DSCat.IPC)
    @Override
    public void sendStickyOrderedBroadcast(
        Intent intent, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendStickyOrderedBroadcast(intent,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.212 -0500", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "00EC50DC96CCBD32534F9677AF9377C0")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
@Override
    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
    }
    
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return receiver.__ds__registerIntentFilter(this, filter)[0];
    	//return null; // no 'sticky' intents need to be modeled for coverage
    }

    /*
     * Register to receive intent broadcasts, to run in the context of scheduler. See registerReceiver(BroadcastReceiver, IntentFilter) for more information. This allows you to enforce permissions on who can broadcast intents to your receiver, or have the receiver run in a different thread than the main application thread.(non-Javadoc)
     * @see android.content.Context#registerReceiver(android.content.BroadcastReceiver, android.content.IntentFilter, java.lang.String, android.os.Handler)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.217 -0500", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "33D6C6769721FBE99429C7A0DC3317BE")
    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.ANDROID_CALLBACK)
@Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        
        Intent intent = receiver.__ds__registerIntentFilter(this,filter)[0];
        
        mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);

        return intent;
    }

    @DSVerified
    @DSComment("No action for callback unregistration")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.220 -0500", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "A589371689D3516AE882F7EC4F1BDC2E")
    
@Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mBase.unregisterReceiver(receiver);
    }

    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.SERVICE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.222 -0500", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "5AF5415B02FACA6C8C573880AF05D53F")
    
@Override
    public ComponentName startService(Intent service) {
        //DSTODO:  We need to translate the service request to the correct service
        //then call onStart on that
        return mBase.startService(service);
    }

    @DSVerified
    @DSComment("Potential intent to trigger other processing")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.225 -0500", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "DA0A6458C647468F8B3105A4F87E6EDB")
    
@Override
    public boolean stopService(Intent name) {
        return mBase.stopService(name);
    }

    @DSVerified
    @DSComment("Bind a service with a connection")
    @DSSpec(DSCat.SERVICE)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.227 -0500", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "5A2B04010F66FEE0B0F4E923A6C9E2B2")
    
@Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        return true; //mBase.bindService(service, conn, flags);
    }

    @DSComment("No action for callback unregistration")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.229 -0500", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "9D13666F99397A76F4A8C5FD5E183D4C")
    @DSVerified
    
@Override
    public void unbindService(ServiceConnection conn) {
        mBase.unbindService(conn);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.231 -0500", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "8E4409240F730EE1F3CC7BCB054AF805")
    @DSVerified("Profiling/instrumentation")
    @DSSpec(DSCat.SPEC_OTHERS)
@Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        return mBase.startInstrumentation(className, profileFile, arguments);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.236 -0500", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "11FAA9A8384227E39B26ED6F4D6FDD3C")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public int checkPermission(String permission, int pid, int uid) {
        return mBase.checkPermission(permission, pid, uid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.238 -0500", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "E5B546D6D794FC539A8C76FE500E7065")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public int checkCallingPermission(String permission) {
        return mBase.checkCallingPermission(permission);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.241 -0500", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "8DB094A80A821530555CD857FFDE637D")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public int checkCallingOrSelfPermission(String permission) {
        return mBase.checkCallingOrSelfPermission(permission);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.243 -0500", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "B541C02D400D327BFC8A863CB221E700")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        mBase.enforcePermission(permission, pid, uid, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.245 -0500", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "F1A1AA6DD63283430C52F59384C1F3F3")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public void enforceCallingPermission(String permission, String message) {
        mBase.enforceCallingPermission(permission, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.247 -0500", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "6BD9531BD72EEBC2BE26D0F6B94ADDA0")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        mBase.enforceCallingOrSelfPermission(permission, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.249 -0500", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "7BA0AD8BAB7B54004790634065682072")
    @DSVerified("give permission to another package")
    @DSSpec(DSCat.IPC)
@Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.251 -0500", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "EA2BB356A403CB0A29926364F604F673")
    @DSVerified
    @DSComment("permission gets tricter")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mBase.revokeUriPermission(uri, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.253 -0500", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "84F559A0441EA14DF929C8887AC5E9CD")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.256 -0500", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "DA22B6B4EFE351EB981FB3B607B43BA9")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.259 -0500", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "8D5CD58B7022F8E1098C2683AE8AC8AE")

    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.262 -0500", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "BB227A21E6F75659ECE0815EC53CE623")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        return mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.264 -0500", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "A1DA191496375CAF53C7A371A3324AC4")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.266 -0500", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "586FC8D427CD7F814109367B959D81D1")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.269 -0500", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "9F64ED44F0281A804086053600C1F83D")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.271 -0500", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "DCCE951A6A6EBABA0F084FC4321A4944")
    
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
@Override
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(
                uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
    }

    @DSComment("Get another app info")
    @DSSpec(DSCat.PACKAGE_INFO)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.273 -0500", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "480E359F080974DFAA38904C4A23473E")
    
@Override
    public Context createPackageContext(String packageName, int flags)
        throws PackageManager.NameNotFoundException {
        return mBase.createPackageContext(packageName, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:41.275 -0500", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "6554424247FEA087DF5168B6356CD30C")
    @DSVerified
    @DSComment("only checking")
    @DSSafe(DSCat.SAFE_OTHERS)
    
@Override
    public boolean isRestricted() {
        return mBase.isRestricted();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    public CompatibilityInfoHolder getCompatibilityInfo(int displayId) {
        return mBase.getCompatibilityInfo(displayId);
    }
    
}

