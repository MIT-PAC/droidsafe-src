package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import android.net.http.Headers;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;



final class WebViewWorker extends Handler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.458 -0500", hash_original_method = "6EA1A03C933C6378F381FBDA824C6664", hash_generated_method = "C5377368D5F0C777E790653720C1F6DE")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.416 -0500", hash_original_field = "1B649F308D1F94A687056AFEE2F4D0B8", hash_generated_field = "6746BABEC0896F6BAEB65B926D6CCDBB")


    private static final String THREAD_NAME = "WebViewWorkerThread";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.418 -0500", hash_original_field = "1554AE612E1BC4D3E1B4409130F43F24", hash_generated_field = "C9DA4AE969ACFC6C284F29220A12B86B")


    private static WebViewWorker sWorkerHandler;

    
    static class CacheCreateData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.423 -0500", hash_original_field = "6F634748B2632997CFA3BD470A985F63", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.425 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.427 -0500", hash_original_field = "B161F982909610C03B68BAACDD54E076", hash_generated_field = "B161F982909610C03B68BAACDD54E076")

        String mMimeType;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.429 -0500", hash_original_field = "FDFA4F4264773014D5F97717B076C5CB", hash_generated_field = "FDFA4F4264773014D5F97717B076C5CB")

        int mStatusCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.432 -0500", hash_original_field = "91EFC443935348EC9C940765764CA60B", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.434 -0500", hash_original_field = "9035AF409A03B14F6004C0202B58C473", hash_generated_field = "9035AF409A03B14F6004C0202B58C473")

        Headers mHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.551 -0400", hash_original_method = "ECF9CE691C1E9D0D27062E328F2071F1", hash_generated_method = "ECF9CE691C1E9D0D27062E328F2071F1")
        public CacheCreateData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheSaveData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.438 -0500", hash_original_field = "6F634748B2632997CFA3BD470A985F63", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.440 -0500", hash_original_field = "CA88DB4A75B79130313A74537195706C", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.442 -0500", hash_original_field = "91EFC443935348EC9C940765764CA60B", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.552 -0400", hash_original_method = "9E757DF8F2598229E9B6588D817525F8", hash_generated_method = "9E757DF8F2598229E9B6588D817525F8")
        public CacheSaveData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheEncoding {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.446 -0500", hash_original_field = "6F634748B2632997CFA3BD470A985F63", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.449 -0500", hash_original_field = "532663CB004FA57020360003BD60B6E5", hash_generated_field = "532663CB004FA57020360003BD60B6E5")

        String mEncoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.552 -0400", hash_original_method = "F4176929ED2D08D577A72138F39F258C", hash_generated_method = "F4176929ED2D08D577A72138F39F258C")
        public CacheEncoding ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheData {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.453 -0500", hash_original_field = "6F634748B2632997CFA3BD470A985F63", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.455 -0500", hash_original_field = "5B0A84D8A494BD5F08750F0C665521E6", hash_generated_field = "5B0A84D8A494BD5F08750F0C665521E6")

        ByteArrayBuilder.Chunk mChunk;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:56.553 -0400", hash_original_method = "C46F5AA83A69689BFB2DC11439BD4C32", hash_generated_method = "C46F5AA83A69689BFB2DC11439BD4C32")
        public CacheData ()
        {
            //Synthesized constructor
        }


    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.421 -0500", hash_original_field = "511DC5A19BDBC686AF16C0423C398C2C", hash_generated_field = "41D36C1690A6040A45AB2CA5B0D88030")


    private static Map<LoadListener, CacheManager.CacheResult> mCacheResultMap
            = new HashMap<LoadListener, CacheManager.CacheResult>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.463 -0500", hash_original_field = "F5E8D7B631E0F308031CB4CD2BD66592", hash_generated_field = "02B6E52440F5DA8B82E7CF24A4C1F6E7")

    private static final int CACHE_TRANSACTION_TICKER_INTERVAL = 60 * 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.465 -0500", hash_original_field = "8AECF04FB0D15E202F8AEBD389A86831", hash_generated_field = "C7223AC6E98D41A51E3D016D37038A69")


    private static boolean mCacheTickersBlocked = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.468 -0500", hash_original_field = "F20D1222B76F06BB723026195239CA9E", hash_generated_field = "86598407858DB0F34C9DF81A2728C8E8")

    static final int MSG_ADD_STREAMLOADER = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.470 -0500", hash_original_field = "FCB8DDCA109E52119A25262C9EE20759", hash_generated_field = "7243151C23685A58AFD23D810BCDFBBC")

    static final int MSG_ADD_HTTPLOADER = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.473 -0500", hash_original_field = "2B6DC44726547045B0FB0208A871D5ED", hash_generated_field = "C851F905ECEE5E9206AE021CAA762927")

    static final int MSG_CREATE_CACHE = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.475 -0500", hash_original_field = "E5292C86D12763502ED6842C883745B4", hash_generated_field = "17778FDC3C85D43A9AAEB19BCA1F66AC")

    static final int MSG_UPDATE_CACHE_ENCODING = 104;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.477 -0500", hash_original_field = "CA143513A2C5E877B60CFB0FC137122E", hash_generated_field = "09EB9EFF5FA68CBCD1EA2190ED9A8E20")

    static final int MSG_APPEND_CACHE = 105;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.479 -0500", hash_original_field = "A42998502D91333C86C3BF651EA4F3E5", hash_generated_field = "42F871A5FE2665652F524E20F1066275")

    static final int MSG_SAVE_CACHE = 106;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.481 -0500", hash_original_field = "097C2A943CE97752A87F5282752AA414", hash_generated_field = "A80D06FEC831D3F9E6B6C53AC3D30B6F")

    static final int MSG_REMOVE_CACHE = 107;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.483 -0500", hash_original_field = "A5E094E00FEA1CA2EA0B18C59FEA857A", hash_generated_field = "361F466F848ED00813A513CCC6D38DBD")

    static final int MSG_TRIM_CACHE = 108;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.486 -0500", hash_original_field = "8C9CD09F354C002D3F270C65C640D53C", hash_generated_field = "CD03C033EACA64A13BF3ACEAFB4C2D0D")

    static final int MSG_CLEAR_CACHE = 109;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.488 -0500", hash_original_field = "CB9A3E4EBD8FDC5C1907AE627E9ED2C6", hash_generated_field = "24031040F6A27EE2AC729CCB800AAC52")

    static final int MSG_CACHE_TRANSACTION_TICKER = 110;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.490 -0500", hash_original_field = "5195DB47FC96EF7D5C54BDEC37B67C3D", hash_generated_field = "03513A2CBF8721C37A437D4C0C08C648")

    static final int MSG_PAUSE_CACHE_TRANSACTION = 111;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.493 -0500", hash_original_field = "0DD9AF145A9C8C24B4A192402C6DDA18", hash_generated_field = "FA47F11A5A15AB1171E495F05948A0A9")

    static final int MSG_RESUME_CACHE_TRANSACTION = 112;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.461 -0500", hash_original_method = "D7D568B3C492B7B5D5E0F8FEE23B0F62", hash_generated_method = "F417D69BF3705C133B8645804DC0EBF3")
    
private WebViewWorker(Looper looper) {
        super(looper);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:42.497 -0500", hash_original_method = "E3F221A899CA64DBBAE93DBAE213C92D", hash_generated_method = "A72FCF2F0EA8646DCA86E9E58908035A")
    
@Override
    public void handleMessage(Message msg) {
        switch(msg.what) {
            case MSG_ADD_STREAMLOADER: {
                StreamLoader loader = (StreamLoader) msg.obj;
                loader.load();
                break;
            }
            case MSG_ADD_HTTPLOADER: {
                FrameLoader loader = (FrameLoader) msg.obj;
                loader.handleHTTPLoad();
                break;
            }
            case MSG_CREATE_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                CacheCreateData data = (CacheCreateData) msg.obj;
                CacheManager.CacheResult cache = CacheManager.createCacheFile(
                        data.mUrl, data.mStatusCode, data.mHeaders,
                        data.mMimeType, data.mPostId, false);
                if (cache != null) {
                    mCacheResultMap.put(data.mListener, cache);
                } else {
                    mCacheResultMap.remove(data.mListener);
                }
                break;
            }
            case MSG_UPDATE_CACHE_ENCODING: {
                assert !JniUtil.useChromiumHttpStack();
                CacheEncoding data = (CacheEncoding) msg.obj;
                CacheManager.CacheResult cache = mCacheResultMap
                        .get(data.mListener);
                if (cache != null) {
                    cache.encoding = data.mEncoding;
                }
                break;
            }
            case MSG_APPEND_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                CacheData data = (CacheData) msg.obj;
                CacheManager.CacheResult cache = mCacheResultMap
                        .get(data.mListener);
                if (cache != null) {
                    cache.contentLength += data.mChunk.mLength;
                    if (cache.contentLength > CacheManager.CACHE_MAX_SIZE) {
                        CacheManager.cleanupCacheFile(cache);
                        mCacheResultMap.remove(data.mListener);
                    } else {
                        try {
                            cache.outStream.write(data.mChunk.mArray, 0,
                                    data.mChunk.mLength);
                        } catch (IOException e) {
                            CacheManager.cleanupCacheFile(cache);
                            mCacheResultMap.remove(data.mListener);
                        }
                    }
                }
                data.mChunk.release();
                break;
            }
            case MSG_SAVE_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                CacheSaveData data = (CacheSaveData) msg.obj;
                CacheManager.CacheResult cache = mCacheResultMap
                        .get(data.mListener);
                if (cache != null) {
                    CacheManager.saveCacheFile(data.mUrl, data.mPostId, cache);
                    mCacheResultMap.remove(data.mListener);
                }
                break;
            }
            case MSG_REMOVE_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                LoadListener listener = (LoadListener) msg.obj;
                CacheManager.CacheResult cache = mCacheResultMap.get(listener);
                if (cache != null) {
                    CacheManager.cleanupCacheFile(cache);
                    mCacheResultMap.remove(listener);
                }
                break;
            }
            case MSG_TRIM_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                CacheManager.trimCacheIfNeeded();
                break;
            }
            case MSG_CLEAR_CACHE: {
                assert !JniUtil.useChromiumHttpStack();
                CacheManager.clearCache();
                break;
            }
            case MSG_CACHE_TRANSACTION_TICKER: {
                assert !JniUtil.useChromiumHttpStack();
                if (!mCacheTickersBlocked) {
                    CacheManager.endTransaction();
                    CacheManager.startTransaction();
                    sendEmptyMessageDelayed(MSG_CACHE_TRANSACTION_TICKER,
                            CACHE_TRANSACTION_TICKER_INTERVAL);
                }
                break;
            }
            case MSG_PAUSE_CACHE_TRANSACTION: {
                assert !JniUtil.useChromiumHttpStack();
                if (CacheManager.disableTransaction()) {
                    mCacheTickersBlocked = true;
                    removeMessages(MSG_CACHE_TRANSACTION_TICKER);
                }
                break;
            }
            case MSG_RESUME_CACHE_TRANSACTION: {
                assert !JniUtil.useChromiumHttpStack();
                if (CacheManager.enableTransaction()) {
                    mCacheTickersBlocked = false;
                    sendEmptyMessageDelayed(MSG_CACHE_TRANSACTION_TICKER,
                            CACHE_TRANSACTION_TICKER_INTERVAL);
                }
                break;
            }
        }
    }
}

