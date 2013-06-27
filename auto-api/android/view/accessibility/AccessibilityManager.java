package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.IWindow;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class AccessibilityManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.381 -0400", hash_original_field = "D96EB21FC1A83B484FAE33A12B05D9CB", hash_generated_field = "08912AD6B563D3650D4698A9BA0A6C64")

    IAccessibilityManager mService;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.381 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "A163099B522120C606A3CA562F90E927")

    Handler mHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.381 -0400", hash_original_field = "1D09076915F0C1B535F8F7A6899A12CD", hash_generated_field = "B3AD351453F3622D7B00E4C698290AE5")

    boolean mIsEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.381 -0400", hash_original_field = "CC9FEDC5C3C4EEA9B9546C6E636B6B06", hash_generated_field = "1A7CE13BB5E9D8ACA2C85DA567CD9FE9")

    boolean mIsTouchExplorationEnabled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.381 -0400", hash_original_field = "252DF980FDC54FEB3852D04E9F87DD5A", hash_generated_field = "515B5BC58FF2988B66C3FE1217453DF2")

    CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners = new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.396 -0400", hash_original_field = "376001492716029F3EB64333857C8E7A", hash_generated_field = "E683F51326D5CB153EA1788BA4C64144")

    IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.396 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "48E4850B433B838533EE453914DCF418")
        public void setState(int state) {
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            addTaint(state);
            // ---------- Original Method ----------
            //mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.397 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "72E333C7C8704699428FFF6466EC7161")
    public  AccessibilityManager(Context context, IAccessibilityManager service) {
        mHandler = new MyHandler(context.getMainLooper());
        mService = service;
        try 
        {
            int stateFlags;
            stateFlags = mService.addClient(mClient);
            setState(stateFlags);
        } //End block
        catch (RemoteException re)
        { }
        // ---------- Original Method ----------
        //mHandler = new MyHandler(context.getMainLooper());
        //mService = service;
        //try {
            //final int stateFlags = mService.addClient(mClient);
            //setState(stateFlags);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "AccessibilityManagerService is dead", re);
        //}
    }

    
        public static AccessibilityManager getInstance(Context context) {
        synchronized (sInstanceSync) {
            if (sInstance == null) {
                IBinder iBinder = ServiceManager.getService(Context.ACCESSIBILITY_SERVICE);
                IAccessibilityManager service = IAccessibilityManager.Stub.asInterface(iBinder);
                sInstance = new AccessibilityManager(context, service);
            }
        }
        return sInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.397 -0400", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "4F201E7197A0052045239E9BD713B0A1")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1591185093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1591185093;
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.398 -0400", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "74ECC6003406648C96EF5186AF36DD2C")
    public boolean isTouchExplorationEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1923889303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1923889303;
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsTouchExplorationEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.398 -0400", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "C88703DB325624E4DE4D2B1FB6F72DD7")
    public IAccessibilityManagerClient getClient() {
        IAccessibilityManagerClient varB4EAC82CA7396A68D541C85D26508E83_138527891 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_138527891 = (IAccessibilityManagerClient) mClient.asBinder();
        varB4EAC82CA7396A68D541C85D26508E83_138527891.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138527891;
        // ---------- Original Method ----------
        //return (IAccessibilityManagerClient) mClient.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.414 -0400", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "E3C3B9250454AF09707C4E4FF05CF36E")
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        } //End block
        boolean doRecycle;
        doRecycle = false;
        try 
        {
            event.setEventTime(SystemClock.uptimeMillis());
            long identityToken;
            identityToken = Binder.clearCallingIdentity();
            doRecycle = mService.sendAccessibilityEvent(event);
            Binder.restoreCallingIdentity(identityToken);
        } //End block
        catch (RemoteException re)
        { }
        finally 
        {
            {
                event.recycle();
            } //End block
        } //End block
        addTaint(event.getTaint());
        // ---------- Original Method ----------
        //if (!mIsEnabled) {
            //throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        //}
        //boolean doRecycle = false;
        //try {
            //event.setEventTime(SystemClock.uptimeMillis());
            //long identityToken = Binder.clearCallingIdentity();
            //doRecycle = mService.sendAccessibilityEvent(event);
            //Binder.restoreCallingIdentity(identityToken);
            //if (DEBUG) {
                //Log.i(LOG_TAG, event + " sent");
            //}
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error during sending " + event + " ", re);
        //} finally {
            //if (doRecycle) {
                //event.recycle();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.415 -0400", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "3D284480B69B1A51ABF5F61A5BB5D1E2")
    public void interrupt() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        } //End block
        try 
        {
            mService.interrupt();
        } //End block
        catch (RemoteException re)
        { }
        // ---------- Original Method ----------
        //if (!mIsEnabled) {
            //throw new IllegalStateException("Accessibility off. Did you forget to check that?");
        //}
        //try {
            //mService.interrupt();
            //if (DEBUG) {
                //Log.i(LOG_TAG, "Requested interrupt from all services");
            //}
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while requesting interrupt from all services. ", re);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.416 -0400", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "97D4D1DD52552999F590D775D111F6BC")
    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<ServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1754822272 = null; //Variable for return #1
        List<AccessibilityServiceInfo> infos;
        infos = getInstalledAccessibilityServiceList();
        List<ServiceInfo> services;
        services = new ArrayList<ServiceInfo>();
        int infoCount;
        infoCount = infos.size();
        {
            int i;
            i = 0;
            {
                AccessibilityServiceInfo info;
                info = infos.get(i);
                services.add(info.getResolveInfo().serviceInfo);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1754822272 = Collections.unmodifiableList(services);
        varB4EAC82CA7396A68D541C85D26508E83_1754822272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1754822272;
        // ---------- Original Method ----------
        //List<AccessibilityServiceInfo> infos = getInstalledAccessibilityServiceList();
        //List<ServiceInfo> services = new ArrayList<ServiceInfo>();
        //final int infoCount = infos.size();
        //for (int i = 0; i < infoCount; i++) {
            //AccessibilityServiceInfo info = infos.get(i);
            //services.add(info.getResolveInfo().serviceInfo);
        //}
        //return Collections.unmodifiableList(services);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.421 -0400", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "9457C5F28E2132ED41DDD7B4393BBEC0")
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_1982809052 = null; //Variable for return #1
        List<AccessibilityServiceInfo> services;
        services = null;
        try 
        {
            services = mService.getInstalledAccessibilityServiceList();
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_1982809052 = Collections.unmodifiableList(services);
        varB4EAC82CA7396A68D541C85D26508E83_1982809052.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1982809052;
        // ---------- Original Method ----------
        //List<AccessibilityServiceInfo> services = null;
        //try {
            //services = mService.getInstalledAccessibilityServiceList();
            //if (DEBUG) {
                //Log.i(LOG_TAG, "Installed AccessibilityServices " + services);
            //}
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", re);
        //}
        //return Collections.unmodifiableList(services);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.430 -0400", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "617BC31F0FF35A224DCB09AA9C8964E1")
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            int feedbackTypeFlags) {
        List<AccessibilityServiceInfo> varB4EAC82CA7396A68D541C85D26508E83_492414482 = null; //Variable for return #1
        List<AccessibilityServiceInfo> services;
        services = null;
        try 
        {
            services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
        } //End block
        catch (RemoteException re)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_492414482 = Collections.unmodifiableList(services);
        addTaint(feedbackTypeFlags);
        varB4EAC82CA7396A68D541C85D26508E83_492414482.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_492414482;
        // ---------- Original Method ----------
        //List<AccessibilityServiceInfo> services = null;
        //try {
            //services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
            //if (DEBUG) {
                //Log.i(LOG_TAG, "Installed AccessibilityServices " + services);
            //}
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while obtaining the installed AccessibilityServices. ", re);
        //}
        //return Collections.unmodifiableList(services);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.432 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "39CB54950A4688262F7B34D72A777C1D")
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        boolean var5A6F0CD479BEDEBB83364E80A3AE764B_971778935 = (mAccessibilityStateChangeListeners.add(listener));
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_316461532 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_316461532;
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.445 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "FC69C74BDA3D8F9892EA858EADC23836")
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        boolean var24C74D594D11A5BCE73EC77DEA6464EE_150505295 = (mAccessibilityStateChangeListeners.remove(listener));
        addTaint(listener.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_217381733 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_217381733;
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.446 -0400", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "23125DEEB58825A0773E656B8E6B6D09")
    private void setState(int stateFlags) {
        boolean accessibilityEnabled;
        accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
        // ---------- Original Method ----------
        //final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        //setAccessibilityState(accessibilityEnabled);
        //mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.446 -0400", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "3719C41A172A25E4503937B4BDEC2AD2")
    private void setAccessibilityState(boolean isEnabled) {
        {
            {
                mIsEnabled = isEnabled;
                notifyAccessibilityStateChanged();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //if (isEnabled != mIsEnabled) {
                //mIsEnabled = isEnabled;
                //notifyAccessibilityStateChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.465 -0400", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "BBD0FCC609001079D0441C0D00ACD185")
    private void notifyAccessibilityStateChanged() {
        int listenerCount;
        listenerCount = mAccessibilityStateChangeListeners.size();
        {
            int i;
            i = 0;
            {
                mAccessibilityStateChangeListeners.get(i).onAccessibilityStateChanged(mIsEnabled);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //final int listenerCount = mAccessibilityStateChangeListeners.size();
        //for (int i = 0; i < listenerCount; i++) {
            //mAccessibilityStateChangeListeners.get(i).onAccessibilityStateChanged(mIsEnabled);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.489 -0400", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "45337084C4611618E0A85E084745ED5D")
    public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        try 
        {
            int var37F2D9A8621328C65259B1F23C1AB2E7_391329665 = (mService.addAccessibilityInteractionConnection(windowToken, connection));
        } //End block
        catch (RemoteException re)
        { }
        addTaint(windowToken.getTaint());
        addTaint(connection.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670601851 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_670601851;
        // ---------- Original Method ----------
        //try {
            //return mService.addAccessibilityInteractionConnection(windowToken, connection);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while adding an accessibility interaction connection. ", re);
        //}
        //return View.NO_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.490 -0400", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "1386E3C3F10A10CC37C3027C01EF7B94")
    public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        try 
        {
            mService.removeAccessibilityInteractionConnection(windowToken);
        } //End block
        catch (RemoteException re)
        { }
        addTaint(windowToken.getTaint());
        // ---------- Original Method ----------
        //try {
            //mService.removeAccessibilityInteractionConnection(windowToken);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while removing an accessibility interaction connection. ", re);
        //}
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.491 -0400", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "9F59FB64EB9EF78D31A1B6F20DE629FC")
          MyHandler(Looper mainLooper) {
            super(mainLooper);
            addTaint(mainLooper.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "373230158FA4C73B8339CEDC434F5FA7")
        @Override
        public void handleMessage(Message message) {
            //Begin case DO_SET_STATE 
            setState(message.arg1);
            //End case DO_SET_STATE 
            addTaint(message.getTaint());
            // ---------- Original Method ----------
            //switch (message.what) {
                //case DO_SET_STATE :
                    //setState(message.arg1);
                    //return;
                //default :
                    //Log.w(LOG_TAG, "Unknown message type: " + message.what);
            //}
        }

        
    }


    
    public interface AccessibilityStateChangeListener {

        
        public void onAccessibilityStateChanged(boolean enabled);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "4D24D329B0EF5D2D82578F930D7403E7", hash_generated_field = "3A7801F426FB7E6E9A7A038BDC52F7F2")

    private static String LOG_TAG = "AccessibilityManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "85D1072A753C43092378F05B5DF305A6", hash_generated_field = "D5243A58F1614AE46E8FCF29704BEB96")

    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "D43BF5D0C31189C57D1C555D72E0BB9B", hash_generated_field = "EAA50D440451540D7B157284465828FF")

    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "CD6BA09F49DD0FBBBD875FEDA92BCBA8", hash_generated_field = "B1C92CD59B48DA59D6BB6DD8FF2DB1E9")

    static Object sInstanceSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "06E23A628CBDEAB09E91C69789BB1974", hash_generated_field = "5EF143443483818ABB8A01E6EB178491")

    private static AccessibilityManager sInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:54.514 -0400", hash_original_field = "93C67DEE8D16722A1A8FF5FADBEF1717", hash_generated_field = "4CB2C624D6386AA51C9DFD2008463648")

    private static int DO_SET_STATE = 10;
}

