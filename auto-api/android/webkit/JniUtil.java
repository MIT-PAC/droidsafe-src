package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;
import java.io.File;
import java.io.InputStream;

class JniUtil {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.436 -0400", hash_original_method = "7797423382E6C41F3BC6877796CBF278", hash_generated_method = "7AE97D3B4E9D45C2A019FC4E29ED6E30")
    @DSModeled(DSC.SAFE)
    private JniUtil() {
        // ---------- Original Method ----------
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

    
        private static synchronized String getDatabaseDirectory() {
        checkInitialized();
        if (sDatabaseDirectory == null) {
            sDatabaseDirectory = sContext.getDatabasePath("dummy").getParent();
        }
        return sDatabaseDirectory;
    }

    
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

    
        static boolean useChromiumHttpStack() {
        if (sUseChromiumHttpStack == null) {
            sUseChromiumHttpStack = nativeUseChromiumHttpStack();
        }
        return sUseChromiumHttpStack;
    }

    
        private static synchronized String getAutofillQueryUrl() {
        checkInitialized();
        return Settings.Secure.getString(sContext.getContentResolver(),
                Settings.Secure.WEB_AUTOFILL_QUERY_URL);
    }

    
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
    
    private static final String LOGTAG = "webkit";
    private static String sDatabaseDirectory;
    private static String sCacheDirectory;
    private static Boolean sUseChromiumHttpStack;
    private static Context sContext;
    private static final String ANDROID_CONTENT = "content:";
}

