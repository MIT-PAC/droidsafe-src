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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.619 -0400", hash_original_method = "D7D568B3C492B7B5D5E0F8FEE23B0F62", hash_generated_method = "FC1CA988FF2A0A5639474C285FD5AFBA")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.629 -0400", hash_original_method = "E3F221A899CA64DBBAE93DBAE213C92D", hash_generated_method = "992CEF70127D670F4A387F7C296C942E")
    @Override
    public void handleMessage(Message msg) {
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
                boolean varFA939AFA557F3C8BDE81CB8A30FD3E26_1975410012 = (CacheManager.disableTransaction());
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
                boolean var4377346BAA1D98FC8EA6FF27F778C0A9_1775171118 = (CacheManager.enableTransaction());
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "FA38F1960A45A7EC16349AAF783A80BC", hash_generated_field = "B161F982909610C03B68BAACDD54E076")

        String mMimeType;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "7948B1EFB4AE211035F97F99CDB6078C", hash_generated_field = "FDFA4F4264773014D5F97717B076C5CB")

        int mStatusCode;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "88D9139BB81B87507A74ED66021EF7FB", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "9DA6583E4F64A78649E80D72BFE1DBCC", hash_generated_field = "9035AF409A03B14F6004C0202B58C473")

        Headers mHeaders;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_method = "ECF9CE691C1E9D0D27062E328F2071F1", hash_generated_method = "ECF9CE691C1E9D0D27062E328F2071F1")
        public CacheCreateData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheSaveData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.630 -0400", hash_original_field = "8299C83E9CFFA2EF5909444648349221", hash_generated_field = "CA88DB4A75B79130313A74537195706C")

        String mUrl;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "88D9139BB81B87507A74ED66021EF7FB", hash_generated_field = "91EFC443935348EC9C940765764CA60B")

        long mPostId;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_method = "9E757DF8F2598229E9B6588D817525F8", hash_generated_method = "9E757DF8F2598229E9B6588D817525F8")
        public CacheSaveData ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheEncoding {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "FF7D0B646B2C057679C99D4079D890AA", hash_generated_field = "532663CB004FA57020360003BD60B6E5")

        String mEncoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_method = "F4176929ED2D08D577A72138F39F258C", hash_generated_method = "F4176929ED2D08D577A72138F39F258C")
        public CacheEncoding ()
        {
            //Synthesized constructor
        }


    }


    
    static class CacheData {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "9B3DD33B99719CE65C53FA6749E2AD69", hash_generated_field = "6F634748B2632997CFA3BD470A985F63")

        LoadListener mListener;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "9AAC32C2595A9C136C2B2B291F82DBDA", hash_generated_field = "5B0A84D8A494BD5F08750F0C665521E6")

        ByteArrayBuilder.Chunk mChunk;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_method = "C46F5AA83A69689BFB2DC11439BD4C32", hash_generated_method = "C46F5AA83A69689BFB2DC11439BD4C32")
        public CacheData ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "2E34ADE68A1BB526AA9049AF7A62BB5B", hash_generated_field = "A813965CE81132F783F0EC6371D4A662")

    private static String THREAD_NAME = "WebViewWorkerThread";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "0B3D43E6CCFCBD2CD6C1607D8D66D377", hash_generated_field = "C9DA4AE969ACFC6C284F29220A12B86B")

    private static WebViewWorker sWorkerHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "A7061F8281FBF3CFA54F6B4C5DA97D49", hash_generated_field = "41D36C1690A6040A45AB2CA5B0D88030")

    private static Map<LoadListener, CacheManager.CacheResult> mCacheResultMap = new HashMap<LoadListener, CacheManager.CacheResult>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "E505431E4F705DE5C913E49B9175B10A", hash_generated_field = "C9970E209557D4F14E468E0647D86652")

    private static int CACHE_TRANSACTION_TICKER_INTERVAL = 60 * 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "F066F1AE9248920199AC06D2265F192C", hash_generated_field = "C7223AC6E98D41A51E3D016D37038A69")

    private static boolean mCacheTickersBlocked = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "572EE4C9065394C1131C10891F50E868", hash_generated_field = "823BD4C99FC60DB2B614C12E7851A1E0")

    static int MSG_ADD_STREAMLOADER = 101;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "66A55D23E33B0D31A773C0CF020C8117", hash_generated_field = "E9798C123F4686F798FE007A651FF5E5")

    static int MSG_ADD_HTTPLOADER = 102;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.631 -0400", hash_original_field = "16C1C0EC9A19CDD8F70B9CDBA213A5A2", hash_generated_field = "DC01B0F43C8DFBF0515F68A7D69ADC3F")

    static int MSG_CREATE_CACHE = 103;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "A2A3E8D61636C835FD151F5873F3AC9D", hash_generated_field = "7D6772E8E83F166A2683972638D33871")

    static int MSG_UPDATE_CACHE_ENCODING = 104;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "5B608E6FD4ADC25B96C5E65760B3A1B1", hash_generated_field = "A2E060713516516DE9BE343B17EFBB91")

    static int MSG_APPEND_CACHE = 105;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "757781DDD389F249E9A7A5E014A3A09B", hash_generated_field = "8A829F3564B00F565B9D78778EB3F750")

    static int MSG_SAVE_CACHE = 106;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "57FC408EE79871280C7E5F3EE6FC4ABC", hash_generated_field = "C5C48B10492083FF6028B32F0BE00FAE")

    static int MSG_REMOVE_CACHE = 107;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "506244A6DB1FF16C7CF9B961BE359D02", hash_generated_field = "5EFC81365DA1A3A27188C920B870903A")

    static int MSG_TRIM_CACHE = 108;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "F96ADD455E1C5E485CB13E64ACF635E9", hash_generated_field = "F15DE54351F7795F8C14C07D84140BC3")

    static int MSG_CLEAR_CACHE = 109;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.642 -0400", hash_original_field = "299F9A3B637F0F3DA012479F89B1350B", hash_generated_field = "D642A905702DEF00B4B36E106DA12559")

    static int MSG_CACHE_TRANSACTION_TICKER = 110;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.643 -0400", hash_original_field = "EBAC16BEDB0A30A32C8CF6AD2FFDC9AF", hash_generated_field = "182F6270FB90F9F6ECDB71872C4E0A46")

    static int MSG_PAUSE_CACHE_TRANSACTION = 111;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.643 -0400", hash_original_field = "A7D95E515C3202A873BE9F87A368B580", hash_generated_field = "D7F2AA021DDF0C656892C801217A6604")

    static int MSG_RESUME_CACHE_TRANSACTION = 112;
}

