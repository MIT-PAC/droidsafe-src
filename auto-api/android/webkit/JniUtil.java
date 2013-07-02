package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.InputStream;

class JniUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.978 -0400", hash_original_method = "7797423382E6C41F3BC6877796CBF278", hash_generated_method = "7AE97D3B4E9D45C2A019FC4E29ED6E30")
    private  JniUtil() {
        
    }

    
    private static void checkInitialized() {
        if (sContext == null) {
            throw new IllegalStateException("Call CookieSyncManager::createInstance() or create a webview before using this class");
        }
    }

    
    protected static synchronized void setContext(Context context) {
        if (sContext != null) {
            return;
        }
        sContext = context.getApplicationContext();
    }

    
    protected static synchronized Context getContext() {
        return sContext;
    }

    
    @DSModeled(DSC.SAFE)
    private static synchronized String getDatabaseDirectory() {
        checkInitialized();
        if (sDatabaseDirectory == null) {
            sDatabaseDirectory = sContext.getDatabasePath("dummy").getParent();
        }
        return sDatabaseDirectory;
    }

    
    @DSModeled(DSC.SAFE)
    private static synchronized String getCacheDirectory() {
        checkInitialized();
        if (sCacheDirectory == null) {
            File cacheDir = sContext.getCacheDir();
            if (cacheDir == null) {
                sCacheDirectory = "";
            } else {
                sCacheDirectory = cacheDir.getAbsolutePath();
            }
        }
        return sCacheDirectory;
    }

    
    @DSModeled(DSC.SAFE)
    private static synchronized long contentUrlSize(String url) {
        if (url.startsWith(ANDROID_CONTENT)) {
            try {
                int mimeIndex = url.lastIndexOf('?');
                if (mimeIndex != -1) {
                    url = url.substring(0, mimeIndex);
                }
                Uri uri = Uri.parse(url);
                InputStream is = sContext.getContentResolver().openInputStream(uri);
                byte[] buffer = new byte[1024];
                int n;
                long size = 0;
                try {
                    while ((n = is.read(buffer)) != -1) {
                        size += n;
                    }
                } finally {
                    is.close();
                }
                return size;
            } catch (Exception e) {
                Log.e(LOGTAG, "Exception: " + url);
                return 0;
            }
        } else {
            return 0;
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static synchronized InputStream contentUrlStream(String url) {
        if (url.startsWith(ANDROID_CONTENT)) {
            try {
                int mimeIndex = url.lastIndexOf('?');
                if (mimeIndex != -1) {
                    url = url.substring(0, mimeIndex);
                }
                Uri uri = Uri.parse(url);
                return sContext.getContentResolver().openInputStream(uri);
            } catch (Exception e) {
                Log.e(LOGTAG, "Exception: " + url);
                return null;
            }
        } else {
            return null;
        }
    }

    
    @DSModeled(DSC.SAFE)
    static boolean useChromiumHttpStack() {
        if (sUseChromiumHttpStack == null) {
            sUseChromiumHttpStack = nativeUseChromiumHttpStack();
        }
        return sUseChromiumHttpStack;
    }

    
    @DSModeled(DSC.SAFE)
    private static synchronized String getAutofillQueryUrl() {
        checkInitialized();
        return Settings.Secure.getString(sContext.getContentResolver(),
                Settings.Secure.WEB_AUTOFILL_QUERY_URL);
    }

    
    @DSModeled(DSC.SPEC)
    private static boolean canSatisfyMemoryAllocation(long bytesRequested) {
        checkInitialized();
        ActivityManager manager = (ActivityManager) sContext.getSystemService(
                Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        manager.getMemoryInfo(memInfo);
        long leftToAllocate = memInfo.availMem - memInfo.threshold;
        return !memInfo.lowMemory && bytesRequested < leftToAllocate;
    }

    
    private static boolean nativeUseChromiumHttpStack() {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    static {
        System.loadLibrary("webcore");
        System.loadLibrary("chromium_net");
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "9722F24E24D81405093C0E61AAF58518", hash_generated_field = "061362C112C980EB4954480FBAFBE378")

    private static final String LOGTAG = "webkit";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "9F41E2A2111E17B86E8301697492E815", hash_generated_field = "A4A53CA8C28F62D26FE2409BADC0B526")

    private static String sDatabaseDirectory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "11D1C8A26F33DBA2AEB52B140094ED4A", hash_generated_field = "AF7392F9E0B86779E1955C31E6B8D8D2")

    private static String sCacheDirectory;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "7AAC7F2579E0B191B09759E6D211DECB", hash_generated_field = "075B7A0020C230CE0B114CFAF022DB3C")

    private static Boolean sUseChromiumHttpStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "85E80EF1450B10017E4C79B6BDDE7990", hash_generated_field = "BB35128711B5DD286691A47454B04C39")

    private static Context sContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.981 -0400", hash_original_field = "B950BCE07884C5BEABDBDD558FFA0C5E", hash_generated_field = "A5A05B8DD281F40CCF47CBF0390B00E3")

    private static final String ANDROID_CONTENT = "content:";
}

