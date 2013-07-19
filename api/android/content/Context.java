package android.content;

// Droidsafe Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Context {
    
@DSModeled(value = DSC.SAFE)
	public Context() {
		//Do Nothing
	}
    public abstract AssetManager getAssets();

    
    public abstract Resources getResources();

    
    public abstract PackageManager getPackageManager();

    
    public abstract ContentResolver getContentResolver();

    
    public abstract Looper getMainLooper();

    
    public abstract Context getApplicationContext();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.168 -0400", hash_original_method = "CA41FDFA6BB6EC9A7DA4C7864F293E89", hash_generated_method = "3008EBB7509B4364ED9CD0494D11106A")
    public void registerComponentCallbacks(ComponentCallbacks callback) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(callback.getTaint());
        getApplicationContext().registerComponentCallbacks(callback);
        // ---------- Original Method ----------
        //getApplicationContext().registerComponentCallbacks(callback);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.169 -0400", hash_original_method = "494D7366CDA5CBFD506341B295742C11", hash_generated_method = "9CB911A537DB635A7DF54F100ABF2CE0")
    public void unregisterComponentCallbacks(ComponentCallbacks callback) {
        addTaint(callback.getTaint());
        getApplicationContext().unregisterComponentCallbacks(callback);
        // ---------- Original Method ----------
        //getApplicationContext().unregisterComponentCallbacks(callback);
    }

    
    public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
		/*
		 * No need to model the Resources class at this time.  The underlying
		 * implementation calls down into AssetManager and simply supplies a
		 * string value.  If more items utilize Resources or AssetManager we
		 * may need to model those classes.  For now this will suffice.
		 */
        //return getResources().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.170 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "93D787D10019EB3C184F3D4409EE8F88")
    public final String getString(int resId) {
        addTaint(resId);
String varE43003255E2CDFE3A3F854C99DB3C345_1254485630 =         getResources().getString(resId);
        varE43003255E2CDFE3A3F854C99DB3C345_1254485630.addTaint(taint);
        return varE43003255E2CDFE3A3F854C99DB3C345_1254485630;
        // ---------- Original Method ----------
        //return getResources().getString(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.170 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "DD7F718E38B10AE9B4A5A4A828CAE4E2")
    public final String getString(int resId, Object... formatArgs) {
        addTaint(formatArgs[0].getTaint());
        addTaint(resId);
String var3E6B52F63767621631F101D027EAE3AD_1525639224 =         getResources().getString(resId, formatArgs);
        var3E6B52F63767621631F101D027EAE3AD_1525639224.addTaint(taint);
        return var3E6B52F63767621631F101D027EAE3AD_1525639224;
        // ---------- Original Method ----------
        //return getResources().getString(resId, formatArgs);
    }

    
    public abstract void setTheme(int resid);

    
    public int getThemeResId() {
        return 0;
    }

    
    public abstract Resources.Theme getTheme();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.171 -0400", hash_original_method = "FF26021DC793B4DE3C0383ED66D7E1E8", hash_generated_method = "166458EACA124EA043102713E83AA2DB")
    public final TypedArray obtainStyledAttributes(
            int[] attrs) {
        addTaint(attrs[0]);
TypedArray var8958D93D46F775F5FEC57E8183C97240_1475138592 =         getTheme().obtainStyledAttributes(attrs);
        var8958D93D46F775F5FEC57E8183C97240_1475138592.addTaint(taint);
        return var8958D93D46F775F5FEC57E8183C97240_1475138592;
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(attrs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.171 -0400", hash_original_method = "C05CBF641E41D370531BE7FED84BE5CE", hash_generated_method = "DC0CF47D3EBED8808E361F65519DE5D0")
    public final TypedArray obtainStyledAttributes(
            int resid, int[] attrs) throws Resources.NotFoundException {
        addTaint(attrs[0]);
        addTaint(resid);
TypedArray var6CAC1D2E58E1F85B1471C7C1B3216D41_1460331081 =         getTheme().obtainStyledAttributes(resid, attrs);
        var6CAC1D2E58E1F85B1471C7C1B3216D41_1460331081.addTaint(taint);
        return var6CAC1D2E58E1F85B1471C7C1B3216D41_1460331081;
        // ---------- Original Method ----------
        //return getTheme().obtainStyledAttributes(resid, attrs);
    }

    
    public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs) {
        return getTheme().obtainStyledAttributes(set, attrs, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.172 -0400", hash_original_method = "23F3A3F4901D9D1C9DD21EEAA884561D", hash_generated_method = "DFC3C32938C72A16758D350507A81749")
    public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs, int defStyleAttr, int defStyleRes) {
        addTaint(defStyleRes);
        addTaint(defStyleAttr);
        addTaint(attrs[0]);
        addTaint(set.getTaint());
TypedArray var06BFBDC52929A707387ABF18809CD1B9_1783689107 =         getTheme().obtainStyledAttributes(
            set, attrs, defStyleAttr, defStyleRes);
        var06BFBDC52929A707387ABF18809CD1B9_1783689107.addTaint(taint);
        return var06BFBDC52929A707387ABF18809CD1B9_1783689107;
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

    
    public boolean isRestricted() {
        return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "EE3A09F6819CC598B5421959E5F2BB90", hash_generated_field = "E0534FAE410858BE0239A90CB81A3C3C")

    public static final int MODE_PRIVATE = 0x0000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "C85DC913DE2B5A5BD0D5D882CA7358B2", hash_generated_field = "C00A6D34EDBF9E60AF33C96D65B15E93")

    public static final int MODE_WORLD_READABLE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "66E0BA87575F3DEFD3FFF5917194B86A", hash_generated_field = "61F4EE1E1FDEEECA23996E2131E557AF")

    public static final int MODE_WORLD_WRITEABLE = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "C8F5CAA2C296624360EC47BB5550FB19", hash_generated_field = "A1D4701EDB7C2CF32DB6D704DB64F158")

    public static final int MODE_APPEND = 0x8000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "C1F8467DEE34CA624771923F4EA750FC", hash_generated_field = "8D32186E1C1FBA644B75AB8D6BD319D0")

    public static final int MODE_MULTI_PROCESS = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "511A3BBBC194AD8B3889A68ADAA492DD", hash_generated_field = "3F719DF33B5D38DBF9EDA5459690E1E3")

    public static final int BIND_AUTO_CREATE = 0x0001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "B42237B6679F096BE298E4A17BD9367D", hash_generated_field = "95934930F85186A3FEB58D687D9B608A")

    public static final int BIND_DEBUG_UNBIND = 0x0002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "FA4FB299AB4E1F82D0C15A35A3842B31", hash_generated_field = "0C5F5CEFA5733E1C296DEE1B15C8D39A")

    public static final int BIND_NOT_FOREGROUND = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.186 -0400", hash_original_field = "A6381EBEB40060C0DE8E15CDB996274A", hash_generated_field = "8D5736F032682672BB446A94C97B4AB9")

    public static final int BIND_ABOVE_CLIENT = 0x0008;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "00E89529E284172847FFC747F71C92E0", hash_generated_field = "7BB1BA1A9DEA67D07B6CE17297E5641E")

    public static final int BIND_ALLOW_OOM_MANAGEMENT = 0x0010;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "72C0AB8FBB6970390EFB8716E31B3093", hash_generated_field = "2656EBD430F847F35F9423E52425B3EA")

    public static final int BIND_WAIVE_PRIORITY = 0x0020;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "22D29B5EA8ED4937B0462C2009C114B9", hash_generated_field = "9CFD13BAA284CD7299FCD1B7145F9D86")

    public static final int BIND_IMPORTANT = 0x0040;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "5537FC5DA42954FFF30CFD153A8C73F8", hash_generated_field = "7AACFEB8F1B496D355C0E0064BF3AB29")

    public static final int BIND_ADJUST_WITH_ACTIVITY = 0x0080;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "15D23573541D5212ED7F356435FAF4A5", hash_generated_field = "36952676B0F348321AD0B80A350F64B3")

    public static final int BIND_NOT_VISIBLE = 0x40000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.187 -0400", hash_original_field = "1DBBBED9A2557579138D603694E08323", hash_generated_field = "E8416ECCEA5BEAC114B2264DD2931CB7")

    public static final String POWER_SERVICE = "power";
    public static final String WINDOW_SERVICE = "window";
    public static final String LAYOUT_INFLATER_SERVICE = "layout_inflater";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "016E11449440B8F6E66E9277112C7F43", hash_generated_field = "C0101BF00244F413D0C290959C084A6C")

    public static final String ACCOUNT_SERVICE = "account";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "722A5A432F2FAA2B0AA60FC489E5B4A4", hash_generated_field = "8BB3D3D67FF9811DEABA28412034BF1F")

    public static final String ACTIVITY_SERVICE = "activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "1B48C4A394C0AAF7C72D6919C76176E3", hash_generated_field = "E5AF97C7B0EB125B7B2BD44F6B682371")

    public static final String ALARM_SERVICE = "alarm";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "D44D09A257EB53015C67A8653C65FFDB", hash_generated_field = "EE887814E737E14F594C651614CE16DF")

    public static final String NOTIFICATION_SERVICE = "notification";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "6E4E72E3D411A823E902B1D97AAC1314", hash_generated_field = "C6CE03AB8349C616824A7FCE6CC045BF")

    public static final String ACCESSIBILITY_SERVICE = "accessibility";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "4A85F035BE9729345A4D0751514E5A00", hash_generated_field = "A2124D9C2882A3B61AA3F18DE08940F6")

    public static final String KEYGUARD_SERVICE = "keyguard";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "FB5D68E080CE455AC4359C5D3B547C22", hash_generated_field = "0A2D92FCA78EDAD178265457397CBFBB")

    public static final String LOCATION_SERVICE = "location";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.193 -0400", hash_original_field = "EC57C197C953FFFA94ACD0FFA885655F", hash_generated_field = "3E584B95026E0B9C77A1D4775A4F38F1")

    public static final String COUNTRY_DETECTOR = "country_detector";
    public static final String SEARCH_SERVICE = "search";
    public static final String SENSOR_SERVICE = "sensor";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "439A23EE61117F50F7C17049ABEB9FB3", hash_generated_field = "683D409858DB0534C1F3F8C1B86A84ED")

    public static final String STORAGE_SERVICE = "storage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "4ED7A6D43C9F7EE9E393150777CAF8C1", hash_generated_field = "4AC7C0CE09AEC0002A651C7949FB84DC")

    public static final String WALLPAPER_SERVICE = "wallpaper";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "591F6CD3BA46F4ED52AEBC7A4A7F9857", hash_generated_field = "39726A4B89909A265FD047CC4D56AEB8")

    public static final String VIBRATOR_SERVICE = "vibrator";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "C656CB2209C42F859B5CC5DD786FB58C", hash_generated_field = "DACE3B8B9B06D14717640DFBD64CB027")

    public static final String STATUS_BAR_SERVICE = "statusbar";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "12B7531B728145C85A35A7180A68E99A", hash_generated_field = "2F45F5AD93952D9D29432D95F2452092")

    public static final String CONNECTIVITY_SERVICE = "connectivity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "6F81AD1F65814352D628BD20FE8F47FD", hash_generated_field = "3AD0A3355544924E513A0BC3052EFC4B")

    public static final String THROTTLE_SERVICE = "throttle";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "D70D79EF531BBB793515711071851138", hash_generated_field = "A450F3546D814B85E8397541C578F3CF")

    public static final String NETWORKMANAGEMENT_SERVICE = "network_management";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "E26D31D78994A6F9F0C616B0D579EFDD", hash_generated_field = "454E71FC4584A535C801D683C68A25ED")

    public static final String NETWORK_STATS_SERVICE = "netstats";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "0E50C770CF83A51E2F6296BECBF63C1B", hash_generated_field = "5A58323C773F04B7B62244D04564F5D5")

    public static final String NETWORK_POLICY_SERVICE = "netpolicy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.194 -0400", hash_original_field = "101B18186FC896AFCA79C32690C31D9A", hash_generated_field = "99A842CA1318F2E11F6BE58707AB118F")

    public static final String WIFI_SERVICE = "wifi";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "DF41D1B4B22A81186A39BA2CA32FF674", hash_generated_field = "C3BF0421487E50A24AE2947C35E56E7D")

    public static final String WIFI_P2P_SERVICE = "wifip2p";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "960019DB6DBB633C43E70FCD1007B199", hash_generated_field = "F28252FD322AD74524DADB8BBEF2D288")

    public static final String AUDIO_SERVICE = "audio";
    public static final String TELEPHONY_SERVICE = "phone";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "50512C453197D293569CD554E80A2585", hash_generated_field = "1A766B47E950410C3F30F8C050ED10B5")

    public static final String CLIPBOARD_SERVICE = "clipboard";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "7E6E4F0F30199FAAAB1FA0D05C488E0D", hash_generated_field = "86CBA0398F780670874BEBBE962A4234")

    public static final String INPUT_METHOD_SERVICE = "input_method";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "1CA2ADA58212A824A9486C9E73574339", hash_generated_field = "3D0F48743A480272F049F93E42ADFD28")

    public static final String TEXT_SERVICES_MANAGER_SERVICE = "textservices";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "537F5C822942042D25FE4186BF67E3B4", hash_generated_field = "532AB440378B09C3B6064E442DF5F1B7")

    public static final String APPWIDGET_SERVICE = "appwidget";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "772E8D9AD519D7EBDB13C5D8C2D2EBF1", hash_generated_field = "FA86164719D55F0E711FE6BC871180E8")

    public static final String BACKUP_SERVICE = "backup";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "D7D533EC55FED163C83F28E872C0BED2", hash_generated_field = "DB9BF2C988EFDA8B74A602487DB98892")

    public static final String DROPBOX_SERVICE = "dropbox";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.195 -0400", hash_original_field = "750BF3B3D7E9E40DB6C54C456F54591E", hash_generated_field = "A27547CDFB697E9207929038781E5413")

    public static final String DEVICE_POLICY_SERVICE = "device_policy";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "F1BBC83E5AE98C1495767DFFB32E707F", hash_generated_field = "093487E6D98CF2E55BA893689E4AD09D")

    public static final String UI_MODE_SERVICE = "uimode";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "87834A265F5B54B889ED8A59DC33B308", hash_generated_field = "2878DC56FA5E2F9F330CB8BDE2ACF22A")

    public static final String DOWNLOAD_SERVICE = "download";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "46DE9B9B0119F3C41C41932D34B77444", hash_generated_field = "5831D684985AAEA831FADFDAE47A65F0")

    public static final String NFC_SERVICE = "nfc";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "B9C452CADD447848AB9A045AF22933C6", hash_generated_field = "D9F0F18B748BD6BA7A9AFD8C772ABF66")

    public static final String SIP_SERVICE = "sip";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "DB62E914E38E146E9C0E5043999BF1E4", hash_generated_field = "8067BA11AD1BFB38AB9ECD2EA5D0F04C")

    public static final String USB_SERVICE = "usb";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "A6BB1D776374328BEF5E4C2A40944D02", hash_generated_field = "2531CFB911E7B5DA453B0D35880BAB90")

    public static final int CONTEXT_INCLUDE_CODE = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "7F4D86CAD1E471178743FCA5B8FF17C3", hash_generated_field = "EA43A38A5281FECBBE69A8378CDA10EC")

    public static final int CONTEXT_IGNORE_SECURITY = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:39.196 -0400", hash_original_field = "7DC790C99BBEE323442B39F8FB05BAC0", hash_generated_field = "F3D4B86861C416E9BCDD00F4D43AA6B2")

    public static final int CONTEXT_RESTRICTED = 0x00000004;
}

