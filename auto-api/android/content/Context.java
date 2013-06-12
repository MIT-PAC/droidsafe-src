package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class Context {
    public static final int MODE_PRIVATE = 0x0000;
    public static final int MODE_WORLD_READABLE = 0x0001;
    public static final int MODE_WORLD_WRITEABLE = 0x0002;
    public static final int MODE_APPEND = 0x8000;
    public static final int MODE_MULTI_PROCESS = 0x0004;
    public static final int BIND_AUTO_CREATE = 0x0001;
    public static final int BIND_DEBUG_UNBIND = 0x0002;
    public static final int BIND_NOT_FOREGROUND = 0x0004;
    public static final int BIND_ABOVE_CLIENT = 0x0008;
    public static final int BIND_ALLOW_OOM_MANAGEMENT = 0x0010;
    public static final int BIND_WAIVE_PRIORITY = 0x0020;
    public static final int BIND_IMPORTANT = 0x0040;
    public static final int BIND_ADJUST_WITH_ACTIVITY = 0x0080;
    public static final int BIND_NOT_VISIBLE = 0x40000000;
    public static final String POWER_SERVICE = "power";
    public static final String WINDOW_SERVICE = "window";
    public static final String LAYOUT_INFLATER_SERVICE = "layout_inflater";
    public static final String ACCOUNT_SERVICE = "account";
    public static final String ACTIVITY_SERVICE = "activity";
    public static final String ALARM_SERVICE = "alarm";
    public static final String NOTIFICATION_SERVICE = "notification";
    public static final String ACCESSIBILITY_SERVICE = "accessibility";
    public static final String KEYGUARD_SERVICE = "keyguard";
    public static final String LOCATION_SERVICE = "location";
    public static final String COUNTRY_DETECTOR = "country_detector";
    public static final String SEARCH_SERVICE = "search";
    public static final String SENSOR_SERVICE = "sensor";
    public static final String STORAGE_SERVICE = "storage";
    public static final String WALLPAPER_SERVICE = "wallpaper";
    public static final String VIBRATOR_SERVICE = "vibrator";
    public static final String STATUS_BAR_SERVICE = "statusbar";
    public static final String CONNECTIVITY_SERVICE = "connectivity";
    public static final String THROTTLE_SERVICE = "throttle";
    public static final String NETWORKMANAGEMENT_SERVICE = "network_management";
    public static final String NETWORK_STATS_SERVICE = "netstats";
    public static final String NETWORK_POLICY_SERVICE = "netpolicy";
    public static final String WIFI_SERVICE = "wifi";
    public static final String WIFI_P2P_SERVICE = "wifip2p";
    public static final String AUDIO_SERVICE = "audio";
    public static final String TELEPHONY_SERVICE = "phone";
    public static final String CLIPBOARD_SERVICE = "clipboard";
    public static final String INPUT_METHOD_SERVICE = "input_method";
    public static final String TEXT_SERVICES_MANAGER_SERVICE = "textservices";
    public static final String APPWIDGET_SERVICE = "appwidget";
    public static final String BACKUP_SERVICE = "backup";
    public static final String DROPBOX_SERVICE = "dropbox";
    public static final String DEVICE_POLICY_SERVICE = "device_policy";
    public static final String UI_MODE_SERVICE = "uimode";
    public static final String DOWNLOAD_SERVICE = "download";
    public static final String NFC_SERVICE = "nfc";
    public static final String SIP_SERVICE = "sip";
    public static final String USB_SERVICE = "usb";
    public static final int CONTEXT_INCLUDE_CODE = 0x00000001;
    public static final int CONTEXT_IGNORE_SECURITY = 0x00000002;
    public static final int CONTEXT_RESTRICTED = 0x00000004;
    
    public abstract AssetManager getAssets();

    
    public abstract Resources getResources();

    
    public abstract PackageManager getPackageManager();

    
    public abstract ContentResolver getContentResolver();

    
    public abstract Looper getMainLooper();

    
    public abstract Context getApplicationContext();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.483 -0400", hash_original_method = "CA41FDFA6BB6EC9A7DA4C7864F293E89", hash_generated_method = "A731A49CD8808349244E12D18E899FEF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        getApplicationContext().registerComponentCallbacks(callback);
        // ---------- Original Method ----------
        //getApplicationContext().registerComponentCallbacks(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.483 -0400", hash_original_method = "494D7366CDA5CBFD506341B295742C11", hash_generated_method = "2D6E208C640AA935484967C3D6FAABBB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(callback.dsTaint);
        getApplicationContext().unregisterComponentCallbacks(callback);
        // ---------- Original Method ----------
        //getApplicationContext().unregisterComponentCallbacks(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.483 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "E1D2AB0F8495B1D6875AEBF9DED1D6E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence getText(int resId) {
        dsTaint.addTaint(resId);
        CharSequence varCE77F3EBEEF8ECEB4093243855E180E5_808031734 = (getResources().getText(resId));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.483 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "F9238A983FE657BE8AD9E5DD174445CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(int resId) {
        dsTaint.addTaint(resId);
        String var4D971E738462AED5F8C202AA44008DD1_119752195 = (getResources().getString(resId));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getString(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.484 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "AB9AB202CF2CDD350F13E88E14E505AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(int resId, Object... formatArgs) {
        dsTaint.addTaint(resId);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String var3D9BFC044EEC4D309825E04863344990_1853339836 = (getResources().getString(resId, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getString(resId, formatArgs);
    }

    
    public abstract void setTheme(int resid);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.484 -0400", hash_original_method = "50CDF7EE4EA4E2BC75FC99DEA1DDCB11", hash_generated_method = "C402031281646ABFAA7B42EC722430E2")
    @DSModeled(DSC.SAFE)
    public int getThemeResId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    public abstract Resources.Theme getTheme();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.484 -0400", hash_original_method = "FF26021DC793B4DE3C0383ED66D7E1E8", hash_generated_method = "C4D6EFD68F08428D076A5C9BEE637287")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TypedArray obtainStyledAttributes(
            int[] attrs) {
        dsTaint.addTaint(attrs);
        TypedArray varED9F3111CA4CF713406C8A3D1EF41AEB_243313993 = (getTheme().obtainStyledAttributes(attrs));
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.484 -0400", hash_original_method = "C05CBF641E41D370531BE7FED84BE5CE", hash_generated_method = "B012DF14BC6266E9BCB184B7D468B85D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TypedArray obtainStyledAttributes(
            int resid, int[] attrs) throws Resources.NotFoundException {
        dsTaint.addTaint(resid);
        dsTaint.addTaint(attrs);
        TypedArray var475E30B532CD8B0AC2559CA39E980A98_70602583 = (getTheme().obtainStyledAttributes(resid, attrs));
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(resid, attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.485 -0400", hash_original_method = "C594E5E7DCFBB517BAAED03BB3D45896", hash_generated_method = "8E6F4D70BD6B4EC55E6E5C94F73652EA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs) {
        dsTaint.addTaint(set.dsTaint);
        dsTaint.addTaint(attrs);
        TypedArray var2752D611BC213CFB1C16C3B3A1F344F9_785422610 = (getTheme().obtainStyledAttributes(set, attrs, 0, 0));
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(set, attrs, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.485 -0400", hash_original_method = "23F3A3F4901D9D1C9DD21EEAA884561D", hash_generated_method = "68380DD20316589B232770884FD0DC76")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        dsTaint.addTaint(defStyleRes);
        dsTaint.addTaint(defStyleAttr);
        dsTaint.addTaint(set.dsTaint);
        dsTaint.addTaint(attrs);
        TypedArray var9371167E95A2CEAE3B3A6F800BBD7E0A_534224328 = (getTheme().obtainStyledAttributes(
            set, attrs, defStyleAttr, defStyleRes));
        return (TypedArray)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(
            //set, attrs, defStyleAttr, defStyleRes);
    }

    
    public abstract ClassLoader getClassLoader();

    
    public abstract String getPackageName();

    
    public abstract ApplicationInfo getApplicationInfo();

    
    public abstract String getPackageResourcePath();

    
    public abstract String getPackageCodePath();

    
    public abstract File getSharedPrefsFile(String name);

    
    public abstract SharedPreferences getSharedPreferences(String name,
            int mode);

    
    public abstract FileInputStream openFileInput(String name)
        throws FileNotFoundException;

    
    public abstract FileOutputStream openFileOutput(String name, int mode)
        throws FileNotFoundException;

    
    public abstract boolean deleteFile(String name);

    
    public abstract File getFileStreamPath(String name);

    
    public abstract File getFilesDir();

    
    public abstract File getExternalFilesDir(String type);

    
    public abstract File getObbDir();

    
    public abstract File getCacheDir();

    
    public abstract File getExternalCacheDir();

    
    public abstract String[] fileList();

    
    public abstract File getDir(String name, int mode);

    
    public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory);

    
    public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory, DatabaseErrorHandler errorHandler);

    
    public abstract boolean deleteDatabase(String name);

    
    public abstract File getDatabasePath(String name);

    
    public abstract String[] databaseList();

    
        @Deprecated
public abstract Drawable getWallpaper();

    
        @Deprecated
public abstract Drawable peekWallpaper();

    
        @Deprecated
public abstract int getWallpaperDesiredMinimumWidth();

    
        @Deprecated
public abstract int getWallpaperDesiredMinimumHeight();

    
        @Deprecated
public abstract void setWallpaper(Bitmap bitmap) throws IOException;

    
        @Deprecated
public abstract void setWallpaper(InputStream data) throws IOException;

    
        @Deprecated
public abstract void clearWallpaper() throws IOException;

    
    public abstract void startActivity(Intent intent);

    
    public abstract void startActivities(Intent[] intents);

    
    public abstract void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException;

    
    public abstract void sendBroadcast(Intent intent);

    
    public abstract void sendBroadcast(Intent intent,
            String receiverPermission);

    
    public abstract void sendOrderedBroadcast(Intent intent,
            String receiverPermission);

    
    public abstract void sendOrderedBroadcast(Intent intent,
            String receiverPermission, BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras);

    
    public abstract void sendStickyBroadcast(Intent intent);

    
    public abstract void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver,
            Handler scheduler, int initialCode, String initialData,
            Bundle initialExtras);

    
    public abstract void removeStickyBroadcast(Intent intent);

    
    public abstract Intent registerReceiver(BroadcastReceiver receiver,
                                            IntentFilter filter);

    
    public abstract Intent registerReceiver(BroadcastReceiver receiver,
                                            IntentFilter filter,
                                            String broadcastPermission,
                                            Handler scheduler);

    
    public abstract void unregisterReceiver(BroadcastReceiver receiver);

    
    public abstract ComponentName startService(Intent service);

    
    public abstract boolean stopService(Intent service);

    
    public abstract boolean bindService(Intent service, ServiceConnection conn,
            int flags);

    
    public abstract void unbindService(ServiceConnection conn);

    
    public abstract boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments);

    
    public abstract Object getSystemService(String name);

    
    public abstract int checkPermission(String permission, int pid, int uid);

    
    public abstract int checkCallingPermission(String permission);

    
    public abstract int checkCallingOrSelfPermission(String permission);

    
    public abstract void enforcePermission(
            String permission, int pid, int uid, String message);

    
    public abstract void enforceCallingPermission(
            String permission, String message);

    
    public abstract void enforceCallingOrSelfPermission(
            String permission, String message);

    
    public abstract void grantUriPermission(String toPackage, Uri uri,
            int modeFlags);

    
    public abstract void revokeUriPermission(Uri uri, int modeFlags);

    
    public abstract int checkUriPermission(Uri uri, int pid, int uid, int modeFlags);

    
    public abstract int checkCallingUriPermission(Uri uri, int modeFlags);

    
    public abstract int checkCallingOrSelfUriPermission(Uri uri, int modeFlags);

    
    public abstract int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags);

    
    public abstract void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message);

    
    public abstract void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message);

    
    public abstract void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message);

    
    public abstract void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message);

    
    public abstract Context createPackageContext(String packageName,
            int flags) throws PackageManager.NameNotFoundException;

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:14:59.488 -0400", hash_original_method = "83D5E01B4EA95EAE9203A12A4E27AA18", hash_generated_method = "885FC8A229DB141CFA68087BA425E4A5")
    @DSModeled(DSC.SAFE)
    public boolean isRestricted() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
}


