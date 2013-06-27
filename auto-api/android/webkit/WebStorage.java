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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.974 -0400", hash_original_field = "66B6E6551149C8D18EAA0C8F6BFA4807", hash_generated_field = "37FCB2431FF7E2170127344873AA09C0")

    private Map <String, Origin> mOrigins;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.974 -0400", hash_original_field = "CE2D1D9987FFB86CFCC27E9C4CC37A4C", hash_generated_field = "A7637B18C168C40831B0C5AF31A66C87")

    private Handler mHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.974 -0400", hash_original_field = "33F4AA66F852E93F47C7B5B93ECFBE81", hash_generated_field = "CAEF8005729A037CF5EC6BF8A6C37C05")

    private Handler mUIHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:01.974 -0400", hash_original_method = "45EE8E569EE103CF8A5587A04223DD11", hash_generated_method = "45EE8E569EE103CF8A5587A04223DD11")
    public WebStorage ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.073 -0400", hash_original_method = "82D962B4566984C9EF0A3C7F9B8F70D3", hash_generated_method = "7676116626EB0F5D145BEE22E8A4A32D")
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.073 -0400", hash_original_method = "E046AB9893C69470BF91F70EA6B66946", hash_generated_method = "8D2F06EE771B26A8B4083B4F5F6E0E01")
                @Override
                public void handleMessage(Message msg) {
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
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.081 -0400", hash_original_method = "70B57611BD5998CDDC131389C1B8C529", hash_generated_method = "F40F4E994429C0EC9793C25065B630A0")
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.080 -0400", hash_original_method = "9AB12BF7A5C5C253376F63645993E150", hash_generated_method = "B3042F5591E72372E96F9D5138CCBFED")
                @Override
                public void handleMessage(Message msg) {
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
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.082 -0400", hash_original_method = "5F1CCC127056749A41D889CB5F293C72", hash_generated_method = "4177179826F6A3C085EF9561E19E37EB")
    public void getOrigins(ValueCallback<Map> callback) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1529914699 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    syncValues();
                    callback.onReceiveValue(mOrigins);
                } //End block
                {
                    postMessage(Message.obtain(null, GET_ORIGINS, callback));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(callback.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.099 -0400", hash_original_method = "20875F7A30B9C28B41BC562F884EFBD9", hash_generated_method = "404FA32671BCDC11801C9E5ECAD44A0C")
     Collection<Origin> getOriginsSync() {
        Collection<Origin> varB4EAC82CA7396A68D541C85D26508E83_1593521134 = null; //Variable for return #1
        Collection<Origin> varB4EAC82CA7396A68D541C85D26508E83_1064127093 = null; //Variable for return #2
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1254451532 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                update();
                varB4EAC82CA7396A68D541C85D26508E83_1593521134 = mOrigins.values();
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1064127093 = null;
        Collection<Origin> varA7E53CE21691AB073D9660D615818899_1725140735; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1725140735 = varB4EAC82CA7396A68D541C85D26508E83_1593521134;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1725140735 = varB4EAC82CA7396A68D541C85D26508E83_1064127093;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1725140735.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1725140735;
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //update();
            //return mOrigins.values();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.100 -0400", hash_original_method = "A830572EF5CC952FAB535A1A02FCF9EB", hash_generated_method = "707C6D46F802161F8B34391C74053C6A")
    public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_203908841 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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
        addTaint(origin.getTaint());
        addTaint(callback.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.100 -0400", hash_original_method = "BC9A85F4ABA5D3D4138B578A1B617A4F", hash_generated_method = "D4B5B9E3FC41042B27BF384415142DD4")
    public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_145338651 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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
        addTaint(origin.getTaint());
        addTaint(callback.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.101 -0400", hash_original_method = "567046E45B1707841AB709B2994EB872", hash_generated_method = "74826B412A46871C961997463C570846")
    public void setQuotaForOrigin(String origin, long quota) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1849745059 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeSetQuotaForOrigin(origin, quota);
                } //End block
                {
                    postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    new Origin(origin, quota)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(origin.getTaint());
        addTaint(quota);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.101 -0400", hash_original_method = "8BD785193E41D931D316F61464C869E4", hash_generated_method = "38F67CFA47B4826AD42A7679A90A52A4")
    public void deleteOrigin(String origin) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_757468841 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeDeleteOrigin(origin);
                } //End block
                {
                    postMessage(Message.obtain(null, DELETE_ORIGIN,
                    new Origin(origin)));
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(origin.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.101 -0400", hash_original_method = "4CABCD5AB64090C1AAA8A337FB9C39CF", hash_generated_method = "8229CB30780538BB3732555C06B830C9")
    public void deleteAllData() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_756341142 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.110 -0400", hash_original_method = "D4FAC5548D3982CA0D61EFA3641C44C0", hash_generated_method = "5A95D28E6A76210DFF46CB7B193BEEA7")
    public void setAppCacheMaximumSize(long size) {
        nativeSetAppCacheMaximumSize(size);
        addTaint(size);
        // ---------- Original Method ----------
        //nativeSetAppCacheMaximumSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.114 -0400", hash_original_method = "62EA151909BF01F1F742C4723FE70A6A", hash_generated_method = "AABEAF0AF3883F5E3B6B2DA616C9BC28")
    private synchronized void postMessage(Message msg) {
        {
            mHandler.sendMessage(msg);
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.115 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C8ED0203F18A2FA93DA4BACC33043B55")
    private void postUIMessage(Message msg) {
        {
            mUIHandler.sendMessage(msg);
        } //End block
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.115 -0400", hash_original_method = "84940B587CE35477B1887A71543D40B1", hash_generated_method = "9B7AFC97FC415ACB5ECEA3C75D966FE7")
    public void update() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1453927871 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.164 -0400", hash_original_method = "5D4FD384A27446A0E17BE685B23E3829", hash_generated_method = "0A3E0AF74B4915576BC31AECB10DABC1")
    private void syncValues() {
        Set<String> tmp;
        tmp = nativeGetOrigins();
        mOrigins = new HashMap<String, Origin>();
        {
            Iterator<String> var789D548900BFEFF21EF0DCF6799AE26E_1948176606 = (tmp).iterator();
            var789D548900BFEFF21EF0DCF6799AE26E_1948176606.hasNext();
            String origin = var789D548900BFEFF21EF0DCF6799AE26E_1948176606.next();
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.165 -0400", hash_original_field = "64750E5841B87A1C417444D299CD4440", hash_generated_field = "C0D04DE859485FC064E3233B8B61E000")

        private String mOrigin = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.165 -0400", hash_original_field = "ACDC9A01B63BF9F3D55326330A8C5FC3", hash_generated_field = "D4673897C52FB70646F861DEAEBDF4CA")

        private long mQuota = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.165 -0400", hash_original_field = "412517F55B5F125B34E008950E31C814", hash_generated_field = "3B69C5C26EF23770033686E958090CE2")

        private long mUsage = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.166 -0400", hash_original_method = "4FE78C59959DAB66D5A54195A66AB06B", hash_generated_method = "76322ED2B92E6B7663D8A0519AE3B0DF")
        private  Origin(String origin, long quota, long usage) {
            mOrigin = origin;
            mQuota = quota;
            mUsage = usage;
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
            //mUsage = usage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.166 -0400", hash_original_method = "C2CBF7E5975A0E1FB4219FCE2892FC4D", hash_generated_method = "FC09A97162600BEE334A20CD3A6FDFA1")
        private  Origin(String origin, long quota) {
            mOrigin = origin;
            mQuota = quota;
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.166 -0400", hash_original_method = "EABE3A839C363BB6725AAE2908A0D269", hash_generated_method = "231D896CFDCFAA5D10466EAE91ED23CC")
        private  Origin(String origin) {
            mOrigin = origin;
            // ---------- Original Method ----------
            //mOrigin = origin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.167 -0400", hash_original_method = "1C35B3C80693DCFAD3BBB071D3FEEF91", hash_generated_method = "C801B3AD613DF95678F1B98F68B88DC3")
        public String getOrigin() {
            String varB4EAC82CA7396A68D541C85D26508E83_1245248303 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1245248303 = mOrigin;
            varB4EAC82CA7396A68D541C85D26508E83_1245248303.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1245248303;
            // ---------- Original Method ----------
            //return mOrigin;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.167 -0400", hash_original_method = "85A4ADA77B01EE5A270890AB8ED69D00", hash_generated_method = "91AB01C3AAB7E178FBC3BCF7A2CE88B5")
        public long getQuota() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_554394619 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_554394619;
            // ---------- Original Method ----------
            //return mQuota;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_method = "9EBBDD3C0652D213E94F799A53008143", hash_generated_method = "32EFE4D17BE9F82BBF094FA2DED4059B")
        public long getUsage() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_458646055 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_458646055;
            // ---------- Original Method ----------
            //return mUsage;
        }

        
    }


    
    public interface QuotaUpdater {
        public void updateQuota(long newQuota);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "902004607D3D35BA00657C15EFA6863D", hash_generated_field = "22E1E74AC3D97D60DB7AA03685045818")

    private static String TAG = "webstorage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "BD285CA53C3AEB1EA97CC49EDB26AF94", hash_generated_field = "0CCDD741FE8F4FB31C977DCC41752D3D")

    private static WebStorage sWebStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "BE98DCB09006644549A3383ECF0F58A5", hash_generated_field = "29D6F6F075BA6A42F1B72E485286B67D")

    static int UPDATE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "B79B2D519A8F1FF73F1A94A436BD870A", hash_generated_field = "6C2C7F35CAD4EC6899ED67FFAF32A344")

    static int SET_QUOTA_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "9B72996C429AC66AEE732C78041BD80A", hash_generated_field = "133329CF0ED7F851D81750AEAD631220")

    static int DELETE_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "07FA09A7985AF455A83A10B767F6D87F", hash_generated_field = "49526463EC831A18862FE1A30F67A765")

    static int DELETE_ALL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "B7BCA5977762AF11F2C340174D2C946B", hash_generated_field = "9D80379F81279B6D35FF4476B65CEB80")

    static int GET_ORIGINS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "037B03ECBAA557B298F95212324431B6", hash_generated_field = "81785955ADA890E34D80B9F798E1E2AE")

    static int GET_USAGE_ORIGIN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "2CD8BDA81653204703E656883F9B9AB3", hash_generated_field = "32040981D8EB6D43E5A00BCA3EAA7410")

    static int GET_QUOTA_ORIGIN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.178 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "9F16B070B67AF569D45922C684F737AD")

    static int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "B723744F78D7F3DDDFCA0EFFD404ADEC", hash_generated_field = "BD76681D73BB960734A2F8E9D31DE721")

    static int RETURN_USAGE_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "4127CB68F596EEEEB8E0EF08848E0B70", hash_generated_field = "92299D695932FA68F6FEEB3E43719A23")

    static int RETURN_QUOTA_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "39B1371A7C105E08D03EF6A82E1C888B")

    private static String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "0A6ED265D5D88B00F83A73502B56BD55")

    private static String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "FC961204076FD50E79C3F05778D9F44E")

    private static String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "093E25DE57FD9F3EDFB24C5EED22C248", hash_generated_field = "849B5DCCAF98D63AFA2BB7370054CCC2")

    private static String USAGE = "usage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:02.179 -0400", hash_original_field = "48126D54606CBBF16C2A595EA1A86762", hash_generated_field = "E863D134D14B25DECC83F7192CCAEC10")

    private static String QUOTA = "quota";
}

