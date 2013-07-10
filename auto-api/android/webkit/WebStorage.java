package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.022 -0400", hash_original_field = "66B6E6551149C8D18EAA0C8F6BFA4807", hash_generated_field = "37FCB2431FF7E2170127344873AA09C0")

    private Map <String, Origin> mOrigins;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.023 -0400", hash_original_field = "CE2D1D9987FFB86CFCC27E9C4CC37A4C", hash_generated_field = "A7637B18C168C40831B0C5AF31A66C87")

    private Handler mHandler = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.023 -0400", hash_original_field = "33F4AA66F852E93F47C7B5B93ECFBE81", hash_generated_field = "CAEF8005729A037CF5EC6BF8A6C37C05")

    private Handler mUIHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.023 -0400", hash_original_method = "45EE8E569EE103CF8A5587A04223DD11", hash_generated_method = "45EE8E569EE103CF8A5587A04223DD11")
    public WebStorage ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.024 -0400", hash_original_method = "82D962B4566984C9EF0A3C7F9B8F70D3", hash_generated_method = "242E1BDEF808D36870960C17F74D14F1")
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.024 -0400", hash_original_method = "E046AB9893C69470BF91F70EA6B66946", hash_generated_method = "53BDF39D8E599B75604BB42E25DF48B6")
                @Override
                public void handleMessage(Message msg) {
                    
                    {
                        Map values = (Map) msg.obj;
                        Map origins = (Map) values.get(ORIGINS);
                        ValueCallback<Map> callback = (ValueCallback<Map>) values.get(CALLBACK);
                        callback.onReceiveValue(origins);
                    } 
                    
                    
                    {
                        Map values = (Map) msg.obj;
                        ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                        callback.onReceiveValue((Long)values.get(USAGE));
                    } 
                    
                    
                    {
                        Map values = (Map) msg.obj;
                        ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                        callback.onReceiveValue((Long)values.get(QUOTA));
                    } 
                    
                    addTaint(msg.getTaint());
                    
                    
                }
};
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.027 -0400", hash_original_method = "70B57611BD5998CDDC131389C1B8C529", hash_generated_method = "BE76E3D8B883720B456FD1427818C77D")
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.027 -0400", hash_original_method = "9AB12BF7A5C5C253376F63645993E150", hash_generated_method = "EB0BBE874A902EDBE9512205D4DFD10D")
                @Override
                public void handleMessage(Message msg) {
                    
                    {
                        Origin website = (Origin) msg.obj;
                        nativeSetQuotaForOrigin(website.getOrigin(),
                                                    website.getQuota());
                    } 
                    
                    
                    {
                        Origin website = (Origin) msg.obj;
                        nativeDeleteOrigin(website.getOrigin());
                    } 
                    
                    
                    nativeDeleteAllData();
                    
                    
                    {
                        syncValues();
                        ValueCallback callback = (ValueCallback) msg.obj;
                        Map origins = new HashMap(mOrigins);
                        Map values = new HashMap<String, Object>();
                        values.put(CALLBACK, callback);
                        values.put(ORIGINS, origins);
                        postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                    } 
                    
                    
                    {
                        syncValues();
                        Map values = (Map) msg.obj;
                        String origin = (String) values.get(ORIGIN);
                        ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                        Origin website = mOrigins.get(origin);
                        Map retValues = new HashMap<String, Object>();
                        retValues.put(CALLBACK, callback);
                        {
                            long usage = website.getUsage();
                            retValues.put(USAGE, new Long(usage));
                        } 
                        postUIMessage(Message.obtain(null, RETURN_USAGE_ORIGIN, retValues));
                    } 
                    
                    
                    {
                        syncValues();
                        Map values = (Map) msg.obj;
                        String origin = (String) values.get(ORIGIN);
                        ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                        Origin website = mOrigins.get(origin);
                        Map retValues = new HashMap<String, Object>();
                        retValues.put(CALLBACK, callback);
                        {
                            long quota = website.getQuota();
                            retValues.put(QUOTA, new Long(quota));
                        } 
                        postUIMessage(Message.obtain(null, RETURN_QUOTA_ORIGIN, retValues));
                    } 
                    
                    
                    syncValues();
                    
                    addTaint(msg.getTaint());
                    
                    
                }
};
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.028 -0400", hash_original_method = "5F1CCC127056749A41D889CB5F293C72", hash_generated_method = "E40435F9CD2068CD677E52562016C0B4")
    public void getOrigins(ValueCallback<Map> callback) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1000403908 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    syncValues();
                    callback.onReceiveValue(mOrigins);
                } 
                {
                    postMessage(Message.obtain(null, GET_ORIGINS, callback));
                } 
            } 
        } 
        addTaint(callback.getTaint());
        
        
            
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.028 -0400", hash_original_method = "20875F7A30B9C28B41BC562F884EFBD9", hash_generated_method = "037DA8ED5BD79AD148D1B9086C586971")
     Collection<Origin> getOriginsSync() {
        Collection<Origin> varB4EAC82CA7396A68D541C85D26508E83_452940126 = null; 
        Collection<Origin> varB4EAC82CA7396A68D541C85D26508E83_503852233 = null; 
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1930799637 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                update();
                varB4EAC82CA7396A68D541C85D26508E83_452940126 = mOrigins.values();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_503852233 = null;
        Collection<Origin> varA7E53CE21691AB073D9660D615818899_1349869295; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1349869295 = varB4EAC82CA7396A68D541C85D26508E83_452940126;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1349869295 = varB4EAC82CA7396A68D541C85D26508E83_503852233;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1349869295.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1349869295;
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.029 -0400", hash_original_method = "A830572EF5CC952FAB535A1A02FCF9EB", hash_generated_method = "C721B700446F0746FC46A6A631CF6C52")
    public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
        {
            callback.onReceiveValue(null);
        } 
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1085533532 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
                Origin website = mOrigins.get(origin);
                callback.onReceiveValue(new Long(website.getUsage()));
            } 
            {
                HashMap values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_USAGE_ORIGIN, values));
            } 
        } 
        addTaint(origin.getTaint());
        addTaint(callback.getTaint());
        
        
            
        
        
            
            
        
        
            
            
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.029 -0400", hash_original_method = "BC9A85F4ABA5D3D4138B578A1B617A4F", hash_generated_method = "3ECE287524B9CF251BD091FCAE932FA1")
    public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
        {
            callback.onReceiveValue(null);
        } 
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_455560817 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
                Origin website = mOrigins.get(origin);
                callback.onReceiveValue(new Long(website.getUsage()));
            } 
            {
                HashMap values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_QUOTA_ORIGIN, values));
            } 
        } 
        addTaint(origin.getTaint());
        addTaint(callback.getTaint());
        
        
            
        
        
            
            
        
        
            
            
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.030 -0400", hash_original_method = "567046E45B1707841AB709B2994EB872", hash_generated_method = "8DAAA47343AF8B6533123A726442C930")
    public void setQuotaForOrigin(String origin, long quota) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1093694120 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeSetQuotaForOrigin(origin, quota);
                } 
                {
                    postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    new Origin(origin, quota)));
                } 
            } 
        } 
        addTaint(origin.getTaint());
        addTaint(quota);
        
        
            
                
            
                
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.030 -0400", hash_original_method = "8BD785193E41D931D316F61464C869E4", hash_generated_method = "A4DD630733D393E8919C36A8AE4D0A57")
    public void deleteOrigin(String origin) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1490949633 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    nativeDeleteOrigin(origin);
                } 
                {
                    postMessage(Message.obtain(null, DELETE_ORIGIN,
                    new Origin(origin)));
                } 
            } 
        } 
        addTaint(origin.getTaint());
        
        
            
                
            
                
                    
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.030 -0400", hash_original_method = "4CABCD5AB64090C1AAA8A337FB9C39CF", hash_generated_method = "098489A3E16FEEF8023463EEC7161037")
    public void deleteAllData() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_161373450 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                nativeDeleteAllData();
            } 
            {
                postMessage(Message.obtain(null, DELETE_ALL));
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.031 -0400", hash_original_method = "D4FAC5548D3982CA0D61EFA3641C44C0", hash_generated_method = "5A95D28E6A76210DFF46CB7B193BEEA7")
    public void setAppCacheMaximumSize(long size) {
        nativeSetAppCacheMaximumSize(size);
        addTaint(size);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.031 -0400", hash_original_method = "62EA151909BF01F1F742C4723FE70A6A", hash_generated_method = "AABEAF0AF3883F5E3B6B2DA616C9BC28")
    private synchronized void postMessage(Message msg) {
        {
            mHandler.sendMessage(msg);
        } 
        addTaint(msg.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.031 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C8ED0203F18A2FA93DA4BACC33043B55")
    private void postUIMessage(Message msg) {
        {
            mUIHandler.sendMessage(msg);
        } 
        addTaint(msg.getTaint());
        
        
            
        
    }

    
        public static WebStorage getInstance() {
        if (sWebStorage == null) {
          sWebStorage = new WebStorage();
      }
        return sWebStorage;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.032 -0400", hash_original_method = "84940B587CE35477B1887A71543D40B1", hash_generated_method = "21C616928357F5033A4B7D2E0581748C")
    public void update() {
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_1879428302 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                syncValues();
            } 
            {
                postMessage(Message.obtain(null, UPDATE));
            } 
        } 
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.038 -0400", hash_original_method = "5D4FD384A27446A0E17BE685B23E3829", hash_generated_method = "D162BA44BE5546270256B6B616FF370D")
    private void syncValues() {
        Set<String> tmp = nativeGetOrigins();
        mOrigins = new HashMap<String, Origin>();
        {
            Iterator<String> var789D548900BFEFF21EF0DCF6799AE26E_289345223 = (tmp).iterator();
            var789D548900BFEFF21EF0DCF6799AE26E_289345223.hasNext();
            String origin = var789D548900BFEFF21EF0DCF6799AE26E_289345223.next();
            {
                Origin website = new Origin(origin,
                                 nativeGetQuotaForOrigin(origin),
                                 nativeGetUsageForOrigin(origin));
                mOrigins.put(origin, website);
            } 
        } 
        
        
        
        
            
                                 
                                 
            
        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.039 -0400", hash_original_field = "64750E5841B87A1C417444D299CD4440", hash_generated_field = "C0D04DE859485FC064E3233B8B61E000")

        private String mOrigin = null;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.040 -0400", hash_original_field = "ACDC9A01B63BF9F3D55326330A8C5FC3", hash_generated_field = "D4673897C52FB70646F861DEAEBDF4CA")

        private long mQuota = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.040 -0400", hash_original_field = "412517F55B5F125B34E008950E31C814", hash_generated_field = "3B69C5C26EF23770033686E958090CE2")

        private long mUsage = 0;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.040 -0400", hash_original_method = "4FE78C59959DAB66D5A54195A66AB06B", hash_generated_method = "76322ED2B92E6B7663D8A0519AE3B0DF")
        private  Origin(String origin, long quota, long usage) {
            mOrigin = origin;
            mQuota = quota;
            mUsage = usage;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.040 -0400", hash_original_method = "C2CBF7E5975A0E1FB4219FCE2892FC4D", hash_generated_method = "FC09A97162600BEE334A20CD3A6FDFA1")
        private  Origin(String origin, long quota) {
            mOrigin = origin;
            mQuota = quota;
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.041 -0400", hash_original_method = "EABE3A839C363BB6725AAE2908A0D269", hash_generated_method = "231D896CFDCFAA5D10466EAE91ED23CC")
        private  Origin(String origin) {
            mOrigin = origin;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.041 -0400", hash_original_method = "1C35B3C80693DCFAD3BBB071D3FEEF91", hash_generated_method = "77D52D0B4F9DA9B3F7ED8FCE4DFEE654")
        public String getOrigin() {
            String varB4EAC82CA7396A68D541C85D26508E83_865759349 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_865759349 = mOrigin;
            varB4EAC82CA7396A68D541C85D26508E83_865759349.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_865759349;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.041 -0400", hash_original_method = "85A4ADA77B01EE5A270890AB8ED69D00", hash_generated_method = "9FE14256D9556F7760416E268FA8B809")
        public long getQuota() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_679957732 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_679957732;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_method = "9EBBDD3C0652D213E94F799A53008143", hash_generated_method = "210B7C3161958E75F0E4F9F806D5F9F4")
        public long getUsage() {
            long var0F5264038205EDFB1AC05FBB0E8C5E94_335402996 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_335402996;
            
            
        }

        
    }


    
    public interface QuotaUpdater {
        public void updateQuota(long newQuota);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "902004607D3D35BA00657C15EFA6863D", hash_generated_field = "B124889B42C1C29694444BA7EE6BE397")

    private static final String TAG = "webstorage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "BD285CA53C3AEB1EA97CC49EDB26AF94", hash_generated_field = "0CCDD741FE8F4FB31C977DCC41752D3D")

    private static WebStorage sWebStorage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "BE98DCB09006644549A3383ECF0F58A5", hash_generated_field = "80220E857288650FCA4A9214D787EEEC")

    static final int UPDATE = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "B79B2D519A8F1FF73F1A94A436BD870A", hash_generated_field = "B80412364CF109AD5CAFECEC494A8508")

    static final int SET_QUOTA_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "9B72996C429AC66AEE732C78041BD80A", hash_generated_field = "D56A0D543C1D970FE705D600456F522E")

    static final int DELETE_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "07FA09A7985AF455A83A10B767F6D87F", hash_generated_field = "2D42D2233FA4B67F3C1E5CC4843B34A5")

    static final int DELETE_ALL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "B7BCA5977762AF11F2C340174D2C946B", hash_generated_field = "3F4854BBB8D9775C988A3B5D200EC051")

    static final int GET_ORIGINS = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "037B03ECBAA557B298F95212324431B6", hash_generated_field = "BC5D7F1753C57A3928A06B0D08AD79A6")

    static final int GET_USAGE_ORIGIN = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "2CD8BDA81653204703E656883F9B9AB3", hash_generated_field = "99224C9057D85343F62A869500380069")

    static final int GET_QUOTA_ORIGIN = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "B723744F78D7F3DDDFCA0EFFD404ADEC", hash_generated_field = "A227830F6616FC7656E2900ADDB77A28")

    static final int RETURN_USAGE_ORIGIN = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "4127CB68F596EEEEB8E0EF08848E0B70", hash_generated_field = "7A5226A7108C30D9EE1EEA0C659F2E2B")

    static final int RETURN_QUOTA_ORIGIN = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "093E25DE57FD9F3EDFB24C5EED22C248", hash_generated_field = "FBF88EFB6A0D9D359F604ABC8EB945F1")

    private static final String USAGE = "usage";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:06.042 -0400", hash_original_field = "48126D54606CBBF16C2A595EA1A86762", hash_generated_field = "FC16563FA12824893DF9C2A0BEFF95D8")

    private static final String QUOTA = "quota";
}

