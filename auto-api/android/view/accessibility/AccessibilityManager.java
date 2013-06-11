package android.view.accessibility;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "AccessibilityManager";
    public static final int STATE_FLAG_ACCESSIBILITY_ENABLED = 0x00000001;
    public static final int STATE_FLAG_TOUCH_EXPLORATION_ENABLED = 0x00000002;
    static final Object sInstanceSync = new Object();
    private static AccessibilityManager sInstance;
    private static final int DO_SET_STATE = 10;
    final IAccessibilityManager mService;
    final Handler mHandler;
    boolean mIsEnabled;
    boolean mIsTouchExplorationEnabled;
    final CopyOnWriteArrayList<AccessibilityStateChangeListener> mAccessibilityStateChangeListeners =
        new CopyOnWriteArrayList<AccessibilityStateChangeListener>();
    final IAccessibilityManagerClient.Stub mClient = new IAccessibilityManagerClient.Stub() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.759 -0400", hash_original_method = "146496CFF3CBEBB0FB17DF578BCDB32A", hash_generated_method = "CA1E9B98B16121A090A19465345DEBB9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void setState(int state) {
            dsTaint.addTaint(state);
            mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
            // ---------- Original Method ----------
            //mHandler.obtainMessage(DO_SET_STATE, state, 0).sendToTarget();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "3479AC0BFEAC12F432B7D77CBEFC979B", hash_generated_method = "DB2EC683E632408AF00A22A05D6ED72D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AccessibilityManager(Context context, IAccessibilityManager service) {
        dsTaint.addTaint(context.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        mHandler = new MyHandler(context.getMainLooper());
        try 
        {
            final int stateFlags;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "39BBFE428528A10289B1FCB8D20D75AC", hash_generated_method = "BC0AD697FB1EA15C7DE9ED02A7611534")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "20CDD5F21F40208C5206265F82FC5959", hash_generated_method = "46AF4F8BBC19E8A77F1F8E4DD04DA857")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "7B07E9E942D9981C7AD5D7B1A6A19F18", hash_generated_method = "18DB3383691421C3F9D92451692CFE4E")
    @DSModeled(DSC.SAFE)
    public boolean isTouchExplorationEnabled() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (mHandler) {
            //return mIsTouchExplorationEnabled;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "D3FF4CE091F652B646DDDB1D1AF726B0", hash_generated_method = "6155B4383A3686083A82FB6630D6B60F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public IAccessibilityManagerClient getClient() {
        IAccessibilityManagerClient varC14DA22045A4F95C19C98C6EA37CA625_959924009 = ((IAccessibilityManagerClient) mClient.asBinder());
        return (IAccessibilityManagerClient)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return (IAccessibilityManagerClient) mClient.asBinder();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "ECD9D39E5E16C36757C6B1E94F274A8A", hash_generated_method = "44DCACD60A15A05BA7A81A83F904CF2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void sendAccessibilityEvent(AccessibilityEvent event) {
        dsTaint.addTaint(event.dsTaint);
        {
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "EF4501E929C209DC672EAD3D7D48095E", hash_generated_method = "354C80C132BC34D8B5409646BD647B0E")
    @DSModeled(DSC.SAFE)
    public void interrupt() {
        {
            throw new IllegalStateException("Accessibility off. Did you forget to check that?");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.760 -0400", hash_original_method = "E2D6992D14607757295701B76C880C8C", hash_generated_method = "DD545B6005EB0481F9DA496DBC93EE79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public List<ServiceInfo> getAccessibilityServiceList() {
        List<AccessibilityServiceInfo> infos;
        infos = getInstalledAccessibilityServiceList();
        List<ServiceInfo> services;
        services = new ArrayList<ServiceInfo>();
        final int infoCount;
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
        List<ServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_570419270 = (Collections.unmodifiableList(services));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "4069133ECADF858B249C4B9AC03C2D2A", hash_generated_method = "F04A57DE44484FFD5773DBA61CE71AD4")
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
        List<AccessibilityServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_1945393962 = (Collections.unmodifiableList(services));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "0B36972F320E6D77C70DA2DE64F6CDA9", hash_generated_method = "91EAAECF45246625E4993BB55670C641")
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
        List<AccessibilityServiceInfo> var3F7062CF7C774A07D56036C1EE92D93C_1512718943 = (Collections.unmodifiableList(services));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "30ACA46B7331464EC3BADA9B88DE998C", hash_generated_method = "2942A18CF25E13F0FD5897093183909D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean addAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean var5A6F0CD479BEDEBB83364E80A3AE764B_39014993 = (mAccessibilityStateChangeListeners.add(listener));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "253F741B79F5A62D71C9725DE0D51542", hash_generated_method = "8C1ED4F58D2ECF89425860AC83B1AF31")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeAccessibilityStateChangeListener(
            AccessibilityStateChangeListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        boolean var24C74D594D11A5BCE73EC77DEA6464EE_682180765 = (mAccessibilityStateChangeListeners.remove(listener));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAccessibilityStateChangeListeners.remove(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "65E953E454D63C10E4D3E41696E8FA2A", hash_generated_method = "4FC72445E10FFE7E74F889130E866EEA")
    @DSModeled(DSC.SAFE)
    private void setState(int stateFlags) {
        dsTaint.addTaint(stateFlags);
        final boolean accessibilityEnabled;
        accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        setAccessibilityState(accessibilityEnabled);
        mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
        // ---------- Original Method ----------
        //final boolean accessibilityEnabled = (stateFlags & STATE_FLAG_ACCESSIBILITY_ENABLED) != 0;
        //setAccessibilityState(accessibilityEnabled);
        //mIsTouchExplorationEnabled = (stateFlags & STATE_FLAG_TOUCH_EXPLORATION_ENABLED) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "CA4E9E314C9F349802EC965B01AC173F", hash_generated_method = "2C8012CC4DF7E1B15C644B9C39784FC9")
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "4BD0E63D4E32757CA8C2FA20BBC17929", hash_generated_method = "478F7DA3E56A580BC2C0A0521EF835AE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void notifyAccessibilityStateChanged() {
        final int listenerCount;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "418C3E6E38CD336BB574D60AEBCE4154", hash_generated_method = "FB83D134E76F25F6A33BAC6DD64C7008")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int addAccessibilityInteractionConnection(IWindow windowToken,
            IAccessibilityInteractionConnection connection) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(connection.dsTaint);
        dsTaint.addTaint(windowToken.dsTaint);
        try 
        {
            int var37F2D9A8621328C65259B1F23C1AB2E7_2087869716 = (mService.addAccessibilityInteractionConnection(windowToken, connection));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.761 -0400", hash_original_method = "E001917337970813CAF9F9A342D31C5B", hash_generated_method = "F5E99792C8597F3FBA22999BF9A711C4")
    @DSModeled(DSC.SAFE)
    public void removeAccessibilityInteractionConnection(IWindow windowToken) {
        //DSFIXME:  CODE0009: Possible callback target function detected
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.762 -0400", hash_original_method = "BE3CF03EB466316B0B79DDBF94893ACA", hash_generated_method = "53981CFFF81D29A0EC64F1AC4E066FBA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         MyHandler(Looper mainLooper) {
            super(mainLooper);
            dsTaint.addTaint(mainLooper.dsTaint);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:04.762 -0400", hash_original_method = "0702CD151ACA01CFBFFCD70D188AF2A1", hash_generated_method = "0E85A7E3A9E76EF23A79CA90B0168121")
        @DSModeled(DSC.SAFE)
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
    
}


