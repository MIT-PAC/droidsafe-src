package android.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

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
import droidsafe.annotations.DSModeled;

public abstract class Context {
	
	public static final String WINDOW_SERVICE = "window";
	public static final String SEARCH_SERVICE = "search";
	public static final String LAYOUT_INFLATER_SERVICE = "layout_inflater";
	public static final String SENSOR_SERVICE = "sensor";
    public static final String TELEPHONY_SERVICE = "phone";

	
	/* Concrete Methods */
    @DSModeled(DSC.SAFE)
	public boolean isRestricted() {
        return false;
    }
	
	@DSModeled(value = DSC.SAFE)
	public int getThemeResId() {
        return 0;
    }
	
	@DSModeled(DSC.SAFE)
	public final String getString(int resId) {
		String str = new String();
        str.addTaint(resId);
        return str;
	}
	
	@DSModeled(DSC.SAFE)
	public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Context() {
		//Do Nothing
	}
	
	@DSModeled(DSC.SAFE)
	public final TypedArray obtainStyledAttributes(
            AttributeSet set, int[] attrs) {
        return getTheme().obtainStyledAttributes(set, attrs, 0, 0);
    }
	
	
	
	/* Abstract Methods */
	public abstract Object getSystemService(String name);
	public abstract boolean bindService(Intent service, ServiceConnection conn,
            int flags);
	public abstract AssetManager getAssets();
	public abstract Resources getResources();
	public abstract PackageManager getPackageManager();
	public abstract ContentResolver getContentResolver();
	public abstract Looper getMainLooper();
	public abstract Context getApplicationContext();
	public abstract void setTheme(int resid);
	public abstract Resources.Theme getTheme();
	public abstract ClassLoader getClassLoader();
	public abstract String getPackageName();
	public abstract ApplicationInfo getApplicationInfo();
	public abstract String getPackageResourcePath();
	public abstract File getSharedPrefsFile(String name);
	public abstract String getPackageCodePath();
	public abstract SharedPreferences getSharedPreferences(String name,
            int mode);
	public abstract FileInputStream openFileInput(String name)
	        throws FileNotFoundException;
	public abstract FileOutputStream openFileOutput(String name, int mode)
	        throws FileNotFoundException;
	public abstract boolean deleteFile(String name);
	public abstract File getFileStreamPath(String name);
	public abstract String[] fileList();
	public abstract File getFilesDir();
	public abstract File getExternalFilesDir(String type);
	public abstract File getObbDir();
	public abstract File getCacheDir();
	public abstract File getExternalCacheDir();
	public abstract File getDir(String name, int mode);
	public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory);
	public abstract SQLiteDatabase openOrCreateDatabase(String name,
            int mode, CursorFactory factory, DatabaseErrorHandler errorHandler);
	public abstract File getDatabasePath(String name);
	public abstract String[] databaseList();
	public abstract boolean deleteDatabase(String name);
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
	public abstract void unbindService(ServiceConnection conn);
	public abstract boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments);
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
	public abstract void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message);
	public abstract void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message);
	public abstract void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message);
	public abstract Context createPackageContext(String packageName,
            int flags) throws PackageManager.NameNotFoundException;
	
	/* Deprecated methods */
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
	
	// Hook to match with value analsysis
	public Set<IntentFilter> __ds__intentFilters = new HashSet<IntentFilter>();

	// We pull out IntentFilters out of xml and register them with the appropriate subclasses of Context here 
	public void __ds__registerIntentFilter(IntentFilter intentFilter) {
		this.__ds__intentFilters.add(intentFilter);
	}
}
