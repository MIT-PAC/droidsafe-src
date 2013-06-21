package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

final class WebViewWorker extends Handler {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.372 -0400", hash_original_method = "D7D568B3C492B7B5D5E0F8FEE23B0F62", hash_generated_method = "2B997B6EAE25D605290E84545F5309F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private WebViewWorker(Looper looper) {
        super(looper);
        dsTaint.addTaint(looper.dsTaint);
        // ---------- Original Method ----------
    }

    
        static synchronized WebViewWorker getHandler() {
        if (sWorkerHandler == null) {
            HandlerThread thread = new HandlerThread(THREAD_NAME,
                    android.os.Process.THREAD_PRIORITY_DEFAULT
                            + android.os.Process.THREAD_PRIORITY_LESS_FAVORABLE);
            thread.start();
            sWorkerHandler = new WebViewWorker(thread.getLooper());
        }
        return sWorkerHandler;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.373 -0400", hash_original_method = "E3F221A899CA64DBBAE93DBAE213C92D", hash_generated_method = "9C2EA8BCEDE3DD46842354C9F5531194")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void handleMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        //Begin case MSG_ADD_STREAMLOADER 
        {
            StreamLoader loader;
            loader = (StreamLoader) msg.obj;
            loader.load();
        } //End block
        //End case MSG_ADD_STREAMLOADER 
        //Begin case MSG_ADD_HTTPLOADER 
        {
            FrameLoader loader;
            loader = (FrameLoader) msg.obj;
            loader.handleHTTPLoad();
        } //End block
        //End case MSG_ADD_HTTPLOADER 
        //Begin case MSG_CREATE_CACHE 
        {
            CacheCreateData data;
            data = (CacheCreateData) msg.obj;
            CacheManager.CacheResult cache;
            cache = CacheManager.createCacheFile(
                        data.mUrl, data.mStatusCode, data.mHeaders,
                        data.mMimeType, data.mPostId, false);
            {
                mCacheResultMap.put(data.mListener, cache);
            } //End block
            {
                mCacheResultMap.remove(data.mListener);
            } //End block
        } //End block
        //End case MSG_CREATE_CACHE 
        //Begin case MSG_UPDATE_CACHE_ENCODING 
        {
            CacheEncoding data;
            data = (CacheEncoding) msg.obj;
            CacheManager.CacheResult cache;
            cache = mCacheResultMap
                        .get(data.mListener);
            {
                cache.encoding = data.mEncoding;
            } //End block
        } //End block
        //End case MSG_UPDATE_CACHE_ENCODING 
        //Begin case MSG_APPEND_CACHE 
        {
            CacheData data;
            data = (CacheData) msg.obj;
            CacheManager.CacheResult cache;
            cache = mCacheResultMap
                        .get(data.mListener);
            {
                cache.contentLength += data.mChunk.mLength;
                {
                    CacheManager.cleanupCacheFile(cache);
                    mCacheResultMap.remove(data.mListener);
                } //End block
                {
                    try 
                    {
                        cache.outStream.write(data.mChunk.mArray, 0,
                                    data.mChunk.mLength);
                    } //End block
                    catch (IOException e)
                    {
                        CacheManager.cleanupCacheFile(cache);
                        mCacheResultMap.remove(data.mListener);
                    } //End block
                } //End block
            } //End block
            data.mChunk.release();
        } //End block
        //End case MSG_APPEND_CACHE 
        //Begin case MSG_SAVE_CACHE 
        {
            CacheSaveData data;
            data = (CacheSaveData) msg.obj;
            CacheManager.CacheResult cache;
            cache = mCacheResultMap
                        .get(data.mListener);
            {
                CacheManager.saveCacheFile(data.mUrl, data.mPostId, cache);
                mCacheResultMap.remove(data.mListener);
            } //End block
        } //End block
        //End case MSG_SAVE_CACHE 
        //Begin case MSG_REMOVE_CACHE 
        {
            LoadListener listener;
            listener = (LoadListener) msg.obj;
            CacheManager.CacheResult cache;
            cache = mCacheResultMap.get(listener);
            {
                CacheManager.cleanupCacheFile(cache);
                mCacheResultMap.remove(listener);
            } //End block
        } //End block
        //End case MSG_REMOVE_CACHE 
        //Begin case MSG_TRIM_CACHE 
        {
            CacheManager.trimCacheIfNeeded();
        } //End block
        //End case MSG_TRIM_CACHE 
        //Begin case MSG_CLEAR_CACHE 
        {
            CacheManager.clearCache();
        } //End block
        //End case MSG_CLEAR_CACHE 
        //Begin case MSG_CACHE_TRANSACTION_TICKER 
        {
            {
                CacheManager.endTransaction();
                CacheManager.startTransaction();
                sendEmptyMessageDelayed(MSG_CACHE_TRANSACTION_TICKER,
                            CACHE_TRANSACTION_TICKER_INTERVAL);
            } //End block
        } //End block
        //End case MSG_CACHE_TRANSACTION_TICKER 
        //Begin case MSG_PAUSE_CACHE_TRANSACTION 
        {
            {
                boolean varFA939AFA557F3C8BDE81CB8A30FD3E26_433790321 = (CacheManager.disableTransaction());
                {
                    mCacheTickersBlocked = true;
                    removeMessages(MSG_CACHE_TRANSACTION_TICKER);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MSG_PAUSE_CACHE_TRANSACTION 
        //Begin case MSG_RESUME_CACHE_TRANSACTION 
        {
            {
                boolean var4377346BAA1D98FC8EA6FF27F778C0A9_1158002695 = (CacheManager.enableTransaction());
                {
                    mCacheTickersBlocked = false;
                    sendEmptyMessageDelayed(MSG_CACHE_TRANSACTION_TICKER,
                            CACHE_TRANSACTION_TICKER_INTERVAL);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MSG_RESUME_CACHE_TRANSACTION 
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class CacheCreateData {
        LoadListener mListener;
        String mUrl;
        String mMimeType;
        int mStatusCode;
        long mPostId;
        Headers mHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.373 -0400", hash_original_method = "A8B9FE8F0E3A626913B6C5C039FED179", hash_generated_method = "A8B9FE8F0E3A626913B6C5C039FED179")
                public CacheCreateData ()
        {
        }


    }


    
    static class CacheSaveData {
        LoadListener mListener;
        String mUrl;
        long mPostId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.373 -0400", hash_original_method = "9F457F7FA6DE4FC42B172AA8C1A09F37", hash_generated_method = "9F457F7FA6DE4FC42B172AA8C1A09F37")
                public CacheSaveData ()
        {
        }


    }


    
    static class CacheEncoding {
        LoadListener mListener;
        String mEncoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.373 -0400", hash_original_method = "D61E898D74419C5265849133F0A37FCD", hash_generated_method = "D61E898D74419C5265849133F0A37FCD")
                public CacheEncoding ()
        {
        }


    }


    
    static class CacheData {
        LoadListener mListener;
        ByteArrayBuilder.Chunk mChunk;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:05.373 -0400", hash_original_method = "879AE3A22A9FBE656CC3DC446EC5B05F", hash_generated_method = "879AE3A22A9FBE656CC3DC446EC5B05F")
                public CacheData ()
        {
        }


    }


    
    private static final String THREAD_NAME = "WebViewWorkerThread";
    private static WebViewWorker sWorkerHandler;
    private static Map<LoadListener, CacheManager.CacheResult> mCacheResultMap
            = new HashMap<LoadListener, CacheManager.CacheResult>();
    private static final int CACHE_TRANSACTION_TICKER_INTERVAL = 60 * 1000;
    private static boolean mCacheTickersBlocked = true;
    static final int MSG_ADD_STREAMLOADER = 101;
    static final int MSG_ADD_HTTPLOADER = 102;
    static final int MSG_CREATE_CACHE = 103;
    static final int MSG_UPDATE_CACHE_ENCODING = 104;
    static final int MSG_APPEND_CACHE = 105;
    static final int MSG_SAVE_CACHE = 106;
    static final int MSG_REMOVE_CACHE = 107;
    static final int MSG_TRIM_CACHE = 108;
    static final int MSG_CLEAR_CACHE = 109;
    static final int MSG_CACHE_TRANSACTION_TICKER = 110;
    static final int MSG_PAUSE_CACHE_TRANSACTION = 111;
    static final int MSG_RESUME_CACHE_TRANSACTION = 112;
}

