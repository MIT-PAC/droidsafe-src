package android.test.mock;

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

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;




public class MockContext extends Context {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.098 -0400", hash_original_method = "3BD432D7D653C5930EE983B863B99E4B", hash_generated_method = "3BD432D7D653C5930EE983B863B99E4B")
    public MockContext ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.215 -0500", hash_original_method = "CF22466B77047295B0A90CFB1E700947", hash_generated_method = "E03BF0AAF559BC63F3B56F0638A041B9")
    
@Override
    public AssetManager getAssets() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.218 -0500", hash_original_method = "C54B5267A2D44CE04E49213C47F52259", hash_generated_method = "C91666E78C9B53E8D4B24F4D6046A163")
    
@Override
    public Resources getResources() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.220 -0500", hash_original_method = "E88041AF08BE295672677A7AE875FEFF", hash_generated_method = "2E1E29A48B4023A31C37FED49BAFD7D8")
    
@Override
    public PackageManager getPackageManager() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.222 -0500", hash_original_method = "61790CFAFC8BCC32869A9B01BEB1BF44", hash_generated_method = "2AF50723418B85B89BEE2FB071D8EE6A")
    
@Override
    public ContentResolver getContentResolver() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.225 -0500", hash_original_method = "962B8DEC28714F6FEBBFE04F24E90B9C", hash_generated_method = "09A1E7F848EEF88937B805EDD7AC12A9")
    
@Override
    public Looper getMainLooper() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.227 -0500", hash_original_method = "7D1710194777282B9AA7CA1905E51B18", hash_generated_method = "EB3EEE126D4E1BF756F5838FCA0FEE71")
    
@Override
    public Context getApplicationContext() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.230 -0500", hash_original_method = "060683B1D8FC90BB795699914548359D", hash_generated_method = "5D936399437A98CAC6BDF5659E8FF186")
    
@Override
    public void setTheme(int resid) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.232 -0500", hash_original_method = "D8312749B850F43C5A70B4ED63CC08E3", hash_generated_method = "A5391203951C100DB9FC27DFD9F66662")
    
@Override
    public Resources.Theme getTheme() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.234 -0500", hash_original_method = "C51DF920D125BDAE90130F458F1F9388", hash_generated_method = "0781404294A9A57943F7952BA3ACB860")
    
@Override
    public ClassLoader getClassLoader() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.236 -0500", hash_original_method = "6D0C58F8CBE63957D6DF922F2249B8C5", hash_generated_method = "F3D71F8DCF132B76BDB5C595DBA7F82F")
    
@Override
    public String getPackageName() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.239 -0500", hash_original_method = "6E8F7F76B2482C387134CAE0922B8764", hash_generated_method = "54D33EED58B055965257537B0468F26F")
    
@Override
    public ApplicationInfo getApplicationInfo() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.241 -0500", hash_original_method = "C89556570A09E26932F56B416A239F82", hash_generated_method = "F3532A37623FA7FA93B50EB0096428E7")
    
@Override
    public String getPackageResourcePath() {
        throw new UnsupportedOperationException();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.243 -0500", hash_original_method = "FA444114F9C54186D6D89E2CA249FBCF", hash_generated_method = "C2A2C27F9FA0D86D7DDD20091C5F9D41")
    
@Override
    public File getSharedPrefsFile(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.246 -0500", hash_original_method = "92AFBFFE30EEE36D5D46293F4B78E905", hash_generated_method = "1960BFF5D79B490327A9ED9F926F92C9")
    
@Override
    public String getPackageCodePath() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.248 -0500", hash_original_method = "7A0D76AB436CE8A39BBA6ED25153EABF", hash_generated_method = "5DBD7F1509E6EA7B5C3116E26BB34EC8")
    
@Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.250 -0500", hash_original_method = "6F9D455A12BE93D87BC450FB84CABAF4", hash_generated_method = "75FDCC350B3C70C607BB00DA986CB167")
    
@Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.252 -0500", hash_original_method = "06BE4C94ED3C4C2DFF4AC6484EAC8136", hash_generated_method = "8ADA13B1CE5CDBC84EC572AA404C0BB4")
    
@Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.255 -0500", hash_original_method = "52E0F39A74289A48663341DDCEF037DC", hash_generated_method = "4B739B0E44C2CB1E7ADF04E12D7CA77F")
    
@Override
    public boolean deleteFile(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.257 -0500", hash_original_method = "466D6BF0E43B95D4B6EB41E58C265707", hash_generated_method = "715B8BFFB59D2D22C3D92020B279FB21")
    
@Override
    public File getFileStreamPath(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.259 -0500", hash_original_method = "59F9DE1DC3F61B801C5281F9E3C6E2A4", hash_generated_method = "5EC66F0530A8F8A25C113AF89F930BAA")
    
@Override
    public String[] fileList() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.261 -0500", hash_original_method = "DBAC6A56B922EB1BA78CA1746FBB8CC3", hash_generated_method = "B5B5E63A9AEF4C35B29CAACE019D215A")
    
@Override
    public File getFilesDir() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.264 -0500", hash_original_method = "90C15C4E056A492114901C79423D8DCF", hash_generated_method = "8469ABAC51FDFFD8DF813EEC51D8D397")
    
@Override
    public File getExternalFilesDir(String type) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.266 -0500", hash_original_method = "702F9A452622032EC8233CE54867C377", hash_generated_method = "733D8115EFA026FDED449E6B8712E502")
    
@Override
    public File getObbDir() {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.268 -0500", hash_original_method = "FDF4A6103F9B59802F7D5E28BF5EFD3A", hash_generated_method = "8473B479C5705492BD200329240F0B48")
    
@Override
    public File getCacheDir() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.270 -0500", hash_original_method = "2A92DC096DA51370A1334577ECF09ECC", hash_generated_method = "4ADCAFED9ECD16FD5F95F9A5E5ABA9A2")
    
@Override
    public File getExternalCacheDir() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.273 -0500", hash_original_method = "34B447CE41C4ED84D6396B7E9780C31D", hash_generated_method = "606009A73CBAD882F2E37156E9564D48")
    
@Override
    public File getDir(String name, int mode) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.276 -0500", hash_original_method = "CD5FDC840DBA80E0D8DDF078BF714DEA", hash_generated_method = "CAA57A38A828E6C46EAAFF2BB3B77F0A")
    
@Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode, 
            SQLiteDatabase.CursorFactory factory) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.278 -0500", hash_original_method = "7939EB7F51D4EA520B25C26292DA454F", hash_generated_method = "6C5F4D1C8729A047988F1055CC75788F")
    
@Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode,
            SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.280 -0500", hash_original_method = "E48DC3F924F870943E4E36BC470CEAAB", hash_generated_method = "A531D5EC596D6798B7836CB3B26C0D52")
    
@Override
    public File getDatabasePath(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.282 -0500", hash_original_method = "B170F7706E5C42A003C64B941E6F02C3", hash_generated_method = "AAE478582CCA352F9051B35F864C6AAA")
    
@Override
    public String[] databaseList() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.284 -0500", hash_original_method = "F910F6C68A7FB093015261F7E1433E12", hash_generated_method = "2C367B9D1DCAFF0D97918577134FF4EC")
    
@Override
    public boolean deleteDatabase(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.286 -0500", hash_original_method = "B684586EF353D1CCAA3450E5FF9DC08F", hash_generated_method = "2CC54FECDC37BFC99173A58B7076AF24")
    
@Override
    public Drawable getWallpaper() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.288 -0500", hash_original_method = "30AAB697F190292EC6A7D3C51657B6D7", hash_generated_method = "22E053E6F264053E91039FF19236922C")
    
@Override
    public Drawable peekWallpaper() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.291 -0500", hash_original_method = "4F392818CCC81F3909BB8C9EA84C5ED2", hash_generated_method = "671CDA4D4A185C06E3CF450E2DB60E01")
    
@Override
    public int getWallpaperDesiredMinimumWidth() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.293 -0500", hash_original_method = "109D2D0B104293A4F52BC55EADD30F43", hash_generated_method = "B3EEA17D1A1CAD9FB5BA6CEC55BB25DF")
    
@Override
    public int getWallpaperDesiredMinimumHeight() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.296 -0500", hash_original_method = "13366CFA01CCB9E3D0D5A885A1E3BD82", hash_generated_method = "EE8DE9F94BDEFAD3AB16EA159D302B89")
    
@Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.298 -0500", hash_original_method = "72AC712F363F7774A80940CA93269479", hash_generated_method = "14C3F584DEDEC75B10A3789D108F29DE")
    
@Override
    public void setWallpaper(InputStream data) throws IOException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.300 -0500", hash_original_method = "6AFDDD74A00ECA2CECE35CA27A2C95A0", hash_generated_method = "BF84EC5CE2BEDCF8D12CE781982B0590")
    
@Override
    public void clearWallpaper() {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.303 -0500", hash_original_method = "10BBC39B201767C43F0FBBE296ABD273", hash_generated_method = "CCFE85678B34F377226A32E287A87E2A")
    
@Override
    public void startActivity(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.305 -0500", hash_original_method = "8A0FF876EE34DCD944B6E38C35E12478", hash_generated_method = "6885ED0EBB2AB9E46607CCF54F7B5495")
    
@Override
    public void startActivities(Intent[] intents) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.308 -0500", hash_original_method = "70A0DB323D66E33A5F118512F09625C8", hash_generated_method = "79E18361827D52876581523D79DE22C4")
    
@Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags)
            throws IntentSender.SendIntentException {
        throw new UnsupportedOperationException();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.310 -0500", hash_original_method = "7E1C16471170CAC5D2A8AEA7AFD07DD1", hash_generated_method = "411990A5E320BF8884DA331BEDA45421")
    
@Override
    public void sendBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.312 -0500", hash_original_method = "4C3B301BF0F66FC6027023D458D4F5CD", hash_generated_method = "CE8925D245F9AAC033275839738F2B60")
    
@Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.315 -0500", hash_original_method = "53C9E33F6F3BF762F0C7AD2D83F8B880", hash_generated_method = "1B58536F6357A3FD7FA43C2D44326430")
    
@Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.317 -0500", hash_original_method = "BD4D4F58A89D586949B717D061DAB18B", hash_generated_method = "DAAF65FE5B776D3490A590BD16EC0C00")
    
@Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.319 -0500", hash_original_method = "F1DE7775DB33185A5749E492B31FBC7D", hash_generated_method = "3A0E265181A05D7C068E99FFBB3BBF04")
    
@Override
    public void sendStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.322 -0500", hash_original_method = "282E4DE5B4B9DE490016C7174B108592", hash_generated_method = "1ABCEFD9637FF1B25952EF527AD8B44B")
    
@Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.324 -0500", hash_original_method = "171AE827F280EA82963EC0D862FF9728", hash_generated_method = "78CBC87F44BA9FB08EE4504A49571572")
    
@Override
    public void removeStickyBroadcast(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.326 -0500", hash_original_method = "0850381B9C1FC302FA99B7B33A5E73A3", hash_generated_method = "20FEE326E9EC11291737D000A5492A92")
    
@Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.328 -0500", hash_original_method = "38D46FC990EC0A671B9656203023C7E3", hash_generated_method = "C079D9B924C3B8C0203DB1CD98AC581E")
    
@Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.330 -0500", hash_original_method = "181E8EC9461ECBFDA8BFB6A0E30406B9", hash_generated_method = "C4FA8B405F9BFB4D2FEF84FFA02E0C17")
    
@Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.333 -0500", hash_original_method = "E1F1505B58131FB6B0B7748694608436", hash_generated_method = "A76FB78CF3469773EEC9E984B16592F0")
    
@Override
    public ComponentName startService(Intent service) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.335 -0500", hash_original_method = "6B730D00DB06298D95F2B7A23DAD395A", hash_generated_method = "7D61645C6CA4FC7347E9D8892F549B5A")
    
@Override
    public boolean stopService(Intent service) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.338 -0500", hash_original_method = "BFAA291B41512300628CDA2B72A00114", hash_generated_method = "2D7F6AD73B05923224A2C1CCA81A0713")
    
@Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.340 -0500", hash_original_method = "87503CB05E3F8FB5C16291E093E4FB05", hash_generated_method = "9C6D900682E24431B18A3EB5E4641D0C")
    
@Override
    public void unbindService(ServiceConnection conn) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.342 -0500", hash_original_method = "30A10D280B19E6882E6D642EC1CD4917", hash_generated_method = "C21FDBE177101D50EFCC13D514737AAA")
    
@Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.344 -0500", hash_original_method = "68E01286CFC0F57628C767DFD8F3DBC4", hash_generated_method = "D5E4E759CF5DD6771C57D05B806A45A0")
    
@Override
    public Object getSystemService(String name) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.347 -0500", hash_original_method = "FA0054E6225B3DA4E3AB5C60EE5617B0", hash_generated_method = "8710F7531FB5A2B801713A7B5D06B067")
    
@Override
    public int checkPermission(String permission, int pid, int uid) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.349 -0500", hash_original_method = "39E4CC67C115397A8C51691BDA0DEFFF", hash_generated_method = "453541B74F30F915B693D7735E084E4A")
    
@Override
    public int checkCallingPermission(String permission) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.352 -0500", hash_original_method = "5DC2D3BE454D628902BC654B11EC880D", hash_generated_method = "EB42E28832525D149CBA691270E578E8")
    
@Override
    public int checkCallingOrSelfPermission(String permission) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.354 -0500", hash_original_method = "56C405B921CD26186CE93AE4FCE77002", hash_generated_method = "2F41FD8228E04D9040BBAEAE9D6CD45E")
    
@Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.357 -0500", hash_original_method = "404869BFDC0DC9DF47C55A15B6DC4397", hash_generated_method = "62CFE74B41B523A65DDED0D7B4A9D4E7")
    
@Override
    public void enforceCallingPermission(String permission, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.359 -0500", hash_original_method = "DF4E179747318B1B15E40F55606A37E9", hash_generated_method = "95F04BB6F98EE23B4A54CABE5844996F")
    
@Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.361 -0500", hash_original_method = "CA3402270A11C945C3AA0E7919220352", hash_generated_method = "9D2A269B70768EB0E3EAEE92242B3A27")
    
@Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.363 -0500", hash_original_method = "A5567E6B8C539B68F363AE3EA825B3B1", hash_generated_method = "4660A080A2216796B43FB9A9DD77A06D")
    
@Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.366 -0500", hash_original_method = "01DA97890A1635A805E6ABA70EA7E1A2", hash_generated_method = "85D2AEDABBA52866F41080DEE82B0446")
    
@Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.368 -0500", hash_original_method = "0E91A21D8BB5EE13B32E9508DC980D04", hash_generated_method = "7659CBC71CCD843B17ED5815619D8C4F")
    
@Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.370 -0500", hash_original_method = "4E907F188543B6F68B290447CBA938FC", hash_generated_method = "958117006C962AD3830BE0B266ECB8C6")
    
@Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.372 -0500", hash_original_method = "10E5B81078B4D8C80FD1ADA81F59A293", hash_generated_method = "5EB077E4DF3EE7C02236F351CA407C94")
    
@Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.375 -0500", hash_original_method = "D6C517671FDE2208703A3C3A6D7AC623", hash_generated_method = "5C598FAAD4C0C6FF76963BCF174EA29F")
    
@Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.377 -0500", hash_original_method = "5404073C28217A8FED2D1029326FF0C1", hash_generated_method = "C30ED41B3A36EB3648EBAE7D81351421")
    
@Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.379 -0500", hash_original_method = "581596FE93D696843E16CDAA47A17F02", hash_generated_method = "7B081C6F955F1EF890E4ACF724D0A9F2")
    
@Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.382 -0500", hash_original_method = "3F20BE4E74327552B96137FD3F126AED", hash_generated_method = "1F1130537829A3C074EA7E59172184AB")
    
public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.384 -0500", hash_original_method = "0406DB1DB1C22587C63AD75F49E0CA3F", hash_generated_method = "62AC49B70B127099D5BE22619AB7561C")
    
@Override
    public Context createPackageContext(String packageName, int flags)
            throws PackageManager.NameNotFoundException {
        throw new UnsupportedOperationException();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:45.386 -0500", hash_original_method = "B79081A4CFC106615A2ECE230BC1B163", hash_generated_method = "1E51E7AC5158A6CE91DC532A8E791A2B")
    
@Override
    public boolean isRestricted() {
        throw new UnsupportedOperationException();        
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

