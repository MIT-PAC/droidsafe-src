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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.737 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.737 -0400", hash_original_field = "D416B92F7674A5F3F49AAD63C150686E", hash_generated_field = "6981106475EB8144679AFAB5874563DD")

    private Handler mUIHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.737 -0400", hash_original_field = "0A6915AA1747354DF9FFB9BA9AA32274", hash_generated_field = "278339A7287A66584FB6CDE30FDBA644")

    private Vector<Message> mQueuedMessages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.737 -0400", hash_original_method = "BCFC7E69B898D596BF2DB066E056C985", hash_generated_method = "BCFC7E69B898D596BF2DB066E056C985")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.750 -0400", hash_original_method = "41983E4AD1DCA5E034973FB71B6F64E2", hash_generated_method = "7829263F9732B49EF8891B087FF82AF4")
    public void createUIHandler() {
        {
            mUIHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.739 -0400", hash_original_method = "CE3359AAEF0337F3F574667CF4484B96", hash_generated_method = "6E50B6BD0FCCFDFD10CE67A82F4381C4")
                @Override
                public void handleMessage(Message msg) {
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
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.765 -0400", hash_original_method = "7339E0A10658134ACC2105D49EF71E34", hash_generated_method = "70B5AFCB1C0315F9385DEB9A191A53BB")
    public synchronized void createHandler() {
        {
            mHandler = new Handler() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.752 -0400", hash_original_method = "CFB8B92EB19D5AA1C7B8DDFE54350D8D", hash_generated_method = "6B6704F62845C469786D97A1E45AE8EA")
                @Override
                public void handleMessage(Message msg) {
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
                    addTaint(msg.getTaint());
                    // ---------- Original Method ----------
                    // Original Method Too Long, Refer to Original Implementation
                }
};
            {
                {
                    boolean var4A9F73C1E93BA1F55C74A9DD5BCAFC7D_1147821093 = (!mQueuedMessages.isEmpty());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.766 -0400", hash_original_method = "C8B20551C681C75E8A94C862CADE3192", hash_generated_method = "59AE9F0EF4727469C955EAD958B89D86")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.766 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "C8ED0203F18A2FA93DA4BACC33043B55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.766 -0400", hash_original_method = "0C5C32901EC14D47C0B4926D32AA66D4", hash_generated_method = "481019C1EA287C750642B609FE411C04")
    public void getOrigins(ValueCallback<Set<String> > callback) {
        {
            {
                boolean var1D1539BC3F985EF6F27916DFF0F70DCB_1249414671 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.767 -0400", hash_original_method = "51BD6C2B8F163ED4F443CF424054287F", hash_generated_method = "04CDCCCEDF4634457539D1A6F51059C8")
    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        {
            callback.onReceiveValue(null);
        } //End block
        {
            boolean var1F2F1B674DC9185D7C933584E9557068_983840704 = (WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.767 -0400", hash_original_method = "EED31E826EEF0A23CBE3E5A871A31746", hash_generated_method = "DCB819BCF1402C58441ABB96E6522CBF")
    public void clear(String origin) {
        postMessage(Message.obtain(null, CLEAR, origin));
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, CLEAR, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.779 -0400", hash_original_method = "35EB967946197F7FF334C62ED26FF684", hash_generated_method = "002BB2894198C13E14B5A67D2BE9DABB")
    public void allow(String origin) {
        postMessage(Message.obtain(null, ALLOW, origin));
        addTaint(origin.getTaint());
        // ---------- Original Method ----------
        //postMessage(Message.obtain(null, ALLOW, origin));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.780 -0400", hash_original_method = "0FC7F7395F602EA6BDC8C8831D80FE6E", hash_generated_method = "9AE310F1A84B8D911C336132598C553B")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "FCE43D70F1242451FA21A1E9AE3D9468", hash_generated_field = "895D5F8CB2F35A502D5A99ED00705332")

    private static String TAG = "geolocationPermissions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C596865D3F7EFF76AD655659294290BE")

    private static GeolocationPermissions sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "9C040BA34F41682B754D42D9F329AB76", hash_generated_field = "CDA27881CAAD7AE21B0114CEB6E40BF9")

    static int GET_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "7E350EA2BD9BFE704EDEF0D6CE64F125", hash_generated_field = "C2D40F414A44CA10FE9991D04CC066AF")

    static int GET_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "92BA6FE9FA77F10EFB9F8C1B6A1C811F", hash_generated_field = "1D6917AF15F32F752F3682CFEDCD9CDE")

    static int CLEAR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "ECD352AFF6D089A622FCA893A0D9F5C0", hash_generated_field = "D99997D17B712757DC88A2FB3D59D5BD")

    static int ALLOW = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "691AFD17E2E1022D2AFC38A8DAD95623", hash_generated_field = "BBB7D18F9459FE17EDC95800931C60B0")

    static int CLEAR_ALL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "9F16B070B67AF569D45922C684F737AD")

    static int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "AD0B913B1913053BBA54CCC9425E3C4A", hash_generated_field = "B374164C6E110385DEAECC1CDE79A66C")

    static int RETURN_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "39B1371A7C105E08D03EF6A82E1C888B")

    private static String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "0A6ED265D5D88B00F83A73502B56BD55")

    private static String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "FC961204076FD50E79C3F05778D9F44E")

    private static String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:00.781 -0400", hash_original_field = "72BA86573E030CAFC65ACC1A43D09E1E", hash_generated_field = "40D2DF545E40E9D8E0DC7769478D4CF9")

    private static String ALLOWED = "allowed";
}

