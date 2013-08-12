package android.content;

// Droidsafe Imports
import droidsafe.annotations.*;
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
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;



public class ContextWrapper extends Context {
    private Context mBase;
    
    @DSModeled(DSC.SAFE)
    public ContextWrapper(Context base) {
        mBase = base;
    }

    
    @DSModeled(DSC.SAFE)
    protected void attachBaseContext(Context base) {
        mBase = base;
    }

    
    @DSModeled(DSC.SAFE)
    public Context getBaseContext() {
        return mBase;
    }

    
    @Override
    @DSModeled(DSC.SPEC)
    public AssetManager getAssets() {
        return mBase.getAssets();
    }

    
    @Override
    @DSModeled(DSC.SPEC)
    public Resources getResources()
    {
        return mBase.getResources();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public PackageManager getPackageManager() {
        return mBase.getPackageManager();
    }

    
    @Override
    @DSModeled(DSC.SPEC)
    public ContentResolver getContentResolver() {
    	return mBase.getContentResolver();
    }

    
    @Override
    public Looper getMainLooper() {
        return mBase.getMainLooper();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public Context getApplicationContext() {
        return mBase.getApplicationContext();
    }

    
    @Override
    public void setTheme(int resid) {
        mBase.setTheme(resid);
    }

    
    @DSModeled(DSC.BAN)
    @Override
    public int getThemeResId() {
        return mBase.getThemeResId();
    }

    
    @Override
    public Resources.Theme getTheme() {
        return mBase.getTheme();
    }

    
    @DSModeled(DSC.BAN)
    @Override
    public ClassLoader getClassLoader() {
        return mBase.getClassLoader();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public String getPackageName() {
        return mBase.getPackageName();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public ApplicationInfo getApplicationInfo() {
        return mBase.getApplicationInfo();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public String getPackageResourcePath() {
        return mBase.getPackageResourcePath();
    }

    
    @Override
    public String getPackageCodePath() {
        return mBase.getPackageCodePath();
    }

    
    @DSModeled(DSC.BAN)
    @Override
    public File getSharedPrefsFile(String name) {
        return mBase.getSharedPrefsFile(name);
    }

    
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        return mBase.getSharedPreferences(name, mode);
    }

    
    @Override
    public FileInputStream openFileInput(String name)
        throws FileNotFoundException {
        return mBase.openFileInput(name);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public FileOutputStream openFileOutput(String name, int mode)
        throws FileNotFoundException {
        return mBase.openFileOutput(name, mode);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public boolean deleteFile(String name) {
        return mBase.deleteFile(name);
    }

    
    @Override
    public File getFileStreamPath(String name) {
        return mBase.getFileStreamPath(name);
    }

    
    @Override
    public String[] fileList() {
        return mBase.fileList();
    }

    
    @Override
    public File getFilesDir() {
        return mBase.getFilesDir();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public File getExternalFilesDir(String type) {
        return mBase.getExternalFilesDir(type);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public File getObbDir() {
        return mBase.getObbDir();
    }

    
    @Override
    public File getCacheDir() {
        return mBase.getCacheDir();
    }

    
    @Override
    public File getExternalCacheDir() {
        return mBase.getExternalCacheDir();
    }

    
    @Override
    public File getDir(String name, int mode) {
        return mBase.getDir(name, mode);
    }

    
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return mBase.openOrCreateDatabase(name, mode, factory);
    }

    
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public boolean deleteDatabase(String name) {
        return mBase.deleteDatabase(name);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public File getDatabasePath(String name) {
        return mBase.getDatabasePath(name);
    }

    
    @Override
    public String[] databaseList() {
        return mBase.databaseList();
    }

    
    @Override
    public Drawable getWallpaper() {
        return mBase.getWallpaper();
    }

    
    @Override
    public Drawable peekWallpaper() {
        return mBase.peekWallpaper();
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        return mBase.getWallpaperDesiredMinimumWidth();
    }

    
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        return mBase.getWallpaperDesiredMinimumHeight();
    }

    
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
    }

    
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        mBase.setWallpaper(data);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
    }

    
    @Override
    public void startActivities(Intent[] intents) {
        mBase.startActivities(intents);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException {
        mBase.startIntentSender(intent, fillInIntent, flagsMask,
                flagsValues, extraFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mBase.sendBroadcast(intent, receiverPermission);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(
        Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendOrderedBroadcast(intent, receiverPermission,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyOrderedBroadcast(
        Intent intent, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendStickyOrderedBroadcast(intent,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
    	receiver.onReceive(this, new Intent());
    	return null; // no 'sticky' intents need to be modeled for coverage
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        return mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
    }

    
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mBase.unregisterReceiver(receiver);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public ComponentName startService(Intent service) {
        return mBase.startService(service);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public boolean stopService(Intent name) {
        return mBase.stopService(name);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        return mBase.bindService(service, conn, flags);
    }

    
    @Override
    public void unbindService(ServiceConnection conn) {
        mBase.unbindService(conn);
    }

    
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        return mBase.startInstrumentation(className, profileFile, arguments);
    }

    
    @Override
    @DSModeled(DSC.SAFE)
    public Object getSystemService(String name) {
        return mBase.getSystemService(name);
    }

    
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        return mBase.checkPermission(permission, pid, uid);
    }

    
    @Override
    public int checkCallingPermission(String permission) {
        return mBase.checkCallingPermission(permission);
    }

    
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        return mBase.checkCallingOrSelfPermission(permission);
    }

    
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        mBase.enforcePermission(permission, pid, uid, message);
    }

    
    @Override
    public void enforceCallingPermission(String permission, String message) {
        mBase.enforceCallingPermission(permission, message);
    }

    
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        mBase.enforceCallingOrSelfPermission(permission, message);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mBase.revokeUriPermission(uri, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        return mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(
                uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public Context createPackageContext(String packageName, int flags)
        throws PackageManager.NameNotFoundException {
        return mBase.createPackageContext(packageName, flags);
    }

    
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isRestricted() {
        return mBase.isRestricted();
    }

    
}

