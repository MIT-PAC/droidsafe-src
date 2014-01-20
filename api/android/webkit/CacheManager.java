package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.net.http.Headers;
import android.os.FileUtils;
import android.util.Log;

import com.android.org.bouncycastle.crypto.Digest;
import com.android.org.bouncycastle.crypto.digests.SHA1Digest;

public final class CacheManager {

    /**
     * Initialize the CacheManager.
     *
     * Note that this is called automatically when a {@link android.webkit.WebView} is created.
     *
     * @param context The application context.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.008 -0500", hash_original_method = "FD0A44038543D4B071B714911C2F38E6", hash_generated_method = "35AE2BCA55738371B7CE0EA20089509D")
    
static void init(Context context) {
        if (JniUtil.useChromiumHttpStack()) {
            // This isn't actually where the real cache lives, but where we put files for the
            // purpose of getCacheFile().
            mBaseDir = new File(context.getCacheDir(), "webviewCacheChromiumStaging");
            if (!mBaseDir.exists()) {
                mBaseDir.mkdirs();
            }
            return;
        }

        mDataBase = WebViewDatabase.getInstance(context.getApplicationContext());
        mBaseDir = new File(context.getCacheDir(), "webviewCache");
        if (createCacheDirectory() && mClearCacheOnInit) {
            removeAllCacheFiles();
            mClearCacheOnInit = false;
        }
    }

    /**
     * Create the cache directory if it does not already exist.
     *
     * @return true if the cache directory didn't exist and was created.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.011 -0500", hash_original_method = "39AF7BF095F0C2B1607F33D11417DF97", hash_generated_method = "F376D4A493B2A43313AC5AD7B7320ED8")
    
static private boolean createCacheDirectory() {
        assert !JniUtil.useChromiumHttpStack();

        if (!mBaseDir.exists()) {
            if(!mBaseDir.mkdirs()) {
                Log.w(LOGTAG, "Unable to create webviewCache directory");
                return false;
            }
            FileUtils.setPermissions(
                    mBaseDir.toString(),
                    FileUtils.S_IRWXU | FileUtils.S_IRWXG,
                    -1, -1);
            // If we did create the directory, we need to flush
            // the cache database. The directory could be recreated
            // because the system flushed all the data/cache directories
            // to free up disk space.
            // delete rows in the cache database
            WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CLEAR_CACHE);
            return true;
        }
        return false;
    }

    /**
     * Get the base directory of the cache. Together with the local path of the CacheResult,
     * obtained from {@link android.webkit.CacheManager.CacheResult#getLocalPath}, this
     * identifies the cache file.
     *
     * Cache files are not guaranteed to be in this directory before
     * CacheManager#getCacheFile(String, Map<String, String>) is called.
     *
     * @return File The base directory of the cache.
     *
     * @deprecated Access to the HTTP cache will be removed in a future release.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.014 -0500", hash_original_method = "F0B0827516949949C11BBC015D95A105", hash_generated_method = "38AC16CFBD9C5FA36401E7D47C89A1CA")
    
@Deprecated
    public static File getCacheFileBaseDir() {
        return mBaseDir;
    }

    /**
     * Sets whether the cache is disabled.
     *
     * @param disabled Whether the cache should be disabled
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.016 -0500", hash_original_method = "15A04C0B3B55BED81D42B45C3530CD7B", hash_generated_method = "B5DD7A823CC11E052351146D788A64DE")
    
static void setCacheDisabled(boolean disabled) {
        assert !JniUtil.useChromiumHttpStack();

        if (disabled == mDisabled) {
            return;
        }
        mDisabled = disabled;
        if (mDisabled) {
            removeAllCacheFiles();
        }
    }

    /**
     * Whether the cache is disabled.
     *
     * @return return Whether the cache is disabled
     *
     * @deprecated Access to the HTTP cache will be removed in a future release.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.018 -0500", hash_original_method = "70B1862B4F6250E0DD71D86C1C84F44C", hash_generated_method = "A3DE51B2043BB8B2898D278AD98EF725")
    
@Deprecated
    public static boolean cacheDisabled() {
        return mDisabled;
    }

    // only called from WebViewWorkerThread
    // make sure to call enableTransaction/disableTransaction in pair
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.021 -0500", hash_original_method = "953C900A9DBD3B15E27F74DCB29F2A3F", hash_generated_method = "4A49FA9A6979EE8FDC70C3F4922446F1")
    
static boolean enableTransaction() {
        assert !JniUtil.useChromiumHttpStack();

        if (++mRefCount == 1) {
            mDataBase.startCacheTransaction();
            return true;
        }
        return false;
    }

    // only called from WebViewWorkerThread
    // make sure to call enableTransaction/disableTransaction in pair
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.023 -0500", hash_original_method = "65C222DBB0B16E3D9C9A879D8816B411", hash_generated_method = "C392682FBE357FFA274F9965349DF02B")
    
static boolean disableTransaction() {
        assert !JniUtil.useChromiumHttpStack();

        if (--mRefCount == 0) {
            mDataBase.endCacheTransaction();
            return true;
        }
        return false;
    }

    // only called from WebViewWorkerThread
    // make sure to call startTransaction/endTransaction in pair
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.025 -0500", hash_original_method = "604E7ACA960E1118AEAD24723E3956E2", hash_generated_method = "95E7F886CB4ED8D88ED2EF3449898360")
    
static boolean startTransaction() {
        assert !JniUtil.useChromiumHttpStack();

        return mDataBase.startCacheTransaction();
    }

    // only called from WebViewWorkerThread
    // make sure to call startTransaction/endTransaction in pair
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.028 -0500", hash_original_method = "0D470A4357137F5CF22E27F25D4438C9", hash_generated_method = "7ACFB55C8E973782678CC1B31B064791")
    
static boolean endTransaction() {
        assert !JniUtil.useChromiumHttpStack();

        boolean ret = mDataBase.endCacheTransaction();
        if (++mTrimCacheCount >= TRIM_CACHE_INTERVAL) {
            mTrimCacheCount = 0;
            trimCacheIfNeeded();
        }
        return ret;
    }

    // only called from WebCore Thread
    // make sure to call startCacheTransaction/endCacheTransaction in pair
    /**
     * @deprecated Always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.030 -0500", hash_original_method = "68D8E567ECF8419214532FD1E5C7DE3D", hash_generated_method = "DC655AD59EB271742B300115B8F74F29")
    
@Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }

    // only called from WebCore Thread
    // make sure to call startCacheTransaction/endCacheTransaction in pair
    /**
     * @deprecated Always returns false.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.032 -0500", hash_original_method = "DAA428FC30DB4B3CA06158EC67C51CFA", hash_generated_method = "E0C46280222321E7B005E281EAFC6630")
    
@Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    /**
     * Given a URL, returns the corresponding CacheResult if it exists, or null otherwise.
     *
     * The input stream of the CacheEntry object is initialized and opened and should be closed by
     * the caller when access to the underlying file is no longer required.
     * If a non-zero value is provided for the headers map, and the cache entry needs validation,
     * HEADER_KEY_IFNONEMATCH or HEADER_KEY_IFMODIFIEDSINCE will be set in headers.
     *
     * @return The CacheResult for the given URL
     *
     * @deprecated Access to the HTTP cache will be removed in a future release.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.034 -0500", hash_original_method = "9B43E497167E7B91E0514510F337FC0F", hash_generated_method = "D81D57C18D8A8C63C92545594B794F56")
    
@Deprecated
    public static CacheResult getCacheFile(String url,
            Map<String, String> headers) {
        return getCacheFile(url, 0, headers);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.042 -0500", hash_original_method = "4E4FEE3E45B78C1C1F78769485D846E8", hash_generated_method = "186F1920794D592844A4AE88FB54D7E3")
    
static CacheResult getCacheFile(String url, long postIdentifier,
            Map<String, String> headers) {
        if (mDisabled) {
            return null;
        }

        if (JniUtil.useChromiumHttpStack()) {
            CacheResult result = nativeGetCacheResult(url);
            if (result == null) {
                return null;
            }
            // A temporary local file will have been created native side and localPath set
            // appropriately.
            File src = new File(mBaseDir, result.localPath);
            try {
                // Open the file here so that even if it is deleted, the content
                // is still readable by the caller until close() is called.
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                Log.v(LOGTAG, "getCacheFile(): Failed to open file: " + e);
                // TODO: The files in the cache directory can be removed by the
                // system. If it is gone, what should we do?
                return null;
            }
            return result;
        }

        String databaseKey = getDatabaseKey(url, postIdentifier);
        CacheResult result = mDataBase.getCache(databaseKey);
        if (result == null) {
            return null;
        }
        if (result.contentLength == 0) {
            if (!isCachableRedirect(result.httpStatusCode)) {
                // This should not happen. If it does, remove it.
                mDataBase.removeCache(databaseKey);
                return null;
            }
        } else {
            File src = new File(mBaseDir, result.localPath);
            try {
                // Open the file here so that even if it is deleted, the content
                // is still readable by the caller until close() is called.
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                // The files in the cache directory can be removed by the
                // system. If it is gone, clean up the database.
                mDataBase.removeCache(databaseKey);
                return null;
            }
        }

        // A null value for headers is used by CACHE_MODE_CACHE_ONLY to imply
        // that we should provide the cache result even if it is expired.
        // Note that a negative expires value means a time in the far future.
        if (headers != null && result.expires >= 0
                && result.expires <= System.currentTimeMillis()) {
            if (result.lastModified == null && result.etag == null) {
                return null;
            }
            // Return HEADER_KEY_IFNONEMATCH or HEADER_KEY_IFMODIFIEDSINCE
            // for requesting validation.
            if (result.etag != null) {
                headers.put(HEADER_KEY_IFNONEMATCH, result.etag);
            }
            if (result.lastModified != null) {
                headers.put(HEADER_KEY_IFMODIFIEDSINCE, result.lastModified);
            }
        }

        if (DebugFlags.CACHE_MANAGER) {
            Log.v(LOGTAG, "getCacheFile for url " + url);
        }

        return result;
    }

    /**
     * Given a url and its full headers, returns CacheResult if a local cache
     * can be stored. Otherwise returns null. The mimetype is passed in so that
     * the function can use the mimetype that will be passed to WebCore which
     * could be different from the mimetype defined in the headers.
     * forceCache is for out-of-package callers to force creation of a
     * CacheResult, and is used to supply surrogate responses for URL
     * interception.
     * @return CacheResult for a given url
     * @hide - hide createCacheFile since it has a parameter of type headers, which is
     * in a hidden package.
     *
     * @deprecated Access to the HTTP cache will be removed in a future release.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.045 -0500", hash_original_method = "9D8B0292BF61165D11B09A1D07C57FAA", hash_generated_method = "E361570C5B288849B1CC1922D12008B8")
    
@Deprecated
    public static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, boolean forceCache) {
        if (JniUtil.useChromiumHttpStack()) {
            // This method is public but hidden. We break functionality.
            return null;
        }

        return createCacheFile(url, statusCode, headers, mimeType, 0,
                forceCache);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.048 -0500", hash_original_method = "187B06232F6CDF0CCCDCE98BD1510E22", hash_generated_method = "4BBC48687B0E9E70DF00C903661299B1")
    
static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, long postIdentifier,
            boolean forceCache) {
        assert !JniUtil.useChromiumHttpStack();

        if (!forceCache && mDisabled) {
            return null;
        }

        String databaseKey = getDatabaseKey(url, postIdentifier);

        // according to the rfc 2616, the 303 response MUST NOT be cached.
        if (statusCode == 303) {
            // remove the saved cache if there is any
            mDataBase.removeCache(databaseKey);
            return null;
        }

        // like the other browsers, do not cache redirects containing a cookie
        // header.
        if (isCachableRedirect(statusCode) && !headers.getSetCookie().isEmpty()) {
            // remove the saved cache if there is any
            mDataBase.removeCache(databaseKey);
            return null;
        }

        CacheResult ret = parseHeaders(statusCode, headers, mimeType);
        if (ret == null) {
            // this should only happen if the headers has "no-store" in the
            // cache-control. remove the saved cache if there is any
            mDataBase.removeCache(databaseKey);
        } else {
            setupFiles(databaseKey, ret);
            try {
                ret.outStream = new FileOutputStream(ret.outFile);
            } catch (FileNotFoundException e) {
                // This can happen with the system did a purge and our
                // subdirectory has gone, so lets try to create it again
                if (createCacheDirectory()) {
                    try {
                        ret.outStream = new FileOutputStream(ret.outFile);
                    } catch  (FileNotFoundException e2) {
                        // We failed to create the file again, so there
                        // is something else wrong. Return null.
                        return null;
                    }
                } else {
                    // Failed to create cache directory
                    return null;
                }
            }
            ret.mimeType = mimeType;
        }

        return ret;
    }

    /**
     * Save the info of a cache file for a given url to the CacheMap so that it
     * can be reused later
     *
     * @deprecated Access to the HTTP cache will be removed in a future release.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.051 -0500", hash_original_method = "5B2895B02F770919C7A447FD3807A154", hash_generated_method = "FA2A899FD670AAECA62D52DFEA96AC42")
    
@Deprecated
    public static void saveCacheFile(String url, CacheResult cacheRet) {
        saveCacheFile(url, 0, cacheRet);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.054 -0500", hash_original_method = "D54B5DD76D17F77C2D9B6B75315C12AF", hash_generated_method = "89A64AF45B131CCFF1019C348D94DB00")
    
static void saveCacheFile(String url, long postIdentifier,
            CacheResult cacheRet) {
        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return;
        }

        if (JniUtil.useChromiumHttpStack()) {
            // This method is exposed in the public API but the API provides no way to obtain a
            // new CacheResult object with a non-null output stream ...
            // - CacheResult objects returned by getCacheFile() have a null output stream.
            // - new CacheResult objects have a null output stream and no setter is provided.
            // Since for the Android HTTP stack this method throws a null pointer exception in this
            // case, this method is effectively useless from the point of view of the public API.

            // We should already have thrown an exception above, to maintain 'backward
            // compatibility' with the Android HTTP stack.
            assert false;
        }

        if (!cacheRet.outFile.exists()) {
            // the file in the cache directory can be removed by the system
            return;
        }

        boolean redirect = isCachableRedirect(cacheRet.httpStatusCode);
        if (redirect) {
            // location is in database, no need to keep the file
            cacheRet.contentLength = 0;
            cacheRet.localPath = "";
        }
        if ((redirect || cacheRet.contentLength == 0)
                && !cacheRet.outFile.delete()) {
            Log.e(LOGTAG, cacheRet.outFile.getPath() + " delete failed.");
        }
        if (cacheRet.contentLength == 0) {
            return;
        }

        mDataBase.addCache(getDatabaseKey(url, postIdentifier), cacheRet);

        if (DebugFlags.CACHE_MANAGER) {
            Log.v(LOGTAG, "saveCacheFile for url " + url);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.056 -0500", hash_original_method = "B851752E3F10EA31521F02463559936A", hash_generated_method = "EEEDD582EF83443F85726A43EF882B5B")
    
static boolean cleanupCacheFile(CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();

        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return false;
        }
        return cacheRet.outFile.delete();
    }

    /**
     * Remove all cache files.
     *
     * @return Whether the removal succeeded.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.062 -0500", hash_original_method = "8B053D7F1520F6A3CE30DCCA756BED4A", hash_generated_method = "9D6D7D01366558B86F29E0C160A9B1C1")
    
static boolean removeAllCacheFiles() {
        // Note, this is called before init() when the database is
        // created or upgraded.
        if (mBaseDir == null) {
            // This method should not be called before init() when using the
            // chrome http stack
            assert !JniUtil.useChromiumHttpStack();
            // Init() has not been called yet, so just flag that
            // we need to clear the cache when init() is called.
            mClearCacheOnInit = true;
            return true;
        }
        // delete rows in the cache database
        if (!JniUtil.useChromiumHttpStack())
            WebViewWorker.getHandler().sendEmptyMessage(WebViewWorker.MSG_CLEAR_CACHE);

        // delete cache files in a separate thread to not block UI.
        final Runnable clearCache = new Runnable() {
            public void run() {
                // delete all cache files
                try {
                    String[] files = mBaseDir.list();
                    // if mBaseDir doesn't exist, files can be null.
                    if (files != null) {
                        for (int i = 0; i < files.length; i++) {
                            File f = new File(mBaseDir, files[i]);
                            if (!f.delete()) {
                                Log.e(LOGTAG, f.getPath() + " delete failed.");
                            }
                        }
                    }
                } catch (SecurityException e) {
                    // Ignore SecurityExceptions.
                }
            }
        };
        new Thread(clearCache).start();
        return true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.069 -0500", hash_original_method = "BDADE4E0F63929C91E9784D4BEEE6A94", hash_generated_method = "821533AB969EC30D88C5041F2FCAF74E")
    
static void trimCacheIfNeeded() {
        assert !JniUtil.useChromiumHttpStack();

        if (mDataBase.getCacheTotalSize() > CACHE_THRESHOLD) {
            List<String> pathList = mDataBase.trimCache(CACHE_TRIM_AMOUNT);
            int size = pathList.size();
            for (int i = 0; i < size; i++) {
                File f = new File(mBaseDir, pathList.get(i));
                if (!f.delete()) {
                    Log.e(LOGTAG, f.getPath() + " delete failed.");
                }
            }
            // remove the unreferenced files in the cache directory
            final List<String> fileList = mDataBase.getAllCacheFileNames();
            if (fileList == null) return;
            String[] toDelete = mBaseDir.list(new FilenameFilter() {
                public boolean accept(File dir, String filename) {
                    if (fileList.contains(filename)) {
                        return false;
                    } else {
                        return true;
                    }
                }
            });
            if (toDelete == null) return;
            size = toDelete.length;
            for (int i = 0; i < size; i++) {
                File f = new File(mBaseDir, toDelete[i]);
                if (!f.delete()) {
                    Log.e(LOGTAG, f.getPath() + " delete failed.");
                }
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.071 -0500", hash_original_method = "EBF8FF361B062C01F7D2F6B200ABB9BA", hash_generated_method = "06ABC24E4421DFFA3721DF4A1A45CD9D")
    
static void clearCache() {
        assert !JniUtil.useChromiumHttpStack();

        // delete database
        mDataBase.clearCache();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.074 -0500", hash_original_method = "F3AB8B6931536450A242ABE9EADE3D7B", hash_generated_method = "FF12C91EA0A617FB3EF6CDFA7687F14E")
    
private static boolean isCachableRedirect(int statusCode) {
        if (statusCode == 301 || statusCode == 302 || statusCode == 307) {
            // as 303 can't be cached, we do not return true
            return true;
        } else {
            return false;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.076 -0500", hash_original_method = "95FFC22FDD78E23D1DBD2657CF1B4DEF", hash_generated_method = "9A879508B81EA3BDEABDB475FFC6E80E")
    
private static String getDatabaseKey(String url, long postIdentifier) {
        assert !JniUtil.useChromiumHttpStack();

        if (postIdentifier == 0) return url;
        return postIdentifier + url;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.079 -0500", hash_original_method = "4240110803662B438BF7B628CA7A5C2B", hash_generated_method = "AD9CFFD4832CBAB3EA78544D498E72C0")
    
@SuppressWarnings("deprecation")
    private static void setupFiles(String url, CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();

        if (true) {
            // Note: SHA1 is much stronger hash. But the cost of setupFiles() is
            // 3.2% cpu time for a fresh load of nytimes.com. While a simple
            // String.hashCode() is only 0.6%. If adding the collision resolving
            // to String.hashCode(), it makes the cpu time to be 1.6% for a 
            // fresh load, but 5.3% for the worst case where all the files 
            // already exist in the file system, but database is gone. So it
            // needs to resolve collision for every file at least once.
            int hashCode = url.hashCode();
            StringBuffer ret = new StringBuffer(8);
            appendAsHex(hashCode, ret);
            String path = ret.toString();
            File file = new File(mBaseDir, path);
            if (true) {
                boolean checkOldPath = true;
                // Check hash collision. If the hash file doesn't exist, just
                // continue. There is a chance that the old cache file is not
                // same as the hash file. As mDataBase.getCache() is more 
                // expansive than "leak" a file until clear cache, don't bother.
                // If the hash file exists, make sure that it is same as the 
                // cache file. If it is not, resolve the collision.
                while (file.exists()) {
                    if (checkOldPath) {
                        CacheResult oldResult = mDataBase.getCache(url);
                        if (oldResult != null && oldResult.contentLength > 0) {
                            if (path.equals(oldResult.localPath)) {
                                path = oldResult.localPath;
                            } else {
                                path = oldResult.localPath;
                                file = new File(mBaseDir, path);
                            }
                            break;
                        }
                        checkOldPath = false;
                    }
                    ret = new StringBuffer(8);
                    appendAsHex(++hashCode, ret);
                    path = ret.toString();
                    file = new File(mBaseDir, path);
                }
            }
            cacheRet.localPath = path;
            cacheRet.outFile = file;
        } else {
            // get hash in byte[]
            Digest digest = new SHA1Digest();
            int digestLen = digest.getDigestSize();
            byte[] hash = new byte[digestLen];
            int urlLen = url.length();
            byte[] data = new byte[urlLen];
            url.getBytes(0, urlLen, data, 0);
            digest.update(data, 0, urlLen);
            digest.doFinal(hash, 0);
            // convert byte[] to hex String
            StringBuffer result = new StringBuffer(2 * digestLen);
            for (int i = 0; i < digestLen; i = i + 4) {
                int h = (0x00ff & hash[i]) << 24 | (0x00ff & hash[i + 1]) << 16
                        | (0x00ff & hash[i + 2]) << 8 | (0x00ff & hash[i + 3]);
                appendAsHex(h, result);
            }
            cacheRet.localPath = result.toString();
            cacheRet.outFile = new File(mBaseDir, cacheRet.localPath);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.082 -0500", hash_original_method = "800F2AC69DCF49143539415C1D541617", hash_generated_method = "9D0BB8A2014EC570579C15D1059CEB30")
    
private static void appendAsHex(int i, StringBuffer ret) {
        assert !JniUtil.useChromiumHttpStack();

        String hex = Integer.toHexString(i);
        switch (hex.length()) {
            case 1:
                ret.append("0000000");
                break;
            case 2:
                ret.append("000000");
                break;
            case 3:
                ret.append("00000");
                break;
            case 4:
                ret.append("0000");
                break;
            case 5:
                ret.append("000");
                break;
            case 6:
                ret.append("00");
                break;
            case 7:
                ret.append("0");
                break;
        }
        ret.append(hex);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.087 -0500", hash_original_method = "1ECAF0C7E317327AAFF7668BB9253488", hash_generated_method = "4ECE103822C066B9D7DB7BFC24BB39BC")
    
private static CacheResult parseHeaders(int statusCode, Headers headers,
            String mimeType) {
        assert !JniUtil.useChromiumHttpStack();

        // if the contentLength is already larger than CACHE_MAX_SIZE, skip it
        if (headers.getContentLength() > CACHE_MAX_SIZE) return null;

        // The HTML 5 spec, section 6.9.4, step 7.3 of the application cache
        // process states that HTTP caching rules are ignored for the
        // purposes of the application cache download process.
        // At this point we can't tell that if a file is part of this process,
        // except for the manifest, which has its own mimeType.
        // TODO: work out a way to distinguish all responses that are part of
        // the application download process and skip them.
        if (MANIFEST_MIME.equals(mimeType)) return null;

        // TODO: if authenticated or secure, return null
        CacheResult ret = new CacheResult();
        ret.httpStatusCode = statusCode;

        ret.location = headers.getLocation();

        ret.expires = -1;
        ret.expiresString = headers.getExpires();
        if (ret.expiresString != null) {
            try {
                ret.expires = AndroidHttpClient.parseDate(ret.expiresString);
            } catch (IllegalArgumentException ex) {
                // Take care of the special "-1" and "0" cases
                if ("-1".equals(ret.expiresString)
                        || "0".equals(ret.expiresString)) {
                    // make it expired, but can be used for history navigation
                    ret.expires = 0;
                } else {
                    Log.e(LOGTAG, "illegal expires: " + ret.expiresString);
                }
            }
        }

        ret.contentdisposition = headers.getContentDisposition();

        ret.crossDomain = headers.getXPermittedCrossDomainPolicies();

        // lastModified and etag may be set back to http header. So they can't
        // be empty string.
        String lastModified = headers.getLastModified();
        if (lastModified != null && lastModified.length() > 0) {
            ret.lastModified = lastModified;
        }

        String etag = headers.getEtag();
        if (etag != null && etag.length() > 0) {
            ret.etag = etag;
        }

        String cacheControl = headers.getCacheControl();
        if (cacheControl != null) {
            String[] controls = cacheControl.toLowerCase().split("[ ,;]");
            boolean noCache = false;
            for (int i = 0; i < controls.length; i++) {
                if (NO_STORE.equals(controls[i])) {
                    return null;
                }
                // According to the spec, 'no-cache' means that the content
                // must be re-validated on every load. It does not mean that
                // the content can not be cached. set to expire 0 means it
                // can only be used in CACHE_MODE_CACHE_ONLY case
                if (NO_CACHE.equals(controls[i])) {
                    ret.expires = 0;
                    noCache = true;
                // if cache control = no-cache has been received, ignore max-age
                // header, according to http spec:
                // If a request includes the no-cache directive, it SHOULD NOT
                // include min-fresh, max-stale, or max-age.
                } else if (controls[i].startsWith(MAX_AGE) && !noCache) {
                    int separator = controls[i].indexOf('=');
                    if (separator < 0) {
                        separator = controls[i].indexOf(':');
                    }
                    if (separator > 0) {
                        String s = controls[i].substring(separator + 1);
                        try {
                            long sec = Long.parseLong(s);
                            if (sec >= 0) {
                                ret.expires = System.currentTimeMillis() + 1000
                                        * sec;
                            }
                        } catch (NumberFormatException ex) {
                            if ("1d".equals(s)) {
                                // Take care of the special "1d" case
                                ret.expires = System.currentTimeMillis() + 86400000; // 24*60*60*1000
                            } else {
                                Log.e(LOGTAG, "exception in parseHeaders for "
                                        + "max-age:"
                                        + controls[i].substring(separator + 1));
                                ret.expires = 0;
                            }
                        }
                    }
                }
            }
        }

        // According to RFC 2616 section 14.32:
        // HTTP/1.1 caches SHOULD treat "Pragma: no-cache" as if the
        // client had sent "Cache-Control: no-cache"
        if (NO_CACHE.equals(headers.getPragma())) {
            ret.expires = 0;
        }

        // According to RFC 2616 section 13.2.4, if an expiration has not been
        // explicitly defined a heuristic to set an expiration may be used.
        if (ret.expires == -1) {
            if (ret.httpStatusCode == 301) {
                // If it is a permanent redirect, and it did not have an
                // explicit cache directive, then it never expires
                ret.expires = Long.MAX_VALUE;
            } else if (ret.httpStatusCode == 302 || ret.httpStatusCode == 307) {
                // If it is temporary redirect, expires
                ret.expires = 0;
            } else if (ret.lastModified == null) {
                // When we have no last-modified, then expire the content with
                // in 24hrs as, according to the RFC, longer time requires a
                // warning 113 to be added to the response.

                // Only add the default expiration for non-html markup. Some
                // sites like news.google.com have no cache directives.
                if (!mimeType.startsWith("text/html")) {
                    ret.expires = System.currentTimeMillis() + 86400000; // 24*60*60*1000
                } else {
                    // Setting a expires as zero will cache the result for
                    // forward/back nav.
                    ret.expires = 0;
                }
            } else {
                // If we have a last-modified value, we could use it to set the
                // expiration. Suggestion from RFC is 10% of time since
                // last-modified. As we are on mobile, loads are expensive,
                // increasing this to 20%.

                // 24 * 60 * 60 * 1000
                long lastmod = System.currentTimeMillis() + 86400000;
                try {
                    lastmod = AndroidHttpClient.parseDate(ret.lastModified);
                } catch (IllegalArgumentException ex) {
                    Log.e(LOGTAG, "illegal lastModified: " + ret.lastModified);
                }
                long difference = System.currentTimeMillis() - lastmod;
                if (difference > 0) {
                    ret.expires = System.currentTimeMillis() + difference / 5;
                } else {
                    // last modified is in the future, expire the content
                    // on the last modified
                    ret.expires = lastmod;
                }
            }
        }

        return ret;
    }
    
    private static CacheResult nativeGetCacheResult(String url) {
    	CacheResult ret = new CacheResult();
    	ret.taint.addTaint(url.taint);
    	return ret;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.898 -0500", hash_original_field = "81C4610321BCE12B5287EA324FFC2568", hash_generated_field = "389C12A8617D8BCC08630F7BA010C0E2")

    private static final String LOGTAG = "cache";
    
    public static class CacheResult {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.937 -0500", hash_original_field = "6C670D782CFBD30F05F5773A857F5BD7", hash_generated_field = "6C670D782CFBD30F05F5773A857F5BD7")

        int httpStatusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.940 -0500", hash_original_field = "1E697977C6954C6B938DDD0BFFFD6A14", hash_generated_field = "1E697977C6954C6B938DDD0BFFFD6A14")

        long contentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.942 -0500", hash_original_field = "79E45F34FE773E697DAD830A242384A5", hash_generated_field = "79E45F34FE773E697DAD830A242384A5")

        long expires;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.944 -0500", hash_original_field = "7815601E56735F19D559F76C33613949", hash_generated_field = "7815601E56735F19D559F76C33613949")

        String expiresString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.946 -0500", hash_original_field = "1EFCF95FF82C8B86BA07D210605AF3E7", hash_generated_field = "1EFCF95FF82C8B86BA07D210605AF3E7")

        String localPath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.949 -0500", hash_original_field = "EFB9BC01C22F5C81858357CDB303A6BA", hash_generated_field = "EFB9BC01C22F5C81858357CDB303A6BA")

        String lastModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.951 -0500", hash_original_field = "00F25F78CD9C317A5119E7AB2B23712A", hash_generated_field = "00F25F78CD9C317A5119E7AB2B23712A")

        String etag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.953 -0500", hash_original_field = "199378A118748448CD8C8A5B6EE3C464", hash_generated_field = "199378A118748448CD8C8A5B6EE3C464")

        String mimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.955 -0500", hash_original_field = "4B5743C8685C2D199755623CB9DF3317", hash_generated_field = "4B5743C8685C2D199755623CB9DF3317")

        String location;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.957 -0500", hash_original_field = "C7941A2E59CC2DF1A97D47295C728725", hash_generated_field = "C7941A2E59CC2DF1A97D47295C728725")

        String encoding;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.959 -0500", hash_original_field = "4265D6CD339375A09FEF81E5473D341C", hash_generated_field = "4265D6CD339375A09FEF81E5473D341C")

        String contentdisposition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.961 -0500", hash_original_field = "C13D92B86B5B4AF70043404C40B34ACF", hash_generated_field = "C13D92B86B5B4AF70043404C40B34ACF")

        String crossDomain;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.962 -0500", hash_original_field = "CE67F8E6759E7AA9F0B2D1B1C622FA48", hash_generated_field = "CE67F8E6759E7AA9F0B2D1B1C622FA48")

        InputStream inStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.965 -0500", hash_original_field = "430FBB760F592DD8FEBCE2866E75BC6B", hash_generated_field = "430FBB760F592DD8FEBCE2866E75BC6B")

        OutputStream outStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.967 -0500", hash_original_field = "20194DFB6E90B876A72FB28D859C6FC5", hash_generated_field = "20194DFB6E90B876A72FB28D859C6FC5")

        File outFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.533 -0400", hash_original_method = "9AF27DA4AF1967F12C09CBC55DFAD3DC", hash_generated_method = "9AF27DA4AF1967F12C09CBC55DFAD3DC")
        public CacheResult ()
        {
            //Synthesized constructor
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.969 -0500", hash_original_method = "DD5A2376D1CE8800456745E0EBB16914", hash_generated_method = "05E1BDC3F930AE4663B3ADC026DD22C2")
        
public int getHttpStatusCode() {
            return httpStatusCode;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.972 -0500", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "64E0C789E764D7FD18A4925FDDA762C8")
        
public long getContentLength() {
            return contentLength;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.974 -0500", hash_original_method = "AD502AEBBD528088B1D12F9CAC38CB54", hash_generated_method = "4DD9751EF04928DC79E9AA1DE1356FEE")
        
public String getLocalPath() {
            return localPath;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.976 -0500", hash_original_method = "4C886ADD26DB3A9818AA89FF03B8C3FC", hash_generated_method = "12335BAB18601E1037EC411935B42E23")
        
public long getExpires() {
            return expires;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.979 -0500", hash_original_method = "EF25E8FEFAF784FE84A0290E2AAD114E", hash_generated_method = "187EC9566E2CC705D650305F823DDA0F")
        
public String getExpiresString() {
            return expiresString;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.981 -0500", hash_original_method = "9BE76A44786245A5C82A387C274361E4", hash_generated_method = "720ADC2B71BAD00DC8CFB20AB813B3DD")
        
public String getLastModified() {
            return lastModified;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.984 -0500", hash_original_method = "C916AEC2FCF91BC5DCA69D0B98CD1013", hash_generated_method = "0B3F663A0C2BFFC22DD63EF03D0F9EB2")
        
public String getETag() {
            return etag;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.986 -0500", hash_original_method = "6CD12CC12FD0AC9D51B06E8F6D96C76B", hash_generated_method = "225784A00B7377228AA4645659A263CC")
        
public String getMimeType() {
            return mimeType;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.988 -0500", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "ADF84B7CD584A3086AA314B699B00CEF")
        
public String getLocation() {
            return location;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.990 -0500", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "AB48E45DF4593246DCA3A0BE40153818")
        
public String getEncoding() {
            return encoding;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.992 -0500", hash_original_method = "C0D4D7C4AE17A99630CF9DD48649B988", hash_generated_method = "28853BE5A577482C17B67B77E9997A22")
        
public String getContentDisposition() {
            return contentdisposition;
        }

        // For out-of-package access to the underlying streams.
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.995 -0500", hash_original_method = "3D92385EA50556C1C84606BD9B5473E5", hash_generated_method = "B57247C408127008EF13DE390580A218")
        
public InputStream getInputStream() {
            return inStream;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.997 -0500", hash_original_method = "B77E86F2D56E5DBE0D55411B47D89551", hash_generated_method = "F74C956C913E715C9216BB2E8F5A91CB")
        
public OutputStream getOutputStream() {
            return outStream;
        }

        // These fields can be set manually.
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.999 -0500", hash_original_method = "B7D827E5771A9B377DDBAC601F400FD6", hash_generated_method = "9BE7805248AEDDB9A0770DAEE15BF6EB")
        
public void setInputStream(InputStream stream) {
            this.inStream = stream;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.001 -0500", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "F16BDC16289B2D2161EBDE6B982650A4")
        
public void setEncoding(String encoding) {
            this.encoding = encoding;
        }

        /**
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:19.003 -0500", hash_original_method = "24FE4CA1135DA21E8B00A4A2D819D5D2", hash_generated_method = "D0AA115BAB323123886FEA387318191B")
        
public void setContentLength(long contentLength) {
            this.contentLength = contentLength;
        }
        
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.901 -0500", hash_original_field = "61FA04D7E8ADF1B0CC1869A6A1603B58", hash_generated_field = "05C239D2ED2147F03B62552EFE9672C2")

    static final String HEADER_KEY_IFMODIFIEDSINCE = "if-modified-since";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.903 -0500", hash_original_field = "0DC5995A1034243BCF9D61DB5154E627", hash_generated_field = "74E44E569BB9F45FBC857E67B78E6030")

    static final String HEADER_KEY_IFNONEMATCH = "if-none-match";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.905 -0500", hash_original_field = "E171209401D4ECEC0C7E62839C040319", hash_generated_field = "939B143BA252760FE6A2040085DA20D1")

    private static final String NO_STORE = "no-store";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.908 -0500", hash_original_field = "426483A1C20B927FA6B0FF7AB5830782", hash_generated_field = "AE15FEBAB58E4F297E6B247B85A02B60")

    private static final String NO_CACHE = "no-cache";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.910 -0500", hash_original_field = "04D54F7257534E50A6A60C8A9BACF9EA", hash_generated_field = "17FDE42B196035B579C4AE0481D84D7C")

    private static final String MAX_AGE = "max-age";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.912 -0500", hash_original_field = "DCCACD75283DADAE0A2418B96F29AE8F", hash_generated_field = "8EEB13495576D8136145DB9C601F7A1C")

    private static final String MANIFEST_MIME = "text/cache-manifest";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.914 -0500", hash_original_field = "1B11CC923E16BC5CF98BDDE4FEC59652", hash_generated_field = "D647BC6BC6F91B30C579B54074B4681D")

    private static long CACHE_THRESHOLD = 6 * 1024 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.916 -0500", hash_original_field = "220EB643096147A378626A5C3B55BFC6", hash_generated_field = "C7BC04A2C8C224B4992692522B1C9534")

    private static long CACHE_TRIM_AMOUNT = 2 * 1024 * 1024;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.918 -0500", hash_original_field = "F801075601131568468FE4052F24C38F", hash_generated_field = "955815A71A2F2BF01B99CE38A6328746")

    static long CACHE_MAX_SIZE = (CACHE_THRESHOLD - CACHE_TRIM_AMOUNT) / 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.921 -0500", hash_original_field = "5C14BBA06D128BE82D86D31F8DDD2320", hash_generated_field = "065C749395F8EEFD3FA335C42BB42982")

    private static boolean mDisabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.923 -0500", hash_original_field = "10901FC32DF7F71F9F354DE920A6F5B1", hash_generated_field = "612C983B5C95EDDDA5D6667269D6C1BD")

    private static int mRefCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.926 -0500", hash_original_field = "24CDF727303D83E32EAD6FF72A7DCF68", hash_generated_field = "64979C270AC155439BA3EAEE15A87924")

    // can load the content, e.g. in a slideshow, continuously, so we need to
    // trim the cache on a timer base too. endCacheTransaction() is called on a 
    // timer base. We share the same timer with less frequent update.
    private static int mTrimCacheCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.928 -0500", hash_original_field = "92D8D6BED5C84D2AE968361DF1D8FE21", hash_generated_field = "75DC397F63C8ACC66AC03AE377165A97")

    private static final int TRIM_CACHE_INTERVAL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.930 -0500", hash_original_field = "D432C32D33F8FDFC876BCEEC94F4E8D4", hash_generated_field = "112D7378ACAC09B383FA76ADC4A7A80A")

    private static WebViewDatabase mDataBase;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.932 -0500", hash_original_field = "A463709AFBD745F5F6949AAF0F7C62A9", hash_generated_field = "E5AA5969C86636B06EBA401AAD2DB4DE")

    private static File mBaseDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.935 -0500", hash_original_field = "34C52DD55A41D3C2BBF7BC1909104C92", hash_generated_field = "485E2AE6AF65AD3F25A212E1A5B60B89")

    private static boolean mClearCacheOnInit = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.526 -0400", hash_original_method = "A0B4DD756EBE924AE07FCEE8B62EE3BB", hash_generated_method = "A0B4DD756EBE924AE07FCEE8B62EE3BB")
    public CacheManager ()
    {
        //Synthesized constructor
    }
}

