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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.732 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.732 -0400", hash_original_field = "D416B92F7674A5F3F49AAD63C150686E", hash_generated_field = "6981106475EB8144679AFAB5874563DD")

    private Handler mUIHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.732 -0400", hash_original_field = "0A6915AA1747354DF9FFB9BA9AA32274", hash_generated_field = "278339A7287A66584FB6CDE30FDBA644")

    private Vector<Message> mQueuedMessages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.732 -0400", hash_original_method = "BCFC7E69B898D596BF2DB066E056C985", hash_generated_method = "BCFC7E69B898D596BF2DB066E056C985")
    public GeolocationPermissions ()
    {
        //Synthesized constructor
    }


    public static GeolocationPermissions getInstance() {
        if (sInstance == null) {
          sInstance = new GeolocationPermissions();
      }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.734 -0400", hash_original_method = "41983E4AD1DCA5E034973FB71B6F64E2", hash_generated_method = "4D9BB8EB311DF1B7EB4BA077BE7E2FBD")
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.734 -0400", hash_original_method = "CE3359AAEF0337F3F574667CF4484B96", hash_generated_method = "1AE7541B0A1D6B2F6EAD13D62267E604")
                @Override
                public void handleMessage(Message msg) {
                    //Begin case RETURN_ORIGINS 
                    {
                        Map values = (Map) msg.obj;
                        Set<String> origins = (Set<String>) values.get(ORIGINS);
                        ValueCallback<Set<String> > callback = (ValueCallback<Set<String> >) values.get(CALLBACK);
                        callback.onReceiveValue(origins);
                    } //End block
                    //End case RETURN_ORIGINS 
                    //Begin case RETURN_ALLOWED 
                    {
                        Map values = (Map) msg.obj;
                        Boolean allowed = (Boolean) values.get(ALLOWED);
                        ValueCallback<Boolean> callback = (ValueCallback<Boolean>) values.get(CALLBACK);
                        callback.onReceiveValue(allowed);
                    } //End block
                    //End case RETURN_ALLOWED 
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.736 -0400", hash_original_method = "7339E0A10658134ACC2105D49EF71E34", hash_generated_method = "801CBDDF11048420C916D3F5E2F32E56")
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.736 -0400", hash_original_method = "CFB8B92EB19D5AA1C7B8DDFE54350D8D", hash_generated_method = "7171592CFC6E88D75213E7A5E9B9C217")
                @Override
                public void handleMessage(Message msg) {
                    //Begin case GET_ORIGINS 
                    {
                        Set origins = nativeGetOrigins();
                        ValueCallback callback = (ValueCallback) msg.obj;
                        Map values = new HashMap<String, Object>();
                        values.put(CALLBACK, callback);
                        values.put(ORIGINS, origins);
                        postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
                    } //End block
                    //End case GET_ORIGINS 
                    //Begin case GET_ALLOWED 
                    {
                        Map values = (Map) msg.obj;
                        String origin = (String) values.get(ORIGIN);
                        ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                        boolean allowed = nativeGetAllowed(origin);
                        Map retValues = new HashMap<String, Object>();
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
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            {
                {
                    boolean var4A9F73C1E93BA1F55C74A9DD5BCAFC7D_64002356 = (!mQueuedMessages.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.736 -0400", hash_original_method = "C8B20551C681C75E8A94C862CADE3192", hash_generated_method = "59AE9F0EF4727469C955EAD958B89D86")
    private synchronized void postMessage(Message msg) {
        {
            {
                mQueuedMessages = new Vector<Message>();
            } //End block
            mQueuedMessages.add(msg);
        } //End block
        {
            mHandler.sendMessage(msg);
        } //End block
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.737 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C8ED0203F18A2FA93DA4BACC33043B55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.737 -0400", hash_original_method = "0C5C32901EC14D47C0B4926D32AA66D4", hash_generated_method = "6BEFD218838BFD1F5192F017755123E8")
    public void getOrigins(ValueCallback<Set<String> > callback) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_702016292 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
                {
                    Set origins = nativeGetOrigins();
                    callback.onReceiveValue(origins);
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
                //Set origins = nativeGetOrigins();
                //callback.onReceiveValue(origins);
            //} else {
                //postMessage(Message.obtain(null, GET_ORIGINS, callback));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.737 -0400", hash_original_method = "51BD6C2B8F163ED4F443CF424054287F", hash_generated_method = "B28CF4B4EFDB41A2542E32607B537454")
    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_424556274 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
            {
                boolean allowed = nativeGetAllowed(origin);
                callback.onReceiveValue(new Boolean(allowed));
            } //End block
            {
                Map values = new HashMap<String, Object>();
                values.put(ORIGIN, origin);
                values.put(CALLBACK, callback);
                postMessage(Message.obtain(null, GET_ALLOWED, values));
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
            //boolean allowed = nativeGetAllowed(origin);
            //callback.onReceiveValue(new Boolean(allowed));
        //} else {
            //Map values = new HashMap<String, Object>();
            //values.put(ORIGIN, origin);
            //values.put(CALLBACK, callback);
            //postMessage(Message.obtain(null, GET_ALLOWED, values));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.738 -0400", hash_original_method = "EED31E826EEF0A23CBE3E5A871A31746", hash_generated_method = "DCB819BCF1402C58441ABB96E6522CBF")
    public void clear(String origin) {
        postMessage(Message.obtain(null, CLEAR, origin));
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, CLEAR, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.738 -0400", hash_original_method = "35EB967946197F7FF334C62ED26FF684", hash_generated_method = "002BB2894198C13E14B5A67D2BE9DABB")
    public void allow(String origin) {
        postMessage(Message.obtain(null, ALLOW, origin));
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, ALLOW, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.738 -0400", hash_original_method = "0FC7F7395F602EA6BDC8C8831D80FE6E", hash_generated_method = "9AE310F1A84B8D911C336132598C553B")
    public void clearAll() {
        postMessage(Message.obtain(null, CLEAR_ALL));
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, CLEAR_ALL));
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

    
    public interface Callback {
        public void invoke(String origin, boolean allow, boolean remember);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "FCE43D70F1242451FA21A1E9AE3D9468", hash_generated_field = "8CF04CB4ECB9AB0455165005BED06537")

    private static final String TAG = "geolocationPermissions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C596865D3F7EFF76AD655659294290BE")

    private static GeolocationPermissions sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "9C040BA34F41682B754D42D9F329AB76", hash_generated_field = "B2B930E0DEAF51B3BFEBDDD5367DF3EF")

    static final int GET_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "7E350EA2BD9BFE704EDEF0D6CE64F125", hash_generated_field = "72FCC8F0DCAC5F61D15EA6F573FF99E1")

    static final int GET_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "92BA6FE9FA77F10EFB9F8C1B6A1C811F", hash_generated_field = "CAE6D8890E07CEF85F431005D11E0878")

    static final int CLEAR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "ECD352AFF6D089A622FCA893A0D9F5C0", hash_generated_field = "998CD419BE1F5CD72638740F7BD9B24D")

    static final int ALLOW = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "691AFD17E2E1022D2AFC38A8DAD95623", hash_generated_field = "FB253837BCC3975DA3E639116C86E8D7")

    static final int CLEAR_ALL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "AD0B913B1913053BBA54CCC9425E3C4A", hash_generated_field = "B83EE419031563F2F60D55C7FFAE2DE6")

    static final int RETURN_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:04.739 -0400", hash_original_field = "72BA86573E030CAFC65ACC1A43D09E1E", hash_generated_field = "C49A555D58D6E46C905036CB1FB4679B")

    private static final String ALLOWED = "allowed";
}

