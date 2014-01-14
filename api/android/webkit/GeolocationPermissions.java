package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import android.os.Handler;
import android.os.Message;

import droidsafe.helpers.DSUtils;

public final class GeolocationPermissions {

    /**
     * Gets the singleton instance of the class.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.193 -0500", hash_original_method = "CF5DE03BD00FE0AD7B0AF2C378080A57", hash_generated_method = "916FC6682CB5E8EDC51BB9668378D669")
    
public static GeolocationPermissions getInstance() {
      if (sInstance == null) {
          sInstance = new GeolocationPermissions();
      }
      return sInstance;
    }
    
    private static Set nativeGetOrigins() {
        	Set s = new HashSet<>();
        	return s;
    }
    
    private static boolean nativeGetAllowed(String origin) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246562142 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246562142;
    }
    
    private static void nativeClear(String origin) {
    }
    
    private static void nativeAllow(String origin) {
    }
    
    private static void nativeClearAll() {
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.156 -0500", hash_original_field = "4D2735B1262AC046E5680A52D0A94087", hash_generated_field = "8CF04CB4ECB9AB0455165005BED06537")

    private static final String TAG = "geolocationPermissions";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.158 -0500", hash_original_field = "FBA466880C60C1FE9B47703D022BDA0B", hash_generated_field = "C596865D3F7EFF76AD655659294290BE")

    private static GeolocationPermissions sInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.168 -0500", hash_original_field = "1D414FBFC2B4202AF11150E88D7CF83C", hash_generated_field = "B2B930E0DEAF51B3BFEBDDD5367DF3EF")

    static final int GET_ORIGINS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.170 -0500", hash_original_field = "ACBAA9B6A4C05F46FC6391B10E031A53", hash_generated_field = "72FCC8F0DCAC5F61D15EA6F573FF99E1")

    static final int GET_ALLOWED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.172 -0500", hash_original_field = "CDDE71EB0754F74CA66A978528279E8B", hash_generated_field = "CAE6D8890E07CEF85F431005D11E0878")

    static final int CLEAR = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.174 -0500", hash_original_field = "54FF24859FB14AA51CE1ECB359C79E0E", hash_generated_field = "998CD419BE1F5CD72638740F7BD9B24D")

    static final int ALLOW = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.176 -0500", hash_original_field = "7988BF20B6185BC063837B22747A5A94", hash_generated_field = "FB253837BCC3975DA3E639116C86E8D7")

    static final int CLEAR_ALL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.178 -0500", hash_original_field = "B94C761C114ABBDF8C0EAF326D54BEC9", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.181 -0500", hash_original_field = "9FE0CF2154686D01C79DCC715F9D0909", hash_generated_field = "B83EE419031563F2F60D55C7FFAE2DE6")

    static final int RETURN_ALLOWED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.183 -0500", hash_original_field = "3A8763FFA79362A6F91CC6D8BB60CC66", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.186 -0500", hash_original_field = "983FFBADFC71C6AD0E8CAB8AC6F52330", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.188 -0500", hash_original_field = "BF7F677908E55C804B04455459BD3DF9", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.190 -0500", hash_original_field = "47145455A79115A10E6CDDC929C950C8", hash_generated_field = "C49A555D58D6E46C905036CB1FB4679B")

    private static final String ALLOWED = "allowed";
    
    public interface Callback {
        public void invoke(String origin, boolean allow, boolean remember);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.160 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.163 -0500", hash_original_field = "B89B84C211A49B133FC74A7019F95457", hash_generated_field = "6981106475EB8144679AFAB5874563DD")

    private Handler mUIHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.165 -0500", hash_original_field = "F727A520352E53CAE689BCBFD3F8F07F", hash_generated_field = "278339A7287A66584FB6CDE30FDBA644")

    private Vector<Message> mQueuedMessages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:51.833 -0400", hash_original_method = "BCFC7E69B898D596BF2DB066E056C985", hash_generated_method = "BCFC7E69B898D596BF2DB066E056C985")
    public GeolocationPermissions ()
    {
        //Synthesized constructor
    }

    /**
     * Creates the UI message handler. Must be called on the UI thread.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.199 -0500", hash_original_method = "41983E4AD1DCA5E034973FB71B6F64E2", hash_generated_method = "FE0086F5838C2FA5A6CD634F53A119E2")
    
public void createUIHandler() {
        if (mUIHandler == null) {
            mUIHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // Runs on the UI thread.
                    switch (msg.what) {
                        case RETURN_ORIGINS: {
                            Map values = (Map) msg.obj;
                            Set<String> origins = (Set<String>) values.get(ORIGINS);
                            ValueCallback<Set<String> > callback = (ValueCallback<Set<String> >) values.get(CALLBACK);
                            callback.onReceiveValue(origins);
                        } break;
                        case RETURN_ALLOWED: {
                            Map values = (Map) msg.obj;
                            Boolean allowed = (Boolean) values.get(ALLOWED);
                            ValueCallback<Boolean> callback = (ValueCallback<Boolean>) values.get(CALLBACK);
                            callback.onReceiveValue(allowed);
                        } break;
                    }
                }
            };
        }
    }

    /**
     * Creates the message handler. Must be called on the WebKit thread.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.205 -0500", hash_original_method = "7339E0A10658134ACC2105D49EF71E34", hash_generated_method = "A7DB82BE290D3AE425288F9384EFF5B5")
    
public synchronized void createHandler() {
        if (mHandler == null) {
            mHandler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    // Runs on the WebKit thread.
                    switch (msg.what) {
                        case GET_ORIGINS: {
                            Set origins = nativeGetOrigins();
                            ValueCallback callback = (ValueCallback) msg.obj;
                            Map values = new HashMap<String, Object>();
                            values.put(CALLBACK, callback);
                            values.put(ORIGINS, origins);
                            postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                            } break;
                        case GET_ALLOWED: {
                            Map values = (Map) msg.obj;
                            String origin = (String) values.get(ORIGIN);
                            ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                            boolean allowed = nativeGetAllowed(origin);
                            Map retValues = new HashMap<String, Object>();
                            retValues.put(CALLBACK, callback);
                            retValues.put(ALLOWED, Boolean.valueOf(allowed));
                            postUIMessage(Message.obtain(null, RETURN_ALLOWED, retValues));
                            } break;
                        case CLEAR:
                            nativeClear((String) msg.obj);
                            break;
                        case ALLOW:
                            nativeAllow((String) msg.obj);
                            break;
                        case CLEAR_ALL:
                            nativeClearAll();
                            break;
                    }
                }
            };

            // Handle the queued messages
            if (mQueuedMessages != null) {
                while (!mQueuedMessages.isEmpty()) {
                    mHandler.sendMessage(mQueuedMessages.remove(0));
                }
                mQueuedMessages = null;
            }
        }
    }

    /**
     * Utility function to send a message to our handler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.209 -0500", hash_original_method = "C8B20551C681C75E8A94C862CADE3192", hash_generated_method = "A7433FDE5A5DBECF9F0AF160B3A18046")
    
private synchronized void postMessage(Message msg) {
        if (mHandler == null) {
            if (mQueuedMessages == null) {
                mQueuedMessages = new Vector<Message>();
            }
            mQueuedMessages.add(msg);
        } else {
            mHandler.sendMessage(msg);
        }
    }

    /**
     * Utility function to send a message to the handler on the UI thread
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.211 -0500", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C2FC6A3A4D0F6BDDE3E5B5092770AEBC")
    
private void postUIMessage(Message msg) {
        if (mUIHandler != null) {
            mUIHandler.sendMessage(msg);
        }
    }

    /**
     * Gets the set of origins for which Geolocation permissions are stored.
     * Note that we represent the origins as strings. These are created using
     * WebCore::SecurityOrigin::toString(). As long as all 'HTML 5 modules'
     * (Database, Geolocation etc) do so, it's safe to match up origins based
     * on this string.
     *
     * Callback is a ValueCallback object whose onReceiveValue method will be
     * called asynchronously with the set of origins.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.213 -0500", hash_original_method = "0C5C32901EC14D47C0B4926D32AA66D4", hash_generated_method = "218CF1C5418D6D6448B70BCEEE1A2093")
    
public void getOrigins(ValueCallback<Set<String> > callback) {
        if (callback != null) {
            if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                Set origins = nativeGetOrigins();
                callback.onReceiveValue(origins);
            } else {
                postMessage(Message.obtain(null, GET_ORIGINS, callback));
            }
        }
    }

    /**
     * Gets the permission state for the specified origin.
     *
     * Callback is a ValueCallback object whose onReceiveValue method will be
     * called asynchronously with the permission state for the origin.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.216 -0500", hash_original_method = "51BD6C2B8F163ED4F443CF424054287F", hash_generated_method = "281E17EF19FE755B4B96522DAD89CE53")
    
public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        if (callback == null) {
            return;
        }
        if (origin == null) {
            callback.onReceiveValue(null);
            return;
        }
        if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
            boolean allowed = nativeGetAllowed(origin);
            callback.onReceiveValue(new Boolean(allowed));
        } else {
            Map values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_ALLOWED, values));
        }
    }

    /**
     * Clears the permission state for the specified origin. This method may be
     * called before the WebKit thread has intialized the message handler.
     * Messages will be queued until this time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.218 -0500", hash_original_method = "EED31E826EEF0A23CBE3E5A871A31746", hash_generated_method = "18FEA60B21C58F31AC99F5F6AEBFE5AE")
    
public void clear(String origin) {
        // Called on the UI thread.
        postMessage(Message.obtain(null, CLEAR, origin));
    }

    /**
     * Allows the specified origin. This method may be called before the WebKit
     * thread has intialized the message handler. Messages will be queued until
     * this time.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.220 -0500", hash_original_method = "35EB967946197F7FF334C62ED26FF684", hash_generated_method = "BBF9608DE336ACFC5BFC5B9C459BBC2C")
    
public void allow(String origin) {
        // Called on the UI thread.
        postMessage(Message.obtain(null, ALLOW, origin));
    }

    /**
     * Clears the permission state for all origins.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.222 -0500", hash_original_method = "0FC7F7395F602EA6BDC8C8831D80FE6E", hash_generated_method = "039E305D22D1CDB49DB823CD35120623")
    
public void clearAll() {
        // Called on the UI thread.
        postMessage(Message.obtain(null, CLEAR_ALL));
    }
}

