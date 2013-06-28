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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.041 -0400", hash_original_method = "D7D568B3C492B7B5D5E0F8FEE23B0F62", hash_generated_method = "FC1CA988FF2A0A5639474C285FD5AFBA")
    private  WebViewWorker(Looper looper) {
        super(looper);
        addTaint(looper.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_method = "E3F221A899CA64DBBAE93DBAE213C92D", hash_generated_method = "2E6C646172FF2D958ADE03BAF08CBD0B")
    @Override
    public void handleMessage(Message msg) {
        //Begin case MSG_ADD_STREAMLOADER 
        {
            StreamLoader loader = (StreamLoader) msg.obj;
            loader.load();
        } //End block
        //End case MSG_ADD_STREAMLOADER 
        //Begin case MSG_ADD_HTTPLOADER 
        {
            FrameLoader loader = (FrameLoader) msg.obj;
            loader.handleHTTPLoad();
        } //End block
        //End case MSG_ADD_HTTPLOADER 
        //Begin case MSG_CREATE_CACHE 
        {
            CacheCreateData data = (CacheCreateData) msg.obj;
            CacheManager.CacheResult cache = CacheManager.createCacheFile(
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
            CacheEncoding data = (CacheEncoding) msg.obj;
            CacheManager.CacheResult cache = mCacheResultMap
                        .get(data.mListener);
            {
                cache.encoding = data.mEncoding;
            } //End block
        } //End block
        //End case MSG_UPDATE_CACHE_ENCODING 
        //Begin case MSG_APPEND_CACHE 
        {
            CacheData data = (CacheData) msg.obj;
            CacheManager.CacheResult cache = mCacheResultMap
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
            CacheSaveData data = (CacheSaveData) msg.obj;
            CacheManager.CacheResult cache = mCacheResultMap
                        .get(data.mListener);
            {
                CacheManager.saveCacheFile(data.mUrl, data.mPostId, cache);
                mCacheResultMap.remove(data.mListener);
            } //End block
        } //End block
        //End case MSG_SAVE_CACHE 
        //Begin case MSG_REMOVE_CACHE 
        {
            LoadListener listener = (LoadListener) msg.obj;
            CacheManager.CacheResult cache = mCacheResultMap.get(listener);
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
                boolean varFA939AFA557F3C8BDE81CB8A30FD3E26_432666081 = (CacheManager.disableTransaction());
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
                boolean var4377346BAA1D98FC8EA6FF27F778C0A9_1063095852 = (CacheManager.enableTransaction());
                {
                    mCacheTickersBlocked = false;
                    sendEmptyMessageDelayed(MSG_CACHE_TRANSACTION_TICKER,
                            CACHE_TRANSACTION_TICKER_INTERVAL);
                } //End block
            } //End collapsed parenthetic
        } //End block
        //End case MSG_RESUME_CACHE_TRANSACTION 
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    static class CacheCreateData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "B161F982909610C03B68BAACDD54E076")

        String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "7948B1EFB4AE211035F97F99CDB6078C", hash_generated_field = "FDFA4F4264773014D5F97717B076C5CB")

        int mStatusCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "88D9139BB81B87507A74ED66021EF7FB", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "9035AF409A03B14F6004C0202B58C473")

        Headers mHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_method = "ECF9CE691C1E9D0D27062E328F2071F1", hash_generated_method = "ECF9CE691C1E9D0D27062E328F2071F1")
        public CacheCreateData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheSaveData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "88D9139BB81B87507A74ED66021EF7FB", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_method = "9E757DF8F2598229E9B6588D817525F8", hash_generated_method = "9E757DF8F2598229E9B6588D817525F8")
        public CacheSaveData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheEncoding {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "532663CB004FA57020360003BD60B6E5")

        String mEncoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_method = "F4176929ED2D08D577A72138F39F258C", hash_generated_method = "F4176929ED2D08D577A72138F39F258C")
        public CacheEncoding ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "9AAC32C2595A9C136C2B2B291F82DBDA", hash_generated_field = "5B0A84D8A494BD5F08750F0C665521E6")

        ByteArrayBuilder.Chunk mChunk;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_method = "C46F5AA83A69689BFB2DC11439BD4C32", hash_generated_method = "C46F5AA83A69689BFB2DC11439BD4C32")
        public CacheData ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "2E34ADE68A1BB526AA9049AF7A62BB5B", hash_generated_field = "6746BABEC0896F6BAEB65B926D6CCDBB")

    private static final String THREAD_NAME = "WebViewWorkerThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "0B3D43E6CCFCBD2CD6C1607D8D66D377", hash_generated_field = "C9DA4AE969ACFC6C284F29220A12B86B")

    private static WebViewWorker sWorkerHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.043 -0400", hash_original_field = "A7061F8281FBF3CFA54F6B4C5DA97D49", hash_generated_field = "41D36C1690A6040A45AB2CA5B0D88030")

    private static Map<LoadListener, CacheManager.CacheResult> mCacheResultMap = new HashMap<LoadListener, CacheManager.CacheResult>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "E505431E4F705DE5C913E49B9175B10A", hash_generated_field = "02B6E52440F5DA8B82E7CF24A4C1F6E7")

    private static final int CACHE_TRANSACTION_TICKER_INTERVAL = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "F066F1AE9248920199AC06D2265F192C", hash_generated_field = "C7223AC6E98D41A51E3D016D37038A69")

    private static boolean mCacheTickersBlocked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "572EE4C9065394C1131C10891F50E868", hash_generated_field = "86598407858DB0F34C9DF81A2728C8E8")

    static final int MSG_ADD_STREAMLOADER = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "66A55D23E33B0D31A773C0CF020C8117", hash_generated_field = "7243151C23685A58AFD23D810BCDFBBC")

    static final int MSG_ADD_HTTPLOADER = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "16C1C0EC9A19CDD8F70B9CDBA213A5A2", hash_generated_field = "C851F905ECEE5E9206AE021CAA762927")

    static final int MSG_CREATE_CACHE = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "A2A3E8D61636C835FD151F5873F3AC9D", hash_generated_field = "17778FDC3C85D43A9AAEB19BCA1F66AC")

    static final int MSG_UPDATE_CACHE_ENCODING = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "5B608E6FD4ADC25B96C5E65760B3A1B1", hash_generated_field = "09EB9EFF5FA68CBCD1EA2190ED9A8E20")

    static final int MSG_APPEND_CACHE = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "757781DDD389F249E9A7A5E014A3A09B", hash_generated_field = "42F871A5FE2665652F524E20F1066275")

    static final int MSG_SAVE_CACHE = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "57FC408EE79871280C7E5F3EE6FC4ABC", hash_generated_field = "A80D06FEC831D3F9E6B6C53AC3D30B6F")

    static final int MSG_REMOVE_CACHE = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "506244A6DB1FF16C7CF9B961BE359D02", hash_generated_field = "361F466F848ED00813A513CCC6D38DBD")

    static final int MSG_TRIM_CACHE = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "F96ADD455E1C5E485CB13E64ACF635E9", hash_generated_field = "CD03C033EACA64A13BF3ACEAFB4C2D0D")

    static final int MSG_CLEAR_CACHE = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "299F9A3B637F0F3DA012479F89B1350B", hash_generated_field = "24031040F6A27EE2AC729CCB800AAC52")

    static final int MSG_CACHE_TRANSACTION_TICKER = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "EBAC16BEDB0A30A32C8CF6AD2FFDC9AF", hash_generated_field = "03513A2CBF8721C37A437D4C0C08C648")

    static final int MSG_PAUSE_CACHE_TRANSACTION = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:08.044 -0400", hash_original_field = "A7D95E515C3202A873BE9F87A368B580", hash_generated_field = "FA47F11A5A15AB1171E495F05948A0A9")

    static final int MSG_RESUME_CACHE_TRANSACTION = 112;
}

