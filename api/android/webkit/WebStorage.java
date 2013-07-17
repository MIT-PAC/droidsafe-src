package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.805 -0400", hash_original_field = "66B6E6551149C8D18EAA0C8F6BFA4807", hash_generated_field = "37FCB2431FF7E2170127344873AA09C0")

    private Map <String, Origin> mOrigins;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.805 -0400", hash_original_field = "CE2D1D9987FFB86CFCC27E9C4CC37A4C", hash_generated_field = "A7637B18C168C40831B0C5AF31A66C87")

    private Handler mHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.806 -0400", hash_original_field = "33F4AA66F852E93F47C7B5B93ECFBE81", hash_generated_field = "CAEF8005729A037CF5EC6BF8A6C37C05")

    private Handler mUIHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.806 -0400", hash_original_method = "45EE8E569EE103CF8A5587A04223DD11", hash_generated_method = "45EE8E569EE103CF8A5587A04223DD11")
    public WebStorage ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.807 -0400", hash_original_method = "82D962B4566984C9EF0A3C7F9B8F70D3", hash_generated_method = "1361F53C78361B29A036A967D022A0E3")
    public void createUIHandler() {
        if(mUIHandler == null)        
        {
            mUIHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.807 -0400", hash_original_method = "E046AB9893C69470BF91F70EA6B66946", hash_generated_method = "59D9A770356CFCA0288BB67A27783270")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case RETURN_ORIGINS:
            {
                Map values = (Map) msg.obj;
                Map origins = (Map) values.get(ORIGINS);
                ValueCallback<Map> callback = (ValueCallback<Map>) values.get(CALLBACK);
                callback.onReceiveValue(origins);
            } //End block
            break;
            case RETURN_USAGE_ORIGIN:
            {
                Map values = (Map) msg.obj;
                ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                callback.onReceiveValue((Long)values.get(USAGE));
            } //End block
            break;
            case RETURN_QUOTA_ORIGIN:
            {
                Map values = (Map) msg.obj;
                ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                callback.onReceiveValue((Long)values.get(QUOTA));
            } //End block
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.810 -0400", hash_original_method = "70B57611BD5998CDDC131389C1B8C529", hash_generated_method = "C7CE16D448A9DB91915B41207A67F1A4")
    public synchronized void createHandler() {
        if(mHandler == null)        
        {
            mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.809 -0400", hash_original_method = "9AB12BF7A5C5C253376F63645993E150", hash_generated_method = "F8D8DDD94D95564550152BCA20CF35BB")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case SET_QUOTA_ORIGIN:
            {
                Origin website = (Origin) msg.obj;
                nativeSetQuotaForOrigin(website.getOrigin(),
                                                    website.getQuota());
            } //End block
            break;
            case DELETE_ORIGIN:
            {
                Origin website = (Origin) msg.obj;
                nativeDeleteOrigin(website.getOrigin());
            } //End block
            break;
            case DELETE_ALL:
            nativeDeleteAllData();
            break;
            case GET_ORIGINS:
            {
                syncValues();
                ValueCallback callback = (ValueCallback) msg.obj;
                Map origins = new HashMap(mOrigins);
                Map values = new HashMap<String, Object>();
                values.put(CALLBACK, callback);
                values.put(ORIGINS, origins);
                postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
            } //End block
            break;
            case GET_USAGE_ORIGIN:
            {
                syncValues();
                Map values = (Map) msg.obj;
                String origin = (String) values.get(ORIGIN);
                ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                Origin website = mOrigins.get(origin);
                Map retValues = new HashMap<String, Object>();
                retValues.put(CALLBACK, callback);
                if(website != null)                
                {
                    long usage = website.getUsage();
                    retValues.put(USAGE, new Long(usage));
                } //End block
                postUIMessage(Message.obtain(null, RETURN_USAGE_ORIGIN, retValues));
            } //End block
            break;
            case GET_QUOTA_ORIGIN:
            {
                syncValues();
                Map values = (Map) msg.obj;
                String origin = (String) values.get(ORIGIN);
                ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                Origin website = mOrigins.get(origin);
                Map retValues = new HashMap<String, Object>();
                retValues.put(CALLBACK, callback);
                if(website != null)                
                {
                    long quota = website.getQuota();
                    retValues.put(QUOTA, new Long(quota));
                } //End block
                postUIMessage(Message.obtain(null, RETURN_QUOTA_ORIGIN, retValues));
            } //End block
            break;
            case UPDATE:
            syncValues();
            break;
}
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.821 -0400", hash_original_method = "5F1CCC127056749A41D889CB5F293C72", hash_generated_method = "7135AA3753F051E88431B8D226C14A5A")
    public void getOrigins(ValueCallback<Map> callback) {
        addTaint(callback.getTaint());
        if(callback != null)        
        {
            if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))            
            {
                syncValues();
                callback.onReceiveValue(mOrigins);
            } //End block
            else
            {
                postMessage(Message.obtain(null, GET_ORIGINS, callback));
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.821 -0400", hash_original_method = "20875F7A30B9C28B41BC562F884EFBD9", hash_generated_method = "CB761D7DF97BA172D48145D8D32C58A7")
     Collection<Origin> getOriginsSync() {
        if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            update();
Collection<Origin> var61DF9E5DBF822A2FCBA15065C576D831_33735556 =             mOrigins.values();
            var61DF9E5DBF822A2FCBA15065C576D831_33735556.addTaint(taint);
            return var61DF9E5DBF822A2FCBA15065C576D831_33735556;
        } //End block
Collection<Origin> var540C13E9E156B687226421B24F2DF178_1642933525 =         null;
        var540C13E9E156B687226421B24F2DF178_1642933525.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1642933525;
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //update();
            //return mOrigins.values();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.821 -0400", hash_original_method = "A830572EF5CC952FAB535A1A02FCF9EB", hash_generated_method = "EE86C4FDB830E4F2505626B1E0F3D829")
    public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
        addTaint(callback.getTaint());
        addTaint(origin.getTaint());
        if(callback == null)        
        {
            return;
        } //End block
        if(origin == null)        
        {
            callback.onReceiveValue(null);
            return;
        } //End block
        if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            syncValues();
            Origin website = mOrigins.get(origin);
            callback.onReceiveValue(new Long(website.getUsage()));
        } //End block
        else
        {
            HashMap values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_USAGE_ORIGIN, values));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "BC9A85F4ABA5D3D4138B578A1B617A4F", hash_generated_method = "E111DCFD1B1DB2C2C4AD207101689B2A")
    public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
        addTaint(callback.getTaint());
        addTaint(origin.getTaint());
        if(callback == null)        
        {
            return;
        } //End block
        if(origin == null)        
        {
            callback.onReceiveValue(null);
            return;
        } //End block
        if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            syncValues();
            Origin website = mOrigins.get(origin);
            callback.onReceiveValue(new Long(website.getUsage()));
        } //End block
        else
        {
            HashMap values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_QUOTA_ORIGIN, values));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "567046E45B1707841AB709B2994EB872", hash_generated_method = "62CE32A563C6095B46F25FB1E90486C6")
    public void setQuotaForOrigin(String origin, long quota) {
        addTaint(quota);
        addTaint(origin.getTaint());
        if(origin != null)        
        {
            if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))            
            {
                nativeSetQuotaForOrigin(origin, quota);
            } //End block
            else
            {
                postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    new Origin(origin, quota)));
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "8BD785193E41D931D316F61464C869E4", hash_generated_method = "2CDD408A3B5CFECEA5040E50F20E3D07")
    public void deleteOrigin(String origin) {
        addTaint(origin.getTaint());
        if(origin != null)        
        {
            if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))            
            {
                nativeDeleteOrigin(origin);
            } //End block
            else
            {
                postMessage(Message.obtain(null, DELETE_ORIGIN,
                    new Origin(origin)));
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "4CABCD5AB64090C1AAA8A337FB9C39CF", hash_generated_method = "22C35A22D212FA5D5952EDE52ECB395A")
    public void deleteAllData() {
        if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            nativeDeleteAllData();
        } //End block
        else
        {
            postMessage(Message.obtain(null, DELETE_ALL));
        } //End block
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //nativeDeleteAllData();
        //} else {
            //postMessage(Message.obtain(null, DELETE_ALL));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "D4FAC5548D3982CA0D61EFA3641C44C0", hash_generated_method = "CE33C07070234D7974A758A711424F58")
    public void setAppCacheMaximumSize(long size) {
        addTaint(size);
        nativeSetAppCacheMaximumSize(size);
        // ---------- Original Method ----------
        //nativeSetAppCacheMaximumSize(size);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.822 -0400", hash_original_method = "62EA151909BF01F1F742C4723FE70A6A", hash_generated_method = "3F4124122CD649158C5EEF1F52FBF08C")
    private synchronized void postMessage(Message msg) {
        addTaint(msg.getTaint());
        if(mHandler != null)        
        {
            mHandler.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mHandler != null) {
            //mHandler.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.823 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "1C7FA8D0FDD7047080CA6C74911CEC8A")
    private void postUIMessage(Message msg) {
        addTaint(msg.getTaint());
        if(mUIHandler != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.823 -0400", hash_original_method = "84940B587CE35477B1887A71543D40B1", hash_generated_method = "793F436C59511EDDA2ADF23E1E896BC1")
    public void update() {
        if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            syncValues();
        } //End block
        else
        {
            postMessage(Message.obtain(null, UPDATE));
        } //End block
        // ---------- Original Method ----------
        //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            //syncValues();
        //} else {
            //postMessage(Message.obtain(null, UPDATE));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.823 -0400", hash_original_method = "5D4FD384A27446A0E17BE685B23E3829", hash_generated_method = "EA0C82C8A988DBC81373CC053B48455A")
    private void syncValues() {
        Set<String> tmp = nativeGetOrigins();
        mOrigins = new HashMap<String, Origin>();
for(String origin : tmp)
        {
            Origin website = new Origin(origin,
                                 nativeGetQuotaForOrigin(origin),
                                 nativeGetUsageForOrigin(origin));
            mOrigins.put(origin, website);
        } //End block
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

    
    @DSModeled(DSC.SAFE)
    private static Set nativeGetOrigins() {
        	return new HashSet();
    }

    
    @DSModeled(DSC.SAFE)
    private static long nativeGetUsageForOrigin(String origin) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1902901200 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1902901200;
    }

    
    @DSModeled(DSC.SAFE)
    private static long nativeGetQuotaForOrigin(String origin) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_752076961 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_752076961;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetQuotaForOrigin(String origin, long quota) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDeleteOrigin(String origin) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeDeleteAllData() {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeSetAppCacheMaximumSize(long size) {
    }

    
    public static class Origin {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_field = "64750E5841B87A1C417444D299CD4440", hash_generated_field = "C0D04DE859485FC064E3233B8B61E000")

        private String mOrigin = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_field = "ACDC9A01B63BF9F3D55326330A8C5FC3", hash_generated_field = "D4673897C52FB70646F861DEAEBDF4CA")

        private long mQuota = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_field = "412517F55B5F125B34E008950E31C814", hash_generated_field = "3B69C5C26EF23770033686E958090CE2")

        private long mUsage = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_method = "4FE78C59959DAB66D5A54195A66AB06B", hash_generated_method = "76322ED2B92E6B7663D8A0519AE3B0DF")
        private  Origin(String origin, long quota, long usage) {
            mOrigin = origin;
            mQuota = quota;
            mUsage = usage;
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
            //mUsage = usage;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_method = "C2CBF7E5975A0E1FB4219FCE2892FC4D", hash_generated_method = "FC09A97162600BEE334A20CD3A6FDFA1")
        private  Origin(String origin, long quota) {
            mOrigin = origin;
            mQuota = quota;
            // ---------- Original Method ----------
            //mOrigin = origin;
            //mQuota = quota;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_method = "EABE3A839C363BB6725AAE2908A0D269", hash_generated_method = "231D896CFDCFAA5D10466EAE91ED23CC")
        private  Origin(String origin) {
            mOrigin = origin;
            // ---------- Original Method ----------
            //mOrigin = origin;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_method = "1C35B3C80693DCFAD3BBB071D3FEEF91", hash_generated_method = "2B4EC318827A4F12A6EC8B313B9BE5C1")
        public String getOrigin() {
String var6E9E95B70F4AE840DEE2352B3C26C2DD_397220404 =             mOrigin;
            var6E9E95B70F4AE840DEE2352B3C26C2DD_397220404.addTaint(taint);
            return var6E9E95B70F4AE840DEE2352B3C26C2DD_397220404;
            // ---------- Original Method ----------
            //return mOrigin;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.824 -0400", hash_original_method = "85A4ADA77B01EE5A270890AB8ED69D00", hash_generated_method = "B26DCB23262DE1F75D93650B45FC444E")
        public long getQuota() {
            long var326B3F631E2F30B0C02519D96FD98708_141899811 = (mQuota);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_553228331 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_553228331;
            // ---------- Original Method ----------
            //return mQuota;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_method = "9EBBDD3C0652D213E94F799A53008143", hash_generated_method = "63A0110FFA0D2E9B9E06E03DDF8191B2")
        public long getUsage() {
            long varF2AAE19CC0AF4955036751775E00CA80_387116082 = (mUsage);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_1814538157 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_1814538157;
            // ---------- Original Method ----------
            //return mUsage;
        }

        
    }


    
    public interface QuotaUpdater {
        public void updateQuota(long newQuota);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "902004607D3D35BA00657C15EFA6863D", hash_generated_field = "B124889B42C1C29694444BA7EE6BE397")

    private static final String TAG = "webstorage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "BD285CA53C3AEB1EA97CC49EDB26AF94", hash_generated_field = "0CCDD741FE8F4FB31C977DCC41752D3D")

    private static WebStorage sWebStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "BE98DCB09006644549A3383ECF0F58A5", hash_generated_field = "80220E857288650FCA4A9214D787EEEC")

    static final int UPDATE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "B79B2D519A8F1FF73F1A94A436BD870A", hash_generated_field = "B80412364CF109AD5CAFECEC494A8508")

    static final int SET_QUOTA_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "9B72996C429AC66AEE732C78041BD80A", hash_generated_field = "D56A0D543C1D970FE705D600456F522E")

    static final int DELETE_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "07FA09A7985AF455A83A10B767F6D87F", hash_generated_field = "2D42D2233FA4B67F3C1E5CC4843B34A5")

    static final int DELETE_ALL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "B7BCA5977762AF11F2C340174D2C946B", hash_generated_field = "3F4854BBB8D9775C988A3B5D200EC051")

    static final int GET_ORIGINS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "037B03ECBAA557B298F95212324431B6", hash_generated_field = "BC5D7F1753C57A3928A06B0D08AD79A6")

    static final int GET_USAGE_ORIGIN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "2CD8BDA81653204703E656883F9B9AB3", hash_generated_field = "99224C9057D85343F62A869500380069")

    static final int GET_QUOTA_ORIGIN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "B723744F78D7F3DDDFCA0EFFD404ADEC", hash_generated_field = "A227830F6616FC7656E2900ADDB77A28")

    static final int RETURN_USAGE_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "4127CB68F596EEEEB8E0EF08848E0B70", hash_generated_field = "7A5226A7108C30D9EE1EEA0C659F2E2B")

    static final int RETURN_QUOTA_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "093E25DE57FD9F3EDFB24C5EED22C248", hash_generated_field = "FBF88EFB6A0D9D359F604ABC8EB945F1")

    private static final String USAGE = "usage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.825 -0400", hash_original_field = "48126D54606CBBF16C2A595EA1A86762", hash_generated_field = "FC16563FA12824893DF9C2A0BEFF95D8")

    private static final String QUOTA = "quota";
}

