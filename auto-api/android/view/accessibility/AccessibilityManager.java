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
    IAccessibilityManager mService;
    Handler mHandler;
    boolean mIsEnabled;
    boolean mIsTouchExplorationEnabled;
    CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners =
        new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.824 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "A44E0357C23CA226656C12CC6B2C5A4A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setState(int state) {
            dsTaint.addTaint(state);
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            // ---------- Original Method ----------
            //mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.825 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "A25A01B213723CD0E8C296D4621C967D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityManager(Context context, IAccessibilityManager service) {
        dsTaint.addTaint(service.dsTaint);
        dsTaint.addTaint(context.dsTaint);
        mHandler = new MyHandler(context.getMainLooper());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.826 -0400", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "42D5644A041134E8383ED3D771965269")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.826 -0400", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "EACA7D762B995048E64DDEC72A0CC590")
    @DSModeled(DSC.SAFE)
    public boolean isTouchExplorationEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsTouchExplorationEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.827 -0400", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "46B065745F31E90D05FB0E322062CD0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IAccessibilityManagerClient getClient() {
        IAccessibilityManagerClient varC14DA22045A4F95C19C98C6EA37CA625_287298777 = ((IAccessibilityManagerClient) mClient.asBinder());
        return (IAccessibilityManagerClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (IAccessibilityManagerClient) mClient.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.827 -0400", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "ADFAE22BA955CAC40BE837AB70317BC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.827 -0400", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "3D284480B69B1A51ABF5F61A5BB5D1E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.827 -0400", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "553664678C14E54CCF3DE8D59BBB31E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
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
        List<ServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_909000391 = (Collections.unmodifiableList(services));
        return (List<ServiceInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.828 -0400", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "10E9DB1A98DCBA2BDD559344B354B91E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList() {
        List<AccessibilityServiceInfo> services;
        services = null;
        try 
        {
            services = mService.getInstalledAccessibilityServiceList();
        } //End block
        catch (RemoteException re)
        { }
        List<AccessibilityServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_211615161 = (Collections.unmodifiableList(services));
        return (List<AccessibilityServiceInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.828 -0400", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "8433BA32005FAE90DD465D002B54316A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(
            int feedbackTypeFlags) {
        dsTaint.addTaint(feedbackTypeFlags);
        List<AccessibilityServiceInfo> services;
        services = null;
        try 
        {
            services = mService.getEnabledAccessibilityServiceList(feedbackTypeFlags);
        } //End block
        catch (RemoteException re)
        { }
        List<AccessibilityServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_1056218667 = (Collections.unmodifiableList(services));
        return (List<AccessibilityServiceInfo>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.828 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "C7A059AB5F4B062EE21AE8D04117EE85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean var5A6F0CD479BEDEBB83364E80A3AE764B_1033163461 = (mAccessibilityStateChangeListeners.add(listener));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.828 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "2406466613F032F56E0DC16EBF57BB0E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean var24C74D594D11A5BCE73EC77DEA6464EE_465073426 = (mAccessibilityStateChangeListeners.remove(listener));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.829 -0400", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "37CA335C144385126731815B9EEA3BFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setState(int stateFlags) {
        dsTaint.addTaint(stateFlags);
        boolean accessibilityEnabled;
        accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
        // ---------- Original Method ----------
        //final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        //setAccessibilityState(accessibilityEnabled);
        //mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.829 -0400", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "41D294E7F1F88E2CA36B8404FBD923AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setAccessibilityState(boolean isEnabled) {
        dsTaint.addTaint(isEnabled);
        {
            {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.829 -0400", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "BBD0FCC609001079D0441C0D00ACD185")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.829 -0400", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "FA112D943FD427069DDAB2E19915C1A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(windowToken.dsTaint);
        try 
        {
            int var37F2D9A8621328C65259B1F23C1AB2E7_427273176 = (mService.addAccessibilityInteractionConnection(windowToken, connection));
        } //End block
        catch (RemoteException re)
        { }
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //try {
            //return mService.addAccessibilityInteractionConnection(windowToken, connection);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while adding an accessibility interaction connection. ", re);
        //}
        //return View.NO_ID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.829 -0400", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "ABC129A329FF875EBEEB3F0F32FA39CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        dsTaint.addTaint(windowToken.dsTaint);
        try 
        {
            mService.removeAccessibilityInteractionConnection(windowToken);
        } //End block
        catch (RemoteException re)
        { }
        // ---------- Original Method ----------
        //try {
            //mService.removeAccessibilityInteractionConnection(windowToken);
        //} catch (RemoteException re) {
            //Log.e(LOG_TAG, "Error while removing an accessibility interaction connection. ", re);
        //}
    }

    
    class MyHandler extends Handler {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.830 -0400", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "596E26594A5E3B24DA484414A29F02EE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper mainLooper) {
            super(mainLooper);
            dsTaint.addTaint(mainLooper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:01.830 -0400", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "FDD6C87BF48032263800116E01BDCB2D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void handleMessage(Message message) {
            dsTaint.addTaint(message.dsTaint);
            //Begin case DO_SET_STATE 
            setState(message.arg1);
            //End case DO_SET_STATE 
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
    
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityManager";
    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
    static final Object sInstanceSync = new Object();
    private static AccessibilityManager sInstance;
    private static final int DO_SET_STATE = 10;
}

