package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class WebStorage {
    private Map <String, Origin> mOrigins;
    private Handler mHandler = null;
    private Handler mUIHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.121 -0400", hash_original_method = "AF677EBC615A3CC551E6ED567BF454B4", hash_generated_method = "AF677EBC615A3CC551E6ED567BF454B4")
        public WebStorage ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.122 -0400", hash_original_method = "82D962B4566984C9EF0A3C7F9B8F70D3", hash_generated_method = "2892D5F8F885C4D6D078C83E086E9C70")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.122 -0400", hash_original_method = "E046AB9893C69470BF91F70EA6B66946", hash_generated_method = "A75FC48F4C2537FAC24D529952C56DBF")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case RETURN_ORIGINS 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        Map origins;
                        origins = (Map) values.get(ORIGINS);
                        ValueCallback<Map> callback;
                        callback = (ValueCallback<Map>) values.get(CALLBACK);
                        callback.onReceiveValue(origins);
                    } //End block
                    //End case RETURN_ORIGINS 
                    //Begin case RETURN_USAGE_ORIGIN 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        ValueCallback<Long> callback;
                        callback = (ValueCallback<Long>) values.get(CALLBACK);
                        callback.onReceiveValue((Long)values.get(USAGE));
                    } //End block
                    //End case RETURN_USAGE_ORIGIN 
                    //Begin case RETURN_QUOTA_ORIGIN 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        ValueCallback<Long> callback;
                        callback = (ValueCallback<Long>) values.get(CALLBACK);
                        callback.onReceiveValue((Long)values.get(QUOTA));
                    } //End block
                    //End case RETURN_QUOTA_ORIGIN 
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.124 -0400", hash_original_method = "70B57611BD5998CDDC131389C1B8C529", hash_generated_method = "775895CEFA13FE9779C3D33037AAC084")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.124 -0400", hash_original_method = "9AB12BF7A5C5C253376F63645993E150", hash_generated_method = "14BF5AA2D54B70E9DCEE4E4D5AC8D39D")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case SET_QUOTA_ORIGIN 
                    {
                        Origin website;
                        website = (Origin) msg.obj;
                        nativeSetQuotaForOrigin(website.getOrigin(),
                                                    website.getQuota());
                    } //End block
                    //End case SET_QUOTA_ORIGIN 
                    //Begin case DELETE_ORIGIN 
                    {
                        Origin website;
                        website = (Origin) msg.obj;
                        nativeDeleteOrigin(website.getOrigin());
                    } //End block
                    //End case DELETE_ORIGIN 
                    //Begin case DELETE_ALL 
                    nativeDeleteAllData();
                    //End case DELETE_ALL 
                    //Begin case GET_ORIGINS 
                    {
                        syncValues();
                        ValueCallback callback;
                        callback = (ValueCallback) msg.obj;
                        Map origins;
                        origins = new HashMap(mOrigins);
                        Map values;
                        values = new HashMap<String, Object>();
                        values.put(CALLBACK, callback);
                        values.put(ORIGINS, origins);
                        postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                    } //End block
                    //End case GET_ORIGINS 
                    //Begin case GET_USAGE_ORIGIN 
                    {
                        syncValues();
                        Map values;
                        values = (Map) msg.obj;
                        String origin;
                        origin = (String) values.get(ORIGIN);
                        ValueCallback callback;
                        callback = (ValueCallback) values.get(CALLBACK);
                        Origin website;
                        website = mOrigins.get(origin);
                        Map retValues;
                        retValues = new HashMap<String, Object>();
                        retValues.put(CALLBACK, callback);
                        {
                            long usage;
                            usage = website.getUsage();
                            retValues.put(USAGE, new Long(usage));
                        } //End block
                        postUIMessage(Message.obtain(null, RETURN_USAGE_ORIGIN, retValues));
                    } //End block
                    //End case GET_USAGE_ORIGIN 
                    //Begin case GET_QUOTA_ORIGIN 
                    {
                        syncValues();
                        Map values;
                        values = (Map) msg.obj;
                        String origin;
                        origin = (String) values.get(ORIGIN);
                        ValueCallback callback;
                        callback = (ValueCallback) values.get(CALLBACK);
                        Origin website;
                        website = mOrigins.get(origin);
                        Map retValues;
                        retValues = new HashMap<String, Object>();
                        retValues.put(CALLBACK, callback);
                        {
                            long quota;
                            quota = website.getQuota();
                            retValues.put(QUOTA, new Long(quota));
                        } //End block
                        postUIMessage(Message.obtain(null, RETURN_QUOTA_ORIGIN, retValues));
                    } //End block
                    //End case GET_QUOTA_ORIGIN 
                    //Begin case UPDATE 
                    syncValues();
                    //End case UPDATE 
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.124 -0400", hash_original_method = "5F1CCC127056749A41D889CB5F293C72", hash_generated_method = "ED4DC4E55D15C1865FD54F6313AC29CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOrigins(ValueCallback<Map> callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_449007928 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    syncValues();
                    callback.onReceiveValue(mOrigins);
                } //End block
                {
                    postMessage(Message.obtain(null, GET_ORIGINS, callback));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (callback != null) {
            //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                //syncValues();
                //callback.onReceiveValue(mOrigins);
            //} else {
                //postMessage(Message.obtain(null, GET_ORIGINS, callback));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.124 -0400", hash_original_method = "20875F7A30B9C28B41BC562F884EFBD9", hash_generated_method = "643C54BB4630FC5AF659D9E6DEB6FD6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Collection<Origin> getOriginsSync() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_370870897 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                update();
                Collection<Origin> var71C6E1E63A866322A504639A75DBBCBA_2096141864 = (mOrigins.values());
            } //End block
        } //End collapsed parenthetic
        return (Collection<Origin>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //update();
            //return mOrigins.values();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.125 -0400", hash_original_method = "A830572EF5CC952FAB535A1A02FCF9EB", hash_generated_method = "70BB2E27BAB631509BC875341C240A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(origin);
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_744912035 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
                Origin website;
                website = mOrigins.get(origin);
                callback.onReceiveValue(new Long(website.getUsage()));
            } //End block
            {
                HashMap values;
                values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_USAGE_ORIGIN, values));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (callback == null) {
            //return;
        //}
        //if (origin == null) {
            //callback.onReceiveValue(null);
            //return;
        //}
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //syncValues();
            //Origin website = mOrigins.get(origin);
            //callback.onReceiveValue(new Long(website.getUsage()));
        //} else {
            //HashMap values = new HashMap<String, Object>();
            //values.put(ORIGIN, origin);
            //values.put(CALLBACK, callback);
            //postMessage(Message.obtain(null, GET_USAGE_ORIGIN, values));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.125 -0400", hash_original_method = "BC9A85F4ABA5D3D4138B578A1B617A4F", hash_generated_method = "FC7AA367CDE03D5C9F95A8376A7F952C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(origin);
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1595550241 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
                Origin website;
                website = mOrigins.get(origin);
                callback.onReceiveValue(new Long(website.getUsage()));
            } //End block
            {
                HashMap values;
                values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_QUOTA_ORIGIN, values));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (callback == null) {
            //return;
        //}
        //if (origin == null) {
            //callback.onReceiveValue(null);
            //return;
        //}
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //syncValues();
            //Origin website = mOrigins.get(origin);
            //callback.onReceiveValue(new Long(website.getUsage()));
        //} else {
            //HashMap values = new HashMap<String, Object>();
            //values.put(ORIGIN, origin);
            //values.put(CALLBACK, callback);
            //postMessage(Message.obtain(null, GET_QUOTA_ORIGIN, values));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.125 -0400", hash_original_method = "567046E45B1707841AB709B2994EB872", hash_generated_method = "AECF9ED76B9FD12263DCE1C0A7CA189B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setQuotaForOrigin(String origin, long quota) {
        dsTaint.addTaint(quota);
        dsTaint.addTaint(origin);
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_150776210 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeSetQuotaForOrigin(origin, quota);
                } //End block
                {
                    postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    new Origin(origin, quota)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (origin != null) {
            //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                //nativeSetQuotaForOrigin(origin, quota);
            //} else {
                //postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    //new Origin(origin, quota)));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.126 -0400", hash_original_method = "8BD785193E41D931D316F61464C869E4", hash_generated_method = "B7C2356945BDAC0AB1979EF30A547A4F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteOrigin(String origin) {
        dsTaint.addTaint(origin);
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_2059434506 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeDeleteOrigin(origin);
                } //End block
                {
                    postMessage(Message.obtain(null, DELETE_ORIGIN,
                    new Origin(origin)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (origin != null) {
            //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                //nativeDeleteOrigin(origin);
            //} else {
                //postMessage(Message.obtain(null, DELETE_ORIGIN,
                    //new Origin(origin)));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.126 -0400", hash_original_method = "4CABCD5AB64090C1AAA8A337FB9C39CF", hash_generated_method = "635BA26865F8F423ED94D4D22FB61B03")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void deleteAllData() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_2063639216 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                nativeDeleteAllData();
            } //End block
            {
                postMessage(Message.obtain(null, DELETE_ALL));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //nativeDeleteAllData();
        //} else {
            //postMessage(Message.obtain(null, DELETE_ALL));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.126 -0400", hash_original_method = "D4FAC5548D3982CA0D61EFA3641C44C0", hash_generated_method = "AD8152FE12EFCDB9CE4ED56FA2359A7A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAppCacheMaximumSize(long size) {
        dsTaint.addTaint(size);
        nativeSetAppCacheMaximumSize(size);
        // ---------- Original Method ----------
        //nativeSetAppCacheMaximumSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.126 -0400", hash_original_method = "62EA151909BF01F1F742C4723FE70A6A", hash_generated_method = "A43E1E5834FC7C995D45369AFF9441E0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void postMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            mHandler.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.126 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "D3A1BC112B6E8C3022B55DEFC2DD77BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void postUIMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            mUIHandler.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mUIHandler != null) {
            //mUIHandler.sendMessage(msg);
        //}
    }

    
        public static WebStorage getInstance() {
        if (sWebStorage == null) {
          sWebStorage = new WebStorage();
      }
        return sWebStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.127 -0400", hash_original_method = "84940B587CE35477B1887A71543D40B1", hash_generated_method = "CC75F08F15DE1198C3F2717B4299F3C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void update() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1335810743 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
            } //End block
            {
                postMessage(Message.obtain(null, UPDATE));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //syncValues();
        //} else {
            //postMessage(Message.obtain(null, UPDATE));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.131 -0400", hash_original_method = "5D4FD384A27446A0E17BE685B23E3829", hash_generated_method = "FE95C253A21E7D621E1D7DB095602F3B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void syncValues() {
        Set<String> tmp;
        tmp = nativeGetOrigins();
        mOrigins = new HashMap<String, Origin>();
        {
            Iterator<String> var789D548900BFEFF21EF0DCF6799AE26E_831630968 = (tmp).iterator();
            var789D548900BFEFF21EF0DCF6799AE26E_831630968.hasNext();
            String origin = var789D548900BFEFF21EF0DCF6799AE26E_831630968.next();
            {
                Origin website;
                website = new Origin(origin,
                                 nativeGetQuotaForOrigin(origin),
                                 nativeGetUsageForOrigin(origin));
                mOrigins.put(origin, website);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //Set<String> tmp = nativeGetOrigins();
        //mOrigins = new HashMap<String, Origin>();
        //for (String origin : tmp) {
            //Origin website = new Origin(origin,
                                 //nativeGetQuotaForOrigin(origin),
                                 //nativeGetUsageForOrigin(origin));
            //mOrigins.put(origin, website);
        //}
    }

    
        private static Set nativeGetOrigins() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static long nativeGetUsageForOrigin(String origin) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static long nativeGetQuotaForOrigin(String origin) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        private static void nativeSetQuotaForOrigin(String origin, long quota) {
    }

    
        private static void nativeDeleteOrigin(String origin) {
    }

    
        private static void nativeDeleteAllData() {
    }

    
        private static void nativeSetAppCacheMaximumSize(long size) {
    }

    
    public static class Origin {
        private String mOrigin = null;
        private long mQuota = 0;
        private long mUsage = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.132 -0400", hash_original_method = "4FE78C59959DAB66D5A54195A66AB06B", hash_generated_method = "30EBE39D896BB259F0828533693F5466")
        @DSModeled(DSC.SAFE)
        private Origin(String origin, long quota, long usage) {
            dsTaint.addTaint(quota);
            dsTaint.addTaint(origin);
            dsTaint.addTaint(usage);
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
            //mUsage = usage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.133 -0400", hash_original_method = "C2CBF7E5975A0E1FB4219FCE2892FC4D", hash_generated_method = "55FD9FAF2E3FA8A112BC61D17024CE34")
        @DSModeled(DSC.SAFE)
        private Origin(String origin, long quota) {
            dsTaint.addTaint(quota);
            dsTaint.addTaint(origin);
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.133 -0400", hash_original_method = "EABE3A839C363BB6725AAE2908A0D269", hash_generated_method = "957100BF90759AA79509A454A78EE674")
        @DSModeled(DSC.SAFE)
        private Origin(String origin) {
            dsTaint.addTaint(origin);
            // ---------- Original Method ----------
            //mOrigin = origin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.133 -0400", hash_original_method = "1C35B3C80693DCFAD3BBB071D3FEEF91", hash_generated_method = "9B237BC95F902A42A21CC3CE8E4DB448")
        @DSModeled(DSC.SAFE)
        public String getOrigin() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mOrigin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.133 -0400", hash_original_method = "85A4ADA77B01EE5A270890AB8ED69D00", hash_generated_method = "39EAD895C3066DD9853953FBFFA918B3")
        @DSModeled(DSC.SAFE)
        public long getQuota() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mQuota;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:04.134 -0400", hash_original_method = "9EBBDD3C0652D213E94F799A53008143", hash_generated_method = "C315242607C32945D98BA93C3B1A989B")
        @DSModeled(DSC.SAFE)
        public long getUsage() {
            return dsTaint.getTaintLong();
            // ---------- Original Method ----------
            //return mUsage;
        }

        
    }


    
    public interface QuotaUpdater {
        public void updateQuota(long newQuota);
    }
    
    private static final String TAG = "webstorage";
    private static WebStorage sWebStorage;
    static final int UPDATE = 0;
    static final int SET_QUOTA_ORIGIN = 1;
    static final int DELETE_ORIGIN = 2;
    static final int DELETE_ALL = 3;
    static final int GET_ORIGINS = 4;
    static final int GET_USAGE_ORIGIN = 5;
    static final int GET_QUOTA_ORIGIN = 6;
    static final int RETURN_ORIGINS = 0;
    static final int RETURN_USAGE_ORIGIN = 1;
    static final int RETURN_QUOTA_ORIGIN = 2;
    private static final String ORIGINS = "origins";
    private static final String ORIGIN = "origin";
    private static final String CALLBACK = "callback";
    private static final String USAGE = "usage";
    private static final String QUOTA = "quota";
}

