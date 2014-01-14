package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import android.os.Handler;
import android.os.Message;

import droidsafe.helpers.DSUtils;

public final class WebStorage {

    /**
     * Get the global instance of WebStorage.
     * @return A single instance of WebStorage.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.312 -0500", hash_original_method = "13124F4F94E405768D8E20607A9780AD", hash_generated_method = "E3D9650EA7BD47A9BD42127B636C3AC6")
    
public static WebStorage getInstance() {
      if (sWebStorage == null) {
          sWebStorage = new WebStorage();
      }
      return sWebStorage;
    }
    
    private static Set nativeGetOrigins() {
        	return new HashSet();
    }
    
    private static long nativeGetUsageForOrigin(String origin) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1902901200 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1902901200;
    }
    
    private static long nativeGetQuotaForOrigin(String origin) {
                long var0F5264038205EDFB1AC05FBB0E8C5E94_752076961 = DSUtils.UNKNOWN_LONG;
        return var0F5264038205EDFB1AC05FBB0E8C5E94_752076961;
    }
    
    private static void nativeSetQuotaForOrigin(String origin, long quota) {
    }
    
    private static void nativeDeleteOrigin(String origin) {
    }
    
    private static void nativeDeleteAllData() {
    }
    
    private static void nativeSetAppCacheMaximumSize(long size) {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.204 -0500", hash_original_field = "89315E767D1FCC96269A405D475BDE30", hash_generated_field = "B124889B42C1C29694444BA7EE6BE397")

    private static final String TAG = "webstorage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.206 -0500", hash_original_field = "E9480EB4C02F89D99A2676FE66AA2E62", hash_generated_field = "0CCDD741FE8F4FB31C977DCC41752D3D")

    private static WebStorage sWebStorage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.208 -0500", hash_original_field = "5AC8C4C3A67295D5554469AE0F293473", hash_generated_field = "80220E857288650FCA4A9214D787EEEC")

    static final int UPDATE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.210 -0500", hash_original_field = "1D4432BF472D3F975C61E7EFAFFFCEF3", hash_generated_field = "B80412364CF109AD5CAFECEC494A8508")

    static final int SET_QUOTA_ORIGIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.212 -0500", hash_original_field = "93D2AC889FC3CAD5225A6427481B39AA", hash_generated_field = "D56A0D543C1D970FE705D600456F522E")

    static final int DELETE_ORIGIN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.214 -0500", hash_original_field = "7DE6B118E08E84DF4B27DA50694B26C1", hash_generated_field = "2D42D2233FA4B67F3C1E5CC4843B34A5")

    static final int DELETE_ALL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.217 -0500", hash_original_field = "8F56C817B6F7F89FB52113F4526E337D", hash_generated_field = "3F4854BBB8D9775C988A3B5D200EC051")

    static final int GET_ORIGINS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.219 -0500", hash_original_field = "B585BFAB18A917F88EB48817BB5295C0", hash_generated_field = "BC5D7F1753C57A3928A06B0D08AD79A6")

    static final int GET_USAGE_ORIGIN = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.222 -0500", hash_original_field = "AE6A58A2E7C9F9C3EB620D1A5A17FABC", hash_generated_field = "99224C9057D85343F62A869500380069")

    static final int GET_QUOTA_ORIGIN = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.224 -0500", hash_original_field = "B94C761C114ABBDF8C0EAF326D54BEC9", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.226 -0500", hash_original_field = "5EACF70DDF3849D20D5BCB91236B75D2", hash_generated_field = "A227830F6616FC7656E2900ADDB77A28")

    static final int RETURN_USAGE_ORIGIN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.228 -0500", hash_original_field = "9B5F750C16CB9A89FDF6F00B8CBBA2C9", hash_generated_field = "7A5226A7108C30D9EE1EEA0C659F2E2B")

    static final int RETURN_QUOTA_ORIGIN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.231 -0500", hash_original_field = "3A8763FFA79362A6F91CC6D8BB60CC66", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.233 -0500", hash_original_field = "983FFBADFC71C6AD0E8CAB8AC6F52330", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.236 -0500", hash_original_field = "BF7F677908E55C804B04455459BD3DF9", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.238 -0500", hash_original_field = "66F43406CD70007D8203A2C15F20ABB7", hash_generated_field = "FBF88EFB6A0D9D359F604ABC8EB945F1")

    private static final String USAGE = "usage";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.241 -0500", hash_original_field = "03F0C54FD469EEA88313A44B8C1F1E47", hash_generated_field = "FC16563FA12824893DF9C2A0BEFF95D8")

    private static final String QUOTA = "quota";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.243 -0500", hash_original_field = "1719CE0771D73BFF018DBA8A9B4EF9ED", hash_generated_field = "37FCB2431FF7E2170127344873AA09C0")

    private Map <String, Origin> mOrigins;
    
    public static class Origin {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.250 -0500", hash_original_field = "F6058587CC1DE776C10C367E01BBCD20", hash_generated_field = "C0D04DE859485FC064E3233B8B61E000")

        private String mOrigin = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.253 -0500", hash_original_field = "047AE718B1437EC25B7F81AAECABEF4B", hash_generated_field = "D4673897C52FB70646F861DEAEBDF4CA")

        private long mQuota = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.255 -0500", hash_original_field = "084880588B4DA90ADB15DE74678C9C88", hash_generated_field = "3B69C5C26EF23770033686E958090CE2")

        private long mUsage = 0;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.257 -0500", hash_original_method = "4FE78C59959DAB66D5A54195A66AB06B", hash_generated_method = "ED33D477D6E7453AD18F312199E75F82")
        
private Origin(String origin, long quota, long usage) {
            mOrigin = origin;
            mQuota = quota;
            mUsage = usage;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.261 -0500", hash_original_method = "C2CBF7E5975A0E1FB4219FCE2892FC4D", hash_generated_method = "3310E29F2F9F0C6416808768AB2195B8")
        
private Origin(String origin, long quota) {
            mOrigin = origin;
            mQuota = quota;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.263 -0500", hash_original_method = "EABE3A839C363BB6725AAE2908A0D269", hash_generated_method = "BCD38518505CC322CB744642E4AD2BFC")
        
private Origin(String origin) {
            mOrigin = origin;
        }

        /**
         * An origin string is created using WebCore::SecurityOrigin::toString().
         * Note that WebCore::SecurityOrigin uses 0 (which is not printed) for
         * the port if the port is the default for the protocol. Eg
         * http://www.google.com and http://www.google.com:80 both record a port
         * of 0 and hence toString() == 'http://www.google.com' for both.
         * @return The origin string.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.266 -0500", hash_original_method = "1C35B3C80693DCFAD3BBB071D3FEEF91", hash_generated_method = "FE80DFECDAB4568B003CCA3FED55809C")
        
public String getOrigin() {
            return mOrigin;
        }

        /**
         * Returns the quota for this origin's HTML5 database.
         * @return The quota in bytes.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.268 -0500", hash_original_method = "85A4ADA77B01EE5A270890AB8ED69D00", hash_generated_method = "6FE1683C4FD2FD1286558D60FB46A1DE")
        
public long getQuota() {
            return mQuota;
        }

        /**
         * Returns the usage for this origin's HTML5 database.
         * @return The usage in bytes.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.270 -0500", hash_original_method = "9EBBDD3C0652D213E94F799A53008143", hash_generated_method = "7B22B0A723E985BC0449B81BAB103C25")
        
public long getUsage() {
            return mUsage;
        }
        
    }
    
    public interface QuotaUpdater {
        public void updateQuota(long newQuota);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.245 -0500", hash_original_field = "5AC474BA51F7B7C543F2DB5B1360A60E", hash_generated_field = "A7637B18C168C40831B0C5AF31A66C87")

    private Handler mHandler = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.248 -0500", hash_original_field = "62C452DC955B51B8C5282E5B97E9998B", hash_generated_field = "CAEF8005729A037CF5EC6BF8A6C37C05")

    private Handler mUIHandler = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:53.806 -0400", hash_original_method = "45EE8E569EE103CF8A5587A04223DD11", hash_generated_method = "45EE8E569EE103CF8A5587A04223DD11")
    public WebStorage ()
    {
        //Synthesized constructor
    }

    /**
     * @hide
     * Message handler, UI side
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.278 -0500", hash_original_method = "82D962B4566984C9EF0A3C7F9B8F70D3", hash_generated_method = "C61735BC167980B4249C1D4B32DFEEBC")
    
public void createUIHandler() {
        if (mUIHandler == null) {
            mUIHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case RETURN_ORIGINS: {
                            Map values = (Map) msg.obj;
                            Map origins = (Map) values.get(ORIGINS);
                            ValueCallback<Map> callback = (ValueCallback<Map>) values.get(CALLBACK);
                            callback.onReceiveValue(origins);
                            } break;

                        case RETURN_USAGE_ORIGIN: {
                            Map values = (Map) msg.obj;
                            ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                            callback.onReceiveValue((Long)values.get(USAGE));
                            } break;

                        case RETURN_QUOTA_ORIGIN: {
                            Map values = (Map) msg.obj;
                            ValueCallback<Long> callback = (ValueCallback<Long>) values.get(CALLBACK);
                            callback.onReceiveValue((Long)values.get(QUOTA));
                            } break;
                    }
                }
            };
        }
    }

    /**
     * @hide
     * Message handler, webcore side
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.286 -0500", hash_original_method = "70B57611BD5998CDDC131389C1B8C529", hash_generated_method = "A57875A1B53D5A78BE33832E5F2922F5")
    
public synchronized void createHandler() {
        if (mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case SET_QUOTA_ORIGIN: {
                            Origin website = (Origin) msg.obj;
                            nativeSetQuotaForOrigin(website.getOrigin(),
                                                    website.getQuota());
                            } break;

                        case DELETE_ORIGIN: {
                            Origin website = (Origin) msg.obj;
                            nativeDeleteOrigin(website.getOrigin());
                            } break;

                        case DELETE_ALL:
                            nativeDeleteAllData();
                            break;

                        case GET_ORIGINS: {
                            syncValues();
                            ValueCallback callback = (ValueCallback) msg.obj;
                            Map origins = new HashMap(mOrigins);
                            Map values = new HashMap<String, Object>();
                            values.put(CALLBACK, callback);
                            values.put(ORIGINS, origins);
                            postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                            } break;

                        case GET_USAGE_ORIGIN: {
                            syncValues();
                            Map values = (Map) msg.obj;
                            String origin = (String) values.get(ORIGIN);
                            ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                            Origin website = mOrigins.get(origin);
                            Map retValues = new HashMap<String, Object>();
                            retValues.put(CALLBACK, callback);
                            if (website != null) {
                                long usage = website.getUsage();
                                retValues.put(USAGE, new Long(usage));
                            }
                            postUIMessage(Message.obtain(null, RETURN_USAGE_ORIGIN, retValues));
                            } break;

                        case GET_QUOTA_ORIGIN: {
                            syncValues();
                            Map values = (Map) msg.obj;
                            String origin = (String) values.get(ORIGIN);
                            ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                            Origin website = mOrigins.get(origin);
                            Map retValues = new HashMap<String, Object>();
                            retValues.put(CALLBACK, callback);
                            if (website != null) {
                                long quota = website.getQuota();
                                retValues.put(QUOTA, new Long(quota));
                            }
                            postUIMessage(Message.obtain(null, RETURN_QUOTA_ORIGIN, retValues));
                            } break;

                        case UPDATE:
                            syncValues();
                            break;
                    }
                }
            };
        }
    }

    /*
     * When calling getOrigins(), getUsageForOrigin() and getQuotaForOrigin(),
     * we need to get the values from webcore, but we cannot block while doing so
     * as we used to do, as this could result in a full deadlock (other webcore
     * messages received while we are still blocked here, see http://b/2127737).
     *
     * We have to do everything asynchronously, by providing a callback function.
     * We post a message on the webcore thread (mHandler) that will get the result
     * from webcore, and we post it back on the UI thread (using mUIHandler).
     * We can then use the callback function to return the value.
     */

    /**
     * Returns a list of origins having a database. The Map is of type
     * Map<String, Origin>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.288 -0500", hash_original_method = "5F1CCC127056749A41D889CB5F293C72", hash_generated_method = "2AD0F34B1C977F38B7E204CE2C1D891E")
    
public void getOrigins(ValueCallback<Map> callback) {
        if (callback != null) {
            if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                syncValues();
                callback.onReceiveValue(mOrigins);
            } else {
                postMessage(Message.obtain(null, GET_ORIGINS, callback));
            }
        }
    }

    /**
     * Returns a list of origins having a database
     * should only be called from WebViewCore.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.291 -0500", hash_original_method = "20875F7A30B9C28B41BC562F884EFBD9", hash_generated_method = "20875F7A30B9C28B41BC562F884EFBD9")
    
Collection<Origin> getOriginsSync() {
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            update();
            return mOrigins.values();
        }
        return null;
    }

    /**
     * Returns the use for a given origin
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.294 -0500", hash_original_method = "A830572EF5CC952FAB535A1A02FCF9EB", hash_generated_method = "0ED4EDD018387496EDCC9CFBAE847FAB")
    
public void getUsageForOrigin(String origin, ValueCallback<Long> callback) {
        if (callback == null) {
            return;
        }
        if (origin == null) {
            callback.onReceiveValue(null);
            return;
        }
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            syncValues();
            Origin website = mOrigins.get(origin);
            callback.onReceiveValue(new Long(website.getUsage()));
        } else {
            HashMap values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_USAGE_ORIGIN, values));
        }
    }

    /**
     * Returns the quota for a given origin
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.296 -0500", hash_original_method = "BC9A85F4ABA5D3D4138B578A1B617A4F", hash_generated_method = "7383A12680032F1EBA9BED35742CDE43")
    
public void getQuotaForOrigin(String origin, ValueCallback<Long> callback) {
        if (callback == null) {
            return;
        }
        if (origin == null) {
            callback.onReceiveValue(null);
            return;
        }
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            syncValues();
            Origin website = mOrigins.get(origin);
            callback.onReceiveValue(new Long(website.getUsage()));
        } else {
            HashMap values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_QUOTA_ORIGIN, values));
        }
    }

    /**
     * Set the quota for a given origin
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.298 -0500", hash_original_method = "567046E45B1707841AB709B2994EB872", hash_generated_method = "9F7FAAF1F324A758693C53AFB4A3A0EF")
    
public void setQuotaForOrigin(String origin, long quota) {
        if (origin != null) {
            if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                nativeSetQuotaForOrigin(origin, quota);
            } else {
                postMessage(Message.obtain(null, SET_QUOTA_ORIGIN,
                    new Origin(origin, quota)));
            }
        }
    }

    /**
     * Delete a given origin
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.300 -0500", hash_original_method = "8BD785193E41D931D316F61464C869E4", hash_generated_method = "BF005B033D05132176A87C8CED92A57F")
    
public void deleteOrigin(String origin) {
        if (origin != null) {
            if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                nativeDeleteOrigin(origin);
            } else {
                postMessage(Message.obtain(null, DELETE_ORIGIN,
                    new Origin(origin)));
            }
        }
    }

    /**
     * Delete all databases
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.303 -0500", hash_original_method = "4CABCD5AB64090C1AAA8A337FB9C39CF", hash_generated_method = "7D14E9FB949E307504A8A0211450A62B")
    
public void deleteAllData() {
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            nativeDeleteAllData();
        } else {
            postMessage(Message.obtain(null, DELETE_ALL));
        }
    }

    /**
     * Sets the maximum size of the ApplicationCache.
     * This should only ever be called on the WebKit thread.
     * @hide Pending API council approval
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.305 -0500", hash_original_method = "D4FAC5548D3982CA0D61EFA3641C44C0", hash_generated_method = "5A556AAAB7FE8E6916D9A64406452F52")
    
public void setAppCacheMaximumSize(long size) {
        nativeSetAppCacheMaximumSize(size);
    }

    /**
     * Utility function to send a message to our handler
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.308 -0500", hash_original_method = "62EA151909BF01F1F742C4723FE70A6A", hash_generated_method = "B4B87F937AC4DD7FF33BE99461BC3CCD")
    
private synchronized void postMessage(Message msg) {
        if (mHandler != null) {
            mHandler.sendMessage(msg);
        }
    }

    /**
     * Utility function to send a message to the handler on the UI thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.310 -0500", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C2FC6A3A4D0F6BDDE3E5B5092770AEBC")
    
private void postUIMessage(Message msg) {
        if (mUIHandler != null) {
            mUIHandler.sendMessage(msg);
        }
    }

    /**
     * @hide
     * Post a Sync request
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.315 -0500", hash_original_method = "84940B587CE35477B1887A71543D40B1", hash_generated_method = "6B01D8682A48428DC96960815CBEEF7E")
    
public void update() {
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            syncValues();
        } else {
            postMessage(Message.obtain(null, UPDATE));
        }
    }

    /**
     * Run on the webcore thread
     * set the local values with the current ones
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:18.317 -0500", hash_original_method = "5D4FD384A27446A0E17BE685B23E3829", hash_generated_method = "636F3F23718BACD2EA84E7AD0D8B80F5")
    
private void syncValues() {
        Set<String> tmp = nativeGetOrigins();
        mOrigins = new HashMap<String, Origin>();
        for (String origin : tmp) {
            Origin website = new Origin(origin,
                                 nativeGetQuotaForOrigin(origin),
                                 nativeGetUsageForOrigin(origin));
            mOrigins.put(origin, website);
        }
    }
}

