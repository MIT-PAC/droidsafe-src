package android.webkit;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public final class GeolocationPermissions {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.200 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "03E47BA0CE42772601F0A13D178B12B5")

    private Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.200 -0400", hash_original_field = "D416B92F7674A5F3F49AAD63C150686E", hash_generated_field = "6981106475EB8144679AFAB5874563DD")

    private Handler mUIHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.200 -0400", hash_original_field = "0A6915AA1747354DF9FFB9BA9AA32274", hash_generated_field = "278339A7287A66584FB6CDE30FDBA644")

    private Vector<Message> mQueuedMessages;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.200 -0400", hash_original_method = "BCFC7E69B898D596BF2DB066E056C985", hash_generated_method = "BCFC7E69B898D596BF2DB066E056C985")
    public GeolocationPermissions ()
    {
        
    }


        public static GeolocationPermissions getInstance() {
        if (sInstance == null) {
          sInstance = new GeolocationPermissions();
      }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.201 -0400", hash_original_method = "41983E4AD1DCA5E034973FB71B6F64E2", hash_generated_method = "12A5D279683871C8F202D753C4F7861D")
    public void createUIHandler() {
    if(mUIHandler == null)        
        {
            mUIHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.201 -0400", hash_original_method = "CE3359AAEF0337F3F574667CF4484B96", hash_generated_method = "BC27FF790ED1B4F2CB58758DD3BAC3CA")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case RETURN_ORIGINS:
            {
                Map values = (Map) msg.obj;
                Set<String> origins = (Set<String>) values.get(ORIGINS);
                ValueCallback<Set<String> > callback = (ValueCallback<Set<String> >) values.get(CALLBACK);
                callback.onReceiveValue(origins);
            } 
            break;
            case RETURN_ALLOWED:
            {
                Map values = (Map) msg.obj;
                Boolean allowed = (Boolean) values.get(ALLOWED);
                ValueCallback<Boolean> callback = (ValueCallback<Boolean>) values.get(CALLBACK);
                callback.onReceiveValue(allowed);
            } 
            break;
}
            
            
        }
};
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.203 -0400", hash_original_method = "7339E0A10658134ACC2105D49EF71E34", hash_generated_method = "B8CD4D363887E28FB16A0A47C06A3253")
    public synchronized void createHandler() {
    if(mHandler == null)        
        {
            mHandler = new Handler() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.202 -0400", hash_original_method = "CFB8B92EB19D5AA1C7B8DDFE54350D8D", hash_generated_method = "7185F1EDDB4FC6F8C4B89AEC1FFD4036")
        @Override
        public void handleMessage(Message msg) {
            addTaint(msg.getTaint());
switch(msg.what){
            case GET_ORIGINS:
            {
                Set origins = nativeGetOrigins();
                ValueCallback callback = (ValueCallback) msg.obj;
                Map values = new HashMap<String, Object>();
                values.put(CALLBACK, callback);
                values.put(ORIGINS, origins);
                postUIMessage(Message.obtain(null, RETURN_ORIGINS, values));
            } 
            break;
            case GET_ALLOWED:
            {
                Map values = (Map) msg.obj;
                String origin = (String) values.get(ORIGIN);
                ValueCallback callback = (ValueCallback) values.get(CALLBACK);
                boolean allowed = nativeGetAllowed(origin);
                Map retValues = new HashMap<String, Object>();
                retValues.put(CALLBACK, callback);
                retValues.put(ALLOWED, Boolean.valueOf(allowed));
                postUIMessage(Message.obtain(null, RETURN_ALLOWED, retValues));
            } 
            break;
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
    if(mQueuedMessages != null)            
            {
                while
(!mQueuedMessages.isEmpty())                
                {
                    mHandler.sendMessage(mQueuedMessages.remove(0));
                } 
                mQueuedMessages = null;
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.203 -0400", hash_original_method = "C8B20551C681C75E8A94C862CADE3192", hash_generated_method = "0656529F923403AB7BC08ED6EF1CA9DC")
    private synchronized void postMessage(Message msg) {
        addTaint(msg.getTaint());
    if(mHandler == null)        
        {
    if(mQueuedMessages == null)            
            {
                mQueuedMessages = new Vector<Message>();
            } 
            mQueuedMessages.add(msg);
        } 
        else
        {
            mHandler.sendMessage(msg);
        } 
        
        
            
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.204 -0400", hash_original_method = "B15FFE1BDDB388A76F495C309FEFF3DA", hash_generated_method = "1C7FA8D0FDD7047080CA6C74911CEC8A")
    private void postUIMessage(Message msg) {
        addTaint(msg.getTaint());
    if(mUIHandler != null)        
        {
            mUIHandler.sendMessage(msg);
        } 
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.204 -0400", hash_original_method = "0C5C32901EC14D47C0B4926D32AA66D4", hash_generated_method = "290F5202D4830906B11E7113D4B7F34E")
    public void getOrigins(ValueCallback<Set<String> > callback) {
        addTaint(callback.getTaint());
    if(callback != null)        
        {
    if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))            
            {
                Set origins = nativeGetOrigins();
                callback.onReceiveValue(origins);
            } 
            else
            {
                postMessage(Message.obtain(null, GET_ORIGINS, callback));
            } 
        } 
        
        
            
                
                
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.205 -0400", hash_original_method = "51BD6C2B8F163ED4F443CF424054287F", hash_generated_method = "A60E4AE7B52A3A755C5C31569CA7BAC5")
    public void getAllowed(String origin, ValueCallback<Boolean> callback) {
        addTaint(callback.getTaint());
        addTaint(origin.getTaint());
    if(callback == null)        
        {
            return;
        } 
    if(origin == null)        
        {
            callback.onReceiveValue(null);
            return;
        } 
    if(WebViewCore.THREAD_NAME.equals(Thread.currentThread().getName()))        
        {
            boolean allowed = nativeGetAllowed(origin);
            callback.onReceiveValue(new Boolean(allowed));
        } 
        else
        {
            Map values = new HashMap<String, Object>();
            values.put(ORIGIN, origin);
            values.put(CALLBACK, callback);
            postMessage(Message.obtain(null, GET_ALLOWED, values));
        } 
        
        
            
        
        
            
            
        
        
            
            
        
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.205 -0400", hash_original_method = "EED31E826EEF0A23CBE3E5A871A31746", hash_generated_method = "22AFFBBD90FD6BE8A4E2341CB46BDECD")
    public void clear(String origin) {
        addTaint(origin.getTaint());
        postMessage(Message.obtain(null, CLEAR, origin));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.205 -0400", hash_original_method = "35EB967946197F7FF334C62ED26FF684", hash_generated_method = "B4FB7F61649539F4543F623D2C67A43F")
    public void allow(String origin) {
        addTaint(origin.getTaint());
        postMessage(Message.obtain(null, ALLOW, origin));
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.205 -0400", hash_original_method = "0FC7F7395F602EA6BDC8C8831D80FE6E", hash_generated_method = "9AE310F1A84B8D911C336132598C553B")
    public void clearAll() {
        postMessage(Message.obtain(null, CLEAR_ALL));
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static Set nativeGetOrigins() {
        	Set s = new HashSet<>();
        	return s;
    }

    
    @DSModeled(DSC.SAFE)
    private static boolean nativeGetAllowed(String origin) {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1246562142 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1246562142;
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClear(String origin) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeAllow(String origin) {
    }

    
    @DSModeled(DSC.SAFE)
    private static void nativeClearAll() {
    }

    
    public interface Callback {
        public void invoke(String origin, boolean allow, boolean remember);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.206 -0400", hash_original_field = "FCE43D70F1242451FA21A1E9AE3D9468", hash_generated_field = "8CF04CB4ECB9AB0455165005BED06537")

    private static final String TAG = "geolocationPermissions";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "C596865D3F7EFF76AD655659294290BE")

    private static GeolocationPermissions sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "9C040BA34F41682B754D42D9F329AB76", hash_generated_field = "B2B930E0DEAF51B3BFEBDDD5367DF3EF")

    static final int GET_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "7E350EA2BD9BFE704EDEF0D6CE64F125", hash_generated_field = "72FCC8F0DCAC5F61D15EA6F573FF99E1")

    static final int GET_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "92BA6FE9FA77F10EFB9F8C1B6A1C811F", hash_generated_field = "CAE6D8890E07CEF85F431005D11E0878")

    static final int CLEAR = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "ECD352AFF6D089A622FCA893A0D9F5C0", hash_generated_field = "998CD419BE1F5CD72638740F7BD9B24D")

    static final int ALLOW = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "691AFD17E2E1022D2AFC38A8DAD95623", hash_generated_field = "FB253837BCC3975DA3E639116C86E8D7")

    static final int CLEAR_ALL = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "7C8537374A482211B56AA6AB46729FB5", hash_generated_field = "A162E9E9F34864677116B609C17EAC70")

    static final int RETURN_ORIGINS = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "AD0B913B1913053BBA54CCC9425E3C4A", hash_generated_field = "B83EE419031563F2F60D55C7FFAE2DE6")

    static final int RETURN_ALLOWED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "65478524DA05A858576A231D6F74BE9F", hash_generated_field = "A0F0A22ECAE7202D88A4D3804E189136")

    private static final String ORIGINS = "origins";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "63CE338685E17E1E1CF5D74A539A8A90", hash_generated_field = "A2B83EB03A0EE6C64FAB04BF77831BDE")

    private static final String ORIGIN = "origin";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "DA9191A8F336B18486DDF571C706A387", hash_generated_field = "AF8428C7524CA5A6292A586912FC7C29")

    private static final String CALLBACK = "callback";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:58.207 -0400", hash_original_field = "72BA86573E030CAFC65ACC1A43D09E1E", hash_generated_field = "C49A555D58D6E46C905036CB1FB4679B")

    private static final String ALLOWED = "allowed";
}

