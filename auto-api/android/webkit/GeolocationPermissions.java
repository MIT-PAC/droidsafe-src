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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class GeolocationPermissions {
    private Handler mHandler;
    private Handler mUIHandler;
    private Vector<Message> mQueuedMessages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.282 -0400", hash_original_method = "28C68E30611DA69C4276D7C70F06CC8E", hash_generated_method = "28C68E30611DA69C4276D7C70F06CC8E")
        public GeolocationPermissions ()
    {
    }


        public static GeolocationPermissions getInstance() {
        if (sInstance == null) {
          sInstance = new GeolocationPermissions();
      }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.283 -0400", hash_original_method = "41983E4AD1DCA5E034973FB71B6F64E2", hash_generated_method = "F17ED0979EACE00FD2AA41753B45A550")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.283 -0400", hash_original_method = "CE3359AAEF0337F3F574667CF4484B96", hash_generated_method = "CA56CDDADC5F4F1710C6AE8B13D47214")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case RETURN_ORIGINS 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        Set<String> origins;
                        origins = (Set<String>) values.get(ORIGINS);
                        ValueCallback<Set<String> > callback;
                        callback = (ValueCallback<Set<String> >) values.get(CALLBACK);
                        callback.onReceiveValue(origins);
                    } //End block
                    //End case RETURN_ORIGINS 
                    //Begin case RETURN_ALLOWED 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        Boolean allowed;
                        allowed = (Boolean) values.get(ALLOWED);
                        ValueCallback<Boolean> callback;
                        callback = (ValueCallback<Boolean>) values.get(CALLBACK);
                        callback.onReceiveValue(allowed);
                    } //End block
                    //End case RETURN_ALLOWED 
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.285 -0400", hash_original_method = "7339E0A10658134ACC2105D49EF71E34", hash_generated_method = "2BB4FF981E1BF6613041BED471241A11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.285 -0400", hash_original_method = "CFB8B92EB19D5AA1C7B8DDFE54350D8D", hash_generated_method = "680F4388DF9D6FC89831706CCDD471ED")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                @Override
                public void handleMessage(Message msg) {
                    dsTaint.addTaint(msg.dsTaint);
                    //Begin case GET_ORIGINS 
                    {
                        Set origins;
                        origins = nativeGetOrigins();
                        ValueCallback callback;
                        callback = (ValueCallback) msg.obj;
                        Map values;
                        values = new HashMap<String, Object>();
                        values.put(CALLBACK, callback);
                        values.put(ORIGINS, origins);
                        postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                    } //End block
                    //End case GET_ORIGINS 
                    //Begin case GET_ALLOWED 
                    {
                        Map values;
                        values = (Map) msg.obj;
                        String origin;
                        origin = (String) values.get(ORIGIN);
                        ValueCallback callback;
                        callback = (ValueCallback) values.get(CALLBACK);
                        boolean allowed;
                        allowed = nativeGetAllowed(origin);
                        Map retValues;
                        retValues = new HashMap<String, Object>();
                        retValues.put(CALLBACK, callback);
                        retValues.put(ALLOWED, Boolean.valueOf(allowed));
                        postUIMessage(Message.obtain(null, RETURN_ALLOWED, retValues));
                    } //End block
                    //End case GET_ALLOWED 
                    //Begin case CLEAR 
                    nativeClear((String) msg.obj);
                    //End case CLEAR 
                    //Begin case ALLOW 
                    nativeAllow((String) msg.obj);
                    //End case ALLOW 
                    //Begin case CLEAR_ALL 
                    nativeClearAll();
                    //End case CLEAR_ALL 
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            {
                {
                    boolean var4A9F73C1E93BA1F55C74A9DD5BCAFC7D_1540817463 = (!mQueuedMessages.isEmpty());
                    {
                        mHandler.sendMessage(mQueuedMessages.remove(0));
                    } //End block
                } //End collapsed parenthetic
                mQueuedMessages = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.285 -0400", hash_original_method = "C8B20551C681C75E8A94C862CADE3192", hash_generated_method = "E56F64444AD5778EFDD15004E3CB78B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private synchronized void postMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        {
            {
                mQueuedMessages = new Vector<Message>();
            } //End block
            mQueuedMessages.add(msg);
        } //End block
        {
            mHandler.sendMessage(msg);
        } //End block
        // ---------- Original Method ----------
        //if (mHandler == null) {
            //if (mQueuedMessages == null) {
                //mQueuedMessages = new Vector<Message>();
            //}
            //mQueuedMessages.add(msg);
        //} else {
            //mHandler.sendMessage(msg);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.286 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "D3A1BC112B6E8C3022B55DEFC2DD77BD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.286 -0400", hash_original_method = "0C5C32901EC14D47C0B4926D32AA66D4", hash_generated_method = "A006B74BB2E1EC6FE5F5691A38A77BB6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getOrigins(ValueCallback<Set<String> > callback) {
        dsTaint.addTaint(callback.dsTaint);
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_584730501 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    Set origins;
                    origins = nativeGetOrigins();
                    callback.onReceiveValue(origins);
                } //End block
                {
                    postMessage(Message.obtain(null, GET_ORIGINS, callback));
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (callback != null) {
            //if (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName())) {
                //Set origins = nativeGetOrigins();
                //callback.onReceiveValue(origins);
            //} else {
                //postMessage(Message.obtain(null, GET_ORIGINS, callback));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.286 -0400", hash_original_method = "51BD6C2B8F163ED4F443CF424054287F", hash_generated_method = "C2F776083F3A3B602C17C2D0263EAD82")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        dsTaint.addTaint(callback.dsTaint);
        dsTaint.addTaint(origin);
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_973973375 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                boolean allowed;
                allowed = nativeGetAllowed(origin);
                callback.onReceiveValue(new Boolean(allowed));
            } //End block
            {
                Map values;
                values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_ALLOWED, values));
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
            //boolean allowed = nativeGetAllowed(origin);
            //callback.onReceiveValue(new Boolean(allowed));
        //} else {
            //Map values = new HashMap<String, Object>();
            //values.put(ORIGIN, origin);
            //values.put(CALLBACK, callback);
            //postMessage(Message.obtain(null, GET_ALLOWED, values));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.286 -0400", hash_original_method = "EED31E826EEF0A23CBE3E5A871A31746", hash_generated_method = "0AD8158EB59FD6F33C95271A8080C30F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clear(String origin) {
        dsTaint.addTaint(origin);
        postMessage(Message.obtain(null, CLEAR, origin));
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, CLEAR, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.287 -0400", hash_original_method = "35EB967946197F7FF334C62ED26FF684", hash_generated_method = "1E693DA6D9A932DB3A2D1E33190E9D05")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void allow(String origin) {
        dsTaint.addTaint(origin);
        postMessage(Message.obtain(null, ALLOW, origin));
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, ALLOW, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:03.287 -0400", hash_original_method = "0FC7F7395F602EA6BDC8C8831D80FE6E", hash_generated_method = "9AE310F1A84B8D911C336132598C553B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void clearAll() {
        postMessage(Message.obtain(null, CLEAR_ALL));
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, CLEAR_ALL));
    }

    
        private static Set nativeGetOrigins() {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        private static boolean nativeGetAllowed(String origin) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        private static void nativeClear(String origin) {
    }

    
        private static void nativeAllow(String origin) {
    }

    
        private static void nativeClearAll() {
    }

    
    public interface Callback {
        public void invoke(String origin, boolean allow, boolean remember);
    }
    
    private static final String TAG = "geolocationPermissions";
    private static GeolocationPermissions sInstance;
    static final int GET_ORIGINS = 0;
    static final int GET_ALLOWED = 1;
    static final int CLEAR = 2;
    static final int ALLOW = 3;
    static final int CLEAR_ALL = 4;
    static final int RETURN_ORIGINS = 0;
    static final int RETURN_ALLOWED = 1;
    private static final String ORIGINS = "origins";
    private static final String ORIGIN = "origin";
    private static final String CALLBACK = "callback";
    private static final String ALLOWED = "allowed";
}

