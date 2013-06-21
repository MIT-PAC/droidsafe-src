package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.net.http.Headers;
import android.os.FileUtils;
import android.util.Log;
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
import com.android.org.bouncycastle.crypto.Digest;
import com.android.org.bouncycastle.crypto.digests.SHA1Digest;

public final class CacheManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.815 -0400", hash_original_method = "4F1EFB8117D6BB5F6FAF53B436617FEC", hash_generated_method = "4F1EFB8117D6BB5F6FAF53B436617FEC")
        public CacheManager ()
    {
    }


        static void init(Context context) {
        if (JniUtil.useChromiumHttpStack()) {
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
            WebViewWorker.getHandler().sendEmptyMessage(
                    WebViewWorker.MSG_CLEAR_CACHE);
            return true;
        }
        return false;
    }

    
        @Deprecated
    public static File getCacheFileBaseDir() {
        return mBaseDir;
    }

    
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

    
        @Deprecated
    public static boolean cacheDisabled() {
        return mDisabled;
    }

    
        static boolean enableTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        if (++mRefCount == 1) {
            mDataBase.startCacheTransaction();
            return true;
        }
        return false;
    }

    
        static boolean disableTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        if (--mRefCount == 0) {
            mDataBase.endCacheTransaction();
            return true;
        }
        return false;
    }

    
        static boolean startTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        return mDataBase.startCacheTransaction();
    }

    
        static boolean endTransaction() {
        assert !JniUtil.useChromiumHttpStack();
        boolean ret = mDataBase.endCacheTransaction();
        if (++mTrimCacheCount >= TRIM_CACHE_INTERVAL) {
            mTrimCacheCount = 0;
            trimCacheIfNeeded();
        }
        return ret;
    }

    
        @Deprecated
    public static boolean startCacheTransaction() {
        return false;
    }

    
        @Deprecated
    public static boolean endCacheTransaction() {
        return false;
    }

    
        @Deprecated
    public static CacheResult getCacheFile(String url,
            Map<String, String> headers) {
        return getCacheFile(url, 0, headers);
    }

    
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
            File src = new File(mBaseDir, result.localPath);
            try {
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                Log.v(LOGTAG, "getCacheFile(): Failed to open file: " + e);
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
                mDataBase.removeCache(databaseKey);
                return null;
            }
        } else {
            File src = new File(mBaseDir, result.localPath);
            try {
                result.inStream = new FileInputStream(src);
            } catch (FileNotFoundException e) {
                mDataBase.removeCache(databaseKey);
                return null;
            }
        }
        if (headers != null && result.expires >= 0
                && result.expires <= System.currentTimeMillis()) {
            if (result.lastModified == null && result.etag == null) {
                return null;
            }
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

    
        @Deprecated
    public static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, boolean forceCache) {
        if (JniUtil.useChromiumHttpStack()) {
            return null;
        }
        return createCacheFile(url, statusCode, headers, mimeType, 0,
                forceCache);
    }

    
        static CacheResult createCacheFile(String url, int statusCode,
            Headers headers, String mimeType, long postIdentifier,
            boolean forceCache) {
        assert !JniUtil.useChromiumHttpStack();
        if (!forceCache && mDisabled) {
            return null;
        }
        String databaseKey = getDatabaseKey(url, postIdentifier);
        if (statusCode == 303) {
            mDataBase.removeCache(databaseKey);
            return null;
        }
        if (isCachableRedirect(statusCode) && !headers.getSetCookie().isEmpty()) {
            mDataBase.removeCache(databaseKey);
            return null;
        }
        CacheResult ret = parseHeaders(statusCode, headers, mimeType);
        if (ret == null) {
            mDataBase.removeCache(databaseKey);
        } else {
            setupFiles(databaseKey, ret);
            try {
                ret.outStream = new FileOutputStream(ret.outFile);
            } catch (FileNotFoundException e) {
                if (createCacheDirectory()) {
                    try {
                        ret.outStream = new FileOutputStream(ret.outFile);
                    } catch  (FileNotFoundException e2) {
                        return null;
                    }
                } else {
                    return null;
                }
            }
            ret.mimeType = mimeType;
        }
        return ret;
    }

    
        @Deprecated
    public static void saveCacheFile(String url, CacheResult cacheRet) {
        saveCacheFile(url, 0, cacheRet);
    }

    
        static void saveCacheFile(String url, long postIdentifier,
            CacheResult cacheRet) {
        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return;
        }
        if (JniUtil.useChromiumHttpStack()) {
            assert false;
        }
        if (!cacheRet.outFile.exists()) {
            return;
        }
        boolean redirect = isCachableRedirect(cacheRet.httpStatusCode);
        if (redirect) {
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

    
        static boolean cleanupCacheFile(CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();
        try {
            cacheRet.outStream.close();
        } catch (IOException e) {
            return false;
        }
        return cacheRet.outFile.delete();
    }

    
        static boolean removeAllCacheFiles() {
        if (mBaseDir == null) {
            assert !JniUtil.useChromiumHttpStack();
            mClearCacheOnInit = true;
            return true;
        }
        if (!JniUtil.useChromiumHttpStack())
            WebViewWorker.getHandler().sendEmptyMessage(WebViewWorker.MSG_CLEAR_CACHE);
        final Runnable clearCache = new Runnable() {
            public void run() {
                try {
                    String[] files = mBaseDir.list();
                    if (files != null) {
                        for (int i = 0; i < files.length; i++) {
                            File f = new File(mBaseDir, files[i]);
                            if (!f.delete()) {
                                Log.e(LOGTAG, f.getPath() + " delete failed.");
                            }
                        }
                    }
                } catch (SecurityException e) {
                }
            }
        };
        new Thread(clearCache).start();
        return true;
    }

    
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

    
        static void clearCache() {
        assert !JniUtil.useChromiumHttpStack();
        mDataBase.clearCache();
    }

    
        private static boolean isCachableRedirect(int statusCode) {
        if (statusCode == 301 || statusCode == 302 || statusCode == 307) {
            return true;
        } else {
            return false;
        }
    }

    
        private static String getDatabaseKey(String url, long postIdentifier) {
        assert !JniUtil.useChromiumHttpStack();
        if (postIdentifier == 0) return url;
        return postIdentifier + url;
    }

    
        @SuppressWarnings("deprecation")
    private static void setupFiles(String url, CacheResult cacheRet) {
        assert !JniUtil.useChromiumHttpStack();
        if (true) {
            int hashCode = url.hashCode();
            StringBuffer ret = new StringBuffer(8);
            appendAsHex(hashCode, ret);
            String path = ret.toString();
            File file = new File(mBaseDir, path);
            if (true) {
                boolean checkOldPath = true;
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
            Digest digest = new SHA1Digest();
            int digestLen = digest.getDigestSize();
            byte[] hash = new byte[digestLen];
            int urlLen = url.length();
            byte[] data = new byte[urlLen];
            url.getBytes(0, urlLen, data, 0);
            digest.update(data, 0, urlLen);
            digest.doFinal(hash, 0);
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

    
        private static CacheResult parseHeaders(int statusCode, Headers headers,
            String mimeType) {
        assert !JniUtil.useChromiumHttpStack();
        if (headers.getContentLength() > CACHE_MAX_SIZE) return null;
        if (MANIFEST_MIME.equals(mimeType)) return null;
        CacheResult ret = new CacheResult();
        ret.httpStatusCode = statusCode;
        ret.location = headers.getLocation();
        ret.expires = -1;
        ret.expiresString = headers.getExpires();
        if (ret.expiresString != null) {
            try {
                ret.expires = AndroidHttpClient.parseDate(ret.expiresString);
            } catch (IllegalArgumentException ex) {
                if ("-1".equals(ret.expiresString)
                        || "0".equals(ret.expiresString)) {
                    ret.expires = 0;
                } else {
                    Log.e(LOGTAG, "illegal expires: " + ret.expiresString);
                }
            }
        }
        ret.contentdisposition = headers.getContentDisposition();
        ret.crossDomain = headers.getXPermittedCrossDomainPolicies();
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
                if (NO_CACHE.equals(controls[i])) {
                    ret.expires = 0;
                    noCache = true;
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
                                ret.expires = System.currentTimeMillis() + 86400000; 
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
        if (NO_CACHE.equals(headers.getPragma())) {
            ret.expires = 0;
        }
        if (ret.expires == -1) {
            if (ret.httpStatusCode == 301) {
                ret.expires = Long.MAX_VALUE;
            } else if (ret.httpStatusCode == 302 || ret.httpStatusCode == 307) {
                ret.expires = 0;
            } else if (ret.lastModified == null) {
                if (!mimeType.startsWith("text/html")) {
                    ret.expires = System.currentTimeMillis() + 86400000; 
                } else {
                    ret.expires = 0;
                }
            } else {
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
                    ret.expires = lastmod;
                }
            }
        }
        return ret;
    }

    
        private static CacheResult nativeGetCacheResult(String url) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    public static class CacheResult {
        int httpStatusCode;
        long contentLength;
        long expires;
        String expiresString;
        String localPath;
        String lastModified;
        String etag;
        String mimeType;
        String location;
        String encoding;
        String contentdisposition;
        String crossDomain;
        InputStream inStream;
        OutputStream outStream;
        File outFile;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.820 -0400", hash_original_method = "E9CF08270D9DF2DE1FEDD7B5458DD349", hash_generated_method = "E9CF08270D9DF2DE1FEDD7B5458DD349")
                public CacheResult ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "DD5A2376D1CE8800456745E0EBB16914", hash_generated_method = "D76B6BE8F56ED6EA320464C971BD5474")
        @DSModeled(DSC.SAFE)
        public int getHttpStatusCode() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return httpStatusCode;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "043A311B0C55CC2C0E7ED635C15C25FD", hash_generated_method = "84773E1BA86644DF0F2D0EF5D9EB2D08")
        @DSModeled(DSC.SAFE)
        public long getContentLength() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return contentLength;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "AD502AEBBD528088B1D12F9CAC38CB54", hash_generated_method = "09CF339A3AB24A9B73E8FBC50E017F33")
        @DSModeled(DSC.SAFE)
        public String getLocalPath() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return localPath;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "4C886ADD26DB3A9818AA89FF03B8C3FC", hash_generated_method = "56A8258C18A2C13B433FC76E6B47507B")
        @DSModeled(DSC.SAFE)
        public long getExpires() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return expires;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "EF25E8FEFAF784FE84A0290E2AAD114E", hash_generated_method = "C2CD1B2C6C732C7358C93DD0D18E8849")
        @DSModeled(DSC.SAFE)
        public String getExpiresString() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return expiresString;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.821 -0400", hash_original_method = "9BE76A44786245A5C82A387C274361E4", hash_generated_method = "ED7C185069701BD9E0401AFD782FEB34")
        @DSModeled(DSC.SAFE)
        public String getLastModified() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return lastModified;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.822 -0400", hash_original_method = "C916AEC2FCF91BC5DCA69D0B98CD1013", hash_generated_method = "0664DEBBE9B8E3DCE3DA41BAC0CACE2C")
        @DSModeled(DSC.SAFE)
        public String getETag() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return etag;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.822 -0400", hash_original_method = "6CD12CC12FD0AC9D51B06E8F6D96C76B", hash_generated_method = "2B9A7264CC8CC55B424E4483F2F67260")
        @DSModeled(DSC.SAFE)
        public String getMimeType() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mimeType;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.822 -0400", hash_original_method = "958E0B7EB30F5353747022B831D2FD74", hash_generated_method = "A941BDFD2013D229D958641548CDE8D4")
        @DSModeled(DSC.SAFE)
        public String getLocation() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return location;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.822 -0400", hash_original_method = "ECC6E581C26F132636CDCE9C9A5E5807", hash_generated_method = "CBEFCA9969C56A89ACF5940A8F5F0AD9")
        @DSModeled(DSC.SAFE)
        public String getEncoding() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return encoding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.822 -0400", hash_original_method = "C0D4D7C4AE17A99630CF9DD48649B988", hash_generated_method = "5EE1C8A5DCF0773697DC62C2A49FB768")
        @DSModeled(DSC.SAFE)
        public String getContentDisposition() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return contentdisposition;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.823 -0400", hash_original_method = "3D92385EA50556C1C84606BD9B5473E5", hash_generated_method = "69098AAC6F12F46199677F39AF66D197")
        @DSModeled(DSC.SAFE)
        public InputStream getInputStream() {
            return (InputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return inStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.823 -0400", hash_original_method = "B77E86F2D56E5DBE0D55411B47D89551", hash_generated_method = "CBFD7CF665184565E3EE261C02D58C52")
        @DSModeled(DSC.SAFE)
        public OutputStream getOutputStream() {
            return (OutputStream)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return outStream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.823 -0400", hash_original_method = "B7D827E5771A9B377DDBAC601F400FD6", hash_generated_method = "9FA83DBC34762210AA597060BE2E3128")
        @DSModeled(DSC.SAFE)
        public void setInputStream(InputStream stream) {
            dsTaint.addTaint(stream.dsTaint);
            // ---------- Original Method ----------
            //this.inStream = stream;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.823 -0400", hash_original_method = "109F4EE072FF4A68A1B686347AFE92DB", hash_generated_method = "27156723D1E3FA1BA675915616B1D20A")
        @DSModeled(DSC.SAFE)
        public void setEncoding(String encoding) {
            dsTaint.addTaint(encoding);
            // ---------- Original Method ----------
            //this.encoding = encoding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.823 -0400", hash_original_method = "24FE4CA1135DA21E8B00A4A2D819D5D2", hash_generated_method = "05DA24B8F82E21605E5E8142BEC17DAE")
        @DSModeled(DSC.SAFE)
        public void setContentLength(long contentLength) {
            dsTaint.addTaint(contentLength);
            // ---------- Original Method ----------
            //this.contentLength = contentLength;
        }

        
    }


    
    private static final String LOGTAG = "cache";
    static final String HEADER_KEY_IFMODIFIEDSINCE = "if-modified-since";
    static final String HEADER_KEY_IFNONEMATCH = "if-none-match";
    private static final String NO_STORE = "no-store";
    private static final String NO_CACHE = "no-cache";
    private static final String MAX_AGE = "max-age";
    private static final String MANIFEST_MIME = "text/cache-manifest";
    private static long CACHE_THRESHOLD = 6 * 1024 * 1024;
    private static long CACHE_TRIM_AMOUNT = 2 * 1024 * 1024;
    static long CACHE_MAX_SIZE = (CACHE_THRESHOLD - CACHE_TRIM_AMOUNT) / 2;
    private static boolean mDisabled;
    private static int mRefCount;
    private static int mTrimCacheCount = 0;
    private static final int TRIM_CACHE_INTERVAL = 5;
    private static WebViewDatabase mDataBase;
    private static File mBaseDir;
    private static boolean mClearCacheOnInit = false;
}

